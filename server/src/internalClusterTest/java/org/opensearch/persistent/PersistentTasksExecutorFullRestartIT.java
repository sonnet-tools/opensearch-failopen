        assertThat(tasksInProgress.tasks().size(), equalTo(numberOfTasks));  
import org.opensearch.persistent.TestPersistentTasksPlugin.TestPersistentTasksExecutor;
        // Make sure that at least one of the tasks is running
            new TestPersistentTasksPlugin.TestTasksRequestBuilder(client()).setOperation("finish").get().getTasks().size(),
            .getMetadata()
import static org.hamcrest.Matchers.equalTo;  
 * license agreements. See the NOTICE file distributed with
        ensureYellow();
import java.util.Collection;  
        assertBusy(() -> {  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
/*
/*
            assertThat(
        PersistentTasksCustomMetadata tasksInProgress = internalCluster().clusterService()
        for (int i = 0; i < numberOfTasks; i++) {  
    }  
        for (int i = 0; i < numberOfTasks; i++) {  
}  
import org.opensearch.action.support.PlainActionFuture;  
        tasksInProgress = internalCluster().clusterService().state().getMetadata().custom(PersistentTasksCustomMetadata.TYPE);  
                equalTo(numberOfTasks)
            PersistentTask<?> task = tasksInProgress.getTask(taskIds[i]);
 * Licensed to Elasticsearch under one or more contributor  
            futures.add(future);
            equalTo(numberOfTasks)  
        String[] taskIds = new String[numberOfTasks];  
            .state()  
import java.util.Collections;
        // Complete the running task and make sure it finishes properly  
 * Modifications Copyright OpenSearch Contributors. See  
        }, 20, TimeUnit.SECONDS);  
import org.opensearch.persistent.TestPersistentTasksPlugin.TestParams;  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
        return true;  
            assertNotNull(task);
            assertThat(
 * this file be licensed under the Apache-2.0 license or a
        return Collections.singletonList(TestPersistentTasksPlugin.class);
    }
    public void testFullClusterRestart() throws Exception {  
        for (int i = 0; i < numberOfTasks; i++) {
import java.util.ArrayList;
import org.opensearch.plugins.Plugin;
                    .custom(PersistentTasksCustomMetadata.TYPE)).tasks(),  
 *
import java.util.List;
        assertThat(
        });  
 * under the License.  
                empty()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            PlainActionFuture<PersistentTask<TestParams>> future = new PlainActionFuture<>();
 * SPDX-License-Identifier: Apache-2.0
 *
import java.util.concurrent.TimeUnit;  
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.greaterThan;
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;
            assertThat(futures.get(i).get().getId(), equalTo(taskIds[i]));
            taskIds[i] = UUIDs.base64UUID();  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, minNumDataNodes = 1)  
            );
            // Wait for the task to start
        // Restart cluster
 * the Apache License, Version 2.0 (the "License"); you may
            );
            assertThat(
                    .getMetadata()
        assertBusy(() -> {  
        assertBusy(() -> {  
import org.opensearch.common.UUIDs;
            // Wait for all tasks to start
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
        }  
        );
        }  
    protected boolean ignoreExternalCluster() {
 */
        List<PlainActionFuture<PersistentTask<TestParams>>> futures = new ArrayList<>(numberOfTasks);
 */
        internalCluster().fullRestart();  
import static org.hamcrest.Matchers.empty;
 * specific language governing permissions and limitations
            service.sendStartRequest(taskIds[i], TestPersistentTasksExecutor.NAME, new TestParams("Blah"), future);
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks().size(),  
        int numberOfTasks = randomIntBetween(1, 10);
            // Make sure the task is removed from the cluster state
        }
    @Override  
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchIntegTestCase;  
 * The OpenSearch Contributors require contributions made to  
                greaterThan(0)
                    .state()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // Check that cluster state is correct
                client().admin().cluster().prepareListTasks().setActions(TestPersistentTasksExecutor.NAME + "[c]").get().getTasks().size(),  
 */  
package org.opensearch.persistent;
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
public class PersistentTasksExecutorFullRestartIT extends OpenSearchIntegTestCase {
                ((PersistentTasksCustomMetadata) internalCluster().clusterService()  
            );
 * GitHub history for details.
            .custom(PersistentTasksCustomMetadata.TYPE);
        assertThat(tasksInProgress.tasks().size(), equalTo(numberOfTasks));
        PersistentTasksService service = internalCluster().getInstance(PersistentTasksService.class);
    }
 *  
        logger.info("Complete all tasks");
        logger.info("Waiting for {} tasks to start", numberOfTasks);
        });  
