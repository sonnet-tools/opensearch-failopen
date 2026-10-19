        try (Releasable r = map.acquireLock(uid(""))) {
                                map.putDeleteUnderLock(bytesRef, (DeleteVersionValue) versionValue);  
                            final long pruneSeqNo = randomLongBetween(0, maxSeqNo.get());
            uid.copyChars(TestUtil.randomSimpleString(random(), 10, 20));
        LiveVersionMap map = new LiveVersionMap();
                assertEquals(version.get(), underLock.version);
            valueMap.forEach((k, v) -> {  
            map.afterRefresh(randomBoolean());
            }
            map.maybePutIndexUnderLock(new BytesRef(""), randomIndexVersionValue());
                            }  
        long estimatedRamBytesUsed = map.ramBytesUsed();
            if (underLock != null) {  
        for (long i = 0; i < versions; i++) {  
                    latestVersion = new IndexVersionValue(randomTranslogLocation(), randomNonNegativeLong(), randomLong(), randomLong());
 * this work for additional information regarding copyright
        CountDownLatch done = new CountDownLatch(numThreads);  
        }  
                try {  
            BytesRefBuilder uid = new BytesRefBuilder();
        }  
        map.getAllCurrent().forEach((k, v) -> {
        ConcurrentHashMap<BytesRef, VersionValue> values = new ConcurrentHashMap<>();
                                    maxSeqNo.incrementAndGet(),
        final AtomicLong maxSeqNo = new AtomicLong();
                    latestVersion = new DeleteVersionValue(randomNonNegativeLong(), randomLong(), randomLong(), randomLong());
        // usage since it ignores the impact of the load factor and of the  
        assertFalse(map.isSafeAccessRequired());  
            assertEquals(new DeleteVersionValue(1, 1, 1, 1), map.getUnderLock(uid("test")));
        BytesRefBuilder builder = new BytesRefBuilder();
                try (Releasable r = map.acquireLock(k)) {
        map.afterRefresh(true);
            assertFalse(map.isUnsafe());
        for (int j = 0; j < threads.length; j++) {
        }
                throw new AssertionError(e);
            map.beforeRefresh();
                    }
    }  
        map.afterRefresh(randomBoolean());  
 * the Apache License, Version 2.0 (the "License"); you may
        });  
                    assertTrue(
 * GitHub history for details.
            map.beforeRefresh();
/*
        // bigger tolerance.
        assertTombstones.run();
            assertEquals(new DeleteVersionValue(1, 1, 1, 1), map.getUnderLock(uid("test")));
            map.maybePutIndexUnderLock(uid("1"), randomIndexVersionValue());
            map.afterRefresh(randomBoolean());
        }
            threads[j] = new Thread(() -> {
 * specific language governing permissions and limitations
        final AtomicLong lastPrunedSeqNo = new AtomicLong();
        t.start();
            try {
    }
        BytesRef uid = uid("1");
                // have a timestamp that is smaller or equal to the maximum timestamp that we pruned on
                try {  
                        }
        deletes.entrySet().forEach(e -> {
        int numThreads = randomIntBetween(2, 5);
                                v -> new IndexVersionValue(randomTranslogLocation(), randomLong(), maxSeqNo.incrementAndGet(), randomLong())  
            VersionValue versionValue = values.get(k);  
        });  
                            boolean isDelete = versionValue instanceof DeleteVersionValue;
        }
import java.util.concurrent.CountDownLatch;
                                versionValue = new DeleteVersionValue(
        while (done.get() == false) {  
            }
            assertNull(map.getUnderLock(uid("1")));
    }
    public void testBasics() throws IOException {
                                    versionValue.term  
                    );
        builder.copyChars(string);
            assertNotNull(map.getUnderLock(uid("1")));  
                }
        thread.start();
 * Licensed to Elasticsearch under one or more contributor  
import java.util.concurrent.atomic.AtomicLong;  
            }
 *
                    versionMap.putDeleteUnderLock(uid, (DeleteVersionValue) latestVersion);
                } finally {  
    }
                        } else {
        try (Releasable r = map.acquireLock(uid(""))) {  
                            assertEquals(underLock, nextVersionValue);  
 *  
            map.afterRefresh(randomBoolean());
                map.putIndexUnderLock(uid.toBytesRef(), randomIndexVersionValue());  
                                    versionValue.version + 1,  
                            nextVersionValue = new IndexVersionValue(randomTranslogLocation(), version.incrementAndGet(), 1, 1);
            }
            assertTrue(map.isUnsafe());  
                                deletes.put(bytesRef, (DeleteVersionValue) versionValue);
        });  
        });
import java.util.List;
        estimatedRamBytesUsed = map.ramBytesUsed();
            map.putIndexUnderLock(uid, (IndexVersionValue) initialVersion);
                map.putIndexUnderLock(uid.toBytesRef(), randomIndexVersionValue());
        assertEquals(actualRamBytesUsed, estimatedRamBytesUsed, tolerance);
import java.util.HashMap;
            if (randomBoolean()) {  
                                    maxSeqNo.incrementAndGet(),
                                    versionValue.term,
            keySet.add(uid(TestUtil.randomSimpleString(random(), 10, 20)));
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            map.afterRefresh(randomBoolean());
            assertTrue(map.isSafeAccessRequired());
            map.afterRefresh(randomBoolean());
        for (int i = 0; i < numIters; i++) { // if we don't do anything ie. no adds etc we will stay with the safe access required
import org.apache.lucene.util.BytesRef;  
            assertNotNull(versionValue);  
                                );
        assertTrue(map.isSafeAccessRequired());
            try (Releasable ignore = versionMap.acquireLock(uid)) {
        // With Java 9, RamUsageTester computes the memory usage of maps as  
                }  
                            nextVersionValue = new DeleteVersionValue(version.incrementAndGet(), 1, 1, 0);
                                    clock.getAndIncrement()  
    public void testCarryOnSafeAccess() throws IOException {  
            assertEquals(e.getValue(), versionValue);
import org.apache.lucene.tests.util.TestUtil;
        }
        VersionValue latestVersion = null;
        LiveVersionMap map = new LiveVersionMap();
                                map.removeTombstoneUnderLock(bytesRef);
        map.enforceSafeAccess();
                }
            map.beforeRefresh();
                done.set(true);
                                    versionValue.version + 1,
        LiveVersionMap map = new LiveVersionMap();  
 * You may obtain a copy of the License at  
            assertNotNull(versionValue);
            }
                versionMap.enforceSafeAccess();  
            VersionValue underLock = map.getUnderLock(uid);
                VersionValue value = map.getUnderLock(e.getKey());  
        assertThat(map.getRefreshingBytes(), equalTo(0L));  
            try (Releasable r = map.acquireLock(uid.toBytesRef())) {  
        final AtomicLong lastPrunedTimestamp = new AtomicLong(-1);  
    public void testPruneTombstonesWhileLocked() throws InterruptedException, IOException {  
                        if (actualValue instanceof DeleteVersionValue) {  
                } catch (InterruptedException e) {
        assertEquals(0, map.getAllCurrent().size());
        }
    public void testAddAndDeleteRefreshConcurrently() throws IOException, InterruptedException {  
 * compatible open source license.
                    assertThat(versionMap.getUnderLock(uid), equalTo(latestVersion));  
        assertFalse(map.isSafeAccessRequired());
            assertEquals(new IndexVersionValue(tlogLoc, 1, 1, 1), map.getUnderLock(uid("test")));
                            map.putDeleteUnderLock(uid, (DeleteVersionValue) nextVersionValue);  
                        } else {
        for (int i = 0; i < 10000; ++i) {  
    public void testRamBytesUsed() throws Exception {  
        // length of the array must be the same as the len of the ref... there is an assertion in LiveVersionMap#putUnderLock  
        assertFalse(map.isUnsafe());
        LiveVersionMap map = new LiveVersionMap();
        assertTrue(map.isUnsafe());  
            assertNotNull(map.getUnderLock(uid("1")));
        }
    public void testRefreshingBytes() throws IOException {
            map.maybePutIndexUnderLock(uid("1"), randomIndexVersionValue());
                    VersionValue actualValue = map.getUnderLock(k);
        map.afterRefresh(true);
            }
        map.beforeRefresh();  
        assertEquals(0, map.getAllTombstones().size());
            map.beforeRefresh();
import java.util.HashSet;  
                start.await();  
                        } else {
                VersionValue nextVersionValue = initialVersion;
public class LiveVersionMapTests extends OpenSearchTestCase {
        try (Releasable ignore = map.acquireLock(uid)) {
        start.countDown();
                    }
        int numKeys = randomIntBetween(50, 200);  
            assertNull(map.getUnderLock(uid("test")));
        try (Releasable ignore = map.acquireLock(uid)) {
                                deletes.remove(bytesRef);
        assertTombstones.run();
        long tolerance = actualRamBytesUsed / 2;
                    }  
        map.beforeRefresh();  
        List<BytesRef> keyList = new ArrayList<>(keySet);
                            }  
        // less than 50% off  
                            );
    private BytesRef uid(String string) {  
                            } else {
            map.afterRefresh(randomBoolean());  
                startGun.countDown();
                if (value == null) {
 */  
    }
        BytesRef uid = uid("1");  
            } finally {  
            assertNull(map.getUnderLock(uid("test")));  
            uid.copyChars(TestUtil.randomSimpleString(random(), 10, 20));
                        assertThat(versionMap.getUnderLock(uid), nullValue());
            map.pruneTombstones(2, 1);
                            if (isDelete) {  
                    assertThat(versionMap.getUnderLock(uid), equalTo(latestVersion));
                    throw new AssertionError(e);
        actualRamBytesUsed = RamUsageTester.ramUsed(map);
                        }  
                    startGun.await();
            initialVersion = new IndexVersionValue(randomTranslogLocation(), version.incrementAndGet(), 1, 1);  
        try (Releasable ignore = map.acquireLock(uid)) {
import java.util.concurrent.ConcurrentHashMap;  
        }
            }
        LiveVersionMap map = new LiveVersionMap();
                            // make sure we track the latest timestamp and seqno we pruned the deletes
                        }
import org.opensearch.common.lease.Releasable;
        final AtomicLong clock = new AtomicLong(0);
            assertNull(map.getUnderLock(uid("1")));  
        for (int j = 0; j < threads.length; j++) {  
            VersionValue versionValue = values.get(e.getKey());
            return null;
                            assertTrue(v.version < actualValue.version);  
                    assertEquals(value, delete);
 * ownership. Elasticsearch licenses this file to you under  
            start.countDown();
            map.maybePutIndexUnderLock(new BytesRef(""), randomIndexVersionValue());  
import static org.hamcrest.Matchers.equalTo;  
        LiveVersionMap map = new LiveVersionMap();
/*  
    public void testRefreshTransition() throws IOException {
                if (versionMap.getUnderLock(uid) != null) {
                    try (Releasable ignore = map.acquireLock(uid)) {  
        }  
                            assertTrue(v.version <= actualValue.version); // deletes can be the same version
            });  
        try (Releasable r = map.acquireLock(uid("1"))) {
        assertFalse(map.isSafeAccessRequired());
                        delete.time <= lastPrunedTimestamp.get() && delete.seqNo <= lastPrunedSeqNo.get()
        thread.join();  
                        if (underLock != null) {
import org.opensearch.test.OpenSearchTestCase;
        final long versions = between(10, 1000);
 *     http://www.apache.org/licenses/LICENSE-2.0
                    if (actualValue != null) {
            assertEquals(new IndexVersionValue(tlogLoc, 1, 1, 1), map.getUnderLock(uid("test")));  
 * license agreements. See the NOTICE file distributed with
            map.beforeRefresh();
                } else if (randomBoolean()) {
                if (randomBoolean()) {  
        assertFalse(map.isUnsafe());  
        VersionValue initialVersion;
                    assertNotNull(actualValue);  
            }
                Thread.yield();
            assertFalse(map.isUnsafe());
        if (randomBoolean()) {
            Thread thread = new Thread(() -> { map.pruneTombstones(Long.MAX_VALUE, 0); });
                                    randomTranslogLocation(),  
                            if (isDelete == false && rarely()) {
                            VersionValue versionValue = values.computeIfAbsent(
            } catch (Exception e) {
        }
 * under the License.  
package org.opensearch.index.engine;
                        delete.time + " > " + lastPrunedTimestamp.get() + "," + delete.seqNo + " > " + lastPrunedSeqNo.get(),  
                for (int i = 0; i < numIters; i++) {
        ConcurrentHashMap<BytesRef, DeleteVersionValue> deletes = new ConcurrentHashMap<>();  
        } else {  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(1, map.getAllCurrent().size());  
        CountDownLatch startGun = new CountDownLatch(numThreads);
                }
        LiveVersionMap map = new LiveVersionMap();  
                    done.countDown();  
    }  
            map.enforceSafeAccess();  
        map.pruneTombstones(clock.incrementAndGet(), maxSeqNo.get());
            assertFalse(map.isUnsafe());
                }
                    assertTrue(v.version <= actualValue.version);
            map.beforeRefresh();  
            assertEquals(new DeleteVersionValue(1, 1, 1, 1), map.getUnderLock(uid("test")));
        do {  
            valueMap.forEach((k, v) -> {
        map.beforeRefresh();
        for (int i = 0; i < numKeys; i++) {
            map.afterRefresh(false);
 * this file be licensed under the Apache-2.0 license or a
                            lastPrunedSeqNo.updateAndGet(prev -> Math.max(pruneSeqNo, prev));  
/*  
                                bytesRef,
                                );
        // now refresh
            assertNull(map.getUnderLock(uid("1")));  
                        if (underLock.isDelete() || randomBoolean()) {
        BytesRefBuilder uid = new BytesRefBuilder();
import java.util.concurrent.atomic.AtomicBoolean;
                                versionValue = new IndexVersionValue(
 * Unless required by applicable law or agreed to in writing,
}
import static org.hamcrest.Matchers.nullValue;
                            underLock = nextVersionValue;
        try (Releasable r = map.acquireLock(uid("test"))) {  
            assertEquals(1, map.getAllTombstones().size());
            map.putDeleteUnderLock(uid("test"), new DeleteVersionValue(1, 1, 1, 1));  
        }  
        map.beforeRefresh();
                            final long clockTick = randomLongBetween(0, clock.get());
                        VersionValue underLock = map.getUnderLock(uid);
        } while (done.getCount() != 0);  
                        assertThat(versionMap.getUnderLock(uid), equalTo(latestVersion));
                    if (versionMap.isSafeAccessRequired()) {
        return new IndexVersionValue(randomTranslogLocation(), randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong());  
            final Map<BytesRef, VersionValue> valueMap = new HashMap<>(map.getAllCurrent());
        // the memory usage of an array that would contain exactly all keys
        t.join();
        assertThat(map.getAllTombstones().entrySet(), empty());  
            threads[j].start();
    IndexVersionValue randomIndexVersionValue() {
        int randomValuesPerThread = randomIntBetween(5000, 20000);
        Runnable assertTombstones = () -> map.getAllTombstones().entrySet().forEach(e -> {
 * not use this file except in compliance with the License.
            assertTrue(map.isUnsafe());  
import org.opensearch.index.translog.Translog;  
            });
                }  
            map.putDeleteUnderLock(uid, new DeleteVersionValue(0, 0, 0, 0));
            map.beforeRefresh();
            thread.join();
        }  
            return new Translog.Location(randomNonNegativeLong(), randomNonNegativeLong(), randomInt());
        }
            }  
 */
    }
        final LiveVersionMap versionMap = new LiveVersionMap();
    }  
            assertTrue(map.isSafeAccessRequired());  
    }  
        Thread t = new Thread(() -> {  
import static org.hamcrest.Matchers.greaterThan;
        assertTombstones.run();  
        AtomicBoolean done = new AtomicBoolean(false);  
            thread.start();  
        Thread thread = new Thread(() -> { map.pruneTombstones(Long.MAX_VALUE, 0); });
                    for (int i = 0; i < randomValuesPerThread; ++i) {
                    done.countDown();
        HashSet<BytesRef> keySet = new HashSet<>();
        // less than 50% off
            map.afterRefresh(false);  
import java.util.Map;
            map.putIndexUnderLock(uid("test"), new IndexVersionValue(tlogLoc, 1, 1, 1));
import java.util.ArrayList;
    public void testConcurrently() throws IOException, InterruptedException {
import java.io.IOException;  
        try (Releasable r = map.acquireLock(uid.toBytesRef())) {  
            map.pruneTombstones(2, 0);  
    }
                        }
        int numIters = randomIntBetween(1, 5);
            if (randomBoolean()) {
                    }
import org.apache.lucene.tests.util.RamUsageTester;
            assertNull(map.getUnderLock(uid("1")));
        uid.copyChars(TestUtil.randomSimpleString(random(), 10, 20));
                        if (rarely()) {  
            try (Releasable r = map.acquireLock(uid.toBytesRef())) {
            assertTrue(versionValue instanceof DeleteVersionValue);
        assertThat(map.getRefreshingBytes(), greaterThan(0L));
            threads[j].join();  
        assertEquals(actualRamBytesUsed, estimatedRamBytesUsed, actualRamBytesUsed / 2);  
            BytesRefBuilder uid = new BytesRefBuilder();  
                            values.put(bytesRef, versionValue);
        AtomicLong version = new AtomicLong();
import org.apache.lucene.util.BytesRefBuilder;
 * software distributed under the License is distributed on an
                            map.pruneTombstones(clockTick, pruneSeqNo);  
 */  
 * The OpenSearch Contributors require contributions made to  
                    VersionValue actualValue = map.getUnderLock(k);
                } else {  
                versionMap.afterRefresh(randomBoolean());  
                            lastPrunedTimestamp.updateAndGet(prev -> Math.max(clockTick, prev));
        map.afterRefresh(false);
            assertEquals(v, versionValue);
                }  
 * Modifications Copyright OpenSearch Contributors. See
            try (Releasable r = map.acquireLock(e.getKey())) {
            map.beforeRefresh(); // refresh otherwise we won't prune since it's tracked by the current map  
        Thread[] threads = new Thread[numThreads];
    public void testRandomlyIndexDeleteAndRefresh() throws Exception {
        }
            Translog.Location tlogLoc = randomTranslogLocation();
        int numIters = randomIntBetween(1000, 5000);
                }
                versionMap.beforeRefresh();
        }
                // here we keep track of the deletes and ensure that all deletes that are not visible anymore ie. not in the map
    }
                try (Releasable r = map.acquireLock(k)) {  
        for (int i = 0; i < 10000; ++i) {
        assertFalse(map.isUnsafe());
            assertEquals(new DeleteVersionValue(1, 1, 1, 1), map.getUnderLock(uid("test")));  
                final DeleteVersionValue delete = e.getValue();  
        // linked list/tree that is used to resolve collisions. So we use a
                            map.putIndexUnderLock(uid, (IndexVersionValue) nextVersionValue);  
                    versionMap.maybePutIndexUnderLock(uid, (IndexVersionValue) latestVersion);  
import static org.hamcrest.Matchers.empty;
                                map.putIndexUnderLock(bytesRef, (IndexVersionValue) versionValue);
    Translog.Location randomTranslogLocation() {  
 * KIND, either express or implied.  See the License for the
        assertFalse(map.isUnsafe());
            assertFalse(map.isUnsafe());
        CountDownLatch start = new CountDownLatch(2);
            assertTrue("failed in iter: " + i, map.isSafeAccessRequired());
            map.putIndexUnderLock(uid.toBytesRef(), randomIndexVersionValue());
                        BytesRef bytesRef = randomFrom(random(), keyList);
        }  
            });  
            Thread.yield();
                        try (Releasable r = map.acquireLock(bytesRef)) {  
        long actualRamBytesUsed = RamUsageTester.ramUsed(map);  
        // and values. This is an under-estimation of the actual memory
        LiveVersionMap map = new LiveVersionMap();
            if (randomBoolean()) {
                    } else {  
        final BytesRef uid = uid("1");  
        return BytesRef.deepCopyOf(builder.get());
 *
                        }
