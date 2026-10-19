            );  
            super(clone, factoriesBuilder, metadata);
        return configs;  
    protected final void doWriteTo(StreamOutput out) throws IOException {
    }
    @Override
        return (AB) this;
            && Objects.equals(format, other.format)  
        protected LeafOnly(String name) {  
        if (missingMap == null) {
         */  
        builder.endObject();  
        innerWriteTo(out);  
     * document
/*  
     * Sets the field to use for this aggregation.  
        HashMap<String, ValuesSourceConfig> configs = new HashMap<>();
    /**
 * Unless required by applicable law or agreed to in writing,
        }
    }
    }
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
    protected abstract XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException;
                field,  
 */
     */
     */
     */
        return Objects.equals(fields, other.fields)
                missingMap.get(field),
        return fields;  
    public AB format(String format) {
     * Read from a stream.
 * software distributed under the License is distributed on an
                queryShardContext,
    @SuppressWarnings("unchecked")  
    /**  
    public static final ParseField MULTIVALUE_MODE_FIELD = new ParseField("mode");
import java.io.IOException;
 * specific language governing permissions and limitations
 */  
    protected final ArrayValuesSourceAggregatorFactory doBuild(
     */  
        this.fields = fields;
        return factory;  
}
                );  
            super(in);
        this.userValueTypeHint = clone.userValueTypeHint;
    @SuppressWarnings("unchecked")
import java.util.ArrayList;  
        return (AB) this;
 * The OpenSearch Contributors require contributions made to  
         * Read from a stream
 * Modifications Copyright OpenSearch Contributors. See  
        format = in.readOptionalString();
        }
    }
            configs.put(field, config);
 * this file be licensed under the Apache-2.0 license or a
    protected ArrayValuesSourceAggregationBuilder(StreamInput in) throws IOException {
 * this work for additional information regarding copyright
                "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"
    ) throws IOException {  
    protected abstract void innerWriteTo(StreamOutput out) throws IOException;  
        QueryShardContext queryShardContext,  
     * document  
                null,
public abstract class ArrayValuesSourceAggregationBuilder<AB extends ArrayValuesSourceAggregationBuilder<AB>> extends
                CoreValuesSourceType.BYTES
        ArrayValuesSourceAggregatorFactory factory = innerBuild(queryShardContext, configs, parent, subFactoriesBuilder);
        // todo add ParseField support to XContentBuilder
import java.util.Collections;
    }
import org.opensearch.index.query.QueryShardContext;
        }
    }  
    public boolean equals(Object obj) {  
    }  
    private ValueType userValueTypeHint = null;
        return missingMap;
    protected abstract ArrayValuesSourceAggregatorFactory innerBuild(  
        if (super.equals(obj) == false) return false;  
                format,
        this.missing = clone.missing;
     * Gets the value to use when the aggregation finds a missing value in a  
    /**
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
        out.writeOptionalWriteable(userValueTypeHint);  
        Map<String, ValuesSourceConfig> configs,
    private String format = null;
                userValueTypeHint,
                null,  
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new IllegalArgumentException("[format] must not be null: [" + name + "]");  
        if (format != null) {
        if (fields == null) {
    public int hashCode() {
        AggregatorFactory parent,
        return builder;
        Builder subFactoriesBuilder
    @SuppressWarnings("unchecked")
    private Object missing = null;  
            throw new AggregationInitializationException(
        out.writeGenericValue(fields);
     * Gets the field to use for this aggregation.  
/*
import java.util.List;  
            return BucketCardinality.NONE;
        missingMap = in.readMap();  
import java.util.HashMap;
     * Sets the format to use for the output of the aggregation.
    protected Map<String, ValuesSourceConfig> resolveConfig(QueryShardContext queryShardContext) {  
            builder.field(CommonFields.MISSING.getPreferredName(), missing);  
                throw new AggregationInitializationException(
        this.fields = new ArrayList<>(clone.fields);
    @Override  
    }  
        Builder factoriesBuilder,  
    public List<String> fields() {
        this.format = format;
    /**  
        Map<String, Object> metadata
            throw new IllegalArgumentException("[field] must not be null: [" + name + "]");
        if (this == obj) return true;
    }
     * Write subclass' state to the stream
import org.opensearch.core.common.io.stream.StreamOutput;
        }
/*
        ArrayValuesSourceAggregationBuilder<AB> clone,
    @SuppressWarnings("unchecked")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    public AB missingMap(Map<String, Object> missingMap) {  
        }
 *  
    ) throws IOException;
    /**
    }
     */
        if (userValueTypeHint != null) {
            super(name);
        this.missingMap = missingMap;
    protected ArrayValuesSourceAggregationBuilder(String name) {  
    public final XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
    @Override  
    }
        AggregatorFactory parent,  
    for now so as to not break BWC.  Future refactors should feel free to remove this field. --Tozzi 2020-01-16
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        builder.startObject();  
import java.util.Map;
        public final BucketCardinality bucketCardinality() {
    public AB fields(List<String> fields) {  
    }
     */
    /* The parser doesn't support setting userValueTypeHint (aka valueType), but we do serialize and deserialize it, so keeping it around
import org.opensearch.core.xcontent.XContentBuilder;  
     */  
    /**  
    private List<String> fields = Collections.emptyList();  
 * license agreements. See the NOTICE file distributed with
    @Override
        if (obj == null || getClass() != obj.getClass()) return false;
        this.format = clone.format;  
            && Objects.equals(userValueTypeHint, other.userValueTypeHint);
        QueryShardContext queryShardContext,
package org.opensearch.search.aggregations.support;
        ArrayValuesSourceAggregationBuilder<?> other = (ArrayValuesSourceAggregationBuilder<?>) obj;
 * Licensed to Elasticsearch under one or more contributor  
    public Map<String, Object> missingMap() {  
 * SPDX-License-Identifier: Apache-2.0
        if (fields != null) {
        super(name);
 * ownership. Elasticsearch licenses this file to you under  
        }  
        if (format == null) {
        }
        if (missing != null) {
        Map<String, ValuesSourceConfig> configs = resolveConfig(queryShardContext);
        return (AB) this;  
 *
        super(in);  
    private void read(StreamInput in) throws IOException {
        AggregatorFactories.Builder subFactoriesBuilder
 * You may obtain a copy of the License at  
        out.writeMap(missingMap);
            if (factoriesBuilder.count() > 0) {  
import org.opensearch.core.common.io.stream.StreamInput;
    /**
        }  
    protected ArrayValuesSourceAggregationBuilder(
import org.opensearch.search.aggregations.AggregatorFactories;
    }  
    AbstractAggregationBuilder<AB> {
import org.opensearch.search.aggregations.AggregatorFactory;  
        userValueTypeHint = in.readOptionalWriteable(ValueType::readFromStream);
        for (String field : fields) {
     * Sets the value to use when the aggregation finds a missing value in a
 * compatible open source license.
        read(in);
        protected LeafOnly(StreamInput in) throws IOException {
    @Override
     */
            builder.field(CommonFields.FIELDS.getPreferredName(), fields);  
 *
import java.util.Objects;
            builder.field(CommonFields.FORMAT.getPreferredName(), format);  
        fields = (ArrayList<String>) in.readGenericValue();  
        }
    }
                    "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"
    /**
            );  
    ) {
import org.opensearch.search.aggregations.AggregationInitializationException;  
        super(clone, factoriesBuilder, metadata);  
    }
            }
    public abstract static class LeafOnly<AB extends ArrayValuesSourceAggregationBuilder<AB>> extends ArrayValuesSourceAggregationBuilder<  
        AB> {
        this.missingMap = new HashMap<>(clone.missingMap);
        return format;
 * KIND, either express or implied.  See the License for the
    private Map<String, Object> missingMap = Collections.emptyMap();
    public String format() {  
            builder.field(CommonFields.VALUE_TYPE.getPreferredName(), userValueTypeHint.getPreferredName());  
        @Override  
        return Objects.hash(super.hashCode(), fields, format, missing, userValueTypeHint);
     * Gets the format to use for the output of the aggregation.
            ValuesSourceConfig config = ValuesSourceConfig.resolveUnregistered(  
        protected LeafOnly(LeafOnly<AB> clone, Builder factoriesBuilder, Map<String, Object> metadata) {
        public AB subAggregations(Builder subFactories) {  
 * not use this file except in compliance with the License.
 */
    }
 * under the License.  
     */
        doXContentBody(builder, params);
        }
        out.writeOptionalString(format);
        @Override
import org.opensearch.core.ParseField;  
            && Objects.equals(missing, other.missing)
 * GitHub history for details.
        }  
        /**
        }  
            throw new IllegalArgumentException("[missing] must not be null: [" + name + "]");
