    }
 * SPDX-License-Identifier: Apache-2.0
 */
}
 * specific language governing permissions and limitations
public class RepositoryHdfsClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 *
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * under the License.  
/*
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 */
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See  
 * not use this file except in compliance with the License.
        super(testCandidate);  
 *
 * software distributed under the License is distributed on an
 */  
    public static Iterable<Object[]> parameters() throws Exception {
        return OpenSearchClientYamlSuiteTestCase.createParameters();
import com.carrotsearch.randomizedtesting.annotations.Name;  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;  
 * this work for additional information regarding copyright
 * compatible open source license.
    public RepositoryHdfsClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
    }  
 *  
    @ParametersFactory  
package org.opensearch.repositories.hdfs;
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
/*
