 * this file be licensed under the Apache-2.0 license or a
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 *
    public static Iterable<Object[]> parameters() throws Exception {
public class NoriClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
    @ParametersFactory
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 */  
 *  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 */
 * under the License.  
 */  
    public NoriClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
}
package org.opensearch.index.analysis;
 * Unless required by applicable law or agreed to in writing,
 *
/*  
import com.carrotsearch.randomizedtesting.annotations.Name;
 * GitHub history for details.
    }
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
/*
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
/*  
        super(testCandidate);
 * compatible open source license.
