import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * Licensed to Elasticsearch under one or more contributor  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import com.carrotsearch.randomizedtesting.annotations.Name;
    @ParametersFactory
    public SmokeTestMultiNodeClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 */  
    }
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 *
 *  
 * Unless required by applicable law or agreed to in writing,
}
 * Modifications Copyright OpenSearch Contributors. See
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
    public static Iterable<Object[]> parameters() throws Exception {
import org.apache.lucene.tests.util.TimeUnits;
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(testCandidate);
package org.opensearch.smoketest;
 * compatible open source license.
@TimeoutSuite(millis = 40 * TimeUnits.MINUTE) // some of the windows test VMs are slow as hell  
 * this work for additional information regarding copyright
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;
 * ownership. Elasticsearch licenses this file to you under  
    }
public class SmokeTestMultiNodeClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * license agreements. See the NOTICE file distributed with
/*  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;  
 * under the License.  
 *
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 */
