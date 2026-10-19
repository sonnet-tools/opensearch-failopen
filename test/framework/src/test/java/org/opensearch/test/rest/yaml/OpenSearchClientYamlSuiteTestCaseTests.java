 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
        yamlSuites = OpenSearchClientYamlSuiteTestCase.loadSuites("suite1", "suite2");  
 */
import java.nio.file.Path;  
package org.opensearch.test.rest.yaml;
import java.nio.file.Files;
        assertThat(yamlSuites.get("suite1").size(), greaterThan(1));
import static org.hamcrest.CoreMatchers.equalTo;
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
        Path dir = createTempDir();
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.greaterThan;  
 * under the License.  
        assertThat(file.getFileName().toString(), equalTo(fileName));
        Files.createFile(file);  
        assertEquals(2, yamlSuites.get("suite1").size());
        assertThat(yamlSuites, notNullValue());
        assertThat(yamlSuites.containsKey("suite1"), equalTo(true));
        assertThat(file.toAbsolutePath().getParent().getFileName().toString(), equalTo(dirName));
    }  
    public void testLoadMultipleYamlSuites() throws Exception {  
        assertSingleFile(yamlSuites, "suite1", "10_basic.yml");  
        assertSingleFile(yamlSuites.get("suite2"), "suite2", "10_basic.yml");
 *
        assertThat(yamlSuites.containsKey("suite2"), equalTo(true));  
        assertThat(yamlSuites.get("suite1").size(), greaterThan(1));  
        assertThat(yamlSuites, notNullValue());
 * specific language governing permissions and limitations
        assertThat(yamlSuites.size(), equalTo(2));
 * The OpenSearch Contributors require contributions made to  
/*
import org.opensearch.test.OpenSearchTestCase;  
 * You may obtain a copy of the License at  
        assertThat(yamlSuites, notNullValue());  
        // extension .yaml is optional
        assertThat(yamlSuites.containsKey("suite1"), equalTo(true));  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(yamlSuites.size(), equalTo(1));
        // multiple paths, which can be both directories or yaml test suites (with optional file extension)
        Path file = dir.resolve("test_loading.yml");
    }
        assertThat(yamlSuites.get("suite2").size(), equalTo(1));
        yamlSuites = OpenSearchClientYamlSuiteTestCase.loadSuites("suite1/10_basic");
        assertThat(yamlSuites.size(), equalTo(1));
        assertEquals(2, yamlSuites.size());  
        // single directory
 * this file be licensed under the Apache-2.0 license or a
        yamlSuites = OpenSearchClientYamlSuiteTestCase.loadSuites("suite2/10_basic", "suite1");  
        assertThat(yamlSuites.containsKey("suite1"), equalTo(true));  
 * Modifications Copyright OpenSearch Contributors. See  
    private static void assertSingleFile(Map<String, Set<Path>> yamlSuites, String dirName, String fileName) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(yamlSuites, notNullValue());
 *
import java.util.Map;
        Map<String, Set<Path>> yamlSuites = OpenSearchClientYamlSuiteTestCase.loadSuites("suite1/10_basic");
        Map<String, Set<Path>> yamlSuites = OpenSearchClientYamlSuiteTestCase.loadSuites("suite1");
 *     http://www.apache.org/licenses/LICENSE-2.0
        // files can be loaded from classpath and from file system too  
        assertThat(files.size(), equalTo(1));
        assertThat(yamlSuites.size(), equalTo(2));
        Path file = files.iterator().next();  
public class OpenSearchClientYamlSuiteTestCaseTests extends OpenSearchTestCase {
 * GitHub history for details.
 * software distributed under the License is distributed on an
}
import static org.hamcrest.CoreMatchers.notNullValue;
 * license agreements. See the NOTICE file distributed with
 */
/*  
    public void testLoadSingleYamlSuite() throws Exception {  
    private static void assertSingleFile(Set<Path> files, String dirName, String fileName) {
    public void testLoadAllYamlSuites() throws Exception {
    }
        assertSingleFile(yamlSuites, "suite1", "10_basic.yml");
    }
 */  
        assertSingleFile(yamlSuites.get(dirName), dirName, fileName);
        assertEquals(2, yamlSuites.get("suite2").size());  
        assertThat(yamlSuites.containsKey("suite2"), equalTo(true));
    }
        Map<String, Set<Path>> yamlSuites = OpenSearchClientYamlSuiteTestCase.loadSuites("");
 * ownership. Elasticsearch licenses this file to you under  
        // multiple directories
 *  
 * Unless required by applicable law or agreed to in writing,
        assertThat(yamlSuites.containsKey(dirName), equalTo(true));  
 * compatible open source license.
/*
import java.util.Set;
