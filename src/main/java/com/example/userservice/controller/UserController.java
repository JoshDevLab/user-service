package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.jpa.UserEntity;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.Greeting;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class UserController {

    private final Environment env;
    private final Greeting greeting;
    private final UserService userService;

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in User Service on PORT %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/welcome")
    public String welcome() {
//        return env.getProperty("greeting.message");
        return greeting.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = mapper.map(user, UserDto.class);

        ResponseUser responseUser = mapper.map(userService.createUser(userDto), ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> findByIdUser(@PathVariable String userId) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto user = userService.getUserById(userId);
        ResponseUser responseUser = mapper.map(user, ResponseUser.class);
        return ResponseEntity.status(HttpStatus.OK).body(responseUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> findAllUsers() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<UserEntity> userList = userService.getUserByAll();
        List<ResponseUser> responseUserList = userList.stream().map(user -> mapper.map(user, ResponseUser.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(responseUserList);
    }
}
