        }
        }  
        50,
    private static final Logger logger = LogManager.getLogger(JvmGcMonitorService.class);
            ) {
    public static final Setting<TimeValue> REFRESH_INTERVAL_SETTING = Setting.timeSetting(
            void onMonitorFailure(Exception e) {
            );  
                if (collections == 0) {  
            for (int i = 0; i < currentJvmStats.getGc().getCollectors().length; i++) {  
        private final Map<String, JvmGcMonitorService.GcThreshold> gcThresholds;
                monitorGc();
            this.gcThresholds = Objects.requireNonNull(gcThresholds);  
        }  
                        new SlowGcEvent(  
            return JvmStats.jvmStats();
            );  
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
                }
import java.util.function.BiFunction;
                } else if (avgCollectionTime > gcThreshold.infoThreshold) {  
            seq++;
                + ", debugThreshold="
                if (avgCollectionTime > gcThreshold.warnThreshold) {
 * the Apache License, Version 2.0 (the "License"); you may
            case WARN:
        0,
            }
    protected void doStart() {
                    prevPool = pool;
                            JvmInfo.jvmInfo().getMem().getHeapMax()
        final JvmStats currentJvmStats = slowGcEvent.currentJvmStats;  
                        totalGcCollectionCount,  
        public final long warnThreshold;
        private long lastTime = now();
    public static final Setting<Integer> GC_OVERHEAD_DEBUG_SETTING = Setting.intSetting(
                if (threshold != null) {
                        TimeValue.timeValueMillis(elapsed),  
            throw new IllegalArgumentException(message);
                // no collection has happened
import org.apache.logging.log4j.Logger;
                        totalGcCollectionTime,
        JvmMonitor(final Map<String, GcThreshold> gcThresholds, final GcOverheadThreshold gcOverheadThreshold) {
        "[gc][{}][{}][{}] duration [{}], collections [{}]/[{}], total [{}]/[{}], memory [{}]->[{}]/[{}], all_pools {}";
        public String toString() {
            );  
                this.maxHeapUsed = maxHeapUsed;  
            throw new IllegalArgumentException(
                ex
            case INFO:  
            long current = 0;  
        }  
            void onGcOverhead(final Threshold threshold, final long current, final long elapsed, final long seq) {  
 */
        switch (threshold) {  
        final long currentGcCollectionCount = slowGcEvent.collectionCount;
 * under the License.  
            @Override
                        SLOW_GC_LOG_MESSAGE,  
                    );  
                    continue;
        final TimeValue currentGcCollectionTime = slowGcEvent.collectionTime;
            GC_OVERHEAD_DEBUG_SETTING.get(settings)  
        }  
                + ", warnThreshold="
    private static String getThresholdName(String key, String level) {  
            @Override  
        abstract void onGcOverhead(Threshold threshold, long total, long elapsed, long seq);
                }
    }
                            elapsed,
            final long elapsed;
        logger.debug(  
                GC_OVERHEAD_DEBUG_SETTING.get(settings),  
    static String buildPools(JvmStats last, JvmStats current) {
                    threshold = Threshold.DEBUG;  
            this.infoThreshold = infoThreshold;
        switch (threshold) {  
                this.lastJvmStats = lastJvmStats;
                }
            this.gcOverheadThreshold.debugThreshold
            this.infoThreshold = infoThreshold;  
 */  
}
        final long seq,  
            threshold = settings.getAsTime(level, null);  
                GarbageCollector gc = currentJvmStats.getGc().getCollectors()[i];
 * GitHub history for details.
 */  
                + debugThreshold  
 *
                }  
                    logger.info(OVERHEAD_LOG_MESSAGE, seq, TimeValue.timeValueMillis(current), TimeValue.timeValueMillis(elapsed));
                final TimeValue collectionTime,  
                .append(currentPool.getUsed())
                GarbageCollector prevGc = lastJvmStats.getGc().getCollectors()[i];  
            monitorGcOverhead(currentJvmStats, elapsed);
                if (logger.isWarnEnabled()) {
        }  
            final TimeValue collectionTime;  
package org.opensearch.monitor.jvm;
        if (!enabled) {  
                        name,
                long collectionTime = gc.getCollectionTime().millis() - prevGc.getCollectionTime().millis();  
                        currentJvmStats.getMem().getHeapUsed(),  
            } else if (fraction >= gcOverheadThreshold.debugThreshold) {
 * @opensearch.internal
        final int infoThreshold;
        BiFunction<JvmStats, JvmStats, String> pools
                }
                onMonitorFailure(e);  
import org.opensearch.common.settings.Setting;
                "[%s] must be greater than [%s] [%d] but was [%d]",  
        synchronized void monitorGc() {  
                        maxHeapUsed,
            checkGcOverhead(current, elapsed, seq);  
                if (logger.isInfoEnabled()) {  
        if (!enabled) {  
                Locale.ROOT,  
    private static final String SLOW_GC_LOG_MESSAGE =  
                if (collectionTime == 0) {
        public void run() {
        final JvmMonitor.SlowGcEvent slowGcEvent,
                final GarbageCollector currentGc,
                logSlowGc(logger, threshold, seq, slowGcEvent, JvmGcMonitorService::buildPools);
            for (int i = 0; i < currentJvmStats.getGc().getCollectors().length; i++) {
    @Override
            return "GcThreshold{"  
                    continue;
    );
                break;
            DEBUG,  
            SlowGcEvent(  
            throw new IllegalArgumentException("missing gc_threshold for [" + getThresholdName(key, level) + "]");
 * this file be licensed under the Apache-2.0 license or a
        "monitor.jvm.gc.overhead.warn",  
 * You may obtain a copy of the License at  
            WARN
                if (gcThreshold == null) {  
                        name,  
                .append(prevPool == null ? "?" : prevPool.getUsed())
            JvmStats currentJvmStats = jvmStats();  
                current += gc.getCollectionTime().millis() - prevGc.getCollectionTime().millis();
        Property.NodeScope
                        currentGcCollectionTime,
            if (fraction >= gcOverheadThreshold.warnThreshold) {  
            Threshold overheadThreshold = null;
            sb.append("{[")
            final String settingValue = settings.get(level);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static String GC_COLLECTOR_PREFIX = "monitor.jvm.gc.collector.";
    }
                }  
                        totalGcCollectionCount,
        0,
        );
        }
        private long seq = 0;
import java.util.Map;
                        currentJvmStats.getMem().getHeapUsed(),
    }
                overheadThreshold = Threshold.DEBUG;
        @Override
                    break;
        try {
        final long totalGcCollectionCount = slowGcEvent.currentGc.getCollectionCount();
 * Licensed to Elasticsearch under one or more contributor  
                break;
    public JvmGcMonitorService(Settings settings, ThreadPool threadPool) {
 * SPDX-License-Identifier: Apache-2.0
                        name,
            GC_OVERHEAD_INFO_SETTING.get(settings),
        gcThresholds.putIfAbsent("default", new GcThreshold("default", 10000, 5000, 2000));
                final long elapsed,
import java.util.Locale;  
            case DEBUG:  
        }
                final JvmStats currentJvmStats,  
                + name
                .append("]}");
        void checkGcOverhead(final long current, final long elapsed, final long seq) {  
            this.interval,  
                        pools.apply(lastJvmStats, currentJvmStats)  
    }
 * Modifications Copyright OpenSearch Contributors. See
                    gcThreshold = gcThresholds.get("default");
 * not use this file except in compliance with the License.
                Locale.ROOT,
    }
        }, interval, Names.SAME);  
    static void logSlowGc(  
                GC_OVERHEAD_INFO_SETTING.get(settings),
            @Override
        final ByteSizeValue maxHeapUsed = slowGcEvent.maxHeapUsed;
                onGcOverhead(overheadThreshold, current, elapsed, seq);
                .append(currentPool.getMax())  
            return System.nanoTime();
        return threshold;  
                "[%s] must be greater than [%s] [%d] but was [%d]",
            for (JvmStats.MemoryPool pool : last.getMem()) {
                .append("] [")
import java.util.Objects;
                GC_OVERHEAD_INFO_SETTING.getKey(),  
                logger.debug("failed to monitor", e);  
                if (logger.isInfoEnabled()) {
                + "name='"
            this.gcOverheadThreshold.infoThreshold,  
        Property.NodeScope
 */  
                    logger.warn(  
            }
                            TimeValue.timeValueMillis(collectionTime),  
 * this work for additional information regarding copyright
                + ", infoThreshold="  
/*  
                .append("]->[")  
 * Unless required by applicable law or agreed to in writing,
        this.enabled = ENABLED_SETTING.get(settings);
            final long collectionCount;
    private static TimeValue getValidThreshold(Settings settings, String key, String level) {
        0,  
        final int warnThreshold;
                this.elapsed = elapsed;  
                this.collectionCount = collectionCount;
                if (logger.isDebugEnabled()) {
        long now() {
                        )
                }  
 * The OpenSearch Contributors require contributions made to  
        final long current,
    }
                    logger.debug(OVERHEAD_LOG_MESSAGE, seq, TimeValue.timeValueMillis(current), TimeValue.timeValueMillis(elapsed));
 *
        for (Map.Entry<String, Settings> entry : gcThresholdGroups.entrySet()) {
 * license agreements. See the NOTICE file distributed with
        if (GC_OVERHEAD_INFO_SETTING.get(settings) <= GC_OVERHEAD_DEBUG_SETTING.get(settings)) {  
            }  
                "failed to parse setting [" + getThresholdName(key, level) + "] with value [" + settingValue + "] as a time value",
    private final boolean enabled;
                    );
            final String message = String.format(
            return;
                long avgCollectionTime = collectionTime / collections;
        } catch (RuntimeException ex) {
        this.interval = REFRESH_INTERVAL_SETTING.get(settings);  
                break;  
                logGcOverhead(logger, threshold, current, elapsed, seq);
        Property.NodeScope  
                GarbageCollector prevGc = lastJvmStats.getGc().getCollectors()[i];
/*  
            TimeValue debug = getValidThreshold(entry.getValue(), entry.getKey(), "debug");
                        pools.apply(lastJvmStats, currentJvmStats)
                if (logger.isDebugEnabled()) {  
            this.gcOverheadThreshold.warnThreshold,
            TimeValue info = getValidThreshold(entry.getValue(), entry.getKey(), "info");
            lastJvmStats = currentJvmStats;
                this.collectionTime = collectionTime;
    private final GcOverheadThreshold gcOverheadThreshold;
                    logger.info(
        final GcOverheadThreshold gcOverheadThreshold;  
        abstract void onSlowGc(Threshold threshold, long seq, SlowGcEvent slowGcEvent);
        100,
        TimeValue.timeValueSeconds(1),
            final ByteSizeValue maxHeapUsed;
        }
        public final long infoThreshold;  
                .append(currentPool.getName())  
                        currentJvmStats.getMem().getHeapUsed(),
        }
                    threshold = Threshold.WARN;
            final int fraction = (int) ((100 * current) / (double) elapsed);
            return;
            }
            final String message = String.format(
                break;
 * Service to monitor garbage collection  
        );
        this.threadPool = threadPool;  
                        totalGcCollectionCount,
                final ByteSizeValue maxHeapUsed
            this.warnThreshold = warnThreshold;  
        scheduledFuture = threadPool.scheduleWithFixedDelay(new JvmMonitor(gcThresholds, gcOverheadThreshold) {  
        }
                    logger.warn(OVERHEAD_LOG_MESSAGE, seq, TimeValue.timeValueMillis(current), TimeValue.timeValueMillis(elapsed));  
                if (pool.getName().equals(currentPool.getName())) {  
            } catch (Exception e) {
                        totalGcCollectionTime,
    private volatile Cancellable scheduledFuture;
        GcThreshold(String name, long warnThreshold, long infoThreshold, long debugThreshold) {  
                } else if (avgCollectionTime > gcThreshold.debugThreshold) {
                        currentGcCollectionCount,  
        scheduledFuture.cancel();  
        @Override
        final void monitorSlowGc(JvmStats currentJvmStats, long elapsed) {
            case WARN:
                        currentGcCollectionTime,
        final TimeValue threshold;  
        }
            void onSlowGc(final Threshold threshold, final long seq, final SlowGcEvent slowGcEvent) {
        abstract void onMonitorFailure(Exception e);
                .append("]/[")
        public final String name;
                            lastJvmStats,
            this.enabled,
                GC_OVERHEAD_INFO_SETTING.getKey(),
            GC_OVERHEAD_WARN_SETTING.get(settings),
                        currentGcCollectionCount,
    public static final Setting<Integer> GC_OVERHEAD_INFO_SETTING = Setting.intSetting(  
        return sb.toString();  
                        seq,
            JvmStats.MemoryPool prevPool = null;
    abstract static class JvmMonitor implements Runnable {  
    @Override
        static class SlowGcEvent {
        final JvmMonitor.Threshold threshold,
        this.gcOverheadThreshold = new GcOverheadThreshold(  
                }
    ) {
    @Override  
        if (GC_OVERHEAD_WARN_SETTING.get(settings) <= GC_OVERHEAD_INFO_SETTING.get(settings)) {
            }
        gcThresholds.putIfAbsent(GcNames.YOUNG, new GcThreshold(GcNames.YOUNG, 1000, 700, 400));
            final JvmStats lastJvmStats;
        Property.NodeScope
            );
                "invalid gc_threshold [" + getThresholdName(key, level) + "] value [" + settingValue + "]: value cannot be negative"
        gcThresholds.putIfAbsent(GcNames.OLD, new GcThreshold(GcNames.OLD, 10000, 5000, 2000));  
                        currentGcCollectionTime,
        100,
import org.opensearch.threadpool.ThreadPool;
import static java.util.Collections.unmodifiableMap;  
                GarbageCollector gc = currentJvmStats.getGc().getCollectors()[i];
        }
            }
            this.debugThreshold = debugThreshold;
                        currentGcCollectionCount,
            final GarbageCollector currentGc;
    static class GcOverheadThreshold {  
                        currentGcCollectionTime,  
    public static final Setting<Settings> GC_SETTING = Setting.groupSetting(GC_COLLECTOR_PREFIX, Property.NodeScope);  
            final String settingValue = settings.get(level);
                break;
                overheadThreshold = Threshold.INFO;  
        }  
import org.opensearch.common.settings.Settings;  
    ) {  
                        currentGcCollectionTime,  
                        maxHeapUsed,  
        100,  
                        totalGcCollectionTime,  
                final JvmStats lastJvmStats,
        }
        }
 * ownership. Elasticsearch licenses this file to you under  
/*
                            currentJvmStats,  
    }  
    }
import org.opensearch.common.unit.TimeValue;
        private JvmStats lastJvmStats = jvmStats();  
            TimeValue warn = getValidThreshold(entry.getValue(), entry.getKey(), "warn");  
public class JvmGcMonitorService extends AbstractLifecycleComponent {
            this.gcOverheadThreshold = Objects.requireNonNull(gcOverheadThreshold);
        }
                }  
        JvmStats jvmStats() {  
                        seq,  
            throw new IllegalArgumentException(  
    static void logGcOverhead(
        public final long debugThreshold;
        final Logger logger,
        final JvmMonitor.Threshold threshold,
                    );
        }
            gcThresholds.put(name, new GcThreshold(name, warn.millis(), info.millis(), debug.millis()));  
        return GC_COLLECTOR_PREFIX + key + "." + level;
            String name = entry.getKey();
                        SLOW_GC_LOG_MESSAGE,
            try {  
                        currentGcCollectionTime,
            case DEBUG:
                        TimeValue.timeValueMillis(elapsed),
                        seq,
                if (logger.isWarnEnabled()) {
    }
            this.warnThreshold = warnThreshold;
    private final Map<String, GcThreshold> gcThresholds;
                long collections = gc.getCollectionCount() - prevGc.getCollectionCount();
                    );  
                GC_OVERHEAD_WARN_SETTING.get(settings)
import org.opensearch.monitor.jvm.JvmStats.GarbageCollector;  
                GC_OVERHEAD_WARN_SETTING.getKey(),
            }  
import org.opensearch.common.settings.Setting.Property;
            final JvmStats currentJvmStats;  
                this.currentJvmStats = currentJvmStats;
import org.apache.logging.log4j.LogManager;
import org.opensearch.threadpool.ThreadPool.Names;  
            monitorSlowGc(currentJvmStats, elapsed);
        10,  
            INFO,
                            gc,
                }
        }
                            collections,
    }  
                        SLOW_GC_LOG_MESSAGE,
            "enabled [{}], interval [{}], gc_threshold [{}], overhead [{}, {}, {}]",
 *
            }
    private final ThreadPool threadPool;
                this.currentGc = currentGc;  
            case INFO:
import java.util.concurrent.TimeUnit;  
            this.debugThreshold = debugThreshold;
    static class GcThreshold {  
        Map<String, GcThreshold> gcThresholds = new HashMap<>();
            this.gcThresholds,
        }
/**
 * software distributed under the License is distributed on an
        final long elapsed,  
        for (JvmStats.MemoryPool currentPool : current.getMem()) {  
    protected void doClose() {}
            final long elapsed = TimeUnit.NANOSECONDS.toMillis(currentTime - lastTime);
    protected void doStop() {
            lastTime = currentTime;
 * compatible open source license.
                    logger.debug(
                + infoThreshold
                        seq,
                        lastJvmStats.getMem().getHeapUsed(),  
 * specific language governing permissions and limitations
    );  
        TimeValue.timeValueSeconds(1),  
        StringBuilder sb = new StringBuilder();
        Map<String, Settings> gcThresholdGroups = GC_SETTING.get(settings).getAsGroups();  
        "monitor.jvm.gc.overhead.info",
        }
                + '\''  
                + '}';
                final long collectionCount,
        final void monitorGcOverhead(final JvmStats currentJvmStats, final long elapsed) {
    public static final Setting<Boolean> ENABLED_SETTING = Setting.boolSetting("monitor.jvm.gc.enabled", true, Property.NodeScope);  
            throw new IllegalArgumentException(message);  
        }
import org.opensearch.core.common.unit.ByteSizeValue;
        GcOverheadThreshold(final int warnThreshold, final int infoThreshold, final int debugThreshold) {
    }  
    private final TimeValue interval;  
            final long currentTime = now();
    public static final Setting<Integer> GC_OVERHEAD_WARN_SETTING = Setting.intSetting(
                    threshold = Threshold.INFO;
    );
                        lastJvmStats.getMem().getHeapUsed(),
        final long seq
        }
                overheadThreshold = Threshold.WARN;
        this.gcThresholds = unmodifiableMap(gcThresholds);
                    onSlowGc(  
        enum Threshold {
        "monitor.jvm.gc.refresh_interval",
            }  
 *  
                break;  
            } else if (fraction >= gcOverheadThreshold.infoThreshold) {
        if (threshold == null) {  
        25,
                }
                Threshold threshold = null;  
        final int debugThreshold;  
                GC_OVERHEAD_INFO_SETTING.get(settings)
                        TimeValue.timeValueMillis(elapsed),
                GC_OVERHEAD_DEBUG_SETTING.getKey(),
    );  
        final String name = slowGcEvent.currentGc.getName();
        final long elapsed = slowGcEvent.elapsed;  
import org.opensearch.threadpool.Scheduler.Cancellable;
                GcThreshold gcThreshold = gcThresholds.get(gc.getName());
        } else if (threshold.nanos() < 0) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
import java.util.HashMap;
        final Logger logger,  
            }
            this.name = name;
                        lastJvmStats.getMem().getHeapUsed(),
                        maxHeapUsed,
 * KIND, either express or implied.  See the License for the
        "monitor.jvm.gc.overhead.debug",
                        pools.apply(lastJvmStats, currentJvmStats)
            if (overheadThreshold != null) {
        final JvmStats lastJvmStats = slowGcEvent.lastJvmStats;
                        threshold,
    private static final String OVERHEAD_LOG_MESSAGE = "[gc][{}] overhead, spent [{}] collecting in the last [{}]";  
        final TimeValue totalGcCollectionTime = slowGcEvent.currentGc.getCollectionTime();  
                + warnThreshold
