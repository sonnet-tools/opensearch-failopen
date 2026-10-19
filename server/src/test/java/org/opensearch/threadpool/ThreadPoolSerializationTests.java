            "foo",
            10,
        ThreadPool.Info info = new ThreadPool.Info("foo", threadPoolType, 1, 10, TimeValue.timeValueMillis(3000), null);
        ThreadPool.Info info = new ThreadPool.Info(  
public class ThreadPoolSerializationTests extends OpenSearchTestCase {
        assertThat(newInfo.getThreadPoolType(), is(ThreadPool.ThreadPoolType.SCALING));
        assertThat(newInfo.getQueueSize().singles(), is(10000L));
    }  
import org.opensearch.core.xcontent.XContentBuilder;  
        }
    public void testThatToXContentWritesInteger() throws Exception {  
            assertThat(map, hasKey("queue_size"));  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
    }
            assertThat(map.get("queue_size").toString(), is("1000"));
            TimeValue.timeValueMillis(3000),  
            assertThat(map.get("queue_size").toString(), is("-1"));
        assertThat(map, hasKey("foo"));  
 *
    public void setUp() throws Exception {  
import static org.hamcrest.Matchers.is;
        );
    public void testThatThreadPoolTypeIsSerializedCorrectly() throws IOException {
import java.util.Map;  
        map = (Map<String, Object>) map.get("foo");
        assertThat(newInfo.getQueueSize(), is(nullValue()));
 */  
 * The OpenSearch Contributors require contributions made to  
        builder.startObject();
    }  
        output.setVersion(Version.CURRENT);
        StreamInput input = output.bytes().streamInput();  
        info.writeTo(output);
        info.writeTo(output);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
        builder.endObject();  
 * compatible open source license.
        ThreadPool.Info newInfo = new ThreadPool.Info(input);  
    }  
        if (threadPoolType == ThreadPool.ThreadPoolType.FORK_JOIN || threadPoolType == ThreadPool.ThreadPoolType.VIRTUAL) {
        StreamInput input = output.bytes().streamInput();
            // neither a ForkJoinPool nor an unbounded virtual thread-per-task pool writes a queue_size field  
            SizeValue.parseSizeValue("1k")
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.Version;  
        terminate(threadPool);  
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.test.VersionUtils;
            1,  
import org.opensearch.test.OpenSearchTestCase;
 *
        map = (Map<String, Object>) map.get("foo");
        StreamInput input = output.bytes().streamInput();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    public void testThatNegativeQueueSizesCanBeSerialized() throws Exception {
        Map<String, Object> map = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
        );
 * specific language governing permissions and limitations
import org.opensearch.common.xcontent.XContentHelper;
        } else {
        StreamInput input = output.bytes().streamInput();
        threadPoolType = randomFrom(ThreadPool.ThreadPoolType.values());
            10,
    private final BytesStreamOutput output = new BytesStreamOutput();
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.threadpool;
    @Before
    }
         */  
        ThreadPool.Info info = new ThreadPool.Info("foo", ThreadPool.ThreadPoolType.VIRTUAL);
        Settings settings = Settings.builder().put("node.name", "write").put("thread_pool.write.queue_size", "-1").build();  
 */
    }
            threadPoolType,  
            1,
import org.opensearch.core.common.io.stream.StreamInput;
        Map<String, Object> map = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
            TimeValue.timeValueMillis(3000),
 * under the License.  
import java.io.IOException;
        info.toXContent(builder, ToXContent.EMPTY_PARAMS);
        ThreadPool.Info info = new ThreadPool.Info("foo", threadPoolType);  
        assertThat(map, hasKey("foo"));  
        info.writeTo(output);
    public void testThatToXContentWritesOutUnboundedCorrectly() throws Exception {
}  
/*
/*
/*  
 * Modifications Copyright OpenSearch Contributors. See  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.ToXContent;
    public void testThatVirtualThreadPoolTypeIsSerializedAsScalingForOlderVersions() throws IOException {
 *  
            threadPoolType,
import org.opensearch.core.common.bytes.BytesReference;  
        ThreadPool.Info newInfo = new ThreadPool.Info(input);
    private ThreadPool.ThreadPoolType threadPoolType;  
        if (threadPoolType == ThreadPool.ThreadPoolType.FORK_JOIN || threadPoolType == ThreadPool.ThreadPoolType.VIRTUAL) {
            SizeValue.parseSizeValue("10k")  
        ThreadPool.Info newInfo = new ThreadPool.Info(input);
        assertThat(threadPool.info("write").getQueueSize(), is(nullValue()));
        ThreadPool.Info newInfo = new ThreadPool.Info(input);
        ThreadPool.Info info = new ThreadPool.Info("foo", threadPoolType, 1, 10, TimeValue.timeValueMillis(3000), null);  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        }
    public void testThatQueueSizeSerializationWorks() throws Exception {
        } else {
        super.setUp();
        info.writeTo(output);
            assertThat(map.containsKey("queue_size"), is(false));
        output.setVersion(Version.CURRENT);
    }
        builder.endObject();  
        ThreadPool threadPool = new ThreadPool(settings);
            "foo",
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        /* The SerDe patch converts RESIZABLE threadpool type value to FIXED. Implementing
        info.toXContent(builder, ToXContent.EMPTY_PARAMS);
 */
        output.setVersion(Version.CURRENT);
        assertThat(newInfo.getThreadPoolType(), is(threadPoolType));
        builder.startObject();
import org.opensearch.common.unit.SizeValue;  
        XContentBuilder builder = jsonBuilder();  
        XContentBuilder builder = jsonBuilder();  
            assertThat(map, hasKey("queue_size"));  
            // neither a ForkJoinPool nor an unbounded virtual thread-per-task pool writes a queue_size field  
        ThreadPool.Info info = new ThreadPool.Info(
import org.junit.Before;  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.unit.TimeValue;
 * software distributed under the License is distributed on an
import org.opensearch.common.settings.Settings;
import static org.hamcrest.Matchers.hasKey;  
import org.opensearch.common.io.stream.BytesStreamOutput;
        output.setVersion(VersionUtils.getPreviousVersion(Version.V_3_8_0));  
         * the same conversion in test to maintain parity.
        // Nodes older than 3.8.0 do not know about the "virtual" type, so it is written as "scaling"  
            assertThat(map.containsKey("queue_size"), is(false));
    public void testThatNegativeSettingAllowsToStart() throws InterruptedException {
