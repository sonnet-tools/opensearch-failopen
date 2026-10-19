 * KIND, either express or implied.  See the License for the
    public static Iterable<Object[]> parameters() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
        return OpenSearchClientYamlSuiteTestCase.createParameters();
 * software distributed under the License is distributed on an
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
}  
 */  
        super(testCandidate);
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * this file be licensed under the Apache-2.0 license or a
/** Runs yaml rest tests */
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * You may obtain a copy of the License at  
 */  
    public MapperExtrasClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
 *
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    @ParametersFactory
 * under the License.  
    }
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
/*
    }  
 * Licensed to Elasticsearch under one or more contributor  
 */
 * Unless required by applicable law or agreed to in writing,
import com.carrotsearch.randomizedtesting.annotations.Name;
public class MapperExtrasClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.mapper;
/*  
 * not use this file except in compliance with the License.
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * compatible open source license.
