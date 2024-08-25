package dev.vimukthi.sentura_interview.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    @Null
    private String uId;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email address format")
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @NotBlank(message = "Given name cannot be blank")
    private String givenName;
    @NotBlank(message = "Middle name cannot be blank")
    private String middleName;
    @NotBlank(message = "Family name cannot be blank")
    private String familyName;
    @NotBlank(message = "Full name cannot be blank")
    private String name;
    @NotBlank(message = "Nick name cannot be blank")
    private String nickName;
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid phone number format")
    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;
    @Null
    private String profilePic;

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert UserDTO to JSON string", e);
        }
    }
}
