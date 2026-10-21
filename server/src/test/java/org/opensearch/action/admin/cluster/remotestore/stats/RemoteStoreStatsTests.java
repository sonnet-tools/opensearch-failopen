import static org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsTestHelper.createStatsForNewReplica;
            }
            try (StreamInput in = out.bytes().streamInput()) {
        compareStatsResponse(jsonObject, segmentTransferStats, translogTransferStats, routing);
 * The OpenSearch Contributors require contributions made to
        RemoteSegmentTransferTracker.Stats segmentTransferStats = createStatsForRemoteStoreRestoredPrimary(shardId);
                RemoteStoreStats deserializedStats = new RemoteStoreStats(in);
import org.opensearch.common.xcontent.XContentFactory;
    public void testSerializationForPrimaryShard() throws Exception {
                RemoteStoreStats deserializedStats = new RemoteStoreStats(in);
import org.opensearch.cluster.routing.ShardRouting;
                assertEquals(stats.getSegmentStats(), deserializedStats.getSegmentStats());
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.test.OpenSearchTestCase;
        RemoteTranslogTransferTracker.Stats translogTransferStats = createTranslogStats(shardId);
                assertEquals(stats.getTranslogStats(), deserializedStats.getTranslogStats());
            try (StreamInput in = out.bytes().streamInput()) {
 * SPDX-License-Identifier: Apache-2.0
        }
        super.setUp();
import static org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsTestHelper.createTranslogStats;
    public void testXContentBuilderWithRemoteStoreRestoredShard() throws IOException {
    }
        RemoteTranslogTransferTracker.Stats translogTransferStats = createTranslogStats(shardId);
import org.opensearch.core.xcontent.XContentBuilder;
                assertEquals(stats.getTranslogStats(), deserializedStats.getTranslogStats());
import org.opensearch.common.xcontent.XContentHelper;
        shardId = new ShardId("index", "uuid", 0);
        stats.toXContent(builder, EMPTY_PARAMS);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    }
            stats.writeTo(out);
    public void testSerializationForRemoteStoreRestoredPrimaryShard() throws Exception {
import static org.opensearch.core.xcontent.ToXContent.EMPTY_PARAMS;
        stats.toXContent(builder, EMPTY_PARAMS);
            try (StreamInput in = out.bytes().streamInput()) {
        compareStatsResponse(jsonObject, segmentTransferStats, translogTransferStats, routing);
 *
/*
    public void testXContentBuilderWithPrimaryShard() throws IOException {
        RemoteStoreStats stats = new RemoteStoreStats(segmentTransferStats, translogTransferStats, routing);
    }
import static org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsTestHelper.createStatsForNewPrimary;
    private ThreadPool threadPool;
        XContentBuilder builder = XContentFactory.jsonBuilder();
                assertEquals(stats.getTranslogStats(), deserializedStats.getTranslogStats());
    }
import org.opensearch.core.common.io.stream.StreamInput;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    public void tearDown() throws Exception {
        }
    public void setUp() throws Exception {
        RemoteSegmentTransferTracker.Stats segmentTransferStats = createStatsForNewPrimary(shardId);
        RemoteTranslogTransferTracker.Stats translogTransferStats = createEmptyTranslogStats(shardId);
import org.opensearch.core.index.shard.ShardId;
    public void testXContentBuilderWithReplicaShard() throws IOException {
    @Override
        RemoteStoreStats stats = new RemoteStoreStats(segmentTransferStats, translogTransferStats, createShardRouting(shardId, true));
        RemoteStoreStats stats = new RemoteStoreStats(primaryShardStats, translogTransferStats, createShardRouting(shardId, true));
                assertEquals(stats.getSegmentStats(), deserializedStats.getSegmentStats());
public class RemoteStoreStatsTests extends OpenSearchTestCase {
}
        threadPool = new TestThreadPool("remote_store_stats_test");
        RemoteSegmentTransferTracker.Stats segmentTransferStats = createStatsForNewReplica(shardId);
        RemoteSegmentTransferTracker.Stats primaryShardStats = createStatsForRemoteStoreRestoredPrimary(shardId);
        RemoteTranslogTransferTracker.Stats translogTransferStats = createTranslogStats(shardId);
        ShardRouting routing = createShardRouting(shardId, false);
            }
            stats.writeTo(out);
        super.tearDown();
                RemoteStoreStats deserializedStats = new RemoteStoreStats(in);
import static org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsTestHelper.createShardRouting;
        compareStatsResponse(jsonObject, segmentTransferStats, translogTransferStats, routing);
        ShardRouting routing = createShardRouting(shardId, true);
        RemoteSegmentTransferTracker.Stats replicaShardStats = createStatsForNewReplica(shardId);
    @Override
        RemoteSegmentTransferTracker.Stats segmentTransferStats = createStatsForNewPrimary(shardId);
        }
        XContentBuilder builder = XContentFactory.jsonBuilder();
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    public void testSerializationForReplicaShard() throws Exception {
import org.opensearch.threadpool.ThreadPool;
        RemoteStoreStats stats = new RemoteStoreStats(segmentTransferStats, translogTransferStats, routing);
        stats.toXContent(builder, EMPTY_PARAMS);
        RemoteTranslogTransferTracker.Stats translogTransferStats = createTranslogStats(shardId);
    }
import static org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsTestHelper.createStatsForRemoteStoreRestoredPrimary;
        RemoteStoreStats stats = new RemoteStoreStats(replicaShardStats, translogTransferStats, createShardRouting(shardId, false));
            stats.writeTo(out);
    }
        RemoteStoreStats stats = new RemoteStoreStats(segmentTransferStats, translogTransferStats, routing);
            }
import java.io.IOException;
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.threadpool.TestThreadPool;
        ShardRouting routing = createShardRouting(shardId, true);
 */
import org.opensearch.index.remote.RemoteSegmentTransferTracker;
    }
        Map<String, Object> jsonObject = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
import static org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsTestHelper.compareStatsResponse;
package org.opensearch.action.admin.cluster.remotestore.stats;
        threadPool.shutdownNow();
import java.util.Map;
        XContentBuilder builder = XContentFactory.jsonBuilder();
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
        RemoteTranslogTransferTracker.Stats translogTransferStats = createEmptyTranslogStats(shardId);
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsTestHelper.createEmptyTranslogStats;
    private ShardId shardId;
                assertEquals(stats.getSegmentStats(), deserializedStats.getSegmentStats());
    }
        Map<String, Object> jsonObject = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
        Map<String, Object> jsonObject = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
 * compatible open source license.
