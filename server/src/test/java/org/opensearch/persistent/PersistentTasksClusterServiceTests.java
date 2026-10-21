            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
    }
        nodes.clusterManagerNodeId("this_node");
    }
    /** Creates a PersistentTasksClusterService with a single PersistentTasksExecutor implemented by a BiFunction **/
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
 * the Apache License, Version 2.0 (the "License"); you may
            .unassign(taskToUnassign, builtTasks.getTask(taskToUnassign).getAllocationId(), "unassignment test");
            return new Assignment(null, "only one task can be assigned at a time");
            .add(new DiscoveryNode("_node", buildNewFakeTransportAddress(), Version.CURRENT))
            taskId2,
    }
    public void testPersistentTasksAssigned() {
        DiscoveryNodes nodes = DiscoveryNodes.builder()
        if (randomBoolean()) {
        doAnswer(invocationOnMock -> state.get().getNodes().getLocalNode()).when(recheckTestClusterService).localNode();
            clusterState,
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
     * This covers the cross-entry interaction in the COMPLETE warning log where
            clusterState,
            taskId,
                return builder.metadata(metadata).build();
        for (int i = 0; i < numberOfIterations; i++) {
import static org.opensearch.persistent.PersistentTasksClusterService.persistentTasksChanged;
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
    private volatile boolean nonClusterStateCondition;
        String taskToComplete = addTask(tasks, "assign_me", "_node_1");
        assertThat(updatedTasks.getTask(newTaskId), is(notNullValue()));
                Metadata.Builder metadata = Metadata.builder(clusterState.metadata());
        );
import org.opensearch.common.unit.TimeValue;
            .clusterManagerNodeId("_node_1");
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
        PersistentTasksClusterService service = createService(
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        super.setUp();
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
import static org.mockito.Mockito.anyString;
        assertThat(result.executionResults.get(entry).isSuccess(), is(false));
            .localNodeId("_node_1")
            .numberOfShards(1)
        if (tasksOrNodesChanged == false) {
        assertBusy(() -> assertThat(completed.get(), is(true)));
        ClusterState previous = ClusterState.builder(new ClusterName("_name"))
        ClusterState current = ClusterState.builder(new ClusterName("_name"))
                    throw new UnsupportedOperationException();
            .put(indexMetadata, false)
import static org.hamcrest.core.Is.is;
        setState(clusterService, clusterState);
        return service.reassignTasks(clusterState);
        } else {
        ClusterState.Builder clusterStateBuilder,
            .numberOfReplicas(1)
            }
        }
                        assertThat(task.getAssignment().getExplanation(), equalTo("only one task can be assigned at a time"));
     * entry fails gracefully without NPE in the warning log path.
            new TestParams("assign_me")
        PersistentTasksCustomMetadata tasks = PersistentTasksCustomMetadata.builder()
            Collections.singletonList(entry)
                @Override
    private Assignment assignBasedOnNonClusterStateCondition(DiscoveryNodes nodes) {
        nonClusterStateCondition = true;
            assertThat(task, is(notNullValue()));
                    logger.info("added random node");
        PersistentTasksClusterService.PersistentTaskUpdateEntry successEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry
    private PersistentTasksClusterService createService() {
            "unassignment test",
            new RuntimeException("test failure"),
        // REMOVE: task should be gone
            newTaskId,
    /**
import org.opensearch.Version;
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(
        if (tasksInProgress.findTasks(
            .nodes(nodes)
        );
            + " routing_table_changed:"
            // change routing table to simulate a change
            boolean changed = false;
        assertThat(result.executionResults.get(entry).getFailure(), instanceOf(ResourceNotFoundException.class));
        if (node != null) {
                builder.metadata(metadata).routingTable(routingTable.build());
        service.clusterChanged(event);
        String newTaskId = UUIDs.base64UUID();
        assertTrue(needsReassignment(new Assignment(null, "unassigned"), nodes));
        boolean unassigned = randomBoolean();
        for (int i = 0; i < randomIndices; i++) {
            Arrays.asList(removeEntry, completeEntry)
                        logger.info("removed node {}", task.getExecutorNode());
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
        PersistentTasksClusterService.PersistentTaskUpdateEntry entry = PersistentTasksClusterService.PersistentTaskUpdateEntry.complete(
        }
        );
 * this work for additional information regarding copyright
        assertThat(result.executionResults.get(successEntry).isSuccess(), is(true));
        // Verify toString
        int assignOneCount = 0;
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
                    addTask(tasks, "assign_one", randomBoolean() ? null : "no_longer_exists");
        AtomicBoolean completed = new AtomicBoolean(false);
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        nodes = DiscoveryNodes.builder(clusterState.nodes());
        if (tasks != null) {
        for (PersistentTask<?> task : tasksInProgress.tasks()) {
                        allCompleted.countDown();
                    addRandomTask(builder, Metadata.builder(clusterState.metadata()), tasksBuilder, NO_NODE_FOUND, "never_assign");
     * Tests that when a prior batch entry REMOVEs a task and a subsequent entry
import org.opensearch.test.VersionUtils;
        );
                case "fail_me_if_called":
        }
            .localNodeId("_node_1")
    public void testUnassignWithWrongAllocationId() {
        ClusterState clusterState = initialState();
                assertThat(task.getExecutorNode(), nullValue());
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
                ? NO_NODE_FOUND
                    }
        }
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
                        success.set(true);
            )
    }
        AtomicReference<ClusterState> state = new AtomicReference<>(initialState);
            assertThat(tasksInProgress, notNullValue());
import static org.hamcrest.Matchers.instanceOf;
        );
            recheckTestClusterService,
        );
        addTestNodes(nodes, randomIntBetween(1, 3));
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
            .localNodeId("_node_1")
    public void testUpdateStateWithNonExistingTask() {
        );
            .build();
            .remove(taskToRemove);
        setState(clusterService, clusterState);
import org.opensearch.persistent.PersistentTasksCustomMetadata.Assignment;
    /** Needed by {@link PersistentTasksClusterService} **/
     * getTaskWithId could return null.
        // Pre-create tasks that we'll update concurrently
    private Assignment assignOnlyOneTaskAtATime(ClusterState clusterState) {
            tasksOrNodesChanged = true;
    }
                addRandomTask(
    }
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
                .metadata(
        ClusterState clusterState = initialState();
                        assertThat(task.getState(), equalTo(newState));
import static org.mockito.Mockito.when;
                    assertThat(task.isAssigned(), equalTo(true));
            TestPersistentTasksExecutor.NAME,
        DiscoveryNodes nodes = DiscoveryNodes.builder()
    private DiscoveryNode newNode(String nodeId) {
        );
    /**
            .nodes(nodes)
     * tries to COMPLETE the same task with a wrong allocation ID, the COMPLETE
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        String taskToUpdate = addTask(tasks, "assign_me", "_node_1");
                assertThat(task.getExecutorNode(), notNullValue());
        assertThat(result.executionResults.get(entry).getFailure(), instanceOf(ResourceNotFoundException.class));
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
        }
            }
            return new Assignment(node, "test assignment");
                clusterState = significantChange(clusterState);
        );
            }
            }
            Metadata.Builder metadata = Metadata.builder(clusterState.metadata());
        nodes.add(DiscoveryNode.createLocal(Settings.EMPTY, buildNewFakeTransportAddress(), "a_new_cluster_manager_node"));
            assertThat(task.getAssignment().getExecutorNode(), is(nullValue()));
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        routingTable.addAsNew(indexMetadata);
        Metadata.Builder metadata = Metadata.builder(initialState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
            final long allocationId = builtTasks.getTask(taskId).getAllocationId();
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
            .clusterManagerNodeId("_node_1");
                    break;
        String taskToUnassign = addTask(tasks, "assign_me", "_node_1");
        for (int i = 0; i < numberOfTasks; i++) {
            clusterState,
        return ClusterState.builder(ClusterName.DEFAULT).nodes(nodes).metadata(metadata).routingTable(routingTable.build()).build();
            RoutingTable.Builder routingTable = RoutingTable.builder(clusterState.routingTable());
    public void testUnassignTask() {
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
    }
        for (int i = 0; i < concurrentUpdates; i++) {
    }
            for (PersistentTask<?> task : tasks.tasks()) {
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        // The service should have cancelled the rechecker on learning it is no longer running on the cluster-manager node
        assertFalse(service.getPeriodicRechecker().isScheduled());
        setState(clusterService, clusterState);
        ClusterService clusterService,
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        assertThat(result.executionResults.get(entry).getFailure(), instanceOf(ResourceNotFoundException.class));
            .complete(taskToComplete, builtTasks.getTask(taskToComplete).getAllocationId());
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        );
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
                case 2:
import org.opensearch.test.OpenSearchTestCase;
            assertThat(task.isAssigned(), equalTo(false));
        ClusterState clusterState = initialState();
        nodes.localNodeId("this_node");
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        return recheckTestClusterService;
    }
        String taskId = addTask(tasks, "assign_me", "_node_2");
        PersistentTasksCustomMetadata tasksInProgress = newClusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
                    tasksBuilder.removeTask(task.getId());
            "missing-task",
                    assertThat(task.getAssignment().getExplanation(), equalTo("no appropriate nodes found for the assignment"));
            assertThat(tasksInProgress.tasks().size(), equalTo(1));
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
    private <P extends PersistentTaskParams> PersistentTasksClusterService createService(
        // add a node if there are unassigned tasks
        AtomicBoolean completed = new AtomicBoolean(false);
                }
    public void testNonClusterStateConditionAssignment() {
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
            if (randomBoolean()) {
            } else {
    private ClusterService clusterService;
            logger.info("inter {} significant: {}", i, significant);
        PersistentTasksCustomMetadata tasks = clusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
            .addTask("_task_2", "test", null, new Assignment("_node_2", ""))
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        ClusterState.Builder builder = ClusterState.builder(clusterState);
        ClusterState clusterState = initialState();
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        assertThat(result.executionResults.get(entry).isSuccess(), is(false));
                case "assign_me":
        assertThat(updatedTasks.getTask(taskToUnassign).getAssignment().getExplanation(), equalTo("unassignment test"));
    }
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        );
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        );
    private static ThreadPool threadPool;
 * You may obtain a copy of the License at
        DiscoveryNodes nodes = clusterState.nodes();
        ClusterState clusterState = builder.metadata(metadata).nodes(nodes).build();
        // Test completion without failure
            .clusterManagerNodeId("_node_1");
            .clusterManagerNodeId("_node_1");
        );
        nodes.add(DiscoveryNode.createLocal(Settings.EMPTY, buildNewFakeTransportAddress(), "this_node"));
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
                }
        // First entry: remove a non-existent task (should fail)
        PersistentTasksCustomMetadata builtTasks = tasks.build();
            clusterState,
                        assertThat(task, is(notNullValue()));
            .build();
        );
            .localNodeId("_node_1")
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata())
            })
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
                            Settings.builder()
            clusterState,
            999999L,
            return false;
        assertThat(tasksInProgress.tasks().size(), equalTo(1));
        ClusterService recheckTestClusterService = createRecheckTestClusterService(clusterState, shouldSimulateFailure);
        assertThat(updatedTasks.getTask(taskToUpdate), is(notNullValue()));
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
        }
                try {
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        for (final String node : nodes.getNodes().keySet()) {
 * under the License.
        return "nodes_changed: "
        service.createPersistentTask(
            .build();
    public void testConcurrentSubmissionsAreBatched() throws Exception {
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
            .putCustom(PersistentTasksCustomMetadata.TYPE, tasksBuilder.build());
    }
     * Tests that the UPDATE_TASK_STATE throttling threshold in ClusterManagerTask
            + " nodes_removed:"
                    }, e -> {
    }
            .clusterManagerNodeId("_node_1")
        service.setRecheckInterval(TimeValue.timeValueMillis(1));
        assertThat(createEntry.toString(), equalTo("CREATE[" + newTaskId + "]"));
        PersistentTasksCustomMetadata updatedTasks = result.resultingState.metadata().custom(PersistentTasksCustomMetadata.TYPE);
            for (PersistentTask<?> task : tasksInProgress.tasks()) {
                        assignOneCount++;
            }
import org.junit.BeforeClass;
            assertThat(task.getId(), equalTo(taskId));
            if (changed) {
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
                assertThat(task.isAssigned(), equalTo(false));
                assertThat(task.getExecutorNode(), nullValue());
            // clear the task
        ClusterState clusterState = initialState();
        }, e -> fail()));
        service.unassignPersistentTask(taskId, tasks.getLastAllocationId(), "test unassign reason", ActionListener.wrap(task -> {
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(
        String taskId = addTask(tasks, "assign_me", "_node_1");
        String taskId = addTask(tasks, "assign_me", "_node_1");
import org.opensearch.cluster.ClusterChangedEvent;
/*
            taskId,
        }
        int numberOfTasks = randomIntBetween(2, 40);
    public void testCompleteWithNonExistingTask() {
        assertThat(result.executionResults.get(entry).getFailure(), instanceOf(ResourceAlreadyExistsException.class));
        clusterState = builder.metadata(metadata).nodes(nodes).build();
    }
                            ? "explanation: assign_based_on_non_cluster_state_condition"
            .build();
            "non-existent-task"
    public void testBatchedPartialFailure() {
        String param
    public void testCreateNewTask() {
    public void testRemovePersistentTaskDelegation() throws Exception {
                : randomNodeAssignment(clusterState.nodes())
    }
            .nodes(nodes)
            }
        ClusterState clusterState = initialState();
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        PersistentTasksClusterService.PersistentTaskUpdateEntry unassignEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry
    public void testReassignConsidersClusterStateUpdates() {
    }
    /**
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
                protected void nodeOperation(AllocatedPersistentTask task, P params, PersistentTaskState state) {
            .addTask("_task_1", TestPersistentTasksExecutor.NAME, null, new Assignment(unassigned ? null : "_node", "_reason"))
 * Unless required by applicable law or agreed to in writing,
        return tasks;
    public void testBatchedCompleteAfterRemoveDoesNotNPE() {
 * not use this file except in compliance with the License.
                assertThat(task.getAssignment().getExplanation(), equalTo("non-cluster state condition prevents assignment"));
        service.updatePersistentTaskState(taskId, tasks.getLastAllocationId(), newState, ActionListener.wrap(task -> {
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
                // Remove all unassigned tasks that cause changing assignments they might trigger a significant change
                    // add an unassigned task that should get assigned because it's assigned to a non-existing node or unassigned
    public void testPersistentTasksChangedNoTasks() {
        assertThat(createdTask.get().getId(), equalTo(taskId));
        ClusterState.Builder builder = ClusterState.builder(initialState);
        DiscoveryNodes nodes = DiscoveryNodes.builder()
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        ClusterState newClusterState = reassign(createService(), clusterState);
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        DiscoveryNodes nodes = DiscoveryNodes.builder()
            ClusterState after = task.execute(before);
import java.util.Collections;
/*
import static org.hamcrest.Matchers.nullValue;
        );
            .build();
import static org.mockito.Mockito.any;
import org.opensearch.ResourceNotFoundException;
                    changed = true;
            .addTask("_task_1", "test", null, new Assignment("_node_1", "_reason"))
    private ClusterState reassign(PersistentTasksClusterService service, ClusterState clusterState) {
        ClusterChangedEvent event = new ClusterChangedEvent("test", clusterState, initialState);
        ClusterChangedEvent event = new ClusterChangedEvent("test", clusterState, initialState);
import org.opensearch.common.settings.Settings;
        String node
            clusterState,
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        assertThat(result.executionResults.get(createEntry).isSuccess(), is(true));
            assertThat(task, is(notNullValue()));
        String taskId2 = addTask(tasks, "assign_me", "_node_1");
            }
        addTestNodes(nodes, randomIntBetween(1, 10));
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
            if (testFailureNextTime.compareAndSet(true, false)) {
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
                    return assignOnlyOneTaskAtATime(currentState);
        }
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
        nonClusterStateCondition = false;
                    assertThat(task.isAssigned(), equalTo(false));
            .clusterManagerNodeId("_node_1");
import java.util.List;
 * KIND, either express or implied.  See the License for the
        );
                metadata.putCustom(PersistentTasksCustomMetadata.TYPE, tasksBuilder.build());
        }
            final String taskId = taskIds.get(i);
            .clusterManagerNodeId("_node_1");
        // After the REMOVE, the task no longer exists, so this should hit the
        IndexMetadata indexMetadata = IndexMetadata.builder(randomAlphaOfLength(10))
        PersistentTasksCustomMetadata tasks = clusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
            .metadata(Metadata.builder().putCustom(PersistentTasksCustomMetadata.TYPE, currentTasks))
        clusterService.close();
            nodes.add(new DiscoveryNode("other_node_" + i, buildNewFakeTransportAddress(), Version.CURRENT));
        assertThat(createdTask.get(), is(notNullValue()));
import org.opensearch.threadpool.ThreadPool;
            }, e -> fail("createPersistentTask should not fail: " + e.getMessage()))
                    return builder.build();
        PersistentTasksClusterService.PersistentTaskUpdateEntry entry = PersistentTasksClusterService.PersistentTaskUpdateEntry.create(
     * Tests that createPersistentTask triggers the periodic rechecker when
            .create(newTaskId, TestPersistentTasksExecutor.NAME, new TestParams("assign_me"));
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
 *
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        assertBusy(() -> assertThat(completed.get(), is(true)));
        assertThat(result.executionResults.get(entry).isSuccess(), is(false));
                assertThat(task, is(notNullValue()));
        }, e -> fail("unassignPersistentTask should not fail: " + e.getMessage())));
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(initialState.nodes());
            Collections.singletonList(entry)
            taskId,
                    barrier.await(10, TimeUnit.SECONDS);
    public void testPersistentTasksChangedTaskRemoved() {
        int concurrentUpdates = 10;
            allocation = randomValueOtherThan(allocation, () -> randomFrom(EnableAssignmentDecider.Allocation.values()));
            }
            (params, currentState) -> assignBasedOnNonClusterStateCondition(currentState.nodes())
import org.opensearch.cluster.metadata.Metadata;
            changeRoutingTable(metadata, routingTable);
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_2", "test"));
        PersistentTasksCustomMetadata tasksInProgress = clusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
import java.util.ArrayList;
                        .persistentSettings(
        PersistentTasksClusterService service = createService((params, currentState) -> NO_NODE_FOUND);
    }
                    Metadata.builder(clusterState.metadata()),
            if (randomBoolean()) {
            + event.nodesChanged()
        assertThat(updatedTasks.getTask(taskToUnassign).getAssignment().getExecutorNode(), is(nullValue()));
        } else {
                case "dont_assign_me":
            assertThat(task.getAssignment().getExecutorNode(), is(nullValue()));
        assertThat("number of tasks shouldn't change as a result or reassignment", numberOfTasks, equalTo(tasksInProgress.tasks().size()));
                        logger.error("unexpected failure for task " + taskId, e);
            AtomicBoolean success = new AtomicBoolean(false);
        // Test completion with failure (covers the failure logging branch)
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
            + event.nodesRemoved()
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
        ClusterState clusterState = initialState();
                completed2.set(true);
                    task.getAssignment().getExplanation(),
                case 0:
        for (int i = 0; i < nonLocalNodesCount; i++) {
            Collections.singletonList(entry)
/*
            .clusterManagerNodeId("_node_1");
        }
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        }
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(initialState.nodes());
        );
                return tasksBuilder.build();
        service.clusterChanged(event);
        PersistentTasksCustomMetadata currentTasks = PersistentTasksCustomMetadata.builder()
            for (PersistentTask<?> task : tasks.tasks()) {
                    logger.info("removed unassigned node {}", node.getId());
        assertThat(updateTaskState.getThreshold(), equalTo(300));
                // we don't have any unassigned tasks - adding a node or changing a routing table shouldn't affect anything
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
            .persistentSettings(
        ClusterState current = ClusterState.builder(new ClusterName("_name"))
            .build();
            existingTaskId,
 * this file be licensed under the Apache-2.0 license or a
                                .put(EnableAssignmentDecider.CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING.getKey(), allocation.toString())
        if (tasks == null || tasks.tasks().isEmpty()) {
        ClusterState.Builder builder = ClusterState.builder(clusterState);
        ClusterState nonMasterClusterState = builder.nodes(nodes).build();
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        ClusterState clusterState = initialState();
        String node = randomFrom(nodeList);
        PersistentTasksCustomMetadata previousTasks = PersistentTasksCustomMetadata.builder()
        return createService((params, currentState) -> {
        assertThat(updatedTasks.getTask(existingTask), is(nullValue()));
            switch (randomInt(2)) {
                return "never_assign".equals(((TestParams) task.getParams()).getTestParam()) == false;
                case "assign_me":
        ClusterState newClusterState = recheckTestClusterService.state();
        if (changed) {
        );
 * The OpenSearch Contributors require contributions made to
        assertThat(dumpEvent(event), service.shouldReassignPersistentTasks(event), equalTo(changed && unassigned));
            .build();
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        String taskId1 = addTask(tasks, "assign_me", "_node_1");
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
            .build();
            .metadata(Metadata.builder().putCustom(PersistentTasksCustomMetadata.TYPE, previousTasks))
        // This ensures no NPE from getTaskWithId().getTaskName() on a removed task.
            PersistentTasksCustomMetadata tasksInProgress = newClusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
            .settings(Settings.builder().put("index.version.created", VersionUtils.randomVersion(random())))
    }
            new TestParams("assign_me")
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
            assertThat(task.getAssignment().getExplanation(), equalTo("test assignment"));
        assertThat(unassignEntry.toString(), equalTo("UNASSIGN[" + taskToUnassign + "]"));
        ClusterState newClusterState = reassign(createService(), clusterState);
        PersistentTasksClusterService.PersistentTaskUpdateEntry createEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry
    private ClusterState initialState() {
            .build();
                logger.info("set task custom to null");
        CountDownLatch allCompleted = new CountDownLatch(concurrentUpdates);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            TestPersistentTasksExecutor.NAME,
     */
        ClusterState.Builder builder = ClusterState.builder(clusterState);
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder();
            (params, currentState) -> assignBasedOnNonClusterStateCondition(currentState.nodes())
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
        // UPDATE_STATE: task should have updated state
        }
                default:
     */
        clusterState = builder.metadata(metadata).nodes(nodes).build();
        PersistentTasksCustomMetadata tasks = PersistentTasksCustomMetadata.builder()
        assertThat(executor.getClusterManagerThrottlingKey(), is(notNullValue()));
            } else {
    }
    }
                    break;
        super.tearDown();
        ClusterState previous = ClusterState.builder(new ClusterName("_name"))
        return new PersistentTasksClusterService(Settings.EMPTY, registry, clusterService, threadPool);
                            : "non-cluster state condition prevents assignment"
            999999L,
            .clusterManagerNodeId("_node_1");
            } else {
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        }, e -> fail()));
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        assertThat(tasksInProgress, notNullValue());
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
            .clusterManagerNodeId("_node_1");
    /**
            boolean significant = randomBoolean();
            .addTask("_task_1", "test", null, new Assignment("_node_1", ""))
            assertThat(task.isAssigned(), equalTo(true));
        }
    public void testCreatePersistentTaskTriggersRecheckerWhenUnassigned() throws Exception {
                tasksOrNodesChanged = true;
        assertThat(result.executionResults.get(completeEntry).getFailure(), instanceOf(ResourceNotFoundException.class));
            .localNodeId("_node_1")
        PersistentTasksClusterService.PersistentTaskUpdateEntry completeEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry
        CyclicBarrier barrier = new CyclicBarrier(concurrentUpdates);
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        assertTrue("persistent tasks changed (task removed)", persistentTasksChanged(new ClusterChangedEvent("test", current, previous)));
        String taskId = addTask(tasks, "assign_me", "_node_1");
            thread.start();
import java.util.concurrent.TimeUnit;
    public void testReassignTasks() {
            clusterState,
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        int randomIndices = randomIntBetween(0, 5);
                    assertThat(task.getAssignment().getExplanation(), equalTo("test assignment"));
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
            .localNodeId("_node_1")
                        assertThat("more than one assign_one tasks are assigned", assignOneCount, lessThanOrEqualTo(1));
            assertThat(tasksInProgress, notNullValue());
import static org.mockito.Mockito.mock;
        ClusterState initialState = initialState();
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
                logger.info("changed routing table");
        // The rechecker should recheck indefinitely on the cluster-manager node as the
     * the created task ends up unassigned (no suitable node found).
        return clusterStateBuilder.metadata(
        // Verify throttling key is available
    private void addTestNodes(DiscoveryNodes.Builder nodes, int nonLocalNodesCount) {
    private void changeRoutingTable(Metadata.Builder metadata, RoutingTable.Builder routingTable) {
                @Override
import static org.hamcrest.Matchers.notNullValue;
import java.util.concurrent.CyclicBarrier;
            taskId,
        ClusterState clusterState = initialState();
                }
        String id = UUIDs.base64UUID();
            .localNodeId("_node_1")
        addTask(tasks, "assign_based_on_non_cluster_state_condition", null);
        }
            .localNodeId("_node_1")
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
 * software distributed under the License is distributed on an
    }
            }
    }
        PersistentTasksCustomMetadata builtTasks = tasks.build();
            .clusterManagerNodeId("_node_1");
        assertTrue("all updates should complete within timeout", allCompleted.await(30, TimeUnit.SECONDS));
     */
                    new Assignment(null, "change me"),
        boolean tasksOrNodesChanged = false;
                    if (task.isAssigned() && clusterState.nodes().nodeExists(task.getExecutorNode())) {
import org.opensearch.persistent.TestPersistentTasksPlugin.TestPersistentTasksExecutor;
                } catch (Exception e) {
        assertThat(result.executionResults.get(entry).getFailure(), instanceOf(ResourceNotFoundException.class));
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        );
        tasks.addTask(id, TestPersistentTasksExecutor.NAME, new TestParams(param), new Assignment(node, "explanation: " + param));
import org.junit.After;
            "non-existing-task",
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
            }, e -> fail())
            .localNodeId("_node")
                    .putCustom(PersistentTasksCustomMetadata.TYPE, PersistentTasksCustomMetadata.builder().build());
        return id;
                    }));
            .addTask("_task_2", "test", null, new Assignment("_node_1", "_reason"))
}
        return addRandomTask(clusterStateBuilder, metadata, tasks, new Assignment(node, randomAlphaOfLength(10)), randomAlphaOfLength(10));
                    assertThat(
            assertThat(dumpEvent(event), service.shouldReassignPersistentTasks(event), equalTo(significant));
            PersistentTasksCustomMetadata tasksInProgress = newClusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
        for (PersistentTask<?> task : tasksInProgress.tasks()) {
        // First entry: REMOVE the task (will succeed)
            completed.set(true);
        AtomicBoolean testFailureNextTime = new AtomicBoolean(shouldSimulateFailure);
import static java.util.Collections.emptyMap;
        AtomicBoolean completed = new AtomicBoolean(false);
        }
            return null;
        if (clusterState.nodes().getNodes().isEmpty()) {
        AtomicBoolean completed = new AtomicBoolean(false);
            Collections.singletonList(entry)
        );
        // Second entry: COMPLETE the same task with wrong allocation ID
        PersistentTasksClusterService.PersistentTaskUpdateEntry entry = PersistentTasksClusterService.PersistentTaskUpdateEntry.updateState(
        ClusterState clusterState = initialState();
            assertThat(task, is(notNullValue()));
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        ClusterService recheckTestClusterService = mock(ClusterService.class);
            .metadata(Metadata.builder().putCustom(PersistentTasksCustomMetadata.TYPE, previousTasks))
        assertTrue("persistent tasks changed (task assigned)", persistentTasksChanged(new ClusterChangedEvent("test", current, previous)));
    }
            .clusterManagerNodeId("_node_1")
    /** Needed by {@link ClusterService} **/
    public void testCreatePersistentTaskDelegation() throws Exception {
            nodeList.add(node);
        // Just add a random index - that shouldn't change anything
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
    }
            .build();
        );
        // Use a barrier to ensure all threads submit simultaneously
    public void testNeedsReassignment() {
    ) {
        );
                .custom(PersistentTasksCustomMetadata.TYPE);
        }
        ClusterState previous = ClusterState.builder(new ClusterName("_name")).nodes(nodes).build();
 *
        }
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
    }
                }
            }
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
                    return assignBasedOnNonClusterStateCondition(currentState.nodes());
            }
    private ClusterState insignificantChange(ClusterState clusterState) {
                    equalTo(
            .metadata(Metadata.builder().putCustom(PersistentTasksCustomMetadata.TYPE, currentTasks))
        PersistentTasksExecutorRegistry registry = new PersistentTasksExecutorRegistry(
import org.opensearch.cluster.ClusterStateTaskExecutor;
        ClusterState clusterState = initialState();
            .numberOfShards(1)
import org.opensearch.threadpool.TestThreadPool;
        ClusterState current = ClusterState.builder(new ClusterName("_name")).nodes(nodes).build();
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
        }
            final PersistentTaskState newState = new TestPersistentTasksPlugin.State("phase_" + i);
        }
            .nodes(nodes)
            assertThat(tasksInProgress.tasks().size(), equalTo(1));
        return tasks != null && tasks.tasks().stream().anyMatch(task -> nodeId.equals(task.getExecutorNode())) == false;
    public void tearDown() throws Exception {
        String taskId = UUIDs.base64UUID();
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
        setState(clusterService, clusterState);
        assertFalse(needsReassignment(new Assignment("_node_1", "assigned"), nodes));
        int numberOfIterations = randomIntBetween(1, 30);
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
        assertBusy(
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
            .localNodeId("_node_1")
            current = ClusterState.builder(previous).build();
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        tasks = removeTasksWithChangingAssignment(tasks);
        {
            ActionListener.wrap(task -> fail(), e -> assertThat(e, instanceOf(ResourceNotFoundException.class)))
            assertThat(tasksInProgress, notNullValue());
        setState(clusterService, clusterState);
        final boolean changed = randomBoolean();
        service.unassignPersistentTask(
import org.opensearch.persistent.TestPersistentTasksPlugin.TestParams;
    }
        setState(clusterService, clusterState);
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        ClusterState.Builder builder = ClusterState.builder(clusterState);
        PersistentTasksCustomMetadata previousTasks = PersistentTasksCustomMetadata.builder()
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
        final ClusterChangedEvent event = new ClusterChangedEvent("test", current, previous);
        PersistentTasksCustomMetadata updatedTasks = result.resultingState.metadata().custom(PersistentTasksCustomMetadata.TYPE);
        assertThat(result.executionResults.get(completeEntry).isSuccess(), is(true));
        ClusterState clusterState = builder.metadata(metadata).nodes(nodes).build();
    }
     * Tests that concurrent submissions to the same PersistentTaskUpdateExecutor
        PersistentTasksClusterService.PersistentTaskUpdateEntry removeEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry
                    fail("Unknown action " + task.getTaskName());
            .add(new DiscoveryNode("_node_2", buildNewFakeTransportAddress(), Version.CURRENT))
import org.opensearch.cluster.service.ClusterManagerTask;
                )
            .build();
 * GitHub history for details.
        ClusterState previous = ClusterState.builder(new ClusterName("_name")).nodes(nodes).build();
        PersistentTasksClusterService.PersistentTaskUpdateEntry entry = PersistentTasksClusterService.PersistentTaskUpdateEntry.create(
        // CREATE: new task should exist and be assigned
            new TestParams("dont_assign_me"),
        assertThat(updatedTasks.getTask(taskToUnassign), is(notNullValue()));
                    addTask(tasks, "assign_me", randomBoolean() ? null : "no_longer_exists");
        );
        ClusterService recheckTestClusterService = createRecheckTestClusterService(clusterState, false);
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        if (nonClusterStateCondition) {
        assertThat(tasksInProgress, notNullValue());
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
            .remove(existingTask);
            return NO_NODE_FOUND;
        assertBusy(() -> assertThat(completed.get(), is(true)));
        assertThat(updatedTasks.getTask(taskToRemove), is(nullValue()));
        ClusterState clusterState = initialState();
 * Licensed to Elasticsearch under one or more contributor
            ClusterStateUpdateTask task = (ClusterStateUpdateTask) invocationOnMock.getArguments()[1];
        );
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        String taskToRemove = addTask(tasks, "assign_me", "_node_1");
            builder.metadata(metadata).routingTable(routingTable.build());
import org.opensearch.cluster.ClusterStateUpdateTask;
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        assertThat(updateTaskState, is(notNullValue()));
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        });
                    );
import org.junit.Before;
            task -> "assign_one".equals(((TestParams) task.getParams()).getTestParam()) && nodes.nodeExists(task.getExecutorNode())
        service.clusterChanged(event);
        ClusterState.Builder builder = ClusterState.builder(clusterState);
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        assertTrue("persistent tasks changed (task added)", persistentTasksChanged(new ClusterChangedEvent("test", current, previous)));
            .localNodeId("_node_1")
            }
            .clusterManagerNodeId("_node_1");
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        }
                task.clusterStateProcessed("test", before, after);
            .add(new DiscoveryNode("_node_2", buildNewFakeTransportAddress(), Version.CURRENT))
                        return builder.build();
                        )
        ClusterState.Builder builder = ClusterState.builder(initialState);
        );
            .clusterManagerNodeId("_node_1");
                        assertThat(task.getAssignment().getExplanation(), equalTo("test assignment"));
        );
        ClusterState clusterState = initialState();
            () -> assertTrue("periodic rechecker should be scheduled for unassigned task", service.getPeriodicRechecker().isScheduled())
        }, e -> fail()));
                state.set(after);
            .localNodeId("_node_1")
            Arrays.asList(createEntry, updateEntry, removeEntry, completeEntry, unassignEntry)
        ClusterState clusterState = initialState();
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        String newTaskId = UUIDs.base64UUID();
        clusterService = createClusterService(threadPool);
            // we don't have any unassigned tasks - add some
        // COMPLETE: task should be gone
        );
    }
        ClusterState clusterState = initialState();
                    return NO_NODE_FOUND;
                    builder.nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode(randomAlphaOfLength(10))));
    }
    }
                Settings.builder()
            Collections.singletonList(entry)
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
        if (randomBoolean()) {
    public void testUnassignPersistentTaskDelegation() throws Exception {
                assertThat(
        ClusterState clusterState = initialState();
        PersistentTasksClusterService.PersistentTaskUpdateEntry failEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry.remove(
            .build();
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        });
            taskIds.add(addTask(tasks, "assign_me", "_node_1"));
        });
 */
        PersistentTasksClusterService.PersistentTaskUpdateEntry entry = PersistentTasksClusterService.PersistentTaskUpdateEntry.unassign(
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
            .clusterManagerNodeId("_node_1");
            .addTask("_task_1", "test", null, new Assignment(null, "_reason"))
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(
        String taskId = UUIDs.base64UUID();
            if (hasAssignableTasks(tasks, clusterState.nodes()) == false) {
            return new Assignment(null, "non-cluster state condition prevents assignment");
    @AfterClass
    private ClusterState.Builder addRandomTask(
     * is correctly set to 300 (increased from the original 50).
    private Assignment randomNodeAssignment(DiscoveryNodes nodes) {
    }
        nonClusterStateCondition = true;
import org.opensearch.cluster.node.DiscoveryNodeRole;
        // add a new unassigned task
                logger.info("added random task");
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
import static java.util.Collections.singleton;
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        );
            .add(new DiscoveryNode("_node_2", buildNewFakeTransportAddress(), Version.CURRENT));
        assertThat(result.executionResults.get(entry).isSuccess(), is(false));
            .build();
                    tasksBuilder.removeTask(task.getId());
        );
            .addTask("_task_2", "test", null, new Assignment(null, "unassigned"))
        terminate(threadPool);
 * SPDX-License-Identifier: Apache-2.0
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
            assertThat(task.getAssignment().getExplanation(), equalTo("test unassign reason"));
        assertThat(result.executionResults.get(failEntry).isSuccess(), is(false));
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(
        EnableAssignmentDecider.Allocation allocation = randomFrom(EnableAssignmentDecider.Allocation.values());
        // Use a wrong allocation id - task exists but allocation id doesn't match
                );
            + event.routingTableChanged()
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
            .build();
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
                    fail("the decision decider shouldn't be called on this task");
        ClusterState clusterState = initialState();
    @Before
        assertBusy(() -> assertThat(completed.get(), is(true)));
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
        assertThat(result.executionResults.get(unassignEntry).isSuccess(), is(true));
import org.opensearch.cluster.ClusterName;
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_2", "test"));
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
import org.opensearch.common.UUIDs;
    private ClusterService createRecheckTestClusterService(ClusterState initialState, boolean shouldSimulateFailure) {
        assertThat(tasksInProgress, notNullValue());
 */
            + event.state().metadata().custom(PersistentTasksCustomMetadata.TYPE);
    }
    public void testPersistentTasksChangedTaskAdded() {
            metadata.putCustom(
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
    }
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        PersistentTasksClusterService service = createService();
import java.util.concurrent.atomic.AtomicBoolean;
            for (PersistentTask<?> task : tasksInProgress.tasks()) {
        setState(clusterService, clusterState);
        return createService(clusterService, fn);
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
import org.opensearch.persistent.decider.EnableAssignmentDecider;
            }
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
                    service.updatePersistentTaskState(taskId, allocationId, newState, ActionListener.wrap(task -> {
        nodes.clusterManagerNodeId("a_new_cluster_manager_node");
                    PersistentTasksCustomMetadata.builder(tasks),
        for (int i = 0; i < concurrentUpdates; i++) {
                );
        builder = ClusterState.builder(clusterState);
        }
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        assertThat(result.executionResults.get(updateEntry).isSuccess(), is(true));
            logger.info("changed routing table");
    public void testBatchedMixedOperations() {
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
                    "never_assign"
                        equalTo(true)
                    return randomNodeAssignment(currentState.nodes());
        assertBusy(() -> assertThat(completed.get(), is(true)));
                    if (clusterState.nodes().nodeExists(task.getExecutorNode()) == false) {
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
                        "task should be assigned to a node that is in the cluster, was assigned to " + task.getExecutorNode(),
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
        ClusterState.Builder clusterStateBuilder,
                        clusterState.nodes().nodeExists(task.getExecutorNode()),
    public void testCompleteWithWrongAllocationId() {
        Metadata metadata = Metadata.builder()
    }
            createdTask.set(task);
        addTestNodes(nodes, randomIntBetween(1, 3));
            assertThat(task.getId(), equalTo(unassignedId));
        List<String> taskIds = new ArrayList<>();
            completed.set(true);
        assertBusy(() -> assertThat(completed2.get(), is(true)));
            singleton(new PersistentTasksExecutor<P>(TestPersistentTasksExecutor.NAME, null) {
package org.opensearch.persistent;
                }
            if (randomBoolean()) {
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
            changeRoutingTable(metadata, routingTable);
        // Now simulate the node ceasing to be the cluster-manager
        for (int i = 0; i < concurrentUpdates; i++) {
        String taskId = addTask(tasks, "assign_me", "_node_1");
                }
    private ClusterState significantChange(ClusterState clusterState) {
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
                changeRoutingTable(metadata, routingTable);
        );
        assertThat(result.executionResults.get(entry).getFailure(), instanceOf(ResourceNotFoundException.class));
        PersistentTasksCustomMetadata.Builder tasks,
            completed.set(true);
            clusterState,
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            .build();
        for (PersistentTask<?> task : tasksInProgress.tasks()) {
import static org.opensearch.test.ClusterServiceUtils.setState;
            )
            });
     * Tests that unassignPersistentTask works correctly through the batched delegation path,
        assertThat(result.executionResults.get(entry).isSuccess(), is(false));
            .complete(taskId, 999999L);
        } else {
        event = new ClusterChangedEvent("test", nonMasterClusterState, clusterState);
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        if (hasAssignableTasks(tasks, clusterState.nodes()) == false) {
                if (task.getExecutorNode() == null || "never_assign".equals(((TestParams) task.getParams()).getTestParam())) {
            TestPersistentTasksExecutor.NAME,
                    assertThat(task.getExecutorNode(), nullValue());
                    } else {
            ActionListener.wrap(task -> {
        setState(clusterService, clusterState);
                    fail("unknown param " + testParams.getTestParam());
            .add(new DiscoveryNode("_node_2", buildNewFakeTransportAddress(), Version.CURRENT));
    }
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        // Second entry: remove an existing task (should succeed despite first failure)
                    if (task.isAssigned()) {
    public void testUpdatePersistentTaskStateDelegation() throws Exception {
    }
        ClusterState newClusterState = reassign(service, clusterState);
        tasksInProgress = finalClusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
        IndexMetadata indexMetadata = IndexMetadata.builder(randomAlphaOfLength(10))
        PersistentTasksCustomMetadata updatedTasks = result.resultingState.metadata().custom(PersistentTasksCustomMetadata.TYPE);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.node.DiscoveryNodes;
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
    }
        assertTrue(service.getPeriodicRechecker().isScheduled());
                case "assign_one":
                return builder.metadata(metadata).build();
            .localNodeId("_node_1")
            Collections.singletonList(entry)
        final BiFunction<P, ClusterState, Assignment> fn
                .getMetadata()
                    allCompleted.countDown();
            PersistentTasksCustomMetadata.Builder tasksBuilder = PersistentTasksCustomMetadata.builder(tasks);
    public static void setUpThreadPool() {
 * ownership. Elasticsearch licenses this file to you under
        assertThat(updatedTasks.getTask(newTaskId).getTaskName(), equalTo(TestPersistentTasksExecutor.NAME));
     */
        assertThat(result.executionResults.get(failEntry).getFailure(), instanceOf(ResourceNotFoundException.class));
        AtomicBoolean completed1 = new AtomicBoolean(false);
                clusterState = insignificantChange(clusterState);
                    // add a task assigned to non-existing node that should not get assigned
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
    }
     * verifying the listener callback receives the created task with correct assignment.
        addTestNodes(nodes, randomIntBetween(1, 3));
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        ClusterState newClusterState = recheckTestClusterService.state();
            assertThat(task.getId(), equalTo(taskId1));
    }
        ).isEmpty()) {
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        );
import org.opensearch.cluster.routing.RoutingTable;
            assertThat(task, is(notNullValue()));
import java.util.Arrays;
                PersistentTasksCustomMetadata.TYPE,
            assertThat(task.getAssignment().getExplanation(), equalTo("unassignment test"));
            }
            } else {
    }
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
        );
                }
        assertThat(updatedTasks.getTask(newTaskId).getAssignment().getExecutorNode(), equalTo("_node_1"));
import org.opensearch.cluster.service.ClusterService;
        ClusterState.Builder builder = ClusterState.builder(clusterState);
            .localNodeId("_node_1")
        }, e -> fail("createPersistentTask should not fail: " + e.getMessage())));
            ClusterChangedEvent event = new ClusterChangedEvent("test", clusterState, previousState);
        );
    }
            assertThat(task.getExecutorNode(), notNullValue());
     * Tests the createPersistentTask end-to-end delegation through the batched path,
        PersistentTasksClusterService service = createService(
            .numberOfReplicas(1)
        ClusterState initialState = initialState();
        );
 * license agreements. See the NOTICE file distributed with
        ClusterState clusterState = initialState();
import org.opensearch.core.action.ActionListener;
                case 1:
                case "assign_based_on_non_cluster_state_condition":
    public void testUnassignNonExistentTask() {
            .nodes(nodes)
    }
        assertThat(result.executionResults.get(entry).isSuccess(), is(true));
            initialState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
            .metadata(Metadata.builder().putCustom(PersistentTasksCustomMetadata.TYPE, tasks))
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
            .build();
                                .build()
        String existingTask = addTask(tasks, "assign_me", "_node_1");
        setState(clusterService, clusterState);
                assertThat(task.isAssigned(), equalTo(true));
 *
        );
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
            PersistentTasksCustomMetadata tasksInProgress = recheckTestClusterService.state()
        assertThat(result.executionResults.get(removeEntry).isSuccess(), is(true));
            switch (testParams.getTestParam()) {
    public void testPeriodicRecheck() throws Exception {
    private boolean hasAssignableTasks(PersistentTasksCustomMetadata tasks, DiscoveryNodes discoveryNodes) {
        boolean shouldSimulateFailure = randomBoolean();
import org.opensearch.cluster.metadata.IndexMetadata;
            successes.add(success);
                addRandomTask(builder, Metadata.builder(clusterState.metadata()), PersistentTasksCustomMetadata.builder(tasks), null);
            999999L
    ) {
        assertThat(updatedTasks.getTask(newTaskId), is(notNullValue()));
            // explanation should correspond to the action name
        assertBusy(() -> {
                logger.info("removed all tasks");
        String unassignedId = addTask(tasks, "unassign", "_node_2");
        }
        DiscoveryNodes nodes = DiscoveryNodes.builder()
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
            clusterState,
            initialState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
    private boolean hasTasksAssignedTo(PersistentTasksCustomMetadata tasks, String nodeId) {
        return tasks.tasks().stream().anyMatch(task -> {
            Collections.singletonList(entry)
            1L,
        if (tasks != null) {
    }
        final PersistentTasksClusterService service = createService(
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        // This should NOT throw NPE
        String existingTaskId = addTask(tasks, "assign_me", "_node_1");
public class PersistentTasksClusterServiceTests extends OpenSearchTestCase {
        threadPool = new TestThreadPool(PersistentTasksClusterServiceTests.class.getSimpleName());
                default:
                        assertThat(task.getId(), equalTo(taskId));
            .add(new DiscoveryNode("_node_2", buildNewFakeTransportAddress(), Version.CURRENT));
        assertThat(result.executionResults.get(completeEntry).isSuccess(), is(false));
                if ("never_assign".equals(((TestParams) task.getParams()).getTestParam())
                tasks.addTask(UUIDs.base64UUID(), TestPersistentTasksExecutor.NAME, new TestParams(param), assignment).build()
            .build();
            if (task.getExecutorNode() == null || discoveryNodes.nodeExists(task.getExecutorNode())) {
            builder.nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode(randomAlphaOfLength(10))));
                    return null;
            .add(new DiscoveryNode("_node_2", buildNewFakeTransportAddress(), Version.CURRENT))
        );
            .clusterManagerNodeId("_node_1");
        PersistentTasksClusterService.PersistentTaskUpdateEntry removeEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry
                    builder,
    public void testReassignTasksWithNoTasks() {
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
                    .build()
            tasks.getLastAllocationId(),
    public void testCompletePersistentTaskDelegation() throws Exception {
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        );
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
        Metadata.Builder metadata,
        assertThat(updatedTasks.getTask(newTaskId).getTaskName(), equalTo(TestPersistentTasksExecutor.NAME));
        PersistentTasksCustomMetadata.Builder tasks,
            assertTrue("update " + i + " should have succeeded", successes.get(i).get());
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        {
        );
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
    }
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
                    assertThat(task.getExecutorNode(), notNullValue());
import org.opensearch.cluster.node.DiscoveryNode;
                public Assignment getAssignment(P params, ClusterState clusterState) {
            .localNodeId("_node_1")
     * are actually batched into a single execute() call by the TaskBatcher.
    private <P extends PersistentTaskParams> PersistentTasksClusterService createService(final BiFunction<P, ClusterState, Assignment> fn) {
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
            .clusterManagerNodeId("_node_1");
        // The periodic rechecker should have been triggered because the task is unassigned
                    }
        return builder.metadata(metadata).build();
    public static void tearDownThreadPool() {
    /**
            @SuppressWarnings("unchecked")
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test assignment"));
                case "dont_assign_me":
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        assertFalse("persistent tasks unchanged (no tasks)", persistentTasksChanged(new ClusterChangedEvent("test", current, previous)));
            completed.set(true);
            return randomNodeAssignment(clusterState.nodes());
        clusterState = builder.metadata(metadata).nodes(nodes).build();
            assertThat(tasksInProgress.tasks().size(), equalTo(1));
        assertBusy(() -> assertThat(completed1.get(), is(true)));
            ActionListener.wrap(task -> {
        ClusterState.Builder builder = ClusterState.builder(clusterState);
        service.createPersistentTask(taskId, TestPersistentTasksExecutor.NAME, new TestParams("assign_me"), ActionListener.wrap(task -> {
        AtomicReference<PersistentTask<?>> createdTask = new AtomicReference<>();
            recheckTestClusterService,
                    addTask(tasks, "dont_assign_me", randomBoolean() ? null : "no_longer_exists");
        ClusterState clusterState = initialState();
                    Metadata.builder(previous.metadata())
            .addTask("_task_1", "test", null, new Assignment("_node_1", "_reason"))
    }
        PersistentTasksCustomMetadata tasksInProgress = newClusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
    }
    private String addTask(PersistentTasksCustomMetadata.Builder tasks, String param, String node) {
import java.util.HashSet;
            .settings(Settings.builder().put("index.version.created", VersionUtils.randomVersion(random())))
        PersistentTasksClusterService.PersistentTaskUpdateEntry completeEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry
                case "assign_one":
                if (hasTasksAssignedTo(tasks, node.getId()) == false && "this_node".equals(node.getId()) == false) {
        assertTrue(needsReassignment(new Assignment("_node_left", "assigned to a node that left"), nodes));
        assertThat(updateTaskState.getKey(), equalTo("update-task-state"));
        ClusterState current;
            tasks.getLastAllocationId(),
        ClusterState finalClusterState = reassign(service, newClusterState);
        PersistentTaskState newState = new TestPersistentTasksPlugin.State("updated_phase");
                        .build()
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
import java.util.concurrent.CountDownLatch;
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
        service.removePersistentTask(taskId, ActionListener.wrap(task -> {
        }
                    }
    }
        }
    @BeforeClass
            .build();
import java.util.function.BiFunction;
        assertThat(tasksInProgress, notNullValue());
            assertThat(task.getState(), equalTo(newState));
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
            .localNodeId("_node_1")
        PersistentTasksClusterService.PersistentTaskUpdateEntry updateEntry = PersistentTasksClusterService.PersistentTaskUpdateEntry
            return randomNodeAssignment(nodes);
                    return builder.nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(node.getId())).build();
        }
        if (randomBoolean()) {
            switch (((TestParams) task.getParams()).getTestParam()) {
        doAnswer(invocationOnMock -> {
        PersistentTasksClusterService.PersistentTaskUpdateEntry entry = PersistentTasksClusterService.PersistentTaskUpdateEntry.updateState(
        );
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(
        AtomicBoolean completed = new AtomicBoolean(false);
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(
            }
                tasksOrNodesChanged = true;
            .clusterManagerNodeId("_node")
            .localNodeId("_node_1")
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
 */
        // Try to create a task with the same id as an existing task
        nonClusterStateCondition = false;
        // Return NO_NODE_FOUND so the task ends up unassigned
        } else {
                    .put(EnableAssignmentDecider.CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING.getKey(), allocation.toString())
            return false;
            logger.info("added random node");
    }
                RoutingTable.Builder routingTable = RoutingTable.builder(clusterState.routingTable());
        Metadata.Builder metadata = Metadata.builder();
    ) {
        // task can never be assigned while nonClusterStateCondition = false
    public void testCreateDuplicateTask() {
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
            .addTask("_task_1", "test", null, new Assignment("_node_1", ""))
 *    http://www.apache.org/licenses/LICENSE-2.0
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        clusterState = builder.metadata(metadata).nodes(nodes).build();
                        allCompleted.countDown();
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(
        );
        );
                    return fn.apply(params, clusterState);
            "non-existing-task",
        DiscoveryNodes nodes = DiscoveryNodes.builder()
            .localNodeId("_node_1")
            TestPersistentTasksExecutor.NAME,
            .build();
import static org.mockito.Mockito.doAnswer;
                assertThat(task.isAssigned(), is(false));
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
        ClusterState clusterState = initialState();
                    break;
                }
        ClusterState clusterState = initialState();
        );
    public void testPeriodicRecheckOffClusterManager() {
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
            .updateState(taskToUpdate, builtTasks.getTask(taskToUpdate).getAllocationId(), newState);
import static org.hamcrest.Matchers.equalTo;
            new TestPersistentTasksPlugin.State("test")
    }
            assertThat(task.getId(), equalTo(taskId));
            .addTask("_task_3", "test", null, new Assignment("_node_2", "_reason"))
        RoutingTable.Builder routingTable = RoutingTable.builder();
        assertThat(result.executionResults.get(entry).isSuccess(), is(false));
                        builder.nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(task.getExecutorNode()));
            .addTask("_task_3", "test", null, new Assignment("_node_2", "_reason"))
import org.opensearch.cluster.ClusterState;
                }
        assertThat(updatedTasks.getTask(taskToUpdate).getState(), equalTo(newState));
                assertThat(task, is(notNullValue()));
            assertThat(task.getId(), equalTo(taskId));
                completed.set(true);
        List<String> nodeList = new ArrayList<>();
     */
            clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE)
            for (DiscoveryNode node : clusterState.nodes()) {
import static org.opensearch.persistent.PersistentTasksExecutor.NO_NODE_FOUND;
            assertThat(task.getExecutorNode(), nullValue());
        );
                if (randomBoolean()) {
 * compatible open source license.
            .clusterManagerNodeId("_node_1")
    private String dumpEvent(ClusterChangedEvent event) {
    }
            TestParams testParams = (TestParams) params;
                .build();
        ClusterState clusterState = initialState();
            if (significant) {
        );
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
            .build();
            .remove(taskId);
            ClusterState before = state.get();
        );
    public void testUpdateTaskStateThrottlingThreshold() {
        assertThat(updateEntry.toString(), equalTo("UPDATE_STATE[" + taskToUpdate + "]"));
    }
    private ClusterState.Builder addRandomTask(
        addTestNodes(nodes, randomIntBetween(1, 10));
                    break;
        if (nodes.getNodes().isEmpty()) {
        assertThat(result.executionResults.get(removeEntry).isSuccess(), is(true));
            }
            Thread thread = new Thread(() -> {
        addTask(tasks, "assign_based_on_non_cluster_state_condition", null);
        }
        assertThat(tasksInProgress.tasks().size(), equalTo(1));
            return NO_NODE_FOUND;
                    logger.info("added random unassignable task");
            for (PersistentTask<?> task : tasksInProgress.tasks()) {
    }
            return NO_NODE_FOUND;
import org.opensearch.ResourceAlreadyExistsException;
        addTask(tasks, "assign_based_on_non_cluster_state_condition", null);
import java.util.Set;
                logger.info("added unassignable task with custom assignment message");
                        shouldSimulateFailure
                    )
            completed1.set(true);
import org.junit.AfterClass;
            current = ClusterState.builder(previous)
        Metadata.Builder metadata,
    public void testUpdateStateWithWrongAllocationId() {
            .add(new DiscoveryNode("_node_1", buildNewFakeTransportAddress(), Version.CURRENT))
    public void testReassignmentRequiredOnMetadataChanges() {
        Assignment assignment,
        );
        Metadata.Builder metadata = Metadata.builder(initialState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
            (params, clusterState) -> "never_assign".equals(((TestParams) params).getTestParam())
        PersistentTasksClusterService.PersistentTaskUpdateExecutor executor = service.new PersistentTaskUpdateExecutor();
        PersistentTasksClusterService.PersistentTaskUpdateEntry entry = PersistentTasksClusterService.PersistentTaskUpdateEntry.complete(
                task.onFailure("testing failure", new RuntimeException("foo"));
            new TestPersistentTasksPlugin.State("test")
        ClusterState clusterState = initialState();
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
        return builder.build();
        ClusterState.Builder csBuilder = ClusterState.builder(clusterState);
            .putCustom(PersistentTasksCustomMetadata.TYPE, tasks)
            addTask(tasks, "assign_one", randomBoolean() ? null : "no_longer_exists");
                Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).removeCustom(PersistentTasksCustomMetadata.TYPE);
    public void setUp() throws Exception {
        List<AtomicBoolean> successes = new ArrayList<>();
                    logger.info("removed task with changing assignment {}", task.getId());
        PersistentTaskState newState = new TestPersistentTasksPlugin.State("updated");
        ClusterManagerTask updateTaskState = ClusterManagerTask.fromKey("update-task-state");
            ClusterState previousState = clusterState;
        // "task wasn't found" branch, NOT the "different allocation id" branch.
import static org.opensearch.persistent.PersistentTasksClusterService.needsReassignment;
        ClusterStateTaskExecutor.ClusterTasksResult<PersistentTasksClusterService.PersistentTaskUpdateEntry> result = executor.execute(
                    break;
                assertThat(task.getAssignment().getExplanation(), equalTo("test assignment"));
            clusterState,
        for (int i = 0; i < numberOfTasks; i++) {
 * specific language governing permissions and limitations
        PersistentTasksCustomMetadata tasksInProgress = newClusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
        // All concurrent updates should complete successfully
                if (randomBoolean()) {
        assertThat(reassign(createService(), clusterState).metadata().custom(PersistentTasksCustomMetadata.TYPE), nullValue());
        assertThat(createdTask.get().getAssignment().getExecutorNode(), equalTo("_node_1"));
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
            Arrays.asList(failEntry, successEntry)
            .clusterManagerNodeId("_node_1");
        AtomicBoolean completed2 = new AtomicBoolean(false);
        service.completePersistentTask(
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder(
    }
        );
            .localNodeId("_node_1")
        Metadata.Builder metadata = Metadata.builder(clusterState.metadata()).putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build());
        if (tasks != null) {
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
    }
        metadata.put(indexMetadata, false);
        int numberOfTasks = randomIntBetween(0, 40);
            assertThat(task.getAssignment().getExplanation(), equalTo("non-cluster state condition prevents assignment"));
            1L
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_2", "test"));
                    break;
    @After
        final PersistentTasksClusterService service = createService((params, clusterState) -> randomNodeAssignment(clusterState.nodes()));
        ClusterState clusterState = initialState();
        }, e -> fail()));
        }).when(recheckTestClusterService).submitStateUpdateTask(anyString(), any(ClusterStateUpdateTask.class));
        assertThat(createdTask.get().getTaskName(), equalTo(TestPersistentTasksExecutor.NAME));
        PersistentTasksClusterService service = createService((params, currentState) -> new Assignment("_node_1", "test"));
        );
        clusterState = builder.metadata(metadata).nodes(nodes).build();
        );
        logger.info("removed all unassigned tasks and changed routing table");
     */
        ClusterState previous = ClusterState.builder(new ClusterName("_name")).nodes(nodes).metadata(metadata).build();
        service.completePersistentTask(taskId1, tasks.getLastAllocationId() - 1, null, ActionListener.wrap(task -> {
        );
        service.unassignPersistentTask(unassignedId, tasks.getLastAllocationId(), "unassignment test", ActionListener.wrap(task -> {
            .localNodeId("_node_1")
        }
                        logger.info(clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE).toString());
    /**
        nonClusterStateCondition = false;
                    && "change me".equals(task.getAssignment().getExplanation())) {
        String taskId = addTask(tasks, "assign_me", "_node_1");
                return builder.build();
        );
            "unassignment test"
            + " tasks: "
            // remove a node that doesn't have any tasks assigned to it and it's not the cluster-manager node
    private PersistentTasksCustomMetadata removeTasksWithChangingAssignment(PersistentTasksCustomMetadata tasks) {
    }
        }
                for (PersistentTask<?> task : tasks.tasks()) {
    }
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder()
        PersistentTasksCustomMetadata.Builder tasksBuilder = PersistentTasksCustomMetadata.builder(tasks);
            }
     * verifying the listener callback receives the unassigned task.
        doAnswer(invocationOnMock -> state.get()).when(recheckTestClusterService).state();
    }
        );
     * This validates the core value proposition of the batching change.
        assertThat(updatedTasks.getTask(taskToComplete), is(nullValue()));
    }
    }
import java.util.concurrent.atomic.AtomicReference;
        clusterState = csBuilder.metadata(metadata).nodes(nodes).build();
                assertThat(task.isAssigned(), equalTo(false));
    public void testReassignmentRequired() {
        ClusterState current = ClusterState.builder(new ClusterName("_name"))
                Metadata.Builder metadata = Metadata.builder(clusterState.metadata())
        when(recheckTestClusterService.getClusterSettings()).thenReturn(clusterService.getClusterSettings());
        String taskId = addTask(tasks, "assign_me", "_node_1");
        // UNASSIGN: task should exist but be unassigned
        }
        PersistentTasksCustomMetadata currentTasks = PersistentTasksCustomMetadata.builder()
