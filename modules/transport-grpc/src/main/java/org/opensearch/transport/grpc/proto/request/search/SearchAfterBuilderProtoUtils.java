        return values.toArray();
package org.opensearch.transport.grpc.proto.request.search;
/*  
 * The OpenSearch Contributors require contributions made to  
        for (FieldValue fieldValue : searchAfterProto) {  
            } else if (fieldValue.hasString()) {  
import java.io.IOException;
                    values.add(number.getInt32Value());
                } else if (number.hasFloatValue()) {
     * that can be used for search_after pagination.  
 */  
     * Similar to {@link SearchAfterBuilder#fromXContent(XContentParser)}, this method
            if (fieldValue.hasGeneralNumber()) {
    }
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.searchafter.SearchAfterBuilder;
import java.util.ArrayList;
                values.add(null);
                    values.add(number.getInt64Value());
import org.opensearch.core.xcontent.XContentParser;  
     */
    private SearchAfterBuilderProtoUtils() {  
     * parses the Protocol Buffer representation and creates an array of values
        }
                }
            } else if (fieldValue.hasBool()) {
     * @param searchAfterProto The list of Protocol Buffer FieldValue objects to convert
/**
 * compatible open source license.
     * that can be used for search_after pagination.  
}
                org.opensearch.protobufs.GeneralNumber number = fieldValue.getGeneralNumber();
                    values.add(number.getFloatValue());  
                values.add(fieldValue.getString());
 * Utility class for converting SearchAfterBuilder Protocol Buffers to OpenSearch objects.  
            } else if (fieldValue.hasNullValue()) {
    }  
     *
            }  
    /**
 * values into their corresponding OpenSearch object arrays for pagination in search operations.
import org.opensearch.protobufs.FieldValue;
                values.add(fieldValue.getBool());  
     * @throws IOException if there's an error during parsing or conversion
import java.util.List;  
    protected static Object[] fromProto(List<FieldValue> searchAfterProto) throws IOException {  
        List<Object> values = new ArrayList<>();
                } else if (number.hasInt64Value()) {
                if (number.hasDoubleValue()) {  
 */  
 *
 * This class provides methods to transform Protocol Buffer representations of search_after
        // Utility class, no instances
public class SearchAfterBuilderProtoUtils {
                } else if (number.hasInt32Value()) {  
     * @return An array of Java objects representing the search_after values  
     * Converts a list of Protocol Buffer FieldValue objects to an array of Java objects
                    values.add(number.getDoubleValue());
