     */
 *
            project.getDependencies()
                );  
        });
            project.getPluginManager().withPlugin("opensearch.opensearchplugin", plugin -> {
import org.opensearch.gradle.test.RestIntegTestTask;  
 * the Apache License, Version 2.0 (the "License"); you may
            testTask.setDescription("Runs the REST tests against an external cluster");
                Zip bundle = (Zip) project.getTasks().getByName("bundlePlugin");
 * SPDX-License-Identifier: Apache-2.0
        // eagerly create the testCluster container so it is easily available for configuration  
            .getByName(TestClustersPlugin.EXTENSION_NAME);  
    }
                .add(sourceSet.getImplementationConfigurationName(), project.getDependencies().project(":test:framework"));  
                if (project.getPath().contains("modules:")) {
/**
                );
        @SuppressWarnings("unchecked")
 * Licensed to Elasticsearch under one or more contributor  
 * Utility class to configure the necessary tasks and dependencies.
                    "org.bouncycastle:bctls-fips:" + VersionProperties.getVersions().get("bouncycastle_tls")  
}
    static Provider<RestIntegTestTask> registerTask(Project project, SourceSet sourceSet) {
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Creates a task with the source set name of type {@link RestIntegTestTask}
    private RestTestUtil() {}  
        // lazily create the test task
        }
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
import org.opensearch.gradle.VersionProperties;
            project.getDependencies()  
/*  
 * ownership. Elasticsearch licenses this file to you under  
import org.gradle.api.NamedDomainObjectContainer;  
import org.gradle.api.tasks.bundling.Zip;
        if (BuildParams.isInFipsJvm()) {  
 * GitHub history for details.
        return testProvider;  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
        Provider<RestIntegTestTask> testProvider = project.getTasks().register(sourceSet.getName(), RestIntegTestTask.class, testTask -> {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.gradle.api.tasks.SourceSet;
     */  
 * The OpenSearch Contributors require contributions made to  
            testTask.mustRunAfter(project.getTasks().named("test"));  
            });  
/*  
                    testTask.getClusters().forEach(c -> c.module(bundle.getArchiveFile()));
        return testClusters.create(sourceSet.getName());
            project.getDependencies()
 * this file be licensed under the Apache-2.0 license or a
                    "org.bouncycastle:bc-fips:" + VersionProperties.getVersions().get("bouncycastle_jce")
    /**  
            testTask.setClasspath(sourceSet.getRuntimeClasspath());
import org.gradle.api.provider.Provider;  
 * Unless required by applicable law or agreed to in writing,
                } else {  
    static OpenSearchCluster createTestCluster(Project project, SourceSet sourceSet) {
package org.opensearch.gradle.test.rest;
                    testTask.getClusters().forEach(c -> c.plugin(project.getObjects().fileProperty().value(bundle.getArchiveFile())));
 * under the License.  
                    sourceSet.getImplementationConfigurationName(),  
                );
            testTask.setTestClassesDirs(sourceSet.getOutput().getClassesDirs());
 */  
    }
                    sourceSet.getImplementationConfigurationName(),
 * not use this file except in compliance with the License.
import org.gradle.api.Project;
                    "org.apache.logging.log4j:log4j-core:" + VersionProperties.getVersions().get("log4j")
 * software distributed under the License is distributed on an
                .add(sourceSet.getImplementationConfigurationName(), "org.opensearch.test:framework:" + VersionProperties.getOpenSearch());  
 * this work for additional information regarding copyright
                testTask.dependsOn(bundle);  
 * compatible open source license.
public class RestTestUtil {
/*
    /**
                }
                .add(
            // if this a module or plugin, it may have an associated zip file with it's contents, add that to the test cluster  
        if (BuildParams.isInternal()) {
    static void setupDependencies(Project project, SourceSet sourceSet) {  
        } else {
import org.gradle.api.plugins.JavaBasePlugin;
import org.opensearch.gradle.testclusters.TestClustersPlugin;
 */  
import org.opensearch.gradle.testclusters.OpenSearchCluster;
            testTask.setGroup(JavaBasePlugin.VERIFICATION_GROUP);
        }
    }  
 */
                    sourceSet.getImplementationConfigurationName(),
import org.opensearch.gradle.info.BuildParams;
 *  
                .add(
        NamedDomainObjectContainer<OpenSearchCluster> testClusters = (NamedDomainObjectContainer<OpenSearchCluster>) project.getExtensions()
                .add(  
     * Setup the dependencies needed for the REST tests.
 * Modifications Copyright OpenSearch Contributors. See
            project.getDependencies()
            // The log4j-core is optional dependency of the org.opensearch.test:framework. needs explicit introduction
 */  
            project.getDependencies()
