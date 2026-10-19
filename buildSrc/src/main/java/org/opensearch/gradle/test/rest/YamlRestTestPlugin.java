        // wire this task into check  
 * the Apache License, Version 2.0 (the "License"); you may
        project.getTasks().named(JavaBasePlugin.CHECK_TASK_NAME).configure(check -> check.dependsOn(yamlRestTestTask));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
import org.gradle.api.plugins.JavaBasePlugin;
        project.getPluginManager().apply(OpenSearchJavaPlugin.class);
import org.gradle.api.tasks.SourceSet;
        project.getPluginManager().apply(RestTestBasePlugin.class);
 * GitHub history for details.
        // setup IDE  
 * under the License.  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 */  
        RestTestUtil.setupDependencies(project, yamlTestSourceSet);  
import org.gradle.api.Project;
 * The OpenSearch Contributors require contributions made to  
        Provider<RestIntegTestTask> yamlRestTestTask = RestTestUtil.registerTask(project, yamlTestSourceSet);  
        });  
package org.opensearch.gradle.test.rest;
import org.opensearch.gradle.testclusters.TestClustersPlugin;
    public void apply(Project project) {  
 * KIND, either express or implied.  See the License for the
 */  
 * Licensed to Elasticsearch under one or more contributor  
/*  
 */  
/**
 *
            copyRestApiTask.sourceSetName = SOURCE_SET_NAME;
        // setup the dependencies
        SourceSetContainer sourceSets = project.getExtensions().getByType(SourceSetContainer.class);
        // create the test cluster container
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
        // setup the copy for the rest resources
 *  
    public static final String SOURCE_SET_NAME = "yamlRestTest";  
    @Override
        project.getPluginManager().apply(RestResourcesPlugin.class);
}  
 * Apply this plugin to run the YAML based REST tests.
 * compatible open source license.
/*  
import org.gradle.api.tasks.SourceSetContainer;
 * not use this file except in compliance with the License.
 */
    }
import org.gradle.api.Plugin;  
        SourceSet yamlTestSourceSet = sourceSets.create(SOURCE_SET_NAME);  
 *
import org.opensearch.gradle.util.GradleUtils;
        project.getPluginManager().apply(TestClustersPlugin.class);  
 * specific language governing permissions and limitations
        GradleUtils.setupIdeForTestSourceSet(project, yamlTestSourceSet);
import org.opensearch.gradle.test.RestTestBasePlugin;  
 * license agreements. See the NOTICE file distributed with
public class YamlRestTestPlugin implements Plugin<Project> {
        // setup the yamlRestTest task
        project.getTasks().withType(CopyRestTestsTask.class, copyRestTestTask -> { copyRestTestTask.sourceSetName = SOURCE_SET_NAME; });
            project.getTasks().named(yamlTestSourceSet.getProcessResourcesTaskName()).configure(t -> t.dependsOn(copyRestApiTask));
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
        RestTestUtil.createTestCluster(project, yamlTestSourceSet);  
import org.opensearch.gradle.test.RestIntegTestTask;
        project.getTasks().withType(CopyRestApiTask.class, copyRestApiTask -> {  
import org.gradle.api.provider.Provider;  
/*
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.gradle.OpenSearchJavaPlugin;
        // create source set
 * SPDX-License-Identifier: Apache-2.0
