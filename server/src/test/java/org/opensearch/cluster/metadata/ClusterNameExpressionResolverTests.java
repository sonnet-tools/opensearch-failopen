 */
        List<String> clusters = clusterNameResolver.resolveClusterNames(remoteClusters, "totally*2");  
 * software distributed under the License is distributed on an
        assertEquals(new HashSet<>(Arrays.asList("cluster1")), new HashSet<>(clusters));  
        List<String> clusters = clusterNameResolver.resolveClusterNames(remoteClusters, "*");
import java.util.List;
    }
import java.util.Arrays;  
 * compatible open source license.
 *
/*  
 * license agreements. See the NOTICE file distributed with
        List<String> clusters = clusterNameResolver.resolveClusterNames(remoteClusters, "totallyDifferent2");
/*  
 * not use this file except in compliance with the License.
    public void testMiddleWildCard() {
 */  
    public void testPrefixWildCard() {
 * Licensed to Elasticsearch under one or more contributor  
        assertTrue(clusters.isEmpty());
}
        List<String> clusters = clusterNameResolver.resolveClusterNames(remoteClusters, "totallyDifferent");
        remoteClusters.add("cluster1");
        assertEquals(new HashSet<>(Arrays.asList("cluster1", "cluster2", "totallyDifferent")), new HashSet<>(clusters));  
        remoteClusters.add("totallyDifferent");
    }
        assertEquals(new HashSet<>(Arrays.asList("cluster1", "cluster2")), new HashSet<>(clusters));
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
    }  
 *  
        assertTrue(clusters.isEmpty());
        remoteClusters.add("cluster2");  
    public void testSuffixWildCard() {  
 */  
        assertEquals(new HashSet<>(Arrays.asList("totallyDifferent")), new HashSet<>(clusters));  
 * ownership. Elasticsearch licenses this file to you under  
/*
    }
 * this work for additional information regarding copyright
import org.opensearch.test.OpenSearchTestCase;
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
import java.util.HashSet;
    private ClusterNameExpressionResolver clusterNameResolver = new ClusterNameExpressionResolver();
    public void testWildCardNoMatch() {
    private static final Set<String> remoteClusters = new HashSet<>();
    }
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
import java.util.Set;  
    public void testExactMatch() {
 *
        List<String> clusters = clusterNameResolver.resolveClusterNames(remoteClusters, "clu*1");
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.cluster.metadata;
public class ClusterNameExpressionResolverTests extends OpenSearchTestCase {
        assertEquals(new HashSet<>(Arrays.asList("totallyDifferent")), new HashSet<>(clusters));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        List<String> clusters = clusterNameResolver.resolveClusterNames(remoteClusters, "cluster*");
 * this file be licensed under the Apache-2.0 license or a
    }  
    public void testSimpleWildCard() {
 * under the License.  
        List<String> clusters = clusterNameResolver.resolveClusterNames(remoteClusters, "*Different");  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
    static {
    public void testNoWildCardNoMatch() {  
 * KIND, either express or implied.  See the License for the
