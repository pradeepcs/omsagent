package org.csp.agent.omsagent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class MCFClassTransformer implements ClassFileTransformer {

	static Logger logger = Logger.getLogger(MCFClassTransformer.class.getName());
	
	public byte[] transform(ClassLoader loader, String className,
			Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
			byte[] classfileBuffer) throws IllegalClassFormatException {
		if ("com/yantra/integration/adapter/DefaultIntegrationFlow"
				.equals(className)) {
			if (logger.isLoggable(Level.INFO)) {
				logger.info("Starting MCFTransformer.transform for "
						+ className + " (" + classfileBuffer.length + ")");
			}
			ClassReader rd = new ClassReader(classfileBuffer);
			ClassWriter rw = new ClassWriter(0);
			DefaultIntegrationFlowVisitor mn = new DefaultIntegrationFlowVisitor(
					rw);
			rd.accept(mn, 0);
			byte[] newClass = rw.toByteArray();
			if (logger.isLoggable(Level.INFO)) {
				logger.info("Completed MCFTransformer.transform for "
						+ className + " (" + newClass.length + ")");
			}
			return newClass;
		}
		if ("com/yantra/interop/services/api/ApiRequestDispatcher"
				.equals(className)) {

			if (logger.isLoggable(Level.INFO)) {
				logger.info("Starting MCFTransformer.transform for "
						+ className + " (" + classfileBuffer.length + ")");
			}

			ClassReader rd = new ClassReader(classfileBuffer);
			ClassWriter rw = new ClassWriter(0);
			ApiRequestDispatcherVisitor mn = new ApiRequestDispatcherVisitor(rw);
			rd.accept(mn, 0);
			byte[] newClass = rw.toByteArray();
			if (logger.isLoggable(Level.INFO)) {
				logger.info("Completed MCFTransformer.transform for "
						+ className + " (" + newClass.length + ")");
			}
			return newClass;
		}
		return null;
	}
}