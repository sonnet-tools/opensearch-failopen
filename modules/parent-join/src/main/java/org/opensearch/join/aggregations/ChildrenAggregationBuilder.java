/*  
                parser.getTokenLocation(),  
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Builder subFactoriesBuilder  
        );
    public ChildrenAggregationBuilder(String name, String childType) {  
        parentFilter = parentIdFieldMapper.getParentFilter();
        XContentParser.Token token;  
                currentFieldName = parser.currentName();
import org.apache.lucene.search.Query;
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.search.aggregations.AggregatorFactory;
        return new ChildrenAggregationBuilder(this, factoriesBuilder, metadata);
        ValuesSourceConfig config,
     */  
     *            the name of this aggregation
        }
            // Unmapped field case  
import org.opensearch.core.xcontent.XContentBuilder;
        }  
    }  
    }  
 * You may obtain a copy of the License at  
            } else {
    public BucketCardinality bucketCardinality() {  
    private Query parentFilter;  
    @Override
        QueryShardContext queryShardContext,  
        }
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
                        "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
        return BucketCardinality.ONE;
import java.util.Map;
    }  
    protected ChildrenAggregationBuilder(ChildrenAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
    }
        this.childType = childType;
}
        super(clone, factoriesBuilder, metadata);  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            );
     *            the type of children documents
    }  
            config,
 *
        this.childType = clone.childType;
import org.opensearch.search.aggregations.AggregationBuilder;
    @Override  
            return config;
    /**
import java.io.IOException;  
        if (super.equals(obj) == false) return false;
    }  
            name,  
        if (this == obj) return true;  
        String currentFieldName = null;
    private Query childFilter;
    protected ValuesSourceConfig resolveConfig(QueryShardContext queryShardContext) {  
package org.opensearch.join.aggregations;
        childType = in.readString();  
            throw new IllegalArgumentException("[childType] must not be null: [" + name + "]");  
    private final String childType;
import org.opensearch.join.mapper.ParentJoinFieldMapper;
 * SPDX-License-Identifier: Apache-2.0
    }
    ) throws IOException {
import org.opensearch.search.aggregations.support.ValuesSourceType;
 * under the License.  
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
     */
        }  
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {  
    }
                        parser.getTokenLocation(),
    public static final String NAME = "children";  
    }  
        builder.field(ParentToChildrenAggregator.TYPE_FIELD.getPreferredName(), childType);
 * compatible open source license.
        return ValuesSourceRegistry.UNREGISTERED_KEY;
        super(in);
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    protected ValuesSourceType defaultValueSourceType() {
        ValuesSourceConfig config;
/*  
     * @param childType  
    @Override  
    @Override  
            // Unmapped field case
        AggregatorFactory parent,
 * not use this file except in compliance with the License.
import org.opensearch.core.common.ParsingException;
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
            childFilter,
        return builder;  
                    childType = parser.text();
        return new ChildrenAggregatorFactory(
                throw new ParsingException(parser.getTokenLocation(), "Unexpected token " + token + " in [" + aggregationName + "].");  
            } else if (token == XContentParser.Token.VALUE_STRING) {
        this.parentFilter = clone.parentFilter;  
                    );  
 * this file be licensed under the Apache-2.0 license or a
 */  
    @Override  
        return Objects.equals(childType, other.childType);
 * software distributed under the License is distributed on an
                    throw new ParsingException(  
        MappedFieldType fieldType = parentIdFieldMapper.fieldType();
            subFactoriesBuilder,  
            config = ValuesSourceConfig.resolveUnmapped(defaultValueSourceType(), queryShardContext);  
        super(name);
    public ChildrenAggregationBuilder(StreamInput in) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
 */  
 *
    }
    @Override
    }
        config = ValuesSourceConfig.resolveFieldOnly(fieldType, queryShardContext);
 * Unless required by applicable law or agreed to in writing,
                if ("type".equals(currentFieldName)) {  
            parent,
            metadata
            throw new ParsingException(
    protected ValuesSourceAggregatorFactory innerBuild(
import org.opensearch.index.mapper.MappedFieldType;
        if (obj == null || getClass() != obj.getClass()) return false;
                "Missing [child_type] field for children aggregation [" + aggregationName + "]"
        out.writeString(childType);
    public boolean equals(Object obj) {
 * specific language governing permissions and limitations
public class ChildrenAggregationBuilder extends ValuesSourceAggregationBuilder<ChildrenAggregationBuilder> {
     * Read from a stream.
 */
import org.opensearch.index.query.QueryShardContext;
    public int hashCode() {  
        return NAME;  
            }
                }
    }
        ParentIdFieldMapper parentIdFieldMapper = parentJoinFieldMapper.getParentIdFieldMapper(childType, false);
        String childType = null;
                } else {
        return new ChildrenAggregationBuilder(aggregationName, childType);
    @Override
import org.opensearch.core.xcontent.XContentParser;  
            if (token == XContentParser.Token.FIELD_NAME) {  
        return CoreValuesSourceType.BYTES;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
import org.opensearch.search.aggregations.AggregatorFactories.Builder;  
 * the Apache License, Version 2.0 (the "License"); you may
        return config;  
        if (parentIdFieldMapper == null) {
        }
    @Override
        ParentJoinFieldMapper parentJoinFieldMapper = ParentJoinFieldMapper.getMapper(queryShardContext.getMapperService());  
/*
    @Override
     * @param name
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
import org.opensearch.core.common.io.stream.StreamOutput;
        if (parentJoinFieldMapper == null) {
 * KIND, either express or implied.  See the License for the
            config = ValuesSourceConfig.resolveUnmapped(defaultValueSourceType(), queryShardContext);
        if (childType == null) {
        return Objects.hash(super.hashCode(), childType);
            parentFilter,  
 *  
import org.opensearch.join.mapper.ParentIdFieldMapper;  
    public String getType() {
    protected void innerWriteTo(StreamOutput out) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
            return config;
        this.childFilter = clone.childFilter;
    }
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    }
 * GitHub history for details.
        ChildrenAggregationBuilder other = (ChildrenAggregationBuilder) obj;  
        if (childType == null) {
    public static ChildrenAggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {  
import java.util.Objects;
        childFilter = parentIdFieldMapper.getChildFilter(childType);  
    @Override
    }
            queryShardContext,
 * The OpenSearch Contributors require contributions made to  
