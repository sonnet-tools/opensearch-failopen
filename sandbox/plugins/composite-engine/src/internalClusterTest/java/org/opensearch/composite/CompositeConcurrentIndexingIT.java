    private Settings mergeOnRefreshDisabledSortedSettings() {
            }, "mor-sorted-indexer-" + t);
        // Multiple refresh cycles with concurrent writers to trigger merge-on-refresh
                } catch (Exception e) {
        int numThreads = 3;
                }
    @Override
            threads[t] = new Thread(() -> {
        }
            .prepareCreate(indexName)
            .build();
        }
            .putList("index.sort.order", "desc")
        AtomicInteger failures = new AtomicInteger(0);
                } catch (Exception e) {
    public void testMergeOnRefreshDisabledWithSortedIndex() throws Exception {
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
                            .setSource("name", "t" + threadId + "_d" + d, "value", threadId * 100 + d)
        for (int t = 0; t < numThreads; t++) {
            for (String idx : INDEX_NAMES) {
     * threads. After every flush, each flusher reads back the just-committed snapshot's
        ensureGreen(indexName);
        }
        int numThreads = 3;
        // Final flush so committed snapshot reflects all indexed docs
            } catch (Exception e) {
                    barrier.await();
            .put("index.merge.policy.max_merge_at_once", 3)
                }
            .prepareCreate(indexName)
        }, "indexer");
            .put("index.pluggable.dataformat.enabled", true)
        ensureGreen(indexName);
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
        client().admin().indices().prepareRefresh(indexName).get();
/**
 */
    // Merge-on-refresh tests
            .get();
     * Each bulk request triggers a refresh (making docs immediately searchable),
            for (Segment seg : snapshot.getSegments()) {
        int flushesPerThread = 8;
            .setSettings(mergeOnRefreshSettings())
     * then waits for background merge to further consolidate. Both merge paths
            String snapshotKey = DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY;
            .put("index.composite.primary_data_format", "parquet")
                commitStats.getUserData().get(snapshotKey),
        for (int t = 0; t < numThreads; t++) {
        Thread[] threads = new Thread[totalThreads];
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
     */
                    indexedCount.incrementAndGet();
            .put("index.pluggable.dataformat", "composite")
        int totalDocs = bulkBatches * docsPerBatch;
            .put(super.nodeSettings(nodeOrdinal))
            assertFalse("Thread did not finish in time: " + t.getName(), t.isAlive());
            .indices()
            for (int t = 0; t < threadsPerIndex; t++) {
 * Integration test for concurrent indexing across multiple indices and shards
import org.opensearch.index.engine.exec.WriterFileSet;
                } catch (Exception e) {
        } finally {
            .putList("index.composite.secondary_data_formats", "lucene")
 * The OpenSearch Contributors require contributions made to
            } catch (Exception e) {
            threads[t] = new Thread(() -> {
        Thread[] threads = new Thread[numThreads];
        client().admin().indices().prepareDelete(indexName).get();
            totalMerges > 0
                    failures.incrementAndGet();
            .build();
                if (wfs != null) {
            var bulkRequest = client().prepareBulk().setRefreshPolicy(org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE);
        forceMerger.join(10_000);
                .prepareCreate(idx)
        ensureGreen(indexName);
        // Force merge thread: runs concurrently
                        client().prepareIndex()
        Thread[] flushers = new Thread[numFlushers];
 *
        assertEquals(0, failures.get());
                        Thread.sleep(randomIntBetween(10, 40));
            assertEquals(0, failures.get());
                WriterFileSet wfs = seg.dfGroupedSearchableFiles().get("parquet");
            .setSettings(indexSettings(numShards))
            assertTrue(
        int numIndexers = 4;
            Set<Long> shardGenerations = new HashSet<>();
                        if (d % 5 == 0) Thread.sleep(randomIntBetween(50, 150));
        // Concurrent indexing across all indices
            final int threadId = t;
        String indexName = "merge-auto-refresh";
        assertEquals("No indexing threads should have failed", 0, failures.get());
        int numThreads = 3;
        int totalThreads = INDEX_NAMES.length * threadsPerIndex;
        verifyIndex(indexName, 1, totalDocs);
        for (Thread t : threads) {
            .put("index.pluggable.dataformat.enabled", true)
                        // on disk. A refresh racing inside flush() leaves the committed snapshot
        AtomicInteger failures = new AtomicInteger(0);
            .build();
        java.nio.file.Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
            t.join(60_000);
        // Clean up
import org.opensearch.arrow.allocator.ArrowBasePlugin;
 * <ul>
        AtomicInteger mergeFailures = new AtomicInteger(0);
                    for (int i = 0; i < refreshesPerThread; i++) {
                failures.incrementAndGet();
 * ./gradlew :sandbox:plugins:composite-engine:internalClusterTest \
 *   <li>Row counts in catalog snapshots match the number of indexed documents</li>
                    }
                } catch (Exception e) {
            .put("index.pluggable.dataformat.enabled", true)
            .put("index.composite.merge_on_refresh_max_size", "10mb")
                    barrier.await();
        client().admin()
            }
                // Every segment must have files
            .setMapping("name", "type=keyword", "value", "type=integer")
     * use the same IndexWriter and refreshLock — this test ensures they don't deadlock.
    /**
        assertEquals(0, failures.get());
import org.opensearch.parquet.ParquetDataFormatPlugin;
            .put("index.refresh_interval", "-1")
        for (int t = 0; t < numThreads; t++) {
    public void testConcurrentIndexingAcrossMultipleIndicesAndShards() throws Exception {
                    client().admin().indices().prepareForceMerge(indexName).setMaxNumSegments(1).get();
        for (Thread t : threads) {
    }
                            .get();
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
        int totalDocs = numThreads * docsPerThread;
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
import org.opensearch.action.admin.indices.stats.ShardStats;
                try {
                }, "indexer-" + threadId);
            assertFalse("Catalog must reference at least one parquet file", catalogFiles.isEmpty());
                            .get();
        AtomicInteger raceDetected = new AtomicInteger(0);
import org.opensearch.core.rest.RestStatus;
        client().admin().indices().prepareRefresh(indexName).get();
     */
     * fix protects.
                                raceDetected.incrementAndGet();
    private Settings indexSettings(int numShards) {
            t.start();
            for (int d = 0; d < docsPerBatch; d++) {
            .put("index.composite.merge_on_refresh_max_size", "0")
                if (s != null && s.routingEntry().primary()) {
                    primaryShard = s;
            if (ss.getShardRouting().primary() == false) {
                    indexedCount.incrementAndGet();
            }
                    "Duplicate generation " + seg.generation() + " in shard " + ss.getShardRouting().shardId(),
    // ══════════════════════════════════════════════════════════════════════
        // 1 flush thread
        for (String node : internalCluster().getDataNodeNames()) {
    // Merge-on-refresh disabled (baseline) tests
            .put("index.pluggable.dataformat.enabled", true)
                                .setIndex(indexName)
     */
        int docsPerThread = 10;
            .put("index.composite.merge_on_refresh_max_size", "0")
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
        assertEquals(0, failures.get());
    private void verifyIndex(String indexName, int numShards, int expectedTotalDocs) throws IOException {
     * Force merge to 1 segment on a sorted index with merge-on-refresh ENABLED.
        for (int idxOrd = 0; idxOrd < INDEX_NAMES.length; idxOrd++) {
        ShardId shardId = new ShardId(resolveIndex(indexName), 0);
        AtomicInteger failures = new AtomicInteger(0);
                    break;
        // Indexer thread: indexes docs and triggers explicit refreshes periodically
                try {
                                .get();
     * has already removed — surfacing later as peer-recovery {@code NoSuchFileException}.
        ShardStats[] shardStats = statsResponse.getIndex(indexName).getShards();
                try {
                    }
                t.join(30_000);
        int numThreads = 3;
                    indexed.incrementAndGet();
                }
                                }
                    // index may not exist
        try {
        // Verify background merge actually ran
            CyclicBarrier barrier = new CyclicBarrier(threadsPerCycle);
    }
                        indexedCount.incrementAndGet();
        for (ShardStats ss : shardStats) {
        // 2 indexing threads
            assertEquals(0, failures.get());
                    Thread.sleep(randomIntBetween(100, 300));
                                .setSource("name", "thread_" + threadId + "_doc_" + d, "value", randomIntBetween(1, 10000))
            try {
            ParquetDataFormatPlugin.class,
                    if (i % 10 == 0) {
        String indexName = "merge-coexistence";
                if (primaryWfs != null) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        verifyIndex(indexName, 1, totalDocs);
                for (int i = 0; i < 3; i++) {
                        client().prepareIndex()
            t.join(30_000);
        indexer1.start();
                    client().admin().indices().prepareDelete(idx).get();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
                    } catch (Exception e) {
     */
    /**
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                            .setSource("name", "t" + threadId + "_d" + i, "value", threadId * 1000 + i)
            .get();
                        client().prepareIndex()
        // Run forceMerge concurrently to exercise background merge + merge-on-refresh coexistence
        client().admin()
                    failures.incrementAndGet();
                            client().prepareIndex()
import org.opensearch.be.lucene.LucenePlugin;
package org.opensearch.composite;
     */
                } catch (InterruptedException e) {
 * </pre>
                            assertEquals(RestStatus.CREATED, response.status());
            .indices()
            .put("index.composite.primary_data_format", "parquet")
                    // Expected during concurrent operations
                        client().prepareIndex()
    }
import java.util.concurrent.atomic.AtomicInteger;
     * Verifies that merge-on-refresh and background merge coexist without deadlock.
        int totalDocs = numThreads * docsPerThread;
        int docsPerThread = randomIntBetween(20, 50);
    }
        String indexName = "merge-bulk-waitfor";
                        for (int d = 0; d < docsPerThread; d++) {
                        // Direct invariant: the just-committed snapshot's lastCommitFileName
     * Same concurrent indexing workload as testMergeOnRefreshWithConcurrentWriters but with
            client().admin().indices().prepareFlush(idx).setForce(true).setWaitIfOngoing(true).get();
                            .get();
        // Verify shard is healthy (not failed due to merge race)
            assertFalse("Thread did not finish in time: " + t.getName(), t.isAlive());
                barrier.await();
                    client().prepareIndex(indexName).setSource("name", "doc_" + i, "value", i).get();
                    failures.incrementAndGet();
import org.opensearch.plugins.Plugin;
                            .setIndex(indexName)
     * which may trigger merge-on-refresh if multiple writers flushed.
            .putList("index.composite.secondary_data_formats", "lucene")
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
                // Count rows from the primary format only (avoid double-counting with secondaries)
        int totalDocs = 60;
                    client().prepareIndex().setIndex(indexName).setSource("name", "idx1_" + i, "value", i).get();
        assertTrue("Parquet directory must exist: " + parquetDir, java.nio.file.Files.isDirectory(parquetDir));
        // Create indices with multiple shards
            .prepareCreate(indexName)
    }
            }
            .putList("index.sort.order", "desc")
                        barrier.await();
    }
        }
                    }
        verifyIndex(indexName, 1, totalDocs);
                }
                bulkRequest.add(client().prepareIndex(indexName).setSource("name", "bulk_" + id, "value", id));
     * Bulk indexing with refresh=wait_for alongside merge-on-refresh.
                t.join(30_000);
        client().admin().indices().prepareDelete(indexName).get();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     * Verifies data correctness and that force merge actually ran.
        client().admin()
        merger.start();
            assertFalse("Bulk request should not have failures", response.hasFailures());
                        Thread.yield();
        client().admin().indices().prepareForceMerge(indexName).setMaxNumSegments(1).get();
            }
    /**
                IndexShard s = getIndexShard(node, shardId, indexName);
            .get();
        Thread flusher = new Thread(() -> {
                    } catch (Exception e) {
            .put("index.refresh_interval", "-1")
                    try {
                        // with a stale name; once the next deletion sweep runs that file is gone.
        }
            }
            allGenerations.addAll(shardGenerations);
                } catch (Exception e) {
                        barrier.await();
        client().admin()
        int docsPerThread = 5;
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
                    if (i > 0 && i % 10 == 0) {
                    failures.incrementAndGet();
            .indices()
                                    raceDetected.incrementAndGet();
        assertTrue(
    public void testMergeOnRefreshSortedWithConcurrentWriters() throws Exception {
     * refresh that fires between {@code committer.commit()} and {@code updateLastCommitInfo()}
                assertFalse("Thread hung", t.isAlive());
        IndicesStatsResponse statsResponse = client().admin().indices().prepareStats(indexName).clear().setStore(true).get();
        int threadsPerCycle = 3;
        client().admin()
        client().admin().indices().prepareRefresh(indexName).get();
                    }
                                primary.store().decRef();
                }
        return Settings.builder()
 *
        }
        client().admin()
                try {
        }
            client().admin().indices().prepareRefresh(indexName).get();
            }
                        client().prepareIndex()
    }
    public void testMergeOnRefreshWithConcurrentWriters() throws Exception {
        assertFalse("Expected parquet files on disk", diskFiles.isEmpty());
            .put("index.pluggable.dataformat", "composite")
                        failures.incrementAndGet();
        Thread[] threads = new Thread[numThreads];
                    assertFalse("WriterFileSet must have files", wfs.files().isEmpty());
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
                int id = cycle * threadsPerCycle * docsPerThread + t * docsPerThread;
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        // Clean up
        int docsPerThread = 10;
                            .setIndex(indexName)
            }
            } catch (Exception ignore) {}
                continue;
        }
                try {
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
            .get();
        int expectedDocsPerIndex = threadsPerIndex * docsPerThread;
        }
        // Force merge: 5 cycles produce at least 2 segments (even if some cycles use 1 writer),
                barrier.await();
                try {
    public void testMergeOnRefreshWithAutoRefreshEnabled() throws Exception {
        }
            CommitStats commitStats = ss.getCommitStats();
            .put("index.pluggable.dataformat.enabled", true)
                        }
                    if (i % 10 == 0) {
        int docsPerThread = 5;
        AtomicInteger failures = new AtomicInteger(0);
            t.start();
                    }
            t.join(30_000);
                WriterFileSet primaryWfs = seg.dfGroupedSearchableFiles().get("parquet");
                threads[t].start();
                        client().admin().indices().prepareRefresh(indexName).get();
     */
     * Verifies that merge-on-refresh does not leave orphan per-writer Parquet files on disk.
                                if (!diskFiles.contains(reported)) {
            .indices()
        AtomicInteger failures = new AtomicInteger(0);
                    }
        Thread indexer = new Thread(() -> {
                threads[t] = new Thread(() -> {
        }
                    shardGenerations.add(seg.generation())
        int docsPerThread = 20;
                        for (int d = 0; d < docsPerThread; d++) {
     * Indexes documents concurrently across multiple indices with multiple shards,
                            }
 * this file be licensed under the Apache-2.0 license or a
                threads[t].start();
            .prepareCreate(indexName)
    /**
            orphans.removeAll(catalogFiles);
    }
            .put("index.composite.primary_data_format", "parquet")
        Thread indexer1 = new Thread(() -> {
        AtomicInteger failures = new AtomicInteger(0);
    }
        ensureGreen(indexName);
        for (int t = 0; t < numFlushers; t++) {
        for (int t = 0; t < numRefreshers; t++) {
                    try {
            .setSettings(mergeOnRefreshSortedSettings())
        }
                            .setSource("name", "t" + threadId + "_d" + d, "value", randomIntBetween(0, 500))
 *   <li>Flush produces valid commit data with catalog snapshots</li>
                    failures.incrementAndGet();
            .indices()
                            .get();
                threads[threadId].start();
                    barrier.await();
     * {@code lastCommitFileName} that may point to a {@code segments_<N>} the deletion sweep
                    for (int d = 0; d < docsPerThread; d++) {
     * Concurrent indexing with merge-on-refresh enabled (Parquet + Lucene).
        verifyIndex(indexName, 1, totalDocs);
        client().admin().indices().prepareDelete(indexName).get();
        ensureGreen(indexName);
     * and force merge (background, warmer needs refreshLock).
            }
 * SPDX-License-Identifier: Apache-2.0
                    forceMergeRuns.incrementAndGet();
        int numShards = 1;
        for (String idx : INDEX_NAMES) {
            Set<String> orphans = new HashSet<>(diskFiles);
                failures.incrementAndGet();
        indexer2.start();
            .setMapping("name", "type=keyword", "value", "type=integer")
                    for (int d = 0; d < docsPerThread; d++) {
            "Background merge should have triggered (forceMergeCount=" + forceMergeCount.get() + ", totalMerges=" + totalMerges + ")",
            assertFalse("Thread did not finish in time: " + t.getName(), t.isAlive());
            int threadId = t;
    @Override
     * Indexes docs in batches with explicit refreshes (triggering merge-on-refresh),
     * {@code lastCommitFileName} and asserts it (a) is non-null and (b) references a Lucene
    // ══════════════════════════════════════════════════════════════════════
        merger.interrupt();
/*
        client().admin().indices().prepareRefresh(indexName).get();
        int cycles = 5;
        for (int t = 0; t < numIndexers; t++) {
        ensureGreen(indexName);
            .put("index.pluggable.dataformat", "composite")
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
                });
                    failures.incrementAndGet();
            }
        int docsPerThread = 10;
        client().admin().indices().prepareDelete(indexName).get();
                commitStats.getUserData().containsKey(snapshotKey)
        assertEquals("Total rows across all shards of " + indexName + " must match indexed docs", expectedTotalDocs, totalRows);
import org.opensearch.test.OpenSearchIntegTestCase;
            .putList("index.composite.secondary_data_formats", "lucene")
        AtomicInteger failures = new AtomicInteger(0);
import org.opensearch.core.index.shard.ShardId;
        IndexShard primaryShard = null;
            assertNotNull("Commit stats should exist for shard " + ss.getShardRouting().shardId(), commitStats);
        for (String idx : INDEX_NAMES) {
                threads[t] = new Thread(() -> {
        verifyIndex(indexName, 1, totalDocs);
            client().admin().indices().prepareRefresh(idx).get();
                }
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
            .setMapping("name", "type=keyword", "value", "type=integer")
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .prepareCreate(indexName)
            verifyIndex(idx, numShards, expectedDocsPerIndex);
            .setMapping("name", "type=keyword", "value", "type=integer")
            for (Thread t : threads) {
import org.opensearch.indices.IndicesService;
        verifyIndex(indexName, 1, totalDocs);
            .setSettings(mergeOnRefreshDisabledSettings())
    }
            t.join(30_000);
                    totalRows += primaryWfs.numRows();
        int threadsPerIndex = randomIntBetween(2, 4);
        }
            .setMapping("name", "type=keyword", "value", "type=integer")
        indexer1.join(60_000);
     */
                    break;
                    }
            }
            threads[t] = new Thread(() -> {
    /**
                    failures.incrementAndGet();
                                .setSource("name", "doc_" + (id + d), "value", randomIntBetween(0, 1000))
        for (int t = 0; t < numThreads; t++) {
    /**
            .put("index.refresh_interval", "-1")
import java.util.Collection;
                );
 * <p>Validates that the {@link org.opensearch.index.engine.DataFormatAwareEngine}
            }
        return Settings.builder()
                    Thread.currentThread().interrupt();
     * Interleaves indexing with refresh and flush operations concurrently.
            }
            .setSettings(mergeOnRefreshSettings())
                    client().admin().indices().prepareRefresh(indexName).get();
                    client().prepareIndex().setIndex(indexName).setSource("name", "idx2_" + i, "value", i + 1000).get();
        AtomicInteger failures = new AtomicInteger(0);
            }, "disabled-indexer-" + t);
                failures.incrementAndGet();
                        for (int d = 0; d < docsPerThread; d++) {
        assertFalse("Force merger thread hung", forceMerger.isAlive());
        for (Thread t : threads) {
            threads[t].start();
        for (Thread t : indexers)
            while (indexed.get() < totalDocs) {
            String indexName = INDEX_NAMES[idxOrd];
                }
                } catch (InterruptedException e) {
                        client().prepareIndex()
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
        String indexName = "merge-on-refresh-disabled";
        int numShards = randomIntBetween(2, 4);
    protected Settings nodeSettings(int nodeOrdinal) {
    public void testMergeOnRefreshWithConcurrentForceMergeUnsorted() throws Exception {
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeNameResolved);
        // Verify each index
    public void tearDown() throws Exception {
        }
        CyclicBarrier barrier = new CyclicBarrier(numIndexers + numFlushers + numRefreshers);
            flushers[t] = new Thread(() -> {
    private Settings mergeOnRefreshSortedSettings() {
        // Verify all data is present
            t.join(60_000);
            .put("index.pluggable.dataformat", "composite")
        int totalDocs = cycles * threadsPerCycle * docsPerThread;
        String indexName = "force-merge-sorted";
            for (int t = 0; t < threadsPerCycle; t++) {
                            }
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
import java.util.HashSet;
            t.join(30_000);
            .put("index.refresh_interval", "1s")
        for (String idx : INDEX_NAMES) {
            .get();
            .prepareCreate(indexName)
                                Set<String> diskFiles = new HashSet<>(Arrays.asList(primary.store().directory().listAll()));
     * Exercises the lock interaction between merge-on-refresh (inline, holds refreshLock)
            t.join(60_000);
        int totalDocs = numThreads * docsPerThread;
            .setSettings(mergeOnRefreshSettings())
                            .setSource("name", "t" + threadId + "_d" + d, "value", threadId * 100 + d)
     * advances {@code latestCatalogSnapshot}, leaving the just-committed snapshot with a stale
            .put("index.composite.primary_data_format", "parquet")
                    barrier.await();
        client().admin().indices().prepareDelete(indexName).get();
        ensureGreen(indexName);
                            client().prepareIndex().setIndex(indexName).setSource("name", "doc_" + (id + d), "value", id + d).get();
        assertEquals(0, failures.get());
    }
            .setSettings(mergeOnRefreshSettings())
                }
                            .setIndex(indexName)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            threads[t].start();
                try {
            .indices()
        client().admin()
                    for (int d = 0; d < docsPerThread; d++) {
    }
        int threadsPerCycle = 3;
        Set<String> diskFiles;
            }
        String indexName = "merge-on-refresh-sorted";
    private static final String[] INDEX_NAMES = { "concurrent-idx-1", "concurrent-idx-2", "concurrent-idx-3" };
        ensureGreen(indexName);
     */
            } catch (Exception e) {
        ensureGreen(indexName);
                int id = cycle * threadsPerCycle * docsPerThread + t * docsPerThread;
            );
            t.start();
import java.util.function.Function;
                } catch (Exception e) {
 *   <li>No documents are lost under concurrent writes</li>
                            } finally {
        // Resolve the primary shard once — used by flushers to read back commit-state invariant
     * After inline merge, only the merged file should remain — the source per-writer files
                }
 *   <li>Segment generations are unique within each shard</li>
        client().admin().indices().prepareRefresh(indexName).get();
                                .get();
                for (int i = 0; i < 5; i++) {
        IndexShard shard = indexService.getShard(0);
                try {
        client().admin().indices().prepareRefresh(indexName).get();
        for (Thread t : refreshers)
            );
                barrier.await();
                    assertTrue("WriterFileSet must have positive row count", wfs.numRows() > 0);
        refresher.start();
            .setMapping("name", "type=keyword", "value", "type=integer")
import org.opensearch.index.shard.IndexShard;
     * Background merge will eventually consolidate them with RowIdMapping.
        }
        }
        String nodeNameResolved = getClusterState().nodes().get(nodeName).getName();
        client().admin().indices().prepareDelete(indexName).get();
                }
                } catch (Exception e) {
        AtomicInteger indexed = new AtomicInteger(0);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
                Function.identity()
            LucenePlugin.class,
                } catch (Exception e) {
                } catch (Exception e) {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
        verifyIndex(indexName, numShards, indexedCount.get());
     * Multiple threads fill different writers, then a single refresh triggers
                    for (int d = 0; d < docsPerThread; d++) {
        indexer.join(60_000);
                            .get();
    public void testMergeOnRefreshDisabledWithConcurrentWriters() throws Exception {
        verifyIndex(indexName, 1, totalDocs);
            try {
                } catch (Exception e) {
 *
            }
 * <pre>
                    barrier.await();
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
        }, "force-merger");
                }
        for (Thread t : flushers)
        int totalDocs = numThreads * docsPerThread;
            indexers[t] = new Thread(() -> {
        client().admin().indices().prepareDelete(indexName).get();
        for (Thread t : threads) {
            .indices()
        for (Thread t : threads) {
            .get();
            .put("index.pluggable.dataformat", "composite")
            try {
            while (Thread.currentThread().isInterrupted() == false) {
        int numFlushers = 3;
            threads[t].start();
                        }
    public void testMergeOnRefreshCoexistsWithBackgroundMerge() throws Exception {
                assertFalse("Segment " + seg.generation() + " has no files", seg.dfGroupedSearchableFiles().isEmpty());
        AtomicInteger failures = new AtomicInteger(0);
    /**
            }
                    barrier.await();
    public void testForceMergeAfterMergeOnRefreshSorted() throws Exception {
                .collect(java.util.stream.Collectors.toSet());
                    barrier.await();
import java.util.Set;
                        client().prepareIndex()
    // ══════════════════════════════════════════════════════════════════════
        // so forceMerge(1) must actually merge.
    // ══════════════════════════════════════════════════════════════════════
        verifyIndex(indexName, 1, totalDocs);
    /**
        assertEquals("No threads should have failed", 0, failures.get());
    // ══════════════════════════════════════════════════════════════════════
                } catch (Exception e) {
        Thread refresher = new Thread(() -> {
 */
            }, "orphan-test-indexer-" + t);
        }
            .setMapping("name", "type=keyword", "value", "type=integer")
            }, "race-refresher-" + t);
        }
        AtomicInteger forceMergeRuns = new AtomicInteger(0);
            threads[t] = new Thread(() -> {
                            .setSource("name", "t" + threadId + "_d" + d, "value", threadId * 100 + d)
        return Settings.builder()
        String nodeName = getClusterState().routingTable().index(indexName).shard(0).primaryShard().currentNodeId();
            int threadId = t;
     * then verifies row counts, segment generation uniqueness, and commit integrity.
        // Count actual parquet files on disk
        flusher.join(60_000);
                for (WriterFileSet wfs : seg.dfGroupedSearchableFiles().values()) {
        String indexName = INDEX_NAMES[0];
import java.util.concurrent.CyclicBarrier;
        client().admin()
        AtomicInteger forceMergeCount = new AtomicInteger(0);
            refreshers[t] = new Thread(() -> {
            .indices()
     * Stress test for the flush/refresh interleaving fixed by holding {@code refreshLock}
            ArrowBasePlugin.class,
    public void testMergeOnRefreshDeletesSourceFiles() throws Exception {
        int totalDocs = numThreads * docsPerThread;
                    for (int d = 0; d < docsPerThread; d++) {
                try {
            .put("index.merge.policy.max_merge_at_once", 3)
        // Get the primary shard's parquet directory directly via IndexShard
        return Settings.builder()
                        Thread.yield();
        verifyIndex(indexName, 1, totalDocs);
                            String reported = ref.get().getLastCommitFileName();
            .build();
        }
                    }
            for (int i = 0; i < totalDocs; i++) {
            client().admin().indices().prepareRefresh(indexName).get();
                int id = batch * docsPerBatch + d;
        assertFalse("Merger hung", merger.isAlive());
    @Override
                        client().admin().indices().prepareFlush(indexName).setForce(false).setWaitIfOngoing(true).get();
        client().admin().indices().prepareRefresh(indexName).get();
                                continue;
     * merge-on-refresh DISABLED (max_size=0). Verifies that the standard per-writer segment
            }, "mor-indexer-" + t);
    }
        }
        ensureGreen(indexName);
     */
        indexer2.join(60_000);
     */
            .prepareCreate(indexName)
                    Thread.sleep(randomIntBetween(50, 200));
        client().admin()
                    }
                            IndexResponse response = client().prepareIndex()
            .setSettings(mergeOnRefreshSettings())
        AtomicInteger indexedCount = new AtomicInteger(0);
     * Sorted index with merge-on-refresh DISABLED. Verifies that per-writer segments
            assertTrue("Orphan parquet files on disk not referenced by catalog: " + orphans, orphans.isEmpty());
                    barrier.await();
    /**
        // Final refresh + flush
        try (GatedCloseable<CatalogSnapshot> gated = shard.getCatalogSnapshot()) {
                try {
    /**
            AtomicInteger failures = new AtomicInteger(0);
        // Collect all parquet files referenced by the catalog
            client().admin()
            .prepareCreate(indexName)
            CompositeDataFormatPlugin.class,
            .build();
        // Single refresh triggers merge-on-refresh
        // Refresh and flush all indices
        int numThreads = 3;
        client().admin().indices().prepareCreate(indexName).setSettings(indexSettings(numShards)).get();
            }
                }
    }
            .setSettings(mergeOnRefreshDisabledSortedSettings())
                            .get();
            .get();
            .setSettings(mergeOnRefreshSortedSettings())
        return Arrays.asList(
            t.join(60_000);
        for (int t = 0; t < numThreads; t++) {
                assertFalse("Thread hung", t.isAlive());
     * <p>The test pushes high contention with multiple parallel indexer + flusher + refresher
            t.join(30_000);
                    forceMergeCount.incrementAndGet();
        }, "force-merger");
     * must be deleted. Without proper cleanup, each merge-on-refresh would leak N-1 files.
            .put("index.merge.policy.max_merge_at_once", 3)
        long totalMerges = statsResponse.getIndex(indexName).getTotal().getMerge().getTotal();
                try {
        try (var stream = java.nio.file.Files.list(parquetDir)) {
     * Verifies no deadlock or data loss under continuous auto-refresh + merge-on-refresh.
        int docsPerThread = 10;
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
    }
            CyclicBarrier barrier = new CyclicBarrier(threadsPerCycle);
    }
                } catch (Exception e) {
                } catch (Exception e) {
                    Thread.sleep(randomIntBetween(100, 200));
            // Every file on disk must be referenced by the catalog (no orphans)
                    for (int d = 0; d < docsPerThread; d++) {
    }
import org.opensearch.common.concurrent.GatedCloseable;
        Thread merger = new Thread(() -> {
            .setMapping("name", "type=keyword", "value", "type=integer")
        forceMerger.start();
        for (int cycle = 0; cycle < cycles; cycle++) {
            .build();
                    }
        }, "refresher");
                    client().admin().indices().prepareFlush(indexName).setForce(false).setWaitIfOngoing(true).get();
     */
        for (int cycle = 0; cycle < cycles; cycle++) {
            Thread[] threads = new Thread[threadsPerCycle];
        IndicesStatsResponse statsResponse = client().admin().indices().prepareStats(indexName).clear().setMerge(true).get();
public class CompositeConcurrentIndexingIT extends OpenSearchIntegTestCase {
     * Verifies RowIdMapping correctness: after inline merge, both formats are aligned.
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        verifyIndex(indexName, 1, totalDocs);
            .put("index.composite.primary_data_format", "parquet")
        return Settings.builder()
import org.opensearch.cluster.metadata.IndexMetadata;
        String indexName = "merge-no-orphans";
        }, "flusher");
            .put("index.composite.merge_on_refresh_max_size", "10mb")
        // Final explicit refresh + flush
                    }
                            .get();
            }, "auto-refresh-indexer-" + t);
            try {
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
            ensureGreen(idx);
        }, "indexer-2");
                            try {
                .setMapping("name", "type=keyword", "value", "type=integer")
        return Settings.builder()
            .prepareCreate(indexName)
                    }
            assertFalse("Thread did not finish in time: " + t.getName(), t.isAlive());
                        Thread.sleep(randomIntBetween(20, 80));
        Thread[] refreshers = new Thread[numRefreshers];
        AtomicInteger indexedCount = new AtomicInteger(0);
                            .setSource("name", "t" + threadId + "_d" + d, "value", randomIntBetween(0, 500))
import org.opensearch.common.util.FeatureFlags;
            int threadId = t;
        int numShards = 2;
        }
    }
    public void testInterleavedIndexRefreshFlush() throws Exception {
        int bulkBatches = 5;
            threads[t] = new Thread(() -> {
import org.opensearch.index.IndexService;
                            .setIndex(indexName)
        );
                int threadId = idxOrd * threadsPerIndex + t;
        // Use enough cycles so multiple segments accumulate regardless of writer distribution
    // ══════════════════════════════════════════════════════════════════════
        client().admin().indices().prepareRefresh(indexName).get();
            .get();
            int threadId = t;
            .put("index.refresh_interval", "-1")
        client().admin().indices().prepareDelete(indexName).get();
        int docsPerBatch = 10;
                }
    /**
            assertFalse("Thread did not finish in time: " + t.getName(), t.isAlive());
        forceMerger.setDaemon(true);
    // ── Helpers ──
            threads[t].start();
            } catch (Exception e) {
     * are produced independently (no inline consolidation) and data is intact.
                            .setIndex(indexName)
            .put("index.pluggable.dataformat", "composite")
        Thread forceMerger = new Thread(() -> {
        flusher.start();
        // Stop force merger
        int numThreads = 3;
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
     * background merge handles consolidation.
                .indices()
            for (Segment seg : snapshot.getSegments()) {
                    client().admin().indices().prepareForceMerge(indexName).setMaxNumSegments(1).get();
        int totalDocs = numThreads * docsPerThread;
                            if (reported == null || !reported.startsWith("segments_")) {
        ensureGreen(indexName);
                });
 * with the composite engine (Parquet primary format).
                try {
        Thread[] threads = new Thread[numThreads];
        for (String idx : INDEX_NAMES) {
import org.opensearch.action.index.IndexResponse;
            }, "race-flusher-" + t);
            AtomicInteger failures = new AtomicInteger(0);
            }
        assertEquals(0, failures.get());
        int totalDocs = randomIntBetween(50, 100);
        for (int batch = 0; batch < bulkBatches; batch++) {
    }
        }
                }
    private Settings mergeOnRefreshSettings() {
                        }
        String indexName = "merge-concurrent-force-unsorted";
        Set<Long> allGenerations = new HashSet<>();
        client().admin().indices().prepareDelete(indexName).get();
                            .setIndex(indexName)
                for (int i = 0; i < totalDocs / 2; i++) {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 *   --tests "*.CompositeConcurrentIndexingIT" -Dsandbox.enabled=true
            .setSettings(mergeOnRefreshAutoRefreshSettings())
            // Verify segment generation uniqueness within this shard
            .prepareCreate(indexName)
        for (Thread t : indexers)
                    catalogFiles.addAll(wfs.files());
            // Each refresh may trigger merge-on-refresh (consolidating per-writer segments)
            var response = bulkRequest.get();
        }
                    barrier.await();
            .indices()
                }
     * After 5 cycles → 5 segments. forceMerge(1) must merge them into 1.
import org.opensearch.common.settings.Settings;
                }
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(indexName));
    public void testConcurrentFlushAndRefreshHoldsRefreshLock() throws Exception {
        String indexName = "merge-on-refresh-concurrent";
    }
        Thread[] threads = new Thread[numThreads];
            DataFusionPlugin.class
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .prepareCreate(indexName)
                    }
            threads[t] = new Thread(() -> {
            DataformatAwareCatalogSnapshot snapshot = DataformatAwareCatalogSnapshot.deserializeFromString(
                        }
                .get();
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
    private Settings mergeOnRefreshAutoRefreshSettings() {
        Thread indexer2 = new Thread(() -> {
            .putList("index.composite.secondary_data_formats", "lucene")
        ensureGreen(indexName);
                "Commit data should contain catalog snapshot for shard " + ss.getShardRouting().shardId(),
        refresher.join(60_000);
        }
     * Concurrent indexing with merge-on-refresh and sorted index (Parquet + Lucene).
                failures.incrementAndGet();
    private Settings mergeOnRefreshDisabledSettings() {
        }
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
        // With merge-on-refresh disabled, each writer produces its own segment
                    }
        client().admin().indices().prepareRefresh(indexName).get();
import org.opensearch.index.engine.exec.Segment;
            .putList("index.composite.secondary_data_formats", "lucene")
                    // Expected during concurrent indexing — shard may be relocating or refreshing
                .setSettings(indexSettings(numShards))
        }
        int totalDocs = cycles * threadsPerCycle * docsPerThread;
     * commit file that actually exists on disk — the direct invariant the {@code refreshLock}
 * correctly handles concurrent document writes, refresh, flush, and merge across
            .putList("index.sort.missing", "_last")
     * path still works correctly — each refresh produces N segments (one per writer), and
                }
            .setMapping("name", "type=keyword", "value", "type=integer")
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .build();
        String indexName = INDEX_NAMES[0];
            DataformatAwareCatalogSnapshot snapshot = (DataformatAwareCatalogSnapshot) gated.get();
     * Auto-refresh enabled (1s interval) with merge-on-refresh. Concurrent indexing
            int threadId = t;
        CyclicBarrier barrier = new CyclicBarrier(4);
                for (int i = 0; i < totalDocs / 2; i++) {
        assertEquals(0, failures.get());
 * compatible open source license.
                    try {
        int numRefreshers = 3;
    /**
            Set<String> catalogFiles = new HashSet<>();
import org.opensearch.be.datafusion.DataFusionPlugin;
                assertTrue(
            try {
        AtomicInteger failures = new AtomicInteger(0);
                    } catch (Exception e) {
        CyclicBarrier barrier = new CyclicBarrier(numThreads);
                barrier.await();
            threads[t].start();
        client().admin()
     *
            .get();
                threads[threadId] = new Thread(() -> {
        client().admin().indices().prepareDelete(indexName).get();
                    Thread.sleep(randomIntBetween(100, 300));
            .get();
                    failures.incrementAndGet();
                            .setSource("name", "t" + threadId + "_d" + d, "value", threadId * 100 + d)
        }
            Thread[] threads = new Thread[threadsPerCycle];
        forceMerger.interrupt();
     * triggers periodic auto-refreshes, each potentially consolidating per-writer segments.
            .putList("index.sort.field", "value")
        assertNotNull("primary shard for [" + indexName + "][0] must be available", primaryShard);
                }
        int cycles = 5;
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
     * inline merge. Verifies row count and segment consolidation.
            }, "sorted-disabled-indexer-" + t);
            .get();
        for (int t = 0; t < numThreads; t++) {
            .indices()
     * Multiple refresh cycles each produce 1 consolidated segment via merge-on-refresh.
        // Final flush
                            .setIndex(indexName)
        // 1 refresh thread
                        try (GatedCloseable<CatalogSnapshot> ref = primary.acquireSafeCatalogSnapshot()) {
        return Settings.builder()
        for (Thread t : refreshers)
        int docsPerIndexer = 50;
        // Verify data correctness
            .putList("index.sort.missing", "_last")
                }
            .indices()
                .map(p -> p.getFileName().toString())
    }
            diskFiles = stream.filter(p -> p.toString().endsWith(".parquet"))
                            primary.store().incRef();
                        client().admin().indices().prepareRefresh(indexName).get();
            assertFalse("Thread did not finish in time: " + t.getName(), t.isAlive());
        final IndexShard primary = primaryShard;
    public void testMergeOnRefreshWithBulkWaitFor() throws Exception {
 * <p>Run with:
            for (int t = 0; t < threadsPerCycle; t++) {
        long totalRows = 0;
            int threadId = t;
     * across the entire {@code DataFormatAwareEngine.flush()} body. Without that lock, a
     */
            .put("index.composite.merge_on_refresh_max_size", "10mb")
            .put("index.pluggable.dataformat.enabled", true)
import java.io.IOException;
     */
    /**
        ensureGreen(indexName);
                    for (int i = 0; i < docsPerIndexer; i++) {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2)
        Thread[] threads = new Thread[numThreads];
            threads[t].start();
            }, "race-indexer-" + t);
import org.opensearch.index.engine.CommitStats;
            .putList("index.composite.secondary_data_formats", "lucene")
     * Concurrent force merge + indexing + explicit refresh on unsorted index.
import java.util.Arrays;
                        logger.error("Indexing failed in thread " + threadId, e);
            .putList("index.sort.field", "value")
            .setMapping("name", "type=keyword", "value", "type=integer")
            super.tearDown();
                }
                        barrier.await();
        }
            .setMapping("name", "type=keyword", "value", "type=integer")
        indexer.start();
                    failures.incrementAndGet();
        assertEquals("No worker thread should have failed under concurrent flush/refresh", 0, failures.get());
            assertFalse("Thread did not finish in time: " + t.getName(), t.isAlive());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        Thread[] indexers = new Thread[numIndexers];
        }
        assertEquals(0, failures.get());
        for (Thread t : flushers)
        CyclicBarrier barrier = new CyclicBarrier(totalThreads);
                        failures.incrementAndGet();
        );
        assertFalse("Indexer hung", indexer.isAlive());
                    break;
        Thread[] threads = new Thread[numThreads];
                        failures.incrementAndGet();
 * </ul>
            .put("index.composite.primary_data_format", "parquet")
                    failures.incrementAndGet();
            .put("index.refresh_interval", "-1")
            for (Thread t : threads) {
                try {
        assertEquals("Committed snapshot's lastCommitFileName must always match an existing segments_<N> on disk", 0, raceDetected.get());
                        // must (a) be non-null and (b) reference a segments_<N> that is still
        verifyIndex(indexName, numShards, indexedCount.get());
        merger.join(10_000);
        for (Thread t : threads) {
                    for (int i = 0; i < flushesPerThread; i++) {
                                .setIndex(indexName)
        int refreshesPerThread = 8;
        for (Thread t : threads) {
 * multiple indices with multiple shards, ensuring:
            t.join(60_000);
        // Verify no data loss — all docs present regardless of which merge path handled them
        }, "indexer-1");
        int docsPerThread = 10;
        client().admin()
                }
    // Merge-on-refresh with auto-refresh and force merge
                    }
        String indexName = "sorted-merge-disabled";
}
