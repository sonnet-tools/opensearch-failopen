        logger.info("--> restarting cluster");  
import org.opensearch.indices.recovery.RecoverySettings;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        createIndex(INDEX_NAME);
    }
            (handler, request, channel, task) -> {
                );
                .setSource("foo-int", randomInt(), "foo-string", randomAlphaOfLength(32), "foo-float", randomFloat());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
    }
        ));
import org.opensearch.test.transport.MockTransportService;
        internalCluster().startNode();
            .put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true)  
        }, 1, TimeUnit.MINUTES);
            TransportService.class,
            Settings.builder()
                .setSource("foo" + i, "bar" + i)
            client().prepareIndex(INDEX_NAME)  
                    }
                logger.info(  
        final String primaryNode = internalCluster().startDataOnlyNode();  
                )  
        logger.info("--> start nodes");  
                .build()
        primaryTransportService.clearAllRules();
    @Override
            assertEquals(segmentCount, primarySegments.size());
                    blockFileCopy.countDown();
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), 5)
    }  
        );
        }  
        MockTransportService primaryTransportService = ((MockTransportService) internalCluster().getInstance(  
                assertEquals(0, ((GetSegmentFilesRequest) request).getFilesToFetch().size());
                .prepareUpdateSettings(INDEX_NAME)
import org.opensearch.test.OpenSearchIntegTestCase;  
        ensureGreen(INDEX_NAME);
    protected Settings nodeSettings(int nodeOrdinal) {  
 * The OpenSearch Contributors require contributions made to  
        logger.info("--> indexing sample data");
                            replicaSegments.add(segment.getName());
            assertEquals(segmentCount, replicaSegments.size());  
            final IndicesSegmentResponse response = client().admin().indices().prepareSegments(indexName).get();
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
                connection.sendRequest(requestId, action, request, options);
        logger.info("--> creating test index: {}", INDEX_NAME);  
import org.opensearch.action.admin.indices.segments.ShardSegments;  
 * compatible open source license.
                .put(IndexSettings.INDEX_MERGE_ON_FLUSH_ENABLED.getKey(), false)  
import org.opensearch.index.store.StoreFileMetadata;
            }
            client().prepareIndex(INDEX_NAME)  
        indexRandom(true, docs);
            primaryNode
        final String replicaNode = internalCluster().startDataOnlyNode();
        CountDownLatch blockFileCopy = new CountDownLatch(1);
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(2));  
        }
                .setId(String.valueOf(i))
import org.opensearch.index.TieredMergePolicyProvider;
        );
public class MergedSegmentWarmerIT extends SegmentReplicationIT {
                .get();
/*  
        AtomicInteger getMergeSegmentFilesActionCount = new AtomicInteger(0);
import org.opensearch.action.support.WriteRequest;
            .build();
                }
            replicaFiles.removeIf(f -> f.startsWith("segment"));
                        throw new ConnectTransportException(connection.getNode(), "mock connection exception");
import org.opensearch.action.index.IndexRequestBuilder;
            }  
        assertBusy(() -> {
            INDEX_NAME,
        MockTransportService primaryTransportService = ((MockTransportService) internalCluster().getInstance(
        forceMergeComplete.set(true);  
 * SPDX-License-Identifier: Apache-2.0
    // Construct a case with redundant pending merge segments in replica shard, and finally delete these files  
 *
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(2));
    public static void waitForSegmentCount(String indexName, int segmentCount, Logger logger) throws Exception {  
            assertEquals(primaryFiles, replicaFiles);
/**  
    public void testMergeSegmentWarmerWithInactiveReplica() throws Exception {  
        assertThat(client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value(), equalTo((long) numDocs));
            Set<String> replicaSegments = Sets.newHashSet();  
import org.opensearch.common.settings.Settings;  
        ensureGreen();  
        ensureGreen();
            client().admin()  
            client().prepareIndex(INDEX_NAME)
                if (action.equals(SegmentReplicationTargetService.Actions.FILE_CHUNK)) {
        waitForSegmentCount(INDEX_NAME, 2, logger);
        AtomicBoolean forceMergeComplete = new AtomicBoolean(false);
        for (int i = 0; i < 30; i++) {
 */
            .put(super.nodeSettings(nodeOrdinal))
            Settings.builder()
    public void testConcurrentMergeSegmentWarmer() throws Exception {
        waitForSegmentCount(INDEX_NAME, 1, logger);
                .setId(String.valueOf(i))
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
        internalCluster().startDataOnlyNode();
                    ((GetSegmentFilesRequest) request).getFilesToFetch().stream().map(StoreFileMetadata::name).collect(Collectors.toList())  
        primaryTransportService.addRequestHandlingBehavior(
                .setSource("foo" + i, "bar" + i)  
    }
import org.opensearch.common.unit.TimeValue;
            primaryNode
            (connection, requestId, action, request, options) -> {  
                    }
                }
        for (int i = 0; i < 30; i++) {
        final int numDocs = 100;  
                .put(indexSettings())  
                        throw new RuntimeException(e);
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
                if (getMergeSegmentFilesActionCount.get() > 2) {  
                );  
import java.util.concurrent.atomic.AtomicBoolean;
        );
                .indices()
import org.opensearch.transport.TransportService;  
        final String primaryNode = internalCluster().startDataOnlyNode();
        ensureGreen(INDEX_NAME);  
        internalCluster().fullRestart();
                }
                }
    }  
        waitForSearchableDocs(30, primaryNode, replicaNode);
                    ((GetSegmentFilesRequest) request).getReplicationId(),
        createIndex(INDEX_NAME, Settings.builder().put(indexSettings()).put("number_of_shards", 1).put("number_of_replicas", 0).build());
        primaryTransportService.addRequestHandlingBehavior(  
    public void testPrimaryNodeRestart() throws Exception {
            Set<String> replicaFiles = Sets.newHashSet(replicaDirectory.listAll());  
            (connection, requestId, action, request, options) -> {  
                        }  
        // ensure pre-copy merge segment concurrent execution
        ));  
                    "replicationId {}, get merge segment files {}",
import java.util.concurrent.CountDownLatch;  
                        if (shardSegment.getShardRouting().primary()) {
        assertBusy(() -> assertFalse(replicaShard.getPendingMergedSegmentCheckpoints().isEmpty()));  
                for (ShardSegments shardSegment : indexShardSegments.getShards()) {  
        waitForSegmentCount(INDEX_NAME, 2, logger);  
        createIndex(INDEX_NAME);
        // Verify replica shard has pending merged segments
            primaryNode
}  
            (handler, request, channel, task) -> {
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
 * this file be licensed under the Apache-2.0 license or a
    public void testMergeSegmentWarmer() throws Exception {
                    "replicationId {}, get segment files {}",  
        }, 1, TimeUnit.MINUTES);  
        primaryTransportService.clearAllRules();  
            // Verify that primary shard and replica shard have the same file list
                if (action.equals(SegmentReplicationTargetService.Actions.MERGED_SEGMENT_FILE_CHUNK)) {
            // Verify replica shard does not have pending merged segments
            for (IndexShardSegments indexShardSegments : response.getIndices().get(indexName).getShards().values()) {
        createIndex(  
        IndexShard replicaShard = getIndexShard(replicaNode, INDEX_NAME);
        final IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(), 5)
        final String replicaNode = internalCluster().startDataOnlyNode();
                .setId(String.valueOf(i))
                .put(indexSettings())  
import org.apache.lucene.store.Directory;
                        blockFileCopy.await();  
        }  
        ensureGreen(INDEX_NAME);
        assertEquals(1, response.getIndices().get(INDEX_NAME).getShards().values().size());  
                connection.sendRequest(requestId, action, request, options);  
                    if (forceMergeComplete.get() == false) {
import org.opensearch.common.util.set.Sets;
        assertBusy(() -> {  
                    ((GetSegmentFilesRequest) request).getFilesToFetch().stream().map(StoreFileMetadata::name).collect(Collectors.toList())
            docs[i] = client().prepareIndex(INDEX_NAME)
        );
                logger.info(
        );
            SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES,  
                    }  
            internalCluster().getInstance(TransportService.class, replicaNode),
package org.opensearch.indices.replication;
        primaryTransportService.clearAllRules();  
        primaryTransportService.addSendBehavior(
                // After the pre-copy merged segment is complete, the merged segment files is to reuse, so the files to fetch is empty.
                        .put(IndexSettings.INDEX_PUBLISH_REFERENCED_SEGMENTS_INTERVAL_SETTING.getKey(), TimeValue.timeValueSeconds(1))
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.transport.ConnectTransportException;
 */  
        return Settings.builder()
        for (int i = 0; i < 30; i++) {  
                        logger.trace("mock connection exception");  
        assertBusy(() -> { assertFalse(replicaShard.getPendingMergedSegmentCheckpoints().isEmpty()); }, 1, TimeUnit.MINUTES);  
            }  
                getMergeSegmentFilesActionCount.incrementAndGet();
                    for (Segment segment : shardSegment.getSegments()) {
                .get();
                    try {
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
                .put(IndexSettings.INDEX_MERGE_ON_FLUSH_ENABLED.getKey(), false)  
            logger.info("primary segments: {}, replica segments: {}", primarySegments, replicaSegments);
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                    } catch (InterruptedException e) {
                .setId(String.valueOf(i))  
import java.util.stream.Collectors;
        }
        primaryTransportService.addSendBehavior(
        for (int i = 0; i < 30; i++) {
    public void testCleanupRedundantPendingMergeFile() throws Exception {
            }
        }
        MockTransportService primaryTransportService = ((MockTransportService) internalCluster().getInstance(  
                .build()
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;  
            IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(), 5)
import org.opensearch.index.engine.Segment;
            .put(RecoverySettings.INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING.getKey(), "1b")
            TransportService.class,
            primaryFiles.removeIf(f -> f.startsWith("segment"));
    }
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(1)).get();
                .setSource("foo" + i, "bar" + i)
        final String replicaNode = internalCluster().startDataOnlyNode();
    }
                handler.messageReceived(request, channel, task);  
                    ((GetSegmentFilesRequest) request).getReplicationId(),
import org.apache.logging.log4j.Logger;
import org.opensearch.index.shard.IndexShard;  
            INDEX_NAME,
        for (int i = 0; i < numDocs; i++) {  
            client().prepareIndex(INDEX_NAME)
            SegmentReplicationSourceService.Actions.GET_MERGED_SEGMENT_FILES,
        );
        createIndex(  
            Directory primaryDirectory = primaryShard.store().directory();
        client().admin().indices().forceMerge(new ForceMergeRequest(INDEX_NAME).maxNumSegments(1)).get();
                .get();  
        final IndicesSegmentResponse response = client().admin().indices().prepareSegments(INDEX_NAME).get();
                            primarySegments.add(segment.getName());  
            internalCluster().getInstance(TransportService.class, replicaNode),
            Set<String> primarySegments = Sets.newHashSet();
import org.opensearch.action.admin.indices.segments.IndexShardSegments;
                .get();
            Directory replicaDirectory = replicaShard.store().directory();
        );
        ));  
import org.opensearch.index.IndexSettings;  
 * This class runs Segment Replication Integ test suite with merged segment warmer enabled.
import java.util.concurrent.atomic.AtomicInteger;  
            Set<String> primaryFiles = Sets.newHashSet(primaryDirectory.listAll());  
            assertEquals(0, replicaShard.getPendingMergedSegmentCheckpoints().size());  
import java.util.Set;
import java.util.concurrent.TimeUnit;
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), 5)
            }
            TransportService.class,  
        flush();  
        final String primaryNode = internalCluster().startDataOnlyNode();
                .setSource("foo" + i, "bar" + i)
                handler.messageReceived(request, channel, task);  
        assertAcked(
                .setSettings(  
                        } else {
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
                    Settings.builder()
