     */
     * Clears the search contexts associated with specified scroll ids.  
import org.opensearch.action.get.MultiGetRequestBuilder;
import org.opensearch.common.Nullable;
     * Deletes a document from the index based on the index, and id.  
    void update(UpdateRequest request, ActionListener<UpdateResponse> listener);
    default CompletionStage<MultiSearchResponse> multiSearchAsync(MultiSearchRequest request) {
import org.opensearch.action.admin.indices.segments.PitSegmentsRequest;
     *
     */  
     * Term vectors - CompletionStage version
     * @param index The index to index the document to
    default CompletionStage<SearchResponse> searchAsync(SearchRequest request) {
        multiTermVectors(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
     */
     * @see Requests#bulkRequest()
     * @param listener A listener to be notified of the result
        bulk(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
     */
     *
     * Computes a score explanation for the specified request.
     */  
    ActionFuture<FieldCapabilitiesResponse> fieldCaps(FieldCapabilitiesRequest request);  
        return future;
     *
    /**
     */  
     */  
 * @see org.opensearch.node.Node#client()  
     */  
     * @throws IllegalArgumentException if the given clusterAlias doesn't exist  
     */  
    ActionFuture<SearchResponse> searchScroll(SearchScrollRequest request);
 * SPDX-License-Identifier: Apache-2.0
        CompletableFuture<BulkResponse> future = new CompletableFuture<>();
     * Gets the document that was indexed from an index with an id.
import org.opensearch.action.get.MultiGetRequest;  
    }
     */  
    }
     */
 * A client provides a one stop interface for performing actions/operations against the cluster.
     */  
    /**  
 * software distributed under the License is distributed on an
    /**
        return future;
     */  
 * Unless required by applicable law or agreed to in writing,
     * Multi search - CompletionStage version
     */  
    ActionFuture<MultiSearchResponse> multiSearch(MultiSearchRequest request);
import org.opensearch.action.bulk.BulkRequestBuilder;
     * The id is optional, if it is not provided, one will be generated automatically.  
     * @see Requests#getRequest(String)  
        return future;
        return future;
     * @param index The index to delete the document from
    /**  
    }
     * Gets the document that was indexed from an index with an id.
    default CompletionStage<GetResponse> getAsync(GetRequest request) {
    void fieldCaps(FieldCapabilitiesRequest request, ActionListener<FieldCapabilitiesResponse> listener);
    /**
    /**  
     *
    }
    /**
     * @param listener A listener to be notified with a result  
    GetRequestBuilder prepareGet();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
     */  
     * Deletes a document from the index based on the index, and id.  
import org.opensearch.action.search.MultiSearchResponse;
    default CompletionStage<SearchResponse> searchScrollAsync(SearchScrollRequest request) {
     * An action that returns the term vectors for a specific document.
    /**  
    /**  
    void clearScroll(ClearScrollRequest request, ActionListener<ClearScrollResponse> listener);
    default CompletionStage<BulkResponse> bulkAsync(BulkRequest request) {
     * An action that returns the field capabilities from the provided request  
     * Multi term vectors - CompletionStage version
 * ownership. Elasticsearch licenses this file to you under  
     * @param request  The index request
    ActionFuture<UpdateResponse> update(UpdateRequest request);  
        index(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
     */
     * @param listener A listener to be notified with a result
     * @return The result future
 */  
    /**
import org.opensearch.action.search.ClearScrollRequest;  
import java.util.concurrent.CompletableFuture;  
import org.opensearch.common.lease.Releasable;
     */
     * @see Requests#searchRequest(String...)
     * @param id    The id of the document
     * Clears the search contexts associated with specified scroll ids.
     * Gets the document that was indexed from an index with an id.
     * @return The result future
    /**  
    /**
     * The id is optional, if it is not provided, one will be generated automatically.
     * <p>  
     * A search scroll request to continue searching a previous scrollable search request.
/**  
import org.opensearch.action.search.MultiSearchRequest;  
import org.opensearch.common.settings.Setting.Property;
    ActionFuture<IndexResponse> index(IndexRequest request);
     */
 * <p>  
     * Index a document associated with a given index.
    default CompletionStage<DeleteResponse> deleteAsync(DeleteRequest request) {
    /**
     * Search across one or more indices with a query.  
     */  
import org.opensearch.action.get.GetRequestBuilder;
     * Computes a score explanation for the specified request.  
 * compatible open source license.
    /**
    /**
     */
    Client filterWithHeader(Map<String, String> headers);
     *  
import org.opensearch.action.search.SearchResponse;
        get(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
import org.opensearch.action.fieldcaps.FieldCapabilitiesResponse;
    /**
    void multiSearch(MultiSearchRequest request, ActionListener<MultiSearchResponse> listener);  
     * Multi get documents.
    /**
     * @param request  The bulk request  
    BulkRequestBuilder prepareBulk();  
import org.opensearch.common.settings.Setting;  
    Setting<String> CLIENT_TYPE_SETTING_S = new Setting<>("client.type", "node", (s) -> {
     * Builder for the term vector request.
     * <p>
     */
     */
import org.opensearch.action.search.GetAllPitNodesResponse;
     */  
import org.opensearch.action.index.IndexResponse;
     * @return The response future
 *
                return s;
     * @see Requests#searchRequest(String...)
    TermVectorsRequestBuilder prepareTermVectors();
    ActionFuture<MultiTermVectorsResponse> multiTermVectors(MultiTermVectorsRequest request);
import org.opensearch.action.search.SearchRequestBuilder;
     * @throws UnsupportedOperationException if this functionality is not available on this client.
        CompletableFuture<FieldCapabilitiesResponse> future = new CompletableFuture<>();
     */  
    /**
                throw new IllegalArgumentException("Can't parse [client.type] must be one of [node, transport]");
 * Modifications Copyright OpenSearch Contributors. See
     * @see Requests#searchScrollRequest(String)
     * Updates a document based on a script.
     * Multi get term vectors.  
        return future;
import org.opensearch.action.search.SearchScrollRequest;  
    ActionFuture<GetResponse> get(GetRequest request);
    default CompletionStage<MultiTermVectorsResponse> multiTermVectorsAsync(MultiTermVectorsRequest request) {
     */
    /**  
     * Search across one or more indices with a query.  
        CompletableFuture<SearchResponse> future = new CompletableFuture<>();
 * {@link ActionListener}.
    /**
    /**
     * Get information of segments of one or more PITs  
     *
 */  
     * Get document - CompletionStage version
     * @param request  The search scroll request  
     */
        return future;
    AdminClient admin();
        return future;
    SearchScrollRequestBuilder prepareSearchScroll(String scrollId);  
    /**
 * All operations performed are asynchronous by nature. Each action/operation has two flavors, the first  
    /**
    /**
     * Builder for the field capabilities request.
     */  
     */
     */
     * <p>
    default CompletionStage<ExplainResponse> explainAsync(ExplainRequest request) {
     * Updates a document based on a script.
     * @param request The request encapsulating the query and document identifier to compute a score explanation for
     *
     * @param listener A listener to be notified with a result  
/*  
    default CompletionStage<UpdateResponse> updateAsync(UpdateRequest request) {
package org.opensearch.transport.client;
     *
 *
     */  
     * Builder for the term vector request.
     *  
    /**
import org.opensearch.common.annotation.PublicApi;
 */  
 * Licensed to Elasticsearch under one or more contributor  
     * Delete a document - CompletionStage version
    default CompletionStage<ClearScrollResponse> clearScrollAsync(ClearScrollRequest request) {
    }
import org.opensearch.action.search.GetAllPitNodesRequest;
    /**  
 * KIND, either express or implied.  See the License for the
import java.util.Map;
        CompletableFuture<SearchResponse> future = new CompletableFuture<>();
     *
     */  
     *
import org.opensearch.action.delete.DeleteResponse;
     */  
    ActionFuture<ClearScrollResponse> clearScroll(ClearScrollRequest request);  
    /**  
    /**  
     * The id is optional, if it is not provided, one will be generated automatically.  
    /**
    /**
     * Deletes a document from the index based on the index, and id.  
import org.opensearch.action.termvectors.TermVectorsRequestBuilder;  
     * @param request  The delete request
     * @param listener A listener to be notified of the result  
     * @param id    The id of the document to delete
 * You may obtain a copy of the License at  
     * @see Requests#deleteRequest(String)
     * A search scroll request to continue searching a previous scrollable search request.
     * Gets the document that was indexed from an index with an id.
    SearchRequestBuilder prepareStreamSearch(String... indices);
        CompletableFuture<MultiTermVectorsResponse> future = new CompletableFuture<>();
     *  
    void multiTermVectors(MultiTermVectorsRequest request, ActionListener<MultiTermVectorsResponse> listener);
import org.opensearch.action.search.DeletePitResponse;  
    /**
        throw new UnsupportedOperationException("this client doesn't support remote cluster connections");
     * @param request The search scroll request  
    void index(IndexRequest request, ActionListener<IndexResponse> listener);  
     */
    void pitSegments(PitSegmentsRequest pitSegmentsRequest, ActionListener<IndicesSegmentResponse> listener);
import org.opensearch.common.settings.Settings;
    /**
     * Index a document - CompletionStage version
     * @return The result future
     */  
    /**
import org.opensearch.action.search.SearchRequest;  
     * @param request The bulk request  
    default CompletionStage<IndexResponse> indexAsync(IndexRequest request) {
     */
     */  
 * GitHub history for details.
     * @param request The get request
 * A client can be retrieved from a started {@link org.opensearch.node.Node}.
     */  
     */
     */
    MultiSearchRequestBuilder prepareMultiSearch();
    /**  
     */
    }
        }
     * Executes a bulk of index / delete operations.
     * Executes a bulk of index / delete operations.
     */
     * Returns this clients settings
    }
    void deletePits(DeletePitRequest deletePITRequest, ActionListener<DeletePitResponse> listener);
     */  
    Settings settings();
     * Deletes a document from the index based on the index, and id.
    /**
    /**
     * @return The result future  
        return future;
    /**
     * Get all active point in time searches
    /**
     * Field capabilities - CompletionStage version
     * Multi get - CompletionStage version
        CompletableFuture<TermVectorsResponse> future = new CompletableFuture<>();
        multiSearch(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
     * Clears the search contexts associated with specified scroll ids.
 *
     */
     * Updates a document based on a script.  
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequestBuilder;
     * @param index The index this explain is targeted for
        update(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
        CompletableFuture<ClearScrollResponse> future = new CompletableFuture<>();
    /**
    /**
    void delete(DeleteRequest request, ActionListener<DeleteResponse> listener);  
     * issued from it.
     * An action that returns the field capabilities from the provided request
     * Computes a score explanation for the specified request.  
     * @param request The term vector request
     * @see Requests#getRequest(String)  
     */  
        return future;
    /**
 * under the License.  
    /**
     * A search scroll request to continue searching a previous scrollable search request.
     */
        explain(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
 * this work for additional information regarding copyright
        return future;
     */
    /**  
import org.opensearch.action.delete.DeleteRequestBuilder;
     * Index a JSON source associated with a given index.
import org.opensearch.action.termvectors.MultiTermVectorsRequestBuilder;  
    /**
    UpdateRequestBuilder prepareUpdate();
    /**
     * @param listener A listener to be notified with a result  
import org.opensearch.action.termvectors.TermVectorsResponse;
/*  
    /**
    void get(GetRequest request, ActionListener<GetResponse> listener);
     * @param request The delete request
    UpdateRequestBuilder prepareUpdate(String index, String id);  
    ActionFuture<BulkResponse> bulk(BulkRequest request);
     *
import org.opensearch.action.update.UpdateRequest;
    /**
     */
import org.opensearch.action.explain.ExplainRequest;  
        CompletableFuture<MultiGetResponse> future = new CompletableFuture<>();
     * Search across one or more indices with a query.  
    void createPit(CreatePitRequest createPITRequest, ActionListener<CreatePitResponse> listener);
     * An action that returns the term vectors for a specific document.
 * license agreements. See the NOTICE file distributed with
     * Explain - CompletionStage version
     */  
    }, Property.NodeScope);  
        CompletableFuture<DeleteResponse> future = new CompletableFuture<>();
    ActionFuture<SearchResponse> search(SearchRequest request);  
        fieldCaps(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
        termVectors(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
    DeleteRequestBuilder prepareDelete();
     * @param id    The document identifier this explain is targeted for  
     * Multi get documents.
     * Returns a new lightweight Client that applies all given headers to each of the requests
     */
import org.opensearch.action.search.ClearScrollResponse;
    void searchScroll(SearchScrollRequest request, ActionListener<SearchResponse> listener);
    /**  
        clearScroll(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
     * The id is optional, if it is not provided, one will be generated automatically.
     * @see Requests#indexRequest(String)
        return future;
 * @opensearch.api
 *  
     */  
        searchScroll(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
     * @param request The term vector request  
    /**
    /**  
     */  
import org.opensearch.action.explain.ExplainRequestBuilder;
     */  
     * Multi get term vectors.
     * Executes a bulk of index / delete operations.
     */
    MultiGetRequestBuilder prepareMultiGet();  
import org.opensearch.action.update.UpdateRequestBuilder;  
public interface Client extends OpenSearchClient, Releasable {
    }
     * Create point in time for one or more indices  
     * Multi get term vectors.
    /**
     * @param request The search request
        CompletableFuture<GetResponse> future = new CompletableFuture<>();
     *  
     */
@PublicApi(since = "1.0.0")
     * @param index The index to load the document from  
     * @return The result future  
        return future;
import org.opensearch.action.explain.ExplainResponse;
import org.opensearch.core.action.ActionListener;  
     */  
     * @param request  The request encapsulating the query and document identifier to compute a score explanation for
     */
        return future;
    ActionFuture<ExplainResponse> explain(ExplainRequest request);  
import org.opensearch.action.get.GetResponse;
            default:  
     * @param listener A listener to be notified of the result  
import org.opensearch.action.termvectors.MultiTermVectorsRequest;
    void getAllPits(GetAllPitNodesRequest getAllPitNodesRequest, ActionListener<GetAllPitNodesResponse> listener);  
    void explain(ExplainRequest request, ActionListener<ExplainResponse> listener);
    /**
    }
 * not use this file except in compliance with the License.
     * Performs multiple search requests.  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
     */  
import org.opensearch.action.get.GetRequest;  
    }
        CompletableFuture<IndexResponse> future = new CompletableFuture<>();
     * @see Requests#deleteRequest(String)
     * Search - CompletionStage version
        CompletableFuture<UpdateResponse> future = new CompletableFuture<>();
    /**
     */
    }
import org.opensearch.action.termvectors.MultiTermVectorsResponse;
import org.opensearch.action.get.MultiGetResponse;
    /**  
    default Client getRemoteClusterClient(String clusterAlias) {  
    IndexRequestBuilder prepareIndex(String index);
    DeleteRequestBuilder prepareDelete(String index, String id);
import org.opensearch.action.update.UpdateResponse;
    default CompletionStage<FieldCapabilitiesResponse> fieldCapsAsync(FieldCapabilitiesRequest request) {
        multiGet(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
}
     */
     */  
     * @param request  The get request
    MultiTermVectorsRequestBuilder prepareMultiTermVectors();  
import org.opensearch.action.search.CreatePitRequest;  
    ClearScrollRequestBuilder prepareClearScroll();
            case "node":  
     * Search scroll - CompletionStage version
     */  
    /**
            case "transport":
    /**
     * @return The result future
     *
     * @param request The index request  
        switch (s) {
    /**
import org.opensearch.action.search.CreatePitResponse;
     * @param listener A listener to be notified with a result
 * specific language governing permissions and limitations
    /**
        CompletableFuture<MultiSearchResponse> future = new CompletableFuture<>();
    GetRequestBuilder prepareGet(String index, String id);  
    SearchRequestBuilder prepareSearch(String... indices);
import org.opensearch.action.search.ClearScrollRequestBuilder;
     * @param request  The search request
        return future;
     */
/*
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
     *
     */  
     */
    default CompletionStage<MultiGetResponse> multiGetAsync(MultiGetRequest request) {
    /**  
        delete(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
     * Updates a document based on a script.
     * @return The result future
     * Update a document - CompletionStage version
        CompletableFuture<ExplainResponse> future = new CompletableFuture<>();
        search(request, ActionListener.wrap(future::complete, future::completeExceptionally));  
    default CompletionStage<TermVectorsResponse> termVectorsAsync(TermVectorsRequest request) {
     * Performs multiple search requests.
    /**  
     * Clear scroll - CompletionStage version
import org.opensearch.action.index.IndexRequestBuilder;
     */  
     * Index a document associated with a given index.
     * Index a document associated with a given index.  
     *  
    /**  
     * <p>
     * @param request  The update request
import org.opensearch.action.bulk.BulkRequest;  
import org.opensearch.action.search.MultiSearchRequestBuilder;
    void bulk(BulkRequest request, ActionListener<BulkResponse> listener);
    ExplainRequestBuilder prepareExplain(String index, String id);
     * The admin client that can be used to perform administrative operations.  
     */
     * Search across one or more indices with a query.
    void termVectors(TermVectorsRequest request, ActionListener<TermVectorsResponse> listener);
     * Returns a client to a remote cluster with the given cluster alias.
     *
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.termvectors.TermVectorsRequest;
    /**
    }
     * @see Requests#bulkRequest()
     * Multi get documents.  
     *
    ActionFuture<TermVectorsResponse> termVectors(TermVectorsRequest request);
import org.opensearch.common.action.ActionFuture;  
     */  
 * <p>
    FieldCapabilitiesRequestBuilder prepareFieldCaps(String... indices);
     * Bulk operations - CompletionStage version
     *
    }
     * @param request The update request  
    ActionFuture<MultiGetResponse> multiGet(MultiGetRequest request);
     * @see Requests#searchScrollRequest(String)
     * Executes a bulk of index / delete operations with default index  
import org.opensearch.action.index.IndexRequest;  
     * @see Requests#indexRequest(String)
    }
    void search(SearchRequest request, ActionListener<SearchResponse> listener);  
    /**
    /**
 */
     */
    /**
     * Performs multiple search requests.
    }
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;  
import org.opensearch.action.bulk.BulkResponse;
     *
    TermVectorsRequestBuilder prepareTermVectors(String index, String id);  
import org.opensearch.action.delete.DeleteRequest;  
    ActionFuture<DeleteResponse> delete(DeleteRequest request);  
    IndexRequestBuilder prepareIndex();
    /**  
    /**
     *
    void multiGet(MultiGetRequest request, ActionListener<MultiGetResponse> listener);
import java.util.concurrent.CompletionStage;
    /**
    BulkRequestBuilder prepareBulk(@Nullable String globalIndex);
     */
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
     *
    /**  
 *
     * Delete one or more point in time contexts
import org.opensearch.action.search.SearchScrollRequestBuilder;
    /**  
import org.opensearch.action.search.DeletePitRequest;
     */
 * simply returns an {@link ActionFuture}, while the second accepts an
