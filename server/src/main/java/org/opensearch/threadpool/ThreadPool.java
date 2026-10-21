                    builder.field("keep_alive", keepAlive.toString());
         * whenever called. Typically used for testing.
                logger.debug(
                }
            pool.shutdownNow();
                new ThreadPoolStats.Stats.Builder().name(name)
        final int genericThreadPoolMax = boundedBy(4 * allocatedProcessors, 128, 512);
        }
                        );
    }
     */
        map.put(Names.STREAM_SEARCH, ThreadPoolType.RESIZABLE);
        public String getName() {
     *
        public String toString() {
                Names.STREAM_SEARCH,
 *
        this.cachedTimeThread.start();
    static int halfAllocatedProcessorsMaxFive(final int allocatedProcessors) {
    static int boundedBy(int value, int min, int max) {
    /**
                Names.REMOTE_DOWNLOAD,
                    .threads(threads)
     * @param value the value to constrain
        map.put(Names.FORCE_MERGE, ThreadPoolType.FIXED);
        return new ScheduledCancellableAdapter(scheduler.schedule(command, delay.millis(), TimeUnit.MILLISECONDS));
                runnableTaskListener
import java.util.Collection;
    static Set<String> fixedThreadPoolKeys = new HashSet<>(Arrays.asList("size"));
            if (holder.info.type == ThreadPoolType.FORK_JOIN || holder.info.type == ThreadPoolType.VIRTUAL) {
        Map<String, Settings> tpGroups = tpSettings.getAsGroups();
        public static ThreadPoolType fromType(String type) {
                }
    static class CachedTimeThread extends Thread {
            assert holder.executor instanceof OpenSearchThreadPoolExecutor;
        }
            if (executors.containsKey(executorHolder.info.getName())) {
import org.opensearch.core.xcontent.XContentBuilder;
        for (final Map.Entry<String, ExecutorBuilder> entry : builders.entrySet()) {
            String tpName = entry.getKey();
    static int twiceAllocatedProcessors(final int allocatedProcessors) {
        private final String name;
                if (queueSize == null) {
        public void run() {
    public static boolean assertNotScheduleThread(String reason) {
            super(name);
        public int hashCode() {
            setDaemon(true);
            Thread.currentThread().interrupt();
                absoluteMillis = System.currentTimeMillis();
        map.put(Names.REMOTE_PURGE, ThreadPoolType.SCALING);
            queueSize = in.readOptionalWriteable(SizeValue::new);
    public Cancellable scheduleWithFixedDelay(Runnable command, TimeValue interval, String executor) {
            }
            return runnable.hashCode();
        map.put(Names.FLUSH, ThreadPoolType.SCALING);
                } catch (InterruptedException e) {
        @Override
    /**
                    throw new IllegalArgumentException("illegal value for [cluster.thread_pool." + tpName + "], has to be positive value");
            return runnable.equals(obj);
            this.type = type;
                if (size < executor.getCorePoolSize()) {
    private static boolean awaitTermination(final ThreadPool threadPool, final long timeout, final TimeUnit timeUnit) {
                        "could not schedule execution of [{}] after [{}] on [{}] as executor is shut down",
    public ThreadPoolStats stats() {
     */
                    builder.field("queue_size", -1);
                    executor.setCorePoolSize(core);
            )
                result &= executor.executor().awaitTermination(timeout, unit);
         * Return the current time used for relative calculations. This is {@link System#nanoTime()}.
        THREAD_POOL_TYPES = Collections.unmodifiableMap(map);
    @PublicApi(since = "1.0.0")
            Names.STREAM_SEARCH,
        map.put(Names.SYSTEM_WRITE, ThreadPoolType.FIXED);
        builders.put(Names.GENERIC, new ScalingExecutorBuilder(Names.GENERIC, 4, genericThreadPoolMax, TimeValue.timeValueSeconds(30)));
        for (ExecutorHolder executor : executors.values()) {
            // queue, largest, and rejected have no referent; only the task flow counters are meaningful.
    public ExecutorService generic() {
                executor.execute(runnable);
    private final ThreadContext threadContext;
        builders.put(
                        new ParameterizedMessage(
            service.shutdown();
            new ScalingExecutorBuilder(
                    .parallelism(parallelism)
    private final ThreadPoolInfo threadPoolInfo;
                completed = threadPoolExecutor.getCompletedTaskCount();
                    .rejected(rejected)
    public ThreadPool(
        final int halfProcMaxAt10 = halfAllocatedProcessorsMaxTen(allocatedProcessors);
    /**
/*
        map.put(Names.REMOTE_RECOVERY, ThreadPoolType.SCALING);
                int size = tpGroup.getAsInt("size", executor.getMaximumPoolSize());
            this.name = name;
            if (holder.info.type == ThreadPoolType.SCALING) {
        map.put(Names.TRANSLOG_SYNC, ThreadPoolType.FIXED);
        public static final String SNAPSHOT = "snapshot";
        builders.put(
                threads = threadPoolExecutor.getPoolSize();
                continue;
        map.put(Names.REMOTE_DOWNLOAD, ThreadPoolType.SCALING);
        cluster.threadpool.snapshot.core : "5",
            // Skip validation for pool types that do not support setting updates. ForkJoinPool is not resizable, and a
        public static final String SEARCH = "search";
            new ResizableExecutorBuilder(
                 */
            Names.TRANSLOG_TRANSFER,
                executor.executor().shutdownNow();
        map.put(Names.MANAGEMENT, ThreadPoolType.SCALING);
            ExecutorHolder holder = executors.get(tpName);
        }
        public static final String SEARCH_THROTTLED = "search_throttled";
                        .waitTimeNanos(-1)
            // the direct executor runs tasks on the calling thread and does not support being shut down
            this.keepAlive = keepAlive;
        return true;
                waitTimeNanos = threadPoolExecutor.getPoolWaitTimeNanos();
                        e
                        .threads(0)
import org.opensearch.common.util.concurrent.XRejectedExecutionHandler;
                    running = false;
    public long absoluteTimeInMillis() {
        );
                continue;
            .map(holder -> holder.info)
                }
    }
                } else {
        public static final String REMOTE_DOWNLOAD = "remote_download";
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                int max = tpGroup.getAsInt("max", threadPoolExecutor.getMaximumPoolSize());
 */
            // virtual thread-per-task pool has no size or queue to configure in the first place.
import java.util.Map;
     * time deltas that should not suffer from negative deltas, which are possible with
                if (fixedThreadPoolKeys.containsAll(tpGroup.keySet()) == false) {
     * timestamp, see {@link #absoluteTimeInMillis()}.
                    .largest(largest)
                // OpenSearch on older version doesn't know about "fork_join" thread pool. Convert FORK_JOIN to FIXED
        builders.put(Names.WRITE, new FixedExecutorBuilder(settings, Names.WRITE, allocatedProcessors, 10000));
        map.put(Names.GET, ThreadPoolType.FIXED);
    public void registerClusterSettingsListeners(ClusterSettings clusterSettings) {
        builders.put(Names.ANALYZE, new FixedExecutorBuilder(settings, Names.ANALYZE, 1, 16));
        ThreadPoolType(String type) {
     * This method should only be used for calculating time deltas. For an epoch based
                    executor.setMaximumPoolSize(max);
            out.writeInt(max);
 *
                relativeNanos = System.nanoTime();
            ThreadPoolType threadPoolType = TYPE_MAP.get(type);
                continue;
            assert holder.executor instanceof OpenSearchThreadPoolExecutor;
                runnableTaskListener
        }
     * Returns a value of nanoseconds that may be used for relative time calculations
            }
                completed = virtualExecutor.getCompletedTaskCount();
            } else {
    }
/**
        return false;
        return boundedBy((allocatedProcessors + 1) / 2, 1, 5);
     *                 the meaning of the ScheduledFuture returned by this method. In that case the ScheduledFuture will complete only when the
    @PublicApi(since = "1.0.0")
        scheduler.shutdown();
import org.opensearch.common.unit.TimeValue;
 * GitHub history for details.
    For example valid settings would be for scaling and fixed thead pool
                    .waitTimeNanos(waitTimeNanos)
                if (keepAlive != null) {
    }
                    } else {
        }
            }
        builders.put(
                    executor.setMaximumPoolSize(size);
            return awaitTermination(service, timeout, timeUnit);
     * The values are updated at a specified interval.
     * @opensearch.api
                // an unbounded virtual thread-per-task pool has no size, keep alive, or queue to report
                settings,
                twiceAllocatedProcessors(allocatedProcessors),
                // to avoid serialization/de-serization issue between nodes with different OpenSearch version
                assert min != -1;
                }
    /**
    }
            Names.REMOTE_REFRESH_RETRY,
        @Override
     * {@link System#nanoTime()} and {@link System#currentTimeMillis()}.
                if (keepAlive != null) {
                    throw new IllegalArgumentException(
     * the service is <code>null</code> this method will return <code>false</code>.
        }
 * license agreements. See the NOTICE file distributed with
                        executor
            try {
        } catch (final InterruptedException e) {
    private final CachedTimeThread cachedTimeThread;
                    executor.setMaximumPoolSize(size);
        } catch (InterruptedException e) {
        final ExecutorBuilder<?>... customBuilders
     *
    }
                if (core < executor.getCorePoolSize()) {
        LoggingRunnable(Runnable runnable) {
        );
        public SizeValue getQueueSize() {
                || executor instanceof ForkJoinPool
package org.opensearch.threadpool;
        }
        }
    }
    }
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
     * the task is canceled before it was added to its target thread pool. Once the task has been added to its target thread pool
            this(name, type, -1);
     * The thread pool information.
    @Override
        map.put(Names.GENERIC, ThreadPoolType.SCALING);
            }
         * then the cache is disabled and the method calls {@link System#currentTimeMillis()}
    /**
    public static final Map<String, ThreadPoolType> THREAD_POOL_TYPES;
    }
        }
            return System.currentTimeMillis();
    /*
        return ((allocatedProcessors * 3) / 2) + 1;
    /**
            }
                    );
        builders.put(Names.SNAPSHOT, new ScalingExecutorBuilder(Names.SNAPSHOT, 1, halfProcMaxAt5, TimeValue.timeValueMinutes(5)));
     * Get the {@link ExecutorService} with the given name. This executor service's
        @Override
 * The OpenSearch Contributors require contributions made to
                    builder.field("queue_size", queueSize.singles());
     * @param max   the maximum acceptable value
            return "[threaded] " + runnable.toString();
                                + typeStr
 */
 * SPDX-License-Identifier: Apache-2.0
        final Map<String, ExecutorHolder> executors = new HashMap<>();
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
    }
            }
            return runnable.hashCode();
    }
        }
        return Collections.unmodifiableCollection(builders.values());
            Names.REMOTE_DOWNLOAD,
     * Warning: this {@linkplain ExecutorService} might not throw {@link RejectedExecutionException}
            }
        return (allocatedProcessors + 1) / 2;
            final String typeStr = in.readString();
            TYPE_MAP = Collections.unmodifiableMap(typeMap);
            this.executor = executor;
        );
                if (size < 1) {
        }
 * this work for additional information regarding copyright
            return awaitTermination(pool, timeout, timeUnit);
            this.runnable = runnable;
                assert max != -1;
            type = resolvedType;
                            executor
        cluster.threadpool.snapshot.max : "5",
        boolean result = scheduler.awaitTermination(timeout, unit);
                 Other wise IllegalArgumentException will be thrown from ThreadPoolExecutor
     * Returns a value of milliseconds that may be used for relative time calculations.
        map.put(Names.REMOTE_STATE_CHECKSUM, ThreadPoolType.FIXED);
        map.put(Names.FETCH_SHARD_STORE, ThreadPoolType.SCALING);
        // TODO: configure the appropriate size and explore use of virtual threads
                resolvedType = ThreadPoolType.RESIZABLE;
     *                 command completes.
        assert Node.NODE_NAME_SETTING.exists(settings);
        return false;
import org.opensearch.common.util.concurrent.ThreadContext;
            if (awaitTermination(service, timeout, timeUnit)) return true;
                    throw new IllegalArgumentException("illegal value for [cluster.thread_pool." + tpName + "], has to be positive value");
        public String toString() {
                }
        public final Info info;
    }
                TimeValue.timeValueMinutes(5)
        private static final Map<String, ThreadPoolType> TYPE_MAP;
                        "illegal thread_pool config : " + tpGroup.keySet() + " should only have " + fixedThreadPoolKeys
import org.opensearch.common.settings.Settings;
                    builder.field("keep_alive", keepAlive.toString());
        );
                    // Only fallback for older versions
        for (final ExecutorBuilder<?> builder : customBuilders) {
            if (builders.containsKey(builder.name())) {
        private final TimeValue keepAlive;
    /**
        public static final String FORCE_MERGE = "force_merge";
        private final ThreadPoolType type;
        map.put(Names.SEARCH_THROTTLED, ThreadPoolType.RESIZABLE);
            if (service.awaitTermination(timeout, timeUnit)) {
     * give better performance at the cost of lower precision.
                || stackTraceElements[i].getMethodName().equals(testingMethod.getMethodName()) == false : testingMethod.getClassName()
        public static final String REMOTE_REFRESH_RETRY = "remote_refresh_retry";
            return "[threaded] " + runnable.toString();
    }
            // the direct executor has no threads of its own and never terminates
        final AtomicReference<RunnableTaskExecutionListener> runnableTaskListener,
            Names.REMOTE_STATE_CHECKSUM,
                        .active(0)
    public ExecutorService executor(String name) {
        }
        );
    }
                 If we are increasing ,max pool size has to be increased first
        stopCachedTimeThread();
                return true;
        for (ExecutorHolder executor : executors.values()) {
        FORK_JOIN("fork_join"),
     * than value, otherwise value
        // the assumption here is that the listeners should be very lightweight on the listeners side
    }
                    + testingMethod.getMethodName()
import org.opensearch.common.annotation.PublicApi;
                out.writeString(type.getType());
            this.absoluteMillis = System.currentTimeMillis();
            );
        builders.put(
     * @throws IllegalArgumentException if no executor service with the specified name exists
            if (typeStr.equalsIgnoreCase("fixed_auto_queue_size")) {
     * @opensearch.api
     */
    public void shutdown() {
        public static final String REFRESH = "refresh";
                            "Unknown ThreadPoolType '"
            name = in.readString();
    @Override
            if (executor.executor() != DIRECT_EXECUTOR) {
        private final Executor executor;
        return threadPoolInfo;
 * specific language governing permissions and limitations
                TimeValue.timeValueMinutes(5)
     * if you submit a task while it shutdown. It will instead silently queue it and not run it.
        private final Runnable runnable;
import java.util.concurrent.ForkJoinPool;
        final int halfProcMaxAt5 = halfAllocatedProcessorsMaxFive(allocatedProcessors);
            if (executors.containsKey(tpName) == false) {
                        resolvedType = ThreadPoolType.FIXED;
            this(name, type, size, size, null, null);
    }
                        delay,
        );
                }
            } else {
        }
                    }
            .stream()
                int core = tpGroup.getAsInt("core", threadPoolExecutor.getCorePoolSize());
        /**
        final ExecutorHolder holder = executors.get(name);
                /*
    class LoggingRunnable implements Runnable {
            while (running && 0 < interval) {
        }
                () -> new ParameterizedMessage("failed to run scheduled task [{}] on thread pool [{}]", command, executor),
        public ThreadPoolType getThreadPoolType() {
        }
import java.util.ArrayList;
        final Map<String, ExecutorBuilder> builders = new HashMap<>();
     * Warning: this {@linkplain ExecutorService} will not throw {@link RejectedExecutionException}
                                + "This may be a protocol or node version mismatch."
            builder.field("type", type.getType());
            )
        );
        // no queue as this means clients will need to handle rejections on listener queue even if the operation succeeded
        }
        public static final String FLUSH = "flush";
        try {
        builders.put(
            } else {
                1000,
 * You may obtain a copy of the License at
                    + "#"
        for (Map.Entry<String, Settings> entry : tpGroups.entrySet()) {
import org.opensearch.core.common.io.stream.Writeable;
            if (executor.executor() != DIRECT_EXECUTOR) {
        public Info(String name, ThreadPoolType type) {
        map.put(Names.SNAPSHOT, ThreadPoolType.SCALING);
     * <p>
        this.builders = Collections.unmodifiableMap(builders);
     * that require the highest precision possible. Performance critical code must use
                out.writeString(ThreadPoolType.FIXED.getType());
         * <p>
import org.opensearch.common.util.concurrent.VirtualThreadPerTaskExecutorService;
        map.put(Names.SAME, ThreadPoolType.DIRECT);
                1,
                RejectedExecutionHandler rejectedExecutionHandler = threadPoolExecutor.getRejectedExecutionHandler();
            if (0 < interval) {
        public static final String GENERIC = "generic";
            } catch (Exception e) {
import java.util.concurrent.RejectedExecutionHandler;
        builders.put(Names.WARMER, new ScalingExecutorBuilder(Names.WARMER, 1, halfProcMaxAt5, TimeValue.timeValueMinutes(5)));
     */
        );
        public static final String SAME = "same";
 * ownership. Elasticsearch licenses this file to you under
        try {
        return threadContext;
        assert stackTraceElements.length >= 3 : stackTraceElements.length;
        public static final String WRITE = "write";
            // Leverage try-with-resources to close the threadpool
 * the Apache License, Version 2.0 (the "License"); you may
    }
     * {@link ThreadContext} of the thread that queues it.
                    new ParameterizedMessage(
     * @return a ScheduledFuture who's get will return when the task is has been added to its target thread pool and throw an exception if
        /** Thread pool name for remote downloads in tiered storage. */
            ExecutorHolder holder = executors.get(tpName);
        long absoluteTimeInMillis() {
        }
 * compatible open source license.
        map.put(Names.SNAPSHOT_DELETION, ThreadPoolType.SCALING);
                || executor == DIRECT_EXECUTOR
        final int halfProc = halfAllocatedProcessors(allocatedProcessors);
            long waitTimeNanos = -1;
        return boundedBy(allocatedProcessors / 8, 1, Integer.MAX_VALUE);
            new ScalingExecutorBuilder(
    public ThreadContext getThreadContext() {
    /**
                    resolvedType = ThreadPoolType.fromType(typeStr);
        return holder.executor();
            this.type = type;
            } else {
                }
            assert stackTraceElements[i].getClassName().equals(testingMethod.getClassName()) == false
            if (type == ThreadPoolType.SCALING) {
            // A virtual thread-per-task pool has neither a bounded set of worker threads nor a queue, so threads,
            if (threadPool.awaitTermination(timeout, timeUnit)) {
        return TimeValue.nsecToMSec(relativeTimeInNanos());
            final ExecutorBuilder.ExecutorSettings executorSettings = entry.getValue().getSettings(settings);
            }
            if (holder.executor() instanceof VirtualThreadPerTaskExecutorService virtualExecutor) {
import org.opensearch.core.common.io.stream.StreamInput;
        final StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            } catch (OpenSearchRejectedExecutionException e) {
    class ThreadedRunnable implements Runnable {
        Setting.Property.NodeScope
        if (!Names.SAME.equals(executor)) {
        this.threadPoolInfo = new ThreadPoolInfo(infos);
     * (inclusive).
    Fixed/ResizableQueue can provide only size
import org.apache.logging.log4j.message.ParameterizedMessage;
            Names.INDEX_SEARCHER,
        private final int max;
        private final Runnable runnable;
        public static final String FETCH_SHARD_STORE = "fetch_shard_store";
        }
    public static final Setting<Settings> CLUSTER_THREAD_POOL_SIZE_SETTING = Setting.groupSetting(
            // last resort
    }
     * <p>
     * @param command  the command to run
                 If we are decreasing, core pool size has to be decreased first.
    @Override
        assert Thread.currentThread().getName().contains("scheduler") == false : "Expected current thread ["
    /**
        volatile long relativeNanos;
            } else if (type == ThreadPoolType.FORK_JOIN && out.getVersion().before(Version.V_3_4_0)) {
        map.put(Names.FETCH_SHARD_STARTED, ThreadPoolType.SCALING);
            Names.FETCH_SHARD_STARTED,
        public void run() {
     * the ScheduledFuture will cannot interact with it.
                if (scalingThreadPoolKeys.containsAll(tpGroup.keySet()) == false) {
    }
    }
            } else if (type == ThreadPoolType.VIRTUAL) {
        }
            executors.put(entry.getKey(), executorHolder);
            new FixedExecutorBuilder(settings, Names.REMOTE_STATE_READ, boundedBy(4 * allocatedProcessors, 4, 32), 120000)
        return new ThreadPoolStats(stats);
            max = in.readInt();
                    return;
            }
            int largest = -1;
        map.put(Names.INDEX_SEARCHER, ThreadPoolType.RESIZABLE);
        TimeValue estimatedTimeInterval = ESTIMATED_TIME_INTERVAL_SETTING.get(settings);
        return result;
        }
    public static Setting<TimeValue> ESTIMATED_TIME_INTERVAL_SETTING = Setting.timeSetting(
    ) {
                } else {
            if (holder.info.type == ThreadPoolType.FORK_JOIN) {
    }
                runnable.run();
        builders.put(
        builders.put(Names.TRANSLOG_RECOVERY, new FixedExecutorBuilder(settings, Names.TRANSLOG_RECOVERY, allocatedProcessors, -1));
        volatile long absoluteMillis;
        public static final String REMOTE_RECOVERY = "remote_recovery";
    public Info info(String name) {
                throw new IllegalArgumentException("illegal thread_pool name : " + tpName);
                    executor.setMaximumPoolSize(max);
                largest = threadPoolExecutor.getLargestPoolSize();
            int active = -1;
     *
            // Executor types that do not expose pool metrics fall through with the -1 "unavailable" defaults set above.
         */
            }
        for (int i = 3; i < stackTraceElements.length; i++) {
    }
        }
/*
                    );
        TimeValue.ZERO,
        if (service != null) {
        return boundedBy(2 * allocatedProcessors, 2, Integer.MAX_VALUE);
        map.put(Names.ANALYZE, ThreadPoolType.FIXED);
            Names.REMOTE_STATE_READ,
        return false;
            + Thread.currentThread()
            OpenSearchThreadPoolExecutor executor = (OpenSearchThreadPoolExecutor) holder.executor;
     */
        }
import java.util.HashMap;
            }
import java.util.Collections;
@PublicApi(since = "1.0.0")
                    rejected = xRejectedExecutionHandler.rejected();
        if (holder == null) {
        VIRTUAL("virtual");
                            "could not schedule execution of [{}] on [{}] as executor is shut down",
        builders.put(Names.FLUSH, new ScalingExecutorBuilder(Names.FLUSH, 1, halfProcMaxAt5, TimeValue.timeValueMinutes(5)));
        map.put(Names.SYSTEM_READ, ThreadPoolType.FIXED);
import org.opensearch.node.Node;
        map.put(Names.REMOTE_STATE_READ, ThreadPoolType.FIXED);
    static {
        builders.put(Names.GET, new FixedExecutorBuilder(settings, Names.GET, allocatedProcessors, 1000));
        builders.put(Names.TRANSLOG_SYNC, new FixedExecutorBuilder(settings, Names.TRANSLOG_SYNC, allocatedProcessors * 4, 10000));
            }
     */
                    new ThreadPoolStats.Stats.Builder().name(name)
            this.min = min;
            this.max = max;
                builder.field("max", max);
                settings,
            stats.add(
                searchThreadPoolSize(allocatedProcessors),
    public ThreadPoolInfo info() {
 *
            return this.type;
            command = new ThreadedRunnable(command, executor(executor));
        public int getMin() {
import java.io.IOException;
        public static final String SYSTEM_WRITE = "system_write";
            Names.SNAPSHOT_DELETION,
     * timestamp, see {@link #absoluteTimeInMillis()}.
        },
     */
            // the direct executor runs tasks on the calling thread and does not support being shut down
                    throw new IllegalArgumentException(
        builders.put(Names.SYSTEM_READ, new FixedExecutorBuilder(settings, Names.SYSTEM_READ, halfProcMaxAt5, 2000, false));
         * <p>
                    .completed(completed)
                    executor.setCorePoolSize(size);
                try {
            ThreadPoolType resolvedType;
    }
                    throw new IllegalArgumentException("core threadpool size cannot be greater than max");
    /**
        }
        public TimeValue getKeepAlive() {
                    + " is called recursively";
                    );
            long completed = -1;
            )
        this(settings, null, customBuilders);
        ThreadedRunnable(Runnable runnable, Executor executor) {
        builders.put(Names.SYSTEM_WRITE, new FixedExecutorBuilder(settings, Names.SYSTEM_WRITE, halfProcMaxAt5, 1000, false));
                    if (in.getVersion().onOrBefore(Version.V_3_3_0)) { // ForkJoinPool Introduced in 3.4.0 onwards
        builders.put(Names.SEARCH_THROTTLED, new ResizableExecutorBuilder(settings, Names.SEARCH_THROTTLED, 1, 100, runnableTaskListener));
                builder.field("parallelism", max);
        threadContext = new ThreadContext(settings);
        public void run() {
            Names.SEARCH,
            builder.endObject();
                        .build()
import org.opensearch.gateway.remote.ClusterStateChecksum;
        return cachedTimeThread.absoluteTimeInMillis();
            }
                }
 *
                    logger.debug(
            this.queueSize = queueSize;
        public static final String GET = "get";
        public Info(String name, ThreadPoolType type, int min, int max, @Nullable TimeValue keepAlive, @Nullable SizeValue queueSize) {
            if (logger.isDebugEnabled()) {
                return relativeNanos;
     * this method, see {@link #relativeTimeInMillis()}.
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
    }
        @Deprecated
     * Constrains a value between minimum and maximum values
        public static final String ANALYZE = "analyze";
     * if you submit a task while it shutdown. It will instead silently queue it and not run it.
 * Licensed to Elasticsearch under one or more contributor
                int core = tpGroup.getAsInt("core", executor.getCorePoolSize());
        public boolean equals(Object obj) {
        static {
        public static final String FETCH_SHARD_STARTED = "fetch_shard_started";
                        "illegal thread_pool config : " + tpGroup.keySet() + " should only have " + scalingThreadPoolKeys
            (e) -> logger.warn(
                int size = tpGroup.getAsInt("size", threadPoolExecutor.getMaximumPoolSize());
    private static boolean awaitTermination(final ExecutorService service, final long timeout, final TimeUnit timeUnit) {
    );
    public ThreadPool(final Settings settings, final ExecutorBuilder<?>... customBuilders) {
                        .parallelism(holder.info.getMax())
import java.util.List;
                active = threadPoolExecutor.getActiveCount();
            return null;
        DIRECT("direct"),
        final StackTraceElement testingMethod = stackTraceElements[2];
        public static final String TRANSLOG_RECOVERY = "translog_recovery";
import java.util.concurrent.atomic.AtomicReference;
            }
         * Return the current epoch time, used to find absolute time. This is
import org.opensearch.common.Nullable;
    private final ScheduledThreadPoolExecutor scheduler;
        final int allocatedProcessors = OpenSearchExecutors.allocatedProcessors(settings);
            new ScalingExecutorBuilder(Names.REMOTE_REFRESH_RETRY, 1, halfProc, TimeValue.timeValueMinutes(5))
     */
                return true;
import java.util.concurrent.TimeUnit;
                continue;
        @Nullable
        Setting.Property.NodeScope
        @Override
        public static final String WARMER = "warmer";
        map.put(Names.WRITE, ThreadPoolType.FIXED);
        Setting.Property.Dynamic,
     * timestamp, see {@link #absoluteTimeInMillis()}.
    }
        @Override
    }
        @Override
        }
            } else {
                    builder.field("queue_size", -1);
            }
import java.util.concurrent.Executor;
     * @param name the name of the executor service to obtain
                    .build()
            }
        public static final String REMOTE_PURGE = "remote_purge";
    Scaling threadpool can provide only max and core
     * This method should only be used for calculating time deltas. For an epoch based
            } else if (holder.executor() instanceof OpenSearchThreadPoolExecutor threadPoolExecutor) {
            min = in.readInt();
     * The threadpool type.
            return threadPoolType;
        private final String type;
        return executor(Names.GENERIC);
        }
    }
    }
                try {
            }
    static Set<String> scalingThreadPoolKeys = new HashSet<>(Arrays.asList("max", "core"));
import java.util.concurrent.ScheduledThreadPoolExecutor;
 */
        }
    private final Map<String, ExecutorBuilder> builders;
        public static final String LISTENER = "listener";
            } else {
        final Settings settings,
     * @return min if value is less than min, max if value is greater
        @Override
                // OpenSearch on older version doesn't know about "resizable" thread pool. Convert RESIZABLE to FIXED
            out.writeString(name);
        @Override
                if (core < 1 || max < 1) {
            return this.keepAlive;
     * This method should only be used for exact date/time formatting. For calculating
                active = virtualExecutor.getActiveCount();
            Names.REMOTE_RECOVERY,
    public static class Info implements Writeable, ToXContentFragment {
                return absoluteMillis;
            int parallelism = -1;
            builders.put(builder.name(), builder);
        public int hashCode() {
     * Returns the value of milliseconds since UNIX epoch.
            out.writeOptionalTimeValue(keepAlive);
                || info.type == ThreadPoolType.VIRTUAL;
        if (pool != null) {
import org.opensearch.common.settings.Setting;
        return new ReschedulingRunnable(command, interval, executor, this, (e) -> {
                } catch (IllegalArgumentException e) {
     *
        }
            }
                        .rejected(0)
                } else {
            schedule(command, delay, executor);
         */
        builders.put(
            } else if (type == ThreadPoolType.FORK_JOIN) {
            return System.nanoTime();
        assert stackTraceElements[0].getMethodName().equals("getStackTrace") : stackTraceElements[0];
            keepAlive = in.readOptionalTimeValue();
    public long preciseRelativeTimeInNanos() {
            Settings tpGroup = entry.getValue();
        return false;
    public static int searchThreadPoolSize(final int allocatedProcessors) {
            new ScalingExecutorBuilder(Names.FETCH_SHARD_STARTED, 1, 2 * allocatedProcessors, TimeValue.timeValueMinutes(5))
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        ExecutorService executor() {
                    .active(active)
        map.put(Names.LISTENER, ThreadPoolType.FIXED);
    private final Map<String, ExecutorHolder> executors;
        }
            return runnable.equals(obj);
    }
     */
        );
            final ExecutorHolder executorHolder = entry.getValue().build(executorSettings, threadContext);
     * <p>
    }
            Names.FETCH_SHARD_STORE,
        builders.put(
        HashMap<String, ThreadPoolType> map = new HashMap<>();
        }
        public static final String SYSTEM_READ = "system_read";
        long relativeTimeInNanos() {
                throw new IllegalStateException("duplicate executors with name [" + executorHolder.info.getName() + "] registered");
        builders.put(Names.MANAGEMENT, new ScalingExecutorBuilder(Names.MANAGEMENT, 1, 5, TimeValue.timeValueMinutes(5)));
import java.util.HashSet;
    public void shutdownNow() {
        }
        }
    public ScheduledCancellable schedule(Runnable command, TimeValue delay, String executor) {
            new FixedExecutorBuilder(settings, Names.FORCE_MERGE, oneEighthAllocatedProcessors(allocatedProcessors), -1)
        }
     */
            new ResizableExecutorBuilder(
    }
     *
                // VIRTUAL introduced in 3.8, convert to SCALING for bwc
            new ScalingExecutorBuilder(Names.FETCH_SHARD_STORE, 1, 2 * allocatedProcessors, TimeValue.timeValueMinutes(5))
        );
                        .completed(0)
        "cluster.thread_pool.",
            this.relativeNanos = System.nanoTime();
 * not use this file except in compliance with the License.
                        throw new IllegalArgumentException(
     * {@link ThreadContext} of the thread that queues it.
    public enum ThreadPoolType {
        SCALING("scaling"),
    }
            }
            if (holder.info.type == ThreadPoolType.SCALING) {
            if (0 < interval) {
                stats.add(
     */
        builders.put(Names.LISTENER, new FixedExecutorBuilder(settings, Names.LISTENER, halfProcMaxAt10, -1, true));
    }
        builders.put(
     * @param delay    delay before the task executes
        builders.put(Names.REFRESH, new ScalingExecutorBuilder(Names.REFRESH, 1, halfProcMaxAt10, TimeValue.timeValueMinutes(5)));
        private final SizeValue queueSize;
                        command,
                }
                                + in.getVersion()
        public static final String MERGE = "merge";
        cachedTimeThread.join(unit.toMillis(timeout));
    }
     */
        }
        return boundedBy((allocatedProcessors + 1) / 2, 1, 10);
/*
        }
        stopCachedTimeThread();
            try {
        public boolean equals(Object obj) {
        FIXED("fixed"),
    public Collection<ExecutorBuilder> builders() {
        }
        builders.put(Names.REMOTE_PURGE, new ScalingExecutorBuilder(Names.REMOTE_PURGE, 1, halfProc, TimeValue.timeValueMinutes(5)));
                 This ensures that core pool is always smaller than max pool size .
            }
            int queue = -1;
        map.put(Names.SEARCH, ThreadPoolType.RESIZABLE);
            if (holder == null) {
        }
import java.util.concurrent.ExecutorService;
            new ScalingExecutorBuilder(Names.SNAPSHOT_DELETION, 1, snapshotDeletionPoolMax, TimeValue.timeValueMinutes(5))
            return this.max;
 * Modifications Copyright OpenSearch Contributors. See
        return Math.min(max, Math.max(min, value));
    }
        private final int min;
        public Info(String name, ThreadPoolType type, int size) {
                queue = threadPoolExecutor.getQueue().size();
        TimeValue.timeValueMillis(200),
        ExecutorHolder holder = executors.get(name);
            if (executor.executor() != DIRECT_EXECUTOR) {
        volatile boolean running = true;
            return builder;
        map.put(Names.REMOTE_REFRESH_RETRY, ThreadPoolType.SCALING);
                out.writeString(ThreadPoolType.SCALING.getType());
     * <p>
        map.put(Names.WARMER, ThreadPoolType.SCALING);
            }
                        .queue(0)
 * under the License.
                );
    }
        }
    static int halfAllocatedProcessors(int allocatedProcessors) {
            pool.shutdown();
                            runnable,
    public static boolean terminate(ExecutorService service, long timeout, TimeUnit timeUnit) {
        builders.put(Names.MERGE, new ScalingExecutorBuilder(Names.MERGE, 1, allocatedProcessors, TimeValue.timeValueMinutes(5)));
            for (ThreadPoolType threadPoolType : ThreadPoolType.values()) {
                builder.field("core", min);
     * Returns <code>true</code> if the given pool was terminated successfully. If the termination timed out,
    }
                executor.executor().shutdown();
        public static final String MANAGEMENT = "management";
    }
        );
        }
    }
                Names.INDEX_SEARCHER,
        private final ExecutorService executor;
                                + "' for version "
            logger.debug("created thread pool: {}", entry.getValue().formatInfo(executorHolder.info));
        public Info(StreamInput in) throws IOException {
                }
            if (awaitTermination(pool, timeout, timeUnit)) {
        Map<String, Settings> tpGroups = tpSettings.getAsGroups();
        command = threadContext.preserveContext(command);
        for (ExecutorHolder holder : executors.values()) {
                throw new IllegalArgumentException("builder with name [" + builder.name() + "] already exists");
                assert max != -1;
                if (queueSize == null) {
     *
    static class ExecutorHolder {
            if (type == ThreadPoolType.RESIZABLE && out.getVersion().before(Version.V_3_0_0)) {
                                + ". "
        }
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        public static final String SNAPSHOT_DELETION = "snapshot_deletion";
     * This method should only be used for calculating time deltas. For an epoch based
                logger.warn(() -> new ParameterizedMessage("failed to run {}", runnable.toString()), e);
     * {@link Executor#execute(Runnable)} method will run the {@link Runnable} it is given in the
            Names.FORCE_MERGE,
import org.opensearch.Version;
        map.put(Names.MERGE, ThreadPoolType.SCALING);
        for (ExecutorHolder executor : executors.values()) {
            return this.name;
 * Unless required by applicable law or agreed to in writing,
        return this.scheduler;
        @Override
    public static class Names {
        public static final String INDEX_SEARCHER = "index_searcher";
            int threads = -1;
        cluster.threadpool.get.size : "2",
     * the service is <code>null</code> this method will return <code>false</code>.
        public String getType() {
        @Nullable
                throw new IllegalArgumentException("illegal thread_pool name : " + tpName);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
            Map<String, ThreadPoolType> typeMap = new HashMap<>();
            )
                }
        }
        }
                Names.REMOTE_RECOVERY,
    public static boolean assertCurrentMethodIsNotCalledRecursively() {
import java.util.stream.Collectors;
        for (Map.Entry<String, Settings> entry : tpGroups.entrySet()) {
                twiceAllocatedProcessors(allocatedProcessors),
            }
            service.shutdownNow();
         * then the cache is disabled and the method calls {@link System#nanoTime()}
            OpenSearchThreadPoolExecutor threadPoolExecutor = (OpenSearchThreadPoolExecutor) holder.executor;
            Settings tpGroup = entry.getValue();
            if (holder.info.type == ThreadPoolType.FORK_JOIN || holder.info.type == ThreadPoolType.VIRTUAL) {
                        ),
        cachedTimeThread.running = false;
 * The OpenSearch threadpool class
         * If {@link ThreadPool#ESTIMATED_TIME_INTERVAL_SETTING} is set to 0
            final String name = holder.info.getName();
     * {@link Executor#execute(Runnable)} method will run the {@link Runnable} it is given in the
    public long relativeTimeInNanos() {
            }
    }
        public static final String REMOTE_STATE_CHECKSUM = "remote_state_checksum";
                if (rejectedExecutionHandler instanceof XRejectedExecutionHandler xRejectedExecutionHandler) {
        public static final String TRANSLOG_TRANSFER = "translog_transfer";
     * The threadpool names.
            // no need to have info on "same" thread pool
 */
            + "]";
     */
    }
            return this.min;
        public void writeTo(StreamOutput out) throws IOException {
        map.put(Names.TRANSLOG_RECOVERY, ThreadPoolType.FIXED);
                } else if (core > max) {
        map.put(Names.TRANSLOG_TRANSFER, ThreadPoolType.SCALING);
 * software distributed under the License is distributed on an
        scheduler.shutdownNow();
        public static final String TRANSLOG_SYNC = "translog_sync";
import static java.util.Collections.unmodifiableMap;
                logger.debug(() -> new ParameterizedMessage("scheduled task [{}] was rejected on thread pool [{}]", command, executor), e);
            )
        @Override
        } catch (OpenSearchRejectedExecutionException e) {
                throw e;
        this.scheduler = Scheduler.initScheduler(settings);
import java.util.Arrays;
                throw new IllegalArgumentException("no ThreadPoolType for " + type);
            this.interval = interval;
 * @opensearch.api
    private void validateSetting(Settings tpSettings) {
                twiceAllocatedProcessors(allocatedProcessors),
            } else if (type == ThreadPoolType.VIRTUAL && out.getVersion().before(Version.V_3_8_0)) {
    protected final void stopCachedTimeThread() {
     * @opensearch.internal
        return holder.info;
    private static final Logger logger = LogManager.getLogger(ThreadPool.class);
            }
                typeMap.put(threadPoolType.getType(), threadPoolType);
            + reason
                    throw e;
                int max = tpGroup.getAsInt("max", executor.getMaximumPoolSize());
            this.runnable = runnable;
        builders.put(
        return cachedTimeThread.relativeTimeInNanos();
        public int getMax() {
            out.writeOptionalWriteable(queueSize);
            Thread.currentThread().interrupt();
            return executor;
                builder.field("size", max);
            String tpName = entry.getKey();
     * <p>
     * <p>
    );
                    .queue(queue)
import org.opensearch.common.settings.ClusterSettings;
        public static final String REMOTE_STATE_READ = "remote_state_read";
            .collect(Collectors.toList());
        final long interval;
}
    /**
            new FixedExecutorBuilder(settings, Names.REMOTE_STATE_CHECKSUM, ClusterStateChecksum.COMPONENT_SIZE, 1000)
     * @param min   the minimum acceptable value
            // Opensearch on or after 3.0.0 version doesn't know about "fixed_auto_queue_size" thread pool. Convert it to RESIZABLE.
                if (e.isExecutorShutdown()) {
        }
    public static boolean terminate(ThreadPool pool, long timeout, TimeUnit timeUnit) {
     * @throws OpenSearchRejectedExecutionException if the task cannot be scheduled for execution
    public long relativeTimeInMillis() {
                e
         * whenever called. Typically used for testing.
        return true;
            return type;
        builders.put(
     * Schedules a one-shot command to run after a given delay. The command is run in the context of the calling thread.
            }
        cachedTimeThread.interrupt();
            if (threadPoolType == null) {
            }
            if ("same".equals(name)) {
                    builder.field("queue_size", queueSize.singles());
        }
                    executor.setCorePoolSize(size);
        executors.put(Names.SAME, new ExecutorHolder(DIRECT_EXECUTOR, new Info(Names.SAME, ThreadPoolType.DIRECT)));
        }
    }
        builders.put(
                    e
            }
    /**
        builders.put(
    /**
            this.executor = executor;
    /**
            return this.queueSize;
        map.put(Names.REFRESH, ThreadPoolType.SCALING);
    public ScheduledExecutorService scheduler() {
                throw e;
         * If {@link ThreadPool#ESTIMATED_TIME_INTERVAL_SETTING} is set to 0
                out.writeString(ThreadPoolType.FIXED.getType());
import org.apache.logging.log4j.Logger;
            long rejected = -1;
            }
import org.opensearch.core.service.ReportingService;
                    ),
                    executor.setCorePoolSize(core);
        final int snapshotDeletionPoolMax = boundedBy(4 * allocatedProcessors, 64, 256);
        this.cachedTimeThread = new CachedTimeThread(OpenSearchExecutors.threadName(settings, "[timer]"), estimatedTimeInterval.millis());
        }
                } else {
import org.opensearch.core.common.io.stream.StreamOutput;
        this.executors = unmodifiableMap(executors);
     * Returns a value of nanoseconds that may be used for relative time calculations.
    static int halfAllocatedProcessorsMaxTen(final int allocatedProcessors) {
        public static final String STREAM_SEARCH = "stream_search";
            out.writeInt(min);
import org.opensearch.core.xcontent.ToXContentFragment;
            }
        );
        }
        );
        }
        List<ThreadPoolStats.Stats> stats = new ArrayList<>();
            + "] to not be the scheduler thread. Reason: ["
        CachedTimeThread(String name, long interval) {
        "thread_pool.estimated_time_interval",
public class ThreadPool implements ReportingService<ThreadPoolInfo>, Scheduler {
        ExecutorHolder(ExecutorService executor, Info info) {
     * Returns <code>true</code> if the given service was terminated successfully. If the termination timed out,
                    Thread.sleep(interval);
        final List<Info> infos = executors.values()
            throw new IllegalArgumentException("no executor service found for [" + name + "]");
            this.info = info;
            new ScalingExecutorBuilder(Names.TRANSLOG_TRANSFER, 1, halfProc, TimeValue.timeValueMinutes(5))
        try {
        @Override
import org.opensearch.common.unit.SizeValue;
                }
        /**
                        .largest(0)
    public void scheduleUnlessShuttingDown(TimeValue delay, String executor, Runnable command) {
    public void setThreadPool(Settings tpSettings) {
            builder.startObject(name);
        if (holder == null) {
     * A thread to cache millisecond time values from
    static int oneEighthAllocatedProcessors(final int allocatedProcessors) {
                1,
            new ResizableExecutorBuilder(settings, Names.SEARCH, searchThreadPoolSize(allocatedProcessors), 1000, runnableTaskListener)
         * a cached version of {@link System#currentTimeMillis()}.
            assert executor instanceof OpenSearchThreadPoolExecutor
import java.util.concurrent.RejectedExecutionException;
 * KIND, either express or implied.  See the License for the
        }
        RESIZABLE("resizable"),
        assert stackTraceElements[1].getMethodName().equals("assertCurrentMethodIsNotCalledRecursively") : stackTraceElements[1];
                1000,
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
                }
    }
            // neither a ForkJoinPool nor a virtual thread-per-task pool can be resized
                );
            if (e.isExecutorShutdown()) {
    }
     */
     * either {@link #relativeTimeInNanos()} or {@link #relativeTimeInMillis()} which
        }
import org.apache.logging.log4j.LogManager;
 * this file be licensed under the Apache-2.0 license or a
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_THREAD_POOL_SIZE_SETTING, this::setThreadPool, this::validateSetting);
                }
                return true;
    static final ExecutorService DIRECT_EXECUTOR = OpenSearchExecutors.newDirectExecutorService();
    }
            .filter(holder -> holder.info.getName().equals("same") == false)
     * @param executor the name of the thread pool on which to execute this task. SAME means "execute on the scheduler thread" which changes
        return System.nanoTime();
     * <p>
                } else {
     * Get the generic {@link ExecutorService}. This executor service
