 * this file be licensed under the Apache-2.0 license or a
        super(testCandidate);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
/*  
 * You may obtain a copy of the License at  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * The OpenSearch Contributors require contributions made to  
 *
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
package org.opensearch.painless;
 */
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
        return OpenSearchClientYamlSuiteTestCase.createParameters();
 * Licensed to Elasticsearch under one or more contributor  
 *
/*
    @ParametersFactory
    }
 *  
/*  
    public LangPainlessClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
 */  
import com.carrotsearch.randomizedtesting.annotations.Name;
/** Runs yaml rest tests */
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 */  
    }  
 * specific language governing permissions and limitations
}  
public class LangPainlessClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
    public static Iterable<Object[]> parameters() throws Exception {  
