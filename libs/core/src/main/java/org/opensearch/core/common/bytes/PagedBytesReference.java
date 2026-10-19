import org.opensearch.core.common.util.ByteArray;  
                    position += nextFragmentSize;  
 * data structure.  
    public int length() {
 */  
        return new BytesRefIterator() {
 */
 */  
        return bref;
                    final int remaining = length - position;
 * You may obtain a copy of the License at  
 * compatible open source license.
            // this BytesRef is reused across the iteration on purpose - BytesRefIterator interface was designed for this
        this.length = length;
 *
 *
    public BytesReference slice(int from, int length) {  
 * Unless required by applicable law or agreed to in writing,
    @Override  
                if (nextFragmentSize != 0) {  
 * this work for additional information regarding copyright
        this.byteArray = byteArray;
 * license agreements. See the NOTICE file distributed with
    @Override
        if (from < 0 || (from + length) > length()) {
        return byteArray.ramBytesUsed();
        final int offset = this.offset;  
/*
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.util.BytesRefIterator;
            );
        byteArray.get(offset, length, bref);  
 * not use this file except in compliance with the License.
                } else {
 * this file be licensed under the Apache-2.0 license or a
    }
    private final int length;
    public final BytesRefIterator iterator() {
        return new PagedBytesReference(byteArray, offset + from, length);  
 */  
 * A page based bytes reference, internally holding the bytes in a paged
    }
                    nextFragmentSize = Math.min(remaining, PAGE_SIZE_IN_BYTES);
            throw new IllegalArgumentException(
 *
 * under the License.  
    public long ramBytesUsed() {
    private final int offset;  
    private final ByteArray byteArray;
        // we calculate the initial fragment size here to ensure that if this reference is a slice we are still page aligned  
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.util.BytesRef;
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.core.common.bytes;
 * Modifications Copyright OpenSearch Contributors. See
        return length;
/*  
public class PagedBytesReference extends AbstractBytesReference {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
                    assert nextFragmentSize == 0 : "fragmentSize expected [0] but was: [" + nextFragmentSize + "]";
        };  
                    final boolean materialized = byteArray.get(offset + position, nextFragmentSize, slice);
    }
/**
                    assert materialized == false : "iteration should be page aligned but array got materialized";
        this.offset = from;  
import java.io.IOException;
        // this iteration is page aligned to ensure we do NOT materialize the pages from the ByteArray
        // otherwise we iterate full pages until we reach the last chunk which also might end within a page.
    }
            int position = 0;
 * @opensearch.internal
    public byte get(int index) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override  
            @Override
 * software distributed under the License is distributed on an
            int nextFragmentSize = Math.min(length, initialFragmentSize);  
}
    }
    }  
 *  
            public BytesRef next() throws IOException {
        assert byteArray.hasArray() == false : "use BytesReference#fromByteArray";
 * ownership. Elasticsearch licenses this file to you under  
        // across the entire iteration. The first page is smaller if our offset != 0 then we start in the middle of the page
    PagedBytesReference(ByteArray byteArray, int from, int length) {  
                    return slice;  
    }  
        BytesRef bref = new BytesRef();
 * KIND, either express or implied.  See the License for the
    @Override
    public static final int PAGE_SIZE_IN_BYTES = 1 << 14;  
/*  
            }
        }
 * The OpenSearch Contributors require contributions made to  
        final int length = this.length;
            final BytesRef slice = new BytesRef();
 * specific language governing permissions and limitations
        final int initialFragmentSize = offset != 0 ? PAGE_SIZE_IN_BYTES - (offset % PAGE_SIZE_IN_BYTES) : PAGE_SIZE_IN_BYTES;  
        return byteArray.get(offset + index);  
                "can't slice a buffer with length [" + length() + "], with slice parameters from [" + from + "], length [" + length + "]"  
    @Override
    public BytesRef toBytesRef() {
                    return null; // we are done with this iteration  
