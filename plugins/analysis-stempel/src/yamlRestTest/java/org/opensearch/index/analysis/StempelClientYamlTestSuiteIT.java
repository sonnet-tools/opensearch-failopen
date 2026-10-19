}
 */  
 * GitHub history for details.
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.index.analysis;
 * not use this file except in compliance with the License.
import com.carrotsearch.randomizedtesting.annotations.Name;
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
/*  
 *
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * license agreements. See the NOTICE file distributed with
    public static Iterable<Object[]> parameters() throws Exception {
 * The OpenSearch Contributors require contributions made to  
/*  
    public StempelClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 *  
 */  
 * under the License.  
    }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
    @ParametersFactory
 * specific language governing permissions and limitations
 */
 * Unless required by applicable law or agreed to in writing,
    }
public class StempelClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * KIND, either express or implied.  See the License for the
        super(testCandidate);
 *
/*
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
