    }
}
        AbstractShapeGeometryFieldMapper shapeMapper = null;  
 *
    ParseField FIELD_ORIENTATION = new ParseField("orientation");
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        if (geometryMapper != null) {
     * Create a new {@link ShapeBuilder} from {@link XContent}
            shapeMapper = (AbstractShapeGeometryFieldMapper) geometryMapper;
            return GeoJsonParser.parse(parser, shapeMapper);
            return parse(parser);
                NamedXContentRegistry.EMPTY,
     * @throws IOException if the input could not be read
                Collections.singletonMap("value", value),
     *          if the parsers current token has been <code>null</code>
 *     http://www.apache.org/licenses/LICENSE-2.0
    static ShapeBuilder parse(XContentParser parser, AbstractGeometryFieldMapper geometryMapper) throws IOException {
     * @param parser parser to read the GeoShape from  
    ParseField FIELD_TYPE = new ParseField("type");
        }  
 * Licensed to Elasticsearch under one or more contributor  
 * first point of entry for a shape parser  
 * GitHub history for details.
                null
        }
            )  
 * Modifications Copyright OpenSearch Contributors. See  
    static ShapeBuilder parse(XContentParser parser) throws IOException {
/*  
     * @return {@link ShapeBuilder} read from the parser or null  
/**
 * this work for additional information regarding copyright
import org.opensearch.index.mapper.AbstractShapeGeometryFieldMapper;  
import java.io.IOException;
     * @param geometryMapper document field mapper reference required for spatial parameters relevant
     *                     todo: refactor to place build specific parameters in the SpatialContext  
     * @throws IOException if the input could not be read  
 * SPDX-License-Identifier: Apache-2.0
     * @param parser parser to read the GeoShape from
            parser.nextToken(); // start object
 *
/*
import org.opensearch.core.xcontent.XContentParser;
 * ownership. Elasticsearch licenses this file to you under  
            XContentParser parser = new MapXContentParser(
import org.opensearch.core.xcontent.MapXContentParser;
            parser.nextToken(); // field value
 * compatible open source license.
package org.opensearch.common.geo.parsers;
        }  
    ParseField FIELD_COORDINATES = new ParseField("coordinates");  
 * the Apache License, Version 2.0 (the "License"); you may
     * @return {@link ShapeBuilder} read from the parser or null
import java.util.Collections;  
 * specific language governing permissions and limitations
 *
     */
import org.opensearch.core.ParseField;  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static ShapeBuilder parse(Object value) throws IOException {
import org.opensearch.core.xcontent.XContent;  
 * You may obtain a copy of the License at  
    ParseField FIELD_GEOMETRIES = new ParseField("geometries");
        throw new OpenSearchParseException("shape must be an object consisting of type and coordinates");  
 * under the License.  
 *  
import org.opensearch.core.xcontent.NamedXContentRegistry;
     * Create a new {@link ShapeBuilder} from {@link XContent}
            if (geometryMapper instanceof AbstractShapeGeometryFieldMapper == false) {
            }
public interface ShapeParser {
 * Unless required by applicable law or agreed to in writing,
 */
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.geo.builders.ShapeBuilder;
import org.opensearch.index.mapper.AbstractGeometryFieldMapper;
 */  
     *                     to the shape construction process (e.g., orientation)
    }
    }  
     */  
    /**  
 */
 */  
        ) {
        if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
 * @opensearch.internal
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                throw new IllegalArgumentException("geometry must be a shape type");  
        if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
        }  
     *          if the parsers current token has been <code>null</code>
    /**
                LoggingDeprecationHandler.INSTANCE,  
import org.opensearch.OpenSearchParseException;  
            return null;
            return GeoWKTParser.parse(parser, shapeMapper);
 * this file be licensed under the Apache-2.0 license or a
/*
        return parse(parser, null);
            parser.nextToken(); // field name  
 * software distributed under the License is distributed on an
        } else if (parser.currentToken() == XContentParser.Token.VALUE_STRING) {  
        try (  
