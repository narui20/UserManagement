package comm.usermanagement.controller;

import comm.usermanagement.bean.User;
import comm.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<List<User>>(service.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/deleteuser/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
        return new ResponseEntity<Integer>(service.deleteUser(id), HttpStatus.OK);
    }

    @PutMapping("/updateuser")
    public ResponseEntity<Integer> updateUser(@RequestBody User user) {
        return new ResponseEntity<Integer>(service.updateUser(user), HttpStatus.OK);
    }
}
