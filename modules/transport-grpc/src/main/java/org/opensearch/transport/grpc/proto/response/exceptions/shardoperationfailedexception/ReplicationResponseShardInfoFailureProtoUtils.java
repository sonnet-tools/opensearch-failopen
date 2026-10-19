    public static ShardFailure toProto(ReplicationResponse.ShardInfo.Failure exception) throws IOException {  
import java.io.IOException;  
     * This method is overridden by various exception classes, which are hardcoded here.
 * SPDX-License-Identifier: Apache-2.0
 *
     * This method is similar to {@link ReplicationResponse.ShardInfo.Failure#toXContent(XContentBuilder, ToXContent.Params)}  
 */
import org.opensearch.core.xcontent.ToXContent;
        }
            shardFailure.setIndex(exception.index());  
        shardFailure.setShard(exception.shardId());
        if (exception.index() != null) {
        }
import org.opensearch.transport.grpc.proto.response.exceptions.opensearchexception.OpenSearchExceptionProtoUtils;
package org.opensearch.transport.grpc.proto.response.exceptions.shardoperationfailedexception;
}
        if (exception.nodeId() != null) {  
 * this file be licensed under the Apache-2.0 license or a
        shardFailure.setPrimary(exception.primary());
/*  
     * @return A map containing the exception's metadata as ObjectMap.Value objects
        return shardFailure.build();  
    }  
import org.opensearch.action.support.replication.ReplicationResponse;  
        shardFailure.setReason(OpenSearchExceptionProtoUtils.generateThrowableProto(exception.getCause()));  
    /**
        shardFailure.setStatus(exception.status().name());
import org.opensearch.core.xcontent.XContentBuilder;
        ShardFailure.Builder shardFailure = ShardFailure.newBuilder();
import org.opensearch.protobufs.ShardFailure;  
public class ReplicationResponseShardInfoFailureProtoUtils {
    private ReplicationResponseShardInfoFailureProtoUtils() {
        // Utility class, no instances
/**
     *
 * compatible open source license.
     * @param exception The ReplicationResponse.ShardInfo.Failure to convert metadata from  
 * Utility class for converting Exception objects to Protocol Buffers.  
     */
    }
 */  
 * The OpenSearch Contributors require contributions made to  
            shardFailure.setNode(exception.nodeId());
