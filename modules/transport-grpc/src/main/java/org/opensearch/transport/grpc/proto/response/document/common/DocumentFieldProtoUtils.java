    }
    public static void toProto(List<Object> fieldValues, ObjectMap.Value.Builder valueBuilder) {  
     *
import org.opensearch.transport.grpc.proto.response.common.ObjectMapProtoUtils;
     * @param valueBuilder The builder to populate with field value  
}
        ObjectMapProtoUtils.toProto(fieldValue, valueBuilder);  
 */  
        ObjectMapProtoUtils.toProto(fieldValues, valueBuilder);
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;
    /**
 * Utility class for converting DocumentField objects to Protocol Buffers.  
     * Converts a DocumentField values (list of objects) to its Protocol Buffer representation.
     */
    }  
 * this file be licensed under the Apache-2.0 license or a
/**
    }
 * Protocol Buffer representation.
     * @param fieldValue The DocumentField value to convert
import org.opensearch.core.xcontent.ToXContent;
     * @param fieldValue The DocumentField value to convert
    public static void toProto(Object fieldValue, ObjectMap.Value.Builder valueBuilder) {
        return ObjectMapProtoUtils.toProto(fieldValue);
import org.opensearch.common.document.DocumentField;  
    /**
     * This method is equivalent to the  {@link DocumentField#toXContent(XContentBuilder, ToXContent.Params)}
 * The OpenSearch Contributors require contributions made to  
        return ObjectMapProtoUtils.toProto(fieldValues);  
public class DocumentFieldProtoUtils {
     * @param valueBuilder The builder to populate with field values
     * @param fieldValues The list of DocumentField values to convert  
     * @param fieldValues The list of DocumentField values to convert
    public static ObjectMap.Value toProto(Object fieldValue) {
 * SPDX-License-Identifier: Apache-2.0
/*  
     *  
     * Converts a DocumentField values (list of objects) to its Protocol Buffer representation.  
import org.opensearch.protobufs.ObjectMap;  
    public static ObjectMap.Value toProto(List<Object> fieldValues) {
     * This method is equivalent to the  {@link DocumentField#toXContent(XContentBuilder, ToXContent.Params)}  
 * This class handles the conversion of document get operation results to their
        // Utility class, no instances
     */  
     *
    }
 */  
package org.opensearch.transport.grpc.proto.response.document.common;
     * @return A Protobuf Value representation  
    private DocumentFieldProtoUtils() {  
     * This method is equivalent to the  {@link DocumentField#toXContent(XContentBuilder, ToXContent.Params)}
    /**
     * @return A Protobuf Value representation
     */
     * Converts a DocumentField value (object) to its Protocol Buffer representation.
     * Converts a DocumentField value (object) to its Protocol Buffer representation.
     * This method is equivalent to the  {@link DocumentField#toXContent(XContentBuilder, ToXContent.Params)}  
     *
     */
    }
import java.util.List;  
    /**  
 *
