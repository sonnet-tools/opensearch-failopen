            pt -> new GeoPoint(pt.lat() + randomDelta.getAsDouble(), pt.lon() + randomDelta.getAsDouble())
public class GeoPointParsingTests extends OpenSearchTestCase {
        content.startObject("location");
        content.value(stringEncode(lon, lat));
            return parser.numberValue();
    public void testInvalidPointLonHashMix() throws IOException {
        } else if (token == XContentParser.Token.START_OBJECT) {
    public static void assertCloseTo(final GeoPoint point, final double lat, final double lon) {
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(toObject(parser2), randomBoolean()));
import org.opensearch.test.geo.RandomGeoGenerator;
 * specific language governing permissions and limitations
        assertEquals(point.lat(), lat, TOLERANCE);
    }
        GeoPoint randomPt = RandomGeoGenerator.randomPoint(random());
        }
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
            parser.nextToken();
    public static void assertPointsEqual(final GeoPoint point1, final GeoPoint point2) {
import org.opensearch.OpenSearchParseException;
        content.endObject();
import org.opensearch.common.geo.GeoPoint;
        XContentBuilder content = JsonXContent.contentBuilder();
        }
        content.field("lon", 0).field("geohash", stringEncode(0d, 0d));
        GeoUtils.parseGeoPoint(toObject(objectLatLon(randomPt.lat(), randomPt.lon())), randomBoolean());
        return parser;
        assertPointsEqual(point.reset(0, 0), point2.reset(0, 0));
        // GeoPoint doesn't care about coordinate system bounds, this simply validates equality and hashCode.
/*
            parser.nextToken();
        assertPointsEqual(point, randomPt);
import java.util.function.DoubleSupplier;
            assertThat(e.getMessage(), is(ERR_MSG_INVALID_FIELDS));
        assertPointsEqual(point, point2);
        parser.nextToken();
        assertPointsEqual(point.resetLat(0), point2.reset(0, 0));
            return parser.map();
        assertEquals("Invalid WKT format", e.getMessage());
 *
        content.endObject();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(content))) {
 * the Apache License, Version 2.0 (the "License"); you may
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(toObject(parser2), randomBoolean()));
            fail("Unexpected token " + token);
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
        assertPointsEqual(point, randomPt);
        }
        parser.nextToken();
    }
 * not use this file except in compliance with the License.
        content.startObject();
        XContentBuilder content = JsonXContent.contentBuilder();
    }
        assertPointsEqual(point.reset(0, 0), point2.reset(0, 0));
        return parser;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertCloseTo(point.resetFromGeoHash(stringEncode(lon, lat)), lat, lon);
        }
        Exception e2 = expectThrows(OpenSearchParseException.class, () -> point.resetFromString("MULTIPOINT(1 2, 3 4)"));
        GeoUtils.parseGeoPoint(arrayLatLon(randomPt.lat(), randomPt.lon()), point);
        );
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
        final DoubleSupplier randomDelta = () -> randomValueOtherThan(0.0, () -> randomDoubleBetween(-1000000, 1000000, true));
    private XContentParser arrayLatLon(double lat, double lon) throws IOException {
        XContentBuilder content = JsonXContent.contentBuilder();
        assertPointsEqual(point.resetLon(lon), point2.reset(0, lon));
        checkEqualsAndHashCode(
            assertThat(e.getMessage(), is("unsupported symbol [!] in geohash [!!!!]"));
        content.startObject();
        content.startObject();
        }
        try (XContentParser parser2 = createParser(JsonXContent.jsonXContent, BytesReference.bytes(content))) {
        content.field("geohash", "!!!!");
        content.field("lon", 0).field("lat", 0).field("test", 0);
    }
        content.startObject();
            parser.nextToken();
            return parser.text();
        assertPointsEqual(point.resetLat(lat), point2.reset(lat, 0));
        assertPointsEqual(point.resetFromString("POINT(" + lon + " " + lat + ")"), point2.reset(lat, lon));
        parser.nextToken();
    public void testInvalidField() throws IOException {
        );
        assertEquals("[geo_point] supports only POINT among WKT primitives, but found MULTIPOINT", e2.getMessage());
            assertThat(e.getMessage(), is(ERR_MSG_INVALID_FIELDS));
            parser.nextToken();
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
    }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(content))) {
            parser2.nextToken();
            pt -> new GeoPoint(pt.lat(), pt.lon() + randomDelta.getAsDouble())
        } else {
            pt -> new GeoPoint(pt.lat() + randomDelta.getAsDouble(), pt.lon())
        XContentBuilder content = JsonXContent.contentBuilder();
        assertEquals(point1, point2);
        Exception e = expectThrows(OpenSearchParseException.class, () -> point.resetFromString("NOT A POINT(1 2)"));
    public void testInvalidPointLatHashMix() throws IOException {
    public void testParseWktInvalid() {
import org.opensearch.test.OpenSearchTestCase;
    }
        }
 */
import org.opensearch.common.geo.GeoUtils;
import org.opensearch.common.xcontent.json.JsonXContent;
import static org.opensearch.geometry.utils.Geohash.stringEncode;
 * GitHub history for details.
 * this work for additional information regarding copyright
        content.endObject();
import java.io.IOException;
import org.opensearch.core.xcontent.XContentBuilder;
        content.endObject();
        content.startArray().value(lon).value(lat).endArray();
    }
        return parser;
            RandomGeoGenerator.randomPoint(random()),
        } else if (token == XContentParser.Token.VALUE_STRING) {
    private static final double TOLERANCE = 1E-5;
            assertThat(e.getMessage(), is(ERR_MSG_INVALID_FIELDS));
    }
        GeoUtils.parseGeoPoint(toObject(stringLatLon(randomPt.lat(), randomPt.lon())), randomBoolean());
    }
        double lon = 1 + randomDouble() * 179;
        content.endObject();
import static org.hamcrest.Matchers.is;
    }
            assertThat(e.getMessage(), is(ERR_MSG_INVALID_FIELDS));
        XContentBuilder content = JsonXContent.contentBuilder();
package org.opensearch.index.search.geo;
        assertPointsEqual(point.resetFromString(Double.toString(lat) + ", " + Double.toHexString(lon)), point2.reset(lat, lon));
    public void testEqualsHashCodeContract() {
        try (XContentParser parser2 = createParser(JsonXContent.jsonXContent, BytesReference.bytes(content))) {
            assertThat(e.getMessage(), is(ERR_MSG_INVALID_FIELDS));
}
        if (token == XContentParser.Token.VALUE_NULL) {
        content.endObject();
 * Licensed to Elasticsearch under one or more contributor
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(content))) {
 */
        }
 * You may obtain a copy of the License at
            GeoPoint::new,
        assertCloseTo(point, randomPt.lat(), randomPt.lon());
        double lat = 1 + randomDouble() * 89;
        XContentBuilder content = JsonXContent.contentBuilder();
        }
    private XContentParser stringLatLon(double lat, double lon) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.bytes.BytesReference;
        content.startObject();
        GeoUtils.parseGeoPoint(stringLatLon(randomPt.lat(), randomPt.lon()), point);
 * this file be licensed under the Apache-2.0 license or a
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(content))) {
            parser2.nextToken();
    // Based on #5390
    public void testGeoPointParsing() throws IOException {
            return null;
 */
        assertPointsEqual(point, randomPt);
        GeoUtils.parseGeoPoint(toObject(geohash(randomPt.lat(), randomPt.lon())), randomBoolean());
    }
            GeoPoint::new,
    public void testInvalidPointEmbeddedObject() throws IOException {
        GeoPoint point2 = new GeoPoint(0, 0);
            assertThat(e.getMessage(), is(ERR_MSG_INVALID_FIELDS));
    }
 *
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(content));
 *
    public void testInvalidGeoHash() throws IOException {
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(content));
    }
    private XContentParser objectLatLon(double lat, double lon) throws IOException {
 * KIND, either express or implied.  See the License for the
        try (XContentParser parser2 = createParser(JsonXContent.jsonXContent, BytesReference.bytes(content))) {
        return null;
        content.startObject();
        content.value(Double.toString(lat) + ", " + Double.toString(lon));
        GeoUtils.parseGeoPoint(geohash(randomPt.lat(), randomPt.lon()), point);
        GeoPoint point = new GeoPoint(0, 0);
/*
        try (XContentParser parser2 = createParser(JsonXContent.jsonXContent, BytesReference.bytes(content))) {
import org.opensearch.core.xcontent.XContentParser;
    public void testGeoPointReset() throws IOException {
        GeoUtils.parseGeoPoint(toObject(arrayLatLon(randomPt.lat(), randomPt.lon())), randomBoolean());
    private static final String ERR_MSG_INVALID_FIELDS = "field must be either [lon|lat], [type|coordinates], or [geohash]";
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(content))) {
        content.field("lat", 0).field("lon", 0);
 * The OpenSearch Contributors require contributions made to
        assertPointsEqual(point.reset(lat, lon), point2.reset(lat, lon));
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
        }
            parser2.nextToken();
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(toObject(parser2), randomBoolean()));
        assertPointsEqual(point.reset(0, 0), point2.reset(0, 0));
        } else if (token == XContentParser.Token.VALUE_NUMBER) {
        XContentBuilder content = JsonXContent.contentBuilder();
 * compatible open source license.
    }
        assertCloseTo(point, randomPt.lat(), randomPt.lon());
        checkEqualsAndHashCode(
    private XContentParser geohash(double lat, double lon) throws IOException {
            parser.nextToken();
 * Modifications Copyright OpenSearch Contributors. See
        content.field("lat", lat).field("lon", lon);
        parser.nextToken();
        GeoPoint point = new GeoPoint(0, 0);
            parser2.nextToken();
    }
        assertPointsEqual(point, randomPt);
        XContentBuilder content = JsonXContent.contentBuilder();
        GeoPoint point = GeoUtils.parseGeoPoint(objectLatLon(randomPt.lat(), randomPt.lon()));
        assertPointsEqual(point.resetLon(0), point2.reset(0, 0));
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(parser));
        );
        assertCloseTo(point, randomPt.lat(), randomPt.lon());
        checkEqualsAndHashCode(
        assertCloseTo(point, randomPt.lat(), randomPt.lon());
            RandomGeoGenerator.randomPoint(random()),
            assertThat(e.getMessage(), is(ERR_MSG_INVALID_FIELDS));
            Exception e = expectThrows(OpenSearchParseException.class, () -> GeoUtils.parseGeoPoint(toObject(parser2), randomBoolean()));
 * license agreements. See the NOTICE file distributed with
        }
        return parser;
        XContentBuilder content = JsonXContent.contentBuilder();
            GeoPoint::new,
/*
            RandomGeoGenerator.randomPoint(random()),
        assertEquals(point1.hashCode(), point2.hashCode());
 * under the License.
            assertThat(e.getMessage(), is(ERR_MSG_INVALID_FIELDS));
        content.field("lat", 0).field("geohash", stringEncode(0d, 0d));
        content.endObject();
        XContentParser.Token token = parser.currentToken();
    public static Object toObject(XContentParser parser) throws IOException {
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(content));
 *     http://www.apache.org/licenses/LICENSE-2.0
        } else if (token == XContentParser.Token.START_ARRAY) {
    }
 * ownership. Elasticsearch licenses this file to you under
 * Unless required by applicable law or agreed to in writing,
        assertEquals(point.lon(), lon, TOLERANCE);
 * software distributed under the License is distributed on an
            return parser.list();
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(content));
