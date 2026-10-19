                    .setDetailed(true)
            WaitForPersistentTaskListener<Params> {}  
        PersistentTask<TestParams> task = future.get();
        assertBusy(() -> {  
        Settings nodeSettings = Settings.builder().put(nodeSettings(0)).put("node.attr.test_attr", "test").build();
            new TestTasksRequestBuilder(client()).setOperation("finish").setTaskId(firstRunningTask.getTaskId()).get().getTasks().size(),
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks(),
        persistentTasksService.sendRemoveRequest(taskId, removeFuture);
 * software distributed under the License is distributed on an
                empty()
            empty()
import java.util.Objects;
            .get(0);
            assertThat(new TestTasksRequestBuilder(client()).setOperation("finish").setTaskId(taskId).get().getTasks().size(), equalTo(1));
                equalTo(1)  
            );
        logger.info("Failing the running task");
        assertThat(unassignedTask.getAssignment().getExecutorNode(), is(nullValue()));
        // Verify it starts again
import org.opensearch.common.settings.Settings;
    public void testPersistentActionStatusUpdate() throws Exception {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFutureThrows;
            assertThat(  
            // Wait for the task to disappear completely
        assertFutureThrows(
        Settings nodeSettings = Settings.builder().put(nodeSettings(0)).put("node.attr.test_attr", "test").build();
        String taskId = future.get().getId();  
        // Speed up rechecks to a rate that is quicker than what settings would allow  
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks().size(),
        PlainActionFuture<PersistentTask<TestParams>> future = new PlainActionFuture<>();
            equalTo(1)
 *
            internalCluster().getClusterManagerName()
                    .get()
            PersistentTasksClusterService.class,  
        assertThat(tasksInProgress.tasks().size(), equalTo(1));  
        PlainActionFuture<PersistentTask<TestParams>> future2 = new PlainActionFuture<>();
            // Wait for the task to disappear completely  
            .prepareListTasks()  
import static org.hamcrest.Matchers.equalTo;  
            .get()
                TimeValue.timeValueSeconds(10),  
        WaitForPersistentTaskFuture<?> future1 = new WaitForPersistentTaskFuture<>();  
}
 * this file be licensed under the Apache-2.0 license or a
                equalTo(1)
            assertThat(
                .get()  
            assertThat(tasks.size(), equalTo(0));  
        assertFutureThrows(future2, ResourceAlreadyExistsException.class);  
            // Complete the running task and make sure it finishes properly  
        PersistentTasksClusterService persistentTasksClusterService = internalCluster().getInstance(  
            .state()
            .cluster()
        PersistentTasksService persistentTasksService = internalCluster().getInstance(PersistentTasksService.class);  
        // Verifying the task can now be assigned  
        );
                    .setActions(TestPersistentTasksExecutor.NAME + "[c]")  
            .get()
        );
import static org.hamcrest.Matchers.nullValue;  
            .getMetadata()
        );  
            .get()  
        TestPersistentTasksExecutor.setNonClusterStateCondition(true);
            assertThat(client().admin().cluster().prepareCancelTasks().setTaskId(taskId).get().getTasks().size(), equalTo(1));  
            .setDetailed(true)  
                task -> task != null
        assertBusy(() -> {
    }
        assertClusterStateHasTask(taskId);
        persistentTasksService.sendStartRequest(taskId, TestPersistentTasksExecutor.NAME, new TestParams("Blah"), future);
        assertThat(unassignedTask.getId(), equalTo(taskId));
            assertThat(
        String taskId = task.getId();  
import org.junit.After;
        PersistentTasksService persistentTasksService = internalCluster().getInstance(PersistentTasksService.class);
 * ownership. Elasticsearch licenses this file to you under  
    }
        waitForTaskToStart();  
        WaitForPersistentTaskFuture<?> future2 = new WaitForPersistentTaskFuture<>();
        waitForTaskToStart();
import static org.hamcrest.Matchers.hasSize;
        logger.info("Completing the running task");
        });
            .get(0);
    }
            );  
            );
        assertFutureThrows(future1, IllegalStateException.class, "timed out after 10ms");  
        // Allow it to be reassigned again to the same node
        PlainActionFuture<PersistentTask<TestParams>> future = new PlainActionFuture<>();  
            .getTasks()
        PersistentTasksService persistentTasksService = internalCluster().getInstance(PersistentTasksService.class);
            .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        long allocationId = future.get().getAllocationId();  
    }
        // Remove the persistent task
            .cluster()  
        assertThat(
                new TestTasksRequestBuilder(client()).setOperation("update_status")
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks(),
                .prepareListTasks()
            PlainActionFuture<PersistentTask<?>> failedCompletionNotificationFuture = new PlainActionFuture<>();
        );
            .prepareListTasks()  
                .getTasks();
        });  
        assertThat(taskInfo.getTaskId().getNodeId(), notNullValue());
        persistentTasksService.waitForPersistentTaskCondition(taskId, Objects::isNull, TimeValue.timeValueSeconds(10), future2);  
        assertThat(firstRunningTask.getParentTaskId().getId(), equalTo(allocationId));  
            .prepareListTasks()
/*  
                .cluster()  
import org.opensearch.core.tasks.TaskId;
            .state()  
        assertBusy(() -> {
                .getTasks();
            logger.info("Cancelling the running task");
    }
            );
        );
 * specific language governing permissions and limitations
        assertBusy(() -> {
        assertThat(firstRunningTask.getParentTaskId().getId(), equalTo(allocationId));
        PersistentTasksService persistentTasksService = internalCluster().getInstance(PersistentTasksService.class);  
                equalTo(1)
            // Verify that the task is NOT running on the node
            // Verify that the task is STILL in internal cluster state
        PersistentTasksClusterService persistentTasksClusterService = internalCluster().getInstance(
        PlainActionFuture<PersistentTask<?>> removeFuture = new PlainActionFuture<>();
import org.opensearch.persistent.TestPersistentTasksPlugin.State;
            equalTo(1)  
            .getTasks()  
            assertThat(  
        internalCluster().startNode(nodeSettings);  
            .get(0);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .setActions(TestPersistentTasksExecutor.NAME + "[c]")
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;
        return Collections.singletonList(TestPersistentTasksPlugin.class);
            // Wait for the task to start  
            assertThat(
            persistentTasksService.sendCompletionRequest(taskId, Long.MAX_VALUE, null, failedCompletionNotificationFuture);
                .prepareListTasks()
    protected boolean ignoreExternalCluster() {
        TestPersistentTasksExecutor.setNonClusterStateCondition(true);  
        TaskInfo firstRunningTask = client().admin()
                    && task.getState().toString().equals("{\"phase\":\"phase " + (finalI + 1) + "\"}"),
            equalTo(1)  
        PersistentTasksService persistentTasksService = internalCluster().getInstance(PersistentTasksService.class);
        internalCluster().stopRandomNode(settings -> "test".equals(settings.get("node.attr.test_attr")));  
                    && task.getState().toString() != null
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks().size(),
        String newNode = internalCluster().startNode(nodeSettings);  
    private void stopOrCancelTask(TaskId taskId) {  
        });
        waitForTaskToStart();
        assertThat(future2.get(), nullValue());  
        persistentTasksService.sendStartRequest(UUIDs.base64UUID(), TestPersistentTasksExecutor.NAME, testParams, future);
            );
        for (int i = 0; i < numberOfUpdates; i++) {
        persistentTasksService.sendStartRequest(taskId, TestPersistentTasksExecutor.NAME, new TestParams("Blah"), future);
        stopOrCancelTask(firstRunningTask.getTaskId());  
                    .size(),
        logger.info("Completing the running task");  
        });
            );  
        TestParams testParams = new TestParams("Blah");
                    .size(),  
            int finalI = i;
        assertBusy(() -> {
            assertThat(
        PersistentTask<?> unassignedTask = unassignmentFuture.get();
        future.get();
            );
            .getTasks()
        String taskId = UUIDs.base64UUID();  
            // Wait for the task to disappear completely  
import java.util.Collection;
        });
            // Wait for the task to start
                .get()  
    public void testPersistentActionFailure() throws Exception {
            // Complete the running task and make sure it finishes properly  
        PlainActionFuture<PersistentTask<?>> removeFuture = new PlainActionFuture<>();
        testParams.setExecutorNodeAttr("test");
            .get(0);
                    .prepareListTasks()
                equalTo(1)
        TestPersistentTasksExecutor.setNonClusterStateCondition(true);
 */  
            // Wait for the task to start  
            new TestTasksRequestBuilder(client()).setOperation("fail").setTaskId(firstRunningTask.getTaskId()).get().getTasks().size(),
        PlainActionFuture<PersistentTask<TestParams>> future = new PlainActionFuture<>();
            client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks(),  
        TaskInfo taskInfo = client().admin()
        assertBusy(() -> {
            .prepareListTasks()
        assertThat(
                    .getTasks()
        String taskId = future.get().getId();  
        PlainActionFuture<PersistentTask<?>> failedUpdateFuture = new PlainActionFuture<>();
            assertThat(future1.get().getId(), equalTo(taskId));  
import org.opensearch.persistent.TestPersistentTasksPlugin.TestPersistentTasksExecutor;  
            logger.info("Updating the task states");
    private static void waitForTaskToStart() throws Exception {
        TaskInfo firstRunningTask = client().admin()  
        persistentTasksService.waitForPersistentTaskCondition(taskId, task -> false, TimeValue.timeValueMillis(10), future1);
        assertThat(
            assertThat(
                empty()  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 2)  
            persistentTasksService.waitForPersistentTaskCondition(  
                empty()
            // Make sure the task is removed from the cluster state
        });
    }
            .prepareListTasks()
            .get()  
        TestPersistentTasksExecutor.setNonClusterStateCondition(false);
        PlainActionFuture<PersistentTask<TestParams>> future = new PlainActionFuture<>();
 * Unless required by applicable law or agreed to in writing,
        logger.info("Waiting for persistent task with id {} to disappear", firstRunningTask.getId());
    @After
    public void testPersistentActionWithNoAvailableNode() throws Exception {  
        logger.info("Found running task with id {} and parent {}", firstRunningTask.getId(), firstRunningTask.getParentTaskId());
                ((PersistentTasksCustomMetadata) internalCluster().clusterService()
        // Complete the running task and make sure it finishes properly  
 */  
            );
        TaskInfo taskInfo = client().admin()
 * license agreements. See the NOTICE file distributed with
import org.opensearch.ResourceNotFoundException;
 *    http://www.apache.org/licenses/LICENSE-2.0
            PersistentTasksClusterService.class,
            // Wait for the task to finish
package org.opensearch.persistent;
        persistentTasksClusterService.setRecheckInterval(TimeValue.timeValueMillis(1));
import org.opensearch.common.UUIDs;
            .getTasks()
    private static void assertClusterStateHasTask(String taskId) {
            .cluster()
            .get(0);  
                equalTo(1)
            failedUpdateFuture,
                    .cluster()
/*  
        // Fail the running task and make sure it restarts properly  
        assertEquals(removeFuture.get().getId(), taskId);
            logger.info("Completing the running task");
            assertThat(  
    public void testUnassignRunningPersistentTask() throws Exception {
            );  
        assertThat(unassignedTask.getAssignment().getExplanation(), equalTo("unassignment test"));  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        }
            .getMetadata()
        // Speed up rechecks to a rate that is quicker than what settings would allow
        int numberOfUpdates = randomIntBetween(1, 10);  
                future1
        assertEquals(removeFuture.get().getId(), taskId);  
        }
 */
            .cluster()  
import org.opensearch.plugins.Plugin;
    @Override  
        long allocationId = future.get().getAllocationId();  
                    .state()
import org.opensearch.test.OpenSearchIntegTestCase;
            .cluster()
        persistentTasksClusterService.setRecheckInterval(TimeValue.timeValueMillis(1));
            .custom(PersistentTasksCustomMetadata.TYPE);
import static org.hamcrest.core.Is.is;
import org.opensearch.ResourceAlreadyExistsException;
        stopOrCancelTask(taskInfo.getTaskId());  
        assertThat(taskInfo.getTaskId().getNodeId(), equalTo(newNodeId));
                equalTo(1)  
        TestParams testParams = new TestParams("Blah");
 * GitHub history for details.
        // Wait for the task to disappear
public class PersistentTasksExecutorIT extends OpenSearchIntegTestCase {
        // Verifying parent
    public void resetNonClusterStateCondition() {
        PersistentTasksCustomMetadata tasksInProgress = internalCluster().clusterService()
    }  
        String newNodeId = internalCluster().clusterService(newNode).localNode().getId();
    }  
            );  
            .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        assertThat(tasksInProgress.tasks().iterator().next().getState(), nullValue());
                taskId,
    public static class WaitForPersistentTaskFuture<Params extends PersistentTaskParams> extends PlainActionFuture<PersistentTask<Params>>
                client().admin()  
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks(),
            List<TaskInfo> tasks = client().admin()
            .custom(PersistentTasksCustomMetadata.TYPE)).tasks();  
            .get()
        // Remove the persistent task  
        persistentTasksService.sendRemoveRequest(taskId, removeFuture);  
 * The OpenSearch Contributors require contributions made to  
        });
        assertNoRunningTasks();
        testParams.setExecutorNodeAttr("test");  
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
        PlainActionFuture<PersistentTask<?>> unassignmentFuture = new PlainActionFuture<>();
 *  
        PlainActionFuture<PersistentTask<TestParams>> future = new PlainActionFuture<>();  
        TaskInfo taskInfo = client().admin()
            // Cancel the running task and make sure it finishes properly
            .getTasks()  
                .setActions(TestPersistentTasksExecutor.NAME + "[c]")
            // try sending completion request with incorrect allocation id  
import org.junit.Before;  
            .getTasks()  
    }
        } else {  
            .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        logger.info("Found running task with id {} and parent {}", firstRunningTask.getId(), firstRunningTask.getParentTaskId());  
        persistentTasksService.sendUpdateStateRequest(taskId, -2, new State("should fail"), failedUpdateFuture);  
        logger.info("Waiting for persistent task with id {} to disappear", firstRunningTask.getId());  
                    .setTaskId(firstRunningTask.getTaskId())  
        assertBusy(() -> {  
                .cluster()  
            assertThat(
            WaitForPersistentTaskFuture<?> future1 = new WaitForPersistentTaskFuture<>();
                empty()  
import static org.hamcrest.Matchers.empty;
 * Licensed to Elasticsearch under one or more contributor  
            assertFutureThrows(failedCompletionNotificationFuture, ResourceNotFoundException.class);  
        String taskId = future.get().getId();
                    .custom(PersistentTasksCustomMetadata.TYPE)).tasks(),
    public void cleanup() throws Exception {  
        assertBusy(() -> {
import org.opensearch.action.support.PlainActionFuture;  
    public void testPersistentActionWithNonClusterStateCondition() throws Exception {
        if (randomBoolean()) {
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks().size(),
            List<TaskInfo> tasks = client().admin()
            .prepareListTasks()  
 * not use this file except in compliance with the License.
                    .getMetadata()  
        }
            .get(0);  
    }
            .prepareListTasks()
            ResourceNotFoundException.class,  
        PersistentTasksService persistentTasksService = internalCluster().getInstance(PersistentTasksService.class);
        // Disallow re-assignment after it is unallocated to verify cluster-manager and node state  
        // Verifying parent and description
            new TestTasksRequestBuilder(client()).setOperation("finish").setTaskId(firstRunningTask.getTaskId()).get().getTasks().size(),  
import org.opensearch.common.unit.TimeValue;  
import static org.hamcrest.Matchers.notNullValue;
        waitForTaskToStart();
            .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        return true;  
/*
            assertThat(  
            .setActions(TestPersistentTasksExecutor.NAME + "[c]")  
    }  
        PlainActionFuture<PersistentTask<TestParams>> future = new PlainActionFuture<>();
        assertThat(firstRunningTask.getDescription(), equalTo("id=" + taskId));
 * under the License.  
        );
        TaskInfo firstRunningTask = client().admin()
            "the task with id " + taskId + " and allocation id -2 doesn't exist"
    private void assertNoRunningTasks() throws Exception {
    }  
        TestPersistentTasksExecutor.setNonClusterStateCondition(false);  
    }
            // Make sure that the task is still running
        persistentTasksService.sendStartRequest(UUIDs.base64UUID(), TestPersistentTasksExecutor.NAME, new TestParams("Blah"), future);
    }  
 * compatible open source license.
        });
    @Before  
 *
    public void testPersistentActionCompletion() throws Exception {
 * this work for additional information regarding copyright
        PersistentTasksService persistentTasksService = internalCluster().getInstance(PersistentTasksService.class);
        PlainActionFuture<PersistentTask<TestParams>> future = new PlainActionFuture<>();
            .cluster()  
            .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        waitForTaskToStart();  
        assertThat(firstRunningTask.getParentTaskId().getNodeId(), equalTo("cluster"));
        Collection<PersistentTask<?>> clusterTasks = ((PersistentTasksCustomMetadata) internalCluster().clusterService()  
        TestParams testParams = new TestParams("Blah");  
        if (randomBoolean()) {
        });
                .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        persistentTasksService.sendStartRequest(taskId, TestPersistentTasksExecutor.NAME, new TestParams("Blah"), future2);
        persistentTasksService.sendStartRequest(UUIDs.base64UUID(), TestPersistentTasksExecutor.NAME, new TestParams("Blah"), future);  
            assertThat(tasks.size(), equalTo(0));
 * You may obtain a copy of the License at  
        persistentTasksClusterService.unassignPersistentTask(taskId, task.getAllocationId() + 1, "unassignment test", unassignmentFuture);  
            assertClusterStateHasTask(taskId);
            .get()
 * SPDX-License-Identifier: Apache-2.0
        assertThat(clusterTasks.iterator().next().getId(), equalTo(taskId));
            logger.info("Found {} tasks", tasks.size());
import org.opensearch.persistent.TestPersistentTasksPlugin.TestParams;
        implements
            .cluster()
        assertThat(
        assertThat(firstRunningTask.getParentTaskId().getNodeId(), equalTo("cluster"));  
import org.opensearch.persistent.PersistentTasksService.WaitForPersistentTaskListener;  
            .get()
    public void testCreatePersistentTaskWithDuplicateId() throws Exception {  
        // Complete or cancel the running task
        TaskInfo firstRunningTask = client().admin()
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks().size(),
 * KIND, either express or implied.  See the License for the
            internalCluster().getClusterManagerName()
                    .get()
            .get(0);
            // Wait for the task to start
        persistentTasksService.sendStartRequest(UUIDs.base64UUID(), TestPersistentTasksExecutor.NAME, testParams, future);
    }
                    .getTasks()  
                    && task.getState() != null  
        assertThat(clusterTasks, hasSize(1));
            .getTasks()
        String taskId = UUIDs.base64UUID();
        // Verifying the task runs on the new node  
        // Fail the running task and make sure it restarts properly
        );
        persistentTasksService.sendStartRequest(UUIDs.base64UUID(), TestPersistentTasksExecutor.NAME, testParams, future);
            logger.info("Simulating errant completion notification");
import java.util.List;
import java.util.Collections;  
import org.opensearch.persistent.TestPersistentTasksPlugin.TestTasksRequestBuilder;
            );  
        assertBusy(() -> {
import org.opensearch.tasks.TaskInfo;  
