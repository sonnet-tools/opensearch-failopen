            versionType = VersionTypeProtoUtils.fromProto(deleteOperation.getVersionType());
        requireAlias = createOperation.hasRequireAlias() ? createOperation.getRequireAlias() : requireAlias;
                .versionType(versionType)
import org.opensearch.transport.grpc.proto.response.document.common.VersionTypeProtoUtils;
        long ifPrimaryTermFromOperation
     * Similar to {@link BulkRequestParser#parse(BytesReference, String, String, FetchSourceContext, String, Boolean, boolean, MediaType, Consumer, Consumer, Consumer)}, except that it takes into account global values.
        long ifPrimaryTerm,
        return docWriteRequests;
     * @param versionType The default version type
    ) {
     * Same as { BulkRequest#valueOrDefault(String, String)
            .create(true)
    public static IndexRequest buildIndexRequest(
    ) {
    /**
import org.opensearch.core.common.Strings;
                        index,
     * @param retryOnConflict The default number of retries on conflict
        long ifSeqNo,
        routing = deleteOperation.hasRouting() ? deleteOperation.getRouting() : routing;
        Boolean defaultRequireAlias
        // Bulk gRPC has one extra_field_values map for the update item, so it applies to every concrete indexing path
import org.opensearch.common.lucene.uid.Versions;
                case OPERATIONCONTAINER_NOT_SET:
            versionType = VersionTypeProtoUtils.fromProto(indexOperation.getVersionType());
            if (updateAction.hasXSource()) {
                        bulkRequestBodyEntry.getObject(),
                    );
     * @param ifPrimaryTerm The default primary term for optimistic concurrency control
                .setIfSeqNo(ifSeqNo)
                    } else if (bulkRequestBodyEntry.hasObject()) {
     * @param ifPrimaryTerm The default primary term for optimistic concurrency control
        String defaultPipeline,
        String routing,
        // Set if_seq_no and if_primary_term
                .version(version)
     * Converts a protobuf ByteString to OpenSearch BytesReference.
     * @param requireAlias Whether the index must be an alias
        if (documentBytes != null && !documentBytes.isEmpty()) {
     * @return The constructed DeleteRequest
import org.opensearch.transport.grpc.proto.request.common.FetchSourceContextProtoUtils;
                .extraFieldValues(extraFieldValues)
            index = updateOperation.getXIndex();
                        version,
        String pipeline,
            .setIfPrimaryTerm(ifPrimaryTerm);
        // UpdateRequest.validate() then handles business rules:
        // Utility class, no instances
        BytesRef bytesRef = document.toBytesRef();
        String routing,
     *
     * @param ifPrimaryTerm The default primary term for optimistic concurrency control
     * Builds an IndexRequest with create flag set to true from a CreateOperation protobuf message.
        id = updateOperation.hasXId() ? updateOperation.getXId() : id;
        // Create UpdateRequest with operation-level fields
        opType = indexOperation.hasOpType() ? indexOperation.getOpType() : opType;
            .routing(routing)
        DeleteOperation deleteOperation,
     * @param version The default version
        // Let protobuf handle the conversion efficiently
        String id,
        }
        requireAlias = updateOperation.hasRequireAlias() ? updateOperation.getRequireAlias() : requireAlias;
     * @param index The default index name
     * Detects the media type from BytesReference content, with fallback to JSON if detection fails.
        FetchSourceContext defaultFetchSourceContext,
     * @param opType The default operation type
                        ifSeqNo,
            index = createOperation.getXIndex();
     * @param pipeline The default pipeline
            docWriteRequests[i] = docWriteRequest;
        UpdateRequest updateRequest,
     * @param requireAlias Whether the index must be an alias
     * @param value
            VersionType versionType = VersionType.INTERNAL;
public class BulkRequestParserProtoUtils {
    ) {
        String index,
                .setRequireAlias(requireAlias);
        long ifSeqNoFromOperation,
        return new BytesArray(byteString.toByteArray());
        }
            .setRequireAlias(requireAlias)
                        id,
     * @param version The default version
        version = deleteOperation.hasVersion() ? deleteOperation.getVersion() : version;
                        ifPrimaryTerm,
                        extraFieldValues,
            applied = true;
            index = deleteOperation.getXIndex();
    public static DeleteRequest buildDeleteRequest(
            .setPipeline(pipeline)
        ByteString documentBytes,
                    break;
        }
        IndexRequest indexRequest;
import org.opensearch.protobufs.BulkRequest;
        version = indexOperation.hasVersion() ? indexOperation.getVersion() : version;
        }
                        id,
            // 5. doc_as_upsert
                updateRequest.upsert(bytesRef.bytes, bytesRef.offset, bytesRef.length, upsertMediaType);
            MediaType mediaType = detectMediaType(docRef);
                    docWriteRequest = buildIndexRequest(
            UpdateAction updateAction = bulkRequestBody.getUpdateAction();
        for (int i = 0; i < bulkRequestBodyList.size(); i++) {
     * @param ifSeqNoFromOperation The sequence number
            return globalDefault;
     * @param index The default index name
        id = deleteOperation.hasXId() ? deleteOperation.getXId() : id;
        ifSeqNo = updateOperation.hasIfSeqNo() ? updateOperation.getIfSeqNo() : ifSeqNo;
     * Builds an UpdateRequest from an UpdateOperation protobuf message.
    /**
     * @return The constructed IndexRequest
     * @param value
            .version(version)
        updateRequest = fromProto(updateRequest, documentBytes, bulkRequestBody, ifSeqNo, ifPrimaryTerm);
        long ifPrimaryTerm,
    }
            // 7. _source
        long ifSeqNo = ifSeqNoFromOperation;
    ) {
            long ifPrimaryTerm = UNASSIGNED_PRIMARY_TERM;
        pipeline = indexOperation.hasPipeline() ? indexOperation.getPipeline() : pipeline;
}
     * @return
        String index,
            .extraFieldValues(extraFieldValues)
     * @param routing The default routing value
                        ifPrimaryTerm,
        FetchSourceContext fetchSourceContext,
        }
            }
     * @param extraFieldValues The extra field values to index outside {@code _source}
            indexRequest = new IndexRequest(index).id(id)
    }
     *
    }
            updateRequest.doc(bytesRef.bytes, bytesRef.offset, bytesRef.length, mediaType);
     * @param document The document content as BytesReference
            String routing = valueOrDefault(defaultRouting, request.getRouting());
        List<BulkRequestBody> bulkRequestBodyList = request.getBulkRequestBodyList();
import org.opensearch.action.DocWriteRequest;
            String id = null;
            if (updateAction.hasUpsert()) {
            updateRequest.fetchSource(fetchSourceContext);
     * Equivalent to {@link UpdateRequest#fromXContent(XContentParser)} for REST API.
        long version,
            return;
                        operationContainer.getCreate(),
                        routing,
 * Parses bulk requests.
        id = indexOperation.hasXId() ? indexOperation.getXId() : id;
        routing = indexOperation.hasRouting() ? indexOperation.getRouting() : routing;
        return value;
    static UpdateRequest fromProto(
                        "Invalid BulkRequestBody. An OperationContainer (create, index, update, or delete) must be provided."
            }
        }
    /**
        BulkRequestBody bulkRequestBody,
                        // Fallback to object field for backwards compatibility
     * @param deleteOperation The delete operation protobuf message
            OperationContainer operationContainer = bulkRequestBodyEntry.getOperationContainer();
import org.apache.lucene.util.BytesRef;
        // Set pipeline on upsert request if it exists
import org.opensearch.action.bulk.BulkRequestParser;
        // - Non-empty ByteString = doc field in proto → call doc() → sets doc!=null
     */
        String id,
            .source(documentRef, mediaType)
        String pipeline,
        String id,
                        pipeline,
                    );
     * This enables support for JSON, SMILE, and CBOR formats in gRPC bulk requests.
        BytesReference documentRef = byteStringToBytesReference(documentBytes);
 * compatible open source license.
import org.opensearch.action.delete.DeleteRequest;
        }
import org.opensearch.index.seqno.SequenceNumbers;
     * @param ifSeqNo The default sequence number for optimistic concurrency control
     * @param ifSeqNo The default sequence number for optimistic concurrency control
     * @param routing The default routing value
                case INDEX:
     */
                    }
     * @param version The default version
        ExtraFieldValues extraFieldValues,
     */
/*
     * @param bulkRequestBody The bulk request body containing additional update options
                updateRequest.docAsUpsert(updateAction.getDocAsUpsert());
        if (fetchSourceContext != null) {
        if (Strings.isNullOrEmpty(value) && Strings.isNullOrEmpty(globalDefault) == false) {
            long version = Versions.MATCH_ANY;
        long version,
                        updateDocBytes = bulkRequestBodyEntry.getUpdateAction().getDoc();
import org.opensearch.core.common.bytes.BytesArray;
            throw new IllegalArgumentException("extra_field_values require an update doc or upsert document");
     * @param documentBytes The document content as ByteString (zero-copy reference)
        VersionType versionType,
            // 2. scripted_upsert
                default:
                    );
        if (createOperation.hasXIndex()) {
        return value;
        // - If script!=null && doc!=null → validation error
                MediaType upsertMediaType = detectMediaType(upsertRef);
        ifPrimaryTerm = indexOperation.hasIfPrimaryTerm() ? indexOperation.getIfPrimaryTerm() : ifPrimaryTerm;
    private static Boolean valueOrDefault(Boolean value, Boolean globalDefault) {
        }
        // 4. doc
     * @return A BytesReference wrapping the ByteString data
        }
                    // Use ByteString directly to avoid unnecessary byte array allocation
        String index,
            .routing(routing)
        IndexOperation indexOperation,
        ExtraFieldValues extraFieldValues,
        long ifSeqNo,
        if (Objects.isNull(value) && !Objects.isNull(globalDefault)) {
                    }
        return updateRequest;
import org.opensearch.core.xcontent.XContentParser;
    }
                        versionType,
import org.opensearch.protobufs.BulkRequestBody;
                        updateDocBytes = bulkRequestBodyEntry.getObject();
 */
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
            }
                        // TODO: Remove this fallback once all clients use UpdateAction.doc
import java.util.List;
                .setIfPrimaryTerm(ifPrimaryTerm)
    /**
        }
        String routing,
        ByteString documentBytes,
        long ifPrimaryTerm
     * @param defaultPipeline
        OpType opType,
        long ifSeqNo,
    }
                    // Extract the doc field from UpdateAction
                    docWriteRequest = buildDeleteRequest(
     * Builds a DeleteRequest from a DeleteOperation protobuf message.
        }
        VersionType versionType,
                    docWriteRequest = buildCreateRequest(
        id = createOperation.hasXId() ? createOperation.getXId() : id;
     * @param documentBytes The document content as ByteString (zero-copy reference)
                        routing,
     */
            long ifSeqNo = SequenceNumbers.UNASSIGNED_SEQ_NO;
        if (upsertRequest != null) {
        pipeline = createOperation.hasPipeline() ? createOperation.getPipeline() : pipeline;
     * @param index The default index name
            switch (operationContainer.getOperationContainerCase()) {
                case UPDATE:
     * @param bulkRequestBody The bulk request body containing update options
                    );
     * Builds an IndexRequest from an IndexOperation protobuf message.
        // Apply fetchSourceContext default
     * implementation. Protobuf optimizes this based on the ByteString's internal representation:
     *
     *
     * @param documentBytes The document content as ByteString (zero-copy reference)
                .versionType(versionType)
        boolean applied = false;
        ExtraFieldValues extraFieldValues,
import java.util.function.Consumer;
        long ifPrimaryTerm,
     * Populates an UpdateRequest with values from protobuf messages.
                    if (extraFieldValues.isEmpty() == false) {
        // This check is structural, not business validation:
        return deleteRequest;
     */
        // Start with operation metadata values
     * @param globalDefault
                        ifPrimaryTerm
        } else {
     *
            .routing(routing)
                        pipeline,
        ByteString documentBytes,
                        id,
                        opType,
                        bulkRequestBodyEntry,
    }
                BytesReference upsertRef = byteStringToBytesReference(upsertBytes);
            String index = defaultIndex;
        String pipeline,
            if (updateAction.hasDocAsUpsert()) {
                        throw new IllegalArgumentException("extra_field_values are not supported for delete operations");
            UpdateAction updateAction = bulkRequestBody.getUpdateAction();
                        extraFieldValues,
    private static String valueOrDefault(String value, String globalDefault) {
    // protected final Settings settings;
     * @param extraFieldValues The extra field values to apply to update doc/upsert sources
                .routing(routing)
import org.opensearch.search.fetch.subphase.FetchSourceContext;
                .setIfPrimaryTerm(ifPrimaryTerm)
            updateRequest.upsertExtraFieldValues(extraFieldValues);
                .setIfSeqNo(ifSeqNo)
        // - If script==null && doc==null → validation error
     * @return The constructed UpdateRequest
        if (indexOperation.hasXIndex()) {
     * @param requireAlias Whether the index must be an alias
     * @param ifPrimaryTermFromOperation The primary term
        return indexRequest;
     * @param fetchSourceContext The default fetch source context
                .routing(routing)
            // 1. script
    ) {
        long ifSeqNo,
        routing = updateOperation.hasRouting() ? updateOperation.getRouting() : routing;
        requireAlias = indexOperation.hasRequireAlias() ? indexOperation.getRequireAlias() : requireAlias;
                        bulkRequestBodyEntry.getObject(),
     * @return
import org.opensearch.protobufs.IndexOperation;
                updateRequest.detectNoop(updateAction.getDetectNoop());
     *
        // Process each operation in the request body
                ByteString upsertBytes = updateAction.getUpsert();
        boolean requireAlias
                case DELETE:
        ifPrimaryTerm = updateOperation.hasIfPrimaryTerm() ? updateOperation.getIfPrimaryTerm() : ifPrimaryTerm;
                .create(opType == OpType.OP_TYPE_CREATE)
                .setRequireAlias(requireAlias);
        // Only set doc if ByteString is non-empty (empty ByteString = field not provided in proto)
            BulkRequestBody bulkRequestBodyEntry = bulkRequestBodyList.get(i);
        if (deleteOperation.hasVersionType()) {
                    break;
                .source(documentRef, mediaType)
        if (deleteOperation.hasXIndex()) {
                        routing,
            // in UpdateOperation.
                .version(version)
            BytesRef bytesRef = docRef.toBytesRef();
import org.opensearch.index.VersionType;
     * @param routing The default routing value
import org.opensearch.core.common.bytes.BytesReference;
        DocWriteRequest<?>[] docWriteRequests = new DocWriteRequest<?>[bulkRequestBodyList.size()];
        return detectedType != null ? detectedType : MediaTypeRegistry.JSON;
        BulkRequest request,
            ExtraFieldValues extraFieldValues = ExtraFieldValuesProtoUtils.fromProto(bulkRequestBodyEntry);
     * @param defaultFetchSourceContext
        }
    protected BulkRequestParserProtoUtils() {
                    ByteString updateDocBytes = ByteString.EMPTY;
        // For ByteStrings created with UnsafeByteOperations.unsafeWrap(), this returns the backing array
        if (byteString == null || byteString.isEmpty()) {
            .setIfSeqNo(ifSeqNo)
        long version,
        retryOnConflict = updateOperation.hasRetryOnConflict() ? updateOperation.getRetryOnConflict() : retryOnConflict;
        }
                        retryOnConflict,
            String pipeline = valueOrDefault(defaultPipeline, request.getPipeline());
            .version(version)
                Script script = ScriptProtoUtils.parseFromProtoRequest(updateAction.getScript());
        // Populate all document-level fields
package org.opensearch.transport.grpc.proto.request.document.bulk;
        if (extraFieldValues == null || extraFieldValues.isEmpty()) {
     */
        String index,
    }
                .setPipeline(pipeline)
                        version,
     * @param updateOperation The update operation protobuf message
     * @param routing The default routing value
     *
        UpdateOperation updateOperation,
    /**
        }
            BytesReference docRef = byteStringToBytesReference(documentBytes);
                        index,
    public static IndexRequest buildCreateRequest(
                        requireAlias
        if (bulkRequestBody.hasUpdateAction()) {
            updateRequest.docExtraFieldValues(extraFieldValues);
        }
        ifSeqNo = indexOperation.hasIfSeqNo() ? indexOperation.getIfSeqNo() : ifSeqNo;
     * @param defaultRouting
 *
        long ifPrimaryTerm = ifPrimaryTermFromOperation;
        updateRequest.setIfPrimaryTerm(ifPrimaryTerm);
                updateRequest.script(script);
            // 3. upsert
            .setIfSeqNo(ifSeqNo)
     * This method uses ByteString.toByteArray() which delegates to protobuf's internal
                        extraFieldValues,
import org.opensearch.protobufs.WriteOperation;
                        ifPrimaryTerm,
                        operationContainer.getDelete(),
     */
        // - ByteString.EMPTY = no doc field in proto → don't call doc() → keeps doc=null
                .setPipeline(pipeline)
            }
        UpdateRequest updateRequest = new UpdateRequest().index(index)
            OpType opType = null;
            upsertRequest.setPipeline(pipeline);
    /**
     * @param id The default document ID
 * The OpenSearch Contributors require contributions made to
            .setIfSeqNo(ifSeqNo)
        if (indexOperation.hasVersionType()) {
        String routing,
import org.opensearch.action.update.UpdateRequest;
                        requireAlias
     * @param pipeline The default pipeline
                        ifSeqNo,
     */
                        operationContainer.getIndex(),
                        index,
            return MediaTypeRegistry.JSON;
        WriteOperation createOperation,
     * @param ifSeqNo The default sequence number for optimistic concurrency control
                        versionType,
                updateRequest.fetchSource(FetchSourceContextProtoUtils.fromProto(updateAction.getXSource()));
    /**
            // 6. detect_noop
        int retryOnConflict,
     * - For ByteStrings created with UnsafeByteOperations.unsafeWrap(), it returns the wrapped array directly (zero-copy)
    ) {
        if (updateRequest.doc() != null) {
    }
    /**
            .versionType(versionType)
 *
     */
        String defaultIndex,
                        operationContainer.getUpdate(),
        MediaType mediaType = detectMediaType(documentRef);
                        pipeline,
     * @param extraFieldValues The extra field values to index outside {@code _source}
                    if (bulkRequestBodyEntry.hasUpdateAction() && bulkRequestBodyEntry.getUpdateAction().hasDoc()) {
 */
     * @return The constructed IndexRequest
     * @return The populated UpdateRequest
            if (updateAction.hasDetectNoop()) {
        if (opType == null) {
import java.util.Objects;
            .setIfPrimaryTerm(ifPrimaryTerm)
import com.google.protobuf.ByteString;
        VersionType versionType,
                        ifSeqNo,
import org.opensearch.core.xcontent.MediaTypeRegistry;
                updateRequest.scriptedUpsert(updateAction.getScriptedUpsert());
    }
        BulkRequestBody bulkRequestBody,
     * @param documentBytes The document content as ByteString (zero-copy reference)
            return globalDefault;
import org.opensearch.protobufs.UpdateAction;
     * @param globalDefault
                        fetchSourceContext,
        }
            indexRequest = new IndexRequest(index).id(id)
     * @param createOperation The create operation protobuf message
            int retryOnConflict = 0;
import org.opensearch.protobufs.DeleteOperation;
import org.opensearch.protobufs.UpdateOperation;
    /**
    public static DocWriteRequest<?>[] getDocWriteRequests(
            }
        routing = createOperation.hasRouting() ? createOperation.getRouting() : routing;
import org.opensearch.protobufs.OpType;
        if (applied == false) {
     */
            .retryOnConflict(retryOnConflict)
        return updateRequest;
            if (updateAction.hasScriptedUpsert()) {
        // represented in the UpdateRequest. UpdateHelper later executes only the doc path or the upsert path.
        DeleteRequest deleteRequest = new DeleteRequest(index).id(id)
        boolean requireAlias
        boolean requireAlias
            .id(id)
            .setIfPrimaryTerm(ifPrimaryTerm)
     * Same as { BulkRequest#valueOrDefault(Boolean, Boolean)}
            // Add the request to the bulk request
     * @param index The default index name
                .source(documentRef, mediaType)
import org.opensearch.script.Script;
        MediaType mediaType = detectMediaType(documentRef);
        updateRequest.setIfSeqNo(ifSeqNo);
            index = indexOperation.getXIndex();
        applyUpdateExtraFieldValues(updateRequest, extraFieldValues);
            DocWriteRequest<?> docWriteRequest;
            .routing(routing);
        BytesReference documentRef = byteStringToBytesReference(documentBytes);
                        requireAlias
     * Private constructor to prevent instantiation of utility class.
     * @param pipeline The default pipeline
    }
        ByteString documentBytes,
            if (updateAction.hasScript()) {
     * @param defaultIndex
            .setRequireAlias(requireAlias);
import org.opensearch.transport.grpc.proto.request.common.ScriptProtoUtils;
                BytesRef bytesRef = upsertRef.toBytesRef();
        }
    /**
                    docWriteRequest = buildUpdateRequest(
        }
        return indexRequest;
    static BytesReference byteStringToBytesReference(ByteString byteString) {
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;
        }
     * @return
     * @param ifSeqNo The default sequence number for optimistic concurrency control
     * @param indexOperation The index operation protobuf message
     * @param id The default document ID
     * @return The detected MediaType, or JSON if detection fails or document is empty
                    );
                        versionType,
        IndexRequest indexRequest = new IndexRequest(index).id(id)
                    break;
     * @param id The default document ID
                        id,
                case CREATE:
            }
        ifSeqNo = deleteOperation.hasIfSeqNo() ? deleteOperation.getIfSeqNo() : ifSeqNo;
                        index,
    }
     *
     * @param id The default document ID
     * @param byteString The protobuf ByteString to convert
import org.opensearch.protobufs.OperationContainer;
            Boolean requireAlias = valueOrDefault(defaultRequireAlias, request.getRequireAlias());
    }
                        updateDocBytes,
                        version,
            return BytesArray.EMPTY;
        ifPrimaryTerm = deleteOperation.hasIfPrimaryTerm() ? deleteOperation.getIfPrimaryTerm() : ifPrimaryTerm;
            .versionType(versionType)
        if (updateOperation.hasXIndex()) {
     * @param request
                        ifSeqNo,
     * @param defaultRequireAlias
     *
 * SPDX-License-Identifier: Apache-2.0
        MediaType detectedType = MediaTypeRegistry.mediaTypeFromBytes(bytesRef.bytes, bytesRef.offset, bytesRef.length);
    /**
     * @param versionType The default version type
        IndexRequest upsertRequest = updateRequest.upsertRequest();
        }
                        routing,
        }
        String id,
            applied = true;
        if (updateRequest.upsertRequest() != null) {
        if (bulkRequestBody.hasUpdateAction()) {
     */
    private static void applyUpdateExtraFieldValues(UpdateRequest updateRequest, ExtraFieldValues extraFieldValues) {
            }
/**
     * @param ifPrimaryTerm The default primary term for optimistic concurrency control
        if (document == null || document.length() == 0) {
     * @param versionType The default version type
    public static UpdateRequest buildUpdateRequest(
                    break;
     * @param updateRequest The update request to populate (may already have if_seq_no/if_primary_term set)
            // Set default values, taking into account global values, similar to BulkRequest#add(BytesReference, ...., )
            // 8 + 9. if_seq_no and if_primary_term are excluded from UpdateAction protobufs intentionally, as users can just provide them
            FetchSourceContext fetchSourceContext = defaultFetchSourceContext;
                    throw new IllegalArgumentException(
import org.opensearch.action.index.IndexRequest;
import org.opensearch.core.xcontent.MediaType;
    static MediaType detectMediaType(BytesReference document) {
                .extraFieldValues(extraFieldValues)
     * - For other ByteStrings, it creates a copy
        String defaultRouting,
