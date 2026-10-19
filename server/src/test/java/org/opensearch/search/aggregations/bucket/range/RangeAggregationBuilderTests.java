        assertThat(parser.currentName(), equalTo("range"));
import org.opensearch.common.xcontent.json.JsonXContent;
        assertThat(builder.getName(), equalTo("test"));
        int rangeCount = between(1, 10);
 * the Apache License, Version 2.0 (the "License"); you may
        }
                break;
 */  
    @Override
        RangeAggregationBuilder parsed = RangeAggregationBuilder.PARSER.apply(parser, name);  
                case 0:
                keyed = !keyed;  
            }
        assertThat(parser.nextToken(), equalTo(XContentParser.Token.FIELD_NAME));
                    r += randomDouble(); // less than 1
 * You may obtain a copy of the License at  
public class RangeAggregationBuilderTests extends AbstractSerializingTestCase<RangeAggregationBuilder> {  
import static org.hamcrest.Matchers.equalTo;
    protected RangeAggregationBuilder doParseInstance(XContentParser parser) throws IOException {
        return mutant;
                break;
                fail();  
        assertThat(builder.fieldName(), equalTo("f"));
        boolean keyed = builder.keyed();
            createParser(JsonXContent.jsonXContent, "{\"test\":{\"range\":{\"field\":\"f\",\"ranges\":[{\"key\":1,\"to\":0}]}}}")  
 * this work for additional information regarding copyright
import java.util.List;
            case 1:
                    double to = r;
        for (int i = 0; i < rangeCount; i++) {  
import java.io.IOException;  
 *  
    }
    @Override
 * Modifications Copyright OpenSearch Contributors. See
            r += randomDouble(); // less than 1
                double from = ranges.get(ranges.size() - 1).from;
 * GitHub history for details.
        assertThat(parser.nextToken(), equalTo(XContentParser.Token.START_OBJECT));  
    }
                case 2:
                    break;
            case 2:
        String name = parser.currentName();
    protected RangeAggregationBuilder createTestInstance() {  
        assertThat(builder.ranges, equalTo(List.of(new RangeAggregator.Range("1", null, 0d))));
        assertThat(parser.nextToken(), equalTo(XContentParser.Token.FIELD_NAME));
        assertThat(parser.nextToken(), equalTo(XContentParser.Token.START_OBJECT));  
                    fail();  
        return parsed;  
        RangeAggregationBuilder builder = doParseInstance(
                    double from = r;  
                    builder.addUnboundedTo(randomAlphaOfLength(2), r);  
            case 0:
                    builder.addRange(randomAlphaOfLength(2), from, to);  
 *
}
 */  
import org.opensearch.test.AbstractSerializingTestCase;
 * compatible open source license.
 */
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
    }  
/*  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        String field = builder.field();
        assertThat(parser.nextToken(), equalTo(XContentParser.Token.END_OBJECT));
package org.opensearch.search.aggregations.bucket.range;
                name += randomAlphaOfLength(1);  
        assertThat(builder.field(), equalTo("f"));  
                break;
        ranges.stream().forEach(mutant::addRange);  
    }
import java.util.ArrayList;
        assertThat(parser.nextToken(), equalTo(XContentParser.Token.END_OBJECT));
                    break;
        return builder;
        builder.keyed(randomBoolean());
                case 1:
 * under the License.  
        String name = builder.getName();  
    @Override  
                ranges.add(new RangeAggregator.Range(randomAlphaOfLength(2), from, to));  
import org.opensearch.core.common.io.stream.Writeable.Reader;
        RangeAggregationBuilder mutant = new RangeAggregationBuilder(name).keyed(keyed).field(field);
        RangeAggregationBuilder builder = new RangeAggregationBuilder(randomAlphaOfLength(5));
        double r = 0;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
            case 3:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                default:
        }  
        return RangeAggregationBuilder::new;
                ranges = new ArrayList<>(ranges);  
                double to = from + randomDouble();
        switch (between(0, 3)) {
import org.opensearch.core.xcontent.XContentParser;  
        builder.field(randomAlphaOfLength(4));  
            switch (between(0, 2)) {
                break;
                    break;
/*
        );
 *
    }  
    protected RangeAggregationBuilder mutateInstance(RangeAggregationBuilder builder) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
                field += randomAlphaOfLength(1);  
    @Override
/*  
        List<RangeAggregator.Range> ranges = builder.ranges();  
            default:
 * software distributed under the License is distributed on an
    public void testNumericKeys() throws IOException {
    protected Reader<RangeAggregationBuilder> instanceReader() {
                    builder.addUnboundedFrom(randomAlphaOfLength(2), r);  
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
