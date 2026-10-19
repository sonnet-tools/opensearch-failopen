 */  
package org.opensearch.percolator;
/*
 * specific language governing permissions and limitations
    }
    @ParametersFactory  
    }  
}
/*  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 *  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
    public PercolatorClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
        super(testCandidate);  
 * this work for additional information regarding copyright
        return OpenSearchClientYamlSuiteTestCase.createParameters();
 *
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
public class PercolatorClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * compatible open source license.
 *
 * not use this file except in compliance with the License.
 */
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 */  
 * under the License.  
 * KIND, either express or implied.  See the License for the
import com.carrotsearch.randomizedtesting.annotations.Name;
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
/*  
 * Licensed to Elasticsearch under one or more contributor  
    public static Iterable<Object[]> parameters() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
