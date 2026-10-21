        super.doClose();
import org.opensearch.common.settings.Settings;
        TransportInterceptor interceptor,
     * Adds a send behavior that is the default send behavior.
     * Adds a get connection behavior that is the default get connection behavior.
            }
        });
import org.apache.logging.log4j.LogManager;
                        stopLatch.await(connectingTimeout.millis(), TimeUnit.MILLISECONDS);
        @Nullable Transport streamTransport,
    }
    }
            if (blockedActions.contains(action)) {
                });
 * specific language governing permissions and limitations
                assert openConnections.size() == 0 : "still open connections: " + openConnections;
     *
import org.opensearch.common.util.io.IOUtils;
     * on the regular transport. We try the regular transport's registry first
import org.opensearch.core.common.transport.TransportAddress;
     * <p>When the streaming transport is in use (e.g. {@code FlightStreamPlugin}
        Settings settings,
     *
            new MockPageCacheRecycler(settings),
        onStopListeners.add(listener);
     */
                    public void onFailure(Exception e) {
     * Adds a rule that will cause ignores each send request, simulating an unresponsive node
 *
                BytesStreamOutput bStream = new BytesStreamOutput();
        }
    }
            clusterSettings,
import org.opensearch.common.util.MockPageCacheRecycler;
    public void clearAllRules() {
            connection.addCloseListener(ActionListener.wrap(() -> {
        );
     * Clears all the registered rules.
            public void openConnection(
                    }
     *                        {@link TransportSettings#TRACE_LOG_INCLUDE_SETTING}.
                    if (openConnections.isEmpty()) {
     * @return {@code true} if no other send behavior was registered for any of the addresses bound by delegate service.
        } catch (InterruptedException e) {
                long requestId,
     *
        );
                RequestHandlerRegistry reg = MockTransportService.this.getRequestHandler(action);
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
    public void clearInboundRules() {
    /**
        @Nullable ClusterSettings clusterSettings,
        Tracer tracer
                if (delay.millis() <= 0) {
    }
                final RunOnce runnable = new RunOnce(new AbstractRunnable() {
    public void addUnresponsiveRule(TransportService transportService) {
                if (openConnections.isEmpty() == false) {
                } catch (InterruptedException e) {
            @Override
                logger.info("--> preventing {} request", action);
                    assert cleared == false;
                    @Override
                    connection.sendRequest(requestId, action, request, options);
                }
            null,
        ThreadPool threadPool,
import org.opensearch.plugins.Plugin;
import org.opensearch.core.action.ActionListener;
        connectionManager().clearBehaviors();
    }
                        runnable.run();
     *
                    } else {
            threadPool,
    }
 * Licensed to Elasticsearch under one or more contributor
        transport().clearOutboundBehaviors(transportAddress);
            settings,
        return connection;
        Set<String> taskHeaders,
        try {
        return new MockTransportService(
 * compatible open source license.
import java.util.function.Function;
            public void clearCallback() {
 * discovery node of the request, namely by DiscoveryNode.getAddress().
            connection.sendRequest(requestId, action, request, options);
            taskHeaders,
            Collections.emptySet(),
        Tracer tracer
                        stopLatch.await(delay.millis(), TimeUnit.MILLISECONDS);
     * registered on {@link StreamTransportService}'s underlying transport, not
        for (TransportAddress transportAddress : extractTransportAddresses(transportService)) {
        Version version,
            new StubbableTransport(transport),
            }
                        logger.debug("failed to send delayed request", e);
import org.opensearch.transport.Transport;
    @Override
            connection.close();
                stopLatch.countDown();
     * @return {@code true} if no other send behavior was registered for any of the addresses bound by delegate service.
 * A mock delegate service that allows to simulate different network topology failures.
            noRegistered &= addConnectBehavior(transportAddress, connectBehavior);
                toClose.add(connection);
                    if (cleared) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.original = transport.getDelegate();
        transportAddresses.add(boundTransportAddress.publishAddress());
                    requestsToSendWhenCleared.forEach(Runnable::run);
        }
            private final Queue<Runnable> requestsToSendWhenCleared = new LinkedBlockingDeque<>();
    public MockTransportService(
    public void addUnresponsiveRule(TransportAddress transportAddress) {
     */
        for (TransportAddress transportAddress : extractTransportAddresses(transportService)) {
 * SPDX-License-Identifier: Apache-2.0
            localNodeFactory,
                ConnectionProfile profile,
     */
                    cleared = true;
    /**
        public List<Setting<?>> getSettings() {
                    }
        }
import java.util.concurrent.CountDownLatch;
import org.opensearch.transport.TransportService;
/*
            addFailToSendNoConnectRule(transportAddress);
        for (TransportAddress transportAddress : extractTransportAddresses(transportService)) {
        if (streamTransport == null) return null;
        Settings settings,
        }
    private MockTransportService(
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    /**
 * Adding rules for a node is done by adding rules for all bound addresses of a node
        }
    @Override
        );
import org.opensearch.cluster.ClusterModule;
 * the Apache License, Version 2.0 (the "License"); you may
            }
        transport().addSendBehavior(transportAddress, new StubbableTransport.SendRequestBehavior() {
    public static MockNioTransport newMockTransport(Settings settings, Version version, ThreadPool threadPool) {
 * KIND, either express or implied.  See the License for the
            )
    private final Map<DiscoveryNode, List<Transport.Connection>> openConnections = new HashMap<>();
    public static MockTransportService createNewService(Settings settings, Version version, ThreadPool threadPool, Tracer tracer) {
                        connection.sendRequest(requestId, action, clonedRequest, options);
    }
import org.opensearch.transport.TransportInterceptor;
 * fake DiscoveryNode instances where the publish address is one of the bound addresses).
import org.opensearch.common.settings.Setting;
        // installed the wrapper via wrapStreamTransport — in that case we
     * Adds a get connection behavior that is used for communication with the given delegate address.
                String action,
     * back to the streaming transport's registry. Either way, the behavior
            threadPool,
        BoundTransportAddress boundTransportAddress = transportService.boundAddress();
        // share the SAME instance so the streamTransportService and this
import java.util.Queue;
        ThreadPool threadPool,
            streamTransportStub.addRequestHandlingBehavior(actionName, handlingBehavior);
     * Adds a new connect behavior that is used for creating connections with the given delegate service.
                    openConnections.wait(TimeUnit.SECONDS.toMillis(30L));
        return noRegistered;
                }
        onStopListeners.forEach(Runnable::run);
        Set<String> taskHeaders,
}
     * Adds a rule that will cause ignores each send request, simulating an unresponsive node
                version
     *                        updates for {@link TransportSettings#TRACE_LOG_EXCLUDE_SETTING} and
    }
                new ConnectTransportException(discoveryNode, "UNRESPONSIVE: simulated")
                DiscoveryNode.getRolesFromSettings(settings),
            ) {
        MockNioTransport mockTransport = newMockTransport(settings, version, threadPool);
            threadPool,
            )
    }
    /**
import org.opensearch.tasks.TaskManager;
        Settings settings,
    /**
            taskHeaders,
import java.util.concurrent.ConcurrentHashMap;
import org.opensearch.common.network.NetworkService;
 *
    /**
        this.streamTransportStub = streamTransport;
     *
        Settings settings,
    /**
    /**
                // TODO: Replace with proper setting
        TransportInterceptor interceptor,
import org.opensearch.common.util.concurrent.RunOnce;
            openConnections.computeIfAbsent(node, n -> new CopyOnWriteArrayList<>()).add(connection);
        HashSet<TransportAddress> transportAddresses = new HashSet<>();
     * Build the service.
    /**
        Version version,
            ) {
        }
 * (and the publish address, if different).
    public boolean addNodeConnectedBehavior(StubbableConnectionManager.NodeConnectedBehavior behavior) {
    }
                synchronized (this) {
    public Transport getOriginalTransport() {
package org.opensearch.test.transport;
        transport().addSendBehavior(transportAddress, (connection, requestId, action, request, options) -> {
     * @param duration the amount of time to delay sending and connecting.
 * You may obtain a copy of the License at
        @Nullable ClusterSettings clusterSettings,
                // don't send anything, the receiving node is unresponsive
                    original.openConnection(discoveryNode, profile, listener);
import org.opensearch.test.OpenSearchTestCase;
        return transportAddresses.toArray(new TransportAddress[0]);
        Set<String> taskHeaders,
    // TODO: we need to add support for mock version of StreamTransportService
     */
            // send the request, which will blow up
            settings,
    private static final Logger logger = LogManager.getLogger(MockTransportService.class);
            transportAddress,
 * this work for additional information regarding copyright
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
import org.apache.logging.log4j.Logger;
     * Clears the outbound rules associated with the provided delegate service.
                TimeValue delay = delaySupplier.get();
                settings,
     * @return {@code true} if no default node connected behavior was registered.
     */
import org.opensearch.transport.TransportSettings;
    private final StubbableTransport streamTransportStub;
    @Nullable
import org.opensearch.transport.RequestHandlerRegistry;
            @Override
     * Adds a node connected behavior that is the default node connected behavior.
        return createNewService(settings, version, threadPool, null, tracer);
import org.opensearch.transport.ConnectionProfile;
        }
    public boolean addConnectBehavior(TransportAddress transportAddress, StubbableTransport.OpenConnectionBehavior connectBehavior) {
            ),
        TransportInterceptor interceptor,
     * is added to fail as well.
        final long startTime = System.currentTimeMillis();
        Transport transport,
import org.opensearch.transport.nio.MockNioTransport;
        for (TransportAddress transportAddress : extractTransportAddresses(transportService)) {
        transport().addConnectBehavior(
import org.opensearch.threadpool.ThreadPool;
    public Transport.Connection openConnection(DiscoveryNode node, ConnectionProfile profile) {
            tracer
    private final Transport original;
            interceptor,
        @Nullable ClusterSettings clusterSettings,
            noRegistered &= addSendBehavior(transportAddress, sendBehavior);
     * fires when the matching request arrives.
        if (stub.hasHandler(actionName)) {
                settings.get(Node.NODE_NAME_SETTING.getKey(), UUIDs.randomBase64UUID())
        for (TransportAddress transportAddress : extractTransportAddresses(transportService)) {
import java.util.Collections;
    }
     * @return {@code true} if no default get connection behavior was registered.
                }
                    if (connections.isEmpty()) {
    public static MockTransportService createNewService(
     *
    public void addOnStopListener(Runnable listener) {
                        listener.onFailure(new ConnectTransportException(discoveryNode, "UNRESPONSIVE: simulated"));
            transport,
        // streamTransport may already be a StubbableTransport when MockNode
    public void addUnresponsiveRule(TransportAddress transportAddress, final TimeValue duration) {
        this(
        );
     *
     *
/**
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.common.unit.TimeValue;
    ) {
            tracer
     * is loaded), {@code FragmentExecutionAction.NAME}-style handlers are
        return (StubbableTransport) transport;
            new StubbableConnectionManager(new ClusterConnectionManager(settings, transport)),
 * ownership. Elasticsearch licenses this file to you under
        // Defer to the regular transport's behavior (which throws with a
    /**
     */
 */
import org.opensearch.Version;
                }
                // delayed sending - even if larger then the request timeout to simulated a potential late response from target node
            }
            tracer
     * Adds a rule that will cause matching operations to throw ConnectTransportExceptions
     * Adds a new send behavior that is used for communication with the given delegate address.
            return;
    /**
    }
        for (TransportAddress transportAddress : extractTransportAddresses(transportService)) {
            threadPool,
    }
        while (transport instanceof StubbableTransport) {
            @Override
     */
        ThreadPool threadPool,
        Transport transport,
    public boolean addGetConnectionBehavior(StubbableConnectionManager.GetConnectionBehavior behavior) {
    public MockTransportService(
            clusterSettings,
    public boolean addConnectBehavior(TransportService transportService, StubbableTransport.OpenConnectionBehavior connectBehavior) {
        );
 * The OpenSearch Contributors require contributions made to
    }
        ThreadPool threadPool,
        Tracer tracer
import org.opensearch.transport.StreamTransportService;
     */
        );
                    protected void doRun() throws IOException {
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
import java.util.HashMap;
            public void sendRequest(
        Transport transport,
                        threadPool.schedule(runnable, delay, ThreadPool.Names.GENERIC);
                synchronized (openConnections) {
        );
        Transport transport,
        @Nullable ClusterSettings clusterSettings,
            (transport, discoveryNode, profile, listener) -> listener.onFailure(
        Settings settings,
     *
        transport().addConnectBehavior(transportAddress, new StubbableTransport.OpenConnectionBehavior() {
                TransportRequestOptions options
            return;
                UUIDs.randomBase64UUID(),
            clusterSettings,
            transportAddress,
            return new MockTaskManager(settings, threadPool, taskHeaders);
            clusterSettings,
                    }
            settings,
        return connectionManager().setDefaultGetConnectionBehavior(behavior);
    }
 */
    public void addFailToSendNoConnectRule(TransportService transportService, final String... blockedActions) {
            NoopTracer.INSTANCE
            }
        Tracer tracer
                    if (delay.millis() < connectingTimeout.millis()) {
        Tracer tracer
 * GitHub history for details.
        boolean noRegistered = true;
        Set<String> taskHeaders,
     * Clears all the inbound rules.
        ThreadPool threadPool,
    }
     *
                    listener.onFailure(new ConnectTransportException(discoveryNode, "UNRESPONSIVE: simulated"));
     */
import java.util.function.Supplier;
     *
            interceptor,
     * and failing to connect once the rule was added.
    @Override
                    List<Transport.Connection> connections = openConnections.get(node);
    }
     * @param clusterSettings if non null the {@linkplain TransportService} will register with the {@link ClusterSettings} for settings
                boundAddress.publishAddress(),
                long requestId,
    }
        @Nullable ClusterSettings clusterSettings,
     * Adds a rule that will cause every send request to fail, and each new connect since the rule
            localNodeFactory,
import org.opensearch.test.tasks.MockTaskManager;
                        openConnections.notifyAll();
            private CountDownLatch stopLatch = new CountDownLatch(1);
        @Nullable ClusterSettings clusterSettings,
    }
    public static class TestPlugin extends Plugin {
                TimeValue connectingTimeout = TransportSettings.CONNECT_TIMEOUT.getDefault(Settings.EMPTY);
 * not use this file except in compliance with the License.
        ThreadPool threadPool,
     * @param duration the amount of time to delay sending and connecting.
                TransportRequest request,
        Set<String> taskHeaders,
                boundAddress.publishAddress(),
            taskHeaders,
    /**
    }
import org.opensearch.common.UUIDs;
        Transport transport = transport();
        super.doStop();
            addUnresponsiveRule(transportAddress);
                // responds).
        Settings settings,
import java.util.Arrays;
        Settings settings,
import org.opensearch.common.io.stream.BytesStreamOutput;
    public static MockTransportService createNewService(
     * Adds a new connect behavior that is used for creating connections with the given delegate address.
    public boolean addGetConnectionBehavior(TransportAddress transportAddress, StubbableConnectionManager.GetConnectionBehavior behavior) {
     * @return {@code true} if no other get connection behavior was registered for this address before.
                    boolean remove = connections.remove(connection);
    ) {
                request.writeTo(bStream);
                }
import org.opensearch.transport.ConnectTransportException;
        transport().clearInboundBehaviors();
     * Adds a new send behavior that is used for communication with the given delegate service.
        @Nullable ClusterSettings clusterSettings,
     */
                try {
        }
        StubbableTransport transport,
            public void clearCallback() {
        StubbableTransport stub = transport();
            clusterSettings,
     */
     * Build the service.
            transport = ((StubbableTransport) transport).getDelegate();
                    assert remove : "Should have removed connection";
                    }
    }
                TimeValue delay = delaySupplier.get();
        @Nullable StubbableTransport streamTransport,
import org.opensearch.transport.ClusterConnectionManager;
                    return;
            }
            new StubbableTransport(transport),
    public boolean addSendBehavior(StubbableTransport.SendRequestBehavior behavior) {
    public MockTransportService(
     * @return {@code true} if no other send behavior was registered for this address before.
public final class MockTransportService extends TransportService {
    private static StubbableTransport asStubbableStreamTransport(@Nullable Transport streamTransport) {
            return super.createTaskManager(settings, clusterSettings, threadPool, taskHeaders);
                String action,
    }
        transportAddresses.addAll(Arrays.asList(boundTransportAddress.boundAddresses()));
    private final List<Runnable> onStopListeners = new CopyOnWriteArrayList<>();
import java.util.concurrent.TimeUnit;
        TransportInterceptor interceptor,
            connection.sendRequest(requestId, action, request, options);
    }
            private boolean cleared = false;
     * and failing to connect once the rule was added.
            transport,
        return transport().addSendBehavior(transportAddress, sendBehavior);
            ) throws IOException {
        // useful message) so the caller error matches what they'd get
        Set<String> taskHeaders
     */
            (boundAddress) -> DiscoveryNode.createLocal(
 * software distributed under the License is distributed on an
     */
    }
    }
    }
        }
            streamTransport,
     * and failing to connect once the rule was added.
     */
     */
            }));
            boundAddress -> new DiscoveryNode(
            private Set<Transport.Connection> toClose = ConcurrentHashMap.newKeySet();
import org.opensearch.transport.TransportRequest;
    /**
                    IOUtils.close(toClose);
                // close to simulate that tcp-ip eventually times out and closes connection (necessary to ensure transport eventually
    private static TransportAddress[] extractTransportAddresses(TransportService transportService) {
     * @param clusterSettings if non null the {@linkplain TransportService} will register with the {@link ClusterSettings} for settings
    }
            namedWriteableRegistry,
            stub.addRequestHandlingBehavior(actionName, handlingBehavior);
     */
    }
                new ConnectTransportException(discoveryNode, "DISCONNECT: simulated")
                        requestsToSendWhenCleared.add(runnable);
    ) {
        return new StubbableTransport(streamTransport);
        Version version,
    }
import java.io.IOException;
            @Override
        Transport.Connection connection = super.openConnection(node, profile);
                // store the request to send it once the rule is cleared.
    public void addUnresponsiveRule(TransportService transportService, final TimeValue duration) {
        });
                    throw new RuntimeException(e);
    public boolean addSendBehavior(TransportAddress transportAddress, StubbableTransport.SendRequestBehavior sendBehavior) {
        } else {
     * Adds a rule that will cause matching operations to throw ConnectTransportExceptions
 * Internally it maps TransportAddress objects to rules that inject failures.
                if (delay.millis() <= 0) {
            version,
     *                        updates for {@link TransportSettings#TRACE_LOG_EXCLUDE_SETTING} and
                    return;
     * Adds a rule that will cause matching operations to throw ConnectTransportExceptions
        this(
        if (MockTaskManager.USE_MOCK_TASK_MANAGER_SETTING.get(settings)) {
            @Override
            @Override
    /**
    public static MockTransportService createNewService(
        TransportInterceptor interceptor,
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        });
            interceptor,
            ),
        });
        stub.addRequestHandlingBehavior(actionName, handlingBehavior);
        for (TransportAddress transportAddress : extractTransportAddresses(transportService)) {
        settings = Settings.builder().put(TransportSettings.PORT.getKey(), OpenSearchTestCase.getPortRange()).put(settings).build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                }
            tracer
import org.opensearch.transport.TransportRequestOptions;
            (transport, discoveryNode, profile, listener) -> listener.onFailure(
        String actionName,
                connection.close();
                        openConnections.remove(node);
     */
    public <R extends TransportRequest> void addRequestHandlingBehavior(
    /**
                Node.NODE_NAME_SETTING.get(settings),
    /**
            interceptor,
     */
        return transport().setDefaultSendBehavior(behavior);
    public void addFailToSendNoConnectRule(TransportService transportService) {
    public void addFailToSendNoConnectRule(TransportAddress transportAddress, final Set<String> blockedActions) {
    }
     * @return {@code true} if no default send behavior was registered
     *
     *
        transport().addConnectBehavior(
    /**
            threadPool,
        @Override
                        original.openConnection(discoveryNode, profile, listener);
/*
 * (for example, @see org.opensearch.discovery.HandshakingTransportAddressConnector, which constructs
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
        connectionManager().clearBehavior(transportAddress);
            addFailToSendNoConnectRule(transportAddress, blockedActions);
 */
    /**
            new NoneCircuitBreakerService(),
        transport().addSendBehavior(transportAddress, (connection, requestId, action, request, options) -> {
     * Clears the outbound rules associated with the provided delegate address.
    public void addFailToSendNoConnectRule(TransportService transportService, final Set<String> blockedActions) {
        addFailToSendNoConnectRule(transportService, new HashSet<>(Arrays.asList(blockedActions)));
                } catch (IOException e) {
    ) {
        // pre-streaming.
        Tracer tracer
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
                Transport.Connection connection,
        transport().addSendBehavior(transportAddress, new StubbableTransport.SendRequestBehavior() {
        return createNewService(settings, transport, version, threadPool, clusterSettings, taskHeaders, NOOP_TRANSPORT_INTERCEPTOR, tracer);
        return new MockNioTransport(
 * under the License.
    ) {
    public StubbableTransport transport() {
     * Adds a rule that will cause every send request to fail, and each new connect since the rule
    }
/*
                try {
        });
                Node.NODE_ATTRIBUTES.getAsMap(settings),
        return noRegistered;
                Transport.Connection connection,
 * Modifications Copyright OpenSearch Contributors. See
        }
        ThreadPool threadPool,
        return this.getLocalNode();
        ClusterSettings clusterSettings,
            localNodeFactory,
                final TransportRequest clonedRequest = reg.newRequest(bStream.bytes().streamInput());
    /**
 * Matching requests to rules is based on the delegate address associated with the
                DiscoveryNode discoveryNode,
        return createNewService(settings, mockTransport, version, threadPool, clusterSettings, Collections.emptySet(), tracer);
     */
        return connectionManager().setDefaultNodeConnectedBehavior(behavior);
    public void clearOutboundRules(TransportAddress transportAddress) {
            public void clearCallback() {
        boolean noRegistered = true;
        return transport().addConnectBehavior(transportAddress, connectBehavior);
    }
            transport,
 *
    @Override
    public StubbableConnectionManager connectionManager() {
            settings,
    public void addFailToSendNoConnectRule(TransportAddress transportAddress) {
import org.opensearch.common.Nullable;
        super(
        return transport;
        Settings settings,
            addUnresponsiveRule(transportAddress, duration);
     * Adds a rule that will cause ignores each send request, simulating an unresponsive node
        transport().clearBehaviors();
        this(
            synchronized (openConnections) {
        }
 * license agreements. See the NOTICE file distributed with
        if (streamTransport instanceof StubbableTransport stubbable) return stubbable;
    }
    }
                }
import java.util.List;
    public boolean addSendBehavior(TransportService transportService, StubbableTransport.SendRequestBehavior sendBehavior) {
import org.opensearch.telemetry.tracing.Tracer;
     */
                TransportRequestOptions options
            }
    /**
import org.opensearch.core.common.transport.BoundTransportAddress;
            return Arrays.asList(MockTaskManager.USE_MOCK_TASK_MANAGER_SETTING);
    }
import java.util.Map;
        }
    }
    protected TaskManager createTaskManager(
import java.util.HashSet;
                    @Override
        );
                    }
        }
        return connectionManager().addGetConnectionBehavior(transportAddress, behavior);
    }
     * Adds a rule that will cause ignores each send request, simulating an unresponsive node
     */
     */
        synchronized (openConnections) {
     * is added to fail as well.
import java.util.concurrent.CopyOnWriteArrayList;
 * Unless required by applicable law or agreed to in writing,
        // MockTransportService see the same handler registry. Wrap only if
                }
        return (StubbableConnectionManager) connectionManager;
    }
import org.opensearch.node.Node;
    }
import java.util.Set;
    }
     * Adds a new handling behavior that is used when the defined request is received.
            new NetworkService(Collections.emptyList()),
import org.opensearch.common.util.concurrent.AbstractRunnable;
            settings,
        }
            }
            public void sendRequest(
                synchronized (this) {
     * and failing to connect once the rule was added.
 * This address is usually the publish address of the node but can also be a different one
import org.opensearch.common.settings.ClusterSettings;
            interceptor,
 */
                ActionListener<Transport.Connection> listener
    /**
    }
    /**
    public void clearOutboundRules(TransportService transportService) {
     * @return {@code true} if no other send behavior was registered for this address before.
    ) {
     * (production-typical actions); if no handler is registered there, we fall
    ) {
        Tracer tracer
 * this file be licensed under the Apache-2.0 license or a
            threadPool,
        Transport transport,
import java.util.concurrent.LinkedBlockingDeque;
    protected void doStop() {
    ) {
    public DiscoveryNode getLocalDiscoNode() {
        ThreadPool threadPool,
     */
     */
    }
            taskHeaders,
                // poor mans request cloning...
                Transport transport,
        if (streamTransportStub != null && streamTransportStub.hasHandler(actionName)) {
    /**
        // it's a plain Transport (legacy callers that bypass the Node hook).
    ) {
     *                        {@link TransportSettings#TRACE_LOG_INCLUDE_SETTING}.
                    }
            clearOutboundRules(transportAddress);
    protected void doClose() throws IOException {
    /**
            tracer
            throw new IllegalStateException(e);
    }
            settings,
                TransportRequest request,
        StubbableTransport.RequestHandlingBehavior<R> handlingBehavior
                    } else {
            asStubbableStreamTransport(streamTransport),
        Supplier<TimeValue> delaySupplier = () -> new TimeValue(duration.millis() - (System.currentTimeMillis() - startTime));
