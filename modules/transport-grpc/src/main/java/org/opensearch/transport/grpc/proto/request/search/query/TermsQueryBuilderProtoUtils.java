            throw new IllegalArgumentException("Either field_value_array or lookup must be set");  
                return TermsQueryBuilder.ValueType.BITMAP;
        if (termsQueryProto.hasBoost()) {
        }
        String fieldName,
        switch (valueTypeProto) {
                return TermsQueryBuilder.ValueType.DEFAULT;
            : org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT;
 *
     * @return the OpenSearch TermsQueryBuilder.ValueType
     */  
 * compatible open source license.
        org.opensearch.protobufs.TermsQueryField termsQueryField,  
     * TermQueryBuilder with the appropriate field name, values, boost, query name,  
import org.opensearch.index.query.TermsQueryBuilder;  
        org.opensearch.protobufs.TermsQueryValueType vt = termsQueryProto.hasValueType()
/**  
            : new TermsQueryBuilder(fieldName, termsLookup);  
        if (termsQueryProto.hasXName()) {
        return values;  
    ) {
     * @param termsQueryField the protobuf oneof (field_value_array or lookup)  
    }
            ? new TermsQueryBuilder(fieldName, values)
        if (fieldName == null || fieldName.isEmpty()) {
     * @param termsQueryField the protobuf oneof (field_value_array or lookup)
            default:
        org.opensearch.protobufs.TermsQueryValueType valueTypeProto
            throw new IllegalArgumentException("TermsQuery must contain exactly one field, found: " + termsQueryProto.getTermsCount());  
     * Builds a TermsQueryBuilder from a field name, TermsQueryField oneof, and value_type.
                break;
        TermsQueryBuilder builder = fromProto(fieldName, termsQueryField, vt, registry);
    }
import org.apache.lucene.util.BytesRef;  
     * @return A configured TermQueryBuilder instance  
     *
 */
import org.opensearch.indices.TermsLookup;
        // Get the first entry from the map  
     * @param valueTypeProto the container-level value_type
     */
 * This class provides methods to transform Protocol Buffer representations of terms queries
            throw new IllegalArgumentException("TermsQuery must not be null");
     * @param valueTypeProto the Protocol Buffer TermsQueryValueType to convert
                Object v = values.get(0);
    private static List<Object> parseFieldValueArray(org.opensearch.protobufs.FieldValueArray fieldValueArray) {
        }  
            default:
            builder.queryName(termsQueryProto.getXName());
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
        }  
        return termsQueryBuilder.valueType(valueType);
     * @param termsQueryProto The Protocol Buffer TermsQuery object  
        if (fieldValueArray == null) {  
        if (termsQueryProto == null) {
                throw new IllegalArgumentException("Neither value nor lookup is set");
    /**
    /**
        List<Object> values = new ArrayList<>();
     * @param fieldValueArray the Protocol Buffer FieldValueArray to convert
     * Similar to {@link TermsQueryBuilder#fromXContent(XContentParser)}, this method
    private TermsQueryBuilderProtoUtils() {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.grpc.proto.response.common.FieldValueProtoUtils;
            case TERMS_QUERY_VALUE_TYPE_UNSPECIFIED:  
        org.opensearch.protobufs.TermsQueryField termsQueryField,  
     * @param valueTypeProto the container-level value_type  
            if (convertedValue == null) {
                values = parseFieldValueArray(termsQueryField.getValue());
                } else if (v instanceof String string) {
            case TERMS_QUERY_VALUE_TYPE_BITMAP:  
     * Converts a Protocol Buffer TermsQuery to an OpenSearch TermQueryBuilder.  
        String fieldName,
        return fromProto(termsQueryProto, null);
                termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsQueryField.getLookup(), registry);
            Object convertedValue = FieldValueProtoUtils.fromProto(fieldValue);  
    /**
     * Parses a protobuf FieldValueArray to a List of Objects
            ? termsQueryProto.getValueType()  
                throw new IllegalArgumentException("Bitmap type requires a single base64 value or a lookup");  
                throw new IllegalArgumentException("No value specified for terms query");
     * and value type settings.
                break;
 * SPDX-License-Identifier: Apache-2.0
        if (values == null && termsLookup == null) {
                    values.set(0, new BytesArray(decoded));
     * @param termsQueryProto The Protocol Buffer TermsQuery object  
 * this file be licensed under the Apache-2.0 license or a
        switch (termsQueryField.getTermsQueryFieldCase()) {
        }  
class TermsQueryBuilderProtoUtils {
        TermsQueryBuilder termsQueryBuilder = (values != null)
        // Apply boost and queryName if provided  
            case TERMSQUERYFIELD_NOT_SET:  
    }
                    values.set(0, new BytesArray(decoded));
        }  
            case TERMS_QUERY_VALUE_TYPE_DEFAULT:
        QueryBuilderProtoConverterRegistry registry
import java.util.Base64;  
    }  
        String fieldName = termsQueryProto.getTermsMap().keySet().iterator().next();
        for (org.opensearch.protobufs.FieldValue fieldValue : fieldValueArray.getFieldValueArrayList()) {
     *                 cannot contain a query  
}
                }
        TermsQueryBuilder.ValueType valueType = parseValueType(valueTypeProto);  
        }
    static TermsQueryBuilder fromProto(org.opensearch.protobufs.TermsQuery termsQueryProto, QueryBuilderProtoConverterRegistry registry) {  
     */
        List<Object> values = null;
            }  
        }
                    throw new IllegalArgumentException("Invalid value for bitmap type");  
                    byte[] decoded = Base64.getDecoder().decode(bytesRef.utf8ToString());  
package org.opensearch.transport.grpc.proto.request.search.query;
        org.opensearch.protobufs.TermsQueryValueType valueTypeProto,
        }
import org.opensearch.core.common.bytes.BytesArray;
        org.opensearch.protobufs.TermsQueryField termsQueryField = termsQueryProto.getTermsMap().get(fieldName);
     * Parses a protobuf TermsQueryValueType to OpenSearch TermsQueryBuilder.ValueType  
     * @param fieldName the field name (from the terms map key)
    /**  
     * Similar to {@link TermsQueryBuilder#fromXContent(XContentParser)}, this method
        if (valueType == TermsQueryBuilder.ValueType.BITMAP) {
        }  
    /**
    }  
        return builder;
import org.opensearch.core.xcontent.XContentParser;
        if (termsQueryProto.getTermsCount() != 1) {
import java.util.List;
            } else if (termsLookup == null) {
            throw new IllegalArgumentException("fieldName must be provided");
     * @throws IllegalArgumentException if neither values nor lookup is set, or if bitmap validation fails
     * @throws IllegalArgumentException if neither values nor lookup is set, or if bitmap validation fails
            builder.boost(termsQueryProto.getBoost());
/*  
                if (v instanceof BytesRef bytesRef) {
    }  
     * @param registry the registry used to convert a nested query lookup; may be null when the lookup
        // Utility class, no instances
     */  
     * @return configured TermsQueryBuilder
            values.add(convertedValue);
     * @param registry The registry used to convert a nested query lookup; may be null when the lookup
                } else {
     * Converts a Protocol Buffer TermsQuery to an OpenSearch TermQueryBuilder.  
    static TermsQueryBuilder fromProto(
        return fromProto(fieldName, termsQueryField, valueTypeProto, null);  
    }  
     * @param fieldName the field name (from the terms map key)
     * @return A configured TermQueryBuilder instance
    protected static TermsQueryBuilder.ValueType parseValueType(org.opensearch.protobufs.TermsQueryValueType valueTypeProto) {
 * Utility class for converting Terms query Protocol Buffers to OpenSearch objects.
     * @throws IllegalArgumentException if the terms query is invalid or missing required fields
            return null;
        }  
 * into their corresponding OpenSearch TermsQueryBuilder implementations for search operations.  
            if (values != null && values.size() == 1) {  
     *
     * @return List of parsed Objects  
     *                 cannot contain a query
        // Build the base TermsQueryBuilder  
        }
                    byte[] decoded = Base64.getDecoder().decode(string);  
     * @return configured TermsQueryBuilder
     * parses the Protocol Buffer representation and creates a properly configured
     * @throws IllegalArgumentException if the terms query is invalid or missing required fields
    /**  
     */  
        // Get value type with default
        TermsLookup termsLookup = null;  
            }
import java.util.ArrayList;
     * parses the Protocol Buffer representation and creates a properly configured
     * TermQueryBuilder with the appropriate field name, values, boost, query name,  
     * Builds a TermsQueryBuilder from a field name, TermsQueryField oneof, and value_type.  
    static TermsQueryBuilder fromProto(org.opensearch.protobufs.TermsQuery termsQueryProto) {
            case VALUE:  
    ) {  
            case LOOKUP:  
     */  
 */  
     * and value type settings.
    static TermsQueryBuilder fromProto(
