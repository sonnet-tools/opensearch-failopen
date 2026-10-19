            LinkedHashMap<String, Object> initialMap = (LinkedHashMap<String, Object>) parser.mapOrdered();
         * "funny" way of calling where the value is null. This once  
import java.util.Collections;  
                try (XContentParser parser = createParser(xContentType.xContent(), bytes)) {  
            expectThrows(IllegalArgumentException.class, () -> {});
         * But going from text back to millis back to text should
import java.util.List;  
            List<String> expectedInnerKeys1 = Arrays.asList("inner1", "inner2", "inner3");
         */  
import org.opensearch.common.time.DateFormatter;
 * not use this file except in compliance with the License.
         * Make sure it doesn't crash trying to format some dates and
        String formattedAgain = formatter.formatMillis(formatter.parseMillis(formatted));
                initialMap = (LinkedHashMap<String, Object>) parser.mapOrdered();
                        builder.field("inner1", "value1");  
                List<String> shuffledKeys = new ArrayList<>(shuffledMap.keySet());
import java.util.concurrent.atomic.AtomicInteger;  
                assertEquals("both maps should contain the same mappings", initialMap, shuffledMap);
            Set<List<String>> distinctTopLevelKeys = new HashSet<>();  
import org.opensearch.core.xcontent.XContentParser;
            expectThrows(IllegalArgumentException.class, () -> { throw new IllegalStateException("bad state"); });
            // out of 10 shuffling runs we expect to have at least more than 1 distinct output for both top level keys and inner object2
         * information because not all date formats spit out milliseconds.
            for (int i = 0; i < 10; i++) {
                    }  
        XContentType xContentType = randomFrom(XContentType.values());
                    try (XContentBuilder shuffledBuilder = shuffleXContent(parser, randomBoolean(), "object1")) {
    }
                            assertEquals("both maps should contain the same mappings", initialMap, shuffledMap);
                            distinctInnerKeys2.add(actualInnerKeys2);
    }
 * compatible open source license.
    public void testRandomUniqueNotUnique() {
        // "normal" way of calling where the value is not null
    }  
        XContentType xContentType = randomFrom(XContentType.values());  
        String formatted = formatter.formatMillis(randomLongBetween(0, 2_000_000_000_000L));
        assumeTrue("requires running tests without Gradle", System.getProperty("tests.gradle") == null);  
         * had a unique behavior but at this point `null` acts just
        BytesReference source = RandomObjects.randomSource(random(), xContentType, 5);  
                            List<String> shuffledKeys = new ArrayList<>(shuffledMap.keySet());
import org.opensearch.test.OpenSearchTestCase;  
    public void testRandomUniqueNormalUsageAlwayMoreThanOne() {
                builder.field("field1", "value1");
        }
            fail("expected assertion error");  
                        builder.field("inner3", "value3");
 * The OpenSearch Contributors require contributions made to  
        try (XContentParser parser = createParser(xContentType.xContent(), source)) {
        }
                        builder.field("inner4", "value4");  
                            assertEquals("object1 should have been left untouched", expectedInnerKeys1, actualInnerKeys1);
                        builder.field("inner6", "value6");
        assertNotEquals(bad, (int) randomValueOtherThan(bad, OpenSearchTestCase::randomInt));  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> { throw new IllegalArgumentException("bad arg"); });
 * Unless required by applicable law or agreed to in writing,
                        builder.field("inner2", "value2");
                {  
            assertThat(distinctTopLevelKeys.size(), greaterThan(1));  
        assertNotNull(randomValueOtherThan(null, usuallyNull));
        /*
    public void testBasePortGradle() {
            }  
                        try (XContentParser shuffledParser = createParser(shuffledBuilder)) {
                    builder.startObject("object2");
            assertEquals("Expected exception IllegalArgumentException but no exception was thrown", assertFailed.getMessage());  
import static org.hamcrest.Matchers.equalTo;
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(randomUnique(() -> 1, 10), hasSize(1));  
            assertNull(assertFailed.getCause());
 */
            fail("expected assertion error");  
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/61496")
    }
    }  
        assertThat(randomUnique(i::incrementAndGet, 100), hasSize(100));
            assertEquals(
import org.opensearch.core.common.bytes.BytesReference;  
 * this file be licensed under the Apache-2.0 license or a
        int bad = randomInt();
 * Licensed to Elasticsearch under one or more contributor  
    public void testRandomUniqueTotallyUnique() {  
 */  
}
        } catch (AssertionFailedError assertFailed) {
                builder.field("field2", "value2");
            assertThat(distinctKeys.size(), greaterThan(1));
import java.util.HashSet;
                assertFailed.getMessage()
         */  
        try {
import org.opensearch.test.RandomObjects;
            assertEquals("bad state", assertFailed.getCause().getMessage());
        assertThat(OpenSearchTestCase.TEST_WORKER_VM_ID, not(equals(OpenSearchTestCase.DEFAULT_TEST_WORKER_ID)));
        Supplier<Object> usuallyNull = () -> usually() ? null : randomInt();
    }
            // out of 10 shuffling runs we expect to have at least more than 1 distinct output.
    }  
                "Unexpected exception type, expected IllegalArgumentException but got java.lang.IllegalStateException: bad state",  
    public void testBasePortIDE() {
        assumeTrue("requires running tests with Gradle", System.getProperty("tests.gradle") != null);  
        // Gradle worker IDs are 1 based
 *
            assertNotNull(assertFailed.getCause());  
            Set<List<String>> distinctKeys = new HashSet<>();
            }  
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
        } catch (AssertionFailedError assertFailed) {
         * be fine!
import java.util.Map;
    public void testShuffleXContentExcludeFields() throws IOException {
                    }  
                }
            {  
 * license agreements. See the NOTICE file distributed with
                            Map<String, Object> innerMap1 = (Map<String, Object>) shuffledMap.get("object1");
        assertThat(randomUnique(() -> randomAlphaOfLengthBetween(1, 20), 10), hasSize(greaterThan(0)));  
                            List<String> actualInnerKeys1 = new ArrayList<>(innerMap1.keySet());  
        assumeTrue("requires running tests with Gradle", System.getProperty("tests.gradle") != null);  
 * You may obtain a copy of the License at  
public class OpenSearchTestCaseTests extends OpenSearchTestCase {
            final LinkedHashMap<String, Object> initialMap;  
                    }
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Arrays;
    }  
 *  
                        }  
                    {
 * Modifications Copyright OpenSearch Contributors. See
/*  
                }
    public void testExpectThrows() {  
                    {
            assertThat(distinctInnerKeys2.size(), greaterThan(1));
            BytesReference bytes = BytesReference.bytes(builder);
            builder.endObject();
                distinctKeys.add(shuffledKeys);  
 * specific language governing permissions and limitations
    public void testShuffleMap() throws IOException {
import java.util.LinkedHashMap;
        }
                            @SuppressWarnings("unchecked")
            builder.startObject();
        AtomicInteger i = new AtomicInteger();
 * ownership. Elasticsearch licenses this file to you under  
import java.util.function.Supplier;
import org.opensearch.common.xcontent.XContentType;
import static org.hamcrest.Matchers.not;
            }
package org.opensearch.test.test;
    }
/*  
 *
                    builder.endObject();
        assertEquals("bad arg", e.getMessage());
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(10300, OpenSearchTestCase.getBasePort());
            }  
        assertNotEquals(10300, OpenSearchTestCase.getBasePort());
import org.opensearch.core.xcontent.XContentBuilder;
         * Interestingly, round tripping through a string *can* lose
                            @SuppressWarnings("unchecked")
    public void testRandomDateFormatterPattern() {
                            Map<String, Object> shuffledMap = shuffledParser.mapOrdered();  
import static org.hamcrest.Matchers.hasSize;
    public void testRandomValueOtherThan() {  
        assertThat(formattedAgain, equalTo(formatted));  
 *     http://www.apache.org/licenses/LICENSE-2.0
         * Hell, not all of them spit out the time of day at all!  
        DateFormatter formatter = DateFormatter.forPattern(randomDateFormatterPattern());  
    public void testWorkerSystemProperty() {
                        builder.field("inner5", "value5");
        }
                            Map<String, Object> innerMap2 = (Map<String, Object>) shuffledMap.get("object2");  
                LinkedHashMap<String, Object> shuffledMap = shuffleMap(initialMap, Collections.emptySet());  
        /*
                    builder.endObject();
                {  
import java.io.IOException;  
            Set<List<String>> distinctInnerKeys2 = new HashSet<>();
    }  
            for (int i = 0; i < 10; i++) {
 * under the License.  
import static org.hamcrest.Matchers.greaterThan;  
                            distinctTopLevelKeys.add(shuffledKeys);  
 * software distributed under the License is distributed on an
            // This is to make sure that we actually do the shuffling  
 * GitHub history for details.
 * this work for additional information regarding copyright
         * like any other value.
import java.util.Set;
 * KIND, either express or implied.  See the License for the
                    builder.startObject("object1");
            );
            try (XContentParser parser = createParser(xContentType.xContent(), bytes)) {
        try {
import junit.framework.AssertionFailedError;  
                            List<String> actualInnerKeys2 = new ArrayList<>(innerMap2.keySet());
                }
    }  
         * that round tripping through millis doesn't lose any information.  
/*
import java.util.ArrayList;
