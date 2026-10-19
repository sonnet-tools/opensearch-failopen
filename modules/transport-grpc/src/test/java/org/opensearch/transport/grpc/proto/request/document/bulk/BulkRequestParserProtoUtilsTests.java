                    .build()
        IndexOperation indexOp = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
    public void testBuildIndexRequestWithNullOpType() {
        assertEquals("Index should use default", "default-index", deleteRequest.index());  
        FloatList.Builder floatList = FloatList.newBuilder();
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value1\"}"))
        assertEquals("IfSeqNo should be set", 123L, result.ifSeqNo());  
        MediaType result = BulkRequestParserProtoUtils.detectMediaType((BytesReference) null);  
        assertNotNull("Source should be set", indexRequest.source());  
                org.opensearch.protobufs.UpdateAction.newBuilder()
            .setRouting("test-routing")
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOp).build())  
            UNASSIGNED_PRIMARY_TERM,
        assertFloatArrayValue(updateRequest.doc().extraFieldValues().get("vector"), false, 9.5f, 10.5f);
        IndexOperation indexOperation = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();  
            UnsafeByteOperations.unsafeWrap(document),  
        expectThrows(IllegalArgumentException.class, () -> parseSingleDocWriteRequest(indexBodyWithExtraField("field", value)));
            ExtraFieldValues.EMPTY,
    }
            Versions.MATCH_ANY,
            ExtraFieldValues.EMPTY,
        assertEquals("Index should match", "test-index", indexRequest.index());
        assertFloatArrayValue(updateRequest.upsertRequest().extraFieldValues().get("vector"), false, 3.5f, 4.5f);
            deleteOperation,
            )
                            .build()
            1,  
        byte[] document = "{\"doc\":{\"field\":\"value\"}}".getBytes(StandardCharsets.UTF_8);
    }
                    .setCreate(WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build())  
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value\"}"))
            .build();
    public void testBuildDeleteRequestWithDefaults() {  
        BulkRequestBody indexBody = BulkRequestBody.newBuilder()
            .setUpdateAction(org.opensearch.protobufs.UpdateAction.newBuilder().setScriptedUpsert(true).build())
        IndexRequest indexRequest = (IndexRequest) requests[0];
        UpdateRequest result = BulkRequestParserProtoUtils.fromProto(
    public void testGetDocWriteRequestsRejectsInvalidExtraFieldValueWithFieldPath() {  
import com.google.protobuf.UnsafeByteOperations;
            "default-pipeline",
        ByteBuffer buffer = ByteBuffer.allocate(values.length * Float.BYTES).order(ByteOrder.LITTLE_ENDIAN);  
            "default-index",
            Versions.MATCH_ANY,
            .build();  
            null, // defaultRouting is null, should use global routing
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()  
        builder.field("field", "value");
        for (int i = 0; i < 200; i++) {
            VersionType.INTERNAL,  
     * Test ByteString to BytesReference conversion with empty ByteString  
            VersionType.INTERNAL,
        assertTrue("DocAsUpsert should match", updateRequest.docAsUpsert());
        );
                OperationContainer.newBuilder()
            VersionType.INTERNAL,
            "default-pipeline",
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
            .setFloatArrayValue(
    public void testGetDocWriteRequestsRejectsUpdateExtraFieldValuesWithoutDocOrUpsert() {
            1,  
                    )
    public void testGetDocWriteRequestsWithExtraFieldValuesOnUpdateDocAndUpsert() {  
            .setIfPrimaryTerm(4)  
        assertNotNull("UpdateRequest should not be null", updateRequest);
            null,
            Versions.MATCH_ANY,  
            writeOperation,  
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
        StringBuilder sb = new StringBuilder("{\"data\":\"");  
                    .setUpsert(ByteString.copyFromUtf8("{\"upsert_field\":\"upsert_value\"}"))
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
import org.opensearch.protobufs.OperationContainer;
    /**  
            )  
            VersionType.INTERNAL,  
            1L,
        assertNotNull("UpdateRequest should not be null", updateRequest);
            "default-index",  
            Versions.MATCH_ANY,
            false
     */
        UpdateRequest updateRequest = new UpdateRequest("test-index", "test-id");
        assertEquals("Create flag should be true", DocWriteRequest.OpType.CREATE, indexRequest.opType());
        assertEquals("Version should match", 2L, indexRequest.version());
            2L,
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOp).build())
            "default-index",
        );  
        assertEquals("Source content should match", new String(document, StandardCharsets.UTF_8), indexRequest.source().utf8ToString());
        );
        assertTrue("Content type should be JSON", indexRequest.getContentType().mediaType().startsWith("application/json"));
        byte[] document = "{\"doc\":{\"field\":\"value\"}}".getBytes(StandardCharsets.UTF_8);
            updateRequest,
            indexOp,
        );
            "default-id",
            "default-index",  
        assertEquals("Id should match", "test-id-3", updateRequest.id());
            "default-index",
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(  
            2L,
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(  
        UpdateRequest updateRequest = parseSingleUpdateRequest(updateBody);  
        );
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            )
        assertTrue("RequireAlias should use global value", indexRequest.isRequireAlias());
        DocWriteRequest<?>[] requests = BulkRequestParserProtoUtils.getDocWriteRequests(request, "default-index", null, null, null, false);
            Versions.MATCH_ANY,  
    public void testGetDocWriteRequestsWithUpdateDocOnlyExtraFieldValues() {
                    .build()  
            false
        assertEquals("Pipeline should use custom value", "custom-pipeline", indexRequest.getPipeline());  
            indexOperation,  
        for (float value : values) {  
            .build();
            .build();
        return org.opensearch.core.common.bytes.BytesReference.toBytes(org.opensearch.core.common.bytes.BytesReference.bytes(builder));
            "default-pipeline",
    public void testIndexRequestLargeDocumentZeroCopy() {
            .setOperationContainer(  
                "default-routing",
            "default-id",
            IllegalArgumentException.class,
            null,
        assertEquals("Content type should be CBOR", "application/cbor", indexRequest.getContentType().mediaType());
            UnsafeByteOperations.unsafeWrap(docBytes),
        return BulkRequestBody.newBuilder()  
        assertNotNull("IndexRequest should not be null", indexRequest);
                            )
    public void testBuildCreateRequestWithYamlContent() throws Exception {
        BulkRequestBody updateBody = BulkRequestBody.newBuilder()
            "default-routing",
            false  
            Versions.MATCH_ANY,
            null,
                org.opensearch.protobufs.FloatArrayValue.newBuilder()  
        );  
        assertNotNull("FetchSource should be set", result.fetchSource());
            "default-pipeline",
        UpdateOperation updateOperation = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            false
            1,  
     */  
import org.opensearch.index.mapper.extrasource.FloatArrayValue;  
        assertEquals("Id should match", "test-id", updateRequest.id());  
        assertNotNull("IndexRequest should not be null", indexRequest);
                                org.opensearch.protobufs.InlineScript.newBuilder()  
        );  
        assertNotNull(updateRequest.upsertRequest());
    }  
        assertArrayEquals(expected, BytesReference.toBytes(((BytesValue) value).bytes()));  
        assertNotNull("Upsert should be set", result.upsertRequest());
            "default-routing",
            .build();
            null,
        byte[] upsertDoc = "{\"upsert_field\":\"upsert_value\"}".getBytes(StandardCharsets.UTF_8);
        );
            request,
        DeleteOperation deleteOperation = DeleteOperation.newBuilder().build();
    /**
        OpType opType = org.opensearch.protobufs.OpType.OP_TYPE_CREATE;
            "default-id",
        assertNotNull(updateRequest.doc());
            "default-index",
            ByteString.EMPTY,
            UnsafeByteOperations.unsafeWrap(yamlDocument),
        );
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(  
    }  
            .setUpdateAction(
        assertEquals("Index should match", "test-index", indexRequest.index());
            .build();
import org.opensearch.protobufs.UpdateOperation;
            indexOperation,
import org.opensearch.core.common.bytes.BytesReference;  
            ExtraFieldValues.EMPTY,  
            null,
                                    .setSource("ctx._source.counter += 1")
        assertEquals("VersionType should match", VersionType.INTERNAL, indexRequest.versionType());
                                            .build()  
    }  
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOp).build())  
            .setDoc(ByteString.copyFromUtf8("{\"field\":\"updated\"}"))  
            .setOperationContainer(OperationContainer.newBuilder().setDelete(deleteOp).build())
    private static BinaryFieldValue binaryPackedFloatValue(byte[] bytes) {
            IllegalArgumentException.class,  
    private byte[] createSmileDocument() throws Exception {
     */
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            updateOperation,
            writeOperation,  
    }  
        IndexOperation indexOperation = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();  
import org.opensearch.common.lucene.uid.Versions;
        assertTrue("ScriptedUpsert should be true", result.scriptedUpsert());
        );
            "default-index",
import java.nio.ByteBuffer;  
            VersionType.INTERNAL,
            () -> BulkRequestParserProtoUtils.getDocWriteRequests(
            "default-id",
        assertEquals("Source should be empty", 0, indexRequest.source().length());  
        assertNotNull("Doc should not be null", updateRequest.doc());  
        assertNotNull("IndexRequest should not be null", indexRequest);
            .build();
            .setUpdateAction(org.opensearch.protobufs.UpdateAction.newBuilder().setDocAsUpsert(true).setDetectNoop(true).build())
            "default-id",
            "default-index",  
        expectThrows(IllegalArgumentException.class, () -> parseSingleDocWriteRequest(deleteBody));
            .setRouting("test-routing")  
    public void testGetDocWriteRequestsRejectsPackedFloatDimensionMismatch() {
            .build();
            .setObject(UnsafeByteOperations.unsafeWrap(document))  
            UNASSIGNED_PRIMARY_TERM,  
        assertTrue("RequireAlias should match", updateRequest.isRequireAlias());
        );  
            "default-routing",
        WriteOperation writeOperation = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            "default-routing",  
     */  
            1L,
        assertEquals("Version should match", 2L, indexRequest.version());  
        assertTrue("Content type should be JSON", indexRequest.getContentType().mediaType().startsWith("application/json"));  
        byte[] jsonDocument = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        UpdateOperation updateOp = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            2L,
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOperation).build())  
                    .setDelete(DeleteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build())
        DeleteRequest deleteRequest = BulkRequestParserProtoUtils.buildDeleteRequest(
            false
        assertEquals("application/json", result.mediaTypeWithoutParameters());
            1L,  
        BulkRequestBody createBody = createBodyBuilder().putExtraFieldValues("vector", binaryPackedFloatValue(packFloatLE(5.5f, 6.5f)))  
        assertEquals("Index should match", "test-index", indexRequest.index());  
    }
        assertTrue("Fourth request should be a DeleteRequest", requests[3] instanceof DeleteRequest);
     */
        byte[] cborUpsert = createCborDocument();
            .setIfSeqNo(3)  
            ExtraFieldValues.EMPTY,
            .setRetryOnConflict(3)  
            null,
            .setRequireAlias(true)
            .setOperationContainer(OperationContainer.newBuilder().setIndex(indexOp).build())  
        MediaType result = BulkRequestParserProtoUtils.detectMediaType(new BytesArray(invalidBytes));  
        assertNotNull("Requests should not be null", requests);  
            .setUpdateAction(org.opensearch.protobufs.UpdateAction.newBuilder().setDoc(UnsafeByteOperations.unsafeWrap(document)).build())  
        DocWriteRequest<?>[] requests = BulkRequestParserProtoUtils.getDocWriteRequests(
                                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
        }
        assertEquals("Index should match", "test-index", indexRequest.index());  
        WriteOperation createOp = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        byte[] upsertBytes = "{\"field\":\"default_value\"}".getBytes(StandardCharsets.UTF_8);
     */
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
            "default-pipeline",
            VersionType.INTERNAL,  
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
    public void testGetDocWriteRequests() {  
        assertNotNull("Source should not be null", indexRequest.source());
            null,  
            .setUpdateAction(updateAction)
            null,
            false
        assertNotNull("DeleteRequest should not be null", deleteRequest);  
        assertNotNull("IndexRequest should not be null", indexRequest);
        );
            false
     * Test create request with UTF-8 encoded document using UnsafeByteOperations.unsafeWrap()
        assertNotNull(updateRequest.doc());
            SequenceNumbers.UNASSIGNED_PRIMARY_TERM  
            null,  
            .setXId("test-id")
            null,  
    }
        assertNotNull("Upsert should not be null", updateRequest.upsertRequest());
    }  
            .build();
    private void assertRejectsIndexExtraFieldValue(BinaryFieldValue value) {  
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(
            .setDoc(UnsafeByteOperations.unsafeWrap(docBytes))
        result = BulkRequestParserProtoUtils.detectMediaType(new BytesArray(new byte[0]));  
        IllegalArgumentException e = expectThrows(
    /**
        // Verify the content is correct
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
            .setUpsert(UnsafeByteOperations.unsafeWrap(upsertBytes))  
            UnsafeByteOperations.unsafeWrap(document),
        assertEquals("IfPrimaryTerm should match", 4L, deleteRequest.ifPrimaryTerm());
        assertFloatArrayValue(indexRequest.extraFieldValues().get("vector_packed"), true, 3.5f, 4.5f);
        assertNotNull("IndexRequest should not be null", indexRequest);
        ByteString byteString = ByteString.EMPTY;  
                                        org.opensearch.protobufs.ScriptLanguage.newBuilder()
        assertFloatArrayValue(updateRequest.doc().extraFieldValues().get("vector"), false, 3.5f, 4.5f);  
            UnsafeByteOperations.unsafeWrap(cborDocument),  
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(
            )
        assertEquals("Should have 1 request", 1, requests.length);
        assertEquals("IfSeqNo should use default", 1L, deleteRequest.ifSeqNo());
            Versions.MATCH_ANY,
    private static byte[] packFloatLE(float... values) {
                                        org.opensearch.protobufs.ScriptLanguage.newBuilder()
            )  
            null,  
            buffer.putFloat(value);
/*  
        assertNotNull("UpdateRequest should not be null", updateRequest);
    }
            .build();
            .build();
            UnsafeByteOperations.unsafeWrap(document),  
            .build();
        IndexRequest indexRequest = (IndexRequest) requests[0];  
            .build();
import org.opensearch.index.mapper.extrasource.ExtraFieldValue;
    }
            UnsafeByteOperations.unsafeWrap(jsonDocument),
    }  
            UnsafeByteOperations.unsafeWrap(document),  
        return org.opensearch.core.common.bytes.BytesReference.toBytes(org.opensearch.core.common.bytes.BytesReference.bytes(builder));
        );
            ExtraFieldValues.EMPTY,
        assertNotNull("UpdateRequest should not be null", updateRequest);
        assertEquals("Should have 0 requests", 0, requests.length);
            false
            .setUpdateAction(  
        assertEquals("Id should match", "test-id", indexRequest.id());
    }
            false
            UnsafeByteOperations.unsafeWrap(yamlDocument),
    }  
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);  
        );  
            null,
        ByteString docBytes = UnsafeByteOperations.unsafeWrap(document);
        // Create JSON document
            123L,
        byte[] jsonDocument = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
    private byte[] createCborDocument() throws Exception {
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);  
            .setVersionType(org.opensearch.protobufs.VersionType.VERSION_TYPE_EXTERNAL)
                                    )  
            false
        assertTrue(e.getMessage(), e.getMessage().contains("Invalid extra_field_values entry [bad_vector]"));  
        byte[] rawBytes = new byte[] { 0, 1, 2, 127, -128, -1 };
        assertTrue("Request should be an UpdateRequest", requests[0] instanceof UpdateRequest);  
            "Second request should be an IndexRequest with create=true",  
 * SPDX-License-Identifier: Apache-2.0
        BulkRequest request = BulkRequest.newBuilder()
            false
            UnsafeByteOperations.unsafeWrap(emptyDocument),
            .setObject(UnsafeByteOperations.unsafeWrap(document))
        assertEquals("Script source should match", "ctx._source.field = 'updated'", updateRequest.script().getIdOrCode());  
            "default-index",
            VersionType.INTERNAL,
     * Test ByteString to BytesReference conversion with ByteString.copyFrom()  
            deleteOperation,
            false
        WriteOperation createOp = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        // Create CBOR-encoded upsert document
        byte[] invalidBytes = new byte[] { (byte) 0xFF, (byte) 0xFE, (byte) 0xFD, (byte) 0xFC };
    }
        ).putExtraFieldValues("vector", binaryFloatValues(7.5f, 8.5f)).build();
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        assertEquals("Should have 4 requests", 4, requests.length);  
    public void testGetDocWriteRequestsWithEmptyList() {  
    /**
        assertNotNull("Source should be set", indexRequest.source());
                    .build()  
import com.google.protobuf.ByteString;
            request,
        assertFloatArrayValue(indexRequest.extraFieldValues().get("vector"), true);
                                    .setSource("ctx._source.field = 'updated'")  
        );  
        assertNotNull("IndexRequest should not be null", indexRequest);
    }
    public void testBuildCreateRequestWithEmptyDocument() {
        );  
        UpdateOperation updateOperation = UpdateOperation.newBuilder().build();
            "default-index",  
                                    .setSource("ctx._source.field = 'updated'")
            ExtraFieldValues.EMPTY,
            sb.append("0123456789");
        // Verify the content type was detected as SMILE
            updateOperation,
            UnsafeByteOperations.unsafeWrap(document),  
    }
                            .setInline(
    }
            .setIfPrimaryTerm(5)
        assertRejectsIndexExtraFieldValue(binaryPackedFloatValue(new byte[] { 1, 2, 3 }));  
        assertEquals("Id should match", "test-id", indexRequest.id());
import org.opensearch.index.mapper.extrasource.BytesValue;  
            .setUpdateAction(updateAction)
            1L,  
        builder.field("field", "value");  
            UnsafeByteOperations.unsafeWrap(document),
                        org.opensearch.protobufs.Script.newBuilder()
    }
            () -> parseSingleDocWriteRequest(indexBodyWithExtraField("bad_vector", binaryPackedFloatValue(new byte[] { 1, 2, 3 })))  
            .build();
            "default-id",  
        assertNotNull("IndexRequest should not be null", indexRequest);
        return BinaryFieldValue.newBuilder()
                        org.opensearch.protobufs.Script.newBuilder()
                                org.opensearch.protobufs.InlineScript.newBuilder()  
            .addBulkRequestBody(deleteBody)
        assertEquals("Index should match", "test-index", indexRequest.index());
            null,
        assertNotNull("Source should be set", indexRequest.source());
     */
        UpdateRequest result = BulkRequestParserProtoUtils.fromProto(
            .setObject(UnsafeByteOperations.unsafeWrap(document))
    public void testBuildIndexRequestWithSmileContent() throws Exception {
            "default-routing",  
        assertEquals("IfPrimaryTerm should match", 4L, indexRequest.ifPrimaryTerm());
            "default-routing",
        UpdateOperation updateOp = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
     * Test ByteString to BytesReference conversion with UnsafeByteOperations.unsafeWrap()
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            updateOperation,
        assertEquals(
        assertNotNull(e.getCause());
        assertNotNull("IndexRequest should not be null", indexRequest);
        expectThrows(
        UpdateOperation updateOperation = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();  
            null, // Pass null to test global pipeline
    public void testBuildIndexRequestWithOpType() {  
        DeleteOperation deleteOperation = DeleteOperation.newBuilder()  
        );  
    public void testFromProtoWithNullDocumentBytes() {  
            .build();  
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(  
            .setPipeline("test-pipeline")
import org.opensearch.protobufs.BulkRequestBody;
        assertFloatArrayValue(indexRequest.extraFieldValues().get("vector_values"), false, 1.5f, 2.5f);
            .build();
            "default-routing",  
            Versions.MATCH_ANY,
        assertNotNull("Source should not be null", indexRequest.source());
        );  
        // Empty document should default to JSON
        assertEquals("IfSeqNo should match", 3L, indexRequest.ifSeqNo());
        byte[] docBytes = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        assertFalse("DetectNoop should be false", result.detectNoop());
            UnsafeByteOperations.unsafeWrap(document),
            UnsafeByteOperations.unsafeWrap(document),  
                    .setXSource(org.opensearch.protobufs.SourceConfig.newBuilder().setFetch(true).build())
    public void testGetDocWriteRequestsWithInvalidOperation() {  
     */  
            "default-pipeline",
        assertNotNull("Upsert should be set", result.upsertRequest());
        IndexRequest indexRequest = parseSingleIndexRequest(indexBodyWithExtraField("vector", binaryFloatValues()));  
    }
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
            UNASSIGNED_PRIMARY_TERM
import org.opensearch.index.seqno.SequenceNumbers;
        DocWriteRequest<?>[] requests = BulkRequestParserProtoUtils.getDocWriteRequests(  
                                org.opensearch.protobufs.InlineScript.newBuilder()
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOperation).build())
        org.opensearch.protobufs.UpdateAction updateAction = org.opensearch.protobufs.UpdateAction.newBuilder().setDoc(docBytes).build();  
            null,
            .setUpdateAction(
        assertTrue("First request should be an IndexRequest", requests[0] instanceof IndexRequest);
import org.opensearch.protobufs.OpType;  
            "default-id",
            updateRequest.upsertRequest().source().utf8ToString()
            ExtraFieldValues.EMPTY,  
            VersionType.INTERNAL,
        assertEquals("Routing should use default", "default-routing", indexRequest.routing());
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
        );
     * Test detectMediaType with null or empty document  
        );
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
     */
                    .setUpdate(UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build())
            null,  
    private static BulkRequestBody.Builder updateBodyBuilder(org.opensearch.protobufs.UpdateAction updateAction) {  
        WriteOperation writeOp = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id-2").build();
            VersionType.INTERNAL,
        assertTrue("DetectNoop should match", updateRequest.detectNoop());  
    /**
        }  
        byte[] yamlDocument = createYamlDocument();  
        // Verify the content type was detected as YAML
            1L,  
            .build();
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
     * Test update request with upsert field using UnsafeByteOperations.unsafeWrap()
    private static BulkRequestBody.Builder deleteBodyBuilder() {
        byte[] document = jsonWithUnicode.getBytes(StandardCharsets.UTF_8);  
        assertNotNull("Requests should not be null", requests);
            2L,
            null,
                            .build()
    public void testValueOrDefaultStringWithNullValue() {  
        assertNotNull("Upsert should not be null", updateRequest.upsertRequest());
        IndexRequest indexRequest = parseSingleIndexRequest(indexBody);
            ExtraFieldValues.EMPTY,  
            .setUpdateAction(org.opensearch.protobufs.UpdateAction.newBuilder().setUpsert(ByteString.copyFrom(upsertDoc)).build())  
        UpdateOperation updateOperation = UpdateOperation.newBuilder()
    }
                    .setXSource(org.opensearch.protobufs.SourceConfig.newBuilder().setFetch(false).build())
        assertNotNull("Source should not be null", indexRequest.source());
            Versions.MATCH_ANY,  
            .setOperationContainer(OperationContainer.newBuilder().setCreate(writeOp).build())  
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);  
    }
            "default-pipeline",
        BulkRequest request = BulkRequest.newBuilder().addBulkRequestBody(invalidBody).build();  
        UpdateRequest updateRequest = new UpdateRequest("test-index", "test-id");
            ExtraFieldValues.EMPTY,
        return indexBodyBuilder().putExtraFieldValues(field, value).build();  
        assertEquals("Pipeline should match", "test-pipeline", indexRequest.getPipeline());
            byteString,  
        BulkRequestBody updateBody = updateBodyBuilder(
        );
            null,
            "default-index",
            ExtraFieldValues.EMPTY,
        assertEquals("Source length should match", document.length, indexRequest.source().length());  
    }
        assertEquals("IfSeqNo should match", 3L, deleteRequest.ifSeqNo());  
        builder.startObject();  
            )
        byte[] document = "{\"doc\":{\"field\":\"value\"}}".getBytes(StandardCharsets.UTF_8);  
            .setVersion(2)
        assertEquals("Create flag should be true", DocWriteRequest.OpType.CREATE, indexRequest.opType());
     * Test fromProto with null document bytes
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
    }
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
public class BulkRequestParserProtoUtilsTests extends OpenSearchTestCase {  
            request,
    /**  
    }
        IndexRequest createRequest = (IndexRequest) requests[1];
        assertNotNull("Requests should not be null", requests);  
            1,
        assertFalse("RequireAlias should use default", indexRequest.isRequireAlias());
        assertNotNull("Script should be set", result.script());  
        assertNotNull("UpdateRequest should not be null", updateRequest);  
            indexOperation,
        assertNotNull("IndexRequest should not be null", indexRequest);  
            VersionType.INTERNAL,  
            ExtraFieldValues.EMPTY,  
            .build();  
            .setPipeline("test-pipeline")
            1L,
            .setUpdateAction(org.opensearch.protobufs.UpdateAction.newBuilder().setUpsert(ByteString.copyFrom(cborUpsert)).build())
        assertFloatArrayValue(updateRequest.doc().extraFieldValues().get("vector"), false, 7.5f, 8.5f);
            .setOperationContainer(OperationContainer.newBuilder().setIndex(indexOp).build())
            null, // Pass null to test global routing  
        );
package org.opensearch.transport.grpc.proto.request.document.bulk;
        assertRejectsIndexExtraFieldValue(binaryPackedFloatValue(packFloatLE(1.5f), -1));
            "default-id",
            .setDoc(ByteString.copyFromUtf8("{\"field\":\"updated\"}"))
            updateOperation,  
     * Helper method to create a YAML-encoded document.
    }  
            UNASSIGNED_PRIMARY_TERM,
    }
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(  
                OperationContainer.newBuilder().setIndex(IndexOperation.newBuilder().setXIndex("test-index").build()).build()  
    public void testBuildIndexRequestWithAllFields() {  
        assertFloatArrayValue(createRequest.extraFieldValues().get("vector"), true, 5.5f, 6.5f);  
            false
            .setFloatArrayValue(org.opensearch.protobufs.FloatArrayValue.newBuilder().setValues(floatList.build()).build())
            .setOperationContainer(
        );  
    }
            false
            false  
            .build();
    public void testFromProtoWithEmptyDocumentBytes() {
            writeOperation,
            "default-index",
            .setVersion(2)  
            bulkRequestBody,
        assertEquals("Index should match", "test-index", deleteRequest.index());
        // Create JSON document  
        assertEquals("Id should match", "test-id", indexRequest.id());
        assertEquals("Routing should match", "test-routing", indexRequest.routing());
            null,  
        assertEquals("Index should match", "test-index", updateRequest.index());
        // Create YAML-encoded document  
            bulkRequestBody,
            null,
        assertEquals("Index should match", "test-index", indexRequest.index());
        UpdateOperation updateOp = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            VersionType.INTERNAL,  
        assertNotNull("Source should be set", indexRequest.source());
            request,  
        IndexRequest createRequest = parseSingleIndexRequest(createBody);  
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()  
        assertEquals("Content type should be CBOR", "application/cbor", indexRequest.getContentType().mediaType());  
            "default-routing",
            .build();
            "default-index",
            .build();  
            VersionType.INTERNAL,  
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
        assertEquals("Id should match", "test-id", indexRequest.id());
            false  
        // Create CBOR-encoded document  
    }  
    private byte[] createYamlDocument() throws Exception {  
            false
    /**
 *
    }
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
    /**  
     * Test index request with large document using UnsafeByteOperations.unsafeWrap()
                request,
        assertNotNull("Source should be set", indexRequest.source());
            1L,  
            ExtraFieldValues.EMPTY,
    /**
        org.opensearch.core.xcontent.XContentBuilder builder = org.opensearch.common.xcontent.XContentFactory.yamlBuilder();
            .build();
    }
        assertNotNull("Result should not be null", result);  
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()  
     */
            .setUpsert(ByteString.copyFrom(upsertBytes))
            "default-id",  
        BulkRequest request = BulkRequest.newBuilder()
            )
    public void testDetectMediaTypeNullOrEmpty() {
        // Create a large document (> 1KB)
            updateOperation,
            "default-routing",
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
import org.opensearch.action.update.UpdateRequest;  
                            .setInline(
            "default-index",
        assertEquals("Index should match", "test-index", indexRequest.index());  
        DeleteRequest deleteRequest = BulkRequestParserProtoUtils.buildDeleteRequest(  
    public void testBuildUpdateRequestWithScriptedUpsert() {
        FloatArrayValue floatArrayValue = (FloatArrayValue) value;
        assertNotNull("IndexRequest should not be null", indexRequest);
     */
            UNASSIGNED_PRIMARY_TERM,
        BulkRequestBody indexBody = indexBodyBuilder().putExtraFieldValues("raw_bytes", binaryBytesValue(rawBytes))
            indexOperation,
        BulkRequestBody updateBody = updateBodyBuilder(updateAction).putExtraFieldValues("vector", binaryFloatValues(9.5f, 10.5f)).build();
                                    .build()
        );
    }
        IndexOperation indexOperation = IndexOperation.newBuilder()
            ExtraFieldValues.EMPTY,  
        assertNotNull("Upsert should be set", updateRequest.upsertRequest());
     */
        assertEquals("Source content should match", new String(document, StandardCharsets.UTF_8), indexRequest.source().utf8ToString());
            )  
        );  
                    .setDetectNoop(false)
import org.opensearch.index.VersionType;
        assertEquals("application/json", result.mediaTypeWithoutParameters());
            requests[1] instanceof IndexRequest && ((IndexRequest) requests[1]).opType().equals(DocWriteRequest.OpType.CREATE)
            .setVersionType(org.opensearch.protobufs.VersionType.VERSION_TYPE_EXTERNAL_GTE)
    }  
        assertTrue("RequireAlias should use global value", indexRequest.isRequireAlias());  
            .setObject(UnsafeByteOperations.unsafeWrap(document))
            UnsafeByteOperations.unsafeWrap(document),
            .build();
    public void testBuildUpdateRequestWithUpsert() {  
                                            .build()
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(  
            null,  
            null,
            null  // Pass null to test global requireAlias  
                    )
        org.opensearch.protobufs.UpdateAction updateAction = org.opensearch.protobufs.UpdateAction.newBuilder()
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        ByteString byteString = UnsafeByteOperations.unsafeWrap(document);
            BulkRequest.newBuilder().addBulkRequestBody(body).build(),  
        assertNotNull("Script should be set", result.script());
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(  
            null,
        assertEquals("Id should match", "test-id", indexRequest.id());  
        assertEquals("Routing should match", "test-routing", updateRequest.routing());  
            false
                                    .setLang(
        assertNotNull("Result should not be null", result);
        // Verify the content type was detected as CBOR
        assertEquals("Content type should be YAML", "application/yaml", indexRequest.getContentType().mediaType());
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
            false
        );
            "default-id",  
            UnsafeByteOperations.unsafeWrap(smileDocument),  
     */
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOp).build())
        byte[] document = "{\"doc\":{\"field\":\"value\"}}".getBytes(StandardCharsets.UTF_8);
            1L,
        org.opensearch.core.xcontent.XContentBuilder builder = org.opensearch.common.xcontent.XContentFactory.cborBuilder();
            )
    private static BinaryFieldValue binaryPackedFloatValue(byte[] bytes, int dimension) {  
                org.opensearch.protobufs.UpdateAction.newBuilder()
        assertNotNull("Doc should not be null", updateRequest.doc());  
        assertEquals("Version should match", 2L, deleteRequest.version());
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
            .build();
            "default-id",  
            .build();
            .setRequireAlias(true)
    private DocWriteRequest<?> parseSingleDocWriteRequest(BulkRequestBody body) {
            1L,
        assertTrue("First request should be an IndexRequest", requests[0] instanceof IndexRequest);
                org.opensearch.protobufs.FloatArrayValue.newBuilder()
    public void testValueOrDefaultBooleanWithNullValue() {
                                    .build()
        assertBytesValue(indexRequest.extraFieldValues().get("raw_bytes"), rawBytes);  
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
            .setObject(UnsafeByteOperations.unsafeWrap(document))  
     * This tests the copy path where ByteString creates an internal copy
    }  
            ExtraFieldValues.EMPTY,  
        assertNotNull("UpdateRequest should not be null", updateRequest);
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
            null,
            .setObject(UnsafeByteOperations.unsafeWrap(document))
        assertNotNull("UpdateRequest should not be null", updateRequest);
        WriteOperation writeOperation = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        );
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
            null,
        assertNotNull("UpdateRequest should not be null", updateRequest);  
            .setXIndex("test-index")
            bulkRequestBody,  
    }  
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        byte[] upsertDoc = "{\"upsert_field\":\"upsert_value\"}".getBytes(StandardCharsets.UTF_8);
            updateOperation,
    }  
        assertFalse("Create flag should be false for INDEX opType", indexRequest.opType().equals(DocWriteRequest.OpType.CREATE));
            UnsafeByteOperations.unsafeWrap(document),  
        UpdateRequest updateRequest = parseSingleUpdateRequest(updateBody);
        assertNotNull("Result should not be null", result);
                        org.opensearch.protobufs.Script.newBuilder()  
        UpdateRequest updateRequest = (UpdateRequest) requests[2];  
            null,
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            docBytes,  
        assertEquals("Source content should match UTF-8", jsonWithUnicode, indexRequest.source().utf8ToString());  
        assertEquals("VersionType should match", VersionType.EXTERNAL, indexRequest.versionType());  
            "default-id",
            1,  
            indexOperation,
        return (UpdateRequest) request;
        UpdateRequest updateRequest = new UpdateRequest("test-index", "test-id");
            UNASSIGNED_PRIMARY_TERM,
    private static BinaryFieldValue binaryFloatValues(float... values) {
        );  
            bulkRequestBody,  
    public void testBuildCreateRequestWithPipeline() {
        IndexRequest indexRequest = parseSingleIndexRequest(indexBodyWithExtraField("vector", binaryPackedFloatValue(new byte[0])));  
        assertEquals(expected.length, floatArrayValue.dimension());
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(
     * Test update request with doc field using UnsafeByteOperations.unsafeWrap()
            false  
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
        org.opensearch.protobufs.UpdateAction updateAction = org.opensearch.protobufs.UpdateAction.newBuilder()
        assertEquals("Id should match", "test-id", indexRequest.id());  
            ExtraFieldValues.EMPTY,  
            bulkRequestBody,
            Versions.MATCH_ANY,
        byte[] document = "{\"field\":\"updated_value\"}".getBytes(StandardCharsets.UTF_8);
        UpdateRequest result = BulkRequestParserProtoUtils.fromProto(  
        return BinaryFieldValue.newBuilder()  
import org.opensearch.protobufs.FloatList;
    }
        assertEquals("Id should match", "test-id-4", deleteRequest.id());  
        BulkRequestBody updateBody = BulkRequestBody.newBuilder()
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;
    /**
        return BinaryFieldValue.newBuilder()  
 * The OpenSearch Contributors require contributions made to  
        assertEquals("Id should use default", "default-id", deleteRequest.id());
            bulkRequestBody,
        return requests[0];
            VersionType.INTERNAL,
        assertEquals("RetryOnConflict should match", 3, updateRequest.retryOnConflict());
        assertEquals("Id should match", "test-id-1", indexRequest.id());
            2L,  
            .putExtraFieldValues("vector_packed", binaryPackedFloatValue(packFloatLE(3.5f, 4.5f), 2))
            ExtraFieldValues.EMPTY,
    }
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOperation).build())
        assertEquals("Index should match", "test-index", indexRequest.index());
            2L
            0,
        builder.endObject();
    public void testGetDocWriteRequestsWithUpdateDocAsUpsertExtraFieldValues() {
import java.nio.ByteOrder;
            indexOperation,
        return buffer.array();
            .setXId("test-id")
                            .build()  
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
            1L,
            .build();  
        // Create YAML-encoded document
            2L,  
            "default-id",  
        assertEquals("Should have 1 request", 1, requests.length);
            .setRouting("test-routing")  
            .build();
        assertEquals("Doc content should match", new String(document, StandardCharsets.UTF_8), updateRequest.doc().source().utf8ToString());
        assertTrue("Third request should be an UpdateRequest", requests[2] instanceof UpdateRequest);  
            .build();
    public void testBuildCreateRequestWithSmileContent() throws Exception {
        // Verify the content type was detected as YAML  
     * This tests the zero-copy path where ByteString wraps a byte array  
        UpdateOperation updateOp = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();  
            null,  
        byte[] emptyDocument = new byte[0];
        );  
                                        org.opensearch.protobufs.ScriptLanguage.newBuilder()  
        org.opensearch.protobufs.UpdateAction updateAction = org.opensearch.protobufs.UpdateAction.newBuilder()  
            updateOperation,
    }
    public void testGetDocWriteRequestsRejectsEmptyBinaryFieldValue() {
        assertNotNull("UpdateRequest should not be null", updateRequest);
                    .build()
            UNASSIGNED_PRIMARY_TERM  
        assertEquals("Index should match", "test-index", updateRequest.index());
    }  
            "default-index",
    }
            "default-index",  
        assertEquals("IfPrimaryTerm should match", 2L, indexRequest.ifPrimaryTerm());
    /**  
            "default-index",  
            .setIfSeqNo(3)
            .build();
            UnsafeByteOperations.unsafeWrap(document),
                "default-pipeline",  
            1L,
}
        // Verify the content type was detected as SMILE  
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value3\"}"))  
    }  
    public void testBuildUpdateRequest() {
            false  
        assertEquals("Id should match", "test-id", indexRequest.id());
    }
            .setUpsert(ByteString.copyFromUtf8("{\"field\":\"created\"}"))  
            "default-routing",
            "default-routing",
    public void testBuildUpdateRequestWithoutUpdateAction() {
            ByteString.copyFrom(docBytes),  
    public void testGetDocWriteRequestsRejectsExtraFieldValuesOnDelete() {
            .setXId("test-id")
        assertRejectsIndexExtraFieldValue(emptyFloatArray);
     * Test valueOrDefault for Boolean with null value and non-null globalDefault  
            ExtraFieldValues.EMPTY,
    }  
        assertRejectsIndexExtraFieldValue(BinaryFieldValue.newBuilder().build());
            "test-pipeline", // pipeline
            "default-id",
        assertNotNull("FetchSource should be set", updateRequest.fetchSource());
        assertNotNull("Source should be set", indexRequest.source());  
    }  
            .setBytesValue(org.opensearch.protobufs.BytesValue.newBuilder().setBytes(ByteString.copyFrom(values)).build())  
            .setObject(UnsafeByteOperations.unsafeWrap(document))  
        WriteOperation writeOperation = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();  
        assertEquals("IfPrimaryTerm should be set", 456L, result.ifPrimaryTerm());
        );
        assertEquals("VersionType should use default", VersionType.INTERNAL, deleteRequest.versionType());
            .build();
    private static BulkRequestBody.Builder indexBodyBuilder() {  
        byte[] cborDocument = createCborDocument();
            1L,  
        DocWriteRequest<?>[] requests = BulkRequestParserProtoUtils.getDocWriteRequests(
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
            null,  
            .build();
    }
        return org.opensearch.core.common.bytes.BytesReference.toBytes(org.opensearch.core.common.bytes.BytesReference.bytes(builder));  
            "default-index",
            VersionType.INTERNAL,
        assertEquals("Routing should match", "test-routing", indexRequest.routing());
        }  
        assertEquals(  
            UnsafeByteOperations.unsafeWrap(jsonDocument),  
            )  
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(  
            1L,
                                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
            1L,
    }
            updateOp,  
                    .build()
            "default-index",  
    }
            null,
            null,
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
        assertEquals("Create flag should be true", DocWriteRequest.OpType.CREATE, createRequest.opType());
    public void testBuildUpdateRequestWithFetchSource() {  
        );
            null,
            "default-index",  
            "default-id",  
    public void testGetDocWriteRequestsWithUpdateActionDoc() {
            "default-routing",
            .setUpdateAction(
        builder.field("field", "value");
        assertEquals("Should have 1 request", 1, requests.length);
        byte[] upsertBytes = "{\"field\":\"default_value\"}".getBytes(StandardCharsets.UTF_8);  
            .setIfSeqNo(4)
            .build();  
import org.opensearch.protobufs.FloatBinaryLE;  
        UpdateRequest updateRequest = (UpdateRequest) requests[0];
                    .setBinaryLe(FloatBinaryLE.newBuilder().setBytesLe(ByteString.copyFrom(bytes)).setDimension(dimension).build())
    }
        );
            UNASSIGNED_PRIMARY_TERM,
        );
    /**
            1L,
        assertEquals("Id should match", "test-id-2", createRequest.id());  
        BinaryFieldValue emptyFloatArray = BinaryFieldValue.newBuilder()  
            .setUpdateAction(
            "default-index",
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(
            .setIfPrimaryTerm(4)
            bulkRequestBody,
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOp).build())
            "default-id",
            .setFloatArrayValue(
                    .setScript(  
        // Create SMILE-encoded document
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(
        assertEquals("application/json", result.mediaTypeWithoutParameters());
            "default-index",  
import org.opensearch.action.delete.DeleteRequest;
            .setUpdateAction(updateAction)
    }
            .setRequireAlias(true)  
import org.opensearch.protobufs.BinaryFieldValue;
            ExtraFieldValues.EMPTY,
            "default-id",
            .setObject(UnsafeByteOperations.unsafeWrap(document))  
        assertEquals("Pipeline should match", "default-pipeline", indexRequest.getPipeline());  
            .setRequireAlias(true)  
        assertEquals("Version should use default", 1L, deleteRequest.version());  
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
        assertEquals("Id should use default", "default-id", indexRequest.id());
        assertEquals("Doc content should match", new String(docBytes, StandardCharsets.UTF_8), updateRequest.doc().source().utf8ToString());
            "default-routing",
                            .setInline(  
    /**
        );  
            );
            .putExtraFieldValues("vector", binaryFloatValues(1.5f))  
        assertEquals("Index should match", "test-index", indexRequest.index());  
            ExtraFieldValues.EMPTY,  
        assertEquals("IfPrimaryTerm should match", 4L, indexRequest.ifPrimaryTerm());  
            UNASSIGNED_PRIMARY_TERM,
import org.opensearch.test.OpenSearchTestCase;
                    )
        assertTrue(e.getMessage(), e.getMessage().contains("packed_le byte length"));
        IndexOperation indexOp = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();  
            "default-routing",
    }
        assertEquals("Routing should use global value", "global-routing", indexRequest.routing());
    }  
        byte[] document = "{\"doc\":{\"field\":\"value\"}}".getBytes(StandardCharsets.UTF_8);  
            VersionType.INTERNAL,
        assertEquals("Id should match", "test-id", indexRequest.id());  
        UpdateOperation updateOperation = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            null,
            bulkRequestBody,
            "default-index",
        assertEquals(DocWriteRequest.OpType.CREATE, createRequest.opType());
            UnsafeByteOperations.unsafeWrap(document),
    /**
        return BinaryFieldValue.newBuilder()
            bulkRequestBody,
        assertEquals("Index should match", "test-index", indexRequest.index());  
            2L,  
            .setOperationContainer(OperationContainer.newBuilder().setIndex(indexOp).build())
        );
            "default-index",
            VersionType.INTERNAL,  
            "default-index",
            bulkRequestBody,
        assertNotNull("IndexRequest should not be null", indexRequest);
            byteString,
        UpdateRequest result = BulkRequestParserProtoUtils.fromProto(
            "default-index",
import org.opensearch.protobufs.DeleteOperation;
            .addBulkRequestBody(indexBody)
 * compatible open source license.
     */  
            "default-routing",
            "default-id",
            "default-routing",  
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
                                    .setLang(
            UNASSIGNED_PRIMARY_TERM,
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
            indexOperation,
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOperation).build())
                            .setInline(
 * this file be licensed under the Apache-2.0 license or a
            1,
            "default-id",
            null,
            1L,  
        WriteOperation createOp = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        BulkRequestBody updateBody = updateBodyBuilder(org.opensearch.protobufs.UpdateAction.newBuilder().setDetectNoop(false).build())
            "default-routing",  
    }
        assertTrue("DocAsUpsert should be true", result.docAsUpsert());  
    public void testBuildCreateRequestWithDefaults() {  
            "default-id",
            "default-index",  
        assertNotNull("IndexRequest should not be null", indexRequest);
        assertRejectsIndexExtraFieldValue(binaryPackedFloatValue(packFloatLE(1.5f, 2.5f), 3));  
        assertNotNull("Source should not be null", indexRequest.source());
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
        DocWriteRequest<?>[] requests = BulkRequestParserProtoUtils.getDocWriteRequests(
            "default-index",  
        assertTrue(updateRequest.docAsUpsert());
        assertEquals("IfSeqNo should match", 4L, updateRequest.ifSeqNo());
        assertTrue(request instanceof UpdateRequest);  
    private static BulkRequestBody.Builder createBodyBuilder() {
            .setOperationContainer(
            false
        DeleteOperation deleteOp = DeleteOperation.newBuilder().setXIndex("test-index").setXId("test-id-4").build();
        assertNotNull("Script should be set", result.script());
    public void testBuildUpdateRequestWithUpsertAndPipeline() {
            "default-id",  
            .setXIndex("test-index")
            writeOperation,
        assertBytesValue(indexRequest.extraFieldValues().get("raw_bytes"));
        assertEquals("Index should use default", "default-index", indexRequest.index());  
                org.opensearch.protobufs.UpdateAction.newBuilder()  
            .setUpdateAction(org.opensearch.protobufs.UpdateAction.newBuilder().setUpsert(ByteString.copyFrom(upsertDoc)).build())
            "default-routing",
            null,
    public void testBuildIndexRequestWithCborContent() throws Exception {
    /**
            "default-pipeline",  
            .build();  
            "default-index",
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(  
            "default-pipeline",
        WriteOperation writeOperation = WriteOperation.newBuilder().setPipeline("custom-pipeline").build();
            2L,
            UNASSIGNED_PRIMARY_TERM,  
            .setRequireAlias(true)
        assertNotNull("Source should be set", indexRequest.source());
        assertNotNull("Doc should be set from UpdateAction.doc", updateRequest.doc());  
        assertEquals("Pipeline should use default", "default-pipeline", indexRequest.getPipeline());  
        assertEquals("IfSeqNo should match", 3L, indexRequest.ifSeqNo());  
import org.opensearch.action.index.IndexRequest;
        return BulkRequestBody.newBuilder()
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(  
            null,  
            ExtraFieldValues.EMPTY,  
     */  
            .setXIndex("test-index")  
            ExtraFieldValues.EMPTY,
        assertEquals("Index should match", "test-index", indexRequest.index());  
import org.opensearch.core.xcontent.MediaType;
            .setFloatArrayValue(org.opensearch.protobufs.FloatArrayValue.newBuilder().build())
        UpdateOperation updateOp = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id-3").build();  
            "default-index",
        return (IndexRequest) request;
            false
    }  
        assertEquals("Pipeline should use global value", "global-pipeline", indexRequest.getPipeline());
    }
            "default-routing",
                                org.opensearch.protobufs.InlineScript.newBuilder()
            createOp,  
            ExtraFieldValues.EMPTY,
                                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)  
    public void testGetDocWriteRequestsWithExtraFieldValuesOnIndex() {  
                org.opensearch.protobufs.UpdateAction.newBuilder()
        IndexOperation indexOperation = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            2L,
        assertEquals("Index should match", "test-index", indexRequest.index());
            null,  
    }
        WriteOperation writeOperation = WriteOperation.newBuilder()  
        assertEquals("Content type should be SMILE", "application/smile", indexRequest.getContentType().mediaType());  
            "default-id",
        assertTrue("RequireAlias should match", indexRequest.isRequireAlias());
    }
    public void testGetDocWriteRequestsWithExtraFieldValuesOnCreate() {
        assertEquals("Index should match", "test-index", indexRequest.index());
            bulkRequestBody,
        BulkRequestBody updateBody = updateBodyBuilder(updateAction).putExtraFieldValues("vector", binaryFloatValues(3.5f, 4.5f)).build();  
            "default-id",  
     * Test detectMediaType with unrecognizable format
     * Test fromProto with empty document bytes (ByteString.EMPTY)
    public void testGetDocWriteRequestsWithEmptyPackedFloatExtraFieldValue() {
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOperation).build())
        for (float value : values) {
                    .build()
        assertTrue(value instanceof FloatArrayValue);
    }
            bulkRequestBody,  
        WriteOperation createOp = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();  
        assertEquals("Routing should match", "test-routing", deleteRequest.routing());  
    }
            "Upsert content should match",  
            0,
        builder.endObject();  
            .setOperationContainer(
                                        org.opensearch.protobufs.ScriptLanguage.newBuilder()  
    public void testUpdateRequestUpsertFieldZeroCopy() {
    }
        assertNotNull("Source should not be null", indexRequest.source());  
        assertTrue(value instanceof BytesValue);
            updateRequest,
            UNASSIGNED_PRIMARY_TERM,
        assertNull(updateRequest.upsertRequest());
    public void testBuildDeleteRequest() {
        ByteString byteString = ByteString.copyFrom(document);
            null,  
        );
        DocWriteRequest<?>[] requests = BulkRequestParserProtoUtils.getDocWriteRequests(  
            "default-index",
    public void testByteStringToBytesReferenceEmpty() {
    }  
    private static BinaryFieldValue binaryBytesValue(byte... values) {
        // Test with null documentBytes  
                                            .build()
            "default-id",
            VersionType.INTERNAL,
            .build();
            "default-pipeline",  
            "default-id",
        // Create SMILE-encoded document
            writeOperation,
            null,
    public void testBuildIndexRequestWithJsonContent() throws Exception {
    public void testFromProtoWithAllUpdateActionFields() {
            UNASSIGNED_PRIMARY_TERM,
                    .build()  
            .setIfSeqNo(3)  
    }
        assertNotNull("Requests should not be null", requests);  
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value\"}"));  
            "default-routing",
            UnsafeByteOperations.unsafeWrap(document),
    public void testGetDocWriteRequestsWithGlobalValues() {  
        assertEquals("Index should match", "test-index", indexRequest.index());
        byte[] cborDocument = createCborDocument();
        assertNotEquals("Create flag should be false", DocWriteRequest.OpType.CREATE, indexRequest.opType());  
            null,
     * Test getDocWriteRequests with update operation using UpdateAction.doc field  
        assertTrue("ScriptedUpsert should be true", updateRequest.scriptedUpsert());  
            Versions.MATCH_ANY,  
            "default-routing",
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        builder.startObject();
            "default-index",  
        BulkRequestBody createBody = BulkRequestBody.newBuilder()
            .build();
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
                                    .build()
            .build();
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOperation).build())  
     * Test update request with both doc and upsert fields using ByteString.copyFrom()
            org.opensearch.protobufs.UpdateAction.newBuilder().setDoc(ByteString.copyFromUtf8("{\"field\":\"updated\"}")).build()  
            1L,
            bulkRequestBody,
            "default-index",
            false
                                            .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
    }
        assertNotNull("Script should be set", updateRequest.script());
    }
        UpdateOperation updateOperation = UpdateOperation.newBuilder().setIfSeqNo(123L).setIfPrimaryTerm(456L).build();
            updateRequest.upsertRequest().source().utf8ToString()  
                            )
     * Test buildUpdateRequest with upsert request and pipeline
        IndexOperation indexOp = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
            "default-pipeline",
        assertEquals("Index should match", "test-index", indexRequest.index());
        builder.endObject();
            UNASSIGNED_PRIMARY_TERM,  
        DocWriteRequest<?> request = parseSingleDocWriteRequest(body);
        assertEquals("Pipeline should match", "test-pipeline", indexRequest.getPipeline());
            ExtraFieldValues.EMPTY,  
            "default-routing",
    public void testGetDocWriteRequestsWithEmptyBytesExtraFieldValue() {
            false  
                                    )
        assertNotNull("IndexRequest should not be null", indexRequest);
            "default-routing",
        assertNotNull("IndexRequest should not be null", indexRequest);
            UnsafeByteOperations.unsafeWrap(document),
            null,  
    public void testUpdateRequestDocFieldZeroCopy() {  
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        UpdateRequest updateRequest = (UpdateRequest) requests[0];
            false  
            null,
        // Test with ByteString.EMPTY (no doc field)
        assertTrue(request instanceof IndexRequest);  
            2L,  
            ExtraFieldValues.EMPTY,
            ExtraFieldValues.EMPTY,
        byte[] smileDocument = createSmileDocument();  
    }
            UNASSIGNED_PRIMARY_TERM,
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(
            UnsafeByteOperations.unsafeWrap(document),
        assertEquals("IfSeqNo should match", 1L, indexRequest.ifSeqNo());
            "default-pipeline",
            UnsafeByteOperations.unsafeWrap(cborDocument),
        assertNull("Doc should not be set when documentBytes is null", result.doc());
        assertEquals("VersionType should match", VersionType.EXTERNAL, deleteRequest.versionType());
            updateRequest,  
        UpdateOperation updateOperation = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        DeleteRequest deleteRequest = (DeleteRequest) requests[3];
        );
            .setRouting("global-routing")  
            .setVersion(2)
                    .setScript(
        assertNotNull("DeleteRequest should not be null", deleteRequest);
        );
                    .setScriptedUpsert(true)
    }
        assertEquals("Routing should use global value", "global-routing", updateRequest.routing());
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOperation).build())
            "Upsert content should match",
            VersionType.INTERNAL,
    public void testDetectMediaTypeUnrecognizable() {
import org.opensearch.protobufs.BulkRequest;  
        org.opensearch.core.xcontent.XContentBuilder builder = org.opensearch.common.xcontent.XContentFactory.smileBuilder();  
            Versions.MATCH_ANY,
                            .build()  
    }
    public void testBuildCreateRequestWithJsonContent() throws Exception {  
        BulkRequest request = BulkRequest.newBuilder().addBulkRequestBody(updateBody).build();  
            floatList.addValues(value);
        byte[] document = "{\"doc\":{\"field\":\"value\"}}".getBytes(StandardCharsets.UTF_8);  
        byte[] yamlDocument = createYamlDocument();
            createOp,
            1L,
        assertNotNull("IndexRequest should not be null", indexRequest);  
            .build();
            .addBulkRequestBody(updateBody)
            .setOperationContainer(OperationContainer.newBuilder().setUpdate(updateOp).build())  
            .setXId("test-id")
        // Verify the content type was detected as JSON (may include charset)
            new String(upsertBytes, StandardCharsets.UTF_8),
            false
     * Helper method to create a SMILE-encoded document.  
    /**
            UNASSIGNED_PRIMARY_TERM,  
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
            UnsafeByteOperations.unsafeWrap(document),  
    private static BulkRequestBody indexBodyWithExtraField(String field, BinaryFieldValue value) {
                                            .build()
        assertArrayEquals(expected, floatArrayValue.asFloatArray(), 0.0f);
            .setUpdateAction(updateAction);
            "default-pipeline",  
            0,
        assertNotNull("Upsert request should be set", updateRequest.upsertRequest());  
            .build();  
        assertEquals("VersionType should match", VersionType.EXTERNAL_GTE, indexRequest.versionType());
        assertEquals("Source content should match", new String(document, StandardCharsets.UTF_8), indexRequest.source().utf8ToString());
            1L,
        );  
        );  
            false
            indexOperation,
        assertEquals("Pipeline should be set on upsert request", "test-pipeline", updateRequest.upsertRequest().getPipeline());
        assertNotNull("Requests should not be null", requests);
            ExtraFieldValues.EMPTY,  
            .setXId("test-id")  
                false
            "default-id",  
            "default-pipeline",  
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
            Versions.MATCH_ANY,
                org.opensearch.protobufs.UpdateAction.newBuilder()  
        assertEquals("IfPrimaryTerm should match", 5L, updateRequest.ifPrimaryTerm());  
    }
                    .build()
            .setRouting("test-routing")
            Versions.MATCH_ANY,
import org.opensearch.protobufs.IndexOperation;
            "default-index",  
     */
            .build();  
            .setVersionType(org.opensearch.protobufs.VersionType.VERSION_TYPE_EXTERNAL)  
            bulkRequestBody,
                    .build()
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value1\"}"))
        assertNotNull("Requests should not be null", requests);
            SequenceNumbers.UNASSIGNED_SEQ_NO,
    public void testBuildUpdateRequestWithScript() {
            null,  
            VersionType.INTERNAL,
            ExtraFieldValues.EMPTY,
        IndexRequest indexRequest = parseSingleIndexRequest(indexBodyWithExtraField("raw_bytes", binaryBytesValue()));  
                            )  
            456L
        );
            ExtraFieldValues.EMPTY,
        // Create CBOR-encoded document
            false
            "default-index",
    private IndexRequest parseSingleIndexRequest(BulkRequestBody body) {
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value\"}"));
            "default-id",
            null,  
            VersionType.INTERNAL,
        assertFloatArrayValue(indexRequest.extraFieldValues().get("vector"), false);
            .build();
                "default-index",  
            updateRequest,
    private static void assertBytesValue(ExtraFieldValue value, byte... expected) {
    }  
    public void testBuildCreateRequest() {
            UnsafeByteOperations.unsafeWrap(document),
            writeOperation,
                                    .setLang(
    public void testByteStringToBytesReferenceCopy() {  
    public void testGetDocWriteRequestsRejectsEmptyFloatArrayValue() {
        assertEquals("Index should match", "test-index", updateRequest.index());
            null,  
        IndexOperation indexOperation = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
import org.opensearch.protobufs.WriteOperation;  
        // Verify the content type was detected as JSON (may include charset)
            .addBulkRequestBody(createBody)  
            "default-id",
import org.opensearch.action.DocWriteRequest;  
            false  
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
            null,  
            new String(upsertBytes, StandardCharsets.UTF_8),
        IndexOperation indexOperation = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            0,
        BulkRequestBody updateBody = BulkRequestBody.newBuilder()
            .setIfPrimaryTerm(4)
            OpType.OP_TYPE_INDEX,
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
                    .setDocAsUpsert(true)  
                                    .build()  
        assertEquals("Id should match", "test-id", indexRequest.id());
        WriteOperation writeOperation = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        WriteOperation writeOperation = WriteOperation.newBuilder().build();
    public void testBuildCreateRequestWithCborContent() throws Exception {  
            byteString,
            updateOp,
    public void testByteStringToBytesReferenceZeroCopy() {
        assertNotNull("IndexRequest should not be null", indexRequest);  
        assertTrue(
                    )  
    public void testUpdateRequestDocAndUpsertCopy() {  
        assertNotNull("IndexRequest should not be null", indexRequest);  
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(  
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);  
import org.opensearch.core.common.bytes.BytesArray;
            .setDoc(ByteString.copyFrom(docBytes))
                    .build()
    }
        assertEquals("Should have 1 request", 1, requests.length);
    /**  
            null // defaultRequireAlias is null, should use global requireAlias  
                        org.opensearch.protobufs.Script.newBuilder()
        assertFalse("Create flag should be false when opType is null", indexRequest.opType().equals(DocWriteRequest.OpType.CREATE));
            "default-id",
            ExtraFieldValues.EMPTY,
            UNASSIGNED_PRIMARY_TERM,
            null, // defaultPipeline is null, should use global pipeline  
            false  
            "default-pipeline",
            1L,  
        UpdateOperation updateOperation = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();  
        assertNotNull("Result should not be null", result);  
                                    .setLang(  
            false
    }
        assertNotNull("IndexRequest should not be null", indexRequest);
        BulkRequestBody indexBody = BulkRequestBody.newBuilder()  
        assertEquals("Routing should use default", "default-routing", deleteRequest.routing());
    }  
        expectThrows(IllegalArgumentException.class, () -> parseSingleDocWriteRequest(updateBody));  
        assertEquals(expectedPackedLE, floatArrayValue.isPackedLE());  
                    .setBinaryLe(FloatBinaryLE.newBuilder().setBytesLe(ByteString.copyFrom(bytes)).build())  
     */  
        assertEquals("Id should match", "test-id", updateRequest.id());
            opType,
            .build();
    }
    public void testBuildIndexRequest() {
            "default-pipeline",
        assertEquals("IfPrimaryTerm should use default", 2L, deleteRequest.ifPrimaryTerm());  
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            VersionType.INTERNAL,
            null,
        );  
        WriteOperation writeOperation = WriteOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
        UpdateRequest updateRequest = BulkRequestParserProtoUtils.buildUpdateRequest(  
            "default-pipeline",
            2L,
            "default-routing",
        assertTrue("RequireAlias should match", indexRequest.isRequireAlias());
            2L,  
            createOp,
        byte[] document = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
            "default-index",
        assertEquals("Id should match", "test-id", indexRequest.id());
        assertEquals(1, requests.length);
            VersionType.INTERNAL,
    public void testGetDocWriteRequestsWithEmptyFloatValuesExtraFieldValue() {
            VersionType.INTERNAL,
        assertEquals("Version should match", 1L, indexRequest.version());
        UpdateOperation updateOperation = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();  
    public void testGetDocWriteRequestsRejectsPackedFloatBytesNotMultipleOfFour() {
    private static void assertFloatArrayValue(ExtraFieldValue value, boolean expectedPackedLE, float... expected) {  
        return BulkRequestBody.newBuilder()
        );
            "default-index",
        sb.append("\"}");
    public void testGetDocWriteRequestsRejectsNegativePackedFloatDimension() {  
    private UpdateRequest parseSingleUpdateRequest(BulkRequestBody body) {
        );
        String jsonWithUnicode = "{\"field\":\"Hello 世界 🌍\"}";
    }
            )  
        UpdateOperation updateOp = UpdateOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
                OperationContainer.newBuilder()
            ExtraFieldValues.EMPTY,  
            1L,
            "default-routing",  
        IndexOperation indexOperation = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id").build();
            UNASSIGNED_PRIMARY_TERM,
                                    )  
        DocWriteRequest<?> request = parseSingleDocWriteRequest(body);
        byte[] smileDocument = createSmileDocument();
    }
            .setXIndex("test-index")
        assertEquals("Routing should match", "test-routing", indexRequest.routing());  
        assertEquals("Content type should be SMILE", "application/smile", indexRequest.getContentType().mediaType());
            "default-id",
    public void testCreateRequestUtf8DocumentZeroCopy() {
            false
        assertTrue("Content type should default to JSON", indexRequest.getContentType().mediaType().startsWith("application/json"));  
        );  
    /**
        BulkRequestBody deleteBody = deleteBodyBuilder().putExtraFieldValues("raw_bytes", binaryBytesValue((byte) 1)).build();
            .build();
            "default-id",  
            "default-id",
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildCreateRequest(
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        assertNull(updateRequest.upsertRequest());  
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
            .setXIndex("test-index")  
            .putExtraFieldValues("vector_values", binaryFloatValues(1.5f, 2.5f))  
        assertEquals("Index should match", "test-index", createRequest.index());
            "default-pipeline",
            UNASSIGNED_PRIMARY_TERM,  
    }
        assertNotNull("Source should be set", indexRequest.source());
        BulkRequest request = BulkRequest.newBuilder()
        assertNotNull("IndexRequest should not be null", indexRequest);  
            .addBulkRequestBody(updateBody)
        // Verify the content type was detected as CBOR
 */  
        byte[] document = sb.toString().getBytes(StandardCharsets.UTF_8);
            "default-index",
        byte[] docBytes = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        );
            writeOperation,
            false
        builder.startObject();
        assertNull("Doc should not be set when ByteString is empty", result.doc());  
    }  
        UpdateRequest updateRequest = parseSingleUpdateRequest(updateBody);  
            .addBulkRequestBody(indexBody)  
        return BulkRequestBody.newBuilder()
        IndexOperation indexOp = IndexOperation.newBuilder().setXIndex("test-index").setXId("test-id-1").build();
    }
            updateOp,
        assertNotNull("IndexRequest should not be null", indexRequest);  
        );
            2L  
        assertEquals("Content type should be YAML", "application/yaml", indexRequest.getContentType().mediaType());
     * Test valueOrDefault for String with null value and non-null globalDefault
            .setPipeline("global-pipeline")
            UnsafeByteOperations.unsafeWrap(document),
        DocWriteRequest<?>[] requests = BulkRequestParserProtoUtils.getDocWriteRequests(  
            null,
            false  
        IndexOperation indexOperation = IndexOperation.newBuilder()
                OperationContainer.newBuilder()  
                    .setScript(
            UnsafeByteOperations.unsafeWrap(smileDocument),
            1L,  
     */  
        byte[] document = "{\"doc\":{\"field\":\"value\"}}".getBytes(StandardCharsets.UTF_8);  
                            )
            UNASSIGNED_PRIMARY_TERM,
            UNASSIGNED_PRIMARY_TERM,
    /**
            null,
            "default-pipeline",
            Versions.MATCH_ANY,  
            "default-pipeline",  
        BulkRequestBody bulkRequestBody = BulkRequestBody.newBuilder()
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
        assertNotNull("UpdateRequest should not be null", updateRequest);
            .setDocAsUpsert(true)
        assertEquals("Index should match", "test-index", deleteRequest.index());
        assertTrue("RequireAlias should match", indexRequest.isRequireAlias());  
     */
    }
            .setRouting("global-routing")
            SequenceNumbers.UNASSIGNED_SEQ_NO,
                                    .setSource("ctx._source.counter += 1")
    }
            .setPipeline("global-pipeline")
    public void testUpdateRequestWithCborUpsert() throws Exception {  
        org.opensearch.protobufs.UpdateAction updateAction = org.opensearch.protobufs.UpdateAction.newBuilder()
        UpdateRequest updateRequest = new UpdateRequest("test-index", "test-id");
import java.nio.charset.StandardCharsets;
        BulkRequestBody indexBody = BulkRequestBody.newBuilder()  
        BulkRequestBody invalidBody = BulkRequestBody.newBuilder().build();
                    .setScript(  
        BulkRequest request = BulkRequest.newBuilder().build();
            ExtraFieldValues.EMPTY,  
            "default-index",  
    public void testBuildIndexRequestWithYamlContent() throws Exception {  
            "default-pipeline",
            request,
            createOp,
        );
        IndexRequest indexRequest = (IndexRequest) requests[0];  
        assertNotNull("Source should be set", indexRequest.source());  
            .setObject(ByteString.copyFromUtf8("{\"field\":\"value2\"}"))
        assertNotNull(updateRequest.doc());  
                null,
    }  
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            .setRouting("test-routing")
        BulkRequestBody deleteBody = BulkRequestBody.newBuilder()  
            writeOperation,
            "default-pipeline",
        assertEquals("Id should match", "test-id", deleteRequest.id());
        BulkRequest request = BulkRequest.newBuilder().addBulkRequestBody(indexBody).setRequireAlias(true).build();
            "default-pipeline",
            "default-id",  
     * Helper method to create a CBOR-encoded document.
        IndexRequest indexRequest = BulkRequestParserProtoUtils.buildIndexRequest(  
                                    )
