package org.opensearch.composite;
    @Override
 * <p>Each variant indexes N docs into writer-1, induces a per-doc parquet failure that
        runDurabilityScenario(/* refreshBeforeRestart= */ false, /* flushBeforeRestart= */ false);
        super.tearDown();
        BulkResponse bulk = client().prepareBulk().add(client().prepareIndex(INDEX_NAME).setSource("f2", "value-fail")).get();
 *   <li>{@code testRetiredWriterDataSurvivesRestart_refreshOnly} — refresh (segments
 * this file be licensed under the Apache-2.0 license or a
            .put(super.nodeSettings(nodeOrdinal))
        ensureGreen(INDEX_NAME);
 * <ul>
        assertTrue("oversized-schema doc must surface as a per-item failure: " + failed.getFailureMessage(), failed.isFailed());
        runDurabilityScenario(/* refreshBeforeRestart= */ true, /* flushBeforeRestart= */ true);
import org.opensearch.arrow.allocator.ArrowBasePlugin;
                FailableParquetDataFormatPlugin.class,
        assertEquals("parquet must hold exactly " + expected + " live docs after restart", expected, parquetRows);
    }
            client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
        // mapping. The writer's schema stays at v1, so a doc carrying f2 trips
import org.opensearch.test.InternalSettingsPlugin;
        }
        }
            .put("index.pluggable.dataformat.enabled", true)
        if (flushBeforeRestart) {
            .put("index.composite.primary_data_format", "parquet")
        FailableParquetDataFormatPlugin.armSchemaSuppression();
                DataFusionPlugin.class,
            Stream.of(
        FailableParquetDataFormatPlugin.clearFailure();
        FailableParquetDataFormatPlugin.clearFailure();
 *
    }
    }
 * retires writer-1, indexes M more docs into writer-2, then full-restarts. After restart,
import java.util.List;
        FailableParquetDataFormatPlugin.clearFailure();
        internalCluster().fullRestart();
            .build();
        if (refreshBeforeRestart) {
        // Phase 2: suppress the writer's mapping-version updates and add f2 to the live
 *
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
 *       searchable, but no commit). Restart still has to replay the translog from the last
        // whether durability came from the committed catalog snapshot, an in-flight
        long expected = initialDocs + postRetirementDocs;
import org.opensearch.cluster.metadata.IndexMetadata;
 * SPDX-License-Identifier: Apache-2.0
    /** Refresh + flush commits the catalog snapshot; restart restores from commit. */
        long parquetRows = CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), INDEX_NAME, "parquet");
        assertEquals(1, bulk.getItems().length);
        // Phase 3: drop suppression so a fresh writer reconciles to v2 cleanly. Index M
 * </ul>
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * The OpenSearch Contributors require contributions made to
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        long luceneRows = CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), INDEX_NAME, "lucene");
                CompositeDataFormatPlugin.class,
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import org.opensearch.action.bulk.BulkItemResponse;
 *       flush. Restart relies entirely on translog replay rebuilding the segments.</li>
}
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
    private static final String INDEX_NAME = "composite-parquet-durability-idx";
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings()).setMapping("f1", "type=keyword").get();
        return Settings.builder()
                InternalSettingsPlugin.class
    @Override
        // more docs with f1 — these go into writer-2.
 *       translog replay is a no-op past the commit point.</li>
    public void tearDown() throws Exception {
import java.util.Collection;
    protected Settings nodeSettings(int nodeOrdinal) {
    public void setUp() throws Exception {
 * full cluster restart, when a writer is retired mid-stream because of a per-doc failure.
            .build();
 * <p>Cluster: 1 shard, 0 replicas (durability-only test, no replication assertions).
 *
 *       (catalog snapshot committed). Restart restores from the committed snapshot;
        assertEquals("lucene must hold exactly " + expected + " live docs after restart", expected, luceneRows);
            assertEquals(RestStatus.CREATED, r.status());
 *   <li>{@code testRetiredWriterDataSurvivesRestart_translogReplayOnly} — no refresh, no
        internalCluster().startDataOnlyNode();
 *   <li>{@code testRetiredWriterDataSurvivesRestart_refreshAndFlush} — refresh + flush
        // Phase 1: index N docs with f1 into writer-1.
 */
            super.nodePlugins().stream(),
public class CompositeEngineParquetFailureDurabilityIT extends RemoteStoreBaseIntegTestCase {
        final int postRetirementDocs = 3;
import java.util.stream.Collectors;
import org.opensearch.indices.replication.common.ReplicationType;
        client().admin().indices().preparePutMapping(INDEX_NAME).setSource("f2", "type=keyword").get();
        // retires writer-1 and queues its flushed segment in pendingSegments.
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
    @Override
    /** Restart relies entirely on translog replay — no segments committed pre-restart. */
        }
 * both formats must report exactly {@code N + M} live docs.
        for (int i = 0; i < postRetirementDocs; i++) {
            IndexResponse r = client().prepareIndex(INDEX_NAME).setSource("f1", "v" + i).get();
import org.opensearch.core.rest.RestStatus;
import org.opensearch.be.lucene.LucenePlugin;
        // Phase 6: every successful doc must have survived. Both formats must agree —
    /** Refresh makes segments searchable but doesn't commit; translog replay still required. */
            assertEquals(RestStatus.CREATED, r.status());
    }
import java.util.stream.Stream;
            .put(remoteStoreIndexSettings(0, 1))
        for (int i = 0; i < initialDocs; i++) {
        BulkItemResponse failed = bulk.getItems()[0];
            .put("index.pluggable.dataformat", "composite")
        ensureGreen(INDEX_NAME);
    }
    public void testRetiredWriterDataSurvivesRestart_refreshAndFlush() throws Exception {
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.common.settings.Settings;
        // MismatchedInputException on the parquet primary. Composite rolls back; DFAE
 * Validates durability of the parquet-primary / lucene-secondary composite engine across a
 * compatible open source license.
 *       persisted commit.</li>
    private void runDurabilityScenario(boolean refreshBeforeRestart, boolean flushBeforeRestart) throws Exception {
                ArrowBasePlugin.class,
        final int initialDocs = 5;
    }
        // Phase 4: optional refresh / flush before restart, per scenario.
    private Settings dfaIndexSettings() {
import org.opensearch.action.index.IndexResponse;
    }
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.test.OpenSearchIntegTestCase;
/*
        runDurabilityScenario(/* refreshBeforeRestart= */ true, /* flushBeforeRestart= */ false);
    @Override
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        return Settings.builder()
 * <p>Three variants exercise different durability paths:
    public void testRetiredWriterDataSurvivesRestart_refreshOnly() throws Exception {
        super.setUp();
            IndexResponse r = client().prepareIndex(INDEX_NAME).setSource("f1", "p" + i).get();
        // segment recovered via translog replay, or pure translog replay.
    }
    public void testRetiredWriterDataSurvivesRestart_translogReplayOnly() throws Exception {
 *
        ).collect(Collectors.toList());
/**
                LucenePlugin.class,
        }
 */
            )
        // Phase 5: full cluster restart.
        return Stream.concat(
import org.opensearch.be.datafusion.DataFusionPlugin;
import org.opensearch.plugins.Plugin;
import org.opensearch.common.util.FeatureFlags;
    }
