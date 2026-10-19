        assertEquals(expected, nodes);  
import static org.junit.Assert.assertEquals;
 *  
        NodeSelector.SKIP_DEDICATED_CLUSTER_MANAGERS.select(nodes);  
            randomAsciiAlphanumOfLength(5),
import java.util.ArrayList;
        List<Node> nodes = new ArrayList<>();
        if (ingest) {
        nodes.add(clusterManagerAndData);
    }
            randomAsciiAlphanumOfLength(5),
        nodes.add(all);
        assertEquals(expected, nodes);
        for (int i = 0; i < size; i++) {
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
        expected.remove(deprecatedMasterOnly);
     */
    public void testNotClusterManagerOnly() {  
            roles.add("ingest");
     * The test is a modified copy of the above testNotClusterManagerOnly().
        if (data) {
        Node clusterManagerAndData = dummyNode(true, true, false);  
 * GitHub history for details.
        nodes.add(clusterManagerOnly);
        assertEquals(expected, nodes);
        expected.remove(clusterManagerOnly);
        );
        nodes.add(all);
 * this file be licensed under the Apache-2.0 license or a
import java.util.TreeSet;
            new HttpHost("dummy"),
        Collections.shuffle(nodes, getRandom());
/*  
 * Modifications Copyright OpenSearch Contributors. See
        }  
        NodeSelector.SKIP_DEDICATED_CLUSTER_MANAGERS.select(nodes);
 */  
        int size = between(2, 5);  
            Collections.emptySet(),  
import java.util.Set;
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
        List<Node> nodes = new ArrayList<>();  
package org.opensearch.client;
import java.util.Collections;
    private static Node dummyNode(boolean clusterManager, boolean data, boolean ingest) {
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        nodes.add(clusterManagerAndIngest);  
 */  
        Node clusterManagerAndIngest = dummyNode(true, false, true);
        List<Node> expected = new ArrayList<>(nodes);
     * Validate SKIP_DEDICATED_CLUSTER_MANAGERS can filter both the deprecated "master" role and the new "cluster_manager" role.  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
        nodes.add(coordinatingOnly);
    }  
        expected.remove(clusterManagerOnly);  
            nodes.add(dummyNode(randomBoolean(), randomBoolean(), randomBoolean()));
        Node coordinatingOnly = dummyNode(false, false, false);
        nodes.add(deprecatedMasterOnly);
        }  
import org.apache.hc.core5.http.HttpHost;
        Node ingestOnly = dummyNode(false, false, true);  
        nodes.add(data);  
        nodes.add(ingestOnly);
 * ownership. Elasticsearch licenses this file to you under  
        Node all = dummyNode(true, true, true);
        return new Node(
    public void testDeprecatedNotMasterOnly() {  
import org.opensearch.client.Node.Roles;
        final Set<String> roles = new TreeSet<>();  
 * KIND, either express or implied.  See the License for the
        List<Node> nodes = new ArrayList<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
        Node clusterManagerOnly = dummyNode(true, false, false);
            Collections.emptyMap()
        if (clusterManager) {
    /*
        nodes.add(data);  
 *
 * software distributed under the License is distributed on an
}  
public class NodeSelectorTests extends RestClientTestCase {  
 * not use this file except in compliance with the License.
    public void testAny() {
            Collections.<HttpHost>emptySet(),  
 * license agreements. See the NOTICE file distributed with
            randomAsciiAlphanumOfLength(5),
        );
            new Roles(Collections.singleton("master")),  
        }  
            randomAsciiAlphanumOfLength(5),
        Node clusterManagerOnly = dummyNode(true, false, false);
        Node data = dummyNode(false, true, randomBoolean());
 * Licensed to Elasticsearch under one or more contributor  
 *
        Collections.shuffle(nodes, getRandom());
        Node all = dummyNode(true, true, true);
        Node data = dummyNode(false, true, randomBoolean());  
        }  
        List<Node> expected = new ArrayList<>(nodes);  
import java.util.List;  
 * under the License.  
 * compatible open source license.
            roles.add("data");
        nodes.add(clusterManagerOnly);  
    }
        List<Node> expected = new ArrayList<>(nodes);
            Collections.<String, List<String>>emptyMap()
            new Roles(roles),  
        NodeSelector.ANY.select(nodes);
    }  
/*  
        Node deprecatedMasterOnly = new Node(
            new HttpHost("dummy"),
            roles.add("cluster_manager");
