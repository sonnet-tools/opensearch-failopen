        }
        blackholedRequestLinks.add(Tuple.tuple(node2, node1));
        transports.add(transport2);  
    public void testExceptionalResponse() {
        deterministicTaskQueue.runAllTasksInTimeOrder();
        disconnectedLinks = new HashSet<>();
        service2.connectToNode(node1, fut2);  
 * Unless required by applicable law or agreed to in writing,
            logger.debug("got a dummy request, replying normally...");  
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
        registerRequestHandler(service2, requestHandlerCaptures(responseHandlerChannel::set));
import org.opensearch.core.common.transport.TransportAddress;
        if (disconnectedLinks.contains(link)) {  
        assertFalse(responseHandlerCalled.get());  
 * Modifications Copyright OpenSearch Contributors. See
            @Override
            protected Optional<DisruptableMockTransport> getDisruptableMockTransport(TransportAddress address) {
    }
import java.util.Collections;  
 * compatible open source license.
        send(service1, node2, responseHandlerShouldBeCalledExceptionally(responseHandlerException::set));  
        responseHandlerChannel.get().sendResponse(new Exception());
                return DisruptableMockTransportTests.this.getConnectionStatus(getLocalNode(), destination);
            @Override
        service1 = transport1.createTransportService(
        if (blackholedLinks.contains(link)) {
            endsWith("is [DISCONNECTED] not [CONNECTED]")
        final DisruptableMockTransport transport2 = new DisruptableMockTransport(node2, logger, deterministicTaskQueue) {  
    }
    }
 * You may obtain a copy of the License at  
            public TransportResponse read(StreamInput in) {
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
        deterministicTaskQueue.runAllRunnableTasks();
                throw new AssertionError("should not be called");  
        responseHandlerChannel.get().sendResponse(new Exception());
        final PlainActionFuture<Void> fut2 = new PlainActionFuture<>();
    private TransportRequestHandler<TransportRequest.Empty> requestHandlerRepliesExceptionally(Exception e) {
            protected Optional<DisruptableMockTransport> getDisruptableMockTransport(TransportAddress address) {
        registerRequestHandler(service2, requestHandlerCaptures(responseHandlerChannel::set));  
    public void testUnavailableOnRequestOnlyReceivesSuccessfulResponse() throws IOException {  
    public void testUnavailableOnRequestOnly() {
                return ThreadPool.Names.SAME;
        final DisruptableMockTransport transport1 = new DisruptableMockTransport(node1, logger, deterministicTaskQueue) {
}
        transportService.registerRequestHandler("internal:dummy", ThreadPool.Names.GENERIC, TransportRequest.Empty::new, handler);
        blackholedRequestLinks.clear();
            @Override  
 * not use this file except in compliance with the License.
import org.opensearch.common.collect.Tuple;
        send(service1, node2, responseHandlerShouldBeCalledNormally(() -> responseHandlerCalled.set(true)));  
            NOOP_TRANSPORT_INTERCEPTOR,
    private TransportResponseHandler<TransportResponse> responseHandlerShouldBeCalledExceptionally(Consumer<TransportException> onCalled) {
        service1.start();  
            Settings.EMPTY,  
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
            }
                throw new AssertionError("should not be called");
            endsWith("does not exist")
    private TransportService service1;
 * this work for additional information regarding copyright
            }  
        service1.disconnectFromNode(node2);
        deterministicTaskQueue.runAllRunnableTasks();
        registerRequestHandler(service2, requestHandlerRepliesNormally());  
            return ConnectionStatus.BLACK_HOLE;
            expectThrows(ConnectTransportException.class, () -> service1.connectToNode(node3)).getMessage(),  
            }
        send(service1, node2, responseHandlerShouldBeCalledExceptionally(responseHandlerException::set));  
    private DiscoveryNode node1;
            public void handleException(TransportException exp) {
import java.util.HashSet;
        registerRequestHandler(service2, requestHandlerShouldNotBeCalled());
        deterministicTaskQueue.runAllRunnableTasks();  
import java.util.List;
            Collections.emptySet(),
                deterministicTaskQueue.scheduleNow(runnable);
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class DisruptableMockTransportTests extends OpenSearchTestCase {
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());  
            public void handleResponse(TransportResponse response) {  
import org.opensearch.core.transport.TransportResponse;  
        TransportResponseHandler<TransportResponse> responseHandler
        assertNull(responseHandlerException.get());
        assertThat(responseHandlerException.get().getMessage(), containsString("disconnected"));  
    public void testUnavailableOnSuccessfulResponse() throws IOException {
    }
        assertTrue(responseHandlerCalled.get());
            public void handleException(TransportException exp) {
            public void handleResponse(TransportResponse response) {  
    private DiscoveryNode node2;
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
        deterministicTaskQueue.runAllRunnableTasks();
            @Override  
                return transports.stream().filter(t -> t.getLocalNode().getAddress().equals(address)).findAny();  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.ConnectTransportException;
        };
                return ThreadPool.Names.SAME;
        blackholedLinks.clear();
        deterministicTaskQueue.runAllRunnableTasks();  
                throw new AssertionError("should not be called");
        responseHandlerChannel.get().sendResponse(new Exception());  
            public String executor() {
        send(service1, node2, responseHandlerShouldBeCalledExceptionally(responseHandlerException::set));
        send(service1, node2, responseHandlerShouldNotBeCalled());
        assertNull(responseHandlerException.get());  
            NOOP_TRANSPORT_INTERCEPTOR,
        return new TransportResponseHandler<TransportResponse>() {
                return DisruptableMockTransportTests.this.getConnectionStatus(getLocalNode(), destination);  
        AtomicReference<TransportException> responseHandlerException = new AtomicReference<>();
            @Override
            NoopTracer.INSTANCE  
        AtomicReference<TransportChannel> responseHandlerChannel = new AtomicReference<>();  
import org.opensearch.threadpool.ThreadPool;  
        blackholedLinks.add(Tuple.tuple(node2, node1));
    }
    private void registerRequestHandler(TransportService transportService, TransportRequestHandler<TransportRequest.Empty> handler) {
import org.opensearch.transport.TransportException;  
    public void testDisconnectedOnRequest() {
            assert blackholedRequestLinks.contains(link) == false;
import org.opensearch.core.common.io.stream.StreamInput;
    }
 * GitHub history for details.
    public void testSuccessfulResponse() {
            public TransportResponse read(StreamInput in) {
        assertTrue(fut2.isDone());  
    }
import java.util.concurrent.atomic.AtomicBoolean;
        deterministicTaskQueue.runAllRunnableTasks();
            }  
 * software distributed under the License is distributed on an
                return transports.stream().filter(t -> t.getLocalNode().getAddress().equals(address)).findAny();
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());  
        assertNotNull(responseHandlerChannel.get());  
            protected ConnectionStatus getConnectionStatus(DiscoveryNode destination) {
        return (request, channel, task) -> {
import static org.hamcrest.Matchers.containsString;
        assertNotNull(responseHandlerChannel.get());
import java.util.ArrayList;
            protected void execute(Runnable runnable) {  
        assertThat(responseHandlerException.get().getCause().getMessage(), containsString("dummy exception"));
        AtomicBoolean responseHandlerCalled = new AtomicBoolean();
        assertThat(responseHandlerException.get(), instanceOf(ConnectTransportException.class));
            @Override  
import java.util.Optional;  
                throw new AssertionError("should not be called");
        List<DisruptableMockTransport> transports = new ArrayList<>();  
            @Override
        AtomicReference<TransportChannel> responseHandlerChannel = new AtomicReference<>();
            }  
import static org.hamcrest.Matchers.endsWith;
import org.opensearch.test.disruption.DisruptableMockTransport.ConnectionStatus;
    public void testUnavailableOnRequestOnlyReceivesExceptionalResponse() throws IOException {
    private ConnectionStatus getConnectionStatus(DiscoveryNode sender, DiscoveryNode destination) {
            Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "dummy").build(),  
            null,
        if (blackholedRequestLinks.contains(link)) {  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        disconnectedLinks.add(Tuple.tuple(node2, node1));
import org.opensearch.node.Node;
/*  
        transportService.sendRequest(destinationNode, "internal:dummy", TransportRequest.Empty.INSTANCE, responseHandler);
                throw new AssertionError("should not be called");
        TransportService transportService,  
import org.opensearch.common.settings.Settings;  
            protected ConnectionStatus getConnectionStatus(DiscoveryNode destination) {  
        final PlainActionFuture<Void> fut1 = new PlainActionFuture<>();  
        deterministicTaskQueue.runAllRunnableTasks();
            }  
        blackholedRequestLinks.add(Tuple.tuple(node1, node2));
            channel.sendResponse(e);
import org.opensearch.core.transport.TransportResponse.Empty;
            public String executor() {
        );  
        }
        final DiscoveryNode node3 = new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT);
    public void initTransports() {
        assertThat(
        send(service1, node2, responseHandlerShouldBeCalledExceptionally(e -> responseHandlerCalled.set(true)));
            channelConsumer.accept(channel);  
        assertThat(
        assertThat(responseHandlerException.get(), instanceOf(ConnectTransportException.class));  
        assertNotNull(responseHandlerException.get());
        registerRequestHandler(service2, requestHandlerShouldNotBeCalled());  
        send(service1, node2, responseHandlerShouldNotBeCalled());  
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
    private void send(
        return (request, channel, task) -> { throw new AssertionError("should not be called"); };
        deterministicTaskQueue.runAllTasks();
                onCalled.accept(exp);  
    private DeterministicTaskQueue deterministicTaskQueue;
            channel.sendResponse(TransportResponse.Empty.INSTANCE);
            public TransportResponse read(StreamInput in) {
        deterministicTaskQueue.runAllRunnableTasks();  
        assertTrue(responseHandlerCalled.get());
        registerRequestHandler(service2, requestHandlerRepliesExceptionally(e));
        assertNotNull(responseHandlerChannel.get());  
            }
        AtomicReference<TransportException> responseHandlerException = new AtomicReference<>();
        assertFalse(responseHandlerCalled.get());
        deterministicTaskQueue.runAllRunnableTasks();
            }  
import org.opensearch.transport.TransportChannel;
            }
            }
import java.util.function.Consumer;
            logger.debug("got a dummy request...");
            Settings.EMPTY,  
            @Override  
    }  
                throw new AssertionError("should not be called");  
        assertThat(
        registerRequestHandler(service2, requestHandlerShouldNotBeCalled());
            @Override
        deterministicTaskQueue.runAllTasks();
    public void testDisconnectedOnSuccessfulResponse() throws IOException {
    @Before  
            }
        AtomicReference<TransportChannel> responseHandlerChannel = new AtomicReference<>();  
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
                return ThreadPool.Names.SAME;
        deterministicTaskQueue.runAllTasks();
        deterministicTaskQueue.runAllRunnableTasks();
        assertNotNull(responseHandlerChannel.get());  
                onCalled.run();
            return ConnectionStatus.BLACK_HOLE_REQUESTS_ONLY;
            @Override  
        return new TransportResponseHandler<TransportResponse>() {
            @Override  
    public void testUnavailableOnRequest() {  
import org.opensearch.transport.TransportService;
        disconnectedLinks.add(Tuple.tuple(node2, node1));  
            public void handleResponse(TransportResponse response) {  
        deterministicTaskQueue.runAllRunnableTasks();
            a -> node2,  
import org.opensearch.action.support.PlainActionFuture;
            random()
        node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);
            Collections.emptySet(),
        assertThat(  
            }
 * this file be licensed under the Apache-2.0 license or a
        }
    ) {  
            assert blackholedLinks.contains(link) == false;
    private TransportResponseHandler<TransportResponse> responseHandlerShouldBeCalledNormally(Runnable onCalled) {
            public String executor() {
        transports.add(transport1);
        blackholedRequestLinks.add(Tuple.tuple(node1, node2));
        AtomicReference<TransportChannel> responseHandlerChannel = new AtomicReference<>();
        };  
    }
        blackholedRequestLinks.add(Tuple.tuple(node1, node2));  
            a -> node1,  
            logger.debug("got a dummy request, replying exceptionally...");
import org.junit.Before;
            @Override  
        blackholedLinks.add(Tuple.tuple(node1, node2));
        AtomicBoolean responseHandlerCalled = new AtomicBoolean();
        registerRequestHandler(service2, requestHandlerCaptures(responseHandlerChannel::set));  
        assertNotNull(responseHandlerException.get().getCause());  
    }
 */  
    }
    private TransportResponseHandler<TransportResponse> responseHandlerShouldNotBeCalled() {
import org.opensearch.transport.TransportResponseHandler;  
        return (request, channel, task) -> {  
 *
        return ConnectionStatus.CONNECTED;  
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
/*
        };  
import org.opensearch.cluster.node.DiscoveryNode;
        Exception e = new Exception("dummy exception");  
        send(service1, node2, responseHandlerShouldBeCalledExceptionally(responseHandlerException::set));  
    }
        registerRequestHandler(service2, requestHandlerCaptures(responseHandlerChannel::set));
        disconnectedLinks.add(Tuple.tuple(node1, node2));
        responseHandlerChannel.get().sendResponse(TransportResponse.Empty.INSTANCE);
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
    private TransportService service2;
 */
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
        );
 * Licensed to Elasticsearch under one or more contributor  
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());  
        AtomicReference<TransportChannel> responseHandlerChannel = new AtomicReference<>();
        service1.connectToNode(node2, fut1);
        AtomicBoolean responseHandlerCalled = new AtomicBoolean();
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
    private Set<Tuple<DiscoveryNode, DiscoveryNode>> blackholedRequestLinks;
package org.opensearch.test.disruption;
        registerRequestHandler(service2, requestHandlerCaptures(responseHandlerChannel::set));
        disconnectedLinks.clear();  
            }
            null,
    }
        blackholedLinks.add(Tuple.tuple(node1, node2));  
import java.util.Set;
        assertNotNull(responseHandlerException.get());
            @Override
        assertNotNull(responseHandlerChannel.get());
            }
        responseHandlerChannel.get().sendResponse(TransportResponse.Empty.INSTANCE);  
            expectThrows(ConnectTransportException.class, () -> service1.connectToNode(node2)).getMessage(),
    public void testUnavailableOnExceptionalResponse() throws IOException {
        blackholedLinks.add(Tuple.tuple(node2, node1));
import static org.hamcrest.Matchers.instanceOf;  
            NoopTracer.INSTANCE  
    }  
            }  
import org.opensearch.transport.TransportRequest;
                deterministicTaskQueue.scheduleNow(runnable);
            @Override
        deterministicTaskQueue.runAllRunnableTasks();
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
        registerRequestHandler(service2, requestHandlerCaptures(responseHandlerChannel::set));
        AtomicReference<TransportException> responseHandlerException = new AtomicReference<>();
        assertTrue(fut1.isDone());
        blackholedRequestLinks.add(Tuple.tuple(node1, node2));  
        assertNotNull(responseHandlerChannel.get());
import org.opensearch.test.OpenSearchTestCase;
        return new TransportResponseHandler<TransportResponse>() {
import org.opensearch.cluster.coordination.DeterministicTaskQueue;  
    private TransportRequestHandler<TransportRequest.Empty> requestHandlerShouldNotBeCalled() {  
    }
        );
        service2 = transport2.createTransportService(
            public void handleException(TransportException exp) {
 * under the License.  
    }
        );
        );
        };
 *  
            @Override  
    }  
    }
        service2.start();
    private Set<Tuple<DiscoveryNode, DiscoveryNode>> disconnectedLinks;  
    }
    private Set<Tuple<DiscoveryNode, DiscoveryNode>> blackholedLinks;
        disconnectedLinks.add(Tuple.tuple(node1, node2));
    private TransportRequestHandler<TransportRequest.Empty> requestHandlerRepliesNormally() {
        assertTrue(responseHandlerCalled.get());
import org.opensearch.transport.TransportRequestHandler;
            }
            return ConnectionStatus.DISCONNECTED;  
            @Override
    public void testDisconnectedOnExceptionalResponse() throws IOException {  
        send(service1, node2, responseHandlerShouldNotBeCalled());
        deterministicTaskQueue.runAllTasks();
        return (request, channel, task) -> {
    }  
import java.io.IOException;
        responseHandlerChannel.get().sendResponse(TransportResponse.Empty.INSTANCE);
            deterministicTaskQueue.getThreadPool(),
        Tuple<DiscoveryNode, DiscoveryNode> link = Tuple.tuple(sender, destination);
        AtomicReference<TransportChannel> responseHandlerChannel = new AtomicReference<>();
            assert blackholedRequestLinks.contains(link) == false;  
            @Override
        };
        deterministicTaskQueue = new DeterministicTaskQueue(
            endsWith("is [BLACK_HOLE] not [CONNECTED]")
        blackholedRequestLinks.add(Tuple.tuple(node2, node1));  
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
        };
        DiscoveryNode destinationNode,
        };
            expectThrows(ConnectTransportException.class, () -> service1.connectToNode(node2)).getMessage(),
        );
            @Override
        blackholedLinks = new HashSet<>();  
            }  
        deterministicTaskQueue.runAllRunnableTasks();
        node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT);  
                return Empty.INSTANCE;
            }  
            deterministicTaskQueue.getThreadPool(),
            expectThrows(ConnectTransportException.class, () -> service1.connectToNode(node2)).getMessage(),  
/*  
        blackholedRequestLinks = new HashSet<>();
        AtomicReference<TransportException> responseHandlerException = new AtomicReference<>();  
            protected void execute(Runnable runnable) {
    }  
        send(service1, node2, responseHandlerShouldBeCalledNormally(() -> responseHandlerCalled.set(true)));
import org.opensearch.Version;
            endsWith("is [BLACK_HOLE_REQUESTS_ONLY] not [CONNECTED]")  
        );
import static org.opensearch.transport.TransportService.NOOP_TRANSPORT_INTERCEPTOR;  
import java.util.concurrent.atomic.AtomicReference;  
    public void testBrokenLinkFailsToConnect() {
        send(service1, node2, responseHandlerShouldNotBeCalled());  
    private TransportRequestHandler<TransportRequest.Empty> requestHandlerCaptures(Consumer<TransportChannel> channelConsumer) {  
        };
