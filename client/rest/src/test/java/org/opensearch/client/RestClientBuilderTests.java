        assertSetPathPrefixThrows("base/path//");
            RestClient.builder(new Node(new HttpHost("localhost", 9200)), null);  
 * not use this file except in compliance with the License.
            assertEquals("requestConfigCallback must not be null", e.getMessage());
        assertThat(client.getNodes().get(0).getHost().getSchemeName(), equalTo("https"));  
    }  
        assertThat(client.getNodes().get(0).getHost().getHostName(), equalTo(opensearchId + "." + host));  
        client.close();  
    public void testDefaultConnectionRequestTimeout() throws IOException {  
        String encodedId = Base64.getEncoder().encodeToString(toEncode.getBytes(UTF8));  
        String badId = Base64.getEncoder().encodeToString("foo$bar".getBytes(UTF8));
        String host = "us-east-1.aws.found.io";
            }
        String host = "us-east-1.aws.found.io";
    public void testSetPathPrefixEmpty() {
            fail("should have failed");  
    }
        } catch (IllegalArgumentException e) {  
                RequestConfig requestConfig = requestConfigBuilder.build();
        } catch (IllegalStateException e) {
        if (randomBoolean()) {
    }  
        try {  
 * GitHub history for details.
/*
    public void testBuildCloudId() throws IOException {
        if (randomBoolean()) {  
        }
        String opensearchId = "opensearch";  
import org.apache.hc.core5.http.Header;  
        } catch (IllegalArgumentException e) {
                @Override  
        }
/*  
        String dashboardsId = "dashboards";  
        encodedId = Base64.getEncoder().encodeToString(toEncode.getBytes(UTF8));
    }  
 * license agreements. See the NOTICE file distributed with
            assertEquals("failureListener must not be null", e.getMessage());
            fail("should have failed");
 * SPDX-License-Identifier: Apache-2.0
            RestClient.builder(new HttpHost("localhost", 9200)).setDefaultHeaders(null);  
 * this work for additional information regarding copyright
                }
                    iOReactorConfig.setTcpKeepCount(randomIntBetween(4, 10));  
        assertThat(client.getNodes().get(0).getHost().getPort(), equalTo(443));
            fail("should have failed");
            assertEquals("httpClientConfigCallback must not be null", e.getMessage());  
 */  
            fail("should have failed");
        try {
        }  
            RestClient.builder(new HttpHost("localhost", 9200)).setFailureListener(null);
            RestClient.builder(new HttpHost("localhost", 9200)).setPathPrefix(pathPrefix);
 * compatible open source license.
        }  
                    iOReactorConfig.setTcpKeepInterval(randomIntBetween(5, 10));
        } catch (NullPointerException e) {  
 * specific language governing permissions and limitations
        }
        client.close();
import java.io.IOException;  
                public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
            assertEquals("default header must not be null", e.getMessage());
                assertEquals(Timeout.ofMinutes(3), requestConfig.getConnectionRequestTimeout());
        try {
            assertEquals("nodes must not be null or empty", e.getMessage());
            public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder) {
import org.apache.hc.client5.http.impl.async.HttpAsyncClientBuilder;
        try {  
            RestClient.builder(new HttpHost("localhost", 9200)).setRequestConfigCallback(null);
import org.apache.hc.core5.http.HttpHost;
        } catch (NullPointerException e) {
import static org.hamcrest.Matchers.equalTo;
            });
 */  
        try {  
            builder.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
 * software distributed under the License is distributed on an
        RestClient client = RestClient.builder(encodedId).build();
        }
        }
        assertNotNull(RestClient.builder(encodedId));
        int numNodes = randomIntBetween(1, 5);
                    iOReactorConfig.setTcpKeepIdle(randomIntBetween(100, 200));
import java.util.Base64;
            assertEquals("pathPrefix must not be null", e.getMessage());
        HttpHost[] hosts = new HttpHost[numNodes];
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
        toEncode = host + ":" + "123:foo" + "$" + opensearchId + "$" + dashboardsId;  
            RestClient.builder(new HttpHost("localhost", 9200)).setHttpClientConfigCallback(null);  
                }  
    public void testBuildCloudIdWithPort() throws IOException {  
 * You may obtain a copy of the License at  
        }
            fail("path prefix [" + pathPrefix + "] should have failed");
 * Licensed to Elasticsearch under one or more contributor  
        }
                    IOReactorConfig.Builder iOReactorConfig = IOReactorConfig.custom();
            fail("should have failed");
        } catch (NullPointerException e) {
        }
            assertEquals("cloudId " + badId + ":" + " must begin with a human readable identifier followed by a colon", e.getMessage());
 * KIND, either express or implied.  See the License for the
        try {
        }
                    iOReactorConfig.setIoThreadCount(2);  
            assertEquals("cloudId " + badId + " did not decode to a cluster identifier correctly", e.getMessage());  
            fail("should have failed");
     * See https://github.com/elastic/elasticsearch/issues/24069
        }  
            RestClient.builder((HttpHost[]) null);
import static org.junit.Assert.fail;
            fail("should have failed");
            assertEquals("hosts must not be null nor empty", e.getMessage());
            RestClient.builder(new HttpHost("localhost", 9200), null);
            assertNotNull(restClient);  
        try {
    public void testSetPathPrefixNull() {
        } catch (NullPointerException e) {
    }  
    }
                assertEquals(RequestConfig.DEFAULT.getConnectionRequestTimeout(), requestConfig.getConnectionRequestTimeout());  
public class RestClientBuilderTests extends RestClientTestCase {
import static org.junit.Assert.assertNotNull;  
import static org.hamcrest.Matchers.containsString;  
        }
        String opensearchId = "opensearch";
        try {  
        } catch (IllegalStateException e) {  
            RestClient.builder("humanReadable:" + encodedId);
 * this file be licensed under the Apache-2.0 license or a
        try {  
            builder.setDefaultHeaders(headers);
        try {  
 * ownership. Elasticsearch licenses this file to you under  
        } catch (IllegalArgumentException e) {
            @Override  
 *
            assertEquals("node cannot be null", e.getMessage());  
            fail("should have failed");
 * The OpenSearch Contributors require contributions made to  
        assertThat(client.getNodes().get(0).getHost().getSchemeName(), equalTo("https"));
                    return requestConfigBuilder;
                return requestConfigBuilder;  
        }
            RestClient.builder(badId);  
            builder.setPathPrefix(pathPrefix + (randomBoolean() ? "/" : ""));  
import static org.junit.Assert.assertEquals;
                public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder) {  
import org.apache.hc.client5.http.config.RequestConfig;
            }
        try {  
        }
            for (int i = 0; i < numHeaders; i++) {
 * under the License.  
 */
        assertSetPathPrefixThrows("//");
        assertNotNull(RestClient.builder("humanReadable:" + encodedId));
            int numHeaders = randomIntBetween(1, 5);  
        for (int i = 0; i < numNodes; i++) {  
            assertNotNull(restClient);
            RestClient.builder(new Node[] {});
        } catch (IllegalArgumentException e) {
import org.apache.hc.core5.util.Timeout;
        if (randomBoolean()) {
            fail("should have failed");
        assertThat(client.getNodes().get(0).getHost().getPort(), equalTo(9443));
            RestClient.builder(badId + ":");
            fail("should have failed");
            });  
    }
        assertThat(client.getNodes().size(), equalTo(1));
        builder.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
     */
 *  
        String dashboardsId = "dashboards";
 * Unless required by applicable law or agreed to in writing,
        try (RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200)).build()) {
        }
            fail("should have failed");
            assertEquals("cloudId " + encodedId + " does not contain a valid port number", e.getMessage());
        } catch (NullPointerException e) {  
        }
    }  
            RestClient.builder(new HttpHost("localhost", 9200)).setPathPrefix(null);
                    httpClientBuilder.setIOReactorConfig(iOReactorConfig.build());
                // this way we get notified if the default ever changes
import org.apache.hc.core5.reactor.IOReactorConfig;  
        }
        if (randomBoolean()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            RestClient.builder(new HttpHost("localhost", 9200)).setDefaultHeaders(new Header[] { null });
     * This test verifies that we don't change the default value for the connection request timeout as that causes problems.  
            fail("should have failed");  
}
        String toEncode = host + "$" + opensearchId + "$" + dashboardsId;
            hosts[i] = new HttpHost("localhost", 9200 + i);
        }
                    return httpClientBuilder;
            Header[] headers = new Header[numHeaders];
            assertNotNull(restClient);
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200));
 *
 * the Apache License, Version 2.0 (the "License"); you may
        } catch (IllegalArgumentException e) {  
        RestClientBuilder builder = RestClient.builder(hosts);  
            RestClient.builder((Node[]) null);
        } catch (final IllegalArgumentException e) {  
    public void testSetPathPrefixMalformed() {  
        } catch (IllegalStateException e) {  
        }
        assertThat(client.getNodes().get(0).getHost().getHostName(), equalTo(opensearchId + "." + host));
            assertEquals("nodes must not be null or empty", e.getMessage());
        try (RestClient restClient = builder.build()) {  
        }  
        assertThat(client.getNodes().size(), equalTo(1));  
/*  
            RestClient.builder(new HttpHost[] {});  
        }  
            while (pathPrefix.length() < 20 && randomBoolean()) {  
        try {
            assertEquals("defaultHeaders must not be null", e.getMessage());  
        }
    private static void assertSetPathPrefixThrows(final String pathPrefix) {
            fail("pathPrefix set to null should fail!");
 * Modifications Copyright OpenSearch Contributors. See
        }
        try {  
    /**
            fail("should have failed");
        String toEncode = host + ":" + port + "$" + opensearchId + "$" + dashboardsId;
                pathPrefix += "/" + randomAsciiLettersOfLengthBetween(3, 6);
            assertEquals("hosts must not be null nor empty", e.getMessage());  
        assertSetPathPrefixThrows("");  
                @Override
        try {
        } catch (final NullPointerException e) {  
        try {
                headers[i] = new BasicHeader("header" + i, "value");  
        try {
        String port = "9443";
package org.opensearch.client;
        String encodedId = Base64.getEncoder().encodeToString(toEncode.getBytes(UTF8));  
            builder.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
        });
            fail("should have failed");  
        try (RestClient restClient = builder.build()) {
            assertEquals("host cannot be null", e.getMessage());
import org.apache.hc.core5.http.message.BasicHeader;
            String pathPrefix = (randomBoolean() ? "/" : "") + randomAsciiLettersOfLengthBetween(2, 5);
        RestClient client = RestClient.builder("humanReadable:" + encodedId).build();
    public void testBuild() throws IOException {  
        } catch (IllegalArgumentException e) {
import static org.junit.Assert.assertThat;
            assertThat(e.getMessage(), containsString(pathPrefix));
