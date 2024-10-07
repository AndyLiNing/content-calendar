package dev.ningli.content_calendar.AutoConfigExample;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// GSON simple example
// @Configuration(proxyBeanMethods = false)  => Very important, main different between @AutoConfiguration and @Configuration

@AutoConfiguration
//@ConditionalOnClass
//@ConditionalOnBean
public class AutoConfigExample {

    @Bean
    PrintBanner printBanner () {
        return new PrintBanner();
    }
}
