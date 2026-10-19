        if (Objects.isNull(value) && !Objects.isNull(globalDefault)) {
    private final Set<String> indices = new HashSet<>();  
        @Nullable String defaultPipeline,  
import org.apache.lucene.util.RamUsageEstimator;
     * The list of requests in this bulk request.  
    @Override
            }
    public final BulkRequest routing(String globalRouting) {
 *
import org.opensearch.action.support.replication.ReplicationRequest;  
import org.opensearch.common.Nullable;
import org.opensearch.core.xcontent.MediaType;
import java.util.Collections;
            defaultIndex,
        BytesReference data,
        return this.requests;  
    @Override
        if (requests.isEmpty()) {
    }
import org.opensearch.core.common.bytes.BytesArray;  
    public String getDescription() {
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        this.globalRouting = globalRouting;
import java.util.HashSet;
package org.opensearch.action.bulk;
                if (validationException == null) {
        @Nullable Boolean defaultRequireAlias,
            sizeInBytes += request.upsertRequest().source().length();
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * @see Client#bulk(BulkRequest)
    private long sizeInBytes = 0;
        throws IOException {  
    ) throws IOException {  
     * Adds a framed data in binary format
    @Override  
        @Nullable FetchSourceContext defaultFetchSourceContext,
        return timeout(TimeValue.parseTimeValue(timeout, null, getClass().getSimpleName() + ".timeout"));
import org.opensearch.core.common.Strings;
    /**  
        return internalAdd(request);
 * A bulk request holds an ordered {@link IndexRequest}s, {@link DeleteRequest}s and {@link UpdateRequest}s
        }
                    validationException  
    }  
     */
    @Override  
        Objects.requireNonNull(request, "'request' must not be null");
    private ActiveShardCount waitForActiveShards = ActiveShardCount.DEFAULT;  
        return requests.size();
    public BulkRequest add(BytesReference data, @Nullable String defaultIndex, boolean allowExplicitIndex, MediaType mediaType)
public class BulkRequest extends ActionRequest implements CompositeIndicesRequest, WriteRequest<BulkRequest>, Accountable {
      - {@link BulkRequest#add(UpdateRequest)}  
/**  
 * You may obtain a copy of the License at  
import org.opensearch.action.ActionRequest;
}
        }  
        for (DocWriteRequest<?> request : requests) {
import org.opensearch.action.ActionRequestValidationException;
    }
        if (request instanceof IndexRequest) {  
            this::add
    }
import org.opensearch.action.DocWriteRequest;
    }
    public BulkRequest requireAlias(Boolean globalRequireAlias) {
     */
        return value;
 * KIND, either express or implied.  See the License for the
 * @opensearch.api
    public long estimatedSizeInBytes() {
    }  
    }
        requests.add(request);
     * Adds a framed data in binary format  
    ) throws IOException {
        Boolean requireAlias = valueOrDefault(defaultRequireAlias, globalRequireAlias);
    /**
     */  
            this::internalAdd,
    private RefreshPolicy refreshPolicy = RefreshPolicy.NONE;
        Objects.requireNonNull(request, "'request' must not be null");
     * See {@link ReplicationRequest#waitForActiveShards(ActiveShardCount)} for details.
    }
     * - {@link BulkRequest#add(UpdateRequest)}
        out.writeCollection(requests, DocWriteRequest::writeDocumentRequest);
 * The OpenSearch Contributors require contributions made to  
            defaultFetchSourceContext,  
     */  
        requests.addAll(in.readList(i -> DocWriteRequest.readDocumentRequest(null, i)));
     * - {@link BulkRequest#add(DocWriteRequest[])} )}  
        applyGlobalMandatoryParameters(request);  
    public BulkRequest(StreamInput in) throws IOException {
    /**
    /**
    /**
import org.opensearch.common.annotation.PublicApi;  
        boolean allowExplicitIndex,
     *                            Only the global index is applied to the request objects.
     */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamOutput;  
        return timeout;
    /**
        request.index(valueOrDefault(request.index(), globalIndex));  
        return this;
    }
 */  
 */
import java.util.Set;
        }
            add(request);
        return add(data, defaultIndex, defaultRouting, defaultFetchSourceContext, defaultPipeline, null, allowExplicitIndex, mediaType);
        return value;
            // We first check if refresh has been set
            return globalDefault;  
        return this;
    /**  
     */
        return internalAdd(request);
    }
    }
            pipeline,
        @Nullable String defaultIndex,  
import org.opensearch.core.common.bytes.BytesReference;
import org.apache.lucene.util.Accountable;
     * the global parameter setting is ignored when used with:
     */
        for (DocWriteRequest<?> request : requests) {
    private static final int REQUEST_OVERHEAD = 50;
        waitForActiveShards.writeTo(out);  
 * specific language governing permissions and limitations
        String routing = valueOrDefault(defaultRouting, globalRouting);
     * - {@link BulkRequest#add(DocWriteRequest)}
        MediaType mediaType  
    }
     */
     * the global parameter setting is ignored when used with:  
        this.refreshPolicy = refreshPolicy;  
    private String globalRouting;  
        }
     * @return the current bulk request  
        for (DocWriteRequest<?> request : requests) {
    @Override
 *  
    }
    /**
            mediaType,
     * - {@link BulkRequest#add(Iterable)}
    /**  
        return this;
                validationException.addValidationErrors(ex.validationErrors());
 * this work for additional information regarding copyright
            return globalDefault;
    }
            allowExplicitIndex,  
     * @return Bulk request with global setting set  
     * - {@link BulkRequest#add(DocWriteRequest)}
     * - {@link BulkRequest#add(IndexRequest)}  
        // lack of source is validated in validate() method  
        return this;  
     * Adds an {@link IndexRequest} to the list of actions to execute. Follows the same behavior of {@link IndexRequest}  
     * - {@link BulkRequest#add(Iterable)}
import org.opensearch.action.delete.DeleteRequest;
     * Adds a list of requests to be executed. Either index or delete requests.
    BulkRequest internalAdd(UpdateRequest request) {
     * Note for internal callers: This method does not respect all global parameters.
        }
import java.util.Objects;
    }
            data,  
     * Adds an {@link DeleteRequest} to the list of actions to execute.
        } else if (request instanceof UpdateRequest) {
        @Nullable String defaultRouting,
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.
            ActionRequestValidationException ex = ((WriteRequest<?>) request).validate();  
        return this.waitForActiveShards;
        }
        return this;  
    }  
 *  
    public BulkRequest add(IndexRequest request) {  
    public BulkRequest add(
import org.opensearch.action.CompositeIndicesRequest;  
import org.opensearch.action.index.IndexRequest;  
        return Collections.unmodifiableSet(indices);
    /**  
        @Nullable FetchSourceContext defaultFetchSourceContext,
    /**  
     * <p>  
    private Boolean globalRequireAlias;
            validationException = addValidationError("no requests added", validationException);
    public Boolean requireAlias() {
 * Modifications Copyright OpenSearch Contributors. See
      - {@link BulkRequest#add(Iterable)}  
     * A shortcut for {@link #waitForActiveShards(ActiveShardCount)} where the numerical
 * <p>  
        return add(data, defaultIndex, null, null, null, null, true, mediaType);
    }
     * (for example, if no id is provided, one will be generated, or usage of the create flag).
            sizeInBytes += request.doc().source().length();
    /**
     */
 * software distributed under the License is distributed on an
        MediaType mediaType
import java.io.IOException;
                    validationException = new ActionRequestValidationException();  
                );
import org.opensearch.common.unit.TimeValue;
    }
        return add(data, defaultIndex, null, null, null, null, allowExplicitIndex, mediaType);
     * Add a request to the current BulkRequest.
import static org.opensearch.action.ValidateActions.addValidationError;
import org.opensearch.core.common.io.stream.StreamInput;
    }
    }  
        return waitForActiveShards(ActiveShardCount.from(waitForActiveShards));  
        return this;
    }  
 * license agreements. See the NOTICE file distributed with
        if (out.getVersion().onOrAfter(Version.V_2_14_0) && out.getVersion().before(Version.V_3_0_0)) {
            in.readInt(); // formerly batch_size  
     * {@link WriteRequest}s to this but java doesn't support syntax to declare that everything in the array has both types so we declare
            sizeInBytes += request.script().getIdOrCode().length() * 2;
 * under the License.  
    /**
        ActionRequestValidationException validationException = null;  
    private String globalPipeline;
    public void writeTo(StreamOutput out) throws IOException {
    public Set<String> getIndices() {
    public BulkRequest add(byte[] data, int from, int length, MediaType mediaType) throws IOException {
        return refreshPolicy;  
    public int numberOfActions() {  
    public BulkRequest add(BytesReference data, @Nullable String defaultIndex, MediaType mediaType) throws IOException {
import org.opensearch.action.update.UpdateRequest;
        if (request.doc() != null) {  
        new BulkRequestParser().parse(
     */
     */  
        } else {  
    public final BulkRequest timeout(TimeValue timeout) {  
     */  
import org.opensearch.action.support.ActiveShardCount;
    public BulkRequest(@Nullable String globalIndex) {
     * @param globalRequireAlias the global default setting
    }
            if (ex != null) {
        this.waitForActiveShards = waitForActiveShards;
     */
        indices.add(request.index());  
    public BulkRequest add(DocWriteRequest<?> request) {
     * Note for internal callers (NOT high level rest client),
        return this;
        return sizeInBytes;
        this.globalPipeline = globalPipeline;  
    public BulkRequest waitForActiveShards(final int waitForActiveShards) {
    }
        }  
        waitForActiveShards = ActiveShardCount.readFrom(in);
@PublicApi(since = "1.0.0")  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param globalPipeline the global default setting
    }
    }
    }
    }
        indices.add(request.index());  
        return "requests[" + requests.size() + "], indices[" + Strings.collectionToDelimitedString(indices, ", ") + "]";
        out.writeTimeValue(timeout);  
        if (in.getVersion().onOrAfter(Version.V_2_14_0) && in.getVersion().before(Version.V_3_0_0)) {
     * Adds a framed data in binary format  
        return SHALLOW_SIZE + requests.stream().mapToLong(Accountable::ramBytesUsed).sum();
      - {@link BulkRequest#add(DocWriteRequest)}
    public BulkRequest add(byte[] data, int from, int length, @Nullable String defaultIndex, MediaType mediaType) throws IOException {  
    }  
        sizeInBytes += REQUEST_OVERHEAD;  
            add((IndexRequest) request);
 * Note that we only support refresh on the bulk request not per item.
        if (request.script() != null) {  
            routing,
import org.opensearch.action.support.WriteRequest;
     * the global parameter setting is ignored when used with:
        this.globalRequireAlias = globalRequireAlias;  
    public String routing() {  
/*
            add((DeleteRequest) request);  
    private static Boolean valueOrDefault(Boolean value, Boolean globalDefault) {
import java.util.List;  
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
    public BulkRequest setRefreshPolicy(RefreshPolicy refreshPolicy) {
                validationException = addValidationError(
        if (request.upsertRequest() != null) {  
            if (((WriteRequest<?>) request).getRefreshPolicy() != RefreshPolicy.NONE) {  
    public BulkRequest add(DocWriteRequest<?>... requests) {  
    public TimeValue timeout() {
        return validationException;  
    /**
      - {@link BulkRequest#add(IndexRequest)}
import org.opensearch.Version;  
     * <p>
        indices.add(request.index());
 * GitHub history for details.
    }  
    /**  
     * - {@link BulkRequest#add(UpdateRequest)}
     */  
        @Nullable String defaultIndex,  
    final List<DocWriteRequest<?>> requests = new ArrayList<>();
        requests.stream().map(DocWriteRequest::index).forEach(indices::add);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.client.Client;  
        return globalRouting;
        return this;  
    /**  
      - {@link BulkRequest#add(DocWriteRequest[])} )}
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
    BulkRequest internalAdd(IndexRequest request) {
        boolean allowExplicitIndex,
    private static String valueOrDefault(String value, String globalDefault) {  
     */
    /**
        return this;
     * @return Bulk request with global setting set
    public RefreshPolicy getRefreshPolicy() {
     * <p>
    public final BulkRequest pipeline(String globalPipeline) {
        timeout = in.readTimeValue();
        String pipeline = valueOrDefault(defaultPipeline, globalPipeline);  
 * Licensed to Elasticsearch under one or more contributor  
     * to get the ActiveShardCount.  
            this::internalAdd,  
     * Adds an {@link UpdateRequest} to the list of actions to execute.
    }
     * @param globalRouting the global default setting
        @Nullable String defaultPipeline,  
    public String pipeline() {
    public List<DocWriteRequest<?>> requests() {
        return globalRequireAlias;
     * Adds a list of requests to be executed. Either index or delete requests.
    private void applyGlobalMandatoryParameters(DocWriteRequest<?> request) {
        requests.add(request);
        return this;
     */
    /**
        return this;
    private String globalIndex;
     * Adds a framed data in binary format
        BytesReference data,
        }  
    public BulkRequest waitForActiveShards(ActiveShardCount waitForActiveShards) {
    public final BulkRequest timeout(String timeout) {  
    public BulkRequest add(
/*  
 *
 * ownership. Elasticsearch licenses this file to you under  
    @Override
     */
    /**
     */
     * Note for internal callers (NOT high level rest client),  
    public ActiveShardCount waitForActiveShards() {  
    /**  
    }
        return add(data, from, length, null, mediaType);  
     */  
     * - {@link BulkRequest#add(DocWriteRequest[])} )}  
            add((UpdateRequest) request);
     * the one with the least casts.  
    protected TimeValue timeout = BulkShardRequest.DEFAULT_TIMEOUT;
        this.timeout = timeout;
            }  
        requests.add(request);
    public BulkRequest() {}  
    }
        }  
    }
 * compatible open source license.
                }
    }
            requireAlias,
     * @return Bulk request with global setting set  
    }  
    }
        super.writeTo(out);
        if (Strings.isNullOrEmpty(value) && Strings.isNullOrEmpty(globalDefault) == false) {
/*  
            out.writeInt(Integer.MAX_VALUE); // formerly batch_size
        );
            add(request);  
     * Sets the number of shard copies that must be active before proceeding with the write.
        return this;
    public ActionRequestValidationException validate() {
     * @param request Request to add
        }
    }
import java.util.ArrayList;  
     *                            in the high level rest client.
     * <p>
        indices.add(request.index());
    }  
     *                            Global parameters would be respected if the request was serialized for a REST call as it is  
     * The estimated size in bytes of the bulk request.
        return globalPipeline;  
        super(in);  
        refreshPolicy.writeTo(out);
     * - {@link BulkRequest#add(IndexRequest)}  
    public BulkRequest add(Iterable<DocWriteRequest<?>> requests) {
    public BulkRequest add(UpdateRequest request) {  
    public BulkRequest add(DeleteRequest request) {
        this.globalIndex = globalIndex;  
    public long ramBytesUsed() {  
     * Note for internal callers (NOT high level rest client),  
        applyGlobalMandatoryParameters(request);  
    }  
    }
        return this;  
        }
        refreshPolicy = RefreshPolicy.readFrom(in);  
        return add(new BytesArray(data, from, length), defaultIndex, mediaType);
        sizeInBytes += (request.source() != null ? request.source().length() : 0) + REQUEST_OVERHEAD;
 */
        applyGlobalMandatoryParameters(request);  
     * Requests that are part of this request. It is only possible to add things that are both {@link ActionRequest}s and
    /**  
                    "RefreshPolicy is not supported on an item request. Set it on the BulkRequest instead.",
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.
 * and allows to executes it in a single batch.
 */  
 * not use this file except in compliance with the License.
     */
     */
        } else if (request instanceof DeleteRequest) {
            throw new IllegalArgumentException("No support for request [" + request + "]");
    private static final long SHALLOW_SIZE = RamUsageEstimator.shallowSizeOfInstance(BulkRequest.class);  
     * The number of actions in the bulk request.
        Objects.requireNonNull(request, "'request' must not be null");
        @Nullable String defaultRouting,
