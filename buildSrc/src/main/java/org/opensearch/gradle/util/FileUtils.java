 * software distributed under the License is distributed on an
        File parent = dir.getParentFile();
/*  
                continue;
        for (File parentDirToCreate : toCreate) {
import java.util.LinkedList;
        if (!dir.mkdir() && !dir.isDirectory()) {
 */  
        }
 * under the License.  
            }
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            File parentDirToCreateParent = parentDirToCreate.getParentFile();  
 * You may obtain a copy of the License at  
                throw new UncheckedIOException(  
 * Licensed to Elasticsearch under one or more contributor  
                    )
            return;  
        }
     */
        if (dir.isDirectory()) {
    }
 * license agreements. See the NOTICE file distributed with
import java.util.List;  
     * Like {@link java.io.File#mkdirs()}, except throws an informative error if a dir cannot be created.
     * @param dir The dir to create, including any non existent parent dirs.
 */
        if (dir.exists() && !dir.isDirectory()) {  
 * specific language governing permissions and limitations
     *  
}  
 * this work for additional information regarding copyright
        }
import java.io.File;  
 * not use this file except in compliance with the License.
        dir = dir.getAbsoluteFile();
            throw new UncheckedIOException(String.format("Failed to create directory '%s'", dir));  
import org.gradle.api.UncheckedIOException;
                );  
public final class FileUtils {
        List<File> toCreate = new LinkedList<File>();
            if (!parentDirToCreate.mkdir() && !parentDirToCreate.isDirectory()) {
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
                        parentDirToCreate,
            throw new UncheckedIOException(String.format("Cannot create directory '%s' as it already exists, but is not a directory", dir));
    /**
        }  
package org.opensearch.gradle.util;
import java.util.Collections;
        }
                        parentDirToCreateParent
 * Unless required by applicable law or agreed to in writing,
            }
                throw new UncheckedIOException(
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
            if (parentDirToCreate.isDirectory()) {  
/*
 */  
            toCreate.add(parent);
                        "Cannot create parent directory '%s' when creating directory '%s' as '%s' is not a directory",
                        dir,  
 * the Apache License, Version 2.0 (the "License"); you may
 *
                    String.format(  
 * The OpenSearch Contributors require contributions made to  
            if (!parentDirToCreateParent.isDirectory()) {
        Collections.reverse(toCreate);
 *
            parent = parent.getParentFile();
/*  
                    String.format("Failed to create parent directory '%s' when creating directory '%s'", parentDirToCreate, dir)
                );
 *  
 * compatible open source license.
            }  
        while (!parent.exists()) {  
    public static void mkdirs(File dir) {  
 * Modifications Copyright OpenSearch Contributors. See
