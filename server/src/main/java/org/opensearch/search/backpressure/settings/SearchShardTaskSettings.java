        private static final double HEAP_PERCENT_THRESHOLD = 0.005;
    public double getNativeMemoryPercentThreshold() {
     * Defines the heap usage threshold (in percentage) for the sum of heap usages across all search shard tasks
        notifyListeners(listener -> listener.onRateChanged(cancellationRate));
        1.0,
    }
    public double getCancellationRateNanos() {
        // inert until an operator or backend plugin opts in by setting a non-zero threshold.
        SearchBackpressureSettings.SETTING_CANCELLATION_RATIO,
        Setting.Property.Dynamic,
    );
 * SPDX-License-Identifier: Apache-2.0
        private static final double NATIVE_MEMORY_PERCENT_THRESHOLD = 0.05;
     */
    }
        return TimeUnit.MILLISECONDS.toNanos(cpuTimeMillisThreshold);
            if (value <= 0.0) {
    }
    }
        "search_backpressure.search_shard_task.cancellation_ratio",
        Setting.Property.NodeScope
    }
                throw new IllegalArgumentException("search_backpressure.search_shard_task.cancellation_rate must be > 0");
        this.heapPercentThreshold = heapPercentThreshold;
    public void addListener(CancellationSettingsListener listener) {
        "search_backpressure.search_shard_task.cancellation_rate",
        clusterSettings.addSettingsUpdateConsumer(SETTING_ELAPSED_TIME_MILLIS_THRESHOLD, this::setElapsedTimeMillisThreshold);
                exceptions.add(e);
    }
                throw new IllegalArgumentException("search_backpressure.search_shard_task.cancellation_ratio must be <= 1.0");
        return totalHeapPercentThreshold;
    private void notifyListeners(Consumer<CancellationSettingsListener> consumer) {
    public static final Setting<Double> SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD = Setting.doubleSetting(
    );
     * Defines the maximum number of SearchShardTasks that can be cancelled before being rate-limited.
        "search_backpressure.search_shard_task.elapsed_time_millis_threshold",
    private volatile long cpuTimeMillisThreshold;
    public SearchShardTaskSettings(Settings settings, ClusterSettings clusterSettings) {
        return heapPercentThreshold;
            }
    /**
    }
     */
     * Defines the number of SearchShardTasks to cancel per unit time (in millis).
        List<Exception> exceptions = new ArrayList<>();
import org.opensearch.common.settings.ClusterSettings;
        totalHeapPercentThreshold = SETTING_TOTAL_HEAP_PERCENT_THRESHOLD.get(settings);
     * In other words, it is the number of tokens added to the bucket on each successful SearchShardTask completion.
    }
        clusterSettings.addSettingsUpdateConsumer(SETTING_HEAP_PERCENT_THRESHOLD, this::setHeapPercentThreshold);
    public static final Setting<Integer> SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE = Setting.intSetting(
            if (value <= 0.0) {
 */
        // The per-task threshold is a fraction of the backend-installed native memory budget,
        clusterSettings.addSettingsUpdateConsumer(SETTING_CANCELLATION_BURST, this::setCancellationBurst);
    }
    /**
        private static final double TOTAL_HEAP_PERCENT_THRESHOLD = 0.05;
                consumer.accept(listener);
     * {@link org.opensearch.search.backpressure.NativeMemoryUsageService#setBudgetSupplier}.
        private static final double HEAP_VARIANCE_THRESHOLD = 2.0;
        "search_backpressure.search_shard_task.heap_moving_average_window_size",
        value -> {
    );
 * Defines the settings related to the cancellation of SearchShardTasks.
    public double getCancellationBurst() {
        Defaults.HEAP_PERCENT_THRESHOLD,
    }
    }
        Setting.Property.NodeScope
        this.cancellationBurst = SETTING_CANCELLATION_BURST.get(settings);
        Defaults.TOTAL_HEAP_PERCENT_THRESHOLD,
/*
     * Defines the heap usage variance for an individual search shard task before it is considered for cancellation.
        Setting.Property.Dynamic,
        "search_backpressure.search_shard_task.total_heap_percent_threshold",
    }
     * {@code budget} is the value installed via
     * for cancellation. The effective per-task byte threshold is {@code budget * fraction}, where
    }
        return cancellationRate;
}
            try {
     */
        return cancellationBurst;
    private final List<CancellationSettingsListener> listeners = new ArrayList<>();
    private volatile double cancellationRate;
        },
    public void setCpuTimeMillisThreshold(long cpuTimeMillisThreshold) {
        Defaults.CPU_TIME_MILLIS_THRESHOLD,
        private static final int HEAP_MOVING_AVERAGE_WINDOW_SIZE = 100;
import java.util.ArrayList;
        Setting.Property.NodeScope
        Setting.Property.NodeScope
        this.heapMovingAverageWindowSize = heapMovingAverageWindowSize;
    );
     * A task is considered for cancellation when taskHeapUsage is greater than or equal to heapUsageMovingAverage * variance.
 *
     */
        private static final long CPU_TIME_MILLIS_THRESHOLD = 15000;
     * Defines the native-memory threshold (as a fraction of the backend-installed native-memory
        1,
            if (value > 1.0) {
     * Defines the window size to calculate the moving average of heap usage of completed search shard tasks.
        Setting.Property.Dynamic,
    }
        return TimeUnit.MILLISECONDS.toNanos(elapsedTimeMillisThreshold);
package org.opensearch.search.backpressure.settings;
    private volatile double heapVarianceThreshold;
        0.0,
        this.cancellationRate = SETTING_CANCELLATION_RATE.get(settings);
        // mirroring HEAP_PERCENT_THRESHOLD.
     * {@code 0.0} disables the check.
        private static final long ELAPSED_TIME_MILLIS_THRESHOLD = 30000;
     */
    public static final Setting<Double> SETTING_HEAP_VARIANCE_THRESHOLD = Setting.doubleSetting(
    }
        this.elapsedTimeMillisThreshold = elapsedTimeMillisThreshold;
        this.totalHeapPercentThreshold = totalHeapPercentThreshold;
    );
        // See SearchTaskSettings.Defaults for rationale: 0 / 0.0 keep the native-memory tracker
        this.cpuTimeMillisThreshold = cpuTimeMillisThreshold;
    public void setElapsedTimeMillisThreshold(long elapsedTimeMillisThreshold) {
    }
     */
        "search_backpressure.search_shard_task.heap_variance",
        return getCancellationRate() / TimeUnit.MILLISECONDS.toNanos(1); // rate per nanoseconds
     * Defines the elapsed time threshold (in millis) for an individual search shard task before it is considered for cancellation.
        return cancellationRatio;
    }
    private void setNativeMemoryPercentThreshold(double nativeMemoryPercentThreshold) {
    public long getCpuTimeNanosThreshold() {
        "search_backpressure.search_shard_task.cpu_time_millis_threshold",
    private volatile long elapsedTimeMillisThreshold;
import java.util.concurrent.TimeUnit;
    private volatile double cancellationBurst;
    public double getCancellationRate() {
    void setCancellationRate(double cancellationRate) {
        1.0,
    private volatile double nativeMemoryPercentThreshold;
        return nativeMemoryPercentThreshold;
public class SearchShardTaskSettings {
        "search_backpressure.search_shard_task.native_memory_percent_threshold",
    );
        this.heapPercentThreshold = SETTING_HEAP_PERCENT_THRESHOLD.get(settings);
import org.opensearch.search.backpressure.CancellationSettingsListener;
        Defaults.HEAP_MOVING_AVERAGE_WINDOW_SIZE,
        SearchBackpressureSettings.SETTING_CANCELLATION_RATE,
    );
import org.opensearch.ExceptionsHelper;
    private static class Defaults {
     */
        "search_backpressure.search_shard_task.cancellation_burst",
        clusterSettings.addSettingsUpdateConsumer(SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD, this::setNativeMemoryPercentThreshold);
    /**
            }
    }
     * before in-flight cancellation is applied.
 * compatible open source license.
    public double getHeapVarianceThreshold() {
/**
    public long getElapsedTimeNanosThreshold() {
    private volatile double cancellationRatio;
    public double getHeapPercentThreshold() {
        0,
    /**
        ExceptionsHelper.maybeThrowRuntimeAndSuppress(exceptions);
    /**
        return heapMovingAverageWindowSize;
import java.util.function.Consumer;
            }
        Defaults.HEAP_VARIANCE_THRESHOLD,
    }
    public static final Setting<Double> SETTING_CANCELLATION_BURST = Setting.doubleSetting(
 * this file be licensed under the Apache-2.0 license or a
    public int getHeapMovingAverageWindowSize() {
    void setCancellationBurst(double cancellationBurst) {
    public static final Setting<Double> SETTING_CANCELLATION_RATE = Setting.doubleSetting(
    }
        this.nativeMemoryPercentThreshold = SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD.get(settings);
        this.cancellationRatio = cancellationRatio;
        1.0,
            }
    }
    }
    );
        this.cancellationBurst = cancellationBurst;
        0.0,
     */
    /**
        Setting.Property.Dynamic,
        Setting.Property.Dynamic,
    public static final Setting<Double> SETTING_CANCELLATION_RATIO = Setting.doubleSetting(
        this.heapVarianceThreshold = heapVarianceThreshold;
     * Defines the CPU usage threshold (in millis) for an individual search shard task before it is considered for cancellation.
        this.nativeMemoryPercentThreshold = nativeMemoryPercentThreshold;
    public void setTotalHeapPercentThreshold(double totalHeapPercentThreshold) {
        this.cancellationRatio = SETTING_CANCELLATION_RATIO.get(settings);
        clusterSettings.addSettingsUpdateConsumer(SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE, this::setHeapMovingAverageWindowSize);
        0.0,
     * In other words, it is the number of tokens added to the bucket each millisecond.
        Setting.Property.Dynamic,
    public static final Setting<Double> SETTING_HEAP_PERCENT_THRESHOLD = Setting.doubleSetting(
    private volatile double heapPercentThreshold;
        Defaults.NATIVE_MEMORY_PERCENT_THRESHOLD,
            } catch (Exception e) {
        clusterSettings.addSettingsUpdateConsumer(SETTING_CANCELLATION_RATIO, this::setCancellationRatio);
    public static final Setting<Long> SETTING_CPU_TIME_MILLIS_THRESHOLD = Setting.longSetting(
        clusterSettings.addSettingsUpdateConsumer(SETTING_TOTAL_HEAP_PERCENT_THRESHOLD, this::setTotalHeapPercentThreshold);
        listeners.add(listener);
import java.util.List;
        for (CancellationSettingsListener listener : listeners) {
    );
        1.0,
    public static final Setting<Double> SETTING_TOTAL_HEAP_PERCENT_THRESHOLD = Setting.doubleSetting(
     * Defines the heap usage threshold (in percentage) for an individual search shard task before it is considered for cancellation.
    /**
        notifyListeners(listener -> listener.onBurstChanged(cancellationBurst));
    }
        Setting.Property.Dynamic,
import org.opensearch.common.settings.Settings;
    }
        Setting.Property.NodeScope
        },
        notifyListeners(listener -> listener.onRatioChanged(cancellationRatio));
    public void setHeapVarianceThreshold(double heapVarianceThreshold) {
    void setCancellationRatio(double cancellationRatio) {
    );
        0,
    public double getCancellationRatio() {
        "search_backpressure.search_shard_task.heap_percent_threshold",
        this.cancellationRate = cancellationRate;
        Setting.Property.NodeScope
    public double getTotalHeapPercentThreshold() {
    }
        clusterSettings.addSettingsUpdateConsumer(SETTING_CANCELLATION_RATE, this::setCancellationRate);
    public static final Setting<Long> SETTING_ELAPSED_TIME_MILLIS_THRESHOLD = Setting.longSetting(
import org.opensearch.common.settings.Setting;
        this.heapMovingAverageWindowSize = SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE.get(settings);
        clusterSettings.addSettingsUpdateConsumer(SETTING_HEAP_VARIANCE_THRESHOLD, this::setHeapVarianceThreshold);
     * Defines the percentage of SearchShardTasks to cancel relative to the number of successful SearchShardTasks completions.
    private volatile double totalHeapPercentThreshold;
        Setting.Property.Dynamic,
    /**
        Setting.Property.NodeScope
 * @opensearch.internal
        Setting.Property.Dynamic,
        clusterSettings.addSettingsUpdateConsumer(SETTING_CPU_TIME_MILLIS_THRESHOLD, this::setCpuTimeMillisThreshold);
        0.0,
        Setting.Property.Dynamic,
                throw new IllegalArgumentException("search_backpressure.search_shard_task.cancellation_ratio must be > 0");
        Defaults.ELAPSED_TIME_MILLIS_THRESHOLD,
    public void setHeapPercentThreshold(double heapPercentThreshold) {
        Setting.Property.NodeScope
     */
    /**
        this.heapVarianceThreshold = SETTING_HEAP_VARIANCE_THRESHOLD.get(settings);
        this.cpuTimeMillisThreshold = SETTING_CPU_TIME_MILLIS_THRESHOLD.get(settings);
     * budget, in {@code [0.0, 1.0]}) for an individual search shard task before it is considered
        }
        SearchBackpressureSettings.SETTING_CANCELLATION_BURST,
        value -> {
 *
    private volatile int heapMovingAverageWindowSize;
        Setting.Property.NodeScope
 */
     */
        this.elapsedTimeMillisThreshold = SETTING_ELAPSED_TIME_MILLIS_THRESHOLD.get(settings);
 * The OpenSearch Contributors require contributions made to
        Setting.Property.NodeScope
    /**
    public void setHeapMovingAverageWindowSize(int heapMovingAverageWindowSize) {
        return heapVarianceThreshold;
