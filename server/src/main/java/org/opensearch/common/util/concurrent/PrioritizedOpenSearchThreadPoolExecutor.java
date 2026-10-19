        public int compareTo(PrioritizedFutureTask pft) {
        } else { // it might be a callable wrapper...  
    protected void afterExecute(Runnable r, Throwable t) {  
            runAndClean(runnable);  
    private static class TaskMetrics {
            this.priority = callable.priority();  
                            if (remove(TieBreakingPrioritizedRunnable.this)) {  
        @Override
        // these two variables are protected by 'this'  
            Priority priority = ((PrioritizedRunnable) command).priority();
        @Override
 * You may obtain a copy of the License at  
import java.util.ArrayList;  
            return command;
/*  
                // and passed it to execute, which doesn't make much sense
            return insertionOrder < ((TieBreakingPrioritizedRunnable) pr).insertionOrder ? -1 : 1;  
            this.runnable = runnable;  
        for (Runnable queuedRunnable : getQueue()) {  
                    ((PrioritizedRunnable) queuedRunnable).getCreationDateInNanos()
    }
        size += getQueue().size();
        PrioritizedFutureTask(Runnable runnable, Priority priority, T value, long insertionOrder) {
 */  
            if (command instanceof TieBreakingPrioritizedRunnable) {
import java.util.concurrent.ScheduledExecutorService;  
                        public void run() {
        private boolean started = false;
                }
        long keepAliveTime,  
    protected Runnable unwrap(Runnable runnable) {  
                    /*  
        @Override  
        private final long startTimeNanos;
            return TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTimeNanos, TimeUnit.NANOSECONDS);  
        return new PrioritizedFutureTask<>((PrioritizedCallable) callable, insertionOrder.incrementAndGet());
import org.opensearch.common.unit.TimeValue;
                FutureUtils.cancel(timeoutFuture);
                    task = super.unwrap((Runnable) t.task);
        }
            return NO_WAIT_TIME_VALUE;
    }
        }
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
        return new PrioritizedFutureTask<>(runnable, priority, value, insertionOrder.incrementAndGet());
        TaskMetrics() {
        int size = current.size();  
 * GitHub history for details.
 * @opensearch.internal
                Object task = t.task;
            }  
        final long insertionOrder;  
    }  
        }
        super(name, corePoolSize, maximumPoolSize, keepAliveTime, unit, new PriorityBlockingQueue<>(), threadFactory, contextHolder);  
import java.util.concurrent.ConcurrentMap;
    }
            if (res != 0 || !(pr instanceof TieBreakingPrioritizedRunnable)) {  
        public void scheduleTimeout(ScheduledExecutorService timer, final Runnable timeoutCallback, TimeValue timeValue) {  
        }  
     *  
            super(runnable, value);  
 *
    }  
        }  
                return res;
        }
 * the Apache License, Version 2.0 (the "License"); you may
                }
 * The OpenSearch Contributors require contributions made to  
        return size;
import java.util.concurrent.ConcurrentHashMap;
        TieBreakingPrioritizedRunnable(Runnable runnable, Priority priority, long insertionOrder) {
import java.util.concurrent.PriorityBlockingQueue;
                if (metrics != null) {  
            this.startTimeNanos = System.nanoTime();
    public TimeValue getMaxTaskWaitTime() {
         * Timeout callback might remain in the timer scheduling queue for some time and it might hold
        private final long insertionOrder;
        }
     * This implementation tracks task execution time, but can be extended
        if (command instanceof PrioritizedRunnable) {
        if (getQueue().size() == 0) {  
         * tasks are executed  
            }
                                runAndClean(timeoutCallback);
                }
                runnable = null;  
 * compatible open source license.
package org.opensearch.common.util.concurrent;
                }
}
        private ScheduledFuture<?> timeoutFuture;
        return pending.toArray(new Pending[0]);
        /**  
        ThreadContext contextHolder,  
        }
        int maximumPoolSize,
            if (runnable instanceof TieBreakingPrioritizedRunnable) {
    @Override
            }
import java.util.concurrent.Callable;  
 * SPDX-License-Identifier: Apache-2.0
    private static final TimeValue NO_WAIT_TIME_VALUE = TimeValue.timeValueMillis(0);
/*
        PrioritizedFutureTask(PrioritizedCallable<T> callable, long insertionOrder) {  
            if (res != 0) {
     */
         * Get the task execution time in milliseconds.  
        super.afterExecute(r, t);
                run.run();
     * Generic class to track various task metrics.  
                }
            } else {  
            if (queuedRunnable instanceof PrioritizedRunnable) {
    @Override
        if (!(runnable instanceof PrioritizedRunnable)) {
                    timeoutFuture = timer.schedule(new Runnable() {  
    }  
            long executionTimeInMillis = 0;
        addPending(new ArrayList<>(getQueue()), pending, false);
 * under the License.  
    @Override
 * specific language governing permissions and limitations
            this.priority = priority;  
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {  
    }  
        String name,  
            this.priority = priority;
                      see {@link TieBreakingPrioritizedRunnable#run} and {@link TieBreakingPrioritizedRunnable#runAndClean}
                timeoutFuture = null;
    private final Queue<Runnable> current = ConcurrentCollections.newQueue();
            this.executing = executing;
    }  
        }
                throw new UnsupportedOperationException("Execute with timeout is not supported for future tasks");  
        }
        /**
        } else {  
import java.util.concurrent.RunnableFuture;
            return new TieBreakingPrioritizedRunnable(super.wrapRunnable(command), Priority.NORMAL, insertionOrder.incrementAndGet());
                      innerRunnable can be null if task is finished but not removed from executor yet,
        this.timer = timer;
            } finally {
                pending.add(new Pending(task, t.priority, t.insertionOrder, executing, executionTimeInMillis));  
 *  
 * Unless required by applicable law or agreed to in writing,
        public void run() {
            }
 * not use this file except in compliance with the License.
                Runnable innerRunnable = t.runnable;
            int res = priority.compareTo(pft.priority);  
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {  
            try {  
                    oldestCreationDateInNanos,  
         * the pointers to other objects. As a result it's possible to run out of memory if a large number of
            super(callable);
            return insertionOrder < pft.insertionOrder ? -1 : 1;
    }
    /**
        }  
        List<Pending> pending = new ArrayList<>();
        public Runnable unwrap() {  
        public final boolean executing;
         */
    }  
            this.insertionOrder = insertionOrder;
        public final long executionTimeInMillis;
 */
            if (command instanceof TieBreakingPrioritizedRunnable) {
        public final Object task;
            }  
            }  
        ThreadFactory threadFactory,
                PrioritizedFutureTask t = (PrioritizedFutureTask) runnable;
    @Override
    }  
        private void runAndClean(Runnable run) {
import java.util.concurrent.ThreadFactory;
        }
    }  
        final Priority priority;
        }
     * Returns the waiting time of the first task in the queue  
                return command;  
            return super.unwrap(((WrappedRunnable) runnable).unwrap());
        }
public class PrioritizedOpenSearchThreadPoolExecutor extends OpenSearchThreadPoolExecutor {  
        current.remove(r);
import java.util.concurrent.ScheduledFuture;
    private final ConcurrentMap<Runnable, TaskMetrics> taskMetrics = new ConcurrentHashMap<>();  
 * <p>
     */
            }
import org.opensearch.common.Priority;  
        } else if (command instanceof PrioritizedFutureTask) {
            this.insertionOrder = insertionOrder;  
        long now = System.nanoTime();
        taskMetrics.put(r, new TaskMetrics());
                ((TieBreakingPrioritizedRunnable) command).scheduleTimeout(timer, timeoutCallback, timeout);
    public void execute(Runnable command, final TimeValue timeout, final Runnable timeoutCallback) {  
            callable = PrioritizedCallable.wrap(callable, Priority.NORMAL);
import java.util.concurrent.FutureTask;  
    protected Runnable wrapRunnable(Runnable command) {  
 * this file be licensed under the Apache-2.0 license or a
                return res;
 * Modifications Copyright OpenSearch Contributors. See  
            return new TieBreakingPrioritizedRunnable(super.wrapRunnable(command), priority, insertionOrder.incrementAndGet());  
    private final class TieBreakingPrioritizedRunnable extends PrioritizedRunnable implements WrappedRunnable {
        long getExecutionTimeMillis() {
     * @opensearch.internal
                if (started == false) {
                    throw new IllegalStateException("scheduleTimeout may only be called once");  
                // make the task as stared. This is needed for synchronization with the timeout handling
        if (runnable instanceof WrappedRunnable) {
    }
        current.add(r);
            this.task = callable;
 * this work for additional information regarding copyright
import java.util.concurrent.atomic.AtomicLong;
                        @Override
import java.util.Queue;
                );
            this.insertionOrder = insertionOrder;
                     */  
            return super.unwrap(runnable);
                        }  
                // We really shouldn't be here. The only way we can get here if somebody created PrioritizedFutureTask
            this.insertionOrder = insertionOrder;
import java.util.List;
            }
        TimeUnit unit,
        private Runnable runnable;  
                TaskMetrics metrics = taskMetrics.get(runnable);
    private void addPending(List<Runnable> runnables, List<Pending> pending, boolean executing) {  
                    }, timeValue.nanos(), TimeUnit.NANOSECONDS);
    }  
            this.executionTimeInMillis = executionTimeInMillis;  
            this.task = runnable;
            int res = super.compareTo(pr);
            if (executing) {
     * A pending thread
        return TimeValue.timeValueNanos(now - oldestCreationDateInNanos);  
            synchronized (this) {
        command = wrapRunnable(command);
        for (Runnable runnable : runnables) {
     * to include additional metrics.
                // see #scheduleTimeout()
    }
 * license agreements. See the NOTICE file distributed with
    }  
            }
    private final ScheduledExecutorService timer;
 * as {@link PrioritizedRunnable} and/or {@link PrioritizedCallable}, those tasks that are not instances of these two will
            runnable = PrioritizedRunnable.wrap(runnable, Priority.NORMAL);
 * KIND, either express or implied.  See the License for the
            }  
                    executionTimeInMillis = metrics.getExecutionTimeMillis();
    public static class Pending {  
    ) {
    public int getNumberOfPendingTasks() {
 *
            super(priority);
            synchronized (this) {  
            return runnable;
        int corePoolSize,
        taskMetrics.remove(r); // Clean up metrics when task completes  
                oldestCreationDateInNanos = Math.min(
    private final AtomicLong insertionOrder = new AtomicLong();  
    /**
        ScheduledExecutorService timer
    protected void beforeExecute(Thread t, Runnable r) {  
            this.task = task;
                if (innerRunnable != null) {
import java.util.concurrent.TimeUnit;  
        final Object task;
    @Override
        long oldestCreationDateInNanos = now;
                if (t.task instanceof Runnable) {  
    @Override
        }  
/**  
                TieBreakingPrioritizedRunnable t = (TieBreakingPrioritizedRunnable) runnable;  
                if (timeoutFuture != null) {
    /**
        }
         */
                            }
 * be wrapped and assign a default {@link Priority#NORMAL} priority.  
    private static final class PrioritizedFutureTask<T> extends FutureTask<T> implements Comparable<PrioritizedFutureTask> {
        public int compareTo(PrioritizedRunnable pr) {
        public final Priority priority;
        Priority priority = ((PrioritizedRunnable) runnable).priority();
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
                started = true;  
            } else if (runnable instanceof PrioritizedFutureTask) {  
        if (!(callable instanceof PrioritizedCallable)) {
        if (timeout.nanos() >= 0) {  
    public Pending[] getPending() {
        }
 */
        public final long insertionOrder;  
        }
        execute(command);
 * A prioritizing executor which uses a priority queue as a work queue. The jobs that will be submitted will be treated
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        addPending(new ArrayList<>(current), pending, true);  
    public PrioritizedOpenSearchThreadPoolExecutor(
        @Override
        public Pending(Object task, Priority priority, long insertionOrder, boolean executing, long executionTimeInMillis) {
                    pending.add(new Pending(super.unwrap(innerRunnable), t.priority(), t.insertionOrder, executing, executionTimeInMillis));
        }
     */  
 * ownership. Elasticsearch licenses this file to you under  
 *  
        }
/*
 * Note, if two tasks have the same priority, the first to arrive will be executed first (FIFO style).
