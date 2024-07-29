package ua.farion.kafkademosignupservice.controller;

import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.farion.kafkademosignupservice.dto.PlayerDto;
import ua.farion.kafkademosignupservice.service.SignupService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignupController {
    private final SignupService signupService;

    @PostMapping
    public ResponseEntity<?> signup(@RequestBody PlayerDto playerDto) {
        try {
            UUID playerId = signupService.signup(playerDto);
            return ResponseEntity.ok().body(Map.of("status", "OK", "uuid", playerId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("status", "KO"));
        }
    }
}
