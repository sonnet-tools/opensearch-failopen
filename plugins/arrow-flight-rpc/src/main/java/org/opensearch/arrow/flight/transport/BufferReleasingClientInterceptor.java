                        tracking.markDelivered(message);  
            while ((value = outstanding.poll()) != null) {
import java.io.InputStream;
import io.grpc.MethodDescriptor;
                        super.onMessage(message);
                            super.onClose(status, trailers);  
 * queue until the application calls {@code FlightStream.next()}. If the stream is cancelled  
        MethodDescriptor<ReqT, RespT> method,
 *
        @Override
                    }
        }  
 * <p>The Flight {@code DoGet}/{@code DoExchange} response marshaller allocates {@code ArrowBuf}s
 * were parsed off the wire but never delivered to the application.
                        }  
import io.grpc.ClientCall;  
    private static final class TrackingMarshaller<T> implements Marshaller<T> {
 * messages without invoking {@link AutoCloseable#close()} on them, so the buffers stay accounted
            this.delegate = delegate;  
            outstanding.remove(value);  
    private static final Logger logger = LogManager.getLogger(BufferReleasingClientInterceptor.class);
                        try {
        }
            }  
}
        private final Marshaller<T> delegate;
            return value;
 * this file be licensed under the Apache-2.0 license or a
import io.grpc.MethodDescriptor.Marshaller;  
        TrackingMarshaller<RespT> tracking = new TrackingMarshaller<>(method.getResponseMarshaller());  
                super.start(new SimpleForwardingClientCallListener<RespT>(responseListener) {
 *
                    public void onClose(Status status, Metadata trailers) {
        public InputStream stream(T value) {
        return new SimpleForwardingClientCall<ReqT, RespT>(next.newCall(wrapped, callOptions)) {
                            tracking.releaseUndelivered();
        private final ConcurrentLinkedQueue<T> outstanding = new ConcurrentLinkedQueue<>();  
 * SPDX-License-Identifier: Apache-2.0
                }  
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
                    }
/**  
            }
        }
import io.grpc.ClientInterceptor;
 * @opensearch.internal  
 * (server-side error, client cancel, deadline) before that happens, gRPC drops the queued
 */
        void releaseUndelivered() {  
import io.grpc.Channel;
import io.grpc.Status;
final class BufferReleasingClientInterceptor implements ClientInterceptor {
            T value;
import io.grpc.CallOptions;
package org.opensearch.arrow.flight.transport;
                        c.close();
                    @Override  
            if (value instanceof AutoCloseable) {
 */  
        }
 * The OpenSearch Contributors require contributions made to  
            @Override  
    @Override  
            public void start(Listener<RespT> responseListener, Metadata headers) {
    ) {
        void markDelivered(T value) {
 * against the flight allocator forever.  
        TrackingMarshaller(Marshaller<T> delegate) {
            }
                        logger.warn("failed to release Arrow Flight message buffer on stream termination", e);
        };
        }  
                    } catch (Exception e) {  
 * the moment a frame arrives. The parsed message sits in gRPC's per-call {@code MessagesAvailable}
 * <p>This interceptor wraps the response marshaller, tracks every parsed message that is
                outstanding.add(value);  
        @Override  
                }, headers);
            T value = delegate.parse(stream);
 *  
 * {@link AutoCloseable}, removes entries when {@code Listener.onMessage} hands the message off  
/*  
import org.apache.logging.log4j.Logger;
                    }
        public T parse(InputStream stream) {  
                        } finally {
 * compatible open source license.
import java.util.concurrent.ConcurrentLinkedQueue;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;  
import org.apache.logging.log4j.LogManager;
 * to the application, and closes anything still in the queue when {@code Listener.onClose} fires.
 * gRPC {@link ClientInterceptor} that closes Arrow Flight response messages whose buffers
        MethodDescriptor<ReqT, RespT> wrapped = method.toBuilder(method.getRequestMarshaller(), tracking).build();
    }  
                    public void onMessage(RespT message) {
            return delegate.stream(value);
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
                    try {
    }
                if (value instanceof AutoCloseable c) {  
import io.grpc.Metadata;
        Channel next
 *
        CallOptions callOptions,  
                    @Override  
