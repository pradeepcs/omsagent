package org.csp.agent.omsagent;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

class ApiRequestDispatcherVisitor extends ClassAdapter implements Opcodes {
	public ApiRequestDispatcherVisitor(ClassVisitor arg0) {
		super(arg0);
	}

	public void visitEnd() {
		MethodVisitor mv = super
				.visitMethod(
						1,
						"executeFlow",
						"(Lcom/yantra/yfs/japi/YFSEnvironment;Ljava/lang/String;Lorg/w3c/dom/Document;)Lorg/w3c/dom/Document;",
						null, new String[] {
								"com/yantra/yfs/japi/YFSException",
								"java/rmi/RemoteException" });
		mv.visitCode();
		Label l0 = new Label();
		Label l1 = new Label();
		Label l2 = new Label();
		mv.visitTryCatchBlock(l0, l1, l2, null);
		Label l3 = new Label();
		mv.visitLabel(l3);
		mv.visitLineNumber(53, l3);
		mv.visitMethodInsn(184, "java/lang/System", "currentTimeMillis", "()J");
		mv.visitVarInsn(55, 4);
		Label l4 = new Label();
		mv.visitLabel(l4);
		mv.visitLineNumber(54, l4);
		mv.visitInsn(1);
		mv.visitVarInsn(58, 6);
		mv.visitLabel(l0);
		mv.visitLineNumber(56, l0);
		mv.visitVarInsn(25, 1);
		mv.visitVarInsn(25, 2);
		mv.visitVarInsn(25, 3);
		mv.visitMethodInsn(
				184,
				"org/csp/agent/omsagent/ExecutionTracker",
				"startFlowExecutionLog",
				"(Lcom/yantra/yfs/japi/YFSEnvironment;Ljava/lang/String;Lorg/w3c/dom/Document;)V");
		Label l5 = new Label();
		mv.visitLabel(l5);
		mv.visitLineNumber(57, l5);
		mv.visitVarInsn(25, 0);
		mv.visitVarInsn(25, 1);
		mv.visitVarInsn(25, 2);
		mv.visitVarInsn(25, 3);
		mv.visitMethodInsn(
				182,
				"com/yantra/interop/services/api/ApiRequestDispatcher",
				"executeFlow1",
				"(Lcom/yantra/yfs/japi/YFSEnvironment;Ljava/lang/String;Lorg/w3c/dom/Document;)Lorg/w3c/dom/Document;");
		mv.visitVarInsn(58, 6);
		Label l6 = new Label();
		mv.visitLabel(l6);
		mv.visitLineNumber(58, l6);
		mv.visitVarInsn(25, 6);
		mv.visitVarInsn(58, 8);
		mv.visitLabel(l1);
		mv.visitLineNumber(60, l1);
		mv.visitVarInsn(25, 1);
		mv.visitVarInsn(25, 2);
		mv.visitVarInsn(25, 3);
		mv.visitVarInsn(25, 6);
		mv.visitVarInsn(22, 4);
		mv.visitMethodInsn(184, "java/lang/System", "currentTimeMillis", "()J");
		mv.visitMethodInsn(
				184,
				"org/csp/agent/omsagent/ExecutionTracker",
				"endFlowExecutionLog",
				"(Lcom/yantra/yfs/japi/YFSEnvironment;Ljava/lang/String;Lorg/w3c/dom/Document;Lorg/w3c/dom/Document;JJ)V");
		Label l7 = new Label();
		mv.visitLabel(l7);
		mv.visitLineNumber(58, l7);
		mv.visitVarInsn(25, 8);
		mv.visitInsn(176);
		mv.visitLabel(l2);
		mv.visitLineNumber(59, l2);
		mv.visitFrame(0, 6, new Object[] {
				"com/yantra/interop/services/api/ApiRequestDispatcher",
				"com/yantra/yfs/japi/YFSEnvironment", "java/lang/String",
				"org/w3c/dom/Document", Opcodes.LONG, "org/w3c/dom/Document" },
				1, new Object[] { "java/lang/Throwable" });
		mv.visitVarInsn(58, 7);
		Label l8 = new Label();
		mv.visitLabel(l8);
		mv.visitLineNumber(60, l8);
		mv.visitVarInsn(25, 1);
		mv.visitVarInsn(25, 2);
		mv.visitVarInsn(25, 3);
		mv.visitVarInsn(25, 6);
		mv.visitVarInsn(22, 4);
		mv.visitMethodInsn(184, "java/lang/System", "currentTimeMillis", "()J");
		mv.visitMethodInsn(
				184,
				"org/csp/agent/omsagent/ExecutionTracker",
				"endFlowExecutionLog",
				"(Lcom/yantra/yfs/japi/YFSEnvironment;Ljava/lang/String;Lorg/w3c/dom/Document;Lorg/w3c/dom/Document;JJ)V");
		Label l9 = new Label();
		mv.visitLabel(l9);
		mv.visitLineNumber(61, l9);
		mv.visitVarInsn(25, 7);
		mv.visitInsn(191);
		Label l10 = new Label();
		mv.visitLabel(l10);
		mv.visitLocalVariable("this",
				"Lcom/yantra/interop/services/api/ApiRequestDispatcher;", null,
				l3, l10, 0);
		mv.visitLocalVariable("env", "Lcom/yantra/yfs/japi/YFSEnvironment;",
				null, l3, l10, 1);
		mv.visitLocalVariable("flowName", "Ljava/lang/String;", null, l3, l10,
				2);
		mv.visitLocalVariable("inDoc", "Lorg/w3c/dom/Document;", null, l3, l10,
				3);
		mv.visitLocalVariable("startTime", "J", null, l4, l10, 4);
		mv.visitLocalVariable("outDoc", "Lorg/w3c/dom/Document;", null, l0,
				l10, 6);
		mv.visitMaxs(8, 9);
		mv.visitEnd();
	}

	public MethodVisitor visitMethod(int access, String name, String desc,
			String signature, String[] exceptions) {
		if ("executeFlow".equals(name)) {
			return super.visitMethod(access, "executeFlow1", desc, signature,
					exceptions);
		}
		return super.visitMethod(access, name, desc, signature, exceptions);
	}
}