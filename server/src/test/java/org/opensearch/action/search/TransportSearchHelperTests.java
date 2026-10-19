        assertThat(parseScrollId.getContext()[2].getSearchContextId().getSessionId(), equalTo("c"));
            node3
 * this file be licensed under the Apache-2.0 license or a
        // Craft a scroll_id with a varint-encoded count far exceeding the payload size.  
        assertEquals("cluster_x", parseScrollId.getContext()[0].getClusterAlias());
        assertEquals("node_3", parseScrollId.getContext()[2].getNode());
public class TransportSearchHelperTests extends OpenSearchTestCase {  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> TransportSearchHelper.parseScrollId(scrollId));
 * specific language governing permissions and limitations
        return array;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String scrollId = TransportSearchHelper.buildScrollId(queryResults, version);
        assertEquals("Cannot parse scroll id", e.getMessage());  
        baos.write(1); // vint string length
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals(3, parseScrollId.getContext().length);  
        );
        ParsedScrollId parseScrollId = TransportSearchHelper.parseScrollId(scrollId);
        baos.write('q');
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
        String scrollId = Base64.getUrlEncoder().encodeToString(baos.toByteArray());  
 * KIND, either express or implied.  See the License for the
        baos.write(0xFF);
            node1  
        baos.write(0xFF);
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * GitHub history for details.
        DiscoveryNode node2 = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
/*
}
        array.setOnce(0, testSearchPhaseResult1);
import org.opensearch.search.SearchShardTarget;
import org.opensearch.search.internal.ShardSearchContextId;  
 * software distributed under the License is distributed on an
        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult3 = new SearchAsyncActionTests.TestSearchPhaseResult(
    public void testParseScrollId() {
        AtomicArray<SearchPhaseResult> array = new AtomicArray<>(3);  
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.equalTo;
        assertEquals(12, parseScrollId.getContext()[1].getSearchContextId().getId());
        baos.write(0xFF);  
import org.opensearch.common.util.concurrent.AtomicArray;
        assertEquals("node_2", parseScrollId.getContext()[1].getNode());  
import org.opensearch.core.index.shard.ShardId;  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
            new ShardSearchContextId("b", 12),
import org.opensearch.search.SearchPhaseResult;
 * Unless required by applicable law or agreed to in writing,
        testSearchPhaseResult1.setSearchShardTarget(new SearchShardTarget("node_1", new ShardId("idx", "uuid1", 2), "cluster_x", null));
            new ShardSearchContextId("c", 42),  
        testSearchPhaseResult2.setSearchShardTarget(new SearchShardTarget("node_2", new ShardId("idy", "uuid2", 42), "cluster_y", null));
        final Version version = VersionUtils.randomVersion(random());
 * compatible open source license.
        final AtomicArray<SearchPhaseResult> queryResults = generateQueryResults();  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See  
        );  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.Version;  
 */  
        // Write type string: length=1, char='q' (any valid type)  
 *
        DiscoveryNode node3 = new DiscoveryNode("node_3", buildNewFakeTransportAddress(), Version.CURRENT);  
        );
import org.opensearch.test.VersionUtils;
        baos.write(0x07);
import java.io.ByteArrayOutputStream;
 * license agreements. See the NOTICE file distributed with
        baos.write(0xFF);
        array.setOnce(1, testSearchPhaseResult2);
        // Write a massive vint count (Integer.MAX_VALUE encoded as 5-byte varint)  
            new ShardSearchContextId("a", 1),
        // This would previously cause an OOM by allocating a huge array.
        assertThat(parseScrollId.getContext()[1].getSearchContextId().getSessionId(), equalTo("b"));  
 */
        array.setOnce(2, testSearchPhaseResult3);  
    }
/*  
        DiscoveryNode node1 = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
/*
package org.opensearch.action.search;
        assertEquals("cluster_y", parseScrollId.getContext()[1].getClusterAlias());
        assertEquals("node_1", parseScrollId.getContext()[0].getNode());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult2 = new SearchAsyncActionTests.TestSearchPhaseResult(  
    }  
        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult1 = new SearchAsyncActionTests.TestSearchPhaseResult(
import java.util.Base64;
        assertThat(parseScrollId.getContext()[0].getSearchContextId().getSessionId(), equalTo("a"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(42, parseScrollId.getContext()[2].getSearchContextId().getId());
    public void testParseScrollIdRejectsOversizedCount() throws Exception {
    public static AtomicArray<SearchPhaseResult> generateQueryResults() {
        assertEquals(1, parseScrollId.getContext()[0].getSearchContextId().getId());  
 *
 *  
        testSearchPhaseResult3.setSearchShardTarget(new SearchShardTarget("node_3", new ShardId("idy", "uuid2", 43), null, null));  
 */
        assertNull(parseScrollId.getContext()[2].getClusterAlias());  
            node2
