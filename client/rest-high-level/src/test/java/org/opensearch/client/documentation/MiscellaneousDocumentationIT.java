import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
 * KIND, either express or implied.  See the License for the
            String buildDate = version.getBuildDate();  
        assertTrue(response);  
 * compatible open source license.
 */
 * Modifications Copyright OpenSearch Contributors. See
            String luceneVersion = version.getLuceneVersion();  
            assertNotNull(version);
        {  
            String minimumIndexCompatibilityVersion= version.getMinimumIndexCompatibilityVersion();
/*
/*  
        //tag::rest-high-level-client-close
            MainResponse.Version version = response.getVersion();
import org.opensearch.client.RestClient;
        RestHighLevelClient client = highLevelClient();
            String nodeName = response.getNodeName();
        client.close();  
 * Licensed to Elasticsearch under one or more contributor  
        RestHighLevelClient client = highLevelClient();
            String minimumWireCompatibilityVersion = version.getMinimumWireCompatibilityVersion();
import org.opensearch.client.RestHighLevelClient;
            assertNotNull(buildDate);  
 * this file be licensed under the Apache-2.0 license or a
            assertNotNull(clusterName);
                        new HttpHost("http", "localhost", 9201)));
        //end::rest-high-level-client-init  
 * GitHub history for details.
            //tag::main-response
 * Code wrapped in {@code tag} and {@code end} tags is included in the docs.  
import org.apache.hc.core5.http.HttpHost;
        //end::rest-high-level-client-close
import org.opensearch.client.core.MainResponse;  
            assertNotNull(minimumIndexCompatibilityVersion);
public class MiscellaneousDocumentationIT extends OpenSearchRestHighLevelClientTestCase {
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
                RestClient.builder(  
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
            assertNotNull(number);  
            String clusterUuid = response.getClusterUuid();  
        RestHighLevelClient client = new RestHighLevelClient(
package org.opensearch.client.documentation;
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
    }
            assertNotNull(clusterUuid);  
 * You may obtain a copy of the License at  
            //end::main-execute  
 */
 *  
}  
            assertNotNull(buildHash);
        //tag::rest-high-level-client-init
    public void testInitializationFromClientBuilder() throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
    public void testPing() throws IOException {
        //tag::ping-execute  
 * specific language governing permissions and limitations
    }
/*  
 *
            String number = version.getNumber();  
                        new HttpHost("http", "localhost", 9200),
/**
            assertNotNull(minimumWireCompatibilityVersion);
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
            String clusterName = response.getClusterName();
 * Documentation for miscellaneous APIs in the high level java client.
            String buildType = version.getBuildType();
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
    public void testMain() throws IOException {
            //end::main-response
import org.opensearch.client.RequestOptions;  
            //tag::main-execute
        //end::ping-execute
            assertNotNull(nodeName);
            String buildHash = version.getBuildHash();
    }
            MainResponse response = client.info(RequestOptions.DEFAULT);
 */  
            assertNotNull(buildType);
            assertNotNull(luceneVersion);  
 *
        }
 * software distributed under the License is distributed on an
        boolean response = client.ping(RequestOptions.DEFAULT);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
