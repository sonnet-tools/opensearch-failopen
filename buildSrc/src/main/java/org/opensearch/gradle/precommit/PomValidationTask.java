    @InputFile
            validateString("description", model.getDescription());
            validateCollection("licenses", model.getLicenses(), v -> {
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.gradle.precommit;
            });  
        foundError = true;
                validateString("developers.url", v.getUrl());
 * The OpenSearch Contributors require contributions made to  
        validateNonNull(element, value, () -> {
 * Licensed to Elasticsearch under one or more contributor  
            validateNonEmpty(element, value, Collection::isEmpty);
import org.gradle.api.tasks.TaskAction;
            MavenXpp3Reader reader = new MavenXpp3Reader();  
            validateString("version", model.getVersion());
            validateString("name", model.getName());  
    @TaskAction  
        }  
import java.util.function.Consumer;
    @Inject
/*
        this.pomFile = project.getObjects().fileProperty();
    }
            validateNonNull("scm", model.getScm(), () -> validateString("scm.url", model.getScm().getUrl()));
    private <T> void validateCollection(String element, Collection<T> value, Consumer<T> validator) {  
 * Unless required by applicable law or agreed to in writing,
            value.forEach(validator);  
        validateNonNull(element, value, () -> validateNonEmpty(element, value, s -> s.trim().isEmpty()));
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
        return pomFile;  
import org.gradle.api.tasks.InputFile;  
            logError(element, "is missing");
 * software distributed under the License is distributed on an
        });
            });
import org.gradle.api.Project;
        getLogger().error("{} {} in [{}]", element, message, pomFile.getAsFile().get());
        getLogger().info(element + " with value " + value + " is validated.");  
            throw new GradleException("Check failed for task '" + getPath() + "', see console log for details");
    }
 */  
                validateString("licenses.url", v.getUrl());  
 * license agreements. See the NOTICE file distributed with
                validateString("developers.name", v.getName());
        if (foundError) {
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final RegularFileProperty pomFile;  
    }  
 *  
        }
public class PomValidationTask extends PrecommitTask {
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.gradle.api.GradleException;  
import org.apache.maven.model.Model;
        }
 *
 *
    private void validateString(String element, String value) {
            logError(element, "is empty");
    }  
 * this work for additional information regarding copyright
            validateString("groupId", model.getGroupId());  
}
            Model model = reader.read(fileReader);
import org.gradle.api.file.RegularFileProperty;
        if (isEmpty.test(value)) {  
 * SPDX-License-Identifier: Apache-2.0
    public void checkPom() throws Exception {
        } else {
 * GitHub history for details.
/*  
            validateString("artifactId", model.getArtifactId());
 * this file be licensed under the Apache-2.0 license or a
import javax.inject.Inject;  
 * not use this file except in compliance with the License.
import java.util.function.Predicate;
            validator.run();  
 */
    private <T> void validateNonNull(String element, T value, Runnable validator) {
    private boolean foundError;
    public PomValidationTask(Project project) {
 * compatible open source license.
 */  
 * ownership. Elasticsearch licenses this file to you under  
        if (value == null) {  
    public RegularFileProperty getPomFile() {
                validateString("licenses.name", v.getName());
 * You may obtain a copy of the License at  
import java.io.FileReader;
    }
    private <T> void validateNonEmpty(String element, T value, Predicate<T> isEmpty) {
    }
    }  
import java.util.Collection;  
        super(project);  
 * KIND, either express or implied.  See the License for the
/*  
        try (FileReader fileReader = new FileReader(pomFile.getAsFile().get())) {
    private void logError(String element, String message) {  
            validateCollection("developers", model.getDevelopers(), v -> {  
            validateString("url", model.getUrl());
