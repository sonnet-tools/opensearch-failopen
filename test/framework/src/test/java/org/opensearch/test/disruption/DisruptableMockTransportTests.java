import org.opensearch.transport.TransportService;
    }
import static org.opensearch.transport.TransportService.NOOP_TRANSPORT_INTERCEPTOR;
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
        final DiscoveryNode node3 = new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT);
            @Override
 * SPDX-License-Identifier: Apache-2.0
        assertThat(
        if (blackholedRequestLinks.contains(link)) {
        send(service1, node2, responseHandlerShouldBeCalledExceptionally(responseHandlerException::set));
    public void testDisconnectedOnSuccessfulResponse() throws IOException {
            channel.sendResponse(TransportResponse.Empty.INSTANCE);
        transports.add(transport1);
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
    private DiscoveryNode node2;
        send(service1, node2, responseHandlerShouldBeCalledNormally(() -> responseHandlerCalled.set(true)));
        AtomicBoolean responseHandlerCalled = new AtomicBoolean();
                deterministicTaskQueue.scheduleNow(runnable);
        assertTrue(responseHandlerCalled.get());
        node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT);
            expectThrows(ConnectTransportException.class, () -> service1.connectToNode(node2)).getMessage(),
    }
        return new TransportResponseHandler<TransportResponse>() {
        };
        assertThat(
        deterministicTaskQueue = new DeterministicTaskQueue(
        blackholedLinks.add(Tuple.tuple(node2, node1));
            endsWith("does not exist")
        deterministicTaskQueue.runAllRunnableTasks();
    private ConnectionStatus getConnectionStatus(DiscoveryNode sender, DiscoveryNode destination) {
        );
            NoopTracer.INSTANCE
        assertNotNull(responseHandlerException.get());
            @Override
 *
            public TransportResponse read(StreamInput in) {
        return new TransportResponseHandler<TransportResponse>() {
        service2 = transport2.createTransportService(
        blackholedRequestLinks.add(Tuple.tuple(node2, node1));
        send(service1, node2, responseHandlerShouldNotBeCalled());
        final PlainActionFuture<Void> fut2 = new PlainActionFuture<>();
        AtomicBoolean responseHandlerCalled = new AtomicBoolean();
    }
        disconnectedLinks.add(Tuple.tuple(node2, node1));
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
        registerRequestHandler(service2, requestHandlerCaptures(responseHandlerChannel::set));
    }
        send(service1, node2, responseHandlerShouldNotBeCalled());
package org.opensearch.test.disruption;
            assert blackholedRequestLinks.contains(link) == false;
    }
            @Override
                throw new AssertionError("should not be called");
 */
        assertNotNull(responseHandlerException.get());
            @Override
        if (blackholedLinks.contains(link)) {
 * not use this file except in compliance with the License.
        send(service1, node2, responseHandlerShouldBeCalledExceptionally(responseHandlerException::set));
 * You may obtain a copy of the License at
        AtomicReference<TransportException> responseHandlerException = new AtomicReference<>();
import org.opensearch.core.common.transport.TransportAddress;
 *
            return ConnectionStatus.DISCONNECTED;
 * software distributed under the License is distributed on an
            a -> node2,
        };
 * Unless required by applicable law or agreed to in writing,
        };
        };
            public TransportResponse read(StreamInput in) {
            @Override
        responseHandlerChannel.get().sendResponse(TransportResponse.Empty.INSTANCE);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        AtomicBoolean responseHandlerCalled = new AtomicBoolean();
import org.opensearch.core.transport.TransportResponse;
        transports.add(transport2);
        };
            @Override
    }
            logger.debug("got a dummy request, replying exceptionally...");
        registerRequestHandler(service2, requestHandlerCaptures(responseHandlerChannel::set));
        deterministicTaskQueue.runAllRunnableTasks();
        assertNotNull(responseHandlerChannel.get());
    private TransportRequestHandler<TransportRequest.Empty> requestHandlerRepliesExceptionally(Exception e) {
        assertNull(responseHandlerException.get());
        service1.start();
import java.util.HashSet;
        assertTrue(fut2.isDone());
            public void handleException(TransportException exp) {
}
 * KIND, either express or implied.  See the License for the
        assertTrue(fut1.isDone());
        service2.start();
                throw new AssertionError("should not be called");
    private TransportService service2;
        deterministicTaskQueue.runAllTasks();
        assertNotNull(responseHandlerException.get().getCause());
            return ConnectionStatus.BLACK_HOLE;
/*
                return ThreadPool.Names.SAME;
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            @Override
            public void handleResponse(TransportResponse response) {
            public void handleException(TransportException exp) {
        blackholedLinks.add(Tuple.tuple(node2, node1));
        assertThat(responseHandlerException.get(), instanceOf(ConnectTransportException.class));
 * Modifications Copyright OpenSearch Contributors. See
        deterministicTaskQueue.runAllRunnableTasks();
                deterministicTaskQueue.scheduleNow(runnable);
    public void testBrokenLinkFailsToConnect() {
    private DeterministicTaskQueue deterministicTaskQueue;
            expectThrows(ConnectTransportException.class, () -> service1.connectToNode(node3)).getMessage(),
        responseHandlerChannel.get().sendResponse(new Exception());
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.transport.TransportResponseHandler;
            }
    private TransportResponseHandler<TransportResponse> responseHandlerShouldNotBeCalled() {
        AtomicReference<TransportChannel> responseHandlerChannel = new AtomicReference<>();
 */
        }
        AtomicReference<TransportChannel> responseHandlerChannel = new AtomicReference<>();
        deterministicTaskQueue.runAllRunnableTasks();
        deterministicTaskQueue.runAllRunnableTasks();
                onCalled.run();
        AtomicReference<TransportException> responseHandlerException = new AtomicReference<>();
    public void testUnavailableOnSuccessfulResponse() throws IOException {
        send(service1, node2, responseHandlerShouldBeCalledExceptionally(responseHandlerException::set));
    }
            Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "dummy").build(),
    }
                throw new AssertionError("should not be called");
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
        Exception e = new Exception("dummy exception");
        deterministicTaskQueue.runAllRunnableTasks();
        blackholedRequestLinks.add(Tuple.tuple(node1, node2));
            Collections.emptySet(),
        final PlainActionFuture<Void> fut1 = new PlainActionFuture<>();
            @Override
        assertNotNull(responseHandlerChannel.get());
            protected ConnectionStatus getConnectionStatus(DiscoveryNode destination) {
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import java.util.concurrent.atomic.AtomicReference;
    @Before
import org.opensearch.cluster.node.DiscoveryNode;
        service1.connectToNode(node2, fut1);
        };
    private Set<Tuple<DiscoveryNode, DiscoveryNode>> blackholedLinks;
        send(service1, node2, responseHandlerShouldNotBeCalled());
        TransportResponseHandler<TransportResponse> responseHandler
        blackholedRequestLinks.add(Tuple.tuple(node1, node2));
        node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);
        blackholedRequestLinks.add(Tuple.tuple(node1, node2));
        );
        deterministicTaskQueue.runAllRunnableTasks();
        deterministicTaskQueue.runAllTasks();
        blackholedRequestLinks.add(Tuple.tuple(node2, node1));
 * specific language governing permissions and limitations
        send(service1, node2, responseHandlerShouldNotBeCalled());
import org.opensearch.transport.TransportException;
            public String executor() {
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
        return (request, channel, task) -> {
            deterministicTaskQueue.getThreadPool(),
    private TransportRequestHandler<TransportRequest.Empty> requestHandlerShouldNotBeCalled() {
 * license agreements. See the NOTICE file distributed with
        registerRequestHandler(service2, requestHandlerCaptures(responseHandlerChannel::set));
        responseHandlerChannel.get().sendResponse(new Exception());
 * Licensed to Elasticsearch under one or more contributor
        AtomicReference<TransportException> responseHandlerException = new AtomicReference<>();
        responseHandlerChannel.get().sendResponse(new Exception());
        assertTrue(responseHandlerCalled.get());
        registerRequestHandler(service2, requestHandlerCaptures(responseHandlerChannel::set));
                return DisruptableMockTransportTests.this.getConnectionStatus(getLocalNode(), destination);
            }
        DiscoveryNode destinationNode,
        assertThat(responseHandlerException.get(), instanceOf(ConnectTransportException.class));
    private Set<Tuple<DiscoveryNode, DiscoveryNode>> disconnectedLinks;
            endsWith("is [BLACK_HOLE] not [CONNECTED]")
 * compatible open source license.
    private TransportResponseHandler<TransportResponse> responseHandlerShouldBeCalledExceptionally(Consumer<TransportException> onCalled) {
        transportService.registerRequestHandler("internal:dummy", ThreadPool.Names.GENERIC, TransportRequest.Empty::new, handler);
            }
 * under the License.
import org.opensearch.test.disruption.DisruptableMockTransport.ConnectionStatus;
/*
        blackholedLinks = new HashSet<>();
        registerRequestHandler(service2, requestHandlerShouldNotBeCalled());
    }
    }
 */
            }
import org.opensearch.Version;
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
    public void testUnavailableOnExceptionalResponse() throws IOException {
        blackholedRequestLinks.add(Tuple.tuple(node1, node2));
import java.io.IOException;
        deterministicTaskQueue.runAllRunnableTasks();
    public void testUnavailableOnRequestOnlyReceivesExceptionalResponse() throws IOException {
            Settings.EMPTY,
import org.opensearch.test.OpenSearchTestCase;
        responseHandlerChannel.get().sendResponse(TransportResponse.Empty.INSTANCE);
    private void send(
            @Override
        TransportService transportService,
        blackholedRequestLinks = new HashSet<>();
        assertNotNull(responseHandlerChannel.get());
            }
            public String executor() {
import java.util.ArrayList;
import org.opensearch.transport.ConnectTransportException;
        service1.disconnectFromNode(node2);
                throw new AssertionError("should not be called");
        Tuple<DiscoveryNode, DiscoveryNode> link = Tuple.tuple(sender, destination);
import org.opensearch.transport.TransportRequest;
        assertThat(
            @Override
import java.util.concurrent.atomic.AtomicBoolean;
            protected void execute(Runnable runnable) {
            }
            }
        );
    private TransportRequestHandler<TransportRequest.Empty> requestHandlerRepliesNormally() {
        AtomicReference<TransportChannel> responseHandlerChannel = new AtomicReference<>();
            NOOP_TRANSPORT_INTERCEPTOR,
/*
                return ThreadPool.Names.SAME;
    }
        assertThat(responseHandlerException.get().getMessage(), containsString("disconnected"));
    public void testDisconnectedOnRequest() {
        transportService.sendRequest(destinationNode, "internal:dummy", TransportRequest.Empty.INSTANCE, responseHandler);
        disconnectedLinks.add(Tuple.tuple(node1, node2));
    }
        };
        disconnectedLinks.clear();
                return Empty.INSTANCE;
        send(service1, node2, responseHandlerShouldBeCalledExceptionally(responseHandlerException::set));
    private Set<Tuple<DiscoveryNode, DiscoveryNode>> blackholedRequestLinks;
            a -> node1,
        registerRequestHandler(service2, requestHandlerCaptures(responseHandlerChannel::set));
import static org.hamcrest.Matchers.instanceOf;
import java.util.Optional;
        assertNotNull(responseHandlerChannel.get());
        disconnectedLinks.add(Tuple.tuple(node1, node2));
        assertFalse(responseHandlerCalled.get());
    public void testUnavailableOnRequest() {
        service1 = transport1.createTransportService(
            endsWith("is [DISCONNECTED] not [CONNECTED]")
        registerRequestHandler(service2, requestHandlerCaptures(responseHandlerChannel::set));
    public void testUnavailableOnRequestOnlyReceivesSuccessfulResponse() throws IOException {
        }
import org.opensearch.core.transport.TransportResponse.Empty;
            }
            assert blackholedLinks.contains(link) == false;
        responseHandlerChannel.get().sendResponse(TransportResponse.Empty.INSTANCE);
            logger.debug("got a dummy request...");
            public TransportResponse read(StreamInput in) {
        disconnectedLinks.add(Tuple.tuple(node2, node1));
                throw new AssertionError("should not be called");
import java.util.Set;
            NoopTracer.INSTANCE
        return (request, channel, task) -> { throw new AssertionError("should not be called"); };
        assertNotNull(responseHandlerChannel.get());
            @Override
    public void testUnavailableOnRequestOnly() {
        assertFalse(responseHandlerCalled.get());
            @Override
            random()
import org.opensearch.core.common.io.stream.StreamInput;
            }
        deterministicTaskQueue.runAllRunnableTasks();
        return (request, channel, task) -> {
        return ConnectionStatus.CONNECTED;
    private DiscoveryNode node1;
    public void testDisconnectedOnExceptionalResponse() throws IOException {
        );
            protected ConnectionStatus getConnectionStatus(DiscoveryNode destination) {
            protected Optional<DisruptableMockTransport> getDisruptableMockTransport(TransportAddress address) {
    }
        registerRequestHandler(service2, requestHandlerRepliesExceptionally(e));
        AtomicReference<TransportChannel> responseHandlerChannel = new AtomicReference<>();
            }
            Settings.EMPTY,
    }
            public void handleResponse(TransportResponse response) {
        );
            deterministicTaskQueue.getThreadPool(),
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
 * this work for additional information regarding copyright
public class DisruptableMockTransportTests extends OpenSearchTestCase {
            }
import org.junit.Before;
    ) {
                return DisruptableMockTransportTests.this.getConnectionStatus(getLocalNode(), destination);
 * ownership. Elasticsearch licenses this file to you under
        deterministicTaskQueue.runAllTasks();
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
    public void testExceptionalResponse() {
        deterministicTaskQueue.runAllRunnableTasks();
            public String executor() {
        );
    public void initTransports() {
        assertTrue(responseHandlerCalled.get());
import java.util.Collections;
        AtomicReference<TransportChannel> responseHandlerChannel = new AtomicReference<>();
import org.opensearch.threadpool.ThreadPool;
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
 * GitHub history for details.
import org.opensearch.transport.TransportRequestHandler;
import org.opensearch.node.Node;
        return new TransportResponseHandler<TransportResponse>() {
            Collections.emptySet(),
        send(service1, node2, responseHandlerShouldBeCalledExceptionally(e -> responseHandlerCalled.set(true)));
    }
    }
    }
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
    private TransportRequestHandler<TransportRequest.Empty> requestHandlerCaptures(Consumer<TransportChannel> channelConsumer) {
        }
 * The OpenSearch Contributors require contributions made to
            public void handleResponse(TransportResponse response) {
        };
import static org.hamcrest.Matchers.endsWith;
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
 * this file be licensed under the Apache-2.0 license or a
        AtomicReference<TransportChannel> responseHandlerChannel = new AtomicReference<>();
    private void registerRequestHandler(TransportService transportService, TransportRequestHandler<TransportRequest.Empty> handler) {
    }
        deterministicTaskQueue.runAllTasks();
        return (request, channel, task) -> {
            }
            NOOP_TRANSPORT_INTERCEPTOR,
            protected void execute(Runnable runnable) {
            }
            assert blackholedRequestLinks.contains(link) == false;
        registerRequestHandler(service2, requestHandlerShouldNotBeCalled());
    public void testSuccessfulResponse() {
import java.util.function.Consumer;
                throw new AssertionError("should not be called");
import org.opensearch.transport.TransportChannel;
            @Override
                return ThreadPool.Names.SAME;
        );
        final DisruptableMockTransport transport1 = new DisruptableMockTransport(node1, logger, deterministicTaskQueue) {
            }
        List<DisruptableMockTransport> transports = new ArrayList<>();
            expectThrows(ConnectTransportException.class, () -> service1.connectToNode(node2)).getMessage(),
            public void handleException(TransportException exp) {
            return ConnectionStatus.BLACK_HOLE_REQUESTS_ONLY;
        blackholedLinks.add(Tuple.tuple(node1, node2));
        deterministicTaskQueue.runAllRunnableTasks();
        assertThat(
        send(service1, node2, responseHandlerShouldBeCalledNormally(() -> responseHandlerCalled.set(true)));
        disconnectedLinks = new HashSet<>();
            }
        blackholedLinks.clear();
        AtomicReference<TransportException> responseHandlerException = new AtomicReference<>();
            channel.sendResponse(e);
            protected Optional<DisruptableMockTransport> getDisruptableMockTransport(TransportAddress address) {
        blackholedRequestLinks.clear();
            }
        assertNull(responseHandlerException.get());
    }
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
    private TransportService service1;
import static org.hamcrest.Matchers.containsString;
            expectThrows(ConnectTransportException.class, () -> service1.connectToNode(node2)).getMessage(),
        service2.connectToNode(node1, fut2);
            channelConsumer.accept(channel);
            logger.debug("got a dummy request, replying normally...");
        blackholedLinks.add(Tuple.tuple(node1, node2));
            }
        registerRequestHandler(service2, requestHandlerShouldNotBeCalled());
        assertThat(responseHandlerException.get().getCause().getMessage(), containsString("dummy exception"));
            }
            @Override
        if (disconnectedLinks.contains(link)) {
import org.opensearch.common.settings.Settings;
            null,
            @Override
import org.opensearch.common.collect.Tuple;
import java.util.List;
        final DisruptableMockTransport transport2 = new DisruptableMockTransport(node2, logger, deterministicTaskQueue) {
                onCalled.accept(exp);
    private TransportResponseHandler<TransportResponse> responseHandlerShouldBeCalledNormally(Runnable onCalled) {
        registerRequestHandler(service1, requestHandlerShouldNotBeCalled());
                return transports.stream().filter(t -> t.getLocalNode().getAddress().equals(address)).findAny();
            @Override
 *
                return transports.stream().filter(t -> t.getLocalNode().getAddress().equals(address)).findAny();
    }
        deterministicTaskQueue.runAllTasksInTimeOrder();
        deterministicTaskQueue.runAllRunnableTasks();
    }
        deterministicTaskQueue.runAllRunnableTasks();
            null,
        registerRequestHandler(service2, requestHandlerRepliesNormally());
        assertNotNull(responseHandlerChannel.get());
            @Override
            endsWith("is [BLACK_HOLE_REQUESTS_ONLY] not [CONNECTED]")
    }
