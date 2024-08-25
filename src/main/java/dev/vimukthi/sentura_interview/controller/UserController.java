package dev.vimukthi.sentura_interview.controller;
import dev.vimukthi.sentura_interview.dto.UserDTO;
import dev.vimukthi.sentura_interview.service.WeavyClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final WeavyClient weavyClient;

    @GetMapping(value = "/check")
    public String checkTest() {
        return "User Check Test";
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        try {
            return ResponseEntity.ok(weavyClient.getWeavyAllUserData("https://a06dd3674d1440a781890212e1079a7e.weavy.io", "wys_LqU4ONwDc8khDBApHoliNG69x70iC21MeSSO"));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Unable to fetch users.\nMore Details\n" + exception);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(weavyClient.putWeavyData("https://a06dd3674d1440a781890212e1079a7e.weavy.io/api/users/"+ id, "wys_LqU4ONwDc8khDBApHoliNG69x70iC21MeSSO", userDTO.toString()));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Unable to fetch users.\nMore Details\n" + exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        try {
            return ResponseEntity.ok(weavyClient.deleteWeavyData("https://a06dd3674d1440a781890212e1079a7e.weavy.io/api/users/"+id +"/trash", "wys_LqU4ONwDc8khDBApHoliNG69x70iC21MeSSO"));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Unable to fetch users.\nMore Details\n" + exception);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(weavyClient.getWeavyUserData("https://a06dd3674d1440a781890212e1079a7e.weavy.io/api/users/"+ id, "wys_LqU4ONwDc8khDBApHoliNG69x70iC21MeSSO"));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Unable to fetch users.\nMore Details\n" + exception);
        }
    }

}

