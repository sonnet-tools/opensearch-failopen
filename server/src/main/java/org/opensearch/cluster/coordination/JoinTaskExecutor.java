                    minClusterNodeVersion = Version.min(minClusterNodeVersion, node.getVersion());
                existingRepositoriesMetadata
                node.toString(),
     */
                )
 * software distributed under the License is distributed on an
     * version mode
        if (existingRemoteStoreNodeAttribute.equalsForRepositories(joiningRemoteStoreNodeAttribute, reposToValidate) == false) {
            repositoriesMetadata.repositories().forEach(r -> repositories.putIfAbsent(r.name(), r));
            .filter(DiscoveryNode::isRemoteStatePublicationEnabled)
            return reason;
            }
            return results.build(
        } else if (currentNodes.getClusterManagerNode() == null && joiningNodes.stream().anyMatch(Task::isBecomeClusterManagerTask)) {
        if (remoteDN.isPresent()) {
        }
import org.opensearch.cluster.metadata.RepositoriesMetadata;
                        repositoriesMetadata.repositories().forEach(r -> repositories.putIfAbsent(r.name(), r));
import org.opensearch.cluster.metadata.IndexMetadata;
        // we ensure that all indices in the cluster we join are compatible with us no matter if they are
                        currentNodes.getMaxNodeVersion()
                            + "] is trying to join a remote store cluster with incompatible node attributes in "
        }
            throw new IllegalStateException(
    public ClusterTasksResult<Task> execute(ClusterState currentState, List<Task> joiningNodes) throws Exception {
        return new Task(null, Task.FINISH_ELECTION_TASK_REASON);
                Set<CoordinationMetadata.VotingConfigExclusion> currentVotingConfigExclusions = currentState.getVotingConfigExclusions();
                    throw new IllegalStateException(reason);
     * The method ensures homogeneity -
                    )
            ensureNodesCompatibility(node, state.getNodes(), state.metadata());
            repositoriesMetadata.repositories().forEach(r -> repositories.putIfAbsent(r.name(), r));
import java.util.Arrays;
            final Version minNodeVersion = currentNodes.getMinNodeVersion();
 * Main executor for Nodes joining the OpenSearch cluster
import org.apache.logging.log4j.Logger;
     */
        assert existingNodes.isEmpty() == false;
            );
import org.apache.logging.log4j.LogManager;
        if (STRICT.equals(remoteStoreCompatibilityMode)) {
import org.opensearch.cluster.decommission.NodeDecommissionedException;
import java.util.Collections;
    }
                        "remote migration : a node [%s] of higher version [%s] is not allowed to join a cluster with maximum version [%s]",
import org.opensearch.cluster.block.ClusterBlocks;
        RemoteStoreNodeAttribute existingRemoteStoreNodeAttribute = new RemoteStoreNodeAttribute(existingNode);
            }
     **/
                } catch (IllegalArgumentException | IllegalStateException | NodeDecommissionedException e) {
                "processing node joins, but we are not the cluster-manager. current cluster-manager: {}",
                                updateMetadataWithRepositoriesMetadata(currentState.metadata(), repositoriesMetadata),
    public static void ensureIndexCompatibility(final Version nodeVersion, Metadata metadata) {
                    // we have added the same check in handleJoinRequest method and adding it here as this method
                }
        boolean isClusterRemoteStoreEnabled = existingNodes.stream().anyMatch(DiscoveryNode::isRemoteStoreNode);
                if (nodeWithSameAddress != null && nodeWithSameAddress.equals(joiningNode) == false) {
    public JoinTaskExecutor(
                        + idxMetadata.getCreationVersion()
        public Task(DiscoveryNode node, String reason) {
                    + "] is not supported. "
    public static void ensureNodesCompatibility(final DiscoveryNode joiningNode, DiscoveryNodes currentNodes, Metadata metadata) {
                newState.metadata(
            assert joiningNodes.stream().anyMatch(Task::isFinishElectionTask) : "becoming a cluster-manager but election is not finished "
                                )
                    results.failure(joinTask, e);
                ensureRemoteStoreNodesCompatibility(joiningNode, existingNode, reposToSkip);
                final DiscoveryNode joiningNode = joinTask.node();
        } else {
                        updateMetadataWithRepositoriesMetadata(currentState.metadata(), repositoriesMetadata),
     * cluster is the one which has only homogeneous remote store backed nodes with same node attributes
        }
        // processing any joins
        if (joiningNodeVersion.compareMajor(minClusterNodeVersion) < 0) {
import org.opensearch.cluster.metadata.Metadata;
            ensureIndexCompatibility(node.getVersion(), state.getMetadata());
                if (nodeWithSameId != null && nodeWithSameId.equals(joiningNode) == false) {
        }
                    + joiningNode
 * GitHub history for details.
     */
        if (remotePublicationDN.isPresent()) {
        }
        ensureRemoteRepositoryCompatibility(joiningNode, currentNodes, metadata);
            );
                        joiningNode.getVersion(),
/*
                        "a remote store node ["
                        joiningNode,
            return currentMetadata;
                                        minClusterNodeVersion
import java.util.LinkedHashMap;
     * ensures that the joining node has a version that's compatible with a given version range and ensures that the
    private Metadata updateMetadataWithRepositoriesMetadata(Metadata currentMetadata, RepositoriesMetadata repositoriesMetadata) {
        this.allocationService = allocationService;
                        ensureMajorVersionBarrier(node.getVersion(), minClusterNodeVersion);
     *
                        .build();
                            + "comparison with existing node ["
                    + maxClusterNodeVersion
            return metadata;
                    newState.nodes(nodesBuilder)
                        Locale.ROOT,
        }
                            dropViewMetadata(
                    throw new IllegalStateException(
/*
            );
     * @see Version#minimumIndexCompatibilityVersion()
    public static Collection<BiConsumer<DiscoveryNode, ClusterState>> addBuiltInJoinValidators(
                logger.debug("received a join request for an existing node [{}]", node);
            } else {
        return Metadata.builder(metadata).removeCustom(ViewMetadata.TYPE).build();
            }
        Optional<DiscoveryNode> remotePublicationDN = currentNodes.getNodes()
    public static void ensureNodeCommissioned(DiscoveryNode node, Metadata metadata) {
                Set<CoordinationMetadata.VotingConfigExclusion> newVotingConfigExclusions = currentVotingConfigExclusions.stream()
import org.opensearch.cluster.metadata.ViewMetadata;
    }
        // find a remote node which has routing table configured
        List<DiscoveryNode> existingNodes = new ArrayList<>(currentNodes.getNodes().values());
                                minClusterNodeVersion
            );
                        if (CoordinationMetadata.VotingConfigExclusion.MISSING_VALUE_MARKER.equals(e.getNodeId())
            .stream()
        Collection<BiConsumer<DiscoveryNode, ClusterState>> onJoinValidators
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(newState.nodes());
            .values()
import java.util.Collection;
                );
                remotePublicationDN.get(),
 * ownership. Elasticsearch licenses this file to you under
                                .build()
    }
                    continue;
        // or removed by us above
                }
        } catch (Exception e) {
            ensureRemoteClusterStateNodesCompatibility(joiningNode, currentNodes);
        this.rerouteService = rerouteService;
            .nodes(nodesBuilder)
        }
            .findFirst();
            .findFirst();
                        + " minimum compatible index version is: "
        if (nodesChanged) {
     * to ensure that if the cluster-manager/master is already fully operating under the new major version, it doesn't go back to mixed
public class JoinTaskExecutor implements ClusterStateTaskExecutor<JoinTaskExecutor.Task> {
        }
                    })
        List<String> reposToSkip
        ClusterState tmpState = ClusterState.builder(currentState)
        final ClusterTasksResult.Builder<Task> results = ClusterTasksResult.builder();
import org.opensearch.persistent.PersistentTasksCustomMetadata;
 *
            DiscoveryNode existingNode = remoteRoutingTableNode.orElseGet(() -> existingNodes.get(0));
                            node,
    }
                            )
        Version maxClusterNodeVersion = newState.nodes().getMaxNodeVersion();
        List<DiscoveryNode> existingNodes = new ArrayList<>(currentNodes.getNodes().values());
        }
                metadata.decommissionAttributeMetadata().decommissionAttribute().toString(),
            );
    @Override
        Version minClusterNodeVersion = newState.nodes().getMinNodeVersion();
        RepositoriesMetadata repositoriesMetadata = new RepositoriesMetadata(new ArrayList<>(repositories.values()));
        tmpState = PersistentTasksCustomMetadata.disassociateDeadNodes(tmpState);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            existingRepositoriesMetadata.repositories().forEach(r -> repositories.putIfAbsent(r.name(), r));
                        )
    }
     * <p>
import java.util.stream.Collectors;
        } else {
            nodesChanged = true;
    private final RemoteStoreNodeService remoteStoreNodeService;
                            + existingNode
                        .clearVotingConfigExclusions();
import org.opensearch.cluster.routing.allocation.AllocationService;
        return new Task(null, Task.BECOME_CLUSTER_MANAGER_TASK_REASON);
            newState = becomeClusterManagerAndTrimConflictingNodes(currentState, joiningNodes);
    }
        private final DiscoveryNode node;
                    .removeGlobalBlock(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID)
        // An optimization can be done as this will get invoked
        List<String> reposToSkip = new ArrayList<>(1);
 */
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;
    }
                        nodeWithSameAddress,
import java.util.List;
            } else {
            )
import org.opensearch.common.Priority;
                    // would guarantee that a decommissioned node would never be able to join the cluster and ensures correctness
    }
            // use these joins to try and become the cluster-manager.
                        joiniedNodeNameIds.put(node.getName(), node.getId());
                metadata.decommissionAttributeMetadata().status().status()
    /**
        try {
                RemoteStoreNodeAttribute joiningRemoteStoreNodeAttribute = new RemoteStoreNodeAttribute(joiningNode);
                    newVotingConfigExclusions.forEach(coordMetadataBuilder::addVotingConfigExclusion);
 * the Apache License, Version 2.0 (the "License"); you may
    ) {
            );
        } else {
            throw new IllegalStateException(
            .filter(DiscoveryNode::isRemoteSegmentStoreNode)
            return results.successes(joiningNodes).build(currentState);
        }
            return node;
                    );
            return reason.equals(FINISH_ELECTION_TASK_REASON);
        // If none of the existing nodes have routing table repo, then we skip this repo check if present in joining node.
                    + "comparison with existing node ["
            .findFirst();
                                    )
    private static void ensureRemoteClusterStateNodesCompatibility(DiscoveryNode joiningNode, DiscoveryNodes currentNodes) {
            } else if (currentNodes.nodeExistsWithSameRoles(node)) {
/*
                        minClusterNodeVersion
        // closed or not we can't read mappings of these indices so we need to reject the join...
 *
 * KIND, either express or implied.  See the License for the
                    + "All nodes in the cluster are of a higher major ["
    }
}
import org.opensearch.Version;
            }
                    logger.debug(
                    + "], which is incompatible."
     * it may be used in combination with {@link JoinTaskExecutor#newBecomeClusterManagerTask()}
            String joiningNodeRepoName = getRoutingTableRepoName(joiningNode.getAttributes());
        }
        }
import static org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode.MIXED;
    /**
import java.util.Locale;
     * state. Once every node is on 3.10.0 or later nothing can read or write it, so it is dropped here.
            .blocks(
        }
                + joiningNodes;
    @Override
            }
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(currentNodes);
            }
                        + idxMetadata.getIndex()
        }
    }
                    if ((remoteDN.isEmpty() && node.isRemoteSegmentStoreNode())
        }
     */
        boolean nodesChanged = false;
                    CoordinationMetadata.Builder coordMetadataBuilder = CoordinationMetadata.builder(currentState.coordinationMetadata())
                        + " the node version is: "
            return results.build(
                }
                    return results.build(
import java.util.ArrayList;
                        );
                            + joiningNode
                getClusterStateRepoName(remotePublicationNode.get().getAttributes()),
        if (joiningNodeVersion.isCompatible(maxClusterNodeVersion) == false) {
                "node version ["
                        )
                ActionListener.wrap(r -> logger.trace("post-join reroute completed"), e -> logger.debug("post-join reroute failed", e))
                    "index "
                    dropViewMetadata(
import org.opensearch.cluster.NotClusterManagerException;
                    ensureNodesCompatibility(node, currentNodes, currentState.metadata(), minClusterNodeVersion, maxClusterNodeVersion);
     * joining node has required attributes to join a remotestore cluster.
                    + "] is trying to join a remote store cluster with incompatible node attributes in "
                    + joiningNodeVersion
                    );
                            + "]"
            throw new NodeDecommissionedException(
 */
        Optional<DiscoveryNode> remotePublicationNode = existingNodes.stream()
        final Collection<BiConsumer<DiscoveryNode, ClusterState>> validators = new ArrayList<>();
                        } else {
                reposToSkip.add(joiningNodeRepoName);
            if (idxMetadata.getCreationVersion().before(supportedIndexVersion)) {
        JoinTaskExecutor.logger = logger;
            throw e;
     * remote store attributes.
            .filter(node -> node.isRemoteStoreNode() && RemoteStoreNodeAttribute.getRoutingTableRepoName(node.getAttributes()) != null)
        final boolean enforceMajorVersion = currentState.getBlocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK) == false;
                if (newVotingConfigExclusions.equals(currentVotingConfigExclusions) == false) {
            return Metadata.builder(currentMetadata).putCustom(RepositoriesMetadata.TYPE, repositoriesMetadata.get()).build();
                    );
                    nodesChanged = true;
    ) {
                    .collect(Collectors.toSet());
                        logger.info("Updating system repository now for remote store");
     *
        // for every set of node join task which we can optimize to not compute if cluster state already has
        assert currentState.nodes().getClusterManagerNodeId() == null : currentState;
                    }
        nodesBuilder.clusterManagerNodeId(currentState.nodes().getLocalNodeId());
                    logger.debug("removing existing node [{}], which conflicts with incoming join from [{}]", nodeWithSameId, joiningNode);
                    String reason = String.format(
                    // we do this validation quite late to prevent race conditions between nodes joining and importing dangling indices
import java.util.HashMap;
     * Validates no remote store attributes are present in joining node as existing nodes in the cluster doesn't have
    /**
    }
    @SuppressWarnings("removal")
                            existingRepositoriesMetadata
                    );
                        + " version not supported: "
            if (joiningNodeRepoName != null) {
 *
 * SPDX-License-Identifier: Apache-2.0
            }
        } else {
        });
        }
 * You may obtain a copy of the License at
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
                }
        if (joiningNodes.size() == 1 && joiningNodes.get(0).isFinishElectionTask()) {
                    + joiningNodeVersion
        DiscoveryNodes currentNodes,
 * Licensed to Elasticsearch under one or more contributor
            if (joiniedNodeNameIds.isEmpty() == false) {
            return node != null ? node + " " + reason : reason;
            .filter(DiscoveryNode::isRemoteStatePublicationEnabled)
                throw new IllegalStateException(
     * 1. The joining node has to be a remote store backed if it's joining a remote store backed cluster. Validates
            newState = ClusterState.builder(currentState);
    }
    /**
import org.opensearch.cluster.node.DiscoveryNodes;
    /**
                    + "]"
    public static void ensureNodesCompatibility(
                            newState.nodes(nodesBuilder)
        if (remoteRoutingTableNode.isEmpty()) {
            this.node = node;
                if (joiningNode.isRemoteStoreNode()) {
        private static final String FINISH_ELECTION_TASK_REASON = "_FINISH_ELECTION_";
    private static Logger logger = LogManager.getLogger(JoinTaskExecutor.class);
        assert nodesBuilder.isLocalNodeElectedClusterManager();
        public boolean isBecomeClusterManagerTask() {
            );
        }
                    + joiningNodeVersion
        for (final Task joinTask : joiningNodes) {
 */
                        || (remotePublicationDN.isEmpty() && node.isRemoteStatePublicationEnabled())) {
 *
                "node [{}] has decommissioned attribute [{}] with current status of decommissioning [{}]",
            if (MIXED.equals(remoteStoreCompatibilityMode)) {
                    + existingNode
        } else {
        }
                        joiningNode
                    + "]."
            );
                        + idxMetadata.getIndex()
            results.success(joinTask);
        public boolean isFinishElectionTask() {
    }
            RepositoriesMetadata repositoriesMetadata = remoteStoreNodeService.updateRepositoriesMetadata(
                }
    /**
                                        updateMetadataWithRepositoriesMetadata(newMetadata, repositoriesMetadata),
import java.util.function.BiConsumer;
import java.util.Set;
        return false;
                        }
            logger.trace(
 * this work for additional information regarding copyright
import org.opensearch.common.settings.Settings;
        validators.add((node, state) -> {
     *       needs to be modified.
                    .blocks(currentState.blocks())
                currentNodes.getClusterManagerNode()
            if (idxMetadata.getCreationVersion().after(nodeVersion)) {
            );
                }
     * @opensearch.internal
        // we only enforce major version transitions on a fully formed clusters
                        "a non remote store node [" + joiningNode + "] is trying to join a remote store cluster"
    private static void ensureRemoteStoreNodesCompatibility(DiscoveryNode joiningNode, DiscoveryNodes currentNodes, Metadata metadata) {
        Map<String, RepositoryMetadata> repositories = new LinkedHashMap<>();
            }
        }
                        + " version not supported: "
     * Ensures that all indices are compatible with the given node version. This will ensure that all indices in the given metadata
        RerouteService rerouteService,
            // for the joining node to finalize its join and set us as a cluster-manager
 * this file be licensed under the Apache-2.0 license or a
        Optional<DiscoveryNode> remoteDN = currentNodes.getNodes()
        // now trim any left over dead nodes - either left there when the previous cluster-manager stepped down
            ensureRepositoryCompatibility(joiningNode, remotePublicationNode.get(), repos);
                allocationService.adaptAutoExpandReplicas(
        assert minClusterNodeVersion.onOrBefore(maxClusterNodeVersion) : minClusterNodeVersion + " > " + maxClusterNodeVersion;
        return ClusterState.builder(allocationService.disassociateDeadNodes(tmpState, false, "removed dead nodes on election"));
                            return new CoordinationMetadata.VotingConfigExclusion(joiniedNodeNameIds.get(e.getNodeName()), e.getNodeName());
                                .metadata(
                    Optional<DiscoveryNode> remoteDN = remoteRoutingTableNode.isPresent()
                    // we have to reject nodes that don't support all indices we have in this cluster
    public static Task newBecomeClusterManagerTask() {
     */
            final DiscoveryNode node = joinTask.node();
        if (joiningNodeVersion.isCompatible(minClusterNodeVersion) == false) {
        if (remotePublicationNode.isPresent() && joiningNode.isRemoteStatePublicationEnabled()) {
import org.opensearch.cluster.ClusterStateTaskExecutor;
        RemoteStoreNodeAttribute joiningRemoteStoreNodeAttribute = new RemoteStoreNodeAttribute(joiningNode);
     * will not be created with a newer version of opensearch as well as that all indices are newer or equal to the minimum index
    }
        Optional<DiscoveryNode> remoteRoutingTableNode = existingNodes.stream()
                        // This is hit only on cases where we encounter first remote node
                    }
            .stream()
    private final RerouteService rerouteService;
                    + "] is not supported."
            final Version maxNodeVersion = currentNodes.getMaxNodeVersion();
    protected ClusterState.Builder becomeClusterManagerAndTrimConflictingNodes(ClusterState currentState, List<Task> joiningNodes) {
                        .metadata(
                if (existingNode.isRemoteStoreNode()) {
        return Collections.unmodifiableCollection(validators);
                            && joiniedNodeNameIds.containsKey(e.getNodeName())) {
            ensureNodesCompatibility(joiningNode, currentNodes, metadata, minNodeVersion, maxNodeVersion);
                        + supportedIndexVersion
        }
            throw new NotClusterManagerException("Node [" + currentNodes.getLocalNode() + "] not cluster-manager for join request");
                    ensureNodeCommissioned(node, currentState.metadata());
            logger.error("Exception in NodesCompatibility validation", e);
     * a task indicates that the current node should become cluster-manager
        }
     * ensures that the joining node has a version that's compatible with all current nodes
    static Metadata dropViewMetadata(Metadata metadata, Version minClusterNodeVersion) {
        CompatibilityMode remoteStoreCompatibilityMode = REMOTE_STORE_COMPATIBILITY_MODE_SETTING.get(metadata.settings());
        final DiscoveryNodes currentNodes = currentState.nodes();
            if (joinTask.isBecomeClusterManagerTask() || joinTask.isFinishElectionTask()) {
    }
    }
                    nodesBuilder.remove(nodeWithSameAddress.getId());
     * A remote store backed node is the one which holds all the remote store attributes and a remote store backed
        Metadata metadata,
            // we must return a new cluster state instance to force publishing. This is important
        this.remoteStoreNodeService = remoteStoreNodeService;
                "node version ["
                final DiscoveryNode nodeWithSameAddress = currentNodes.findByAddress(joiningNode.getAddress());
            if (existingNode.isRemoteStoreNode()) {
            // Note that we don't have to do any validation of the amount of joining nodes - the commit
import static org.opensearch.cluster.decommission.DecommissionHelper.nodeCommissioned;
                    if (enforceMajorVersion) {
                final DiscoveryNode nodeWithSameId = nodesBuilder.get(joiningNode.getId());
        Settings settings,
        // repository information.
        if (metadata.custom(ViewMetadata.TYPE) == null || minClusterNodeVersion.before(Version.V_3_10_0)) {
        }
     */
 * Unless required by applicable law or agreed to in writing,
        Version minClusterNodeVersion,
                try {
import org.opensearch.cluster.ClusterState;
        public DiscoveryNode node() {
    ) {
                    + minClusterNodeVersion
            RepositoriesMetadata repositoriesMetadata = remoteStoreNodeService.updateRepositoriesMetadata(
                // noop
/**
        private final String reason;
        DiscoveryNode joiningNode,
                if (existingRemoteStoreNodeAttribute.equalsWithRepoSkip(joiningRemoteStoreNodeAttribute, reposToSkip) == false) {
                    + "], which is incompatible."
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
import static org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode.STRICT;
                    );
        }
                        .build()
        final byte clusterMajor = minClusterNodeVersion.major == 1 ? 7 : minClusterNodeVersion.major;
                    logger.warn(reason);
     * carried along untouched while older nodes are still in the cluster, because they read it from every published
     * a task that is used to signal the election is stopped and we should process pending joins.
        }
            throw new IllegalStateException(
                        allocationService.adaptAutoExpandReplicas(
                ).build()
        Logger logger,
     * @throws IllegalStateException if any index is incompatible with the given version
                throw new IllegalStateException("a remote store node [" + joiningNode + "] is trying to join a non remote store cluster");
                    maxClusterNodeVersion = Version.max(maxClusterNodeVersion, node.getVersion());
    private static void ensureRepositoryCompatibility(DiscoveryNode joiningNode, DiscoveryNode existingNode, List<String> reposToValidate) {
                    ensureIndexCompatibility(node.getVersion(), currentState.getMetadata());
                    + "The cluster contains nodes with version ["
                throw new IllegalStateException(
        allocationService.cleanCaches();
        Version joiningNodeVersion = joiningNode.getVersion();
 * @opensearch.internal
import org.opensearch.cluster.routing.RerouteService;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
                "post-join reroute",
        if (existingRepositoriesMetadata != null) {
            List<String> repos = Arrays.asList(
        } else if (currentNodes.isLocalNodeElectedClusterManager() == false) {
        for (IndexMetadata idxMetadata : metadata) {
     * remote store attributes of joining node against the existing nodes of cluster.
                    nodesBuilder.add(node);
        public String reason() {
        AllocationService allocationService,
                    + "] is not supported. "
                        // Update nodeId in VotingConfigExclusion when a new node with excluded node name joins
        Version maxClusterNodeVersion
                Priority.HIGH,
        public String toString() {
                    .map(e -> {
     * The experimental Views feature was removed in 3.10.0. A {@code view} custom left behind by an earlier 3.x node is
                }
                        ? remoteRoutingTableNode
            );
            } else {
        logger.info("all nodes are on [{}] or later, removing the [{}] metadata custom", Version.V_3_10_0, ViewMetadata.TYPE);
        if (joiningNode.isRemoteStoreNode()) {
                existingRepositoriesMetadata
                    throw new IllegalStateException(
        Version supportedIndexVersion = nodeVersion.minimumIndexCompatibilityVersion();
                    Metadata newMetadata = Metadata.builder(currentState.metadata())
        assert existingNodes.isEmpty() == false;
     * <p>
            );
        }
     * compatibility version.
                    remoteDN.ifPresent(discoveryNode -> ensureRemoteStoreNodesCompatibility(joiningNode, discoveryNode, reposToSkip));
                        + idxMetadata.getCreationVersion()
                        .coordinationMetadata(coordMetadataBuilder.build())
            // during the cluster state publishing guarantees that we have enough
        RepositoriesMetadata existingRepositoriesMetadata = currentState.getMetadata().custom(RepositoriesMetadata.TYPE);
    }
                "a remote store node ["
        @Override
                getRoutingTableRepoName(remotePublicationNode.get().getAttributes())
 */
                    }
                }
                        "removing existing node [{}], which conflicts with incoming join from [{}]",
        // we validate that we are allowed to change the cluster state during cluster state processing
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.node.remotestore.RemoteStoreNodeService;
                        RepositoriesMetadata repositoriesMetadata = remoteStoreNodeService.updateRepositoriesMetadata(
     */
    /**
            throw new IllegalStateException(
            }
        if (repositoriesMetadata == null || repositoriesMetadata.repositories() == null || repositoriesMetadata.repositories().isEmpty()) {
                remoteDN.get(),
    public static void ensureMajorVersionBarrier(Version joiningNodeVersion, Version minClusterNodeVersion) {
        // This ensures a new node with remote routing table repo is able to join the cluster.
            .build();
                        : existingNodes.stream().filter(DiscoveryNode::isRemoteStoreNode).findFirst();
                                    dropViewMetadata(
        Map<String, String> joiniedNodeNameIds = new HashMap<>();
     */
                    nodesBuilder.remove(nodeWithSameId.getId());
        DiscoveryNode existingNode,
                        + nodeVersion
        }
        if (nodeCommissioned(node, metadata) == false) {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.getClusterStateRepoName;
                            return e;
        ClusterState.Builder newState;
        logger.trace("becomeClusterManagerAndTrimConflictingNodes: {}", tmpState.nodes());
            ensureNodeCommissioned(node, state.getMetadata());
    private final AllocationService allocationService;
        for (final Task joinTask : joiningNodes) {
                    + clusterMajor
    }
            } else {
        }
                    "index "
        private static final String BECOME_CLUSTER_MANAGER_TASK_REASON = "_BECOME_CLUSTER_MANAGER_TASK_";
        DiscoveryNodes currentNodes = currentState.nodes();
import org.opensearch.core.action.ActionListener;
                if (joiningNode.getVersion().after(currentNodes.getMaxNodeVersion())) {
            ensureRemoteStoreNodesCompatibility(joiningNode, currentNodes, metadata);
 * under the License.
    public static void ensureRemoteRepositoryCompatibility(DiscoveryNode joiningNode, DiscoveryNodes currentNodes, Metadata metadata) {
    }
                // no-op
    public static class Task {
            rerouteService.reroute(
    /**
    public static Task newFinishElectionTask() {
                    if (node.isClusterManagerNode()) {
        DiscoveryNode joiningNode,
    public boolean runOnlyOnClusterManager() {
    /**
            if (joiningNode.isRemoteStoreNode()) {
import java.util.Map;
        validators.addAll(onJoinValidators);
                ClusterBlocks.builder()
import java.util.Optional;
    private static void ensureRemoteStoreNodesCompatibility(
            return reason.equals(BECOME_CLUSTER_MANAGER_TASK_REASON);
                "node version ["
                    + "The cluster contains nodes with version ["
import org.opensearch.cluster.metadata.RepositoryMetadata;
        if (isClusterRemoteStoreEnabled || joiningNode.isRemoteStoreNode()) {
 * license agreements. See the NOTICE file distributed with
            );
 * The OpenSearch Contributors require contributions made to
        List<DiscoveryNode> existingNodes = new ArrayList<>(currentNodes.getNodes().values());
        RemoteStoreNodeService remoteStoreNodeService
                RemoteStoreNodeAttribute existingRemoteStoreNodeAttribute = new RemoteStoreNodeAttribute(existingNode);
                );
            if (joinTask.isBecomeClusterManagerTask() || joinTask.isFinishElectionTask()) {
package org.opensearch.cluster.coordination;
    ) {
import static org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode;
     * 2. The joining node has to be a non-remote store backed if it is joining a non-remote store backed cluster.
     * Task for the join task executor.
 * not use this file except in compliance with the License.
     * ensures that the joining node's major version is equal or higher to the minClusterNodeVersion. This is needed
 * specific language governing permissions and limitations
            .findFirst();
            .values()
     * TODO: When we support moving from remote store cluster to non remote store and vice versa the this logic will
    }
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.getRoutingTableRepoName;
                // if VotingConfigExclusions did get updated
            this.reason = reason;
