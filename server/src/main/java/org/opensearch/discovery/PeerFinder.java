        return currentTerm;
                        requestPeers();
            final DiscoveryNode discoveryNode = getDiscoveryNode();
                @Override
                }
            startProbe(discoveryNodeObjectCursor.getAddress());
                }
                public PeersResponse read(StreamInput in) throws IOException {
    public static final Setting<TimeValue> DISCOVERY_REQUEST_PEERS_TIMEOUT_SETTING = Setting.timeSetting(
    public interface TransportAddressConnector {
            final List<DiscoveryNode> knownPeers;
        }
                    startProbe(peersRequest.getSourceNode().getAddress());
    /**
        if (active == false) {
    /**
        });
 * @opensearch.internal
 *
    public void deactivate(DiscoveryNode leader) {
    public synchronized void onNodeCommissionStatusChange(boolean localNodeCommissioned) {
    private boolean handleWakeUp() {
                    if (handleWakeUp() == false) {
    public long getCurrentTerm() {
                assert false : e;
        TimeValue.timeValueMillis(3000),
            assert assertInactiveWithNoKnownPeers();
                    peersRequestInFlight = false;
        final boolean peersRemoved = peersByAddress.values().removeIf(Peer::handleWakeUp);
public abstract class PeerFinder {
            assert holdsLock() : "PeerFinder mutex not held";
        TimeValue.timeValueSeconds(120L),
                public void onResponse(DiscoveryNode remoteNode) {
    }
                logger.trace("{} not requesting peers from local node", this);
    private final ConfiguredHostsResolver configuredHostsResolver;
import org.opensearch.common.settings.Setting;
            Names.GENERIC,
            return discoveryNode.get();
 */
                return;
            logger.trace("deactivating and setting leader to {}", leader);
        TimeValue.timeValueMillis(1000),
    public static final Setting<TimeValue> DISCOVERY_FIND_PEERS_INTERVAL_SETTING = Setting.timeSetting(
                    synchronized (mutex) {
                }
        private volatile boolean peersRequestInFlight;
        private final TransportAddress transportAddress;
                return true;
 * ownership. Elasticsearch licenses this file to you under
import java.util.List;
        assert active == false;
        synchronized (mutex) {
 * SPDX-License-Identifier: Apache-2.0
            localNodeCommissioned,
    PeersResponse handlePeersRequest(PeersRequest peersRequest) {
import org.opensearch.cluster.node.DiscoveryNode;
/*
        );
        transportService.registerRequestHandler(
                logger.debug("unexpected exception in wakeup", e);
            final List<DiscoveryNode> knownNodes = getFoundPeersUnderLock();
        Setting.Property.NodeScope
 *
    }
                    synchronized (mutex) {
 * KIND, either express or implied.  See the License for the
            logger.trace("{} attempting connection", this);
        return peersRemoved;
    TimeValue getFindPeersInterval() {
            protected void doRun() {
            findPeersInterval,
        "discovery.find_peers_interval_during_decommission",
                peersResponseHandler
        synchronized (mutex) {
                public void onFailure(Exception e) {
            transportService.sendRequest(
                + ", peersRequestInFlight="
            logger.trace("startProbe({}) not running", transportAddress);
                }
        DiscoveryNode getDiscoveryNode() {
            return leader;
        }
            .filter(Objects::nonNull)
     */
        public String toString() {
    /**
         * @param consumer Consumer for the resolved list. May not be called if an error occurs or if another resolution attempt is in
        this.currentTerm = currentTerm;
            }
    }
            return getFoundPeersUnderLock();
                        onActiveClusterManagerFound(discoveryNode, response.getTerm());
        if (active == false) {
    }
 * The OpenSearch Contributors require contributions made to
                public String executor() {
import org.opensearch.common.unit.TimeValue;
 *
            REQUEST_PEERS_ACTION_NAME,
            synchronized (mutex) {
            }
import org.opensearch.transport.TransportResponseHandler;
            assert active;
                    logger.trace("{} received {}", Peer.this, response);
import java.util.function.Consumer;
        TimeValue.timeValueMillis(1),
        }
                        if (active == false) {
                }
         */
 * specific language governing permissions and limitations
    }
                + ", discoveryNode="
/*
            handleWakeUp(); // return value discarded: there are no known peers, so none can be disconnected
            assert peersRequestInFlight == false : "PeersRequest already in flight";
    private boolean assertInactiveWithNoKnownPeers() {
 * compatible open source license.
    }
        @Nullable
        Setting.Property.NodeScope
    public static final String REQUEST_PEERS_ACTION_NAME = "internal:discovery/request_peers";
            return;
                    }
import java.util.stream.Collectors;
        }
            return new PeersResponse(leader, knownPeers, currentTerm);
            }
    public List<TransportAddress> getLastResolvedAddresses() {
            assert discoveryNode != null : "cannot request peers without first connecting";
                @Override
    /**
    public Iterable<DiscoveryNode> getFoundPeers() {
            peersRequestInFlight = true;
                    }
        if (transportAddress.equals(getLocalNode().getAddress())) {
                knownPeers = emptyList();
    private final TransportService transportService;
                } else {
import org.apache.logging.log4j.LogManager;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.TransportService;
                            return;
    protected void startProbe(TransportAddress transportAddress) {
     * @opensearch.internal
            .distinct()
                        peersRequestInFlight = false;
    private final Settings settings;
                knownPeers = getFoundPeersUnderLock();
 * Licensed to Elasticsearch under one or more contributor
    protected final boolean holdsLock() {
    private Peer createConnectingPeer(TransportAddress transportAddress) {
    private Optional<DiscoveryNode> leader = Optional.empty();
                    synchronized (mutex) {
    // package private for tests
    public void activate(final DiscoveryNodes lastAcceptedNodes) {
                public void handleException(TransportException exp) {
            transportService.getLocalNode()
            this.leader = Optional.of(leader);
    );
        void connectToRemoteMasterNode(TransportAddress transportAddress, ActionListener<DiscoveryNode> listener);
 * the Apache License, Version 2.0 (the "License"); you may
        return peer;
    private volatile long currentTerm;
     */
            : DISCOVERY_FIND_PEERS_INTERVAL_DURING_DECOMMISSION_SETTING.get(settings);
                if (transportService.nodeConnected(discoveryNode)) {
    public PeerFinder(
            return "Peer{"
        this.configuredHostsResolver = configuredHostsResolver;
         * Attempt to resolve the configured unicast hosts list to a list of transport addresses.
            // may be null if connection not yet established
            active = true;
        configuredHostsResolver.resolveConfiguredHosts(providedAddresses -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        peersByAddress.remove(transportAddress, Peer.this);
            @Override
                    }
        private SetOnce<DiscoveryNode> discoveryNode = new SetOnce<>();
            }
 * this work for additional information regarding copyright
            @Override
        "discovery.find_peers_interval",
            assert assertInactiveWithNoKnownPeers();
            ? DISCOVERY_FIND_PEERS_INTERVAL_SETTING.get(settings)
        synchronized (mutex) {
        });
    );
                new PeersRequest(getLocalNode(), knownNodes),
                    }
        }
            peersRemoved = handleWakeUp();
     * updated set of peers as an argument to this method, leaving it to the implementation to call getFoundPeers() with appropriate
        this.transportAddressConnector = transportAddressConnector;
        }
                }
    private volatile List<TransportAddress> lastResolvedAddresses = emptyList();
            .stream()
                    return true;
        }
            assert active;
            assert holdsLock() : "PeerFinder mutex not held";
                        if (active == false) {
            final DiscoveryNode discoveryNode = getDiscoveryNode();
                    logger.debug(() -> new ParameterizedMessage("{} connection failed", Peer.this), e);
            @Override
                    return new PeersResponse(in);
import org.opensearch.threadpool.ThreadPool.Names;
     */
                TransportRequestOptions.builder().withTimeout(requestPeersTimeout).build(),
import org.opensearch.common.util.concurrent.AbstractRunnable;
        }
    ) {
                    logger.trace("{} no longer connected", this);
            return false;
     * Transport address connector interface.
            PeersRequest::new,
    // exposed for checking invariant in o.e.c.c.Coordinator (public since this is a different package)
    }
        peer.establishConnection();
        "discovery.request_peers_timeout",
import org.apache.logging.log4j.message.ParameterizedMessage;
        synchronized (mutex) {
     *
            }
     * @return whether any peers were removed due to disconnection
            .map(Peer::getDiscoveryNode)
    public Optional<DiscoveryNode> getLeader() {
    }
        for (final DiscoveryNode discoveryNodeObjectCursor : lastAcceptedNodes.getClusterManagerNodes().values()) {
            false,
 *
 * You may obtain a copy of the License at
        Setting.Property.NodeScope
    }
                @Override
            }
            public boolean isForceExecution() {
        return Thread.holdsLock(mutex);
    );
            public String toString() {
    }
        this.transportService = transportService;
import java.util.LinkedHashMap;
     * @opensearch.internal
    private TimeValue findPeersInterval;
import org.opensearch.common.Nullable;
        return peersByAddress.values()
                    onFoundPeersUpdated();
                    if (response.getClusterManagerNode().equals(Optional.of(discoveryNode))) {
    protected abstract void onFoundPeersUpdated();
            assert getDiscoveryNode() == null : "unexpectedly connected to " + getDiscoveryNode();
        ConfiguredHostsResolver configuredHostsResolver
        assert holdsLock() : "PeerFinder mutex not held";
            } else {
     * synchronisation to avoid lost updates. Also, by the time this method is invoked we may have been deactivated.
                    }
    /**
                @Override
                    }
 * not use this file except in compliance with the License.
            leader = Optional.empty();
        );
        assert peersByAddress.isEmpty() : peersByAddress.keySet();
            (request, channel, task) -> channel.sendResponse(handlePeersRequest(request))
        }
    }
        findPeersInterval = DISCOVERY_FIND_PEERS_INTERVAL_SETTING.get(settings);
                    assert remoteNode.equals(getLocalNode()) == false : remoteNode + " is the local node";
            return;
            }
    }
        }
        @Override
                }
                    return Names.GENERIC;
                + peersRequestInFlight
            return peersRemoved;
import java.util.Optional;
            onFoundPeersUpdated();
    }
 */
        return localNode;
 * Modifications Copyright OpenSearch Contributors. See
            }
                onFoundPeersUpdated();
 *     http://www.apache.org/licenses/LICENSE-2.0
            active = false;
                assert leader.isPresent() == false : leader;
                    assert holdsLock() == false : "PeerFinder mutex is held in error";
        return findPeersInterval;
                + "transportAddress="
     * Resolves the configured unicast host.
    }
            });
            @Override
                }
        this.settings = settings;
    public static final Setting<TimeValue> DISCOVERY_FIND_PEERS_INTERVAL_DURING_DECOMMISSION_SETTING = Setting.timeSetting(
                }
                synchronized (mutex) {
    }
    private final TimeValue requestPeersTimeout;
import org.opensearch.common.settings.Settings;
        return lastResolvedAddresses;
        }
        return true;
            assert holdsLock() : "PeerFinder mutex not held";
        }
/**
    // exposed for checking invariant in o.e.c.c.Coordinator (public since this is a different package)
    protected abstract void onActiveClusterManagerFound(DiscoveryNode clusterManagerNode, long term);
}
            final TransportResponseHandler<PeersResponse> peersResponseHandler = new TransportResponseHandler<PeersResponse>() {
import org.opensearch.core.common.io.stream.StreamInput;
    private DiscoveryNodes lastAcceptedNodes;
            if (active) {
        assert holdsLock() : "PeerFinder mutex not held";
        final boolean peersRemoved;
        synchronized (mutex) {
        }
            };
import java.util.Map;
    // the time between attempts to find all peers
        void establishConnection() {
                + transportAddress
     */
                        }
            );
        final DiscoveryNode localNode = transportService.getLocalNode();
                    assert remoteNode.isClusterManagerNode() : remoteNode + " is not cluster-manager-eligible";
        }
import org.opensearch.cluster.coordination.PeersResponse;
                            return;
import org.opensearch.core.action.ActionListener;
                    logger.debug(new ParameterizedMessage("{} peers request failed", Peer.this), exp);
            .collect(Collectors.toList());
        logger.info(
    private static final Logger logger = LogManager.getLogger(PeerFinder.class);
                + discoveryNode.get()
    }
            assert peersRequest.getSourceNode().equals(getLocalNode()) == false;
        /**
    // the time between attempts to find all peers when node is in decommissioned state, default set to 2 minutes
                return "PeerFinder handling wakeup";
     * Note that invocations of this method are not synchronised. By the time it is called we may have been deactivated.
        findPeersInterval = localNodeCommissioned
            if (active == false) {
 * software distributed under the License is distributed on an
            this.transportAddress = transportAddress;
        logger.trace("activating with {}", lastAcceptedNodes);
                public void handleResponse(PeersResponse response) {
import static java.util.Collections.emptyList;
     * will be multiple concurrent invocations of this method, with no guarantee as to their order. For this reason we do not pass the
            if (discoveryNode != null) {
            logger.trace("startProbe({}) not probing local node", transportAddress);
        TimeValue.timeValueMillis(1),
        Settings settings,
        boolean handleWakeUp() {
     * Invoked when the set of found peers changes. Note that invocations of this method are not fully synchronised, so we only guarantee
                        // Must not hold lock here to avoid deadlock
 * license agreements. See the NOTICE file distributed with
     * Invoked on receipt of a PeersResponse from a node that believes it's an active leader, which this node should therefore try and join.
            false,
    private DiscoveryNode getLocalNode() {
import org.opensearch.cluster.node.DiscoveryNodes;
        }
        /**
        private void requestPeers() {
        TransportService transportService,
        TransportAddressConnector transportAddressConnector,
            logger.trace("{} requesting peers", this);
    public interface ConfiguredHostsResolver {
            if (discoveryNode.equals(getLocalNode())) {
            "setting findPeersInterval to [{}] as node commission status = [{}] for local node [{}]",
                return true;
        onFoundPeersUpdated(); // trigger a check for a quorum already
            public void onFailure(Exception e) {
    private final TransportAddressConnector transportAddressConnector;
                        }
        Peer peer = new Peer(transportAddress);
            }
import org.opensearch.core.common.transport.TransportAddress;
                        requestPeers();
        peersByAddress.computeIfAbsent(transportAddress, this::createConnectingPeer);
    private boolean active;
        assert holdsLock() : "PeerFinder mutex not held";
        logger.trace("probing cluster-manager nodes from cluster state: {}", lastAcceptedNodes);
        TimeValue.timeValueMillis(1000),
        assert localNode != null;
                assert leader.isPresent() || lastAcceptedNodes == null;
    private class Peer {
                        discoveryNode.set(remoteNode);
                logger.trace("probing resolved transport addresses {}", providedAddresses);
    }
         *                 progress.
import org.opensearch.transport.TransportRequestOptions;
 * Unless required by applicable law or agreed to in writing,
                        response.getKnownPeers().stream().map(DiscoveryNode::getAddress).forEach(PeerFinder.this::startProbe);
                @Override
        if (peersRemoved) {
                REQUEST_PEERS_ACTION_NAME,
    }
            this.lastAcceptedNodes = lastAcceptedNodes;
import org.opensearch.transport.TransportException;
                        assert discoveryNode.get() == null : "discoveryNode unexpectedly already set to " + discoveryNode.get();
            logger.trace("not active");
                        return;
    // exposed to subclasses for testing
        void resolveConfiguredHosts(Consumer<List<TransportAddress>> consumer);
    }
                        assert holdsLock() == false : "PeerFinder mutex is held in error";
     * that the change to the set of found peers happens before this method is invoked. If there are multiple concurrent changes then there
/*
        }
import java.util.Objects;
import org.opensearch.common.SetOnce;
                if (peersRequest.getSourceNode().isClusterManagerNode()) {
        Peer(TransportAddress transportAddress) {
        assert holdsLock() : "PeerFinder mutex not held";
         *
 */
                peersRequest.getKnownPeers().stream().map(DiscoveryNode::getAddress).forEach(this::startProbe);
                        response.getClusterManagerNode().map(DiscoveryNode::getAddress).ifPresent(PeerFinder.this::startProbe);
            transportAddressConnector.connectToRemoteMasterNode(transportAddress, new ActionListener<DiscoveryNode>() {
                discoveryNode,
    private final Object mutex = new Object();
    private List<DiscoveryNode> getFoundPeersUnderLock() {
         */
         * Identify the node at the given address and, if it is a cluster-manager node and not the local node then establish a full connection to it.
                    if (peersRequestInFlight == false) {
    }
                @Override
                lastResolvedAddresses = providedAddresses;
                + '}';
 * finds peers
    private final Map<TransportAddress, Peer> peersByAddress = new LinkedHashMap<>();
     *
package org.opensearch.discovery;
    public void setCurrentTerm(long currentTerm) {
    }
        transportService.getThreadPool().scheduleUnlessShuttingDown(findPeersInterval, Names.GENERIC, new AbstractRunnable() {
import org.apache.logging.log4j.Logger;
     */
                providedAddresses.forEach(this::startProbe);
import java.io.IOException;
 * GitHub history for details.
        requestPeersTimeout = DISCOVERY_REQUEST_PEERS_TIMEOUT_SETTING.get(settings);
 * under the License.
 */
