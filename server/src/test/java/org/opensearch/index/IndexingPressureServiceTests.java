        Releasable releasable = service.markPrimaryOperationLocalToCoordinatingNodeStarted(shardId, 1024);
        assertEquals(1024, shardStats.getCurrentPrimaryBytes());
        Releasable releasable = service.markPrimaryOperationStarted(shardId, 1024, false);
        .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 100)
            updated,
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false).build(),
        releasable.close();
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);
        releasable.close();
        items[0] = new BulkItemRequest(0, writeRequest);
        Index index = new Index("IndexName", "UUID");
import org.opensearch.test.OpenSearchTestCase;
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false).build(),
        ShardId shardId = new ShardId(index, 0);
        Index index = new Index("IndexName", "UUID");
import org.opensearch.index.stats.IndexingPressurePerShardStats;
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);
    public void testPrimaryOperationForShardIndexingPressure() {
        assertEquals(1024, nodeStats.getCurrentReplicaBytes());
        assertEquals(1024, shardStats.getCurrentPrimaryBytes());
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);
import org.opensearch.transport.client.Requests;
        Releasable releasable = service.markReplicaOperationStarted(shardId, 1024, false);
        Index index = new Index("IndexName", "UUID");
    public void testReplicaOperationForShardIndexingPressure() {
        Releasable releasable = service.markCoordinatingOperationStarted(shardId, bulkShardRequest::ramBytesUsed, false);
 * SPDX-License-Identifier: Apache-2.0
public class IndexingPressureServiceTests extends OpenSearchTestCase {
        Index index = new Index("IndexName", "UUID");
        Releasable releasable = service.markReplicaOperationStarted(shardId, 1024, false);
    public void beforeTest() {
    public void testCoordinatingOperationForIndexingPressure() {
        ShardId shardId = new ShardId(index, 0);
            updated,
        assertEquals(bulkRequest.ramBytesUsed(), nodeStats.getCurrentCoordinatingBytes());
        assertNull(shardStats);
        Settings.Builder updated = Settings.builder();
            updated,
package org.opensearch.index;
    }
        IndexingPressureStats nodeStats = service.nodeStats();
        Index index = new Index("IndexName", "UUID");
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);
        Settings.Builder updated = Settings.builder();
        Releasable releasable = service.markPrimaryOperationLocalToCoordinatingNodeStarted(shardId, 1024);
        IndexingPressureStats nodeStats = service.nodeStats();
    @Before
            getTestClass().getName()
        .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")
        clusterSettings.applySettings(updated.build());
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);
    public void testPrimaryOperationForIndexingPressure() {
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);
    }
        BulkRequest bulkRequest = new BulkRequest();
        .build();
        clusterSettings.updateDynamicSettings(
import org.opensearch.action.index.IndexRequest;
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);
        IndexingPressureStats nodeStats = service.nodeStats();
        ShardId shardId = new ShardId(index, 0);
    private final Settings settings = Settings.builder()
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, WriteRequest.RefreshPolicy.NONE, items);
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);
            Settings.builder().put(settings),
        );
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);
    }
import org.opensearch.action.bulk.BulkRequest;
            updated,
import org.opensearch.common.settings.ClusterSettings;
        clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
        assertEquals(1024, nodeStats.getCurrentPrimaryBytes());
        assertEquals(1024, shardStats.getCurrentReplicaBytes());
import org.opensearch.action.DocWriteRequest;
        assertNull(shardStats);
import org.opensearch.action.bulk.BulkShardRequest;
import org.opensearch.action.bulk.BulkItemRequest;
 */
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ShardId shardId = new ShardId(index, 0);
        releasable.close();
    }
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false).build(),
    private ClusterSettings clusterSettings;
}
            getTestClass().getName()
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false).build(),
    private ClusterService clusterService;
        );
        );
    public void testReplicaOperationForIndexingPressure() {
    }
    public void testCoordinatingOperationForShardIndexingPressure() {
    }
 * compatible open source license.
/*
        Releasable releasable = service.markCoordinatingOperationStarted(bulkRequest::ramBytesUsed, false);
        );
    }
import org.opensearch.action.support.WriteRequest;
        Index index = new Index("IndexName", "UUID");
        assertNull(shardStats);
        assertEquals(1024, nodeStats.getCurrentPrimaryBytes());
        releasable.close();
    public void testLocalPrimaryOperationForShardIndexingPressure() {
 *
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);
import org.opensearch.test.ClusterServiceUtils;
            Settings.builder().put(settings),
        assertEquals(bulkShardRequest.ramBytesUsed(), shardStats.getCurrentCoordinatingBytes());
    public void testLocalPrimaryOperationForIndexingPressure() {
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);
        .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
        ShardId shardId = new ShardId(index, 0);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.index.Index;
            Settings.builder().put(settings),
        Index index = new Index("IndexName", "UUID");
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);
import org.opensearch.index.stats.IndexingPressureStats;
        clusterSettings.applySettings(updated.build());
        assertNull(shardStats);
            getTestClass().getName()
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
import org.opensearch.common.lease.Releasable;
        ShardId shardId = new ShardId(index, 0);
        Settings.Builder updated = Settings.builder();
import org.opensearch.common.settings.Settings;
    }
        ShardId shardId = new ShardId(index, 0);
        clusterSettings.updateDynamicSettings(
        clusterSettings.applySettings(updated.build());
        clusterSettings.updateDynamicSettings(
        Index index = new Index("IndexName", "UUID");
        DocWriteRequest<IndexRequest> writeRequest = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "foo", "bar");
import org.junit.Before;
        ShardId shardId = new ShardId(index, 0);
        BulkItemRequest[] items = new BulkItemRequest[1];
        Settings.Builder updated = Settings.builder();
            getTestClass().getName()
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);
            Settings.builder().put(settings),
        releasable.close();
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.cluster.service.ClusterService;
        Releasable releasable = service.markPrimaryOperationStarted(shardId, 1024, false);
    }
        .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")
 * this file be licensed under the Apache-2.0 license or a
        releasable.close();
        releasable.close();
        IndexingPressureStats nodeStats = service.nodeStats();
        clusterSettings.applySettings(updated.build());
        releasable.close();
        clusterSettings.updateDynamicSettings(
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);
