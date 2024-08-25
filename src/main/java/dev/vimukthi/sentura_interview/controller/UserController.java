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

}
