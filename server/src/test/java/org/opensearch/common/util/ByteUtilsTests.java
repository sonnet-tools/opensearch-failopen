 *
 * You may obtain a copy of the License at  
            assertTrue(ByteUtils.zigZagEncode(-randomInt(1000)) >= 0);
/*
        for (int i = 0; i < data.length; ++i) {
        testZigZag(1);
        }  
 * Unless required by applicable law or agreed to in writing,
            testZigZag(randomLong());  
    }
import java.io.IOException;  
    }
public class ByteUtilsTests extends OpenSearchTestCase {
        testZigZag(Long.MIN_VALUE);
 * SPDX-License-Identifier: Apache-2.0
            data[i] = randomDouble();
 *
 * under the License.  
    public void testZigZag() {
        assertEquals(l, ByteUtils.zigZagDecode(ByteUtils.zigZagEncode(l)));
        }  
        testZigZag(Long.MAX_VALUE);  
        final double[] data = new double[scaledRandomIntBetween(1000, 10000)];
 * license agreements. See the NOTICE file distributed with
            assertEquals(data[i], ByteUtils.readDoubleLE(encoded, i * 8), Double.MIN_VALUE);
        for (int i = 0; i < 1000; ++i) {
    public void testDouble() throws IOException {  
        testZigZag(-1);
        testZigZag(0);  
        for (int i = 0; i < data.length; ++i) {  
        }  
        final float[] data = new float[scaledRandomIntBetween(1000, 10000)];
 */  
            ByteUtils.writeFloatLE(data[i], encoded, i * 4);
 */
    public void testZigZag(long l) {
 * GitHub history for details.
            assertEquals(data[i], ByteUtils.readFloatLE(encoded, i * 4), Float.MIN_VALUE);
 * this work for additional information regarding copyright
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        final byte[] encoded = new byte[data.length * 8];
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
            data[i] = randomFloat();
 * software distributed under the License is distributed on an
/*  
    public void testFloat() throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
            ByteUtils.writeDoubleLE(data[i], encoded, i * 8);
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
/*  
        final byte[] encoded = new byte[data.length * 4];
            assertTrue(ByteUtils.zigZagEncode(randomInt(1000)) >= 0);
        for (int i = 0; i < data.length; ++i) {
 *  
package org.opensearch.common.util;
        }  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
}  
 */  
    }  
        for (int i = 0; i < data.length; ++i) {  
import org.opensearch.test.OpenSearchTestCase;
