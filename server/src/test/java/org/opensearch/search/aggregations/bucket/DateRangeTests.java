                ? Double.POSITIVE_INFINITY
                    ? randomIntBetween(Integer.MIN_VALUE, Integer.MAX_VALUE)
import org.opensearch.search.aggregations.BaseAggregationTestCase;
                factory.addRange(new Range(key, from, to));
            double to = randomBoolean()
 * under the License.  
            + "\"ranges\" : [\n"
    }  
            XContentParseException.class,
 *  
                String toAsStr = Double.isInfinite(to) ? null : String.valueOf(to);
import org.opensearch.core.xcontent.XContentParser;  
        if (randomBoolean()) {  
 * not use this file except in compliance with the License.
        XContentParseException ex = expectThrows(  
}
 * KIND, either express or implied.  See the License for the
                key = randomAlphaOfLengthBetween(1, 20);
import static org.hamcrest.Matchers.containsString;
/*  
        final String rangeAggregation = "{\n"
            + "]\n"  
        assertThat(ex.getCause(), notNullValue());
        if (randomBoolean()) {  
            + "}";
        }
 */  
 * You may obtain a copy of the License at  
            + "    { \"from\" : \"2017-01-01\", \"to\" : \"2017-01-02\", \"badField\" : \"abcd\" }\n"
 *    http://www.apache.org/licenses/LICENSE-2.0
            } else {
import org.opensearch.search.aggregations.bucket.range.DateRangeAggregationBuilder;
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.bucket.range.RangeAggregator.Range;  
        factory.field(INT_FIELD_NAME);
        }
 * software distributed under the License is distributed on an
        assertThat(ex.getCause().getMessage(), containsString("badField"));
    @Override  
                : (Double.isInfinite(from)  
public class DateRangeTests extends BaseAggregationTestCase<DateRangeAggregationBuilder> {
        }
        DateRangeAggregationBuilder factory = new DateRangeAggregationBuilder(randomAlphaOfLengthBetween(3, 10));  
        return factory;  
/*  
import java.io.IOException;
                    : randomIntBetween((int) from, Integer.MAX_VALUE));
 * SPDX-License-Identifier: Apache-2.0
            () -> DateRangeAggregationBuilder.PARSER.parse(parser, "aggregationName")
    public void testParsingRangeStrict() throws IOException {  
            factory.keyed(randomBoolean());
    }
            double from = randomBoolean() ? Double.NEGATIVE_INFINITY : randomIntBetween(Integer.MIN_VALUE, Integer.MAX_VALUE - 1000);  
import static org.hamcrest.Matchers.notNullValue;
/*
        if (randomBoolean()) {  
import org.opensearch.common.xcontent.json.JsonXContent;
        }
package org.opensearch.search.aggregations.bucket;
            if (randomBoolean()) {  
 */
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
            }  
            factory.missing(randomIntBetween(0, 10));
            String key = null;
                factory.addRange(new Range(key, fromAsStr, toAsStr));
 * ownership. Elasticsearch licenses this file to you under  
        for (int i = 0; i < numRanges; i++) {
 *
            if (randomBoolean()) {  
 */  
        );  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                String fromAsStr = Double.isInfinite(from) ? null : String.valueOf(from);  
            + "\"format\" : \"yyyy-MM-dd\",\n"  
 * The OpenSearch Contributors require contributions made to  
            + "\"field\" : \"date\",\n"
            factory.format("###.##");
 * Licensed to Elasticsearch under one or more contributor  
        if (randomBoolean()) {  
        int numRanges = randomIntBetween(1, 10);
 *
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
            factory.timeZone(randomZone());
import org.opensearch.core.xcontent.XContentParseException;
        XContentParser parser = createParser(JsonXContent.jsonXContent, rangeAggregation);
            }
 * GitHub history for details.
    protected DateRangeAggregationBuilder createTestAggregatorBuilder() {
 * license agreements. See the NOTICE file distributed with
