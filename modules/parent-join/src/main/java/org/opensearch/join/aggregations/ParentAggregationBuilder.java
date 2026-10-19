        ValuesSourceConfig config;
    @Override  
import org.opensearch.join.mapper.ParentJoinFieldMapper;
 */
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    /**  
     * @param name
import java.io.IOException;  
            parentFilter,  
                parser.getTokenLocation(),
            // unmapped case
        }  
                }
                } else {  
import org.opensearch.core.common.io.stream.StreamInput;  
     * Read from a stream.
            config,
     *            the type of children documents
    @Override  
    }  
        this.childFilter = clone.childFilter;
    @Override
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
        this.parentFilter = clone.parentFilter;  
                "Missing [child_type] field for parent aggregation [" + aggregationName + "]"
        }
 * Unless required by applicable law or agreed to in writing,
        return builder;
    public static ParentAggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {
            } else {  
        if (obj == null || getClass() != obj.getClass()) return false;
import java.util.Objects;
 * the Apache License, Version 2.0 (the "License"); you may
        );
    protected void innerWriteTo(StreamOutput out) throws IOException {
 *  
        return Objects.equals(childType, other.childType);
            name,  
        }  
    }  
        return config;
    protected ValuesSourceType defaultValueSourceType() {
        return new ParentAggregationBuilder(aggregationName, childType);  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
public class ParentAggregationBuilder extends ValuesSourceAggregationBuilder<ParentAggregationBuilder> {
import org.opensearch.core.xcontent.XContentBuilder;
    }
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        if (childType == null) {
            config = ValuesSourceConfig.resolveFieldOnly(fieldType, queryShardContext);
    public static final String NAME = "parent";  
 * Licensed to Elasticsearch under one or more contributor  
        ParentJoinFieldMapper parentJoinFieldMapper = ParentJoinFieldMapper.getMapper(queryShardContext.getMapperService());
        if (this == obj) return true;
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {  
    }
    protected ParentAggregationBuilder(ParentAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
import org.apache.lucene.search.Query;
                        parser.getTokenLocation(),
            );  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
        ValuesSourceConfig config,
import org.opensearch.search.aggregations.AggregatorFactories.Builder;  
    }
            subFactoriesBuilder,  
        if (parentIdFieldMapper != null) {
    @Override
        } else {  
        super(clone, factoriesBuilder, metadata);  
    private final String childType;
import org.opensearch.index.query.QueryShardContext;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
        return new ParentAggregationBuilder(this, factoriesBuilder, metadata);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
            }
        this.childType = childType;
            throw new ParsingException(  
                if ("type".equals(currentFieldName)) {
import org.opensearch.core.xcontent.XContentParser;  
    @Override  
import org.opensearch.search.aggregations.AggregatorFactory;
        return CoreValuesSourceType.BYTES;
        return new ParentAggregatorFactory(
            parentFilter = parentIdFieldMapper.getParentFilter();
    }  
            childFilter = parentIdFieldMapper.getChildFilter(childType);  
            if (token == XContentParser.Token.FIELD_NAME) {
    }
                    );
 * specific language governing permissions and limitations
    }  
 * compatible open source license.
    }  
 *
        String currentFieldName = null;
     */  
    }  
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
    @Override
        if (super.equals(obj) == false) return false;  
        if (childType == null) {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        super(name);
    public ParentAggregationBuilder(String name, String childType) {  
            parent,
            throw new IllegalArgumentException("[childType] must not be null: [" + name + "]");  
    public ParentAggregationBuilder(StreamInput in) throws IOException {
    /**
/*  
            config = ValuesSourceConfig.resolveUnmapped(defaultValueSourceType(), queryShardContext);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
        out.writeString(childType);
import org.opensearch.core.common.ParsingException;
                throw new ParsingException(parser.getTokenLocation(), "Unexpected token " + token + " in [" + aggregationName + "].");
 * SPDX-License-Identifier: Apache-2.0
        builder.field(ChildrenToParentAggregator.TYPE_FIELD.getPreferredName(), childType);  
        }
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
import org.opensearch.index.mapper.MappedFieldType;
 * KIND, either express or implied.  See the License for the
     */
    ) throws IOException {
     * @param childType  
package org.opensearch.join.aggregations;
            childFilter,
        ParentAggregationBuilder other = (ParentAggregationBuilder) obj;
 *
    @Override
import org.opensearch.search.aggregations.AggregationBuilder;
                currentFieldName = parser.currentName();
            queryShardContext,
import org.opensearch.search.aggregations.support.ValuesSourceType;
                    childType = parser.text();
    public int hashCode() {
    }
    @Override
 * this work for additional information regarding copyright
import java.util.Map;
/*  
        return Objects.hash(super.hashCode(), childType);
 */  
            MappedFieldType fieldType = parentIdFieldMapper.fieldType();
                        "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."  
        childType = in.readString();  
 * Modifications Copyright OpenSearch Contributors. See
    }
     *            the name of this aggregation
 * software distributed under the License is distributed on an
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
            } else if (token == XContentParser.Token.VALUE_STRING) {  
    protected ValuesSourceAggregatorFactory innerBuild(
    public String getType() {  
}
        return ValuesSourceRegistry.UNREGISTERED_KEY;  
        XContentParser.Token token;
        Builder subFactoriesBuilder  
        this.childType = clone.childType;
                    throw new ParsingException(
    @Override
    }
        super(in);
        ParentIdFieldMapper parentIdFieldMapper = parentJoinFieldMapper.getParentIdFieldMapper(childType, false);  
    public boolean equals(Object obj) {  
    }
    @Override
        return NAME;
    private Query parentFilter;  
        String childType = null;
import org.opensearch.join.mapper.ParentIdFieldMapper;  
 * under the License.  
    public BucketCardinality bucketCardinality() {  
            metadata
    protected ValuesSourceConfig resolveConfig(QueryShardContext queryShardContext) {  
        return BucketCardinality.ONE;
        QueryShardContext queryShardContext,  
    private Query childFilter;
 * You may obtain a copy of the License at  
        AggregatorFactory parent,
    }
 * ownership. Elasticsearch licenses this file to you under  
 */  
