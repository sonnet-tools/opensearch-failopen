            assert v >= 0 : "bytes=" + v;
            return map.isEmpty();
        // and one for the free space that is due to the fact hash tables can
        /**
        void adjustRam(long value) {
            return new Maps(current, VersionLookup.EMPTY, previousMapsNeededSafeAccess);
    Releasable acquireLock(BytesRef uid) {
    }
        return Collections.emptyList();
     * don't clear on refresh.
        public void updateMinDeletedTimestamp(DeleteVersionValue delete) {
    public void afterRefresh(boolean didRefresh) throws IOException {
        assert keyedLock.isHeldByCurrentThread(uid) : "Thread [" + Thread.currentThread().getName() + "], uid [" + uid.utf8ToString() + "]";
    }
            return map.get(key);
    }
        // is fine: it means they were actually already included in the previously opened reader, so we can still safely drop them in that
        final boolean isNotTrackedByCurrentMaps = versionValue.time < maps.getMinDeleteTimestamp();
        private VersionLookup(Map<BytesRef, VersionValue> map) {
    void putDeleteUnderLock(BytesRef uid, DeleteVersionValue version) {
     * In this base value, we account for the {@link BytesRef} object itself as
            return value;
        int size() {
    /**
        private final AtomicLong minDeleteTimestamp = new AtomicLong(Long.MAX_VALUE);
                    }
        // case. This is because we assign new maps (in beforeRefresh) slightly before Lucene actually flushes any segments for the
    /** Iterates over all deleted versions, including new ones (not yet exposed via reader) and old ones
        return keyedLock.acquire(uid);
        // version value can't be removed it's
     * Adds this uid/version to the pending adds map iff the map needs safe access.
         * Builds a new map for the refresh transition this should be called in beforeRefresh()
     */
        }
            assert putAssertionMap(uid, version);
        return maps.current.ramBytesUsed.get();
        // reflected in the previous reader. We don't touch tombstones here: they expire on their own index.gc_deletes timeframe:
            minDeleteTimestamp.updateAndGet(prev -> Math.min(time, prev));
 * The OpenSearch Contributors require contributions made to
    // we maintain a second map that only receives the updates that we skip on the actual map (unsafe ops)
 *
    }
        return getUnderLock(uid, maps);
                    // if we do use a blocking acquire. see #28714
     * to object alignment. So consumers of this constant just have to add the
            );
        return true;
    private static final long BASE_BYTES_PER_CHM_ENTRY;
                        final DeleteVersionValue versionValue = tombstones.get(uid);
    @Override
        // this is not volatile since we don't need to maintain a happens before relation ship across doc IDs so it's enough to
        }
        // check if the value is old enough and safe to be removed
        }
    synchronized void clear() {
        assert assertKeyedLockHeldByCurrentThread(uid);
            if (previousValue != null) {
        assert uid.bytes.length == uid.length : "Oversized _uid! UID length: " + uid.length + ", bytes length: " + uid.bytes.length;
            VersionValue previousValue = current.remove(uid);
        }
    }
            assert prev.isDelete();
     * well as the header of the byte[] array it holds, and some lost bytes due
     */
    /**
                // we also need to remove it from the old map here to make sure we don't read this stale value while
    }
            // we do check before we actually lock the key - this way we don't need to acquire the lock for tombstones that are not
    public Collection<Accountable> getChildResources() {
    /**
    }
 * license agreements. See the NOTICE file distributed with
            VersionValue previousValue = current.put(uid, version);
 * not use this file except in compliance with the License.
 *
        }
        // not be fully loaded
            current.updateMinDeletedTimestamp(deleted);
        RamUsageEstimator.shallowSizeOfInstance(BytesRef.class) +
    /**
        // if the version map is in safeAccess mode we track all version in the version map. yet if a document comes in that needs
 * compatible open source license.
        }
        }
            }
    private volatile Maps unsafeKeysMap = new Maps();
        // we hold the ID lock in the engine while we do all this it's safe to do it globally unlocked.
    }
        // Used while refresh is running, and to hold adds/deletes until refresh finishes. We read from both current and old on lookup:
     * @opensearch.internal
package org.opensearch.index.engine;
        if (accountRam != 0) {
    }
        // We can now drop old because these operations are now visible via the newly opened searcher. Even if didRefresh is false, which
        }
     *
            accountRam -= (BASE_BYTES_PER_CHM_ENTRY + prevTombstone.ramBytesUsed() + uidRAMBytesUsed);
    }
        final VersionLookup current;
            maps.current.markAsUnsafe();
        assert (unsafeKeysMap = unsafeKeysMap.invalidateOldMap()) != null;
    }
        assert uid.bytes.length == uid.length : "Oversized _uid! UID length: " + uid.length + ", bytes length: " + uid.bytes.length;
     * Bytes used by having CHM point to a key/value.
     * Looks up document version
 * Maps _uid value to its version information.
        long getMinDeleteTimestamp() {
            long v = ramBytesUsedTombstones.addAndGet(-(BASE_BYTES_PER_CHM_ENTRY + prev.ramBytesUsed() + uidRAMBytesUsed));
 */
            ramAccounting += previousValue == null ? 0 : -(BASE_BYTES_PER_CHM_ENTRY + previousValue.ramBytesUsed() + uidRAMBytesUsed);
 * KIND, either express or implied.  See the License for the
 */
     * Bytes consumed for each BytesRef UID:
    VersionValue getUnderLock(final BytesRef uid) {
    @Override
 *
        // means Lucene did not actually open a new reader because it detected no changes, it's possible old has some entries in it, which
                long uidRAMBytesUsed = BASE_BYTES_PER_BYTESREF + uid.bytes.length;
    static {
            putIndexUnderLock(uid, version);
        }
 * specific language governing permissions and limitations
        /** Tracks bytes used by current map, i.e. what is freed on refresh. For deletes, which are also added to tombstones,
    Map<BytesRef, DeleteVersionValue> getAllTombstones() {
        // the memory pressure significantly for this use-case where we often get a massive amount of small document (metrics).
        public VersionValue remove(BytesRef uid) {
        // map reference itself.
                        }
    @Override
        // the tombstone
            return map.remove(uid);
        /**
        // minimum timestamp of delete operations that were made while this map was active. this is used to make sure they are kept in
        boolean needsSafeAccess;
         * builds a new map that invalidates the old map but maintains the current. This should be called in afterRefresh()
        assert assertKeyedLockHeldByCurrentThread(uid);
    public long ramBytesUsed() {
 * GitHub history for details.
        long accountRam = (BASE_BYTES_PER_CHM_ENTRY + version.ramBytesUsed() + uidRAMBytesUsed);
                        if (versionValue != null) {
            // we should still remove any previous delete for this uuid (avoid accidental accesses).
            return value;
            return map.put(key, value);
                    if (lock != null) { // did we get the lock?
import java.util.Collection;
    // this map is only maintained if assertions are enabled
    /**
        unsafeKeysMap.put(uid, version);
                assert v >= 0 : "bytes=" + v;
    public void beforeRefresh() throws IOException {
            this(new VersionLookup(ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency()), VersionLookup.EMPTY, false);
                old.remove(uid);
        maps = maps.buildTransitionMap();
            this.old = old;
        value = currentMaps.old.get(uid);
     */
        // index is being closed:
     *
        // use the same impl as the Maps does
        // respect that and fill the version map. The nice part here is that we are only really requiring this for a single ID and since
    // All deletes also go here, and delete "tombstones" are retained after refresh:
        tombstones.clear();
                // we are in the middle of a refresh. Most of the time the old map is an empty map so we can skip it there.
 * ownership. Elasticsearch licenses this file to you under
        }
            }
    /**
    }
        maps.put(uid, version);
     * Returns the current internal versions as a point in time snapshot
        final VersionLookup old;
            return needsSafeAccess || previousMapsNeededSafeAccess;
        // where we know that documents can't have any duplicates so we can skip the version map entirely. This reduces
    private static final class VersionLookup {
        maps.remove(uid, version);
        assert assertKeyedLockHeldByCurrentThread(uid);
        return tombstones;
    }
            // we won't collect the tombstone below since it must be newer than this one.
    private final AtomicLong ramBytesUsedTombstones = new AtomicLong();
        // reopen, and so any concurrent indexing requests can still sneak in a few additions to that current map that are in fact
        final VersionValue prevTombstone = tombstones.put(uid, version);
        VersionValue put(BytesRef key, VersionValue value) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // for each entry, we need two object refs, one for the entry itself
}
        long uidRAMBytesUsed = BASE_BYTES_PER_BYTESREF + uid.bytes.length;
        if (prev != null) {
    private static final long BASE_BYTES_PER_BYTESREF =
            final boolean mapHasNotSeenAnyOperations = current.isEmpty() && current.isUnsafe() == false;
        assert assertKeyedLockHeldByCurrentThread(uid);
        if (value != null) {
        } else {
                final BytesRef uid = entry.getKey();
            // Not this should not hurt performance because the tombstone is small (or empty) when unsafe is relevant.
import org.apache.lucene.util.Accountable;
     * Removes this uid from the pending deletes map.
        for (Map.Entry<BytesRef, DeleteVersionValue> entry : tombstones.entrySet()) {
    /**
    }
                    // we use tryAcquire here since this is a best effort and we try to be least disruptive
    }
     */
    }
            this.previousMapsNeededSafeAccess = previousMapsNeededSafeAccess;
            return new Maps(
        private boolean unsafe;
        maps = maps.invalidateOldMap();
 * You may obtain a copy of the License at
         *  we only account for the CHM entry here, and account for BytesRef/VersionValue against the tombstones, since refresh would not
        private static final VersionLookup EMPTY = new VersionLookup(Collections.emptyMap());
    VersionValue getVersionForAssert(final BytesRef uid) {
        Maps() {
                }
        // Deduct tombstones bytes used for the version we just removed or replaced:
    }
        }
     * Returns how much RAM is current being freed up by refreshing.  This is {@link #ramBytesUsed()}
            if (canRemoveTombstone(maxTimestampToPrune, maxSeqNoToPrune, entry.getValue())) {
            long v = ramBytesUsedTombstones.addAndGet(accountRam);
         */
            }
        // header of the byte[] array
     * Returns how much RAM would be freed up by refreshing. This is {@link #ramBytesUsed} except does not include tombstones because they
final class LiveVersionMap implements ReferenceManager.RefreshListener, Accountable {
        }
        }
 * @opensearch.internal
        final AtomicLong ramBytesUsed = new AtomicLong();
            removeTombstoneUnderLock(uid);
        void remove(BytesRef uid, DeleteVersionValue deleted) {
     * length of the byte[] (assuming it is not shared between multiple
    long ramBytesUsedForRefresh() {
        // ramBytesUsedTombstones.set(0);
import org.opensearch.common.util.concurrent.KeyedLock;
    }
import java.io.IOException;
     * except does not include tombstones because they don't clear on refresh.
import org.apache.lucene.util.BytesRef;
            long time = delete.time;
        // current searcher:
            // with an alignment size (-XX:ObjectAlignmentInBytes) of 8 (default),
    /**
     * Tracks bytes used by tombstones (deletes)
 *    http://www.apache.org/licenses/LICENSE-2.0
        private final Map<BytesRef, VersionValue> map;
import org.apache.lucene.util.RamUsageEstimator;
        assert assertKeyedLockHeldByCurrentThread(uid);
    }
            // prune-able. If the tombstone changes concurrently we will re-read and step out below since if we can't collect it now w
    private void putTombstone(BytesRef uid, DeleteVersionValue version) {
     */
                try (Releasable lock = keyedLock.tryAcquire(uid)) {
        return maps.current.ramBytesUsed.get() + ramBytesUsedTombstones.get();
                        // Must re-get it here, vs using entry.getValue(), in case the uid was indexed/deleted since we pulled the iterator:
import java.util.Collections;
import org.opensearch.common.util.concurrent.ConcurrentCollections;
    }
    void pruneTombstones(long maxTimestampToPrune, long maxSeqNoToPrune) {
        if (value == null) {
        return tombstones.get(uid);
        BASE_BYTES_PER_CHM_ENTRY = chmEntryShallowSize + 2 * RamUsageEstimator.NUM_BYTES_OBJECT_REF;
     * @see KeyedLock
    void removeTombstoneUnderLock(BytesRef uid) {
     * Try to prune tombstones whose timestamp is less than maxTimestampToPrune and seqno at most the maxSeqNoToPrune.
        if (maps.isSafeAccessMode()) {
    void putIndexUnderLock(BytesRef uid, IndexVersionValue version) {
        // This is not 100% correct, since concurrent indexing ops can change these counters in between our execution of the previous
            if (value != 0) {
        // NOTE: we can't zero this here, because a refresh thread could be calling InternalEngine.pruneDeletedTombstones at the same time,
            long ramAccounting = BASE_BYTES_PER_CHM_ENTRY + version.ramBytesUsed() + uidRAMBytesUsed;
 * software distributed under the License is distributed on an
        map.put(0, 0);
            value = getUnderLock(uid, unsafeKeysMap);
     */
    void enforceSafeAccess() {
    private VersionValue getUnderLock(final BytesRef uid, Maps currentMaps) {
        maps.needsSafeAccess = true;
     * Returns the live version (add or delete) for this uid.
            assert v >= 0 : "bytes=" + v;
            }
    }
            return map.size();
        // All writes (adds and deletes) go into here:
 * SPDX-License-Identifier: Apache-2.0
        boolean isUnsafe() {
        final boolean previousMapsNeededSafeAccess;
    private volatile Maps maps = new Maps();
            RamUsageEstimator.NUM_BYTES_ARRAY_HEADER +
import org.apache.lucene.search.ReferenceManager;
 * Unless required by applicable law or agreed to in writing,
        // that will prevent concurrent updates to the same document ID and therefore we can rely on the happens-before guanratee of the
        // Also enroll the delete into tombstones, and account for its RAM too:
        // First try to get the "live" value:
        return true;
    boolean assertKeyedLockHeldByCurrentThread(BytesRef uid) {
    /**
    private static final class Maps {
        // safe access but we are not in this mode we force a refresh and make the map as safe access required. All subsequent ops will
            3;
        void markAsUnsafe() {
        // each version map has a notion of safe / unsafe which allows us to apply certain optimization in the auto-generated ID usecase
    boolean isSafeAccessRequired() {
                long v = current.ramBytesUsed.addAndGet(value);
            adjustRam(ramAccounting);
        VersionValue get(BytesRef key) {
    }
                    // this method is also called under lock in the engine under certain situations such that this can lead to deadlocks
/**
     * Called when this index is closed.
 */
/*
        }
            long uidRAMBytesUsed = BASE_BYTES_PER_BYTESREF + uid.bytes.length;
        VersionValue value = currentMaps.current.get(uid);
        Maps buildTransitionMap() {
    /**
            this.current = current;
        // and this will lead to an assert trip. Presumably it's fine if our ramBytesUsedTombstones is non-zero after clear since the
        Maps maps = this.maps;
        }
        // line and this one, but that should be minor, and the error won't accumulate over time:
    private boolean canRemoveTombstone(long maxTimestampToPrune, long maxSeqNoToPrune, DeleteVersionValue versionValue) {
        }
 * Licensed to Elasticsearch under one or more contributor
     * this lock to be hold by the caller otherwise the visibility guarantees of this version
        final VersionValue prev = tombstones.remove(uid);
     * @opensearch.internal
        Maps(VersionLookup current, VersionLookup old, boolean previousMapsNeededSafeAccess) {
        long chmEntryShallowSize = RamUsageEstimator.shallowSizeOf(map.entrySet().iterator().next());
        boolean isEmpty() {
        }
            // Even though we don't store a record of the indexing operation (and mark as unsafe),
        Map<Integer, Integer> map = ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();
         */
        maps = new Maps();
        boolean isSafeAccessMode() {
     */
 * Modifications Copyright OpenSearch Contributors. See
    /**
                shouldInheritSafeAccess()
        boolean shouldInheritSafeAccess() {
        // NOTE: these values can both be non-volatile since it's ok to read a stale value per doc ID. We serialize changes in the engine
 * this file be licensed under the Apache-2.0 license or a
     * Map of version lookups
                            }
    }
        // map. While reopen is running, any lookup will first
                // we haven't seen any ops and map before needed it so we maintain it
        assert uid.bytes.length == uid.length : "Oversized _uid! UID length: " + uid.length + ", bytes length: " + uid.bytes.length;
                                removeTombstoneUnderLock(uid);
        }
    }
         *  clear this RAM. */
     */
        // shallow memory usage of the BytesRef object
        }
/*
import java.util.Map;
    private final KeyedLock<BytesRef> keyedLock = new KeyedLock<>();
                new VersionLookup(ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency(current.size())),
     * instances).
import java.util.concurrent.atomic.AtomicLong;
        }
                current,
    /**
    long getRefreshingBytes() {
        return maps.old.ramBytesUsed.get();
 * the Apache License, Version 2.0 (the "License"); you may
                || (mapHasNotSeenAnyOperations && previousMapsNeededSafeAccess);
        if (value != null) {
     */
            unsafe = true;
 * under the License.
     */
        final boolean isTooOld = versionValue.time < maxTimestampToPrune;
        }
/*
        }
import org.opensearch.common.lease.Releasable;
        VersionValue value = getUnderLock(uid, maps);
    void maybePutIndexUnderLock(BytesRef uid, IndexVersionValue version) {
            // lost bytes on average
     * Acquires a releaseable lock for the given uId. All *UnderLock methods require
        return isTooOld && isSafeToPrune && isNotTrackedByCurrentMaps;
     *  (exposed via reader but not yet GC'd). */
        }
        removeTombstoneUnderLock(uid);
        Maps invalidateOldMap() {
        }
    private final Map<BytesRef, DeleteVersionValue> tombstones = ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();
    /**
    /**
        putTombstone(uid, version);
        assert assertKeyedLockHeldByCurrentThread(uid);
    boolean isUnsafe() {
     * map are broken. We assert on this lock to be hold when calling these methods.
     */
        assert (unsafeKeysMap = unsafeKeysMap.buildTransitionMap()) != null;
        // assume a load factor of 50%
 *
        return value;
        void put(BytesRef uid, VersionValue version) {
     */
        long uidRAMBytesUsed = BASE_BYTES_PER_BYTESREF + uid.bytes.length;
    Map<BytesRef, VersionValue> getAllCurrent() {
        // not yet flushed to lucene ie. it's part of this current maps object
        }
            // there could be between 0 and 7 lost bytes, so we account for 3
        // Start sending all updates after this point to the new
        return maps.isSafeAccessMode();
            this.map = map;
 */
        // try this new map, then fallback to old, then to the
        }
        // have the volatile read of the Maps reference to make it visible even across threads.
    }
        if (prevTombstone != null) {
    }
            return unsafe;
     */
            if (old != VersionLookup.EMPTY) {
        return maps.current.map;
     */
    @Override
                adjustRam(-(BASE_BYTES_PER_CHM_ENTRY + previousValue.ramBytesUsed() + uidRAMBytesUsed));
        }
    }
            return needsSafeAccess
                            if (canRemoveTombstone(maxTimestampToPrune, maxSeqNoToPrune, versionValue)) {
        // TODO: useful to break down RAM usage here?
        final boolean isSafeToPrune = versionValue.seqNo <= maxSeqNoToPrune;
    }
 * this work for additional information regarding copyright
    private boolean putAssertionMap(BytesRef uid, IndexVersionValue version) {
            return Math.min(current.minDeleteTimestamp.get(), old.minDeleteTimestamp.get());
        return maps.current.isUnsafe() || maps.old.isUnsafe();
