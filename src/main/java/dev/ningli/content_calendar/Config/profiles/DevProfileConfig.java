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



// Users/andy/.m2/repository/org/springframework/spring-jcl/6.2.0-M6/spring-jcl-6.2.0-M6.jar
//        dev.ningli.content_calendar.Application
//        spring.profiles.active=DEV


// /Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home/bin/java -javaagent:
// /Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=52136:
// /Applications/IntelliJ IDEA CE.app/Contents/bin
// -Dfile.encoding=UTF-8
// -classpath /Users/andy/Work/Java/content-calendar/target/classes:
// ......
//  Users/andy/.m2/repository/org/springframework/spring-jcl/6.2.0-M6/spring-jcl-6.2.0-M6.jar
//  dev.ningli.content_calendar.Application
// --spring.profiles.active=DEV
