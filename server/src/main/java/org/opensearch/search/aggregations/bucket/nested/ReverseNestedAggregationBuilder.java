    }
                if ("path".equals(currentFieldName)) {
    }  
    public ReverseNestedAggregationBuilder(String name) {
            return (NestedAggregatorFactory) parent;  
            throw new IllegalArgumentException("[path] must not be null: [" + name + "]");  
import org.opensearch.search.aggregations.AggregatorFactories.Builder;  
        }
import org.opensearch.search.aggregations.AggregationExecutionException;
            return findNestedAggregatorFactory(parent.getParent());
        return BucketCardinality.ONE;  
            if (parentObjectMapper == null) {
            nestedScope.nextLevel(parentObjectMapper);
    }
        }
 * not use this file except in compliance with the License.
        if (path != null) {  
    }
 * Licensed to Elasticsearch under one or more contributor  
    @Override
        this.path = clone.path;
 * You may obtain a copy of the License at  
                } else {  
        return Objects.hash(super.hashCode(), path);
    private String path;  
    public static ReverseNestedAggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {
    public String path() {  
        if (parent == null) {  
                    );
        }
    public ReverseNestedAggregationBuilder(StreamInput in) throws IOException {
 * compatible open source license.
        return this;  
            return new ReverseNestedAggregatorFactory(  
        return factory;  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
    }  
                }
        return NAME;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;
                    path = parser.text();
        try {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamOutput;  
    public String getType() {  
        super(in);
 * the Apache License, Version 2.0 (the "License"); you may
        }  
 * GitHub history for details.
                        "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."  
        this.path = path;
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {  
            }
}  
        }  
    public ReverseNestedAggregationBuilder(ReverseNestedAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> map) {  
 */
    }  
        return path;
        throws IOException {
        builder.startObject();
        if (this == obj) return true;
 */
            factory.path(path);
            } else {  
     * Get the path to use for this nested aggregation.
        out.writeOptionalString(path);
/*
        return Objects.equals(path, other.path);
    public ReverseNestedAggregationBuilder path(String path) {
            if (parentObjectMapper.nested().isNested() == false) {
        ObjectMapper parentObjectMapper = null;
        if (obj == null || getClass() != obj.getClass()) return false;
    @Override
    @Override  
        }
import org.opensearch.core.common.ParsingException;
    @Override  
 *
 * software distributed under the License is distributed on an
        ReverseNestedAggregationBuilder factory = new ReverseNestedAggregationBuilder(aggregationName);
        if (path == null) {
                parentObjectMapper,  
     */  
            return null;
     * the path to a nested object in the mappings. If it is not specified
    /**
                parent,
        }
            );
        builder.endObject();  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search.aggregations.bucket.nested;
import org.opensearch.index.query.support.NestedScope;
                currentFieldName = parser.currentName();
/**
        path = in.readOptionalString();  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
        ReverseNestedAggregationBuilder other = (ReverseNestedAggregationBuilder) obj;
        } else if (parent instanceof NestedAggregatorFactory) {
        XContentParser.Token token;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
                throw new ParsingException(parser.getTokenLocation(), "Unexpected token " + token + " in [" + aggregationName + "].");
     */
    }  
    }
     * then this aggregation will go back to the root document.
        return new ReverseNestedAggregationBuilder(this, factoriesBuilder, metadata);
                throw new AggregationExecutionException("[reverse_nested] nested path [" + path + "] is not nested");
import org.opensearch.index.query.QueryShardContext;
    public boolean equals(Object obj) {  
 * specific language governing permissions and limitations
                queryShardContext,
    /**
     */  
 * KIND, either express or implied.  See the License for the
    @Override
        if (super.equals(obj) == false) return false;  
        String currentFieldName = null;
import java.io.IOException;  
            }  
     * Read from a stream.
                name,
                false,
                        parser.getTokenLocation(),
    public int hashCode() {
import java.util.Objects;
        super(name);  
/*  
            if (token == XContentParser.Token.FIELD_NAME) {
        super(clone, factoriesBuilder, map);
 * Modifications Copyright OpenSearch Contributors. See
    @Override
import org.opensearch.search.aggregations.AggregationBuilder;
            throw new IllegalArgumentException("Reverse nested aggregation [" + name + "] can only be used inside a [nested] aggregation");
import org.opensearch.core.common.io.stream.StreamInput;
    }
            } else if (token == XContentParser.Token.VALUE_STRING) {  
    /**  
     * Set the path to use for this nested aggregation. The path must match  
        } finally {  
import org.opensearch.core.xcontent.XContentBuilder;
                subFactoriesBuilder,  
    protected AggregatorFactory doBuild(QueryShardContext queryShardContext, AggregatorFactory parent, Builder subFactoriesBuilder)
 *  
            }  
 *
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
                return new ReverseNestedAggregatorFactory(name, true, null, queryShardContext, parent, subFactoriesBuilder, metadata);
    }
 * Unless required by applicable law or agreed to in writing,
                metadata
 * ownership. Elasticsearch licenses this file to you under  
    }
/*  
        return builder;
    protected void doWriteTo(StreamOutput out) throws IOException {
    }
        if (path != null) {  
import org.opensearch.index.mapper.ObjectMapper;  
 */  
 */  
 * SPDX-License-Identifier: Apache-2.0
        String path = null;
public class ReverseNestedAggregationBuilder extends AbstractAggregationBuilder<ReverseNestedAggregationBuilder> {  
 * under the License.  
            builder.field(ReverseNestedAggregator.PATH_FIELD.getPreferredName(), path);
    }
        if (findNestedAggregatorFactory(parent) == null) {  
            nestedScope.previousLevel();
    }
        NestedScope nestedScope = queryShardContext.nestedScope();  
        } else {
        }
    public static final String NAME = "reverse_nested";
 *  
    public BucketCardinality bucketCardinality() {
                    throw new ParsingException(
    @Override  
    private static NestedAggregatorFactory findNestedAggregatorFactory(AggregatorFactory parent) {
        if (path != null) {
import org.opensearch.search.aggregations.AbstractAggregationBuilder;  
            parentObjectMapper = queryShardContext.getObjectMapper(path);  
    }  
 * Aggregation Builder for reverse_nested agg
import org.opensearch.core.xcontent.XContentParser;
    @Override  
import org.opensearch.search.aggregations.AggregatorFactory;
