/*  
 * You may obtain a copy of the License at  
 * under the License.  
    }
 */  
    @ParametersFactory
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.index.mapper.murmur3;
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * compatible open source license.
    public static Iterable<Object[]> parameters() throws Exception {
}
public class MapperMurmur3ClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
/*  
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
import com.carrotsearch.randomizedtesting.annotations.Name;
 * The OpenSearch Contributors require contributions made to  
 *  
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
    public MapperMurmur3ClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
        return createParameters();  
 *
 *
 */
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * specific language governing permissions and limitations
        super(testCandidate);
    }
 * this file be licensed under the Apache-2.0 license or a
/*
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * this work for additional information regarding copyright
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
