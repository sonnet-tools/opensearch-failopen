                 * handled by the executed task or the task submitter.
    /**
            new OpenSearchAbortPolicy(),
        if (initialQueueCapacity <= 0) {  
                int left = executor.getMaximumPoolSize() - executor.getCorePoolSize();  
            assert ((RunnableFuture) runnable).isDone();
            return 0;
            threadFactory,  
    public static String threadName(Settings settings, String namePrefix) {
            TimedRunnable::new,  
        int minQueueSize,
        int queueCapacity,  
            super.offer(e);  
        }  
        public List<Runnable> shutdownNow() {  
        public boolean offer(E e, long timeout, TimeUnit unit) {
 * GitHub history for details.
        final ThreadGroup group;  
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {  
            size,
            );  
        }
                // force queue policy should only be used with a scaling queue
                    return false;
        }  
        int initialQueueCapacity,
import org.opensearch.common.unit.TimeValue;
 * this work for additional information regarding copyright
        final String namePrefix;
                    throw maybeError.get();
     *
                if (e instanceof InterruptedException) {
            if (!tryTransfer(e)) {  
            keepAliveTime,
            minQueueSize,
    /**  
    }
            // first try to transfer to a waiting worker thread
            SecurityManager s = System.getSecurityManager();
            this.namePrefix = namePrefix;  
        public void put(E e) {
            return threadName(Node.NODE_NAME_SETTING.get(settings), namePrefix);
    );  
    }  
     * @param initialQueueCapacity initial size of the executor queue
            runnableWrapper = TimedRunnable::new;
        ThreadFactory threadFactory,  
    static class OpenSearchThreadFactory implements ThreadFactory {
 * You may obtain a copy of the License at  
            contextHolder
     * {@link Settings} instance with the key {@code node.processors} set to the desired value.  
            max,
    /**
        } else {
    /**
            0,  
        return executor;
         * Workaround for https://bugs.openjdk.org/browse/JDK-8323659 regression, introduced in JDK-21.0.2.
        processorsParser("processors"),  
        String name,
    ) {
        return DIRECT_EXECUTOR_SERVICE;
         */  
                // pool executor
     */
                 * exception. We want to ignore cancellation exceptions, restore the interrupt status on interrupted exceptions, and
            size,
        }
        final ThreadFactory threadFactory = Thread.ofVirtual().name(threadName(nodeName, namePrefix) + "#", 0).factory();
        }  
        if (runnable instanceof RunnableFuture) {
 *
            min,  
            contextHolder
     * Returns a new executor that creates a new virtual thread for each task.
            if (value > availableProcessors) {  
            }
            final int value = Setting.parseInt(s, 1, name);
     * @opensearch.internal
        "node.processors",
        public boolean awaitTermination(long timeout, TimeUnit unit) {  
            TimeUnit.MILLISECONDS,
 * SPDX-License-Identifier: Apache-2.0
    static class ForceQueuePolicy implements XRejectedExecutionHandler {  
            unit,  
                assert e instanceof CancellationException || e instanceof InterruptedException || e instanceof ExecutionException : e;
                if (maybeError.isPresent()) {  
        }
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(
     */  
import java.util.concurrent.CancellationException;
        public boolean add(E e) {  
    /**  
     * @param namePrefix     the name prefix for virtual threads
                return true;  
 * license agreements. See the NOTICE file distributed with
     *  
 *    http://www.apache.org/licenses/LICENSE-2.0
        /**  
    public static Throwable rethrowErrors(Runnable runnable) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @return a new virtual-thread-per-task executor  
 */
    }
        public long rejected() {  
    private OpenSearchExecutors() {}
import org.opensearch.common.settings.Setting.Property;
 *  
     *
    ) {  
        return NODE_PROCESSORS_SETTING.get(settings);  
            size,
     * available to OpenSearch (e.g., because of CPU limits).
        AtomicReference<RunnableTaskExecutionListener> runnableTaskListener  
            throw new IllegalArgumentException(
                }
     * Checks if the runnable arose from asynchronous submission of a task to an executor. If an uncaught exception was thrown
                if (left > 0) {
import java.util.concurrent.AbstractExecutorService;
            contextHolder
    private static final ExecutorService DIRECT_EXECUTOR_SERVICE = new DirectExecutorService();
        // TODO missing node names should only be allowed in tests  
import java.util.concurrent.TimeUnit;
    }  
 * software distributed under the License is distributed on an
        return new QueueResizableOpenSearchThreadPoolExecutor(
     * @param nodeName       the name of the node  
                    "processors_" + name,
        Property.Deprecated,
 * ownership. Elasticsearch licenses this file to you under  
     * @param minQueueSize minimum queue size that the queue can be adjusted to  
            runnableWrapper,  
 *
            TimeUnit.MILLISECONDS,
                }
     * during the execution of this task, we need to inspect this runnable and see if it is an error that should be propagated  
            }
        ThreadPoolExecutor executor;
        int queueCapacity,
                executor.getQueue().put(r);
 * @opensearch.internal  
            initialQueueCapacity
        return new QueueResizingOpenSearchThreadPoolExecutor(  
        final String namePrefix,
        final String nodeName,  
        @Override
        assert nodeName != null && false == nodeName.isEmpty();  
    public static ExecutorService newDirectExecutorService() {
        String name,
    public static ExecutorService newVirtualThreadPerTaskExecutor(
                /*  
     * waiting if necessary for space to become available.
            throw new UnsupportedOperationException();
                    return e.getCause();  
            // TODO this should only be allowed in tests  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(OpenSearchExecutors.class);
        }
            threadFactory,
                } else {
 * compatible open source license.
        final AtomicInteger threadNumber = new AtomicInteger(1);
            command.run();  
            return value;  
            return false;  
     */
                if (e instanceof ExecutionException) {
        return new PrioritizedOpenSearchThreadPoolExecutor(name, 1, 1, 0L, TimeUnit.MILLISECONDS, threadFactory, contextHolder, timer);  
        Function<Runnable, WrappedRunnable> runnableWrapper;
                    "setting [{}] to value [{}] which is more than available processors [{}] is deprecated",  
        @Override  
}  
    }
            0,
        public boolean isShutdown() {
     * @param size number of fixed threads to use for executing tasks
     */  
            return t;  
        ThreadFactory threadFactory,
        String name,
        }
    /**
                assert executor.getQueue() instanceof ExecutorScalingQueue;  
     */  
                deprecationLogger.deprecate(
        Property.NodeScope
        s -> Integer.toString(Runtime.getRuntime().availableProcessors()),
     * @param settings a {@link Settings} instance from which to derive the allocated processors
            throw new IllegalArgumentException("queue capacity for [" + name + "] executor must be positive, got: " + queueCapacity);
        } else {
import java.util.concurrent.BlockingQueue;  
        }
     */
 * The OpenSearch Contributors require contributions made to  
        @Override  
    }
        ThreadContext contextHolder
            contextHolder  
        ScheduledExecutorService timer
     *  
    ) {
        if (queueCapacity < 0) {  
     * Cannot instantiate.  
        }
        @Override
            frameSize,
        final ExecutorService delegate = Executors.newThreadPerTaskExecutor(threadFactory);  
                );
            return false;
        ThreadContext contextHolder,
     * A scaling queue for executors
    public static OpenSearchThreadPoolExecutor newScaling(  
        );
     *
                    // restore the interrupt status
 * not use this file except in compliance with the License.
                final Optional<Error> maybeError = ExceptionsHelper.maybeError(e);
            } catch (final InterruptedException e) {
     */
    public static String threadName(final String nodeName, final String namePrefix) {
            return threadName("", namePrefix);
        /**
            new OpenSearchAbortPolicy(),
    private static Function<String, Integer> processorsParser(final String name) {
        }
         * Workaround for https://bugs.openjdk.org/browse/JDK-8323659 regression, introduced in JDK-21.0.2.
            return super.offer(e);
        int min,
     *
        return daemonThreadFactory(threadName(settings, namePrefix));
                ((RunnableFuture) runnable).get();
    }  
        PROCESSORS_SETTING,  
            return super.offer(e);
     * Setting to manually set the number of available processors. This setting is used to adjust thread pool sizes per node.
    /**
    static class ExecutorScalingQueue<E> extends LinkedTransferQueue<E> {  
                    availableProcessors  
        TimeUnit unit,
        OpenSearchThreadPoolExecutor executor = new OpenSearchThreadPoolExecutor(
    }
                    // only queue when there is no spare capacity  
/*
     * @return an {@link ExecutorService} that executes submitted tasks on the current thread
 */  
                 */  
        if (Node.NODE_NAME_SETTING.exists(settings)) {  
     *  
    }
        public void execute(Runnable command) {
        final ThreadContext threadContext
        );  
        if (runnableTaskListener != null) {
    public static ThreadFactory daemonThreadFactory(String namePrefix) {
    /**
        public boolean offer(E e) {
        public boolean isTerminated() {
    }
        );
            super();  
        @Override
import org.opensearch.common.SuppressForbidden;
        return new OpenSearchThreadFactory(namePrefix);
        return null;
        int size,  
        assert nodeName != null && false == nodeName.isEmpty();
        TimeValue targetedResponseTime,
        @Override
                    Thread.currentThread().interrupt();  
        public void shutdown() {
    ) {
 */  
        if (queueCapacity <= 0) {  
    }  
     * @opensearch.internal
                    return super.offer(e);  
            threadFactory,
     * to the uncaught exception handler.
                // check if there might be spare capacity in the thread
        int frameSize,
    public static OpenSearchThreadPoolExecutor newFixed(
            throw new UnsupportedOperationException();
            new ForceQueuePolicy(),  
        DirectExecutorService() {
        } else {
 * Modifications Copyright OpenSearch Contributors. See
     * Returns an {@link ExecutorService} that executes submitted tasks on the current thread. This executor service does not support being
    }
        @SuppressForbidden(reason = "properly rethrowing errors, see OpenSearchExecutors.rethrowErrors")
     * @return non fatal exception or null if no exception.
    public static final Setting<Integer> NODE_PROCESSORS_SETTING = new Setting<>(
    public static ThreadFactory daemonThreadFactory(Settings settings, String namePrefix) {
            new OpenSearchAbortPolicy(),
        int max,  
                 * In theory, Future#get can only throw a cancellation exception, an interrupted exception, or an execution
                    // reject queuing the task to force the thread pool
                TaskAwareRunnable taskAwareRunnable = new TaskAwareRunnable(contextHolder, runnable, runnableTaskListener);
        @SuppressWarnings("removal")
        ThreadContext contextHolder  
                    // pool to always scale up to max pool size and we
            }
    );  
                    // executor to add a worker if it can; combined  
        ThreadFactory threadFactory,
            }
    /**  
        }  
        public Thread newThread(Runnable r) {  
        @Override
        Property.NodeScope
            queue,  
 * the Apache License, Version 2.0 (the "License"); you may
         * Workaround for https://bugs.openjdk.org/browse/JDK-8323659 regression, introduced in JDK-21.0.2.  
 * Unless required by applicable law or agreed to in writing,
import java.util.function.Function;
            } else {
        processorsParser("node.processors"),
public class OpenSearchExecutors {
     * A thread factory  
import java.util.concurrent.ThreadFactory;
         */
 */
            size,
    }  
        };
                "initial queue capacity for [" + name + "] executor must be positive, got: " + initialQueueCapacity
/*  
    public static int allocatedProcessors(final Settings settings) {
            new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), queueCapacity),
        }  
            queue = new SizeBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), queueCapacity);  
     */
        }
     */  
    public static PrioritizedOpenSearchThreadPoolExecutor newSinglePrioritizing(  
            targetedResponseTime,
        ExecutorScalingQueue<Runnable> queue = new ExecutorScalingQueue<>();  
        ThreadContext contextHolder,  
import java.util.concurrent.atomic.AtomicReference;  
        queue.executor = executor;  
            TimeUnit.MILLISECONDS,
        @Override
    }
     * Setting to manually control the number of allocated processors. This setting is used to adjust thread pool sizes per node. The  
                    // throw this error where it will propagate to the uncaught exception handler
            try {
     */
        return new OpenSearchThreadPoolExecutor(
            name,
            name,
                }
            final int availableProcessors = Runtime.getRuntime().availableProcessors();
            } catch (final Exception e) {
 * Executors.
        return daemonThreadFactory(threadName(nodeName, namePrefix));
            threadFactory,  
     */
                    // with ForceQueuePolicy, this causes the thread
        }  
         */
 * under the License.  
 *
            size,  
    public static OpenSearchThreadPoolExecutor newResizable(  
     * @param frameSize number of tasks during which stats are collected before adjusting queue size
            try {  
    }
        /**
 * Licensed to Elasticsearch under one or more contributor  
                    name,
     * Returns the number of allocated processors. Defaults to {@link Runtime#availableProcessors()} but can be overridden by passing a
                throw new AssertionError(e);
            Thread t = new Thread(group, r, namePrefix + "[T#" + threadNumber.getAndIncrement() + "]", 0);
            0,  
            queue,
        }
import java.util.List;  
        int maxQueueSize,  
import java.util.concurrent.ThreadPoolExecutor;  
        }
        long keepAliveTime,
        BlockingQueue<Runnable> queue;
     * default value is {@link Runtime#availableProcessors()} but should be manually controlled if not all processors on the machine are
import java.util.concurrent.ScheduledExecutorService;
package org.opensearch.common.util.concurrent;
import org.opensearch.ExceptionsHelper;
     *
        ExecutorScalingQueue() {}
                }  
    }  
     * shutdown.  
import org.opensearch.threadpool.TaskAwareRunnable;
            rethrowErrors(command);
        }
            name,  
        return new VirtualThreadPerTaskExecutorService(delegate, threadContext);
import org.opensearch.common.settings.Setting;
import java.util.concurrent.Executors;
            };  
import org.opensearch.common.settings.Settings;  
    public static OpenSearchThreadPoolExecutor newAutoQueueFixed(
        int size,
            maxQueueSize,
        "processors",
import java.util.concurrent.RunnableFuture;  
     * @opensearch.internal
                // a scaling queue never blocks so a put to it can never be interrupted  
        }
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        return s -> {  
        }
        return "opensearch" + (nodeName.isEmpty() ? "" : "[") + nodeName + (nodeName.isEmpty() ? "" : "]") + "[" + namePrefix + "]";
            queue = ConcurrentCollections.newBlockingQueue();
        String name,
 * specific language governing permissions and limitations
    public static ThreadFactory daemonThreadFactory(String nodeName, String namePrefix) {
        String name,
/*  
import java.util.Optional;
     * Return a new executor that will automatically adjust the queue size based on queue throughput.
    ) {
    ) {
                return new TimedRunnable(taskAwareRunnable);
            t.setDaemon(true);
                 * exception to ensure that there is not a buried error anywhere. We assume that a general exception has been
    /**
            name,  
        }  
            throw new UnsupportedOperationException();
        ThreadFactory threadFactory,  
    }
                 * inspect the cause of an execution. We are going to be extra paranoid here though and completely unwrap the  
        ThreadFactory threadFactory,
 * KIND, either express or implied.  See the License for the
            size,
import java.util.concurrent.LinkedTransferQueue;
    public static final Setting<Integer> PROCESSORS_SETTING = new Setting<>(  
        );  
    }
        OpenSearchThreadFactory(String namePrefix) {
     * @return the number of allocated processors  
/**  
        ThreadContext contextHolder
        @Override
        int size,  
                    value,
            runnableWrapper = (runnable) -> {  
 * this file be licensed under the Apache-2.0 license or a
            ConcurrentCollections.<Runnable>newBlockingQueue(),  
     * A handler for rejected tasks that adds the specified element to this queue,
    private static final class DirectExecutorService extends AbstractExecutorService {
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.common.logging.DeprecationLogger;  
     * @param maxQueueSize maximum queue size that the queue can be adjusted to
            queue,
import java.util.concurrent.ExecutorService;  
     * @param threadContext  the thread context to preserve across task execution
import org.opensearch.threadpool.RunnableTaskExecutionListener;  
import org.opensearch.node.Node;
        @Override
     * @param runnable the runnable to inspect, should be a RunnableFuture  
    /**
        @Override
        @Override  
        @Override  
        );
    }  
import java.util.concurrent.ExecutionException;
