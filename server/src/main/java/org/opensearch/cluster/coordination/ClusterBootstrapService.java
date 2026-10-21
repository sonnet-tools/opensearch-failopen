            || discoveryNode.getAddress().getAddress().equals(requirement);
}
                    logger.info("avoiding best-effort cluster bootstrapping due to discovery of pre-7.0 nodes {}", zen1Nodes);
        Property.NodeScope
        Function.identity(),
            public String toString() {
            INITIAL_CLUSTER_MANAGER_NODES_SETTING,
 *     http://www.apache.org/licenses/LICENSE-2.0
                return;
                if (zen1Nodes.isEmpty()) {
import java.util.function.BooleanSupplier;
import java.util.HashSet;
            }
            final Tuple<Set<DiscoveryNode>, List<String>> requirementMatchingResult;
        if (unconfiguredBootstrapTimeout == null) {
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        "cluster.initial_master_nodes",
                public String toString() {
                    );
 */
    }
                nodesMatchingRequirements,
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_SETTING;
    }
        } else {
import org.opensearch.threadpool.ThreadPool.Names;
                logger.info(
    private final Consumer<VotingConfiguration> votingConfigurationConsumer;
        Function.identity(),
            }
    private final AtomicBoolean bootstrappingPermitted = new AtomicBoolean(true);
        TransportService transportService,
            "no discovery configuration found, will perform best-effort cluster bootstrapping after [{}] "
                return "unconfigured-discovery delayed bootstrap";
            logger.trace(
    }
        TimeValue.timeValueMillis(1),
import java.util.stream.StreamSupport;
                final List<DiscoveryNode> zen1Nodes = discoveredNodes.stream().filter(Coordinator::isZen1Node).collect(Collectors.toList());
 * ownership. Elasticsearch licenses this file to you under
            }
    public static final Setting<List<String>> INITIAL_CLUSTER_MANAGER_NODES_SETTING = Setting.listSetting(
import org.opensearch.common.settings.Settings;
    private final Supplier<Iterable<DiscoveryNode>> discoveredNodesSupplier;
    }
                    "skipping cluster bootstrapping as local node does not match bootstrap requirements: {}",
        transportService.getThreadPool().scheduleUnlessShuttingDown(unconfiguredBootstrapTimeout, Names.GENERIC, new Runnable() {
                    return "retry of failed bootstrapping with " + votingConfiguration;
                        + "] must be cluster-manager-eligible"
                "nodesMatchingRequirements={}, unsatisfiedRequirements={}, bootstrapRequirements={}",
 * KIND, either express or implied.  See the License for the
            );
            ? INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()
        return Tuple.tuple(selectedNodes, unmatchedRequirements);
                if (selectedNodes.add(matchingNode) == false) {
            DISCOVERY_SEED_HOSTS_SETTING,
                            + matchingNode
            bootstrapRequirements = Collections.singleton(Node.NODE_NAME_SETTING.get(settings));
        this.discoveredNodesSupplier = discoveredNodesSupplier;
            doBootstrap(
import org.opensearch.common.Nullable;
            }
                public void run() {
    // The setting below is going to replace the above.
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 */
            logger.warn(new ParameterizedMessage("exception when bootstrapping with {}, rescheduling", votingConfiguration), e);
                        "node ["
import org.opensearch.transport.TransportService;
        String initialClusterManagerSettingName = INITIAL_CLUSTER_MANAGER_NODES_SETTING.exists(settings)
            public void run() {
                bootstrappingPermitted.set(false);
/*
                    Stream.concat(
            if (nodesMatchingRequirements.size() * 2 > bootstrapRequirements.size()) {
import static java.util.Collections.emptyList;
                .collect(Collectors.toSet());
                        + initialClusterManagerSettingName
            final Set<DiscoveryNode> matchingNodes = nodes.stream()
                    logger.debug("performing best-effort cluster bootstrapping with {}", discoveredNodes);
        }
    private Set<DiscoveryNode> getDiscoveredNodes() {
            }
    private void startBootstrap(Set<DiscoveryNode> discoveryNodes, List<String> unsatisfiedRequirements) {
        }
        }
 * You may obtain a copy of the License at
            return;
                    doBootstrap(votingConfiguration);
        Supplier<Iterable<DiscoveryNode>> discoveredNodesSupplier,
            DISCOVERY_SEED_PROVIDERS_SETTING,
import org.opensearch.common.settings.Setting;
    private final BooleanSupplier isBootstrappedSupplier;
    private static boolean matchesRequirement(DiscoveryNode discoveryNode, String requirement) {
                        + DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey()
    public static boolean discoveryIsConfigured(Settings settings) {
            }
                        discoveryNodes.stream().map(DiscoveryNode::getId),
            }
 * under the License.
    private final TimeValue unconfiguredBootstrapTimeout;
    public ClusterBootstrapService(
    private Tuple<Set<DiscoveryNode>, List<String>> checkRequirements(Set<DiscoveryNode> nodes) {
    }
import java.util.function.Function;
    public static boolean isBootstrapPlaceholder(String nodeId) {
                } else {
    ) {
        });
            bootstrapRequirements = unmodifiableSet(new LinkedHashSet<>(initialClusterManagerNodes));
            final List<String> initialClusterManagerNodes = INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(settings);
    );
 * the Apache License, Version 2.0 (the "License"); you may
            LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_SETTING,
            && bootstrapRequirements.isEmpty() == false
            if (bootstrapRequirements.size() != initialClusterManagerNodes.size()) {
        assert transportService.getLocalNode().isClusterManagerNode();
            : INITIAL_MASTER_NODES_SETTING.getKey();
        this.votingConfigurationConsumer = votingConfigurationConsumer;
/*
 * The OpenSearch Contributors require contributions made to
                }
                        + DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey()
                    "setting [" + initialClusterManagerSettingName + "] contains duplicates: " + initialClusterManagerNodes
        final Set<DiscoveryNode> nodes = getDiscoveredNodes();
        ).anyMatch(s -> s.exists(settings));
                    startBootstrap(discoveredNodes, emptyList());
                final Set<DiscoveryNode> discoveredNodes = getDiscoveredNodes();
import java.util.List;
    private void doBootstrap(VotingConfiguration votingConfiguration) {
    );
        }
        Settings settings,
            final List<String> unsatisfiedRequirements = requirementMatchingResult.v2();
import java.util.concurrent.atomic.AtomicBoolean;
    void onFoundPeersUpdated() {
        }
        ).collect(Collectors.toSet());
                unmatchedRequirements.add(bootstrapRequirement);
 * @opensearch.internal
    static final String BOOTSTRAP_PLACEHOLDER_PREFIX = "{bootstrap-placeholder}-";
                }
            LEGACY_DISCOVERY_HOSTS_PROVIDER_SETTING,
import java.util.stream.Stream;
 * Modifications Copyright OpenSearch Contributors. See
                new VotingConfiguration(
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING;
            try {
            transportService.getThreadPool().scheduleUnlessShuttingDown(TimeValue.timeValueSeconds(10), Names.GENERIC, new Runnable() {
 * this work for additional information regarding copyright
                            + "] matches multiple requirements: "
        assert discoveryNodes.stream().allMatch(DiscoveryNode::isClusterManagerNode) : discoveryNodes;
/*
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;
    }
                    "node with ["
    }
import java.util.function.Consumer;
            if (matchingNodes.size() > 1) {
            if (nodesMatchingRequirements.contains(transportService.getLocalNode()) == false) {
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
    }
    public static final Setting<TimeValue> UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING = Setting.timeSetting(
        this.isBootstrappedSupplier = isBootstrappedSupplier;
import org.opensearch.common.collect.Tuple;
            return;
            } catch (IllegalStateException e) {
                }
        final Set<DiscoveryNode> selectedNodes = new HashSet<>();
            );
                    throw new IllegalStateException(
                );
        Property.NodeScope
 * Service for bootstrapping the OpenSearch cluster
import java.util.function.Supplier;
        }
            StreamSupport.stream(discoveredNodesSupplier.get().spliterator(), false)
        }
import java.util.LinkedHashSet;
import static java.util.Collections.unmodifiableSet;
        // TODO: Remove variable 'initialClusterManagerSettingName' after removing MASTER_ROLE.
    public static final Setting<List<String>> INITIAL_MASTER_NODES_SETTING = Setting.listSetting(
 *
    private final TransportService transportService;
        INITIAL_MASTER_NODES_SETTING,
/**
            INITIAL_MASTER_NODES_SETTING
        if (bootstrappingPermitted.compareAndSet(true, false)) {
                            + bootstrapRequirements.stream().filter(r -> matchesRequirement(matchingNode, r)).collect(Collectors.toList())
        Property.NodeScope,
                bootstrappingPermitted.set(false);
        if (bootstrappingPermitted.get()
            unconfiguredBootstrapTimeout = discoveryIsConfigured(settings) ? null : UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING.get(settings);
                        + "] set to ["
import java.util.Set;
                throw new IllegalStateException("requirement [" + bootstrapRequirement + "] matches multiple nodes: " + matchingNodes);
import java.util.Collections;
        if (DiscoveryModule.isSingleNodeDiscovery(settings)) {
        try {
            Stream.of(transportService.getLocalNode()),
                + "unless existing cluster-manager is discovered",
                requirementMatchingResult = checkRequirements(nodes);
import org.opensearch.common.unit.TimeValue;
            && nodes.stream().noneMatch(Coordinator::isZen1Node)) {
 *
    }
        return nodeId.startsWith(BOOTSTRAP_PLACEHOLDER_PREFIX);
            if (INITIAL_CLUSTER_MANAGER_NODES_SETTING.existsOrFallbackExists(settings)) {
        logger.info(
            unconfiguredBootstrapTimeout
 */
                    "setting ["
        Property.Deprecated
        TimeValue.timeValueSeconds(3),
                );
        } catch (Exception e) {
 */
public class ClusterBootstrapService {
 * SPDX-License-Identifier: Apache-2.0
                        unsatisfiedRequirements.stream().map(s -> BOOTSTRAP_PLACEHOLDER_PREFIX + s)
                }
                @Override
    }
                )
            if (DiscoveryNode.isClusterManagerNode(settings) == false) {
            unconfiguredBootstrapTimeout = null;
            final Set<DiscoveryNode> nodesMatchingRequirements = requirementMatchingResult.v1();
            for (final DiscoveryNode matchingNode : matchingNodes) {
                        + "] is set to ["
                );
                return;
    );
            }
 * Licensed to Elasticsearch under one or more contributor
                        + DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE
        "discovery.unconfigured_bootstrap_timeout",
                bootstrapRequirements
                throw new IllegalArgumentException(
        return Stream.concat(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        this.transportService = transportService;
        for (final String bootstrapRequirement : bootstrapRequirements) {
import org.opensearch.node.Node;
        if (transportService.getLocalNode().isClusterManagerNode() == false) {
        return discoveryNode.getName().equals(requirement)
                startBootstrap(nodesMatchingRequirements, unsatisfiedRequirements);
    // To keep backwards compatibility, the old usage is remained, and it's also used as the fallback for the new usage.
                    ).collect(Collectors.toSet())
    private final Set<String> bootstrapRequirements;
import java.util.ArrayList;
    private static final Logger logger = LogManager.getLogger(ClusterBootstrapService.class);
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
                        + "] is not allowed when ["
 * GitHub history for details.
                .filter(n -> matchesRequirement(n, bootstrapRequirement))
            && isBootstrappedSupplier.getAsBoolean() == false
            }
 * this file be licensed under the Apache-2.0 license or a
                logger.warn("bootstrapping cancelled", e);
                );
import org.opensearch.cluster.node.DiscoveryNode;
import org.apache.logging.log4j.message.ParameterizedMessage;
            || discoveryNode.getAddress().toString().equals(requirement)
            && transportService.getLocalNode().isClusterManagerNode()
import static org.opensearch.discovery.DiscoveryModule.LEGACY_DISCOVERY_HOSTS_PROVIDER_SETTING;
                throw new IllegalArgumentException(
                @Override
 * compatible open source license.
        "cluster.initial_cluster_manager_nodes",
            }
import org.opensearch.discovery.DiscoveryModule;
        BooleanSupplier isBootstrappedSupplier,
import java.util.stream.Collectors;
                        + DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE
                    bootstrapRequirements
            votingConfigurationConsumer.accept(votingConfiguration);
            });
                        + "]"
        assert discoveryNodes.stream().noneMatch(Coordinator::isZen1Node) : discoveryNodes;
 * specific language governing permissions and limitations
    void scheduleUnconfiguredBootstrap() {
        return Stream.of(
            if (matchingNodes.size() == 0) {
    @Nullable // null if discoveryIsConfigured()
                throw new IllegalArgumentException(
 *
        final List<String> unmatchedRequirements = new ArrayList<>();
            @Override
        Consumer<VotingConfiguration> votingConfigurationConsumer
        emptyList(),
 *
            @Override
        );
            }
                unsatisfiedRequirements,
import org.opensearch.common.settings.Setting.Property;
package org.opensearch.cluster.coordination;
        assert unsatisfiedRequirements.size() < discoveryNodes.size() : discoveryNodes + " smaller than " + unsatisfiedRequirements;
