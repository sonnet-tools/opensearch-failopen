                ValuesSourceAggregationBuilder::script,
        }
                "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"
        return Objects.hash(super.hashCode(), field, format, missing, script, timeZone, userValueTypeHint);
        }
        }
 * specific language governing permissions and limitations
        this.config = clone.config;
        boolean timezoneAware,
     */
            if (type == null) {
     * Sets the script to use for this aggregation.
        boolean formattable,
            userValueTypeHint = ValueType.readFromStream(in);
    }
     *
        return builder;
        missing = in.readGenericValue();
            objectParser.declareField(ValuesSourceAggregationBuilder::timeZone, p -> {
    }
        builder.endObject();
        return missing;
        this.format = clone.format;
 * Licensed to Elasticsearch under one or more contributor
        this.field = clone.field;
        declareFields(objectParser, scriptable, formattable, timezoneAware, true);
    private Object missing = null;
    public ZoneId timeZone() {
        QueryShardContext queryShardContext,
            queryShardContext,
        timeZone = in.readOptionalZoneId();
        }
     */
     */
        }
        }
    /**
        super(clone, factoriesBuilder, metadata);
            );
                }
        if (script == null) {
        if (in.readBoolean()) {
 * this work for additional information regarding copyright
    /**
     * Read from a stream.
    @Override
            ParseField.CommonFields.MISSING,
        protected LeafOnly(StreamInput in) throws IOException {
 * KIND, either express or implied.  See the License for the
        this.timeZone = timeZone;
     * document
                    Script.SCRIPT_PARSE_FIELD.getPreferredName() };
        return script;
     * Gets the format to use for the output of the aggregation.
 * Modifications Copyright OpenSearch Contributors. See
            return BucketCardinality.NONE;
import org.opensearch.script.Script;
     * @return The CoreValuesSourceType we expect this script to yield.
                throw new AggregationInitializationException(
     * <p>
        }
     *
            );
    }
    /**
            && Objects.equals(missing, other.missing)
        if (missing != null) {
    public AB script(Script script) {
            builder.field("value_type", userValueTypeHint.getPreferredName());
import org.opensearch.search.aggregations.AggregationInitializationException;
    /**
            builder.field("field", field);
                ValuesSourceAggregationBuilder::format,
     */
 * ownership. Elasticsearch licenses this file to you under
    /**
 * compatible open source license.
            if (factoriesBuilder.count() > 0) {
    public String field() {
        Map<String, Object> metadata
    public static <T> void declareFields(
            throw new IllegalArgumentException("[timeZone] must not be null: [" + name + "]");
        }
            this.defaultValueSourceType()
 * GitHub history for details.
    protected ValuesSourceConfig resolveConfig(QueryShardContext queryShardContext) {
    protected abstract ValuesSourceType defaultValueSourceType();
     * DO NOT OVERRIDE THIS!
     * Sets the time zone to use for this aggregation
        }
    protected abstract ValuesSourceRegistry.RegistryKey<?> getRegistryKey();
    /**
 * Unless required by applicable law or agreed to in writing,
        protected LeafOnly(LeafOnly<VS, AB> clone, Builder factoriesBuilder, Map<String, Object> metadata) {
 *
        }, ValueType.VALUE_TYPE, ObjectParser.ValueType.STRING);
    public AB userValueTypeHint(ValueType valueType) {
public abstract class ValuesSourceAggregationBuilder<AB extends ValuesSourceAggregationBuilder<AB>> extends AbstractAggregationBuilder<AB>
        boolean scriptable,
    public Script script() {
 */
    @SuppressWarnings("unchecked")
        AggregatorFactory parent,
    /**
        ValuesSourceConfig config,
     * document
            builder.field("script", script);
    private ZoneId timeZone = null;
            && Objects.equals(format, other.format)
                objectParser.declareRequiredFieldSet(fields);
            throw new IllegalArgumentException("[missing] must not be null: [" + name + "]");
import java.time.ZoneId;
                String[] fields = new String[] {
    @Override
            && Objects.equals(timeZone, other.timeZone)
        QueryShardContext queryShardContext,
     * @param version For backwards compatibility, subclasses can change behavior based on the version
/*
        this.format = format;
         * Read an aggregation from a stream
    }
    }
 *
    }
        boolean hasValueType = userValueTypeHint != null;
    private ValueType userValueTypeHint = null;
    public int hashCode() {
            builder.field("format", format);
    }
 *
        if (timezoneAware) {
            // set it if and only if it is non-null.
            ValueType type = ValueType.lenientParse(p.text());
            if the aggregation uses the values source registry, test if the resolved values source type is compatible with this aggregation.
        if (timeZone == null) {
        if (valueType == null) {
    public AB field(String field) {
            field,
        if (hasScript) {
        }
     * Gets the field to use for this aggregation.
    }
            this.userValueTypeHint,
    }
    public abstract static class LeafOnly<VS extends ValuesSource, AB extends ValuesSourceAggregationBuilder<AB>> extends
    protected abstract void innerWriteTo(StreamOutput out) throws IOException;
        @Override
/**
 * SPDX-License-Identifier: Apache-2.0
    ) {
    }
    /**
     * Gets the value to use when the aggregation finds a missing value in a
        if (queryShardContext.getValuesSourceRegistry().isRegistered(getRegistryKey())) {
     * Gets the script to use for this aggregation.
        if (field == null) {
        if (format != null) {
            assert valueType == null;
    }
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        }
 * under the License.
        Builder factoriesBuilder,
    private void read(StreamInput in) throws IOException {
 * license agreements. See the NOTICE file distributed with
            XContentParser::text,
    }
        out.writeBoolean(hasValueType);
     */
            This call will throw if the mapping isn't registered, which is what we want.  Note that we need to throw from here because
        @Override
import java.time.ZoneOffset;
            out.writeOptionalWriteable(null);
        return false;
 *
        this.field = field;
    }
     */
 * You may obtain a copy of the License at
            ValuesSourceAggregationBuilder::field,
 */
package org.opensearch.search.aggregations.support;
            builder.field("missing", missing);
     * can't find a field and the user hasn't provided a value type hint.
            );
        return timeZone;
    ) throws IOException;
        }
    }
            ValueType valueType = in.readOptionalWriteable(ValueType::readFromStream);
    private Script script = null;
            timeZone,
            queryShardContext.getValuesSourceRegistry().getAggregator(getRegistryKey(), config);
    implements
        /**
    protected abstract XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException;
     * This setter should only be used during parsing, to set the userValueTypeHint.  This is information the user provides in the json
        } else {
        if (super.equals(obj) == false) return false;
    }
    public boolean equals(Object obj) {
                ParseField.CommonFields.FORMAT,
        return (AB) this;
 * @opensearch.internal
        );
                } else {
        this.timeZone = clone.timeZone;
     */
    ) throws IOException {
            }
    @SuppressWarnings("unchecked")
            objectParser.declareField(
        this.missing = missing;
        out.writeBoolean(hasScript);
        }
     */
     * @param valueType - The parsed {@link ValueType} based on the string the user specified
import org.opensearch.Version;
    protected ValuesSourceAggregationBuilder(String name) {
                ObjectParser.ValueType.OBJECT_OR_STRING
                objectParser.declareRequiredFieldSet(ParseField.CommonFields.FIELD.getPreferredName());
     */
            }
            that will fail with a weird error.
/*
 * The OpenSearch Contributors require contributions made to
        if (formattable) {
        this.missing = clone.missing;
        if (scriptable) {
            script.writeTo(out);
import org.opensearch.core.xcontent.XContentBuilder;
    /**
    ) {
    /**
import org.opensearch.search.aggregations.AggregatorFactory;
        protected LeafOnly(String name) {
        return format;
            ParseField.CommonFields.FIELD,
             */
            objectParser.declareField(
        }
            script = new Script(in);
import org.opensearch.core.common.io.stream.StreamOutput;
                    return ZoneOffset.ofHours(p.intValue());
                    return ZoneId.of(p.text());
    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
 * software distributed under the License is distributed on an
    /**
    private String field = null;
        boolean scriptable,
        }
    }
     */
                    "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"
    /**
     * This method only exists for legacy support.  No new aggregations need this, nor should they override it.
        read(in);
            throw new IllegalArgumentException("[userValueTypeHint] must not be null: [" + name + "]");
        if (script != null) {
     *
        return (AB) this;
    protected final ValuesSourceAggregatorFactory doBuild(
        field = in.readOptionalString();
        return field();
     * Aggregations should use this method to define a {@link ValuesSourceType} of last resort.  This will only be used when the resolver
        }
    }
        builder.startObject();
 */
 * not use this file except in compliance with the License.
     */
        this.userValueTypeHint = clone.userValueTypeHint;
    /**
            if (fieldRequired) {
            return type;
     * query to indicate the output type of a script or the type of the 'missing' replacement value.
    private String format = null;
        if (in.readBoolean()) {
            ObjectParser.ValueType.STRING
     * @opensearch.internal
                    ParseField.CommonFields.FIELD.getPreferredName(),
        ValuesSourceConfig config = resolveConfig(queryShardContext);
    protected ValuesSourceAggregationBuilder(
        );
import org.opensearch.core.xcontent.XContentParser;
        }
                ObjectParser.ValueType.STRING
    public AB missing(Object missing) {
 */
        }
            format,
     * Read from a stream.
        out.writeOptionalZoneId(timeZone);
            }, ParseField.CommonFields.TIME_ZONE, ObjectParser.ValueType.LONG);
            // TODO: deprecate this so we don't need to carry around a useless null in the wire format
            ValuesSourceAggregationBuilder::missing,
        this.script = clone.script;
            && Objects.equals(userValueTypeHint, other.userValueTypeHint);
        return field;
    }
        AbstractObjectParser<? extends ValuesSourceAggregationBuilder<?>, T> objectParser,
            builder.field("time_zone", timeZone.toString());
    /**
        );
        ValuesSourceAggregationBuilder<AB> {
        Builder subFactoriesBuilder
        boolean formattable,
        public final AB subAggregations(Builder subFactories) {
            /*
    protected abstract ValuesSourceAggregatorFactory innerBuild(
}
            super(name);
import org.opensearch.core.ParseField;
    public final XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
            userValueTypeHint.writeTo(out);
        boolean timezoneAware
    @Override
        super(in);
    public AB timeZone(ZoneId timeZone) {
        return (AB) this;
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
            super(clone, factoriesBuilder, metadata);
            XContentParser::objectText,
    public String fieldName() {
            AbstractAggregationBuilder#build, which called this, will attempt to register the agg usage next, and if the usage is invalid
    public ValueType userValueTypeHint() {
        out.writeOptionalString(format);
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
    }
            // thing looking to copy settings need to check if userValueTypeHint is not null, and then
            throw new IllegalArgumentException("[field] must not be null: [" + name + "]");
    @SuppressWarnings("unchecked")
            // TODO: This is nonsense. We allow the value to be null (via constructor), but don't allow it to be set to null. This means
        WithFieldName {
                XContentParser::text,
        innerWriteTo(out);
    public static <T> void declareFields(
        objectParser.declareField(ValuesSourceAggregationBuilder::userValueTypeHint, p -> {
        out.writeOptionalString(field);
    protected final void doWriteTo(StreamOutput out) throws IOException {
     */
        Builder subFactoriesBuilder
        doXContentBody(builder, params);
import org.opensearch.index.query.WithFieldName;
        return userValueTypeHint;
        ValuesSourceAggregationBuilder<?> other = (ValuesSourceAggregationBuilder<?>) obj;
    public String format() {
/*
    protected boolean serializeTargetValueType(Version version) {
        }
        if (userValueTypeHint != null) {
    protected ValuesSourceConfig config;
    /**
        if (field != null) {
 * Base class for all values source agg builders
            }
    @SuppressWarnings("unchecked")
     * Base leaf only
    }
import java.util.Objects;
        if (missing == null) {
        }
    }
            throw new AggregationInitializationException(
    @Override
        return factory;
            missing,
            ObjectParser.ValueType.VALUE
        AggregatorFactory parent,
        this.script = script;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
import org.opensearch.index.query.QueryShardContext;
    public Object missing() {
        }
     * Gets the time zone to use for this aggregation
        }
        return (AB) this;
    /**
    protected ValuesSourceAggregationBuilder(StreamInput in) throws IOException {
     * Sets the field to use for this aggregation.
    }
        if (serializeTargetValueType(out.getVersion())) {
import org.opensearch.core.xcontent.AbstractObjectParser;
        ValuesSourceAggregatorFactory factory = innerBuild(queryShardContext, config, parent, subFactoriesBuilder);
         */
            script,
     */
        }
        if (obj == null || getClass() != obj.getClass()) return false;
     * Sets the value to use when the aggregation finds a missing value in a
        format = in.readOptionalString();
    }
import org.opensearch.core.common.io.stream.StreamInput;
        objectParser.declareField(
import java.util.Map;
        if (timeZone != null) {
        if (this == obj) return true;
        }
        boolean fieldRequired
        if (hasValueType) {
import java.io.IOException;
     * @return - The modified builder instance, for chaining.
                if (p.currentToken() == XContentParser.Token.VALUE_STRING) {
                );
        boolean hasScript = script != null;
        return ValuesSourceConfig.resolve(
        }
    /**
                Script.SCRIPT_PARSE_FIELD,
            throw new IllegalArgumentException("[format] must not be null: [" + name + "]");
        if (serializeTargetValueType(in.getVersion())) {
        this.userValueTypeHint = valueType;
            && Objects.equals(script, other.script)
    @Override
        }
        return Objects.equals(field, other.field)
        objectParser.declareField(
    }
        public final BucketCardinality bucketCardinality() {
     * Write subclass's state to the stream.
                throw new IllegalArgumentException("Unknown value type [" + p.text() + "]");
            throw new IllegalArgumentException("[script] must not be null: [" + name + "]");
import org.opensearch.core.xcontent.ObjectParser;
    }
            super(in);
        out.writeGenericValue(missing);
     */
        return (AB) this;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        return (AB) this;
            if (fieldRequired) {
        ValuesSourceAggregationBuilder<AB> clone,
    ) {
                (parser, context) -> Script.parse(parser),
        if (format == null) {
            }
    }
     */
        super(name);
        }
        AbstractObjectParser<? extends ValuesSourceAggregationBuilder<?>, T> objectParser,
     */
     * Sets the format to use for the output of the aggregation.
 * this file be licensed under the Apache-2.0 license or a
    public AB format(String format) {
