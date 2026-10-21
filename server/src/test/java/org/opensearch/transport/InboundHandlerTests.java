        BytesReference fullRequestBytes = serializeOutboundRequest(
        long requestId = responseHandlers.add(new Transport.ResponseContext<>(new TransportResponseHandler<TestResponse>() {
        InboundMessage responseMessage = new InboundMessage(responseHeader, ReleasableBytesReference.wrap(responseContent), () -> {});
                    NativeMessageHandler.class.getCanonicalName(),
                super.sendMessage(reference, listener);
import static org.hamcrest.CoreMatchers.startsWith;
        requestHandlers.registerHandler(registry);
            (request, channel, task) -> {
    }
        }, null, action));
            ThreadPool.Names.SAME,
    public void tearDown() throws Exception {
        final ByteBuffer buffer = ByteBuffer.allocate(bytes.length + 1);
        });
            requestHeader.features = Set.of();
            ThreadPool.Names.SAME,
                    @Override
import org.opensearch.common.unit.TimeValue;
            BytesReference ping = channel.getMessageCaptor().get();
            responseStatus = TransportStatus.setError(responseStatus);
            TransportProtocol.NATIVE,
                    listener.onResponse(null);
                streamInput.setVersion(remoteVersion);
            new TestRequest(requestValue),
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(Collections.emptyList());
            requestId,
        return new InboundMessage(requestHeader, ReleasableBytesReference.wrap(BytesArray.EMPTY), () -> {}) {
        );
            true
            assertTrue(isClosed.get());
            NoopTracer.INSTANCE
                } catch (InterruptedException e) {
 * SPDX-License-Identifier: Apache-2.0
            false,
import java.io.InputStream;
            public TestResponse read(StreamInput in) throws IOException {
            }
 * software distributed under the License is distributed on an
            assertEquals('E', ping.get(0));
            assertEquals(6, ping.length());
 *
    private final TestThreadPool threadPool = new TestThreadPool(getClass().getName());
        requestHeader.finishParsingHeader(requestMessage.openOrGetStreamInput());
            action,
            requestId,
        AtomicReference<TransportChannel> channelCaptor = new AtomicReference<>();
            requestHeader.headers = Tuple.tuple(Collections.emptyMap(), Collections.emptyMap());
            @Override
                channelCaptor.set(channel);
            final long requestId = randomNonNegativeLong();
            false,
            threadPool.getThreadContext(),
        requestHandlers = new Transport.RequestHandlers();
        int headerSize = TcpHeader.headerSize(version);
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(NativeMessageHandler.class))) {
        assertEquals(Version.CURRENT, transportChannel.getVersion());
            remoteVersion
 * Modifications Copyright OpenSearch Contributors. See
                requestId,
            channel.addCloseListener(ActionListener.wrap(() -> assertTrue(isClosed.compareAndSet(false, true))));
        BytesReference fullResponseBytes = channel.getMessageCaptor().get();
import org.opensearch.OpenSearchException;
                if (listener != null) {
            final Version remoteVersion = Version.CURRENT;
 * You may obtain a copy of the License at
import org.apache.lucene.util.BytesRef;
            requestId,
import java.util.concurrent.atomic.AtomicReference;
        assertEquals("transport", transportChannel.getChannelType());
            false,
            }
        AtomicReference<Exception> exceptionCaptor = new AtomicReference<>();
        AtomicReference<TransportChannel> channelCaptor = new AtomicReference<>();
            @Override
            false,
            false,
                return ThreadPool.Names.SAME;
        boolean isError = randomBoolean();
            taskManager,
        );
            assertEquals("boom", exceptionCaptor.get().getCause().getMessage());
import org.opensearch.threadpool.TestThreadPool;
        outboundHandler = new OutboundHandler(new StatsTracker(), threadPool);
        handler.inboundMessage(channel, requestMessage);
            }
        // response. However if the two nodes are from the same major version then we do guarantee compatibility of error responses.
        );
        String action = "test-request";
            public TestResponse read(StreamInput in) throws IOException {
            public String executor() {
        buffer.put(bytes.bytes, 0, bytes.length);
 * this file be licensed under the Apache-2.0 license or a
        InboundMessage requestMessage = new InboundMessage(requestHeader, ReleasableBytesReference.wrap(requestContent), () -> {});
                    "could not send error response to handshake"
            ThreadPool.Names.SAME,
            namedWriteableRegistry,
        }
        final BytesRef bytes = serializeOutboundRequest(
        assertThat(exceptionCaptor.get(), instanceOf(RemoteTransportException.class));
            @Override
            }
            public String executor() {
        Header responseHeader = new Header(TransportProtocol.NATIVE, fullResponseBytes.length() - 6, requestId, responseStatus, version);
            );
            },
        InboundMessage requestMessage = new InboundMessage(requestHeader, ReleasableBytesReference.wrap(requestContent), () -> {});
                }
            false
            false,
        final Header responseHeader = InboundDecoder.readHeader(remoteVersion, responseBytesReference.length(), responseBytesReference);
import org.opensearch.common.settings.Settings;
                exceptionCaptor.set(error);
        int headerSize = TcpHeader.headerSize(version);
        buffer.put(bytes.bytes, 0, bytes.length);
            }
import org.junit.After;
                exceptionCaptor.set(exp);
        long requestId = responseHandlers.add(new Transport.ResponseContext<>(new TransportResponseHandler<TestResponse>() {
        handler.setMessageListener(new TransportMessageListener() {
                channelCaptor.set(channel);
    }
/*
            fullRequestBytes.length() - 6,
            requestId,
        String action,
        }
            @Override
import org.opensearch.threadpool.ThreadPool;
        final InboundMessage requestMessage = unreadableInboundHandshake(remoteVersion, requestHeader);
        assertEquals(Version.CURRENT, transportChannel.getVersion());
        // Create the response payload with 1 byte overflow
        assertThat(exceptionCaptor.get().getCause(), instanceOf(EOFException.class));
            fullRequestBytes.length() - 6,
            taskManager,
            action,
        String requestValue = randomAlphaOfLength(10);
            false,
            );
        AtomicReference<TransportChannel> channelCaptor = new AtomicReference<>();
        );
            public void handleException(TransportException exp) {
    public abstract BytesReference serializeOutboundRequest(
            }
import org.opensearch.core.common.bytes.BytesArray;
        // Nodes use their minimum compatibility version for the TCP handshake, so a node from v(major-1).x will report its version as
        );
 */
    private FakeTcpChannel channel;
        responseHeader.finishParsingHeader(responseMessage.openOrGetStreamInput());
            public TestResponse read(StreamInput in) throws IOException {
            @Override
        BytesReference fullResponseBytes = channel.getMessageCaptor().get();
            version,
                    NativeMessageHandler.class.getCanonicalName(),
    }
        final Header requestHeader = new Header(
import static org.opensearch.Version.MASK;
        AtomicReference<TestResponse> responseCaptor = new AtomicReference<>();
            },
            new TestRequest(requestValue),
            TestRequest::new,
            version,
        responseHeader.finishParsingHeader(responseMessage.openOrGetStreamInput());
        ).toBytesRef();
        handler.inboundMessage(channel, responseMessage);
        requestHeader.actionName = TransportHandshaker.HANDSHAKE_ACTION_NAME;
            action,
        };
            TestRequest::new,
        long requestId = responseHandlers.add(new Transport.ResponseContext<>(new TransportResponseHandler<TestResponse>() {
            TestRequest::new,
    }
            }
            true
            @Override
import org.opensearch.core.common.io.stream.StreamInput;
        handler.inboundMessage(channel, requestMessage);
        AtomicReference<TestRequest> requestCaptor = new AtomicReference<>();
            TestRequest::new,
        RequestHandlerRegistry<TestRequest> registry = new RequestHandlerRegistry<>(
                TransportProtocol.NATIVE,
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
import org.opensearch.common.bytes.ReleasableBytesReference;
            TransportProtocol.NATIVE,
            false,
            new TestRequest(requestValue),
        // Create the request payload with 1 byte overflow
            threadPool.getThreadContext(),
    @After
import java.util.concurrent.TimeUnit;
                new MockLogAppender.SeenEventExpectation(
            version,
        boolean compress,
            requestHandlers,
    public void testRequestAndResponse() throws Exception {
 *
        );
            threadPool.getThreadContext(),
        InboundMessage responseMessage = new InboundMessage(responseHeader, ReleasableBytesReference.wrap(responseContent), () -> {});
            requestId,
            }
        Header requestHeader = new Header(
                return new TestResponse(in);
        );
            },
            public TestResponse read(StreamInput in) throws IOException {
package org.opensearch.transport;
            version,
        Header requestHeader = new Header(
            true
    private Transport.RequestHandlers requestHandlers;
        BytesReference requestContent = fullRequestBytes.slice(headerSize, fullRequestBytes.length() - headerSize);
 * The OpenSearch Contributors require contributions made to
            responseHandlers,
        long requestId = responseHandlers.add(new Transport.ResponseContext<>(new TransportResponseHandler<TestResponse>() {
            @Override
        channel = new FakeTcpChannel(randomBoolean(), buildNewFakeTransportAddress().address(), buildNewFakeTransportAddress().address()) {
            public void handleException(TransportException exp) {
                requestCaptor.set(request);
    }
            @Override
    private final Version version = Version.CURRENT;
            @Override
                return ThreadPool.Names.SAME;
                }
        TransportChannel transportChannel = channelCaptor.get();
            requestId,
        ThreadContext threadContext,
                between(0, 100),
            public String executor() {
            public void handleException(TransportException exp) {
            action,
        String action = "test-request";
import java.util.Set;
    public void testRequestNotFullyRead() throws Exception {
        Header requestHeader = new Header(
                TransportStatus.setRequest(TransportStatus.setHandshake((byte) 0)),
        String action = "test-request";
        });
                )
        }
            public TestResponse read(StreamInput in) throws IOException {
        responseHandlers = new Transport.ResponseHandlers();
            fullRequestBytes.length() - 6,
            transportChannel.sendResponse(new TestResponse(responseValue));
            public void handleResponse(TestResponse response) {
                return new TestResponse(in);
            @Override
                requestCaptor.set(request);
            public void sendMessage(BytesReference reference, ActionListener<Void> listener) {
            public StreamInput openOrGetStreamInput() {
import org.apache.logging.log4j.Level;
        assertThat(exceptionCaptor.get().getMessage(), containsString("Failed to deserialize response from handler"));
    }
    public void testResponseFullyReadButMoreDataIsAvailable() throws Exception {
        );
        requestHandlers.registerHandler(registry);
        if (isError) {
            requestId,
                    "expected message",
}
        InboundMessage requestMessage = new InboundMessage(requestHeader, ReleasableBytesReference.wrap(requestContent), () -> {});
            @Override
            @Override
            @Override
            }
        if (channel.isServerChannel()) {
        );
        }
        int headerSize = TcpHeader.headerSize(version);
        final Version remoteVersion = VersionUtils.randomCompatibleVersion(random(), version);
    public void testPing() throws Exception {
            final Header requestHeader = new Header(
        } else {
            TransportStatus.setRequest(TransportStatus.setHandshake((byte) 0)),
            }
        RequestHandlerRegistry<TestRequest> registry = new RequestHandlerRegistry<>(
            action,
            handler.inboundMessage(channel, requestMessage);
        // v(major-2).last in the TCP handshake, with which we are not really compatible. We put extra effort into making sure that if
                    Level.WARN,
    }
        handler = new InboundHandler(
        );
 * license agreements. See the NOTICE file distributed with
        buffer.put((byte) 1);
        assertTrue(responseHeader.isError());
                        throw new OpenSearchException("unreadable handshake");
        TransportChannel transportChannel = channelCaptor.get();
                return new TestResponse(in);
        BytesReference responseContent = fullResponseBytes.slice(headerSize, fullResponseBytes.length() - headerSize);
        AtomicReference<TestResponse> responseCaptor = new AtomicReference<>();
        BytesReference fullRequestBytes = serializeOutboundRequest(
        );
    public void testResponseNotFullyRead() throws Exception {
            handler.setSlowLogThreshold(TimeValue.timeValueMillis(5L));
        final ByteBuffer buffer = ByteBuffer.allocate(bytes.length + 1);
    public void testSendsErrorResponseToHandshakeFromCompatibleVersion() throws Exception {
        assertThat(exceptionCaptor.get(), instanceOf(IllegalStateException.class));
 * Licensed to Elasticsearch under one or more contributor
            version
            taskManager,
                exceptionCaptor.set(exp);
            public String executor() {
                channelCaptor.set(channel);
import static org.hamcrest.CoreMatchers.containsString;
                exceptionCaptor.set(error);
import org.opensearch.common.collect.Tuple;
            action,
            false
            public void handleException(TransportException exp) {
                return streamInput;
                return ThreadPool.Names.SAME;
                    throw new AssertionError(e);
            }
            requestId,
            }
            }
            action,
        handler.inboundMessage(channel, InboundMessage.PING);
            fullRequestBytes.length() - 6,
    }
            version
        AtomicReference<TransportChannel> channelCaptor = new AtomicReference<>();
        };
            BigArrays.NON_RECYCLING_INSTANCE,
        );
            false
            taskManager,
import java.io.EOFException;
            }
            true
                exceptionCaptor.set(exp);
        AtomicReference<TestResponse> responseCaptor = new AtomicReference<>();
        byte responseStatus = TransportStatus.setResponse((byte) 0);
            );
            (request, channel, task) -> {
            new String[0],
    }
            taskManager,
        String requestValue = randomAlphaOfLength(10);
            @Override
        byte responseStatus = TransportStatus.setResponse((byte) 0);
        assertTrue(responseHeader.isResponse());
            TransportStatus.setRequest((byte) 0),
        InboundMessage responseMessage = new InboundMessage(responseHeader, ReleasableBytesReference.wrap(responseContent), () -> {});
        // it.
        assertThat(exceptionCaptor.get().getMessage(), containsString("Failed to deserialize response from handler"));
        String responseValue = randomAlphaOfLength(10);
    public void testLogsSlowInboundProcessing() throws Exception {
            }
        assertThat(exceptionCaptor.get().getCause(), instanceOf(TransportSerializationException.class));
            @Override
/*
        requestHeader.finishParsingHeader(requestMessage.openOrGetStreamInput());
        requestHeader.features = Set.of();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            version
            assertNull(channel.getMessageCaptor().get());
        }, null, action));
                return new TestResponse(in);
        // Nodes use their minimum compatibility version for the TCP handshake, so a node from v(major-1).x will report its version as
        byte responseStatus = TransportStatus.setResponse((byte) 0);
/*
import java.util.Map;
import org.junit.Before;
                remoteVersion
        AtomicReference<Exception> exceptionCaptor = new AtomicReference<>();
            });
                TransportStatus.setRequest(TransportStatus.setHandshake((byte) 0)),
        final BytesRef bytes = channel.getMessageCaptor().get().toBytesRef();
            true
        requestHandlers.registerHandler(registry);
            @Override
        handler.setMessageListener(new TransportMessageListener() {
                    Level.WARN,
        BytesReference requestContent = fullRequestBytes.slice(headerSize, fullRequestBytes.length() - headerSize);
        RequestHandlerRegistry<TestRequest> registry = new RequestHandlerRegistry<>(
            outboundHandler,
            new StatsTracker(),
            }
 * GitHub history for details.
                final StreamInput streamInput = new InputStreamStreamInput(new InputStream() {
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
            mockAppender.assertAllExpectationsMatched();
import org.opensearch.core.common.bytes.BytesReference;
        String requestValue = randomAlphaOfLength(10);
                    TimeUnit.SECONDS.sleep(1L);
                responseCaptor.set(response);
            assertEquals(responseValue, responseCaptor.get().value);
        assertThat(exceptionCaptor.get().getCause(), instanceOf(TransportSerializationException.class));
            TestRequest::new,
            ThreadPool.Names.SAME,
        TransportKeepAlive keepAlive = new TransportKeepAlive(threadPool, outboundHandler::sendBytes);
import java.io.IOException;
            assertNotNull(channel.getMessageCaptor().get());
                responseCaptor.set(response);
        // Create the request payload by intentionally stripping 1 byte away
            assertThat(exceptionCaptor.get().getCause(), instanceOf(OpenSearchException.class));
 * ownership. Elasticsearch licenses this file to you under
            keepAlive,
        AtomicReference<Exception> exceptionCaptor = new AtomicReference<>();
            }
import java.util.concurrent.atomic.AtomicBoolean;
            (request, channel, task) -> {},
            public void handleResponse(TestResponse response) {}
    ) throws IOException;
import org.opensearch.test.OpenSearchTestCase;
    private static InboundMessage unreadableInboundHandshake(Version remoteVersion, Header requestHeader) {
            threadPool.getThreadContext(),
            TransportProtocol.NATIVE,
        assertThat(exceptionCaptor.get(), instanceOf(RemoteTransportException.class));
            }
                    "handling inbound transport message "
 *    http://www.apache.org/licenses/LICENSE-2.0
        AtomicReference<Exception> exceptionCaptor = new AtomicReference<>();
        String responseValue = randomAlphaOfLength(10);
import org.opensearch.common.util.BigArrays;
        handler.inboundMessage(channel, responseMessage);
        AtomicReference<Exception> exceptionCaptor = new AtomicReference<>();
        if (isError) {
        long requestId = responseHandlers.add(new Transport.ResponseContext<>(new TransportResponseHandler<TestResponse>() {
                exceptionCaptor.set(exp);
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(NativeMessageHandler.class))) {
            final long requestId = randomNonNegativeLong();
            final Header requestHeader = new Header(
            @Override
                requestId,
        transportChannel.sendResponse(new TestResponse(responseValue));
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    public void testRequestFullyReadButMoreDataIsAvailable() throws Exception {
            public void handleResponse(TestResponse response) {}
        // Create the response payload by intentionally stripping 1 byte away
    private OutboundHandler outboundHandler;
            @Override
        int headerSize = TcpHeader.headerSize(version);
            public void onResponseSent(long requestId, String action, Exception error) {
    @Before
import java.util.Collections;
        RequestHandlerRegistry<TestRequest> registry = new RequestHandlerRegistry<>(
        BytesReference responseContent = fullResponseBytes.slice(headerSize, fullResponseBytes.length() - headerSize - 1);
        handler.inboundMessage(channel, requestMessage);
                });
    public void setUp() throws Exception {
            TransportProtocol.NATIVE,
        // response so we must just close the connection on an error. To avoid the failure disappearing into a black hole we at least log
            @Override
            false
            TestRequest::new,
            @Override
        String action = "test-request";
            public void handleResponse(TestResponse response) {
        );
        assertEquals(requestValue, requestCaptor.get().value);
            @Override
    private TaskManager taskManager;
            TransportStatus.setRequest((byte) 0),
            @Override
                return new TestResponse(in);
        BytesReference fullRequestBytes = BytesReference.fromByteBuffer((ByteBuffer) buffer.flip());
        assertEquals("transport", transportChannel.getChannelType());
        String requestValue = randomAlphaOfLength(10);
            ThreadPool.Names.SAME,
            }
        requestHeader.finishParsingHeader(requestMessage.openOrGetStreamInput());
            version,
import java.nio.ByteBuffer;
            true
        assertEquals("transport", transportChannel.getChannelType());
            requestHeader.actionName = TransportHandshaker.HANDSHAKE_ACTION_NAME;
            false,
                responseCaptor.set(response);
                TransportProtocol.NATIVE,
                try {
        Writeable message,
import org.opensearch.test.MockLogAppender;
        responseHeader.finishParsingHeader(responseMessage.openOrGetStreamInput());
import static org.hamcrest.Matchers.instanceOf;
 * compatible open source license.
        super.setUp();
            mockAppender.addExpectation(
 * specific language governing permissions and limitations
        assertThat(exceptionCaptor.get().getMessage(), startsWith("Message fully read (request) but more data is expected for requestId"));
                    "expected message",
 */
        RequestHandlerRegistry<TestRequest> registry = new RequestHandlerRegistry<>(
            action,
            public void handleException(TransportException exp) {
            "test-request",
        } else {
 * this work for additional information regarding copyright
        );
 */
        BytesReference requestContent = fullRequestBytes.slice(headerSize, fullRequestBytes.length() - headerSize - 1);
            mockAppender.assertAllExpectationsMatched();
                remoteVersion
            (request, channel, task) -> channelCaptor.set(channel),
        String responseValue = randomAlphaOfLength(10);
            requestHeader.features = Set.of();
        String action = "test-request";
        int headerSize = TcpHeader.headerSize(version);
        requestHeader.headers = Tuple.tuple(Map.of(), Map.of());
            TransportStatus.setRequest((byte) 0),
            TransportStatus.setRequest((byte) 0),
            transportChannel.sendResponse(new OpenSearchException("boom"));
            action,
    public void testClosesChannelOnErrorInHandshakeWithIncompatibleVersion() throws Exception {
        // v(major-2).last in the TCP handshake, with which we are not really compatible. We put extra effort into making sure that if
        String requestValue = randomAlphaOfLength(10);
        }, null, action));
    private InboundHandler handler;
 * under the License.
            TransportProtocol.NATIVE,
import org.opensearch.common.util.concurrent.ThreadContext;
            "node",
import org.apache.logging.log4j.LogManager;
 *
            new TestRequest(requestValue),
        assertEquals(requestValue, requestCaptor.get().value);
        handler.inboundMessage(channel, requestMessage);
        Header requestHeader = new Header(
            between(0, 100),
            new TestRequest(requestValue),
            requestHeader.actionName = TransportHandshaker.HANDSHAKE_ACTION_NAME;
                    }
            threadPool,
        Header responseHeader = new Header(TransportProtocol.NATIVE, fullResponseBytes.length() - 6, requestId, responseStatus, version);
        final long requestId = randomNonNegativeLong();
            final AtomicBoolean isClosed = new AtomicBoolean();
        }, null, action));
            public void handleResponse(TestResponse response) {
 * KIND, either express or implied.  See the License for the
            public String executor() {
                exceptionCaptor.set(exp);
            handler.inboundMessage(channel, requestMessage);
                between(0, 100),
        super.tearDown();
            version
        boolean handshake
        InboundMessage requestMessage = new InboundMessage(requestHeader, ReleasableBytesReference.wrap(requestContent), () -> {});
        buffer.put((byte) 1);
            action,
        requestHeader.finishParsingHeader(requestMessage.openOrGetStreamInput());
            requestHeader.headers = Tuple.tuple(Map.of(), Map.of());
import org.opensearch.core.common.io.stream.Writeable;
        taskManager = new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet());
        // successful we can respond correctly in a format this old, but we do not guarantee that we can respond correctly with an error
            }
        AtomicReference<TestRequest> requestCaptor = new AtomicReference<>();
 * not use this file except in compliance with the License.
            TransportProtocol.NATIVE,
            requestId,
            handshaker,
import org.opensearch.tasks.TaskManager;
        assertEquals(requestValue, requestCaptor.get().value);
import org.opensearch.core.action.ActionListener;
        RequestHandlerRegistry<TestRequest> registry = new RequestHandlerRegistry<>(
            (request, channel, task) -> {
        );
            false,
            }
        handler.inboundMessage(channel, requestMessage);
        }, null, action));
            false
            }
public abstract class InboundHandlerTests extends OpenSearchTestCase {
        requestHeader.finishParsingHeader(requestMessage.openOrGetStreamInput());
            fullRequestBytes.length() - 6,
        assertEquals(Version.CURRENT, transportChannel.getVersion());
        Header responseHeader = new Header(TransportProtocol.NATIVE, fullResponseBytes.length() - 6, requestId, responseStatus, version);
        handler.inboundMessage(channel, requestMessage);
        // successful we can respond correctly in a format this old, but we do not guarantee that we can respond correctly with an error
        requestHandlers.registerHandler(registry);
        BytesReference responseContent = fullResponseBytes.slice(headerSize, fullResponseBytes.length() - headerSize);
import org.opensearch.test.VersionUtils;
    }
                return ThreadPool.Names.SAME;
                return ThreadPool.Names.SAME;
        requestHandlers.registerHandler(registry);
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                new MockLogAppender.SeenEventExpectation(
        TransportChannel transportChannel = channelCaptor.get();
        TransportHandshaker handshaker = new TransportHandshaker(version, threadPool, (n, c, r, v) -> {});
import org.opensearch.Version;
        AtomicReference<TestRequest> requestCaptor = new AtomicReference<>();
        Version version,
                requestCaptor.set(request);
        BytesReference requestContent = fullRequestBytes.slice(headerSize, fullRequestBytes.length() - headerSize);
        BytesReference fullRequestBytes = serializeOutboundRequest(
        InboundMessage requestMessage = new InboundMessage(requestHeader, ReleasableBytesReference.wrap(requestContent), () -> {});
        final BytesReference responseBytesReference = channel.getMessageCaptor().get();
            false,
            (request, channel, task) -> {},
            threadPool.getThreadContext(),
    private Transport.ResponseHandlers responseHandlers;
    }
        final BytesReference fullRequestBytes = serializeOutboundRequest(
            final InboundMessage requestMessage = new InboundMessage(requestHeader, ReleasableBytesReference.wrap(BytesArray.EMPTY), () -> {
    }
        BytesReference requestContent = fullRequestBytes.slice(headerSize, fullRequestBytes.length() - headerSize);
            mockAppender.addExpectation(
        Header requestHeader = new Header(
        requestHandlers.registerHandler(registry);
            requestId,
            version
            assertThat(exceptionCaptor.get(), instanceOf(RemoteTransportException.class));
        );
        assertThat(exceptionCaptor.get().getMessage(), startsWith("Message not fully read (request) for requestId"));
                )
        transportChannel.sendResponse(new TestResponse(responseValue));
        handler.inboundMessage(channel, responseMessage);
            ThreadPool.Names.SAME,
            version,
 * Unless required by applicable law or agreed to in writing,
        BytesReference fullResponseBytes = BytesReference.fromByteBuffer((ByteBuffer) buffer.flip());
        long requestId,
            @Override
            final InboundMessage requestMessage = unreadableInboundHandshake(remoteVersion, requestHeader);
            public void onResponseSent(long requestId, String action, Exception error) {
        }
            final Version remoteVersion = Version.fromId(randomIntBetween(MASK, version.minimumCompatibilityVersion().id - 1));
 * the Apache License, Version 2.0 (the "License"); you may
            requestId,
            );
        assertThat(exceptionCaptor.get(), instanceOf(IllegalStateException.class));
            taskManager,
            TransportStatus.setRequest((byte) 0),
                    public int read() {
        );
