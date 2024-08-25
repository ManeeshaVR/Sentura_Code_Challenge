package dev.vimukthi.sentura_interview.controller;
import dev.vimukthi.sentura_interview.service.WeavyClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final WeavyClient weavyClient;

    @GetMapping(value = "/check")
    public String checkTest() {
        return "User Check Test";
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
        try {
            return ResponseEntity.ok(weavyClient.getWeavyAllUserData("https://a06dd3674d1440a781890212e1079a7e.weavy.io", "wys_LqU4ONwDc8khDBApHoliNG69x70iC21MeSSO"));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Unable to fetch customers.\nMore Details\n" + exception);
        }
    }

}
