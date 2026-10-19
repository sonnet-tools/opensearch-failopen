        for (int indexName = 0; indexName < totalIndices; indexName++) {  
        sortField.setMissingValue(SortField.STRING_LAST);
            new ShardSegments[] { shardSegments },  
 * this work for additional information regarding copyright
/*  
        ShardSegments shardSegments = new ShardSegments(shardRouting, Collections.singletonList(segment));
import org.opensearch.index.engine.Segment;
            for (int shardId = 0; shardId < shardsPerIndex; shardId++) {
            }  
        ShardRouting shardRouting = TestShardRouting.newShardRouting("foo", 0, "node_id", true, ShardRoutingState.STARTED);  
/*  
}  
 * GitHub history for details.
                    segmentList.add(new Segment("foo" + indexName + shardId + segmentNum));
                    ShardRoutingState.STARTED
        Collections.shuffle(shardSegmentsList, random());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            response.toXContent(builder, ToXContent.EMPTY_PARAMS);
            totalIndices * shardsPerIndex,
                    "node_id",
 * license agreements. See the NOTICE file distributed with
        for (Map.Entry<String, IndexSegments> indexSegmentEntry : indicesSegments.entrySet()) {
            1,
import org.opensearch.core.xcontent.XContentBuilder;
        IndicesSegmentResponse response = new IndicesSegmentResponse(
            for (IndexShardSegments indexShardSegment : indexSegmentEntry.getValue().getShards().values()) {
        // Preparing a ShardSegments list, which will have (totalIndices * shardsPerIndex) shardSegments.  
 *    http://www.apache.org/licenses/LICENSE-2.0
        Segment segment = new Segment("my");
import java.util.Collections;  
 */  
                    }
        );
    }
 */
        final int totalIndices = 5;  
import java.util.ArrayList;
import org.apache.lucene.search.Sort;
        );
package org.opensearch.action.admin.indices.segments;
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
                ShardRouting shardRouting = TestShardRouting.newShardRouting(
 * under the License.  
                List<Segment> segmentList = new ArrayList<>();  
 * SPDX-License-Identifier: Apache-2.0
            shardSegmentsList.toArray(new ShardSegments[0]),
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.ToXContent;  
                    "foo" + indexName,  
    }  
        // Indices will be named -> foo1, foo2, ..., foo{totalIndices}
                        String segmentName = indexSegmentEntry.getKey() + shardSegment.getShardRouting().getId() + i;
        final int segmentsPerShard = 2;
 *
import org.opensearch.cluster.routing.TestShardRouting;
                }
 * ownership. Elasticsearch licenses this file to you under  
 *
            totalIndices * shardsPerIndex,  
/*
 * compatible open source license.
        IndicesSegmentResponse response = new IndicesSegmentResponse(
public class IndicesSegmentResponseTests extends OpenSearchTestCase {  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                );
 * Modifications Copyright OpenSearch Contributors. See
    public void testGetIndices() {
import org.apache.lucene.search.SortField;
 * You may obtain a copy of the License at  
        assertEquals(totalIndices, indicesSegments.size());
 * this file be licensed under the Apache-2.0 license or a
                    for (int i = 0; i < segmentsPerShard; i++) {
            Collections.emptyList()  
                for (int segmentNum = 0; segmentNum < segmentsPerShard; segmentNum++) {
            1,
        Map<String, IndexSegments> indicesSegments = response.getIndices();
        try (XContentBuilder builder = jsonBuilder()) {  
            }
 * not use this file except in compliance with the License.
                    true,  
import java.util.Map;
import java.util.List;
 * specific language governing permissions and limitations
                for (ShardSegments shardSegment : indexShardSegment.getShards()) {
        List<ShardSegments> shardSegmentsList = new ArrayList<>();
                        assertEquals(segmentName, shardSegment.getSegments().get(i).getName());  
    public void testToXContentSerialiationWithSortedFields() throws Exception {
        SortField sortField = new SortField("foo", SortField.Type.STRING);  
            assertEquals(shardsPerIndex, indexSegmentEntry.getValue().getShards().size());  
 *  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
            0,  
            Collections.emptyList()
        // Prepare the IndicesSegmentResponse object and get the indicesSegments map  
            0,
                }  
        }
import org.opensearch.cluster.routing.ShardRoutingState;
        }
        }  
        final int shardsPerIndex = 3;
import org.opensearch.test.OpenSearchTestCase;  
 * Licensed to Elasticsearch under one or more contributor  
                    shardId,
 */  
                    assertEquals(segmentsPerShard, shardSegment.getSegments().size());  
import org.opensearch.cluster.routing.ShardRouting;  
        segment.segmentSort = new Sort(sortField);
                shardSegmentsList.add(new ShardSegments(shardRouting, segmentList));
