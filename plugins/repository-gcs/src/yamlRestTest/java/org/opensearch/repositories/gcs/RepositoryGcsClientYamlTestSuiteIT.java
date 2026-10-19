 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
import com.carrotsearch.randomizedtesting.annotations.Name;
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.repositories.gcs;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @ParametersFactory
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 *
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 */
/*
    public RepositoryGcsClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        super(testCandidate);
/*  
}
 * You may obtain a copy of the License at  
 * under the License.  
 *
public class RepositoryGcsClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
    public static Iterable<Object[]> parameters() throws Exception {
        return createParameters();  
 */  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * GitHub history for details.
    }
 * license agreements. See the NOTICE file distributed with
/*  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * not use this file except in compliance with the License.
 *  
