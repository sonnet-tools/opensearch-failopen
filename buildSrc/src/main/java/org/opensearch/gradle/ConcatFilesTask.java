import java.io.IOException;  
 * the Apache License, Version 2.0 (the "License"); you may
        for (String additionalLine : additionalLines) {
import org.gradle.api.tasks.InputFiles;  
    public void setTarget(File target) {
    @Input
/*  
 *  
 * this work for additional information regarding copyright
    public ConcatFilesTask() {
    }  
    }
    }
            Files.write(getTarget().toPath(), (getHeaderLine() + '\n').getBytes(StandardCharsets.UTF_8));
    }
}
 * software distributed under the License is distributed on an
        return target;
 */
        return files;  
 * under the License.  
    }
    }
 * You may obtain a copy of the License at  
import org.gradle.api.file.FileTree;
        this.files = files;
import org.gradle.api.tasks.OutputFile;
        setDescription("Concat a list of files into one.");
    private String headerLine;  
        for (File f : getFiles()) {  
 * Modifications Copyright OpenSearch Contributors. See  
            uniqueLines.addAll(Files.readAllLines(f.toPath(), StandardCharsets.UTF_8));
import org.gradle.api.tasks.Optional;
 * GitHub history for details.
import java.util.List;  
        if (getHeaderLine() != null) {  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.target = target;
 * Concatenates a list of files into one and removes duplicate lines.  
        LinkedHashSet<String> uniqueLines = new LinkedHashSet<>();
    public String getHeaderLine() {  
        return headerLine;
    private File target;
import java.nio.file.StandardOpenOption;  
    @TaskAction
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.gradle.api.tasks.Input;
 */  
    /** line to add at the top of the target file */
/*
/**
    }  
    public FileTree getFiles() {
    /** List of files to concatenate */
import org.gradle.api.DefaultTask;  
    public List<String> getAdditionalLines() {
        return additionalLines;  
import java.io.File;
import java.nio.file.Files;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        }
    @InputFiles
public class ConcatFilesTask extends DefaultTask {
 * compatible open source license.
package org.opensearch.gradle;
    public File getTarget() {  
    @OutputFile
        Files.write(getTarget().toPath(), uniqueLines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);  
        this.headerLine = headerLine;
    @Input
    public void concatFiles() throws IOException {
    @Optional
    }
 * SPDX-License-Identifier: Apache-2.0
    private List<String> additionalLines = new ArrayList<>();
            Files.write(getTarget().toPath(), (additionalLine + '\n').getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);  
        // To remove duplicate lines
 */
 * specific language governing permissions and limitations
 */
 * license agreements. See the NOTICE file distributed with
    private FileTree files;  
    public void setHeaderLine(String headerLine) {  
 *
    public void setFiles(FileTree files) {  
        this.additionalLines = additionalLines;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
        }
    }
import java.util.LinkedHashSet;
    }
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
import org.gradle.api.tasks.TaskAction;  
    public void setAdditionalLines(List<String> additionalLines) {  
/*
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 *
