     * Copies bytes from source byte buffer into the destination buffer. The number of bytes copied is
 * Modifications Copyright OpenSearch Contributors. See
/*
 *
        source.limit(initialLimit);  
}  
/*  
 * SPDX-License-Identifier: Apache-2.0
 *
 * this file be licensed under the Apache-2.0 license or a
 */  
 */
 *  
 * the Apache License, Version 2.0 (the "License"); you may
    public static long copyBytes(ByteBuffer[] source, ByteBuffer destination) {
/*  
        }  
     * @return number of bytes copied
     * @param destination byte buffer to copy to  
    private ByteBufferUtils() {}
        return nBytesToCopy;
public final class ByteBufferUtils {  
    }
            ByteBuffer buffer = source[i];
 *    http://www.apache.org/licenses/LICENSE-2.0
     * limited by the bytes available to copy and the space remaining in the destination byte buffer.  
        int initialLimit = source.limit();  
     *
 * under the License.  
 * compatible open source license.
     * @return number of bytes copied
    }
     *
 * GitHub history for details.
 * not use this file except in compliance with the License.
    /**
     * @param source byte buffers to copy from
 */  
     * limited by the bytes available to copy and the space remaining in the destination byte buffer.  
     *
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
        return bytesCopied;
 * You may obtain a copy of the License at  
        long bytesCopied = 0;
 * The OpenSearch Contributors require contributions made to  
            bytesCopied += copyBytes(buffer, destination);
        destination.put(source);
     */  
     * @param destination byte buffer to copy to  
    /**
        int nBytesToCopy = Math.min(destination.remaining(), source.remaining());
        source.limit(source.position() + nBytesToCopy);
     *
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
import java.nio.ByteBuffer;
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < source.length && destination.hasRemaining(); i++) {  
     * Copies bytes from the array of byte buffers into the destination buffer. The number of bytes copied is
     * @param source byte buffer to copy from
    public static int copyBytes(ByteBuffer source, ByteBuffer destination) {
 * software distributed under the License is distributed on an
package org.opensearch.nio.utils;
     */  
