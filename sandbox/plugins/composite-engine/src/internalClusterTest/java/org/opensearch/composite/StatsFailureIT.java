        StatsITHelpers.assertCounterAtLeast(
        // recovered on the same node.
     * 1. Happy path: all *_failures counters are 0 after successful indexing.
        Map<String, Object> happyL = StatsITHelpers.luceneIndexStats(getRestClient(), idx);
import java.util.Collection;
        indexDocs(idx, 20, 100);
            } catch (Exception expected) {  
    }  
 * SPDX-License-Identifier: Apache-2.0
                break;
            "indices." + idx + ".indexing.docs_indexed_total",
 * failures necessarily flow through the {@code LuceneWriter.addDoc()} catch block, so a
        // Start a single node to minimize interference with the JVM-wide failure countdown.
            }  
 * indexing operations. The Directory-level fault makes the engine tragic before all per-doc  
        indexDocs(idx, 50, 0);
 * <p>Uses {@link FailableLuceneDataFormatPlugin} to inject a Directory-level fault that makes
                // Engine failure causes indexing exceptions — expected.
 *
 * that the per-format provider registry properly unregisters the dead tracker and registers a
}
            0L
import java.util.Map;
        StatsITHelpers.assertCounter(  
        FailableLuceneDataFormatPlugin.clearFailure();
        for (int i = 50; i < 70; i++) {  
        );
        StatsITHelpers.assertCounter(  
        FailableLuceneDataFormatPlugin.failOnNthWrite(3);
    protected boolean addMockHttpTransport() {  
            "happy lucene docs_indexed_failures",
import java.util.concurrent.TimeUnit;  
            0L
        assertBusy(() -> ensureGreen(idx), 30, TimeUnit.SECONDS);  
            happyL,
        Map<String, Object> postIndexL = StatsITHelpers.luceneIndexStats(getRestClient(), idx);
 * compatible open source license.
        );
        // the new tracker starts fresh.
/*  
            postRecoveryL,
            Netty4ModulePlugin.class
        // Stage 4 — after recovery, stats endpoint must be functional with clean counters.
        StatsITHelpers.assertCounterAtLeast(  
import org.opensearch.arrow.allocator.ArrowBasePlugin;
 * this file be licensed under the Apache-2.0 license or a
        // Stage 5 — new indexing after recovery is tracked correctly.
        // Swap LucenePlugin out for FailableLuceneDataFormatPlugin so we can inject failures.  
        FailableLuceneDataFormatPlugin.clearFailure();
 * Integration tests for stats tracker lifecycle around DFA engine failure.  
            "indices." + idx + ".merge.merge_failures",  
        // Stage 3 — wait for shard recovery. After the engine fails, the shard is reallocated.
        // A new engine is created with a fresh stats tracker.
        internalCluster().startNode();
 * the IndexWriter tragic, fails the engine, and forces a shard recovery. The test then verifies  
        // Stage 1 — happy path: index 50 docs, refresh, assert all *_failures == 0.  
import org.opensearch.be.datafusion.DataFusionPlugin;
        + "writer lock is left held on the engine-failure path. The shard never recovers, so ensureGreen times "  
        super.setUp();
        + "permanently in LockablePool.checkoutAll (blocking ReentrantLock.lock with no timeout) because a "
     *    (proving the old tracker was properly unregistered and a fresh one registered).
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        );
        Map<String, Object> happyP = StatsITHelpers.parquetIndexStats(getRestClient(), idx);  
            ArrowBasePlugin.class,
     * Verifies stats tracker lifecycle around engine failure and recovery:  
            ParquetDataFormatPlugin.class,  
    @Override
            CompositeDataFormatPlugin.class,
        refreshIndex(idx);
            try {
 * deterministic assertion on the failure-counter increment is racy. The lifecycle invariants
 */
            "indices." + idx + ".native_write.native_write_failures",
 *
public class StatsFailureIT extends AbstractCompositeEngineIT {  
        + "out. Root cause is in DataFormatAwareEngine.refresh / LockablePool (server), not in stats. "
            postIndexL,
     */  
            happyP,
            FailableLuceneDataFormatPlugin.class,
            0L  
        + "Re-enable once checkoutAll uses a bounded tryLock or the failure path releases writer locks.")
            postIndexP,
        StatsITHelpers.assertCounter(
import java.util.Arrays;  
            DataFusionPlugin.class,  
            postRecoveryL,
    @Override
            20L
        // The old tracker (which may have seen the failure) was unregistered on engine close;  
            0L
            20L  
            "post-recovery parquet new docs tracked",
        );
import org.opensearch.transport.Netty4ModulePlugin;
        // IndexWriter tragic, which fails the engine. The shard is then reallocated and  
 * surface as non-zero counters on the post-recovery tracker.
        }
    @Override
 * <p>Note: this test does NOT assert that {@code docs_indexed_failures} ticks during the failed
        createCompositeIndex(idx, true);
            "happy parquet native_write_failures",  
        );
        );
 *
            "indices." + idx + ".indexing.docs_indexed_total",  
/**
     * 2. Inject a Directory-level fault that causes the engine to fail.
        return Arrays.asList(
        FailableLuceneDataFormatPlugin.clearFailure();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 *
        StatsITHelpers.assertCounter("happy parquet merge_failures", happyP, "indices." + idx + ".merge.merge_failures", 0L);
        StatsITHelpers.assertCounter("happy lucene merge_failures", happyL, "indices." + idx + ".merge.merge_failures", 0L);  
        Map<String, Object> postIndexP = StatsITHelpers.parquetIndexStats(getRestClient(), idx);
    }  
 * fresh one for the new engine, with all failure counters at zero on the recovered tracker and
import org.opensearch.plugins.Plugin;
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
            "post-recovery lucene docs_indexed_failures must be 0",
 * subsequent indexing tracked correctly.  
     * 3. After shard recovery, stats endpoint is functional and failure counters are 0  
        refreshIndex(idx);  
    }  
    }
        String idx = "failure-idx";  
 * tested here are the higher-value safety net: orphan trackers and double-counting bugs would  
    public void tearDown() throws Exception {  
 * @opensearch.experimental  
package org.opensearch.composite;
        StatsITHelpers.assertCounter(  
     * 4. New indexing after recovery is tracked correctly.
        );
import org.opensearch.parquet.ParquetDataFormatPlugin;  
            "indices." + idx + ".indexing.docs_indexed_failures",  
        Map<String, Object> postRecoveryL = StatsITHelpers.luceneIndexStats(getRestClient(), idx);
    @AwaitsFix(bugUrl = "Intermittent deadlock: after the injected engine failure, a scheduled refresh thread parks "
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
    public void setUp() throws Exception {  
    /**
        super.tearDown();
            "post-recovery lucene merge_failures must be 0",
        // Stage 2 — inject a Directory-level fault. The IOException during flush makes the
            "post-recovery new docs tracked",  
            "indices." + idx + ".indexing.docs_indexed_failures",  
    }  
        return false;
    public void testTrackerLifecycleAroundEngineFailure() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
    @Override
                client().prepareIndex(idx).setSource("name", "injection_" + i, "value", i).get();
 */  
