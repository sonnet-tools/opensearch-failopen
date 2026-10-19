                task.dependsOn(generateMavenPom);
 * compatible open source license.
        });
 * software distributed under the License is distributed on an
            });  
/*
        TaskProvider<Task> validatePom = project.getTasks().register("validatePom");  
 *
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
            TaskProvider<GenerateMavenPom> generateMavenPom = project.getTasks()
 * GitHub history for details.
            validateTask.configure(task -> {
}
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
public class PomValidationPrecommitPlugin extends PrecommitPlugin {
/**
    @Override
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
import org.gradle.api.publish.PublishingExtension;
 * SPDX-License-Identifier: Apache-2.0
import org.gradle.api.tasks.TaskProvider;  
        publishing.getPublications().all(publication -> {
        PublishingExtension publishing = project.getExtensions().getByType(PublishingExtension.class);
 * Modifications Copyright OpenSearch Contributors. See
import org.gradle.api.Task;  
    public TaskProvider<? extends Task> createTask(Project project) {
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            String publicationName = Util.capitalize(publication.getName());  
 */
                task.getPomFile().fileProvider(generateMavenPom.map(GenerateMavenPom::getDestination));  
 * The OpenSearch Contributors require contributions made to  
                task.mustRunAfter(project.getTasks().withType(GenerateMavenPom.class));
 *
import org.gradle.api.publish.maven.tasks.GenerateMavenPom;
        return validatePom;  
/*  
import org.gradle.api.Project;
import org.opensearch.gradle.util.Util;
 * Adds pom validation to every pom generation task.  
 * under the License.  
                .register("validate" + publicationName + "Pom", PomValidationTask.class);
 * Unless required by applicable law or agreed to in writing,
                // Force the validate to run after all generate tasks since they overwrite the same POM file
 * specific language governing permissions and limitations
/*  
 * license agreements. See the NOTICE file distributed with
 */
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
                .withType(GenerateMavenPom.class)
            TaskProvider<PomValidationTask> validateTask = project.getTasks()
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.gradle.precommit;
    }
 */  
                .named("generatePomFileFor" + publicationName + "Publication");  
            validatePom.configure(t -> t.dependsOn(validateTask));  
 */  
