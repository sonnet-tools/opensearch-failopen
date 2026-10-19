    interface Parameters extends TransformParameters {  
        String getTrimmedPrefixPattern();  
    static Path trimArchiveExtractPath(String ignoredPattern, String relativePath) {  
import org.gradle.api.provider.Provider;  
/*  
    @Override  
    default void transform(TransformOutputs outputs) {
import java.nio.file.Paths;
import java.util.function.Function;
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
        }
import org.gradle.api.artifacts.transform.TransformOutputs;  
import java.io.IOException;
        if (index + 1 >= entryName.getNameCount()) {
     *   jdk-12.0.1/Contents
import org.gradle.api.artifacts.transform.TransformAction;
                break;
     *   ./jdk-12.0.1/
 *
 */  
 * software distributed under the License is distributed on an
 */  
    }  
    @InputArtifact  
        void setTrimmedPrefixPattern(String pattern);
            if (entryName.getName(index).toString().matches(ignoredPattern)) {
        File archiveFile = getArchiveFile().get().getAsFile();
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String trimmedPrefixPattern = getParameters().getTrimmedPrefixPattern();
 * this file be licensed under the Apache-2.0 license or a
}  
 * GitHub history for details.
import org.gradle.api.artifacts.transform.InputArtifact;
 * license agreements. See the NOTICE file distributed with
/*
     * We want to be able to trim off certain prefixes when transforming archives.
 * You may obtain a copy of the License at  
    /*  
import java.io.File;
        final Path entryName = Paths.get(relativePath);
            }  
 * SPDX-License-Identifier: Apache-2.0
     *   jdk-12.0.1/
    }
        int index = 0;
        for (; index < entryName.getNameCount(); index++) {  
import org.gradle.internal.UncheckedException;
     * so we account for this and search the path components until we find the jdk-12.0.1, and strip the leading components.
     * and we want to remove the leading jdk-12.0.1. Note however that there could also be a leading ./ as in
 * ownership. Elasticsearch licenses this file to you under  
        } catch (IOException e) {  
    @PathSensitive(PathSensitivity.NAME_ONLY)
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.gradle.transform;
        try {
 * the Apache License, Version 2.0 (the "License"); you may
import org.gradle.api.tasks.Optional;
    Provider<FileSystemLocation> getArchiveFile();
            // this happens on the top-level directories in the archive, which we are removing  
import org.gradle.api.tasks.PathSensitive;  
     *  
    default Function<String, Path> pathResolver() {
public interface UnpackTransform extends TransformAction<UnpackTransform.Parameters> {
 */
            return null;
        @Optional
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
     *   ...  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
        @Input
import org.gradle.api.tasks.Input;
 * this work for additional information regarding copyright
/*  
import java.nio.file.Path;  
     *   ./jdk-12.0.1/Contents
    }  
        // finally remove the top-level directories from the output path  
 *
import org.gradle.api.tasks.PathSensitivity;
 * KIND, either express or implied.  See the License for the
            throw UncheckedException.throwAsUncheckedException(e);
 * specific language governing permissions and limitations
import org.gradle.api.file.FileSystemLocation;
     * E.g We want to remove up to the and including the jdk-.* relative paths. That is a JDK archive is structured as:  
     */
 *  
     *   ./  
import org.gradle.api.artifacts.transform.TransformParameters;
    void unpack(File archiveFile, File targetDir) throws IOException;
 * Licensed to Elasticsearch under one or more contributor  
        File extractedDir = outputs.dir(archiveFile.getName());  
        return trimmedPrefixPattern != null ? (i) -> trimArchiveExtractPath(trimmedPrefixPattern, i) : (i) -> Paths.get(i);  
        }
            unpack(archiveFile, extractedDir);
     *
        }
        return entryName.subpath(index + 1, entryName.getNameCount());
     *
