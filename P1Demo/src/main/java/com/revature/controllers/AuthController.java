package com.revature.controllers;

import com.revature.models.DTOs.LoginDTO;
import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.models.User;
import com.revature.utils.JwtTokenUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class AuthController {

    //No service!
    private JwtTokenUtil jwtTokenUtil;
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(JwtTokenUtil jwtTokenUtil, AuthenticationManager authenticationManager) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
    }

    //NOTE: our HTTP Session is coming in via parameters this time (to be sent to the controller)
    //The session in the parameter is not the same as the static session above
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO lDTO){

        //Attempt to log in - NOTE no direct calls of the Service. All Spring Security now!
        try{

            //Our AuthenticationManager is now in charge of checking username/password
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(lDTO.getUsername(), lDTO.getPassword())
            );

            //Build up the user based on the validation above (an Exception is thrown credentials are invalid)
            User user = (User) auth.getPrincipal();

            //Finally, generate a JWT for the user to use in subsequent requests
            String accessToken = jwtTokenUtil.generateAccessToken(user);

            //In a real app, we'd just send the JWT (since it has all the user info)
            //But for clarity, we're sending back an OutgoingUserDTO, which has raw fields AND the JWT.
            OutgoingUserDTO outUser =
                    new OutgoingUserDTO(user.getUserId(), user.getUsername(), user.getRole(), accessToken);

            return ResponseEntity.ok(outUser);

        } catch(Exception e){
            e.printStackTrace(); //show the error message in the console
            return ResponseEntity.status(401).body("Invalid Credentials");
        }

    }

    //Exception Handler (stole this from the UserController)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e){
        //Return a 400 (BAD REQUEST) status code with the exception message
        return ResponseEntity.status(400).body(e.getMessage());
    }

}
