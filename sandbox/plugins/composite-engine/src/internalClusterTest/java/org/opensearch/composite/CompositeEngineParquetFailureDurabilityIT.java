        if (refreshBeforeRestart) {
                CompositeDataFormatPlugin.class,
import java.util.Collection;
import java.util.List;  
import org.opensearch.action.index.IndexResponse;  
        internalCluster().fullRestart();  
        // MismatchedInputException on the parquet primary. Composite rolls back; DFAE
            IndexResponse r = client().prepareIndex(INDEX_NAME).setSource("f1", "v" + i).get();
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
        return Stream.concat(  
        }  
    /** Refresh + flush commits the catalog snapshot; restart restores from commit. */  
        long parquetRows = CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), INDEX_NAME, "parquet");
    }
    public void testRetiredWriterDataSurvivesRestart_refreshOnly() throws Exception {
 * <ul>  
            )  
        if (flushBeforeRestart) {
        long luceneRows = CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), INDEX_NAME, "lucene");
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.FeatureFlags;  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
    public void setUp() throws Exception {
import org.opensearch.core.rest.RestStatus;
        }  
        // Phase 2: suppress the writer's mapping-version updates and add f2 to the live  
        // mapping. The writer's schema stays at v1, so a doc carrying f2 trips
import java.util.stream.Stream;
    @Override
    /** Refresh makes segments searchable but doesn't commit; translog replay still required. */
        ).collect(Collectors.toList());
 * both formats must report exactly {@code N + M} live docs.
    @Override  
import org.opensearch.test.OpenSearchIntegTestCase;  
        super.setUp();
 *       persisted commit.</li>
        final int initialDocs = 5;  
        // more docs with f1 — these go into writer-2.
        ensureGreen(INDEX_NAME);
            IndexResponse r = client().prepareIndex(INDEX_NAME).setSource("f1", "p" + i).get();
 * retires writer-1, indexes M more docs into writer-2, then full-restarts. After restart,  
        // Phase 5: full cluster restart.
 * <p>Cluster: 1 shard, 0 replicas (durability-only test, no replication assertions).  
import org.opensearch.plugins.Plugin;  
import org.opensearch.be.datafusion.DataFusionPlugin;
            .put("index.pluggable.dataformat", "composite")
 *
        BulkItemResponse failed = bulk.getItems()[0];  
 */
            client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
 *   <li>{@code testRetiredWriterDataSurvivesRestart_refreshOnly} — refresh (segments  
        internalCluster().startDataOnlyNode();
                InternalSettingsPlugin.class
        for (int i = 0; i < postRetirementDocs; i++) {
            super.nodePlugins().stream(),
        // whether durability came from the committed catalog snapshot, an in-flight
        assertTrue("oversized-schema doc must surface as a per-item failure: " + failed.getFailureMessage(), failed.isFailed());
        FailableParquetDataFormatPlugin.armSchemaSuppression();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * <p>Three variants exercise different durability paths:
import org.opensearch.be.lucene.LucenePlugin;  
        runDurabilityScenario(/* refreshBeforeRestart= */ true, /* flushBeforeRestart= */ true);
 * </ul>  
 *       translog replay is a no-op past the commit point.</li>
        FailableParquetDataFormatPlugin.clearFailure();  
        FailableParquetDataFormatPlugin.clearFailure();
 */  
    @Override
        FailableParquetDataFormatPlugin.clearFailure();
            .put("index.composite.primary_data_format", "parquet")  
 *
                DataFusionPlugin.class,
 *       (catalog snapshot committed). Restart restores from the committed snapshot;
    }
 *   <li>{@code testRetiredWriterDataSurvivesRestart_translogReplayOnly} — no refresh, no
            .build();  
import org.opensearch.action.bulk.BulkItemResponse;
        assertEquals(1, bulk.getItems().length);
        for (int i = 0; i < initialDocs; i++) {
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        ensureGreen(INDEX_NAME);  
        // segment recovered via translog replay, or pure translog replay.
 * compatible open source license.
    private void runDurabilityScenario(boolean refreshBeforeRestart, boolean flushBeforeRestart) throws Exception {
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
    }
                ArrowBasePlugin.class,  
            assertEquals(RestStatus.CREATED, r.status());  
    private Settings dfaIndexSettings() {  
}  
import org.opensearch.cluster.metadata.IndexMetadata;
/**
        // retires writer-1 and queues its flushed segment in pendingSegments.  
        assertEquals("lucene must hold exactly " + expected + " live docs after restart", expected, luceneRows);
    }  
import java.util.stream.Collectors;
 *
package org.opensearch.composite;
    protected Settings nodeSettings(int nodeOrdinal) {
        runDurabilityScenario(/* refreshBeforeRestart= */ true, /* flushBeforeRestart= */ false);  
        // Phase 3: drop suppression so a fresh writer reconciles to v2 cleanly. Index M  
 *
import org.opensearch.action.bulk.BulkResponse;
        return Settings.builder()  
import org.opensearch.indices.replication.common.ReplicationType;
    /** Restart relies entirely on translog replay — no segments committed pre-restart. */
        // Phase 1: index N docs with f1 into writer-1.
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        final int postRetirementDocs = 3;  
 * full cluster restart, when a writer is retired mid-stream because of a per-doc failure.  
import org.opensearch.test.InternalSettingsPlugin;
        client().admin().indices().preparePutMapping(INDEX_NAME).setSource("f2", "type=keyword").get();
    }
 * Validates durability of the parquet-primary / lucene-secondary composite engine across a
        runDurabilityScenario(/* refreshBeforeRestart= */ false, /* flushBeforeRestart= */ false);
        assertEquals("parquet must hold exactly " + expected + " live docs after restart", expected, parquetRows);  
    }
    }
        super.tearDown();  
            assertEquals(RestStatus.CREATED, r.status());  
            .put("index.pluggable.dataformat.enabled", true)
    @Override  
        }
    private static final String INDEX_NAME = "composite-parquet-durability-idx";
            .put(remoteStoreIndexSettings(0, 1))
    public void testRetiredWriterDataSurvivesRestart_translogReplayOnly() throws Exception {  
        // Phase 6: every successful doc must have survived. Both formats must agree —  
        // Phase 4: optional refresh / flush before restart, per scenario.  
    }  
                LucenePlugin.class,  
            Stream.of(
 *       flush. Restart relies entirely on translog replay rebuilding the segments.</li>
            .build();
        return Settings.builder()
 * <p>Each variant indexes N docs into writer-1, induces a per-doc parquet failure that
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
 *   <li>{@code testRetiredWriterDataSurvivesRestart_refreshAndFlush} — refresh + flush  
    public void testRetiredWriterDataSurvivesRestart_refreshAndFlush() throws Exception {
 * The OpenSearch Contributors require contributions made to  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings()).setMapping("f1", "type=keyword").get();
        }
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
public class CompositeEngineParquetFailureDurabilityIT extends RemoteStoreBaseIntegTestCase {  
 *       searchable, but no commit). Restart still has to replay the translog from the last
        BulkResponse bulk = client().prepareBulk().add(client().prepareIndex(INDEX_NAME).setSource("f2", "value-fail")).get();
/*  
        long expected = initialDocs + postRetirementDocs;  
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
    }
            .put(super.nodeSettings(nodeOrdinal))
                FailableParquetDataFormatPlugin.class,
        internalCluster().startClusterManagerOnlyNode();  
    public void tearDown() throws Exception {
