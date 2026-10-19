        TaskInfo taskInfo = new TaskInfo(
package org.opensearch.action.admin.cluster.node.tasks;
        boolean cancellable = true;
            randomLong(),
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.tasks.TaskId;  
import org.opensearch.core.common.bytes.BytesArray;
                "test_description",  
        String nodeId = randomAlphaOfLength(10);  
            cancelled,
        }
            cancelled,
            long initial_memory = randomLongBetween(1, 100);
            // pass
        boolean cancellable = false;  
        String nodeId = randomAlphaOfLength(10);  
import org.opensearch.core.tasks.resourcetracker.ResourceUsageMetric;  
            null,  
        }
            task.updateThreadResourceStats(i, ResourceStatsType.WORKER_STATS, taskResourceMetrics);
 * KIND, either express or implied.  See the License for the
/*
        assertEquals(e.getMessage(), "task cannot be cancelled");
                new ResourceUsageMetric(ResourceStats.CPU, cpu) };  
            cancellationStartTime
            new TaskId(nodeId, taskId),
            new TaskId(nodeId, taskId),  
 */
 * license agreements. See the NOTICE file distributed with
            "test_description",  
        String taskInfoString = taskInfo.toString();
            () -> new TaskInfo(
            task.startThreadResourceTracking(threadId, ResourceStatsType.WORKER_STATS);
        assertTrue(task.getMinResourceStats().getMemoryInBytes() < task.getAverageResourceStats().getMemoryInBytes());
            fail("add/start should not be successful as active entry is already present!");  
            IllegalArgumentException.class,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
        long runningTime = randomNonNegativeLong();  
public class TaskTests extends OpenSearchTestCase {
        assertEquals(((Number) map.get("start_time_in_millis")).longValue(), startTime);
        task.startThreadResourceTracking(threadId, ResourceStatsType.WORKER_STATS, new ResourceUsageMetric(ResourceStats.MEMORY, 100));  
        boolean cancellable = true;
    public void testTaskResourceStats() {
        } catch (IllegalStateException e) {  
            "test_type",
            ResourceUsageMetric[] taskResourceMetrics = new ResourceUsageMetric[] {
 *  
                runningTime,  
import org.opensearch.tasks.TaskInfo;
        );
                new ResourceUsageMetric(ResourceStats.MEMORY, memory),
                new ResourceUsageMetric(ResourceStats.CPU, initial_cpu) };
    }  
            cancelled,  
            randomResourceStats(randomBoolean())
        assertEquals(map.get("headers"), Collections.singletonMap("foo", "bar"));
        );
            totalMemory += memory - initial_memory;
        Map<String, Object> map = XContentHelper.convertToMap(new BytesArray(taskInfoString.getBytes(StandardCharsets.UTF_8)), true).v2();
        String nodeId = randomAlphaOfLength(10);  
import org.opensearch.action.search.SearchAction;  
    public void testCancellableOptionWhenCancelledFalse() {
        assertEquals(map.get("cancelled"), cancelled);
        assertEquals(map.get("action"), "test_action");
/*  
 */
 *
                "test_type",
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
                null,
        }  
            )  
            Collections.singletonMap("foo", "bar"),
            runningTime,
            randomResourceStats(randomBoolean())  
 * ownership. Elasticsearch licenses this file to you under  
            startTime,
                randomResourceStats(randomBoolean())
 * software distributed under the License is distributed on an
        // re-adding a thread entry that is already present, should throw an exception
        long taskId = randomIntBetween(0, 100000);
            "test_type",
            Collections.singletonMap("foo", "bar"),  
            "test_action",  
            cancellable,
        // existing active entry is present only for memory, update cannot be called with cpu values.
        assertEquals(map.get("type"), "test_type");
                cancellable,
        assertEquals(((Number) map.get("id")).longValue(), taskId);  
        long runningTime = randomNonNegativeLong();  
        TaskInfo taskInfo = new TaskInfo(
        long totalMemory = 0L;  
        assertEquals(map.get("cancellable"), cancellable);
            TaskId.EMPTY_TASK_ID,  
            task.updateThreadResourceStats(threadId, ResourceStatsType.WORKER_STATS, new ResourceUsageMetric(ResourceStats.CPU, 200));
        assertTrue(task.getAverageResourceStats().getMemoryInBytes() < task.getMaxResourceStats().getMemoryInBytes());
    }  
        long taskId = randomIntBetween(0, 100000);
        boolean cancelled = false;
            TaskId.EMPTY_TASK_ID,
import java.util.Map;
    public void testTaskInfoToString() {
            task.updateThreadResourceStats(randomInt(), ResourceStatsType.WORKER_STATS);
import org.opensearch.core.tasks.resourcetracker.ResourceStats;
            "test_type",  
        assertEquals(task.getTotalResourceStats().getMemoryInBytes(), totalMemory);
            "test_description",
            fail("update should not be successful as entry for CPU is not present!");
        for (int i = 0; i < randomIntBetween(2, 10); i++) {
        long startTime = randomNonNegativeLong();
 * this work for additional information regarding copyright
            "test_description",
            fail("update should not be successful as active entry is not present!");
            "description",
            ResourceUsageMetric[] initialTaskResourceMetrics = new ResourceUsageMetric[] {
    }  
        );  
 * GitHub history for details.
        // Basic sanity testing that min < average < max < total  
        );
        );  
        assertEquals(map.get("cancelled"), cancelled);
        String taskInfoString = taskInfo.toString();
        assertEquals(map.get("cancelled"), cancelled);
        // reporting resource consumption events and checking total consumption values  
        } catch (IllegalStateException e) {
        long runningTime = randomNonNegativeLong();
                new ResourceUsageMetric(ResourceStats.MEMORY, initial_memory),  
            new TaskId(nodeId, taskId),
            new TaskId(randomLong() + ":" + randomLong()),
            null,
            SearchAction.NAME,  
 * Licensed to Elasticsearch under one or more contributor  
        long runningTime = randomNonNegativeLong();  
            null,
            cancellable,  
            Collections.singletonMap("foo", "bar"),
            startTime,
            randomResourceStats(randomBoolean()),
                TaskId.EMPTY_TASK_ID,  
            task.stopThreadResourceTracking(i, ResourceStatsType.WORKER_STATS);
        assertEquals(map.get("cancellation_time_millis"), cancellationStartTime);
        assertTrue(task.getMaxResourceStats().getMemoryInBytes() < task.getTotalResourceStats().getMemoryInBytes());  
        }  
 * Unless required by applicable law or agreed to in writing,
        String taskInfoString = taskInfo.toString();
        String nodeId = randomAlphaOfLength(10);
            "test_action",
import static org.opensearch.tasks.TaskInfoTests.randomResourceStats;  
 * compatible open source license.
}
        final Task task = new Task(  
        try {  
    }  
    public void testNonCancellableOption() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        boolean cancelled = true;
            runningTime,
        boolean cancelled = true;  
                cancelled,
/*
        Map<String, Object> map = XContentHelper.convertToMap(new BytesArray(taskInfoString.getBytes(StandardCharsets.UTF_8)), true).v2();
 * Modifications Copyright OpenSearch Contributors. See  
            "transport",
        try {
        long startTime = randomNonNegativeLong();
        Exception e = expectThrows(  
        long cancellationStartTime = randomNonNegativeLong();
            TaskId.EMPTY_TASK_ID,
 *
import org.opensearch.core.tasks.resourcetracker.ResourceStatsType;
        // updating should throw an IllegalStateException when active entry is not present.
        boolean cancelled = false;
        assertEquals(map.get("description"), "test_description");  
        long startTime = randomNonNegativeLong();
 * You may obtain a copy of the License at  
        long taskId = randomIntBetween(0, 100000);
            "test_action",
        } catch (IllegalStateException e) {  
            Collections.emptyMap()  
            long initial_cpu = randomLongBetween(1, 100);  
        assertEquals(((Number) map.get("running_time_in_nanos")).longValue(), runningTime);
import org.opensearch.tasks.Task;
            totalCPU += cpu - initial_cpu;
            long memory = initial_memory + randomLongBetween(1, 10000);
        long totalCPU = 0L;
        assertEquals(map.get("cancellable"), cancellable);  
        TaskInfo taskInfo = new TaskInfo(  
            task.startThreadResourceTracking(i, ResourceStatsType.WORKER_STATS, initialTaskResourceMetrics);
 * The OpenSearch Contributors require contributions made to  
    public void testCancellableOptionWhenCancelledTrue() {
        long taskId = randomIntBetween(0, 100000);  
            cancellable,
        try {  
                "test_action",
 */  
                Collections.singletonMap("foo", "bar"),
        Map<String, Object> map = XContentHelper.convertToMap(new BytesArray(taskInfoString.getBytes(StandardCharsets.UTF_8)), true).v2();  
import java.util.Collections;  
        assertEquals(task.getTotalResourceStats().getCpuTimeInNanos(), totalCPU);
            // pass
                startTime,
import java.nio.charset.StandardCharsets;
        assertEquals(map.get("cancellable"), cancellable);  
        boolean cancellable = false;
            long cpu = initial_cpu + randomLongBetween(1, 10000);
import org.opensearch.test.OpenSearchTestCase;  
 * not use this file except in compliance with the License.
    }  
        long startTime = randomNonNegativeLong();
        int threadId = randomInt();
            // pass
                new TaskId(nodeId, taskId),  
 * under the License.  
            startTime,  
import org.opensearch.common.xcontent.XContentHelper;
            runningTime,  
