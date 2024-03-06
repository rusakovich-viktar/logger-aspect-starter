package by.clevertec.aspectlogger.config;

import by.clevertec.aspectlogger.logger.LoggingAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация для аспекта логирования.
 */
@Configuration
@ConditionalOnProperty(prefix = "exception.handler", name = "enabled", havingValue = "true", matchIfMissing = true)
public class LoggingAspectAutoConfiguration {

    /**
     * Создает экземпляр аспекта логирования.
     *
     * @return экземпляр LoggingAspect
     */
    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

}
