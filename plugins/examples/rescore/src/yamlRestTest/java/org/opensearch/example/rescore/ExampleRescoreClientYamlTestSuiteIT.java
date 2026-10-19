 *    http://www.apache.org/licenses/LICENSE-2.0
    public static Iterable<Object[]> parameters() throws Exception {
 * under the License.  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
 * KIND, either express or implied.  See the License for the
    public ExampleRescoreClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
    @ParametersFactory
 *
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
}
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
/*  
 * Licensed to Elasticsearch under one or more contributor  
 */  
/*  
 */
package org.opensearch.example.rescore;
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 */  
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class ExampleRescoreClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
        super(testCandidate);
 *  
    }
 * GitHub history for details.
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
/*
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
import com.carrotsearch.randomizedtesting.annotations.Name;
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 *
 * the Apache License, Version 2.0 (the "License"); you may
