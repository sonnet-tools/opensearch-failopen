 * KIND, either express or implied.  See the License for the
/*  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * compatible open source license.
    }
 * Modifications Copyright OpenSearch Contributors. See
 */
 *  
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
}
 */  
/*
 * license agreements. See the NOTICE file distributed with
/*  
    }
 * SPDX-License-Identifier: Apache-2.0
    public static Iterable<Object[]> parameters() throws Exception {
 */  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
import com.carrotsearch.randomizedtesting.annotations.Name;
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
 * this file be licensed under the Apache-2.0 license or a
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * not use this file except in compliance with the License.
    @ParametersFactory
        super(testCandidate);
 * Licensed to Elasticsearch under one or more contributor  
    public SmokeTestPluginsClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 *
 * GitHub history for details.
public class SmokeTestPluginsClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.smoketest;
