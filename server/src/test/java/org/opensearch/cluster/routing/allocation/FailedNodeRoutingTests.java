            VersionUtils.randomIndexCompatibleVersion(random())
            assertThat(routingNode.numberOfShardsWithState(STARTED), equalTo(1));
        );
        ClusterState state = ClusterStateCreationUtils.state(localNode, localNode, allNodes.toArray(new DiscoveryNode[0]));
        for (int i = 0; i < randomIntBetween(4, 8); i++) {
        logger.info("--> starting replicas a random number of times");
    private final Logger logger = LogManager.getLogger(FailedNodeRoutingTests.class);
 * license agreements. See the NOTICE file distributed with
                .put(SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 4))
    public void testRandomClusterPromotesNewestReplica() throws InterruptedException {
                });
            final ClusterState compareState = state;
        clusterState = ClusterState.builder(clusterState)
                                    + " and there is a candidate on "
                .put(
        logger.info("remove 2 nodes where primaries are allocated, reroute");
        testRandomClusterPromotesReplica(true);
            String name = "index_" + randomAlphaOfLength(8).toLowerCase(Locale.ROOT);
 * Modifications Copyright OpenSearch Contributors. See
        AllocationService strategy = createAllocationService(
            .nodes(
        routingNodes = clusterState.getRoutingNodes();
        }
            DiscoveryNodes newNodes = DiscoveryNodes.builder(state.nodes()).add(createNode()).build();
        }
                logger.info("--> verifying version for {}", shardRouting);
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
            logger.info("--> node [{}] has version [{}]", cursor.getId(), nodeVer);
        // randomly add nodes of mixed versions
        ThreadPool threadPool = new TestThreadPool(getClass().getName());
/*
                                "candidate was not on the newest version, new primary is on "
                ShardRouting newPrimary = compareState.routingTable().index(shardRouting.index()).shard(shardRouting.id()).primaryShard();
    private static final AtomicInteger nodeIdGenerator = new AtomicInteger();
                compareState.routingTable().shardRoutingTable(newPrimary.shardId()).shardsWithState(STARTED).stream().forEach(sr -> {
                                    + newPrimaryVersion
                                    + candidateVer,
                .collect(Collectors.toList());
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")).add(newNode("node4")))
 * software distributed under the License is distributed on an
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
import org.opensearch.cluster.ClusterState;
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
            .metadata(metadata)
 */
                                    + candidateVer,
                                "candidate was not on the oldest version, new primary is on "
        for (int i = 0; i < randomIntBetween(1, 10); i++) {
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
import org.opensearch.indices.replication.common.ReplicationType;
 * Unless required by applicable law or agreed to in writing,
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                            assertTrue(
import java.util.stream.Collectors;
 *
            CreateIndexRequest request = new CreateIndexRequest(name, settingsBuilder.build()).waitForActiveShards(ActiveShardCount.NONE);
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
 * Licensed to Elasticsearch under one or more contributor
                )
            List<ShardRouting> primaries = state.getRoutingNodes()
        allNodes.add(createNode(DiscoveryNodeRole.DATA_ROLE));
                .filter(ShardRouting::primary)
import org.opensearch.Version;
                                    + newPrimaryVersion
            .build();
                            );
/*
                .put(SETTING_NUMBER_OF_REPLICAS, randomIntBetween(2, 4));
 *
import org.opensearch.cluster.node.DiscoveryNodeRole;
            Settings.builder()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
 * The OpenSearch Contributors require contributions made to
        logger.info("start 4 nodes");
            });
        return state;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
        Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));
        for (int i = 0; i < randomIntBetween(2, 5); i++) {
        clusterState = ClusterState.builder(clusterState)
        final String id = String.format(Locale.ROOT, "node_%03d", nodeIdGenerator.incrementAndGet());
 * KIND, either express or implied.  See the License for the
        }
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        return new DiscoveryNode(
    private static Version getNodeVersion(ShardRouting shardRouting, ClusterState state) {
        Collections.addAll(roles, mustHaveRoles);
import org.opensearch.indices.cluster.ClusterStateChanges;
        }
import org.opensearch.threadpool.TestThreadPool;
package org.opensearch.cluster.routing.allocation;
import org.opensearch.cluster.routing.RoutingNode;
            Settings.Builder settingsBuilder = Settings.builder()
import org.apache.logging.log4j.LogManager;
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(1));
            Version nodeVer = cursor.getVersion();
import org.apache.logging.log4j.Logger;
        clusterState = strategy.disassociateDeadNodes(clusterState, true, "reroute");
    }
import org.opensearch.cluster.node.DiscoveryNodes;
            failedPrimaries.stream().forEach(sr -> {
            if (isSegmentReplicationEnabled) {
            .build();
            )
        testRandomClusterPromotesReplica(false);
            }
                        } else {
import org.opensearch.cluster.metadata.Metadata;
                                candidateVer.onOrBefore(newPrimaryVersion)
        logger.info("start all the primary shards, replicas will start initializing");
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
                        if (isSegmentReplicationEnabled) {
            assertThat(routingNode.numberOfShardsWithState(INITIALIZING), equalTo(1));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.cluster.routing.ShardRouting;
        // at least two nodes that have the data role so that we can allocate shards
                settingsBuilder.put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);
import java.util.HashSet;
        // randomly create some indices
        allNodes.add(localNode);
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
                DiscoveryNodes.builder(clusterState.nodes())
            roles,
                    Version candidateVer = getNodeVersion(sr, compareState);
                            );
                    }
        DiscoveryNode localNode = createNode(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE); // local node is the cluster-manager
        clusterState = strategy.reroute(clusterState, "reroute");
                logger.info("--> new primary is on version {}: {}", newPrimaryVersion, newPrimary);
    public ClusterState randomInitialClusterState() {
/*
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
 * SPDX-License-Identifier: Apache-2.0
                    .remove(clusterState.routingTable().index("test2").shard(0).primaryShard().currentNodeId())
            .build();
        ClusterStateChanges cluster = new ClusterStateChanges(xContentRegistry(), threadPool);
        Metadata metadata = Metadata.builder()
            id,
 * this work for additional information regarding copyright
import java.util.Locale;
        assertThat(routingNodes.node("node4").numberOfShardsWithState(STARTED), equalTo(1));
    void testRandomClusterPromotesReplica(boolean isSegmentReplicationEnabled) throws InterruptedException {
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
                    if (candidateVer != null) {
        }
public class FailedNodeRoutingTests extends OpenSearchAllocationTestCase {
 *
            .routingTable(initialRoutingTable)
            state = cluster.reroute(state, new ClusterRerouteRequest()); // always reroute after adding node
import org.opensearch.test.VersionUtils;
        logger.info("start the replica shards");
    }
import org.opensearch.threadpool.ThreadPool;
 * You may obtain a copy of the License at
            Collections.emptyMap(),
        logger.info("--> adding random nodes");
            .addAsNew(metadata.index("test2"))
            List<FailedShard> shardsToFail = new ArrayList<>();
            List<ShardRouting> failedPrimaries = randomSubsetOf(primaries);
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(1));
 * ownership. Elasticsearch licenses this file to you under
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.ArrayList;
        for (RoutingNode routingNode : routingNodes) {
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(1));
            });
            buildNewFakeTransportAddress(),
import org.opensearch.common.settings.Settings;
        for (int i = 0; i < randomIntBetween(2, 5); i++) {
                Version newPrimaryVersion = getNodeVersion(newPrimary, compareState);
import org.opensearch.cluster.metadata.IndexMetadata;
            logger.info("--> state before failing shards: {}", state);
import static org.hamcrest.Matchers.equalTo;
 * under the License.
import java.util.concurrent.atomic.AtomicInteger;
            // Pick a random subset of primaries to fail
        }
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
 */
import org.opensearch.cluster.OpenSearchAllocationTestCase;
    }
            .build();
        }
    public void testSimpleFailedNodeTest() {
                        logger.info("--> candidate on {} node; shard routing: {}", candidateVer, sr);
 * compatible open source license.
            state = ClusterState.builder(state).nodes(newNodes).build();
            state = cluster.applyFailedShards(state, shardsToFail);
                    .remove(clusterState.routingTable().index("test1").shard(0).primaryShard().currentNodeId())
        RoutingTable initialRoutingTable = RoutingTable.builder()
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
                                candidateVer.onOrAfter(newPrimaryVersion)
        for (final DiscoveryNode cursor : state.nodes().getDataNodes().values()) {
    }
        logger.info("--> creating some indices");
    }
        List<DiscoveryNode> allNodes = new ArrayList<>();
import org.opensearch.cluster.routing.RoutingTable;
                shardsToFail.add(new FailedShard(randomFrom(sr), "failed primary", new Exception(), randomBoolean()));
        return Optional.ofNullable(state.getNodes().get(shardRouting.currentNodeId())).map(DiscoveryNode::getVersion).orElse(null);
                        }
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
 * the Apache License, Version 2.0 (the "License"); you may
            id,
 *     http://www.apache.org/licenses/LICENSE-2.0
}
 * specific language governing permissions and limitations
    }
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        boolean keepGoing = true;
        );
            keepGoing = randomBoolean();
import java.util.List;
import org.opensearch.cluster.routing.RoutingNodes;
            state = cluster.applyStartedShards(state, state.getRoutingNodes().shardsWithState(INITIALIZING));
    public void testRandomClusterPromotesOldestReplica() throws InterruptedException {
            .build();
            failedPrimaries.forEach(shardRouting -> {
        while (keepGoing) {
import org.opensearch.action.support.ActiveShardCount;
                            assertTrue(
        // Log the node versions (for debugging if necessary)
    protected DiscoveryNode createNode(DiscoveryNodeRole... mustHaveRoles) {
            assertTrue(state.metadata().hasIndex(name));
        allNodes.add(createNode(DiscoveryNodeRole.DATA_ROLE));
            .addAsNew(metadata.index("test1"))
            state = cluster.createIndex(state, request);
                                    + " and there is a candidate on "
import java.util.Collections;
 * GitHub history for details.
    }
            allNodes.add(createNode());
        logger.info("--> starting shards");
import java.util.Set;
        ClusterState state = randomInitialClusterState();
                .stream()
        terminate(threadPool);
import java.util.Optional;
                .shardsWithState(STARTED)
        state = cluster.applyStartedShards(state, state.getRoutingNodes().shardsWithState(INITIALIZING));
                .build()
 */
