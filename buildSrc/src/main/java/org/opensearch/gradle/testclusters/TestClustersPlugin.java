                    // we only start the cluster before the actions, so we'll not start it if the task is up-to-date  
    private void createListClustersTask(Project project, NamedDomainObjectContainer<OpenSearchCluster> container) {
        ReaperService reaper = project.getRootProject().getExtensions().getByType(ReaperService.class);
import org.gradle.api.Plugin;  
import org.gradle.api.file.FileSystemOperations;  
        project.getRootProject().getPluginManager().apply(ReaperPlugin.class);
 * license agreements. See the NOTICE file distributed with
import org.gradle.api.logging.Logging;  
 * compatible open source license.
package org.opensearch.gradle.testclusters;
    public static final String EXTENSION_NAME = "testClusters";  
 * software distributed under the License is distributed on an
    @Inject
    public static final String THROTTLE_SERVICE_NAME = "testClustersThrottle";
        // register cluster registry as a global build service
            configureClaimClustersHook(project.getGradle(), registry);
 * SPDX-License-Identifier: Apache-2.0
                    .forEach(registry::claimCluster);
            );  
                getArchiveOperations()
import org.gradle.api.execution.TaskExecutionListener;
                @Override
                name,
        throw new UnsupportedOperationException();  
    }  
 */
/*
            );  
            .getSharedServices()
            // terminate the cluster right away and free up resources.  
 * Unless required by applicable law or agreed to in writing,
                    .map(task -> (TestClustersAware) task)
            // claims so we'll know when it's safe to stop them.  
                REGISTRY_SERVICE_NAME
                        return;
                public void afterExecute(Task task, TaskState state) {
            OpenSearchCluster.class,  
            project.getPlugins().apply(DistributionDownloadPlugin.class);  
        private static void configureStopClustersHook(Gradle gradle, TestClustersRegistry registry) {
import org.opensearch.gradle.info.GlobalBuildInfoPlugin;
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
                    .flatMap(task -> task.getClusters().stream())  
 * Licensed to Elasticsearch under one or more contributor  
 *
    private static final String REGISTRY_SERVICE_NAME = "testClustersRegistry";
import org.gradle.api.NamedDomainObjectContainer;
                    }
            configureStartClustersHook(project.getGradle(), registry);
 *    http://www.apache.org/licenses/LICENSE-2.0
        private static void configureStartClustersHook(Gradle gradle, TestClustersRegistry registry) {
 * KIND, either express or implied.  See the License for the
        if (project.getState().getExecuted()) {
                @Override
                    if (task instanceof TestClustersAware == false) {  
 * You may obtain a copy of the License at  
        // Create an extensions that allows describing clusters
            container.all(cluster -> cluster.realize("its creation after " + project.getPath() + " was evaluated"));  
        project.getRootProject().getPluginManager().apply(TestClustersHookPlugin.class);  
                    // and caused the cluster to start.
    private static final Logger logger = Logging.getLogger(TestClustersPlugin.class);
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // anything plans a task with them. Anything that reads a cluster's nodes earlier creates them then.
            task.setGroup("OpenSearch cluster formation");
            task.setDescription("Lists all OpenSearch clusters configured for this project");  
        project.getGradle()  
        }
            // that are defined in the build script and the ones that will actually be used in this invocation of gradle
import org.opensearch.gradle.DistributionDownloadPlugin;  
            name -> new OpenSearchCluster(
 * not use this file except in compliance with the License.
        } else {
import static org.opensearch.gradle.util.GradleUtils.noop;
                project,  
import javax.inject.Inject;
                THROTTLE_SERVICE_NAME,  
import org.opensearch.gradle.JdkDownloadPlugin;
    }  
            gradle.addListener(new TaskActionListener() {  
            });
    }  
        createListClustersTask(project, container);  
        });
 * the Apache License, Version 2.0 (the "License"); you may
                    awareTask.getClusters().forEach(registry::maybeStartCluster);  
/*  
        }  
    private static final String LIST_TASK_NAME = "listTestClusters";  
    private NamedDomainObjectContainer<OpenSearchCluster> createTestClustersContainerExtension(Project project, ReaperService reaper) {  
        NamedDomainObjectContainer<OpenSearchCluster> container = createTestClustersContainerExtension(project, reaper);
                        return;
import java.io.File;  
            // When we know what tasks will run, we claim the clusters of those task to differentiate between clusters  
        }
        project.getGradle().getSharedServices().registerIfAbsent(REGISTRY_SERVICE_NAME, TestClustersRegistry.class, noop());  
                    .filter(task -> task instanceof TestClustersAware)
        // provide a task to be able to list defined clusters.
        return container;
        // register throttle so we only run at most max-workers/2 nodes concurrently
        }
        project.getPluginManager().apply(JdkDownloadPlugin.class);
            // After each task we determine if there are clusters that are no longer needed.  
import org.opensearch.gradle.ReaperService;  
import org.gradle.api.file.ArchiveOperations;
                taskExecutionGraph.getAllTasks()
                @Override  
        // Create every cluster's nodes once the build script has finished configuring them, so that they exist before  
 *  
        // register cluster hooks
import org.gradle.api.invocation.Gradle;
 * under the License.  
}
        } else {
            )
            configureStopClustersHook(project.getGradle(), registry);
        @Override  
            );  
        NamedDomainObjectContainer<OpenSearchCluster> container = project.container(
import org.opensearch.gradle.util.GradleUtils;
                throw new IllegalStateException(this.getClass().getName() + " can only be applied to the root project.");  
                project.getGradle().getSharedServices(),
        project.getExtensions().add(EXTENSION_NAME, container);
                new File(project.getBuildDir(), "testclusters"),
    }
            gradle.addListener(new TaskExecutionListener() {  
                }  
            .registerIfAbsent(
 * Modifications Copyright OpenSearch Contributors. See  
            task.doLast(
 * The OpenSearch Contributors require contributions made to  
        }  
        private static void configureClaimClustersHook(Gradle gradle, TestClustersRegistry registry) {
            // we use this information to determine when the last task that required the cluster executed so that we can
        // Task is never up to date so we can pass an lambda for the task action  
import org.opensearch.gradle.ReaperPlugin;
    protected ArchiveOperations getArchiveOperations() {
        project.getTasks().register(LIST_TASK_NAME, task -> {
import org.gradle.api.Project;
                    .stream()  
    @Inject  
        if (BuildParams.isInternal()) {  
import org.gradle.api.Task;
            });
            // Before each task, we determine if a cluster needs to be started for that task.  
        public void apply(Project project) {
                public void beforeActions(Task task) {
                @Override
 */  
import org.opensearch.gradle.internal.InternalDistributionDownloadPlugin;  
        project.getRootProject().getPluginManager().apply(GlobalBuildInfoPlugin.class);
import org.opensearch.gradle.info.BuildParams;
            });
    @Override
    protected FileSystemOperations getFileSystemOperations() {
                    // always unclaim the cluster, even if _this_ task is up-to-date, as others might not have been  
                public void beforeExecute(Task task) {}  
 * GitHub history for details.
                    ((TestClustersAware) task).getClusters().forEach(cluster -> registry.stopCluster(cluster, state.getFailure() != null));
 *
                    }
 */
                    if (task instanceof TestClustersAware == false) {  
            if (project != project.getRootProject()) {
        throw new UnsupportedOperationException();
        );  
 * this work for additional information regarding copyright
            project.afterEvaluate(p -> container.forEach(cluster -> cluster.realize("the end of " + p.getPath() + "'s configuration")));
                public void afterActions(Task task) {}
            gradle.getTaskGraph().whenReady(taskExecutionGraph -> {
                }
    static class TestClustersHookPlugin implements Plugin<Project> {
                spec -> spec.getMaxParallelUsages().set(Math.max(1, project.getGradle().getStartParameter().getMaxWorkerCount() / 2))
            // Once we know all the tasks that need to execute, we claim all the clusters that belong to those and count the
            Provider<TestClustersRegistry> registryProvider = GradleUtils.getBuildService(  
import org.gradle.api.execution.TaskActionListener;  
import org.gradle.api.tasks.TaskState;
    public void apply(Project project) {  
                reaper,
                getFileSystemOperations(),  
        }  
                (Task t) -> container.forEach(cluster -> logger.lifecycle("   * {}: {}", cluster.getName(), cluster.getNumberOfNodes()))
    }  
                    TestClustersAware awareTask = (TestClustersAware) task;
    }
                TestClustersThrottle.class,
            project.getPlugins().apply(InternalDistributionDownloadPlugin.class);
import org.gradle.api.logging.Logger;
public class TestClustersPlugin implements Plugin<Project> {
 * this file be licensed under the Apache-2.0 license or a
            TestClustersRegistry registry = registryProvider.get();
        // enable the DSL to describe clusters  
import org.gradle.api.provider.Provider;
                    awareTask.beforeStart();
            }
