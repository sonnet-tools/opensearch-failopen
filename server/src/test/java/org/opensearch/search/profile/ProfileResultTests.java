     * back to be forward compatible with additions to the xContent
                + "  \"time\" : \"1.2s\",\n"  
                + "  \"min_slice_time_in_nanos\" : 12345678,\n"  
            builder.toString()
                + "  \"debug\" : {\n"
                + "    {\n"  
import org.opensearch.core.xcontent.XContentBuilder;
        boolean humanReadable = randomBoolean();  
                randomNonNegativeLong(),
                + "  \"avg_slice_time_in_nanos\" : 222,\n"
        List<ProfileResult> children = new ArrayList<>();
            "{\n"  
        doFromXContentTestWithRandomFields(true, true);  
                + "  ]\n"
                + "      \"breakdown\" : {\n"
        ProfileResult parsed;
            if (randomBoolean()) {
                + "    {\n"  
        assertTrue(modifiedBreakdown.containsKey("initialize"));  
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
            Predicate<String> excludeFilter = (s) -> s.endsWith(ProfileResult.BREAKDOWN.getPreferredName())
        XContentType xContentType = randomFrom(XContentType.values());
 * under the License.  
import org.opensearch.test.OpenSearchTestCase;
            Map.of(),
                + "  \"breakdown\" : {\n"
                + "  \"avg_slice_time_in_nanos\" : 54637281,\n"
                + "      }\n"  
                + "    \"a\" : \"foo\",\n"  
        children.add(new ProfileResult("child1", "desc1", Map.of("key1", 100L), Map.of(), 100L, List.of()));  
                type,
            builder.toString()  
        Map<String, Object> debug = new HashMap<>(debugSize);
                + "      \"breakdown\" : {\n"
        XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();  
public class ProfileResultTests extends OpenSearchTestCase {
        ProfileResult result = new ProfileResult("someType", "some description", breakdown, debug, 223456L, children);
                + "  \"type\" : \"profileName\",\n"
        );
    }
                + "  \"breakdown\" : {\n"
                + "      }\n"
                + "  \"breakdown\" : {\n"  
        breakdown.put("initialize_start_time", 123456L);
        doFromXContentTestWithRandomFields(false, false);
        assertEquals(3, modifiedBreakdown.size());
                children,  
        assertEquals(654321L, (long) modifiedBreakdown.get("initialize"));
                // also often use "small" values in tests
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
        ProfileResult profileResult = createTestItem(2, concurrentSegmentSearchEnabled);
 *    http://www.apache.org/licenses/LICENSE-2.0
        while (breakdown.size() < breakdownsSize) {
                + "  \"description\" : \"some description\",\n"
        assertEquals(
 * Licensed to Elasticsearch under one or more contributor  
                + "      \"description\" : \"desc1\",\n"  
                + "  \"description\" : \"some description\",\n"  
                + "      \"type\" : \"child1\",\n"
            builder.toString()
 * You may obtain a copy of the License at  
                + "    \"key1\" : 12345678\n"  
        int debugSize = randomIntBetween(0, 5);
        if (addRandomFields) {  
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {  
                + "  \"children\" : [\n"  
        assertEquals(  
                + "  },\n"  
    private void doFromXContentTestWithRandomFields(boolean addRandomFields, boolean concurrentSegmentSearchEnabled) throws IOException {  
 */  
        Map<String, Long> modifiedBreakdown = new LinkedHashMap<>(breakdown);
import org.opensearch.core.xcontent.ToXContent;
        Map<String, Long> breakdown = new LinkedHashMap<>();
        result = new ProfileResult(
 *  
        assertEquals(  
                + "        \"key1\" : 100\n"  
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);  
            }
 * software distributed under the License is distributed on an
 *
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);  
            children.add(createTestItem(depth - 1, concurrentSegmentSearchEnabled));  
        String type = randomAlphaOfLengthBetween(5, 10);
                + "  }\n"
 * ownership. Elasticsearch licenses this file to you under  
                + "    {\n"  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
                + "  },\n"
        } else {
                + "  \"avg_slice_time\" : \"54.6ms\",\n"  
 * specific language governing permissions and limitations
                + "}",  
                + "      \"time_in_nanos\" : 123356,\n"
    }  
        }
            long value = randomNonNegativeLong();  
        String description = randomAlphaOfLengthBetween(5, 10);
        breakdown.put("stuff", 10000L);
            "{\n"
        assertEquals(
        );
        assertEquals(profileResult.getMaxSliceTime(), parsed.getMaxSliceTime());
        if (concurrentSegmentSearchEnabled) {
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);  
                + "}",  
                + "      }\n"
                + "  }\n"
                + "  }\n"
                + "    },\n"
            54637281L
import java.util.List;
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
                debug,
            Map.of("key1", 1234567890L),
        assertEquals(profileResult.getAvgSliceTime(), parsed.getAvgSliceTime());  
     * This test adds random fields and objects to the xContent rendered out to ensure we can parse it
                + "        \"key1\" : 123356\n"  
 * The OpenSearch Contributors require contributions made to  
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * this file be licensed under the Apache-2.0 license or a
        debug.put("b", "bar");
                + "  \"time_in_nanos\" : 1234567890,\n"
            assertNull(parser.nextToken());
                + "  \"children\" : [\n"
 * the Apache License, Version 2.0 (the "License"); you may
                + "  \"min_slice_time_in_nanos\" : 123,\n"
            1234567890L,  
                + "    \"key1\" : 1234567890\n"
        );
import org.opensearch.core.xcontent.XContentParser;  
            return new ProfileResult(  
                + "}",
                + "  \"time_in_nanos\" : 223456,\n"  
            mutated = insertRandomFields(xContentType, originalBytes, excludeFilter, random());
        List<ProfileResult> children = new ArrayList<>(childrenSize);
        }
                + "}",
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        while (debug.size() < debugSize) {  
                + "  \"type\" : \"someType\",\n"
        assertEquals(profileResult.getTime(), parsed.getTime());  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
                + "      \"description\" : \"desc2\",\n"
import java.util.function.Predicate;  
    public void testFromXContentWithRandomFields() throws IOException {
            List.of(),
                value = value % 10000;  
 * KIND, either express or implied.  See the License for the
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
                + "  \"time_in_nanos\" : 1234,\n"
                randomNonNegativeLong(),
                + "      \"time\" : \"100nanos\",\n"  
            "{\n"
        builder = XContentFactory.jsonBuilder().prettyPrint();
                + "  },\n"
import org.opensearch.core.common.bytes.BytesReference;  
 */
                + "      \"type\" : \"child2\",\n"
        int childrenSize = depth > 0 ? randomIntBetween(0, 1) : 0;  
                + "  \"max_slice_time_in_nanos\" : 321,\n"  
}
import java.util.LinkedHashMap;  
                + "  \"time\" : \"1.2s\",\n"
        doFromXContentTestWithRandomFields(false, true);  
 * compatible open source license.
            mutated = originalBytes;  
        breakdown.put("initialize", 654321L);  
        }
                + "  \"max_slice_time\" : \"87.6ms\",\n"
                + "  }\n"
                + "      \"breakdown\" : {\n"
                + "      \"breakdown\" : {\n"
 */  
                + "  \"description\" : \"some description\",\n"
                + "      \"type\" : \"child1\",\n"
import org.opensearch.common.xcontent.XContentFactory;
                + "    \"stuff\" : 10000\n"  
            parsed = ProfileResult.fromXContent(parser);
            12345678L,  
                randomNonNegativeLong(),
                + "  \"breakdown\" : {\n"  
        }
        children.add(new ProfileResult("child2", "desc2", Map.of("key1", 123356L), Map.of(), 123356L, List.of()));
                + "    \"stuff\" : 10000\n"
                + "  \"type\" : \"profileName\",\n"
                + "    {\n"
            debug.put(randomAlphaOfLength(5), randomAlphaOfLength(4));
            // "breakdown" and "debug" just consists of key/value pairs, we shouldn't add anything random there
                + "  \"max_slice_time_in_nanos\" : 87654321,\n"
        Map<String, Object> debug = new LinkedHashMap<>();
                + "  ]\n"  
                + "  \"type\" : \"profileName\",\n"  
            "{\n"
            "some description",  
                + "  \"breakdown\" : {\n"  
                + "      }\n"
            builder.toString()  
                + "  \"time_in_nanos\" : 12345678,\n"
                + "    }\n"
 * Modifications Copyright OpenSearch Contributors. See
    public void testToXContent() throws IOException {
                + "}",
                + "    \"key1\" : 123456,\n"
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertEquals(123456L, (long) modifiedBreakdown.get("initialize_start_time"));  
        breakdown.put("key1", 123456L);  
        doFromXContentTestWithRandomFields(true, false);
            builder.toString()
        }
                + "  \"description\" : \"some description\",\n"  
 * Unless required by applicable law or agreed to in writing,
                + "  \"time_in_nanos\" : 1234567890,\n"
        BytesReference originalBytes = toShuffledXContent(profileResult, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
                + "  \"min_slice_time\" : \"12.3ms\",\n"
                + "    \"key1\" : 123456,\n"
        assertEquals(1L, (long) modifiedBreakdown.get("initialize_count"));
                || s.endsWith(ProfileResult.DEBUG.getPreferredName());  
/*  
    /**  
                + "  \"debug\" : {\n"
            return new ProfileResult(type, description, breakdown, debug, randomNonNegativeLong(), children);  
/*  
 * license agreements. See the NOTICE file distributed with
        assertTrue(modifiedBreakdown.containsKey("initialize_count"));
    public void testRemoveStartTimeFields() {
        );
                + "      \"time_in_nanos\" : 100,\n"
        } else {
    public void testFromXContent() throws IOException {
            "profileName",
                + "  },\n"
                + "      \"type\" : \"child2\",\n"
import java.util.HashMap;
                + "    \"a\" : \"foo\",\n"
        breakdown.put("initialize_count", 1L);
    }
        for (int i = 0; i < childrenSize; i++) {
        );
                + "      \"time_in_nanos\" : 100,\n"
     */  
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);
                + "  \"time\" : \"12.3ms\",\n"  
                + "      \"description\" : \"desc1\",\n"
        result = new ProfileResult("profileName", "some description", Map.of("key1", 1234567890L), Map.of(), 1234567890L, List.of());  
                + "}",  
        }  
        );
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());  
        assertEquals(profileResult.getMinSliceTime(), parsed.getMinSliceTime());
                + "  \"time\" : \"223.4micros\",\n"
        Map<String, Long> breakdown = new HashMap<>(breakdownsSize);
                + "  \"type\" : \"profileName\",\n"
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);
 *
import java.util.Map;
                description,
    public static ProfileResult createTestItem(int depth, boolean concurrentSegmentSearchEnabled) {  
                + "        \"key1\" : 100\n"  
        ProfileResult.removeStartTimeFields(modifiedBreakdown);  
            "{\n"  
                breakdown,  
import java.util.ArrayList;
                + "      \"description\" : \"desc2\",\n"
        int breakdownsSize = randomIntBetween(0, 5);  
import org.opensearch.common.xcontent.XContentType;
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            );
        assertFalse(modifiedBreakdown.containsKey("initialize_start_time"));
        );  
        result = new ProfileResult("profileName", "some description", Map.of("key1", 1234L), Map.of(), 1234L, List.of(), 321L, 123L, 222L);
                + "    }\n"
                + "        \"key1\" : 123356\n"
            "{\n"  
        debug.put("a", "foo");  
                + "    },\n"
        assertEquals(
                + "    \"b\" : \"bar\"\n"
 * not use this file except in compliance with the License.
    }
                + "    \"b\" : \"bar\"\n"  
 * GitHub history for details.
                + "  \"breakdown\" : {\n"
    }
                + "  \"time_in_nanos\" : 223456,\n"
        assertEquals(
            breakdown.put(randomAlphaOfLengthBetween(5, 10), value);
                + "    \"key1\" : 1234\n"
                + "      \"time\" : \"123.3micros\",\n"  
        assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);
                + "      \"time_in_nanos\" : 123356,\n"  
        BytesReference mutated;
        result = new ProfileResult("profileName", "some description", Map.of("key1", 12345678L), Map.of(), 12345678L, List.of());
                + "  \"description\" : \"some description\",\n"
    }
                randomNonNegativeLong()  
            87654321L,
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
                + "    \"key1\" : 1234567890\n"  
            builder.toString()
package org.opensearch.search.profile;
        Map<String, Long> breakdown = new HashMap<>();  
import java.io.IOException;  
                + "  \"type\" : \"someType\",\n"
                + "  \"description\" : \"some description\",\n"
/*
 * SPDX-License-Identifier: Apache-2.0
