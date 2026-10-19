    /**
        return indexMetadata.getSettings().getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false);
     *
 * Utility class for tiering operations
    public static boolean isWarmIndex(final IndexMetadata indexMetadata) {  
    }
/*  
 *
     * @return true if the shard is a partial shard, false otherwise
     * checking the WARM_INDEX_ENABLED_SETTING for the index.
     *  checking the WARM_INDEX_ENABLED_SETTING for its index.  
 * @opensearch.internal  
     */
 */
     *  Checks if the specified shard is a partial shard by
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.routing.ShardRouting;
package org.opensearch.action.admin.indices.tiering;
    public static boolean isPartialShard(ShardRouting shard, RoutingAllocation allocation) {  
/**  
}  
 * The OpenSearch Contributors require contributions made to  
    /**
     * @param shard ShardRouting object representing the shard
     *  see {@link #isWarmIndex(IndexMetadata)} (IndexMetadata)}
    }  
     * Checks if the specified index is a warm index by  
     * @param allocation RoutingAllocation object representing the allocation  
     * @return true if the index is a warm index, false otherwise
     */
 * compatible open source license.
        return isWarmIndex(indexMetadata);
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
        IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shard.index());
 *
 */  
public class TieringUtils {
     * @param indexMetadata the metadata of the index  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.IndexModule;
