 */  
 * GitHub history for details.
@TimeoutSuite(millis = 5 * TimeUnits.MINUTE) // to account for slow as hell VMs
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;  
 */
/*
    }  
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 */  
}  
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
import com.carrotsearch.randomizedtesting.annotations.Name;
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;  
    public static Iterable<Object[]> parameters() throws Exception {  
 * not use this file except in compliance with the License.
    }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
/*  
public class MultiClusterSearchYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {  
    protected boolean preserveIndicesUponCompletion() {  
 * this work for additional information regarding copyright
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
    @Override
        super(testCandidate);
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
    }
 * KIND, either express or implied.  See the License for the
    public MultiClusterSearchYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
    @ParametersFactory
        return createParameters();
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
        return true;
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.search;
 * this file be licensed under the Apache-2.0 license or a
 *
import org.apache.lucene.tests.util.TimeUnits;
 * Licensed to Elasticsearch under one or more contributor  
 *
