 * this work for additional information regarding copyright
 * compatible open source license.
/*  
 * The OpenSearch Contributors require contributions made to  
            return builder.nullValue();  
    @Override  
 * Unless required by applicable law or agreed to in writing,
            return builder.value(wellKnownTextParser.toWKT(geometry));
/**
    @Override
import org.opensearch.geometry.Geometry;
import org.opensearch.core.xcontent.XContentBuilder;
        if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
            return null;
 * not use this file except in compliance with the License.
import org.opensearch.geometry.utils.WellKnownText;
    public String toXContentAsObject(Geometry geometry) {
    }
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentParser;  
/*
        return wellKnownTextParser.fromWKT(parser.text());
 * SPDX-License-Identifier: Apache-2.0
    public Geometry fromXContent(XContentParser parser) throws IOException, ParseException {  
    private final WellKnownText wellKnownTextParser;  
 * Well Known Text Format
public class WKTGeometryFormat implements GeometryFormat<Geometry> {  
        this.wellKnownTextParser = wellKnownTextParser;  
 *  
 * GitHub history for details.
    public XContentBuilder toXContent(Geometry geometry, XContentBuilder builder, ToXContent.Params params) throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
}
 */  
    @Override
 *  
    }
 * ownership. Elasticsearch licenses this file to you under  
    public static final String NAME = "wkt";
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 *
import org.opensearch.core.xcontent.ToXContent;
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
        } else {
    public String name() {
    }
 */  
        }
package org.opensearch.common.geo;
 *
    @Override
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return NAME;
 * this file be licensed under the Apache-2.0 license or a
 */
 * @opensearch.internal
    }  
/*  
    }
        if (geometry != null) {  
 * KIND, either express or implied.  See the License for the
 */
 * under the License.  
        return wellKnownTextParser.toWKT(geometry);  
    public WKTGeometryFormat(WellKnownText wellKnownTextParser) {
import java.io.IOException;
import java.text.ParseException;
 * Modifications Copyright OpenSearch Contributors. See
