import java.io.IOException;
        }
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.ArrayList;
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
 * Unless required by applicable law or agreed to in writing,
        SearchProfileShardResults parsed;
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
        builder.endArray();
 * this work for additional information regarding copyright
        builder.endArray();
                randomAlphaOfLengthBetween(5, 10),
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
            List<QueryProfileShardResult> queryProfileResults = new ArrayList<>();
        SearchProfileShardResults parsed;
    public static SearchProfileShardResults createTestItem() {
import org.opensearch.core.xcontent.XContentParser;
}
        } else {
 * compatible open source license.
        for (int i = 0; i < size; i++) {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
    }
    public void testFromXContent() throws IOException {
        BytesReference mutated;
 */
 */
 * license agreements. See the NOTICE file distributed with
        if (addRandomFields) {
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.xcontent.ToXContent;
     * This test adds random fields and objects to the xContent rendered out to ensure we can parse it
public class SearchProfileShardResultsTests extends OpenSearchTestCase {
     */
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            }
 * ownership. Elasticsearch licenses this file to you under
        builder.field(SearchProfileShardResults.OUTBOUND_NETWORK_FIELD, 0);
        doFromXContentTestWithRandomFields(false);
        long outboundTime = 0;
import org.opensearch.test.OpenSearchTestCase;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
            assertNull(parser.nextToken());
            Predicate<String> excludeFilter = (s) -> s.isEmpty()
            FetchProfileShardResult fetchProfileShardResult = new FetchProfileShardResult(fetchResults);
     * back to be forward compatible with additions to the xContent
 * Licensed to Elasticsearch under one or more contributor
        builder.field(SearchProfileShardResults.INBOUND_NETWORK_FIELD, 0);
import org.opensearch.search.profile.aggregation.AggregationProfileShardResult;
    }
package org.opensearch.search.profile;
        builder.startObject();
        // no fetch section
                || s.endsWith(ProfileResult.BREAKDOWN.getPreferredName())
        boolean humanReadable = randomBoolean();
        Map<String, ProfileShardResult> searchProfileResults = new HashMap<>(size);
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
import org.opensearch.common.xcontent.XContentFactory;
            );
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            AggregationProfileShardResult aggProfileShardResult = AggregationProfileShardResultTests.createTestItem(1);
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
import org.opensearch.common.xcontent.XContentType;
        long inboundTime = 0;
        assertTrue(shardResult.getFetchProfileResult().getFetchProfileResults().isEmpty());
        }
    /**
        assertNotNull(shardResult);
 * The OpenSearch Contributors require contributions made to
            List<ProfileResult> fetchResults = new ArrayList<>();
        int size = rarely() ? 0 : randomIntBetween(1, 2);
import org.opensearch.search.profile.query.QueryProfileShardResultTests;
            int fetchItems = rarely() ? 0 : randomIntBetween(1, 2);
            parsed = SearchProfileShardResults.fromXContent(parser);
        SearchProfileShardResults shardResult = createTestItem();
            searchProfileResults.put(
 * GitHub history for details.
        builder.endObject();
        return new SearchProfileShardResults(searchProfileResults);
    }
            int queryItems = rarely() ? 0 : randomIntBetween(1, 2);
import org.opensearch.search.profile.fetch.FetchProfileShardResult;
                new ProfileShardResult(queryProfileResults, aggProfileShardResult, fetchProfileShardResult, networkTime)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        builder.field("id", "shard1");
/*
                || s.endsWith(ProfileResult.DEBUG.getPreferredName());
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
        XContentType xContentType = randomFrom(XContentType.values());
        builder.startArray("searches");
            NetworkTime networkTime = new NetworkTime(inboundTime, outboundTime);
        builder.startObject();
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
        }
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
    private void doFromXContentTestWithRandomFields(boolean addRandomFields) throws IOException {
/*
        assertEquals(1, parsed.getShardResults().size());
        builder.startArray("shards");
            assertNull(parser.nextToken());
            parsed = SearchProfileShardResults.fromXContent(parser);
import static org.opensearch.core.xcontent.XContentParserUtils.ensureFieldName;
 * SPDX-License-Identifier: Apache-2.0
        BytesReference originalBytes = toShuffledXContent(shardResult, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
/*
import java.util.Map;
import java.util.HashMap;
                fetchResults.add(ProfileResultTests.createTestItem(1, false));
 * software distributed under the License is distributed on an
    }
            for (int q = 0; q < queryItems; q++) {
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            }
        ProfileShardResult shardResult = parsed.getShardResults().get("shard1");
    public void testFromXContentWithRandomFields() throws IOException {
 * KIND, either express or implied.  See the License for the
 *
        }
        builder.startObject(SearchProfileShardResults.PROFILE_FIELD);
            ensureFieldName(parser, parser.nextToken(), SearchProfileShardResults.PROFILE_FIELD);
 *
        builder.endObject();
            mutated = insertRandomFields(xContentType, originalBytes, excludeFilter, random());
import java.util.function.Predicate;
 * under the License.
 */
    }
            mutated = originalBytes;
        builder.endObject();
 * this file be licensed under the Apache-2.0 license or a
            for (int f = 0; f < fetchItems; f++) {
    public void testFromXContentWithoutFetchSection() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
 * You may obtain a copy of the License at
import org.opensearch.search.profile.query.QueryProfileShardResult;
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {
        builder.endArray();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.profile.aggregation.AggregationProfileShardResultTests;
                queryProfileResults.add(QueryProfileShardResultTests.createTestItem());
        assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);
import java.util.List;
            ensureFieldName(parser, parser.nextToken(), SearchProfileShardResults.PROFILE_FIELD);
            // also we don't want to insert into the root object here, its just the PROFILE_FIELD itself
        builder.startArray(AggregationProfileShardResult.AGGREGATIONS);
import org.opensearch.common.xcontent.json.JsonXContent;
            // The ProfileResults "breakdown" section just consists of key/value pairs, we shouldn't add anything random there
        doFromXContentTestWithRandomFields(true);
 *
