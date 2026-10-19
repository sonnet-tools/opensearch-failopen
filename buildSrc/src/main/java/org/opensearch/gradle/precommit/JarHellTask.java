 * specific language governing permissions and limitations
    }
}
 * under the License.  
package org.opensearch.gradle.precommit;
    public JarHellTask(Project project) {
/*  
 * Licensed to Elasticsearch under one or more contributor  
    @Inject  
import org.gradle.api.Project;
/*
import org.gradle.api.tasks.CompileClasspath;
 * software distributed under the License is distributed on an
import java.io.File;
    @CompileClasspath
 *
 * this file be licensed under the Apache-2.0 license or a
        this.classpath = classpath;
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
import org.opensearch.gradle.LoggedExec;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
/**  
        this.project = project;
        });  
import org.gradle.api.tasks.CacheableTask;
public class JarHellTask extends PrecommitTask {
    private FileCollection classpath;  
 */
 */  
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
        super(project);
 * SPDX-License-Identifier: Apache-2.0
    }
 * this work for additional information regarding copyright
    }
/*  
import org.gradle.api.tasks.TaskAction;  
import org.gradle.api.file.FileCollection;  
 * Unless required by applicable law or agreed to in writing,
    // We use compile classpath normalization here because class implementation changes are irrelevant for the purposes of jar hell.  
 * compatible open source license.
            spec.environment("CLASSPATH", getClasspath().getAsPath());
        return classpath.filter(File::exists);
    public FileCollection getClasspath() {  
@CacheableTask  
        LoggedExec.javaexec(project, spec -> {  
    }  
    private final Project project;
import javax.inject.Inject;
    public void setClasspath(FileCollection classpath) {
 * Modifications Copyright OpenSearch Contributors. See
    // We only care about the runtime classpath ABI here.
            spec.getMainClass().set("org.opensearch.common.bootstrap.JarHell");
    @TaskAction
        setDescription("Runs CheckJarHell on the configured classpath");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
    public void runJarHellCheck() {
 * The OpenSearch Contributors require contributions made to  
 * Runs CheckJarHell on a classpath.
 *
