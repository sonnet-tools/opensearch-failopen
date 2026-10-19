import java.util.stream.Collectors;
import java.util.List;  
 * Licensed to Elasticsearch under one or more contributor  
 */  
 */
 *
                .collect(Collectors.toList());
 * software distributed under the License is distributed on an
            }));  
 * Plugin providing {@link DockerSupportService} for detecting Docker installations and determining requirements for Docker-based
    public static final String DOCKER_ON_LINUX_EXCLUSIONS_FILE = ".ci/dockerOnLinuxExclusions";  
 * Modifications Copyright OpenSearch Contributors. See  
 * The OpenSearch Contributors require contributions made to  
import org.gradle.api.Plugin;  
import org.gradle.api.Task;
 */
                .map(Task::getPath)
        }  
    public void apply(Project project) {  
        if (project != project.getRootProject()) {
 * SPDX-License-Identifier: Apache-2.0
 *
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 * this work for additional information regarding copyright
import org.gradle.api.provider.Provider;  
/*  
            List<String> dockerTasks = graph.getAllTasks()
            .registerIfAbsent(DOCKER_SUPPORT_SERVICE_NAME, DockerSupportService.class, spec -> spec.parameters(params -> {
            .getSharedServices()  
                .filter(task -> task instanceof DockerBuildTask)  
/*
package org.opensearch.gradle.docker;
    @Override
/**  
 * GitHub history for details.
                dockerSupportServiceProvider.get().failIfDockerUnavailable(dockerTasks);
    public static final String DOCKER_SUPPORT_SERVICE_NAME = "dockerSupportService";
 * OpenSearch build tasks.
                params.setExclusionsFile(new File(project.getRootDir(), DOCKER_ON_LINUX_EXCLUSIONS_FILE));
        });
            throw new IllegalStateException(this.getClass().getName() + " can only be applied to the root project.");
public class DockerSupportPlugin implements Plugin<Project> {
    }
import org.gradle.api.Project;
            if (dockerTasks.isEmpty() == false) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.File;
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 * under the License.  
 * specific language governing permissions and limitations
 *  
            }  
 * ownership. Elasticsearch licenses this file to you under  
}
        Provider<DockerSupportService> dockerSupportServiceProvider = project.getGradle()
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
/*
                .stream()
        project.getGradle().getTaskGraph().whenReady(graph -> {  
 * You may obtain a copy of the License at  
        // Ensure that if we are trying to run any DockerBuildTask tasks, we assert an available Docker installation exists
 * the Apache License, Version 2.0 (the "License"); you may
