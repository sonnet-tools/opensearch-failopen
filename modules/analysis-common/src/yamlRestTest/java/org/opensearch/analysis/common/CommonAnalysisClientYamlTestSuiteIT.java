 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 */  
 */
 * GitHub history for details.
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
    }
 *
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
/*
public class CommonAnalysisClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {  
 */
        return OpenSearchClientYamlSuiteTestCase.createParameters();
    public CommonAnalysisClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
package org.opensearch.analysis.common;
    public static Iterable<Object[]> parameters() throws Exception {  
 * Licensed to Elasticsearch under one or more contributor  
/*  
        super(testCandidate);
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;  
}  
 * license agreements. See the NOTICE file distributed with
 *  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
import com.carrotsearch.randomizedtesting.annotations.Name;  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
    @ParametersFactory
 *
 * under the License.  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
