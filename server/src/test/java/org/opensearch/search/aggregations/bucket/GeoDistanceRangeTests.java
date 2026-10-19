        }
        if (randomBoolean()) {  
            "aggregationName",
            + "}";
import org.opensearch.core.xcontent.XContentParser;  
 * You may obtain a copy of the License at  
            + "\"field\" : \"location\",\n"
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.bucket.range.GeoDistanceAggregationBuilder;
import org.opensearch.core.xcontent.XContentParseException;
        GeoPoint origin = RandomShapeGenerator.randomPoint(random());
        );
                ? Double.POSITIVE_INFINITY
        }
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
            if (randomBoolean()) {
import org.opensearch.common.unit.DistanceUnit;  
        if (randomBoolean()) {  
import java.io.IOException;  
     * We never render "null" values to xContent, but we should test that we can parse them (and they return correct defaults)
            factory.addRange(new Range(key, from, to));  
            double from = randomBoolean() ? 0 : randomIntBetween(0, Integer.MAX_VALUE - 1000);
import org.opensearch.common.geo.GeoDistance;
        for (int i = 0; i < numRanges; i++) {  
import org.opensearch.search.aggregations.BaseAggregationTestCase;
            + "\"field\" : \"location\",\n"
        }
            + "\"ranges\" : [\n"
        XContentParser parser = createParser(JsonXContent.jsonXContent, rangeAggregation);  
            + "}";
 * this work for additional information regarding copyright
    }
import org.opensearch.test.geo.RandomShapeGenerator;
}  
    /**  
            + "\"origin\" : \"52.3760, 4.894\",\n"  
            + "\"unit\" : \"m\",\n"
            + "\"origin\" : \"52.3760, 4.894\",\n"  
import org.opensearch.common.geo.GeoPoint;
 */
        }
import org.opensearch.search.aggregations.bucket.range.GeoDistanceAggregationBuilder.Range;  
    @Override
 */  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 *
        assertEquals(1, aggregationBuilder.range().size());
            + "\"unit\" : \"m\",\n"
package org.opensearch.search.aggregations.bucket;
 * Licensed to Elasticsearch under one or more contributor  
            double to = randomBoolean()  
            + "    { \"from\" : null, \"to\" : null }\n"  
import static org.hamcrest.Matchers.notNullValue;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.containsString;
        if (randomBoolean()) {  
            parser  
/*
     */
        assertEquals(0.0, aggregationBuilder.range().get(0).getFrom(), 0.0);  
 * not use this file except in compliance with the License.
                key = randomAlphaOfLengthBetween(1, 20);  
        if (randomBoolean()) {  
        XContentParseException ex = expectThrows(
            XContentParseException.class,
            factory.keyed(randomBoolean());
        );
        assertEquals(Double.POSITIVE_INFINITY, aggregationBuilder.range().get(0).getTo(), 0.0);
 * license agreements. See the NOTICE file distributed with
        GeoDistanceAggregationBuilder factory = new GeoDistanceAggregationBuilder(randomAlphaOfLengthBetween(3, 10), origin);
        return factory;  
 * The OpenSearch Contributors require contributions made to  
            + "]\n"
        int numRanges = randomIntBetween(1, 10);  
            }
public class GeoDistanceRangeTests extends BaseAggregationTestCase<GeoDistanceAggregationBuilder> {
 */  
            () -> GeoDistanceAggregationBuilder.parse("aggregationName", parser)  
        assertThat(ex.getCause(), notNullValue());
 * specific language governing permissions and limitations
 *  
                : (Double.compare(from, 0) == 0 ? randomIntBetween(0, Integer.MAX_VALUE) : randomIntBetween((int) from, Integer.MAX_VALUE));
            + "\"ranges\" : [\n"
 * software distributed under the License is distributed on an
 * compatible open source license.
            factory.missing("0, 0");
        XContentParser parser = createParser(JsonXContent.jsonXContent, rangeAggregation);  
        assertThat(ex.getCause().getMessage(), containsString("badField"));  
        GeoDistanceAggregationBuilder aggregationBuilder = (GeoDistanceAggregationBuilder) GeoDistanceAggregationBuilder.parse(
            + "    { \"from\" : 10000, \"to\" : 20000, \"badField\" : \"abcd\" }\n"  
            factory.unit(randomFrom(DistanceUnit.values()));
 * Modifications Copyright OpenSearch Contributors. See
    protected GeoDistanceAggregationBuilder createTestAggregatorBuilder() {
import org.opensearch.common.xcontent.json.JsonXContent;
        }
        final String rangeAggregation = "{\n"
 *
    public void testParsingNull() throws IOException {  
        factory.field(randomAlphaOfLengthBetween(1, 20));
/*  
    }
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
    public void testParsingRangeStrict() throws IOException {  
            String key = null;
            factory.distanceType(randomFrom(GeoDistance.values()));
        final String rangeAggregation = "{\n"
 * SPDX-License-Identifier: Apache-2.0
            + "]\n"
