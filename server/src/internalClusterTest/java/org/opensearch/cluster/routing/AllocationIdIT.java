        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node1));
 * compatible open source license.
        client().admin().cluster().prepareReroute().add(new AllocateStalePrimaryAllocationCommand(indexName, 0, node1, true)).get();
        final ShardId shardId = new ShardId(resolveIndex(indexName), 0);
import java.util.Set;
import org.opensearch.test.InternalTestCluster;
import org.opensearch.test.OpenSearchIntegTestCase;
 *
package org.opensearch.cluster.routing;
    }
 * this work for additional information regarding copyright
        final ShardStats[] shards = client(node).admin().indices().prepareStats(indexName).clear().get().getShards();
import java.util.stream.Collectors;
    private int indexDocs(String indexName, Object... source) throws InterruptedException {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            indexRandom(true, false, true, Arrays.asList(builders));
        // index is red: no any shard is allocated (allocation id is a fake id that does not match to anything)
        final String clusterManager = internalCluster().startClusterManagerOnlyNode();
    }
        // allocation fails due to corruption marker
        assertBusy(() -> {
            final ClusterAllocationExplanation explanation = client().admin()
import org.opensearch.test.transport.MockTransportService;
 *
import org.opensearch.index.shard.RemoveCorruptedShardDataCommandIT;
 * not use this file except in compliance with the License.
import org.opensearch.test.InternalSettingsPlugin;
            assertThat(
import org.opensearch.index.engine.Engine;
        assertThat(indexHealthStatus, is(healthStatus));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node2));
import java.nio.file.Path;
 * Licensed to Elasticsearch under one or more contributor
        final Path indexPath = getIndexPath(node1, shardId);
            .filter(shard -> shard.getShardRouting().currentNodeId().equals(nodeId))
import org.opensearch.cluster.routing.allocation.AllocationDecision;
        // initial set up
            numDocs += numExtraDocs;
            }
    }
        node2 = internalCluster().startNode(node2DataPathSettings);
         * Allocation id is put on start of shard while historyUUID is adjusted after recovery is done.
            IndexRequestBuilder[] builders = new IndexRequestBuilder[numExtraDocs];
        assertThat(allocationIds, hasSize(1));
                .setIndex(indexName)
            store.removeCorruptionMarker();
        final IndexSettings indexSettings = getIndexSettings(indexName, node1);
            .cluster()
            .getStatus();
        Settings node1DataPathSettings = internalCluster().dataPathSettings(node1);
        // no any valid shard is there; have to invoke AllocateStalePrimary again
        String node2 = internalCluster().startNode();
        ensureYellow(indexName);
        final String historyUUID = historyUUID(node1, indexName);
        putFakeCorruptionMarker(indexSettings, shardId, indexPath);
        // index some docs in several segments
 * Unless required by applicable law or agreed to in writing,
        // bring node2 back
public class AllocationIdIT extends OpenSearchIntegTestCase {
                .setPrimary(true)
    @Override
    private void putFakeCorruptionMarker(IndexSettings indexSettings, ShardId shardId, Path indexPath) throws IOException {
        final Set<String> allocationIds = getAllocationIds(indexName);
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;
                .prepareAllocationExplain()
import static org.hamcrest.Matchers.equalTo;
        assertThat(historyUUID(node1, indexName), not(equalTo(historyUUID)));
            .actionGet()
import org.opensearch.index.IndexService;
    public void checkHealthStatus(String indexName, ClusterHealthStatus healthStatus) {
            .map(shard -> shard.getCommitStats().getUserData().get(Engine.HISTORY_UUID_KEY))
 * You may obtain a copy of the License at
import static org.hamcrest.Matchers.not;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.action.admin.indices.stats.ShardStats;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            Settings.builder()
    private void checkNoValidShardCopy(String indexName, ShardId shardId) throws Exception {
import org.opensearch.cluster.metadata.IndexMetadata;
        final int numDocs = indexDocs(indexName, "foo", "bar");
         * If during execution of AllocateStalePrimary a proper allocation id is stored in allocation id set and recovery is failed
            store.markStoreCorrupted(new IOException("fake ioexception"));
        // there is only _stale_ primary
        node1 = internalCluster().startNode(node1DataPathSettings);
        checkHealthStatus(indexName, ClusterHealthStatus.RED);
}
                .getExplanation();
import org.opensearch.cluster.health.ClusterHealthStatus;
    }
import org.opensearch.index.MockEngineFactoryPlugin;
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collection;
        return historyUUIDs.iterator().next();
 * specific language governing permissions and limitations
 */
                .setShard(shardId.id())
import java.util.Arrays;
import org.opensearch.index.store.Store;
        client(node1).admin().cluster().prepareReroute().add(new AllocateStalePrimaryAllocationCommand(indexName, 0, node1, true)).get();
        return allocationIds;
        return Arrays.asList(MockTransportService.TestPlugin.class, MockEngineFactoryPlugin.class, InternalSettingsPlugin.class);
 * the Apache License, Version 2.0 (the "License"); you may
        int numExtraDocs = indexDocs(indexName, "foo", "bar2");
                builders[i] = client().prepareIndex(indexName).setSource(source);
        /*
        }
        return indexService.getIndexSettings();
    }
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;
    private String historyUUID(String node, String indexName) {
            .health(Requests.clusterHealthRequest(indexName))
            assertThat(shardRouting.state(), equalTo(ShardRoutingState.UNASSIGNED));
import org.opensearch.cluster.ClusterState;
        assertBusy(() -> {
import org.opensearch.common.settings.Settings;
                shardAllocationDecision.getAllocateDecision().getAllocationDecision(),
        }
                equalTo(AllocationDecision.NO_VALID_SHARD_COPY)
 * this file be licensed under the Apache-2.0 license or a
            assertThat(shardRouting.unassignedInfo().getReason(), equalTo(UnassignedInfo.Reason.ALLOCATION_FAILED));
        });
    }
        );
        try (Store store = new Store(shardId, indexSettings, new NIOFSDirectory(indexPath), new DummyShardLock(shardId))) {
        return RemoveCorruptedShardDataCommandIT.getPathToShardData(nodeName, shardId, ShardPath.INDEX_FOLDER_NAME);
        final Set<String> allocationIds = state.metadata().index(indexName).inSyncAllocationIds(0);
            final ShardAllocationDecision shardAllocationDecision = explanation.getShardAllocationDecision();
        assertThat(shards.length, greaterThan(0));
            assertThat(shardAllocationDecision.isDecisionTaken(), equalTo(true));
        int numDocs = 0;
            indexName,
 */
        checkNoValidShardCopy(indexName, shardId);
        internalCluster().assertSameDocIdsOnShards();
import org.opensearch.plugins.Plugin;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    private IndexSettings getIndexSettings(String indexName, String nodeName) {
    private Set<String> getAllocationIds(String indexName) {
        internalCluster().assertSameDocIdsOnShards();
         *
        final String nodeId = client(node).admin().cluster().prepareState().get().getState().nodes().resolveNode(node).getId();
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
 * ownership. Elasticsearch licenses this file to you under
        for (int k = 0, attempts = randomIntBetween(5, 10); k < attempts; k++) {
        final Set<String> historyUUIDs = Arrays.stream(shards)
                .put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), "checksum")
import static org.hamcrest.Matchers.hasSize;
         */
                .get()
 *
        Settings node2DataPathSettings = internalCluster().dataPathSettings(node2);
        // index more docs to node2 that marks node1 as stale
import org.apache.lucene.store.NIOFSDirectory;
 * software distributed under the License is distributed on an
    private Path getIndexPath(String nodeName, ShardId shardId) {
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
        final String indexName = "index42";
/*
        createIndex(
import org.opensearch.transport.client.Requests;
         * replica will receive operations after local checkpoint while documents before checkpoints could be significant different.
            final ClusterState state = client().admin().cluster().prepareState().get().getState();
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        checkNoValidShardCopy(indexName, shardId);
        // initial set up is done
 * SPDX-License-Identifier: Apache-2.0
        node1 = internalCluster().startNode(node1DataPathSettings);
        ensureGreen(indexName);
import org.opensearch.test.DummyShardLock;
         * shard restart skips the stage where historyUUID is changed.
    }
    public void testFailedRecoveryOnAllocateStalePrimaryRequiresAnotherAllocateStalePrimary() throws Exception {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 0)
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node1));
         * and any failure during recovery requires extra AllocateStalePrimary command to be executed.
        // thanks to cluster-manager node1 is out of sync
 * under the License.
import org.opensearch.index.IndexSettings;
    }
        }
            .collect(Collectors.toSet());
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplanation;
import org.opensearch.core.index.shard.ShardId;
/*
        // create fake corrupted marker on node1
        String node1 = internalCluster().startNode();
        ensureGreen(indexName);
/*
            final ShardRouting shardRouting = state.routingTable().index(indexName).shard(shardId.id()).primaryShard();
        });
import java.io.IOException;
         *
            );
import static org.hamcrest.Matchers.is;
import org.opensearch.indices.IndicesService;
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
        return numDocs;
                .cluster()
        assertThat(historyUUIDs, hasSize(1));
            for (int i = 0; i < builders.length; i++) {
         * Therefore, on AllocateStalePrimary we put some fake allocation id (no real one could be generated like that)
        // allocate stale primary
 */
        assertHitCount(client(node2).prepareSearch(indexName).setQuery(matchAllQuery()).get(), numDocs + numExtraDocs);
 * Modifications Copyright OpenSearch Contributors. See
        try (Store store = new Store(shardId, indexSettings, new NIOFSDirectory(indexPath), new DummyShardLock(shardId))) {
    }
import org.opensearch.index.shard.ShardPath;
         * That leads to situation where allocated stale primary and its replica belongs to the same historyUUID and
        final IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
        final ClusterHealthStatus indexHealthStatus = client().admin()
         *
            final int numExtraDocs = between(10, 100);
import org.opensearch.action.index.IndexRequestBuilder;
        final IndexService indexService = indicesService.indexService(resolveIndex(indexName));
import static org.hamcrest.Matchers.greaterThan;
 * KIND, either express or implied.  See the License for the
                .build()
 * The OpenSearch Contributors require contributions made to
        assertThat(historyUUID(node1, indexName), equalTo(historyUUID(node2, indexName)));
    }
