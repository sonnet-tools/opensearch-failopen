                    @Override
import org.opensearch.threadpool.TestThreadPool;
         */
        assertEquals(versionConflicts, status.getVersionConflicts());
                @Override
                    waitForShutdown.await();
            }
                @Override
                    }
            status = task.getStatus();
                    errors.add(e);
        assertThat((double) workerState.perfectlyThrottledBatchTime(randomInt()), closeTo(0f, 0f));
 * KIND, either express or implied.  See the License for the
            (double) workerState.perfectlyThrottledBatchTime(total),
        workerState.setTotal(totalHits);
                    }
            threadPool.shutdown();
 * GitHub history for details.
        workerState.rethrottle(originalRequestsPerSecond);
        assertEquals(0, status.getTotal());
            closeTo(TimeUnit.SECONDS.toNanos(total), TimeUnit.SECONDS.toNanos(1))
        long totalHits = randomIntBetween(10, 1000);
        workerState.rethrottle(1);
                    int rethrottles = 0;
import static org.hamcrest.Matchers.empty;
            if (rarely()) {
            });
        assertEquals(noops, status.getNoops());
    }
                threadPool.generic().execute(test);
 * under the License.
    public void testDelayAndRethrottle() throws IOException, InterruptedException {
 * specific language governing permissions and limitations
        workerState.rethrottle(Float.POSITIVE_INFINITY);
            assertEquals(batch, status.getBatches());
                workerState.countNoop();
            assertEquals(totalHits, status.getTotal());
        List<Throwable> errors = new CopyOnWriteArrayList<>();
        ThreadPool threadPool = new TestThreadPool(getTestName()) {
            }
        assertEquals(created, status.getCreated());
                        workerState.rethrottle(requestsPerSecond);
                    @Override
import org.opensearch.core.tasks.TaskId;
            // Other threads should finish up quickly as they are checking the same AtomicBoolean.
        task = new BulkByScrollTask(1, "test_type", "test_action", "test", TaskId.EMPTY_TASK_ID, Collections.emptyMap());
            if (rarely()) {
            // Have the task use the thread pool to delay a task that does nothing
import java.util.concurrent.CyclicBarrier;
            assertEquals(timeValueSeconds(0), task.getStatus().getThrottledUntil());
            assertEquals(deleted, status.getDeleted());
        /*
                    errors.add(e);
                versionConflicts++;
                    public boolean cancel() {
        } finally {
        workerState = task.getWorkerState();
                assertThat(delay.nanos(), both(greaterThanOrEqualTo(0L)).and(lessThanOrEqualTo(maxDelay.nanos())));
        assertEquals(created, status.getCreated());
import org.opensearch.test.OpenSearchTestCase;
    /**
 * Unless required by applicable law or agreed to in writing,
        long created = 0;
                protected void doRun() throws Exception {
         * We never end up waiting this long because the test rethrottles over and over again, ratcheting down the delay a random amount
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
 * this work for additional information regarding copyright
    }
                workerState.countDeleted();
                noops++;
            test.run();
        long deleted = 0;
                        throw new UnsupportedOperationException();
        assertThat(maxDelay.nanos(), greaterThanOrEqualTo(0L));
                    }
 * ownership. Elasticsearch licenses this file to you under
                    }
            for (int i = 1; i < threads; i++) {
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.CopyOnWriteArrayList;
                    boolean oldValue = done.getAndSet(true);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
     * Furiously rethrottles a delayed request to make sure that we never run it twice.
            assertEquals(noops, status.getNoops());
 * Licensed to Elasticsearch under one or more contributor
     */
                    public int compareTo(Delayed o) {
                    }
    }
        try {
                }
                protected void doRun() throws Exception {}
                public void onFailure(Exception e) {
            } else {
 * Modifications Copyright OpenSearch Contributors. See
        long updated = 0;
            Runnable test = () -> {
        assertEquals(deleted, status.getDeleted());
    public void createTask() {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * software distributed under the License is distributed on an
        BulkByScrollTask.Status status = task.getStatus();
    }
            threadPool.shutdown();
                @Override
import org.junit.Before;
        float originalRequestsPerSecond = (float) randomDoubleBetween(1, 10000, true);
        TimeValue maxDelay = timeValueSeconds(between(1, 5));
                public void onFailure(Exception e) {
        assertEquals(updated, status.getUpdated());
                        float requestsPerSecond = (float) randomDoubleBetween(0, originalRequestsPerSecond * 2, true);
            workerState.delayPrepareBulkRequest(threadPool, 0, 1, new AbstractRunnable() {
                }
                }
        assertEquals("test", task.getDescription());
                    @Override
        };
/*
        status = task.getStatus();
 *
                        return -1;
            });
        }
            public ScheduledCancellable schedule(Runnable command, TimeValue delay, String name) {
            }
        assertEquals(batch, status.getBatches());
 *
 * not use this file except in compliance with the License.
                    public boolean isCancelled() {
                workerState.countCreated();
        long versionConflicts = 0;
import org.opensearch.common.unit.TimeValue;
    public void testPerfectlyThrottledBatchTime() {
    public void testProgress() {
        }
        };
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
            }
            if (randomBoolean()) {
            @Override
        );
                        throw new UnsupportedOperationException();
 */
                    throw new UnsupportedOperationException();
            }
                    public long getDelay(TimeUnit unit) {
                workerState.countBatch();
import java.util.concurrent.Delayed;
    private BulkByScrollTask task;
            threadPool.awaitTermination(10, TimeUnit.SECONDS);
 */
            if (rarely()) {
            }
        assertThat(
/*
        }
        assertEquals(updated, status.getUpdated());
        int total = between(0, 1000000);
 * The OpenSearch Contributors require contributions made to
        assertEquals(noops, status.getNoops());
 * this file be licensed under the Apache-2.0 license or a
                        throw new UnsupportedOperationException();
import org.opensearch.common.util.concurrent.AbstractRunnable;
            assertEquals(versionConflicts, status.getVersionConflicts());
    public void testBasicData() {
        for (long p = 0; p < totalHits; p++) {
        task.setWorker(Float.POSITIVE_INFINITY, null);
package org.opensearch.index.reindex;
            workerState.delayPrepareBulkRequest(threadPool, System.nanoTime(), batchSizeForMaxDelay, new AbstractRunnable() {
        assertThat(errors, empty());
 * the Apache License, Version 2.0 (the "License"); you may
/*
        try {
            public ScheduledCancellable schedule(Runnable command, TimeValue delay, String name) {
public class WorkerBulkByScrollTaskStateTests extends OpenSearchTestCase {
            }
            };
        long noops = 0;
                batch++;
                workerState.countUpdated();
        assertEquals(1, task.getId());
 */
}
        int threads = between(1, 10);
         * each time.
                    }
                    @Override
                    while (false == done.get()) {
                created++;
                updated++;
import java.util.List;
                    if (oldValue) {
import static org.hamcrest.Matchers.both;
        int batch = 0;
                }
import java.io.IOException;
            } else if (randomBoolean()) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    private WorkerBulkByScrollTaskState workerState;
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
                workerState.countVersionConflict();
            assertEquals(updated, status.getUpdated());
            assertEquals(created, status.getCreated());
            // Rethrottle on a random number of threads, one of which is this thread.
        assertEquals(totalHits, status.getTotal());
        assertEquals(batch, status.getBatches());
                        rethrottles += 1;
                return super.schedule(command, delay, name);
                deleted++;
                } catch (Exception e) {
        CyclicBarrier waitForShutdown = new CyclicBarrier(threads);
                        throw new RuntimeException("Ran twice oh no!");
            // Even though the future returns a negative delay we just return 0 because the time is up.
        AtomicBoolean done = new AtomicBoolean();
        assertEquals(deleted, status.getDeleted());
 * You may obtain a copy of the License at
import org.opensearch.threadpool.ThreadPool;
                };
        // Thread pool that returns a ScheduledFuture that claims to have a negative delay
        assertEquals(versionConflicts, status.getVersionConflicts());
import java.util.Collections;
        assertEquals("test_type", task.getType());
import java.util.concurrent.TimeUnit;
        int batchSizeForMaxDelay = (int) (maxDelay.seconds() * originalRequestsPerSecond);
    public void testDelayNeverNegative() throws IOException {
                    logger.info("Rethrottled [{}] times", rethrottles);
                @Override
    }
 *
 * license agreements. See the NOTICE file distributed with
                try {
import static org.hamcrest.Matchers.closeTo;
        } finally {
                return new ScheduledCancellable() {
        assertEquals("test_action", task.getAction());
        ThreadPool threadPool = new TestThreadPool("test") {
    @Before
