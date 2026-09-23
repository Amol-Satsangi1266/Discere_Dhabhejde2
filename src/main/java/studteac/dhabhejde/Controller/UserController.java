package studteac.dhabhejde.Controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import studteac.dhabhejde.DTO.UserRequestDTO;
import studteac.dhabhejde.DTO.UserResponseDTO;
import studteac.dhabhejde.Service.UserService;

import java.util.List;

@Tag(name = "User APIs", description = "APIs for managing Students and Teachers")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create User
    @Operation(
            summary = "Create a User",
            description = "To create a User and giving unique identity to it"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(
            @Valid @RequestBody UserRequestDTO request) {

        return userService.createUser(request);
    }

    // Get User By ID
    @Operation(
            summary = "Get student by ID",
            description = "Fetches a student using the student's unique ID"
    )
    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    // Get All Users
    @Operation(
            summary = "Get students all",
            description = "Fetches all Students"
    )
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {

        return userService.getAllUsers();
    }
}

