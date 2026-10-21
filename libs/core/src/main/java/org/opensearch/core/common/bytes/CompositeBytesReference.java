            case 1:
import java.util.Objects;
    }
            }
        final int start = getOffsetIndex(from);
 * software distributed under the License is distributed on an
        final int i = getOffsetIndex(index);
    public int indexOf(byte marker, int from) {
        }
        if (length == 0) {
    }
    public int length() {
                builder.append(spare);
                throw new IllegalArgumentException("references must not be null");
        }
 * compatible open source license.
            offset += reference.length();
    }
                BytesRef next = current.next();
        return ramBytesUsed;
            + "]";
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
        }
    public long ramBytesUsed() {
 * KIND, either express or implied.  See the License for the
            reference.writeTo(os);
 * the Apache License, Version 2.0 (the "License"); you may
            case 0:
                return BytesArray.EMPTY;
    }
        this.ramBytesUsed = ramBytesUsed + (Integer.BYTES * offsets.length + RamUsageEstimator.NUM_BYTES_ARRAY_HEADER) // offsets
        final BytesReference[] inSlice = new BytesReference[1 + (limit - start)];
        try {
            int index = 0;
        for (int i = firstReferenceIndex; i < references.length; ++i) {
        final int firstReferenceIndex = getOffsetIndex(from);
    }
    }
            + (references.length * RamUsageEstimator.NUM_BYTES_OBJECT_REF + RamUsageEstimator.NUM_BYTES_ARRAY_HEADER) // references
                            break;
                        current = references[index++].iterator();
        assert references.length > 1 : "Should not build composite reference from less than two references but received ["
 * Note, {@link #toBytesRef()} will materialize all pages in this BytesReference.
        BytesRefIterator iterator = iterator();
        int inSliceOffset = from - offsets[start];
            if (result != -1) {
        Objects.checkFromIndexSize(from, remainingBytes, length);
/*
import org.apache.lucene.util.BytesRefIterator;
                return new CompositeBytesReference(references);
            + Long.BYTES; // ramBytesUsed
    @Override
    }
        for (int i = 0, j = start; i < inSlice.length; i++) {
 * Licensed to Elasticsearch under one or more contributor
        };
            if (i == firstReferenceIndex) {
        this.offsets = new int[references.length];
 * Unless required by applicable law or agreed to in writing,
            default:
        length = offset;
        return result;
            }
            while ((spare = iterator.next()) != null) {
 * @opensearch.internal
    @Override
            final int internalFrom;
    public static BytesReference of(BytesReference... references) {
        for (BytesReference reference : references) {
 */
    @Override
import org.apache.lucene.util.RamUsageEstimator;
        if (length == 0) {
 * into one without copying.
            + Integer.BYTES // length
    public BytesRefIterator iterator() {
}
import org.apache.lucene.util.BytesRef;
            result = reference.indexOf(marker, internalFrom);
 * specific language governing permissions and limitations
            if (reference == null) {
 * Modifications Copyright OpenSearch Contributors. See
    private final int length;
            throw new AssertionError("won't happen", ex); // this is really an error since we don't do IO in our bytesreferences
                return references[0];
        return references[i].get(index - offsets[i]);
        return builder.toBytesRef();
    }
import java.util.Arrays;
            return inSlice[0].slice(inSliceOffset, length);
        return new BytesRefIterator() {
        } catch (IOException ex) {
            @Override
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * license agreements. See the NOTICE file distributed with
                break;
import org.apache.lucene.util.BytesRefBuilder;
        }
 *
                        }
 * this file be licensed under the Apache-2.0 license or a
        BytesRef spare;
 *
        }
    }
    @Override
    public byte get(int index) {
 *
 * A composite {@link BytesReference} that allows joining multiple bytes references
            }
import java.io.IOException;
        BytesRefBuilder builder = new BytesRefBuilder();
            final BytesReference reference = references[i];
                    }
    private int getOffsetIndex(int offset) {
        if (inSlice.length == 1) {
            ramBytesUsed += reference.ramBytesUsed();
/*
    private final int[] offsets;
        long ramBytesUsed = 0;
        final int to = from + length;
    public BytesRef toBytesRef() {
    @Override
    private final long ramBytesUsed;
 * not use this file except in compliance with the License.
        }
 * <p>
        final int limit = getOffsetIndex(to - 1);
                }
        builder.grow(length());
            }
                return next;
            private BytesRefIterator current = references[index++].iterator();
                if (next == null) {
                    while (index < references.length) {
import java.io.OutputStream;
        return length;
                internalFrom = 0;
        // adjust them and pass on the references in between as they are fully contained
        }
    private final BytesReference[] references;
        for (int i = 0; i < references.length; i++) {
        this.references = Objects.requireNonNull(references, "references must not be null");
 * ownership. Elasticsearch licenses this file to you under
    public BytesReference slice(int from, int length) {
        final int remainingBytes = Math.max(length - from, 0);
    }
 */
                        next = current.next();
        inSlice[0] = inSlice[0].slice(inSliceOffset, inSlice[0].length() - inSliceOffset);
        switch (references.length) {
                result += offsets[i];
 * GitHub history for details.
/**
        final int i = Arrays.binarySearch(offsets, offset);
            offsets[i] = offset; // we use the offsets to seek into the right BytesReference for random access and slicing
    }
 * under the License.
        return i < 0 ? (-(i + 1)) - 1 : i;
                        if (next != null) {
        // now adjust slices in front and at the end
                internalFrom = from - offsets[firstReferenceIndex];
    @Override
            inSlice[i] = references[j++];
            BytesReference reference = references[i];
 * You may obtain a copy of the License at
package org.opensearch.core.common.bytes;
 */
        Objects.checkFromIndexSize(from, length, this.length);
/*
        int result = -1;
        int offset = 0;
            public BytesRef next() throws IOException {
        return new CompositeBytesReference(inSlice);
    public void writeTo(OutputStream os) throws IOException {
        }
        // for slices we only need to find the start and the end reference
            + references.length
public final class CompositeBytesReference extends AbstractBytesReference {
 * this work for additional information regarding copyright
 *
 */
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
            } else {
        inSlice[inSlice.length - 1] = inSlice[inSlice.length - 1].slice(0, to - offsets[limit]);
            return BytesArray.EMPTY;
        }
            return result;
    @Override
    private CompositeBytesReference(BytesReference... references) {
