 * You may obtain a copy of the License at
            123456789L,
        );
                + "}",
            123456789L,
        );
            );
                + "    }\n"
 *
import org.opensearch.core.xcontent.XContentBuilder;
        CollectorResult collectorResult = createTestItem(1, concurrentSearchEnabled);
                + "  \"reason\" : \"some reason\",\n"
        return new CollectorResult(name, reason, time, children);
import org.opensearch.test.OpenSearchTestCase;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
 */
            builder.toString()
        if (concurrentSearchEnabled) {
                children.add(createTestItem(depth - 1, concurrentSearchEnabled));
            "{\n"
 * not use this file except in compliance with the License.
        }
                + "  \"name\" : \"collectorName\",\n"
        if (randomBoolean()) {
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
                + "  \"reason\" : \"some reason\",\n"
            builder.toString()
import org.opensearch.core.xcontent.ToXContent;
 *
        children.add(new CollectorResult("child1", "reason1", 100L, Collections.emptyList()));
                + "  ]\n"
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
                + "      \"time\" : \"123.3micros\",\n"
import java.util.ArrayList;
    }
                + "  \"time\" : \"1.2s\",\n"
 * Licensed to Elasticsearch under one or more contributor
                avgSliceTime,
                + "    {\n"
                + "      \"name\" : \"child2\",\n"
            mutated = originalBytes;
        XContentType xContentType = randomFrom(XContentType.values());
                + "  ]\n"
                + "  \"name\" : \"collectorName\",\n"
                + "  \"reason\" : \"some reason\",\n"
            123456789L,
                + "  \"reason\" : \"some reason\",\n"
                sliceCount,
        result = new CollectorResult("collectorName", "some reason", 1234567890L, Collections.emptyList());
            "{\n"
        String reason = randomAlphaOfLengthBetween(5, 10);
    public static CollectorResult createTestItem(int depth, boolean concurrentSearchEnabled) {
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {
import java.io.IOException;
                minSliceTime,
                + "      \"time\" : \"100nanos\",\n"
                + "}",
        }
    }
 *
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        }
                + "  \"max_slice_time_in_nanos\" : 123456789,\n"
            123456789L,
 * license agreements. See the NOTICE file distributed with
    }
    private void doFromXContentTestWithRandomFields(boolean addRandomFields, boolean concurrentSearchEnabled) throws IOException {
                + "      \"time_in_nanos\" : 100\n"
                + "      \"time_in_nanos\" : 123356\n"
                "defaultCollectorManager",
        assertEquals(
 * this work for additional information regarding copyright
package org.opensearch.search.profile.query;
public class CollectorResultTests extends OpenSearchTestCase {
        doFromXContentTestWithRandomFields(true, false);
        } else {
            "defaultCollectorManager",
        long reduceTime = time;
 * compatible open source license.
            for (int i = 0; i < size; i++) {
 * this file be licensed under the Apache-2.0 license or a
                reduceTime,
                + "  \"reason\" : \"some reason\",\n"
        BytesReference originalBytes = toShuffledXContent(collectorResult, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
        List<CollectorResult> children = new ArrayList<>(size);
    public void testToXContent() throws IOException {
                + "      \"name\" : \"child2\",\n"
            time = time % 100000;
            builder.toString()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
}
import org.opensearch.core.common.bytes.BytesReference;
            return new CollectorResult(
                + "    },\n"
                + "    {\n"
            }
 * KIND, either express or implied.  See the License for the
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
            mutated = insertRandomFields(xContentType, originalBytes, null, random());
 * specific language governing permissions and limitations
                + "  \"name\" : \"collectorName\",\n"
        long time = randomNonNegativeLong();
                + "  \"reduce_time_in_nanos\" : 123456789,\n"
        }
            3,
 * software distributed under the License is distributed on an
        CollectorResult result = new CollectorResult("collectorName", "some reason", 123456L, children);
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);
        doFromXContentTestWithRandomFields(true, true);
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
                + "      \"reason\" : \"reason1\",\n"
import org.opensearch.common.xcontent.XContentFactory;
                + "  \"name\" : \"collectorName\",\n"
            "{\n"
        );
        long minSliceTime = time;
                + "      \"reason\" : \"reason1\",\n"
            "some reason",
    public void testFromXContent() throws IOException {
                + "  \"time\" : \"123.4ms\",\n"
                + "  \"min_slice_time_in_nanos\" : 123456789,\n"
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertEquals(
            123456789L,
                + "    {\n"
                + "  \"name\" : \"defaultCollectorManager\",\n"
    public void testFromXContentWithRandomFields() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
        );
                + "}",
                + "  \"children\" : [\n"
        doFromXContentTestWithRandomFields(false, false);
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
            CollectorResult parsed = CollectorResult.fromXContent(parser);
/*
            Collections.emptyList()
                + "  \"slice_count\" : 3\n"
                + "      \"reason\" : \"reason1\",\n"
        int size = randomIntBetween(0, 5);
            "{\n"
 */
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
        List<CollectorResult> children = new ArrayList<>();
                + "      \"name\" : \"child1\",\n"
                + "    {\n"
                + "      \"time_in_nanos\" : 123356\n"
            builder.toString()
        );
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
                + "      \"time_in_nanos\" : 100\n"
                + "}",
 * ownership. Elasticsearch licenses this file to you under
                children
                + "  \"time_in_nanos\" : 123456789,\n"
import org.opensearch.core.xcontent.XContentParser;
                + "}",
                + "  \"children\" : [\n"
                maxSliceTime,
        result = new CollectorResult(
        doFromXContentTestWithRandomFields(false, true);
        assertEquals(
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (depth > 0) {
        BytesReference mutated;
/*
 * under the License.
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);
        );
                + "      \"reason\" : \"reason1\",\n"
        assertEquals(
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        int sliceCount = randomIntBetween(1, 10);
        XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
        String name = randomAlphaOfLengthBetween(5, 10);
/*
import org.opensearch.common.xcontent.XContentType;
    }
        if (addRandomFields) {
                + "  \"time_in_nanos\" : 1234567890\n"
            // also often use relatively "small" values, otherwise we will mostly test huge longs
                + "  \"time_in_nanos\" : 12345678\n"
                + "  \"time\" : \"12.3ms\",\n"
                + "    }\n"
                + "  \"time\" : \"123.4micros\",\n"
 * The OpenSearch Contributors require contributions made to
 */
                + "  \"time_in_nanos\" : 123456,\n"
        long maxSliceTime = time;
                time,
                + "      \"name\" : \"child1\",\n"
import java.util.List;
import java.util.Collections;
                + "    },\n"
                + "  \"time_in_nanos\" : 123456,\n"
            assertNull(parser.nextToken());
 * GitHub history for details.
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);
            builder.toString()
        assertEquals(
        }
        result = new CollectorResult("collectorName", "some reason", 12345678L, Collections.emptyList());
    }
        long avgSliceTime = time;
            "{\n"
        boolean humanReadable = randomBoolean();
 * SPDX-License-Identifier: Apache-2.0
                + "  \"avg_slice_time_in_nanos\" : 123456789,\n"
            assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);
                "some reason",
        children.add(new CollectorResult("child2", "reason1", 123356L, Collections.emptyList()));
