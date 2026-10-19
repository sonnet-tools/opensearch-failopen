            shardIdsToFail.add(randomInt(numberOfShards - 1));
            nodesBuilder.add(newNode("extra_" + i));  
 *
    private void assertAllPrimaryTerm() {
import java.util.HashMap;  
        // stablize cluster
    private static final String TEST_INDEX_1 = "test1";  
    /**  
    private void initPrimaries() {  
public class PrimaryTermsTests extends OpenSearchAllocationTestCase {
 * software distributed under the License is distributed on an
        while (changed) {
            builder.metadata(Metadata.builder(newClusterState.metadata()).version(newClusterState.metadata().version() + 1));  
import org.opensearch.cluster.node.DiscoveryNodes.Builder;
        for (int i = 0; i < newNodes; i++) {
        primaryTermsPerIndex.get(index)[shard]++;  
                equalTo(terms[shard])
            assertAllPrimaryTerm();  
        }
        Set<Integer> shardIdsToFail = new HashSet<>();  
            assertAllPrimaryTerm();
 * ownership. Elasticsearch licenses this file to you under  
    private static final String TEST_INDEX_2 = "test2";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        logger.info("failing primary shards {} for index [{}]", shardIdsToFail, index);
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", Integer.MAX_VALUE)
            assertAllPrimaryTerm();
 * SPDX-License-Identifier: Apache-2.0
        this.clusterState = builder.build();
        }  
 *  
        assertAllPrimaryTerm();
                new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_2).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_2)).build()
    }
                .put("cluster.routing.allocation.node_concurrent_recoveries", Integer.MAX_VALUE) // don't limit recoveries  
    private void assertPrimaryTerm(String index) {
 * not use this file except in compliance with the License.
        ClusterState rerouteResult = allocationService.reroute(clusterState, "reroute");
        this.primaryTermsPerIndex.clear();
            .numberOfReplicas(this.numberOfReplicas)
import org.opensearch.cluster.routing.allocation.AllocationService;  
    }
import org.opensearch.Version;
    }  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.settings.Settings;
            .metadata(metadata)
        logger.info("Setup test with {} shards and {} replicas.", this.numberOfShards, this.numberOfReplicas);  
package org.opensearch.cluster.routing;
    }
            builder.routingTable(
        startInitializingShards(TEST_INDEX_2);
            changed |= startInitializingShards(TEST_INDEX_2);  
            )  
        }
    private int numberOfShards;
    private void incrementPrimaryTerm(String index, int shard) {
            Settings.builder()
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
            clusterHealth.getInitializingShards(),
 * this work for additional information regarding copyright
    private final Map<String, long[]> primaryTermsPerIndex = new HashMap<>();
        ClusterState rerouteResult = startShardsAndReroute(allocationService, clusterState, startedShards);  
        this.allocationService = createAllocationService(
        // primary promotion
            primaryTermsPerIndex.get(indexName)[i] = builder.primaryTerm(i);
        assertAllPrimaryTerm();
        assertAllPrimaryTerm();
        this.clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
    }
            primaryTerms[i]++;
        return builder;
        primaryTermsPerIndex.keySet().forEach(this::incrementPrimaryTerm);
 * this file be licensed under the Apache-2.0 license or a
/*  
    public void setUp() throws Exception {
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;  
 * You may obtain a copy of the License at  
    private void incrementPrimaryTerm(String index) {
        this.numberOfShards = randomIntBetween(1, 5);
        // relocations shouldn't change much
 * license agreements. See the NOTICE file distributed with
        logger.info("adding [{}] nodes", newNodes);
import java.util.Map;  
    }
        applyRerouteResult(rerouteResult);  
    private boolean startInitializingShards(String index) {  
    private void failSomePrimaries(String index) {
        final List<ShardRouting> startedShards = clusterState.getRoutingNodes().shardsWithState(index, INITIALIZING);
 * Unless required by applicable law or agreed to in writing,
 */  
        }  
 * compatible open source license.
 *
            final int shard = shardRoutingTable.shardId().id();  
    private static final Settings DEFAULT_SETTINGS = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
        final long[] terms = primaryTermsPerIndex.get(index);  
        Builder discoBuilder = DiscoveryNodes.builder();
        logger.info("adding {} nodes and performing rerouting", this.numberOfReplicas + 1);
        primaryTermsPerIndex.put(indexName, new long[numberOfShards]);
        }
        }  
import static org.hamcrest.Matchers.equalTo;
        for (int shard : shardIdsToFail) {  
import org.opensearch.cluster.ClusterState;
/*  
    }
        applyRerouteResult(rerouteResult);
                RoutingTable.builder(newClusterState.routingTable()).version(newClusterState.routingTable().version() + 1).build()
import org.opensearch.cluster.health.ClusterStateHealth;
    }
        // now start all replicas too  
            changed = startInitializingShards(TEST_INDEX_1);
    }
        assertAllPrimaryTerm();
                "primary term mismatch between indexMetadata of [" + index + "] and shard [" + shard + "]'s routing",
            incrementPrimaryTerm(index, shard); // the primary failure should increment the primary term;
 * under the License.  
        final long[] primaryTerms = primaryTermsPerIndex.get(index);
            builder.primaryTerm(i, randomInt(200));
import java.util.HashSet;
            clusterHealth.getActiveShards(),
 * Licensed to Elasticsearch under one or more contributor  
        primaryTermsPerIndex.keySet().forEach(this::assertPrimaryTerm);
    @Override
        }
        startInitializingShards(TEST_INDEX_2);  
 */
            .routingTable(routingTable)
        Metadata metadata = Metadata.builder().put(createIndexMetadata(TEST_INDEX_1)).put(createIndexMetadata(TEST_INDEX_2)).build();
        if (previousClusterState.routingTable() != newClusterState.routingTable()) {  
                indexMetadata.primaryTerm(shard),  
            new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_1).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_1)).build()
        startInitializingShards(TEST_INDEX_1);  
    private void applyRerouteResult(ClusterState newClusterState) {  
            .add(
            discoBuilder = discoBuilder.add(newNode("node" + i));
    private void addNodes() {
        assertThat(rerouteResult, not(equalTo(this.clusterState)));
                .build()
        RoutingTable routingTable = new RoutingTable.Builder().add(
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterState.nodes());
            );  
            "applied reroute. active shards: p [{}], t [{}], init shards: [{}], relocating: [{}]",
 * specific language governing permissions and limitations
        for (int i = 0; i < primaryTerms.length; i++) {  
        final IndexMetadata indexMetadata = clusterState.metadata().index(index);
        ClusterState.Builder builder = ClusterState.builder(newClusterState).incrementVersion();
        applyRerouteResult(allocationService.applyFailedShards(this.clusterState, failedShards, Collections.emptyList()));
        for (int i = 1 + randomInt(numberOfShards - 1); i > 0; i--) {
        this.clusterState = ClusterState.builder(clusterState).nodes(nodesBuilder).build();
    }  
        );
    }
            .numberOfShards(this.numberOfShards);
            .build();
import org.opensearch.cluster.routing.allocation.FailedShard;
 * GitHub history for details.
        ClusterState previousClusterState = this.clusterState;
}
 * Modifications Copyright OpenSearch Contributors. See
    private int numberOfReplicas;  
 * the Apache License, Version 2.0 (the "License"); you may
        assertAllPrimaryTerm();
        }
        logger.info(
    private AllocationService allocationService;
        startInitializingShards(TEST_INDEX_1);
        boolean changed = rerouteResult.equals(clusterState) == false;
            clusterHealth.getRelocatingShards()  
 * The OpenSearch Contributors require contributions made to  
 */  
        this.clusterState = ClusterState.builder(clusterState).nodes(discoBuilder).build();  
        this.numberOfReplicas = randomIntBetween(0, 5);
        for (int i = 0; i < this.numberOfReplicas + 1; i++) {  
        addNodes();  
        }  
        for (IndexShardRoutingTable shardRoutingTable : this.clusterState.routingTable().index(index)) {
        for (int i = 0; i < numberOfShards; i++) {  
        boolean changed = true;
        final IndexMetadata.Builder builder = new IndexMetadata.Builder(indexName).settings(DEFAULT_SETTINGS)  
import org.opensearch.cluster.node.DiscoveryNodes;
        final IndexRoutingTable indexShardRoutingTable = clusterState.routingTable().index(index);
     * puts primary shard indexRoutings into initializing state
        changed = true;  
        final int newNodes = randomInt(10);  
        while (changed) {  
/*
            clusterHealth.getActivePrimaryShards(),  
        super.setUp();  
        }
        failSomePrimaries(TEST_INDEX_1);
            changed |= startInitializingShards(TEST_INDEX_2);
import java.util.ArrayList;
        logger.info("start primary shards for index [{}]: {} ", index, startedShards);
    private ClusterState clusterState;  
        );  
        return changed;  
        final ClusterStateHealth clusterHealth = new ClusterStateHealth(clusterState);  
        if (previousClusterState.metadata() != newClusterState.metadata()) {
import static org.hamcrest.Matchers.not;
            .build();  
import java.util.List;
        )  
import java.util.Collections;
            assertThat(
        List<FailedShard> failedShards = new ArrayList<>();
        assertAllPrimaryTerm();  
        assertAllPrimaryTerm();  
    public void testPrimaryTermMetadataSync() {  
        initPrimaries();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        applyRerouteResult(allocationService.reroute(this.clusterState, "nodes added"));  
            changed = startInitializingShards(TEST_INDEX_1);
import org.opensearch.cluster.metadata.IndexMetadata;
    private IndexMetadata.Builder createIndexMetadata(String indexName) {
        }  
     */
import org.opensearch.cluster.metadata.Metadata;  
            failedShards.add(new FailedShard(indexShardRoutingTable.shard(shard).primaryShard(), "test", null, randomBoolean()));
            );
import java.util.Set;
            assertAllPrimaryTerm();
    }
