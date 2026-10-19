        controller.assertWriting(shard0, 8);
        );
            return new ArrayList<>(indexBufferRAMBytesUsed.keySet());
        Iterable<IndexShard> iterable = () -> (shardRef.get() == null)  
        // shard1 crossed 5 mb and is now cleared:
        shard.markAsRecovering("store", new RecoveryState(shard.routingEntry(), localNode, null));
        );
    ThreadPoolStats.Stats getRefreshThreadPoolStats() {
            : Collections.singleton(shardRef.get()).iterator();
            threadPool,
            () -> new MockController(Settings.builder().put("indices.memory.max_index_buffer_size", "-6mb").build())
import static org.hamcrest.Matchers.equalTo;
        };
import org.opensearch.index.codec.CodecService;
            super(  
    }  
        controller.simulateIndexing(shard0);
            .eventListener(config.getEventListener())
            Settings.builder().put("indices.memory.index_buffer_size", "1kb").put("indices.memory.native_index_buffer_size", "1gb").build()
    }
        // add a new one
import java.util.HashMap;
            .retentionLeasesSupplier(config.retentionLeasesSupplier())
        controller.assertBuffer(shard0, 0);
import java.util.ArrayList;  
            @Override
        final List<ReferenceManager.RefreshListener> internalRefreshListener = new ArrayList<>(config.getInternalRefreshListener());
            if (actual == null) {
        protected long getNativeBytesUsed(IndexShard shard) {  
    public void testNativeUnderBudgetDoesNotTriggerRefresh() throws IOException {
import org.opensearch.index.engine.EngineConfig;  
    }  
            .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())
                actual = 0L;  
        );
    }  
        assertEquals(200L * 1024 * 1024, controller.nativeBufferSizeInBytes());
import org.opensearch.index.shard.IndexShardTestCase;
    }
        public void writeIndexingBufferAsync(IndexShard shard) {
 * under the License.  
        // If sort key is heap+native, shard A is refreshed first.
            indexBufferRAMBytesUsed.remove(shard);
        @Override
        shardRef.set(shard);
        // Native memory used by each shard
            assertTrue(throttled.contains(shard));
    }
            assertTrue(throttled.add(shard));
        final RefreshStats refreshStats = shard.refreshStats();
        controller.writingBytes.put(shardA, 0L);
        controller.assertBuffer(shard0, 1);
        closeShards(shardA, shardB);
        controller.assertBuffer(shard1, 2);  
                + "[-42s] as a time value: negative durations are not supported",  
        closeShards(shard);
        }  
        // Shard A: high heap, low native. Shard B: low heap, high native.
        controller.simulateIndexing(shard0);  
        controller.indexBufferRAMBytesUsed.put(shardB, 500_000L);  
        assertEquals("failed to parse setting [indices.memory.max_index_buffer_size] with value [-6mb] as a size in bytes", e.getMessage());  
                .put("indices.memory.index_buffer_size", "1024b")
        // With B refreshed: totalHeap = 2300 - 1500 = 800 < 1024, so A should NOT be refreshed  
 */  
        );
            Long bytes = indexBufferRAMBytesUsed.get(shard);  
import java.util.concurrent.CountDownLatch;
        controller.simulateIndexing(shard0);  
        );
        controller.writingBytes.put(shardB, 0L);  
        // Shard A: heap=600, native=600, total=1200
        closeShards(shard);
 * Licensed to Elasticsearch under one or more contributor  
        logger.info("--> Indexing more data");
 * not use this file except in compliance with the License.
        controller.assertWriting(shard1, 4);
        controller.writingBytes.put(shard, 0L);
            Settings.builder()
    }  
                .put("indices.memory.index_buffer_size", "10mb") // high heap budget
}
    }
        controller.indexBufferRAMBytesUsed.put(shard, 200_000L); // 200kb > 100kb heap budget
    public void testThrottleActivatedOnNativePressure() throws IOException {
            .flushMergesAfter(config.getFlushMergesAfter())
        public void deactivateThrottling(IndexShard shard) {  
        controller.simulateIndexing(shard1);  
import java.util.List;
            Settings.builder()  
            .tombstoneDocSupplier(config.getTombstoneDocSupplier())
        }
/*
            }
        controller.writingBytes.put(shardA, 0L);
        // We are now using 5 MB, so we should be writing shard0 since it's using the most heap:  
        int iterations = randomIntBetween(10, 100);
                return 0;
            ? Collections.emptyIterator()
import java.util.Collections;
            Settings.builder().put("indices.memory.index_buffer_size", "90%").put("indices.memory.max_index_buffer_size", "6mb").build()  
        @Override  
        controller.simulateIndexing(shard0);
        IndexShard shard1 = newStartedShard();
        closeShards(shard);
        assertThat(controller.indexingBufferSize(), equalTo(new ByteSizeValue(6, ByteSizeUnit.MB)));  
        // More indexing to shard0
        controller.simulateIndexing(shard0);  
    public void testHeapBudgetStillTriggersRefreshIndependently() throws IOException {
            .similarity(config.getSimilarity())
        MockController controller = new MockController(  
            .queryCachingPolicy(config.getQueryCachingPolicy())  
        controller.assertThrottled(shard1);
        refreshLatch.set(new CountDownLatch(1)); // block refresh  
import java.util.Set;  
            assertEquals(expectedMB * 1024 * 1024, actual.longValue());
        IndexShard shard = newShard(true);
 *  
        IndexShard shard = newShard(true);
            } else {  
import org.opensearch.common.SetOnce;  
            controller.forceCheck();
import org.opensearch.core.common.unit.ByteSizeValue;  
import org.opensearch.index.refresh.RefreshStats;  
            writingBytes.remove(shard);  
            .store(config.getStore())
        assertThat("we should have flushed in IMC at least once", flushes.get(), greaterThanOrEqualTo(1));
        controller.simulateIndexing(shard1);
        }
            () -> new MockController(Settings.builder().put("indices.memory.shard_inactive_time", "-42s").build())  
            .translogConfig(config.getTranslogConfig())
        );
import org.opensearch.index.engine.InternalEngine;
            .threadPool(config.getThreadPool())
        controller.indexBufferRAMBytesUsed.put(shard, 50L); // well under heap budget
            assertTrue(throttled.remove(shard));
            .queryCache(config.getQueryCache())
        controller.assertWriting(shard0, 3);  
            if (bytes == null) {
        controller.assertThrottled(shard1);  
        controller.assertNotThrottled(shard0);
        controller.setNativeBufferBytes(200L * 1024 * 1024);
            writingBytes.put(shard, 0L);
    public void testNegativeMaxIndexBufferSize() {
        controller.forceCheck();
        );
        }
        controller.simulateIndexing(shard1);
    public void testSkipRefreshIfShardIsRefreshingAlready() throws Exception {  
                return 0L;
        MockController controller = new MockController(
        // Both budgets exceeded. Shard A total=13000, Shard B total=9000  
                .put("indices.memory.index_buffer_size", "100kb")
    public void testNegativeInterval() {
            long bytes = indexBufferRAMBytesUsed.put(shard, 0L);  
            assertFalse(throttled.contains(shard));  
        );  
        controller.writingBytes.put(shard, 0L);  
        }  
            .codecService(new CodecService(null, config.getIndexSettings(), logger, List.of()))  
            }
        assertEquals(0L, (long) controller.indexBufferRAMBytesUsed.get(shardA));
        closeShards(shard0, shard1);  
        ThreadPoolStats.Stats beforeStats = getRefreshThreadPoolStats();  
        controller.assertNotThrottled(shard0);
        @Override
        IndexShard shardB = newShard(true);
        closeShards(shard);
        MockController controller = new MockController(  
        );  
    }
        // Now we are still writing 3 MB (shard0), and using 5 MB index buffers, so we should now 1) be writing shard1,
        controller.simulateIndexing(shard2);  
    }
            .primaryTermSupplier(config.getPrimaryTermSupplier())  
                .put("indices.memory.native_index_buffer_size", "10mb")
        // Shard A should be refreshed first
/*  
        controller.simulateIndexing(shard0);
        };  
        controller.assertBuffer(shard1, 2);  
            e.getMessage()
                return s;  
        assertEquals(0L, (long) controller.nativeMemoryUsed.get(shardB));
        refreshLatch.get().countDown(); // allow refresh
        Exception e = expectThrows(
        controller.writingBytes.put(shard, 0L);
        }  
        protected void checkIdle(IndexShard shard, long inactiveTimeNS) {}
        assertEquals(
        controller.simulateIndexing(shard0);
        // depending on whether refreshing A alone brings native under budget
        controller.nativeMemoryUsed.put(shardA, 8000L);
        // Shards that are currently throttled
    public void testHeapOnlySortKeyUsedWhenOnlyHeapExceeds() throws IOException {  
        assertEquals(0L, (long) controller.indexBufferRAMBytesUsed.get(shard));  
            () -> new MockController(Settings.builder().put("indices.memory.interval", "-42s").build())
            indexBufferRAMBytesUsed.put(shard, 0L);
        assertEquals(0L, (long) controller.nativeMemoryUsed.get(shardA));
        controller.assertBuffer(shard0, 1);
        };
    }
                null  
                    .put(settings)  
        controller.deleteShard(shard1);
        IndexShard shardB = newShard(true);
        );  
        controller.indexBufferRAMBytesUsed.put(shardA, 600L);  
    EngineConfig configWithRefreshListener(EngineConfig config, ReferenceManager.RefreshListener listener) {  
import java.util.Map;
            .externalRefreshListener(config.getExternalRefreshListener())  
                return bytes;
        controller.assertWriting(shard1, 4);  
        AtomicInteger flushes = new AtomicInteger();  
        controller.simulateIndexing(shard0);
        controller.assertBuffer(shard2, 1);
        for (ThreadPoolStats.Stats s : stats) {
                .build()
        // and 2) be throttling shard1:
        }
        Settings settings = Settings.builder().put("indices.memory.index_buffer_size", "50kb").build();
 * the Apache License, Version 2.0 (the "License"); you may
        controller.simulateIndexing(shard1);  
        // If sort key is native-only, shard B is refreshed first.
 */
        }  
                writingBytes.put(shard, 0L);
        controller.indexBufferRAMBytesUsed.put(shardA, 100L);
        assertEquals(100L * 1024 * 1024, controller.nativeBufferSizeInBytes());
    }  
            IllegalArgumentException.class,
        assertThat(controller.indexingBufferSize(), equalTo(new ByteSizeValue(6, ByteSizeUnit.MB)));
        IndexShard shard0 = newStartedShard();  
        // Update again
            }
                // First time we are seeing this shard:  
        closeShards(shardA, shardB);
import org.opensearch.core.xcontent.MediaTypeRegistry;
            Settings.EMPTY,  
            writingBytes.put(shard, writingBytes.get(shard) + bytes);
        // Native budget = 10MB (high), heap budget = 100kb  
        controller.assertBuffer(shard0, 3);
        controller.assertBuffer(shard1, 1);  
        assertEquals(100L, (long) controller.nativeMemoryUsed.get(shardA));  
        }
        Exception e = expectThrows(  
    public void testCombinedSortKeyUsedWhenBothExceed() throws IOException {
        controller.forceCheck();  
 * ownership. Elasticsearch licenses this file to you under  
        IndexShard shard1 = newStartedShard();
        // Both budgets exceeded. Shard A has lower heap but higher native → higher total.
public class IndexingMemoryControllerTests extends IndexShardTestCase {
        controller.simulateIndexing(shard0);
        controller.setNativeBufferBytes(50L * 1024 * 1024);
        }
        public void assertBuffer(IndexShard shard, int expectedMB) {
        }
            .mergePolicy(config.getMergePolicy())  
                if (refreshLatch.get() != null) {
                Settings.builder()
        controller.nativeMemoryUsed.put(shard, 2_000_000L); // 2MB > 1.5 × 1MB = 1.5MB throttle threshold
        controller.simulateIndexing(shard0);
            nativeMemoryUsed.put(shard, 0L);  
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        );  
            Settings.builder()
        MockController controller = new MockController(  
            }  
        );  
    public void testSetNativeBufferBytesUpdatesThreshold() {
            Settings.builder().put("indices.memory.index_buffer_size", "1kb").put("indices.memory.native_index_buffer_size", "1kb").build()  
        controller.assertBuffer(shard0, 2);
            randomBoolean(),
            public void beforeRefresh() {
 */
            @Override
        MockController controller = new MockController(
        controller.writingBytes.put(shardA, 0L);
        for (int i = 0; i < iterations; i++) {
                .build()
        });  
        controller.forceCheck();
        controller.writingBytes.put(shard, 0L);
            Settings.builder().put("indices.memory.index_buffer_size", "10mb").put("indices.memory.native_index_buffer_size", "1gb").build()  
    static class MockController extends IndexingMemoryController {  
        MockController controller = new MockController(
        // Shard B: higher heap, low native
        }
        @Override
        controller.nativeMemoryUsed.put(shard, 10_000_000L); // 10MB native — under 1gb budget  
            indexDoc(shard, Integer.toString(i), "{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON, null);
        public void simulateIndexing(IndexShard shard) {
        MockController controller = new MockController(Settings.builder().put("indices.memory.index_buffer_size", "5mb").build());
        // Shard B has higher heap but lower native → lower total.  
        controller.assertBuffer(shard1, 1);
            Settings.builder().put("indices.memory.index_buffer_size", "0.001%").put("indices.memory.min_index_buffer_size", "6mb").build()
        closeShards(shard);  
        controller.assertBuffer(shard0, 0);  
        IndexShard shard0 = newStartedShard();  
        closeShards(shardA, shardB);
            }
        @Override
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.indices.recovery.RecoveryState;  
                null,
    }
        controller.assertBuffer(shard0, 1);
            .internalRefreshListener(internalRefreshListener)
 *
        controller.simulateIndexing(shard1);  
                + "[-42s] as a time value: negative durations are not supported",
            IllegalArgumentException.class,  
            ThreadPoolStats.Stats stats = getRefreshThreadPoolStats();
        assertEquals(0L, (long) controller.nativeMemoryUsed.get(shardA)); // A was refreshed  
        IndexShard shardB = newShard(true);  
        closeShards(shard);
            protected long getIndexBufferRAMBytesUsed(IndexShard shard) {
        controller.writingBytes.put(shard, 0L);  
        // Shard A should NOT be refreshed: totalNative = 1100 - 1000 = 100 < 1024
        // Heap budget = 1kb (exceeded), native budget = 1gb (not exceeded)
 * this work for additional information regarding copyright
    }
        assertBusy(() -> {
    public void testNativeBudgetTriggersRefreshWhenExceeded() throws IOException {
        controller.deleteShard(shard0);
        });
        controller.writingBytes.put(shardB, 0L);
        controller.indexBufferRAMBytesUsed.put(shard, 50L); // under 100kb heap budget
            if (bytes == null) {
import java.io.IOException;
        final Map<IndexShard, Long> nativeMemoryUsed = new HashMap<>();  
        shard = reinitShard(shard, imc);  
    public void testNoThrottleWhenNativeUnderBudget() throws IOException {
        final ThreadPoolStats stats = threadPool.stats();  
        @Override
                .put("indices.memory.interval", "200h") // disable it
 * compatible open source license.
        public void assertNotThrottled(IndexShard shard) {
        assertEquals(0L, (long) controller.indexBufferRAMBytesUsed.get(shard));  
    public void testTranslogRecoveryWorksWithIMC() throws IOException {
        controller.forceCheck();
        // Refresh triggered because native exceeded budget
                return randomLongBetween(1025, 10 * 1024 * 1024);  
    public void testNegativeMinIndexBufferSize() {
        MockController controller = new MockController(
    public void testShardAdditionAndRemoval() throws IOException {  
        // Refresh triggered because heap exceeded budget (native is fine)
            () -> new MockController(Settings.builder().put("indices.memory.min_index_buffer_size", "-6mb").build())
        controller.nativeMemoryUsed.put(shardB, 1000L); // native higher than ShardA  
            @Override  
        closeShards(shard);
            .put("indices.memory.native_index_buffer_size", "100mb")
        // Both shards finally finish writing, and throttling should stop:
                    try {  
        IndexShard shard0 = newStartedShard();  
        ReferenceManager.RefreshListener refreshListener = new ReferenceManager.RefreshListener() {
                .put("indices.memory.native_index_buffer_size", "1gb")  
        internalRefreshListener.add(listener);  
import org.opensearch.core.common.unit.ByteSizeUnit;
            );
    }  
        IndexShard shard2 = newStartedShard();
            Settings.builder().put("indices.memory.index_buffer_size", "1gb").put("indices.memory.native_index_buffer_size", "1kb").build()
        MockController controller = new MockController(
        controller.nativeMemoryUsed.put(shard, 2_000_000L); // 2MB > 1MB native budget
    public void testThrottling() throws Exception {  
        controller.forceCheck();
        controller.assertBuffer(shard1, 4);
            .warmer(config.getWarmer())
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import org.opensearch.common.settings.Settings;
        public void activateThrottling(IndexShard shard) {
        assertEquals(800L, (long) controller.indexBufferRAMBytesUsed.get(shardA));
        assertThat(shard.refreshStats().getTotal(), equalTo(refreshStats.getTotal() + 1));
        assertEquals(0L, (long) controller.indexBufferRAMBytesUsed.get(shardB));
        // Sort key should be heap-only → shard B (1500) refreshed before shard A (800)
        // Two shards: shard A has high native, shard B has high heap but low native
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        controller.nativeMemoryUsed.put(shard, 100_000_000L); // 100MB native — under 1gb budget
        // Shard A: low heap, high native  
        controller.indexBufferRAMBytesUsed.put(shardA, 5000L);  
                    .build(),
        // Native budget set high (1gb), native usage is under budget — should NOT trigger
import org.opensearch.threadpool.ThreadPoolStats;  
        MockController controller = new MockController(
        // remove second shard  
 *
        closeShards(shard0, shard1);
        assertEquals(500L, (long) controller.indexBufferRAMBytesUsed.get(shardB));  
        }
        protected List<IndexShard> availableShards() {
            }
        controller.indexBufferRAMBytesUsed.put(shardB, 7000L);
        controller.assertBuffer(shard1, 0);
        IndexShard shard = newShard(true);  
            }  
        @Override  
                shard.writeIndexingBuffer();  
        // Shard A should be refreshed first (higher native), shard B may or may not be refreshed
        // Total heap = 2300 > 1024. Only heap over budget.  
    }
        IndexShard shardA = newShard(true);  
        protected Cancellable scheduleTask(ThreadPool threadPool) {
            return indexBufferRAMBytesUsed.get(shard) + writingBytes.get(shard);
    }
import org.apache.lucene.search.ReferenceManager;  
        }  
                .put("indices.memory.native_index_buffer_size", "1mb")  
            .build();
        MockController controller = new MockController(
        controller.simulateIndexing(shard1);
    }
        MockController(Settings settings) {
import org.opensearch.Version;
            if (s.getName().equals(ThreadPool.Names.REFRESH)) {
        closeShards(shardA, shardB);
        );  
            @Override  
        controller.assertBuffer(shard0, 0);
                    } catch (InterruptedException e) {
        // Shard B must have been refreshed (native was highest)  
            Settings.builder()
            ThreadPoolStats.Stats stats = getRefreshThreadPoolStats();
        controller.assertBuffer(shard1, 1);
            return nativeMemoryUsed.getOrDefault(shard, 0L);
                bytes = 0L;
        controller.assertBuffer(shard1, 0);
        protected long getIndexBufferRAMBytesUsed(IndexShard shard) {  
 * SPDX-License-Identifier: Apache-2.0
        // Shard A: low heap, high native. Shard B: high heap, low native.
        controller.writingBytes.put(shardB, 0L);  
        controller.writingBytes.put(shardA, 0L);
        // Sort key = heap+native → shard A (1200) > shard B (1000), so A refreshed first, B won't be refreshed
/*
        controller.indexBufferRAMBytesUsed.put(shardB, 800L); // heap lower than ShardA
        assertTrue(recoverFromStore(shard));
        // remove first shard
        MockController controller = new MockController(
                .build()
        final Set<IndexShard> throttled = new HashSet<>();  
        controller.nativeMemoryUsed.put(shardB, 2000L);
 *     http://www.apache.org/licenses/LICENSE-2.0
            Long actual = writingBytes.get(shard);
        IndexShard shardB = newShard(true);
                .put("indices.memory.index_buffer_size", "100kb")  
        Settings settings = Settings.builder()  
        Exception e = expectThrows(
import static java.util.Collections.emptyMap;
import java.util.concurrent.atomic.AtomicReference;  
                    .put("indices.memory.interval", "200h") // disable it
        }
            Long actual = indexBufferRAMBytesUsed.get(shard);  
        shard.close("simon says", false, false);  
            forceCheck();  
                .put("indices.memory.native_index_buffer_size", "1mb")
        controller.indexBufferRAMBytesUsed.put(shardA, 800L);
        assertEquals(0, imc.availableShards().size());
        // How many bytes this shard is currently moving to disk
        controller.assertBuffer(shard1, 0);  
        @Override  
package org.opensearch.indices;
        IndexShard shardA = newShard(true);
        controller.nativeMemoryUsed.put(shardA, 900_000L); // 900KB  
        // Shard B: high heap + low native = lower total
    }  
            "failed to parse setting [indices.memory.interval] with value "
 * specific language governing permissions and limitations
        controller.simulateIndexing(shard1);  
        for (int i = 0; i < 100; i++) {  
        );
        controller.simulateIndexing(shard1);
        controller.assertThrottled(shard0);
                assertEquals(shard, shardRef.get());
    }
    // --- Dual-budget (heap + native) tests ---
            }
            .indexSettings(config.getIndexSettings())  
        );
    public void testActiveInactive() throws IOException {
        controller.forceCheck();
        // Initial value from setting: 100MB  
            .analyzer(config.getAnalyzer())
        MockController controller = new MockController(Settings.builder().put("indices.memory.index_buffer_size", "4mb").build());
        Exception e = expectThrows(  
        IndexShard shardA = newShard(true);  
        public void assertWriting(IndexShard shard, int expectedMB) {  
        public void doneWriting(IndexShard shard) {
            }
        IndexShard shardA = newShard(true);
        // Shard B must have been refreshed (heap was highest)
                flushes.incrementAndGet();
        controller.writingBytes.put(shardA, 0L);
        controller.forceCheck();  
import org.opensearch.threadpool.ThreadPool;
        // Heap budget = 1gb (not exceeded), native budget = 1kb (exceeded)  
        IndexShard shard = newShard(true);
        ;
        controller.simulateIndexing(shard1);  
        IndexShard shard1 = newStartedShard();
            Long bytes = writingBytes.get(shard);  
        assertTrue(controller.throttled.contains(shard));  
        // Size of each shard's indexing buffer
        assertEquals(0L, (long) controller.indexBufferRAMBytesUsed.get(shardA));
        controller.assertNotThrottled(shard1);  
        );  
import static java.util.Collections.emptySet;  
        );
        MockController controller = new MockController(settings);
            IllegalArgumentException.class,
        controller.writingBytes.put(shardB, 0L);  
        controller.nativeMemoryUsed.put(shardA, 100L);
        protected long getShardWritingBytes(IndexShard shard) {
    }
        controller.assertBuffer(shard0, 1);
        MockController controller = new MockController(
        controller.indexBufferRAMBytesUsed.put(shard, 100L);  
        final Map<IndexShard, Long> writingBytes = new HashMap<>();  
        controller.simulateIndexing(shard0);
        // Native budget = 1MB, heap budget = 100kb  
                actual = 0L;
        final IndexingMemoryController controller = new IndexingMemoryController(
import java.util.HashSet;  
        // Now we are using 5 MB again, so shard0 should also be writing and now also be throttled:
            .indexSort(config.getIndexSort())
        IndexShard shardA = newShard(true);
            }  
        // If sort key is heap-only, shard B is refreshed first.  
        controller.indexBufferRAMBytesUsed.put(shard, 100L);  
        controller.doneWriting(shard0);
 * software distributed under the License is distributed on an
            assertEquals(expectedMB * 1024 * 1024, actual.longValue());
        // Shard B: heap=500, native=500, total=1000
                .put("indices.memory.index_buffer_size", "100kb")  
 * Modifications Copyright OpenSearch Contributors. See  
 * You may obtain a copy of the License at  
        assertEquals(0L, (long) controller.nativeMemoryUsed.get(shard));
        throw new AssertionError("refresh thread pool stats not found [" + stats + "]");  
        controller.simulateIndexing(shard0);  
 * this file be licensed under the Apache-2.0 license or a
    public void testMaxBufferSizes() {
        controller.forceCheck();
                .build(),  
        controller.assertBuffer(shard1, 2);
    public void testMinBufferSizes() {  
        controller.forceCheck();
        assertEquals(
        IndexShard shard = newStartedShard(
            IllegalArgumentException.class,
        ) {  
        @Override
        controller.assertWriting(shard1, 0);
                .build()
        controller.nativeMemoryUsed.put(shardB, 200_000L); // 200KB
        controller.indexBufferRAMBytesUsed.put(shardA, 1500L);  
        public void deleteShard(IndexShard shard) {
        assertEquals("failed to parse setting [indices.memory.min_index_buffer_size] with value [-6mb] as a size in bytes", e.getMessage());
        controller.forceCheck();
            // Each doc we index takes up a megabyte!  
        assertEquals(500L, (long) controller.nativeMemoryUsed.get(shardB));
        assertEquals(0L, (long) controller.nativeMemoryUsed.get(shardA));
                }
            .put("indices.memory.index_buffer_size", "10%")
            bytes += 1024 * 1024;
        // Total native = 1100 > 1024. Only native over budget.
            .circuitBreakerService(config.getCircuitBreakerService())  
        return new EngineConfig.Builder().shardId(config.getShardId())
            Collections.singleton(shard)
        }  
            new EngineBackedIndexerFactory(config -> new InternalEngine(configWithRefreshListener(config, refreshListener)))
        controller.indexBufferRAMBytesUsed.put(shardB, 1500L); // heap higher than shardA
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.threadpool.Scheduler.Cancellable;
        assertEquals(1, imc.availableShards().size());  
        controller.simulateIndexing(shard1);  
        public void assertThrottled(IndexShard shard) {
    public void testBothBudgetsExceededSortsByTotal() throws IOException {
            @Override
import org.opensearch.index.shard.IndexShard;
            indexBufferRAMBytesUsed.put(shard, bytes);
        controller.simulateIndexing(shard1);
            protected long getShardWritingBytes(IndexShard shard) {
 * license agreements. See the NOTICE file distributed with
                        throw new AssertionError(e);  
    public void testRefreshTargetsSortedByNativeWhenOnlyNativeExceeds() throws IOException {
    }  
    }
import java.util.concurrent.atomic.AtomicInteger;
    public void testNativeOnlySortKeyUsedWhenOnlyNativeExceeds() throws IOException {
                        refreshLatch.get().await();
        assertFalse(controller.throttled.contains(shard));  
        controller.simulateIndexing(shard0);
        controller.nativeMemoryUsed.put(shardB, 100L); // native lower than shardA
        assertEquals(50L, (long) controller.indexBufferRAMBytesUsed.get(shard)); // not refreshed
        IndexShard shard = newShard(true);
        controller.assertWriting(shard0, 3);
            public void afterRefresh(boolean didRefresh) {  
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
        // index into one shard only, crosses the 5mb limit, so shard1 is refreshed
    }
        AtomicReference<IndexShard> shardRef = new AtomicReference<>();
            if (actual == null) {
        controller.forceCheck();
        SetOnce<CountDownLatch> refreshLatch = new SetOnce<>();
        // Shard A: moderate heap + high native = high total
        assertBusy(() -> {  
        );
    public void testNegativeShardInactiveTime() {  
            Settings.builder().put("indices.memory.index_buffer_size", "1kb").put("indices.memory.native_index_buffer_size", "1kb").build()  
            return null;
        IndexShard shard = newStartedShard(true);
        controller.forceCheck();
        controller.nativeMemoryUsed.put(shardB, 500L);
            assertThat(stats.getCompleted(), equalTo(beforeStats.getCompleted() + iterations - 1));  
        // add another shard
        controller.doneWriting(shard1);  
            Settings.builder().put("indices.memory.index_buffer_size", "10mb").put("indices.memory.native_index_buffer_size", "1mb").build()  
 * Unless required by applicable law or agreed to in writing,
        // Dynamically update  
        controller.forceCheck();  
        IndexingMemoryController imc = new IndexingMemoryController(settings, threadPool, iterable) {
        controller.indexBufferRAMBytesUsed.put(shardB, 500L);
        }  
            e.getMessage()
        controller.nativeMemoryUsed.put(shardA, 1000L);  
            Settings.builder()
        controller.nativeMemoryUsed.put(shard, 500_000L); // 500kb < 10MB native budget
        }
        IndexShard shardB = newShard(true);  
            "failed to parse setting [indices.memory.shard_inactive_time] with value "  
        assertEquals(50L * 1024 * 1024, controller.nativeBufferSizeInBytes());  
        closeShards(shardA, shardB);  
 * KIND, either express or implied.  See the License for the
        final Map<IndexShard, Long> indexBufferRAMBytesUsed = new HashMap<>();  
        // Both budgets exceeded (heap total=1100>1024, native total=1100>1024)  
        // Total native = 1.1MB > 1MB budget. Total heap = 500KB < 10MB budget.
 * GitHub history for details.
        MockController controller = new MockController(Settings.builder().put("indices.memory.index_buffer_size", "4mb").build());
        controller.nativeMemoryUsed.put(shardA, 600L);
                    }
        // Sort key should be native-only → shard B (1000) refreshed before shard A (100)  
    }  
            assertThat(stats.getCompleted(), equalTo(beforeStats.getCompleted() + iterations));
        controller.writingBytes.put(shardB, 0L);
        }  
        closeShards(shard0, shard1, shard2);
            protected void writeIndexingBufferAsync(IndexShard shard) {  
            .build();  
        );
