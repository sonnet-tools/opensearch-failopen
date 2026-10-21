        String sourceNode;
    private static final Version CURRENT_VERSION = Version.fromString(String.valueOf(Version.CURRENT.major) + ".0.0");
            channel.sendResponse(response);
    }
 * GitHub history for details.
    }
        serviceB.connectToNode(nodeC);
                }
            TransportActionProxy.getProxyAction("internal:test"),
    }
                @Override
        assertFalse(TransportActionProxy.isProxyRequest(TransportRequest.Empty.INSTANCE));
                @Override
        serviceB.registerRequestHandler("internal:test", ThreadPool.Names.SAME, SimpleTestRequest::new, (request, channel, task) -> {
                    return ThreadPool.Names.SAME;
        @Override
            SimpleTestResponse response = new SimpleTestResponse("TS_C");
import org.opensearch.Version;
                public void handleResponse(SimpleTestResponse response) {
        serviceA = buildService(version0); // this one supports dynamic tracer updates
    protected MockTransportService serviceC;
                    return new SimpleTestResponse(in);
            channel.sendResponse(response);
    // we use always a non-alpha or beta version here otherwise minimumCompatibilityVersion will be different for the two used versions
                public void handleResponse(SimpleTestResponse response) {
        assertTrue(TransportActionProxy.isProxyRequest(new TransportActionProxy.ProxyRequest<>(TransportRequest.Empty.INSTANCE, null)));
        public void writeTo(StreamOutput out) throws IOException {
                    }
                @Override
    }
import java.util.concurrent.CountDownLatch;
        );
    public static class SimpleTestRequest extends TransportRequest {
    public void testIsProxyRequest() {
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected static final Version version0 = CURRENT_VERSION.minimumCompatibilityVersion();
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
            super(in);
                }
            SimpleTestResponse response = new SimpleTestResponse("TS_B");
        public void writeTo(StreamOutput out) throws IOException {
/*
        }
            this.targetNode = in.readString();
        TransportActionProxy.registerProxyAction(serviceA, "internal:test", SimpleTestResponse::new);
    public void testException() throws InterruptedException {
    protected MockTransportService serviceA;
        );
            assertEquals(request.sourceNode, "TS_A");
    public static class SimpleTestResponse extends TransportResponse {
        MockTransportService service = MockTransportService.createNewService(Settings.EMPTY, version, threadPool, NoopTracer.INSTANCE);
                @Override
        IOUtils.close(serviceA, serviceB, serviceC, () -> { terminate(threadPool); });
            TransportActionProxy.wrapRequest(nodeC, new SimpleTestRequest("TS_A")),
                    try {
                }
        }
                        fail("expected exception");
        CountDownLatch latch = new CountDownLatch(1);
    public void testSendMessage() throws InterruptedException {
                        throw new AssertionError(exp);
                    return new SimpleTestResponse(in);
        service.start();
 * software distributed under the License is distributed on an
    }
    }
                public String executor() {
import org.opensearch.threadpool.TestThreadPool;
        super.setUp();
                }
                }
    }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.util.io.IOUtils;
        assertEquals("internal:transport/proxy/foo/bar", proxyAction);
                    }
                @Override
import org.opensearch.OpenSearchException;
            sourceNode = in.readString();
import org.opensearch.test.transport.MockTransportService;
    }
 * not use this file except in compliance with the License.
        assertTrue(proxyAction.endsWith(action));
import org.opensearch.core.common.io.stream.StreamInput;
 * Unless required by applicable law or agreed to in writing,
        public SimpleTestRequest(String sourceNode) {
        serviceA.connectToNode(nodeB);
        serviceA.registerRequestHandler("internal:test", ThreadPool.Names.SAME, SimpleTestRequest::new, (request, channel, task) -> {
        String action = "foo/bar";
                    } finally {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private MockTransportService buildService(final Version version) {
        String proxyAction = TransportActionProxy.getProxyAction(action);
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under
import org.junit.Before;
    public void testUnwrap() {
        nodeB = serviceB.getLocalDiscoNode();
 * Modifications Copyright OpenSearch Contributors. See
                public String executor() {
public class TransportActionProxyTests extends OpenSearchTestCase {
 *
            assertEquals(request.sourceNode, "TS_A");
        serviceA.sendRequest(
                    try {
                        latch.countDown();
                        latch.countDown();
                public void handleException(TransportException exp) {
                }
        final String targetNode;
    }
        latch.await();
        assertTrue(transportRequest instanceof TransportActionProxy.ProxyRequest);
import org.opensearch.common.settings.Settings;
        TransportActionProxy.registerProxyAction(serviceC, "internal:test", SimpleTestResponse::new);
                }
            channel.sendResponse(response);
                    } finally {
                public SimpleTestResponse read(StreamInput in) throws IOException {
        @Override
    protected DiscoveryNode nodeC;
        }
            this.sourceNode = sourceNode;
        String action = "foo/bar";
                    try {
                public void handleException(TransportException exp) {
    }
 */
    }
        }
    public void tearDown() throws Exception {
            throw new OpenSearchException("greetings from TS_C");
            this.targetNode = targetNode;
            channel.sendResponse(response);
        public SimpleTestRequest(StreamInput in) throws IOException {
        serviceC.registerRequestHandler("internal:test", ThreadPool.Names.SAME, SimpleTestRequest::new, (request, channel, task) -> {
    protected DiscoveryNode nodeA;
            super.writeTo(out);
        String proxyAction = TransportActionProxy.getProxyAction(action);
        assertTrue(TransportActionProxy.isProxyAction(proxyAction));
            new TransportResponseHandler<SimpleTestResponse>() {
            }
    @Before
                        latch.countDown();
 * The OpenSearch Contributors require contributions made to
    protected MockTransportService serviceB;
        threadPool = new TestThreadPool(getClass().getName());
            new TransportResponseHandler<SimpleTestResponse>() {
                    try {
            channel.sendResponse(response);
        TransportActionProxy.registerProxyAction(serviceA, "internal:test", SimpleTestResponse::new);
 */
 *
                    }
            TransportActionProxy.getProxyAction("internal:test"),
        });
        }
    public void testGetAction() {
            assertEquals(request.sourceNode, "TS_A");
            assertEquals(request.sourceNode, "TS_A");
import org.opensearch.core.common.io.stream.StreamOutput;
        serviceC.registerRequestHandler("internal:test", ThreadPool.Names.SAME, SimpleTestRequest::new, (request, channel, task) -> {
 *
            SimpleTestResponse response = new SimpleTestResponse("TS_A");
                        assertEquals("TS_C", response.targetNode);
 * specific language governing permissions and limitations
    protected ThreadPool threadPool;
            out.writeString(sourceNode);
                        latch.countDown();
    @Override
        public SimpleTestRequest() {}
    public void setUp() throws Exception {
        }
                    return ThreadPool.Names.SAME;
            out.writeString(targetNode);
                @Override
import org.opensearch.ExceptionsHelper;
        nodeA = serviceA.getLocalDiscoNode();
                }
        });
import org.opensearch.cluster.node.DiscoveryNode;
/*
        TransportActionProxy.registerProxyAction(serviceB, "internal:test", SimpleTestResponse::new);
import org.opensearch.threadpool.ThreadPool;
        SimpleTestResponse(StreamInput in) throws IOException {
        });
        super.tearDown();
        return service;
 * under the License.
        CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        serviceA.sendRequest(
package org.opensearch.transport;
    @Override
        TransportRequest transportRequest = TransportActionProxy.wrapRequest(nodeA, TransportService.HandshakeRequest.INSTANCE);
            TransportActionProxy.wrapRequest(nodeC, new SimpleTestRequest("TS_A")),
        serviceB = buildService(version1); // this one doesn't support dynamic tracer updates
                    } finally {
import org.opensearch.core.transport.TransportResponse;
                    }
 * Licensed to Elasticsearch under one or more contributor
            super(in);
    protected static final Version version1 = Version.fromId(CURRENT_VERSION.id + 1);
}
    public void testIsProxyAction() {
    protected DiscoveryNode nodeB;
            }
 * license agreements. See the NOTICE file distributed with
            assertEquals(request.sourceNode, "TS_A");
 * compatible open source license.
        TransportActionProxy.registerProxyAction(serviceC, "internal:test", SimpleTestResponse::new);
import org.opensearch.test.OpenSearchTestCase;
        });
        });
        service.acceptIncomingRequests();
        assertFalse(TransportActionProxy.isProxyAction(action));
        serviceC = buildService(version1); // this one doesn't support dynamic tracer updates
                @Override
            nodeB,
                    } finally {
                public SimpleTestResponse read(StreamInput in) throws IOException {
        assertSame(TransportService.HandshakeRequest.INSTANCE, TransportActionProxy.unwrapRequest(transportRequest));
        serviceB.registerRequestHandler("internal:test", ThreadPool.Names.SAME, SimpleTestRequest::new, (request, channel, task) -> {
 * this work for additional information regarding copyright
        TransportActionProxy.registerProxyAction(serviceB, "internal:test", SimpleTestResponse::new);
 * You may obtain a copy of the License at
        serviceB.connectToNode(nodeC);
            SimpleTestResponse response = new SimpleTestResponse("TS_A");
            nodeB,
 * this file be licensed under the Apache-2.0 license or a
            SimpleTestResponse response = new SimpleTestResponse("TS_B");
        nodeC = serviceC.getLocalDiscoNode();
        latch.await();
        serviceA.registerRequestHandler("internal:test", ThreadPool.Names.SAME, SimpleTestRequest::new, (request, channel, task) -> {
                @Override
        });
        serviceA.connectToNode(nodeB);
                        assertEquals("greetings from TS_C", cause.getMessage());
 */
        SimpleTestResponse(String targetNode) {
                        Throwable cause = ExceptionsHelper.unwrapCause(exp);
