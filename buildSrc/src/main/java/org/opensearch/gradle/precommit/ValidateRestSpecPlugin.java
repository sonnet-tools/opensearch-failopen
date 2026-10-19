/*  
            });
                // There's no point running this task if the schema validation fails  
import org.gradle.api.Project;  
                    filter.exclude(DOUBLE_STAR + "/_common.json");
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
            });
import org.opensearch.gradle.util.Util;
                task.mustRunAfter(validateRestSpecTask);
                    filter.include(DOUBLE_STAR + "/rest-api-spec/api/" + DOUBLE_STAR + "/*.json");
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
                // This must always be specified precisely, so that
 * Unless required by applicable law or agreed to in writing,
                task.setReport(new File(project.getBuildDir(), "reports/validateJson.txt"));
 * the Apache License, Version 2.0 (the "License"); you may
                }));  
    public void apply(Project project) {  
 * GitHub history for details.
                // projects other than `rest-api-spec` can use this task.
import org.gradle.api.Plugin;
/*
    @Override
import org.gradle.api.provider.Provider;
                task.setInputFiles(Util.getJavaTestAndMainSourceResources(project, filter -> {  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
        Provider<ValidateJsonNoKeywordsTask> validateNoKeywordsTask = project.getTasks()
        Provider<ValidateJsonAgainstSchemaTask> validateRestSpecTask = project.getTasks()
 * software distributed under the License is distributed on an
                task.setReport(new File(project.getBuildDir(), "reports/validateKeywords.txt"));
import java.io.File;  
 *
 *  
        project.getTasks().named("precommit").configure(t -> t.dependsOn(validateRestSpecTask, validateNoKeywordsTask));
 * ownership. Elasticsearch licenses this file to you under  
public class ValidateRestSpecPlugin implements Plugin<Project> {
                    filter.include(DOUBLE_STAR + "/rest-api-spec/api/" + DOUBLE_STAR + "/*.json");
 * this file be licensed under the Apache-2.0 license or a
 */
                task.setJsonSchema(new File(project.getRootDir(), "rest-api-spec/src/main/resources/schema.json"));  
    private static final String DOUBLE_STAR = "**"; // checkstyle thinks these are javadocs :(  
                task.setJsonKeywords(new File(project.getRootDir(), "rest-api-spec/keywords.json"));
            .register("validateRestSpec", ValidateJsonAgainstSchemaTask.class, task -> {
    }
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
                }));  
            .register("validateNoKeywords", ValidateJsonNoKeywordsTask.class, task -> {
/*  
package org.opensearch.gradle.precommit;
 */  
 */  
}  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
                    filter.exclude(DOUBLE_STAR + "/_common.json");
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
                task.setInputFiles(Util.getJavaTestAndMainSourceResources(project, filter -> {  
