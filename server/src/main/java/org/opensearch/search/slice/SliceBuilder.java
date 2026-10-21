    @Override
        return builder;
     */
    public boolean shardMatches(int shardOrdinal, int numShards) {
    private int max = -1;
import org.opensearch.core.xcontent.ToXContentObject;
            // Slices are distributed over shards
     */
        int numShards = context.getIndexSettings().getNumberOfShards();
 */
    /**
                numShards = group.size();
    public Query toFilter(ClusterService clusterService, ShardSearchRequest request, QueryShardContext context, Version minNodeVersion) {
                shardOrdinal = -1;
                    if (request.shardId().equals(it.shardId())) {
            throw new IllegalArgumentException("max must be greater than id");
import org.opensearch.core.common.Strings;
            IndexFieldData ifm = context.getForField(type);
            throw new IllegalArgumentException("cannot load numeric doc values on " + field);
 *
                }
                throw new IllegalArgumentException("cannot load numeric doc values on " + field);
        String[] indices = new String[] { request.shardId().getIndex().getName() };
 * license agreements. See the NOTICE file distributed with
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
import org.opensearch.index.mapper.MappedFieldType;
    }
            int rest = max % numShards;
                    }
            throw new IllegalArgumentException("field " + field + " not found");
import org.opensearch.cluster.routing.ShardIterator;
 *  {@link org.opensearch.search.slice.DocValuesSliceQuery} is used to filter the results.
 * this work for additional information regarding copyright
 *
        this(IdFieldMapper.NAME, id, max);
    }
import org.opensearch.common.util.set.Sets;
    static {
    /** The id of the slice */
 *  For instance if the number of shards is equal to 2 and the user requested 4 slices
                        shardOrdinal = ord;
@PublicApi(since = "1.0.0")
        } else {
 * software distributed under the License is distributed on an
    @Override
    public boolean equals(Object other) {
        if (max != -1 && id >= max) {
        out.writeVInt(max);
import org.opensearch.index.fielddata.IndexNumericFieldData;
            throw new IllegalArgumentException("max must be greater than 1");
            if (ifm instanceof IndexNumericFieldData == false) {
 * Modifications Copyright OpenSearch Contributors. See
        } else if (type.hasDocValues() == false) {
            return id % numShards == shardOrdinal;
        if ((request.preference() != null || request.indexRoutings().length > 0)) {
     * The id of the slice.
 */
        // full set of shards matched by the routing parameters.
                for (ShardIterator it : group) {
        final ClusterState state = clusterService.state();
        out.writeString(field);
import org.opensearch.core.common.io.stream.StreamInput;
        }
    /**
 *  (instead of {@code numShards*numSlices}).
public class SliceBuilder implements Writeable, ToXContentObject {
        if (!(other instanceof SliceBuilder o)) {
        this.field = field;
     * @param max The maximum number of slices
     *
        return builder;
        }
    private SliceBuilder setField(String field) {
            int targetShard = id % numShards;
 * Licensed to Elasticsearch under one or more contributor
    @Override
    /** Name of field to slice against (_uid by default) */
     */
/*
import org.opensearch.index.fielddata.IndexFieldData;
 *  Otherwise the provided field must be a numeric and doc_values must be enabled. In that case a
 * this file be licensed under the Apache-2.0 license or a
    /**
 * ownership. Elasticsearch licenses this file to you under
    private SliceBuilder() {}
        }
    }
import org.opensearch.index.mapper.IdFieldMapper;
        PARSER.declareInt(SliceBuilder::setMax, MAX_FIELD);
                numSlicesInShard++;
        return new MatchAllDocsQuery();
    public static final ParseField ID_FIELD = new ParseField("id");
    @Override
    private int id = -1;
            }
            ? Collections.singletonMap(indices[0], Sets.newHashSet(request.indexRoutings()))
package org.opensearch.search.slice;
        return clusterService.operationRouting().searchShards(state, indices, routingMap, request.preference());
 * KIND, either express or implied.  See the License for the
 *  This way the total number of bitsets that we need to build on each shard is bounded by the number of slices
        if (max <= 1) {
        SliceBuilder builder = PARSER.parse(parser, new SliceBuilder(), null);
    }
    private SliceBuilder setId(int id) {
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.ParseField;
 *  to do the slicing. The slicing is done at the shard level first and then each shard is split into multiple slices.
                int ord = 0;
            if (rest > targetShard) {
    @Override
     */
                    assert it.shardId().getIndex().equals(request.shardId().getIndex());
import java.util.Collections;
    public static final ParseField MAX_FIELD = new ParseField("max");
                 */
 * GitHub history for details.
                 * The routing of this request targets a subset of the shards of this index so we need to we retrieve
     */
        // Shards are distributed over slices
        if (numShards == 1) {
            throw new IllegalArgumentException("max must be greater than id");
     */
/**
    }
    public String getField() {
            // in such case we can reduce the number of requested shards by slice
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (id < 0) {
 * under the License.
                ? new TermsSliceQuery(field, shardSlice, numSlicesInShard)
            if (group.size() < numShards) {
    public SliceBuilder(StreamInput in) throws IOException {
                + group.size()
import org.opensearch.core.xcontent.ObjectParser;
    }
    }
            // the number of slices is greater than the number of shards
            return useTermQuery
     * The maximum number of slices.
            if (numSlicesInShard == 1) {
        if (shardMatches(shardOrdinal, numShards) == false) {
        return max;
import org.opensearch.Version;
            throw new IllegalArgumentException("id must be greater than or equal to 0");
        }
 *  then the slices 0 and 2 are assigned to the first shard and the slices 1 and 3 are assigned to the second shard.
    public static SliceBuilder fromXContent(XContentParser parser) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
     * Converts this QueryBuilder to a lucene {@link Query}.
    }
            return new MatchNoDocsQuery("this shard is not part of the slice");
    }
 * You may obtain a copy of the License at
            int numSlicesInShard = max / numShards;
            throw new IllegalArgumentException("Computing slices on the [_uid] field is illegal for 7.x indices, use [_id] instead");
            }
    private GroupShardsIterator<ShardIterator> buildShardIterator(ClusterService clusterService, ShardSearchRequest request) {
        int shardOrdinal = request.shardId().id();
    /**
        this.max = max;
 * specific language governing permissions and limitations
        return this;
        // Note that we do *not* want to filter this set of shard IDs based on the slice, since we want the
        setField(field);
        builder.startObject();
        builder.field(ID_FIELD.getPreferredName(), id);
                return new MatchAllDocsQuery();
        builder.field(MAX_FIELD.getPreferredName(), max);
        } else if (IdFieldMapper.NAME.equals(field)) {
     * @param context Additional information needed to build the query
import org.opensearch.core.xcontent.MediaTypeRegistry;
 */
    public SliceBuilder(String field, int id, int max) {
        }
        this.field = in.readString();
        this.max = in.readVInt();
    public static final ParseField FIELD_FIELD = new ParseField("field");
    public SliceBuilder(int id, int max) {
        }
    }
            // get the new slice id for this shard
import org.apache.lucene.search.MatchNoDocsQuery;
        }
}
 *
import java.util.Set;
    private SliceBuilder setMax(int max) {
                + numShards;
 *  A slice builder allowing to split a scroll in multiple partitions.
            return useTermQuery ? new TermsSliceQuery(field, id, max) : new DocValuesSliceQuery(field, id, max);
        out.writeVInt(id);
 *  If the provided field is the "_uid" it uses a {@link org.opensearch.search.slice.TermsSliceQuery}
        return this;
    void innerToXContent(XContentBuilder builder) throws IOException {
        setId(id);
    }
import org.apache.lucene.search.Query;
    /** Max number of slices */
            throw new IllegalArgumentException("field name is null or empty");
    }
/*
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.search.internal.ShardSearchRequest;
        }
 * Unless required by applicable law or agreed to in writing,
     * @param id The id of the slice
                    ++ord;
import org.opensearch.common.annotation.PublicApi;
        if ("_uid".equals(field)) {
     * The name of the field to slice against
                + " cannot be greater than total number of shards: "
import java.util.Map;
        if (max >= numShards) {
            }
import org.opensearch.core.common.io.stream.StreamOutput;
        return this;
import org.opensearch.cluster.routing.GroupShardsIterator;
        innerToXContent(builder);
            useTermQuery = true;
        return id;
        if (type == null) {
        final MappedFieldType type = context.fieldMapper(field);
 * SPDX-License-Identifier: Apache-2.0
        if (Strings.isEmpty(field)) {
/*
import org.opensearch.core.common.io.stream.Writeable;
            GroupShardsIterator<ShardIterator> group = buildShardIterator(clusterService, request);
    private String field = IdFieldMapper.NAME;
                 * the original {@link GroupShardsIterator} and compute the request shard id and number of
 * The OpenSearch Contributors require contributions made to
            return false;
            int shardSlice = id / numShards;
        this.id = in.readVInt();
        return ((field == null && o.field == null) || field.equals(o.field)) && id == o.id && o.max == max;
 */
     * Returns the {@link GroupShardsIterator} for the provided <code>request</code>.
    }
        return this.field;
            assert group.size() <= numShards : "index routing shards: "
    /**
        }
        builder.endObject();
        PARSER.declareInt(SliceBuilder::setId, ID_FIELD);
import org.opensearch.cluster.ClusterState;
        Map<String, Set<String>> routingMap = request.indexRoutings().length > 0
import org.apache.lucene.search.MatchAllDocsQuery;
    public int getMax() {
            // We should have already excluded this shard before routing to it.
        }
    }
                /*
import org.opensearch.cluster.service.ClusterService;
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            // If we somehow land here, then we match nothing.
        boolean useTermQuery = false;
            : null;
        return shardOrdinal % max == id;
            // compute the number of slices where this shard appears
    }
        setMax(max);
    }
                // this shard has only one slice so we must check all the documents
     *
                        break;
                : new DocValuesSliceQuery(field, shardSlice, numSlicesInShard);
import java.io.IOException;
import org.opensearch.index.query.QueryShardContext;
    }
    public int getId() {
        return Objects.hash(this.field, this.id, this.max);
        // the number of shards is greater than the number of slices. If we target this shard, we target all of it.
        PARSER.declareString(SliceBuilder::setField, FIELD_FIELD);
    private static final ObjectParser<SliceBuilder, Void> PARSER = new ObjectParser<>("slice", SliceBuilder::new);
import java.util.Objects;
    public String toString() {
        this.id = id;
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
    }
    /**
     * @param field The name of the field
        }
 * @opensearch.api
                // remap the original shard id with its index (position) in the sorted shard iterator.
    public int hashCode() {
        if (id != -1 && id >= max) {
                assert shardOrdinal != -1 : "shard id: " + request.shardId().getId() + " not found in index shard routing";
        }
            }
    }
                 * shards from it.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (max >= numShards) {
 *
        }
        builder.field(FIELD_FIELD.getPreferredName(), field);
