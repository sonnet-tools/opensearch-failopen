        out.writeOptionalWriteable(pageParams);  
            out.writeVInt(shard);
        }  
 */  
    public GetIngestionStateRequest(StreamInput in) throws IOException {
    public int[] getShards() {
import static org.opensearch.action.ValidateActions.addValidationError;
     */
        super();
        if (indices == null) {  
public class GetIngestionStateRequest extends BroadcastRequest<GetIngestionStateRequest> {
import java.util.ArrayList;
package org.opensearch.action.admin.indices.streamingingestion.state;
            this.indexName = in.readString();
            this.shard = in.readVInt();  
 * Request to get current ingestion state when using pull-based ingestion. This request supports retrieving index and
    public PageParams getPageParams() {  
        return validationException;
        for (IndexShardPair indexShardPair : indexShardPairsList) {
import org.opensearch.action.pagination.PageParams;
    public void setShards(int[] shards) {
 */  
    public void writeTo(StreamOutput out) throws IOException {  
import java.util.Arrays;
        } else if (indices.length != Arrays.stream(indices).collect(Collectors.toSet()).size()) {
    public static final int DEFAULT_PAGE_SIZE = 1000;  
    }  
import org.opensearch.core.common.io.stream.StreamOutput;  
            validationException = addValidationError("index is missing", validationException);
            this.shard = shard;
        out.writeList(indexShardPairsList);
 *
    public Map<String, Set<Integer>> getIndexShardPairsAsMap() {  
    }
        this.shards = in.readVIntArray();
    public void setPageParams(PageParams pageParams) {
import org.opensearch.action.support.broadcast.BroadcastRequest;  
    @Override
    private PageParams pageParams;
    public ActionRequestValidationException validate() {
    }
        return shards;
 * SPDX-License-Identifier: Apache-2.0
        this.pageParams = in.readOptionalWriteable(PageParams::new);
    }
        public IndexShardPair(String indexName, int shard) {  
    /**  
@PublicApi(since = "3.6.0")
    }
    public void addIndexShardPair(String indexName, int shard) {
     * Returns a map of index name and respective shards to be considered.
        public void writeTo(StreamOutput out) throws IOException {  
            validationException = addValidationError("duplicate index names provided", validationException);  
        return pageParams;
            indexShardMap.computeIfAbsent(indexShardPair.indexName, indexName -> new HashSet<>()).add(indexShardPair.shard);  
        String indexName;
            out.writeString(indexName);
    // holds the <index,shard> pairs to consider when using pagination  
    @Override  
        super.writeTo(out);
    }  
        out.writeVIntArray(shards);
 *
import java.util.Set;
    }
        }
    private int[] shards;  
    public GetIngestionStateRequest(String[] indices) {  
        public IndexShardPair(StreamInput in) throws IOException {
 * shard level state. By default, all shards of an index are included.  
 * The OpenSearch Contributors require contributions made to  
        this.shards = shards;  
        return indexShardMap;  
    }
}
            this.indexName = indexName;
        this.shards = new int[] {};  
import java.util.HashMap;  
        this.indexShardPairsList = in.readList(IndexShardPair::new);  
import java.util.Map;  
import static org.opensearch.action.pagination.PageParams.PARAM_ASC_SORT_VALUE;
        this.indices = indices;
        indexShardPairsList.add(new IndexShardPair(indexName, shard));  
import org.opensearch.common.annotation.PublicApi;
import java.util.HashSet;
        @Override
    }  
import java.util.List;
        this.pageParams = new PageParams(null, DEFAULT_SORT_VALUE, DEFAULT_PAGE_SIZE);
import java.util.stream.Collectors;
import org.opensearch.action.ActionRequestValidationException;
        int shard;
 * this file be licensed under the Apache-2.0 license or a
        }
        ActionRequestValidationException validationException = null;
        Map<String, Set<Integer>> indexShardMap = new HashMap<>();
import org.opensearch.core.common.io.stream.Writeable;
    }  
    private List<IndexShardPair> indexShardPairsList;
        super(in);  
        }
import java.io.IOException;  
        this.pageParams = pageParams;
 * @opensearch.api
 * compatible open source license.
    private class IndexShardPair implements Writeable {  
    public static final String DEFAULT_SORT_VALUE = PARAM_ASC_SORT_VALUE;
        }  
    }
/**
import org.opensearch.core.common.io.stream.StreamInput;
        this.indexShardPairsList = new ArrayList<>();
/*  
