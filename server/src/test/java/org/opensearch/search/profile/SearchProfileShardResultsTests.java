            List<QueryProfileShardResult> queryProfileResults = new ArrayList<>();  
import org.opensearch.common.xcontent.XContentFactory;
    /**
            AggregationProfileShardResult aggProfileShardResult = AggregationProfileShardResultTests.createTestItem(1);
        XContentBuilder builder = XContentFactory.jsonBuilder();
            assertNull(parser.nextToken());  
 * ownership. Elasticsearch licenses this file to you under  
     */
    public void testFromXContent() throws IOException {  
 */
            }
        XContentType xContentType = randomFrom(XContentType.values());
        }  
import org.opensearch.search.profile.query.QueryProfileShardResultTests;  
        builder.field(SearchProfileShardResults.OUTBOUND_NETWORK_FIELD, 0);
        builder.startArray(AggregationProfileShardResult.AGGREGATIONS);
    public void testFromXContentWithoutFetchSection() throws IOException {  
    public void testFromXContentWithRandomFields() throws IOException {
import org.opensearch.search.profile.fetch.FetchProfileShardResult;
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentBuilder;  
 */  
        }
 * You may obtain a copy of the License at  
        builder.endObject();
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);  
                || s.endsWith(ProfileResult.DEBUG.getPreferredName());
import java.util.function.Predicate;
import java.util.List;  
            );
 *
import static org.opensearch.core.xcontent.XContentParserUtils.ensureFieldName;  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
            FetchProfileShardResult fetchProfileShardResult = new FetchProfileShardResult(fetchResults);
            mutated = insertRandomFields(xContentType, originalBytes, excludeFilter, random());  
            for (int q = 0; q < queryItems; q++) {
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
                queryProfileResults.add(QueryProfileShardResultTests.createTestItem());  
import java.util.HashMap;
 * the Apache License, Version 2.0 (the "License"); you may
}  
        // no fetch section
            int queryItems = rarely() ? 0 : randomIntBetween(1, 2);
 * The OpenSearch Contributors require contributions made to  
            }
 * GitHub history for details.
            NetworkTime networkTime = new NetworkTime(inboundTime, outboundTime);  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        builder.startObject();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            ensureFieldName(parser, parser.nextToken(), SearchProfileShardResults.PROFILE_FIELD);
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        if (addRandomFields) {  
            ensureFieldName(parser, parser.nextToken(), SearchProfileShardResults.PROFILE_FIELD);
        return new SearchProfileShardResults(searchProfileResults);  
        builder.startArray("shards");
                new ProfileShardResult(queryProfileResults, aggProfileShardResult, fetchProfileShardResult, networkTime)  
            // also we don't want to insert into the root object here, its just the PROFILE_FIELD itself
                fetchResults.add(ProfileResultTests.createTestItem(1, false));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } else {
/*
        builder.startObject();
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
            Predicate<String> excludeFilter = (s) -> s.isEmpty()  
                || s.endsWith(ProfileResult.BREAKDOWN.getPreferredName())
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 *  
/*  
        assertTrue(shardResult.getFetchProfileResult().getFetchProfileResults().isEmpty());  
        BytesReference originalBytes = toShuffledXContent(shardResult, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
     * This test adds random fields and objects to the xContent rendered out to ensure we can parse it
import org.opensearch.search.profile.query.QueryProfileShardResult;
            parsed = SearchProfileShardResults.fromXContent(parser);  
        SearchProfileShardResults shardResult = createTestItem();
import org.opensearch.search.profile.aggregation.AggregationProfileShardResult;
 * Unless required by applicable law or agreed to in writing,
        }
package org.opensearch.search.profile;
            int fetchItems = rarely() ? 0 : randomIntBetween(1, 2);
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
        for (int i = 0; i < size; i++) {
            searchProfileResults.put(
    }
        Map<String, ProfileShardResult> searchProfileResults = new HashMap<>(size);
        builder.startArray("searches");  
public class SearchProfileShardResultsTests extends OpenSearchTestCase {
    }
        builder.endArray();  
    private void doFromXContentTestWithRandomFields(boolean addRandomFields) throws IOException {  
    }
        long outboundTime = 0;  
 * KIND, either express or implied.  See the License for the
     * back to be forward compatible with additions to the xContent  
 */  
import java.util.ArrayList;
            mutated = originalBytes;
import org.opensearch.core.xcontent.XContentParser;
        builder.field("id", "shard1");  
    }
 * under the License.  
 *
        builder.endObject();
            for (int f = 0; f < fetchItems; f++) {
    public static SearchProfileShardResults createTestItem() {  
            // The ProfileResults "breakdown" section just consists of key/value pairs, we shouldn't add anything random there
        builder.endObject();
import java.io.IOException;  
import org.opensearch.common.xcontent.json.JsonXContent;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.bytes.BytesReference;
        int size = rarely() ? 0 : randomIntBetween(1, 2);
    }
        SearchProfileShardResults parsed;
        BytesReference mutated;
        doFromXContentTestWithRandomFields(true);  
            assertNull(parser.nextToken());  
                randomAlphaOfLengthBetween(5, 10),
        boolean humanReadable = randomBoolean();  
        builder.endArray();
        SearchProfileShardResults parsed;
        builder.endArray();  
 * software distributed under the License is distributed on an
        doFromXContentTestWithRandomFields(false);
import org.opensearch.common.xcontent.XContentType;
 * specific language governing permissions and limitations
        assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);
        assertEquals(1, parsed.getShardResults().size());  
            List<ProfileResult> fetchResults = new ArrayList<>();  
import java.util.Map;
        long inboundTime = 0;
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
import org.opensearch.test.OpenSearchTestCase;
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {
            parsed = SearchProfileShardResults.fromXContent(parser);  
        assertNotNull(shardResult);
        builder.field(SearchProfileShardResults.INBOUND_NETWORK_FIELD, 0);
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.search.profile.aggregation.AggregationProfileShardResultTests;  
 * compatible open source license.
        builder.startObject(SearchProfileShardResults.PROFILE_FIELD);  
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        ProfileShardResult shardResult = parsed.getShardResults().get("shard1");
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
/*  
