            return id % numShards == shardOrdinal;
        out.writeString(field);  
            throw new IllegalArgumentException("id must be greater than or equal to 0");
            int targetShard = id % numShards;  
     * Converts this QueryBuilder to a lucene {@link Query}.
        }
                int ord = 0;  
     */
     * @param context Additional information needed to build the query
 */  
 *
        return builder;  
import org.opensearch.core.common.Strings;  
        out.writeVInt(id);
                    }
 * Unless required by applicable law or agreed to in writing,
            if (rest > targetShard) {
import org.opensearch.cluster.routing.GroupShardsIterator;  
     * @param id The id of the slice
    }
import org.apache.lucene.search.MatchNoDocsQuery;
    }
    /**
        return this;
        return max;
            // compute the number of slices where this shard appears
        }
    public Query toFilter(ClusterService clusterService, ShardSearchRequest request, QueryShardContext context, Version minNodeVersion) {  
    void innerToXContent(XContentBuilder builder) throws IOException {
        }  
import org.opensearch.index.mapper.MappedFieldType;  
 *  This way the total number of bitsets that we need to build on each shard is bounded by the number of slices
                 * the original {@link GroupShardsIterator} and compute the request shard id and number of
        out.writeVInt(max);
            IndexFieldData ifm = context.getForField(type);
    @Override  
        boolean useTermQuery = false;  
/*
        return this;
    public SliceBuilder(String field, int id, int max) {
package org.opensearch.search.slice;
    }  
    }
        if (max != -1 && id >= max) {  
     * Returns the {@link GroupShardsIterator} for the provided <code>request</code>.
 *
        setId(id);  
                : new DocValuesSliceQuery(field, shardSlice, numSlicesInShard);
 */  
     *  
        return ((field == null && o.field == null) || field.equals(o.field)) && id == o.id && o.max == max;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    public SliceBuilder(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
            // Slices are distributed over shards  
    }
    /**  
        this.field = in.readString();
        Map<String, Set<String>> routingMap = request.indexRoutings().length > 0  
    /**
 *  A slice builder allowing to split a scroll in multiple partitions.
 *  (instead of {@code numShards*numSlices}).
            // the number of slices is greater than the number of shards  
            throw new IllegalArgumentException("field name is null or empty");
        if (id != -1 && id >= max) {  
                 */
 * GitHub history for details.
        } else if (IdFieldMapper.NAME.equals(field)) {  
        if (Strings.isEmpty(field)) {  
 * not use this file except in compliance with the License.
import java.io.IOException;
import org.opensearch.core.xcontent.XContentParser;
 * SPDX-License-Identifier: Apache-2.0
                + " cannot be greater than total number of shards: "  
            useTermQuery = true;
        return builder;
                        break;
        if (type == null) {
import org.opensearch.index.query.QueryShardContext;
    }  
        builder.startObject();
        return clusterService.operationRouting().searchShards(state, indices, routingMap, request.preference());
        SliceBuilder builder = PARSER.parse(parser, new SliceBuilder(), null);
            ? Collections.singletonMap(indices[0], Sets.newHashSet(request.indexRoutings()))
    @Override
        PARSER.declareString(SliceBuilder::setField, FIELD_FIELD);
    /** Max number of slices */
                numShards = group.size();
        }
 * the Apache License, Version 2.0 (the "License"); you may
                + numShards;
    }  
    @Override
        setMax(max);
            return new MatchNoDocsQuery("this shard is not part of the slice");  
 */
import org.opensearch.core.xcontent.MediaTypeRegistry;
            throw new IllegalArgumentException("max must be greater than id");
     * The name of the field to slice against
        builder.field(MAX_FIELD.getPreferredName(), max);
import java.util.Collections;
 *  Otherwise the provided field must be a numeric and doc_values must be enabled. In that case a  
            int shardSlice = id / numShards;
            GroupShardsIterator<ShardIterator> group = buildShardIterator(clusterService, request);  
import org.opensearch.index.fielddata.IndexNumericFieldData;
            return useTermQuery  
                    ++ord;  
                return new MatchAllDocsQuery();
    private static final ObjectParser<SliceBuilder, Void> PARSER = new ObjectParser<>("slice", SliceBuilder::new);
        if (id < 0) {  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamOutput;
        if (max >= numShards) {
            // get the new slice id for this shard  
        innerToXContent(builder);
 * this work for additional information regarding copyright
            }  
import java.util.Objects;
 * specific language governing permissions and limitations
            }
    private int max = -1;
public class SliceBuilder implements Writeable, ToXContentObject {  
    private int id = -1;  
    private SliceBuilder() {}
        if (!(other instanceof SliceBuilder o)) {
import org.opensearch.search.internal.ShardSearchRequest;
        if (max <= 1) {  
        if (max >= numShards) {
                ? new TermsSliceQuery(field, shardSlice, numSlicesInShard)
    /** The id of the slice */
/*  
            int rest = max % numShards;  
        }
        // full set of shards matched by the routing parameters.
     */  
            }
import java.util.Set;
            return useTermQuery ? new TermsSliceQuery(field, id, max) : new DocValuesSliceQuery(field, id, max);  
     *
        }  
            throw new IllegalArgumentException("max must be greater than 1");
@PublicApi(since = "1.0.0")
            // in such case we can reduce the number of requested shards by slice
                    if (request.shardId().equals(it.shardId())) {
    /**
    public void writeTo(StreamOutput out) throws IOException {
    public boolean equals(Object other) {
import org.opensearch.common.util.set.Sets;
        return id;
 * Licensed to Elasticsearch under one or more contributor  
    public String getField() {
        PARSER.declareInt(SliceBuilder::setMax, MAX_FIELD);  
        // Shards are distributed over slices  
    private SliceBuilder setField(String field) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    public String toString() {  
                shardOrdinal = -1;
        builder.endObject();  
                /*  
            throw new IllegalArgumentException("field " + field + " not found");  
    }  
            // We should have already excluded this shard before routing to it.
        } else if (type.hasDocValues() == false) {
                for (ShardIterator it : group) {  
                assert shardOrdinal != -1 : "shard id: " + request.shardId().getId() + " not found in index shard routing";
import org.opensearch.index.mapper.IdFieldMapper;
    public static final ParseField FIELD_FIELD = new ParseField("field");
import org.opensearch.core.common.io.stream.Writeable;  
        this.id = in.readVInt();  
    }
    }
    }
            return false;  
        // Note that we do *not* want to filter this set of shard IDs based on the slice, since we want the  
 * compatible open source license.
    }  
        if (numShards == 1) {
 * under the License.  
        setField(field);
                // remap the original shard id with its index (position) in the sorted shard iterator.
    public int hashCode() {  
 * license agreements. See the NOTICE file distributed with
     * The maximum number of slices.
    /**
     * @param max The maximum number of slices
    }
                numSlicesInShard++;
 *
        this.field = field;  
            assert group.size() <= numShards : "index routing shards: "
import org.opensearch.cluster.ClusterState;
import org.opensearch.core.xcontent.XContentBuilder;
 *  For instance if the number of shards is equal to 2 and the user requested 4 slices
            throw new IllegalArgumentException("max must be greater than id");
    private SliceBuilder setId(int id) {
        final ClusterState state = clusterService.state();
            int numSlicesInShard = max / numShards;
import java.util.Map;  
    static {  
import org.opensearch.core.ParseField;
import org.opensearch.Version;
    private String field = IdFieldMapper.NAME;
    }
    }
            throw new IllegalArgumentException("cannot load numeric doc values on " + field);  
                // this shard has only one slice so we must check all the documents  
    @Override
            if (group.size() < numShards) {
        if (shardMatches(shardOrdinal, numShards) == false) {  
        return Objects.hash(this.field, this.id, this.max);
        }
     */
 * The OpenSearch Contributors require contributions made to  
                }
                 * shards from it.  
    }
     */  
 * software distributed under the License is distributed on an
    /**
        return this.field;
                    assert it.shardId().getIndex().equals(request.shardId().getIndex());
    public static SliceBuilder fromXContent(XContentParser parser) throws IOException {
        this(IdFieldMapper.NAME, id, max);
        }
 * You may obtain a copy of the License at  
        // the number of shards is greater than the number of slices. If we target this shard, we target all of it.
        builder.field(FIELD_FIELD.getPreferredName(), field);
import org.apache.lucene.search.MatchAllDocsQuery;
import org.opensearch.core.xcontent.ObjectParser;
            if (numSlicesInShard == 1) {
                        shardOrdinal = ord;  
    public boolean shardMatches(int shardOrdinal, int numShards) {
import org.apache.lucene.search.Query;  
        }
            // If we somehow land here, then we match nothing.
     * The id of the slice.
    private GroupShardsIterator<ShardIterator> buildShardIterator(ClusterService clusterService, ShardSearchRequest request) {  
            }  
        } else {
 *  If the provided field is the "_uid" it uses a {@link org.opensearch.search.slice.TermsSliceQuery}  
/**
        final MappedFieldType type = context.fieldMapper(field);
    @Override
                 * The routing of this request targets a subset of the shards of this index so we need to we retrieve
        }
        return shardOrdinal % max == id;
}  
     * @param field The name of the field  
        return this;
        PARSER.declareInt(SliceBuilder::setId, ID_FIELD);
        String[] indices = new String[] { request.shardId().getIndex().getName() };
        if ((request.preference() != null || request.indexRoutings().length > 0)) {
        }
 *  then the slices 0 and 2 are assigned to the first shard and the slices 1 and 3 are assigned to the second shard.  
    /** Name of field to slice against (_uid by default) */  
    public static final ParseField MAX_FIELD = new ParseField("max");  
     */  
import org.opensearch.common.annotation.PublicApi;  
        this.max = max;  
            throw new IllegalArgumentException("Computing slices on the [_uid] field is illegal for 7.x indices, use [_id] instead");
 *  
    public static final ParseField ID_FIELD = new ParseField("id");
 */
                + group.size()
    }  
        return new MatchAllDocsQuery();  
        builder.field(ID_FIELD.getPreferredName(), id);  
import org.opensearch.index.fielddata.IndexFieldData;  
/*  
 * this file be licensed under the Apache-2.0 license or a
        }
    }
        this.id = id;  
            : null;
import org.opensearch.core.xcontent.ToXContentObject;  
        int shardOrdinal = request.shardId().id();  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public int getId() {
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.routing.ShardIterator;
    public int getMax() {
                throw new IllegalArgumentException("cannot load numeric doc values on " + field);
 * Modifications Copyright OpenSearch Contributors. See
        this.max = in.readVInt();
        int numShards = context.getIndexSettings().getNumberOfShards();
import org.opensearch.cluster.service.ClusterService;
     */  
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
 * @opensearch.api  
 *  {@link org.opensearch.search.slice.DocValuesSliceQuery} is used to filter the results.
            if (ifm instanceof IndexNumericFieldData == false) {  
    }
        }
    public SliceBuilder(int id, int max) {  
        if ("_uid".equals(field)) {
    private SliceBuilder setMax(int max) {
 *  to do the slicing. The slicing is done at the shard level first and then each shard is split into multiple slices.
