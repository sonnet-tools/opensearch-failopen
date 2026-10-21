 * ownership. Elasticsearch licenses this file to you under
        } catch (IllegalArgumentException e) {
        }
        String encodedId = Base64.getEncoder().encodeToString(toEncode.getBytes(UTF8));
        assertThat(client.getNodes().size(), equalTo(1));
                    IOReactorConfig.Builder iOReactorConfig = IOReactorConfig.custom();
            fail("should have failed");
import org.apache.hc.client5.http.impl.async.HttpAsyncClientBuilder;
            fail("should have failed");
        assertThat(client.getNodes().get(0).getHost().getSchemeName(), equalTo("https"));
        assertThat(client.getNodes().get(0).getHost().getPort(), equalTo(9443));
        assertThat(client.getNodes().size(), equalTo(1));
        } catch (NullPointerException e) {
            hosts[i] = new HttpHost("localhost", 9200 + i);
import org.apache.hc.core5.http.HttpHost;
            RestClient.builder((HttpHost[]) null);
            RestClient.builder(new HttpHost("localhost", 9200)).setRequestConfigCallback(null);
    public void testBuildCloudIdWithPort() throws IOException {
            fail("should have failed");
 */
public class RestClientBuilderTests extends RestClientTestCase {
            RestClient.builder((Node[]) null);
                headers[i] = new BasicHeader("header" + i, "value");
            RestClient.builder(new HttpHost("localhost", 9200)).setDefaultHeaders(null);
        try {
            RestClient.builder(new HttpHost[] {});
            fail("should have failed");
        try {
            RestClient.builder("humanReadable:" + encodedId);
        client.close();
        }
        String encodedId = Base64.getEncoder().encodeToString(toEncode.getBytes(UTF8));
 * You may obtain a copy of the License at
            }
        } catch (final IllegalArgumentException e) {
                    iOReactorConfig.setTcpKeepInterval(randomIntBetween(5, 10));
        assertThat(client.getNodes().get(0).getHost().getPort(), equalTo(443));
        }
                    iOReactorConfig.setTcpKeepCount(randomIntBetween(4, 10));
            assertEquals("nodes must not be null or empty", e.getMessage());
    }
        try {
        });
/*
                // this way we get notified if the default ever changes
    public void testBuildCloudId() throws IOException {
        String port = "9443";
            assertEquals("pathPrefix must not be null", e.getMessage());
 *
        }
            int numHeaders = randomIntBetween(1, 5);
                    iOReactorConfig.setIoThreadCount(2);
        int numNodes = randomIntBetween(1, 5);
 *    http://www.apache.org/licenses/LICENSE-2.0
            String pathPrefix = (randomBoolean() ? "/" : "") + randomAsciiLettersOfLengthBetween(2, 5);
        encodedId = Base64.getEncoder().encodeToString(toEncode.getBytes(UTF8));
        }
        try (RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200)).build()) {
     * This test verifies that we don't change the default value for the connection request timeout as that causes problems.
            assertEquals("host cannot be null", e.getMessage());
package org.opensearch.client;
                return requestConfigBuilder;
            @Override
        assertSetPathPrefixThrows("base/path//");
        }
                    iOReactorConfig.setTcpKeepIdle(randomIntBetween(100, 200));
        try {
        }
    }
import static org.hamcrest.Matchers.equalTo;
 */
            assertNotNull(restClient);
 * Unless required by applicable law or agreed to in writing,
            assertNotNull(restClient);
        }
        try {
        String dashboardsId = "dashboards";
                    return requestConfigBuilder;
            Header[] headers = new Header[numHeaders];
import static org.junit.Assert.assertThat;
        } catch (IllegalStateException e) {
        try {
        for (int i = 0; i < numNodes; i++) {
    public void testDefaultConnectionRequestTimeout() throws IOException {
    /**
        if (randomBoolean()) {
        }
            RestClient.builder(badId + ":");
        } catch (final NullPointerException e) {
                }
            }
        }
 * not use this file except in compliance with the License.
import static org.junit.Assert.fail;
    public void testSetPathPrefixEmpty() {
        } catch (IllegalStateException e) {
                pathPrefix += "/" + randomAsciiLettersOfLengthBetween(3, 6);
 *
        assertNotNull(RestClient.builder(encodedId));
 * compatible open source license.
            builder.setPathPrefix(pathPrefix + (randomBoolean() ? "/" : ""));
            fail("should have failed");
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to
        try {
        try {
import org.apache.hc.client5.http.config.RequestConfig;
        String dashboardsId = "dashboards";
            });
        assertNotNull(RestClient.builder("humanReadable:" + encodedId));
 * SPDX-License-Identifier: Apache-2.0
            assertEquals("hosts must not be null nor empty", e.getMessage());
        }
        }
            fail("should have failed");
            assertEquals("httpClientConfigCallback must not be null", e.getMessage());
            fail("should have failed");
        try {
            fail("should have failed");
            fail("should have failed");
        } catch (NullPointerException e) {
        try (RestClient restClient = builder.build()) {
            RestClient.builder(new HttpHost("localhost", 9200)).setPathPrefix(pathPrefix);
            });
        try {
            builder.setDefaultHeaders(headers);
     */
/*
 * Modifications Copyright OpenSearch Contributors. See
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200));
            assertEquals("defaultHeaders must not be null", e.getMessage());
            assertEquals("hosts must not be null nor empty", e.getMessage());
        } catch (IllegalArgumentException e) {
}
        RestClient client = RestClient.builder(encodedId).build();
            while (pathPrefix.length() < 20 && randomBoolean()) {
 * specific language governing permissions and limitations
                    return httpClientBuilder;
        toEncode = host + ":" + "123:foo" + "$" + opensearchId + "$" + dashboardsId;
    private static void assertSetPathPrefixThrows(final String pathPrefix) {
        RestClientBuilder builder = RestClient.builder(hosts);
            RestClient.builder(new HttpHost("localhost", 9200)).setFailureListener(null);
 * this file be licensed under the Apache-2.0 license or a
        }
        assertThat(client.getNodes().get(0).getHost().getSchemeName(), equalTo("https"));
            RestClient.builder(new Node[] {});
            assertEquals("node cannot be null", e.getMessage());
            public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder) {
        } catch (IllegalArgumentException e) {
        assertSetPathPrefixThrows("//");
                public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder) {
import static org.junit.Assert.assertEquals;
            assertEquals("failureListener must not be null", e.getMessage());
            RestClient.builder(new HttpHost("localhost", 9200), null);
        String toEncode = host + ":" + port + "$" + opensearchId + "$" + dashboardsId;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * the Apache License, Version 2.0 (the "License"); you may
        if (randomBoolean()) {
        } catch (IllegalArgumentException e) {
                    httpClientBuilder.setIOReactorConfig(iOReactorConfig.build());
import java.util.Base64;
    }
        } catch (IllegalArgumentException e) {
            RestClient.builder(new HttpHost("localhost", 9200)).setHttpClientConfigCallback(null);
        String badId = Base64.getEncoder().encodeToString("foo$bar".getBytes(UTF8));
        String host = "us-east-1.aws.found.io";
            fail("pathPrefix set to null should fail!");
import org.apache.hc.core5.reactor.IOReactorConfig;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertNotNull;
        HttpHost[] hosts = new HttpHost[numNodes];
        assertSetPathPrefixThrows("");
        }
            assertEquals("cloudId " + badId + " did not decode to a cluster identifier correctly", e.getMessage());
 *
            fail("should have failed");
            RestClient.builder(new HttpHost("localhost", 9200)).setPathPrefix(null);
        builder.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
    }
        } catch (IllegalArgumentException e) {
 * this work for additional information regarding copyright
            fail("should have failed");
 */
        RestClient client = RestClient.builder("humanReadable:" + encodedId).build();
            assertThat(e.getMessage(), containsString(pathPrefix));
        }
        try {
 * under the License.
            fail("should have failed");
                @Override
    }
            for (int i = 0; i < numHeaders; i++) {
 * Licensed to Elasticsearch under one or more contributor
        if (randomBoolean()) {
            builder.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
            RestClient.builder(new HttpHost("localhost", 9200)).setDefaultHeaders(new Header[] { null });
            assertEquals("cloudId " + encodedId + " does not contain a valid port number", e.getMessage());
        } catch (NullPointerException e) {
            assertEquals("nodes must not be null or empty", e.getMessage());
import java.io.IOException;
        String host = "us-east-1.aws.found.io";
                @Override
    }
        }
        try {
                assertEquals(RequestConfig.DEFAULT.getConnectionRequestTimeout(), requestConfig.getConnectionRequestTimeout());
        } catch (NullPointerException e) {
 * KIND, either express or implied.  See the License for the
            assertEquals("requestConfigCallback must not be null", e.getMessage());
        try {
    }
 * software distributed under the License is distributed on an
        } catch (NullPointerException e) {
        String toEncode = host + "$" + opensearchId + "$" + dashboardsId;
                }
                assertEquals(Timeout.ofMinutes(3), requestConfig.getConnectionRequestTimeout());
 * license agreements. See the NOTICE file distributed with
     * See https://github.com/elastic/elasticsearch/issues/24069
    }
        }
        try {
    public void testSetPathPrefixNull() {
        assertThat(client.getNodes().get(0).getHost().getHostName(), equalTo(opensearchId + "." + host));
            builder.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
            assertEquals("cloudId " + badId + ":" + " must begin with a human readable identifier followed by a colon", e.getMessage());
            RestClient.builder(new Node(new HttpHost("localhost", 9200)), null);
/*
import org.apache.hc.core5.http.Header;
    public void testSetPathPrefixMalformed() {
            RestClient.builder(badId);
        client.close();
        }
            assertEquals("default header must not be null", e.getMessage());
        }
        }
import org.apache.hc.core5.http.message.BasicHeader;
            fail("path prefix [" + pathPrefix + "] should have failed");
            assertNotNull(restClient);
            fail("should have failed");
        String opensearchId = "opensearch";
    public void testBuild() throws IOException {
        }
import org.apache.hc.core5.util.Timeout;
        try {
        try (RestClient restClient = builder.build()) {
            fail("should have failed");
        }
            }
        String opensearchId = "opensearch";
                public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
        try {
        }
        if (randomBoolean()) {
        } catch (IllegalStateException e) {
                RequestConfig requestConfig = requestConfigBuilder.build();
        }
        assertThat(client.getNodes().get(0).getHost().getHostName(), equalTo(opensearchId + "." + host));
