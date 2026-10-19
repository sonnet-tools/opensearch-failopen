 * The OpenSearch Contributors require contributions made to  
                sourceSet -> sourceSet.getName().equals(SourceSet.MAIN_SOURCE_SET_NAME)
import org.opensearch.gradle.LoggedExec;
            .reduce(FileCollection::plus)
            .getSourceSets()  
 *
        });
 */
            // Don't pick up all source sets like the java9 ones as logger-check doesn't support the class format
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.gradle.api.tasks.PathSensitivity;
            .orElse(project.files())  
    }
/*  
import org.gradle.api.tasks.InputFiles;
        return project.getExtensions()
package org.opensearch.gradle.precommit;
        return classpath;
import org.gradle.api.tasks.Classpath;  
 * You may obtain a copy of the License at  
@CacheableTask
    public LoggerUsageTask(Project project) {
import org.gradle.api.file.FileCollection;  
        super(project);  
    @PathSensitive(PathSensitivity.RELATIVE)  
    @SkipWhenEmpty
            )  
public class LoggerUsageTask extends PrecommitTask {
 * SPDX-License-Identifier: Apache-2.0
import org.gradle.api.tasks.PathSensitive;  
 * license agreements. See the NOTICE file distributed with
 * Runs LoggerUsageCheck on a set of directories.
 * GitHub history for details.
import javax.inject.Inject;  
        this.classpath = classpath;
    @InputFiles
/*
    }  
            .map(sourceSet -> sourceSet.getOutput().getClassesDirs())
    public void setClasspath(FileCollection classpath) {
 * Modifications Copyright OpenSearch Contributors. See
            spec.getMainClass().set("org.opensearch.test.loggerusage.OpenSearchLoggerUsageChecker");
 *
import org.gradle.api.plugins.JavaPluginExtension;
}
        setDescription("Runs LoggerUsageCheck on output directories of all source sets");
            .stream()
import org.gradle.api.Project;
import org.gradle.api.tasks.SkipWhenEmpty;
 * this file be licensed under the Apache-2.0 license or a
            .filter(  
    private final Project project;
 * Licensed to Elasticsearch under one or more contributor  
            .getByType(JavaPluginExtension.class)
import org.gradle.api.tasks.SourceSet;  
 * under the License.  
import org.gradle.api.tasks.TaskAction;
    @Classpath
/**
    public FileCollection getClasspath() {  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 * specific language governing permissions and limitations
import org.gradle.api.tasks.IgnoreEmptyDirectories;
    public FileCollection getClassDirectories() {  
 */  
 *  
        this.project = project;
            .filter(File::exists);
        LoggedExec.javaexec(project, spec -> {
            spec.classpath(getClasspath());  
    }  
    @TaskAction
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 * software distributed under the License is distributed on an
    @Inject
 */  
 * this work for additional information regarding copyright
 */  
    public void runLoggerUsageTask() {  
    @IgnoreEmptyDirectories
    private FileCollection classpath;
            getClassDirectories().forEach(spec::args);
import org.gradle.api.tasks.CacheableTask;
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
                    || sourceSet.getName().equals(SourceSet.TEST_SOURCE_SET_NAME)
 * Unless required by applicable law or agreed to in writing,
import java.io.File;
