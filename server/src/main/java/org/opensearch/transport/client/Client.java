     * <p>
    DeleteRequestBuilder prepareDelete(String index, String id);
        CompletableFuture<SearchResponse> future = new CompletableFuture<>();
     *
     * Search across one or more indices with a query.
 * GitHub history for details.
    void explain(ExplainRequest request, ActionListener<ExplainResponse> listener);
     */
     * Updates a document based on a script.
    void deletePits(DeletePitRequest deletePITRequest, ActionListener<DeletePitResponse> listener);
 * this work for additional information regarding copyright
     * Field capabilities - CompletionStage version
     * A search scroll request to continue searching a previous scrollable search request.
    SearchRequestBuilder prepareStreamSearch(String... indices);
 * <p>
    Client filterWithHeader(Map<String, String> headers);
    default CompletionStage<MultiSearchResponse> multiSearchAsync(MultiSearchRequest request) {
 * not use this file except in compliance with the License.
    /**
     * Deletes a document from the index based on the index, and id.
     *
    ActionFuture<DeleteResponse> delete(DeleteRequest request);
    /**
     * The id is optional, if it is not provided, one will be generated automatically.
     * @param request The index request
     */
    void fieldCaps(FieldCapabilitiesRequest request, ActionListener<FieldCapabilitiesResponse> listener);
import org.opensearch.action.search.SearchScrollRequestBuilder;
     * @param listener A listener to be notified with a result
     */
    SearchRequestBuilder prepareSearch(String... indices);
     */
import org.opensearch.action.termvectors.MultiTermVectorsRequestBuilder;
     * Clears the search contexts associated with specified scroll ids.
     */
     */
import org.opensearch.core.action.ActionListener;
     */
 *
import org.opensearch.common.lease.Releasable;
     * @throws IllegalArgumentException if the given clusterAlias doesn't exist
 */
     * @param index The index this explain is targeted for
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
    BulkRequestBuilder prepareBulk();
     */
    void pitSegments(PitSegmentsRequest pitSegmentsRequest, ActionListener<IndicesSegmentResponse> listener);
     */
     * Builder for the field capabilities request.
        return future;
     */
import org.opensearch.action.explain.ExplainResponse;
     * @param request The term vector request
    default CompletionStage<GetResponse> getAsync(GetRequest request) {
     * Get document - CompletionStage version
import org.opensearch.action.admin.indices.segments.PitSegmentsRequest;
    /**
     * @param request The bulk request
    /**
    ActionFuture<TermVectorsResponse> termVectors(TermVectorsRequest request);
    SearchScrollRequestBuilder prepareSearchScroll(String scrollId);
    /**
     *
package org.opensearch.transport.client;
import org.opensearch.action.search.MultiSearchResponse;
    MultiGetRequestBuilder prepareMultiGet();
import org.opensearch.action.bulk.BulkRequestBuilder;
        delete(request, ActionListener.wrap(future::complete, future::completeExceptionally));
        CompletableFuture<IndexResponse> future = new CompletableFuture<>();
import org.opensearch.common.Nullable;
     *
     * @param request The delete request
 */
import org.opensearch.action.get.MultiGetResponse;
     * Multi get documents.
     * @param listener A listener to be notified of the result
     * @param request  The search scroll request
    /**
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequest;
import org.opensearch.action.delete.DeleteRequest;
    }
     */
    ExplainRequestBuilder prepareExplain(String index, String id);
     * @param request The get request
     */
     * @param index The index to load the document from
     */
     * @see Requests#searchScrollRequest(String)
    /**
    /**
     */
     * Get all active point in time searches
     * @param id    The document identifier this explain is targeted for
     * Bulk operations - CompletionStage version
    /**
     * Multi get term vectors.
     * Term vectors - CompletionStage version
import org.opensearch.action.update.UpdateRequestBuilder;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.settings.Setting.Property;
     */
     *
    FieldCapabilitiesRequestBuilder prepareFieldCaps(String... indices);
    ActionFuture<SearchResponse> searchScroll(SearchScrollRequest request);
     *
     */
    ActionFuture<FieldCapabilitiesResponse> fieldCaps(FieldCapabilitiesRequest request);
import org.opensearch.common.settings.Settings;
        CompletableFuture<DeleteResponse> future = new CompletableFuture<>();
     * @param request  The request encapsulating the query and document identifier to compute a score explanation for
    /**
import org.opensearch.common.action.ActionFuture;
     * <p>
    /**
     * @see Requests#indexRequest(String)
     */
import org.opensearch.action.search.SearchResponse;
    }
 * under the License.
        update(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    IndexRequestBuilder prepareIndex();
    /**
    IndexRequestBuilder prepareIndex(String index);
    ActionFuture<SearchResponse> search(SearchRequest request);
/*
    default CompletionStage<FieldCapabilitiesResponse> fieldCapsAsync(FieldCapabilitiesRequest request) {
                throw new IllegalArgumentException("Can't parse [client.type] must be one of [node, transport]");
 * simply returns an {@link ActionFuture}, while the second accepts an
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
     * Multi get documents.
    void multiGet(MultiGetRequest request, ActionListener<MultiGetResponse> listener);
     * Search across one or more indices with a query.
        index(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     */
 * Unless required by applicable law or agreed to in writing,
     * Updates a document based on a script.
     * @see Requests#getRequest(String)
     * Computes a score explanation for the specified request.
     * @param index The index to delete the document from
 * A client can be retrieved from a started {@link org.opensearch.node.Node}.
    /**
     * Explain - CompletionStage version
    /**
     */
     *
     * @param request The request encapsulating the query and document identifier to compute a score explanation for
    default CompletionStage<TermVectorsResponse> termVectorsAsync(TermVectorsRequest request) {
    default CompletionStage<ExplainResponse> explainAsync(ExplainRequest request) {
    /**
    default CompletionStage<UpdateResponse> updateAsync(UpdateRequest request) {
    /**
import org.opensearch.action.search.ClearScrollRequest;
        multiGet(request, ActionListener.wrap(future::complete, future::completeExceptionally));
        switch (s) {
     */
    default CompletionStage<MultiGetResponse> multiGetAsync(MultiGetRequest request) {
    Settings settings();
    /**
        multiTermVectors(request, ActionListener.wrap(future::complete, future::completeExceptionally));
 * @see org.opensearch.node.Node#client()
        searchScroll(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    }
     */
     * Clears the search contexts associated with specified scroll ids.
     * Computes a score explanation for the specified request.
     */
    /**
     * Performs multiple search requests.
     * @param request  The update request
    ActionFuture<GetResponse> get(GetRequest request);
    /**
    /**
    }
import org.opensearch.action.bulk.BulkResponse;
     * An action that returns the field capabilities from the provided request
     */
    }
     * @param request The search scroll request
     * Updates a document based on a script.
    }
    ActionFuture<UpdateResponse> update(UpdateRequest request);
    /**
     * @see Requests#bulkRequest()
     * Performs multiple search requests.
    TermVectorsRequestBuilder prepareTermVectors(String index, String id);
    void searchScroll(SearchScrollRequest request, ActionListener<SearchResponse> listener);
        }
        CompletableFuture<BulkResponse> future = new CompletableFuture<>();
     * @param listener A listener to be notified of the result
     * @param request The update request
 * A client provides a one stop interface for performing actions/operations against the cluster.
    ActionFuture<MultiTermVectorsResponse> multiTermVectors(MultiTermVectorsRequest request);
     * Multi get documents.
    void bulk(BulkRequest request, ActionListener<BulkResponse> listener);
     */
        CompletableFuture<MultiTermVectorsResponse> future = new CompletableFuture<>();
     */
     * @return The result future
import org.opensearch.common.settings.Setting;
    }
    default CompletionStage<IndexResponse> indexAsync(IndexRequest request) {
import org.opensearch.action.fieldcaps.FieldCapabilitiesResponse;
 */
    /**
     * The id is optional, if it is not provided, one will be generated automatically.
    default CompletionStage<ClearScrollResponse> clearScrollAsync(ClearScrollRequest request) {
    UpdateRequestBuilder prepareUpdate();
     */
    /**
     */
    void delete(DeleteRequest request, ActionListener<DeleteResponse> listener);
    /**
/**
        return future;
     */
import org.opensearch.action.explain.ExplainRequestBuilder;
        explain(request, ActionListener.wrap(future::complete, future::completeExceptionally));
import org.opensearch.action.get.GetRequest;
     */
    }
     * Clear scroll - CompletionStage version
     */
 * compatible open source license.
    /**
 * {@link ActionListener}.
import org.opensearch.action.fieldcaps.FieldCapabilitiesRequestBuilder;
     *
    /**
 *
 * The OpenSearch Contributors require contributions made to
     *
     */
     * @see Requests#searchRequest(String...)
 *
 * Licensed to Elasticsearch under one or more contributor
     */
    void getAllPits(GetAllPitNodesRequest getAllPitNodesRequest, ActionListener<GetAllPitNodesResponse> listener);
     * Multi search - CompletionStage version
     * Index a document associated with a given index.
        return future;
                return s;
    ActionFuture<MultiSearchResponse> multiSearch(MultiSearchRequest request);
     * @return The result future
    void createPit(CreatePitRequest createPITRequest, ActionListener<CreatePitResponse> listener);
import org.opensearch.action.termvectors.TermVectorsRequestBuilder;
     * @param listener A listener to be notified with a result
     * Search scroll - CompletionStage version
     */
     * Updates a document based on a script.
        CompletableFuture<ClearScrollResponse> future = new CompletableFuture<>();
     */
import java.util.Map;
     */
     * Deletes a document from the index based on the index, and id.
     *
     * Executes a bulk of index / delete operations.
     * @see Requests#getRequest(String)
import org.opensearch.action.update.UpdateRequest;
     *
    void clearScroll(ClearScrollRequest request, ActionListener<ClearScrollResponse> listener);
import org.opensearch.action.index.IndexRequestBuilder;
    TermVectorsRequestBuilder prepareTermVectors();
     * Search - CompletionStage version
    ActionFuture<ExplainResponse> explain(ExplainRequest request);
import org.opensearch.action.termvectors.MultiTermVectorsRequest;
import org.opensearch.action.index.IndexRequest;
        CompletableFuture<GetResponse> future = new CompletableFuture<>();
     */
import org.opensearch.action.delete.DeleteResponse;
     * Multi get term vectors.
        return future;
    ActionFuture<BulkResponse> bulk(BulkRequest request);
     * @param request  The get request
        return future;
        return future;
    }
import org.opensearch.action.search.DeletePitResponse;
     * Gets the document that was indexed from an index with an id.
     * Returns this clients settings
     * @see Requests#searchRequest(String...)
        CompletableFuture<MultiGetResponse> future = new CompletableFuture<>();
import org.opensearch.action.explain.ExplainRequest;
        return future;
    GetRequestBuilder prepareGet();
 */
     * Index a document associated with a given index.
     */
    default CompletionStage<BulkResponse> bulkAsync(BulkRequest request) {
    MultiTermVectorsRequestBuilder prepareMultiTermVectors();
     * The id is optional, if it is not provided, one will be generated automatically.
     */
        CompletableFuture<MultiSearchResponse> future = new CompletableFuture<>();
    }
     */
        search(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    /**
     */
    /**
     * @param request The term vector request
import org.opensearch.action.get.GetRequestBuilder;
    /**
 *
     *
    ActionFuture<ClearScrollResponse> clearScroll(ClearScrollRequest request);
    GetRequestBuilder prepareGet(String index, String id);
 * <p>
import org.opensearch.action.search.MultiSearchRequestBuilder;
     * Search across one or more indices with a query.
     *
     *
     * @see Requests#deleteRequest(String)
        return future;
            case "transport":
     */
     */
 * @opensearch.api
    /**
    /**
import org.opensearch.action.termvectors.MultiTermVectorsResponse;
    /**
    /**
     */
     *
     */
     * @see Requests#searchScrollRequest(String)
    default CompletionStage<DeleteResponse> deleteAsync(DeleteRequest request) {
     * @return The result future
 * Modifications Copyright OpenSearch Contributors. See
     *
import org.opensearch.action.search.GetAllPitNodesResponse;
     * Performs multiple search requests.
     * @param index The index to index the document to
    ActionFuture<MultiGetResponse> multiGet(MultiGetRequest request);
 * You may obtain a copy of the License at
     * @return The result future
 *
    /**
        fieldCaps(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    /**
     * Computes a score explanation for the specified request.
     */
    /**
import org.opensearch.action.search.SearchRequest;
    /**
    /**
    /**
 * specific language governing permissions and limitations
     * @param listener A listener to be notified with a result
     * @see Requests#indexRequest(String)
    void termVectors(TermVectorsRequest request, ActionListener<TermVectorsResponse> listener);
     * Multi get - CompletionStage version
import org.opensearch.action.search.CreatePitRequest;
     * A search scroll request to continue searching a previous scrollable search request.
     * @param listener A listener to be notified of the result
    }
     */
import org.opensearch.action.delete.DeleteRequestBuilder;
    }
    Setting<String> CLIENT_TYPE_SETTING_S = new Setting<>("client.type", "node", (s) -> {
     * @param request  The bulk request
    AdminClient admin();
    /**
     * Search across one or more indices with a query.
     * Executes a bulk of index / delete operations with default index
     */
     * Deletes a document from the index based on the index, and id.
     * Delete a document - CompletionStage version
    /**
import org.opensearch.common.annotation.PublicApi;
        clearScroll(request, ActionListener.wrap(future::complete, future::completeExceptionally));
    ActionFuture<IndexResponse> index(IndexRequest request);
    }
     * Gets the document that was indexed from an index with an id.
     * @return The result future
        multiSearch(request, ActionListener.wrap(future::complete, future::completeExceptionally));
import org.opensearch.action.index.IndexResponse;
     * @param id    The id of the document to delete
    MultiSearchRequestBuilder prepareMultiSearch();
     * Get information of segments of one or more PITs
     * issued from it.
import org.opensearch.action.get.GetResponse;
     * Executes a bulk of index / delete operations.
     */
     * @param listener A listener to be notified with a result
     *
    void multiTermVectors(MultiTermVectorsRequest request, ActionListener<MultiTermVectorsResponse> listener);
    void multiSearch(MultiSearchRequest request, ActionListener<MultiSearchResponse> listener);
import org.opensearch.action.search.CreatePitResponse;
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
    /**
     * <p>
import org.opensearch.action.search.ClearScrollRequestBuilder;
     */
    BulkRequestBuilder prepareBulk(@Nullable String globalIndex);
    ClearScrollRequestBuilder prepareClearScroll();
     * Returns a client to a remote cluster with the given cluster alias.
    /**
     * Executes a bulk of index / delete operations.
     * An action that returns the term vectors for a specific document.
    default CompletionStage<MultiTermVectorsResponse> multiTermVectorsAsync(MultiTermVectorsRequest request) {
     * @return The result future
        return future;
    /**
     * Deletes a document from the index based on the index, and id.
     *
        CompletableFuture<FieldCapabilitiesResponse> future = new CompletableFuture<>();
    /**
        CompletableFuture<TermVectorsResponse> future = new CompletableFuture<>();
import org.opensearch.action.bulk.BulkRequest;
     *
     * Gets the document that was indexed from an index with an id.
            case "node":
     *
    /**
        bulk(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     */
    /**
     * @see Requests#deleteRequest(String)
    /**
     * Index a document associated with a given index.
     * @param request  The search request
    /**
 * license agreements. See the NOTICE file distributed with
     * @throws UnsupportedOperationException if this functionality is not available on this client.
    /**
import org.opensearch.action.search.MultiSearchRequest;
     */
    default CompletionStage<SearchResponse> searchAsync(SearchRequest request) {
     */
     */
    }
 * All operations performed are asynchronous by nature. Each action/operation has two flavors, the first
}
     */
    DeleteRequestBuilder prepareDelete();
     * The id is optional, if it is not provided, one will be generated automatically.
     * Returns a new lightweight Client that applies all given headers to each of the requests
     */
     * Update a document - CompletionStage version
        return future;
    /**
     * @return The result future
import java.util.concurrent.CompletionStage;
     * The admin client that can be used to perform administrative operations.
import org.opensearch.action.get.MultiGetRequestBuilder;
        return future;
    /**
    /**
        CompletableFuture<SearchResponse> future = new CompletableFuture<>();
     * Gets the document that was indexed from an index with an id.
    /**
    /**
    }, Property.NodeScope);
import org.opensearch.action.search.SearchRequestBuilder;
     */
     * A search scroll request to continue searching a previous scrollable search request.
     * Delete one or more point in time contexts
    UpdateRequestBuilder prepareUpdate(String index, String id);
    /**
     */
    void index(IndexRequest request, ActionListener<IndexResponse> listener);
     */
    void update(UpdateRequest request, ActionListener<UpdateResponse> listener);
import org.opensearch.action.termvectors.TermVectorsResponse;
    /**
     */
     * @param id    The id of the document
import org.opensearch.action.termvectors.TermVectorsRequest;
        get(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     * An action that returns the term vectors for a specific document.
     */
    /**
     * An action that returns the field capabilities from the provided request
import org.opensearch.action.search.SearchScrollRequest;
    void get(GetRequest request, ActionListener<GetResponse> listener);
     *
/*
     * @param request  The index request
     * Builder for the term vector request.
import org.opensearch.action.update.UpdateResponse;
     */
     * @param listener A listener to be notified with a result
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
     */
@PublicApi(since = "1.0.0")
        CompletableFuture<UpdateResponse> future = new CompletableFuture<>();
    /**
     * <p>
     * Multi get term vectors.
    void search(SearchRequest request, ActionListener<SearchResponse> listener);
        return future;
        CompletableFuture<ExplainResponse> future = new CompletableFuture<>();
    /**
    /**
        throw new UnsupportedOperationException("this client doesn't support remote cluster connections");
     */
     * Create point in time for one or more indices
import java.util.concurrent.CompletableFuture;
    /**
    /**
import org.opensearch.action.search.DeletePitRequest;
import org.opensearch.action.get.MultiGetRequest;
    default Client getRemoteClusterClient(String clusterAlias) {
     * @return The response future
        return future;
    default CompletionStage<SearchResponse> searchScrollAsync(SearchScrollRequest request) {
     */
    /**
     */
        termVectors(request, ActionListener.wrap(future::complete, future::completeExceptionally));
     */
    }
     * Index a document - CompletionStage version
     */
            default:
 * software distributed under the License is distributed on an
     * @param request The search request
     */
     *
    /**
     */
    /**
public interface Client extends OpenSearchClient, Releasable {
     * Multi term vectors - CompletionStage version
    /**
     * Clears the search contexts associated with specified scroll ids.
     */
    /**
/*
     * Builder for the term vector request.
        return future;
     * @param request  The delete request
     * Index a JSON source associated with a given index.
     * @see Requests#bulkRequest()
     */
    /**
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.search.ClearScrollResponse;
     *
import org.opensearch.action.search.GetAllPitNodesRequest;
