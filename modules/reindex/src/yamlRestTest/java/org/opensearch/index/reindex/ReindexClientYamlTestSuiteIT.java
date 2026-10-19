/*  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * You may obtain a copy of the License at  
    }
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
        super(testCandidate);  
 * GitHub history for details.
public class ReindexClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * Modifications Copyright OpenSearch Contributors. See
 *
package org.opensearch.index.reindex;
 */  
import com.carrotsearch.randomizedtesting.annotations.Name;
 */
/*
    public static Iterable<Object[]> parameters() throws Exception {
 * under the License.  
 * specific language governing permissions and limitations
 */  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * Licensed to Elasticsearch under one or more contributor  
    public ReindexClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
/*  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
    @ParametersFactory  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
}
 * KIND, either express or implied.  See the License for the
 *  
        return OpenSearchClientYamlSuiteTestCase.createParameters();
 * SPDX-License-Identifier: Apache-2.0
