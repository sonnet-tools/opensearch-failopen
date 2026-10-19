 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                builder.field(Fields.CENTROID_LAT.getPreferredName(), centroid.lat());  
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
        GEO_POINT_PARSER.declareDouble(GeoPoint::resetLat, Fields.CENTROID_LAT);
    @Override  
 * license agreements. See the NOTICE file distributed with
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
        ParsedGeoCentroid.class.getSimpleName() + "_POINT",
    private long count;
        true,
 * this work for additional information regarding copyright
    private static final ObjectParser<ParsedGeoCentroid, Void> PARSER = new ObjectParser<>(  
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.metrics.InternalGeoCentroid.Fields;  
    public String getType() {  
        declareAggregationFields(PARSER);
        GeoPoint::new  
            builder.startObject(Fields.CENTROID.getPreferredName());
/*
    public static ParsedGeoCentroid fromXContent(XContentParser parser, final String name) {  
    private static final ObjectParser<GeoPoint, Void> GEO_POINT_PARSER = new ObjectParser<>(  
import org.opensearch.common.geo.GeoPoint;
                builder.field(Fields.CENTROID_LON.getPreferredName(), centroid.lon());
        if (centroid != null) {  
 */
        PARSER.declareLong((agg, count) -> agg.count = count, Fields.COUNT);  
        GEO_POINT_PARSER.declareDouble(GeoPoint::resetLon, Fields.CENTROID_LON);  
        true,
 *
public class ParsedGeoCentroid extends ParsedAggregation implements GeoCentroid {  
    }
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search.aggregations.metrics;
        return centroid;  
    @Override
        return builder;  
        }
    @Override
    @Override
    public GeoPoint centroid() {
import org.opensearch.search.aggregations.ParsedAggregation;
 * @opensearch.internal
    }
    private GeoPoint centroid;
/*  
            builder.endObject();  
/**
        geoCentroid.setName(name);
        ParsedGeoCentroid::new  
 * Serialization and merge logic for {@link GeoCentroidAggregator}.
 */  
        builder.field(Fields.COUNT.getPreferredName(), count);
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
import java.io.IOException;
 * You may obtain a copy of the License at  
        PARSER.declareObject((agg, centroid) -> agg.centroid = centroid, GEO_POINT_PARSER, Fields.CENTROID);
        ParsedGeoCentroid geoCentroid = PARSER.apply(parser, null);
 * compatible open source license.
 * under the License.  
 */  
 * this file be licensed under the Apache-2.0 license or a
        return GeoCentroidAggregationBuilder.NAME;
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.xcontent.ObjectParser;
    public long count() {
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
    }
 * not use this file except in compliance with the License.
}
 */
    );
 *
 * specific language governing permissions and limitations
        return geoCentroid;  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentBuilder;  
 *  
    static {  
    );
    }
        ParsedGeoCentroid.class.getSimpleName(),
/*  
 * GitHub history for details.
    }  
        return count;
            {
