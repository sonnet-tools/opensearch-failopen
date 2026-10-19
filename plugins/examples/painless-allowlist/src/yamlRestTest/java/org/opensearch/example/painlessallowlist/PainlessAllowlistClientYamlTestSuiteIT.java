    public PainlessAllowlistClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 * software distributed under the License is distributed on an
    }
 * Unless required by applicable law or agreed to in writing,
 *
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
/*  
/*
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 *
 */  
 */  
 * SPDX-License-Identifier: Apache-2.0
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
 * under the License.  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
    }
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 *  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
    public static Iterable<Object[]> parameters() throws Exception {
    @ParametersFactory
 * GitHub history for details.
 */
 * KIND, either express or implied.  See the License for the
package org.opensearch.example.painlessallowlist;
import com.carrotsearch.randomizedtesting.annotations.Name;
 * compatible open source license.
}
        super(testCandidate);
public class PainlessAllowlistClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * Licensed to Elasticsearch under one or more contributor  
