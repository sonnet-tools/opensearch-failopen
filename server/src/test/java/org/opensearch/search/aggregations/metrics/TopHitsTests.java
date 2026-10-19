                } else {
        }
    protected final TopHitsAggregationBuilder createTestAggregatorBuilder() {
        }
        if (randomBoolean()) {
                List<String> fields = new ArrayList<>(fieldsSize);
                }
                    case 5:
 * under the License.
            + "      \"aggs\": {\n"
        Exception e = expectThrows(AggregationInitializationException.class, () -> AggregatorFactories.parseAggregators(parser));
 */
            + "          \"aggs\": {\n"
                    fetchSourceContext = new FetchSourceContext(true, includes, excludes);
 * not use this file except in compliance with the License.
                        factory.sort(SortBuilders.scoreSort().order(randomFrom(SortOrder.values())));
            }
 * the Apache License, Version 2.0 (the "License"); you may
                if (randomBoolean()) {
            factory.explain(randomBoolean());
            + "        \"field\": \"tags\"\n"
        if (randomBoolean()) {
        }
            case 3:
 *
                factory.storedFields(fields);
            + "              }\n"
            factory.from(randomIntBetween(0, 10000));
                    case 4:
import org.opensearch.search.sort.SortOrder;
                    break;
                        factory.sort(SortBuilders.fieldSort(randomAlphaOfLengthBetween(5, 20)).order(randomFrom(SortOrder.values())));
 * this work for additional information regarding copyright
            + "                \"field\": \"age\"\n"
                    fetchSourceContext = new FetchSourceContext(
                        break;
        TopHitsAggregationBuilder factory = new TopHitsAggregationBuilder(randomAlphaOfLengthBetween(3, 10));
                for (int i = 0; i < fieldsSize; i++) {
        }
            // parent test shuffles xContent, we need to make sure highlight fields are ordered
        if (randomBoolean()) {
                        factory.sort(randomAlphaOfLengthBetween(5, 20), randomFrom(SortOrder.values()));
        }
                    throw new IllegalStateException();
                        );
                default:
            + "            \"max\": {\n"
import org.opensearch.search.sort.ScriptSortBuilder.ScriptSortType;
                    break;
            for (int i = 0; i < scriptFieldsSize; i++) {
                            SortBuilders.geoDistanceSort(randomAlphaOfLengthBetween(5, 20), AbstractQueryTestCase.randomGeohash(1, 12))
 * Licensed to Elasticsearch under one or more contributor
}
            + "          }\n"
                    fields.add(randomAlphaOfLengthBetween(5, 50));
                case 1:
 * license agreements. See the NOTICE file distributed with
        }
            String[] includes = new String[randomIntBetween(0, 20)];
            factory.version(randomBoolean());
                    factory.scriptField(randomAlphaOfLengthBetween(5, 50), mockScript("foo"), randomBoolean());
            + "      },\n"
                factory.storedField("_none_");
import java.util.Collections;
        if (randomBoolean()) {
                factory.docValueField(randomAlphaOfLengthBetween(5, 50));
import org.opensearch.search.aggregations.BaseAggregationTestCase;
 *
            + "}";
                throw new IllegalStateException();
/*
import org.opensearch.search.aggregations.AggregatorFactories;
                switch (branch) {
            factory.seqNoAndPrimaryTerm(randomBoolean());
    public void testFailWithSubAgg() throws Exception {
package org.opensearch.search.aggregations.metrics;
            int scriptFieldsSize = randomInt(25);
        assertSame(XContentParser.Token.START_OBJECT, parser.nextToken());
        }
            + "      \"terms\": {\n"
                }
public class TopHitsTests extends BaseAggregationTestCase<TopHitsAggregationBuilder> {
                break;
        if (randomBoolean()) {
                    fetchSourceContext = new FetchSourceContext(true, includes, null);
            + "        \"top_tags_hits\": {\n"
            FetchSourceContext fetchSourceContext;
        }
            for (int i = 0; i < fetchFieldsSize; i++) {
            int numSorts = randomIntBetween(1, 5);
        }
                    break;
        return factory;
import java.util.ArrayList;
        assertThat(e.toString(), containsString("Aggregator [top_tags_hits] of type [top_hits] cannot accept sub-aggregations"));
            case 0:
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
            int fetchFieldsSize = randomInt(25);
import org.opensearch.common.xcontent.json.JsonXContent;
            switch (branch) {
/*
 * Modifications Copyright OpenSearch Contributors. See
                        );
                    );
                            SortBuilders.scriptSort(mockScript("foo"), ScriptSortType.NUMBER).order(randomFrom(SortOrder.values()))
 */
        if (randomBoolean()) {
                    fetchSourceContext = randomBoolean() ? FetchSourceContext.FETCH_SOURCE : FetchSourceContext.DO_NOT_FETCH_SOURCE;
            factory.trackScores(randomBoolean());
        if (randomBoolean()) {
            }
            + "        }\n"
 * GitHub history for details.
        }
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.containsString;
                int branch = randomInt(5);
                        new String[] { randomAlphaOfLengthBetween(5, 20) }
                excludes[i] = randomAlphaOfLengthBetween(5, 20);
            factory.size(randomIntBetween(0, 10000));
            int branch = randomInt(5);
            for (int i = 0; i < fieldDataFieldsSize; i++) {
                        break;
            factory.fetchSource(fetchSourceContext);
            + "          \"top_hits\": {},\n"
                }
            case 1:
 */
import org.opensearch.search.fetch.subphase.FetchSourceContext;
 * specific language governing permissions and limitations
            + "              \"max\": {\n"
            }
                case 2:
            + "    }\n"
        if (randomBoolean()) {
                case 3:
import org.opensearch.core.xcontent.XContentParser;
        if (randomBoolean()) {
import org.opensearch.search.sort.SortBuilders;
        }
                    break;
                        break;
            + "      }\n"
            for (int i = 0; i < numSorts; i++) {
    @Override
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
                case 0:
                break;
    }
                        true,
        if (randomBoolean()) {
 * The OpenSearch Contributors require contributions made to
                        break;
            for (int i = 0; i < includes.length; i++) {
                    break;
import org.opensearch.search.aggregations.AggregationInitializationException;
                    fetchSourceContext = new FetchSourceContext(true, includes, excludes);
        }
import java.util.List;
                        factory.sort(
            String[] excludes = new String[randomIntBetween(0, 20)];
                includes[i] = randomAlphaOfLengthBetween(5, 20);
                        break;
                case 4:
 * Unless required by applicable law or agreed to in writing,
                                .order(randomFrom(SortOrder.values()))
 * this file be licensed under the Apache-2.0 license or a
            }
            for (int i = 0; i < excludes.length; i++) {
        if (randomBoolean()) {
                case 5:
            int fieldDataFieldsSize = randomInt(25);
                factory.storedFields(Collections.emptyList());
/*
                        factory.sort(randomAlphaOfLengthBetween(5, 20));
    }
                    case 1:
            }
            + "    \"top-tags\": {\n"
            + "            }\n"
                        break;
            }
                    break;
                    factory.scriptField(randomAlphaOfLengthBetween(5, 50), mockScript("foo"));
        switch (randomInt(3)) {
        if (randomBoolean()) {
            case 2:
 * compatible open source license.
                    case 0:
            }
                        factory.sort(
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilderTests;
            default:
                    fetchSourceContext = new FetchSourceContext(true, new String[] { randomAlphaOfLengthBetween(5, 20) }, null);
 *
 * ownership. Elasticsearch licenses this file to you under
        String source = "{\n"
                break;
                int fieldsSize = randomInt(25);
        }
                break;
            factory.highlighter(HighlightBuilderTests.randomHighlighterBuilder().useExplicitFieldOrder(true));
                    case 3:
        XContentParser parser = createParser(JsonXContent.jsonXContent, source);
                    case 2:
                        new String[] { randomAlphaOfLengthBetween(5, 20) },
import org.opensearch.test.AbstractQueryTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                factory.fetchField(randomAlphaOfLengthBetween(5, 50));
