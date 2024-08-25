package dev.vimukthi.sentura_interview.controller;
import dev.vimukthi.sentura_interview.dto.UserDTO;
import dev.vimukthi.sentura_interview.service.WeavyClient;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final WeavyClient weavyClient;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/check")
    public String checkTest() {
        return "User Check Test";
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
        try {
            String response = weavyClient.getWeavyAllUserData("https://a06dd3674d1440a781890212e1079a7e.weavy.io/api/users", "wys_LqU4ONwDc8khDBApHoliNG69x70iC21MeSSO");
            logger.info("Fetching all users");
            logger.info("Response: " + response);
            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Unable to fetch users.\nMore Details\n" + exception);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(weavyClient.getWeavyUserData("https://a06dd3674d1440a781890212e1079a7e.weavy.io/api/users/"+ id, "wys_LqU4ONwDc8khDBApHoliNG69x70iC21MeSSO"));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Unable to fetch users.\nMore Details\n" + exception);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(weavyClient.postWeavyData("https://a06dd3674d1440a781890212e1079a7e.weavy.io/api/users", "wys_LqU4ONwDc8khDBApHoliNG69x70iC21MeSSO", userDTO.toString()));
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

    @PostMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        try {
            return ResponseEntity.ok(weavyClient.deleteWeavyData("https://a06dd3674d1440a781890212e1079a7e.weavy.io/api/users/"+id+"/trash", "wys_LqU4ONwDc8khDBApHoliNG69x70iC21MeSSO"));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Unable to fetch users.\nMore Details\n" + exception);
        }
    }

}

