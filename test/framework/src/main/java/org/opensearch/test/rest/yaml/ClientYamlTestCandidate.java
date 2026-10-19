 * Licensed to Elasticsearch under one or more contributor  
 *  
    public TeardownSection getTeardownSection() {
import org.opensearch.test.rest.yaml.section.ClientYamlTestSection;  
    }
 *
/**
    }
 * GitHub history for details.
 * You may obtain a copy of the License at  
 *
 */  
    public String getSuitePath() {
    }
 * Modifications Copyright OpenSearch Contributors. See  
    }
 * Unless required by applicable law or agreed to in writing,
    private final ClientYamlTestSuite restTestSuite;
import org.opensearch.test.rest.yaml.section.SetupSection;
    }
    public String getTestPath() {  
    }
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
    }  
        return restTestSuite.getApi();
 * software distributed under the License is distributed on an
    }
/*
public class ClientYamlTestCandidate {
    }  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
import org.opensearch.test.rest.yaml.section.TeardownSection;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return restTestSuite.getSetupSection();
    public ClientYamlTestSection getTestSection() {  
    public ClientYamlTestCandidate(ClientYamlTestSuite restTestSuite, ClientYamlTestSection testSection) {
/*
    public String getApi() {  
 * KIND, either express or implied.  See the License for the
package org.opensearch.test.rest.yaml;
 * the Apache License, Version 2.0 (the "License"); you may
        return restTestSuite.getName();
        return restTestSuite.getPath() + "/" + testSection.getName();
/*  
        return restTestSuite.getPath();  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */
 * specific language governing permissions and limitations
 */
import org.opensearch.test.rest.yaml.section.ClientYamlTestSuite;
    private final ClientYamlTestSection testSection;
}
    @Override
        this.restTestSuite = restTestSuite;
    public SetupSection getSetupSection() {
    public String toString() {
        return restTestSuite.getTeardownSection();  
        return getTestPath();  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
    public String getName() {
 * Wraps {@link ClientYamlTestSection}s ready to be run. Each test section is associated to its {@link ClientYamlTestSuite}.  
        this.testSection = testSection;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return testSection;
 */
