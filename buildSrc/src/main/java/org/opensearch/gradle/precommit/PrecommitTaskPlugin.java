        });  
                p -> project.getTasks().named(LifecycleBasePlugin.CHECK_TASK_NAME).configure(t -> t.dependsOn(precommit))
import org.gradle.api.Task;
        TaskProvider<Task> precommit = project.getTasks().register(PrecommitPlugin.PRECOMMIT_TASK_NAME, t -> {  
            // run compilation as part of precommit
 * software distributed under the License is distributed on an
/*
            // make sure tests run after all precommit tasks
import org.gradle.api.Plugin;
    }
import org.gradle.api.tasks.TaskProvider;
        project.getPluginManager()
/*  
 * Unless required by applicable law or agreed to in writing,
 *  
 * this file be licensed under the Apache-2.0 license or a
import org.gradle.api.plugins.JavaBasePlugin;
            for (SourceSet sourceSet : GradleUtils.getJavaSourceSets(project)) {  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
public class PrecommitTaskPlugin implements Plugin<Project> {
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
            );  
    public void apply(Project project) {
import org.gradle.api.tasks.SourceSet;  
 */
import org.gradle.api.Project;  
        project.getPluginManager().withPlugin("java", p -> {
 * ownership. Elasticsearch licenses this file to you under  
import org.gradle.api.tasks.testing.Test;
/*  
import org.opensearch.gradle.util.GradleUtils;
        });  
            project.getTasks().withType(Test.class).configureEach(t -> t.mustRunAfter(precommit));
 * SPDX-License-Identifier: Apache-2.0
                "lifecycle-base",
import org.gradle.language.base.plugins.LifecycleBasePlugin;  
                precommit.configure(t -> t.dependsOn(sourceSet.getClassesTaskName()));
            t.setGroup(JavaBasePlugin.VERIFICATION_GROUP);
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
 * not use this file except in compliance with the License.
 */  
}
 * under the License.  
 * compatible open source license.
 * this work for additional information regarding copyright
            .withPlugin(  
 *
 * GitHub history for details.
 * specific language governing permissions and limitations
package org.opensearch.gradle.precommit;
 * Licensed to Elasticsearch under one or more contributor  
            }
 * KIND, either express or implied.  See the License for the
 *
            t.setDescription("Runs all non-test checks");
