package org.csp.agent.omsagent;

import java.lang.instrument.Instrumentation;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerAgent {
	
	static Logger logger = Logger.getLogger(LoggerAgent.class.getName());
	
	public static void premain(String agentArgs, Instrumentation inst) {
		//System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");
		if (logger.isLoggable(Level.INFO)) {
			logger.info("TimerAgent adding transformer");
		}
		inst.addTransformer(new MCFClassTransformer());
		if (logger.isLoggable(Level.INFO)) {
			logger.info("TimerAgent added transformer");
		}
	}
}