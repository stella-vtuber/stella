package quest.gekko.stella.memory.base;

import quest.gekko.stella.api.Platform;

import java.util.List;
import java.util.UUID;

public interface MemoryService {
    void rememberUser(final UUID userId, Platform platform, final String message);
    void rememberGeneral(final Platform platform, final String message);

    List<String> getUserMemory(final UUID userId, final Platform platform);
    List<String> getGeneralMemory(final Platform platform);
}
