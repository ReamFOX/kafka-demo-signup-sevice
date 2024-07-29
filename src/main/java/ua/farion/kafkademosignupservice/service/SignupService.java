package ua.farion.kafkademosignupservice.service;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ua.farion.kafkademosignupservice.dto.PlayerDto;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public UUID signup(PlayerDto playerDto) {
        UUID playerId = UUID.randomUUID();
        kafkaTemplate.send("signup-topic", playerId.toString(), String.valueOf(playerDto));
        return playerId;
    }
}
