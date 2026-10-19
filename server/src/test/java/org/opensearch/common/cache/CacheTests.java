        Set<Integer> keys = new HashSet<>();
            expected.add(i);
        // wait for all threads to finish
        invalidator.start();
    public void testDependentKeyDeadlock() throws BrokenBarrierException, InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                } else {
                    barrier.await();
import org.junit.Before;
                });
            @Override
        CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
                for (long deadlockedThread : deadlockedThreads) {
    }
                    barrier.await();
                cache.invalidate(i);
            expected.add(i);
        CopyOnWriteArrayList<ExecutionException> failures = new CopyOnWriteArrayList<>();
    public void testSimpleExpireAfterAccess() {
        // cache entries up to numberOfEntries - maximumWeight; all of these entries will ultimately be evicted in
            }
                                    return 0;
import java.util.Random;
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
                    barrier.await();
            cache.put(i, Integer.toString(i));
        barrier.await();
            threads.add(thread);
                    cache.invalidate(key, Integer.toString(key + randomIntBetween(2, 10)));
        int weight = randomIntBetween(2, 10);
            .removalListener(notification -> {
        }).build();
                            break;
            for (Thread thread : threads) {
        }
        for (int i = 0; i < evictedKeys.size(); i++) {
        for (int i = 0; i < numberOfThreads; i++) {
        for (int i = numberOfEntries; i < 2 * numberOfEntries; i++) {
    // those entries
        cache.setRemovalListener(notification -> {
        final CountDownLatch releaseLoad = new CountDownLatch(1);
    // the first batch of cached entries expired and were removed
        assertEquals(numberOfEntries, cache.weight());
        for (int i = 0; i < numberOfEntries; i++) {
                                if (k.key == 0) {
            cache.put(i, Integer.toString(i));
                releaseLoad.await();
        Set<Integer> remainingKeys = new HashSet<>();
        }
                        Key key = new Key(random.nextInt(numberOfEntries));
        }
    public void testKeysSnapshotContainsAllKeys() {
            assertNull(cache.get(i));
                            cache.computeIfAbsent(key, k -> {
                        }
        }
                assertNotNull(cache.get(i));
        for (int i = 0; i < numberOfEntries; i++) {
        barrier.await();
    }
                try {
            Thread thread = new Thread(() -> {
        assertEquals(0, cache.count());
            assertEquals(i, (int) evictedKeys.get(i));
            --missingKey;
            Thread thread = new Thread(() -> {
            @Override
        barrier.await();
        assertEquals(IN_FLIGHT_KEY, removals.get(0).getKey());
        Map<Integer, Integer> map = new HashMap<>();
        };
        now.set(0);
        List<Thread> threads = new ArrayList<>();
                    barrier.await();
    // randomly invalidate some cached entries, then check that we receive invalidate notifications for those and only
                    for (int j = 0; j < numberOfEntries; j++) {
        }).removalListener(removals::add).build();
                expectedRemovals.add(value);
        final Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().build();
            cache.put(i, Integer.toString(i));
            .setMaximumWeight(numberOfEntries)
                        }
                } catch (BrokenBarrierException | InterruptedException e) {
            }
            assertFalse(keys.contains(expectedEvictions.get(i)));
 * compatible open source license.
            });
        assertEquals(RemovalReason.INVALIDATED, removals.get(0).getRemovalReason());
    public void testNotificationOnInvalidate() {
                assertNotNull(cache.get(i));
                    for (int j = 0; j < numberOfEntries; j++) {
                        break;
            keys.add(key);
            .setNumberOfSegments(numberOfSegments)
            });
 * this file be licensed under the Apache-2.0 license or a
            }
        final CountDownLatch releaseLoad = new CountDownLatch(1);
        }
            protected long now() {
    // whole duration of the call, regardless of concurrent reads promoting entries.
        List<Integer> remainingKeys = new ArrayList<>();
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
        try {
        Cache<Integer, String> cache = new Cache<Integer, String>(numberOfSegments) {
            if (rarely()) {
    // check that the evicted entries were evicted in LRU order (first the odds in a batch, then the evens in a batch)
            } else {
        final CyclicBarrier barrier = new CyclicBarrier(1 + numberOfReaders);
        for (int i = 0; i < numberOfEntries; i++) {
    }
            if (promotedKeys.contains(i)) {
        barrier.await();
            }
    private static final String IN_FLIGHT_KEY = "in_flight";
            for (int j = i * maximumWeight; j < (i + 1) * maximumWeight && j < numberOfEntries - maximumWeight; j++) {
                    throw new AssertionError(e);
                try {
        }
                replaced++;
            cache.put(i, Integer.toString(i));
        for (Integer key : cache.keys()) {
        };
        for (int i = 0; i < numberOfEntries; i++) {
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().removalListener(notification -> {
            cache.put(i, Integer.toString(i));
            } else {
            } catch (ExecutionException e) {
                                assertThat(e.getCause(), instanceOf(Exception.class));
        numberOfEntries = randomIntBetween(1000, 10000);
                cache.invalidate(key);
            cache.put(i, Integer.toString(i));
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
            .build();
                            first = random.nextBoolean();
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
import java.util.Iterator;
     * {@link Cache#invalidate(Object)} on such a key parks the caller until the load completes: the
        List<Integer> evictedKeys = new ArrayList<>();
        while (valueIterator.hasNext()) {
                                } else {
        now.set(0);
                }
        assertEquals(0, cache.weight());
            assertEquals(RemovalReason.INVALIDATED, notification.getRemovalReason());
                                    return value != null ? value : 0;
     * {@code unlink()} finds {@code state == NEW}, returns false, and drops the removal notification.
                    barrier.await();
                    expectedEvictions.add(j);
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
        }
                        cache.put(key, Integer.toString(j));
    // those entries
            if (randomBoolean()) {
        // the number of evicted entries should be the number of entries that fit in the excess weight
                            cache.computeIfAbsent(0, k -> Integer.toString(k));
        assertEquals(evictions.get(), cache.stats().getEvictions());
                }
            assertEquals(RemovalReason.EVICTED, notification.getRemovalReason());
                        // release the main test thread to fail the test
            thread.start();
        // wait for all threads to finish
                                return Integer.toString(key);
                    cache.invalidate(i, Integer.toString(i));
            @Override
     * promote its entry until the test thread has finished invalidating it.
     * <p>
                assertEquals(RemovalReason.INVALIDATED, notification.getRemovalReason());
    }
                }
        int numberOfThreads = randomIntBetween(2, 32);
    // map before the value is loaded, so there is a window in which a key is in the segment map but its entry is not
                replacements.add(i);
        releaseLoad.countDown();
            thread.start();
            keys.add(key);
                    invalidated.add(i);
        }, 1, 1, TimeUnit.SECONDS);
            cache.computeIfAbsent(1, k -> null);
                    }
    }
    public void testComputeIfAbsentThrowsExceptionIfLoaderReturnsANullValue() {
 *
                } catch (BrokenBarrierException | InterruptedException e) {
    // expected evictions occurred
                    int value = randomInt();
            final Thread thread = new Thread(() -> {
            .removalListener(notification -> evictions.incrementAndGet())
        }
        assertEquals(weight, cache.weight());
        for (int i = 0; i < numberOfEntries; i++) {
                cache.invalidate(i);
        for (int i = 0; i < numberOfEntries; i++) {
        assertEquals(expected, new HashSet<>(snapshot));
        assertFalse(invalidator.isAlive());
    public void testWeigher() {
        assertBusy(() -> assertEquals(Thread.State.WAITING, invalidator.getState()));
            assertEquals(expectedEvictions.get(i), evictedKeys.get(i));
                count--;
        AtomicLong evictions = new AtomicLong();
            cache.put(i, Integer.toString(i));
    }
    }
        AtomicLong evictions = new AtomicLong();
        }
        assertEquals(numberOfEntries, cache.count());
                assertNull(cache.get(i));
                        try {
                    try {
 * Unless required by applicable law or agreed to in writing,
    }
        }
                } catch (BrokenBarrierException | InterruptedException e) {
                    }
                    barrier.await();
        for (int i = 0; i < evictedKeys.size(); i++) {
                    barrier.await();
            }
     * {@link Cache#keysSnapshot()} contains keys whose load is still in flight, and
            @Override
            .setNumberOfSegments(numberOfSegments)
        assertEquals(expected.size(), snapshot.size());
            remainingKeys.add(key);
                    Random random = new Random(random().nextLong());
            fail("expected ExecutionException");
        }
                invalidated.add(i);
     * invalidation consumer calls {@code future.get()} on the incomplete future with no timeout.
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().build();
                if (randomBoolean()) {
    }
            }
            cache.computeIfAbsent(i, k -> Integer.toString(k) + "-second");
        cache.setExpireAfterAccessNanos(1);
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder()
        loader.start();
        Iterator<String> valueIterator = cache.values().iterator();
                    barrier.await();
                } finally {
        Set<Integer> notifications = new HashSet<>();
        final AtomicBoolean done = new AtomicBoolean(false);
        int count = 0;
            cache.put(i, new Value(Integer.toString(i), 1));
                        }
                    for (int j = 0; j < numberOfEntries; j++) {
    @Before
        assertTrue("the weigher never ran, so the interleaving under test did not happen", invalidatedUnderLruLock.get());
    }
    // randomly replace some entries, increasing the weight by 1 for each replacement, then count that the cache size
            if (rarely()) {
                                assertTrue(flags.compareAndSet(key, false, true));
            cache.put(i, Integer.toString(i) + "-first");
                            }
                            fail("expected exception but got: " + value);
        cache.put(STALL_KEY, "v");
                            try {
import org.opensearch.test.OpenSearchTestCase;
    // A cache segment maps each key to a CompletableFuture, and computeIfAbsent installs that future in the segment
    private static final String STALL_KEY = "stall";
        for (int i = 0; i < numberOfEntries; i++) {
        now.set(1);
        int replaced = 0;
                notifications.add(notification.getKey());
        assertEquals((long) Math.ceil(numberOfEntries / 2.0), evictions.get());
            }
        assertEquals(expected, new HashSet<>(snapshot));
        int iterations = (int) Math.ceil((numberOfEntries - maximumWeight) / (1.0 * maximumWeight));
                            failures.add(e);
                    cache.invalidate(key, key.toString());
        // finish filling the cache
    }
        }
        for (int i = 0; i < numberOfEntries; i++) {
            protected long now() {
            assertEquals(i + "-second", cache.get(i));
        }
    private int numberOfEntries;
                            throw new AssertionError(e);
import java.util.stream.Collectors;
        assertNull(cache.get(IN_FLIGHT_KEY));
        }
        now.set(2);
/*
    public void testWeight() {
    public void testRemoveUsingValuesIterator() {
        for (int i = 0; i < numberOfEntries; i++) {
                    cache.invalidate(i, Integer.toString(i + randomIntBetween(2, 10)));
    public void testInvalidateBlocksOnInFlightLoad() throws Exception {
                assertEquals(expected, new HashSet<>(snapshot));
                }
                            assertNotNull(e.getCause());
                notifications.add(notification.getKey());
        }
    // cache some entries, randomly invalidate some of them, then check that the weight of the cache is correct
        final Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().setMaximumWeight(1000).weigher((k, v) -> 2).build();
                        }
        for (int i = 0; i < expectedRemovals.size(); i++) {
            }
        List<Integer> expectedEvictions = new ArrayList<>();
            .build();
                assertNull(cache.get(i));
        int weight = 0;
        assertEquals(hits, cache.stats().getHits());
 * this work for additional information regarding copyright
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
        cache.refresh();
            count++;
     */
        assertTrue(loadStarted.await(10, TimeUnit.SECONDS));
        for (int i = 0; i < iterations; i++) {
                        for (int i = 0; i < numberOfThreads; i++) {
            .setMaximumWeight(maximumWeight)
                        } else {
                evictedKeys.add(notification.getKey());
        assert !deadlock.get();
                        throw new AssertionError(e);
                cache.computeIfAbsent(i, k -> {
        cache.refresh();
            private String value;
            }
                            second = random.nextBoolean();
                }
                    }
        final CountDownLatch loadStarted = new CountDownLatch(1);
        }
                                });
                        deadlock.set(true);
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
        for (int i = 0; i < expectedEvictions.size(); i++) {
    public void testWithInvalidSegmentNumber() {
            .weigher((k, v) -> weight)
    public void testNotificationOnInvalidateAll() {
        now.set(0);
    public void testComputeIfAbsentAfterExpiration() throws ExecutionException {
            .setNumberOfSegments(numberOfSegments)
                return now.get();
                    throw new AssertionError(e);
        );
import java.lang.management.ThreadMXBean;
            });
            public int hashCode() {
            cache.put(i, Integer.toString(i));
            .removalListener(notification -> {
        assertEquals(numberOfEntries, cache.count());
        for (int i = 0; i < numberOfEntries; i++) {
        assertEquals("the removal listener should have been notified", 1, removals.size());
        return keys;
                                }
                valueIterator.remove();
                        do {
    }
            }
                keys.add(key);
            assertEquals(cache.get(i), Integer.toString(i));
        // everything is setup, release the hounds
            @Override
        cache.refresh();
    // invalidate all cached entries, then check that the cache is empty
        assertEquals(evictions.get(), cache.stats().getEvictions());
    public void testTorture() throws BrokenBarrierException, InterruptedException {
            }
        }
    public void testReplaceRecomputesSize() {
            if (rarely()) {
            }
    // cache some entries in batches of size maximumWeight; for each batch, touch the even entries to affect the
            weight += i;
        Cache<Integer, String> cache = new Cache<Integer, String>(numberOfSegments) {
                    cache.get(j);
        barrier.await();
                    map.put(k, value);
        assertEquals(1L, cache.weight());
     */
            .build();
                    Random random = new Random(randomLong());
            Value(String value, long weight) {
            thread.start();
package org.opensearch.common.cache;
                assertNotNull(cache.get(i));
            })
        }
        }
        barrier.await();
                    // ensure that we detected deadlock on our threads
            cache.computeIfAbsent(IN_FLIGHT_KEY, k -> {
        cache.setExpireAfterAccessNanos(1);
                    // successfully avoided deadlock, release the main thread
            }
                    barrier.await();
            assertThat(e.getCause(), instanceOf(NullPointerException.class));
            assertEquals(RemovalReason.REPLACED, notification.getRemovalReason());
                } catch (BrokenBarrierException | InterruptedException e) {
            @Override
        for (Integer key : cache.keys()) {
                        } catch (ExecutionException e) {
        for (int i = 0; i < numberOfEntries; i++) {
            keys.add(i);
                                    }
import static org.hamcrest.Matchers.empty;
        }
 * the Apache License, Version 2.0 (the "License"); you may
            flags.set(j, false);
        try {
        }
        // start a watchdog service
        Thread loader = new Thread(() -> loadInFlightKey(cache, loadStarted, releaseLoad), "loader");
            Thread thread = new Thread(() -> {
                    } catch (BrokenBarrierException | InterruptedException e) {
                }
 * specific language governing permissions and limitations
            assertEquals(i, (int) evictedKeys.get(i));
                        Integer key = random.nextInt(numberOfEntries);
            assertTrue(keys.contains(i));
        for (int i = 0; i < numberOfEntries; i++) {
    }
        Set<Integer> keys = new HashSet<>();
 * not use this file except in compliance with the License.
            done.set(true);
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
        assertEquals(numberOfEntries - maximumWeight, evictions.get());
                                    } else {
        } finally {
                }
                this.weight = weight;
        cache.invalidateAll();
            Set<Long> ids = threads.stream().map(Thread::threadId).collect(Collectors.toSet());
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
        }
    }
            assertEquals(RemovalReason.EVICTED, notification.getRemovalReason());
    public void testComputeIfAbsentLoadsSuccessfully() {
                                assertNotNull(e.getCause());
            assertEquals(
    public void testCachePollution() throws BrokenBarrierException, InterruptedException {
        });
        List<Integer> snapshot = cache.keysSnapshot();
            for (int j = i * maximumWeight; j < (i + 1) * maximumWeight && j < numberOfEntries - maximumWeight; j++) {
            }
            cache.put(i, Integer.toString(i));
        // wait for all threads to finish
        for (int i = numberOfEntries - maximumWeight; i < numberOfEntries; i++) {
 * You may obtain a copy of the License at
        assertTrue(loadStarted.await(10, TimeUnit.SECONDS));
        scheduler.scheduleAtFixedRate(() -> {
        for (int i = 0; i < numberOfEntries; i++) {
        }
        // cached yet: it is not in the LRU list and is not counted
            .build();
     * which gives the test thread a point where it holds the LRU lock, so the loading thread cannot
        for (int i = 0; i < numberOfEntries; i++) {
        deadlockLatch.await();
        loader.join(10_000);
                            deadlockLatch.countDown();
                    }
        Set<Integer> keys = new HashSet<>();
        super.setUp();
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder()
                        boolean second;
        AtomicBoolean deadlock = new AtomicBoolean();
                    if (ids.contains(deadlockedThread)) {
            }
            assertEquals(map.get(i), cache.get(i));
        invalidator.join(10_000);
        }
        class Key {
        for (int i = numberOfEntries; i < 2 * numberOfEntries; i++) {
        CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
        }
        // IN_FLIGHT_KEY's load is in flight; this put takes the LRU lock and runs the weigher above
        now.set(0);
            @Override
        cache.refresh();
        // the snapshot is a copy: invalidating entries does not affect it
                if (this == o) return true;
                    deadlockLatch.countDown();
                    keys.add(key);
import java.util.concurrent.BrokenBarrierException;
import java.util.Map;
            assertEquals(RemovalReason.INVALIDATED, removalNotifications.get(i).getRemovalReason());
        Cache<Integer, String> cache = new Cache<Integer, String>(numberOfSegments) {
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder()
            }
    // randomly promote some entries, step the clock forward, then check that the promoted entries remain and the
            Thread thread = new Thread(() -> {
        List<Integer> evictedKeys = new ArrayList<>();
 */
                try {
                if (o == null || getClass() != o.getClass()) return false;
import java.util.concurrent.ExecutionException;
        // wait for all threads to be ready
        // batches of size maximumWeight, first the odds in the batch, then the evens in the batch
    // randomly replace some entries, then check that we received replacement notifications for those and only those
                if (j % 2 == 1) {
                try {
        }
                cacheRef.get().invalidate(IN_FLIGHT_KEY);
            invalidated.add(i);
import java.util.HashMap;
        CountDownLatch deadlockLatch = new CountDownLatch(numberOfThreads);
}
            cache.put(i, Integer.toString(i));
                this.value = value;
        }
                return key % 2;
                misses++;
                            assertEquals(e.getCause().getMessage(), "failed to load");
            assertTrue(remainingKeys.contains(i));
        for (Integer key : keys) {
        now.set(2);
            protected long now() {
        int numberOfThreads = randomIntBetween(2, 32);
    public void testCount() {
                                    Integer value = cache.get(new Key(k.key / 2));
                try {
        AtomicLong evictions = new AtomicLong();
        assertEquals("the invalidated key should not be left in the LRU list", List.of(STALL_KEY), lruKeys(cache));
        for (int i = 0; i < entries; i++) {
            .build();
        }
    public void testNotificationOnReplace() {
        }
                        if (first) {
        }
import java.util.concurrent.atomic.AtomicReference;
                }
            });
            if (rarely()) {
 * KIND, either express or implied.  See the License for the
        assertThat(removalNotifications.size(), is(0));
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().setNumberOfSegments(numberOfSegments).build();
            notifications.add(notification.getKey());
            .build();
                return now.get();
            Thread thread = new Thread(() -> {
        }
            cache.invalidate(i);
                return now.get();
        barrier.await();
            .removalListener(notification -> {
        }
        for (int i = 0; i < numberOfEntries; i++) {
    }
                cache.invalidate(i);
public class CacheTests extends OpenSearchTestCase {
        }
        for (int i = 0; i < numberOfEntries; i++) {
 * under the License.
    public void testKeysSnapshotUnderConcurrentPromotion() throws BrokenBarrierException, InterruptedException {
                        try {
        cache.setExpireAfterWriteNanos(1);
                    }
        }
        CopyOnWriteArrayList<ExecutionException> failures = new CopyOnWriteArrayList<>();
        final int entries = randomIntBetween(1000, 5000);
        for (K key : cache.keys()) {
                    barrier.await();
                cache.get(i);
        final String key = randomAlphaOfLengthBetween(2, 32);
            remainingKeys.add(key);
        for (int i = 0; i < numberOfEntries; i++) {
import java.util.HashSet;
                } else {
            thread.start();
            @Override
        }
        for (int i = 0; i < numberOfThreads; i++) {
        Cache<Integer, String> cache = new Cache<Integer, String>(numberOfSegments) {
import java.util.concurrent.atomic.AtomicLong;
            .setNumberOfSegments(numberOfSegments)
        assertEquals(notifications, invalidated);
            .removalListener(removalNotifications::add)
            public boolean equals(Object o) {
    public void testInvalidate() {
                    throw new AssertionError(e);
        assertEquals(notifications, invalidated);
                        barrier.await();
                evictions.incrementAndGet();
            if (keys.contains(i)) {
            Key(int key) {
            }
        for (int i = 0; i < numberOfEntries; i++) {
 *
        }
                            String value = cache.computeIfAbsent(key, k -> { throw new RuntimeException("failed to load"); });
        now.set(2);
    }
    // cache some entries, step the clock forward, cache some more entries, step the clock forward and then check that
import java.util.concurrent.Executors;
        }
        List<K> keys = new ArrayList<>();
        assertEquals(numberOfEntries, cache.count());
import java.util.ArrayList;
            ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().removalListener(notification -> {
        final Cache<Key, Integer> cache = CacheBuilder.<Key, Integer>builder().build();
    // ordering; upon the next caching of entries, the entries from the previous batch will be evicted; we can then
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = 0; i < numberOfEntries; i++) {
    private void loadInFlightKey(Cache<String, String> cache, CountDownLatch loadStarted, CountDownLatch releaseLoad) {
    }
    // entries
                                        return Integer.toString(k);
            throw new AssertionError(e);
        }
            });
                        } catch (ExecutionException e) {
            IllegalArgumentException.class,
import java.util.concurrent.atomic.AtomicReferenceArray;
            if (!deadlock.get() && deadlockedThreads != null) {
    public void setUp() throws Exception {
        // wait for all threads to be ready
 * software distributed under the License is distributed on an
import java.util.concurrent.CountDownLatch;
            } else {
        for (int i = 0; i < numberOfEntries; i++) {
            }
import java.util.concurrent.ScheduledExecutorService;
                        } while (first && second);
            }
        }
    public void testPromotion() {
                        } catch (ExecutionException e) {
import java.util.List;
        for (int i = 0; i < numberOfEntries; i++) {
                Key key1 = (Key) o;
            remainingKeys.add(key);
     * When {@code invalidate(key)} deletes an entry before the thread that loaded it has promoted it,
                if (this == o) return true;
    public void testInvalidateBeforePromoteLeavesUnreclaimableEntry() throws Exception {
            cache.put(i, Integer.toString(i));
        };
        now.set(2);
        for (int i = 0; i < numberOfEntries; i++) {
            });
        assertThrows(
    /**
    public void testNotificationOnInvalidateWithValue() {
                if (randomBoolean()) {
                            cache.invalidate(key);
    }
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder()
            if (STALL_KEY.equals(key) && invalidatedUnderLruLock.compareAndSet(false, true)) {
    }
                            failures.add(e);
                return "v";
        barrier.await();
        assertEquals(weight * (maximumWeight / weight), cache.weight());
                        }
                        try {
                            });
        // assert that the keys were evicted in LRU order
    // yet linked into the LRU list. The two tests below cover what invalidate(key) does with a key in that window.
        assertFalse("deadlock", deadlock.get());
            });
    // cache some entries, randomly invalidate some of them, then check that the number of cached entries is correct
        cache.invalidateAll();
        cache.setRemovalListener(notification -> {
        for (int i = 0; i < numberOfEntries; i++) {
        }
                assertNull(cache.get(i));
                return value.equals(that.value);
            })
 * ownership. Elasticsearch licenses this file to you under
        for (int i = numberOfEntries; i < 2 * numberOfEntries; i++) {
    public void testExpirationAfterAccess() {
        class Value {
            public boolean equals(Object o) {
        final int numberOfThreads = randomIntBetween(2, 32);
            })
        invalidator.join(500);
                    for (int j = 0; j < numberOfEntries; j++) {
        for (Integer key : cache.keys()) {
            .setMaximumWeight(maximumWeight)
            cache.put(i, Integer.toString(i));
    }
        }
        final Cache<String, String> cache = CacheBuilder.<String, String>builder().build();
            }
        } catch (ExecutionException e) {
                loadStarted.countDown();
import java.lang.management.ManagementFactory;
                // can be promoted. invalidate() blocks until the load completes, then reenters the LRU lock.
        for (int i = 0; i < numberOfEntries; i++) {
        assertEquals(expectedRemovals.size(), removalNotifications.size());
    // current entry to the head of the LRU list, keysSnapshot must observe every key that is present for the
        assertEquals((int) Math.ceil((weight - 2) * numberOfEntries / (1.0 * weight)), evictions.get());
        Set<Integer> notifications = new HashSet<>();
                promotedKeys.add(i);
        // wait for either deadlock to be detected or the threads to terminate
        now.set(1);
        int numberOfThreads = randomIntBetween(2, 32);
        final Cache<String, String> cache = CacheBuilder.<String, String>builder().build();
        assertEquals(misses, cache.stats().getMisses());
        final CountDownLatch loadStarted = new CountDownLatch(1);
        Set<Integer> invalidated = new HashSet<>();
            );
    }
                            });
        barrier.await();
            protected long now() {
        }
        Set<Integer> remainingKeys = new HashSet<>();
                cache.put(i, new Value(Integer.toString(i), 2));
        Thread loader = new Thread(() -> loadInFlightKey(cache, loadStarted, releaseLoad), "loader");
                cache.get(key);
    }
            protected long now() {
        barrier.await();
            cache.put(i, Integer.toString(i));
        Cache<Integer, Value> cache = CacheBuilder.<Integer, Value>builder().weigher((k, s) -> s.weight).build();
        // wait for all threads to finish
            () -> CacheBuilder.<Integer, String>builder().setMaximumWeight(1000).setNumberOfSegments(21).build()
            for (int iteration = 0; iteration < 100; iteration++) {
                numberOfEntries - i + (numberOfEntries - maximumWeight) - 1,
            thread.start();
            .setNumberOfSegments(numberOfSegments)
        AtomicLong now = new AtomicLong();
            }
        // wait for all threads to be ready
                List<Integer> snapshot = cache.keysSnapshot();
            if (rarely()) {
                    }
        CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            evictedKeys.add(notification.getKey());
        final Cache<String, String> cache = CacheBuilder.<String, String>builder().weigher((key, value) -> {
        }
        assertEquals(promotedKeys.size(), cache.count());
        assertThat(failures, is(empty()));
        Set<Integer> notifications = new HashSet<>();
                } catch (BrokenBarrierException | InterruptedException e) {
        final AtomicReference<Cache<String, String>> cacheRef = new AtomicReference<>();
            cache.put(i, Integer.toString(i));
        }
            }
        assertEquals(numberOfEntries + replaced, cache.weight());
        }
import java.util.Set;
    }
        }
        now.set(1);
        final CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
    public void testComputeIfAbsentDeadlock() throws BrokenBarrierException, InterruptedException {
    public void testCacheStats() {
        for (int i = 0; i < numberOfThreads; i++) {
            if (rarely()) {
        }
            }
        assertEquals(count, cache.count());
        final List<RemovalNotification<Integer, String>> removalNotifications = new ArrayList<>();
        final Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().build();
        });
        assertEquals(List.of(), lruKeys(cache));
                    // invalidate with incorrect value
                        } catch (final ExecutionException e) {
            notifications.add(notification.getKey());
                        Integer key = random.nextInt(numberOfEntries);
        final AtomicBoolean invalidatedUnderLruLock = new AtomicBoolean();
    // randomly invalidate some cached entries, then check that a lookup for each of those and only those keys is null
                if (j % 2 == 0) {
    }
            .removalListener(notification -> {
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
    public void testCacheEvictions() {
        assertFalse(loader.isAlive());
                        }
import static org.hamcrest.CoreMatchers.instanceOf;
                }
                            cache.get(key);
            try {
                            cache.computeIfAbsent(j, key -> {
            @Override
        }
                                assertEquals(e.getCause().getMessage(), "testCachePollution");
        } catch (ExecutionException e) {
        int maximumWeight = randomIntBetween(1, numberOfEntries);
import java.util.concurrent.CyclicBarrier;
        CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
        now.set(2);
        final List<String> expectedRemovals = new ArrayList<>();
        }
            }
                cache.put(j, Integer.toString(j));
                    while (done.get() == false) {
        int numberOfThreads = randomIntBetween(2, 32);
                throw new AssertionError(e);
    // test that the cache is not corrupted under lots of concurrent modifications, even hitting the same key
                            assertThat(e.getCause(), instanceOf(RuntimeException.class));
            cache.put(i, Integer.toString(i));
        Set<Integer> invalidated = new HashSet<>();
        now.set(0);
        for (int t = 0; t < numberOfReaders; t++) {
                // holding the LRU lock: let the load finish and invalidate IN_FLIGHT_KEY before its entry
        assertTrue("invalidate() should still be blocked on the in-flight load", invalidator.isAlive());
            cache.put(i, Integer.toString(i));
                }
        assertEquals(numberOfEntries, cache.stats().getEvictions());
    public void testInvalidateWithValue() {
            if (rarely()) {
                    throw new AssertionError(e);
                evictions.incrementAndGet();
    // is correct
                        boolean first;
            cache.put(i, Integer.toString(i));
                        try {
                keys.remove(notification.getKey());
        for (int i = 0; i < numberOfEntries; i++) {
            cache.put(i, Integer.toString(i));
        for (int i = 0; i < numberOfEntries; i++) {
    public void testComputeIfAbsentCallsOnce() throws BrokenBarrierException, InterruptedException {
    // here be dragons: this test did catch one subtle bug during development; do not remove lightly
                    throw new AssertionError(e);
            threads.add(thread);
            if (rarely()) {
            }
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
                return key == key1.key;
            if (rarely()) {
        scheduler.shutdown();
            cache.put(i, Integer.toString(i));
import static org.hamcrest.Matchers.is;
                assertEquals(RemovalReason.INVALIDATED, notification.getRemovalReason());
        final Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder()
            long[] deadlockedThreads = mxBean.findDeadlockedThreads();
        final Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().build();
            if (keys.contains(i)) {
    // invalidate all cached entries, then check that we receive invalidate notifications for all entries
    }
        }
        assertEquals("the invalidated key should be gone from the segment map", List.of(STALL_KEY), cache.keysSnapshot());
    }
 */
            })
    // non-promoted entries were removed
                    }
                weight -= i;
                if (o == null || getClass() != o.getClass()) return false;
        for (int i = 0; i < numberOfEntries; i++) {
        }
            thread.start();
        };
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
        assertEquals(invalidated, notifications);
        for (int i = 0; i < numberOfThreads; i++) {
            cache.get(i);
                    Random random = new Random(random().nextLong());
import java.util.concurrent.TimeUnit;
        logger.debug("numberOfEntries: {}", numberOfEntries);
                    // invalidate with incorrect value
                Value that = (Value) o;
                return now.get();
            .setNumberOfSegments(numberOfSegments)
    }
            cache.put(i, Integer.toString(i));
        cache.setExpireAfterAccessNanos(1);
        }
    }
 * SPDX-License-Identifier: Apache-2.0
            return 1L;
                        cache.get(random.nextInt(entries));
    }
                    for (int j = 0; j < numberOfEntries; j++) {
            if (rarely()) {
                    }
    // cache some entries, then randomly lookup keys that do not exist, then check the stats
            private long weight;
import org.opensearch.common.unit.TimeValue;
        AtomicLong now = new AtomicLong();
                    throw new AssertionError(e);
        assertEquals(replacements, notifications);
    }
                try {
     * The loading thread then links the entry into the LRU list even though its key is already gone from
        }
                    }
        // the in-flight key is in the segment map, so keysSnapshot() returns it, even though nothing is
        cache.setExpireAfterAccessNanos(1);
        for (int i = 0; i < numberOfEntries; i++) {
    // for each batch
        for (int i = 0; i < numberOfEntries; i++) {
        long hits = 0;
            cache.put(i, Integer.toString(i));
            });
            "Number of segments for cache should be a power of two up-to 256",
        int numberOfThreads = randomIntBetween(2, 32);
        }
        }
        for (Integer key : cache.keys()) {
            }
            .setExpireAfterAccess(TimeValue.timeValueNanos(1))
                this.key = key;
        }
        }
        barrier.await();
    // Unlike Cache.keys(), whose iterator can silently skip entries when a concurrent cache hit relinks the
/*
        AtomicLong now = new AtomicLong();
        AtomicLong now = new AtomicLong();
        for (Integer key : cache.keys()) {
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
    // randomly invalidate some cached entries, then check that a lookup for each of those and only those keys is null
        }
        Cache<Integer, String> cache = new Cache<Integer, String>(numberOfSegments) {
        long misses = 0;
        for (int i = 0; i < numberOfEntries; i++) {
        for (int i = 0; i < numberOfEntries; i++) {
        loader.start();
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder()
            } else {
        for (int i = 0; i < numberOfThreads; i++) {
        }
                assertEquals(expected.size(), snapshot.size());
 * The OpenSearch Contributors require contributions made to
                return now.get();
        barrier.await();
        assertEquals(expectedEvictions.size(), evictedKeys.size());
    public void testExpirationAfterWrite() {
                }
                    for (int j = 0; j < numberOfEntries; j++) {
    // randomly invalidate some cached entries, then check that we receive invalidate notifications for those and only
        assertEquals(evictions.get(), cache.stats().getEvictions());
 * license agreements. See the NOTICE file distributed with
    private <K, V> List<K> lruKeys(Cache<K, V> cache) {
     * unreachable via {@code get()}, and can no longer be invalidated by key -- so its removal listener
                                        throw new Exception("testCachePollution");
     * The interleaving is forced rather than raced for: the weigher runs inside {@code linkAtHead()},
        // wait for all threads to be ready
     * the segment map, leaving an entry that is counted in {@code count()}/{@code weight()}, is
                try {
            }
        Thread invalidator = new Thread(() -> cache.invalidate(IN_FLIGHT_KEY), "invalidator");
                thread.join();
        CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
        }
        for (int i = 0; i < numberOfEntries; i++) {
        assertEquals(1, cache.count());
                cache.put(i, Integer.toString(i) + Integer.toString(i));
        };
        AtomicLong now = new AtomicLong();
        }
 *
        }).build();
        Set<Integer> invalidated = new HashSet<>();
import java.util.concurrent.atomic.AtomicBoolean;
                    return value;
        // wait for all threads to be ready
        Set<Integer> promotedKeys = new HashSet<>();
        }
    }
        for (int j = 0; j < numberOfEntries; j++) {
                    expectedEvictions.add(j);
                }
        }
                cache.get(missingKey);
    // cache some entries and exceed the maximum weight, then check that the cache has the expected weight and the
        try {
                    Random random = new Random(random().nextLong());
        }
                            } catch (ExecutionException e) {
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().build();
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().weigher((k, v) -> k).build();
        for (int i = 0; i < numberOfEntries; i++) {
        int maximumWeight = 2 * numberOfEntries;
    }
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().build();
        final Set<Integer> expected = new HashSet<>();
        for (int i = numberOfEntries - maximumWeight; i < numberOfEntries; i++) {
                (int) remainingKeys.get(i - (numberOfEntries - maximumWeight))
        loader.join(10_000);
        List<Integer> evictedKeys = new ArrayList<>();
            Thread thread = new Thread(() -> {
            .build();
        final Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().build();
                        } else if (second) {
        }
/*
        for (int i = 0; i < numberOfThreads; i++) {
    /**
            thread.start();
 *     http://www.apache.org/licenses/LICENSE-2.0
                } catch (final BrokenBarrierException | InterruptedException e) {
        cacheRef.set(cache);
        Integer missingKey = 0;
        for (int i = 0; i < numberOfEntries; i++) {
        AtomicReferenceArray flags = new AtomicReferenceArray(numberOfEntries);
        Set<Integer> keys = new HashSet<>();
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder()
    }
            String value = valueIterator.next();
        for (int i = numberOfEntries; i < 2 * numberOfEntries; i++) {
    }
     * never fires and the memory it accounts for is never given back.
            }
        }
        final List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < numberOfEntries; i++) {
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().setNumberOfSegments(numberOfSegments).build();
    }
        final List<RemovalNotification<String, String>> removals = new CopyOnWriteArrayList<>();
        assertEquals(List.of(IN_FLIGHT_KEY), cache.keysSnapshot());
            }
        final int numberOfReaders = randomIntBetween(2, 4);
        // shutdown the watchdog service
        Set<Integer> expected = new HashSet<>();
            evictedKeys.add(notification.getKey());
                hits++;
        }
            private final int key;
                    barrier.await();
        // it only unblocks once the loader finishes, however long that takes
            // track the keys, which will be removed upon eviction (see the RemovalListener)
            .setMaximumWeight(numberOfEntries / 2)
        // invalidate() cannot return while the load is in flight
        assertEquals(numberOfEntries, cache.count());
    public void testExceptionThrownDuringConcurrentComputeIfAbsent() throws BrokenBarrierException, InterruptedException {
        for (int i = 0; i < numberOfEntries; i++) {
        assertEquals(0, cache.count());
            }
import java.util.concurrent.CopyOnWriteArrayList;
                                    if (random.nextBoolean()) {
        for (int i = 0; i < numberOfEntries / 2; i++) {
    public void testInvalidateAll() {
        // cache weight should be the largest multiple of weight less than maximumWeight
 * GitHub history for details.
                                cache.computeIfAbsent(key, k -> {
                releaseLoad.countDown();
            assertTrue(remainingKeys.contains(i));
                return value.hashCode();
        }
 * Licensed to Elasticsearch under one or more contributor
        Set<Integer> replacements = new HashSet<>();
        Set<Integer> notifications = new HashSet<>();
            public int hashCode() {
        }
        // wait for all threads to finish
 */
        assertEquals(500, cache.count());
        Cache<Integer, Integer> cache = CacheBuilder.<Integer, Integer>builder().setNumberOfSegments(numberOfSegments).build();
                            break;
    /** The keys in the LRU list, head first. */
            }
            }
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
        assertThat(failures, is(empty()));
            assertEquals(expectedRemovals.get(i), removalNotifications.get(i).getValue());
