
package senex.config;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import senex.core.Senex;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "shell")
public class ShellConfig {
	private boolean consoleOutputEnabled;

	public boolean isConsoleOutputEnabled() {
		return consoleOutputEnabled;
	}

	public void setConsoleOutputEnabled(boolean consoleOutputEnabled) {
		this.consoleOutputEnabled = consoleOutputEnabled;
	}
	
	@PostConstruct
	private void init(){
		Senex.setShellConfig(this);
	}
	
}
