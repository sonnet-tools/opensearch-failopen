            localNodeFactory,
            NoopTracer.INSTANCE
                final TransportRequest clonedRequest = reg.newRequest(bStream.bytes().streamInput());
import org.opensearch.transport.TransportRequest;
            threadPool,
                boundAddress.publishAddress(),  
    }  
            return new MockTaskManager(settings, threadPool, taskHeaders);
        Transport transport = transport();
                    }  
        );  
     * Clears the outbound rules associated with the provided delegate service.
     */
     * on the regular transport. We try the regular transport's registry first
        for (TransportAddress transportAddress : extractTransportAddresses(transportService)) {  
        }  
    public void clearAllRules() {
    @Override
import org.opensearch.common.util.concurrent.RunOnce;
        Settings settings,
     */
    }
     * Adds a new connect behavior that is used for creating connections with the given delegate address.
        ThreadPool threadPool,
            @Override
     * @return {@code true} if no default node connected behavior was registered.
                ConnectionProfile profile,  
            connection.addCloseListener(ActionListener.wrap(() -> {
 * A mock delegate service that allows to simulate different network topology failures.
                }
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
     */  
        // pre-streaming.
import org.opensearch.transport.TransportInterceptor;
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,  
            clearOutboundRules(transportAddress);  
import org.opensearch.transport.nio.MockNioTransport;  
        Settings settings,
                TimeValue connectingTimeout = TransportSettings.CONNECT_TIMEOUT.getDefault(Settings.EMPTY);
        this.streamTransportStub = streamTransport;  
        );  
 * Adding rules for a node is done by adding rules for all bound addresses of a node
 * discovery node of the request, namely by DiscoveryNode.getAddress().
 */  
            ),  
    public void addUnresponsiveRule(TransportAddress transportAddress) {  
        return (StubbableConnectionManager) connectionManager;  
            if (blockedActions.contains(action)) {
    public <R extends TransportRequest> void addRequestHandlingBehavior(
     *  
        Transport.Connection connection = super.openConnection(node, profile);
 * specific language governing permissions and limitations
        TransportInterceptor interceptor,
        Tracer tracer  
            threadPool,
            public void clearCallback() {
import org.opensearch.common.network.NetworkService;  
     * Build the service.
    public void addUnresponsiveRule(TransportService transportService, final TimeValue duration) {  
    /**  
     * @param clusterSettings if non null the {@linkplain TransportService} will register with the {@link ClusterSettings} for settings
            public void sendRequest(  
                if (openConnections.isEmpty() == false) {
    }
 *
        }
import java.util.concurrent.LinkedBlockingDeque;
        settings = Settings.builder().put(TransportSettings.PORT.getKey(), OpenSearchTestCase.getPortRange()).put(settings).build();
    public void addFailToSendNoConnectRule(TransportService transportService, final String... blockedActions) {
    /**
     * Adds a node connected behavior that is the default node connected behavior.
                UUIDs.randomBase64UUID(),
            public void sendRequest(
 *
    private final List<Runnable> onStopListeners = new CopyOnWriteArrayList<>();
        this.original = transport.getDelegate();
        return new MockNioTransport(  
        transport().addConnectBehavior(transportAddress, new StubbableTransport.OpenConnectionBehavior() {
import org.opensearch.common.settings.ClusterSettings;
            addUnresponsiveRule(transportAddress);
        Set<String> taskHeaders,  
     */
                try {
    public void addOnStopListener(Runnable listener) {
            private CountDownLatch stopLatch = new CountDownLatch(1);  
    ) {
    public static class TestPlugin extends Plugin {
    }  
    ) {
    public boolean addSendBehavior(StubbableTransport.SendRequestBehavior behavior) {
    public DiscoveryNode getLocalDiscoNode() {  
 * The OpenSearch Contributors require contributions made to  
        synchronized (openConnections) {  
        }
        Transport transport,
import org.opensearch.cluster.ClusterModule;
        );
     * back to the streaming transport's registry. Either way, the behavior
    }
import org.opensearch.node.Node;
    /**  
     * Adds a rule that will cause ignores each send request, simulating an unresponsive node
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
    public static MockNioTransport newMockTransport(Settings settings, Version version, ThreadPool threadPool) {  
     */
                TimeValue delay = delaySupplier.get();
            threadPool,  
    public boolean addGetConnectionBehavior(TransportAddress transportAddress, StubbableConnectionManager.GetConnectionBehavior behavior) {  
                        runnable.run();
            noRegistered &= addConnectBehavior(transportAddress, connectBehavior);
import org.opensearch.core.common.transport.TransportAddress;  
    public static MockTransportService createNewService(  
 * Modifications Copyright OpenSearch Contributors. See
        // useful message) so the caller error matches what they'd get  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        transport().addConnectBehavior(  
    }
     *
    ) {
        // installed the wrapper via wrapStreamTransport — in that case we
/*  
            private Set<Transport.Connection> toClose = ConcurrentHashMap.newKeySet();  
                new ConnectTransportException(discoveryNode, "UNRESPONSIVE: simulated")
        for (TransportAddress transportAddress : extractTransportAddresses(transportService)) {
    /**
        @Nullable ClusterSettings clusterSettings,  
            public void clearCallback() {
            clusterSettings,  
        return this.getLocalNode();
import org.opensearch.common.unit.TimeValue;
     * Adds a new send behavior that is used for communication with the given delegate service.  
     */
            interceptor,
                    openConnections.wait(TimeUnit.SECONDS.toMillis(30L));  
                    }
        );
            }));
                assert openConnections.size() == 0 : "still open connections: " + openConnections;
                    } else {  
     * is added to fail as well.  
        return createNewService(settings, version, threadPool, null, tracer);  
            localNodeFactory,  
     * Adds a new handling behavior that is used when the defined request is received.  
 * This address is usually the publish address of the node but can also be a different one
                    if (openConnections.isEmpty()) {
import java.util.Map;
            private final Queue<Runnable> requestsToSendWhenCleared = new LinkedBlockingDeque<>();
/*
        Settings settings,
    }
    }
     * Adds a send behavior that is the default send behavior.
            @Override
        return transport().addSendBehavior(transportAddress, sendBehavior);  
        Set<String> taskHeaders
     * Clears all the registered rules.
import org.opensearch.telemetry.tracing.Tracer;
            public void openConnection(  
        return new StubbableTransport(streamTransport);  
        Transport transport,
                DiscoveryNode discoveryNode,
     *  
        onStopListeners.forEach(Runnable::run);
                Node.NODE_NAME_SETTING.get(settings),
    }  
        transport().clearBehaviors();
import org.opensearch.transport.TransportSettings;
import org.apache.logging.log4j.LogManager;
        ThreadPool threadPool,  
        }  
    public MockTransportService(
    }
     *
     * @return {@code true} if no other send behavior was registered for any of the addresses bound by delegate service.
     */
            )
                // TODO: Replace with proper setting  
        for (TransportAddress transportAddress : extractTransportAddresses(transportService)) {
        transportAddresses.addAll(Arrays.asList(boundTransportAddress.boundAddresses()));  
            openConnections.computeIfAbsent(node, n -> new CopyOnWriteArrayList<>()).add(connection);
        connectionManager().clearBehaviors();  
     *  
     */
            clusterSettings,
        return connection;
                TransportRequestOptions options
import org.opensearch.transport.Transport;  
     * Adds a get connection behavior that is the default get connection behavior.
     *                        {@link TransportSettings#TRACE_LOG_INCLUDE_SETTING}.  
        }
        } else {
                long requestId,
        ClusterSettings clusterSettings,
            throw new IllegalStateException(e);
    }
                // delayed sending - even if larger then the request timeout to simulated a potential late response from target node  
    @Override  
    ) {
 * (for example, @see org.opensearch.discovery.HandshakingTransportAddressConnector, which constructs  
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        @Nullable StubbableTransport streamTransport,  
 *     http://www.apache.org/licenses/LICENSE-2.0
                }  
     */
     * Adds a new send behavior that is used for communication with the given delegate address.
                // store the request to send it once the rule is cleared.
import org.opensearch.test.OpenSearchTestCase;
            threadPool,  
                if (delay.millis() <= 0) {
            null,  
    public boolean addSendBehavior(TransportService transportService, StubbableTransport.SendRequestBehavior sendBehavior) {
                }
     * Adds a rule that will cause ignores each send request, simulating an unresponsive node  
        transport().addConnectBehavior(
    }
     * is loaded), {@code FragmentExecutionAction.NAME}-style handlers are  
        TransportInterceptor interceptor,  
        TransportInterceptor interceptor,
import java.util.Arrays;  
            taskHeaders,
            taskHeaders,
        onStopListeners.add(listener);  
            threadPool,  
    /**
        transport().addSendBehavior(transportAddress, (connection, requestId, action, request, options) -> {
            stub.addRequestHandlingBehavior(actionName, handlingBehavior);
            ),
import java.util.function.Supplier;
            new StubbableTransport(transport),
 */
    private final Map<DiscoveryNode, List<Transport.Connection>> openConnections = new HashMap<>();  
        @Nullable ClusterSettings clusterSettings,
        @Override
        super.doClose();
                    return;
                        threadPool.schedule(runnable, delay, ThreadPool.Names.GENERIC);
}
        for (TransportAddress transportAddress : extractTransportAddresses(transportService)) {
    public MockTransportService(
            settings,
        return (StubbableTransport) transport;
     * registered on {@link StreamTransportService}'s underlying transport, not
    /**
    /**  
        if (streamTransport == null) return null;
            }
     */  
     */  
        super(
    private static final Logger logger = LogManager.getLogger(MockTransportService.class);
                    assert remove : "Should have removed connection";  
        stub.addRequestHandlingBehavior(actionName, handlingBehavior);
            tracer
import org.opensearch.tasks.TaskManager;
        // share the SAME instance so the streamTransportService and this
    /**  
            transport,
        return new MockTransportService(
                    requestsToSendWhenCleared.forEach(Runnable::run);
     *  
                    connection.sendRequest(requestId, action, request, options);  
    public void addFailToSendNoConnectRule(TransportService transportService, final Set<String> blockedActions) {  
import org.opensearch.cluster.node.DiscoveryNode;
 * SPDX-License-Identifier: Apache-2.0
            settings,  
 * You may obtain a copy of the License at  
                    @Override
     */  
        try {  
        }  
     * Adds a get connection behavior that is used for communication with the given delegate address.
import java.util.HashSet;  
                } catch (InterruptedException e) {
    public void addFailToSendNoConnectRule(TransportService transportService) {
     * Build the service.
        Settings settings,
import org.opensearch.transport.StreamTransportService;
        transport().addSendBehavior(transportAddress, new StubbableTransport.SendRequestBehavior() {
            }
    }
    private static TransportAddress[] extractTransportAddresses(TransportService transportService) {  
        return connectionManager().setDefaultNodeConnectedBehavior(behavior);
     *
    /**
     * and failing to connect once the rule was added.
 * compatible open source license.
    }
     * @param clusterSettings if non null the {@linkplain TransportService} will register with the {@link ClusterSettings} for settings  
        return transport().addConnectBehavior(transportAddress, connectBehavior);
 * Matching requests to rules is based on the delegate address associated with the  
        if (streamTransport instanceof StubbableTransport stubbable) return stubbable;
    public void clearInboundRules() {  
        TransportInterceptor interceptor,
                        logger.debug("failed to send delayed request", e);
        Transport transport,
        Transport transport,  
            localNodeFactory,
        ThreadPool threadPool,
    ) {  
        transport().addSendBehavior(transportAddress, (connection, requestId, action, request, options) -> {
            version,
import java.util.concurrent.TimeUnit;  
     *                        {@link TransportSettings#TRACE_LOG_INCLUDE_SETTING}.
            ) {
                    } else {
    }
    ) {
                    return;  
                    protected void doRun() throws IOException {
public final class MockTransportService extends TransportService {  
    }
        this(  
                TransportRequestOptions options
                    if (delay.millis() < connectingTimeout.millis()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                });
    public void clearOutboundRules(TransportAddress transportAddress) {
        });
    }  
    /**  
     */  
     * @return {@code true} if no other send behavior was registered for this address before.
     */
import org.opensearch.core.common.transport.BoundTransportAddress;
    public void addFailToSendNoConnectRule(TransportAddress transportAddress) {
import java.util.Queue;  
    }  
import java.util.Collections;
                    }  
            return;
        @Nullable ClusterSettings clusterSettings,
        }
    /**
     * is added to fail as well.
package org.opensearch.test.transport;
    public boolean addGetConnectionBehavior(StubbableConnectionManager.GetConnectionBehavior behavior) {  
        return connectionManager().addGetConnectionBehavior(transportAddress, behavior);
    }
        ThreadPool threadPool,
        StubbableTransport.RequestHandlingBehavior<R> handlingBehavior  
        ThreadPool threadPool,
    protected void doStop() {
        for (TransportAddress transportAddress : extractTransportAddresses(transportService)) {
    }
            interceptor,
            (transport, discoveryNode, profile, listener) -> listener.onFailure(
                request.writeTo(bStream);
                    IOUtils.close(toClose);
import org.apache.logging.log4j.Logger;
                Transport.Connection connection,  
    public StubbableConnectionManager connectionManager() {
    }  
                // poor mans request cloning...
            }
 * Internally it maps TransportAddress objects to rules that inject failures.  
        TransportInterceptor interceptor,  
            boundAddress -> new DiscoveryNode(  
    public boolean addNodeConnectedBehavior(StubbableConnectionManager.NodeConnectedBehavior behavior) {  
    public static MockTransportService createNewService(  
            asStubbableStreamTransport(streamTransport),
    /**  
                        listener.onFailure(new ConnectTransportException(discoveryNode, "UNRESPONSIVE: simulated"));
    /**
        boolean noRegistered = true;  
        });
            transport,
                // don't send anything, the receiving node is unresponsive
        });
        );  
            new NoneCircuitBreakerService(),
            (transport, discoveryNode, profile, listener) -> listener.onFailure(  
    // TODO: we need to add support for mock version of StreamTransportService  
     */
import org.opensearch.threadpool.ThreadPool;  
     * <p>When the streaming transport is in use (e.g. {@code FlightStreamPlugin}
 * the Apache License, Version 2.0 (the "License"); you may
        Supplier<TimeValue> delaySupplier = () -> new TimeValue(duration.millis() - (System.currentTimeMillis() - startTime));  
            return;  
import org.opensearch.core.action.ActionListener;  
                TransportRequest request,
    }
    /**
                Transport transport,
        }
        Set<String> taskHeaders,  
            transportAddress,
 * fake DiscoveryNode instances where the publish address is one of the bound addresses).
            namedWriteableRegistry,  
    /**
                }  
     */
            taskHeaders,  
        @Nullable ClusterSettings clusterSettings,
 */  
    }
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
 * ownership. Elasticsearch licenses this file to you under  
            interceptor,
    protected TaskManager createTaskManager(  
import java.util.concurrent.CopyOnWriteArrayList;  
        }
        Set<String> taskHeaders,
            new NetworkService(Collections.emptyList()),
            connection.sendRequest(requestId, action, request, options);
 * under the License.  
     */
            }  
     * Adds a rule that will cause matching operations to throw ConnectTransportExceptions
                        openConnections.notifyAll();
        }  
     */
            interceptor,
                } catch (IOException e) {
import org.opensearch.plugins.Plugin;  
    /**
                }  
    @Override  
                settings,  
                synchronized (openConnections) {  
     *                        updates for {@link TransportSettings#TRACE_LOG_EXCLUDE_SETTING} and
     * Adds a rule that will cause ignores each send request, simulating an unresponsive node
        StubbableTransport transport,
        return noRegistered;
    private final StubbableTransport streamTransportStub;
                        requestsToSendWhenCleared.add(runnable);  
        return createNewService(settings, transport, version, threadPool, clusterSettings, taskHeaders, NOOP_TRANSPORT_INTERCEPTOR, tracer);  
     *
        while (transport instanceof StubbableTransport) {
    /**  
                        connection.sendRequest(requestId, action, clonedRequest, options);  
    }
                    boolean remove = connections.remove(connection);
                    if (connections.isEmpty()) {
import java.util.function.Function;
        Version version,  
        Settings settings,  
                }
                    public void onFailure(Exception e) {  
            tracer  
            )
import org.opensearch.transport.RequestHandlerRegistry;
        final long startTime = System.currentTimeMillis();
     * and failing to connect once the rule was added.
                ActionListener<Transport.Connection> listener
     * Clears the outbound rules associated with the provided delegate address.
import java.util.List;
 * license agreements. See the NOTICE file distributed with
    public MockTransportService(
    }
    public void addFailToSendNoConnectRule(TransportAddress transportAddress, final Set<String> blockedActions) {  
        // it's a plain Transport (legacy callers that bypass the Node hook).
import org.opensearch.common.util.concurrent.AbstractRunnable;  
                String action,
        public List<Setting<?>> getSettings() {  
        @Nullable Transport streamTransport,
            (boundAddress) -> DiscoveryNode.createLocal(
 */
     *
     */  
                        stopLatch.await(connectingTimeout.millis(), TimeUnit.MILLISECONDS);
        transport().addSendBehavior(transportAddress, new StubbableTransport.SendRequestBehavior() {  
        transport().clearInboundBehaviors();
import org.opensearch.transport.ClusterConnectionManager;
                boundAddress.publishAddress(),
                Transport.Connection connection,
                String action,  
     * Adds a rule that will cause ignores each send request, simulating an unresponsive node
                new ConnectTransportException(discoveryNode, "DISCONNECT: simulated")  
    }
    }
    /**  
            @Override  
            tracer  
                connection.close();
    }  
        return noRegistered;  
     * Adds a new connect behavior that is used for creating connections with the given delegate service.
            addFailToSendNoConnectRule(transportAddress, blockedActions);
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
                TimeValue delay = delaySupplier.get();  
import java.util.concurrent.CountDownLatch;
import org.opensearch.common.UUIDs;
                try {  
        addFailToSendNoConnectRule(transportService, new HashSet<>(Arrays.asList(blockedActions)));  
 * software distributed under the License is distributed on an
    private final Transport original;
                // responds).
            @Override
            interceptor,
        Tracer tracer
        return transport;
    public static MockTransportService createNewService(
                synchronized (this) {
     * (production-typical actions); if no handler is registered there, we fall  
            }  
    }
import org.opensearch.transport.ConnectionProfile;  
                }
     * Clears all the inbound rules.
        return connectionManager().setDefaultGetConnectionBehavior(behavior);
    public boolean addConnectBehavior(TransportAddress transportAddress, StubbableTransport.OpenConnectionBehavior connectBehavior) {  
            }
    /**
            clusterSettings,
        Settings settings,
        }
        Transport transport,  
import java.util.Set;
        StubbableTransport stub = transport();
                    }  
import org.opensearch.common.settings.Setting;
    public void addUnresponsiveRule(TransportAddress transportAddress, final TimeValue duration) {  
    }
                        openConnections.remove(node);
        HashSet<TransportAddress> transportAddresses = new HashSet<>();
 * (and the publish address, if different).
        ThreadPool threadPool,
        Tracer tracer
            addFailToSendNoConnectRule(transportAddress);  
        String actionName,
        Settings settings,
        if (stub.hasHandler(actionName)) {  
    }
    }  
    /**
                settings.get(Node.NODE_NAME_SETTING.getKey(), UUIDs.randomBase64UUID())
    public static MockTransportService createNewService(Settings settings, Version version, ThreadPool threadPool, Tracer tracer) {
import org.opensearch.common.io.stream.BytesStreamOutput;
     *                        updates for {@link TransportSettings#TRACE_LOG_EXCLUDE_SETTING} and
     */  
                if (delay.millis() <= 0) {
        Set<String> taskHeaders,  
        }  
        @Nullable ClusterSettings clusterSettings,
     */
        Tracer tracer
                BytesStreamOutput bStream = new BytesStreamOutput();  
                version  
 *  
        // streamTransport may already be a StubbableTransport when MockNode  
    private static StubbableTransport asStubbableStreamTransport(@Nullable Transport streamTransport) {  
                final RunOnce runnable = new RunOnce(new AbstractRunnable() {
        // Defer to the regular transport's behavior (which throws with a
    }
            connection.sendRequest(requestId, action, request, options);  
        ThreadPool threadPool,
            public void clearCallback() {  
import java.util.concurrent.ConcurrentHashMap;
    }
        Settings settings,
        for (TransportAddress transportAddress : extractTransportAddresses(transportService)) {
            settings,
            noRegistered &= addSendBehavior(transportAddress, sendBehavior);
                    throw new RuntimeException(e);  
        @Nullable ClusterSettings clusterSettings,
 * GitHub history for details.
/**
            addUnresponsiveRule(transportAddress, duration);
            transportAddress,
            taskHeaders,
    public StubbableTransport transport() {
        Version version,  
                // close to simulate that tcp-ip eventually times out and closes connection (necessary to ensure transport eventually
     */
            settings,  
    protected void doClose() throws IOException {
                logger.info("--> preventing {} request", action);  
    }
        });
        super.doStop();  
        );
            tracer  
    ) {
            synchronized (openConnections) {
                RequestHandlerRegistry reg = MockTransportService.this.getRequestHandler(action);
     * Adds a rule that will cause every send request to fail, and each new connect since the rule
                        original.openConnection(discoveryNode, profile, listener);
            new StubbableTransport(transport),
        return transportAddresses.toArray(new TransportAddress[0]);
     *
     * and failing to connect once the rule was added.
                    }
            @Override  
import org.opensearch.common.util.io.IOUtils;
                        stopLatch.await(delay.millis(), TimeUnit.MILLISECONDS);
import java.io.IOException;
            streamTransportStub.addRequestHandlingBehavior(actionName, handlingBehavior);
            // send the request, which will blow up  
                    }
            new StubbableConnectionManager(new ClusterConnectionManager(settings, transport)),
    public boolean addConnectBehavior(TransportService transportService, StubbableTransport.OpenConnectionBehavior connectBehavior) {
import org.opensearch.test.tasks.MockTaskManager;
                synchronized (this) {
            threadPool,  
     * @param duration the amount of time to delay sending and connecting.
     * @return {@code true} if no other send behavior was registered for any of the addresses bound by delegate service.  
        return transport().setDefaultSendBehavior(behavior);  
     * @return {@code true} if no other get connection behavior was registered for this address before.
import org.opensearch.common.util.MockPageCacheRecycler;
import org.opensearch.transport.TransportRequestOptions;  
                Node.NODE_ATTRIBUTES.getAsMap(settings),
import org.opensearch.common.settings.Settings;  
    ) {
        @Nullable ClusterSettings clusterSettings,
                long requestId,
    }
        // MockTransportService see the same handler registry. Wrap only if  
            return Arrays.asList(MockTaskManager.USE_MOCK_TASK_MANAGER_SETTING);
    }
            private boolean cleared = false;
 * KIND, either express or implied.  See the License for the
        Set<String> taskHeaders,  
                    List<Transport.Connection> connections = openConnections.get(node);
     * Adds a rule that will cause matching operations to throw ConnectTransportExceptions  
     * @return {@code true} if no other send behavior was registered for this address before.  
    public void clearOutboundRules(TransportService transportService) {
        );
/*  
            clusterSettings,
     * Adds a rule that will cause matching operations to throw ConnectTransportExceptions
        for (TransportAddress transportAddress : extractTransportAddresses(transportService)) {  
 * not use this file except in compliance with the License.
        connectionManager().clearBehavior(transportAddress);  
import java.util.HashMap;
            streamTransport,
    }  
                    listener.onFailure(new ConnectTransportException(discoveryNode, "UNRESPONSIVE: simulated"));
 * this work for additional information regarding copyright
            settings,
        }
            }
     */
        }  
            clusterSettings,  
            transport,  
     */
        if (streamTransportStub != null && streamTransportStub.hasHandler(actionName)) {
        Tracer tracer
    }  
        );
    public Transport getOriginalTransport() {  
    public boolean addSendBehavior(TransportAddress transportAddress, StubbableTransport.SendRequestBehavior sendBehavior) {
    /**
     * fires when the matching request arrives.
    }
        if (MockTaskManager.USE_MOCK_TASK_MANAGER_SETTING.get(settings)) {  
        Version version,  
import org.opensearch.transport.ConnectTransportException;
     * @return {@code true} if no default get connection behavior was registered.
        transport().clearOutboundBehaviors(transportAddress);
        this(
                DiscoveryNode.getRolesFromSettings(settings),
            ) throws IOException {
        });  
    /**  
            settings,
                    cleared = true;
                    @Override
import org.opensearch.Version;  
                toClose.add(connection);
            }  
import org.opensearch.common.Nullable;  
            transport = ((StubbableTransport) transport).getDelegate();  
        } catch (InterruptedException e) {
    private MockTransportService(  
        ThreadPool threadPool,
    /**
 * this file be licensed under the Apache-2.0 license or a
    ) {
     * and failing to connect once the rule was added.  
    }
        MockNioTransport mockTransport = newMockTransport(settings, version, threadPool);
        transportAddresses.add(boundTransportAddress.publishAddress());
     *  
            connection.close();
    /**  
            ) {  
            Collections.emptySet(),
                    original.openConnection(discoveryNode, profile, listener);
     *  
     * @param duration the amount of time to delay sending and connecting.
    }
                stopLatch.countDown();
        this(  
        return createNewService(settings, mockTransport, version, threadPool, clusterSettings, Collections.emptySet(), tracer);  
            return super.createTaskManager(settings, clusterSettings, threadPool, taskHeaders);  
    public Transport.Connection openConnection(DiscoveryNode node, ConnectionProfile profile) {  
import org.opensearch.transport.TransportService;
    @Nullable  
            new MockPageCacheRecycler(settings),
            @Override
                TransportRequest request,  
    @Override
        Tracer tracer  
     *  
                    if (cleared) {  
    }
            tracer
        Tracer tracer
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
     * Adds a rule that will cause every send request to fail, and each new connect since the rule
        BoundTransportAddress boundTransportAddress = transportService.boundAddress();
    public void addUnresponsiveRule(TransportService transportService) {
                    assert cleared == false;  
        boolean noRegistered = true;
                }
     * @return {@code true} if no default send behavior was registered  
