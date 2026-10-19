    }
        try (RestClient restClient = RestClient.builder(initialNode).build()) {  
            assertTrue("timeout waiting for sniffing rounds to be completed", completionLatch.await(1000, TimeUnit.MILLISECONDS));  
    public void testOrdinarySniffRounds() throws Exception {  
import java.util.concurrent.atomic.AtomicBoolean;  
                    if (onFailureCompleted.get() && onFailureTasks.size() == afterFailureTasks.size()) {  
                    Node node = restClient.getNodes().get(0);
    }
        final CountDownLatch completionLatch = new CountDownLatch(1);
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();  
                @Override
                @Override  
 */
import java.io.IOException;
     * The {@link CountingNodesSniffer} doesn't make any network connection but may throw exception or return no nodes, which makes
                }
     * Mock {@link NodesSniffer} implementation used for testing, which most of the times return a fixed node.
                }  
                    assertEquals(sniffInterval, task.nextTaskDelay);
                for (int j = 0; j < cancelCalls; j++) {
                    }  
                }
        assertSame(mockedFuture, future);
                    assertTrue(future.isDone());
     */
                    // or skipped, in which case it will run but do nothing (thanks to Task#skip).
                    @Override
        final AtomicInteger shutdown = new AtomicInteger(0);
        try {
        private final AtomicInteger runs = new AtomicInteger(0);
                            @Override
                assertThat(onFailureFutures.size(), greaterThanOrEqualTo(minNumOnFailureRounds));
                } else {  
            assertTrue(task.future.isDone());
    /**  
                // with tasks executing quickly one after each other, it is very likely that the onFailure round gets skipped  
            Set<Future<?>> onFailureFutures = new CopyOnWriteArraySet<>();
            assertTrue(task.task.hasStarted());  
        );  
    private static boolean assertTaskCancelledOrCompleted(Sniffer.ScheduledTask task) throws ExecutionException, InterruptedException {  
                @Override
                            assertNotEquals(lastNodes, restClient.getNodes());  
 * GitHub history for details.
            @Override  
import static org.mockito.Mockito.anyCollection;  
                        completionLatch.countDown();
        verify(restClient, times(setNodesRuns)).setNodes(anyCollection());
                    lastFuture.set(future);
import java.util.concurrent.Executors;  
        if (task.task.isSkipped()) {
                assertFalse(onFailureTask.future.isCancelled());
        final Set<Sniffer.ScheduledTask> afterFailureTasks = new CopyOnWriteArraySet<>();  
            // while scheduling the next round which is still part of the execution of the runnable itself.
        final Sniffer.Task task;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    } catch (IOException e) {
                if (rarely()) {
import java.util.concurrent.atomic.AtomicInteger;
                future.get();
     */  
        final int iters = randomIntBetween(30, 100);
    public void testDefaultSchedulerThreadFactory() {  
 * Unless required by applicable law or agreed to in writing,
                    if (delayMillis == sniffAfterFailureDelay) {  
    public void testTaskCancelling() throws Exception {
                    onFailureFutures.add(onFailureExecutor.submit(new Runnable() {  
            defaultScheduler.shutdown();
                    assertTrue(future.isCancelled());
        }
        Sniffer sniffer = new Sniffer(restClient, nodesSniffer, noOpScheduler, 0L, 0L);
            int completedTasks = onFailureTasks.size() + 1;
 * KIND, either express or implied.  See the License for the
                assertEquals(nodesSniffer.emptyList.get(), emptyList);  
        verify(executor).awaitTermination(1000, TimeUnit.MILLISECONDS);
            @Override
                }
                public void shutdown() {}
                        assertEquals(0L, delayMillis);  
                    // the future may or may not be cancelled but the task has for sure started and completed  
        final AtomicBoolean initialized = new AtomicBoolean(false);  
            }  
                    }
                int emptyList = 0;  
            @Override
                return mock(Future.class);
                shutdown.incrementAndGet();
            sniffer.close();  
            @Override
                fail("cancellation exception should have been thrown");
 *
     * throw {@link CancellationException} straight-away but the execution of the task will continue if it had already started,
        long sniffAfterFailureDelay = randomLongBetween(1, Long.MAX_VALUE);
            assertTrue(executor.getExecuteExistingDelayedTasksAfterShutdownPolicy());  
        try {  
                assertEquals(sniffInterval, task.nextTaskDelay);  
            verifyNoMoreInteractions(restClient);
                    return mock(Future.class);
        private final AtomicInteger failures = new AtomicInteger(0);
                    // if a future is cancelled when its execution has already started, future#get throws CancellationException before
            }
 */  
                @Override
import static org.mockito.Mockito.any;
                        if (nodesSniffer.failures.get() > failures) {
                                try {
 * SPDX-License-Identifier: Apache-2.0
        } finally {  
    }
            return nodes;  
                    }));
                    // Here we want to make sure that whenever skip returns false, the task will be completed, otherwise we may be  
            @Override
                assertTrue(onFailureTask.future.isDone());  
                onFailureCompleted.set(true);
import static org.mockito.Mockito.mock;
        defaultScheduler.shutdown();
            for (int i = 0; i < size; i++) {  
            assertEquals(onFailureTasks.size(), afterFailureTasks.size());
                boolean skip = scheduledTask.skip();
            public Future<?> schedule(Sniffer.Task task, long delayMillis) {  
                }
                        return mock(Future.class);
        }
                if (assertTaskCancelledOrCompleted(afterFailureTask)) {  
            assertTrue(executor.getRemoveOnCancelPolicy());
                    // missing to schedule the following round, which means no sniffing will ever happen again besides on failure sniffing.
                        }
        Sniffer sniffer = new Sniffer(restClient, new MockNodesSniffer(), scheduler, sniffInterval, sniffAfterFailureDelay);
import static org.junit.Assert.fail;
                    // all of the subsequent times "schedule" is called with delay set to the configured sniff interval
                        } else {
                } else {  
    public void testDefaultSchedulerSchedule() {
                            lastNodes = restClient.getNodes();  
            }
                assertTrue(task.future.isCancelled());  
            public void shutdown() {}
import org.mockito.invocation.InvocationOnMock;
import org.apache.hc.core5.http.HttpHost;
                nodes.add(new Node(new HttpHost("sniffed-" + run, 9200 + i)));
    public void testClose() {  
                    if (numberOfRuns == 0) {
/*
 * software distributed under the License is distributed on an
                    assertEquals(sniffInterval, delayMillis);
import java.util.Collections;
     * It rarely throws exception or return an empty list of nodes, to make sure that such situations are properly handled.
            }
            assertTrue("timeout waiting for sniffing rounds to be completed", completionLatch.await(1000, TimeUnit.MILLISECONDS));
            if (rarely()) {
                // we submit rather than scheduling to make the test quick and not depend on time  
            }  
    private static class CountingNodesSniffer implements NodesSniffer {  
    public void testSniff() throws IOException {
                public void shutdown() {
                        onFailureTasks.add(new Sniffer.ScheduledTask(task, future));  
                    assertEquals("localhost", node.getHost().getHostName());  
            public Future<?> schedule(Sniffer.Task task, long delayMillis) {  
                    task.run();  
 * this work for additional information regarding copyright
     * Tests the {@link Sniffer#sniff()} method in isolation. Verifies that it uses the {@link NodesSniffer} implementation
                    }
                } catch (CancellationException ignore) {
        } finally {
        int iters = randomIntBetween(3, 10);
        verify(executor).shutdown();
    /**
                }
        @Override
    }  
            for (Future<?> future : futures) {
import java.util.concurrent.CancellationException;
        verifyNoMoreInteractions(restClient);
        verify(executor).shutdownNow();  
        NodesSniffer nodesSniffer = mock(NodesSniffer.class);  
import java.util.concurrent.ExecutionException;
                try {
                    Future<?> future = scheduleOrSubmit(task);
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.concurrent.CopyOnWriteArraySet;
            return true;
        RestClient restClient = mock(RestClient.class);
        RestClient restClient = mock(RestClient.class);
                    if (initializing.compareAndSet(true, false)) {
            }
            assertTrue(executor.awaitTermination(1000, TimeUnit.MILLISECONDS));
import java.util.concurrent.Future;
                if (initialized.compareAndSet(false, true)) {
            for (int i = 1; i <= iters; i++) {  
        final CountDownLatch initializingLatch = new CountDownLatch(1);
                onFailureExecutor.awaitTermination(1000, TimeUnit.MILLISECONDS);
            @Override
        final AtomicInteger scheduleCalls = new AtomicInteger(0);
            @Override
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
            public void shutdown() {}  
            return buildNodes(run);
            } catch (CancellationException ignore) {}  
        final CountDownLatch completionLatch = new CountDownLatch(1);
        ScheduledExecutorService scheduledExecutorService = mock(ScheduledExecutorService.class);  
                    ordinaryRoundsTasks.add(new Sniffer.ScheduledTask(task, future));  
                task.run();
                    // the task was either cancelled before starting, in which case it will never start (thanks to Future#cancel),  
        int setNodesRuns = totalRuns - nodesSniffer.failures.get() - nodesSniffer.emptyList.get();  
        long delay = randomLongBetween(1, Long.MAX_VALUE);
            assertEquals(completedTasks, nodesSniffer.runs.get());
 * license agreements. See the NOTICE file distributed with
                return Collections.emptyList();  
            }
        when(executor.awaitTermination(1000, TimeUnit.MILLISECONDS)).thenReturn(true);  
                            assertEquals(expectedNodes, restClient.getNodes());
            for (Sniffer.ScheduledTask task : ordinaryRoundsTasks) {
                TaskWrapper wrapper = new TaskWrapper(task);
            int size = run % 5 + 1;  
    public void testSniffOnFailureNotInitialized() {  
        }
            try (Sniffer sniffer = new Sniffer(restClient, nodesSniffer, noOpScheduler, 1000L, -1)) {
                        return future;
                    assertTrue(wrapper.await());
                        runs++;  
        RestClient restClient = mock(RestClient.class);
            assertThat(executorService, instanceOf(ScheduledThreadPoolExecutor.class));
                            sniffer.sniffOnFailure();  
                task.future.get();
     * The {@link Scheduler} implementation submits rather than scheduling tasks, meaning that it doesn't respect the requested sniff  
            assertFalse(initializingFuture.get().isCancelled());
            } finally {
     * Test behaviour when a bunch of onFailure sniffing rounds are triggered in parallel. Each run will always  
                            failures++;  
            int cancelledTasks = 0;  
        assertEquals(0, totalRuns);
import org.opensearch.client.sniff.Sniffer.DefaultScheduler;
        public void run() {
                emptyList.incrementAndGet();
    }  
        } else {
import static org.hamcrest.CoreMatchers.equalTo;
            executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
                    return future;
                        return executor.submit(task);
import java.util.concurrent.ExecutorService;
                Sniffer.Task task = sniffer.new Task(0L);
                        public void run() {
            assertTrue("timeout waiting for sniffer to get initialized", initializingLatch.await(1000, TimeUnit.MILLISECONDS));
        final long sniffAfterFailureDelay = randomLongBetween(1, Long.MAX_VALUE);  
                        assertTrue(initializingFuture.compareAndSet(null, future));
                                }
        DefaultScheduler defaultScheduler = new DefaultScheduler();
        final CountDownLatch completionLatch = new CountDownLatch(1);
                assertThat(thread.getName(), equalTo("opensearch_rest_client_sniffer[T#" + i + "]"));
            return completionLatch.await(1000, TimeUnit.MILLISECONDS);
        };
                });  
                        return future;  
                    assertEquals(0L, delayMillis);
                    } else {
                    cancelledTasks++;  
            @Override
            return false;
        };
import org.opensearch.client.RestClient;  
        @Override
    }
                    assertNull(onFailureFuture.get());  
                    cancelledTasks++;  
        long sniffInterval = randomLongBetween(1, Long.MAX_VALUE);  
            assertEquals(i, shutdown.get());
        assertEquals(1, scheduleCalls.get());  
        for (int i = 1; i <= iters; i++) {
            } catch (CancellationException ignore) {
                Future<?> future = executor.submit(task);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.client.Node;
        Node initialNode = new Node(new HttpHost("localhost", 9200));
 *
                    completedTasks++;
            }  
                    assertEquals(9200, node.getHost().getPort());
                    assertNull(future.get());  
        final AtomicInteger runs = new AtomicInteger(iters);
        final Set<Sniffer.ScheduledTask> ordinaryRoundsTasks = new CopyOnWriteArraySet<>();  
        }
import static org.mockito.Mockito.times;
        verify(restClient, times(setNodesRuns)).setNodes(anyCollection());
                }
                if (skip) {
                }
            assertTrue(initializingFuture.get().isDone());  
            int iters = randomIntBetween(5, 30);
                // the executor is closed externally, shutdown is tested separately  
        public List<Node> sniff() throws IOException {  
                while (onFailureTasks.size() < minNumOnFailureRounds) {
                onFailureExecutor.shutdown();
                                    task.run();
            try {  
import static org.junit.Assert.assertEquals;  
                    if (randomBoolean()) {
                private Future<?> scheduleOrSubmit(Sniffer.Task task) {
    }  
/*  
import java.util.concurrent.TimeUnit;
                public ScheduledFuture<?> answer(InvocationOnMock invocationOnMock) {
 * compatible open source license.
            }  
            };
            assertThat(executorService, instanceOf(ScheduledThreadPoolExecutor.class));
                assertEquals(nodesSniffer.failures.get(), failures);
            new Sniffer(restClient, nodesSniffer, scheduler, sniffInterval, sniffAfterFailureDelay);
        int totalRuns = nodesSniffer.runs.get();
                }  
        assertEquals(iters, totalRuns);
        int minNumOnFailureRounds = randomIntBetween(5, 10);
            }
        verify(executor, times(2)).awaitTermination(1000, TimeUnit.MILLISECONDS);  
                                    initializingLatch.countDown();  
            verify(future, times(i)).cancel(false);
        }  
                }
        final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();  
            executor.awaitTermination(1000L, TimeUnit.MILLISECONDS);
                } else {  
                public Future<?> schedule(final Sniffer.Task task, long delayMillis) {
        DefaultScheduler scheduler = new DefaultScheduler(scheduledExecutorService);
        verifyNoMoreInteractions(executor);
        final Set<Future<?>> futures = new CopyOnWriteArraySet<>();  
            // the last future is the only one that may not be completed yet, as the count down happens
            } finally {  
                    try {
        long sniffInterval = randomLongBetween(1, Long.MAX_VALUE);
            executor.shutdown();  
            ScheduledExecutorService executorService = defaultScheduler.executor;  
        final Set<Sniffer.ScheduledTask> onFailureTasks = new CopyOnWriteArraySet<>();
        Scheduler noOpScheduler = new Scheduler() {
        ScheduledThreadPoolExecutor executor = mock(ScheduledThreadPoolExecutor.class);
                    }  
        assertEquals(0, shutdown.get());  
                    lastTask.set(task);
        }
        verify(scheduledExecutorService).schedule(task, delay, TimeUnit.MILLISECONDS);
import java.util.concurrent.CountDownLatch;  
}  
        }  
            try {  
                if (assertTaskCancelledOrCompleted(task)) {  
     * it possible to verify that errors are properly handled and don't affect subsequent runs and their scheduling.
            executor.shutdown();
                    if (delayMillis == 0L) {
import static org.junit.Assert.assertFalse;
package org.opensearch.client.sniff;
                        Future<?> future = executor.submit(task);
                    // completion. The execution continues though so we use a latch to try and wait for the task to be completed.
        }  
import static org.junit.Assert.assertNull;  
                int runs = 0;
                }
                int failures = 0;
                    }
     * at a given point in time.
import java.util.concurrent.atomic.AtomicReference;
                completionLatch.countDown();  
                // as another round is already running. We retry till enough runs get through as that's what we want to test.
            }
/*  
    /**
                            emptyList++;  
            executor.shutdown();
                    public void run() {  
        }  
    }
                throw new IOException("communication breakdown");
            if (rarely()) {
     * in which case {@link Future#cancel(boolean)} returns true which is not very helpful.  
                } else {
import org.opensearch.client.RestClientTestCase;
            };
        final Future<?> future = mock(Future.class);
                    assertTrue(task.toString(), task.hasStarted());
        when(scheduledExecutorService.schedule(any(Runnable.class), any(Long.class), any(TimeUnit.class))).then(
            public void shutdown() {
 * under the License.  
            assertFalse(executor.getContinueExistingPeriodicTasksAfterShutdownPolicy());
            int setNodesRuns = nodesSniffer.runs.get() - nodesSniffer.failures.get() - nodesSniffer.emptyList.get();  
            assertEquals(iters, futures.size());  
    }
                            fail("should have failed given that nodesSniffer says it threw an exception");
            Scheduler noOpScheduler = new Scheduler() {
            int run = runs.incrementAndGet();
                }
            }  
        }
     */
                // subsequent cancel calls return false for sure
            int numIters = randomIntBetween(50, 100);
                        afterFailureTasks.add(new Sniffer.ScheduledTask(task, future));
            assertTrue(task.future.isCancelled());
            for (int i = 0; i < numIters; i++) {  
        Scheduler scheduler = new Scheduler() {  
        };  
                assertEquals(nodesSniffer.runs.get(), runs);
            verify(restClient, times(setNodesRuns)).setNodes(anyCollection());
    }
                }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                @Override  
        try {
            }
 * ownership. Elasticsearch licenses this file to you under  
    /**
     */
                    future = executor.schedule(wrapper, randomLongBetween(0L, 200L), TimeUnit.MILLISECONDS);
                    }  
 * Modifications Copyright OpenSearch Contributors. See
                assertNull(onFailureTask.future.get());
            }
        Sniffer sniffer = new Sniffer(restClient, nodesSniffer, noOpScheduler, 0L, 0L);  
            new Answer<ScheduledFuture<?>>() {  
                if (numberOfRuns == iters) {
        CountingNodesSniffer nodesSniffer = new CountingNodesSniffer();  
            }
                }
        } finally {  
 *  
    private static final class TaskWrapper implements Runnable {
                int numberOfRuns = runs.getAndDecrement();
                            assertEquals("communication breakdown", e.getMessage());
import static org.mockito.Mockito.verifyNoMoreInteractions;
            sniffer.sniffOnFailure();
import java.util.concurrent.ScheduledThreadPoolExecutor;
                    // Here we want to make sure that whenever skip returns true, the task either won't run or it won't do anything,
import java.util.List;
import org.mockito.stubbing.Answer;
                            }
                        }
        verify(executor, times(2)).shutdown();
        int totalRuns = nodesSniffer.runs.get();
        verifyNoMoreInteractions(restClient);
import java.util.ArrayList;  
        final AtomicReference<Future<?>> initializingFuture = new AtomicReference<>();
                    // make sure that onFailure takes scheduling over while at the same time ordinary rounds don't go on.
 */  
     * that tasks are either never started or always completed. Calling {@link Future#get()} against a cancelled future will
        final AtomicReference<Future<?>> lastFuture = new AtomicReference<>();
            assertThat(ordinaryRoundsTasks.size(), greaterThan(0));
                assertTrue(future.isDone());  
import java.util.concurrent.ScheduledFuture;  
     * Wraps a {@link Sniffer.Task} and allows to wait for its completion. This is needed to verify  
     * to retrieve nodes and set them (when not empty) to the provided {@link RestClient} instance.
import static org.hamcrest.Matchers.greaterThan;  
            for (Sniffer.ScheduledTask afterFailureTask : afterFailureTasks) {
                // check that if communication breaks, sniffer keeps on working
    }
                if (numberOfRuns == 1) {  
                        sniffer.sniff();
        for (int i = 0; i < 10; i++) {  
import java.util.concurrent.ScheduledExecutorService;
                for (Future<?> onFailureFuture : onFailureFutures) {
                    assertFalse(scheduledTask.skip());
            public Future<?> schedule(Sniffer.Task task, long delayMillis) {
    public void testDefaultSchedulerShutdown() throws Exception {  
        int setNodesRuns = totalRuns - nodesSniffer.failures.get() - nodesSniffer.emptyList.get();  
        Scheduler scheduler = new Scheduler() {  
            assertThat(executor.getThreadFactory(), instanceOf(Sniffer.SnifferThreadFactory.class));
                        return null;  
        final AtomicBoolean initializing = new AtomicBoolean(true);
        verifyNoMoreInteractions(scheduledExecutorService, mockedFuture);  
                    assertEquals(1, restClient.getNodes().size());
                }
                failures.incrementAndGet();  
                }  
            assert size > 0;
                for (int i = 0; i < iters; i++) {
        long sniffAfterFailureDelay = randomLongBetween(1, Long.MAX_VALUE);
        };
 * not use this file except in compliance with the License.
                {  
            }
                        completionLatch.countDown();
        RestClient restClient = mock(RestClient.class);  
     */  
        final ExecutorService executor = Executors.newSingleThreadExecutor();  
     * Test that {@link Sniffer#close()} shuts down the underlying {@link Scheduler}, and that such calls are idempotent.  
     */
                        }  
                return null;
                }  
            ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) executorService;  
        NodesSniffer nodesSniffer = mock(NodesSniffer.class);
                    assertTrue(task.isSkipped());  
        try {
            }
        final AtomicReference<Sniffer.Task> lastTask = new AtomicReference<>();
        boolean await() throws InterruptedException {
                    }
                        Future<?> future = executor.submit(new Runnable() {
                        } else if (nodesSniffer.emptyList.get() > emptyList) {
            @Override
 * specific language governing permissions and limitations
                    assertEquals(sniffInterval, task.nextTaskDelay);
import static org.junit.Assert.assertSame;
                        return future;
                                    // call does what it needs to do. Otherwise nothing happens until initialized.
                        @Override
                        if (nodesSniffer.failures.get() > failures) {  
                return null;
            CountingNodesSniffer nodesSniffer = new CountingNodesSniffer();  
                    assertTrue(future.isDone());  
                return future;
                        return executor.schedule(task, randomLongBetween(0L, 200L), TimeUnit.MILLISECONDS);  
        }
 * Licensed to Elasticsearch under one or more contributor  
            lastFuture.get().get();
                    assertFalse(task.isSkipped());
                            List<Node> expectedNodes = CountingNodesSniffer.buildNodes(runs);
        defaultScheduler.shutdown();  
                assertFalse(onFailureTask.task.isSkipped());  
            }
import static org.junit.Assert.assertNotEquals;
import org.opensearch.client.sniff.Sniffer.Scheduler;  
        Sniffer sniffer = new Sniffer(restClient, nodesSniffer, scheduler, sniffInterval, sniffAfterFailureDelay);
            @Override
        long sniffAfterFailureDelay = randomLongBetween(1, Long.MAX_VALUE);  
        CountingNodesSniffer nodesSniffer = new CountingNodesSniffer();
            int iters = randomIntBetween(3, 10);
                List<Node> lastNodes = Collections.singletonList(initialNode);  
            assertEquals(onFailureTasks.size(), cancelledTasks);  
                int cancelCalls = randomIntBetween(1, 10);  
        Scheduler scheduler = new Scheduler() {
     * Test multiple sniffing rounds by mocking the {@link Scheduler} as well as the {@link NodesSniffer}.
                    completedTasks++;
                return future;
        Sniffer.Task task = sniffer.new Task(randomLongBetween(1, Long.MAX_VALUE));
        private final AtomicInteger emptyList = new AtomicInteger(0);  
                futures.add(future);
                assertThat(thread.isDaemon(), is(true));
            }
    }  
                    assertFalse(task.hasStarted());
            List<Node> nodes = new ArrayList<>(size);
            }
            this.task = task;
        final long sniffInterval = randomLongBetween(1, Long.MAX_VALUE);
                                } finally {  
            public void shutdown() {  
                            public void run() {  
import static org.junit.Assert.assertThat;
        CountingNodesSniffer nodesSniffer = new CountingNodesSniffer();
                    assertTrue(future.isCancelled());
            public void shutdown() {
            assertThat(onFailureTasks.size(), greaterThanOrEqualTo(minNumOnFailureRounds));
        }  
        RestClient restClient = mock(RestClient.class);  
                } else {
    /**  
    public void testSniffOnFailure() throws Exception {
                        });  
     * Also verifies that the next scheduled round gets cancelled.
        verifyNoMoreInteractions(executor);
                    assertEquals(sniffInterval, task.nextTaskDelay);  
            try {
                }
            }  
            final Sniffer sniffer = new Sniffer(restClient, nodesSniffer, scheduler, sniffInterval, sniffAfterFailureDelay);  
                Future<?> future;  
        };  
                            failures++;
                            assertEquals(lastNodes, restClient.getNodes());
                    return mockedFuture;  
     * It also asserts that it never gets called concurrently, based on the assumption that only one sniff run can be run  
import static org.mockito.Mockito.verify;  
                public Future<?> schedule(Sniffer.Task task, long delayMillis) {  
            for (Sniffer.ScheduledTask onFailureTask : onFailureTasks) {
                assertNull(task.future.get());
        } finally {
        TaskWrapper(Sniffer.Task task) {  
            assertNull(initializingFuture.get().get());
 * You may obtain a copy of the License at  
        }  
public class SnifferTests extends RestClientTestCase {
        final long sniffInterval = randomLongBetween(1, Long.MAX_VALUE);
                    }
     * schedule a subsequent afterFailure round. Also, for each onFailure round that starts, the net scheduled round
                    // run from the same thread so the sniffer gets for sure initialized and the scheduled task gets cancelled on close
                Thread thread = executor.getThreadFactory().newThread(new Runnable() {
                    assertEquals(sniffInterval, delayMillis);  
            ExecutorService onFailureExecutor = Executors.newFixedThreadPool(randomIntBetween(5, 20));  
 * The OpenSearch Contributors require contributions made to  
            Scheduler scheduler = new Scheduler() {
import static org.junit.Assert.assertTrue;  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Set;  
                    // otherwise we may end up with parallel sniffing tracks given that each task schedules the following one. We need to  
                assertTrue(onFailureTask.task.hasStarted());
            public Future<?> schedule(Sniffer.Task task, long delayMillis) {
        private static List<Node> buildNodes(int run) {
            assertTrue(lastTask.get().hasStarted());  
                scheduleCalls.incrementAndGet();  
        Scheduler noOpScheduler = new Scheduler() {
            try {  
     * delays while allowing to assert that the requested delays for each requested run and the following one are the expected values.
import static org.hamcrest.CoreMatchers.instanceOf;
     * (either afterFailure or ordinary) gets cancelled.
                    future = executor.submit(wrapper);
                Sniffer.ScheduledTask scheduledTask = new Sniffer.ScheduledTask(task, future);  
            }
    /**
        final AtomicBoolean onFailureCompleted = new AtomicBoolean(false);
        final ScheduledFuture<?> mockedFuture = mock(ScheduledFuture.class);
        DefaultScheduler defaultScheduler = new DefaultScheduler(executor);
        RestClient restClient = mock(RestClient.class);
                        Future<?> future = scheduleOrSubmit(task);
     * Simulates the ordinary behaviour of {@link Sniffer} when sniffing on failure is not enabled.  
        Future<?> future = scheduler.schedule(task, delay);  
                                    // we need to make sure that the sniffer is initialized, so the sniffOnFailure
            public Future<?> schedule(Sniffer.Task task, long delayMillis) {
                    // the first call is to schedule the first sniff round from the Sniffer constructor, with delay O  
