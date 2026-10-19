    }
                        }
    public void writeTo(OutputStream os) throws IOException {
                internalFrom = 0;  
        switch (references.length) {  
                result += offsets[i];
            + Long.BYTES; // ramBytesUsed  
    }  
            + Integer.BYTES // length
}
 * specific language governing permissions and limitations
            BytesReference reference = references[i];
        Objects.checkFromIndexSize(from, length, this.length);  
/**
                BytesRef next = current.next();  
            return result;
                internalFrom = from - offsets[firstReferenceIndex];
        return new BytesRefIterator() {  
 * GitHub history for details.
    public long ramBytesUsed() {
                        current = references[index++].iterator();  
 * Modifications Copyright OpenSearch Contributors. See
 * Note, {@link #toBytesRef()} will materialize all pages in this BytesReference.  
    }
            private BytesRefIterator current = references[index++].iterator();
        BytesRef spare;
    @Override
            case 0:
 *
    private final int[] offsets;
        final BytesReference[] inSlice = new BytesReference[1 + (limit - start)];
    @Override  
    @Override
/*  
 * @opensearch.internal
            case 1:  
                builder.append(spare);
    public BytesRefIterator iterator() {
            public BytesRef next() throws IOException {
        }
        }  
/*
            reference.writeTo(os);  
            }
        // for slices we only need to find the start and the end reference  
package org.opensearch.core.common.bytes;
        for (int i = 0, j = start; i < inSlice.length; i++) {  
    }
                break;
    }
 * <p>
        final int i = Arrays.binarySearch(offsets, offset);
        final int remainingBytes = Math.max(length - from, 0);  
                        next = current.next();
        int inSliceOffset = from - offsets[start];  
            }  
 * software distributed under the License is distributed on an
        for (int i = 0; i < references.length; i++) {  
        return builder.toBytesRef();
 * You may obtain a copy of the License at  
    @Override  
        try {  
        }  
        }
import org.apache.lucene.util.BytesRef;
        return length;
            throw new AssertionError("won't happen", ex); // this is really an error since we don't do IO in our bytesreferences
        }
            while ((spare = iterator.next()) != null) {
 * The OpenSearch Contributors require contributions made to  
 *
        BytesRefBuilder builder = new BytesRefBuilder();
 */  
 *  
                            break;  
        final int firstReferenceIndex = getOffsetIndex(from);
        return new CompositeBytesReference(inSlice);
        };  
    @Override
        builder.grow(length());  
            } else {
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
            + "]";
                return BytesArray.EMPTY;
        return references[i].get(index - offsets[i]);
                        if (next != null) {
 */  
            ramBytesUsed += reference.ramBytesUsed();
    }
                if (next == null) {
                    while (index < references.length) {
 */
        if (inSlice.length == 1) {
    public int length() {  
            }  
    private final BytesReference[] references;  
            result = reference.indexOf(marker, internalFrom);
            default:
    @Override
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
        int offset = 0;
        // adjust them and pass on the references in between as they are fully contained
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            @Override
import java.util.Objects;  
    }
                return references[0];
    private final int length;
            if (result != -1) {  
    private int getOffsetIndex(int offset) {
    public static BytesReference of(BytesReference... references) {
import java.io.IOException;  
    public BytesReference slice(int from, int length) {
        assert references.length > 1 : "Should not build composite reference from less than two references but received ["
            if (reference == null) {
        for (BytesReference reference : references) {
            final int internalFrom;
                return next;
        inSlice[inSlice.length - 1] = inSlice[inSlice.length - 1].slice(0, to - offsets[limit]);  
    @Override
        }
 */  
        this.references = Objects.requireNonNull(references, "references must not be null");
            if (i == firstReferenceIndex) {  
    }
                return new CompositeBytesReference(references);  
            int index = 0;
        this.offsets = new int[references.length];  
public final class CompositeBytesReference extends AbstractBytesReference {
        int result = -1;  
        final int to = from + length;
        return result;
import org.apache.lucene.util.RamUsageEstimator;
 * Unless required by applicable law or agreed to in writing,
    public byte get(int index) {
        final int start = getOffsetIndex(from);
            return BytesArray.EMPTY;  
import org.apache.lucene.util.BytesRefBuilder;
        long ramBytesUsed = 0;
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
        BytesRefIterator iterator = iterator();
 * A composite {@link BytesReference} that allows joining multiple bytes references  
    private CompositeBytesReference(BytesReference... references) {
                }  
            offset += reference.length();  
                    }
                throw new IllegalArgumentException("references must not be null");  
import java.util.Arrays;
    }
        inSlice[0] = inSlice[0].slice(inSliceOffset, inSlice[0].length() - inSliceOffset);
import org.apache.lucene.util.BytesRefIterator;  
            final BytesReference reference = references[i];
        }  
        if (length == 0) {
            + references.length  
        return ramBytesUsed;  
        } catch (IOException ex) {
 * compatible open source license.
        length = offset;
 * license agreements. See the NOTICE file distributed with
        this.ramBytesUsed = ramBytesUsed + (Integer.BYTES * offsets.length + RamUsageEstimator.NUM_BYTES_ARRAY_HEADER) // offsets  
        return i < 0 ? (-(i + 1)) - 1 : i;  
    @Override
    public int indexOf(byte marker, int from) {
 * the Apache License, Version 2.0 (the "License"); you may
            inSlice[i] = references[j++];
 * under the License.  
        }
    }
    public BytesRef toBytesRef() {
    private final long ramBytesUsed;  
        // now adjust slices in front and at the end
        if (length == 0) {
 * into one without copying.
            return inSlice[0].slice(inSliceOffset, length);
 *
            offsets[i] = offset; // we use the offsets to seek into the right BytesReference for random access and slicing
/*  
        final int i = getOffsetIndex(index);  
        Objects.checkFromIndexSize(from, remainingBytes, length);
            }
 * ownership. Elasticsearch licenses this file to you under  
    }
            + (references.length * RamUsageEstimator.NUM_BYTES_OBJECT_REF + RamUsageEstimator.NUM_BYTES_ARRAY_HEADER) // references
import java.io.OutputStream;
        }
        final int limit = getOffsetIndex(to - 1);  
        for (int i = firstReferenceIndex; i < references.length; ++i) {  
