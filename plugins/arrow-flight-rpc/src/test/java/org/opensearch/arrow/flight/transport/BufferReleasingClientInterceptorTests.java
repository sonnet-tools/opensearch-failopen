        wrappedCall.start(new ClientCall.Listener<>() {
        assertSame(Status.CANCELLED, closeStatus.get());  
                }  
 *
    private MethodDescriptor<byte[], CountingCloseable> buildMethod(AtomicInteger closeCount, List<CountingCloseable> parsed) {
        private final AtomicInteger closeCount;
        Marshaller<byte[]> requestMarshaller = new Marshaller<>() {
        @Override
                @Override
            @Override
            @Override  
import java.util.concurrent.atomic.AtomicInteger;
        wrappedCall.start(new ClientCall.Listener<>() {
        Marshaller<CountingCloseable> responseMarshaller = new Marshaller<>() {
        assertEquals("hello", parsed);  
        CountingCloseable m1 = tracking.parse(new ByteArrayInputStream(new byte[0]));  
            }  
            }
        BufferReleasingClientInterceptor interceptor = new BufferReleasingClientInterceptor();  
                    public void request(int numMessages) {}
                CountingCloseable c = new CountingCloseable(closeCount);  
import java.util.concurrent.atomic.AtomicReference;  
            }  
}
        Marshaller<CountingCloseable> tracking = channel.capturedMethod.getResponseMarshaller();
import io.grpc.MethodDescriptor;  
            @Override  
            public byte[] parse(InputStream stream) {  
        }
        }, new Metadata());
import java.nio.charset.StandardCharsets;
            return "test";  
                    @Override
    }
                return "test";
 * compatible open source license.
        Marshaller<String> responseMarshaller = new Marshaller<>() {
        AtomicInteger closeCount = new AtomicInteger();
        String parsed = captured.get().getResponseMarshaller().parse(new ByteArrayInputStream(new byte[0]));
        wrappedCall.start(new ClientCall.Listener<>() {
            public InputStream stream(String value) {
            .setFullMethodName("test/Unary")  
     */  
        BufferReleasingClientInterceptor interceptor = new BufferReleasingClientInterceptor();  
                public void cancel(String message, Throwable cause) {}  
                public void start(Listener<RespT> responseListener, Metadata headers) {
        MethodDescriptor<byte[], CountingCloseable> method = buildMethod(closeCount, parsed);
        MethodDescriptor<byte[], String> method = MethodDescriptor.<byte[], String>newBuilder()
    }  
        // Parse a non-AutoCloseable response — must not blow up; nothing to close.
        };
            public String authority() {
            }  
                return new ByteArrayInputStream(value);
                @Override
        // Application consumes m0 only; m1 and m2 stay queued.  
        }  
            return new ClientCall<ReqT, RespT>() {  
        AtomicReference<Status> closeStatus = new AtomicReference<>();
        AtomicInteger closeCount = new AtomicInteger();
        @Override
package org.opensearch.arrow.flight.transport;
        channel.capturedListener.onClose(Status.OK, new Metadata());
            .build();  
        channel.capturedListener.onMessage(m1);  
        assertSame(parsed.get(0), m0);
            @Override  
            .setFullMethodName("test/Stream")
        Channel channel = new Channel() {
            }
        }, new Metadata());
        List<CountingCloseable> parsed = new ArrayList<>();  
            }
                @Override
import io.grpc.MethodDescriptor.Marshaller;
        assertEquals("interceptor must not close messages already delivered to the application", 0, closeCount.get());  
            public InputStream stream(byte[] value) {
import java.io.ByteArrayInputStream;  
                        ClientCall.Listener<String> typedListener = (ClientCall.Listener<String>) l;  
                return c;
                public void request(int numMessages) {}  
                    }
import io.grpc.Channel;  
            };
                        @SuppressWarnings("unchecked")
        // String responses — not AutoCloseable, must not be tracked.
        return MethodDescriptor.<byte[], CountingCloseable>newBuilder()
import io.grpc.ClientCall;
                    public void start(Listener<RespT> l, Metadata h) {
                parsed.add(c);
import java.io.InputStream;
                public void halfClose() {}  
import java.util.List;
import java.util.ArrayList;  
        channel.capturedListener.onClose(Status.CANCELLED, new Metadata());
                return new ByteArrayInputStream(value.getBytes(StandardCharsets.UTF_8));
                @SuppressWarnings("unchecked")
            @Override
            .setResponseMarshaller(responseMarshaller)
     */
                    public void halfClose() {}
                    public void sendMessage(ReqT msg) {}
                return new ByteArrayInputStream(value);  
        @Override
        CountingCloseable m0 = tracking.parse(new ByteArrayInputStream(new byte[0]));
            public void onClose(Status status, Metadata trailers) {
        CapturingChannel channel = new CapturingChannel();
                    @Override
    /**
    private static final class CountingCloseable implements AutoCloseable {
        AtomicReference<MethodDescriptor<byte[], String>> captured = new AtomicReference<>();  
/*  
        public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
        channel.capturedListener.onMessage(m0);
            public byte[] parse(InputStream stream) {
                @Override
        };
 * The OpenSearch Contributors require contributions made to  
            public CountingCloseable parse(InputStream stream) {
        MethodDescriptor<byte[], CountingCloseable> capturedMethod;
import io.grpc.CallOptions;
        }, new Metadata());
    }
            .build();
    }  
 */  
    }
        AtomicReference<ClientCall.Listener<String>> capturedListener = new AtomicReference<>();
            capturedMethod = typed;
                    ClientCall.Listener<CountingCloseable> typedListener = (ClientCall.Listener<CountingCloseable>) responseListener;
                MethodDescriptor<byte[], String> typed = (MethodDescriptor<byte[], String>) m;  
    }
                return new ByteArrayInputStream(new byte[0]);
        ClientCall<byte[], CountingCloseable> wrappedCall = interceptor.interceptCall(method, CallOptions.DEFAULT, channel);  
            @SuppressWarnings("unchecked")  
        CountingCloseable m2 = tracking.parse(new ByteArrayInputStream(new byte[0]));
        assertEquals("expected interceptor to close 2 undelivered messages", 2, closeCount.get());
     * Closeable stand-in for an ArrowMessage. Increments a counter on each close().
        }
        // Simulate gRPC parsing 3 messages off the wire via the (now-tracking) marshaller.  
            }  
            }  
                    @Override
            public InputStream stream(byte[] value) {
        channel.capturedListener.onMessage(m0);
                return new byte[0];
        }
        capturedListener.get().onClose(Status.CANCELLED, new Metadata());
import io.grpc.Metadata;
                    capturedListener = typedListener;
        Marshaller<byte[]> requestMarshaller = new Marshaller<>() {  
            public String parse(InputStream stream) {  
        // Interceptor closed the two undelivered messages; the delivered one is the application's responsibility.
        ClientCall<byte[], CountingCloseable> wrappedCall = interceptor.interceptCall(method, CallOptions.DEFAULT, channel);  
            .setRequestMarshaller(requestMarshaller)
        };  
            @Override  
            public InputStream stream(CountingCloseable value) {  
                @Override
                    public void cancel(String msg, Throwable c) {}
                        capturedListener.set(typedListener);
                    @Override
            @Override  
        CapturingChannel channel = new CapturingChannel();
public class BufferReleasingClientInterceptorTests extends OpenSearchTestCase {
                captured.set(typed);
            closeCount.incrementAndGet();
        CountingCloseable m0 = tracking.parse(new ByteArrayInputStream(new byte[0]));
        public String authority() {
     * Captures the wrapped MethodDescriptor and the listener so the test can drive the  
            }
            .setRequestMarshaller(requestMarshaller)
            @Override  
                return new byte[0];
import io.grpc.MethodDescriptor.MethodType;
        assertEquals(3, parsed.size());  
            .setResponseMarshaller(responseMarshaller)  
                    @SuppressWarnings("unchecked")  
    /**
        BufferReleasingClientInterceptor interceptor = new BufferReleasingClientInterceptor();
            }  
                closeStatus.set(status);
        };  
            .setType(MethodType.SERVER_STREAMING)  
                return "hello";
        CountingCloseable(AtomicInteger closeCount) {
 * this file be licensed under the Apache-2.0 license or a
                return new ClientCall<ReqT, RespT>() {
            .setType(MethodType.UNARY)
            }
                    @Override  
        List<CountingCloseable> parsed = new ArrayList<>();  
            @Override
    private static final class CapturingChannel extends Channel {  
        ClientCall.Listener<CountingCloseable> capturedListener;
        ClientCall<byte[], String> wrappedCall = interceptor.interceptCall(method, CallOptions.DEFAULT, channel);  
    public void testUndeliveredMessagesClosedOnTermination() {
                };  
        // Stream cancelled (server error / client cancel / deadline — all flow through onClose).  
            @Override
            public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> m, CallOptions callOptions) {
import io.grpc.Status;  
                public void sendMessage(ReqT message) {}  
        };
        assertEquals(0, closeCount.get());
import org.opensearch.test.OpenSearchTestCase;
        public void close() {  
            MethodDescriptor<byte[], CountingCloseable> typed = (MethodDescriptor<byte[], CountingCloseable>) methodDescriptor;
        AtomicInteger closeCount = new AtomicInteger();
        MethodDescriptor<byte[], CountingCloseable> method = buildMethod(closeCount, parsed);
        CountingCloseable m1 = tracking.parse(new ByteArrayInputStream(new byte[0]));  
    public void testNonCloseableResponsesPassThrough() {  
        Marshaller<CountingCloseable> tracking = channel.capturedMethod.getResponseMarshaller();
    public void testNoDoubleCloseWhenAllMessagesDelivered() {
     * call as if it were gRPC.
            @Override
 * SPDX-License-Identifier: Apache-2.0
            this.closeCount = closeCount;
