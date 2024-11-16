package dev.ningli.content_calendar.Config.profiles;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("DEV")
@PropertySource("file:${SOURCES_DIR}/dev/${spring.application.name}/application.properties")
@PropertySource("file:${SOURCES_DIR}/dev/common.properties")
@PropertySource("file:${SOURCES_DIR}/dev/datasource.properties")
@PropertySource("file:${SOURCES_DIR}/dev/liquibase.properties")
@PropertySource("file:${SOURCES_DIR}/dev/log.properties")
@PropertySource("file:${SOURCES_DIR}/dev/email.properties")
@PropertySource("file:${SOURCES_DIR}/dev/oauth2.properties")
public class DevProfileConfig { }
