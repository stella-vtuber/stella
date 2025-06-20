package quest.gekko.stella.api;

import quest.gekko.stella.ai.AiService;

public interface StellaPlugin {

    String getName();

    void onLoad(final AiService aiService);

    String onMessage(final String message);

}
