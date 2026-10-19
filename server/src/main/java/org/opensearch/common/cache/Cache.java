    private long weight = 0;
     * An LRU sequencing of the values in the cache. This sequence is not protected from mutations
        return count;
import java.util.concurrent.CompletableFuture;  
@PublicApi(since = "1.0.0")  
        CompletableFuture<Entry<K, V>> completableFuture = new CompletableFuture<>();
        public long getHits() {
                }
     * A cache segment.  
            value = completableValue.get();
     */
     */
     * @return an LRU-ordered {@link Iterable} over the values in the cache
            // count/weight adjustment to make here because the entry was never linked, but the removal notification
 * @param <V> The type of the values
                NullPointerException npe = new NullPointerException("loader returned a null value");  
            // check to ensure the future hasn't been completed with an exception  
     * @param loader the function to compute a value given a key
            try (ReleasableLock ignored = readLock.acquire()) {
            }
     * If the specified key is not already associated with a value (or is mapped to null), attempts to compute its
    private final Consumer<CompletableFuture<Entry<K, V>>> removalConsumer = f -> {
        } catch (ExecutionException e) {
     * Invalidate all cache entries. A removal notification will be issued for invalidated entries with  
            }  
    }
         * @return a tuple of the new entry and the existing entry, if there was one otherwise null
                                return ok;  
                } catch (ExecutionException e) {  
        entry.state = State.EXISTING;
        private long hits;  
            void eviction() {  
                if (haveSegmentLock[i]) {
    private boolean entriesExpireAfterWrite;
     * thrown during the execution of the first.
                head = after;  
                } catch (ExecutionException | InterruptedException e) {
        try {  
            final Entry<K, V> before = entry.before;  
    // true if entries can expire after initial insertion  
            if (entry != null) {  
                Entry<K, V> current = head;  
    /**
    // pkg-private for testing  
                haveSegmentLock[i] = true;
        } else {  
                    delete(entry, RemovalReason.INVALIDATED);
                    throw new IllegalStateException(e);
            @Override
        }
         * Use {@link CacheStats} instead.
    /**
    long getExpireAfterAccessNanos() {  
        @Override
            removalNotifications.add(new RemovalNotification<>(tuple.v2().key, tuple.v2().value, RemovalReason.REPLACED));
                    removalListener.onRemoval(removalNotification);
        void remove(K key, Consumer<CompletableFuture<Entry<K, V>>> onRemoval) {
     *  
         */
     * entry with {@link RemovalReason} EXPLICIT.
        }
     * {@link RemovalReason} INVALIDATED.
            for (RemovalNotification<K, V> removalNotification : removalNotifications) {
                    throw new IllegalStateException(e);
            evictEntry(tail);
            private final LongAdder misses = new LongAdder();
    public void refresh() {
    /**
                for (RemovalNotification<K, V> removalNotification : removalNotifications) {
                return iterator.hasNext();
        return value;
        return maximumWeight != -1 && weight > maximumWeight;  
        if (future == null) {
                future = map.remove(key);
                before.after = after;  
    }  
    }
                    return entry;
/*  
        @Override  
            throw new IllegalStateException(e);  
                    entry = future.get();
        long writeTime;
        }  
     * the key, the old value is replaced.
                case DELETED:  
            evictions += segments[i].segmentStats.evictions.longValue();  
        this.weigher = weigher;  
    }
            }
                }  
     * A point-in-time copy of the keys in the cache, in no particular order. Unlike {@link #keys()}, the returned
                    if (segment != null) {
 * A simple concurrent cache.  
                future.get(); // call get to force the exception to be thrown for other concurrent callers
import java.util.concurrent.atomic.LongAdder;
         * expected value
            h.before = entry;  
    private void evictEntry(Entry<K, V> entry) {  
        assert lruLock.isHeldByCurrentThread();  
                hits.increment();
    void setRemovalListener(RemovalListener<K, V> removalListener) {  
            @Override  
    }
         * Builder for the {@link CacheStats} class.  
            h = h.after;  
        private static class SegmentStats {
        public long getMisses() {  
        this.entriesExpireAfterWrite = true;  
        count++;  
        return numberOfSegments;
        volatile long accessTime;
                        }
     * @param key the key whose mapping is to be removed from the cache  
     * the cache, no removal will occur. A removal notification will be issued for invalidated  
            // promote it. Claim it by marking it DELETED so that the pending promote() becomes a no-op: otherwise the
    }
 * <p>
        /**
        return get(key, now(), e -> {});
            private long hits = 0;
            unlink(entry);  
 * Licensed to Elasticsearch under one or more contributor  
     * @param key the key whose associated value is to be returned
                evictions.increment();
                try {
 * the Apache License, Version 2.0 (the "License"); you may
     *
        for (CacheSegment<K, V> segment : segments) {
    private boolean shouldPrune(Entry<K, V> entry, long now) {
     * @return the current (existing or computed) non-null value associated with the specified key
    // true if entries can expire after access  
            if (after == null) {
    }
 * The LRU functionality is backed by a single doubly-linked list chaining the entries in order of insertion. This  
 * compatible open source license.
                // removing inner element  
import java.util.Objects;
        } catch (InterruptedException e) {
                        segment.remove(entryToBeRemoved.key, entryToBeRemoved.value, f -> {});  
     * to the cache (except for {@link Iterator#remove()}. The result of iteration under any other mutation is
        }
    private Tuple<Boolean, List<RemovalNotification<K, V>>> promote(Entry<K, V> entry, long now) {
     * @param value value to be associated with the specified key
                segmentStats.eviction();
        }  
    @PublicApi(since = "1.0.0")
            if (before == null) {  
    // the number of entries in the cache  
            public boolean hasNext() {  
            entry.state = State.DELETED;  
    public V computeIfAbsent(K key, CacheLoader<K, V> loader) throws ExecutionException {
                try (ReleasableLock ignored = lruLock.acquire()) {  
        long now = now();  
        private Entry<K, V> current;
         * pruned or a manual {@link Cache#refresh()} is performed however a caller can take action using the provided callback
            }
import java.util.HashMap;
                future.complete(new Entry<>(key, loaded, now));
        assert lruLock.isHeldByCurrentThread();  
import org.opensearch.common.collect.Tuple;
            }  
        if (replaced) {  
                throw new ExecutionException(npe);
    int getNumberOfSegments() {  
                            new RemovalNotification<>(entryToBeRemoved.key, entryToBeRemoved.value, RemovalReason.EVICTED)
                            }  
    }  
         * @return the entry if there was one, otherwise null
            return next != null;
         *  
        }
     * Cache statistics  
     * An LRU sequencing of the keys in the cache that supports removal. This sequence is not protected from mutations  
                return iterator.hasNext();  
    public void invalidateAll() {  
            } catch (Exception e) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        V value = get(key, now, e -> {
        }
                                return null;
        }  
    };  
            for (int i = this.numberOfSegments - 1; i >= 0; i--) {
         * This constructor will be deprecated starting in version 3.4.0.
                return iterator.next().key;
        /**  
            }  
            next = head;  
                        existing = future.handle((ok, ex) -> {
        Tuple<Entry<K, V>, Entry<K, V>> tuple = segment.put(key, value, now);
        this.removalListener = removalListener;
        }
        private Entry<K, V> next;
            if (future != null) {  
    }
        }
            return hits;  
            }  
                    }  
        } else {
    private void evict(long now) {
        // get the value from this future on the thread that won the race to place the future into the segment map
            evict(now);
    private long expireAfterWriteNanos = -1;
 * software distributed under the License is distributed on an
import java.util.function.ToLongBiFunction;  
            this.misses = misses;
    }  
 *  
        ReleasableLock writeLock = new ReleasableLock(segmentLock.writeLock());
                if (unlink(tuple.v2())) {  
                iterator.remove();
            } else {  
                loaded = loader.load(key);  
                            }
        this.expireAfterWriteNanos = expireAfterWriteNanos;
         * @param onRemoval a callback for the removed entry
            }
                    }  
        }
                    CompletableFuture<Entry<K, V>> future = map.put(key, CompletableFuture.completedFuture(entry));
            Entry<K, V> entry = new Entry<>(key, value, now);
            return current;  
    }  
     * @param key the key whose mapping is to be invalidated from the cache  
            if (promoted) {
    public void put(K key, V value) {  
    /**
     * notifications that the callers needs to handle.
                        removalNotifications.add(  
    }
                }
            }
            this.misses = builder.misses;
        put(key, value, now);
         *  
                while (tail != null && shouldPrune(tail, now)) {
                try {
    }  
     *
            }
 * </ol>
        segment.remove(key, value, invalidationConsumer);
    private V compute(K key, CacheLoader<K, V> loader) throws ExecutionException {
            try (ReleasableLock ignored = lruLock.acquire()) {  
        }
 * <li>Locks on the list could be taken per node being modified instead of globally.</li>
     * The number of entries in the cache.  
            if (future != null && removed) {  
            this.hits = builder.hits;
        }
    void setExpireAfterWriteNanos(long expireAfterWriteNanos) {
        CacheSegment<K, V> segment = getCacheSegment(entry.key);  
                entry.after = null;
 */  
    /**  
        return value;
                }
}  
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.locks.ReentrantLock;
                    if (sanity != null && sanity.isCompletedExceptionally()) {
    }
        if (h == null) {  
                } else {
    /**
     * undefined.  
         * @param key the key of the entry to remove from the cache
    private void delete(Entry<K, V> entry, RemovalReason removalReason) {
     *
        // need a mechanism to ensure that load is invoked at most once, but we are not invoking load while holding
            List<RemovalNotification<K, V>> removalNotifications = promote(entry, now).v2();
import java.util.concurrent.ExecutionException;
            private final LongAdder hits = new LongAdder();  
     * or may not reflect concurrent insertions and removals. Keys are copied one segment at a time while holding
     * @return an LRU-ordered {@link Iterable} over the keys in the cache
         * @param onExpiration a callback if the entry associated to the key is expired  
        Map<K, CompletableFuture<Entry<K, V>>> map = new HashMap<>();
 * this work for additional information regarding copyright
import java.util.function.Predicate;
            removalListener.onRemoval(new RemovalNotification<>(entry.key, entry.value, removalReason));  
        this.segments = new CacheSegment[this.numberOfSegments];  
 * under the License.  
            }
        /**
                }  
            Entry<K, V> existing = null;
            // entry gets linked into the LRU list while absent from the segment map, where it is counted in
    private final CacheSegment<K, V>[] segments;
                    CacheSegment<K, V> segment = getCacheSegment(entryToBeRemoved.key);
 * <p>
            }  
     *
            return misses;
 * license agreements. See the NOTICE file distributed with
        });  
 * @param <K> The type of the keys
        private long evictions;
        if (segment != null) {
    }  
            for (int i = 0; i < this.numberOfSegments; i++) {
        return exceedsWeight() || isExpired(entry, now);
            value = compute(key, loader);
        /**
    public int count() {
 * You may obtain a copy of the License at  
        try (ReleasableLock ignored = lruLock.acquire()) {
         */
                entry.before = null;
        public long getEvictions() {
        final V value;  
            this.segments[i] = new CacheSegment<>();
        return (entriesExpireAfterAccess && now - entry.accessTime > expireAfterAccessNanos)
     * value using the given mapping function and enters it into this map unless null. The load method for a given key
        if (value == null) {
        SegmentStats segmentStats = new SegmentStats();  
import java.util.Iterator;
     *
         * @param key       the key of the entry to remove from the cache
            // The entry was removed from the segment map before the thread that loaded it acquired the LRU lock to  
        BiFunction<? super Entry<K, V>, Throwable, ? extends V> handler = (ok, ex) -> {
     */  
        return weight;
        }
            public V next() {
        }
                delete(entry, RemovalReason.INVALIDATED);
                        }).get();
             */
 * here if write throughput is a concern.
            }
     *
/*  
        CacheSegment<K, V> segment = getCacheSegment(key);
        return keys;  
    }
         * remove an entry from the segment
        // System.nanoTime takes non-negligible time, so we only use it if we need it
                assert tail == entry;  
        CompletableFuture<V> completableValue;  
    }
 * <p>  
    Entry<K, V> tail;
    // the weigher of entries  
        }
            }
        /**  
    /**
        CacheSegment<K, V> segment = getCacheSegment(key);  
         */
        head = entry;
    /**
            }  
            this.writeTime = this.accessTime = writeTime;
        if (removed) {
                    if (future != null) {
        @Deprecated
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
         * @param now       the access time of this entry
        long now = now();
                return this;
            try {
    }
            } else {
                case EXISTING:  
        List<RemovalNotification<K, V>> removalNotifications = new ArrayList<>();  
     *  
    }
     * to the cache (except for {@link Iterator#remove()}. The result of iteration under any other mutation is
            switch (entry.state) {
        Entry<K, V> entry = segment.get(key, now, e -> isExpired(e, now), onExpiration);
        assert lruLock.isHeldByCurrentThread();  
     */  
     * entries with {@link RemovalReason} INVALIDATED.
     * @return the weight of the entries in the cache
        if (maximumWeight < 0) {  
        segment.remove(key, removalConsumer);
 * The OpenSearch Contributors require contributions made to  
            }  
        this.entriesExpireAfterAccess = true;
            CompletableFuture<Entry<K, V>> future;  
     */
            }
 * ownership. Elasticsearch licenses this file to you under  
        try (ReleasableLock ignored = segment.writeLock.acquire()) {  
        boolean replaced = false;
    private void put(K key, V value, long now) {
                }
        public boolean hasNext() {
         * @param key       the key of the entry to get from the cache  
            public boolean hasNext() {
     * undefined.
     * @opensearch.internal
            this.value = value;  
         */
    private CacheSegment<K, V> getCacheSegment(K key) {  
     *
        for (int i = 0; i < segments.length; i++) {  
                keys.addAll(segment.map.keySet());  
                if (!removalNotifications.isEmpty()) {
            throw new IllegalArgumentException("expireAfterAccessNanos <= 0");
        } else {  
        entry.after = head;
 * if they are reading a segment that a writer is writing to).
                future = map.get(key);  
        CacheSegment<K, V> segment = getCacheSegment(key);  
            }
    }  
                misses.increment();  
                Entry<K, V> entry;  
                    }  
     * @throws ExecutionException thrown if loader throws an exception or returns a null value  
    private final int numberOfSegments;  
            return Tuple.tuple(entry, existing);
        }  
        }  
        try (ReleasableLock ignored = lruLock.acquire()) {
            private long evictions = 0;  
        final K key;
                }
            misses += segments[i].segmentStats.misses.longValue();
        }
import java.util.List;  
    /**
    }
    }  
            }
                weight = 0;
 * specific language governing permissions and limitations
     */
     * list is not backed by the cache and is safe to iterate under any concurrent mutation. The copy is weakly  
 */  
        Objects.requireNonNull(removalListener);
                segmentStats.eviction();
    Entry<K, V> head;  
    private boolean unlink(Entry<K, V> entry) {
                after.before = before;
        assert lruLock.isHeldByCurrentThread();
    }  
                try (ReleasableLock ignored = segment.writeLock.acquire()) {
        // invoking load can lead to deadlock against another thread due to dependent key loading; therefore, we
        }  
     * Invalidate the entry for the specified key and value. If the value provided is not equal to the value in
                    for (RemovalNotification<K, V> removalNotification : removalNotifications) {
            }
            removalListener.onRemoval(new RemovalNotification<>(h.key, h.value, RemovalReason.INVALIDATED));
    Cache(final int numberOfSegments) {  
        };
    private long expireAfterAccessNanos = -1;
     *
        this.maximumWeight = maximumWeight;  
            // ok  
            entry.state = State.DELETED;
        }  
        long hits = 0;  
        entry.before = null;  
                onRemoval.accept(future);
        EXISTING,
    public void remove(K key) {
    }  
                future = map.get(key);  
     *
    private final Consumer<CompletableFuture<Entry<K, V>>> invalidationConsumer = f -> {
            private CacheIterator iterator = new CacheIterator(head);  
 * without contention, and the segments gives us write throughput without impacting readers (so readers are blocked only  
            Entry<K, V> entry = f.get();
            @Override
        }
                onRemoval.accept(future);
            CompletableFuture<Entry<K, V>> future;
                evictEntry(e);
    }
        };  
    void setExpireAfterAccessNanos(long expireAfterAccessNanos) {  
         * This is the sole entry point for creating a new CacheStats object.  
        }
        return this.expireAfterWriteNanos;
            throw new IllegalArgumentException("maximumWeight < 0");
 * invalidation) or an explicit call to {@link #refresh()}.
 *
        }
    }
        for (int i = 0; i < this.numberOfSegments; i++) {
    }  
    // the weight of the entries in the cache  
        CacheSegment<K, V> segment = getCacheSegment(key);
    public long weight() {
/**
        }
    }
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
            public Builder misses(long misses) {  
     */  
         * @opensearch.internal  
            public void remove() {
        } else {  
 * evictions. The design goals for this cache were simplicity and read performance. This means that we are willing to  
            throw new IllegalStateException(e);
                return new CacheStats(this);  
        Entry<K, V> h;
                }
        try {
         */  
        List<RemovalNotification<K, V>> removalNotifications = new ArrayList<>();  
        CacheSegment<K, V> segment = getCacheSegment(key);
        boolean promoted = true;
                    if (unlink(entryToBeRemoved)) {
     */  
                }  
 * evictions are exposed.
            removed = true;
    }
            }
        List<K> keys = new ArrayList<>(count);  
                throw new ExecutionException(e);  
        return entriesExpireAfterAccess || entriesExpireAfterWrite ? System.nanoTime() : 0;
    private boolean isExpired(Entry<K, V> entry, long now) {  
    // the state of an entry in the LRU list
            Entry<K, V> entry = f.get();  
                head = tail = null;
    }  
    /**
    private void linkAtHead(Entry<K, V> entry) {
    private int count = 0;
     * will be invoked at most once.  
            return entry.value;
            try (ReleasableLock ignored = writeLock.acquire()) {  
            removed = unlink(entry);  
     * @return the current relative time
            private long misses = 0;
                    }
        }
         */
        }
    }  
        Entry<K, V> get(K key, long now, Predicate<Entry<K, V>> isExpired, Consumer<Entry<K, V>> onExpiration) {  
                    onExpiration.accept(entry);  
                        segment.map.remove(key);
        CacheIterator(Entry<K, V> head) {
                } catch (InterruptedException e) {
                return this;
            } else {
            try (ReleasableLock ignored = lruLock.acquire()) {
                    if (future != null) {  
                            if (Objects.equals(value, entry.value)) {
        if (expireAfterAccessNanos <= 0) {
    }  
             * @return A new CacheStats instance.  
            return false;
                count = 0;  
    /**
                    current = null;
     * @return Returns a tuple. v1 signifies whether an entry got promoted, v2 signifies the list of removal
            }
 * GitHub history for details.
            } else {
         */
        }  
package org.opensearch.common.cache;
                h = head;
                            } else {
                removalListener.onRemoval(removalNotification);
    }
        long now = now();
     * Associates the specified value with the specified key in this map. If the map previously contained a mapping for  
        public static class Builder {  
                    current.state = State.DELETED;
                    return null;  
         *
        }
    /**
         * @param onRemoval a callback for the removed entry  
                Arrays.stream(segments).forEach(segment -> segment.map = new HashMap<>());
        Entry<K, V> before;  
            }
 * Cache is a simple concurrent cache that supports time-based and weight-based evictions, with notifications for all
        }
                this.hits = hits;
     */
            }  
     * @return the current cache statistics  
                if (head != null) {
 * @opensearch.api
                        removalListener.onRemoval(removalNotification);  
            completableValue = future.handle(handler);  
                    linkAtHead(entry);
        }
        delete(entry, RemovalReason.EVICTED);
        /**
        CacheSegment<K, V> segment = getCacheSegment(key);  
        if (expireAfterWriteNanos <= 0) {
                    current = current.after;  
            hits += segments[i].segmentStats.hits.longValue();
        void remove(K key, V value, Consumer<CompletableFuture<Entry<K, V>>> onRemoval) {
        return new CacheStats.Builder().hits(hits).misses(misses).evictions(evictions).build();
        return maximumWeight;
     */
             * Creates a {@link CacheStats} object from the builder's current state.
    }  
            public CacheStats build() {
        long now = now();
                }  
     * Entry in a cache  
                    replaced = true;
                }  
    public long getMaximumWeight() {  
    }
    static class Entry<K, V> {
     * loader function being called and the second will be returned the result provided by the first including any exceptions  
                tail = before;
                iterator.remove();
                segmentStats.miss();
                return null;
                this.misses = misses;
     * @param key the key whose mapping is to be invalidated from the cache
                List<RemovalNotification<K, V>> removalNotifications = new ArrayList<>();  
import org.opensearch.common.annotation.PublicApi;
 *  
        }
    private boolean entriesExpireAfterAccess;
            future = completableFuture;
    // the removal callback  
        boolean[] haveSegmentLock = new boolean[this.numberOfSegments];  
                return null;  
        }  
                    assert future.isCompletedExceptionally();
 * this file be licensed under the Apache-2.0 license or a
        // we have to eagerly evict expired entries or our putIfAbsent call below will fail
        if (entry == null) {
 * <p>  
    public void invalidate(K key) {  
import java.util.function.Consumer;
        try {
 */
        State state = State.NEW;
        Tuple<Entry<K, V>, Entry<K, V>> put(K key, V value, long now) {  
        // read/write lock protecting mutations to the segment
        while (tail != null && shouldPrune(tail, now)) {
                    head.before = null;
        /**
        }
 * accept reduced write performance in exchange for easy-to-understand code. Cache statistics for hits, misses and
     * <p>
        return this.expireAfterAccessNanos;
            public Builder hits(long hits) {
         * @param value the value expected to be associated with the key
                    throw new IllegalStateException(e);
                    }
     * @return the number of entries in the cache
    }
        }
                    removalNotifications = promote(ok, now).v2();
            }  
                future.completeExceptionally(e);
     *
     *  
     * Force any outstanding size-based and time-based evictions to occur
                throw new IllegalStateException("the future was completed exceptionally but no exception was thrown");  
        long misses = 0;
            this.numberOfSegments = numberOfSegments;
            @Override  
     * @param <V> the type of the values
     */  
            void miss() {
        V value;  
    long getExpireAfterWriteNanos() {
            this.evictions = builder.evictions;  
            /**
    private V get(K key, long now, Consumer<Entry<K, V>> onExpiration) {
            }
            linkAtHead(entry);
                return iterator.next().value;  
            public Builder() {}
    }  
            segment.remove(entry.key, entry.value, f -> {});
            }
        NEW,  
        }  
import java.util.Map;
 * <ol>  
     * segment at a time, and does not acquire the LRU lock.
    public CacheStats stats() {
                }  
         * Provides a fluent API for constructing a CacheStats object.
                future.completeExceptionally(npe);
                    tail.after = null;  
        public CacheStats(long hits, long misses, long evictions) {
     */
            return null;  
            }  
        } catch (InterruptedException e) {  
        };
                if (isExpired.test(entry)) {
                delete(entry, RemovalReason.EXPLICIT);  
            if (tuple.v2() != null && tuple.v2().state == State.EXISTING) {
            // ok
         * get an entry from the segment; expired entries will be returned as null but not removed from the cache until the LRU list is  
            current = null;
                // removing the head
        } else {
import java.util.function.BiFunction;  
        }
            next = next.after;
                }
    }
        if (entry.state == State.EXISTING) {
    // the maximum weight that this cache supports  
        try {
 * The design of the cache is relatively simple. The cache is segmented into 256 segments which are backed by HashMaps.
            }
            try (ReleasableLock ignored = writeLock.acquire()) {  
    public Iterable<V> values() {
    protected long now() {
            }
import java.util.concurrent.locks.ReentrantReadWriteLock;
        } catch (ExecutionException e) {
         * put an entry into the segment
    public void setMaximumWeight(long maximumWeight) {
        // the segment lock; to do this, we atomically put a future in the map that can load the value, and then  
        DELETED
            count--;
        Entry<K, V> after;
    private boolean exceedsWeight() {
            } else {
     *  
        @Override  
        }  
        }  
        public void remove() {
     * @param value the expected value that should be associated with the key
                    entry.accessTime = now;
            // must still fire so that listeners can account for the value the loader produced.
                // removing tail
        private long misses;
        private CacheStats(Builder builder) {  
        if (!removalNotifications.isEmpty()) {  
         * @param key   the key of the entry to add to the cache
            weight -= weigher.applyAsLong(entry.key, entry.value);  
     * @param <K> the type of the keys
        } finally {  
            @Override
    /**
     * The cache statistics tracking hits, misses and evictions. These are taken on a best-effort basis meaning that  
     *
            private final LongAdder evictions = new LongAdder();
import java.util.ArrayList;
import org.opensearch.common.util.concurrent.ReleasableLock;  
            tail = entry;
 * Each segment is protected by a re-entrant read/write lock. The read/write locks permit multiple concurrent readers
                    segmentStats.hit();  
    // pkg-private for testing
 * LRU list is protected by a lock that serializes all writes to it. There are opportunities for improvements
    private static class CacheSegment<K, V> {  
     * @return a copy of the keys in the cache  
     * The relative time used to track time-based evictions.  
            void hit() {
    void setWeigher(ToLongBiFunction<K, V> weigher) {
            public Builder evictions(long evictions) {
            }  
     */
    public void invalidate(K key, V value) {  
 * KIND, either express or implied.  See the License for the
                    segmentStats.miss();
    public ToLongBiFunction<K, V> getWeigher() {
            this.hits = hits;  
        Objects.requireNonNull(weigher);
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
        Entry(K key, V value, long writeTime) {
            public K next() {
                                removed = map.remove(key, future);  
     */  
                    promoted = false;
                return this;  
import java.util.Arrays;  
                    break;
                // removing inner element
                assert head == entry;
        ReleasableLock readLock = new ReleasableLock(segmentLock.readLock());
                            Entry<K, V> entry = future.get();
            if (ok != null) {
 */
     * Invalidate the association for the specified key. A removal notification will be issued for invalidated
     * Removes the association for the specified key. A removal notification will be issued for removed  
    };
     * case the cache size is exceeding or the entry got expired.
        long evictions = 0;
     * @opensearch.api
     * they could be out-of-date mid-flight.
    private RemovalListener<K, V> removalListener = notification -> {};
            return true;
                }  
    private void relinkAtHead(Entry<K, V> entry) {
                segments[i].segmentLock.writeLock().lock();  
                    Entry<K, V> entryToBeRemoved = tail;  
            try (ReleasableLock ignored = lruLock.acquire()) {
        return () -> new Iterator<V>() {
            this.key = key;
                this.evictions = evictions;  
 *
         *  
    /**  
        this.expireAfterAccessNanos = expireAfterAccessNanos;
                            if (ok != null) {
            public void remove() {  
        if (entry.state == State.NEW) {
    private long maximumWeight = -1;
     * A CacheSegment is backed by a HashMap and is protected by a read/write lock.
            CompletableFuture<Entry<K, V>> future;
            || (entriesExpireAfterWrite && now - entry.writeTime > expireAfterWriteNanos);
     * entries with {@link RemovalReason} INVALIDATED.
            V loaded;
            }
     */  
            return evictions;
    public static class CacheStats {
        }
        Entry<K, V> h = head;
            }
    }  
        public Entry<K, V> next() {  
     *
    public V get(K key) {
    public Iterable<K> keys() {  
                    return null;
         *
    // positive if entries have an expiration after write  
     *  
            boolean removed = false;
        weight += weigher.applyAsLong(entry.key, entry.value);
         * remove an entry from the segment iff the future is done and the value is equal to the
            }
        /**  
    /**
            if (loaded == null) {
 * <li>LRU list mutations could be inserted into a blocking queue that a single thread is reading from
            current = next;
         * @param now   the access time of this entry  
     * <p>
/*
        }
        while (h != null) {
 * not use this file except in compliance with the License.
            throw new IllegalStateException(e);
            if (future.isCompletedExceptionally()) {
     */
                CacheSegment<K, V> segment = getCacheSegment(entry.key);
            }  
        } catch (InterruptedException e) {
        // use System.nanoTime because we want relative time, not absolute time  
        segment.remove(key, invalidationConsumer);
                    break;
                    segmentStats.miss();
            completableValue = future.handle(handler);
import java.util.concurrent.locks.ReadWriteLock;  
 *  
    @SuppressWarnings("unchecked")  
            future = segment.map.putIfAbsent(key, completableFuture);
        }
            }
        CompletableFuture<Entry<K, V>> future;  
    private ToLongBiFunction<K, V> weigher = (k, v) -> 1;
                } catch (ExecutionException | InterruptedException e) {  
        }
    /**
                try {
        return () -> new Iterator<K>() {
            this.evictions = evictions;
        // we need to synchronize loading of a value for a given key; however, holding the segment lock while  
     * The weight of the entries in the cache.  
        if (numberOfSegments != -1) {
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            try (ReleasableLock ignored = segment.readLock.acquire()) {
                        );
     * only that segment's read lock, so this method never blocks cache reads, briefly blocks writes to a single  
        return weigher;  
    }  
    /**  
        if (head != entry) {
    public List<K> keysSnapshot() {
        try (ReleasableLock ignored = lruLock.acquire()) {  
 * and applying to the LRU list.</li>
         * Private constructor that takes a builder.
    // lock protecting mutations to the LRU list  
                    }
                    segments[i].segmentLock.writeLock().unlock();  
            }
     * @param key    the key whose associated value is to be returned or computed for if non-existent  
                while (current != null) {
        } else {
        ReadWriteLock segmentLock = new ReentrantReadWriteLock();
         * Segment statistics
    }  
        final boolean removed;
                if (tail != null) {
        assert lruLock.isHeldByCurrentThread();
    }
     * @opensearch.internal
     * @param key   key with which the specified value is to be associated  
            if (!removalNotifications.isEmpty()) {  
                    break;
            try (ReleasableLock ignored = lruLock.acquire()) {  
            if (future != null) {
            private CacheIterator iterator = new CacheIterator(head);
        return segments[key.hashCode() & (this.numberOfSegments - 1)];
     */  
         */  
            @Override
            }  
            Entry<K, V> entry = current;
    /**
            try (ReleasableLock ignored = writeLock.acquire()) {
     */  
    private class CacheIterator implements Iterator<Entry<K, V>> {  
    /**
            }
        }  
        return new Tuple<>(promoted, removalNotifications);
     * @param now the current time  
     * Promotes the desired entry to the head of the lru list and tries to see if it needs to evict any entries in  
     * consistent: it contains every key that was present in the cache for the entire duration of the call, and may
    private final ReleasableLock lruLock = new ReleasableLock(new ReentrantLock());
     * Use of different {@link CacheLoader} implementations on the same key concurrently may result in only the first
                    relinkAtHead(entry);
     */
         * @param value the value of the entry to add to the cache
                }
                try (ReleasableLock ignored = lruLock.acquire()) {
     * @param entry Entry to be promoted
                segment.remove(entry.key, entry.value, f -> {});
            this.numberOfSegments = NUMBER_OF_SEGMENTS;
                case NEW:  
                        if (future.isDone()) {  
    enum State {
public class Cache<K, V> {
            final Entry<K, V> after = entry.after;
                return ok.value;  
            // count()/weight() but is unreachable via get() and can no longer be invalidated by key. There is no  
        assert lruLock.isHeldByCurrentThread();
                    CompletableFuture<Entry<K, V>> sanity = segment.map.get(key);  
            throw new IllegalArgumentException("expireAfterWriteNanos <= 0");  
    public static final int NUMBER_OF_SEGMENTS = 256;
    // positive if entries have an expiration  
    }  
         * @param isExpired test if the entry is expired
 * <li>Promotions could be deferred for entries that were "recently" promoted.</li>  
         * @param builder The builder instance containing all the values.
            removalNotifications = promote(tuple.v1(), now).v2();
 * Evictions only occur after a mutation to the cache (meaning an entry promotion, a cache insertion, or a manual
