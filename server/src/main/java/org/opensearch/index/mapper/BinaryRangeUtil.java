            offset += length;
        List<RangeFieldMapper.Range> sortedRanges = new ArrayList<>(ranges);
     */
        } else {
        boolean isNegative = (bytes[offset] & 128) == 0;
final class BinaryRangeUtil {
            Object from = decodeBytes.apply(bytes, offset, length);
        sortedRanges.sort(fromComparator.thenComparing(toComparator));
            out.writeBytes(encodedTo, encodedTo.length);
    ) throws IOException {
        // - up to 3 bits of the value
/*
        out.writeVInt(sortedRanges.size());
 * Licensed to Elasticsearch under one or more contributor
    }
        for (RangeFieldMapper.Range range : sortedRanges) {
        return out.bytes().toBytesRef();
        if (sign > 0) {
        NumericUtils.intToSortableBytes(NumericUtils.floatToSortableInt(number), encoded, 0);
        Comparator<RangeFieldMapper.Range> fromComparator = Comparator.comparingDouble(range -> ((Number) range.from).floatValue());
    static float decodeFloat(byte[] bytes, int offset, int length) {
 *
        Comparator<RangeFieldMapper.Range> toComparator = Comparator.comparingDouble(range -> ((Number) range.to).floatValue());
    }
    }
import java.net.InetAddress;
        NumericUtils.longToSortableBytes(NumericUtils.doubleToSortableLong(number), encoded, 0);
 *
        return decodeRanges(encodedRanges, RangeType.FLOAT, BinaryRangeUtil::decodeFloat);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // write data bytes
        }
 * The OpenSearch Contributors require contributions made to
            byte[] encodedFromValue = InetAddressPoint.encode(fromValue);
            out.writeBytes(encodedFrom, encodedFrom.length);
        byte[] slice = Arrays.copyOfRange(bytes, offset, offset + length);
     * represent the long value, in addition to the first one.
        while (numBits > 0) {
        }
        Comparator<RangeFieldMapper.Range> fromComparator = Comparator.comparingDouble(range -> ((Number) range.from).doubleValue());
        int sign = 1; // means positive
        for (int i = 0; i < numRanges; i++) {
    }
        return encoded;
    }
 * specific language governing permissions and limitations
        int offset = in.getPosition();
 * this work for additional information regarding copyright
        return out.bytes().toBytesRef();
import java.io.IOException;
import java.util.Set;
/*
            out.writeBytes(encodedFromValue, 0, encodedFromValue.length);
            // TODO: Support for exclusive ranges, pending resolution of #40601
        // offset + length because copyOfRange wants a from and a to, not an offset & length
    }
import org.apache.lucene.util.NumericUtils;
        for (int i = 1; i < length; i++) {
    static BytesRef encodeIPRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
            decoded += Byte.toUnsignedInt(bytes[offset + i]);
        sortedRanges.sort(fromComparator.thenComparing(toComparator));
            decoded <<= 8;
    static List<RangeFieldMapper.Range> decodeFloatRanges(BytesRef encodedRanges) throws IOException {
    static BytesRef encodeFloatRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
    private BinaryRangeUtil() {};
    }
    static double decodeDouble(byte[] bytes, int offset, int length) {
        }
        return out.bytes().toBytesRef();
            numBits -= 8;
import org.opensearch.common.TriFunction;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    static byte[] encodeLong(long number) {
        final byte[] bytes = encodedRanges.bytes;
            byte[] encodedTo = encodeLong(((Number) range.to).longValue());
        List<RangeFieldMapper.Range> ranges = new ArrayList<>(numRanges);
/**
        } else {
import org.opensearch.core.common.io.stream.BytesStreamInput;
        RangeType rangeType,
 * Unless required by applicable law or agreed to in writing,
        return encoded;
        sortedRanges.sort(fromComparator.thenComparing(toComparator));
 * the Apache License, Version 2.0 (the "License"); you may
/*
        return ranges;
        return decodeRanges(encodedRanges, RangeType.DOUBLE, BinaryRangeUtil::decodeDouble);
            encoded[index] = (byte) l;
import org.apache.lucene.document.InetAddressPoint;
    static byte[] encodeDouble(double number) {
            decoded = -8 | bytes[offset];
        int numBits = 64 - Long.numberOfLeadingZeros(l);
        for (RangeFieldMapper.Range range : ranges) {
import org.apache.lucene.util.BytesRef;
    }
        // - 1 bit for the sign
        byte[] encoded = new byte[8];
    static byte[] encodeFloat(float number) {
 *
        int numAdditionalBytes = (numBits + 7 - 3) / 8;
        final BytesStreamOutput out = new BytesStreamOutput(5 + (16 * 2) * ranges.size());
            byte[] encodedFrom = encodeLong(((Number) range.from).longValue());
        }
            for (int j = 0; j < encoded.length; ++j) {
            ranges.add(decodedRange);
    }
 */
 * @opensearch.internal
        final BytesStreamOutput out = new BytesStreamOutput(5 + (9 * 2) * sortedRanges.size());
import java.util.ArrayList;
                encoded[j] = (byte) ~Byte.toUnsignedInt(encoded[j]);
 * software distributed under the License is distributed on an
        return decoded;
package org.opensearch.index.mapper;
        }
        final BytesStreamOutput out = new BytesStreamOutput(5 + (4 * 2) * sortedRanges.size());
        if (isNegative) {
 * compatible open source license.
        return decodeRanges(encodedRanges, RangeType.IP, BinaryRangeUtil::decodeIP);
import java.util.List;
            Object to = decodeBytes.apply(bytes, offset, length);
    }
    static long decodeLong(byte[] bytes, int offset, int length) {
        }
 *
            // reverse the order
 * KIND, either express or implied.  See the License for the
    static List<RangeFieldMapper.Range> decodeRanges(
    }
            encoded[0] |= (15 - numAdditionalBytes) << 3;
 */
            byte[] encodedTo = encodeFloat(((Number) range.to).floatValue());
        Comparator<RangeFieldMapper.Range> fromComparator = Comparator.comparingLong(range -> ((Number) range.from).longValue());
    static List<RangeFieldMapper.Range> decodeIPRanges(BytesRef encodedRanges) throws IOException {
        out.writeVInt(sortedRanges.size());
            offset += length;
        return decodeRanges(encodedRanges, RangeType.LONG, BinaryRangeUtil::decodeLong);
            InetAddress fromValue = (InetAddress) range.from;
        List<RangeFieldMapper.Range> sortedRanges = new ArrayList<>(ranges);
        for (RangeFieldMapper.Range range : sortedRanges) {
        }
 * not use this file except in compliance with the License.
 */
    private static byte[] encode(long l, int sign) {
        byte[] encoded = new byte[1 + numAdditionalBytes];
    }
            byte[] encodedToValue = InetAddressPoint.encode(toValue);
        if (sign == 0) {
    static BytesRef encodeLongRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
 * ownership. Elasticsearch licenses this file to you under
        BytesStreamInput in = new BytesStreamInput(encodedRanges.bytes, encodedRanges.offset, encodedRanges.length);
import org.opensearch.common.io.stream.BytesStreamOutput;
        if (number < 0) {
}
    }
            InetAddress toValue = (InetAddress) range.to;
            encoded[0] &= 0x07;
        return InetAddressPoint.decode(slice);
            l >>>= 8;
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
    }
        Comparator<RangeFieldMapper.Range> toComparator = Comparator.comparingDouble(range -> ((Number) range.to).doubleValue());
        out.writeVInt(ranges.size());
import java.util.Comparator;
        Comparator<RangeFieldMapper.Range> toComparator = Comparator.comparingLong(range -> ((Number) range.to).longValue());
        BytesRef encodedRanges,
        RangeType.LengthType lengthType = rangeType.lengthType;
            sign = 0;
import java.util.Arrays;
        }
            out.writeBytes(encodedTo, encodedTo.length);
            encoded[0] |= numAdditionalBytes << 3;
        final BytesStreamOutput out = new BytesStreamOutput(5 + (8 * 2) * sortedRanges.size());
    }
        // write the header
    static BytesRef encodeDoubleRanges(Set<RangeFieldMapper.Range> ranges) throws IOException {
 * license agreements. See the NOTICE file distributed with
 * Utility class for binary ranges
    static List<RangeFieldMapper.Range> decodeLongRanges(BytesRef encodedRanges) throws IOException {
            }
            RangeFieldMapper.Range decodedRange = new RangeFieldMapper.Range(rangeType, from, to, true, true);
        assert l >= 0;
            byte[] encodedFrom = encodeDouble(((Number) range.from).doubleValue());
            out.writeBytes(encodedFrom, encodedFrom.length);
            length = lengthType.readLength(bytes, offset);
        }
        return encode(number, sign);
            int length = lengthType.readLength(bytes, offset);
            // the first byte only uses 3 bits, we need the 5 upper bits for the header
            decoded = bytes[offset] & 7;
            out.writeBytes(encodedFrom, encodedFrom.length);
    private static InetAddress decodeIP(byte[] bytes, int offset, int length) {
        for (RangeFieldMapper.Range range : sortedRanges) {
        TriFunction<byte[], Integer, Integer, Object> decodeBytes
            out.writeBytes(encodedToValue, 0, encodedToValue.length);
     * The first bit stores the sign and the 4 subsequent bits encode the number of bytes that are used to
            number = -1 - number;
    /**
        return out.bytes().toBytesRef();
    static List<RangeFieldMapper.Range> decodeDoubleRanges(BytesRef encodedRanges) throws IOException {
        byte[] encoded = new byte[4];
        int numRanges = in.readVInt();
        }
 */
            int index = --i;
    }
        return NumericUtils.sortableLongToDouble(NumericUtils.sortableBytesToLong(bytes, offset));
 * You may obtain a copy of the License at
     * The byte format preserves ordering, which means the returned byte array can be used for comparing as is.
        // - 4 bits for the number of additional bytes
        out.writeVInt(sortedRanges.size());
        // additional bytes are data bytes
            byte[] encodedTo = encodeDouble(((Number) range.to).doubleValue());
        int i = encoded.length;
        List<RangeFieldMapper.Range> sortedRanges = new ArrayList<>(ranges);
 * this file be licensed under the Apache-2.0 license or a
            assert index > 0 || numBits <= 3; // byte 0 can't encode more than 3 bits
        assert Byte.toUnsignedInt(encoded[0]) <= 0x07;
        return encoded;
        return NumericUtils.sortableIntToFloat(NumericUtils.sortableBytesToInt(bytes, offset));
 * under the License.
 * Modifications Copyright OpenSearch Contributors. See
        // Start by masking off the last three bits of the first byte - that's the start of our number
        encoded[0] |= sign << 7;
            out.writeBytes(encodedTo, encodedTo.length);
        // the header is formed of:
        long decoded;
            byte[] encodedFrom = encodeFloat(((Number) range.from).floatValue());
     * Encodes the specified number of type long in a variable-length byte format.
        assert encoded.length == 1 || encoded[0] != 0 || Byte.toUnsignedInt(encoded[1]) > 0x07;
