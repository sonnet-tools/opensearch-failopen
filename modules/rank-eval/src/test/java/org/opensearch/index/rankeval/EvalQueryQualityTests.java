                throw new IllegalStateException("The test should only allow four parameters mutated");
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
import java.util.ArrayList;
    }  
            ratedSearchHit.getSearchHit().shard(new SearchShardTarget("_na_", new ShardId("index", "_na_", 0), null, OriginalIndices.NONE));
import org.opensearch.common.xcontent.XContentType;
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
        }  
        EvalQueryQuality original = randomEvalQueryQuality();  
    protected NamedXContentRegistry xContentRegistry() {
            switch (metricDetail) {
            ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);  
    }
        new RankEvalModulePlugin().getNamedWriteables()
        return evalQueryQuality;  
        // have the same xContent representation
 */
        }
import org.opensearch.core.common.bytes.BytesReference;  
    public void testXContentParsing() throws IOException {
    }
            ratedHits.add(ratedSearchHit);  
            assertNull(parser.nextToken());  
        return new NamedXContentRegistry(new RankEvalModulePlugin().getNamedXContent());
                case 0:  
        String id = original.getId();  
        switch (randomIntBetween(0, 3)) {
                            randomDoubleBetween(0, 1, true),  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
            }
                    metricDetails = null;  
 *
import org.opensearch.core.index.shard.ShardId;
                case 2:  
            case 2:
                } else {
                }
        for (int i = 0; i < numberOfSearchHits; i++) {
/*
 * GitHub history for details.
        EvalQueryQuality parsedItem;  
            parsedItem = EvalQueryQuality.fromXContent(parser, queryId);  
        List<RatedSearchHit> ratedHits = new ArrayList<>(original.getHitsAndRatings());
    }  
                default:  
        // we cannot check equality of object here because some information (e.g. SearchHit#shard) cannot fully be  
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
    @Override  
 * software distributed under the License is distributed on an
        EvalQueryQuality testItem = randomEvalQueryQuality();
 * ownership. Elasticsearch licenses this file to you under  
/*  
        Predicate<String> pathsToExclude = path -> path.isEmpty() || path.endsWith("metric_details") || path.contains("hits");
                    evalQueryQuality.setMetricDetails(new MeanReciprocalRank.Detail(randomIntBetween(0, 1000)));
        assertNotSame(deserialized, original);
import java.util.function.Predicate;  
            default:  
        evalQueryQuality.addHitsAndRatings(ratedHits);
 * compatible open source license.
        checkEqualsAndHashCode(randomEvalQueryQuality(), EvalQueryQualityTests::copy, EvalQueryQualityTests::mutateTestItem);
import org.opensearch.action.OriginalIndices;
/*  
 * this file be licensed under the Apache-2.0 license or a
    @SuppressWarnings("resource")
        MetricDetail metricDetails = original.getMetricDetails();  
        XContentType xContentType = randomFrom(XContentType.values());
import org.opensearch.core.xcontent.XContentParser;
 * license agreements. See the NOTICE file distributed with
                            randomInt()
        assertEquals(deserialized.hashCode(), original.hashCode());  
        List<RatedSearchHit> ratedHits = new ArrayList<>();
        EvalQueryQuality evalQueryQuality = new EvalQueryQuality(id, metricScore);  
    public void testEqualsAndHash() throws IOException {
        return evalQueryQuality;
 * specific language governing permissions and limitations
            // we need to associate each hit with an index name otherwise rendering will not work
                    break;
    private static EvalQueryQuality copy(EvalQueryQuality original) throws IOException {  
    public static EvalQueryQuality randomEvalQueryQuality() {
    public void testSerialization() throws IOException {
                break;
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
 * Licensed to Elasticsearch under one or more contributor  
}
                id = id + "_";  
                    throw new IllegalArgumentException("illegal randomized value in test");
        // parsed back after going through the rest layer. That's why we only check that the original and the parsed item
 */  
        }
            RatedSearchHit ratedSearchHit = RatedSearchHitTests.randomRatedSearchHit();  
                            randomBoolean() ? randomDoubleBetween(0, 1, true) : 0,
        // - everything under `hits` (we test lenient SearchHit parsing elsewhere)  
 * this work for additional information regarding copyright
    }
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
import org.opensearch.test.OpenSearchTestCase;
 * KIND, either express or implied.  See the License for the
        return OpenSearchTestCase.copyWriteable(original, namedWritableRegistry, EvalQueryQuality::new);
    private static NamedWriteableRegistry namedWritableRegistry = new NamedWriteableRegistry(
                    break;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;  
                        )  
                    evalQueryQuality.setMetricDetails(
            case 3:  
            int metricDetail = randomIntBetween(0, 2);
 * SPDX-License-Identifier: Apache-2.0
                metricScore = metricScore + 0.1;  
                break;
                break;
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
                    );
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static EvalQueryQuality mutateTestItem(EvalQueryQuality original) {
        boolean humanReadable = randomBoolean();  
        assertEquals(deserialized, original);
                    metricDetails = new PrecisionAtK.Detail(1, 5);
 *  
package org.opensearch.index.rankeval;
    }
                        new DiscountedCumulativeGain.Detail(
        double metricScore = original.metricScore();
        evalQueryQuality.addHitsAndRatings(ratedHits);
                    break;
 * under the License.  
        evalQueryQuality.setMetricDetails(metricDetails);
public class EvalQueryQualityTests extends OpenSearchTestCase {
            case 0:
                ratedHits.add(RatedSearchHitTests.randomRatedSearchHit());
        // - the `metric_details` section, which can potentially contain different namedXContent names
                case 1:  
    );  
            ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
            String queryId = parser.currentName();
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, pathsToExclude, random());
 * not use this file except in compliance with the License.
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
        assertNotSame(testItem, parsedItem);
            ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.currentToken(), parser);
import org.opensearch.search.SearchShardTarget;  
        int numberOfSearchHits = randomInt(5);  
 * Unless required by applicable law or agreed to in writing,
 */  
    }  
        }
 *
        if (randomBoolean()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // skip inserting random fields for:  
                    evalQueryQuality.setMetricDetails(new PrecisionAtK.Detail(randomIntBetween(0, 1000), randomIntBetween(0, 1000)));
        // - the root object, since we expect a particular queryId there in this test
        assertToXContentEquivalent(originalBytes, toXContent(parsedItem, xContentType, humanReadable), xContentType);  
import java.util.List;
        EvalQueryQuality evalQueryQuality = new EvalQueryQuality(randomAlphaOfLength(10), randomDoubleBetween(0.0, 1.0, true));
                break;
 * Modifications Copyright OpenSearch Contributors. See
                if (metricDetails == null) {  
 * the Apache License, Version 2.0 (the "License"); you may
        EvalQueryQuality deserialized = copy(original);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
            case 1:
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.ToXContent;
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
