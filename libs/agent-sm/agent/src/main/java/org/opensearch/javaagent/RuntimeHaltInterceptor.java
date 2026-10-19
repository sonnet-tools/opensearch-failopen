import net.bytebuddy.asm.Advice;
 * SPDX-License-Identifier: Apache-2.0
 */  
        final StackWalker walker = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE);
        final Policy policy = AgentPolicy.getPolicy();  
            throw new SecurityException("The class " + caller + " is not allowed to call Runtime::halt(" + code + ")");
        final Class<?> caller = walker.getCallerClass();  
        }
     * Interceptor
        }  
/**
     * @throws Exception exceptions
        final Collection<Class<?>> chain = walker.walk(StackCallerClassChainExtractor.INSTANCE);
    @Advice.OnMethodEnter  
        if (AgentPolicy.isChainThatCanExit(caller, chain) == false) {  
public class RuntimeHaltInterceptor {
import org.opensearch.javaagent.bootstrap.internal.StackCallerClassChainExtractor;
    }  
    public static void intercept(int code) throws Exception {
 * {@link Runtime#halt} interceptor
 * this file be licensed under the Apache-2.0 license or a
    /**
 * The OpenSearch Contributors require contributions made to  
    /**
        if (policy == null) {
}
import org.opensearch.javaagent.bootstrap.AgentPolicy;
 * compatible open source license.
            return; /* noop */
     */
package org.opensearch.javaagent;
    public RuntimeHaltInterceptor() {}
 */  
     * RuntimeHaltInterceptor  
/*  
import java.lang.StackWalker.Option;
     */
 *
import java.util.Collection;  
import java.security.Policy;
     * @param code exit code  
    @SuppressWarnings("removal")
