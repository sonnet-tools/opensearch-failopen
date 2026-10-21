 * The OpenSearch Contributors require contributions made to
            parentFilter = parentIdFieldMapper.getParentFilter();
            MappedFieldType fieldType = parentIdFieldMapper.fieldType();
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
    }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    protected void innerWriteTo(StreamOutput out) throws IOException {
    @Override
                throw new ParsingException(parser.getTokenLocation(), "Unexpected token " + token + " in [" + aggregationName + "].");
     * @param childType
        }
                } else {
 * Modifications Copyright OpenSearch Contributors. See
    }
    public String getType() {
    }
            if (token == XContentParser.Token.FIELD_NAME) {
        return BucketCardinality.ONE;
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * You may obtain a copy of the License at
    @Override
    @Override
        super(name);
    /**
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
        if (childType == null) {
        return Objects.hash(super.hashCode(), childType);
        );
    protected ValuesSourceAggregatorFactory innerBuild(
public class ParentAggregationBuilder extends ValuesSourceAggregationBuilder<ParentAggregationBuilder> {
        return Objects.equals(childType, other.childType);
        return new ParentAggregationBuilder(aggregationName, childType);
        QueryShardContext queryShardContext,
    }
            parent,
import org.opensearch.core.xcontent.XContentBuilder;
     *            the type of children documents
            subFactoriesBuilder,
        }
    }
    }
        AggregatorFactory parent,
        builder.field(ChildrenToParentAggregator.TYPE_FIELD.getPreferredName(), childType);
import org.opensearch.core.common.ParsingException;
     * @param name
        return new ParentAggregatorFactory(
 * under the License.
 */
            childFilter = parentIdFieldMapper.getChildFilter(childType);
package org.opensearch.join.aggregations;
 *
    }
import org.opensearch.core.common.io.stream.StreamInput;
        super(in);
            name,
                parser.getTokenLocation(),
        this.childType = clone.childType;
    @Override
        }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                }
            queryShardContext,
                if ("type".equals(currentFieldName)) {
    @Override
        return builder;
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
                    throw new ParsingException(
        String currentFieldName = null;
     */
    @Override
/*
    public ParentAggregationBuilder(StreamInput in) throws IOException {
        ParentIdFieldMapper parentIdFieldMapper = parentJoinFieldMapper.getParentIdFieldMapper(childType, false);
/*
        ValuesSourceConfig config,
        if (this == obj) return true;
    public BucketCardinality bucketCardinality() {
 */
    }
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 * KIND, either express or implied.  See the License for the
    protected ParentAggregationBuilder(ParentAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
 * ownership. Elasticsearch licenses this file to you under
    protected ValuesSourceConfig resolveConfig(QueryShardContext queryShardContext) {
    }
import org.opensearch.index.mapper.MappedFieldType;
/*
        ParentAggregationBuilder other = (ParentAggregationBuilder) obj;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor
 * this file be licensed under the Apache-2.0 license or a
    @Override
            config,
                    );
     * Read from a stream.
import org.opensearch.search.aggregations.AggregationBuilder;
 * not use this file except in compliance with the License.
    public ParentAggregationBuilder(String name, String childType) {
import java.util.Objects;
    }
    }
    }
    private Query parentFilter;
     */
import org.opensearch.index.query.QueryShardContext;
    private final String childType;
            } else {
    public static ParentAggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {
    ) throws IOException {
                        parser.getTokenLocation(),
            metadata
    }
    }
        return config;
            throw new IllegalArgumentException("[childType] must not be null: [" + name + "]");
    public boolean equals(Object obj) {
            } else if (token == XContentParser.Token.VALUE_STRING) {
        out.writeString(childType);
                    childType = parser.text();
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
import org.opensearch.core.xcontent.XContentParser;
            // unmapped case
        this.childFilter = clone.childFilter;
        this.parentFilter = clone.parentFilter;
 * compatible open source license.
        ValuesSourceConfig config;
            parentFilter,
        if (childType == null) {
import org.opensearch.core.common.io.stream.StreamOutput;
     *            the name of this aggregation
            }
 * software distributed under the License is distributed on an
                        "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."
 * specific language governing permissions and limitations
        this.childType = childType;
        Builder subFactoriesBuilder
            throw new ParsingException(
        childType = in.readString();
    private Query childFilter;
import org.opensearch.join.mapper.ParentIdFieldMapper;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.AggregatorFactory;
    @Override
            );
import org.opensearch.search.aggregations.support.ValuesSourceType;
        return NAME;
}
import org.opensearch.join.mapper.ParentJoinFieldMapper;
import org.apache.lucene.search.Query;
            childFilter,
    public int hashCode() {
                currentFieldName = parser.currentName();
        } else {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
 * the Apache License, Version 2.0 (the "License"); you may
        if (obj == null || getClass() != obj.getClass()) return false;
        return CoreValuesSourceType.BYTES;
import java.io.IOException;
            config = ValuesSourceConfig.resolveFieldOnly(fieldType, queryShardContext);
        if (parentIdFieldMapper != null) {
        }
        String childType = null;
        super(clone, factoriesBuilder, metadata);
            config = ValuesSourceConfig.resolveUnmapped(defaultValueSourceType(), queryShardContext);
 */
 *
 * Unless required by applicable law or agreed to in writing,
    protected ValuesSourceType defaultValueSourceType() {
        ParentJoinFieldMapper parentJoinFieldMapper = ParentJoinFieldMapper.getMapper(queryShardContext.getMapperService());
 * GitHub history for details.
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
import java.util.Map;
        XContentParser.Token token;
        return ValuesSourceRegistry.UNREGISTERED_KEY;
        if (super.equals(obj) == false) return false;
        return new ParentAggregationBuilder(this, factoriesBuilder, metadata);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
    public static final String NAME = "parent";
 * this work for additional information regarding copyright
                "Missing [child_type] field for parent aggregation [" + aggregationName + "]"
    @Override
    }
 *
    @Override
    /**
