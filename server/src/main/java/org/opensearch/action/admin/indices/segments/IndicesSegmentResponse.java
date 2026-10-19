        static final String NUM_COMMITTED_SEGMENTS = "num_committed_segments";  
    /**
import java.util.Arrays;
        // Add the last shardSegment from shards list which would have got missed in the loop above  
        static final String STATE = "state";
            builder.endObject();
                        }
        int startIndexPos = 0;  
        Arrays.sort(shards, Comparator.comparing(shardSegment -> shardSegment.getShardRouting().getIndexName()));
                        }
    public void writeTo(StreamOutput out) throws IOException {
                        }
public class IndicesSegmentResponse extends BroadcastResponse {  
            }
                startIndexPos = i;
        static final String RELOCATING_NODE = "relocating_node";
import org.opensearch.common.annotation.PublicApi;  
    private final ShardSegments[] shards;
 * this file be licensed under the Apache-2.0 license or a
        static final String MERGE_ID = "merge_id";
 */  
                for (ShardSegments shardSegments : indexSegment) {
 *  
 *
        static final String NUM_DOCS = "num_docs";
 * The OpenSearch Contributors require contributions made to  
                builder.startArray(Integer.toString(indexSegment.getShardId().id()));
        static final String PRIMARY = "primary";  
        super(totalShards, successfulShards, failedShards, shardFailures);  
 * You may obtain a copy of the License at  
     * @opensearch.internal
        if (indicesSegments != null) {
                        if (segment.isCompound() != null) {  
        static final String VERSION = "version";
        builder.endObject();
 */
/*  
                            builder.field(Fields.COMPOUND, segment.isCompound());
                    builder.endObject();
        for (SortField field : sort.getSort()) {  
                    builder.field(Fields.NODE, shardSegments.getShardRouting().currentNodeId());
    }
                        builder.endObject();  
            builder.startObject(Fields.SHARDS);
import org.opensearch.core.common.io.stream.StreamInput;
            builder.field("reverse", field.getReverse());
        this.shards = shards;
 * license agreements. See the NOTICE file distributed with
    }  
        static final String COMMITTED = "committed";  
import org.apache.lucene.search.Sort;
        String startIndexName = shards[startIndexPos].getShardRouting().getIndexName();
        static final String RAM_TREE = "ram_tree";
                        builder.field(Fields.NUM_DOCS, segment.getNumDocs());  
/*
                    }
                        builder.field(Fields.DELETED_DOCS, segment.getDeletedDocs());
    static final class Fields {
                            builder.field(Fields.VERSION, segment.getVersion());
    }
        shards = in.readArray(ShardSegments::new, ShardSegments[]::new);
import org.opensearch.core.common.io.stream.StreamOutput;  
        static final String NODE = "node";
                        builder.field(Fields.COMMITTED, segment.isCommitted());
                        builder.field(Fields.GENERATION, segment.getGeneration());
    IndicesSegmentResponse(StreamInput in) throws IOException {  
                        if (segment.getVersion() != null) {  
                        builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, segment.getSize());
 *
 * KIND, either express or implied.  See the License for the
        builder.startObject(Fields.INDICES);  
import java.util.Map;
            } else if (field instanceof SortedSetSortField) {
                    builder.startObject();  
        builder.startArray("sort");
        indicesSegments.put(startIndexName, new IndexSegments(startIndexName, Arrays.copyOfRange(shards, startIndexPos, shards.length)));
            this.indicesSegments = indicesSegments;
            if (field instanceof SortedNumericSortField) {  
 * ownership. Elasticsearch licenses this file to you under  
                builder.field("mode", ((SortedSetSortField) field).getSelector().toString().toLowerCase(Locale.ROOT));  
import org.opensearch.core.xcontent.XContentBuilder;
 */
                    }
            builder.endObject();  
                        builder.field(Fields.RELOCATING_NODE, shardSegments.getShardRouting().relocatingNodeId());
    }
                        builder.field(Fields.SEARCH, segment.isSearch());
            builder.startObject();
import org.apache.lucene.search.SortedNumericSortField;  
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
            for (IndexShardSegments indexSegment : indexSegments) {  
    @Override
        static final String SIZE_IN_BYTES = "size_in_bytes";
    }  
                startIndexName = shards[startIndexPos].getShardRouting().getIndexName();  
/**  
        static final String GENERATION = "generation";
        out.writeArray(shards);
            builder.startObject(indexSegments.getIndex());  
 * compatible open source license.
package org.opensearch.action.admin.indices.segments;
        super.writeTo(out);  
        if (shards.length == 0) {  
        static final String SIZE = "size";
 * specific language governing permissions and limitations
            return indicesSegments;
    }
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
 * under the License.  
 *
        int successfulShards,
/*  
                    builder.field(Fields.PRIMARY, shardSegments.getShardRouting().primary());
        static final String MEMORY = "memory";
        static final String NUM_SEARCH_SEGMENTS = "num_search_segments";
        static final String INDICES = "indices";
            }
     */  
        }
                indicesSegments.put(startIndexName, new IndexSegments(startIndexName, Arrays.copyOfRange(shards, startIndexPos, i)));
        }
                    builder.field(Fields.NUM_COMMITTED_SEGMENTS, shardSegments.getNumberOfCommitted());
 * Licensed to Elasticsearch under one or more contributor  
        static final String SEGMENTS = "segments";
                        builder.startObject(segment.getName());
 * Unless required by applicable law or agreed to in writing,
        }
            return indicesSegments;  
import java.util.HashMap;
        static final String SHARDS = "shards";  
            builder.field("field", field.getField());
        int failedShards,  
     * Fields for parsing and toXContent  
import java.io.IOException;
                        }
        ShardSegments[] shards,  
}
    ) {
                builder.field("missing", field.getMissingValue().toString());  
@PublicApi(since = "1.0.0")
                }
        this.indicesSegments = indicesSegments;  
                        if (segment.attributes != null && segment.attributes.isEmpty() == false) {  
 */  
                    builder.startObject(Fields.SEGMENTS);
                    builder.field(Fields.NUM_SEARCH_SEGMENTS, shardSegments.getNumberOfSearch());  
    IndicesSegmentResponse(
import org.apache.lucene.search.SortedSetSortField;
                    builder.endObject();
        static final String MEMORY_IN_BYTES = "memory_in_bytes";  
                    builder.endObject();  
        for (IndexSegments indexSegments : getIndices().values()) {
        }
            }
    protected void addCustomXContentFields(XContentBuilder builder, Params params) throws IOException {
        static final String COMPOUND = "compound";  
 * SPDX-License-Identifier: Apache-2.0
        Map<String, IndexSegments> indicesSegments = new HashMap<>();
        for (int i = 0; i < shards.length; i++) {
                    builder.field(Fields.STATE, shardSegments.getShardRouting().state());  
    public Map<String, IndexSegments> getIndices() {
import java.util.List;
import java.util.Locale;  
                            builder.field("attributes", segment.attributes);
            }
 * Modifications Copyright OpenSearch Contributors. See
        static final String DESCRIPTION = "description";
        super(in);
 * Transport response for retrieving indices segment information
                    for (Segment segment : shardSegments) {  
            builder.endObject();
                builder.field("mode", ((SortedNumericSortField) field).getSelector().toString().toLowerCase(Locale.ROOT));
            if (!shards[i].getShardRouting().getIndexName().equals(startIndexName)) {  
import org.apache.lucene.search.SortField;
import org.opensearch.index.engine.Segment;
                    builder.startObject(Fields.ROUTING);
                            builder.field(Fields.MERGE_ID, segment.getMergeId());
import org.opensearch.action.support.broadcast.BroadcastResponse;
        builder.endArray();
            if (field.getMissingValue() != null) {
        return indicesSegments;
                        if (segment.getMergeId() != null) {  
                        if (segment.getSegmentSort() != null) {  
 * @opensearch.api  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        List<DefaultShardOperationFailedException> shardFailures
     *
    private Map<String, IndexSegments> indicesSegments;
                    if (shardSegments.getShardRouting().relocatingNodeId() != null) {  
                        builder.humanReadableField(Fields.MEMORY_IN_BYTES, Fields.MEMORY, segment.getZeroMemory());  
                            toXContent(builder, segment.getSegmentSort());
        int totalShards,
        static final String CHILDREN = "children";  
                        }
        static final String ROUTING = "routing";
        static final String DELETED_DOCS = "deleted_docs";  
 * software distributed under the License is distributed on an
    private static void toXContent(XContentBuilder builder, Sort sort) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
                builder.endArray();  
        static final String SEARCH = "search";
        }  
 * GitHub history for details.
import java.util.Comparator;  
