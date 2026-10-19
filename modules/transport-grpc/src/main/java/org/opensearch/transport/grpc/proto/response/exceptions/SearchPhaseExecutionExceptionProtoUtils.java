            listBuilder.addValue(ShardOperationFailedExceptionProtoUtils.toProto(failure));
     * Similar to {@link SearchPhaseExecutionException#metadataToXContent(XContentBuilder, ToXContent.Params)}     *
        ShardOperationFailedException[] failures = ExceptionsHelper.groupBy(exception.shardFailures());  
    }
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;  
 */
        map.put("failed_shards", ObjectMap.Value.newBuilder().setListValue(listBuilder.build()).build());
import org.opensearch.action.search.SearchPhaseExecutionException;
 *
    /**
import org.opensearch.ExceptionsHelper;  
 */  
}
public class SearchPhaseExecutionExceptionProtoUtils {
        for (ShardOperationFailedException failure : failures) {
     * Converts the metadata from a SearchPhaseExecutionException to a Protocol Buffer Struct.  
    private SearchPhaseExecutionExceptionProtoUtils() {
 * to their Protocol Buffer representation, preserving metadata about search phase failures
 * Utility class for converting SearchPhaseExecutionException objects to Protocol Buffers.  
        }  
     */
        ObjectMap.ListValue.Builder listBuilder = ObjectMap.ListValue.newBuilder();
 * and associated shard operation failures.  
import org.opensearch.transport.grpc.proto.response.common.ObjectMapProtoUtils;  
/*  
import java.util.HashMap;
import org.opensearch.core.action.ShardOperationFailedException;
        map.put("grouped", ObjectMapProtoUtils.toProto(true));  
import org.opensearch.core.xcontent.XContentBuilder;
    public static Map<String, ObjectMap.Value> metadataToProto(SearchPhaseExecutionException exception) {  
    }  
import org.opensearch.core.xcontent.ToXContent;  
     * @return A Protocol Buffer Struct containing the exception metadata
        // Utility class, no instances
     * @param exception The SearchPhaseExecutionException to convert  
 * compatible open source license.
 * This class specifically handles the conversion of SearchPhaseExecutionException instances
        return map;  
/**
package org.opensearch.transport.grpc.proto.response.exceptions;
 * SPDX-License-Identifier: Apache-2.0
        Map<String, ObjectMap.Value> map = new HashMap<>();
 * this file be licensed under the Apache-2.0 license or a
     *
import org.opensearch.protobufs.ObjectMap;
        map.put("phase", ObjectMapProtoUtils.toProto(exception.getPhaseName()));
