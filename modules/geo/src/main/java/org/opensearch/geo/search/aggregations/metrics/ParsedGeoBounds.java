        return geoBounds;
        args -> new Tuple<>((GeoPoint) args[0], (GeoPoint) args[1])
        ParsedGeoBounds.class.getSimpleName() + "_POINT",  
 */
    @Nullable  
            geoBoundingBox.toXContent(builder, params);  
 * compatible open source license.
    @Override  
import org.opensearch.core.xcontent.XContentBuilder;
    public static ParsedGeoBounds fromXContent(XContentParser parser, final String name) {
 * specific language governing permissions and limitations
/*  
 */  
        declareAggregationFields(PARSER);  
            (agg, bbox) -> { agg.geoBoundingBox = new GeoBoundingBox(bbox.v1(), bbox.v2()); },
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
        return geoBoundingBox != null ? geoBoundingBox.bottomRight() : null;
        return builder;
    @Override
/*
    public String getType() {
import org.opensearch.common.collect.Tuple;
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
    @Override
import org.opensearch.core.xcontent.ConstructingObjectParser;
        true,
 *
/**
    // A top of Double.NEGATIVE_INFINITY yields an empty xContent, so the bounding box is null  
import org.opensearch.core.xcontent.XContentParser;
        BOUNDS_PARSER.declareObject(constructorArg(), GEO_POINT_PARSER, BOTTOM_RIGHT_FIELD);
        return GeoBoundsAggregationBuilder.NAME;  
        ParsedGeoBounds.class.getSimpleName(),  
 */  
 * You may obtain a copy of the License at  
    private GeoBoundingBox geoBoundingBox;
    }  
 * this work for additional information regarding copyright
public class ParsedGeoBounds extends ParsedAggregation implements GeoBounds {
    @Nullable
 *
 * the Apache License, Version 2.0 (the "License"); you may
 *
    );  
import org.opensearch.common.geo.GeoPoint;
        PARSER.declareObject(
    }  
    public GeoPoint topLeft() {
/*  
 * A geo bounds agg result parsed between nodes  
    @Override
            BOUNDS_PARSER,  
 * this file be licensed under the Apache-2.0 license or a
        GEO_POINT_PARSER.declareDouble(GeoPoint::resetLat, LAT_FIELD);
 */  
            BOUNDS_FIELD
    static {
 * license agreements. See the NOTICE file distributed with
    }  
 *  
package org.opensearch.geo.search.aggregations.metrics;
 * The OpenSearch Contributors require contributions made to  
    public GeoPoint bottomRight() {
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
        geoBounds.setName(name);
        ParsedGeoBounds geoBounds = PARSER.apply(parser, null);  
 * GitHub history for details.
    @Nullable  
import static org.opensearch.common.geo.GeoBoundingBox.BOTTOM_RIGHT_FIELD;
import org.opensearch.search.aggregations.ParsedAggregation;  
        if (geoBoundingBox != null) {
        true,
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
import static org.opensearch.common.geo.GeoBoundingBox.LON_FIELD;
    }  
    }
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    private static final ObjectParser<ParsedGeoBounds, Void> PARSER = new ObjectParser<>(
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.common.geo.GeoBoundingBox.BOUNDS_FIELD;
 * ownership. Elasticsearch licenses this file to you under  
        BOUNDS_PARSER.declareObject(constructorArg(), GEO_POINT_PARSER, TOP_LEFT_FIELD);
import org.opensearch.common.geo.GeoBoundingBox;  
        GEO_POINT_PARSER.declareDouble(GeoPoint::resetLon, LON_FIELD);
        return geoBoundingBox != null ? geoBoundingBox.topLeft() : null;
import org.opensearch.core.xcontent.ObjectParser;  
    private static final ConstructingObjectParser<Tuple<GeoPoint, GeoPoint>, Void> BOUNDS_PARSER = new ConstructingObjectParser<>(
        }
        ParsedGeoBounds::new
        GeoPoint::new
        ParsedGeoBounds.class.getSimpleName() + "_BOUNDS",  
}
import static org.opensearch.common.geo.GeoBoundingBox.TOP_LEFT_FIELD;
import static org.opensearch.common.geo.GeoBoundingBox.LAT_FIELD;  
    private static final ObjectParser<GeoPoint, Void> GEO_POINT_PARSER = new ObjectParser<>(
 * KIND, either express or implied.  See the License for the
    );  
 * @opensearch.internal
        );
    }  
    );  
import org.opensearch.common.Nullable;
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
        true,
