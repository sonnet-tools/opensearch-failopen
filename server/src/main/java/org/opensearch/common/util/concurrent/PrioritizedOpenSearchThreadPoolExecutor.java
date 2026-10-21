import java.util.concurrent.ScheduledFuture;
    private final Queue<Runnable> current = ConcurrentCollections.newQueue();
        public void run() {
        List<Pending> pending = new ArrayList<>();
        int maximumPoolSize,
                Object task = t.task;
        }
        command = wrapRunnable(command);
            }
            int res = priority.compareTo(pft.priority);
         * Get the task execution time in milliseconds.
                oldestCreationDateInNanos = Math.min(
                return res;
        }
            }
    }
                started = true;
    public PrioritizedOpenSearchThreadPoolExecutor(
                      see {@link TieBreakingPrioritizedRunnable#run} and {@link TieBreakingPrioritizedRunnable#runAndClean}
 * under the License.
                    throw new IllegalStateException("scheduleTimeout may only be called once");
        }
            if (runnable instanceof TieBreakingPrioritizedRunnable) {
    /**
        current.add(r);
import java.util.concurrent.FutureTask;
/*
        }
        } else { // it might be a callable wrapper...
        }
            return super.unwrap(((WrappedRunnable) runnable).unwrap());
                }
        Priority priority = ((PrioritizedRunnable) runnable).priority();
import org.opensearch.common.unit.TimeValue;
        final long insertionOrder;
        int corePoolSize,
        public final boolean executing;
    @Override
        this.timer = timer;
     * This implementation tracks task execution time, but can be extended
        final Priority priority;
 * this work for additional information regarding copyright
import java.util.concurrent.ThreadFactory;
        @Override
        return new PrioritizedFutureTask<>((PrioritizedCallable) callable, insertionOrder.incrementAndGet());
     */
    }
            this.priority = priority;
     * Generic class to track various task metrics.
            return insertionOrder < pft.insertionOrder ? -1 : 1;
            this.insertionOrder = insertionOrder;
        /**
 * <p>
            }
        }
                }
                TieBreakingPrioritizedRunnable t = (TieBreakingPrioritizedRunnable) runnable;
    public Pending[] getPending() {
 * ownership. Elasticsearch licenses this file to you under
                        public void run() {
        public final long insertionOrder;
            this.insertionOrder = insertionOrder;
package org.opensearch.common.util.concurrent;
                            if (remove(TieBreakingPrioritizedRunnable.this)) {
                if (metrics != null) {
        String name,
 * Note, if two tasks have the same priority, the first to arrive will be executed first (FIFO style).
 * A prioritizing executor which uses a priority queue as a work queue. The jobs that will be submitted will be treated
                if (timeoutFuture != null) {
    protected void afterExecute(Runnable r, Throwable t) {
    @Override
 * as {@link PrioritizedRunnable} and/or {@link PrioritizedCallable}, those tasks that are not instances of these two will
    @Override
import java.util.List;
        public void scheduleTimeout(ScheduledExecutorService timer, final Runnable timeoutCallback, TimeValue timeValue) {
 */
        }
            this.startTimeNanos = System.nanoTime();
     * to include additional metrics.
                }
        size += getQueue().size();
        super.afterExecute(r, t);
                            }
            return runnable;
        addPending(new ArrayList<>(current), pending, true);
            this.insertionOrder = insertionOrder;
            }
import java.util.concurrent.atomic.AtomicLong;
     */
                return command;
            return TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTimeNanos, TimeUnit.NANOSECONDS);
            if (command instanceof TieBreakingPrioritizedRunnable) {
 * license agreements. See the NOTICE file distributed with
        int size = current.size();
     * @opensearch.internal
        ThreadFactory threadFactory,
        }
        if (command instanceof PrioritizedRunnable) {
    /**
                    /*
 * The OpenSearch Contributors require contributions made to
                if (innerRunnable != null) {
                }
        }
 * compatible open source license.
        // these two variables are protected by 'this'
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
        for (Runnable queuedRunnable : getQueue()) {
import java.util.ArrayList;
    ) {
                }
        private Runnable runnable;
        if (!(runnable instanceof PrioritizedRunnable)) {
            }
    }
        taskMetrics.put(r, new TaskMetrics());
        public final Priority priority;
            return super.unwrap(runnable);
        long getExecutionTimeMillis() {
                );
            int res = super.compareTo(pr);
         */
import java.util.Queue;
        /**
 * Unless required by applicable law or agreed to in writing,
     *
        if (timeout.nanos() >= 0) {
                run.run();
    private void addPending(List<Runnable> runnables, List<Pending> pending, boolean executing) {
         * Timeout callback might remain in the timer scheduling queue for some time and it might hold
 *
            return command;
/**
                ((TieBreakingPrioritizedRunnable) command).scheduleTimeout(timer, timeoutCallback, timeout);
        TimeUnit unit,
            }
                PrioritizedFutureTask t = (PrioritizedFutureTask) runnable;
                // make the task as stared. This is needed for synchronization with the timeout handling
        taskMetrics.remove(r); // Clean up metrics when task completes
            if (res != 0 || !(pr instanceof TieBreakingPrioritizedRunnable)) {
        @Override
                throw new UnsupportedOperationException("Execute with timeout is not supported for future tasks");
        private final long insertionOrder;
            if (res != 0) {
         * the pointers to other objects. As a result it's possible to run out of memory if a large number of
import java.util.concurrent.PriorityBlockingQueue;
            return new TieBreakingPrioritizedRunnable(super.wrapRunnable(command), Priority.NORMAL, insertionOrder.incrementAndGet());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        @Override
        return pending.toArray(new Pending[0]);
            super(priority);
                    pending.add(new Pending(super.unwrap(innerRunnable), t.priority(), t.insertionOrder, executing, executionTimeInMillis));
    public TimeValue getMaxTaskWaitTime() {
        long oldestCreationDateInNanos = now;
    public void execute(Runnable command, final TimeValue timeout, final Runnable timeoutCallback) {
 * Licensed to Elasticsearch under one or more contributor
        public final Object task;
        for (Runnable runnable : runnables) {
            runnable = PrioritizedRunnable.wrap(runnable, Priority.NORMAL);
            } finally {
        }
        }
                // We really shouldn't be here. The only way we can get here if somebody created PrioritizedFutureTask
import java.util.concurrent.RunnableFuture;
                    task = super.unwrap((Runnable) t.task);
                return res;
    }
            this.executionTimeInMillis = executionTimeInMillis;
 * the Apache License, Version 2.0 (the "License"); you may
        } else if (command instanceof PrioritizedFutureTask) {
                pending.add(new Pending(task, t.priority, t.insertionOrder, executing, executionTimeInMillis));
            if (executing) {
        }
            this.task = task;
 *
    private static final class PrioritizedFutureTask<T> extends FutureTask<T> implements Comparable<PrioritizedFutureTask> {
 *
        current.remove(r);
            return NO_WAIT_TIME_VALUE;
public class PrioritizedOpenSearchThreadPoolExecutor extends OpenSearchThreadPoolExecutor {
        @Override
    private final ScheduledExecutorService timer;
        private void runAndClean(Runnable run) {
     * Returns the waiting time of the first task in the queue
        TieBreakingPrioritizedRunnable(Runnable runnable, Priority priority, long insertionOrder) {
        }
         * tasks are executed
        }
            this.runnable = runnable;
            runAndClean(runnable);
        @Override
/*
        PrioritizedFutureTask(Runnable runnable, Priority priority, T value, long insertionOrder) {
                if (t.task instanceof Runnable) {
        final Object task;
                FutureUtils.cancel(timeoutFuture);
        public Runnable unwrap() {
            callable = PrioritizedCallable.wrap(callable, Priority.NORMAL);
            super(runnable, value);
    @Override
            return new TieBreakingPrioritizedRunnable(super.wrapRunnable(command), priority, insertionOrder.incrementAndGet());
}
            }
    private static final TimeValue NO_WAIT_TIME_VALUE = TimeValue.timeValueMillis(0);
    }
    private final class TieBreakingPrioritizedRunnable extends PrioritizedRunnable implements WrappedRunnable {
 * @opensearch.internal
        public int compareTo(PrioritizedRunnable pr) {
        return TimeValue.timeValueNanos(now - oldestCreationDateInNanos);
        if (runnable instanceof WrappedRunnable) {
            this.priority = callable.priority();
            super(callable);
                // see #scheduleTimeout()
import java.util.concurrent.Callable;
            if (queuedRunnable instanceof PrioritizedRunnable) {
        }
 * GitHub history for details.
                                runAndClean(timeoutCallback);
                    ((PrioritizedRunnable) queuedRunnable).getCreationDateInNanos()
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
            this.executing = executing;
        PrioritizedFutureTask(PrioritizedCallable<T> callable, long insertionOrder) {
 * Modifications Copyright OpenSearch Contributors. See
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;
     * A pending thread
 * not use this file except in compliance with the License.
            if (command instanceof TieBreakingPrioritizedRunnable) {
    }
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
        if (!(callable instanceof PrioritizedCallable)) {
    @Override
    protected Runnable unwrap(Runnable runnable) {
            Priority priority = ((PrioritizedRunnable) command).priority();
        }
    @Override
        addPending(new ArrayList<>(getQueue()), pending, false);
            } else {
            this.priority = priority;
                if (started == false) {
        execute(command);
        }
        }
        TaskMetrics() {
import java.util.concurrent.ConcurrentMap;
        long now = System.nanoTime();
 */
        }
            }
            this.task = callable;
        ScheduledExecutorService timer
 *
                runnable = null;
            try {
import java.util.concurrent.ConcurrentHashMap;
    /**
    }
        private boolean started = false;
            synchronized (this) {
                    }, timeValue.nanos(), TimeUnit.NANOSECONDS);
        super(name, corePoolSize, maximumPoolSize, keepAliveTime, unit, new PriorityBlockingQueue<>(), threadFactory, contextHolder);
 */
        public Pending(Object task, Priority priority, long insertionOrder, boolean executing, long executionTimeInMillis) {
                      innerRunnable can be null if task is finished but not removed from executor yet,
    }
        }
            this.task = runnable;
        private final long startTimeNanos;
        private ScheduledFuture<?> timeoutFuture;
    }
            return insertionOrder < ((TieBreakingPrioritizedRunnable) pr).insertionOrder ? -1 : 1;
        } else {
                // and passed it to execute, which doesn't make much sense
    private static class TaskMetrics {
 */
import org.opensearch.common.Priority;
         */
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        public final long executionTimeInMillis;
                    oldestCreationDateInNanos,
    }
            synchronized (this) {
    public static class Pending {
/*
    private final AtomicLong insertionOrder = new AtomicLong();
                timeoutFuture = null;
        ThreadContext contextHolder,
    protected Runnable wrapRunnable(Runnable command) {
                TaskMetrics metrics = taskMetrics.get(runnable);
    }
    protected void beforeExecute(Thread t, Runnable r) {
                    executionTimeInMillis = metrics.getExecutionTimeMillis();
    }
 * specific language governing permissions and limitations
    private final ConcurrentMap<Runnable, TaskMetrics> taskMetrics = new ConcurrentHashMap<>();
 * be wrapped and assign a default {@link Priority#NORMAL} priority.
            }
        return new PrioritizedFutureTask<>(runnable, priority, value, insertionOrder.incrementAndGet());
                     */
            long executionTimeInMillis = 0;
    }
     */
        public int compareTo(PrioritizedFutureTask pft) {
        long keepAliveTime,
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at
        return size;
                        }
            this.insertionOrder = insertionOrder;
    }
    }
    public int getNumberOfPendingTasks() {
                Runnable innerRunnable = t.runnable;
 * this file be licensed under the Apache-2.0 license or a
        if (getQueue().size() == 0) {
                    timeoutFuture = timer.schedule(new Runnable() {
            } else if (runnable instanceof PrioritizedFutureTask) {
