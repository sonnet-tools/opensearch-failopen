    }
            try {
     *
        private static ScheduledExecutorService initScheduledExecutorService() {
     */
        return new SnifferBuilder(restClient);
import java.io.IOException;
        boolean skip() {
     * it will also schedule a new round after sniffAfterFailureDelay ms.
         * Returns true if the task was set to be skipped before it was started
        if (logger.isDebugEnabled()) {
 * ownership. Elasticsearch licenses this file to you under
 * Unless required by applicable law or agreed to in writing,
import java.util.concurrent.ScheduledExecutorService;
             * or entirely run. In the odd case that future#cancel returns true and the thread still runs, the task won't do anything.
        this(restClient, nodesSniffer, new DefaultScheduler(), sniffInterval, sniffAfterFailureDelay);
import java.util.concurrent.Executors;
        /*
            if (taskState.compareAndSet(TaskState.WAITING, TaskState.STARTED) == false) {
 * A background task fetches the nodes through the {@link NodesSniffer} and sets them to the {@link RestClient} instance.
                 * assigned to nextTask till this onFailure round gets run and schedules its corresponding afterFailure round.
            }
        void shutdown();
            this.nextTaskDelay = nextTaskDelay;
            }
                return;
import org.apache.commons.logging.Log;
            this.future = future;
                nextScheduledTask = new ScheduledTask(task, future);
    static final class ScheduledTask {
 */
        STARTED
         * Cancels this task. Returns true if the task has been successfully cancelled, meaning it won't be executed
    }
         * already cancelled or already completed).
            /*
    /**
                executor.shutdownNow();
        // sniffOnFailure does nothing until the initial sniffing round has been completed
    private final long sniffAfterFailureDelayMillis;
            } finally {
        public void run() {
         * Sets this task to be skipped. Returns true if the task will be skipped, false if the task has already started.
         * We do not keep track of the returned future as we never intend to cancel the initial sniffing round, we rather
    }
 */
        private final String namePrefix;
             * Skipped or already started tasks do nothing. In most cases tasks will be cancelled and not run, but we want to protect for
 * the Apache License, Version 2.0 (the "License"); you may
             * returns false and the task will normally run.
        }
import java.util.concurrent.ScheduledThreadPoolExecutor;
        @Override
                ScheduledTask previousTask = nextScheduledTask;
        } else {
            });
 * specific language governing permissions and limitations
            try {
        this.sniffAfterFailureDelayMillis = sniffAfterFailureDelay;
    interface Scheduler {
         */
 * not use this file except in compliance with the License.
    /**
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (executor.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
        if (initialized.get()) {
        }
        if (sniffedNodes.isEmpty()) {
                assert initialized.get() == false || previousTask.task.isSkipped() || previousTask.task.hasStarted()
        }
         */
 * under the License.
        /**
            } catch (Exception e) {
     * The Scheduler interface allows to isolate the sniffing scheduling aspects so that we can test
        boolean skip() {
                // tasks are run by a single threaded executor, so swapping is safe with a simple volatile variable
            public void run() {
        final Task task;
                public ThreadFactory run() {
                    return Executors.defaultThreadFactory();
import org.opensearch.client.RestClientBuilder;
 * You may obtain a copy of the License at
        @Override
            });
                /*
            this.originalThreadFactory = AccessController.doPrivileged(new PrivilegedAction<ThreadFactory>() {
         */
        final Future<?> future;
package org.opensearch.client.sniff;
     * @return a new instance of {@link SnifferBuilder}
        WAITING,
                    : "task that we are replacing is neither " + "cancelled nor has it ever started";
                }
 * It is possible to perform sniffing on failure by creating a {@link SniffOnFailureListener} and providing it as an argument to
            if (this.nextScheduledTask.skip()) {
        private final AtomicInteger threadNumber = new AtomicInteger(1);
                public Thread run() {
import java.util.concurrent.atomic.AtomicReference;
            nextScheduledTask.skip();
        boolean hasStarted() {
import java.security.AccessController;
        this.scheduler.shutdown();
                    t.setName(namePrefix + "[T#" + threadNumber.getAndIncrement() + "]");
            ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1, new SnifferThreadFactory(SNIFFER_THREAD_NAME));
 * previously created SniffOnFailureListener through {@link SniffOnFailureListener#setSniffer(Sniffer)}.
     * the sniffer by injecting when needed a custom scheduler that is more suited for testing.
     * Schedule sniffing to run as soon as possible if it isn't already running. Once such sniffing round runs
             * trust it much though so we try to cancel hoping that it will work.  At the same time we always call skip too, which means
    }
         * Returns true if the task has started, false in case it didn't start (yet?) or it was skipped
            future.cancel(false);
            }
        }
        }
        private final ThreadFactory originalThreadFactory;
             */
        if (initialized.get()) {
    }
        scheduler.schedule(task, 0L);
             * cases where future#cancel returns true yet the task runs. We want to make sure that such tasks do nothing otherwise they will
    final void sniff() throws IOException {
    Sniffer(RestClient restClient, NodesSniffer nodesSniffer, Scheduler scheduler, long sniffInterval, long sniffAfterFailureDelay) {
import org.apache.commons.logging.LogFactory;
                    Thread t = originalThreadFactory.newThread(r);
import org.opensearch.client.RestClient;
        }
        }
        }
import java.io.Closeable;
        }
     *      {@link RestClient#setNodes(Collection)}) once they are fetched
 * GitHub history for details.
                 * We do not keep track of this future as the task will immediately run and we don't intend to cancel it
        /**
 */
                }
 * Modifications Copyright OpenSearch Contributors. See
 *
            executor.shutdown();
import java.security.PrivilegedAction;
         */
    /**
            return taskState.compareAndSet(TaskState.WAITING, TaskState.SKIPPED);
         * Schedules the provided {@link Runnable} to be executed in <code>delayMillis</code> milliseconds
        }
/**
/*
            this.namePrefix = namePrefix;
    public void sniffOnFailure() {
            return task.skip();
    }
    class Task implements Runnable {
        /*
 * software distributed under the License is distributed on an
                    return;
            this.executor = executor;
        Task task = new Task(sniffIntervalMillis) {
            executor.setRemoveOnCancelPolicy(true);
                Future<?> future = scheduler.schedule(task, nextTaskDelay);
 * {@link RestClient}. Must be created via {@link SnifferBuilder}, which allows to set all of the different options or rely on defaults.
        ScheduledTask(Task task, Future<?> future) {
                    t.setDaemon(true);
             */
import java.util.Collection;
 * license agreements. See the NOTICE file distributed with
             * schedule another round at the end and so on, leaving us with multiple parallel sniffing "tracks" whish is undesirable.
        }
    }
             * false but we prefer to stay on the safe side.
        this.restClient = restClient;
             * In case future#cancel returns true but the task has already started, this state change will not succeed hence this method
        }
    private static final String SNIFFER_THREAD_NAME = "opensearch_rest_client_sniffer";
    }
                 */
import java.util.concurrent.ThreadFactory;
    public static SnifferBuilder builder(RestClient restClient) {
    private final AtomicBoolean initialized = new AtomicBoolean(false);
            return AccessController.doPrivileged(new PrivilegedAction<Thread>() {
         * prevent any other operation from being executed till the sniffer is properly initialized
         */
         */
                @Override
 * this work for additional information regarding copyright
            logger.debug("sniffed nodes: " + sniffedNodes);
         * or if it is its execution won't have any effect. Returns false if the task cannot be cancelled (possibly it was
                scheduler.schedule(new Task(sniffAfterFailureDelayMillis), 0L);
    @SuppressWarnings("removal")
            return taskState.get() == TaskState.SKIPPED;
                Thread.currentThread().interrupt();
    }
 * Licensed to Elasticsearch under one or more contributor
import java.util.concurrent.Future;
                @Override
            /*
                super.run();
        this.nodesSniffer = nodesSniffer;
         */
             * Threads may still get run although future#cancel returns true. We make sure that a task is either cancelled (or skipped),
             */
        }
        }
                 * due to concurrent sniffOnFailure runs. Effectively the previous (now cancelled or skipped) task will stay
    }
            /*
 * this file be licensed under the Apache-2.0 license or a
     * Default implementation of {@link Scheduler}, based on {@link ScheduledExecutorService}
            this.task = task;
             * Future#cancel should return false whenever a task cannot be cancelled, most likely as it has already started. We don't
         * Shuts this scheduler down
        Task(long nextTaskDelay) {
                }
        SKIPPED,
import java.util.List;
     * Returns a new {@link SnifferBuilder} to help with {@link Sniffer} creation.
             */
                    return t;
            }
    }
        List<Node> sniffedNodes = nodesSniffer.sniff();
        /**
        final ScheduledExecutorService executor;
        @Override
            restClient.setNodes(sniffedNodes);
}
        };
public class Sniffer implements Closeable {
        /**
        }
        this.sniffIntervalMillis = sniffInterval;
            @Override
        final AtomicReference<TaskState> taskState = new AtomicReference<>(TaskState.WAITING);
    enum TaskState {
        private SnifferThreadFactory(String namePrefix) {
                logger.error("error while sniffing nodes", e);
    public void close() {
        public Future<?> schedule(Task task, long delayMillis) {
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.atomic.AtomicBoolean;
        }
        DefaultScheduler() {
        Future<?> schedule(Task task, long delayMillis);
    }
             * that if the task has already started the state change will fail. We could potentially not call skip when cancel returns
    Sniffer(RestClient restClient, NodesSniffer nodesSniffer, long sniffInterval, long sniffAfterFailureDelay) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final long sniffIntervalMillis;
 *
        boolean isSkipped() {
     */
             * Concurrent calls may be checking the same task state, but only the first skip call on the same task returns true.
import org.opensearch.client.Node;
 * The OpenSearch Contributors require contributions made to
import java.util.concurrent.atomic.AtomicInteger;
                sniff();
        }
            return executor.schedule(task, delayMillis, TimeUnit.MILLISECONDS);
        }
             * The task may also get replaced while we check its state, in which case calling skip on it returns false.
            return executor;
 * KIND, either express or implied.  See the License for the
    private final NodesSniffer nodesSniffer;
    static class SnifferThreadFactory implements ThreadFactory {
    private volatile ScheduledTask nextScheduledTask;
/*
         */
            } catch (InterruptedException ignore) {
        DefaultScheduler(ScheduledExecutorService executor) {
        /**
 * Class responsible for sniffing nodes from some source (default is opensearch itself) and setting them to a provided instance of
    @Override
 */
        /**
    private final Scheduler scheduler;
            this(initScheduledExecutorService());
            /*
        @Override
import java.util.concurrent.TimeUnit;
        public void shutdown() {
            }
     */
    /**
 * {@link RestClientBuilder#setFailureListener(RestClient.FailureListener)}. The Sniffer implementation needs to be lazily set to the
 *
         * The first sniffing round is async, so this constructor returns before nextScheduledTask is assigned to a task.
                Task task = new Task(sniffIntervalMillis);
     */
    private final RestClient restClient;
             * If sniffing is already running, there is no point in scheduling another round right after the current one.
     * @param restClient the client that gets its hosts set (via
         * The initialized flag is a protection against NPE due to that.
                initialized.compareAndSet(false, true);
            logger.warn("no nodes to set, nodes will be updated at the next sniffing round");
 * compatible open source license.
        this.scheduler = scheduler;
        final long nextTaskDelay;
        public Thread newThread(final Runnable r) {
            return taskState.get() == TaskState.STARTED;
    static final class DefaultScheduler implements Scheduler {
    private static final Log logger = LogFactory.getLog(Sniffer.class);
