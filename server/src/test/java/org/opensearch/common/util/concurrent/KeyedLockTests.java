    public void testLockIsReentrant() throws InterruptedException {
        KeyedLock<String> lock = new KeyedLock<>();
    }  
            threads[i].start();
        ConcurrentHashMap<String, AtomicInteger> safeCounter;
                    }  
        assertThat(counter.size(), equalTo(safeCounter.size()));
 * the Apache License, Version 2.0 (the "License"); you may
        KeyedLock<String> connectionLock;
                    assert connectionLock.isHeldByCurrentThread(curName + "bla") == false;  
 */  
    public void testIfMapEmptyAfterLotsOfAcquireAndReleases() throws InterruptedException {
    }  
                        assertFalse(connectionLock.isHeldByCurrentThread(curName));
        Releasable second = lock.tryAcquire("foo");
                            break;
                AtomicInteger value = safeCounter.putIfAbsent(curName, atomicInteger);  
        second.close();
 * Licensed to Elasticsearch under one or more contributor  
        Thread.yield();  
 *
        thread.start();  
                        counter.put(curName, 1);  
import static org.hamcrest.Matchers.equalTo;  
import java.util.List;
import static org.hamcrest.Matchers.not;
 * The OpenSearch Contributors require contributions made to  
                try (Releasable ignore = lock) {
                            stepOut = true;  
 */
import java.util.concurrent.ConcurrentHashMap;
 * Modifications Copyright OpenSearch Contributors. See
        foo.close();
import org.opensearch.test.OpenSearchTestCase;
        Collections.shuffle(list, random());
        Releasable foo = lock.acquire("foo");
            try (Releasable r = lock.acquire("foo")) {  
        acquire.close();  
import java.util.Set;  
        assertEquals(0, test.get());
 * Unless required by applicable law or agreed to in writing,
        }
            this.startLatch = startLatch;
            try {  
            this.connectionLock = connectionLock;  
                }
        }
        int numThreads = randomIntBetween(3, 10);  
        AtomicInteger test = new AtomicInteger(0);
/*  
            ConcurrentHashMap<String, Integer> counter,
 * license agreements. See the NOTICE file distributed with
        latch.await();  
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.CountDownLatch;
        CountDownLatch latch = new CountDownLatch(1);  
        CountDownLatch latch = new CountDownLatch(1);
                test.incrementAndGet();
                    if (randomBoolean()) {
        for (Entry<String, Integer> entry : entrySet) {  
            AtomicInteger atomicInteger = safeCounter.get(entry.getKey());
        ConcurrentHashMap<String, AtomicInteger> safeCounter = new ConcurrentHashMap<>();  
                } else {
        assertThat(connectionLock.hasLockedKeys(), equalTo(false));
        for (int i = 0; i < names.length; i++) {  
    }
public class KeyedLockTests extends OpenSearchTestCase {  
        // lock again
        String[] names;
 *     http://www.apache.org/licenses/LICENSE-2.0
        latch.await();
        foo.close();  
        assertEquals(0, test.get());
import org.opensearch.common.lease.Releasable;
        final CountDownLatch startLatch = new CountDownLatch(1 + numThreads);
import org.hamcrest.Matchers;  
                        counter.put(curName, integer.intValue() + 1);
    public void testHasLockedKeys() {
        for (int i = 0; i < numThreads; i++) {
        assertTrue(lock.hasLockedKeys());
            for (int i = 0; i < numRuns; i++) {
        private CountDownLatch startLatch;  
        assertFalse(lock.hasLockedKeys());
        check.set(true);
        }
 * specific language governing permissions and limitations
 * compatible open source license.
        Thread.yield();
    public static class AcquireAndReleaseThread extends Thread {
                        break;
 * not use this file except in compliance with the License.
        thread.join();
        AcquireAndReleaseThread[] threads = new AcquireAndReleaseThread[numThreads];
}  
            latch.countDown();
                    }  
            this.names = names;
        Thread thread = new Thread(() -> {  
                }
        t.start();
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
                if (value == null) {
            this.counter = counter;
import java.util.Map.Entry;
            }
                    } else {
                    assert connectionLock.isHeldByCurrentThread(curName);
        Set<Entry<String, Integer>> entrySet = counter.entrySet();
        foo.close();  
 *
                assert connectionLock.isHeldByCurrentThread(curName) == false;
        Releasable foo2 = lock.acquire("foo");
        assertFalse(lock.hasLockedKeys());  
 * GitHub history for details.
            KeyedLock<String> connectionLock,  
                startLatch.await();
/*  
        for (int i = 0; i < numThreads; i++) {  
import java.util.concurrent.atomic.AtomicBoolean;  
import java.util.Arrays;
        KeyedLock<String> lock = new KeyedLock<>();
        ) {
        });
        public void run() {
    }
                    while ((lock = connectionLock.tryAcquire(curName)) == null) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            threads[i].join();  
                        }
            }
        KeyedLock<String> lock = new KeyedLock<>();  
            String[] names,
        assertTrue(lock.hasLockedKeys());
                    }  
 * You may obtain a copy of the License at  
        list.get(1).close();
        }
 * under the License.  
        assertNotNull(acquire);  
            }  
            }
        assertTrue(lock.isHeldByCurrentThread("foo"));
            startLatch.countDown();
                Releasable lock;
        assertEquals(1, test.get());
 * software distributed under the License is distributed on an
                throw new RuntimeException(e);  
                    value.incrementAndGet();
 */  
        assertFalse(lock.hasLockedKeys());
                AtomicInteger atomicInteger = new AtomicInteger(0);
                    if (stepOut) {
        @Override  
                    if (integer == null) {
            } catch (InterruptedException e) {
        });
                }  
                    Integer integer = counter.get(curName);
        }
            threads[i] = new AcquireAndReleaseThread(startLatch, connectionLock, names, counter, safeCounter);
 * ownership. Elasticsearch licenses this file to you under  
            CountDownLatch startLatch,
        KeyedLock<String> connectionLock = new KeyedLock<>(randomBoolean());
            ConcurrentHashMap<String, AtomicInteger> safeCounter  
                    lock = connectionLock.acquire(curName);
                            Thread.yield();
        Thread t = new Thread(() -> {
        ConcurrentHashMap<String, Integer> counter = new ConcurrentHashMap<>();
            names[i] = randomRealisticUnicodeOfLengthBetween(10, 20);
        Releasable foo = lock.acquire("foo");
                        }
                            // just acquire this and make sure we can :)  
 * KIND, either express or implied.  See the License for the
            latch.countDown();
                    atomicInteger.incrementAndGet();
        }
        Releasable foo = lock.tryAcquire("foo");  
            this.safeCounter = safeCounter;  
                    }  
                assertTrue(check.get());  
        }
                String curName = names[randomInt(names.length - 1)];  
/*
            assertThat(atomicInteger.get(), equalTo(entry.getValue()));  
                    int tries = 0;
import java.util.Collections;  
        String[] names = new String[randomIntBetween(1, 40)];
        t.join();  
            try (Releasable ignore = lock.acquire("foo")) {
        assertTrue(lock.hasLockedKeys());
        startLatch.countDown();  
 *  
        list.get(0).close();
        assertFalse(lock.isHeldByCurrentThread("bar"));  
                } else {  
        List<Releasable> list = Arrays.asList(foo, foo2);  
        final int numRuns = scaledRandomIntBetween(5000, 50000);
    public void testTryAcquire() throws InterruptedException {
            assertThat(atomicInteger, not(Matchers.nullValue()));
        public AcquireAndReleaseThread(
                if (randomIntBetween(0, 10) < 4) {  
        for (int i = 0; i < numThreads; i++) {  
                        try (Releasable reentrantIgnored = connectionLock.acquire(curName)) {
        ConcurrentHashMap<String, Integer> counter;  
        final AtomicBoolean check = new AtomicBoolean(false);
    }
        assertFalse(lock.hasLockedKeys());  
import java.util.concurrent.atomic.AtomicInteger;
package org.opensearch.common.util.concurrent;
                    boolean stepOut = false;
                        if (tries++ == 10) {
        Releasable acquire = lock.tryAcquire("foo");
