package quest.gekko.stella.prompt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import quest.gekko.stella.memory.base.MemoryService;
import quest.gekko.stella.api.Platform;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PromptBuilder {
    private final MemoryService memoryService;

    public String buildPrompt(final String incomingMessage, final UUID userId, final Platform platform) {
        final StringBuilder builder = new StringBuilder();
        builder.append("Incoming message: ").append(incomingMessage).append("\n\n");

        final List<String> generalMemories = memoryService.getGeneralMemory(platform);

        if (!generalMemories.isEmpty()) {
            builder.append("Recent public context:\n");
            generalMemories.forEach(message -> builder.append("- ").append(message).append("\n"));
            builder.append("\n");
        }

        final List<String> userMemories = memoryService.getUserMemory(userId, platform);

        if (!userMemories.isEmpty()) {
            builder.append("User-specific memory:\n");
            userMemories.forEach(message -> builder.append("- ").append(message).append("\n"));
            builder.append("\n");
        }

        return builder.toString();
    }
}