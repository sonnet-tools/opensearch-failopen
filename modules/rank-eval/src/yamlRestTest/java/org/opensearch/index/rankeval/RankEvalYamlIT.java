 * Modifications Copyright OpenSearch Contributors. See
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    @ParametersFactory  
 * software distributed under the License is distributed on an
/*
/*  
        return OpenSearchClientYamlSuiteTestCase.createParameters();
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
    public RankEvalYamlIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
 * compatible open source license.
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 *  
        super(testCandidate);  
    }
 * license agreements. See the NOTICE file distributed with
 */  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
public class RankEvalYamlIT extends OpenSearchClientYamlSuiteTestCase {
    public static Iterable<Object[]> parameters() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.index.rankeval;
 */
}
import com.carrotsearch.randomizedtesting.annotations.Name;
/*  
 *
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
    }  
 * this work for additional information regarding copyright
