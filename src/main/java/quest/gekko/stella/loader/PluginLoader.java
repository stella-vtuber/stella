package quest.gekko.stella.loader;

import lombok.Getter;
import org.springframework.stereotype.Component;
import quest.gekko.stella.ai.AiService;
import quest.gekko.stella.api.StellaPlugin;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

@Getter
@Component
public class PluginLoader {
    private final List<StellaPlugin> stellaPlugins = new ArrayList<>();

    public void loadPlugins(final File pluginsDir, final AiService aiService) {
        final File[] jars = pluginsDir.listFiles((dir, name) -> name.endsWith(".jar"));

        if (jars == null) {
            return;
        }

        for (final File jar : jars) {
            try {
                final URL[] urls = {jar.toURI().toURL()};
                final URLClassLoader classLoader = new URLClassLoader(urls, this.getClass().getClassLoader());
                final ServiceLoader<StellaPlugin> serviceLoader = ServiceLoader.load(StellaPlugin.class, classLoader);

                for (final StellaPlugin plugin : serviceLoader) {
                    plugin.onLoad(aiService);
                    stellaPlugins.add(plugin);
                    System.out.println("Loaded plugin: " + plugin.getClass().getName());
                }
            }  catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }
}
