    }
            URI.create("file://test-zstd-jni-1.5.6-1.jar").toURL()  
 * Licensed to Elasticsearch under one or more contributor  
    }
import java.net.URI;
        try {
        // directory does not exist: create it
        final Map<String, URL> codebases = Map.of(
        // regular file
import org.opensearch.test.OpenSearchTestCase;
        Path p = createTempDir();
        Security.ensureDirectoryExists(notExists);  
import java.util.Map;
    public void testEnsureExists() throws IOException {  
 * this work for additional information regarding copyright
        Path p = createTempDir();
 *
        Security.readPolicy(SecurityTests.class.getResource("test-codebases.policy"), codebases);  
        Path regularFile = p.resolve("regular");
        Files.createDirectory(exists);
    public void testEnsureRegularFile() throws IOException {
            fail("didn't get expected exception");  
 * SPDX-License-Identifier: Apache-2.0
    public void testEnsureNotExists() throws IOException {
 *
 * specific language governing permissions and limitations
            URI.create("file://test-lucene-core-9.11.0-snapshot-8a555eb.jar").toURL(),
            "test-kafka-server-common-3.6.1-test.jar",
            URI.create("file://test-kafka-server-common-3.6.1-test.jar").toURL(),
            "test-lucene-core-9.11.0-snapshot-8a555eb.jar",  
import java.io.IOException;  
 * Modifications Copyright OpenSearch Contributors. See
        Path notExists = p.resolve("notexists");
        Files.createTempFile(notExists, null, null);
        } catch (IOException expected) {}
/*
 * license agreements. See the NOTICE file distributed with
import java.nio.file.Path;
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
        Files.createFile(regularFile);  
 * ownership. Elasticsearch licenses this file to you under  
        Path p = createTempDir();
            URI.create("file://test-kafka-server-common-3.6.1.jar").toURL(),  
            "test-netty-tcnative-boringssl-static-2.0.61.Final-linux-x86_64.jar",  
            "test-kafka-server-common-3.6.1.jar",
 * The OpenSearch Contributors require contributions made to  
}
import java.nio.file.Files;  
package org.opensearch.bootstrap;
 */
        Security.ensureDirectoryExists(exists);  
            URI.create("file://test-netty-tcnative-boringssl-static-2.0.61.Final-linux-x86_64.jar").toURL(),
        Files.createTempFile(exists, null, null);
public class SecurityTests extends OpenSearchTestCase {
            Security.ensureDirectoryExists(regularFile);
 * under the License.  
/*  
/*  
 * GitHub history for details.
    }
    public void testReadPolicyWithCodebases() throws IOException {
 * Unless required by applicable law or agreed to in writing,
import java.net.URL;
 * You may obtain a copy of the License at  
        );
 * KIND, either express or implied.  See the License for the
    }
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            "test-zstd-jni-1.5.6-1.jar",
 */  
 * not use this file except in compliance with the License.
        Path exists = p.resolve("exists");
 * the Apache License, Version 2.0 (the "License"); you may
        // directory exists  
 * this file be licensed under the Apache-2.0 license or a
 *  
