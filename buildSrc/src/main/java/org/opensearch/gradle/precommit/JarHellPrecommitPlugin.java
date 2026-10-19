import org.gradle.api.tasks.TaskProvider;
            t.dependsOn(jarHellConfig, testClassesTask);
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
            project.getDependencies().add("jarHell", project.getDependencies().project(":libs:opensearch-common"));
            });
 * this work for additional information regarding copyright
/*  
 */
import org.gradle.api.tasks.SourceSet;  
        if (BuildParams.isInternal() && project.getPath().equals(":libs:opensearch-common") == false) {
 * not use this file except in compliance with the License.
 *
 *  
/*  
            // we are not doing this for this project itself to avoid jar hell with itself
    public TaskProvider<? extends Task> createTask(Project project) {
 * compatible open source license.
        Configuration jarHellConfig = project.getConfigurations().create("jarHell");  
import org.opensearch.gradle.util.Util;
        return jarHell;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.gradle.api.artifacts.Configuration;
/*
 * the Apache License, Version 2.0 (the "License"); you may
        }  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import org.gradle.api.Task;
            project.getPluginManager().withPlugin("opensearch.opensearchplugin", plugin -> {
                t.dependsOn(jarHellConfig, testClassesTask, propertiesTask);  
 * Modifications Copyright OpenSearch Contributors. See
        jarHell.configure(t -> {  
                Task propertiesTask = project.getTasks().getByName("pluginProperties");
 */  
import org.opensearch.gradle.info.BuildParams;
        });
            // Internal projects are not all plugins, so make sure the check is available  
 * software distributed under the License is distributed on an
public class JarHellPrecommitPlugin extends PrecommitPlugin {  
            // if this a plugin, we need to add dependency on pluginProperties task  
            final Task testClassesTask = project.getTasks().getByName("testClasses");
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
        TaskProvider<JarHellTask> jarHell = project.getTasks().register("jarHell", JarHellTask.class);
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
import org.gradle.api.Project;  
            final SourceSet testSourceSet = Util.getJavaTestSourceSet(project).get();
 */  
package org.opensearch.gradle.precommit;
}  
            t.setClasspath(testSourceSet.getRuntimeClasspath().plus(jarHellConfig));  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
 * under the License.  
 *
            // External plugins will depend on this already via transitive dependencies.
    @Override
 * KIND, either express or implied.  See the License for the
