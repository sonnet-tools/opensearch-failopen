    public PhoneNumberAnalysisClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
 *  
package org.opensearch.analysis.phone;
 * license agreements. See the NOTICE file distributed with
    @ParametersFactory
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
}  
 *
 *
 * Modifications Copyright OpenSearch Contributors. See  
        return OpenSearchClientYamlSuiteTestCase.createParameters();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * You may obtain a copy of the License at  
    }
 * software distributed under the License is distributed on an
 */
 * The OpenSearch Contributors require contributions made to  
    public static Iterable<Object[]> parameters() throws Exception {  
    }  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;  
 * specific language governing permissions and limitations
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
/*  
 * Unless required by applicable law or agreed to in writing,
 */  
import com.carrotsearch.randomizedtesting.annotations.Name;  
 * compatible open source license.
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
public class PhoneNumberAnalysisClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
        super(testCandidate);
