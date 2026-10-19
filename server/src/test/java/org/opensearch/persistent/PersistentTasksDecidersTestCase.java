        for (int i = 0; i < nbTasks; i++) {
        PersistentTasksCustomMetadata.Builder tasks = PersistentTasksCustomMetadata.builder();  
    protected static ClusterState createClusterStateWithTasks(final int nbNodes, final int nbTasks) {  
 */  
 * software distributed under the License is distributed on an
        final long nbTasks,
import org.opensearch.cluster.metadata.Metadata;  
    }
    }  
            clusterService.getSettings(),
        clusterSettings.applySettings(updated.build());  
/*
    /** Needed by {@link PersistentTasksClusterService} **/
import org.opensearch.cluster.service.ClusterService;  
import java.util.function.Predicate;
                        logger.debug("Executing task {}", task);
        }  
 */
    }  
 * SPDX-License-Identifier: Apache-2.0
    private static ThreadPool threadPool;
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
        clusterService = createClusterService(threadPool);  
        assertPersistentTasks(nbTasks, clusterState, PersistentTasksCustomMetadata.PersistentTask::isAssigned);  
        assertPersistentTasks(nbTasks, clusterState, task -> task.isAssigned() == false);
 * not use this file except in compliance with the License.
    protected static void assertNbUnassignedTasks(final long nbTasks, final ClusterState clusterState) {
import org.opensearch.common.settings.ClusterSettings;
}  
import org.opensearch.common.settings.Settings;
        super.setUp();
        clusterService.close();
        super.tearDown();  
        terminate(threadPool);
    private ClusterService clusterService;  
        );
 * license agreements. See the NOTICE file distributed with
        assertNotNull("Persistent tasks must be not null", tasks);  
    @AfterClass
        final ClusterState clusterState,
    }
    public void tearDown() throws Exception {
 * under the License.  
 * this work for additional information regarding copyright
import org.opensearch.cluster.node.DiscoveryNode;
 * specific language governing permissions and limitations
import org.opensearch.cluster.ClusterState;
    protected void updateSettings(final Settings settings) {
    /** Asserts that the given cluster state contains nbTasks tasks that are NOT assigned **/  
 * The OpenSearch Contributors require contributions made to  
    }  
 * GitHub history for details.
    protected static void assertPersistentTasks(  
        return persistentTasksClusterService.reassignTasks(clusterState);
public abstract class PersistentTasksDecidersTestCase extends OpenSearchTestCase {
        threadPool = new TestThreadPool(getTestClass().getSimpleName());  
import org.opensearch.threadpool.TestThreadPool;
    public static void setUpThreadPool() {
import org.junit.AfterClass;
    private PersistentTasksClusterService persistentTasksClusterService;
    protected ClusterState reassign(final ClusterState clusterState) {
    /** Asserts that the given cluster state contains nbTasks tasks that are assigned **/
/*
import org.opensearch.cluster.node.DiscoveryNodes;
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.threadpool.ThreadPool;
        PersistentTasksExecutorRegistry registry = new PersistentTasksExecutorRegistry(emptyList()) {
                return new PersistentTasksExecutor<Params>(taskName, null) {
package org.opensearch.persistent;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        };
        final Predicate<PersistentTasksCustomMetadata.PersistentTask> predicate  
    @After
    @BeforeClass
            tasks.addTask("_task_" + i, "test", null, new PersistentTasksCustomMetadata.Assignment(null, "initialized"));
    ) {
            clusterService,  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        }
    }
        Settings.Builder updated = Settings.builder();
        assertEquals(nbTasks, tasks.tasks().stream().filter(predicate).count());
 *  
import org.opensearch.Version;  
    }
        ClusterSettings clusterSettings = clusterService.getClusterSettings();  
                    @Override
            threadPool
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
        return ClusterState.builder(ClusterName.DEFAULT).nodes(nodes).metadata(metadata).build();
    /** Asserts that the cluster state contains nbTasks tasks that verify the given predicate **/
 *
    @Before  
                };  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
    }
            nodes.add(new DiscoveryNode("_node_" + i, buildNewFakeTransportAddress(), Version.CURRENT));  
        for (int i = 0; i < nbNodes; i++) {
            registry,
    }
    public void setUp() throws Exception {
        Metadata metadata = Metadata.builder().putCustom(PersistentTasksCustomMetadata.TYPE, tasks.build()).build();
    /** Needed by {@link ClusterService} **/  
 *
        persistentTasksClusterService = new PersistentTasksClusterService(  
                    }
 * You may obtain a copy of the License at  
            public <Params extends PersistentTaskParams> PersistentTasksExecutor<Params> getPersistentTaskExecutorSafe(String taskName) {  
import org.opensearch.test.OpenSearchTestCase;  
/*  
    protected static void assertNbAssignedTasks(final long nbTasks, final ClusterState clusterState) {
            @Override
import org.junit.After;  
import static java.util.Collections.emptyList;
                    protected void nodeOperation(AllocatedPersistentTask task, Params params, PersistentTaskState state) {  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
import org.junit.BeforeClass;  
import org.opensearch.cluster.ClusterName;
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder();
    public static void tearDownThreadPool() {  
 * this file be licensed under the Apache-2.0 license or a
import org.junit.Before;
        PersistentTasksCustomMetadata tasks = clusterState.metadata().custom(PersistentTasksCustomMetadata.TYPE);
            }
        clusterSettings.updateDynamicSettings(settings, updated, Settings.builder(), getTestClass().getName());
 */
