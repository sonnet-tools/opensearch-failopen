            indexBufferRAMBytesUsed.put(shard, bytes);
import java.util.concurrent.atomic.AtomicReference;
    }
        controller.simulateIndexing(shard1);
    }
                return bytes;
        controller.simulateIndexing(shard0);
        assertTrue(recoverFromStore(shard));
        controller.indexBufferRAMBytesUsed.put(shard, 50L); // well under heap budget
        controller.doneWriting(shard0);
        controller.nativeMemoryUsed.put(shardA, 100L);
}
    public void testShardAdditionAndRemoval() throws IOException {
import static java.util.Collections.emptyMap;
    public void testMaxBufferSizes() {
            : Collections.singleton(shardRef.get()).iterator();
        protected long getIndexBufferRAMBytesUsed(IndexShard shard) {
        assertEquals(0L, (long) controller.indexBufferRAMBytesUsed.get(shard));
        public void doneWriting(IndexShard shard) {
            writingBytes.put(shard, writingBytes.get(shard) + bytes);
        controller.indexBufferRAMBytesUsed.put(shard, 100L);
        );
        assertEquals(0L, (long) controller.nativeMemoryUsed.get(shardA));
            () -> new MockController(Settings.builder().put("indices.memory.shard_inactive_time", "-42s").build())
    }
        controller.indexBufferRAMBytesUsed.put(shardB, 1500L); // heap higher than shardA
 * You may obtain a copy of the License at
            indexBufferRAMBytesUsed.put(shard, 0L);
        controller.indexBufferRAMBytesUsed.put(shardA, 1500L);
        assertEquals("failed to parse setting [indices.memory.max_index_buffer_size] with value [-6mb] as a size in bytes", e.getMessage());
            .retentionLeasesSupplier(config.retentionLeasesSupplier())
 * this work for additional information regarding copyright
            Long bytes = indexBufferRAMBytesUsed.get(shard);
    }
            ThreadPoolStats.Stats stats = getRefreshThreadPoolStats();
            @Override
        // remove second shard
                return randomLongBetween(1025, 10 * 1024 * 1024);
    }
        controller.forceCheck();
        controller.indexBufferRAMBytesUsed.put(shardB, 800L); // heap lower than ShardA
            nativeMemoryUsed.put(shard, 0L);
            protected long getIndexBufferRAMBytesUsed(IndexShard shard) {
        controller.nativeMemoryUsed.put(shardA, 900_000L); // 900KB
                if (refreshLatch.get() != null) {
    }
        controller.simulateIndexing(shard1);
        assertBusy(() -> {
 * license agreements. See the NOTICE file distributed with
    public void testCombinedSortKeyUsedWhenBothExceed() throws IOException {
/*
import org.opensearch.Version;
            @Override
    public void testSetNativeBufferBytesUpdatesThreshold() {
        }
            Settings.builder()
        controller.simulateIndexing(shard0);
        IndexShard shardB = newShard(true);
        });
        final Map<IndexShard, Long> nativeMemoryUsed = new HashMap<>();
            super(
 */
import org.opensearch.threadpool.ThreadPool;
        protected long getNativeBytesUsed(IndexShard shard) {
        closeShards(shard);
        controller.indexBufferRAMBytesUsed.put(shardA, 800L);
            .queryCache(config.getQueryCache())
            if (actual == null) {
        assertEquals(
        controller.forceCheck();
        for (ThreadPoolStats.Stats s : stats) {
        // Both budgets exceeded (heap total=1100>1024, native total=1100>1024)
import org.opensearch.cluster.node.DiscoveryNode;
        controller.assertNotThrottled(shard1);
        controller.forceCheck();
    }
        assertEquals(50L * 1024 * 1024, controller.nativeBufferSizeInBytes());
        controller.simulateIndexing(shard0);
    public void testNativeOnlySortKeyUsedWhenOnlyNativeExceeds() throws IOException {
    }
        // shard1 crossed 5 mb and is now cleared:
        controller.nativeMemoryUsed.put(shardA, 600L);
        // Shard A: moderate heap + high native = high total
            indexDoc(shard, Integer.toString(i), "{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON, null);
            Long bytes = writingBytes.get(shard);
    public void testNegativeInterval() {
        );
            .build();
        Settings settings = Settings.builder().put("indices.memory.index_buffer_size", "50kb").build();
        controller.nativeMemoryUsed.put(shardA, 8000L);
        // Shard A: high heap, low native. Shard B: low heap, high native.
            assertEquals(expectedMB * 1024 * 1024, actual.longValue());
        // add a new one
    }
                actual = 0L;
        MockController controller = new MockController(
        }
    }
            .indexSettings(config.getIndexSettings())
        IndexShard shard = newShard(true);
                .build()
        // Update again
        // Sort key should be native-only → shard B (1000) refreshed before shard A (100)
        assertEquals(100L * 1024 * 1024, controller.nativeBufferSizeInBytes());
            @Override
        // Two shards: shard A has high native, shard B has high heap but low native
    }
            if (actual == null) {
        controller.indexBufferRAMBytesUsed.put(shard, 200_000L); // 200kb > 100kb heap budget
        controller.simulateIndexing(shard0);
        controller.nativeMemoryUsed.put(shardB, 200_000L); // 200KB
        });
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        // We are now using 5 MB, so we should be writing shard0 since it's using the most heap:
        @Override
        controller.simulateIndexing(shard1);
        protected long getShardWritingBytes(IndexShard shard) {
    public void testBothBudgetsExceededSortsByTotal() throws IOException {
        assertTrue(controller.throttled.contains(shard));
import java.util.HashSet;
        controller.assertBuffer(shard2, 1);
            return indexBufferRAMBytesUsed.get(shard) + writingBytes.get(shard);
            );
        controller.assertBuffer(shard0, 0);
        controller.nativeMemoryUsed.put(shard, 500_000L); // 500kb < 10MB native budget
                .build(),
        controller.simulateIndexing(shard1);
        controller.simulateIndexing(shard1);
        controller.nativeMemoryUsed.put(shard, 2_000_000L); // 2MB > 1MB native budget
        controller.assertBuffer(shard0, 1);
        controller.assertBuffer(shard1, 4);
        IndexShard shard = newShard(true);
        controller.forceCheck();
        public void deactivateThrottling(IndexShard shard) {
        public void deleteShard(IndexShard shard) {
        assertEquals(0L, (long) controller.nativeMemoryUsed.get(shard));
            .similarity(config.getSimilarity())
                    .build(),
    }
            .store(config.getStore())
        public void assertThrottled(IndexShard shard) {
import java.util.List;
        @Override
        }
 * Modifications Copyright OpenSearch Contributors. See
        controller.assertBuffer(shard1, 1);
        controller.nativeMemoryUsed.put(shard, 100_000_000L); // 100MB native — under 1gb budget
        Exception e = expectThrows(
        IndexShard shard = newStartedShard(true);
        assertThat(controller.indexingBufferSize(), equalTo(new ByteSizeValue(6, ByteSizeUnit.MB)));
    public void testActiveInactive() throws IOException {
                flushes.incrementAndGet();
    }
                .put("indices.memory.native_index_buffer_size", "1gb")
        closeShards(shard);
        MockController controller = new MockController(
        // Total native = 1100 > 1024. Only native over budget.
            assertTrue(throttled.remove(shard));
            Settings.EMPTY,
 *
import java.util.ArrayList;
            }
        );
        }
        assertEquals("failed to parse setting [indices.memory.min_index_buffer_size] with value [-6mb] as a size in bytes", e.getMessage());
        // Shards that are currently throttled
        // Native memory used by each shard
            .put("indices.memory.index_buffer_size", "10%")
        logger.info("--> Indexing more data");
        assertEquals(100L, (long) controller.nativeMemoryUsed.get(shardA));
import org.opensearch.index.refresh.RefreshStats;
        // Native budget = 10MB (high), heap budget = 100kb
        controller.assertBuffer(shard0, 1);
        controller.deleteShard(shard1);
        controller.nativeMemoryUsed.put(shard, 2_000_000L); // 2MB > 1.5 × 1MB = 1.5MB throttle threshold
import org.apache.lucene.search.ReferenceManager;
        controller.nativeMemoryUsed.put(shard, 10_000_000L); // 10MB native — under 1gb budget
    public void testThrottling() throws Exception {
        );
        controller.assertBuffer(shard0, 2);
        controller.indexBufferRAMBytesUsed.put(shard, 50L); // under 100kb heap budget
        IndexShard shard = newShard(true);
        ;
        controller.simulateIndexing(shard1);
        assertEquals(0L, (long) controller.indexBufferRAMBytesUsed.get(shardA));
            Long actual = writingBytes.get(shard);
        ThreadPoolStats.Stats beforeStats = getRefreshThreadPoolStats();
        controller.forceCheck();
    // --- Dual-budget (heap + native) tests ---
        // Shard A: low heap, high native. Shard B: high heap, low native.
import java.util.HashMap;
        assertEquals(200L * 1024 * 1024, controller.nativeBufferSizeInBytes());
            Settings.builder().put("indices.memory.index_buffer_size", "1gb").put("indices.memory.native_index_buffer_size", "1kb").build()
        controller.assertBuffer(shard1, 2);
        // Shard B: higher heap, low native
            .circuitBreakerService(config.getCircuitBreakerService())
 */
        MockController controller = new MockController(
            }
        controller.indexBufferRAMBytesUsed.put(shardB, 500L);
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    } catch (InterruptedException e) {
 * this file be licensed under the Apache-2.0 license or a
        // Both budgets exceeded. Shard A has lower heap but higher native → higher total.
            .analyzer(config.getAnalyzer())
        @Override
            .put("indices.memory.native_index_buffer_size", "100mb")
        MockController controller = new MockController(
import org.opensearch.common.settings.Settings;
        // Refresh triggered because native exceeded budget
    public void testMinBufferSizes() {
        closeShards(shardA, shardB);
        public void assertBuffer(IndexShard shard, int expectedMB) {
                .put("indices.memory.index_buffer_size", "100kb")
        }
        protected void checkIdle(IndexShard shard, long inactiveTimeNS) {}
        controller.assertNotThrottled(shard0);
                null
            assertFalse(throttled.contains(shard));
        controller.nativeMemoryUsed.put(shardB, 500L);
        shard = reinitShard(shard, imc);
        // Native budget set high (1gb), native usage is under budget — should NOT trigger
            .build();
/*
        controller.nativeMemoryUsed.put(shardB, 2000L);
        refreshLatch.set(new CountDownLatch(1)); // block refresh
        assertFalse(controller.throttled.contains(shard));
    public void testNativeBudgetTriggersRefreshWhenExceeded() throws IOException {
        IndexShard shardA = newShard(true);
        MockController controller = new MockController(
    public void testNegativeShardInactiveTime() {
                    }
        // Shard A should be refreshed first
        IndexShard shard0 = newStartedShard();
    public void testHeapBudgetStillTriggersRefreshIndependently() throws IOException {
        );
        controller.assertNotThrottled(shard0);
        final Map<IndexShard, Long> indexBufferRAMBytesUsed = new HashMap<>();
        controller.writingBytes.put(shardB, 0L);
            protected void writeIndexingBufferAsync(IndexShard shard) {
        // add another shard
        controller.assertBuffer(shard0, 3);
            new EngineBackedIndexerFactory(config -> new InternalEngine(configWithRefreshListener(config, refreshListener)))
        // Both shards finally finish writing, and throttling should stop:
                .build()
            if (bytes == null) {
        controller.simulateIndexing(shard0);
                .put("indices.memory.index_buffer_size", "100kb")
        MockController controller = new MockController(Settings.builder().put("indices.memory.index_buffer_size", "4mb").build());
        public void writeIndexingBufferAsync(IndexShard shard) {
            IllegalArgumentException.class,
        // If sort key is heap-only, shard B is refreshed first.
        // remove first shard
    public void testNoThrottleWhenNativeUnderBudget() throws IOException {
        controller.writingBytes.put(shardB, 0L);
        controller.simulateIndexing(shard1);
        IndexShard shard0 = newStartedShard();
            writingBytes.put(shard, 0L);
 *
        IndexShard shardA = newShard(true);
        // Native budget = 1MB, heap budget = 100kb
            Settings.builder().put("indices.memory.index_buffer_size", "1kb").put("indices.memory.native_index_buffer_size", "1kb").build()
        public void assertNotThrottled(IndexShard shard) {
        controller.writingBytes.put(shardB, 0L);
            @Override
 * specific language governing permissions and limitations
package org.opensearch.indices;
        // Heap budget = 1gb (not exceeded), native budget = 1kb (exceeded)
        shard.markAsRecovering("store", new RecoveryState(shard.routingEntry(), localNode, null));
        // Shard B must have been refreshed (heap was highest)
import org.opensearch.core.common.unit.ByteSizeValue;
        controller.simulateIndexing(shard0);
import org.opensearch.core.common.unit.ByteSizeUnit;
        controller.simulateIndexing(shard0);
        }
        );
                .build()
        MockController controller = new MockController(
 * under the License.
        IndexShard shardB = newShard(true);
import java.util.concurrent.CountDownLatch;
                .build()
                Settings.builder()
 * Unless required by applicable law or agreed to in writing,
            () -> new MockController(Settings.builder().put("indices.memory.max_index_buffer_size", "-6mb").build())
        controller.indexBufferRAMBytesUsed.put(shardA, 5000L);
        controller.writingBytes.put(shardB, 0L);
    ThreadPoolStats.Stats getRefreshThreadPoolStats() {
        };
    public void testRefreshTargetsSortedByNativeWhenOnlyNativeExceeds() throws IOException {
        for (int i = 0; i < iterations; i++) {
            ThreadPoolStats.Stats stats = getRefreshThreadPoolStats();
        final RefreshStats refreshStats = shard.refreshStats();
    public void testNegativeMaxIndexBufferSize() {
        assertEquals(0L, (long) controller.nativeMemoryUsed.get(shardA)); // A was refreshed
        controller.forceCheck();
        controller.simulateIndexing(shard1);
        MockController controller = new MockController(
        MockController controller = new MockController(
        // How many bytes this shard is currently moving to disk
        MockController controller = new MockController(Settings.builder().put("indices.memory.index_buffer_size", "4mb").build());
            .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())
        MockController(Settings settings) {
        public void assertWriting(IndexShard shard, int expectedMB) {
        @Override
        controller.forceCheck();
        return new EngineConfig.Builder().shardId(config.getShardId())
        MockController controller = new MockController(
            controller.forceCheck();
import java.io.IOException;
                return 0L;
        // With B refreshed: totalHeap = 2300 - 1500 = 800 < 1024, so A should NOT be refreshed
        }
        controller.indexBufferRAMBytesUsed.put(shardB, 7000L);
    public void testNativeUnderBudgetDoesNotTriggerRefresh() throws IOException {
        IndexShard shard = newShard(true);
            () -> new MockController(Settings.builder().put("indices.memory.min_index_buffer_size", "-6mb").build())
        IndexShard shard = newStartedShard(
            randomBoolean(),
        controller.forceCheck();
        controller.assertWriting(shard0, 3);
        // Size of each shard's indexing buffer
        controller.simulateIndexing(shard0);
            Settings.builder().put("indices.memory.index_buffer_size", "1kb").put("indices.memory.native_index_buffer_size", "1kb").build()
        assertEquals(0L, (long) controller.nativeMemoryUsed.get(shardB));
        IndexShard shard1 = newStartedShard();
        controller.indexBufferRAMBytesUsed.put(shardA, 100L);
        // Total native = 1.1MB > 1MB budget. Total heap = 500KB < 10MB budget.
        // Shard B must have been refreshed (native was highest)
        assertEquals(0L, (long) controller.indexBufferRAMBytesUsed.get(shard));
        controller.simulateIndexing(shard1);
/*
import org.opensearch.threadpool.Scheduler.Cancellable;
        final List<ReferenceManager.RefreshListener> internalRefreshListener = new ArrayList<>(config.getInternalRefreshListener());
import org.opensearch.index.engine.EngineConfig;
                .put("indices.memory.native_index_buffer_size", "10mb")
            } else {
        assertBusy(() -> {
            .primaryTermSupplier(config.getPrimaryTermSupplier())
        controller.forceCheck();
    EngineConfig configWithRefreshListener(EngineConfig config, ReferenceManager.RefreshListener listener) {
            Settings.builder()
        );
        // Sort key should be heap-only → shard B (1500) refreshed before shard A (800)
import org.opensearch.indices.recovery.RecoveryState;
        controller.writingBytes.put(shard, 0L);
        IndexShard shard0 = newStartedShard();
        IndexShard shard = newShard(true);
        IndexShard shard1 = newStartedShard();
        controller.assertWriting(shard1, 0);
            // Each doc we index takes up a megabyte!
        closeShards(shard0, shard1);
        }
        IndexShard shardA = newShard(true);
        assertEquals(50L, (long) controller.indexBufferRAMBytesUsed.get(shard)); // not refreshed
import java.util.Map;
    }
        protected List<IndexShard> availableShards() {
    }
        );
        controller.writingBytes.put(shardA, 0L);
        controller.writingBytes.put(shardA, 0L);
        protected Cancellable scheduleTask(ThreadPool threadPool) {
        Iterable<IndexShard> iterable = () -> (shardRef.get() == null)
    }
        controller.assertBuffer(shard1, 2);
                return s;
        // If sort key is heap+native, shard A is refreshed first.
            .internalRefreshListener(internalRefreshListener)
        );
        IndexingMemoryController imc = new IndexingMemoryController(settings, threadPool, iterable) {
        IndexShard shard1 = newStartedShard();
        // Both budgets exceeded. Shard A total=13000, Shard B total=9000
        controller.forceCheck();
            }
    }
            .translogConfig(config.getTranslogConfig())
        controller.writingBytes.put(shardA, 0L);
        assertThat(controller.indexingBufferSize(), equalTo(new ByteSizeValue(6, ByteSizeUnit.MB)));
import org.opensearch.index.engine.InternalEngine;
 * GitHub history for details.
 * software distributed under the License is distributed on an
        controller.simulateIndexing(shard0);
        assertThat("we should have flushed in IMC at least once", flushes.get(), greaterThanOrEqualTo(1));
            assertTrue(throttled.add(shard));
                }
        }
            .eventListener(config.getEventListener())
                .put("indices.memory.index_buffer_size", "10mb") // high heap budget
                + "[-42s] as a time value: negative durations are not supported",
        IndexShard shardB = newShard(true);
        }
    }
                actual = 0L;
import org.opensearch.index.shard.IndexShardTestCase;
            assertTrue(throttled.contains(shard));
        IndexShard shardA = newShard(true);
        // More indexing to shard0
            "failed to parse setting [indices.memory.shard_inactive_time] with value "
import java.util.concurrent.atomic.AtomicInteger;
            }
 * ownership. Elasticsearch licenses this file to you under
        final Map<IndexShard, Long> writingBytes = new HashMap<>();
            assertThat(stats.getCompleted(), equalTo(beforeStats.getCompleted() + iterations));
            bytes += 1024 * 1024;
        assertEquals(500L, (long) controller.nativeMemoryUsed.get(shardB));
        }
            IllegalArgumentException.class,
    public void testThrottleActivatedOnNativePressure() throws IOException {
        }
                .put("indices.memory.interval", "200h") // disable it
        controller.assertBuffer(shard1, 0);
        // Sort key = heap+native → shard A (1200) > shard B (1000), so A refreshed first, B won't be refreshed
        );
        controller.setNativeBufferBytes(200L * 1024 * 1024);
        );
            Settings.builder().put("indices.memory.index_buffer_size", "10mb").put("indices.memory.native_index_buffer_size", "1mb").build()
        controller.nativeMemoryUsed.put(shardB, 1000L); // native higher than ShardA
        ) {
 * compatible open source license.
            e.getMessage()
            Long actual = indexBufferRAMBytesUsed.get(shard);
        // Refresh triggered because heap exceeded budget (native is fine)
        }
 * The OpenSearch Contributors require contributions made to
            if (s.getName().equals(ThreadPool.Names.REFRESH)) {
        AtomicReference<IndexShard> shardRef = new AtomicReference<>();
        controller.assertBuffer(shard1, 0);
            }
        controller.nativeMemoryUsed.put(shardB, 100L); // native lower than shardA
    static class MockController extends IndexingMemoryController {
            ? Collections.emptyIterator()
        assertEquals(
        controller.forceCheck();
            .tombstoneDocSupplier(config.getTombstoneDocSupplier())
        controller.writingBytes.put(shardA, 0L);
        closeShards(shard);
import static java.util.Collections.emptySet;
        controller.nativeMemoryUsed.put(shardA, 1000L);
            }
        @Override
            .flushMergesAfter(config.getFlushMergesAfter())
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
        controller.forceCheck();
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(0, imc.availableShards().size());
        controller.assertBuffer(shard0, 1);
            return new ArrayList<>(indexBufferRAMBytesUsed.keySet());
 *
import org.opensearch.index.shard.IndexShard;
        );
        controller.writingBytes.put(shard, 0L);
        DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        controller.setNativeBufferBytes(50L * 1024 * 1024);
                null,
        ReferenceManager.RefreshListener refreshListener = new ReferenceManager.RefreshListener() {
            threadPool,
        }
        controller.writingBytes.put(shardA, 0L);
        MockController controller = new MockController(
            public void afterRefresh(boolean didRefresh) {
            assertEquals(expectedMB * 1024 * 1024, actual.longValue());
        );
        @Override
        // Shard B: high heap + low native = lower total
            Settings.builder()
import org.opensearch.threadpool.ThreadPoolStats;
        controller.assertWriting(shard1, 4);
        }
                .put("indices.memory.native_index_buffer_size", "1mb")
        closeShards(shard);
        closeShards(shard0, shard1);
        }
    public void testTranslogRecoveryWorksWithIMC() throws IOException {
                .put("indices.memory.native_index_buffer_size", "1mb")
        IndexShard shardB = newShard(true);
import org.opensearch.common.SetOnce;
        int iterations = randomIntBetween(10, 100);
            Settings.builder()
                .put("indices.memory.index_buffer_size", "1024b")
        controller.assertBuffer(shard1, 0);
        final Set<IndexShard> throttled = new HashSet<>();
            }
                writingBytes.put(shard, 0L);
        );
        // Heap budget = 1kb (exceeded), native budget = 1gb (not exceeded)
            @Override
        final IndexingMemoryController controller = new IndexingMemoryController(
    }
        );
        controller.simulateIndexing(shard1);
        controller.assertBuffer(shard1, 1);
        controller.doneWriting(shard1);
        for (int i = 0; i < 100; i++) {
        controller.indexBufferRAMBytesUsed.put(shardA, 600L);
        controller.assertBuffer(shard0, 0);
        // Shard A: low heap, high native
        @Override
            IllegalArgumentException.class,
            () -> new MockController(Settings.builder().put("indices.memory.interval", "-42s").build())
        controller.assertWriting(shard0, 8);
 * KIND, either express or implied.  See the License for the
        controller.assertBuffer(shard1, 1);
                        refreshLatch.get().await();
                + "[-42s] as a time value: negative durations are not supported",
            Collections.singleton(shard)
        closeShards(shardA, shardB);
        MockController controller = new MockController(
                assertEquals(shard, shardRef.get());
        // Shard A: heap=600, native=600, total=1200
        controller.assertThrottled(shard0);
            .queryCachingPolicy(config.getQueryCachingPolicy())
    public void testNegativeMinIndexBufferSize() {
        // Dynamically update
 * not use this file except in compliance with the License.
        controller.assertBuffer(shard0, 0);
            if (bytes == null) {
    }
                bytes = 0L;
        controller.simulateIndexing(shard0);
        Settings settings = Settings.builder()
            indexBufferRAMBytesUsed.remove(shard);
    public void testHeapOnlySortKeyUsedWhenOnlyHeapExceeds() throws IOException {
        final ThreadPoolStats stats = threadPool.stats();
 * the Apache License, Version 2.0 (the "License"); you may
        closeShards(shardA, shardB);
        shardRef.set(shard);
            Settings.builder().put("indices.memory.index_buffer_size", "0.001%").put("indices.memory.min_index_buffer_size", "6mb").build()
        closeShards(shard);
                shard.writeIndexingBuffer();
public class IndexingMemoryControllerTests extends IndexShardTestCase {
            writingBytes.remove(shard);
            return nativeMemoryUsed.getOrDefault(shard, 0L);
        Exception e = expectThrows(
    }
            .mergePolicy(config.getMergePolicy())
        IndexShard shardA = newShard(true);
        closeShards(shard);
        assertEquals(800L, (long) controller.indexBufferRAMBytesUsed.get(shardA));
        // If sort key is native-only, shard B is refreshed first.
        controller.simulateIndexing(shard0);
        public void activateThrottling(IndexShard shard) {
        SetOnce<CountDownLatch> refreshLatch = new SetOnce<>();
        @Override
        controller.forceCheck();
            protected long getShardWritingBytes(IndexShard shard) {
            long bytes = indexBufferRAMBytesUsed.put(shard, 0L);
            Settings.builder()
import org.opensearch.index.codec.CodecService;
                .put("indices.memory.index_buffer_size", "100kb")
            assertThat(stats.getCompleted(), equalTo(beforeStats.getCompleted() + iterations - 1));
    }
        assertThat(shard.refreshStats().getTotal(), equalTo(refreshStats.getTotal() + 1));
        // depending on whether refreshing A alone brings native under budget
                        throw new AssertionError(e);
            .threadPool(config.getThreadPool())
        Exception e = expectThrows(
            .indexSort(config.getIndexSort())
    }
        // Shard A should be refreshed first (higher native), shard B may or may not be refreshed
        controller.writingBytes.put(shard, 0L);
        assertEquals(0L, (long) controller.indexBufferRAMBytesUsed.get(shardA));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(0L, (long) controller.nativeMemoryUsed.get(shardA));
        }
        controller.simulateIndexing(shard0);
        // index into one shard only, crosses the 5mb limit, so shard1 is refreshed
            .externalRefreshListener(config.getExternalRefreshListener())
        MockController controller = new MockController(
        );
        assertEquals(500L, (long) controller.indexBufferRAMBytesUsed.get(shardB));
        controller.writingBytes.put(shard, 0L);
        // Total heap = 2300 > 1024. Only heap over budget.
        closeShards(shardA, shardB);
        MockController controller = new MockController(Settings.builder().put("indices.memory.index_buffer_size", "5mb").build());
        controller.deleteShard(shard0);
            .codecService(new CodecService(null, config.getIndexSettings(), logger, List.of()))
        assertEquals(0L, (long) controller.indexBufferRAMBytesUsed.get(shardB));
        // Shard B has higher heap but lower native → lower total.
            forceCheck();
        controller.indexBufferRAMBytesUsed.put(shard, 100L);
        // Shard A should NOT be refreshed: totalNative = 1100 - 1000 = 100 < 1024
 */
        controller.simulateIndexing(shard1);
            Settings.builder().put("indices.memory.index_buffer_size", "90%").put("indices.memory.max_index_buffer_size", "6mb").build()
        throw new AssertionError("refresh thread pool stats not found [" + stats + "]");
        controller.writingBytes.put(shardB, 0L);
        controller.assertWriting(shard1, 4);
        );
        IndexShard shardB = newShard(true);
            public void beforeRefresh() {
        // Now we are using 5 MB again, so shard0 should also be writing and now also be throttled:
        controller.assertThrottled(shard1);
        closeShards(shard0, shard1, shard2);
        // and 2) be throttling shard1:
        closeShards(shard);
            }
        // Initial value from setting: 100MB
            return null;
        MockController controller = new MockController(settings);
        controller.assertBuffer(shard0, 1);
        controller.simulateIndexing(shard2);
import java.util.Set;
import java.util.Collections;
        }
                    try {
                    .put("indices.memory.interval", "200h") // disable it
        // Now we are still writing 3 MB (shard0), and using 5 MB index buffers, so we should now 1) be writing shard1,
        closeShards(shardA, shardB);
        Exception e = expectThrows(
        );
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                return 0;
            }
        controller.assertWriting(shard0, 3);
        );
            .warmer(config.getWarmer())
        @Override
        }
        controller.writingBytes.put(shard, 0L);
        controller.assertThrottled(shard1);
        public void simulateIndexing(IndexShard shard) {
        };
            Settings.builder().put("indices.memory.index_buffer_size", "10mb").put("indices.memory.native_index_buffer_size", "1gb").build()
                    .put(settings)
        internalRefreshListener.add(listener);
            e.getMessage()
        IndexShard shard2 = newStartedShard();
            IllegalArgumentException.class,
    }
            "failed to parse setting [indices.memory.interval] with value "
    }
        controller.simulateIndexing(shard0);
        controller.indexBufferRAMBytesUsed.put(shardB, 500_000L);
        controller.assertBuffer(shard1, 2);
        // Shard B: heap=500, native=500, total=1000
        AtomicInteger flushes = new AtomicInteger();
        assertEquals(1, imc.availableShards().size());
import static org.hamcrest.Matchers.equalTo;
        refreshLatch.get().countDown(); // allow refresh
        };
    public void testSkipRefreshIfShardIsRefreshingAlready() throws Exception {
            }
                // First time we are seeing this shard:
            Settings.builder().put("indices.memory.index_buffer_size", "1kb").put("indices.memory.native_index_buffer_size", "1gb").build()
        shard.close("simon says", false, false);
