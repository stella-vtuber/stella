package quest.gekko.stella.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {
    private static ApplicationContext APPLICATION_CONTEXT;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        APPLICATION_CONTEXT = applicationContext;
    }

    public static <T> T getBean(Class<T> requiredType) {
        return APPLICATION_CONTEXT.getBean(requiredType);
    }
}