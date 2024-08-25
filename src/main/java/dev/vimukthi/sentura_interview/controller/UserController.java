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
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final WeavyClient weavyClient;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String url = "https://a06dd3674d1440a781890212e1079a7e.weavy.io/api/users";
    private static final String key = "wys_LqU4ONwDc8khDBApHoliNG69x70iC21MeSSO";

    @GetMapping("/check")
    public String checkTest() {
        return "User Check Test";
    }

    @GetMapping
    public ResponseEntity<?> getAlLUsers() {
        try {
            String response = weavyClient.getWeavyAllUserData(url, key);
            logger.info("Fetching all users");
            logger.info("Response: " + response);
            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Unable to fetch users.\nMore Details\n" + exception);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(weavyClient.getWeavyUserData(url+ id, key));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Unable to fetch users.\nMore Details\n" + exception);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(weavyClient.postWeavyData(url, key, userDTO.toString()));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Unable to fetch users.\nMore Details\n" + exception);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(weavyClient.putWeavyData(url+ id, key, userDTO.toString()));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Unable to fetch users.\nMore Details\n" + exception);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        try {
            return ResponseEntity.ok(weavyClient.deleteWeavyData(url+id+"/trash", key));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Unable to fetch users.\nMore Details\n" + exception);
        }
    }

}

