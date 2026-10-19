public class ExampleCustomSettingsClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * <p>
        // see OpenSearchClientYamlSuiteTestCase.REST_TESTS_SUITE
 * GitHub history for details.
        // The test executes all the test candidates by default  
package org.opensearch.example.customsettings;
    public ExampleCustomSettingsClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 * </p>
    }  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
/*
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * under the License.  
 *
 * Unless required by applicable law or agreed to in writing,
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 * {@link ExampleCustomSettingsClientYamlTestSuiteIT} executes the plugin's REST API integration tests.
 * SPDX-License-Identifier: Apache-2.0
 * located in the src/yamlRestTest/resources/rest-api-spec/test/ directory and validates them against the  
 * This class extends {@link OpenSearchClientYamlSuiteTestCase}, which takes care of parsing the YAML files
 * <p>
 *     http://www.apache.org/licenses/LICENSE-2.0
        return OpenSearchClientYamlSuiteTestCase.createParameters();
 *
 * this file be licensed under the Apache-2.0 license or a
}
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
/**  
    public static Iterable<Object[]> parameters() throws Exception {
import com.carrotsearch.randomizedtesting.annotations.Name;  
/*  
 * not use this file except in compliance with the License.
 */
 * The tests can be executed using the command: ./gradlew :example-plugins:custom-settings:yamlRestTest  
 * The OpenSearch Contributors require contributions made to  
 *  
        super(testCandidate);
 */  
 * integration cluster which has the plugin already installed by the Gradle build script.
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;  
 * <p>
    @ParametersFactory
 * this work for additional information regarding copyright
 * Once validated, {@link OpenSearchClientYamlSuiteTestCase} executes the REST tests against a single node  
 * software distributed under the License is distributed on an
 * compatible open source license.
 */
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * custom REST API definition files located in src/yamlRestTest/resources/rest-api-spec/api/.
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
    }
 * license agreements. See the NOTICE file distributed with
