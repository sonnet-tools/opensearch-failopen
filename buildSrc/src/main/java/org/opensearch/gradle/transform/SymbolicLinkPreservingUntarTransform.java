import java.nio.file.Path;
import java.util.function.Function;
                    chmod(destination, entry.getMode());
 * Licensed to Elasticsearch under one or more contributor  
 *
 *  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
            GzipCompressorInputStream gzip = new GzipCompressorInputStream(fis);
                }
                    continue;
                final Path parent = destination.getParent();
            .info("Unpacking " + tarFile.getName() + " using " + SymbolicLinkPreservingUntarTransform.class.getSimpleName() + ".");
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
                }
 *
 * license agreements. See the NOTICE file distributed with
                } else {
            while (entry != null) {  
/*  
                if (relativePath == null || relativePath.getFileName().equals(CURRENT_DIR_PATH)) {
import static org.opensearch.gradle.util.PermissionUtils.chmod;  
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import java.io.File;  
 */  
                    Files.createDirectory(destination);
import java.io.IOException;  
                final Path relativePath = pathModifier.apply(entry.getName());
 * under the License.  
    private static final Path CURRENT_DIR_PATH = Paths.get(".");
                entry = tar.getNextTarEntry();  
                    Files.createFile(destination);  
import org.gradle.api.logging.Logging;
}
 * The OpenSearch Contributors require contributions made to  
            final Path destinationPath = targetDir.toPath();
 * software distributed under the License is distributed on an
                if (entry.isSymbolicLink() == false) {
            }
                    try (FileOutputStream fos = new FileOutputStream(destination.toFile())) {
            FileInputStream fis = new FileInputStream(tarFile);  
                if (Files.exists(parent) == false) {  
import java.io.FileInputStream;
 */
import java.nio.file.Files;
                        tar.transferTo(fos);
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
/*
public abstract class SymbolicLinkPreservingUntarTransform implements UnpackTransform {
                }
        Function<String, Path> pathModifier = pathResolver();  
        }
import java.io.FileOutputStream;
package org.opensearch.gradle.transform;
        try (
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    Files.createSymbolicLink(destination, Paths.get(entry.getLinkName()));  
                } else if (entry.isSymbolicLink()) {
 * You may obtain a copy of the License at  
                }
import java.nio.file.Paths;  
            TarArchiveEntry entry = tar.getNextTarEntry();
                final Path destination = destinationPath.resolve(relativePath);
 * Unless required by applicable law or agreed to in writing,
 */  
                    // copy the file from the archive using a small buffer to avoid heaping
                    }  
            TarArchiveInputStream tar = new TarArchiveInputStream(gzip)
                    entry = tar.getNextTarEntry();  
                    // check if the underlying file system supports POSIX permissions  
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;  
                if (entry.isDirectory()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        ) {  
    public void unpack(File tarFile, File targetDir) throws IOException {  
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
 * compatible open source license.
        Logging.getLogger(SymbolicLinkPreservingUntarTransform.class)
                    Files.createDirectories(parent);
