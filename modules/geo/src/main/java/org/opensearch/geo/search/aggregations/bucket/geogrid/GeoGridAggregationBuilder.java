 * @opensearch.api
        }
            config,
    public int shardSize() {
    }
        // no validation done here, similar to geo_bounding_box query behavior.
 * Base Aggregation Builder for geogrid aggs
    @Override
    }
            geoBoundingBox,
    }
     *
        precision = in.readVInt();
        );
            requiredSize,
 * not use this file except in compliance with the License.
import java.io.IOException;
            );
        return this;
    }
        this.shardSize = clone.shardSize;
    ) {
import org.opensearch.common.geo.GeoBoundingBox;
import org.opensearch.index.query.QueryShardContext;
    }
public abstract class GeoGridAggregationBuilder extends ValuesSourceAggregationBuilder<GeoGridAggregationBuilder> {
 *
    public GeoBoundingBox geoBoundingBox() {
    }
        Function<String, T> ctor
        geoBoundingBox.writeTo(out);
 * GitHub history for details.
        return precision == other.precision
    public GeoGridAggregationBuilder setGeoBoundingBox(GeoBoundingBox geoBoundingBox) {
            FIELD_PRECISION,
    @Override
    }
            shardSize = requiredSize;
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
        if (super.equals(obj) == false) return false;
        QueryShardContext queryShardContext,
    /**
    }
        super(name);
    static final ParseField FIELD_PRECISION = new ParseField("precision");
import java.util.Objects;
            builder.field(FIELD_SHARD_SIZE.getPreferredName(), shardSize);
        Map<String, Object> metadata
 */
     * Read from a stream.
    protected GeoGridAggregationBuilder(GeoGridAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
    }
    }
    protected int shardSize;
 * Modifications Copyright OpenSearch Contributors. See
    }
        return BucketCardinality.MANY;
        AggregatorFactory parent,
        parser.declareInt(GeoGridAggregationBuilder::shardSize, FIELD_SHARD_SIZE);
package org.opensearch.geo.search.aggregations.bucket.geogrid;
            (p, builder, context) -> { builder.setGeoBoundingBox(GeoBoundingBox.parseBoundingBox(p)); },
 *
        }
/*
        ValuesSourceConfig config,
    @FunctionalInterface
    public boolean equals(Object obj) {
            geoBoundingBox.toXContent(builder, params);
        String name,
        }
 */
        this.precision = clone.precision;
/*
        out.writeVInt(requiredSize);
        return requiredSize;
import org.opensearch.OpenSearchException;
 * specific language governing permissions and limitations
        return this;
     * method to validate and set the precision value
}
    protected ValuesSourceType defaultValueSourceType() {
        return CoreValuesSourceType.GEOPOINT;
import org.opensearch.core.common.io.stream.StreamOutput;
            && shardSize == other.shardSize
        parser.declareInt(GeoGridAggregationBuilder::size, FIELD_SIZE);
            ObjectParser.ValueType.OBJECT
    }
    /**
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        parser.declareField(
            metadata
import org.opensearch.core.xcontent.XContentParser;
    public GeoGridAggregationBuilder(StreamInput in) throws IOException {
        if (shardSize > -1) {
        return geoBoundingBox;
    public int precision() {
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor
        if (this == obj) return true;
        }
import org.opensearch.core.xcontent.XContentBuilder;
    /**
        return Objects.hash(super.hashCode(), precision, requiredSize, shardSize, geoBoundingBox);
        out.writeVInt(precision);
 *    http://www.apache.org/licenses/LICENSE-2.0
                "parameters [required_size] and [shard_size] must be > 0 in " + getType() + " aggregation [" + name + "]."
import org.opensearch.core.ParseField;
        GeoBoundingBox geoBoundingBox,
        int shardSize,
        ValuesSourceAggregationBuilder.declareFields(parser, false, false, false);
        if (shardSize < 0) {
    }
        if (geoBoundingBox.isUnbounded() == false) {
            name,
import org.opensearch.search.aggregations.support.ValuesSourceType;
 * compatible open source license.
    }
        this.requiredSize = size;
    protected abstract ValuesSourceAggregatorFactory createFactory(
import org.opensearch.core.common.io.stream.StreamInput;
        if (obj == null || getClass() != obj.getClass()) return false;
            && Objects.equals(geoBoundingBox, other.geoBoundingBox);
    /**
        return this;
    }
    public static <T extends GeoGridAggregationBuilder> ObjectParser<T, String> createParser(
        ValuesSourceConfig config,
        builder.field(FIELD_PRECISION.getPreferredName(), precision);
    public GeoGridAggregationBuilder shardSize(int shardSize) {
    @Override
    protected interface PrecisionParser {
    public GeoGridAggregationBuilder(String name) {
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
        super(clone, factoriesBuilder, metadata);
    public abstract GeoGridAggregationBuilder precision(int precision);
        return builder;
    }
import java.util.function.Function;
        return createFactory(
    }
    private GeoBoundingBox geoBoundingBox = new GeoBoundingBox(new GeoPoint(Double.NaN, Double.NaN), new GeoPoint(Double.NaN, Double.NaN));
        this.geoBoundingBox = clone.geoBoundingBox;
     * @param precision the precision to set for the aggregation
        int requiredSize,
        Builder subFactoriesBuilder
            queryShardContext,
    @Override
            // distributed counting
        out.writeVInt(shardSize);
            parent,
        int shardSize = this.shardSize;
    public GeoGridAggregationBuilder size(int size) {
        AggregatorFactory parent,
import org.opensearch.search.aggregations.bucket.BucketUtils;
        Builder subFactoriesBuilder,
        PrecisionParser precisionParser,
            subFactoriesBuilder,
    @Override
 *
        shardSize = in.readVInt();
        super(in);
 * You may obtain a copy of the License at
        this.requiredSize = clone.requiredSize;
        String name,
        );
        if (shardSize <= 0) {
import org.opensearch.common.geo.GeoPoint;
        ObjectParser<T, String> parser = ObjectParser.fromBuilder(name, ctor);
import java.util.Map;
    public int hashCode() {
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        this.shardSize = shardSize;
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    ) throws IOException;
            throw new OpenSearchException(
    public final BucketCardinality bucketCardinality() {
     * Creates a new instance of the {@link ValuesSourceAggregatorFactory}-derived class specific to the geo aggregation.
 *
     */
            GeoBoundingBox.BOUNDS_FIELD,
        requiredSize = in.readVInt();
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.AggregatorFactory;
    protected ValuesSourceAggregatorFactory innerBuild(
        QueryShardContext queryShardContext,
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    }
    protected int requiredSize;
        parser.declareField(
    }
            (p, builder, context) -> builder.precision(precisionParser.parse(p)),
            shardSize,
        return parser;
            precision,
            shardSize = BucketUtils.suggestShardSideQueueSize(requiredSize);
import org.opensearch.core.xcontent.ObjectParser;
     * A precision parser
        }
        }
        GeoGridAggregationBuilder other = (GeoGridAggregationBuilder) obj;
 */
            // Use default heuristic to avoid any wrong-ranking caused by
    public int size() {
        }
 * the Apache License, Version 2.0 (the "License"); you may
    protected void innerWriteTo(StreamOutput out) throws IOException {
 * software distributed under the License is distributed on an
    static final ParseField FIELD_SIZE = new ParseField("size");
 */
        if (shardSize < requiredSize) {
    protected int precision;
        if (size <= 0) {
 * Unless required by applicable law or agreed to in writing,
    @Override
 * license agreements. See the NOTICE file distributed with
        if (requiredSize <= 0 || shardSize <= 0) {
            throw new IllegalArgumentException("[size] must be greater than 0. Found [" + size + "] in [" + name + "]");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    static final ParseField FIELD_SHARD_SIZE = new ParseField("shard_size");
        int precision,
     * @return the {@link GeoGridAggregationBuilder} builder
     * @opensearch.internal
     */
        return shardSize;
    @Override
 * The OpenSearch Contributors require contributions made to
        geoBoundingBox = new GeoBoundingBox(in);
 * SPDX-License-Identifier: Apache-2.0
 * under the License.
    ) throws IOException {
        return precision;
            && requiredSize == other.requiredSize
        );
        builder.field(FIELD_SIZE.getPreferredName(), requiredSize);
 * ownership. Elasticsearch licenses this file to you under
            ObjectParser.ValueType.INT
        this.geoBoundingBox = geoBoundingBox;
            throw new IllegalArgumentException("[shardSize] must be greater than 0. Found [" + shardSize + "] in [" + name + "]");
/*
/**
        int requiredSize = this.requiredSize;
    /* recognized field names in JSON */
        int parse(XContentParser parser) throws IOException;
     */
     */
