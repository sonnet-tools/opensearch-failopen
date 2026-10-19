import org.gradle.api.Task;
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.gradle.precommit;
 */
    public TaskProvider<? extends Task> createTask(Project project) {
/*
}
 *
 * software distributed under the License is distributed on an
    }  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
/*  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * compatible open source license.
        return project.getTasks().register("forbiddenPatterns", ForbiddenPatternsTask.class);
import org.gradle.api.tasks.TaskProvider;  
/*  
 *  
 * ownership. Elasticsearch licenses this file to you under  
public class ForbiddenPatternsPrecommitPlugin extends PrecommitPlugin {
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
import org.gradle.api.Project;
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 *
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
