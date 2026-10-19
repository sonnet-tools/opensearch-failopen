 * compatible open source license.
 * software distributed under the License is distributed on an
        if (randomBoolean()) {  
import org.apache.hc.core5.http.HttpHost;
        }
import java.util.Collections;  
        }
/*  
 * license agreements. See the NOTICE file distributed with
 */  
 *  
        final Set<String> roles = new TreeSet<>();
        Node hasAttributeButNotValue = dummyNode(singletonMap("attr", singletonList("notval")));
 * GitHub history for details.
import java.util.Arrays;
            roles.add("ingest");
            Collections.<HttpHost>emptySet(),
 * under the License.  
 *
            attributes  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testHasAttribute() {
        if (randomBoolean()) {  
        List<Node> nodes = new ArrayList<>();
import static org.junit.Assert.assertEquals;
 * Modifications Copyright OpenSearch Contributors. See
public class HasAttributeNodeSelectorTests extends RestClientTestCase {
import java.util.TreeSet;
 * The OpenSearch Contributors require contributions made to  
 *
            randomAsciiAlphanumOfLength(5),  
import org.opensearch.client.Node.Roles;
    }
        );
        nodes.add(hasAttributeValue);
            roles.add("data");
import java.util.ArrayList;
    }
 * specific language governing permissions and limitations
        nodes.add(hasAttributeValueInList);
 * You may obtain a copy of the License at  
        new HasAttributeNodeSelector("attr", "val").select(nodes);  
            new HttpHost("dummy"),
import java.util.Set;  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * not use this file except in compliance with the License.
        expected.add(hasAttributeValueInList);
package org.opensearch.client;
        nodes.add(notHasAttribute);
        Node hasAttributeValue = dummyNode(singletonMap("attr", singletonList("val")));  
 * this work for additional information regarding copyright
        if (randomBoolean()) {  
        assertEquals(expected, nodes);
 * Unless required by applicable law or agreed to in writing,
/*
 * Licensed to Elasticsearch under one or more contributor  
        nodes.add(hasAttributeButNotValue);  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        Node notHasAttribute = dummyNode(singletonMap("notattr", singletonList("val")));  
        return new Node(  
    private static Node dummyNode(Map<String, List<String>> attributes) {
        Node hasAttributeValueInList = dummyNode(singletonMap("attr", Arrays.asList("val", "notval")));
        List<Node> expected = new ArrayList<>();  
            new Roles(roles),
}  
            randomAsciiAlphanumOfLength(5),
 */  
import static java.util.Collections.singletonList;  
        expected.add(hasAttributeValue);
import java.util.Map;
            roles.add("master");
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
 */
import static java.util.Collections.singletonMap;
