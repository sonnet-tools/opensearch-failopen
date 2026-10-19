        map.put(Names.MANAGEMENT, ThreadPoolType.SCALING);
            this.info = info;
        public static final String GET = "get";
     * <p>
                    builder.field("keep_alive", keepAlive.toString());
                            runnable,
     * Returns a value of nanoseconds that may be used for relative time calculations
                if (queueSize == null) {  
    /*  
        private final ThreadPoolType type;  
     * <p>  
            this.interval = interval;
                largest = threadPoolExecutor.getLargestPoolSize();  
        return result;
    /**
        builders.put(  
    /**
     * {@link ThreadContext} of the thread that queues it.
                assert min != -1;
            assert holder.executor instanceof OpenSearchThreadPoolExecutor;
     */
import org.opensearch.common.unit.TimeValue;
            name = in.readString();  
            builder.field("type", type.getType());
        map.put(Names.GENERIC, ThreadPoolType.SCALING);
        public static final String STREAM_SEARCH = "stream_search";  
        volatile long absoluteMillis;  
                active = virtualExecutor.getActiveCount();  
                if (queueSize == null) {  
            }  
                        .threads(0)
        map.put(Names.TRANSLOG_RECOVERY, ThreadPoolType.FIXED);  
        }
        private final Runnable runnable;
        } catch (InterruptedException e) {  
         * then the cache is disabled and the method calls {@link System#nanoTime()}
            Names.REMOTE_STATE_READ,
        );  
        for (ExecutorHolder executor : executors.values()) {  
    public ThreadContext getThreadContext() {  
     */  
                Names.REMOTE_DOWNLOAD,
                result &= executor.executor().awaitTermination(timeout, unit);  
                relativeNanos = System.nanoTime();  
        map.put(Names.SNAPSHOT, ThreadPoolType.SCALING);
        final StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
                    executor.setMaximumPoolSize(max);  
                builder.field("core", min);  
                if (keepAlive != null) {  
    protected final void stopCachedTimeThread() {
        }
            }
                searchThreadPoolSize(allocatedProcessors),  
        }  
    private static boolean awaitTermination(final ThreadPool threadPool, final long timeout, final TimeUnit timeUnit) {
            new ScalingExecutorBuilder(Names.SNAPSHOT_DELETION, 1, snapshotDeletionPoolMax, TimeValue.timeValueMinutes(5))
                    throw new IllegalArgumentException("core threadpool size cannot be greater than max");  
            }
                    executor.setMaximumPoolSize(size);
            }
        ThreadedRunnable(Runnable runnable, Executor executor) {
        }
        public static final String WRITE = "write";
        /**  
        ExecutorHolder(ExecutorService executor, Info info) {
        private final Runnable runnable;  
        return System.nanoTime();
                Names.REMOTE_RECOVERY,
            } else if (type == ThreadPoolType.FORK_JOIN && out.getVersion().before(Version.V_3_4_0)) {  
         * <p>  
                 */  
         * <p>  
            return this.keepAlive;  
                    running = false;
            }  
                resolvedType = ThreadPoolType.RESIZABLE;
     */
                1000,
 *
         * Return the current time used for relative calculations. This is {@link System#nanoTime()}.
    public static int searchThreadPoolSize(final int allocatedProcessors) {  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            if (type == ThreadPoolType.RESIZABLE && out.getVersion().before(Version.V_3_0_0)) {
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            Map<String, ThreadPoolType> typeMap = new HashMap<>();
     * This method should only be used for exact date/time formatting. For calculating
            max = in.readInt();  
            )
                }
        }
     * (inclusive).
                    .build()
        }
                out.writeString(ThreadPoolType.FIXED.getType());
/**
        public static final String REMOTE_STATE_READ = "remote_state_read";  
        return new ScheduledCancellableAdapter(scheduler.schedule(command, delay.millis(), TimeUnit.MILLISECONDS));  
        return cachedTimeThread.absoluteTimeInMillis();
                if (keepAlive != null) {  
        map.put(Names.REMOTE_RECOVERY, ThreadPoolType.SCALING);  
        builders.put(Names.GET, new FixedExecutorBuilder(settings, Names.GET, allocatedProcessors, 1000));  
        return boundedBy(allocatedProcessors / 8, 1, Integer.MAX_VALUE);
        return false;
                queue = threadPoolExecutor.getQueue().size();
                    e  
    }
        this.cachedTimeThread = new CachedTimeThread(OpenSearchExecutors.threadName(settings, "[timer]"), estimatedTimeInterval.millis());
    }
        return cachedTimeThread.relativeTimeInNanos();
    public long absoluteTimeInMillis() {  
                logger.warn(() -> new ParameterizedMessage("failed to run {}", runnable.toString()), e);
    }  
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_THREAD_POOL_SIZE_SETTING, this::setThreadPool, this::validateSetting);  
     * The values are updated at a specified interval.
        final ExecutorHolder holder = executors.get(name);
        }  
                int core = tpGroup.getAsInt("core", threadPoolExecutor.getCorePoolSize());
    @Override
     *
        map.put(Names.TRANSLOG_TRANSFER, ThreadPoolType.SCALING);
                    throw new IllegalArgumentException("illegal value for [cluster.thread_pool." + tpName + "], has to be positive value");
                assert max != -1;
        map.put(Names.SEARCH, ThreadPoolType.RESIZABLE);
        builders.put(Names.SEARCH_THROTTLED, new ResizableExecutorBuilder(settings, Names.SEARCH_THROTTLED, 1, 100, runnableTaskListener));
                }  
        for (final Map.Entry<String, ExecutorBuilder> entry : builders.entrySet()) {
            long rejected = -1;
            }
     * This method should only be used for calculating time deltas. For an epoch based
        );  
                        ),  
        public static final String ANALYZE = "analyze";  
    public void shutdownNow() {
    private final ThreadContext threadContext;
        },
    private static boolean awaitTermination(final ExecutorService service, final long timeout, final TimeUnit timeUnit) {
                    .largest(largest)  
            if (threadPool.awaitTermination(timeout, timeUnit)) {  
import org.opensearch.node.Node;
        stopCachedTimeThread();  
        }
     * <p>
        );
            assert executor instanceof OpenSearchThreadPoolExecutor
     * {@link ThreadContext} of the thread that queues it.
        return false;  
            type = resolvedType;
     * this method, see {@link #relativeTimeInMillis()}.
        builders.put(  
            if (holder.executor() instanceof VirtualThreadPerTaskExecutorService virtualExecutor) {
                    logger.debug(
        map.put(Names.STREAM_SEARCH, ThreadPoolType.RESIZABLE);  
                }
                }
        );  
        builders.put(  
            return awaitTermination(pool, timeout, timeUnit);
            new ResizableExecutorBuilder(
        public SizeValue getQueueSize() {
        }
        builders.put(Names.SYSTEM_WRITE, new FixedExecutorBuilder(settings, Names.SYSTEM_WRITE, halfProcMaxAt5, 1000, false));
    private static final Logger logger = LogManager.getLogger(ThreadPool.class);
     * Constrains a value between minimum and maximum values  
            )
                1,
/*  
    public long relativeTimeInNanos() {  
    public enum ThreadPoolType {
        public static final String SEARCH = "search";
     * @return a ScheduledFuture who's get will return when the task is has been added to its target thread pool and throw an exception if
        builders.put(Names.MANAGEMENT, new ScalingExecutorBuilder(Names.MANAGEMENT, 1, 5, TimeValue.timeValueMinutes(5)));  
            return this.type;
            Names.REMOTE_REFRESH_RETRY,
                builder.field("size", max);
                } else {
        assert stackTraceElements.length >= 3 : stackTraceElements.length;  
    }
            this(name, type, -1);
        private final int max;
            Names.FETCH_SHARD_STORE,
import java.util.List;
        return holder.info;
        }  
            new FixedExecutorBuilder(settings, Names.REMOTE_STATE_READ, boundedBy(4 * allocatedProcessors, 4, 32), 120000)  
            return runnable.hashCode();
            while (running && 0 < interval) {
        volatile boolean running = true;
    }  
                    builder.field("queue_size", queueSize.singles());  
     * the ScheduledFuture will cannot interact with it.  
    }
import org.opensearch.core.service.ReportingService;  
        public static final String FETCH_SHARD_STARTED = "fetch_shard_started";
    }
        public void run() {
        @Override  
        map.put(Names.SYSTEM_READ, ThreadPoolType.FIXED);  
        /**
        map.put(Names.FETCH_SHARD_STORE, ThreadPoolType.SCALING);
            return null;  
import java.util.concurrent.Executor;
     * This method should only be used for calculating time deltas. For an epoch based
import java.util.concurrent.atomic.AtomicReference;  
    private final ScheduledThreadPoolExecutor scheduler;
        );  
import org.opensearch.core.common.io.stream.StreamOutput;  
        }  
                out.writeString(type.getType());
        public static final String TRANSLOG_RECOVERY = "translog_recovery";
                    throw e;
            Names.SEARCH,  
        final int allocatedProcessors = OpenSearchExecutors.allocatedProcessors(settings);  
     * <p>
                } catch (InterruptedException e) {
    static Set<String> fixedThreadPoolKeys = new HashSet<>(Arrays.asList("size"));  
        long absoluteTimeInMillis() {
    }  
        }  
        map.put(Names.ANALYZE, ThreadPoolType.FIXED);  
        this.threadPoolInfo = new ThreadPoolInfo(infos);
                1000,
import java.util.concurrent.ForkJoinPool;  
                continue;  
        builders.put(Names.REMOTE_PURGE, new ScalingExecutorBuilder(Names.REMOTE_PURGE, 1, halfProc, TimeValue.timeValueMinutes(5)));
    static {
                        .active(0)
        Map<String, Settings> tpGroups = tpSettings.getAsGroups();
    public long preciseRelativeTimeInNanos() {
     * <p>
        final long interval;  
            }
        map.put(Names.REFRESH, ThreadPoolType.SCALING);  
        public static ThreadPoolType fromType(String type) {  
            new FixedExecutorBuilder(settings, Names.FORCE_MERGE, oneEighthAllocatedProcessors(allocatedProcessors), -1)  
                } else {  
            }
                return true;
import org.opensearch.common.util.concurrent.ThreadContext;
            return "[threaded] " + runnable.toString();  
        public static final String REMOTE_DOWNLOAD = "remote_download";
    /**
        builders.put(Names.REFRESH, new ScalingExecutorBuilder(Names.REFRESH, 1, halfProcMaxAt10, TimeValue.timeValueMinutes(5)));
                        resolvedType = ThreadPoolType.FIXED;  
import java.util.concurrent.TimeUnit;
                logger.debug(() -> new ParameterizedMessage("scheduled task [{}] was rejected on thread pool [{}]", command, executor), e);  
                if (core < executor.getCorePoolSize()) {
            long completed = -1;
        builders.put(
        }  
    static final ExecutorService DIRECT_EXECUTOR = OpenSearchExecutors.newDirectExecutorService();
    }  
     */
        executors.put(Names.SAME, new ExecutorHolder(DIRECT_EXECUTOR, new Info(Names.SAME, ThreadPoolType.DIRECT)));
            out.writeString(name);
        for (int i = 3; i < stackTraceElements.length; i++) {
            new ResizableExecutorBuilder(  
        return holder.executor();
            if (holder == null) {
        scheduler.shutdown();
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
        map.put(Names.LISTENER, ThreadPoolType.FIXED);
            assert holder.executor instanceof OpenSearchThreadPoolExecutor;
            if (holder.info.type == ThreadPoolType.FORK_JOIN || holder.info.type == ThreadPoolType.VIRTUAL) {
        cachedTimeThread.interrupt();  
                }
                } else {
            new ScalingExecutorBuilder(Names.FETCH_SHARD_STORE, 1, 2 * allocatedProcessors, TimeValue.timeValueMinutes(5))
        }
                || info.type == ThreadPoolType.VIRTUAL;
         */
        public int hashCode() {
            min = in.readInt();
import java.util.HashMap;
            return System.nanoTime();  
                RejectedExecutionHandler rejectedExecutionHandler = threadPoolExecutor.getRejectedExecutionHandler();
        public static final String LISTENER = "listener";
     *
        );  
    }  
                    builder.field("queue_size", queueSize.singles());  
     * time deltas that should not suffer from negative deltas, which are possible with  
    public ScheduledExecutorService scheduler() {
        for (ExecutorHolder holder : executors.values()) {
                if (rejectedExecutionHandler instanceof XRejectedExecutionHandler xRejectedExecutionHandler) {
            Names.FETCH_SHARD_STARTED,
        }
        return TimeValue.nsecToMSec(relativeTimeInNanos());  
        builders.put(Names.TRANSLOG_RECOVERY, new FixedExecutorBuilder(settings, Names.TRANSLOG_RECOVERY, allocatedProcessors, -1));
                    new ThreadPoolStats.Stats.Builder().name(name)
        }  
                1,
    public ExecutorService executor(String name) {  
            .filter(holder -> holder.info.getName().equals("same") == false)
            // queue, largest, and rejected have no referent; only the task flow counters are meaningful.
            Names.REMOTE_DOWNLOAD,
            if (executor.executor() != DIRECT_EXECUTOR) {
                        .rejected(0)
     * Get the {@link ExecutorService} with the given name. This executor service's
            new FixedExecutorBuilder(settings, Names.REMOTE_STATE_CHECKSUM, ClusterStateChecksum.COMPONENT_SIZE, 1000)
    }
    Fixed/ResizableQueue can provide only size
     * Returns a value of milliseconds that may be used for relative time calculations.  
                throw new IllegalArgumentException("builder with name [" + builder.name() + "] already exists");
        SCALING("scaling"),  
    public static final Setting<Settings> CLUSTER_THREAD_POOL_SIZE_SETTING = Setting.groupSetting(  
            builder.startObject(name);
                                + in.getVersion()  
     * the service is <code>null</code> this method will return <code>false</code>.  
        for (Map.Entry<String, Settings> entry : tpGroups.entrySet()) {  
import org.opensearch.core.xcontent.XContentBuilder;
     * Schedules a one-shot command to run after a given delay. The command is run in the context of the calling thread.  
    }  
        for (ExecutorHolder executor : executors.values()) {  
                        "illegal thread_pool config : " + tpGroup.keySet() + " should only have " + scalingThreadPoolKeys
            + reason
 * GitHub history for details.
                if (scalingThreadPoolKeys.containsAll(tpGroup.keySet()) == false) {
            builder.endObject();  
    private final Map<String, ExecutorBuilder> builders;  
        Setting.Property.NodeScope  
     * than value, otherwise value
        @Nullable  
                // VIRTUAL introduced in 3.8, convert to SCALING for bwc
        public void writeTo(StreamOutput out) throws IOException {  
        );
            out.writeOptionalWriteable(queueSize);  
        for (Map.Entry<String, Settings> entry : tpGroups.entrySet()) {
 * SPDX-License-Identifier: Apache-2.0
            out.writeInt(max);
    public void scheduleUnlessShuttingDown(TimeValue delay, String executor, Runnable command) {  
            if (awaitTermination(service, timeout, timeUnit)) return true;
                        "could not schedule execution of [{}] after [{}] on [{}] as executor is shut down",
            }
        command = threadContext.preserveContext(command);
        assert stackTraceElements[0].getMethodName().equals("getStackTrace") : stackTraceElements[0];
                                + "' for version "
            + "]";  
        builders.put(Names.SNAPSHOT, new ScalingExecutorBuilder(Names.SNAPSHOT, 1, halfProcMaxAt5, TimeValue.timeValueMinutes(5)));
    Scaling threadpool can provide only max and core
            if (holder.info.type == ThreadPoolType.SCALING) {
import org.opensearch.common.unit.SizeValue;
    static class CachedTimeThread extends Thread {
            }  
    public Collection<ExecutorBuilder> builders() {
     * The threadpool names.
     * @opensearch.api
        public static final String SYSTEM_WRITE = "system_write";
    public ScheduledCancellable schedule(Runnable command, TimeValue delay, String executor) {
            );
            Names.SNAPSHOT_DELETION,  
/*
     * Returns <code>true</code> if the given pool was terminated successfully. If the termination timed out,
     *
    public ExecutorService generic() {  
        }  
                int size = tpGroup.getAsInt("size", threadPoolExecutor.getMaximumPoolSize());
@PublicApi(since = "1.0.0")
        map.put(Names.REMOTE_STATE_CHECKSUM, ThreadPoolType.FIXED);
                    } else {
    public long relativeTimeInMillis() {
import org.opensearch.common.Nullable;
            if (builders.containsKey(builder.name())) {  
import org.opensearch.Version;
            if (executor.executor() != DIRECT_EXECUTOR) {
                        delay,  
        builders.put(Names.SYSTEM_READ, new FixedExecutorBuilder(settings, Names.SYSTEM_READ, halfProcMaxAt5, 2000, false));
    public void registerClusterSettingsListeners(ClusterSettings clusterSettings) {
import java.util.Collection;  
    /**  
    }  
        private final SizeValue queueSize;
                    rejected = xRejectedExecutionHandler.rejected();  
 *    http://www.apache.org/licenses/LICENSE-2.0
        public static final String FLUSH = "flush";  
            return runnable.equals(obj);
            Names.STREAM_SEARCH,
     * @throws OpenSearchRejectedExecutionException if the task cannot be scheduled for execution
        this(settings, null, customBuilders);
                out.writeString(ThreadPoolType.FIXED.getType());
        builders.put(Names.FLUSH, new ScalingExecutorBuilder(Names.FLUSH, 1, halfProcMaxAt5, TimeValue.timeValueMinutes(5)));
        return (allocatedProcessors + 1) / 2;  
        public Info(String name, ThreadPoolType type, int size) {
            final ExecutorHolder executorHolder = entry.getValue().build(executorSettings, threadContext);  
                runnable.run();  
        map.put(Names.MERGE, ThreadPoolType.SCALING);
     * timestamp, see {@link #absoluteTimeInMillis()}.
            final String name = holder.info.getName();  
        }
    public static boolean terminate(ExecutorService service, long timeout, TimeUnit timeUnit) {
            if (executors.containsKey(tpName) == false) {
        assert stackTraceElements[1].getMethodName().equals("assertCurrentMethodIsNotCalledRecursively") : stackTraceElements[1];
    }
                        );  
    class ThreadedRunnable implements Runnable {
        private static final Map<String, ThreadPoolType> TYPE_MAP;
                out.writeString(ThreadPoolType.SCALING.getType());
            return executor;
            // the direct executor has no threads of its own and never terminates
        ExecutorService executor() {
            String tpName = entry.getKey();  
        final AtomicReference<RunnableTaskExecutionListener> runnableTaskListener,  
     * the service is <code>null</code> this method will return <code>false</code>.
    public static class Info implements Writeable, ToXContentFragment {  
                if (core < 1 || max < 1) {  
        }
    private final Map<String, ExecutorHolder> executors;
        FIXED("fixed"),
     * @param command  the command to run
        @Override
            OpenSearchThreadPoolExecutor executor = (OpenSearchThreadPoolExecutor) holder.executor;  
            queueSize = in.readOptionalWriteable(SizeValue::new);
        final Map<String, ExecutorHolder> executors = new HashMap<>();  
        map.put(Names.REMOTE_STATE_READ, ThreadPoolType.FIXED);
            try {
        );
            new ScalingExecutorBuilder(Names.FETCH_SHARD_STARTED, 1, 2 * allocatedProcessors, TimeValue.timeValueMinutes(5))
 * The OpenSearch Contributors require contributions made to  
            if (e.isExecutorShutdown()) {
            OpenSearchThreadPoolExecutor threadPoolExecutor = (OpenSearchThreadPoolExecutor) holder.executor;  
        if (!Names.SAME.equals(executor)) {  
                    .rejected(rejected)
    static int boundedBy(int value, int min, int max) {  
                active = threadPoolExecutor.getActiveCount();
        @Deprecated  
                        throw new IllegalArgumentException(
            if (service.awaitTermination(timeout, timeUnit)) {
        stopCachedTimeThread();
            } else {  
                    // Only fallback for older versions
        } catch (OpenSearchRejectedExecutionException e) {  
            // Leverage try-with-resources to close the threadpool
                    builder.field("queue_size", -1);
                continue;  
        map.put(Names.FETCH_SHARD_STARTED, ThreadPoolType.SCALING);  
                } else {
                 This ensures that core pool is always smaller than max pool size .
            if (typeStr.equalsIgnoreCase("fixed_auto_queue_size")) {
            // Executor types that do not expose pool metrics fall through with the -1 "unavailable" defaults set above.
import org.opensearch.common.util.concurrent.XRejectedExecutionHandler;
        List<ThreadPoolStats.Stats> stats = new ArrayList<>();
    static int twiceAllocatedProcessors(final int allocatedProcessors) {
                );
    }
            if (executor.executor() != DIRECT_EXECUTOR) {
            // Opensearch on or after 3.0.0 version doesn't know about "fixed_auto_queue_size" thread pool. Convert it to RESIZABLE.  
                } catch (IllegalArgumentException e) {  
        } catch (final InterruptedException e) {
                return true;
    public static class Names {
                new ThreadPoolStats.Stats.Builder().name(name)
                        .build()
import java.util.concurrent.ScheduledThreadPoolExecutor;
        public static final String SEARCH_THROTTLED = "search_throttled";
     * @opensearch.internal  
        THREAD_POOL_TYPES = Collections.unmodifiableMap(map);
            service.shutdown();  
    public static final Map<String, ThreadPoolType> THREAD_POOL_TYPES;  
     */
            return runnable.hashCode();  
                        "illegal thread_pool config : " + tpGroup.keySet() + " should only have " + fixedThreadPoolKeys
    }  
            if (threadPoolType == null) {
            pool.shutdownNow();
        }  
                    ),
 * Modifications Copyright OpenSearch Contributors. See
                try {
    }
        public static final String FORCE_MERGE = "force_merge";
                runnableTaskListener
    public Info info(String name) {  
     */
                int max = tpGroup.getAsInt("max", executor.getMaximumPoolSize());
        assert Node.NODE_NAME_SETTING.exists(settings);  
            long waitTimeNanos = -1;
            }  
                return true;
    /**
        CachedTimeThread(String name, long interval) {
            }  
}
            }  
            if ("same".equals(name)) {
        private final TimeValue keepAlive;  
            int parallelism = -1;  
            return this.max;
    private void validateSetting(Settings tpSettings) {  
        if (holder == null) {
        final int snapshotDeletionPoolMax = boundedBy(4 * allocatedProcessors, 64, 256);
     *                 command completes.  
        public TimeValue getKeepAlive() {
        cluster.threadpool.snapshot.core : "5",  
        cachedTimeThread.running = false;
        builders.put(
     * timestamp, see {@link #absoluteTimeInMillis()}.
                e
import org.apache.logging.log4j.Logger;
     * @param name the name of the executor service to obtain  
            Names.REMOTE_RECOVERY,
            Names.INDEX_SEARCHER,  
        public static final String SAME = "same";  
        }
                            executor
            if (logger.isDebugEnabled()) {
            // the direct executor runs tasks on the calling thread and does not support being shut down  
        map.put(Names.INDEX_SEARCHER, ThreadPoolType.RESIZABLE);  
     * {@link Executor#execute(Runnable)} method will run the {@link Runnable} it is given in the  
                            "could not schedule execution of [{}] on [{}] as executor is shut down",  
        builders.put(  
        }  
        if (service != null) {
    );
                    executor.setCorePoolSize(core);  
        builders.put(Names.ANALYZE, new FixedExecutorBuilder(settings, Names.ANALYZE, 1, 16));
    For example valid settings would be for scaling and fixed thead pool
        @Nullable
                throw e;  
        public final Info info;
        // TODO: configure the appropriate size and explore use of virtual threads  
            return type;
     * @throws IllegalArgumentException if no executor service with the specified name exists
        return boundedBy((allocatedProcessors + 1) / 2, 1, 10);
        public static final String TRANSLOG_SYNC = "translog_sync";  
            for (ThreadPoolType threadPoolType : ThreadPoolType.values()) {  
 */  
    }
                settings,
                } else if (core > max) {
            } else if (type == ThreadPoolType.FORK_JOIN) {
        }
     * give better performance at the cost of lower precision.
        public String getType() {  
                        command,
        private final ExecutorService executor;
        return boundedBy(2 * allocatedProcessors, 2, Integer.MAX_VALUE);  
        return boundedBy((allocatedProcessors + 1) / 2, 1, 5);
            return this.min;  
        );
    @PublicApi(since = "1.0.0")
            new ScalingExecutorBuilder(  
        // the assumption here is that the listeners should be very lightweight on the listeners side
                || executor == DIRECT_EXECUTOR  
import java.util.concurrent.ExecutorService;
     *
            new ScalingExecutorBuilder(Names.REMOTE_REFRESH_RETRY, 1, halfProc, TimeValue.timeValueMinutes(5))
            this.type = type;
                /*
            }  
        final List<Info> infos = executors.values()
    }
    class LoggingRunnable implements Runnable {
            setDaemon(true);
package org.opensearch.threadpool;
        volatile long relativeNanos;
                    throw new IllegalArgumentException(
        }
            out.writeOptionalTimeValue(keepAlive);
         * If {@link ThreadPool#ESTIMATED_TIME_INTERVAL_SETTING} is set to 0
            new ResizableExecutorBuilder(settings, Names.SEARCH, searchThreadPoolSize(allocatedProcessors), 1000, runnableTaskListener)
        if (pool != null) {  
    }
    }  
            if (executors.containsKey(executorHolder.info.getName())) {
import org.opensearch.core.xcontent.ToXContentFragment;
            }
    @Override  
        boolean result = scheduler.awaitTermination(timeout, unit);
        return Math.min(max, Math.max(min, value));
                                + typeStr
/*  
        builders.put(
        public int getMin() {
import java.util.HashSet;  
    }
        public int getMax() {  
            // the direct executor runs tasks on the calling thread and does not support being shut down
    public ThreadPool(final Settings settings, final ExecutorBuilder<?>... customBuilders) {  
        }
 */  
                throw e;  
        builders.put(Names.GENERIC, new ScalingExecutorBuilder(Names.GENERIC, 4, genericThreadPoolMax, TimeValue.timeValueSeconds(30)));  
        public boolean equals(Object obj) {
                threads = threadPoolExecutor.getPoolSize();  
     *
                );
    }
    @PublicApi(since = "1.0.0")
    public ThreadPool(
                    + " is called recursively";  
        return new ThreadPoolStats(stats);
                }
 */
import org.opensearch.gateway.remote.ClusterStateChecksum;  
        map.put(Names.SNAPSHOT_DELETION, ThreadPoolType.SCALING);  
        public String toString() {  
                Names.INDEX_SEARCHER,  
                if (e.isExecutorShutdown()) {  
        }
        map.put(Names.REMOTE_PURGE, ThreadPoolType.SCALING);
        final StackTraceElement testingMethod = stackTraceElements[2];  
    public static Setting<TimeValue> ESTIMATED_TIME_INTERVAL_SETTING = Setting.timeSetting(
        return this.scheduler;
        }  
     */
            int active = -1;
     */
     * @param min   the minimum acceptable value
     * Warning: this {@linkplain ExecutorService} might not throw {@link RejectedExecutionException}  
     * @opensearch.api  
            } else if (type == ThreadPoolType.VIRTUAL) {
        ThreadPoolType(String type) {
        "thread_pool.estimated_time_interval",  
     * if you submit a task while it shutdown. It will instead silently queue it and not run it.
                int size = tpGroup.getAsInt("size", executor.getMaximumPoolSize());  
        }  
    static Set<String> scalingThreadPoolKeys = new HashSet<>(Arrays.asList("max", "core"));
    /**
                }
            pool.shutdown();
    /**  
        public static final String REMOTE_REFRESH_RETRY = "remote_refresh_retry";
         */
            this.absoluteMillis = System.currentTimeMillis();  
        builders.put(
                    executor.setCorePoolSize(size);
                if (size < executor.getCorePoolSize()) {
        builders.put(
        builders.put(Names.LISTENER, new FixedExecutorBuilder(settings, Names.LISTENER, halfProcMaxAt10, -1, true));  
     * A thread to cache millisecond time values from
                 Other wise IllegalArgumentException will be thrown from ThreadPoolExecutor
            return runnable.equals(obj);
    }
            // no need to have info on "same" thread pool
import org.opensearch.core.common.io.stream.StreamInput;
                stats.add(  
    }
        @Override  
     * {@link Executor#execute(Runnable)} method will run the {@link Runnable} it is given in the  
                    builder.field("keep_alive", keepAlive.toString());
            }
        );
 * this work for additional information regarding copyright
                TimeValue.timeValueMinutes(5)
                            "Unknown ThreadPoolType '"  
        final int halfProcMaxAt5 = halfAllocatedProcessorsMaxFive(allocatedProcessors);
            Thread.currentThread().interrupt();
                twiceAllocatedProcessors(allocatedProcessors),
import java.util.Collections;
     * @param delay    delay before the task executes  
                        .largest(0)  
        private final String name;
     * timestamp, see {@link #absoluteTimeInMillis()}.  
            }
                    builder.field("queue_size", -1);
        }
    public static boolean assertCurrentMethodIsNotCalledRecursively() {
    public ThreadPoolInfo info() {
            this.runnable = runnable;  
     * if you submit a task while it shutdown. It will instead silently queue it and not run it.
 *
        }  
        @Override  
        private final String type;
                    .completed(completed)
        final Map<String, ExecutorBuilder> builders = new HashMap<>();
                builder.field("max", max);
                        e
            this.runnable = runnable;  
        }  
        }
    public ThreadPoolStats stats() {  
            return threadPoolType;
        public static final String SNAPSHOT = "snapshot";  
 * Unless required by applicable law or agreed to in writing,
        final int genericThreadPoolMax = boundedBy(4 * allocatedProcessors, 128, 512);
    }
    public Cancellable scheduleWithFixedDelay(Runnable command, TimeValue interval, String executor) {  
                    );  
            if (0 < interval) {  
                    resolvedType = ThreadPoolType.fromType(typeStr);
                int max = tpGroup.getAsInt("max", threadPoolExecutor.getMaximumPoolSize());
        @Override
     * that require the highest precision possible. Performance critical code must use  
                    + testingMethod.getMethodName()
                completed = virtualExecutor.getCompletedTaskCount();
                twiceAllocatedProcessors(allocatedProcessors),  
                assert max != -1;
        map.put(Names.SYSTEM_WRITE, ThreadPoolType.FIXED);
                    if (in.getVersion().onOrBefore(Version.V_3_3_0)) { // ForkJoinPool Introduced in 3.4.0 onwards
            this.queueSize = queueSize;
        return false;
                absoluteMillis = System.currentTimeMillis();
                        executor
        RESIZABLE("resizable"),
            .map(holder -> holder.info)
     */  
            )  
                return relativeNanos;
            logger.debug("created thread pool: {}", entry.getValue().formatInfo(executorHolder.info));
            Thread.currentThread().interrupt();
                    .threads(threads)
            Names.REMOTE_STATE_CHECKSUM,
        TimeValue.timeValueMillis(200),
     * <p>
        public static final String GENERIC = "generic";
            } catch (OpenSearchRejectedExecutionException e) {
    /**
        DIRECT("direct"),  
        }
    }  
        this.builders = Collections.unmodifiableMap(builders);
            schedule(command, delay, executor);
        map.put(Names.REMOTE_REFRESH_RETRY, ThreadPoolType.SCALING);
            return awaitTermination(service, timeout, timeUnit);  
            return this.name;
        /** Thread pool name for remote downloads in tiered storage. */
        }
                TimeValue.timeValueMinutes(5)
    }
                try {
 * compatible open source license.
            this.relativeNanos = System.nanoTime();
                // to avoid serialization/de-serization issue between nodes with different OpenSearch version
        @Override
        long relativeTimeInNanos() {
        TimeValue estimatedTimeInterval = ESTIMATED_TIME_INTERVAL_SETTING.get(settings);  
                    executor.setMaximumPoolSize(size);  
import org.opensearch.common.util.concurrent.VirtualThreadPerTaskExecutorService;  
 * ownership. Elasticsearch licenses this file to you under  
        final ExecutorBuilder<?>... customBuilders
        private final Executor executor;  
            }  
        this.scheduler = Scheduler.initScheduler(settings);
        builders.put(
        }
                    .queue(queue)  
        public String toString() {
                throw new IllegalStateException("duplicate executors with name [" + executorHolder.info.getName() + "] registered");
                        .parallelism(holder.info.getMax())  
    public static boolean terminate(ThreadPool pool, long timeout, TimeUnit timeUnit) {
        for (final ExecutorBuilder<?> builder : customBuilders) {
        }
     * The thread pool information.
    }
        }
                }
        return threadPoolInfo;  
                }
        map.put(Names.FORCE_MERGE, ThreadPoolType.FIXED);
     * the task is canceled before it was added to its target thread pool. Once the task has been added to its target thread pool
            } else {
 */  
                builder.field("parallelism", max);  
    /**
        map.put(Names.WARMER, ThreadPoolType.SCALING);
        return false;
                                + ". "
        map.put(Names.SEARCH_THROTTLED, ThreadPoolType.RESIZABLE);
            return "[threaded] " + runnable.toString();
            ExecutorHolder holder = executors.get(tpName);
            } else if (holder.executor() instanceof OpenSearchThreadPoolExecutor threadPoolExecutor) {
            // neither a ForkJoinPool nor a virtual thread-per-task pool can be resized
import org.opensearch.common.annotation.PublicApi;  
            if (holder.info.type == ThreadPoolType.FORK_JOIN) {
                throw new IllegalArgumentException("illegal thread_pool name : " + tpName);
        );  
            }
import java.util.ArrayList;
        map.put(Names.FLUSH, ThreadPoolType.SCALING);
        return true;
 * KIND, either express or implied.  See the License for the
        public static final String WARMER = "warmer";
            } else {  
         * whenever called. Typically used for testing.  
                }
                settings,
     * <p>
                waitTimeNanos = threadPoolExecutor.getPoolWaitTimeNanos();
            + Thread.currentThread()  
                    executor.setCorePoolSize(size);  
import java.util.concurrent.RejectedExecutionException;
        scheduler.shutdownNow();
     * The threadpool type.  
        this.cachedTimeThread.start();
                if (fixedThreadPoolKeys.containsAll(tpGroup.keySet()) == false) {  
            } else {
        cluster.threadpool.snapshot.max : "5",
        cachedTimeThread.join(unit.toMillis(timeout));  
            this.name = name;  
        threadContext = new ThreadContext(settings);
                 If we are increasing ,max pool size has to be increased first  
            Names.FORCE_MERGE,
        map.put(Names.TRANSLOG_SYNC, ThreadPoolType.FIXED);  
    }
            } else {  
                 If we are decreasing, core pool size has to be decreased first.
                || executor instanceof ForkJoinPool
    }
                    executor.setMaximumPoolSize(max);
import org.apache.logging.log4j.message.ParameterizedMessage;  
        assert Thread.currentThread().getName().contains("scheduler") == false : "Expected current thread ["
        public static final String SYSTEM_READ = "system_read";  
            this.keepAlive = keepAlive;
import java.util.concurrent.ScheduledExecutorService;  
     */
         * whenever called. Typically used for testing.  
     * @param value the value to constrain  
        }  
        public String getName() {  
        }
    public void shutdown() {  
                    );
     * either {@link #relativeTimeInNanos()} or {@link #relativeTimeInMillis()} which
        Setting.Property.NodeScope  
                // an unbounded virtual thread-per-task pool has no size, keep alive, or queue to report
                completed = threadPoolExecutor.getCompletedTaskCount();
    }
        public boolean equals(Object obj) {  
            stats.add(  
            )
            }
        @Override
    }
                typeMap.put(threadPoolType.getType(), threadPoolType);
                runnableTaskListener  
                if (size < 1) {  
        map.put(Names.GET, ThreadPoolType.FIXED);
                }
                twiceAllocatedProcessors(allocatedProcessors),  
 *  
            (e) -> logger.warn(  
        }  
    }  
                throw new IllegalArgumentException("no ThreadPoolType for " + type);  
        public static final String SNAPSHOT_DELETION = "snapshot_deletion";
    public static boolean assertNotScheduleThread(String reason) {
    }
    ) {
        public Info(String name, ThreadPoolType type, int min, int max, @Nullable TimeValue keepAlive, @Nullable SizeValue queueSize) {
            ThreadPoolType threadPoolType = TYPE_MAP.get(type);
        "cluster.thread_pool.",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    throw new IllegalArgumentException("illegal value for [cluster.thread_pool." + tpName + "], has to be positive value");
            if (type == ThreadPoolType.SCALING) {
            new ScalingExecutorBuilder(Names.TRANSLOG_TRANSFER, 1, halfProc, TimeValue.timeValueMinutes(5))
        final int halfProc = halfAllocatedProcessors(allocatedProcessors);
     * Returns <code>true</code> if the given service was terminated successfully. If the termination timed out,
        public ThreadPoolType getThreadPoolType() {
                executor.execute(runnable);
                    new ParameterizedMessage(  
         * If {@link ThreadPool#ESTIMATED_TIME_INTERVAL_SETTING} is set to 0
            this.max = max;  
        builders.put(  
    @Override
            )  
    public void setThreadPool(Settings tpSettings) {
            TYPE_MAP = Collections.unmodifiableMap(typeMap);  
            } else if (type == ThreadPoolType.VIRTUAL && out.getVersion().before(Version.V_3_8_0)) {  
    }
 * The OpenSearch threadpool class  
                executor.executor().shutdownNow();
            // A virtual thread-per-task pool has neither a bounded set of worker threads nor a queue, so threads,  
import static java.util.Collections.unmodifiableMap;  
                    .parallelism(parallelism)  
    }
    }
                    );
import java.util.concurrent.RejectedExecutionHandler;
                    .active(active)
            }
        static {
            }
        map.put(Names.WRITE, ThreadPoolType.FIXED);
            .collect(Collectors.toList());  
            this.min = min;
     */
         * a cached version of {@link System#currentTimeMillis()}.
            }
            keepAlive = in.readOptionalTimeValue();
        final int halfProcMaxAt10 = halfAllocatedProcessorsMaxTen(allocatedProcessors);  
        public Info(String name, ThreadPoolType type) {  
     */  
                        new ParameterizedMessage(
 * under the License.  
            return this.queueSize;
                // OpenSearch on older version doesn't know about "resizable" thread pool. Convert RESIZABLE to FIXED  
            new ScalingExecutorBuilder(  
                    Thread.sleep(interval);  
        }
        if (holder == null) {
 * the Apache License, Version 2.0 (the "License"); you may
        return true;
 * @opensearch.api
            command = new ThreadedRunnable(command, executor(executor));
        Map<String, Settings> tpGroups = tpSettings.getAsGroups();
                    throw new IllegalArgumentException(  
        public static final String TRANSLOG_TRANSFER = "translog_transfer";
            }
            super(name);  
import java.util.Set;  
        cluster.threadpool.get.size : "2",
     * @param executor the name of the thread pool on which to execute this task. SAME means "execute on the scheduler thread" which changes
 * not use this file except in compliance with the License.
            ThreadPoolType resolvedType;
                || stackTraceElements[i].getMethodName().equals(testingMethod.getMethodName()) == false : testingMethod.getClassName()  
 * You may obtain a copy of the License at  
            .stream()  
            }
        public void run() {
                    .waitTimeNanos(waitTimeNanos)
            this.executor = executor;  
 *
        return new ReschedulingRunnable(command, interval, executor, this, (e) -> {
        map.put(Names.SAME, ThreadPoolType.DIRECT);
            Settings tpGroup = entry.getValue();
                // OpenSearch on older version doesn't know about "fork_join" thread pool. Convert FORK_JOIN to FIXED
    static class ExecutorHolder {  
                executor.executor().shutdown();  
        }
        // no queue as this means clients will need to handle rejections on listener queue even if the operation succeeded
            if (holder.info.type == ThreadPoolType.SCALING) {
     *                 the meaning of the ScheduledFuture returned by this method. In that case the ScheduledFuture will complete only when the
        return threadContext;
    /**
        builders.put(
            assert stackTraceElements[i].getClassName().equals(testingMethod.getClassName()) == false
            final ExecutorBuilder.ExecutorSettings executorSettings = entry.getValue().getSettings(settings);
            // virtual thread-per-task pool has no size or queue to configure in the first place.
                logger.debug(
        builders.put(Names.WARMER, new ScalingExecutorBuilder(Names.WARMER, 1, halfProcMaxAt5, TimeValue.timeValueMinutes(5)));  
            out.writeInt(min);  
    }  
        Setting.Property.Dynamic,
            Names.TRANSLOG_TRANSFER,
                continue;  
import java.util.stream.Collectors;
        public Info(StreamInput in) throws IOException {
        public static final String REMOTE_STATE_CHECKSUM = "remote_state_checksum";
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
        public static final String INDEX_SEARCHER = "index_searcher";
            }
        ExecutorHolder holder = executors.get(name);
    private final CachedTimeThread cachedTimeThread;  
        HashMap<String, ThreadPoolType> map = new HashMap<>();  
        private final int min;
        public static final String MANAGEMENT = "management";
    );
            ExecutorHolder holder = executors.get(tpName);  
                continue;  
        public static final String FETCH_SHARD_STORE = "fetch_shard_store";
import java.util.Map;
        public static final String REMOTE_PURGE = "remote_purge";
     */
        }
                                + "This may be a protocol or node version mismatch."
        for (ExecutorHolder executor : executors.values()) {
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
        );  
import org.opensearch.common.settings.Setting;
    static int oneEighthAllocatedProcessors(final int allocatedProcessors) {
        LoggingRunnable(Runnable runnable) {
import org.apache.logging.log4j.LogManager;
                return absoluteMillis;
     * @return min if value is less than min, max if value is greater  
        public void run() {
    }  
        @Override
        }
            + "] to not be the scheduler thread. Reason: ["
            if (awaitTermination(pool, timeout, timeUnit)) {  
        VIRTUAL("virtual");
            } else {
            } catch (Exception e) {
                } else {
    }
            executors.put(entry.getKey(), executorHolder);
            }
                    }
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            // Skip validation for pool types that do not support setting updates. ForkJoinPool is not resizable, and a  
        @Override
            Settings tpGroup = entry.getValue();
    static int halfAllocatedProcessorsMaxTen(final int allocatedProcessors) {
 * this file be licensed under the Apache-2.0 license or a
            }
     * @param max   the maximum acceptable value
        public static final String MERGE = "merge";  
        }
     * Warning: this {@linkplain ExecutorService} will not throw {@link RejectedExecutionException}  
    /**  
                    executor.setCorePoolSize(core);
                        .completed(0)
                }
        @Override  
        final Settings settings,
        );
            service.shutdownNow();
            return builder;
            }
    private final ThreadPoolInfo threadPoolInfo;
                    + "#"
        }
        public static final String REFRESH = "refresh";
            int queue = -1;  
        builders.put(Names.MERGE, new ScalingExecutorBuilder(Names.MERGE, 1, allocatedProcessors, TimeValue.timeValueMinutes(5)));
     * Get the generic {@link ExecutorService}. This executor service
        builders.put(Names.WRITE, new FixedExecutorBuilder(settings, Names.WRITE, allocatedProcessors, 10000));
                        .waitTimeNanos(-1)
        return ((allocatedProcessors * 3) / 2) + 1;
         * then the cache is disabled and the method calls {@link System#currentTimeMillis()}
                }
        public int hashCode() {
            this.type = type;
        try {
public class ThreadPool implements ReportingService<ThreadPoolInfo>, Scheduler {
            // last resort  
     * Returns a value of nanoseconds that may be used for relative time calculations.
            this.executor = executor;
 * software distributed under the License is distributed on an
     * {@link System#nanoTime()} and {@link System#currentTimeMillis()}.  
        return Collections.unmodifiableCollection(builders.values());
            try {  
                }
     */  
        @Override
    }  
    /**
                throw new IllegalArgumentException("illegal thread_pool name : " + tpName);
        builders.put(Names.TRANSLOG_SYNC, new FixedExecutorBuilder(settings, Names.TRANSLOG_SYNC, allocatedProcessors * 4, 10000));
    }
        map.put(Names.REMOTE_DOWNLOAD, ThreadPoolType.SCALING);
            if (holder.info.type == ThreadPoolType.FORK_JOIN || holder.info.type == ThreadPoolType.VIRTUAL) {
            return System.currentTimeMillis();  
import org.opensearch.common.settings.Settings;  
            throw new IllegalArgumentException("no executor service found for [" + name + "]");  
    static int halfAllocatedProcessorsMaxFive(final int allocatedProcessors) {  
    static int halfAllocatedProcessors(int allocatedProcessors) {
            int largest = -1;  
        builders.put(
         * Return the current epoch time, used to find absolute time. This is
            builders.put(builder.name(), builder);  
     */
                        .queue(0)  
                int core = tpGroup.getAsInt("core", executor.getCorePoolSize());  
        return executor(Names.GENERIC);
        TimeValue.ZERO,
        }
        public static final String REMOTE_RECOVERY = "remote_recovery";  
import java.util.Arrays;
import org.opensearch.core.common.io.stream.Writeable;
                    return;  
            final String typeStr = in.readString();
            String tpName = entry.getKey();
            if (0 < interval) {  
        FORK_JOIN("fork_join"),
    /**
                () -> new ParameterizedMessage("failed to run scheduled task [{}] on thread pool [{}]", command, executor),
     * Returns the value of milliseconds since UNIX epoch.  
        try {  
            int threads = -1;
     * This method should only be used for calculating time deltas. For an epoch based  
        }
        }
    /**  
    }  
                Names.STREAM_SEARCH,
            this(name, type, size, size, null, null);
     *
        this.executors = unmodifiableMap(executors);  
    }
        );
import java.io.IOException;  
        try {
import org.opensearch.common.settings.ClusterSettings;
