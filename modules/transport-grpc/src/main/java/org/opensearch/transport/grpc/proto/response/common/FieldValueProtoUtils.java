 */
            case BigInteger bi -> {
     * @return A Java object representation of the FieldValue, or null if the FieldValue represents null  
            default -> throw new IllegalArgumentException("Cannot convert " + javaObject + " to FieldValue");
            }  
     *  
        }
        } else {  
     * @return A Java object representation of the FieldValue, or null if the FieldValue represents null
            }
        if (fieldValue.hasGeneralNumber()) {
     */  
    private FieldValueProtoUtils() {
                num.setUint64Value(bi.longValue());
 * This class provides methods to transform Java objects of various types (primitives, strings,
                        // Value fits in signed long range, return as Long  
 * and vice versa.  
                fieldValueBuilder.setGeneralNumber(num.build());  
            throw new IllegalArgumentException("FieldValue type not recognized");
 * maps, etc.) into their corresponding Protocol Buffer representations for gRPC communication,
    public static Object fromProto(FieldValue fieldValue, boolean convertStringsToBytesRef) {  
                    throw new IllegalArgumentException("Unsupported general number type: " + generalNumber.getValueCase());
    /**
    }  
                    } else {
                case INT64_VALUE:
                    }
        } else if (fieldValue.hasString()) {  
     * @throws IllegalArgumentException if the FieldValue type is not recognized
            }
     * @param javaObject The Java object to convert
            switch (generalNumber.getValueCase()) {
            return convertStringsToBytesRef ? maybeConvertToBytesRef(fieldValue.getString()) : fieldValue.getString();
                num.setInt32Value(i);
                org.opensearch.protobufs.GeneralNumber.Builder num = org.opensearch.protobufs.GeneralNumber.newBuilder();
    public static void toProto(Object javaObject, FieldValue.Builder fieldValueBuilder) {
        toProto(javaObject, fieldValueBuilder);
 * compatible open source license.
     */
                // Validate that the value is within unsigned long range (0 to 2^64-1)  
     * and converts them to the appropriate Java types.
 * this file be licensed under the Apache-2.0 license or a
     * maybeConvertToBytesRef for consistency with OpenSearch query processing.
import org.opensearch.protobufs.NullValue;
     * Converts a generic Java Object to its Protocol Buffer FieldValue representation.  
                        return Numbers.toUnsignedBigInteger(uint64Value);
                case UINT64_VALUE:
     */
     * This method handles various Java types (Integer, Long, Double, Float, String, Boolean, Enum, Map)
    /**
            case null -> fieldValueBuilder.setNullValue(NullValue.NULL_VALUE_NULL);
     *  
import static org.opensearch.index.query.AbstractQueryBuilder.maybeConvertToBytesRef;  
        } else if (fieldValue.hasNullValue()) {
                default:  
                fieldValueBuilder.setGeneralNumber(num.build());
     * @param javaObject The Java object to convert
import org.opensearch.protobufs.FieldValue;
                org.opensearch.protobufs.GeneralNumber.Builder num = org.opensearch.protobufs.GeneralNumber.newBuilder();
            case String s -> fieldValueBuilder.setString(s);
package org.opensearch.transport.grpc.proto.response.common;
     * and converts them to the appropriate Java types. String values are processed through  
    /**  
     * @param convertStringsToBytesRef Whether to process string values through maybeConvertToBytesRef
     */
                case DOUBLE_VALUE:
import org.opensearch.common.Numbers;  
            return fieldValue.getBool();  
     * This method handles various FieldValue types (GeneralNumber, String, Boolean, NullValue)
 */  
        if (fieldValue == null) {
        return fromProto(fieldValue, true);
            }
            org.opensearch.protobufs.GeneralNumber generalNumber = fieldValue.getGeneralNumber();  
                    // If the value doesn't fit in a signed long (i.e., it's negative when interpreted as signed),  
                Numbers.toUnsignedLongExact(bi);
                num.setInt64Value(l);
            case Integer i -> {  
                fieldValueBuilder.setGeneralNumber(num.build());  
     * @param fieldValueBuilder The builder to populate with the Java object data
            case Double d -> {
                    return generalNumber.getInt32Value();  
                fieldValueBuilder.setGeneralNumber(num.build());  
/*  
     *  
    /**
            return null;
     * @return A Protocol Buffer FieldValue representation of the Java object
                fieldValueBuilder.setGeneralNumber(num.build());
                case FLOAT_VALUE:  
                // bi.longValue() preserves the bit pattern for correct uint64 encoding  
    public static FieldValue toProto(Object javaObject) {
                org.opensearch.protobufs.GeneralNumber.Builder num = org.opensearch.protobufs.GeneralNumber.newBuilder();
                    return generalNumber.getDoubleValue();  
    }  
     * @throws IllegalArgumentException if the Java object type cannot be converted  
     * @param fieldValue The Protocol Buffer FieldValue to convert
        } else if (fieldValue.hasBool()) {
                org.opensearch.protobufs.GeneralNumber.Builder num = org.opensearch.protobufs.GeneralNumber.newBuilder();
        return fieldValueBuilder.build();
                // Convert to long for protobuf uint64 representation
                // BigInteger is used for unsigned_long fields in OpenSearch
     * Converts a generic Java Object to its Protocol Buffer FieldValue representation.  
    }  
                    if (uint64Value < 0) {
     * @throws IllegalArgumentException if the FieldValue type is not recognized
            }
 *
 * The OpenSearch Contributors require contributions made to  
}
        }  
                case INT32_VALUE:
                num.setDoubleValue(d);  
    }
                    return generalNumber.getInt64Value();
 * Utility class for converting between generic Java objects and Protocol Buffer FieldValue type.  
     * Converts a Protocol Buffer FieldValue to its corresponding Java object representation.
     * This method handles various FieldValue types (GeneralNumber, String, Boolean, NullValue)
     * @param fieldValue The Protocol Buffer FieldValue to convert  
        switch (javaObject) {  
            }
     * It handles various Java types (Integer, Long, Double, Float, String, Boolean, Enum, BigInteger, Map)
                        // Value exceeds Long.MAX_VALUE, convert to BigInteger using unsigned interpretation  
            case Boolean b -> fieldValueBuilder.setBool(b);
     * and converts them to the appropriate FieldValue type.
     * Converts a Protocol Buffer FieldValue to its corresponding Java object representation.  
            case Enum<?> e -> fieldValueBuilder.setString(e.toString());  
    }  
                        return uint64Value;
                    return generalNumber.getFloatValue();
                num.setFloatValue(f);
/**
            case Long l -> {
 * SPDX-License-Identifier: Apache-2.0
import java.math.BigInteger;
     * and converts them to the appropriate FieldValue type.
            return null;
        FieldValue.Builder fieldValueBuilder = FieldValue.newBuilder();  
            case Float f -> {  
    public static Object fromProto(FieldValue fieldValue) {
        }  
public class FieldValueProtoUtils {
     * @throws IllegalArgumentException if the Java object type cannot be converted  
                    // return BigInteger to preserve the unsigned value. Otherwise return Long for efficiency.
                org.opensearch.protobufs.GeneralNumber.Builder num = org.opensearch.protobufs.GeneralNumber.newBuilder();  
     *
                    long uint64Value = generalNumber.getUint64Value();
