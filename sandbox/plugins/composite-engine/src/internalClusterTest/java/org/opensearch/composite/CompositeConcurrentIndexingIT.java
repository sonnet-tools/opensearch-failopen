        // Count actual parquet files on disk
            client().admin().indices().prepareRefresh(indexName).get();  
            .putList("index.composite.secondary_data_formats", "lucene")
        indexer.join(60_000);
                            .get();
        // 1 flush thread
                IndexShard s = getIndexShard(node, shardId, indexName);  
                            .setSource("name", "t" + threadId + "_d" + d, "value", threadId * 100 + d)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                    Thread.sleep(randomIntBetween(100, 300));
/**  
        long totalRows = 0;
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
                    }  
        IndicesStatsResponse statsResponse = client().admin().indices().prepareStats(indexName).clear().setMerge(true).get();
        } finally {
                t.join(30_000);
            .put("index.pluggable.dataformat.enabled", true)  
                                .get();
                                    raceDetected.incrementAndGet();  
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
                        client().admin().indices().prepareRefresh(indexName).get();
            if (ss.getShardRouting().primary() == false) {
     * Bulk indexing with refresh=wait_for alongside merge-on-refresh.
        }  
        refresher.start();
            }
                } catch (InterruptedException e) {
        refresher.join(60_000);
            .get();
                        // with a stale name; once the next deletion sweep runs that file is gone.
            threads[t] = new Thread(() -> {
import org.opensearch.cluster.metadata.IndexMetadata;  
                } catch (Exception e) {  
    public void testMergeOnRefreshDisabledWithSortedIndex() throws Exception {
        assertEquals("Total rows across all shards of " + indexName + " must match indexed docs", expectedTotalDocs, totalRows);
        int cycles = 5;
                try {
            assertFalse("Thread did not finish in time: " + t.getName(), t.isAlive());
 * <p>Run with:
                        // on disk. A refresh racing inside flush() leaves the committed snapshot  
        AtomicInteger forceMergeCount = new AtomicInteger(0);
    }
        Thread forceMerger = new Thread(() -> {  
            client().admin().indices().prepareRefresh(idx).get();
                        // must (a) be non-null and (b) reference a segments_<N> that is still
            assertFalse("Thread did not finish in time: " + t.getName(), t.isAlive());
        for (Thread t : indexers)
            .putList("index.sort.missing", "_last")
        int docsPerThread = 20;  
        assertEquals(0, failures.get());
                    for (int d = 0; d < docsPerThread; d++) {
            } catch (Exception ignore) {}
                    break;
                    indexedCount.incrementAndGet();  
                    client().prepareIndex().setIndex(indexName).setSource("name", "idx2_" + i, "value", i + 1000).get();
                    } catch (Exception e) {  
                }
        client().admin().indices().prepareRefresh(indexName).get();
        // Clean up  
            .put("index.composite.merge_on_refresh_max_size", "10mb")  
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
        }
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
        }, "force-merger");
                }  
        // Single refresh triggers merge-on-refresh  
        }
     *
                try {
        merger.join(10_000);
        ensureGreen(indexName);
        for (Thread t : flushers)  
                                Set<String> diskFiles = new HashSet<>(Arrays.asList(primary.store().directory().listAll()));
                } catch (InterruptedException e) {  
        client().admin().indices().prepareDelete(indexName).get();
            Thread[] threads = new Thread[threadsPerCycle];
                }
                        for (int d = 0; d < docsPerThread; d++) {  
                        indexedCount.incrementAndGet();
            .get();
        for (String node : internalCluster().getDataNodeNames()) {
        }
            .put("index.refresh_interval", "1s")  
            threads[t].start();
        }  
        // Verify all data is present  
        // Verify background merge actually ran  
        int numIndexers = 4;
                                .setIndex(indexName)
import org.opensearch.index.engine.exec.WriterFileSet;  
                        client().prepareIndex()
        CyclicBarrier barrier = new CyclicBarrier(totalThreads);  
        }
     * Concurrent force merge + indexing + explicit refresh on unsorted index.
                            .setIndex(indexName)  
        CyclicBarrier barrier = new CyclicBarrier(numIndexers + numFlushers + numRefreshers);
        client().admin().indices().prepareDelete(indexName).get();
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
        for (Thread t : flushers)
                try {
                    client().admin().indices().prepareDelete(idx).get();
            try {
            threads[t] = new Thread(() -> {
            .get();
    private Settings mergeOnRefreshDisabledSortedSettings() {
                } catch (Exception e) {
                }  
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
        long totalMerges = statsResponse.getIndex(indexName).getTotal().getMerge().getTotal();
     * Multiple refresh cycles each produce 1 consolidated segment via merge-on-refresh.
                try {
    protected Settings nodeSettings(int nodeOrdinal) {
        Thread[] threads = new Thread[numThreads];  
        for (Thread t : threads) {  
            .prepareCreate(indexName)
                    barrier.await();
            for (int t = 0; t < threadsPerIndex; t++) {  
        int flushesPerThread = 8;
     * <p>The test pushes high contention with multiple parallel indexer + flusher + refresher  
     */
                WriterFileSet wfs = seg.dfGroupedSearchableFiles().get("parquet");
        int docsPerThread = 10;  
    // ══════════════════════════════════════════════════════════════════════
            .get();  
 * Integration test for concurrent indexing across multiple indices and shards
        java.nio.file.Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
                            .setSource("name", "t" + threadId + "_d" + d, "value", randomIntBetween(0, 500))
    }
        for (int t = 0; t < numRefreshers; t++) {
        }
 *
                            try {  
        client().admin().indices().prepareRefresh(indexName).get();
                                .setIndex(indexName)  
    public void testMergeOnRefreshWithAutoRefreshEnabled() throws Exception {  
                Function.identity()
            indexers[t] = new Thread(() -> {  
    }
            .setMapping("name", "type=keyword", "value", "type=integer")
                    failures.incrementAndGet();  
                        Thread.sleep(randomIntBetween(10, 40));
            .get();
        AtomicInteger failures = new AtomicInteger(0);
        Thread flusher = new Thread(() -> {  
        int cycles = 5;
                    // Expected during concurrent operations
                    Thread.sleep(randomIntBetween(50, 200));  
        ensureGreen(indexName);
import org.opensearch.index.engine.exec.Segment;
        }
                } catch (Exception e) {
            t.start();  
import org.opensearch.be.lucene.LucenePlugin;
                            .get();  
                    primaryShard = s;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2)  
import org.opensearch.plugins.Plugin;  
        for (Thread t : refreshers)  
            DataFusionPlugin.class  
        }
        IndexShard primaryShard = null;  
                    }
        // Indexer thread: indexes docs and triggers explicit refreshes periodically  
                "Commit data should contain catalog snapshot for shard " + ss.getShardRouting().shardId(),
            try {
        String nodeName = getClusterState().routingTable().index(indexName).shard(0).primaryShard().currentNodeId();
import org.opensearch.parquet.ParquetDataFormatPlugin;
        for (int cycle = 0; cycle < cycles; cycle++) {
            try {
    }
                    "Duplicate generation " + seg.generation() + " in shard " + ss.getShardRouting().shardId(),
    // ══════════════════════════════════════════════════════════════════════
                try {  
        // Resolve the primary shard once — used by flushers to read back commit-state invariant
     * Concurrent indexing with merge-on-refresh enabled (Parquet + Lucene).  
        AtomicInteger failures = new AtomicInteger(0);
        // With merge-on-refresh disabled, each writer produces its own segment
import org.opensearch.core.rest.RestStatus;
            .indices()
        forceMerger.interrupt();
            }  
    // Merge-on-refresh disabled (baseline) tests  
        Thread[] threads = new Thread[numThreads];  
     * Verifies no deadlock or data loss under continuous auto-refresh + merge-on-refresh.
            assertFalse("Catalog must reference at least one parquet file", catalogFiles.isEmpty());  
                assertFalse("Thread hung", t.isAlive());  
                .collect(java.util.stream.Collectors.toSet());
            ArrowBasePlugin.class,
        ensureGreen(indexName);
                        logger.error("Indexing failed in thread " + threadId, e);
        client().admin().indices().prepareDelete(indexName).get();
            } catch (Exception e) {  
                .setSettings(indexSettings(numShards))
     * use the same IndexWriter and refreshLock — this test ensures they don't deadlock.
                    for (int d = 0; d < docsPerThread; d++) {
        String indexName = "merge-auto-refresh";
import java.util.Set;
                            .get();
            assertFalse("Thread did not finish in time: " + t.getName(), t.isAlive());  
            .setSettings(mergeOnRefreshAutoRefreshSettings())  
        String indexName = "merge-on-refresh-disabled";
        for (int t = 0; t < numThreads; t++) {
                    client().prepareIndex(indexName).setSource("name", "doc_" + i, "value", i).get();
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
        }
                    failures.incrementAndGet();
    /**
                    totalRows += primaryWfs.numRows();
     * which may trigger merge-on-refresh if multiple writers flushed.  
        // Clean up  
            .setSettings(mergeOnRefreshDisabledSortedSettings())
            .prepareCreate(indexName)
            for (int t = 0; t < threadsPerCycle; t++) {
            }, "mor-sorted-indexer-" + t);
 * correctly handles concurrent document writes, refresh, flush, and merge across
            .put("index.composite.primary_data_format", "parquet")
                        }  
        merger.start();
            assertNotNull("Commit stats should exist for shard " + ss.getShardRouting().shardId(), commitStats);  
            .put("index.composite.primary_data_format", "parquet")
        // Verify each index  
                    // index may not exist
     */
        ensureGreen(indexName);
        verifyIndex(indexName, 1, totalDocs);
        return Settings.builder()
                .get();
                        // Direct invariant: the just-committed snapshot's lastCommitFileName
        int docsPerThread = randomIntBetween(20, 50);  
            .setSettings(indexSettings(numShards))  
                    } catch (Exception e) {  
        Thread[] flushers = new Thread[numFlushers];
        int numFlushers = 3;
        int totalDocs = numThreads * docsPerThread;  
            }
                }  
     * commit file that actually exists on disk — the direct invariant the {@code refreshLock}  
                            .setSource("name", "t" + threadId + "_d" + d, "value", threadId * 100 + d)
    private Settings indexSettings(int numShards) {
        client().admin().indices().prepareForceMerge(indexName).setMaxNumSegments(1).get();
        }
        assertEquals("No indexing threads should have failed", 0, failures.get());
        verifyIndex(indexName, 1, totalDocs);
        try {
     */
                        for (int d = 0; d < docsPerThread; d++) {
                            .setIndex(indexName)
                threads[threadId].start();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    @Override
        for (Thread t : threads) {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     * Background merge will eventually consolidate them with RowIdMapping.  
                    if (i % 10 == 0) {
        String indexName = "merge-coexistence";
        indexer1.join(60_000);
     * After inline merge, only the merged file should remain — the source per-writer files
    public void testConcurrentFlushAndRefreshHoldsRefreshLock() throws Exception {  
            .put("index.pluggable.dataformat.enabled", true)
                barrier.await();  
import org.opensearch.common.util.FeatureFlags;  
        return Settings.builder()  
            }  
     * fix protects.
            threads[t] = new Thread(() -> {
            threads[t] = new Thread(() -> {
        try (var stream = java.nio.file.Files.list(parquetDir)) {
            .prepareCreate(indexName)
        ensureGreen(indexName);
        // Collect all parquet files referenced by the catalog
            }, "auto-refresh-indexer-" + t);  
                }
        ensureGreen(indexName);
                        Thread.yield();
                }  
            client().admin().indices().prepareRefresh(indexName).get();
                    try {
                        client().admin().indices().prepareFlush(indexName).setForce(false).setWaitIfOngoing(true).get();
        AtomicInteger mergeFailures = new AtomicInteger(0);
            .put("index.merge.policy.max_merge_at_once", 3)
            Set<String> orphans = new HashSet<>(diskFiles);  
            .prepareCreate(indexName)
                    failures.incrementAndGet();
        int threadsPerCycle = 3;  
            .put("index.pluggable.dataformat", "composite")  
        assertFalse("Indexer hung", indexer.isAlive());
            assertFalse("Thread did not finish in time: " + t.getName(), t.isAlive());  
                    failures.incrementAndGet();
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
            t.join(30_000);
        }
 * multiple indices with multiple shards, ensuring:  
            final int threadId = t;
        Thread[] threads = new Thread[numThreads];
                .map(p -> p.getFileName().toString())  
     * Indexes documents concurrently across multiple indices with multiple shards,
            int threadId = t;
                    failures.incrementAndGet();
            .putList("index.composite.secondary_data_formats", "lucene")  
        assertEquals(0, failures.get());
            for (int d = 0; d < docsPerBatch; d++) {  
                    barrier.await();
        // Get the primary shard's parquet directory directly via IndexShard
    public void tearDown() throws Exception {
            var bulkRequest = client().prepareBulk().setRefreshPolicy(org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE);
            threads[t].start();
        assertNotNull("primary shard for [" + indexName + "][0] must be available", primaryShard);
            ensureGreen(idx);
                failures.incrementAndGet();  
            CyclicBarrier barrier = new CyclicBarrier(threadsPerCycle);  
        ensureGreen(indexName);
                    if (i % 10 == 0) {
        for (int t = 0; t < numThreads; t++) {
            refreshers[t] = new Thread(() -> {  
            .prepareCreate(indexName)  
            }, "sorted-disabled-indexer-" + t);
        AtomicInteger failures = new AtomicInteger(0);
        int totalDocs = cycles * threadsPerCycle * docsPerThread;
        }, "force-merger");
                    client().prepareIndex().setIndex(indexName).setSource("name", "idx1_" + i, "value", i).get();
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
        ensureGreen(indexName);
        int docsPerThread = 10;
        client().admin().indices().prepareRefresh(indexName).get();
     * Verifies that merge-on-refresh does not leave orphan per-writer Parquet files on disk.
        indexer2.join(60_000);  
     */
            try {
        CyclicBarrier barrier = new CyclicBarrier(numThreads);  
        client().admin().indices().prepareCreate(indexName).setSettings(indexSettings(numShards)).get();
            t.join(60_000);  
        for (Thread t : threads) {  
        Thread indexer1 = new Thread(() -> {
            .get();  
        return Settings.builder()  
        int docsPerThread = 5;  
        for (Thread t : threads) {
            for (int t = 0; t < threadsPerCycle; t++) {
            .get();
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeNameResolved);
        int totalDocs = numThreads * docsPerThread;
                }  
        forceMerger.join(10_000);  
        verifyIndex(indexName, 1, totalDocs);
package org.opensearch.composite;
        for (Thread t : threads) {
                    }
        Thread indexer = new Thread(() -> {
import java.io.IOException;  
        client().admin().indices().prepareDelete(indexName).get();  
                    }  
                    assertFalse("WriterFileSet must have files", wfs.files().isEmpty());  
            );
            .put("index.composite.primary_data_format", "parquet")  
    @Override
     * must be deleted. Without proper cleanup, each merge-on-refresh would leak N-1 files.  
                } catch (Exception e) {
            .put("index.merge.policy.max_merge_at_once", 3)  
            threads[t] = new Thread(() -> {  
        // Stop force merger
 * this file be licensed under the Apache-2.0 license or a
            threads[t].start();
        AtomicInteger indexedCount = new AtomicInteger(0);  
                        client().prepareIndex()
    // ── Helpers ──
        verifyIndex(indexName, 1, totalDocs);
            .put("index.refresh_interval", "-1")
            }
    private Settings mergeOnRefreshSortedSettings() {  
                    if (i > 0 && i % 10 == 0) {  
                } catch (Exception e) {
                if (primaryWfs != null) {
    /**
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            .indices()
        assertTrue("Parquet directory must exist: " + parquetDir, java.nio.file.Files.isDirectory(parquetDir));  
                    shardGenerations.add(seg.generation())  
            .put("index.pluggable.dataformat.enabled", true)
        verifyIndex(indexName, numShards, indexedCount.get());
            AtomicInteger failures = new AtomicInteger(0);
                    }  
                        try (GatedCloseable<CatalogSnapshot> ref = primary.acquireSafeCatalogSnapshot()) {
            .setMapping("name", "type=keyword", "value", "type=integer")
        ensureGreen(indexName);
        int totalDocs = bulkBatches * docsPerBatch;  
        }, "flusher");
     * Auto-refresh enabled (1s interval) with merge-on-refresh. Concurrent indexing
 * <p>Validates that the {@link org.opensearch.index.engine.DataFormatAwareEngine}
                try {
            int threadId = t;  
            super.tearDown();
            .get();
            client().admin()
     * Same concurrent indexing workload as testMergeOnRefreshWithConcurrentWriters but with
            } catch (Exception e) {
            .put("index.pluggable.dataformat.enabled", true)
                    }  
        client().admin()
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();  
            .indices()
            .put("index.pluggable.dataformat.enabled", true)  
            int threadId = t;  
            verifyIndex(idx, numShards, expectedDocsPerIndex);  
    }
        // Final explicit refresh + flush  
            .setSettings(mergeOnRefreshSortedSettings())
        return Arrays.asList(
    /**
     * Each bulk request triggers a refresh (making docs immediately searchable),
     * Verifies data correctness and that force merge actually ran.  
        Thread[] threads = new Thread[numThreads];  
                    for (int i = 0; i < docsPerIndexer; i++) {  
     * Concurrent indexing with merge-on-refresh and sorted index (Parquet + Lucene).
                int id = cycle * threadsPerCycle * docsPerThread + t * docsPerThread;
            .setSettings(mergeOnRefreshSettings())
    private void verifyIndex(String indexName, int numShards, int expectedTotalDocs) throws IOException {  
        assertEquals(0, failures.get());
            } catch (Exception e) {
            int threadId = t;  
            .build();  
        }, "indexer-1");
        String indexName = INDEX_NAMES[0];
            while (indexed.get() < totalDocs) {  
        }  
        String indexName = "merge-on-refresh-concurrent";
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                            String reported = ref.get().getLastCommitFileName();  
        for (Thread t : threads) {  
            }, "race-indexer-" + t);
                    break;  
            .get();
            }  
                try {
        Thread refresher = new Thread(() -> {
        Thread indexer2 = new Thread(() -> {
        assertEquals(0, failures.get());  
        assertTrue(  
import org.opensearch.index.shard.IndexShard;  
                        barrier.await();  
            .putList("index.composite.secondary_data_formats", "lucene")  
            }
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(indexName));
                    for (int d = 0; d < docsPerThread; d++) {
            t.join(30_000);
                    barrier.await();
    }
            .put("index.pluggable.dataformat", "composite")
        }  
            .putList("index.composite.secondary_data_formats", "lucene")
        ensureGreen(indexName);  
            .build();
        }
            .put("index.composite.merge_on_refresh_max_size", "10mb")
import java.util.concurrent.CyclicBarrier;
        client().admin()
            threads[t] = new Thread(() -> {
            try {  
            CyclicBarrier barrier = new CyclicBarrier(threadsPerCycle);
        int docsPerThread = 5;
    public void testMergeOnRefreshDisabledWithConcurrentWriters() throws Exception {  
                int threadId = idxOrd * threadsPerIndex + t;
            .put("index.pluggable.dataformat.enabled", true)  
        for (int idxOrd = 0; idxOrd < INDEX_NAMES.length; idxOrd++) {
        for (int t = 0; t < numThreads; t++) {
        // Final flush  
        }
            }  
     * then verifies row counts, segment generation uniqueness, and commit integrity.
    }
        // Force merge: 5 cycles produce at least 2 segments (even if some cycles use 1 writer),
 * ./gradlew :sandbox:plugins:composite-engine:internalClusterTest \
            .get();  
        int docsPerThread = 10;
                int id = batch * docsPerBatch + d;
        assertEquals(0, failures.get());
            .putList("index.composite.secondary_data_formats", "lucene")
 * </pre>  
     * path still works correctly — each refresh produces N segments (one per writer), and  
     * Indexes docs in batches with explicit refreshes (triggering merge-on-refresh),  
            t.join(60_000);
                }, "indexer-" + threadId);
        }  
            DataformatAwareCatalogSnapshot snapshot = (DataformatAwareCatalogSnapshot) gated.get();
        forceMerger.setDaemon(true);
    /**  
 *   <li>Row counts in catalog snapshots match the number of indexed documents</li>
        for (String idx : INDEX_NAMES) {
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
                    barrier.await();
        assertFalse("Force merger thread hung", forceMerger.isAlive());
        verifyIndex(indexName, 1, totalDocs);
        for (Thread t : indexers)
            .put("index.composite.primary_data_format", "parquet")  
                    barrier.await();
                    }
            .setMapping("name", "type=keyword", "value", "type=integer")
            // Each refresh may trigger merge-on-refresh (consolidating per-writer segments)  
     * Verifies RowIdMapping correctness: after inline merge, both formats are aligned.  
            }
                        failures.incrementAndGet();
                            .get();
                for (WriterFileSet wfs : seg.dfGroupedSearchableFiles().values()) {
        flusher.start();  
    // ══════════════════════════════════════════════════════════════════════  
                });  
        client().admin()
 */  
        try (GatedCloseable<CatalogSnapshot> gated = shard.getCatalogSnapshot()) {  
        }, "indexer");
            }, "race-flusher-" + t);
                } catch (Exception e) {  
                try {  
        int docsPerIndexer = 50;  
                    }  
                        barrier.await();
    /**  
                }  
                    for (int d = 0; d < docsPerThread; d++) {  
            .indices()
     * refresh that fires between {@code committer.commit()} and {@code updateLastCommitInfo()}
                threads[t] = new Thread(() -> {  
                failures.incrementAndGet();
            .put("index.pluggable.dataformat", "composite")
        int totalDocs = numThreads * docsPerThread;  
            threads[t].start();
            }  
     * Stress test for the flush/refresh interleaving fixed by holding {@code refreshLock}
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                barrier.await();
            }
                    Thread.sleep(randomIntBetween(100, 200));
        Set<Long> allGenerations = new HashSet<>();
            // Every file on disk must be referenced by the catalog (no orphans)
                    try {
            .setSettings(mergeOnRefreshSettings())
                            .setIndex(indexName)
            Thread[] threads = new Thread[threadsPerCycle];  
            }, "race-refresher-" + t);
        int totalDocs = numThreads * docsPerThread;  
        int docsPerThread = 10;
    @Override  
        String indexName = "merge-on-refresh-sorted";  
            totalMerges > 0
                        for (int d = 0; d < docsPerThread; d++) {
        assertEquals(0, failures.get());
    // ══════════════════════════════════════════════════════════════════════
        for (int t = 0; t < numThreads; t++) {
        // 1 refresh thread
        AtomicInteger indexedCount = new AtomicInteger(0);  
                continue;  
            .build();  
            .put("index.refresh_interval", "-1")  
                );
            .put("index.composite.merge_on_refresh_max_size", "10mb")
import org.opensearch.index.engine.CommitStats;
        IndexShard shard = indexService.getShard(0);  
                    } catch (Exception e) {
                    for (int d = 0; d < docsPerThread; d++) {
        int totalThreads = INDEX_NAMES.length * threadsPerIndex;
        ensureGreen(indexName);  
                } catch (Exception e) {  
    public void testMergeOnRefreshDeletesSourceFiles() throws Exception {
        ensureGreen(indexName);
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
        return Settings.builder()
        int numThreads = 3;  
 *
            t.join(30_000);
    private Settings mergeOnRefreshAutoRefreshSettings() {
        verifyIndex(indexName, 1, totalDocs);
    }
            t.join(60_000);
                for (int i = 0; i < 5; i++) {
    private Settings mergeOnRefreshDisabledSettings() {
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
            }, "mor-indexer-" + t);  
                    failures.incrementAndGet();
            .prepareCreate(indexName)
 *  
    }
                    barrier.await();  
     * then waits for background merge to further consolidate. Both merge paths
                if (s != null && s.routingEntry().primary()) {
import org.opensearch.core.index.shard.ShardId;
        String indexName = "merge-no-orphans";  
                if (wfs != null) {
import java.util.HashSet;  
 * </ul>  
            .putList("index.sort.missing", "_last")
            .put("index.refresh_interval", "-1")
        client().admin().indices().prepareDelete(indexName).get();
        client().admin().indices().prepareRefresh(indexName).get();
    }  
                }
        }
        indexer1.start();  
 * compatible open source license.
import java.util.concurrent.atomic.AtomicInteger;  
                assertFalse("Thread hung", t.isAlive());
    }  
            .putList("index.sort.field", "value")  
            t.start();
            int threadId = t;
                    barrier.await();  
     * Multiple threads fill different writers, then a single refresh triggers
     * {@code lastCommitFileName} that may point to a {@code segments_<N>} the deletion sweep  
        int totalDocs = cycles * threadsPerCycle * docsPerThread;
     * are produced independently (no inline consolidation) and data is intact.
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 *   <li>No documents are lost under concurrent writes</li>
                failures.incrementAndGet();
     */  
            .put("index.pluggable.dataformat", "composite")
                        client().prepareIndex()
        client().admin()  
            .indices()  
    }
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        Thread[] indexers = new Thread[numIndexers];  
        }  
    /**
            t.join(60_000);
    /**  
        for (int t = 0; t < numThreads; t++) {  
        );
            allGenerations.addAll(shardGenerations);
                }
     * Interleaves indexing with refresh and flush operations concurrently.
            String snapshotKey = DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY;
                    }  
            assertFalse("Thread did not finish in time: " + t.getName(), t.isAlive());  
            .indices()  
            threads[t].start();  
            LucenePlugin.class,
                        Thread.yield();
        CyclicBarrier barrier = new CyclicBarrier(4);
                    barrier.await();  
            while (Thread.currentThread().isInterrupted() == false) {
                }  
        String indexName = "sorted-merge-disabled";  
    public void testForceMergeAfterMergeOnRefreshSorted() throws Exception {
        AtomicInteger failures = new AtomicInteger(0);  
     * threads. After every flush, each flusher reads back the just-committed snapshot's
        // Final refresh + flush  
        client().admin()
                    // Expected during concurrent indexing — shard may be relocating or refreshing
            for (Thread t : threads) {  
                    Thread.sleep(randomIntBetween(100, 300));  
                // Count rows from the primary format only (avoid double-counting with secondaries)
                int id = cycle * threadsPerCycle * docsPerThread + t * docsPerThread;  
            .putList("index.sort.order", "desc")
        int threadsPerIndex = randomIntBetween(2, 4);
            .build();
        int numThreads = 3;
                }
                }  
        IndicesStatsResponse statsResponse = client().admin().indices().prepareStats(indexName).clear().setStore(true).get();
    /**
        Set<String> diskFiles;  
                barrier.await();  
        for (String idx : INDEX_NAMES) {
            assertEquals(0, failures.get());
        forceMerger.start();  
        int numThreads = 3;
        client().admin().indices().prepareDelete(indexName).get();
            .setSettings(mergeOnRefreshSortedSettings())
                        failures.incrementAndGet();
    }
                }
        flusher.join(60_000);
                } catch (Exception e) {
        ensureGreen(indexName);  
                    indexed.incrementAndGet();
        AtomicInteger raceDetected = new AtomicInteger(0);
import java.util.Collection;
     * {@code lastCommitFileName} and asserts it (a) is non-null and (b) references a Lucene
        ShardStats[] shardStats = statsResponse.getIndex(indexName).getShards();
        indexer2.start();
            .put("index.composite.primary_data_format", "parquet")
        client().admin().indices().prepareRefresh(indexName).get();
    }  
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
            .put(super.nodeSettings(nodeOrdinal))
            client().admin().indices().prepareFlush(idx).setForce(true).setWaitIfOngoing(true).get();  
                t.join(30_000);
                threads[t].start();
    // Merge-on-refresh tests
                    client().admin().indices().prepareFlush(indexName).setForce(false).setWaitIfOngoing(true).get();
                    for (int i = 0; i < flushesPerThread; i++) {  
            .indices()  
     */
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
                }
                        client().prepareIndex()
                assertFalse("Segment " + seg.generation() + " has no files", seg.dfGroupedSearchableFiles().isEmpty());  
                assertTrue(
        AtomicInteger forceMergeRuns = new AtomicInteger(0);
        AtomicInteger failures = new AtomicInteger(0);
                    try {  
    public void testMergeOnRefreshWithConcurrentForceMergeUnsorted() throws Exception {  
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();  
                        Thread.sleep(randomIntBetween(20, 80));
        AtomicInteger indexed = new AtomicInteger(0);  
            for (String idx : INDEX_NAMES) {  
        verifyIndex(indexName, 1, totalDocs);
        for (String idx : INDEX_NAMES) {  
                failures.incrementAndGet();  
    /**  
                } catch (Exception e) {  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            assertTrue(  
            .setMapping("name", "type=keyword", "value", "type=integer")
            .build();
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
        int numThreads = 3;
            }  
            } catch (Exception e) {
public class CompositeConcurrentIndexingIT extends OpenSearchIntegTestCase {
     * merge-on-refresh DISABLED (max_size=0). Verifies that the standard per-writer segment
     * and force merge (background, warmer needs refreshLock).
    }
        }
                try {
     */  
        }, "indexer-2");
                }  
        int refreshesPerThread = 8;
        Thread[] threads = new Thread[numThreads];
        assertEquals("No threads should have failed", 0, failures.get());
            .put("index.composite.primary_data_format", "parquet")
            assertFalse("Thread did not finish in time: " + t.getName(), t.isAlive());
        client().admin().indices().prepareDelete(indexName).get();  
        for (int batch = 0; batch < bulkBatches; batch++) {
                    for (int i = 0; i < refreshesPerThread; i++) {  
                        failures.incrementAndGet();
                    Thread.currentThread().interrupt();
        int expectedDocsPerIndex = threadsPerIndex * docsPerThread;
        verifyIndex(indexName, 1, totalDocs);
            for (Thread t : threads) {
                } catch (Exception e) {
            t.start();
            .build();  
                    barrier.await();
            t.join(60_000);
        client().admin().indices().prepareDelete(indexName).get();  
            .setMapping("name", "type=keyword", "value", "type=integer")  
        String indexName = INDEX_NAMES[0];
     * triggers periodic auto-refreshes, each potentially consolidating per-writer segments.  
                    }
                            } finally {
                            .setIndex(indexName)
        }  
        int numThreads = 3;
        String indexName = "force-merge-sorted";  
                                continue;  
            .setMapping("name", "type=keyword", "value", "type=integer")
        }
     * Exercises the lock interaction between merge-on-refresh (inline, holds refreshLock)  
        verifyIndex(indexName, numShards, indexedCount.get());
            .get();  
                    forceMergeCount.incrementAndGet();
        client().admin().indices().prepareDelete(indexName).get();  
        AtomicInteger failures = new AtomicInteger(0);
            .put("index.refresh_interval", "-1")
                bulkRequest.add(client().prepareIndex(indexName).setSource("name", "bulk_" + id, "value", id));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)  
                            .setIndex(indexName)  
                commitStats.getUserData().get(snapshotKey),  
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
                            if (reported == null || !reported.startsWith("segments_")) {
            for (int i = 0; i < totalDocs; i++) {
            for (Segment seg : snapshot.getSegments()) {  
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();  
        for (int cycle = 0; cycle < cycles; cycle++) {  
                        }
     * advances {@code latestCatalogSnapshot}, leaving the just-committed snapshot with a stale
import org.opensearch.common.settings.Settings;
        client().admin()
    // ══════════════════════════════════════════════════════════════════════  
                            IndexResponse response = client().prepareIndex()  
        for (int t = 0; t < numThreads; t++) {  
                .setMapping("name", "type=keyword", "value", "type=integer")  
 * The OpenSearch Contributors require contributions made to  
        String indexName = "merge-concurrent-force-unsorted";
    }
            .setSettings(mergeOnRefreshSettings())
                    indexedCount.incrementAndGet();  
    }
            .indices()  
                // Every segment must have files
        String indexName = "merge-bulk-waitfor";  
     */
    }  
        verifyIndex(indexName, 1, totalDocs);  
            .prepareCreate(indexName)
            .indices()
                        client().admin().indices().prepareRefresh(indexName).get();
                                }
        client().admin().indices().prepareRefresh(indexName).get();
            }, "orphan-test-indexer-" + t);
            diskFiles = stream.filter(p -> p.toString().endsWith(".parquet"))
        AtomicInteger failures = new AtomicInteger(0);  
        // 2 indexing threads  
 * SPDX-License-Identifier: Apache-2.0
        return Settings.builder()
            .indices()
        return Settings.builder()
    public void testMergeOnRefreshSortedWithConcurrentWriters() throws Exception {
            Set<String> catalogFiles = new HashSet<>();
        AtomicInteger failures = new AtomicInteger(0);
     * Force merge to 1 segment on a sorted index with merge-on-refresh ENABLED.  
                            .setSource("name", "t" + threadId + "_d" + d, "value", threadId * 100 + d)  
            }  
                try {  
            t.join(30_000);
                threads[t] = new Thread(() -> {
    // Merge-on-refresh with auto-refresh and force merge
                        if (d % 5 == 0) Thread.sleep(randomIntBetween(50, 150));
        }
                                .setSource("name", "thread_" + threadId + "_doc_" + d, "value", randomIntBetween(1, 10000))
            .put("index.pluggable.dataformat", "composite")
                } catch (Exception e) {
 * with the composite engine (Parquet primary format).
                threads[t].start();
            }  
    }  
        ShardId shardId = new ShardId(resolveIndex(indexName), 0);
                    assertTrue("WriterFileSet must have positive row count", wfs.numRows() > 0);
            .setMapping("name", "type=keyword", "value", "type=integer")
            .indices()
        Thread[] refreshers = new Thread[numRefreshers];
    private static final String[] INDEX_NAMES = { "concurrent-idx-1", "concurrent-idx-2", "concurrent-idx-3" };  
            .setMapping("name", "type=keyword", "value", "type=integer")
                    catalogFiles.addAll(wfs.files());  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            .setMapping("name", "type=keyword", "value", "type=integer")  
        indexer.start();
import java.util.Arrays;
        AtomicInteger failures = new AtomicInteger(0);
                                raceDetected.incrementAndGet();
        int totalDocs = randomIntBetween(50, 100);
            }
        Thread[] threads = new Thread[totalThreads];
                            }
        client().admin()
            .put("index.merge.policy.max_merge_at_once", 3)
        Thread merger = new Thread(() -> {
                            .get();
    }
import org.opensearch.indices.IndicesService;
                    }
     * Sorted index with merge-on-refresh DISABLED. Verifies that per-writer segments
        );  
import org.opensearch.action.admin.indices.stats.ShardStats;
        assertFalse("Merger hung", merger.isAlive());
                }
        int numShards = randomIntBetween(2, 4);
                    }  
 *   <li>Segment generations are unique within each shard</li>  
        int numShards = 2;  
                .prepareCreate(idx)
     */
        for (int t = 0; t < numIndexers; t++) {
            }, "disabled-indexer-" + t);
            assertFalse("Bulk request should not have failures", response.hasFailures());
            assertEquals(0, failures.get());
        // Use enough cycles so multiple segments accumulate regardless of writer distribution
    public void testMergeOnRefreshWithBulkWaitFor() throws Exception {
                            .setIndex(indexName)  
                }
        // so forceMerge(1) must actually merge.  
        for (String idx : INDEX_NAMES) {
     * across the entire {@code DataFormatAwareEngine.flush()} body. Without that lock, a  
        int numShards = 1;
            .setMapping("name", "type=keyword", "value", "type=integer")  
                    client().admin().indices().prepareRefresh(indexName).get();
     * has already removed — surfacing later as peer-recovery {@code NoSuchFileException}.
            threads[t].start();
            );  
                } catch (Exception e) {  
                .indices()  
    }  
            orphans.removeAll(catalogFiles);
            }
            int threadId = t;
        client().admin().indices().prepareRefresh(indexName).get();
                    forceMergeRuns.incrementAndGet();
        int totalDocs = numThreads * docsPerThread;
                            .setSource("name", "t" + threadId + "_d" + d, "value", randomIntBetween(0, 500))
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                            assertEquals(RestStatus.CREATED, response.status());
            AtomicInteger failures = new AtomicInteger(0);
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
                }
        // Concurrent indexing across all indices
        int numThreads = 3;
            .putList("index.sort.order", "desc")  
                                primary.store().decRef();  
                        client().prepareIndex()  
     */
 *   --tests "*.CompositeConcurrentIndexingIT" -Dsandbox.enabled=true
        client().admin()  
                } catch (Exception e) {
            .prepareCreate(indexName)  
            .putList("index.sort.field", "value")
                });
        return Settings.builder()  
        int numRefreshers = 3;  
    public void testMergeOnRefreshCoexistsWithBackgroundMerge() throws Exception {
        verifyIndex(indexName, 1, totalDocs);
            .put("index.composite.merge_on_refresh_max_size", "0")
     * background merge handles consolidation.
                WriterFileSet primaryWfs = seg.dfGroupedSearchableFiles().get("parquet");  
            .setMapping("name", "type=keyword", "value", "type=integer")  
        client().admin()  
        }
            t.join(30_000);  
            assertFalse("Thread did not finish in time: " + t.getName(), t.isAlive());
    // ══════════════════════════════════════════════════════════════════════
        }  
        assertEquals("Committed snapshot's lastCommitFileName must always match an existing segments_<N> on disk", 0, raceDetected.get());
import java.util.function.Function;
        assertEquals(0, failures.get());  
import org.opensearch.index.IndexService;  
            var response = bulkRequest.get();
    /**
    /**
        String nodeNameResolved = getClusterState().nodes().get(nodeName).getName();  
                }
                try {
        // Force merge thread: runs concurrently  
                    for (int d = 0; d < docsPerThread; d++) {
                    failures.incrementAndGet();
            .setSettings(mergeOnRefreshDisabledSettings())  
            CommitStats commitStats = ss.getCommitStats();
        // Refresh and flush all indices  
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
        for (int t = 0; t < numFlushers; t++) {
                            .setSource("name", "t" + threadId + "_d" + d, "value", threadId * 100 + d)
        int bulkBatches = 5;
                for (int i = 0; i < totalDocs / 2; i++) {
            .setSettings(mergeOnRefreshSettings())
                        }
        merger.interrupt();  
                    }  
        final IndexShard primary = primaryShard;
                    failures.incrementAndGet();
            "Background merge should have triggered (forceMergeCount=" + forceMergeCount.get() + ", totalMerges=" + totalMerges + ")",
                    break;  
        Thread[] threads = new Thread[numThreads];
     * After 5 cycles → 5 segments. forceMerge(1) must merge them into 1.
        for (ShardStats ss : shardStats) {
        // Verify shard is healthy (not failed due to merge race)  
        }  
        int docsPerBatch = 10;
    /**
        client().admin().indices().prepareRefresh(indexName).get();
            ParquetDataFormatPlugin.class,  
 * <pre>  
        assertFalse("Expected parquet files on disk", diskFiles.isEmpty());  
        // Final flush so committed snapshot reflects all indexed docs  
        client().admin()
                barrier.await();
                for (int i = 0; i < totalDocs / 2; i++) {
 * <ul>
    public void testInterleavedIndexRefreshFlush() throws Exception {
                            primary.store().incRef();
                    client().admin().indices().prepareForceMerge(indexName).setMaxNumSegments(1).get();
                        barrier.await();
                try {
        }  
                        client().prepareIndex()
        int totalDocs = numThreads * docsPerThread;
            CompositeDataFormatPlugin.class,
                    failures.incrementAndGet();
                    }  
                                .get();  
        client().admin().indices().prepareRefresh(indexName).get();
                            .setIndex(indexName)
import org.opensearch.common.concurrent.GatedCloseable;
            flushers[t] = new Thread(() -> {  
     */  
}
                                .setSource("name", "doc_" + (id + d), "value", randomIntBetween(0, 1000))
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
 */
            .setSettings(mergeOnRefreshSettings())
            }
    public void testConcurrentIndexingAcrossMultipleIndicesAndShards() throws Exception {
import org.opensearch.action.index.IndexResponse;
        // Verify no data loss — all docs present regardless of which merge path handled them  
    }
        int docsPerThread = 10;
        for (Thread t : refreshers)
                                if (!diskFiles.contains(reported)) {
        // Verify data correctness
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
                        client().prepareIndex()  
    }
 *   <li>Flush produces valid commit data with catalog snapshots</li>
        int totalDocs = 60;
import org.opensearch.be.datafusion.DataFusionPlugin;
        }
            .prepareCreate(indexName)  
                            client().prepareIndex().setIndex(indexName).setSource("name", "doc_" + (id + d), "value", id + d).get();
     * inline merge. Verifies row count and segment consolidation.
                            .get();  
    /**  
            for (Segment seg : snapshot.getSegments()) {  
                threads[threadId] = new Thread(() -> {
                    }  
     */  
            // Verify segment generation uniqueness within this shard
        // Multiple refresh cycles with concurrent writers to trigger merge-on-refresh  
        AtomicInteger failures = new AtomicInteger(0);
     */
                        }
                for (int i = 0; i < 3; i++) {  
                            .setSource("name", "t" + threadId + "_d" + i, "value", threadId * 1000 + i)  
                try {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .put("index.composite.merge_on_refresh_max_size", "0")
        }  
                            }
        // Run forceMerge concurrently to exercise background merge + merge-on-refresh coexistence  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .build();
            assertTrue("Orphan parquet files on disk not referenced by catalog: " + orphans, orphans.isEmpty());
        for (Thread t : threads) {
    public void testMergeOnRefreshWithConcurrentWriters() throws Exception {
    private Settings mergeOnRefreshSettings() {
            .put("index.refresh_interval", "-1")
        assertEquals("No worker thread should have failed under concurrent flush/refresh", 0, failures.get());  
            .prepareCreate(indexName)
     * Verifies that merge-on-refresh and background merge coexist without deadlock.
            Set<Long> shardGenerations = new HashSet<>();
            .prepareCreate(indexName)  
        }, "refresher");  
                commitStats.getUserData().containsKey(snapshotKey)
import org.opensearch.test.OpenSearchIntegTestCase;
            DataformatAwareCatalogSnapshot snapshot = DataformatAwareCatalogSnapshot.deserializeFromString(
/*  
                    client().admin().indices().prepareForceMerge(indexName).setMaxNumSegments(1).get();  
            .putList("index.composite.secondary_data_formats", "lucene")  
            .put("index.pluggable.dataformat", "composite")
            String indexName = INDEX_NAMES[idxOrd];
                            .get();
        // Create indices with multiple shards  
                            client().prepareIndex()
                    failures.incrementAndGet();
        int threadsPerCycle = 3;
        client().admin().indices().prepareDelete(indexName).get();
        client().admin()
