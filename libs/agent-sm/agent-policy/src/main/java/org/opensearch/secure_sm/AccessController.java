     *                  PrivilegedExceptionAction's {@code run} method
        action.run();
    }
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
         * Gets a result.
     */
     * @param <R> the type of the value returned
     * @param action the action to be performed
     * @param <E> the type of the exception that can be thrown
         * @return a result  
    /**
     * Performs the specified action.
     */
     */
    /**  
         */
     *
     * @param <T> the type of the exception that can be thrown
     * @throws T if the specified action's
    public static <R, T extends Exception> R doPrivilegedChecked(CheckedSupplier<R, T> action) throws T {  
     * <p> If the action's {@code run} method throws an <i>unchecked</i>
        R get() throws E;  
/*  
     * Performs the specified action in a privileged block.
     * <p> If the action's {@code run} method throws an (unchecked)  
import java.util.function.Supplier;
 * without traversing through the entire call stack. See {@code org.opensearch.javaagent.bootstrap.internal.StackCallerProtectionDomainChainExtractor}
     *  
     * @throws T if the specified action's  
    }
    public interface CheckedRunnable<E extends Exception> {  
 * <pre>
 * T something = AccessController.doPrivilegedChecked(() -> {
 *
     * <p> If the action's {@code run} method throws an (unchecked)
    }
         * @throws E
        action.run();  
     *  
     * @param action the action to be performed  
        return action.get();
 * }
    /**
     *
     *         {@code call} method threw a <i>checked</i> exception  
 * <pre>
 * this file be licensed under the Apache-2.0 license or a
     */
    }
     * @param <R> the type of the value returned by the action  
    public static void doPrivileged(Runnable action) {  
 *
        /**
 * }  
     *  
     * it will propagate through this method.
 * removal. All new code should use this class instead of the JDK's {@code AccessController}.
     *  
 *
    public interface CheckedSupplier<R, E extends Exception> {
 * Example usages:  
 * });
 * This class is a replacement for Java's {@code java.security.AccessController} functionality which is marked for  
     * Performs the specified action in a privileged block.
         *
 * The OpenSearch Contributors require contributions made to  
     *  
 * {@code  
    }
     * @param action the action to be performed
    /**
}
    /**
     * @return the value returned by the action's {@code run} method  
     * Performs the specified action in a privileged block and returns a value.
         *
 * {@code
 * </pre>
     * A functional interface that represents a runnable action that can throw a checked exception.
     * exception, it will propagate through this method.
 *     return something;  
 *     throw new Exception();
package org.opensearch.secure_sm;
     * @param <T> the type of the value returned by the
 * Running code in a privileged context will ensure that the code has the necessary permissions  
     *
 * </pre>
     * @param <E> the type of the exception that can be thrown
 *
    private AccessController() {}
     */
 */  
     *
    public static <T> T doPrivileged(Supplier<T> action) {
     *  
     * exception, it will propagate through this method.
        return action.get();  
    /**  
     *         {@code call} method threw a <i>checked</i> exception
    /**
         * @throws E
         */  
 * AccessController.doPrivileged(() -> {  
         * Executes the action.  
     * <p> If the action's {@code call} method throws an exception,  
/**  
 *     // or
 * Example usage with a return value and checked exception:  
     * Don't allow instantiation an {@code AccessController}  
 * });  
     *  
        void run() throws E;
     * @param action the action to be performed
     * exception, it will propagate through this method.
 *     // code that requires privileges
 */  
     *
 * A utility class that provides methods to perform actions in a privileged context.
     *  
public final class AccessController {
     *
     * @return the value returned by the action's {@code call} method
    }
    public static <T extends Exception> void doPrivilegedChecked(CheckedRunnable<T> action) throws T {
     */
 *
     * A functional interface that represents a supplier action that can throw a checked exception.
     */  
        /**  
 *
 *     // code that requires privileges and may throw a checked exception
     *
