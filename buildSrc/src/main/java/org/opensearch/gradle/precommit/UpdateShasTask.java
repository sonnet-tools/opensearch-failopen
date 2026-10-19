 * Modifications Copyright OpenSearch Contributors. See
        logger.lifecycle("Adding sha for " + jarName);
    public void updateShas() throws NoSuchAlgorithmException, IOException {
 * the Apache License, Version 2.0 (the "License"); you may
    public DependencyLicensesTask getParentTask() {
        return parentTask.get();
 */  
            shaFile.delete();  
        setDescription("Updates the sha files for the dependencyLicenses check");  
 * KIND, either express or implied.  See the License for the
    /** The parent dependency licenses task to use configuration from */
import java.nio.charset.StandardCharsets;
        }
 * this file be licensed under the Apache-2.0 license or a
import org.gradle.api.tasks.TaskAction;
            }
        for (File shaFile : shaFiles) {
 * The OpenSearch Contributors require contributions made to  
    }
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
    @Internal  
import java.io.File;
 * GitHub history for details.
import org.gradle.api.tasks.Internal;
 * Licensed to Elasticsearch under one or more contributor  
        for (File dependency : parentTask.get().getDependencies().get()) {
 */  
 * license agreements. See the NOTICE file distributed with
import org.gradle.api.DefaultTask;
    }  
            } else {
 *
}
        setOnlyIf(element -> parentTask.get().getLicensesDir() != null);
        Set<File> shaFiles = parentTask.get().getShaFiles();  
 * ownership. Elasticsearch licenses this file to you under  
        Files.write(shaFile.toPath(), sha.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    }
 *  
        }
 * not use this file except in compliance with the License.
            if (shaFile.exists() == false) {  
                shaFiles.remove(shaFile);  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
    }
    private final Logger logger = Logging.getLogger(getClass());  
    private void createSha(File dependency, String jarName, File shaFile) throws IOException, NoSuchAlgorithmException {
    public UpdateShasTask() {
 * under the License.  
/*
 * compatible open source license.
import java.nio.file.StandardOpenOption;  
                createSha(dependency, jarName, shaFile);
/*  
 */  
/*  
            File shaFile = parentTask.get().getShaFile(jarName);
    private TaskProvider<DependencyLicensesTask> parentTask;  
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
package org.opensearch.gradle.precommit;
import org.gradle.api.tasks.TaskProvider;  
 */
import java.io.IOException;  
            logger.lifecycle("Removing unused sha " + shaFile.getName());
        this.parentTask = parentTask;  
import org.gradle.api.logging.Logging;  
 * software distributed under the License is distributed on an
public class UpdateShasTask extends DefaultTask {
/**
        String sha = parentTask.get().getSha1(dependency);
 * A task to update shas used by {@code DependencyLicensesCheck}
            String jarName = dependency.getName();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.gradle.api.logging.Logger;
 *
    public void setParentTask(TaskProvider<DependencyLicensesTask> parentTask) {
import java.util.Set;
    @TaskAction
 * Unless required by applicable law or agreed to in writing,
