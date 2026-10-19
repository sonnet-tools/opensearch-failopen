                    info.getCancellationStartTime()
        }, new TaskThreadUsage(randomInt(10), randomInt(10))) : null;
            {
                    info.getStatus(),  
import java.util.Map;
                );
    private static TaskId randomTaskId() {  
    @Override  
            case 6:
                } else {
import org.opensearch.transport.client.Requests;
                    info.getStartTime(),  
                    info.getRunningTimeNanos(),  
        Long cancellationStartTime = null;
                    headers,
                return new TaskInfo(
                    info.getRunningTimeNanos(),
                    info.getStartTime(),
                    info.getHeaders(),  
                    info.getParentTaskId(),
                    info.getStatus(),
            case 8:
        boolean cancellable = randomBoolean();  
    }
            action,
                    info.isCancellable(),  
                    info.getCancellationStartTime()  
                    info.isCancelled(),
        return new NamedWriteableRegistry(
 * Modifications Copyright OpenSearch Contributors. See
                return new TaskInfo(
                );
                    info.getType(),  
 */  
                    resourceUsageMap = new HashMap<>(1);
import org.opensearch.test.AbstractSerializingTestCase;
                    info.getParentTaskId(),
                    info.getHeaders(),  
                    newStatus,  
                    info.getCancellationStartTime()
                    info.isCancelled(),
 * The OpenSearch Contributors require contributions made to  
                    info.getDescription(),
                    info.getRunningTimeNanos(),  
                    info.getDescription(),
 * Licensed to Elasticsearch under one or more contributor  
            Collections.singletonList(new NamedWriteableRegistry.Entry(Task.Status.class, RawTaskStatus.NAME, RawTaskStatus::new))  
 * license agreements. See the NOTICE file distributed with
                    info.getAction(),  
                } else {  
                }
                    info.getResourceStats(),  
                    info.getType() + randomAlphaOfLength(5),
                    info.isCancellable(),  
                    info.getTaskId(),
                    info.getCancellationStartTime()  
 * the Apache License, Version 2.0 (the "License"); you may
            parentTaskId,
                    info.getStartTime(),  
                    info.getCancellationStartTime()
import java.util.HashMap;  
                );
    }  
                    info.getAction(),  
            cancelled,
                return new TaskInfo(
                    info.isCancelled(),  
                    info.getAction(),
                Map<String, TaskResourceUsage> resourceUsageMap;  
    static TaskInfo randomTaskInfo() {  
/*
                    info.getTaskId(),
    @Override  
                    info.getStartTime(),
                    info.getHeaders(),  
                    info.getStatus(),
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    info.getAction() + randomAlphaOfLength(5),
 * software distributed under the License is distributed on an
                    info.getResourceStats(),
            }  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    parentId,
                    info.getHeaders(),  
import org.opensearch.core.tasks.resourcetracker.TaskResourceStats;
                    info.getResourceStats(),
                    info.isCancellable(),
                    info.getType(),
                    info.getParentTaskId(),  
                return new TaskInfo(  
                    info.getHeaders(),
                );  
    }
                }  
 * specific language governing permissions and limitations
            case 7:  
        switch (between(0, 11)) {
                    info.getResourceStats(),
            status,  
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;  
                    info.getStartTime(),
                    info.getCancellationStartTime()
            ? Collections.emptyMap()
                    randomNonNegativeLong()
                    info.isCancellable(),
                Task.Status newStatus = randomValueOtherThan(info.getStatus(), TaskInfoTests::randomRawTaskStatus);  
                    info.getAction(),
                    info.getAction(),  
                );
            int fields = between(0, 11);
                    info.getStartTime(),
            case 5:
                    info.getResourceStats(),  
 * You may obtain a copy of the License at  
                    info.getTaskId(),  
package org.opensearch.tasks;
                return new TaskInfo(  
            case 2:  
 * compatible open source license.
                    info.getCancellationStartTime()
                resourceUsageMap.put(randomAlphaOfLength(5), new TaskResourceUsage(randomNonNegativeLong(), randomNonNegativeLong()));  
                    info.isCancellable(),  
 * GitHub history for details.
                    info.getStartTime(),
                    info.getStatus(),
                    info.getType(),  
                if (headers == null) {
            randomResourceStats(detailed),
                    info.getAction(),
            cancellationStartTime = randomNonNegativeLong();
    public static TaskResourceStats randomResourceStats(boolean detailed) {  
                    info.getTaskId(),
                    info.getParentTaskId(),
                    info.getRunningTimeNanos(),
        if (cancelled) {  
        String type = randomAlphaOfLength(5);  
                    info.getHeaders(),  
                    info.getHeaders(),
                    info.getStartTime() + between(1, 100),
                    info.isCancellable(),
                    info.getAction(),
                    info.getTaskId(),
                    info.getRunningTimeNanos(),
    protected TaskInfo mutateInstance(TaskInfo info) {
                    info.isCancelled(),
                headers.put(randomAlphaOfLength(15), randomAlphaOfLength(15));
            headers,  
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
            case 10:
            taskId,
    protected TaskInfo createTestInstance() {  
                    info.getTaskId(),
                    info.getHeaders(),
            type,  
        return randomTaskInfo();
                    info.getResourceStats(),
                    info.getResourceStats(),
                    info.getRunningTimeNanos(),
        long runningTimeNanos = randomLong();
    @Override  
                    info.getDescription(),  
        String action = randomAlphaOfLength(5);
                    info.getStartTime(),
        }  
    @Override  
            }
    }
            case 9:  
                    true,  
    protected boolean supportsUnknownFields() {
 *
                    info.getDescription(),
 * SPDX-License-Identifier: Apache-2.0
            case 0:  
                    info.getTaskId(),  
        return field -> "status".equals(field) || "headers".equals(field) || field.contains("resource_stats");  
                );
import java.util.Collections;
 * not use this file except in compliance with the License.
                    info.getRunningTimeNanos() + between(1, 100),
                throw new IllegalStateException();
                    info.getStartTime(),  
                    info.isCancelled(),
                    info.isCancelled(),
        long startTime = randomLong();
                    info.getDescription(),  
    }
                    info.isCancellable(),
                    info.getResourceStats(),  
                    info.getHeaders(),
                    info.getParentTaskId(),  
            throw new IllegalStateException(e);
                    info.getParentTaskId(),
 *  
                    info.getType(),  
        );
                );  
                    info.getRunningTimeNanos(),
                    info.getStatus(),
                    taskId,  
                    info.getDescription(),
                return new TaskInfo(
                return new TaskInfo(
 *
                    info.getAction(),
                    info.getStartTime(),
                    info.getDescription(),
                    info.getTaskId(),
                    info.getStatus(),  
                    info.getHeaders(),
                    info.getRunningTimeNanos(),
        Map<String, String> headers = randomBoolean()
            cancellationStartTime
                    info.getType(),
/*  
        return TaskInfo.fromXContent(parser);
    protected TaskInfo doParseInstance(XContentParser parser) {
/*  
    @Override
            case 1:
        }
                    headers = new HashMap<>(info.getHeaders());
                    info.isCancellable(),
 * this work for additional information regarding copyright
                    info.getStatus(),  
            return new RawTaskStatus(BytesReference.bytes(builder));  
        String description = detailed ? randomAlphaOfLength(5) : null;  
                    info.getRunningTimeNanos(),
        TaskId taskId = randomTaskId();
                );  
            : Collections.singletonMap(randomAlphaOfLength(5), randomAlphaOfLength(5));  
        try (XContentBuilder builder = XContentBuilder.builder(Requests.INDEX_CONTENT_TYPE.xContent())) {
import org.opensearch.core.tasks.TaskId;
    }
                    info.getType(),
import org.opensearch.core.xcontent.XContentParser;  
                    info.getTaskId(),
                    put(randomAlphaOfLength(5), new TaskResourceUsage(randomNonNegativeLong(), randomNonNegativeLong()));
                    info.getRunningTimeNanos(),  
            case 11:  
                    info.isCancelled(),  
                    info.getResourceStats(),
    protected Predicate<String> getRandomFieldsExcludeFilter() {
import org.opensearch.core.xcontent.XContentBuilder;
 * ownership. Elasticsearch licenses this file to you under  
                    info.isCancelled(),  
import org.opensearch.core.tasks.resourcetracker.TaskThreadUsage;
                    info.getType(),
                    info.getType(),
                    info.getDescription(),
                    info.getType(),  
                }
                    info.getStartTime(),
        }  
            startTime,
                    info.getDescription(),
                    info.getParentTaskId(),  
                    info.getStatus(),
                    info.isCancellable(),
        return new TaskInfo(
        );  
        return TaskInfo::new;  
                    true,
            default:
                    info.getParentTaskId(),  
}  
 * under the License.  
                    info.isCancellable(),
                    info.getParentTaskId(),
                    info.getAction(),
    }
            description,
                    info.getTaskId(),  
                    headers = new HashMap<>(1);  
                );
    @Override
        return randomTaskInfo(randomBoolean());
import org.opensearch.core.common.io.stream.Writeable;  
                return new TaskInfo(
                    info.isCancelled(),
                    info.getParentTaskId(),
                if (info.getResourceStats() == null) {
                    info.getTaskId(),
                    info.getAction(),
                    info.getStatus(),
                    new TaskResourceStats(resourceUsageMap, new TaskThreadUsage(randomInt(10), randomInt(10)))
                );
import java.io.IOException;
    @Override
        TaskId parentTaskId = randomBoolean() ? TaskId.EMPTY_TASK_ID : randomTaskId();  
        // status, headers and resource_stats hold arbitrary content, we can't inject random fields in them
                return new TaskInfo(
public class TaskInfoTests extends AbstractSerializingTestCase<TaskInfo> {
    }
                    info.isCancelled(),
            runningTimeNanos,
                    info.getParentTaskId(),
                    info.getResourceStats(),
                    info.getCancellationStartTime()
                    info.getDescription(),  
            builder.startObject();  
        Task.Status status = detailed ? randomRawTaskStatus() : null;
    static TaskInfo randomTaskInfo(boolean detailed) {
                    info.getRunningTimeNanos(),  
    protected Writeable.Reader<TaskInfo> instanceReader() {
                Map<String, String> headers = info.getHeaders();
                return new TaskInfo(
                    info.getDescription() + randomAlphaOfLength(5),  
                    info.getType(),  
                    info.getStatus(),  
    }
                    info.getType(),
                    info.getResourceStats(),
                    false,
            for (int f = 0; f < fields; f++) {
                TaskId taskId = new TaskId(info.getTaskId().getNodeId() + randomAlphaOfLength(5), info.getTaskId().getId());
            cancellable,  
 * KIND, either express or implied.  See the License for the
                    info.getStatus(),
                    info.getAction(),
                return new TaskInfo(
                return new TaskInfo(  
                    info.getCancellationStartTime()  
            case 3:
        return detailed ? new TaskResourceStats(new HashMap<>() {
            builder.endObject();
                );
 * this file be licensed under the Apache-2.0 license or a
        return new TaskId(randomAlphaOfLength(5), randomLong());
import java.util.function.Predicate;
    }
 */
                );  
                    info.isCancellable() == false,  
    }
                    info.getDescription(),
                for (int i = 0; i < randomInt(5); i++) {  
 * Unless required by applicable law or agreed to in writing,
                    resourceUsageMap = new HashMap<>(info.getResourceStats().getResourceUsageInfo());
                    info.getHeaders(),
                builder.field(randomAlphaOfLength(5), randomAlphaOfLength(5));  
            case 4:
        } catch (IOException e) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.bytes.BytesReference;
    private static RawTaskStatus randomRawTaskStatus() {
 */  
                TaskId parentId = new TaskId(info.getParentTaskId().getNodeId() + randomAlphaOfLength(5), info.getParentTaskId().getId());
                    info.getCancellationStartTime()  
        return true;  
        boolean cancelled = cancellable == true ? randomBoolean() : false;
