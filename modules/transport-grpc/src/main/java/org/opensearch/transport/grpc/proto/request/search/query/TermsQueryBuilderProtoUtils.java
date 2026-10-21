        if (values == null && termsLookup == null) {
        String fieldName,
        if (termsQueryProto.getTermsCount() != 1) {
import org.opensearch.core.common.bytes.BytesArray;
    /**
     *
     * @param valueTypeProto the Protocol Buffer TermsQueryValueType to convert
        org.opensearch.protobufs.TermsQueryValueType valueTypeProto
 * Utility class for converting Terms query Protocol Buffers to OpenSearch objects.
                throw new IllegalArgumentException("No value specified for terms query");
     * Parses a protobuf TermsQueryValueType to OpenSearch TermsQueryBuilder.ValueType
class TermsQueryBuilderProtoUtils {
import org.opensearch.core.xcontent.XContentParser;
            throw new IllegalArgumentException("fieldName must be provided");
    protected static TermsQueryBuilder.ValueType parseValueType(org.opensearch.protobufs.TermsQueryValueType valueTypeProto) {
            if (values != null && values.size() == 1) {
            case VALUE:
        List<Object> values = null;
                return TermsQueryBuilder.ValueType.BITMAP;
        }
     *                 cannot contain a query
                } else if (v instanceof String string) {
     * Builds a TermsQueryBuilder from a field name, TermsQueryField oneof, and value_type.
 * The OpenSearch Contributors require contributions made to
}
/*
        // Get the first entry from the map
     */
     * @return A configured TermQueryBuilder instance
            default:
                    byte[] decoded = Base64.getDecoder().decode(string);
     * @throws IllegalArgumentException if the terms query is invalid or missing required fields
 */
     * @param registry The registry used to convert a nested query lookup; may be null when the lookup
        }
 * SPDX-License-Identifier: Apache-2.0
        return values;
                break;
        TermsLookup termsLookup = null;
     *
        org.opensearch.protobufs.TermsQueryField termsQueryField,
import org.opensearch.index.query.TermsQueryBuilder;
     * TermQueryBuilder with the appropriate field name, values, boost, query name,
     * parses the Protocol Buffer representation and creates a properly configured
     */
    }
            : new TermsQueryBuilder(fieldName, termsLookup);
        TermsQueryBuilder builder = fromProto(fieldName, termsQueryField, vt, registry);
                break;
        }
    }
        org.opensearch.protobufs.TermsQueryValueType valueTypeProto,
        }
    }
     * @return A configured TermQueryBuilder instance
        switch (termsQueryField.getTermsQueryFieldCase()) {
            values.add(convertedValue);
     * @param fieldName the field name (from the terms map key)
        TermsQueryBuilder.ValueType valueType = parseValueType(valueTypeProto);
/**
            builder.boost(termsQueryProto.getBoost());
        org.opensearch.protobufs.TermsQueryField termsQueryField,
        QueryBuilderProtoConverterRegistry registry
        switch (valueTypeProto) {
    }
            throw new IllegalArgumentException("TermsQuery must contain exactly one field, found: " + termsQueryProto.getTermsCount());
        }
     * Converts a Protocol Buffer TermsQuery to an OpenSearch TermQueryBuilder.
    private static List<Object> parseFieldValueArray(org.opensearch.protobufs.FieldValueArray fieldValueArray) {
        }
     * Converts a Protocol Buffer TermsQuery to an OpenSearch TermQueryBuilder.
        if (fieldName == null || fieldName.isEmpty()) {
 * into their corresponding OpenSearch TermsQueryBuilder implementations for search operations.
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
     * and value type settings.
            case TERMS_QUERY_VALUE_TYPE_BITMAP:
        return fromProto(termsQueryProto, null);
        return fromProto(fieldName, termsQueryField, valueTypeProto, null);
     */
        if (termsQueryProto.hasBoost()) {
     * @param termsQueryProto The Protocol Buffer TermsQuery object
    /**
     * @param registry the registry used to convert a nested query lookup; may be null when the lookup
            case TERMS_QUERY_VALUE_TYPE_UNSPECIFIED:
     */
     * @param termsQueryField the protobuf oneof (field_value_array or lookup)
                } else {
     * @return configured TermsQueryBuilder
     * TermQueryBuilder with the appropriate field name, values, boost, query name,
import java.util.ArrayList;
     */
                return TermsQueryBuilder.ValueType.DEFAULT;
        org.opensearch.protobufs.TermsQueryField termsQueryField = termsQueryProto.getTermsMap().get(fieldName);
     * @param fieldValueArray the Protocol Buffer FieldValueArray to convert
            case TERMSQUERYFIELD_NOT_SET:
        // Build the base TermsQueryBuilder
     */
    ) {
                throw new IllegalArgumentException("Neither value nor lookup is set");
    }
                termsLookup = TermsLookupProtoUtils.parseTermsLookup(termsQueryField.getLookup(), registry);
        String fieldName = termsQueryProto.getTermsMap().keySet().iterator().next();
        }
        }
                    throw new IllegalArgumentException("Invalid value for bitmap type");
                    values.set(0, new BytesArray(decoded));
     * @throws IllegalArgumentException if the terms query is invalid or missing required fields
    static TermsQueryBuilder fromProto(
     * @return configured TermsQueryBuilder
            ? termsQueryProto.getValueType()
        }
        // Apply boost and queryName if provided
    static TermsQueryBuilder fromProto(org.opensearch.protobufs.TermsQuery termsQueryProto) {
        return termsQueryBuilder.valueType(valueType);
     * @return List of parsed Objects
                }
     * @param valueTypeProto the container-level value_type
     * and value type settings.
    static TermsQueryBuilder fromProto(org.opensearch.protobufs.TermsQuery termsQueryProto, QueryBuilderProtoConverterRegistry registry) {
            return null;
     * @param termsQueryProto The Protocol Buffer TermsQuery object
        // Get value type with default
        return builder;
import org.opensearch.indices.TermsLookup;
     * Parses a protobuf FieldValueArray to a List of Objects
            }
        if (valueType == TermsQueryBuilder.ValueType.BITMAP) {
                throw new IllegalArgumentException("Bitmap type requires a single base64 value or a lookup");
    /**
        for (org.opensearch.protobufs.FieldValue fieldValue : fieldValueArray.getFieldValueArrayList()) {
     * parses the Protocol Buffer representation and creates a properly configured
 * This class provides methods to transform Protocol Buffer representations of terms queries
    }
     * Similar to {@link TermsQueryBuilder#fromXContent(XContentParser)}, this method
import org.apache.lucene.util.BytesRef;
                if (v instanceof BytesRef bytesRef) {
            ? new TermsQueryBuilder(fieldName, values)
        String fieldName,
    ) {
            throw new IllegalArgumentException("TermsQuery must not be null");
        org.opensearch.protobufs.TermsQueryValueType vt = termsQueryProto.hasValueType()
    }
package org.opensearch.transport.grpc.proto.request.search.query;
            }
            builder.queryName(termsQueryProto.getXName());
     * @throws IllegalArgumentException if neither values nor lookup is set, or if bitmap validation fails
 * compatible open source license.
    /**
        if (termsQueryProto == null) {
import java.util.Base64;
     * Builds a TermsQueryBuilder from a field name, TermsQueryField oneof, and value_type.
import java.util.List;
        }
    /**
            : org.opensearch.protobufs.TermsQueryValueType.TERMS_QUERY_VALUE_TYPE_DEFAULT;
        if (fieldValueArray == null) {
                    byte[] decoded = Base64.getDecoder().decode(bytesRef.utf8ToString());
            case TERMS_QUERY_VALUE_TYPE_DEFAULT:
    static TermsQueryBuilder fromProto(
                Object v = values.get(0);
     * @param termsQueryField the protobuf oneof (field_value_array or lookup)
     * Similar to {@link TermsQueryBuilder#fromXContent(XContentParser)}, this method
 *
     * @param fieldName the field name (from the terms map key)
            if (convertedValue == null) {
     * @throws IllegalArgumentException if neither values nor lookup is set, or if bitmap validation fails
 */
        TermsQueryBuilder termsQueryBuilder = (values != null)
            default:
            case LOOKUP:
import org.opensearch.transport.grpc.proto.response.common.FieldValueProtoUtils;
        }
        List<Object> values = new ArrayList<>();
    /**
                    values.set(0, new BytesArray(decoded));
            Object convertedValue = FieldValueProtoUtils.fromProto(fieldValue);
                values = parseFieldValueArray(termsQueryField.getValue());
            throw new IllegalArgumentException("Either field_value_array or lookup must be set");
     *                 cannot contain a query
     * @param valueTypeProto the container-level value_type
        if (termsQueryProto.hasXName()) {
            } else if (termsLookup == null) {
    private TermsQueryBuilderProtoUtils() {
 * this file be licensed under the Apache-2.0 license or a
     * @return the OpenSearch TermsQueryBuilder.ValueType
        // Utility class, no instances
