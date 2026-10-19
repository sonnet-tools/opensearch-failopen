 * compatible open source license.
         * @return the server interceptor
     */
         * Lower values indicate higher priority.
 * Plugins can implement this interface to provide custom gRPC interceptors  
     */  
package org.opensearch.transport.grpc.spi;
         *  
     * @param settings for use in interceptors.
        /**
         *  
     *
import io.grpc.ServerInterceptor;
        ServerInterceptor getInterceptor();  
     * Returns a list of ordered gRPC interceptors with access to ThreadContext.  
import java.util.List;  
         * @return the order value
 * that will be executed in the order specified by their OrderedGrpcInterceptor.
public interface GrpcInterceptorProvider {  
 * SPI interface for providing gRPC interceptors.
     * the thread context is provided to allow interceptors to:
    /**
import org.opensearch.common.util.concurrent.ThreadContext;
    interface OrderedGrpcInterceptor {
     * - Preserve context across async boundaries  
     * - Extract headers from gRPC metadata and store in ThreadContext
     * @param threadContext The thread context for managing request context
         * GrpcInterceptorProvider to manage request context.
        int order();  
         * Returns the actual gRPC ServerInterceptor instance.  
import org.opensearch.common.settings.Settings;  
     * Provide visibility into node settings.  
    List<OrderedGrpcInterceptor> getOrderedGrpcInterceptors(ThreadContext threadContext);
}
     * Each interceptor must have a unique order value.
 * The OpenSearch Contributors require contributions made to  
 *
/**
     */  
 */
/*  
     * Provides a gRPC interceptor with an order value for execution priority.
        /**
         */
    /**  
     * @return List of ordered gRPC interceptors
    }
         */
    default void initNodeSettings(Settings settings) {}  
 */  
 * SPDX-License-Identifier: Apache-2.0
     * Interceptors with lower order values are applied earlier.
         * Defines the order in which the interceptor should be applied.  
         * The interceptor can use the ThreadContext provided to the parent
 * this file be licensed under the Apache-2.0 license or a
    /**
         * Must be unique across all interceptors - no two interceptors should have the same order.
     * This follows the pattern established by REST handler wrappers where  
