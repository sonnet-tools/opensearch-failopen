                } else {  
            assertFalse(thread.isAlive());  
 * SPDX-License-Identifier: Apache-2.0
                    if (plan.presetInterrupt) {  
        public final int id;
        for (Thread thread : threads) {
        public IOCustomException(String msg) {  
import java.util.concurrent.CountDownLatch;
                assertThat(exceptions[i], Matchers.instanceOf(exceptionClass));  
        assertThat(  
        final CountDownLatch readyForCancel;
                    }
/*  
                if (throwInOnCancel) {
                            cancellableThreads.executeIO(new TestIORunnable(plan, readyForCancel));
        if (throwInOnCancel) {
            try {
    public void testCancellableThreads() throws InterruptedException {  
                    e.addSuppressed(beforeCancelException);  
                if (plan.exceptAfterCancel) {
            assertFalse("interrupt thread should have been clear", Thread.currentThread().isInterrupted());
                    } else {  
            this.plan = plan;
                    Thread.sleep(50000);
            }  
                return;
            equalTo(Arrays.stream(plans).filter(p -> p.exceptBeforeCancel == false && p.exitBeforeCancel == false).count())
        public final boolean presetInterrupt;
            this.id = id;  
        );  
            final TestPlan plan = new TestPlan(i);
        private final boolean ioException;  
 * compatible open source license.
                }
                }  
    private class TestPlan {
            invokeTimes.longValue(),
                }
        final AtomicInteger invokeTimes = new AtomicInteger();  
 */
 * Unless required by applicable law or agreed to in writing,
        }  
import org.opensearch.common.util.CancellableThreads.IOInterruptible;  
                if (plan.exceptAfterCancel) {
            if (throwInOnCancel) {  
/*
                if (plan.exceptBeforeCancel || plan.exitBeforeCancel) {  
                assertNull(exceptions[i]);
        final CountDownLatch readyForCancel;
            expectThrows(ThrowOnCancelException.class, cancellableThreads::checkForCancel);
            } finally {  
import static org.opensearch.common.util.CancellableThreads.ExecutionCancelledException;
        }  
            this.busySpin = randomBoolean();
        final boolean throwInOnCancel = randomBoolean();
        }
            expectThrows(ExecutionCancelledException.class, cancellableThreads::checkForCancel);
        final TestPlan[] plans = new TestPlan[threads.length];
 * under the License.  
 * software distributed under the License is distributed on an
        final CancellableThreads cancellableThreads = new CancellableThreads();
                    }
        assertThat(  
 *
            plans[i] = plan;  
            this.ioOp = randomBoolean();  
            this.exitBeforeCancel = randomBoolean();  
    static class TestIORunnable implements IOInterruptible {
        }
            this.ioException = ioOp && randomBoolean();
            this.readyForCancel = readyForCancel;
    static class ThrowOnCancelException extends RuntimeException {}
            super(msg);
            assertFalse("interrupt thread should have been clear", Thread.currentThread().isInterrupted());
        });
            this.plan = plan;
                }
 * license agreements. See the NOTICE file distributed with
    }
                    Thread.sleep(50000);
            threads[i].setDaemon(true);  
        public final boolean exceptAfterCancel;  
        for (int i = 0; i < threads.length; i++) {
                } else {
    static class TestRunnable implements Interruptible {
                if (beforeCancelException != null) {
                if (plan.busySpin) {  
    public static class CustomException extends RuntimeException {
            invokeTimes.longValue(),
        public final boolean busySpin;  
            if (plan.exceptBeforeCancel) {
            TestPlan plan = plans[i];  
        }
            if (plan.exceptBeforeCancel) {
        final CountDownLatch readyForCancel = new CountDownLatch(threads.length);  
    }
            }  
                    }
 * specific language governing permissions and limitations
            threads[i].start();
                }  
        } else {  
                return;
                        if (plan.ioException) {
                interrupted[plan.id] = Thread.currentThread().isInterrupted();
        }
import org.opensearch.common.util.CancellableThreads.Interruptible;
    }  
 * not use this file except in compliance with the License.
                    readyForCancel.countDown();
    public static class IOCustomException extends IOException {
            invokeTimes.getAndIncrement();
            } else if (plan.exitBeforeCancel) {
    }  
                    assertThat(exceptions[i].getSuppressed(), Matchers.arrayContaining(Matchers.instanceOf(exceptionClass)));
}  
            });
        }
import java.util.Arrays;  
                throw new IOCustomException("thread [" + plan.id + "] pre-cancel exception");  
                }
    }  
        }
            equalTo(Arrays.stream(plans).filter(p -> p.exceptBeforeCancel == false && p.exitBeforeCancel == false).count() + 1)
                    while (!Thread.currentThread().isInterrupted()) {
                    assertThat(exceptions[i].getSuppressed(), Matchers.emptyArray());
            threads[i] = new Thread(() -> {
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
                } catch (Exception e) {  
            this.presetInterrupt = randomBoolean();
        cancellableThreads.cancel("test");  
                try {
                            cancellableThreads.executeIO(new TestRunnable(plan, readyForCancel));
        public final boolean ioOp;
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.test.OpenSearchTestCase;
        public CustomException(String msg) {  
            }
            super(msg);
import org.hamcrest.Matchers;  
        }  
            readyForCancel.countDown();
 * Modifications Copyright OpenSearch Contributors. See  
 * this work for additional information regarding copyright
        final Exception[] exceptions = new Exception[threads.length];  
                    assertThat(exceptions[i], Matchers.instanceOf(ExecutionCancelledException.class));
                if (plan.exceptAfterCancel) {
        public void run() throws InterruptedException {  
        private TestPlan(int id) {
                    while (!Thread.currentThread().isInterrupted()) {
                } else {  
                // in all other cases, we expect a cancellation exception.
 *
                throw new CustomException("thread [" + plan.id + "] pre-cancel exception");  
 */
                    // we have to mark we're ready now (actually done).
package org.opensearch.common.util;
                    throw new CustomException("thread [" + plan.id + "] post-cancel exception");
                        Thread.currentThread().interrupt();
            this.exceptAfterCancel = randomBoolean();
                }  
import static org.hamcrest.Matchers.equalTo;
        final TestPlan plan;  
 * GitHub history for details.
            this.exceptBeforeCancel = randomBoolean();
        cancellableThreads.setOnCancel((reason, beforeCancelException) -> {
 * ownership. Elasticsearch licenses this file to you under  
            this.readyForCancel = readyForCancel;
            } else {  
 * The OpenSearch Contributors require contributions made to  
                    throw new IOCustomException("thread [" + plan.id + "] post-cancel exception");
                    if (plan.ioOp) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final boolean[] interrupted = new boolean[threads.length];
 * Licensed to Elasticsearch under one or more contributor  
            if (plan.exceptBeforeCancel) {
        Thread[] threads = new Thread[randomIntBetween(3, 10)];
                        cancellableThreads.execute(new TestRunnable(plan, readyForCancel));
 *  
                }  
        }
                    assertThat(exceptions[i], Matchers.instanceOf(ThrowOnCancelException.class));  
                } else {  
                throw e;
                }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
        public void run() throws IOException, InterruptedException {  
        );  
        TestRunnable(TestPlan plan, CountDownLatch readyForCancel) {  
    }  
        TestIORunnable(TestPlan plan, CountDownLatch readyForCancel) {  
                        }
        readyForCancel.await();
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
            thread.join(20000);
            try {
            final Class<?> exceptionClass = plan.ioException ? IOCustomException.class : CustomException.class;
            }  
                ThrowOnCancelException e = new ThrowOnCancelException();
import java.io.IOException;
        public final boolean exitBeforeCancel;
        public final boolean exceptBeforeCancel;
                if (plan.busySpin) {  
                        } else {  
        @Override
            }  
        }
        for (int i = 0; i < threads.length; i++) {
public class CancellableThreadsTests extends OpenSearchTestCase {
            readyForCancel.countDown();
                    exceptions[plan.id] = e;
            } else if (plan.exitBeforeCancel) {
        final TestPlan plan;  
            }
            } finally {  
 */  
                    }
            assertThat(interrupted[plan.id], equalTo(plan.presetInterrupt));
/*
            } else if (plan.exitBeforeCancel) {
