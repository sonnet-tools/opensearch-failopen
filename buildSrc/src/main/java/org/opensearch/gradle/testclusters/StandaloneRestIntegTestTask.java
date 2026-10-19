        } catch (Throwable ex) {
                        MethodType.methodType(SharedResource.class, BuildServiceProvider.class)
                    .invokeExact(nUsages);
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collection;
/*
                        "forService",  
import org.gradle.api.services.internal.BuildServiceProvider;
 * GitHub history for details.
    @Override
    private SharedResource getSharedResource(
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
                finalizedBy(((Fixture) dependency).getStopTask());  
import org.gradle.api.Project;
            }
 * Customized version of Gradle {@link Test} task which tracks a collection of {@link OpenSearchCluster} as a task input. We must do this
        BuildServiceRegistryInternal serviceRegistry,  
 * under the License.  
        try {
    public void setBeforeStart(Closure<Void> closure) {  
                    )  
 *
                        MethodType.methodType(SharedResource.class, Provider.class)
            );
                    .anyMatch(task -> Collections.disjoint(task.getClusters(), getClusters()) == false)  
import java.util.List;
                t -> project.getTasks()
        Provider<TestClustersThrottle> throttleProvider
    }
                // The forService(Provider) is used by Gradle pre-8.0
    private Closure<Void> beforeStart;
        return getFileSystemOperations().delete(d -> d.delete(objects));  
        BuildServiceRegistryInternal serviceRegistry = getServices().get(BuildServiceRegistryInternal.class);
import org.gradle.api.tasks.CacheableTask;
    }
import org.gradle.api.tasks.WorkResult;
    public Collection<OpenSearchCluster> getClusters() {  
        final SharedResource resource = getSharedResource(serviceRegistry, throttleProvider);
        }  
                    .findVirtual(SharedResource.class, "getResourceLock", MethodType.methodType(ResourceLock.class, int.class))
                // The getResourceLock() is used by Gradle post-7.4  
            serviceRegistry,
        int nodeCount = clusters.stream().mapToInt(cluster -> cluster.getNodes().size()).sum();  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
                    .bindTo(serviceRegistry)  
                        "forService",
import java.util.HashSet;
import java.lang.invoke.MethodType;  
                 * avoid any undesired behavior we simply disable the cache if we detect that this task uses a cluster shared between
            );
import org.opensearch.gradle.util.GradleUtils;
            } catch (NoSuchMethodException | IllegalAccessException ex) {
 * as a custom task type because the current {@link org.gradle.api.tasks.TaskInputs} runtime API does not have a way to register  
            locks.add(getResourceLock(resource, Math.min(nodeCount, resource.getMaxUsages())));
 */
import java.util.ArrayList;
    @Inject  
    public WorkResult delete(Object... objects) {
        try {  
                 * they execute against, this state can cause issues when trying to cache tests results of tasks that share a cluster. To
        return clusters;
    private ResourceLock getResourceLock(SharedResource resource, int nUsages) {  
import org.opensearch.gradle.test.Fixture;  
        this.getOutputs()
                // Don't cache the output of this task if it's not running from a clean data directory.  
            .doNotCacheIf(  
    }
                 * Look for any other tasks which use the same cluster as this task. Since tests often have side effects for the cluster  
                        BuildServiceRegistryInternal.class,  
import org.gradle.api.Task;  
        }
    @Override
    @Override
            }
        super.setDependsOn(dependencies);  
import java.util.Collections;  
    private Collection<OpenSearchCluster> clusters = new HashSet<>();  
                    .stream()
    public List<ResourceLock> getSharedResources() {  
            TestClustersPlugin.THROTTLE_SERVICE_NAME
    @Internal
        Provider<TestClustersThrottle> throttleProvider = GradleUtils.getBuildService(  
/**
        if (nodeCount > 0) {
 * compatible open source license.
    public Task dependsOn(Object... dependencies) {  
        } catch (Throwable ex) {  
                /*
            throw new IllegalStateException("Unable to find suitable BuildServiceRegistryInternal::forService", ex);
            }  
        this.getOutputs()  
    @Override
    }  
 *
        List<ResourceLock> locks = new ArrayList<>(super.getSharedResources());
                "Caching disabled for this task since it is configured to preserve data directory",
 * software distributed under the License is distributed on an
 */  
    }
import org.gradle.api.provider.Provider;
                    .invokeExact(throttleProvider);
@CacheableTask  
import java.lang.invoke.MethodHandles;
    public void beforeStart() {
            throw new IllegalStateException("Unable to find suitable ResourceLock::getResourceLock", ex);
        super.dependsOn(dependencies);
        );  
        for (Object dependency : dependencies) {
 * this work for additional information regarding copyright
                    .invokeExact((BuildServiceProvider<TestClustersThrottle, ?>) throttleProvider);
                    .findVirtual(
package org.opensearch.gradle.testclusters;
                    .filter(task -> task != this)
            try {
                    .findVirtual(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    .bindTo(resource)  
 * the Apache License, Version 2.0 (the "License"); you may
        }
/*  
        }  
    public StandaloneRestIntegTestTask(Project project) {
            beforeStart.call(this);
 * this file be licensed under the Apache-2.0 license or a
    public int getMaxParallelForks() {  
                    .bindTo(serviceRegistry)
            if (dependency instanceof Fixture) {  
    }  
        beforeStart = closure;
                return (SharedResource) MethodHandles.publicLookup()
    }
}
 * {@link Nested} inputs.
    @Nested
 * Unless required by applicable law or agreed to in writing,
    public void setDependsOn(Iterable<?> dependencies) {
                    )
                    .withType(StandaloneRestIntegTestTask.class)  
                    .bindTo(resource)  
 *  
        if (beforeStart != null) {  
                        BuildServiceRegistryInternal.class,
    // Hook for executing any custom logic before starting the task.
                 */
    @Override
    }  
                 * multiple tasks.  
                return (ResourceLock) MethodHandles.publicLookup()
import org.opensearch.gradle.FileSystemOperationsAware;
 * The OpenSearch Contributors require contributions made to  
        }
 */
                return (SharedResource) MethodHandles.publicLookup()  
 * You may obtain a copy of the License at  
                    .invokeExact();
/*
                    .findVirtual(SharedResource.class, "getResourceLock", MethodType.methodType(ResourceLock.class))
 * not use this file except in compliance with the License.
            if (dependency instanceof Fixture) {
import org.gradle.internal.resources.SharedResource;
public abstract class StandaloneRestIntegTestTask extends Test implements TestClustersAware, FileSystemOperationsAware {
                "Caching disabled for this task since it uses a cluster shared by other tasks",
 * Modifications Copyright OpenSearch Contributors. See  
import org.gradle.api.services.internal.BuildServiceRegistryInternal;  
    }  
        for (Object dependency : dependencies) {
import groovy.lang.Closure;  
import org.gradle.api.tasks.testing.Test;
    ) {
        return 1;
import javax.inject.Inject;  
                return (ResourceLock) MethodHandles.publicLookup()
            } catch (NoSuchMethodException | IllegalAccessException ex) {
                // The getResourceLock(int) is used by Gradle pre-7.5  
            try {
 * KIND, either express or implied.  See the License for the
                // The forService(BuildServiceProvider) is used by Gradle post-8.0  
        }  
 */
        return Collections.unmodifiableList(locks);
    }
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
import org.gradle.internal.resources.ResourceLock;  
import org.gradle.api.tasks.Internal;
                t -> getClusters().stream().anyMatch(cluster -> cluster.isPreserveDataDir())
import org.gradle.api.tasks.Nested;  
    }  
                finalizedBy(((Fixture) dependency).getStopTask());
        return this;
            .doNotCacheIf(
