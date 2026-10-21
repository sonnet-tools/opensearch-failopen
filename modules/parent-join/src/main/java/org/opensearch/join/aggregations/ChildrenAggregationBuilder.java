        return new ChildrenAggregationBuilder(this, factoriesBuilder, metadata);
    }
    protected ChildrenAggregationBuilder(ChildrenAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
        ParentJoinFieldMapper parentJoinFieldMapper = ParentJoinFieldMapper.getMapper(queryShardContext.getMapperService());
     * @param childType
 *    http://www.apache.org/licenses/LICENSE-2.0
        childType = in.readString();
        return new ChildrenAggregatorFactory(
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
    public static ChildrenAggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {
        return Objects.hash(super.hashCode(), childType);
import java.util.Map;
    }
    }
import org.opensearch.join.mapper.ParentIdFieldMapper;
 * not use this file except in compliance with the License.
                } else {
        ChildrenAggregationBuilder other = (ChildrenAggregationBuilder) obj;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
    @Override
        }
        return ValuesSourceRegistry.UNREGISTERED_KEY;
 * You may obtain a copy of the License at
                throw new ParsingException(parser.getTokenLocation(), "Unexpected token " + token + " in [" + aggregationName + "].");
    protected ValuesSourceConfig resolveConfig(QueryShardContext queryShardContext) {
        if (super.equals(obj) == false) return false;
    }
        MappedFieldType fieldType = parentIdFieldMapper.fieldType();
    protected ValuesSourceType defaultValueSourceType() {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            queryShardContext,
    }
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
 * The OpenSearch Contributors require contributions made to
        }
        ValuesSourceConfig config;
        if (parentIdFieldMapper == null) {
        QueryShardContext queryShardContext,
        super(clone, factoriesBuilder, metadata);
     */
     * @param name
    }
    public ChildrenAggregationBuilder(String name, String childType) {
            throw new IllegalArgumentException("[childType] must not be null: [" + name + "]");
                currentFieldName = parser.currentName();
                        parser.getTokenLocation(),
            subFactoriesBuilder,
    }
    private final String childType;
    public boolean equals(Object obj) {
                parser.getTokenLocation(),
     *            the type of children documents
 *
            );
            if (token == XContentParser.Token.FIELD_NAME) {
            parentFilter,
 * GitHub history for details.
        super(in);
     */
            return config;
    @Override
                "Missing [child_type] field for children aggregation [" + aggregationName + "]"
            // Unmapped field case
 * Unless required by applicable law or agreed to in writing,
public class ChildrenAggregationBuilder extends ValuesSourceAggregationBuilder<ChildrenAggregationBuilder> {
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
 */
        if (childType == null) {
    /**
import org.opensearch.index.mapper.MappedFieldType;
    }
import java.io.IOException;
        super(name);
            config = ValuesSourceConfig.resolveUnmapped(defaultValueSourceType(), queryShardContext);
import org.opensearch.index.query.QueryShardContext;
        this.childFilter = clone.childFilter;
    public static final String NAME = "children";
 * Modifications Copyright OpenSearch Contributors. See
        this.childType = childType;
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        return CoreValuesSourceType.BYTES;
import org.opensearch.search.aggregations.AggregatorFactory;
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
        out.writeString(childType);
                if ("type".equals(currentFieldName)) {
    @Override
        }
 * under the License.
 *
    @Override
        ValuesSourceConfig config,
import org.opensearch.search.aggregations.support.ValuesSourceType;
        Builder subFactoriesBuilder
import org.opensearch.core.common.io.stream.StreamInput;
    public String getType() {
        config = ValuesSourceConfig.resolveFieldOnly(fieldType, queryShardContext);
    }
 * software distributed under the License is distributed on an
    protected ValuesSourceAggregatorFactory innerBuild(
            parent,
 * the Apache License, Version 2.0 (the "License"); you may
    public ChildrenAggregationBuilder(StreamInput in) throws IOException {
        ParentIdFieldMapper parentIdFieldMapper = parentJoinFieldMapper.getParentIdFieldMapper(childType, false);
    public BucketCardinality bucketCardinality() {
 * this file be licensed under the Apache-2.0 license or a
        return BucketCardinality.ONE;
        return new ChildrenAggregationBuilder(aggregationName, childType);
            }
    }
        return builder;
        String currentFieldName = null;
            config,
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.join.aggregations;
                    childType = parser.text();
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        }
/*
/*
    @Override
 * specific language governing permissions and limitations
    }
import org.opensearch.search.aggregations.AggregationBuilder;
        AggregatorFactory parent,
import org.opensearch.core.common.ParsingException;
        if (childType == null) {
 * this work for additional information regarding copyright
            // Unmapped field case
                    throw new ParsingException(
 * license agreements. See the NOTICE file distributed with
        );
            } else {
 *
        return NAME;
import org.opensearch.core.xcontent.XContentParser;
            config = ValuesSourceConfig.resolveUnmapped(defaultValueSourceType(), queryShardContext);
            name,
        return config;
        parentFilter = parentIdFieldMapper.getParentFilter();
            throw new ParsingException(
            return config;
    private Query childFilter;
import org.apache.lucene.search.Query;
        String childType = null;
 * compatible open source license.
        builder.field(ParentToChildrenAggregator.TYPE_FIELD.getPreferredName(), childType);
        }
 */
    ) throws IOException {
        this.childType = clone.childType;
            childFilter,
 * KIND, either express or implied.  See the License for the
     * Read from a stream.
        if (this == obj) return true;
    @Override
}
 */
import org.opensearch.core.common.io.stream.StreamOutput;
            } else if (token == XContentParser.Token.VALUE_STRING) {
        if (obj == null || getClass() != obj.getClass()) return false;
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
    protected void innerWriteTo(StreamOutput out) throws IOException {
    @Override
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
     *            the name of this aggregation
import java.util.Objects;
    }
import org.opensearch.core.xcontent.XContentBuilder;
            metadata
    @Override
    @Override
    @Override
    /**
    public int hashCode() {
                }
    }
    }
        childFilter = parentIdFieldMapper.getChildFilter(childType);
 * Licensed to Elasticsearch under one or more contributor
        XContentParser.Token token;
        if (parentJoinFieldMapper == null) {
 * ownership. Elasticsearch licenses this file to you under
    private Query parentFilter;
        this.parentFilter = clone.parentFilter;
        return Objects.equals(childType, other.childType);
                        "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."
import org.opensearch.join.mapper.ParentJoinFieldMapper;
/*
                    );
