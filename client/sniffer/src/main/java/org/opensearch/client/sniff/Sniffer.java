        return new SnifferBuilder(restClient);  
        private static ScheduledExecutorService initScheduledExecutorService() {  
}  
    public void close() {  
        /**
        }
 *
import org.opensearch.client.RestClient;
                executor.shutdownNow();  
        this.scheduler = scheduler;
         * Returns true if the task was set to be skipped before it was started
            return taskState.compareAndSet(TaskState.WAITING, TaskState.SKIPPED);
         * The initialized flag is a protection against NPE due to that.
    interface Scheduler {
        void shutdown();
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            executor.setRemoveOnCancelPolicy(true);
        }
 * not use this file except in compliance with the License.
     * Default implementation of {@link Scheduler}, based on {@link ScheduledExecutorService}
        Task task = new Task(sniffIntervalMillis) {
    /**
    /**
        }  
        this.scheduler.shutdown();
import java.util.concurrent.TimeUnit;  
 */  
/*  
        } else {  
            logger.debug("sniffed nodes: " + sniffedNodes);
                }
package org.opensearch.client.sniff;
            }
        }  
            return task.skip();
                public Thread run() {  
 * You may obtain a copy of the License at  
     * @return a new instance of {@link SnifferBuilder}  
    private final NodesSniffer nodesSniffer;  
        this.sniffIntervalMillis = sniffInterval;  
 * KIND, either express or implied.  See the License for the
            this.task = task;
        }
public class Sniffer implements Closeable {
        @Override  
 */
        public void run() {
             * If sniffing is already running, there is no point in scheduling another round right after the current one.
 * Modifications Copyright OpenSearch Contributors. See
             * The task may also get replaced while we check its state, in which case calling skip on it returns false.
 */  
 * Class responsible for sniffing nodes from some source (default is opensearch itself) and setting them to a provided instance of  
                return;  
        /*
             * trust it much though so we try to cancel hoping that it will work.  At the same time we always call skip too, which means
        this.restClient = restClient;
     * Schedule sniffing to run as soon as possible if it isn't already running. Once such sniffing round runs
        final AtomicReference<TaskState> taskState = new AtomicReference<>(TaskState.WAITING);
        final long nextTaskDelay;  
            } catch (InterruptedException ignore) {
import org.opensearch.client.Node;  
 * Unless required by applicable law or agreed to in writing,
            @Override
    }  
    static final class ScheduledTask {  
            return taskState.get() == TaskState.STARTED;  
        private SnifferThreadFactory(String namePrefix) {
            return executor.schedule(task, delayMillis, TimeUnit.MILLISECONDS);
            });
             * Skipped or already started tasks do nothing. In most cases tasks will be cancelled and not run, but we want to protect for
    private final RestClient restClient;
            restClient.setNodes(sniffedNodes);
 * the Apache License, Version 2.0 (the "License"); you may
                 * assigned to nextTask till this onFailure round gets run and schedules its corresponding afterFailure round.
    private final Scheduler scheduler;
                    t.setName(namePrefix + "[T#" + threadNumber.getAndIncrement() + "]");
                logger.error("error while sniffing nodes", e);
                    return t;
import java.util.List;  
import java.util.concurrent.Future;
        if (sniffedNodes.isEmpty()) {
        }  
         */  
                nextScheduledTask = new ScheduledTask(task, future);
            return executor;  
                assert initialized.get() == false || previousTask.task.isSkipped() || previousTask.task.hasStarted()  
             */
            this.originalThreadFactory = AccessController.doPrivileged(new PrivilegedAction<ThreadFactory>() {  
 * {@link RestClientBuilder#setFailureListener(RestClient.FailureListener)}. The Sniffer implementation needs to be lazily set to the
             * cases where future#cancel returns true yet the task runs. We want to make sure that such tasks do nothing otherwise they will
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.security.PrivilegedAction;
        final Task task;
     * it will also schedule a new round after sniffAfterFailureDelay ms.
import java.util.concurrent.ScheduledExecutorService;  
        DefaultScheduler() {
            this.nextTaskDelay = nextTaskDelay;
         */  
        this.nodesSniffer = nodesSniffer;
                    t.setDaemon(true);  
        final Future<?> future;
        if (logger.isDebugEnabled()) {
                /*
            }  
                initialized.compareAndSet(false, true);
                if (executor.awaitTermination(1000, TimeUnit.MILLISECONDS)) {  
        }
import org.opensearch.client.RestClientBuilder;
    }  
 * license agreements. See the NOTICE file distributed with
        boolean skip() {  
                // tasks are run by a single threaded executor, so swapping is safe with a simple volatile variable  
         * prevent any other operation from being executed till the sniffer is properly initialized
            this.future = future;  
         */
            }
 * compatible open source license.
     * the sniffer by injecting when needed a custom scheduler that is more suited for testing.
/*  
             * returns false and the task will normally run.
        this(restClient, nodesSniffer, new DefaultScheduler(), sniffInterval, sniffAfterFailureDelay);  
         */
         * Cancels this task. Returns true if the task has been successfully cancelled, meaning it won't be executed
    private final long sniffIntervalMillis;
import java.util.concurrent.ThreadFactory;
            ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1, new SnifferThreadFactory(SNIFFER_THREAD_NAME));
        // sniffOnFailure does nothing until the initial sniffing round has been completed
        private final AtomicInteger threadNumber = new AtomicInteger(1);  
         * The first sniffing round is async, so this constructor returns before nextScheduledTask is assigned to a task.
             */  
                 * due to concurrent sniffOnFailure runs. Effectively the previous (now cancelled or skipped) task will stay  
import org.apache.commons.logging.LogFactory;
 * {@link RestClient}. Must be created via {@link SnifferBuilder}, which allows to set all of the different options or rely on defaults.
     */  
     */  
             * or entirely run. In the odd case that future#cancel returns true and the thread still runs, the task won't do anything.  
/**
        }
            /*  
 * previously created SniffOnFailureListener through {@link SniffOnFailureListener#setSniffer(Sniffer)}.
                @Override
             * Future#cancel should return false whenever a task cannot be cancelled, most likely as it has already started. We don't
            executor.shutdown();
             * that if the task has already started the state change will fail. We could potentially not call skip when cancel returns  
            } catch (Exception e) {
        boolean isSkipped() {
        public Thread newThread(final Runnable r) {  
        ScheduledTask(Task task, Future<?> future) {
        @Override
    Sniffer(RestClient restClient, NodesSniffer nodesSniffer, Scheduler scheduler, long sniffInterval, long sniffAfterFailureDelay) {  
        /**
                 * We do not keep track of this future as the task will immediately run and we don't intend to cancel it
 *  
            this(initScheduledExecutorService());
    }  
                @Override
 * Licensed to Elasticsearch under one or more contributor  
import java.util.concurrent.Executors;
            this.executor = executor;  
    private static final Log logger = LogFactory.getLog(Sniffer.class);  
        boolean hasStarted() {
        /*  
        if (initialized.get()) {
             * In case future#cancel returns true but the task has already started, this state change will not succeed hence this method
    final void sniff() throws IOException {
             * Threads may still get run although future#cancel returns true. We make sure that a task is either cancelled (or skipped),
        STARTED
            logger.warn("no nodes to set, nodes will be updated at the next sniffing round");
 * software distributed under the License is distributed on an
    }
 * specific language governing permissions and limitations
        };
        /**
        /**  
         * Schedules the provided {@link Runnable} to be executed in <code>delayMillis</code> milliseconds  
     *  
                public ThreadFactory run() {
import java.util.concurrent.atomic.AtomicInteger;
    static class SnifferThreadFactory implements ThreadFactory {
        }
    class Task implements Runnable {
         * We do not keep track of the returned future as we never intend to cancel the initial sniffing round, we rather  
 * The OpenSearch Contributors require contributions made to  
                 */
    private final long sniffAfterFailureDelayMillis;  
    public void sniffOnFailure() {
 * A background task fetches the nodes through the {@link NodesSniffer} and sets them to the {@link RestClient} instance.
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
    private final AtomicBoolean initialized = new AtomicBoolean(false);
    }
import java.util.Collection;
        }  
        /**  
    static final class DefaultScheduler implements Scheduler {
        }
     *      {@link RestClient#setNodes(Collection)}) once they are fetched
    /**  
            } finally {  
     * Returns a new {@link SnifferBuilder} to help with {@link Sniffer} creation.
        /**
        SKIPPED,
                }
    @Override
        if (initialized.get()) {  
 * this file be licensed under the Apache-2.0 license or a
            public void run() {  
        }  
                Task task = new Task(sniffIntervalMillis);
        private final String namePrefix;
        DefaultScheduler(ScheduledExecutorService executor) {
        final ScheduledExecutorService executor;
         * already cancelled or already completed).  
            /*
        }  
        private final ThreadFactory originalThreadFactory;
    private volatile ScheduledTask nextScheduledTask;  
         */
 */  
    }
             */
     * The Scheduler interface allows to isolate the sniffing scheduling aspects so that we can test
import java.io.Closeable;
            try {
 * GitHub history for details.
            }  
import java.security.AccessController;  
                    return Executors.defaultThreadFactory();  
    Sniffer(RestClient restClient, NodesSniffer nodesSniffer, long sniffInterval, long sniffAfterFailureDelay) {
             * schedule another round at the end and so on, leaving us with multiple parallel sniffing "tracks" whish is undesirable.  
        List<Node> sniffedNodes = nodesSniffer.sniff();  
    }
         * Shuts this scheduler down
        Future<?> schedule(Task task, long delayMillis);
             * Concurrent calls may be checking the same task state, but only the first skip call on the same task returns true.  
    }
     */
         */
    enum TaskState {
            return taskState.get() == TaskState.SKIPPED;
 * under the License.  
 * It is possible to perform sniffing on failure by creating a {@link SniffOnFailureListener} and providing it as an argument to  
    private static final String SNIFFER_THREAD_NAME = "opensearch_rest_client_sniffer";
import org.apache.commons.logging.Log;
        this.sniffAfterFailureDelayMillis = sniffAfterFailureDelay;
                sniff();  
        }
         */
        public void shutdown() {  
         * Returns true if the task has started, false in case it didn't start (yet?) or it was skipped  
                    Thread t = originalThreadFactory.newThread(r);
 *
     * @param restClient the client that gets its hosts set (via
    }
        }  
        Task(long nextTaskDelay) {  
        @Override
             * false but we prefer to stay on the safe side.
     */  
        @Override
 * SPDX-License-Identifier: Apache-2.0
            if (taskState.compareAndSet(TaskState.WAITING, TaskState.STARTED) == false) {
    /**  
            /*
            return AccessController.doPrivileged(new PrivilegedAction<Thread>() {
             */
        }
        WAITING,  
            nextScheduledTask.skip();
            future.cancel(false);  
import java.util.concurrent.atomic.AtomicReference;  
         * or if it is its execution won't have any effect. Returns false if the task cannot be cancelled (possibly it was
        boolean skip() {
import java.util.concurrent.ScheduledThreadPoolExecutor;
                    : "task that we are replacing is neither " + "cancelled nor has it ever started";
    public static SnifferBuilder builder(RestClient restClient) {
            this.namePrefix = namePrefix;
    @SuppressWarnings("removal")
                }
         * Sets this task to be skipped. Returns true if the task will be skipped, false if the task has already started.
    }
            if (this.nextScheduledTask.skip()) {  
            });  
 * this work for additional information regarding copyright
                Future<?> future = scheduler.schedule(task, nextTaskDelay);
        }
        scheduler.schedule(task, 0L);  
            try {
 * ownership. Elasticsearch licenses this file to you under  
                scheduler.schedule(new Task(sniffAfterFailureDelayMillis), 0L);  
                ScheduledTask previousTask = nextScheduledTask;
         */  
                    return;
                Thread.currentThread().interrupt();
            }
                super.run();
        public Future<?> schedule(Task task, long delayMillis) {
            /*  
    }
