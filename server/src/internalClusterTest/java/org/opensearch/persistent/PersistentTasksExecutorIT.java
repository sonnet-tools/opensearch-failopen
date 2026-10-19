            );
import java.util.List;
            .get()
        PlainActionFuture<PersistentTask<?>> removeFuture = new PlainActionFuture<>();
                equalTo(1)
        return true;
        persistentTasksService.sendRemoveRequest(taskId, removeFuture);
    public void testPersistentActionWithNonClusterStateCondition() throws Exception {
import org.opensearch.persistent.TestPersistentTasksPlugin.TestParams;
            // Complete the running task and make sure it finishes properly
 *
            );
        PersistentTasksService persistentTasksService = internalCluster().getInstance(PersistentTasksService.class);
        logger.info("Waiting for persistent task with id {} to disappear", firstRunningTask.getId());
                equalTo(1)
import org.opensearch.persistent.TestPersistentTasksPlugin.State;
                    && task.getState() != null
            .get(0);
            assertThat(
        logger.info("Found running task with id {} and parent {}", firstRunningTask.getId(), firstRunningTask.getParentTaskId());
        TaskInfo taskInfo = client().admin()
        int numberOfUpdates = randomIntBetween(1, 10);
                    .custom(PersistentTasksCustomMetadata.TYPE)).tasks(),
        persistentTasksService.sendUpdateStateRequest(taskId, -2, new State("should fail"), failedUpdateFuture);
        if (randomBoolean()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
}
    }
            List<TaskInfo> tasks = client().admin()
        waitForTaskToStart();
            equalTo(1)
    public void resetNonClusterStateCondition() {
import org.opensearch.test.OpenSearchIntegTestCase;
            .getMetadata()
        }
            .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        assertThat(firstRunningTask.getDescription(), equalTo("id=" + taskId));
        if (randomBoolean()) {
        PersistentTasksService persistentTasksService = internalCluster().getInstance(PersistentTasksService.class);
                .getTasks();
    }
 * license agreements. See the NOTICE file distributed with
        persistentTasksService.sendStartRequest(UUIDs.base64UUID(), TestPersistentTasksExecutor.NAME, testParams, future);
            ResourceNotFoundException.class,
 * SPDX-License-Identifier: Apache-2.0
            equalTo(1)
            // Complete the running task and make sure it finishes properly
            // Wait for the task to finish
        // Remove the persistent task
        logger.info("Found running task with id {} and parent {}", firstRunningTask.getId(), firstRunningTask.getParentTaskId());
        persistentTasksClusterService.setRecheckInterval(TimeValue.timeValueMillis(1));
    }
import java.util.Collection;
            // Wait for the task to start
            .get()
        assertFutureThrows(
            .cluster()
        PlainActionFuture<PersistentTask<TestParams>> future = new PlainActionFuture<>();
 * The OpenSearch Contributors require contributions made to
        assertBusy(() -> {
/*
import org.opensearch.common.unit.TimeValue;
        persistentTasksService.waitForPersistentTaskCondition(taskId, task -> false, TimeValue.timeValueMillis(10), future1);
            new TestTasksRequestBuilder(client()).setOperation("finish").setTaskId(firstRunningTask.getTaskId()).get().getTasks().size(),
import static org.hamcrest.Matchers.notNullValue;
    }
        assertEquals(removeFuture.get().getId(), taskId);
            .get(0);
        return Collections.singletonList(TestPersistentTasksPlugin.class);
        internalCluster().startNode(nodeSettings);
        assertBusy(() -> {
                .cluster()
            assertFutureThrows(failedCompletionNotificationFuture, ResourceNotFoundException.class);
        String taskId = task.getId();
            logger.info("Updating the task states");
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.empty;
        assertBusy(() -> {
        String taskId = future.get().getId();
            WaitForPersistentTaskFuture<?> future1 = new WaitForPersistentTaskFuture<>();
        assertFutureThrows(future1, IllegalStateException.class, "timed out after 10ms");
            .cluster()
        String taskId = future.get().getId();
        WaitForPersistentTaskFuture<?> future1 = new WaitForPersistentTaskFuture<>();
            assertThat(future1.get().getId(), equalTo(taskId));
                    .size(),
            .getTasks()
            .get(0);
        }
    public void testCreatePersistentTaskWithDuplicateId() throws Exception {
        );
        // Fail the running task and make sure it restarts properly
            assertThat(
            .custom(PersistentTasksCustomMetadata.TYPE);
        persistentTasksClusterService.unassignPersistentTask(taskId, task.getAllocationId() + 1, "unassignment test", unassignmentFuture);
            .getTasks()
            .getTasks()
    }
                .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        PersistentTasksClusterService persistentTasksClusterService = internalCluster().getInstance(
        assertThat(
                taskId,
 * Modifications Copyright OpenSearch Contributors. See
            .get()
 * compatible open source license.
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks().size(),
            assertThat(tasks.size(), equalTo(0));
        TaskInfo firstRunningTask = client().admin()
    }
                    && task.getState().toString() != null
            PlainActionFuture<PersistentTask<?>> failedCompletionNotificationFuture = new PlainActionFuture<>();
 * under the License.
        });
        TestParams testParams = new TestParams("Blah");
import org.opensearch.core.tasks.TaskId;
        stopOrCancelTask(firstRunningTask.getTaskId());
            assertThat(
            .get()
        persistentTasksService.waitForPersistentTaskCondition(taskId, Objects::isNull, TimeValue.timeValueSeconds(10), future2);
        assertThat(tasksInProgress.tasks().iterator().next().getState(), nullValue());
 */
            .getTasks()
        });
    public void testUnassignRunningPersistentTask() throws Exception {
import org.opensearch.ResourceNotFoundException;
    public void testPersistentActionWithNoAvailableNode() throws Exception {
        PersistentTasksClusterService persistentTasksClusterService = internalCluster().getInstance(
        String newNode = internalCluster().startNode(nodeSettings);
        // Verifying parent
        TestPersistentTasksExecutor.setNonClusterStateCondition(false);
            assertThat(
    private void stopOrCancelTask(TaskId taskId) {
                .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        testParams.setExecutorNodeAttr("test");
            );
import static org.hamcrest.Matchers.hasSize;
                .getTasks();
            // Wait for the task to disappear completely
        stopOrCancelTask(taskInfo.getTaskId());
            assertClusterStateHasTask(taskId);
            logger.info("Simulating errant completion notification");
                equalTo(1)
            .get(0);
    private void assertNoRunningTasks() throws Exception {
        assertThat(future2.get(), nullValue());
        );
        waitForTaskToStart();
        WaitForPersistentTaskFuture<?> future2 = new WaitForPersistentTaskFuture<>();
            .get(0);
                TimeValue.timeValueSeconds(10),
            assertThat(client().admin().cluster().prepareCancelTasks().setTaskId(taskId).get().getTasks().size(), equalTo(1));
 * Unless required by applicable law or agreed to in writing,
        persistentTasksClusterService.setRecheckInterval(TimeValue.timeValueMillis(1));
                empty()
        for (int i = 0; i < numberOfUpdates; i++) {
                    .setTaskId(firstRunningTask.getTaskId())
            failedUpdateFuture,
            // Wait for the task to start
import org.opensearch.persistent.TestPersistentTasksPlugin.TestPersistentTasksExecutor;
 * KIND, either express or implied.  See the License for the
                    .get()
        waitForTaskToStart();
 * Licensed to Elasticsearch under one or more contributor
            // Cancel the running task and make sure it finishes properly
    }
            .prepareListTasks()
            .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        PlainActionFuture<PersistentTask<TestParams>> future = new PlainActionFuture<>();
    public static class WaitForPersistentTaskFuture<Params extends PersistentTaskParams> extends PlainActionFuture<PersistentTask<Params>>
            );
            );
                empty()
        });
 * not use this file except in compliance with the License.
        assertThat(
        // Speed up rechecks to a rate that is quicker than what settings would allow
            );
        persistentTasksService.sendStartRequest(UUIDs.base64UUID(), TestPersistentTasksExecutor.NAME, testParams, future);
        PersistentTask<TestParams> task = future.get();
        logger.info("Waiting for persistent task with id {} to disappear", firstRunningTask.getId());
        } else {
            // Wait for the task to disappear completely
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks(),
        logger.info("Completing the running task");
            WaitForPersistentTaskListener<Params> {}
import org.opensearch.tasks.TaskInfo;
        persistentTasksService.sendRemoveRequest(taskId, removeFuture);
        assertThat(tasksInProgress.tasks().size(), equalTo(1));
            PersistentTasksClusterService.class,
            PersistentTasksClusterService.class,
        waitForTaskToStart();
        persistentTasksService.sendStartRequest(taskId, TestPersistentTasksExecutor.NAME, new TestParams("Blah"), future);
        assertThat(firstRunningTask.getParentTaskId().getNodeId(), equalTo("cluster"));
            new TestTasksRequestBuilder(client()).setOperation("fail").setTaskId(firstRunningTask.getTaskId()).get().getTasks().size(),
        internalCluster().stopRandomNode(settings -> "test".equals(settings.get("node.attr.test_attr")));
            client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks(),
                equalTo(1)
            List<TaskInfo> tasks = client().admin()
            assertThat(
            logger.info("Cancelling the running task");
 * this file be licensed under the Apache-2.0 license or a
        TestParams testParams = new TestParams("Blah");
                    .size(),
                .get()
 * GitHub history for details.
        // Verifying the task runs on the new node
        assertClusterStateHasTask(taskId);
                new TestTasksRequestBuilder(client()).setOperation("update_status")
        assertThat(firstRunningTask.getParentTaskId().getId(), equalTo(allocationId));
        // Verifying parent and description
            .prepareListTasks()
            // Wait for the task to start
        PersistentTasksService persistentTasksService = internalCluster().getInstance(PersistentTasksService.class);
/*
        assertThat(firstRunningTask.getParentTaskId().getNodeId(), equalTo("cluster"));
            logger.info("Completing the running task");
        // Allow it to be reassigned again to the same node
            .prepareListTasks()
        TaskInfo firstRunningTask = client().admin()
            new TestTasksRequestBuilder(client()).setOperation("finish").setTaskId(firstRunningTask.getTaskId()).get().getTasks().size(),
        PlainActionFuture<PersistentTask<TestParams>> future2 = new PlainActionFuture<>();
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks().size(),
            .getTasks()
            .cluster()
    private static void waitForTaskToStart() throws Exception {
                .prepareListTasks()
        TaskInfo firstRunningTask = client().admin()
            .state()
                    .getTasks()
            assertThat(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String taskId = UUIDs.base64UUID();
        );
        Settings nodeSettings = Settings.builder().put(nodeSettings(0)).put("node.attr.test_attr", "test").build();
                client().admin()
        PersistentTasksService persistentTasksService = internalCluster().getInstance(PersistentTasksService.class);
 * this work for additional information regarding copyright
            .getMetadata()
        PlainActionFuture<PersistentTask<TestParams>> future = new PlainActionFuture<>();
            .getTasks()
        assertThat(unassignedTask.getAssignment().getExplanation(), equalTo("unassignment test"));
        assertBusy(() -> {
        );
        PersistentTasksService persistentTasksService = internalCluster().getInstance(PersistentTasksService.class);
            .prepareListTasks()
            .prepareListTasks()
        PlainActionFuture<PersistentTask<TestParams>> future = new PlainActionFuture<>();
        assertBusy(() -> {
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;
import org.opensearch.plugins.Plugin;
        PlainActionFuture<PersistentTask<TestParams>> future = new PlainActionFuture<>();
        assertNoRunningTasks();
        PlainActionFuture<PersistentTask<TestParams>> future = new PlainActionFuture<>();
            "the task with id " + taskId + " and allocation id -2 doesn't exist"
            );
import org.opensearch.persistent.PersistentTasksService.WaitForPersistentTaskListener;
 * ownership. Elasticsearch licenses this file to you under
    @Before
        long allocationId = future.get().getAllocationId();
        // Fail the running task and make sure it restarts properly
            equalTo(1)
        assertBusy(() -> {
            .cluster()
    @After
 */
                    .cluster()
        assertThat(unassignedTask.getId(), equalTo(taskId));
        assertThat(clusterTasks, hasSize(1));
        );
import org.opensearch.ResourceAlreadyExistsException;
                    .getTasks()
        long allocationId = future.get().getAllocationId();
        TaskInfo firstRunningTask = client().admin()
            assertThat(
            .get()
        // Complete the running task and make sure it finishes properly
 * You may obtain a copy of the License at
        PersistentTasksService persistentTasksService = internalCluster().getInstance(PersistentTasksService.class);
            .prepareListTasks()
        assertThat(firstRunningTask.getParentTaskId().getId(), equalTo(allocationId));
        });
        PlainActionFuture<PersistentTask<TestParams>> future = new PlainActionFuture<>();
 * specific language governing permissions and limitations
/*
            logger.info("Found {} tasks", tasks.size());
        Settings nodeSettings = Settings.builder().put(nodeSettings(0)).put("node.attr.test_attr", "test").build();
                ((PersistentTasksCustomMetadata) internalCluster().clusterService()
        persistentTasksService.sendStartRequest(taskId, TestPersistentTasksExecutor.NAME, new TestParams("Blah"), future);
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks(),
import org.opensearch.persistent.TestPersistentTasksPlugin.TestTasksRequestBuilder;
        TestPersistentTasksExecutor.setNonClusterStateCondition(true);
        logger.info("Completing the running task");
                equalTo(1)
        assertThat(taskInfo.getTaskId().getNodeId(), notNullValue());
            // Wait for the task to disappear completely
        Collection<PersistentTask<?>> clusterTasks = ((PersistentTasksCustomMetadata) internalCluster().clusterService()
        // Complete or cancel the running task
                    .state()
                task -> task != null
            .state()
        String taskId = future.get().getId();
        logger.info("Failing the running task");
    protected boolean ignoreExternalCluster() {
        persistentTasksService.sendStartRequest(UUIDs.base64UUID(), TestPersistentTasksExecutor.NAME, new TestParams("Blah"), future);
            .get(0);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFutureThrows;
    }
        });
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 2)
            .cluster()
        PlainActionFuture<PersistentTask<?>> removeFuture = new PlainActionFuture<>();
    }
            internalCluster().getClusterManagerName()
        PersistentTask<?> unassignedTask = unassignmentFuture.get();
    }
            persistentTasksService.waitForPersistentTaskCondition(
                    .getMetadata()
        // Remove the persistent task
        });
            .cluster()
        );
            assertThat(new TestTasksRequestBuilder(client()).setOperation("finish").setTaskId(taskId).get().getTasks().size(), equalTo(1));
        assertThat(clusterTasks.iterator().next().getId(), equalTo(taskId));
                empty()
        // Wait for the task to disappear
            .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        // Speed up rechecks to a rate that is quicker than what settings would allow
            .getTasks()
        waitForTaskToStart();
package org.opensearch.persistent;
import org.junit.After;
        // Verifying the task can now be assigned
        PersistentTasksCustomMetadata tasksInProgress = internalCluster().clusterService()
        assertBusy(() -> {
        TestPersistentTasksExecutor.setNonClusterStateCondition(true);
    public void testPersistentActionFailure() throws Exception {
        // Disallow re-assignment after it is unallocated to verify cluster-manager and node state
import static org.hamcrest.Matchers.equalTo;
    }
                equalTo(1)
            assertThat(
            // try sending completion request with incorrect allocation id
        });
        persistentTasksService.sendStartRequest(UUIDs.base64UUID(), TestPersistentTasksExecutor.NAME, testParams, future);
        }
                    && task.getState().toString().equals("{\"phase\":\"phase " + (finalI + 1) + "\"}"),
        assertThat(unassignedTask.getAssignment().getExecutorNode(), is(nullValue()));
        assertFutureThrows(future2, ResourceAlreadyExistsException.class);
        assertBusy(() -> {
            );
import static org.hamcrest.core.Is.is;
                .get()
            persistentTasksService.sendCompletionRequest(taskId, Long.MAX_VALUE, null, failedCompletionNotificationFuture);
        assertEquals(removeFuture.get().getId(), taskId);
    private static void assertClusterStateHasTask(String taskId) {
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks().size(),
                    .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        // Verify it starts again
        });
            .setDetailed(true)
    public void testPersistentActionCompletion() throws Exception {
            int finalI = i;
    }
        PlainActionFuture<PersistentTask<?>> unassignmentFuture = new PlainActionFuture<>();
        assertThat(
        TaskInfo taskInfo = client().admin()
 * the Apache License, Version 2.0 (the "License"); you may
    }
 *
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks(),
        TestPersistentTasksExecutor.setNonClusterStateCondition(false);
        String newNodeId = internalCluster().clusterService(newNode).localNode().getId();
        PlainActionFuture<PersistentTask<?>> failedUpdateFuture = new PlainActionFuture<>();
    }
            .setActions(TestPersistentTasksExecutor.NAME + "[c]")
                    .prepareListTasks()
import java.util.Objects;
            // Make sure that the task is still running
                .cluster()
        assertThat(taskInfo.getTaskId().getNodeId(), equalTo(newNodeId));
import org.opensearch.action.support.PlainActionFuture;
        TestPersistentTasksExecutor.setNonClusterStateCondition(true);
        persistentTasksService.sendStartRequest(taskId, TestPersistentTasksExecutor.NAME, new TestParams("Blah"), future2);
            // Wait for the task to start
            assertThat(
            );
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.junit.Before;
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks().size(),
        PersistentTasksService persistentTasksService = internalCluster().getInstance(PersistentTasksService.class);
                future1
            assertThat(tasks.size(), equalTo(0));
            .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        TestParams testParams = new TestParams("Blah");
    public void testPersistentActionStatusUpdate() throws Exception {
    }
 */
            // Make sure the task is removed from the cluster state
import java.util.Collections;
            // Verify that the task is STILL in internal cluster state
                    .setDetailed(true)
            .custom(PersistentTasksCustomMetadata.TYPE)).tasks();
            internalCluster().getClusterManagerName()
        persistentTasksService.sendStartRequest(UUIDs.base64UUID(), TestPersistentTasksExecutor.NAME, new TestParams("Blah"), future);
            .setActions(TestPersistentTasksExecutor.NAME + "[c]")
            .get()
            .cluster()
import org.opensearch.common.UUIDs;
            .get(0);
        TaskInfo taskInfo = client().admin()
            );
                    .get()
        testParams.setExecutorNodeAttr("test");
    @Override
            );
import org.opensearch.common.settings.Settings;
        implements
        assertBusy(() -> {
            .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        assertThat(
            assertThat(
            .prepareListTasks()
 * software distributed under the License is distributed on an
        });
        );
                empty()
            .get()
        future.get();
            empty()
            // Verify that the task is NOT running on the node
public class PersistentTasksExecutorIT extends OpenSearchIntegTestCase {
        String taskId = UUIDs.base64UUID();
                .prepareListTasks()
    public void cleanup() throws Exception {
