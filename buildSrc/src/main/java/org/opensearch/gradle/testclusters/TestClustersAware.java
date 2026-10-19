 * Modifications Copyright OpenSearch Contributors. See  
package org.opensearch.gradle.testclusters;
        }  
 * under the License.  
 */  
 * license agreements. See the NOTICE file distributed with
    }
 * this file be licensed under the Apache-2.0 license or a
                .stream()
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
import org.gradle.api.Task;
    Collection<OpenSearchCluster> getClusters();
        if (cluster.getPath().equals(project.getPath()) == false) {
 */
            (Callable<List<Configuration>>) () -> cluster.getNodes()  
 * The OpenSearch Contributors require contributions made to  
    @Deprecated(forRemoval = true)
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Nested
                .collect(Collectors.toList())
    }
    default void useCluster(Project project, OpenSearchCluster cluster) {  
import java.util.List;
 *    http://www.apache.org/licenses/LICENSE-2.0
                .flatMap(node -> node.getDistributions().stream())
}
 * SPDX-License-Identifier: Apache-2.0
                .collect(Collectors.toList())
import org.gradle.api.Project;
 *
import java.util.stream.Collectors;  
 */
                .flatMap(node -> node.getPluginAndModuleConfigurations().stream())  
 * KIND, either express or implied.  See the License for the
                .map(OpenSearchDistribution::getExtracted)  
 *
                .stream()
 * Unless required by applicable law or agreed to in writing,
        // nodes while the build script may still be configuring how many there are and how they are numbered.
        dependsOn(
import org.gradle.api.artifacts.Configuration;  
 * Licensed to Elasticsearch under one or more contributor  
import org.gradle.api.tasks.Nested;
 * not use this file except in compliance with the License.
import org.opensearch.gradle.OpenSearchDistribution;  
            (Callable<List<Configuration>>) () -> cluster.getNodes()
        useCluster(getProject(), cluster);  
 * specific language governing permissions and limitations
public interface TestClustersAware extends Task {
import java.util.Collection;  
/*  
        getClusters().add(cluster);  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
        );
        dependsOn(  
        // cluster. Resolved when the task graph is built rather than now, so that using a cluster does not create its  
    default void useCluster(OpenSearchCluster cluster) {
/*
 *  
    default void beforeStart() {}  
 * software distributed under the License is distributed on an
            throw new TestClustersException("Task " + getPath() + " can't use test cluster from" + " another project " + cluster);
import java.util.concurrent.Callable;
        // Add configured distributions, plugins and modules as task dependencies so they are built before starting the
 * GitHub history for details.
        );
