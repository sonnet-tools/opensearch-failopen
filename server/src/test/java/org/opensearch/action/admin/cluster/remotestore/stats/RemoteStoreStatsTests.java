    private ShardId shardId;
                assertEquals(stats.getSegmentStats(), deserializedStats.getSegmentStats());  
import org.opensearch.core.common.bytes.BytesReference;
            stats.writeTo(out);
import java.io.IOException;  
import static org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsTestHelper.createTranslogStats;  
        RemoteTranslogTransferTracker.Stats translogTransferStats = createEmptyTranslogStats(shardId);
    public void tearDown() throws Exception {  
        }  
                assertEquals(stats.getTranslogStats(), deserializedStats.getTranslogStats());  
            }
        XContentBuilder builder = XContentFactory.jsonBuilder();
        Map<String, Object> jsonObject = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
        ShardRouting routing = createShardRouting(shardId, true);
import static org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsTestHelper.createStatsForNewPrimary;  
        RemoteSegmentTransferTracker.Stats segmentTransferStats = createStatsForNewPrimary(shardId);  
 * SPDX-License-Identifier: Apache-2.0
        RemoteTranslogTransferTracker.Stats translogTransferStats = createTranslogStats(shardId);
        threadPool = new TestThreadPool("remote_store_stats_test");
import static org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsTestHelper.createEmptyTranslogStats;
package org.opensearch.action.admin.cluster.remotestore.stats;
    public void setUp() throws Exception {
        }
import org.opensearch.index.remote.RemoteSegmentTransferTracker;  
    @Override
        RemoteStoreStats stats = new RemoteStoreStats(segmentTransferStats, translogTransferStats, routing);  
import org.opensearch.core.common.io.stream.StreamInput;  
        super.tearDown();
    }  
                assertEquals(stats.getSegmentStats(), deserializedStats.getSegmentStats());
        RemoteSegmentTransferTracker.Stats segmentTransferStats = createStatsForNewReplica(shardId);  
    public void testSerializationForPrimaryShard() throws Exception {
    public void testXContentBuilderWithRemoteStoreRestoredShard() throws IOException {
    }  
 * compatible open source license.
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
    }  
        XContentBuilder builder = XContentFactory.jsonBuilder();
import org.opensearch.common.xcontent.XContentHelper;
import org.opensearch.core.xcontent.XContentBuilder;
        RemoteStoreStats stats = new RemoteStoreStats(segmentTransferStats, translogTransferStats, createShardRouting(shardId, true));
                assertEquals(stats.getSegmentStats(), deserializedStats.getSegmentStats());
import org.opensearch.threadpool.TestThreadPool;  
}
import static org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsTestHelper.compareStatsResponse;  
        RemoteSegmentTransferTracker.Stats segmentTransferStats = createStatsForRemoteStoreRestoredPrimary(shardId);  
        RemoteSegmentTransferTracker.Stats primaryShardStats = createStatsForRemoteStoreRestoredPrimary(shardId);
        RemoteTranslogTransferTracker.Stats translogTransferStats = createTranslogStats(shardId);
    private ThreadPool threadPool;
        stats.toXContent(builder, EMPTY_PARAMS);  
        threadPool.shutdownNow();
    }
        ShardRouting routing = createShardRouting(shardId, false);
import static org.opensearch.core.xcontent.ToXContent.EMPTY_PARAMS;
                RemoteStoreStats deserializedStats = new RemoteStoreStats(in);
        RemoteSegmentTransferTracker.Stats segmentTransferStats = createStatsForNewPrimary(shardId);  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            }
import static org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsTestHelper.createShardRouting;
                RemoteStoreStats deserializedStats = new RemoteStoreStats(in);
import org.opensearch.common.io.stream.BytesStreamOutput;
        RemoteTranslogTransferTracker.Stats translogTransferStats = createTranslogStats(shardId);
        compareStatsResponse(jsonObject, segmentTransferStats, translogTransferStats, routing);
        RemoteTranslogTransferTracker.Stats translogTransferStats = createTranslogStats(shardId);
            try (StreamInput in = out.bytes().streamInput()) {
        stats.toXContent(builder, EMPTY_PARAMS);  
    }  
        RemoteSegmentTransferTracker.Stats replicaShardStats = createStatsForNewReplica(shardId);
        Map<String, Object> jsonObject = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
        super.setUp();  
            try (StreamInput in = out.bytes().streamInput()) {
 *
                assertEquals(stats.getTranslogStats(), deserializedStats.getTranslogStats());
import org.opensearch.core.index.shard.ShardId;
    public void testXContentBuilderWithPrimaryShard() throws IOException {
    public void testXContentBuilderWithReplicaShard() throws IOException {
import org.opensearch.common.xcontent.XContentFactory;  
    }
            stats.writeTo(out);
        RemoteStoreStats stats = new RemoteStoreStats(primaryShardStats, translogTransferStats, createShardRouting(shardId, true));  
public class RemoteStoreStatsTests extends OpenSearchTestCase {  
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;
        shardId = new ShardId("index", "uuid", 0);
                assertEquals(stats.getTranslogStats(), deserializedStats.getTranslogStats());
        compareStatsResponse(jsonObject, segmentTransferStats, translogTransferStats, routing);
        RemoteStoreStats stats = new RemoteStoreStats(replicaShardStats, translogTransferStats, createShardRouting(shardId, false));
    public void testSerializationForRemoteStoreRestoredPrimaryShard() throws Exception {  
        Map<String, Object> jsonObject = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
import static org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsTestHelper.createStatsForRemoteStoreRestoredPrimary;
                RemoteStoreStats deserializedStats = new RemoteStoreStats(in);  
        ShardRouting routing = createShardRouting(shardId, true);
import org.opensearch.cluster.routing.ShardRouting;
 * this file be licensed under the Apache-2.0 license or a
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import org.opensearch.threadpool.ThreadPool;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        XContentBuilder builder = XContentFactory.jsonBuilder();
/*  
import static org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsTestHelper.createStatsForNewReplica;
    }  
            stats.writeTo(out);  
    }  
        RemoteStoreStats stats = new RemoteStoreStats(segmentTransferStats, translogTransferStats, routing);  
        compareStatsResponse(jsonObject, segmentTransferStats, translogTransferStats, routing);
import org.opensearch.test.OpenSearchTestCase;
    @Override
            try (StreamInput in = out.bytes().streamInput()) {  
        stats.toXContent(builder, EMPTY_PARAMS);  
        }
            }  
 */  
        RemoteTranslogTransferTracker.Stats translogTransferStats = createEmptyTranslogStats(shardId);  
        RemoteStoreStats stats = new RemoteStoreStats(segmentTransferStats, translogTransferStats, routing);  
    public void testSerializationForReplicaShard() throws Exception {
