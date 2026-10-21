    @Override
                    info.getType() + randomAlphaOfLength(5),
                    info.getHeaders(),
                    info.getRunningTimeNanos(),
            }
                    info.getStatus(),
                return new TaskInfo(
}
                resourceUsageMap.put(randomAlphaOfLength(5), new TaskResourceUsage(randomNonNegativeLong(), randomNonNegativeLong()));
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
                    info.getStatus(),
                    info.isCancelled(),
                    info.getRunningTimeNanos(),
    }
                    info.getResourceStats(),
    @Override
                }
                return new TaskInfo(
                );
                    info.getHeaders(),
                    info.getRunningTimeNanos(),
        return randomTaskInfo();
                    info.getHeaders(),
    protected Writeable.Reader<TaskInfo> instanceReader() {
                    info.getParentTaskId(),
    }
                    info.getType(),
            ? Collections.emptyMap()
/*
    private static TaskId randomTaskId() {
                    info.getStartTime(),
                    info.getStatus(),
 *
                    info.getDescription(),
import org.opensearch.core.xcontent.XContentBuilder;
                Task.Status newStatus = randomValueOtherThan(info.getStatus(), TaskInfoTests::randomRawTaskStatus);
        try (XContentBuilder builder = XContentBuilder.builder(Requests.INDEX_CONTENT_TYPE.xContent())) {
 * not use this file except in compliance with the License.
            taskId,
        Task.Status status = detailed ? randomRawTaskStatus() : null;
                    info.getStartTime(),
    protected TaskInfo createTestInstance() {
                    info.getParentTaskId(),
                    info.isCancellable(),
                if (info.getResourceStats() == null) {
                    info.getStatus(),
    protected TaskInfo doParseInstance(XContentParser parser) {
        }, new TaskThreadUsage(randomInt(10), randomInt(10))) : null;
 * under the License.
                    info.getTaskId(),
                Map<String, String> headers = info.getHeaders();
import org.opensearch.core.xcontent.XContentParser;
                    info.getHeaders(),
    }
                    info.getRunningTimeNanos(),
            description,
                    info.getAction() + randomAlphaOfLength(5),
                    info.getStartTime(),
                );
        return true;
            case 7:
        return detailed ? new TaskResourceStats(new HashMap<>() {
import java.util.HashMap;
                    info.getDescription(),
                    info.getRunningTimeNanos(),
                    info.getTaskId(),
                    info.getStatus(),
        return TaskInfo.fromXContent(parser);
import org.opensearch.core.common.io.stream.Writeable;
                    info.getParentTaskId(),
                    info.getResourceStats(),
                    info.getRunningTimeNanos(),
        );
                    info.getStartTime(),
 * this work for additional information regarding copyright
                    info.getAction(),
                    info.getResourceStats(),
                    info.getType(),
                    info.getType(),
                if (headers == null) {
import org.opensearch.core.tasks.TaskId;
                    info.isCancelled(),
    }
                    info.getHeaders(),
                builder.field(randomAlphaOfLength(5), randomAlphaOfLength(5));
 * the Apache License, Version 2.0 (the "License"); you may
        return field -> "status".equals(field) || "headers".equals(field) || field.contains("resource_stats");
 * ownership. Elasticsearch licenses this file to you under
import java.util.Map;
                    info.getTaskId(),
        return new NamedWriteableRegistry(
                    info.getAction(),
                    info.isCancellable() == false,
 * software distributed under the License is distributed on an
            case 11:
                Map<String, TaskResourceUsage> resourceUsageMap;
        return randomTaskInfo(randomBoolean());
                    info.getStartTime(),
            cancellationStartTime = randomNonNegativeLong();
        TaskId taskId = randomTaskId();
                    info.getStartTime(),
            cancellationStartTime
        Map<String, String> headers = randomBoolean()
    }
                    info.getParentTaskId(),
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    @Override
                    info.getTaskId(),
            for (int f = 0; f < fields; f++) {
 *
                    info.getResourceStats(),
 */
                    info.getResourceStats(),
                    info.getRunningTimeNanos(),
                    info.isCancellable(),
 * The OpenSearch Contributors require contributions made to
        Long cancellationStartTime = null;
                return new TaskInfo(
                    info.getRunningTimeNanos(),
        }
import org.opensearch.transport.client.Requests;
                    info.getHeaders(),
            type,
                    info.getRunningTimeNanos(),
    @Override
                TaskId taskId = new TaskId(info.getTaskId().getNodeId() + randomAlphaOfLength(5), info.getTaskId().getId());
import org.opensearch.core.common.bytes.BytesReference;
                } else {
                    info.getRunningTimeNanos(),
                    info.getAction(),
                    info.getStartTime() + between(1, 100),
                );
                    true,
                    info.isCancellable(),
            startTime,
                    info.getCancellationStartTime()
    public static TaskResourceStats randomResourceStats(boolean detailed) {
                    info.isCancellable(),
            case 0:
            {
                return new TaskInfo(
            headers,
        return new TaskInfo(
                return new TaskInfo(
                    info.getDescription(),
            case 2:
                    info.getTaskId(),
import java.io.IOException;
                    info.getAction(),
                    info.getCancellationStartTime()
                return new TaskInfo(
                    info.isCancellable(),
    }
                    info.getParentTaskId(),
                    info.getResourceStats(),
    }
                    true,
                    info.getDescription(),
                    randomNonNegativeLong()
                    info.getParentTaskId(),
                    info.isCancelled(),
                    info.getStatus(),
                    newStatus,
                    info.getStartTime(),
                    info.getType(),
                    info.getDescription(),
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;
            case 4:
                    info.isCancelled(),
                    info.getDescription(),
                headers.put(randomAlphaOfLength(15), randomAlphaOfLength(15));
                    info.getDescription(),
                    info.getHeaders(),
                    info.isCancelled(),
                    info.getResourceStats(),
                return new TaskInfo(
                return new TaskInfo(
    static TaskInfo randomTaskInfo(boolean detailed) {
            builder.endObject();
                    headers,
            parentTaskId,
    @Override
                    info.isCancelled(),
                    false,
        TaskId parentTaskId = randomBoolean() ? TaskId.EMPTY_TASK_ID : randomTaskId();
                    info.isCancellable(),
                    info.getRunningTimeNanos(),
                    info.getAction(),
        switch (between(0, 11)) {
        long startTime = randomLong();
            case 10:
            return new RawTaskStatus(BytesReference.bytes(builder));
                    info.getStatus(),
                    info.getResourceStats(),
                );
 * license agreements. See the NOTICE file distributed with
            cancellable,
                    info.getDescription(),
        if (cancelled) {
 * KIND, either express or implied.  See the License for the
            builder.startObject();
                    info.getHeaders(),
            status,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    resourceUsageMap = new HashMap<>(info.getResourceStats().getResourceUsageInfo());
    protected TaskInfo mutateInstance(TaskInfo info) {
                    info.isCancellable(),
            case 9:
    }
            action,
                    info.getTaskId(),
                    info.getType(),
        boolean cancellable = randomBoolean();
                throw new IllegalStateException();
                    info.isCancelled(),
                return new TaskInfo(
                    info.isCancelled(),
                    info.getParentTaskId(),
            cancelled,
                }
import java.util.Collections;
                    info.getStatus(),
        boolean cancelled = cancellable == true ? randomBoolean() : false;
    }
                }
                    info.getType(),
                    info.getTaskId(),
 * specific language governing permissions and limitations
                );
                    taskId,
                    info.getHeaders(),
 * You may obtain a copy of the License at
            }
                    info.getAction(),
public class TaskInfoTests extends AbstractSerializingTestCase<TaskInfo> {
                    parentId,
                    info.isCancellable(),
                    info.getTaskId(),
                    info.getParentTaskId(),
                    info.getStartTime(),
        // status, headers and resource_stats hold arbitrary content, we can't inject random fields in them
                    info.getParentTaskId(),
                    info.getTaskId(),
                    info.getStatus(),
            Collections.singletonList(new NamedWriteableRegistry.Entry(Task.Status.class, RawTaskStatus.NAME, RawTaskStatus::new))
    @Override
                return new TaskInfo(
                    new TaskResourceStats(resourceUsageMap, new TaskThreadUsage(randomInt(10), randomInt(10)))
                    info.isCancellable(),
                    info.getTaskId(),
        String type = randomAlphaOfLength(5);
                );
        String action = randomAlphaOfLength(5);
        }
                    info.getCancellationStartTime()
                    info.getType(),
                    info.getHeaders(),
                    info.getResourceStats(),
                );
        );
                return new TaskInfo(
    protected Predicate<String> getRandomFieldsExcludeFilter() {
 */
                    info.getStatus(),
            randomResourceStats(detailed),
import org.opensearch.test.AbstractSerializingTestCase;
                    info.getRunningTimeNanos() + between(1, 100),
                    resourceUsageMap = new HashMap<>(1);
        }
            case 6:
                    info.getType(),
                    info.getDescription(),
                    info.getStartTime(),
import org.opensearch.core.tasks.resourcetracker.TaskThreadUsage;
                    info.getResourceStats(),
    }
                    info.getCancellationStartTime()
                    info.getStartTime(),
    protected boolean supportsUnknownFields() {
        return TaskInfo::new;
import org.opensearch.core.tasks.resourcetracker.TaskResourceStats;
                    info.getCancellationStartTime()
                    info.getDescription(),
            default:
                    info.getDescription(),
            throw new IllegalStateException(e);
            int fields = between(0, 11);
                    info.getAction(),
 */
                    put(randomAlphaOfLength(5), new TaskResourceUsage(randomNonNegativeLong(), randomNonNegativeLong()));
                    info.isCancelled(),
 * Modifications Copyright OpenSearch Contributors. See
        long runningTimeNanos = randomLong();
                    info.getType(),
 * this file be licensed under the Apache-2.0 license or a
                return new TaskInfo(
                    info.getDescription() + randomAlphaOfLength(5),
                    info.getCancellationStartTime()
                    info.isCancellable(),
    private static RawTaskStatus randomRawTaskStatus() {
            case 1:
                    info.getType(),
package org.opensearch.tasks;
    @Override
                    info.getCancellationStartTime()
 *
                );
        } catch (IOException e) {
                );
 * SPDX-License-Identifier: Apache-2.0
                );
    }
                } else {
 * Unless required by applicable law or agreed to in writing,
                    info.getAction(),
/*
                for (int i = 0; i < randomInt(5); i++) {
            : Collections.singletonMap(randomAlphaOfLength(5), randomAlphaOfLength(5));
                    info.getCancellationStartTime()
/*
                    info.getParentTaskId(),
                );
            case 8:
                    info.getTaskId(),
                    info.getStatus(),
 * GitHub history for details.
                    info.getCancellationStartTime()
 *    http://www.apache.org/licenses/LICENSE-2.0
                    info.getAction(),
                    headers = new HashMap<>(info.getHeaders());
                    info.getCancellationStartTime()
                    headers = new HashMap<>(1);
                    info.getAction(),
                    info.getResourceStats(),
import java.util.function.Predicate;
                    info.getParentTaskId(),
        String description = detailed ? randomAlphaOfLength(5) : null;
                    info.getType(),
 * Licensed to Elasticsearch under one or more contributor
 * compatible open source license.
                    info.getAction(),
                    info.getHeaders(),
    static TaskInfo randomTaskInfo() {
            runningTimeNanos,
    }
                );
                    info.getStartTime(),
            case 3:
        return new TaskId(randomAlphaOfLength(5), randomLong());
                    info.isCancelled(),
            case 5:
                TaskId parentId = new TaskId(info.getParentTaskId().getNodeId() + randomAlphaOfLength(5), info.getParentTaskId().getId());
