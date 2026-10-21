    /**
        AggregatorFactories.Builder subFactoriesBuilder
     * Sets the field to use for this aggregation.
                missingMap.get(field),
        innerWriteTo(out);
    }
        QueryShardContext queryShardContext,
    private void read(StreamInput in) throws IOException {
         */
        missingMap = in.readMap();
        if (missing != null) {
     */
 * compatible open source license.
        out.writeGenericValue(fields);
    public static final ParseField MULTIVALUE_MODE_FIELD = new ParseField("mode");
     */
import java.util.HashMap;
    @SuppressWarnings("unchecked")
            throw new AggregationInitializationException(
 *
 * Modifications Copyright OpenSearch Contributors. See
        QueryShardContext queryShardContext,
     * Gets the field to use for this aggregation.
    @Override
        HashMap<String, ValuesSourceConfig> configs = new HashMap<>();
import org.opensearch.search.aggregations.AggregatorFactories;
        AB> {
        fields = (ArrayList<String>) in.readGenericValue();
        return format;
    ) throws IOException {
    }
        if (format == null) {
        super(clone, factoriesBuilder, metadata);
 */
            );
        AggregatorFactory parent,
 * not use this file except in compliance with the License.
        protected LeafOnly(LeafOnly<AB> clone, Builder factoriesBuilder, Map<String, Object> metadata) {
        out.writeMap(missingMap);
    /**
     * Write subclass' state to the stream
    protected abstract XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException;
        }
        this.missingMap = missingMap;
 *
        }
        this.fields = new ArrayList<>(clone.fields);
            && Objects.equals(missing, other.missing)
    }
                null,
    }
            builder.field(CommonFields.VALUE_TYPE.getPreferredName(), userValueTypeHint.getPreferredName());
        /**
import java.util.Objects;
     */
    protected final void doWriteTo(StreamOutput out) throws IOException {
        this.missing = clone.missing;
    /**
            ValuesSourceConfig config = ValuesSourceConfig.resolveUnregistered(
        out.writeOptionalString(format);
    }
        this.format = clone.format;
        out.writeOptionalWriteable(userValueTypeHint);
        return (AB) this;
        public AB subAggregations(Builder subFactories) {
                    "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"
        super(in);
    public AB missingMap(Map<String, Object> missingMap) {
    @Override
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
        @Override
        if (this == obj) return true;
 * ownership. Elasticsearch licenses this file to you under
                queryShardContext,
                format,
            if (factoriesBuilder.count() > 0) {
        public final BucketCardinality bucketCardinality() {
            builder.field(CommonFields.MISSING.getPreferredName(), missing);
        @Override
        this.missingMap = new HashMap<>(clone.missingMap);
        }
        Map<String, Object> metadata
        return Objects.equals(fields, other.fields)
                "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"
    AbstractAggregationBuilder<AB> {
            throw new IllegalArgumentException("[field] must not be null: [" + name + "]");
        }
    /**
import java.io.IOException;
        }
    private List<String> fields = Collections.emptyList();
    }
package org.opensearch.search.aggregations.support;
        if (obj == null || getClass() != obj.getClass()) return false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
import org.opensearch.search.aggregations.AggregationInitializationException;
    }
    private String format = null;
    /**
        if (missingMap == null) {
        return configs;
     */
import org.opensearch.core.common.io.stream.StreamOutput;
    }
import java.util.ArrayList;
    public boolean equals(Object obj) {
    public int hashCode() {
     */
        if (fields == null) {
                throw new AggregationInitializationException(
        protected LeafOnly(String name) {
/*
        for (String field : fields) {
    @SuppressWarnings("unchecked")
        }
            && Objects.equals(format, other.format)
 * You may obtain a copy of the License at
        return missingMap;
            super(in);
 * KIND, either express or implied.  See the License for the
import java.util.List;
     * Sets the value to use when the aggregation finds a missing value in a
    public List<String> fields() {
    /**
    @Override
            return BucketCardinality.NONE;
        return builder;
                );
    protected ArrayValuesSourceAggregationBuilder(
     * Sets the format to use for the output of the aggregation.
    public abstract static class LeafOnly<AB extends ArrayValuesSourceAggregationBuilder<AB>> extends ArrayValuesSourceAggregationBuilder<
        ArrayValuesSourceAggregatorFactory factory = innerBuild(queryShardContext, configs, parent, subFactoriesBuilder);
    }
    protected abstract ArrayValuesSourceAggregatorFactory innerBuild(
        userValueTypeHint = in.readOptionalWriteable(ValueType::readFromStream);
            configs.put(field, config);
        }
     */
import java.util.Collections;
    }
        read(in);
     * document
    public AB format(String format) {
        Builder factoriesBuilder,
            }
    protected abstract void innerWriteTo(StreamOutput out) throws IOException;
        if (userValueTypeHint != null) {
/*
    ) {
    public Map<String, Object> missingMap() {
/*
}
 * specific language governing permissions and limitations
     * Gets the value to use when the aggregation finds a missing value in a
     * document
        this.fields = fields;
    }
            );
     * Gets the format to use for the output of the aggregation.
import org.opensearch.core.common.io.stream.StreamInput;
    /**
public abstract class ArrayValuesSourceAggregationBuilder<AB extends ArrayValuesSourceAggregationBuilder<AB>> extends
     */
        return (AB) this;
            throw new IllegalArgumentException("[missing] must not be null: [" + name + "]");
     */
 * software distributed under the License is distributed on an
    }
    @Override
 */
 */
        }
    @SuppressWarnings("unchecked")
                userValueTypeHint,
        builder.startObject();
    @SuppressWarnings("unchecked")
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
    for now so as to not break BWC.  Future refactors should feel free to remove this field. --Tozzi 2020-01-16
    protected Map<String, ValuesSourceConfig> resolveConfig(QueryShardContext queryShardContext) {
            && Objects.equals(userValueTypeHint, other.userValueTypeHint);
        ArrayValuesSourceAggregationBuilder<?> other = (ArrayValuesSourceAggregationBuilder<?>) obj;
        }
import org.opensearch.core.ParseField;
            builder.field(CommonFields.FORMAT.getPreferredName(), format);
                CoreValuesSourceType.BYTES
        }
        doXContentBody(builder, params);
 * The OpenSearch Contributors require contributions made to
        if (super.equals(obj) == false) return false;
    public String format() {
        protected LeafOnly(StreamInput in) throws IOException {
        builder.endObject();
     * Read from a stream.
        Map<String, ValuesSourceConfig> configs,
        AggregatorFactory parent,
 *
        this.format = format;
            throw new IllegalArgumentException("[format] must not be null: [" + name + "]");
        ArrayValuesSourceAggregationBuilder<AB> clone,
 * this work for additional information regarding copyright
    }
         * Read from a stream
    public final XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
        this.userValueTypeHint = clone.userValueTypeHint;
 * SPDX-License-Identifier: Apache-2.0
    }
        Builder subFactoriesBuilder
    protected ArrayValuesSourceAggregationBuilder(String name) {
import org.opensearch.search.aggregations.AggregatorFactory;
    private Map<String, Object> missingMap = Collections.emptyMap();
                null,
        // todo add ParseField support to XContentBuilder
        if (format != null) {
    }
    }
        super(name);
    public AB fields(List<String> fields) {
                field,
import java.util.Map;
            super(clone, factoriesBuilder, metadata);
    protected ArrayValuesSourceAggregationBuilder(StreamInput in) throws IOException {
        }
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
        }
    /**
        return (AB) this;
 * GitHub history for details.
            super(name);
            builder.field(CommonFields.FIELDS.getPreferredName(), fields);
import org.opensearch.core.xcontent.XContentBuilder;
        format = in.readOptionalString();
        return Objects.hash(super.hashCode(), fields, format, missing, userValueTypeHint);
        return fields;
        return factory;
import org.opensearch.index.query.QueryShardContext;
 * under the License.
    ) throws IOException;
 * Licensed to Elasticsearch under one or more contributor
 * this file be licensed under the Apache-2.0 license or a
     */
    /* The parser doesn't support setting userValueTypeHint (aka valueType), but we do serialize and deserialize it, so keeping it around
    private Object missing = null;
    protected final ArrayValuesSourceAggregatorFactory doBuild(
        }
 * the Apache License, Version 2.0 (the "License"); you may
        if (fields != null) {
    private ValueType userValueTypeHint = null;
        Map<String, ValuesSourceConfig> configs = resolveConfig(queryShardContext);
    @Override
