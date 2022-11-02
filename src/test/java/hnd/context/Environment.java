package hnd.context;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource(value = "classpath:config.properties")
public class Environment {
    @Value("${uat.url}")
    private String uatUrl;
    @Value("${prod.url}")
    private String prodUrl;
    @Value("${staging.url}")
    private String stagingUrl;
    @Value("${timeout}")
    private Double timeout;

}