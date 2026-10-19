        String json = builder.toString();
        List<ThreadPoolStats.Stats> copy = new ArrayList<>(stats);
 *    http://www.apache.org/licenses/LICENSE-2.0
            .queue(2)  
            stats.add(defaultStats.name(ThreadPool.Names.SEARCH).waitTimeNanos(0L).build());
                .parallelism(-1);  
import static org.hamcrest.Matchers.equalTo;  
        stats.add(defaultStats.name("m").threads(2).build());
        StreamInput in = out.bytes().streamInput();
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, os.bytes())) {
                token = parser.nextToken();  
            .completed(0L)  
                .active(0)
import java.io.IOException;  
                    parser.skipChildren();
    }  
    }
import static org.hamcrest.Matchers.contains;
                    assertThat(token, equalTo(XContentParser.Token.START_OBJECT));  
                assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));
                while (token == XContentParser.Token.FIELD_NAME) {
/*
package org.opensearch.threadpool;
    public void testThreadPoolStatsToXContent() throws IOException {
import java.util.List;  
                }
            .largest(5)
        assertThat(threads, contains(-1, -1, 1, 2, 3, -1, -1));  
        ThreadPoolStats.Stats s4 = builder.name("b").build();  
 * SPDX-License-Identifier: Apache-2.0
            .parallelism(8)
        stats.add(defaultStats.name("d").threads(-1).build());  
import java.util.ArrayList;
            threads.add(stat.getThreads());
        in.setVersion(Version.V_3_3_0);  
 *
            .rejected(4L)  
            stats.add(defaultStats.name(ThreadPool.Names.WARMER).waitTimeNanos(-1L).build());
                    token = parser.nextToken();  
            .build();
            .parallelism(9)  
            .rejected(0)
            ThreadPoolStats threadPoolStats = new ThreadPoolStats(stats);
        assertEquals("test", stats.getName());  
 * Unless required by applicable law or agreed to in writing,
            .active(3)
            .parallelism(8);
    }  
            .waitTimeNanos(7L)  
 * ownership. Elasticsearch licenses this file to you under  
public class ThreadPoolStatsTests extends OpenSearchTestCase {
        }
                        ThreadPool.Names.SAME,
        in = out.bytes().streamInput();
 * under the License.  
        ThreadPoolStats.Stats stats = new ThreadPoolStats.Stats.Builder().name("test")
                    names.add(parser.currentName());  
                token = parser.nextToken();
        stats.add(defaultStats.name("z").threads(-1).build());  
                .completed(0L)
 * Modifications Copyright OpenSearch Contributors. See
            ThreadPoolStats.Stats.Builder defaultStats = new ThreadPoolStats.Stats.Builder().threads(-1)  
import org.opensearch.common.xcontent.json.JsonXContent;
        statsIn = new ThreadPoolStats.Stats(in);
                    token = parser.nextToken();
    public void testStatsSerializationParallelismVersion() throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
        List<ThreadPoolStats.Stats> stats = new ArrayList<>();
            try (XContentBuilder builder = new XContentBuilder(MediaTypeRegistry.JSON.xContent(), os)) {
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(6L, stats.getCompleted());  
            .parallelism(8)
            .rejected(4L)
            .waitTimeNanos(7L)  
            .largest(5)
        assertEquals(0, s1.compareTo(s2));
            .threads(1)
        stats.add(defaultStats.name("m").threads(3).build());
import org.opensearch.test.OpenSearchTestCase;
                builder.endObject();
            .completed(6L)  
        // Test constructor and toXContent with parallelism set
        ThreadPoolStats.Stats s1 = builder.build();  
    public void testStatsParallelismConstructorAndToXContent() throws IOException {  
            .parallelism(-1);
            .completed(6L)
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            .largest(5)
 * compatible open source license.
            .queue(2)
                    names,  
        stats.add(defaultStats.name("t").threads(-1).build());
                        ThreadPool.Names.FORCE_MERGE,
        json = builder.toString();
            .waitTimeNanos(7L)  
                token = parser.nextToken();  
                .largest(0)
            List<ThreadPoolStats.Stats> stats = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
            .completed(6L)
                    contains(
            .rejected(4L)
 * software distributed under the License is distributed on an
    public void testStatsCompareToWithParallelism() {
 * not use this file except in compliance with the License.
        assertEquals(2, stats.getQueue());
        builder.endObject();  
            .active(3)
                XContentParser.Token token = parser.currentToken();  
        }
                    )
            .largest(0)
            .active(0)  
        ThreadPoolStats.Stats s3 = builder.threads(2).build();
import org.opensearch.core.xcontent.ToXContent;
            .queue(2)
                assertThat(parser.currentName(), equalTo(ThreadPoolStats.Fields.THREAD_POOL));
                        ThreadPool.Names.WARMER  
            }  
            .waitTimeNanos(7L)
            .threads(1)  
            .threads(1)  
            }  
                .rejected(0)  
        // Test with parallelism = -1 (should not output the field)
            .active(3)
                        ThreadPool.Names.GENERIC,  
import org.opensearch.common.xcontent.XContentFactory;  
        in.setVersion(Version.V_3_4_0);  
            .rejected(4L)  
 * the Apache License, Version 2.0 (the "License"); you may
        assertFalse(json.contains("parallelism"));
        assertEquals(8, stats.getParallelism());
 * specific language governing permissions and limitations
        assertEquals(4L, stats.getRejected());
            stats.add(defaultStats.name(ThreadPool.Names.FORCE_MERGE).waitTimeNanos(-1L).build());
            .parallelism(-1)
import org.opensearch.core.xcontent.XContentBuilder;
        stats = new ThreadPoolStats.Stats.Builder().name("test")
    }
        for (ThreadPoolStats.Stats stat : copy) {  
import org.opensearch.common.io.stream.BytesStreamOutput;
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
        ThreadPoolStats.Stats s2 = builder.build();
 * Licensed to Elasticsearch under one or more contributor  
            .build();
        assertTrue(s1.compareTo(s3) < 0);  
 * license agreements. See the NOTICE file distributed with
        assertEquals(9, statsIn.getParallelism());
            .active(3)  
        statsOut.writeTo(out);
                assertNull(token);
 *  
        }
        assertEquals(7L, stats.getWaitTimeNanos());
 * this work for additional information regarding copyright
        out = new BytesStreamOutput();
        assertTrue(json.contains("\"parallelism\":8"));
 */  
        builder.startObject();
        List<String> names = new ArrayList<>(copy.size());
        assertEquals(-1, statsIn.getParallelism());
                token = parser.nextToken();
                );
/*  
            stats.add(defaultStats.name(ThreadPool.Names.SAME).waitTimeNanos(-1L).build());
        ThreadPoolStats.Stats.Builder builder = new ThreadPoolStats.Stats.Builder().name("a")  
import org.opensearch.core.xcontent.XContentParser;  
                assertThat(
        out.setVersion(Version.V_3_4_0);  
            .completed(6L)
        // Serialization for version < 3.4.0 (parallelism is not written, should be -1)
                builder.startObject();  
            .largest(5)  
            .waitTimeNanos(7L)
            .largest(5)
            .threads(1)  
            .completed(6L)
        XContentBuilder builder = XContentFactory.jsonBuilder();  
                        ThreadPool.Names.SEARCH,
            .queue(2)
    public void testStatsGetters() {
        // Serialization for version >= 3.4.0 (parallelism is written and read)  
 *
            .build();
        stats.add(defaultStats.name("a").threads(-1).build());  
 * GitHub history for details.
        builder = XContentFactory.jsonBuilder();  
            .waitTimeNanos(0L)
    }  
        builder.startObject();
        statsOut.writeTo(out);
 */  
        assertThat(names, contains("a", "d", "m", "m", "m", "t", "z"));  
        assertEquals(5, stats.getLargest());
            .build();
        BytesStreamOutput out = new BytesStreamOutput();
                threadPoolStats.toXContent(builder, ToXContent.EMPTY_PARAMS);
            .queue(2)
                .queue(0)
                List<String> names = new ArrayList<>();
        for (ThreadPoolStats.Stats stat : copy) {  
/*  
        ThreadPoolStats.Stats.Builder defaultStats = new ThreadPoolStats.Stats.Builder().queue(0)
            .threads(1)
 */
            .active(3)
        out.setVersion(Version.V_3_3_0);  
        builder.endObject();  
            names.add(stat.getName());
        stats.add(defaultStats.name("m").threads(1).build());
import java.util.Collections;
                assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));
}  
        assertEquals(1, stats.getThreads());
                assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
                assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
        Collections.sort(copy);  
        try (BytesStreamOutput os = new BytesStreamOutput()) {  
            .rejected(4L)  
        ThreadPoolStats.Stats stats = new ThreadPoolStats.Stats.Builder().name("test")
import org.opensearch.Version;
        assertTrue(s4.compareTo(s1) > 0);
            stats.add(defaultStats.name(ThreadPool.Names.GENERIC).waitTimeNanos(-1L).build());  
    public void testThreadPoolStatsSort() throws IOException {  
 * The OpenSearch Contributors require contributions made to  
    }
        ThreadPoolStats.Stats statsIn = new ThreadPoolStats.Stats(in);
        ThreadPoolStats.Stats statsOut = new ThreadPoolStats.Stats.Builder().name("test")
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertEquals(3, stats.getActive());  
        List<Integer> threads = new ArrayList<>(copy.size());
