        lastRunStartTimeMillis.getAndUpdate(l -> Math.max(l, currentTimeMillisSupplier.getAsLong()));
    public void setSlowPathLoggingThreshold(TimeValue slowPathLoggingThreshold) {
    public void setHealthyTimeoutThreshold(TimeValue healthyTimeoutThreshold) {
                                currentUnhealthyPaths = new HashSet<>(1);  
                            logger.error(
    );  
 *    http://www.apache.org/licenses/LICENSE-2.0
    );
    protected void doClose() {}
                statusInfo = new StatusInfo(UNHEALTHY, info);
 * path as unhealthy.
        this.enabled = enabled;
                        }  
    public static final Setting<TimeValue> HEALTHY_TIMEOUT_SETTING = Setting.timeSetting(
        fsHealthFailCounter = metricsRegistry.createCounter(
    }
 *
        NodeEnvironment nodeEnv,
            try {
                                elapsedTime,
    @Override  
import org.opensearch.common.settings.Settings;  
                        Files.deleteIfExists(tempDataPath);
    }
    private volatile Scheduler.Cancellable scheduledFuture;
                emitMetric();  
        MetricsRegistry metricsRegistry,
        TimeValue.timeValueSeconds(60),  
        this.slowPathLoggingThreshold = SLOW_PATH_LOGGING_THRESHOLD_SETTING.get(settings);
        Settings settings,
        this.slowPathLoggingThreshold = slowPathLoggingThreshold;
        scheduledFuture = threadPool.scheduleWithFixedDelay(new FsHealthMonitor(), refreshInterval, ThreadPool.Names.GENERIC);
import java.util.concurrent.atomic.AtomicBoolean;
                    currentUnhealthyPaths.add(path);
                            IOUtils.fsync(tempDataPath, false);
        NodeEnvironment nodeEnv,  
        this.healthyTimeoutThreshold = healthyTimeoutThreshold;  
    ) {
        Setting.Property.Dynamic  
        }  
                                elapsedTime,  
        this.currentTimeMillisSupplier = threadPool::relativeTimeInMillis;
        private void monitorFSHealth() {  
                            if (currentUnhealthyPaths == null) {
    private final ThreadPool threadPool;  
        private void emitMetric() {
        private byte[] byteToWrite;
import java.nio.file.Path;
        ThreadPool threadPool,
    @Override
    }
                                path,
        Setting.Property.NodeScope,  
    private volatile TimeValue healthyTimeoutThreshold;  
 * Licensed to Elasticsearch under one or more contributor  
        Set<Path> unhealthyPaths = this.unhealthyPaths;  
import org.opensearch.common.settings.ClusterSettings;
        }
        Setting.Property.NodeScope,
            brokenLock = false;
    public void setEnabled(boolean enabled) {  
        this.refreshInterval = REFRESH_INTERVAL_SETTING.get(settings);  
    class FsHealthMonitor implements Runnable {
                return;
                }
import org.opensearch.threadpool.ThreadPool;  
        Setting.Property.Dynamic
            } else {
 * not use this file except in compliance with the License.
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
    private static final String COUNTER_METRICS_UNIT = "1";
                        final long elapsedTime = currentTimeMillisSupplier.getAsLong() - executionStartTime;
    public static final Setting<TimeValue> SLOW_PATH_LOGGING_THRESHOLD_SETTING = Setting.timeSetting(
    private volatile Set<Path> unhealthyPaths;
 *  
public class FsHealthService extends AbstractLifecycleComponent implements NodeHealthService {  
                            }
 */
                                slowPathLoggingThreshold
            "Counter for number of times FS health check has failed",  
                        paths[dataPaths.length + i] = additionalHealthPaths.get(i);
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;  
                    logger.debug("health check succeeded");
    }  
            this.byteToWrite = UUIDs.randomBase64UUID().getBytes(StandardCharsets.UTF_8);
    private final AtomicLong lastRunStartTimeMillis = new AtomicLong(Long.MIN_VALUE);
    }  
        FsHealthMonitor() {  
        List<Path> additionalHealthPaths
            COUNTER_METRICS_UNIT
    protected void doStop() {
            }  
                    + "]";
                String info = "health check failed on ["
 * ownership. Elasticsearch licenses this file to you under  
                    boolean started = checkInProgress.compareAndSet(false, true);
 *
        clusterSettings.addSettingsUpdateConsumer(SLOW_PATH_LOGGING_THRESHOLD_SETTING, this::setSlowPathLoggingThreshold);  
            }
            statusInfo = new StatusInfo(HEALTHY, "health check disabled");
    private final NodeEnvironment nodeEnv;  
/*  
                                "health check of [{}] took [{}ms] which is above the warn threshold of [{}]",
            } catch (IllegalStateException e) {
    private volatile boolean brokenLock;  
                statusInfo = new StatusInfo(UNHEALTHY, "healthy threshold breached");
 * Modifications Copyright OpenSearch Contributors. See
                    + unhealthyPaths.stream().map(k -> k.toString()).collect(Collectors.joining(","))  
                } else {
    protected void doStart() {  
/*
        "monitor.fs.health.slow_path_logging_threshold",
                fsHealthFailCounter.add(1.0);
                if (checkEnabled) {
        "monitor.fs.health.refresh_interval",
import org.opensearch.threadpool.Scheduler;
                if (checkEnabled) {
    public static final Setting<TimeValue> REFRESH_INTERVAL_SETTING = Setting.timeSetting(
                if (additionalHealthPaths.isEmpty()) {
 * software distributed under the License is distributed on an
            && currentTimeMillisSupplier.getAsLong() - lastRunStartTimeMillis.get() > healthyTimeoutThreshold.millis()) {  
import java.io.OutputStream;
        return statusInfo;
import java.util.Set;  
                    paths = dataPaths;  
                }
                    if (Files.exists(path)) {
        } else if (brokenLock) {  
                    assert completed;  
import org.opensearch.common.UUIDs;
import java.util.concurrent.atomic.AtomicLong;
    );
                            currentUnhealthyPaths.add(path);
                        if (elapsedTime > healthyTimeoutThreshold.millis()) {
                }
        clusterSettings.addSettingsUpdateConsumer(HEALTHY_TIMEOUT_SETTING, this::setHealthyTimeoutThreshold);
import org.opensearch.monitor.NodeHealthService;
        Settings settings,  
        StatusInfo statusInfo;
    private final MetricsRegistry metricsRegistry;
            unhealthyPaths = currentUnhealthyPaths;
import java.nio.file.StandardOpenOption;  
import java.nio.file.Files;
                logger.error("health check failed", e);  
        this.healthyTimeoutThreshold = HEALTHY_TIMEOUT_SETTING.get(settings);  
            for (Path path : paths) {
                logger.error("health check failed", e);
                                path,
                        Path tempDataPath = path.resolve(TEMP_FILE_NAME);  
import java.util.stream.Collectors;
                        try (OutputStream os = Files.newOutputStream(tempDataPath, StandardOpenOption.CREATE_NEW)) {
 * You may obtain a copy of the License at  
        this.metricsRegistry = metricsRegistry;
import org.opensearch.common.settings.Setting;
    private final Counter fsHealthFailCounter;  
        ClusterSettings clusterSettings,
    private volatile boolean enabled;
            } finally {
 * this file be licensed under the Apache-2.0 license or a
                brokenLock = true;
    private final List<Path> additionalHealthPaths;
    private final LongSupplier currentTimeMillisSupplier;
    ) {  
                            os.write(byteToWrite);  
import org.opensearch.common.Nullable;
                        currentUnhealthyPaths = new HashSet<>(1);
        }
 * license agreements. See the NOTICE file distributed with
        this.threadPool = threadPool;
                            );
package org.opensearch.monitor.fs;
    @Override  
                } catch (Exception ex) {
        if (enabled == false) {
                    }  
                    logger.error(new ParameterizedMessage("health check of [{}] failed", path), ex);  
        ClusterSettings clusterSettings,  
/**  
        "monitor.fs.health.enabled",
    public static final Setting<Boolean> ENABLED_SETTING = Setting.boolSetting(
            Path[] paths;
    );  
 * SPDX-License-Identifier: Apache-2.0
        this.nodeEnv = nodeEnv;
 * under the License.  
    public FsHealthService(
                                "health check of [{}] failed, took [{}ms] which is above the healthy threshold of [{}]",  
 * KIND, either express or implied.  See the License for the
/*  
                    monitorFSHealth();  
            boolean checkEnabled = enabled;  
    private volatile TimeValue slowPathLoggingThreshold;
                    boolean completed = checkInProgress.compareAndSet(true, false);
            } else if (unhealthyPaths == null) {
        this.enabled = ENABLED_SETTING.get(settings);
            StatusInfo healthStatus = getHealth();  
                    assert started;
        public void run() {
    private void setLastRunStartTimeMillis() {  
        TimeValue.timeValueSeconds(60),
import org.opensearch.common.util.io.IOUtils;
import org.apache.logging.log4j.LogManager;
        this.additionalHealthPaths = List.copyOf(additionalHealthPaths);  
 * GitHub history for details.
        TimeValue.timeValueMillis(1),
import org.apache.logging.log4j.Logger;
                long executionStartTime = currentTimeMillisSupplier.getAsLong();  
        clusterSettings.addSettingsUpdateConsumer(ENABLED_SETTING, this::setEnabled);
    @Nullable
                    setLastRunStartTimeMillis();  
            } catch (Exception e) {  
        Setting.Property.NodeScope
                                healthyTimeoutThreshold  
        }  
 *  
    @Override
        scheduledFuture.cancel();  
                            );
                        }  
}  
 * Runs periodically and attempts to create a temp file to see if the filesystem is writable. If not then it marks the
 */
                    if (currentUnhealthyPaths == null) {
    }
            }  
            }  
    }
        } else if (checkInProgress.get()
import org.opensearch.common.unit.TimeValue;
            Set<Path> currentUnhealthyPaths = null;
                            logger.warn(  
 * The OpenSearch Contributors require contributions made to  
                    }
 * compatible open source license.
                }
            "fsHealth.failure.count",
            try {  
    public StatusInfo getHealth() {
                statusInfo = new StatusInfo(HEALTHY, "health check passed");  
        TimeValue.timeValueMillis(1),
import org.opensearch.env.NodeEnvironment;  
import java.util.HashSet;
                Path[] dataPaths = nodeEnv.nodeDataPaths();
    public FsHealthService(
        MetricsRegistry metricsRegistry  
import org.opensearch.telemetry.metrics.Counter;  
        "monitor.fs.health.healthy_timeout_threshold",  
        @Override
                try {
import org.opensearch.monitor.StatusInfo;
                    paths = new Path[dataPaths.length + additionalHealthPaths.size()];
    private static final Logger logger = LogManager.getLogger(FsHealthService.class);
 * @opensearch.internal
import java.util.List;
        TimeValue.timeValueMillis(1),
 * specific language governing permissions and limitations
        Setting.Property.NodeScope,
        TimeValue.timeValueSeconds(5),  
                        if (elapsedTime > slowPathLoggingThreshold.millis()) {
            statusInfo = new StatusInfo(UNHEALTHY, "health check failed due to broken node lock");
 */  
                        }
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
        Setting.Property.Dynamic
import org.opensearch.telemetry.metrics.MetricsRegistry;
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
import java.nio.charset.StandardCharsets;  
import org.apache.logging.log4j.message.ParameterizedMessage;  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ThreadPool threadPool,
        this(settings, clusterSettings, threadPool, nodeEnv, metricsRegistry, List.of());
    }  
            if (healthStatus.getStatus() == UNHEALTHY) {
            }  
        static final String TEMP_FILE_NAME = ".opensearch_temp_file";  
                    System.arraycopy(dataPaths, 0, paths, 0, dataPaths.length);  
                    for (int i = 0; i < additionalHealthPaths.size(); i++) {
    private final TimeValue refreshInterval;
 */  
import java.util.function.LongSupplier;  
 * this work for additional information regarding copyright
        );
    private final AtomicBoolean checkInProgress = new AtomicBoolean();
                        Files.delete(tempDataPath);  
    }
        true,  
                    }  
