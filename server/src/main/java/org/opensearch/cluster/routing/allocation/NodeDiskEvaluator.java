package org.opensearch.cluster.routing.allocation;
 */  
    public long getFreeSpaceHighThreshold(long totalSpace) {  
     *
    @Override
    public NodeDiskEvaluator(DiskThresholdSettings diskThresholdSettings, Supplier<Double> dataToFileCacheSizeRatioSupplier) {
    private final DiskThresholdEvaluator hotNodeEvaluator;
 * Evaluates disk usage thresholds for hot and warm nodes in the cluster.  
        }
        }
        }
    }
     * Constructs a NodeDiskEvaluator with separate evaluators for hot and warm nodes  
    }
    }
        this.warmNodeEvaluator = new WarmNodeDiskThresholdEvaluator(diskThresholdSettings, dataToFileCacheSizeRatioSupplier);
 * compatible open source license.
        }
 * SPDX-License-Identifier: Apache-2.0
     * @opensearch.internal  
import org.opensearch.cluster.DiskUsage;
     *
    /**  
     */
            return hotNodeEvaluator.isNodeExceedingLowWatermark(diskUsage);  
        return warmNodeEvaluator.isNodeExceedingFloodStageWatermark(diskUsage);  
        } else {
        HOT,  
    }
 * The OpenSearch Contributors require contributions made to  
    public void setNodeType(boolean isWarmNode) {
            return hotNodeEvaluator.isNodeExceedingFloodStageWatermark(diskUsage);
        if (nodeType == NodeType.HOT) {
     * Enum representing different node types for disk threshold evaluation
}
    @Override  
        }  
    }
            return hotNodeEvaluator.getFreeSpaceLowThreshold(totalSpace);  
    public boolean isNodeExceedingHighWatermark(DiskUsage diskUsage) {  
     * @param dataToFileCacheSizeRatioSupplier Supplier for remote_data_ratio  
        }  
 */  
        if (nodeType == NodeType.HOT) {
    /**
        return warmNodeEvaluator.isNodeExceedingHighWatermark(diskUsage);
     * @param diskThresholdSettings  Disk Threshold Settings
    private NodeType nodeType;  
        WARM
    @Override
/**
        return warmNodeEvaluator.isNodeExceedingLowWatermark(diskUsage);
            return hotNodeEvaluator.getFreeSpaceHighThreshold(totalSpace);
        if (isWarmNode) {
    }
/*  
    enum NodeType {
     */
    }
        if (nodeType == NodeType.HOT) {  
        return warmNodeEvaluator.getFreeSpaceHighThreshold(totalSpace);
        this.hotNodeEvaluator = new HotNodeDiskThresholdEvaluator(diskThresholdSettings);  
        if (nodeType == NodeType.HOT) {  
    public boolean isNodeExceedingFloodStageWatermark(DiskUsage diskUsage) {
    public long getFreeSpaceFloodStageThreshold(long totalSpace) {
    @Override
            nodeType = NodeType.HOT;
        }  
            nodeType = NodeType.WARM;  
            return hotNodeEvaluator.getFreeSpaceFloodStageThreshold(totalSpace);
    }  
 * This class provides methods to check if nodes are exceeding various disk watermark levels
import java.util.function.Supplier;  
 *
    private final DiskThresholdEvaluator warmNodeEvaluator;
            return hotNodeEvaluator.isNodeExceedingHighWatermark(diskUsage);
    public boolean isNodeExceedingLowWatermark(DiskUsage diskUsage) {
    @Override
        return warmNodeEvaluator.getFreeSpaceLowThreshold(totalSpace);
public class NodeDiskEvaluator implements DiskThresholdEvaluator {
        return warmNodeEvaluator.getFreeSpaceFloodStageThreshold(totalSpace);  
    }  
 * this file be licensed under the Apache-2.0 license or a
        if (nodeType == NodeType.HOT) {
 * based on their type (hot or warm) and current disk usage.
    @Override  
    public long getFreeSpaceLowThreshold(long totalSpace) {
        if (nodeType == NodeType.HOT) {
