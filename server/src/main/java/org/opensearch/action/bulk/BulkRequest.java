        }
import org.opensearch.action.support.WriteRequest;
        return internalAdd(request);
            return globalDefault;
     */
    public final BulkRequest timeout(TimeValue timeout) {
    public BulkRequest add(IndexRequest request) {
     */
 * not use this file except in compliance with the License.
    final List<DocWriteRequest<?>> requests = new ArrayList<>();
package org.opensearch.action.bulk;
     * @param globalRouting the global default setting
    }
    /**
        return add(new BytesArray(data, from, length), defaultIndex, mediaType);
            defaultIndex,
            defaultFetchSourceContext,
    /**
     * @return the current bulk request
     * Requests that are part of this request. It is only possible to add things that are both {@link ActionRequest}s and
            allowExplicitIndex,
import org.opensearch.action.CompositeIndicesRequest;
    }
    }
        ActionRequestValidationException validationException = null;
     */
    public BulkRequest add(
 */
    }
        if (request.doc() != null) {
 * and allows to executes it in a single batch.
 * Note that we only support refresh on the bulk request not per item.
        if (request.script() != null) {
     * {@link WriteRequest}s to this but java doesn't support syntax to declare that everything in the array has both types so we declare
/**
    public ActiveShardCount waitForActiveShards() {
     * to get the ActiveShardCount.
            if (((WriteRequest<?>) request).getRefreshPolicy() != RefreshPolicy.NONE) {
import org.opensearch.core.common.Strings;
    public BulkRequest waitForActiveShards(final int waitForActiveShards) {
     *                            in the high level rest client.
        return validationException;
     *                            Global parameters would be respected if the request was serialized for a REST call as it is
        Boolean requireAlias = valueOrDefault(defaultRequireAlias, globalRequireAlias);
    /**
    }
        requests.stream().map(DocWriteRequest::index).forEach(indices::add);
    public long estimatedSizeInBytes() {
        timeout = in.readTimeValue();
     * - {@link BulkRequest#add(IndexRequest)}
      - {@link BulkRequest#add(IndexRequest)}
import org.opensearch.action.delete.DeleteRequest;
        @Nullable String defaultRouting,
        } else if (request instanceof DeleteRequest) {
    private static final int REQUEST_OVERHEAD = 50;
        if (in.getVersion().onOrAfter(Version.V_2_14_0) && in.getVersion().before(Version.V_3_0_0)) {
        }
    }
        return this;
        waitForActiveShards.writeTo(out);
            ActionRequestValidationException ex = ((WriteRequest<?>) request).validate();
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.
        boolean allowExplicitIndex,
     * - {@link BulkRequest#add(DocWriteRequest)}
    }
            sizeInBytes += request.upsertRequest().source().length();
        Objects.requireNonNull(request, "'request' must not be null");
import java.util.HashSet;
            add((UpdateRequest) request);
            requireAlias,
        return refreshPolicy;
import org.opensearch.action.update.UpdateRequest;
        this.timeout = timeout;
     */
    public final BulkRequest routing(String globalRouting) {
     * @param globalRequireAlias the global default setting
import org.opensearch.action.support.replication.ReplicationRequest;
 * You may obtain a copy of the License at
    private String globalIndex;
    }
     * The estimated size in bytes of the bulk request.
 * Licensed to Elasticsearch under one or more contributor
            in.readInt(); // formerly batch_size
import org.opensearch.core.common.bytes.BytesReference;
import static org.opensearch.action.ValidateActions.addValidationError;
     */
    public BulkRequest(StreamInput in) throws IOException {
        return add(data, defaultIndex, null, null, null, null, allowExplicitIndex, mediaType);
    public String pipeline() {
 * this file be licensed under the Apache-2.0 license or a
     * the global parameter setting is ignored when used with:
    }
        } else if (request instanceof UpdateRequest) {
     */
        this.globalRouting = globalRouting;
        return sizeInBytes;
        applyGlobalMandatoryParameters(request);
     * Adds a list of requests to be executed. Either index or delete requests.
 *
     */
     * - {@link BulkRequest#add(DocWriteRequest[])} )}
     * Note for internal callers (NOT high level rest client),
    @Override
        return this;
 * @opensearch.api
     */
            if (ex != null) {
        if (requests.isEmpty()) {
        BytesReference data,
    }
                validationException = addValidationError(
    }
        this.refreshPolicy = refreshPolicy;
    @Override
import org.opensearch.core.common.bytes.BytesArray;
        refreshPolicy = RefreshPolicy.readFrom(in);
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
    }
        BytesReference data,
        return Collections.unmodifiableSet(indices);
        return this;
    protected TimeValue timeout = BulkShardRequest.DEFAULT_TIMEOUT;
     * - {@link BulkRequest#add(IndexRequest)}
     * Adds a framed data in binary format
     * the global parameter setting is ignored when used with:
     * Adds an {@link DeleteRequest} to the list of actions to execute.
 * this work for additional information regarding copyright
        boolean allowExplicitIndex,
        return value;
    /**
        return timeout(TimeValue.parseTimeValue(timeout, null, getClass().getSimpleName() + ".timeout"));
        requests.addAll(in.readList(i -> DocWriteRequest.readDocumentRequest(null, i)));
 * <p>
    public BulkRequest add(BytesReference data, @Nullable String defaultIndex, boolean allowExplicitIndex, MediaType mediaType)
     * Adds a framed data in binary format
    @Override
        return requests.size();
     * the global parameter setting is ignored when used with:
     */
     */
    }
    public RefreshPolicy getRefreshPolicy() {
import org.opensearch.transport.client.Client;
    /**
     * @param globalPipeline the global default setting
            add(request);
        return this;
    /**
    public final BulkRequest timeout(String timeout) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Note for internal callers: This method does not respect all global parameters.
    }
     * Adds an {@link UpdateRequest} to the list of actions to execute.
                    validationException = new ActionRequestValidationException();
        this.globalRequireAlias = globalRequireAlias;
     */
        return this;
     */
    }
        return add(data, from, length, null, mediaType);
 * KIND, either express or implied.  See the License for the
        requests.add(request);
    public BulkRequest add(Iterable<DocWriteRequest<?>> requests) {
    public String getDescription() {
      - {@link BulkRequest#add(UpdateRequest)}
     */
      - {@link BulkRequest#add(DocWriteRequest)}
    /**
    }
 * specific language governing permissions and limitations
    }
        indices.add(request.index());
    public List<DocWriteRequest<?>> requests() {
        this.globalIndex = globalIndex;
    private RefreshPolicy refreshPolicy = RefreshPolicy.NONE;
        return "requests[" + requests.size() + "], indices[" + Strings.collectionToDelimitedString(indices, ", ") + "]";
            out.writeInt(Integer.MAX_VALUE); // formerly batch_size
    @Override
      - {@link BulkRequest#add(DocWriteRequest[])} )}
        request.index(valueOrDefault(request.index(), globalIndex));
     * <p>
     */
import org.opensearch.search.fetch.subphase.FetchSourceContext;
     *                            Only the global index is applied to the request objects.
    public BulkRequest add(byte[] data, int from, int length, MediaType mediaType) throws IOException {
        return this;
            pipeline,
    /**
    private String globalRouting;
        @Nullable String defaultIndex,
import org.opensearch.common.unit.TimeValue;
        waitForActiveShards = ActiveShardCount.readFrom(in);
    private long sizeInBytes = 0;
                validationException.addValidationErrors(ex.validationErrors());
    }
        }
            mediaType,
    }
    public Boolean requireAlias() {
        }
        return value;
     */
     */
import java.io.IOException;
        // lack of source is validated in validate() method
 * ownership. Elasticsearch licenses this file to you under
    /**
    /**
    public BulkRequest add(
    }
     * See {@link ReplicationRequest#waitForActiveShards(ActiveShardCount)} for details.
     * - {@link BulkRequest#add(Iterable)}
    }
 * compatible open source license.
            }
    public BulkRequest setRefreshPolicy(RefreshPolicy refreshPolicy) {
 * @see Client#bulk(BulkRequest)
            routing,
    }
        return add(data, defaultIndex, defaultRouting, defaultFetchSourceContext, defaultPipeline, null, allowExplicitIndex, mediaType);
        if (out.getVersion().onOrAfter(Version.V_2_14_0) && out.getVersion().before(Version.V_3_0_0)) {
        super(in);
    }
    private String globalPipeline;
     * Note for internal callers (NOT high level rest client),
     * @return Bulk request with global setting set
     * - {@link BulkRequest#add(UpdateRequest)}
        String routing = valueOrDefault(defaultRouting, globalRouting);
import org.opensearch.common.annotation.PublicApi;
        @Nullable String defaultRouting,
    /**
        }
    private Boolean globalRequireAlias;
        }
import org.opensearch.action.index.IndexRequest;
    public TimeValue timeout() {
 *
        }
     * Note for internal callers (NOT high level rest client),
        this.waitForActiveShards = waitForActiveShards;
        );
        return this;
import org.opensearch.core.common.io.stream.StreamInput;
        MediaType mediaType
    ) throws IOException {
        this.globalPipeline = globalPipeline;
 * A bulk request holds an ordered {@link IndexRequest}s, {@link DeleteRequest}s and {@link UpdateRequest}s
        }
        String pipeline = valueOrDefault(defaultPipeline, globalPipeline);
        }
     * @return Bulk request with global setting set
    public BulkRequest add(DocWriteRequest<?>... requests) {
    public String routing() {
    @Override
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
 */
    }
    }
import java.util.List;
     * A shortcut for {@link #waitForActiveShards(ActiveShardCount)} where the numerical
        return internalAdd(request);
                );
    }
    /**
/*
    public BulkRequest waitForActiveShards(ActiveShardCount waitForActiveShards) {
        return globalRouting;
        }
 */
     * Adds an {@link IndexRequest} to the list of actions to execute. Follows the same behavior of {@link IndexRequest}
import org.opensearch.action.support.ActiveShardCount;
        indices.add(request.index());
 */
                    validationException
     * - {@link BulkRequest#add(DocWriteRequest[])} )}
 *
 * GitHub history for details.
    }
 * Unless required by applicable law or agreed to in writing,
    }
import org.apache.lucene.util.RamUsageEstimator;
    /**
@PublicApi(since = "1.0.0")
import org.opensearch.action.DocWriteRequest;
                    "RefreshPolicy is not supported on an item request. Set it on the BulkRequest instead.",
    }
            sizeInBytes += request.doc().source().length();
     * <p>
        @Nullable FetchSourceContext defaultFetchSourceContext,
     * The list of requests in this bulk request.
 * SPDX-License-Identifier: Apache-2.0
        @Nullable Boolean defaultRequireAlias,
    public final BulkRequest pipeline(String globalPipeline) {
    public Set<String> getIndices() {
        if (request.upsertRequest() != null) {
        throws IOException {
        MediaType mediaType
    /**
        @Nullable String defaultPipeline,
    public ActionRequestValidationException validate() {
/*
    }
    private final Set<String> indices = new HashSet<>();
            this::add
    public long ramBytesUsed() {
        super.writeTo(out);
        sizeInBytes += (request.source() != null ? request.source().length() : 0) + REQUEST_OVERHEAD;
    }
            return globalDefault;
        return globalRequireAlias;
     * @param request Request to add
        @Nullable FetchSourceContext defaultFetchSourceContext,
    private static final long SHALLOW_SIZE = RamUsageEstimator.shallowSizeOfInstance(BulkRequest.class);
    }
import java.util.ArrayList;
     * Adds a list of requests to be executed. Either index or delete requests.
import java.util.Set;
        for (DocWriteRequest<?> request : requests) {
    public BulkRequest add(DocWriteRequest<?> request) {
    }
        return timeout;
    /**
      - {@link BulkRequest#add(Iterable)}
    public BulkRequest add(byte[] data, int from, int length, @Nullable String defaultIndex, MediaType mediaType) throws IOException {
        return waitForActiveShards(ActiveShardCount.from(waitForActiveShards));
public class BulkRequest extends ActionRequest implements CompositeIndicesRequest, WriteRequest<BulkRequest>, Accountable {
            add(request);
        return this;
import org.opensearch.core.xcontent.MediaType;
    }
    }
    public BulkRequest() {}
    BulkRequest internalAdd(UpdateRequest request) {
            add((IndexRequest) request);
                }
 * under the License.
     * - {@link BulkRequest#add(DocWriteRequest)}
        new BulkRequestParser().parse(
     * Sets the number of shard copies that must be active before proceeding with the write.
        return this.requests;
        applyGlobalMandatoryParameters(request);
     * Adds a framed data in binary format
    private void applyGlobalMandatoryParameters(DocWriteRequest<?> request) {
        out.writeCollection(requests, DocWriteRequest::writeDocumentRequest);
    public BulkRequest add(DeleteRequest request) {
        if (request instanceof IndexRequest) {
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.
            this::internalAdd,
        return this;
    /**
    public void writeTo(StreamOutput out) throws IOException {
        return this;
import org.opensearch.action.ActionRequestValidationException;
        indices.add(request.index());
    }
     * - {@link BulkRequest#add(UpdateRequest)}
    public BulkRequest(@Nullable String globalIndex) {
    }
     * - {@link BulkRequest#add(Iterable)}
        }
    }
        indices.add(request.index());
    public BulkRequest add(UpdateRequest request) {
        if (Objects.isNull(value) && !Objects.isNull(globalDefault)) {
        applyGlobalMandatoryParameters(request);
            // We first check if refresh has been set
        return globalPipeline;
        Objects.requireNonNull(request, "'request' must not be null");
        return this;
     * the one with the least casts.
    private static String valueOrDefault(String value, String globalDefault) {
import org.apache.lucene.util.Accountable;
     */
        @Nullable String defaultPipeline,
        refreshPolicy.writeTo(out);
import org.opensearch.common.Nullable;
    }
     */
        requests.add(request);
import java.util.Collections;
        sizeInBytes += REQUEST_OVERHEAD;
        return this;
     */
     * The number of actions in the bulk request.
        return this;
 * license agreements. See the NOTICE file distributed with
    private ActiveShardCount waitForActiveShards = ActiveShardCount.DEFAULT;
    /**
            add((DeleteRequest) request);
    BulkRequest internalAdd(IndexRequest request) {
        requests.add(request);
            throw new IllegalArgumentException("No support for request [" + request + "]");
        for (DocWriteRequest<?> request : requests) {
    @Override
    public BulkRequest add(BytesReference data, @Nullable String defaultIndex, MediaType mediaType) throws IOException {
     * <p>
        Objects.requireNonNull(request, "'request' must not be null");
 * The OpenSearch Contributors require contributions made to
        return SHALLOW_SIZE + requests.stream().mapToLong(Accountable::ramBytesUsed).sum();
            sizeInBytes += request.script().getIdOrCode().length() * 2;
 *
                if (validationException == null) {
    private static Boolean valueOrDefault(Boolean value, Boolean globalDefault) {
            data,
    public int numberOfActions() {
        return this.waitForActiveShards;
     */
     * Add a request to the current BulkRequest.
        }
            this::internalAdd,
 * the Apache License, Version 2.0 (the "License"); you may
            validationException = addValidationError("no requests added", validationException);
 * software distributed under the License is distributed on an
/*
    /**
        for (DocWriteRequest<?> request : requests) {
        } else {
    }
     * (for example, if no id is provided, one will be generated, or usage of the create flag).
     * @return Bulk request with global setting set
import org.opensearch.Version;
    }
        out.writeTimeValue(timeout);
    /**
    public BulkRequest requireAlias(Boolean globalRequireAlias) {
    /**
        return add(data, defaultIndex, null, null, null, null, true, mediaType);
    ) throws IOException {
     */
     * Adds a framed data in binary format
 * Modifications Copyright OpenSearch Contributors. See
}
     * <p>
import java.util.Objects;
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (Strings.isNullOrEmpty(value) && Strings.isNullOrEmpty(globalDefault) == false) {
        @Nullable String defaultIndex,
import org.opensearch.action.ActionRequest;
            }
