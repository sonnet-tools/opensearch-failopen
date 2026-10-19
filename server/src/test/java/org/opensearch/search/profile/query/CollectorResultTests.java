        List<CollectorResult> children = new ArrayList<>(size);
                sliceCount,  
        );
 */  
            );
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);
    }
                + "  \"children\" : [\n"  
import org.opensearch.common.xcontent.XContentType;
                reduceTime,
            // also often use relatively "small" values, otherwise we will mostly test huge longs
        assertEquals(
            CollectorResult parsed = CollectorResult.fromXContent(parser);  
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
 * Unless required by applicable law or agreed to in writing,
                + "      \"name\" : \"child2\",\n"
                + "}",
        }
                + "}",  
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
                + "}",  
                + "      \"time\" : \"100nanos\",\n"
import org.opensearch.test.OpenSearchTestCase;
        return new CollectorResult(name, reason, time, children);
        long minSliceTime = time;
 * SPDX-License-Identifier: Apache-2.0
                + "    },\n"  
                + "      \"time\" : \"123.3micros\",\n"
 * software distributed under the License is distributed on an
            123456789L,
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
        assertEquals(  
            123456789L,  
            "{\n"
                + "    }\n"
                + "}",
                children
        boolean humanReadable = randomBoolean();
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {
 */
        doFromXContentTestWithRandomFields(true, false);
                + "  \"name\" : \"collectorName\",\n"  
        long reduceTime = time;
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(  
        doFromXContentTestWithRandomFields(false, false);
                + "  \"time\" : \"12.3ms\",\n"
    private void doFromXContentTestWithRandomFields(boolean addRandomFields, boolean concurrentSearchEnabled) throws IOException {
                + "  \"reason\" : \"some reason\",\n"  
            "{\n"
        }
                + "    {\n"  
 * under the License.  
 *  
        int sliceCount = randomIntBetween(1, 10);  
        result = new CollectorResult("collectorName", "some reason", 1234567890L, Collections.emptyList());
            }  
import java.util.ArrayList;
                + "  \"reason\" : \"some reason\",\n"  
                + "      \"time_in_nanos\" : 123356\n"
                + "    {\n"
        doFromXContentTestWithRandomFields(false, true);  
    }  
            Collections.emptyList()
        children.add(new CollectorResult("child2", "reason1", 123356L, Collections.emptyList()));  
                + "  \"time\" : \"123.4ms\",\n"
        );  
            123456789L,  
        String name = randomAlphaOfLengthBetween(5, 10);
                + "  \"time\" : \"1.2s\",\n"
                + "  ]\n"
            123456789L,
                + "  \"name\" : \"collectorName\",\n"
        long avgSliceTime = time;
 * Modifications Copyright OpenSearch Contributors. See
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * the Apache License, Version 2.0 (the "License"); you may
                + "      \"reason\" : \"reason1\",\n"  
        assertEquals(  
import org.opensearch.core.xcontent.ToXContent;
 *
        );  
 * Licensed to Elasticsearch under one or more contributor  
        );
import org.opensearch.common.xcontent.XContentFactory;
 *
        result = new CollectorResult("collectorName", "some reason", 12345678L, Collections.emptyList());  
            builder.toString()  
 * this work for additional information regarding copyright
        children.add(new CollectorResult("child1", "reason1", 100L, Collections.emptyList()));
                + "  \"name\" : \"collectorName\",\n"
                + "  \"time_in_nanos\" : 123456789,\n"
        String reason = randomAlphaOfLengthBetween(5, 10);
                + "  \"name\" : \"collectorName\",\n"  
                "some reason",  
                + "      \"time_in_nanos\" : 100\n"
        doFromXContentTestWithRandomFields(true, true);
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        result = new CollectorResult(
                + "  \"max_slice_time_in_nanos\" : 123456789,\n"
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);  
    public void testFromXContent() throws IOException {
                + "      \"name\" : \"child1\",\n"
            mutated = originalBytes;
        long maxSliceTime = time;  
 * license agreements. See the NOTICE file distributed with
public class CollectorResultTests extends OpenSearchTestCase {
                + "  \"reduce_time_in_nanos\" : 123456789,\n"  
        }  
        }  
                + "      \"time_in_nanos\" : 100\n"
                + "  \"min_slice_time_in_nanos\" : 123456789,\n"
        BytesReference mutated;
    }
 * You may obtain a copy of the License at  
            assertNull(parser.nextToken());
            assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);
import java.io.IOException;  
 * compatible open source license.
        XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
            builder.toString()
    }
        );
/*  
 * KIND, either express or implied.  See the License for the
                + "  ]\n"
        BytesReference originalBytes = toShuffledXContent(collectorResult, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);  
                children.add(createTestItem(depth - 1, concurrentSearchEnabled));
            for (int i = 0; i < size; i++) {
import org.opensearch.core.common.bytes.BytesReference;  
            "{\n"
                avgSliceTime,
 * this file be licensed under the Apache-2.0 license or a
            "{\n"
                + "      \"reason\" : \"reason1\",\n"
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);
                + "  \"reason\" : \"some reason\",\n"
import org.opensearch.core.xcontent.XContentBuilder;
                + "  \"name\" : \"defaultCollectorManager\",\n"
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        long time = randomNonNegativeLong();  
                + "    {\n"
                + "  \"time_in_nanos\" : 1234567890\n"  
                + "      \"reason\" : \"reason1\",\n"  
    public static CollectorResult createTestItem(int depth, boolean concurrentSearchEnabled) {  
            "defaultCollectorManager",  
 * GitHub history for details.
                + "  \"time\" : \"123.4micros\",\n"
/*  
                + "  \"reason\" : \"some reason\",\n"  
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);
                + "}",
 * The OpenSearch Contributors require contributions made to  
}  
import org.opensearch.core.xcontent.XContentParser;  
                + "      \"name\" : \"child2\",\n"
        List<CollectorResult> children = new ArrayList<>();
            builder.toString()
            "{\n"
import java.util.Collections;
 * specific language governing permissions and limitations
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
                + "  \"reason\" : \"some reason\",\n"
                + "      \"reason\" : \"reason1\",\n"  
            builder.toString()
        } else {
                minSliceTime,
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
        builder = XContentFactory.jsonBuilder().prettyPrint().humanReadable(true);
                + "  \"time_in_nanos\" : 12345678\n"
                + "    },\n"
            mutated = insertRandomFields(xContentType, originalBytes, null, random());  
        if (addRandomFields) {
        if (randomBoolean()) {
/*
    }
            "some reason",
                + "      \"name\" : \"child1\",\n"
    public void testFromXContentWithRandomFields() throws IOException {  
                "defaultCollectorManager",
 *    http://www.apache.org/licenses/LICENSE-2.0
                + "  \"avg_slice_time_in_nanos\" : 123456789,\n"  
                maxSliceTime,  
                + "  \"time_in_nanos\" : 123456,\n"
        XContentType xContentType = randomFrom(XContentType.values());
                + "  \"slice_count\" : 3\n"
                time,
                + "      \"time_in_nanos\" : 123356\n"  
                + "    {\n"
            3,
package org.opensearch.search.profile.query;
        int size = randomIntBetween(0, 5);
            time = time % 100000;  
        result.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * not use this file except in compliance with the License.
        if (concurrentSearchEnabled) {  
 */  
            builder.toString()  
    public void testToXContent() throws IOException {  
        assertEquals(
                + "    }\n"  
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
        CollectorResult result = new CollectorResult("collectorName", "some reason", 123456L, children);
            123456789L,
        CollectorResult collectorResult = createTestItem(1, concurrentSearchEnabled);  
                + "  \"time_in_nanos\" : 123456,\n"
import java.util.List;  
            return new CollectorResult(
        if (depth > 0) {  
        );
                + "  \"children\" : [\n"  
