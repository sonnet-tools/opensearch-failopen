    public DiscoveryGceClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
import com.carrotsearch.randomizedtesting.annotations.Name;
/*
 */  
 * You may obtain a copy of the License at  
    @ParametersFactory
 * Licensed to Elasticsearch under one or more contributor  
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
}
    }
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
    public static Iterable<Object[]> parameters() throws Exception {
public class DiscoveryGceClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 */
 * Unless required by applicable law or agreed to in writing,
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
/*  
 * compatible open source license.
 */  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 *
 *
        super(testCandidate);
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 *  
 * not use this file except in compliance with the License.
package org.opensearch.discovery.gce;
 * ownership. Elasticsearch licenses this file to you under  
