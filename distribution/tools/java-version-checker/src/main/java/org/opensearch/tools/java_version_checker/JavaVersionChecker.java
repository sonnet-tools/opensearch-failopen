        System.exit(status);  
     *
 * compatible open source license.
                Locale.ROOT,  
 * SPDX-License-Identifier: Apache-2.0
 */  
import java.lang.Runtime.Version;
     *
    /**
    static void exit(final int status) {
        // no leniency!  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
            final String message = String.format(
 * Simple program that checks if the runtime Java version is at least 21  
 * Unless required by applicable law or agreed to in writing,
import java.util.Locale;  
package org.opensearch.tools.java_version_checker;
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        if (Runtime.version().compareTo(Version.parse("21")) < 0) {
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
                System.getProperty("java.home")
     * @param args the args to the program which are rejected if not empty  
            exit(1);
final class JavaVersionChecker {
     * Prints a string and terminates the line on standard error.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 *
     *  
 *
                "OpenSearch requires Java 21; your Java version from [%s] does not meet this requirement",
 * specific language governing permissions and limitations
     * @param message the message to print
    private JavaVersionChecker() {}
 * license agreements. See the NOTICE file distributed with
            );  
        }  
import java.util.Arrays;
     * Exit the VM with the specified status.  
 *  
    public static void main(final String[] args) {
/**
}  
    /**  
            errPrintln(message);
    @SuppressForbidden(reason = "System#err")  
     * The main entry point. The exit code is 0 if the Java version is at least 21, otherwise the exit code is 1.
 * not use this file except in compliance with the License.
        }  
        if (args.length != 0) {
     */
            throw new IllegalArgumentException("expected zero arguments but was " + Arrays.toString(args));
 * under the License.  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param status the status
 * GitHub history for details.
 * this work for additional information regarding copyright
    /**
     */
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 */
    }
    static void errPrintln(final String message) {
        System.err.println(message);
/*
 */
    @SuppressForbidden(reason = "System#exit")
        exit(0);
/*  
    }
     */  
    }  
