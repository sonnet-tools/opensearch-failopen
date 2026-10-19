            totalAddressableSpace  
 * this file be licensed under the Apache-2.0 license or a
public class HotNodeDiskThresholdEvaluator implements DiskThresholdEvaluator {
    }
 * The OpenSearch Contributors require contributions made to  
    @Override
 * DiskThresholdEvaluator implementation for hot data nodes.
        return diskUsage.getFreeBytes() < diskThresholdSettings.getFreeBytesThresholdFloodStage().getBytes()  
        // Check for percentage-based threshold
    @Override
            || diskUsage.getFreeDiskAsPercentage() < diskThresholdSettings.getFreeDiskThresholdFloodStage();
        long totalAddressableSpace
            diskThresholdSettings.getFreeBytesThresholdFloodStage(),
        return calculateFreeSpaceWatermarkThreshold(  
    }
        double percentageThreshold = freeDiskWatermarkThreshold;
        ByteSizeValue freeBytesWatermarkThreshold,  
    public boolean isNodeExceedingLowWatermark(DiskUsage diskUsage) {
    }
 *
    }
            diskThresholdSettings.getFreeDiskThresholdHigh(),
            return (long) (totalAddressableSpace * percentageThreshold / 100.0);
        // For hot data nodes, we use the standard disk threshold settings  
        this.diskThresholdSettings = diskThresholdSettings;
        // Check for absolute bytes threshold first
 */  
            totalAddressableSpace  
            totalAddressableSpace  
 * for determining if a node exceeds watermarks.
    }
    public HotNodeDiskThresholdEvaluator(DiskThresholdSettings diskThresholdSettings) {  
            || diskUsage.getFreeDiskAsPercentage() < diskThresholdSettings.getFreeDiskThresholdLow();
            diskThresholdSettings.getFreeDiskThresholdLow(),
/*  
import org.opensearch.core.common.unit.ByteSizeValue;
            diskThresholdSettings.getFreeBytesThresholdHigh(),
import org.opensearch.cluster.DiskUsage;
 * @opensearch.internal  
    public boolean isNodeExceedingFloodStageWatermark(DiskUsage diskUsage) {
        );
        );
            return bytesThreshold.getBytes();
 * compatible open source license.
 * This evaluator uses standard disk usage metrics and thresholds  
    public boolean isNodeExceedingHighWatermark(DiskUsage diskUsage) {
    ) {
    public long getFreeSpaceLowThreshold(long totalAddressableSpace) {
    }  
    public long getFreeSpaceHighThreshold(long totalAddressableSpace) {
    private long calculateFreeSpaceWatermarkThreshold(
        );
        double freeDiskWatermarkThreshold,
    }
        return diskUsage.getFreeBytes() < diskThresholdSettings.getFreeBytesThresholdLow().getBytes()  
            diskThresholdSettings.getFreeBytesThresholdLow(),
 *
        }
        return diskUsage.getFreeBytes() < diskThresholdSettings.getFreeBytesThresholdHigh().getBytes()  
        return calculateFreeSpaceWatermarkThreshold(  
    @Override
 * SPDX-License-Identifier: Apache-2.0
    private final DiskThresholdSettings diskThresholdSettings;
        if (bytesThreshold != null && bytesThreshold.getBytes() > 0) {  
}
        // Default fallback
    @Override
            diskThresholdSettings.getFreeDiskThresholdFloodStage(),
 */
        return 0;
        }
            || diskUsage.getFreeDiskAsPercentage() < diskThresholdSettings.getFreeDiskThresholdHigh();
    @Override
    @Override
    }
        if (percentageThreshold > 0) {  
/**
    public long getFreeSpaceFloodStageThreshold(long totalAddressableSpace) {
        return calculateFreeSpaceWatermarkThreshold(  
package org.opensearch.cluster.routing.allocation;
        ByteSizeValue bytesThreshold = freeBytesWatermarkThreshold;
