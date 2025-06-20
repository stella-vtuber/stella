package quest.gekko.stella.memory.base.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import quest.gekko.stella.api.Platform;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMemory {
    @Id
    @GeneratedValue
    private Long id;

    private UUID userId;

    @Enumerated(EnumType.STRING)
    private Platform platform;
    private String message;

    private Instant timestamp;
}
