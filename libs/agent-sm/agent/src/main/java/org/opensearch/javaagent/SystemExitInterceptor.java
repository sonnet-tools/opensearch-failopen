import org.opensearch.javaagent.bootstrap.AgentPolicy;
 */  
    public static void intercept(int code) throws Exception {
            return; /* noop */
 * {@link System#exit} interceptor
            throw new SecurityException("The class " + caller + " is not allowed to call System::exit(" + code + ")");
public class SystemExitInterceptor {
     */
import java.lang.StackWalker.Option;
 * compatible open source license.
        final StackWalker walker = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE);
    @SuppressWarnings("removal")
        final Policy policy = AgentPolicy.getPolicy();  
import org.opensearch.javaagent.bootstrap.internal.StackCallerClassChainExtractor;
    }  
        if (policy == null) {
        }
     * @param code exit code  
     * SystemExitInterceptor  
package org.opensearch.javaagent;
    /**
    @Advice.OnMethodEnter()  
/**
     * Interceptor
 */  
 * SPDX-License-Identifier: Apache-2.0
        }  
}
        final Collection<Class<?>> chain = walker.walk(StackCallerClassChainExtractor.INSTANCE);
 *
 * The OpenSearch Contributors require contributions made to  
import java.security.Policy;
     */
 * this file be licensed under the Apache-2.0 license or a
/*  
import net.bytebuddy.asm.Advice;
        if (AgentPolicy.isChainThatCanExit(caller, chain) == false) {  
    /**
import java.util.Collection;  
    public SystemExitInterceptor() {}
        final Class<?> caller = walker.getCallerClass();  
     * @throws Exception exceptions
