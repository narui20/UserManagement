package comm.usermanagement.controller;

import comm.usermanagement.bean.AuthenticationResponse;
import comm.usermanagement.bean.User;
import comm.usermanagement.service.LoginService;
import comm.usermanagement.utility.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usermanagement")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody User user) {
        final String jwt = jwtUtil.generateToken(loginService.loginUser(user.getEmail(), user.getPassword()));
        return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(jwt), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return new ResponseEntity<User>(loginService.register(user), HttpStatus.OK);
    }

}
