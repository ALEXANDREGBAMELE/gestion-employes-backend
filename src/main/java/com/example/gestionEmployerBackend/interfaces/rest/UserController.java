package com.example.gestionEmployerBackend.interfaces.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    /**
     * @Autowired
     *            private CustomUserService customUserService;
     * 
     * @Autowired
     *            private CustomUserMapper customUserMapper;
     * 
     *            // GET all users
     *            @GetMapping("/getAll")
     *            public ResponseEntity<List<CustomUser>> getAllUsers() {
     *            // Appel au service pour récupérer la liste des entités CustomUser
     *            List<CustomUser> users = customUserService.findAll();
     * 
     *            // Renvoyer la liste des DTOs dans la réponse
     *            return ResponseEntity.ok(users);
     *            }
     * 
     * 
     *            // GET a specific user by ID
     *            @GetMapping("getByID/{id}")
     *            public ResponseEntity<CustomUserDto> getUserById(@PathVariable
     *            Long id) {
     *            Optional<CustomUser> user = customUserService.findById(id);
     *            // Mapper l'entité CustomUser en CustomUserDto
     *            CustomUserDto userDto = customUserMapper.toDto(user);
     *            return ResponseEntity.ok(userDto);
     *            }
     * 
     *            // POST to create a new user
     *            @PostMapping("register")
     *            public ResponseEntity<CustomUserDto> createUser(@RequestBody
     *            CustomUserDto userDto) {
     *            // Mapper le DTO CustomUserDto en entité CustomUser
     *            CustomUser user = customUserMapper.toEntity(userDto);
     *            CustomUser createdUser = customUserService.saveUser(user);
     *            // Retourner le DTO du user créé
     *            CustomUserDto createdUserDto =
     *            customUserMapper.toDto(Optional.ofNullable(createdUser));
     *            return ResponseEntity.ok(createdUserDto);
     *            }
     * 
     *            // PUT to update an existing user
     *            @PutMapping("/{id}")
     *            public ResponseEntity<CustomUserDto> updateUser(@PathVariable Long
     *            id, @RequestBody CustomUserDto userDto) {
     *            CustomUser user = customUserMapper.toEntity(userDto);
     *            CustomUser updatedUser = customUserService.update(id, user);
     *            CustomUserDto updatedUserDto =
     *            customUserMapper.toDto(Optional.ofNullable(updatedUser));
     *            return ResponseEntity.ok(updatedUserDto);
     *            }
     * 
     *            // DELETE a user
     *            @DeleteMapping("/{id}")
     *            public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
     *            customUserService.delete(id);
     *            return ResponseEntity.noContent().build();
     *            }
     **/
}
