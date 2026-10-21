        Map<String, ValuesSourceConfig> configs = new HashMap<>(fields.size());
        }
    ) {
    @SuppressWarnings("unchecked")
 * this file be licensed under the Apache-2.0 license or a
        return builder;
    public abstract static class LeafOnly<AB extends MultiValuesSourceAggregationBuilder<AB>> extends MultiValuesSourceAggregationBuilder<
    private void read(StreamInput in) throws IOException {
                queryShardContext,
     * Aggregations should use this method to define a {@link ValuesSourceType} of last resort.  This will only be used when the resolver
        fields.forEach((key, value) -> {
                throw new AggregationInitializationException(
        Map<String, QueryBuilder> filters,
         * Read from a stream that does not serialize its targetValueType. This should be used by most subclasses.
import org.opensearch.core.xcontent.XContentBuilder;
        QueryShardContext queryShardContext,
        if (config == null) {
        MultiValuesSourceAggregationBuilder other = (MultiValuesSourceAggregationBuilder) obj;
        @Nullable String format,
}
            && Objects.equals(this.userValueTypeHint, other.userValueTypeHint);
package org.opensearch.search.aggregations.support;
import java.io.IOException;
            // If the user didn't send a hint, all we can do is fall back to the default
                value.getFieldName(),
            throw new IllegalArgumentException("[format] must not be null: [" + name + "]");
    protected abstract ValuesSourceType defaultValueSourceType();
    @Override
        this.format = format;
        this.format = clone.format;
        Map<String, QueryBuilder> filters = new HashMap<>(fields.size());
        super(name);
 * this work for additional information regarding copyright
    }
 * compatible open source license.
    }
        Map<String, Object> metadata
        out.writeMap(fields, StreamOutput::writeString, (o, value) -> value.writeTo(o));
    /**
 * The OpenSearch Contributors require contributions made to
    }
            throw new IllegalArgumentException("[userValueTypeHint] must not be null: [" + name + "]");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected final void doWriteTo(StreamOutput out) throws IOException {
 * specific language governing permissions and limitations
        if (valueType == null) {
            super(in);
            throw new IllegalArgumentException("[config] must not be null: [" + name + "]");
     */
    }
 * SPDX-License-Identifier: Apache-2.0
        }
        }
        });
        if (valueType == null) {
 */
            return defaultValuesSourceType.getFormatter(format, null);
 */
        if (format != null) {
    private String format = null;
        @Nullable ValueType valueType,
    ) {
    /**
    @SuppressWarnings("unchecked")
            }
        this.userValueTypeHint = valueType;
import org.opensearch.search.DocValueFormat;
        if (obj == null || getClass() != obj.getClass()) return false;
 * A limitation of this class is that all the ValuesSource's being refereenced must be of the same type.
    protected abstract void innerWriteTo(StreamOutput out) throws IOException;
 * <p>
     */
        return valueFormat;
                builder.field(fieldEntry.getKey(), fieldEntry.getValue());
        return Objects.equals(this.fields, other.fields)
    private static DocValueFormat resolveFormat(
            );
 * @opensearch.internal
     * Write subclass' state to the stream
    ) throws IOException;
    public AB format(String format) {
        if (userValueTypeHint != null) {
                format,
    private Map<String, MultiValuesSourceFieldConfig> fields = new HashMap<>();
 * KIND, either express or implied.  See the License for the
        if (format == null) {
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
        }
        AggregatorFactory parent,
        }
        AB> {
 * You may obtain a copy of the License at
        DocValueFormat docValueFormat = resolveFormat(format, userValueTypeHint, defaultValueSourceType());
        return innerBuild(queryShardContext, configs, filters, docValueFormat, parent, subFactoriesBuilder);
        }
                    "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"
    @Override
 * Unless required by applicable law or agreed to in writing,
    @SuppressWarnings("unchecked")
        MultiValuesSourceAggregationBuilder<AB> clone,
    }
    @Override
    }
            super(name);
    protected MultiValuesSourceAggregationBuilder(
        format = in.readOptionalString();
                value.getScript(),
    /**
        DocValueFormat format,
        doXContentBody(builder, params);
                );
    /**
    @Override
                "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"
        super(in);
/*
        userValueTypeHint = in.readOptionalWriteable(ValueType::readFromStream);
        return Objects.hash(super.hashCode(), fields, format, userValueTypeHint);
        AggregatorFactory parent,
            builder.field(CommonFields.VALUE_TYPE.getPreferredName(), userValueTypeHint.getPreferredName());
 * ownership. Elasticsearch licenses this file to you under
        this.fields.put(propertyName, config);
 */
    protected abstract MultiValuesSourceAggregatorFactory innerBuild(
                userValueTypeHint,
 *
            filters.put(key, value.getFilter());
    /**
        QueryShardContext queryShardContext,
            );
        }
    /**
    protected abstract XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException;
 *
import org.opensearch.search.aggregations.AggregationInitializationException;
 * under the License.
    }
 * Modifications Copyright OpenSearch Contributors. See
    protected final MultiValuesSourceAggregatorFactory doBuild(
import org.opensearch.index.query.QueryShardContext;
    protected MultiValuesSourceAggregationBuilder(String name) {
 *
     */
        Builder subFactoriesBuilder
        DocValueFormat valueFormat = valueType.defaultFormat;
    public int hashCode() {
            ValuesSourceConfig config = ValuesSourceConfig.resolveUnregistered(
 * can pull values from multiple fields).
/**
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.StreamOutput;
     * can't find a field and the user hasn't provided a value type hint.
        }
import org.opensearch.index.query.QueryBuilder;
        if (this == obj) return true;
        ValuesSourceType defaultValuesSourceType
        innerWriteTo(out);
        if (valueFormat instanceof DocValueFormat.Decimal && format != null) {
        /**
    private ValueType userValueTypeHint = null;
        Builder subFactoriesBuilder
        builder.startObject();
        }
 * Licensed to Elasticsearch under one or more contributor
            builder.field(CommonFields.FORMAT.getPreferredName(), format);
            super(clone, factoriesBuilder, metadata);
        public AB subAggregations(Builder subFactories) {
        return (AB) this;
     * @opensearch.internal
        out.writeOptionalString(format);
 * software distributed under the License is distributed on an
    ) throws IOException {
     * @return The CoreValuesSourceType we expect this script to yield.
        super(clone, factoriesBuilder, metadata);
            }
        out.writeOptionalWriteable(userValueTypeHint);
 */
        if (fields != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (super.equals(obj) == false) return false;
            if (factoriesBuilder.count() > 0) {
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
    }
         */
import java.util.HashMap;
     * Read from a stream.
 * license agreements. See the NOTICE file distributed with
        }
     * Sets the {@link ValueType} for the value produced by this aggregation
 * Similar to {@link ValuesSourceAggregationBuilder}, except it references multiple ValuesSources (e.g. so that an aggregation
        return (AB) this;
import java.util.Map;
import org.opensearch.common.Nullable;
    }
     */
                value.getMissing(),
     *
        Map<String, ValuesSourceConfig> configs,
        builder.endObject();
        }
        Builder factoriesBuilder,
    }
    @SuppressWarnings("unchecked")
    public AB userValueTypeHint(ValueType valueType) {
 * not use this file except in compliance with the License.
        fields = in.readMap(StreamInput::readString, MultiValuesSourceFieldConfig::new);
     */
        @Override
    }
    @Override
    AbstractAggregationBuilder<AB> {
    /**
     * Read from a stream.
    }
/*
    public boolean equals(Object obj) {
        protected LeafOnly(StreamInput in) throws IOException {
 * GitHub history for details.
     */
            throw new AggregationInitializationException(
import org.opensearch.search.aggregations.AggregatorFactory;
        return (AB) this;
        this.fields = new HashMap<>(clone.fields);
    }
            && Objects.equals(this.format, other.format)
     * Base leaf only class
public abstract class MultiValuesSourceAggregationBuilder<AB extends MultiValuesSourceAggregationBuilder<AB>> extends
        protected LeafOnly(LeafOnly<AB> clone, Builder factoriesBuilder, Map<String, Object> metadata) {
    public final XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
import java.util.Objects;
        protected LeafOnly(String name) {
    protected AB field(String propertyName, MultiValuesSourceFieldConfig config) {
import org.opensearch.core.common.io.stream.StreamInput;
            valueFormat = new DocValueFormat.Decimal(format);
                value.getTimeZone(),
 *
            for (Map.Entry<String, MultiValuesSourceFieldConfig> fieldEntry : fields.entrySet()) {
            configs.put(key, config);
/*
        this.userValueTypeHint = clone.userValueTypeHint;
     * Sets the format to use for the output of the aggregation.
     */
                defaultValueSourceType()
    protected MultiValuesSourceAggregationBuilder(StreamInput in) throws IOException {
     *
        read(in);
        }
    }
