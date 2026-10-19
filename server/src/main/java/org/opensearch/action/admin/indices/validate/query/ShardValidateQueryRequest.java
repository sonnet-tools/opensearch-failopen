        filteringAliases = new AliasFilter(in);  
    public QueryBuilder query() {  
    }
 * the Apache License, Version 2.0 (the "License"); you may
    }
import java.io.IOException;  
    private AliasFilter filteringAliases;
import org.opensearch.core.index.shard.ShardId;
        this.rewrite = request.rewrite();
import org.opensearch.action.support.broadcast.BroadcastShardRequest;
        filteringAliases.writeTo(out);  
    @Override
 */  
    public ShardValidateQueryRequest(ShardId shardId, AliasFilter filteringAliases, ValidateQueryRequest request) {  
import java.util.Objects;
    public boolean explain() {
 */
 * under the License.  
import org.opensearch.search.internal.AliasFilter;
        out.writeBoolean(explain);
        this.explain = request.explain();  
                    in.readString();
        this.nowInMillis = request.nowInMillis;  
        if (out.getVersion().before(Version.V_2_0_0)) {  
 * compatible open source license.
/*  
            }
        if (in.getVersion().before(Version.V_2_0_0)) {
        this.query = request.query();
import org.opensearch.Version;
    }
    public long nowInMillis() {
 * Unless required by applicable law or agreed to in writing,
        return this.explain;
        }
        rewrite = in.readBoolean();
 * Internal validate request executed directly against a specific index shard.
 * not use this file except in compliance with the License.
    public boolean rewrite() {
    private boolean explain;
    public void writeTo(StreamOutput out) throws IOException {  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
/*
 * You may obtain a copy of the License at  
 *  
            out.writeVInt(0); // no types to filter
    }  
import org.opensearch.index.query.QueryBuilder;  
        explain = in.readBoolean();
        return this.rewrite;  
 * ownership. Elasticsearch licenses this file to you under  
    private long nowInMillis;
        out.writeNamedWriteable(query);
 * specific language governing permissions and limitations
        return query;
 */  
        super(shardId, request);
 *
 * this file be licensed under the Apache-2.0 license or a
/*  
    }
                }  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
        out.writeVLong(nowInMillis);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    private QueryBuilder query;
            if (typesSize > 0) {  
        super.writeTo(out);
            int typesSize = in.readVInt();
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamInput;  
        nowInMillis = in.readVLong();  
 * software distributed under the License is distributed on an
    public AliasFilter filteringAliases() {  
        return filteringAliases;
    public ShardValidateQueryRequest(StreamInput in) throws IOException {
package org.opensearch.action.admin.indices.validate.query;
 * license agreements. See the NOTICE file distributed with
}
public class ShardValidateQueryRequest extends BroadcastShardRequest {
/**  
                for (int i = 0; i < typesSize; i++) {
    }
        out.writeBoolean(rewrite);
 * @opensearch.internal  
        query = in.readNamedWriteable(QueryBuilder.class);  
    private boolean rewrite;  
        super(in);
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
 *
import org.opensearch.core.common.io.stream.StreamOutput;
 *
 */
 * The OpenSearch Contributors require contributions made to  
        this.filteringAliases = Objects.requireNonNull(filteringAliases, "filteringAliases must not be null");
        return this.nowInMillis;
