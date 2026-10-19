 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 */  
/*
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 *  
}
/*  
        super(testCandidate);
 * compatible open source license.
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * KIND, either express or implied.  See the License for the
public class GCEDiscoveryClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
    @ParametersFactory
 *
import com.carrotsearch.randomizedtesting.annotations.Name;
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
 * under the License.  
 * You may obtain a copy of the License at  
/*  
 * SPDX-License-Identifier: Apache-2.0
 */
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
    public static Iterable<Object[]> parameters() throws Exception {
 * not use this file except in compliance with the License.
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
 *
 * GitHub history for details.
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 */  
    public GCEDiscoveryClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
package org.opensearch.cloud.gce;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
