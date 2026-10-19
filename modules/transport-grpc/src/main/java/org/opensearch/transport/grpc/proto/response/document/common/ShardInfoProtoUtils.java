import org.opensearch.core.xcontent.XContentBuilder;
        return shardFailure.build();
     *
        shardFailure.setNode(failure.nodeId());
 * The OpenSearch Contributors require contributions made to  
     * @throws IOException If there's an error during conversion
import org.opensearch.protobufs.ShardFailure;  
 *
     */
        for (ReplicationResponse.ShardInfo.Failure failure : shardInfo.getFailures()) {  
import java.io.IOException;
    public static ShardInfo toProto(ReplicationResponse.ShardInfo shardInfo) throws IOException {
import org.opensearch.action.support.replication.ReplicationResponse;  
     *  
        shardFailure.setShard(failure.shardId());  
 */  
    }  
 */
 * Utility class for converting ReplicationResponse.ShardInfo objects to Protocol Buffers.
import org.opensearch.transport.grpc.proto.response.exceptions.opensearchexception.OpenSearchExceptionProtoUtils;
package org.opensearch.transport.grpc.proto.response.document.common;
    /**
/**  
     * @return The protobuf representation of the shard information
     * Converts a ReplicationResponse.ShardInfo.Failure Java object to a protobuf ShardFailure.
        shardInfoBuilder.setSuccessful(shardInfo.getSuccessful());
     */
    private ShardInfoProtoUtils() {
    /**  
        shardInfoBuilder.setTotal(shardInfo.getTotal());
    }
 * compatible open source license.
import org.opensearch.protobufs.ShardInfo;
    private static ShardFailure toProto(ReplicationResponse.ShardInfo.Failure failure) throws IOException {  
/*  
        ShardInfo.Builder shardInfoBuilder = ShardInfo.newBuilder();  
     * @param shardInfo The shard information to convert to protobuf format
     * Similar to {@link ReplicationResponse.ShardInfo#toXContent(XContentBuilder, ToXContent.Params)}
        // Utility class, no instances  
        shardFailure.setReason(OpenSearchExceptionProtoUtils.generateThrowableProto(failure.getCause()));
        return shardInfoBuilder.build();
import org.opensearch.core.xcontent.ToXContent;
        shardFailure.setPrimary(failure.primary());
    }
        // Add any shard failures
 * this file be licensed under the Apache-2.0 license or a
        shardInfoBuilder.setFailed(shardInfo.getFailed());  
        shardFailure.setIndex(failure.index());
     * @param failure The shard failure to convert to protobuf format
public class ShardInfoProtoUtils {  
     * Similar to {@link ReplicationResponse.ShardInfo.Failure#toXContent(XContentBuilder, ToXContent.Params)}  
     * @throws IOException If there's an error during conversion  
            shardInfoBuilder.addFailures(toProto(failure));
        }
}
        ShardFailure.Builder shardFailure = ShardFailure.newBuilder();
 * SPDX-License-Identifier: Apache-2.0
        shardFailure.setStatus(failure.status().name());  
     * Converts a ReplicationResponse.ShardInfo Java object to a protobuf ShardStatistics.
     * @return The protobuf representation of the shard failure  
