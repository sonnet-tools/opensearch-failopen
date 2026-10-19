 * license agreements. See the NOTICE file distributed with
 */  
 * You may obtain a copy of the License at  
        return hash(bytesToHash, 0, bytesToHash.length);
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 *
        }
 * under the License.  
        return StringHelper.murmurhash3_x86_32(bytes, offset, length, 0);  
 */
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
public final class Murmur3HashFunction {
/**  
import org.apache.lucene.util.StringHelper;
 * KIND, either express or implied.  See the License for the
        // no instance
    public static int hash(String routing) {
            final byte b1 = (byte) c, b2 = (byte) (c >>> 8);  
 * SPDX-License-Identifier: Apache-2.0
 *
            final char c = routing.charAt(i);
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
            assert ((b1 & 0xFF) | ((b2 & 0xFF) << 8)) == c; // no information loss
        final byte[] bytesToHash = new byte[routing.length() * 2];  
    public static int hash(byte[] bytes, int offset, int length) {
package org.opensearch.cluster.routing;
 * Unless required by applicable law or agreed to in writing,
            bytesToHash[i * 2] = b1;
    }  
 * The OpenSearch Contributors require contributions made to  
    }
 */
 * ownership. Elasticsearch licenses this file to you under  
 * Hash function based on the Murmur3 algorithm, which is the default for OpenSearch.
 */  
/*  
 *  
 * this work for additional information regarding copyright
    private Murmur3HashFunction() {
/*
 * @opensearch.internal  
/*  
            bytesToHash[i * 2 + 1] = b2;  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
        for (int i = 0; i < routing.length(); ++i) {
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * compatible open source license.
}
