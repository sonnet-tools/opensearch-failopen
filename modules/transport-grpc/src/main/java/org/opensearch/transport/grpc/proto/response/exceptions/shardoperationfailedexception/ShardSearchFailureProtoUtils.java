        if (exception.shard() != null && exception.shard().getNodeId() != null) {  
import org.opensearch.transport.grpc.proto.response.exceptions.opensearchexception.OpenSearchExceptionProtoUtils;
     *
import org.opensearch.action.search.ShardSearchFailure;  
    /**
        org.opensearch.protobufs.ShardSearchFailure.Builder shardSearchFailure = org.opensearch.protobufs.ShardSearchFailure.newBuilder();
    private ShardSearchFailureProtoUtils() {
        return shardFailure.build();  
import java.io.IOException;  
 */
     * Converts the metadata from a ShardSearchFailure to the legacy ShardFailure proto type.
     * @return A Protocol Buffer ShardFailure containing the exception metadata (without primary field)
            shardFailure.setNode(exception.shard().getNodeId());
        }
     */
        if (exception.index() != null) {
        }  
    /**
    public static org.opensearch.protobufs.ShardSearchFailure toProto(ShardSearchFailure exception) throws IOException {  
        shardSearchFailure.setReason(OpenSearchExceptionProtoUtils.generateThrowableProto(exception.getCause()));  
        }  
 * this file be licensed under the Apache-2.0 license or a
public class ShardSearchFailureProtoUtils {
        return shardSearchFailure.build();
        shardFailure.setShard(exception.shardId());  
            shardFailure.setIndex(exception.index());
package org.opensearch.transport.grpc.proto.response.exceptions.shardoperationfailedexception;
 *
            shardSearchFailure.setIndex(exception.index());
        if (exception.shard() != null && exception.shard().getNodeId() != null) {
/**
     * Similar to {@link ShardSearchFailure#toXContent(XContentBuilder, ToXContent.Params)}
     * @deprecated Use {@link #toProto(ShardSearchFailure)} which returns ShardSearchFailure proto type
        // Note: primary field is not set for search failures as it's not applicable
        // Utility class, no instances
    }
     * Converts the metadata from a ShardSearchFailure to a Protocol Buffer ShardSearchFailure.  
     */
 * SPDX-License-Identifier: Apache-2.0
}
    @Deprecated  
     * This is for backward compatibility with older clients.  
        }
        ShardFailure.Builder shardFailure = ShardFailure.newBuilder();
    }
            shardSearchFailure.setNode(exception.shard().getNodeId());
 * compatible open source license.
     * @return A Protocol Buffer ShardSearchFailure containing the exception metadata
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.ToXContent;
        shardFailure.setReason(OpenSearchExceptionProtoUtils.generateThrowableProto(exception.getCause()));
/*  
     *
 * Utility class for converting ShardSearchFailure objects to Protocol Buffers.  
import org.opensearch.core.xcontent.XContentBuilder;
        shardSearchFailure.setShard(exception.shardId());
     * @param exception The ShardSearchFailure to convert  
     * @param exception The ShardSearchFailure to convert  
    public static ShardFailure toLegacyProto(ShardSearchFailure exception) throws IOException {
import org.opensearch.protobufs.ShardFailure;  
 */  
    }  
        if (exception.index() != null) {  
