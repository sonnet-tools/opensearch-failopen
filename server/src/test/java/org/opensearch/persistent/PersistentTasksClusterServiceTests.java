        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
    /**  
            assertThat(task.isAssigned(), equalTo(true));  
        String id = UUIDs.base64UUID();
    }  
import org.junit.After;  
        for (int i = 0; i < concurrentUpdates; i++) {
                }  
            .add(new DiscoveryNode("_node_2", buildNewFakeTransportAddress(), Version.CURRENT))  
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        String taskId = addTask(tasks, "assign_me", "_node_1");
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
import org.opensearch.ResourceNotFoundException;
                        shouldSimulateFailure
    public void testUpdatePersistentTaskStateDelegation() throws Exception {
            TestPersistentTasksExecutor.NAME,
                    return builder.build();
                );
        ClusterState previous = ClusterState.builder(new ClusterName("_name")).nodes(nodes).metadata(metadata).build();  
                    assertThat(task.getExecutorNode(), nullValue());
import java.util.concurrent.atomic.AtomicReference;  
        service.unassignPersistentTask(taskId, tasks.getLastAllocationId(), "test unassign reason", ActionListener.wrap(task -> {
        ClusterState clusterState = initialState();
        assertThat(result.executionResults.get(removeEntry).isSuccess(), is(true));
            .clusterManagerNodeId("_node_1");
                default:
        );  
        }
            .remove(taskId);
                    fail("unknown param " + testParams.getTestParam());  
            .create(newTaskId, TestPersistentTasksExecutor.NAME, new TestParams("assign_me"));
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))  
        assertTrue("all updates should complete within timeout", allCompleted.await(30, TimeUnit.SECONDS));  
    }
        }
        for (PersistentTask<?> task : tasksInProgress.tasks()) {  
            current = ClusterState.builder(previous).build();
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
                assertThat(task.getExecutorNode(), nullValue());  
                tasks.addTask(UUIDs.base64UUID(), TestPersistentTasksExecutor.NAME, new TestParams(param), assignment).build()
            nodeList.add(node);
    public void testCompleteWithNonExistingTask() {
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        }  
        }  
            "unassignment test"  
        }, e -> fail()));
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());  
            .metadata(Metadata.builder().putCustom(PersistentTasksCustomMetadata.TYPE, currentTasks))
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
    }
        // Use a barrier to ensure all threads submit simultaneously  
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        // Use a wrong allocation id - task exists but allocation id doesn't match
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();  
                Metadata.Builder metadata = Metadata.builder(clusterState.metadata());
import org.opensearch.common.UUIDs;
        assertThat(updatedTasks.getTask(taskToUnassign).getAssignment().getExplanation(), equalTo("unassignment test"));  
                    // add an unassigned task that should get assigned because it's assigned to a non-existing node or unassigned  
     * Tests that createPersistentTask triggers the periodic rechecker when
            new TestPersistentTasksPlugin.State("test")  
            for (PersistentTask<?> task : tasksInProgress.tasks()) {
        assertBusy(() -> assertThat(completed.get(), is(true)));
            Arrays.asList(createEntry, updateEntry, removeEntry, completeEntry, unassignEntry)
                case "assign_one":
            return NO_NODE_FOUND;  
    @Before  
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
    private DiscoveryNode newNode(String nodeId) {  
                            : "non-cluster state condition prevents assignment"
        // "task wasn't found" branch, NOT the "different allocation id" branch.
            .clusterManagerNodeId("_node")
        assertThat(updatedTasks.getTask(taskToUpdate), is(notNullValue()));  
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();  
        ClusterState clusterState = initialState();  
            } else {  
    /**
 * compatible open source license.
    private String dumpEvent(ClusterChangedEvent event) {
package org.opensearch.persistent;
    }
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(initialState.nodes());
        DiscoveryNodes nodes = DiscoveryNodes.builder()
            if (randomBoolean()) {
 * Unless required by applicable law or agreed to in writing,
     * verifying the listener callback receives the unassigned task.
        nodes.clusterManagerNodeId("a_new_cluster_manager_node");
            assertThat(task, is(notNullValue()));
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);  
            Collections.singletonList(entry)
        ClusterState clusterState = initialState();
    public void testCreatePersistentTaskDelegation() throws Exception {
        }  
        assertThat(result.executionResults.get(completeEntry).isSuccess(), is(true));
        ClusterState.Builder builder = ClusterState.builder(clusterState);  
        ClusterState clusterState = initialState();  
    public void testCreatePersistentTaskTriggersRecheckerWhenUnassigned() throws Exception {
        );  
            assertThat(task.getAssignment().getExecutorNode(), is(nullValue()));
        assertThat(updatedTasks.getTask(taskToUpdate).getState(), equalTo(newState));
            nodes.add(new DiscoveryNode("other_node_" + i, buildNewFakeTransportAddress(), Version.CURRENT));
        );
    }
            singleton(new PersistentTasksExecutor<P>(TestPersistentTasksExecutor.NAME, null) {
 *
            .putCustom(PersistentTasksCustomMetadata.TYPE, tasks)
            "non-existing-task",  
        assertThat(tasksInProgress.tasks().size(), equalTo(1));  
        // add a node if there are unassigned tasks
                .build();  
            () -> assertTrue("periodic rechecker should be scheduled for unassigned task", service.getPeriodicRechecker().isScheduled())
        } else {
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
    public void testUnassignTask() {
        // Try to create a task with the same id as an existing task
        }
        int concurrentUpdates = 10;
        for (final String node : nodes.getNodes().keySet()) {  
            .build();
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
                            Settings.builder()  
import static org.mockito.Mockito.any;
        );
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        // Now simulate the node ceasing to be the cluster-manager  
 * KIND, either express or implied.  See the License for the
        );  
import static org.hamcrest.Matchers.notNullValue;
            for (PersistentTask<?> task : tasksInProgress.tasks()) {
        final boolean changed = randomBoolean();
        Metadata.Builder metadata,
        for (int i = 0; i < numberOfTasks; i++) {  
    }
 */  
        // Verify throttling key is available  
import org.opensearch.Version;  
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
            return randomNodeAssignment(nodes);
                .metadata(  
                case 2:
            completed.set(true);
import org.opensearch.cluster.ClusterStateTaskExecutor;
        clusterState = builder.metadata(metadata).nodes(nodes).build();
        );
            }
            .numberOfShards(1)
        );  
        if (tasks == null || tasks.tasks().isEmpty()) {  
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        // add a new unassigned task
        assertThat(updateEntry.toString(), equalTo("UPDATE_STATE[" + taskToUpdate + "]"));
            .addTask("_task_1", "test", null, new Assignment("_node_1", ""))
import static org.opensearch.persistent.PersistentTasksClusterService.needsReassignment;
        assertThat(result.executionResults.get(entry).isSuccess(), is(false));
    }
    public void testPersistentTasksChangedTaskRemoved() {  
import java.util.concurrent.CountDownLatch;
import java.util.function.BiFunction;
        );
    }  
        assertThat(result.executionResults.get(entry).getFailure(), instanceOf(ResourceNotFoundException.class));
                        assertThat(task.getId(), equalTo(taskId));
                builder.metadata(metadata).routingTable(routingTable.build());  
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
            999999L,
            .add(new DiscoveryNode("_node_2", buildNewFakeTransportAddress(), Version.CURRENT))
        assertThat(createEntry.toString(), equalTo("CREATE[" + newTaskId + "]"));  
        });  
        int assignOneCount = 0;
            .clusterManagerNodeId("_node_1")
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();  
        addTask(tasks, "assign_based_on_non_cluster_state_condition", null);  
        PersistentTasksCustomMetadata updatedTasks = result.resultingState.metadata().custom(PersistentTasksCustomMetadata.TYPE);
        if (node != null) {
                    throw new UnsupportedOperationException();  
        ClusterService recheckTestClusterService = createRecheckTestClusterService(clusterState, shouldSimulateFailure);
            .localNodeId("_node_1")  
            999999L
                protected void nodeOperation(AllocatedPersistentTask task, P params, PersistentTaskState state) {
        nonClusterStateCondition = true;
            new TestParams("assign_me")
            .clusterManagerNodeId("_node_1");
        ClusterState.Builder builder = ClusterState.builder(clusterState);
 * Modifications Copyright OpenSearch Contributors. See
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
        for (PersistentTask<?> task : tasksInProgress.tasks()) {
                addRandomTask(builder, Metadata.builder(clusterState.metadata()), PersistentTasksCustomMetadata.builder(tasks), null);  
        DiscoveryNodes nodes = DiscoveryNodes.builder()
        }
            assertThat(tasksInProgress.tasks().size(), equalTo(1));
            .metadata(Metadata.builder().putCustom(PersistentTasksCustomMetadata.TYPE, tasks))  
        return service.reassignTasks(clusterState);
        );
                if ("never_assign".equals(((TestParams) task.getParams()).getTestParam())
            (params, currentState) -> assignBasedOnNonClusterStateCondition(currentState.nodes())
        ClusterState clusterState = initialState();
     * getTaskWithId could return null.
        setState(clusterService, clusterState);
        assertThat(tasksInProgress, notNullValue());  
            .build();
            .build();
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);  
        // First entry: REMOVE the task (will succeed)
        );
        });
        PersistentTasksCustomMetadata previousTasks = PersistentTasksCustomMetadata.builder()  
            .numberOfShards(1)
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
    }  
                        logger.error("unexpected failure for task " + taskId, e);
            Collections.singletonList(entry)
        PersistentTasksCustomMetadata tasks = clusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);  
            .unassign(taskToUnassign, builtTasks.getTask(taskToUnassign).getAllocationId(), "unassignment test");
/*  
        ClusterState previous = ClusterState.builder(new ClusterName("_name"))  
        String param
        AtomicBoolean completed2 = new AtomicBoolean(false);  
        int numberOfIterations = randomIntBetween(1, 30);  
        // task can never be assigned while nonClusterStateCondition = false  
            boolean changed = false;
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(
        }, e -> fail()));
                                .build()
            .nodes(nodes)
    @After
import org.opensearch.cluster.metadata.Metadata;
                    assertThat(task.getAssignment().getExplanation(), equalTo("no appropriate nodes found for the assignment"));
        addTestNodes(nodes, randomIntBetween(1, 3));
        ClusterState initialState = initialState();
            .localNodeId("_node_1")
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
            .settings(Settings.builder().put("index.version.created", VersionUtils.randomVersion(random())))
            completed.set(true);  
            ActionListener.wrap(task -> fail(), e -> assertThat(e, instanceOf(ResourceNotFoundException.class)))
        assertThat(tasksInProgress, notNullValue());  
            RoutingTable.Builder routingTable = RoutingTable.builder(clusterState.routingTable());
            initialState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        AtomicReference<ClusterState> state = new AtomicReference<>(initialState);
        ClusterState current = ClusterState.builder(new ClusterName("_name"))  
        addTask(tasks, "assign_based_on_non_cluster_state_condition", null);  
 * specific language governing permissions and limitations
        PersistentTasksCustomMetadata tasks = PersistentTasksCustomMetadata.builder()  
        final PersistentTasksClusterService service = createService((params, clusterState) -> randomNodeAssignment(clusterState.nodes()));
        );  
            }  
        AtomicBoolean completed = new AtomicBoolean(false);
                Settings.builder()  
    }  
        assertThat(updateTaskState.getThreshold(), equalTo(300));
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
import static java.util.Collections.singleton;
/*  
                task.onFailure("testing failure", new RuntimeException("foo"));  
                    break;
        return tasks.tasks().stream().anyMatch(task -> {  
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
            // remove a node that doesn't have any tasks assigned to it and it's not the cluster-manager node
        } else {
            .localNodeId("_node_1")  
            changeRoutingTable(metadata, routingTable);
    /**  
            .addTask("_task_3", "test", null, new Assignment("_node_2", "_reason"))
        assertThat(dumpEvent(event), service.shouldReassignPersistentTasks(event), equalTo(changed && unassigned));
            .clusterManagerNodeId("_node_1");  
                    addRandomTask(builder, Metadata.builder(clusterState.metadata()), tasksBuilder, NO_NODE_FOUND, "never_assign");
        setState(clusterService, clusterState);
import java.util.concurrent.TimeUnit;
public class PersistentTasksClusterServiceTests extends OpenSearchTestCase {
        ClusterState clusterState = initialState();
        PersistentTasksClusterService.PersistentTaskUpdateEntry removeEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry  
            ClusterState previousState = clusterState;
                    Metadata.builder(previous.metadata())
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
            assertThat(task.getAssignment().getExplanation(), equalTo("non-cluster state condition prevents assignment"));
        // This ensures no NPE from getTaskWithId().getTaskName() on a removed task.  
                    if (clusterState.nodes().nodeExists(task.getExecutorNode()) == false) {  
        assertThat(executor.getClusterManagerThrottlingKey(), is(notNullValue()));
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());  
        assertThat(result.executionResults.get(entry).isSuccess(), is(false));
                    addTask(tasks, "dont_assign_me", randomBoolean() ? null : "no_longer_exists");
        DiscoveryNodes nodes = DiscoveryNodes.builder()
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
        if (hasAssignableTasks(tasks, clusterState.nodes()) == false) {
    }
            assertThat(tasksInProgress, notNullValue());
            .clusterManagerNodeId("_node_1");
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));  
        ClusterState clusterState = initialState();
        PersistentTasksCustomMetadata updatedTasks = result.resultingState.metadata().custom(PersistentTasksCustomMetadata.TYPE);
                } catch (Exception e) {
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
            if (task.getExecutorNode() == null || discoveryNodes.nodeExists(task.getExecutorNode())) {
        clusterState = builder.metadata(metadata).nodes(nodes).build();
        assertThat(updatedTasks.getTask(taskToRemove), is(nullValue()));  
        );
            clusterState,  
        // Just add a random index - that shouldn't change anything
            final PersistentTaskState newState = new TestPersistentTasksPlugin.State("phase_" + i);
                    equalTo(
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
            .build();  
        Metadata.Builder metadata = Metadata.builder();
            logger.info("inter {} significant: {}", i, significant);
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        PersistentTasksClusterService.PersistentTaskUpdateEntry entry = PersistentTasksClusterService.PersistentTaskUpdateEntry.updateState(  
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
import org.opensearch.cluster.node.DiscoveryNodeRole;  
            assertThat(task.getId(), equalTo(taskId));
        PersistentTasksClusterService.PersistentTaskUpdateEntry createEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        ClusterState clusterState = initialState();
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
        service.clusterChanged(event);  
    private ClusterState.Builder addRandomTask(  
            }
        setState(clusterService, clusterState);  
        PersistentTasksCustomMetadata.Builder tasks,  
        ClusterState clusterState = initialState();  
        if (randomBoolean()) {
            .build();
                        assertThat("more than one assign_one tasks are assigned", assignOneCount, lessThanOrEqualTo(1));  
                Metadata.Builder metadata = Metadata.builder(clusterState.metadata())  
                case "dont_assign_me":
            final String taskId = taskIds.get(i);
            + event.routingTableChanged()
        ClusterState clusterState = builder.metadata(metadata).nodes(nodes).build();
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);  
        service.unassignPersistentTask(unassignedId, tasks.getLastAllocationId(), "unassignment test", ActionListener.wrap(task -> {
                logger.info("removed all tasks");
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
     * are actually batched into a single execute() call by the TaskBatcher.
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(
                    logger.info("added random node");
     * verifying the listener callback receives the created task with correct assignment.
        PersistentTasksClusterService.PersistentTaskUpdateEntry entry = PersistentTasksClusterService.PersistentTaskUpdateEntry.updateState(
            assertThat(task.getState(), equalTo(newState));
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
    }
        addTestNodes(nodes, randomIntBetween(1, 10));
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
import org.opensearch.cluster.node.DiscoveryNode;
        for (int i = 0; i < concurrentUpdates; i++) {  
     * Tests the createPersistentTask end-to-end delegation through the batched path,
                addRandomTask(
        );
                    service.updatePersistentTaskState(taskId, allocationId, newState, ActionListener.wrap(task -> {  
     * Tests that unassignPersistentTask works correctly through the batched delegation path,
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test assignment"));
            "non-existing-task",
        return id;  
        List<String> taskIds = new ArrayList<>();
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        assertBusy(() -> assertThat(completed2.get(), is(true)));
            )
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
    public void testBatchedCompleteAfterRemoveDoesNotNPE() {
            ClusterStateUpdateTask task = (ClusterStateUpdateTask) invocationOnMock.getArguments()[1];
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        // Return NO_NODE_FOUND so the task ends up unassigned
        for (PersistentTask<?> task : tasksInProgress.tasks()) {
        assertThat(createdTask.get().getId(), equalTo(taskId));
        );  
            assertThat(task.getAssignment().getExplanation(), equalTo("test assignment"));
            if (randomBoolean()) {
                case 0:
        nodes = DiscoveryNodes.builder(clusterState.nodes());
        // Pre-create tasks that we'll update concurrently  
            return new Assignment(null, "non-cluster state condition prevents assignment");  
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);  
import static org.hamcrest.core.Is.is;  
            completed1.set(true);
            switch (((TestParams) task.getParams()).getTestParam()) {
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))  
            AtomicBoolean success = new AtomicBoolean(false);  
                Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).removeCustom(PersistentTasksCustomMetadata.TYPE);
            .clusterManagerNodeId("_node_1");
            assertThat(task.getAssignment().getExplanation(), equalTo("test unassign reason"));
        ClusterState finalClusterState = reassign(service, newClusterState);  
            .build();
        assertBusy(() -> {
 * software distributed under the License is distributed on an
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
    public void testReassignTasksWithNoTasks() {
        assertFalse("persistent tasks unchanged (no tasks)", persistentTasksChanged(new ClusterChangedEvent("test", current, previous)));
                assertThat(task, is(notNullValue()));  
                assertThat(task.isAssigned(), equalTo(true));  
        String taskId = addTask(tasks, "assign_me", "_node_1");  
import org.opensearch.cluster.ClusterStateUpdateTask;
        if (nodes.getNodes().isEmpty()) {
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        PersistentTasksClusterService.PersistentTaskUpdateEntry completeEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry
        assertThat(result.executionResults.get(entry).isSuccess(), is(false));
        final PersistentTasksClusterService service = createService(  
        PersistentTasksClusterService.PersistentTaskUpdateEntry updateEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // The rechecker should recheck indefinitely on the cluster-manager node as the
        setState(clusterService, clusterState);
        // Second entry: COMPLETE the same task with wrong allocation ID  
        }
import static org.mockito.Mockito.mock;
                    && "change me".equals(task.getAssignment().getExplanation())) {  
import static org.opensearch.persistent.PersistentTasksClusterService.persistentTasksChanged;  
    public void setUp() throws Exception {
        addTestNodes(nodes, randomIntBetween(1, 10));
        ClusterState clusterState = initialState();
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
    public static void tearDownThreadPool() {
        DiscoveryNodes nodes = DiscoveryNodes.builder()  
        addTestNodes(nodes, randomIntBetween(1, 3));
                metadata.putCustom(PersistentTasksCustomMetadata.TYPE, tasksBuilder.build());  
        clusterState = builder.metadata(metadata).nodes(nodes).build();
                        allCompleted.countDown();
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
            .remove(existingTask);
        PersistentTasksCustomMetadata builtTasks = tasks.build();
        assertBusy(
 * SPDX-License-Identifier: Apache-2.0
    }
    }
                    new Assignment(null, "change me"),
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            TestParams testParams = (TestParams) params;
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
        EnableAssignmentDecider.Allocation allocation = randomFrom(EnableAssignmentDecider.Allocation.values());
        metadata.put(indexMetadata, false);
        ClusterState clusterState = initialState();  
        assertTrue("persistent tasks changed (task assigned)", persistentTasksChanged(new ClusterChangedEvent("test", current, previous)));
                    }
                logger.info("changed routing table");
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();  
                    return assignBasedOnNonClusterStateCondition(currentState.nodes());
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        ClusterState clusterState = initialState();  
        String taskToUnassign = addTask(tasks, "assign_me", "_node_1");
        PersistentTasksCustomMetadata tasksInProgress = clusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);  
            .localNodeId("_node_1")
        String taskId = addTask(tasks, "assign_me", "_node_1");  
                    logger.info("removed unassigned node {}", node.getId());
            // we don't have any unassigned tasks - add some  
    }  
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
    public void testRemovePersistentTaskDelegation() throws Exception {
        {  
                ? NO_NODE_FOUND
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
            assertThat(tasksInProgress.tasks().size(), equalTo(1));
    }
        PersistentTasksCustomMetadata tasksInProgress = newClusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
            if (testFailureNextTime.compareAndSet(true, false)) {
        String newTaskId = UUIDs.base64UUID();
     */  
            .addTask("_task_1", "test", null, new Assignment("_node_1", "_reason"))  
     * the created task ends up unassigned (no suitable node found).
        );
            assertThat(task.getId(), equalTo(taskId));  
            clusterState,  
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());  
            boolean significant = randomBoolean();  
    public void testPersistentTasksAssigned() {  
            clusterState,  
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        AtomicBoolean completed1 = new AtomicBoolean(false);  
            .clusterManagerNodeId("_node_1");  
            ClusterState after = task.execute(before);
            .updateState(taskToUpdate, builtTasks.getTask(taskToUpdate).getAllocationId(), newState);
    }  
        // Test completion without failure
                    break;
        }, e -> fail("unassignPersistentTask should not fail: " + e.getMessage())));
 * not use this file except in compliance with the License.
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        assertThat(result.executionResults.get(entry).getFailure(), instanceOf(ResourceAlreadyExistsException.class));
    public void testReassignmentRequiredOnMetadataChanges() {
        assertThat(updatedTasks.getTask(newTaskId).getAssignment().getExecutorNode(), equalTo("_node_1"));
            if (changed) {  
        addTestNodes(nodes, randomIntBetween(1, 3));
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()  
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
    private ClusterState insignificantChange(ClusterState clusterState) {
        setState(clusterService, clusterState);
    }
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();  
                            ? "explanation: assign_based_on_non_cluster_state_condition"  
            tasks.getLastAllocationId(),  
    public void testPeriodicRecheckOffClusterManager() {
            .build();
        assertThat("number of tasks shouldn't change as a result or reassignment", numberOfTasks, equalTo(tasksInProgress.tasks().size()));
    }
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
        assertThat(result.executionResults.get(entry).isSuccess(), is(false));
    }
                    Metadata.builder(clusterState.metadata()),  
        clusterService.close();
     * is correctly set to 300 (increased from the original 50).
                    addTask(tasks, "assign_one", randomBoolean() ? null : "no_longer_exists");
        // This should NOT throw NPE
    }  
        for (int i = 0; i < numberOfTasks; i++) {
        );
 * license agreements. See the NOTICE file distributed with
            .add(new DiscoveryNode("_node", buildNewFakeTransportAddress(), Version.CURRENT))
            .localNodeId("_node_1")
                assertThat(task.isAssigned(), equalTo(false));
            .localNodeId("_node_1")
            .clusterManagerNodeId("_node_1")
 * The OpenSearch Contributors require contributions made to  
            .nodes(nodes)  
    public void testReassignmentRequired() {
        );  
import org.opensearch.cluster.metadata.IndexMetadata;  
        }
        );  
        PersistentTasksClusterService.PersistentTaskUpdateEntry failEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry.remove(
                    PersistentTasksCustomMetadata.builder(tasks),
            + " nodes_removed:"
            "missing-task",
    }  
        event = new ClusterChangedEvent("test", nonMasterClusterState, clusterState);  
import static org.mockito.Mockito.when;
    }
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)  
        assertThat(updatedTasks.getTask(existingTask), is(nullValue()));
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        }
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));  
        );  
        ClusterState initialState = initialState();
        PersistentTasksCustomMetadata builtTasks = tasks.build();  
        );  
            clusterState,
    public void testCreateDuplicateTask() {  
            assertThat(task, is(notNullValue()));  
 * the Apache License, Version 2.0 (the "License"); you may
        );  
            } else {
            .localNodeId("_node_1")
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        assertTrue("persistent tasks changed (task added)", persistentTasksChanged(new ClusterChangedEvent("test", current, previous)));  
        }
        }
    }
            taskIds.add(addTask(tasks, "assign_me", "_node_1"));
    private ClusterState.Builder addRandomTask(  
    private String addTask(PersistentTasksCustomMetadata.Builder tasks, String param, String node) {  
        );
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
            .clusterManagerNodeId("_node_1");  
import java.util.Set;
        DiscoveryNodes nodes = DiscoveryNodes.builder()
        return recheckTestClusterService;
        assertThat(result.executionResults.get(entry).getFailure(), instanceOf(ResourceNotFoundException.class));  
        }
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);  
        service.createPersistentTask(  
    }
                    break;  
    }  
            taskId,
            }
        ClusterState clusterState = initialState();
            .add(new DiscoveryNode("_node_2", buildNewFakeTransportAddress(), Version.CURRENT));  
            }
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(
        assertThat(result.executionResults.get(entry).isSuccess(), is(true));
                        equalTo(true)  
                    return NO_NODE_FOUND;  
                                .put(EnableAssignmentDecider.CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING.getKey(), allocation.toString())
        PersistentTasksClusterService.PersistentTaskUpdateEntry entry = PersistentTasksClusterService.PersistentTaskUpdateEntry.create(
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);  
            }
        service.createPersistentTask(taskId, TestPersistentTasksExecutor.NAME, new TestParams("assign_me"), ActionListener.wrap(task -> {  
    }
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()  
    @BeforeClass
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(  
            return randomNodeAssignment(clusterState.nodes());
            .localNodeId("_node")  
import org.opensearch.cluster.ClusterName;
                    return fn.apply(params, clusterState);
        nodes.clusterManagerNodeId("this_node");  
        for (int i = 0; i < numberOfIterations; i++) {
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(  
    private ClusterState reassign(PersistentTasksClusterService service, ClusterState clusterState) {  
        final BiFunction<P, ClusterState, Assignment> fn
        ClusterState nonMasterClusterState = builder.nodes(nodes).build();
        }, e -> fail()));
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
            initialState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));  
        } else {  
                public Assignment getAssignment(P params, ClusterState clusterState) {  
            assertThat(task.getExecutorNode(), nullValue());
        tasksInProgress = finalClusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
            clusterState,
 * this file be licensed under the Apache-2.0 license or a
                logger.info("set task custom to null");
            } else {
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))  
        PersistentTasksClusterService.PersistentTaskUpdateEntry entry = PersistentTasksClusterService.PersistentTaskUpdateEntry.complete(  
        DiscoveryNodes nodes = clusterState.nodes();
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
                .getMetadata()
        );
            assertThat(dumpEvent(event), service.shouldReassignPersistentTasks(event), equalTo(significant));  
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()  
            .clusterManagerNodeId("_node_1");
            .metadata(Metadata.builder().putCustom(PersistentTasksCustomMetadata.TYPE, currentTasks))  
    }  
            switch (testParams.getTestParam()) {
import static org.hamcrest.Matchers.equalTo;
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(  
            .localNodeId("_node_1")
        return clusterStateBuilder.metadata(
import org.opensearch.core.action.ActionListener;
            (params, currentState) -> assignBasedOnNonClusterStateCondition(currentState.nodes())
            for (DiscoveryNode node : clusterState.nodes()) {  
        );  
            assertThat(task.getAssignment().getExecutorNode(), is(nullValue()));
            .nodes(nodes)
        tasks = removeTasksWithChangingAssignment(tasks);
            completed.set(true);  
    private Assignment randomNodeAssignment(DiscoveryNodes nodes) {
        assertThat(result.executionResults.get(createEntry).isSuccess(), is(true));
        String taskId = addTask(tasks, "assign_me", "_node_1");
        assertThat(updatedTasks.getTask(newTaskId).getTaskName(), equalTo(TestPersistentTasksExecutor.NAME));
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
    private <P extends PersistentTaskParams> PersistentTasksClusterService createService(final BiFunction<P, ClusterState, Assignment> fn) {
                default:  
        assertThat(updateTaskState, is(notNullValue()));  
                assertThat(task, is(notNullValue()));
            .addTask("_task_3", "test", null, new Assignment("_node_2", "_reason"))  
        if (tasks != null) {
        }  
        }
                case "dont_assign_me":
            clusterState,
        } else {  
                    break;
        // The service should have cancelled the rechecker on learning it is no longer running on the cluster-manager node  
 * Licensed to Elasticsearch under one or more contributor  
        );  
            successes.add(success);
        );
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
            for (PersistentTask<?> task : tasks.tasks()) {
            PersistentTasksCustomMetadata tasksInProgress = newClusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
                    if (task.isAssigned() && clusterState.nodes().nodeExists(task.getExecutorNode())) {
        addTask(tasks, "assign_based_on_non_cluster_state_condition", null);  
        ClusterChangedEvent event = new ClusterChangedEvent("test", clusterState, initialState);
                        )  
        AtomicBoolean completed = new AtomicBoolean(false);
    /**  
     * tries to COMPLETE the same task with a wrong allocation ID, the COMPLETE
    private ClusterState initialState() {
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
            1L  
        return "nodes_changed: "  
                        assertThat(task, is(notNullValue()));
        assertBusy(() -> assertThat(completed.get(), is(true)));
                }
        );
     */  
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        String taskToRemove = addTask(tasks, "assign_me", "_node_1");
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
        assertThat(createdTask.get(), is(notNullValue()));  
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_2", "test"));
                    logger.info("added random unassignable task");  
        PersistentTasksCustomMetadata tasksInProgress = newClusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);  
            assertTrue("update " + i + " should have succeeded", successes.get(i).get());
        );  
    private static ThreadPool threadPool;
        ClusterState newClusterState = reassign(createService(), clusterState);  
    public void testCreateNewTask() {
            }
    public void tearDown() throws Exception {  
        PersistentTasksClusterService.PersistentTaskUpdateEntry entry = PersistentTasksClusterService.PersistentTaskUpdateEntry.complete(
        PersistentTasksClusterService service = createService(  
    }
    }
    }
                clusterState = insignificantChange(clusterState);  
            TestPersistentTasksExecutor.NAME,
        nodes.add(DiscoveryNode.createLocal(Settings.EMPTY, buildNewFakeTransportAddress(), "a_new_cluster_manager_node"));  
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        );  
        service.completePersistentTask(
            .build();
                changeRoutingTable(metadata, routingTable);
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());  
            .localNodeId("_node_1")  
            .clusterManagerNodeId("_node_1");
import org.opensearch.test.OpenSearchTestCase;
        String newTaskId = UUIDs.base64UUID();  
                completed.set(true);
        String taskId2 = addTask(tasks, "assign_me", "_node_1");  
            + " routing_table_changed:"
}  
            }
            .build();
                    }, e -> {  
            taskId2,
            }
        );
            taskId,
import org.opensearch.persistent.PersistentTasksCustomMetadata.Assignment;  
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(
        String taskToComplete = addTask(tasks, "assign_me", "_node_1");  
        threadPool = new TestThreadPool(PersistentTasksClusterServiceTests.class.getSimpleName());  
    private ClusterState significantChange(ClusterState clusterState) {
                @Override
            + event.nodesRemoved()  
            Metadata.Builder metadata = Metadata.builder(clusterState.metadata());  
            return NO_NODE_FOUND;
                assertThat(task.getExecutorNode(), nullValue());
            .build();  
    private void changeRoutingTable(Metadata.Builder metadata, RoutingTable.Builder routingTable) {
        assertThat(result.executionResults.get(entry).isSuccess(), is(false));
            TestPersistentTasksExecutor.NAME,
                for (PersistentTask<?> task : tasks.tasks()) {  
            .localNodeId("_node_1")
        assertThat(updatedTasks.getTask(taskToUnassign), is(notNullValue()));
        }, e -> fail("createPersistentTask should not fail: " + e.getMessage())));  
            Arrays.asList(removeEntry, completeEntry)
                    // add a task assigned to non-existing node that should not get assigned
import org.opensearch.cluster.node.DiscoveryNodes;
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
import org.opensearch.cluster.service.ClusterManagerTask;  
            tasks.getLastAllocationId(),
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)  
        ClusterState clusterState = initialState();
        builder = ClusterState.builder(clusterState);
        ClusterState.Builder builder = ClusterState.builder(initialState);  
        for (int i = 0; i < concurrentUpdates; i++) {
                case 1:  
        String unassignedId = addTask(tasks, "unassign", "_node_2");
            .build();
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
        tasks.addTask(id, TestPersistentTasksExecutor.NAME, new TestParams(param), new Assignment(node, "explanation: " + param));
            builder.metadata(metadata).routingTable(routingTable.build());  
 * GitHub history for details.
        PersistentTasksExecutorRegistry registry = new PersistentTasksExecutorRegistry(  
            .localNodeId("_node_1")  
            .localNodeId("_node_1")  
        return new PersistentTasksClusterService(Settings.EMPTY, registry, clusterService, threadPool);
    public static void setUpThreadPool() {
            if (hasAssignableTasks(tasks, clusterState.nodes()) == false) {
                return builder.metadata(metadata).build();  
        int randomIndices = randomIntBetween(0, 5);
                    }
            .clusterManagerNodeId("_node_1");
        );
    public void testUnassignWithWrongAllocationId() {
            completed.set(true);  
            thread.start();
        assertBusy(() -> assertThat(completed.get(), is(true)));  
                        assertThat(task.getAssignment().getExplanation(), equalTo("only one task can be assigned at a time"));  
                    )
                    assertThat(task.isAssigned(), equalTo(false));  
                clusterState = significantChange(clusterState);
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
import org.opensearch.persistent.decider.EnableAssignmentDecider;
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();  
                        .build()
            .complete(taskToComplete, builtTasks.getTask(taskToComplete).getAllocationId());
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(  
    public void testUpdateTaskStateThrottlingThreshold() {
            .settings(Settings.builder().put("index.version.created", VersionUtils.randomVersion(random())))
import org.opensearch.test.VersionUtils;  
        );
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)  
            1L,
        ClusterState.Builder builder = ClusterState.builder(clusterState);
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        assertThat(tasksInProgress.tasks().size(), equalTo(1));  
    ) {  
        for (int i = 0; i < randomIndices; i++) {
            changeRoutingTable(metadata, routingTable);  
        assertThat(result.executionResults.get(removeEntry).isSuccess(), is(true));  
                    allCompleted.countDown();
        // All concurrent updates should complete successfully
        AtomicBoolean completed = new AtomicBoolean(false);  
                return "never_assign".equals(((TestParams) task.getParams()).getTestParam()) == false;
            assertThat(task.getId(), equalTo(taskId1));  
            final long allocationId = builtTasks.getTask(taskId).getAllocationId();  
        clusterState = builder.metadata(metadata).nodes(nodes).build();  
    }  
        List<String> nodeList = new ArrayList<>();
            .clusterManagerNodeId("_node_1");
import static org.opensearch.persistent.PersistentTasksExecutor.NO_NODE_FOUND;
            ClusterChangedEvent event = new ClusterChangedEvent("test", clusterState, previousState);
        PersistentTasksClusterService.PersistentTaskUpdateEntry completeEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));  
            switch (randomInt(2)) {
        PersistentTasksCustomMetadata.Builder tasks,  
                case "assign_me":  
            .build();  
                case "assign_one":  
            assertThat(task.getExecutorNode(), notNullValue());
            }, e -> fail())
        ClusterService recheckTestClusterService = mock(ClusterService.class);
import java.util.Collections;
     */  
                    .build()
        return tasks;
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
    public void testUnassignNonExistentTask() {
        ClusterState clusterState = initialState();
        assertBusy(() -> assertThat(completed.get(), is(true)));
                    tasksBuilder.removeTask(task.getId());
            assertThat(task.getId(), equalTo(taskId));
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        PersistentTasksClusterService.PersistentTaskUpdateEntry successEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry  
                if (task.getExecutorNode() == null || "never_assign".equals(((TestParams) task.getParams()).getTestParam())) {  
 *  
            } else {
     */  
            Collections.singletonList(entry)
        assertThat(result.executionResults.get(unassignEntry).isSuccess(), is(true));
        Metadata.Builder metadata = Metadata.builder(initialState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
    }  
            return null;
        ClusterState.Builder builder = ClusterState.builder(clusterState);  
                    barrier.await(10, TimeUnit.SECONDS);
    }  
        setState(clusterService, clusterState);
                    break;  
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)  
            new TestParams("assign_me")
        String taskId = addTask(tasks, "assign_me", "_node_2");
            return false;
                assertThat(task.getAssignment().getExplanation(), equalTo("non-cluster state condition prevents assignment"));  
        super.setUp();
     * This covers the cross-entry interaction in the COMPLETE warning log where
            .put(indexMetadata, false)  
                        .persistentSettings(
        IndexMetadata indexMetadata = IndexMetadata.builder(randomAlphaOfLength(10))  
        );  
            new RuntimeException("test failure"),
        assertBusy(() -> assertThat(completed.get(), is(true)));
            .complete(taskId, 999999L);
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
                    if (task.isAssigned()) {
            .build();
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(  
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
            task -> "assign_one".equals(((TestParams) task.getParams()).getTestParam()) && nodes.nodeExists(task.getExecutorNode())  
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();  
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
            Collections.singletonList(entry)
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
        assertThat(createdTask.get().getTaskName(), equalTo(TestPersistentTasksExecutor.NAME));
                    task.getAssignment().getExplanation(),  
        String taskToUpdate = addTask(tasks, "assign_me", "_node_1");
     * Tests that the UPDATE_TASK_STATE throttling threshold in ClusterManagerTask
    public void testReassignTasks() {  
    private PersistentTasksClusterService createService() {
            PersistentTasksCustomMetadata.Builder tasksBuilder = PersistentTasksCustomMetadata.builder(tasks);
        service.clusterChanged(event);
        );
        ClusterService recheckTestClusterService = createRecheckTestClusterService(clusterState, false);
        );
                assertThat(task.getExecutorNode(), notNullValue());
        CountDownLatch allCompleted = new CountDownLatch(concurrentUpdates);
            recheckTestClusterService,  
                return builder.metadata(metadata).build();
                PersistentTasksCustomMetadata.TYPE,  
                task.clusterStateProcessed("test", before, after);  
        );  
                @Override
                try {
            // clear the task  
                if (hasTasksAssignedTo(tasks, node.getId()) == false && "this_node".equals(node.getId()) == false) {
    /**  
        routingTable.addAsNew(indexMetadata);  
    }  
                    }));  
                tasksOrNodesChanged = true;
import static java.util.Collections.emptyMap;  
        String node
        });
        PersistentTasksClusterService service = createService(
 * this work for additional information regarding copyright
        if (nonClusterStateCondition) {  
            .numberOfReplicas(1)  
            @SuppressWarnings("unchecked")
import static org.hamcrest.Matchers.nullValue;
/*
        PersistentTasksClusterService.PersistentTaskUpdateEntry entry = PersistentTasksClusterService.PersistentTaskUpdateEntry.create(
    }
                logger.info("added random task");
                RoutingTable.Builder routingTable = RoutingTable.builder(clusterState.routingTable());
            PersistentTasksCustomMetadata tasksInProgress = recheckTestClusterService.state()  
                }  
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
            .addTask("_task_2", "test", null, new Assignment("_node_1", "_reason"))
            Arrays.asList(failEntry, successEntry)
                );  
        assertThat(result.executionResults.get(failEntry).getFailure(), instanceOf(ResourceNotFoundException.class));  
        String taskId = UUIDs.base64UUID();
        // UPDATE_STATE: task should have updated state
        service.completePersistentTask(taskId1, tasks.getLastAllocationId() - 1, null, ActionListener.wrap(task -> {
            .clusterManagerNodeId("_node_1");
            // change routing table to simulate a change
    }
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        );
            PersistentTasksCustomMetadata tasksInProgress = newClusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);  
        doAnswer(invocationOnMock -> {  
            tasksOrNodesChanged = true;  
            .metadata(Metadata.builder().putCustom(PersistentTasksCustomMetadata.TYPE, previousTasks))
        assertThat(updatedTasks.getTask(newTaskId), is(notNullValue()));  
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
        ClusterState clusterState = initialState();
        );  
            .build();  
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
                logger.info("added unassignable task with custom assignment message");  
            .add(new DiscoveryNode("_node_2", buildNewFakeTransportAddress(), Version.CURRENT));
                }
        PersistentTaskState newState = new TestPersistentTasksPlugin.State("updated_phase");
        assertTrue(needsReassignment(new Assignment(null, "unassigned"), nodes));
    }
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
import org.opensearch.common.unit.TimeValue;
            .addTask("_task_1", "test", null, new Assignment("_node_1", ""))
        assertTrue(service.getPeriodicRechecker().isScheduled());
                    logger.info("removed task with changing assignment {}", task.getId());
        String taskId = addTask(tasks, "assign_me", "_node_1");
            return new Assignment(null, "only one task can be assigned at a time");
        final ClusterChangedEvent event = new ClusterChangedEvent("test", current, previous);
        assertThat(result.executionResults.get(updateEntry).isSuccess(), is(true));
            }
    }
        ClusterState.Builder builder = ClusterState.builder(clusterState);  
            assertThat(task.getAssignment().getExplanation(), equalTo("unassignment test"));
            .addTask("_task_1", "test", null, new Assignment(null, "_reason"))
        return tasks != null && tasks.tasks().stream().anyMatch(task -> nodeId.equals(task.getExecutorNode())) == false;  
        ClusterState current = ClusterState.builder(new ClusterName("_name"))
                case "assign_me":  
                        clusterState.nodes().nodeExists(task.getExecutorNode()),
        PersistentTasksCustomMetadata updatedTasks = result.resultingState.metadata().custom(PersistentTasksCustomMetadata.TYPE);  
            .putCustom(PersistentTasksCustomMetadata.TYPE, tasksBuilder.build());
                    return randomNodeAssignment(currentState.nodes());
                        return builder.build();
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
                completed2.set(true);
            .build();
        ClusterState previous = ClusterState.builder(new ClusterName("_name")).nodes(nodes).build();
import static org.opensearch.test.ClusterServiceUtils.setState;  
        Metadata.Builder metadata = Metadata.builder(initialState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        ClusterState.Builder builder = ClusterState.builder(clusterState);
import java.util.HashSet;
 * under the License.  
     */  
        );
                    assertThat(task.getExecutorNode(), notNullValue());
        assertFalse(service.getPeriodicRechecker().isScheduled());
    }  
        if (tasks != null) {
import org.opensearch.threadpool.TestThreadPool;
            newTaskId,  
        String node = randomFrom(nodeList);  
        PersistentTasksCustomMetadata currentTasks = PersistentTasksCustomMetadata.builder()
                }  
        ClusterState previous = ClusterState.builder(new ClusterName("_name")).nodes(nodes).build();
        PersistentTaskState newState = new TestPersistentTasksPlugin.State("updated");
        ClusterState clusterState = initialState();
        boolean unassigned = randomBoolean();
                        logger.info("removed node {}", task.getExecutorNode());
    private <P extends PersistentTaskParams> PersistentTasksClusterService createService(
        PersistentTasksCustomMetadata previousTasks = PersistentTasksCustomMetadata.builder()  
            ActionListener.wrap(task -> {
            return NO_NODE_FOUND;
        return builder.build();
            assertThat(task, is(notNullValue()));
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(
        assertTrue("persistent tasks changed (task removed)", persistentTasksChanged(new ClusterChangedEvent("test", current, previous)));  
                    addTask(tasks, "assign_me", randomBoolean() ? null : "no_longer_exists");
import org.opensearch.cluster.service.ClusterService;
                .custom(PersistentTasksCustomMetadata.TYPE);
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        ClusterState newClusterState = reassign(service, clusterState);  
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        nonClusterStateCondition = false;
        PersistentTasksClusterService.PersistentTaskUpdateEntry entry = PersistentTasksClusterService.PersistentTaskUpdateEntry.unassign(  
                }
        // Verify toString
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(  
            .clusterManagerNodeId("_node_1");
                if (randomBoolean()) {
        PersistentTasksCustomMetadata tasks = clusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);  
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
    public void testReassignConsidersClusterStateUpdates() {
            }
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        assertThat(updatedTasks.getTask(newTaskId).getTaskName(), equalTo(TestPersistentTasksExecutor.NAME));
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))  
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
import org.opensearch.cluster.ClusterState;  
 */
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(  
        doAnswer(invocationOnMock -> state.get()).when(recheckTestClusterService).state();
    public void testPersistentTasksChangedNoTasks() {  
        }
            .remove(taskToRemove);  
    private boolean hasAssignableTasks(PersistentTasksCustomMetadata tasks, DiscoveryNodes discoveryNodes) {
            .addTask("_task_2", "test", null, new Assignment(null, "unassigned"))
        Assignment assignment,
                }
        Metadata.Builder metadata,
        ).isEmpty()) {
        assertThat(result.executionResults.get(failEntry).isSuccess(), is(false));
        String taskId = addTask(tasks, "assign_me", "_node_1");  
            }  
        ClusterState current = ClusterState.builder(new ClusterName("_name"))
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());  
            }
        service.setRecheckInterval(TimeValue.timeValueMillis(1));  
            taskId,
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
            Collections.singletonList(entry)
     * entry fails gracefully without NPE in the warning log path.  
                    fail("the decision decider shouldn't be called on this task");
        if (clusterState.nodes().getNodes().isEmpty()) {  
    ) {
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
        return ClusterState.builder(ClusterName.DEFAULT).nodes(nodes).metadata(metadata).routingTable(routingTable.build()).build();
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))  
        setState(clusterService, clusterState);
     * Tests that concurrent submissions to the same PersistentTaskUpdateExecutor  
            if (randomBoolean()) {
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
                    );
        return addRandomTask(clusterStateBuilder, metadata, tasks, new Assignment(node, randomAlphaOfLength(10)), randomAlphaOfLength(10));  
        }
        );  
                assertThat(task.isAssigned(), is(false));  
        PersistentTasksClusterService service = createService();
    private void addTestNodes(DiscoveryNodes.Builder nodes, int nonLocalNodesCount) {
            assertThat(tasksInProgress.tasks().size(), equalTo(1));  
                assertThat(task.isAssigned(), equalTo(false));
        ClusterState clusterState = builder.metadata(metadata).nodes(nodes).build();
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        boolean tasksOrNodesChanged = false;  
        ClusterService clusterService,  
    }
        // Second entry: remove an existing task (should succeed despite first failure)
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
    public void testNonClusterStateConditionAssignment() {
        assertThat(result.executionResults.get(successEntry).isSuccess(), is(true));
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        int numberOfTasks = randomIntBetween(2, 40);  
        AtomicBoolean completed = new AtomicBoolean(false);
import java.util.List;  
            .addTask("_task_1", "test", null, new Assignment("_node_1", "_reason"))
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
    }
        );
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(  
    private ClusterService clusterService;  
    /** Needed by {@link ClusterService} **/  
            .localNodeId("_node_1")  
        assertThat(reassign(createService(), clusterState).metadata().custom(PersistentTasksCustomMetadata.TYPE), nullValue());
            logger.info("changed routing table");
                    assertThat(  
        assertThat(result.executionResults.get(entry).isSuccess(), is(false));
        assertThat(updateTaskState.getKey(), equalTo("update-task-state"));
        PersistentTasksClusterService service = createService((params, currentState) -> NO_NODE_FOUND);
        }  
    }  
                if (randomBoolean()) {
        // After the REMOVE, the task no longer exists, so this should hit the
            assertThat(tasksInProgress, notNullValue());  
        }
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
    private volatile boolean nonClusterStateCondition;
        }  
            Thread thread = new Thread(() -> {  
            }
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
    public void testConcurrentSubmissionsAreBatched() throws Exception {
import org.opensearch.persistent.TestPersistentTasksPlugin.TestParams;
                // Remove all unassigned tasks that cause changing assignments they might trigger a significant change
        nonClusterStateCondition = false;  
    /** Needed by {@link PersistentTasksClusterService} **/
import static org.mockito.Mockito.doAnswer;  
        assertTrue(needsReassignment(new Assignment("_node_left", "assigned to a node that left"), nodes));  
            recheckTestClusterService,
        PersistentTasksClusterService.PersistentTaskUpdateEntry removeEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry
        assertThat(tasksInProgress, notNullValue());  
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        );
    public void testUpdateStateWithNonExistingTask() {  
        terminate(threadPool);
    @AfterClass  
            .clusterManagerNodeId("_node_1");
            .nodes(nodes)
            new TestPersistentTasksPlugin.State("test")
            )  
            .build();  
            Collections.singletonList(entry)
            "unassignment test",  
        DiscoveryNodes nodes = DiscoveryNodes.builder()  
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
            taskId,
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata())
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
                    fail("Unknown action " + task.getTaskName());
            // explanation should correspond to the action name
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(  
        boolean shouldSimulateFailure = randomBoolean();  
            ClusterState before = state.get();  
        List<AtomicBoolean> successes = new ArrayList<>();  
        ClusterState current = ClusterState.builder(new ClusterName("_name")).nodes(nodes).build();  
            });
        ClusterState clusterState = initialState();  
        logger.info("removed all unassigned tasks and changed routing table");  
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        // First entry: remove a non-existent task (should fail)
                        builder.nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(task.getExecutorNode()));  
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_2", "test"));  
                assertThat(
        ClusterState clusterState = initialState();
    }
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)  
        String taskId1 = addTask(tasks, "assign_me", "_node_1");
        );  
        ClusterState previous = ClusterState.builder(new ClusterName("_name"))
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
    }  
            .localNodeId("_node_1")  
    public void testCompleteWithWrongAllocationId() {
        );  
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        if (randomBoolean()) {
import org.junit.Before;
    public void testBatchedPartialFailure() {  
        {
    }  
        ClusterState clusterState = initialState();
        }  
        setState(clusterService, clusterState);
        ClusterState newClusterState = recheckTestClusterService.state();  
                    return builder.nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(node.getId())).build();  
        if (tasks != null) {  
            .build();
     * Tests that when a prior batch entry REMOVEs a task and a subsequent entry
            TestPersistentTasksExecutor.NAME,
        if (tasksOrNodesChanged == false) {  
        CyclicBarrier barrier = new CyclicBarrier(concurrentUpdates);
        return createService((params, currentState) -> {  
        return createService(clusterService, fn);
        service.clusterChanged(event);
        }  
        service.updatePersistentTaskState(taskId, tasks.getLastAllocationId(), newState, ActionListener.wrap(task -> {
            builder.nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode(randomAlphaOfLength(10))));
import org.opensearch.cluster.routing.RoutingTable;
            .addTask("_task_1", TestPersistentTasksExecutor.NAME, null, new Assignment(unassigned ? null : "_node", "_reason"))  
            })
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
            .localNodeId("_node_1")
        );  
            "non-existent-task"  
    }
    /**  
    public void testNeedsReassignment() {
        // REMOVE: task should be gone
        assertThat(unassignEntry.toString(), equalTo("UNASSIGN[" + taskToUnassign + "]"));
            for (PersistentTask<?> task : tasksInProgress.tasks()) {  
                        allCompleted.countDown();
        ClusterState newClusterState = reassign(createService(), clusterState);
     */  
            clusterState,  
            }, e -> fail("createPersistentTask should not fail: " + e.getMessage()))
            .build();
            .clusterManagerNodeId("_node_1")
    public void testPeriodicRecheck() throws Exception {
            metadata.putCustom(
        if (changed) {
            }
            .localNodeId("_node_1")
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());  
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()  
            + event.state().metadata().custom(PersistentTasksCustomMetadata.TYPE);
        assertThat(createdTask.get().getAssignment().getExecutorNode(), equalTo("_node_1"));  
                    }
                    "never_assign"  
 * ownership. Elasticsearch licenses this file to you under  
     * This validates the core value proposition of the batching change.
        assertThat(result.executionResults.get(entry).getFailure(), instanceOf(ResourceNotFoundException.class));  
                        logger.info(clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE).toString());
                        assertThat(task.getState(), equalTo(newState));  
                tasksOrNodesChanged = true;
            clusterState,  
            .add(new DiscoveryNode("_node_2", buildNewFakeTransportAddress(), Version.CURRENT))  
    public void testUnassignPersistentTaskDelegation() throws Exception {
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        ClusterState newClusterState = recheckTestClusterService.state();
            .numberOfReplicas(1)  
        nonClusterStateCondition = true;
                return builder.build();
                    } else {
            clusterState,
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);  
            ActionListener.wrap(task -> {
        // COMPLETE: task should be gone
            .persistentSettings(
    public void testCompletePersistentTaskDelegation() throws Exception {  
        ClusterState clusterState = initialState();
    private boolean hasTasksAssignedTo(PersistentTasksCustomMetadata tasks, String nodeId) {
            return false;
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());  
        ClusterState.Builder clusterStateBuilder,
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_2", "test"));
    public void testBatchedMixedOperations() {
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));  
        assertThat(tasksInProgress, notNullValue());
        // CREATE: new task should exist and be assigned
            .clusterManagerNodeId("_node_1");
                state.set(after);
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
import org.opensearch.common.settings.Settings;  
        ClusterState.Builder builder = ClusterState.builder(clusterState);
        service.unassignPersistentTask(  
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
            .localNodeId("_node_1")  
        String existingTaskId = addTask(tasks, "assign_me", "_node_1");
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
 * You may obtain a copy of the License at  
        PersistentTasksCustomMetadata tasksInProgress = newClusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
    }
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
        String existingTask = addTask(tasks, "assign_me", "_node_1");
        service.removePersistentTask(taskId, ActionListener.wrap(task -> {  
        PersistentTasksClusterService.PersistentTaskUpdateEntry unassignEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry  
        assertThat(result.executionResults.get(completeEntry).getFailure(), instanceOf(ResourceNotFoundException.class));  
import org.opensearch.threadpool.ThreadPool;
        AtomicBoolean completed = new AtomicBoolean(false);  
                    tasksBuilder.removeTask(task.getId());
                    assertThat(task.getAssignment().getExplanation(), equalTo("test assignment"));
        clusterService = createClusterService(threadPool);  
        // Test completion with failure (covers the failure logging branch)
                return tasksBuilder.build();
    }
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
            .localNodeId("_node_1")
        }
        AtomicBoolean testFailureNextTime = new AtomicBoolean(shouldSimulateFailure);  
import java.util.concurrent.atomic.AtomicBoolean;
            .clusterManagerNodeId("_node_1");  
                        "task should be assigned to a node that is in the cluster, was assigned to " + task.getExecutorNode(),
import org.junit.AfterClass;
        assertThat(updatedTasks.getTask(taskToComplete), is(nullValue()));
                case "assign_based_on_non_cluster_state_condition":  
                        assertThat(task.getAssignment().getExplanation(), equalTo("test assignment"));
            clusterState,
            for (PersistentTask<?> task : tasks.tasks()) {  
        setState(clusterService, clusterState);
import static org.hamcrest.Matchers.instanceOf;
        RoutingTable.Builder routingTable = RoutingTable.builder();  
        super.tearDown();
                    .putCustom(PersistentTasksCustomMetadata.TYPE, PersistentTasksCustomMetadata.builder().build());
            createdTask.set(task);
        );  
                    return assignOnlyOneTaskAtATime(currentState);
    }
                : randomNodeAssignment(clusterState.nodes())  
    private Assignment assignOnlyOneTaskAtATime(ClusterState clusterState) {
        );  
        assertFalse(needsReassignment(new Assignment("_node_1", "assigned"), nodes));
        AtomicReference<PersistentTask<?>> createdTask = new AtomicReference<>();
            allocation = randomValueOtherThan(allocation, () -> randomFrom(EnableAssignmentDecider.Allocation.values()));  
        }  
import org.junit.BeforeClass;  
    }  
    }  
 */  
            .build();
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();  
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
            }
            assertThat(tasksInProgress, notNullValue());
        ClusterChangedEvent event = new ClusterChangedEvent("test", clusterState, initialState);
        ClusterManagerTask updateTaskState = ClusterManagerTask.fromKey("update-task-state");
            .add(new DiscoveryNode("_node_2", buildNewFakeTransportAddress(), Version.CURRENT));
import java.util.ArrayList;
            999999L,
                assertThat(task.getAssignment().getExplanation(), equalTo("test assignment"));
                    builder.nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode(randomAlphaOfLength(10))));  
        );  
        Metadata metadata = Metadata.builder()  
            if (significant) {  
        }).when(recheckTestClusterService).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));  
            .localNodeId("_node_1")
        // The periodic rechecker should have been triggered because the task is unassigned  
    }
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
        assertThat(result.executionResults.get(completeEntry).isSuccess(), is(false));
        );  
        }  
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)  
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(initialState.nodes());
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
        for (int i = 0; i < nonLocalNodesCount; i++) {  
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
 *
            logger.info("added random node");
        return builder.metadata(metadata).build();
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
    }  
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder();  
            .build();
import org.opensearch.ResourceAlreadyExistsException;
            assertThat(task, is(notNullValue()));
        ClusterState clusterState = initialState();  
        when(recheckTestClusterService.getClusterSettings()).thenReturn(clusterService.getClusterSettings());  
        );  
        PersistentTasksCustomMetadata.Builder tasksBuilder = PersistentTasksCustomMetadata.builder(tasks);
            assertThat(task.getId(), equalTo(unassignedId));  
        String taskId = UUIDs.base64UUID();  
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
                case "fail_me_if_called":
import java.util.concurrent.CyclicBarrier;  
            assertThat(task.isAssigned(), equalTo(false));  
            .metadata(Metadata.builder().putCustom(PersistentTasksCustomMetadata.TYPE, previousTasks))
            return new Assignment(node, "test assignment");
        }
import org.opensearch.persistent.TestPersistentTasksPlugin.TestPersistentTasksExecutor;  
import java.util.Arrays;  
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
        clusterState = builder.metadata(metadata).nodes(nodes).build();  
        PersistentTasksCustomMetadata currentTasks = PersistentTasksCustomMetadata.builder()
import org.opensearch.cluster.ClusterChangedEvent;
    private PersistentTasksCustomMetadata removeTasksWithChangingAssignment(PersistentTasksCustomMetadata tasks) {
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)  
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());  
    public void testPersistentTasksChangedTaskAdded() {
        nodes.localNodeId("this_node");
        }, e -> fail()));
        assertBusy(() -> assertThat(completed1.get(), is(true)));  
                    assertThat(task.isAssigned(), equalTo(true));
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))  
        ClusterState clusterState = initialState();  
            Collections.singletonList(entry)
        nodes.add(DiscoveryNode.createLocal(Settings.EMPTY, buildNewFakeTransportAddress(), "this_node"));
            .addTask("_task_2", "test", null, new Assignment("_node_2", ""))  
        assertThat(updatedTasks.getTask(taskToUnassign).getAssignment().getExecutorNode(), is(nullValue()));
    /** Creates a PersistentTasksClusterService with a single PersistentTasksExecutor implemented by a BiFunction **/  
            new TestParams("dont_assign_me"),  
import static org.mockito.Mockito.anyString;
    }
                }
        }  
        }
                        success.set(true);
        nonClusterStateCondition = false;
        assertThat(result.executionResults.get(entry).getFailure(), instanceOf(ResourceNotFoundException.class));
    }  
                    .put(EnableAssignmentDecider.CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING.getKey(), allocation.toString())
        if (randomBoolean()) {
                )
            addTask(tasks, "assign_one", randomBoolean() ? null : "no_longer_exists");
        ClusterState current;
            existingTaskId,  
                // we don't have any unassigned tasks - adding a node or changing a routing table shouldn't affect anything  
        }
                        assignOneCount++;
                }
        PersistentTasksCustomMetadata tasks = PersistentTasksCustomMetadata.builder()
        assertThat(updatedTasks.getTask(newTaskId), is(notNullValue()));  
        IndexMetadata indexMetadata = IndexMetadata.builder(randomAlphaOfLength(10))  
        ClusterState.Builder clusterStateBuilder,
            .nodes(nodes)
            }  
            (params, clusterState) -> "never_assign".equals(((TestParams) params).getTestParam())
        int numberOfTasks = randomIntBetween(0, 40);
        ClusterState clusterState = initialState();
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(  
    public void testUpdateStateWithWrongAllocationId() {
                    return null;  
    private ClusterService createRecheckTestClusterService(ClusterState initialState, boolean shouldSimulateFailure) {
        if (tasksInProgress.findTasks(
        // UNASSIGN: task should exist but be unassigned  
            current = ClusterState.builder(previous)
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
                    changed = true;  
    }
            + " tasks: "  
        assertThat(result.executionResults.get(entry).getFailure(), instanceOf(ResourceNotFoundException.class));  
    private Assignment assignBasedOnNonClusterStateCondition(DiscoveryNodes nodes) {
        );
                    break;  
                    builder,
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))  
            + event.nodesChanged()
        ClusterState.Builder builder = ClusterState.builder(initialState);  
        doAnswer(invocationOnMock -> state.get().getNodes().getLocalNode()).when(recheckTestClusterService).localNode();
    ) {
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());  
        );  
