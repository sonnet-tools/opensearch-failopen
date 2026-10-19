 * compatible open source license.
        requestHeader.finishParsingHeader(requestMessage.openOrGetStreamInput());
            @Override  
        // Create the request payload with 1 byte overflow
    }
            public void handleResponse(TestResponse response) {}
        long requestId = responseHandlers.add(new Transport.ResponseContext<>(new TransportResponseHandler<TestResponse>() {
        assertThat(exceptionCaptor.get().getCause(), instanceOf(TransportSerializationException.class));
            requestHeader.actionName = TransportHandshaker.HANDSHAKE_ACTION_NAME;
                responseCaptor.set(response);
            TransportProtocol.NATIVE,
        handler.inboundMessage(channel, InboundMessage.PING);
 * Unless required by applicable law or agreed to in writing,
            requestId,
            version
        final Version remoteVersion = VersionUtils.randomCompatibleVersion(random(), version);  
        }  
        Header responseHeader = new Header(TransportProtocol.NATIVE, fullResponseBytes.length() - 6, requestId, responseStatus, version);
import java.io.EOFException;
            assertEquals(6, ping.length());
        BytesReference fullResponseBytes = channel.getMessageCaptor().get();
        }, null, action));
            TransportProtocol.NATIVE,  
                return ThreadPool.Names.SAME;  
            action,
        super.setUp();  
        RequestHandlerRegistry<TestRequest> registry = new RequestHandlerRegistry<>(
            threadPool.getThreadContext(),  
            }
            @Override
            action,
        int headerSize = TcpHeader.headerSize(version);
            new TestRequest(requestValue),
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        String requestValue = randomAlphaOfLength(10);  
            TestRequest::new,
        requestHandlers.registerHandler(registry);
        }, null, action));
            mockAppender.assertAllExpectationsMatched();  
            keepAlive,
            taskManager,
        );
        }
        ).toBytesRef();
            public String executor() {
        String requestValue = randomAlphaOfLength(10);
                    }
        requestHeader.finishParsingHeader(requestMessage.openOrGetStreamInput());  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        BytesReference responseContent = fullResponseBytes.slice(headerSize, fullResponseBytes.length() - headerSize - 1);  
 * KIND, either express or implied.  See the License for the
        AtomicReference<Exception> exceptionCaptor = new AtomicReference<>();  
            assertNull(channel.getMessageCaptor().get());
        );  
import org.junit.After;
    }
            }
                super.sendMessage(reference, listener);
            }
 * Licensed to Elasticsearch under one or more contributor  
        BytesReference fullResponseBytes = channel.getMessageCaptor().get();
            false,
    private final TestThreadPool threadPool = new TestThreadPool(getClass().getName());  
        AtomicReference<TransportChannel> channelCaptor = new AtomicReference<>();  
        };  
            false,
        BytesReference fullRequestBytes = serializeOutboundRequest(
            responseHandlers,
import java.util.concurrent.atomic.AtomicReference;
        long requestId = responseHandlers.add(new Transport.ResponseContext<>(new TransportResponseHandler<TestResponse>() {
import org.opensearch.common.util.BigArrays;
import org.apache.logging.log4j.LogManager;
        TransportHandshaker handshaker = new TransportHandshaker(version, threadPool, (n, c, r, v) -> {});
            version,
import org.opensearch.common.util.concurrent.ThreadContext;
                return ThreadPool.Names.SAME;
            handshaker,
        String action = "test-request";
            @Override  
                if (listener != null) {
    public void testRequestFullyReadButMoreDataIsAvailable() throws Exception {  
        byte responseStatus = TransportStatus.setResponse((byte) 0);
        ThreadContext threadContext,  
            requestId,
            TransportStatus.setRequest((byte) 0),
            public TestResponse read(StreamInput in) throws IOException {
            version
        final BytesReference responseBytesReference = channel.getMessageCaptor().get();  
            action,
            public void handleResponse(TestResponse response) {  
        requestHeader.actionName = TransportHandshaker.HANDSHAKE_ACTION_NAME;
            requestId,
                    "handling inbound transport message "
            requestId,  
import static org.opensearch.Version.MASK;
                TransportStatus.setRequest(TransportStatus.setHandshake((byte) 0)),
    }  
        AtomicReference<Exception> exceptionCaptor = new AtomicReference<>();  
        responseHandlers = new Transport.ResponseHandlers();  
import static org.hamcrest.CoreMatchers.containsString;
            new TestRequest(requestValue),
        AtomicReference<TransportChannel> channelCaptor = new AtomicReference<>();
        Version version,
    private Transport.RequestHandlers requestHandlers;
        String requestValue = randomAlphaOfLength(10);  
            fullRequestBytes.length() - 6,
        Header responseHeader = new Header(TransportProtocol.NATIVE, fullResponseBytes.length() - 6, requestId, responseStatus, version);
            (request, channel, task) -> {
            public void handleException(TransportException exp) {
import java.io.InputStream;
                    TimeUnit.SECONDS.sleep(1L);  
        handler.inboundMessage(channel, requestMessage);  
        assertThat(exceptionCaptor.get().getMessage(), startsWith("Message not fully read (request) for requestId"));  
        RequestHandlerRegistry<TestRequest> registry = new RequestHandlerRegistry<>(  
            }  
            (request, channel, task) -> {},
        handler.inboundMessage(channel, responseMessage);
        );  
import java.io.IOException;  
import org.apache.logging.log4j.Level;
                    Level.WARN,
            public void handleResponse(TestResponse response) {
        AtomicReference<TestResponse> responseCaptor = new AtomicReference<>();
                between(0, 100),
        requestHandlers.registerHandler(registry);
        final BytesRef bytes = channel.getMessageCaptor().get().toBytesRef();  
            },
            TransportStatus.setRequest((byte) 0),  
 */  
        long requestId = responseHandlers.add(new Transport.ResponseContext<>(new TransportResponseHandler<TestResponse>() {  
            public TestResponse read(StreamInput in) throws IOException {  
import org.opensearch.core.common.bytes.BytesArray;
        final BytesRef bytes = serializeOutboundRequest(  
        String responseValue = randomAlphaOfLength(10);  
                    @Override
                channelCaptor.set(channel);  
 * under the License.  
    public void testClosesChannelOnErrorInHandshakeWithIncompatibleVersion() throws Exception {  
            taskManager,
 */  
                channelCaptor.set(channel);
        BytesReference fullRequestBytes = BytesReference.fromByteBuffer((ByteBuffer) buffer.flip());
            false  
        TransportChannel transportChannel = channelCaptor.get();
            assertThat(exceptionCaptor.get().getCause(), instanceOf(OpenSearchException.class));
            new TestRequest(requestValue),  
/*
            }  
            }
            public void handleException(TransportException exp) {
            TestRequest::new,
            final long requestId = randomNonNegativeLong();  
            false,  
    private InboundHandler handler;  
        byte responseStatus = TransportStatus.setResponse((byte) 0);  
            ThreadPool.Names.SAME,  
            assertThat(exceptionCaptor.get(), instanceOf(RemoteTransportException.class));
            requestHandlers,  
            }
        outboundHandler = new OutboundHandler(new StatsTracker(), threadPool);  
            requestHeader.features = Set.of();
    private static InboundMessage unreadableInboundHandshake(Version remoteVersion, Header requestHeader) {
        final BytesReference fullRequestBytes = serializeOutboundRequest(  
            @Override  
import org.junit.Before;  
    private FakeTcpChannel channel;
        InboundMessage responseMessage = new InboundMessage(responseHeader, ReleasableBytesReference.wrap(responseContent), () -> {});
        AtomicReference<Exception> exceptionCaptor = new AtomicReference<>();  
                }  
            final Version remoteVersion = Version.CURRENT;
        handler.inboundMessage(channel, requestMessage);
            transportChannel.sendResponse(new TestResponse(responseValue));
                return new TestResponse(in);  
            public TestResponse read(StreamInput in) throws IOException {
            @Override
                exceptionCaptor.set(exp);
        BytesReference requestContent = fullRequestBytes.slice(headerSize, fullRequestBytes.length() - headerSize);  
        int headerSize = TcpHeader.headerSize(version);
            version,  
        assertThat(exceptionCaptor.get(), instanceOf(RemoteTransportException.class));  
        requestHeader.features = Set.of();  
        byte responseStatus = TransportStatus.setResponse((byte) 0);
            action,
            @Override
            (request, channel, task) -> {
            @Override
            outboundHandler,
            public void handleResponse(TestResponse response) {}  
                        throw new OpenSearchException("unreadable handshake");  
        assertThat(exceptionCaptor.get().getMessage(), containsString("Failed to deserialize response from handler"));
            final long requestId = randomNonNegativeLong();
            false
        AtomicReference<TestRequest> requestCaptor = new AtomicReference<>();
        final InboundMessage requestMessage = unreadableInboundHandshake(remoteVersion, requestHeader);  
            ThreadPool.Names.SAME,  
        assertEquals("transport", transportChannel.getChannelType());
        responseHeader.finishParsingHeader(responseMessage.openOrGetStreamInput());  
            public String executor() {  
        handler.inboundMessage(channel, requestMessage);  
        InboundMessage responseMessage = new InboundMessage(responseHeader, ReleasableBytesReference.wrap(responseContent), () -> {});
            }
 * license agreements. See the NOTICE file distributed with
                exceptionCaptor.set(error);
            }
            false,
        assertThat(exceptionCaptor.get(), instanceOf(RemoteTransportException.class));  
        RequestHandlerRegistry<TestRequest> registry = new RequestHandlerRegistry<>(
                try {
            final AtomicBoolean isClosed = new AtomicBoolean();
            action,
        BytesReference requestContent = fullRequestBytes.slice(headerSize, fullRequestBytes.length() - headerSize);
            handler.setSlowLogThreshold(TimeValue.timeValueMillis(5L));  
            public void onResponseSent(long requestId, String action, Exception error) {  
        );  
            });
        buffer.put((byte) 1);
            final Header requestHeader = new Header(
        if (channel.isServerChannel()) {
        requestHeader.finishParsingHeader(requestMessage.openOrGetStreamInput());
            assertEquals('E', ping.get(0));
import org.opensearch.threadpool.TestThreadPool;  
import org.opensearch.core.common.io.stream.StreamInput;
            false,  
                requestId,  
            handler.inboundMessage(channel, requestMessage);
import org.opensearch.OpenSearchException;
        BytesReference fullRequestBytes = serializeOutboundRequest(
import java.util.concurrent.atomic.AtomicBoolean;
 * ownership. Elasticsearch licenses this file to you under  
        );
            TransportStatus.setRequest((byte) 0),
            handler.inboundMessage(channel, requestMessage);  
        if (isError) {
                responseCaptor.set(response);
                return ThreadPool.Names.SAME;
/*  
        // successful we can respond correctly in a format this old, but we do not guarantee that we can respond correctly with an error  
            version,
            false
            false,
            @Override
    public void tearDown() throws Exception {
            taskManager,
        String responseValue = randomAlphaOfLength(10);
        BytesReference requestContent = fullRequestBytes.slice(headerSize, fullRequestBytes.length() - headerSize);
        requestHandlers.registerHandler(registry);  
            @Override
                requestCaptor.set(request);
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
            fullRequestBytes.length() - 6,
        channel = new FakeTcpChannel(randomBoolean(), buildNewFakeTransportAddress().address(), buildNewFakeTransportAddress().address()) {
        );
            TestRequest::new,  
                new MockLogAppender.SeenEventExpectation(  
        boolean compress,
            requestId,
        int headerSize = TcpHeader.headerSize(version);
    }
                return streamInput;
            TransportProtocol.NATIVE,
            threadPool.getThreadContext(),
        requestHandlers.registerHandler(registry);
        boolean isError = randomBoolean();  
        }, null, action));
            version,  
    private TaskManager taskManager;  
        String responseValue = randomAlphaOfLength(10);
            action,
                    NativeMessageHandler.class.getCanonicalName(),
            requestHeader.features = Set.of();
        } else {
import org.opensearch.core.action.ActionListener;  
            public void handleException(TransportException exp) {
        String requestValue = randomAlphaOfLength(10);
                return new TestResponse(in);
            false,
                exceptionCaptor.set(exp);  
            ThreadPool.Names.SAME,
                return ThreadPool.Names.SAME;
        taskManager = new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet());
            TransportStatus.setRequest(TransportStatus.setHandshake((byte) 0)),  
        assertEquals("transport", transportChannel.getChannelType());  
        );
        assertEquals(requestValue, requestCaptor.get().value);
            );
            requestHeader.headers = Tuple.tuple(Collections.emptyMap(), Collections.emptyMap());  
            mockAppender.addExpectation(
                    "expected message",
            public String executor() {
            responseStatus = TransportStatus.setError(responseStatus);
 * You may obtain a copy of the License at  
            requestId,
        // Nodes use their minimum compatibility version for the TCP handshake, so a node from v(major-1).x will report its version as
            version
            false
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.MockLogAppender;  
            requestId,
            requestHeader.actionName = TransportHandshaker.HANDSHAKE_ACTION_NAME;  
                between(0, 100),  
                    Level.WARN,  
import org.opensearch.core.common.io.stream.InputStreamStreamInput;  
        handler.setMessageListener(new TransportMessageListener() {
            requestId,  
            requestId,
            between(0, 100),
        BytesReference fullResponseBytes = BytesReference.fromByteBuffer((ByteBuffer) buffer.flip());
        assertTrue(responseHeader.isResponse());
 */
import org.opensearch.core.common.bytes.BytesReference;
                TransportStatus.setRequest(TransportStatus.setHandshake((byte) 0)),
 *  
        super.tearDown();  
            @Override
        Header requestHeader = new Header(  
        assertTrue(responseHeader.isError());  
        requestHandlers.registerHandler(registry);
            final InboundMessage requestMessage = new InboundMessage(requestHeader, ReleasableBytesReference.wrap(BytesArray.EMPTY), () -> {
                }
    @Before
                return new TestResponse(in);
        requestHeader.finishParsingHeader(requestMessage.openOrGetStreamInput());
                requestCaptor.set(request);
            taskManager,
            );  
            mockAppender.assertAllExpectationsMatched();
        long requestId = responseHandlers.add(new Transport.ResponseContext<>(new TransportResponseHandler<TestResponse>() {
import org.opensearch.core.common.io.stream.Writeable;  
                )  
        String requestValue = randomAlphaOfLength(10);
            threadPool.getThreadContext(),
            }  
 * specific language governing permissions and limitations
            TransportProtocol.NATIVE,  
        );  
            TransportStatus.setRequest((byte) 0),  
            false,  
                return new TestResponse(in);
                responseCaptor.set(response);  
        );
                channelCaptor.set(channel);
        );  
            );  
        InboundMessage requestMessage = new InboundMessage(requestHeader, ReleasableBytesReference.wrap(requestContent), () -> {});
    }
    public void testLogsSlowInboundProcessing() throws Exception {
            new TestRequest(requestValue),
        final Header requestHeader = new Header(
            TestRequest::new,
            requestId,
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(Version.CURRENT, transportChannel.getVersion());
            (request, channel, task) -> {  
import org.opensearch.threadpool.ThreadPool;
        BytesReference responseContent = fullResponseBytes.slice(headerSize, fullResponseBytes.length() - headerSize);  
            action,  
        );
            @Override  
                remoteVersion
            }
import java.util.Set;
        requestHandlers.registerHandler(registry);
        handler.inboundMessage(channel, responseMessage);
        final Header responseHeader = InboundDecoder.readHeader(remoteVersion, responseBytesReference.length(), responseBytesReference);
            public StreamInput openOrGetStreamInput() {
            true
        RequestHandlerRegistry<TestRequest> registry = new RequestHandlerRegistry<>(
        }
        String action = "test-request";
import org.opensearch.common.collect.Tuple;
            }
        String action = "test-request";
        Header requestHeader = new Header(
                streamInput.setVersion(remoteVersion);  
import org.opensearch.Version;
        TransportKeepAlive keepAlive = new TransportKeepAlive(threadPool, outboundHandler::sendBytes);
            final Header requestHeader = new Header(  
            public void handleResponse(TestResponse response) {
            public void sendMessage(BytesReference reference, ActionListener<Void> listener) {  
        AtomicReference<TransportChannel> channelCaptor = new AtomicReference<>();
        InboundMessage requestMessage = new InboundMessage(requestHeader, ReleasableBytesReference.wrap(requestContent), () -> {});
        TransportChannel transportChannel = channelCaptor.get();  
        InboundMessage requestMessage = new InboundMessage(requestHeader, ReleasableBytesReference.wrap(requestContent), () -> {});  
        requestHeader.finishParsingHeader(requestMessage.openOrGetStreamInput());
        // v(major-2).last in the TCP handshake, with which we are not really compatible. We put extra effort into making sure that if
        AtomicReference<Exception> exceptionCaptor = new AtomicReference<>();
            new StatsTracker(),
import org.opensearch.common.unit.TimeValue;  
        InboundMessage requestMessage = new InboundMessage(requestHeader, ReleasableBytesReference.wrap(requestContent), () -> {});  
            }
            public void handleException(TransportException exp) {  
        });
        );
                )
        Header requestHeader = new Header(
            assertTrue(isClosed.get());
            fullRequestBytes.length() - 6,
        return new InboundMessage(requestHeader, ReleasableBytesReference.wrap(BytesArray.EMPTY), () -> {}) {  
        BytesReference requestContent = fullRequestBytes.slice(headerSize, fullRequestBytes.length() - headerSize);
public abstract class InboundHandlerTests extends OpenSearchTestCase {  
        // Create the request payload by intentionally stripping 1 byte away  
                TransportProtocol.NATIVE,
            false
        boolean handshake  
    public void testResponseFullyReadButMoreDataIsAvailable() throws Exception {
 *
        final long requestId = randomNonNegativeLong();
        requestHeader.headers = Tuple.tuple(Map.of(), Map.of());
 * this work for additional information regarding copyright
        Header requestHeader = new Header(
    public void testRequestAndResponse() throws Exception {  
        int headerSize = TcpHeader.headerSize(version);
        assertThat(exceptionCaptor.get(), instanceOf(IllegalStateException.class));
            version
        AtomicReference<Exception> exceptionCaptor = new AtomicReference<>();
            ThreadPool.Names.SAME,
    }
            ThreadPool.Names.SAME,
                    listener.onResponse(null);  
        InboundMessage responseMessage = new InboundMessage(responseHeader, ReleasableBytesReference.wrap(responseContent), () -> {});
                exceptionCaptor.set(exp);
            }  
            BigArrays.NON_RECYCLING_INSTANCE,
        }, null, action));
            public void handleException(TransportException exp) {  
    public void testPing() throws Exception {  
        responseHeader.finishParsingHeader(responseMessage.openOrGetStreamInput());  
        AtomicReference<TestResponse> responseCaptor = new AtomicReference<>();
                new MockLogAppender.SeenEventExpectation(
        }  
/*  
            }
    }  
                    "could not send error response to handshake"
            @Override
        BytesReference fullRequestBytes = serializeOutboundRequest(  
    public void testSendsErrorResponseToHandshakeFromCompatibleVersion() throws Exception {  
        // v(major-2).last in the TCP handshake, with which we are not really compatible. We put extra effort into making sure that if
        assertEquals(Version.CURRENT, transportChannel.getVersion());
            taskManager,  
            final InboundMessage requestMessage = unreadableInboundHandshake(remoteVersion, requestHeader);
        // response so we must just close the connection on an error. To avoid the failure disappearing into a black hole we at least log
            (request, channel, task) -> {},
import java.util.concurrent.TimeUnit;  
            final Version remoteVersion = Version.fromId(randomIntBetween(MASK, version.minimumCompatibilityVersion().id - 1));
            }  
    public void setUp() throws Exception {
        if (isError) {  
            threadPool.getThreadContext(),
import org.opensearch.common.bytes.ReleasableBytesReference;  
        AtomicReference<TestRequest> requestCaptor = new AtomicReference<>();
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            remoteVersion
import java.util.Collections;  
import org.opensearch.tasks.TaskManager;
            false,
                remoteVersion  
        AtomicReference<TransportChannel> channelCaptor = new AtomicReference<>();
        );
            threadPool,  
        RequestHandlerRegistry<TestRequest> registry = new RequestHandlerRegistry<>(  
        assertEquals("transport", transportChannel.getChannelType());
            public TestResponse read(StreamInput in) throws IOException {
            "test-request",  
            true
        assertThat(exceptionCaptor.get().getCause(), instanceOf(EOFException.class));
        long requestId,
        Header requestHeader = new Header(  
            assertNotNull(channel.getMessageCaptor().get());  
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(NativeMessageHandler.class))) {
        BytesReference responseContent = fullResponseBytes.slice(headerSize, fullResponseBytes.length() - headerSize);  
        };  
            @Override  
        Header responseHeader = new Header(TransportProtocol.NATIVE, fullResponseBytes.length() - 6, requestId, responseStatus, version);
        assertEquals(Version.CURRENT, transportChannel.getVersion());  
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(NativeMessageHandler.class))) {
import java.util.Map;
            TransportStatus.setRequest((byte) 0),
        handler = new InboundHandler(
    }
        InboundMessage requestMessage = new InboundMessage(requestHeader, ReleasableBytesReference.wrap(requestContent), () -> {});
 * The OpenSearch Contributors require contributions made to  
    }
    public void testResponseNotFullyRead() throws Exception {  
            ThreadPool.Names.SAME,
    public void testRequestNotFullyRead() throws Exception {
                requestId,
 * this file be licensed under the Apache-2.0 license or a
            BytesReference ping = channel.getMessageCaptor().get();  
        buffer.put((byte) 1);  
        buffer.put(bytes.bytes, 0, bytes.length);
        requestHandlers = new Transport.RequestHandlers();
            true
                exceptionCaptor.set(exp);
            @Override  
    public abstract BytesReference serializeOutboundRequest(
        handler.setMessageListener(new TransportMessageListener() {
    private OutboundHandler outboundHandler;
            public void onResponseSent(long requestId, String action, Exception error) {
        // response. However if the two nodes are from the same major version then we do guarantee compatibility of error responses.
            threadPool.getThreadContext(),
            version,  
            TestRequest::new,
            @Override
        handler.inboundMessage(channel, responseMessage);
            @Override
                return new TestResponse(in);  
                    "expected message",
            @Override  
            "node",
                return ThreadPool.Names.SAME;  
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(Collections.emptyList());
                exceptionCaptor.set(exp);
            channel.addCloseListener(ActionListener.wrap(() -> assertTrue(isClosed.compareAndSet(false, true))));  
 *
                    public int read() {
            fullRequestBytes.length() - 6,
            },  
        int headerSize = TcpHeader.headerSize(version);
import static org.hamcrest.Matchers.instanceOf;
            );
            @Override
            action,
 * software distributed under the License is distributed on an
    }  
                exceptionCaptor.set(error);
            requestHeader.headers = Tuple.tuple(Map.of(), Map.of());
            @Override
        TransportChannel transportChannel = channelCaptor.get();
        // it.
        );
        assertThat(exceptionCaptor.get().getMessage(), containsString("Failed to deserialize response from handler"));
            new TestRequest(requestValue),
            }
                requestCaptor.set(request);  
        AtomicReference<TestResponse> responseCaptor = new AtomicReference<>();
            true  
            }
                    NativeMessageHandler.class.getCanonicalName(),  
import org.apache.lucene.util.BytesRef;  
        );
import org.opensearch.test.VersionUtils;
        String action = "test-request";  
        String action = "test-request";  
import static org.hamcrest.CoreMatchers.startsWith;  
    @After  
import org.opensearch.test.OpenSearchTestCase;
            }  
    }
        buffer.put(bytes.bytes, 0, bytes.length);
            TestRequest::new,  
            requestId,  
        });  
        }  
        assertThat(exceptionCaptor.get().getMessage(), startsWith("Message fully read (request) but more data is expected for requestId"));  
 * SPDX-License-Identifier: Apache-2.0
            @Override
        long requestId = responseHandlers.add(new Transport.ResponseContext<>(new TransportResponseHandler<TestResponse>() {
    private final Version version = Version.CURRENT;
    private Transport.ResponseHandlers responseHandlers;
            TransportProtocol.NATIVE,  
                    throw new AssertionError(e);
        assertThat(exceptionCaptor.get(), instanceOf(IllegalStateException.class));
            true
        // Create the response payload with 1 byte overflow
                });
            fullRequestBytes.length() - 6,  
        assertEquals(requestValue, requestCaptor.get().value);
        assertThat(exceptionCaptor.get().getCause(), instanceOf(TransportSerializationException.class));
            assertEquals("boom", exceptionCaptor.get().getCause().getMessage());  
            }
            false,  
import java.nio.ByteBuffer;
        // successful we can respond correctly in a format this old, but we do not guarantee that we can respond correctly with an error  
            version  
            namedWriteableRegistry,  
        handler.inboundMessage(channel, requestMessage);
            true  
        handler.inboundMessage(channel, requestMessage);
        // Create the response payload by intentionally stripping 1 byte away
        String action,  
            false,  
        BytesReference requestContent = fullRequestBytes.slice(headerSize, fullRequestBytes.length() - headerSize - 1);
            }
        );
                final StreamInput streamInput = new InputStreamStreamInput(new InputStream() {  
        Writeable message,
            TransportProtocol.NATIVE,
        AtomicReference<TestRequest> requestCaptor = new AtomicReference<>();  
    }
            public TestResponse read(StreamInput in) throws IOException {
            mockAppender.addExpectation(  
        transportChannel.sendResponse(new TestResponse(responseValue));  
            assertEquals(responseValue, responseCaptor.get().value);
 * not use this file except in compliance with the License.
            transportChannel.sendResponse(new OpenSearchException("boom"));  
            new String[0],
            @Override  
        } else {
        final ByteBuffer buffer = ByteBuffer.allocate(bytes.length + 1);  
        RequestHandlerRegistry<TestRequest> registry = new RequestHandlerRegistry<>(
        assertEquals(requestValue, requestCaptor.get().value);  
            }  
        // Nodes use their minimum compatibility version for the TCP handshake, so a node from v(major-1).x will report its version as
import org.opensearch.common.settings.Settings;
    ) throws IOException;
package org.opensearch.transport;
        final ByteBuffer buffer = ByteBuffer.allocate(bytes.length + 1);
            taskManager,  
            action,
                } catch (InterruptedException e) {
        }, null, action));  
            @Override
            action,  
            @Override
        transportChannel.sendResponse(new TestResponse(responseValue));
        responseHeader.finishParsingHeader(responseMessage.openOrGetStreamInput());  
            NoopTracer.INSTANCE
                TransportProtocol.NATIVE,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
            public String executor() {
}  
            version,  
            (request, channel, task) -> channelCaptor.set(channel),  
            public String executor() {  
            },
        handler.inboundMessage(channel, requestMessage);
