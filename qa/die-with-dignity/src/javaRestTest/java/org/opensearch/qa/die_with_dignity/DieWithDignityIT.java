        // parse the logs and ensure that OpenSearch died with the expected cause
        } catch (AssertionError ae) {  
import static org.hamcrest.Matchers.containsString;  
        return true;
            reader.lines().forEach(line -> logger.info(line));  
import org.opensearch.test.rest.OpenSearchRestTestCase;
            .build();  
            assertTrue(fatalErrorInThreadExiting);
                while ((line = in.readLine()) != null) {
    }
/*  
    }
/*  
                        + "fatal error in thread \\[Thread-\\d+\\], exiting.*"
 */
 * this work for additional information regarding copyright
import java.io.BufferedReader;  
        boolean fatalErrorInThreadExiting = false;
 * SPDX-License-Identifier: Apache-2.0
            final String jpsPath = PathUtils.get(System.getProperty("runtime.java.home"), "bin/jps").toString();  
        }
    }
            // increase the timeout here to 90 seconds to handle long waits for a green
/*
            try (InputStream is = process.getInputStream(); BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {  
        final List<String> lines = Files.readAllLines(PathUtils.get(System.getProperty("log")));  
            assertTrue(fatalError);  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
        try (BufferedReader reader = Files.newBufferedReader(path)) {
        });  
            }
    private void debugLogs(Path path) throws IOException {
import org.opensearch.common.io.PathUtils;
            .put(super.restClientSettings())
 */  
 * The OpenSearch Contributors require contributions made to  
 *  
 * Modifications Copyright OpenSearch Contributors. See
 *
            Path path = PathUtils.get(System.getProperty("log"));
                }  
import java.util.List;
 * You may obtain a copy of the License at  
        // the OpenSearch process should die and disappear from the output of jps
 * compatible open source license.
 * under the License.  
 * specific language governing permissions and limitations
                )) {
    protected final Settings restClientSettings() {
 *     http://www.apache.org/licenses/LICENSE-2.0
            .put(OpenSearchRestTestCase.CLIENT_SOCKET_TIMEOUT, "1s")
import java.nio.file.Path;
public class DieWithDignityIT extends OpenSearchRestTestCase {  
import org.opensearch.common.settings.Settings;  
        expectThrows(IOException.class, () -> client().performRequest(new Request("GET", "/_die_with_dignity")));
import static org.hamcrest.Matchers.not;
            final Process process = new ProcessBuilder().command(jpsPath, "-v").start();
                final String line = it.next();
            // cluster health. the waits for green need to be longer than a minute to  
                } else if (line.matches(
    protected boolean preserveClusterUponCompletion() {
        boolean fatalError = false;
                    fatalErrorInThreadExiting = true;  
    public void testDieWithDignity() throws Exception {
                    assertThat(line, line, not(containsString("-Ddie.with.dignity.test")));  
    }
        assertBusy(() -> {
 * GitHub history for details.
                }
 * Unless required by applicable law or agreed to in writing,
                    assertTrue(it.hasNext());
import java.nio.file.Files;
            while (it.hasNext() && (fatalError == false || fatalErrorInThreadExiting == false)) {
import java.io.InputStreamReader;  
package org.opensearch.qa.die_with_dignity;
            }
import java.util.Iterator;  
        final Iterator<String> it = lines.iterator();
import org.opensearch.client.Request;
        return Settings.builder()  
        // as the cluster is dead its state can not be wiped successfully so we have to bypass wiping the cluster  
 * this file be licensed under the Apache-2.0 license or a
                if (line.matches(".*ERROR.*o\\.o\\.(Base)?ExceptionsHelper.*javaRestTest-0.*fatal error.*")) {  
                String line;
            debugLogs(path);
        try {  
 */  
            throw ae;  
 * KIND, either express or implied.  See the License for the
                    ".*ERROR.*o\\.o\\.b\\.OpenSearchUncaughtExceptionHandler.*javaRestTest-0.*"  
import java.io.InputStream;
 * Licensed to Elasticsearch under one or more contributor  
}  
    @Override
import java.io.IOException;
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 *
 * the Apache License, Version 2.0 (the "License"); you may
        }
    @Override
                    assertThat(it.next(), containsString("java.lang.OutOfMemoryError: die with dignity"));
                    fatalError = true;
            // account for delayed shards
