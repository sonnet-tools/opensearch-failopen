import tools.jackson.core.json.JsonFactory;
            node(9201, "m2", "1.0.0", "master", "data", "ingest"),
import java.util.Map;
            node(9202, "m3", "2.0.0", "cluster_manager", "ingest"),
            node(9205, "d3", "1.0.0", "data", "ingest"),  
            node(9203, "d1", "1.0.0", "data", "ingest"),
            node(9205, "d3", "2.0.0", "data", "ingest"),
            }
                assertEquals(expected[i], nodes.get(i));  
        List<Node> nodes = OpenSearchNodesSniffer.readHosts(entity, Scheme.HTTP, new JsonFactory());  
/*  
    public void test1x() throws IOException {
             */  
 *
 * not use this file except in compliance with the License.
        boundHosts.add(host);
 * compatible open source license.
import org.opensearch.client.RestClientTestCase;
    }
             * that is how we generated the file.
 * The OpenSearch Contributors require contributions made to  
    private Node node(int port, String name, String version, String... roles) {  
        Set<HttpHost> boundHosts = new HashSet<>(2);  
        checkFile(
        } finally {
 * license agreements. See the NOTICE file distributed with
 */  
    }
import java.util.List;  
 * Test parsing the response from the {@code /_nodes/http} API from fixed
        assertEquals(9200, nodes.get(0).getHost().getPort());  
 * the Apache License, Version 2.0 (the "License"); you may
/*
import org.apache.hc.core5.http.HttpHost;  
 */  
 * software distributed under the License is distributed on an
            node(9206, "c1", "2.0.0", "ingest"),  
            node(9203, "d1", "2.0.0", "data", "ingest"),  
            node(9207, "c2", "2.0.0", "ingest")
        }  
        if (in == null) {
 * this work for additional information regarding copyright
        assertEquals("http", nodes.get(0).getHost().getSchemeName());
        assertEquals("127.0.0.1", nodes.get(0).getHost().getHostName());
            for (int i = 0; i < expected.length; i++) {
 * Unless required by applicable law or agreed to in writing,
    }
        attributes.put("dummy", singletonList("everyone_has_me"));
        HttpEntity entity = new InputStreamEntity(in, ContentType.APPLICATION_JSON);
 *  
             * Use these assertions because the error messages are nicer  
import static org.hamcrest.Matchers.hasSize;
import java.util.HashSet;
            node(9202, "m3", "1.0.0", "master", "ingest"),  
 *
/**  
/*  
import org.opensearch.client.sniff.OpenSearchNodesSniffer.Scheme;
import static java.util.Collections.singletonList;
    }  
import java.io.InputStream;
        return new Node(host, boundHosts, name, version, new Roles(new TreeSet<>(roles)), attributes);
 * GitHub history for details.
            "2.0.0_nodes_http.json",
 * Licensed to Elasticsearch under one or more contributor  
 * versions of OpenSearch.
    public void testParsingPublishAddressWithES7Format() throws IOException {
import org.apache.hc.core5.http.ContentType;
        try {
             * than hasItems and we know the results are in order because
package org.opensearch.client.sniff;
            node(9204, "d2", "1.0.0", "data", "ingest"),
 * You may obtain a copy of the License at  
        );  
 *    http://www.apache.org/licenses/LICENSE-2.0
        HttpHost host = new HttpHost("127.0.0.1", port);
            node(9201, "m2", "2.0.0", "cluster_manager", "data", "ingest"),
            node(9204, "d2", "2.0.0", "data", "ingest"),
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
    public void test2x() throws IOException {  
            in.close();  
    private void checkFile(String file, Node... expected) throws IOException {  
            node(9207, "c2", "1.0.0", "ingest")
import java.io.IOException;
        assertEquals(9200, nodes.get(0).getHost().getPort());
            attributes.put("shard_indexing_pressure_enabled", singletonList(Boolean.TRUE.toString()));
    private Node node(int port, String name, String version, Set<String> roles) {
        assertEquals("http", nodes.get(0).getHost().getSchemeName());  
 * this file be licensed under the Apache-2.0 license or a
        );
 */
        }
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("es7_nodes_publication_address_format.json");
        if (!version.startsWith("1.0") && !version.startsWith("1.1")) {  
        boundHosts.add(new HttpHost("[::1]", port));
            // Shard Indexing Pressure feature is added in version 1.2.0
 * under the License.  
            node(9200, "m1", "1.0.0", "master", "ingest"),
import java.util.TreeSet;  
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
import org.opensearch.client.Node.Roles;  
 */  
import static org.junit.Assert.assertThat;
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("es6_nodes_publication_address_format.json");  
            node(9206, "c1", "1.0.0", "ingest"),
        Map<String, List<String>> attributes = new LinkedHashMap<>(); // LinkedHashMap to preserve insertion order  
            List<Node> nodes = OpenSearchNodesSniffer.readHosts(entity, Scheme.HTTP, new JsonFactory());
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
    public void testParsingPublishAddressWithPreES7Format() throws IOException {
            throw new IllegalArgumentException("Couldn't find [" + file + "]");  
        assertEquals("opensearch.test", nodes.get(0).getHost().getHostName());
        return node(port, name, version, new TreeSet<>(Arrays.asList(roles)));
import java.util.Set;
import org.apache.hc.core5.http.io.entity.InputStreamEntity;
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
        attributes.put("array", Arrays.asList(name.substring(0, 1), name.substring(1)));
        attributes.put("number", singletonList(name.substring(1)));
        List<Node> nodes = OpenSearchNodesSniffer.readHosts(entity, Scheme.HTTP, new JsonFactory());
import java.util.Arrays;  
            HttpEntity entity = new InputStreamEntity(in, ContentType.APPLICATION_JSON);  
            "1.0.0_nodes_http.json",  
import org.opensearch.client.Node;
    }  
        HttpEntity entity = new InputStreamEntity(in, ContentType.APPLICATION_JSON);
 * KIND, either express or implied.  See the License for the
import java.util.LinkedHashMap;
import static org.junit.Assert.assertEquals;  
            assertThat(nodes, hasSize(expected.length));
            node(9200, "m1", "2.0.0", "cluster_manager", "ingest"),  
import org.apache.hc.core5.http.HttpEntity;
public class OpenSearchNodesSnifferParseTests extends RestClientTestCase {
        }
    }
        checkFile(
            /*
