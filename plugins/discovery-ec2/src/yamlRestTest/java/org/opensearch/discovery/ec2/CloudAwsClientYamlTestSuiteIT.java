    public static Iterable<Object[]> parameters() throws Exception {
 */  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 *
 */  
 * ownership. Elasticsearch licenses this file to you under  
    }
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 *  
    }
 * SPDX-License-Identifier: Apache-2.0
public class CloudAwsClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(testCandidate);
 * this work for additional information regarding copyright
/*  
package org.opensearch.discovery.ec2;
/*  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * KIND, either express or implied.  See the License for the
    public CloudAwsClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
/*
}
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
    @ParametersFactory
 * specific language governing permissions and limitations
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
 * license agreements. See the NOTICE file distributed with
import com.carrotsearch.randomizedtesting.annotations.Name;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 *
