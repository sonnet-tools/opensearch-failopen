        Settings settings = Settings.builder()
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SCHEDULER_INTERVAL.getKey(), SCHEDULER_INTERVAL)
        Settings clusterSettings = Settings.builder()  
            TimeUnit.MINUTES
                        .build()
    private static final int INGESTION_COUNT = 3;  
        autoForceMergeManager.getTask().runInternal();
            flushAndRefresh(INDEX_NAME_1);
            indexBulk(INDEX_NAME_2, NUM_DOCS_IN_BULK);
        ensureStableCluster(3, dataNode);
import org.opensearch.cluster.metadata.IndexMetadata;  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertTrue(shardWithoutWarmNode.segmentStats(false, false).getCount() > SEGMENT_COUNT);
                .indices()
        for (int i = 0; i < INGESTION_COUNT; i++) {
import org.opensearch.core.common.unit.ByteSizeUnit;
            "Auto force merge continued after all warm nodes were removed",
        assertTrue(totalSegmentsBefore.get() > 5);
        Settings clusterSettings = Settings.builder()  
 */  
            .build();
        flushAndRefresh(INDEX_NAME_1);
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME_1).setSettings(settings).get());
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME_2).get());  
        waitUntil(() -> shard1.segmentStats(false, false).getCount() == SEGMENT_COUNT, 1, TimeUnit.MINUTES);
            .build();  
        assertNotNull(shard);
        internalTestCluster.startClusterManagerOnlyNode(clusterSettings);  
        // After stats
    public void testAutoForceMergeTriggeringBasicWithOneShard() throws Exception {  
        assertTrue(autoForceMergeManager.getConfigurationValidator().validate().isAllowed());
            .put(super.nodeSettings(nodeOrdinal))
        IndexShard shard2 = getIndexShardFromShardId(dataNode, INDEX_NAME_1, 1);
            client().admin()
            .build();
        Thread.sleep(TimeValue.parseTimeValue(SCHEDULER_INTERVAL, "test").getMillis() * 3);  
        assertNotNull(shard);  
        );  
        String warmNode = internalTestCluster.startWarmOnlyNodes(1, clusterSettings).getFirst();  
                .indices()
import org.opensearch.index.shard.IndexShard;
            client().admin()
            .put(super.nodeSettings(0))
                .prepareCreate(INDEX_NAME_2)  
        SegmentsStats segmentsStatsAfter = shard.segmentStats(false, false);
        internalCluster().startWarmOnlyNodes(1, clusterSettings).getFirst();
        IndexShard shard = getIndexShard(dataNode, INDEX_NAME_1);
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
        assertEquals((int) SEGMENT_COUNT, segmentsStatsAfter.getCount());  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        assertTrue(
            flushAndRefresh(INDEX_NAME_1);
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
        for (int i = 0; i < INGESTION_COUNT; i++) {
        SegmentsStats segmentsStatsForShard3After = shard3.segmentStats(false, false);  
            .build();  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .build();  
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SETTING.getKey(), true)
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())  
    }
        );
            client().admin()
            indexBulk(INDEX_NAME_1, NUM_DOCS_IN_BULK);  
            () -> assertTrue(
/*  
    }
        assertBusy(() -> assertTrue(shardWithWarmNode.indexSettings().isAutoForcemergeEnabled()));
            .put(ForceMergeManagerSettings.TRANSLOG_AGE_AUTO_FORCE_MERGE.getKey(), TRANSLOG_AGE)  
        Settings settings = Settings.builder()  
        String dataNode = internalTestCluster.startDataOnlyNodes(1, clusterSettings).getFirst();  
        InternalTestCluster internalTestCluster = internalCluster();
    private static final int NUM_DOCS_IN_BULK = 1000;
        for (int i = 0; i < INGESTION_COUNT; i++) {
        assertNotNull(shard);
                    Settings.builder()
        waitUntil(() -> shard3.segmentStats(false, false).getCount() == SEGMENT_COUNT, 1, TimeUnit.MINUTES);
            waitUntil(() -> shardWithoutWarmNode.segmentStats(false, false).getCount() == SEGMENT_COUNT, 10, TimeUnit.SECONDS)
        String dataNode = internalTestCluster.startDataOnlyNodes(1, clusterSettings).getFirst();  
    private static final String INDEX_NAME_1 = "test-auto-forcemerge-one";  
        assertNotNull(shard2);
        SegmentsStats segmentsStatsAfter = shard.segmentStats(false, false);
                .get()
        String dataNode = internalTestCluster.startDataOnlyNodes(1, clusterSettings).getFirst();
        Settings clusterSettings = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.index.IndexSettings;  
import org.opensearch.test.OpenSearchIntegTestCase;
        assertEquals(segmentsStatsBefore.getCount(), segmentsStatsAfter.getCount());
        assertFalse(  
                .setSettings(Settings.builder().put(IndexSettings.INDEX_AUTO_FORCE_MERGES_ENABLED.getKey(), true))  
        IndexShard shardWithWarmNode = getIndexShard(dataNode, INDEX_NAME_1);  
        assertBusy(  
import java.util.concurrent.TimeUnit;
        assertNotNull(shard5);
        SegmentsStats segmentsStatsForShard3Before = shard3.segmentStats(false, false);  
        waitUntil(() -> shard2.segmentStats(false, false).getCount() == SEGMENT_COUNT, 1, TimeUnit.MINUTES);  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        SegmentsStats segmentsStatsForShard1Before = shard1.segmentStats(false, false);
        assertBusy(() -> assertTrue(autoForceMergeManager.getNodeValidator().validate().isAllowed()), 1, TimeUnit.MINUTES);  
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SETTING.getKey(), true)  
 * SPDX-License-Identifier: Apache-2.0
        IndexShard shard5 = getIndexShardFromShardId(dataNode, INDEX_NAME_2, 1);  
                )  
    private static final String MERGE_DELAY = "1s";  
            waitUntil(() -> shardWithWarmNode.segmentStats(false, false).getCount() == SEGMENT_COUNT, 30, TimeUnit.SECONDS)  
        autoForceMergeManager.getTask().runInternal();  
                .get()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.test.InternalTestCluster;  
        assertNotNull(shard3);  
    }
    protected Settings nodeSettings(int nodeOrdinal) {
        SegmentsStats segmentsStatsForShard4Before = shard4.segmentStats(false, false);
                .indices()
                + segmentsStatsForShard4Before.getCount() + segmentsStatsForShard5Before.getCount()
    @SuppressForbidden(reason = "Sleeping longer than scheduled interval")
        String dataNode = internalTestCluster.startDataOnlyNodes(1, clusterSettings).getFirst();
        Settings settings = Settings.builder()
        assertAcked(
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME_1).setSettings(settings).get());  
 * The OpenSearch Contributors require contributions made to  
        }  
        );
        return Settings.builder()  
            .put(super.nodeSettings(0))
    private static final String SCHEDULER_INTERVAL = "1s";
            .put(IndexSettings.INDEX_AUTO_FORCE_MERGES_ENABLED.getKey(), false)  
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SETTING.getKey(), true)  
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        }  
        // Deleting the index (so that ref count drops to zero for all the files) and then pruning the cache to clear it to avoid any file
import org.opensearch.common.unit.TimeValue;  
            indexBulk(INDEX_NAME_2, NUM_DOCS_IN_BULK);
        IndexShard shard1 = getIndexShardFromShardId(dataNode, INDEX_NAME_1, 0);
            TimeUnit.MINUTES
        assertNotNull(shard1);
        );
        // Each ingestion request creates a segment here  
                .setSettings(Settings.builder().put(IndexSettings.INDEX_AUTO_FORCE_MERGES_ENABLED.getKey(), true))
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME_1).get());
        for (int i = 0; i < INGESTION_COUNT; i++) {  
import org.opensearch.index.engine.SegmentsStats;
        SegmentsStats segmentsStatsForShard2After = shard2.segmentStats(false, false);
        }
            .build();  
            .put(IndexSettings.INDEX_AUTO_FORCE_MERGES_ENABLED.getKey(), false)
import org.opensearch.core.common.unit.ByteSizeValue;
        assertTrue((int) segmentsStatsBefore.getCount() > segmentsStatsAfter.getCount());
                .setSettings(
            )  
            refresh(INDEX_NAME_2);
        InternalTestCluster internalTestCluster = internalCluster();
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME_1).get());
            .put(ForceMergeManagerSettings.JVM_THRESHOLD_PERCENTAGE_FOR_AUTO_FORCE_MERGE.getKey(), 100)  
                client(dataNode).admin().cluster().prepareState().setLocal(true).get().getState().getNodes().getWarmNodes().isEmpty()
        );  
        SegmentsStats segmentsStatsForShard2Before = shard2.segmentStats(false, false);
        InternalTestCluster internalTestCluster = internalCluster();
        assertBusy(
            segmentsStatsForShard1Before.getCount() + segmentsStatsForShard2Before.getCount() + segmentsStatsForShard3Before.getCount()
            "Auto force merge did not run while a warm node was present",
        SegmentsStats segmentsStatsForShard4After = shard4.segmentStats(false, false);
        );
        internalTestCluster.stopRandomNode(InternalTestCluster.nameFilter(warmNode));
        SegmentsStats segmentsStatsAfter = shard.segmentStats(false, false);
    }
            .put(NODE_PROCESSORS_SETTING.getKey(), 32)
 *
        );
        waitUntil(() -> shard5.segmentStats(false, false).getCount() == SEGMENT_COUNT, 1, TimeUnit.MINUTES);  
        SegmentsStats segmentsStatsForShard5Before = shard5.segmentStats(false, false);
            indexBulk(INDEX_NAME_1, NUM_DOCS_IN_BULK);
        );  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        SegmentsStats segmentsStatsForShard5After = shard5.segmentStats(false, false);
            .build();  
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        }
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME_1).setSettings(settings).get());
        );  
        assertTrue(shardWithWarmNode.segmentStats(false, false).getCount() > SEGMENT_COUNT);
        Settings clusterSettings = Settings.builder()
public class AutoForceMergeManagerIT extends RemoteStoreBaseIntegTestCase {
        );  
        IndexShard shard = getIndexShard(dataNode, INDEX_NAME_1);  
        IndexShard shardWithoutWarmNode = getIndexShard(dataNode, INDEX_NAME_2);
        InternalTestCluster internalTestCluster = internalCluster();
        assertBusy(
            indexBulk(INDEX_NAME_1, NUM_DOCS_IN_BULK);  
        assertBusy(() -> assertTrue(autoForceMergeManager.getNodeValidator().validate().isAllowed()), 1, TimeUnit.MINUTES);
                    Settings.builder()
        internalTestCluster.startClusterManagerOnlyNode(clusterSettings);  
        IndexShard shard4 = getIndexShardFromShardId(dataNode, INDEX_NAME_2, 0);
        assertNotNull(shard4);
            .put(ForceMergeManagerSettings.DISK_THRESHOLD_PERCENTAGE_FOR_AUTO_FORCE_MERGE.getKey(), 100)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .setSettings(
        Thread.sleep(TimeValue.parseTimeValue(SCHEDULER_INTERVAL, "test").getMillis() * 3);  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testAutoForceMergeTriggeringBasicWithFiveShardsOfTwoIndex() throws Exception {
        assertAcked(  
        internalCluster().startWarmOnlyNodes(1, clusterSettings).getFirst();
}
        ensureStableCluster(2, dataNode);
        assertEquals(segmentsStatsBefore.getCount(), segmentsStatsAfter.getCount());  
        assertAcked(  
            indexBulk(INDEX_NAME_1, NUM_DOCS_IN_BULK);
            .build();
        internalCluster().startWarmOnlyNodes(1, clusterSettings).getFirst();
        SegmentsStats segmentsStatsBefore = shard.segmentStats(false, false);
                )  
                .indices()
            () -> assertTrue(autoForceMergeManager.getShardValidator().validate(shardWithWarmNode).isAllowed()),
                        .build()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, supportsDedicatedMasters = false)  
            .build();
        assertAcked(  
            1,
        for (int i = 0; i < INGESTION_COUNT; i++) {  
        waitUntil(() -> shard4.segmentStats(false, false).getCount() == SEGMENT_COUNT, 1, TimeUnit.MINUTES);
                + segmentsStatsForShard4After.getCount() + segmentsStatsForShard5After.getCount()
        }
import org.opensearch.common.settings.Settings;
            .build();  
        IndexShard shard = getIndexShard(dataNode, INDEX_NAME_1);  
        internalTestCluster.startClusterManagerOnlyNode(clusterSettings);
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME_1).get());
        Settings clusterSettings = Settings.builder()
                .prepareUpdateSettings(INDEX_NAME_2)
            .put(ForceMergeManagerSettings.CPU_THRESHOLD_PERCENTAGE_FOR_AUTO_FORCE_MERGE.getKey(), 100)
        internalTestCluster.startClusterManagerOnlyNode(clusterSettings);
        internalTestCluster.startClusterManagerOnlyNode(clusterSettings);
            refresh(INDEX_NAME_1);  
        // leaks  
                .get()
import java.util.concurrent.atomic.AtomicLong;
        String dataNode = internalTestCluster.startDataOnlyNodes(1, clusterSettings).getFirst();
                .prepareUpdateSettings(INDEX_NAME_1)  
            .put(super.nodeSettings(0))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        assertNotNull(shardWithoutWarmNode);  
        // This is to make sure auto force merge action gets triggered multiple times ang gets successful at least once.
 * this file be licensed under the Apache-2.0 license or a
        SegmentsStats segmentsStatsBefore = shard.segmentStats(false, false);  
            () -> assertTrue(autoForceMergeManager.getShardValidator().validate(shardWithoutWarmNode).isAllowed()),  
        // Before stats
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME_1).get());  
            segmentsStatsForShard1After.getCount() + segmentsStatsForShard2After.getCount() + segmentsStatsForShard3After.getCount()
    private static final Integer SEGMENT_COUNT = 1;
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SETTING.getKey(), false)
        Settings settings = Settings.builder()  
    private static final String TRANSLOG_AGE = "1s";
        SegmentsStats segmentsStatsForShard1After = shard1.segmentStats(false, false);
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)  
        for (int i = 0; i < INGESTION_COUNT; i++) {
        AtomicLong totalSegmentsBefore = new AtomicLong(  
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;  
            flushAndRefresh(INDEX_NAME_1);  
 * compatible open source license.
package org.opensearch.index.autoforcemerge;
        );
import org.opensearch.common.SuppressForbidden;
    @SuppressForbidden(reason = "Sleeping longer than scheduled interval")  
    private static final String INDEX_NAME_2 = "test-auto-forcemerge-two";
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME_2).setSettings(initiallyDisabledSettings).get());
        SegmentsStats segmentsStatsBefore = shard.segmentStats(false, false);
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME_1).get());
import org.opensearch.node.Node;
            .put(IndexSettings.INDEX_AUTO_FORCE_MERGES_ENABLED.getKey(), false)
        AtomicLong totalSegmentsAfter = new AtomicLong(  
        Settings initiallyDisabledSettings = Settings.builder()  
            .put(ForceMergeManagerSettings.MERGE_DELAY_BETWEEN_SHARDS_FOR_AUTO_FORCE_MERGE.getKey(), MERGE_DELAY)
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME_1).setSettings(settings).get());
        InternalTestCluster internalTestCluster = internalCluster();  
            .put(super.nodeSettings(0))
            flushAndRefresh(INDEX_NAME_2);  
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SETTING.getKey(), true)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        IndexShard shard3 = getIndexShardFromShardId(dataNode, INDEX_NAME_1, 2);  
            1,  
    public void testAutoForceMergeTriggeringWithOneShardOfNonWarmCandidate() throws Exception {
    }
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)  
            client().admin()  
        assertTrue(totalSegmentsBefore.get() > totalSegmentsAfter.get());
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertTrue(shardWithoutWarmNode.segmentStats(false, false).getCount() > SEGMENT_COUNT);
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
            .put(super.nodeSettings(0))  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertBusy(() -> assertTrue(shardWithoutWarmNode.indexSettings().isAutoForcemergeEnabled()));  
    public void testAutoForceMergeFeatureFlagDisabled() throws InterruptedException, ExecutionException {
        AutoForceMergeManager autoForceMergeManager = internalTestCluster.getInstance(AutoForceMergeManager.class, dataNode);
        waitUntil(() -> shard.segmentStats(false, false).getCount() == SEGMENT_COUNT, 1, TimeUnit.MINUTES);  
        for (int i = 0; i < INGESTION_COUNT; i++) {
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME_2).get());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
    @Override  
        internalCluster().startWarmOnlyNodes(1, clusterSettings).getFirst();
            .put(ForceMergeManagerSettings.SEGMENT_COUNT_FOR_AUTO_FORCE_MERGE.getKey(), SEGMENT_COUNT)
        assertNotNull(shardWithWarmNode);
    public void testAutoForceMergeStopsAfterAllWarmNodesAreRemoved() throws Exception {
import java.util.concurrent.ExecutionException;  
                .prepareCreate(INDEX_NAME_1)  
            .build();
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.NODE_PROCESSORS_SETTING;
            indexBulk(INDEX_NAME_1, NUM_DOCS_IN_BULK);
        // refresh to clear old segments
                .get()
            flushAndRefresh(INDEX_NAME_1);
        }
    }  
        }
