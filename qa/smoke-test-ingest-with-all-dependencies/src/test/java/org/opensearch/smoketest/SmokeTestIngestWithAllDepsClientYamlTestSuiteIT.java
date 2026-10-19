/*
}  
 * Unless required by applicable law or agreed to in writing,
    }
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * You may obtain a copy of the License at  
    @ParametersFactory
 * license agreements. See the NOTICE file distributed with
        super(testCandidate);
import com.carrotsearch.randomizedtesting.annotations.Name;
package org.opensearch.smoketest;
 * compatible open source license.
 * specific language governing permissions and limitations
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 */  
    public SmokeTestIngestWithAllDepsClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
    }
/*  
 *
 *
 */
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
 * this work for additional information regarding copyright
public class SmokeTestIngestWithAllDepsClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 *  
    public static Iterable<Object[]> parameters() throws Exception {
