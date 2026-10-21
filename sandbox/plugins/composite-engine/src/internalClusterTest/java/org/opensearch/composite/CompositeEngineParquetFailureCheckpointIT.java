            .shard(0)
 *   <li>Doc 2 carries {@code f2}. {@code VSRManager.addDocument} raises
import java.util.concurrent.TimeUnit;
     * <b>same writer instance</b>. This validates that ACTIVE post-rollback prevents
        getIndexShard(primaryNodeName(), INDEX_NAME).maybeSyncGlobalCheckpoint("post-failure-test-sync");
        assertTrue("must surface per-item failure", bulk.getItems()[0].isFailed());
        // Doc 1 mints writer-1 in the pool.
        FailableParquetDataFormatPlugin.clearFailure();
 * SPDX-License-Identifier: Apache-2.0
    public void setUp() throws Exception {
 *   <li>Arm {@link FailableParquetDataFormatPlugin#armSchemaSuppression()} and add a new
        BulkItemResponse failed = bulk.getItems()[0];
        engine.getWriterPool().forEach(writers::add);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        FailableParquetDataFormatPlugin.armSchemaSuppression();
                ArrowBasePlugin.class,
            .build();
        BulkResponse bulk = client().prepareBulk().add(client().prepareIndex(INDEX_NAME).setSource("f2", "value-2")).get();
        FailableParquetDataFormatPlugin.clearFailure();
        assertNotNull("failure message should be present", failed.getFailureMessage());
    /**
            assert r.isActive() : "Replica is not active";
        return getClusterState().nodes().get(nodeId).getName();
            .put(super.nodeSettings(nodeOrdinal))
            .put("index.global_checkpoint_sync.interval", "1s")
     * state ACTIVE), the writer should remain in the pool and the next doc must land on the
        // never landed), restores ACTIVE, and returns WriteResult.Failure.
        // Force a parquet self-rollback: suppression + new field → MismatchedInputException
import java.util.stream.Collectors;
        assertSame("parquet self-rollback must keep the same writer instance in the pool", writerBefore, writerAfter);
    @Override
 *
        // Doc 3 with f1 (already in every schema version) succeeds on the fresh writer —
        // → composite rollback → state restored to ACTIVE (no flush, no retire).
        return Settings.builder()
import java.util.Collection;
        // Engine must still be open: MismatchedInputException is per-doc, not tragic.
        super.setUp();
 */
        assertEquals("expected exactly one writer in pool", 1, writers.size());
        client().admin().indices().preparePutMapping(INDEX_NAME).setSource("f2", "type=keyword").get();
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
 *   <li>Flush — retires the v1 writer, drains pending segments, mints a fresh writer.</li>
        Writer<?> writerBefore = singleWriter(engine);
        // to the index mapping — the writer's schema stays at v1, so a doc carrying f2 will
    }
    public void testParquetSelfRollbackKeepsSameWriterInPool() throws Exception {
import org.opensearch.test.OpenSearchIntegTestCase;
        super.tearDown();
 * The OpenSearch Contributors require contributions made to
        // proves the engine survives a per-doc parquet failure and continues serving writes.
    }
 *       no-ops in the VSR (since the doc never landed) and restores ACTIVE.</li>
                FailableParquetDataFormatPlugin.class,
            assertEquals("primary maxSeqNo", 2L, p.seqNoStats().getMaxSeqNo());
        assertEquals("parquet must hold exactly 2 successful docs", 2L, parquetRows);
        assertNotNull("engine must still hold a valid commit after parquet per-doc failure", engineAfterFailure.commitStats());
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.action.index.IndexResponse;
    protected Settings nodeSettings(int nodeOrdinal) {
    private static final String INDEX_NAME = "composite-parquet-failure-idx";
            super.nodePlugins().stream(),
        assertEquals(RestStatus.CREATED, ok1.status());
        IndexResponse ok1 = client().prepareIndex(INDEX_NAME).setSource("f1", "value-1").get();
        Writer<?> writerAfter = singleWriter(engine);
package org.opensearch.composite;
            .currentNodeId();
 *
            .put("index.composite.primary_data_format", "parquet")
        // Doc 1 with the original mapping (just f1) — succeeds.
import org.opensearch.indices.replication.common.ReplicationType;
     */
 *       on the active VSR). {@code ParquetWriter.addDoc} catches it (state PENDING_ROLLBACK → returns
/**
import java.util.stream.Stream;
        internalCluster().startClusterManagerOnlyNode();
            Stream.of(
    @Override
     * After a parquet self-rollback (Failure → state PENDING_ROLLBACK → composite drives rollback →
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        assertTrue("doc 2 must surface as a per-item failure: " + failed.getFailureMessage(), failed.isFailed());
    private Settings dfaIndexSettings() {
    }
            .put("index.pluggable.dataformat", "composite")
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        // Doc 3 (f1, schema v1-compatible) must land on the same writer instance.
        return Settings.builder()
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        assertBusy(() -> {
            )
    }
        FailableParquetDataFormatPlugin.clearFailure();
import org.opensearch.index.engine.DataFormatAwareEngine;
    }
        // transitions to PENDING_ROLLBACK, runs rollbackLastDoc (no-op against the VSR since the doc
            .put(remoteStoreIndexSettings(1, 1))
 * and parquet/lucene each hold the 2 successful docs.
import java.util.List;
 *   <li>Doc 1 with field {@code f1} succeeds.</li>
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        return Stream.concat(
        return writers.get(0);
        // the live mapping cleanly. Then drop suppression so future mapping updates propagate.
            .findFirst()
                InternalSettingsPlugin.class
import java.util.ArrayList;
    @Override
        // Flush the v1-schema writer out so doc 3 mints a fresh writer that reconciles to
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("lucene must hold exactly 2 successful docs", 2L, luceneRows);
    public void tearDown() throws Exception {
 *       field {@code f2} via put-mapping. The parquet writer's mapping-version update is
            // 30s default timer waiting for the replica to catch up.
        ensureGreen(INDEX_NAME);
        internalCluster().startDataOnlyNodes(2);
        // raises MismatchedInputException. ParquetWriter.addDoc catches it, briefly
            .build();
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings()).setMapping("f1", "type=keyword").get();
                CompositeDataFormatPlugin.class,
    }
 * </ol>
            .orElseThrow()
        assertEquals("writer must still be ACTIVE after self-rollback", WriterState.ACTIVE, writerAfter.state());
        ensureGreen(INDEX_NAME);
public class CompositeEngineParquetFailureCheckpointIT extends RemoteStoreBaseIntegTestCase {
    private String primaryNodeName() {
        // commitStats() throws AlreadyClosedException if the engine has failed/closed.
            .stream()
    }
import org.opensearch.index.engine.dataformat.Writer;
     * unnecessary writer churn for fully-reversible failure modes.
 * Exercises the parquet-primary self-rollback path end-to-end. Sequence:
        DataFormatAwareEngine engineAfterFailure = CompositeEngineHelper.getEngine(clusterService(), internalCluster(), INDEX_NAME);
        assertEquals(1, bulk.getItems().length);
        assertEquals(RestStatus.CREATED, ok3.status());
            assertEquals("primary lastSyncedGCP catches up to LCP", p.getLocalCheckpoint(), p.getLastSyncedGlobalCheckpoint());
        }, 30, TimeUnit.SECONDS);
 *       mismatch since {@code f1} is in every schema version).</li>
        assertEquals(RestStatus.CREATED, client().prepareIndex(INDEX_NAME).setSource("f1", "v3").get().status());
            assertEquals("primary persistedLCP", 2L, p.getLocalCheckpoint());
                LucenePlugin.class,
/*
            .filter(s -> s.started())
import org.opensearch.plugins.Plugin;
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.action.bulk.BulkItemResponse;
        // hit VSRManager.addDocument with no ParquetField mapping and the production code
        client().admin().indices().prepareFlush(INDEX_NAME).get();
        client().admin().indices().preparePutMapping(INDEX_NAME).setSource("f2", "type=keyword").get();
        DataFormatAwareEngine engine = CompositeEngineHelper.getEngine(clusterService(), internalCluster(), INDEX_NAME);
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings()).setMapping("f1", "type=keyword").get();
            IndexShard r = getIndexShard(replicaNodeName(), INDEX_NAME);
    private static Writer<?> singleWriter(DataFormatAwareEngine engine) {
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.core.rest.RestStatus;
        return getClusterState().nodes().get(nodeId).getName();
            .put("index.pluggable.dataformat.enabled", true)
 * <p>Asserts: engine stays open, primary maxSeqNo, processed/persisted LCP, and lastSyncedGCP
        FailableParquetDataFormatPlugin.armSchemaSuppression();
    }
 *   <li>Clear suppression. Doc 3 with {@code f1} succeeds on the new writer (no schema
import org.opensearch.be.lucene.LucenePlugin;
 */
    @Override
        BulkResponse bulk = client().prepareBulk().add(client().prepareIndex(INDEX_NAME).setSource("f2", "x")).get();
            .index(INDEX_NAME)
        assertEquals(RestStatus.CREATED, client().prepareIndex(INDEX_NAME).setSource("f1", "v1").get().status());
        long luceneRows = CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), INDEX_NAME, "lucene");
import org.opensearch.cluster.metadata.IndexMetadata;
        client().admin().indices().prepareFlush(INDEX_NAME).get();
            assertEquals("replica processedLCP matches primary", p.getProcessedLocalCheckpoint(), r.getProcessedLocalCheckpoint());
        ensureYellowAndNoInitializingShards(INDEX_NAME);
    public void testParquetAddDocFailureSelfRollsAndCheckpointsConverge() throws Exception {
import org.opensearch.index.engine.dataformat.WriterState;
            assert p.isActive() : "Primary is not active";
            .replicaShards()
    private String replicaNodeName() {
        IndexResponse ok3 = client().prepareIndex(INDEX_NAME).setSource("f1", "value-3").get();
        ).collect(Collectors.toList());
        internalCluster().startDataOnlyNodes(2);
        // Suppress the parquet writer's mapping-version updates. Then add a new field f2
    }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.common.settings.Settings;
            // Tighten the periodic GCP sync so the post-failure assertion doesn't race a
 * converge to 2 (failed doc backfilled by Translog.NoOp), replica processedLCP catches up,
            assertEquals("primary processedLCP", 2L, p.getProcessedLocalCheckpoint());
 *       dropped, so its schema stays at v1.</li>
}
import org.opensearch.test.InternalSettingsPlugin;
import org.opensearch.index.shard.IndexShard;
        List<Writer<?>> writers = new ArrayList<>();
                DataFusionPlugin.class,
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
import org.opensearch.common.util.FeatureFlags;
 *       {@code WriteResult.Failure}), the composite drives {@code rollbackLastDoc} which
        FailableParquetDataFormatPlugin.clearFailure();
import org.opensearch.be.datafusion.DataFusionPlugin;
    }
 *       {@link org.opensearch.parquet.writer.MismatchedInputException} (no {@code f2} vector
            IndexShard p = getIndexShard(primaryNodeName(), INDEX_NAME);
 * compatible open source license.
        String nodeId = getClusterState().routingTable()
 * <ol>
        long parquetRows = CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), INDEX_NAME, "parquet");
