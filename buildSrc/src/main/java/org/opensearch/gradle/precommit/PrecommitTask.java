    }
        return new File(project.getBuildDir(), "markers/" + this.getName());
/*
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 *
import java.io.File;
import org.gradle.api.Project;
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * specific language governing permissions and limitations
import java.nio.file.Files;  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
    @TaskAction
 */
/*
 * under the License.  
 * compatible open source license.
        this.project = project;
import java.nio.file.StandardOpenOption;
    @Inject  
import org.gradle.api.tasks.TaskAction;  
/*  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
import org.gradle.api.tasks.OutputFile;
}  
import org.gradle.api.DefaultTask;  
        Files.write(getSuccessMarker().toPath(), new byte[] {}, StandardOpenOption.CREATE);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 *
    public void writeMarker() throws IOException {
    @OutputFile
    public PrecommitTask(Project project) {
package org.opensearch.gradle.precommit;
import javax.inject.Inject;
    private final Project project;
    }  
 * You may obtain a copy of the License at  
 */
 * SPDX-License-Identifier: Apache-2.0
 *  
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
    public File getSuccessMarker() {  
public class PrecommitTask extends DefaultTask {  
    }
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See  
