import org.opensearch.core.xcontent.XContentBuilder;  
        ShardOperationFailedException[] shardFailures
        shardStats.setTotal(total);
/*  
import org.opensearch.transport.grpc.proto.response.exceptions.shardoperationfailedexception.ShardSearchFailureProtoUtils;  
     * @return A Protocol Buffer ShardStatistics representation  
     * @throws IOException if there's an error during conversion
                }
     * @param shardFailures the array of shard operation failures
     * @param successful the number of successful shards
 * SPDX-License-Identifier: Apache-2.0
            for (ShardOperationFailedException shardFailure : ExceptionsHelper.groupBy(shardFailures)) {  
    ) throws IOException {  
     */
public class ShardStatisticsProtoUtils {  
                shardStats.addFailures(ShardOperationFailedExceptionProtoUtils.toProto(shardFailure));
 * Protocol Buffer representation.
        ShardStatistics.Builder shardStats = ShardStatistics.newBuilder();
import org.opensearch.transport.grpc.proto.response.exceptions.shardoperationfailedexception.ShardOperationFailedExceptionProtoUtils;
import org.opensearch.core.xcontent.ToXContent;
 *
     * @param total the total number of shards
 */  
        }  
            }
 * This class handles the conversion of search operation responses to their  
        // Utility class, no instances  
    private ShardStatisticsProtoUtils() {
        int failed,
            shardStats.setSkipped(skipped);
import org.opensearch.action.search.ShardSearchFailure;
}
 * this file be licensed under the Apache-2.0 license or a
                    shardStats.addFailures2(ShardSearchFailureProtoUtils.toProto((ShardSearchFailure) shardFailure));  
     * This method is equivalent to {@link ShardStats#toXContent(XContentBuilder, ToXContent.Params)}
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.action.ShardOperationFailedException;  
                // Also populate the deprecated failures field for backward compatibility  
 * compatible open source license.
        if (skipped >= 0) {
        }  
        int total,
    }
        int skipped,  
    protected static ShardStatistics getShardStats(  
                if (shardFailure instanceof ShardSearchFailure) {
package org.opensearch.transport.grpc.proto.response.search;
import java.io.IOException;
     * Converts shard statistics information to its Protocol Buffer representation.
    /**  
        shardStats.setFailed(failed);
        shardStats.setSuccessful(successful);  
 * Utility class for converting ShardStatistics objects to Protocol Buffers.
     *  
    }
/**
import org.opensearch.protobufs.ShardStatistics;
     * @param skipped the number of skipped shards  
        int successful,
import org.opensearch.core.common.util.CollectionUtils;
import org.opensearch.action.admin.indices.stats.ShardStats;
        return shardStats.build();
import org.opensearch.ExceptionsHelper;  
 */
                // Populate the new failures_2 field with ShardSearchFailure proto type
     * @param failed the number of failed shards
        if (CollectionUtils.isEmpty(shardFailures) == false) {
