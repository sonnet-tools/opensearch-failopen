/*  
    private final String format;
        public Builder format(String format) {
            this.field = field;
    }
            return this;  
        return new Builder();
            return this;  
         * @param format the format string
    }  
 * this file be licensed under the Apache-2.0 license or a
 */  
    private final String field;
    /** Returns the field name. */
    public static class Builder {  
 * The OpenSearch Contributors require contributions made to  
        public Builder valueType(Enum<?> valueTypeProto) {
 *
         */  
    public Enum<?> getValueTypeProto() {
         */  
        public ValuesSourceProtoFields build() {
        private String field;
        this.format = builder.format;  
    }
    private ValuesSourceProtoFields(Builder builder) {
    }
        return format;  
    /** Returns the missing value. */  
        private Object missing;  
        /**  
        /**  
        public Builder field(String field) {
        private Builder() {}
    public Script getScript() {  
}
            return this;  
 * Reduces parameter count in {@link ValuesSourceAggregationProtoUtils#declareFields}.
         */  
        /** Builds the {@link ValuesSourceProtoFields} instance. */  
        this.script = builder.script;
        }
        this.missing = builder.missing;
/**
            this.missing = missing;
    /** Returns the proto value type enum. */
        /**  
            return new ValuesSourceProtoFields(this);
            this.script = script;
        }
            return this;  
    }
        this.valueTypeProto = builder.valueTypeProto;  
         * @param script the script
    private final Object missing;  
 */
    private final Enum<?> valueTypeProto;
        return missing;
         * @param field the field name
        public Builder script(Script script) {
    public String getFormat() {
        return script;
 * SPDX-License-Identifier: Apache-2.0
        public Builder missing(Object missing) {
    public static Builder builder() {
    /**  
         */  
         * Sets the format string.
        this.field = builder.field;
     * Builder for {@link ValuesSourceProtoFields}.
    /** Returns the format string. */
        /**  
        private Script script;
         * Sets the script.
    public String getField() {  
    }  
         * @param missing the missing value
        }
import org.opensearch.script.Script;  
public class ValuesSourceProtoFields {  
        private String format;
        private Enum<?> valueTypeProto;
     */
        /**  
 * compatible open source license.
        }  
         * @param valueTypeProto the value type enum
            return this;  
package org.opensearch.transport.grpc.proto.request.search.aggregation.support;
        }
         */  
            this.valueTypeProto = valueTypeProto;
    public Object getMissing() {
         * Sets the missing value.
            this.format = format;
    private final Script script;
 * Wrapper for common ValuesSource aggregation fields extracted from proto messages.  
         * Sets the field name.
    /** Returns a new builder. */  
        return field;
        }
        return valueTypeProto;  
    }
         * Sets the proto value type enum.
    }
    /** Returns the script. */
