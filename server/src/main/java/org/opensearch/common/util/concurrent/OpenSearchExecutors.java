        if (Node.NODE_NAME_SETTING.exists(settings)) {
            max,
     * shutdown.
import org.opensearch.common.unit.TimeValue;
                    // executor to add a worker if it can; combined
import java.util.List;
     * @param namePrefix     the name prefix for virtual threads
        }
     * Cannot instantiate.
            runnableWrapper,
 *
    }
         * Workaround for https://bugs.openjdk.org/browse/JDK-8323659 regression, introduced in JDK-21.0.2.
                    value,
            0,
import java.util.Optional;
    public static int allocatedProcessors(final Settings settings) {
            targetedResponseTime,
    /**
            maxQueueSize,
            return threadName(Node.NODE_NAME_SETTING.get(settings), namePrefix);
                 * exception. We want to ignore cancellation exceptions, restore the interrupt status on interrupted exceptions, and
        final String namePrefix,
import org.opensearch.common.settings.Setting.Property;
            return threadName("", namePrefix);
            try {
 * software distributed under the License is distributed on an
     * A handler for rejected tasks that adds the specified element to this queue,
     * @param frameSize number of tasks during which stats are collected before adjusting queue size
        PROCESSORS_SETTING,
        String name,
        }
            // TODO this should only be allowed in tests
import org.opensearch.common.SuppressForbidden;
            new OpenSearchAbortPolicy(),
                 * handled by the executed task or the task submitter.
 * Modifications Copyright OpenSearch Contributors. See
        ScheduledExecutorService timer
            size,
     *
        final ThreadFactory threadFactory = Thread.ofVirtual().name(threadName(nodeName, namePrefix) + "#", 0).factory();
        @Override
    /**
            rethrowErrors(command);
import java.util.concurrent.ThreadFactory;
            0,
        @Override
            size,
     * Return a new executor that will automatically adjust the queue size based on queue throughput.
        public void execute(Runnable command) {
        @Override
     *
    /**
 * compatible open source license.
     * to the uncaught exception handler.
     * Checks if the runnable arose from asynchronous submission of a task to an executor. If an uncaught exception was thrown
                if (left > 0) {
    /**
    private static Function<String, Integer> processorsParser(final String name) {
    static class OpenSearchThreadFactory implements ThreadFactory {
        Function<Runnable, WrappedRunnable> runnableWrapper;
        int size,
        ThreadFactory threadFactory,
        );
            return false;
        public boolean offer(E e, long timeout, TimeUnit unit) {
                final Optional<Error> maybeError = ExceptionsHelper.maybeError(e);
        if (queueCapacity <= 0) {
        ThreadContext contextHolder
            return false;
                    name,
            assert ((RunnableFuture) runnable).isDone();
                "initial queue capacity for [" + name + "] executor must be positive, got: " + initialQueueCapacity
            min,
        } else {
        }
     */
                if (maybeError.isPresent()) {
import java.util.concurrent.atomic.AtomicInteger;
     * @opensearch.internal
     * @param initialQueueCapacity initial size of the executor queue
            runnableWrapper = TimedRunnable::new;
import org.opensearch.ExceptionsHelper;
        public long rejected() {
        String name,
        ThreadFactory threadFactory,
    }
            name,
        String name,
    public static ExecutorService newDirectExecutorService() {
     * Returns a new executor that creates a new virtual thread for each task.
 * under the License.
                // a scaling queue never blocks so a put to it can never be interrupted
        }
     */
    private static final class DirectExecutorService extends AbstractExecutorService {
        OpenSearchThreadPoolExecutor executor = new OpenSearchThreadPoolExecutor(
                    // reject queuing the task to force the thread pool
        public boolean isShutdown() {
     * A scaling queue for executors
    ) {
    );
            threadFactory,
        processorsParser("node.processors"),
        } else {
        ThreadContext contextHolder,
        }
import java.util.concurrent.ThreadPoolExecutor;
        final ThreadContext threadContext
    }
        final ExecutorService delegate = Executors.newThreadPerTaskExecutor(threadFactory);
        );
     * Setting to manually set the number of available processors. This setting is used to adjust thread pool sizes per node.
         * Workaround for https://bugs.openjdk.org/browse/JDK-8323659 regression, introduced in JDK-21.0.2.
            initialQueueCapacity
    /**
    public static ThreadFactory daemonThreadFactory(Settings settings, String namePrefix) {
        Property.NodeScope
                    Thread.currentThread().interrupt();
     * Setting to manually control the number of allocated processors. This setting is used to adjust thread pool sizes per node. The
                    "setting [{}] to value [{}] which is more than available processors [{}] is deprecated",
        "processors",
        @SuppressForbidden(reason = "properly rethrowing errors, see OpenSearchExecutors.rethrowErrors")
            throw new IllegalArgumentException(
            super();
public class OpenSearchExecutors {
            command.run();
        public boolean isTerminated() {
     * A thread factory
     * @return the number of allocated processors
            new OpenSearchAbortPolicy(),
    ) {
            throw new UnsupportedOperationException();
            // first try to transfer to a waiting worker thread
        @Override
     */
            SecurityManager s = System.getSecurityManager();
            } catch (final InterruptedException e) {
            return super.offer(e);
     * available to OpenSearch (e.g., because of CPU limits).
     *
        Property.Deprecated,
        }
        "node.processors",
            TimeUnit.MILLISECONDS,
import org.opensearch.common.logging.DeprecationLogger;
            TimedRunnable::new,
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
                    // with ForceQueuePolicy, this causes the thread
            throw new UnsupportedOperationException();
    /**
 * this work for additional information regarding copyright
        queue.executor = executor;
     * @param threadContext  the thread context to preserve across task execution
            size,
        @Override
        @Override
        }
        int max,
                    // restore the interrupt status
     * Returns the number of allocated processors. Defaults to {@link Runtime#availableProcessors()} but can be overridden by passing a
import java.util.concurrent.TimeUnit;
        @Override
                assert e instanceof CancellationException || e instanceof InterruptedException || e instanceof ExecutionException : e;
    ) {
            size,
    private OpenSearchExecutors() {}
                }
            size,
            contextHolder
     * @param minQueueSize minimum queue size that the queue can be adjusted to
        public boolean offer(E e) {
        return null;
     *
    private static final ExecutorService DIRECT_EXECUTOR_SERVICE = new DirectExecutorService();
 * ownership. Elasticsearch licenses this file to you under
 * Executors.
    }
        assert nodeName != null && false == nodeName.isEmpty();
            };
 * KIND, either express or implied.  See the License for the
            } catch (final Exception e) {
    static class ForceQueuePolicy implements XRejectedExecutionHandler {
    public static String threadName(Settings settings, String namePrefix) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
            }
                 * exception to ensure that there is not a buried error anywhere. We assume that a general exception has been
 * the Apache License, Version 2.0 (the "License"); you may
        if (initialQueueCapacity <= 0) {
        @SuppressWarnings("removal")
 */
        /**
    public static PrioritizedOpenSearchThreadPoolExecutor newSinglePrioritizing(
        }
     * Returns an {@link ExecutorService} that executes submitted tasks on the current thread. This executor service does not support being
     */
package org.opensearch.common.util.concurrent;
     */
            contextHolder
     */
        final ThreadGroup group;
     * @return non fatal exception or null if no exception.
     *
        public void shutdown() {
        String name,
            throw new UnsupportedOperationException();
        return new VirtualThreadPerTaskExecutorService(delegate, threadContext);
                    // pool to always scale up to max pool size and we
    public static String threadName(final String nodeName, final String namePrefix) {
     * @opensearch.internal
        s -> Integer.toString(Runtime.getRuntime().availableProcessors()),
        ExecutorScalingQueue() {}
        AtomicReference<RunnableTaskExecutionListener> runnableTaskListener
import java.util.concurrent.CancellationException;
        int size,
    );
        public List<Runnable> shutdownNow() {
import org.opensearch.node.Node;
        /**
/*
 * You may obtain a copy of the License at
        return new QueueResizingOpenSearchThreadPoolExecutor(
            queue,
        final String nodeName,
    }
    /**
            new ForceQueuePolicy(),
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
import java.util.concurrent.atomic.AtomicReference;
                    return super.offer(e);
    }
     */
 *
        return daemonThreadFactory(threadName(nodeName, namePrefix));
     *
        }
            return super.offer(e);
    }
            contextHolder
                } else {
    public static ThreadFactory daemonThreadFactory(String nodeName, String namePrefix) {
                    return e.getCause();
            frameSize,
                 * In theory, Future#get can only throw a cancellation exception, an interrupted exception, or an execution
    public static ThreadFactory daemonThreadFactory(String namePrefix) {
        @Override
            } else {
        final AtomicInteger threadNumber = new AtomicInteger(1);
                TaskAwareRunnable taskAwareRunnable = new TaskAwareRunnable(contextHolder, runnable, runnableTaskListener);
    public static OpenSearchThreadPoolExecutor newAutoQueueFixed(
            }
            contextHolder
        assert nodeName != null && false == nodeName.isEmpty();
     * default value is {@link Runtime#availableProcessors()} but should be manually controlled if not all processors on the machine are
        }
                throw new AssertionError(e);
     * @param settings a {@link Settings} instance from which to derive the allocated processors
        if (queueCapacity < 0) {
}
            }
        return DIRECT_EXECUTOR_SERVICE;
        }
        ThreadContext contextHolder
            name,
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(OpenSearchExecutors.class);
        );
                return new TimedRunnable(taskAwareRunnable);
        /**
    public static final Setting<Integer> NODE_PROCESSORS_SETTING = new Setting<>(
         */
    /**
                // check if there might be spare capacity in the thread
        DirectExecutorService() {
 * Licensed to Elasticsearch under one or more contributor
                // force queue policy should only be used with a scaling queue
        );
                assert executor.getQueue() instanceof ExecutorScalingQueue;
            final int value = Setting.parseInt(s, 1, name);
        ThreadPoolExecutor executor;
 * @opensearch.internal
            queue,
                }
        return daemonThreadFactory(threadName(settings, namePrefix));
        int queueCapacity,
            TimeUnit.MILLISECONDS,
        public boolean add(E e) {
        @Override
    public static OpenSearchThreadPoolExecutor newResizable(
            );
    ) {
            final int availableProcessors = Runtime.getRuntime().availableProcessors();
                }
                /*
                // pool executor
                    return false;
        @Override
        int minQueueSize,
         * Workaround for https://bugs.openjdk.org/browse/JDK-8323659 regression, introduced in JDK-21.0.2.
    static class ExecutorScalingQueue<E> extends LinkedTransferQueue<E> {
                }
            Thread t = new Thread(group, r, namePrefix + "[T#" + threadNumber.getAndIncrement() + "]", 0);
        public boolean awaitTermination(long timeout, TimeUnit unit) {
        public Thread newThread(Runnable r) {
     */
        TimeValue targetedResponseTime,
 */
    }
        ThreadContext contextHolder,
                    "processors_" + name,
import java.util.concurrent.BlockingQueue;
            return t;
        long keepAliveTime,
        }
                ((RunnableFuture) runnable).get();
            runnableWrapper = (runnable) -> {
            if (!tryTransfer(e)) {
            name,
        return s -> {
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(
    }
            threadFactory,
            size,
        };
    }
     * @param maxQueueSize maximum queue size that the queue can be adjusted to
        }
        }
        );
import java.util.concurrent.ScheduledExecutorService;
        @Override
            new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), queueCapacity),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
        }
 */
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    availableProcessors
     * @return an {@link ExecutorService} that executes submitted tasks on the current thread
    /**
            queue = ConcurrentCollections.newBlockingQueue();
import java.util.concurrent.Executors;
     * during the execution of this task, we need to inspect this runnable and see if it is an error that should be propagated
            throw new IllegalArgumentException("queue capacity for [" + name + "] executor must be positive, got: " + queueCapacity);
                return true;
        }
            threadFactory,
import java.util.concurrent.LinkedTransferQueue;
            ConcurrentCollections.<Runnable>newBlockingQueue(),
            return 0;
            super.offer(e);
    ) {
/**
        @Override
import java.util.concurrent.RunnableFuture;
    }
import org.opensearch.threadpool.RunnableTaskExecutionListener;
            }
    }
     * waiting if necessary for space to become available.
        return new OpenSearchThreadPoolExecutor(
     * @return a new virtual-thread-per-task executor
            new OpenSearchAbortPolicy(),
            minQueueSize,
        int min,
import java.util.concurrent.ExecutorService;
            queue,
     */
                 * inspect the cause of an execution. We are going to be extra paranoid here though and completely unwrap the
            unit,
 * Unless required by applicable law or agreed to in writing,
    }
    public static ExecutorService newVirtualThreadPerTaskExecutor(
     * @param nodeName       the name of the node
            queue = new SizeBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), queueCapacity);
        int maxQueueSize,
        public void put(E e) {
        processorsParser("processors"),
    }
     * @param size number of fixed threads to use for executing tasks
     * @param runnable the runnable to inspect, should be a RunnableFuture
        return new QueueResizableOpenSearchThreadPoolExecutor(
    }
        }
        }
        int initialQueueCapacity,
        return new PrioritizedOpenSearchThreadPoolExecutor(name, 1, 1, 0L, TimeUnit.MILLISECONDS, threadFactory, contextHolder, timer);
    /**
            name,
         */
        TimeUnit unit,
import java.util.function.Function;
        String name,
            TimeUnit.MILLISECONDS,
         */
                executor.getQueue().put(r);
        int frameSize,
     */
import org.opensearch.common.settings.Settings;
    }
                deprecationLogger.deprecate(
                    // throw this error where it will propagate to the uncaught exception handler
                 */
 * The OpenSearch Contributors require contributions made to
        int size,
                );
 * this file be licensed under the Apache-2.0 license or a
            t.setDaemon(true);
    public static OpenSearchThreadPoolExecutor newScaling(
            this.namePrefix = namePrefix;
import org.opensearch.common.settings.Setting;
import org.opensearch.threadpool.TaskAwareRunnable;
        return "opensearch" + (nodeName.isEmpty() ? "" : "[") + nodeName + (nodeName.isEmpty() ? "" : "]") + "[" + namePrefix + "]";
    public static Throwable rethrowErrors(Runnable runnable) {
        @Override
import java.util.concurrent.ExecutionException;
            if (value > availableProcessors) {
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
                int left = executor.getMaximumPoolSize() - executor.getCorePoolSize();
        ExecutorScalingQueue<Runnable> queue = new ExecutorScalingQueue<>();
        ThreadFactory threadFactory,
        }
    public static OpenSearchThreadPoolExecutor newFixed(
            return value;
                if (e instanceof InterruptedException) {
    }
        return new OpenSearchThreadFactory(namePrefix);
     * @opensearch.internal
        ThreadFactory threadFactory,
        return NODE_PROCESSORS_SETTING.get(settings);
        // TODO missing node names should only be allowed in tests
            keepAliveTime,
        }
                if (e instanceof ExecutionException) {
            threadFactory,
     *
        int queueCapacity,
        Property.NodeScope
        OpenSearchThreadFactory(String namePrefix) {
     * {@link Settings} instance with the key {@code node.processors} set to the desired value.
        } else {
import java.util.concurrent.AbstractExecutorService;
     *
     */
        if (runnableTaskListener != null) {
        return executor;
    public static final Setting<Integer> PROCESSORS_SETTING = new Setting<>(
            try {
        if (runnable instanceof RunnableFuture) {
                    throw maybeError.get();
 * specific language governing permissions and limitations
    }
    }
        }
 */
        BlockingQueue<Runnable> queue;
/*
            0,
/*
        ThreadContext contextHolder
    ) {
                    // only queue when there is no spare capacity
 *
        ThreadFactory threadFactory,
        final String namePrefix;
