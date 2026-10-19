                return new Result(update, DocWriteResponse.Result.NOOP, updatedSourceAsMap, updateSourceContentType);
 */
 * specific language governing permissions and limitations
    Result prepareUpdateIndexRequest(ShardId shardId, UpdateRequest request, GetResult getResult, boolean detectNoop) {
        @SuppressWarnings("unchecked")
                    .setRefreshPolicy(request.getRefreshPolicy());
import org.opensearch.core.common.bytes.BytesReference;  
                        shardId,  
                    .setIfSeqNo(getResult.getSeqNo())
            primaryTerm,
import org.opensearch.common.io.stream.BytesStreamOutput;  
        public static UpdateOpType lenientFromString(String operation, Logger logger, String scriptId) {
        @SuppressWarnings("unchecked")  
     * @opensearch.internal
        if (operation != UpdateOpType.CREATE && operation != UpdateOpType.NONE) {  
        final XContentType updateSourceContentType = sourceAndContent.v1();  
        // where users repopulating multi-fields or adding synonyms, etc.  
import org.opensearch.script.ScriptService;
     * either a new {@code IndexRequest} or {@code DeleteRequest} (depending on the script's returned "op" value) to be executed on the
        final UpdateRequest request,
 * compatible open source license.
import java.io.IOException;
        } catch (Exception e) {
            Collections.emptyMap(),
            // no source, we can't do anything, throw a failure...  
        this.scriptService = scriptService;
        public static final String OP = "op";
        public static final String NOW = "_now";
                        getResult.internalSourceRef()
            SourceLookup sourceLookup = new SourceLookup();
        private final Writeable action;
     * {@code IndexRequest} to be executed on the primary and replicas.  
            this.result = result;
                    )  
    }
import org.opensearch.index.get.GetResult;  
    }
        return prepare(indexShard.shardId(), request, getResult, nowInMillis);  
                getResult.getSeqNo(),
     */
        }
    enum UpdateOpType {
            .id(request.id())
                    getResult.getPrimaryTerm(),  
                        getResult.getId(),
     * Prepares an update request by converting it into an index or delete request or an update response (no action, in the event of a
            }
            indexRequest.version(request.version()).versionType(request.versionType());
                return new Result(deleteRequest, DocWriteResponse.Result.DELETED, updatedSourceAsMap, updateSourceContentType);  
        }
import org.opensearch.common.xcontent.XContentType;
     * Prepare the request for updating an existing document using a script. Executes the script and returns a {@code Result} containing  
                // If it was neither an INDEX or DELETE operation, treat it as a noop
                    return new Result(update, DocWriteResponse.Result.NOOP, upsertResult.v2(), MediaTypeRegistry.JSON);
        }
            );
                throw new OpenSearchException("Error filtering source", e);
            throw new DocumentSourceMissingException(shardId, request.id());
     */
                        request.index(),
            if (logger.isDebugEnabled() || ScriptType.STORED.equals(script.getType())) {
                )
            DocWriteResponse.Result result,  
                    return UpdateOpType.INDEX;
    }
        final Map<String, Object> sourceAsMap = sourceAndContent.v2();  
                    getResult.getSeqNo(),
            // Run the script to perform the create logic
 *     http://www.apache.org/licenses/LICENSE-2.0
        final Map<String, Object> updatedSourceAsMap = (Map<String, Object>) ctx.get(ContextFields.SOURCE);
        } else if (getResult.internalSourceRef() == null) {
import java.util.HashMap;  
    /**
            return updateIndexRequest.routing();
                .routing(routing)
        }
        final Map<String, Object> source,
        try {
                    throw new IllegalArgumentException("unknown upsert operation, got: " + upsertResult.v1());
                default:  
 *  
                    // TODO: can we remove this leniency yet??
     * containing a new {@code IndexRequest} to be executed on the primary and replicas.  
    }  
        Map<String, Object> newSource = (Map<String, Object>) ctx.get(ContextFields.SOURCE);
    }
    ) {
        DELETE("delete"),
                return new Result(indexRequest, DocWriteResponse.Result.UPDATED, updatedSourceAsMap, updateSourceContentType);
        if (getResult.isExists() == false) {
     * @opensearch.internal
        @Nullable final BytesReference sourceAsBytes  
            }  
                DocWriteResponse.Result.NOOP
                    .setIfPrimaryTerm(getResult.getPrimaryTerm())
                logger.warn("Invalid upsert operation [{}] for given script", operation);
        public Map<String, Object> updatedSourceAsMap() {
            default:
        }
            .timeout(request.timeout())
            return (T) action;  
                executableScript.execute();
                getResult.getId(),
                    getResult.getSeqNo(),  
                    .id(request.id())
                case "index":  
            return result;
                );
    private final ScriptService scriptService;
        ctx.put(ContextFields.VERSION, getResult.getVersion());  
                    getResult.getVersion(),
import org.opensearch.index.mapper.RoutingFieldMapper;
                    updateSourceContentType,  
        // We can only actually turn the update into a noop if detectNoop is true to preserve backwards compatibility and to handle cases
    /**
            IndexRequest upsert = request.upsertRequest();  
                    update.setGetResult(getResult);
    @Nullable
 * Helper for translating an update request to an index, delete request or update response.
import org.opensearch.transport.client.Requests;
        private final String name;
 *
import org.opensearch.core.index.shard.ShardId;
        private final Map<String, Object> updatedSourceAsMap;
        if (request.fetchSource().includes().length > 0 || request.fetchSource().excludes().length > 0) {
            return prepareUpdateIndexRequest(shardId, request, getResult, request.detectNoop());
     * Execute a scripted upsert, where there is an existing upsert document and a script to be executed. The script is executed and a new  
                    break;  
                getResult.getPrimaryTerm(),  
        public DocWriteResponse.Result getResponseResult() {  
     */
    private static final Logger logger = LogManager.getLogger(UpdateHelper.class);
        }
 * Unless required by applicable law or agreed to in writing,
                        getResult.getPrimaryTerm(),
                .setRefreshPolicy(request.getRefreshPolicy());  
        ctx.put(ContextFields.ID, getResult.getId());
        public static final String CTX = "ctx";
            this.updatedSourceAsMap = updatedSourceAsMap;  
        // TODO when using delete/none, we can still return the source as bytes by generating it (using the sourceContentType)
import org.opensearch.core.common.io.stream.Writeable;
        }
                    UpdateResponse update = new UpdateResponse(
     * Applies {@link UpdateRequest#fetchSource()} to the _source of the updated document to be returned in a update response.
                UpdateScript executableScript = factory.newInstance(script.getParams(), ctx);
        ctx.put(ContextFields.OP, UpdateOpType.INDEX.toString()); // The default operation is "index"  
        final Tuple<XContentType, Map<String, Object>> sourceAndContent = XContentHelper.convertToMap(getResult.internalSourceRef(), true);
                    request,  
        }  
        String concreteIndex,  
            this.name = name;
        }
        ctx = executeScript(request.script, ctx);
    public static GetResult extractGetResult(
 * under the License.  
     * Prepares an update request by converting it into an index or delete request or an update response (no action).
                    return UpdateOpType.NONE;  
        final boolean noop = !XContentHelper.update(updatedSourceAsMap, currentRequest.sourceAsMap(), detectNoop);  
     */
     */  
    /**
            case INDEX:
        }
                UpdateResponse update = new UpdateResponse(  
     */  
        } else if (request.script() == null && request.doc() != null) {
        public String toString() {
            // The request has a script (or empty script), execute the script and prepare a new index request  
            try {
import org.opensearch.script.UpdateScript;  
 * SPDX-License-Identifier: Apache-2.0
            );  
        ctx.put(ContextFields.NOW, nowInMillis.getAsLong());
                update.setGetResult(
                nowInMillis
import java.util.Collections;
    public static class ContextFields {  
import org.opensearch.action.delete.DeleteRequest;
import java.util.function.LongSupplier;
        public MediaType updateSourceContentType() {
     *  
import org.opensearch.common.xcontent.XContentHelper;
                    .routing(routing)
    public UpdateHelper(ScriptService scriptService) {  
    }
        final Tuple<XContentType, Map<String, Object>> sourceAndContent = XContentHelper.convertToMap(getResult.internalSourceRef(), true);
            // If the document didn't exist, execute the update request as an upsert  
                try (XContentBuilder builder = new XContentBuilder(sourceContentType.xContent(), streamOutput)) {
    }  
        indexRequest.index(request.index())  
        NONE("none");  
            .setRefreshPolicy(request.getRefreshPolicy())
 * Licensed to Elasticsearch under one or more contributor  
            .waitForActiveShards(request.waitForActiveShards())
            case DELETE:  
            request.id(),
        if (request.versionType() != VersionType.INTERNAL) {  
    /**
        final IndexRequest currentRequest = request.doc();  
        return ctx;
            }
    public Result prepare(UpdateRequest request, IndexShard indexShard, LongSupplier nowInMillis) {
        public static final String ROUTING = "_routing";
                    getResult.getPrimaryTerm(),
        if (request.scriptedUpsert() && request.script() != null) {
                    .setIfSeqNo(getResult.getSeqNo())  
     */
                .timeout(request.timeout())
        return new GetResult(  
                    builder.value(value);  
 * not use this file except in compliance with the License.
 * GitHub history for details.
import org.opensearch.action.DocWriteResponse;
            throw new IllegalArgumentException("failed to execute script", e);
        } else {
        @Override
        ctx.put(ContextFields.NOW, nowInMillis.getAsLong());  
    public static class Result {  
import org.apache.logging.log4j.Logger;
import java.util.Map;
import org.opensearch.index.engine.DocumentMissingException;
                        updatedSourceAsMap,  
     */
        }  
                case "none":
/**
     * noop).
                    getResult.internalSourceRef()
        ctx.put(ContextFields.SOURCE, upsertDoc);
            return prepareUpdateScriptRequest(shardId, request, getResult, nowInMillis);
     * Field names used to populate the script context
                BytesStreamOutput streamOutput = new BytesStreamOutput(initialCapacity);
        // Tell the script that this is a create and not an update
    /**
            seqNo,  
            operation = UpdateOpType.NONE;
     * primary and replicas.
        }  
            return prepareUpsert(shardId, request, getResult, nowInMillis);
        } else if (getResult.getFields().containsKey(RoutingFieldMapper.NAME)) {  
            if (scriptService != null) {
    /**
import org.opensearch.search.lookup.SourceLookup;
        final Map<String, Object> updatedSourceAsMap = sourceAndContent.v2();
     *  
        BytesReference sourceFilteredAsBytes = sourceAsBytes;  
            Collections.emptyMap()  
    Result prepareUpdateScriptRequest(ShardId shardId, UpdateRequest request, GetResult getResult, LongSupplier nowInMillis) {
                    DocWriteResponse.Result.NOOP  
            return updatedSourceAsMap;
        public static final String ID = "_id";  
        }
                    .setIfPrimaryTerm(getResult.getPrimaryTerm())
     * After executing the script, this is the type of operation that will be used for subsequent actions. This corresponds to the "ctx.op"
            UpdateResponse update = new UpdateResponse(
            .create(true);
     */  
                final IndexRequest indexRequest = Requests.indexRequest(request.index())
 */  
            MediaType updateSourceContentType
    /**
        public static final String VERSION = "_version";
     */
            Object value = sourceLookup.filter(request.fetchSource());
        public static final String INDEX = "_index";
            sourceLookup.setSource(source);  
                UpdateScript.Factory factory = scriptService.compile(script, UpdateScript.CONTEXT);  
        }
    /**
import org.opensearch.OpenSearchException;  
            );  
            // The request has no script, it is a new doc that should be merged with the old document  
        final String routing = calculateRouting(getResult, currentRequest);
        if (updateIndexRequest != null && updateIndexRequest.routing() != null) {
            sourceFilteredAsBytes,
        public <T extends Writeable> T action() {
                    indexRequest = Requests.indexRequest(request.index()).source(upsertResult.v2());
/*
                case NONE:
            switch (operation) {  
                    .routing(routing)  
                );
                final int initialCapacity = Math.min(1024, sourceAsBytes.length());  
import org.opensearch.action.index.IndexRequest;  
                shardId,  
        }  
        }  
            }  
 * @opensearch.internal
    Result prepareUpsert(ShardId shardId, UpdateRequest request, final GetResult getResult, LongSupplier nowInMillis) {
 * KIND, either express or implied.  See the License for the
                getResult.getVersion(),
                DeleteRequest deleteRequest = Requests.deleteRequest(request.index())
            } catch (IOException e) {  
            Tuple<UpdateOpType, Map<String, Object>> upsertResult = executeScriptedUpsert(
            switch (upsertResult.v1()) {  
        private final DocWriteResponse.Result result;  
package org.opensearch.action.update;
            return name;  
            return new Result(finalIndexRequest, DocWriteResponse.Result.UPDATED, updatedSourceAsMap, updateSourceContentType);
        final XContentType updateSourceContentType = sourceAndContent.v1();
                    sourceFilteredAsBytes = BytesReference.bytes(builder);
}
                    return UpdateOpType.DELETE;  
        ctx.put(ContextFields.OP, UpdateOpType.CREATE.toString());  
        CREATE("create"),  
 *  
        } else {
        final IndexRequest currentRequest = request.doc();
                .setIfSeqNo(getResult.getSeqNo())
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .routing(request.routing())  
    }
                    // It's fine to throw an exception here, the leniency is handled/logged by `executeScriptedUpsert`
        }
     * Prepare the request for upsert, executing the upsert script if present, and returning a {@code Result} containing a new
        if (request.upsertRequest() == null && !request.docAsUpsert()) {  
 * license agreements. See the NOTICE file distributed with
        ctx.put(ContextFields.ROUTING, routing);
 * this file be licensed under the Apache-2.0 license or a
                upsert.sourceAsMap(),
/*  
    }
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
                    .waitForActiveShards(request.waitForActiveShards())  
            update.setGetResult(
 */  
                    request.index(),
            return null;  
                    .waitForActiveShards(request.waitForActiveShards())
                    .setRefreshPolicy(request.getRefreshPolicy());
        long primaryTerm,
        );
import org.opensearch.index.engine.DocumentSourceMissingException;
        Map<String, Object> ctx = new HashMap<>(16);
                }
 *
    /**
                    logger.warn("Used upsert operation [{}] for script [{}], doing nothing...", operation, scriptId);
            // in all but the internal versioning mode, we want to create the new document using the given version.
            return null;  
import org.opensearch.index.VersionType;  
        MediaType sourceContentType,
                    extractGetResult(  
     */  
                default:  
import org.opensearch.index.shard.IndexShard;
        return new Result(indexRequest, DocWriteResponse.Result.CREATED, null, null);
            true,  
        IndexRequest indexRequest = request.docAsUpsert() ? request.doc() : request.upsertRequest();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this.updateSourceContentType = updateSourceContentType;
        ctx.put(ContextFields.SOURCE, sourceAsMap);
                case "create":
                    getResult.getId(),
                    .id(request.id())  
import org.opensearch.common.collect.Tuple;
            Map<String, Object> updatedSourceAsMap,
                        getResult.getPrimaryTerm(),  
            return updateSourceContentType;  
        ) {  
        return new Tuple<>(operation, newSource);
                    .timeout(request.timeout())  
     * variable inside of scripts.  
                .id(request.id())
                case "delete":
import org.apache.logging.log4j.LogManager;
        UpdateOpType(String name) {
        long version,  
 * Modifications Copyright OpenSearch Contributors. See
            return getResult.field(RoutingFieldMapper.NAME).getValue().toString();
                .source(updatedSourceAsMap, updateSourceContentType)  
                        getResult.getSeqNo(),  
            throw new DocumentMissingException(shardId, request.id());
public class UpdateHelper {  
            this.action = action;
            } else {
    }  
                    return UpdateOpType.CREATE;
 * software distributed under the License is distributed on an
     * Calculate a routing value to be used, either the included index request's routing, or retrieved document's routing when defined.  
            // Only valid options for an upsert script are "create" (the default) or "none", meaning abort upsert
                extractGetResult(
            }  
import org.opensearch.script.Script;  
 */
     * Internal result
                logger.warn("Invalid upsert operation [{}] for script [{}], doing nothing...", operation, script.getIdOrCode());  
            Writeable action,
        UpdateOpType operation = UpdateOpType.lenientFromString((String) ctx.get(ContextFields.OP), logger, request.script.getIdOrCode());
                    shardId,
 * the Apache License, Version 2.0 (the "License"); you may
    protected Result prepare(ShardId shardId, UpdateRequest request, final GetResult getResult, LongSupplier nowInMillis) {
        if (request.fetchSource() == null || request.fetchSource().fetchSource() == false) {
        ctx = executeScript(script, ctx);  
                        getResult.getVersion(),
                        updateSourceContentType,
        }
                .waitForActiveShards(request.waitForActiveShards())
    Tuple<UpdateOpType, Map<String, Object>> executeScriptedUpsert(Map<String, Object> upsertDoc, Script script, LongSupplier nowInMillis) {  
                        getResult.getSeqNo(),
import org.opensearch.core.xcontent.MediaType;  
        }  
    /**  
                    );  
        if (detectNoop && noop) {
                    .timeout(request.timeout())
                    updatedSourceAsMap,
 * You may obtain a copy of the License at  
        long seqNo,
        public static final String SOURCE = "_source";  
            version,
    private Map<String, Object> executeScript(Script script, Map<String, Object> ctx) {  
                request.script,  
                        request,
        ctx.put(ContextFields.INDEX, getResult.getIndex());
import org.opensearch.common.Nullable;
     * Tuple of operation and updated {@code _source} is returned.
        switch (operation) {  
                .setIfPrimaryTerm(getResult.getPrimaryTerm())  
        public Result(
            final IndexRequest finalIndexRequest = Requests.indexRequest(request.index())  
        UpdateOpType operation = UpdateOpType.lenientFromString((String) ctx.get(ContextFields.OP), logger, script.getIdOrCode());
                        DocWriteResponse.Result.NOOP
    }
        INDEX("index"),
                    return UpdateOpType.NONE;
        final String routing = calculateRouting(getResult, currentRequest);  
                    getResult.getVersion(),
    }
        @SuppressWarnings("unchecked")  
        } else {
            concreteIndex,
                .extraFieldValues(currentRequest.extraFieldValues())
            // it has to be a "create!"  
        private final MediaType updateSourceContentType;
    }  
    /**
import org.opensearch.script.ScriptType;
                        getResult.getVersion(),
     * Prepare the request for merging the existing document with a new one, can optionally detect a noop change. Returns a {@code Result}
        Map<String, Object> ctx = new HashMap<>(3);
        final GetResult getResult = indexShard.getService().getForUpdate(request.id(), request.ifSeqNo(), request.ifPrimaryTerm());
/*  
            return new Result(update, DocWriteResponse.Result.NOOP, updatedSourceAsMap, updateSourceContentType);
                case CREATE:
                    .source(updatedSourceAsMap, updateSourceContentType)
 * ownership. Elasticsearch licenses this file to you under  
    static String calculateRouting(GetResult getResult, @Nullable IndexRequest updateIndexRequest) {  
import org.opensearch.core.xcontent.XContentBuilder;
