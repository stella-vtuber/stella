package quest.gekko.stella.memory.base.user;

import org.springframework.data.jpa.repository.JpaRepository;
import quest.gekko.stella.api.Platform;

import java.util.List;
import java.util.UUID;

public interface UserMemoryRepository extends JpaRepository<UserMemory, Long> {
    List<UserMemory> findTop20ByUserIdAndPlatformOrderByTimestampDesc(final UUID userId, final Platform platform);
}
