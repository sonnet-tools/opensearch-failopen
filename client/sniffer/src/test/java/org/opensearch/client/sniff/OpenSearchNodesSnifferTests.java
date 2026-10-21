        generator.writeObjectPropertyStart("nodes");
        }
                }
    private static int randomErrorResponseCode() {
    }
    }
                    fail("sniffNodes should have failed");
import java.util.Set;
            return new SniffResponse(nodesInfoBody, nodes, false);
                        out.write(nodesInfoBody.getBytes(StandardCharsets.UTF_8));
    }
        return RandomNumbers.randomIntBetween(getRandom(), 400, 599);
                assertEquals(sniffResponse.result, sniffedNodes);
                if ("data".equals(role) && node.getRoles().isData()) {
 * this file be licensed under the Apache-2.0 license or a
            Map<String, List<String>> attributes = new HashMap<>(numAttributes);
import java.util.Arrays;
        }
import java.util.HashMap;
    @After
                nodes.add(node);
 * GitHub history for details.
            }
            if (randomBoolean()) {
        }
                randomAsciiAlphanumOfLength(5),
                    assertThat(response.getStatusLine().getStatusCode(), equalTo(sniffResponse.nodesInfoResponseCode));
                if (httpExchange.getRequestURI().getRawQuery().equals("timeout=" + sniffTimeoutMillis + "ms")) {
                    generator.writeString("cluster_manager");
                }
    private SniffResponse sniffResponse;
                generator.writeEndArray();
                } else {
            String nodeId = RandomStrings.randomAsciiOfLengthBetween(getRandom(), 5, 10);
 * this work for additional information regarding copyright
import org.apache.hc.core5.http.HttpHost;
                List<Node> sniffedNodes = sniffer.sniff();
        this.httpServer.start();
                    final String errorPrefix = "method [GET], host ["
        int numNodes = RandomNumbers.randomIntBetween(getRandom(), 1, 5);
                if (getRandom().nextBoolean()) {
                        response.getRequestLine().toString(),
                    assertThat(e.getMessage(), startsWith(errorPrefix));
                    generator.writeString("data");
 * under the License.
 * the Apache License, Version 2.0 (the "License"); you may
import static org.junit.Assert.assertEquals;
                        + httpHost
            }
 *
    }
            this.sniffResponse = sniffResponse;
            generator.writeEndObject();
        } else {
        try (RestClient restClient = RestClient.builder(httpHost).build()) {
import java.net.InetSocketAddress;
                new OpenSearchNodesSniffer(restClient, 1, null);
    public void testSniffNodes() throws IOException {
    private static class ResponseHandler implements HttpHandler {
            generator.writeName("name");
import com.sun.net.httpserver.HttpHandler;
            if (randomBoolean()) {
import org.junit.After;
        httpServer.createContext("/_nodes/http", new ResponseHandler(sniffTimeoutMillis, sniffResponse));
        }
        HttpHost httpHost = new HttpHost(httpServer.getAddress().getHostString(), httpServer.getAddress().getPort());
            generator.writeEndObject();
import java.util.ArrayList;
 * license agreements. See the NOTICE file distributed with
                generator.writeArrayPropertyStart("bogus_array");
            }
                attributes
            this.isFailure = isFailure;
            }
            generator.writeString(node.getVersion());
import java.util.List;
    private static SniffResponse buildSniffResponse(OpenSearchNodesSniffer.Scheme scheme) throws IOException {
import static org.hamcrest.CoreMatchers.equalTo;
        }
            );
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
                    generator.writeNumberProperty("max_content_length_in_bytes", 104857600);
                    generator.writeString(bound.toHostString());
    private int sniffRequestTimeout;
 * SPDX-License-Identifier: Apache-2.0
        private final String nodesInfoBody;
                if (getRandom().nextBoolean()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
        generator.writeEndObject();
    @Before
        JsonGenerator generator = jsonFactory.createGenerator(writer);
            if (randomBoolean()) {
                nodeRoles.add("data");
                }
            if (isFailure) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * You may obtain a copy of the License at
            boundHosts.add(publishHost);
            Collections.shuffle(roles, getRandom());
                generator.writeStartObject();
            generator.writeObjectPropertyStart(nodeId);
/*
                }
import tools.jackson.core.JsonGenerator;
            this.result = result;
        StringWriter writer = new StringWriter();
            final Set<String> nodeRoles = new TreeSet<>();
                if (sniffResponse.isFailure) {
 * Licensed to Elasticsearch under one or more contributor
public class OpenSearchNodesSnifferTests extends RestClientTestCase {
            try {
                }
            List<String> roles = Arrays.asList(new String[] { "cluster_manager", "data", "ingest" });
                List<String> values = new ArrayList<>();
            }
        httpServer.stop(0);
    private OpenSearchNodesSniffer.Scheme scheme;
            assertEquals("restClient cannot be null", e.getMessage());
                        + "], URI [/_nodes/http?timeout="
                generator.writeEndObject();
import java.net.InetAddress;
        }
                    );
        }
}
            }
            generator.writeString(node.getName());
        }
                }
                    String nodesInfoBody = sniffResponse.nodesInfoBody;
        try (RestClient restClient = RestClient.builder(httpHost).build()) {
import org.opensearch.client.RestClientTestCase;
        if (getRandom().nextBoolean()) {
                generator.writeArrayPropertyStart("bound_address");
            for (int j = 0; j < numAttributes; j++) {
        private final boolean isFailure;
                    assertThat(response.getHost(), equalTo(httpHost));
                    assertThat(e.getMessage(), containsString(Integer.toString(sniffResponse.nodesInfoResponseCode)));
 * KIND, either express or implied.  See the License for the
        private final List<Node> result;
                    assertThat(
            }
    private static class SniffResponse {
                this.nodesInfoResponseCode = randomErrorResponseCode();
                    generator.writeEndObject();
    private HttpServer httpServer;
                for (int v = 0; v < numValues; v++) {
            Set<HttpHost> boundHosts = new HashSet<>();
                if ("cluster_manager".equals(role) && node.getRoles().isClusterManagerEligible()) {
            new OpenSearchNodesSniffer(null, 1, OpenSearchNodesSniffer.Scheme.HTTP);
            OpenSearchNodesSniffer sniffer = new OpenSearchNodesSniffer(restClient, sniffRequestTimeout, scheme);
                fail("should have failed");
 * Modifications Copyright OpenSearch Contributors. See
        }
                        return;
            } else {
                assertEquals(e.getMessage(), "sniffRequestTimeoutMillis must be greater than 0");
import java.nio.charset.StandardCharsets;
        ResponseHandler(int sniffTimeoutMillis, SniffResponse sniffResponse) {
                );
            try {
        @Override
import java.util.HashSet;
        try {
                generator.writeEndObject();
            if (httpExchange.getRequestMethod().equals(HttpGet.METHOD_NAME)) {
                assertEquals(e.getMessage(), "scheme cannot be null");
    public void testConstructorValidation() throws IOException {
        }
 */
            return new SniffResponse("", Collections.<Node>emptyList(), true);
import java.io.IOException;
                for (int b = 0; b < bound; b++) {
        this.httpServer = createHttpServer(sniffResponse, sniffRequestTimeout);
        for (int i = 0; i < numNodes; i++) {
                for (Map.Entry<String, List<String>> entry : attributes.entrySet()) {
                Response response = e.getResponse();
            if (getRandom().nextBoolean()) {
    }
        this.scheme = RandomPicks.randomFrom(getRandom(), OpenSearchNodesSniffer.Scheme.values());
            Node node = new Node(
import java.io.StringWriter;
import static org.hamcrest.CoreMatchers.startsWith;
            generator.writeArrayPropertyStart("roles");
import java.util.TreeSet;
        JsonFactory jsonFactory = new JsonFactory();
                if ("ingest".equals(role) && node.getRoles().isIngest()) {
            }
import com.sun.net.httpserver.HttpExchange;
            } catch (ResponseException e) {
            String host = "host" + i;
        List<Node> nodes = new ArrayList<>(numNodes);
            }
            int numAttributes = between(0, 5);
                }
                    generator.writeString("ingest");
        static SniffResponse buildResponse(String nodesInfoBody, List<Node> nodes) {
                new OpenSearchNodesSniffer(
    public void stopHttpServer() throws IOException {
            if (getRandom().nextBoolean()) {
                    fail("sniffNodes should have succeeded: " + response.getStatusLine());
                    try (OutputStream out = httpExchange.getResponseBody()) {
                for (HttpHost bound : boundHosts) {
                    generator.writeObjectPropertyStart("bogus_object");
            this.sniffResponse = buildSniffResponse(scheme);
                generator.writeObjectPropertyStart("http");
                        equalTo("GET /_nodes/http?timeout=" + sniffRequestTimeout + "ms HTTP/1.1")
                randomAsciiAlphanumOfLength(5),
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        public void handle(HttpExchange httpExchange) throws IOException {
                generator.writeEndObject();
        if (rarely()) {
 * compatible open source license.
            if (isHttpEnabled) {
                    }
                nodeRoles.add("cluster_manager");
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
            generator.writeName("version");
                generator.writeEndArray();
 * not use this file except in compliance with the License.
import org.opensearch.client.Response;
                generator.writeEndObject();
            }
import com.sun.net.httpserver.HttpServer;
                }
            }
    }
        generator.writeStartObject();
                publishHost,
            generator.writeObjectPropertyStart("bogus_object");
import static org.junit.Assert.fail;
 * ownership. Elasticsearch licenses this file to you under
            httpExchange.sendResponseHeaders(404, 0);
                        + "ms], status line [HTTP/1.1";
                generator.writeObjectPropertyStart("bogus_object");
/*
    }
            this.sniffResponse = SniffResponse.buildFailure();
import java.io.OutputStream;
                }
            this.nodesInfoBody = nodesInfoBody;
        private final SniffResponse sniffResponse;
                int bound = between(1, 5);
import org.junit.Before;
            } catch (NullPointerException e) {
 * Unless required by applicable law or agreed to in writing,
            }
            generator.writeStringProperty("cluster_name", "opensearch");
        return httpServer;
                if (sniffResponse.isFailure) {
import org.opensearch.client.ResponseException;
                attributes.put("attr" + j, values);
    private static HttpServer createHttpServer(final SniffResponse sniffResponse, final int sniffTimeoutMillis) throws IOException {
                generator.writeStringProperty("publish_address", publishHost.toHostString());
import tools.jackson.core.json.JsonFactory;
                    boundHosts.add(new HttpHost(scheme.toString(), host + b, port));
                    values.add(j + "value" + v);
import java.util.Collections;
                    httpExchange.sendResponseHeaders(sniffResponse.nodesInfoResponseCode, nodesInfoBody.length());
                    generator.writeStringProperty(entry.getKey(), entry.getValue().toString());
        if (getRandom().nextBoolean()) {
                this.nodesInfoResponseCode = 200;
            this.sniffTimeoutMillis = sniffTimeoutMillis;
            HttpHost publishHost = new HttpHost(scheme.toString(), host, port);
import org.opensearch.client.RestClient;
            }
                new Node.Roles(nodeRoles),
 * The OpenSearch Contributors require contributions made to
        }
import org.opensearch.client.Node;
        generator.writeEndObject();
                    RandomNumbers.randomIntBetween(getRandom(), Integer.MIN_VALUE, 0),
        }
 * software distributed under the License is distributed on an
import org.apache.hc.client5.http.classic.methods.HttpGet;
        private final int sniffTimeoutMillis;
        return SniffResponse.buildResponse(writer.toString(), nodes);
    }
            for (String role : roles) {
/*
import static org.junit.Assert.assertThat;
        this.sniffRequestTimeout = RandomNumbers.randomIntBetween(getRandom(), 1000, 10000);
                boundHosts,
package org.opensearch.client.sniff;
            }
                }
        generator.close();
            }
        HttpHost httpHost = new HttpHost(httpServer.getAddress().getHostString(), httpServer.getAddress().getPort());
                        + sniffRequestTimeout
        private final int nodesInfoResponseCode;
 * specific language governing permissions and limitations
            if (numAttributes > 0) {
import java.util.Map;
                fail("should have failed");
                }
            generator.writeEndArray();
                    OpenSearchNodesSniffer.Scheme.HTTP
            int port = RandomNumbers.randomIntBetween(getRandom(), 9200, 9299);
        static SniffResponse buildFailure() {
            fail("should have failed");
    public void startHttpServer() throws IOException {
    }
import static org.hamcrest.CoreMatchers.containsString;
            if (randomBoolean()) {
                }
                generator.writeObjectPropertyStart("attributes");
                nodeRoles.add("ingest");
            try {
                int numValues = frequently() ? 1 : between(2, 5);
 *
                    restClient,
            httpExchange.close();
        SniffResponse(String nodesInfoBody, List<Node> result, boolean isFailure) {
        } catch (NullPointerException e) {
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
 */
            boolean isHttpEnabled = rarely() == false;
            } catch (IllegalArgumentException e) {
