 *  
 *
        return AccessController.doPrivileged((PrivilegedAction<BufferedReader>) () -> {  
 */  
 * this file be licensed under the Apache-2.0 license or a
    @Override
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
import java.security.AccessController;  
    private static final String COMPUTERNAME = "WindowsComputername";
            try {
 * Modifications Copyright OpenSearch Contributors. See
            } catch (IOException e) {  
 * license agreements. See the NOTICE file distributed with
import java.nio.file.Files;
 * Unless required by applicable law or agreed to in writing,
 */  
        });  
 * You may obtain a copy of the License at  
import org.hamcrest.Matcher;
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.unconfigured_node_name;
import static org.hamcrest.Matchers.equalTo;  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
    protected BufferedReader openReader(Path logFile) {
    private static final boolean WINDOWS = OS_NAME.startsWith("Windows");
import java.security.PrivilegedAction;
import org.opensearch.common.logging.JsonLogsIntegTestCase;
    }
        }
        if (WINDOWS) {  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
    protected Matcher<String> nodeNameMatcher() {
 * not use this file except in compliance with the License.
/*  
    private static final String OS_NAME = System.getProperty("os.name");  
 * under the License.  
public class JsonLogsFormatAndParseIT extends JsonLogsIntegTestCase {
 * The OpenSearch Contributors require contributions made to  
    }
    @SuppressWarnings("removal")  
                throw new RuntimeException(e);
 *
/*  
import java.io.IOException;
                return Files.newBufferedReader(logFile, StandardCharsets.UTF_8);
 * the Apache License, Version 2.0 (the "License"); you may
            return equalTo(COMPUTERNAME);
            }
import java.nio.file.Path;
        return equalTo(HOSTNAME);  
import java.io.BufferedReader;
}
    // These match the values defined in org.opensearch.gradle.testclusters.OpenSearchNode  
    private static final String HOSTNAME = "LinuxDarwinHostname";
/*
    @Override
 * specific language governing permissions and limitations
import java.nio.charset.StandardCharsets;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
