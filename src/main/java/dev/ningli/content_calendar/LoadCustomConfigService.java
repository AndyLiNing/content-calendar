package dev.ningli.content_calendar;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "main.module")
public class LoadCustomConfigService {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
// Note look at "GsonAutoConfiguration"  to get how does
// @EnableConfigurationProperties

// @ConditionalOnClass => will auto config if the dependency classes present on class path

// @ConditionalOnMissBean() => will auto config if the missing the bean in IOC container