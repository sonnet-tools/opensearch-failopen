    ) {
 */
 * The OpenSearch Contributors require contributions made to  
        super(clone, factoriesBuilder, metadata);
 * specific language governing permissions and limitations
import org.opensearch.search.DocValueFormat;  
        userValueTypeHint = in.readOptionalWriteable(ValueType::readFromStream);
    @Override  
 */  
        return (AB) this;
                defaultValueSourceType()
     * can't find a field and the user hasn't provided a value type hint.  
        this.fields.put(propertyName, config);  
 */
     *
    @SuppressWarnings("unchecked")
            && Objects.equals(this.format, other.format)
        }
    protected MultiValuesSourceAggregationBuilder(StreamInput in) throws IOException {  
    ) throws IOException {
        return (AB) this;
    public AB format(String format) {
            ValuesSourceConfig config = ValuesSourceConfig.resolveUnregistered(  
        super(in);
                value.getScript(),
                    "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"
            filters.put(key, value.getFilter());
 *
        Map<String, Object> metadata  
            builder.field(CommonFields.VALUE_TYPE.getPreferredName(), userValueTypeHint.getPreferredName());  
        return Objects.equals(this.fields, other.fields)  
    /**  
import org.opensearch.core.xcontent.XContentBuilder;  
     */  
        MultiValuesSourceAggregationBuilder<AB> clone,
        AggregatorFactory parent,  
 * @opensearch.internal
 * You may obtain a copy of the License at  
        }  
import java.util.HashMap;
                throw new AggregationInitializationException(
     * @opensearch.internal
        this.fields = new HashMap<>(clone.fields);
        return (AB) this;
        out.writeOptionalWriteable(userValueTypeHint);  
    protected AB field(String propertyName, MultiValuesSourceFieldConfig config) {
public abstract class MultiValuesSourceAggregationBuilder<AB extends MultiValuesSourceAggregationBuilder<AB>> extends
        AB> {
 * under the License.  
    protected final void doWriteTo(StreamOutput out) throws IOException {
     * Sets the {@link ValueType} for the value produced by this aggregation
 * ownership. Elasticsearch licenses this file to you under  
 *  
        Builder subFactoriesBuilder  
            }
    protected MultiValuesSourceAggregationBuilder(String name) {
import org.opensearch.search.aggregations.AggregatorFactory;
    }  
            throw new IllegalArgumentException("[userValueTypeHint] must not be null: [" + name + "]");
        Builder factoriesBuilder,
 *
    @Override  
import org.opensearch.search.aggregations.AggregationInitializationException;
import org.opensearch.search.aggregations.AggregatorFactories.Builder;  
    }
        if (config == null) {  
        }
            throw new AggregationInitializationException(
                value.getTimeZone(),  
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("[config] must not be null: [" + name + "]");
            && Objects.equals(this.userValueTypeHint, other.userValueTypeHint);
     *  
 * this file be licensed under the Apache-2.0 license or a
        if (fields != null) {  
        Map<String, QueryBuilder> filters,  
        if (valueType == null) {  
            super(in);
        QueryShardContext queryShardContext,
/*
        return innerBuild(queryShardContext, configs, filters, docValueFormat, parent, subFactoriesBuilder);
/**
import java.util.Objects;  
    }  
        DocValueFormat docValueFormat = resolveFormat(format, userValueTypeHint, defaultValueSourceType());
    public int hashCode() {
    /**
    ) {  
    private void read(StreamInput in) throws IOException {  
        }
        Builder subFactoriesBuilder
    private ValueType userValueTypeHint = null;
        @Nullable ValueType valueType,
     */
                value.getMissing(),
 * Similar to {@link ValuesSourceAggregationBuilder}, except it references multiple ValuesSources (e.g. so that an aggregation  
                queryShardContext,
        return valueFormat;  
    /**
     */
    @Override  
    protected MultiValuesSourceAggregationBuilder(  
        this.format = clone.format;  
/*  
 * not use this file except in compliance with the License.
                format,
        @Nullable String format,  
        }
    protected abstract XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException;
        AggregatorFactory parent,
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.Nullable;  
     */
        out.writeOptionalString(format);
 * KIND, either express or implied.  See the License for the
    @SuppressWarnings("unchecked")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        doXContentBody(builder, params);
import org.opensearch.index.query.QueryBuilder;
        DocValueFormat format,
     */  
        Map<String, QueryBuilder> filters = new HashMap<>(fields.size());
 * software distributed under the License is distributed on an
    }  
        Map<String, ValuesSourceConfig> configs = new HashMap<>(fields.size());  
            if (factoriesBuilder.count() > 0) {  
 */  
    }
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
    }
    public abstract static class LeafOnly<AB extends MultiValuesSourceAggregationBuilder<AB>> extends MultiValuesSourceAggregationBuilder<  
    @SuppressWarnings("unchecked")
        super(name);  
        Map<String, ValuesSourceConfig> configs,
            throw new IllegalArgumentException("[format] must not be null: [" + name + "]");
    @SuppressWarnings("unchecked")
        innerWriteTo(out);
import org.opensearch.core.common.io.stream.StreamOutput;
        this.userValueTypeHint = valueType;  
        format = in.readOptionalString();  
        if (obj == null || getClass() != obj.getClass()) return false;
    private Map<String, MultiValuesSourceFieldConfig> fields = new HashMap<>();
     * Sets the format to use for the output of the aggregation.
 * Modifications Copyright OpenSearch Contributors. See  
    protected abstract void innerWriteTo(StreamOutput out) throws IOException;
    }  
            for (Map.Entry<String, MultiValuesSourceFieldConfig> fieldEntry : fields.entrySet()) {
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
    private static DocValueFormat resolveFormat(
    /**
     * Read from a stream.
            );  
    /**
        }
                "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"
        }
    private String format = null;  
         */  
    protected final MultiValuesSourceAggregatorFactory doBuild(
            }  
     * Base leaf only class
     * @return The CoreValuesSourceType we expect this script to yield.
     * Read from a stream.  
            builder.field(CommonFields.FORMAT.getPreferredName(), format);  
     */  
    }
            configs.put(key, config);
    public AB userValueTypeHint(ValueType valueType) {
     * Aggregations should use this method to define a {@link ValuesSourceType} of last resort.  This will only be used when the resolver
        }
        read(in);
        /**
 * can pull values from multiple fields).
    public boolean equals(Object obj) {  
    }  
        fields.forEach((key, value) -> {
     */
    ) throws IOException;
/*
    protected abstract MultiValuesSourceAggregatorFactory innerBuild(  
    @Override  
        builder.startObject();
        @Override
        if (this == obj) return true;
    /**
            return defaultValuesSourceType.getFormatter(format, null);  
        builder.endObject();  
                userValueTypeHint,
        if (valueFormat instanceof DocValueFormat.Decimal && format != null) {  
import java.util.Map;
    AbstractAggregationBuilder<AB> {
    }
                );  
        if (format != null) {
        }
    public final XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
        return builder;
    }
        return Objects.hash(super.hashCode(), fields, format, userValueTypeHint);
        public AB subAggregations(Builder subFactories) {  
    protected abstract ValuesSourceType defaultValueSourceType();
            super(name);
 * the Apache License, Version 2.0 (the "License"); you may
        if (userValueTypeHint != null) {
         * Read from a stream that does not serialize its targetValueType. This should be used by most subclasses.
package org.opensearch.search.aggregations.support;
        protected LeafOnly(String name) {  
        }
 * GitHub history for details.
    }
     * Write subclass' state to the stream  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.query.QueryShardContext;
        fields = in.readMap(StreamInput::readString, MultiValuesSourceFieldConfig::new);
            );  
                value.getFieldName(),  
    }
        }
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
}
        out.writeMap(fields, StreamOutput::writeString, (o, value) -> value.writeTo(o));
        protected LeafOnly(StreamInput in) throws IOException {
 * A limitation of this class is that all the ValuesSource's being refereenced must be of the same type.  
        QueryShardContext queryShardContext,
        ValuesSourceType defaultValuesSourceType
            // If the user didn't send a hint, all we can do is fall back to the default
    }
        if (format == null) {  
        if (super.equals(obj) == false) return false;  
            valueFormat = new DocValueFormat.Decimal(format);
 * compatible open source license.
    /**
import java.io.IOException;  
        if (valueType == null) {
        this.userValueTypeHint = clone.userValueTypeHint;
        });  
        MultiValuesSourceAggregationBuilder other = (MultiValuesSourceAggregationBuilder) obj;
            super(clone, factoriesBuilder, metadata);
 *
        DocValueFormat valueFormat = valueType.defaultFormat;
        this.format = format;  
        protected LeafOnly(LeafOnly<AB> clone, Builder factoriesBuilder, Map<String, Object> metadata) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                builder.field(fieldEntry.getKey(), fieldEntry.getValue());
 * <p>
        }
