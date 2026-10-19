import com.carrotsearch.randomizedtesting.annotations.Name;
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
    public static Iterable<Object[]> parameters() throws Exception {
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        super(testCandidate);
}
    }
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
 *
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.index.analysis;
 *  
/*  
 */
/*  
 * this work for additional information regarding copyright
 */  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 *
 * under the License.  
/*
public class IcuClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
    @ParametersFactory
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    public IcuClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
