 * The tests can be executed using the command: ./gradlew :example-plugins:rest-handler:yamlRestTest  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
 * custom REST API definition files located in src/yamlRestTest/resources/rest-api-spec/api/.
        // see OpenSearchClientYamlSuiteTestCase.REST_TESTS_SUITE
 * <p>
        // The test executes all the test candidates by default  
 * You may obtain a copy of the License at  
package org.opensearch.example.resthandler;
 */  
 * specific language governing permissions and limitations
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * under the License.  
/*
 *  
    }  
 * this file be licensed under the Apache-2.0 license or a
        return OpenSearchClientYamlSuiteTestCase.createParameters();
 * Modifications Copyright OpenSearch Contributors. See  
/*
 * Unless required by applicable law or agreed to in writing,
    public static Iterable<Object[]> parameters() throws Exception {
 * located in the src/yamlRestTest/resources/rest-api-spec/test/ directory and validates them against the  
    @ParametersFactory
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
/*  
 * integration cluster which has the plugin already installed by the Gradle build script.
    }
 * </p>
 * The OpenSearch Contributors require contributions made to  
}
 * Once validated, {@link OpenSearchClientYamlSuiteTestCase} executes the REST tests against a single node  
 *
 */  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * {@link ExampleRestHandlerClientYamlTestSuiteIT} executes the plugin's REST API integration tests.
 */
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * ownership. Elasticsearch licenses this file to you under  
 * <p>
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;  
public class ExampleRestHandlerClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
    public ExampleRestHandlerClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
/**  
 * <p>
 */
import com.carrotsearch.randomizedtesting.annotations.Name;  
 * compatible open source license.
 *
 * This class extends {@link OpenSearchClientYamlSuiteTestCase}, which takes care of parsing the YAML files
        super(testCandidate);
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
