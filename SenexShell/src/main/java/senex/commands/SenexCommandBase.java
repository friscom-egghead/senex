package senex.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

public abstract class SenexCommandBase {
	@Autowired
	private Environment env;
	
	@Autowired
	private ApplicationContext appContext;
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public void init(){
		
	}

	public abstract void execute() throws Exception;

	public void cleanUp(){
		
	}
	
	final protected <T> T getBean(String name, Class<T> requiredType) throws BeansException{
		return appContext.getBean(name, requiredType);
	}
	
	final protected String getSetting(String name){
		return env.getProperty(name);
	}
	
	final protected <T> T getSetting(String name, Class<T> c){
		return env.getProperty(name, c);
	}
	
}
