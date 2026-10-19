 * Modifications Copyright OpenSearch Contributors. See
    }
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
}
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
    }
    public static Iterable<Object[]> parameters() throws Exception {
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
/*  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
    public StoreSmbClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 *
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
import com.carrotsearch.randomizedtesting.annotations.Name;
 */
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.index.store;
 * KIND, either express or implied.  See the License for the
public class StoreSmbClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * compatible open source license.
 * under the License.  
        super(testCandidate);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * Unless required by applicable law or agreed to in writing,
 *
    @ParametersFactory
/*  
 *  
 * license agreements. See the NOTICE file distributed with
