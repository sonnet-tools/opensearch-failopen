        ensureYellowAndNoInitializingShards(INDEX_NAME);
     * Lucene's docId allocator can't be reversed: after a per-doc IAE the secondary
/*
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            .get();
        DataFormatAwareEngine engine = CompositeEngineHelper.getEngine(clusterService(), internalCluster(), INDEX_NAME);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    private static final int OVERSIZED_TERM_CHARS = 33000;
    }
            .index(INDEX_NAME)
            .indices()
        long parquetRows = CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), INDEX_NAME, "parquet");
 * <p>Two variants cover both branches of {@code LuceneWriter#flush}: without index sort
        assertEquals(RestStatus.CREATED, client().prepareIndex(INDEX_NAME).setSource("field", "v3", "sort_key", 1L).get().status());
            assert p.isActive() : "Primary is not active";
        assertEquals("expected exactly one writer in pool", 1, writers.size());
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
        client().admin()
 * this file be licensed under the Apache-2.0 license or a
        client().admin().indices().prepareFlush(INDEX_NAME).get();
        );
     */
 * (plain force-merge) and with index sort (RowIdMapping-driven reorder merge).
        // Cross-format parity on the primary: 2 successful docs in parquet AND in lucene —
        DataFormatAwareEngine engineAfterFailure = CompositeEngineHelper.getEngine(clusterService(), internalCluster(), INDEX_NAME);
            .setSettings(dfaIndexSettings(withIndexSort))
        IndexResponse ok3 = client().prepareIndex(INDEX_NAME).setSource("field", "value-3", "sort_key", 1L).get();
/**
 */
import org.apache.lucene.index.IndexWriter;
        // Force the GCP sync immediately instead of waiting for the periodic timer — after
    }
    }
        // Doc 1: succeeds.
 * all converge to 2 (the failed doc's seqNo backfilled by a Translog.NoOp), replica
            .prepareCreate(INDEX_NAME)
import org.opensearch.action.index.IndexResponse;
import org.opensearch.test.InternalSettingsPlugin;
            .put(remoteStoreIndexSettings(1, 1))
            assert r.isActive() : "Replica is not active";
import org.opensearch.index.engine.dataformat.WriterState;
     * <p>This test asserts both halves: the writer instance held by the pool after the
            .get();
        String oversized = "x".repeat(OVERSIZED_TERM_CHARS);
     * failure is <b>different</b> from the one before, and the original writer is
    }
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
            .put("index.global_checkpoint_sync.interval", "1s");
            assertEquals("replica processedLCP matches primary", p.getProcessedLocalCheckpoint(), r.getProcessedLocalCheckpoint());
        createIndex(withIndexSort);
        BulkResponse bulk = client().prepareBulk()
import org.opensearch.be.lucene.LucenePlugin;
        runOversizedTermScenario(/* withIndexSort= */ false);
        return Settings.builder()
        BulkItemResponse failed = bulk.getItems()[0];
    }
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            // merge-on-refresh code path is fixed.
 * compatible open source license.
            .put("index.composite.merge_on_refresh_max_size", "0b")
            // LCP covers the gap and processed/persisted both equal maxSeqNo.
 * {@link IllegalArgumentException}. No fault injection — a 33000-char {@code keyword} value
 * The OpenSearch Contributors require contributions made to
            super.nodePlugins().stream(),
            .stream()
        assertTrue("oversized term doc must fail", bulk.getItems()[0].isFailed());
            // Lucene flush down the ReorderingMergePolicy branch.
        assertEquals(RestStatus.CREATED, client().prepareIndex(INDEX_NAME).setSource("field", "v1", "sort_key", 10L).get().status());
        return Stream.concat(
import org.opensearch.common.util.FeatureFlags;
        Writer<?> writerAfter = singleWriter(engine);
            .replicaShards()
            // 30s default timer waiting for the replica to catch up.
    protected Settings nodeSettings(int nodeOrdinal) {
        if (withIndexSort) {
import org.opensearch.common.settings.Settings;
                CompositeDataFormatPlugin.class,
import org.opensearch.index.engine.DataFormatAwareEngine;
 * when Lucene's {@link IndexWriter#MAX_TERM_LENGTH} (32766 UTF-8 bytes) rejects a doc with
            .get();
import org.opensearch.core.rest.RestStatus;
            sb.putList("index.sort.field", "sort_key").putList("index.sort.order", "asc");
        ensureGreen(INDEX_NAME);
import java.util.List;
            IndexShard r = getIndexShard(replicaNodeName(), INDEX_NAME);
        // so an oversized value reaches Lucene's per-term length check verbatim.
    private static Writer<?> singleWriter(DataFormatAwareEngine engine) {
import org.opensearch.parquet.ParquetDataFormatPlugin;
        createIndex(/* withIndexSort= */ false);
 * processedLCP catches up, and parquet/lucene each hold the 2 successful docs.
        internalCluster().startClusterManagerOnlyNode();
    public void testLuceneFailureReplacesWriterAndClosesOldOne() throws Exception {
        getIndexShard(primaryNodeName(), INDEX_NAME).maybeSyncGlobalCheckpoint("post-noop-test-sync");
        // Engine must still be open: an oversized-term IAE is a per-doc rejection, not a
public class CompositeEngineLuceneOversizedTermIT extends RemoteStoreBaseIntegTestCase {
            IndexShard p = getIndexShard(primaryNodeName(), INDEX_NAME);
import org.opensearch.test.OpenSearchIntegTestCase;
    private static final String INDEX_NAME = "composite-lucene-oversized-term-idx";
        assertNotNull("failure message should be present", failed.getFailureMessage());
            assertEquals("primary processedLCP", 2L, p.getProcessedLocalCheckpoint());
    }
import java.util.stream.Stream;
        // Doc 3: succeeds on the same primary — proves the engine and writer pool recovered.
        List<Writer<?>> writers = new ArrayList<>();
        assertEquals("the retired writer must be CLOSED — resources released", WriterState.CLOSED, writerBefore.state());
        // Doc 3 forces the pool to mint a fresh writer (the old one is gone).
    /** 33000 chars > MAX_TERM_LENGTH (32766 bytes); ASCII so byte-length == char-length. */
 */
import java.util.Collection;
        // Doc 2: oversized term → Lucene IAE → RETIRED_FLUSHABLE → DFAE retires + closes.
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            .put("index.pluggable.dataformat.enabled", true)
            .orElseThrow()
        // tragic event. The Lucene secondary writer transitions ACTIVE→PENDING_ROLLBACK, the composite
            .add(client().prepareIndex(INDEX_NAME).setSource("field", oversized, "sort_key", 5L))
import org.opensearch.arrow.allocator.ArrowBasePlugin;
 * <p>Asserts: engine stays open, primary maxSeqNo, processed/persisted LCP, and lastSyncedGCP
     * N-1 docs, closes the writer, queues the segment in pendingSegments). The pool then
        // rolls back the parquet primary, and DFAE retires the writer to RETIRED_FLUSHABLE
                ArrowBasePlugin.class,
import java.util.ArrayList;
        assertBusy(() -> {
        }
import org.opensearch.index.shard.IndexShard;
     * transitions to RETIRED_FLUSHABLE post-rollback, DFAE retires it (flushes the buffered
                DataFusionPlugin.class,
import org.opensearch.action.bulk.BulkItemResponse;
 *
        long luceneRows = CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), INDEX_NAME, "lucene");
import org.opensearch.cluster.metadata.IndexMetadata;
    }
            failed.getFailureMessage().contains("immense term") || failed.getFailureMessage().contains("max length")
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import java.util.stream.Collectors;
import org.opensearch.be.datafusion.DataFusionPlugin;
        assertEquals(RestStatus.CREATED, ok1.status());
            // Tighten the periodic GCP sync so the post-failover assertion doesn't race a
        assertEquals(RestStatus.CREATED, ok3.status());
     * mints a fresh writer for the next doc.
        // replication request, and we want to assert state quickly.
        // keyword field with default ignore_above forwards the entire string as one token,
        return sb.build();
        IndexResponse ok1 = client().prepareIndex(INDEX_NAME).setSource("field", "value-1", "sort_key", 10L).get();
            .setMapping("field", "type=keyword", "sort_key", "type=long")
import org.opensearch.indices.replication.common.ReplicationType;
        engine.getWriterPool().forEach(writers::add);
            .filter(s -> s.started())
            .add(client().prepareIndex(INDEX_NAME).setSource("field", oversized, "sort_key", 5L))
            .findFirst()
        BulkResponse bulk = client().prepareBulk()
        internalCluster().startDataOnlyNodes(2);
        Settings.Builder sb = Settings.builder()
    private Settings dfaIndexSettings(boolean withIndexSort) {
        // (its buffered N-1 docs flushed into pendingSegments). The engine remains usable —
    private String replicaNodeName() {
        assertNotNull("engine must still hold a valid commit after per-doc IAE", engineAfterFailure.commitStats());
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
     * <b>closed</b> (state == CLOSED — its IndexWriter, Directory, and temp dir released).
        // a non-trivial RowIdMapping permutation rather than the identity case.
        Writer<?> writerBefore = singleWriter(engine);
package org.opensearch.composite;
        // remains open, the bulk item surfaces as a per-doc failure.
        // the failed doc contributed neither a parquet row nor a lucene live doc.
 * trips the limit naturally.
    private void runOversizedTermScenario(boolean withIndexSort) throws Exception {
import java.util.concurrent.TimeUnit;
        return getClusterState().nodes().get(nodeId).getName();
    @Override
            assertEquals("primary persistedLCP", 2L, p.getLocalCheckpoint());
    public void testOversizedTermProducesNoOpAndEngineStaysHealthy() throws Exception {
    private String primaryNodeName() {
 *
            .build();
        runOversizedTermScenario(/* withIndexSort= */ true);
            .put("index.pluggable.dataformat", "composite")
import org.opensearch.plugins.Plugin;
    private void createIndex(boolean withIndexSort) {
        assertEquals(1, bulk.getItems().length);
            "failure should mention immense term: " + failed.getFailureMessage(),
        // IllegalArgumentException from termsHashPerField.add — no tragic event, IndexWriter
        assertNotSame("Lucene retirement must replace the writer instance in the pool", writerBefore, writerAfter);
                InternalSettingsPlugin.class
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.index.engine.dataformat.Writer;
    }
    @Override
        assertEquals("lucene must hold exactly 2 successful docs", 2L, luceneRows);
        // the NoOp + flush there are no further indexing ops to piggyback the new GCP onto a
            .currentNodeId();
        assertTrue("oversized term doc must fail: " + failed.getFailureMessage(), failed.isFailed());
        String nodeId = getClusterState().routingTable()
            // Sequence-number bookkeeping: 3 ops attempted (seq 0, 1, 2). The failed doc 2 was
 * SPDX-License-Identifier: Apache-2.0
        // Doc 2: a single oversized keyword token. Lucene's IndexingChain throws
            )
        // sort_key=1 is less than doc 1's sort_key=10, so the index-sort variant exercises
        // commitStats() throws AlreadyClosedException if the engine has failed/closed.
            // TODO: Remove the merge_on_refresh_max_size=0b override once the thread leak in the
    }
                ParquetDataFormatPlugin.class,
                LucenePlugin.class,
        return getClusterState().nodes().get(nodeId).getName();
 *
        internalCluster().startDataOnlyNodes(2);
            assertEquals("primary maxSeqNo", 2L, p.seqNoStats().getMaxSeqNo());
            assertEquals("primary lastSyncedGCP catches up to LCP", p.getLocalCheckpoint(), p.getLastSyncedGlobalCheckpoint());
        ).collect(Collectors.toList());
        internalCluster().startClusterManagerOnlyNode();
        assertTrue(
            .put("index.composite.primary_data_format", "parquet")
            // Forces parquet to compute a RowIdMapping on flush, which drives the secondary
        // Doc 1 mints writer-1 in the pool.
    }
    public void testOversizedTermWithIndexSortProducesNoOpAndEngineStaysHealthy() throws Exception {
        assertEquals("parquet must hold exactly 2 successful docs", 2L, parquetRows);
            .shard(0)
import org.opensearch.action.bulk.BulkResponse;
 * Exercises the per-doc failure path on a parquet-primary / lucene-secondary composite index
}
    }
    /**
        return writers.get(0);
            Stream.of(
     *
            // backfilled by a Translog.NoOp at DataFormatAwareEngine.indexIntoEngine, so the
        }, 30, TimeUnit.SECONDS);
        String oversized = "x".repeat(OVERSIZED_TERM_CHARS);
        assertEquals("the new writer must be ACTIVE", WriterState.ACTIVE, writerAfter.state());
