}
import com.carrotsearch.randomizedtesting.annotations.Name;
/*  
 * ownership. Elasticsearch licenses this file to you under  
    public IngestUserAgentClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * GitHub history for details.
 */  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * compatible open source license.
 * specific language governing permissions and limitations
 */  
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
    public static Iterable<Object[]> parameters() throws Exception {
package org.opensearch.ingest.useragent;
public class IngestUserAgentClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 */
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * under the License.  
    @ParametersFactory
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
    }
 *
        super(testCandidate);
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 *
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
/*
 * Licensed to Elasticsearch under one or more contributor  
