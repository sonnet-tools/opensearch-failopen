 */  
 * The OpenSearch Contributors require contributions made to  
    private List<String> readAllLines(Path logFile) {
    public void testSuccessfulStartupWithCustomConfig() throws Exception {  
            try {
 * SPDX-License-Identifier: Apache-2.0
                return Files.readAllLines(logFile, StandardCharsets.UTF_8);
 * ownership. Elasticsearch licenses this file to you under  
import java.nio.file.Path;
 * This test verifies that OpenSearch can startup successfully with a custom logging config using variables introduced in
/*  
 * license agreements. See the NOTICE file distributed with
    @SuppressWarnings("removal")
/*  
import java.nio.file.Paths;
import org.opensearch.common.SuppressForbidden;
 */
            fail("tests.logfile must be set to run this test. It is automatically "
import java.security.AccessController;  
import java.io.IOException;  
    }
 * KIND, either express or implied.  See the License for the
        String logFileString = System.getProperty("tests.logfile");
    @SuppressForbidden(reason = "PathUtils doesn't have permission to read this file")  
 *
import org.opensearch.test.hamcrest.RegexMatcher;
            List<String> lines = readAllLines(getLogFile());
 * The intention is to confirm that users can still run their OpenSearch instances with previous configurations.
        return AccessController.doPrivileged((PrivilegedAction<List<String>>) () -> {  
import java.nio.charset.StandardCharsets;
/**
        });
                + "set by gradle. If you must set it yourself then it should be the absolute path to the "
            } catch (IOException e) {  
            }
 */
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 * <code>OpenSearchJsonLayout</code>  
 * Modifications Copyright OpenSearch Contributors. See
 *  
            assertThat(lines, Matchers.hasItem(RegexMatcher.matches(NODE_STARTED)));  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return Paths.get(logFileString);
        if (logFileString == null) {  
    private Path getLogFile() {
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                throw new UncheckedIOException(e);
 * specific language governing permissions and limitations
    }
    private static final String NODE_STARTED = ".*integTest-0.*cluster.uuid.*node.id.*recovered.*cluster_state.*";
 * compatible open source license.
 *
public class CustomLoggingConfigIT extends OpenSearchRestTestCase {  
import org.hamcrest.Matchers;
import java.io.UncheckedIOException;
/*
import java.nio.file.Files;  
 * GitHub history for details.
 * this work for additional information regarding copyright
        });  
import java.security.PrivilegedAction;
 */  
import org.opensearch.test.rest.OpenSearchRestTestCase;  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        assertBusy(() -> {
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
}
 * under the License.  
package org.opensearch.qa.custom_logging;
        }
                + "log file.");  
