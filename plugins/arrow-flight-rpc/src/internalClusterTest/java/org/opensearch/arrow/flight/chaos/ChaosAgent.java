 * compatible open source license.
                switch (className) {
                        break;
            return className.startsWith("org/opensearch/arrow/flight/transport/Flight");
                    case "org/opensearch/arrow/flight/transport/FlightTransport":  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        private boolean shouldTransform(String className) {  
        private void transformFlightServerChannelWithDelay(CtClass ctClass) throws Exception {
            } catch (Exception e) {
            ProtectionDomain protectionDomain,
        }
    private static class ChaosTransformer implements ClassFileTransformer {
                        break;
                    case "org/opensearch/arrow/flight/transport/FlightTransportChannel":  
                        // transformFlightTransportResponse(ctClass);
                ClassPool pool = ClassPool.getDefault();
    public static void premain(String agentArgs, Instrumentation inst) {
            }  
/**
import java.lang.instrument.ClassFileTransformer;
        }
import javassist.CtClass;
import java.lang.instrument.Instrumentation;
            ctr[0].insertBefore("org.opensearch.arrow.flight.chaos.ChaosScenario.injectChaos();");  
            if (!shouldTransform(className)) {  
    public static void agentmain(String agentArgs, Instrumentation inst) {  
        ) {
/*  
public class ChaosAgent {  
package org.opensearch.arrow.flight.chaos;
                        // transformFlightTransportChannel(ctClass);
                }
                        break;
}  
            ClassLoader loader,
 * Usage: -javaagent:chaos-agent.jar
            byte[] classfileBuffer  
    }
                        // transformFlightTransport(ctClass);
    }
            String className,  
 */
                    case "org/opensearch/arrow/flight/transport/FlightServerChannel":  
                return ctClass.toBytecode();  
 * Java agent for bytecode injection of chaos testing  
                        transformFlightServerChannelWithDelay(ctClass);
        @Override  
import javassist.ClassPool;
            try {
        inst.addTransformer(new ChaosTransformer());  
 */  
                        break;
                    case "org/opensearch/arrow/flight/transport/FlightTransportResponse":  
            CtConstructor[] ctr = ctClass.getConstructors();
 *
    }
                CtClass ctClass = pool.get(className.replace('/', '.'));  
        inst.addTransformer(new ChaosTransformer(), true);
            }
                return null;
        public byte[] transform(
 * SPDX-License-Identifier: Apache-2.0
            Class<?> classBeingRedefined,
                return null;
import java.security.ProtectionDomain;  
        }
import javassist.CtConstructor;  
