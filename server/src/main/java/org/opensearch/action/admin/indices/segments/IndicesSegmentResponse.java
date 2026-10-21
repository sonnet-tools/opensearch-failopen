 * KIND, either express or implied.  See the License for the
        }
     *
 */
                        }
 */
            if (!shards[i].getShardRouting().getIndexName().equals(startIndexName)) {
    IndicesSegmentResponse(
        static final String RELOCATING_NODE = "relocating_node";
package org.opensearch.action.admin.indices.segments;
                        builder.field(Fields.RELOCATING_NODE, shardSegments.getShardRouting().relocatingNodeId());
        static final String COMMITTED = "committed";
        static final String INDICES = "indices";
        builder.endObject();
                        }
    IndicesSegmentResponse(StreamInput in) throws IOException {
            }
import org.opensearch.core.common.io.stream.StreamInput;
        static final String SIZE = "size";
                    builder.startObject();
    private final ShardSegments[] shards;
                        builder.field(Fields.COMMITTED, segment.isCommitted());
                    builder.field(Fields.PRIMARY, shardSegments.getShardRouting().primary());
 *
                }
            builder.startObject(Fields.SHARDS);
        List<DefaultShardOperationFailedException> shardFailures
                        if (segment.getSegmentSort() != null) {
        shards = in.readArray(ShardSegments::new, ShardSegments[]::new);
                        builder.field(Fields.NUM_DOCS, segment.getNumDocs());
        return indicesSegments;
                            toXContent(builder, segment.getSegmentSort());
                    builder.startObject(Fields.ROUTING);
        static final String STATE = "state";
                builder.field("mode", ((SortedSetSortField) field).getSelector().toString().toLowerCase(Locale.ROOT));
            }
/**
                            builder.field(Fields.COMPOUND, segment.isCompound());
        static final String CHILDREN = "children";
    ) {
        static final String GENERATION = "generation";
     */
                        if (segment.isCompound() != null) {
    private Map<String, IndexSegments> indicesSegments;
import java.io.IOException;
        }
        builder.startObject(Fields.INDICES);
            } else if (field instanceof SortedSetSortField) {
        this.shards = shards;
    @Override
            return indicesSegments;
        static final String SHARDS = "shards";
 * this file be licensed under the Apache-2.0 license or a
                startIndexPos = i;
 * @opensearch.api
import java.util.Locale;
        static final String SEGMENTS = "segments";
            }
        static final String PRIMARY = "primary";
                    builder.endObject();
        int startIndexPos = 0;
        static final String VERSION = "version";
 * The OpenSearch Contributors require contributions made to
                        builder.field(Fields.SEARCH, segment.isSearch());
                        builder.humanReadableField(Fields.MEMORY_IN_BYTES, Fields.MEMORY, segment.getZeroMemory());
            builder.endObject();
                for (ShardSegments shardSegments : indexSegment) {
 * ownership. Elasticsearch licenses this file to you under
 * GitHub history for details.
        for (IndexSegments indexSegments : getIndices().values()) {
            builder.field("reverse", field.getReverse());
 * Modifications Copyright OpenSearch Contributors. See
                        }
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
import org.apache.lucene.search.Sort;
    static final class Fields {
@PublicApi(since = "1.0.0")
    private static void toXContent(XContentBuilder builder, Sort sort) throws IOException {
    }
        static final String NUM_COMMITTED_SEGMENTS = "num_committed_segments";
        this.indicesSegments = indicesSegments;
                        builder.startObject(segment.getName());
        // Add the last shardSegment from shards list which would have got missed in the loop above
        static final String MEMORY = "memory";
 * not use this file except in compliance with the License.
 */
 *
    /**
                        if (segment.attributes != null && segment.attributes.isEmpty() == false) {
        static final String MEMORY_IN_BYTES = "memory_in_bytes";
                            builder.field(Fields.MERGE_ID, segment.getMergeId());
                            builder.field(Fields.VERSION, segment.getVersion());
                    if (shardSegments.getShardRouting().relocatingNodeId() != null) {
        super.writeTo(out);
        static final String RAM_TREE = "ram_tree";
                startIndexName = shards[startIndexPos].getShardRouting().getIndexName();
    public void writeTo(StreamOutput out) throws IOException {
import java.util.List;
import org.opensearch.core.common.io.stream.StreamOutput;
import org.apache.lucene.search.SortedNumericSortField;
        String startIndexName = shards[startIndexPos].getShardRouting().getIndexName();
        static final String DELETED_DOCS = "deleted_docs";
                    builder.field(Fields.STATE, shardSegments.getShardRouting().state());
                        }
                    builder.endObject();
     * Fields for parsing and toXContent
    }
        super(totalShards, successfulShards, failedShards, shardFailures);
            builder.endObject();
                        builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, segment.getSize());
    @Override
                        }
 *
        builder.endArray();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    }
        int totalShards,
        static final String SIZE_IN_BYTES = "size_in_bytes";
        for (SortField field : sort.getSort()) {
 *
        }
        Map<String, IndexSegments> indicesSegments = new HashMap<>();
                indicesSegments.put(startIndexName, new IndexSegments(startIndexName, Arrays.copyOfRange(shards, startIndexPos, i)));
        builder.startArray("sort");
 * under the License.
import org.opensearch.index.engine.Segment;
        super(in);
     * @opensearch.internal
        out.writeArray(shards);
    }
            return indicesSegments;
        static final String SEARCH = "search";
        if (shards.length == 0) {
        static final String MERGE_ID = "merge_id";
import java.util.Arrays;
 * SPDX-License-Identifier: Apache-2.0
                    builder.startObject(Fields.SEGMENTS);
 * Licensed to Elasticsearch under one or more contributor
        static final String NUM_SEARCH_SEGMENTS = "num_search_segments";
                        if (segment.getVersion() != null) {
            }
        Arrays.sort(shards, Comparator.comparing(shardSegment -> shardSegment.getShardRouting().getIndexName()));
        }
        static final String NUM_DOCS = "num_docs";
            for (IndexShardSegments indexSegment : indexSegments) {
                        builder.endObject();
        ShardSegments[] shards,
import org.opensearch.common.annotation.PublicApi;
                    for (Segment segment : shardSegments) {
/*
                        builder.field(Fields.DELETED_DOCS, segment.getDeletedDocs());
/*
 * specific language governing permissions and limitations
            builder.field("field", field.getField());
            this.indicesSegments = indicesSegments;
import java.util.Map;
        static final String NODE = "node";
        if (indicesSegments != null) {
                    builder.field(Fields.NUM_SEARCH_SEGMENTS, shardSegments.getNumberOfSearch());
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        static final String COMPOUND = "compound";
    }
import java.util.Comparator;
    }
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.SortField;
                    builder.field(Fields.NUM_COMMITTED_SEGMENTS, shardSegments.getNumberOfCommitted());
import org.opensearch.core.xcontent.XContentBuilder;
            if (field.getMissingValue() != null) {
                builder.field("mode", ((SortedNumericSortField) field).getSelector().toString().toLowerCase(Locale.ROOT));
                builder.endArray();
    public Map<String, IndexSegments> getIndices() {
                builder.startArray(Integer.toString(indexSegment.getShardId().id()));
 * You may obtain a copy of the License at
                            builder.field("attributes", segment.attributes);
import java.util.HashMap;
                    }
            builder.startObject();
import org.apache.lucene.search.SortedSetSortField;
        static final String ROUTING = "routing";
 * software distributed under the License is distributed on an
 */
            if (field instanceof SortedNumericSortField) {
        int failedShards,
 * Transport response for retrieving indices segment information
            builder.endObject();
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.support.broadcast.BroadcastResponse;
    protected void addCustomXContentFields(XContentBuilder builder, Params params) throws IOException {
}
                builder.field("missing", field.getMissingValue().toString());
                        builder.field(Fields.GENERATION, segment.getGeneration());
 * the Apache License, Version 2.0 (the "License"); you may
        indicesSegments.put(startIndexName, new IndexSegments(startIndexName, Arrays.copyOfRange(shards, startIndexPos, shards.length)));
    }
                    builder.endObject();
        int successfulShards,
                        if (segment.getMergeId() != null) {
public class IndicesSegmentResponse extends BroadcastResponse {
/*
        }
        for (int i = 0; i < shards.length; i++) {
        static final String DESCRIPTION = "description";
                    builder.field(Fields.NODE, shardSegments.getShardRouting().currentNodeId());
 * this work for additional information regarding copyright
            builder.startObject(indexSegments.getIndex());
