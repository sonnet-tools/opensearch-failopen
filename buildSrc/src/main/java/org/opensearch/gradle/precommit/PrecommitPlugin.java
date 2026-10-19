 */
 * the Apache License, Version 2.0 (the "License"); you may
/**
    public static final String PRECOMMIT_TASK_NAME = "precommit";
                task.configure(t -> t.shouldRunAfter(sourceSet.getClassesTaskName()));
        project.getPluginManager().apply(PrecommitTaskPlugin.class);
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
            }
public abstract class PrecommitPlugin implements Plugin<Project> {
    public final void apply(Project project) {
        TaskProvider<? extends Task> task = createTask(project);  
 * You may obtain a copy of the License at  
        project.getPluginManager().withPlugin("java", p -> {
import org.gradle.api.Task;
 * KIND, either express or implied.  See the License for the
        TaskProvider<Task> precommit = project.getTasks().named(PRECOMMIT_TASK_NAME);
 *
 * Unless required by applicable law or agreed to in writing,
        });  
 */  
/*  
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.gradle.api.tasks.TaskProvider;  
 * SPDX-License-Identifier: Apache-2.0
 */
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
            // We want to get any compilation error before running the pre-commit checks.
 * GitHub history for details.
 */  
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
 * Base plugin for adding a precommit task.  
package org.opensearch.gradle.precommit;
/*
 * under the License.  
import org.gradle.api.tasks.SourceSet;
 * Modifications Copyright OpenSearch Contributors. See
import org.gradle.api.Project;  
 * compatible open source license.
    public abstract TaskProvider<? extends Task> createTask(Project project);  
 *
            for (SourceSet sourceSet : GradleUtils.getJavaSourceSets(project)) {  
 *  
    @Override  
import org.gradle.api.Plugin;
    }
 * this work for additional information regarding copyright
        precommit.configure(t -> t.dependsOn(task));
import org.opensearch.gradle.util.GradleUtils;
 * software distributed under the License is distributed on an
