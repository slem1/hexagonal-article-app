package fr.sle.article;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import fr.sle.article.common.domain.Generated;

import java.util.Properties;

@SpringBootApplication
@Generated(reason = "Not testing logs")
public class JhipsterSampleApplicationApp {

  private static final Logger log = LoggerFactory.getLogger(JhipsterSampleApplicationApp.class);

  public static void main(String[] args) {
    final SpringApplication springApplication = new SpringApplication(JhipsterSampleApplicationApp.class);
    Properties properties = new Properties();
    properties.setProperty("enable.kafka", "false");
    springApplication.setDefaultProperties(properties);
    Environment env = springApplication.run(args).getEnvironment();


    if (log.isInfoEnabled()) {
      log.info(ApplicationStartupTraces.of(env));
    }
  }
}
