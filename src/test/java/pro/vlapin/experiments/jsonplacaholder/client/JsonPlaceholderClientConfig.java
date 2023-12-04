package pro.vlapin.experiments.jsonplacaholder.client;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
@EnableAutoConfiguration
public class JsonPlaceholderClientConfig {
}
