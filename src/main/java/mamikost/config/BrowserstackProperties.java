package mamikost.config;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ConfigurationProperties(prefix = "browserstack")
@PropertySource(value = "classpath:browserstack.yml", factory = YamlPropertySourceFactory.class)
@ToString
public class BrowserstackProperties {
    private @Setter@Getter String userName;
    private @Setter@Getter String apiKey;
    private @Setter@Getter String url;
    private @Setter@Getter String appiumHub;
}

