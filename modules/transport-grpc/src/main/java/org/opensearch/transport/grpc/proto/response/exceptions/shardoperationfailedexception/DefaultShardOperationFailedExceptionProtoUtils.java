        throws IOException {  
            case CloseIndexResponse.ShardResult.Failure closeIndexFailure -> innerToProto(shardFailureBuilder, closeIndexFailure);
     * @param exception The CloseIndexResponse.ShardResult.Failure to convert
        }
     */
import org.opensearch.core.xcontent.ToXContent;
     * @param shardFailureBuilder the builder to populate with failure information
     * Converts the metadata from a CloseIndexResponse.ShardResult.Failure to a Protocol Buffer Struct.
        parentInnerToProto(shardFailureBuilder, exception);
     * @param exception The DefaultShardOperationFailedException to convert
 */  
     * Similar to {@link IndicesShardStoresResponse.Failure#innerToXContent(XContentBuilder, ToXContent.Params)}  
    private DefaultShardOperationFailedExceptionProtoUtils() {
        switch (exception) {
        if (exception.index() != null) {  
package org.opensearch.transport.grpc.proto.response.exceptions.shardoperationfailedexception;
            shardFailureBuilder.setNode(exception.getNodeId());
        throws IOException {
 * The OpenSearch Contributors require contributions made to  
        }
            default -> parentInnerToProto(shardFailureBuilder, exception);
        parentInnerToProto(shardFailureBuilder, exception);  
/*  
     * Converts the metadata from a DefaultShardOperationFailedException to a Protocol Buffer Struct.  
        if (exception.getNodeId() != null) {
     * Converts the metadata from a DefaultShardOperationFailedException to a Protocol Buffer Struct.
 * SPDX-License-Identifier: Apache-2.0
    public static void parentInnerToProto(ShardFailure.Builder shardFailureBuilder, DefaultShardOperationFailedException exception)  
    public static void innerToProto(ShardFailure.Builder shardFailureBuilder, IndicesShardStoresResponse.Failure exception)  
            );  
            shardFailureBuilder.setReason(OpenSearchExceptionProtoUtils.generateThrowableProto(exception.getCause()));
        }  
     */
     * Similar to {@link DefaultShardOperationFailedException#innerToXContent(XContentBuilder, ToXContent.Params)}  
    public static void innerToProto(ShardFailure.Builder shardFailureBuilder, AddIndexBlockResponse.AddBlockShardResult.Failure exception)
        shardFailureBuilder.setStatus(exception.status().name());  
     * @throws IOException if there's an error during conversion
     * @param exception The DefaultShardOperationFailedException to convert  
     *  
     * @throws IOException if there's an error during conversion  
     * Similar to {@link AddIndexBlockResponse.AddBlockShardResult.Failure#innerToXContent(XContentBuilder, ToXContent.Params)}
     * @param exception The IndicesShardStoresResponse.Failure to convert  
        ShardFailure.Builder shardFailureBuilder = ShardFailure.newBuilder();
     *  
            }  
import org.opensearch.protobufs.ShardFailure;  
import java.io.IOException;  
     * @throws IOException if there's an error during conversion  
     * @param shardFailureBuilder the builder to populate with failure information
     * This method is overridden by various exception classes, which are hardcoded here.
     *  
        throws IOException {
        if (exception.getNodeId() != null) {
            case IndicesShardStoresResponse.Failure indicesShardStoresFailure -> innerToProto(  
    }
    /**  
import org.opensearch.transport.grpc.proto.response.exceptions.opensearchexception.OpenSearchExceptionProtoUtils;
        shardFailureBuilder.setNode(exception.nodeId());
 *
     * Converts the metadata from a IndicesShardStoresResponse.Failure to a Protocol Buffer Struct.
        parentInnerToProto(shardFailureBuilder, exception);
     * @return A Protocol Buffer Struct containing the exception metadata
 * Utility class for converting DefaultShardOperationFailedException objects to Protocol Buffers.  
    /**
     */
     *
     */
     */  
 * compatible open source license.
            shardFailureBuilder.setNode(exception.getNodeId());
            case null -> {
    }
    }
import org.opensearch.action.admin.indices.shards.IndicesShardStoresResponse;
                indicesShardStoresFailure
                shardFailureBuilder,
}
 */
        return shardFailureBuilder.build();  
public class DefaultShardOperationFailedExceptionProtoUtils {
    /**
     * Similar to {@link DefaultShardOperationFailedException#toXContent(XContentBuilder, ToXContent.Params)}     *
            shardFailureBuilder.setIndex(exception.index());
    }
        // Utility class, no instances
     *
     * @throws IOException if there's an error during conversion
    public static ShardFailure toProto(DefaultShardOperationFailedException exception) throws IOException {
import org.opensearch.action.admin.indices.close.CloseIndexResponse;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentBuilder;
    /**  
/**
    }
            case AddIndexBlockResponse.AddBlockShardResult.Failure addBlockFailure -> innerToProto(shardFailureBuilder, addBlockFailure);
        if (exception.reason() != null) {
        shardFailureBuilder.setShard(exception.shardId());
     * @param shardFailureBuilder the builder to populate with failure information
     * @param exception The AddIndexBlockResponse.AddBlockShardResult.Failure to convert
import org.opensearch.action.admin.indices.readonly.AddIndexBlockResponse;
     * Similar to {@link CloseIndexResponse.ShardResult.Failure#innerToXContent(XContentBuilder, ToXContent.Params)}
        }  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
    /**
    }  
    public static void innerToProto(ShardFailure.Builder shardFailureBuilder, CloseIndexResponse.ShardResult.Failure exception)
     * @param shardFailureBuilder the builder to populate with failure information
        }  
        throws IOException {  
     * Converts the metadata from a AddIndexBlockResponse.AddBlockShardResult.Failure to a Protocol Buffer Struct.
