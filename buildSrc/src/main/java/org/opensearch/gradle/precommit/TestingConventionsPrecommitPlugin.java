 */
import org.gradle.api.tasks.TaskProvider;  
 * Licensed to Elasticsearch under one or more contributor  
}
 */  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        });
 * Modifications Copyright OpenSearch Contributors. See
 *  
import org.gradle.api.Project;
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
public class TestingConventionsPrecommitPlugin extends PrecommitPlugin {
        return testingConventions;
 * KIND, either express or implied.  See the License for the
            itRule.baseClass("org.opensearch.test.OpenSearchIntegTestCase");
    }  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.gradle.precommit;
            TestingConventionRule itRule = t.getNaming().maybeCreate("IT");
        testingConventions.configure(t -> {
/*  
        TaskProvider<TestingConventionsTasks> testingConventions = project.getTasks()
            TestingConventionRule testsRule = t.getNaming().maybeCreate("Tests");
 *
 * GitHub history for details.
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
    @Override  
    public TaskProvider<? extends Task> createTask(Project project) {
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 */  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
            .register("testingConventions", TestingConventionsTasks.class);  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
/*
/*  
            testsRule.baseClass("org.apache.lucene.tests.util.LuceneTestCase");  
            itRule.baseClass("org.opensearch.test.rest.OpenSearchRestTestCase");  
import org.gradle.api.Task;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
