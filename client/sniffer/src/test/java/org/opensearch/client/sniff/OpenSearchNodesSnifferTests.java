                    assertThat(e.getMessage(), containsString(Integer.toString(sniffResponse.nodesInfoResponseCode)));  
 * specific language governing permissions and limitations
    @After
                    OpenSearchNodesSniffer.Scheme.HTTP
                for (Map.Entry<String, List<String>> entry : attributes.entrySet()) {
                generator.writeStringProperty("publish_address", publishHost.toHostString());
            try {
            } catch (ResponseException e) {  
                generator.writeEndObject();
            Map<String, List<String>> attributes = new HashMap<>(numAttributes);
                }
                for (HttpHost bound : boundHosts) {  
        static SniffResponse buildFailure() {
            generator.writeObjectPropertyStart("bogus_object");  
import java.util.Set;
            generator.writeString(node.getName());
 * GitHub history for details.
                        + "ms], status line [HTTP/1.1";
                generator.writeEndObject();
            HttpHost publishHost = new HttpHost(scheme.toString(), host, port);
import org.opensearch.client.RestClientTestCase;  
                randomAsciiAlphanumOfLength(5),
            if (getRandom().nextBoolean()) {
    public void stopHttpServer() throws IOException {  
import java.util.Arrays;
                Response response = e.getResponse();
        HttpHost httpHost = new HttpHost(httpServer.getAddress().getHostString(), httpServer.getAddress().getPort());
                    assertThat(response.getHost(), equalTo(httpHost));
        HttpHost httpHost = new HttpHost(httpServer.getAddress().getHostString(), httpServer.getAddress().getPort());  
        }
                }
                randomAsciiAlphanumOfLength(5),  
                );  
    private static SniffResponse buildSniffResponse(OpenSearchNodesSniffer.Scheme scheme) throws IOException {
import org.junit.Before;
        generator.writeEndObject();
            generator.writeEndArray();
            return new SniffResponse(nodesInfoBody, nodes, false);
            Set<HttpHost> boundHosts = new HashSet<>();  
                        + "], URI [/_nodes/http?timeout="
import org.opensearch.client.Response;  
            fail("should have failed");
        }
                generator.writeArrayPropertyStart("bound_address");
                    final String errorPrefix = "method [GET], host ["  
            return new SniffResponse("", Collections.<Node>emptyList(), true);  
            if (randomBoolean()) {  
                }  
    }
}
                nodeRoles.add("ingest");
                }  
                }
                if (httpExchange.getRequestURI().getRawQuery().equals("timeout=" + sniffTimeoutMillis + "ms")) {
                for (int b = 0; b < bound; b++) {
import com.sun.net.httpserver.HttpHandler;  
        if (rarely()) {
        private final String nodesInfoBody;
            this.result = result;
            for (String role : roles) {  
            OpenSearchNodesSniffer sniffer = new OpenSearchNodesSniffer(restClient, sniffRequestTimeout, scheme);
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);  
            }
                    generator.writeString(bound.toHostString());
    }  
                generator.writeArrayPropertyStart("bogus_array");
                int numValues = frequently() ? 1 : between(2, 5);
import java.util.HashSet;
import org.apache.hc.core5.http.HttpHost;
            if (httpExchange.getRequestMethod().equals(HttpGet.METHOD_NAME)) {
            final Set<String> nodeRoles = new TreeSet<>();  
                boundHosts,
        return SniffResponse.buildResponse(writer.toString(), nodes);  
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
import com.carrotsearch.randomizedtesting.generators.RandomStrings;  
 *  
/*  
                assertEquals(sniffResponse.result, sniffedNodes);
import org.junit.After;
            } catch (NullPointerException e) {
                new Node.Roles(nodeRoles),
            Node node = new Node(
        generator.close();
                    generator.writeString("data");
    private static int randomErrorResponseCode() {
import java.util.Collections;  
                generator.writeEndArray();
                    generator.writeNumberProperty("max_content_length_in_bytes", 104857600);
 * not use this file except in compliance with the License.
                generator.writeObjectPropertyStart("bogus_object");
    private int sniffRequestTimeout;
                        equalTo("GET /_nodes/http?timeout=" + sniffRequestTimeout + "ms HTTP/1.1")
    @Before
        @Override
        generator.writeStartObject();
import tools.jackson.core.json.JsonFactory;  
        this.httpServer = createHttpServer(sniffResponse, sniffRequestTimeout);
                }  
import tools.jackson.core.JsonGenerator;
            assertEquals("restClient cannot be null", e.getMessage());  
        generator.writeEndObject();  
import java.net.InetSocketAddress;
        }
            }
                    assertThat(response.getStatusLine().getStatusCode(), equalTo(sniffResponse.nodesInfoResponseCode));
            generator.writeEndObject();
                fail("should have failed");
                } else {
import java.util.HashMap;
import java.io.StringWriter;  
        private final int nodesInfoResponseCode;
                if (getRandom().nextBoolean()) {
    public void testSniffNodes() throws IOException {
                List<String> values = new ArrayList<>();
                    fail("sniffNodes should have failed");  
            boundHosts.add(publishHost);
        ResponseHandler(int sniffTimeoutMillis, SniffResponse sniffResponse) {  
            if (randomBoolean()) {
            generator.writeEndObject();
            );  
        }  
    }
                if ("ingest".equals(role) && node.getRoles().isIngest()) {
        int numNodes = RandomNumbers.randomIntBetween(getRandom(), 1, 5);
                generator.writeEndObject();
            if (isHttpEnabled) {
            List<String> roles = Arrays.asList(new String[] { "cluster_manager", "data", "ingest" });  
        public void handle(HttpExchange httpExchange) throws IOException {  
 * under the License.  
            }
                if ("data".equals(role) && node.getRoles().isData()) {
        }
            this.isFailure = isFailure;  
                }
 * software distributed under the License is distributed on an
public class OpenSearchNodesSnifferTests extends RestClientTestCase {  
 *
import java.util.List;  
                publishHost,  
            this.sniffResponse = sniffResponse;
                assertEquals(e.getMessage(), "sniffRequestTimeoutMillis must be greater than 0");  
 *
    private static class ResponseHandler implements HttpHandler {
        try (RestClient restClient = RestClient.builder(httpHost).build()) {  
                    RandomNumbers.randomIntBetween(getRandom(), Integer.MIN_VALUE, 0),
            httpExchange.close();  
            this.sniffResponse = SniffResponse.buildFailure();  
        generator.writeObjectPropertyStart("nodes");  
        static SniffResponse buildResponse(String nodesInfoBody, List<Node> nodes) {  
 * this work for additional information regarding copyright
            try {
                    values.add(j + "value" + v);
            generator.writeName("name");  
                    generator.writeObjectPropertyStart("bogus_object");
            generator.writeName("version");
        }
        }
            this.nodesInfoBody = nodesInfoBody;
        }  
    }  
 * compatible open source license.
import java.net.InetAddress;
            } else {  
 * license agreements. See the NOTICE file distributed with
import java.util.ArrayList;
            }  
        private final SniffResponse sniffResponse;
        StringWriter writer = new StringWriter();
                nodes.add(node);  
                if (sniffResponse.isFailure) {
import java.util.TreeSet;  
                generator.writeObjectPropertyStart("attributes");
            generator.writeArrayPropertyStart("roles");
        try (RestClient restClient = RestClient.builder(httpHost).build()) {
            int numAttributes = between(0, 5);
            if (isFailure) {
import org.opensearch.client.RestClient;
import static org.junit.Assert.assertEquals;
 * this file be licensed under the Apache-2.0 license or a
            int port = RandomNumbers.randomIntBetween(getRandom(), 9200, 9299);
                if ("cluster_manager".equals(role) && node.getRoles().isClusterManagerEligible()) {
        JsonFactory jsonFactory = new JsonFactory();
 * Modifications Copyright OpenSearch Contributors. See
                generator.writeEndArray();  
        this.httpServer.start();
            new OpenSearchNodesSniffer(null, 1, OpenSearchNodesSniffer.Scheme.HTTP);  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
        if (getRandom().nextBoolean()) {
import com.sun.net.httpserver.HttpServer;
                    assertThat(  
import static org.junit.Assert.assertThat;  
                if (sniffResponse.isFailure) {
        try {
import org.opensearch.client.Node;
            this.sniffTimeoutMillis = sniffTimeoutMillis;
        }
package org.opensearch.client.sniff;
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
                List<Node> sniffedNodes = sniffer.sniff();
    public void testConstructorValidation() throws IOException {
    private OpenSearchNodesSniffer.Scheme scheme;  
import static org.hamcrest.CoreMatchers.equalTo;  
            try {  
import com.sun.net.httpserver.HttpExchange;
 */  
 * Licensed to Elasticsearch under one or more contributor  
            String host = "host" + i;  
        httpServer.stop(0);
            generator.writeObjectPropertyStart(nodeId);
import org.opensearch.client.ResponseException;
                fail("should have failed");  
        httpServer.createContext("/_nodes/http", new ResponseHandler(sniffTimeoutMillis, sniffResponse));
        } else {
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
                generator.writeObjectPropertyStart("http");
    }  
            if (getRandom().nextBoolean()) {  
                        response.getRequestLine().toString(),
            }
            for (int j = 0; j < numAttributes; j++) {  
        List<Node> nodes = new ArrayList<>(numNodes);  
            generator.writeStringProperty("cluster_name", "opensearch");  
                generator.writeStartObject();  
                    generator.writeString("cluster_manager");
        return RandomNumbers.randomIntBetween(getRandom(), 400, 599);  
 */
        this.scheme = RandomPicks.randomFrom(getRandom(), OpenSearchNodesSniffer.Scheme.values());
                new OpenSearchNodesSniffer(restClient, 1, null);
    public void startHttpServer() throws IOException {
        } catch (NullPointerException e) {
                }  
    }  
            httpExchange.sendResponseHeaders(404, 0);
    private HttpServer httpServer;
/*  
                for (int v = 0; v < numValues; v++) {  
                    try (OutputStream out = httpExchange.getResponseBody()) {
                        + httpHost
            if (numAttributes > 0) {  
import static org.junit.Assert.fail;
        for (int i = 0; i < numNodes; i++) {
                assertEquals(e.getMessage(), "scheme cannot be null");
import java.nio.charset.StandardCharsets;  
            }  
                    assertThat(e.getMessage(), startsWith(errorPrefix));
 */  
        this.sniffRequestTimeout = RandomNumbers.randomIntBetween(getRandom(), 1000, 10000);  
        if (getRandom().nextBoolean()) {
            } catch (IllegalArgumentException e) {
 * KIND, either express or implied.  See the License for the
                    httpExchange.sendResponseHeaders(sniffResponse.nodesInfoResponseCode, nodesInfoBody.length());
                }
                int bound = between(1, 5);
        JsonGenerator generator = jsonFactory.createGenerator(writer);  
    }
            }  
                    generator.writeEndObject();  
            generator.writeString(node.getVersion());
    private static class SniffResponse {  
        }
            }  
                    }
            if (randomBoolean()) {
            }  
                    fail("sniffNodes should have succeeded: " + response.getStatusLine());
    }  
import static org.hamcrest.CoreMatchers.startsWith;
                    restClient,  
                generator.writeEndObject();  
            }
import org.apache.hc.client5.http.classic.methods.HttpGet;  
/*
 * The OpenSearch Contributors require contributions made to  
                attributes.put("attr" + j, values);  
            Collections.shuffle(roles, getRandom());
                        return;
                nodeRoles.add("data");
                nodeRoles.add("cluster_manager");
        SniffResponse(String nodesInfoBody, List<Node> result, boolean isFailure) {  
                    boundHosts.add(new HttpHost(scheme.toString(), host + b, port));  
    }
            }
            if (randomBoolean()) {
import static org.hamcrest.CoreMatchers.containsString;
import java.util.Map;
            }
        private final boolean isFailure;
            }  
import java.io.OutputStream;
                }  
                this.nodesInfoResponseCode = 200;
        return httpServer;
                        out.write(nodesInfoBody.getBytes(StandardCharsets.UTF_8));  
                        + sniffRequestTimeout  
    private SniffResponse sniffResponse;
                    );  
            this.sniffResponse = buildSniffResponse(scheme);
                this.nodesInfoResponseCode = randomErrorResponseCode();
                attributes
                    generator.writeString("ingest");
            }
                    String nodesInfoBody = sniffResponse.nodesInfoBody;  
                    generator.writeStringProperty(entry.getKey(), entry.getValue().toString());  
 * ownership. Elasticsearch licenses this file to you under  
                }
        }  
            boolean isHttpEnabled = rarely() == false;
        }
        private final int sniffTimeoutMillis;  
            }  
                new OpenSearchNodesSniffer(
import java.io.IOException;
    private static HttpServer createHttpServer(final SniffResponse sniffResponse, final int sniffTimeoutMillis) throws IOException {
                if (getRandom().nextBoolean()) {  
        private final List<Node> result;  
            String nodeId = RandomStrings.randomAsciiOfLengthBetween(getRandom(), 5, 10);
