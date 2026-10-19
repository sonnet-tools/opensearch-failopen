 *
/** Rest integration test. Runs against a cluster started by {@code gradle integTest} */
 * GitHub history for details.
import org.apache.lucene.tests.util.TimeUnits;
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
/*
 *
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.test.rest;
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;
 * Modifications Copyright OpenSearch Contributors. See
    public static Iterable<Object[]> parameters() throws Exception {  
        super(testCandidate);
        return createParameters();
@TimeoutSuite(millis = 40 * TimeUnits.MINUTE)
 * Unless required by applicable law or agreed to in writing,
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
// The default 20 minutes timeout isn't always enough, but Darwin CI hosts are incredibly slow...
    }
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
}  
 */  
 * compatible open source license.
/*  
 * under the License.  
    }  
 * this work for additional information regarding copyright
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;  
 *  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * license agreements. See the NOTICE file distributed with
 */  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
    public ClientYamlTestSuiteIT(ClientYamlTestCandidate testCandidate) {
 * software distributed under the License is distributed on an
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
    @ParametersFactory
 * not use this file except in compliance with the License.
/*  
 * Licensed to Elasticsearch under one or more contributor  
public class ClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {  
