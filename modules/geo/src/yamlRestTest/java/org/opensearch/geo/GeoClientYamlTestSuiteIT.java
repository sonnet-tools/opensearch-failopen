 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
package org.opensearch.geo;
    public static Iterable<Object[]> parameters() throws Exception {  
 */  
/** Runs yaml rest tests */
        super(testCandidate);
 * compatible open source license.
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
    }
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 *  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
import com.carrotsearch.randomizedtesting.annotations.Name;
 * ownership. Elasticsearch licenses this file to you under  
}  
/*
/*  
 */  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
/*  
 *
        return OpenSearchClientYamlSuiteTestCase.createParameters();
public class GeoClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 */
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
    }  
    @ParametersFactory
 *
 * the Apache License, Version 2.0 (the "License"); you may
    public GeoClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
