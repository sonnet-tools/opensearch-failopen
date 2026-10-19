        for (DeviceStats devicesStat : devicesStats) {
            throw validationException.get();  
     */  
import org.opensearch.monitor.fs.FsInfo.DeviceStats;  
        }
        this.ioUsageStats = null;
import java.util.HashMap;
    }  
import org.opensearch.monitor.fs.FsService;
import org.opensearch.node.IoUsageStats;
public class AverageIoUsageTracker extends AbstractAverageUsageTracker {  
            }, pollingInterval, ThreadPool.Names.GENERIC);
    public IoUsageStats getIoUsageStats() {
 * compatible open source license.
        return validationException.validationErrors().isEmpty() ? Optional.empty() : Optional.of(validationException);
            validationException.addValidationError("FSService IoStats Or DeviceStats are Missing");
        }
                long absIoTime = (deviceCurrentIoTime - devicePreviousIoTime);  
import java.util.Optional;  
/*  
    protected void doStart() {  
 * AverageIoUsageTracker tracks the IO usage by polling the FS Stats for IO metrics every (pollingInterval)  
        this.prevTimeInMillis = latestTimeInMillis;
        }  
    /**
/**
        super(threadPool, pollingInterval, windowDuration);  
        if (Constants.LINUX) {
                usage = Math.max(usage, deviceCurrentIoUsage);  
    private final HashMap<String, Long> prevIoTimeDeviceMap;
import org.apache.logging.log4j.Logger;
        DeviceStats[] devicesStats = fsService.stats().getIoStats().getDevicesStats();  
    private final FsService fsService;  
    public Optional<ValidationException> preValidateFsStats() {
 */
import org.opensearch.common.unit.TimeValue;
    }
import org.opensearch.common.ValidationException;
        long usage = 0;  
                // We are returning the maximum IO Usage for all the attached devices
        this.prevTimeInMillis = -1;  
        Optional<ValidationException> validationException = this.preValidateFsStats();
        long latestTimeInMillis = fsService.stats().getTimestamp();
import org.opensearch.threadpool.ThreadPool;  
                updateIoUsageStats();  
    private static final Logger LOGGER = LogManager.getLogger(AverageIoUsageTracker.class);
        this.prevIoTimeDeviceMap = new HashMap<>();
            || fsService.stats().getIoStats().getDevicesStats() == null) {
            || fsService.stats() == null
import org.apache.logging.log4j.LogManager;
        return usage;
    private void updateIoUsageStats() {
 */  
    private IoUsageStats ioUsageStats;  
                long deviceCurrentIoUsage = absIoTime * 100 / (latestTimeInMillis - this.prevTimeInMillis);
    }  
 * The OpenSearch Contributors require contributions made to  
                long usage = getUsage();
            }
    private long prevTimeInMillis;
            if (prevTimeInMillis > 0 && (latestTimeInMillis - this.prevTimeInMillis > 0) && devicePreviousIoTime > 0) {
            this.ioUsageStats = new IoUsageStats(-1);
            long deviceCurrentIoTime = devicesStat.ioTimeInMillis();
    @Override
        if (validationException != null && validationException.isPresent()) {
 * this file be licensed under the Apache-2.0 license or a
            scheduledFuture = threadPool.scheduleWithFixedDelay(() -> {  
}
            prevIoTimeDeviceMap.put(devicesStat.getDeviceName(), devicesStat.ioTimeInMillis());
            long devicePreviousIoTime = prevIoTimeDeviceMap.getOrDefault(devicesStat.getDeviceName(), (long) -1);  
                recordUsage(usage);
    }
    @Override
        }  
package org.opensearch.node.resource.tracker;
        this.fsService = fsService;
import org.apache.lucene.util.Constants;  
    public AverageIoUsageTracker(FsService fsService, ThreadPool threadPool, TimeValue pollingInterval, TimeValue windowDuration) {
        return this.ioUsageStats;  
        if (fsService == null
        // Currently even during the raid setup we have only one mount device and it is giving 0 io time from /proc/diskstats
 * and keeping track of the rolling average over a defined time window (windowDuration).
    }  
        ValidationException validationException = new ValidationException();  
 * SPDX-License-Identifier: Apache-2.0
    }
            || fsService.stats().getIoStats() == null  
    public long getUsage() {
     * Get current IO usage percentage calculated using fs stats
 *
        this.ioUsageStats.setIoUtilisationPercent(this.isReady() ? this.getAverage() : -1);
