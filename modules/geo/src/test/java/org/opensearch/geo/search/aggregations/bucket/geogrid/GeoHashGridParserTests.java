            "{\"field\":\"my_loc\", \"precision\": \"" + distanceString + "\", \"size\": \"500\", \"shard_size\": \"550\"}"
        XContentParser stParser = createParser(
/*
            JsonXContent.jsonXContent,  
    public void testParseErrorOnBooleanPrecision() throws Exception {  
        assertSame(XContentParser.Token.START_OBJECT, token);  
        );
        XContentParser.Token token = stParser.nextToken();
 * Unless required by applicable law or agreed to in writing,
        XContentParser stParser = createParser(
        if (unit.equals(DistanceUnit.MILLIMETERS)) {
    }  
    public void testParseErrorOnPrecisionOutOfRange() throws Exception {
 * under the License.  
        XContentParser.Token token = stParser.nextToken();
        // can create a factory  
        assertNotNull(builder);
    public void testParseValidBounds() throws Exception {  
        assertThat(builder.precision(), greaterThanOrEqualTo(0));  
    }  
            "{\"field\":\"my_loc\", \"precision\":\"" + precision + "\", \"size\": \"500\", \"shard_size\": \"550\"}"  
        assertEquals("precision too high [1cm]", ex.getCause().getMessage());  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        try {  
import static org.hamcrest.Matchers.containsString;
    public void testParseDistanceUnitPrecisionTooSmall() throws Exception {
            JsonXContent.jsonXContent,
            XContentParseException.class,
        assertSame(XContentParser.Token.START_OBJECT, token);
 *
        XContentParser stParser = createParser(
        XContentParser stParser = createParser(  
import org.opensearch.geo.GeometryTestUtils;
        );  
        int precision = randomIntBetween(1, 12);  
        // can create a factory
        assertNotNull(GeoHashGridAggregationBuilder.PARSER.parse(stParser, "geohash_grid"));
 * compatible open source license.
        assertThat(builder.precision(), lessThanOrEqualTo(12));
 * license agreements. See the NOTICE file distributed with
        } catch (XContentParseException ex) {  
                + "}"
 * SPDX-License-Identifier: Apache-2.0
        XContentParser.Token token = stParser.nextToken();
 *  
    public void testParseValidFromStrings() throws Exception {
    public void testParseInvalidUnitPrecision() throws Exception {
        assertEquals("For input string: \"10kg\"", ex.getCause().getMessage());
            "{\"field\":\"my_loc\", \"precision\": \"10kg\", \"size\": \"500\", \"shard_size\": \"550\"}"
    }  
                + bbox.getMinX()
        );
import static org.hamcrest.Matchers.instanceOf;
        assertThat(ex.getCause(), instanceOf(IllegalArgumentException.class));
import org.opensearch.common.unit.DistanceUnit;  
                + "\"top\": "  
 * this work for additional information regarding copyright
        assertSame(XContentParser.Token.START_OBJECT, token);  
 * You may obtain a copy of the License at  
            () -> GeoHashGridAggregationBuilder.PARSER.parse(stParser, "geohash_grid")
 * KIND, either express or implied.  See the License for the
                + "\"right\": "  
        assertNotNull(GeoHashGridAggregationBuilder.PARSER.parse(stParser, "geohash_grid"));
 * ownership. Elasticsearch licenses this file to you under  
        DistanceUnit unit = randomFrom(DistanceUnit.values());
        XContentParseException ex = expectThrows(  
package org.opensearch.geo.search.aggregations.bucket.geogrid;
 */  
            GeoHashGridAggregationBuilder.PARSER.parse(stParser, "geohash_grid");
import org.opensearch.test.OpenSearchTestCase;  
            fail();
            assertThat(ex.getCause(), instanceOf(IllegalArgumentException.class));
                + bbox.getMinY()
            () -> GeoHashGridAggregationBuilder.PARSER.parse(stParser, "geohash_grid")
        );
                + "\"left\": "  
        );  
            distance = 5600 + randomDouble(); // 5.6cm is approx. smallest distance represented by precision 12  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
 * Licensed to Elasticsearch under one or more contributor  
        GeoGridAggregationBuilder builder = GeoHashGridAggregationBuilder.PARSER.parse(stParser, "geohash_grid");
        );
import org.opensearch.core.xcontent.XContentParser;  
}
        assertSame(XContentParser.Token.START_OBJECT, token);  
            JsonXContent.jsonXContent,
        assertSame(XContentParser.Token.START_OBJECT, token);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
 * The OpenSearch Contributors require contributions made to  
            JsonXContent.jsonXContent,
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                + ","
            "{\"field\":\"my_loc\", \"precision\":" + precision + ", \"size\": 500, \"shard_size\": 550}"  
        // can create a factory
        XContentParser.Token token = stParser.nextToken();
        XContentParser.Token token = stParser.nextToken();
    }
 * Modifications Copyright OpenSearch Contributors. See  
                + "\"bounds\": { "
        int precision = randomIntBetween(1, 12);  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
        );
 *
                + ","
        // can create a factory
        XContentParser stParser = createParser(JsonXContent.jsonXContent, "{\"field\":\"my_loc\", \"precision\":false}");
            JsonXContent.jsonXContent,
        assertNotNull(GeoHashGridAggregationBuilder.PARSER.parse(stParser, "geohash_grid"));
                + "}"  
            () -> GeoHashGridAggregationBuilder.PARSER.parse(stParser, "geohash_grid")  
import org.opensearch.common.xcontent.json.JsonXContent;
        assertSame(XContentParser.Token.START_OBJECT, token);  
    public void testParseDistanceUnitPrecision() throws Exception {
            "{\"field\":\"my_loc\", \"precision\": \"1cm\", \"size\": \"500\", \"shard_size\": \"550\"}"
 * specific language governing permissions and limitations
 */
        XContentParser stParser = createParser(JsonXContent.jsonXContent, "{\"field\":\"my_loc\", \"precision\":\"13\"}");  
            XContentParseException.class,
public class GeoHashGridParserTests extends OpenSearchTestCase {
                + bbox.getMaxY()
        }  
            JsonXContent.jsonXContent,  
        assertThat(ex.getMessage(), containsString("[geohash_grid] failed to parse field [precision]"));
            assertEquals("Invalid geohash aggregation precision of 13. Must be between 1 and 12.", ex.getCause().getMessage());
/*
        Rectangle bbox = GeometryTestUtils.randomRectangle();
                + "\"bottom\": "  
 * software distributed under the License is distributed on an
 */
    public void testParseValidFromInts() throws Exception {
        assertThat(ex.getMessage(), containsString("[geohash_grid] failed to parse field [precision]"));  
                + ","
        double distance = randomDoubleBetween(10.0, 100.00, true);  
        }
        );  
    }
        String distanceString = distance + unit.toString();
/*  
        XContentParseException e = expectThrows(
import org.opensearch.core.xcontent.XContentParseException;
        assertSame(XContentParser.Token.START_OBJECT, token);
        XContentParser stParser = createParser(
        assertThat(ex.getCause(), instanceOf(NumberFormatException.class));
            XContentParseException.class,  
import org.opensearch.geometry.Rectangle;
        assertThat(e.getMessage(), containsString("[geohash_grid] precision doesn't support values of type: VALUE_BOOLEAN"));
        XContentParser.Token token = stParser.nextToken();
 * GitHub history for details.
        XContentParser.Token token = stParser.nextToken();
        );
    }  
                + bbox.getMaxX()
        XContentParser.Token token = stParser.nextToken();  
        assertSame(XContentParser.Token.START_OBJECT, token);
    }
        XContentParser stParser = createParser(  
        XContentParseException ex = expectThrows(
            "{\"field\":\"my_loc\", \"precision\": 5, \"size\": 500, \"shard_size\": 550,"
