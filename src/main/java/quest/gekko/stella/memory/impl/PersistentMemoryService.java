package quest.gekko.stella.memory.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import quest.gekko.stella.memory.base.MemoryService;
import quest.gekko.stella.api.Platform;
import quest.gekko.stella.memory.base.general.GeneralMemory;
import quest.gekko.stella.memory.base.general.GeneralMemoryRepository;
import quest.gekko.stella.memory.base.user.UserMemory;
import quest.gekko.stella.memory.base.user.UserMemoryRepository;

import java.time.Instant;
import java.util.*;

@Service
public class PersistentMemoryService implements MemoryService {
    private final UserMemoryRepository userMemoryRepository;
    private final GeneralMemoryRepository generalMemoryRepository;

    public PersistentMemoryService(final UserMemoryRepository userMemoryRepository, final GeneralMemoryRepository generalMemoryRepository) {
        this.userMemoryRepository = userMemoryRepository;
        this.generalMemoryRepository = generalMemoryRepository;
    }

    @Override
    public void rememberUser(final UUID userId, final Platform platform, final String message) {
        userMemoryRepository.save(new UserMemory(null, userId, platform, message, Instant.now()));
    }

    @Override
    public void rememberGeneral(final Platform platform, final String message) {
        generalMemoryRepository.save(new GeneralMemory(null, platform, message, Instant.now()));
    }

    @Override
    @Cacheable(value = "userMemory", key = "#userId + '_' + #platform")
    public List<String> getUserMemory(final UUID userId, final Platform platform) {
        return userMemoryRepository.findTop20ByUserIdAndPlatformOrderByTimestampDesc(userId, platform)
                .stream()
                .map(UserMemory::getMessage)
                .toList();
    }

    @Override
    @Cacheable(value = "generalMemory", key = "#platform")
    public List<String> getGeneralMemory(final Platform platform) {
        return generalMemoryRepository.findTop10ByPlatformOrderByTimestampDesc(platform)
                .stream()
                .map(GeneralMemory::getMessage)
                .toList();
    }
}