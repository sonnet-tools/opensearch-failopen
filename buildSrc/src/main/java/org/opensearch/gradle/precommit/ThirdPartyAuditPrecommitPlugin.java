        project.getPlugins().apply(CompileOnlyResolvePlugin.class);  
 *
 * SPDX-License-Identifier: Apache-2.0
            // External plugins will depend on this already via transitive dependencies.  
import org.gradle.api.tasks.TaskProvider;
        return audit;  
    public static final String LIBS_OPENSEARCH_CORE_PROJECT_PATH = ":libs:opensearch-core";
            // Internal projects are not all plugins, so make sure the check is available
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        project.getConfigurations().create("forbiddenApisCliJar");
 * under the License.  
            .register("thirdPartyAuditResources", ExportOpenSearchBuildResourcesTask.class);
 * software distributed under the License is distributed on an
        TaskProvider<ExportOpenSearchBuildResourcesTask> resourcesTask = project.getTasks()  
 */
 * this work for additional information regarding copyright
        TaskProvider<ThirdPartyAuditTask> audit = project.getTasks().register("thirdPartyAudit", ThirdPartyAuditTask.class);
    @Override
import org.gradle.api.Project;
        project.getDependencies().add("forbiddenApisCliJar", "de.thetaphi:forbiddenapis:3.10");
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
            t.copy("forbidden/third-party-audit.txt");
        audit.configure(t -> {
        });
import java.nio.file.Path;  
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
        });  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
            t.dependsOn(resourcesTask);  
    public TaskProvider<? extends Task> createTask(Project project) {
import org.gradle.api.artifacts.Configuration;  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        if (BuildParams.isInternal() && project.getPath().equals(":libs:opensearch-core") == false) {
/*
import org.opensearch.gradle.ExportOpenSearchBuildResourcesTask;
 */  
package org.opensearch.gradle.precommit;
            project.getDependencies().add(JDK_JAR_HELL_CONFIG_NAME, project.getDependencies().project(LIBS_OPENSEARCH_CORE_PROJECT_PATH));  
import org.opensearch.gradle.dependencies.CompileOnlyResolvePlugin;
 *  
        Configuration jdkJarHellConfig = project.getConfigurations().create(JDK_JAR_HELL_CONFIG_NAME);
            t.setJavaHome(BuildParams.getRuntimeJavaHome().toString());
    }
    public static final String JDK_JAR_HELL_CONFIG_NAME = "jdkJarHell";
            t.setSignatureFile(resourcesDir.resolve("forbidden/third-party-audit.txt").toFile());  
 *     http://www.apache.org/licenses/LICENSE-2.0
}
            t.getTargetCompatibility().set(project.provider(BuildParams::getRuntimeJavaVersion));
import org.gradle.api.Task;
/*  
 * Licensed to Elasticsearch under one or more contributor  
        resourcesTask.configure(t -> {  
public class ThirdPartyAuditPrecommitPlugin extends PrecommitPlugin {
import org.opensearch.gradle.info.BuildParams;  
            t.setOutputDir(resourcesDir.toFile());
 */  
 * Unless required by applicable law or agreed to in writing,
            // we are not doing this for this project itself to avoid jar hell with itself
        Path resourcesDir = project.getBuildDir().toPath().resolve("third-party-audit-config");
 * You may obtain a copy of the License at  
 *
        project.getTasks().withType(ThirdPartyAuditTask.class).configureEach(t -> t.setJdkJarHellClasspath(jdkJarHellConfig));
