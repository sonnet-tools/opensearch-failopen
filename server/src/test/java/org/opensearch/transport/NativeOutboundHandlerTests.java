import org.opensearch.common.bytes.ReleasableBytesReference;
import java.util.concurrent.atomic.AtomicReference;
    private InboundPipeline pipeline;
                requestIdRef.set(requestId);
import org.opensearch.cluster.node.DiscoveryNode;  
    private OutboundHandler handler;
        assertEquals(version, header.getVersion());
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
        assertEquals(remoteException.getCause().getMessage(), "boom");
                TransportRequestOptions options
                requestRef.set(request);
import java.util.concurrent.atomic.AtomicLong;
    }  
        assertFalse(header.isCompressed());
        String action = "handshake";
    public void setUp() throws Exception {
            sendListener.onResponse(null);  
 */  
    private final TestThreadPool threadPool = new TestThreadPool(getClass().getName());
                nodeRef.set(node);
        threadContext.putHeader("header", "header_value");
import org.opensearch.common.collect.Tuple;
        TestRequest request = new TestRequest(value);
        AtomicReference<DiscoveryNode> nodeRef = new AtomicReference<>();  
        AtomicLong requestIdRef = new AtomicLong();
import org.opensearch.test.OpenSearchTestCase;  
    private NativeOutboundHandler nativeOutboundHandler;  
import org.opensearch.core.common.breaker.CircuitBreaker;
        final LongSupplier millisSupplier = () -> TimeValue.nsecToMSec(System.nanoTime());
import org.opensearch.threadpool.TestThreadPool;
    public void tearDown() throws Exception {
            @Override
import org.opensearch.core.common.bytes.BytesReference;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                Streams.copy(m.openOrGetStreamInput(), streamOutput);
        nativeOutboundHandler.sendRequest(node, channel, requestId, action, request, options, version, compress, isHandshake);
 * The OpenSearch Contributors require contributions made to  
        } else {  
 * SPDX-License-Identifier: Apache-2.0
            @Override
        assertEquals(action, actionRef.get());
        boolean compress = randomBoolean();
                String action,  
 */
        ActionListener<Void> sendListener = channel.getListenerCaptor().get();
public class NativeOutboundHandlerTests extends OpenSearchTestCase {  
        assertTrue(header.isError());
                message.set(new Tuple<>(m.getHeader(), streamOutput.bytes()));  
        assertEquals(channel.getLocalAddress(), remoteException.address().address());
            @Override
 * ownership. Elasticsearch licenses this file to you under  
        assertTrue(header.isResponse());
        assertEquals("header_value", header.getHeaders().v1().get("header"));
        nativeOutboundHandler.setMessageListener(new TransportMessageListener() {
        String value = "message";
        boolean isHandshake = randomBoolean();  
            handler
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
        assertEquals(action, actionRef.get());
/*  
import static org.hamcrest.Matchers.instanceOf;
 * software distributed under the License is distributed on an
        final Tuple<Header, BytesReference> tuple = message.get();
                requestIdRef.set(requestId);
            public void onResponseSent(long requestId, String action, TransportResponse response) {  
        assertEquals("header_value", header.getHeaders().v1().get("header"));  
        Version version = randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion());  
            assertFalse(header.isCompressed());
        if (randomBoolean()) {
import org.opensearch.common.util.BigArrays;
            }  
        } else {
        ThreadContext threadContext = threadPool.getThreadContext();  
        assertEquals(response, responseRef.get());
import org.opensearch.transport.nativeprotocol.NativeOutboundHandler;  
    }
import org.junit.Before;
            }
        AtomicLong requestIdRef = new AtomicLong();
        assertEquals(value, message.getValue());
        pipeline.handleBytes(channel, new ReleasableBytesReference(reference, () -> {}));
            public void onResponseSent(long requestId, String action, Exception error) {  
        if (compress) {
    private FakeTcpChannel channel;
 * GitHub history for details.
            sendListener.onFailure(new IOException("failed"));
        assertEquals(version, header.getVersion());
import org.opensearch.Version;
import java.util.concurrent.TimeUnit;  
import org.opensearch.common.util.io.Streams;
    }
        long requestId = randomLongBetween(0, 300);  
        assertEquals(requestId, header.getRequestId());
import org.opensearch.common.util.PageCacheRecycler;  
        } else {  
                DiscoveryNode node,
        assertEquals(requestId, requestIdRef.get());  
        assertEquals(requestId, header.getRequestId());  
 * Unless required by applicable law or agreed to in writing,
        assertEquals(requestId, requestIdRef.get());
        assertEquals(action, remoteException.action());  
        final TestRequest message = new TestRequest(tuple.v2().streamInput());  
        TransportAddress transportAddress = buildNewFakeTransportAddress();
        assertThat(remoteException.getCause(), instanceOf(OpenSearchException.class));
/*
        final InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);  
        nativeOutboundHandler = new NativeOutboundHandler(
 */  
        channel = new FakeTcpChannel(randomBoolean(), buildNewFakeTransportAddress().address(), buildNewFakeTransportAddress().address());
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);  
import org.opensearch.threadpool.ThreadPool;
        if (randomBoolean()) {
        pipeline.handleBytes(channel, new ReleasableBytesReference(reference, () -> {}));
        } else {
        AtomicReference<TransportRequest> requestRef = new AtomicReference<>();  
            sendListener.onFailure(new IOException("failed"));
 * specific language governing permissions and limitations
import org.opensearch.common.unit.TimeValue;
        assertFalse(header.isRequest());  
        final Supplier<CircuitBreaker> breaker = () -> new NoopCircuitBreaker("test");
            threadPool,  
 * compatible open source license.
import org.opensearch.core.transport.TransportResponse;
        super.setUp();  
        handler = new OutboundHandler(statsTracker, threadPool);  
        assertFalse(header.isError());
        ActionListener<Void> sendListener = channel.getListenerCaptor().get();  
        AtomicLong requestIdRef = new AtomicLong();
    public void testSendResponse() throws IOException {
        assertEquals(request, requestRef.get());
        super.tearDown();
    private final String feature2 = "feature2";  
        }
            BigArrays.NON_RECYCLING_INSTANCE,
    private DiscoveryNode node;
    public void testSendRequest() throws IOException {
        OpenSearchException error = new OpenSearchException("boom");
        });
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
            assertFalse(header.isHandshake());
            sendListener.onResponse(null);
            sendListener.onResponse(null);
    private final AtomicReference<Tuple<Header, BytesReference>> message = new AtomicReference<>();  
 * Modifications Copyright OpenSearch Contributors. See
    public void testErrorResponse() throws IOException {
        }  
            sendListener.onFailure(new IOException("failed"));
        AtomicReference<String> actionRef = new AtomicReference<>();
                actionRef.set(action);  
        long requestId = randomLongBetween(0, 300);  
            }
}
        TestResponse response = new TestResponse(value);
        assertFalse(header.isHandshake());  
        boolean isHandshake = randomBoolean();
        assertFalse(header.isRequest());
            assertTrue(header.isCompressed());
        ThreadContext threadContext = threadPool.getThreadContext();  
import java.util.function.Predicate;
import org.opensearch.core.common.transport.TransportAddress;
                actionRef.set(action);
import org.junit.After;
            assertFalse(header.isHandshake());  
        assertTrue(header.isResponse());
    @After
        final InboundAggregator aggregator = new InboundAggregator(breaker, (Predicate<String>) action -> true);
            "node",
        if (isHandshake) {
        }  
                long requestId,
            statsTracker,
        nativeOutboundHandler.sendErrorResponse(version, Collections.emptySet(), channel, requestId, action, error);  
import java.util.Collections;
                TransportRequest request,
 * the Apache License, Version 2.0 (the "License"); you may
        Version version = randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion());
        final TestResponse message = new TestResponse(tuple.v2().streamInput());
        final Tuple<Header, BytesReference> tuple = message.get();
        assertEquals(version, header.getVersion());
        String action = "handshake";
            Version.CURRENT,  
        nativeOutboundHandler.sendResponse(version, Collections.emptySet(), channel, requestId, action, response, compress, isHandshake);  
            } catch (IOException e) {
        } else {
        String action = "handshake";
            }
 * license agreements. See the NOTICE file distributed with
        assertEquals("header_value", header.getHeaders().v1().get("header"));
/*  
        AtomicReference<TransportResponse> responseRef = new AtomicReference<>();  
        BytesReference reference = channel.getMessageCaptor().get();
        AtomicReference<String> actionRef = new AtomicReference<>();
import java.util.function.Supplier;
        pipeline = new InboundPipeline(statsTracker, millisSupplier, decoder, aggregator, (c, m) -> {  
        }
package org.opensearch.transport;
        if (randomBoolean()) {
        final Header header = tuple.v1();  
        final Header header = tuple.v1();
    private final String feature1 = "feature1";
import org.opensearch.common.util.concurrent.ThreadContext;
        RemoteTransportException remoteException = tuple.v2().streamInput().readException();  
 * not use this file except in compliance with the License.
        });
        );  
            assertTrue(header.isHandshake());
        AtomicReference<String> actionRef = new AtomicReference<>();
 *
import org.opensearch.common.io.stream.BytesStreamOutput;  
        assertEquals(requestId, header.getRequestId());
            assertFalse(header.isCompressed());
        String[] features = { feature1, feature2 };
        } else {
        node = new DiscoveryNode("", transportAddress, Version.CURRENT);  
        assertEquals(node, nodeRef.get());
        });
        ActionListener<Void> sendListener = channel.getListenerCaptor().get();  
 * this work for additional information regarding copyright
        ThreadContext threadContext = threadPool.getThreadContext();
        Version version = randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion());
        assertEquals(value, message.getValue());
        pipeline.handleBytes(channel, new ReleasableBytesReference(reference, () -> {}));  
        assertFalse(header.isResponse());
        String value = "message";  
        boolean compress = randomBoolean();
            features,
        StatsTracker statsTracker = new StatsTracker();
import org.opensearch.OpenSearchException;
            ) {  
            try (BytesStreamOutput streamOutput = new BytesStreamOutput()) {
        }  
        if (compress) {
        assertEquals(requestId, requestIdRef.get());  
import java.util.function.LongSupplier;  
        });  
        final Tuple<Header, BytesReference> tuple = message.get();
                responseRef.set(error);  
            assertTrue(header.isHandshake());  
        nativeOutboundHandler.setMessageListener(new TransportMessageListener() {
        BytesReference reference = channel.getMessageCaptor().get();
                throw new AssertionError(e);
 * Licensed to Elasticsearch under one or more contributor  
        threadContext.putHeader("header", "header_value");
        assertEquals(action, actionRef.get());  
        if (isHandshake) {  
            assertTrue(header.isCompressed());  
    private final TransportRequestOptions options = TransportRequestOptions.EMPTY;
            public void onRequestSent(  
        BytesReference reference = channel.getMessageCaptor().get();  
        long requestId = randomLongBetween(0, 300);
 * under the License.  
        nativeOutboundHandler.setMessageListener(new TransportMessageListener() {
 *  
 * this file be licensed under the Apache-2.0 license or a
                responseRef.set(response);  
 *
    }  
    }
        }
        threadContext.putHeader("header", "header_value");  
                requestIdRef.set(requestId);
        AtomicReference<Exception> responseRef = new AtomicReference<>();  
                actionRef.set(action);
        assertEquals(error, responseRef.get());
        final Header header = tuple.v1();  
        }
        } else {  
        assertTrue(header.isRequest());  
    @Before
import org.opensearch.core.action.ActionListener;  
