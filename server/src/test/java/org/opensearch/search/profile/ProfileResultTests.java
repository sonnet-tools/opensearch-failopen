            breakdown.put(randomAlphaOfLengthBetween(5, 10), value);
                + "  },\n"
import org.opensearch.common.xcontent.XContentFactory;
    }
                + "  \"time_in_nanos\" : 12345678,\n"
                + "  \"time_in_nanos\" : 223456,\n"
            mutated = insertRandomFields(xContentType, originalBytes, excludeFilter, random());
        while (breakdown.size() < breakdownsSize) {
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
        breakdown.put("stuff", 10000L);
                + "  \"children\" : [\n"
                + "    \"b\" : \"bar\"\n"
                + "}",
                + "      \"time_in_nanos\" : 100,\n"
        ProfileResult profileResult = createTestItem(2, concurrentSegmentSearchEnabled);
        }
        assertEquals(123456L, (long) modifiedBreakdown.get("initialize_start_time"));
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under
import java.util.List;
            return new ProfileResult(type, description, breakdown, debug, randomNonNegativeLong(), children);
                + "  \"time\" : \"1.2s\",\n"
 * Licensed to Elasticsearch under one or more contributor
        );
/*
    public void testFromXContent() throws IOException {
        Map<String, Long> breakdown = new HashMap<>(breakdownsSize);
 * SPDX-License-Identifier: Apache-2.0
 */
                + "  \"description\" : \"some description\",\n"
 *
        int debugSize = randomIntBetween(0, 5);
                + "  }\n"
                + "}",
        }
        );
            );
        result = new ProfileResult("profileName", "some description", Map.of("key1", 1234567890L), Map.of(), 1234567890L, List.of());
        Map<String, Long> breakdown = new LinkedHashMap<>();
                + "  \"type\" : \"profileName\",\n"
import org.opensearch.core.xcontent.XContentParser;
                randomNonNegativeLong()
    public static ProfileResult createTestItem(int depth, boolean concurrentSegmentSearchEnabled) {
                + "      \"breakdown\" : {\n"
        assertEquals(
import java.util.LinkedHashMap;
        ProfileResult.removeStartTimeFields(modifiedBreakdown);
                + "  \"time_in_nanos\" : 1234,\n"
                + "    \"key1\" : 1234567890\n"
        assertEquals(
        assertEquals(654321L, (long) modifiedBreakdown.get("initialize"));
        );
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
        List<ProfileResult> children = new ArrayList<>(childrenSize);
                + "        \"key1\" : 123356\n"
        doFromXContentTestWithRandomFields(false, true);
 * Modifications Copyright OpenSearch Contributors. See
                + "  \"time_in_nanos\" : 223456,\n"
     * This test adds random fields and objects to the xContent rendered out to ensure we can parse it
                + "        \"key1\" : 100\n"
                + "  \"avg_slice_time\" : \"54.6ms\",\n"
        assertTrue(modifiedBreakdown.containsKey("initialize"));
        XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
                + "      \"type\" : \"child2\",\n"
        assertFalse(modifiedBreakdown.containsKey("initialize_start_time"));
                + "    \"key1\" : 123456,\n"
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        assertEquals(profileResult.getTime(), parsed.getTime());
                + "  \"time\" : \"1.2s\",\n"
                + "      \"breakdown\" : {\n"
                randomNonNegativeLong(),
                + "  \"description\" : \"some description\",\n"
                + "  \"type\" : \"profileName\",\n"
            "{\n"
                + "      \"type\" : \"child2\",\n"
 */
            parsed = ProfileResult.fromXContent(parser);
            builder.toString()
 * You may obtain a copy of the License at
        Map<String, Long> breakdown = new HashMap<>();
        assertEquals(3, modifiedBreakdown.size());
        ProfileResult result = new ProfileResult("someType", "some description", breakdown, debug, 223456L, children);
            builder.toString()
        doFromXContentTestWithRandomFields(false, false);
                + "  ]\n"
        assertEquals(profileResult.getAvgSliceTime(), parsed.getAvgSliceTime());
                + "    },\n"
                + "      }\n"
                + "        \"key1\" : 123356\n"
                randomNonNegativeLong(),
                + "      \"time\" : \"123.3micros\",\n"
                + "  \"type\" : \"someType\",\n"
                + "  \"description\" : \"some description\",\n"
                breakdown,
import org.opensearch.core.xcontent.XContentBuilder;
                type,
                + "      \"description\" : \"desc1\",\n"
        assertEquals(
import java.util.Map;
 * software distributed under the License is distributed on an
                + "  \"description\" : \"some description\",\n"
                + "      \"breakdown\" : {\n"
            "{\n"
 * KIND, either express or implied.  See the License for the
                + "      \"time_in_nanos\" : 123356,\n"
                || s.endsWith(ProfileResult.DEBUG.getPreferredName());
package org.opensearch.search.profile;
        int breakdownsSize = randomIntBetween(0, 5);
            builder.toString()
    public void testRemoveStartTimeFields() {
            "{\n"
    }
        assertTrue(modifiedBreakdown.containsKey("initialize_count"));
        Map<String, Object> debug = new LinkedHashMap<>();
                + "  \"debug\" : {\n"
 * specific language governing permissions and limitations
                + "    \"a\" : \"foo\",\n"
                + "        \"key1\" : 100\n"
    }
        }
        children.add(new ProfileResult("child1", "desc1", Map.of("key1", 100L), Map.of(), 100L, List.of()));
        assertEquals(
        XContentType xContentType = randomFrom(XContentType.values());
            builder.toString()
 * The OpenSearch Contributors require contributions made to
            12345678L,
 *
                + "    \"b\" : \"bar\"\n"
            debug.put(randomAlphaOfLength(5), randomAlphaOfLength(4));
            "profileName",
                + "  \"min_slice_time_in_nanos\" : 123,\n"
                + "      \"time_in_nanos\" : 100,\n"
                + "    {\n"
        );
                + "  \"min_slice_time\" : \"12.3ms\",\n"
                + "  \"type\" : \"profileName\",\n"
 * this work for additional information regarding copyright
                + "    \"key1\" : 1234567890\n"
     */
    public void testToXContent() throws IOException {
                + "      \"breakdown\" : {\n"
 * Unless required by applicable law or agreed to in writing,
        debug.put("b", "bar");
        }
        assertEquals(profileResult.getMaxSliceTime(), parsed.getMaxSliceTime());
 * this file be licensed under the Apache-2.0 license or a
            return new ProfileResult(
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
                + "    \"a\" : \"foo\",\n"
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
                + "  \"breakdown\" : {\n"
            assertNull(parser.nextToken());
        } else {
 */
                + "  \"time\" : \"223.4micros\",\n"
                + "    }\n"
        for (int i = 0; i < childrenSize; i++) {
                + "    \"stuff\" : 10000\n"
        BytesReference originalBytes = toShuffledXContent(profileResult, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
                + "  }\n"
                + "    \"key1\" : 123456,\n"
        } else {
        BytesReference mutated;
        String type = randomAlphaOfLengthBetween(5, 10);
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
        assertEquals(profileResult.getMinSliceTime(), parsed.getMinSliceTime());
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);
import org.opensearch.core.xcontent.ToXContent;
                + "    },\n"
                + "  \"breakdown\" : {\n"
                + "  \"time\" : \"12.3ms\",\n"
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);
            "{\n"
        String description = randomAlphaOfLengthBetween(5, 10);
                + "  },\n"
            "some description",
        if (concurrentSegmentSearchEnabled) {
     * back to be forward compatible with additions to the xContent
/*
                + "  }\n"
                + "  \"breakdown\" : {\n"
    private void doFromXContentTestWithRandomFields(boolean addRandomFields, boolean concurrentSegmentSearchEnabled) throws IOException {
import java.util.ArrayList;
 * compatible open source license.
                debug,
                + "  },\n"
            }
        while (debug.size() < debugSize) {
public class ProfileResultTests extends OpenSearchTestCase {
        assertEquals(1L, (long) modifiedBreakdown.get("initialize_count"));
    }
        );
 *
                + "  \"max_slice_time_in_nanos\" : 321,\n"
                + "  ]\n"
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
    public void testFromXContentWithRandomFields() throws IOException {
        if (addRandomFields) {
        List<ProfileResult> children = new ArrayList<>();
                + "    {\n"
 * the Apache License, Version 2.0 (the "License"); you may
        breakdown.put("key1", 123456L);
    }
            long value = randomNonNegativeLong();
import java.util.function.Predicate;
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {
                + "    {\n"
                + "  \"max_slice_time_in_nanos\" : 87654321,\n"
                + "      \"description\" : \"desc2\",\n"
        result = new ProfileResult("profileName", "some description", Map.of("key1", 12345678L), Map.of(), 12345678L, List.of());
                + "  \"avg_slice_time_in_nanos\" : 222,\n"
                value = value % 10000;
                + "      }\n"
 * license agreements. See the NOTICE file distributed with
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);
                + "  \"breakdown\" : {\n"
                + "  }\n"
        doFromXContentTestWithRandomFields(true, true);
                + "  \"description\" : \"some description\",\n"
            Predicate<String> excludeFilter = (s) -> s.endsWith(ProfileResult.BREAKDOWN.getPreferredName())
                randomNonNegativeLong(),
                + "      \"type\" : \"child1\",\n"
                + "  },\n"
                + "}",
        Map<String, Long> modifiedBreakdown = new LinkedHashMap<>(breakdown);
                + "  \"avg_slice_time_in_nanos\" : 54637281,\n"
                + "  \"debug\" : {\n"
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
                + "}",
import java.util.HashMap;
import org.opensearch.test.OpenSearchTestCase;
            List.of(),
            1234567890L,
            Map.of("key1", 1234567890L),
        assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);
    /**
        doFromXContentTestWithRandomFields(true, false);
            54637281L
                + "    }\n"
        int childrenSize = depth > 0 ? randomIntBetween(0, 1) : 0;
                + "  \"time_in_nanos\" : 1234567890,\n"
                + "    \"key1\" : 1234\n"
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
                + "  \"type\" : \"profileName\",\n"
                + "    \"stuff\" : 10000\n"
                // also often use "small" values in tests
                + "  \"time_in_nanos\" : 1234567890,\n"
                + "  \"max_slice_time\" : \"87.6ms\",\n"
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
import org.opensearch.core.common.bytes.BytesReference;
                + "      \"type\" : \"child1\",\n"
 * not use this file except in compliance with the License.
        result = new ProfileResult(
            87654321L,
            "{\n"
                + "      \"time\" : \"100nanos\",\n"
                + "  \"type\" : \"someType\",\n"
        assertEquals(
 * GitHub history for details.
                + "}",
                + "      \"time_in_nanos\" : 123356,\n"
        boolean humanReadable = randomBoolean();
            builder.toString()
                + "      }\n"
                + "      \"description\" : \"desc2\",\n"
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
        breakdown.put("initialize_count", 1L);
            if (randomBoolean()) {
        result = new ProfileResult("profileName", "some description", Map.of("key1", 1234L), Map.of(), 1234L, List.of(), 321L, 123L, 222L);
 * under the License.
        breakdown.put("initialize", 654321L);
            // "breakdown" and "debug" just consists of key/value pairs, we shouldn't add anything random there
        );
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);
            mutated = originalBytes;
        ProfileResult parsed;
            Map.of(),
            builder.toString()
                + "      }\n"
 *    http://www.apache.org/licenses/LICENSE-2.0
                + "}",
        breakdown.put("initialize_start_time", 123456L);
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertEquals(
            children.add(createTestItem(depth - 1, concurrentSegmentSearchEnabled));
                + "    \"key1\" : 12345678\n"
        }
        builder = XContentFactory.jsonBuilder().prettyPrint();
                + "  \"breakdown\" : {\n"
        debug.put("a", "foo");
            "{\n"
                + "      \"description\" : \"desc1\",\n"
                + "  \"min_slice_time_in_nanos\" : 12345678,\n"
                + "    {\n"
/*
                + "  \"description\" : \"some description\",\n"
                + "  \"breakdown\" : {\n"
import org.opensearch.common.xcontent.XContentType;
        children.add(new ProfileResult("child2", "desc2", Map.of("key1", 123356L), Map.of(), 123356L, List.of()));
        Map<String, Object> debug = new HashMap<>(debugSize);
                + "  \"children\" : [\n"
                children,
                description,
        );
}
