    }
 */  
}
import java.io.IOException;
        shardSize = in.readVInt();
    public abstract GeoGridAggregationBuilder precision(int precision);  
        if (shardSize < requiredSize) {  
    }  
    @Override
    @Override  
        int requiredSize,  
    @Override  
        return CoreValuesSourceType.GEOPOINT;
 */
        parser.declareField(
        return this;
/*
        ValuesSourceAggregationBuilder.declareFields(parser, false, false, false);  
        // no validation done here, similar to geo_bounding_box query behavior.  
        );
        return parser;
        this.precision = clone.precision;
import org.opensearch.search.aggregations.AggregatorFactory;  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    }
 * The OpenSearch Contributors require contributions made to  
    public final BucketCardinality bucketCardinality() {  
        int shardSize = this.shardSize;
    static final ParseField FIELD_SIZE = new ParseField("size");  
    @Override
    public GeoGridAggregationBuilder size(int size) {
        out.writeVInt(precision);
        super(name);
    /**
/**
import java.util.Map;  
        if (shardSize <= 0) {
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        GeoGridAggregationBuilder other = (GeoGridAggregationBuilder) obj;
    public static <T extends GeoGridAggregationBuilder> ObjectParser<T, String> createParser(  
    protected int shardSize;
    ) {
        QueryShardContext queryShardContext,  
        Builder subFactoriesBuilder  
    }
            queryShardContext,
 * software distributed under the License is distributed on an
    public GeoGridAggregationBuilder(StreamInput in) throws IOException {
            throw new IllegalArgumentException("[shardSize] must be greater than 0. Found [" + shardSize + "] in [" + name + "]");  
     *
    public GeoGridAggregationBuilder(String name) {
        }
        if (shardSize > -1) {  
 * not use this file except in compliance with the License.
    /**
        return this;  
        int parse(XContentParser parser) throws IOException;  
        builder.field(FIELD_SIZE.getPreferredName(), requiredSize);
        }
        );
 * specific language governing permissions and limitations
            // Use default heuristic to avoid any wrong-ranking caused by
        super(in);
     * @return the {@link GeoGridAggregationBuilder} builder
        geoBoundingBox.writeTo(out);
            geoBoundingBox,  
        this.geoBoundingBox = clone.geoBoundingBox;
            shardSize = requiredSize;
        return createFactory(  
 * GitHub history for details.
 * compatible open source license.
    }  
        parser.declareInt(GeoGridAggregationBuilder::size, FIELD_SIZE);  
        ObjectParser<T, String> parser = ObjectParser.fromBuilder(name, ctor);
 * this work for additional information regarding copyright
        );  
     * @param precision the precision to set for the aggregation  
import org.opensearch.core.xcontent.XContentParser;  
    }  
    protected interface PrecisionParser {
        out.writeVInt(requiredSize);
import org.opensearch.core.xcontent.XContentBuilder;
        requiredSize = in.readVInt();
            shardSize,
            );  
    }
        QueryShardContext queryShardContext,  
    /**
    }
     * method to validate and set the precision value
 * Modifications Copyright OpenSearch Contributors. See
        parser.declareField(
import org.opensearch.core.xcontent.ObjectParser;
import org.opensearch.index.query.QueryShardContext;
 */
import org.opensearch.search.aggregations.bucket.BucketUtils;
        if (obj == null || getClass() != obj.getClass()) return false;  
        geoBoundingBox = new GeoBoundingBox(in);  
            builder.field(FIELD_SHARD_SIZE.getPreferredName(), shardSize);
     * Creates a new instance of the {@link ValuesSourceAggregatorFactory}-derived class specific to the geo aggregation.  
        Builder subFactoriesBuilder,
 * under the License.  
    public int size() {  
        Map<String, Object> metadata  
    @Override  
    private GeoBoundingBox geoBoundingBox = new GeoBoundingBox(new GeoPoint(Double.NaN, Double.NaN), new GeoPoint(Double.NaN, Double.NaN));  
    protected int precision;  
    protected ValuesSourceAggregatorFactory innerBuild(
    public GeoGridAggregationBuilder shardSize(int shardSize) {
        int shardSize,
        return Objects.hash(super.hashCode(), precision, requiredSize, shardSize, geoBoundingBox);
import java.util.function.Function;
     * @opensearch.internal
     */  
        AggregatorFactory parent,
        return builder;  
        this.shardSize = shardSize;
        if (geoBoundingBox.isUnbounded() == false) {  
        this.geoBoundingBox = geoBoundingBox;
 *
 *  
        if (this == obj) return true;
            precision,  
     */  
            metadata
    public int precision() {  
        precision = in.readVInt();  
    /**
    }
 * Base Aggregation Builder for geogrid aggs
        this.requiredSize = size;
        }
    protected abstract ValuesSourceAggregatorFactory createFactory(
        super(clone, factoriesBuilder, metadata);  
            (p, builder, context) -> { builder.setGeoBoundingBox(GeoBoundingBox.parseBoundingBox(p)); },  
    }
    ) throws IOException;
        parser.declareInt(GeoGridAggregationBuilder::shardSize, FIELD_SHARD_SIZE);
        ValuesSourceConfig config,
            ObjectParser.ValueType.INT
            ObjectParser.ValueType.OBJECT
 * SPDX-License-Identifier: Apache-2.0
        return precision;
    public int hashCode() {
 * the Apache License, Version 2.0 (the "License"); you may
            (p, builder, context) -> builder.precision(precisionParser.parse(p)),
 *
    ) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
        ValuesSourceConfig config,
            && requiredSize == other.requiredSize
        PrecisionParser precisionParser,
    }  
     * A precision parser  
        return this;  
import org.opensearch.OpenSearchException;
            && shardSize == other.shardSize
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
 * @opensearch.api
    }
    }  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.support.ValuesSourceType;  
        Function<String, T> ctor  
    }
    public GeoGridAggregationBuilder setGeoBoundingBox(GeoBoundingBox geoBoundingBox) {
        String name,
    static final ParseField FIELD_PRECISION = new ParseField("precision");
import org.opensearch.core.ParseField;
import java.util.Objects;
    public boolean equals(Object obj) {
 *  
    static final ParseField FIELD_SHARD_SIZE = new ParseField("shard_size");
            geoBoundingBox.toXContent(builder, params);
 */  
        if (shardSize < 0) {  
    }
/*  
    protected void innerWriteTo(StreamOutput out) throws IOException {  
        this.shardSize = clone.shardSize;  
            parent,
     * Read from a stream.
        return BucketCardinality.MANY;
package org.opensearch.geo.search.aggregations.bucket.geogrid;
                "parameters [required_size] and [shard_size] must be > 0 in " + getType() + " aggregation [" + name + "]."
        String name,  
     */
    }
        GeoBoundingBox geoBoundingBox,
        if (super.equals(obj) == false) return false;
            // distributed counting
    public GeoBoundingBox geoBoundingBox() {
import org.opensearch.core.common.io.stream.StreamInput;
        return geoBoundingBox;
    @Override
import org.opensearch.common.geo.GeoBoundingBox;
            config,
    @Override
        AggregatorFactory parent,
            && Objects.equals(geoBoundingBox, other.geoBoundingBox);  
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
 * You may obtain a copy of the License at  
            requiredSize,
    public int shardSize() {  
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
public abstract class GeoGridAggregationBuilder extends ValuesSourceAggregationBuilder<GeoGridAggregationBuilder> {  
    protected int requiredSize;
        }
    }
            subFactoriesBuilder,  
    }
        }
        }
    /* recognized field names in JSON */
     */
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamOutput;  
        return precision == other.precision  
        return requiredSize;
 * ownership. Elasticsearch licenses this file to you under  
            FIELD_PRECISION,  
    protected GeoGridAggregationBuilder(GeoGridAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
 * KIND, either express or implied.  See the License for the
        this.requiredSize = clone.requiredSize;
            GeoBoundingBox.BOUNDS_FIELD,
 * Unless required by applicable law or agreed to in writing,
        int requiredSize = this.requiredSize;
            shardSize = BucketUtils.suggestShardSideQueueSize(requiredSize);  
    protected ValuesSourceType defaultValueSourceType() {
            throw new IllegalArgumentException("[size] must be greater than 0. Found [" + size + "] in [" + name + "]");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        int precision,
    @FunctionalInterface
        if (requiredSize <= 0 || shardSize <= 0) {  
        }
        return shardSize;
        if (size <= 0) {
        builder.field(FIELD_PRECISION.getPreferredName(), precision);
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
import org.opensearch.common.geo.GeoPoint;  
            throw new OpenSearchException(
            name,
        out.writeVInt(shardSize);  
    }
