package org.bidding.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Overall App Configuration
 *
 */
@Configuration
@ComponentScan({ "org.bidding" })
@Import({ WebConfig.class, PersistenceConfig.class, SecurityConfig.class, AspectConfig.class })
public class AppConfig {
	
	public AppConfig() {
		super();
	}
}
