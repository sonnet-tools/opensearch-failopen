        // Thread pool that returns a ScheduledFuture that claims to have a negative delay
import org.opensearch.test.OpenSearchTestCase;
    public void testDelayAndRethrottle() throws IOException, InterruptedException {
        long deleted = 0;
            (double) workerState.perfectlyThrottledBatchTime(total),
 * SPDX-License-Identifier: Apache-2.0
        ThreadPool threadPool = new TestThreadPool(getTestName()) {
                    throw new UnsupportedOperationException();  
            // Rethrottle on a random number of threads, one of which is this thread.
                    while (false == done.get()) {
package org.opensearch.index.reindex;
    public void testProgress() {
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        try {  
            }
            assertEquals(timeValueSeconds(0), task.getStatus().getThrottledUntil());
        try {
                workerState.countVersionConflict();  
        assertThat(
 *
 * The OpenSearch Contributors require contributions made to  
                protected void doRun() throws Exception {}
            threadPool.awaitTermination(10, TimeUnit.SECONDS);
                @Override
                }
        int batch = 0;
                protected void doRun() throws Exception {  
                        throw new RuntimeException("Ran twice oh no!");  
         */
 *
                @Override
        };  
        }  
            assertEquals(batch, status.getBatches());
                } catch (Exception e) {  
                    }  
        long updated = 0;  
        task = new BulkByScrollTask(1, "test_type", "test_action", "test", TaskId.EMPTY_TASK_ID, Collections.emptyMap());
 * KIND, either express or implied.  See the License for the
            if (randomBoolean()) {
                created++;  
            assertEquals(updated, status.getUpdated());
            });
    public void testPerfectlyThrottledBatchTime() {
        assertEquals(noops, status.getNoops());  
/*
                versionConflicts++;
                threadPool.generic().execute(test);
import java.util.concurrent.CopyOnWriteArrayList;  
                workerState.countCreated();
 * this file be licensed under the Apache-2.0 license or a
            }
                return new ScheduledCancellable() {
        } finally {
 * compatible open source license.
        AtomicBoolean done = new AtomicBoolean();
        long totalHits = randomIntBetween(10, 1000);
                    errors.add(e);
    @Before
                updated++;  
            }
            } else {
            }
 * Unless required by applicable law or agreed to in writing,
        assertEquals(created, status.getCreated());  
            assertEquals(noops, status.getNoops());  
        assertEquals(deleted, status.getDeleted());
                    int rethrottles = 0;
        workerState = task.getWorkerState();  
         * We never end up waiting this long because the test rethrottles over and over again, ratcheting down the delay a random amount  
        workerState.rethrottle(Float.POSITIVE_INFINITY);
                        throw new UnsupportedOperationException();
 * You may obtain a copy of the License at  
                        float requestsPerSecond = (float) randomDoubleBetween(0, originalRequestsPerSecond * 2, true);  
    }
    }
/*  
                batch++;
}  
 * not use this file except in compliance with the License.
                workerState.countDeleted();
            });
 */  
        workerState.setTotal(totalHits);  
                assertThat(delay.nanos(), both(greaterThanOrEqualTo(0L)).and(lessThanOrEqualTo(maxDelay.nanos())));
import static org.hamcrest.Matchers.empty;  
        task.setWorker(Float.POSITIVE_INFINITY, null);
                }
                }
        assertEquals(batch, status.getBatches());
            workerState.delayPrepareBulkRequest(threadPool, System.nanoTime(), batchSizeForMaxDelay, new AbstractRunnable() {
                    public int compareTo(Delayed o) {  
import java.util.Collections;
                        throw new UnsupportedOperationException();
        assertEquals(updated, status.getUpdated());
 * license agreements. See the NOTICE file distributed with
        assertEquals(versionConflicts, status.getVersionConflicts());
        long noops = 0;  
 * Licensed to Elasticsearch under one or more contributor  
    }
            }
                workerState.countNoop();
import static org.hamcrest.Matchers.closeTo;
import org.opensearch.common.util.concurrent.AbstractRunnable;
        int total = between(0, 1000000);
        long versionConflicts = 0;
                    }
            Runnable test = () -> {
            public ScheduledCancellable schedule(Runnable command, TimeValue delay, String name) {
                    public boolean isCancelled() {
        assertEquals(batch, status.getBatches());
public class WorkerBulkByScrollTaskStateTests extends OpenSearchTestCase {
 * under the License.  
            if (rarely()) {  
                public void onFailure(Exception e) {
import org.opensearch.common.unit.TimeValue;
            public ScheduledCancellable schedule(Runnable command, TimeValue delay, String name) {
            if (rarely()) {
import org.junit.Before;
        assertEquals(1, task.getId());
 * ownership. Elasticsearch licenses this file to you under  
import java.util.concurrent.Delayed;
import org.opensearch.threadpool.ThreadPool;  
                        throw new UnsupportedOperationException();  
                    public boolean cancel() {
 *  
import static org.hamcrest.Matchers.both;
            @Override  
        assertEquals(updated, status.getUpdated());
        assertEquals(deleted, status.getDeleted());  
                public void onFailure(Exception e) {
            }  
            test.run();
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
                    @Override  
            if (rarely()) {
        float originalRequestsPerSecond = (float) randomDoubleBetween(1, 10000, true);  
        ThreadPool threadPool = new TestThreadPool("test") {  
                workerState.countUpdated();
    }
    public void createTask() {  
            } else if (randomBoolean()) {
            for (int i = 1; i < threads; i++) {
 * Modifications Copyright OpenSearch Contributors. See
                        return -1;
        assertEquals(0, status.getTotal());  
    private WorkerBulkByScrollTaskState workerState;  
                    if (oldValue) {
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;  
import java.util.concurrent.TimeUnit;  
                @Override
         * each time.
                    @Override  
            }  
                workerState.countBatch();
            // Other threads should finish up quickly as they are checking the same AtomicBoolean.  
        assertThat(errors, empty());
import java.io.IOException;  
        int batchSizeForMaxDelay = (int) (maxDelay.seconds() * originalRequestsPerSecond);
        assertEquals(versionConflicts, status.getVersionConflicts());  
    /**
        assertEquals(noops, status.getNoops());
 */
                    @Override
        assertEquals("test_action", task.getAction());  
        }
/*  
                @Override
        for (long p = 0; p < totalHits; p++) {
    }
        assertThat((double) workerState.perfectlyThrottledBatchTime(randomInt()), closeTo(0f, 0f));  
                    }  
        long created = 0;
                noops++;  
                return super.schedule(command, delay, name);  
            };  
        workerState.rethrottle(1);  
        workerState.rethrottle(originalRequestsPerSecond);
            assertEquals(totalHits, status.getTotal());  
            assertEquals(created, status.getCreated());
    }  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import java.util.List;
        CyclicBarrier waitForShutdown = new CyclicBarrier(threads);  
                    @Override
            assertEquals(deleted, status.getDeleted());  
            assertEquals(versionConflicts, status.getVersionConflicts());
            threadPool.shutdown();  
                    }  
            // Even though the future returns a negative delay we just return 0 because the time is up.  
            workerState.delayPrepareBulkRequest(threadPool, 0, 1, new AbstractRunnable() {  
                    errors.add(e);  
        assertThat(maxDelay.nanos(), greaterThanOrEqualTo(0L));  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                    public long getDelay(TimeUnit unit) {
    public void testDelayNeverNegative() throws IOException {
            threadPool.shutdown();
     */
    public void testBasicData() {  
        };
        }  
                }
                deleted++;  
        status = task.getStatus();
import org.opensearch.core.tasks.TaskId;  
        BulkByScrollTask.Status status = task.getStatus();
 * specific language governing permissions and limitations
            status = task.getStatus();
        assertEquals(created, status.getCreated());
                try {  
import org.opensearch.threadpool.TestThreadPool;
                    }
                };
 * the Apache License, Version 2.0 (the "License"); you may
        int threads = between(1, 10);
import java.util.concurrent.CyclicBarrier;
        } finally {
        assertEquals("test", task.getDescription());
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
                        workerState.rethrottle(requestsPerSecond);
import java.util.concurrent.atomic.AtomicBoolean;
                    }
                    waitForShutdown.await();
            // Have the task use the thread pool to delay a task that does nothing
        assertEquals("test_type", task.getType());
        assertEquals(totalHits, status.getTotal());
        TimeValue maxDelay = timeValueSeconds(between(1, 5));
        /*
                        rethrottles += 1;
                    logger.info("Rethrottled [{}] times", rethrottles);
                    boolean oldValue = done.getAndSet(true);
     * Furiously rethrottles a delayed request to make sure that we never run it twice.  
            closeTo(TimeUnit.SECONDS.toNanos(total), TimeUnit.SECONDS.toNanos(1))  
        List<Throwable> errors = new CopyOnWriteArrayList<>();  
 * GitHub history for details.
    private BulkByScrollTask task;
