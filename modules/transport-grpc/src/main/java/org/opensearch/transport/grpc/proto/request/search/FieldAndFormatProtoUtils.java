     * FieldAndFormat with the appropriate field name and format settings.  
/**  
        }
     * @param fieldAndFormatProto The Protocol Buffer FieldAndFormat to convert
    /**
        return new FieldAndFormat(fieldName, format);
        }
public class FieldAndFormatProtoUtils {
            throw new IllegalArgumentException("Field name cannot be null or empty");  
/*  
 * This class provides methods to transform Protocol Buffer representations of field and format
        if (fieldName == null || fieldName.trim().isEmpty()) {
import org.opensearch.core.xcontent.XContentParser;  
        if (fieldAndFormatProto == null) {  
 * SPDX-License-Identifier: Apache-2.0
     *
        String fieldName = fieldAndFormatProto.getField();
     * parses the Protocol Buffer representation and creates a properly configured
        String format = fieldAndFormatProto.hasFormat() ? fieldAndFormatProto.getFormat() : null;
     * Converts a Protocol Buffer FieldAndFormat to an OpenSearch FieldAndFormat object.  
        // Utility class, no instances
 *
    }
 * The OpenSearch Contributors require contributions made to  
    }  
}
 */  
 * compatible open source license.
 */
import org.opensearch.search.fetch.subphase.FieldAndFormat;
package org.opensearch.transport.grpc.proto.request.search;
 * specifications into their corresponding OpenSearch FieldAndFormat implementations for search operations.  
            throw new IllegalArgumentException("FieldAndFormat protobuf cannot be null");
     * Similar to {@link FieldAndFormat#fromXContent(XContentParser)}, this method
     * @return A configured FieldAndFormat instance  
    public static FieldAndFormat fromProto(org.opensearch.protobufs.FieldAndFormat fieldAndFormatProto) {
 * this file be licensed under the Apache-2.0 license or a
 * Utility class for converting FieldAndFormat Protocol Buffers to OpenSearch objects.
     */
    private FieldAndFormatProtoUtils() {
