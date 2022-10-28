package sagar.springproject.msscbeerservice.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@ConfigurationProperties(prefix = "sfg.jmsconfig", ignoreUnknownFields = false)
public class JmsConfig {
    public void setJmsQueue(String jmsQueue) {
        this.jmsQueue = jmsQueue;
    }

    public String getJmsQueue() {
        return jmsQueue;
    }

    private String jmsQueue;

    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();
        mappingJackson2MessageConverter.setTargetType(MessageType.TEXT);
        mappingJackson2MessageConverter.setTypeIdPropertyName("_type");
        return mappingJackson2MessageConverter;
    }
}
