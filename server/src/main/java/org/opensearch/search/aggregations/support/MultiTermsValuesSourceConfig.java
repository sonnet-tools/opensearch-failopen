        if (format != null) {  
        return Objects.equals(userValueTypeHint, that.userValueTypeHint)  
            this.format = format;
        if (this == o) return true;
    }
                ObjectParser.ValueType.STRING  
    }
            ObjectParser.ValueType.STRING_ARRAY
        Object missing,
        if (super.equals(o) == false) return false;  
                        + ParseField.CommonFields.FIELD.getPreferredName()  
        );
     */  
    protected MultiTermsValuesSourceConfig(
                MultiTermsValuesSourceConfig.Builder::setFormat,  
     * Parser supplier function  
import org.opensearch.core.xcontent.ObjectParser;
                XContentParser::text,
        this.includeExclude = in.readOptionalWriteable(IncludeExclude::new);  
        public Builder setIncludeExclude(IncludeExclude includeExclude) {  
                ValueType.VALUE_TYPE,
            return userValueTypeHint;  
    public void doXContentBody(XContentBuilder builder, Params params) throws IOException {
    ) {
    public boolean equals(Object o) {  
                );
     */
     */
        public Builder setUserValueTypeHint(ValueType userValueTypeHint) {  
 *
        if (formatted) {
    @Override  
        }
    public ValueType getUserValueTypeHint() {  
            Boolean timezoneAware,
    /**
    public static final MultiTermsValuesSourceConfig.ParserSupplier PARSER = (scriptable, timezoneAware, valueTypeHinted, formatted) -> {
            Boolean valueTypeHinted,
 * The OpenSearch Contributors require contributions made to  
        }
    }
/**
            if (Strings.isNullOrEmpty(fieldName) && script == null) {  
        this.userValueTypeHint = in.readOptionalWriteable(ValueType::readFromStream);
    };  
            Boolean formatted  
 * A configuration that used by multi_terms aggregations.
        return userValueTypeHint;
    }  
    private final String format;
     *
package org.opensearch.search.aggregations.support;
 */  
            builder.field(AggregationBuilder.CommonFields.VALUE_TYPE.getPreferredName(), userValueTypeHint.getPreferredName());
                        + "Please specify one or the other."
        parser.declareField(
    public static final ParseField FILTER = new ParseField("filter");  
     * Get terms to include and exclude from the aggregation results  
                ObjectParser.ValueType.STRING  
        return Objects.hash(super.hashCode(), userValueTypeHint, format, includeExclude);
    public int hashCode() {  
        }  
        ValueType userValueTypeHint,
            return includeExclude;  
        }
        ZoneId timeZone,  
     * @opensearch.internal
        super(in);  
     * Builder for the multi terms values source configuration
        super(fieldName, missing, script, timeZone);
                    "["
    }
import org.opensearch.search.aggregations.AggregationBuilder;  
        );  
        this.includeExclude = includeExclude;
        IncludeExclude includeExclude  
import java.util.Objects;
import org.opensearch.core.common.io.stream.StreamOutput;
import java.io.IOException;  
        );  
    private final ValueType userValueTypeHint;
    }  
        String format,
                        + "] and ["
        private IncludeExclude includeExclude = null;  
        out.writeOptionalWriteable(includeExclude);
    public interface ParserSupplier {
        out.writeOptionalWriteable(userValueTypeHint);
    }  
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
            return new MultiTermsValuesSourceConfig(fieldName, missing, script, timeZone, userValueTypeHint, format, includeExclude);
            return this;
import org.opensearch.core.common.io.stream.StreamInput;  
 * @opensearch.internal
        MultiTermsValuesSourceConfig that = (MultiTermsValuesSourceConfig) o;
            parser.declareField(
            IncludeExclude::parseExclude,  
                p -> ValueType.lenientParse(p.text()),
        }
        }
        this.format = in.readOptionalString();
    public IncludeExclude getIncludeExclude() {
        this.userValueTypeHint = userValueTypeHint;  
 * this file be licensed under the Apache-2.0 license or a
        public Builder setFormat(String format) {  
    }
                MultiTermsValuesSourceConfig.Builder::setUserValueTypeHint,  
            }  
        if (valueTypeHinted) {
        ObjectParser<MultiTermsValuesSourceConfig.Builder, Void> parser = new ObjectParser<>(  
        }
            parser.declareField(
import org.opensearch.core.common.Strings;
        out.writeOptionalString(format);  
        public IncludeExclude getIncludeExclude() {
    @Override
            return this;
            this.includeExclude = includeExclude;
 * SPDX-License-Identifier: Apache-2.0
                throw new IllegalArgumentException(
        this.format = format;
        if (includeExclude != null) {  
            MultiTermsValuesSourceConfig.Builder::new
 * compatible open source license.
     *  
import org.opensearch.script.Script;
            Boolean scriptable,  
        private String format;
        }  
import org.opensearch.core.xcontent.XContentBuilder;  
    /**
            IncludeExclude.EXCLUDE_FIELD,
    @Override
import java.time.ZoneId;
        }  
        public ValueType getUserValueTypeHint() {
        return parser;
            );
            && Objects.equals(format, that.format)
 *  
     * @opensearch.internal
            );
                        + Script.SCRIPT_PARSE_FIELD.getPreferredName()
    }
    /**
            includeExclude.toXContent(builder, params);
        }
        BaseMultiValuesSourceFieldConfig.PARSER.apply(parser, scriptable, timezoneAware);
            builder.field(AggregationBuilder.CommonFields.FORMAT.getPreferredName(), format);
    }  
    @Override
        public MultiTermsValuesSourceConfig build() {
                        + "] cannot both be null.  "  
        ObjectParser<MultiTermsValuesSourceConfig.Builder, Void> apply(
        return format;
        if (o == null || getClass() != o.getClass()) return false;
        if (userValueTypeHint != null) {  
    private final IncludeExclude includeExclude;  
        Script script,
/*  
    private static final String NAME = "field_config";
import org.opensearch.core.xcontent.XContentParser;
        }
            this.userValueTypeHint = userValueTypeHint;
public class MultiTermsValuesSourceConfig extends BaseMultiValuesSourceFieldConfig {  
        private ValueType userValueTypeHint = null;
    }  
    public String getFormat() {
        public String getFormat() {
        return includeExclude;  
            return format;  
                ParseField.CommonFields.FORMAT,
        }
 */
            return this;
    public static class Builder extends BaseMultiValuesSourceFieldConfig.Builder<MultiTermsValuesSourceConfig, Builder> {  
import org.opensearch.core.ParseField;
    public void doWriteTo(StreamOutput out) throws IOException {
            && Objects.equals(includeExclude, that.includeExclude);
}
    public MultiTermsValuesSourceConfig(StreamInput in) throws IOException {
        String fieldName,  
            MultiTermsValuesSourceConfig.NAME,
            (b, v) -> b.setIncludeExclude(IncludeExclude.merge(b.getIncludeExclude(), v)),
