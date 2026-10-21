                                map.putDeleteUnderLock(bytesRef, (DeleteVersionValue) versionValue);
            thread.join();
            assertTrue(map.isUnsafe());
            assertNull(map.getUnderLock(uid("1")));
        for (int i = 0; i < numKeys; i++) {
                            nextVersionValue = new DeleteVersionValue(version.incrementAndGet(), 1, 1, 0);
            map.putIndexUnderLock(uid.toBytesRef(), randomIndexVersionValue());
        LiveVersionMap map = new LiveVersionMap();
        ConcurrentHashMap<BytesRef, VersionValue> values = new ConcurrentHashMap<>();
            threads[j].join();
        }
        LiveVersionMap map = new LiveVersionMap();
                                    maxSeqNo.incrementAndGet(),
        for (int i = 0; i < numIters; i++) { // if we don't do anything ie. no adds etc we will stay with the safe access required
            map.enforceSafeAccess();
    }
                            map.putIndexUnderLock(uid, (IndexVersionValue) nextVersionValue);
        long estimatedRamBytesUsed = map.ramBytesUsed();
            assertNull(map.getUnderLock(uid("test")));
        }
            try (Releasable r = map.acquireLock(e.getKey())) {
                    assertTrue(
                }
import static org.hamcrest.Matchers.greaterThan;
            Thread.yield();
        // usage since it ignores the impact of the load factor and of the
    public void testRefreshingBytes() throws IOException {
        BytesRef uid = uid("1");
            map.putDeleteUnderLock(uid, new DeleteVersionValue(0, 0, 0, 0));
        thread.start();
    }
import java.util.Map;
        // less than 50% off
            assertNull(map.getUnderLock(uid("1")));
        deletes.entrySet().forEach(e -> {
        } while (done.getCount() != 0);
            map.beforeRefresh();
        assertEquals(0, map.getAllTombstones().size());
public class LiveVersionMapTests extends OpenSearchTestCase {
                Thread.yield();
            }
                } catch (InterruptedException e) {
            assertEquals(new DeleteVersionValue(1, 1, 1, 1), map.getUnderLock(uid("test")));
                versionMap.afterRefresh(randomBoolean());
            assertNull(map.getUnderLock(uid("1")));
            map.beforeRefresh();
        VersionValue initialVersion;
                    }
                map.putIndexUnderLock(uid.toBytesRef(), randomIndexVersionValue());
            initialVersion = new IndexVersionValue(randomTranslogLocation(), version.incrementAndGet(), 1, 1);
    public void testCarryOnSafeAccess() throws IOException {
            start.countDown();
                }
                    latestVersion = new DeleteVersionValue(randomNonNegativeLong(), randomLong(), randomLong(), randomLong());
                        } else {
                            if (isDelete == false && rarely()) {
        for (int j = 0; j < threads.length; j++) {
        Runnable assertTombstones = () -> map.getAllTombstones().entrySet().forEach(e -> {
        Thread t = new Thread(() -> {
        try (Releasable r = map.acquireLock(uid(""))) {
            assertEquals(new IndexVersionValue(tlogLoc, 1, 1, 1), map.getUnderLock(uid("test")));
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(map.isUnsafe());
        assertFalse(map.isSafeAccessRequired());
 * software distributed under the License is distributed on an
            map.maybePutIndexUnderLock(uid("1"), randomIndexVersionValue());
                            map.pruneTombstones(clockTick, pruneSeqNo);
                            assertTrue(v.version < actualValue.version);
        map.beforeRefresh();
                                bytesRef,
                if (value == null) {
import static org.hamcrest.Matchers.equalTo;
            } finally {
            if (randomBoolean()) {
        assertThat(map.getRefreshingBytes(), equalTo(0L));
        try (Releasable r = map.acquireLock(uid.toBytesRef())) {
import org.apache.lucene.tests.util.RamUsageTester;
                VersionValue value = map.getUnderLock(e.getKey());
import org.opensearch.common.lease.Releasable;
            assertEquals(new DeleteVersionValue(1, 1, 1, 1), map.getUnderLock(uid("test")));
                try (Releasable r = map.acquireLock(k)) {
        CountDownLatch startGun = new CountDownLatch(numThreads);
                // here we keep track of the deletes and ensure that all deletes that are not visible anymore ie. not in the map
                versionMap.beforeRefresh();
        } else {
import org.apache.lucene.util.BytesRef;
        assertFalse(map.isUnsafe());
            assertNull(map.getUnderLock(uid("test")));
                            boolean isDelete = versionValue instanceof DeleteVersionValue;
            map.afterRefresh(randomBoolean());
            map.pruneTombstones(2, 0);
            try (Releasable r = map.acquireLock(uid.toBytesRef())) {
            assertNull(map.getUnderLock(uid("1")));
        for (int i = 0; i < 10000; ++i) {
            final Map<BytesRef, VersionValue> valueMap = new HashMap<>(map.getAllCurrent());
                start.await();
    }
                        } else {
        try (Releasable r = map.acquireLock(uid("test"))) {
 * You may obtain a copy of the License at
        while (done.get() == false) {
        assertFalse(map.isSafeAccessRequired());
    IndexVersionValue randomIndexVersionValue() {
                if (randomBoolean()) {
            }
                    if (actualValue != null) {
import java.util.HashSet;
        // linked list/tree that is used to resolve collisions. So we use a
        assertFalse(map.isUnsafe());
import org.opensearch.index.translog.Translog;
            Thread thread = new Thread(() -> { map.pruneTombstones(Long.MAX_VALUE, 0); });
        map.afterRefresh(true);
        assertThat(map.getAllTombstones().entrySet(), empty());
        assertTrue(map.isSafeAccessRequired());
 * not use this file except in compliance with the License.
        map.afterRefresh(false);
            map.afterRefresh(randomBoolean());
                                map.removeTombstoneUnderLock(bytesRef);
        assertFalse(map.isUnsafe());
        }
                final DeleteVersionValue delete = e.getValue();
 * GitHub history for details.
import java.util.HashMap;
        map.enforceSafeAccess();
            threads[j] = new Thread(() -> {
        if (randomBoolean()) {
import java.util.concurrent.CountDownLatch;
        long actualRamBytesUsed = RamUsageTester.ramUsed(map);
    public void testAddAndDeleteRefreshConcurrently() throws IOException, InterruptedException {
                VersionValue nextVersionValue = initialVersion;
        t.join();
            assertEquals(v, versionValue);
                map.putIndexUnderLock(uid.toBytesRef(), randomIndexVersionValue());
                                    clock.getAndIncrement()
            assertNotNull(versionValue);
 * The OpenSearch Contributors require contributions made to
            Translog.Location tlogLoc = randomTranslogLocation();
                                v -> new IndexVersionValue(randomTranslogLocation(), randomLong(), maxSeqNo.incrementAndGet(), randomLong())
        final AtomicLong maxSeqNo = new AtomicLong();
        ConcurrentHashMap<BytesRef, DeleteVersionValue> deletes = new ConcurrentHashMap<>();
            });
                versionMap.enforceSafeAccess();
import java.util.ArrayList;
 * KIND, either express or implied.  See the License for the
            return null;
        final BytesRef uid = uid("1");
        });
        int numIters = randomIntBetween(1000, 5000);
        map.beforeRefresh();
            if (underLock != null) {
                    versionMap.putDeleteUnderLock(uid, (DeleteVersionValue) latestVersion);
            assertTrue(versionValue instanceof DeleteVersionValue);
        });
                startGun.countDown();
                            nextVersionValue = new IndexVersionValue(randomTranslogLocation(), version.incrementAndGet(), 1, 1);
        assertEquals(0, map.getAllCurrent().size());
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        delete.time + " > " + lastPrunedTimestamp.get() + "," + delete.seqNo + " > " + lastPrunedSeqNo.get(),
    public void testPruneTombstonesWhileLocked() throws InterruptedException, IOException {
 *
                        }
import java.util.List;
            valueMap.forEach((k, v) -> {
        do {
        // bigger tolerance.
                        if (underLock != null) {
            map.beforeRefresh();
                        if (rarely()) {
 * compatible open source license.
        assertEquals(1, map.getAllCurrent().size());
        long tolerance = actualRamBytesUsed / 2;
import org.apache.lucene.tests.util.TestUtil;
            try {
 * Unless required by applicable law or agreed to in writing,
                            }
                    done.countDown();
    }
                                    maxSeqNo.incrementAndGet(),
        thread.join();
                            assertEquals(underLock, nextVersionValue);
                } else if (randomBoolean()) {
            VersionValue underLock = map.getUnderLock(uid);
        map.getAllCurrent().forEach((k, v) -> {
            VersionValue versionValue = values.get(k);
        return new IndexVersionValue(randomTranslogLocation(), randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong());
            BytesRefBuilder uid = new BytesRefBuilder();
    public void testRandomlyIndexDeleteAndRefresh() throws Exception {
                    assertNotNull(actualValue);
            } catch (Exception e) {
                        }
        assertTombstones.run();
                    done.countDown();
        }
                done.set(true);
                            } else {
            try (Releasable r = map.acquireLock(uid.toBytesRef())) {
            assertFalse(map.isUnsafe());
            }
        LiveVersionMap map = new LiveVersionMap();
                                    versionValue.version + 1,
 */
            }
                }
                }
        assertThat(map.getRefreshingBytes(), greaterThan(0L));
                        }
        }
                        delete.time <= lastPrunedTimestamp.get() && delete.seqNo <= lastPrunedSeqNo.get()
        CountDownLatch done = new CountDownLatch(numThreads);
        VersionValue latestVersion = null;
        try (Releasable ignore = map.acquireLock(uid)) {
                    startGun.await();
    }
            assertTrue(map.isSafeAccessRequired());
            try (Releasable ignore = versionMap.acquireLock(uid)) {
            assertEquals(e.getValue(), versionValue);
                                );
        }
                        assertThat(versionMap.getUnderLock(uid), equalTo(latestVersion));
                        try (Releasable r = map.acquireLock(bytesRef)) {
            map.putDeleteUnderLock(uid("test"), new DeleteVersionValue(1, 1, 1, 1));
                            final long pruneSeqNo = randomLongBetween(0, maxSeqNo.get());
        for (int j = 0; j < threads.length; j++) {
        }
        BytesRefBuilder uid = new BytesRefBuilder();
        try (Releasable r = map.acquireLock(uid(""))) {
        }
                        }
            map.maybePutIndexUnderLock(new BytesRef(""), randomIndexVersionValue());
                    versionMap.maybePutIndexUnderLock(uid, (IndexVersionValue) latestVersion);
        map.beforeRefresh();
                            lastPrunedSeqNo.updateAndGet(prev -> Math.max(pruneSeqNo, prev));
                    }
        int numKeys = randomIntBetween(50, 200);
        map.afterRefresh(randomBoolean());
            return new Translog.Location(randomNonNegativeLong(), randomNonNegativeLong(), randomInt());
            }
                        } else {
        }
        estimatedRamBytesUsed = map.ramBytesUsed();
            map.afterRefresh(false);
    public void testConcurrently() throws IOException, InterruptedException {
 */
            map.maybePutIndexUnderLock(new BytesRef(""), randomIndexVersionValue());
    Translog.Location randomTranslogLocation() {
                    assertEquals(value, delete);
                    assertThat(versionMap.getUnderLock(uid), equalTo(latestVersion));
                }
    private BytesRef uid(String string) {
/*
            });
            }
    }
import org.apache.lucene.util.BytesRefBuilder;
                            );
                                    randomTranslogLocation(),
import static org.hamcrest.Matchers.empty;
                        if (actualValue instanceof DeleteVersionValue) {
                    }
                            values.put(bytesRef, versionValue);
            map.putIndexUnderLock(uid("test"), new IndexVersionValue(tlogLoc, 1, 1, 1));
        final LiveVersionMap versionMap = new LiveVersionMap();
}
        }
        }
            assertEquals(new IndexVersionValue(tlogLoc, 1, 1, 1), map.getUnderLock(uid("test")));
                            assertTrue(v.version <= actualValue.version); // deletes can be the same version
            if (randomBoolean()) {
        List<BytesRef> keyList = new ArrayList<>(keySet);
 *     http://www.apache.org/licenses/LICENSE-2.0
            valueMap.forEach((k, v) -> {
                    for (int i = 0; i < randomValuesPerThread; ++i) {
        HashSet<BytesRef> keySet = new HashSet<>();
                            map.putDeleteUnderLock(uid, (DeleteVersionValue) nextVersionValue);
    }
                try (Releasable r = map.acquireLock(k)) {
            map.afterRefresh(randomBoolean());
                    assertTrue(v.version <= actualValue.version);
            if (randomBoolean()) {
 * SPDX-License-Identifier: Apache-2.0
        // length of the array must be the same as the len of the ref... there is an assertion in LiveVersionMap#putUnderLock
        BytesRef uid = uid("1");
 *
            map.beforeRefresh();
        int numIters = randomIntBetween(1, 5);
                    throw new AssertionError(e);
    }
/*
                assertEquals(version.get(), underLock.version);
        uid.copyChars(TestUtil.randomSimpleString(random(), 10, 20));
            }
                                    versionValue.term
            assertNotNull(map.getUnderLock(uid("1")));
                for (int i = 0; i < numIters; i++) {
                try {
    }
                }
        // With Java 9, RamUsageTester computes the memory usage of maps as
                    VersionValue actualValue = map.getUnderLock(k);
        }
        LiveVersionMap map = new LiveVersionMap();
                            if (isDelete) {
        assertFalse(map.isUnsafe());
 * ownership. Elasticsearch licenses this file to you under
                                );
        BytesRefBuilder builder = new BytesRefBuilder();
                try {
package org.opensearch.index.engine;
                    }
        map.beforeRefresh();
            });
        }
            assertFalse(map.isUnsafe());
import static org.hamcrest.Matchers.nullValue;
            map.beforeRefresh(); // refresh otherwise we won't prune since it's tracked by the current map
                            // make sure we track the latest timestamp and seqno we pruned the deletes
                                deletes.remove(bytesRef);
        t.start();
 * specific language governing permissions and limitations
            assertTrue(map.isSafeAccessRequired());
        actualRamBytesUsed = RamUsageTester.ramUsed(map);
                    VersionValue actualValue = map.getUnderLock(k);
            map.putIndexUnderLock(uid, (IndexVersionValue) initialVersion);
        CountDownLatch start = new CountDownLatch(2);
            assertFalse(map.isUnsafe());
        Thread thread = new Thread(() -> { map.pruneTombstones(Long.MAX_VALUE, 0); });
        for (long i = 0; i < versions; i++) {
        AtomicBoolean done = new AtomicBoolean(false);
            map.pruneTombstones(2, 1);
        }
        final AtomicLong lastPrunedTimestamp = new AtomicLong(-1);
                            }
                            lastPrunedTimestamp.updateAndGet(prev -> Math.max(clockTick, prev));
                    if (versionMap.isSafeAccessRequired()) {
        int numThreads = randomIntBetween(2, 5);
 * under the License.
        int randomValuesPerThread = randomIntBetween(5000, 20000);
                        }
        map.pruneTombstones(clock.incrementAndGet(), maxSeqNo.get());
 */
 * license agreements. See the NOTICE file distributed with
            map.beforeRefresh();
        LiveVersionMap map = new LiveVersionMap();
        assertEquals(actualRamBytesUsed, estimatedRamBytesUsed, actualRamBytesUsed / 2);
                    assertThat(versionMap.getUnderLock(uid), equalTo(latestVersion));
import java.util.concurrent.atomic.AtomicLong;
                if (versionMap.getUnderLock(uid) != null) {
                                deletes.put(bytesRef, (DeleteVersionValue) versionValue);
                        if (underLock.isDelete() || randomBoolean()) {
            }
import java.io.IOException;
            VersionValue versionValue = values.get(e.getKey());
                                map.putIndexUnderLock(bytesRef, (IndexVersionValue) versionValue);
        try (Releasable r = map.acquireLock(uid("1"))) {
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
                    try (Releasable ignore = map.acquireLock(uid)) {
        try (Releasable ignore = map.acquireLock(uid)) {
        LiveVersionMap map = new LiveVersionMap();
                            underLock = nextVersionValue;
            assertEquals(1, map.getAllTombstones().size());
        }
            assertNotNull(versionValue);
import java.util.concurrent.atomic.AtomicBoolean;
        assertTombstones.run();
            threads[j].start();
            assertTrue("failed in iter: " + i, map.isSafeAccessRequired());
        try (Releasable ignore = map.acquireLock(uid)) {
        assertFalse(map.isSafeAccessRequired());
                            VersionValue versionValue = values.computeIfAbsent(
        assertEquals(actualRamBytesUsed, estimatedRamBytesUsed, tolerance);
import org.opensearch.test.OpenSearchTestCase;
        final long versions = between(10, 1000);
        return BytesRef.deepCopyOf(builder.get());
                                    versionValue.version + 1,
        map.afterRefresh(true);
    public void testRefreshTransition() throws IOException {
            map.beforeRefresh();
        final AtomicLong lastPrunedSeqNo = new AtomicLong();
            assertEquals(new DeleteVersionValue(1, 1, 1, 1), map.getUnderLock(uid("test")));
            assertFalse(map.isUnsafe());
            map.afterRefresh(randomBoolean());
            uid.copyChars(TestUtil.randomSimpleString(random(), 10, 20));
            BytesRefBuilder uid = new BytesRefBuilder();
        }
                    } else {
                        assertThat(versionMap.getUnderLock(uid), nullValue());
                // have a timestamp that is smaller or equal to the maximum timestamp that we pruned on
        // and values. This is an under-estimation of the actual memory
                    latestVersion = new IndexVersionValue(randomTranslogLocation(), randomNonNegativeLong(), randomLong(), randomLong());
        // the memory usage of an array that would contain exactly all keys
        start.countDown();
                        BytesRef bytesRef = randomFrom(random(), keyList);
                                versionValue = new DeleteVersionValue(
        LiveVersionMap map = new LiveVersionMap();
            keySet.add(uid(TestUtil.randomSimpleString(random(), 10, 20)));
        assertTombstones.run();
        Thread[] threads = new Thread[numThreads];
                    );
                }
/*
    public void testRamBytesUsed() throws Exception {
    }
                                versionValue = new IndexVersionValue(
                            final long clockTick = randomLongBetween(0, clock.get());
                                    versionValue.term,
            map.afterRefresh(false);
            }
        for (int i = 0; i < 10000; ++i) {
        assertTrue(map.isUnsafe());
                throw new AssertionError(e);
 * this work for additional information regarding copyright
        });
 *
                } else {
            assertNotNull(map.getUnderLock(uid("1")));
        });
            map.beforeRefresh();
            thread.start();
        LiveVersionMap map = new LiveVersionMap();
                } finally {
    }
        // less than 50% off
    }
import java.util.concurrent.ConcurrentHashMap;
        // now refresh
        AtomicLong version = new AtomicLong();
                        VersionValue underLock = map.getUnderLock(uid);
        }
            map.maybePutIndexUnderLock(uid("1"), randomIndexVersionValue());
    public void testBasics() throws IOException {
 * Licensed to Elasticsearch under one or more contributor
            uid.copyChars(TestUtil.randomSimpleString(random(), 10, 20));
        builder.copyChars(string);
            map.afterRefresh(randomBoolean());
            assertEquals(new DeleteVersionValue(1, 1, 1, 1), map.getUnderLock(uid("test")));
            map.afterRefresh(randomBoolean());
        final AtomicLong clock = new AtomicLong(0);
