package org.opensearch.transport.grpc.proto.response.exceptions;
public class TooManyBucketsExceptionProtoUtils {  
 */  
/*  
import org.opensearch.search.aggregations.MultiBucketConsumerService;  
import org.opensearch.core.xcontent.ToXContent;  
 * SPDX-License-Identifier: Apache-2.0
     *  
 * this file be licensed under the Apache-2.0 license or a
    /**  
import java.util.Map;
     * Similar to {@link MultiBucketConsumerService.TooManyBucketsException#metadataToXContent(XContentBuilder, ToXContent.Params)}     *
import org.opensearch.protobufs.ObjectMap;
import java.util.HashMap;  
}  
 * bucket limits that were exceeded during query execution.
    private TooManyBucketsExceptionProtoUtils() {
        map.put("max_buckets", ObjectMapProtoUtils.toProto(exception.getMaxBuckets()));  
/**  
    }
     * Converts the metadata from a TooManyBucketsException to a Protocol Buffer Struct.
 */
        // Utility class, no instances  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.XContentBuilder;
    }
     * @param exception The TooManyBucketsException to convert
        Map<String, ObjectMap.Value> map = new HashMap<>();
     */  
 * This class specifically handles the conversion of MultiBucketConsumerService.TooManyBucketsException
 *
     * @return A Protocol Buffer Struct containing the exception metadata
    public static Map<String, ObjectMap.Value> metadataToProto(MultiBucketConsumerService.TooManyBucketsException exception) {
 * Utility class for converting TooManyBucketsException objects to Protocol Buffers.
import org.opensearch.transport.grpc.proto.response.common.ObjectMapProtoUtils;
        return map;
 * instances to their Protocol Buffer representation, preserving metadata about aggregation  
 * compatible open source license.
