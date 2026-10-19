    }  
        if (strValue == null) {
    /**
/*  
    /**
 * {@link BalancedShardsAllocator#SHARD_MOVEMENT_STRATEGY_SETTING} via cluster settings.
@PublicApi(since = "2.9.0")
     */  
 * The OpenSearch Contributors require contributions made to  
            return null;  
        } else {
    }
 * this file be licensed under the Apache-2.0 license or a
}
            } catch (IllegalArgumentException e) {
     * default behavior in which order of shard movement doesn't matter.
import java.util.Locale;
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
            }
 *
 * @opensearch.api  
        }
/**  
     */
 */  
     * replica shards are moved first  
 * ShardMovementStrategy defines the order in which shard movement occurs.
    /**  
     * primary shards are moved first
                throw new IllegalArgumentException("Illegal allocation.shard_movement_strategy value [" + strValue + "]");  
 * compatible open source license.
    public static ShardMovementStrategy parse(String strValue) {
package org.opensearch.cluster.routing;
 *
     */
    REPLICA_FIRST;
                return ShardMovementStrategy.valueOf(strValue);
            try {  
 * ShardMovementStrategy values or rather their string representation to be used with  
    PRIMARY_FIRST,  
    NO_PREFERENCE,
 * <p>
import org.opensearch.common.annotation.PublicApi;
public enum ShardMovementStrategy {  
 * SPDX-License-Identifier: Apache-2.0
        return name().toLowerCase(Locale.ROOT);
    public String toString() {  
 */
            strValue = strValue.toUpperCase(Locale.ROOT);
    @Override
