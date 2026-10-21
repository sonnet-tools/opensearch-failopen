    }
 * <p>Uses {@link FailableLuceneDataFormatPlugin} to inject a Directory-level fault that makes
        internalCluster().startNode();
            DataFusionPlugin.class,
                break;
        );
        );
        + "writer lock is left held on the engine-failure path. The shard never recovers, so ensureGreen times "
    @Override
            try {
    @AwaitsFix(bugUrl = "Intermittent deadlock: after the injected engine failure, a scheduled refresh thread parks "
    public void setUp() throws Exception {
            Netty4ModulePlugin.class
 *
    /**
            "post-recovery parquet new docs tracked",
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        FailableLuceneDataFormatPlugin.failOnNthWrite(3);
     */
        // IndexWriter tragic, which fails the engine. The shard is then reallocated and
        FailableLuceneDataFormatPlugin.clearFailure();
            FailableLuceneDataFormatPlugin.class,
        StatsITHelpers.assertCounterAtLeast(
        StatsITHelpers.assertCounter(
    }
            postIndexL,
        StatsITHelpers.assertCounter("happy lucene merge_failures", happyL, "indices." + idx + ".merge.merge_failures", 0L);
        return false;
     * 4. New indexing after recovery is tracked correctly.
        + "permanently in LockablePool.checkoutAll (blocking ReentrantLock.lock with no timeout) because a "
        // Start a single node to minimize interference with the JVM-wide failure countdown.
            happyP,
 * <p>Note: this test does NOT assert that {@code docs_indexed_failures} ticks during the failed
        createCompositeIndex(idx, true);
        refreshIndex(idx);
 *
     * 3. After shard recovery, stats endpoint is functional and failure counters are 0
    public void testTrackerLifecycleAroundEngineFailure() throws Exception {
    }
        StatsITHelpers.assertCounter(
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
 * subsequent indexing tracked correctly.
            20L
        // A new engine is created with a fresh stats tracker.
            "post-recovery lucene merge_failures must be 0",
        for (int i = 50; i < 70; i++) {
            "indices." + idx + ".indexing.docs_indexed_total",
        StatsITHelpers.assertCounter(
 *
        // Stage 4 — after recovery, stats endpoint must be functional with clean counters.
            happyL,
import org.opensearch.be.datafusion.DataFusionPlugin;
                client().prepareIndex(idx).setSource("name", "injection_" + i, "value", i).get();
 * deterministic assertion on the failure-counter increment is racy. The lifecycle invariants
/*
public class StatsFailureIT extends AbstractCompositeEngineIT {
import org.opensearch.parquet.ParquetDataFormatPlugin;
 * compatible open source license.
        Map<String, Object> happyL = StatsITHelpers.luceneIndexStats(getRestClient(), idx);
import java.util.Arrays;
    public void tearDown() throws Exception {
        Map<String, Object> postIndexL = StatsITHelpers.luceneIndexStats(getRestClient(), idx);
            "indices." + idx + ".merge.merge_failures",
            postRecoveryL,
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            "happy parquet native_write_failures",
 * tested here are the higher-value safety net: orphan trackers and double-counting bugs would
    }
            } catch (Exception expected) {
    @Override
            ArrowBasePlugin.class,
}
    }
 * indexing operations. The Directory-level fault makes the engine tragic before all per-doc
            0L
            0L
            20L
import java.util.concurrent.TimeUnit;
        FailableLuceneDataFormatPlugin.clearFailure();
            ParquetDataFormatPlugin.class,
        refreshIndex(idx);
        );
                // Engine failure causes indexing exceptions — expected.
        // Stage 1 — happy path: index 50 docs, refresh, assert all *_failures == 0.
        );
        // the new tracker starts fresh.
        super.tearDown();
import java.util.Collection;
        indexDocs(idx, 20, 100);
    @Override
        // recovered on the same node.
            CompositeDataFormatPlugin.class,
        );
        indexDocs(idx, 50, 0);
        // Stage 3 — wait for shard recovery. After the engine fails, the shard is reallocated.
            "indices." + idx + ".native_write.native_write_failures",
        );
        // Stage 5 — new indexing after recovery is tracked correctly.
     * 2. Inject a Directory-level fault that causes the engine to fail.
 */
            "post-recovery new docs tracked",
 * the IndexWriter tragic, fails the engine, and forces a shard recovery. The test then verifies
import org.opensearch.plugins.Plugin;
/**
        Map<String, Object> postRecoveryL = StatsITHelpers.luceneIndexStats(getRestClient(), idx);
        StatsITHelpers.assertCounter("happy parquet merge_failures", happyP, "indices." + idx + ".merge.merge_failures", 0L);
        // Swap LucenePlugin out for FailableLuceneDataFormatPlugin so we can inject failures.
            postIndexP,
import java.util.Map;
    protected boolean addMockHttpTransport() {
        // Stage 2 — inject a Directory-level fault. The IOException during flush makes the
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> postIndexP = StatsITHelpers.parquetIndexStats(getRestClient(), idx);
            "indices." + idx + ".indexing.docs_indexed_failures",
     *    (proving the old tracker was properly unregistered and a fresh one registered).
        }
 *
 * fresh one for the new engine, with all failure counters at zero on the recovered tracker and
        FailableLuceneDataFormatPlugin.clearFailure();
        Map<String, Object> happyP = StatsITHelpers.parquetIndexStats(getRestClient(), idx);
            postRecoveryL,
     * 1. Happy path: all *_failures counters are 0 after successful indexing.
    @Override
package org.opensearch.composite;
 * that the per-format provider registry properly unregisters the dead tracker and registers a
 * @opensearch.experimental
        StatsITHelpers.assertCounter(
            "indices." + idx + ".indexing.docs_indexed_failures",
 */
        + "Re-enable once checkoutAll uses a bounded tryLock or the failure path releases writer locks.")
            0L
        String idx = "failure-idx";
 * failures necessarily flow through the {@code LuceneWriter.addDoc()} catch block, so a
 * this file be licensed under the Apache-2.0 license or a
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
            "happy lucene docs_indexed_failures",
        assertBusy(() -> ensureGreen(idx), 30, TimeUnit.SECONDS);
            "indices." + idx + ".indexing.docs_indexed_total",
        StatsITHelpers.assertCounterAtLeast(
            }
 * Integration tests for stats tracker lifecycle around DFA engine failure.
        + "out. Root cause is in DataFormatAwareEngine.refresh / LockablePool (server), not in stats. "
        // The old tracker (which may have seen the failure) was unregistered on engine close;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        );
            "post-recovery lucene docs_indexed_failures must be 0",
import org.opensearch.transport.Netty4ModulePlugin;
        super.setUp();
 * surface as non-zero counters on the post-recovery tracker.
            0L
     * Verifies stats tracker lifecycle around engine failure and recovery:
        return Arrays.asList(
