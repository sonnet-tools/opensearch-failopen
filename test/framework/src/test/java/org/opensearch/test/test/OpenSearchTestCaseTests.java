        String formatted = formatter.formatMillis(randomLongBetween(0, 2_000_000_000_000L));
    }
        AtomicInteger i = new AtomicInteger();
 */
        assertNotEquals(bad, (int) randomValueOtherThan(bad, OpenSearchTestCase::randomInt));
        try {
        assertThat(formattedAgain, equalTo(formatted));
        /*
                        builder.field("inner4", "value4");
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
    }
    public void testRandomUniqueNormalUsageAlwayMoreThanOne() {
import org.opensearch.common.time.DateFormatter;
        // "normal" way of calling where the value is not null
import org.opensearch.test.RandomObjects;
    }
    public void testExpectThrows() {
 * Licensed to Elasticsearch under one or more contributor
                initialMap = (LinkedHashMap<String, Object>) parser.mapOrdered();
    public void testShuffleMap() throws IOException {
/*
            LinkedHashMap<String, Object> initialMap = (LinkedHashMap<String, Object>) parser.mapOrdered();
    public void testWorkerSystemProperty() {
                        builder.field("inner1", "value1");
                        builder.field("inner5", "value5");
        }
            assertEquals(
        assertEquals(10300, OpenSearchTestCase.getBasePort());
                            List<String> shuffledKeys = new ArrayList<>(shuffledMap.keySet());
                distinctKeys.add(shuffledKeys);
                        }
            }
                            Map<String, Object> shuffledMap = shuffledParser.mapOrdered();
                            List<String> actualInnerKeys2 = new ArrayList<>(innerMap2.keySet());
    public void testRandomDateFormatterPattern() {
         * Make sure it doesn't crash trying to format some dates and
 *
            Set<List<String>> distinctInnerKeys2 = new HashSet<>();
        }
            Set<List<String>> distinctKeys = new HashSet<>();
            assertEquals("Expected exception IllegalArgumentException but no exception was thrown", assertFailed.getMessage());
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
public class OpenSearchTestCaseTests extends OpenSearchTestCase {
                }
                }
                {
         * Hell, not all of them spit out the time of day at all!
import java.util.ArrayList;
                        builder.field("inner3", "value3");
                        builder.field("inner2", "value2");
            BytesReference bytes = BytesReference.bytes(builder);
        }
import org.opensearch.common.xcontent.XContentType;
        XContentType xContentType = randomFrom(XContentType.values());
import java.util.HashSet;
        }
 * GitHub history for details.
                    builder.startObject("object1");
                    {
            assertEquals("bad state", assertFailed.getCause().getMessage());
        assertNotNull(randomValueOtherThan(null, usuallyNull));
         * Interestingly, round tripping through a string *can* lose
        assertThat(randomUnique(i::incrementAndGet, 100), hasSize(100));
            builder.startObject();
import java.util.List;
/*
        assertThat(OpenSearchTestCase.TEST_WORKER_VM_ID, not(equals(OpenSearchTestCase.DEFAULT_TEST_WORKER_ID)));
 *
            fail("expected assertion error");
                    builder.startObject("object2");
            assertThat(distinctInnerKeys2.size(), greaterThan(1));
import java.util.function.Supplier;
        assertThat(randomUnique(() -> randomAlphaOfLengthBetween(1, 20), 10), hasSize(greaterThan(0)));
            }
 * The OpenSearch Contributors require contributions made to
 * software distributed under the License is distributed on an
            expectThrows(IllegalArgumentException.class, () -> {});
                    builder.endObject();
    public void testShuffleXContentExcludeFields() throws IOException {
        try (XContentParser parser = createParser(xContentType.xContent(), source)) {
         * But going from text back to millis back to text should
 */
        try {
 * compatible open source license.
    }
        assumeTrue("requires running tests with Gradle", System.getProperty("tests.gradle") != null);
import java.util.Set;
            assertNull(assertFailed.getCause());
                LinkedHashMap<String, Object> shuffledMap = shuffleMap(initialMap, Collections.emptySet());
import java.util.concurrent.atomic.AtomicInteger;
    }
            assertNotNull(assertFailed.getCause());
            try (XContentParser parser = createParser(xContentType.xContent(), bytes)) {
         */
                            distinctTopLevelKeys.add(shuffledKeys);
        } catch (AssertionFailedError assertFailed) {
            fail("expected assertion error");
         * that round tripping through millis doesn't lose any information.
                            @SuppressWarnings("unchecked")
 * You may obtain a copy of the License at
                    builder.endObject();
 * specific language governing permissions and limitations
                    try (XContentBuilder shuffledBuilder = shuffleXContent(parser, randomBoolean(), "object1")) {
                            Map<String, Object> innerMap1 = (Map<String, Object>) shuffledMap.get("object1");
         * be fine!
        assertEquals("bad arg", e.getMessage());
import static org.hamcrest.Matchers.hasSize;
        Supplier<Object> usuallyNull = () -> usually() ? null : randomInt();
        XContentType xContentType = randomFrom(XContentType.values());
            final LinkedHashMap<String, Object> initialMap;
                            assertEquals("object1 should have been left untouched", expectedInnerKeys1, actualInnerKeys1);
        assertNotEquals(10300, OpenSearchTestCase.getBasePort());
            // This is to make sure that we actually do the shuffling
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;
            Set<List<String>> distinctTopLevelKeys = new HashSet<>();
    public void testBasePortGradle() {
        assumeTrue("requires running tests with Gradle", System.getProperty("tests.gradle") != null);
 * the Apache License, Version 2.0 (the "License"); you may
            for (int i = 0; i < 10; i++) {
                }
import static org.hamcrest.Matchers.greaterThan;
                            @SuppressWarnings("unchecked")
                        try (XContentParser shuffledParser = createParser(shuffledBuilder)) {
    }
                    {
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    }
import static org.hamcrest.Matchers.equalTo;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> { throw new IllegalArgumentException("bad arg"); });
import java.util.Arrays;
 * license agreements. See the NOTICE file distributed with
                            assertEquals("both maps should contain the same mappings", initialMap, shuffledMap);
        assertThat(randomUnique(() -> 1, 10), hasSize(1));
         */
            List<String> expectedInnerKeys1 = Arrays.asList("inner1", "inner2", "inner3");
 */
         * like any other value.
         * "funny" way of calling where the value is null. This once
/*
    }
            {
        int bad = randomInt();
 * this file be licensed under the Apache-2.0 license or a
            // out of 10 shuffling runs we expect to have at least more than 1 distinct output for both top level keys and inner object2
            }
 *
    }
                            distinctInnerKeys2.add(actualInnerKeys2);
import org.opensearch.core.xcontent.XContentParser;
        BytesReference source = RandomObjects.randomSource(random(), xContentType, 5);
                assertEquals("both maps should contain the same mappings", initialMap, shuffledMap);
import java.util.LinkedHashMap;
 * this work for additional information regarding copyright
            expectThrows(IllegalArgumentException.class, () -> { throw new IllegalStateException("bad state"); });
        // Gradle worker IDs are 1 based
                builder.field("field2", "value2");
    public void testRandomUniqueTotallyUnique() {
import junit.framework.AssertionFailedError;
            for (int i = 0; i < 10; i++) {
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
         * information because not all date formats spit out milliseconds.
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/61496")
                {
         * had a unique behavior but at this point `null` acts just
                            Map<String, Object> innerMap2 = (Map<String, Object>) shuffledMap.get("object2");
                List<String> shuffledKeys = new ArrayList<>(shuffledMap.keySet());
        DateFormatter formatter = DateFormatter.forPattern(randomDateFormatterPattern());
            builder.endObject();
            assertThat(distinctKeys.size(), greaterThan(1));
import org.opensearch.core.xcontent.XContentBuilder;
        } catch (AssertionFailedError assertFailed) {
import java.util.Collections;
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testRandomUniqueNotUnique() {
 * under the License.
                    }
                try (XContentParser parser = createParser(xContentType.xContent(), bytes)) {
                            List<String> actualInnerKeys1 = new ArrayList<>(innerMap1.keySet());
            // out of 10 shuffling runs we expect to have at least more than 1 distinct output.
            );
    public void testBasePortIDE() {
                builder.field("field1", "value1");
import static org.hamcrest.Matchers.not;
import org.opensearch.core.common.bytes.BytesReference;
        String formattedAgain = formatter.formatMillis(formatter.parseMillis(formatted));
        assumeTrue("requires running tests without Gradle", System.getProperty("tests.gradle") == null);
            assertThat(distinctTopLevelKeys.size(), greaterThan(1));
                        builder.field("inner6", "value6");
    }
    public void testRandomValueOtherThan() {
                    }
 * ownership. Elasticsearch licenses this file to you under
                "Unexpected exception type, expected IllegalArgumentException but got java.lang.IllegalStateException: bad state",
import java.util.Map;
    }
 * not use this file except in compliance with the License.
            }
                assertFailed.getMessage()
package org.opensearch.test.test;
        /*
