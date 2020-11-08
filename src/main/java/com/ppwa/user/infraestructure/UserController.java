package com.ppwa.user.infraestructure;

import com.ppwa.user.application.command.CreateUserCommand;
import com.ppwa.user.application.command.DeleteUserCommand;
import com.ppwa.user.application.command.UpdateUserCommand;
import com.ppwa.user.application.use_case.CreateUser;
import com.ppwa.user.application.use_case.DeleteUser;
import com.ppwa.user.application.use_case.ReadUser;
import com.ppwa.user.application.use_case.UpdateUser;
import com.ppwa.user.domain.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public final class UserController {

    private final CreateUser createUser;
    private final ReadUser readUser;
    private final UpdateUser updateUser;
    private final DeleteUser deleteUser;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserController(CreateUser createUser, ReadUser readUser, UpdateUser updateUser, DeleteUser deleteUser,
                          BCryptPasswordEncoder passwordEncoder) {
        this.createUser = createUser;
        this.readUser = readUser;
        this.updateUser = updateUser;
        this.deleteUser = deleteUser;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public void createUser(@RequestBody CreateUserCommand createUserCommand) {
        this.createUser.execute(createUserCommand, passwordEncoder.encode(createUserCommand.getPassword()));
    }

    @GetMapping("/{username}")
    public User readUser(@PathVariable String username) {
        return this.readUser.execute(username);
    }

    @PutMapping
    public void updateUser(@RequestBody UpdateUserCommand updateUserCommand) {
        this.updateUser.execute(updateUserCommand, passwordEncoder.encode(updateUserCommand.getPassword()));
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username, @RequestBody DeleteUserCommand deleteUserCommand) {
        this.deleteUser.execute(username, deleteUserCommand);
    }
}
