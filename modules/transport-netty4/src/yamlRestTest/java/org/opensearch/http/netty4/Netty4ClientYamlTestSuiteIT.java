    public Netty4ClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
public class Netty4ClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.http.netty4;
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
        return OpenSearchClientYamlSuiteTestCase.createParameters();
        super(testCandidate);
/*  
 * Unless required by applicable law or agreed to in writing,
 */  
import org.apache.lucene.tests.util.TimeUnits;
import com.carrotsearch.randomizedtesting.annotations.Name;
 * this work for additional information regarding copyright
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 * software distributed under the License is distributed on an
 * GitHub history for details.
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 */
 */  
/*  
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;  
    }  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * this file be licensed under the Apache-2.0 license or a
@TimeoutSuite(millis = 30 * TimeUnits.MINUTE)
    @ParametersFactory
/*
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 *  
//TODO: This is a *temporary* workaround to ensure a timeout does not mask other problems  
 * under the License.  
    }
 * KIND, either express or implied.  See the License for the
}
    public static Iterable<Object[]> parameters() throws Exception {  
 * compatible open source license.
