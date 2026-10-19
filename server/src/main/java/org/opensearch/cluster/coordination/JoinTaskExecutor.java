    private static void ensureRepositoryCompatibility(DiscoveryNode joiningNode, DiscoveryNode existingNode, List<String> reposToValidate) {  
                    }  
     *  
    private static void ensureRemoteClusterStateNodesCompatibility(DiscoveryNode joiningNode, DiscoveryNodes currentNodes) {
                    "index "  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
    }
    }  
                            return new CoordinationMetadata.VotingConfigExclusion(joiniedNodeNameIds.get(e.getNodeName()), e.getNodeName());  
        this.remoteStoreNodeService = remoteStoreNodeService;  
                    "index "
        public DiscoveryNode node() {
 * GitHub history for details.
        validators.addAll(onJoinValidators);
        }  
     */  
            } else {
                        + idxMetadata.getIndex()  
            .blocks(
        Settings settings,  
            throw new IllegalStateException(
    public static Collection<BiConsumer<DiscoveryNode, ClusterState>> addBuiltInJoinValidators(
                "node version ["
import org.opensearch.cluster.node.DiscoveryNode;
                    })
                        repositoriesMetadata.repositories().forEach(r -> repositories.putIfAbsent(r.name(), r));  
                        logger.info("Updating system repository now for remote store");
     * a task indicates that the current node should become cluster-manager  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            ensureIndexCompatibility(node.getVersion(), state.getMetadata());
            } else {  
                        } else {
                            + existingNode
     * Ensures that all indices are compatible with the given node version. This will ensure that all indices in the given metadata  
        RepositoriesMetadata existingRepositoriesMetadata = currentState.getMetadata().custom(RepositoriesMetadata.TYPE);
import static org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode.MIXED;
                ClusterBlocks.builder()  
                                updateMetadataWithRepositoriesMetadata(currentState.metadata(), repositoriesMetadata),
            .build();
                        nodeWithSameAddress,
            this.node = node;  
                    }
                    );
                                    dropViewMetadata(
        private final String reason;  
import org.opensearch.cluster.routing.RerouteService;  
                RemoteStoreNodeAttribute joiningRemoteStoreNodeAttribute = new RemoteStoreNodeAttribute(joiningNode);  
                    ensureNodesCompatibility(node, currentNodes, currentState.metadata(), minClusterNodeVersion, maxClusterNodeVersion);
                            && joiniedNodeNameIds.containsKey(e.getNodeName())) {
import java.util.Set;
                }  
 */  
    private static Logger logger = LogManager.getLogger(JoinTaskExecutor.class);
package org.opensearch.cluster.coordination;
                    + joiningNodeVersion  
            rerouteService.reroute(
                if (joiningNode.isRemoteStoreNode()) {
                                )
                            node,  
     * 1. The joining node has to be a remote store backed if it's joining a remote store backed cluster. Validates  
                    .collect(Collectors.toSet());
import org.opensearch.node.remotestore.RemoteStoreNodeService;  
import org.opensearch.cluster.ClusterState;  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    if ((remoteDN.isEmpty() && node.isRemoteSegmentStoreNode())
                reposToSkip.add(joiningNodeRepoName);  
        }
            );  
 */  
    public static void ensureNodesCompatibility(final DiscoveryNode joiningNode, DiscoveryNodes currentNodes, Metadata metadata) {
                    Metadata newMetadata = Metadata.builder(currentState.metadata())  
        public boolean isBecomeClusterManagerTask() {
                        + supportedIndexVersion
/*
            final Version maxNodeVersion = currentNodes.getMaxNodeVersion();
        Version joiningNodeVersion = joiningNode.getVersion();  
                    newState.nodes(nodesBuilder)
        public String toString() {
        public boolean isFinishElectionTask() {  
    /**
     */
                            existingRepositoriesMetadata
import org.opensearch.cluster.metadata.IndexMetadata;
     * remote store attributes of joining node against the existing nodes of cluster.
                if (nodeWithSameAddress != null && nodeWithSameAddress.equals(joiningNode) == false) {
import org.opensearch.persistent.PersistentTasksCustomMetadata;
        boolean isClusterRemoteStoreEnabled = existingNodes.stream().anyMatch(DiscoveryNode::isRemoteStoreNode);
            .filter(DiscoveryNode::isRemoteStatePublicationEnabled)
     */
                        + idxMetadata.getCreationVersion()
        DiscoveryNodes currentNodes,
        } else {  
        // we validate that we are allowed to change the cluster state during cluster state processing
            .findFirst();  
    /**
            }
            if (idxMetadata.getCreationVersion().after(nodeVersion)) {  
        RemoteStoreNodeAttribute existingRemoteStoreNodeAttribute = new RemoteStoreNodeAttribute(existingNode);  
        final byte clusterMajor = minClusterNodeVersion.major == 1 ? 7 : minClusterNodeVersion.major;
            String joiningNodeRepoName = getRoutingTableRepoName(joiningNode.getAttributes());
                        minClusterNodeVersion
        CompatibilityMode remoteStoreCompatibilityMode = REMOTE_STORE_COMPATIBILITY_MODE_SETTING.get(metadata.settings());  
                        joiningNode,  
                    ensureNodeCommissioned(node, currentState.metadata());
                    nodesChanged = true;
        this.rerouteService = rerouteService;
/**
                    remoteDN.ifPresent(discoveryNode -> ensureRemoteStoreNodesCompatibility(joiningNode, discoveryNode, reposToSkip));
                ensureRemoteStoreNodesCompatibility(joiningNode, existingNode, reposToSkip);
                }  
            }
                )
        }
                    // we have to reject nodes that don't support all indices we have in this cluster  
                                minClusterNodeVersion  
            newState = becomeClusterManagerAndTrimConflictingNodes(currentState, joiningNodes);
    public static class Task {  
            throw new IllegalStateException(  
                        : existingNodes.stream().filter(DiscoveryNode::isRemoteStoreNode).findFirst();
            );
    public static void ensureRemoteRepositoryCompatibility(DiscoveryNode joiningNode, DiscoveryNodes currentNodes, Metadata metadata) {
            .filter(DiscoveryNode::isRemoteSegmentStoreNode)  
            .findFirst();
                    )
                RemoteStoreNodeAttribute existingRemoteStoreNodeAttribute = new RemoteStoreNodeAttribute(existingNode);
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(newState.nodes());
     */
            }
            );
        }
            newState = ClusterState.builder(currentState);
        final ClusterTasksResult.Builder<Task> results = ClusterTasksResult.builder();
                remoteDN.get(),
import org.opensearch.Version;
                    logger.debug(  
        return Collections.unmodifiableCollection(validators);  
        List<String> reposToSkip = new ArrayList<>(1);
        private static final String FINISH_ELECTION_TASK_REASON = "_FINISH_ELECTION_";
import java.util.List;  
            return metadata;  
        }
        Map<String, String> joiniedNodeNameIds = new HashMap<>();
                    + clusterMajor  
     * a task that is used to signal the election is stopped and we should process pending joins.
            throw new IllegalStateException(  
        for (IndexMetadata idxMetadata : metadata) {
            .filter(DiscoveryNode::isRemoteStatePublicationEnabled)  
            return reason.equals(FINISH_ELECTION_TASK_REASON);
                    + "]."
                // noop
 * Licensed to Elasticsearch under one or more contributor  
        AllocationService allocationService,
            );
            List<String> repos = Arrays.asList(
                    );  
            // Note that we don't have to do any validation of the amount of joining nodes - the commit
    protected ClusterState.Builder becomeClusterManagerAndTrimConflictingNodes(ClusterState currentState, List<Task> joiningNodes) {  
                } catch (IllegalArgumentException | IllegalStateException | NodeDecommissionedException e) {
                    throw new IllegalStateException(
     **/  
        if (remoteRoutingTableNode.isEmpty()) {  
        DiscoveryNode joiningNode,  
    }
                        "a remote store node ["
                    + "], which is incompatible."
        List<DiscoveryNode> existingNodes = new ArrayList<>(currentNodes.getNodes().values());
        private static final String BECOME_CLUSTER_MANAGER_TASK_REASON = "_BECOME_CLUSTER_MANAGER_TASK_";
            ensureRepositoryCompatibility(joiningNode, remotePublicationNode.get(), repos);  
        RemoteStoreNodeService remoteStoreNodeService
    public static void ensureNodeCommissioned(DiscoveryNode node, Metadata metadata) {  
        assert currentState.nodes().getClusterManagerNodeId() == null : currentState;
                currentNodes.getClusterManagerNode()  
        return Metadata.builder(metadata).removeCustom(ViewMetadata.TYPE).build();  
                }  
    private static void ensureRemoteStoreNodesCompatibility(DiscoveryNode joiningNode, DiscoveryNodes currentNodes, Metadata metadata) {  
    private static void ensureRemoteStoreNodesCompatibility(
 *  
 */
        final DiscoveryNodes currentNodes = currentState.nodes();
            }
        // If none of the existing nodes have routing table repo, then we skip this repo check if present in joining node.
    }
    }
            // for the joining node to finalize its join and set us as a cluster-manager
                    + "The cluster contains nodes with version ["
    private final AllocationService allocationService;  
 * software distributed under the License is distributed on an
        if (joiningNode.isRemoteStoreNode()) {
        Version maxClusterNodeVersion
                    + "comparison with existing node ["
        if (nodesChanged) {
                    + existingNode
 * SPDX-License-Identifier: Apache-2.0
                                .metadata(  
        RepositoriesMetadata repositoriesMetadata = new RepositoriesMetadata(new ArrayList<>(repositories.values()));  
        Optional<DiscoveryNode> remotePublicationNode = existingNodes.stream()
        }
                "node version ["
     * <p>
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.getRoutingTableRepoName;
     * The method ensures homogeneity -
                    nodesBuilder.add(node);
    }
     */  
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
        // or removed by us above
                            + "] is trying to join a remote store cluster with incompatible node attributes in "  
    public static Task newBecomeClusterManagerTask() {
 * specific language governing permissions and limitations
        if (repositoriesMetadata == null || repositoriesMetadata.repositories() == null || repositoriesMetadata.repositories().isEmpty()) {  
        // This ensures a new node with remote routing table repo is able to join the cluster.
     * carried along untouched while older nodes are still in the cluster, because they read it from every published  
                Set<CoordinationMetadata.VotingConfigExclusion> newVotingConfigExclusions = currentVotingConfigExclusions.stream()
                "a remote store node ["
                    if (node.isClusterManagerNode()) {
import org.opensearch.common.settings.Settings;  
                    );
                            )
                    continue;
                        + " version not supported: "
import org.opensearch.cluster.metadata.RepositoryMetadata;
    }  
import static org.opensearch.cluster.decommission.DecommissionHelper.nodeCommissioned;
                        if (CoordinationMetadata.VotingConfigExclusion.MISSING_VALUE_MARKER.equals(e.getNodeId())
        DiscoveryNodes currentNodes = currentState.nodes();
    public static void ensureMajorVersionBarrier(Version joiningNodeVersion, Version minClusterNodeVersion) {
     * remote store attributes.
            return results.build(  
    }
    private final RerouteService rerouteService;  
            throw new NotClusterManagerException("Node [" + currentNodes.getLocalNode() + "] not cluster-manager for join request");
        RemoteStoreNodeAttribute joiningRemoteStoreNodeAttribute = new RemoteStoreNodeAttribute(joiningNode);
     * Task for the join task executor.
}
import java.util.Map;
        }
                        allocationService.adaptAutoExpandReplicas(
        ClusterState tmpState = ClusterState.builder(currentState)  
        Version minClusterNodeVersion,  
     */
        try {  
            .findFirst();  
            if (joiningNodeRepoName != null) {
                );
        validators.add((node, state) -> {  
import org.opensearch.cluster.node.DiscoveryNodes;
                    + "The cluster contains nodes with version ["
        }
        RerouteService rerouteService,  
                if (existingNode.isRemoteStoreNode()) {  
        DiscoveryNode existingNode,
     */
        if (joiningNodeVersion.compareMajor(minClusterNodeVersion) < 0) {  
                    + maxClusterNodeVersion
            }
                getRoutingTableRepoName(remotePublicationNode.get().getAttributes())  
                    logger.debug("removing existing node [{}], which conflicts with incoming join from [{}]", nodeWithSameId, joiningNode);
import org.opensearch.cluster.block.ClusterBlocks;  
            } else {
                if (existingRemoteStoreNodeAttribute.equalsWithRepoSkip(joiningRemoteStoreNodeAttribute, reposToSkip) == false) {
            if (existingNode.isRemoteStoreNode()) {
        // An optimization can be done as this will get invoked  
        if (isClusterRemoteStoreEnabled || joiningNode.isRemoteStoreNode()) {  
                    results.failure(joinTask, e);  
import java.util.Locale;
        @Override  
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(currentNodes);  
                        );
                        joiningNode  
        ensureRemoteRepositoryCompatibility(joiningNode, currentNodes, metadata);
        // repository information.
                if (joiningNode.getVersion().after(currentNodes.getMaxNodeVersion())) {
import org.apache.logging.log4j.Logger;
            ensureRemoteClusterStateNodesCompatibility(joiningNode, currentNodes);  
                    + "] is not supported."
                try {  
                    + joiningNodeVersion
            logger.error("Exception in NodesCompatibility validation", e);
                    throw new IllegalStateException(reason);
            ensureNodeCommissioned(node, state.getMetadata());  
                        updateMetadataWithRepositoriesMetadata(currentState.metadata(), repositoriesMetadata),  
        ClusterState.Builder newState;  
    }  
        Version minClusterNodeVersion = newState.nodes().getMinNodeVersion();
    @Override
                        + " version not supported: "
    /**
        this.allocationService = allocationService;  
            if (idxMetadata.getCreationVersion().before(supportedIndexVersion)) {
            ensureRemoteStoreNodesCompatibility(joiningNode, currentNodes, metadata);
        return false;
                                    )
            if (joinTask.isBecomeClusterManagerTask() || joinTask.isFinishElectionTask()) {
                    + "] is not supported. "
                        Locale.ROOT,
     * @see Version#minimumIndexCompatibilityVersion()
 * @opensearch.internal
                        joiniedNodeNameIds.put(node.getName(), node.getId());  
import org.opensearch.common.Priority;
                final DiscoveryNode nodeWithSameId = nodesBuilder.get(joiningNode.getId());
                        + idxMetadata.getIndex()
        Map<String, RepositoryMetadata> repositories = new LinkedHashMap<>();
        DiscoveryNode joiningNode,  
        } else {
        JoinTaskExecutor.logger = logger;
                            dropViewMetadata(
    static Metadata dropViewMetadata(Metadata metadata, Version minClusterNodeVersion) {
 * this work for additional information regarding copyright
            } else if (currentNodes.nodeExistsWithSameRoles(node)) {  
    }
        private final DiscoveryNode node;
import java.util.Arrays;
                    ensureIndexCompatibility(node.getVersion(), currentState.getMetadata());
                "node [{}] has decommissioned attribute [{}] with current status of decommissioning [{}]",  
        Version maxClusterNodeVersion = newState.nodes().getMaxNodeVersion();  
        Optional<DiscoveryNode> remoteRoutingTableNode = existingNodes.stream()
            );
                    + joiningNodeVersion  
                    + "All nodes in the cluster are of a higher major ["
            throw e;  
                "node version ["
            );
    @SuppressWarnings("removal")  
                        currentNodes.getMaxNodeVersion()
                    return results.build(  
        // processing any joins  
    ) {  
            throw new IllegalStateException(
                }
            repositoriesMetadata.repositories().forEach(r -> repositories.putIfAbsent(r.name(), r));
        } catch (Exception e) {
     *       needs to be modified.
            this.reason = reason;
import org.opensearch.cluster.NotClusterManagerException;
        }
                    Optional<DiscoveryNode> remoteDN = remoteRoutingTableNode.isPresent()
                    minClusterNodeVersion = Version.min(minClusterNodeVersion, node.getVersion());  
                }
            return node != null ? node + " " + reason : reason;
        public String reason() {
     * it may be used in combination with {@link JoinTaskExecutor#newBecomeClusterManagerTask()}
     * compatibility version.
        final Collection<BiConsumer<DiscoveryNode, ClusterState>> validators = new ArrayList<>();
        } else if (currentNodes.isLocalNodeElectedClusterManager() == false) {  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode;  
 * Unless required by applicable law or agreed to in writing,
                if (nodeWithSameId != null && nodeWithSameId.equals(joiningNode) == false) {  
            return reason;  
            DiscoveryNode existingNode = remoteRoutingTableNode.orElseGet(() -> existingNodes.get(0));
 * Modifications Copyright OpenSearch Contributors. See  
            final DiscoveryNode node = joinTask.node();  
                        + idxMetadata.getCreationVersion()  
                remotePublicationDN.get(),  
    private final RemoteStoreNodeService remoteStoreNodeService;
        for (final Task joinTask : joiningNodes) {
 * The OpenSearch Contributors require contributions made to  
                "processing node joins, but we are not the cluster-manager. current cluster-manager: {}",
    }  
        }
        if (STRICT.equals(remoteStoreCompatibilityMode)) {
 * You may obtain a copy of the License at  
                    newVotingConfigExclusions.forEach(coordMetadataBuilder::addVotingConfigExclusion);
 * ownership. Elasticsearch licenses this file to you under  
        } else {  
    /**
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;  
            // during the cluster state publishing guarantees that we have enough  
                + joiningNodes;  
    private Metadata updateMetadataWithRepositoriesMetadata(Metadata currentMetadata, RepositoriesMetadata repositoriesMetadata) {
    }  
        }  
     * ensures that the joining node's major version is equal or higher to the minClusterNodeVersion. This is needed  
            ensureNodesCompatibility(node, state.getNodes(), state.metadata());
                    + "], which is incompatible."  
                "post-join reroute",  
                        ? remoteRoutingTableNode  
        return new Task(null, Task.FINISH_ELECTION_TASK_REASON);
        allocationService.cleanCaches();  
            );
        } else {
        public Task(DiscoveryNode node, String reason) {
                        + nodeVersion
                }
                newState.metadata(
        }  
                if (newVotingConfigExclusions.equals(currentVotingConfigExclusions) == false) {
                            + "comparison with existing node ["
                        RepositoriesMetadata repositoriesMetadata = remoteStoreNodeService.updateRepositoriesMetadata(
public class JoinTaskExecutor implements ClusterStateTaskExecutor<JoinTaskExecutor.Task> {
                throw new IllegalStateException(
                    + "]"  
        for (final Task joinTask : joiningNodes) {  
            if (MIXED.equals(remoteStoreCompatibilityMode)) {
        }
import org.opensearch.cluster.routing.allocation.AllocationService;
            return node;
                    logger.warn(reason);
            if (joiningNode.isRemoteStoreNode()) {  
     * TODO: When we support moving from remote store cluster to non remote store and vice versa the this logic will  
        }
        if (joiningNodeVersion.isCompatible(minClusterNodeVersion) == false) {  
                ).build()  
     * <p>
import java.util.function.BiConsumer;
                            newState.nodes(nodesBuilder)
                ActionListener.wrap(r -> logger.trace("post-join reroute completed"), e -> logger.debug("post-join reroute failed", e))
            .stream()
    /**
                allocationService.adaptAutoExpandReplicas(
            throw new NodeDecommissionedException(
    public ClusterTasksResult<Task> execute(ClusterState currentState, List<Task> joiningNodes) throws Exception {
            );
     * ensures that the joining node has a version that's compatible with all current nodes  
                        // Update nodeId in VotingConfigExclusion when a new node with excluded node name joins  
import org.opensearch.cluster.metadata.ViewMetadata;  
    @Override  
        Logger logger,
                    // we do this validation quite late to prevent race conditions between nodes joining and importing dangling indices
                );  
                existingRepositoriesMetadata  
                        joiningNode.getVersion(),
                        "a non remote store node [" + joiningNode + "] is trying to join a remote store cluster"
        }
                logger.debug("received a join request for an existing node [{}]", node);
            }  
                                        updateMetadataWithRepositoriesMetadata(newMetadata, repositoriesMetadata),
    }
            );
        // find a remote node which has routing table configured  
                    }
        }
        if (existingRepositoriesMetadata != null) {  
            // use these joins to try and become the cluster-manager.
        if (remotePublicationNode.isPresent() && joiningNode.isRemoteStatePublicationEnabled()) {  
            results.success(joinTask);
            .values()  
                        .build();
     * 2. The joining node has to be a non-remote store backed if it is joining a non-remote store backed cluster.
        Metadata metadata,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.getClusterStateRepoName;
                    .map(e -> {
    public boolean runOnlyOnClusterManager() {  
            ensureNodesCompatibility(joiningNode, currentNodes, metadata, minNodeVersion, maxNodeVersion);  
    }
/*
                final DiscoveryNode joiningNode = joinTask.node();
                        .clearVotingConfigExclusions();
            nodesChanged = true;
        if (joiningNodeVersion.isCompatible(maxClusterNodeVersion) == false) {
                    );  
        }
        }
        if (metadata.custom(ViewMetadata.TYPE) == null || minClusterNodeVersion.before(Version.V_3_10_0)) {
        logger.trace("becomeClusterManagerAndTrimConflictingNodes: {}", tmpState.nodes());
     * Validates no remote store attributes are present in joining node as existing nodes in the cluster doesn't have  
                    if (enforceMajorVersion) {
                        // This is hit only on cases where we encounter first remote node  
        // for every set of node join task which we can optimize to not compute if cluster state already has
                }  
                                .build()  
    public static void ensureNodesCompatibility(
                    String reason = String.format(  
            RepositoriesMetadata repositoriesMetadata = remoteStoreNodeService.updateRepositoriesMetadata(
        // we ensure that all indices in the cluster we join are compatible with us no matter if they are  
 *
        }
        }  
                metadata.decommissionAttributeMetadata().decommissionAttribute().toString(),
            )  
                            + "]"  
        boolean nodesChanged = false;
import java.util.ArrayList;  
import org.apache.logging.log4j.LogManager;  
     * A remote store backed node is the one which holds all the remote store attributes and a remote store backed  
import java.util.Collection;
        } else {  
    }  
import java.util.stream.Collectors;  
        Optional<DiscoveryNode> remoteDN = currentNodes.getNodes()  
            return results.successes(joiningNodes).build(currentState);  
        tmpState = PersistentTasksCustomMetadata.disassociateDeadNodes(tmpState);
                    + joiningNode
                        )
            RepositoriesMetadata repositoriesMetadata = remoteStoreNodeService.updateRepositoriesMetadata(
                    // we have added the same check in handleJoinRequest method and adding it here as this method
import org.opensearch.cluster.decommission.NodeDecommissionedException;
/*  
        final boolean enforceMajorVersion = currentState.getBlocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK) == false;
     *  
            return reason.equals(BECOME_CLUSTER_MANAGER_TASK_REASON);  
                    nodesBuilder.remove(nodeWithSameId.getId());
                        "remote migration : a node [%s] of higher version [%s] is not allowed to join a cluster with maximum version [%s]",
     * state. Once every node is on 3.10.0 or later nothing can read or write it, so it is dropped here.
            }
            }
        logger.info("all nodes are on [{}] or later, removing the [{}] metadata custom", Version.V_3_10_0, ViewMetadata.TYPE);
    /**
                        "removing existing node [{}], which conflicts with incoming join from [{}]",
                }  
     * cluster is the one which has only homogeneous remote store backed nodes with same node attributes
import org.opensearch.core.action.ActionListener;
    public static void ensureIndexCompatibility(final Version nodeVersion, Metadata metadata) {
        return ClusterState.builder(allocationService.disassociateDeadNodes(tmpState, false, "removed dead nodes on election"));
     * ensures that the joining node has a version that's compatible with a given version range and ensures that the
    /**  
                            + joiningNode
        // now trim any left over dead nodes - either left there when the previous cluster-manager stepped down
                // if VotingConfigExclusions did get updated
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;  
                    + "] is trying to join a remote store cluster with incompatible node attributes in "  
                        ensureMajorVersionBarrier(node.getVersion(), minClusterNodeVersion);
                    throw new IllegalStateException(  
            }  
import org.opensearch.cluster.metadata.Metadata;  
                            return e;
                        + " minimum compatible index version is: "
                    CoordinationMetadata.Builder coordMetadataBuilder = CoordinationMetadata.builder(currentState.coordinationMetadata())  
                    nodesBuilder.remove(nodeWithSameAddress.getId());
 * this file be licensed under the Apache-2.0 license or a
                existingRepositoriesMetadata
 * KIND, either express or implied.  See the License for the
                    + minClusterNodeVersion  
            if (joiniedNodeNameIds.isEmpty() == false) {
     * @throws IllegalStateException if any index is incompatible with the given version
            .values()
            .filter(node -> node.isRemoteStoreNode() && RemoteStoreNodeAttribute.getRoutingTableRepoName(node.getAttributes()) != null)
    public JoinTaskExecutor(
 * compatible open source license.
            .nodes(nodesBuilder)
            final Version minNodeVersion = currentNodes.getMinNodeVersion();
        List<String> reposToSkip
import java.util.LinkedHashMap;
        });
 *
                throw new IllegalStateException("a remote store node [" + joiningNode + "] is trying to join a non remote store cluster");
            );
import org.opensearch.cluster.ClusterStateTaskExecutor;
        }
                        || (remotePublicationDN.isEmpty() && node.isRemoteStatePublicationEnabled())) {
        Optional<DiscoveryNode> remotePublicationDN = currentNodes.getNodes()
            .findFirst();
        List<DiscoveryNode> existingNodes = new ArrayList<>(currentNodes.getNodes().values());
        return new Task(null, Task.BECOME_CLUSTER_MANAGER_TASK_REASON);  
        }
        }
                    maxClusterNodeVersion = Version.max(maxClusterNodeVersion, node.getVersion());
                    + "] is not supported. "  
                    );
                Priority.HIGH,
            existingRepositoriesMetadata.repositories().forEach(r -> repositories.putIfAbsent(r.name(), r));
        if (nodeCommissioned(node, metadata) == false) {
            } else {  
    }  
                    .removeGlobalBlock(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID)
            return currentMetadata;
            // we must return a new cluster state instance to force publishing. This is important
        assert existingNodes.isEmpty() == false;
    /**
                getClusterStateRepoName(remotePublicationNode.get().getAttributes()),
        }  
                        }  
import java.util.Optional;  
        }
                        )
    }  
    }  
                    // would guarantee that a decommissioned node would never be able to join the cluster and ensures correctness  
            if (joinTask.isBecomeClusterManagerTask() || joinTask.isFinishElectionTask()) {
                // no-op
        }  
        if (remoteDN.isPresent()) {  
                throw new IllegalStateException(
                node.toString(),
            );
 * Main executor for Nodes joining the OpenSearch cluster  
        assert existingNodes.isEmpty() == false;
 *
            repositoriesMetadata.repositories().forEach(r -> repositories.putIfAbsent(r.name(), r));  
            );
                        .metadata(  
        List<DiscoveryNode> existingNodes = new ArrayList<>(currentNodes.getNodes().values());  
    }  
        // we only enforce major version transitions on a fully formed clusters
        assert nodesBuilder.isLocalNodeElectedClusterManager();  
        Version supportedIndexVersion = nodeVersion.minimumIndexCompatibilityVersion();
                final DiscoveryNode nodeWithSameAddress = currentNodes.findByAddress(joiningNode.getAddress());
 * not use this file except in compliance with the License.
                    .blocks(currentState.blocks())
        }
                        .build()  
import java.util.Collections;  
        if (remotePublicationDN.isPresent()) {
import org.opensearch.cluster.metadata.RepositoriesMetadata;
            return Metadata.builder(currentMetadata).putCustom(RepositoriesMetadata.TYPE, repositoriesMetadata.get()).build();  
     * The experimental Views feature was removed in 3.10.0. A {@code view} custom left behind by an earlier 3.x node is
        } else if (currentNodes.getClusterManagerNode() == null && joiningNodes.stream().anyMatch(Task::isBecomeClusterManagerTask)) {
    ) {
     */
        // closed or not we can't read mappings of these indices so we need to reject the join...
     * will not be created with a newer version of opensearch as well as that all indices are newer or equal to the minimum index
        nodesBuilder.clusterManagerNodeId(currentState.nodes().getLocalNodeId());
import static org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode.STRICT;
    }
        assert minClusterNodeVersion.onOrBefore(maxClusterNodeVersion) : minClusterNodeVersion + " > " + maxClusterNodeVersion;
                        .coordinationMetadata(coordMetadataBuilder.build())
     * version mode
import java.util.HashMap;
            logger.trace(
            return results.build(  
    ) {
            .stream()
                metadata.decommissionAttributeMetadata().status().status()  
     * joining node has required attributes to join a remotestore cluster.  
     * @opensearch.internal
                                        minClusterNodeVersion  
                        + " the node version is: "  
 * under the License.  
            assert joiningNodes.stream().anyMatch(Task::isFinishElectionTask) : "becoming a cluster-manager but election is not finished "
    public static Task newFinishElectionTask() {
                Set<CoordinationMetadata.VotingConfigExclusion> currentVotingConfigExclusions = currentState.getVotingConfigExclusions();  
    ) {
     * to ensure that if the cluster-manager/master is already fully operating under the new major version, it doesn't go back to mixed
                    dropViewMetadata(
        if (existingRemoteStoreNodeAttribute.equalsForRepositories(joiningRemoteStoreNodeAttribute, reposToValidate) == false) {
    /**
        if (joiningNodes.size() == 1 && joiningNodes.get(0).isFinishElectionTask()) {
        Collection<BiConsumer<DiscoveryNode, ClusterState>> onJoinValidators  
 */
