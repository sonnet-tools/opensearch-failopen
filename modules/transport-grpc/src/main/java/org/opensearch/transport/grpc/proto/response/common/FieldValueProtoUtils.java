     * @return A Java object representation of the FieldValue, or null if the FieldValue represents null
                num.setFloatValue(f);
                Numbers.toUnsignedLongExact(bi);
        }
     * This method handles various Java types (Integer, Long, Double, Float, String, Boolean, Enum, Map)
import org.opensearch.protobufs.NullValue;
     * and converts them to the appropriate FieldValue type.
            }
/*
 * Utility class for converting between generic Java objects and Protocol Buffer FieldValue type.
            }
    private FieldValueProtoUtils() {
    public static Object fromProto(FieldValue fieldValue, boolean convertStringsToBytesRef) {
     * @throws IllegalArgumentException if the Java object type cannot be converted
                // Convert to long for protobuf uint64 representation
                    return generalNumber.getFloatValue();
 * SPDX-License-Identifier: Apache-2.0
                    }
            case null -> fieldValueBuilder.setNullValue(NullValue.NULL_VALUE_NULL);
            }
     * @param javaObject The Java object to convert
     * Converts a generic Java Object to its Protocol Buffer FieldValue representation.
     *
        } else {
                // bi.longValue() preserves the bit pattern for correct uint64 encoding
                        return Numbers.toUnsignedBigInteger(uint64Value);
     */
        } else if (fieldValue.hasString()) {
/**
    public static Object fromProto(FieldValue fieldValue) {
            return null;
                org.opensearch.protobufs.GeneralNumber.Builder num = org.opensearch.protobufs.GeneralNumber.newBuilder();
        if (fieldValue.hasGeneralNumber()) {
     * maybeConvertToBytesRef for consistency with OpenSearch query processing.
            case Boolean b -> fieldValueBuilder.setBool(b);
                fieldValueBuilder.setGeneralNumber(num.build());
                org.opensearch.protobufs.GeneralNumber.Builder num = org.opensearch.protobufs.GeneralNumber.newBuilder();
     * This method handles various FieldValue types (GeneralNumber, String, Boolean, NullValue)
import static org.opensearch.index.query.AbstractQueryBuilder.maybeConvertToBytesRef;
                    } else {
            return convertStringsToBytesRef ? maybeConvertToBytesRef(fieldValue.getString()) : fieldValue.getString();
                    // return BigInteger to preserve the unsigned value. Otherwise return Long for efficiency.
 * This class provides methods to transform Java objects of various types (primitives, strings,
                default:
            default -> throw new IllegalArgumentException("Cannot convert " + javaObject + " to FieldValue");
     *
    }
     * Converts a Protocol Buffer FieldValue to its corresponding Java object representation.
    public static void toProto(Object javaObject, FieldValue.Builder fieldValueBuilder) {
                    return generalNumber.getDoubleValue();
     * @param convertStringsToBytesRef Whether to process string values through maybeConvertToBytesRef
        switch (javaObject) {
     * @param fieldValue The Protocol Buffer FieldValue to convert
        } else if (fieldValue.hasNullValue()) {
import java.math.BigInteger;
            case Float f -> {
            }
     * and converts them to the appropriate Java types.
        }
                num.setInt32Value(i);
     *
                org.opensearch.protobufs.GeneralNumber.Builder num = org.opensearch.protobufs.GeneralNumber.newBuilder();
package org.opensearch.transport.grpc.proto.response.common;
                    throw new IllegalArgumentException("Unsupported general number type: " + generalNumber.getValueCase());
            case Enum<?> e -> fieldValueBuilder.setString(e.toString());
 * The OpenSearch Contributors require contributions made to
            case Long l -> {
                case UINT64_VALUE:
 * this file be licensed under the Apache-2.0 license or a
 */
 *
    /**
 */
import org.opensearch.common.Numbers;
                case INT32_VALUE:
            case Integer i -> {
                org.opensearch.protobufs.GeneralNumber.Builder num = org.opensearch.protobufs.GeneralNumber.newBuilder();
            }
            case Double d -> {
                fieldValueBuilder.setGeneralNumber(num.build());
                num.setUint64Value(bi.longValue());
     * It handles various Java types (Integer, Long, Double, Float, String, Boolean, Enum, BigInteger, Map)
     * @throws IllegalArgumentException if the FieldValue type is not recognized
        if (fieldValue == null) {
    /**
                    if (uint64Value < 0) {
                org.opensearch.protobufs.GeneralNumber.Builder num = org.opensearch.protobufs.GeneralNumber.newBuilder();
            }
                    return generalNumber.getInt64Value();
                fieldValueBuilder.setGeneralNumber(num.build());
                        return uint64Value;
import org.opensearch.protobufs.FieldValue;
        return fieldValueBuilder.build();
                fieldValueBuilder.setGeneralNumber(num.build());
     * @param javaObject The Java object to convert
}
     * Converts a Protocol Buffer FieldValue to its corresponding Java object representation.
            throw new IllegalArgumentException("FieldValue type not recognized");
    }
 * and vice versa.
     * @return A Protocol Buffer FieldValue representation of the Java object
     * @param fieldValueBuilder The builder to populate with the Java object data
    public static FieldValue toProto(Object javaObject) {
     */
                case FLOAT_VALUE:
                        // Value exceeds Long.MAX_VALUE, convert to BigInteger using unsigned interpretation
     * and converts them to the appropriate FieldValue type.
                    // If the value doesn't fit in a signed long (i.e., it's negative when interpreted as signed),
    }
                    long uint64Value = generalNumber.getUint64Value();
            switch (generalNumber.getValueCase()) {
     * @throws IllegalArgumentException if the FieldValue type is not recognized
            case BigInteger bi -> {
     */
        toProto(javaObject, fieldValueBuilder);
    /**
            return fieldValue.getBool();
    /**
    }
            case String s -> fieldValueBuilder.setString(s);
        return fromProto(fieldValue, true);
     */
                num.setDoubleValue(d);
 * compatible open source license.
        } else if (fieldValue.hasBool()) {
     * @throws IllegalArgumentException if the Java object type cannot be converted
     * and converts them to the appropriate Java types. String values are processed through
            return null;
public class FieldValueProtoUtils {
 * maps, etc.) into their corresponding Protocol Buffer representations for gRPC communication,
                case INT64_VALUE:
        }
     * @param fieldValue The Protocol Buffer FieldValue to convert
            org.opensearch.protobufs.GeneralNumber generalNumber = fieldValue.getGeneralNumber();
                // BigInteger is used for unsigned_long fields in OpenSearch
                        // Value fits in signed long range, return as Long
     * @return A Java object representation of the FieldValue, or null if the FieldValue represents null
                case DOUBLE_VALUE:
                // Validate that the value is within unsigned long range (0 to 2^64-1)
        FieldValue.Builder fieldValueBuilder = FieldValue.newBuilder();
                    return generalNumber.getInt32Value();
    }
     *
     * This method handles various FieldValue types (GeneralNumber, String, Boolean, NullValue)
                num.setInt64Value(l);
     * Converts a generic Java Object to its Protocol Buffer FieldValue representation.
                fieldValueBuilder.setGeneralNumber(num.build());
