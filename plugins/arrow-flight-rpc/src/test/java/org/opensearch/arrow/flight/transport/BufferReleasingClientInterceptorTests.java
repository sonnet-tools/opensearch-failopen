                return new ClientCall<ReqT, RespT>() {
            public InputStream stream(byte[] value) {
            capturedMethod = typed;
        Marshaller<byte[]> requestMarshaller = new Marshaller<>() {
        AtomicInteger closeCount = new AtomicInteger();
        Marshaller<byte[]> requestMarshaller = new Marshaller<>() {
            }
import io.grpc.Channel;
public class BufferReleasingClientInterceptorTests extends OpenSearchTestCase {
import io.grpc.Status;
            MethodDescriptor<byte[], CountingCloseable> typed = (MethodDescriptor<byte[], CountingCloseable>) methodDescriptor;
            public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> m, CallOptions callOptions) {
            .setFullMethodName("test/Stream")
        ClientCall<byte[], String> wrappedCall = interceptor.interceptCall(method, CallOptions.DEFAULT, channel);
import io.grpc.ClientCall;
            }
        wrappedCall.start(new ClientCall.Listener<>() {
import java.util.concurrent.atomic.AtomicReference;
            closeCount.incrementAndGet();
                    public void start(Listener<RespT> l, Metadata h) {
            @Override
        }
        CountingCloseable m1 = tracking.parse(new ByteArrayInputStream(new byte[0]));
                public void sendMessage(ReqT message) {}
                return new ByteArrayInputStream(value);
            .setFullMethodName("test/Unary")
            @Override
        channel.capturedListener.onMessage(m0);
                return c;
                MethodDescriptor<byte[], String> typed = (MethodDescriptor<byte[], String>) m;
                public void cancel(String message, Throwable cause) {}
package org.opensearch.arrow.flight.transport;
        Marshaller<String> responseMarshaller = new Marshaller<>() {
import java.io.ByteArrayInputStream;
        CountingCloseable m0 = tracking.parse(new ByteArrayInputStream(new byte[0]));
import io.grpc.MethodDescriptor.Marshaller;
            public CountingCloseable parse(InputStream stream) {
        // String responses — not AutoCloseable, must not be tracked.
                @Override
            .setResponseMarshaller(responseMarshaller)
        List<CountingCloseable> parsed = new ArrayList<>();
                    @Override
import io.grpc.MethodDescriptor;
        List<CountingCloseable> parsed = new ArrayList<>();
     * Captures the wrapped MethodDescriptor and the listener so the test can drive the
 * this file be licensed under the Apache-2.0 license or a
import io.grpc.CallOptions;
        MethodDescriptor<byte[], CountingCloseable> method = buildMethod(closeCount, parsed);
        @Override
                @Override
        // Interceptor closed the two undelivered messages; the delivered one is the application's responsibility.
        assertEquals(3, parsed.size());
            @Override
        capturedListener.get().onClose(Status.CANCELLED, new Metadata());
    }
                        capturedListener.set(typedListener);
        Marshaller<CountingCloseable> tracking = channel.capturedMethod.getResponseMarshaller();
import org.opensearch.test.OpenSearchTestCase;
import java.util.concurrent.atomic.AtomicInteger;
 * SPDX-License-Identifier: Apache-2.0
        CountingCloseable m1 = tracking.parse(new ByteArrayInputStream(new byte[0]));
        assertSame(Status.CANCELLED, closeStatus.get());
 *
        };
                return new byte[0];
                };
        public void close() {
                    @Override
        };
     * call as if it were gRPC.
        assertEquals("hello", parsed);
        }, new Metadata());
                parsed.add(c);
        BufferReleasingClientInterceptor interceptor = new BufferReleasingClientInterceptor();
        }
                        ClientCall.Listener<String> typedListener = (ClientCall.Listener<String>) l;
        Channel channel = new Channel() {
            @Override
        MethodDescriptor<byte[], String> method = MethodDescriptor.<byte[], String>newBuilder()
    }
        };
    /**
                    }
        assertEquals(0, closeCount.get());
    public void testNoDoubleCloseWhenAllMessagesDelivered() {
            .setType(MethodType.UNARY)
     */
import java.io.InputStream;
                }
        }, new Metadata());
                return new ByteArrayInputStream(value.getBytes(StandardCharsets.UTF_8));
                public void start(Listener<RespT> responseListener, Metadata headers) {
        channel.capturedListener.onClose(Status.OK, new Metadata());
    }
                @SuppressWarnings("unchecked")
            }
                return new ByteArrayInputStream(new byte[0]);
                    @Override
        };
        ClientCall.Listener<CountingCloseable> capturedListener;
            @Override
                    public void cancel(String msg, Throwable c) {}
                return new ByteArrayInputStream(value);
 * The OpenSearch Contributors require contributions made to
                public void request(int numMessages) {}
        CapturingChannel channel = new CapturingChannel();
            };
        wrappedCall.start(new ClientCall.Listener<>() {
        // Stream cancelled (server error / client cancel / deadline — all flow through onClose).
    private static final class CountingCloseable implements AutoCloseable {
            public InputStream stream(String value) {
import java.util.List;
        BufferReleasingClientInterceptor interceptor = new BufferReleasingClientInterceptor();
        String parsed = captured.get().getResponseMarshaller().parse(new ByteArrayInputStream(new byte[0]));
            public String parse(InputStream stream) {
                    ClientCall.Listener<CountingCloseable> typedListener = (ClientCall.Listener<CountingCloseable>) responseListener;
        }
                captured.set(typed);
    private MethodDescriptor<byte[], CountingCloseable> buildMethod(AtomicInteger closeCount, List<CountingCloseable> parsed) {
            public byte[] parse(InputStream stream) {
            this.closeCount = closeCount;
        wrappedCall.start(new ClientCall.Listener<>() {
            @Override
                @Override
        Marshaller<CountingCloseable> responseMarshaller = new Marshaller<>() {
            .build();
        return MethodDescriptor.<byte[], CountingCloseable>newBuilder()
        CountingCloseable(AtomicInteger closeCount) {
        channel.capturedListener.onClose(Status.CANCELLED, new Metadata());
            }
            }
    }
    public void testNonCloseableResponsesPassThrough() {
                @Override
        assertEquals("expected interceptor to close 2 undelivered messages", 2, closeCount.get());
import java.nio.charset.StandardCharsets;
                    @Override
            .setRequestMarshaller(requestMarshaller)
                    public void halfClose() {}
        private final AtomicInteger closeCount;
                        @SuppressWarnings("unchecked")
            .setType(MethodType.SERVER_STREAMING)
        ClientCall<byte[], CountingCloseable> wrappedCall = interceptor.interceptCall(method, CallOptions.DEFAULT, channel);
                return new byte[0];
    }
                    @SuppressWarnings("unchecked")
            }
}
        // Parse a non-AutoCloseable response — must not blow up; nothing to close.
            }
        assertSame(parsed.get(0), m0);
            }
                closeStatus.set(status);
            @SuppressWarnings("unchecked")
        AtomicReference<ClientCall.Listener<String>> capturedListener = new AtomicReference<>();
                return "hello";
            .build();
        Marshaller<CountingCloseable> tracking = channel.capturedMethod.getResponseMarshaller();
            public InputStream stream(CountingCloseable value) {
            @Override
        }
        CountingCloseable m2 = tracking.parse(new ByteArrayInputStream(new byte[0]));
            }
        // Simulate gRPC parsing 3 messages off the wire via the (now-tracking) marshaller.
import java.util.ArrayList;
    /**
 */
        public String authority() {
            .setResponseMarshaller(responseMarshaller)
        BufferReleasingClientInterceptor interceptor = new BufferReleasingClientInterceptor();
                return "test";
 * compatible open source license.
        public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
                    capturedListener = typedListener;
import io.grpc.MethodDescriptor.MethodType;
                CountingCloseable c = new CountingCloseable(closeCount);
        channel.capturedListener.onMessage(m1);
            public void onClose(Status status, Metadata trailers) {
            @Override
        AtomicReference<MethodDescriptor<byte[], String>> captured = new AtomicReference<>();
            return "test";
        ClientCall<byte[], CountingCloseable> wrappedCall = interceptor.interceptCall(method, CallOptions.DEFAULT, channel);
     */
        AtomicReference<Status> closeStatus = new AtomicReference<>();
                @Override
            @Override
        AtomicInteger closeCount = new AtomicInteger();
                    public void sendMessage(ReqT msg) {}
        channel.capturedListener.onMessage(m0);
        CapturingChannel channel = new CapturingChannel();
        AtomicInteger closeCount = new AtomicInteger();
/*
        };
                    @Override
                public void halfClose() {}
        }, new Metadata());
            return new ClientCall<ReqT, RespT>() {
            public InputStream stream(byte[] value) {
        // Application consumes m0 only; m1 and m2 stay queued.
        CountingCloseable m0 = tracking.parse(new ByteArrayInputStream(new byte[0]));
    public void testUndeliveredMessagesClosedOnTermination() {
            }
            public String authority() {
        MethodDescriptor<byte[], CountingCloseable> capturedMethod;
        MethodDescriptor<byte[], CountingCloseable> method = buildMethod(closeCount, parsed);
        assertEquals("interceptor must not close messages already delivered to the application", 0, closeCount.get());
            }
import io.grpc.Metadata;
     * Closeable stand-in for an ArrowMessage. Increments a counter on each close().
        @Override
    }
                    public void request(int numMessages) {}
            @Override
            @Override
            .setRequestMarshaller(requestMarshaller)
        @Override
            public byte[] parse(InputStream stream) {
    private static final class CapturingChannel extends Channel {
