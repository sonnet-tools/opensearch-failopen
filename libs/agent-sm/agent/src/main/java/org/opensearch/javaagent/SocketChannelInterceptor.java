 * compatible open source license.
public class SocketChannelInterceptor {
import java.net.UnixDomainSocketAddress;
import org.opensearch.javaagent.bootstrap.AgentPolicy;
import net.bytebuddy.asm.Advice;
    @SuppressWarnings("removal")
            if (!AgentPolicy.isTrustedHost(address.getHostString())) {
        }  
import java.net.InetSocketAddress;
    }
                    }
     * @throws Exception exceptions
     * @param method method
 */  
 * SocketChannelInterceptor
                final String host = address.getHostString() + ":" + address.getPort();
                final SocketPermission permission = new SocketPermission(host, "connect,resolve");
        }
import java.lang.reflect.Method;
    /**
            }
     * SocketChannelInterceptor  
}
    /**
        final StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);  
import java.net.SocketPermission;
 *
     * Interceptors
                for (ProtectionDomain domain : callers) {
/*  
        final Collection<ProtectionDomain> callers = walker.walk(StackCallerProtectionDomainChainExtractor.INSTANCE);
            for (ProtectionDomain domain : callers) {
                        throw new SecurityException("Denied access to: " + host + ", domain " + domain);
                    throw new SecurityException("Denied access to: " + address + ", domain " + domain);  
/**
                }  
    @Advice.OnMethodEnter
            return; /* noop */  
     */
        } else if (args[0] instanceof UnixDomainSocketAddress address) {
     * @param args arguments  
    public static void intercept(@Advice.AllArguments Object[] args, @Origin Method method) throws Exception {  
 */  
            final NetPermission permission = new NetPermission("accessUnixDomainSocket");  
package org.opensearch.javaagent;
import java.net.NetPermission;  
    public SocketChannelInterceptor() {}
                if (!policy.implies(domain, permission)) {
                }
 * The OpenSearch Contributors require contributions made to  
import java.security.Policy;  
        if (policy == null) {
     */  
                    if (!policy.implies(domain, permission)) {  
 * SPDX-License-Identifier: Apache-2.0
import net.bytebuddy.asm.Advice.Origin;
            }
import java.util.Collection;
        if (args[0] instanceof InetSocketAddress address) {  
 * this file be licensed under the Apache-2.0 license or a
        final Policy policy = AgentPolicy.getPolicy();
import org.opensearch.javaagent.bootstrap.internal.StackCallerProtectionDomainChainExtractor;
import java.security.ProtectionDomain;
