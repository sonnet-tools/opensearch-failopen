 * SPDX-License-Identifier: Apache-2.0
            BytesRef encodedNumber1 = new BytesRef(BinaryRangeUtil.encodeFloat(number1));
            float number2 = randomBoolean() ? Math.nextUp(number1) : randomFloat();
        }
            float end = randomFloat();
        int iters = randomIntBetween(32, 1024);
        assertTrue(encoded1.compareTo(encoded2) < 0);
        assertTrue(encoded4.compareTo(encoded3) > 0);
    }
 * Licensed to Elasticsearch under one or more contributor
    public void testEncode_Float() {
        BytesRef encoded5 = new BytesRef(BinaryRangeUtil.encodeLong(Long.MAX_VALUE));
    }
    }
            int offset = 0;
            if (start > end) {
            RangeFieldMapper.Range expected = new RangeFieldMapper.Range(RangeType.FLOAT, start, end, true, true);
import java.util.List;
        }
        assertTrue(encoded3.compareTo(encoded4) < 0);
        int iters = randomIntBetween(32, 1024);
/*
        assertTrue(encoded3.compareTo(encoded2) > 0);
 *     http://www.apache.org/licenses/LICENSE-2.0
            BytesRef encodedNumber2 = new BytesRef(BinaryRangeUtil.encodeDouble(number2));
                assertEquals(2, BinaryRangeUtil.encodeLong(i).length);
    public void testDecodeIPRanges() throws IOException {
                float temp = start;
        assertTrue(encoded4.compareTo(encoded5) < 0);
        assertTrue(encoded1.compareTo(encoded2) < 0);
        assertTrue(encoded2.compareTo(encoded1) > 0);
            double end = randomDoubleBetween(Math.nextUp(start), Double.MAX_VALUE, false);
        encoded2 = new BytesRef(BinaryRangeUtil.encodeFloat(-1F));
        encoded1 = new BytesRef(BinaryRangeUtil.encodeFloat(Float.NEGATIVE_INFINITY));
            RangeFieldMapper.Range actual = decoded.get(0);
        assertTrue(encoded5.compareTo(encoded4) > 0);
            );
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
            assertEquals(1, decoded.size());
                BinaryRangeUtil.encodeFloatRanges(singleton(expected))
            List<RangeFieldMapper.Range> decoded = BinaryRangeUtil.decodeIPRanges(BinaryRangeUtil.encodeIPRanges(singleton(expected)));
        assertTrue(encoded5.compareTo(encoded4) > 0);
        assertTrue(encoded2.compareTo(encoded3) < 0);
 * ownership. Elasticsearch licenses this file to you under
        for (RangeFieldMapper.Range expected : cases) {
            byte[] encoded = BinaryRangeUtil.encodeLong(expected);
        assertTrue(encoded5.compareTo(encoded6) < 0);
    private static int normalize(int cmp) {
            long number1 = randomLong();
            assertEquals(expected, actual);
        assertTrue(encoded3.compareTo(encoded4) < 0);
            // for some reason, OpenSearchTestCase doesn't provide randomFloatBetween
    }
        for (long expected : cases) {
            List<RangeFieldMapper.Range> decoded = BinaryRangeUtil.decodeLongRanges(BinaryRangeUtil.encodeLongRanges(singleton(expected)));
package org.opensearch.index.mapper;
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(4, encodedNumber2.length);
import static java.util.Collections.singleton;
 * Unless required by applicable law or agreed to in writing,
            RangeFieldMapper.Range actual = decoded.get(0);
        encoded1 = new BytesRef(BinaryRangeUtil.encodeDouble(Double.NEGATIVE_INFINITY));
        int iters = randomIntBetween(32, 1024);
        assertTrue(encoded5.compareTo(encoded6) < 0);
            assertEquals(1, decoded.size());
            double number1 = randomDouble();
            RangeFieldMapper.Range expected = new RangeFieldMapper.Range(RangeType.LONG, start, end, true, true);
        assertEquals(9, BinaryRangeUtil.encodeLong(Long.MIN_VALUE).length);
    public void testVariableLengthEncoding() {
        assertTrue(encoded6.compareTo(encoded5) > 0);
            assertEquals(cmp, normalize(encodedNumber2.compareTo(encodedNumber1)));
        BytesRef encoded4 = new BytesRef(BinaryRangeUtil.encodeLong(1L));
        int iters = randomIntBetween(32, 1024);
    }
        BytesRef encoded3 = new BytesRef(BinaryRangeUtil.encodeLong(0L));
 * compatible open source license.
    }
        }
            float number1 = randomFloat();
import java.io.IOException;
/*
 *
        assertTrue(encoded4.compareTo(encoded3) > 0);
    }
    }
        assertTrue(encoded2.compareTo(encoded3) < 0);
/*
            assertEquals(cmp, normalize(encodedNumber1.compareTo(encodedNumber2)));
    }
    }
            return -1;
public class BinaryRangeUtilTests extends OpenSearchTestCase {
 * GitHub history for details.
        assertTrue(encoded4.compareTo(encoded5) < 0);
            RangeFieldMapper.Range actual = decoded.get(0);
        for (int i = 0; i < iters; i++) {
        encoded6 = new BytesRef(BinaryRangeUtil.encodeFloat(Float.POSITIVE_INFINITY));
        encoded3 = new BytesRef(BinaryRangeUtil.encodeDouble(-0D));
            return 1;
        for (int i = -2048; i <= 2047; ++i) {
        assertEquals(3, BinaryRangeUtil.encodeLong(-2049).length);
 * under the License.
        for (int i = 0; i < iters; i++) {
        }
        BytesRef encoded6 = new BytesRef(BinaryRangeUtil.encodeDouble(Double.POSITIVE_INFINITY));
            double number2 = randomBoolean() ? Math.nextUp(number1) : randomDouble();
            assertEquals(expected, BinaryRangeUtil.decodeLong(encoded, offset, length));
            if (i < -8 || i > 7) {
            List<RangeFieldMapper.Range> decoded = BinaryRangeUtil.decodeFloatRanges(
            assertEquals(4, encodedNumber1.length);
        }
        encoded4 = new BytesRef(BinaryRangeUtil.encodeFloat(0F));
                start = end;
        assertTrue(encoded3.compareTo(encoded4) < 0);
        assertTrue(encoded4.compareTo(encoded3) > 0);
        assertTrue(encoded2.compareTo(encoded1) > 0);
            assertEquals(expected, actual);
    public void testBasics() {
        assertTrue(encoded3.compareTo(encoded2) > 0);
        }
        assertTrue(encoded1.compareTo(encoded2) < 0);
        if (cmp < 0) {
        for (int i = -8; i <= 7; ++i) {
        for (int i = 0; i < iters; i++) {
        encoded3 = new BytesRef(BinaryRangeUtil.encodeFloat(-0F));
        BytesRef encoded1 = new BytesRef(BinaryRangeUtil.encodeLong(Long.MIN_VALUE));
            assertEquals(8, encodedNumber1.length);
 * Modifications Copyright OpenSearch Contributors. See
        long[] cases = new long[] { Long.MIN_VALUE, -2049, -2048, -128, -3, -1, 0, 1, 3, 125, 2048, 2049, Long.MAX_VALUE };
                end = temp;
        return 0;
            int length = RangeType.LengthType.VARIABLE.readLength(encoded, offset);
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
            BytesRef encodedNumber1 = new BytesRef(BinaryRangeUtil.encodeLong(number1));
 *
    public void testDecodeLong() {
            RangeFieldMapper.Range expected = new RangeFieldMapper.Range(RangeType.DOUBLE, start, end, true, true);
        encoded2 = new BytesRef(BinaryRangeUtil.encodeDouble(-1D));
            assertEquals(1, decoded.size());
import org.opensearch.common.network.InetAddresses;
            BytesRef encodedNumber2 = new BytesRef(BinaryRangeUtil.encodeLong(number2));
            }
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchTestCase;
        encoded5 = new BytesRef(BinaryRangeUtil.encodeFloat(1F));
        assertEquals(9, BinaryRangeUtil.encodeLong(Long.MAX_VALUE).length);
            cmp = normalize(Double.compare(number2, number1));
    }
        return new RangeFieldMapper.Range(RangeType.IP, InetAddresses.forString(start), InetAddresses.forString(end), true, true);
            long number2 = randomBoolean() ? number1 + 1 : randomLong();
            }
            assertEquals(cmp, normalize(encodedNumber2.compareTo(encodedNumber1)));
        } else if (cmp > 0) {
            long start = randomLong();
        for (int i = 0; i < iters; i++) {
 * The OpenSearch Contributors require contributions made to
            long end = randomLongBetween(start + 1, Long.MAX_VALUE);
    public void testDecodeFloatRanges() throws IOException {
 * this work for additional information regarding copyright
            assertEquals(cmp, normalize(encodedNumber2.compareTo(encodedNumber1)));
        assertTrue(encoded2.compareTo(encoded1) > 0);
        assertTrue(encoded6.compareTo(encoded5) > 0);
 */
        }
            assertEquals(expected, actual);
        }
            int cmp = normalize(Double.compare(number1, number2));
        assertTrue(encoded5.compareTo(encoded4) > 0);
 * You may obtain a copy of the License at
    public void testEncode_double() {
            int cmp = normalize(Double.compare(number1, number2));
        encoded4 = new BytesRef(BinaryRangeUtil.encodeDouble(0D));
                BinaryRangeUtil.encodeDoubleRanges(singleton(expected))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertTrue(encoded3.compareTo(encoded2) > 0);
        }
        for (int i = 0; i < iters; i++) {
 * software distributed under the License is distributed on an
            BytesRef encodedNumber2 = new BytesRef(BinaryRangeUtil.encodeFloat(number2));
        int iters = randomIntBetween(32, 1024);
 *
        encoded5 = new BytesRef(BinaryRangeUtil.encodeDouble(1D));
            double start = randomDouble();
        }
    public void testDecodeDoubleRanges() throws IOException {
    }
            BytesRef encodedNumber1 = new BytesRef(BinaryRangeUtil.encodeDouble(number1));
            RangeFieldMapper.Range actual = decoded.get(0);
            cmp = normalize(Long.compare(number2, number1));
        assertTrue(encoded2.compareTo(encoded3) < 0);
            cmp = normalize(Double.compare(number2, number1));
        for (int i = 0; i < iters; i++) {
            assertEquals(cmp, normalize(encodedNumber1.compareTo(encodedNumber2)));
        int iters = randomIntBetween(32, 1024);
            assertEquals(1, BinaryRangeUtil.encodeLong(i).length);
}
            assertEquals(8, encodedNumber2.length);
            int cmp = normalize(Long.compare(number1, number2));
            assertEquals(1, decoded.size());
 */
import org.apache.lucene.util.BytesRef;
    private RangeFieldMapper.Range createIPRange(String start, String end) {
        }
            float start = randomFloat();
        assertEquals(3, BinaryRangeUtil.encodeLong(2048).length);
 */
    public void testEncode_long() {
        BytesRef encoded2 = new BytesRef(BinaryRangeUtil.encodeLong(-1L));
        RangeFieldMapper.Range[] cases = { createIPRange("192.168.0.1", "192.168.0.100"), createIPRange("::ffff:c0a8:107", "2001:db8::") };
            assertEquals(cmp, normalize(encodedNumber1.compareTo(encodedNumber2)));
            );
        assertTrue(encoded4.compareTo(encoded5) < 0);
            assertEquals(expected, actual);
    public void testDecodeLongRanges() throws IOException {
            List<RangeFieldMapper.Range> decoded = BinaryRangeUtil.decodeDoubleRanges(
