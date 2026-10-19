        assert !deadlock.get();
            }  
                        Key key = new Key(random.nextInt(numberOfEntries));  
                Key key1 = (Key) o;  
        for (int i = 0; i < numberOfEntries; i++) {
                return now.get();
        for (int i = numberOfEntries - maximumWeight; i < numberOfEntries; i++) {  
        }
                if (this == o) return true;
            .removalListener(notification -> {  
            }
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < numberOfEntries; i++) {
    // randomly invalidate some cached entries, then check that a lookup for each of those and only those keys is null  
                for (long deadlockedThread : deadlockedThreads) {
        }
import org.junit.Before;  
        }
        for (int i = 0; i < numberOfEntries; i++) {  
                    }  
        }
                cache.get(missingKey);  
        List<Integer> evictedKeys = new ArrayList<>();  
                cache.invalidate(i);
            }
                            });  
            .setMaximumWeight(numberOfEntries / 2)
            })  
                        } catch (ExecutionException e) {
                return "v";
        for (int i = 0; i < numberOfEntries; i++) {
    }
import java.lang.management.ThreadMXBean;  
    }  
        // invalidate() cannot return while the load is in flight  
        final Cache<Key, Integer> cache = CacheBuilder.<Key, Integer>builder().build();
    // randomly promote some entries, step the clock forward, then check that the promoted entries remain and the  
                cache.get(key);  
                }
                keys.remove(notification.getKey());
            cache.put(i, Integer.toString(i));  
                    barrier.await();
            }
            private long weight;
        }
        for (int i = numberOfEntries - maximumWeight; i < numberOfEntries; i++) {  
        final CountDownLatch releaseLoad = new CountDownLatch(1);  
        assertThrows(
        };
        }
                            first = random.nextBoolean();  
            private final int key;
            if (rarely()) {  
        Cache<Integer, String> cache = new Cache<Integer, String>(numberOfSegments) {
        final Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().setMaximumWeight(1000).weigher((k, v) -> 2).build();
                        }
        now.set(2);  
                assertNull(cache.get(i));
        final Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().build();  
        int numberOfThreads = randomIntBetween(2, 32);
/*  
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
        assertEquals(1, cache.count());
        for (int i = 0; i < numberOfEntries; i++) {
        assertTrue(loadStarted.await(10, TimeUnit.SECONDS));
            })  
            }  
    // here be dragons: this test did catch one subtle bug during development; do not remove lightly
        Set<Integer> remainingKeys = new HashSet<>();
        }
    public void testComputeIfAbsentAfterExpiration() throws ExecutionException {
        for (int i = 0; i < evictedKeys.size(); i++) {
                (int) remainingKeys.get(i - (numberOfEntries - maximumWeight))
                                } else {
        Set<Integer> notifications = new HashSet<>();
        AtomicLong now = new AtomicLong();
    // randomly replace some entries, increasing the weight by 1 for each replacement, then count that the cache size  
            thread.start();  
    }  
                } else {  
    // cache some entries, randomly invalidate some of them, then check that the number of cached entries is correct  
import static org.hamcrest.CoreMatchers.instanceOf;
        AtomicBoolean deadlock = new AtomicBoolean();  
 */  
        logger.debug("numberOfEntries: {}", numberOfEntries);
        }
                loadStarted.countDown();
package org.opensearch.common.cache;
    // entries  
        for (Integer key : cache.keys()) {  
            for (int j = i * maximumWeight; j < (i + 1) * maximumWeight && j < numberOfEntries - maximumWeight; j++) {
        // cache weight should be the largest multiple of weight less than maximumWeight
        // cached yet: it is not in the LRU list and is not counted
                                return Integer.toString(key);
        for (int i = 0; i < numberOfEntries; i++) {
                        Integer key = random.nextInt(numberOfEntries);
            }  
                            fail("expected exception but got: " + value);  
        }
    public void testWeigher() {
        assertEquals(0, cache.count());
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().build();  
        assertEquals(numberOfEntries - maximumWeight, evictions.get());  
                valueIterator.remove();
import java.util.concurrent.Executors;
    // cache some entries, randomly invalidate some of them, then check that the weight of the cache is correct
        assertEquals(numberOfEntries, cache.stats().getEvictions());
                try {
        cache.setRemovalListener(notification -> {
            } else {  
import org.opensearch.test.OpenSearchTestCase;
            }
            cache.put(i, Integer.toString(i));  
                    return value;
                                        throw new Exception("testCachePollution");  
        assertEquals(count, cache.count());  
                                    if (random.nextBoolean()) {  
        }  
        for (int i = 0; i < numberOfEntries; i++) {  
    @Before  
     * {@code unlink()} finds {@code state == NEW}, returns false, and drops the removal notification.
        Cache<Integer, Integer> cache = CacheBuilder.<Integer, Integer>builder().setNumberOfSegments(numberOfSegments).build();
        Set<Integer> remainingKeys = new HashSet<>();
        int numberOfThreads = randomIntBetween(2, 32);  
            if (rarely()) {
        // wait for all threads to be ready  
import java.util.concurrent.atomic.AtomicReference;
        AtomicLong evictions = new AtomicLong();
            cache.put(i, Integer.toString(i));
            keys.add(key);
        }  
                this.key = key;
                    }
                        }
        }
                        }
     * {@link Cache#invalidate(Object)} on such a key parks the caller until the load completes: the  
                return now.get();
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
        cache.setExpireAfterAccessNanos(1);
            threads.add(thread);  
            cache.put(i, Integer.toString(i));
        }
            Thread thread = new Thread(() -> {
                                    return 0;
        }
    }
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);  
                            assertNotNull(e.getCause());
            @Override  
            assertEquals(RemovalReason.INVALIDATED, notification.getRemovalReason());  
        try {
        }
                this.value = value;
        assertEquals(expectedRemovals.size(), removalNotifications.size());
                try {
            thread.start();  
        final CyclicBarrier barrier = new CyclicBarrier(1 + numberOfReaders);
        final CountDownLatch releaseLoad = new CountDownLatch(1);
                    if (ids.contains(deadlockedThread)) {  
            assertEquals(
            cache.put(i, Integer.toString(i));
            @Override
                                    return value != null ? value : 0;
                }
                        cache.put(key, Integer.toString(j));
            cache.put(i, Integer.toString(i));
    }
            cache.get(i);
            } catch (ExecutionException e) {
    // cache some entries and exceed the maximum weight, then check that the cache has the expected weight and the  
                cache.get(i);
        loader.join(10_000);
 * ownership. Elasticsearch licenses this file to you under  
                        Integer key = random.nextInt(numberOfEntries);
        for (Integer key : cache.keys()) {  
                    barrier.await();
        cache.setExpireAfterAccessNanos(1);
                evictedKeys.add(notification.getKey());
        assertTrue(loadStarted.await(10, TimeUnit.SECONDS));
                }  
        Set<Integer> keys = new HashSet<>();
            if (keys.contains(i)) {
        Set<Integer> promotedKeys = new HashSet<>();
        for (int i = 0; i < numberOfEntries; i++) {  
    public void testDependentKeyDeadlock() throws BrokenBarrierException, InterruptedException {
        }
            }  
                    deadlockLatch.countDown();
            }  
            }
        for (int i = 0; i < numberOfEntries; i++) {  
 * You may obtain a copy of the License at  
        invalidator.join(500);
        now.set(0);  
        final Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder()
        } catch (ExecutionException e) {  
        }
    public void testKeysSnapshotUnderConcurrentPromotion() throws BrokenBarrierException, InterruptedException {
        assertEquals(numberOfEntries, cache.count());
            .build();
                    barrier.await();  
        final Cache<String, String> cache = CacheBuilder.<String, String>builder().weigher((key, value) -> {
                            String value = cache.computeIfAbsent(key, k -> { throw new RuntimeException("failed to load"); });
    }
        // finish filling the cache
                } catch (BrokenBarrierException | InterruptedException e) {
        Cache<Integer, String> cache = new Cache<Integer, String>(numberOfSegments) {
        // wait for all threads to be ready  
        }
        }
            }
        cache.refresh();
        barrier.await();
        cache.invalidateAll();  
                notifications.add(notification.getKey());
     * invalidation consumer calls {@code future.get()} on the incomplete future with no timeout.
 * GitHub history for details.
        cacheRef.set(cache);
            thread.start();  
        }  
        return keys;
        }
        for (Integer key : cache.keys()) {
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().build();
    }
import java.util.concurrent.atomic.AtomicLong;  
import java.util.HashMap;
                assertNotNull(cache.get(i));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
    private void loadInFlightKey(Cache<String, String> cache, CountDownLatch loadStarted, CountDownLatch releaseLoad) {
                    }  
                                if (k.key == 0) {  
        Set<Integer> invalidated = new HashSet<>();  
                cacheRef.get().invalidate(IN_FLIGHT_KEY);  
            .setNumberOfSegments(numberOfSegments)
            .setNumberOfSegments(numberOfSegments)  
            if (keys.contains(i)) {  
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder()  
        cache.refresh();
    // for each batch  
        assertEquals("the invalidated key should not be left in the LRU list", List.of(STALL_KEY), lruKeys(cache));  
            cache.computeIfAbsent(IN_FLIGHT_KEY, k -> {
            String value = valueIterator.next();  
        final CountDownLatch loadStarted = new CountDownLatch(1);  
            }
        for (int i = 0; i < numberOfThreads; i++) {  
 *  
     * never fires and the memory it accounts for is never given back.  
        }
            .removalListener(notification -> {
    // randomly invalidate some cached entries, then check that we receive invalidate notifications for those and only
                    for (int j = 0; j < numberOfEntries; j++) {
import java.util.HashSet;  
    }
    }  
        // wait for all threads to finish
                            throw new AssertionError(e);
        final List<Thread> threads = new ArrayList<>();
            for (int j = i * maximumWeight; j < (i + 1) * maximumWeight && j < numberOfEntries - maximumWeight; j++) {
                expectedRemovals.add(value);  
            @Override  
        assertThat(failures, is(empty()));
        assertEquals(numberOfEntries, cache.count());
        assertEquals(expected, new HashSet<>(snapshot));
                    throw new AssertionError(e);
        } catch (ExecutionException e) {  
import java.util.Random;
        }
                    barrier.await();
    public void testComputeIfAbsentLoadsSuccessfully() {
                        } while (first && second);
            if (rarely()) {  
    /**
            try {
        assertFalse("deadlock", deadlock.get());
        barrier.await();
        // wait for all threads to finish
        assertEquals(notifications, invalidated);  
 * license agreements. See the NOTICE file distributed with
        for (int i = numberOfEntries; i < 2 * numberOfEntries; i++) {
        for (int i = 0; i < numberOfThreads; i++) {
                        }  
                assertNotNull(cache.get(i));
            cache.put(i, Integer.toString(i));
        for (int i = 0; i < numberOfEntries; i++) {
            protected long now() {
            cache.put(i, Integer.toString(i));
        final List<RemovalNotification<Integer, String>> removalNotifications = new ArrayList<>();
        Cache<Integer, Value> cache = CacheBuilder.<Integer, Value>builder().weigher((k, s) -> s.weight).build();  
                        for (int i = 0; i < numberOfThreads; i++) {  
     * unreachable via {@code get()}, and can no longer be invalidated by key -- so its removal listener
                            failures.add(e);
        );  
    }
    public void testExpirationAfterAccess() {
                            } catch (ExecutionException e) {  
import java.util.Map;  
 * software distributed under the License is distributed on an
    }
                            assertThat(e.getCause(), instanceOf(RuntimeException.class));  
                        try {
            cache.put(i, Integer.toString(i));
                numberOfEntries - i + (numberOfEntries - maximumWeight) - 1,  
            threads.add(thread);
        }  
    public void testComputeIfAbsentCallsOnce() throws BrokenBarrierException, InterruptedException {
                thread.join();
                releaseLoad.countDown();
            .build();
        }  
                evictions.incrementAndGet();
            .setMaximumWeight(maximumWeight)
        final Cache<String, String> cache = CacheBuilder.<String, String>builder().build();  
        }
            cache.put(i, Integer.toString(i));
    }
        CopyOnWriteArrayList<ExecutionException> failures = new CopyOnWriteArrayList<>();  
            assertFalse(keys.contains(expectedEvictions.get(i)));  
                try {
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
            for (int iteration = 0; iteration < 100; iteration++) {  
        }
            });
            }  
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);  
     * the segment map, leaving an entry that is counted in {@code count()}/{@code weight()}, is
    }  
            if (rarely()) {
        };
            assertEquals(i, (int) evictedKeys.get(i));
        for (int i = 0; i < numberOfEntries; i++) {
        final Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().build();
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().removalListener(notification -> {
            invalidated.add(i);  
            thread.start();
            assertEquals(RemovalReason.INVALIDATED, removalNotifications.get(i).getRemovalReason());
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().setNumberOfSegments(numberOfSegments).build();  
        final Cache<String, String> cache = CacheBuilder.<String, String>builder().build();
        now.set(0);  
 */
            notifications.add(notification.getKey());
        final AtomicBoolean done = new AtomicBoolean(false);  
        for (int i = 0; i < numberOfEntries; i++) {  
        // shutdown the watchdog service  
                }  
            ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
     * <p>
        now.set(0);
    public void testPromotion() {
        }  
            });
            .build();  
        assertFalse(invalidator.isAlive());  
        }
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
            assertEquals(RemovalReason.EVICTED, notification.getRemovalReason());  
        while (valueIterator.hasNext()) {
            for (Thread thread : threads) {
                            failures.add(e);
            }  
        final int entries = randomIntBetween(1000, 5000);
            protected long now() {
                cache.invalidate(i);  
            }
    // is correct
        // wait for all threads to be ready
        now.set(2);
                Value that = (Value) o;
        Set<Integer> notifications = new HashSet<>();
        cache.setExpireAfterAccessNanos(1);
    // Unlike Cache.keys(), whose iterator can silently skip entries when a concurrent cache hit relinks the
import org.opensearch.common.unit.TimeValue;
                    throw new AssertionError(e);  
        for (int i = 0; i < numberOfEntries; i++) {  
                if (this == o) return true;  
    // map before the value is loaded, so there is a window in which a key is in the segment map but its entry is not
        for (int i = 0; i < numberOfEntries; i++) {
import java.util.concurrent.atomic.AtomicBoolean;
            })  
            cache.put(i, Integer.toString(i));
                invalidated.add(i);  
                evictions.incrementAndGet();
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);  
        }
                    }
        assertEquals(0, cache.count());
        // cache entries up to numberOfEntries - maximumWeight; all of these entries will ultimately be evicted in
            Thread thread = new Thread(() -> {
        loader.join(10_000);  
                weight -= i;
            if (STALL_KEY.equals(key) && invalidatedUnderLruLock.compareAndSet(false, true)) {
        final AtomicReference<Cache<String, String>> cacheRef = new AtomicReference<>();
        int numberOfThreads = randomIntBetween(2, 32);  
                } catch (BrokenBarrierException | InterruptedException e) {
    }
        CountDownLatch deadlockLatch = new CountDownLatch(numberOfThreads);  
    // those entries  
            assertEquals(i + "-second", cache.get(i));  
 * not use this file except in compliance with the License.
        assertEquals(numberOfEntries, cache.weight());
                        break;  
    }
            cache.put(i, Integer.toString(i));
            thread.start();  
        for (int i = 0; i < numberOfThreads; i++) {
        final Set<Integer> expected = new HashSet<>();
     * promote its entry until the test thread has finished invalidating it.
                        barrier.await();  
        releaseLoad.countDown();  
        AtomicLong evictions = new AtomicLong();  
        long misses = 0;  
    // cache some entries in batches of size maximumWeight; for each batch, touch the even entries to affect the  
            }
import static org.hamcrest.Matchers.is;
        assertNull(cache.get(IN_FLIGHT_KEY));
        assertEquals("the invalidated key should be gone from the segment map", List.of(STALL_KEY), cache.keysSnapshot());
            .setNumberOfSegments(numberOfSegments)
                    expectedEvictions.add(j);
        int weight = randomIntBetween(2, 10);
        invalidator.join(10_000);
                if (randomBoolean()) {  
            public int hashCode() {
        barrier.await();
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().setNumberOfSegments(numberOfSegments).build();  
        }
        Iterator<String> valueIterator = cache.values().iterator();
        }
 */  
                        boolean first;  
                                assertThat(e.getCause(), instanceOf(Exception.class));
                        } catch (ExecutionException e) {
                        } else if (second) {
            assertEquals(map.get(i), cache.get(i));  
        now.set(1);
                    barrier.await();
        AtomicLong now = new AtomicLong();  
                            second = random.nextBoolean();
        CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);  
                    }
        Set<Integer> invalidated = new HashSet<>();
        long hits = 0;
        }  
        assertTrue("invalidate() should still be blocked on the in-flight load", invalidator.isAlive());  
        // wait for either deadlock to be detected or the threads to terminate  
        assertEquals(weight * (maximumWeight / weight), cache.weight());
        cache.refresh();  
        }
        CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
        final int numberOfThreads = randomIntBetween(2, 32);
            });
                    expectedEvictions.add(j);
                throw new AssertionError(e);
                                cache.computeIfAbsent(key, k -> {
                    barrier.await();
            .removalListener(notification -> {  
        }
            assertNull(cache.get(i));
    /** The keys in the LRU list, head first. */
            private String value;
                replacements.add(i);
            }  
            if (!deadlock.get() && deadlockedThreads != null) {  
            Thread thread = new Thread(() -> {  
            thread.start();
                        }
    // yet linked into the LRU list. The two tests below cover what invalidate(key) does with a key in that window.
        for (int i = 0; i < numberOfEntries; i++) {  
        }
        }  
                }
        barrier.await();
 * this work for additional information regarding copyright
                    try {
            cache.put(i, Integer.toString(i));  
        for (int i = 0; i < expectedEvictions.size(); i++) {
        barrier.await();
                        }
                try {  
            }
     */
        assertEquals(1L, cache.weight());
        } finally {
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
        for (int i = 0; i < numberOfEntries; i++) {
                            break;  
        for (int i = 0; i < expectedRemovals.size(); i++) {
                }
    public void testKeysSnapshotContainsAllKeys() {
    }  
                } else {  
            if (rarely()) {
        }
        Set<Integer> keys = new HashSet<>();  
        // batches of size maximumWeight, first the odds in the batch, then the evens in the batch  
        assertEquals(expected.size(), snapshot.size());
                    }  
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().weigher((k, v) -> k).build();  
    // whole duration of the call, regardless of concurrent reads promoting entries.
import java.util.concurrent.atomic.AtomicReferenceArray;
            expected.add(i);
    public void testWeight() {
    public void testReplaceRecomputesSize() {
        List<Integer> remainingKeys = new ArrayList<>();
 *
            } else {
        Cache<Integer, String> cache = new Cache<Integer, String>(numberOfSegments) {  
        try {  
        final List<RemovalNotification<String, String>> removals = new CopyOnWriteArrayList<>();
        }  
            fail("expected ExecutionException");
            .setNumberOfSegments(numberOfSegments)
            () -> CacheBuilder.<Integer, String>builder().setMaximumWeight(1000).setNumberOfSegments(21).build()
                List<Integer> snapshot = cache.keysSnapshot();
    private int numberOfEntries;
        for (int t = 0; t < numberOfReaders; t++) {  
        }  
        Thread invalidator = new Thread(() -> cache.invalidate(IN_FLIGHT_KEY), "invalidator");  
        Set<Integer> notifications = new HashSet<>();  
    }
        }
        for (int i = 0; i < numberOfEntries; i++) {
        for (int i = 0; i < numberOfEntries; i++) {  
                }
                    for (int j = 0; j < numberOfEntries; j++) {  
                // can be promoted. invalidate() blocks until the load completes, then reenters the LRU lock.
import java.util.concurrent.TimeUnit;
            Key(int key) {  
    }
        cache.setExpireAfterAccessNanos(1);
        }, 1, 1, TimeUnit.SECONDS);
                    throw new AssertionError(e);  
            cache.put(i, Integer.toString(i));
        barrier.await();  
        assertBusy(() -> assertEquals(Thread.State.WAITING, invalidator.getState()));
    public void testExpirationAfterWrite() {  
                cache.invalidate(i);  
                                    }
    // ordering; upon the next caching of entries, the entries from the previous batch will be evicted; we can then
        now.set(2);
        for (int i = 0; i < numberOfEntries; i++) {
                            break;  
     * The interleaving is forced rather than raced for: the weigher runs inside {@code linkAtHead()},
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
                if (randomBoolean()) {  
                releaseLoad.await();  
            }  
            }
            .removalListener(notification -> evictions.incrementAndGet())
    }  
        }
        int iterations = (int) Math.ceil((numberOfEntries - maximumWeight) / (1.0 * maximumWeight));
        for (int i = 0; i < numberOfEntries; i++) {
    // the first batch of cached entries expired and were removed
            );
                return now.get();
            count++;  
    }  
        cache.setExpireAfterWriteNanos(1);  
 *
        Map<Integer, Integer> map = new HashMap<>();
        }).build();  
import java.util.ArrayList;
        }  
            Set<Long> ids = threads.stream().map(Thread::threadId).collect(Collectors.toSet());  
                count--;
                    barrier.await();  
                notifications.add(notification.getKey());  
                });  
        }
                        cache.get(random.nextInt(entries));  
        for (int i = 0; i < numberOfEntries; i++) {  
        // the number of evicted entries should be the number of entries that fit in the excess weight
                    barrier.await();
                }
                    Random random = new Random(randomLong());
            } else {
    public void testWithInvalidSegmentNumber() {
        loader.start();  
    }  
            flags.set(j, false);  
        List<Integer> expectedEvictions = new ArrayList<>();
        now.set(0);  
    }
                    int value = randomInt();  
            assertThat(e.getCause(), instanceOf(NullPointerException.class));
            .setNumberOfSegments(numberOfSegments)  
        for (int i = 0; i < numberOfEntries; i++) {
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);  
        }
            assertEquals(i, (int) evictedKeys.get(i));  
                            }
                            try {
                        try {
        assertEquals(List.of(IN_FLIGHT_KEY), cache.keysSnapshot());
            }  
    private <K, V> List<K> lruKeys(Cache<K, V> cache) {  
            throw new AssertionError(e);
        for (int i = 0; i < numberOfEntries; i++) {  
    }
                                assertTrue(flags.compareAndSet(key, false, true));
            .build();
    // non-promoted entries were removed
            public boolean equals(Object o) {
                    cache.invalidate(key, Integer.toString(key + randomIntBetween(2, 10)));
        for (int i = 0; i < numberOfEntries; i++) {  
        Set<Integer> notifications = new HashSet<>();
            IllegalArgumentException.class,
            assertEquals(expectedEvictions.get(i), evictedKeys.get(i));
        for (int i = 0; i < numberOfEntries; i++) {
            @Override  
            });
                        if (first) {  
import java.util.Set;
            --missingKey;  
                } catch (BrokenBarrierException | InterruptedException e) {
    }
    // A cache segment maps each key to a CompletableFuture, and computeIfAbsent installs that future in the segment  
    // cache some entries, step the clock forward, cache some more entries, step the clock forward and then check that  
        for (int i = 0; i < numberOfEntries; i++) {  
    public void testInvalidateAll() {
        // start a watchdog service  
                if (j % 2 == 1) {  
        Thread loader = new Thread(() -> loadInFlightKey(cache, loadStarted, releaseLoad), "loader");
    }  
    public void testInvalidateWithValue() {
        assertEquals(numberOfEntries + replaced, cache.weight());
                // holding the LRU lock: let the load finish and invalidate IN_FLIGHT_KEY before its entry  
        for (int i = 0; i < numberOfEntries; i++) {  
                    }
                } catch (BrokenBarrierException | InterruptedException e) {  
                }
        CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);  
                                assertEquals(e.getCause().getMessage(), "testCachePollution");  
        assertEquals(evictions.get(), cache.stats().getEvictions());
        final CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder()
        assertEquals(weight, cache.weight());  
            if (rarely()) {
 * specific language governing permissions and limitations
                assertEquals(expected, new HashSet<>(snapshot));  
import java.util.concurrent.BrokenBarrierException;  
            cache.put(i, Integer.toString(i) + "-first");
    public void testInvalidateBeforePromoteLeavesUnreclaimableEntry() throws Exception {  
            remainingKeys.add(key);
                return key % 2;
                            });  
            cache.put(i, new Value(Integer.toString(i), 1));
        assertEquals(500, cache.count());  
        Set<Integer> keys = new HashSet<>();
        for (int i = 0; i < numberOfEntries; i++) {
    public void testCacheEvictions() {
        }
        // the snapshot is a copy: invalidating entries does not affect it
    // randomly replace some entries, then check that we received replacement notifications for those and only those
                    Random random = new Random(random().nextLong());
        for (int i = 0; i < numberOfEntries; i++) {
        int maximumWeight = randomIntBetween(1, numberOfEntries);  
        assertEquals(numberOfEntries, cache.count());  
                                assertNotNull(e.getCause());
 * The OpenSearch Contributors require contributions made to  
     * {@link Cache#keysSnapshot()} contains keys whose load is still in flight, and
                        try {
        }  
import java.util.concurrent.ScheduledExecutorService;  
        for (Integer key : cache.keys()) {
 * Licensed to Elasticsearch under one or more contributor  
        barrier.await();  
        }
                        try {
            if (randomBoolean()) {
        };  
            protected long now() {
                    throw new AssertionError(e);  
    public void testComputeIfAbsentThrowsExceptionIfLoaderReturnsANullValue() {
                    // ensure that we detected deadlock on our threads
                misses++;
        for (int i = numberOfEntries; i < 2 * numberOfEntries; i++) {
            protected long now() {
            });
            .removalListener(notification -> {  
        super.setUp();
/*
        assertEquals(IN_FLIGHT_KEY, removals.get(0).getKey());
                return key == key1.key;
        barrier.await();
        for (int i = 0; i < numberOfEntries; i++) {  
        // wait for all threads to finish  
        for (int i = 0; i < numberOfThreads; i++) {
        // it only unblocks once the loader finishes, however long that takes
        barrier.await();  
        cache.invalidateAll();
        }
                try {
            .build();
        now.set(2);
    public void testInvalidateBlocksOnInFlightLoad() throws Exception {  
    }  
            });
                            cache.computeIfAbsent(j, key -> {  
 * the Apache License, Version 2.0 (the "License"); you may
        int numberOfThreads = randomIntBetween(2, 32);  
    }
    public void setUp() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
            if (rarely()) {
            }
    public void testTorture() throws BrokenBarrierException, InterruptedException {
            weight += i;  
            evictedKeys.add(notification.getKey());  
            }  
        for (int j = 0; j < numberOfEntries; j++) {
            cache.put(i, Integer.toString(i));
import java.util.concurrent.CountDownLatch;
    // invalidate all cached entries, then check that the cache is empty  
            Thread thread = new Thread(() -> {
                        do {
        assertEquals(RemovalReason.INVALIDATED, removals.get(0).getRemovalReason());
    public void testNotificationOnInvalidateWithValue() {
        final List<String> expectedRemovals = new ArrayList<>();  
        }
                    for (int j = 0; j < numberOfEntries; j++) {
        for (int i = 0; i < evictedKeys.size(); i++) {
        }  
        assertEquals(misses, cache.stats().getMisses());
            });
            .build();
            thread.start();
            .setMaximumWeight(numberOfEntries)  
        // the in-flight key is in the segment map, so keysSnapshot() returns it, even though nothing is  
import java.util.List;
                        deadlock.set(true);
                    throw new AssertionError(e);
    // test that the cache is not corrupted under lots of concurrent modifications, even hitting the same key  
                            cache.get(key);
        class Value {  
            cache.put(i, Integer.toString(i));
                cache.invalidate(key);
        barrier.await();
        for (int i = 0; i < numberOfEntries; i++) {
            @Override
    }
        });
        }
        class Key {  
            }
        for (int i = 0; i < numberOfEntries / 2; i++) {
                if (o == null || getClass() != o.getClass()) return false;
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);  
        AtomicReferenceArray flags = new AtomicReferenceArray(numberOfEntries);
        };
                    for (int j = 0; j < numberOfEntries; j++) {
        assertFalse(loader.isAlive());
}
    public void testCount() {
        final int numberOfReaders = randomIntBetween(2, 4);
    public void testNotificationOnInvalidate() {
    public void testRemoveUsingValuesIterator() {  
        scheduler.scheduleAtFixedRate(() -> {
        now.set(1);  
        for (int i = 0; i < numberOfEntries; i++) {  
        int numberOfThreads = randomIntBetween(2, 32);
        }
        cache.put(STALL_KEY, "v");
            cache.computeIfAbsent(1, k -> null);
        CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
        for (int i = numberOfEntries; i < 2 * numberOfEntries; i++) {  
public class CacheTests extends OpenSearchTestCase {  
        for (Integer key : keys) {
                cache.put(j, Integer.toString(j));
                            cache.invalidate(key);  
            notifications.add(notification.getKey());
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().build();
        CopyOnWriteArrayList<ExecutionException> failures = new CopyOnWriteArrayList<>();  
        AtomicLong now = new AtomicLong();
    /**  
                        } else {
        List<K> keys = new ArrayList<>();
        final CountDownLatch loadStarted = new CountDownLatch(1);
    }
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);  
import java.util.concurrent.ExecutionException;
import static org.hamcrest.Matchers.empty;  
                                });
    public void testCacheStats() {
            Thread thread = new Thread(() -> {  
        Thread loader = new Thread(() -> loadInFlightKey(cache, loadStarted, releaseLoad), "loader");  
        };
        for (K key : cache.keys()) {
                replaced++;  
            .removalListener(removalNotifications::add)
        assertEquals(notifications, invalidated);  
    public void testCachePollution() throws BrokenBarrierException, InterruptedException {
        assertEquals(promotedKeys.size(), cache.count());
import java.lang.management.ManagementFactory;
        assertEquals((long) Math.ceil(numberOfEntries / 2.0), evictions.get());
        assertEquals(evictions.get(), cache.stats().getEvictions());
        Cache<Integer, String> cache = new Cache<Integer, String>(numberOfSegments) {
    // invalidate all cached entries, then check that we receive invalidate notifications for all entries
                            assertEquals(e.getCause().getMessage(), "failed to load");
                cache.computeIfAbsent(i, k -> {
                        // release the main test thread to fail the test
        }
        Set<Integer> invalidated = new HashSet<>();  
            }
            .setNumberOfSegments(numberOfSegments)  
        }).build();
 *     http://www.apache.org/licenses/LICENSE-2.0
    // current entry to the head of the LRU list, keysSnapshot must observe every key that is present for the  
            }
            }
        try {  
                assertEquals(RemovalReason.INVALIDATED, notification.getRemovalReason());
                    // invalidate with incorrect value
                    for (int j = 0; j < numberOfEntries; j++) {  
        for (int i = 0; i < numberOfEntries; i++) {
            // track the keys, which will be removed upon eviction (see the RemovalListener)
            assertTrue(keys.contains(i));
        assertEquals(0, cache.weight());
            }
        }  
                    Random random = new Random(random().nextLong());  
     * When {@code invalidate(key)} deletes an entry before the thread that loaded it has promoted it,
                cache.put(i, Integer.toString(i) + Integer.toString(i));
    private static final String IN_FLIGHT_KEY = "in_flight";
        final String key = randomAlphaOfLengthBetween(2, 32);
                }  
        Set<Integer> expected = new HashSet<>();
        CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
    // cache some entries, then randomly lookup keys that do not exist, then check the stats
            cache.put(i, Integer.toString(i));  
            cache.invalidate(i);  
                    throw new AssertionError(e);  
            })
            Value(String value, long weight) {
                    } catch (BrokenBarrierException | InterruptedException e) {
                if (j % 2 == 0) {
                try {
            cache.computeIfAbsent(i, k -> Integer.toString(k) + "-second");  
        Set<Integer> keys = new HashSet<>();
    }  
            keys.add(i);
        assertTrue("the weigher never ran, so the interleaving under test did not happen", invalidatedUnderLruLock.get());
        int maximumWeight = 2 * numberOfEntries;
            long[] deadlockedThreads = mxBean.findDeadlockedThreads();
            cache.put(i, Integer.toString(i));
        loader.start();
                assertNull(cache.get(i));
            } else {  
        invalidator.start();
            .weigher((k, v) -> weight)
 * Unless required by applicable law or agreed to in writing,
        // wait for all threads to be ready  
        List<Integer> evictedKeys = new ArrayList<>();
        assertEquals(expectedEvictions.size(), evictedKeys.size());
        assertEquals(replacements, notifications);
 * KIND, either express or implied.  See the License for the
        }
        cache.setRemovalListener(notification -> {
        }
                this.weight = weight;  
            Thread thread = new Thread(() -> {  
        // assert that the keys were evicted in LRU order  
            done.set(true);  
            @Override  
            }
import java.util.concurrent.CopyOnWriteArrayList;
                } catch (BrokenBarrierException | InterruptedException e) {
        assertEquals((int) Math.ceil((weight - 2) * numberOfEntries / (1.0 * weight)), evictions.get());
        barrier.await();  
                        boolean second;
            });  
        final Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().build();
        // everything is setup, release the hounds  
        }  
 * under the License.  
        for (Integer key : cache.keys()) {
                hits++;
    public void testInvalidate() {
        final AtomicBoolean invalidatedUnderLruLock = new AtomicBoolean();
    }
            cache.put(i, Integer.toString(i));
        for (int i = numberOfEntries; i < 2 * numberOfEntries; i++) {
    }  
    // expected evictions occurred
                    cache.get(j);  
                } catch (final BrokenBarrierException | InterruptedException e) {
                assertEquals(expected.size(), snapshot.size());
            .build();
            @Override
                                }
            assertEquals(RemovalReason.EVICTED, notification.getRemovalReason());
    public void testNotificationOnReplace() {
        List<Integer> snapshot = cache.keysSnapshot();  
        assertEquals(invalidated, notifications);  
    }  
        AtomicLong evictions = new AtomicLong();
                promotedKeys.add(i);  
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder()
import java.util.concurrent.CyclicBarrier;  
        for (int i = 0; i < numberOfEntries; i++) {
        // IN_FLIGHT_KEY's load is in flight; this put takes the LRU lock and runs the weigher above
            if (rarely()) {
                    }
            assertEquals(RemovalReason.REPLACED, notification.getRemovalReason());
        }
        // wait for all threads to finish
            if (rarely()) {
        assertEquals(List.of(), lruKeys(cache));  
        assertEquals("the removal listener should have been notified", 1, removals.size());  
            "Number of segments for cache should be a power of two up-to 256",  
        }  
            @Override
            expected.add(i);
                    barrier.await();
        }
                            cache.computeIfAbsent(0, k -> Integer.toString(k));
            cache.put(i, Integer.toString(i));
        barrier.await();
                    }  
            public int hashCode() {
    }
            if (rarely()) {
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);  
        now.set(1);
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().removalListener(notification -> {  
        Set<Integer> replacements = new HashSet<>();
        final Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder().build();  
    public void testComputeIfAbsentDeadlock() throws BrokenBarrierException, InterruptedException {
        }).removalListener(removals::add).build();  
            .setExpireAfterAccess(TimeValue.timeValueNanos(1))
    // check that the evicted entries were evicted in LRU order (first the odds in a batch, then the evens in a batch)
            keys.add(key);  
            remainingKeys.add(key);  
                return now.get();
     * The loading thread then links the entry into the LRU list even though its key is already gone from  
            assertTrue(remainingKeys.contains(i));
        }  
                } finally {  
    }
        AtomicLong now = new AtomicLong();
                }
        now.set(2);  
            assertTrue(remainingKeys.contains(i));  
                    barrier.await();  
        assertEquals(hits, cache.stats().getHits());  
                try {
                    // successfully avoided deadlock, release the main thread
            assertEquals(expectedRemovals.get(i), removalNotifications.get(i).getValue());  
        assertEquals(evictions.get(), cache.stats().getEvictions());  
        List<Integer> evictedKeys = new ArrayList<>();
    public void testNotificationOnInvalidateAll() {  
            evictedKeys.add(notification.getKey());
        assertEquals(numberOfEntries, cache.count());
            }
            @Override  
                return value.hashCode();  
        Cache<Integer, String> cache = new Cache<Integer, String>(numberOfSegments) {
            }
        // wait for all threads to be ready
    // randomly invalidate some cached entries, then check that a lookup for each of those and only those keys is null  
                            cache.computeIfAbsent(key, k -> {
        }
/*  
        }
        numberOfEntries = randomIntBetween(1000, 10000);  
     */
                    keys.add(key);
        int replaced = 0;  
                    cache.invalidate(key, key.toString());
            if (promotedKeys.contains(i)) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                    map.put(k, value);
        for (int i = 0; i < iterations; i++) {  
                                    Integer value = cache.get(new Key(k.key / 2));  
        });
     * which gives the test thread a point where it holds the LRU lock, so the loading thread cannot  
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);  
        assertThat(removalNotifications.size(), is(0));
            protected long now() {  
                    Random random = new Random(random().nextLong());
        AtomicLong now = new AtomicLong();
        scheduler.shutdown();
import java.util.Iterator;
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder()
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder()
        int weight = 0;
                        } catch (ExecutionException e) {
            public boolean equals(Object o) {
                assertNull(cache.get(i));
                return now.get();  
    public void testExceptionThrownDuringConcurrentComputeIfAbsent() throws BrokenBarrierException, InterruptedException {
                assertNotNull(cache.get(i));  
                }  
        for (int i = 0; i < entries; i++) {  
        Integer missingKey = 0;
        assertThat(failures, is(empty()));  
        for (int i = 0; i < numberOfThreads; i++) {
        deadlockLatch.await();
                                        return Integer.toString(k);
        for (int i = 0; i < numberOfEntries; i++) {
        // wait for all threads to finish
                    invalidated.add(i);
        now.set(0);
            final Thread thread = new Thread(() -> {  
            .setMaximumWeight(maximumWeight)
    public void testSimpleExpireAfterAccess() {
        }
                    while (done.get() == false) {
        int numberOfSegments = randomFrom(1, 2, 4, 8, 16, 64, 128, 256);
                return value.equals(that.value);
    // randomly invalidate some cached entries, then check that we receive invalidate notifications for those and only  
                cache.put(i, new Value(Integer.toString(i), 2));
import java.util.stream.Collectors;  
                            deadlockLatch.countDown();
                    cache.invalidate(i, Integer.toString(i + randomIntBetween(2, 10)));
        for (int i = 0; i < numberOfEntries; i++) {
                    for (int j = 0; j < numberOfEntries; j++) {  
            return 1L;
            cache.put(i, Integer.toString(i));
        }
                        throw new AssertionError(e);
                    // invalidate with incorrect value
                keys.add(key);
                                    } else {
        int count = 0;
        assertEquals(expected, new HashSet<>(snapshot));
                        } catch (final ExecutionException e) {  
        }
        cache.refresh();
    private static final String STALL_KEY = "stall";
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>builder()  
    // those entries
        }
                    barrier.await();
            }
        }
            remainingKeys.add(key);
                assertEquals(RemovalReason.INVALIDATED, notification.getRemovalReason());
                    cache.invalidate(i, Integer.toString(i));
            assertEquals(cache.get(i), Integer.toString(i));
                if (o == null || getClass() != o.getClass()) return false;  
