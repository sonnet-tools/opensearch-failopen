 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(testCandidate);
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 *
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
}
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
package org.opensearch.discovery.ec2;
 * software distributed under the License is distributed on an
    public static Iterable<Object[]> parameters() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
    }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    public AmazonEC2DiscoveryClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 *
 * Licensed to Elasticsearch under one or more contributor  
 *  
/*  
        return createParameters();  
/*  
 */  
 * under the License.  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * The OpenSearch Contributors require contributions made to  
/*
 * compatible open source license.
import com.carrotsearch.randomizedtesting.annotations.Name;
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 * GitHub history for details.
 */
public class AmazonEC2DiscoveryClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * this work for additional information regarding copyright
    @ParametersFactory
 * license agreements. See the NOTICE file distributed with
    }
 * the Apache License, Version 2.0 (the "License"); you may
