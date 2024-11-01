package com.example.gestionEmployerBackend.interfaces.mapper;

// import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public interface CustomUserMapper {

    /**
     * // Mapper de l'entité vers le DTO
     * public CustomUserDto toDto(CustomUser user) {
     * if (user == null) {
     * return null;
     * }
     * 
     * CustomUserDto userDTO = new CustomUserDto();
     * userDTO.setId(user.getId());
     * userDTO.setUsername(user.getUsername());
     * userDTO.setEmail(user.getEmail());
     * userDTO.setRoles(user.getRoles());
     * return userDTO;
     * }
     * 
     * // Mapper du DTO vers l'entité
     * public CustomUser toEntity(CustomUserDto userDTO) {
     * if (userDTO == null) {
     * return null;
     * }
     * 
     * CustomUser user = new CustomUser();
     * user.setId(userDTO.getId());
     * user.setUsername(userDTO.getUsername());
     * user.setEmail(userDTO.getEmail());
     * user.setRoles(userDTO.getRoles());
     * return user;
     * }
     */

    // CustomUserMapper INSTANCE = Mappers.getMapper(CustomUserMapper.class);

    // // Mapper de l'entité vers le DTO
    // CustomUserDto toDto(Optional<CustomUser> user);

    // // Mapper du DTO vers l'entité
    // CustomUser toEntity(CustomUserDto userDTO);
}
