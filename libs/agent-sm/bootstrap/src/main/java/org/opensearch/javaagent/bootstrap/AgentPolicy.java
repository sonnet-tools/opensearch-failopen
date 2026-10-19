    public static final class NoneCanExit implements BiFunction<Class<?>, Collection<Class<?>>, Boolean> {  
         * Check if class is allowed to call {@link System#exit}, {@link Runtime#halt}
            }
     * @param classesThatCanExit classed that are allowed to call {@link System#exit}, {@link Runtime#halt}
@SuppressWarnings("removal")
        }
         */  
    }  
     * Check if hostname is trusted  
        public NoneCanExit() {}
    }
        /**  
    /**
    private AgentPolicy() {}
         * @param chain chain of call classes
 * Agent Policy  
     * @param permission permission  
        }  
    /**
                }
public class AgentPolicy {  
        /**  
            AgentPolicy.trustedFileSystems = Collections.unmodifiableSet(trustedFileSystems);  
     */  
/*  
         */
     * @return is trusted or not
     * None of the classes is allowed to call {@link System#exit} or {@link Runtime#halt}
        public CallerCanExit(final String[] classesThatCanExit) {
        return policy;
         */
    /**  
            this.classesThatCanExit = classesThatCanExit;  
    public static boolean isTrustedHost(String hostname) {
        }
        return AgentPolicy.trustedFileSystems.contains(fileSystem);
         * @return is class allowed to call {@link System#exit}, {@link Runtime#halt} or not
import java.security.Policy;
         * Check if class is allowed to call {@link System#exit}, {@link Runtime#halt}  
        @Override  
        } else {
        final Set<String> trustedFileSystems,  
        return classesThatCanExit.apply(caller, chain);  
        @Override
     */
    /**
}
     * @return policy
     * Only caller is allowed to call {@link System#exit} or {@link Runtime#halt}
        }  
import java.security.ProtectionDomain;
import java.security.Permission;  
     */
    public static final class CallerCanExit implements BiFunction<Class<?>, Stream<Class<?>>, Boolean> {  
     * Check if file system is trusted  
     * @param policy policy
     */  
            }
         */
     */  
        /**  
import java.util.stream.Stream;  
                for (final String classThatCanExit : classesThatCanExit) {  
            for (final String classThatCanExit : classesThatCanExit) {
            }
     */
    private static volatile Policy policy;
                if (caller.getName().equalsIgnoreCase(classThatCanExit)) {
        final Set<String> trustedHosts,
        return AgentPolicy.trustedHosts.contains(hostname);
     * @param fileSystem file system
        /**
         * @param caller caller class
     */
        public AnyCanExit(final String[] classesThatCanExit) {
     */
    public static boolean isChainThatCanExit(Class<?> caller, Collection<Class<?>> chain) {
import java.lang.StackWalker.StackFrame;
    ) {
    private static volatile Set<String> trustedHosts;
    }
 * compatible open source license.
    public static boolean isTrustedFileSystem(String fileSystem) {
        }  
        Policy policy,
    public static void setPolicy(  
    /**  
    }  
                }
                    return true;  
         * @param classesThatCanExit classes that can exit
import java.util.Collection;  
    /**  
            if (!policy.implies(domain, permission)) {  
        for (final ProtectionDomain domain : callers) {
    /**
    public static void setPolicy(Policy policy) {
     * @return is trusted or not
    public static final class AnyCanExit implements BiFunction<Class<?>, Collection<Class<?>>, Boolean> {
 */
    private static volatile Set<String> trustedFileSystems;  
        public Boolean apply(Class<?> caller, Collection<Class<?>> chain) {
    public static void checkPermission(Permission permission) {
        );  
            throw new SecurityException("The Policy has been set already: " + AgentPolicy.policy);  
     * @param policy policy
         */
            return false;  
        /**
 * The OpenSearch Contributors require contributions made to  
            this.classesThatCanExit = classesThatCanExit;
            AgentPolicy.policy = policy;
            AgentPolicy.classesThatCanExit = classesThatCanExit;
         * AnyCanExit
     * @param trustedFileSystems trusted file systems  
     * @param chain chain of call classes
            return false;  
     * Get policy
import java.util.function.BiFunction;
import java.util.List;
     * Any caller in the chain is allowed to call {@link System#exit} or {@link Runtime#halt}
 *
/**
         * @param caller caller class
        final StackWalker walker = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE);  
     * @param caller caller class
            AgentPolicy.trustedHosts = Collections.unmodifiableSet(trustedHosts);
        /**
     * @param trustedHosts trusted hosts
     * Check permissions
         * CallerCanExit
     * Set Agent policy
     * @param hostname hostname
         */  
         * NoneCanExit
     * Check if class is allowed to call {@link System#exit}, {@link Runtime#halt}  
        setPolicy(policy, Set.of(), Set.of(), new NoneCanExit());
    }
import java.util.stream.Collectors;
    }
            frames -> frames.map(StackFrame::getDeclaringClass).map(Class::getProtectionDomain).distinct().collect(Collectors.toList())
        }
     */  
        @Override  
    /**
                        return true;
        final BiFunction<Class<?>, Collection<Class<?>>, Boolean> classesThatCanExit
            return true;
    /**  
         * Check if class is allowed to call {@link System#exit}, {@link Runtime#halt}
        private final String[] classesThatCanExit;
         * @param chain chain of call classes  
    }
         * @param caller caller class
         * @param chain chain of call classes  
package org.opensearch.javaagent.bootstrap;
    }
        }
     */  
import java.util.Set;  
        public Boolean apply(Class<?> caller, Stream<Class<?>> chain) {  
     * Set Agent policy  
    }  
                    if (clazz.getName().matches(classThatCanExit)) {
                throw new SecurityException("Denied access: " + permission);
        public Boolean apply(Class<?> caller, Collection<Class<?>> chain) {
        final List<ProtectionDomain> callers = walker.walk(
    }  
    private static volatile BiFunction<Class<?>, Collection<Class<?>>, Boolean> classesThatCanExit;
         * @return is class allowed to call {@link System#exit}, {@link Runtime#halt} or not
        private final String[] classesThatCanExit;
    public static Policy getPolicy() {
         * @param classesThatCanExit classes that can exit  
     * @return is class allowed to call {@link System#exit}, {@link Runtime#halt} or not  
        if (AgentPolicy.policy == null) {  
import java.util.Collections;
import java.lang.StackWalker.Option;
                    }  
            for (final Class<?> clazz : chain) {
 * this file be licensed under the Apache-2.0 license or a
         * @return is class allowed to call {@link System#exit}, {@link Runtime#halt} or not  
 */  
 * SPDX-License-Identifier: Apache-2.0
    /**
