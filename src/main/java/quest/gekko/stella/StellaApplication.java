package quest.gekko.stella;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import quest.gekko.stella.ai.AiService;
import quest.gekko.stella.loader.PluginLoader;

import java.io.File;

@SpringBootApplication
public class StellaApplication implements CommandLineRunner {
    private final AiService aiService;
    private final PluginLoader pluginLoader;

    public  StellaApplication(final AiService aiService, final PluginLoader pluginLoader) {
        this.aiService = aiService;
        this.pluginLoader = pluginLoader;
    }

    public static void main(String[] args) {
        SpringApplication.run(StellaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        final File pluginsFolder = new File("plugins");

        if (!pluginsFolder.exists() && !pluginsFolder.mkdirs()) {
            System.out.println("Failed to create plugin folder:  " + pluginsFolder.getAbsolutePath());
        }

        pluginLoader.loadPlugins(pluginsFolder, aiService);

        final int pluginCount = pluginLoader.getStellaPlugins().size();
        System.out.printf("Stella has successfully loaded %d plugins.%n", pluginCount);
    }
}
