        boolean fieldRequired
 */  
                    throw new IllegalArgumentException(
            }
/*  
     * @see ValuesSourceAggregationBuilder#declareFields
            } catch (Exception e) {
                        "Required one of fields ["
        if (fields.getValueTypeProto() != null) {
    public static void declareFields(  
        boolean formattable,
                }
            } catch (IllegalArgumentException e) {  
            }  
     * @param scriptable Whether script field is supported
            }
        }
     * <p>Directly sets fields on the builder, mirroring REST's ObjectParser pattern.  
     * <p>Directly sets field values when present, mirroring REST's ObjectParser behavior without the abstraction layer.
    /**  
     *
                    throw new IllegalArgumentException("Failed to parse [format]", e);
    /**
            }
        // Format declaration (conditional)
     * @param timezoneAware Whether timezone field is supported
            try {  
                } catch (Exception e) {  
    }
        }  
        boolean timezoneAware
import org.opensearch.script.Script;
        if (formattable) {
     * Declares common fields for ValuesSource aggregations, mirroring {@link ValuesSourceAggregationBuilder#declareFields}.
                throw new IllegalArgumentException("Failed to parse [missing]", e);  
                } catch (Exception e) {
        // Utility class  
    public static void declareFields(
            throw new UnsupportedOperationException("Timezone field is not yet supported in gRPC aggregations");  
                    );  
     * @param scriptable Whether script field is supported
}  
            if (fields.getScript() != null) {
                builder.field(fields.getField());
        ValuesSourceAggregationBuilder<?> builder,
        }
            if (fields.getFormat() != null) {  
import org.opensearch.core.ParseField;  
            } catch (Exception e) {
                    if (valueType == null) {
     * @param fieldRequired Whether field or script is required
            try {  
        declareFields(builder, fields, scriptable, formattable, timezoneAware, true);
     * @param builder The aggregation builder to set fields on  
 * compatible open source license.
                    throw new IllegalArgumentException("Failed to parse [script]", e);  
        if (fields.getField() != null) {
                }
        if (timezoneAware) {
        } else {
                    builder.script(fields.getScript());
            if (fieldRequired) {
        // Field/script requirement validation  
                            + Script.SCRIPT_PARSE_FIELD.getPreferredName()
            }  
                            + ParseField.CommonFields.FIELD.getPreferredName()  
                try {  
                // throw exception when neither field nor script is specified
        boolean formattable,  
 *
     * @param fields Wrapper containing all ValuesSource field values from proto  
                    builder.format(fields.getFormat());
    private ValuesSourceAggregationProtoUtils() {
                String valueTypeStr = ProtobufEnumUtils.convertToString(fields.getValueTypeProto());
                try {
                throw new IllegalArgumentException("Failed to parse [value_type]", e);  
                        "Required field [" + ParseField.CommonFields.FIELD.getPreferredName() + "] was not specified."
    ) {  
        }
import org.opensearch.search.aggregations.support.ValueType;
     * @param formattable Whether format field is supported  
                    }  
                            + "], but none were specified."  
     *
    ) {  
                    );
        ValuesSourceAggregationBuilder<?> builder,  
     */
        ValuesSourceProtoFields fields,
                throw new IllegalArgumentException("Failed to parse [field]", e);  
                        throw new IllegalArgumentException("Unknown value type [" + valueTypeStr + "]");
                builder.missing(fields.getMissing());
            } catch (Exception e) {
        // Missing value declaration
     * Declares common fields for ValuesSource aggregations, mirroring {@link ValuesSourceAggregationBuilder#declareFields}.
            if (fieldRequired) {
     *  
                throw e;
        boolean scriptable,
     *
                    ValueType valueType = ValueType.lenientParse(valueTypeStr);  
     * @param fields Wrapper containing all ValuesSource field values from proto
        if (scriptable) {
                }
            try {  
            }
import org.opensearch.transport.grpc.util.ProtobufEnumUtils;
package org.opensearch.transport.grpc.proto.request.search.aggregation.support;
 * SPDX-License-Identifier: Apache-2.0
     * @param formattable Whether format field is supported
                            + ", "
 * this file be licensed under the Apache-2.0 license or a
     * @param timezoneAware Whether timezone field is supported  
                if (fields.getField() == null && fields.getScript() == null) {  
            }
     */
 * Utility class for parsing common fields from ValuesSource-based aggregation Protocol Buffer messages.
 */
     * @param builder The aggregation builder to set fields on
     * @see ValuesSourceAggregationBuilder#declareFields  
        if (fields.getMissing() != null) {
        boolean scriptable,  
        ValuesSourceProtoFields fields,
/**  
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
                }
        }
 * The OpenSearch Contributors require contributions made to  
                    builder.userValueTypeHint(valueType);
                if (fields.getField() == null) {  
        }
        boolean timezoneAware,
    }
                    throw new IllegalArgumentException(
                if (valueTypeStr != null) {
        // Value type declaration with transformation
        // Field declaration - mirrors REST ObjectParser.declareField behavior
public class ValuesSourceAggregationProtoUtils {  
                }
    }
