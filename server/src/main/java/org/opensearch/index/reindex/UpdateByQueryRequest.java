import org.opensearch.core.xcontent.ToXContentObject;
        UpdateByQueryRequest request = doForSlice(new UpdateByQueryRequest(slice, false), slicingTask, totalSlices);  
     * Set routing limiting the process to the shards that match that routing value
     * Set the ingest pipeline to set on index requests made by this action.
    }
 * the Apache License, Version 2.0 (the "License"); you may
     * Gets the routing value used for this request
 * specific language governing permissions and limitations
 *  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
    /**
        }
    @Override
 * GitHub history for details.
    }  
        return builder;
    private UpdateByQueryRequest(SearchRequest search, boolean setDefaults) {
 * Modifications Copyright OpenSearch Contributors. See
    public UpdateByQueryRequest setIndicesOptions(IndicesOptions indicesOptions) {  
 */
    /**
}  
    }
import org.opensearch.core.common.io.stream.StreamOutput;
 * ownership. Elasticsearch licenses this file to you under  
        ToXContentObject {  
 *  
    public UpdateByQueryRequest setQuery(QueryBuilder query) {
        assert getSearchRequest() != null;  
 * SPDX-License-Identifier: Apache-2.0
        return this;  
        request.setPipeline(pipeline);
/*  
        return this;  
        IndicesRequest.Replaceable,
        assert getSearchRequest() != null;
 * under the License.  
        this(search, true);  
        getSearchRequest().source().innerToXContent(builder, params);
        }  
        super(search, setDefaults);  
        return this;
        assert getSearchRequest() != null;  
 * CompositeIndicesRequest but in a misleading way. Rather than returning all the subrequests that it will make it tries to return a  
 * Request to update some documents. That means you can't change their type, id, index, or anything like that. This implements
        return this;
    public String toString() {  
    /**  
    UpdateByQueryRequest(SearchRequest search) {
        super.writeTo(out);  
 * license agreements. See the NOTICE file distributed with
            getScript().toXContent(builder, params);  
    public UpdateByQueryRequest() {  
    }  
import java.io.IOException;
    }
     * Set the IndicesOptions for controlling unavailable indices
        pipeline = in.readOptionalString();
        this(new SearchRequest());
        getSearchRequest().indicesOptions(indicesOptions);
        return getSearchRequest().source().size();  
        if (query != null) {  
    public IndicesRequest indices(String... indices) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class UpdateByQueryRequest extends AbstractBulkIndexByScrollRequest<UpdateByQueryRequest>  
import org.opensearch.action.search.SearchRequest;
 */  
 */  
    @Override
    public UpdateByQueryRequest(StreamInput in) throws IOException {  
    }
    public String getPipeline() {
        }
    }
        return request;
 *
 * Unless required by applicable law or agreed to in writing,
        getSearchRequest().indices(indices);  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * Set the query for selective update  
    }
        out.writeOptionalString(pipeline);
package org.opensearch.index.reindex;
        b.append("update-by-query ");
import org.opensearch.index.query.QueryBuilder;  
    }
        return getSearchRequest().indices();
    @Override
 *
     */
        super(in);
     */
    @Override
        if (routing != null) {
    @Override  
import org.opensearch.core.xcontent.XContentBuilder;
    /**
    }  
            getSearchRequest().source().query(query);
    public IndicesOptions indicesOptions() {
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
        return this;
 * destination index and things.
    public UpdateByQueryRequest setPipeline(String pipeline) {  
    implements
     */
 * You may obtain a copy of the License at  
        return pipeline;
import org.opensearch.action.IndicesRequest;
    private String pipeline;
    }
        return getSearchRequest().routing();
        getSearchRequest().source().size(size);
    }
/*  
            builder.field("script");
        searchToString(b);  
    public String getRouting() {  
    public UpdateByQueryRequest setBatchSize(int size) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
import org.opensearch.core.common.io.stream.StreamInput;
    public UpdateByQueryRequest(String... indices) {
    }
 */
 * KIND, either express or implied.  See the License for the
 * representative set of subrequests. This is best-effort but better than {@linkplain ReindexRequest} because scripts can't change the
     * Gets the batch size for this request  
     * Ingest pipeline to set on index requests made by this action.
     */
 * this file be licensed under the Apache-2.0 license or a
     * The scroll size to control number of documents processed per batch
    public int getBatchSize() {
    public UpdateByQueryRequest setRouting(String routing) {  
        return this;
     */  
    public String[] indices() {
        builder.endObject();  
        StringBuilder b = new StringBuilder();
        return b.toString();
        this.pipeline = pipeline;
    @Override
     */  
    }
    @Override
     */
    /**
 * compatible open source license.
import org.opensearch.action.support.IndicesOptions;  
    }
    protected UpdateByQueryRequest self() {  
    /**  
    @Override
            getSearchRequest().routing(routing);
        return getSearchRequest().indicesOptions();
     */
    }  
    /**  
    }
        return this;
    /**  
    public UpdateByQueryRequest forSlice(TaskId slicingTask, SearchRequest slice, int totalSlices) {
    }  
/*
    // indices are resolved depend entirely on the inner search request. That's why the following methods delegate to it.
    }
    }  
        if (getScript() != null) {
        this(new SearchRequest(indices));
     */  
 * @opensearch.internal
/**
 * this work for additional information regarding copyright
    public void writeTo(StreamOutput out) throws IOException {
        builder.startObject();  
import org.opensearch.core.tasks.TaskId;  
    }
     * Ingest pipeline to set on index requests made by this action.
    // update by query updates all documents that match a query. The indices and indices options that affect how
