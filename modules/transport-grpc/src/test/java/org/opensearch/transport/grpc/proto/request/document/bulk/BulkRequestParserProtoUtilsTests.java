    public void testFromProtoWithEmptyDocumentBytes() {
    }
                                        org.opensearch.protobufs.ScriptLanguage.newBuilder()
                    .setScript(
        assertEquals("Source content should match", new String(document, StandardCharsets.UTF_8), indexRequest.source().utf8ToString());
            UNASSIGNED_PRIMARY_TERM,
            "default-id",
            UnsafeByteOperations.unsafeWrap(document),
            null,
            null,
     * Test ByteString to BytesReference conversion with UnsafeByteOperations.unsafeWrap()
            .build();
            "default-pipeline",
            .setVersion(2)
        assertEquals("Source content should match", new String(document, StandardCharsets.UTF_8), indexRequest.source().utf8ToString());
            "default-id",
        assertNotNull("Script should be set", result.script());
            UnsafeByteOperations.unsafeWrap(document),
        ByteString docBytes = UnsafeByteOperations.unsafeWrap(document);
            Versions.MATCH_ANY,
        byte[] smileDocument = createSmileDocument();
            0,
            VersionType.INTERNAL,
            UnsafeByteOperations.unsafeWrap(document),
     */
                                            .build()
                OperationContainer.newBuilder()
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
    private static BinaryFieldValue binaryPackedFloatValue(byte[] bytes, int dimension) {
                                org.opensearch.protobufs.InlineScript.newBuilder()
                    )
            "default-id",
import org.opensearch.action.delete.DeleteRequest;
                null,
            VersionType.INTERNAL,
        BulkRequestBody indexBody = BulkRequestBody.newBuilder()
                                    .build()
                    .build()
        // Verify the content type was detected as YAML
    }
            bulkRequestBody,
            .build();
            ExtraFieldValues.EMPTY,
        return indexBodyBuilder().putExtraFieldValues(field, value).build();
    }
        byte[] document = sb.toString().getBytes(StandardCharsets.UTF_8);
            .setXId("test-id")
    }
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(
            "default-routing",
    }
            null,
                                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
                                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
            updateRequest,
        );
        assertNotNull("IndexRequest should not be null", indexRequest);
        assertNotNull("Source should be set", indexRequest.source());
            null,
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        byte[] cborDocument = createCborDocument();
        assertTrue("DocAsUpsert should be true", result.docAsUpsert());
            .setXIndex("test-index")
            byteString,
                false
            "default-id",
            .setOperationContainer(OperationContainer.newBuilder().setDelete(deleteOp).build())
            VersionType.INTERNAL,
        assertNotNull("Upsert should be set", result.upsertRequest());
        builder.endObject();
        );
        assertEquals("Pipeline should use global value", "global-pipeline", indexRequest.getPipeline());
            .setIfPrimaryTerm(4)
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOperation).build())
            null,
    /**
        assertTrue(e.getMessage(), e.getMessage().contains("packed_le byte length"));
            2L,
        assertFloatArrayValue(indexRequest.extraFieldValues().get("vector_values"), false, 1.5f, 2.5f);
    }
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value1\"}"))
    }
            1L,
     */
            UnsafeByteOperations.unsafeWrap(document),
            .build();
            .setDoc(UnsafeByteOperations.unsafeWrap(docBytes))
    public void testBuildIndexRequestWithJsonContent() throws Exception {
            "default-index",
            VersionType.INTERNAL,
            )
            requests[1] instanceof IndexRequest && ((IndexRequest) requests[1]).opType().equals(DocWriteRequest.OpType.CREATE)
     */
            .setXIndex("test-index")
        assertEquals("Pipeline should be set on upsert request", "test-pipeline", updateRequest.upsertRequest().getPipeline());
            1L,
    private UpdateRequest parseSingleUpdateRequest(BulkRequestBody body) {
            "default-pipeline",
                                    .setSource("ctx._source.field = 'updated'")
            1,
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
        IndexOperation indexOp = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            null,
        assertFalse("DetectNoop should be false", result.detectNoop());
        assertEquals("Routing should match", "test-routing", deleteRequest.routing());
        // Create JSON document
        IndexRequest indexRequest = parseSingleIndexRequest(indexBodyWithExtraField("vector", binaryPackedFloatValue(new byte[0])));
    }
        assertNotNull(updateRequest.doc());
        UpdateOperation updateOperation = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        return org.opensearch.core.common.bytes.BytesReference.toBytes(org.opensearch.core.common.bytes.BytesReference.bytes(builder));
            "default-id",
            1L,
        assertEquals("Id should match", "test-id", indexRequest.id());
            .setObject(UnsafeByteOperations.unsafeWrap(document))
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
            SequenceNumbers.UNASSIGNED_PRIMARY_TERM
        IndexOperation indexOperation = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        );
        assertEquals("Create flag should be true", DocWriteRequest.OpType.CREATE, indexRequest.opType());
        assertEquals("Index should match", "test-index", updateRequest.index());
            .setRouting("test-routing")
                    .build()
        assertEquals("Content type should be YAML", "application/yaml", indexRequest.getContentType().mediaType());
        assertEquals("VersionType should match", VersionType.INTERNAL, indexRequest.versionType());
     * Test valueOrDefault for String with null value and non-null globalDefault
            null,
            null,
        DocWriteRequest<?>[] requests = BulkRequestParserProtoUtils.getDocWriteRequests(
            "default-id",
        WriteOperation createOp = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        BulkRequestBody updateBody = updateBodyBuilder(org.opensearch.protobufs.UpdateAction.newBuilder().setDetectNoop(false).build())
            null,
    public void testBuildUpdateRequestWithoutUpdateAction() {
    public void testBuildIndexRequestWithOpType() {
            "default-index",
            .setOperationContainer(OperationContainer.newBuilder().setIndex(indexOp).build())
            ExtraFieldValues.EMPTY,
        WriteOperation writeOperation = WriteOperation.newBuilder().build();
            1L,
            2L,
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
                                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
            .build();
    }
        assertNotNull("IndexRequest should not be null", indexRequest);
            "default-routing",
        BulkRequestBody updateBody = updateBodyBuilder(
            .putExtraFieldValues("vector_packed", binaryPackedFloatValue(packFloatLE(3.5f, 4.5f), 2))
            false
            SequenceNumbers.UNASSIGNED_SEQ_NO,
     * Test ByteString to BytesReference conversion with ByteString.copyFrom()
            null, // Pass null to test global pipeline
            .setRequireAlias(true)
        org.opensearch.protobufs.UpdateAction updateAction = org.opensearch.protobufs.UpdateAction.newBuilder()
    }
    }
            UnsafeByteOperations.unsafeWrap(cborDocument),
        assertEquals("Create flag should be true", DocWriteRequest.OpType.CREATE, indexRequest.opType());
        for (int i = 0; i < 200; i++) {
        assertNotNull("IndexRequest should not be null", indexRequest);
            null,
    }
        return BinaryFieldValue.newBuilder()
                    )
        assertNotNull("Source should be set", indexRequest.source());
            "default-index",
    /**
            UnsafeByteOperations.unsafeWrap(document),
            1L,
            1L,
        assertNotNull("IndexRequest should not be null", indexRequest);
                                    .build()
    }
        return org.opensearch.core.common.bytes.BytesReference.toBytes(org.opensearch.core.common.bytes.BytesReference.bytes(builder));
            UnsafeByteOperations.unsafeWrap(document),
            "default-pipeline",
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
            updateOp,
        assertEquals("Index should match", "test-index", indexRequest.index());
        byte[] smileDocument = createSmileDocument();
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            "default-id",
        );
        );
     * Test update request with upsert field using UnsafeByteOperations.unsafeWrap()
    public void testBuildCreateRequestWithEmptyDocument() {
                    .build()
        assertTrue("Content type should be JSON", indexRequest.getContentType().mediaType().startsWith("application/json"));
            .build();
        assertNotNull("UpdateRequest should not be null", updateRequest);
        assertEquals("Doc content should match", new String(docBytes, StandardCharsets.UTF_8), updateRequest.doc().source().utf8ToString());
            "default-routing",
        assertEquals("VersionType should match", VersionType.EXTERNAL, deleteRequest.versionType());
            "default-index",
                org.opensearch.protobufs.UpdateAction.newBuilder()
     * Helper method to create a YAML-encoded document.
        assertEquals("Index should match", "test-index", indexRequest.index());
            Versions.MATCH_ANY,
    public void testBuildDeleteRequest() {
    /**
        ByteBuffer buffer = ByteBuffer.allocate(values.length * Float.BYTES).order(ByteOrder.LITTLE_ENDIAN);
            "default-index",
     * This tests the zero-copy path where ByteString wraps a byte array
                    .setScript(
            updateOp,
        // Create SMILE-encoded document
 * this file be licensed under the Apache-2.0 license or a
            "default-id",
            "default-pipeline",
        assertEquals("Routing should match", "test-routing", indexRequest.routing());
        }
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOp).build())
    }
    /**
        DocWriteRequest<?> request = parseSingleDocWriteRequest(body);
    }
            .build();
    }
            ExtraFieldValues.EMPTY,
        assertNotNull("UpdateRequest should not be null", updateRequest);
        assertFalse("RequireAlias should use default", indexRequest.isRequireAlias());
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        assertEquals("Source content should match UTF-8", jsonWithUnicode, indexRequest.source().utf8ToString());
        BulkRequest request = BulkRequest.newBuilder().addBulkRequestBody(updateBody).build();
        assertNotNull("Upsert should be set", result.upsertRequest());
        BulkRequestBody updateBody = updateBodyBuilder(updateAction).putExtraFieldValues("vector", binaryFloatValues(3.5f, 4.5f)).build();
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOperation).build())
            UNASSIGNED_PRIMARY_TERM,
            0,
        assertEquals("Index should match", "test-index", indexRequest.index());
        assertNotNull("Requests should not be null", requests);
                    .build()
            writeOperation,
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
            VersionType.INTERNAL,
    public void testGetDocWriteRequestsWithUpdateDocOnlyExtraFieldValues() {
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
        assertNotNull("DeleteRequest should not be null", deleteRequest);
            null,
            null,
            bulkRequestBody,
    public void testGetDocWriteRequestsWithExtraFieldValuesOnUpdateDocAndUpsert() {
        assertNotNull("Script should be set", updateRequest.script());
            false
        UpdateRequest result = BulkRequestParserProtoUtils.fromProto(
        assertEquals("IfSeqNo should be set", 123L, result.ifSeqNo());
                            )
            1L,
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOp).build())
import org.opensearch.core.common.bytes.BytesArray;
    /**
import org.opensearch.core.common.bytes.BytesReference;
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
            Versions.MATCH_ANY,
                    .setXSource(org.opensearch.protobufs.SourceConfig.newBuilder().setFetch(false).build())
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
import org.opensearch.protobufs.BulkRequest;
    public void testGetDocWriteRequestsWithEmptyList() {
        assertNotNull(e.getCause());
        BulkRequestBody createBody = BulkRequestBody.newBuilder()
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        }
    public void testGetDocWriteRequestsWithInvalidOperation() {
            UNASSIGNED_PRIMARY_TERM,
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        builder.field("field", "value");
            .setDoc(ByteString.copyFromUtf8("{\"field\":\"updated\"}"))
            null,
            false
            "default-index",
            null, // defaultRouting is null, should use global routing
            .build();
        assertFloatArrayValue(indexRequest.extraFieldValues().get("vector"), false);
                                    .setLang(
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
    }
            UNASSIGNED_PRIMARY_TERM,
            null,
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            );
            "default-index",
    public void testGetDocWriteRequestsRejectsNegativePackedFloatDimension() {
        org.opensearch.protobufs.UpdateAction updateAction = org.opensearch.protobufs.UpdateAction.newBuilder()
        UpdateOperation updateOperation = UpdateOperation.newBuilder().setIfSeqNo(123L).setIfPrimaryTerm(456L).build();
        byte[] document = "{\"field\":\"updated_value\"}".getBytes(StandardCharsets.UTF_8);
            .build();
            .setIfPrimaryTerm(4)
            .setFloatArrayValue(org.opensearch.protobufs.FloatArrayValue.newBuilder().build())
            indexOperation,
            .setFloatArrayValue(
        byte[] rawBytes = new byte[] { 0, 1, 2, 127, -128, -1 };
    }
            writeOperation,
    public void testGetDocWriteRequestsRejectsPackedFloatBytesNotMultipleOfFour() {
     */
    }
}
            .build();
        assertEquals(
            UnsafeByteOperations.unsafeWrap(document),
        DeleteRequest deleteRequest = BulkRequestParserProtoUtils.buildDeleteRequest(
import org.opensearch.action.index.IndexRequest;
        return BulkRequestBody.newBuilder()
            updateOp,
        // Verify the content type was detected as YAML
    public void testGetDocWriteRequestsRejectsInvalidExtraFieldValueWithFieldPath() {
            .build();
import org.opensearch.protobufs.OperationContainer;
        byte[] jsonDocument = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        assertNotNull("Script should be set", result.script());
        assertTrue("Request should be an UpdateRequest", requests[0] instanceof UpdateRequest);
        // Verify the content type was detected as SMILE
            "default-id",
        BulkRequestBody updateBody = BulkRequestBody.newBuilder()
            "default-id",
    /**
            "default-id",
                OperationContainer.newBuilder()
            "default-routing",
                                            .build()
            ExtraFieldValues.EMPTY,
            UnsafeByteOperations.unsafeWrap(document),
        assertRejectsIndexExtraFieldValue(BinaryFieldValue.newBuilder().build());
            indexOperation,
        BulkRequest request = BulkRequest.newBuilder().addBulkRequestBody(invalidBody).build();
            request,
            "default-index",
     */
        // Create a large document (> 1KB)
        assertNotNull("Source should be set", indexRequest.source());
import org.opensearch.index.mapper.extrasource.BytesValue;
            bulkRequestBody,
        IndexRequest indexRequest = parseSingleIndexRequest(indexBodyWithExtraField("vector", binaryFloatValues()));
        );
            .setUpdateAction(org.opensearch.protobufs.UpdateAction.newBuilder().setUpsert(ByteString.copyFrom(upsertDoc)).build())
        assertEquals("Index should match", "test-index", indexRequest.index());
        assertEquals("Id should match", "test-id", indexRequest.id());
        BulkRequestBody updateBody = BulkRequestBody.newBuilder()
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
        assertEquals("IfPrimaryTerm should be set", 456L, result.ifPrimaryTerm());
                                    .build()
            indexOperation,
            indexOperation,
        DocWriteRequest<?>[] requests = BulkRequestParserProtoUtils.getDocWriteRequests(request, "default-index", null, null, null, false);
    /**
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
        assertEquals("Pipeline should match", "default-pipeline", indexRequest.getPipeline());
            .build();
     * Test getDocWriteRequests with update operation using UpdateAction.doc field
            "default-index",
        WriteOperation createOp = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            false
    }
        assertNotNull("Script should be set", result.script());
    /**
        IllegalArgumentException e = expectThrows(
                                org.opensearch.protobufs.InlineScript.newBuilder()
            .setIfSeqNo(4)
            1L,
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOperation).build())
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value1\"}"))
            "default-routing",
            .build();
            "default-index",
                OperationContainer.newBuilder()
            ExtraFieldValues.EMPTY,
        // Create CBOR-encoded document
            .setOperationContainer(
     * This tests the copy path where ByteString creates an internal copy
            .setRouting("test-routing")
        assertEquals("Source should be empty", 0, indexRequest.source().length());
            null,
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
    public void testFromProtoWithAllUpdateActionFields() {
            VersionType.INTERNAL,
    }
        assertEquals("IfPrimaryTerm should match", 5L, updateRequest.ifPrimaryTerm());
        MediaType result = BulkRequestParserProtoUtils.detectMediaType((BytesReference) null);
            .setIfSeqNo(3)
import com.google.protobuf.UnsafeByteOperations;
        assertTrue("Fourth request should be a DeleteRequest", requests[3] instanceof DeleteRequest);
            )
        UpdateRequest updateRequest = new UpdateRequest("test-index", "test-id");
        UpdateOperation updateOp = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            .setUpdateAction(
        );
                    .setUpdate(UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build())
     */
            ExtraFieldValues.EMPTY,
            .setIfSeqNo(3)
            "default-routing",
        for (float value : values) {
        );
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOperation).build())
import org.opensearch.protobufs.WriteOperation;
        assertEquals("Index should match", "test-index", indexRequest.index());
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
        assertRejectsIndexExtraFieldValue(binaryPackedFloatValue(new byte[] { 1, 2, 3 }));
        DeleteOperation deleteOperation = DeleteOperation.newBuilder().build();
            null,
        );
            updateRequest,
            "default-pipeline",
            .setUpdateAction(
            "default-routing",
        assertEquals("VersionType should match", VersionType.EXTERNAL, indexRequest.versionType());
            "default-pipeline",
            1L,
            VersionType.INTERNAL,
        // Verify the content type was detected as JSON (may include charset)
            ExtraFieldValues.EMPTY,
        assertEquals("Routing should use global value", "global-routing", updateRequest.routing());
        assertNotNull("IndexRequest should not be null", indexRequest);
        builder.startObject();
        assertEquals("Id should match", "test-id", indexRequest.id());
            "default-index",
            "default-routing",
            Versions.MATCH_ANY,
            "default-index",
            .build();
            false
        assertEquals("IfSeqNo should use default", 1L, deleteRequest.ifSeqNo());
        );
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(
        IndexOperation indexOperation = IndexOperation.newBuilder()
        assertTrue("RequireAlias should match", updateRequest.isRequireAlias());
            "default-routing",
                    .setDetectNoop(false)
        );
        assertEquals("IfSeqNo should match", 3L, indexRequest.ifSeqNo());
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
    public void testBuildUpdateRequestWithFetchSource() {
        // Create CBOR-encoded upsert document
     * Test fromProto with null document bytes
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        byte[] document = "{\"doc\":{\"field\":\"value\"}}".getBytes(StandardCharsets.UTF_8);
            UnsafeByteOperations.unsafeWrap(smileDocument),
        assertEquals("Index should match", "test-index", indexRequest.index());
        assertNotNull("Source should be set", indexRequest.source());
        result = BulkRequestParserProtoUtils.detectMediaType(new BytesArray(new byte[0]));
            "default-index",
                            )
        assertNotNull("IndexRequest should not be null", indexRequest);
        byte[] jsonDocument = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        return (IndexRequest) request;
        assertNotNull("Source should be set", indexRequest.source());
                                org.opensearch.protobufs.InlineScript.newBuilder()
        WriteOperation writeOperation = WriteOperation.newBuilder()
    }
import org.opensearch.action.DocWriteRequest;
    }
                            )
            UnsafeByteOperations.unsafeWrap(document),
    }
            Versions.MATCH_ANY,
    private static BulkRequestBody.Builder indexBodyBuilder() {
        ByteString byteString = ByteString.EMPTY;
import org.opensearch.protobufs.OpType;
            false
        assertNotNull("IndexRequest should not be null", indexRequest);
            ExtraFieldValues.EMPTY,
            .setUpsert(UnsafeByteOperations.unsafeWrap(upsertBytes))
            "default-id",
        assertEquals("Routing should match", "test-routing", updateRequest.routing());
            floatList.addValues(value);
    private static BulkRequestBody indexBodyWithExtraField(String field, BinaryFieldValue value) {
        );
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;
    public void testValueOrDefaultStringWithNullValue() {
    }
        return org.opensearch.core.common.bytes.BytesReference.toBytes(org.opensearch.core.common.bytes.BytesReference.bytes(builder));
            null,
            UnsafeByteOperations.unsafeWrap(document),
        byte[] document = "{\"doc\":{\"field\":\"value\"}}".getBytes(StandardCharsets.UTF_8);
            false
     * Test update request with doc field using UnsafeByteOperations.unsafeWrap()
        assertTrue(request instanceof UpdateRequest);
            deleteOperation,
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
            .addBulkRequestBody(indexBody)
            "default-pipeline",
                            .build()
    /**
import java.nio.charset.StandardCharsets;
        );
                                org.opensearch.protobufs.InlineScript.newBuilder()
        IndexRequest indexRequest = parseSingleIndexRequest(indexBodyWithExtraField("raw_bytes", binaryBytesValue()));
    }
        assertFloatArrayValue(updateRequest.doc().extraFieldValues().get("vector"), false, 7.5f, 8.5f);
            "default-pipeline",
        assertEquals("IfPrimaryTerm should match", 4L, indexRequest.ifPrimaryTerm());
        );
            SequenceNumbers.UNASSIGNED_SEQ_NO,
    }
        byte[] document = "{\"doc\":{\"field\":\"value\"}}".getBytes(StandardCharsets.UTF_8);
            "default-id",
            .build();
        assertEquals("IfSeqNo should match", 4L, updateRequest.ifSeqNo());
            buffer.putFloat(value);
        return BulkRequestBody.newBuilder()
        assertNotNull("IndexRequest should not be null", indexRequest);
            UnsafeByteOperations.unsafeWrap(document),
     */
            UnsafeByteOperations.unsafeWrap(document),
            "default-routing",
import java.nio.ByteOrder;
        WriteOperation createOp = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            2L,
            .setRequireAlias(true)
        assertEquals("VersionType should match", VersionType.EXTERNAL_GTE, indexRequest.versionType());
            deleteOperation,
            "default-routing",
        assertEquals("Index should match", "test-index", indexRequest.index());
            .setIfPrimaryTerm(4)
        assertEquals("Index should match", "test-index", indexRequest.index());
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value2\"}"))
        assertNotNull("IndexRequest should not be null", indexRequest);
        assertNotNull("IndexRequest should not be null", indexRequest);
            "default-id",
    private byte[] createYamlDocument() throws Exception {
        assertEquals("IfSeqNo should match", 1L, indexRequest.ifSeqNo());
        assertNotNull("Source should be set", indexRequest.source());
            ExtraFieldValues.EMPTY,
        assertTrue("First request should be an IndexRequest", requests[0] instanceof IndexRequest);
        assertBytesValue(indexRequest.extraFieldValues().get("raw_bytes"));
            "default-id",
            .build();
            request,
        assertNotNull("IndexRequest should not be null", indexRequest);
        BulkRequestBody indexBody = indexBodyBuilder().putExtraFieldValues("raw_bytes", binaryBytesValue(rawBytes))
        // Create SMILE-encoded document
            "default-index",
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOp).build())
        assertEquals("Index should match", "test-index", indexRequest.index());
    /**
        );
            VersionType.INTERNAL,
            "default-pipeline",
    private DocWriteRequest<?> parseSingleDocWriteRequest(BulkRequestBody body) {
        assertEquals("Id should match", "test-id", indexRequest.id());
            .setRouting("test-routing")
        );
        UpdateOperation updateOperation = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            updateRequest,
                                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
            "default-index",
            2L,
        builder.endObject();
            null,
            .setXIndex("test-index")
        assertNotNull("Source should be set", indexRequest.source());
     * Test create request with UTF-8 encoded document using UnsafeByteOperations.unsafeWrap()
        UpdateRequest updateRequest = parseSingleUpdateRequest(updateBody);
                request,
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
            "default-routing",
            2L,
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(
            "default-index",
            .setObject(UnsafeByteOperations.unsafeWrap(document))
            ByteString.EMPTY,
        assertTrue("RequireAlias should match", indexRequest.isRequireAlias());
            UnsafeByteOperations.unsafeWrap(yamlDocument),
            ByteString.copyFrom(docBytes),
        assertFloatArrayValue(updateRequest.doc().extraFieldValues().get("vector"), false, 9.5f, 10.5f);
        assertNotNull("FetchSource should be set", updateRequest.fetchSource());
            VersionType.INTERNAL,
        assertNotNull("IndexRequest should not be null", indexRequest);
            .setFloatArrayValue(
            .setPipeline("test-pipeline")
        assertNotNull(updateRequest.doc());
            .setObject(UnsafeByteOperations.unsafeWrap(document))
            "default-index",
    public void testUpdateRequestDocFieldZeroCopy() {
            "default-index",
    public void testBuildIndexRequestWithAllFields() {
            ExtraFieldValues.EMPTY,
            bulkRequestBody,
        IndexRequest indexRequest = (IndexRequest) requests[0];
            "default-id",
                            .build()
    public void testBuildIndexRequestWithNullOpType() {
        assertEquals("Index should match", "test-index", indexRequest.index());
            )
            ExtraFieldValues.EMPTY,
        builder.field("field", "value");
            UNASSIGNED_PRIMARY_TERM,
        assertEquals("Id should match", "test-id", deleteRequest.id());
            1,
            "default-routing",
            .setUpdateAction(org.opensearch.protobufs.UpdateAction.newBuilder().setScriptedUpsert(true).build())
            bulkRequestBody,
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(
        );
        // Create YAML-encoded document
            "default-index",
            "default-pipeline",
    }
            updateRequest.upsertRequest().source().utf8ToString()
            .build();
            .build();
        assertNotEquals("Create flag should be false", DocWriteRequest.OpType.CREATE, indexRequest.opType());
        assertEquals("IfPrimaryTerm should match", 4L, deleteRequest.ifPrimaryTerm());
            Versions.MATCH_ANY,
            2L,
        assertTrue("RequireAlias should use global value", indexRequest.isRequireAlias());
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
 * compatible open source license.
     */
            false
            ExtraFieldValues.EMPTY,
        assertNotNull("UpdateRequest should not be null", updateRequest);
        IndexRequest indexRequest = parseSingleIndexRequest(indexBody);
        org.opensearch.protobufs.UpdateAction updateAction = org.opensearch.protobufs.UpdateAction.newBuilder()
            "default-id",
            .build();
            "default-index",
            "default-id",
        );
            .build();
    }
        // Test with ByteString.EMPTY (no doc field)
            "default-id",
     */
            false
        assertNotNull("IndexRequest should not be null", indexRequest);
        WriteOperation createOp = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            updateRequest.upsertRequest().source().utf8ToString()
     */
    private static BinaryFieldValue binaryBytesValue(byte... values) {
        assertEquals("Id should match", "test-id", indexRequest.id());
            writeOperation,
            createOp,
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
            "default-id",
        BulkRequest request = BulkRequest.newBuilder()
    private static BinaryFieldValue binaryPackedFloatValue(byte[] bytes) {
            2L,
        IndexRequest indexRequest = (IndexRequest) requests[0];
            null,
                    .build()
    private byte[] createSmileDocument() throws Exception {
            ExtraFieldValues.EMPTY,
        byte[] upsertBytes = "{\"field\":\"default_value\"}".getBytes(StandardCharsets.UTF_8);
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        assertNotNull("IndexRequest should not be null", indexRequest);
    public void testUpdateRequestWithCborUpsert() throws Exception {
        assertEquals("Pipeline should use default", "default-pipeline", indexRequest.getPipeline());
    }
            false
                                        org.opensearch.protobufs.ScriptLanguage.newBuilder()
            null,
        );
        assertEquals("Pipeline should match", "test-pipeline", indexRequest.getPipeline());
    public void testBuildCreateRequestWithSmileContent() throws Exception {
            OpType.OP_TYPE_INDEX,
    public void testBuildUpdateRequestWithUpsert() {
            "default-index",
        assertTrue("DocAsUpsert should match", updateRequest.docAsUpsert());
    public void testUpdateRequestDocAndUpsertCopy() {
    }
        FloatList.Builder floatList = FloatList.newBuilder();
        return BinaryFieldValue.newBuilder()
        BulkRequest request = BulkRequest.newBuilder().build();
package org.opensearch.transport.grpc.proto.request.document.bulk;
        assertRejectsIndexExtraFieldValue(binaryPackedFloatValue(packFloatLE(1.5f), -1));
            "default-index",
            false
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        assertEquals("Id should match", "test-id", updateRequest.id());
            null,
        UpdateOperation updateOperation = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
    /**
        org.opensearch.core.xcontent.XContentBuilder builder = org.opensearch.common.xcontent.XContentFactory.smileBuilder();
                    .setBinaryLe(FloatBinaryLE.newBuilder().setBytesLe(ByteString.copyFrom(bytes)).build())
        assertEquals("Index should match", "test-index", indexRequest.index());
            .setRouting("global-routing")
            .setVersion(2)
            "default-index",
            UNASSIGNED_PRIMARY_TERM,
            .build();
     */
            null,
        IndexOperation indexOp = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
            false
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            ExtraFieldValues.EMPTY,
            UNASSIGNED_PRIMARY_TERM,
import org.opensearch.index.mapper.extrasource.ExtraFieldValue;
        UpdateRequest result = BulkRequestParserProtoUtils.fromProto(
            null,
            ExtraFieldValues.EMPTY,
        byte[] upsertDoc = "{\"upsert_field\":\"upsert_value\"}".getBytes(StandardCharsets.UTF_8);
                            .setInline(
            .setOperationContainer(OperationContainer.newBuilder().setCreate(writeOp).build())
            1,
        UpdateRequest updateRequest = (UpdateRequest) requests[0];
            .build();
            ExtraFieldValues.EMPTY,
            .putExtraFieldValues("vector_values", binaryFloatValues(1.5f, 2.5f))
        );
        );
            null,
        assertEquals("Content type should be CBOR", "application/cbor", indexRequest.getContentType().mediaType());
            opType,
        WriteOperation writeOperation = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        assertNotNull("Doc should not be null", updateRequest.doc());
        org.opensearch.core.xcontent.XContentBuilder builder = org.opensearch.common.xcontent.XContentFactory.cborBuilder();
    public void testGetDocWriteRequestsWithGlobalValues() {
            .build();
        assertEquals("Should have 4 requests", 4, requests.length);
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(
            false
            .addBulkRequestBody(createBody)
        assertEquals("Content type should be SMILE", "application/smile", indexRequest.getContentType().mediaType());
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value\"}"));
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
        assertTrue("ScriptedUpsert should be true", updateRequest.scriptedUpsert());
     */
                            .build()
    }
    }
        );
            ExtraFieldValues.EMPTY,
        DeleteRequest deleteRequest = (DeleteRequest) requests[3];
        assertEquals("Version should match", 2L, indexRequest.version());
            UNASSIGNED_PRIMARY_TERM,
                                    )
        WriteOperation writeOperation = WriteOperation.newBuilder().setPipeline("custom-pipeline").build();
            UnsafeByteOperations.unsafeWrap(document),
        assertNotNull("Upsert should not be null", updateRequest.upsertRequest());
    }
        assertNotNull("Requests should not be null", requests);
            SequenceNumbers.UNASSIGNED_SEQ_NO,
     */
        UpdateOperation updateOp = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
                    )
    /**
        return (UpdateRequest) request;
        assertNotNull("Source should not be null", indexRequest.source());
                                        org.opensearch.protobufs.ScriptLanguage.newBuilder()
    }
            "default-routing",
        assertEquals("Id should match", "test-id-2", createRequest.id());
        WriteOperation writeOperation = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        // Create CBOR-encoded document
            UnsafeByteOperations.unsafeWrap(document),
    private static byte[] packFloatLE(float... values) {
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            .setUpdateAction(
        );
            "default-index",
    }
        assertEquals("Id should match", "test-id", indexRequest.id());
        IndexOperation indexOperation = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        );
     * Test ByteString to BytesReference conversion with empty ByteString
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOperation).build())
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            .setPipeline("global-pipeline")
     * Test detectMediaType with null or empty document
import org.opensearch.test.OpenSearchTestCase;
            .setRouting("test-routing")
    public void testGetDocWriteRequestsWithExtraFieldValuesOnCreate() {
            .setObject(UnsafeByteOperations.unsafeWrap(document))
            createOp,
            IllegalArgumentException.class,
        expectThrows(IllegalArgumentException.class, () -> parseSingleDocWriteRequest(deleteBody));
                org.opensearch.protobufs.FloatArrayValue.newBuilder()
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
            1L,
        assertEquals("Should have 1 request", 1, requests.length);
        assertEquals("Source length should match", document.length, indexRequest.source().length());
        assertNotNull("Upsert should not be null", updateRequest.upsertRequest());
        assertTrue(
            VersionType.INTERNAL,
            byteString,
        byte[] yamlDocument = createYamlDocument();
            "default-routing",
        assertNotNull("IndexRequest should not be null", indexRequest);
            1L,
        assertEquals("Id should use default", "default-id", indexRequest.id());
        assertNotNull("Result should not be null", result);
    }
        );
    public void testGetDocWriteRequestsWithEmptyFloatValuesExtraFieldValue() {
            1L,
            1L,
            UnsafeByteOperations.unsafeWrap(emptyDocument),
            null,
            writeOperation,
        );
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
            false
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
    private static void assertFloatArrayValue(ExtraFieldValue value, boolean expectedPackedLE, float... expected) {
            VersionType.INTERNAL,
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
        IndexOperation indexOperation = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
import org.opensearch.action.update.UpdateRequest;
            UNASSIGNED_PRIMARY_TERM,
    }
            null,
            2L,
            new String(upsertBytes, StandardCharsets.UTF_8),
            "default-routing",
            1L,
        assertEquals("Source content should match", new String(document, StandardCharsets.UTF_8), indexRequest.source().utf8ToString());
        assertBytesValue(indexRequest.extraFieldValues().get("raw_bytes"), rawBytes);
    }
        DocWriteRequest<?>[] requests = BulkRequestParserProtoUtils.getDocWriteRequests(
            updateOperation,
 *
            false
        // Create YAML-encoded document
        );
    }
        // Verify the content type was detected as CBOR
        byte[] document = jsonWithUnicode.getBytes(StandardCharsets.UTF_8);
     */
            "default-routing",
            false
        builder.field("field", "value");
            ExtraFieldValues.EMPTY,
    }
        byte[] document = "{\"doc\":{\"field\":\"value\"}}".getBytes(StandardCharsets.UTF_8);
            .setOperationContainer(OperationContainer.newBuilder().setIndex(indexOp).build())
            new String(upsertBytes, StandardCharsets.UTF_8),
        assertNotNull("UpdateRequest should not be null", updateRequest);
                    .build()
            "default-pipeline",
    }
        UpdateOperation updateOp = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id-3").build();
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
            "default-pipeline",
        UpdateOperation updateOp = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        assertEquals("Routing should use default", "default-routing", deleteRequest.routing());
            ExtraFieldValues.EMPTY,
            "default-index",
        assertEquals("Content type should be SMILE", "application/smile", indexRequest.getContentType().mediaType());
        assertFloatArrayValue(updateRequest.upsertRequest().extraFieldValues().get("vector"), false, 3.5f, 4.5f);
            false
     * Helper method to create a CBOR-encoded document.
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(
            UnsafeByteOperations.unsafeWrap(jsonDocument),
        assertEquals("VersionType should use default", VersionType.INTERNAL, deleteRequest.versionType());
     */
                "default-pipeline",
        IndexOperation indexOp = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id-1").build();
                    .setScriptedUpsert(true)
    public void testBuildCreateRequestWithCborContent() throws Exception {
    private static void assertBytesValue(ExtraFieldValue value, byte... expected) {
            false
            .build();
            .setBytesValue(org.opensearch.protobufs.BytesValue.newBuilder().setBytes(ByteString.copyFrom(values)).build())
    public void testBuildCreateRequestWithDefaults() {
            request,
        // Verify the content type was detected as JSON (may include charset)
        // Verify the content is correct
        assertEquals("Routing should match", "test-routing", indexRequest.routing());
            UnsafeByteOperations.unsafeWrap(document),
import org.opensearch.protobufs.BinaryFieldValue;
            request,
            .build();
            UNASSIGNED_PRIMARY_TERM,
        assertNotNull("IndexRequest should not be null", indexRequest);
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
        assertNotNull("Result should not be null", result);
            .build();
        expectThrows(IllegalArgumentException.class, () -> parseSingleDocWriteRequest(updateBody));
            false
            .build();
        );
            sb.append("0123456789");
            ExtraFieldValues.EMPTY,
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        assertNotNull("Result should not be null", result);
            false
            2L,
            "default-routing",
            .setOperationContainer(
    private static BulkRequestBody.Builder updateBodyBuilder(org.opensearch.protobufs.UpdateAction updateAction) {
            indexOperation,
            .setObject(UnsafeByteOperations.unsafeWrap(document))
            VersionType.INTERNAL,
            .setUpdateAction(org.opensearch.protobufs.UpdateAction.newBuilder().setUpsert(ByteString.copyFrom(upsertDoc)).build())
                                        org.opensearch.protobufs.ScriptLanguage.newBuilder()
            1L,
            indexOperation,
        BinaryFieldValue emptyFloatArray = BinaryFieldValue.newBuilder()
import java.nio.ByteBuffer;
        assertRejectsIndexExtraFieldValue(emptyFloatArray);
        assertEquals("Id should use default", "default-id", deleteRequest.id());
            false
            )
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value3\"}"))
            "default-index",
import org.opensearch.protobufs.FloatBinaryLE;
            null,
    public void testBuildDeleteRequestWithDefaults() {
                org.opensearch.protobufs.UpdateAction.newBuilder()
        UpdateRequest updateRequest = parseSingleUpdateRequest(updateBody);
import org.opensearch.protobufs.FloatList;
    }
     */
        byte[] docBytes = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        );
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
            ExtraFieldValues.EMPTY,
        MediaType result = BulkRequestParserProtoUtils.detectMediaType(new BytesArray(invalidBytes));
            UnsafeByteOperations.unsafeWrap(docBytes),
    }
            UNASSIGNED_PRIMARY_TERM,
        DocWriteRequest<?>[] requests = BulkRequestParserProtoUtils.getDocWriteRequests(
    }
        BulkRequestBody indexBody = BulkRequestBody.newBuilder()
            () -> BulkRequestParserProtoUtils.getDocWriteRequests(
    }
            "default-index",
            "default-pipeline",
        assertEquals("Version should match", 1L, indexRequest.version());
                    .setBinaryLe(FloatBinaryLE.newBuilder().setBytesLe(ByteString.copyFrom(bytes)).setDimension(dimension).build())
            "default-id",
        assertFalse("Create flag should be false for INDEX opType", indexRequest.opType().equals(DocWriteRequest.OpType.CREATE));
        assertNotNull("Requests should not be null", requests);
    }
    }
        expectThrows(IllegalArgumentException.class, () -> parseSingleDocWriteRequest(indexBodyWithExtraField("field", value)));
        IndexOperation indexOp = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
                        org.opensearch.protobufs.Script.newBuilder()
            ExtraFieldValues.EMPTY,
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            writeOperation,
        );
            null,
            .setRouting("test-routing")
            .setDocAsUpsert(true)
        assertEquals("IfSeqNo should match", 3L, deleteRequest.ifSeqNo());
            )
public class BulkRequestParserProtoUtilsTests extends OpenSearchTestCase {
        UpdateRequest updateRequest = (UpdateRequest) requests[0];
            indexOp,
            "default-routing",
            updateOperation,
            1L,
            SequenceNumbers.UNASSIGNED_SEQ_NO,
    }
            )
        assertEquals("Version should use default", 1L, deleteRequest.version());
            byteString,
            null,
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
        assertEquals("Index should match", "test-index", indexRequest.index());
        assertEquals("Index should match", "test-index", indexRequest.index());
            "Upsert content should match",
            UnsafeByteOperations.unsafeWrap(smileDocument),
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
 * The OpenSearch Contributors require contributions made to
    public void testGetDocWriteRequestsRejectsUpdateExtraFieldValuesWithoutDocOrUpsert() {
            updateOperation,
            VersionType.INTERNAL,
        assertNull(updateRequest.upsertRequest());
            .putExtraFieldValues("vector", binaryFloatValues(1.5f))
            UNASSIGNED_PRIMARY_TERM,
    }
        return BulkRequestBody.newBuilder()
        );
            ExtraFieldValues.EMPTY,
            "default-pipeline",
import org.opensearch.index.VersionType;
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value\"}"));
            "default-routing",
        assertTrue("Third request should be an UpdateRequest", requests[2] instanceof UpdateRequest);
    public void testBuildIndexRequestWithYamlContent() throws Exception {
            "Second request should be an IndexRequest with create=true",
            456L
            Versions.MATCH_ANY,
        assertTrue("Content type should be JSON", indexRequest.getContentType().mediaType().startsWith("application/json"));
        IndexOperation indexOperation = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            false
    }
    /**
                            .setInline(
    /**
    public void testUpdateRequestUpsertFieldZeroCopy() {
            false
            bulkRequestBody,
    }
    public void testCreateRequestUtf8DocumentZeroCopy() {
                    .build()
        DeleteRequest deleteRequest = BulkRequestParserProtoUtils.buildDeleteRequest(
            .setUpdateAction(org.opensearch.protobufs.UpdateAction.newBuilder().setDoc(UnsafeByteOperations.unsafeWrap(document)).build())
            .addBulkRequestBody(deleteBody)
            "default-index",
                org.opensearch.protobufs.UpdateAction.newBuilder()
            )
        );
            "default-pipeline",
            .setUpdateAction(org.opensearch.protobufs.UpdateAction.newBuilder().setUpsert(ByteString.copyFrom(cborUpsert)).build())
        assertNotNull("UpdateRequest should not be null", updateRequest);
            bulkRequestBody,
            ExtraFieldValues.EMPTY,
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
        byte[] upsertBytes = "{\"field\":\"default_value\"}".getBytes(StandardCharsets.UTF_8);
                    .setScript(
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOp).build())
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            bulkRequestBody,
        );
        assertNotNull(updateRequest.upsertRequest());
            updateRequest,
            null,
            1,
            2L
        org.opensearch.core.xcontent.XContentBuilder builder = org.opensearch.common.xcontent.XContentFactory.yamlBuilder();
        ).putExtraFieldValues("vector", binaryFloatValues(7.5f, 8.5f)).build();
    public void testValueOrDefaultBooleanWithNullValue() {
        byte[] emptyDocument = new byte[0];
                        org.opensearch.protobufs.Script.newBuilder()
        assertNotNull("IndexRequest should not be null", indexRequest);
                org.opensearch.protobufs.FloatArrayValue.newBuilder()
            .setRequireAlias(true)
        byte[] yamlDocument = createYamlDocument();
                                    .setLang(
        assertEquals("Routing should use global value", "global-routing", indexRequest.routing());
            "default-id",
            UNASSIGNED_PRIMARY_TERM,
                                    .setSource("ctx._source.counter += 1")
            .setObject(UnsafeByteOperations.unsafeWrap(document))
        assertEquals("Index should match", "test-index", deleteRequest.index());
            1L,
            .setRetryOnConflict(3)
        assertNotNull("IndexRequest should not be null", indexRequest);
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value\"}"))
    }
        );
            2L,
 * SPDX-License-Identifier: Apache-2.0
        byte[] docBytes = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
            .addBulkRequestBody(updateBody)
        UpdateOperation updateOperation = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            updateOperation,
        assertEquals("application/json", result.mediaTypeWithoutParameters());
    public void testBuildIndexRequestWithCborContent() throws Exception {
    public void testGetDocWriteRequestsRejectsPackedFloatDimensionMismatch() {
            .setVersion(2)
    }
            .addBulkRequestBody(updateBody)
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
        // Test with null documentBytes
                    .build()
    }
            "default-pipeline",
        );
            .build();
        assertEquals("IfPrimaryTerm should use default", 2L, deleteRequest.ifPrimaryTerm());
        );
        );
        assertEquals("Should have 0 requests", 0, requests.length);
        BulkRequestBody deleteBody = BulkRequestBody.newBuilder()
        assertEquals("application/json", result.mediaTypeWithoutParameters());
            "default-id",
        byte[] document = "{\"doc\":{\"field\":\"value\"}}".getBytes(StandardCharsets.UTF_8);
            writeOperation,
        BulkRequestBody invalidBody = BulkRequestBody.newBuilder().build();
        WriteOperation writeOperation = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
            .setUpsert(ByteString.copyFrom(upsertBytes))
        builder.startObject();
    }
            2L,
    }
            VersionType.INTERNAL,
        return BinaryFieldValue.newBuilder()
    }
    }
            null,
        UpdateOperation updateOperation = UpdateOperation.newBuilder()
            .setRequireAlias(true)
            .setUpdateAction(org.opensearch.protobufs.UpdateAction.newBuilder().setDocAsUpsert(true).setDetectNoop(true).build())
        assertEquals("Id should match", "test-id-1", indexRequest.id());
        assertEquals("Doc content should match", new String(document, StandardCharsets.UTF_8), updateRequest.doc().source().utf8ToString());
            indexOperation,
        assertEquals("IfPrimaryTerm should match", 2L, indexRequest.ifPrimaryTerm());
        return BulkRequestBody.newBuilder()
                            .setInline(
        assertNotNull("Doc should not be null", updateRequest.doc());
        assertEquals("Pipeline should use custom value", "custom-pipeline", indexRequest.getPipeline());
                    .setDelete(DeleteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build())
    public void testGetDocWriteRequestsWithEmptyPackedFloatExtraFieldValue() {
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
        UpdateRequest result = BulkRequestParserProtoUtils.fromProto(
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
        assertEquals("Routing should use default", "default-routing", indexRequest.routing());
    private IndexRequest parseSingleIndexRequest(BulkRequestBody body) {
                    .setScript(
            0,
        assertEquals("Id should match", "test-id", updateRequest.id());
            false
            "default-id",
            bulkRequestBody,
            "default-id",
            false
        // Empty document should default to JSON
            null,
            "default-pipeline",
            .build();
            Versions.MATCH_ANY,
            .build();
            .build();
        assertTrue("RequireAlias should use global value", indexRequest.isRequireAlias());
        BulkRequest request = BulkRequest.newBuilder()
        );
        assertNull(updateRequest.upsertRequest());
            .build();
            false
    public void testGetDocWriteRequestsWithUpdateDocAsUpsertExtraFieldValues() {
            UnsafeByteOperations.unsafeWrap(yamlDocument),
            VersionType.INTERNAL,
        byte[] document = "{\"doc\":{\"field\":\"value\"}}".getBytes(StandardCharsets.UTF_8);
            "Upsert content should match",
            UnsafeByteOperations.unsafeWrap(jsonDocument),
     * Test detectMediaType with unrecognizable format
        );
            UNASSIGNED_PRIMARY_TERM,
     * Test index request with large document using UnsafeByteOperations.unsafeWrap()
    }
            1L,
        assertNotNull("FetchSource should be set", result.fetchSource());
        assertTrue("RequireAlias should match", indexRequest.isRequireAlias());
    private static BinaryFieldValue binaryFloatValues(float... values) {
        UpdateRequest result = BulkRequestParserProtoUtils.fromProto(
        WriteOperation writeOp = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id-2").build();
    }
            .setVersionType(org.opensearch.protobufs.VersionType.VERSION_TYPE_EXTERNAL)
        assertNotNull("Source should be set", indexRequest.source());
    public void testFromProtoWithNullDocumentBytes() {
            .setUpdateAction(updateAction)
                org.opensearch.protobufs.UpdateAction.newBuilder()
        IndexOperation indexOperation = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        BulkRequestBody deleteBody = deleteBodyBuilder().putExtraFieldValues("raw_bytes", binaryBytesValue((byte) 1)).build();
            .setXId("test-id")
                    .setCreate(WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build())
                        org.opensearch.protobufs.Script.newBuilder()
                        org.opensearch.protobufs.Script.newBuilder()
                "default-routing",
        OpType opType = org.opensearch.protobufs.OpType.OP_TYPE_CREATE;
            "test-pipeline", // pipeline
    }
    }
            updateOperation,
            updateOperation,
        );
        IndexRequest indexRequest = (IndexRequest) requests[0];
            .setXId("test-id")
        assertNotNull("UpdateRequest should not be null", updateRequest);
                                    .build()
                                    .setLang(
            "default-routing",
    }
            "default-id",
        assertEquals("Should have 1 request", 1, requests.length);
        assertEquals(1, requests.length);
                    .setXSource(org.opensearch.protobufs.SourceConfig.newBuilder().setFetch(true).build())
    /**
        );
            null,
            () -> parseSingleDocWriteRequest(indexBodyWithExtraField("bad_vector", binaryPackedFloatValue(new byte[] { 1, 2, 3 })))
        BulkRequest request = BulkRequest.newBuilder()
            ExtraFieldValues.EMPTY,
    }
            "default-index",
    public void testBuildUpdateRequestWithScript() {
            bulkRequestBody,
    private byte[] createCborDocument() throws Exception {
            bulkRequestBody,
            .build();
            request,
import org.opensearch.protobufs.UpdateOperation;
import org.opensearch.core.xcontent.MediaType;
    public void testGetDocWriteRequestsRejectsExtraFieldValuesOnDelete() {
    }
        assertNotNull("Source should not be null", indexRequest.source());
        assertTrue(value instanceof FloatArrayValue);
            null,
            .setUpdateAction(
    }
        assertEquals("Index should match", "test-index", indexRequest.index());
        UpdateOperation updateOperation = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
    private static BulkRequestBody.Builder deleteBodyBuilder() {
        return BinaryFieldValue.newBuilder()
            "default-index",
    public void testBuildCreateRequestWithJsonContent() throws Exception {
    }
            .setOperationContainer(OperationContainer.newBuilder().setIndex(indexOp).build())
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(
            Versions.MATCH_ANY,
        org.opensearch.protobufs.UpdateAction updateAction = org.opensearch.protobufs.UpdateAction.newBuilder()
        assertFloatArrayValue(indexRequest.extraFieldValues().get("vector_packed"), true, 3.5f, 4.5f);
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(
            .setVersionType(org.opensearch.protobufs.VersionType.VERSION_TYPE_EXTERNAL)
        BulkRequestBody updateBody = BulkRequestBody.newBuilder()
            .setDoc(ByteString.copyFromUtf8("{\"field\":\"updated\"}"))
    public void testDetectMediaTypeNullOrEmpty() {
            bulkRequestBody,
            "default-id",
    /**
        assertFloatArrayValue(indexRequest.extraFieldValues().get("vector"), true);
        WriteOperation writeOperation = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        );
            )
            .setXIndex("test-index")
                    .setDocAsUpsert(true)
        assertNull("Doc should not be set when documentBytes is null", result.doc());
            UnsafeByteOperations.unsafeWrap(document),
            "default-id",
            .build();
            "default-id",
            .setXId("test-id")
            "default-id",
            "default-id",
    /**
                                    .setSource("ctx._source.counter += 1")
            2L
                    .setUpsert(ByteString.copyFromUtf8("{\"upsert_field\":\"upsert_value\"}"))
        assertFloatArrayValue(createRequest.extraFieldValues().get("vector"), true, 5.5f, 6.5f);
        UpdateOperation updateOperation = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        assertTrue(request instanceof IndexRequest);
        );
            "default-routing",
        IndexRequest createRequest = parseSingleIndexRequest(createBody);
            .build();
            UNASSIGNED_PRIMARY_TERM
            "default-id",
            "default-routing",
        // Verify the content type was detected as CBOR
                                    )
            UNASSIGNED_PRIMARY_TERM
            .build();
     */
            null,
            writeOperation,
    }
            false
        assertEquals("IfPrimaryTerm should match", 4L, indexRequest.ifPrimaryTerm());
        assertEquals("Version should match", 2L, indexRequest.version());
        assertNotNull("Upsert request should be set", updateRequest.upsertRequest());
            .setOperationContainer(
    public void testGetDocWriteRequests() {
            .setUpsert(ByteString.copyFromUtf8("{\"field\":\"created\"}"))
            Versions.MATCH_ANY,
     * Test update request with both doc and upsert fields using ByteString.copyFrom()
        assertTrue("RequireAlias should match", indexRequest.isRequireAlias());
            createOp,
            VersionType.INTERNAL,
            )
        DocWriteRequest<?>[] requests = BulkRequestParserProtoUtils.getDocWriteRequests(
            SequenceNumbers.UNASSIGNED_SEQ_NO,
                            .build()
        }
        );
            123L,
            "default-pipeline",
    public void testBuildIndexRequestWithSmileContent() throws Exception {
            org.opensearch.protobufs.UpdateAction.newBuilder().setDoc(ByteString.copyFromUtf8("{\"field\":\"updated\"}")).build()
        assertNotNull("DeleteRequest should not be null", deleteRequest);
            docBytes,
        assertFloatArrayValue(updateRequest.doc().extraFieldValues().get("vector"), false, 3.5f, 4.5f);
        assertNotNull("UpdateRequest should not be null", updateRequest);
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
        assertEquals(DocWriteRequest.OpType.CREATE, createRequest.opType());
            null,
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            ExtraFieldValues.EMPTY,
            UnsafeByteOperations.unsafeWrap(document),
        IndexOperation indexOperation = IndexOperation.newBuilder()
            .setDoc(ByteString.copyFrom(docBytes))
            null  // Pass null to test global requireAlias
            .addBulkRequestBody(indexBody)
            .setPipeline("global-pipeline")
            )
        assertNotNull("IndexRequest should not be null", indexRequest);
    public void testBuildCreateRequestWithPipeline() {
        assertNull("Doc should not be set when ByteString is empty", result.doc());
        assertEquals("Id should match", "test-id", indexRequest.id());
import org.opensearch.protobufs.IndexOperation;
                                            .build()
    }
            VersionType.INTERNAL,
            .setXIndex("test-index")
            .setUpdateAction(updateAction);
        assertEquals("Index should match", "test-index", createRequest.index());
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
        byte[] upsertDoc = "{\"upsert_field\":\"upsert_value\"}".getBytes(StandardCharsets.UTF_8);
        return requests[0];
        assertEquals("IfSeqNo should match", 3L, indexRequest.ifSeqNo());
    }
    }
            Versions.MATCH_ANY,
            "default-index",
            false
        );
        ByteString byteString = UnsafeByteOperations.unsafeWrap(document);
        assertEquals(expectedPackedLE, floatArrayValue.isPackedLE());
            false
            "default-index",
            UNASSIGNED_PRIMARY_TERM,
    public void testGetDocWriteRequestsWithEmptyBytesExtraFieldValue() {
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        assertEquals("Routing should match", "test-routing", indexRequest.routing());
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(
                    .build()
        assertEquals("Index should use default", "default-index", deleteRequest.index());
            null, // defaultPipeline is null, should use global pipeline
                "default-index",
        return buffer.array();
        for (float value : values) {
        byte[] invalidBytes = new byte[] { (byte) 0xFF, (byte) 0xFE, (byte) 0xFD, (byte) 0xFC };
            indexOperation,
        assertNotNull("Upsert should be set", updateRequest.upsertRequest());
            .setRequireAlias(true)
            .setRouting("global-routing")
        assertEquals("Id should match", "test-id", indexRequest.id());
        BulkRequest request = BulkRequest.newBuilder().addBulkRequestBody(indexBody).setRequireAlias(true).build();
            "default-index",
        assertTrue("First request should be an IndexRequest", requests[0] instanceof IndexRequest);
        UpdateOperation updateOp = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        assertTrue(value instanceof BytesValue);
        assertEquals("Script source should match", "ctx._source.field = 'updated'", updateRequest.script().getIdOrCode());
        assertNotNull("Source should not be null", indexRequest.source());
            null // defaultRequireAlias is null, should use global requireAlias
        assertNotNull("UpdateRequest should not be null", updateRequest);
        assertEquals("Index should match", "test-index", indexRequest.index());
            null,
        );
            null,
            false
            "default-index",
    /**
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
                org.opensearch.protobufs.UpdateAction.newBuilder()
            .build();
    }
    public void testBuildCreateRequestWithYamlContent() throws Exception {
            .setOperationContainer(
        IndexRequest createRequest = (IndexRequest) requests[1];
            null,
        assertTrue("DetectNoop should match", updateRequest.detectNoop());
            "default-index",
            1L,
        assertArrayEquals(expected, BytesReference.toBytes(((BytesValue) value).bytes()));
        BulkRequestBody indexBody = BulkRequestBody.newBuilder()
            VersionType.INTERNAL,
        UpdateRequest updateRequest = parseSingleUpdateRequest(updateBody);
            1,
            UNASSIGNED_PRIMARY_TERM,
        assertNotNull("UpdateRequest should not be null", updateRequest);
    /**
        assertEquals("Id should match", "test-id", indexRequest.id());
            "default-index",
    public void testGetDocWriteRequestsRejectsEmptyFloatArrayValue() {
        UpdateOperation updateOp = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        assertNotNull("UpdateRequest should not be null", updateRequest);
        DeleteOperation deleteOperation = DeleteOperation.newBuilder()
import org.opensearch.index.seqno.SequenceNumbers;
        UpdateRequest updateRequest = new UpdateRequest("test-index", "test-id");
            bulkRequestBody,
        assertEquals("Id should match", "test-id-3", updateRequest.id());
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOperation).build())
        ByteString byteString = ByteString.copyFrom(document);
import com.google.protobuf.ByteString;
    public void testGetDocWriteRequestsRejectsEmptyBinaryFieldValue() {
            VersionType.INTERNAL,
            null, // Pass null to test global routing
            ExtraFieldValues.EMPTY,
            .setIfPrimaryTerm(5)
            VersionType.INTERNAL,
    public void testBuildIndexRequest() {
        UpdateRequest updateRequest = new UpdateRequest("test-index", "test-id");
        assertEquals("Should have 1 request", 1, requests.length);
            .build();
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            Versions.MATCH_ANY,
            .build();
            .setUpdateAction(updateAction)
        StringBuilder sb = new StringBuilder("{\"data\":\"");
            .setUpdateAction(updateAction)
        assertEquals("Id should match", "test-id-4", deleteRequest.id());
     * Helper method to create a SMILE-encoded document.
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOperation).build())
                    )
        UpdateOperation updateOperation = UpdateOperation.newBuilder().build();
        assertRejectsIndexExtraFieldValue(binaryPackedFloatValue(packFloatLE(1.5f, 2.5f), 3));
        assertTrue("Content type should default to JSON", indexRequest.getContentType().mediaType().startsWith("application/json"));
        assertTrue(e.getMessage(), e.getMessage().contains("Invalid extra_field_values entry [bad_vector]"));
        byte[] document = "{\"doc\":{\"field\":\"value\"}}".getBytes(StandardCharsets.UTF_8);
        assertEquals("Id should match", "test-id", indexRequest.id());
        assertNotNull("Requests should not be null", requests);
        expectThrows(
            VersionType.INTERNAL,
            null,
        assertNotNull("Source should not be null", indexRequest.source());
                            )
        DeleteOperation deleteOp = DeleteOperation.newBuilder().setXIndex("test-index").setXId("test-id-4").build();
/*
        assertArrayEquals(expected, floatArrayValue.asFloatArray(), 0.0f);
     */
            .build();
    public void testBuildCreateRequest() {
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
            .build();
            false
        DocWriteRequest<?> request = parseSingleDocWriteRequest(body);
        // Verify the content type was detected as SMILE
        assertNotNull("Requests should not be null", requests);
    }
import org.opensearch.common.lucene.uid.Versions;
        IndexOperation indexOperation = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
                                            .build()
        BulkRequestBody createBody = createBodyBuilder().putExtraFieldValues("vector", binaryPackedFloatValue(packFloatLE(5.5f, 6.5f)))
            false
                                    .setSource("ctx._source.field = 'updated'")
    public void testDetectMediaTypeUnrecognizable() {
    public void testByteStringToBytesReferenceEmpty() {
        DocWriteRequest<?>[] requests = BulkRequestParserProtoUtils.getDocWriteRequests(
            "default-id",
                                    .setLang(
            )
            UnsafeByteOperations.unsafeWrap(cborDocument),
    public void testGetDocWriteRequestsWithExtraFieldValuesOnIndex() {
            "default-index",
            .setXId("test-id")
            createOp,
        assertEquals("Content type should be CBOR", "application/cbor", indexRequest.getContentType().mediaType());
        sb.append("\"}");
            .setObject(UnsafeByteOperations.unsafeWrap(document))
            1L,
        assertEquals("Should have 1 request", 1, requests.length);
        UpdateRequest updateRequest = (UpdateRequest) requests[2];
            null,
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
    public void testBuildUpdateRequestWithScriptedUpsert() {
     * Test valueOrDefault for Boolean with null value and non-null globalDefault
        assertEquals("Index should match", "test-index", updateRequest.index());
            UNASSIGNED_PRIMARY_TERM,
        );
    public void testIndexRequestLargeDocumentZeroCopy() {
    }
        assertEquals("Index should match", "test-index", updateRequest.index());
            "default-pipeline",
        assertEquals(
            "default-pipeline",
import org.opensearch.protobufs.DeleteOperation;
            Versions.MATCH_ANY,
        assertNotNull("Source should be set", indexRequest.source());
            null,
            null,
            "default-routing",
    }
        assertNotNull("Result should not be null", result);
        assertEquals("Index should use default", "default-index", indexRequest.index());
    private static BulkRequestBody.Builder createBodyBuilder() {
            UnsafeByteOperations.unsafeWrap(document),
    }
            .setVersionType(org.opensearch.protobufs.VersionType.VERSION_TYPE_EXTERNAL_GTE)
    }
            "default-index",
            .setFloatArrayValue(org.opensearch.protobufs.FloatArrayValue.newBuilder().setValues(floatList.build()).build())
    public void testGetDocWriteRequestsWithUpdateActionDoc() {
        assertNotNull(updateRequest.doc());
        WriteOperation writeOperation = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        );
            VersionType.INTERNAL,
                                    )
            "default-pipeline",
     * Test buildUpdateRequest with upsert request and pipeline
            "default-index",
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        assertEquals("Version should match", 2L, deleteRequest.version());
        assertEquals("application/json", result.mediaTypeWithoutParameters());
            bulkRequestBody,
    public void testBuildUpdateRequestWithUpsertAndPipeline() {
            Versions.MATCH_ANY,
import org.opensearch.index.mapper.extrasource.FloatArrayValue;
        assertEquals("RetryOnConflict should match", 3, updateRequest.retryOnConflict());
            null,
import org.opensearch.protobufs.BulkRequestBody;
        assertFalse("Create flag should be false when opType is null", indexRequest.opType().equals(DocWriteRequest.OpType.CREATE));
            .setPipeline("test-pipeline")
    public void testBuildUpdateRequest() {
            Versions.MATCH_ANY,
        assertTrue("ScriptedUpsert should be true", result.scriptedUpsert());
        byte[] cborUpsert = createCborDocument();
        assertEquals("Content type should be YAML", "application/yaml", indexRequest.getContentType().mediaType());
            null,
            .setIfSeqNo(3)
                    .build()
        assertNotNull("IndexRequest should not be null", indexRequest);
            "default-pipeline",
        DocWriteRequest<?>[] requests = BulkRequestParserProtoUtils.getDocWriteRequests(
        assertNotNull("Source should not be null", indexRequest.source());
            "default-routing",
            .setObject(UnsafeByteOperations.unsafeWrap(document))
            BulkRequest.newBuilder().addBulkRequestBody(body).build(),
            1L,
        assertEquals("Create flag should be true", DocWriteRequest.OpType.CREATE, createRequest.opType());
            false
    private void assertRejectsIndexExtraFieldValue(BinaryFieldValue value) {
        assertEquals(expected.length, floatArrayValue.dimension());
            IllegalArgumentException.class,
            VersionType.INTERNAL,
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOp).build())
        org.opensearch.protobufs.UpdateAction updateAction = org.opensearch.protobufs.UpdateAction.newBuilder().setDoc(docBytes).build();
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOp).build())
    public void testByteStringToBytesReferenceZeroCopy() {
        assertTrue(updateRequest.docAsUpsert());
        builder.endObject();
        assertNotNull("Doc should be set from UpdateAction.doc", updateRequest.doc());
            ExtraFieldValues.EMPTY,
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        builder.startObject();
            2L,
            false
            ExtraFieldValues.EMPTY,
 */
            UNASSIGNED_PRIMARY_TERM,
        BulkRequestBody updateBody = updateBodyBuilder(updateAction).putExtraFieldValues("vector", binaryFloatValues(9.5f, 10.5f)).build();
            .build();
            1,
            false
        assertNotNull("Requests should not be null", requests);
            updateOperation,
     * Test fromProto with empty document bytes (ByteString.EMPTY)
            ExtraFieldValues.EMPTY,
            writeOperation,
            .setUpdateAction(
            null,
    }
            UNASSIGNED_PRIMARY_TERM,
            null,
    }
        assertEquals("Index should match", "test-index", deleteRequest.index());
                            .setInline(
        String jsonWithUnicode = "{\"field\":\"Hello 世界 🌍\"}";
            ExtraFieldValues.EMPTY,
            .build();
                OperationContainer.newBuilder().setIndex(IndexOperation.newBuilder().setXIndex("test-index").build()).build()
    }
        byte[] cborDocument = createCborDocument();
        FloatArrayValue floatArrayValue = (FloatArrayValue) value;
            "default-pipeline",
            0,
    public void testByteStringToBytesReferenceCopy() {
        UpdateRequest updateRequest = new UpdateRequest("test-index", "test-id");
        assertEquals("Pipeline should match", "test-pipeline", indexRequest.getPipeline());
     */
                                    )
            1L,
        // Create JSON document
