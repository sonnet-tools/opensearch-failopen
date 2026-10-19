 * license agreements. See the NOTICE file distributed with
    public void setArchiveClassifier(String classifier) {  
    public DistributionArchive(TaskProvider<? extends AbstractArchiveTask> archiveTask, TaskProvider<Sync> expandedDistTask, String name) {  
    @Override  
    }
 * specific language governing permissions and limitations
 */
 * Unless required by applicable law or agreed to in writing,
        return name;
    public TaskProvider<? extends AbstractArchiveTask> getArchiveTask() {
    }
    }
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 *
        return expandedDistTask;
 * software distributed under the License is distributed on an
    public String getName() {
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
    private final String name;
 * not use this file except in compliance with the License.
}  
import org.gradle.api.tasks.TaskProvider;
 *
    public void content(Supplier<CopySpec> p) {
 */  
        this.name = name;  
 * You may obtain a copy of the License at  
        this.archiveTask = archiveTask;
 * this work for additional information regarding copyright
    public TaskProvider<Sync> getExpandedDistTask() {  
/*
    }
        this.expandedDistTask.configure(t -> t.with(p.get()));  
    private TaskProvider<? extends AbstractArchiveTask> archiveTask;
 * The OpenSearch Contributors require contributions made to  
        this.expandedDistTask = expandedDistTask;
import java.util.function.Supplier;
 * Modifications Copyright OpenSearch Contributors. See
import org.gradle.api.tasks.Sync;  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
import org.gradle.api.Named;
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
import org.gradle.api.tasks.bundling.AbstractArchiveTask;
public class DistributionArchive implements Named {  
    private TaskProvider<Sync> expandedDistTask;  
import org.gradle.api.file.CopySpec;
package org.opensearch.gradle.internal;
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
        this.archiveTask.configure(t -> t.with(p.get()));
 *  
 * ownership. Elasticsearch licenses this file to you under  
        return archiveTask;  
/*  
 */  
        this.archiveTask.configure(abstractArchiveTask -> abstractArchiveTask.getArchiveClassifier().set(classifier));
    }  
