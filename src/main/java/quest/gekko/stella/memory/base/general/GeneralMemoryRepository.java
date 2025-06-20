package quest.gekko.stella.memory.base.general;

import org.springframework.data.jpa.repository.JpaRepository;
import quest.gekko.stella.api.Platform;

import java.util.List;

public interface GeneralMemoryRepository extends JpaRepository<GeneralMemory, Long> {
    List<GeneralMemory> findTop10ByPlatformOrderByTimestampDesc(final Platform platform);
}