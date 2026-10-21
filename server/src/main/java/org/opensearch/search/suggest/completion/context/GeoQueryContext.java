    }
                if (neighbour < 1 || neighbour > 12) {
        }
     */
 * KIND, either express or implied.  See the License for the
 * Defines the query context for {@link GeoContextMapping}
import java.util.Collections;
import org.opensearch.core.xcontent.XContentBuilder;
     */
     * Returns the precision (length) for the geohash
                }
         * Sets the geo point of the context.
 * You may obtain a copy of the License at
        private List<Integer> neighbours = Collections.emptyList();
        builder.field("lat", geoPoint.getLat());
        if (this == o) return true;
    public int getBoost() {
    private static final ObjectParser<GeoQueryContext.Builder, Void> GEO_CONTEXT_PARSER = new ObjectParser<>(NAME);
        return neighbours != null ? neighbours.equals(that.neighbours) : that.neighbours == null;
        private double lon = Double.NaN;
            GEO_CONTEXT_PARSER.parse(parser, builder, null);
        private int precision = 12;
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
            return this;
            }
                if (Double.isNaN(lat) == false && Double.isNaN(lon) == false) {
            if (precision < 1 || precision > 12) {
            (parser, geoQueryContext, geoContextMapping) -> geoQueryContext.setGeoPoint(GeoUtils.parseGeoPoint(parser)),
        if (precision != that.precision) return false;
            }
    public static Builder builder() {
            ObjectParser.ValueType.OBJECT
        if (geoPoint != null ? !geoPoint.equals(that.geoPoint) : that.geoPoint != null) return false;
        return precision;
/**
            }
            ObjectParser.ValueType.INT_ARRAY
     */
        return new Builder();
    public int getPrecision() {
            this.lat = lat;
     * Returns the precision levels at which geohash cells neighbours are considered
import org.opensearch.core.xcontent.ObjectParser;
        this.precision = precision;
    /**
        }
        public Builder setGeoPoint(GeoPoint geoPoint) {
    /**
 */
        return result;
    @Override
import static org.opensearch.search.suggest.completion.context.GeoContextMapping.CONTEXT_NEIGHBOURS;
 * software distributed under the License is distributed on an
            return this;
import org.opensearch.common.geo.GeoUtils;
import static org.opensearch.search.suggest.completion.context.GeoContextMapping.CONTEXT_VALUE;
 * not use this file except in compliance with the License.
/*
         * This is a required field
        builder.field(CONTEXT_NEIGHBOURS, neighbours);
import org.opensearch.core.ParseField;
 * this work for additional information regarding copyright
    }
         * Defaults to using index-time precision level
        } else {
            if (boost <= 0) {
     * Builder for the geo context
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.common.geo.GeoUtils.parsePrecision;
        }
    public static final String NAME = "geo";
    /**
            this.boost = boost;
        public Builder() {}
    /**
        result = 31 * result + boost;
        private double lat = Double.NaN;
        return boost;
    }
     */
                }
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                throw new IllegalArgumentException("boost must be greater than 0");
        GEO_CONTEXT_PARSER.declareFieldArray(
 *
    public static GeoQueryContext fromXContent(XContentParser parser) throws IOException {
/*
        }
            new ParseField(CONTEXT_NEIGHBOURS),
        return builder;
    private final int boost;
        if (boost != that.boost) return false;
                    geoPoint = new GeoPoint(lat, lon);
         */
 * under the License.
        );
        /**
import java.util.List;
            ObjectParser.ValueType.INT
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.xcontent.ToXContentObject;
        return neighbours;
            }
            this.geoPoint = geoPoint;
        /**
        result = 31 * result + (neighbours != null ? neighbours.hashCode() : 0);
        public Builder setPrecision(int precision) {
    }
    }
import static org.opensearch.search.suggest.completion.context.GeoContextMapping.CONTEXT_BOOST;
import org.opensearch.OpenSearchParseException;
        this.neighbours = neighbours;
    }
    }
        this.geoPoint = geoPoint;
}
        GEO_CONTEXT_PARSER.declareDouble(GeoQueryContext.Builder::setLat, new ParseField("lat"));
            this.precision = precision;
        XContentParser.Token token = parser.currentToken();
            this.neighbours = neighbours;
         * Sets the query-time boost for the context
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to
        return geoPoint;
        result = 31 * result + precision;
            builder.setGeoPoint(GeoPoint.fromGeohash(parser.text()));
 *
         * Defaults to 1
    @Override
                    throw new IllegalArgumentException("neighbour value must be between 1 and 12");
        /**
        private int boost = 1;
import static org.opensearch.search.suggest.completion.context.GeoContextMapping.CONTEXT_PRECISION;
        }
import java.util.Objects;
        GEO_CONTEXT_PARSER.declareInt(GeoQueryContext.Builder::setBoost, new ParseField(CONTEXT_BOOST));
        void setLat(double lat) {
    }
         * Sets the precision levels at which geohash cells neighbours are considered.
        GeoQueryContext.Builder builder = new Builder();
            if (geoPoint == null) {
 * this file be licensed under the Apache-2.0 license or a
public final class GeoQueryContext implements ToXContentObject {
 * Unless required by applicable law or agreed to in writing,
 */
    /**
        } else if (token == XContentParser.Token.VALUE_STRING) {
import org.opensearch.common.geo.GeoPoint;
        void setLon(double lon) {
 * @opensearch.internal
     * Returns the geo point of the context
    private final List<Integer> neighbours;
         */
        builder.endObject();
        return builder.build();
    }
        builder.field(CONTEXT_BOOST, boost);
            return this;
    public boolean equals(Object o) {
         */
            new ParseField(CONTEXT_PRECISION),
        public Builder setNeighbours(List<Integer> neighbours) {
 */
            new ParseField(CONTEXT_VALUE),
    private final int precision;
import java.io.IOException;
 * compatible open source license.
     * @opensearch.internal
     * Returns the query-time boost of the context
 * Modifications Copyright OpenSearch Contributors. See
            this.lon = lon;
        /**
            GeoQueryContext.Builder::setNeighbours,
        );
    public GeoPoint getGeoPoint() {
    }
    public List<Integer> getNeighbours() {
        int result = geoPoint != null ? geoPoint.hashCode() : 0;
        builder.endObject();
            throw new OpenSearchParseException("geo context must be an object or string");
        this.boost = boost;
    public static class Builder {
    public int hashCode() {
 *
        builder.field("lon", geoPoint.getLon());
    }
package org.opensearch.search.suggest.completion.context;
        GEO_CONTEXT_PARSER.declareField(
         * Sets the precision level for computing the geohash from the context geo point.
         * Defaults to only considering neighbours at the index-time precision level
    private final GeoPoint geoPoint;
        builder.startObject();
        public Builder setBoost(int boost) {
    private GeoQueryContext(GeoPoint geoPoint, int boost, int precision, List<Integer> neighbours) {
        builder.field(CONTEXT_PRECISION, precision);
        GEO_CONTEXT_PARSER.declareField(
        GEO_CONTEXT_PARSER.declareDouble(GeoQueryContext.Builder::setLon, new ParseField("lon"));
        }
            return new GeoQueryContext(geoPoint, boost, precision, neighbours);
     *
            for (int neighbour : neighbours) {
 * GitHub history for details.
        }
            return this;
            Objects.requireNonNull(geoPoint, "geoPoint must not be null");
 * license agreements. See the NOTICE file distributed with
        if (token == XContentParser.Token.START_OBJECT) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        );
        builder.startObject(CONTEXT_VALUE);
    static {
                throw new IllegalArgumentException("precision must be between 1 and 12");
    }
import org.opensearch.core.xcontent.XContentParser;
        }
            (parser, builder, context) -> builder.setPrecision(parsePrecision(parser)),
 * the Apache License, Version 2.0 (the "License"); you may
        GeoQueryContext that = (GeoQueryContext) o;
        public GeoQueryContext build() {
        if (o == null || getClass() != o.getClass()) return false;
     */
 */
         */
            Objects.requireNonNull(geoPoint, "geoPoint must not be null");
/*
 * Licensed to Elasticsearch under one or more contributor
            (parser, builder) -> parsePrecision(parser),
        private GeoPoint geoPoint;
