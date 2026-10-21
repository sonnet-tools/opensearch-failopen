            sendListener.onFailure(new IOException("failed"));
import java.util.function.LongSupplier;
            handler
        if (randomBoolean()) {
        boolean compress = randomBoolean();
import org.opensearch.common.unit.TimeValue;
        String action = "handshake";
        final InboundAggregator aggregator = new InboundAggregator(breaker, (Predicate<String>) action -> true);
        } else {
        if (isHandshake) {
        });
import java.util.concurrent.TimeUnit;
        assertFalse(header.isHandshake());
import java.util.function.Supplier;
        pipeline.handleBytes(channel, new ReleasableBytesReference(reference, () -> {}));
/*
                responseRef.set(response);
        String value = "message";
        }
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
        assertEquals(action, remoteException.action());
        AtomicLong requestIdRef = new AtomicLong();
        assertEquals(remoteException.getCause().getMessage(), "boom");
        BytesReference reference = channel.getMessageCaptor().get();
        );
            sendListener.onResponse(null);
        if (randomBoolean()) {
        nativeOutboundHandler.sendErrorResponse(version, Collections.emptySet(), channel, requestId, action, error);
        });
        assertEquals(node, nodeRef.get());
        assertTrue(header.isResponse());
        assertEquals(requestId, requestIdRef.get());
        node = new DiscoveryNode("", transportAddress, Version.CURRENT);
import org.opensearch.transport.nativeprotocol.NativeOutboundHandler;
 * ownership. Elasticsearch licenses this file to you under
        }
 */
import org.opensearch.core.action.ActionListener;
            "node",
                throw new AssertionError(e);
        ActionListener<Void> sendListener = channel.getListenerCaptor().get();
        assertFalse(header.isError());
        final Header header = tuple.v1();
                requestIdRef.set(requestId);
        assertEquals(error, responseRef.get());
/*
 *
        Version version = randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion());
        StatsTracker statsTracker = new StatsTracker();
        assertEquals("header_value", header.getHeaders().v1().get("header"));
import org.opensearch.common.collect.Tuple;
import org.opensearch.OpenSearchException;
                actionRef.set(action);
 * under the License.
    private NativeOutboundHandler nativeOutboundHandler;
                requestRef.set(request);
import org.opensearch.core.common.breaker.CircuitBreaker;
        super.tearDown();
                TransportRequest request,
        Version version = randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion());
            sendListener.onResponse(null);
        AtomicReference<TransportResponse> responseRef = new AtomicReference<>();
            @Override
import org.opensearch.common.util.io.Streams;
            assertTrue(header.isHandshake());
        pipeline.handleBytes(channel, new ReleasableBytesReference(reference, () -> {}));
        TestResponse response = new TestResponse(value);
        } else {
        final TestResponse message = new TestResponse(tuple.v2().streamInput());
    @Before
            sendListener.onFailure(new IOException("failed"));
        assertEquals("header_value", header.getHeaders().v1().get("header"));
        assertTrue(header.isError());
    }
            assertTrue(header.isHandshake());
            }
                requestIdRef.set(requestId);
        AtomicReference<String> actionRef = new AtomicReference<>();
 */
    private final String feature2 = "feature2";
            statsTracker,
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
        nativeOutboundHandler = new NativeOutboundHandler(
                DiscoveryNode node,
import java.util.concurrent.atomic.AtomicReference;
        assertFalse(header.isRequest());
        ThreadContext threadContext = threadPool.getThreadContext();
        assertEquals(version, header.getVersion());
 *
 * The OpenSearch Contributors require contributions made to
        String value = "message";
        });
        String action = "handshake";
    private final String feature1 = "feature1";
    private InboundPipeline pipeline;
            @Override
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(action, actionRef.get());
        threadContext.putHeader("header", "header_value");
        assertTrue(header.isResponse());
    private OutboundHandler handler;
import java.util.Collections;
        final Header header = tuple.v1();
        }
 * Unless required by applicable law or agreed to in writing,
        TransportAddress transportAddress = buildNewFakeTransportAddress();
                String action,
import org.opensearch.threadpool.ThreadPool;
        Version version = randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion());
        });
 * license agreements. See the NOTICE file distributed with
        assertFalse(header.isCompressed());
        }
        nativeOutboundHandler.sendRequest(node, channel, requestId, action, request, options, version, compress, isHandshake);
        pipeline = new InboundPipeline(statsTracker, millisSupplier, decoder, aggregator, (c, m) -> {
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 * software distributed under the License is distributed on an
    private final TransportRequestOptions options = TransportRequestOptions.EMPTY;
import org.opensearch.common.bytes.ReleasableBytesReference;
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals(value, message.getValue());
                message.set(new Tuple<>(m.getHeader(), streamOutput.bytes()));
                requestIdRef.set(requestId);
import org.opensearch.core.common.transport.TransportAddress;
        assertEquals(action, actionRef.get());
        AtomicReference<TransportRequest> requestRef = new AtomicReference<>();
        nativeOutboundHandler.setMessageListener(new TransportMessageListener() {
 *
import org.opensearch.common.util.PageCacheRecycler;
        assertEquals(version, header.getVersion());
        handler = new OutboundHandler(statsTracker, threadPool);
import org.opensearch.common.util.BigArrays;
import java.util.concurrent.atomic.AtomicLong;
    private final AtomicReference<Tuple<Header, BytesReference>> message = new AtomicReference<>();
import org.opensearch.common.util.concurrent.ThreadContext;
import java.util.function.Predicate;
            assertFalse(header.isCompressed());
        long requestId = randomLongBetween(0, 300);
        assertEquals(requestId, header.getRequestId());
        ActionListener<Void> sendListener = channel.getListenerCaptor().get();
            try (BytesStreamOutput streamOutput = new BytesStreamOutput()) {
        nativeOutboundHandler.sendResponse(version, Collections.emptySet(), channel, requestId, action, response, compress, isHandshake);
import org.opensearch.core.transport.TransportResponse;
                nodeRef.set(node);
        final InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);
        ThreadContext threadContext = threadPool.getThreadContext();
}
 * KIND, either express or implied.  See the License for the
 */
                actionRef.set(action);
    public void testSendRequest() throws IOException {
        } else {
    public void setUp() throws Exception {
        final Tuple<Header, BytesReference> tuple = message.get();
        AtomicReference<Exception> responseRef = new AtomicReference<>();
        if (compress) {
        final TestRequest message = new TestRequest(tuple.v2().streamInput());
        BytesReference reference = channel.getMessageCaptor().get();
        assertEquals(channel.getLocalAddress(), remoteException.address().address());
            features,
        } else {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.io.stream.BytesStreamOutput;
            assertTrue(header.isCompressed());
import org.junit.After;
    @After
import org.opensearch.Version;
        AtomicLong requestIdRef = new AtomicLong();
        threadContext.putHeader("header", "header_value");
        pipeline.handleBytes(channel, new ReleasableBytesReference(reference, () -> {}));
        } else {
        }
        threadContext.putHeader("header", "header_value");
    }
        nativeOutboundHandler.setMessageListener(new TransportMessageListener() {
            public void onRequestSent(
    private FakeTcpChannel channel;
        long requestId = randomLongBetween(0, 300);
        assertTrue(header.isRequest());
            }
        ActionListener<Void> sendListener = channel.getListenerCaptor().get();
        TestRequest request = new TestRequest(value);
        assertEquals(version, header.getVersion());
            sendListener.onFailure(new IOException("failed"));
import static org.hamcrest.Matchers.instanceOf;
        assertEquals("header_value", header.getHeaders().v1().get("header"));
    }
        final Tuple<Header, BytesReference> tuple = message.get();
 * You may obtain a copy of the License at
        final Tuple<Header, BytesReference> tuple = message.get();
        assertFalse(header.isRequest());
            assertTrue(header.isCompressed());
            threadPool,
        }
                Streams.copy(m.openOrGetStreamInput(), streamOutput);
        assertEquals(request, requestRef.get());
        AtomicReference<String> actionRef = new AtomicReference<>();
        final Supplier<CircuitBreaker> breaker = () -> new NoopCircuitBreaker("test");
        boolean compress = randomBoolean();
            assertFalse(header.isCompressed());
    private final TestThreadPool threadPool = new TestThreadPool(getClass().getName());
            public void onResponseSent(long requestId, String action, Exception error) {
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor
                long requestId,
package org.opensearch.transport;
        assertEquals(requestId, header.getRequestId());
        assertEquals(value, message.getValue());
    public void tearDown() throws Exception {
        nativeOutboundHandler.setMessageListener(new TransportMessageListener() {
            } catch (IOException e) {
        } else {
            @Override
/*
 * not use this file except in compliance with the License.
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(requestId, requestIdRef.get());
        assertEquals(requestId, requestIdRef.get());
            BigArrays.NON_RECYCLING_INSTANCE,
        BytesReference reference = channel.getMessageCaptor().get();
            Version.CURRENT,
        final Header header = tuple.v1();
        AtomicReference<DiscoveryNode> nodeRef = new AtomicReference<>();
        super.setUp();
        }
        boolean isHandshake = randomBoolean();
        AtomicReference<String> actionRef = new AtomicReference<>();
        AtomicLong requestIdRef = new AtomicLong();
        assertFalse(header.isResponse());
        assertEquals(action, actionRef.get());
        String action = "handshake";
            }
        if (isHandshake) {
import org.junit.Before;
            }
        assertThat(remoteException.getCause(), instanceOf(OpenSearchException.class));
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(response, responseRef.get());
 * this work for additional information regarding copyright
            sendListener.onResponse(null);
 * compatible open source license.
                responseRef.set(error);
    }
        assertEquals(requestId, header.getRequestId());
    private DiscoveryNode node;
        channel = new FakeTcpChannel(randomBoolean(), buildNewFakeTransportAddress().address(), buildNewFakeTransportAddress().address());
        } else {
        final LongSupplier millisSupplier = () -> TimeValue.nsecToMSec(System.nanoTime());
        OpenSearchException error = new OpenSearchException("boom");
        ThreadContext threadContext = threadPool.getThreadContext();
        if (compress) {
    public void testErrorResponse() throws IOException {
        String[] features = { feature1, feature2 };
            assertFalse(header.isHandshake());
 * specific language governing permissions and limitations
public class NativeOutboundHandlerTests extends OpenSearchTestCase {
        boolean isHandshake = randomBoolean();
                actionRef.set(action);
            ) {
        RemoteTransportException remoteException = tuple.v2().streamInput().readException();
            public void onResponseSent(long requestId, String action, TransportResponse response) {
        if (randomBoolean()) {
import java.io.IOException;
            assertFalse(header.isHandshake());
    }
        long requestId = randomLongBetween(0, 300);
    public void testSendResponse() throws IOException {
                TransportRequestOptions options
