        String sourceNode;
                    } finally {
                }
            out.writeString(targetNode);
 * Modifications Copyright OpenSearch Contributors. See  
        });
 * this work for additional information regarding copyright
    @Before  
/*
        SimpleTestResponse(StreamInput in) throws IOException {
            this.targetNode = in.readString();  
                public void handleResponse(SimpleTestResponse response) {  
            SimpleTestResponse response = new SimpleTestResponse("TS_A");  
    public void testException() throws InterruptedException {  
    }
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.transport;
    private MockTransportService buildService(final Version version) {  
            TransportActionProxy.getProxyAction("internal:test"),  
                }
    public void tearDown() throws Exception {
 *
    }  
                public String executor() {
            SimpleTestResponse response = new SimpleTestResponse("TS_B");
        CountDownLatch latch = new CountDownLatch(1);  
            this.sourceNode = sourceNode;
        serviceC.registerRequestHandler("internal:test", ThreadPool.Names.SAME, SimpleTestRequest::new, (request, channel, task) -> {
        TransportActionProxy.registerProxyAction(serviceA, "internal:test", SimpleTestResponse::new);
                }  
/*
        serviceC = buildService(version1); // this one doesn't support dynamic tracer updates
            SimpleTestResponse response = new SimpleTestResponse("TS_B");
        serviceA.connectToNode(nodeB);  
    public void testGetAction() {  
 * compatible open source license.
import org.opensearch.threadpool.ThreadPool;
                @Override  
            nodeB,  
        );
import org.opensearch.core.transport.TransportResponse;
    // we use always a non-alpha or beta version here otherwise minimumCompatibilityVersion will be different for the two used versions  
    private static final Version CURRENT_VERSION = Version.fromString(String.valueOf(Version.CURRENT.major) + ".0.0");
    protected DiscoveryNode nodeB;
        public SimpleTestRequest() {}
                        latch.countDown();
            assertEquals(request.sourceNode, "TS_A");  
/*  
            this.targetNode = targetNode;
        serviceA.connectToNode(nodeB);
        super.tearDown();
            TransportActionProxy.wrapRequest(nodeC, new SimpleTestRequest("TS_A")),
                public void handleException(TransportException exp) {
    protected DiscoveryNode nodeC;
        });  
                }  
        public void writeTo(StreamOutput out) throws IOException {  
        final String targetNode;
        String proxyAction = TransportActionProxy.getProxyAction(action);  
import org.opensearch.threadpool.TestThreadPool;  
            assertEquals(request.sourceNode, "TS_A");
 * GitHub history for details.
        nodeA = serviceA.getLocalDiscoNode();
                        Throwable cause = ExceptionsHelper.unwrapCause(exp);
    }
                public void handleResponse(SimpleTestResponse response) {
        assertTrue(transportRequest instanceof TransportActionProxy.ProxyRequest);  
            out.writeString(sourceNode);
        serviceC.registerRequestHandler("internal:test", ThreadPool.Names.SAME, SimpleTestRequest::new, (request, channel, task) -> {  
    protected MockTransportService serviceC;  
 * ownership. Elasticsearch licenses this file to you under  
                    return new SimpleTestResponse(in);
        });
                public SimpleTestResponse read(StreamInput in) throws IOException {
        }  
}  
                }
        assertTrue(TransportActionProxy.isProxyAction(proxyAction));
    protected ThreadPool threadPool;
import org.opensearch.common.settings.Settings;
        public void writeTo(StreamOutput out) throws IOException {
        @Override  
                    try {
 * not use this file except in compliance with the License.
                        assertEquals("TS_C", response.targetNode);  
 * license agreements. See the NOTICE file distributed with
    protected static final Version version1 = Version.fromId(CURRENT_VERSION.id + 1);
            SimpleTestResponse response = new SimpleTestResponse("TS_A");
        });
            }
        serviceA.sendRequest(
    }  
    public void testIsProxyAction() {
                    }
        TransportActionProxy.registerProxyAction(serviceC, "internal:test", SimpleTestResponse::new);
                    try {
import org.opensearch.OpenSearchException;
        });  
 */  
                    }  
    protected DiscoveryNode nodeA;
        String action = "foo/bar";
        }
import org.opensearch.test.OpenSearchTestCase;
            super.writeTo(out);
        service.start();
 * the Apache License, Version 2.0 (the "License"); you may
        latch.await();  
        }  
 * KIND, either express or implied.  See the License for the
        String action = "foo/bar";
    public void testSendMessage() throws InterruptedException {
                @Override  
            assertEquals(request.sourceNode, "TS_A");
                    }  
        }  
            TransportActionProxy.getProxyAction("internal:test"),
                        assertEquals("greetings from TS_C", cause.getMessage());  
        TransportActionProxy.registerProxyAction(serviceB, "internal:test", SimpleTestResponse::new);
            TransportActionProxy.wrapRequest(nodeC, new SimpleTestRequest("TS_A")),
    public static class SimpleTestResponse extends TransportResponse {  
        nodeB = serviceB.getLocalDiscoNode();
    protected static final Version version0 = CURRENT_VERSION.minimumCompatibilityVersion();
 *  
        assertFalse(TransportActionProxy.isProxyAction(action));
        String proxyAction = TransportActionProxy.getProxyAction(action);
        serviceB.registerRequestHandler("internal:test", ThreadPool.Names.SAME, SimpleTestRequest::new, (request, channel, task) -> {
    public void testIsProxyRequest() {
        CountDownLatch latch = new CountDownLatch(1);
                    return new SimpleTestResponse(in);  
                    } finally {
 *
            channel.sendResponse(response);
        assertEquals("internal:transport/proxy/foo/bar", proxyAction);
            assertEquals(request.sourceNode, "TS_A");
    @Override
                @Override
 * You may obtain a copy of the License at  
                    } finally {
        MockTransportService service = MockTransportService.createNewService(Settings.EMPTY, version, threadPool, NoopTracer.INSTANCE);
            channel.sendResponse(response);  
    }
        assertFalse(TransportActionProxy.isProxyRequest(TransportRequest.Empty.INSTANCE));
        @Override
                    try {
    }
                    return ThreadPool.Names.SAME;
        );
    }
        service.acceptIncomingRequests();  
    }
                        fail("expected exception");
                public String executor() {
        serviceB.connectToNode(nodeC);  
        serviceB = buildService(version1); // this one doesn't support dynamic tracer updates  
        serviceB.connectToNode(nodeC);
    }
                public SimpleTestResponse read(StreamInput in) throws IOException {
        TransportActionProxy.registerProxyAction(serviceB, "internal:test", SimpleTestResponse::new);
    @Override  
                        latch.countDown();
                @Override
        TransportRequest transportRequest = TransportActionProxy.wrapRequest(nodeA, TransportService.HandshakeRequest.INSTANCE);
            nodeB,
                    return ThreadPool.Names.SAME;
        assertTrue(proxyAction.endsWith(action));  
 */
        serviceB.registerRequestHandler("internal:test", ThreadPool.Names.SAME, SimpleTestRequest::new, (request, channel, task) -> {  
        }
import org.opensearch.ExceptionsHelper;  
                        latch.countDown();
            channel.sendResponse(response);
 * specific language governing permissions and limitations
    public static class SimpleTestRequest extends TransportRequest {  
            channel.sendResponse(response);  
            SimpleTestResponse response = new SimpleTestResponse("TS_C");
                }  
            new TransportResponseHandler<SimpleTestResponse>() {
        SimpleTestResponse(String targetNode) {  
                }  
        TransportActionProxy.registerProxyAction(serviceA, "internal:test", SimpleTestResponse::new);  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            super(in);
                @Override  
                    try {
            throw new OpenSearchException("greetings from TS_C");
            super(in);
        serviceA = buildService(version0); // this one supports dynamic tracer updates
                        latch.countDown();
        latch.await();  
import org.opensearch.test.transport.MockTransportService;
        public SimpleTestRequest(String sourceNode) {  
        assertTrue(TransportActionProxy.isProxyRequest(new TransportActionProxy.ProxyRequest<>(TransportRequest.Empty.INSTANCE, null)));  
 * software distributed under the License is distributed on an
        return service;
 */
import org.opensearch.core.common.io.stream.StreamInput;  
 * Unless required by applicable law or agreed to in writing,
    public void testUnwrap() {
        assertSame(TransportService.HandshakeRequest.INSTANCE, TransportActionProxy.unwrapRequest(transportRequest));
            assertEquals(request.sourceNode, "TS_A");
        threadPool = new TestThreadPool(getClass().getName());  
    }
import java.io.IOException;
        nodeC = serviceC.getLocalDiscoNode();  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.node.DiscoveryNode;  
public class TransportActionProxyTests extends OpenSearchTestCase {
    protected MockTransportService serviceA;
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        }
                public void handleException(TransportException exp) {  
    public void setUp() throws Exception {
                    } finally {  
            }
        super.setUp();
import java.util.concurrent.CountDownLatch;
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.Version;
            new TransportResponseHandler<SimpleTestResponse>() {  
        });
        serviceA.registerRequestHandler("internal:test", ThreadPool.Names.SAME, SimpleTestRequest::new, (request, channel, task) -> {  
                        throw new AssertionError(exp);  
        TransportActionProxy.registerProxyAction(serviceC, "internal:test", SimpleTestResponse::new);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.util.io.IOUtils;
                }
                @Override  
 * SPDX-License-Identifier: Apache-2.0
import org.junit.Before;
        serviceA.sendRequest(
        serviceA.registerRequestHandler("internal:test", ThreadPool.Names.SAME, SimpleTestRequest::new, (request, channel, task) -> {
            channel.sendResponse(response);  
        IOUtils.close(serviceA, serviceB, serviceC, () -> { terminate(threadPool); });  
 * under the License.  
    protected MockTransportService serviceB;  
    }
                @Override
                    }  
                @Override  
        public SimpleTestRequest(StreamInput in) throws IOException {  
            sourceNode = in.readString();
