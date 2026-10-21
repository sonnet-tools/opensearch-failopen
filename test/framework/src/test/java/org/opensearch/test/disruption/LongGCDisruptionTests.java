        final CountDownLatch underLock = new CountDownLatch(1);
 * under the License.
import org.opensearch.test.OpenSearchTestCase;
        LongGCDisruption disruption = new LongGCDisruption(random(), nodeName) {
        final String blockedNodeName = "blocked_node";
                                    ops.incrementAndGet();
            assertThat(ops.get(), equalTo(first));
                });
 *
import static org.hamcrest.Matchers.equalTo;
            for (int i = 0; i < threads.length; i++) {
 * license agreements. See the NOTICE file distributed with
        final List<Thread> threads = new ArrayList<>();
                threads[i].setName("[" + nodeName + "][" + i + "]");
            for (int i = 0; i < 10; i++) {
 * compatible open source license.
        final LockedExecutor lockedExecutor = new LockedExecutor();
        final AtomicLong ops = new AtomicLong();
        final AtomicBoolean stop = new AtomicBoolean();
    public void testBlockDetection() throws Exception {
                        if (lockedExec) {
        } finally {
            protected void onBlockDetected(ThreadInfo blockedThread, @Nullable ThreadInfo blockingThread) {
import java.util.concurrent.locks.ReentrantLock;
            @Override
            ThreadInfo threadInfo = blockDetectionResult.get();
    static class LockedExecutor {
        AtomicReference<ThreadInfo> blockDetectionResult = new AtomicReference<>();
                                }
        final Thread[] threads = new Thread[10];
import static org.hamcrest.Matchers.greaterThan;
            }
        };
        final AtomicBoolean stop = new AtomicBoolean();
                        if (lockedExec) {
        final AtomicBoolean stop = new AtomicBoolean();
                    }
                    return;
                            ops.incrementAndGet();
                threads[i].start();
                Thread thread = new Thread(() -> {
                                    underLock.countDown();
            for (final Thread thread : threads) {
                            lockedExecutor.executeLocked(() -> {
                if (e.getMessage().contains("suspending node threads took too long") && disruption.sawSlowSuspendBug()) {
                                    pauseUnderLock.await();
        }
            assertTrue(waitForBlockDetectionResult.await(30, TimeUnit.SECONDS));
 * The OpenSearch Contributors require contributions made to
import java.util.concurrent.atomic.AtomicBoolean;
            // make sure some threads of test_node are under lock
                        }
 * Modifications Copyright OpenSearch Contributors. See
    }
            } catch (RuntimeException e) {
                threads.add(thread);
 * You may obtain a copy of the License at
            protected Pattern[] getUnsafeClasses() {
/*
 *
        LongGCDisruption disruption = new LongGCDisruption(random(), disruptedNodeName) {
            @Override
                // at least one locked and one none lock thread
                });
        };
 * not use this file except in compliance with the License.
        assumeThat("Thread::resume / Thread::suspend are not supported anymore", Runtime.version(), lessThan(Runtime.Version.parse("20")));
                // at least one locked and one none lock thread
        if (disruption.isBlockDetectionSupported() == false) {
            assertThat(e.getMessage(), containsString("suspending node threads took too long"));
            assertThat(threadInfo.getLockOwnerName(), containsString("[" + disruptedNodeName + "]"));
import java.util.ArrayList;
                thread.setName("[" + disruptedNodeName + "][" + i + "]");
        assumeThat("Thread::resume / Thread::suspend are not supported anymore", Runtime.version(), lessThan(Runtime.Version.parse("20")));
            }
            protected long getSuspendingTimeoutInMillis() {
    public void testBlockingTimeout() throws Exception {
import java.util.List;
                                    ops.incrementAndGet();
                });
        final CountDownLatch pauseUnderLock = new CountDownLatch(1);
            // make sure some threads are under lock
            }
     * Checks that a GC disruption never blocks threads while they are doing something "unsafe"
            pauseUnderLock.countDown();
/*
                threads.add(thread);
 * the Apache License, Version 2.0 (the "License"); you may
                final boolean lockedExec = (i < 9 && randomBoolean()) || i == 0;
                final boolean lockedExec = (i < 4 && randomBoolean()) || i == 0;
                                }
                // at least one locked and one none lock thread
        final AtomicLong ops = new AtomicLong();
        }
                throw new AssertionError(e);
                thread.setName("[" + blockedNodeName + "][" + i + "]");
        }
            }
            @Override
            assertBusy(() -> assertThat(ops.get(), greaterThan(first)));
            }
                                } catch (InterruptedException e) {
 * KIND, either express or implied.  See the License for the
    }
                final boolean lockedExec = (i < 4 && randomBoolean()) || i == 0;
import java.util.concurrent.atomic.AtomicReference;
     * but does keep retrying until all threads can be safely paused
            stop.set(true);
        final Runnable yieldAndIncrement = () -> {
            assertThat(threadInfo.getThreadName(), containsString("[" + blockedNodeName + "]"));
 * ownership. Elasticsearch licenses this file to you under
                        } else {
        final LockedExecutor lockedExecutor = new LockedExecutor();
 * Licensed to Elasticsearch under one or more contributor
 *
            }
import org.opensearch.common.Nullable;
        };
            }
            assertThat(lockedExecutor.lock.isLocked(), equalTo(false)); // no threads should own the lock
                                    pauseUnderLock.await();
        LongGCDisruption disruption = new LongGCDisruption(random(), nodeName) {
        final String nodeName = "test_node";
            }
            @Override
        try {
            @Override
            protected Pattern[] getUnsafeClasses() {
        assumeThat("Thread::resume / Thread::suspend are not supported anymore", Runtime.version(), lessThan(Runtime.Version.parse("20")));
            disruption.stopDisrupting();
            }
                            lockedExecutor.executeLocked(yieldAndIncrement);
 */
/*
    public void testNotBlockingUnsafeStackTraces() throws Exception {
            underLock.await();
            assertThat(threadInfo.getLockInfo().getClassName(), containsString(ReentrantLock.class.getName()));
                                } catch (InterruptedException e) {
                    }
                return new Pattern[] { Pattern.compile(LockedExecutor.class.getSimpleName()) };
import java.util.concurrent.atomic.AtomicLong;
        try {
package org.opensearch.test.disruption;
                    }
                                try {
                return 100;
                                    underLock.countDown();
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.lessThan;
                    while (stop.get() == false) {
 * software distributed under the License is distributed on an
        ReentrantLock lock = new ReentrantLock();
            } finally {
            lock.lock();
            @Override
        public void executeLocked(Runnable r) {
                return new Pattern[0];
            // make sure some threads are under lock
            try {
            for (int i = 0; i < 5; i++) {
                        }
            }
            disruption.stopDisrupting();
}
        final CountDownLatch underLock = new CountDownLatch(1);
            }
    }
            pauseUnderLock.countDown();
            stop.set(true);
                threads[i].start();
                lock.unlock();
                            });
import static org.junit.Assume.assumeThat;
            underLock.await();
                            });
                    while (stop.get() == false) {
                    for (int iter = 0; stop.get() == false; iter++) {
                            ops.incrementAndGet();
        final String disruptedNodeName = "disrupted_node";
            try {
            }
import java.util.concurrent.CountDownLatch;
                }
                disruption.startDisrupting();
        } finally {
                threads[i] = new Thread(() -> {
                    while (stop.get() == false) {
                thread.start();
    }
 * Unless required by applicable law or agreed to in writing,
            }
import java.util.concurrent.TimeUnit;
 */
            Thread.yield(); // give some chance to catch this stack trace
        final Thread[] threads = new Thread[5];
            assertNotNull(threadInfo);
                        } else {
                        } else {
        final LockedExecutor lockedExecutor = new LockedExecutor();
                threads[i] = new Thread(() -> {
                blockDetectionResult.set(blockedThread);
            disruption.stopDisrupting();
                        if (lockedExec) {
                                try {
            Thread.sleep(100);
        try {
 * specific language governing permissions and limitations
        }
                        }
        final String nodeName = "test_node";
                            yieldAndIncrement.run();
    /**
            for (int i = 0; i < 5; i++) {
        } finally {
import java.util.regex.Pattern;
                thread.start();
            stop.set(true);
            }
            protected Pattern[] getUnsafeClasses() {
                thread.join();
                            lockedExecutor.executeLocked(() -> {
import java.lang.management.ThreadInfo;
                return new Pattern[] { Pattern.compile(LockedExecutor.class.getSimpleName()) };
                return 10L;
                Thread thread = new Thread(() -> {
                });
            return;
     */
                threads[i].setName("[" + nodeName + "][" + i + "]");
            for (final Thread thread : threads) {
            long first = ops.get();
                        if (iter % 2 == 0) {
                    }
                        }
                waitForBlockDetectionResult.countDown();
                            lockedExecutor.executeLocked(() -> { ops.incrementAndGet(); });
 */
                        } else {
        };
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
            ops.incrementAndGet();
            RuntimeException e = expectThrows(RuntimeException.class, disruption::startDisrupting);
                r.run();
            for (final Thread thread : threads) {
            }
            protected long getBlockDetectionIntervalInMillis() {
                thread.join();
            disruption.startDisrupting();
                            ops.incrementAndGet();
        }
 * GitHub history for details.
        CountDownLatch waitForBlockDetectionResult = new CountDownLatch(1);
        final AtomicLong ops = new AtomicLong();
import static org.hamcrest.Matchers.containsString;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                thread.join();
        final CountDownLatch pauseUnderLock = new CountDownLatch(1);
public class LongGCDisruptionTests extends OpenSearchTestCase {
 * SPDX-License-Identifier: Apache-2.0
