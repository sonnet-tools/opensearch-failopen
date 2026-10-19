     * @param exception The ShardOperationFailedException to convert metadata from  
            case ReplicationResponse.ShardInfo.Failure sf -> ReplicationResponseShardInfoFailureProtoUtils.toProto(sf);
}
import org.opensearch.core.action.ShardOperationFailedException;
    }
        // Utility class, no instances
            );
                "Unsupported ShardOperationFailedException [null] cannot be converted to proto."
            case DefaultShardOperationFailedException dsofe -> DefaultShardOperationFailedExceptionProtoUtils.toProto(dsofe);
    /**
import org.opensearch.core.xcontent.XContentBuilder;
 * SPDX-License-Identifier: Apache-2.0
            );
 */  
        return switch (exception) {
    public static ShardFailure toProto(ShardOperationFailedException exception) throws IOException {  
    private ShardOperationFailedExceptionProtoUtils() {
public class ShardOperationFailedExceptionProtoUtils {
                "Unsupported ShardOperationFailedException " + exception.getClass().getName() + "cannot be converted to proto."
     *
 * compatible open source license.
     * This method converts to the legacy ShardFailure proto type for backward compatibility.  
     * For ShardSearchFailure, use the new failures_2 field with ShardSearchFailure proto type.
import java.io.IOException;  
 */
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
     */
    }  
 * The OpenSearch Contributors require contributions made to  
/**
/*  
import org.opensearch.core.xcontent.ToXContent;
     * This method is overridden by various exception classes, which are hardcoded here.
        };  
     *
            case ShardSearchFailure ssf -> ShardSearchFailureProtoUtils.toLegacyProto(ssf);
            default -> throw new UnsupportedOperationException(  
import org.opensearch.action.support.replication.ReplicationResponse;
 * Utility class for converting ShardOperationFailedException objects to Protocol Buffers.  
     * @return ShardFailure proto object
import org.opensearch.protobufs.ShardFailure;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.snapshots.SnapshotShardFailure;
            case null -> throw new UnsupportedOperationException(  
 *
package org.opensearch.transport.grpc.proto.response.exceptions.shardoperationfailedexception;
import org.opensearch.action.search.ShardSearchFailure;  
     * This method is similar to {@link org.opensearch.core.action.ShardOperationFailedException#toXContent(XContentBuilder, ToXContent.Params)}  
            case SnapshotShardFailure ssf -> SnapshotShardFailureProtoUtils.toProto(ssf);  
