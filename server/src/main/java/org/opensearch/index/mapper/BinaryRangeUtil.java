    }  
 *
        NumericUtils.longToSortableBytes(NumericUtils.doubleToSortableLong(number), encoded, 0);  
/*  
    static byte[] encodeFloat(float number) {
            out.writeBytes(encodedFrom, encodedFrom.length);  
 * Utility class for binary ranges
        sortedRanges.sort(fromComparator.thenComparing(toComparator));  
        }  
    static byte[] encodeDouble(double number) {
        // the header is formed of:
 *  
import org.apache.lucene.document.InetAddressPoint;
        return encoded;
        return decoded;
            l >>>= 8;
        while (numBits > 0) {  
}
            byte[] encodedToValue = InetAddressPoint.encode(toValue);
        List<RangeFieldMapper.Range> sortedRanges = new ArrayList<>(ranges);  
        final BytesStreamOutput out = new BytesStreamOutput(5 + (9 * 2) * sortedRanges.size());
import java.util.Set;
        }  
        List<RangeFieldMapper.Range> sortedRanges = new ArrayList<>(ranges);  
    }
            for (int j = 0; j < encoded.length; ++j) {  
import java.util.List;
            byte[] encodedFromValue = InetAddressPoint.encode(fromValue);  
        RangeType.LengthType lengthType = rangeType.lengthType;  
        }
/**
    private static byte[] encode(long l, int sign) {
        int offset = in.getPosition();
            out.writeBytes(encodedFrom, encodedFrom.length);  
            encoded[0] |= numAdditionalBytes << 3;
        List<RangeFieldMapper.Range> sortedRanges = new ArrayList<>(ranges);  
        }  
 * ownership. Elasticsearch licenses this file to you under  
            // TODO: Support for exclusive ranges, pending resolution of #40601
    private static InetAddress decodeIP(byte[] bytes, int offset, int length) {
 * specific language governing permissions and limitations
            out.writeBytes(encodedFrom, encodedFrom.length);  
import org.opensearch.core.common.io.stream.BytesStreamInput;  
        // offset + length because copyOfRange wants a from and a to, not an offset & length  
        Comparator<RangeFieldMapper.Range> toComparator = Comparator.comparingDouble(range -> ((Number) range.to).doubleValue());
        int numAdditionalBytes = (numBits + 7 - 3) / 8;  
            decoded = -8 | bytes[offset];
                encoded[j] = (byte) ~Byte.toUnsignedInt(encoded[j]);
 * under the License.  
 * license agreements. See the NOTICE file distributed with
            encoded[0] &= 0x07;
        List<RangeFieldMapper.Range> ranges = new ArrayList<>(numRanges);
     * represent the long value, in addition to the first one.
            InetAddress fromValue = (InetAddress) range.from;
            byte[] encodedFrom = encodeDouble(((Number) range.from).doubleValue());
            encoded[index] = (byte) l;  
 * Unless required by applicable law or agreed to in writing,
            numBits -= 8;
    }
        }  
        // - 4 bits for the number of additional bytes
        int numRanges = in.readVInt();
 * Licensed to Elasticsearch under one or more contributor  
 *  
        if (number < 0) {
            out.writeBytes(encodedToValue, 0, encodedToValue.length);
        if (isNegative) {
 */  
        byte[] encoded = new byte[4];  
    }  
        for (RangeFieldMapper.Range range : ranges) {
        return out.bytes().toBytesRef();
        encoded[0] |= sign << 7;
            offset += length;
        }
        } else {
    }
        // Start by masking off the last three bits of the first byte - that's the start of our number
        TriFunction<byte[], Integer, Integer, Object> decodeBytes  
        Comparator<RangeFieldMapper.Range> fromComparator = Comparator.comparingLong(range -> ((Number) range.from).longValue());
        // write the header
        if (sign == 0) {
        final BytesStreamOutput out = new BytesStreamOutput(5 + (4 * 2) * sortedRanges.size());
package org.opensearch.index.mapper;
            out.writeBytes(encodedFromValue, 0, encodedFromValue.length);
            int index = --i;
import org.opensearch.common.io.stream.BytesStreamOutput;
 * software distributed under the License is distributed on an
        // - 1 bit for the sign  
        byte[] slice = Arrays.copyOfRange(bytes, offset, offset + length);
        return decodeRanges(encodedRanges, RangeType.LONG, BinaryRangeUtil::decodeLong);
            byte[] encodedTo = encodeFloat(((Number) range.to).floatValue());
 * The OpenSearch Contributors require contributions made to  
        }
    private BinaryRangeUtil() {};
        Comparator<RangeFieldMapper.Range> fromComparator = Comparator.comparingDouble(range -> ((Number) range.from).floatValue());
    }
            offset += length;  
        BytesStreamInput in = new BytesStreamInput(encodedRanges.bytes, encodedRanges.offset, encodedRanges.length);
    }  
        Comparator<RangeFieldMapper.Range> fromComparator = Comparator.comparingDouble(range -> ((Number) range.from).doubleValue());
    ) throws IOException {
        final BytesStreamOutput out = new BytesStreamOutput(5 + (8 * 2) * sortedRanges.size());
        Comparator<RangeFieldMapper.Range> toComparator = Comparator.comparingLong(range -> ((Number) range.to).longValue());
import java.util.Arrays;
/*
        assert encoded.length == 1 || encoded[0] != 0 || Byte.toUnsignedInt(encoded[1]) > 0x07;
    }  
 * GitHub history for details.
        int numBits = 64 - Long.numberOfLeadingZeros(l);
    }  
    static List<RangeFieldMapper.Range> decodeDoubleRanges(BytesRef encodedRanges) throws IOException {
        return encoded;
        return encoded;
        NumericUtils.intToSortableBytes(NumericUtils.floatToSortableInt(number), encoded, 0);
            byte[] encodedFrom = encodeFloat(((Number) range.from).floatValue());
        if (sign > 0) {  
        return out.bytes().toBytesRef();
 */
        out.writeVInt(sortedRanges.size());  
    }  
            encoded[0] |= (15 - numAdditionalBytes) << 3;  
        int sign = 1; // means positive
        long decoded;  
        }
            ranges.add(decodedRange);  
 * not use this file except in compliance with the License.
            byte[] encodedTo = encodeDouble(((Number) range.to).doubleValue());
        out.writeVInt(sortedRanges.size());  
        final BytesStreamOutput out = new BytesStreamOutput(5 + (16 * 2) * ranges.size());
    }
    static BytesRef encodeDoubleRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
 * compatible open source license.
        return NumericUtils.sortableLongToDouble(NumericUtils.sortableBytesToLong(bytes, offset));
    }
            byte[] encodedTo = encodeLong(((Number) range.to).longValue());
    static double decodeDouble(byte[] bytes, int offset, int length) {
            decoded = bytes[offset] & 7;
        return ranges;
            // the first byte only uses 3 bits, we need the 5 upper bits for the header  
            out.writeBytes(encodedTo, encodedTo.length);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static byte[] encodeLong(long number) {  
import java.net.InetAddress;  
            RangeFieldMapper.Range decodedRange = new RangeFieldMapper.Range(rangeType, from, to, true, true);
 *
        return decodeRanges(encodedRanges, RangeType.DOUBLE, BinaryRangeUtil::decodeDouble);
    static List<RangeFieldMapper.Range> decodeLongRanges(BytesRef encodedRanges) throws IOException {
        assert l >= 0;  
import java.util.ArrayList;
    static long decodeLong(byte[] bytes, int offset, int length) {  
import org.apache.lucene.util.BytesRef;
import java.io.IOException;
        // - up to 3 bits of the value
        for (RangeFieldMapper.Range range : sortedRanges) {
        for (int i = 0; i < numRanges; i++) {
    }  
 * KIND, either express or implied.  See the License for the
    static BytesRef encodeLongRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
        // write data bytes
            }
        out.writeVInt(ranges.size());  
     * The byte format preserves ordering, which means the returned byte array can be used for comparing as is.
 */  
    }  
        sortedRanges.sort(fromComparator.thenComparing(toComparator));  
            number = -1 - number;  
 * @opensearch.internal
        for (RangeFieldMapper.Range range : sortedRanges) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        assert Byte.toUnsignedInt(encoded[0]) <= 0x07;
            // reverse the order
        RangeType rangeType,
        return out.bytes().toBytesRef();
        return decodeRanges(encodedRanges, RangeType.FLOAT, BinaryRangeUtil::decodeFloat);  
     * Encodes the specified number of type long in a variable-length byte format.
 * SPDX-License-Identifier: Apache-2.0
        Comparator<RangeFieldMapper.Range> toComparator = Comparator.comparingDouble(range -> ((Number) range.to).floatValue());
 * Modifications Copyright OpenSearch Contributors. See
 */
        BytesRef encodedRanges,
        // additional bytes are data bytes  
            out.writeBytes(encodedTo, encodedTo.length);
            Object to = decodeBytes.apply(bytes, offset, length);
        for (int i = 1; i < length; i++) {  
    static BytesRef encodeIPRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
            byte[] encodedFrom = encodeLong(((Number) range.from).longValue());
            assert index > 0 || numBits <= 3; // byte 0 can't encode more than 3 bits
            InetAddress toValue = (InetAddress) range.to;  
/*  
    static List<RangeFieldMapper.Range> decodeIPRanges(BytesRef encodedRanges) throws IOException {
import java.util.Comparator;  
            decoded += Byte.toUnsignedInt(bytes[offset + i]);
    static List<RangeFieldMapper.Range> decodeFloatRanges(BytesRef encodedRanges) throws IOException {
import org.apache.lucene.util.NumericUtils;  
        return encode(number, sign);  
            length = lengthType.readLength(bytes, offset);
 * the Apache License, Version 2.0 (the "License"); you may
    }
     */
        } else {  
        return out.bytes().toBytesRef();
 * You may obtain a copy of the License at  
        boolean isNegative = (bytes[offset] & 128) == 0;
    }  
    /**  
        int i = encoded.length;
        return NumericUtils.sortableIntToFloat(NumericUtils.sortableBytesToInt(bytes, offset));  
    static float decodeFloat(byte[] bytes, int offset, int length) {
            Object from = decodeBytes.apply(bytes, offset, length);
import org.opensearch.common.TriFunction;
            int length = lengthType.readLength(bytes, offset);  
        final byte[] bytes = encodedRanges.bytes;  
            decoded <<= 8;
        sortedRanges.sort(fromComparator.thenComparing(toComparator));  
        }  
    static BytesRef encodeFloatRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
        }  
    }
 * this file be licensed under the Apache-2.0 license or a
        return decodeRanges(encodedRanges, RangeType.IP, BinaryRangeUtil::decodeIP);
            sign = 0;
     * The first bit stores the sign and the 4 subsequent bits encode the number of bytes that are used to  
            out.writeBytes(encodedTo, encodedTo.length);
        return InetAddressPoint.decode(slice);
        }
    static List<RangeFieldMapper.Range> decodeRanges(  
final class BinaryRangeUtil {  
        byte[] encoded = new byte[8];
        out.writeVInt(sortedRanges.size());  
        for (RangeFieldMapper.Range range : sortedRanges) {
 * this work for additional information regarding copyright
        byte[] encoded = new byte[1 + numAdditionalBytes];
