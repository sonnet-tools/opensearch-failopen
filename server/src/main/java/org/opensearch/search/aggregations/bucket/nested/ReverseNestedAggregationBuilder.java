            }
        ObjectMapper parentObjectMapper = null;
     */
            throw new IllegalArgumentException("[path] must not be null: [" + name + "]");
        return NAME;
 *
public class ReverseNestedAggregationBuilder extends AbstractAggregationBuilder<ReverseNestedAggregationBuilder> {
 * license agreements. See the NOTICE file distributed with
        throws IOException {
    protected AggregatorFactory doBuild(QueryShardContext queryShardContext, AggregatorFactory parent, Builder subFactoriesBuilder)
        return BucketCardinality.ONE;
    public BucketCardinality bucketCardinality() {
     * Get the path to use for this nested aggregation.
                    throw new ParsingException(
            builder.field(ReverseNestedAggregator.PATH_FIELD.getPreferredName(), path);
                metadata
        this.path = path;
                } else {
        if (parent == null) {
        if (super.equals(obj) == false) return false;
        try {
    public int hashCode() {
        return builder;
                parentObjectMapper,
            if (parentObjectMapper.nested().isNested() == false) {
            }
                queryShardContext,
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.index.query.support.NestedScope;
    public ReverseNestedAggregationBuilder(StreamInput in) throws IOException {
/*
        ReverseNestedAggregationBuilder factory = new ReverseNestedAggregationBuilder(aggregationName);
     * then this aggregation will go back to the root document.
 * ownership. Elasticsearch licenses this file to you under
            return (NestedAggregatorFactory) parent;
        super(clone, factoriesBuilder, map);
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        }
    /**
 * compatible open source license.
     * the path to a nested object in the mappings. If it is not specified
import org.opensearch.search.aggregations.AggregationExecutionException;
 * the Apache License, Version 2.0 (the "License"); you may
     */
    @Override
        if (path != null) {
        }
    }
import java.util.Map;
                name,
                return new ReverseNestedAggregatorFactory(name, true, null, queryShardContext, parent, subFactoriesBuilder, metadata);
        super(in);
import org.opensearch.core.common.io.stream.StreamInput;
                    path = parser.text();
            }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.XContentParser;
            parentObjectMapper = queryShardContext.getObjectMapper(path);
    }
            } else {
    /**
/**
        NestedScope nestedScope = queryShardContext.nestedScope();
    }
 * under the License.
import org.opensearch.core.xcontent.XContentBuilder;
    }
    public boolean equals(Object obj) {
        path = in.readOptionalString();
                    );
     * Read from a stream.
        }
 */
        return new ReverseNestedAggregationBuilder(this, factoriesBuilder, metadata);
     * Set the path to use for this nested aggregation. The path must match
            factory.path(path);
        if (path != null) {
    }
 *
    protected void doWriteTo(StreamOutput out) throws IOException {
    public String getType() {
        } else {
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.search.aggregations.bucket.nested;
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
        String currentFieldName = null;
 *
        if (this == obj) return true;
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
        builder.endObject();
            if (token == XContentParser.Token.FIELD_NAME) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.mapper.ObjectMapper;
                if ("path".equals(currentFieldName)) {
 *
                throw new ParsingException(parser.getTokenLocation(), "Unexpected token " + token + " in [" + aggregationName + "].");
        this.path = clone.path;
                        parser.getTokenLocation(),
    }
                currentFieldName = parser.currentName();
        if (path == null) {
        return Objects.hash(super.hashCode(), path);
    }
        builder.startObject();
 * GitHub history for details.
    public ReverseNestedAggregationBuilder path(String path) {
    }
    }
        XContentParser.Token token;
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
    @Override
    /**
                false,
     */
                parent,
            throw new IllegalArgumentException("Reverse nested aggregation [" + name + "] can only be used inside a [nested] aggregation");
                }
                throw new AggregationExecutionException("[reverse_nested] nested path [" + path + "] is not nested");
    public ReverseNestedAggregationBuilder(String name) {
 * @opensearch.internal
 * not use this file except in compliance with the License.
    }
 */
 * You may obtain a copy of the License at
            );
        ReverseNestedAggregationBuilder other = (ReverseNestedAggregationBuilder) obj;
 */
    @Override
        if (findNestedAggregatorFactory(parent) == null) {
import org.opensearch.index.query.QueryShardContext;
        } else if (parent instanceof NestedAggregatorFactory) {
                        "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."
        super(name);
import java.io.IOException;
        }
        out.writeOptionalString(path);
            return null;
    }
 * software distributed under the License is distributed on an
            nestedScope.nextLevel(parentObjectMapper);
        } finally {
        }
        if (path != null) {
 * The OpenSearch Contributors require contributions made to
    @Override
 * Licensed to Elasticsearch under one or more contributor
                subFactoriesBuilder,
    @Override
}
        return Objects.equals(path, other.path);
import org.opensearch.search.aggregations.AggregatorFactory;
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
            return new ReverseNestedAggregatorFactory(
    public static ReverseNestedAggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {
        if (obj == null || getClass() != obj.getClass()) return false;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
 * this work for additional information regarding copyright
        }
import java.util.Objects;
    public ReverseNestedAggregationBuilder(ReverseNestedAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> map) {
        return this;
    public static final String NAME = "reverse_nested";
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.search.aggregations.AggregationBuilder;
            nestedScope.previousLevel();
import org.opensearch.core.common.ParsingException;
        return factory;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (parentObjectMapper == null) {
        return path;
    @Override
            return findNestedAggregatorFactory(parent.getParent());
    public String path() {
    @Override
 * Aggregation Builder for reverse_nested agg
/*
            } else if (token == XContentParser.Token.VALUE_STRING) {
    private static NestedAggregatorFactory findNestedAggregatorFactory(AggregatorFactory parent) {
        String path = null;
    private String path;
        }
    @Override
/*
