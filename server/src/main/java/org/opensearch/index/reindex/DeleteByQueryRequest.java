/*  
    /**
        // Delete-By-Query does not require the source  
public class DeleteByQueryRequest extends AbstractBulkByScrollRequest<DeleteByQueryRequest>
 */  
    public int getBatchSize() {  
        if (getSearchRequest().indices() == null || getSearchRequest().indices().length == 0) {
 * compatible open source license.
    protected DeleteByQueryRequest self() {  
        super(search, setDefaults);
    /**
 *     stored in the transaction logs that might not be supported in the future.</li>
 *
    // delete by query deletes all documents that match a query. The indices and indices options that affect how
 *     deleted</li>
 * under the License.  
    }
        searchToString(b);  
        getSearchRequest().source().innerToXContent(builder, params);
    @Override  
     * Set routing limiting the process to the shards that match that routing value
     */  
     */
        }
    }
        b.append("delete-by-query ");
        StringBuilder b = new StringBuilder();
        return this;  
    implements
 *     <li>it's {@code syntactic sugar}, a delete-by-query is equivalent to a scroll search and corresponding bulk-deletes by ID</li>
    }  
    /**
 *
import org.opensearch.index.query.QueryBuilder;  
 * license agreements. See the NOTICE file distributed with
    }
    }
 * not use this file except in compliance with the License.
import org.opensearch.core.tasks.TaskId;  
    public String getRouting() {
    }
    @Override
    public DeleteByQueryRequest forSlice(TaskId slicingTask, SearchRequest slice, int totalSlices) {
            getSearchRequest().routing(routing);  
     * Gets the routing value used for this request
    @Override
import java.io.IOException;
    }  
        getSearchRequest().indicesOptions(indicesOptions);
    public DeleteByQueryRequest setQuery(QueryBuilder query) {  
     */
        } else if (getSearchRequest().source().query() == null) {  
    public DeleteByQueryRequest setRouting(String routing) {
     * Set the query for selective delete
    /**  
            search.source().fetchSource(false);
    public ActionRequestValidationException validate() {
 *     <li>it's {@code forward-compatible}, a delete-by-query will only send IDs to the shards as deletes such that no queries are  
        this(new SearchRequest(indices));
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return e;  
package org.opensearch.index.reindex;
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 *     <li>it's {@code non-atomic}, a delete-by-query may fail at any time while some documents matching the query have already been  
 *  
/*
    public IndicesOptions indicesOptions() {
    public DeleteByQueryRequest() {  
    }
 * <ul>
     * Set the IndicesOptions for controlling unavailable indices
 * Unless required by applicable law or agreed to in writing,
}
        getSearchRequest().source().size(size);  
 *     point in time the delete-by-query was started, equivalent to the scroll API</li>
/**  
        assert getSearchRequest() != null;  
        ToXContentObject {
        return b.toString();
 * GitHub history for details.
        this(new SearchRequest());
    }
import org.opensearch.action.ActionRequestValidationException;
 *
 * this work for additional information regarding copyright
    public String[] indices() {
import org.opensearch.action.support.IndicesOptions;
     * The scroll size to control number of documents processed per batch  
    DeleteByQueryRequest(SearchRequest search) {
    @Override
        if (getSearchRequest() == null || getSearchRequest().source() == null) {
            getSearchRequest().source().query(query);
    private DeleteByQueryRequest(SearchRequest search, boolean setDefaults) {
        return doForSlice(new DeleteByQueryRequest(slice, false), slicingTask, totalSlices);
    }
import org.opensearch.core.xcontent.ToXContentObject;
     */  
        return getSearchRequest().indices();
import org.opensearch.action.search.SearchRequest;  
        getSearchRequest().indices(indices);  
 * Licensed to Elasticsearch under one or more contributor  
        return this;
 */
        assert getSearchRequest() != null;
        }  
 * The OpenSearch Contributors require contributions made to  
        IndicesRequest.Replaceable,  
import org.opensearch.action.IndicesRequest;
        return this;
            e = addValidationError("query is missing", e);
    public DeleteByQueryRequest(String... indices) {
 * the query. This can have performance as well as visibility implications.
 * You may obtain a copy of the License at  
            e = addValidationError("source is missing", e);
    public String toString() {  
        super(in);
        }
        }  
 * @opensearch.internal
 * <p>  
     * Gets the batch size for this request
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (query != null) {
    public DeleteByQueryRequest(StreamInput in) throws IOException {  
 * Delete-by-query now has the following semantics:
        return getSearchRequest().source().size();
    // indices are resolved depend entirely on the inner search request. That's why the following methods delegate to it.
    }
        return getSearchRequest().indicesOptions();
 *     <li>it's executed on a {@code point-in-time} snapshot, a delete-by-query will only delete the documents that are visible at the  
 * Modifications Copyright OpenSearch Contributors. See
    public IndicesRequest indices(String... indices) {
    }
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    }
/*  
import org.opensearch.core.common.io.stream.StreamInput;
 * Creates a new {@link DeleteByQueryRequest} that uses scrolling and bulk requests to delete all documents matching
 */  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        this(search, true);  
import static org.opensearch.action.ValidateActions.addValidationError;
        return getSearchRequest().routing();
 * SPDX-License-Identifier: Apache-2.0
        return this;
     */  
 *     <li>it's results won't be visible until the index is refreshed.</li>
    }
    }
        return this;
        return builder;  
import org.opensearch.core.xcontent.XContentBuilder;
        return this;
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            e = addValidationError("use _all if you really want to delete from all existing indexes", e);
 *     <li>it's {@code consistent}, a delete-by-query will yield consistent results across all replicas of a shard</li>
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
        assert getSearchRequest() != null;  
        }  
        ActionRequestValidationException e = super.validate();  
    }
    }  
    @Override  
    @Override
 * </ul>  
    /**  
        builder.endObject();
    public DeleteByQueryRequest setBatchSize(int size) {
     */
    public DeleteByQueryRequest setIndicesOptions(IndicesOptions indicesOptions) {
        if (setDefaults) {
    @Override
    /**
        if (routing != null) {
    }
        builder.startObject();  
