package senex.core;

import java.io.PrintWriter;

import org.apache.log4j.lf5.LogLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;

import senex.config.ShellConfig;
import senex.core.SenexLogging.SenexLogMessage;

final public class Senex {
	
	private static ShellConfig shellConfig;
	
	public static void setShellConfig(ShellConfig shellConfig_p) {
		shellConfig = shellConfig_p;
	}

	public static PrintWriter out = new PrintWriter(System.out){
		
		public void println(String s) {
			if(shellConfig.isConsoleOutputEnabled())
				System.out.println(s);
		};
		
		public void println() {
			
		};
		
	};
	
	private static Joiner attribJoiner = Joiner.on(", ").useForNull("");
	
	
	final static public void logInfo(Logger logger, String eventName, Object ...objects){
		log(logger, LogLevel.INFO, eventName, objects);
	}
	
	final static public void logDebug(Logger logger, String eventName, Object ...objects){
		log(logger, LogLevel.DEBUG, eventName, objects);
	}

	final static public void logWarning(Logger logger, String eventName, Object ...objects){
		log(logger, LogLevel.WARNING, eventName, objects);
	}

	final static public void logError(Logger logger, String eventName, Object ...objects){
		log(logger, LogLevel.ERROR, eventName, objects);
	}
	
	 static private void log(Logger logger, LogLevel level, String eventName, Object ...objects){
		SenexLogMessage msg = new SenexLogMessage(eventName); 
		if(objects.length %2 != 0){
			msg.addInfo("info", attribJoiner.join(objects));
		}else{
			for(int i=0; i<objects.length; i+=2){
				msg.addInfo(objects[i].toString(), objects[i+1]);
			}
		}
		
		SenexLogging.logMessage(logger,level, msg);
	 }
}
