        assertBusy(() -> {
    }
            tasks = internalCluster().clusterService().state().getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
        assertThat(Allocation.fromString(value), equalTo(expected));
 */
                    .setActions(TestPersistentTasksExecutor.NAME + "[c]")
/*
import static org.hamcrest.Matchers.equalTo;
                    .prepareListTasks()
    private void disablePersistentTasksAssignment() {
            assertThat(listTasks.getTasks().size(), equalTo(numberOfTasks));
    @Override
import static org.opensearch.persistent.decider.EnableAssignmentDecider.Allocation;
            assertEnableAssignmentSetting(Allocation.NONE);
                    .cluster()
    /**
    @Override
    }
 */
            assertEquals(
            );
        logger.trace("creating {} persistent tasks", numberOfTasks);
import org.opensearch.persistent.PersistentTasksService;
import java.util.concurrent.CountDownLatch;
    private void resetPersistentTasksAssignment() {
}
            logger.trace("enable persistent tasks assignment");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
        }
import java.util.Collection;
            ListTasksResponse listTasks = client().admin()
            } else {
    }
import org.opensearch.persistent.PersistentTasksCustomMetadata;
/*
            internalCluster().fullRestart();
 * the Apache License, Version 2.0 (the "License"); you may
        PersistentTasksCustomMetadata tasks = clusterService.state().getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
import org.opensearch.common.settings.Settings;
     * Test that the {@link EnableAssignmentDecider#CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING} setting correctly
 * ownership. Elasticsearch licenses this file to you under
        for (int i = 0; i < numberOfTasks; i++) {
        ClusterService clusterService = internalCluster().clusterService(internalCluster().getClusterManagerName());
 * GitHub history for details.
 */
            resetPersistentTasksAssignment();
        } finally {
                enablePersistentTasksAssignment();
            logger.trace("disable persistent tasks assignment");
        }
            }
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings));
        Settings settings = clusterStateResponse.getState().getMetadata().settings();
                    .filter(t -> TestPersistentTasksExecutor.NAME.equals(t.getTaskName()))
 *
        return true;
    }
        Settings.Builder settings = Settings.builder().put(CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.ALL);
                .get();
                .prepareListTasks()
import org.opensearch.core.action.ActionListener;
        assertEquals(numberOfTasks, tasks.tasks().stream().filter(t -> TestPersistentTasksExecutor.NAME.equals(t.getTaskName())).count());
package org.opensearch.persistent.decider;
                    .filter(t -> t.isAssigned() == false)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * software distributed under the License is distributed on an
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings));
/*
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
                .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        latch.await();
        Settings.Builder settings = Settings.builder().put(CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.NONE);
 * under the License.
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchIntegTestCase;
 * not use this file except in compliance with the License.
        return singletonList(TestPersistentTasksPlugin.class);
                tasks.tasks()
import org.opensearch.plugins.Plugin;
        logger.trace("waiting for the tasks to be running");
import org.opensearch.persistent.TestPersistentTasksPlugin.TestParams;
            ensureYellow();
        final CountDownLatch latch = new CountDownLatch(numberOfTasks);
 * The OpenSearch Contributors require contributions made to
    public void testEnableAssignmentAfterRestart() throws Exception {
    private void assertEnableAssignmentSetting(final Allocation expected) {
import org.opensearch.persistent.TestPersistentTasksPlugin;
        try {
            if (randomBoolean()) {
                    .count()
            service.sendStartRequest(
                ListTasksResponse listTasks = client().admin()
                    .get();
            PersistentTasksService service = internalCluster().getInstance(PersistentTasksService.class);
    private void enablePersistentTasksAssignment() {
                .prepareListTasks()
import static org.opensearch.persistent.decider.EnableAssignmentDecider.CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING;
            });
        String value = settings.get(CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING.getKey());
            assertThat(runningTasks.getTasks().size(), equalTo(0));
 * license agreements. See the NOTICE file distributed with
     */
                numberOfTasks,
 *
                new TestParams(randomAlphaOfLength(10)),
            logger.trace("persistent tasks are not assigned");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Settings.Builder settings = Settings.builder().putNull(CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING.getKey());
     * prevents persistent tasks to be assigned after a cluster restart.
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 1)
    protected boolean ignoreExternalCluster() {
 *
public class EnableAssignmentDeciderIT extends OpenSearchIntegTestCase {
 * this work for additional information regarding copyright
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings));
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                .cluster()
            );
 *    http://www.apache.org/licenses/LICENSE-2.0
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().clear().setMetadata(true).get();
 * specific language governing permissions and limitations
        final int numberOfTasks = randomIntBetween(1, 10);
import org.opensearch.cluster.service.ClusterService;
            ListTasksResponse runningTasks = client().admin()
                .get();
    }
                resetPersistentTasksAssignment();
 * compatible open source license.
import static java.util.Collections.singletonList;
 * You may obtain a copy of the License at
                .cluster()
import org.opensearch.persistent.TestPersistentTasksPlugin.TestPersistentTasksExecutor;
                .setActions(TestPersistentTasksExecutor.NAME + "[c]")
            assertBusy(() -> {
    }
 * Licensed to Elasticsearch under one or more contributor
                "task_" + i,
                ActionListener.wrap(latch::countDown)
                TestPersistentTasksExecutor.NAME,
            logger.trace("restart the cluster");
            logger.trace("persistent tasks assignment is still disabled");
                    .stream()
 * this file be licensed under the Apache-2.0 license or a
        });
 * Unless required by applicable law or agreed to in writing,
            disablePersistentTasksAssignment();
                assertThat(listTasks.getTasks().size(), equalTo(numberOfTasks));
    }
