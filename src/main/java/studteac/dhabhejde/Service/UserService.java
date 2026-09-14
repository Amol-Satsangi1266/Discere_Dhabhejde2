package studteac.dhabhejde.Service;


import org.springframework.stereotype.Service;
import studteac.dhabhejde.dto.UserRequestDTO;
import studteac.dhabhejde.dto.UserResponseDTO;
import studteac.dhabhejde.Model.User;
import studteac.dhabhejde.Repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create User
    public UserResponseDTO createUser(UserRequestDTO request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setProfileImage(request.getProfileImage());

        User savedUser = userRepository.save(user);

        return convertToResponseDTO(savedUser);
    }

    // Get User By ID
    public UserResponseDTO getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return convertToResponseDTO(user);
    }

    // Get All Users
    public List<UserResponseDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .toList();
    }

    // Convert Entity → Response DTO
    private UserResponseDTO convertToResponseDTO(User user) {

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getProfileImage(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}

