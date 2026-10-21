        internalCluster().startDataOnlyNode();
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), 5)
                        throw new ConnectTransportException(connection.getNode(), "mock connection exception");
            client().prepareIndex(INDEX_NAME)
            primaryNode
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
        }
            INDEX_NAME,
 * compatible open source license.
        final String primaryNode = internalCluster().startDataOnlyNode();
                }
                // After the pre-copy merged segment is complete, the merged segment files is to reuse, so the files to fetch is empty.
public class MergedSegmentWarmerIT extends SegmentReplicationIT {
                if (action.equals(SegmentReplicationTargetService.Actions.MERGED_SEGMENT_FILE_CHUNK)) {
                    "replicationId {}, get segment files {}",
                .put(IndexSettings.INDEX_MERGE_ON_FLUSH_ENABLED.getKey(), false)
        ensureGreen(INDEX_NAME);
            Directory replicaDirectory = replicaShard.store().directory();
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put("number_of_shards", 1).put("number_of_replicas", 0).build());
            Directory primaryDirectory = primaryShard.store().directory();
        AtomicInteger getMergeSegmentFilesActionCount = new AtomicInteger(0);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        final IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
            }
 * this file be licensed under the Apache-2.0 license or a
        assertBusy(() -> {
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(), 5)
            for (IndexShardSegments indexShardSegments : response.getIndices().get(indexName).getShards().values()) {
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                .build()
        CountDownLatch blockFileCopy = new CountDownLatch(1);
        // Verify replica shard has pending merged segments
                connection.sendRequest(requestId, action, request, options);
        );
        indexRandom(true, docs);
                .setSource("foo" + i, "bar" + i)
            .build();
                }
        primaryTransportService.addSendBehavior(
                )
            // Verify replica shard does not have pending merged segments
 * This class runs Segment Replication Integ test suite with merged segment warmer enabled.
            (handler, request, channel, task) -> {
            primaryFiles.removeIf(f -> f.startsWith("segment"));
import java.util.concurrent.atomic.AtomicBoolean;
    public void testPrimaryNodeRestart() throws Exception {
                    ((GetSegmentFilesRequest) request).getReplicationId(),
        );
            }
}
        primaryTransportService.addRequestHandlingBehavior(
    }
            }
        assertAcked(
import java.util.concurrent.TimeUnit;
    public void testConcurrentMergeSegmentWarmer() throws Exception {
                .setSource("foo" + i, "bar" + i)
        );
/*
        ensureYellowAndNoInitializingShards(INDEX_NAME);
                .setSource("foo" + i, "bar" + i)
    }
        for (int i = 0; i < numDocs; i++) {
                    blockFileCopy.countDown();
import org.opensearch.index.shard.IndexShard;
        assertThat(client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value(), equalTo((long) numDocs));
                .get();
    protected Settings nodeSettings(int nodeOrdinal) {
        logger.info("--> start nodes");
import org.opensearch.index.TieredMergePolicyProvider;
        flush();
        }
            client().prepareIndex(INDEX_NAME)
                        logger.trace("mock connection exception");
            Set<String> replicaSegments = Sets.newHashSet();
import org.opensearch.common.util.set.Sets;
package org.opensearch.indices.replication;
 * The OpenSearch Contributors require contributions made to
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(1)).get();
        IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);
        );
            replicaFiles.removeIf(f -> f.startsWith("segment"));
                    "replicationId {}, get merge segment files {}",
                    ((GetSegmentFilesRequest) request).getFilesToFetch().stream().map(StoreFileMetadata::name).collect(Collectors.toList())
            // Verify that primary shard and replica shard have the same file list
                .put(IndexSettings.INDEX_MERGE_ON_FLUSH_ENABLED.getKey(), false)
                getMergeSegmentFilesActionCount.incrementAndGet();
        ensureGreen(INDEX_NAME);
        ));
        );
    }
                        .put(IndexSettings.INDEX_PUBLISH_REFERENCED_SEGMENTS_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(1))
                        }
            TransportService.class,
                .setId(String.valueOf(i))
import org.opensearch.test.transport.MockTransportService;
            SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES,
    }
            .put(super.nodeSettings(nodeOrdinal))
    public static void waitForSegmentCount(String indexName, int segmentCount, Logger logger) throws Exception {
        waitForSegmentCount(INDEX_NAME, 2, logger);
        createIndex(INDEX_NAME);
                assertEquals(0, ((GetSegmentFilesRequest) request).getFilesToFetch().size());
                    }
    }
        }, 1, TimeUnit.MINUTES);
import org.apache.logging.log4j.Logger;
                        } else {
        final String primaryNode = internalCluster().startDataOnlyNode();
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
import org.opensearch.index.store.StoreFileMetadata;
                .setSource("foo-int", randomInt(), "foo-string", randomAlphaOfLength(32), "foo-float", randomFloat());
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.index.engine.Segment;
            (connection, requestId, action, request, options) -> {
                .setSettings(
import org.opensearch.transport.ConnectTransportException;
            }
                );
    }
                    for (Segment segment : shardSegment.getSegments()) {
        }, 1, TimeUnit.MINUTES);
            Settings.builder()
                .get();
                    ((GetSegmentFilesRequest) request).getReplicationId(),
        primaryTransportService.addRequestHandlingBehavior(
 */
        createIndex(
        }
            internalCluster().getInstance(TransportService.class, replicaNode),
                logger.info(
        primaryTransportService.clearAllRules();
        );
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                .prepareUpdateSettings(INDEX_NAME)
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(), 5)
            SegmentReplicationSourceService.Actions.GET_MERGED_SEGMENT_FILES,
            }
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(2));
            Set<String> replicaFiles = Sets.newHashSet(replicaDirectory.listAll());
            Settings.builder()
        return Settings.builder()
    public void testMergeSegmentWarmerWithInactiveReplica() throws Exception {
        MockTransportService primaryTransportService = ((MockTransportService) internalCluster().getInstance(
        final String replicaNode = internalCluster().startDataOnlyNode();
    // Construct a case with redundant pending merge segments in replica shard, and finally delete these files
    }
import org.opensearch.common.unit.TimeValue;
            .put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true)
        );
        primaryTransportService.addSendBehavior(
            assertEquals(primaryFiles, replicaFiles);
                handler.messageReceived(request, channel, task);
                    try {
import org.opensearch.index.IndexSettings;
import org.opensearch.common.settings.Settings;
                .setSource("foo" + i, "bar" + i)
                .get();
import org.opensearch.action.index.IndexRequestBuilder;
            (connection, requestId, action, request, options) -> {
        // ensure pre-copy merge segment concurrent execution
        logger.info("--> indexing sample data");
                connection.sendRequest(requestId, action, request, options);
            primaryNode
        MockTransportService primaryTransportService = ((MockTransportService) internalCluster().getInstance(
                if (getMergeSegmentFilesActionCount.get() > 2) {
            client().prepareIndex(INDEX_NAME)
                .put(indexSettings())
            final IndicesSegmentResponse response = client().admin().indices().prepareSegments(indexName).get();
        }
        for (int i = 0; i < 30; i++) {
        final String replicaNode = internalCluster().startDataOnlyNode();
        ));
                );
                    ((GetSegmentFilesRequest) request).getFilesToFetch().stream().map(StoreFileMetadata::name).collect(Collectors.toList())
        final IndicesSegmentResponse response = client().admin().indices().prepareSegments(INDEX_NAME).get();
            logger.info("primary segments: {}, replica segments: {}", primarySegments, replicaSegments);
                    if (forceMergeComplete.get() == false) {
import org.apache.lucene.store.Directory;
import org.opensearch.transport.TransportService;
            client().admin()
            internalCluster().getInstance(TransportService.class, replicaNode),
        MockTransportService primaryTransportService = ((MockTransportService) internalCluster().getInstance(
        assertBusy(() -> {
        internalCluster().fullRestart();
import static org.hamcrest.Matchers.equalTo;
            client().prepareIndex(INDEX_NAME)
import java.util.concurrent.CountDownLatch;
            TransportService.class,
            Set<String> primarySegments = Sets.newHashSet();
        createIndex(
        assertBusy(() -> { assertFalse(replicaShard.getPendingMergedSegmentCheckpoints().isEmpty()); }, 1, TimeUnit.MINUTES);
        forceMergeComplete.set(true);
        AtomicBoolean forceMergeComplete = new AtomicBoolean(false);
        waitForSegmentCount(INDEX_NAME, 1, logger);
            INDEX_NAME,
        waitForSegmentCount(INDEX_NAME, 2, logger);
import org.opensearch.indices.recovery.RecoverySettings;
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {
        primaryTransportService.clearAllRules();
import org.opensearch.action.support.WriteRequest;
                        throw new RuntimeException(e);
                .build()
                .get();
                        blockFileCopy.await();
        createIndex(INDEX_NAME);
                .setId(String.valueOf(i))
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), 5)
    @Override
            assertEquals(0, replicaShard.getPendingMergedSegmentCheckpoints().size());
                    }
        final int numDocs = 100;
import java.util.stream.Collectors;
        }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            Set<String> primaryFiles = Sets.newHashSet(primaryDirectory.listAll());
            docs[i] = client().prepareIndex(INDEX_NAME)
        ));
    public void testMergeSegmentWarmer() throws Exception {
        primaryTransportService.clearAllRules();
                    }
 */
        internalCluster().startNode();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
                    } catch (InterruptedException e) {
        for (int i = 0; i < 30; i++) {
                handler.messageReceived(request, channel, task);
/**
                .put(indexSettings())
 * SPDX-License-Identifier: Apache-2.0
                }
        for (int i = 0; i < 30; i++) {
                for (ShardSegments shardSegment : indexShardSegments.getShards()) {
        ensureYellowAndNoInitializingShards(INDEX_NAME);
                .setId(String.valueOf(i))
                }
import java.util.concurrent.atomic.AtomicInteger;
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        logger.info("--> restarting cluster");
                .indices()
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(1)).get();
        final String replicaNode = internalCluster().startDataOnlyNode();
                logger.info(
import org.opensearch.action.admin.indices.segments.IndexShardSegments;
            IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
        ensureGreen();
        assertEquals(1, response.getIndices().get(INDEX_NAME).getShards().values().size());
            TransportService.class,
        for (int i = 0; i < 30; i++) {
 *
        final String primaryNode = internalCluster().startDataOnlyNode();
                    Settings.builder()
                            primarySegments.add(segment.getName());
                        if (shardSegment.getShardRouting().primary()) {
                            replicaSegments.add(segment.getName());
        assertBusy(() -> assertFalse(replicaShard.getPendingMergedSegmentCheckpoints().isEmpty()));
            .put(RecoverySettings.INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING.getKey(), "1b")
import org.opensearch.action.admin.indices.segments.ShardSegments;
import java.util.Set;
        ensureGreen(INDEX_NAME);
            assertEquals(segmentCount, replicaSegments.size());
                .setId(String.valueOf(i))
    public void testCleanupRedundantPendingMergeFile() throws Exception {
            (handler, request, channel, task) -> {
        ensureGreen();
            assertEquals(segmentCount, primarySegments.size());
        waitForSearchableDocs(30, primaryNode, replicaNode);
            primaryNode
        logger.info("--> creating test index: {}", INDEX_NAME);
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(2));
