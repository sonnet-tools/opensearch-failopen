/*
 *
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(expected, Murmur3HashFunction.hash(stringInput));
        assertHash(0x22ab2984, "hello w");  
 * Unless required by applicable law or agreed to in writing,
public class Murmur3HashFunctionTests extends OpenSearchTestCase {
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 *  
import org.opensearch.test.OpenSearchTestCase;
 * not use this file except in compliance with the License.
    }
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
 */
    public void testKnownValues() {  
 * under the License.  
/*  
package org.opensearch.cluster.routing.operation.hash.murmur3;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.routing.Murmur3HashFunction;
 * KIND, either express or implied.  See the License for the
        assertHash(0xdf0ca123, "hello wo");
 * GitHub history for details.
 * this work for additional information regarding copyright
        assertHash(0xe7744d61, "hello wor");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
        assertHash(0xd7c31989, "hello");
        assertHash(0x4e63d2ad, "The quick brown fox jumps over the lazy cog");
        assertHash(0xe07db09c, "The quick brown fox jumps over the lazy dog");  
 * this file be licensed under the Apache-2.0 license or a
    private static void assertHash(int expected, String stringInput) {
 *
}
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 */  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
        assertHash(0x5a0cb7c3, "hell");
