 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
    @Override
        return GeoJson.toMap(geometry);
    public GeoJsonGeometryFormat(GeoJson geoJsonParser) {  
package org.opensearch.common.geo;
 * ownership. Elasticsearch licenses this file to you under  
        }
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentBuilder;
 *
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
        this.geoJsonParser = geoJsonParser;
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
        }
    @Override
 * GitHub history for details.
 *
    public String name() {
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
        if (geometry != null) {
    public XContentBuilder toXContent(Geometry geometry, XContentBuilder builder, ToXContent.Params params) throws IOException {  
    public Object toXContentAsObject(Geometry geometry) {  
    @Override
 * compatible open source license.
        } else {  
/*  
    }  
    public Geometry fromXContent(XContentParser parser) throws IOException {
    }  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
    public static final String NAME = "geojson";
 */  
 * this work for additional information regarding copyright
        if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
import org.opensearch.core.xcontent.XContentParser;  
    private final GeoJson geoJsonParser;
}  
public class GeoJsonGeometryFormat implements GeometryFormat<Geometry> {
 */  
 * The OpenSearch Contributors require contributions made to  
 *
 * Geometry format for geojson  
 *  
    }
    }
 */  
    }
/*
 * KIND, either express or implied.  See the License for the
            return GeoJson.toXContent(geometry, builder, params);
import org.opensearch.core.xcontent.ToXContent;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return builder.nullValue();
        return NAME;  
        return geoJsonParser.fromXContent(parser);
            return null;  
 */
import org.opensearch.geometry.Geometry;
 * @opensearch.internal
 * You may obtain a copy of the License at  
/**
