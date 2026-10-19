        ShardSearchRequest shardSearchRequest,
public class ShardFetchSearchRequest extends ShardFetchRequest implements IndicesRequest {  
 * this work for additional information regarding copyright
import org.opensearch.action.support.IndicesOptions;
        originalIndices = OriginalIndices.readOriginalIndices(in);
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        ShardSearchContextId id,  
    }
        List<Integer> list,
 * @opensearch.internal
        this.aggregatedDfs = aggregatedDfs;
package org.opensearch.search.fetch;
        out.writeOptionalWriteable(aggregatedDfs);
        shardSearchRequest = in.readOptionalWriteable(ShardSearchRequest::new);
        return aggregatedDfs;
 * and implements {@link org.opensearch.action.IndicesRequest}.
 * the Apache License, Version 2.0 (the "License"); you may
}
    ) {  
 * Unless required by applicable law or agreed to in writing,
        return rescoreDocIds;  
 * Licensed to Elasticsearch under one or more contributor  
    public ShardSearchRequest getShardSearchRequest() {  
    @Override  
        if (originalIndices == null) {  
import org.opensearch.search.internal.ShardSearchContextId;  
    @Override  
 *  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
import org.opensearch.search.RescoreDocIds;
import org.opensearch.action.IndicesRequest;
 * Shard level fetch request used with search. Holds indices taken from the original search request
        return originalIndices.indices();  
    private final OriginalIndices originalIndices;
import java.util.List;
import org.opensearch.core.common.io.stream.StreamOutput;  
    public IndicesOptions indicesOptions() {
 *
        return shardSearchRequest;
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
        super(id, list, lastEmittedDoc);
 * Modifications Copyright OpenSearch Contributors. See
        this.originalIndices = originalIndices;
    private final AggregatedDfs aggregatedDfs;
        aggregatedDfs = in.readOptionalWriteable(AggregatedDfs::new);
        this.rescoreDocIds = rescoreDocIds;
        }
 * under the License.  
        if (originalIndices == null) {
        RescoreDocIds rescoreDocIds,
        }
    public ShardFetchSearchRequest(
        ScoreDoc lastEmittedDoc,  
    public RescoreDocIds getRescoreDocIds() {
    @Override
/*  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
    }
        super.writeTo(out);  
        super(in);  
 */
/*  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        rescoreDocIds.writeTo(out);  
        rescoreDocIds = new RescoreDocIds(in);  
    public void writeTo(StreamOutput out) throws IOException {
        OriginalIndices originalIndices,
import java.io.IOException;  
import org.apache.lucene.search.ScoreDoc;
    private final RescoreDocIds rescoreDocIds;
 * specific language governing permissions and limitations
import org.opensearch.search.dfs.AggregatedDfs;
 *
    public AggregatedDfs getAggregatedDfs() {
 * KIND, either express or implied.  See the License for the
    public ShardFetchSearchRequest(StreamInput in) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 *  
        this.shardSearchRequest = shardSearchRequest;  
    }  
 * software distributed under the License is distributed on an
 */
/**  
        OriginalIndices.writeOriginalIndices(originalIndices, out);
    public String[] indices() {
    }
        out.writeOptionalWriteable(shardSearchRequest);
    }  
    @Override
/*
        AggregatedDfs aggregatedDfs
    private final ShardSearchRequest shardSearchRequest;  
import org.opensearch.action.OriginalIndices;  
import org.opensearch.search.internal.ShardSearchRequest;
    }  
        return originalIndices.indicesOptions();
            return null;  
            return null;
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
    }
    @Override
