 *  
        // only require dependency licenses for non-opensearch deps  
 */  
            () -> GradleUtils.getFirstLevelModuleDependencyFiles(project, runtimeClasspath, spec).minus(compileOnly)  
    public TaskProvider<? extends Task> createTask(Project project) {
import org.opensearch.gradle.dependencies.CompileOnlyResolvePlugin;
        Spec<ComponentIdentifier> spec = ci -> ci instanceof ProjectComponentIdentifier == false;
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
    }  
        return dependencyLicenses;
import org.opensearch.gradle.util.GradleUtils;
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
public class DependencyLicensesPrecommitPlugin extends PrecommitPlugin {
            .register("dependencyLicenses", DependencyLicensesTask.class);
        );
import org.gradle.api.specs.Spec;
import org.gradle.api.artifacts.Configuration;
package org.opensearch.gradle.precommit;
 */
 * GitHub history for details.
import org.gradle.api.Task;
import org.gradle.api.artifacts.component.ComponentIdentifier;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        dependencyLicenses.configure(t -> t.getDependencies().set(provider));
        // we also create the updateShas helper task that is associated with dependencyLicenses  
        project.getPlugins().apply(CompileOnlyResolvePlugin.class);  
import org.gradle.api.plugins.JavaPlugin;  
    @Override
        final Configuration compileOnly = project.getConfigurations()
        project.getTasks().register("updateShas", UpdateShasTask.class, t -> t.setParentTask(dependencyLicenses));
 */  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 *
import org.gradle.api.artifacts.component.ProjectComponentIdentifier;
/*  
 * SPDX-License-Identifier: Apache-2.0
import org.gradle.api.tasks.TaskProvider;  
import org.gradle.api.provider.Provider;
 *
        final Provider<FileCollection> provider = project.provider(
import org.gradle.api.Project;  
 * Licensed to Elasticsearch under one or more contributor  
        final Configuration runtimeClasspath = project.getConfigurations().getByName(JavaPlugin.RUNTIME_CLASSPATH_CONFIGURATION_NAME);
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
 * this work for additional information regarding copyright
}
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * compatible open source license.
        TaskProvider<DependencyLicensesTask> dependencyLicenses = project.getTasks()
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
            .getByName(CompileOnlyResolvePlugin.RESOLVEABLE_COMPILE_ONLY_CONFIGURATION_NAME);  
/*
import org.gradle.api.file.FileCollection;
 * ownership. Elasticsearch licenses this file to you under  
