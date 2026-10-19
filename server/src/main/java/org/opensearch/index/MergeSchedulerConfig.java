        if (hasIndexSetting) {
     **
 * <p>
    void setMaxForceMergeMBPerSec(double maxForceMergeMBPerSec) {
     * @param overrideExistingConfigs if {@code true}, applies these values to all existing
    /**
        boolean autoThrottleEnabled = (AUTO_THROTTLE_SETTING.exists(settings) == false && clusterAutoThrottleEnabledDefault != null)
        (s) -> Setting.parseInt(s, 1, "index.merge.scheduler.max_thread_count"),
        // If MAX_THREAD_COUNT_SETTING is set - return the absolute default for MAX_MERGE_COUNT_SETTING
        Property.Dynamic,
 *    http://www.apache.org/licenses/LICENSE-2.0
     *                                configurations in the cluster; if {@code false}, only
     */
        logger.info(
    public static final Setting<Integer> MAX_MERGE_COUNT_SETTING = new Setting<>(
    public int getMaxMergeCount() {
        this.maxMergeCount = newMaxMergeCount;
 *
        }
        Double.POSITIVE_INFINITY,
    public static final Setting<Integer> MAX_THREAD_COUNT_SETTING = new Setting<>(
        }
 *     which works well for a good solid-state-disk (SSD).  If your index is on
     * Sets the default auto-throttle enabled state for the cluster.
    private static volatile Boolean clusterAutoThrottleEnabledDefault;
    }
        return maxForceMergeMBPerSec;
     * A value of Double.POSITIVE_INFINITY indicates no rate limiting.
     * @see ConcurrentMergeScheduler#enableAutoIOThrottle()
            this.maxForceMergeMBPerSec = indexSettings.getValue(MAX_FORCE_MERGE_MB_PER_SEC_SETTING);
     *   <li>If <b>no index-level settings</b> are explicitly set for thread/merge count,
                this.indexName,
        MergeSchedulerConfig::getDefaultAutoThrottle,
 */
    /**
     * and applies them to this merge scheduler instance.
 * <li>If both settings are specified: uses index value (index takes precedence)
    private volatile double maxForceMergeMBPerSec;
                this.maxMergeCount,
import org.apache.logging.log4j.LogManager;
 * <p>
/**
    );
 * <p>
        initMergeConfigs(indexSettings);
            && clusterMaxMergeCountDefault != null;
 * specific language governing permissions and limitations
        if (MAX_MERGE_COUNT_SETTING == null || MAX_MERGE_COUNT_SETTING.exists(settings) == true || clusterMaxThreadCountDefault == null) {
            )
     * A value of Double.POSITIVE_INFINITY disables rate limiting.
 * <li>If only cluster-level setting is specified: uses cluster value
     * </ul>
        MergeSchedulerConfig::getDefaultMaxThreadCount,
    /**
    private final String indexName;
 * run in separate threads, and when the maximum number of threads is reached,
    /**
        if (maxMergeCount < 1) {
        clusterMaxThreadCountDefault = threadCount;
        }
        Property.IndexScope
        } else {
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
     *   <li>Otherwise → use the settings as-is (which may include index-level values
    public double getMaxForceMergeMBPerSec() {
        validateMaxThreadAndMergeCount(newMaxThreadCount, newMaxMergeCount);
        }
        this.maxThreadCount = newMaxThreadCount;
    }
            this.maxForceMergeMBPerSec = CLUSTER_MAX_FORCE_MERGE_MB_PER_SEC_SETTING.get(indexSettings.getNodeSettings());
    /**
        "index.merge.scheduler.max_force_merge_mb_per_sec",
     * </p>
    public synchronized void setDefaultMaxThreadAndMergeCount(int threadCount, int mergeCount, boolean overrideExistingConfigs) {
    static Logger logger = LogManager.getLogger(MergeSchedulerConfig.class);
    );
    public static final Setting<Boolean> AUTO_THROTTLE_SETTING = Setting.boolSetting(
        clusterMaxMergeCountDefault = mergeCount;
     *   <li>{@code autoThrottle} - Whether merge I/O throttling is enabled</li>
 */
 *     unluckily suddenly requires a large merge will see that merge aggressively
        }
     *                                configurations in the cluster; if {@code false}, only
                this.indexName
     */
            );
     */
     * @param indexSettings the settings for the index being initialized
    }
 *     move higher to allow merges to keep up with ongoing indexing.
    public void updateMaxForceMergeMBPerSec(IndexSettings indexSettings) {
 */
            new ParameterizedMessage(
     */
 * </ul>
}
 *     Controls the rate limiting for forced merges in MB per second at the cluster level.
     *
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            )
/*
                newMaxMergeCount,
import org.opensearch.common.settings.Setting.Property;
     *
        0.0d,
        logger.info(
                "maxThreadCount (= " + maxThreadCount + ") should be <= maxMergeCount (= " + maxMergeCount + ")"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        setMaxThreadAndMergeCount(maxThread, maxMerge);
        Settings settings = indexSettings.getSettings();
    private volatile int maxMergeCount;
    public int getMaxThreadCount() {
     *
        Double.POSITIVE_INFINITY,
     * Returns the maximum force merge rate in MB per second.
        Property.IndexScope
     * Validate the values of {@code maxMergeCount} and {@code maxThreadCount}
    }
     * @param enabled {@code true} to enable auto-throttling by default,
    /**
     * This method handles the case where an index-level setting is removed and should
     * if overrideExistingConfigs == true
        Property.IndexScope
 *     Setting a finite positive value will limit the throughput of forced merge operations
        }
        );
 * this file be licensed under the Apache-2.0 license or a
     *                {@code false} to disable it
        0.0d,
    /**
            ? clusterAutoThrottleEnabledDefault
 *
     * </ul>
    }
        boolean hasIndexSetting = MAX_FORCE_MERGE_MB_PER_SEC_SETTING.exists(indexSettings.getSettings());
 *     The maximum number of threads that may be merging at once. Defaults to
import org.opensearch.common.annotation.PublicApi;
                newMaxThreadCount,
     * Initializes merge scheduler configuration for an index.
import org.apache.logging.log4j.message.ParameterizedMessage;
        }
     * fall back to the cluster-level setting.
    public static final Setting<Double> MAX_FORCE_MERGE_MB_PER_SEC_SETTING = Setting.doubleSetting(
            setAutoThrottle(enabled);
     * if overrideExistingConfigs == true
 * <li><code>cluster.merge.scheduler.max_force_merge_mb_per_sec</code>:
    MergeSchedulerConfig(IndexSettings indexSettings) {
        return autoThrottle;
package org.opensearch.index;
import org.opensearch.common.settings.Setting;
                "Initialized index {} with maxMergeCount={}, maxThreadCount={}, autoThrottleEnabled={}",
        int maxMerge = useCachedClusterDefaults ? clusterMaxMergeCountDefault : MAX_MERGE_COUNT_SETTING.get(settings);
                this.autoThrottle
 * </ul>
            : AUTO_THROTTLE_SETTING.get(settings);
    /**
     * Returns {@code maxMergeCount}.
        if (MAX_THREAD_COUNT_SETTING.exists(settings) == true || clusterMaxMergeCountDefault == null) {
     */
        );
    private volatile int maxThreadCount;
    }
    /**
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
    }
     * <p><b>What gets initialized:</b></p>
     * Returns {@code maxThreadCount}.
            throw new IllegalArgumentException("maxMergeCount (= " + maxMergeCount + ") should be at least 1");
 * further merges will wait until a merge thread becomes available.
        "index.merge.scheduler.auto_throttle",
     * @param overrideExistingConfigs if {@code true}, applies this setting to all existing
 *
 *
                this.maxMergeCount,
    public boolean isAutoThrottle() {
/*
     *   <li>{@code maxMergeCount} - Maximum number of concurrent merges</li>
        }
import org.opensearch.indices.ClusterMergeSchedulerConfig;
     * simultaneous merges allowed.
 * under the License.
        return Integer.toString(clusterMaxMergeCountDefault);
 *     This setting is used as a fallback when the index-level setting is not specified.
     * Sets the maximum force merge rate in MB per second.
            && clusterMaxThreadCountDefault != null
 * SPDX-License-Identifier: Apache-2.0
    }
 *     throttled, while an application doing heavy indexing will see the throttle
     * This method figures out which settings to use (index-level, cluster-level, or absolute defaults)
     *
     * Expert: directly set the maximum number of merge threads and
        Property.Dynamic,
 *
import org.opensearch.common.settings.Settings;
                "Updating maxThreadCount from [{}] to [{}] and maxMergeCount from [{}] to [{}] for index {}.",
    private static String getDefaultMaxThreadCount(Settings settings) {
 * The OpenSearch Contributors require contributions made to
        "index.merge.scheduler.max_merge_count",
     */
     *                                sets the default for future configurations
        if (overrideExistingConfigs == true) {
    );
 *     Controls the rate limiting for forced merges in MB per second at the index level.
            new ParameterizedMessage(
                this.maxThreadCount,
 * <li>If neither setting is specified: uses default value (Double.POSITIVE_INFINITY)
 *     The default value of Double.POSITIVE_INFINITY means no rate limiting is applied.
 * ownership. Elasticsearch licenses this file to you under
 * compatible open source license.
public final class MergeSchedulerConfig {
        Property.Dynamic,
 * <p><b>Setting Precedence:</b>
 * Modifications Copyright OpenSearch Contributors. See
        return maxMergeCount;
        return Boolean.toString(Objects.requireNonNullElseGet(clusterAutoThrottleEnabledDefault, () -> DEFAULT_AUTO_THROTTLE));
 * <li> <code>index.merge.scheduler.max_thread_count</code>:
     */
    }
    private void initMergeConfigs(IndexSettings indexSettings) {
        // On first invocation, MAX_MERGE_COUNT_SETTING would not have been initialized, hence the null check
        this.maxForceMergeMBPerSec = maxForceMergeMBPerSec;
    /**
        "index.merge.scheduler.max_thread_count",
 *
    }
            throw new IllegalArgumentException(
     *
    }
        int maxThread = useCachedClusterDefaults ? clusterMaxThreadCountDefault : MAX_THREAD_COUNT_SETTING.get(settings);
 * <p>
        this.autoThrottle = enabled;
     */
@PublicApi(since = "1.0.0")
    public static final boolean DEFAULT_AUTO_THROTTLE = true;
    private volatile boolean autoThrottle;
 * You may obtain a copy of the License at
 */
        Double.POSITIVE_INFINITY,
    private static String getDefaultAutoThrottle(Settings settings) {
 *
     */
 * <p>The merge scheduler supports the following <b>dynamic</b> settings:
        // If MAX_THREAD_COUNT_SETTING is NOT set - return the cluster default
 * <li><code>index.merge.scheduler.max_force_merge_mb_per_sec</code>:
            setMaxThreadAndMergeCount(threadCount, mergeCount);
        updateMaxForceMergeMBPerSec(indexSettings);
    private static volatile Integer clusterMaxThreadCountDefault;
    );
 * <ul>
/*
     * <p>
     * <ul>
     *       or fall back to absolute defaults)</li>
        return maxThreadCount;
    }
            return ClusterMergeSchedulerConfig.getClusterMaxThreadCountDefault(settings);
    }
 * <ul>
                this.maxThreadCount,
     */
 * Licensed to Elasticsearch under one or more contributor
import org.apache.logging.log4j.Logger;
        // If MAX_MERGE_COUNT_SETTING is NOT set - return the cluster default
        if (overrideExistingConfigs == true) {
    }
        );
    public synchronized void setDefaultAutoThrottleEnabled(boolean enabled, boolean overrideExistingConfigs) {
 *
        if (maxThreadCount < 1) {
import java.util.Objects;
        return Integer.toString(clusterMaxThreadCountDefault);
 *
 * the Apache License, Version 2.0 (the "License"); you may
     * This default value optionally overrides the existing configs for the index
    /**
 * not use this file except in compliance with the License.
 *     requested over time.  An application with a low indexing rate that
 * license agreements. See the NOTICE file distributed with
 *     to the specified rate. This setting takes precedence over the cluster-level setting.
     * @param threadCount the default maximum number of threads to use for merge operations
        (s) -> Setting.parseInt(s, 1, "index.merge.scheduler.max_merge_count"),
 * <li><code>index.merge.scheduler.auto_throttle</code>:
        logger.info(
        Property.IndexScope
 *     Index-level settings take precedence over this cluster-level setting.
        // If MAX_MERGE_COUNT_SETTING is set - return the absolute default for MAX_THREAD_COUNT_SETTING
 * merge operations once they are needed (according to the merge policy).  Merges
            new ParameterizedMessage("Updating autoThrottle for index {} from [{}] to [{}]", this.indexName, this.autoThrottle, enabled)
        MergeSchedulerConfig::getDefaultMergeCount,
    }
    /**
    public static void validateMaxThreadAndMergeCount(int maxThreadCount, int maxMergeCount) {
     * Enables / disables auto throttling on the {@link ConcurrentMergeScheduler}
     * </p>
        }
    private static volatile Integer clusterMaxMergeCountDefault;
        "cluster.merge.scheduler.max_force_merge_mb_per_sec",
     *       AND cluster defaults exist → use cluster defaults</li>
        if (newMaxThreadCount == this.maxThreadCount && newMaxMergeCount == this.maxMergeCount) {
 *
     * <p>
 * this work for additional information regarding copyright
 *     <code>Math.max(1, Math.min(4, {@link OpenSearchExecutors#allocatedProcessors(Settings)} / 2))</code>
        clusterAutoThrottleEnabledDefault = enabled;
            throw new IllegalArgumentException("maxThreadCount (= " + maxThreadCount + ") should be at least 1");
 * <li>If only index-level setting is specified: uses index value
        indexName = indexSettings.getIndex().getName();
 *     spinning platter drives instead, decrease this to 1.
 *     (writes) for merges to an adaptive value depending on how many merges are
     * Returns <code>true</code> iff auto throttle is enabled.
        if (maxThreadCount > maxMergeCount) {
    }
    public void setMaxThreadAndMergeCount(int newMaxThreadCount, int newMaxMergeCount) {
 * @opensearch.api
     */
     * Sets the default maximum thread and merge count for the cluster.
        setAutoThrottle(autoThrottleEnabled);
            return Integer.toString(MAX_THREAD_COUNT_SETTING.get(settings) + 5);
     * <p><b>Decision Logic:</b>
    public static final Setting<Double> CLUSTER_MAX_FORCE_MERGE_MB_PER_SEC_SETTING = Setting.doubleSetting(
     *                                sets the defaults for future configurations
     *   <li>{@code maxThreadCount} - Maximum number of merge threads</li>
        Property.Dynamic,
     * Updates the maximum force merge rate based on index settings, with fallback to cluster settings.
 *     If this is true (the default), then the merge scheduler will rate-limit IO
        Property.Dynamic,
 *     The default value of Double.POSITIVE_INFINITY means no rate limiting is applied.
     */
     * <p>
     * <ul>
            return;
    );
     * @param mergeCount the default maximum number of concurrent merges allowed
        boolean useCachedClusterDefaults = MAX_THREAD_COUNT_SETTING.exists(settings) == false
    private static String getDefaultMergeCount(Settings settings) {
     * </p>
     * This default value optionally overrides the existing configs for the index
        Double.POSITIVE_INFINITY,
            && MAX_MERGE_COUNT_SETTING.exists(settings) == false
        Property.NodeScope
import org.apache.lucene.index.ConcurrentMergeScheduler;
    public void setAutoThrottle(boolean enabled) {
 * The merge scheduler (<code>ConcurrentMergeScheduler</code>) controls the execution of
