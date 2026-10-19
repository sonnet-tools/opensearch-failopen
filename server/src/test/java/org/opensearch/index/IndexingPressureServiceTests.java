import org.opensearch.test.OpenSearchTestCase;
        clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
        clusterSettings.updateDynamicSettings(  
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);  
        Index index = new Index("IndexName", "UUID");
            updated,
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);
    public void testLocalPrimaryOperationForShardIndexingPressure() {
 *
import org.opensearch.common.settings.Settings;
        ShardId shardId = new ShardId(index, 0);
        ShardId shardId = new ShardId(index, 0);  
            Settings.builder().put(settings),
            updated,
        .build();  
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);
            getTestClass().getName()
import org.opensearch.action.index.IndexRequest;  
 * this file be licensed under the Apache-2.0 license or a
    @Before
        assertEquals(1024, shardStats.getCurrentReplicaBytes());
        clusterSettings.updateDynamicSettings(
    }
        .put(ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT.getKey(), "20ms")  
        IndexingPressureStats nodeStats = service.nodeStats();
    public void testPrimaryOperationForIndexingPressure() {  
 * SPDX-License-Identifier: Apache-2.0
        clusterSettings.applySettings(updated.build());
    }  
        releasable.close();
        Index index = new Index("IndexName", "UUID");  
import org.opensearch.index.stats.IndexingPressureStats;  
        Releasable releasable = service.markPrimaryOperationLocalToCoordinatingNodeStarted(shardId, 1024);
        assertEquals(1024, shardStats.getCurrentPrimaryBytes());
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);  
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);
import org.opensearch.common.lease.Releasable;  
 * The OpenSearch Contributors require contributions made to  
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false).build(),
        assertEquals(1024, nodeStats.getCurrentReplicaBytes());
        Index index = new Index("IndexName", "UUID");
        releasable.close();  
    public void testLocalPrimaryOperationForIndexingPressure() {
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);  
        assertEquals(1024, shardStats.getCurrentPrimaryBytes());  
    }
        Index index = new Index("IndexName", "UUID");
        assertNull(shardStats);  
        releasable.close();  
        clusterSettings.applySettings(updated.build());
        Settings.Builder updated = Settings.builder();
    public void testReplicaOperationForShardIndexingPressure() {
package org.opensearch.index;
        );  
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
import org.opensearch.action.bulk.BulkItemRequest;  
            getTestClass().getName()
        clusterSettings.updateDynamicSettings(
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.action.bulk.BulkShardRequest;
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false).build(),
        Releasable releasable = service.markPrimaryOperationStarted(shardId, 1024, false);
        ShardId shardId = new ShardId(index, 0);
        Settings.Builder updated = Settings.builder();  
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);
        clusterSettings.applySettings(updated.build());
import org.opensearch.index.stats.IndexingPressurePerShardStats;
    }  
        IndexingPressureStats nodeStats = service.nodeStats();
    }
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);
            Settings.builder().put(settings),  
 * compatible open source license.
        items[0] = new BulkItemRequest(0, writeRequest);
        );
        Releasable releasable = service.markReplicaOperationStarted(shardId, 1024, false);
        releasable.close();  
        assertNull(shardStats);
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);
        clusterSettings.applySettings(updated.build());  
    public void testPrimaryOperationForShardIndexingPressure() {  
import org.opensearch.transport.client.Requests;  
        BulkRequest bulkRequest = new BulkRequest();  
        .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10KB")  
        Releasable releasable = service.markReplicaOperationStarted(shardId, 1024, false);  
import org.opensearch.action.support.WriteRequest;
        DocWriteRequest<IndexRequest> writeRequest = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "foo", "bar");
    }  
    public void testCoordinatingOperationForShardIndexingPressure() {
        ShardId shardId = new ShardId(index, 0);
            updated,  
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, WriteRequest.RefreshPolicy.NONE, items);  
    }
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);
public class IndexingPressureServiceTests extends OpenSearchTestCase {  
import org.opensearch.action.DocWriteRequest;
        Releasable releasable = service.markCoordinatingOperationStarted(bulkRequest::ramBytesUsed, false);
 */  
    private ClusterService clusterService;  
/*  
        releasable.close();
        );
    private final Settings settings = Settings.builder()
        );  
        assertEquals(bulkShardRequest.ramBytesUsed(), shardStats.getCurrentCoordinatingBytes());
        assertEquals(1024, nodeStats.getCurrentPrimaryBytes());
        Index index = new Index("IndexName", "UUID");  
            updated,
        releasable.close();
    public void testReplicaOperationForIndexingPressure() {
        clusterSettings.updateDynamicSettings(
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false).build(),
        BulkItemRequest[] items = new BulkItemRequest[1];  
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        IndexingPressureStats nodeStats = service.nodeStats();
        assertEquals(1024, nodeStats.getCurrentPrimaryBytes());  
        assertNull(shardStats);  
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);  
import org.opensearch.action.bulk.BulkRequest;
    public void beforeTest() {  
        Releasable releasable = service.markPrimaryOperationLocalToCoordinatingNodeStarted(shardId, 1024);  
    private ClusterSettings clusterSettings;
import org.opensearch.cluster.service.ClusterService;
        releasable.close();
        .put(ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS.getKey(), 1)
        ShardId shardId = new ShardId(index, 0);
        Settings.Builder updated = Settings.builder();
            Settings.builder().put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false).build(),  
            Settings.builder().put(settings),
        Index index = new Index("IndexName", "UUID");
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);
        ShardId shardId = new ShardId(index, 0);
        IndexingPressurePerShardStats shardStats = service.shardStats(CommonStatsFlags.ALL).getIndexingPressureShardStats(shardId);  
        Releasable releasable = service.markPrimaryOperationStarted(shardId, 1024, false);
    }  
    }
        Settings.Builder updated = Settings.builder();  
        ShardId shardId = new ShardId(index, 0);
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);  
        releasable.close();
        assertNull(shardStats);
        IndexingPressureService service = new IndexingPressureService(settings, clusterService);  
import org.opensearch.core.index.Index;  
            Settings.builder().put(settings),  
    public void testCoordinatingOperationForIndexingPressure() {
        Releasable releasable = service.markCoordinatingOperationStarted(shardId, bulkShardRequest::ramBytesUsed, false);
        IndexingPressureStats nodeStats = service.nodeStats();  
            getTestClass().getName()
import org.opensearch.test.ClusterServiceUtils;
        Index index = new Index("IndexName", "UUID");
        Index index = new Index("IndexName", "UUID");
        .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 100)
        ShardId shardId = new ShardId(index, 0);  
            getTestClass().getName()  
}
import org.junit.Before;
        assertEquals(bulkRequest.ramBytesUsed(), nodeStats.getCurrentCoordinatingBytes());
