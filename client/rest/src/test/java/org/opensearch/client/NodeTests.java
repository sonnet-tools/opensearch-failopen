            randomBoolean() ? null : singletonMap("foo", singletonList("bar"))
 * software distributed under the License is distributed on an
/*  
                )
                    node.getBoundHosts(),  
import static java.util.Collections.singleton;  
        assertEquals("[host=http://1, version=ver]", new Node(new HttpHost("1"), null, null, "ver", null, null).toString());  
import static org.junit.Assert.assertEquals;
 *
        assertTrue(node.equals(copy));
    public void testEqualsAndHashCode() {  
            randomBoolean() ? null : new Roles(new TreeSet<>(Arrays.asList("master", "data", "ingest"))),
 * this file be licensed under the Apache-2.0 license or a
        );  
        assertEquals(node.hashCode(), node.hashCode());  
                "nam",
                    node.getBoundHosts(),
        assertFalse(  
                    node.getVersion(),
 * The OpenSearch Contributors require contributions made to  
public class NodeTests extends RestClientTestCase {  
            )  
                .toString()
                    new Roles(Collections.emptySet()),  
 * SPDX-License-Identifier: Apache-2.0
 */  
            node.equals(
 * license agreements. See the NOTICE file distributed with
import static org.junit.Assert.assertTrue;
        assertThat(searchRole.isSearch(), equalTo(true));  
    }
        assertEquals("[host=http://1, name=nam]", new Node(new HttpHost("1"), null, "nam", null, null, null).toString());
                    node.getBoundHosts(),  
import static org.hamcrest.CoreMatchers.equalTo;  
        assertFalse(
package org.opensearch.client;
            node.equals(  
        assertFalse(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(  
        assertEquals(
import static org.junit.Assert.assertThat;  
                )
            )
    public void testIsSearchNode() {
                new Node(host, node.getBoundHosts(), node.getName() + "changed", node.getVersion(), node.getRoles(), node.getAttributes())  
                )
                new Roles(Collections.singleton("master")),  
import java.util.List;
 *
 * Modifications Copyright OpenSearch Contributors. See
                    host,
            host,  
            ).toString()
                    node.getName(),
 * under the License.  
                    node.getName(),  
                    node.getName(),  
 * GitHub history for details.
                    singletonMap("bort", singletonList("bing"))
 *    http://www.apache.org/licenses/LICENSE-2.0
        Map<String, List<String>> attributes = new HashMap<>();
            new Node(new HttpHost("1"), new HashSet<>(Arrays.asList(new HttpHost("1"), new HttpHost("2"))), null, null, null, null)
                    node.getAttributes()  
        assertEquals(
 * not use this file except in compliance with the License.
            new Node(new HttpHost("1"), null, null, null, null, attributes).toString()
        attributes.put("baz", Arrays.asList("bort", "zoom"));
}
                new HttpHost("1"),
import static java.util.Collections.singletonList;
        HttpHost host = new HttpHost(randomAsciiAlphanumOfLength(5));
                    node.getAttributes()
                    node.getRoles(),
            randomBoolean() ? null : singleton(host),
                new Node(host, node.getBoundHosts(), node.getName(), node.getVersion() + "changed", node.getRoles(), node.getAttributes())
                    node.getAttributes()  
/*  
                .toString()
        assertEquals("[host=http://1]", new Node(new HttpHost("1")).toString());
        assertFalse(
                    host,
            node.equals(  
                new Node(  
import org.opensearch.client.Node.Roles;
        );  
        );
        );  
        assertEquals(node.hashCode(), copy.hashCode());  
 * You may obtain a copy of the License at  
            "[host=http://1, roles=data,ingest,master]",
            randomBoolean() ? null : randomAsciiAlphanumOfLength(5),
    }
import java.util.TreeSet;
        assertEquals(
        assertFalse(node.equals(null));
 * KIND, either express or implied.  See the License for the
                + "name=nam, version=ver, roles=master, attributes={foo=[bar], baz=[bort, zoom]}]",  
        attributes.put("foo", singletonList("bar"));  
import java.util.HashMap;  
                new Node(
        );  
                new Node(  
import java.util.Collections;
 * compatible open source license.
                new Node(
                    new HttpHost(host.toHostString() + "changed"),
/*
            )  
                    node.getVersion(),
                    node.getRoles(),
        );
                    node.getName(),
                new HashSet<>(Arrays.asList(new HttpHost("1"), new HttpHost("2"))),  
import static org.junit.Assert.assertFalse;
                    node.getRoles(),  
            node.equals(
 * Unless required by applicable law or agreed to in writing,
import org.apache.hc.core5.http.HttpHost;
        );  
        Roles searchRole = new Roles(Collections.singleton("search"));
import java.util.Map;  
    }
                    node.getVersion(),
            new Node(
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
import static java.util.Collections.singletonMap;
            "[host=http://1, bound=[http://1, http://2], "
        );
            )
        assertFalse(
        );
 * ownership. Elasticsearch licenses this file to you under  
            )
            node.equals(
 *  
        );  
 * the Apache License, Version 2.0 (the "License"); you may
        Node node = new Node(
            new Node(new HttpHost("1"), null, null, null, new Roles(new TreeSet<>(Arrays.asList("master", "data", "ingest"))), null)  
                    node.getVersion(),
                "ver",
 */  
 * Licensed to Elasticsearch under one or more contributor  
        assertTrue(node.equals(node));
    public void testToString() {
                attributes
            )  
            node.equals(
                    new HashSet<>(Arrays.asList(host, new HttpHost(host.toHostString() + "changed"))),
            "[host=http://1, attributes={foo=[bar], baz=[bort, zoom]}]",
                    host,
            "[host=http://1, bound=[http://1, http://2]]",  
            randomBoolean() ? null : randomAsciiAlphanumOfLength(5),  
                )
import java.util.Arrays;
 */
        Node copy = new Node(host, node.getBoundHosts(), node.getName(), node.getVersion(), node.getRoles(), node.getAttributes());
        );
import java.util.HashSet;
        assertFalse(
