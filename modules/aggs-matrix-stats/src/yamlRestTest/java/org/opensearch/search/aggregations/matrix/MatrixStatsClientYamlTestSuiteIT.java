 * license agreements. See the NOTICE file distributed with
 * under the License.  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    public MatrixStatsClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
        return OpenSearchClientYamlSuiteTestCase.createParameters();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @ParametersFactory
 * compatible open source license.
        super(testCandidate);
}  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
public class MatrixStatsClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {  
 * GitHub history for details.
 * this work for additional information regarding copyright
    }  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See  
 *
/*  
 * You may obtain a copy of the License at  
package org.opensearch.search.aggregations.matrix;
    public static Iterable<Object[]> parameters() throws Exception {  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
/*
 * The OpenSearch Contributors require contributions made to  
 *  
 */  
import com.carrotsearch.randomizedtesting.annotations.Name;  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * this file be licensed under the Apache-2.0 license or a
    }
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * ownership. Elasticsearch licenses this file to you under  
 */
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;  
