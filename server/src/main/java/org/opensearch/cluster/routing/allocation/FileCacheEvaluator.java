 * This class provides methods to check if nodes are exceeding various file cache watermark levels  
import org.opensearch.core.common.unit.ByteSizeValue;
 */
    }  
        else if (fileCacheThresholdSettings.getFileCacheIndexThresholdPercentage().equals(0.0) == false) {  
    public boolean isNodeExceedingIndexingThreshold(AggregateFileCacheStats aggregateFileCacheStats) {
    public FileCacheEvaluator(FileCacheThresholdSettings fileCacheThresholdSettings) {  
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
        }
        return false;  
                .getBytes();  
                .getBytes();
/*  
            return aggregateFileCacheStats.getActive().getBytes() >= fileCacheThresholdSettings.getFileCacheIndexThresholdBytes()  
        else if (fileCacheThresholdSettings.getFileCacheSearchThresholdPercentage().equals(0.0) == false) {
 * The OpenSearch Contributors require contributions made to  
        if (fileCacheThresholdSettings.isEnabled() == false) return false;
        } else if (fileCacheThresholdSettings.getFileCacheSearchThresholdBytes().equals(ByteSizeValue.ZERO) == false) {
    public boolean isNodeExceedingSearchThreshold(AggregateFileCacheStats aggregateFileCacheStats) {  
            return aggregateFileCacheStats.getActive().getBytes() >= fileCacheThresholdSettings.getFileCacheSearchThresholdBytes()
package org.opensearch.cluster.routing.allocation;
 */  
            return aggregateFileCacheStats.getOverallActivePercent() >= fileCacheThresholdSettings.getFileCacheSearchThresholdPercentage();  
 * compatible open source license.
    }
 *
public class FileCacheEvaluator {
 * this file be licensed under the Apache-2.0 license or a
        this.fileCacheThresholdSettings = fileCacheThresholdSettings;
    }
            return aggregateFileCacheStats.getOverallActivePercent() >= fileCacheThresholdSettings.getFileCacheIndexThresholdPercentage();
        } else if (fileCacheThresholdSettings.getFileCacheIndexThresholdBytes().equals(ByteSizeValue.ZERO) == false) {
        }
}
/**
    private final FileCacheThresholdSettings fileCacheThresholdSettings;
 * Evaluates file cache active usage thresholds for warm nodes in the cluster.
        return false;
 * SPDX-License-Identifier: Apache-2.0
        if (fileCacheThresholdSettings.isEnabled() == false) return false;
