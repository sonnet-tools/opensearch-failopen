import org.opensearch.common.lease.Releasable;
                for (int j = 0; j < iterations; j++) {  
        int timeout = randomFrom(0, 5, 10);
 * Licensed to Elasticsearch under one or more contributor  
     * not its second entrance.  
            if (locked != null) {
import java.util.stream.IntStream;  
                }
import static org.hamcrest.Matchers.equalTo;
            });  
                    if (randomBoolean()) {
            barrier.await(10, TimeUnit.SECONDS);
        }  
                        acquire(writeLock, readLock);
 */  
import java.util.concurrent.locks.ReentrantLock;  
            assertThat(locked, notNullValue());  
 * software distributed under the License is distributed on an
                }
        }  
                assertThat(lockedCounter.get(), equalTo(0));
 * You may obtain a copy of the License at  
                    throw new RuntimeException(e);
     * lock that if a thread entered the lock twice we would declare that it does not hold the lock after it exits its first entrance but
                        acquire(readLock, writeLock);
        final List<Thread> threads = new ArrayList<>();
 */
        Releasable outer = randomAcquireMethod(lockToAcquire)) {
                    if (locked != null) {  
 *
            }  
 * specific language governing permissions and limitations
        for (final Thread thread : threads) {
            } else {  
    public void testIsHeldByCurrentThread() throws BrokenBarrierException, InterruptedException {
            threads.add(thread);
import java.util.ArrayList;
                ReleasableLock releasableLock = lock.tryAcquire(TimeValue.timeValueSeconds(30));
public class ReleasableLockTests extends OpenSearchTestCase {
            thread.start();
                return releasableLock;
import java.util.stream.Collectors;
 * ownership. Elasticsearch licenses this file to you under  
        int numberOfThreads = randomIntBetween(1, 10);
        List<Thread> threads = IntStream.range(0, numberOfThreads).mapToObj(i -> new Thread(() -> {
        final ReleasableLock writeLock = new ReleasableLock(readWriteLock.writeLock());
 * compatible open source license.
                throw new AssertionError(e);  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
     * Test that accounting on whether or not a thread holds a releasable lock is correct. Previously we had a bug where on a re-entrant
            }
                }  
import org.opensearch.common.unit.TimeValue;
 * Unless required by applicable law or agreed to in writing,
                try {
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchTestCase;  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
                assertThat(lockedCounter.get(), greaterThanOrEqualTo(1));
            assertFalse(otherLock.isHeldByCurrentThread());
                } catch (final BrokenBarrierException | InterruptedException e) {  
        final int iterations = scaledRandomIntBetween(1, 32);
        final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();  
 *
/*
        barrier.await();
            }  
import java.util.concurrent.TimeUnit;  
import java.util.concurrent.BrokenBarrierException;
            assertTrue(lockToAcquire.isHeldByCurrentThread());  
                    throw new RuntimeException(e);
     * @throws InterruptedException   if awaiting on the synchronization barrier is interrupted  
            assertTrue(lockToAcquire.isHeldByCurrentThread());
package org.opensearch.common.util.concurrent;
import static org.hamcrest.Matchers.notNullValue;
            try {
                assertThat(releasableLock, notNullValue());  
import java.util.List;  
        barrier.await();  
        try (ReleasableLock locked = randomBoolean() ? lock.acquire() : null) {  
                    barrier.await();
                try {
    }  
            }
/*  
 * KIND, either express or implied.  See the License for the
            threads.forEach(t -> assertThat(t.isAlive(), is(false)));
            try {  
                barrier.await(10, TimeUnit.SECONDS);
import static org.hamcrest.Matchers.is;
import java.util.concurrent.TimeoutException;
        if (randomBoolean()) {
    private ReleasableLock randomAcquireMethod(ReleasableLock lock) {  
        } else {  
 *  
 * under the License.  
            }
            } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
                    }
     * @throws BrokenBarrierException if awaiting on the synchronization barrier breaks
        final int numberOfThreads = scaledRandomIntBetween(1, 32);
        final CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);  
    }
                    } else {  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
            assertFalse(otherLock.isHeldByCurrentThread());  
    }
            final Thread thread = new Thread(() -> {  
/*  
                }  
}  
                assertFalse(otherLock.isHeldByCurrentThread());
        }
                    barrier.await();
 * SPDX-License-Identifier: Apache-2.0
                } catch (final BrokenBarrierException | InterruptedException e) {  
import java.util.concurrent.locks.ReentrantReadWriteLock;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
    private void acquire(final ReleasableLock lockToAcquire, final ReleasableLock otherLock) {  
        }  
                throw new AssertionError(e);
                thread.join(10000);  
        try (@SuppressWarnings("unused")
        }
        final ReleasableLock readLock = new ReleasableLock(readWriteLock.readLock());
 * GitHub history for details.
        for (int i = 0; i < numberOfThreads; i++) {
    /**  
                        lockedCounter.incrementAndGet();
            thread.join();
            return lock.acquire();
            } catch (InterruptedException e) {
        AtomicInteger lockedCounter = new AtomicInteger();  
                    }
        assertFalse(lockToAcquire.isHeldByCurrentThread());
    }
 * license agreements. See the NOTICE file distributed with
 *     http://www.apache.org/licenses/LICENSE-2.0
        try (ReleasableLock locked = lock.tryAcquire(TimeValue.ZERO)) {
        })).collect(Collectors.toList());
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.CyclicBarrier;
        ReleasableLock lock = new ReleasableLock(new ReentrantLock());  
        CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
            // previously there was a bug here and this would return false
     *
            for (Thread thread : threads) {
        threads.forEach(Thread::start);
                try (ReleasableLock locked = lock.tryAcquire(TimeValue.timeValueMillis(timeout))) {
        }
     */
        assertFalse(otherLock.isHeldByCurrentThread());  
    public void testTryAcquire() throws Exception {
            try (@SuppressWarnings("unused")
                assertTrue(lockToAcquire.isHeldByCurrentThread());
            Releasable inner = randomAcquireMethod(lockToAcquire)) {  
