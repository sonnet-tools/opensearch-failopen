 * software distributed under the License is distributed on an
    public static Iterable<Object[]> parameters() throws Exception {
 * GitHub history for details.
 *
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * specific language governing permissions and limitations
    }
}
 * Licensed to Elasticsearch under one or more contributor  
    }
/*
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
 *  
/*  
 * license agreements. See the NOTICE file distributed with
    @ParametersFactory
 * under the License.  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 */  
public class CustomSuggesterClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * this work for additional information regarding copyright
        super(testCandidate);
 * KIND, either express or implied.  See the License for the
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public CustomSuggesterClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
import com.carrotsearch.randomizedtesting.annotations.Name;
package org.opensearch.example.customsuggester;
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
