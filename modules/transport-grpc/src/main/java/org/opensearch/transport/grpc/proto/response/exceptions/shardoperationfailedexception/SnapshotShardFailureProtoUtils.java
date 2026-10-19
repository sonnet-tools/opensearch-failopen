 * Utility class for converting SnapshotShardFailure objects to Protocol Buffers.  
import org.opensearch.core.xcontent.XContentBuilder;
     * @param exception The SnapshotShardFailure to convert  
 * this file be licensed under the Apache-2.0 license or a
        // shardFailure.setReason(exception.reason()); // TODO ErrorCause type in ShardFailure, not string
        // shardFailure.setIndexUuid(exception.index()); // TODO no field called index_uuid in ShardFailure protos  
}
        // Utility class, no instances
        shardFailure.setShard(exception.shardId());
import org.opensearch.core.xcontent.ToXContent;  
 * The OpenSearch Contributors require contributions made to  
/**
package org.opensearch.transport.grpc.proto.response.exceptions.shardoperationfailedexception;
        shardFailure.setStatus(exception.status().name());
        shardFailure.setNode(exception.nodeId());
public class SnapshotShardFailureProtoUtils {
     * Similar to {@link SnapshotShardFailure#toXContent(XContentBuilder, ToXContent.Params)}     *
     */
import org.opensearch.snapshots.SnapshotShardFailure;  
 * compatible open source license.
     *
     * Converts the metadata from a SnapshotShardFailure to a Protocol Buffer Struct.  
        shardFailure.setIndex(exception.index());  
/*  
 * SPDX-License-Identifier: Apache-2.0
 */
     * @return A Protocol Buffer Struct containing the exception metadata
    }
    public static ShardFailure toProto(SnapshotShardFailure exception) {  
    /**
 */  
        ShardFailure.Builder shardFailure = ShardFailure.newBuilder();
        return shardFailure.build();  
 *
    }  
import org.opensearch.protobufs.ShardFailure;
        shardFailure.setIndex(exception.index());
    private SnapshotShardFailureProtoUtils() {
