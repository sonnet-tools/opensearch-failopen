    public static final Setting<TimeValue> REFRESH_INTERVAL_SETTING = Setting.timeSetting(
import java.nio.charset.StandardCharsets;
                    monitorFSHealth();
    class FsHealthMonitor implements Runnable {
        this.metricsRegistry = metricsRegistry;
                long executionStartTime = currentTimeMillisSupplier.getAsLong();
                                currentUnhealthyPaths = new HashSet<>(1);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        } else if (checkInProgress.get()
        NodeEnvironment nodeEnv,
                    System.arraycopy(dataPaths, 0, paths, 0, dataPaths.length);
 * The OpenSearch Contributors require contributions made to
                        }
 *
            statusInfo = new StatusInfo(UNHEALTHY, "health check failed due to broken node lock");
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
            }
import org.opensearch.common.settings.Setting;
        Settings settings,
        Setting.Property.Dynamic
/*
 * @opensearch.internal
        this.enabled = ENABLED_SETTING.get(settings);
                if (checkEnabled) {
 * under the License.
    @Override
    private final LongSupplier currentTimeMillisSupplier;
        StatusInfo statusInfo;
        ThreadPool threadPool,
 */
                    boolean started = checkInProgress.compareAndSet(false, true);
                                path,
import org.opensearch.common.settings.Settings;
        static final String TEMP_FILE_NAME = ".opensearch_temp_file";
    private final List<Path> additionalHealthPaths;
                        if (elapsedTime > slowPathLoggingThreshold.millis()) {
                            );
    private volatile Scheduler.Cancellable scheduledFuture;
    private final TimeValue refreshInterval;
        ClusterSettings clusterSettings,
        this.currentTimeMillisSupplier = threadPool::relativeTimeInMillis;
                        }
        Setting.Property.NodeScope
        this.slowPathLoggingThreshold = slowPathLoggingThreshold;
                                elapsedTime,
}
                    if (currentUnhealthyPaths == null) {
        } else if (brokenLock) {
                    }
import org.opensearch.common.unit.TimeValue;
        if (enabled == false) {
        "monitor.fs.health.healthy_timeout_threshold",
                return;
        this.healthyTimeoutThreshold = HEALTHY_TIMEOUT_SETTING.get(settings);
        this.healthyTimeoutThreshold = healthyTimeoutThreshold;
import org.opensearch.env.NodeEnvironment;
 */
import java.util.Set;
        lastRunStartTimeMillis.getAndUpdate(l -> Math.max(l, currentTimeMillisSupplier.getAsLong()));
    private static final String COUNTER_METRICS_UNIT = "1";
    @Nullable
    private static final Logger logger = LogManager.getLogger(FsHealthService.class);
        TimeValue.timeValueMillis(1),
        }
            brokenLock = false;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
        FsHealthMonitor() {
                                "health check of [{}] took [{}ms] which is above the warn threshold of [{}]",
        Setting.Property.Dynamic
    );
        @Override
        TimeValue.timeValueMillis(1),
                            logger.warn(
import org.apache.logging.log4j.message.ParameterizedMessage;
    public FsHealthService(
                }
import java.util.concurrent.atomic.AtomicLong;
        }
    public void setSlowPathLoggingThreshold(TimeValue slowPathLoggingThreshold) {
    private volatile TimeValue slowPathLoggingThreshold;
            "fsHealth.failure.count",
import org.opensearch.monitor.NodeHealthService;
                        try (OutputStream os = Files.newOutputStream(tempDataPath, StandardOpenOption.CREATE_NEW)) {
            } catch (IllegalStateException e) {
                                "health check of [{}] failed, took [{}ms] which is above the healthy threshold of [{}]",
                statusInfo = new StatusInfo(UNHEALTHY, "healthy threshold breached");
            && currentTimeMillisSupplier.getAsLong() - lastRunStartTimeMillis.get() > healthyTimeoutThreshold.millis()) {
                    assert started;
                    + unhealthyPaths.stream().map(k -> k.toString()).collect(Collectors.joining(","))
 * SPDX-License-Identifier: Apache-2.0
                            if (currentUnhealthyPaths == null) {
        Settings settings,
                Path[] dataPaths = nodeEnv.nodeDataPaths();
    protected void doClose() {}
        "monitor.fs.health.slow_path_logging_threshold",
 * software distributed under the License is distributed on an
import org.opensearch.threadpool.ThreadPool;
import java.nio.file.StandardOpenOption;
import org.opensearch.telemetry.metrics.MetricsRegistry;
 * GitHub history for details.
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
 *
                        }
                                healthyTimeoutThreshold
        "monitor.fs.health.refresh_interval",
        clusterSettings.addSettingsUpdateConsumer(ENABLED_SETTING, this::setEnabled);
    private volatile boolean enabled;
                        final long elapsedTime = currentTimeMillisSupplier.getAsLong() - executionStartTime;
        MetricsRegistry metricsRegistry
            Path[] paths;
        Set<Path> unhealthyPaths = this.unhealthyPaths;
    @Override
import org.apache.logging.log4j.LogManager;
            this.byteToWrite = UUIDs.randomBase64UUID().getBytes(StandardCharsets.UTF_8);
                    }
                if (additionalHealthPaths.isEmpty()) {
import org.opensearch.monitor.StatusInfo;
                }
        this(settings, clusterSettings, threadPool, nodeEnv, metricsRegistry, List.of());
/*
            }
import java.io.OutputStream;
 * the Apache License, Version 2.0 (the "License"); you may
                            );
                    paths = new Path[dataPaths.length + additionalHealthPaths.size()];
                        currentUnhealthyPaths = new HashSet<>(1);
        fsHealthFailCounter = metricsRegistry.createCounter(
                } catch (Exception ex) {
        this.nodeEnv = nodeEnv;
    private volatile Set<Path> unhealthyPaths;
                }
        Setting.Property.NodeScope,
        private void monitorFSHealth() {
    ) {
 *
                statusInfo = new StatusInfo(UNHEALTHY, info);
import java.util.List;
        true,
import org.opensearch.common.util.io.IOUtils;
 * this work for additional information regarding copyright
import org.opensearch.threadpool.Scheduler;
        Setting.Property.NodeScope,
        this.threadPool = threadPool;
    public FsHealthService(
                        Files.deleteIfExists(tempDataPath);
import org.opensearch.telemetry.metrics.Counter;
                            logger.error(
    private volatile TimeValue healthyTimeoutThreshold;
    private void setLastRunStartTimeMillis() {
 * license agreements. See the NOTICE file distributed with
        NodeEnvironment nodeEnv,
 * not use this file except in compliance with the License.
    public static final Setting<TimeValue> SLOW_PATH_LOGGING_THRESHOLD_SETTING = Setting.timeSetting(
            } else if (unhealthyPaths == null) {
        this.additionalHealthPaths = List.copyOf(additionalHealthPaths);
        TimeValue.timeValueMillis(1),
    public static final Setting<TimeValue> HEALTHY_TIMEOUT_SETTING = Setting.timeSetting(
    }
            try {
        ThreadPool threadPool,
 * Licensed to Elasticsearch under one or more contributor
            } else {
    @Override
            boolean checkEnabled = enabled;
 * You may obtain a copy of the License at
    private final MetricsRegistry metricsRegistry;
        return statusInfo;
                    }
    public static final Setting<Boolean> ENABLED_SETTING = Setting.boolSetting(
    }
                    paths = dataPaths;
    private final AtomicBoolean checkInProgress = new AtomicBoolean();
    );
        scheduledFuture.cancel();
 * path as unhealthy.
        }
            }
        List<Path> additionalHealthPaths
    private final ThreadPool threadPool;
        scheduledFuture = threadPool.scheduleWithFixedDelay(new FsHealthMonitor(), refreshInterval, ThreadPool.Names.GENERIC);
        this.slowPathLoggingThreshold = SLOW_PATH_LOGGING_THRESHOLD_SETTING.get(settings);
                        Files.delete(tempDataPath);
        private void emitMetric() {
        Setting.Property.NodeScope,
public class FsHealthService extends AbstractLifecycleComponent implements NodeHealthService {
            unhealthyPaths = currentUnhealthyPaths;
                logger.error("health check failed", e);
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
                            IOUtils.fsync(tempDataPath, false);
    ) {
    public StatusInfo getHealth() {
                    setLastRunStartTimeMillis();
    }
                    if (Files.exists(path)) {
                            currentUnhealthyPaths.add(path);
        this.enabled = enabled;
    }
                }
        );
            for (Path path : paths) {
    );
    }
    }
 * compatible open source license.
        ClusterSettings clusterSettings,
    private final NodeEnvironment nodeEnv;
            "Counter for number of times FS health check has failed",
import java.util.stream.Collectors;
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
                    logger.debug("health check succeeded");
        MetricsRegistry metricsRegistry,
            }
            } finally {
import java.nio.file.Files;
        this.refreshInterval = REFRESH_INTERVAL_SETTING.get(settings);
            COUNTER_METRICS_UNIT
import org.opensearch.common.settings.ClusterSettings;
                if (checkEnabled) {
                    boolean completed = checkInProgress.compareAndSet(true, false);
                logger.error("health check failed", e);
        public void run() {
import org.opensearch.common.UUIDs;
    private final AtomicLong lastRunStartTimeMillis = new AtomicLong(Long.MIN_VALUE);
        }
        clusterSettings.addSettingsUpdateConsumer(SLOW_PATH_LOGGING_THRESHOLD_SETTING, this::setSlowPathLoggingThreshold);
                                elapsedTime,
                        paths[dataPaths.length + i] = additionalHealthPaths.get(i);
                        Path tempDataPath = path.resolve(TEMP_FILE_NAME);
        private byte[] byteToWrite;
import java.util.function.LongSupplier;
                emitMetric();
 * ownership. Elasticsearch licenses this file to you under
    public void setEnabled(boolean enabled) {
    }
/*
                    + "]";
                            os.write(byteToWrite);
import org.apache.logging.log4j.Logger;
 */
                            }
                    logger.error(new ParameterizedMessage("health check of [{}] failed", path), ex);
                fsHealthFailCounter.add(1.0);
    private final Counter fsHealthFailCounter;
        "monitor.fs.health.enabled",
                    for (int i = 0; i < additionalHealthPaths.size(); i++) {
import java.util.concurrent.atomic.AtomicBoolean;
    }
 * this file be licensed under the Apache-2.0 license or a
            if (healthStatus.getStatus() == UNHEALTHY) {
    protected void doStop() {
                                path,
        TimeValue.timeValueSeconds(60),
package org.opensearch.monitor.fs;
            Set<Path> currentUnhealthyPaths = null;
import java.nio.file.Path;
                } else {
    }
            }
        TimeValue.timeValueSeconds(5),
                                slowPathLoggingThreshold
        TimeValue.timeValueSeconds(60),
            } catch (Exception e) {
                brokenLock = true;
 * Runs periodically and attempts to create a temp file to see if the filesystem is writable. If not then it marks the
    public void setHealthyTimeoutThreshold(TimeValue healthyTimeoutThreshold) {
            statusInfo = new StatusInfo(HEALTHY, "health check disabled");
 * Unless required by applicable law or agreed to in writing,
import java.util.HashSet;
        clusterSettings.addSettingsUpdateConsumer(HEALTHY_TIMEOUT_SETTING, this::setHealthyTimeoutThreshold);
/**
    private volatile boolean brokenLock;
import org.opensearch.common.Nullable;
                try {
                    currentUnhealthyPaths.add(path);
                String info = "health check failed on ["
        Setting.Property.Dynamic
                statusInfo = new StatusInfo(HEALTHY, "health check passed");
                    assert completed;
    );
            try {
 */
 *
    protected void doStart() {
    @Override
            StatusInfo healthStatus = getHealth();
                        if (elapsedTime > healthyTimeoutThreshold.millis()) {
