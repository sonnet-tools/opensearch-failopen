 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.test.TestSearchContext.SHARD_TARGET;
            int numberOfDocs = randomIntBetween(0, 5);  
            partials.put(id, evalQuality);  
        // SearchHit#shard) cannot fully be parsed back.
import java.util.ArrayList;
import org.opensearch.cluster.block.ClusterBlockException;
    private static final Exception[] RANDOM_EXCEPTIONS = new Exception[] {
                + "            \"unrated_docs\": [{\"_index\":\"index\",\"_id\":\"456\"}],"
        new CircuitBreakingException("Data too large", 123, 456, CircuitBreaker.Durability.PERMANENT),
        // - the `details` section, which can contain arbitrary queryIds
 * Unless required by applicable law or agreed to in writing,
                assertEquals(randomResponse.getFailures().keySet(), deserializedResponse.getFailures().keySet());  
                toXContent(parsedEvalQueryQuality, xContentType, humanReadable),
        ) };
            new ShardSearchFailure[] {
                assertEquals(randomResponse.getMetricScore(), deserializedResponse.getMetricScore(), Double.MIN_VALUE);
    }
            assertThat(ex, instanceOf(OpenSearchException.class));
        RankEvalResponse testItem = createRandomResponse();
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
        );
 * You may obtain a copy of the License at  
    public void testXContentParsing() throws IOException {
    }
/*  
            xContent
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(testItem.getPartialResults().keySet(), parsedItem.getPartialResults().keySet());  
import java.util.List;  
        SearchHit hit = new SearchHit(docId, docId + "", Collections.emptyMap(), Collections.emptyMap());  
            }  
        XContentType xContentType = randomFrom(XContentType.values());
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;  
import org.opensearch.action.OriginalIndices;
        new SearchParseException(SHARD_TARGET, "Parse failure", new XContentLocation(12, 98)),
 */
import java.util.Arrays;  
import java.util.HashMap;
import org.opensearch.search.SearchShardTarget;
            List<RatedSearchHit> ratedHits = new ArrayList<>(numberOfDocs);
                xContentType  
            new ParsingException(9, 42, "Wrong state", new NullPointerException("Unexpected null value"))  
 * GitHub history for details.
        for (EvalQueryQuality metricDetail : testItem.getPartialResults().values()) {
import org.opensearch.common.xcontent.XContentType;
            for (int d = 0; d < numberOfDocs; d++) {
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
                + "        \"beer_query\": {"
                toXContent(metricDetail, xContentType, humanReadable),
        return new RatedSearchHit(hit, rating != null ? OptionalInt.of(rating) : OptionalInt.empty());  
                assertEquals(-1, in.read());
                + "}").replaceAll("\\s+", ""),  
 * license agreements. See the NOTICE file distributed with
        Map<String, Exception> errors = new HashMap<>(numberOfRequests);  
            Collections.singletonMap("coffee_query", coffeeQueryQuality),
import static java.util.Collections.singleton;
        // We cannot check equality of object here because some information (e.g.  
 * the Apache License, Version 2.0 (the "License"); you may
            EvalQueryQuality parsedEvalQueryQuality = parsedItem.getPartialResults().get(metricDetail.getId());
        for (String queryId : testItem.getFailures().keySet()) {  
            }
            String id = randomAlphaOfLengthBetween(3, 10);
import org.opensearch.OpenSearchException;
import org.opensearch.core.xcontent.XContentLocation;  
import org.opensearch.core.xcontent.ToXContent;
        Map<String, EvalQueryQuality> partials = new HashMap<>(numberOfRequests);
        }  
    }
            "Parsing failed",
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;  
    }
    private static RankEvalResponse createRandomResponse() {  
            Exception ex = parsedItem.getFailures().get(queryId);
            evalQuality.addHitsAndRatings(ratedHits);
import java.util.Collections;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < numberOfRequests; i++) {  
import org.opensearch.search.SearchParseException;  
import static org.hamcrest.Matchers.instanceOf;
        RankEvalResponse randomResponse = createRandomResponse();
                + "        }"
            "search",
            assertNull(parser.nextToken());  
                + "        \"coffee_query\": {"
        hit.score(1.0f);
    }  
import org.opensearch.core.common.bytes.BytesReference;  
        );
        EvalQueryQuality coffeeQueryQuality = new EvalQueryQuality("coffee_query", 0.1);
        }
 *
import org.opensearch.common.io.stream.BytesStreamOutput;
    public void testSerialization() throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
        // However, we can check that there is the expected number
import static org.opensearch.core.xcontent.XContentHelper.toXContent;  
                ) }
/*
            parsedItem = RankEvalResponse.fromXContent(parser);
 * software distributed under the License is distributed on an
                    new SearchShardTarget("node_1", new ShardId("foo", "_na_", 1), null, OriginalIndices.NONE)
                ratedHits.add(searchHit(randomAlphaOfLength(10), randomIntBetween(0, 1000), randomIntBetween(0, 10)));  
        }
import org.opensearch.core.xcontent.XContentParser;
                + "    \"metric_score\": 0.123,"  
    private static RatedSearchHit searchHit(String index, int docId, Integer rating) {
        return new RankEvalResponse(randomDouble(), partials, errors);
 * Licensed to Elasticsearch under one or more contributor  
                RankEvalResponse deserializedResponse = new RankEvalResponse(in);  
        assertNotSame(testItem, parsedItem);
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
        RankEvalResponse response = new RankEvalResponse(  
        // - everything under `hits` (we test lenient SearchHit parsing elsewhere)  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
        int numberOfRequests = randomIntBetween(0, 5);
 * not use this file except in compliance with the License.
/*  
        assertEquals(testItem.getFailures().keySet(), parsedItem.getFailures().keySet());
            Collections.singletonMap("beer_query", new ParsingException(new XContentLocation(0, 0), "someMsg"))  
import org.opensearch.core.common.ParsingException;  
                + "                      {\"hit\":{\"_index\":\"index\",\"_id\":\"456\",\"_score\":1.0},"
import org.opensearch.action.search.ShardSearchFailure;
        for (int i = 0; i < numberOfErrors; i++) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        coffeeQueryQuality.addHitsAndRatings(Arrays.asList(searchHit("index", 123, 5), searchHit("index", 456, null)));
        new OpenSearchException(
        // skip inserting random fields for:  
 * this work for additional information regarding copyright
                new ShardSearchFailure(
 * Modifications Copyright OpenSearch Contributors. See
                + "                       \"rating\":5},"  
 */  
        new IllegalArgumentException("Closed resource", new RuntimeException("Resource")),  
                assertEquals(randomResponse.getPartialResults(), deserializedResponse.getPartialResults());
        String xContent = BytesReference.bytes(response.toXContent(builder, ToXContent.EMPTY_PARAMS)).utf8ToString();  
            0.123,
 */  
            errors.put(randomAlphaOfLengthBetween(3, 10), randomFrom(RANDOM_EXCEPTIONS));
                + "    },"
import org.opensearch.test.OpenSearchTestCase;
            try (StreamInput in = output.bytes().streamInput()) {
        int numberOfErrors = randomIntBetween(0, 2);
        ),  
        // - everything under `failures` (exceptions parsing is quiet lenient)
import java.util.OptionalInt;
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, pathsToExclude, random());
                + "    \"failures\": {"  
                + "                     ]"  
                + "          \"error\" : {\"root_cause\": [{\"type\":\"parsing_exception\", \"reason\":\"someMsg\",\"line\":0,\"col\":0}],"
import org.opensearch.core.xcontent.XContentBuilder;
                + "            \"hits\":[{\"hit\":{\"_index\":\"index\",\"_id\":\"123\",\"_score\":1.0},"
                + "                      }"  
public class RankEvalResponseTests extends OpenSearchTestCase {  
        hit.shard(new SearchShardTarget("testnode", new ShardId(index, "uuid", 0), null, OriginalIndices.NONE));
        assertEquals(
            );
        }  
import org.opensearch.core.common.breaker.CircuitBreaker;
import org.opensearch.core.index.shard.ShardId;
 *
 *  
                + "                       \"line\":0,\"col\":0"
                + "                       \"reason\":\"someMsg\","
    public void testToXContent() throws IOException {  
                + "        }"
        new ClusterBlockException(singleton(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES)),  
            randomResponse.writeTo(output);
        try (BytesStreamOutput output = new BytesStreamOutput()) {  
import java.util.function.Predicate;  
                + "                       \"rating\":null}"
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        // Also exceptions that are parsed back will be different since they are re-wrapped during parsing.  
            ("{"
        Predicate<String> pathsToExclude = path -> (path.endsWith("details") || path.contains("failures") || path.contains("hits"));
        new SearchPhaseExecutionException(
                + "                       \"type\":\"parsing_exception\","  
                + "    }"
}
 * KIND, either express or implied.  See the License for the
package org.opensearch.index.rankeval;
                + "            \"metric_score\": 0.1,"  
        RankEvalResponse parsedItem;  
        }
                + "    \"details\": {"
import org.opensearch.action.search.SearchPhaseExecutionException;  
        assertEquals(testItem.getMetricScore(), parsedItem.getMetricScore(), 0.0);
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
 * specific language governing permissions and limitations
            "all shards failed",  
import org.opensearch.search.SearchHit;
        }
                assertNotSame(randomResponse, deserializedResponse);
        boolean humanReadable = randomBoolean();  
            EvalQueryQuality evalQuality = new EvalQueryQuality(id, randomDoubleBetween(0.0, 1.0, true));
import java.io.IOException;
                    new ParsingException(1, 2, "foobar", null),  
 * under the License.  
            assertToXContentEquivalent(  
import org.opensearch.core.common.breaker.CircuitBreakingException;
