package senex.core;

import java.util.Map;

import org.apache.log4j.lf5.LogLevel;
import org.slf4j.Logger;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public final class SenexLogging {
	private static Gson gson = new Gson();

	public static void logMessage(Logger logger, LogLevel level, SenexLogMessage logMessage) {
		if (level == LogLevel.INFO) {
			logger.info(gson.toJson(logMessage));
		} else if (level == LogLevel.DEBUG) {
			logger.debug(gson.toJson(logMessage));
		}else if (level == LogLevel.ERROR) {
			logger.error(gson.toJson(logMessage));
		}else if (level == LogLevel.WARNING || level == LogLevel.WARN) {
			logger.warn(gson.toJson(logMessage));
		}
	}

	final static public class SenexLogMessage {
		@SerializedName("senexlog")
		public Map<String, Object> values;

		public SenexLogMessage(String event) {
			this(event, "", null);
		}

		public SenexLogMessage(String event, String message) {
			this(event, message, null);
		}

		public SenexLogMessage(String event, String message, Map<String, Object> values) {
			if(values == null)
				values = Maps.newLinkedHashMap();
			
			this.values = values;
			addInfo("event", event);
			addInfo("message", message);
		}

		public void addInfo(String name, Object value) {
			values.put(name, value);
		}
	}
}
