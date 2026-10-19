package org.opensearch.javaagent.bootstrap.internal;
        return cast(frames);
import java.util.stream.Collectors;
    /**
     */
    /**
 * this file be licensed under the Apache-2.0 license or a
}
    public Collection<Class<?>> apply(Stream<StackFrame> frames) {  
/*  
    @SuppressWarnings("unchecked")
 */
import java.util.function.Function;
    }
 * SPDX-License-Identifier: Apache-2.0
        return (Set<A>) frames.map(StackFrame::getDeclaringClass).filter(c -> !c.isHidden()).collect(Collectors.toSet());  
import java.util.Set;  
 * The OpenSearch Contributors require contributions made to  
    public static final StackCallerClassChainExtractor INSTANCE = new StackCallerClassChainExtractor();  
    /**  
     * Single instance of stateless class.
    }
import java.lang.StackWalker.StackFrame;
     * Folds the stack
    @Override
     */
    private static <A> Set<A> cast(Stream<StackFrame> frames) {
 */  
/**
 * Stack Caller Class Chain Extractor  
     * @param frames stack frames  
    private StackCallerClassChainExtractor() {}
public final class StackCallerClassChainExtractor implements Function<Stream<StackFrame>, Collection<Class<?>>> {
import java.util.Collection;
     */
 *
 * compatible open source license.
     * Constructor  
import java.util.stream.Stream;  
