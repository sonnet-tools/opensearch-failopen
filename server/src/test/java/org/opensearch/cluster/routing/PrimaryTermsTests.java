    public void testPrimaryTermMetadataSync() {
        super.setUp();
            .add(
    }
 *
        List<FailedShard> failedShards = new ArrayList<>();
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.cluster.ClusterState;
    private final Map<String, long[]> primaryTermsPerIndex = new HashMap<>();
 * software distributed under the License is distributed on an
            builder.metadata(Metadata.builder(newClusterState.metadata()).version(newClusterState.metadata().version() + 1));
package org.opensearch.cluster.routing;
        for (int shard : shardIdsToFail) {
        Metadata metadata = Metadata.builder().put(createIndexMetadata(TEST_INDEX_1)).put(createIndexMetadata(TEST_INDEX_2)).build();
            .metadata(metadata)
            assertAllPrimaryTerm();
        }
        primaryTermsPerIndex.get(index)[shard]++;
        this.numberOfReplicas = randomIntBetween(0, 5);
public class PrimaryTermsTests extends OpenSearchAllocationTestCase {
    private void assertAllPrimaryTerm() {
        this.clusterState = builder.build();
            assertAllPrimaryTerm();
            assertAllPrimaryTerm();
        this.clusterState = ClusterState.builder(clusterState).nodes(nodesBuilder).build();
 * not use this file except in compliance with the License.
        assertAllPrimaryTerm();
import org.opensearch.common.settings.Settings;
import java.util.HashSet;
 * The OpenSearch Contributors require contributions made to
 * license agreements. See the NOTICE file distributed with
            .numberOfShards(this.numberOfShards);
            clusterHealth.getInitializingShards(),
            builder.primaryTerm(i, randomInt(200));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return builder;
            changed = startInitializingShards(TEST_INDEX_1);
    private static final String TEST_INDEX_1 = "test1";
                .put("cluster.routing.allocation.node_concurrent_recoveries", Integer.MAX_VALUE) // don't limit recoveries
            nodesBuilder.add(newNode("extra_" + i));
            .numberOfReplicas(this.numberOfReplicas)
        for (int i = 0; i < numberOfShards; i++) {
        }
        this.clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        }
        startInitializingShards(TEST_INDEX_1);
        logger.info("Setup test with {} shards and {} replicas.", this.numberOfShards, this.numberOfReplicas);
import java.util.Map;
import java.util.ArrayList;
    public void setUp() throws Exception {
        assertAllPrimaryTerm();
    private void assertPrimaryTerm(String index) {
        return changed;
    private int numberOfShards;
        primaryTermsPerIndex.put(indexName, new long[numberOfShards]);
    }
 * the Apache License, Version 2.0 (the "License"); you may
        logger.info("adding {} nodes and performing rerouting", this.numberOfReplicas + 1);
    }
        ClusterState rerouteResult = allocationService.reroute(clusterState, "reroute");
    }
        primaryTermsPerIndex.keySet().forEach(this::incrementPrimaryTerm);
        startInitializingShards(TEST_INDEX_2);
        ClusterState.Builder builder = ClusterState.builder(newClusterState).incrementVersion();
            failedShards.add(new FailedShard(indexShardRoutingTable.shard(shard).primaryShard(), "test", null, randomBoolean()));
import org.opensearch.Version;
                indexMetadata.primaryTerm(shard),
    }
            primaryTermsPerIndex.get(indexName)[i] = builder.primaryTerm(i);
     * puts primary shard indexRoutings into initializing state
            .build();
        for (int i = 1 + randomInt(numberOfShards - 1); i > 0; i--) {
            )
        for (int i = 0; i < newNodes; i++) {
    }
        assertAllPrimaryTerm();
                "primary term mismatch between indexMetadata of [" + index + "] and shard [" + shard + "]'s routing",
    private IndexMetadata.Builder createIndexMetadata(String indexName) {
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterState.nodes());
        assertAllPrimaryTerm();
}
            );
        }
    private ClusterState clusterState;
        logger.info("start primary shards for index [{}]: {} ", index, startedShards);
        final ClusterStateHealth clusterHealth = new ClusterStateHealth(clusterState);
            clusterHealth.getRelocatingShards()
        while (changed) {
import org.opensearch.cluster.health.ClusterStateHealth;
        Builder discoBuilder = DiscoveryNodes.builder();
        final IndexMetadata indexMetadata = clusterState.metadata().index(index);
        assertAllPrimaryTerm();
    @Override
            new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_1).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_1)).build()
    }
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
        Set<Integer> shardIdsToFail = new HashSet<>();
    private void addNodes() {
        final List<ShardRouting> startedShards = clusterState.getRoutingNodes().shardsWithState(index, INITIALIZING);
    private void incrementPrimaryTerm(String index) {
        }
import org.opensearch.cluster.OpenSearchAllocationTestCase;
    private static final String TEST_INDEX_2 = "test2";
    private void incrementPrimaryTerm(String index, int shard) {
            assertAllPrimaryTerm();
            final int shard = shardRoutingTable.shardId().id();
        startInitializingShards(TEST_INDEX_1);
        ClusterState rerouteResult = startShardsAndReroute(allocationService, clusterState, startedShards);
        }
        if (previousClusterState.routingTable() != newClusterState.routingTable()) {
        for (int i = 0; i < primaryTerms.length; i++) {
/*
import java.util.List;
            primaryTerms[i]++;
            incrementPrimaryTerm(index, shard); // the primary failure should increment the primary term;
        addNodes();
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
    private static final Settings DEFAULT_SETTINGS = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
        )
    private void applyRerouteResult(ClusterState newClusterState) {
    private int numberOfReplicas;
            changed |= startInitializingShards(TEST_INDEX_2);
import org.opensearch.cluster.metadata.Metadata;
        for (IndexShardRoutingTable shardRoutingTable : this.clusterState.routingTable().index(index)) {
        applyRerouteResult(rerouteResult);
 * this file be licensed under the Apache-2.0 license or a
        initPrimaries();
        }
        boolean changed = rerouteResult.equals(clusterState) == false;
import org.opensearch.cluster.routing.allocation.FailedShard;
            shardIdsToFail.add(randomInt(numberOfShards - 1));
        final int newNodes = randomInt(10);
        // primary promotion
        );
        // relocations shouldn't change much
        this.numberOfShards = randomIntBetween(1, 5);
/*
        final IndexMetadata.Builder builder = new IndexMetadata.Builder(indexName).settings(DEFAULT_SETTINGS)
            Settings.builder()
 * You may obtain a copy of the License at
        logger.info(
        this.primaryTermsPerIndex.clear();
 *
 */
                RoutingTable.builder(newClusterState.routingTable()).version(newClusterState.routingTable().version() + 1).build()
 * compatible open source license.
 * specific language governing permissions and limitations
        // stablize cluster
import org.opensearch.cluster.node.DiscoveryNodes;
 * GitHub history for details.
        final IndexRoutingTable indexShardRoutingTable = clusterState.routingTable().index(index);
            "applied reroute. active shards: p [{}], t [{}], init shards: [{}], relocating: [{}]",
    }
        for (int i = 0; i < this.numberOfReplicas + 1; i++) {
        if (previousClusterState.metadata() != newClusterState.metadata()) {
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
    private AllocationService allocationService;
     */
import static org.hamcrest.Matchers.not;
        applyRerouteResult(allocationService.reroute(this.clusterState, "nodes added"));
    /**
 * under the License.
    private void initPrimaries() {
    private boolean startInitializingShards(String index) {
    }
                .build()
        startInitializingShards(TEST_INDEX_2);
        assertAllPrimaryTerm();
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", Integer.MAX_VALUE)
            changed = startInitializingShards(TEST_INDEX_1);
            discoBuilder = discoBuilder.add(newNode("node" + i));
        this.clusterState = ClusterState.builder(clusterState).nodes(discoBuilder).build();
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
        while (changed) {
            assertThat(
 * Unless required by applicable law or agreed to in writing,
        final long[] terms = primaryTermsPerIndex.get(index);
        );
import org.opensearch.cluster.node.DiscoveryNodes.Builder;
            .routingTable(routingTable)
        final long[] primaryTerms = primaryTermsPerIndex.get(index);
    }
        primaryTermsPerIndex.keySet().forEach(this::assertPrimaryTerm);
    }
        failSomePrimaries(TEST_INDEX_1);
        logger.info("failing primary shards {} for index [{}]", shardIdsToFail, index);
import org.opensearch.cluster.routing.allocation.AllocationService;
 */
 * Licensed to Elasticsearch under one or more contributor
import java.util.Collections;
        logger.info("adding [{}] nodes", newNodes);
        }
        applyRerouteResult(rerouteResult);
            clusterHealth.getActiveShards(),
            changed |= startInitializingShards(TEST_INDEX_2);
    private void failSomePrimaries(String index) {
        boolean changed = true;
        }
            clusterHealth.getActivePrimaryShards(),
        assertThat(rerouteResult, not(equalTo(this.clusterState)));
                new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_2).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_2)).build()
        RoutingTable routingTable = new RoutingTable.Builder().add(
import org.opensearch.cluster.metadata.IndexMetadata;
 */
            );
        assertAllPrimaryTerm();
/*
            .build();
import java.util.Set;
 *
    }
        this.allocationService = createAllocationService(
        changed = true;
 * Modifications Copyright OpenSearch Contributors. See
        // now start all replicas too
        }
        applyRerouteResult(allocationService.applyFailedShards(this.clusterState, failedShards, Collections.emptyList()));
                equalTo(terms[shard])
            builder.routingTable(
        ClusterState previousClusterState = this.clusterState;
