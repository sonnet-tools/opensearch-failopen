                int fieldsSize = randomInt(25);
 * You may obtain a copy of the License at  
            factory.trackScores(randomBoolean());
        if (randomBoolean()) {
import org.opensearch.search.sort.SortOrder;
        switch (randomInt(3)) {  
                switch (branch) {
                    case 3:
                break;
        return factory;
import org.opensearch.search.aggregations.BaseAggregationTestCase;
            + "}";  
            for (int i = 0; i < fieldDataFieldsSize; i++) {
                        new String[] { randomAlphaOfLengthBetween(5, 20) },  
 */  
    @Override  
        if (randomBoolean()) {  
                    fetchSourceContext = new FetchSourceContext(true, new String[] { randomAlphaOfLengthBetween(5, 20) }, null);
 * not use this file except in compliance with the License.
            + "      \"terms\": {\n"
            int numSorts = randomIntBetween(1, 5);
        if (randomBoolean()) {  
        if (randomBoolean()) {  
import java.util.List;  
                    fetchSourceContext = randomBoolean() ? FetchSourceContext.FETCH_SOURCE : FetchSourceContext.DO_NOT_FETCH_SOURCE;
 * compatible open source license.
                factory.storedField("_none_");
                    break;
 *
 * The OpenSearch Contributors require contributions made to  
        String source = "{\n"  
 * software distributed under the License is distributed on an
                case 3:
                int branch = randomInt(5);  
    public void testFailWithSubAgg() throws Exception {
                    break;  
            }  
                    factory.scriptField(randomAlphaOfLengthBetween(5, 50), mockScript("foo"), randomBoolean());  
 *  
                for (int i = 0; i < fieldsSize; i++) {  
                break;
                        new String[] { randomAlphaOfLengthBetween(5, 20) }
        if (randomBoolean()) {  
        }  
            + "    }\n"
                    break;  
                        factory.sort(SortBuilders.scoreSort().order(randomFrom(SortOrder.values())));  
            int fieldDataFieldsSize = randomInt(25);  
 * Licensed to Elasticsearch under one or more contributor  
        if (randomBoolean()) {  
                throw new IllegalStateException();  
 */  
                    throw new IllegalStateException();
                    );
                case 4:
                        break;
            case 2:  
                case 5:
                default:
 */
            case 0:
    }
                        );  
                excludes[i] = randomAlphaOfLengthBetween(5, 20);  
            String[] excludes = new String[randomIntBetween(0, 20)];
                        factory.sort(  
        Exception e = expectThrows(AggregationInitializationException.class, () -> AggregatorFactories.parseAggregators(parser));  
            factory.version(randomBoolean());
 * this work for additional information regarding copyright
                includes[i] = randomAlphaOfLengthBetween(5, 20);
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilderTests;
        }
            factory.seqNoAndPrimaryTerm(randomBoolean());
        if (randomBoolean()) {  
                    fetchSourceContext = new FetchSourceContext(true, includes, excludes);
package org.opensearch.search.aggregations.metrics;
import org.opensearch.common.xcontent.json.JsonXContent;
            for (int i = 0; i < numSorts; i++) {
        }
            + "            \"max\": {\n"  
                    case 2:
                }
            for (int i = 0; i < scriptFieldsSize; i++) {
            + "          }\n"
 *    http://www.apache.org/licenses/LICENSE-2.0
                factory.docValueField(randomAlphaOfLengthBetween(5, 50));
/*
 * specific language governing permissions and limitations
/*  
                factory.fetchField(randomAlphaOfLengthBetween(5, 50));
            + "        \"field\": \"tags\"\n"  
                    case 0:
                case 0:  
        }
                    fetchSourceContext = new FetchSourceContext(
            for (int i = 0; i < fetchFieldsSize; i++) {
 * Modifications Copyright OpenSearch Contributors. See
        if (randomBoolean()) {  
            + "        }\n"  
            for (int i = 0; i < includes.length; i++) {
        if (randomBoolean()) {
            }  
            + "      \"aggs\": {\n"
                    break;  
        if (randomBoolean()) {
                }  
            }
import org.opensearch.search.sort.ScriptSortBuilder.ScriptSortType;
                        );
    }  
            + "      }\n"
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.AbstractQueryTestCase;
                    factory.scriptField(randomAlphaOfLengthBetween(5, 50), mockScript("foo"));
        assertThat(e.toString(), containsString("Aggregator [top_tags_hits] of type [top_hits] cannot accept sub-aggregations"));
 * GitHub history for details.
            int scriptFieldsSize = randomInt(25);  
            }  
        }
            int fetchFieldsSize = randomInt(25);  
                            SortBuilders.scriptSort(mockScript("foo"), ScriptSortType.NUMBER).order(randomFrom(SortOrder.values()))
        }
                if (randomBoolean()) {
                        factory.sort(SortBuilders.fieldSort(randomAlphaOfLengthBetween(5, 20)).order(randomFrom(SortOrder.values())));  
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
                        break;
/*  
                case 2:  
        }
 *
        }
                        break;  
        if (randomBoolean()) {  
}
            default:
        }
                factory.storedFields(Collections.emptyList());
 * this file be licensed under the Apache-2.0 license or a
            // parent test shuffles xContent, we need to make sure highlight fields are ordered
 * the Apache License, Version 2.0 (the "License"); you may
    protected final TopHitsAggregationBuilder createTestAggregatorBuilder() {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
            + "              }\n"  
        }
                break;
import org.opensearch.core.xcontent.XContentParser;
            case 3:  
            factory.from(randomIntBetween(0, 10000));
                    fetchSourceContext = new FetchSourceContext(true, includes, excludes);
            + "              \"max\": {\n"
                            SortBuilders.geoDistanceSort(randomAlphaOfLengthBetween(5, 20), AbstractQueryTestCase.randomGeohash(1, 12))
                        break;
import java.util.ArrayList;
            for (int i = 0; i < excludes.length; i++) {
            switch (branch) {
            int branch = randomInt(5);
                case 1:  
            factory.highlighter(HighlightBuilderTests.randomHighlighterBuilder().useExplicitFieldOrder(true));  
                    fields.add(randomAlphaOfLengthBetween(5, 50));
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
                        true,
                        factory.sort(randomAlphaOfLengthBetween(5, 20));
                }
            + "    \"top-tags\": {\n"
 * KIND, either express or implied.  See the License for the
                break;
            factory.size(randomIntBetween(0, 10000));
public class TopHitsTests extends BaseAggregationTestCase<TopHitsAggregationBuilder> {
 * Unless required by applicable law or agreed to in writing,
            + "                \"field\": \"age\"\n"
        }
        assertSame(XContentParser.Token.START_OBJECT, parser.nextToken());
            + "          \"aggs\": {\n"
            + "        \"top_tags_hits\": {\n"  
            case 1:  
                                .order(randomFrom(SortOrder.values()))
                        factory.sort(randomAlphaOfLengthBetween(5, 20), randomFrom(SortOrder.values()));
import org.opensearch.search.aggregations.AggregationInitializationException;  
                        break;  
        }
            factory.fetchSource(fetchSourceContext);
                } else {
                    break;
        if (randomBoolean()) {
import org.opensearch.search.aggregations.AggregatorFactories;
import java.util.Collections;
import org.opensearch.search.sort.SortBuilders;  
                        factory.sort(  
        XContentParser parser = createParser(JsonXContent.jsonXContent, source);
            + "            }\n"
                    break;  
            }  
                    case 5:
                factory.storedFields(fields);  
            }
            }
            + "      },\n"
            String[] includes = new String[randomIntBetween(0, 20)];  
        TopHitsAggregationBuilder factory = new TopHitsAggregationBuilder(randomAlphaOfLengthBetween(3, 10));
                    fetchSourceContext = new FetchSourceContext(true, includes, null);
            FetchSourceContext fetchSourceContext;
            + "          \"top_hits\": {},\n"
import static org.hamcrest.Matchers.containsString;
                        break;  
                    case 1:
            factory.explain(randomBoolean());
                    case 4:
                List<String> fields = new ArrayList<>(fieldsSize);
