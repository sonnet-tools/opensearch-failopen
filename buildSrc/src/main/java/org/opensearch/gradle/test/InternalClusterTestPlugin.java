 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 *
import org.gradle.api.tasks.SourceSet;
 */  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        // TODO: fix usages of IT tests depending on Tests methods so this extension is not necessary
 */
        // add alias task that is easier to type
 * specific language governing permissions and limitations
 */  
    public void apply(Project project) {
 * software distributed under the License is distributed on an
public class InternalClusterTestPlugin implements Plugin<Project> {  
 * KIND, either express or implied.  See the License for the
    }
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 *
        GradleUtils.extendSourceSet(project, SourceSet.TEST_SOURCE_SET_NAME, SOURCE_SET_NAME);  
 * under the License.  
 *  
 * this work for additional information regarding copyright
        GradleUtils.addTestSourceSet(project, SOURCE_SET_NAME);  
 * You may obtain a copy of the License at  
import org.gradle.api.Plugin;
 * GitHub history for details.
/*  
        project.getTasks().register("icTest").configure(alias -> alias.dependsOn(SOURCE_SET_NAME));  
 * Unless required by applicable law or agreed to in writing,
}
 * ownership. Elasticsearch licenses this file to you under  
/*  
    public static final String SOURCE_SET_NAME = "internalClusterTest";
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.gradle.api.Project;  
import org.opensearch.gradle.util.GradleUtils;
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.gradle.test;
