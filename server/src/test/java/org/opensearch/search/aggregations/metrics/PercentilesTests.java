        ex = expectThrows(IllegalArgumentException.class, () -> builder.percentiles(new double[0]));
 *
        XContentParseException e = expectThrows(
        assertEquals("percent must be in [0,100], got [-0.4]: [testAgg]", ex.getMessage());  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentParseException;
 * Unless required by applicable law or agreed to in writing,
            + "           \"field\": \"load_time\",\n"  
        randomFieldOrScript(factory, field);
 */  
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
}
        ex = expectThrows(IllegalArgumentException.class, () -> builder.percentiles(104));
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.containsString;
            XContentParseException.class,
            factory.keyed(randomBoolean());
        if (randomBoolean()) {
            () -> PercentilesAggregationBuilder.parse("myPercentiles", parser)  
package org.opensearch.search.aggregations.metrics;
import org.opensearch.common.xcontent.json.JsonXContent;
            for (int i = 0; i < percentsSize; i++) {  
 */  
        PercentilesAggregationBuilder builder = new PercentilesAggregationBuilder("testAgg");
    }
/*  
        );
            factory.missing("MISSING");
/*  
            factory.percentiles(percents);  
            factory.numberOfSignificantValueDigits(randomIntBetween(0, 5));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        String field = randomNumericField();
            + "               \"number_of_significant_value_digits\": 3\n"  
/*
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentParser;  
            factory.compression(randomIntBetween(1, 50000));
 * The OpenSearch Contributors require contributions made to  
        assertEquals("percent must be in [0,100], got [104.0]: [testAgg]", ex.getMessage());  
public class PercentilesTests extends BaseAggregationTestCase<PercentilesAggregationBuilder> {
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> builder.percentiles(-0.4));
            + "       \"percentiles\": {\n"
        XContentParser parser = createParser(JsonXContent.jsonXContent, illegalAgg);
        PercentilesAggregationBuilder factory = new PercentilesAggregationBuilder(randomAlphaOfLengthBetween(1, 20));
        assertEquals("[percents] must not be empty: [testAgg]", ex.getMessage());  
            + "           }\n"
 * Modifications Copyright OpenSearch Contributors. See
        if (randomBoolean()) {  
            + "}";  
 * under the License.  
 */
 * KIND, either express or implied.  See the License for the
        PercentilesAggregationBuilder builder = new PercentilesAggregationBuilder("testAgg");
        }  
        return factory;  
    protected PercentilesAggregationBuilder createTestAggregatorBuilder() {
        }
    public void testOutOfRangePercentilesThrows() throws IOException {  
            double[] percents = new double[percentsSize];
 *  
            factory.format("###.00");
 * this file be licensed under the Apache-2.0 license or a
        assertThat(e.getMessage(), containsString("[percentiles] failed to parse field [hdr]"));
        if (randomBoolean()) {  
    }
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> builder.percentiles(null));
    public void testExceptionMultipleMethods() throws IOException {  
        }
 * this work for additional information regarding copyright
        if (randomBoolean()) {  
        assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());  
 *
        final String illegalAgg = "{\n"
        }
        assertEquals("[percents] must not be null: [testAgg]", ex.getMessage());  
 *    http://www.apache.org/licenses/LICENSE-2.0
            + "           },\n"
            + "   }\n"
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
    @Override  
        } else if (randomBoolean()) {
            int percentsSize = randomIntBetween(1, 20);
            }
            + "           \"percents\": [99],\n"
import org.opensearch.search.aggregations.BaseAggregationTestCase;
            + "           \"hdr\": {\n"
    public void testNullOrEmptyPercentilesThrows() throws IOException {  
 * compatible open source license.
        }
        assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        if (randomBoolean()) {  
            + "           \"tdigest\": {\n"
                percents[i] = randomDouble() * 100;
import java.io.IOException;  
 * Licensed to Elasticsearch under one or more contributor  
    }  
            + "               \"compression\": 200\n"  
