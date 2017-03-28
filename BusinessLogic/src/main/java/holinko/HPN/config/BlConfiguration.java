package holinko.HPN.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Pavel
 */
@Configuration
@ComponentScan(value = "holinko.HPN.managers")
@ImportResource(value = "classpath:app-context-annotation.xml")
public class BlConfiguration
{
}
