            // pass
        // reporting resource consumption events and checking total consumption values
            cancellable,
        boolean cancellable = false;
import org.opensearch.core.common.bytes.BytesArray;
        TaskInfo taskInfo = new TaskInfo(
        // re-adding a thread entry that is already present, should throw an exception
            task.startThreadResourceTracking(i, ResourceStatsType.WORKER_STATS, initialTaskResourceMetrics);
            SearchAction.NAME,
            "test_type",
import java.util.Collections;
        assertEquals(map.get("cancelled"), cancelled);
        long taskId = randomIntBetween(0, 100000);
 * KIND, either express or implied.  See the License for the
        );
        } catch (IllegalStateException e) {
 */
        String taskInfoString = taskInfo.toString();
        long startTime = randomNonNegativeLong();
/*
            runningTime,
        boolean cancellable = false;
        long startTime = randomNonNegativeLong();
        assertEquals(map.get("type"), "test_type");
        boolean cancelled = true;
        assertEquals(e.getMessage(), "task cannot be cancelled");
            ResourceUsageMetric[] taskResourceMetrics = new ResourceUsageMetric[] {
 * this work for additional information regarding copyright
            task.updateThreadResourceStats(threadId, ResourceStatsType.WORKER_STATS, new ResourceUsageMetric(ResourceStats.CPU, 200));
                TaskId.EMPTY_TASK_ID,
        String taskInfoString = taskInfo.toString();
            randomResourceStats(randomBoolean())
            "test_action",
        final Task task = new Task(
        try {
import org.opensearch.tasks.Task;
        assertTrue(task.getMaxResourceStats().getMemoryInBytes() < task.getTotalResourceStats().getMemoryInBytes());
        String nodeId = randomAlphaOfLength(10);
            startTime,
        assertEquals(map.get("cancellable"), cancellable);
        Map<String, Object> map = XContentHelper.convertToMap(new BytesArray(taskInfoString.getBytes(StandardCharsets.UTF_8)), true).v2();
                cancelled,
        assertEquals(task.getTotalResourceStats().getMemoryInBytes(), totalMemory);
        long taskId = randomIntBetween(0, 100000);
        }
 *
            startTime,
 * under the License.
        }
        );
            )
        assertEquals(map.get("cancellation_time_millis"), cancellationStartTime);
            cancelled,
    }
 * compatible open source license.
                "test_description",
        long totalCPU = 0L;
        TaskInfo taskInfo = new TaskInfo(
            cancelled,
        assertEquals(((Number) map.get("start_time_in_millis")).longValue(), startTime);
            randomResourceStats(randomBoolean()),
            task.startThreadResourceTracking(threadId, ResourceStatsType.WORKER_STATS);
            "test_description",
 * The OpenSearch Contributors require contributions made to
            // pass
        Exception e = expectThrows(
            "transport",
        assertEquals(map.get("cancellable"), cancellable);
                "test_type",
        task.startThreadResourceTracking(threadId, ResourceStatsType.WORKER_STATS, new ResourceUsageMetric(ResourceStats.MEMORY, 100));
        long taskId = randomIntBetween(0, 100000);
            Collections.singletonMap("foo", "bar"),
            cancellationStartTime
 *    http://www.apache.org/licenses/LICENSE-2.0
        long runningTime = randomNonNegativeLong();
            "test_action",
/*
import org.opensearch.core.tasks.resourcetracker.ResourceStatsType;
        long runningTime = randomNonNegativeLong();
                new TaskId(nodeId, taskId),
            new TaskId(nodeId, taskId),
            "test_action",
        );
                "test_action",
        }
        String nodeId = randomAlphaOfLength(10);
 * this file be licensed under the Apache-2.0 license or a
            TaskId.EMPTY_TASK_ID,
    }
package org.opensearch.action.admin.cluster.node.tasks;
        assertTrue(task.getMinResourceStats().getMemoryInBytes() < task.getAverageResourceStats().getMemoryInBytes());
                null,
        assertTrue(task.getAverageResourceStats().getMemoryInBytes() < task.getMaxResourceStats().getMemoryInBytes());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            // pass
import org.opensearch.common.xcontent.XContentHelper;
            task.updateThreadResourceStats(i, ResourceStatsType.WORKER_STATS, taskResourceMetrics);
            "test_description",
        long startTime = randomNonNegativeLong();
 * the Apache License, Version 2.0 (the "License"); you may
                new ResourceUsageMetric(ResourceStats.CPU, cpu) };
}
            runningTime,
import org.opensearch.core.tasks.resourcetracker.ResourceUsageMetric;
            "test_description",
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
            IllegalArgumentException.class,
        long cancellationStartTime = randomNonNegativeLong();
        } catch (IllegalStateException e) {
            cancelled,
        assertEquals(map.get("cancellable"), cancellable);
import org.opensearch.core.tasks.resourcetracker.ResourceStats;
    }
        try {
                new ResourceUsageMetric(ResourceStats.CPU, initial_cpu) };
            () -> new TaskInfo(
                randomResourceStats(randomBoolean())
    public void testCancellableOptionWhenCancelledTrue() {
        boolean cancellable = true;
            cancellable,
import org.opensearch.core.tasks.TaskId;
        assertEquals(((Number) map.get("running_time_in_nanos")).longValue(), runningTime);
        String taskInfoString = taskInfo.toString();
 * SPDX-License-Identifier: Apache-2.0
        // updating should throw an IllegalStateException when active entry is not present.
    }
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
import org.opensearch.action.search.SearchAction;
        long taskId = randomIntBetween(0, 100000);
            ResourceUsageMetric[] initialTaskResourceMetrics = new ResourceUsageMetric[] {
        TaskInfo taskInfo = new TaskInfo(
            "test_type",
            totalMemory += memory - initial_memory;
                Collections.singletonMap("foo", "bar"),
import java.util.Map;
 */
        Map<String, Object> map = XContentHelper.convertToMap(new BytesArray(taskInfoString.getBytes(StandardCharsets.UTF_8)), true).v2();
        long runningTime = randomNonNegativeLong();
public class TaskTests extends OpenSearchTestCase {
        assertEquals(task.getTotalResourceStats().getCpuTimeInNanos(), totalCPU);
            "description",
 *
        // Basic sanity testing that min < average < max < total
        assertEquals(((Number) map.get("id")).longValue(), taskId);
 * You may obtain a copy of the License at
            task.stopThreadResourceTracking(i, ResourceStatsType.WORKER_STATS);
            startTime,
        for (int i = 0; i < randomIntBetween(2, 10); i++) {
        String nodeId = randomAlphaOfLength(10);
        boolean cancellable = true;
            fail("add/start should not be successful as active entry is already present!");
        long runningTime = randomNonNegativeLong();
        );
            fail("update should not be successful as entry for CPU is not present!");
            Collections.emptyMap()
            new TaskId(randomLong() + ":" + randomLong()),
        int threadId = randomInt();
            runningTime,
            totalCPU += cpu - initial_cpu;
                runningTime,
 * not use this file except in compliance with the License.
/*
        // existing active entry is present only for memory, update cannot be called with cpu values.
            long initial_memory = randomLongBetween(1, 100);
        String nodeId = randomAlphaOfLength(10);
import org.opensearch.tasks.TaskInfo;
        assertEquals(map.get("description"), "test_description");
            null,
        assertEquals(map.get("headers"), Collections.singletonMap("foo", "bar"));
    }
    public void testCancellableOptionWhenCancelledFalse() {
            randomLong(),
        long startTime = randomNonNegativeLong();
                new ResourceUsageMetric(ResourceStats.MEMORY, memory),
    public void testTaskInfoToString() {
            Collections.singletonMap("foo", "bar"),
        assertEquals(map.get("cancelled"), cancelled);
            null,
            cancellable,
            long memory = initial_memory + randomLongBetween(1, 10000);
            randomResourceStats(randomBoolean())
            TaskId.EMPTY_TASK_ID,
import static org.opensearch.tasks.TaskInfoTests.randomResourceStats;
        long totalMemory = 0L;
import org.opensearch.test.OpenSearchTestCase;
    public void testNonCancellableOption() {
        assertEquals(map.get("action"), "test_action");
            new TaskId(nodeId, taskId),
        boolean cancelled = false;
                new ResourceUsageMetric(ResourceStats.MEMORY, initial_memory),
import java.nio.charset.StandardCharsets;
        boolean cancelled = true;
            null,
            long cpu = initial_cpu + randomLongBetween(1, 10000);
                startTime,
        } catch (IllegalStateException e) {
    public void testTaskResourceStats() {
        boolean cancelled = false;
 * license agreements. See the NOTICE file distributed with
        );
        try {
            Collections.singletonMap("foo", "bar"),
            long initial_cpu = randomLongBetween(1, 100);
        Map<String, Object> map = XContentHelper.convertToMap(new BytesArray(taskInfoString.getBytes(StandardCharsets.UTF_8)), true).v2();
 * specific language governing permissions and limitations
 *
            fail("update should not be successful as active entry is not present!");
 * ownership. Elasticsearch licenses this file to you under
                cancellable,
        assertEquals(map.get("cancelled"), cancelled);
            new TaskId(nodeId, taskId),
 */
 * Licensed to Elasticsearch under one or more contributor
            "test_type",
        }
            TaskId.EMPTY_TASK_ID,
            task.updateThreadResourceStats(randomInt(), ResourceStatsType.WORKER_STATS);
