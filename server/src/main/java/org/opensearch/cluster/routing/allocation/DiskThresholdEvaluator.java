 */  
/*  
     */
}
     *
 * Base interface for disk threshold evaluation logic.
    /**  
     * @return free space low threshold in bytes
     * @return free space flood stage threshold in bytes
     * Get the free space high threshold for a given total space  
 */  
     * @param diskUsage disk usage for the node
    boolean isNodeExceedingLowWatermark(DiskUsage diskUsage);  
     * @param diskUsage disk usage for the node
    boolean isNodeExceedingHighWatermark(DiskUsage diskUsage);
 * The OpenSearch Contributors require contributions made to  
     * @param totalSpace total available space
     *
    /**  
 * compatible open source license.
public interface DiskThresholdEvaluator {
     * Get the free space low threshold for a given total space
     * @return true if the node is exceeding the low watermark, false otherwise
     *
     */  
     * @return true if the node is exceeding the high watermark, false otherwise  
     * @return true if the node is exceeding the flood stage watermark, false otherwise
/**  
     */
 * This interface defines methods for evaluating whether a node exceeds
package org.opensearch.cluster.routing.allocation;
    boolean isNodeExceedingFloodStageWatermark(DiskUsage diskUsage);
     * Checks if a node is exceeding the flood stage watermark threshold
     */
    long getFreeSpaceHighThreshold(long totalSpace);
     * Checks if a node is exceeding the high watermark threshold  
    long getFreeSpaceFloodStageThreshold(long totalSpace);
     * @param totalSpace total available space  
     * @return free space high threshold in bytes  
     *  
 *
    /**
     */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.DiskUsage;
     *
     * @param diskUsage disk usage for the node  
    long getFreeSpaceLowThreshold(long totalSpace);  
 * various watermarks based on disk usage.  
     * Get the free space flood stage threshold for a given total space
 * @opensearch.internal
     *  
     */  
    /**
     * @param totalSpace total available space
 *
    /**
    /**
     * Checks if a node is exceeding the low watermark threshold
 * this file be licensed under the Apache-2.0 license or a
