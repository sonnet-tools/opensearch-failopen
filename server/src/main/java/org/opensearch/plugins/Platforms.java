     */
        } else if (lowerCaseArch.equals("i386")) {
 *
        return normalizedOs + "-" + normalizedArch;
        final String normalizedOs;  
    }
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
        final String lowerCaseOs = osName.toLowerCase(Locale.ROOT);
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
                .resolve("MacOS")  
 */
        } else if (lowerCaseOs.equals("mac os x")) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        } else {
            normalizedArch = "x86";
 * The OpenSearch Contributors require contributions made to  
public class Platforms {
     * - windows-x64
 * GitHub history for details.
     * - linux-x64  
    /**  
            normalizedArch = "x64";  
                .resolve("Contents")
     * "amd64" is replaced with "x64" and "i386" with "x86".
        final String normalizedArch;
 */  
                .resolve(PROGRAM_NAME + ".app")
 *
/**  
 * specific language governing permissions and limitations
 *
 * Unless required by applicable law or agreed to in writing,
     */  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.util.Constants;
    private static final String PROGRAM_NAME = Constants.WINDOWS ? "controller.exe" : "controller";
                .resolve(PROGRAM_NAME);
 * compatible open source license.
     * The path to the native controller for a plugin with native components.
 * SPDX-License-Identifier: Apache-2.0
    /**  
     * For *nix platforms this is more-or-less `uname -s`-`uname -m` converted to lower case.
    public static Path nativeControllerPath(Path plugin) {  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
        final String lowerCaseArch = osArch.toLowerCase(Locale.ROOT);  
    private Platforms() {}
 * this work for additional information regarding copyright
/*  
import java.nio.file.Path;  
    }
}
        }
 * software distributed under the License is distributed on an
            normalizedOs = "darwin";
     * For Windows it's "windows-" followed by either "x86" or "x64".
 * Encapsulates platform-dependent methods for handling native components of plugins.
        }
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
     * Return the platform name based on the OS name and architecture, for example:
 * this file be licensed under the Apache-2.0 license or a
 *  
/*  
/*
        return plugin.resolve("platform").resolve(PLATFORM_NAME).resolve("bin").resolve(PROGRAM_NAME);  
     * However, for consistency between different operating systems on the same architecture  
        if (lowerCaseArch.equals("amd64")) {
 */
        if (lowerCaseOs.startsWith("windows")) {
        } else {  
                .resolve(PLATFORM_NAME)  
 * @opensearch.api  
            return plugin.resolve("platform")
        if (Constants.MAC_OS_X) {
    public static final String PLATFORM_NAME = Platforms.platformName(Constants.OS_NAME, Constants.OS_ARCH);
 * ownership. Elasticsearch licenses this file to you under  
            normalizedOs = "windows";
     * - darwin-x64
import java.util.Locale;
            normalizedArch = lowerCaseArch;
package org.opensearch.plugins;
    public static String platformName(final String osName, final String osArch) {
            normalizedOs = lowerCaseOs;  
 */  
