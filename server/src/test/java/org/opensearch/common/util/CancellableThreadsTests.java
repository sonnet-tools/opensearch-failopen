                if (plan.busySpin) {
        if (throwInOnCancel) {
                }
    }
        }
                } else {
 * You may obtain a copy of the License at
            expectThrows(ThrowOnCancelException.class, cancellableThreads::checkForCancel);
            } else {
 *
        final TestPlan[] plans = new TestPlan[threads.length];
 * the Apache License, Version 2.0 (the "License"); you may
                }
        }
            try {
        }
                if (plan.busySpin) {
                try {
        final TestPlan plan;
                ThrowOnCancelException e = new ThrowOnCancelException();
        final CountDownLatch readyForCancel;
    static class TestIORunnable implements IOInterruptible {
            });
            } else if (plan.exitBeforeCancel) {
 * compatible open source license.
            this.ioOp = randomBoolean();
                    if (plan.ioOp) {
            final Class<?> exceptionClass = plan.ioException ? IOCustomException.class : CustomException.class;
            threads[i] = new Thread(() -> {
        public final boolean exceptAfterCancel;
            invokeTimes.longValue(),
                }
        }
import java.io.IOException;
        assertThat(
            assertFalse("interrupt thread should have been clear", Thread.currentThread().isInterrupted());
        }
            expectThrows(ExecutionCancelledException.class, cancellableThreads::checkForCancel);
    public static class CustomException extends RuntimeException {
    }
        } else {
                    }
                if (throwInOnCancel) {
        final TestPlan plan;
    }
 * GitHub history for details.
                        }
        TestRunnable(TestPlan plan, CountDownLatch readyForCancel) {
        cancellableThreads.setOnCancel((reason, beforeCancelException) -> {
        @Override
            readyForCancel.countDown();
        public final boolean presetInterrupt;
            readyForCancel.countDown();
                } catch (Exception e) {
 * Modifications Copyright OpenSearch Contributors. See
        public void run() throws InterruptedException {
import org.opensearch.test.OpenSearchTestCase;
                            cancellableThreads.executeIO(new TestRunnable(plan, readyForCancel));
                }
                } else {
        );
        }
import java.util.Arrays;
    }
                } else {
            this.ioException = ioOp && randomBoolean();
        private TestPlan(int id) {
                    Thread.sleep(50000);
/*
        TestIORunnable(TestPlan plan, CountDownLatch readyForCancel) {
                    e.addSuppressed(beforeCancelException);
            if (plan.exceptBeforeCancel) {
            super(msg);
                throw new CustomException("thread [" + plan.id + "] pre-cancel exception");
                }
                    // we have to mark we're ready now (actually done).
public class CancellableThreadsTests extends OpenSearchTestCase {
    static class TestRunnable implements Interruptible {
    public static class IOCustomException extends IOException {
            this.readyForCancel = readyForCancel;
    public void testCancellableThreads() throws InterruptedException {
        for (int i = 0; i < threads.length; i++) {
        public final boolean ioOp;
        final CountDownLatch readyForCancel = new CountDownLatch(threads.length);
        public final boolean busySpin;
            this.exceptBeforeCancel = randomBoolean();
/*
 * license agreements. See the NOTICE file distributed with
            invokeTimes.getAndIncrement();
            }
            this.exitBeforeCancel = randomBoolean();
 */
 *
 * Licensed to Elasticsearch under one or more contributor
                        if (plan.ioException) {
            thread.join(20000);
 * ownership. Elasticsearch licenses this file to you under
                    assertThat(exceptions[i].getSuppressed(), Matchers.emptyArray());
import java.util.concurrent.CountDownLatch;
        for (Thread thread : threads) {
                    Thread.sleep(50000);
        }
            this.presetInterrupt = randomBoolean();
            }
            this.readyForCancel = readyForCancel;
            threads[i].setDaemon(true);
            assertFalse("interrupt thread should have been clear", Thread.currentThread().isInterrupted());
    private class TestPlan {
        final boolean[] interrupted = new boolean[threads.length];
                    throw new IOCustomException("thread [" + plan.id + "] post-cancel exception");
                if (plan.exceptAfterCancel) {
                return;
import java.util.concurrent.atomic.AtomicInteger;
            if (throwInOnCancel) {
            }
        });
                    } else {
import org.opensearch.common.util.CancellableThreads.Interruptible;
                if (plan.exceptAfterCancel) {
                if (plan.exceptAfterCancel) {
                    }
        public CustomException(String msg) {
            assertThat(interrupted[plan.id], equalTo(plan.presetInterrupt));
        }
/*
                    if (plan.presetInterrupt) {
                throw new IOCustomException("thread [" + plan.id + "] pre-cancel exception");
 * under the License.
 * KIND, either express or implied.  See the License for the
                    while (!Thread.currentThread().isInterrupted()) {
                    }
                }
                    assertThat(exceptions[i], Matchers.instanceOf(ThrowOnCancelException.class));
            threads[i].start();
        assertThat(
            try {
            } finally {
                return;
                            cancellableThreads.executeIO(new TestIORunnable(plan, readyForCancel));
        final CancellableThreads cancellableThreads = new CancellableThreads();
 * The OpenSearch Contributors require contributions made to
            equalTo(Arrays.stream(plans).filter(p -> p.exceptBeforeCancel == false && p.exitBeforeCancel == false).count() + 1)
                // in all other cases, we expect a cancellation exception.
            } finally {
                assertThat(exceptions[i], Matchers.instanceOf(exceptionClass));
 * specific language governing permissions and limitations
            final TestPlan plan = new TestPlan(i);
                    }
 * this file be licensed under the Apache-2.0 license or a
                if (plan.exceptBeforeCancel || plan.exitBeforeCancel) {
            }
        @Override
        cancellableThreads.cancel("test");
            this.exceptAfterCancel = randomBoolean();
                }
                }
}
import org.hamcrest.Matchers;
 */
                    exceptions[plan.id] = e;
                assertNull(exceptions[i]);
        public final boolean exceptBeforeCancel;
        private final boolean ioException;
    static class ThrowOnCancelException extends RuntimeException {}
        }
import static org.opensearch.common.util.CancellableThreads.ExecutionCancelledException;
                    while (!Thread.currentThread().isInterrupted()) {
                    assertThat(exceptions[i], Matchers.instanceOf(ExecutionCancelledException.class));
                        Thread.currentThread().interrupt();
        }
        public void run() throws IOException, InterruptedException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        readyForCancel.await();
                    throw new CustomException("thread [" + plan.id + "] post-cancel exception");
            }
            } else if (plan.exitBeforeCancel) {
            this.plan = plan;
 * this work for additional information regarding copyright
        );
            this.busySpin = randomBoolean();
            this.id = id;
            if (plan.exceptBeforeCancel) {
            }
        public final int id;
 *     http://www.apache.org/licenses/LICENSE-2.0
        final boolean throwInOnCancel = randomBoolean();
 * software distributed under the License is distributed on an
package org.opensearch.common.util;
import static org.hamcrest.Matchers.equalTo;
 * SPDX-License-Identifier: Apache-2.0
                } else {
        final CountDownLatch readyForCancel;
 * not use this file except in compliance with the License.
            } else if (plan.exitBeforeCancel) {
                interrupted[plan.id] = Thread.currentThread().isInterrupted();
 *
    }
                        cancellableThreads.execute(new TestRunnable(plan, readyForCancel));
        final AtomicInteger invokeTimes = new AtomicInteger();
        for (int i = 0; i < threads.length; i++) {
            invokeTimes.longValue(),
                }
            this.plan = plan;
                    readyForCancel.countDown();
        final Exception[] exceptions = new Exception[threads.length];
    }
                        } else {
import org.opensearch.common.util.CancellableThreads.IOInterruptible;
        Thread[] threads = new Thread[randomIntBetween(3, 10)];
        public IOCustomException(String msg) {
            plans[i] = plan;
 * Unless required by applicable law or agreed to in writing,
 */
                throw e;
        public final boolean exitBeforeCancel;
            super(msg);
            if (plan.exceptBeforeCancel) {
            assertFalse(thread.isAlive());
        }
                if (beforeCancelException != null) {
            TestPlan plan = plans[i];
            equalTo(Arrays.stream(plans).filter(p -> p.exceptBeforeCancel == false && p.exitBeforeCancel == false).count())
                    assertThat(exceptions[i].getSuppressed(), Matchers.arrayContaining(Matchers.instanceOf(exceptionClass)));
