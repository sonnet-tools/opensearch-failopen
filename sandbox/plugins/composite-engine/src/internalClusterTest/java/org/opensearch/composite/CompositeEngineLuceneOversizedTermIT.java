            assertEquals("primary persistedLCP", 2L, p.getLocalCheckpoint());
        ).collect(Collectors.toList());
        // Engine must still be open: an oversized-term IAE is a per-doc rejection, not a  
        assertBusy(() -> {  
            .put("index.composite.merge_on_refresh_max_size", "0b")
import org.opensearch.index.engine.dataformat.Writer;
        long luceneRows = CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), INDEX_NAME, "lucene");  
            .put("index.pluggable.dataformat.enabled", true)
            .get();
            "failure should mention immense term: " + failed.getFailureMessage(),
        assertEquals("the new writer must be ACTIVE", WriterState.ACTIVE, writerAfter.state());  
        // the NoOp + flush there are no further indexing ops to piggyback the new GCP onto a
import org.opensearch.index.shard.IndexShard;  
    }
        assertEquals(RestStatus.CREATED, client().prepareIndex(INDEX_NAME).setSource("field", "v1", "sort_key", 10L).get().status());  
        return writers.get(0);
            .replicaShards()  
        Settings.Builder sb = Settings.builder()
                CompositeDataFormatPlugin.class,  
                ArrowBasePlugin.class,
            // 30s default timer waiting for the replica to catch up.
        client().admin().indices().prepareFlush(INDEX_NAME).get();
     *
        String nodeId = getClusterState().routingTable()  
        return Settings.builder()
        assertEquals(1, bulk.getItems().length);  
import org.opensearch.index.engine.dataformat.WriterState;
        // rolls back the parquet primary, and DFAE retires the writer to RETIRED_FLUSHABLE
            // Lucene flush down the ReorderingMergePolicy branch.
            .setMapping("field", "type=keyword", "sort_key", "type=long")  
    }  
import java.util.ArrayList;
/**  
    }
            assertEquals("primary processedLCP", 2L, p.getProcessedLocalCheckpoint());  
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            .add(client().prepareIndex(INDEX_NAME).setSource("field", oversized, "sort_key", 5L))
            .put("index.global_checkpoint_sync.interval", "1s");
            failed.getFailureMessage().contains("immense term") || failed.getFailureMessage().contains("max length")  
import java.util.stream.Stream;
        createIndex(withIndexSort);
        // keyword field with default ignore_above forwards the entire string as one token,  
 * {@link IllegalArgumentException}. No fault injection — a 33000-char {@code keyword} value  
        assertNotNull("failure message should be present", failed.getFailureMessage());  
    /** 33000 chars > MAX_TERM_LENGTH (32766 bytes); ASCII so byte-length == char-length. */
        assertEquals("expected exactly one writer in pool", 1, writers.size());  
    public void testOversizedTermWithIndexSortProducesNoOpAndEngineStaysHealthy() throws Exception {
 *
        BulkResponse bulk = client().prepareBulk()  
    protected Settings nodeSettings(int nodeOrdinal) {  
        assertEquals(RestStatus.CREATED, ok3.status());  
 * The OpenSearch Contributors require contributions made to  
                ParquetDataFormatPlugin.class,
 *
}  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
        assertEquals("parquet must hold exactly 2 successful docs", 2L, parquetRows);
            // Forces parquet to compute a RowIdMapping on flush, which drives the secondary
    }
        // Doc 3 forces the pool to mint a fresh writer (the old one is gone).  
        IndexResponse ok1 = client().prepareIndex(INDEX_NAME).setSource("field", "value-1", "sort_key", 10L).get();
import java.util.Collection;  
            .indices()  
            .currentNodeId();
            // Sequence-number bookkeeping: 3 ops attempted (seq 0, 1, 2). The failed doc 2 was
    public void testOversizedTermProducesNoOpAndEngineStaysHealthy() throws Exception {  
        runOversizedTermScenario(/* withIndexSort= */ true);
import org.opensearch.arrow.allocator.ArrowBasePlugin;
import java.util.stream.Collectors;  
        }, 30, TimeUnit.SECONDS);
        ensureGreen(INDEX_NAME);  
            .put(super.nodeSettings(nodeOrdinal))
        assertEquals(RestStatus.CREATED, client().prepareIndex(INDEX_NAME).setSource("field", "v3", "sort_key", 1L).get().status());
    private Settings dfaIndexSettings(boolean withIndexSort) {
import org.opensearch.action.bulk.BulkResponse;  
            )
        // remains open, the bulk item surfaces as a per-doc failure.
            IndexShard r = getIndexShard(replicaNodeName(), INDEX_NAME);
 * (plain force-merge) and with index sort (RowIdMapping-driven reorder merge).
import org.opensearch.test.InternalSettingsPlugin;
            .filter(s -> s.started())
            assert p.isActive() : "Primary is not active";  
            Stream.of(  
            .setSettings(dfaIndexSettings(withIndexSort))
 * <p>Two variants cover both branches of {@code LuceneWriter#flush}: without index sort  
    }  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        Writer<?> writerBefore = singleWriter(engine);  
    private static final int OVERSIZED_TERM_CHARS = 33000;  
import org.opensearch.common.settings.Settings;  
    }  
import org.opensearch.cluster.metadata.IndexMetadata;
        BulkResponse bulk = client().prepareBulk()
        // so an oversized value reaches Lucene's per-term length check verbatim.
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
 * <p>Asserts: engine stays open, primary maxSeqNo, processed/persisted LCP, and lastSyncedGCP  
 */  
        client().admin()
        return getClusterState().nodes().get(nodeId).getName();  
    }  
            .stream()
            // TODO: Remove the merge_on_refresh_max_size=0b override once the thread leak in the  
    }  
        String oversized = "x".repeat(OVERSIZED_TERM_CHARS);
        IndexResponse ok3 = client().prepareIndex(INDEX_NAME).setSource("field", "value-3", "sort_key", 1L).get();
     * Lucene's docId allocator can't be reversed: after a per-doc IAE the secondary  
    }
import org.opensearch.be.lucene.LucenePlugin;
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
            .findFirst()  
    @Override
     * failure is <b>different</b> from the one before, and the original writer is  
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.opensearch.plugins.Plugin;  
            assert r.isActive() : "Replica is not active";
                InternalSettingsPlugin.class  
    }
            .build();
 * when Lucene's {@link IndexWriter#MAX_TERM_LENGTH} (32766 UTF-8 bytes) rejects a doc with
    private static Writer<?> singleWriter(DataFormatAwareEngine engine) {  
import java.util.concurrent.TimeUnit;
     * <p>This test asserts both halves: the writer instance held by the pool after the
        engine.getWriterPool().forEach(writers::add);
        assertNotSame("Lucene retirement must replace the writer instance in the pool", writerBefore, writerAfter);
        internalCluster().startDataOnlyNodes(2);
    private void createIndex(boolean withIndexSort) {
            .get();  
            // backfilled by a Translog.NoOp at DataFormatAwareEngine.indexIntoEngine, so the  
     * transitions to RETIRED_FLUSHABLE post-rollback, DFAE retires it (flushes the buffered
            .put("index.pluggable.dataformat", "composite")  
        }
            assertEquals("primary maxSeqNo", 2L, p.seqNoStats().getMaxSeqNo());
 *
        // Doc 3: succeeds on the same primary — proves the engine and writer pool recovered.
        assertEquals("lucene must hold exactly 2 successful docs", 2L, luceneRows);
     * <b>closed</b> (state == CLOSED — its IndexWriter, Directory, and temp dir released).
            // merge-on-refresh code path is fixed.
import org.opensearch.core.rest.RestStatus;
        );
 * Exercises the per-doc failure path on a parquet-primary / lucene-secondary composite index
 * SPDX-License-Identifier: Apache-2.0
            .put(remoteStoreIndexSettings(1, 1))  
package org.opensearch.composite;
import org.opensearch.parquet.ParquetDataFormatPlugin;
    private String primaryNodeName() {  
import org.opensearch.be.datafusion.DataFusionPlugin;  
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        // Doc 2: a single oversized keyword token. Lucene's IndexingChain throws
        // (its buffered N-1 docs flushed into pendingSegments). The engine remains usable —  
import org.opensearch.action.index.IndexResponse;
    private void runOversizedTermScenario(boolean withIndexSort) throws Exception {
        internalCluster().startClusterManagerOnlyNode();  
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
            .orElseThrow()
        getIndexShard(primaryNodeName(), INDEX_NAME).maybeSyncGlobalCheckpoint("post-noop-test-sync");
            // Tighten the periodic GCP sync so the post-failover assertion doesn't race a  
            IndexShard p = getIndexShard(primaryNodeName(), INDEX_NAME);
            .add(client().prepareIndex(INDEX_NAME).setSource("field", oversized, "sort_key", 5L))
    public void testLuceneFailureReplacesWriterAndClosesOldOne() throws Exception {  
 */  
        runOversizedTermScenario(/* withIndexSort= */ false);
            assertEquals("replica processedLCP matches primary", p.getProcessedLocalCheckpoint(), r.getProcessedLocalCheckpoint());  
            assertEquals("primary lastSyncedGCP catches up to LCP", p.getLocalCheckpoint(), p.getLastSyncedGlobalCheckpoint());
        // IllegalArgumentException from termsHashPerField.add — no tragic event, IndexWriter  
     * mints a fresh writer for the next doc.  
    @Override
                DataFusionPlugin.class,
     * N-1 docs, closes the writer, queues the segment in pendingSegments). The pool then
        assertEquals(RestStatus.CREATED, ok1.status());  
        if (withIndexSort) {  
        // replication request, and we want to assert state quickly.  
            .get();
        assertEquals("the retired writer must be CLOSED — resources released", WriterState.CLOSED, writerBefore.state());
            .shard(0)
import org.opensearch.common.util.FeatureFlags;
        // a non-trivial RowIdMapping permutation rather than the identity case.
    private static final String INDEX_NAME = "composite-lucene-oversized-term-idx";
        long parquetRows = CompositeEngineHelper.getRowCount(clusterService(), internalCluster(), INDEX_NAME, "parquet");
        assertTrue("oversized term doc must fail", bulk.getItems()[0].isFailed());
        return getClusterState().nodes().get(nodeId).getName();
        assertTrue("oversized term doc must fail: " + failed.getFailureMessage(), failed.isFailed());
import org.opensearch.action.bulk.BulkItemResponse;
import org.apache.lucene.index.IndexWriter;
 * all converge to 2 (the failed doc's seqNo backfilled by a Translog.NoOp), replica
    private String replicaNodeName() {
import java.util.List;
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
import org.opensearch.indices.replication.common.ReplicationType;
        List<Writer<?>> writers = new ArrayList<>();
        // tragic event. The Lucene secondary writer transitions ACTIVE→PENDING_ROLLBACK, the composite
        // Force the GCP sync immediately instead of waiting for the periodic timer — after
        DataFormatAwareEngine engine = CompositeEngineHelper.getEngine(clusterService(), internalCluster(), INDEX_NAME);
     */
    }
            .prepareCreate(INDEX_NAME)
        return Stream.concat(
 * processedLCP catches up, and parquet/lucene each hold the 2 successful docs.
        internalCluster().startDataOnlyNodes(2);
        // sort_key=1 is less than doc 1's sort_key=10, so the index-sort variant exercises  
        String oversized = "x".repeat(OVERSIZED_TERM_CHARS);  
        // commitStats() throws AlreadyClosedException if the engine has failed/closed.
        assertNotNull("engine must still hold a valid commit after per-doc IAE", engineAfterFailure.commitStats());  
            sb.putList("index.sort.field", "sort_key").putList("index.sort.order", "asc");  
public class CompositeEngineLuceneOversizedTermIT extends RemoteStoreBaseIntegTestCase {
        DataFormatAwareEngine engineAfterFailure = CompositeEngineHelper.getEngine(clusterService(), internalCluster(), INDEX_NAME);
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        // the failed doc contributed neither a parquet row nor a lucene live doc.
 * trips the limit naturally.
        BulkItemResponse failed = bulk.getItems()[0];
    /**
        createIndex(/* withIndexSort= */ false);  
        assertTrue(
        return sb.build();
        internalCluster().startClusterManagerOnlyNode();
 * compatible open source license.
        // Cross-format parity on the primary: 2 successful docs in parquet AND in lucene —  
import org.opensearch.test.OpenSearchIntegTestCase;  
            super.nodePlugins().stream(),
        Writer<?> writerAfter = singleWriter(engine);  
        // Doc 1 mints writer-1 in the pool.
            .put("index.composite.primary_data_format", "parquet")
        // Doc 2: oversized term → Lucene IAE → RETIRED_FLUSHABLE → DFAE retires + closes.
        // Doc 1: succeeds.
            // LCP covers the gap and processed/persisted both equal maxSeqNo.
            .index(INDEX_NAME)
import org.opensearch.index.engine.DataFormatAwareEngine;  
                LucenePlugin.class,
