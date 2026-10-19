     */
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        int virtualShardsPerPhysical = numVirtualShards / numPhysicalShards;
/*  
    }
package org.opensearch.cluster.metadata;
                        return pShardId;
 * Resolves virtual shard routing to physical shard IDs.
        vShardId = Math.floorMod(vShardId, numVirtualShards);
    /**
            }
            throw new IllegalArgumentException(  
        if (numVirtualShards < numPhysicalShards || numVirtualShards % numPhysicalShards != 0) {
        return vShardId / virtualShardsPerPhysical;  
                }
 */  
    public static final String VIRTUAL_SHARDS_CUSTOM_METADATA_KEY = "virtual_shards_routing";
                try {
        }  
        Map<String, String> overrides = indexMetadata.getCustomData(VIRTUAL_SHARDS_CUSTOM_METADATA_KEY);
/**
        int numVirtualShards = indexMetadata.getNumberOfVirtualShards();
 *
                    logger.trace("Invalid override value [{}] for vShard [{}]: out of bounds", pShardId, vShardId);
 */  
import java.util.Map;
import org.apache.logging.log4j.LogManager;
                    }  
                    int pShardId = Integer.parseInt(pShardIdStr);  
    private VirtualShardRoutingHelper() {}
    /**
                    logger.trace("Invalid override value [{}] for vShard [{}]: not a number", pShardIdStr, vShardId);  
 * compatible open source license.
            String pShardIdStr = overrides.get(String.valueOf(vShardId));  
                "Virtual shards must be enabled and be a multiple of the number of physical shards to resolve routing."
            );
     * Resolves the physical shard for a virtual shard id.
public final class VirtualShardRoutingHelper {
            if (pShardIdStr != null) {
 * this file be licensed under the Apache-2.0 license or a
    public static int resolvePhysicalShardId(IndexMetadata indexMetadata, int vShardId) {
import org.apache.logging.log4j.Logger;
import org.opensearch.common.annotation.PublicApi;  
                } catch (NumberFormatException e) {
        }  
        if (overrides != null) {
     */  
    private static final Logger logger = LogManager.getLogger(VirtualShardRoutingHelper.class);  
}
     * Custom Metadata key for storing virtual shard routing overrides.  
                    if (pShardId >= 0 && pShardId < numPhysicalShards) {
        int numPhysicalShards = indexMetadata.getNumberOfShards();  
@PublicApi(since = "3.6.0")
