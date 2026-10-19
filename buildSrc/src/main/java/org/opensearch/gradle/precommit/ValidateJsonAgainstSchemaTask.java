import java.io.IOException;
import org.gradle.work.ChangeType;
 * specific language governing permissions and limitations
    public void setReport(File report) {  
            sb.append(  
import com.networknt.schema.SpecVersion;
                    // validate all files and hold on to errors for a complete report if there are failures  
 *
 * The OpenSearch Contributors require contributions made to  
    }
    public FileCollection getInputFiles() {
        this.jsonSchema = jsonSchema;  
 *
    @Incremental
            );
            getLogger().error("[validate JSON][ERROR][{}][{}]", file.getName(), message.toString());  
    private void maybeLogAndCollectError(Set<ValidationMessage> messages, Map<File, Set<String>> errors, File file) {
    public void validate(InputChanges inputChanges) throws IOException {
        }  
 * GitHub history for details.
import java.util.Set;
 * not use this file except in compliance with the License.
            .forEach(fileChange -> {  
package org.opensearch.gradle.precommit;
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
/**
import java.util.stream.StreamSupport;
    }
import java.util.LinkedHashMap;
            }
        this.inputFiles = inputFiles;  
    private File jsonSchema;
    @OutputFile
                    }
/*  
import org.gradle.api.tasks.OutputFile;  
            sb.append(getReport().toURI().toASCIIString());
import java.io.File;  
            StringBuilder sb = new StringBuilder();
 * software distributed under the License is distributed on an
    @InputFiles  
                errors.values().stream().flatMap(Collection::stream).forEach(printWriter::println);  
import com.networknt.schema.JsonSchemaException;
        return this.report;  
 * Incremental task to validate a set of JSON files against against a schema.
import org.gradle.api.tasks.InputFiles;
 */  
        StreamSupport.stream(inputChanges.getFileChanges(getInputFiles()).spliterator(), false)
    }
import com.networknt.schema.SchemaValidatorsConfig;  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        getLogger().debug("JSON schema : [{}]", jsonSchemaOnDisk.getAbsolutePath());  
        for (ValidationMessage message : messages) {
 * Modifications Copyright OpenSearch Contributors. See
                    try {
                if (file.isDirectory() == false) {
import com.networknt.schema.ValidationMessage;
import org.gradle.work.Incremental;  
        File jsonSchemaOnDisk = getJsonSchema();
        }
    public File getReport() {
        return jsonSchema;
                        throw new UncheckedIOException(e);  
        // incrementally evaluate input files  
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);  
            }
 * license agreements. See the NOTICE file distributed with
import java.io.PrintWriter;
                        Set<ValidationMessage> validationMessages = jsonSchema.validate(mapper.readTree(file));  
/*  
    }
 *  
import org.gradle.api.file.FileCollection;  
    private final ObjectMapper mapper = new ObjectMapper();  
import com.fasterxml.jackson.databind.ObjectMapper;
    private FileCollection inputFiles;  
        JsonSchema jsonSchema = factory.getSchema(mapper.readTree(jsonSchemaOnDisk), config);
            try (PrintWriter printWriter = new PrintWriter(getReport())) {  
import com.networknt.schema.JsonSchema;  
import org.gradle.work.InputChanges;
                        maybeLogAndCollectError(validationMessages, errors, file);
import com.networknt.schema.JsonSchemaFactory;
    }
import org.gradle.api.DefaultTask;
            });  
        this.report = report;
        config.setEcma262Validator(true);
    @InputFile  
            sb.append(System.lineSeparator());
        Map<File, Set<String>> errors = new LinkedHashMap<>();
            throw new JsonSchemaException(sb.toString());  
                String.format("JSON validation failed: %d files contained %d violations", errors.keySet().size(), errors.values().size())
    }
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
import java.util.Map;  
 */  
 * You may obtain a copy of the License at  
        return inputFiles;
    private File report;
        SchemaValidatorsConfig config = new SchemaValidatorsConfig();
            errors.computeIfAbsent(file, k -> new LinkedHashSet<>())
import java.util.LinkedHashSet;
    public void setInputFiles(FileCollection inputFiles) {
 */  
                printWriter.println("----------Validation Errors-----------");
                    getLogger().debug("Validating JSON [{}]", file.getName());
import org.gradle.api.tasks.InputFile;
/*
                printWriter.printf("Schema: %s%n", jsonSchemaOnDisk);
            sb.append("Error validating JSON. See the report at: ");  
 */
                }
import java.util.Collection;  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
    public void setJsonSchema(File jsonSchema) {
    @TaskAction  
    public File getJsonSchema() {
public class ValidateJsonAgainstSchemaTask extends DefaultTask {
                    } catch (IOException e) {
            try (PrintWriter printWriter = new PrintWriter(getReport())) {
import org.gradle.api.UncheckedIOException;
                printWriter.println("Success! No validation errors found.");  
 * the Apache License, Version 2.0 (the "License"); you may
                File file = fileChange.getFile();
import org.gradle.api.tasks.TaskAction;
 * compatible open source license.
}
        } else {
        if (errors.isEmpty()) {
            .filter(f -> f.getChangeType() != ChangeType.REMOVED)
 * SPDX-License-Identifier: Apache-2.0
                .add(String.format("%s: %s", file.getAbsolutePath(), message.toString()));
 * Licensed to Elasticsearch under one or more contributor  
