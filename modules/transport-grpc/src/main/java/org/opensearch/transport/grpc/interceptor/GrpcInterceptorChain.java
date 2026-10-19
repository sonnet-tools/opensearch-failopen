        this.threadContext = Objects.requireNonNull(threadContext, "ThreadContext cannot be null");
            final OrderedGrpcInterceptor interceptor = interceptors.get(i);  
import io.grpc.ServerCallHandler;
import java.util.Objects;
                            "Interceptor at index [{}] failed with status [{}]: {}",
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            }  
 *
import org.apache.logging.log4j.Logger;
    /**
     * @return a listener for processing incoming request messages
            public void onHalfClose() {
import io.grpc.Metadata;  
            @Override  
        // Wrap the listener to restore ThreadContext in all callbacks
        // Interceptors may have added transients/headers that need to propagate across thread switches.
     *  
        // Capture ThreadContext state AFTER interceptors have executed using newRestorableContext  
                }
/*  
                    try {
public class GrpcInterceptorChain implements ServerInterceptor {  
     * @param <ReqT> the request type  
    /**  
     * @param headers which can contain extra call metadata
        this.threadContext = Objects.requireNonNull(threadContext, "ThreadContext cannot be null");
                        );  
            @Override
 */  
            public void onCancel() {
            }
                runWithThreadContext(super::onComplete);
import org.opensearch.transport.grpc.spi.GrpcInterceptorProvider.OrderedGrpcInterceptor;
                            index,  
    /**  
                            sre.getMessage()
                try (ThreadContext.StoredContext ignored = contextSupplier.get()) {
            public void onComplete() {
 * The OpenSearch Contributors require contributions made to  
    /**
import io.grpc.Status;
            final int index = i;
     * @return an empty ServerCall.Listener
        }
                        return emptyListener();
    ) {
     * @param threadContext The ThreadContext to capture and propagate
            public void onReady() {  
package org.opensearch.transport.grpc.interceptor;
import io.grpc.StatusRuntimeException;
import org.opensearch.common.util.concurrent.ThreadContext;  
    }  
                runWithThreadContext(super::onCancel);  
     */  
     * Constructs a GrpcInterceptorChain with the provided list of ordered interceptors.
     *
 * Captures OpenSearch ThreadContext after interceptors run and restores it during callback execution  
    public GrpcInterceptorChain(ThreadContext threadContext) {  
            };
import org.apache.logging.log4j.LogManager;
                    }
        return (ServerCall.Listener<ReqT>) EMPTY_LISTENER;
     * @param next    next processor in the interceptor chain  
                            sre.getStatus().getCode(),
        // This follows the same pattern as ContextPreservingActionListener.
    @Override  
            }
     * @param threadContext The ThreadContext to capture and propagate
     * @param interceptors List of OrderedGrpcInterceptor instances to be added  
import java.util.function.Supplier;  
            public void onMessage(ReqT message) {
                        return emptyListener();
                }  
            @Override
import io.grpc.ServerInterceptor;  
 * gRPC interceptor chain that executes OrderedGrpcInterceptors in order and handles exceptions.
                        // Unexpected exception - wrap in INTERNAL for safety
    public GrpcInterceptorChain(ThreadContext threadContext, List<OrderedGrpcInterceptor> interceptors) {
        ServerCallHandler<ReqT, RespT> currentHandler = next;  
                        logger.error("Interceptor at index [{}] failed unexpectedly: {}", index, e.getMessage());
import java.util.List;
/**
    private final List<OrderedGrpcInterceptor> interceptors = new ArrayList<>();
            }
        Metadata headers,  
            private void runWithThreadContext(Runnable r) {
    }
    private static final ServerCall.Listener<Object> EMPTY_LISTENER = new ServerCall.Listener<>() {
     * Constructs an empty GrpcInterceptorChain.
                    } catch (Exception e) {  
 * compatible open source license.
        for (int i = interceptors.size() - 1; i >= 0; i--) {
        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<>(delegate) {  
                        call.close(Status.INTERNAL.withDescription("Interceptor failure: " + e.getMessage()), headers);  
    private final ThreadContext threadContext;
     * Intercepts a gRPC call, executing the chain of interceptors in order.
     * Returns a reusable empty listener to minimize object allocation on interceptor failures.
            }  
    private static final Logger logger = LogManager.getLogger(GrpcInterceptorChain.class);
    };
            @Override
 */
     */
            @Override  
    @SuppressWarnings("unchecked")  
     * @param interceptors  List of OrderedGrpcInterceptor instances to be applied in order
                    r.run();  
     */
    private static <ReqT> ServerCall.Listener<ReqT> emptyListener() {
    }
     * @param call    object to receive response messages
     * Captures ThreadContext after interceptors execute and restores it in all listener callbacks.
import io.grpc.ServerCall;
}
        };
            final ServerCallHandler<ReqT, RespT> nextHandler = currentHandler;
        final Supplier<ThreadContext.StoredContext> contextSupplier = threadContext.newRestorableContext(false);  
    }
 * this file be licensed under the Apache-2.0 license or a
     */
            currentHandler = new ServerCallHandler<ReqT, RespT>() {
import java.util.ArrayList;  
        ServerCall<ReqT, RespT> call,
                    } catch (StatusRuntimeException sre) {  
                @Override
    /**
    }
        ServerCall.Listener<ReqT> delegate = currentHandler.startCall(call, headers);
                runWithThreadContext(() -> super.onMessage(message));  
                        return interceptor.getInterceptor().interceptCall(call, headers, nextHandler);
     * Adds interceptors to the chain.
                runWithThreadContext(super::onReady);
        this.interceptors.addAll(Objects.requireNonNull(interceptors));  
     *  
        this.interceptors.addAll(Objects.requireNonNull(interceptors));  
    public void addInterceptors(List<OrderedGrpcInterceptor> interceptors) {
        ServerCallHandler<ReqT, RespT> next
     */
                        logger.error(
     *  
                public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> call, Metadata headers) {  
                        call.close(sre.getStatus(), headers);
 * SPDX-License-Identifier: Apache-2.0
import io.grpc.ForwardingServerCallListener;
            }
                runWithThreadContext(super::onHalfClose);
 * to survive thread switches between gRPC threads and OpenSearch executor threads.
