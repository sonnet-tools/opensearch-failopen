            roles.add("ingest");
import org.opensearch.client.Node.Roles;
 * GitHub history for details.
import java.util.ArrayList;
/*  
        expected.add(hasAttributeValue);
            new HttpHost("dummy"),
 */  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
        List<Node> nodes = new ArrayList<>();
 * under the License.  
 * this work for additional information regarding copyright
public class PreferHasAttributeNodeSelectorTests extends RestClientTestCase {
import java.util.TreeSet;
            roles.add("data");
package org.opensearch.client;
}
        nodes.add(hasAttributeValueInList);
 *  
        List<Node> expected = new ArrayList<>();
/*  
 *
/*
        return new Node(
        if (randomBoolean()) {
        new PreferHasAttributeNodeSelector("attr", "val").select(nodes);  
        Node hasAttributeButNotValue = dummyNode(singletonMap("attr", singletonList("notval")));
    public void testNotFoundPreferHasAttribute() {
        List<Node> nodes = new ArrayList<>();  
 * Unless required by applicable law or agreed to in writing,
import java.util.Collections;  
            Collections.<HttpHost>emptySet(),  
import java.util.Map;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
    private static Node dummyNode(Map<String, List<String>> attributes) {
            randomAsciiAlphanumOfLength(5),
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * not use this file except in compliance with the License.
 *
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
    public void testFoundPreferHasAttribute() {
        }  
        }  
        assertEquals(expected, nodes);
 *    http://www.apache.org/licenses/LICENSE-2.0
        List<Node> expected = new ArrayList<>();  
import java.util.Set;  
import java.util.Arrays;
        assertEquals(expected, nodes);
 * KIND, either express or implied.  See the License for the
        final Set<String> roles = new TreeSet<>();  
        nodes.add(notHasAttribute);
        Node hasAttributeValue = dummyNode(singletonMap("attr", singletonList("val")));  
        Node notHasAttribute = dummyNode(singletonMap("notattr", singletonList("val")));  
        nodes.add(notHasAttribute);
import java.util.List;
        expected.add(hasAttributeValueInList);
    }  
        );
 * this file be licensed under the Apache-2.0 license or a
        }  
import static org.junit.Assert.assertEquals;
    }  
            roles.add("master");
        new PreferHasAttributeNodeSelector("attr", "val").select(nodes);
            new Roles(roles),  
        nodes.add(hasAttributeValue);
 * software distributed under the License is distributed on an
 */
        Node notHasAttribute = dummyNode(singletonMap("notattr", singletonList("val")));
        if (randomBoolean()) {
            randomAsciiAlphanumOfLength(5),
 * Modifications Copyright OpenSearch Contributors. See
import static java.util.Collections.singletonList;  
import org.apache.hc.core5.http.HttpHost;
        nodes.add(hasAttributeButNotValue);  
    }
        if (randomBoolean()) {
        Node hasAttributeValueInList = dummyNode(singletonMap("attr", Arrays.asList("val", "notval")));
            attributes
import static java.util.Collections.singletonMap;
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
        expected.add(notHasAttribute);  
