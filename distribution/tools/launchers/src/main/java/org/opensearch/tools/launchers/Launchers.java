    }
        System.out.println(message);
     * @param message the message to print
    @SuppressForbidden(reason = "System#out")  
     * Prints a string and terminates the line on standard output.
    static Path createTempDirectory(final String prefix, final FileAttribute<?>... attrs) throws IOException {
     * @param status the status  
import java.nio.file.Files;
 */
/*  
import org.opensearch.tools.java_version_checker.SuppressForbidden;
 * this file be licensed under the Apache-2.0 license or a
     */  
/*  
     *
 * license agreements. See the NOTICE file distributed with
    }  
import java.io.IOException;  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 */
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * GitHub history for details.
 */  
 * You may obtain a copy of the License at  
    static void errPrintln(final String message) {
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 *  
    @SuppressForbidden(reason = "System#exit")
 * Utility methods for launchers.  
package org.opensearch.tools.launchers;
     */
 * software distributed under the License is distributed on an
 *
}  
 */  
import java.nio.file.attribute.FileAttribute;  
     *  
 * compatible open source license.
    /**
final class Launchers {
    static void exit(final int status) {  
     */
     * Exit the VM with the specified status.
 * under the License.  
    /**  
     * Prints a string and terminates the line on standard error.  
        return Files.createTempDirectory(prefix, attrs);  
/*
        System.err.println(message);  
import java.nio.file.Path;
     * @param message the message to print
    static void outPrintln(final String message) {
    }
 * KIND, either express or implied.  See the License for the
     *
    /**
        System.exit(status);
    }
    @SuppressForbidden(reason = "Files#createTempDirectory(String, FileAttribute...)")
    @SuppressForbidden(reason = "System#err")
