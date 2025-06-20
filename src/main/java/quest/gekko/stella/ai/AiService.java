package quest.gekko.stella.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiService {
    private final ChatClient chatClient;

    public AiService(final ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String handleMessage(final String prompt) {
        return chatClient.prompt(prompt).call().content();
    }
}
