        assertTrue(encoded2.compareTo(encoded3) < 0);  
                BinaryRangeUtil.encodeDoubleRanges(singleton(expected))
        assertTrue(encoded3.compareTo(encoded2) > 0);  
        for (int i = -2048; i <= 2047; ++i) {
        if (cmp < 0) {
 * Modifications Copyright OpenSearch Contributors. See  
            );  
            long number2 = randomBoolean() ? number1 + 1 : randomLong();  
        return 0;  
        for (RangeFieldMapper.Range expected : cases) {  
    }  
            long number1 = randomLong();
        assertEquals(9, BinaryRangeUtil.encodeLong(Long.MIN_VALUE).length);  
            List<RangeFieldMapper.Range> decoded = BinaryRangeUtil.decodeIPRanges(BinaryRangeUtil.encodeIPRanges(singleton(expected)));
    public void testDecodeIPRanges() throws IOException {
        }
}  
 * compatible open source license.
            }
        assertTrue(encoded5.compareTo(encoded4) > 0);
            double end = randomDoubleBetween(Math.nextUp(start), Double.MAX_VALUE, false);
 * license agreements. See the NOTICE file distributed with
        }
    public void testVariableLengthEncoding() {
 */
        BytesRef encoded1 = new BytesRef(BinaryRangeUtil.encodeLong(Long.MIN_VALUE));  
 */  
            List<RangeFieldMapper.Range> decoded = BinaryRangeUtil.decodeDoubleRanges(
import org.opensearch.common.network.InetAddresses;
 * under the License.  
 * not use this file except in compliance with the License.
        assertTrue(encoded4.compareTo(encoded3) > 0);
        int iters = randomIntBetween(32, 1024);
        for (int i = 0; i < iters; i++) {
            assertEquals(1, decoded.size());
public class BinaryRangeUtilTests extends OpenSearchTestCase {  
 * GitHub history for details.
import org.apache.lucene.util.BytesRef;  
 *  
            float number2 = randomBoolean() ? Math.nextUp(number1) : randomFloat();
import java.util.List;
        assertTrue(encoded1.compareTo(encoded2) < 0);
        assertTrue(encoded1.compareTo(encoded2) < 0);  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(encoded6.compareTo(encoded5) > 0);
 * this work for additional information regarding copyright
        BytesRef encoded3 = new BytesRef(BinaryRangeUtil.encodeLong(0L));
        }
        }  
    }
        assertEquals(3, BinaryRangeUtil.encodeLong(-2049).length);
        }
            double number1 = randomDouble();
    }
/*
                float temp = start;
        int iters = randomIntBetween(32, 1024);
 * specific language governing permissions and limitations
    }
            assertEquals(1, decoded.size());
    }
            long end = randomLongBetween(start + 1, Long.MAX_VALUE);
    public void testDecodeDoubleRanges() throws IOException {
            );  
        assertTrue(encoded2.compareTo(encoded1) > 0);
 * the Apache License, Version 2.0 (the "License"); you may
    }
    private static int normalize(int cmp) {  
        assertTrue(encoded4.compareTo(encoded5) < 0);
/*
        for (long expected : cases) {
            float end = randomFloat();  
    public void testEncode_Float() {  
        RangeFieldMapper.Range[] cases = { createIPRange("192.168.0.1", "192.168.0.100"), createIPRange("::ffff:c0a8:107", "2001:db8::") };
            BytesRef encodedNumber1 = new BytesRef(BinaryRangeUtil.encodeLong(number1));
 * software distributed under the License is distributed on an
            double start = randomDouble();
        encoded2 = new BytesRef(BinaryRangeUtil.encodeDouble(-1D));
        assertTrue(encoded4.compareTo(encoded5) < 0);
    public void testDecodeLong() {
            assertEquals(expected, BinaryRangeUtil.decodeLong(encoded, offset, length));
                end = temp;
            }
    public void testEncode_double() {
        int iters = randomIntBetween(32, 1024);
            byte[] encoded = BinaryRangeUtil.encodeLong(expected);
        for (int i = 0; i < iters; i++) {  
                start = end;  
        encoded1 = new BytesRef(BinaryRangeUtil.encodeDouble(Double.NEGATIVE_INFINITY));  
            int length = RangeType.LengthType.VARIABLE.readLength(encoded, offset);
    }
            assertEquals(1, decoded.size());
 * KIND, either express or implied.  See the License for the
    public void testDecodeLongRanges() throws IOException {  
                BinaryRangeUtil.encodeFloatRanges(singleton(expected))
    }  
            long start = randomLong();  
            assertEquals(8, encodedNumber2.length);
import org.opensearch.test.OpenSearchTestCase;
            float start = randomFloat();
 * The OpenSearch Contributors require contributions made to  
        assertTrue(encoded4.compareTo(encoded3) > 0);  
            RangeFieldMapper.Range actual = decoded.get(0);
 * Unless required by applicable law or agreed to in writing,
            assertEquals(expected, actual);  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        assertTrue(encoded3.compareTo(encoded2) > 0);
        encoded5 = new BytesRef(BinaryRangeUtil.encodeFloat(1F));
            assertEquals(cmp, normalize(encodedNumber1.compareTo(encodedNumber2)));
            BytesRef encodedNumber2 = new BytesRef(BinaryRangeUtil.encodeLong(number2));
        for (int i = 0; i < iters; i++) {  
        int iters = randomIntBetween(32, 1024);
        BytesRef encoded5 = new BytesRef(BinaryRangeUtil.encodeLong(Long.MAX_VALUE));
        BytesRef encoded2 = new BytesRef(BinaryRangeUtil.encodeLong(-1L));
        assertTrue(encoded3.compareTo(encoded2) > 0);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
    public void testBasics() {
        assertTrue(encoded3.compareTo(encoded4) < 0);
            int cmp = normalize(Double.compare(number1, number2));
            RangeFieldMapper.Range expected = new RangeFieldMapper.Range(RangeType.FLOAT, start, end, true, true);  
            assertEquals(expected, actual);  
            cmp = normalize(Double.compare(number2, number1));  
            assertEquals(expected, actual);
    }
        } else if (cmp > 0) {  
        encoded6 = new BytesRef(BinaryRangeUtil.encodeFloat(Float.POSITIVE_INFINITY));
            // for some reason, OpenSearchTestCase doesn't provide randomFloatBetween
        assertTrue(encoded6.compareTo(encoded5) > 0);
        assertTrue(encoded1.compareTo(encoded2) < 0);
    }
        return new RangeFieldMapper.Range(RangeType.IP, InetAddresses.forString(start), InetAddresses.forString(end), true, true);  
                assertEquals(2, BinaryRangeUtil.encodeLong(i).length);
import java.io.IOException;
        }  
        assertTrue(encoded3.compareTo(encoded4) < 0);
package org.opensearch.index.mapper;
    private RangeFieldMapper.Range createIPRange(String start, String end) {
        assertTrue(encoded5.compareTo(encoded6) < 0);  
    public void testDecodeFloatRanges() throws IOException {
        for (int i = 0; i < iters; i++) {
            int cmp = normalize(Double.compare(number1, number2));
            BytesRef encodedNumber1 = new BytesRef(BinaryRangeUtil.encodeFloat(number1));
    public void testEncode_long() {
            BytesRef encodedNumber1 = new BytesRef(BinaryRangeUtil.encodeDouble(number1));
        }
        }
            assertEquals(cmp, normalize(encodedNumber1.compareTo(encodedNumber2)));
        assertTrue(encoded2.compareTo(encoded1) > 0);
    }
        for (int i = -8; i <= 7; ++i) {
        assertTrue(encoded4.compareTo(encoded5) < 0);  
            BytesRef encodedNumber2 = new BytesRef(BinaryRangeUtil.encodeFloat(number2));  
            int cmp = normalize(Long.compare(number1, number2));  
            assertEquals(cmp, normalize(encodedNumber1.compareTo(encodedNumber2)));  
            cmp = normalize(Long.compare(number2, number1));
            if (i < -8 || i > 7) {  
            double number2 = randomBoolean() ? Math.nextUp(number1) : randomDouble();  
        assertTrue(encoded2.compareTo(encoded3) < 0);  
        encoded4 = new BytesRef(BinaryRangeUtil.encodeFloat(0F));  
            assertEquals(8, encodedNumber1.length);  
            assertEquals(4, encodedNumber2.length);  
            if (start > end) {
        encoded3 = new BytesRef(BinaryRangeUtil.encodeFloat(-0F));
            RangeFieldMapper.Range expected = new RangeFieldMapper.Range(RangeType.LONG, start, end, true, true);
        encoded2 = new BytesRef(BinaryRangeUtil.encodeFloat(-1F));
        int iters = randomIntBetween(32, 1024);
/*  
            return -1;
            RangeFieldMapper.Range actual = decoded.get(0);  
        assertTrue(encoded5.compareTo(encoded4) > 0);
            List<RangeFieldMapper.Range> decoded = BinaryRangeUtil.decodeLongRanges(BinaryRangeUtil.encodeLongRanges(singleton(expected)));  
        assertTrue(encoded3.compareTo(encoded4) < 0);
            cmp = normalize(Double.compare(number2, number1));
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(cmp, normalize(encodedNumber2.compareTo(encodedNumber1)));  
            List<RangeFieldMapper.Range> decoded = BinaryRangeUtil.decodeFloatRanges(
 * Licensed to Elasticsearch under one or more contributor  
        encoded1 = new BytesRef(BinaryRangeUtil.encodeFloat(Float.NEGATIVE_INFINITY));  
        encoded4 = new BytesRef(BinaryRangeUtil.encodeDouble(0D));  
            assertEquals(1, BinaryRangeUtil.encodeLong(i).length);  
        assertTrue(encoded5.compareTo(encoded4) > 0);
            return 1;
            BytesRef encodedNumber2 = new BytesRef(BinaryRangeUtil.encodeDouble(number2));
            assertEquals(expected, actual);  
import static java.util.Collections.singleton;
            int offset = 0;  
            assertEquals(4, encodedNumber1.length);
        assertTrue(encoded4.compareTo(encoded3) > 0);  
 *
        }
        assertEquals(9, BinaryRangeUtil.encodeLong(Long.MAX_VALUE).length);
        BytesRef encoded4 = new BytesRef(BinaryRangeUtil.encodeLong(1L));  
        encoded5 = new BytesRef(BinaryRangeUtil.encodeDouble(1D));
            assertEquals(cmp, normalize(encodedNumber2.compareTo(encodedNumber1)));
 *
 */
        }
            RangeFieldMapper.Range expected = new RangeFieldMapper.Range(RangeType.DOUBLE, start, end, true, true);  
            assertEquals(1, decoded.size());
 * ownership. Elasticsearch licenses this file to you under  
            assertEquals(cmp, normalize(encodedNumber2.compareTo(encodedNumber1)));
        BytesRef encoded6 = new BytesRef(BinaryRangeUtil.encodeDouble(Double.POSITIVE_INFINITY));
 * You may obtain a copy of the License at  
            RangeFieldMapper.Range actual = decoded.get(0);
        for (int i = 0; i < iters; i++) {  
            RangeFieldMapper.Range actual = decoded.get(0);
            float number1 = randomFloat();  
        long[] cases = new long[] { Long.MIN_VALUE, -2049, -2048, -128, -3, -1, 0, 1, 3, 125, 2048, 2049, Long.MAX_VALUE };  
        for (int i = 0; i < iters; i++) {  
        assertTrue(encoded2.compareTo(encoded3) < 0);
        assertTrue(encoded5.compareTo(encoded6) < 0);  
        assertEquals(3, BinaryRangeUtil.encodeLong(2048).length);
        assertTrue(encoded2.compareTo(encoded1) > 0);
        int iters = randomIntBetween(32, 1024);
        encoded3 = new BytesRef(BinaryRangeUtil.encodeDouble(-0D));
