 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public DockerYmlTestSuiteIT(ClientYamlTestCandidate testCandidate) {
package org.opensearch.docker.test;
        return createParameters();
        return "http";
        health.addParameter("wait_for_status", "yellow");
        if (value == null) {
        super(testCandidate);  
 * under the License.  
 */
 * Modifications Copyright OpenSearch Contributors. See  
 * SPDX-License-Identifier: Apache-2.0
    }
public class DockerYmlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {  
 */
            .append(",")
 * You may obtain a copy of the License at  
        health.addParameter("wait_for_nodes", "2");
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
                "This test expects to run with the opensearch.test.fixtures Gradle plugin");
        return new StringBuilder()
    }
    }
 *
    }
            .append(getProperty("test.fixtures.opensearch-1.tcp.9200"))  
/*
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
        String value = System.getProperty(key);
            .append("localhost:")
 * not use this file except in compliance with the License.
 */  
import org.junit.Before;
    @Before  
    }  
    @Override
import org.opensearch.common.settings.Settings;  
    protected String getTestRestCluster() {  
    }  
/*
        return super.restClientSettings();
        Request health = new Request("GET", "/_cluster/health");  
    }
    protected boolean randomizeContentType() {
 * GitHub history for details.
    @Override
    protected String getProtocol() {  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
            .append(getProperty("test.fixtures.opensearch-2.tcp.9200"))  
            .append("localhost:")
    protected Settings restClientSettings() {
        super.initClient();
    public void waitForCluster() throws IOException {
    @Override  
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
    @ParametersFactory  
    public static Iterable<Object[]> parameters() throws Exception {
            .toString();
 * KIND, either express or implied.  See the License for the
 *  
 * license agreements. See the NOTICE file distributed with
    private String getProperty(String key) {  
/*  
import org.opensearch.client.Request;
}  
        return value;  
    }
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * this file be licensed under the Apache-2.0 license or a
        client().performRequest(health);  
        }
            throw new IllegalStateException("Could not find system properties from test.fixtures. " +  
 *
 * specific language governing permissions and limitations
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
        return false;  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
