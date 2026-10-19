            .put(super.nodeSettings(nodeOrdinal))  
     * <b>same writer instance</b>. This validates that ACTIVE post-rollback prevents
            assertEquals("primary maxSeqNo", 2L, p.seqNoStats().getMaxSeqNo());  
     * After a parquet self-rollback (Failure → state PENDING_ROLLBACK → composite drives rollback →
public class CompositeEngineParquetFailureCheckpointIT extends RemoteStoreBaseIntegTestCase {
            super.nodePlugins().stream(),  
        // to the index mapping — the writer's schema stays at v1, so a doc carrying f2 will
                CompositeDataFormatPlugin.class,
        assertEquals(RestStatus.CREATED, client().prepareIndex(INDEX_NAME).setSource("f1", "v1").get().status());  
import org.opensearch.index.engine.DataFormatAwareEngine;
        }, 30, TimeUnit.SECONDS);
            .filter(s -> s.started())  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    public void setUp() throws Exception {  
            assert r.isActive() : "Replica is not active";
 *       {@link org.opensearch.parquet.writer.MismatchedInputException} (no {@code f2} vector  
        // the live mapping cleanly. Then drop suppression so future mapping updates propagate.  
    private Settings dfaIndexSettings() {
    private static Writer<?> singleWriter(DataFormatAwareEngine engine) {  
     */  
        String nodeId = getClusterState().routingTable()
        Writer<?> writerAfter = singleWriter(engine);  
        long parquetRows = CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), INDEX_NAME, "parquet");
        super.tearDown();
        super.setUp();
            .put("index.composite.primary_data_format", "parquet")
package org.opensearch.composite;
 * compatible open source license.
        FailableParquetDataFormatPlugin.armSchemaSuppression();
        FailableParquetDataFormatPlugin.armSchemaSuppression();  
 * <ol>  
 * Exercises the parquet-primary self-rollback path end-to-end. Sequence:
    }
        client().admin().indices().prepareFlush(INDEX_NAME).get();  
import org.opensearch.indices.replication.common.ReplicationType;  
        Writer<?> writerBefore = singleWriter(engine);  
    private String replicaNodeName() {  
        IndexResponse ok1 = client().prepareIndex(INDEX_NAME).setSource("f1", "value-1").get();  
        // Engine must still be open: MismatchedInputException is per-doc, not tragic.  
                LucenePlugin.class,
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        // raises MismatchedInputException. ParquetWriter.addDoc catches it, briefly  
            .put("index.pluggable.dataformat", "composite")
    @Override  
import org.opensearch.index.engine.dataformat.WriterState;
        DataFormatAwareEngine engine = CompositeEngineHelper.getEngine(clusterService(), internalCluster(), INDEX_NAME);
        client().admin().indices().prepareFlush(INDEX_NAME).get();
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings()).setMapping("f1", "type=keyword").get();
        List<Writer<?>> writers = new ArrayList<>();
 *   <li>Clear suppression. Doc 3 with {@code f1} succeeds on the new writer (no schema
            assertEquals("primary processedLCP", 2L, p.getProcessedLocalCheckpoint());
     * unnecessary writer churn for fully-reversible failure modes.
 * converge to 2 (failed doc backfilled by Translog.NoOp), replica processedLCP catches up,
    }
        assertEquals(RestStatus.CREATED, ok1.status());
        // commitStats() throws AlreadyClosedException if the engine has failed/closed.
        // Suppress the parquet writer's mapping-version updates. Then add a new field f2  
import org.opensearch.be.lucene.LucenePlugin;  
import java.util.List;
        internalCluster().startClusterManagerOnlyNode();
        assertEquals("expected exactly one writer in pool", 1, writers.size());  
        // Flush the v1-schema writer out so doc 3 mints a fresh writer that reconciles to
import org.opensearch.index.shard.IndexShard;
    @Override
 * </ol>
        client().admin().indices().preparePutMapping(INDEX_NAME).setSource("f2", "type=keyword").get();
import java.util.concurrent.TimeUnit;  
        return getClusterState().nodes().get(nodeId).getName();  
 * this file be licensed under the Apache-2.0 license or a
        IndexResponse ok3 = client().prepareIndex(INDEX_NAME).setSource("f1", "value-3").get();  
        internalCluster().startDataOnlyNodes(2);  
        BulkResponse bulk = client().prepareBulk().add(client().prepareIndex(INDEX_NAME).setSource("f2", "value-2")).get();  
    }
        // Doc 1 with the original mapping (just f1) — succeeds.
            .orElseThrow()
import org.opensearch.common.util.FeatureFlags;  
import org.opensearch.plugins.Plugin;
/*  
 *   <li>Arm {@link FailableParquetDataFormatPlugin#armSchemaSuppression()} and add a new
        long luceneRows = CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), INDEX_NAME, "lucene");
 */  
}  
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
import java.util.stream.Stream;
        BulkResponse bulk = client().prepareBulk().add(client().prepareIndex(INDEX_NAME).setSource("f2", "x")).get();  
        ensureGreen(INDEX_NAME);  
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            )
import java.util.ArrayList;  
 *       on the active VSR). {@code ParquetWriter.addDoc} catches it (state PENDING_ROLLBACK → returns
            assertEquals("primary persistedLCP", 2L, p.getLocalCheckpoint());
        BulkItemResponse failed = bulk.getItems()[0];
        return getClusterState().nodes().get(nodeId).getName();
    }
import org.opensearch.test.OpenSearchIntegTestCase;
        engine.getWriterPool().forEach(writers::add);
        // proves the engine survives a per-doc parquet failure and continues serving writes.
import org.opensearch.index.engine.dataformat.Writer;  
    }
        FailableParquetDataFormatPlugin.clearFailure();
            .put(remoteStoreIndexSettings(1, 1))
    }  
import org.opensearch.action.bulk.BulkItemResponse;
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        FailableParquetDataFormatPlugin.clearFailure();
            Stream.of(
        // hit VSRManager.addDocument with no ParquetField mapping and the production code
/**
 *       no-ops in the VSR (since the doc never landed) and restores ACTIVE.</li>  
 *
            .build();
 * The OpenSearch Contributors require contributions made to  
            assertEquals("replica processedLCP matches primary", p.getProcessedLocalCheckpoint(), r.getProcessedLocalCheckpoint());
        FailableParquetDataFormatPlugin.clearFailure();
            .index(INDEX_NAME)
        assertEquals("parquet must hold exactly 2 successful docs", 2L, parquetRows);  
        assertBusy(() -> {
 *       field {@code f2} via put-mapping. The parquet writer's mapping-version update is  
    }  
            .put("index.global_checkpoint_sync.interval", "1s")  
import org.opensearch.be.datafusion.DataFusionPlugin;
        DataFormatAwareEngine engineAfterFailure = CompositeEngineHelper.getEngine(clusterService(), internalCluster(), INDEX_NAME);
 *
    }
    private static final String INDEX_NAME = "composite-parquet-failure-idx";
                FailableParquetDataFormatPlugin.class,  
        // Doc 1 mints writer-1 in the pool.
            // Tighten the periodic GCP sync so the post-failure assertion doesn't race a
            assert p.isActive() : "Primary is not active";
            .shard(0)  
        internalCluster().startClusterManagerOnlyNode();
        return Settings.builder()  
    @Override  
    }  
        return writers.get(0);
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings()).setMapping("f1", "type=keyword").get();
        // → composite rollback → state restored to ACTIVE (no flush, no retire).  
            .putList("index.composite.secondary_data_formats", List.of("lucene"))  
        internalCluster().startDataOnlyNodes(2);  
        // Doc 3 with f1 (already in every schema version) succeeds on the fresh writer —
        return Stream.concat(
        // Doc 3 (f1, schema v1-compatible) must land on the same writer instance.
import java.util.stream.Collectors;
            .replicaShards()
        // transitions to PENDING_ROLLBACK, runs rollbackLastDoc (no-op against the VSR since the doc
import org.opensearch.action.index.IndexResponse;  
                InternalSettingsPlugin.class
import java.util.Collection;
            .findFirst()
import org.opensearch.test.InternalSettingsPlugin;  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        assertEquals(RestStatus.CREATED, ok3.status());
 */  
            IndexShard p = getIndexShard(primaryNodeName(), INDEX_NAME);
import org.opensearch.core.rest.RestStatus;
 * <p>Asserts: engine stays open, primary maxSeqNo, processed/persisted LCP, and lastSyncedGCP  
        // Force a parquet self-rollback: suppression + new field → MismatchedInputException
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            // 30s default timer waiting for the replica to catch up.
 *   <li>Doc 1 with field {@code f1} succeeds.</li>
                DataFusionPlugin.class,  
        client().admin().indices().preparePutMapping(INDEX_NAME).setSource("f2", "type=keyword").get();
                ArrowBasePlugin.class,
 *   <li>Flush — retires the v1 writer, drains pending segments, mints a fresh writer.</li>
        FailableParquetDataFormatPlugin.clearFailure();
        assertEquals("writer must still be ACTIVE after self-rollback", WriterState.ACTIVE, writerAfter.state());  
    public void tearDown() throws Exception {  
        return Settings.builder()
    @Override
    public void testParquetSelfRollbackKeepsSameWriterInPool() throws Exception {
    protected Settings nodeSettings(int nodeOrdinal) {
        assertSame("parquet self-rollback must keep the same writer instance in the pool", writerBefore, writerAfter);
import org.opensearch.action.bulk.BulkResponse;
            .build();
 * SPDX-License-Identifier: Apache-2.0
            .currentNodeId();  
            IndexShard r = getIndexShard(replicaNodeName(), INDEX_NAME);  
        assertTrue("must surface per-item failure", bulk.getItems()[0].isFailed());
            assertEquals("primary lastSyncedGCP catches up to LCP", p.getLocalCheckpoint(), p.getLastSyncedGlobalCheckpoint());  
 *   <li>Doc 2 carries {@code f2}. {@code VSRManager.addDocument} raises
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
 * and parquet/lucene each hold the 2 successful docs.
 *       mismatch since {@code f1} is in every schema version).</li>  
 *       {@code WriteResult.Failure}), the composite drives {@code rollbackLastDoc} which
        // never landed), restores ACTIVE, and returns WriteResult.Failure.
        assertNotNull("engine must still hold a valid commit after parquet per-doc failure", engineAfterFailure.commitStats());  
import org.opensearch.cluster.metadata.IndexMetadata;
        getIndexShard(primaryNodeName(), INDEX_NAME).maybeSyncGlobalCheckpoint("post-failure-test-sync");
        ).collect(Collectors.toList());  
        assertEquals("lucene must hold exactly 2 successful docs", 2L, luceneRows);
        assertNotNull("failure message should be present", failed.getFailureMessage());
        assertEquals(1, bulk.getItems().length);
    private String primaryNodeName() {
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
        ensureGreen(INDEX_NAME);  
import org.opensearch.common.settings.Settings;
    public void testParquetAddDocFailureSelfRollsAndCheckpointsConverge() throws Exception {
    /**
            .stream()
        assertTrue("doc 2 must surface as a per-item failure: " + failed.getFailureMessage(), failed.isFailed());  
            .put("index.pluggable.dataformat.enabled", true)  
    }
        assertEquals(RestStatus.CREATED, client().prepareIndex(INDEX_NAME).setSource("f1", "v3").get().status());
     * state ACTIVE), the writer should remain in the pool and the next doc must land on the  
 *       dropped, so its schema stays at v1.</li>
