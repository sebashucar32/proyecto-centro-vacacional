package co.com.agencia.rabbitmq.subscriptor;

import co.com.agencia.model.stroll.Stroll;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class EventSubscriptionConfig {
    @Bean
    @Primary
    public HandlerRegistry registerEvent(EventsHandler events) {
        return HandlerRegistry.register()
            .listenEvent("register.newstroll", events::handleRegisterStroll, Stroll.class);
    }
}