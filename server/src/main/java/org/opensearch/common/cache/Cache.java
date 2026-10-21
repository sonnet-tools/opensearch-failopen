            current = next;
                    return null;
         *
                    return null;
                    }
            try (ReleasableLock ignored = lruLock.acquire()) {
                loaded = loader.load(key);
            this.hits = builder.hits;
            future = segment.map.putIfAbsent(key, completableFuture);
                    head.before = null;
        long writeTime;
    }
 * <li>Promotions could be deferred for entries that were "recently" promoted.</li>
            if (future != null) {
                for (RemovalNotification<K, V> removalNotification : removalNotifications) {
        if (expireAfterWriteNanos <= 0) {
                            } else {
    /**
            }
    /**
                } catch (ExecutionException | InterruptedException e) {
    private Tuple<Boolean, List<RemovalNotification<K, V>>> promote(Entry<K, V> entry, long now) {
    public int count() {
        return maximumWeight;
        /**
        return value;
    }
        long hits = 0;
    Entry<K, V> head;
            }
    // pkg-private for testing
            if (future != null && removed) {
                        }).get();
            }
     *
     * Promotes the desired entry to the head of the lru list and tries to see if it needs to evict any entries in
        };
     * @param key    the key whose associated value is to be returned or computed for if non-existent
        this.maximumWeight = maximumWeight;
         * @param onExpiration a callback if the entry associated to the key is expired
import java.util.function.ToLongBiFunction;
        } else {
        long misses = 0;
        this.segments = new CacheSegment[this.numberOfSegments];
                keys.addAll(segment.map.keySet());
                return ok.value;
                count = 0;
    public void put(K key, V value) {
            final Entry<K, V> before = entry.before;
            // promote it. Claim it by marking it DELETED so that the pending promote() becomes a no-op: otherwise the
    }
    public ToLongBiFunction<K, V> getWeigher() {
            Entry<K, V> entry = f.get();
        weight += weigher.applyAsLong(entry.key, entry.value);
            }
            Entry<K, V> existing = null;
     *
        void remove(K key, V value, Consumer<CompletableFuture<Entry<K, V>>> onRemoval) {
            try (ReleasableLock ignored = writeLock.acquire()) {
            }
     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            value = completableValue.get();
            linkAtHead(entry);
 * Licensed to Elasticsearch under one or more contributor
 * accept reduced write performance in exchange for easy-to-understand code. Cache statistics for hits, misses and
    private void evictEntry(Entry<K, V> entry) {
            }
    }
                        segment.remove(entryToBeRemoved.key, entryToBeRemoved.value, f -> {});
     * @opensearch.internal
                        );
     * @return an LRU-ordered {@link Iterable} over the keys in the cache
            }
        } catch (ExecutionException e) {
    }
    }
import org.opensearch.common.collect.Tuple;
                return iterator.next().key;
                    }
        return new CacheStats.Builder().hits(hits).misses(misses).evictions(evictions).build();
     * list is not backed by the cache and is safe to iterate under any concurrent mutation. The copy is weakly
            throw new IllegalArgumentException("expireAfterAccessNanos <= 0");
            entry.state = State.DELETED;
import java.util.Iterator;
 *
            for (int i = 0; i < this.numberOfSegments; i++) {
        private Entry<K, V> current;
     * The cache statistics tracking hits, misses and evictions. These are taken on a best-effort basis meaning that
                head = tail = null;
         * This constructor will be deprecated starting in version 3.4.0.
 * <p>
            || (entriesExpireAfterWrite && now - entry.writeTime > expireAfterWriteNanos);
        // System.nanoTime takes non-negligible time, so we only use it if we need it
            }
        this.removalListener = removalListener;
        delete(entry, RemovalReason.EVICTED);
        final V value;
public class Cache<K, V> {
            if (!removalNotifications.isEmpty()) {
        }
                            Entry<K, V> entry = future.get();
            if (after == null) {
            }
    public V get(K key) {
            void hit() {
                    segmentStats.hit();
        }
                iterator.remove();
        return () -> new Iterator<V>() {
        CacheSegment<K, V> segment = getCacheSegment(key);
                    CompletableFuture<Entry<K, V>> sanity = segment.map.get(key);
     * @param key the key whose mapping is to be invalidated from the cache
    enum State {
                // removing inner element
                assert head == entry;
         * @param key the key of the entry to remove from the cache
 * this file be licensed under the Apache-2.0 license or a
                throw new IllegalStateException("the future was completed exceptionally but no exception was thrown");
            removalListener.onRemoval(new RemovalNotification<>(h.key, h.value, RemovalReason.INVALIDATED));
import java.util.concurrent.locks.ReentrantReadWriteLock;
     *
    /**
     * @throws ExecutionException thrown if loader throws an exception or returns a null value
            }
        Entry<K, V> before;
        if (future == null) {
                if (haveSegmentLock[i]) {
/*
        Tuple<Entry<K, V>, Entry<K, V>> tuple = segment.put(key, value, now);
        this.entriesExpireAfterWrite = true;
     * A point-in-time copy of the keys in the cache, in no particular order. Unlike {@link #keys()}, the returned
            CompletableFuture<Entry<K, V>> future;
                }
        // read/write lock protecting mutations to the segment
                while (current != null) {
        volatile long accessTime;
                segment.remove(entry.key, entry.value, f -> {});
        Objects.requireNonNull(removalListener);
    private boolean shouldPrune(Entry<K, V> entry, long now) {
    };
 * and applying to the LRU list.</li>
     *
        ReadWriteLock segmentLock = new ReentrantReadWriteLock();
     * to the cache (except for {@link Iterator#remove()}. The result of iteration under any other mutation is
                delete(entry, RemovalReason.INVALIDATED);
    private boolean entriesExpireAfterWrite;
        CacheIterator(Entry<K, V> head) {
            entry.state = State.DELETED;
     * @return a copy of the keys in the cache
                    promoted = false;
        CacheSegment<K, V> segment = getCacheSegment(key);
            for (int i = this.numberOfSegments - 1; i >= 0; i--) {
                future = map.get(key);
    public static class CacheStats {
     * @param value value to be associated with the specified key
        if (maximumWeight < 0) {
    // true if entries can expire after access
    private long weight = 0;
        } else {
     * An LRU sequencing of the values in the cache. This sequence is not protected from mutations
            // ok
            hits += segments[i].segmentStats.hits.longValue();
                                removed = map.remove(key, future);
        assert lruLock.isHeldByCurrentThread();
    public long weight() {
        } else {
                if (!removalNotifications.isEmpty()) {
     */
            }
                }
    private static class CacheSegment<K, V> {
                            }
        State state = State.NEW;
                hits.increment();
         * @param now   the access time of this entry
            return entry.value;
                try (ReleasableLock ignored = lruLock.acquire()) {
        } catch (InterruptedException e) {
 * SPDX-License-Identifier: Apache-2.0
            return true;
            unlink(entry);
     * If the specified key is not already associated with a value (or is mapped to null), attempts to compute its
        try {
 * The OpenSearch Contributors require contributions made to
        return value;
    /**
        } finally {
        assert lruLock.isHeldByCurrentThread();
            return hits;
        }
            }
            return Tuple.tuple(entry, existing);
        CompletableFuture<Entry<K, V>> completableFuture = new CompletableFuture<>();
}
            @Override
        long evictions = 0;
     */
                removalListener.onRemoval(removalNotification);
            return next != null;
 * @param <K> The type of the keys
                    onExpiration.accept(entry);
                return iterator.hasNext();
 *
        CacheSegment<K, V> segment = getCacheSegment(key);
                }
    // the state of an entry in the LRU list
 * license agreements. See the NOTICE file distributed with
        try {
                misses.increment();
    public Iterable<V> values() {
    private final Consumer<CompletableFuture<Entry<K, V>>> invalidationConsumer = f -> {
                        segment.map.remove(key);
    }
            return evictions;
            if (tuple.v2() != null && tuple.v2().state == State.EXISTING) {
            this.key = key;
         */
        }
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
        }
            }
    private long expireAfterWriteNanos = -1;
            Entry<K, V> entry = current;
     * @param key the key whose associated value is to be returned
    }
         * Builder for the {@link CacheStats} class.
    }
        try {
                // removing tail
    private void delete(Entry<K, V> entry, RemovalReason removalReason) {
                                return null;
         */
    /**
    }
/*
        SegmentStats segmentStats = new SegmentStats();
        return count;
import java.util.concurrent.ExecutionException;
        long now = now();
                    entry = future.get();
            }
                    removalNotifications = promote(ok, now).v2();
             * @return A new CacheStats instance.
        DELETED
 */
            public Builder evictions(long evictions) {
    /**
                }
        NEW,
                weight = 0;
     * only that segment's read lock, so this method never blocks cache reads, briefly blocks writes to a single
    @PublicApi(since = "1.0.0")
            }
        }
        };
        head = entry;
 * Evictions only occur after a mutation to the cache (meaning an entry promotion, a cache insertion, or a manual
        boolean replaced = false;
        Entry(K key, V value, long writeTime) {
            removalNotifications.add(new RemovalNotification<>(tuple.v2().key, tuple.v2().value, RemovalReason.REPLACED));
    }
            V loaded;
        long now = now();
import java.util.concurrent.CompletableFuture;
    public void invalidate(K key) {
                entry.before = null;
 * @opensearch.api
    // pkg-private for testing
            }
        } catch (InterruptedException e) {
        // we have to eagerly evict expired entries or our putIfAbsent call below will fail
    /**
                    break;
    public void invalidateAll() {
                before.after = after;
    private boolean exceedsWeight() {
                // removing inner element
    // the weight of the entries in the cache
    /**
            }
            if (ok != null) {
        }
        // we need to synchronize loading of a value for a given key; however, holding the segment lock while
        private CacheStats(Builder builder) {
         * expected value
        if (entry.state == State.EXISTING) {
        Entry<K, V> entry = segment.get(key, now, e -> isExpired(e, now), onExpiration);
        private long misses;
    // the removal callback
        if (segment != null) {
                    if (future != null) {
     */
                iterator.remove();
                return this;
     */
     *
         * pruned or a manual {@link Cache#refresh()} is performed however a caller can take action using the provided callback
    void setWeigher(ToLongBiFunction<K, V> weigher) {
import java.util.Map;
 * The design of the cache is relatively simple. The cache is segmented into 256 segments which are backed by HashMaps.
                    }
 * not use this file except in compliance with the License.
            }
    private void evict(long now) {
     *
     * notifications that the callers needs to handle.
        boolean promoted = true;
     * @opensearch.api
            }
        for (int i = 0; i < this.numberOfSegments; i++) {
                    if (segment != null) {
            private final LongAdder hits = new LongAdder();
        List<RemovalNotification<K, V>> removalNotifications = new ArrayList<>();
 * Unless required by applicable law or agreed to in writing,
    private V compute(K key, CacheLoader<K, V> loader) throws ExecutionException {
 */
         * @param key       the key of the entry to remove from the cache
     *
import java.util.List;
    }
            }
        // need a mechanism to ensure that load is invoked at most once, but we are not invoking load while holding
        try (ReleasableLock ignored = lruLock.acquire()) {
                        if (future.isDone()) {
    public CacheStats stats() {
            private final LongAdder evictions = new LongAdder();
                h = head;
        }
            count--;
    /**
                tail = before;
    Entry<K, V> tail;
                try {
    // the weigher of entries
        });
            this.numberOfSegments = NUMBER_OF_SEGMENTS;
 * KIND, either express or implied.  See the License for the
     * case the cache size is exceeding or the entry got expired.
 * compatible open source license.
            return false;
        entry.before = null;
            CompletableFuture<Entry<K, V>> future;
 * You may obtain a copy of the License at
     */
        CacheSegment<K, V> segment = getCacheSegment(key);
     * or may not reflect concurrent insertions and removals. Keys are copied one segment at a time while holding
                    linkAtHead(entry);
        }
                while (tail != null && shouldPrune(tail, now)) {
            if (promoted) {
import org.opensearch.common.util.concurrent.ReleasableLock;
                    current = null;
                haveSegmentLock[i] = true;
 * <p>
        return weight;
    // the maximum weight that this cache supports
            for (RemovalNotification<K, V> removalNotification : removalNotifications) {
 * </ol>
import java.util.HashMap;
            @Override
     * will be invoked at most once.
            boolean removed = false;
         * Provides a fluent API for constructing a CacheStats object.
 * evictions. The design goals for this cache were simplicity and read performance. This means that we are willing to
    private void linkAtHead(Entry<K, V> entry) {
 * under the License.
        // the segment lock; to do this, we atomically put a future in the map that can load the value, and then
        CacheSegment<K, V> segment = getCacheSegment(key);
    private void relinkAtHead(Entry<K, V> entry) {
            this.evictions = evictions;
            public CacheStats build() {
        }
    public void setMaximumWeight(long maximumWeight) {
            try (ReleasableLock ignored = readLock.acquire()) {
    }
        this.weigher = weigher;
                List<RemovalNotification<K, V>> removalNotifications = new ArrayList<>();
                try (ReleasableLock ignored = segment.writeLock.acquire()) {
        return numberOfSegments;
                onRemoval.accept(future);
            public void remove() {
 */
        CompletableFuture<Entry<K, V>> future;
            }
     * segment at a time, and does not acquire the LRU lock.
     * An LRU sequencing of the keys in the cache that supports removal. This sequence is not protected from mutations
                            if (Objects.equals(value, entry.value)) {
     */
    private final Consumer<CompletableFuture<Entry<K, V>>> removalConsumer = f -> {
            return misses;
            weight -= weigher.applyAsLong(entry.key, entry.value);
     * entries with {@link RemovalReason} INVALIDATED.
         * @param key       the key of the entry to get from the cache
                return this;
                    throw new IllegalStateException(e);
                }
        assert lruLock.isHeldByCurrentThread();
         * @param onRemoval a callback for the removed entry
 * <p>
     * @return the current cache statistics
                        removalListener.onRemoval(removalNotification);
     * {@link RemovalReason} INVALIDATED.
    /**
            } catch (Exception e) {
    // the number of entries in the cache
                this.misses = misses;
        return exceedsWeight() || isExpired(entry, now);
    }
            public V next() {
                future = map.get(key);
        }
        }
 *
    }
                return null;
     * Cache statistics
                    if (sanity != null && sanity.isCompletedExceptionally()) {
    }
                if (unlink(tuple.v2())) {
    /**
                    for (RemovalNotification<K, V> removalNotification : removalNotifications) {
                        }
    // positive if entries have an expiration after write
            }
        /**
                }
    }
 *
                this.evictions = evictions;
            h.before = entry;
            if (future.isCompletedExceptionally()) {
     * undefined.
                    removalListener.onRemoval(removalNotification);
    }
    private final int numberOfSegments;
        Objects.requireNonNull(weigher);
                try {
            }
                            }
         * @opensearch.internal
        public long getMisses() {
             * Creates a {@link CacheStats} object from the builder's current state.
        try (ReleasableLock ignored = lruLock.acquire()) {
            void miss() {
     *
                CacheSegment<K, V> segment = getCacheSegment(entry.key);
                    }
     * thrown during the execution of the first.
                evictions.increment();
            private CacheIterator iterator = new CacheIterator(head);
        if (entry == null) {
    private RemovalListener<K, V> removalListener = notification -> {};
                }
            /**
     * A CacheSegment is backed by a HashMap and is protected by a read/write lock.
     * @param loader the function to compute a value given a key
    private final ReleasableLock lruLock = new ReleasableLock(new ReentrantLock());
    /**
            @Override
            final Entry<K, V> after = entry.after;
     *
                    Entry<K, V> entryToBeRemoved = tail;
            public K next() {
    }
        public Entry<K, V> next() {
    }
 * here if write throughput is a concern.
        return (entriesExpireAfterAccess && now - entry.accessTime > expireAfterAccessNanos)
    // lock protecting mutations to the LRU list
    void setExpireAfterAccessNanos(long expireAfterAccessNanos) {
 * LRU list is protected by a lock that serializes all writes to it. There are opportunities for improvements
                }
        private long hits;
        while (tail != null && shouldPrune(tail, now)) {
        public static class Builder {
         *
 * The LRU functionality is backed by a single doubly-linked list chaining the entries in order of insertion. This
     * the key, the old value is replaced.
    /**
                    segmentStats.miss();
    }
            // must still fire so that listeners can account for the value the loader produced.
        BiFunction<? super Entry<K, V>, Throwable, ? extends V> handler = (ok, ex) -> {
    private class CacheIterator implements Iterator<Entry<K, V>> {
    protected long now() {
        }
    private void put(K key, V value, long now) {
                NullPointerException npe = new NullPointerException("loader returned a null value");
        long now = now();
        void remove(K key, Consumer<CompletableFuture<Entry<K, V>>> onRemoval) {
        Map<K, CompletableFuture<Entry<K, V>>> map = new HashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
        return keys;
                    delete(entry, RemovalReason.INVALIDATED);
     *
        if (value == null) {
            try (ReleasableLock ignored = writeLock.acquire()) {
    private boolean isExpired(Entry<K, V> entry, long now) {
import java.util.concurrent.atomic.LongAdder;
     * Force any outstanding size-based and time-based evictions to occur
     *
                            if (ok != null) {
 * A simple concurrent cache.
         * remove an entry from the segment
 * <ol>
                if (tail != null) {
         */
            } else {
        while (h != null) {
     */
/**
                segmentStats.eviction();
    /**
                } catch (ExecutionException e) {
                        removalNotifications.add(
            private CacheIterator iterator = new CacheIterator(head);
                head = after;
    private final CacheSegment<K, V>[] segments;
        for (int i = 0; i < segments.length; i++) {
            } else {
                    current = current.after;
                    segmentStats.miss();
        }
 * ownership. Elasticsearch licenses this file to you under
         */
        } else {
            try (ReleasableLock ignored = lruLock.acquire()) {
    }
    /**
        this.expireAfterAccessNanos = expireAfterAccessNanos;
            completableValue = future.handle(handler);
    void setRemovalListener(RemovalListener<K, V> removalListener) {
                    current.state = State.DELETED;
            // entry gets linked into the LRU list while absent from the segment map, where it is counted in
    }
                Entry<K, V> current = head;
    }
        for (CacheSegment<K, V> segment : segments) {
            private long hits = 0;
        CacheSegment<K, V> segment = getCacheSegment(entry.key);
        assert lruLock.isHeldByCurrentThread();
     * Invalidate the entry for the specified key and value. If the value provided is not equal to the value in
        ReleasableLock readLock = new ReleasableLock(segmentLock.readLock());
            }
     * @return the number of entries in the cache
         * @return a tuple of the new entry and the existing entry, if there was one otherwise null
     * @param key the key whose mapping is to be invalidated from the cache
        segment.remove(key, invalidationConsumer);
        try (ReleasableLock ignored = lruLock.acquire()) {
     * @opensearch.internal
        put(key, value, now);
        private long evictions;
    }
         */
            this.writeTime = this.accessTime = writeTime;
            this.misses = misses;
                return new CacheStats(this);
        if (!removalNotifications.isEmpty()) {
            @Override
    }
                }
    // positive if entries have an expiration
            if (future != null) {
            throw new IllegalStateException(e);
                                return ok;
        final boolean removed;
 * this work for additional information regarding copyright
     * The number of entries in the cache.
            removalListener.onRemoval(new RemovalNotification<>(entry.key, entry.value, removalReason));
     */
        this.entriesExpireAfterAccess = true;
    /**
                }
        // invoking load can lead to deadlock against another thread due to dependent key loading; therefore, we
    }
     *
                }
        if (expireAfterAccessNanos <= 0) {
    public void remove(K key) {
 * Each segment is protected by a re-entrant read/write lock. The read/write locks permit multiple concurrent readers
        /**
            @Override
        /**
                }
import java.util.Arrays;
        final K key;
            this.evictions = builder.evictions;
     */
import java.util.ArrayList;
     * entry with {@link RemovalReason} EXPLICIT.
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
    }
        Tuple<Entry<K, V>, Entry<K, V>> put(K key, V value, long now) {
            List<RemovalNotification<K, V>> removalNotifications = promote(entry, now).v2();
     * value using the given mapping function and enters it into this map unless null. The load method for a given key
            evictions += segments[i].segmentStats.evictions.longValue();
     * the cache, no removal will occur. A removal notification will be issued for invalidated
        }
        }
                delete(entry, RemovalReason.EXPLICIT);
            }
        }
            // check to ensure the future hasn't been completed with an exception
                    relinkAtHead(entry);
     * entries with {@link RemovalReason} INVALIDATED.
                    CacheSegment<K, V> segment = getCacheSegment(entryToBeRemoved.key);
                    replaced = true;
     * @param <K> the type of the keys
                case NEW:
         *
                    if (future != null) {
import java.util.Objects;
            completableValue = future.handle(handler);
         * Use {@link CacheStats} instead.
    };
            }
            CompletableFuture<Entry<K, V>> future;
        }
         * get an entry from the segment; expired entries will be returned as null but not removed from the cache until the LRU list is
            public void remove() {
        EXISTING,
         * put an entry into the segment
            }
     * Invalidate the association for the specified key. A removal notification will be issued for invalidated
                segments[i].segmentLock.writeLock().lock();
    public void invalidate(K key, V value) {
        }
     */
        Entry<K, V> h = head;
 * specific language governing permissions and limitations
 * <p>
         * @param now       the access time of this entry
        CompletableFuture<V> completableValue;
        return this.expireAfterAccessNanos;
        }
import java.util.function.BiFunction;
         * Segment statistics
                this.hits = hits;
            void eviction() {
    }
            public Builder hits(long hits) {
        }
    }
            private long misses = 0;
            this.hits = hits;
        if (replaced) {
                    }
     * @return the weight of the entries in the cache
            try (ReleasableLock ignored = lruLock.acquire()) {
     * they could be out-of-date mid-flight.
                if (isExpired.test(entry)) {
     * @param value the expected value that should be associated with the key
    static class Entry<K, V> {
                throw new ExecutionException(e);
            if (loaded == null) {
        count++;
                assert tail == entry;
            public boolean hasNext() {
    int getNumberOfSegments() {
        ReleasableLock writeLock = new ReleasableLock(segmentLock.writeLock());
            removed = unlink(entry);
        @Override
        public CacheStats(long hits, long misses, long evictions) {
        }
                Entry<K, V> entry;
            if (entry != null) {
            throw new IllegalArgumentException("expireAfterWriteNanos <= 0");
            return null;
        }
     * <p>
    }
        segment.remove(key, value, invalidationConsumer);
     * The relative time used to track time-based evictions.
     * <p>
        return segments[key.hashCode() & (this.numberOfSegments - 1)];
                    break;
                evictEntry(e);
        }
        }
                segmentStats.eviction();
            }
        V value;
    }
        return weigher;
        @Deprecated
            Entry<K, V> entry = f.get();
     */
    public long getMaximumWeight() {
            public boolean hasNext() {
         * @param value the value expected to be associated with the key
            // count()/weight() but is unreachable via get() and can no longer be invalidated by key. There is no
            }
            next = next.after;
            }
     * @return an LRU-ordered {@link Iterable} over the values in the cache
            // count/weight adjustment to make here because the entry was never linked, but the removal notification
        V value = get(key, now, e -> {
        @Override
            removalNotifications = promote(tuple.v1(), now).v2();
        private Entry<K, V> next;
         */
    /**
                    return entry;
    }
package org.opensearch.common.cache;
        segment.remove(key, removalConsumer);
     *
        return new Tuple<>(promoted, removalNotifications);
                    assert future.isCompletedExceptionally();
            private long evictions = 0;
        }
         */
        }
        public long getHits() {
     * @param key   key with which the specified value is to be associated
                    CompletableFuture<Entry<K, V>> future = map.put(key, CompletableFuture.completedFuture(entry));
         * @param builder The builder instance containing all the values.
    public Iterable<K> keys() {
        }
 * <li>LRU list mutations could be inserted into a blocking queue that a single thread is reading from
 * the Apache License, Version 2.0 (the "License"); you may
    }
        }
     */
                } else {
        }
            evictEntry(tail);
    private long maximumWeight = -1;
        return entriesExpireAfterAccess || entriesExpireAfterWrite ? System.nanoTime() : 0;
            }
/*
        if (removed) {
                onRemoval.accept(future);
                entry.after = null;
        }
            segment.remove(entry.key, entry.value, f -> {});
     * @return Returns a tuple. v1 signifies whether an entry got promoted, v2 signifies the list of removal
            }
            try (ReleasableLock ignored = segment.readLock.acquire()) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * invalidation) or an explicit call to {@link #refresh()}.
            next = head;
                future.completeExceptionally(npe);
                // removing the head
         * @param value the value of the entry to add to the cache
                } catch (ExecutionException | InterruptedException e) {
            throw new IllegalStateException(e);
     */
            } else {
                    if (unlink(entryToBeRemoved)) {
        /**
            this.segments[i] = new CacheSegment<>();
     * Removes the association for the specified key. A removal notification will be issued for removed
        }
import java.util.function.Consumer;
import org.opensearch.common.annotation.PublicApi;
            public Builder misses(long misses) {
    }
         * @return the entry if there was one, otherwise null
    void setExpireAfterWriteNanos(long expireAfterWriteNanos) {
        return get(key, now(), e -> {});
        }
 * software distributed under the License is distributed on an
                future = map.remove(key);
            }
        entry.state = State.EXISTING;
        public boolean hasNext() {
                try {
            future = completableFuture;
        }
     * loader function being called and the second will be returned the result provided by the first including any exceptions
                if (head != null) {
    private ToLongBiFunction<K, V> weigher = (k, v) -> 1;
        private static class SegmentStats {
    private long expireAfterAccessNanos = -1;
            return current;
            value = compute(key, loader);
        }
    /**
         * @param isExpired test if the entry is expired
    private boolean entriesExpireAfterAccess;
         * @param onRemoval a callback for the removed entry
    public void refresh() {
                after.before = before;
 */
        if (h == null) {
            try {
        try (ReleasableLock ignored = segment.writeLock.acquire()) {
            }
            public Builder() {}
    @SuppressWarnings("unchecked")
        }
    }
            @Override
     * consistent: it contains every key that was present in the cache for the entire duration of the call, and may
     * undefined.
    }
        this.expireAfterWriteNanos = expireAfterWriteNanos;
     */
    public static final int NUMBER_OF_SEGMENTS = 256;
         * @param key   the key of the entry to add to the cache
            current = null;
                    }
                return this;
                        existing = future.handle((ok, ex) -> {
                case DELETED:
        if (head != entry) {
        Entry<K, V> h;
        CacheSegment<K, V> segment = getCacheSegment(key);
        if (numberOfSegments != -1) {
        /**
                    throw new IllegalStateException(e);
    }
            }
            misses += segments[i].segmentStats.misses.longValue();
            }
import java.util.concurrent.locks.ReentrantLock;
        return maximumWeight != -1 && weight > maximumWeight;
        List<RemovalNotification<K, V>> removalNotifications = new ArrayList<>();
            removed = true;
        public long getEvictions() {
     * Associates the specified value with the specified key in this map. If the map previously contained a mapping for
        }
        }
            try (ReleasableLock ignored = lruLock.acquire()) {
            }
    // true if entries can expire after initial insertion
        } catch (InterruptedException e) {
    }
            evict(now);
     * Invalidate all cache entries. A removal notification will be issued for invalidated entries with
                try (ReleasableLock ignored = lruLock.acquire()) {
     * @param now the current time
        } else {
    public V computeIfAbsent(K key, CacheLoader<K, V> loader) throws ExecutionException {
     *
    }
    private CacheSegment<K, V> getCacheSegment(K key) {
                    entry.accessTime = now;
     * A cache segment.
                throw new ExecutionException(npe);
            // The entry was removed from the segment map before the thread that loaded it acquired the LRU lock to
                } catch (InterruptedException e) {
        return this.expireAfterWriteNanos;
     * @param entry Entry to be promoted
 * evictions are exposed.
        /**
         * Private constructor that takes a builder.
        } else {
        // use System.nanoTime because we want relative time, not absolute time
    }
            throw new IllegalArgumentException("maximumWeight < 0");
        assert lruLock.isHeldByCurrentThread();
            // ok
        };
        Entry<K, V> get(K key, long now, Predicate<Entry<K, V>> isExpired, Consumer<Entry<K, V>> onExpiration) {
 * <li>Locks on the list could be taken per node being modified instead of globally.</li>
            switch (entry.state) {
                }
 * @param <V> The type of the values
            tail = entry;
        entry.after = head;
        try {
import java.util.function.Predicate;
        }
            }
                future.get(); // call get to force the exception to be thrown for other concurrent callers
         *
            private final LongAdder misses = new LongAdder();
    }
        assert lruLock.isHeldByCurrentThread();
        }
         *
            }
        }
        boolean[] haveSegmentLock = new boolean[this.numberOfSegments];
                future.completeExceptionally(e);
                future.complete(new Entry<>(key, loaded, now));
import java.util.concurrent.locks.ReadWriteLock;
 *
     */
        List<K> keys = new ArrayList<>(count);
         * remove an entry from the segment iff the future is done and the value is equal to the
            this.value = value;
                }
     * to the cache (except for {@link Iterator#remove()}. The result of iteration under any other mutation is
        if (entry.state == State.NEW) {
     *
 * without contention, and the segments gives us write throughput without impacting readers (so readers are blocked only
        public void remove() {
        /**
                segmentStats.miss();
     * @return the current relative time
                    throw new IllegalStateException(e);
     * @param key the key whose mapping is to be removed from the cache
            h = h.after;
                return iterator.hasNext();
     * Use of different {@link CacheLoader} implementations on the same key concurrently may result in only the first
            this.misses = builder.misses;
        Entry<K, V> after;
    }
                return iterator.next().value;
                }
                    break;
         */
            throw new IllegalStateException(e);
@PublicApi(since = "1.0.0")
        return () -> new Iterator<K>() {
    private boolean unlink(Entry<K, V> entry) {
        @Override
 * Cache is a simple concurrent cache that supports time-based and weight-based evictions, with notifications for all
    long getExpireAfterAccessNanos() {
            Entry<K, V> entry = new Entry<>(key, value, now);
        }
 * if they are reading a segment that a writer is writing to).
                    segments[i].segmentLock.writeLock().unlock();
        long now = now();
             */
        }
     * @param <V> the type of the values
    Cache(final int numberOfSegments) {
                    tail.after = null;
     * @return the current (existing or computed) non-null value associated with the specified key
     */
    long getExpireAfterWriteNanos() {
                case EXISTING:
    private int count = 0;
         * This is the sole entry point for creating a new CacheStats object.
     */
     */
    private V get(K key, long now, Consumer<Entry<K, V>> onExpiration) {
            } else {
            if (before == null) {
                            new RemovalNotification<>(entryToBeRemoved.key, entryToBeRemoved.value, RemovalReason.EVICTED)
        // get the value from this future on the thread that won the race to place the future into the segment map
    public List<K> keysSnapshot() {
            this.numberOfSegments = numberOfSegments;
        } catch (ExecutionException e) {
     *
 * GitHub history for details.
    /**
    }
    }
     * The weight of the entries in the cache.
            } else {
                return null;
        }
            try (ReleasableLock ignored = writeLock.acquire()) {
     */
                Arrays.stream(segments).forEach(segment -> segment.map = new HashMap<>());
     * Entry in a cache
