 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        long startTime = randomLong();  
    private void toXContent(GetTaskResponse response, XContentBuilder builder) throws IOException {
        xContentTester(this::createParser, this::createTestInstance, this::toXContent, GetTaskResponse::fromXContent).supportsUnknownFields(
        }
            action,  
 */  
            description,
import org.opensearch.core.xcontent.XContentBuilder;  
 * software distributed under the License is distributed on an
        }, new TaskThreadUsage(randomInt(10), randomInt(10)));  
        builder.startObject();  
            headers,
            int fields = between(0, 10);  
    }
    private static TaskId randomTaskId() {
 * KIND, either express or implied.  See the License for the
    }
 * this file be licensed under the Apache-2.0 license or a
    private static TaskResourceStats randomResourceStats() {
            cancellationStartTime = randomNonNegativeLong();
            }
        return new GetTaskResponse(randomBoolean(), randomTaskInfo());
    }  
import java.util.Collections;
import org.opensearch.client.tasks.GetTaskResponse;
    public void testFromXContent() throws IOException {  
        }  
        return randomBoolean() ? null : new TaskResourceStats(new HashMap<>() {  
/*  
            .test();
            cancellable,
import org.opensearch.core.tasks.resourcetracker.TaskResourceStats;
        return new TaskId(randomAlphaOfLength(5), randomLong());  
    }
        Map<String, String> headers = randomBoolean()  
            {
    }  
        assertEquals(expectedInstance.getTaskInfo(), newInstance.getTaskInfo());  
        String action = randomAlphaOfLength(5);  
            randomResourceStats(),  
    private static RawTaskStatus randomRawTaskStatus() {  
import org.opensearch.test.OpenSearchTestCase;
        TaskId taskId = randomTaskId();
        );
import java.util.Map;  
                    put(randomAlphaOfLength(5), new TaskResourceUsage(randomNonNegativeLong(), randomNonNegativeLong()));  
import org.opensearch.core.common.bytes.BytesReference;
            .assertEqualsConsumer(this::assertEqualInstances)
            .randomFieldsExcludeFilter(field -> field.endsWith("headers") || field.endsWith("status") || field.contains("resource_stats"))  
        long runningTimeNanos = randomLong();
 * GitHub history for details.
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
import org.opensearch.core.tasks.resourcetracker.TaskThreadUsage;  
 */  
import org.opensearch.tasks.RawTaskStatus;
        if (cancelled) {  
import org.opensearch.core.tasks.TaskId;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        boolean cancelled = cancellable == true ? randomBoolean() : false;  
    private void assertEqualInstances(GetTaskResponse expectedInstance, GetTaskResponse newInstance) {
 * license agreements. See the NOTICE file distributed with
            return new RawTaskStatus(BytesReference.bytes(builder));
            builder.endObject();
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(expectedInstance.isCompleted(), newInstance.isCompleted());
        String type = randomAlphaOfLength(5);
        try (XContentBuilder builder = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent())) {
            builder.startObject(GetTaskResponse.TASK.getPreferredName());  
public class GetTaskResponseTests extends OpenSearchTestCase {
 * compatible open source license.
package org.opensearch.client.core.tasks;
    static TaskInfo randomTaskInfo() {  
        }
                builder.field(randomAlphaOfLength(5), randomAlphaOfLength(5));
            cancelled,  
 * the Apache License, Version 2.0 (the "License"); you may
            .assertToXContentEquivalence(true)
import java.util.HashMap;
            ? Collections.emptyMap()
        TaskId parentTaskId = randomBoolean() ? TaskId.EMPTY_TASK_ID : randomTaskId();
        {
import java.io.IOException;  
        Long cancellationStartTime = null;
            builder.startObject();
 *
        return new TaskInfo(  
            response.getTaskInfo().toXContent(builder, ToXContent.EMPTY_PARAMS);
        } catch (IOException e) {  
            runningTimeNanos,
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;
/*
        Task.Status status = randomBoolean() ? randomRawTaskStatus() : null;
            builder.endObject();
            throw new IllegalStateException(e);
            type,
            builder.field(GetTaskResponse.COMPLETED.getPreferredName(), response.isCompleted());
        )  
            true
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
import org.opensearch.tasks.TaskInfo;  
            }  
            taskId,
 *
import org.opensearch.tasks.Task;
 */
 * SPDX-License-Identifier: Apache-2.0
    }
        boolean cancellable = randomBoolean();
            startTime,  
 * ownership. Elasticsearch licenses this file to you under  
}
import org.opensearch.core.xcontent.ToXContent;
            for (int f = 0; f < fields; f++) {
            cancellationStartTime
            parentTaskId,
    private GetTaskResponse createTestInstance() {
/*  
                for (int i = 0; i < randomInt(5); i++) {
                }
        builder.endObject();
 *  
        String description = randomBoolean() ? randomAlphaOfLength(5) : null;
            : Collections.singletonMap(randomAlphaOfLength(5), randomAlphaOfLength(5));
import static org.opensearch.test.AbstractXContentTestCase.xContentTester;
    }  
            status,
