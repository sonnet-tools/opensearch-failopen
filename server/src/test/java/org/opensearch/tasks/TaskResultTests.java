            }
            }  
    private XContentBuilder addRandomUnknownFields(XContentBuilder builder) throws IOException {  
        TaskInfo read;  
            case 0:  
            taskInfo.toXContent(builder, ToXContent.EMPTY_PARAMS);  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        assertEquals(result, read);
            try (StreamInput in = new NamedWriteableAwareStreamInput(out.bytes().streamInput(), registry)) {
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
            throw new IOException("Error processing [" + result + "]", e);
            }  
            @Override  
                if (randomBoolean()) {
 * Round trip tests for {@link TaskResult} and those classes that it includes like {@link TaskInfo} and {@link RawTaskStatus}.
            for (int i = 0; i < numberOfNewFields; i++) {
 *
        TaskResult result = randomTaskResult();  
        try (XContentParser parser = createParser(builder)) {
            throw new IOException("Error processing [" + taskInfo + "]", e);
 * GitHub history for details.
            XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(parser.contentType());
import java.util.Map;
        NamedWriteableRegistry registry = new NamedWriteableRegistry(  
    }  
        } catch (IOException e) {
                // Responses in Elasticsearch never output a leading startObject. There isn't really a good reason, they just don't.
 * compatible open source license.
            default:  
            Map<String, Object> map = parser.mapOrdered();
        }
                read = TaskResult.PARSER.apply(parser, null);
        }
 */  
            Collections.singletonList(new NamedWriteableRegistry.Entry(Task.Status.class, RawTaskStatus.NAME, RawTaskStatus::new))
                    try (XContentParser parser = createParser(shuffled)) {
            result.put(randomAlphaOfLength(5), randomAlphaOfLength(5));  
         * as the status we randomly generate then we can assert the round trip with .equals.
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(result, read);
        TaskResult read;
    }
                }
                return new TaskResult(randomTaskInfo(), randomTaskResponse());
        } catch (IOException e) {  
/**
 * not use this file except in compliance with the License.
        try (XContentBuilder builder = XContentBuilder.builder(randomFrom(XContentType.values()).xContent())) {
        TaskResult read;
import java.util.TreeMap;  
 * KIND, either express or implied.  See the License for the
public class TaskResultTests extends OpenSearchTestCase {
package org.opensearch.tasks;
}
/*  
                for (Map.Entry<String, String> entry : result.entrySet()) {  
            case 1:
import org.opensearch.core.common.io.stream.StreamInput;
        try (XContentBuilder builder = XContentBuilder.builder(randomFrom(XContentType.values()).xContent())) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        }  
        assertEquals(taskInfo, read);  
            builder.startObject();
    public void testTaskInfoIsForwardCompatible() throws IOException {
    public void testBinaryRoundTrip() throws IOException {
                return new TaskResult(randomTaskInfo(), new RuntimeException("error"));  
            try (XContentBuilder withExtraFields = addRandomUnknownFields(builder)) {
                }
 * specific language governing permissions and limitations
    }  
import java.io.IOException;  
                throw new UnsupportedOperationException("Unsupported random TaskResult constructor");
            try (XContentBuilder shuffled = shuffleXContent(builder); XContentParser parser = createParser(shuffled)) {
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
        return new ToXContent() {
    }
        };
        TaskResult result = randomTaskResult();  
    private static ToXContent randomTaskResponse() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (int f = 0; f < fields; f++) {
        Map<String, String> result = new TreeMap<>();  
 * You may obtain a copy of the License at  
    public void testXContentRoundTrip() throws IOException {
    private static TaskResult randomTaskResult() throws IOException {
import org.opensearch.core.xcontent.XContentParser;  
        TaskInfo taskInfo = randomTaskInfo();
            int numberOfNewFields = randomIntBetween(2, 10);  
 *
        switch (between(0, 2)) {
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.tasks.TaskInfoTests.randomTaskInfo;
    }
        );
                try (XContentBuilder shuffled = shuffleXContent(withExtraFields)) {  
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                } else {
            throw new IOException("Error processing [" + result + "]", e);
        } catch (IOException e) {
                        read = TaskInfo.PARSER.apply(parser, null);
        /*
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
            }
 * software distributed under the License is distributed on an
import java.util.Collections;
                return builder;  
 * SPDX-License-Identifier: Apache-2.0
        }
         * Note that this round trip isn't 100% perfect - status will always be read as RawTaskStatus. Since this test uses RawTaskStatus  
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.common.io.stream.BytesStreamOutput;
                return new TaskResult(randomBoolean(), randomTaskInfo());
                    map.put("unknown_field" + i, Collections.singletonMap("inner", randomAlphaOfLength(20)));
 */  
                }  
            builder.endObject();
            case 2:
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        }  
                    map.put("unknown_field" + i, randomAlphaOfLength(20));  
            result.toXContent(builder, ToXContent.EMPTY_PARAMS);  
                    builder.field(entry.getKey(), entry.getValue());
                    }  
        }
         */
            result.writeTo(out);  
/*
        int fields = between(0, 10);
                read = new TaskResult(in);
            return xContentBuilder.map(map);  
            }
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 *  
    }
 */  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.test.OpenSearchTestCase;
