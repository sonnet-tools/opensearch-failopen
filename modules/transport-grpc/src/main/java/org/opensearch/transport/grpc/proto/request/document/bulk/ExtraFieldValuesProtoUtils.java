                out.put(e.getKey(), toExtraFieldValue(e.getValue()));
            throw new IllegalArgumentException(  
            case VALUES: {
        if (dimension == 0) {
final class ExtraFieldValuesProtoUtils {
        }  
package org.opensearch.transport.grpc.proto.request.document.bulk;
                int dim = resolvePackedDimension(bs, fav.getBinaryLe().getDimension(), Float.BYTES, "float");
            }
                    valueType + " packed_le byte length must be multiple of " + bytesPerElement + " but was " + byteLength
                "Bad packed " + valueType + " length=" + byteLength + " expected=" + expectedByteLength + " (dim=" + dimension + ")"
import org.opensearch.index.mapper.extrasource.ExtraFieldValue;  
    private static FloatArrayValue toInternalFloatArrayValue(org.opensearch.protobufs.FloatArrayValue fav) {  
            case BINARY_LE: {
        Map<String, ExtraFieldValue> out = new HashMap<>(Math.max(16, m.size() * 2));
        }  
            if (byteLength % bytesPerElement != 0) {  
                throw new IllegalArgumentException("Invalid extra_field_values entry [" + e.getKey() + "]: " + ex.getMessage(), ex);
/*  
    private static ExtraFieldValue toExtraFieldValue(BinaryFieldValue protoVal) {
import org.opensearch.protobufs.FloatList;
            expectedByteLength = Math.multiplyExact(dimension, bytesPerElement);
                final FloatList fl = fav.getValues();
    private static int resolvePackedDimension(ByteString bytes, int dimension, int bytesPerElement, String valueType) {
        }  
                return toInternalFloatArrayValue(protoVal.getFloatArrayValue());
            }
import com.google.protobuf.ByteString;
            try {
                throw new IllegalArgumentException("FloatArrayValue.repr is not set");
import org.opensearch.index.mapper.extrasource.FloatArrayValue;
                final int count = fl.getValuesCount();  
            default:  
            throw new IllegalArgumentException(valueType + " dimension must be >= 0 but was " + dimension);
        final int expectedByteLength;
                return FloatArrayValue.fromFloatArray(arr);  
import java.util.HashMap;
        }
import org.opensearch.protobufs.BinaryFieldValue;  
            case FLOAT_ARRAY_VALUE: {  
            }
                // Important: Avoid boxing, protobuf uses primitive float list internally
        if (dimension < 0) {  
 * SPDX-License-Identifier: Apache-2.0
        for (Map.Entry<String, BinaryFieldValue> e : m.entrySet()) {  
        }
        }
 * this file be licensed under the Apache-2.0 license or a
        } catch (ArithmeticException e) {
        return new ExtraFieldValues(out);
                final float[] arr = new float[count];
                return new BytesValue(BulkRequestParserProtoUtils.byteStringToBytesReference(protoVal.getBytesValue().getBytes()));
                    arr[i] = fl.getValues(i);
 * Converts protobuf extra field values into OpenSearch extra source values.
            } catch (IllegalArgumentException ex) {  
            }
        return dimension;
            }  
        int byteLength = bytes.size();
    }
import org.opensearch.protobufs.BulkRequestBody;
        switch (fav.getEncodingCase()) {
                );  
    static ExtraFieldValues fromProto(BulkRequestBody body) {
                return FloatArrayValue.fromPackedBytes(BulkRequestParserProtoUtils.byteStringToBytesReference(bs), dim);
    private ExtraFieldValuesProtoUtils() {}  
        try {  
        switch (protoVal.getBinaryFieldValueCase()) {
 *
/**
                throw new IllegalArgumentException("Unsupported/empty BinaryFieldValue: " + protoVal.getBinaryFieldValueCase());
            case BINARYFIELDVALUE_NOT_SET:  
        }  
        if (byteLength != expectedByteLength) {
        if (m.isEmpty()) {
    }  
import org.opensearch.index.mapper.extrasource.BytesValue;
                for (int i = 0; i < count; i++) {  
    }
            return byteLength / bytesPerElement;
            throw new IllegalArgumentException(valueType + " dimension too large: " + dimension, e);  
                throw new IllegalArgumentException(
        Map<String, BinaryFieldValue> m = body.getExtraFieldValuesMap();  
import java.util.Map;
    }
 * compatible open source license.
            case ENCODING_NOT_SET:
            return ExtraFieldValues.EMPTY;
}  
            case BYTES_VALUE: {  
        }  
            }
                final ByteString bs = fav.getBinaryLe().getBytesLe();  
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;
            );
 */  
                }
            default:
 * The OpenSearch Contributors require contributions made to  
 */  
