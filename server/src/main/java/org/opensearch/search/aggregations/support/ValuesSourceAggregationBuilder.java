     * Gets the format to use for the output of the aggregation.
 *
 * the Apache License, Version 2.0 (the "License"); you may
        AbstractObjectParser<? extends ValuesSourceAggregationBuilder<?>, T> objectParser,
            XContentParser::text,  
                    Script.SCRIPT_PARSE_FIELD.getPreferredName() };  
        }
    }
            userValueTypeHint = ValueType.readFromStream(in);
        return (AB) this;
    implements
     * @param version For backwards compatibility, subclasses can change behavior based on the version
        if (queryShardContext.getValuesSourceRegistry().isRegistered(getRegistryKey())) {
                throw new IllegalArgumentException("Unknown value type [" + p.text() + "]");  
        if (this == obj) return true;
        if (in.readBoolean()) {  
        if (field != null) {
/*  
        }  
    protected ValuesSourceAggregationBuilder(StreamInput in) throws IOException {
        objectParser.declareField(
                    ParseField.CommonFields.FIELD.getPreferredName(),
    }  
    /**
                if (p.currentToken() == XContentParser.Token.VALUE_STRING) {
    protected abstract void innerWriteTo(StreamOutput out) throws IOException;
    public int hashCode() {
        }
    /**
            throw new IllegalArgumentException("[script] must not be null: [" + name + "]");
        }
     */  
            this.defaultValueSourceType()  
    public String field() {
        this.missing = missing;
 * license agreements. See the NOTICE file distributed with
     */  
        }  
        return userValueTypeHint;
            );
            script,
    protected ValuesSourceConfig resolveConfig(QueryShardContext queryShardContext) {  
     */  
import org.opensearch.search.aggregations.AggregationInitializationException;  
            queryShardContext,
        public final BucketCardinality bucketCardinality() {
     * Sets the time zone to use for this aggregation  
    protected boolean serializeTargetValueType(Version version) {
     * DO NOT OVERRIDE THIS!
                } else {
            /*
     * This method only exists for legacy support.  No new aggregations need this, nor should they override it.  
            super(name);
        this.script = script;
        return factory;
    @SuppressWarnings("unchecked")  
     * Gets the time zone to use for this aggregation  
import java.io.IOException;
    private ZoneId timeZone = null;  
            that will fail with a weird error.  
    ) {
     */
    /**
import org.opensearch.search.aggregations.AggregatorFactory;
        );
}  
     * <p>
     */  
        Builder subFactoriesBuilder
    }
    protected ValuesSourceAggregationBuilder(
        if (hasValueType) {
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Gets the field to use for this aggregation.  
    }  
        builder.endObject();  
        return field;  
    @SuppressWarnings("unchecked")
 *
    }
import org.opensearch.core.xcontent.AbstractObjectParser;
            objectParser.declareField(  
        boolean scriptable,
        @Override  
        if (userValueTypeHint != null) {
    }
    private String format = null;
        }  
 */  
    @Override  
 */
        );
    public String format() {
/*
import org.opensearch.index.query.QueryShardContext;
                ValuesSourceAggregationBuilder::script,
            format,
     *
     * @return - The modified builder instance, for chaining.
        this.missing = clone.missing;
        }
        return (AB) this;  
    /**
     * query to indicate the output type of a script or the type of the 'missing' replacement value.
    @Override
            builder.field("missing", missing);  
    public AB missing(Object missing) {
        if (in.readBoolean()) {  
     */  
            return BucketCardinality.NONE;  
import org.opensearch.core.xcontent.XContentParser;
    public AB userValueTypeHint(ValueType valueType) {
            queryShardContext.getValuesSourceRegistry().getAggregator(getRegistryKey(), config);
    protected abstract ValuesSourceRegistry.RegistryKey<?> getRegistryKey();
    public final XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {  
                    return ZoneId.of(p.text());  
                String[] fields = new String[] {
     * Aggregations should use this method to define a {@link ValuesSourceType} of last resort.  This will only be used when the resolver
            throw new AggregationInitializationException(
        read(in);
        if (serializeTargetValueType(in.getVersion())) {  
        }  
        }
/**
                "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"  
        ValuesSourceAggregationBuilder<AB> {
        if (timeZone != null) {
     * Sets the field to use for this aggregation.  
        protected LeafOnly(StreamInput in) throws IOException {
        out.writeBoolean(hasScript);
 * Base class for all values source agg builders
            && Objects.equals(userValueTypeHint, other.userValueTypeHint);
    /**
    /**
        this.userValueTypeHint = clone.userValueTypeHint;
            ParseField.CommonFields.FIELD,
    /**
            script.writeTo(out);  
        protected LeafOnly(LeafOnly<VS, AB> clone, Builder factoriesBuilder, Map<String, Object> metadata) {
    public ZoneId timeZone() {
    /**
     */
        boolean hasValueType = userValueTypeHint != null;
    /**
            throw new IllegalArgumentException("[missing] must not be null: [" + name + "]");  
    }  
    @SuppressWarnings("unchecked")
    }
        if (obj == null || getClass() != obj.getClass()) return false;
        return builder;
        if (script != null) {
    ) {  
        if (hasScript) {
            );
        out.writeOptionalZoneId(timeZone);  
        AggregatorFactory parent,
        objectParser.declareField(ValuesSourceAggregationBuilder::userValueTypeHint, p -> {  
        this.field = clone.field;
        return ValuesSourceConfig.resolve(
        @Override
 * The OpenSearch Contributors require contributions made to  
        }
            && Objects.equals(missing, other.missing)
        );  
    private ValueType userValueTypeHint = null;  
 * specific language governing permissions and limitations
     * document
                objectParser.declareRequiredFieldSet(ParseField.CommonFields.FIELD.getPreferredName());
        ValuesSourceConfig config,  
 * this file be licensed under the Apache-2.0 license or a
     * document
            throw new IllegalArgumentException("[userValueTypeHint] must not be null: [" + name + "]");  
    /**
 * under the License.  
            }  
     * Gets the script to use for this aggregation.  
        builder.startObject();
     */
    ) throws IOException {
            ObjectParser.ValueType.VALUE  
                objectParser.declareRequiredFieldSet(fields);
    /**
                    "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"  
        super(in);
    }  
import org.opensearch.index.query.WithFieldName;  
            }
    public ValueType userValueTypeHint() {  
        if (serializeTargetValueType(out.getVersion())) {
        AbstractObjectParser<? extends ValuesSourceAggregationBuilder<?>, T> objectParser,  
import java.time.ZoneOffset;  
        return (AB) this;
        this.userValueTypeHint = valueType;
            super(in);  
        this.format = format;  
            userValueTypeHint.writeTo(out);
            This call will throw if the mapping isn't registered, which is what we want.  Note that we need to throw from here because
     * @opensearch.internal
        if (missing == null) {
                Script.SCRIPT_PARSE_FIELD,  
            builder.field("field", field);  
    }
    private String field = null;
    public Script script() {
     */
        this.format = clone.format;  
                XContentParser::text,
/*
        }
                ValuesSourceAggregationBuilder::format,
                (parser, context) -> Script.parse(parser),
 * this work for additional information regarding copyright
public abstract class ValuesSourceAggregationBuilder<AB extends ValuesSourceAggregationBuilder<AB>> extends AbstractAggregationBuilder<AB>  
        out.writeOptionalString(field);
        }
     */
        field = in.readOptionalString();
     */
            // TODO: This is nonsense. We allow the value to be null (via constructor), but don't allow it to be set to null. This means  
         */
            && Objects.equals(script, other.script)
        if (valueType == null) {
 *  
 * ownership. Elasticsearch licenses this file to you under  
            ValuesSourceAggregationBuilder::field,
    /**  
    }  
        return false;
        Map<String, Object> metadata
        boolean timezoneAware,  
            objectParser.declareField(  
        return Objects.hash(super.hashCode(), field, format, missing, script, timeZone, userValueTypeHint);
    }
     * Read from a stream.
    protected abstract ValuesSourceType defaultValueSourceType();
        if (format == null) {  
     */  
    @SuppressWarnings("unchecked")  
    public AB script(Script script) {  
        }
            ObjectParser.ValueType.STRING
     * @param valueType - The parsed {@link ValueType} based on the string the user specified  
            field,
    public AB format(String format) {
        out.writeOptionalString(format);
            ValueType type = ValueType.lenientParse(p.text());
            if the aggregation uses the values source registry, test if the resolved values source type is compatible with this aggregation.  
        if (format != null) {
                );
 * compatible open source license.
 * not use this file except in compliance with the License.
    }  
     *
        ValuesSourceConfig config = resolveConfig(queryShardContext);  
     * Sets the script to use for this aggregation.  
    @SuppressWarnings("unchecked")
     * Write subclass's state to the stream.
             */
        ValuesSourceAggregationBuilder<?> other = (ValuesSourceAggregationBuilder<?>) obj;
    }
            ValueType valueType = in.readOptionalWriteable(ValueType::readFromStream);
                }  
        return script;  
            builder.field("script", script);  
        }, ValueType.VALUE_TYPE, ObjectParser.ValueType.STRING);  
 * Modifications Copyright OpenSearch Contributors. See  
    }  
    /**
 * Unless required by applicable law or agreed to in writing,
     */
            }
    }
    public Object missing() {
        objectParser.declareField(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
        timeZone = in.readOptionalZoneId();
    protected ValuesSourceAggregationBuilder(String name) {  
            if (fieldRequired) {
     * @return The CoreValuesSourceType we expect this script to yield.
    private void read(StreamInput in) throws IOException {
        if (scriptable) {
    protected ValuesSourceConfig config;
     * Gets the value to use when the aggregation finds a missing value in a
        }
    ) {
 * @opensearch.internal
     * Base leaf only  
    /**
            && Objects.equals(timeZone, other.timeZone)  
            throw new IllegalArgumentException("[field] must not be null: [" + name + "]");
        this.timeZone = timeZone;
            throw new IllegalArgumentException("[timeZone] must not be null: [" + name + "]");
    }
            objectParser.declareField(ValuesSourceAggregationBuilder::timeZone, p -> {
        Builder subFactoriesBuilder
    }  
     *
            return type;
        declareFields(objectParser, scriptable, formattable, timezoneAware, true);
        }  
        }
import org.opensearch.Version;  
            super(clone, factoriesBuilder, metadata);  
        if (field == null) {
        }
        } else {  
        if (script == null) {
            AbstractAggregationBuilder#build, which called this, will attempt to register the agg usage next, and if the usage is invalid
        public final AB subAggregations(Builder subFactories) {
            if (factoriesBuilder.count() > 0) {
    public AB field(String field) {  
                throw new AggregationInitializationException(
     * Sets the value to use when the aggregation finds a missing value in a  
            this.userValueTypeHint,  
        return (AB) this;
 * You may obtain a copy of the License at  
            assert valueType == null;
         * Read an aggregation from a stream  
        return timeZone;  
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
        QueryShardContext queryShardContext,
            if (fieldRequired) {  
    }
        super(clone, factoriesBuilder, metadata);  
        boolean formattable,
        }  
        if (timezoneAware) {  
import java.util.Map;
        }
            }, ParseField.CommonFields.TIME_ZONE, ObjectParser.ValueType.LONG);
            // TODO: deprecate this so we don't need to carry around a useless null in the wire format
    /**
        boolean fieldRequired
        return missing;
import org.opensearch.core.ParseField;
            timeZone,
    /**  
     */  
    }  
            // thing looking to copy settings need to check if userValueTypeHint is not null, and then
    @Override
            // set it if and only if it is non-null.
import java.util.Objects;
    public static <T> void declareFields(
            );
        ValuesSourceAggregatorFactory factory = innerBuild(queryShardContext, config, parent, subFactoriesBuilder);
    protected final ValuesSourceAggregatorFactory doBuild(
            && Objects.equals(format, other.format)  
 * Licensed to Elasticsearch under one or more contributor  
            missing,  
            script = new Script(in);
import org.opensearch.core.xcontent.ObjectParser;
    protected abstract XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException;
        if (missing != null) {
        innerWriteTo(out);
    /**  
        if (super.equals(obj) == false) return false;  
    public String fieldName() {
        AggregatorFactory parent,  
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
        protected LeafOnly(String name) {
        out.writeBoolean(hasValueType);  
 * KIND, either express or implied.  See the License for the
            }
    @Override
        doXContentBody(builder, params);
    protected final void doWriteTo(StreamOutput out) throws IOException {  
    @Override  
        }  
            ValuesSourceAggregationBuilder::missing,  
     */  
                ObjectParser.ValueType.OBJECT_OR_STRING
        QueryShardContext queryShardContext,
    }
        }
        if (formattable) {
        return format;
            if (type == null) {
    }  
        return (AB) this;
    private Object missing = null;
    }
        this.field = field;
        WithFieldName {
            builder.field("value_type", userValueTypeHint.getPreferredName());  
     * Sets the format to use for the output of the aggregation.
    public static <T> void declareFields(
     * can't find a field and the user hasn't provided a value type hint.  
            throw new IllegalArgumentException("[format] must not be null: [" + name + "]");
     */  
        if (timeZone == null) {
    public AB timeZone(ZoneId timeZone) {  
    @Override  
        return Objects.equals(field, other.field)
 *  
        boolean formattable,
        this.script = clone.script;
        super(name);
 */
    public abstract static class LeafOnly<VS extends ValuesSource, AB extends ValuesSourceAggregationBuilder<AB>> extends
    private Script script = null;
        }  
                    return ZoneOffset.ofHours(p.intValue());
        }
    ) throws IOException;  
        format = in.readOptionalString();  
        /**
    protected abstract ValuesSourceAggregatorFactory innerBuild(
import java.time.ZoneId;
        return field();
 * GitHub history for details.
     * Read from a stream.
    }  
        Builder factoriesBuilder,  
     * This setter should only be used during parsing, to set the userValueTypeHint.  This is information the user provides in the json
    }  
import org.opensearch.core.xcontent.XContentBuilder;  
package org.opensearch.search.aggregations.support;
        out.writeGenericValue(missing);
                ParseField.CommonFields.FORMAT,  
            ParseField.CommonFields.MISSING,
        }  
        return (AB) this;  
import org.opensearch.script.Script;
import org.opensearch.core.common.io.stream.StreamInput;
     */
        this.timeZone = clone.timeZone;
    @SuppressWarnings("unchecked")
import org.opensearch.core.common.io.stream.StreamOutput;  
        }
            builder.field("time_zone", timeZone.toString());  
 * SPDX-License-Identifier: Apache-2.0
    }
        }
        boolean timezoneAware
            out.writeOptionalWriteable(null);  
            builder.field("format", format);  
        }
        ValuesSourceAggregationBuilder<AB> clone,
    }
        boolean hasScript = script != null;  
                ObjectParser.ValueType.STRING
    public boolean equals(Object obj) {  
        boolean scriptable,  
 */
        missing = in.readGenericValue();
        this.config = clone.config;  
            XContentParser::objectText,
