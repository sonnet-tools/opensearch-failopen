import org.opensearch.core.common.bytes.BytesReference;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.protobufs.InlineGetDictUserDefined;  
        long seqNo = 2;
    public void testToProtoWithNonExistingDocument() throws IOException {  
            null,  
import org.opensearch.test.OpenSearchTestCase;
        long primaryTerm = 3;
        GetResult getResult = new GetResult(index, id, seqNo, primaryTerm, 1, true, source, Collections.emptyMap(), Collections.emptyMap());  
        long version = 1;
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        // Convert to Protocol Buffer
        assertFalse("Should not have source", builder.hasXSource());
        assertTrue("Should be found", get.getFound());  
        assertTrue("Should be found", builder.getFound());
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        String index = "test-index";
            -1,
        );  
    }
}  
 * this file be licensed under the Apache-2.0 license or a
        assertFalse("Should not have primary term", builder.hasXPrimaryTerm());  
            Collections.emptyMap()
        ResponseItem.Builder responseItemBuilder = ResponseItem.newBuilder();  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.get.GetResult;
        assertEquals("Should have the correct index", index, result.getXIndex());
        GetResultProtoUtils.toProtoEmbedded(getResult, builder);
            Collections.emptyMap(),
            true,
        InlineGetDictUserDefined.Builder builder = InlineGetDictUserDefined.newBuilder();  
    public void testToProtoWithExistingDocument() throws IOException {
        byte[] sourceBytes = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
import com.google.protobuf.ByteString;
        GetResult getResult = new GetResult(
        // Convert to Protocol Buffer
            Collections.emptyMap(),
        assertEquals("Should have the correct source", ByteString.copyFrom(sourceBytes), builder.getXSource());
        InlineGetDictUserDefined get = result.getGet();
        assertEquals("Should have the correct primary term", primaryTerm, builder.getXPrimaryTerm());  
    }
            Collections.emptyMap()
        String id = "test-id";  
        long primaryTerm = 3;
        String index = "test-index";  
        // Create a GetResult without source
import org.opensearch.core.common.bytes.BytesArray;
            id,
        ResponseItem.Builder result = GetResultProtoUtils.toProto(getResult, responseItemBuilder);
public class GetResultProtoUtilsTests extends OpenSearchTestCase {
        assertEquals("Should have the correct id", id, result.getXId());
        assertTrue("Should be found", builder.getFound());
        // Create a GetResult for a non-existing document
        assertEquals("Should have the correct version", version, result.getXVersion());  
        InlineGetDictUserDefined.Builder builder = InlineGetDictUserDefined.newBuilder();  
        String id = "test-id";
/*  
        // Convert to Protocol Buffer
    }
        assertEquals("Should have the correct sequence number", seqNo, builder.getXSeqNo());
            index,  
        InlineGetDictUserDefined.Builder builder = InlineGetDictUserDefined.newBuilder();  
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        long seqNo = 2;  
 * compatible open source license.
package org.opensearch.transport.grpc.proto.response.document.get;
            id,
            SequenceNumbers.UNASSIGNED_PRIMARY_TERM,  
import java.nio.charset.StandardCharsets;
        GetResult getResult = new GetResult(
import org.opensearch.protobufs.ResponseItem;
        assertFalse("Should not have sequence number", builder.hasXSeqNo());
            index,  
import java.io.IOException;
            Collections.emptyMap(),
            null,  
        String index = "test-index";  
    public void testToProtoEmbeddedWithoutSource() throws IOException {  
        // Verify the conversion  
        assertEquals("Should have the correct source", ByteString.copyFrom(sourceBytes), get.getXSource());  
        // Verify the conversion  
        );  
            index,  
        BytesReference source = new BytesArray(sourceBytes);  
        byte[] sourceBytes = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);  
        String id = "test-id";
        );  
            Collections.emptyMap()
        byte[] sourceBytes = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        assertFalse("Should not be found", result.getGet().getFound());  
        String id = "test-id";  
 */  
    }
        );  
        ResponseItem.Builder result = GetResultProtoUtils.toProto(getResult, responseItemBuilder);
        GetResultProtoUtils.toProtoEmbedded(getResult, builder);
        // Create a GetResult with sequence number and primary term
            false,
            source,  
        // Source should not be set  
            source,  
        BytesReference source = new BytesArray(sourceBytes);
        GetResult getResult = new GetResult(
        GetResult getResult = new GetResult(
            SequenceNumbers.UNASSIGNED_PRIMARY_TERM,  
    public void testToProtoEmbeddedWithSequenceNumber() throws IOException {  
        // Create a GetResult without sequence number and primary term
        // Verify the conversion  
            Collections.emptyMap()
            1,
            Collections.emptyMap(),
            index,  
        // Convert to Protocol Buffer
        // Create a GetResult for an existing document
            primaryTerm,  
            version,
        assertEquals("Should have the correct source", ByteString.copyFrom(source.toBytesRef().bytes), builder.getXSource());
        assertEquals("Should have the correct id", id, result.getXId());
            true,
import org.opensearch.index.seqno.SequenceNumbers;
import java.util.Collections;  
        ResponseItem.Builder responseItemBuilder = ResponseItem.newBuilder();  
    }
        String id = "test-id";  
            id,
        assertEquals("Should have the correct primary term", primaryTerm, get.getXPrimaryTerm());
        BytesReference source = new BytesArray(sourceBytes);  
            id,
        GetResultProtoUtils.toProtoEmbedded(getResult, builder);
            1,
        // Sequence number and primary term should not be set
        String index = "test-index";
        // Verify the conversion  
        // Convert to Protocol Buffer
 *
        assertEquals("Should have the correct index", index, result.getXIndex());
    public void testToProtoEmbeddedWithoutSequenceNumber() throws IOException {
        // Verify the conversion  
        String index = "test-index";
            true,
        assertEquals("Should have the correct sequence number", seqNo, get.getXSeqNo());
            SequenceNumbers.UNASSIGNED_PRIMARY_TERM,  
            seqNo,
        assertTrue("Should be found", builder.getFound());
