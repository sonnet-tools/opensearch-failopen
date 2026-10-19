        latch.await();  
        } finally {
            service.sendStartRequest(
            logger.trace("persistent tasks are not assigned");  
 * You may obtain a copy of the License at  
                numberOfTasks,  
        return singletonList(TestPersistentTasksPlugin.class);
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 1)
import static org.opensearch.persistent.decider.EnableAssignmentDecider.Allocation;  
 * not use this file except in compliance with the License.
                    .count()
            assertThat(runningTasks.getTasks().size(), equalTo(0));
                .prepareListTasks()
 * this file be licensed under the Apache-2.0 license or a
            } else {  
            assertEnableAssignmentSetting(Allocation.NONE);
        Settings settings = clusterStateResponse.getState().getMetadata().settings();
    private void resetPersistentTasksAssignment() {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * SPDX-License-Identifier: Apache-2.0
    public void testEnableAssignmentAfterRestart() throws Exception {
import org.opensearch.test.OpenSearchIntegTestCase;  
        logger.trace("creating {} persistent tasks", numberOfTasks);  
package org.opensearch.persistent.decider;
                .prepareListTasks()
                .cluster()  
/*  
import org.opensearch.persistent.TestPersistentTasksPlugin;
        logger.trace("waiting for the tasks to be running");  
            internalCluster().fullRestart();  
    /**  
    }
                assertThat(listTasks.getTasks().size(), equalTo(numberOfTasks));
        for (int i = 0; i < numberOfTasks; i++) {  
 * under the License.  
        }  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
            );  
     */  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
 *  
public class EnableAssignmentDeciderIT extends OpenSearchIntegTestCase {  
 * The OpenSearch Contributors require contributions made to  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        assertBusy(() -> {
 *
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings));
    }
                .get();  
            logger.trace("disable persistent tasks assignment");
        Settings.Builder settings = Settings.builder().put(CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.NONE);  
        Settings.Builder settings = Settings.builder().put(CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.ALL);
                    .cluster()  
 *
        try {
                    .setActions(TestPersistentTasksExecutor.NAME + "[c]")
 */  
/*  
                ActionListener.wrap(latch::countDown)  
            ListTasksResponse runningTasks = client().admin()
                .setActions(TestPersistentTasksExecutor.NAME + "[c]")
                    .stream()
                    .filter(t -> t.isAssigned() == false)
                .cluster()  
import org.opensearch.cluster.service.ClusterService;  
import static java.util.Collections.singletonList;
        });
                    .get();  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
                .get();  
    }  
            tasks = internalCluster().clusterService().state().getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
    }
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().clear().setMetadata(true).get();
 */
        }
 * Modifications Copyright OpenSearch Contributors. See
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.persistent.TestPersistentTasksPlugin.TestPersistentTasksExecutor;
            disablePersistentTasksAssignment();  
                .setActions(TestPersistentTasksExecutor.NAME + "[c]")
        final CountDownLatch latch = new CountDownLatch(numberOfTasks);
            ensureYellow();
            ListTasksResponse listTasks = client().admin()
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
            });
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .filter(t -> TestPersistentTasksExecutor.NAME.equals(t.getTaskName()))  
import org.opensearch.core.action.ActionListener;
 * compatible open source license.
            PersistentTasksService service = internalCluster().getInstance(PersistentTasksService.class);
            resetPersistentTasksAssignment();
                resetPersistentTasksAssignment();
                tasks.tasks()
            logger.trace("enable persistent tasks assignment");  
    private void assertEnableAssignmentSetting(final Allocation expected) {  
 * software distributed under the License is distributed on an
            }
     * prevents persistent tasks to be assigned after a cluster restart.
        assertThat(Allocation.fromString(value), equalTo(expected));
 * Unless required by applicable law or agreed to in writing,
            logger.trace("persistent tasks assignment is still disabled");  
import org.opensearch.plugins.Plugin;
 * license agreements. See the NOTICE file distributed with
    private void disablePersistentTasksAssignment() {
                TestPersistentTasksExecutor.NAME,
/*
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings));  
            assertBusy(() -> {
    }  
                new TestParams(randomAlphaOfLength(10)),
 */  
            );
    @Override
    }
        return true;  
 * GitHub history for details.
    @Override
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.persistent.PersistentTasksCustomMetadata;  
import java.util.Collection;
            assertThat(listTasks.getTasks().size(), equalTo(numberOfTasks));
            if (randomBoolean()) {
        Settings.Builder settings = Settings.builder().putNull(CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING.getKey());
        assertEquals(numberOfTasks, tasks.tasks().stream().filter(t -> TestPersistentTasksExecutor.NAME.equals(t.getTaskName())).count());
                    .prepareListTasks()
import org.opensearch.persistent.PersistentTasksService;
            assertEquals(
            logger.trace("restart the cluster");
     * Test that the {@link EnableAssignmentDecider#CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING} setting correctly
import static org.opensearch.persistent.decider.EnableAssignmentDecider.CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING;
import org.opensearch.persistent.TestPersistentTasksPlugin.TestParams;  
                ListTasksResponse listTasks = client().admin()
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings));
        PersistentTasksCustomMetadata tasks = clusterService.state().getMetadata().custom(PersistentTasksCustomMetadata.TYPE);  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        ClusterService clusterService = internalCluster().clusterService(internalCluster().getClusterManagerName());
                "task_" + i,  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.Settings;
    private void enablePersistentTasksAssignment() {
import java.util.concurrent.CountDownLatch;  
    protected boolean ignoreExternalCluster() {
        String value = settings.get(CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING.getKey());
                enablePersistentTasksAssignment();
        final int numberOfTasks = randomIntBetween(1, 10);
