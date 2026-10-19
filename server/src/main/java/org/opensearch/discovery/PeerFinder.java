    public static final Setting<TimeValue> DISCOVERY_FIND_PEERS_INTERVAL_DURING_DECOMMISSION_SETTING = Setting.timeSetting(
    private final ConfiguredHostsResolver configuredHostsResolver;
                logger.trace("{} not requesting peers from local node", this);  
        @Nullable
        private volatile boolean peersRequestInFlight;
                logger.trace("probing resolved transport addresses {}", providedAddresses);
import static java.util.Collections.emptyList;
                + peersRequestInFlight
            "setting findPeersInterval to [{}] as node commission status = [{}] for local node [{}]",  
    public static final Setting<TimeValue> DISCOVERY_REQUEST_PEERS_TIMEOUT_SETTING = Setting.timeSetting(  
     *  
import org.opensearch.common.unit.TimeValue;
                    synchronized (mutex) {
                providedAddresses.forEach(this::startProbe);  
                        return;
                }  
        Setting.Property.NodeScope
            false,  
        final boolean peersRemoved = peersByAddress.values().removeIf(Peer::handleWakeUp);
        }
         *                 progress.
        return lastResolvedAddresses;
import org.opensearch.cluster.node.DiscoveryNodes;  
            this.leader = Optional.of(leader);
        /**
    );
     */  
                }
    }
import org.opensearch.transport.TransportRequestOptions;  
         */  
                        if (active == false) {
                + discoveryNode.get()  
    private volatile List<TransportAddress> lastResolvedAddresses = emptyList();  
        Setting.Property.NodeScope  
        return currentTerm;
 *
     * Resolves the configured unicast host.
                    peersRequestInFlight = false;  
import java.util.Objects;
    private Peer createConnectingPeer(TransportAddress transportAddress) {
import org.opensearch.transport.TransportException;
    }  
            );  
            logger.trace("not active");
        private SetOnce<DiscoveryNode> discoveryNode = new SetOnce<>();
            assert assertInactiveWithNoKnownPeers();  
     * @opensearch.internal
                @Override
 * @opensearch.internal  
        logger.trace("probing cluster-manager nodes from cluster state: {}", lastAcceptedNodes);  
    // the time between attempts to find all peers
        peer.establishConnection();
        assert active == false;
    }
     * that the change to the set of found peers happens before this method is invoked. If there are multiple concurrent changes then there
        if (transportAddress.equals(getLocalNode().getAddress())) {  
        }
                return "PeerFinder handling wakeup";
}  
 *  
 * this work for additional information regarding copyright
        assert holdsLock() : "PeerFinder mutex not held";
        peersByAddress.computeIfAbsent(transportAddress, this::createConnectingPeer);
            }
                @Override
        Settings settings,  
    TimeValue getFindPeersInterval() {
                assert false : e;  
import java.util.LinkedHashMap;
    }  
        );
    }
            }
                onFoundPeersUpdated();
    /**
        findPeersInterval = DISCOVERY_FIND_PEERS_INTERVAL_SETTING.get(settings);  
import org.opensearch.common.settings.Settings;
    ) {
        void establishConnection() {
import org.opensearch.core.common.transport.TransportAddress;  
        transportService.getThreadPool().scheduleUnlessShuttingDown(findPeersInterval, Names.GENERIC, new AbstractRunnable() {
        configuredHostsResolver.resolveConfiguredHosts(providedAddresses -> {
    }
                }
public abstract class PeerFinder {
                public PeersResponse read(StreamInput in) throws IOException {  
                + ", peersRequestInFlight="
                    }
     * synchronisation to avoid lost updates. Also, by the time this method is invoked we may have been deactivated.
     * Transport address connector interface.
                        requestPeers();
                @Override
            public String toString() {  
         * Identify the node at the given address and, if it is a cluster-manager node and not the local node then establish a full connection to it.
                synchronized (mutex) {  
    /**
    protected void startProbe(TransportAddress transportAddress) {
                lastResolvedAddresses = providedAddresses;
 * SPDX-License-Identifier: Apache-2.0
     * @opensearch.internal
                logger.debug("unexpected exception in wakeup", e);
    public PeerFinder(
        TimeValue.timeValueMillis(1),  
            if (active == false) {
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
        private void requestPeers() {  
            final DiscoveryNode discoveryNode = getDiscoveryNode();
        "discovery.request_peers_timeout",
        }  
    private final TransportService transportService;  
            @Override
        void connectToRemoteMasterNode(TransportAddress transportAddress, ActionListener<DiscoveryNode> listener);
                    }  
import org.opensearch.transport.TransportResponseHandler;
     * Invoked when the set of found peers changes. Note that invocations of this method are not fully synchronised, so we only guarantee
    // package private for tests
                }
            .stream()
        synchronized (mutex) {
                assert leader.isPresent() == false : leader;  
        final boolean peersRemoved;  
    }  
        assert localNode != null;
                        }
    // exposed for checking invariant in o.e.c.c.Coordinator (public since this is a different package)
    private final Object mutex = new Object();
 * software distributed under the License is distributed on an
    }
        }
        return peersRemoved;
    protected abstract void onFoundPeersUpdated();
            return getFoundPeersUnderLock();  
                    logger.debug(() -> new ParameterizedMessage("{} connection failed", Peer.this), e);
            return;  
        synchronized (mutex) {
                    logger.trace("{} no longer connected", this);
     */
/*
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
            }  
        }
                + ", discoveryNode="
import org.apache.logging.log4j.LogManager;
            logger.trace("{} requesting peers", this);
                @Override
        public String toString() {
     * Note that invocations of this method are not synchronised. By the time it is called we may have been deactivated.
    public Optional<DiscoveryNode> getLeader() {  
            assert holdsLock() : "PeerFinder mutex not held";
    // the time between attempts to find all peers when node is in decommissioned state, default set to 2 minutes
 * The OpenSearch Contributors require contributions made to  
        private final TransportAddress transportAddress;  
import java.util.stream.Collectors;
            final DiscoveryNode discoveryNode = getDiscoveryNode();
import org.opensearch.transport.TransportService;
            };
    }
                            return;
    private final TransportAddressConnector transportAddressConnector;
    // exposed to subclasses for testing
        Peer(TransportAddress transportAddress) {
 */  
                        response.getClusterManagerNode().map(DiscoveryNode::getAddress).ifPresent(PeerFinder.this::startProbe);
 *     http://www.apache.org/licenses/LICENSE-2.0
        TransportAddressConnector transportAddressConnector,
                return true;
                TransportRequestOptions.builder().withTimeout(requestPeersTimeout).build(),
        synchronized (mutex) {
        this.settings = settings;
 */
    /**
            logger.trace("{} attempting connection", this);  
 *
    private boolean handleWakeUp() {
            final List<DiscoveryNode> knownNodes = getFoundPeersUnderLock();
                        // Must not hold lock here to avoid deadlock
            assert assertInactiveWithNoKnownPeers();
import java.io.IOException;
        return peersByAddress.values()  
 * the Apache License, Version 2.0 (the "License"); you may
        }
        transportService.registerRequestHandler(  
        TimeValue.timeValueMillis(1000),
            active = false;  
                public String executor() {
         */  
    private final Map<TransportAddress, Peer> peersByAddress = new LinkedHashMap<>();
                knownPeers = emptyList();
            startProbe(discoveryNodeObjectCursor.getAddress());
                    assert holdsLock() == false : "PeerFinder mutex is held in error";
    }  
                }
            }  
        logger.info(
    }
    private DiscoveryNode getLocalNode() {  
            .collect(Collectors.toList());
                    assert remoteNode.isClusterManagerNode() : remoteNode + " is not cluster-manager-eligible";
        });
/*  
 * not use this file except in compliance with the License.
    private final Settings settings;
 * You may obtain a copy of the License at  
import java.util.Map;
    }
                if (peersRequest.getSourceNode().isClusterManagerNode()) {
     */  
    // exposed for checking invariant in o.e.c.c.Coordinator (public since this is a different package)  
/*  
    public void activate(final DiscoveryNodes lastAcceptedNodes) {  
        assert holdsLock() : "PeerFinder mutex not held";  
    public interface ConfiguredHostsResolver {  
        "discovery.find_peers_interval_during_decommission",  
                    startProbe(peersRequest.getSourceNode().getAddress());
            public boolean isForceExecution() {  
                + "transportAddress="  
    private volatile long currentTerm;
        TimeValue.timeValueSeconds(120L),
        /**
                    return true;  
            PeersRequest::new,
            @Override
    }
    public synchronized void onNodeCommissionStatusChange(boolean localNodeCommissioned) {
        });  
            if (discoveryNode.equals(getLocalNode())) {
            });  
            .filter(Objects::nonNull)  
        return peer;
            assert discoveryNode != null : "cannot request peers without first connecting";  
 */  
        this.transportService = transportService;
            }
    }
                return;
 *
            this.transportAddress = transportAddress;
import java.util.List;  
        return findPeersInterval;  
                        requestPeers();
                    assert remoteNode.equals(getLocalNode()) == false : remoteNode + " is the local node";
            @Override
            }
import java.util.function.Consumer;
import org.opensearch.common.util.concurrent.AbstractRunnable;  
                + '}';  
                return true;
                    }
                        discoveryNode.set(remoteNode);  
            assert active;
        assert holdsLock() : "PeerFinder mutex not held";  
                        if (active == false) {
        return true;
            if (discoveryNode != null) {
    public void deactivate(DiscoveryNode leader) {
        return localNode;  
    private class Peer {
            assert getDiscoveryNode() == null : "unexpectedly connected to " + getDiscoveryNode();  
     * @return whether any peers were removed due to disconnection  
            leader = Optional.empty();
            peersRequestInFlight = true;
        Setting.Property.NodeScope
            assert active;  
                    return new PeersResponse(in);
import org.opensearch.threadpool.ThreadPool.Names;
    public long getCurrentTerm() {
import org.opensearch.common.settings.Setting;  
        TimeValue.timeValueMillis(1000),
        return Thread.holdsLock(mutex);  
                }
            return "Peer{"
                        }  
        }  
        final DiscoveryNode localNode = transportService.getLocalNode();
                assert leader.isPresent() || lastAcceptedNodes == null;
        boolean handleWakeUp() {
            this.lastAcceptedNodes = lastAcceptedNodes;  
     * updated set of peers as an argument to this method, leaving it to the implementation to call getFoundPeers() with appropriate
            return peersRemoved;  
        logger.trace("activating with {}", lastAcceptedNodes);
            ? DISCOVERY_FIND_PEERS_INTERVAL_SETTING.get(settings)  
        TimeValue.timeValueMillis(3000),
 * Modifications Copyright OpenSearch Contributors. See
                            return;  
    public interface TransportAddressConnector {  
        if (active == false) {
import org.opensearch.cluster.node.DiscoveryNode;
 * specific language governing permissions and limitations
            findPeersInterval,
        this.configuredHostsResolver = configuredHostsResolver;
            logger.trace("startProbe({}) not running", transportAddress);
        findPeersInterval = localNodeCommissioned
        DiscoveryNode getDiscoveryNode() {  
            false,
            transportService.sendRequest(  
            logger.trace("deactivating and setting leader to {}", leader);
            // may be null if connection not yet established  
        for (final DiscoveryNode discoveryNodeObjectCursor : lastAcceptedNodes.getClusterManagerNodes().values()) {
    private List<DiscoveryNode> getFoundPeersUnderLock() {
            }  
        }  
import org.opensearch.cluster.coordination.PeersResponse;
        }
import org.apache.logging.log4j.Logger;
 * this file be licensed under the Apache-2.0 license or a
            return;
                public void handleResponse(PeersResponse response) {
            public void onFailure(Exception e) {
        requestPeersTimeout = DISCOVERY_REQUEST_PEERS_TIMEOUT_SETTING.get(settings);
        assert holdsLock() : "PeerFinder mutex not held";
import org.opensearch.common.Nullable;
    public static final Setting<TimeValue> DISCOVERY_FIND_PEERS_INTERVAL_SETTING = Setting.timeSetting(  
    private DiscoveryNodes lastAcceptedNodes;  
            return false;
            assert peersRequestInFlight == false : "PeersRequest already in flight";
     * will be multiple concurrent invocations of this method, with no guarantee as to their order. For this reason we do not pass the  
     */
            active = true;
    }
            REQUEST_PEERS_ACTION_NAME,
        TimeValue.timeValueMillis(1),  
                        assert discoveryNode.get() == null : "discoveryNode unexpectedly already set to " + discoveryNode.get();
    private static final Logger logger = LogManager.getLogger(PeerFinder.class);
    private Optional<DiscoveryNode> leader = Optional.empty();
            : DISCOVERY_FIND_PEERS_INTERVAL_DURING_DECOMMISSION_SETTING.get(settings);
    public Iterable<DiscoveryNode> getFoundPeers() {
package org.opensearch.discovery;
    protected abstract void onActiveClusterManagerFound(DiscoveryNode clusterManagerNode, long term);
            assert holdsLock() : "PeerFinder mutex not held";
        }
import java.util.Optional;  
    );
        synchronized (mutex) {  
        }  
        ConfiguredHostsResolver configuredHostsResolver  
    }
            handleWakeUp(); // return value discarded: there are no known peers, so none can be disconnected
import org.opensearch.core.action.ActionListener;
 * under the License.  
    private boolean assertInactiveWithNoKnownPeers() {  
                    logger.debug(new ParameterizedMessage("{} peers request failed", Peer.this), exp);
         * @param consumer Consumer for the resolved list. May not be called if an error occurs or if another resolution attempt is in
                REQUEST_PEERS_ACTION_NAME,
    public List<TransportAddress> getLastResolvedAddresses() {  
            (request, channel, task) -> channel.sendResponse(handlePeersRequest(request))  
        }
 * compatible open source license.
            .distinct()
    private boolean active;
            } else {  
        if (peersRemoved) {
                peersResponseHandler
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    return Names.GENERIC;  
        @Override  
                discoveryNode,
        }  
    }  
    public void setCurrentTerm(long currentTerm) {
        void resolveConfiguredHosts(Consumer<List<TransportAddress>> consumer);
import org.opensearch.common.SetOnce;
    public static final String REQUEST_PEERS_ACTION_NAME = "internal:discovery/request_peers";  
            return leader;
        }
        Peer peer = new Peer(transportAddress);  
     *  
            synchronized (mutex) {  
                public void handleException(TransportException exp) {
            assert holdsLock() : "PeerFinder mutex not held";
        this.currentTerm = currentTerm;  
 * ownership. Elasticsearch licenses this file to you under  
        TransportService transportService,
        }
            return discoveryNode.get();
            protected void doRun() {
                    if (handleWakeUp() == false) {
     */
            assert peersRequest.getSourceNode().equals(getLocalNode()) == false;  
    private final TimeValue requestPeersTimeout;  
                        assert holdsLock() == false : "PeerFinder mutex is held in error";
                    }
            }
            localNodeCommissioned,
        synchronized (mutex) {
        if (active == false) {
                if (transportService.nodeConnected(discoveryNode)) {  
        assert peersByAddress.isEmpty() : peersByAddress.keySet();  
                        peersRequestInFlight = false;  
                new PeersRequest(getLocalNode(), knownNodes),  
                    synchronized (mutex) {
            if (active) {
                }
import org.opensearch.core.common.io.stream.StreamInput;
                knownPeers = getFoundPeersUnderLock();
    }
                + transportAddress
import org.apache.logging.log4j.message.ParameterizedMessage;  
                    }  
            transportAddressConnector.connectToRemoteMasterNode(transportAddress, new ActionListener<DiscoveryNode>() {
            peersRemoved = handleWakeUp();
    PeersResponse handlePeersRequest(PeersRequest peersRequest) {
                }
                        onActiveClusterManagerFound(discoveryNode, response.getTerm());  
                    if (response.getClusterManagerNode().equals(Optional.of(discoveryNode))) {  
                public void onResponse(DiscoveryNode remoteNode) {  
                        response.getKnownPeers().stream().map(DiscoveryNode::getAddress).forEach(PeerFinder.this::startProbe);  
        );
    }
     * Invoked on receipt of a PeersResponse from a node that believes it's an active leader, which this node should therefore try and join.
        }
    );
 */
    private TimeValue findPeersInterval;
 * license agreements. See the NOTICE file distributed with
/**  
                    }
                public void onFailure(Exception e) {  
    protected final boolean holdsLock() {
                @Override
                @Override
                } else {
                    onFoundPeersUpdated();
            .map(Peer::getDiscoveryNode)
            final List<DiscoveryNode> knownPeers;
                }  
    /**  
 * finds peers
            @Override
            }
                    logger.trace("{} received {}", Peer.this, response);  
                    synchronized (mutex) {  
        onFoundPeersUpdated(); // trigger a check for a quorum already
            final TransportResponseHandler<PeersResponse> peersResponseHandler = new TransportResponseHandler<PeersResponse>() {  
        this.transportAddressConnector = transportAddressConnector;  
            Names.GENERIC,
         *  
            onFoundPeersUpdated();  
            return new PeersResponse(leader, knownPeers, currentTerm);
            transportService.getLocalNode()  
                        peersByAddress.remove(transportAddress, Peer.this);  
    /**  
        "discovery.find_peers_interval",
                peersRequest.getKnownPeers().stream().map(DiscoveryNode::getAddress).forEach(this::startProbe);
         * Attempt to resolve the configured unicast hosts list to a list of transport addresses.
    }  
    }  
                    if (peersRequestInFlight == false) {
            logger.trace("startProbe({}) not probing local node", transportAddress);
