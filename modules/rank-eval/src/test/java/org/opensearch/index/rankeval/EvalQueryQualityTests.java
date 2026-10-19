            ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);
import org.opensearch.core.common.bytes.BytesReference;
        assertToXContentEquivalent(originalBytes, toXContent(parsedItem, xContentType, humanReadable), xContentType);
                metricScore = metricScore + 0.1;
 *    http://www.apache.org/licenses/LICENSE-2.0
                break;
        return evalQueryQuality;
                            randomDoubleBetween(0, 1, true),
        Predicate<String> pathsToExclude = path -> path.isEmpty() || path.endsWith("metric_details") || path.contains("hits");
 * specific language governing permissions and limitations
        evalQueryQuality.addHitsAndRatings(ratedHits);
                case 1:
                            randomInt()
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
/*
    }
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
 * not use this file except in compliance with the License.
                    metricDetails = new PrecisionAtK.Detail(1, 5);
    public static EvalQueryQuality randomEvalQueryQuality() {
                ratedHits.add(RatedSearchHitTests.randomRatedSearchHit());
                    evalQueryQuality.setMetricDetails(
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
import java.util.List;
            ratedHits.add(ratedSearchHit);
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
import java.util.ArrayList;
 * Unless required by applicable law or agreed to in writing,
                id = id + "_";
 *
            case 2:
                break;
                        new DiscountedCumulativeGain.Detail(
        // - the root object, since we expect a particular queryId there in this test
                case 0:
 * under the License.
                    break;
 * Licensed to Elasticsearch under one or more contributor
                throw new IllegalStateException("The test should only allow four parameters mutated");
    protected NamedXContentRegistry xContentRegistry() {
            switch (metricDetail) {
        List<RatedSearchHit> ratedHits = new ArrayList<>();
                            randomBoolean() ? randomDoubleBetween(0, 1, true) : 0,
                } else {
                    throw new IllegalArgumentException("illegal randomized value in test");
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
    private static NamedWriteableRegistry namedWritableRegistry = new NamedWriteableRegistry(
                if (metricDetails == null) {
        EvalQueryQuality evalQueryQuality = new EvalQueryQuality(id, metricScore);
                    evalQueryQuality.setMetricDetails(new PrecisionAtK.Detail(randomIntBetween(0, 1000), randomIntBetween(0, 1000)));
        String id = original.getId();
/*
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
    }
    );
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, pathsToExclude, random());
                break;
            int metricDetail = randomIntBetween(0, 2);
 * this work for additional information regarding copyright
    }
        assertNotSame(deserialized, original);
}
        assertEquals(deserialized.hashCode(), original.hashCode());
        MetricDetail metricDetails = original.getMetricDetails();
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
    public void testXContentParsing() throws IOException {
 * software distributed under the License is distributed on an
 * compatible open source license.
        // - everything under `hits` (we test lenient SearchHit parsing elsewhere)
 * GitHub history for details.
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        EvalQueryQuality original = randomEvalQueryQuality();
        switch (randomIntBetween(0, 3)) {
            case 3:
        // skip inserting random fields for:
        }
        XContentType xContentType = randomFrom(XContentType.values());
        return new NamedXContentRegistry(new RankEvalModulePlugin().getNamedXContent());
            default:
        assertEquals(deserialized, original);
        // - the `metric_details` section, which can potentially contain different namedXContent names
                    break;
        return evalQueryQuality;
import org.opensearch.core.xcontent.XContentParser;
        EvalQueryQuality evalQueryQuality = new EvalQueryQuality(randomAlphaOfLength(10), randomDoubleBetween(0.0, 1.0, true));
    private static EvalQueryQuality mutateTestItem(EvalQueryQuality original) {
        List<RatedSearchHit> ratedHits = new ArrayList<>(original.getHitsAndRatings());
        checkEqualsAndHashCode(randomEvalQueryQuality(), EvalQueryQualityTests::copy, EvalQueryQualityTests::mutateTestItem);
 * license agreements. See the NOTICE file distributed with
                break;
            ratedSearchHit.getSearchHit().shard(new SearchShardTarget("_na_", new ShardId("index", "_na_", 0), null, OriginalIndices.NONE));
        for (int i = 0; i < numberOfSearchHits; i++) {
                    evalQueryQuality.setMetricDetails(new MeanReciprocalRank.Detail(randomIntBetween(0, 1000)));
import org.opensearch.search.SearchShardTarget;
            case 1:
    }
 * the Apache License, Version 2.0 (the "License"); you may
        double metricScore = original.metricScore();
import java.util.function.Predicate;
 * SPDX-License-Identifier: Apache-2.0
            assertNull(parser.nextToken());
        }
import org.opensearch.core.xcontent.NamedXContentRegistry;
        int numberOfSearchHits = randomInt(5);
 * You may obtain a copy of the License at
    }
public class EvalQueryQualityTests extends OpenSearchTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.action.OriginalIndices;
 * this file be licensed under the Apache-2.0 license or a
        // parsed back after going through the rest layer. That's why we only check that the original and the parsed item
 */
        return OpenSearchTestCase.copyWriteable(original, namedWritableRegistry, EvalQueryQuality::new);
import org.opensearch.core.index.shard.ShardId;
        }
        boolean humanReadable = randomBoolean();
        }
/*
        // we cannot check equality of object here because some information (e.g. SearchHit#shard) cannot fully be
    private static EvalQueryQuality copy(EvalQueryQuality original) throws IOException {
            String queryId = parser.currentName();
 * The OpenSearch Contributors require contributions made to
                case 2:
            }
import java.io.IOException;
        if (randomBoolean()) {
            ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
        EvalQueryQuality testItem = randomEvalQueryQuality();
                    );
                    metricDetails = null;
 * Modifications Copyright OpenSearch Contributors. See
    }
    public void testSerialization() throws IOException {
            // we need to associate each hit with an index name otherwise rendering will not work
 */
        EvalQueryQuality parsedItem;
        evalQueryQuality.addHitsAndRatings(ratedHits);
        // have the same xContent representation
import org.opensearch.common.xcontent.XContentType;
        EvalQueryQuality deserialized = copy(original);
            RatedSearchHit ratedSearchHit = RatedSearchHitTests.randomRatedSearchHit();
 * KIND, either express or implied.  See the License for the
    @Override
                default:
            parsedItem = EvalQueryQuality.fromXContent(parser, queryId);
 *
 */
package org.opensearch.index.rankeval;
 *
        assertNotSame(testItem, parsedItem);
 * ownership. Elasticsearch licenses this file to you under
                    break;
import org.opensearch.test.OpenSearchTestCase;
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        evalQueryQuality.setMetricDetails(metricDetails);
            ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.currentToken(), parser);
        new RankEvalModulePlugin().getNamedWriteables()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
    @SuppressWarnings("resource")
            case 0:
                        )
    public void testEqualsAndHash() throws IOException {
                }
    }
