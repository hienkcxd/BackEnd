package com.example.BachEnd_Ses4.api.user.system;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.BachEnd_Ses4.DTO.SystemDTO.UserDetailDTO;
import com.example.BachEnd_Ses4.converter.ConverterToken;
import com.example.BachEnd_Ses4.converter.SystemConverter.UserDetailConverter;
import com.example.BachEnd_Ses4.model.System.Role;
import com.example.BachEnd_Ses4.model.System.User;
import com.example.BachEnd_Ses4.service.system.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/")
@Slf4j
public class UserResource {
    @Autowired
    private UserService userService;
    @Autowired
    private ConverterToken converterToken;
    @Autowired
    private UserDetailConverter converter;
    private final PasswordEncoder passwordEncoder;

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }

        return userName;
    }
    @GetMapping("/admin/list-user")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/login-token")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Map<Integer,String>> checkLogin(HttpServletRequest request){
        Map<Integer,String> status = new HashMap<Integer,String>();
        status.put(1, "2689367B205C16CE32ED4200942B8B8B1E262DFC70D9BC9FBC77C49699A4F1DF");
        return ResponseEntity.ok(status);
    }

    @GetMapping("/user-detail")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<User> getUsersByAdminName(HttpServletRequest request){
        String username = converterToken.convertTokenToUserName(request);
        log.info("user resource convertTokenToRole: " + converterToken.convertTokenToRole(request));
        return ResponseEntity.ok().body(userService.getUser(username));
    }


    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<User> getUsersByUserName(HttpServletRequest request){
        String username = converterToken.convertTokenToUserName(request);
        return ResponseEntity.ok().body(userService.getUser(username));
    }

    @GetMapping("/user/user-detail")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public UserDetailDTO getUsersByAdminNameDTO(HttpServletRequest request){
        String username = converterToken.convertTokenToUserName(request);
        log.info("user resource convertTokenToRole: " + converterToken.convertTokenToRole(request));
        return converter.entityToDTO(userService.getUser(getPrincipal()));
    }

    @PostMapping("/user/save")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/change-password")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public User changePassword(HttpServletRequest request){
        String username = converterToken.convertTokenToUserName(request);
        User user = userService.getUser(username);
        String newPassword =  request.getParameter("newPassword");
        log.info("new password from client is "+newPassword);
        if(!newPassword.equals("") || newPassword == null){
            user.setId(user.getId());
            user.setPassword(newPassword);
            userService.saveUser(user);
            return user;
        }else {
            return (User) ResponseEntity.badRequest();
        }
    }



//    @PostMapping("/role/save")
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
//    public ResponseEntity<Role> saveUser(@RequestBody Role role){
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
//        return ResponseEntity.created(uri).body(userService.saveRole(role));
//    }
//    @PostMapping("/role/add-Role-User")
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
//    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
//        userService.addRoleToUser(form.getUserName(), form.getRolename());
//        return ResponseEntity.ok().build();
//    }

    @GetMapping("/token/refresh")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null){
            try {
                String refresh_token = authorizationHeader;
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = userService.getUser(username);
                String access_token = JWT.create()
                        .withSubject(user.getUserName())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 7+24*60*60*1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> respone_json = new HashMap<>();
                respone_json.put("access_token", access_token);
                respone_json.put("refresh_token", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), respone_json);
            }catch (Exception exception){
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        }else {
            throw new RuntimeException("Refresh token is missing");
        }
    }

}
@Data
class RoleToUserForm{
    private String userName;
    private String rolename;
}
