    public void testParsingNull() throws IOException {
            + "\"field\" : \"price\",\n"  
/*
                : (Double.isInfinite(from)  
            } else {
            + "}";
 *
import org.opensearch.core.xcontent.XContentParseException;
                    : randomIntBetween((int) from, Integer.MAX_VALUE));
 * Licensed to Elasticsearch under one or more contributor  
        }
 */  
            + "    { \"from\" : null, \"to\" : null }\n"
                factory.addRange(new Range(key, from, to));
        XContentParser parser = createParser(JsonXContent.jsonXContent, rangeAggregation);
    }
import org.opensearch.core.xcontent.XContentParser;  
 * You may obtain a copy of the License at  
/*  
        int numRanges = randomIntBetween(1, 10);
 *  
            double from = randomBoolean() ? Double.NEGATIVE_INFINITY : randomIntBetween(Integer.MIN_VALUE, Integer.MAX_VALUE - 1000);  
    @Override  
 * compatible open source license.
        assertEquals(1, aggregationBuilder.ranges().size());
        }
        RangeAggregationBuilder aggregationBuilder = RangeAggregationBuilder.PARSER.parse(parser, "aggregationName");  
        }
 */
import java.io.IOException;
    }
            factory.keyed(randomBoolean());
            }  
        for (int i = 0; i < numRanges; i++) {
     */  
        assertEquals(Double.NEGATIVE_INFINITY, aggregationBuilder.ranges().get(0).getFrom(), 0.0);
            if (randomBoolean()) {  
package org.opensearch.search.aggregations.bucket;
import org.opensearch.search.aggregations.BaseAggregationTestCase;
                String fromAsStr = Double.isInfinite(from) ? null : String.valueOf(from);  
        final String rangeAggregation = "{\n"
        assertThat(ex.getCause().getMessage(), containsString("badField"));
 * this work for additional information regarding copyright
                ? Double.POSITIVE_INFINITY
     * We never render "null" values to xContent, but we should test that we can parse them (and they return correct defaults)
            + "]\n"  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
            + "    { \"from\" : 50, \"to\" : 100, \"badField\" : \"abcd\" }\n"
    public void testParsingRangeStrict() throws IOException {  
 * KIND, either express or implied.  See the License for the
    protected RangeAggregationBuilder createTestAggregatorBuilder() {
            }
 *
        RangeAggregationBuilder factory = new RangeAggregationBuilder(randomAlphaOfLengthBetween(3, 10));  
            factory.format("###.##");
    }
            () -> RangeAggregationBuilder.PARSER.parse(parser, "aggregationName")
 * The OpenSearch Contributors require contributions made to  
        assertThat(ex.getCause(), notNullValue());  
 */  
 * specific language governing permissions and limitations
        if (randomBoolean()) {  
public class RangeTests extends BaseAggregationTestCase<RangeAggregationBuilder> {
 * the Apache License, Version 2.0 (the "License"); you may
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (randomBoolean()) {  
                    ? randomIntBetween(Integer.MIN_VALUE, Integer.MAX_VALUE)
            + "]\n"
        final String rangeAggregation = "{\n"
 * GitHub history for details.
 * software distributed under the License is distributed on an
            XContentParseException.class,  
            factory.missing(randomIntBetween(0, 10));
 * Unless required by applicable law or agreed to in writing,
}
                factory.addRange(new Range(key, fromAsStr, toAsStr));
        XContentParser parser = createParser(JsonXContent.jsonXContent, rangeAggregation);
/*  
        return factory;  
            + "}";  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
            if (randomBoolean()) {  
            + "\"ranges\" : [\n"  
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(Double.POSITIVE_INFINITY, aggregationBuilder.ranges().get(0).getTo(), 0.0);  
        factory.field(INT_FIELD_NAME);
        if (randomBoolean()) {  
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.common.xcontent.json.JsonXContent;
            double to = randomBoolean()
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
            String key = null;
import static org.hamcrest.Matchers.containsString;
                String toAsStr = Double.isInfinite(to) ? null : String.valueOf(to);
        XContentParseException ex = expectThrows(
        }
        );
            + "\"ranges\" : [\n"
                key = randomAlphaOfLengthBetween(1, 20);
            + "\"field\" : \"price\",\n"
import org.opensearch.search.aggregations.bucket.range.RangeAggregator.Range;  
