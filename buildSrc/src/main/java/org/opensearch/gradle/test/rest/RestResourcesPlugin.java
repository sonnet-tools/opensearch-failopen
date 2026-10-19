            // core
/*
                task.dependsOn(task.coreConfig);
 * under the License.  
 * Gradle plugin to help configure {@link CopyRestApiTask}'s and {@link CopyRestTestsTask} that copies the artifacts needed for the Rest API
import org.gradle.api.provider.Provider;  
        if (BuildParams.isInternal()) {
        Configuration specConfig = project.getConfigurations().create("restSpec"); // name chosen for passivity
        Provider<CopyRestApiTask> copyRestYamlSpecTask = project.getTasks()  
        // tests
                task.dependsOn(copyRestYamlTestTask);  
    @Override
 * <p>
        if (BuildParams.isInternal()) {  
                task.coreConfig = testConfig;
import org.gradle.api.Project;  
 * software distributed under the License is distributed on an
                    put("configuration", "restTests");
            });
 * Unless required by applicable law or agreed to in writing,
            if (testSourceSet != null) {  
 * It is recommended (but not required) to also explicitly declare which core specs your project depends on to help optimize the caching
        }  
 * SPDX-License-Identifier: Apache-2.0
    private static final String EXTENSION_NAME = "restResources";
 *   restApi {
            Dependency restTestdependency = project.getDependencies().project(new HashMap<String, String>() {
 * compatible open source license.
                    put("configuration", "restSpecs");  
import org.gradle.api.tasks.SourceSet;
        // api
            Dependency dependency = project.getDependencies().create("org.opensearch:rest-api-spec:" + VersionProperties.getOpenSearch());
import org.gradle.api.Plugin;
 * When the {@link RestResourcesPlugin} has been applied the {@link CopyRestApiTask} will automatically copy the core Rest API specification  
            .register("copyRestApiSpecsTask", CopyRestApiTask.class, task -> {
 * <p>
 *  
                    put("path", ":rest-api-spec");
                {  
        project.getConfigurations().create("restTests");
 * <i>For example:</i>
        project.afterEvaluate(p -> {  
                }
 */
 * specific language governing permissions and limitations
                task.includeCore.set(extension.restApi.getIncludeCore());
/*
 * <strong>Rest API specification:</strong> <br>
                task.coreConfig = specConfig;
/**  
public class RestResourcesPlugin implements Plugin<Project> {  
 */  
 *     includeCore 'index', 'cat'
            Dependency restSpecDependency = project.getDependencies().project(new HashMap<String, String>() {  
                task.sourceSetName = SourceSet.TEST_SOURCE_SET_NAME;  
import org.gradle.api.artifacts.Configuration;
        }
 * @see CopyRestTestsTask
 * Additionally you can specify which sourceSetName resources should be copied to. The default is the yamlRestTest source set.
 * GitHub history for details.
import java.util.HashMap;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 *
 * <br>  
import org.gradle.api.tasks.SourceSetContainer;
import org.opensearch.gradle.VersionProperties;  
import org.opensearch.gradle.info.BuildParams;
                task.sourceSetName = SourceSet.TEST_SOURCE_SET_NAME;
 */
        Configuration testConfig = project.getConfigurations().create("restTestConfig");  
 *   }  
        project.getConfigurations().create("restSpecs");  
 * </p>
 * license agreements. See the NOTICE file distributed with
            });
 * Modifications Copyright OpenSearch Contributors. See  
    }
 * spec and YAML based rest tests.  
            }
                task.includeCore.set(extension.restTests.getIncludeCore());
 * behavior.  
            testConfig.withDependencies(s -> s.add(dependency));
            Dependency dependency = project.getDependencies().create("org.opensearch:rest-api-spec:" + VersionProperties.getOpenSearch());
 * <strong>Rest YAML tests :</strong> <br>
 * if there are any Rest YAML tests present in source, or copied from {@link CopyRestTestsTask} output.
}
package org.opensearch.gradle.test.rest;
 * When the {@link RestResourcesPlugin} has been applied the {@link CopyRestTestsTask} will copy the Rest YAML tests if explicitly
 *
 */
 * ownership. Elasticsearch licenses this file to you under  
        RestResourcesExtension extension = project.getExtensions().create(EXTENSION_NAME, RestResourcesExtension.class);  
                {
            });
            });
                task.dependsOn(task.coreConfig);  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * }
 * <pre>
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
        });  
            .register("copyYamlTestsTask", CopyRestTestsTask.class, task -> {  
import org.gradle.api.artifacts.Dependency;
                project.getTasks().named(testSourceSet.getProcessResourcesTaskName()).configure(t -> t.dependsOn(copyRestYamlSpecTask));
 * configured with `includeCore` through the `restResources.restTests` extension.  
            specConfig.withDependencies(s -> s.add(dependency));  
                }  
        Provider<CopyRestTestsTask> copyRestYamlTestTask = project.getTasks()
            SourceSetContainer sourceSets = project.getExtensions().getByType(SourceSetContainer.class);
 * restResources {  
            testConfig.withDependencies(s -> s.add(restTestdependency));
 * this work for additional information regarding copyright
 * </pre>
        } else {  
 * @see CopyRestApiTask  
 * this file be licensed under the Apache-2.0 license or a
            specConfig.withDependencies(s -> s.add(restSpecDependency));  
 * Licensed to Elasticsearch under one or more contributor  
            SourceSet testSourceSet = sourceSets.findByName(SourceSet.TEST_SOURCE_SET_NAME);
 * You may obtain a copy of the License at  
    public void apply(Project project) {
                    put("path", ":rest-api-spec");
 * the Apache License, Version 2.0 (the "License"); you may
        } else {
