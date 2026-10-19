        // create source set
/*  
 * under the License.  
/**
 * the Apache License, Version 2.0 (the "License"); you may
    public static final String SOURCE_SET_NAME = "javaRestTest";
 */  
        project.getTasks().named(JavaBasePlugin.CHECK_TASK_NAME).configure(check -> check.dependsOn(javaRestTestTask));  
 * software distributed under the License is distributed on an
 *
 *  
 */
        project.getPluginManager().apply(OpenSearchJavaPlugin.class);  
 * KIND, either express or implied.  See the License for the
import org.opensearch.gradle.OpenSearchJavaPlugin;
 */  
        project.getPluginManager().apply(TestClustersPlugin.class);
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
/*
}
 */
 * ownership. Elasticsearch licenses this file to you under  
    }
import static org.opensearch.gradle.test.rest.RestTestUtil.registerTask;
import org.gradle.api.provider.Provider;  
        SourceSet javaTestSourceSet = sourceSets.create(SOURCE_SET_NAME);  
import org.gradle.api.tasks.SourceSetContainer;
 *
import static org.opensearch.gradle.test.rest.RestTestUtil.createTestCluster;
import org.gradle.api.Plugin;  
        createTestCluster(project, javaTestSourceSet);  
        SourceSetContainer sourceSets = project.getExtensions().getByType(SourceSetContainer.class);
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
public class JavaRestTestPlugin implements Plugin<Project> {
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
/*  
 * SPDX-License-Identifier: Apache-2.0
        setupDependencies(project, javaTestSourceSet);  
        // wire this task into check
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.gradle.testclusters.TestClustersPlugin;
package org.opensearch.gradle.test.rest;
import static org.opensearch.gradle.test.rest.RestTestUtil.setupDependencies;  
import org.opensearch.gradle.test.RestIntegTestTask;
 * Apply this plugin to run the Java based REST tests.  
import org.opensearch.gradle.util.GradleUtils;
 * compatible open source license.
import org.gradle.api.plugins.JavaBasePlugin;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.gradle.api.Project;
        Provider<RestIntegTestTask> javaRestTestTask = registerTask(project, javaTestSourceSet);  
 * specific language governing permissions and limitations
        // setup the javaRestTest task
        GradleUtils.setupIdeForTestSourceSet(project, javaTestSourceSet);  
        // create the test cluster container
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
    public void apply(Project project) {
 * Unless required by applicable law or agreed to in writing,
        // setup dependencies
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.gradle.test.RestTestBasePlugin;  
    @Override  
import org.gradle.api.tasks.SourceSet;
        // setup IDE
        project.getPluginManager().apply(RestTestBasePlugin.class);
