            );  
    }  
    @Override
 */
        // we hold the ID lock in the engine while we do all this it's safe to do it globally unlocked.  
        // minimum timestamp of delete operations that were made while this map was active. this is used to make sure they are kept in  
        }
        for (Map.Entry<BytesRef, DeleteVersionValue> entry : tombstones.entrySet()) {  
         * builds a new map that invalidates the old map but maintains the current. This should be called in afterRefresh()
 * Unless required by applicable law or agreed to in writing,
                    }  
    Releasable acquireLock(BytesRef uid) {
     */
        // TODO: useful to break down RAM usage here?
 * @opensearch.internal  
                        if (versionValue != null) {
    }
        // We can now drop old because these operations are now visible via the newly opened searcher. Even if didRefresh is false, which
     * Returns the live version (add or delete) for this uid.
            // we should still remove any previous delete for this uuid (avoid accidental accesses).  
        return getUnderLock(uid, maps);
 * under the License.  
    // we maintain a second map that only receives the updates that we skip on the actual map (unsafe ops)  
        assert keyedLock.isHeldByCurrentThread(uid) : "Thread [" + Thread.currentThread().getName() + "], uid [" + uid.utf8ToString() + "]";  
        void adjustRam(long value) {  
    }
        if (value == null) {
     * Map of version lookups
        }
         */  
                assert v >= 0 : "bytes=" + v;  
            if (value != 0) {
        // map. While reopen is running, any lookup will first
        }
    Map<BytesRef, DeleteVersionValue> getAllTombstones() {  
        // assume a load factor of 50%
    }  
    /**
            long uidRAMBytesUsed = BASE_BYTES_PER_BYTESREF + uid.bytes.length;
                || (mapHasNotSeenAnyOperations && previousMapsNeededSafeAccess);
        // and this will lead to an assert trip. Presumably it's fine if our ramBytesUsedTombstones is non-zero after clear since the
                // we are in the middle of a refresh. Most of the time the old map is an empty map so we can skip it there.
            unsafe = true;
        VersionValue value = currentMaps.current.get(uid);
    public void beforeRefresh() throws IOException {  
                long v = current.ramBytesUsed.addAndGet(value);
    }
        final VersionValue prevTombstone = tombstones.put(uid, version);
            long ramAccounting = BASE_BYTES_PER_CHM_ENTRY + version.ramBytesUsed() + uidRAMBytesUsed;  
        void remove(BytesRef uid, DeleteVersionValue deleted) {
            return new Maps(
            long v = ramBytesUsedTombstones.addAndGet(-(BASE_BYTES_PER_CHM_ENTRY + prev.ramBytesUsed() + uidRAMBytesUsed));
    Map<BytesRef, VersionValue> getAllCurrent() {  
        }
        return isTooOld && isSafeToPrune && isNotTrackedByCurrentMaps;
import org.opensearch.common.util.concurrent.KeyedLock;
        }
        // version value can't be removed it's
        int size() {
            }
                            if (canRemoveTombstone(maxTimestampToPrune, maxSeqNoToPrune, versionValue)) {
 * this file be licensed under the Apache-2.0 license or a
    void pruneTombstones(long maxTimestampToPrune, long maxSeqNoToPrune) {
import org.apache.lucene.util.RamUsageEstimator;
 * You may obtain a copy of the License at  
        VersionValue put(BytesRef key, VersionValue value) {  
        // use the same impl as the Maps does
            return map.put(key, value);
        // line and this one, but that should be minor, and the error won't accumulate over time:
        assert assertKeyedLockHeldByCurrentThread(uid);  
    private volatile Maps maps = new Maps();
     */
     *
        }
 * software distributed under the License is distributed on an
        assert uid.bytes.length == uid.length : "Oversized _uid! UID length: " + uid.length + ", bytes length: " + uid.bytes.length;
    }
        boolean needsSafeAccess;
            }
    }
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
        Maps(VersionLookup current, VersionLookup old, boolean previousMapsNeededSafeAccess) {
        BASE_BYTES_PER_CHM_ENTRY = chmEntryShallowSize + 2 * RamUsageEstimator.NUM_BYTES_OBJECT_REF;  
    /**  
        private boolean unsafe;
            return map.isEmpty();
        // ramBytesUsedTombstones.set(0);  
    }  
                shouldInheritSafeAccess()
        // Used while refresh is running, and to hold adds/deletes until refresh finishes. We read from both current and old on lookup:
        }  
        maps.put(uid, version);
        assert assertKeyedLockHeldByCurrentThread(uid);
 * ownership. Elasticsearch licenses this file to you under  
    }
    long ramBytesUsedForRefresh() {  
import org.apache.lucene.util.Accountable;
     */
        value = currentMaps.old.get(uid);
                try (Releasable lock = keyedLock.tryAcquire(uid)) {  
        }
                // we haven't seen any ops and map before needed it so we maintain it  
         *  we only account for the CHM entry here, and account for BytesRef/VersionValue against the tombstones, since refresh would not
     * Try to prune tombstones whose timestamp is less than maxTimestampToPrune and seqno at most the maxSeqNoToPrune.  
    void maybePutIndexUnderLock(BytesRef uid, IndexVersionValue version) {
            // with an alignment size (-XX:ObjectAlignmentInBytes) of 8 (default),
    }
        // is fine: it means they were actually already included in the previously opened reader, so we can still safely drop them in that  
        final boolean previousMapsNeededSafeAccess;
        putTombstone(uid, version);
        long uidRAMBytesUsed = BASE_BYTES_PER_BYTESREF + uid.bytes.length;  
 *
        // NOTE: these values can both be non-volatile since it's ok to read a stale value per doc ID. We serialize changes in the engine
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
        // Start sending all updates after this point to the new
        final AtomicLong ramBytesUsed = new AtomicLong();
    }
        // shallow memory usage of the BytesRef object
    }
    /**
    /**
            assert v >= 0 : "bytes=" + v;
            // Not this should not hurt performance because the tombstone is small (or empty) when unsafe is relevant.
        maps = new Maps();
            final boolean mapHasNotSeenAnyOperations = current.isEmpty() && current.isUnsafe() == false;
            adjustRam(ramAccounting);  
        Maps() {
        public void updateMinDeletedTimestamp(DeleteVersionValue delete) {  
    boolean assertKeyedLockHeldByCurrentThread(BytesRef uid) {
     * map are broken. We assert on this lock to be hold when calling these methods.
        // the tombstone
        }  
        // not yet flushed to lucene ie. it's part of this current maps object  
        VersionValue get(BytesRef key) {
import org.apache.lucene.search.ReferenceManager;
        }  
        // for each entry, we need two object refs, one for the entry itself  
        if (prev != null) {  
 * the Apache License, Version 2.0 (the "License"); you may
            this.previousMapsNeededSafeAccess = previousMapsNeededSafeAccess;
    private static final class VersionLookup {
            long v = ramBytesUsedTombstones.addAndGet(accountRam);  
        if (maps.isSafeAccessMode()) {
    }
                final BytesRef uid = entry.getKey();
        return value;
        // this is not volatile since we don't need to maintain a happens before relation ship across doc IDs so it's enough to
        final boolean isTooOld = versionValue.time < maxTimestampToPrune;  
        // that will prevent concurrent updates to the same document ID and therefore we can rely on the happens-before guanratee of the
    /**
 */  
        map.put(0, 0);  
        assert assertKeyedLockHeldByCurrentThread(uid);  
    }
        final boolean isSafeToPrune = versionValue.seqNo <= maxSeqNoToPrune;
        }
            // there could be between 0 and 7 lost bytes, so we account for 3  
        tombstones.clear();
        /** Tracks bytes used by current map, i.e. what is freed on refresh. For deletes, which are also added to tombstones,
        }
        return maps.current.isUnsafe() || maps.old.isUnsafe();  
    private static final long BASE_BYTES_PER_BYTESREF =  
     * except does not include tombstones because they don't clear on refresh.  
    }
        assert assertKeyedLockHeldByCurrentThread(uid);  
        // reopen, and so any concurrent indexing requests can still sneak in a few additions to that current map that are in fact
    private static final long BASE_BYTES_PER_CHM_ENTRY;
            // we do check before we actually lock the key - this way we don't need to acquire the lock for tombstones that are not
    /** Iterates over all deleted versions, including new ones (not yet exposed via reader) and old ones
    /**  
            }  
 * GitHub history for details.
        // case. This is because we assign new maps (in beforeRefresh) slightly before Lucene actually flushes any segments for the
    /**  
     */
        // current searcher:
                // we also need to remove it from the old map here to make sure we don't read this stale value while  
    @Override  
/*  
     * Acquires a releaseable lock for the given uId. All *UnderLock methods require
            return value;
        maps = maps.buildTransitionMap();
        }  
        }
        if (accountRam != 0) {
        assert assertKeyedLockHeldByCurrentThread(uid);
        return tombstones.get(uid);  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * In this base value, we account for the {@link BytesRef} object itself as  
            this(new VersionLookup(ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency()), VersionLookup.EMPTY, false);
 * Modifications Copyright OpenSearch Contributors. See
            if (previousValue != null) {
    synchronized void clear() {  
        void put(BytesRef uid, VersionValue version) {
        assert (unsafeKeysMap = unsafeKeysMap.invalidateOldMap()) != null;  
                                removeTombstoneUnderLock(uid);  
            maps.current.markAsUnsafe();  
    }  
    }
        boolean isEmpty() {
        VersionValue value = getUnderLock(uid, maps);
        final boolean isNotTrackedByCurrentMaps = versionValue.time < maps.getMinDeleteTimestamp();
            removeTombstoneUnderLock(uid);
        // respect that and fill the version map. The nice part here is that we are only really requiring this for a single ID and since
     */
            return map.remove(uid);  
         *  clear this RAM. */  
     * this lock to be hold by the caller otherwise the visibility guarantees of this version  
        return true;
        // Deduct tombstones bytes used for the version we just removed or replaced:
     */
        // safe access but we are not in this mode we force a refresh and make the map as safe access required. All subsequent ops will
    private void putTombstone(BytesRef uid, DeleteVersionValue version) {
        // each version map has a notion of safe / unsafe which allows us to apply certain optimization in the auto-generated ID usecase  
     * Tracks bytes used by tombstones (deletes)
            // prune-able. If the tombstone changes concurrently we will re-read and step out below since if we can't collect it now w
        return maps.current.ramBytesUsed.get();
        // check if the value is old enough and safe to be removed
     *  (exposed via reader but not yet GC'd). */
        // Also enroll the delete into tombstones, and account for its RAM too:
     * don't clear on refresh.
        return maps.isSafeAccessMode();
     * Called when this index is closed.
            return map.size();  
            minDeleteTimestamp.updateAndGet(prev -> Math.min(time, prev));
    /**
        // if the version map is in safeAccess mode we track all version in the version map. yet if a document comes in that needs  
        // the memory pressure significantly for this use-case where we often get a massive amount of small document (metrics).
        long accountRam = (BASE_BYTES_PER_CHM_ENTRY + version.ramBytesUsed() + uidRAMBytesUsed);  
     * Returns the current internal versions as a point in time snapshot
        maps.needsSafeAccess = true;
        assert uid.bytes.length == uid.length : "Oversized _uid! UID length: " + uid.length + ", bytes length: " + uid.bytes.length;
     * @opensearch.internal
    /**
     * Adds this uid/version to the pending adds map iff the map needs safe access.  
 * compatible open source license.
         */
        final VersionLookup current;  
        // where we know that documents can't have any duplicates so we can skip the version map entirely. This reduces
 * Licensed to Elasticsearch under one or more contributor  
        Maps buildTransitionMap() {
            VersionValue previousValue = current.remove(uid);
    boolean isUnsafe() {
        long chmEntryShallowSize = RamUsageEstimator.shallowSizeOf(map.entrySet().iterator().next());
        boolean shouldInheritSafeAccess() {  
    private volatile Maps unsafeKeysMap = new Maps();
        /**  
        if (value != null) {
    }  
        Map<Integer, Integer> map = ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();
        // This is not 100% correct, since concurrent indexing ops can change these counters in between our execution of the previous
        return Collections.emptyList();  
                        final DeleteVersionValue versionValue = tombstones.get(uid);  
    }  
            VersionValue previousValue = current.put(uid, version);
     */  
     * to object alignment. So consumers of this constant just have to add the
        assert (unsafeKeysMap = unsafeKeysMap.buildTransitionMap()) != null;  
    /**  
        // NOTE: we can't zero this here, because a refresh thread could be calling InternalEngine.pruneDeletedTombstones at the same time,  
        }
            assert putAssertionMap(uid, version);
 */
    private boolean canRemoveTombstone(long maxTimestampToPrune, long maxSeqNoToPrune, DeleteVersionValue versionValue) {
        return tombstones;
        /**
            this.current = current;
        long getMinDeleteTimestamp() {  
 * license agreements. See the NOTICE file distributed with
                        // Must re-get it here, vs using entry.getValue(), in case the uid was indexed/deleted since we pulled the iterator:
    private VersionValue getUnderLock(final BytesRef uid, Maps currentMaps) {
import java.util.Collections;
        }
        // means Lucene did not actually open a new reader because it detected no changes, it's possible old has some entries in it, which
                    if (lock != null) { // did we get the lock?
                old.remove(uid);
        public VersionValue remove(BytesRef uid) {
    private final KeyedLock<BytesRef> keyedLock = new KeyedLock<>();
        private final AtomicLong minDeleteTimestamp = new AtomicLong(Long.MAX_VALUE);
            this.old = old;  
        }
/*
        // have the volatile read of the Maps reference to make it visible even across threads.  
    private final AtomicLong ramBytesUsedTombstones = new AtomicLong();  
 * KIND, either express or implied.  See the License for the
import java.util.concurrent.atomic.AtomicLong;
                new VersionLookup(ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency(current.size())),  
     * Returns how much RAM is current being freed up by refreshing.  This is {@link #ramBytesUsed()}
            assert v >= 0 : "bytes=" + v;  
}  
            return Math.min(current.minDeleteTimestamp.get(), old.minDeleteTimestamp.get());
        void markAsUnsafe() {
            }
            accountRam -= (BASE_BYTES_PER_CHM_ENTRY + prevTombstone.ramBytesUsed() + uidRAMBytesUsed);  
        return maps.current.map;
     */
            putIndexUnderLock(uid, version);  
        Maps invalidateOldMap() {  
        unsafeKeysMap.put(uid, version);  
        RamUsageEstimator.shallowSizeOfInstance(BytesRef.class) +
 * this work for additional information regarding copyright
    private static final class Maps {  
import java.io.IOException;  
    }  
    @Override  
    void putDeleteUnderLock(BytesRef uid, DeleteVersionValue version) {
            return value;  
        }
        }
    public long ramBytesUsed() {
                    // this method is also called under lock in the engine under certain situations such that this can lead to deadlocks
     * Removes this uid from the pending deletes map.  
        if (value != null) {  
            if (old != VersionLookup.EMPTY) {
            ramAccounting += previousValue == null ? 0 : -(BASE_BYTES_PER_CHM_ENTRY + previousValue.ramBytesUsed() + uidRAMBytesUsed);
final class LiveVersionMap implements ReferenceManager.RefreshListener, Accountable {
            // lost bytes on average
    private final Map<BytesRef, DeleteVersionValue> tombstones = ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();  
            // Even though we don't store a record of the indexing operation (and mark as unsafe),
                    // we use tryAcquire here since this is a best effort and we try to be least disruptive
            return needsSafeAccess || previousMapsNeededSafeAccess;  
        // try this new map, then fallback to old, then to the  
            return needsSafeAccess
                            }
        // and one for the free space that is due to the fact hash tables can
        private static final VersionLookup EMPTY = new VersionLookup(Collections.emptyMap());  
        // index is being closed:
     *  
    // All deletes also go here, and delete "tombstones" are retained after refresh:
    public Collection<Accountable> getChildResources() {
    /**
        return maps.old.ramBytesUsed.get();  
import org.apache.lucene.util.BytesRef;  
 * not use this file except in compliance with the License.
            // we won't collect the tombstone below since it must be newer than this one.  
 *
            return unsafe;
    public void afterRefresh(boolean didRefresh) throws IOException {  
        }
            if (canRemoveTombstone(maxTimestampToPrune, maxSeqNoToPrune, entry.getValue())) {
                }
        private VersionLookup(Map<BytesRef, VersionValue> map) {
        private final Map<BytesRef, VersionValue> map;
        return keyedLock.acquire(uid);
    void putIndexUnderLock(BytesRef uid, IndexVersionValue version) {
    }  
import org.opensearch.common.lease.Releasable;
    void enforceSafeAccess() {  
        Maps maps = this.maps;
import java.util.Map;  
        boolean isUnsafe() {  
     * @opensearch.internal  
 *  
            3;
        boolean isSafeAccessMode() {
            return map.get(key);  
        }
     * well as the header of the byte[] array it holds, and some lost bytes due
    VersionValue getVersionForAssert(final BytesRef uid) {  
    static {  
    }  
    }  
        // All writes (adds and deletes) go into here:
        if (prevTombstone != null) {
        // not be fully loaded
    }
        maps = maps.invalidateOldMap();
/**  
                adjustRam(-(BASE_BYTES_PER_CHM_ENTRY + previousValue.ramBytesUsed() + uidRAMBytesUsed));  
        }
        // header of the byte[] array  
                current,
    boolean isSafeAccessRequired() {
        // reflected in the previous reader. We don't touch tombstones here: they expire on their own index.gc_deletes timeframe:  
        assert uid.bytes.length == uid.length : "Oversized _uid! UID length: " + uid.length + ", bytes length: " + uid.bytes.length;  
     */  
    /**
     * @see KeyedLock
     */  
        return maps.current.ramBytesUsed.get() + ramBytesUsedTombstones.get();
            long time = delete.time;
     * length of the byte[] (assuming it is not shared between multiple  
        }
        // map reference itself.  
 *
            current.updateMinDeletedTimestamp(deleted);  
        final VersionValue prev = tombstones.remove(uid);
            assert prev.isDelete();
        return true;
/*  
     */
    }
                long uidRAMBytesUsed = BASE_BYTES_PER_BYTESREF + uid.bytes.length;
    void removeTombstoneUnderLock(BytesRef uid) {
    }
 * The OpenSearch Contributors require contributions made to  
            RamUsageEstimator.NUM_BYTES_ARRAY_HEADER +
     * Bytes used by having CHM point to a key/value.
        assert assertKeyedLockHeldByCurrentThread(uid);  
    /**
                    // if we do use a blocking acquire. see #28714  
         * Builds a new map for the refresh transition this should be called in beforeRefresh()
        long uidRAMBytesUsed = BASE_BYTES_PER_BYTESREF + uid.bytes.length;
     * Looks up document version
     * Bytes consumed for each BytesRef UID:
 */  
 * Maps _uid value to its version information.
    long getRefreshingBytes() {
        } else {
     */
        removeTombstoneUnderLock(uid);  
     */
     * Returns how much RAM would be freed up by refreshing. This is {@link #ramBytesUsed} except does not include tombstones because they  
        }  
        final VersionLookup old;  
     * instances).
     */
import java.util.Collection;
        }
    private boolean putAssertionMap(BytesRef uid, IndexVersionValue version) {  
    @Override
        // First try to get the "live" value:
        }  
    // this map is only maintained if assertions are enabled
    /**
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.engine;
    }  
            return new Maps(current, VersionLookup.EMPTY, previousMapsNeededSafeAccess);
    }
                        }
        maps.remove(uid, version);
            value = getUnderLock(uid, unsafeKeysMap);  
    VersionValue getUnderLock(final BytesRef uid) {
            this.map = map;
