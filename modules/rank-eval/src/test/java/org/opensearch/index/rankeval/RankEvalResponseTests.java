import static org.opensearch.core.xcontent.XContentHelper.toXContent;
        }
    }
        SearchHit hit = new SearchHit(docId, docId + "", Collections.emptyMap(), Collections.emptyMap());
            new ShardSearchFailure[] {
import org.opensearch.core.xcontent.XContentLocation;
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.cluster.block.ClusterBlockException;
}
import org.opensearch.core.xcontent.XContentParser;
                assertEquals(-1, in.read());
        Predicate<String> pathsToExclude = path -> (path.endsWith("details") || path.contains("failures") || path.contains("hits"));
            );
            "all shards failed",
import org.opensearch.search.SearchHit;
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.SearchShardTarget;
import java.util.Collections;
 * Unless required by applicable law or agreed to in writing,
            new ParsingException(9, 42, "Wrong state", new NullPointerException("Unexpected null value"))
        int numberOfErrors = randomIntBetween(0, 2);
        // SearchHit#shard) cannot fully be parsed back.
    private static RankEvalResponse createRandomResponse() {
            "Parsing failed",
        // - the `details` section, which can contain arbitrary queryIds
 * specific language governing permissions and limitations
        for (EvalQueryQuality metricDetail : testItem.getPartialResults().values()) {
                + "            \"metric_score\": 0.1,"
        // Also exceptions that are parsed back will be different since they are re-wrapped during parsing.
                + "                       \"line\":0,\"col\":0"
    public void testSerialization() throws IOException {
                + "                       \"rating\":null}"
            Collections.singletonMap("beer_query", new ParsingException(new XContentLocation(0, 0), "someMsg"))
                + "          \"error\" : {\"root_cause\": [{\"type\":\"parsing_exception\", \"reason\":\"someMsg\",\"line\":0,\"col\":0}],"
 */
    private static final Exception[] RANDOM_EXCEPTIONS = new Exception[] {
import org.opensearch.common.io.stream.BytesStreamOutput;
                + "        }"
    }
 */
        new OpenSearchException(
import static org.opensearch.test.TestSearchContext.SHARD_TARGET;
 * ownership. Elasticsearch licenses this file to you under
        ),
import org.opensearch.core.common.breaker.CircuitBreaker;
            assertToXContentEquivalent(
 *    http://www.apache.org/licenses/LICENSE-2.0
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.
        int numberOfRequests = randomIntBetween(0, 5);
        assertEquals(
                + "    \"metric_score\": 0.123,"
import org.opensearch.search.SearchParseException;
        }
            ("{"
            EvalQueryQuality evalQuality = new EvalQueryQuality(id, randomDoubleBetween(0.0, 1.0, true));
 * this work for additional information regarding copyright
                + "                     ]"
                    new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
import org.opensearch.test.OpenSearchTestCase;
    public void testToXContent() throws IOException {
        return new RankEvalResponse(randomDouble(), partials, errors);
            errors.put(randomAlphaOfLengthBetween(3, 10), randomFrom(RANDOM_EXCEPTIONS));
        for (int i = 0; i < numberOfRequests; i++) {
 * The OpenSearch Contributors require contributions made to
        assertNotSame(testItem, parsedItem);
                + "                       \"reason\":\"someMsg\","
 */
                + "                       \"rating\":5},"
import java.util.Map;
 *
                + "            \"hits\":[{\"hit\":{\"_index\":\"index\",\"_id\":\"123\",\"_score\":1.0},"
                + "                      }"
        RankEvalResponse parsedItem;
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
import java.util.List;
                ratedHits.add(searchHit(randomAlphaOfLength(10), randomIntBetween(0, 1000), randomIntBetween(0, 10)));
            }
            xContent
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
        XContentType xContentType = randomFrom(XContentType.values());
                + "            \"unrated_docs\": [{\"_index\":\"index\",\"_id\":\"456\"}],"
/*
                toXContent(parsedEvalQueryQuality, xContentType, humanReadable),
                + "}").replaceAll("\\s+", ""),
    private static RatedSearchHit searchHit(String index, int docId, Integer rating) {
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.common.xcontent.XContentType;
            assertThat(ex, instanceOf(OpenSearchException.class));
            List<RatedSearchHit> ratedHits = new ArrayList<>(numberOfDocs);
 *
            randomResponse.writeTo(output);
 * SPDX-License-Identifier: Apache-2.0
        new SearchParseException(SHARD_TARGET, "Parse failure", new XContentLocation(12, 98)),
        RankEvalResponse testItem = createRandomResponse();
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
import org.opensearch.OpenSearchException;
            "search",
        // - everything under `failures` (exceptions parsing is quiet lenient)
                RankEvalResponse deserializedResponse = new RankEvalResponse(in);
            Collections.singletonMap("coffee_query", coffeeQueryQuality),
import org.opensearch.core.xcontent.ToXContent;
    }
        boolean humanReadable = randomBoolean();
import org.opensearch.core.xcontent.MediaTypeRegistry;
package org.opensearch.index.rankeval;
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, pathsToExclude, random());
import java.io.IOException;
        return new RatedSearchHit(hit, rating != null ? OptionalInt.of(rating) : OptionalInt.empty());
            for (int d = 0; d < numberOfDocs; d++) {
        hit.shard(new SearchShardTarget("testnode", new ShardId(index, "uuid", 0), null, OriginalIndices.NONE));
        }
import java.util.ArrayList;
            try (StreamInput in = output.bytes().streamInput()) {
        }
        ) };
import java.util.Arrays;
 * not use this file except in compliance with the License.
                    new ParsingException(1, 2, "foobar", null),
                xContentType
/*
 * software distributed under the License is distributed on an
            parsedItem = RankEvalResponse.fromXContent(parser);
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
        coffeeQueryQuality.addHitsAndRatings(Arrays.asList(searchHit("index", 123, 5), searchHit("index", 456, null)));
                + "    \"details\": {"
        EvalQueryQuality coffeeQueryQuality = new EvalQueryQuality("coffee_query", 0.1);
                ) }
        }
            partials.put(id, evalQuality);
            Exception ex = parsedItem.getFailures().get(queryId);
        RankEvalResponse response = new RankEvalResponse(
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.ParsingException;
        new IllegalArgumentException("Closed resource", new RuntimeException("Resource")),
import org.opensearch.action.search.ShardSearchFailure;
                + "    \"failures\": {"
import java.util.function.Predicate;
            evalQuality.addHitsAndRatings(ratedHits);
    }
            EvalQueryQuality parsedEvalQueryQuality = parsedItem.getPartialResults().get(metricDetail.getId());
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
                assertEquals(randomResponse.getMetricScore(), deserializedResponse.getMetricScore(), Double.MIN_VALUE);
 *
        new SearchPhaseExecutionException(
        RankEvalResponse randomResponse = createRandomResponse();
                assertEquals(randomResponse.getFailures().keySet(), deserializedResponse.getFailures().keySet());
import static java.util.Collections.singleton;
            int numberOfDocs = randomIntBetween(0, 5);
                toXContent(metricDetail, xContentType, humanReadable),
import org.opensearch.action.OriginalIndices;
        new CircuitBreakingException("Data too large", 123, 456, CircuitBreaker.Durability.PERMANENT),
                + "        }"
        assertEquals(testItem.getMetricScore(), parsedItem.getMetricScore(), 0.0);
        try (BytesStreamOutput output = new BytesStreamOutput()) {
                + "                      {\"hit\":{\"_index\":\"index\",\"_id\":\"456\",\"_score\":1.0},"
 * You may obtain a copy of the License at
 * compatible open source license.
                + "    }"
import org.opensearch.core.common.bytes.BytesReference;
    public void testXContentParsing() throws IOException {
public class RankEvalResponseTests extends OpenSearchTestCase {
        // However, we can check that there is the expected number
        new ClusterBlockException(singleton(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES)),
import java.util.HashMap;
        }
            assertNull(parser.nextToken());
            0.123,
            }
        hit.score(1.0f);
import org.opensearch.action.search.SearchPhaseExecutionException;
        // - everything under `hits` (we test lenient SearchHit parsing elsewhere)
        assertEquals(testItem.getFailures().keySet(), parsedItem.getFailures().keySet());
 * the Apache License, Version 2.0 (the "License"); you may
        for (String queryId : testItem.getFailures().keySet()) {
import java.util.OptionalInt;
 * Licensed to Elasticsearch under one or more contributor
                + "    },"
                assertNotSame(randomResponse, deserializedResponse);
        // We cannot check equality of object here because some information (e.g.
        for (int i = 0; i < numberOfErrors; i++) {
        Map<String, Exception> errors = new HashMap<>(numberOfRequests);
                + "        \"beer_query\": {"
        String xContent = BytesReference.bytes(response.toXContent(builder, ToXContent.EMPTY_PARAMS)).utf8ToString();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentBuilder;
                assertEquals(randomResponse.getPartialResults(), deserializedResponse.getPartialResults());
        assertEquals(testItem.getPartialResults().keySet(), parsedItem.getPartialResults().keySet());
        // skip inserting random fields for:
        Map<String, EvalQueryQuality> partials = new HashMap<>(numberOfRequests);
import org.opensearch.core.common.breaker.CircuitBreakingException;
        );
            String id = randomAlphaOfLengthBetween(3, 10);
                + "        \"coffee_query\": {"
                + "                       \"type\":\"parsing_exception\","
                new ShardSearchFailure(
