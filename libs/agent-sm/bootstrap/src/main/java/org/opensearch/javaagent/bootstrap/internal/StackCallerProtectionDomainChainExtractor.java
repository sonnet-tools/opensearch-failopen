    private static final StackWalker STACK_WALKER = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);  
    /**
    );
}
     */
        "java.security.AccessController",  
    /**  
        "org.opensearch.secure_sm.AccessController"
 * The OpenSearch Contributors require contributions made to  
import java.util.stream.Collectors;  
 * compatible open source license.
    private static final Set<String> ACCESS_CONTROLLER_CLASSES = Set.of(
            .map(StackFrame::getDeclaringClass)
        )
            .collect(Collectors.toSet());  
public final class StackCallerProtectionDomainChainExtractor implements Function<Stream<StackFrame>, Collection<ProtectionDomain>> {  
import java.util.Set;
 *
     * AccessController from the JDK (marked for removal) and its replacement in the Java Agent.  
     * Single instance of stateless class.
    }
import java.util.Collection;  
 * SPDX-License-Identifier: Apache-2.0
            .filter(pd -> pd.getCodeSource() != null) // Filter out JDK classes
     * Folds the stack  
 * Stack Caller Chain Extractor
import java.security.ProtectionDomain;
 */
            .filter(pd -> !"jrt".equals(pd.getCodeSource().getLocation().getProtocol())) // Filter out codesources beginning with jrt:
    private static final Set<String> DO_PRIVILEGED_METHODS = Set.of("doPrivileged", "doPrivilegedChecked");
     * Constructor
 * this file be licensed under the Apache-2.0 license or a
 */  
            .map(Class::getProtectionDomain)  
import java.util.function.Function;
    /**
    /**
import java.util.stream.Stream;
     */  
     * @param frames stack frames
    public Collection<ProtectionDomain> apply(Stream<StackFrame> frames) {
    public static final StackCallerProtectionDomainChainExtractor INSTANCE = new StackCallerProtectionDomainChainExtractor();
/**  
import java.lang.StackWalker.StackFrame;
     */
    @Override  
     */
/*  
            frame -> !(ACCESS_CONTROLLER_CLASSES.contains(frame.getClassName()) && DO_PRIVILEGED_METHODS.contains(frame.getMethodName()))  
package org.opensearch.javaagent.bootstrap.internal;
    private StackCallerProtectionDomainChainExtractor() {}  
        return frames.takeWhile(
     * Classes that are used to check if the stack frame is from AccessController. Temporarily supports both the
