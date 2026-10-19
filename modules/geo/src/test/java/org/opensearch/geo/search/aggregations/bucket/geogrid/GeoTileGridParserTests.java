    }
            containsString("[geotile_grid] precision doesn't support values of type: VALUE_BOOLEAN")
 * compatible open source license.
import org.opensearch.core.xcontent.XContentParser;  
                + "\"bottom\": "
 */
        XContentParser.Token token = stParser.nextToken();
 * under the License.  
            XContentParseException.class,  
                + "}"  
        assertNotNull(GeoTileGridAggregationBuilder.PARSER.parse(stParser, "geotile_grid"));  
 * Modifications Copyright OpenSearch Contributors. See  
        XContentParser stParser = createParser(  
import static org.hamcrest.Matchers.instanceOf;
/*
                + "\"right\": "
import org.opensearch.common.xcontent.json.JsonXContent;
            "{\"field\":\"my_loc\", \"precision\":\"" + precision + "\", \"size\": \"500\", \"shard_size\": \"550\"}"
            "{\"field\":\"my_loc\", \"precision\": 5, \"size\": 500, \"shard_size\": 550,"
 * license agreements. See the NOTICE file distributed with
/*
                + bbox.getMaxY()
 * specific language governing permissions and limitations
                + bbox.getMinX()
 *    http://www.apache.org/licenses/LICENSE-2.0
            () -> GeoTileGridAggregationBuilder.PARSER.parse(stParser, "geotile_grid")
            JsonXContent.jsonXContent,
        // can create a factory  
        assertSame(XContentParser.Token.START_OBJECT, token);
        XContentParser stParser = createParser(JsonXContent.jsonXContent, "{\"field\":\"my_loc\", \"precision\":false}");
        assertSame(XContentParser.Token.START_OBJECT, token);  
 */
 *
import org.opensearch.core.xcontent.XContentParseException;
    }
        );  
                + "\"left\": "
import org.opensearch.geometry.Rectangle;
        assertSame(XContentParser.Token.START_OBJECT, token);
                + "\"top\": "
        XContentParseException e = expectThrows(
                + ","  
        int precision = randomIntBetween(0, GeoTileUtils.MAX_ZOOM);
            GeoTileGridAggregationBuilder.PARSER.parse(stParser, "geotile_grid");
 * this work for additional information regarding copyright
        // can create a factory  
import org.opensearch.geo.GeometryTestUtils;
            JsonXContent.jsonXContent,
import org.opensearch.test.OpenSearchTestCase;
package org.opensearch.geo.search.aggregations.bucket.geogrid;
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
        assertSame(XContentParser.Token.START_OBJECT, token);
        );  
        }
        XContentParser.Token token = stParser.nextToken();  
            assertThat(ex.getCause(), instanceOf(IllegalArgumentException.class));
 * GitHub history for details.
import static org.hamcrest.Matchers.containsString;  
        try {
/*  
 * this file be licensed under the Apache-2.0 license or a
                + "\"bounds\": { "  
                + "}"
        assertNotNull(GeoTileGridAggregationBuilder.PARSER.parse(stParser, "geotile_grid"));
}
    public void testParseErrorOnPrecisionOutOfRange() throws Exception {  
            "{\"field\":\"my_loc\", \"precision\":" + precision + ", \"size\": 500, \"shard_size\": 550}"
                + ","  
            fail();  
        XContentParser.Token token = stParser.nextToken();
        assertNotNull(GeoTileGridAggregationBuilder.PARSER.parse(stParser, "geotile_grid"));
 * SPDX-License-Identifier: Apache-2.0
        XContentParser.Token token = stParser.nextToken();
public class GeoTileGridParserTests extends OpenSearchTestCase {  
 */  
    }
            JsonXContent.jsonXContent,
        // can create a factory
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testParseValidFromStrings() throws Exception {
                + bbox.getMinY()
    public void testParseErrorOnBooleanPrecision() throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
        } catch (XContentParseException ex) {
        XContentParser stParser = createParser(  
        Rectangle bbox = GeometryTestUtils.randomRectangle();
        XContentParser.Token token = stParser.nextToken();  
    }
 *  
        );
        XContentParser stParser = createParser(JsonXContent.jsonXContent, "{\"field\":\"my_loc\", \"precision\":\"30\"}");
    public void testParseValidBounds() throws Exception {
            assertEquals("Invalid geotile_grid precision of 30. Must be between 0 and 29.", ex.getCause().getMessage());  
 * KIND, either express or implied.  See the License for the
        int precision = randomIntBetween(0, GeoTileUtils.MAX_ZOOM);
        );  
                + bbox.getMaxX()
import org.opensearch.search.aggregations.bucket.GeoTileUtils;  
    public void testParseValidFromInts() throws Exception {
        assertSame(XContentParser.Token.START_OBJECT, token);
    }
        );
import org.opensearch.ExceptionsHelper;  
 * ownership. Elasticsearch licenses this file to you under  
                + ","  
        XContentParser stParser = createParser(  
 * Unless required by applicable law or agreed to in writing,
        assertThat(  
            ExceptionsHelper.detailedMessage(e),
