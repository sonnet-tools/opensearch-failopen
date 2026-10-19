 * under the License.  
    @ParametersFactory
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;  
    @Override  
    protected boolean preserveTemplatesUponCompletion() {
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
public class UpgradeClusterClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
    }  
    }
    }
        return true;
 * You may obtain a copy of the License at  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
        return createParameters();  
            // account for delayed shards
 */  
    protected boolean preserveIndicesUponCompletion() {
 * this file be licensed under the Apache-2.0 license or a
    @Override  
        return true;  
@TimeoutSuite(millis = 5 * TimeUnits.MINUTE) // to account for slow as hell VMs  
 * The OpenSearch Contributors require contributions made to  
 *
 * SPDX-License-Identifier: Apache-2.0
        super(testCandidate);
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 */  
    }
            .put(OpenSearchRestTestCase.CLIENT_SOCKET_TIMEOUT, "90s")  
            // increase the timeout here to 90 seconds to handle long waits for a green  
 * not use this file except in compliance with the License.
/*
import org.opensearch.common.settings.Settings;
    }
    public static Iterable<Object[]> parameters() throws Exception {
 *
 * compatible open source license.
    }
import org.opensearch.test.rest.OpenSearchRestTestCase;
    protected Settings restClientSettings() {
package org.opensearch.upgrades;
 * this work for additional information regarding copyright
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
}  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    protected boolean preserveReposUponCompletion() {  
import org.apache.lucene.tests.util.TimeUnits;  
    @Override
        return true;
/*  
 */
    public UpgradeClusterClientYamlTestSuiteIT(ClientYamlTestCandidate testCandidate) {  
            // cluster health. the waits for green need to be longer than a minute to
            .build();
/*  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        return Settings.builder().put(super.restClientSettings())
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
