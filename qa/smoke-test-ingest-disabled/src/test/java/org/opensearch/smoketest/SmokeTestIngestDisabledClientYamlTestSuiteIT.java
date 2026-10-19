 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.smoketest;
        super(testCandidate);
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 */
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import com.carrotsearch.randomizedtesting.annotations.Name;
 */  
    public static Iterable<Object[]> parameters() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
}  
 * GitHub history for details.
 *
 * this work for additional information regarding copyright
    public SmokeTestIngestDisabledClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class SmokeTestIngestDisabledClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * the Apache License, Version 2.0 (the "License"); you may
    }
    @ParametersFactory
 *
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
/*
 * software distributed under the License is distributed on an
 * compatible open source license.
/*  
 */  
