         * The HTTP host scheme.
            if (parser.currentToken() == JsonToken.PROPERTY_NAME) {
        HTTP("http"),
                                host = cnameAndURI[0];
import tools.jackson.core.JsonParser;
import org.opensearch.client.Response;
    /**
                realAttributes.put(entry.getKey(), singletonList(entry.getValue()));
        request.addParameter("timeout", sniffRequestTimeoutMillis + "ms");
            return name;
                                String[] cnameAndURI = address.split("/", 2);
                            String host;
                            String oldValue = protoAttributes.put(parser.currentName(), parser.getValueAsString());
                    while (parser.nextToken() != JsonToken.END_OBJECT) {
import java.io.InputStream;
    }
     * The supported host schemes.
        /**
        HttpHost publishedHost = null;
 * the Apache License, Version 2.0 (the "License"); you may
 *
 */
                    }
import org.apache.commons.logging.LogFactory;
    }
import java.util.Map;
        @Override
                    name = parser.getText();
                                publishAddressAsURI = URI.create(scheme + "://" + address);
     * Creates a new instance of the OpenSearch sniffer. It will use the provided {@link RestClient} to fetch the hosts
                    parser.skipChildren();
/**
    private final Scheme scheme;
                    sawRoles = true;
        }
 */
         * The HTTPS host scheme.
import org.apache.hc.core5.http.HttpEntity;
                            }
                if ("http".equals(fieldName)) {
    public OpenSearchNodesSniffer(RestClient restClient) {
     *                                  that have responded within this timeout will be returned.
         */
/*
        }
import org.apache.hc.core5.http.HttpHost;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.HashSet;
        public String toString() {
    public enum Scheme {
        return readHosts(response.getEntity(), scheme, jsonFactory);
                String value = entry.getValue();
    private final Request request;
        /*
         * that they arive.
     */
 */
        private final String name;
     * Calls the opensearch nodes info api, parses the response and returns all the found http hosts
 * You may obtain a copy of the License at
                        parser.skipChildren();
                                boundHosts.add(
                if ("version".equals(fieldName)) {
        assert sawRoles : "didn't see roles for [" + nodeId + "]";
    /**
     *                   client that was used to fetch them.
        final Map<String, String> protoAttributes = new HashMap<String, String>();
            while (parser.nextToken() != JsonToken.END_OBJECT) {
                                nodes.add(node);
 * under the License.
                        if (parser.currentToken() == JsonToken.VALUE_STRING && "publish_address".equals(parser.currentName())) {
            } else if (parser.currentToken() == JsonToken.START_ARRAY) {
         * test framework where we sometimes publish ipv6 addresses but the
import org.opensearch.client.RestClient;
 * SPDX-License-Identifier: Apache-2.0
 */
     *                   that is also provided to {@link Sniffer#builder(RestClient)}, so that the hosts are set to the same
            JsonParser parser = jsonFactory.createParser(inputStream);
                if (parser.currentToken() == JsonToken.START_OBJECT) {
        while (parser.nextToken() != JsonToken.END_OBJECT) {
        this.request = new Request("GET", "/_nodes/http");
            return nodes;
                        }
        }
                            parser.skipChildren();
                    } else {
 * software distributed under the License is distributed on an
                            String address = parser.getValueAsString();
        if (publishedHost == null) {
    private static Node readNode(String nodeId, JsonParser parser, Scheme scheme) throws IOException {
import tools.jackson.core.json.JsonFactory;
        String fieldName = null;
    private final RestClient restClient;
        try (InputStream inputStream = entity.getContent()) {
     */
            throw new IllegalArgumentException("sniffRequestTimeoutMillis must be greater than 0");
        for (Map.Entry<String, String> entry : protoAttributes.entrySet()) {
    public OpenSearchNodesSniffer(RestClient restClient, long sniffRequestTimeoutMillis, Scheme scheme) {
        /**
                            String nodeId = parser.currentName();
                            if (node != null) {
public final class OpenSearchNodesSniffer implements NodesSniffer {
         * unflip them after reading them because we can't rely on the order
     * @param sniffRequestTimeoutMillis the sniff request timeout (in milliseconds) to be passed in as a query string parameter
                                throw new IOException("repeated attribute key [" + parser.currentName() + "]");
        Set<HttpHost> boundHosts = new HashSet<>();
        Response response = restClient.performRequest(request);
         * tests contact the node on ipv4.
                }
import static java.util.Collections.unmodifiableMap;
                        if (parser.currentToken() == JsonToken.VALUE_STRING) {
    }
                throw new IOException("expected data to start with an object");
                    while (parser.nextToken() != JsonToken.END_ARRAY) {
    static List<Node> readHosts(HttpEntity entity, Scheme scheme, JsonFactory jsonFactory) throws IOException {
            }
import java.util.Set;
         */
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
            logger.debug("skipping node [" + nodeId + "] with http disabled");
            List<Node> nodes = new ArrayList<>();
         * address on which it is listening. This is useful in OpenSearch's
        }
                String[] values = value.substring(1, value.length() - 1).split(", ");
                            URI publishAddressAsURI;
import tools.jackson.core.JsonToken;
                            }
import static java.util.Collections.singletonList;
                        while (parser.nextToken() != JsonToken.END_OBJECT) {
        String version = null;
                        } else {
 * Licensed to Elasticsearch under one or more contributor
        return new Node(publishedHost, boundHosts, name, version, new Roles(roles), unmodifiableMap(realAttributes));
        }
import java.util.Arrays;
import org.opensearch.client.Node;
                                );
                            publishedHost = new HttpHost(publishAddressAsURI.getScheme(), host, publishAddressAsURI.getPort());
        this(restClient, DEFAULT_SNIFF_REQUEST_TIMEOUT, OpenSearchNodesSniffer.Scheme.HTTP);
        this.scheme = Objects.requireNonNull(scheme, "scheme cannot be null");
     * Creates a new instance of the OpenSearch sniffer. It will use the provided {@link RestClient} to fetch the hosts,
 * compatible open source license.
                    while (parser.nextToken() != JsonToken.END_OBJECT) {
                }
        assert boundHosts.contains(publishedHost) : "[" + nodeId + "] doesn't make sense! publishedHost should be in boundHosts";
                                URI boundAddressAsURI = URI.create(scheme + "://" + parser.getValueAsString());
    }
import java.io.IOException;
                realAttributes.put(entry.getKey(), unmodifiableList(Arrays.asList(values)));
        HTTPS("https");
import java.util.HashMap;
                            }
 * ownership. Elasticsearch licenses this file to you under
                            } else {
        String name = null;
import java.util.concurrent.TimeUnit;
import org.opensearch.client.Request;
                    version = parser.getText();
     * as the scheme for all the hosts.
 * specific language governing permissions and limitations
                    }
     * @param restClient client used to fetch the hosts from opensearch through nodes info api. Usually the same instance
    private final JsonFactory jsonFactory = new JsonFactory();
                            Node node = readNode(nodeId, parser, scheme);
    /**
 *
                        }
         */
 * The OpenSearch Contributors require contributions made to
         * Multi-valued attributes come with key = `real_key.index` and we
     * through the nodes info api, the provided sniff request timeout value and scheme.
     * The default sniff request timeout (in milliseconds).
            return null;
                                host = publishAddressAsURI.getHost();
                        } else if (parser.currentToken() == JsonToken.START_OBJECT) {
        final Set<String> roles = new TreeSet<>();
    private static final Log logger = LogFactory.getLog(OpenSearchNodesSniffer.class);
     * through the nodes info api, the default sniff request timeout value {@link #DEFAULT_SNIFF_REQUEST_TIMEOUT} and http
     *                                  to opensearch. Allows to halt the request without any failure, as only the nodes
                fieldName = parser.currentName();
import java.util.TreeSet;
                            if (oldValue != null) {
        }
 * this work for additional information regarding copyright
                        roles.add(parser.getText());
     *                   that is also provided to {@link Sniffer#builder(RestClient)}, so that the hosts are set to the same
        /*
 * this file be licensed under the Apache-2.0 license or a
            }
         */
            }
     */
                        } else if (parser.currentToken() == JsonToken.START_ARRAY && "bound_address".equals(parser.currentName())) {
                                publishAddressAsURI = URI.create(scheme + "://" + cnameAndURI[1]);
        this.restClient = Objects.requireNonNull(restClient, "restClient cannot be null");
                            parser.skipChildren();
                    }
     *                   client that was used to sniff them.
                            JsonToken token = parser.nextToken();
}
    }
                } else {
                }
                // Convert string array to list
                            // ES7 cname/ip:port format
                } else {
     */
                            assert token == JsonToken.START_OBJECT;
     * @param restClient client used to fetch the hosts from opensearch through nodes info api. Usually the same instance
        logger.trace("adding node [" + nodeId + "]");
import java.util.Objects;
    /**
                            while (parser.nextToken() != JsonToken.END_ARRAY) {
import org.opensearch.client.Node.Roles;
        boolean sawRoles = false;
            } else {
import static java.util.Collections.unmodifiableList;
            if (entry.getValue().startsWith("[")) {
                    parser.skipChildren();
 * KIND, either express or implied.  See the License for the
                            if (address.contains("/")) {
package org.opensearch.client.sniff;
        }
                if ("roles".equals(fieldName)) {
    @Override
import java.util.List;
            }
        Scheme(String name) {
import java.net.URI;
 * not use this file except in compliance with the License.
         * We sniff the bound hosts so we can look up the node based on any
     * @param scheme the scheme to associate sniffed nodes with (as it is not returned by opensearch)
 *
        Map<String, List<String>> realAttributes = new HashMap<>(protoAttributes.size());
    /**
            this.name = name;
            } else if (parser.currentToken() == JsonToken.START_OBJECT) {
                }
        // http section is not present if http is not enabled on the node, ignore such nodes
 * Class responsible for sniffing the http hosts from opensearch through the nodes info api and returning them back.
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (parser.nextToken() != JsonToken.START_OBJECT) {
                                    new HttpHost(boundAddressAsURI.getScheme(), boundAddressAsURI.getHost(), boundAddressAsURI.getPort())
 * Modifications Copyright OpenSearch Contributors. See
    public List<Node> sniff() throws IOException {
import java.util.ArrayList;
/*
                    }
                        }
     */
 * GitHub history for details.
                } else if ("attributes".equals(fieldName)) {
            } else if (parser.currentToken().isScalarValue()) {
    }
        if (sniffRequestTimeoutMillis < 0) {
                            }
                    if ("nodes".equals(parser.currentName())) {
import org.apache.commons.logging.Log;
    public static final long DEFAULT_SNIFF_REQUEST_TIMEOUT = TimeUnit.SECONDS.toMillis(1);
/*
                } else if ("name".equals(fieldName)) {
