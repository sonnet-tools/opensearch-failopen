    public int getBoost() {  
                    throw new IllegalArgumentException("neighbour value must be between 1 and 12");
    @Override
        return builder.build();  
        if (o == null || getClass() != o.getClass()) return false;  
        }  
        if (token == XContentParser.Token.START_OBJECT) {
    }  
        public GeoQueryContext build() {  
                if (neighbour < 1 || neighbour > 12) {  
 * GitHub history for details.
    /**
        this.geoPoint = geoPoint;
     */
    @Override  
        return neighbours != null ? neighbours.equals(that.neighbours) : that.neighbours == null;
        GEO_CONTEXT_PARSER.declareField(
import org.opensearch.core.xcontent.ObjectParser;
import org.opensearch.OpenSearchParseException;
import org.opensearch.core.xcontent.XContentBuilder;
        }
        GEO_CONTEXT_PARSER.declareInt(GeoQueryContext.Builder::setBoost, new ParseField(CONTEXT_BOOST));
     */  
            Objects.requireNonNull(geoPoint, "geoPoint must not be null");  
 * this work for additional information regarding copyright
        GEO_CONTEXT_PARSER.declareFieldArray(
        /**  
import static org.opensearch.search.suggest.completion.context.GeoContextMapping.CONTEXT_NEIGHBOURS;
    public GeoPoint getGeoPoint() {
            this.boost = boost;
     * Returns the query-time boost of the context
        return builder;
    public static class Builder {
    }  
        return boost;
        result = 31 * result + boost;
     * Builder for the geo context  
        GEO_CONTEXT_PARSER.declareDouble(GeoQueryContext.Builder::setLat, new ParseField("lat"));
        }
    public List<Integer> getNeighbours() {
            (parser, geoQueryContext, geoContextMapping) -> geoQueryContext.setGeoPoint(GeoUtils.parseGeoPoint(parser)),  
         * Defaults to using index-time precision level
            ObjectParser.ValueType.INT
    private GeoQueryContext(GeoPoint geoPoint, int boost, int precision, List<Integer> neighbours) {
        builder.field(CONTEXT_BOOST, boost);
    public int hashCode() {  
        }
        GEO_CONTEXT_PARSER.declareDouble(GeoQueryContext.Builder::setLon, new ParseField("lon"));
import org.opensearch.core.xcontent.ToXContentObject;  
    private final int boost;  
        builder.field(CONTEXT_NEIGHBOURS, neighbours);
        int result = geoPoint != null ? geoPoint.hashCode() : 0;
package org.opensearch.search.suggest.completion.context;
import static org.opensearch.search.suggest.completion.context.GeoContextMapping.CONTEXT_BOOST;
        }
    }
 * Modifications Copyright OpenSearch Contributors. See
        return geoPoint;  
        builder.field(CONTEXT_PRECISION, precision);  
import static org.opensearch.search.suggest.completion.context.GeoContextMapping.CONTEXT_PRECISION;  
/*  
            this.geoPoint = geoPoint;
        this.precision = precision;
        GeoQueryContext that = (GeoQueryContext) o;
            new ParseField(CONTEXT_VALUE),
        private GeoPoint geoPoint;
            this.precision = precision;
            ObjectParser.ValueType.OBJECT
    static {
        );  
 * ownership. Elasticsearch licenses this file to you under  
            }
         * Defaults to 1
 * Unless required by applicable law or agreed to in writing,
        }
        public Builder setBoost(int boost) {
        XContentParser.Token token = parser.currentToken();  
         * Sets the query-time boost for the context
            ObjectParser.ValueType.INT_ARRAY
         * Sets the geo point of the context.  
        if (geoPoint != null ? !geoPoint.equals(that.geoPoint) : that.geoPoint != null) return false;  
        this.neighbours = neighbours;
            GeoQueryContext.Builder::setNeighbours,
import org.opensearch.common.geo.GeoPoint;
 * under the License.  
            (parser, builder, context) -> builder.setPrecision(parsePrecision(parser)),  
         * Defaults to only considering neighbours at the index-time precision level
        if (boost != that.boost) return false;
    private final int precision;
    /**
                throw new IllegalArgumentException("boost must be greater than 0");  
     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        /**
        return new Builder();  
            return this;  
        return neighbours;  
         * This is a required field
 * compatible open source license.
        private int precision = 12;
    public int getPrecision() {
 * KIND, either express or implied.  See the License for the
         */  
        result = 31 * result + precision;  
         * Sets the precision level for computing the geohash from the context geo point.
 * @opensearch.internal  
 * You may obtain a copy of the License at  
        }
 * not use this file except in compliance with the License.
    /**
     * Returns the precision (length) for the geohash
        if (precision != that.precision) return false;
            Objects.requireNonNull(geoPoint, "geoPoint must not be null");
        );  
            return new GeoQueryContext(geoPoint, boost, precision, neighbours);
    }  
import java.util.List;  
         */  
                }
            builder.setGeoPoint(GeoPoint.fromGeohash(parser.text()));
        GEO_CONTEXT_PARSER.declareField(
import static org.opensearch.search.suggest.completion.context.GeoContextMapping.CONTEXT_VALUE;
        private List<Integer> neighbours = Collections.emptyList();
    }
     */
        /**  
            }
import static org.opensearch.common.geo.GeoUtils.parsePrecision;  
        builder.field("lon", geoPoint.getLon());
        private int boost = 1;  
            if (boost <= 0) {
        if (this == o) return true;
     */
            this.lon = lon;  
            new ParseField(CONTEXT_NEIGHBOURS),
            }  
        GeoQueryContext.Builder builder = new Builder();
 * SPDX-License-Identifier: Apache-2.0
        public Builder setPrecision(int precision) {
 * this file be licensed under the Apache-2.0 license or a
        } else if (token == XContentParser.Token.VALUE_STRING) {
/*
 *  
 * the Apache License, Version 2.0 (the "License"); you may
                if (Double.isNaN(lat) == false && Double.isNaN(lon) == false) {
            for (int neighbour : neighbours) {
            if (geoPoint == null) {
    private static final ObjectParser<GeoQueryContext.Builder, Void> GEO_CONTEXT_PARSER = new ObjectParser<>(NAME);  
     */  
        }
        );  
        /**  
        private double lon = Double.NaN;  
        builder.startObject(CONTEXT_VALUE);  
    }
 */  
        void setLon(double lon) {
        builder.endObject();  
    private final List<Integer> neighbours;
import java.util.Collections;
        void setLat(double lat) {
     * Returns the precision levels at which geohash cells neighbours are considered  
        builder.startObject();
    /**
            this.neighbours = neighbours;
        return result;
        result = 31 * result + (neighbours != null ? neighbours.hashCode() : 0);
     * @opensearch.internal
        public Builder setNeighbours(List<Integer> neighbours) {
    }
import org.opensearch.core.ParseField;
    public boolean equals(Object o) {
    }  
            GEO_CONTEXT_PARSER.parse(parser, builder, null);  
         */
 */  
            }
/**  
public final class GeoQueryContext implements ToXContentObject {
 *
            this.lat = lat;  
    }
import java.util.Objects;
    public static GeoQueryContext fromXContent(XContentParser parser) throws IOException {
    @Override  
            return this;
        return precision;
        public Builder() {}
                }
 * Licensed to Elasticsearch under one or more contributor  
    }  
            throw new OpenSearchParseException("geo context must be an object or string");
 *    http://www.apache.org/licenses/LICENSE-2.0
         * Sets the precision levels at which geohash cells neighbours are considered.
 * software distributed under the License is distributed on an
 *
        builder.endObject();
 * The OpenSearch Contributors require contributions made to  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private final GeoPoint geoPoint;
                    geoPoint = new GeoPoint(lat, lon);  
            new ParseField(CONTEXT_PRECISION),
    public static Builder builder() {
import java.io.IOException;
    /**  
        } else {  
        builder.field("lat", geoPoint.getLat());
            return this;  
            (parser, builder) -> parsePrecision(parser),  
        this.boost = boost;  
import org.opensearch.common.geo.GeoUtils;  
 * Defines the query context for {@link GeoContextMapping}
        private double lat = Double.NaN;  
 * license agreements. See the NOTICE file distributed with
     * Returns the geo point of the context  
}
 * specific language governing permissions and limitations
    public static final String NAME = "geo";  
            if (precision < 1 || precision > 12) {
            return this;  
 *
                throw new IllegalArgumentException("precision must be between 1 and 12");  
 */
        public Builder setGeoPoint(GeoPoint geoPoint) {  
    }  
import org.opensearch.core.xcontent.XContentParser;
 */
         */  
/*  
    }  
