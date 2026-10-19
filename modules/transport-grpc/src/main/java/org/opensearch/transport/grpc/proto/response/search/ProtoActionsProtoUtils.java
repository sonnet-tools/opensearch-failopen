 */  
     * Similar to {@link RestActions#buildBroadcastShardsHeader(XContentBuilder, ToXContent.Params, int, int, int, int, ShardOperationFailedException[])}  
import org.opensearch.protobufs.SearchResponse;
     * @param skipped the number of skipped shards
     * @throws IOException if there's an error during conversion
    }  
import org.opensearch.core.action.ShardOperationFailedException;
     * @param successful the number of successful shards
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.ToXContent;
     */  
 *
        ShardOperationFailedException[] shardFailures
package org.opensearch.transport.grpc.proto.response.search;
 * Utility class for converting REST-like actions between OpenSearch and Protocol Buffers formats.
     * @param shardFailures the array of shard operation failures
        SearchResponse.Builder searchResponseProtoBuilder,
import org.opensearch.core.xcontent.XContentBuilder;  
        int total,  
        // Utility class, no instances
        searchResponseProtoBuilder.setXShards(ShardStatisticsProtoUtils.getShardStats(total, successful, skipped, failed, shardFailures));  
import org.opensearch.rest.action.RestActions;
}
     * @param total the total number of shards  
 * compatible open source license.
import java.io.IOException;
    ) throws IOException {
        int failed,  
 * this file be licensed under the Apache-2.0 license or a
        int skipped,
     *
 * broadcast headers to ensure proper communication between the OpenSearch server and gRPC clients.  
    protected static void buildBroadcastShardsHeader(
 */
     * @param failed the number of failed shards  
 * The OpenSearch Contributors require contributions made to  
 * This class provides methods to transform response components such as shard statistics and
public class ProtoActionsProtoUtils {
     * @param searchResponseProtoBuilder the response builder to populate with shard statistics
    /**
/**  
        int successful,
/*  
    }
    private ProtoActionsProtoUtils() {
