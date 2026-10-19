 * You may obtain a copy of the License at
    }
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesResponse.resultsByIndexUUID;
    }
        final DiscoveryNode node2 = mock(DiscoveryNode.class);
        final DiscoveryNode node1 = mock(DiscoveryNode.class);
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to
 *    http://www.apache.org/licenses/LICENSE-2.0
        final AggregatedDanglingIndexInfo expected = new AggregatedDanglingIndexInfo(UUID_1, "some-index", 123456L);
        final DiscoveryNode node2 = mock(DiscoveryNode.class);
    /**
            new DanglingIndexInfo("node-id-1", "some-other-index", UUID_2, 7891011L)
        expected.getNodeIds().add("node-id-2");
        final List<AggregatedDanglingIndexInfo> aggregated = new ArrayList<>(resultsByIndexUUID(nodes));
        );
import static org.hamcrest.Matchers.empty;
        final List<AggregatedDanglingIndexInfo> aggregated = new ArrayList<>(resultsByIndexUUID(nodes));
 * software distributed under the License is distributed on an
     * Checks that <code>resultsByIndexUUID(List)</code> can aggregate multiple dangling indices
import org.opensearch.test.OpenSearchTestCase;
        final DiscoveryNode node1 = mock(DiscoveryNode.class);
        final DiscoveryNode node = mock(DiscoveryNode.class);
        info1.getNodeIds().add("node-id-1");
        final List<AggregatedDanglingIndexInfo> aggregated = new ArrayList<>(resultsByIndexUUID(nodes));
import static org.mockito.Mockito.mock;
 * Licensed to Elasticsearch under one or more contributor
import java.util.UUID;
        when(node1.getId()).thenReturn("node-id-1");
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesResponse.AggregatedDanglingIndexInfo;
import static java.util.Collections.singletonList;
            new DanglingIndexInfo("node-id-1", "some-index", UUID_1, 123456L),
        expected.getNodeIds().add("some-node-id");
     * Checks that <code>resultsByIndexUUID(List)</code> can aggregate multiple dangling indices
import static org.hamcrest.Matchers.hasSize;
        final List<DanglingIndexInfo> danglingIndexInfo = singletonList(
import org.opensearch.cluster.node.DiscoveryNode;
        assertThat(aggregated, containsInAnyOrder(info1, info2));
    public void testResultsByIndexUUIDCanAggregateAcrossMultipleNodes() {
        when(node1.getId()).thenReturn("node-id-1");
        final AggregatedDanglingIndexInfo expected = new AggregatedDanglingIndexInfo(UUID_1, "some-index", 123456L);
        );
 * compatible open source license.
        final List<NodeListDanglingIndicesResponse> nodes = singletonList(new NodeListDanglingIndicesResponse(node, danglingIndexInfo));
     */
 */
 *
        assertThat(aggregated, containsInAnyOrder(info1, info2));
     */
        assertThat(aggregated.get(0), equalTo(expected));
        info2.getNodeIds().add("node-id-2");
        assertThat(aggregated, hasSize(1));
    /**
            new NodeListDanglingIndicesResponse(node1, danglingIndexInfo1),
import org.opensearch.action.admin.indices.dangling.DanglingIndexInfo;
        AggregatedDanglingIndexInfo info1 = new AggregatedDanglingIndexInfo(UUID_1, "some-index", 123456L);
        final List<DanglingIndexInfo> danglingIndexInfo1 = singletonList(new DanglingIndexInfo("node-id-1", "some-index", UUID_1, 123456L));
            new NodeListDanglingIndicesResponse(node2, danglingIndexInfo2)
     * Checks that {@link ListDanglingIndicesResponse#resultsByIndexUUID(List)} handles the
        assertThat(aggregated, hasSize(2));
 */
        when(node2.getId()).thenReturn("node-id-2");
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
package org.opensearch.action.admin.indices.dangling.list;
 *
    }
        when(node.getId()).thenReturn("some-node-id");
}
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
        final List<DanglingIndexInfo> danglingIndexInfo = asList(
    }
    public static final String UUID_1 = UUID.randomUUID().toString();
        );
 */
     */
 * ownership. Elasticsearch licenses this file to you under
        AggregatedDanglingIndexInfo info2 = new AggregatedDanglingIndexInfo(UUID_2, "some-other-index", 7891011L);
    }
        );
        assertThat(resultsByIndexUUID(emptyList()), empty());
     * Checks that <code>resultsByIndexUUID(List)</code> can aggregate a single dangling index
public class ListDanglingIndicesResponseTests extends OpenSearchTestCase {
        final List<NodeListDanglingIndicesResponse> nodes = asList(
/*
            new NodeListDanglingIndicesResponse(node2, danglingIndexInfo2)
import static java.util.Arrays.asList;
    public void testResultsByIndexUUIDCanAggregateASingleResponse() {
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
import java.util.ArrayList;
import static org.mockito.Mockito.when;
        final List<DanglingIndexInfo> danglingIndexInfo1 = singletonList(new DanglingIndexInfo("node-id-1", "some-index", UUID_1, 123456L));
        info2.getNodeIds().add("node-id-1");
        final List<NodeListDanglingIndicesResponse> nodes = singletonList(new NodeListDanglingIndicesResponse(node1, danglingIndexInfo));
import static org.hamcrest.Matchers.containsInAnyOrder;
    /**
     * basic base of empty input.
 * Unless required by applicable law or agreed to in writing,
import static java.util.Collections.emptyList;
     */
    public void testResultsByIndexUUIDCanAggregateMultipleIndicesAcrossMultipleNodes() {
     * Checks that <code>resultsByIndexUUID(List)</code> can aggregate a single dangling index
        when(node2.getId()).thenReturn("node-id-2");
     */
        assertThat(aggregated.get(0), equalTo(expected));
        final List<DanglingIndexInfo> danglingIndexInfo2 = singletonList(new DanglingIndexInfo("node-id-2", "some-index", UUID_1, 123456L));
        when(node1.getId()).thenReturn("node-id-1");
        final List<DanglingIndexInfo> danglingIndexInfo2 = singletonList(
     * across multiple nodes.
        AggregatedDanglingIndexInfo info2 = new AggregatedDanglingIndexInfo(UUID_2, "some-other-index", 7891011L);
/*
    public void testResultsByIndexUUIDWithEmptyListReturnsEmptyMap() {
        AggregatedDanglingIndexInfo info1 = new AggregatedDanglingIndexInfo(UUID_1, "some-index", 123456L);
        final DiscoveryNode node1 = mock(DiscoveryNode.class);
     * on a single node.
 * under the License.
        info1.getNodeIds().add("node-id-1");
    public static final String UUID_2 = UUID.randomUUID().toString();
    /**
 * KIND, either express or implied.  See the License for the
        assertThat(aggregated, hasSize(1));
import static org.hamcrest.Matchers.equalTo;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * across multiple nodes.
/*
        expected.getNodeIds().add("node-id-1");
            new NodeListDanglingIndicesResponse(node1, danglingIndexInfo1),
 * specific language governing permissions and limitations
    /**
        );
 *
        final List<AggregatedDanglingIndexInfo> aggregated = new ArrayList<>(resultsByIndexUUID(nodes));
        assertThat(aggregated, hasSize(2));
            new DanglingIndexInfo("node-id-2", "some-other-index", UUID_2, 7891011L)
            new DanglingIndexInfo("some-node-id", "some-index", UUID_1, 123456L)
     * on a single node.
        final List<NodeListDanglingIndicesResponse> nodes = asList(
    public void testResultsByIndexUUIDCanAggregateMultipleIndicesOnOneNode() {
 * GitHub history for details.
