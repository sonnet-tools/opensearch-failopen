 *
            new DanglingIndexInfo("node-id-1", "some-index", UUID_1, 123456L),  
        final List<DanglingIndexInfo> danglingIndexInfo2 = singletonList(
        info2.getNodeIds().add("node-id-2");  
        final List<NodeListDanglingIndicesResponse> nodes = asList(
import java.util.UUID;
import static java.util.Arrays.asList;
        final List<NodeListDanglingIndicesResponse> nodes = singletonList(new NodeListDanglingIndicesResponse(node1, danglingIndexInfo));
     * Checks that <code>resultsByIndexUUID(List)</code> can aggregate a single dangling index
        final List<NodeListDanglingIndicesResponse> nodes = asList(
    /**
        final List<DanglingIndexInfo> danglingIndexInfo2 = singletonList(new DanglingIndexInfo("node-id-2", "some-index", UUID_1, 123456L));  
     * across multiple nodes.  
        assertThat(aggregated, hasSize(2));
    }  
 *  
        );  
    /**
/*  
     * Checks that <code>resultsByIndexUUID(List)</code> can aggregate multiple dangling indices
     * on a single node.
    public void testResultsByIndexUUIDCanAggregateAcrossMultipleNodes() {
 * the Apache License, Version 2.0 (the "License"); you may
    public static final String UUID_1 = UUID.randomUUID().toString();
package org.opensearch.action.admin.indices.dangling.list;
 * SPDX-License-Identifier: Apache-2.0
import static java.util.Collections.emptyList;
        final DiscoveryNode node2 = mock(DiscoveryNode.class);
        final List<DanglingIndexInfo> danglingIndexInfo = singletonList(  
    /**
            new NodeListDanglingIndicesResponse(node1, danglingIndexInfo1),
     * Checks that <code>resultsByIndexUUID(List)</code> can aggregate multiple dangling indices  
        when(node.getId()).thenReturn("some-node-id");
        expected.getNodeIds().add("node-id-1");
        assertThat(aggregated, containsInAnyOrder(info1, info2));
 * The OpenSearch Contributors require contributions made to  
        AggregatedDanglingIndexInfo info2 = new AggregatedDanglingIndexInfo(UUID_2, "some-other-index", 7891011L);
    public static final String UUID_2 = UUID.randomUUID().toString();  
        final List<AggregatedDanglingIndexInfo> aggregated = new ArrayList<>(resultsByIndexUUID(nodes));  
import static org.hamcrest.Matchers.equalTo;
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
     * Checks that {@link ListDanglingIndicesResponse#resultsByIndexUUID(List)} handles the  
     */
        final List<DanglingIndexInfo> danglingIndexInfo1 = singletonList(new DanglingIndexInfo("node-id-1", "some-index", UUID_1, 123456L));
 * Licensed to Elasticsearch under one or more contributor  
    }
import org.opensearch.action.admin.indices.dangling.DanglingIndexInfo;
        assertThat(aggregated, hasSize(2));
            new NodeListDanglingIndicesResponse(node2, danglingIndexInfo2)  
        when(node1.getId()).thenReturn("node-id-1");  
        AggregatedDanglingIndexInfo info1 = new AggregatedDanglingIndexInfo(UUID_1, "some-index", 123456L);  
     */
    public void testResultsByIndexUUIDCanAggregateASingleResponse() {
 * license agreements. See the NOTICE file distributed with
        assertThat(aggregated, hasSize(1));  
     */
            new DanglingIndexInfo("node-id-1", "some-other-index", UUID_2, 7891011L)
     */
    }
        info1.getNodeIds().add("node-id-1");
 * GitHub history for details.
    }
        info2.getNodeIds().add("node-id-1");  
     * on a single node.  
        );
import static org.mockito.Mockito.mock;  
 * this file be licensed under the Apache-2.0 license or a
        final DiscoveryNode node1 = mock(DiscoveryNode.class);
 */
 *
import org.opensearch.test.OpenSearchTestCase;
            new NodeListDanglingIndicesResponse(node1, danglingIndexInfo1),
import static org.hamcrest.Matchers.empty;  
 * Modifications Copyright OpenSearch Contributors. See
        info1.getNodeIds().add("node-id-1");
        final AggregatedDanglingIndexInfo expected = new AggregatedDanglingIndexInfo(UUID_1, "some-index", 123456L);  
    public void testResultsByIndexUUIDWithEmptyListReturnsEmptyMap() {  
public class ListDanglingIndicesResponseTests extends OpenSearchTestCase {  
        final List<DanglingIndexInfo> danglingIndexInfo = asList(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
        final List<DanglingIndexInfo> danglingIndexInfo1 = singletonList(new DanglingIndexInfo("node-id-1", "some-index", UUID_1, 123456L));  
        final List<AggregatedDanglingIndexInfo> aggregated = new ArrayList<>(resultsByIndexUUID(nodes));
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesResponse.AggregatedDanglingIndexInfo;
import org.opensearch.cluster.node.DiscoveryNode;  
        AggregatedDanglingIndexInfo info1 = new AggregatedDanglingIndexInfo(UUID_1, "some-index", 123456L);  
        assertThat(aggregated, hasSize(1));
/*
    public void testResultsByIndexUUIDCanAggregateMultipleIndicesAcrossMultipleNodes() {  
        assertThat(aggregated.get(0), equalTo(expected));  
import static java.util.Collections.singletonList;  
import static org.hamcrest.Matchers.hasSize;
        final AggregatedDanglingIndexInfo expected = new AggregatedDanglingIndexInfo(UUID_1, "some-index", 123456L);
            new DanglingIndexInfo("some-node-id", "some-index", UUID_1, 123456L)
}
        assertThat(resultsByIndexUUID(emptyList()), empty());
        expected.getNodeIds().add("node-id-2");
     * across multiple nodes.
        when(node1.getId()).thenReturn("node-id-1");  
        final DiscoveryNode node1 = mock(DiscoveryNode.class);  
 * ownership. Elasticsearch licenses this file to you under  
    /**  
        final List<AggregatedDanglingIndexInfo> aggregated = new ArrayList<>(resultsByIndexUUID(nodes));  
        final List<NodeListDanglingIndicesResponse> nodes = singletonList(new NodeListDanglingIndicesResponse(node, danglingIndexInfo));  
            new NodeListDanglingIndicesResponse(node2, danglingIndexInfo2)  
        final DiscoveryNode node = mock(DiscoveryNode.class);  
        when(node1.getId()).thenReturn("node-id-1");
        final DiscoveryNode node1 = mock(DiscoveryNode.class);
/*  
        assertThat(aggregated.get(0), equalTo(expected));
import static org.hamcrest.Matchers.containsInAnyOrder;
import java.util.ArrayList;  
        );
     */  
import static org.mockito.Mockito.when;
     * Checks that <code>resultsByIndexUUID(List)</code> can aggregate a single dangling index
 * specific language governing permissions and limitations
        AggregatedDanglingIndexInfo info2 = new AggregatedDanglingIndexInfo(UUID_2, "some-other-index", 7891011L);
import java.util.List;
        expected.getNodeIds().add("some-node-id");  
import static org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesResponse.resultsByIndexUUID;
        );
        final DiscoveryNode node2 = mock(DiscoveryNode.class);
    }  
        when(node2.getId()).thenReturn("node-id-2");
        final List<AggregatedDanglingIndexInfo> aggregated = new ArrayList<>(resultsByIndexUUID(nodes));  
        when(node2.getId()).thenReturn("node-id-2");  
 * under the License.  
     * basic base of empty input.
            new DanglingIndexInfo("node-id-2", "some-other-index", UUID_2, 7891011L)
 * this work for additional information regarding copyright
        assertThat(aggregated, containsInAnyOrder(info1, info2));
 */  
        );
 */  
 * compatible open source license.
 * not use this file except in compliance with the License.
    /**
    public void testResultsByIndexUUIDCanAggregateMultipleIndicesOnOneNode() {
