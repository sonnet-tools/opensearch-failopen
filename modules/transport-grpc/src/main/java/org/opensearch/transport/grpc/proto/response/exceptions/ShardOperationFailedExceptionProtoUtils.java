        // Utility class, no instances
 * to their Protocol Buffer representation, which represent failures that occur during
package org.opensearch.transport.grpc.proto.response.exceptions;
}
    private ShardOperationFailedExceptionProtoUtils() {
public class ShardOperationFailedExceptionProtoUtils {
    /**
 * SPDX-License-Identifier: Apache-2.0
    public static ObjectMap.Value toProto(ShardOperationFailedException exception) {
     * @return A Protocol Buffer Value representing the exception (currently empty)
        return ObjectMap.Value.newBuilder().build();
     *  
 * compatible open source license.
import org.opensearch.core.xcontent.ToXContent;
     * @param exception The ShardOperationFailedException to convert
/**
 * operations on specific shards in an OpenSearch cluster.  
 *
 * this file be licensed under the Apache-2.0 license or a
     * This method is similar to {@link ShardOperationFailedException#toXContent(XContentBuilder, ToXContent.Params)}
 */
     * TODO why is ShardOperationFailedException#toXContent() empty?
 */  
import org.opensearch.core.xcontent.XContentBuilder;
 * The OpenSearch Contributors require contributions made to  
 * Utility class for converting ShardOperationFailedException objects to Protocol Buffers.  
 * This class specifically handles the conversion of ShardOperationFailedException instances
     */  
     * Converts a ShardOperationFailedException to a Protocol Buffer Value.  
    }  
import org.opensearch.core.action.ShardOperationFailedException;  
import org.opensearch.protobufs.ObjectMap;  
/*  
    }  
