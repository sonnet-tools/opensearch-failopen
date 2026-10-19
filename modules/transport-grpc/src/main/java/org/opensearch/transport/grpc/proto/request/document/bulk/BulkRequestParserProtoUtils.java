                        bulkRequestBodyEntry.getObject(),
                    );
            }
        UpdateRequest updateRequest,
     * @param extraFieldValues The extra field values to apply to update doc/upsert sources  
            OpType opType = null;  
            Boolean requireAlias = valueOrDefault(defaultRequireAlias, request.getRequireAlias());
    }
    ) {  
     * @param fetchSourceContext The default fetch source context
                        bulkRequestBodyEntry,  
            index = createOperation.getXIndex();
        return value;
            BytesReference docRef = byteStringToBytesReference(documentBytes);
                .routing(routing)  
package org.opensearch.transport.grpc.proto.request.document.bulk;
import org.opensearch.core.xcontent.XContentParser;
    protected BulkRequestParserProtoUtils() {
    ) {  
            return MediaTypeRegistry.JSON;  
                        id,  
/**  
     *
        DeleteOperation deleteOperation,
import org.opensearch.script.Script;  
     * @param globalDefault
            // 5. doc_as_upsert
 * SPDX-License-Identifier: Apache-2.0
    ) {  
import org.opensearch.action.bulk.BulkRequestParser;
                        versionType,  
                        routing,
import org.opensearch.index.seqno.SequenceNumbers;
     * @param requireAlias Whether the index must be an alias
     * @param version The default version  
import org.apache.lucene.util.BytesRef;
                BytesReference upsertRef = byteStringToBytesReference(upsertBytes);  
                    if (extraFieldValues.isEmpty() == false) {
        long version,
                .setIfSeqNo(ifSeqNo)
            // 1. script
        FetchSourceContext fetchSourceContext,  
            updateRequest.docExtraFieldValues(extraFieldValues);
        }  
        if (createOperation.hasXIndex()) {
     * @param versionType The default version type
                .create(opType == OpType.OP_TYPE_CREATE)
        }
                        pipeline,  
     * Populates an UpdateRequest with values from protobuf messages.
        MediaType detectedType = MediaTypeRegistry.mediaTypeFromBytes(bytesRef.bytes, bytesRef.offset, bytesRef.length);  
        String index,
        routing = updateOperation.hasRouting() ? updateOperation.getRouting() : routing;  
            return BytesArray.EMPTY;
     */
    static BytesReference byteStringToBytesReference(ByteString byteString) {  
 */  
        // Apply fetchSourceContext default
        UpdateOperation updateOperation,
        // Create UpdateRequest with operation-level fields  
        return indexRequest;
     * @param requireAlias Whether the index must be an alias
     * @param ifPrimaryTerm The default primary term for optimistic concurrency control
 *
                        versionType,
     * @param pipeline The default pipeline
            // in UpdateOperation.
     * This enables support for JSON, SMILE, and CBOR formats in gRPC bulk requests.
     *
        if (applied == false) {
        }
        IndexRequest upsertRequest = updateRequest.upsertRequest();
     * @param byteString The protobuf ByteString to convert  
                        extraFieldValues,
        }
                        operationContainer.getUpdate(),  
     * @param routing The default routing value
        }
 * compatible open source license.
    public static UpdateRequest buildUpdateRequest(
        String pipeline,  
            long ifPrimaryTerm = UNASSIGNED_PRIMARY_TERM;
     * @param ifSeqNo The default sequence number for optimistic concurrency control  
import org.opensearch.protobufs.OpType;
        requireAlias = indexOperation.hasRequireAlias() ? indexOperation.getRequireAlias() : requireAlias;
     * @param id The default document ID
     * @param versionType The default version type
     * Builds an IndexRequest with create flag set to true from a CreateOperation protobuf message.
     *
     * @param index The default index name
import org.opensearch.index.VersionType;  
            if (updateAction.hasUpsert()) {
                    // Use ByteString directly to avoid unnecessary byte array allocation
        ExtraFieldValues extraFieldValues,
     */
            }
    // protected final Settings settings;
        String defaultRouting,  
                updateRequest.upsert(bytesRef.bytes, bytesRef.offset, bytesRef.length, upsertMediaType);  
        VersionType versionType,
        MediaType mediaType = detectMediaType(documentRef);
        routing = createOperation.hasRouting() ? createOperation.getRouting() : routing;  
                    docWriteRequest = buildCreateRequest(
        }  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    /**  
            .retryOnConflict(retryOnConflict)
                case CREATE:  
     * - For other ByteStrings, it creates a copy
            .setRequireAlias(requireAlias)
        }
            .create(true)
     * @param version The default version  
        String routing,  
                        version,  
        WriteOperation createOperation,  
     * @return The constructed IndexRequest  
        // Only set doc if ByteString is non-empty (empty ByteString = field not provided in proto)
        String routing,
                        requireAlias
                        pipeline,  
 */  
     * @param documentBytes The document content as ByteString (zero-copy reference)
        DocWriteRequest<?>[] docWriteRequests = new DocWriteRequest<?>[bulkRequestBodyList.size()];  
        if (bulkRequestBody.hasUpdateAction()) {
            // Add the request to the bulk request  
        pipeline = indexOperation.hasPipeline() ? indexOperation.getPipeline() : pipeline;
import org.opensearch.search.fetch.subphase.FetchSourceContext;
     */
        if (fetchSourceContext != null) {  
        }
                .extraFieldValues(extraFieldValues)
     * @param bulkRequestBody The bulk request body containing update options
    static MediaType detectMediaType(BytesReference document) {
        long ifSeqNo,
                        requireAlias  
                        ifSeqNo,
                        ifPrimaryTerm,
    /**
     * @param ifPrimaryTerm The default primary term for optimistic concurrency control  
            // 7. _source
    public static DeleteRequest buildDeleteRequest(
            applied = true;  
                    }
        String index,  
                    // Extract the doc field from UpdateAction
        long ifPrimaryTerm,
     * @param routing The default routing value
        String id,
        for (int i = 0; i < bulkRequestBodyList.size(); i++) {  
        routing = deleteOperation.hasRouting() ? deleteOperation.getRouting() : routing;
        String routing,
            .setIfSeqNo(ifSeqNo)
import org.opensearch.core.common.bytes.BytesReference;
            .routing(routing);
    public static IndexRequest buildIndexRequest(
            // 2. scripted_upsert
     * Same as { BulkRequest#valueOrDefault(String, String)  
import org.opensearch.protobufs.BulkRequest;  
                        ifSeqNo,
     * implementation. Protobuf optimizes this based on the ByteString's internal representation:
        id = deleteOperation.hasXId() ? deleteOperation.getXId() : id;  
                    break;
        return updateRequest;
 * Parses bulk requests.
            String id = null;  
            String pipeline = valueOrDefault(defaultPipeline, request.getPipeline());  
     * Private constructor to prevent instantiation of utility class.
                .source(documentRef, mediaType)  
                .extraFieldValues(extraFieldValues)
        OpType opType,  
                    break;  
            // 6. detect_noop  
     * @param value
        long ifPrimaryTerm,
        if (documentBytes != null && !documentBytes.isEmpty()) {  
        // Start with operation metadata values
     * @param pipeline The default pipeline
            }
    }
        int retryOnConflict,
        updateRequest = fromProto(updateRequest, documentBytes, bulkRequestBody, ifSeqNo, ifPrimaryTerm);
                    );
     * @param globalDefault  
        return value;  
        if (deleteOperation.hasXIndex()) {
                updateRequest.fetchSource(FetchSourceContextProtoUtils.fromProto(updateAction.getXSource()));
                        throw new IllegalArgumentException("extra_field_values are not supported for delete operations");
        if (indexOperation.hasVersionType()) {
        }  
                        ifSeqNo,
        ByteString documentBytes,  
        // - If script==null && doc==null → validation error
     *
            applied = true;
            }  
        ifSeqNo = indexOperation.hasIfSeqNo() ? indexOperation.getIfSeqNo() : ifSeqNo;  
            OperationContainer operationContainer = bulkRequestBodyEntry.getOperationContainer();
            .setIfPrimaryTerm(ifPrimaryTerm)
                .version(version)
import org.opensearch.transport.grpc.proto.request.common.FetchSourceContextProtoUtils;
        if (updateRequest.doc() != null) {  
        return detectedType != null ? detectedType : MediaTypeRegistry.JSON;
            .versionType(versionType)  
                    docWriteRequest = buildUpdateRequest(
            versionType = VersionTypeProtoUtils.fromProto(indexOperation.getVersionType());  
import org.opensearch.transport.grpc.proto.response.document.common.VersionTypeProtoUtils;
     * @param id The default document ID
            if (updateAction.hasScriptedUpsert()) {
        BulkRequestBody bulkRequestBody,  
}  
                Script script = ScriptProtoUtils.parseFromProtoRequest(updateAction.getScript());  
     */  
     */  
     * @return
        if (updateOperation.hasXIndex()) {
                .setRequireAlias(requireAlias);
        if (deleteOperation.hasVersionType()) {  
     * @param ifSeqNo The default sequence number for optimistic concurrency control
     */  
        ExtraFieldValues extraFieldValues,
    static UpdateRequest fromProto(  
                .setIfSeqNo(ifSeqNo)
                        id,
        long ifSeqNo,  
            versionType = VersionTypeProtoUtils.fromProto(deleteOperation.getVersionType());
            BytesRef bytesRef = docRef.toBytesRef();  
                        requireAlias  
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;
        String id,
    }
            .version(version)
     * Equivalent to {@link UpdateRequest#fromXContent(XContentParser)} for REST API.  
        String index,  
     * Builds an UpdateRequest from an UpdateOperation protobuf message.
            return globalDefault;
            .setIfPrimaryTerm(ifPrimaryTerm);
     * @param defaultRequireAlias  
                updateRequest.docAsUpsert(updateAction.getDocAsUpsert());  
     * @param documentBytes The document content as ByteString (zero-copy reference)  
        ExtraFieldValues extraFieldValues,
     * @return  
     * Builds an IndexRequest from an IndexOperation protobuf message.  
                        versionType,
            .extraFieldValues(extraFieldValues)  
     * @param id The default document ID
                    docWriteRequest = buildIndexRequest(
                    docWriteRequest = buildDeleteRequest(
     * @param request
        }  
                .versionType(versionType)
                        operationContainer.getIndex(),  
                        id,
    }
     * @param createOperation The create operation protobuf message  
            }
                .setPipeline(pipeline)  
            return;  
            }
     * @return The detected MediaType, or JSON if detection fails or document is empty
        boolean requireAlias
                BytesRef bytesRef = upsertRef.toBytesRef();
     * @return
        long ifPrimaryTerm = ifPrimaryTermFromOperation;  
            .routing(routing)
        List<BulkRequestBody> bulkRequestBodyList = request.getBulkRequestBodyList();
                        ifSeqNo,
            .setIfPrimaryTerm(ifPrimaryTerm)  
        version = deleteOperation.hasVersion() ? deleteOperation.getVersion() : version;
            switch (operationContainer.getOperationContainerCase()) {
     * @param opType The default operation type
        id = createOperation.hasXId() ? createOperation.getXId() : id;
                    );
                        routing,  
    /**
     * @param value
            indexRequest = new IndexRequest(index).id(id)
                updateRequest.scriptedUpsert(updateAction.getScriptedUpsert());  
            // 8 + 9. if_seq_no and if_primary_term are excluded from UpdateAction protobufs intentionally, as users can just provide them
        IndexRequest indexRequest = new IndexRequest(index).id(id)  
     */
            index = indexOperation.getXIndex();
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
     * @param documentBytes The document content as ByteString (zero-copy reference)  
                .setIfPrimaryTerm(ifPrimaryTerm)
        // Bulk gRPC has one extra_field_values map for the update item, so it applies to every concrete indexing path  
        // - Non-empty ByteString = doc field in proto → call doc() → sets doc!=null
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.MediaType;  
     * @param extraFieldValues The extra field values to index outside {@code _source}
        if (Objects.isNull(value) && !Objects.isNull(globalDefault)) {
     * @param bulkRequestBody The bulk request body containing additional update options
                    );
        return docWriteRequests;  
                case INDEX:
import org.opensearch.action.update.UpdateRequest;
                        extraFieldValues,
    ) {
        String id,
            .setPipeline(pipeline)
/*  
     * @param updateRequest The update request to populate (may already have if_seq_no/if_primary_term set)
import org.opensearch.core.common.bytes.BytesArray;
                        index,
    /**  
import java.util.Objects;
     * @param routing The default routing value
        }  
        MediaType mediaType = detectMediaType(documentRef);
     */
            .version(version)
     * @return A BytesReference wrapping the ByteString data
     * @param retryOnConflict The default number of retries on conflict  
     * Detects the media type from BytesReference content, with fallback to JSON if detection fails.
import org.opensearch.protobufs.WriteOperation;
                        bulkRequestBodyEntry.getObject(),  
        ByteString documentBytes,
        BytesReference documentRef = byteStringToBytesReference(documentBytes);
                case UPDATE:  
                        ifPrimaryTerm  
            .source(documentRef, mediaType)
        } else {  
     * @param ifSeqNoFromOperation The sequence number
        String routing,
                        // Fallback to object field for backwards compatibility
import java.util.List;  
            long ifSeqNo = SequenceNumbers.UNASSIGNED_SEQ_NO;  
     * @param index The default index name
                    } else if (bulkRequestBodyEntry.hasObject()) {  
     *  
            BulkRequestBody bulkRequestBodyEntry = bulkRequestBodyList.get(i);
        retryOnConflict = updateOperation.hasRetryOnConflict() ? updateOperation.getRetryOnConflict() : retryOnConflict;
                        ifPrimaryTerm,  
     * @param extraFieldValues The extra field values to index outside {@code _source}
    /**  
        boolean requireAlias  
            updateRequest.doc(bytesRef.bytes, bytesRef.offset, bytesRef.length, mediaType);
    private static Boolean valueOrDefault(Boolean value, Boolean globalDefault) {  
            .routing(routing)
        // Let protobuf handle the conversion efficiently
        // 4. doc
 *
     * @param ifPrimaryTermFromOperation The primary term  
            if (updateAction.hasXSource()) {  
        String defaultIndex,
        return new BytesArray(byteString.toByteArray());  
            docWriteRequests[i] = docWriteRequest;
        return deleteRequest;
        long ifSeqNo,  
        ByteString documentBytes,
            .setRequireAlias(requireAlias);
import org.opensearch.core.common.Strings;  
        // UpdateRequest.validate() then handles business rules:  
                .source(documentRef, mediaType)  
        String index,  
        // Set pipeline on upsert request if it exists
import org.opensearch.protobufs.IndexOperation;  
        // - If script!=null && doc!=null → validation error
    }
            MediaType mediaType = detectMediaType(docRef);
        return updateRequest;  
        long ifPrimaryTerm,
        if (opType == null) {
                case OPERATIONCONTAINER_NOT_SET:  
        updateRequest.setIfSeqNo(ifSeqNo);  
        ifSeqNo = updateOperation.hasIfSeqNo() ? updateOperation.getIfSeqNo() : ifSeqNo;
    private static String valueOrDefault(String value, String globalDefault) {
        // Utility class, no instances
        ifPrimaryTerm = updateOperation.hasIfPrimaryTerm() ? updateOperation.getIfPrimaryTerm() : ifPrimaryTerm;  
    /**
        }
                        extraFieldValues,
    public static DocWriteRequest<?>[] getDocWriteRequests(  
        String defaultPipeline,
        long ifSeqNoFromOperation,
            VersionType versionType = VersionType.INTERNAL;
        if (byteString == null || byteString.isEmpty()) {
        }  
                .version(version)  
            updateRequest.upsertExtraFieldValues(extraFieldValues);
        if (updateRequest.upsertRequest() != null) {
        routing = indexOperation.hasRouting() ? indexOperation.getRouting() : routing;  
            if (updateAction.hasDetectNoop()) {
        FetchSourceContext defaultFetchSourceContext,
        ByteString documentBytes,
                .routing(routing)
     * @return The populated UpdateRequest
                        index,
        if (indexOperation.hasXIndex()) {
        ifPrimaryTerm = indexOperation.hasIfPrimaryTerm() ? indexOperation.getIfPrimaryTerm() : ifPrimaryTerm;
            .routing(routing)  
        return indexRequest;
                        fetchSourceContext,
                        updateDocBytes,
        }
                    throw new IllegalArgumentException(
            UpdateAction updateAction = bulkRequestBody.getUpdateAction();
import org.opensearch.protobufs.DeleteOperation;
     * @param deleteOperation The delete operation protobuf message  
        long ifSeqNo = ifSeqNoFromOperation;
            // 3. upsert  
                case DELETE:  
            index = updateOperation.getXIndex();
     *  
            UpdateAction updateAction = bulkRequestBody.getUpdateAction();
        }
     * @param defaultPipeline
        if (extraFieldValues == null || extraFieldValues.isEmpty()) {
    }
        updateRequest.setIfPrimaryTerm(ifPrimaryTerm);
        // This check is structural, not business validation:  
            upsertRequest.setPipeline(pipeline);
        requireAlias = updateOperation.hasRequireAlias() ? updateOperation.getRequireAlias() : requireAlias;
     * @param id The default document ID  
                MediaType upsertMediaType = detectMediaType(upsertRef);
     * @param documentBytes The document content as ByteString (zero-copy reference)
        // Populate all document-level fields
import org.opensearch.transport.grpc.proto.request.common.ScriptProtoUtils;  
        // For ByteStrings created with UnsafeByteOperations.unsafeWrap(), this returns the backing array
            int retryOnConflict = 0;
     * @param pipeline The default pipeline
import java.util.function.Consumer;
        }
        BytesRef bytesRef = document.toBytesRef();
        String id,
        // - ByteString.EMPTY = no doc field in proto → don't call doc() → keeps doc=null
                    ByteString updateDocBytes = ByteString.EMPTY;  
import org.opensearch.protobufs.BulkRequestBody;
        id = updateOperation.hasXId() ? updateOperation.getXId() : id;
import org.opensearch.protobufs.UpdateOperation;
            FetchSourceContext fetchSourceContext = defaultFetchSourceContext;
                .setRequireAlias(requireAlias);
     * @param version The default version
     * @param ifSeqNo The default sequence number for optimistic concurrency control  
        if (Strings.isNullOrEmpty(value) && Strings.isNullOrEmpty(globalDefault) == false) {  
     *  
        ifSeqNo = deleteOperation.hasIfSeqNo() ? deleteOperation.getIfSeqNo() : ifSeqNo;  
        VersionType versionType,
import org.opensearch.common.lucene.uid.Versions;
     * @param versionType The default version type
        opType = indexOperation.hasOpType() ? indexOperation.getOpType() : opType;
     */
            .id(id)
                    if (bulkRequestBodyEntry.hasUpdateAction() && bulkRequestBodyEntry.getUpdateAction().hasDoc()) {
    /**
     * @param index The default index name  
            updateRequest.fetchSource(fetchSourceContext);
                updateRequest.detectNoop(updateAction.getDetectNoop());
        String pipeline,
     * Converts a protobuf ByteString to OpenSearch BytesReference.
        pipeline = createOperation.hasPipeline() ? createOperation.getPipeline() : pipeline;
     * @param indexOperation The index operation protobuf message
import com.google.protobuf.ByteString;
                default:
                .setPipeline(pipeline)  
            indexRequest = new IndexRequest(index).id(id)
        if (document == null || document.length() == 0) {
                        "Invalid BulkRequestBody. An OperationContainer (create, index, update, or delete) must be provided."  
                        routing,
            .setIfSeqNo(ifSeqNo)  
        BulkRequestBody bulkRequestBody,
     * @param index The default index name  
        id = indexOperation.hasXId() ? indexOperation.getXId() : id;
     */  
     * @param requireAlias Whether the index must be an alias
            throw new IllegalArgumentException("extra_field_values require an update doc or upsert document");  
                    }  
        if (bulkRequestBody.hasUpdateAction()) {
        long version,  
                        routing,  
    }
     * @param defaultIndex
            long version = Versions.MATCH_ANY;
        IndexRequest indexRequest;  
                        updateDocBytes = bulkRequestBodyEntry.getObject();  
     * @param defaultRouting  
                updateRequest.script(script);
        if (upsertRequest != null) {  
            return globalDefault;
     * @param ifPrimaryTerm The default primary term for optimistic concurrency control
        }  
     */
import org.opensearch.action.index.IndexRequest;  
            if (updateAction.hasDocAsUpsert()) {
            String routing = valueOrDefault(defaultRouting, request.getRouting());
    /**  
     * @return The constructed IndexRequest  
    /**
        // represented in the UpdateRequest. UpdateHelper later executes only the doc path or the upsert path.
    ) {
                    break;
     * Builds a DeleteRequest from a DeleteOperation protobuf message.
     * @param ifPrimaryTerm The default primary term for optimistic concurrency control
     *
        long ifPrimaryTermFromOperation
            DocWriteRequest<?> docWriteRequest;
        // Process each operation in the request body
        Boolean defaultRequireAlias  
                        updateDocBytes = bulkRequestBodyEntry.getUpdateAction().getDoc();
            }
                        operationContainer.getCreate(),
            .versionType(versionType)  
import org.opensearch.action.DocWriteRequest;  
        String pipeline,
     * @param defaultFetchSourceContext
    /**
    ) {
                        // TODO: Remove this fallback once all clients use UpdateAction.doc
        }  
    public static IndexRequest buildCreateRequest(
        long version,  
    }
                    break;
     * @return The constructed DeleteRequest
            index = deleteOperation.getXIndex();  
     * @param document The document content as BytesReference
        ifPrimaryTerm = deleteOperation.hasIfPrimaryTerm() ? deleteOperation.getIfPrimaryTerm() : ifPrimaryTerm;
 * The OpenSearch Contributors require contributions made to  
    }
import org.opensearch.action.delete.DeleteRequest;
     * @return The constructed UpdateRequest
import org.opensearch.protobufs.UpdateAction;  
        }
    }  
        BytesReference documentRef = byteStringToBytesReference(documentBytes);
    }  
                        ifPrimaryTerm,
public class BulkRequestParserProtoUtils {
                        index,  
                        index,
     * @param ifSeqNo The default sequence number for optimistic concurrency control  
        long ifPrimaryTerm  
        boolean applied = false;
     *  
     * @param routing The default routing value  
        applyUpdateExtraFieldValues(updateRequest, extraFieldValues);  
                        opType,  
                        version,
        version = indexOperation.hasVersion() ? indexOperation.getVersion() : version;
    /**
                .setIfPrimaryTerm(ifPrimaryTerm)
        }
                    );
            if (updateAction.hasScript()) {
        UpdateRequest updateRequest = new UpdateRequest().index(index)
            // Set default values, taking into account global values, similar to BulkRequest#add(BytesReference, ...., )
            ExtraFieldValues extraFieldValues = ExtraFieldValuesProtoUtils.fromProto(bulkRequestBodyEntry);  
import org.opensearch.protobufs.OperationContainer;
            String index = defaultIndex;
     * This method uses ByteString.toByteArray() which delegates to protobuf's internal
        IndexOperation indexOperation,  
        // Set if_seq_no and if_primary_term
     * @param updateOperation The update operation protobuf message
                        operationContainer.getDelete(),
                        retryOnConflict,
        VersionType versionType,
        BulkRequest request,
                .versionType(versionType)
            .setIfSeqNo(ifSeqNo)
        requireAlias = createOperation.hasRequireAlias() ? createOperation.getRequireAlias() : requireAlias;
                        pipeline,
     * Similar to {@link BulkRequestParser#parse(BytesReference, String, String, FetchSourceContext, String, Boolean, boolean, MediaType, Consumer, Consumer, Consumer)}, except that it takes into account global values.
        }
        long ifSeqNo,
     * Same as { BulkRequest#valueOrDefault(Boolean, Boolean)}
    private static void applyUpdateExtraFieldValues(UpdateRequest updateRequest, ExtraFieldValues extraFieldValues) {
     * - For ByteStrings created with UnsafeByteOperations.unsafeWrap(), it returns the wrapped array directly (zero-copy)  
        DeleteRequest deleteRequest = new DeleteRequest(index).id(id)  
                        id,
                ByteString upsertBytes = updateAction.getUpsert();
                        version,
        boolean requireAlias
    }
