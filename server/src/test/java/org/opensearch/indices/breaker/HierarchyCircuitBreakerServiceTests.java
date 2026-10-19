            threads.add(new Thread(() -> {
        );
        assertEquals(0, requestBreaker.getTrippedCount());  
        for (int i = 0; i < regionCount; ++i) {  
                    + "/"
                    } catch (Exception e) {
    }
    public void testThreadedUpdatesToChildBreaker() throws Exception {
            .put(HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "200b")
            memoryUsage::get,
            long parentLimitBytes = service.getParentLimit();
    }  
            assertThat(startedBlocking.await(10, TimeUnit.SECONDS), is(true));
import java.util.concurrent.atomic.AtomicBoolean;
        );
 * Modifications Copyright OpenSearch Contributors. See
        );
        HierarchyCircuitBreakerService.G1OverLimitStrategy strategy = new HierarchyCircuitBreakerService.G1OverLimitStrategy(  
            .put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "150mb")
                Collections.emptyList(),
        for (int i = 0; i < iterationCount; ++i) {
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), "false")
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < NUM_THREADS; i++) {  
 */  
            );
            .put(HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "200mb")
            time.addAndGet(randomLongBetween(interval, interval * 2));  
        } finally {  
            exception.getMessage(),
 * compatible open source license.
        final int BYTES_PER_THREAD = scaledRandomIntBetween(500, 4500);
        // necessary, which is hard to control in the test).
    /**
        // breaking the child breaker.  
            clusterSettings,
        );
        Settings clusterSettings = Settings.builder()
        logger.info(
        );
        final int BYTES_PER_THREAD = scaledRandomIntBetween(500, 4500);  
            time::get,
        logger.trace("black hole [{}]", data.hashCode());
        onOverLimit.set(leader -> {
                // Parent will trip right before regular breaker would trip
    }  
        threads.forEach(thread -> assertFalse(thread.isAlive()));  
        logger.info("--> starting threads...");
    public void testParentBreaksOnRealMemoryUsage() {
        boolean saveTheDay = randomBoolean();  
        final Thread[] threads = new Thread[NUM_THREADS];
        assertThat(exception.getDurability(), equalTo(CircuitBreaker.Durability.TRANSIENT));
            for (int i = 0; i < 1023; i++) {
        int iterationCount = randomIntBetween(1, 5);  
                assertThat(output.permanentChildUsage, equalTo(input.permanentChildUsage));
        assertThat(output.totalUsage, equalTo(99 + input.totalUsage - 100));
                "should not break"
            .put(HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "50%")
            1,
        final CircuitBreakerService service = new HierarchyCircuitBreakerService(  
                new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
                    return memoryUsed;
                service.checkParentLimit(0, "test");  
                return breakerRef.get();
                assertThat(output.transientChildUsage, equalTo(input.transientChildUsage));  
import java.util.concurrent.BrokenBarrierException;  
    }  
            () -> new HierarchyCircuitBreakerService(
                data.clear();
        }
                "usages [request="
            )  
            }
                }
        int threadCount = randomIntBetween(1, 10);
            for (int i = 0; i < allocationCount && overLimitTriggered.get() == false; ++i) {
     */
            assertFalse(saveTheDay);
        HierarchyCircuitBreakerService.MemoryUsage output = strategy.overLimit(input);
            CircuitBreaker fieldDataCircuitBreaker = service.getBreaker(CircuitBreaker.FIELDDATA);  
        HierarchyCircuitBreakerService.MemoryUsage input = new HierarchyCircuitBreakerService.MemoryUsage(  
        long interval = randomLongBetween(1, 1000);  
        final BreakerSettings settings = new BreakerSettings(CircuitBreaker.REQUEST, (BYTES_PER_THREAD * NUM_THREADS) - 1, 1.0);
import java.util.concurrent.TimeUnit;  
        // lower memory usage again - the same reservation should succeed  
            Collections.emptyList(),
 * this file be licensed under the Apache-2.0 license or a
            @Override
                } else {  
                equalTo(expectedDurability)  
                clusterSettings,
        int allocationSize = g1RegionSize > 0 ? (int) (g1RegionSize / 2) : 1024 * 1024;  
package org.opensearch.indices.breaker;
import org.opensearch.search.aggregations.MultiBucketConsumerService;
        }
        AtomicLong time = new AtomicLong(randomLongBetween(Long.MIN_VALUE / 2, Long.MAX_VALUE / 2));
            containsString("More than one circuit breaker with the name [foo] exists. Circuit breaker names must be unique")
 * KIND, either express or implied.  See the License for the
        long g1RegionSize = JvmInfo.jvmInfo().getG1RegionSize();  
            .put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_OVERHEAD_SETTING.getKey(), 2)
            gcCounter::incrementAndGet,
                    }
            assertThat(service.getBreaker("bar").getOverhead(), equalTo(0.1));
        assumeTrue("Only G1GC can utilize the over limit check", JvmInfo.jvmInfo().useG1GC().equals("true"));
        assertThat(output.permanentChildUsage, equalTo(input.permanentChildUsage));
            // OK
            assertThat(service.getBreaker("foo"), is(not(nullValue())));
        try {  
        blocker.start();  
        final HierarchyCircuitBreakerService service = new HierarchyCircuitBreakerService(
            iae.getMessage(),
                HierarchyCircuitBreakerService.MemoryUsage input = new HierarchyCircuitBreakerService.MemoryUsage(
            randomLongBetween(0, 50)
import org.opensearch.common.settings.ClusterSettings;
                if (leader) {  
            }
            .put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "350b")  
                for (int j = 0; j < BYTES_PER_THREAD; j++) {
                void overLimitTriggered(boolean leader) {  
            BYTES_PER_THREAD,
                    } catch (CircuitBreakingException e) {
        breakerRef.set(breaker);  
                    try {  
            )
        final CircuitBreakerService service = new HierarchyCircuitBreakerService(
        Settings clusterSettings = Settings.builder()
    public void testRegisterCustomCircuitBreakers_WithDuplicates() {
                () -> requestCircuitBreaker.addEstimateBytesAndMaybeBreak(new ByteSizeValue(50, ByteSizeUnit.MB).getBytes(), "should break")
                    randomLongBetween(0, 100),
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), Boolean.TRUE)
    private static long mb(long size) {
                } else {
public class HierarchyCircuitBreakerServiceTests extends OpenSearchTestCase {  
            clusterSettings,  
            );  
                Collections.emptyList(),
import static org.hamcrest.Matchers.nullValue;  
            assertEquals(new ByteSizeValue(100, ByteSizeUnit.MB).getBytes(), requestUsedBytes, 0.0);
                    );
        };  
                    } catch (Exception e) {
                new ByteSizeValue(50, ByteSizeUnit.MB).getBytes(),  
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), Boolean.TRUE)
        long g1RegionSize = JvmInfo.jvmInfo().getG1RegionSize();
/*
                    leaderTriggerCount.incrementAndGet();
            assertThat(blocker.isAlive(), is(false));  
        int allocationCount = (int) (JvmInfo.jvmInfo().getConfiguredMaxHeapSize() / allocationSize) + 1;
        // anything below 100 bytes should work (overhead) - current memory usage is zero
            }  
import org.opensearch.test.OpenSearchTestCase;  
            public void checkParentLimit(long newBytesReserved, String label) throws CircuitBreakingException {  
                        memoryUsed.baseUsage / 2,
            CircuitBreaker fieldDataCircuitBreaker = service.getBreaker(CircuitBreaker.FIELDDATA);
            .build();
    }
        final AtomicBoolean tripped = new AtomicBoolean(false);  
                    logger.info("Thread got semi-unexpected circuit breaking exception", e);
        assertEquals(1, service.stats().getStats(CircuitBreaker.PARENT).getTrippedCount());
        );  
            Collections.emptyList(),  
        ) {
                        parentLimit,  
                    throw new CircuitBreakingException(  
        assertThat(strategy.overLimit(input), sameInstance(input));
        }
                    + "/"  
        assertThat(nonLeaderTriggerCount.get(), equalTo(1));
        memoryUsage.set(99);
                } else {  
                }
                }
 */  
                data.add(new byte[allocationSize]);
            );  
            assertThat(leaderTriggerCount.get(), lessThanOrEqualTo(i + 1));
        assertThat("breaker was tripped", tripped.get(), equalTo(true));  
        for (int i = 0; i < threadCount; ++i) {
        try (
        for (Thread t : threads) {  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            assertTrue(saveTheDay);
    public void testG1OverLimitStrategyBreakOnGcCount() {
    public void testG1OverLimitStrategyThrottling() throws InterruptedException, BrokenBarrierException, TimeoutException {
        AtomicLong gcCounter = new AtomicLong();
                    nonLeaderTriggerCount.incrementAndGet();
            blocker.join(10000);
        return new ByteSizeValue(size, ByteSizeUnit.MB).getBytes();
            @Override  
                        leaderTriggerCount.incrementAndGet();
            countDown.set(new CountDownLatch(randomIntBetween(1, 20)));
        int threadCount = randomIntBetween(1, 10);  
            );
     * the end of the test is not enabled. The following tests checks this in more unit test style.  
            .put(HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "200mb")  
        ) {
        barrier.await(20, TimeUnit.SECONDS);
        try (
                        breaker.addEstimateBytesAndMaybeBreak(1L, "test");  
            randomLongBetween(0, 50),  
            assertEquals(new ByteSizeValue(200, ByteSizeUnit.MB).getBytes(), service.stats().getStats(CircuitBreaker.PARENT).getLimit());
            }  
            );
            memoryUsage.set(randomLongBetween(0, 100));
            .put(HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "100b")
        CyclicBarrier barrier = new CyclicBarrier(threadCount + 1);
import static org.hamcrest.Matchers.sameInstance;
        final CircuitBreakerService service = new HierarchyCircuitBreakerService(
            );
        );
            assertThat(exception.getMessage(), containsString("[parent] Data too large, data for [should break] would be"));
        }  
        breakerRef.set(breaker);
import java.util.stream.Collectors;
        threads.forEach(thread -> assertFalse(thread.isAlive()));
            randomLongBetween(0, 50)
                    randomLongBetween(0, 100)
        // assume memory usage has increased to 150 bytes
        AtomicReference<CountDownLatch> countDown = new AtomicReference<>(new CountDownLatch(randomIntBetween(1, 20)));
    public void testParentDoesOverLimitCheck() {
            void overLimitTriggered(boolean leader) {  
        final CircuitBreaker requestBreaker = service.getBreaker(CircuitBreaker.REQUEST);  
        assertThat(leaderTriggerCount.get(), equalTo(2));
                    leaderTriggerCount.incrementAndGet();
            ) {  
                10000,  
        assertThat(gcCounter.get(), equalTo(2L));
            }
                "should not break"  
        final AtomicReference<ChildMemoryCircuitBreaker> breakerRef = new AtomicReference<>(null);  
        long reservationInBytes = randomLongBetween(10, 50);
            containsString(
 * not use this file except in compliance with the License.
                throw new AssertionError(e);
        };
                @Override
                        CircuitBreaker.Durability.PERMANENT
        };
        }
    public void testBorrowingSiblingBreakerMemory() {  
            );
        };
                    }  
        assertThat(  
            CircuitBreakingException.class,
        long interval = randomLongBetween(1, 1000);  
     */
        assertThat(output.baseUsage, equalTo(memoryUsage.get()));
            CircuitBreaker requestCircuitBreaker = service.getBreaker(CircuitBreaker.REQUEST);  
            "--> NUM_THREADS: [{}], BYTES_PER_THREAD: [{}], TOTAL_BYTES: [{}], PARENT_LIMIT: [{}], CHILD_LIMIT: [{}]",  
            100,
        AtomicLong time = new AtomicLong(randomLongBetween(Long.MIN_VALUE / 2, Long.MAX_VALUE / 2));  
        threads.forEach(Thread::start);  
            .build();
            CircuitBreaker.REQUEST
                new ByteSizeValue(50, ByteSizeUnit.MB).getBytes(),
                Collections.singletonList(new BreakerSettings(CircuitBreaker.FIELDDATA, 100, 1.2)),  
        AtomicReference<Consumer<Boolean>> onOverLimit = new AtomicReference<>(leader -> {});
        if (JvmInfo.jvmInfo().useG1GC().equals("true")) {
                    barrier.await(10, TimeUnit.SECONDS);
        assertThat(leaderTriggerCount.get(), equalTo(1));  
            memoryUsageSupplier,  
    public void testFallbackG1RegionSize() {
        assertEquals(0, requestBreaker.getTrippedCount());
            Collections.emptyList(),  
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            () -> requestBreaker.addEstimateBytesAndMaybeBreak(reservationInBytes, "request")  
                Settings.EMPTY,
     * this case, the request breaker borrows space from the fielddata breaker
            )
        }
                        }  
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            IllegalArgumentException.class,
            public void checkParentLimit(long newBytesReserved, String label) throws CircuitBreakingException {
        }
        } catch (CircuitBreakingException e) {  
        final ChildMemoryCircuitBreaker breaker = new ChildMemoryCircuitBreaker(
                if (leader) {  
import org.opensearch.core.common.breaker.CircuitBreakingException;  
            () -> 0,  
            CircuitBreakerService service = new HierarchyCircuitBreakerService(
        }  
import java.util.concurrent.TimeoutException;
        for (Thread t : threads) {
            @Override
        assertThat(memoryUsageCounter.get(), equalTo(2L)); // 1 before gc count break and 1 to get resulting memory usage.
                HierarchyCircuitBreakerService.createYoungGcCountSupplier(),
                () -> fieldDataCircuitBreaker.addEstimateBytesAndMaybeBreak(mb(40), "should break")
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
        logger.info("--> parent tripped: {}, total trip count: {} (expecting 1-2 for each)", parentTripped.get(), tripped.get());  
    }  
                    randomLongBetween(0, 100),  
        }
                Settings.EMPTY,  
                    // very rare  
                barrier.await(10, TimeUnit.SECONDS);
            breaker.getUsed(),
/*  
        );  
            }
        } catch (CircuitBreakingException e) {  
        int regionCount = Math.toIntExact((maxHeap / 2 + g1RegionSize - 1) / g1RegionSize);
            );  
            }
        } else {
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                        lastException.set(e);
            assertThat(leaderTriggerCount.get(), greaterThanOrEqualTo(i / 2 + 1));
        final AtomicReference<Throwable> lastException = new AtomicReference<>(null);
import org.opensearch.monitor.jvm.JvmInfo;
        assertThat(output, not(sameInstance(input)));  
    }  
            new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
     * "Integration test" checking that we ask the G1 over limit check before parent breaking.
import java.util.ArrayList;
            not(instanceOf(HierarchyCircuitBreakerService.G1OverLimitStrategy.class))
                    onOverLimit.get().accept(leader);
                containsString("usages [request=157286400/150mb, fielddata=54001664/51.5mb, in_flight_requests=0/0b]")
            assertThat(exception.getMessage(), containsString("[parent] Data too large, data for [allocated_buckets] would be"));
        assertEquals(0, requestBreaker.getTrippedCount());  
            )
    }  
        List<byte[]> data = new ArrayList<>();
        });  
import static org.hamcrest.Matchers.instanceOf;  
                        memoryUsed.permanentChildUsage
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(exception.getMessage(), containsString("which is larger than the limit of [200/200b]"));
                expectedDurability = CircuitBreaker.Durability.TRANSIENT;
            public CircuitBreaker getBreaker(String name) {
            parentLimit,
                JvmInfo.jvmInfo(),  
                }
    public void testCustomCircuitBreakers() {
            memoryUsage::get,  
            JvmInfo.jvmInfo(),
                        throw new AssertionError(e);
 * under the License.  
                );  
            assertEquals(new ByteSizeValue(100, ByteSizeUnit.BYTES).getBytes(), parentLimitBytes);
                        tripped.incrementAndGet();  
        final AtomicInteger tripped = new AtomicInteger(0);
            double fieldDataUsedBytes = fieldDataCircuitBreaker.addEstimateBytesAndMaybeBreak(  
            new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        };
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
                    if (leader) {
            // make sure that we check on the following call  
    public void testAllocationBucketsBreaker() {
        assertThat(exception.getMessage(), containsString("[parent] Data too large, data for [request] would be"));  
        final AtomicInteger parentTripped = new AtomicInteger(0);
        AtomicInteger leaderTriggerCount = new AtomicInteger();
                Settings.EMPTY,
            randomLongBetween(100, 110),  
            assertThat(exception.getMessage(), containsString("which is larger than the limit of [100/100b]"));  
                        // this is the central assertion - the overLimit call below should complete in a timely manner.
                if (requestBreakerUsed > parentLimit) {  
            containsString(  
        for (Thread thread : threads) {
                Arrays.asList(new BreakerSettings("foo", 100, 1.2), new BreakerSettings("bar", 200, 0.1)),  
        assertThat(output.permanentChildUsage, equalTo(input.permanentChildUsage));
            @Override
            MultiBucketConsumerService.MultiBucketConsumer multiBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
import java.util.concurrent.atomic.AtomicInteger;  
            t.join();
                exception.getMessage(),
            }
            assertThat(exception.getMessage(), containsString("[parent] Data too large, data for [should break] would be"));
        HierarchyCircuitBreakerService.G1OverLimitStrategy strategy = new HierarchyCircuitBreakerService.G1OverLimitStrategy(
            assertEquals(new ByteSizeValue(150, ByteSizeUnit.MB).getBytes(), fieldDataCircuitBreaker.getLimit());
                    );
            t.join();
            assertThat(exception.getMessage(), containsString("which is larger than the limit of [209715200/200mb]"));
        // anything >= 20 bytes (10 bytes * 2 overhead) reservation breaks the parent but it must be low enough to avoid
                        if (tripped.get()) {
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)
        })).collect(Collectors.toList());
            }
            assertThat(exception.getDurability(), equalTo(CircuitBreaker.Durability.TRANSIENT));
                requestCircuitBreaker.addEstimateBytesAndMaybeBreak(mb(120), "should not break");
            NUM_THREADS,
            assertThat(service.getBreaker("foo").getLimit(), equalTo(100L));  
            .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "150mb")
            HierarchyCircuitBreakerService.createOverLimitStrategy(false),
            JvmInfo.jvmInfo(),
        ) {  
            interval,  
 * this work for additional information regarding copyright
import org.opensearch.core.common.unit.ByteSizeValue;
    }
        assumeTrue("Must have region size", JvmInfo.jvmInfo().getG1RegionSize() > 0);  
import java.util.Collections;
        ) {
                    randomLongBetween(0, 100),
            }  
            }
        CountDownLatch startedBlocking = new CountDownLatch(1);
                fieldDataCircuitBreaker.addEstimateBytesAndMaybeBreak(mb(70), "should not break");  
        final AtomicReference<ChildMemoryCircuitBreaker> breakerRef = new AtomicReference<>(null);
 * Licensed to Elasticsearch under one or more contributor  
            void overLimitTriggered(boolean leader) {  
                } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {  
            () -> 0,  
        );  
            // this should complete in a timely manner, verified by the assertion in the thread.
        AtomicLong time = new AtomicLong(randomLongBetween(Long.MIN_VALUE / 2, Long.MAX_VALUE / 2));  
                    throw new AssertionError(e);
            clusterSettings,  
            logger,
            } while (!Thread.interrupted());  
    public void testG1OverLimitStrategyBreakOnMemory() {
            assertThat(  
        );
        );
import java.util.function.LongSupplier;
        HierarchyCircuitBreakerService.G1OverLimitStrategy strategy = new HierarchyCircuitBreakerService.G1OverLimitStrategy(
            (HierarchyCircuitBreakerService) service,  
                assertThat(output.totalUsage, equalTo(output.baseUsage + input.totalUsage - input.baseUsage));
            assertThat(service.getBreaker("bar").getLimit(), equalTo(200L));  
        assertThat(output.totalUsage, equalTo(99 + input.totalUsage - 100));
            "breaker should be reset back to the parent limit after parent breaker trips",  
        final int NUM_THREADS = scaledRandomIntBetween(3, 15);
                    + ", fielddata=0/0b, in_flight_requests=0/0b]"
        assumeTrue("Must have region size", g1RegionSize > 0);
            gcCounter::incrementAndGet,
        HierarchyCircuitBreakerService.MemoryUsage input = new HierarchyCircuitBreakerService.MemoryUsage(
            trackRealMemoryUsage -> memoryUsed -> {  
            requestUsedBytes = requestCircuitBreaker.addEstimateBytesAndMaybeBreak(
            interval,
            logger,  
            });
import org.opensearch.common.unit.TimeValue;
            @Override
        CyclicBarrier barrier = new CyclicBarrier(threadCount + 1);
        ) {
    }  
        assertThat(output.transientChildUsage, equalTo(input.transientChildUsage));  
                    }  
        AtomicLong memoryUsageCounter = new AtomicLong();
                if (leader) {
                "real usage: [181/181b], new bytes reserved: ["
                clusterSettings,
        memoryUsage.set(100);
                return breakerRef.get();  
            randomLongBetween(100, 110),
                expectedDurability = CircuitBreaker.Durability.PERMANENT;
                Arrays.asList(new BreakerSettings("foo", 100, 1.2), new BreakerSettings("foo", 200, 0.1)),
            greaterThanOrEqualTo((long) parentLimit - NUM_THREADS)
                return memoryUsage.get();  
                for (int j = 0; j < BYTES_PER_THREAD; j++) {
            randomLongBetween(0, 50),
        assertThat(
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            threads[i].start();
                HierarchyCircuitBreakerService::realMemoryUsage,
            fail("must exceed memory limit");
            equalTo(JvmInfo.jvmInfo().getG1RegionSize())
    }  
        ) {  
            HierarchyCircuitBreakerService.G1OverLimitStrategy.fallbackRegionSize(JvmInfo.jvmInfo()),  
        memoryUsage.set(181);
            return randomLongBetween(100, 110);
            );
                assertTrue(overLimitTriggered.compareAndSet(false, true));
            TimeValue.timeValueSeconds(30)
        AtomicInteger leaderTriggerCount = new AtomicInteger();
                Collections.emptyList(),
            // make sure used bytes is greater than the total circuit breaker limit
        HierarchyCircuitBreakerService.MemoryUsage input = new HierarchyCircuitBreakerService.MemoryUsage(100, 100, 0, 0);
                }  
        AtomicLong time = new AtomicLong(randomLongBetween(Long.MIN_VALUE / 2, Long.MAX_VALUE / 2));  
        AtomicInteger nonLeaderTriggerCount = new AtomicInteger();
            .put(HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "50%")  
                        assertThat(blockingUntil.await(10, TimeUnit.SECONDS), is(true));
                    nonLeaderTriggerCount.incrementAndGet();  
            settings,
        AtomicInteger nonLeaderTriggerCount = new AtomicInteger();
                        breaker.addEstimateBytesAndMaybeBreak(1L, "test");
                if (leader) {
            breaker.addWithoutBreaking(200);
            () -> 100,
                CircuitBreakingException.class,
        Settings clusterSettings = Settings.builder()  
        ) {
 *  
        iae = expectThrows(  
            (BYTES_PER_THREAD * NUM_THREADS),  
        final ChildMemoryCircuitBreaker breaker = new ChildMemoryCircuitBreaker(  
            Settings.EMPTY,
    public void testG1LockTimeout() throws Exception {
            iae.getMessage(),  
    public void testParentTriggersG1GCBeforeBreaking() throws InterruptedException, TimeoutException, BrokenBarrierException {
        };
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.CoreMatchers.is;
        logger.info("--> child breaker: used: {}, limit: {}", breaker.getUsed(), breaker.getLimit());
                        "parent tripped",
        final int childLimit = parentLimit + 10;
                }
                    leaderTriggerCount.incrementAndGet();
        memoryUsage.set(150);  
 * software distributed under the License is distributed on an
                    try {  
        assertThat("total breaker was tripped at least once", tripped.get(), greaterThanOrEqualTo(1));
        }
            TimeValue.timeValueSeconds(30)
import org.opensearch.common.settings.Settings;  
        AtomicLong gcCounter = new AtomicLong();
        for (Thread t : threads) {
                    + new ByteSizeValue(reservationInBytes * 2)
            CircuitBreakingException exception = expectThrows(
import org.opensearch.core.common.breaker.CircuitBreaker;
        for (Thread thread : threads) {  
                    logger.info("--> parent tripped");
        AtomicInteger leaderTriggerCount = new AtomicInteger();  
            .put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "150mb")
        ) {
        time.addAndGet(randomLongBetween(interval, interval + 10));
            assertEquals(new ByteSizeValue(50, ByteSizeUnit.MB).getBytes(), requestUsedBytes, 0.0);  
                        } else {
                }
            } else {
/*  
import java.util.concurrent.CountDownLatch;
            void overLimitTriggered(boolean leader) {
            assertEquals(new ByteSizeValue(150, ByteSizeUnit.MB).getBytes(), requestCircuitBreaker.getLimit());  
                if (saveTheDay) {
        CircuitBreakingException exception = expectThrows(
        };
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                }  
}
            }  
            () -> 0,
        List<byte[]> data = new ArrayList<>();
        assertThat(leaderTriggerCount.get(), equalTo(2));
            .build();  
                "Expected [" + expectedDurability + "] due to [" + exception.getMessage() + "]",
        logger.trace("black hole [{}]", data.hashCode());
            data.add(new byte[(int) (JvmInfo.jvmInfo().getG1RegionSize() / 2)]);
                        memoryUsed.totalUsage - (memoryUsed.baseUsage / 2),
            CircuitBreaker.Durability expectedDurability;  
import java.util.List;
        }  
            service.checkParentLimit(0, "test");
 * Unless required by applicable law or agreed to in writing,
        assertEquals(0, requestBreaker.getTrippedCount());
    }  
            exception.getMessage(),  
        try {
            assertThat(  
                requestCircuitBreaker.addEstimateBytesAndMaybeBreak(mb(70), "should not break");  
                CircuitBreakingException.class,  
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            }  
                long requestBreakerUsed = getBreaker(CircuitBreaker.REQUEST).getUsed();
        try (  
                clusterSettings,  
            long currentMemoryUsage() {
                            assertThat(tripped.compareAndSet(false, true), equalTo(true));
     * Given that it depends on GC, the main assertion that we do not get a circuit breaking exception in the threads towards
import static org.hamcrest.Matchers.containsString;  
        try {  
 * The OpenSearch Contributors require contributions made to  
            )  
            });
    public void testTrippedCircuitBreakerDurability() {
        try (
    }
                multiBucketConsumer.accept(0);
 * ownership. Elasticsearch licenses this file to you under  
        List<Thread> threads = new ArrayList<>(threadCount);  
import org.opensearch.common.breaker.ChildMemoryCircuitBreaker;
        // First setup a host of large byte[]'s, must be Humongous objects since those are cleaned during a young phase (no concurrent cycle  
            thread.join(10000);
        HierarchyCircuitBreakerService.OverLimitStrategy overLimitStrategy = HierarchyCircuitBreakerService.createOverLimitStrategy(true);
        assertThat(leaderTriggerCount.get(), equalTo(1));
            time::get,
            threads[i] = new Thread(() -> {
        assertThat(output, not(sameInstance(input)));  
import static org.hamcrest.Matchers.not;
                exception.getDurability(),
            CircuitBreakingException exception = expectThrows(  
                    return new HierarchyCircuitBreakerService.MemoryUsage(  
    /**  
    }
            CircuitBreakerService service = new HierarchyCircuitBreakerService(  
        AtomicLong memoryUsage = new AtomicLong();  
            IllegalArgumentException.class,  
                new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
            settings,
                    + (reservationInBytes * 2)  
            assertThat(service.getBreaker("bar"), is(not(nullValue())));
            () -> new HierarchyCircuitBreakerService(
                    startedBlocking.countDown();
        }
                    }  
        );  
            .build();  
    }
            threads[i] = new Thread(() -> {  
        final long requestCircuitBreakerUsed = (requestBreaker.getUsed() + reservationInBytes) * 2;  
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), Boolean.TRUE)  
            assertThat(
            TimeValue.timeValueSeconds(30)  
        HierarchyCircuitBreakerService.G1OverLimitStrategy strategy = new HierarchyCircuitBreakerService.G1OverLimitStrategy(
            .build();
        );
            (HierarchyCircuitBreakerService) service,
        assertThat(output.baseUsage, equalTo(memoryUsage.get()));
            interval,  
        assertThat(strategy.overLimit(input), sameInstance(input));
        Settings clusterSettings = Settings.builder()  
    public void testCreateOverLimitStrategy() {
            } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {  
        final BreakerSettings settings = new BreakerSettings(CircuitBreaker.REQUEST, childLimit, 1.0);  
        ) {
        threads.forEach(Thread::interrupt);
 */
            if (leader) {  
                } catch (CircuitBreakingException e) {
            blockingUntil.countDown();
            assertThat(overLimitStrategy, not(instanceOf(HierarchyCircuitBreakerService.G1OverLimitStrategy.class)));  
        assertThat("no other exceptions were thrown", lastException.get(), equalTo(null));
                    + requestCircuitBreakerUsed
        requestBreaker.addEstimateBytesAndMaybeBreak(randomLongBetween(0, 24), "request");  
import org.opensearch.core.common.unit.ByteSizeUnit;
            CircuitBreaker.REQUEST
            thread.join(10000);  
            assertThat(strategy.overLimit(input), sameInstance(input));
        );  
        threads.forEach(Thread::start);  
                        lastException.set(e);
            assertThat(exception.getMessage(), containsString("which is larger than the limit of [209715200/200mb]"));
        }
            assertThat(overLimitStrategy, instanceOf(HierarchyCircuitBreakerService.G1OverLimitStrategy.class));  
        CountDownLatch blockingUntil = new CountDownLatch(1);  
                TimeValue.timeValueSeconds(30)
                interval,
        requestBreaker.addEstimateBytesAndMaybeBreak(randomLongBetween(0, 99), "request");  
                        memoryUsed.transientChildUsage,  
            t.start();
        Thread blocker = new Thread(() -> { strategy.overLimit(input); });
        memoryUsage.set(randomLongBetween(100, 110));
 * GitHub history for details.
            CircuitBreaker requestCircuitBreaker = service.getBreaker(CircuitBreaker.REQUEST);
            containsString("More than one circuit breaker with the name [fielddata] exists. Circuit breaker names must be unique")  
        AtomicInteger leaderTriggerCount = new AtomicInteger();
import java.util.function.Consumer;  
        ) {  
                        requestBreakerUsed + newBytesReserved,
            )
        assertThat(
            double requestUsedBytes = requestCircuitBreaker.addEstimateBytesAndMaybeBreak(
                equalTo(TimeValue.timeValueMillis(500))  
                breaker
            childLimit
            }));  
import static org.hamcrest.Matchers.equalTo;
        }
        assertThat(
        final int NUM_THREADS = scaledRandomIntBetween(3, 15);  
            TimeValue.timeValueMillis(randomFrom(0, 5, 10))
    }
            assertEquals(new ByteSizeValue(50, ByteSizeUnit.MB).getBytes(), fieldDataUsedBytes, 0.0);
            }  
            CircuitBreakerService service = new HierarchyCircuitBreakerService(
    }  
import java.util.concurrent.CyclicBarrier;
        final int parentLimit = (BYTES_PER_THREAD * NUM_THREADS) - 2;
                fieldDataCircuitBreaker.addEstimateBytesAndMaybeBreak(mb(100), "should not break");
                    + new ByteSizeValue(requestCircuitBreakerUsed)
     * Test that a breaker correctly redistributes to a different breaker, in  
                    + "]"  
            HierarchyCircuitBreakerService service = new HierarchyCircuitBreakerService(  
            }  
            Collections.emptyList(),
            CircuitBreakingException exception = expectThrows(CircuitBreakingException.class, () -> multiBucketConsumer.accept(1024));
        // it was the parent that rejected the reservation
        LongSupplier memoryUsageSupplier = () -> {  
                    try {
                new ByteSizeValue(50, ByteSizeUnit.MB).getBytes(),
            assertThat(service.getBreaker("foo").getOverhead(), equalTo(1.2));
        long interval = randomLongBetween(1, 1000);  
            Collections.emptyList(),
                // never trip
                    } catch (CircuitBreakingException e) {
                time::get,  
            }  
        }
                }
            @Override
            100,
import java.util.concurrent.atomic.AtomicReference;
        }
        final AtomicReference<Throwable> lastException = new AtomicReference<>(null);
            @Override  
                    parentTripped.incrementAndGet();
        assertThat(output.transientChildUsage, equalTo(input.transientChildUsage));  
        assumeTrue("Only G1GC can utilize the over limit check", JvmInfo.jvmInfo().useG1GC().equals("true"));  
            Settings.EMPTY,
        Settings clusterSettings = Settings.builder()
                            assertThat("tripped too many times", true, equalTo(false));  
            CircuitBreaker breaker = service.getBreaker(CircuitBreaker.REQUEST);
                    } catch (InterruptedException e) {  
        IllegalArgumentException iae = expectThrows(
            try {
import java.util.Arrays;  
            JvmInfo.jvmInfo(),  
            )
        );
        long maxHeap = JvmInfo.jvmInfo().getConfiguredMaxHeapSize();  
        requestBreaker.addEstimateBytesAndMaybeBreak(reservationInBytes, "request");
            .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "150mb")  
        };  
            public CircuitBreaker getBreaker(String name) {
            void overLimitTriggered(boolean leader) {
        final Thread[] threads = new Thread[NUM_THREADS];  
        output = strategy.overLimit(input);
 *
 *
            )  
            trackRealMemoryUsage -> new HierarchyCircuitBreakerService.G1OverLimitStrategy(
            do {  
                "should not break"
        assertThat("parent breaker was tripped at least once", parentTripped.get(), greaterThanOrEqualTo(1));
        List<Thread> threads = IntStream.range(0, threadCount).mapToObj(i -> new Thread(() -> {  
        long interval = randomLongBetween(1, 1000);
    public void testThreadedUpdatesToChildBreakerWithParentLimit() throws Exception {
            JvmInfo.jvmInfo(),
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
            @Override
                new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                HierarchyCircuitBreakerService.MemoryUsage output = strategy.overLimit(input);
        );  
            assertTrue(countDown.get().await(20, TimeUnit.SECONDS));  
        assertThat("breaker was tripped at least once", breaker.getTrippedCount(), greaterThanOrEqualTo(1L));
        assertThat("no other exceptions were thrown", lastException.get(), equalTo(null));
                try {  
        final HierarchyCircuitBreakerService service = new HierarchyCircuitBreakerService(
import java.util.stream.IntStream;  
        );
                ((HierarchyCircuitBreakerService.G1OverLimitStrategy) overLimitStrategy).getLockTimeout(),
 * You may obtain a copy of the License at  
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), Boolean.FALSE)  
        AtomicBoolean overLimitTriggered = new AtomicBoolean();
        assertThat(
            time::get,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (randomBoolean()) {
        barrier.await(20, TimeUnit.SECONDS);
        AtomicLong memoryUsage = new AtomicLong();
        time.addAndGet(randomLongBetween(interval, interval * 2));
            .build();
import java.util.concurrent.atomic.AtomicLong;
        }
                countDown.get().countDown();
        Settings clusterSettings = Settings.builder()
        ) {
        // a reservation that bumps memory usage to less than 200 (150 bytes used + reservation < 200)
            memoryUsageCounter.incrementAndGet();
                }
        AtomicLong memoryUsage = new AtomicLong();
            new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        assertThat(
        assertThat(
                    service.checkParentLimit(0, "test-thread");
            @Override
