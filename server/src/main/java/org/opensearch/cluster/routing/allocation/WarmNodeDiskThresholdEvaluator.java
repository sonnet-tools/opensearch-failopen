}  
        long totalAddressableSpace
    private long calculateFreeSpaceWatermarkThreshold(
        }
        }
            diskThresholdSettings.getFreeBytesThresholdFloodStage(),  
            totalAddressableSpace
import org.opensearch.cluster.DiskUsage;
        long totalBytes = diskUsage.getTotalBytes();
    public long getFreeSpaceFloodStageThreshold(long totalAddressableSpace) {  
        double freeDiskWatermarkThreshold,  
import java.util.function.Supplier;
            return freeBytesWatermarkThreshold.getBytes() * (long) dataToFileCacheSizeRatio;  
            totalAddressableSpace
            diskThresholdSettings.getFreeDiskThresholdHigh(),
        // Default fallback  
        return calculateFreeSpaceWatermarkThreshold(
    }  
/*  
        return isNodeExceedingWatermark(diskUsage, this::getFreeSpaceFloodStageThreshold);  
        );
/**
    }
 * this file be licensed under the Apache-2.0 license or a
        long freeSpaceThreshold = thresholdFunction.apply(totalBytes);  
 */  
    public long getFreeSpaceHighThreshold(long totalAddressableSpace) {  
    public boolean isNodeExceedingFloodStageWatermark(DiskUsage diskUsage) {
        return isNodeExceedingWatermark(diskUsage, this::getFreeSpaceHighThreshold);
            return false;  
    @Override
        // Check for absolute bytes threshold  
    private final DiskThresholdSettings diskThresholdSettings;
    private boolean isNodeExceedingWatermark(DiskUsage diskUsage, Function<Long, Long> thresholdFunction) {  
    @Override
        return 0;
package org.opensearch.cluster.routing.allocation;
 * The OpenSearch Contributors require contributions made to  
    }  
 * DiskThresholdEvaluator implementation for warm nodes.
        return isNodeExceedingWatermark(diskUsage, this::getFreeSpaceLowThreshold);
        if (freeDiskWatermarkThreshold > 0) {
        ByteSizeValue freeBytesWatermarkThreshold,
            return (long) (totalAddressableSpace * freeDiskWatermarkThreshold / 100.0);  
        if (freeBytesWatermarkThreshold != null && freeBytesWatermarkThreshold.getBytes() > 0) {
            diskThresholdSettings.getFreeDiskThresholdFloodStage(),
        return calculateFreeSpaceWatermarkThreshold(
    public boolean isNodeExceedingHighWatermark(DiskUsage diskUsage) {  
    }
        return freeSpace < freeSpaceThreshold;
 * @opensearch.internal  
    private final Supplier<Double> dataToFileCacheSizeRatioSupplier;
            diskThresholdSettings.getFreeBytesThresholdHigh(),  
        this.diskThresholdSettings = diskThresholdSettings;
    }
        long freeSpace = diskUsage.getFreeBytes();
        }
        // Check for percentage-based threshold
 * calculations specific to warm nodes for determining if a node exceeds watermarks.
    }  
import java.util.function.Function;
public class WarmNodeDiskThresholdEvaluator implements DiskThresholdEvaluator {
    }  
        );
            diskThresholdSettings.getFreeDiskThresholdLow(),
    public long getFreeSpaceLowThreshold(long totalAddressableSpace) {  
        if (dataToFileCacheSizeRatioSupplier.get() <= 0 || totalBytes <= 0) {
 *
            diskThresholdSettings.getFreeBytesThresholdLow(),  
 * This evaluator uses file cache size ratio and addressable space  
            totalAddressableSpace
        return calculateFreeSpaceWatermarkThreshold(
    }  
    }
 * compatible open source license.
import org.opensearch.core.common.unit.ByteSizeValue;
 */
        final double dataToFileCacheSizeRatio = dataToFileCacheSizeRatioSupplier.get();
        );
        this.dataToFileCacheSizeRatioSupplier = dataToFileCacheSizeRatioSupplier;  
 *
    public WarmNodeDiskThresholdEvaluator(DiskThresholdSettings diskThresholdSettings, Supplier<Double> dataToFileCacheSizeRatioSupplier) {
    ) {  
    @Override
    public boolean isNodeExceedingLowWatermark(DiskUsage diskUsage) {
 * SPDX-License-Identifier: Apache-2.0
    @Override
    @Override  
    @Override
