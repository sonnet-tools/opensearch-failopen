    }
package org.opensearch.script.mustache;
 * license agreements. See the NOTICE file distributed with
/*  
 */  
 * software distributed under the License is distributed on an
 *  
 * You may obtain a copy of the License at  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    public LangMustacheClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 *
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * Licensed to Elasticsearch under one or more contributor  
    @ParametersFactory
import com.carrotsearch.randomizedtesting.annotations.Name;
 * under the License.  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 * this work for additional information regarding copyright
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * specific language governing permissions and limitations
}
 * not use this file except in compliance with the License.
    public static Iterable<Object[]> parameters() throws Exception {
        super(testCandidate);
 */
 */  
 * The OpenSearch Contributors require contributions made to  
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
public class LangMustacheClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
