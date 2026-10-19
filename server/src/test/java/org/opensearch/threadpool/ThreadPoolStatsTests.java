                assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));
    public void testThreadPoolStatsToXContent() throws IOException {
import org.opensearch.common.xcontent.json.JsonXContent;
            .completed(6L)
/*
            .queue(2)
    public void testThreadPoolStatsSort() throws IOException {
        for (ThreadPoolStats.Stats stat : copy) {
import org.opensearch.core.common.io.stream.StreamInput;
        stats.add(defaultStats.name("m").threads(3).build());
        ThreadPoolStats.Stats s3 = builder.threads(2).build();
                assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
 *
    public void testStatsCompareToWithParallelism() {
import java.io.IOException;
            .queue(2)
        XContentBuilder builder = XContentFactory.jsonBuilder();
 * Licensed to Elasticsearch under one or more contributor
        Collections.sort(copy);
 *
import static org.hamcrest.Matchers.contains;
 * Modifications Copyright OpenSearch Contributors. See
        in.setVersion(Version.V_3_3_0);
            List<ThreadPoolStats.Stats> stats = new ArrayList<>();
        List<ThreadPoolStats.Stats> stats = new ArrayList<>();
                    token = parser.nextToken();
            .threads(1)
        builder.endObject();
        builder.startObject();
            .largest(5)
 * software distributed under the License is distributed on an
            .parallelism(8);
                    assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
        // Test with parallelism = -1 (should not output the field)
                assertNull(token);
                        ThreadPool.Names.FORCE_MERGE,
        builder = XContentFactory.jsonBuilder();
        assertTrue(json.contains("\"parallelism\":8"));
            .waitTimeNanos(7L)
            .largest(5)
        assertThat(threads, contains(-1, -1, 1, 2, 3, -1, -1));
            try (XContentBuilder builder = new XContentBuilder(MediaTypeRegistry.JSON.xContent(), os)) {
            .parallelism(-1);
        stats.add(defaultStats.name("z").threads(-1).build());
}
import org.opensearch.core.xcontent.MediaTypeRegistry;
                token = parser.nextToken();
            stats.add(defaultStats.name(ThreadPool.Names.WARMER).waitTimeNanos(-1L).build());
                        ThreadPool.Names.SAME,
        builder.startObject();
        assertTrue(s4.compareTo(s1) > 0);
                    parser.skipChildren();
        json = builder.toString();
 *    http://www.apache.org/licenses/LICENSE-2.0
            .build();
            .completed(0L)
import org.opensearch.common.xcontent.XContentFactory;
                assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
                        ThreadPool.Names.WARMER
            ThreadPoolStats.Stats.Builder defaultStats = new ThreadPoolStats.Stats.Builder().threads(-1)
        ThreadPoolStats.Stats s2 = builder.build();
            .parallelism(9)
                token = parser.nextToken();
    }
        assertTrue(s1.compareTo(s3) < 0);
    public void testStatsParallelismConstructorAndToXContent() throws IOException {
            .threads(1)
                XContentParser.Token token = parser.currentToken();
        String json = builder.toString();
            }
            .build();
        assertEquals(-1, statsIn.getParallelism());
                .active(0)
 * GitHub history for details.
        out.setVersion(Version.V_3_4_0);
            .waitTimeNanos(7L)
            .active(0)
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
            .largest(5)
            .waitTimeNanos(7L)
        assertEquals(2, stats.getQueue());
        List<Integer> threads = new ArrayList<>(copy.size());
        assertThat(names, contains("a", "d", "m", "m", "m", "t", "z"));
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;
            .threads(1)
        ThreadPoolStats.Stats stats = new ThreadPoolStats.Stats.Builder().name("test")
package org.opensearch.threadpool;
        ThreadPoolStats.Stats statsOut = new ThreadPoolStats.Stats.Builder().name("test")
                    token = parser.nextToken();
import static org.hamcrest.Matchers.equalTo;
            ThreadPoolStats threadPoolStats = new ThreadPoolStats(stats);
 */
            .rejected(4L)
                token = parser.nextToken();
public class ThreadPoolStatsTests extends OpenSearchTestCase {
                    names,
        List<String> names = new ArrayList<>(copy.size());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    }
                .largest(0)
        stats.add(defaultStats.name("m").threads(1).build());
import java.util.List;
        stats.add(defaultStats.name("t").threads(-1).build());
                    )
 * this file be licensed under the Apache-2.0 license or a
            .largest(0)
            .active(3)
            stats.add(defaultStats.name(ThreadPool.Names.SEARCH).waitTimeNanos(0L).build());
            .queue(2)
import java.util.ArrayList;
            .active(3)
        assertEquals(3, stats.getActive());
                    names.add(parser.currentName());
            .parallelism(-1)
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
        assertFalse(json.contains("parallelism"));
                        ThreadPool.Names.SEARCH,
import java.util.Collections;
        out.setVersion(Version.V_3_3_0);
                .parallelism(-1);
import org.opensearch.test.OpenSearchTestCase;
            stats.add(defaultStats.name(ThreadPool.Names.GENERIC).waitTimeNanos(-1L).build());
        ThreadPoolStats.Stats.Builder defaultStats = new ThreadPoolStats.Stats.Builder().queue(0)
            .rejected(0)
 * KIND, either express or implied.  See the License for the
        stats.add(defaultStats.name("d").threads(-1).build());
import org.opensearch.Version;
            .largest(5)
/*
        assertEquals(6L, stats.getCompleted());
            .active(3)
        ThreadPoolStats.Stats s4 = builder.name("b").build();
import org.opensearch.common.io.stream.BytesStreamOutput;
            .rejected(4L)
        try (BytesStreamOutput os = new BytesStreamOutput()) {
            names.add(stat.getName());
        assertEquals(1, stats.getThreads());
        assertEquals(9, statsIn.getParallelism());
        ThreadPoolStats.Stats s1 = builder.build();
import org.opensearch.core.xcontent.ToXContent;
        for (ThreadPoolStats.Stats stat : copy) {
                .queue(0)
            threads.add(stat.getThreads());
        ThreadPoolStats.Stats.Builder builder = new ThreadPoolStats.Stats.Builder().name("a")
        // Serialization for version < 3.4.0 (parallelism is not written, should be -1)
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
            .queue(2)
            .rejected(4L)
    }
        in.setVersion(Version.V_3_4_0);
            .active(3)
        assertEquals(4L, stats.getRejected());
        BytesStreamOutput out = new BytesStreamOutput();
            .completed(6L)
        }
        assertEquals(5, stats.getLargest());
            .completed(6L)
 * license agreements. See the NOTICE file distributed with
        StreamInput in = out.bytes().streamInput();
 * this work for additional information regarding copyright
        stats.add(defaultStats.name("a").threads(-1).build());
            .rejected(4L)
        assertEquals("test", stats.getName());
                }
            stats.add(defaultStats.name(ThreadPool.Names.SAME).waitTimeNanos(-1L).build());
                    contains(
    }
        statsOut.writeTo(out);
    public void testStatsGetters() {
        out = new BytesStreamOutput();
        assertEquals(8, stats.getParallelism());
            .completed(6L)
            .rejected(4L)
        ThreadPoolStats.Stats statsIn = new ThreadPoolStats.Stats(in);
                assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));
 * The OpenSearch Contributors require contributions made to
                );
                assertThat(
        // Test constructor and toXContent with parallelism set
import org.opensearch.core.xcontent.XContentParser;
                builder.startObject();
            .waitTimeNanos(0L)
            .parallelism(8)
        // Serialization for version >= 3.4.0 (parallelism is written and read)
        assertEquals(7L, stats.getWaitTimeNanos());
            .queue(2)
                .completed(0L)
 *
            .threads(1)
        }
        statsOut.writeTo(out);
        }
            .largest(5)
 * You may obtain a copy of the License at
            .threads(1)
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, os.bytes())) {
            .build();
    }
                while (token == XContentParser.Token.FIELD_NAME) {
 * specific language governing permissions and limitations
        builder.endObject();
        stats = new ThreadPoolStats.Stats.Builder().name("test")
        in = out.bytes().streamInput();
                builder.endObject();
            stats.add(defaultStats.name(ThreadPool.Names.FORCE_MERGE).waitTimeNanos(-1L).build());
        assertEquals(0, s1.compareTo(s2));
            .waitTimeNanos(7L)
                        ThreadPool.Names.GENERIC,
                .rejected(0)
                List<String> names = new ArrayList<>();
/*
 */
        statsIn = new ThreadPoolStats.Stats(in);
 * ownership. Elasticsearch licenses this file to you under
        stats.add(defaultStats.name("m").threads(2).build());
            }
            .parallelism(8)
                assertThat(parser.currentName(), equalTo(ThreadPoolStats.Fields.THREAD_POOL));
                token = parser.nextToken();
 */
                threadPoolStats.toXContent(builder, ToXContent.EMPTY_PARAMS);
            .completed(6L)
            .build();
            .active(3)
 * under the License.
            .waitTimeNanos(7L)
        ThreadPoolStats.Stats stats = new ThreadPoolStats.Stats.Builder().name("test")
    public void testStatsSerializationParallelismVersion() throws IOException {
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        List<ThreadPoolStats.Stats> copy = new ArrayList<>(stats);
