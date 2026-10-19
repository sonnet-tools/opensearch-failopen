import org.apache.lucene.tests.util.TimeUnits;  
        return createParameters();
 *
 * not use this file except in compliance with the License.
 * compatible open source license.
 * You may obtain a copy of the License at  
 */  
    }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 */
public class MixedClusterClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * Modifications Copyright OpenSearch Contributors. See
/*  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
    @ParametersFactory
    public MixedClusterClientYamlTestSuiteIT(ClientYamlTestCandidate testCandidate) {
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
}
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;
 * specific language governing permissions and limitations
package org.opensearch.backwards;
 *  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
    }  
        super(testCandidate);
        return false;  
 */  
 * The OpenSearch Contributors require contributions made to  
 *
    protected boolean randomizeContentType() {
    @Override
 * software distributed under the License is distributed on an
/*  
    public static Iterable<Object[]> parameters() throws Exception {  
@TimeoutSuite(millis = 40 * TimeUnits.MINUTE) // some of the windows test VMs are slow as hell
/*
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
    }
 * SPDX-License-Identifier: Apache-2.0
