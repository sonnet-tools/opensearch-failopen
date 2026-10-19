    String getShardId();
    /**
     * @param blockFileName the block file name  
    /**
 * compatible open source license.
    void recordPrefetch(String fileName, int blockId);
     * Records a prefetch event.  
 * The OpenSearch Contributors require contributions made to  
    /** Records the end time of the metric collection. */
 *
    void recordFileAccess(String blockFileName, boolean hit);  
/**  
     */  
     */
 */  
     * Records a read-ahead event.
     * Returns the parent task id.
    /**
public interface TieredStoragePerQueryMetric extends Accountable {
 *
package org.opensearch.storage.slowlogs;
     */
     * @param fileName the file name
     */
import org.apache.lucene.util.Accountable;
     * @param blockId the block id
 * @opensearch.experimental  
    void recordReadAhead(String fileName, int blockId);
 */
}  
    /**  
    /**
    String getParentTaskId();
     * @param fileName the file name
    void recordEndTime();
 * SPDX-License-Identifier: Apache-2.0
     * @param hit whether the access was a cache hit
     * @param blockId the block id  
     * Returns the shard id.
 * this file be licensed under the Apache-2.0 license or a
 * Interface that needs to be implemented by any per query metric collector.
     * @return the parent task id  
     * Records a file access event.
     */
     * @return the shard id  
/*  
