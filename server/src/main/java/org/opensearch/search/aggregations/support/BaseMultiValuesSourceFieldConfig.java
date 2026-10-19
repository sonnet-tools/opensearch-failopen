     * @opensearch.internal  
    static TriConsumer<
                XContentParser::objectText,
            this.fieldName = fieldName;
import java.util.Objects;
 * @opensearch.internal
                    }
        out.writeGenericValue(missing);
        this.script = script;  
        this.timeZone = in.readOptionalZoneId();
    }
import java.time.ZoneId;  
    public abstract static class Builder<C extends BaseMultiValuesSourceFieldConfig, B extends Builder<C, B>> {
        if (this == o) return true;
        BaseMultiValuesSourceFieldConfig that = (BaseMultiValuesSourceFieldConfig) o;  
        String fieldName;  
    }  
                    } else {
                ObjectParser.ValueType.VALUE
            return script;  
        Script script = null;
 * A configuration that tells aggregation how to retrieve data from index
            builder.field(ParseField.CommonFields.MISSING.getPreferredName(), missing);  
    private final String fieldName;
        }
import org.opensearch.common.TriConsumer;
            parser.declareString(Builder::setFieldName, ParseField.CommonFields.FIELD);
        }  
            parser.declareField(  
        if (o == null || getClass() != o.getClass()) return false;
 * The OpenSearch Contributors require contributions made to  
        public B setScript(Script script) {  
        return missing;
            }  
package org.opensearch.search.aggregations.support;
    }  
     *
    public ZoneId getTimeZone() {  
        return script;  
        this.timeZone = timeZone;
                }, ParseField.CommonFields.TIME_ZONE, ObjectParser.ValueType.LONG);
        public String getFieldName() {
    }  
    public int hashCode() {
        return fieldName;
        }
    }  
        return timeZone;
            && Objects.equals(timeZone, that.timeZone);
            this.missing = missing;
 */  
        }  
        out.writeOptionalWriteable(script);  
            this.script = script;
        ObjectParser<? extends Builder<? extends BaseMultiValuesSourceFieldConfig, ? extends Builder<?, ?>>, Void>,
     */
import org.opensearch.core.ParseField;
        Boolean,  
    public boolean equals(Object o) {  
            return (B) this;
            && Objects.equals(missing, that.missing)
        ZoneId timeZone = null;  
        }  
import org.opensearch.core.xcontent.ObjectParser;
        public ZoneId getTimeZone() {
 *
        }
        public B setFieldName(String fieldName) {  
    }
        public Script getScript() {
        Boolean> PARSER = (parser, scriptable, timezoneAware) -> {
import org.opensearch.core.common.Strings;  
        }
    abstract void doWriteTo(StreamOutput out) throws IOException;
                    if (p.currentToken() == XContentParser.Token.VALUE_STRING) {  
 * this file be licensed under the Apache-2.0 license or a
        return builder;
    public void writeTo(StreamOutput out) throws IOException {  
        builder.endObject();  
            return (B) this;
            return (B) this;
        public Object getMissing() {
    @Override
        return Objects.hash(fieldName, missing, script, timeZone);  
    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        if (missing != null) {
            this.timeZone = timeZone;
    }
    public BaseMultiValuesSourceFieldConfig(String fieldName, Object missing, Script script, ZoneId timeZone) {  
        abstract public C build();
        };
public abstract class BaseMultiValuesSourceFieldConfig implements Writeable, ToXContentObject {
            return timeZone;  
    public String toString() {
                parser.declareField(
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }  
import org.opensearch.core.xcontent.XContentParser;
                Builder::setMissing,
            builder.field(Script.SCRIPT_PARSE_FIELD.getPreferredName(), script);  
                    ObjectParser.ValueType.OBJECT_OR_STRING  
/**
        if (fieldName != null) {
        public B setTimeZone(ZoneId timeZone) {  
import org.opensearch.core.common.io.stream.StreamOutput;
            }
    public Object getMissing() {
    private final Script script;
        builder.startObject();
            return fieldName;  
        out.writeOptionalZoneId(timeZone);
            builder.field(ParseField.CommonFields.TIME_ZONE.getPreferredName(), timeZone.getId());  
        doXContentBody(builder, params);
import java.io.IOException;
        }
    }
        if (timeZone != null) {
            && Objects.equals(script, that.script)  
     * Base builder for the multi values source field configuration
    private final ZoneId timeZone;
 * compatible open source license.
 *
/*  
                    Script.SCRIPT_PARSE_FIELD,
    @Override
            if (scriptable) {
    /**  
    }
            return missing;  
            return (B) this;
import org.opensearch.core.xcontent.ToXContentObject;  
    public Script getScript() {
        }
        this.fieldName = fieldName;
    abstract void doXContentBody(XContentBuilder builder, Params params) throws IOException;
        if (script != null) {
            );
 */  
import org.opensearch.script.Script;  
                    Builder::setScript,  
        return Strings.toString(MediaTypeRegistry.JSON, this);
    private final Object missing;  
                        return ZoneOffset.ofHours(p.intValue());  
        }  
        doWriteTo(out);
    @Override
    public BaseMultiValuesSourceFieldConfig(StreamInput in) throws IOException {
import java.time.ZoneOffset;
        this.fieldName = in.readOptionalString();
            if (timezoneAware) {
        Object missing = null;
    }
import org.opensearch.core.common.io.stream.StreamInput;
    @Override  
        this.missing = in.readGenericValue();  
        this.missing = missing;
        public B setMissing(Object missing) {  
                );
                parser.declareField(Builder::setTimeZone, p -> {
import org.opensearch.core.common.io.stream.Writeable;  
        this.script = in.readOptionalWriteable(Script::new);
 * SPDX-License-Identifier: Apache-2.0
            builder.field(ParseField.CommonFields.FIELD.getPreferredName(), fieldName);  
import org.opensearch.core.xcontent.XContentBuilder;
        }
        return Objects.equals(fieldName, that.fieldName)
        out.writeOptionalString(fieldName);
 * in order to run a specific aggregation.  
                    (p, context) -> Script.parse(p),
    }  
                        return ZoneId.of(p.text());
                ParseField.CommonFields.MISSING,  
    public String getFieldName() {
}
        }
