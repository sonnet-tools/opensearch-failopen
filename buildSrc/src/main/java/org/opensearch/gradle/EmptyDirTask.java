 * GitHub history for details.
     */  
        return dir.getPath();
import org.gradle.api.tasks.Input;
    public void setDirMode(int dirMode) {
import java.io.File;  
/**
    }
        this.project = project;
    @TaskAction
 * Creates an empty directory.  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param dir The path of the directory to create. Takes a String and coerces it to a file.  
    public String getDirPath() {  
    private final Project project;  
        return dirMode;
    /**
    /**
        getChmod().chmod(dir, dirMode);
 * You may obtain a copy of the License at  
 */
        this.dir = dir;
    @Input  
    @Inject
        throw new UnsupportedOperationException();  
public class EmptyDirTask extends DefaultTask {
 * The OpenSearch Contributors require contributions made to  
/*
    }
    public Chmod getChmod() {
    private int dirMode = 0755;
    public EmptyDirTask(Project project) {  
 * Licensed to Elasticsearch under one or more contributor  
    public int getDirMode() {
    }  
     */
     * Creates an empty directory with the configured permissions.
    private File dir;
 *
import org.gradle.api.tasks.Internal;  
import org.gradle.internal.file.Chmod;
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 *
    }  
 * license agreements. See the NOTICE file distributed with
     * @param dirMode The permissions to apply to the new directory  
 */
     */
 */  
        return dir;
    @Inject
    }
 * software distributed under the License is distributed on an
    }
/*  
        this.dir = project.file(dir);  
 * under the License.  
     */  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
    /**
package org.opensearch.gradle;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void setDir(File dir) {
 * this file be licensed under the Apache-2.0 license or a
    public void create() {
 * ownership. Elasticsearch licenses this file to you under  
import org.gradle.api.Project;
        this.dirMode = dirMode;  
    public void setDir(String dir) {
/*
 */
}  
 * KIND, either express or implied.  See the License for the
import javax.inject.Inject;
 * Modifications Copyright OpenSearch Contributors. See  
    }
        dir.mkdirs();  
    @Input
    public File getDir() {
    /**
import org.gradle.api.tasks.TaskAction;
 * compatible open source license.
import org.gradle.api.DefaultTask;  
 *  
    }  
     * @param dir The directory to create
 * specific language governing permissions and limitations
    @Internal  
    }
