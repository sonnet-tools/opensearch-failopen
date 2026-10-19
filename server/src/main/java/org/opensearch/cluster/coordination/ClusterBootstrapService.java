        final Set<DiscoveryNode> selectedNodes = new HashSet<>();  
    private static final Logger logger = LogManager.getLogger(ClusterBootstrapService.class);
        Function.identity(),  
        logger.info(  
 * The OpenSearch Contributors require contributions made to  
    void scheduleUnconfiguredBootstrap() {  
                return "unconfigured-discovery delayed bootstrap";  
            unconfiguredBootstrapTimeout = discoveryIsConfigured(settings) ? null : UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING.get(settings);
                throw new IllegalArgumentException(
import java.util.function.Consumer;  
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_SETTING;  
        this.transportService = transportService;
            if (nodesMatchingRequirements.size() * 2 > bootstrapRequirements.size()) {  
            if (DiscoveryNode.isClusterManagerNode(settings) == false) {
import java.util.LinkedHashSet;
import org.opensearch.transport.TransportService;
    private void doBootstrap(VotingConfiguration votingConfiguration) {
    private final AtomicBoolean bootstrappingPermitted = new AtomicBoolean(true);  
            if (matchingNodes.size() > 1) {
                throw new IllegalStateException("requirement [" + bootstrapRequirement + "] matches multiple nodes: " + matchingNodes);  
import org.opensearch.cluster.node.DiscoveryNode;
                unsatisfiedRequirements,
            final Set<DiscoveryNode> matchingNodes = nodes.stream()  
 * compatible open source license.
        }  
            }  
            }  
                    ).collect(Collectors.toSet())
package org.opensearch.cluster.coordination;
            }
                    "node with ["  
import static org.opensearch.discovery.DiscoveryModule.LEGACY_DISCOVERY_HOSTS_PROVIDER_SETTING;
                        + DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE  
                }  
        assert discoveryNodes.stream().noneMatch(Coordinator::isZen1Node) : discoveryNodes;
    private static boolean matchesRequirement(DiscoveryNode discoveryNode, String requirement) {
        return discoveryNode.getName().equals(requirement)  
 */  
                logger.warn("bootstrapping cancelled", e);
                new VotingConfiguration(  
                }
        } catch (Exception e) {
            LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_SETTING,
/*
            try {
        this.isBootstrappedSupplier = isBootstrappedSupplier;
import java.util.Set;  
                    doBootstrap(votingConfiguration);  
    );
            } catch (IllegalStateException e) {  
                if (zen1Nodes.isEmpty()) {
            final Tuple<Set<DiscoveryNode>, List<String>> requirementMatchingResult;  
                    bootstrapRequirements  
                }
import org.opensearch.node.Node;  
 * You may obtain a copy of the License at  
        "cluster.initial_cluster_manager_nodes",
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING;
                    startBootstrap(discoveredNodes, emptyList());
                "nodesMatchingRequirements={}, unsatisfiedRequirements={}, bootstrapRequirements={}",  
        Settings settings,  
        final Set<DiscoveryNode> nodes = getDiscoveredNodes();
 *
                );
            public String toString() {
            }  
            }
 * this work for additional information regarding copyright
        if (transportService.getLocalNode().isClusterManagerNode() == false) {
    private final TimeValue unconfiguredBootstrapTimeout;
        assert transportService.getLocalNode().isClusterManagerNode();  
                .filter(n -> matchesRequirement(n, bootstrapRequirement))
 * not use this file except in compliance with the License.
        for (final String bootstrapRequirement : bootstrapRequirements) {
                startBootstrap(nodesMatchingRequirements, unsatisfiedRequirements);
        // TODO: Remove variable 'initialClusterManagerSettingName' after removing MASTER_ROLE.  
import java.util.function.Function;
            "no discovery configuration found, will perform best-effort cluster bootstrapping after [{}] "
 * SPDX-License-Identifier: Apache-2.0
            );  
 * license agreements. See the NOTICE file distributed with
import java.util.Collections;
    }
        String initialClusterManagerSettingName = INITIAL_CLUSTER_MANAGER_NODES_SETTING.exists(settings)
                        + "] is set to ["
        Property.NodeScope,
            if (matchingNodes.size() == 0) {
        "cluster.initial_master_nodes",
        Property.Deprecated
    public static final Setting<List<String>> INITIAL_CLUSTER_MANAGER_NODES_SETTING = Setting.listSetting(  
            public void run() {
                unmatchedRequirements.add(bootstrapRequirement);
    );  
                        + "] must be cluster-manager-eligible"
            final List<String> unsatisfiedRequirements = requirementMatchingResult.v2();
                public void run() {
import java.util.function.BooleanSupplier;
    static final String BOOTSTRAP_PLACEHOLDER_PREFIX = "{bootstrap-placeholder}-";
/*  
    }  
                    "skipping cluster bootstrapping as local node does not match bootstrap requirements: {}",
            }
        ).collect(Collectors.toSet());  
        assert discoveryNodes.stream().allMatch(DiscoveryNode::isClusterManagerNode) : discoveryNodes;
        Property.NodeScope
            && isBootstrappedSupplier.getAsBoolean() == false  
 * GitHub history for details.
                        + "] is not allowed when ["  
                }
            doBootstrap(
                        + "] set to ["
import java.util.stream.Collectors;  
        );
                        + DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey()
    public static boolean discoveryIsConfigured(Settings settings) {
 */  
                    return "retry of failed bootstrapping with " + votingConfiguration;
/**
            StreamSupport.stream(discoveredNodesSupplier.get().spliterator(), false)
        }
                    "setting ["
                        + "]"
            && nodes.stream().noneMatch(Coordinator::isZen1Node)) {
    // The setting below is going to replace the above.
    private void startBootstrap(Set<DiscoveryNode> discoveryNodes, List<String> unsatisfiedRequirements) {  
        INITIAL_MASTER_NODES_SETTING,
            return;
        this.votingConfigurationConsumer = votingConfigurationConsumer;
        if (DiscoveryModule.isSingleNodeDiscovery(settings)) {
            INITIAL_MASTER_NODES_SETTING  
import java.util.ArrayList;
                throw new IllegalArgumentException(
                logger.info(
            logger.warn(new ParameterizedMessage("exception when bootstrapping with {}, rescheduling", votingConfiguration), e);
                        unsatisfiedRequirements.stream().map(s -> BOOTSTRAP_PLACEHOLDER_PREFIX + s)  
                bootstrappingPermitted.set(false);
                final List<DiscoveryNode> zen1Nodes = discoveredNodes.stream().filter(Coordinator::isZen1Node).collect(Collectors.toList());
    private final Supplier<Iterable<DiscoveryNode>> discoveredNodesSupplier;  
    @Nullable // null if discoveryIsConfigured()  
        ).anyMatch(s -> s.exists(settings));
    }
                nodesMatchingRequirements,
                requirementMatchingResult = checkRequirements(nodes);
        return Stream.concat(  
 *     http://www.apache.org/licenses/LICENSE-2.0
import static java.util.Collections.emptyList;
                    logger.debug("performing best-effort cluster bootstrapping with {}", discoveredNodes);  
        BooleanSupplier isBootstrappedSupplier,  
            DISCOVERY_SEED_HOSTS_SETTING,  
            : INITIAL_MASTER_NODES_SETTING.getKey();  
    ) {
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.settings.Setting.Property;
 * @opensearch.internal
                    );
        Property.NodeScope
                final Set<DiscoveryNode> discoveredNodes = getDiscoveredNodes();  
    public static boolean isBootstrapPlaceholder(String nodeId) {
                bootstrappingPermitted.set(false);
    void onFoundPeersUpdated() {
            }  
import org.apache.logging.log4j.message.ParameterizedMessage;
        final List<String> unmatchedRequirements = new ArrayList<>();
            && bootstrapRequirements.isEmpty() == false
            logger.trace(
        Consumer<VotingConfiguration> votingConfigurationConsumer
            DISCOVERY_SEED_PROVIDERS_SETTING,
            unconfiguredBootstrapTimeout = null;
                    logger.info("avoiding best-effort cluster bootstrapping due to discovery of pre-7.0 nodes {}", zen1Nodes);  
    }  
        });
import org.opensearch.common.settings.Setting;
        if (unconfiguredBootstrapTimeout == null) {
                    throw new IllegalStateException(
import org.opensearch.threadpool.ThreadPool.Names;
    private final Set<String> bootstrapRequirements;
    public static final Setting<TimeValue> UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING = Setting.timeSetting(
        this.discoveredNodesSupplier = discoveredNodesSupplier;  
        }
 *  
                            + matchingNode
    private final TransportService transportService;
            Stream.of(transportService.getLocalNode()),
                return;  
 * Licensed to Elasticsearch under one or more contributor  
            }
import org.opensearch.common.settings.Settings;  
import java.util.HashSet;  
                );
import org.opensearch.common.Nullable;
            for (final DiscoveryNode matchingNode : matchingNodes) {  
        try {
            @Override
        if (bootstrappingPermitted.get()  
            votingConfigurationConsumer.accept(votingConfiguration);  
 * software distributed under the License is distributed on an
            || discoveryNode.getAddress().getAddress().equals(requirement);
                } else {
        assert unsatisfiedRequirements.size() < discoveryNodes.size() : discoveryNodes + " smaller than " + unsatisfiedRequirements;  
            }
                        + DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey()
            transportService.getThreadPool().scheduleUnlessShuttingDown(TimeValue.timeValueSeconds(10), Names.GENERIC, new Runnable() {  
import java.util.stream.StreamSupport;
                    "setting [" + initialClusterManagerSettingName + "] contains duplicates: " + initialClusterManagerNodes
    private Tuple<Set<DiscoveryNode>, List<String>> checkRequirements(Set<DiscoveryNode> nodes) {
 * KIND, either express or implied.  See the License for the
        }  
        TransportService transportService,
    }  
            });
 * Modifications Copyright OpenSearch Contributors. See  
    // To keep backwards compatibility, the old usage is remained, and it's also used as the fallback for the new usage.
 * under the License.  
import org.opensearch.common.collect.Tuple;  
    }
                + "unless existing cluster-manager is discovered",
        Function.identity(),  
        return Stream.of(  
            || discoveryNode.getAddress().toString().equals(requirement)
                        + initialClusterManagerSettingName
        if (bootstrappingPermitted.compareAndSet(true, false)) {
    }
            ? INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()
import org.opensearch.common.unit.TimeValue;
import java.util.function.Supplier;
            final List<String> initialClusterManagerNodes = INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(settings);
    }  
                throw new IllegalArgumentException(  
                .collect(Collectors.toSet());
                return;  
                )
        return nodeId.startsWith(BOOTSTRAP_PLACEHOLDER_PREFIX);
            LEGACY_DISCOVERY_HOSTS_PROVIDER_SETTING,
public class ClusterBootstrapService {
        transportService.getThreadPool().scheduleUnlessShuttingDown(unconfiguredBootstrapTimeout, Names.GENERIC, new Runnable() {  
}
import org.opensearch.discovery.DiscoveryModule;
        TimeValue.timeValueSeconds(3),  
            return;  
                        discoveryNodes.stream().map(DiscoveryNode::getId),
                bootstrapRequirements  
 *
        }
 *
            if (nodesMatchingRequirements.contains(transportService.getLocalNode()) == false) {  
                );  
        }
 * the Apache License, Version 2.0 (the "License"); you may
            );
import static java.util.Collections.unmodifiableSet;
            @Override
import org.apache.logging.log4j.LogManager;  
                @Override
            if (bootstrapRequirements.size() != initialClusterManagerNodes.size()) {  
 * this file be licensed under the Apache-2.0 license or a
                            + bootstrapRequirements.stream().filter(r -> matchesRequirement(matchingNode, r)).collect(Collectors.toList())  
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;  
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;  
import java.util.stream.Stream;
            && transportService.getLocalNode().isClusterManagerNode()
            bootstrapRequirements = unmodifiableSet(new LinkedHashSet<>(initialClusterManagerNodes));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                );
        return Tuple.tuple(selectedNodes, unmatchedRequirements);  
        } else {  
        emptyList(),
            INITIAL_CLUSTER_MANAGER_NODES_SETTING,
                @Override  
            unconfiguredBootstrapTimeout  
    public static final Setting<List<String>> INITIAL_MASTER_NODES_SETTING = Setting.listSetting(  
            }
            if (INITIAL_CLUSTER_MANAGER_NODES_SETTING.existsOrFallbackExists(settings)) {
    );  
    private final Consumer<VotingConfiguration> votingConfigurationConsumer;
 */
        "discovery.unconfigured_bootstrap_timeout",
        Supplier<Iterable<DiscoveryNode>> discoveredNodesSupplier,
    }  
    private Set<DiscoveryNode> getDiscoveredNodes() {
            }
import java.util.List;
                public String toString() {
    }
 */
                if (selectedNodes.add(matchingNode) == false) {
                        + DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE  
                            + "] matches multiple requirements: "
                        "node ["  
import org.apache.logging.log4j.Logger;
            final Set<DiscoveryNode> nodesMatchingRequirements = requirementMatchingResult.v1();  
    public ClusterBootstrapService(
                    Stream.concat(
            bootstrapRequirements = Collections.singleton(Node.NODE_NAME_SETTING.get(settings));
/*
        TimeValue.timeValueMillis(1),
    private final BooleanSupplier isBootstrappedSupplier;
import java.util.concurrent.atomic.AtomicBoolean;
 * Service for bootstrapping the OpenSearch cluster  
 * specific language governing permissions and limitations
        }  
