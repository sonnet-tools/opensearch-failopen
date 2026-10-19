                executableScript.execute();
        } else {
 * Unless required by applicable law or agreed to in writing,
            true,
public class UpdateHelper {
            indexRequest.version(request.version()).versionType(request.versionType());
                BytesStreamOutput streamOutput = new BytesStreamOutput(initialCapacity);
            sourceFilteredAsBytes,
import org.opensearch.index.shard.IndexShard;
                        request.index(),
            // no source, we can't do anything, throw a failure...
        final IndexRequest currentRequest = request.doc();
        if (detectNoop && noop) {
        final Tuple<XContentType, Map<String, Object>> sourceAndContent = XContentHelper.convertToMap(getResult.internalSourceRef(), true);
                request.script,
            MediaType updateSourceContentType
 * ownership. Elasticsearch licenses this file to you under
        if (request.fetchSource().includes().length > 0 || request.fetchSource().excludes().length > 0) {
    private final ScriptService scriptService;
        } else {
            this.updatedSourceAsMap = updatedSourceAsMap;
            } catch (IOException e) {
    /**
     * Execute a scripted upsert, where there is an existing upsert document and a script to be executed. The script is executed and a new
            switch (upsertResult.v1()) {
            concreteIndex,
        BytesReference sourceFilteredAsBytes = sourceAsBytes;
 * this file be licensed under the Apache-2.0 license or a
            if (scriptService != null) {
                        getResult.getId(),
                    request.index(),
    }
                final IndexRequest indexRequest = Requests.indexRequest(request.index())
     */
import org.opensearch.core.common.io.stream.Writeable;
        ctx.put(ContextFields.ROUTING, routing);
                getResult.getSeqNo(),
                    extractGetResult(
        @Override
        ctx = executeScript(script, ctx);
        ctx.put(ContextFields.ID, getResult.getId());
                getResult.getVersion(),
                        getResult.getVersion(),
            return new Result(finalIndexRequest, DocWriteResponse.Result.UPDATED, updatedSourceAsMap, updateSourceContentType);
            // Only valid options for an upsert script are "create" (the default) or "none", meaning abort upsert
        ctx.put(ContextFields.SOURCE, sourceAsMap);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    updatedSourceAsMap,
            throw new DocumentSourceMissingException(shardId, request.id());
                DeleteRequest deleteRequest = Requests.deleteRequest(request.index())
        ctx.put(ContextFields.OP, UpdateOpType.INDEX.toString()); // The default operation is "index"
        } else if (getResult.getFields().containsKey(RoutingFieldMapper.NAME)) {
                    builder.value(value);
            Collections.emptyMap(),
        }
import org.opensearch.action.index.IndexRequest;
                .routing(routing)
        public static final String SOURCE = "_source";
            Object value = sourceLookup.filter(request.fetchSource());
            seqNo,
        final UpdateRequest request,
            case INDEX:
    public static class Result {
                        request,
                .source(updatedSourceAsMap, updateSourceContentType)
import org.opensearch.script.UpdateScript;
            return getResult.field(RoutingFieldMapper.NAME).getValue().toString();
                    update.setGetResult(getResult);
                case "none":
                    .setIfPrimaryTerm(getResult.getPrimaryTerm())
        String concreteIndex,
        ctx.put(ContextFields.VERSION, getResult.getVersion());
        final GetResult getResult = indexShard.getService().getForUpdate(request.id(), request.ifSeqNo(), request.ifPrimaryTerm());
        final String routing = calculateRouting(getResult, currentRequest);
        return ctx;
        public static final String NOW = "_now";
        public DocWriteResponse.Result getResponseResult() {
                .setIfPrimaryTerm(getResult.getPrimaryTerm())
            );
        IndexRequest indexRequest = request.docAsUpsert() ? request.doc() : request.upsertRequest();
            Writeable action,
        Map<String, Object> ctx = new HashMap<>(3);
     * primary and replicas.
            try {
            .setRefreshPolicy(request.getRefreshPolicy())
        public <T extends Writeable> T action() {
                UpdateScript.Factory factory = scriptService.compile(script, UpdateScript.CONTEXT);
    protected Result prepare(ShardId shardId, UpdateRequest request, final GetResult getResult, LongSupplier nowInMillis) {
 */
        }
                    UpdateResponse update = new UpdateResponse(
import java.util.HashMap;
        }
    /**
import org.opensearch.common.xcontent.XContentType;
        if (request.scriptedUpsert() && request.script() != null) {
     * Prepare the request for updating an existing document using a script. Executes the script and returns a {@code Result} containing
        final Map<String, Object> source,
        ctx.put(ContextFields.NOW, nowInMillis.getAsLong());
import org.opensearch.index.VersionType;
        }
        MediaType sourceContentType,
                .timeout(request.timeout())
            // in all but the internal versioning mode, we want to create the new document using the given version.
        return new Tuple<>(operation, newSource);
    }
                getResult.getPrimaryTerm(),
        indexRequest.index(request.index())
    }
    }
            return updateSourceContentType;
        final Map<String, Object> updatedSourceAsMap = sourceAndContent.v2();
     * Calculate a routing value to be used, either the included index request's routing, or retrieved document's routing when defined.
 *
     * variable inside of scripts.
    Tuple<UpdateOpType, Map<String, Object>> executeScriptedUpsert(Map<String, Object> upsertDoc, Script script, LongSupplier nowInMillis) {
                    getResult.getId(),
        // TODO when using delete/none, we can still return the source as bytes by generating it (using the sourceContentType)
                    getResult.getSeqNo(),
import org.opensearch.core.xcontent.MediaTypeRegistry;
    private static final Logger logger = LogManager.getLogger(UpdateHelper.class);
     * @opensearch.internal
                        DocWriteResponse.Result.NOOP
 * under the License.
                    .waitForActiveShards(request.waitForActiveShards())
    private Map<String, Object> executeScript(Script script, Map<String, Object> ctx) {
 * this work for additional information regarding copyright
    Result prepareUpsert(ShardId shardId, UpdateRequest request, final GetResult getResult, LongSupplier nowInMillis) {
     * Field names used to populate the script context
        }
            // The request has a script (or empty script), execute the script and prepare a new index request
    }
                )
            primaryTerm,
        ctx.put(ContextFields.SOURCE, upsertDoc);
                extractGetResult(
                        getResult.internalSourceRef()
    public static class ContextFields {
    }
        public Map<String, Object> updatedSourceAsMap() {
    enum UpdateOpType {
 * You may obtain a copy of the License at
                    getResult.getPrimaryTerm(),
                logger.warn("Invalid upsert operation [{}] for given script", operation);
import org.opensearch.index.engine.DocumentMissingException;
/*
        private final Writeable action;
                    .setRefreshPolicy(request.getRefreshPolicy());
     */
        NONE("none");
     * Prepare the request for upsert, executing the upsert script if present, and returning a {@code Result} containing a new
                    .source(updatedSourceAsMap, updateSourceContentType)
        final Tuple<XContentType, Map<String, Object>> sourceAndContent = XContentHelper.convertToMap(getResult.internalSourceRef(), true);
        Map<String, Object> ctx = new HashMap<>(16);
        } catch (Exception e) {
            return name;
        private final MediaType updateSourceContentType;
 * license agreements. See the NOTICE file distributed with
import org.apache.logging.log4j.Logger;
                    updateSourceContentType,
                    getResult.getSeqNo(),
        private final String name;
import org.opensearch.common.Nullable;
            case DELETE:
            this.updateSourceContentType = updateSourceContentType;
        } else if (getResult.internalSourceRef() == null) {
     */
                    .routing(routing)
    static String calculateRouting(GetResult getResult, @Nullable IndexRequest updateIndexRequest) {
        if (operation != UpdateOpType.CREATE && operation != UpdateOpType.NONE) {
            .timeout(request.timeout())
import org.opensearch.script.Script;
            // it has to be a "create!"
     */
     * @opensearch.internal
                    getResult.internalSourceRef()
        public Result(
    Result prepareUpdateIndexRequest(ShardId shardId, UpdateRequest request, GetResult getResult, boolean detectNoop) {
                    getResult.getVersion(),
     * containing a new {@code IndexRequest} to be executed on the primary and replicas.
     * Prepare the request for merging the existing document with a new one, can optionally detect a noop change. Returns a {@code Result}
                .setIfSeqNo(getResult.getSeqNo())
            request.id(),
        private final Map<String, Object> updatedSourceAsMap;
 * compatible open source license.
                upsert.sourceAsMap(),
                        getResult.getSeqNo(),
import org.opensearch.script.ScriptType;
            return new Result(update, DocWriteResponse.Result.NOOP, updatedSourceAsMap, updateSourceContentType);
            DocWriteResponse.Result result,
    /**
        // where users repopulating multi-fields or adding synonyms, etc.
 *     http://www.apache.org/licenses/LICENSE-2.0
                        getResult.getPrimaryTerm(),
        DELETE("delete"),
import java.util.Map;
     */
            final IndexRequest finalIndexRequest = Requests.indexRequest(request.index())
        return prepare(indexShard.shardId(), request, getResult, nowInMillis);
     * Prepares an update request by converting it into an index or delete request or an update response (no action).
        INDEX("index"),
                throw new OpenSearchException("Error filtering source", e);
            return prepareUpdateIndexRequest(shardId, request, getResult, request.detectNoop());
                default:
    }
                return new Result(update, DocWriteResponse.Result.NOOP, updatedSourceAsMap, updateSourceContentType);
                getResult.getId(),
    /**
                    .setIfSeqNo(getResult.getSeqNo())
import org.apache.logging.log4j.LogManager;
            .create(true);
            return (T) action;
    }
import java.io.IOException;
        final XContentType updateSourceContentType = sourceAndContent.v1();
        }
     */
 *
                    .timeout(request.timeout())
    }
        }
    @Nullable
import org.opensearch.common.xcontent.XContentHelper;
    ) {
        public static final String OP = "op";
                    // TODO: can we remove this leniency yet??
    public Result prepare(UpdateRequest request, IndexShard indexShard, LongSupplier nowInMillis) {
        final XContentType updateSourceContentType = sourceAndContent.v1();
 * Licensed to Elasticsearch under one or more contributor
            return null;
        // Tell the script that this is a create and not an update
            UpdateResponse update = new UpdateResponse(
            throw new DocumentMissingException(shardId, request.id());
import org.opensearch.index.engine.DocumentSourceMissingException;
     */
            // Run the script to perform the create logic
            return prepareUpsert(shardId, request, getResult, nowInMillis);
            this.name = name;
        if (getResult.isExists() == false) {
            default:
                case NONE:
                    getResult.getVersion(),
    public UpdateHelper(ScriptService scriptService) {
            .id(request.id())
 * @opensearch.internal
        final Map<String, Object> sourceAsMap = sourceAndContent.v2();
        ) {
                case "create":
        return new GetResult(
import java.util.function.LongSupplier;
                .waitForActiveShards(request.waitForActiveShards())
            switch (operation) {
        public String toString() {
            Collections.emptyMap()
 *
import org.opensearch.common.io.stream.BytesStreamOutput;
                    .waitForActiveShards(request.waitForActiveShards())
            }
        @SuppressWarnings("unchecked")
        CREATE("create"),
            return updateIndexRequest.routing();
            }
                return new Result(indexRequest, DocWriteResponse.Result.UPDATED, updatedSourceAsMap, updateSourceContentType);
        );
                        updateSourceContentType,
        }
        }
        // We can only actually turn the update into a noop if detectNoop is true to preserve backwards compatibility and to handle cases
     */
                    return UpdateOpType.CREATE;
        UpdateOpType operation = UpdateOpType.lenientFromString((String) ctx.get(ContextFields.OP), logger, request.script.getIdOrCode());
                .extraFieldValues(currentRequest.extraFieldValues())
        this.scriptService = scriptService;
                case "index":
                .id(request.id())
                    );
        } else if (request.script() == null && request.doc() != null) {
        long version,
        public static final String VERSION = "_version";
        try {
    }
                UpdateScript executableScript = factory.newInstance(script.getParams(), ctx);
            );
        if (updateIndexRequest != null && updateIndexRequest.routing() != null) {
                return new Result(deleteRequest, DocWriteResponse.Result.DELETED, updatedSourceAsMap, updateSourceContentType);
        final IndexRequest currentRequest = request.doc();
        }
     * {@code IndexRequest} to be executed on the primary and replicas.
 * Helper for translating an update request to an index, delete request or update response.
 * KIND, either express or implied.  See the License for the
import org.opensearch.script.ScriptService;
                    request,
                    indexRequest = Requests.indexRequest(request.index()).source(upsertResult.v2());
                    return UpdateOpType.DELETE;
    }
                nowInMillis
        @SuppressWarnings("unchecked")
            return null;
        }
    }
                    break;
package org.opensearch.action.update;
        public static final String INDEX = "_index";
            sourceLookup.setSource(source);
 */
            return updatedSourceAsMap;
     * either a new {@code IndexRequest} or {@code DeleteRequest} (depending on the script's returned "op" value) to be executed on the
import org.opensearch.core.xcontent.MediaType;
        } else {
                );
                    )
        }
        }
 * software distributed under the License is distributed on an
    /**
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.transport.client.Requests;
        public static final String ROUTING = "_routing";
                }
                    DocWriteResponse.Result.NOOP
                    .id(request.id())
import org.opensearch.core.xcontent.XContentBuilder;
                    .setIfPrimaryTerm(getResult.getPrimaryTerm())
import java.util.Collections;
 * not use this file except in compliance with the License.
            } else {
        }
 */
        public static final String ID = "_id";
            return prepareUpdateScriptRequest(shardId, request, getResult, nowInMillis);
 * GitHub history for details.
     */
            .routing(request.routing())
            }
                    .setRefreshPolicy(request.getRefreshPolicy());
                        getResult.getPrimaryTerm(),
            }
    /**
/*
                    return new Result(update, DocWriteResponse.Result.NOOP, upsertResult.v2(), MediaTypeRegistry.JSON);
                    // It's fine to throw an exception here, the leniency is handled/logged by `executeScriptedUpsert`
                    .setIfSeqNo(getResult.getSeqNo())
            );
    /**
        final String routing = calculateRouting(getResult, currentRequest);
                );
                    .routing(routing)
            operation = UpdateOpType.NONE;
            if (logger.isDebugEnabled() || ScriptType.STORED.equals(script.getType())) {
                DocWriteResponse.Result.NOOP
    }
        }
        UpdateOpType operation = UpdateOpType.lenientFromString((String) ctx.get(ContextFields.OP), logger, script.getIdOrCode());
/*
        ctx.put(ContextFields.OP, UpdateOpType.CREATE.toString());
            // If the document didn't exist, execute the update request as an upsert
                    return UpdateOpType.NONE;
 */
 * SPDX-License-Identifier: Apache-2.0
     * Internal result
                        getResult.getVersion(),
        @SuppressWarnings("unchecked")
        final boolean noop = !XContentHelper.update(updatedSourceAsMap, currentRequest.sourceAsMap(), detectNoop);
 *
            SourceLookup sourceLookup = new SourceLookup();
        final Map<String, Object> updatedSourceAsMap = (Map<String, Object>) ctx.get(ContextFields.SOURCE);
    Result prepareUpdateScriptRequest(ShardId shardId, UpdateRequest request, GetResult getResult, LongSupplier nowInMillis) {
import org.opensearch.core.index.shard.ShardId;
        UpdateOpType(String name) {
                logger.warn("Invalid upsert operation [{}] for script [{}], doing nothing...", operation, script.getIdOrCode());
     * Prepares an update request by converting it into an index or delete request or an update response (no action, in the event of a
import org.opensearch.OpenSearchException;
                    shardId,
    /**
    /**
import org.opensearch.action.DocWriteResponse;
    public static GetResult extractGetResult(
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.search.lookup.SourceLookup;
        }
            this.action = action;
                shardId,
import org.opensearch.index.mapper.RoutingFieldMapper;
        @Nullable final BytesReference sourceAsBytes
        Map<String, Object> newSource = (Map<String, Object>) ctx.get(ContextFields.SOURCE);
            Map<String, Object> updatedSourceAsMap,
                // If it was neither an INDEX or DELETE operation, treat it as a noop
                .setRefreshPolicy(request.getRefreshPolicy());
        if (request.upsertRequest() == null && !request.docAsUpsert()) {
 * The OpenSearch Contributors require contributions made to
        ctx = executeScript(request.script, ctx);
                default:
     * Applies {@link UpdateRequest#fetchSource()} to the _source of the updated document to be returned in a update response.
            version,
        switch (operation) {
}
                    getResult.getPrimaryTerm(),
            IndexRequest upsert = request.upsertRequest();
                final int initialCapacity = Math.min(1024, sourceAsBytes.length());
                    logger.warn("Used upsert operation [{}] for script [{}], doing nothing...", operation, scriptId);
            return result;
            update.setGetResult(
                    sourceFilteredAsBytes = BytesReference.bytes(builder);
        }
        return new Result(indexRequest, DocWriteResponse.Result.CREATED, null, null);
                    return UpdateOpType.NONE;
                        shardId,
        public MediaType updateSourceContentType() {
/**
                UpdateResponse update = new UpdateResponse(
                        updatedSourceAsMap,
        }
 * specific language governing permissions and limitations
import org.opensearch.index.get.GetResult;
     * After executing the script, this is the type of operation that will be used for subsequent actions. This corresponds to the "ctx.op"
import org.opensearch.action.delete.DeleteRequest;
        public static final String CTX = "ctx";
        if (request.versionType() != VersionType.INTERNAL) {
                    .id(request.id())
                        getResult.getSeqNo(),
                update.setGetResult(
     *
                    throw new IllegalArgumentException("unknown upsert operation, got: " + upsertResult.v1());
        long seqNo,
     */
        public static UpdateOpType lenientFromString(String operation, Logger logger, String scriptId) {
            this.result = result;
        if (request.fetchSource() == null || request.fetchSource().fetchSource() == false) {
    /**
                try (XContentBuilder builder = new XContentBuilder(sourceContentType.xContent(), streamOutput)) {
 * the Apache License, Version 2.0 (the "License"); you may
     * Tuple of operation and updated {@code _source} is returned.
            // The request has no script, it is a new doc that should be merged with the old document
     *
    /**
     * noop).
        long primaryTerm,
        private final DocWriteResponse.Result result;
        ctx.put(ContextFields.INDEX, getResult.getIndex());
     */
                case CREATE:
import org.opensearch.common.collect.Tuple;
                    return UpdateOpType.INDEX;
            Tuple<UpdateOpType, Map<String, Object>> upsertResult = executeScriptedUpsert(
            }
        ctx.put(ContextFields.NOW, nowInMillis.getAsLong());
                    .timeout(request.timeout())
            .waitForActiveShards(request.waitForActiveShards())
            throw new IllegalArgumentException("failed to execute script", e);
                case "delete":
