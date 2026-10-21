        AtomicReference<CountDownLatch> countDown = new AtomicReference<>(new CountDownLatch(randomIntBetween(1, 20)));
            assertThat(
        assertThat(exception.getDurability(), equalTo(CircuitBreaker.Durability.TRANSIENT));
        );
            }));
        requestBreaker.addEstimateBytesAndMaybeBreak(randomLongBetween(0, 24), "request");
                expectedDurability = CircuitBreaker.Durability.TRANSIENT;
        final int parentLimit = (BYTES_PER_THREAD * NUM_THREADS) - 2;
        }
            @Override
            TimeValue.timeValueSeconds(30)
 * software distributed under the License is distributed on an
            assertThat(exception.getMessage(), containsString("[parent] Data too large, data for [should break] would be"));
            assertThat(service.getBreaker("bar").getOverhead(), equalTo(0.1));
                "should not break"
            data.add(new byte[(int) (JvmInfo.jvmInfo().getG1RegionSize() / 2)]);
import java.util.concurrent.TimeUnit;
                        leaderTriggerCount.incrementAndGet();
            () -> 0,
    }
        final AtomicReference<Throwable> lastException = new AtomicReference<>(null);
        Thread blocker = new Thread(() -> { strategy.overLimit(input); });
        long interval = randomLongBetween(1, 1000);
        }
            )
        final ChildMemoryCircuitBreaker breaker = new ChildMemoryCircuitBreaker(
                    startedBlocking.countDown();
                new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            memoryUsage::get,
                JvmInfo.jvmInfo(),
            void overLimitTriggered(boolean leader) {
        );
            );
        try {
        final AtomicReference<Throwable> lastException = new AtomicReference<>(null);
        } catch (CircuitBreakingException e) {
            .put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "350b")
            assertThat(exception.getMessage(), containsString("[parent] Data too large, data for [allocated_buckets] would be"));
                "usages [request="
            assertThat(service.getBreaker("foo").getLimit(), equalTo(100L));
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
/*
        }
        CyclicBarrier barrier = new CyclicBarrier(threadCount + 1);
        }
            assertThat(overLimitStrategy, not(instanceOf(HierarchyCircuitBreakerService.G1OverLimitStrategy.class)));
            CircuitBreaker.REQUEST
import java.util.ArrayList;
            assertThat(
        assertThat(
            containsString(
            long currentMemoryUsage() {
                        }
        AtomicInteger leaderTriggerCount = new AtomicInteger();
                fieldDataCircuitBreaker.addEstimateBytesAndMaybeBreak(mb(70), "should not break");
                HierarchyCircuitBreakerService::realMemoryUsage,
            logger,
            randomLongBetween(0, 50),
            clusterSettings,
                    if (leader) {
        long g1RegionSize = JvmInfo.jvmInfo().getG1RegionSize();
            assertThat(exception.getMessage(), containsString("which is larger than the limit of [100/100b]"));
        }
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(output.transientChildUsage, equalTo(input.transientChildUsage));
        final Thread[] threads = new Thread[NUM_THREADS];
            assertThat(service.getBreaker("foo").getOverhead(), equalTo(1.2));
        assertThat(output.permanentChildUsage, equalTo(input.permanentChildUsage));
            return randomLongBetween(100, 110);
        );
            }
        });
                    leaderTriggerCount.incrementAndGet();
        try (
     */
import org.opensearch.monitor.jvm.JvmInfo;
                Collections.emptyList(),
    }
        time.addAndGet(randomLongBetween(interval, interval + 10));
        for (Thread thread : threads) {
        assertThat(exception.getMessage(), containsString("[parent] Data too large, data for [request] would be"));
import static org.hamcrest.Matchers.instanceOf;
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), "false")
        requestBreaker.addEstimateBytesAndMaybeBreak(randomLongBetween(0, 99), "request");
import java.util.Collections;
                () -> requestCircuitBreaker.addEstimateBytesAndMaybeBreak(new ByteSizeValue(50, ByteSizeUnit.MB).getBytes(), "should break")
        HierarchyCircuitBreakerService.G1OverLimitStrategy strategy = new HierarchyCircuitBreakerService.G1OverLimitStrategy(
        AtomicInteger nonLeaderTriggerCount = new AtomicInteger();
            for (int i = 0; i < allocationCount && overLimitTriggered.get() == false; ++i) {
            CircuitBreakingException exception = expectThrows(CircuitBreakingException.class, () -> multiBucketConsumer.accept(1024));
            )
                new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            randomLongBetween(100, 110),
    }
            @Override
            "breaker should be reset back to the parent limit after parent breaker trips",
            IllegalArgumentException.class,
        } catch (CircuitBreakingException e) {
        return new ByteSizeValue(size, ByteSizeUnit.MB).getBytes();
                    + new ByteSizeValue(requestCircuitBreakerUsed)
import java.util.concurrent.CyclicBarrier;
        ) {
        };
            assertThat(blocker.isAlive(), is(false));
                } else {
            TimeValue.timeValueMillis(randomFrom(0, 5, 10))
    public void testG1OverLimitStrategyThrottling() throws InterruptedException, BrokenBarrierException, TimeoutException {
            breaker.addWithoutBreaking(200);
        assertThat("breaker was tripped at least once", breaker.getTrippedCount(), greaterThanOrEqualTo(1L));
    }
        AtomicLong gcCounter = new AtomicLong();
        try {
        final CircuitBreakerService service = new HierarchyCircuitBreakerService(
        CircuitBreakingException exception = expectThrows(
import org.opensearch.common.settings.ClusterSettings;
        ) {
                    + (reservationInBytes * 2)
            )
            parentLimit,
            }
        }
                }
        final HierarchyCircuitBreakerService service = new HierarchyCircuitBreakerService(
        })).collect(Collectors.toList());
        assertThat(nonLeaderTriggerCount.get(), equalTo(1));
        threads.forEach(Thread::start);
        );
            randomLongBetween(0, 50)
                );
    public void testFallbackG1RegionSize() {
    }
                if (saveTheDay) {
        Settings clusterSettings = Settings.builder()
        );
        HierarchyCircuitBreakerService.G1OverLimitStrategy strategy = new HierarchyCircuitBreakerService.G1OverLimitStrategy(
                    + "/"
 * GitHub history for details.
        assertThat(output.baseUsage, equalTo(memoryUsage.get()));
            blockingUntil.countDown();
        assertThat(output.totalUsage, equalTo(99 + input.totalUsage - 100));
            trackRealMemoryUsage -> memoryUsed -> {
            assertThat(exception.getDurability(), equalTo(CircuitBreaker.Durability.TRANSIENT));
            () -> new HierarchyCircuitBreakerService(
                countDown.get().countDown();
        );
            Collections.emptyList(),
        long maxHeap = JvmInfo.jvmInfo().getConfiguredMaxHeapSize();
                breaker
                }
            assertThat(startedBlocking.await(10, TimeUnit.SECONDS), is(true));
                requestCircuitBreaker.addEstimateBytesAndMaybeBreak(mb(70), "should not break");
        );
        }
    /**
        final BreakerSettings settings = new BreakerSettings(CircuitBreaker.REQUEST, (BYTES_PER_THREAD * NUM_THREADS) - 1, 1.0);
        CyclicBarrier barrier = new CyclicBarrier(threadCount + 1);
            clusterSettings,
        blocker.start();
            )
            @Override
                    + "]"
        HierarchyCircuitBreakerService.MemoryUsage input = new HierarchyCircuitBreakerService.MemoryUsage(100, 100, 0, 0);
            }
            assertThat(strategy.overLimit(input), sameInstance(input));
            not(instanceOf(HierarchyCircuitBreakerService.G1OverLimitStrategy.class))
            requestUsedBytes = requestCircuitBreaker.addEstimateBytesAndMaybeBreak(
                if (leader) {
            .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "150mb")
        try (
                HierarchyCircuitBreakerService.MemoryUsage input = new HierarchyCircuitBreakerService.MemoryUsage(
                    + ", fielddata=0/0b, in_flight_requests=0/0b]"
            time::get,
        HierarchyCircuitBreakerService.MemoryUsage output = strategy.overLimit(input);
            containsString("More than one circuit breaker with the name [fielddata] exists. Circuit breaker names must be unique")
     */
            @Override
            .put(HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "50%")
            CircuitBreaker.REQUEST
            } else {
        assertThat(
                    randomLongBetween(0, 100),
        logger.info("--> parent tripped: {}, total trip count: {} (expecting 1-2 for each)", parentTripped.get(), tripped.get());
                Collections.emptyList(),
                HierarchyCircuitBreakerService.createYoungGcCountSupplier(),
            )
import java.util.concurrent.CountDownLatch;
                    } catch (CircuitBreakingException e) {
        requestBreaker.addEstimateBytesAndMaybeBreak(reservationInBytes, "request");
            .build();
            if (randomBoolean()) {
                } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
            assertEquals(new ByteSizeValue(150, ByteSizeUnit.MB).getBytes(), fieldDataCircuitBreaker.getLimit());
        threads.forEach(Thread::interrupt);
        HierarchyCircuitBreakerService.OverLimitStrategy overLimitStrategy = HierarchyCircuitBreakerService.createOverLimitStrategy(true);
            exception.getMessage(),
                expectedDurability = CircuitBreaker.Durability.PERMANENT;
        memoryUsage.set(99);
            IllegalArgumentException.class,
            threads.add(new Thread(() -> {
 * license agreements. See the NOTICE file distributed with
            gcCounter::incrementAndGet,
                @Override
        IllegalArgumentException iae = expectThrows(
            }
                if (leader) {
            gcCounter::incrementAndGet,
        int threadCount = randomIntBetween(1, 10);
 * this file be licensed under the Apache-2.0 license or a
            // this should complete in a timely manner, verified by the assertion in the thread.
            assertTrue(countDown.get().await(20, TimeUnit.SECONDS));
        } finally {
                Settings.EMPTY,
            CircuitBreakerService service = new HierarchyCircuitBreakerService(
                    onOverLimit.get().accept(leader);
 */
        assertThat(output.baseUsage, equalTo(memoryUsage.get()));
                        memoryUsed.totalUsage - (memoryUsed.baseUsage / 2),
        long interval = randomLongBetween(1, 1000);
        }
        assumeTrue("Must have region size", g1RegionSize > 0);
                fieldDataCircuitBreaker.addEstimateBytesAndMaybeBreak(mb(100), "should not break");
import java.util.concurrent.BrokenBarrierException;
                equalTo(expectedDurability)
        for (int i = 0; i < regionCount; ++i) {
    }
        final ChildMemoryCircuitBreaker breaker = new ChildMemoryCircuitBreaker(
            CircuitBreakerService service = new HierarchyCircuitBreakerService(
            } while (!Thread.interrupted());
            @Override
            thread.join(10000);
     * Test that a breaker correctly redistributes to a different breaker, in
                () -> fieldDataCircuitBreaker.addEstimateBytesAndMaybeBreak(mb(40), "should break")
                }
                    parentTripped.incrementAndGet();
            JvmInfo.jvmInfo(),
        assertThat(output, not(sameInstance(input)));
            CircuitBreakingException.class,
import java.util.concurrent.atomic.AtomicReference;
    public void testCustomCircuitBreakers() {
            BYTES_PER_THREAD,
        // breaking the child breaker.
                    service.checkParentLimit(0, "test-thread");
                        lastException.set(e);
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                "Expected [" + expectedDurability + "] due to [" + exception.getMessage() + "]",
                        lastException.set(e);
                for (int j = 0; j < BYTES_PER_THREAD; j++) {
            100,
            }
    }
    }
        assertThat(
import static org.hamcrest.CoreMatchers.is;
import org.opensearch.common.settings.Settings;
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at
            trackRealMemoryUsage -> new HierarchyCircuitBreakerService.G1OverLimitStrategy(
                clusterSettings,
            }
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
    public void testThreadedUpdatesToChildBreaker() throws Exception {
        List<byte[]> data = new ArrayList<>();
        breakerRef.set(breaker);
import java.util.concurrent.atomic.AtomicInteger;
            exception.getMessage(),
            interval,
        Settings clusterSettings = Settings.builder()
        int iterationCount = randomIntBetween(1, 5);
        assertEquals(0, requestBreaker.getTrippedCount());
                    } catch (InterruptedException e) {
        assertThat(memoryUsageCounter.get(), equalTo(2L)); // 1 before gc count break and 1 to get resulting memory usage.
                }
import static org.hamcrest.Matchers.not;
            JvmInfo.jvmInfo(),
                }
import java.util.concurrent.TimeoutException;
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                equalTo(TimeValue.timeValueMillis(500))
            }
import org.opensearch.test.OpenSearchTestCase;
                Settings.EMPTY,
        Settings clusterSettings = Settings.builder()
            countDown.set(new CountDownLatch(randomIntBetween(1, 20)));
import org.opensearch.core.common.breaker.CircuitBreaker;
                interval,
import java.util.function.LongSupplier;
        threads.forEach(thread -> assertFalse(thread.isAlive()));
            public CircuitBreaker getBreaker(String name) {
            );
            );
            memoryUsageCounter.incrementAndGet();
                Collections.emptyList(),
                if (leader) {
import java.util.stream.IntStream;
                    randomLongBetween(0, 100)
        AtomicLong memoryUsageCounter = new AtomicLong();
 * SPDX-License-Identifier: Apache-2.0
            );
            () -> 0,
            assertEquals(new ByteSizeValue(50, ByteSizeUnit.MB).getBytes(), fieldDataUsedBytes, 0.0);
                    throw new AssertionError(e);
            () -> requestBreaker.addEstimateBytesAndMaybeBreak(reservationInBytes, "request")
                "should not break"
        memoryUsage.set(randomLongBetween(100, 110));
        // it was the parent that rejected the reservation
        );
 * Licensed to Elasticsearch under one or more contributor
                        memoryUsed.permanentChildUsage
                } else {
        assertEquals(0, requestBreaker.getTrippedCount());
}
            CircuitBreaker fieldDataCircuitBreaker = service.getBreaker(CircuitBreaker.FIELDDATA);
                new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            assertThat(exception.getMessage(), containsString("which is larger than the limit of [209715200/200mb]"));
            "--> NUM_THREADS: [{}], BYTES_PER_THREAD: [{}], TOTAL_BYTES: [{}], PARENT_LIMIT: [{}], CHILD_LIMIT: [{}]",
                Settings.EMPTY,
            assertEquals(new ByteSizeValue(100, ByteSizeUnit.MB).getBytes(), requestUsedBytes, 0.0);
                requestCircuitBreaker.addEstimateBytesAndMaybeBreak(mb(120), "should not break");
            assertThat(leaderTriggerCount.get(), lessThanOrEqualTo(i + 1));
                    } catch (Exception e) {
        };
        ) {
                clusterSettings,
     * Given that it depends on GC, the main assertion that we do not get a circuit breaking exception in the threads towards
        assumeTrue("Only G1GC can utilize the over limit check", JvmInfo.jvmInfo().useG1GC().equals("true"));
            100,
        int regionCount = Math.toIntExact((maxHeap / 2 + g1RegionSize - 1) / g1RegionSize);
            .put(HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "200b")
    public void testCreateOverLimitStrategy() {
                    + "/"
        assertThat(output.permanentChildUsage, equalTo(input.permanentChildUsage));
                    throw new CircuitBreakingException(
        }
        AtomicInteger leaderTriggerCount = new AtomicInteger();
        AtomicInteger leaderTriggerCount = new AtomicInteger();
            JvmInfo.jvmInfo(),
            randomLongBetween(0, 50),
import java.util.function.Consumer;
                    + new ByteSizeValue(reservationInBytes * 2)
    }
                assertThat(output.permanentChildUsage, equalTo(input.permanentChildUsage));
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        barrier.await(20, TimeUnit.SECONDS);
        );
import static org.hamcrest.Matchers.equalTo;
                    randomLongBetween(0, 100),
                long requestBreakerUsed = getBreaker(CircuitBreaker.REQUEST).getUsed();
        final int NUM_THREADS = scaledRandomIntBetween(3, 15);
        final AtomicReference<ChildMemoryCircuitBreaker> breakerRef = new AtomicReference<>(null);
        LongSupplier memoryUsageSupplier = () -> {
        AtomicReference<Consumer<Boolean>> onOverLimit = new AtomicReference<>(leader -> {});
        // lower memory usage again - the same reservation should succeed
            public CircuitBreaker getBreaker(String name) {
            CircuitBreaker breaker = service.getBreaker(CircuitBreaker.REQUEST);
    public void testG1OverLimitStrategyBreakOnGcCount() {
        }
        assertThat(
        for (Thread t : threads) {
import static org.hamcrest.Matchers.sameInstance;
        assumeTrue("Only G1GC can utilize the over limit check", JvmInfo.jvmInfo().useG1GC().equals("true"));
import static org.hamcrest.Matchers.nullValue;
        assertThat("total breaker was tripped at least once", tripped.get(), greaterThanOrEqualTo(1));
            public void checkParentLimit(long newBytesReserved, String label) throws CircuitBreakingException {
            );
            CircuitBreakingException exception = expectThrows(
            Settings.EMPTY,
        final CircuitBreakerService service = new HierarchyCircuitBreakerService(
                throw new AssertionError(e);
        HierarchyCircuitBreakerService.G1OverLimitStrategy strategy = new HierarchyCircuitBreakerService.G1OverLimitStrategy(
        final AtomicReference<ChildMemoryCircuitBreaker> breakerRef = new AtomicReference<>(null);
            assertThat(service.getBreaker("bar"), is(not(nullValue())));
        // anything >= 20 bytes (10 bytes * 2 overhead) reservation breaks the parent but it must be low enough to avoid
                data.add(new byte[allocationSize]);
            memoryUsageSupplier,
            new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            time::get,
            threads[i] = new Thread(() -> {
        for (int i = 0; i < iterationCount; ++i) {
            .put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "150mb")
                        memoryUsed.transientChildUsage,
            randomLongBetween(100, 110),
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            memoryUsage.set(randomLongBetween(0, 100));
 *     http://www.apache.org/licenses/LICENSE-2.0
                }
                new ByteSizeValue(50, ByteSizeUnit.MB).getBytes(),
        assertThat(leaderTriggerCount.get(), equalTo(1));
                Arrays.asList(new BreakerSettings("foo", 100, 1.2), new BreakerSettings("foo", 200, 0.1)),
            containsString("More than one circuit breaker with the name [foo] exists. Circuit breaker names must be unique")
        Settings clusterSettings = Settings.builder()
import static org.hamcrest.Matchers.containsString;
            double requestUsedBytes = requestCircuitBreaker.addEstimateBytesAndMaybeBreak(
        threads.forEach(Thread::start);
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), Boolean.TRUE)
     * the end of the test is not enabled. The following tests checks this in more unit test style.
            assertThat(exception.getMessage(), containsString("which is larger than the limit of [209715200/200mb]"));
                    return new HierarchyCircuitBreakerService.MemoryUsage(
        final AtomicInteger tripped = new AtomicInteger(0);
            }
    }
            @Override
        AtomicLong time = new AtomicLong(randomLongBetween(Long.MIN_VALUE / 2, Long.MAX_VALUE / 2));
                    nonLeaderTriggerCount.incrementAndGet();
        }
            } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
        assertThat(output.transientChildUsage, equalTo(input.transientChildUsage));
                    } catch (Exception e) {
        assertThat(gcCounter.get(), equalTo(2L));
        boolean saveTheDay = randomBoolean();
                CircuitBreakingException.class,
        assertThat(leaderTriggerCount.get(), equalTo(1));
        );
        ) {
            greaterThanOrEqualTo((long) parentLimit - NUM_THREADS)
            .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "150mb")
            () -> 100,
            HierarchyCircuitBreakerService service = new HierarchyCircuitBreakerService(
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), Boolean.FALSE)
                    try {
                void overLimitTriggered(boolean leader) {
            HierarchyCircuitBreakerService.G1OverLimitStrategy.fallbackRegionSize(JvmInfo.jvmInfo()),
    /**
        for (Thread thread : threads) {
import org.opensearch.common.breaker.ChildMemoryCircuitBreaker;
        AtomicLong memoryUsage = new AtomicLong();
                }
                }
    }
                if (requestBreakerUsed > parentLimit) {
                // Parent will trip right before regular breaker would trip
            CircuitBreaker.Durability expectedDurability;
            Collections.emptyList(),
            new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                barrier.await(10, TimeUnit.SECONDS);
        ) {
        ) {
            () -> new HierarchyCircuitBreakerService(
            interval,
        try {
public class HierarchyCircuitBreakerServiceTests extends OpenSearchTestCase {
        }
                    try {
        assertEquals(1, service.stats().getStats(CircuitBreaker.PARENT).getTrippedCount());
                Arrays.asList(new BreakerSettings("foo", 100, 1.2), new BreakerSettings("bar", 200, 0.1)),
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), Boolean.TRUE)
        // a reservation that bumps memory usage to less than 200 (150 bytes used + reservation < 200)
        final int NUM_THREADS = scaledRandomIntBetween(3, 15);
                    randomLongBetween(0, 100),
    }
        time.addAndGet(randomLongBetween(interval, interval * 2));
 * KIND, either express or implied.  See the License for the
            .put(HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "200mb")
        );
        assertEquals(0, requestBreaker.getTrippedCount());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                assertTrue(overLimitTriggered.compareAndSet(false, true));
        List<byte[]> data = new ArrayList<>();
            }
            assertEquals(new ByteSizeValue(200, ByteSizeUnit.MB).getBytes(), service.stats().getStats(CircuitBreaker.PARENT).getLimit());
                    barrier.await(10, TimeUnit.SECONDS);
        for (int i = 0; i < NUM_THREADS; i++) {
        AtomicInteger leaderTriggerCount = new AtomicInteger();
                assertThat(output.transientChildUsage, equalTo(input.transientChildUsage));
            containsString(
            .build();
        final Thread[] threads = new Thread[NUM_THREADS];
            () -> 0,
        List<Thread> threads = new ArrayList<>(threadCount);
        try (
        final CircuitBreakerService service = new HierarchyCircuitBreakerService(
                    } catch (CircuitBreakingException e) {
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), Boolean.TRUE)
        assertEquals(0, requestBreaker.getTrippedCount());
                        memoryUsed.baseUsage / 2,
            for (int i = 0; i < 1023; i++) {
            CircuitBreaker fieldDataCircuitBreaker = service.getBreaker(CircuitBreaker.FIELDDATA);
            }
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)
            blocker.join(10000);
        ) {
                        CircuitBreaker.Durability.PERMANENT
        assertThat("no other exceptions were thrown", lastException.get(), equalTo(null));
    public void testRegisterCustomCircuitBreakers_WithDuplicates() {
 * this work for additional information regarding copyright
        assumeTrue("Must have region size", JvmInfo.jvmInfo().getG1RegionSize() > 0);
                clusterSettings,
    private static long mb(long size) {
            CircuitBreaker requestCircuitBreaker = service.getBreaker(CircuitBreaker.REQUEST);
        long interval = randomLongBetween(1, 1000);
    }
 * the Apache License, Version 2.0 (the "License"); you may
                            assertThat(tripped.compareAndSet(false, true), equalTo(true));
            void overLimitTriggered(boolean leader) {
    }
     * this case, the request breaker borrows space from the fielddata breaker
                    }
        assertThat(leaderTriggerCount.get(), equalTo(2));
            clusterSettings,
        AtomicLong memoryUsage = new AtomicLong();
        memoryUsage.set(100);
import java.util.stream.Collectors;
                } else {
            double fieldDataUsedBytes = fieldDataCircuitBreaker.addEstimateBytesAndMaybeBreak(
            childLimit
            long parentLimitBytes = service.getParentLimit();
            .put(HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "100b")
            }
            assertThat(
                10000,
            );
 *
        assertThat(
                        requestBreakerUsed + newBytesReserved,
            interval,
    public void testG1LockTimeout() throws Exception {
                time::get,
                    );
        }
                    try {
        assertThat(output, not(sameInstance(input)));
            }
            // OK
            logger,
                    );
                exception.getMessage(),
        };
 */
            );
                for (int j = 0; j < BYTES_PER_THREAD; j++) {
                        throw new AssertionError(e);
                    nonLeaderTriggerCount.incrementAndGet();
            }
                        "parent tripped",
                "should not break"
            }
                assertThat(output.totalUsage, equalTo(output.baseUsage + input.totalUsage - input.baseUsage));
        for (Thread t : threads) {
                }
        AtomicInteger nonLeaderTriggerCount = new AtomicInteger();
            .put(HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "50%")
            );
            .build();
        final long requestCircuitBreakerUsed = (requestBreaker.getUsed() + reservationInBytes) * 2;
                TimeValue.timeValueSeconds(30)
    public void testTrippedCircuitBreakerDurability() {
            JvmInfo.jvmInfo(),
    }
            )
        assertThat(
    }
import java.util.List;
            t.join();
                "real usage: [181/181b], new bytes reserved: ["
            settings,
            assertEquals(new ByteSizeValue(100, ByteSizeUnit.BYTES).getBytes(), parentLimitBytes);
            assertFalse(saveTheDay);
            )
        List<Thread> threads = IntStream.range(0, threadCount).mapToObj(i -> new Thread(() -> {
        for (int i = 0; i < threadCount; ++i) {
        Settings clusterSettings = Settings.builder()
    public void testParentBreaksOnRealMemoryUsage() {
                        tripped.incrementAndGet();
            assertThat(overLimitStrategy, instanceOf(HierarchyCircuitBreakerService.G1OverLimitStrategy.class));
        AtomicLong gcCounter = new AtomicLong();
 * under the License.
            assertThat(service.getBreaker("bar").getLimit(), equalTo(200L));
            )
            assertThat(leaderTriggerCount.get(), greaterThanOrEqualTo(i / 2 + 1));
                new ByteSizeValue(50, ByteSizeUnit.MB).getBytes(),
        HierarchyCircuitBreakerService.MemoryUsage input = new HierarchyCircuitBreakerService.MemoryUsage(
            assertThat(service.getBreaker("foo"), is(not(nullValue())));
                multiBucketConsumer.accept(0);
        final int BYTES_PER_THREAD = scaledRandomIntBetween(500, 4500);
            service.checkParentLimit(0, "test");
        ) {
            Collections.emptyList(),
                    }
        }
 * ownership. Elasticsearch licenses this file to you under
        );
                service.checkParentLimit(0, "test");
        ) {
        iae = expectThrows(
                        parentLimit,
                        breaker.addEstimateBytesAndMaybeBreak(1L, "test");
        AtomicLong memoryUsage = new AtomicLong();
            CircuitBreakingException exception = expectThrows(
            assertEquals(new ByteSizeValue(50, ByteSizeUnit.MB).getBytes(), requestUsedBytes, 0.0);
            void overLimitTriggered(boolean leader) {
            new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                    return memoryUsed;
                return breakerRef.get();
        }
        assertThat(strategy.overLimit(input), sameInstance(input));
                    logger.info("Thread got semi-unexpected circuit breaking exception", e);
                            assertThat("tripped too many times", true, equalTo(false));
import java.util.concurrent.atomic.AtomicLong;
            });
            fail("must exceed memory limit");
            .build();
        logger.trace("black hole [{}]", data.hashCode());
                    leaderTriggerCount.incrementAndGet();
        logger.info(
                }
        };
        };
            t.start();
                    // very rare
            ) {
        assertThat("parent breaker was tripped at least once", parentTripped.get(), greaterThanOrEqualTo(1));
                    }
        for (Thread t : threads) {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        final AtomicBoolean tripped = new AtomicBoolean(false);
        );
            (HierarchyCircuitBreakerService) service,
        final CircuitBreaker requestBreaker = service.getBreaker(CircuitBreaker.REQUEST);
                return memoryUsage.get();
                if (leader) {
        threads.forEach(thread -> assertFalse(thread.isAlive()));
        breakerRef.set(breaker);
                    leaderTriggerCount.incrementAndGet();
                ((HierarchyCircuitBreakerService.G1OverLimitStrategy) overLimitStrategy).getLockTimeout(),
    public void testParentTriggersG1GCBeforeBreaking() throws InterruptedException, TimeoutException, BrokenBarrierException {
 * compatible open source license.
            iae.getMessage(),
        AtomicBoolean overLimitTriggered = new AtomicBoolean();
        // First setup a host of large byte[]'s, must be Humongous objects since those are cleaned during a young phase (no concurrent cycle
            try {
            });
                HierarchyCircuitBreakerService.MemoryUsage output = strategy.overLimit(input);
        output = strategy.overLimit(input);
    }
            public void checkParentLimit(long newBytesReserved, String label) throws CircuitBreakingException {
        }
            assertThat(exception.getMessage(), containsString("[parent] Data too large, data for [should break] would be"));
            HierarchyCircuitBreakerService.createOverLimitStrategy(false),
        int allocationCount = (int) (JvmInfo.jvmInfo().getConfiguredMaxHeapSize() / allocationSize) + 1;
        final HierarchyCircuitBreakerService service = new HierarchyCircuitBreakerService(
            Collections.emptyList(),
        // necessary, which is hard to control in the test).
                new ByteSizeValue(50, ByteSizeUnit.MB).getBytes(),
        final int BYTES_PER_THREAD = scaledRandomIntBetween(500, 4500);
            memoryUsage::get,
        ) {
        assertThat(strategy.overLimit(input), sameInstance(input));
        // assume memory usage has increased to 150 bytes
 */
                Collections.singletonList(new BreakerSettings(CircuitBreaker.FIELDDATA, 100, 1.2)),
            CircuitBreaker requestCircuitBreaker = service.getBreaker(CircuitBreaker.REQUEST);
        for (int i = 0; i < NUM_THREADS; i++) {
import org.opensearch.core.common.breaker.CircuitBreakingException;
            assertTrue(saveTheDay);
        final AtomicInteger parentTripped = new AtomicInteger(0);
        memoryUsage.set(181);
            thread.join(10000);
            Settings.EMPTY,
            do {
        };
                    + requestCircuitBreakerUsed
        CountDownLatch blockingUntil = new CountDownLatch(1);
        // anything below 100 bytes should work (overhead) - current memory usage is zero
                        } else {
        };
            t.join();
        AtomicLong time = new AtomicLong(randomLongBetween(Long.MIN_VALUE / 2, Long.MAX_VALUE / 2));
/*
        };
        memoryUsage.set(150);
            CircuitBreakerService service = new HierarchyCircuitBreakerService(
                        if (tripped.get()) {
        onOverLimit.set(leader -> {
            @Override
                        assertThat(blockingUntil.await(10, TimeUnit.SECONDS), is(true));
 *
            }
import java.util.Arrays;
        } else {
            TimeValue.timeValueSeconds(30)
    public void testThreadedUpdatesToChildBreakerWithParentLimit() throws Exception {
import org.opensearch.core.indices.breaker.CircuitBreakerService;
    public void testBorrowingSiblingBreakerMemory() {
            randomLongBetween(0, 50)
     * "Integration test" checking that we ask the G1 over limit check before parent breaking.
        );
import org.opensearch.core.common.unit.ByteSizeValue;
            @Override
            .build();
            time::get,
            @Override
                try {
        long g1RegionSize = JvmInfo.jvmInfo().getG1RegionSize();
            }
                exception.getDurability(),
        }
 * The OpenSearch Contributors require contributions made to
        try (
            .put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "150mb")
        if (JvmInfo.jvmInfo().useG1GC().equals("true")) {
        assertThat("no other exceptions were thrown", lastException.get(), equalTo(null));
        final BreakerSettings settings = new BreakerSettings(CircuitBreaker.REQUEST, childLimit, 1.0);
                // never trip
                        breaker.addEstimateBytesAndMaybeBreak(1L, "test");
        assertThat("breaker was tripped", tripped.get(), equalTo(true));
            threads[i].start();
/*
                    logger.info("--> parent tripped");
        long interval = randomLongBetween(1, 1000);
            1,
                return breakerRef.get();
    public void testParentDoesOverLimitCheck() {
import org.opensearch.common.unit.TimeValue;
            void overLimitTriggered(boolean leader) {
        assertThat(exception.getMessage(), containsString("which is larger than the limit of [200/200b]"));
import java.util.concurrent.atomic.AtomicBoolean;
            // make sure that we check on the following call
        assertThat(leaderTriggerCount.get(), equalTo(2));
        Settings clusterSettings = Settings.builder()
        long reservationInBytes = randomLongBetween(10, 50);
        );
            );
 *
            .put(HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "200mb")
        }
                data.clear();
        assertThat(output.totalUsage, equalTo(99 + input.totalUsage - 100));
            time.addAndGet(randomLongBetween(interval, interval * 2));
            breaker.getUsed(),
        CountDownLatch startedBlocking = new CountDownLatch(1);
        logger.info("--> starting threads...");
        final int childLimit = parentLimit + 10;
        HierarchyCircuitBreakerService.MemoryUsage input = new HierarchyCircuitBreakerService.MemoryUsage(
                        // this is the central assertion - the overLimit call below should complete in a timely manner.
            settings,
 * not use this file except in compliance with the License.
            TimeValue.timeValueSeconds(30)
            (BYTES_PER_THREAD * NUM_THREADS),
 * Unless required by applicable law or agreed to in writing,
            equalTo(JvmInfo.jvmInfo().getG1RegionSize())
                CircuitBreakingException.class,
        ) {
            .build();
        assertThat(
package org.opensearch.indices.breaker;
            .put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_OVERHEAD_SETTING.getKey(), 2)
        AtomicLong time = new AtomicLong(randomLongBetween(Long.MIN_VALUE / 2, Long.MAX_VALUE / 2));
            MultiBucketConsumerService.MultiBucketConsumer multiBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
            iae.getMessage(),
            NUM_THREADS,
            (HierarchyCircuitBreakerService) service,
import org.opensearch.core.common.unit.ByteSizeUnit;
            if (leader) {
            Collections.emptyList(),
        int threadCount = randomIntBetween(1, 10);
        logger.info("--> child breaker: used: {}, limit: {}", breaker.getUsed(), breaker.getLimit());
            // make sure used bytes is greater than the total circuit breaker limit
    public void testAllocationBucketsBreaker() {
        logger.trace("black hole [{}]", data.hashCode());
        barrier.await(20, TimeUnit.SECONDS);
        );
                    }
    public void testG1OverLimitStrategyBreakOnMemory() {
        HierarchyCircuitBreakerService.G1OverLimitStrategy strategy = new HierarchyCircuitBreakerService.G1OverLimitStrategy(
        int allocationSize = g1RegionSize > 0 ? (int) (g1RegionSize / 2) : 1024 * 1024;
        AtomicLong time = new AtomicLong(randomLongBetween(Long.MIN_VALUE / 2, Long.MAX_VALUE / 2));
        );
                } catch (CircuitBreakingException e) {
            assertEquals(new ByteSizeValue(150, ByteSizeUnit.MB).getBytes(), requestCircuitBreaker.getLimit());
                containsString("usages [request=157286400/150mb, fielddata=54001664/51.5mb, in_flight_requests=0/0b]")
            threads[i] = new Thread(() -> {
