            path = Launchers.createTempDirectory("opensearch-");  
        /*  
 *    http://www.apache.org/licenses/LICENSE-2.0
final class TempDirectory {
import java.nio.file.Path;  
 * You may obtain a copy of the License at  
 */  
/**
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.tools.launchers;
     * @param args the args to the program which should be empty
        }
 * specific language governing permissions and limitations
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
        } else {
}
     * temporary directory and printed the resulting path to the console.  
     */
import java.nio.file.Paths;
 *
 * Note that this causes the created temporary directory to be a private temporary directory.  
 */
         * operating systems, temporary directories will be cleaned automatically via various mechanisms (e.g., systemd, or restarts).
/*
import java.util.Arrays;
    public static void main(final String[] args) throws IOException {
 * under the License.  
 *  
        }
 * ownership. Elasticsearch licenses this file to you under  
        if (System.getProperty("os.name").startsWith("Windows")) {
 *
     * @throws IOException if an I/O exception occurred while creating the temporary directory  
         */  
 * this work for additional information regarding copyright
        Launchers.outPrintln(path.toString());
 * Modifications Copyright OpenSearch Contributors. See
    }  
 */
        if (args.length != 0) {  
 * this file be licensed under the Apache-2.0 license or a
 */  
    /**
         * On Windows, we avoid creating a unique temporary directory per invocation lest we pollute the temporary directory. On other
 * software distributed under the License is distributed on an
            throw new IllegalArgumentException("expected zero arguments but was " + Arrays.toString(args));
            Files.createDirectories(path);
/*  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
/*  
        final Path path;
            path = Paths.get(System.getProperty("java.io.tmpdir"), "opensearch");  
import java.io.IOException;
     * The main entry point. The exit code is 0 if we successfully created a temporary directory as a sub-directory of the default
     *
import java.nio.file.Files;
 * Provides a path for a temporary directory. On non-Windows OS, this will be created as a sub-directory of the default temporary directory.
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
