        internalTestCluster.startClusterManagerOnlyNode(clusterSettings);
            () -> assertTrue(autoForceMergeManager.getShardValidator().validate(shardWithWarmNode).isAllowed()),
        Settings clusterSettings = Settings.builder()
 * compatible open source license.
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
    @SuppressForbidden(reason = "Sleeping longer than scheduled interval")
        String dataNode = internalTestCluster.startDataOnlyNodes(1, clusterSettings).getFirst();
    @Override
        assertNotNull(shard);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .setSettings(Settings.builder().put(IndexSettings.INDEX_AUTO_FORCE_MERGES_ENABLED.getKey(), true))
        AutoForceMergeManager autoForceMergeManager = internalTestCluster.getInstance(AutoForceMergeManager.class, dataNode);
        ensureStableCluster(3, dataNode);
                .prepareUpdateSettings(INDEX_NAME_1)
        assertBusy(() -> assertTrue(shardWithWarmNode.indexSettings().isAutoForcemergeEnabled()));
        );
            segmentsStatsForShard1After.getCount() + segmentsStatsForShard2After.getCount() + segmentsStatsForShard3After.getCount()
        assertEquals(segmentsStatsBefore.getCount(), segmentsStatsAfter.getCount());
        SegmentsStats segmentsStatsForShard2Before = shard2.segmentStats(false, false);
    private static final String SCHEDULER_INTERVAL = "1s";
                .setSettings(
        InternalTestCluster internalTestCluster = internalCluster();
            client().admin()
        assertBusy(() -> assertTrue(autoForceMergeManager.getNodeValidator().validate().isAllowed()), 1, TimeUnit.MINUTES);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            client().admin()
        assertBusy(() -> assertTrue(shardWithoutWarmNode.indexSettings().isAutoForcemergeEnabled()));
                + segmentsStatsForShard4Before.getCount() + segmentsStatsForShard5Before.getCount()
        assertFalse(
 *
        assertEquals(segmentsStatsBefore.getCount(), segmentsStatsAfter.getCount());
    public void testAutoForceMergeTriggeringWithOneShardOfNonWarmCandidate() throws Exception {
        );
            .build();
    public void testAutoForceMergeTriggeringBasicWithFiveShardsOfTwoIndex() throws Exception {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
import org.opensearch.test.OpenSearchIntegTestCase;
        );
        // After stats
        internalTestCluster.stopRandomNode(InternalTestCluster.nameFilter(warmNode));
        assertTrue((int) segmentsStatsBefore.getCount() > segmentsStatsAfter.getCount());
                .setSettings(Settings.builder().put(IndexSettings.INDEX_AUTO_FORCE_MERGES_ENABLED.getKey(), true))
        for (int i = 0; i < INGESTION_COUNT; i++) {
        // Deleting the index (so that ref count drops to zero for all the files) and then pruning the cache to clear it to avoid any file
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME_1).setSettings(settings).get());
        assertNotNull(shard);
        // leaks
        waitUntil(() -> shard.segmentStats(false, false).getCount() == SEGMENT_COUNT, 1, TimeUnit.MINUTES);
            .put(super.nodeSettings(0))
        IndexShard shardWithoutWarmNode = getIndexShard(dataNode, INDEX_NAME_2);
            .build();
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SETTING.getKey(), true)
        internalCluster().startWarmOnlyNodes(1, clusterSettings).getFirst();
import org.opensearch.common.settings.Settings;
import org.opensearch.common.unit.TimeValue;
            "Auto force merge continued after all warm nodes were removed",
import org.opensearch.index.IndexSettings;
            .build();
        IndexShard shard4 = getIndexShardFromShardId(dataNode, INDEX_NAME_2, 0);
        Settings initiallyDisabledSettings = Settings.builder()
        IndexShard shard3 = getIndexShardFromShardId(dataNode, INDEX_NAME_1, 2);
package org.opensearch.index.autoforcemerge;
        }
        Settings settings = Settings.builder()
                .get()
                client(dataNode).admin().cluster().prepareState().setLocal(true).get().getState().getNodes().getWarmNodes().isEmpty()
            segmentsStatsForShard1Before.getCount() + segmentsStatsForShard2Before.getCount() + segmentsStatsForShard3Before.getCount()
        Settings settings = Settings.builder()
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        SegmentsStats segmentsStatsAfter = shard.segmentStats(false, false);
        assertNotNull(shard5);
        SegmentsStats segmentsStatsBefore = shard.segmentStats(false, false);
        );
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
            .build();
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME_1).get());
import org.opensearch.test.InternalTestCluster;
                .setSettings(
        SegmentsStats segmentsStatsForShard1After = shard1.segmentStats(false, false);
    protected Settings nodeSettings(int nodeOrdinal) {
        Settings clusterSettings = Settings.builder()
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME_1).get());
            indexBulk(INDEX_NAME_2, NUM_DOCS_IN_BULK);
            TimeUnit.MINUTES
        for (int i = 0; i < INGESTION_COUNT; i++) {
                    Settings.builder()
            waitUntil(() -> shardWithWarmNode.segmentStats(false, false).getCount() == SEGMENT_COUNT, 30, TimeUnit.SECONDS)
 */
            indexBulk(INDEX_NAME_1, NUM_DOCS_IN_BULK);
        assertNotNull(shard2);
            .put(IndexSettings.INDEX_AUTO_FORCE_MERGES_ENABLED.getKey(), false)
        }
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.NODE_PROCESSORS_SETTING;
        assertNotNull(shard3);
        Settings settings = Settings.builder()
                .prepareCreate(INDEX_NAME_2)
import org.opensearch.index.engine.SegmentsStats;
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME_1).setSettings(settings).get());
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SETTING.getKey(), true)
import org.opensearch.core.common.unit.ByteSizeValue;
        // Each ingestion request creates a segment here
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME_1).get());
        internalTestCluster.startClusterManagerOnlyNode(clusterSettings);
            .put(IndexSettings.INDEX_AUTO_FORCE_MERGES_ENABLED.getKey(), false)
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SETTING.getKey(), true)
    public void testAutoForceMergeFeatureFlagDisabled() throws InterruptedException, ExecutionException {
        SegmentsStats segmentsStatsAfter = shard.segmentStats(false, false);
        Thread.sleep(TimeValue.parseTimeValue(SCHEDULER_INTERVAL, "test").getMillis() * 3);
        IndexShard shard2 = getIndexShardFromShardId(dataNode, INDEX_NAME_1, 1);
        for (int i = 0; i < INGESTION_COUNT; i++) {
        Settings clusterSettings = Settings.builder()
            indexBulk(INDEX_NAME_1, NUM_DOCS_IN_BULK);
        }
            .build();
        assertTrue(autoForceMergeManager.getConfigurationValidator().validate().isAllowed());
        );
            1,
            .build();
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
            () -> assertTrue(
        waitUntil(() -> shard2.segmentStats(false, false).getCount() == SEGMENT_COUNT, 1, TimeUnit.MINUTES);
    private static final int INGESTION_COUNT = 3;
            .put(super.nodeSettings(0))
        SegmentsStats segmentsStatsForShard4Before = shard4.segmentStats(false, false);
        for (int i = 0; i < INGESTION_COUNT; i++) {
    private static final String MERGE_DELAY = "1s";
        SegmentsStats segmentsStatsForShard4After = shard4.segmentStats(false, false);
                .get()
                .indices()
        }
        assertAcked(
import org.opensearch.node.Node;
            .put(ForceMergeManagerSettings.TRANSLOG_AGE_AUTO_FORCE_MERGE.getKey(), TRANSLOG_AGE)
            .put(ForceMergeManagerSettings.MERGE_DELAY_BETWEEN_SHARDS_FOR_AUTO_FORCE_MERGE.getKey(), MERGE_DELAY)
                        .build()
        assertNotNull(shardWithWarmNode);
            .put(super.nodeSettings(0))
        IndexShard shard5 = getIndexShardFromShardId(dataNode, INDEX_NAME_2, 1);
        String dataNode = internalTestCluster.startDataOnlyNodes(1, clusterSettings).getFirst();
        IndexShard shard = getIndexShard(dataNode, INDEX_NAME_1);
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME_2).get());
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME_2).get());
/*
        assertAcked(
        AtomicLong totalSegmentsAfter = new AtomicLong(
            .build();
        assertNotNull(shard1);
            indexBulk(INDEX_NAME_1, NUM_DOCS_IN_BULK);
            client().admin()
    }
        String warmNode = internalTestCluster.startWarmOnlyNodes(1, clusterSettings).getFirst();
            .build();
    }
import java.util.concurrent.TimeUnit;
        assertNotNull(shard4);
            refresh(INDEX_NAME_2);
        assertTrue(
        );
        // This is to make sure auto force merge action gets triggered multiple times ang gets successful at least once.
        ensureStableCluster(2, dataNode);
        );
        internalTestCluster.startClusterManagerOnlyNode(clusterSettings);
        );
            flushAndRefresh(INDEX_NAME_1);
        IndexShard shard = getIndexShard(dataNode, INDEX_NAME_1);
        InternalTestCluster internalTestCluster = internalCluster();
        Settings clusterSettings = Settings.builder()
    private static final String INDEX_NAME_1 = "test-auto-forcemerge-one";
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.index.shard.IndexShard;
        InternalTestCluster internalTestCluster = internalCluster();
                .indices()
            .put(super.nodeSettings(0))
        String dataNode = internalTestCluster.startDataOnlyNodes(1, clusterSettings).getFirst();
        assertTrue(shardWithoutWarmNode.segmentStats(false, false).getCount() > SEGMENT_COUNT);
        // Before stats
        SegmentsStats segmentsStatsForShard5After = shard5.segmentStats(false, false);
        assertNotNull(shard);
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME_2).setSettings(initiallyDisabledSettings).get());
    @SuppressForbidden(reason = "Sleeping longer than scheduled interval")
import org.opensearch.common.SuppressForbidden;
public class AutoForceMergeManagerIT extends RemoteStoreBaseIntegTestCase {
                .indices()
        internalCluster().startWarmOnlyNodes(1, clusterSettings).getFirst();
import org.opensearch.cluster.metadata.IndexMetadata;
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME_1).get());
        assertBusy(
            1,
        SegmentsStats segmentsStatsForShard3Before = shard3.segmentStats(false, false);
        SegmentsStats segmentsStatsForShard2After = shard2.segmentStats(false, false);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertTrue(totalSegmentsBefore.get() > totalSegmentsAfter.get());
        // refresh to clear old segments
        );
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, supportsDedicatedMasters = false)
        Thread.sleep(TimeValue.parseTimeValue(SCHEDULER_INTERVAL, "test").getMillis() * 3);
        waitUntil(() -> shard4.segmentStats(false, false).getCount() == SEGMENT_COUNT, 1, TimeUnit.MINUTES);
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME_1).setSettings(settings).get());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        internalCluster().startWarmOnlyNodes(1, clusterSettings).getFirst();
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
            .put(NODE_PROCESSORS_SETTING.getKey(), 32)
    public void testAutoForceMergeTriggeringBasicWithOneShard() throws Exception {
        IndexShard shardWithWarmNode = getIndexShard(dataNode, INDEX_NAME_1);
        autoForceMergeManager.getTask().runInternal();
    private static final int NUM_DOCS_IN_BULK = 1000;
        }
 * this file be licensed under the Apache-2.0 license or a
            client().admin()
                        .build()
        Settings clusterSettings = Settings.builder()
        SegmentsStats segmentsStatsForShard5Before = shard5.segmentStats(false, false);
        IndexShard shard1 = getIndexShardFromShardId(dataNode, INDEX_NAME_1, 0);
            .build();
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
            indexBulk(INDEX_NAME_1, NUM_DOCS_IN_BULK);
        for (int i = 0; i < INGESTION_COUNT; i++) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        waitUntil(() -> shard1.segmentStats(false, false).getCount() == SEGMENT_COUNT, 1, TimeUnit.MINUTES);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
}
                .indices()
            .put(super.nodeSettings(0))
        SegmentsStats segmentsStatsAfter = shard.segmentStats(false, false);
import java.util.concurrent.atomic.AtomicLong;
                .get()
        internalTestCluster.startClusterManagerOnlyNode(clusterSettings);
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SETTING.getKey(), false)
                .prepareUpdateSettings(INDEX_NAME_2)
                .get()
        for (int i = 0; i < INGESTION_COUNT; i++) {
        InternalTestCluster internalTestCluster = internalCluster();
                )
            () -> assertTrue(autoForceMergeManager.getShardValidator().validate(shardWithoutWarmNode).isAllowed()),
        SegmentsStats segmentsStatsForShard1Before = shard1.segmentStats(false, false);
            .build();
        assertAcked(
    }
        InternalTestCluster internalTestCluster = internalCluster();
            flushAndRefresh(INDEX_NAME_1);
            )
        flushAndRefresh(INDEX_NAME_1);
            .put(IndexSettings.INDEX_AUTO_FORCE_MERGES_ENABLED.getKey(), false)
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SETTING.getKey(), true)
        Settings settings = Settings.builder()
            flushAndRefresh(INDEX_NAME_1);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 * The OpenSearch Contributors require contributions made to
            .build();
        for (int i = 0; i < INGESTION_COUNT; i++) {
            "Auto force merge did not run while a warm node was present",
        assertTrue(shardWithWarmNode.segmentStats(false, false).getCount() > SEGMENT_COUNT);
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SCHEDULER_INTERVAL.getKey(), SCHEDULER_INTERVAL)
        autoForceMergeManager.getTask().runInternal();
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
            .put(ForceMergeManagerSettings.CPU_THRESHOLD_PERCENTAGE_FOR_AUTO_FORCE_MERGE.getKey(), 100)
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        AtomicLong totalSegmentsBefore = new AtomicLong(
    private static final String TRANSLOG_AGE = "1s";
        SegmentsStats segmentsStatsBefore = shard.segmentStats(false, false);
        assertBusy(
    public void testAutoForceMergeStopsAfterAllWarmNodesAreRemoved() throws Exception {
            .put(ForceMergeManagerSettings.JVM_THRESHOLD_PERCENTAGE_FOR_AUTO_FORCE_MERGE.getKey(), 100)
        assertNotNull(shardWithoutWarmNode);
        internalTestCluster.startClusterManagerOnlyNode(clusterSettings);
            .put(ForceMergeManagerSettings.SEGMENT_COUNT_FOR_AUTO_FORCE_MERGE.getKey(), SEGMENT_COUNT)
        assertBusy(
    }
        waitUntil(() -> shard3.segmentStats(false, false).getCount() == SEGMENT_COUNT, 1, TimeUnit.MINUTES);
                + segmentsStatsForShard4After.getCount() + segmentsStatsForShard5After.getCount()
import java.util.concurrent.ExecutionException;
            .put(ForceMergeManagerSettings.DISK_THRESHOLD_PERCENTAGE_FOR_AUTO_FORCE_MERGE.getKey(), 100)
    private static final String INDEX_NAME_2 = "test-auto-forcemerge-two";
                .prepareCreate(INDEX_NAME_1)
            indexBulk(INDEX_NAME_1, NUM_DOCS_IN_BULK);
    private static final Integer SEGMENT_COUNT = 1;
        assertBusy(() -> assertTrue(autoForceMergeManager.getNodeValidator().validate().isAllowed()), 1, TimeUnit.MINUTES);
        );
            TimeUnit.MINUTES
                    Settings.builder()
        SegmentsStats segmentsStatsForShard3After = shard3.segmentStats(false, false);
                )
        return Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
            flushAndRefresh(INDEX_NAME_2);
        assertTrue(totalSegmentsBefore.get() > 5);
    }
        String dataNode = internalTestCluster.startDataOnlyNodes(1, clusterSettings).getFirst();
            flushAndRefresh(INDEX_NAME_1);
        }
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.core.common.unit.ByteSizeUnit;
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME_1).setSettings(settings).get());
        IndexShard shard = getIndexShard(dataNode, INDEX_NAME_1);
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME_1).get());
            refresh(INDEX_NAME_1);
            indexBulk(INDEX_NAME_2, NUM_DOCS_IN_BULK);
        assertAcked(
        SegmentsStats segmentsStatsBefore = shard.segmentStats(false, false);
        assertTrue(shardWithoutWarmNode.segmentStats(false, false).getCount() > SEGMENT_COUNT);
        assertEquals((int) SEGMENT_COUNT, segmentsStatsAfter.getCount());
        }
            waitUntil(() -> shardWithoutWarmNode.segmentStats(false, false).getCount() == SEGMENT_COUNT, 10, TimeUnit.SECONDS)
        internalCluster().startWarmOnlyNodes(1, clusterSettings).getFirst();
        String dataNode = internalTestCluster.startDataOnlyNodes(1, clusterSettings).getFirst();
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
        waitUntil(() -> shard5.segmentStats(false, false).getCount() == SEGMENT_COUNT, 1, TimeUnit.MINUTES);
