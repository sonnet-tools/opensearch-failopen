 *
                            }  
                            parser.skipChildren();
            List<Node> nodes = new ArrayList<>();
     *                   client that was used to sniff them.
        /*
                            }
         */  
 * ownership. Elasticsearch licenses this file to you under  
                // Convert string array to list
            }
        public String toString() {
        String fieldName = null;  
            } else {
        HttpHost publishedHost = null;
     *                   that is also provided to {@link Sniffer#builder(RestClient)}, so that the hosts are set to the same  
                if (parser.currentToken() == JsonToken.START_OBJECT) {
            this.name = name;  
import java.util.TreeSet;
        final Set<String> roles = new TreeSet<>();
                } else if ("name".equals(fieldName)) {
 * You may obtain a copy of the License at  
            logger.debug("skipping node [" + nodeId + "] with http disabled");  
import java.io.InputStream;  
        Set<HttpHost> boundHosts = new HashSet<>();
                        }
                            Node node = readNode(nodeId, parser, scheme);
                            String address = parser.getValueAsString();
 * Class responsible for sniffing the http hosts from opensearch through the nodes info api and returning them back.
    /**
                } else {
    private static Node readNode(String nodeId, JsonParser parser, Scheme scheme) throws IOException {  
                    }
                    }
                                publishAddressAsURI = URI.create(scheme + "://" + cnameAndURI[1]);  
                    name = parser.getText();  
    }
        HTTPS("https");
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
        if (sniffRequestTimeoutMillis < 0) {  
                                URI boundAddressAsURI = URI.create(scheme + "://" + parser.getValueAsString());  
                        } else if (parser.currentToken() == JsonToken.START_ARRAY && "bound_address".equals(parser.currentName())) {
                if ("roles".equals(fieldName)) {  
                                nodes.add(node);  
            throw new IllegalArgumentException("sniffRequestTimeoutMillis must be greater than 0");
    private final Scheme scheme;
     */  
import static java.util.Collections.unmodifiableList;  
     * The default sniff request timeout (in milliseconds).
                        parser.skipChildren();
    }  
     * Calls the opensearch nodes info api, parses the response and returns all the found http hosts  
    }
        this.scheme = Objects.requireNonNull(scheme, "scheme cannot be null");
        }
 * under the License.  
import org.opensearch.client.Request;
    private static final Log logger = LogFactory.getLog(OpenSearchNodesSniffer.class);
                            String host;  
import org.apache.hc.core5.http.HttpHost;
                            URI publishAddressAsURI;
import java.util.concurrent.TimeUnit;
                realAttributes.put(entry.getKey(), singletonList(entry.getValue()));  
                        if (parser.currentToken() == JsonToken.VALUE_STRING) {
import tools.jackson.core.JsonToken;
                            while (parser.nextToken() != JsonToken.END_ARRAY) {
 *  
     * The supported host schemes.
 * license agreements. See the NOTICE file distributed with
                                host = publishAddressAsURI.getHost();
     *                                  that have responded within this timeout will be returned.
import java.util.Set;  
                            }
        HTTP("http"),
                                throw new IOException("repeated attribute key [" + parser.currentName() + "]");
import java.io.IOException;
     */  
        final Map<String, String> protoAttributes = new HashMap<String, String>();
            } else if (parser.currentToken().isScalarValue()) {
import org.opensearch.client.RestClient;  
        for (Map.Entry<String, String> entry : protoAttributes.entrySet()) {
                if ("version".equals(fieldName)) {  
    static List<Node> readHosts(HttpEntity entity, Scheme scheme, JsonFactory jsonFactory) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
                        } else if (parser.currentToken() == JsonToken.START_OBJECT) {
                            if (node != null) {
     */  
    /**
         */
import java.util.ArrayList;
                        if (parser.currentToken() == JsonToken.VALUE_STRING && "publish_address".equals(parser.currentName())) {
                        while (parser.nextToken() != JsonToken.END_OBJECT) {  
                            if (oldValue != null) {
     *                   that is also provided to {@link Sniffer#builder(RestClient)}, so that the hosts are set to the same
                            String nodeId = parser.currentName();  
                realAttributes.put(entry.getKey(), unmodifiableList(Arrays.asList(values)));
                                host = cnameAndURI[0];
/*
 * specific language governing permissions and limitations
                if ("http".equals(fieldName)) {
        logger.trace("adding node [" + nodeId + "]");  
import java.net.URI;
            } else if (parser.currentToken() == JsonToken.START_ARRAY) {
    public OpenSearchNodesSniffer(RestClient restClient) {
    public List<Node> sniff() throws IOException {  
            return null;
    public static final long DEFAULT_SNIFF_REQUEST_TIMEOUT = TimeUnit.SECONDS.toMillis(1);
 * software distributed under the License is distributed on an
                    }
        }  
/*  
                } else if ("attributes".equals(fieldName)) {  
import static java.util.Collections.unmodifiableMap;
                }
                            String oldValue = protoAttributes.put(parser.currentName(), parser.getValueAsString());  
 * KIND, either express or implied.  See the License for the
        }  
import org.apache.commons.logging.LogFactory;
public final class OpenSearchNodesSniffer implements NodesSniffer {  
 * SPDX-License-Identifier: Apache-2.0
            if (entry.getValue().startsWith("[")) {  
 * GitHub history for details.
                        roles.add(parser.getText());  
                } else {
                                    new HttpHost(boundAddressAsURI.getScheme(), boundAddressAsURI.getHost(), boundAddressAsURI.getPort())
    /**
        private final String name;  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
                    }
         * unflip them after reading them because we can't rely on the order
     */
        @Override  
                            // ES7 cname/ip:port format  
 * the Apache License, Version 2.0 (the "License"); you may
                String[] values = value.substring(1, value.length() - 1).split(", ");  
        /*
            }
        if (publishedHost == null) {
        return new Node(publishedHost, boundHosts, name, version, new Roles(roles), unmodifiableMap(realAttributes));
import java.util.Objects;
                fieldName = parser.currentName();  
                            parser.skipChildren();  
        Scheme(String name) {
                    parser.skipChildren();  
     * @param scheme the scheme to associate sniffed nodes with (as it is not returned by opensearch)
import org.opensearch.client.Node.Roles;  
                    parser.skipChildren();  
}
         */
 * The OpenSearch Contributors require contributions made to  
        try (InputStream inputStream = entity.getContent()) {  
                    sawRoles = true;
        boolean sawRoles = false;  
import org.opensearch.client.Node;
    private final RestClient restClient;  
        /**
 */
import org.opensearch.client.Response;
         * address on which it is listening. This is useful in OpenSearch's
 */  
                        }
        }  
                            publishedHost = new HttpHost(publishAddressAsURI.getScheme(), host, publishAddressAsURI.getPort());  
 */  
import java.util.Arrays;  
 * this work for additional information regarding copyright
     * @param sniffRequestTimeoutMillis the sniff request timeout (in milliseconds) to be passed in as a query string parameter
            }
        // http section is not present if http is not enabled on the node, ignore such nodes
                            }
import org.apache.hc.core5.http.HttpEntity;  
import java.util.HashMap;
         * Multi-valued attributes come with key = `real_key.index` and we  
            }
     *                   client that was used to fetch them.
        String name = null;  
import org.apache.commons.logging.Log;
        Response response = restClient.performRequest(request);
     * Creates a new instance of the OpenSearch sniffer. It will use the provided {@link RestClient} to fetch the hosts,  
        }
/*  
            } else if (parser.currentToken() == JsonToken.START_OBJECT) {
                }
     * Creates a new instance of the OpenSearch sniffer. It will use the provided {@link RestClient} to fetch the hosts  
                    while (parser.nextToken() != JsonToken.END_OBJECT) {  
         * that they arive.
 * Licensed to Elasticsearch under one or more contributor  
import tools.jackson.core.JsonParser;
import java.util.Map;
    public enum Scheme {
                        } else {
    private final JsonFactory jsonFactory = new JsonFactory();  
            JsonParser parser = jsonFactory.createParser(inputStream);
 */
     * @param restClient client used to fetch the hosts from opensearch through nodes info api. Usually the same instance
         * The HTTP host scheme.  
            return nodes;
                    } else {  
 * compatible open source license.
 * not use this file except in compliance with the License.
                                publishAddressAsURI = URI.create(scheme + "://" + address);  
                            } else {
                }  
                    while (parser.nextToken() != JsonToken.END_ARRAY) {
     * through the nodes info api, the provided sniff request timeout value and scheme.
        String version = null;
    /**
 *
        assert boundHosts.contains(publishedHost) : "[" + nodeId + "] doesn't make sense! publishedHost should be in boundHosts";
        /**
                                boundHosts.add(
     */  
    private final Request request;
    public OpenSearchNodesSniffer(RestClient restClient, long sniffRequestTimeoutMillis, Scheme scheme) {
            while (parser.nextToken() != JsonToken.END_OBJECT) {  
                String value = entry.getValue();
/**  
         * We sniff the bound hosts so we can look up the node based on any  
 * Unless required by applicable law or agreed to in writing,
                throw new IOException("expected data to start with an object");  
                                );  
import static java.util.Collections.singletonList;
                                String[] cnameAndURI = address.split("/", 2);
        request.addParameter("timeout", sniffRequestTimeoutMillis + "ms");
                    if ("nodes".equals(parser.currentName())) {
import java.util.HashSet;
    }  
     *                                  to opensearch. Allows to halt the request without any failure, as only the nodes  
    /**
                    while (parser.nextToken() != JsonToken.END_OBJECT) {
        return readHosts(response.getEntity(), scheme, jsonFactory);
                            if (address.contains("/")) {
            if (parser.nextToken() != JsonToken.START_OBJECT) {
        this.restClient = Objects.requireNonNull(restClient, "restClient cannot be null");
                    version = parser.getText();
     * as the scheme for all the hosts.
     * @param restClient client used to fetch the hosts from opensearch through nodes info api. Usually the same instance  
                        }  
 * Modifications Copyright OpenSearch Contributors. See
        this.request = new Request("GET", "/_nodes/http");  
         * tests contact the node on ipv4.  
        Map<String, List<String>> realAttributes = new HashMap<>(protoAttributes.size());
         * The HTTPS host scheme.
        this(restClient, DEFAULT_SNIFF_REQUEST_TIMEOUT, OpenSearchNodesSniffer.Scheme.HTTP);
                            assert token == JsonToken.START_OBJECT;
        while (parser.nextToken() != JsonToken.END_OBJECT) {
                            JsonToken token = parser.nextToken();
        assert sawRoles : "didn't see roles for [" + nodeId + "]";
         * test framework where we sometimes publish ipv6 addresses but the
import tools.jackson.core.json.JsonFactory;  
import java.util.List;  
     * through the nodes info api, the default sniff request timeout value {@link #DEFAULT_SNIFF_REQUEST_TIMEOUT} and http
        }
package org.opensearch.client.sniff;
        }
            if (parser.currentToken() == JsonToken.PROPERTY_NAME) {
    }  
            return name;
         */  
