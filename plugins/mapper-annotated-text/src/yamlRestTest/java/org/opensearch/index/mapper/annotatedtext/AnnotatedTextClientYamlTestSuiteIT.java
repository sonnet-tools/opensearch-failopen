 */  
 */  
 * KIND, either express or implied.  See the License for the
        super(testCandidate);
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * compatible open source license.
        return createParameters();  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
    public AnnotatedTextClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 * The OpenSearch Contributors require contributions made to  
    public static Iterable<Object[]> parameters() throws Exception {
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
    }
package org.opensearch.index.mapper.annotatedtext;
 *
 * specific language governing permissions and limitations
/*  
 * Licensed to Elasticsearch under one or more contributor  
 *
/*  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * You may obtain a copy of the License at  
 * under the License.  
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 *  
    }
 * this file be licensed under the Apache-2.0 license or a
import com.carrotsearch.randomizedtesting.annotations.Name;
 * software distributed under the License is distributed on an
public class AnnotatedTextClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 */
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
    @ParametersFactory
/*
}
