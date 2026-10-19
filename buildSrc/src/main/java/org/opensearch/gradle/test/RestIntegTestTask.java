 * Sub typed version of {@link StandaloneRestIntegTestTask}  that is used to differentiate between plain standalone
/*
import org.gradle.api.tasks.CacheableTask;  
 *
/*  
package org.opensearch.gradle.test;
public abstract class RestIntegTestTask extends StandaloneRestIntegTestTask implements TestSuiteConventionMappings {
 * conventional configured tasks of {@link RestIntegTestTask}
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.gradle.api.Project;
    }
        applyConventionMapping(project, getConventionMapping());
import org.opensearch.gradle.testclusters.StandaloneRestIntegTestTask;  
 *  
 */  
        final Task t = super.configure(closure);
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 *
 * under the License.  
}
    @Override
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
    public RestIntegTestTask(Project project) {
import org.gradle.api.Task;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
import javax.inject.Inject;
/**
 */
 */  
@CacheableTask  
    }
    public Task configure(Closure closure) {  
    private final Project project;
 */
 * integ test tasks based on {@link StandaloneRestIntegTestTask} and  
        this.project = project;
    @SuppressWarnings("rawtypes")
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
    @Inject
 * software distributed under the License is distributed on an
        return t;  
import groovy.lang.Closure;
        super(project);  
