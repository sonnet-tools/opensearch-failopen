 */  
        assertTrue("Exception message should mention 'Invalid optype'", exception.getMessage().contains("Invalid optype"));
            UnsupportedOperationException.class,
        OpType opType = org.opensearch.protobufs.OpType.UNRECOGNIZED;
}
        OpType opType = org.opensearch.protobufs.OpType.UNRECOGNIZED;
        DocWriteRequest.OpType result = OpTypeProtoUtils.fromProto(opType);
    public void testFromProtoWithOpTypeIndex() {
        assertTrue("Exception message should mention 'Invalid optype'", exception.getMessage().contains("Invalid optype"));
        assertEquals("OP_TYPE_CREATE should convert to DocWriteRequest.OpType.CREATE", DocWriteRequest.OpType.CREATE, result);
 * SPDX-License-Identifier: Apache-2.0
        DocWriteRequest.OpType result = OpTypeProtoUtils.fromProto(opType);  
        );  
    }  
import org.opensearch.protobufs.OpType;
    public void testFromProtoWithUnrecognizedOpType() {
    }  
        );
import org.opensearch.action.DocWriteRequest;
import org.opensearch.test.OpenSearchTestCase;  
/*  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    }
            () -> OpTypeProtoUtils.fromProto(opType)
        UnsupportedOperationException exception = expectThrows(  
 *
        assertEquals("OP_TYPE_INDEX should convert to DocWriteRequest.OpType.INDEX", DocWriteRequest.OpType.INDEX, result);  
        OpType opType = org.opensearch.protobufs.OpType.OP_TYPE_INDEX;  
    }
public class OpTypeProtoUtilsTests extends OpenSearchTestCase {
            () -> OpTypeProtoUtils.fromProto(opType)
    public void testFromProtoWithOpTypeCreate() {
        UnsupportedOperationException exception = expectThrows(
 * compatible open source license.
        OpType opType = org.opensearch.protobufs.OpType.OP_TYPE_CREATE;
package org.opensearch.transport.grpc.proto.request.common;
    public void testFromProtoWithOpTypeUnspecified() {  
            UnsupportedOperationException.class,  
