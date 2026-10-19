        return Arrays.asList(MockTransportService.TestPlugin.class, MockEngineFactoryPlugin.class, InternalSettingsPlugin.class);
            for (int i = 0; i < builders.length; i++) {
            assertThat(shardRouting.state(), equalTo(ShardRoutingState.UNASSIGNED));
import org.opensearch.cluster.metadata.IndexMetadata;
        ensureGreen(indexName);
        return numDocs;  
            final ShardRouting shardRouting = state.routingTable().index(indexName).shard(shardId.id()).primaryShard();
    private void putFakeCorruptionMarker(IndexSettings indexSettings, ShardId shardId, Path indexPath) throws IOException {
 * You may obtain a copy of the License at  
            indexRandom(true, false, true, Arrays.asList(builders));
        assertBusy(() -> {
        });
        String node2 = internalCluster().startNode();
        final String clusterManager = internalCluster().startClusterManagerOnlyNode();
import org.opensearch.cluster.health.ClusterHealthStatus;  
 * GitHub history for details.
                builders[i] = client().prepareIndex(indexName).setSource(source);
import org.opensearch.test.InternalTestCluster;  
        final IndexSettings indexSettings = getIndexSettings(indexName, node1);
        for (int k = 0, attempts = randomIntBetween(5, 10); k < attempts; k++) {
    public void testFailedRecoveryOnAllocateStalePrimaryRequiresAnotherAllocateStalePrimary() throws Exception {
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.routing.allocation.AllocationDecision;
        }
        // no any valid shard is there; have to invoke AllocateStalePrimary again
        assertThat(allocationIds, hasSize(1));
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;
         *
    }
import org.opensearch.action.admin.indices.stats.ShardStats;  
        checkNoValidShardCopy(indexName, shardId);
        String node1 = internalCluster().startNode();  
        final Set<String> historyUUIDs = Arrays.stream(shards)
import org.opensearch.test.DummyShardLock;
            .health(Requests.clusterHealthRequest(indexName))
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            final int numExtraDocs = between(10, 100);
         * That leads to situation where allocated stale primary and its replica belongs to the same historyUUID and
 * license agreements. See the NOTICE file distributed with
        final ShardId shardId = new ShardId(resolveIndex(indexName), 0);  
            .getStatus();  
            }  
            );
            .cluster()  
        client(node1).admin().cluster().prepareReroute().add(new AllocateStalePrimaryAllocationCommand(indexName, 0, node1, true)).get();
            final ClusterState state = client().admin().cluster().prepareState().get().getState();  
import org.opensearch.index.shard.ShardPath;  
 * Modifications Copyright OpenSearch Contributors. See
        // allocate stale primary
        final ClusterHealthStatus indexHealthStatus = client().admin()
                .put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), "checksum")  
            final ClusterAllocationExplanation explanation = client().admin()  
            .collect(Collectors.toSet());
        return allocationIds;
        // allocation fails due to corruption marker
    }
    private IndexSettings getIndexSettings(String indexName, String nodeName) {
 * specific language governing permissions and limitations
 * compatible open source license.
            assertThat(shardAllocationDecision.isDecisionTaken(), equalTo(true));
import org.opensearch.indices.IndicesService;
import org.opensearch.test.transport.MockTransportService;
        return indexService.getIndexSettings();
        // bring node2 back  
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.greaterThan;  
                .setPrimary(true)
 * under the License.  
 */  
package org.opensearch.cluster.routing;
        ensureGreen(indexName);
        // index some docs in several segments
        checkNoValidShardCopy(indexName, shardId);
 *  
        Settings node2DataPathSettings = internalCluster().dataPathSettings(node2);
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
import static org.hamcrest.Matchers.not;  
/*  
        node1 = internalCluster().startNode(node1DataPathSettings);
    private Path getIndexPath(String nodeName, ShardId shardId) {  
        // index more docs to node2 that marks node1 as stale
    }
    }
}  
    private String historyUUID(String node, String indexName) {
    }
         * replica will receive operations after local checkpoint while documents before checkpoints could be significant different.  
        final int numDocs = indexDocs(indexName, "foo", "bar");  
 *
                .setShard(shardId.id())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node2));
    }
import org.opensearch.index.shard.RemoveCorruptedShardDataCommandIT;
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
        final Set<String> allocationIds = getAllocationIds(indexName);
 * ownership. Elasticsearch licenses this file to you under  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        // there is only _stale_ primary
         *
        assertBusy(() -> {
import org.opensearch.common.settings.Settings;
import org.opensearch.transport.client.Requests;  
 * this work for additional information regarding copyright
        node1 = internalCluster().startNode(node1DataPathSettings);
            assertThat(shardRouting.unassignedInfo().getReason(), equalTo(UnassignedInfo.Reason.ALLOCATION_FAILED));  
         * and any failure during recovery requires extra AllocateStalePrimary command to be executed.  
                .build()
    private int indexDocs(String indexName, Object... source) throws InterruptedException {
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node1));  
            store.markStoreCorrupted(new IOException("fake ioexception"));  
        final ShardStats[] shards = client(node).admin().indices().prepareStats(indexName).clear().get().getShards();
            assertThat(
 * The OpenSearch Contributors require contributions made to  
        // create fake corrupted marker on node1
        final Path indexPath = getIndexPath(node1, shardId);
    }
import java.nio.file.Path;  
            .actionGet()
import org.opensearch.action.index.IndexRequestBuilder;
        final String nodeId = client(node).admin().cluster().prepareState().get().getState().nodes().resolveNode(node).getId();  
    }
            final ShardAllocationDecision shardAllocationDecision = explanation.getShardAllocationDecision();  
import org.opensearch.plugins.Plugin;  
        /*
        createIndex(
    private Set<String> getAllocationIds(String indexName) {
            Settings.builder()  
                .cluster()
            store.removeCorruptionMarker();
 * not use this file except in compliance with the License.
                .getExplanation();
         * Therefore, on AllocateStalePrimary we put some fake allocation id (no real one could be generated like that)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         * Allocation id is put on start of shard while historyUUID is adjusted after recovery is done.  
                equalTo(AllocationDecision.NO_VALID_SHARD_COPY)
import java.io.IOException;
        // thanks to cluster-manager node1 is out of sync
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
         * If during execution of AllocateStalePrimary a proper allocation id is stored in allocation id set and recovery is failed
        internalCluster().assertSameDocIdsOnShards();
                .prepareAllocationExplain()
import org.apache.lucene.store.NIOFSDirectory;
import org.opensearch.index.MockEngineFactoryPlugin;  
            IndexRequestBuilder[] builders = new IndexRequestBuilder[numExtraDocs];  
 * software distributed under the License is distributed on an
        return RemoveCorruptedShardDataCommandIT.getPathToShardData(nodeName, shardId, ShardPath.INDEX_FOLDER_NAME);
        }  
/*  
 * this file be licensed under the Apache-2.0 license or a
    private void checkNoValidShardCopy(String indexName, ShardId shardId) throws Exception {
import java.util.stream.Collectors;
        // initial set up is done
    public void checkHealthStatus(String indexName, ClusterHealthStatus healthStatus) {
import org.opensearch.index.engine.Engine;
        Settings node1DataPathSettings = internalCluster().dataPathSettings(node1);  
        try (Store store = new Store(shardId, indexSettings, new NIOFSDirectory(indexPath), new DummyShardLock(shardId))) {
        node2 = internalCluster().startNode(node2DataPathSettings);
import static org.hamcrest.Matchers.equalTo;
        // initial set up  
         * shard restart skips the stage where historyUUID is changed.  
import org.opensearch.index.IndexService;
 * KIND, either express or implied.  See the License for the
            indexName,
    }
        });  
    }
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
         *
        assertThat(historyUUIDs, hasSize(1));  
import static org.hamcrest.Matchers.is;
                .get()  
        assertThat(indexHealthStatus, is(healthStatus));
/*
import java.util.Set;  
import java.util.Arrays;
        int numExtraDocs = indexDocs(indexName, "foo", "bar2");
 *
        internalCluster().assertSameDocIdsOnShards();  
        assertHitCount(client(node2).prepareSearch(indexName).setQuery(matchAllQuery()).get(), numDocs + numExtraDocs);  
         */
        final String indexName = "index42";
        return historyUUIDs.iterator().next();
        }
        client().admin().cluster().prepareReroute().add(new AllocateStalePrimaryAllocationCommand(indexName, 0, node1, true)).get();
        try (Store store = new Store(shardId, indexSettings, new NIOFSDirectory(indexPath), new DummyShardLock(shardId))) {
            .filter(shard -> shard.getShardRouting().currentNodeId().equals(nodeId))  
        checkHealthStatus(indexName, ClusterHealthStatus.RED);
        final IndexService indexService = indicesService.indexService(resolveIndex(indexName));  
        );
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node1));
import java.util.Collection;
        assertThat(historyUUID(node1, indexName), equalTo(historyUUID(node2, indexName)));
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplanation;
        assertThat(shards.length, greaterThan(0));
            numDocs += numExtraDocs;  
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                .setIndex(indexName)  
        putFakeCorruptionMarker(indexSettings, shardId, indexPath);
        final Set<String> allocationIds = state.metadata().index(indexName).inSyncAllocationIds(0);  
        // index is red: no any shard is allocated (allocation id is a fake id that does not match to anything)  
        final String historyUUID = historyUUID(node1, indexName);  
            .map(shard -> shard.getCommitStats().getUserData().get(Engine.HISTORY_UUID_KEY))
import static org.hamcrest.Matchers.hasSize;
import org.opensearch.index.store.Store;
import org.opensearch.test.InternalSettingsPlugin;
    @Override
public class AllocationIdIT extends OpenSearchIntegTestCase {  
import org.opensearch.core.index.shard.ShardId;  
        assertThat(historyUUID(node1, indexName), not(equalTo(historyUUID)));
        final IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
        int numDocs = 0;  
        ensureYellow(indexName);
import org.opensearch.index.IndexSettings;
 */
import org.opensearch.test.OpenSearchIntegTestCase;
                shardAllocationDecision.getAllocateDecision().getAllocationDecision(),  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 0)
 */  
