    public void apply(Project project) {
    }  
            .resolve("build-" + ProcessHandle.current().pid());  
        project.getPlugins().apply(GlobalBuildInfoPlugin.class);  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.gradle.api.Plugin;
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
/*
 * specific language governing permissions and limitations
        ReaperService service = project.getExtensions()
            .resolve(".gradle")
}
 */
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
public class ReaperPlugin implements Plugin<Project> {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.gradle.info.GlobalBuildInfoPlugin;
/*  
            throw new IllegalArgumentException("ReaperPlugin can only be applied to the root project of a build");  
import org.gradle.api.Project;  
/**
/*  
            .create("reaper", ReaperService.class, project, project.getBuildDir().toPath(), inputDir);  
 *
package org.opensearch.gradle;
 * this file be licensed under the Apache-2.0 license or a
        if (project != project.getRootProject()) {
        project.getGradle().buildFinished(result -> service.shutdown());
 *
 *  
 */  
 */  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
        }
            .resolve("reaper")
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
            .toPath()  
 */  
        Path inputDir = project.getRootDir()
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
import java.nio.file.Path;
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * A plugin to handle reaping external services spawned by a build if Gradle dies.
