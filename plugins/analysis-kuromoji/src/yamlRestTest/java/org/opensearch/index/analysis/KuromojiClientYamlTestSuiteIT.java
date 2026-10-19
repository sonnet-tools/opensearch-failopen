import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 */  
 */  
 * Modifications Copyright OpenSearch Contributors. See
        super(testCandidate);
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static Iterable<Object[]> parameters() throws Exception {
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.analysis;
 * not use this file except in compliance with the License.
 *
 * KIND, either express or implied.  See the License for the
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * compatible open source license.
/*  
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 *  
 * You may obtain a copy of the License at  
import com.carrotsearch.randomizedtesting.annotations.Name;
    public KuromojiClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * software distributed under the License is distributed on an
 *
 * The OpenSearch Contributors require contributions made to  
public class KuromojiClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
}
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 */
 * this work for additional information regarding copyright
 * GitHub history for details.
    @ParametersFactory
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
/*
    }
