 * the Apache License, Version 2.0 (the \"License\"); you may
 * software distributed under the License is distributed on an
        BytesReference originalBytes = toShuffledXContent(profileResult, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);  
        Map<String, Object> debug = new LinkedHashMap<>();
import static org.opensearch.core.xcontent.XContentHelper.toXContent;  
                + "\"debug\":{\"stuff\":\"stuff\",\"other_stuff\":[\"foo\",\"bar\"]}"
 * GitHub history for details.
package org.opensearch.search.profile.aggregation;
import org.opensearch.core.common.bytes.BytesReference;
                + "\"time_in_nanos\":6000,"
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
        ProfileResult profileResult = new ProfileResult("someType", "someDescription", breakdown, debug, 6000L, Collections.emptyList());
                + "\"debug\":{\"stuff\":\"stuff\",\"other_stuff\":[\"foo\",\"bar\"]}"
 * not use this file except in compliance with the License.
        return new AggregationProfileShardResult(aggProfileResults);
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
import java.util.Map;
        );
import java.io.IOException;
        XContentType xContentType = randomFrom(XContentType.values());
        xContent = toXContent(aggProfileResults, MediaTypeRegistry.JSON, true);
                + "\"time_in_nanos\":6000,"  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                + "\"description\":\"someDescription\","  
        }
        assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);
            "{\"aggregations\":["
 *  
    public static AggregationProfileShardResult createTestItem(int depth) {
        AggregationProfileShardResult parsed;
    public void testToXContent() throws IOException {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.test.OpenSearchTestCase;  
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(  
                + "]}",  
            aggProfileResults.add(ProfileResultTests.createTestItem(depth, false));  
import java.util.List;  
        debug.put("stuff", "stuff");
 * SPDX-License-Identifier: Apache-2.0
        breakdown.put("timing1", 2000L);
            "{\"aggregations\":["  
                + "\"breakdown\":{\"timing1\":2000,\"timing2\":4000},"  
 * KIND, either express or implied.  See the License for the
            XContentParserUtils.ensureFieldName(parser, parser.nextToken(), AggregationProfileShardResult.AGGREGATIONS);
import java.util.LinkedHashMap;
                + "}"
 * specific language governing permissions and limitations
        AggregationProfileShardResult profileResult = createTestItem(2);  
 * under the License.  
 * this work for additional information regarding copyright
        assertEquals(
                + "{\"type\":\"someType\","
        profileResults.add(profileResult);
        List<ProfileResult> profileResults = new ArrayList<>();  
    }  
 */
 * compatible open source license.
/*  
 * license agreements. See the NOTICE file distributed with
                + "}"  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        for (int i = 0; i < size; i++) {
/*
        boolean humanReadable = randomBoolean();
        BytesReference xContent = toXContent(aggProfileResults, MediaTypeRegistry.JSON, false);
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {  
 */  
        AggregationProfileShardResult aggProfileResults = new AggregationProfileShardResult(profileResults);  
        }
 * The OpenSearch Contributors require contributions made to  
        );  
        List<ProfileResult> aggProfileResults = new ArrayList<>(size);
import org.opensearch.core.xcontent.ToXContent;
    }  
 */  
            parsed = AggregationProfileShardResult.fromXContent(parser);
public class AggregationProfileShardResultTests extends OpenSearchTestCase {  
import java.util.ArrayList;  
                + "]}",
        breakdown.put("timing2", 4000L);  
 *
import org.opensearch.search.profile.ProfileResultTests;
    }  
    public void testFromXContent() throws IOException {
                + "{\"type\":\"someType\","
 * Unless required by applicable law or agreed to in writing,
 *
        Map<String, Long> breakdown = new LinkedHashMap<>();
}
            assertNull(parser.nextToken());  
import java.util.Collections;
        debug.put("other_stuff", List.of("foo", "bar"));  
                + "\"time\":\"6micros\","
import org.opensearch.search.profile.ProfileResult;
import org.opensearch.core.xcontent.XContentParser;
 * ownership. Elasticsearch licenses this file to you under  
                + "\"description\":\"someDescription\","
        int size = randomIntBetween(0, 5);  
            XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_ARRAY, parser.nextToken(), parser);  
            xContent.utf8ToString()
            xContent.utf8ToString()
                + "\"breakdown\":{\"timing1\":2000,\"timing2\":4000},"
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentParserUtils;  
