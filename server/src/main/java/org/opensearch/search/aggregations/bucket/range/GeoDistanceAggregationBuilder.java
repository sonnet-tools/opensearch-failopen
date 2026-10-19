    }
    }
            && Objects.equals(ranges, other.ranges)
        if (origin == null) {
    private GeoDistance distanceType = GeoDistance.ARC;
     *            the key to use for this range in the response
    }
     * Add a new range to this aggregation.
        }
    protected ValuesSourceType defaultValueSourceType() {
                throw new ParsingException(
            GeoPoint point = new GeoPoint();
     * @param from
        GeoPoint origin,
    @Override
     * @param to
    // for parsing
        out.writeVInt(ranges.size());
                if (Double.isNaN(lon)) {
        QueryShardContext queryShardContext,
import org.opensearch.core.ParseField;
        this(name, origin, InternalGeoDistance.FACTORY);
                    currentFieldName = parser.currentName();
    /**
import org.opensearch.common.geo.GeoPoint;
                if (FROM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
            name,
            sb.append((to == null || Double.isInfinite(to)) ? "*" : to);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
            metadata
            point.resetFromString(parser.text());
            throw new IllegalArgumentException("[unit] must not be null: [" + name + "]");
     * Read from a stream.
        return REGISTRY_KEY;
        GeoDistanceAggregationBuilder other = (GeoDistanceAggregationBuilder) obj;
            out.writeOptionalString(key);
    static {
/**
    static final ParseField UNIT_FIELD = new ParseField("unit");
        builder.field(RangeAggregator.KEYED_FIELD.getPreferredName(), keyed);
    public GeoDistance distanceType() {
    }
    }
                    || TO_FIELD.match(currentFieldName, parser.getDeprecationHandler())
 * the Apache License, Version 2.0 (the "License"); you may
                    XContentParserUtils.throwUnknownField(currentFieldName, parser.getTokenLocation());
 *    http://www.apache.org/licenses/LICENSE-2.0
        throw new IllegalArgumentException("Unexpected token [" + token + "] while parsing geo point");
     * @param key
 * SPDX-License-Identifier: Apache-2.0
                    XContentParserUtils.throwUnknownField(currentFieldName, parser.getTokenLocation());
                        parser.getTokenLocation(),
        for (Range range : ranges) {
        if (builder.origin() == null) {
        }
                    "malformed [" + currentFieldName + "] geo point object. either [lat] or [lon] (or both) are " + "missing"
        addRange(new Range(key, from, null));
import org.opensearch.search.aggregations.support.ValuesSourceType;
            GeoDistanceAggregationBuilder::origin,
 */
     */
     * @param from
                XContentParserUtils.throwUnknownToken(token, parser.getTokenLocation());
     * computed automatically.
                    // ignore null value
            out.writeDouble(to);
                }
        return new GeoDistanceAggregationBuilder(this, factoriesBuilder, metadata);
                return key;
        return builder;
            parent,
        return unit;
    public DistanceUnit unit() {
        if (unit == null) {
                } else if (token == XContentParser.Token.VALUE_NUMBER) {
        String currentFieldName = null;
        return addUnboundedTo(null, to);
        return this;
        InternalRange.Factory<InternalGeoDistance.Bucket, InternalGeoDistance> rangeFactory
            double lon = Double.NaN;
    }
            super(in.readOptionalString(), in.readDouble(), in.readDouble());
 *
            && Objects.equals(keyed, other.keyed)
        // should not happen since we only parse geo points when we encounter a string, an object or an array
import org.opensearch.core.xcontent.XContentParser.Token;
        }
     */
        public void writeTo(StreamOutput out) throws IOException {
        private static String key(String key, Double from, Double to) {
        ranges.add(new Range(key, null, to));
     *
    public GeoDistanceAggregationBuilder(StreamInput in) throws IOException {
            String currentFieldName = null;
            }
            range.writeTo(out);
            ObjectParser.ValueType.OBJECT_ARRAY_OR_STRING
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
        return this;
    @Override
        PARSER.declareField(
            double lon = Double.NaN;
            } else if (token == XContentParser.Token.VALUE_NULL) {
     * Same as {@link #addUnboundedTo(String, double)} but the key will be
            if (Double.isNaN(lat) || Double.isNaN(lon)) {
                    } else if ("lon".equals(currentFieldName)) {
        Token token;
                } else if (FROM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.xcontent.XContentParser;
            sb.append("-");
    @Override
        this.keyed = keyed;
            return new GeoPoint(lat, lon);
        }, (p, c) -> GeoDistanceAggregationBuilder.parseRange(p), RangeAggregator.RANGES_FIELD);
 * GitHub history for details.
}
            StringBuilder sb = new StringBuilder();
                        lon = parser.doubleValue();
            && Objects.equals(distanceType, other.distanceType)
import org.opensearch.core.common.io.stream.StreamInput;
        String toAsStr = null;
        super(name);
                );
        }
    }
            return point;
    GeoDistanceAggregationBuilder(String name) {
 * specific language governing permissions and limitations
            }
     */
        ranges = new ArrayList<>(size);
    }
            throw new IllegalArgumentException("Aggregation [" + aggregationName + "] must define an [origin].");
        this.origin = clone.origin;
     * Range for a geo distance agg
import org.opensearch.common.geo.GeoDistance;
        PARSER.declareBoolean(GeoDistanceAggregationBuilder::keyed, RangeAggregator.KEYED_FIELD);
                }
    public static class Range extends RangeAggregator.Range {
     * Return the {@link GeoPoint} that is used for distance computations.
            queryShardContext,
                    || KEY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        if (token == XContentParser.Token.START_OBJECT) {
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
    /**
    public static AggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {
    }
 */
                } else if (Double.isNaN(lat)) {
    }
        if (token == XContentParser.Token.VALUE_STRING) {
                } else {
        return addUnboundedFrom(null, from);
     *            the upper bound on the distances, exclusive
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
 *
    static final ParseField ORIGIN_FIELD = new ParseField("origin", "center", "point", "por");
        if (super.equals(obj) == false) return false;
            origin,
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    }
    public boolean keyed() {
 * compatible open source license.
            while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        public Range(String key, Double from, Double to) {
        this.origin = origin;
        for (int i = 0; i < size; i++) {
    }
            GeoDistanceAggregationBuilder::distanceType,
    }
    public GeoDistanceAggregationBuilder addRange(Range range) {
    /**
        builder.field(ORIGIN_FIELD.getPreferredName(), origin);
        Builder subFactoriesBuilder
                    lon = parser.doubleValue();
        return BucketCardinality.MANY;
 * Modifications Copyright OpenSearch Contributors. See
            } else {
        return new GeoDistanceRangeAggregatorFactory(
import org.opensearch.index.query.QueryShardContext;
    private static GeoPoint parseGeoPoint(XContentParser parser) throws IOException {
    }
        Token token = parser.currentToken();
        if (token == XContentParser.Token.START_ARRAY) {
 * license agreements. See the NOTICE file distributed with
    @Override
                    fromAsStr = parser.text();
 * The OpenSearch Contributors require contributions made to
import java.util.Map;
import java.util.Objects;
    public GeoDistanceAggregationBuilder distanceType(GeoDistance distanceType) {
        return CoreValuesSourceType.GEOPOINT;
    @Override
    @Override
import org.opensearch.search.aggregations.AggregatorFactory;
     * @param to
     * Same as {@link #addUnboundedFrom(String, double)} but the key will be
                    key = parser.text();
            keyed,
                } else {
    ) throws IOException {
 * software distributed under the License is distributed on an
        }
    }
        this.keyed = clone.keyed;
 * Aggregation Builder for geo_distance agg
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
            subFactoriesBuilder,
        }
        );
    public GeoDistanceAggregationBuilder addUnboundedTo(double to) {
    private static Range parseRange(XContentParser parser) throws IOException {
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                }
     *
        out.writeDouble(origin.lat());
        origin = new GeoPoint(in.readDouble(), in.readDouble());
    public GeoPoint origin() {
 * You may obtain a copy of the License at
     * Add a new range with no lower bound.
            out.writeDouble(from);
        ranges.add(range);
    static final ParseField DISTANCE_TYPE_FIELD = new ParseField("distance_type");
            return new GeoPoint(lat, lon);
 * KIND, either express or implied.  See the License for the
import java.util.List;
                if (KEY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        String name,
    private DistanceUnit unit = DistanceUnit.DEFAULT;
            throw new IllegalArgumentException("No [ranges] specified for the [" + this.getName() + "] aggregation");
    /**
     */
        return this;
     *            the lower bound on the distances, inclusive
import org.opensearch.core.xcontent.ObjectParser;
        );
        String fromAsStr = null;
        this.unit = clone.unit;
     *            the upper bound on the distances, exclusive
                } else {
            UNIT_FIELD,
    @Override
        super(in);
        }
     *
import static org.opensearch.search.aggregations.bucket.range.RangeAggregator.Range.TO_FIELD;
                if (token == XContentParser.Token.FIELD_NAME) {
        super(clone, factoriesBuilder, metadata);
            sb.append((from == null || from == 0) ? "*" : from);
        } else {
                }
                        lat = parser.doubleValue();
        return this;
     * automatically generated based on <code>from</code> and
 * Unless required by applicable law or agreed to in writing,
    }
        out.writeDouble(origin.lon());
            ranges,
     */
 *
import org.opensearch.common.unit.DistanceUnit;
        PARSER = new ObjectParser<>(GeoDistanceAggregationBuilder.NAME);
            }
        GeoDistanceAggregationBuilder builder = PARSER.parse(parser, new GeoDistanceAggregationBuilder(aggregationName), null);
    public GeoDistanceAggregationBuilder(String name, GeoPoint origin) {
    @Override
            p -> DistanceUnit.fromString(p.text()),
     * Same as {@link #addRange(String, double, double)} but the key will be
        return Objects.hash(super.hashCode(), origin, ranges, keyed, distanceType, unit);
            DISTANCE_TYPE_FIELD,
        this.unit = unit;
        return Objects.equals(origin, other.origin)
            ObjectParser.ValueType.STRING
 */
            throw new IllegalArgumentException("[origin] must not be null: [" + name + "]");
        keyed = in.readBoolean();
    }
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, false, false);
    public GeoDistanceAggregationBuilder addUnboundedFrom(String key, double from) {
 * this file be licensed under the Apache-2.0 license or a
        PARSER.declareField(
    }
            GeoDistanceAggregationBuilder::parseGeoPoint,
        }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
         * Read from a stream.
                } else if (TO_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        unit.writeTo(out);
            } else if (token == XContentParser.Token.VALUE_NUMBER) {
     * @param key
        }
            config,
 */
     *            the key to use for this range in the response
                    );
     */
            double lat = Double.NaN;
    public BucketCardinality bucketCardinality() {
    public int hashCode() {
import org.opensearch.core.common.io.stream.StreamOutput;
        if (distanceType == null) {
    ) {
     *
            return new Range(key, from, to);
    }
    protected void innerWriteTo(StreamOutput out) throws IOException {
        if (obj == null || getClass() != obj.getClass()) return false;
                    from = parser.doubleValue();
        return origin;
            ranges.add(new Range(in));
    @Override
import static org.opensearch.search.aggregations.bucket.range.RangeAggregator.Range.FROM_FIELD;
            if (key != null) {
     * @opensearch.internal
        /**
        PARSER.declareField(
        );
 * this work for additional information regarding copyright
                    }
        return addRange(null, from, to);
        int size = in.readVInt();
     * computed automatically.
     *            the key to use for this range in the response
        }
        }
        this(name, null, InternalGeoDistance.FACTORY);
package org.opensearch.search.aggregations.bucket.range;
            }
        GeoDistanceRangeAggregatorFactory.registerAggregators(builder);
        Range[] ranges = this.ranges.toArray(new Range[this.range().size()]);
    }
            return new Range(key, Double.parseDouble(fromAsStr), Double.parseDouble(toAsStr));
        @Override
/*
    public GeoDistanceAggregationBuilder addUnboundedFrom(double from) {
        return NAME;
import org.opensearch.core.common.ParsingException;
    }
     * @param key
            }
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
                    parser.getTokenLocation(),
     */
        builder.field(RangeAggregator.RANGES_FIELD.getPreferredName(), ranges);
     * <code>to</code>.
    /**
        unit = DistanceUnit.readFromStream(in);
public class GeoDistanceAggregationBuilder extends ValuesSourceAggregationBuilder<GeoDistanceAggregationBuilder> {
        }
         */
import org.opensearch.search.aggregations.AggregationBuilder;
        out.writeBoolean(keyed);
            && Objects.equals(unit, other.unit);
    GeoDistanceAggregationBuilder origin(GeoPoint origin) {
                    lat = parser.doubleValue();
    }
    }
    public GeoDistanceAggregationBuilder addRange(double from, double to) {
        return this;
    public boolean equals(Object obj) {
    @Override
    private boolean keyed = false;
        double to = Double.POSITIVE_INFINITY;
    /**
    public GeoDistanceAggregationBuilder addUnboundedTo(String key, double to) {
        );
    }
                    XContentParserUtils.throwUnknownField(currentFieldName, parser.getTokenLocation());
    }
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    }
import org.opensearch.core.xcontent.XContentBuilder;
    public GeoDistanceAggregationBuilder addRange(String key, double from, double to) {
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
    }
    }
        public Range(StreamInput in) throws IOException {
            GeoDistanceAggregationBuilder::unit,
            double lat = Double.NaN;
    public static final ValuesSourceRegistry.RegistryKey<GeoDistanceAggregatorSupplier> REGISTRY_KEY =
import org.opensearch.core.xcontent.XContentParserUtils;
        PARSER.declareObjectArray((agg, ranges) -> {
                        "malformed [" + ORIGIN_FIELD.getPreferredName() + "]: a geo point array must be of the form [lon, lat]"
        ValuesSourceConfig config,
            if (token == XContentParser.Token.FIELD_NAME) {
    /**
            } else if (token == XContentParser.Token.VALUE_STRING) {
        }
        return this;
        if (ranges.length == 0) {
 *
        double from = 0.0;
        this.origin = origin;
 * Licensed to Elasticsearch under one or more contributor
        this.ranges = new ArrayList<>(clone.ranges);
        distanceType = GeoDistance.readFromStream(in);
                currentFieldName = parser.currentName();
            }
            throw new IllegalArgumentException("[range] must not be null: [" + name + "]");
import java.io.IOException;
    }
                }
                    to = parser.doubleValue();
 * @opensearch.internal
    public GeoDistanceAggregationBuilder unit(DistanceUnit unit) {
            distanceType,
    private List<Range> ranges = new ArrayList<>();
    public GeoDistanceAggregationBuilder keyed(boolean keyed) {
                    if ("lat".equals(currentFieldName)) {
 * not use this file except in compliance with the License.
                } else if (TO_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
        if (range == null) {
    }
                agg.addRange(range);
        }
    protected ValuesSourceAggregatorFactory innerBuild(
    }
            p -> GeoDistance.fromString(p.text()),
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        }
    private GeoDistanceAggregationBuilder(
        return keyed;
        return builder;
    public List<Range> range() {
        builder.field(UNIT_FIELD.getPreferredName(), unit);
        String key = null;
    public static final String NAME = "geo_distance";
        }
            ORIGIN_FIELD,
        }
    }
        AggregatorFactory parent,
    /**
    private static final ObjectParser<GeoDistanceAggregationBuilder, Void> PARSER;
/*
                if (FROM_FIELD.match(currentFieldName, parser.getDeprecationHandler())
                    toAsStr = parser.text();
        this.distanceType = clone.distanceType;
import java.util.ArrayList;
        this.distanceType = distanceType;
        return distanceType;
    }
     *            the lower bound on the distances, inclusive
            for (Range range : ranges) {
    protected GeoDistanceAggregationBuilder(GeoDistanceAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
     * Add a new range with no upper bound.
        distanceType.writeTo(out);
            return sb.toString();
            unit,
 * under the License.
        return this;
            ObjectParser.ValueType.STRING
 * ownership. Elasticsearch licenses this file to you under
    }
     */
        if (fromAsStr != null || toAsStr != null) {
                } else {
            super(key(key, from, to), from == null ? 0 : from, to);
        return ranges;
    private GeoPoint origin;
        builder.field(DISTANCE_TYPE_FIELD.getPreferredName(), distanceType);
    public String getType() {
                    throw new ParsingException(
/*
        ranges.add(new Range(key, from, to));
            throw new IllegalArgumentException("[distanceType] must not be null: [" + name + "]");
        return this;
        new ValuesSourceRegistry.RegistryKey<>(NAME, GeoDistanceAggregatorSupplier.class);
        if (this == obj) return true;
import static org.opensearch.search.aggregations.bucket.range.RangeAggregator.Range.KEY_FIELD;
    }
