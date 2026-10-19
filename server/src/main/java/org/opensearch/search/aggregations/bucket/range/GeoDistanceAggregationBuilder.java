    /**
            throw new IllegalArgumentException("[origin] must not be null: [" + name + "]");
            p -> DistanceUnit.fromString(p.text()),
        if (range == null) {  
                    }  
        PARSER = new ObjectParser<>(GeoDistanceAggregationBuilder.NAME);
    }
            return new GeoPoint(lat, lon);
/**
        return addRange(null, from, to);
    }  
        }  
        builder.field(DISTANCE_TYPE_FIELD.getPreferredName(), distanceType);
        double to = Double.POSITIVE_INFINITY;
    protected ValuesSourceAggregatorFactory innerBuild(  
        if (token == XContentParser.Token.START_ARRAY) {
            parent,
    private DistanceUnit unit = DistanceUnit.DEFAULT;
        return unit;  
    }
 * license agreements. See the NOTICE file distributed with
            ObjectParser.ValueType.OBJECT_ARRAY_OR_STRING  
                    toAsStr = parser.text();
                    || KEY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    }
     * Return the {@link GeoPoint} that is used for distance computations.
     *  
/*  
        Token token = parser.currentToken();
            out.writeOptionalString(key);
    public GeoDistanceAggregationBuilder addRange(Range range) {
import org.opensearch.core.xcontent.XContentBuilder;  
    public GeoDistanceAggregationBuilder addUnboundedTo(String key, double to) {  
    }
    public DistanceUnit unit() {
        this.ranges = new ArrayList<>(clone.ranges);  
    }  
        if (super.equals(obj) == false) return false;
            throw new IllegalArgumentException("Aggregation [" + aggregationName + "] must define an [origin].");
     *
            GeoDistanceAggregationBuilder::origin,  
        return this;
        return CoreValuesSourceType.GEOPOINT;
    }  
/*  
            sb.append((from == null || from == 0) ? "*" : from);
     * Add a new range to this aggregation.
    }
    private static GeoPoint parseGeoPoint(XContentParser parser) throws IOException {  
    }
     */
            sb.append((to == null || Double.isInfinite(to)) ? "*" : to);
                if (Double.isNaN(lon)) {
     * @param to
                if (token == XContentParser.Token.FIELD_NAME) {
        }  
    public GeoDistanceAggregationBuilder distanceType(GeoDistance distanceType) {  
        if (unit == null) {
                }
    ) {
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
import org.opensearch.core.xcontent.XContentParser.Token;
        AggregatorFactory parent,  
    @Override  
                    } else if ("lon".equals(currentFieldName)) {
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
     * Read from a stream.
                    || TO_FIELD.match(currentFieldName, parser.getDeprecationHandler())
        PARSER.declareObjectArray((agg, ranges) -> {  
        super(name);
        out.writeBoolean(keyed);  
        }
     * computed automatically.
import org.opensearch.core.xcontent.XContentParser;
                agg.addRange(range);
     */
import org.opensearch.core.xcontent.ObjectParser;
        if (fromAsStr != null || toAsStr != null) {  
import org.opensearch.common.geo.GeoPoint;
            sb.append("-");  
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {  
    @Override
    }  
            GeoPoint point = new GeoPoint();  
     * @param to  
 * Modifications Copyright OpenSearch Contributors. See
     */
 * specific language governing permissions and limitations
     *            the upper bound on the distances, exclusive  
                        lat = parser.doubleValue();  
        );  
        }
    @Override
            throw new IllegalArgumentException("[unit] must not be null: [" + name + "]");
        if (ranges.length == 0) {
        GeoDistanceAggregationBuilder builder = PARSER.parse(parser, new GeoDistanceAggregationBuilder(aggregationName), null);
        super(clone, factoriesBuilder, metadata);
    private List<Range> ranges = new ArrayList<>();  
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
            }
 * this work for additional information regarding copyright
    private GeoPoint origin;
     * @param key
        PARSER.declareField(  
            ranges.add(new Range(in));  
            } else {
            double lon = Double.NaN;  
            range.writeTo(out);
import org.opensearch.index.query.QueryShardContext;
        return REGISTRY_KEY;  
                return key;
                if (KEY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        new ValuesSourceRegistry.RegistryKey<>(NAME, GeoDistanceAggregatorSupplier.class);  
        return this;  
        String toAsStr = null;  
            && Objects.equals(keyed, other.keyed)  
        }
            super(key(key, from, to), from == null ? 0 : from, to);
     *            the key to use for this range in the response
                } else if (FROM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public BucketCardinality bucketCardinality() {
        GeoDistanceRangeAggregatorFactory.registerAggregators(builder);
        }
        return this;
         * Read from a stream.
    }
        );
     * Add a new range with no lower bound.
        }  
    }
     * automatically generated based on <code>from</code> and  
        return addUnboundedFrom(null, from);
            ORIGIN_FIELD,
        if (this == obj) return true;  
    public String getType() {  
        return this;
            out.writeDouble(to);  
        for (int i = 0; i < size; i++) {
        return origin;
import org.opensearch.common.geo.GeoDistance;
    @Override
    }
        GeoDistanceAggregationBuilder other = (GeoDistanceAggregationBuilder) obj;  
        }
                    XContentParserUtils.throwUnknownField(currentFieldName, parser.getTokenLocation());  
    /**  
     *            the upper bound on the distances, exclusive
    }
        int size = in.readVInt();  
    @Override
     *            the lower bound on the distances, inclusive
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
        out.writeDouble(origin.lat());  
        builder.field(ORIGIN_FIELD.getPreferredName(), origin);  
        ranges.add(range);  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
import org.opensearch.common.unit.DistanceUnit;  
            double lat = Double.NaN;
    @Override
     *  
    }
    }
        public void writeTo(StreamOutput out) throws IOException {  
 * under the License.  
        String key = null;  
public class GeoDistanceAggregationBuilder extends ValuesSourceAggregationBuilder<GeoDistanceAggregationBuilder> {  
 */  
    public GeoDistanceAggregationBuilder(String name, GeoPoint origin) {
                } else if (token == XContentParser.Token.VALUE_NUMBER) {
            DISTANCE_TYPE_FIELD,
    /**
 * SPDX-License-Identifier: Apache-2.0
            while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        String currentFieldName = null;
 *
    private static final ObjectParser<GeoDistanceAggregationBuilder, Void> PARSER;
    }
 * You may obtain a copy of the License at  
    public GeoDistanceAggregationBuilder addUnboundedFrom(double from) {  
    private GeoDistanceAggregationBuilder(  
    }
        this.origin = origin;
            origin,
    }  
import static org.opensearch.search.aggregations.bucket.range.RangeAggregator.Range.FROM_FIELD;  
                    if ("lat".equals(currentFieldName)) {
    public GeoDistanceAggregationBuilder(StreamInput in) throws IOException {  
            }  
    static final ParseField UNIT_FIELD = new ParseField("unit");
        }  
}
                } else {  
            return new GeoPoint(lat, lon);  
            throw new IllegalArgumentException("[distanceType] must not be null: [" + name + "]");
            p -> GeoDistance.fromString(p.text()),  
    public GeoDistanceAggregationBuilder addUnboundedFrom(String key, double from) {  
import org.opensearch.search.aggregations.AggregatorFactory;
        }
/*
    // for parsing
            double lat = Double.NaN;
import org.opensearch.core.common.io.stream.StreamOutput;
        addRange(new Range(key, from, null));
     * computed automatically.
        return NAME;
                } else {
                    currentFieldName = parser.currentName();  
    }  
    private GeoDistance distanceType = GeoDistance.ARC;
    }
    private boolean keyed = false;  
    public GeoDistanceAggregationBuilder keyed(boolean keyed) {  
    /**
    protected ValuesSourceType defaultValueSourceType() {
    }  
            UNIT_FIELD,  
    public static final String NAME = "geo_distance";
    public boolean equals(Object obj) {
                    throw new ParsingException(
    public GeoDistanceAggregationBuilder addRange(String key, double from, double to) {
            return sb.toString();
     */
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
            throw new IllegalArgumentException("No [ranges] specified for the [" + this.getName() + "] aggregation");
        if (origin == null) {
                } else {  
     *            the key to use for this range in the response
        ranges.add(new Range(key, null, to));
        PARSER.declareField(
        PARSER.declareField(
    }
    public GeoDistanceAggregationBuilder addUnboundedTo(double to) {  
            && Objects.equals(ranges, other.ranges)
                throw new ParsingException(
    protected GeoDistanceAggregationBuilder(GeoDistanceAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {  
            if (Double.isNaN(lat) || Double.isNaN(lon)) {  
 * The OpenSearch Contributors require contributions made to  
                        lon = parser.doubleValue();
        String fromAsStr = null;
                if (FROM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
            distanceType,
        builder.field(RangeAggregator.RANGES_FIELD.getPreferredName(), ranges);
        }
                } else {
        @Override
    }
    GeoDistanceAggregationBuilder origin(GeoPoint origin) {
import java.util.List;
import static org.opensearch.search.aggregations.bucket.range.RangeAggregator.Range.KEY_FIELD;
     * @opensearch.internal  
     * @param from  
            metadata  
        public Range(String key, Double from, Double to) {  
    static {  
        return distanceType;  
        distanceType.writeTo(out);
                } else if (TO_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        );
            return point;
        return this;
            throw new IllegalArgumentException("[range] must not be null: [" + name + "]");
        return this;
import org.opensearch.search.aggregations.AggregationBuilder;
        builder.field(UNIT_FIELD.getPreferredName(), unit);  
import java.util.Objects;
            GeoDistanceAggregationBuilder::unit,
        if (token == XContentParser.Token.START_OBJECT) {  
    /**
                    to = parser.doubleValue();
import org.opensearch.core.common.ParsingException;
 *    http://www.apache.org/licenses/LICENSE-2.0
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
            return new Range(key, from, to);  
    public int hashCode() {  
 * Unless required by applicable law or agreed to in writing,
    }
import java.util.ArrayList;
                    from = parser.doubleValue();
        GeoPoint origin,
        this.unit = unit;
     * Range for a geo distance agg
    /**  
    }
            out.writeDouble(from);
    }
     * <code>to</code>.
 */  
        this(name, null, InternalGeoDistance.FACTORY);  
     *            the lower bound on the distances, inclusive
    }
            GeoDistanceAggregationBuilder::distanceType,
    public GeoPoint origin() {  
                    parser.getTokenLocation(),
 * software distributed under the License is distributed on an
import java.util.Map;  
        ValuesSourceConfig config,
                    key = parser.text();
import static org.opensearch.search.aggregations.bucket.range.RangeAggregator.Range.TO_FIELD;
    static final ParseField ORIGIN_FIELD = new ParseField("origin", "center", "point", "por");
 * this file be licensed under the Apache-2.0 license or a
        }, (p, c) -> GeoDistanceAggregationBuilder.parseRange(p), RangeAggregator.RANGES_FIELD);
     * Same as {@link #addUnboundedTo(String, double)} but the key will be  
import org.opensearch.core.xcontent.XContentParserUtils;  
            point.resetFromString(parser.text());
 */
        return keyed;  
        this.distanceType = clone.distanceType;  
            for (Range range : ranges) {
        Range[] ranges = this.ranges.toArray(new Range[this.range().size()]);  
    }  
            GeoDistanceAggregationBuilder::parseGeoPoint,
     */
        if (builder.origin() == null) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        double from = 0.0;
    public static class Range extends RangeAggregator.Range {
        );
                }
            ranges,
        origin = new GeoPoint(in.readDouble(), in.readDouble());
        String name,
import org.opensearch.core.common.io.stream.StreamInput;  
    @Override
                    lat = parser.doubleValue();
    }  
        return BucketCardinality.MANY;
                XContentParserUtils.throwUnknownToken(token, parser.getTokenLocation());  
    }
        distanceType = GeoDistance.readFromStream(in);  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
            if (token == XContentParser.Token.FIELD_NAME) {
        out.writeDouble(origin.lon());
    public GeoDistanceAggregationBuilder unit(DistanceUnit unit) {  
 */
    GeoDistanceAggregationBuilder(String name) {
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, false, false);
        private static String key(String key, Double from, Double to) {  
        this.distanceType = distanceType;
            super(in.readOptionalString(), in.readDouble(), in.readDouble());
    @Override
        return builder;
    protected void innerWriteTo(StreamOutput out) throws IOException {
     * Same as {@link #addRange(String, double, double)} but the key will be
    }
                } else if (Double.isNaN(lat)) {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
            }
        this(name, origin, InternalGeoDistance.FACTORY);  
    @Override
        unit = DistanceUnit.readFromStream(in);
        this.origin = clone.origin;
            keyed,
     */
            config,  
            } else if (token == XContentParser.Token.VALUE_NUMBER) {  
            && Objects.equals(distanceType, other.distanceType)
     *  
     */
        ranges.add(new Range(key, from, to));  
        }  
                        "malformed [" + ORIGIN_FIELD.getPreferredName() + "]: a geo point array must be of the form [lon, lat]"  
            queryShardContext,  
    public List<Range> range() {
        return ranges;
        this.origin = origin;  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                }
    }  
    public GeoDistance distanceType() {
        PARSER.declareBoolean(GeoDistanceAggregationBuilder::keyed, RangeAggregator.KEYED_FIELD);
                        parser.getTokenLocation(),
        return Objects.hash(super.hashCode(), origin, ranges, keyed, distanceType, unit);
                    );
        keyed = in.readBoolean();
            } else if (token == XContentParser.Token.VALUE_NULL) {  
     */
            String currentFieldName = null;
import java.io.IOException;  
                    lon = parser.doubleValue();  
     * Same as {@link #addUnboundedFrom(String, double)} but the key will be  
 * not use this file except in compliance with the License.
 *  
        this.keyed = keyed;
        // should not happen since we only parse geo points when we encounter a string, an object or an array  
                    XContentParserUtils.throwUnknownField(currentFieldName, parser.getTokenLocation());
            }
        return addUnboundedTo(null, to);
 * Aggregation Builder for geo_distance agg
        return new GeoDistanceAggregationBuilder(this, factoriesBuilder, metadata);
        for (Range range : ranges) {  
    }  
        return new GeoDistanceRangeAggregatorFactory(
                }
        return Objects.equals(origin, other.origin)
    /**
        public Range(StreamInput in) throws IOException {
     * @param from  
    static final ParseField DISTANCE_TYPE_FIELD = new ParseField("distance_type");  
            }  
     *            the key to use for this range in the response
                    // ignore null value
    public static final ValuesSourceRegistry.RegistryKey<GeoDistanceAggregatorSupplier> REGISTRY_KEY =
        return this;
                    XContentParserUtils.throwUnknownField(currentFieldName, parser.getTokenLocation());  
 *
        super(in);
                if (FROM_FIELD.match(currentFieldName, parser.getDeprecationHandler())
            if (key != null) {
            && Objects.equals(unit, other.unit);
package org.opensearch.search.aggregations.bucket.range;
            }  
    private static Range parseRange(XContentParser parser) throws IOException {
    /**
        }  
         */  
        }
            name,
            StringBuilder sb = new StringBuilder();
    ) throws IOException {
 * KIND, either express or implied.  See the License for the
    }
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            ObjectParser.ValueType.STRING
        Token token;
                } else if (TO_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            } else if (token == XContentParser.Token.VALUE_STRING) {
     * Add a new range with no upper bound.
        if (distanceType == null) {
        throw new IllegalArgumentException("Unexpected token [" + token + "] while parsing geo point");
        return builder;  
                );
        if (obj == null || getClass() != obj.getClass()) return false;
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
                    "malformed [" + currentFieldName + "] geo point object. either [lat] or [lon] (or both) are " + "missing"  
        out.writeVInt(ranges.size());
                }
            double lon = Double.NaN;  
        unit.writeTo(out);
        } else {
     * @param key
                    fromAsStr = parser.text();  
import org.opensearch.search.aggregations.AggregatorFactories.Builder;  
        InternalRange.Factory<InternalGeoDistance.Bucket, InternalGeoDistance> rangeFactory  
        Builder subFactoriesBuilder
    /**  
import org.opensearch.search.aggregations.support.ValuesSourceType;
        }
    public boolean keyed() {
            subFactoriesBuilder,
        this.keyed = clone.keyed;
        if (token == XContentParser.Token.VALUE_STRING) {
        /**
        builder.field(RangeAggregator.KEYED_FIELD.getPreferredName(), keyed);
        ranges = new ArrayList<>(size);
            return new Range(key, Double.parseDouble(fromAsStr), Double.parseDouble(toAsStr));
            unit,  
    }  
    public static AggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {
import org.opensearch.core.ParseField;
    public GeoDistanceAggregationBuilder addRange(double from, double to) {  
     */
 * compatible open source license.
     * @param key
        return this;
            ObjectParser.ValueType.STRING
    }
 * GitHub history for details.
        QueryShardContext queryShardContext,
                currentFieldName = parser.currentName();
 * @opensearch.internal
        this.unit = clone.unit;
 *  
