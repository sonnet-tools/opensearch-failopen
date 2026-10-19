                )
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;  
        }
import org.opensearch.cluster.node.DiscoveryNodeRole;
        ClusterStateChanges cluster = new ClusterStateChanges(xContentRegistry(), threadPool);
    public void testRandomClusterPromotesOldestReplica() throws InterruptedException {  
        logger.info("start all the primary shards, replicas will start initializing");  
        List<DiscoveryNode> allNodes = new ArrayList<>();
import org.opensearch.threadpool.TestThreadPool;  
            roles,  
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
        logger.info("start the replica shards");  
import java.util.concurrent.atomic.AtomicInteger;
    protected DiscoveryNode createNode(DiscoveryNodeRole... mustHaveRoles) {  
            // Pick a random subset of primaries to fail
                            );  
 * under the License.  
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
import org.apache.logging.log4j.LogManager;
            Version nodeVer = cursor.getVersion();  
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
            final ClusterState compareState = state;
            keepGoing = randomBoolean();
    private static final AtomicInteger nodeIdGenerator = new AtomicInteger();
            }
        clusterState = strategy.disassociateDeadNodes(clusterState, true, "reroute");  
        );
import java.util.Collections;
                        if (isSegmentReplicationEnabled) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
                            assertTrue(
 * compatible open source license.
        logger.info("--> starting replicas a random number of times");  
 * license agreements. See the NOTICE file distributed with
            String name = "index_" + randomAlphaOfLength(8).toLowerCase(Locale.ROOT);
        }
            .build();
public class FailedNodeRoutingTests extends OpenSearchAllocationTestCase {
            state = cluster.applyFailedShards(state, shardsToFail);  
        ClusterState state = randomInitialClusterState();  
            List<FailedShard> shardsToFail = new ArrayList<>();
    }
 * You may obtain a copy of the License at  
            state = cluster.reroute(state, new ClusterRerouteRequest()); // always reroute after adding node
        clusterState = strategy.reroute(clusterState, "reroute");
            .build();
        // randomly add nodes of mixed versions
    }
        );
import org.opensearch.cluster.routing.RoutingNode;  
                                    + candidateVer,  
            failedPrimaries.forEach(shardRouting -> {  
            });  
                        }  
 * this work for additional information regarding copyright
            assertTrue(state.metadata().hasIndex(name));
    }  
    private final Logger logger = LogManager.getLogger(FailedNodeRoutingTests.class);  
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(1));  
 *     http://www.apache.org/licenses/LICENSE-2.0
                .put(SETTING_NUMBER_OF_REPLICAS, randomIntBetween(2, 4));
                            assertTrue(  
 *  
import static org.hamcrest.Matchers.equalTo;  
        }  
        // at least two nodes that have the data role so that we can allocate shards
            .addAsNew(metadata.index("test2"))
import java.util.stream.Collectors;
            .build();  
 * Licensed to Elasticsearch under one or more contributor  
                    }
            Collections.emptyMap(),
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
import java.util.HashSet;
                    .remove(clusterState.routingTable().index("test2").shard(0).primaryShard().currentNodeId())  
            DiscoveryNodes newNodes = DiscoveryNodes.builder(state.nodes()).add(createNode()).build();
                                "candidate was not on the oldest version, new primary is on "
        DiscoveryNode localNode = createNode(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE); // local node is the cluster-manager  
 * GitHub history for details.
        allNodes.add(createNode(DiscoveryNodeRole.DATA_ROLE));  
            logger.info("--> state before failing shards: {}", state);
 * Unless required by applicable law or agreed to in writing,
        }  
 * this file be licensed under the Apache-2.0 license or a
                                    + candidateVer,
import org.opensearch.indices.replication.common.ReplicationType;
 */  
                                    + " and there is a candidate on "
        routingNodes = clusterState.getRoutingNodes();
import org.opensearch.threadpool.ThreadPool;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            Settings.Builder settingsBuilder = Settings.builder()
                                "candidate was not on the newest version, new primary is on "  
 * Modifications Copyright OpenSearch Contributors. See
                            );
            state = ClusterState.builder(state).nodes(newNodes).build();  
}
                DiscoveryNodes.builder(clusterState.nodes())
    public ClusterState randomInitialClusterState() {
import java.util.Set;  
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
        ClusterState state = ClusterStateCreationUtils.state(localNode, localNode, allNodes.toArray(new DiscoveryNode[0]));
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
                    .remove(clusterState.routingTable().index("test1").shard(0).primaryShard().currentNodeId())
            .addAsNew(metadata.index("test1"))  
    void testRandomClusterPromotesReplica(boolean isSegmentReplicationEnabled) throws InterruptedException {
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.node.DiscoveryNodes;
        return state;  
    }  
        logger.info("remove 2 nodes where primaries are allocated, reroute");  
            List<ShardRouting> primaries = state.getRoutingNodes()
                logger.info("--> new primary is on version {}: {}", newPrimaryVersion, newPrimary);  
        logger.info("--> adding random nodes");  
            id,
/*  
            VersionUtils.randomIndexCompatibleVersion(random())
 */
import java.util.List;  
        Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));
        boolean keepGoing = true;
            .metadata(metadata)
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
        for (int i = 0; i < randomIntBetween(2, 5); i++) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            .build();  
                Version newPrimaryVersion = getNodeVersion(newPrimary, compareState);
import org.opensearch.cluster.metadata.IndexMetadata;
        logger.info("--> creating some indices");
 * The OpenSearch Contributors require contributions made to  
                .put(
        clusterState = ClusterState.builder(clusterState)
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
                .filter(ShardRouting::primary)
import java.util.Optional;
                    Version candidateVer = getNodeVersion(sr, compareState);
                                candidateVer.onOrBefore(newPrimaryVersion)
        for (RoutingNode routingNode : routingNodes) {  
                compareState.routingTable().shardRoutingTable(newPrimary.shardId()).shardsWithState(STARTED).stream().forEach(sr -> {
            assertThat(routingNode.numberOfShardsWithState(STARTED), equalTo(1));
        logger.info("start 4 nodes");  
 * not use this file except in compliance with the License.
    }
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(1));
        testRandomClusterPromotesReplica(true);
            logger.info("--> node [{}] has version [{}]", cursor.getId(), nodeVer);
                settingsBuilder.put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);  
        assertThat(routingNodes.node("node4").numberOfShardsWithState(STARTED), equalTo(1));
        for (final DiscoveryNode cursor : state.nodes().getDataNodes().values()) {
                .collect(Collectors.toList());
import org.opensearch.indices.cluster.ClusterStateChanges;  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")).add(newNode("node4")))
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        clusterState = ClusterState.builder(clusterState)
        AllocationService strategy = createAllocationService(  
            if (isSegmentReplicationEnabled) {
            state = cluster.createIndex(state, request);  
package org.opensearch.cluster.routing.allocation;
            .routingTable(initialRoutingTable)  
import org.opensearch.Version;  
                        logger.info("--> candidate on {} node; shard routing: {}", candidateVer, sr);
    public void testRandomClusterPromotesNewestReplica() throws InterruptedException {
import org.opensearch.action.support.ActiveShardCount;  
 *
                .shardsWithState(STARTED)
            id,  
        Metadata metadata = Metadata.builder()  
    private static Version getNodeVersion(ShardRouting shardRouting, ClusterState state) {
import org.opensearch.cluster.ClusterState;
        RoutingTable initialRoutingTable = RoutingTable.builder()
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        allNodes.add(createNode(DiscoveryNodeRole.DATA_ROLE));
                        } else {
    }  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        }
        // randomly create some indices
 * the Apache License, Version 2.0 (the "License"); you may
                });
        terminate(threadPool);
            .build();
                .put(SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 4))  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import org.opensearch.cluster.routing.RoutingTable;
/*
                .build()  
        state = cluster.applyStartedShards(state, state.getRoutingNodes().shardsWithState(INITIALIZING));
                                    + " and there is a candidate on "  
        // Log the node versions (for debugging if necessary)
            failedPrimaries.stream().forEach(sr -> {
            List<ShardRouting> failedPrimaries = randomSubsetOf(primaries);  
                shardsToFail.add(new FailedShard(randomFrom(sr), "failed primary", new Exception(), randomBoolean()));
        logger.info("--> starting shards");
        final String id = String.format(Locale.ROOT, "node_%03d", nodeIdGenerator.incrementAndGet());  
import java.util.ArrayList;  
            });  
        for (int i = 0; i < randomIntBetween(2, 5); i++) {  
        Collections.addAll(roles, mustHaveRoles);
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < randomIntBetween(4, 8); i++) {
 * KIND, either express or implied.  See the License for the
        ThreadPool threadPool = new TestThreadPool(getClass().getName());
                .stream()  
        }
    }
                                    + newPrimaryVersion
        while (keepGoing) {  
import org.opensearch.test.VersionUtils;
    public void testSimpleFailedNodeTest() {
                                candidateVer.onOrAfter(newPrimaryVersion)
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),  
                                    + newPrimaryVersion
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        for (int i = 0; i < randomIntBetween(1, 10); i++) {
            buildNewFakeTransportAddress(),
        allNodes.add(localNode);
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(1));
 * software distributed under the License is distributed on an
 */  
            .nodes(  
        }  
        testRandomClusterPromotesReplica(false);
 *
                    if (candidateVer != null) {  
import org.opensearch.cluster.routing.RoutingNodes;
            allNodes.add(createNode());  
                logger.info("--> verifying version for {}", shardRouting);
            state = cluster.applyStartedShards(state, state.getRoutingNodes().shardsWithState(INITIALIZING));
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.node.DiscoveryNode;  
            assertThat(routingNode.numberOfShardsWithState(INITIALIZING), equalTo(1));
                ShardRouting newPrimary = compareState.routingTable().index(shardRouting.index()).shard(shardRouting.id()).primaryShard();  
import java.util.Locale;
            )
        return new DiscoveryNode(
 * specific language governing permissions and limitations
            CreateIndexRequest request = new CreateIndexRequest(name, settingsBuilder.build()).waitForActiveShards(ActiveShardCount.NONE);
        return Optional.ofNullable(state.getNodes().get(shardRouting.currentNodeId())).map(DiscoveryNode::getVersion).orElse(null);
import org.opensearch.cluster.metadata.Metadata;
import org.apache.logging.log4j.Logger;
/*  
            Settings.builder()
import org.opensearch.cluster.routing.ShardRouting;  
