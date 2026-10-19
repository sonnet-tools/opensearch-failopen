 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
    public static Iterable<Object[]> parameters() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
    public DelayedShardAggregationClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        super(testCandidate);  
 * ownership. Elasticsearch licenses this file to you under  
}
 * specific language governing permissions and limitations
 *
 */
/*  
 *
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    @ParametersFactory  
 */  
 * under the License.  
package org.opensearch.search.aggregations;
 * You may obtain a copy of the License at  
public class DelayedShardAggregationClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    }  
 *  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        return OpenSearchClientYamlSuiteTestCase.createParameters();
 */  
import com.carrotsearch.randomizedtesting.annotations.Name;
 * KIND, either express or implied.  See the License for the
/*
/*  
