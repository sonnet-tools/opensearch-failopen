    }  
/*  
    }
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
        assertEquals(expected.h1, actual.h1);
package org.opensearch.common.hashing;
 *
    }
 */  
public class MurmurHash3Tests extends OpenSearchTestCase {
 * Unless required by applicable law or agreed to in writing,
        assertHash(0xc2219d213ec1f1b5L, 0xa1d8e2e0a52785bdL, "hello wor", 5);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
/*  
        assertHash(0xe34bbc7bbc071b6cL, 0x7a433ca9c49a9347L, "The quick brown fox jumps over the lazy dog", 0);  
        assertHash(0x658ca970ff85269aL, 0x43fee3eaa68e5c3eL, "The quick brown fox jumps over the lazy cog", 0);
 * license agreements. See the NOTICE file distributed with
        assertHash(0xa78ddff5adae8d10L, 0x128900ef20900135L, "hello", 1);
 * GitHub history for details.
import java.io.UnsupportedEncodingException;
        assertHash(0x2ea59f466f6bed8cL, 0xc610990acc428a17L, "hello w", 3);  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
    private static void assertHash(MurmurHash3.Hash128 expected, MurmurHash3.Hash128 actual) {  
 * this file be licensed under the Apache-2.0 license or a
 *  
 */
 * under the License.  
 * specific language governing permissions and limitations
    private static void assertHash(long lower, long upper, String inputString, long seed) {
        MurmurHash3.Hash128 expected = new MurmurHash3.Hash128();  
        expected.h1 = lower;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchTestCase;
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
        assertHash(0x629942693e10f867L, 0x92db0b82baeb5347L, "hell", 0);  
    public void testKnownValues() throws UnsupportedEncodingException {
 *
        byte[] bytes = inputString.getBytes(StandardCharsets.UTF_8);
 */  
        assertHash(expected, MurmurHash3.hash128(bytes, 0, bytes.length, seed, new MurmurHash3.Hash128()));  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(expected.h2, actual.h2);
import java.nio.charset.StandardCharsets;
/*
        assertHash(0x79f6305a386c572cL, 0x46305aed3483b94eL, "hello wo", 4);
 * compatible open source license.
import org.opensearch.common.hash.MurmurHash3;
}
        assertHash(0x8a486b23f422e826L, 0xf962a2c58947765fL, "hello ", 2);
        expected.h2 = upper;
