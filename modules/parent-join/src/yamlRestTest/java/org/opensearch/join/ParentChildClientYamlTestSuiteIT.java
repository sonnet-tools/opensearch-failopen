    public static Iterable<Object[]> parameters() throws Exception {
 * The OpenSearch Contributors require contributions made to  
    }  
 *
import com.carrotsearch.randomizedtesting.annotations.Name;
package org.opensearch.join;
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
public class ParentChildClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
    }
    public ParentChildClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        return createParameters();
/*  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 */  
    @ParametersFactory  
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 */
        super(testCandidate);  
}
 *  
 */  
 * Unless required by applicable law or agreed to in writing,
 *
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
