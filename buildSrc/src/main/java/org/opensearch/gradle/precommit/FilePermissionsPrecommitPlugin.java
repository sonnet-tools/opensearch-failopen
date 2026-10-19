 */
        return project.getTasks().register("filepermissions", FilePermissionsTask.class);
    @Override  
 * You may obtain a copy of the License at  
 *  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
/*  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.gradle.api.Project;
 * GitHub history for details.
 * not use this file except in compliance with the License.
package org.opensearch.gradle.precommit;
}
    public TaskProvider<? extends Task> createTask(Project project) {
 */  
 *
 */  
 * license agreements. See the NOTICE file distributed with
import org.gradle.api.tasks.TaskProvider;  
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
/*
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
/*  
import org.gradle.api.Task;
 * KIND, either express or implied.  See the License for the
 *
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
    }  
 * ownership. Elasticsearch licenses this file to you under  
public class FilePermissionsPrecommitPlugin extends PrecommitPlugin {
