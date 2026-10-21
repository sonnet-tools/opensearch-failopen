                completionLatch.countDown();
                }
        try (RestClient restClient = RestClient.builder(initialNode).build()) {
            assertTrue(executor.awaitTermination(1000, TimeUnit.MILLISECONDS));
                // check that if communication breaks, sniffer keeps on working
            }
                    assertTrue(future.isCancelled());
import static org.mockito.Mockito.anyCollection;
        ScheduledThreadPoolExecutor executor = mock(ScheduledThreadPoolExecutor.class);
        RestClient restClient = mock(RestClient.class);
            if (rarely()) {
        public List<Node> sniff() throws IOException {
                    assertFalse(task.isSkipped());
     * Test behaviour when a bunch of onFailure sniffing rounds are triggered in parallel. Each run will always
import java.util.concurrent.CountDownLatch;
            assertThat(executorService, instanceOf(ScheduledThreadPoolExecutor.class));
            ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) executorService;
        verifyNoMoreInteractions(restClient);
import static org.hamcrest.CoreMatchers.equalTo;
        };
                    }
        verifyNoMoreInteractions(executor);
 * Modifications Copyright OpenSearch Contributors. See
        } finally {
            ScheduledExecutorService executorService = defaultScheduler.executor;
            verify(restClient, times(setNodesRuns)).setNodes(anyCollection());
            assertTrue(executor.getExecuteExistingDelayedTasksAfterShutdownPolicy());
        } finally {
        Sniffer.Task task = sniffer.new Task(randomLongBetween(1, Long.MAX_VALUE));
                assertTrue(onFailureTask.task.hasStarted());
            }
 * GitHub history for details.
import java.util.concurrent.ScheduledThreadPoolExecutor;
        verify(executor).awaitTermination(1000, TimeUnit.MILLISECONDS);
        Node initialNode = new Node(new HttpHost("localhost", 9200));
package org.opensearch.client.sniff;
                shutdown.incrementAndGet();
                Future<?> future = executor.submit(task);
                int failures = 0;
                    // the task was either cancelled before starting, in which case it will never start (thanks to Future#cancel),
import java.util.concurrent.ExecutionException;
            try {
        };
            assert size > 0;
                                    // we need to make sure that the sniffer is initialized, so the sniffOnFailure
        final Set<Sniffer.ScheduledTask> onFailureTasks = new CopyOnWriteArraySet<>();
            }
                return null;
        verify(restClient, times(setNodesRuns)).setNodes(anyCollection());
        long delay = randomLongBetween(1, Long.MAX_VALUE);
                List<Node> lastNodes = Collections.singletonList(initialNode);
                future.get();
import static org.hamcrest.Matchers.greaterThan;
                }
                TaskWrapper wrapper = new TaskWrapper(task);
import static org.junit.Assert.fail;
     * Simulates the ordinary behaviour of {@link Sniffer} when sniffing on failure is not enabled.
            return nodes;
        DefaultScheduler scheduler = new DefaultScheduler(scheduledExecutorService);
                // with tasks executing quickly one after each other, it is very likely that the onFailure round gets skipped
        assertSame(mockedFuture, future);
                            failures++;
                    assertNull(future.get());
        final ScheduledFuture<?> mockedFuture = mock(ScheduledFuture.class);
                assertEquals(nodesSniffer.runs.get(), runs);
            List<Node> nodes = new ArrayList<>(size);
                            @Override
 * software distributed under the License is distributed on an
                @Override
     * that tasks are either never started or always completed. Calling {@link Future#get()} against a cancelled future will
                try {
    public void testDefaultSchedulerSchedule() {
                }
        final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
import java.util.Set;
                // subsequent cancel calls return false for sure
            public void shutdown() {}
                            fail("should have failed given that nodesSniffer says it threw an exception");
    /**
 * The OpenSearch Contributors require contributions made to
                    Future<?> future = scheduleOrSubmit(task);
                for (int j = 0; j < cancelCalls; j++) {
    private static final class TaskWrapper implements Runnable {
import static org.mockito.Mockito.when;
            sniffer.sniffOnFailure();
        RestClient restClient = mock(RestClient.class);
                        Future<?> future = executor.submit(task);
                assertTrue(task.future.isCancelled());
                    if (randomBoolean()) {
        }
                if (initialized.compareAndSet(false, true)) {
                return mock(Future.class);
                    }
            try {
/*
        long sniffInterval = randomLongBetween(1, Long.MAX_VALUE);
        long sniffAfterFailureDelay = randomLongBetween(1, Long.MAX_VALUE);
                } else {
import org.opensearch.client.sniff.Sniffer.DefaultScheduler;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.mock;
                } else {
                    assertNull(onFailureFuture.get());
                if (skip) {
            assertTrue("timeout waiting for sniffing rounds to be completed", completionLatch.await(1000, TimeUnit.MILLISECONDS));
                        sniffer.sniff();
 * not use this file except in compliance with the License.
    /**
                assertThat(onFailureFutures.size(), greaterThanOrEqualTo(minNumOnFailureRounds));
                    future = executor.schedule(wrapper, randomLongBetween(0L, 200L), TimeUnit.MILLISECONDS);
import java.util.concurrent.atomic.AtomicInteger;
                assertTrue(onFailureTask.future.isDone());
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
                } catch (CancellationException ignore) {
                if (numberOfRuns == iters) {
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.junit.Assert.assertNotEquals;
 * compatible open source license.
                        onFailureTasks.add(new Sniffer.ScheduledTask(task, future));
                Sniffer.Task task = sniffer.new Task(0L);
import org.mockito.stubbing.Answer;
        @Override
        }
            assertEquals(onFailureTasks.size(), afterFailureTasks.size());
        assertEquals(1, scheduleCalls.get());
                    }
            assertFalse(initializingFuture.get().isCancelled());
            return buildNodes(run);
            int iters = randomIntBetween(5, 30);
            executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
    }
import java.util.concurrent.atomic.AtomicBoolean;
            @Override
            assertTrue(task.future.isCancelled());
                failures.incrementAndGet();
                    // if a future is cancelled when its execution has already started, future#get throws CancellationException before
                task.run();
                            failures++;
    }
                assertThat(thread.isDaemon(), is(true));
                onFailureExecutor.awaitTermination(1000, TimeUnit.MILLISECONDS);
                                    initializingLatch.countDown();
            };
        long sniffAfterFailureDelay = randomLongBetween(1, Long.MAX_VALUE);
/*
                nodes.add(new Node(new HttpHost("sniffed-" + run, 9200 + i)));
        DefaultScheduler defaultScheduler = new DefaultScheduler();
import java.util.concurrent.ScheduledExecutorService;
                if (rarely()) {
        private final AtomicInteger failures = new AtomicInteger(0);
                        } else if (nodesSniffer.emptyList.get() > emptyList) {
        for (int i = 1; i <= iters; i++) {
        }
            ExecutorService onFailureExecutor = Executors.newFixedThreadPool(randomIntBetween(5, 20));
                                } finally {
        int setNodesRuns = totalRuns - nodesSniffer.failures.get() - nodesSniffer.emptyList.get();
     * The {@link CountingNodesSniffer} doesn't make any network connection but may throw exception or return no nodes, which makes
     */
                        });
            int iters = randomIntBetween(3, 10);
            @Override
        when(scheduledExecutorService.schedule(any(Runnable.class), any(Long.class), any(TimeUnit.class))).then(
                }
                    }
                @Override
 * license agreements. See the NOTICE file distributed with
            }
            @Override
            }
     */
            }
            assertTrue(initializingFuture.get().isDone());
                        return mock(Future.class);
                    future = executor.submit(wrapper);
 * under the License.
                        return null;
                    public void run() {
        private static List<Node> buildNodes(int run) {
            this.task = task;
import static org.mockito.Mockito.verify;
            }
            } catch (CancellationException ignore) {}
        long sniffInterval = randomLongBetween(1, Long.MAX_VALUE);
import static org.hamcrest.CoreMatchers.instanceOf;
                    assertTrue(task.isSkipped());
    }
                    completedTasks++;
                        return future;
            sniffer.close();
    public void testDefaultSchedulerShutdown() throws Exception {
                @Override
            }
        }
        for (int i = 0; i < 10; i++) {
        }
            assertEquals(iters, futures.size());
                    // or skipped, in which case it will run but do nothing (thanks to Task#skip).
                    assertTrue(wrapper.await());
            }
            assertTrue(executor.getRemoveOnCancelPolicy());
 * Unless required by applicable law or agreed to in writing,
                    if (numberOfRuns == 0) {
                            emptyList++;
        final AtomicInteger scheduleCalls = new AtomicInteger(0);
            }
        NodesSniffer nodesSniffer = mock(NodesSniffer.class);
                        afterFailureTasks.add(new Sniffer.ScheduledTask(task, future));
                    // the future may or may not be cancelled but the task has for sure started and completed
                    // the first call is to schedule the first sniff round from the Sniffer constructor, with delay O
                assertEquals(sniffInterval, task.nextTaskDelay);
        int setNodesRuns = totalRuns - nodesSniffer.failures.get() - nodesSniffer.emptyList.get();
            public Future<?> schedule(Sniffer.Task task, long delayMillis) {
        assertEquals(0, shutdown.get());
    }
                assertTrue(future.isDone());
            executor.shutdown();
                return Collections.emptyList();
public class SnifferTests extends RestClientTestCase {
import java.io.IOException;
 * specific language governing permissions and limitations
                public Future<?> schedule(final Sniffer.Task task, long delayMillis) {
        }
                    assertTrue(future.isCancelled());
            if (rarely()) {
        Scheduler scheduler = new Scheduler() {
            try {
                @Override
                                }
                if (numberOfRuns == 1) {
                    ordinaryRoundsTasks.add(new Sniffer.ScheduledTask(task, future));
import static org.mockito.Mockito.verifyNoMoreInteractions;
                        return executor.submit(task);
            public void shutdown() {
                }
            public void shutdown() {
                    if (initializing.compareAndSet(true, false)) {
                                try {
        final Set<Sniffer.ScheduledTask> ordinaryRoundsTasks = new CopyOnWriteArraySet<>();
     * The {@link Scheduler} implementation submits rather than scheduling tasks, meaning that it doesn't respect the requested sniff
        }
import static org.mockito.Mockito.any;
                        }
            int run = runs.incrementAndGet();
            Scheduler scheduler = new Scheduler() {
import static org.junit.Assert.assertSame;
import org.opensearch.client.sniff.Sniffer.Scheduler;
                    assertEquals(sniffInterval, delayMillis);
        }
                        Future<?> future = scheduleOrSubmit(task);
                    // make sure that onFailure takes scheduling over while at the same time ordinary rounds don't go on.
                    try {
                        completionLatch.countDown();
     * at a given point in time.
            assertNull(initializingFuture.get().get());
            }
            @Override
                scheduleCalls.incrementAndGet();
                    assertEquals("localhost", node.getHost().getHostName());
                                    // call does what it needs to do. Otherwise nothing happens until initialized.
            int cancelledTasks = 0;
                public void shutdown() {}
                    lastFuture.set(future);
        Scheduler scheduler = new Scheduler() {
                int numberOfRuns = runs.getAndDecrement();
        final AtomicReference<Sniffer.Task> lastTask = new AtomicReference<>();
                onFailureCompleted.set(true);
                        if (nodesSniffer.failures.get() > failures) {
                for (Future<?> onFailureFuture : onFailureFutures) {
                            List<Node> expectedNodes = CountingNodesSniffer.buildNodes(runs);
            }
     */
                        return future;
        };
                    assertTrue(future.isDone());
                    // run from the same thread so the sniffer gets for sure initialized and the scheduled task gets cancelled on close
            int numIters = randomIntBetween(50, 100);
    }
                assertNull(onFailureTask.future.get());
     * It rarely throws exception or return an empty list of nodes, to make sure that such situations are properly handled.
    public void testSniffOnFailureNotInitialized() {
        final long sniffInterval = randomLongBetween(1, Long.MAX_VALUE);
        RestClient restClient = mock(RestClient.class);
import static org.junit.Assert.assertEquals;
        final Sniffer.Task task;
 * SPDX-License-Identifier: Apache-2.0
        if (task.task.isSkipped()) {
            }
                for (int i = 0; i < iters; i++) {
            defaultScheduler.shutdown();
        private final AtomicInteger emptyList = new AtomicInteger(0);
            final Sniffer sniffer = new Sniffer(restClient, nodesSniffer, scheduler, sniffInterval, sniffAfterFailureDelay);
    }
     * (either afterFailure or ordinary) gets cancelled.
import org.opensearch.client.Node;
                        @Override
 * KIND, either express or implied.  See the License for the
        } finally {
        NodesSniffer nodesSniffer = mock(NodesSniffer.class);
        CountingNodesSniffer nodesSniffer = new CountingNodesSniffer();
        } else {
                    if (delayMillis == sniffAfterFailureDelay) {
     * schedule a subsequent afterFailure round. Also, for each onFailure round that starts, the net scheduled round
            assertTrue("timeout waiting for sniffing rounds to be completed", completionLatch.await(1000, TimeUnit.MILLISECONDS));
                            sniffer.sniffOnFailure();
/*
            @Override
        final AtomicBoolean onFailureCompleted = new AtomicBoolean(false);
                    }
            assertThat(ordinaryRoundsTasks.size(), greaterThan(0));
                fail("cancellation exception should have been thrown");
 */
            assertFalse(executor.getContinueExistingPeriodicTasksAfterShutdownPolicy());
        boolean await() throws InterruptedException {
                    assertTrue(future.isDone());
import org.mockito.invocation.InvocationOnMock;
                    cancelledTasks++;
                        completionLatch.countDown();
                    return mockedFuture;
                return future;
        final CountDownLatch completionLatch = new CountDownLatch(1);
                } else {
import java.util.ArrayList;
        }
                        return future;
        verify(scheduledExecutorService).schedule(task, delay, TimeUnit.MILLISECONDS);
        Scheduler noOpScheduler = new Scheduler() {
 */
                    if (delayMillis == 0L) {
                task.future.get();
                Thread thread = executor.getThreadFactory().newThread(new Runnable() {
                            public void run() {
        public void run() {
                    onFailureFutures.add(onFailureExecutor.submit(new Runnable() {
        final AtomicReference<Future<?>> initializingFuture = new AtomicReference<>();
     * Wraps a {@link Sniffer.Task} and allows to wait for its completion. This is needed to verify
                assertEquals(nodesSniffer.failures.get(), failures);
    private static class CountingNodesSniffer implements NodesSniffer {
 *
                public void shutdown() {
            public Future<?> schedule(Sniffer.Task task, long delayMillis) {
    }
                            assertNotEquals(lastNodes, restClient.getNodes());
            for (Future<?> future : futures) {
            }
                }
                });
    }
                } else {
            try {
            }
        assertEquals(iters, totalRuns);
            executor.awaitTermination(1000L, TimeUnit.MILLISECONDS);
                    assertEquals(0L, delayMillis);
            Scheduler noOpScheduler = new Scheduler() {
            Set<Future<?>> onFailureFutures = new CopyOnWriteArraySet<>();
        };
                }
                            }
    /**
        @Override
import static org.junit.Assert.assertFalse;
                    // Here we want to make sure that whenever skip returns false, the task will be completed, otherwise we may be
                        public void run() {
        }
            // while scheduling the next round which is still part of the execution of the runnable itself.
        Sniffer sniffer = new Sniffer(restClient, nodesSniffer, noOpScheduler, 0L, 0L);
                assertEquals(nodesSniffer.emptyList.get(), emptyList);
                }
        final long sniffAfterFailureDelay = randomLongBetween(1, Long.MAX_VALUE);
            }
        } finally {
            for (int i = 0; i < size; i++) {
                        if (nodesSniffer.failures.get() > failures) {
        verify(executor).shutdown();
            assertEquals(completedTasks, nodesSniffer.runs.get());
        verify(executor).shutdownNow();
                }
        RestClient restClient = mock(RestClient.class);
                {
        long sniffAfterFailureDelay = randomLongBetween(1, Long.MAX_VALUE);
                    return mock(Future.class);
            }
                        assertEquals(0L, delayMillis);
    /**
            assertTrue(lastTask.get().hasStarted());
import static org.junit.Assert.assertTrue;
            @Override
 * Licensed to Elasticsearch under one or more contributor
            for (Sniffer.ScheduledTask task : ordinaryRoundsTasks) {
                }
        try {
                futures.add(future);
            public Future<?> schedule(Sniffer.Task task, long delayMillis) {
                    lastTask.set(task);
            for (Sniffer.ScheduledTask afterFailureTask : afterFailureTasks) {
                    }));
            return true;
    }
     * it possible to verify that errors are properly handled and don't affect subsequent runs and their scheduling.
                }
            new Sniffer(restClient, nodesSniffer, scheduler, sniffInterval, sniffAfterFailureDelay);
        Future<?> future = scheduler.schedule(task, delay);
                    assertEquals(sniffInterval, task.nextTaskDelay);
                Future<?> future;
                if (assertTaskCancelledOrCompleted(task)) {
            int size = run % 5 + 1;
            int setNodesRuns = nodesSniffer.runs.get() - nodesSniffer.failures.get() - nodesSniffer.emptyList.get();
                if (assertTaskCancelledOrCompleted(afterFailureTask)) {
 *
            executor.shutdown();
                Sniffer.ScheduledTask scheduledTask = new Sniffer.ScheduledTask(task, future);
        try {
        }
                            assertEquals(lastNodes, restClient.getNodes());
                return null;
        ScheduledExecutorService scheduledExecutorService = mock(ScheduledExecutorService.class);
                    @Override
            public Future<?> schedule(Sniffer.Task task, long delayMillis) {
        defaultScheduler.shutdown();
                    assertEquals(9200, node.getHost().getPort());
     * in which case {@link Future#cancel(boolean)} returns true which is not very helpful.
            lastFuture.get().get();
        verify(restClient, times(setNodesRuns)).setNodes(anyCollection());
        );
        final CountDownLatch completionLatch = new CountDownLatch(1);
        final CountDownLatch initializingLatch = new CountDownLatch(1);
     * Test that {@link Sniffer#close()} shuts down the underlying {@link Scheduler}, and that such calls are idempotent.
                }
                public Future<?> schedule(Sniffer.Task task, long delayMillis) {
        final Set<Future<?>> futures = new CopyOnWriteArraySet<>();
                // as another round is already running. We retry till enough runs get through as that's what we want to test.
                private Future<?> scheduleOrSubmit(Sniffer.Task task) {
        final AtomicBoolean initialized = new AtomicBoolean(false);
        verify(executor, times(2)).awaitTermination(1000, TimeUnit.MILLISECONDS);
            assertTrue(task.task.hasStarted());
        RestClient restClient = mock(RestClient.class);
                        }
            executor.shutdown();
                boolean skip = scheduledTask.skip();
        verify(executor, times(2)).shutdown();
                        }
                    if (onFailureCompleted.get() && onFailureTasks.size() == afterFailureTasks.size()) {
    public void testOrdinarySniffRounds() throws Exception {
     * Test multiple sniffing rounds by mocking the {@link Scheduler} as well as the {@link NodesSniffer}.
                    }
        final AtomicInteger runs = new AtomicInteger(iters);
                    assertFalse(task.hasStarted());
     */
import java.util.concurrent.Executors;
            public void shutdown() {
import java.util.Collections;
                    }
            }
    /**
                }
    public void testClose() {
        verifyNoMoreInteractions(restClient);
 * ownership. Elasticsearch licenses this file to you under
                            lastNodes = restClient.getNodes();
     * Also verifies that the next scheduled round gets cancelled.
        int totalRuns = nodesSniffer.runs.get();
                        assertTrue(initializingFuture.compareAndSet(null, future));
        }
import java.util.concurrent.CancellationException;
                assertFalse(onFailureTask.future.isCancelled());
                    return future;
        DefaultScheduler defaultScheduler = new DefaultScheduler(executor);
                            assertEquals(expectedNodes, restClient.getNodes());
            CountingNodesSniffer nodesSniffer = new CountingNodesSniffer();
            @Override
        Sniffer sniffer = new Sniffer(restClient, new MockNodesSniffer(), scheduler, sniffInterval, sniffAfterFailureDelay);
            // the last future is the only one that may not be completed yet, as the count down happens
    }
                    assertEquals(1, restClient.getNodes().size());
                // the executor is closed externally, shutdown is tested separately
        Sniffer sniffer = new Sniffer(restClient, nodesSniffer, noOpScheduler, 0L, 0L);
        RestClient restClient = mock(RestClient.class);
                    // missing to schedule the following round, which means no sniffing will ever happen again besides on failure sniffing.
            @Override
            for (int i = 0; i < numIters; i++) {
            public void shutdown() {}
 * this work for additional information regarding copyright
                int cancelCalls = randomIntBetween(1, 10);
            };
        try {
                }
}
            assertTrue(task.future.isDone());
     */
        assertEquals(0, totalRuns);
        final Future<?> future = mock(Future.class);
        when(executor.awaitTermination(1000, TimeUnit.MILLISECONDS)).thenReturn(true);
                public ScheduledFuture<?> answer(InvocationOnMock invocationOnMock) {
import java.util.concurrent.ExecutorService;
     * Mock {@link NodesSniffer} implementation used for testing, which most of the times return a fixed node.
            }
import java.util.concurrent.CopyOnWriteArraySet;
        int iters = randomIntBetween(3, 10);
                throw new IOException("communication breakdown");
            @Override
                assertNull(task.future.get());
    }
            assertTrue("timeout waiting for sniffer to get initialized", initializingLatch.await(1000, TimeUnit.MILLISECONDS));
            try (Sniffer sniffer = new Sniffer(restClient, nodesSniffer, noOpScheduler, 1000L, -1)) {
    }
                                    task.run();
        Scheduler scheduler = new Scheduler() {
        TaskWrapper(Sniffer.Task task) {
 * You may obtain a copy of the License at
            }
            } finally {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    // all of the subsequent times "schedule" is called with delay set to the configured sniff interval
            @Override
        CountingNodesSniffer nodesSniffer = new CountingNodesSniffer();
            int completedTasks = onFailureTasks.size() + 1;
                    completedTasks++;
            assertEquals(onFailureTasks.size(), cancelledTasks);
            } catch (CancellationException ignore) {
                    // Here we want to make sure that whenever skip returns true, the task either won't run or it won't do anything,
                    assertFalse(scheduledTask.skip());
        try {
import static org.hamcrest.Matchers.is;
            return false;
 * this file be licensed under the Apache-2.0 license or a
    private static boolean assertTaskCancelledOrCompleted(Sniffer.ScheduledTask task) throws ExecutionException, InterruptedException {
        defaultScheduler.shutdown();
                    cancelledTasks++;
                    task.run();
            for (int i = 1; i <= iters; i++) {
                    } catch (IOException e) {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        private final AtomicInteger runs = new AtomicInteger(0);
        final AtomicInteger shutdown = new AtomicInteger(0);
                    assertEquals(sniffInterval, task.nextTaskDelay);
                        Future<?> future = executor.submit(new Runnable() {
    public void testSniffOnFailure() throws Exception {
        final int iters = randomIntBetween(30, 100);
            verifyNoMoreInteractions(restClient);
        Scheduler noOpScheduler = new Scheduler() {
     * throw {@link CancellationException} straight-away but the execution of the task will continue if it had already started,
import java.util.List;
                assertThat(thread.getName(), equalTo("opensearch_rest_client_sniffer[T#" + i + "]"));
import org.apache.hc.core5.http.HttpHost;
                return future;
            assertThat(executor.getThreadFactory(), instanceOf(Sniffer.SnifferThreadFactory.class));
        int minNumOnFailureRounds = randomIntBetween(5, 10);
        final long sniffInterval = randomLongBetween(1, Long.MAX_VALUE);
     * Tests the {@link Sniffer#sniff()} method in isolation. Verifies that it uses the {@link NodesSniffer} implementation
        CountingNodesSniffer nodesSniffer = new CountingNodesSniffer();
        verifyNoMoreInteractions(executor);
import java.util.concurrent.ScheduledFuture;
        }
                    assertTrue(task.toString(), task.hasStarted());
import org.opensearch.client.RestClientTestCase;
     * It also asserts that it never gets called concurrently, based on the assumption that only one sniff run can be run
                }
                emptyList.incrementAndGet();
                    assertEquals(sniffInterval, task.nextTaskDelay);
        final Set<Sniffer.ScheduledTask> afterFailureTasks = new CopyOnWriteArraySet<>();
            new Answer<ScheduledFuture<?>>() {
     */
                    assertEquals(sniffInterval, delayMillis);
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        final ExecutorService executor = Executors.newSingleThreadExecutor();
            for (Sniffer.ScheduledTask onFailureTask : onFailureTasks) {
        final CountDownLatch completionLatch = new CountDownLatch(1);
                    Node node = restClient.getNodes().get(0);
            public Future<?> schedule(Sniffer.Task task, long delayMillis) {
 *
                        } else {
                } else {
                    } else {
    public void testSniff() throws IOException {
                int emptyList = 0;
import static org.junit.Assert.assertThat;
                // we submit rather than scheduling to make the test quick and not depend on time
        Sniffer sniffer = new Sniffer(restClient, nodesSniffer, scheduler, sniffInterval, sniffAfterFailureDelay);
    /**
import static org.junit.Assert.assertNull;
            verify(future, times(i)).cancel(false);
import java.util.concurrent.TimeUnit;
        verifyNoMoreInteractions(scheduledExecutorService, mockedFuture);
                assertFalse(onFailureTask.task.isSkipped());
            assertThat(onFailureTasks.size(), greaterThanOrEqualTo(minNumOnFailureRounds));
            assertThat(executorService, instanceOf(ScheduledThreadPoolExecutor.class));
            } finally {
import org.opensearch.client.RestClient;
            assertEquals(i, shutdown.get());
     * to retrieve nodes and set them (when not empty) to the provided {@link RestClient} instance.
                }
        final AtomicBoolean initializing = new AtomicBoolean(true);
        final AtomicReference<Future<?>> lastFuture = new AtomicReference<>();
    public void testDefaultSchedulerThreadFactory() {
            return completionLatch.await(1000, TimeUnit.MILLISECONDS);
                    // otherwise we may end up with parallel sniffing tracks given that each task schedules the following one. We need to
 */
                        return executor.schedule(task, randomLongBetween(0L, 200L), TimeUnit.MILLISECONDS);
                    // completion. The execution continues though so we use a latch to try and wait for the task to be completed.
                    }
    public void testTaskCancelling() throws Exception {
                while (onFailureTasks.size() < minNumOnFailureRounds) {
                }
                        runs++;
                onFailureExecutor.shutdown();
        };
                @Override
        int totalRuns = nodesSniffer.runs.get();
                int runs = 0;
     * delays while allowing to assert that the requested delays for each requested run and the following one are the expected values.
 * the Apache License, Version 2.0 (the "License"); you may
            }
            }
                }
                            assertEquals("communication breakdown", e.getMessage());
