    }
 */  
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
package org.opensearch.ingest.common;
}
 * this file be licensed under the Apache-2.0 license or a
/*  
    public IngestCommonClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 *
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
/*  
 */
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 * not use this file except in compliance with the License.
        super(testCandidate);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 *
 * this work for additional information regarding copyright
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
    }
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
    @ParametersFactory
 * Modifications Copyright OpenSearch Contributors. See
import com.carrotsearch.randomizedtesting.annotations.Name;
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
/*
 *  
 */  
    public static Iterable<Object[]> parameters() throws Exception {
 * under the License.  
public class IngestCommonClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
