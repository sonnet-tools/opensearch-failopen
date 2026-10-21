import java.util.Set;
                    Integer integer = counter.get(curName);
        int numThreads = randomIntBetween(3, 10);
        }
                    } else {
        thread.start();
import java.util.concurrent.ConcurrentHashMap;
                    boolean stepOut = false;
                        }
                    }
                            // just acquire this and make sure we can :)
            assertThat(atomicInteger.get(), equalTo(entry.getValue()));
        startLatch.countDown();
        Thread t = new Thread(() -> {
        second.close();
        thread.join();
 *
        ConcurrentHashMap<String, Integer> counter;
 * ownership. Elasticsearch licenses this file to you under
package org.opensearch.common.util.concurrent;
                if (randomIntBetween(0, 10) < 4) {
    }
        assertFalse(lock.hasLockedKeys());
            this.names = names;
                    }
import static org.hamcrest.Matchers.not;
        t.start();
                        counter.put(curName, integer.intValue() + 1);
                    if (randomBoolean()) {
                            stepOut = true;
            try (Releasable r = lock.acquire("foo")) {
import org.hamcrest.Matchers;
                startLatch.await();
 * specific language governing permissions and limitations
        assertTrue(lock.hasLockedKeys());
            AtomicInteger atomicInteger = safeCounter.get(entry.getKey());
    }
import java.util.List;
        list.get(0).close();
        assertFalse(lock.hasLockedKeys());
                    atomicInteger.incrementAndGet();
                            break;
        Releasable foo = lock.acquire("foo");
        CountDownLatch latch = new CountDownLatch(1);
import java.util.concurrent.CountDownLatch;
 *
 * this work for additional information regarding copyright
 *
        final AtomicBoolean check = new AtomicBoolean(false);
            threads[i].start();
        assertEquals(0, test.get());
 * Licensed to Elasticsearch under one or more contributor
                try (Releasable ignore = lock) {
            }
        foo.close();
                AtomicInteger atomicInteger = new AtomicInteger(0);
                    if (integer == null) {
        Thread thread = new Thread(() -> {
                        break;
        KeyedLock<String> lock = new KeyedLock<>();
        latch.await();
        assertFalse(lock.isHeldByCurrentThread("bar"));
        Thread.yield();
        }
    public static class AcquireAndReleaseThread extends Thread {
                AtomicInteger value = safeCounter.putIfAbsent(curName, atomicInteger);
import static org.hamcrest.Matchers.equalTo;
            for (int i = 0; i < numRuns; i++) {
        for (int i = 0; i < numThreads; i++) {
        });
        assertThat(connectionLock.hasLockedKeys(), equalTo(false));
    }
                    }
        for (int i = 0; i < numThreads; i++) {
                Releasable lock;
            this.connectionLock = connectionLock;
                throw new RuntimeException(e);
    public void testHasLockedKeys() {
            this.safeCounter = safeCounter;
import org.opensearch.common.lease.Releasable;
            KeyedLock<String> connectionLock,
                    assert connectionLock.isHeldByCurrentThread(curName + "bla") == false;
        for (int i = 0; i < numThreads; i++) {
 * Unless required by applicable law or agreed to in writing,
        assertNotNull(acquire);
                }
import java.util.concurrent.atomic.AtomicInteger;
                            Thread.yield();
        assertTrue(lock.hasLockedKeys());
 * The OpenSearch Contributors require contributions made to
            }
        ConcurrentHashMap<String, Integer> counter = new ConcurrentHashMap<>();
        }
        AtomicInteger test = new AtomicInteger(0);
 * Modifications Copyright OpenSearch Contributors. See
                    while ((lock = connectionLock.tryAcquire(curName)) == null) {
        }
            try {
    }
            String[] names,
 * KIND, either express or implied.  See the License for the
        for (Entry<String, Integer> entry : entrySet) {
/*
        Releasable acquire = lock.tryAcquire("foo");
        String[] names;
        foo.close();
/*
                    }
        for (int i = 0; i < names.length; i++) {
        KeyedLock<String> connectionLock;
        List<Releasable> list = Arrays.asList(foo, foo2);
public class KeyedLockTests extends OpenSearchTestCase {
            assertThat(atomicInteger, not(Matchers.nullValue()));
        Thread.yield();
        @Override
        }
        AcquireAndReleaseThread[] threads = new AcquireAndReleaseThread[numThreads];
            ConcurrentHashMap<String, AtomicInteger> safeCounter
        Releasable foo2 = lock.acquire("foo");
                } else {
        assertEquals(1, test.get());
        Releasable second = lock.tryAcquire("foo");
        Collections.shuffle(list, random());
                        try (Releasable reentrantIgnored = connectionLock.acquire(curName)) {
            latch.countDown();
                    int tries = 0;
        public void run() {
        latch.await();
        Set<Entry<String, Integer>> entrySet = counter.entrySet();
                if (value == null) {
    public void testTryAcquire() throws InterruptedException {
                test.incrementAndGet();
        }
                String curName = names[randomInt(names.length - 1)];
            latch.countDown();
        }
}
        ConcurrentHashMap<String, AtomicInteger> safeCounter;
        check.set(true);
        acquire.close();
        assertTrue(lock.hasLockedKeys());
import java.util.concurrent.atomic.AtomicBoolean;
    }
        Releasable foo = lock.tryAcquire("foo");
        KeyedLock<String> connectionLock = new KeyedLock<>(randomBoolean());
 * You may obtain a copy of the License at
        final int numRuns = scaledRandomIntBetween(5000, 50000);
                    value.incrementAndGet();
            this.startLatch = startLatch;
                } else {
        assertTrue(lock.isHeldByCurrentThread("foo"));
        assertEquals(0, test.get());
                        }
                assertTrue(check.get());
        foo.close();
        list.get(1).close();
            CountDownLatch startLatch,
            }
 * under the License.
        String[] names = new String[randomIntBetween(1, 40)];
import java.util.Map.Entry;
        ConcurrentHashMap<String, AtomicInteger> safeCounter = new ConcurrentHashMap<>();
        Releasable foo = lock.acquire("foo");
 * SPDX-License-Identifier: Apache-2.0
            try (Releasable ignore = lock.acquire("foo")) {
 */
                        counter.put(curName, 1);
        private CountDownLatch startLatch;
            names[i] = randomRealisticUnicodeOfLengthBetween(10, 20);
            startLatch.countDown();
 * not use this file except in compliance with the License.
 * compatible open source license.
        final CountDownLatch startLatch = new CountDownLatch(1 + numThreads);
                        if (tries++ == 10) {
        public AcquireAndReleaseThread(
 */
            this.counter = counter;
 * GitHub history for details.
                assert connectionLock.isHeldByCurrentThread(curName) == false;
        KeyedLock<String> lock = new KeyedLock<>();
        ) {
 * software distributed under the License is distributed on an
        // lock again
            ConcurrentHashMap<String, Integer> counter,
                    assert connectionLock.isHeldByCurrentThread(curName);
    public void testIfMapEmptyAfterLotsOfAcquireAndReleases() throws InterruptedException {
        assertFalse(lock.hasLockedKeys());
import java.util.Arrays;
                }
            threads[i] = new AcquireAndReleaseThread(startLatch, connectionLock, names, counter, safeCounter);
            }
                    if (stepOut) {
/*
        });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testLockIsReentrant() throws InterruptedException {
                    lock = connectionLock.acquire(curName);
                        assertFalse(connectionLock.isHeldByCurrentThread(curName));
import org.opensearch.test.OpenSearchTestCase;
        KeyedLock<String> lock = new KeyedLock<>();
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
        assertThat(counter.size(), equalTo(safeCounter.size()));
            threads[i].join();
            } catch (InterruptedException e) {
                }
        CountDownLatch latch = new CountDownLatch(1);
        assertFalse(lock.hasLockedKeys());
        t.join();
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
 */
