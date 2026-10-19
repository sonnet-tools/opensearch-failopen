 * this file be licensed under the Apache-2.0 license or a
        }  
                    case WAIT_FOR_ACTIVE_SHARD_OPTIONS_NULL:
     */
                }  
                return ActiveShardCount.DEFAULT;
     *  
 * SPDX-License-Identifier: Apache-2.0
     * the wait_for_active_shards parameter from the Protocol Buffer request and applies
            default:
    }
            case COUNT:
 */  
}
                        return ActiveShardCount.DEFAULT;
     * Private constructor to prevent instantiation of utility class.
                return ActiveShardCount.from(waitForActiveShards.getCount());
 * and OpenSearch ActiveShardCount objects.
        // Utility class, no instances
 *
package org.opensearch.transport.grpc.proto.request.document.bulk;
/**
 * This class provides methods to convert between Protocol Buffer representations  
 * Utility class for handling active shard count settings in gRPC bulk requests.
 * The OpenSearch Contributors require contributions made to  
                    case WAIT_FOR_ACTIVE_SHARD_OPTIONS_ALL:  
    public static ActiveShardCount parseProto(WaitForActiveShards waitForActiveShards) {
        switch (waitForActiveShards.getWaitForActiveShardsCase()) {  
    private ActiveShardCountProtoUtils() {  
            case WAITFORACTIVESHARDS_NOT_SET:  
     * Sets the active shard count on the bulk request based on the protobuf request.
     * @param waitForActiveShards The protobuf object containing the active shard count
    }
                        return ActiveShardCount.ALL;
     */  
 */
     * @return The modified bulk request
                switch (waitForActiveShards.getOption()) {
     * the appropriate ActiveShardCount setting to the OpenSearch bulk request.
public class ActiveShardCountProtoUtils {  
    // protected final Settings settings;
    /**
                    case WAIT_FOR_ACTIVE_SHARD_OPTIONS_UNSPECIFIED:  
    /**  
 * compatible open source license.
import org.opensearch.protobufs.WaitForActiveShards;
/*  
                    default:
import org.opensearch.action.support.ActiveShardCount;
     * Similar to {@link ActiveShardCount#parseString(String)}, this method interprets  
            case OPTION:
