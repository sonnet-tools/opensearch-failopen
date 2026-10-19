            .putExtraFieldValues("vector_values", binaryFloatValues(1.5f, 2.5f))
                    .setBinaryLe(FloatBinaryLE.newBuilder().setBytesLe(ByteString.copyFrom(bytes)).setDimension(dimension).build())
    private static void assertFloatArrayValue(ExtraFieldValue value, boolean expectedPackedLE, float... expected) {
                org.opensearch.protobufs.FloatArrayValue.newBuilder()  
            buffer.putFloat(value);  
        assertEquals(expectedPackedLE, floatArrayValue.isPackedLE());
package org.opensearch.transport.grpc.proto.request.document.bulk;
import java.nio.ByteOrder;
        FloatArrayValue floatArrayValue = (FloatArrayValue) value;  
        assertArrayEquals(expected, floatArrayValue.asFloatArray(), 0.0f);  
import org.opensearch.protobufs.FloatList;
                    .setBinaryLe(FloatBinaryLE.newBuilder().setBytesLe(ByteString.copyFrom(bytes)).build())
        }  
                org.opensearch.protobufs.FloatArrayValue.newBuilder()
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(e.getMessage(), e.getMessage().contains("packed_le byte length"));
            .putExtraFieldValues("bad_vector", binaryPackedFloatValue(new byte[] { 1, 2, 3 }))
import java.nio.ByteBuffer;
 * The OpenSearch Contributors require contributions made to  
/*  
        FloatList.Builder floatList = FloatList.newBuilder();  
        assertTrue(value instanceof BytesValue);  
import org.opensearch.protobufs.BulkRequestBody;
        assertFloatArrayValue(extraFieldValues.get("vector_packed"), true, 3.5f, 4.5f);
    private static BinaryFieldValue binaryPackedFloatValue(byte[] bytes, int dimension) {
import org.opensearch.index.mapper.extrasource.BytesValue;  
            floatList.addValues(value);
 * this file be licensed under the Apache-2.0 license or a
    }  
 *
            .putExtraFieldValues("raw_bytes", binaryBytesValue(rawBytes))
        return BinaryFieldValue.newBuilder()
    private static BinaryFieldValue binaryBytesValue(byte... values) {
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;
        return BinaryFieldValue.newBuilder()
        for (float value : values) {
 */  
}
        BulkRequestBody body = BulkRequestBody.newBuilder()  
            .build();
        return BinaryFieldValue.newBuilder()
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(expected.length, floatArrayValue.dimension());
        return BinaryFieldValue.newBuilder()  
    }
    private static void assertBytesValue(ExtraFieldValue value, byte... expected) {
            .setFloatArrayValue(org.opensearch.protobufs.FloatArrayValue.newBuilder().setValues(floatList.build()).build())
        assertTrue(e.getMessage(), e.getMessage().contains("Invalid extra_field_values entry [bad_vector]"));  
            .build();  
    private static byte[] packFloatLE(float... values) {  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ExtraFieldValuesProtoUtils.fromProto(body));
        ByteBuffer buffer = ByteBuffer.allocate(values.length * Float.BYTES).order(ByteOrder.LITTLE_ENDIAN);
    }  
            .build();
        for (float value : values) {
        assertBytesValue(extraFieldValues.get("raw_bytes"), rawBytes);  
            .putExtraFieldValues("vector_packed", binaryPackedFloatValue(packFloatLE(3.5f, 4.5f), 2))  
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.index.mapper.extrasource.FloatArrayValue;  
            .setFloatArrayValue(
        assertNotNull(e.getCause());
    private static BinaryFieldValue binaryPackedFloatValue(byte[] bytes) {  
        }
                    .build()  
        byte[] rawBytes = new byte[] { 0, 1, 2, 127, -128, -1 };
        assertArrayEquals(expected, BytesReference.toBytes(((BytesValue) value).bytes()));
    }  
            )  
        BulkRequestBody body = BulkRequestBody.newBuilder()  
    }
    public void testFromProtoReturnsEmptyForNoExtraFieldValues() {  
import org.opensearch.protobufs.BinaryFieldValue;
    }  
    private static BinaryFieldValue binaryFloatValues(float... values) {
    }  
import org.opensearch.index.mapper.extrasource.ExtraFieldValue;
        assertTrue(value instanceof FloatArrayValue);
    }
            .build();
                    .build()
    }
            .setFloatArrayValue(  
import com.google.protobuf.ByteString;
import org.opensearch.protobufs.FloatBinaryLE;  
    public void testFromProtoRejectsInvalidEntryWithFieldPath() {
            .build();
        assertSame(ExtraFieldValues.EMPTY, ExtraFieldValuesProtoUtils.fromProto(BulkRequestBody.newBuilder().build()));
            .build();
            )
        assertEquals(3, extraFieldValues.values().size());
        return buffer.array();
        ExtraFieldValues extraFieldValues = ExtraFieldValuesProtoUtils.fromProto(body);  
 * compatible open source license.
    public void testFromProtoConvertsSupportedTypes() {
        assertFloatArrayValue(extraFieldValues.get("vector_values"), false, 1.5f, 2.5f);
    }
public class ExtraFieldValuesProtoUtilsTests extends OpenSearchTestCase {
            .setBytesValue(org.opensearch.protobufs.BytesValue.newBuilder().setBytes(ByteString.copyFrom(values)).build())
