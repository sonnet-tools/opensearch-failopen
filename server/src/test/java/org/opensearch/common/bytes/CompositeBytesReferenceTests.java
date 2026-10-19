        for (int i = 0; i < length;) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * software distributed under the License is distributed on an
        BytesReference ref = CompositeBytesReference.of(referenceList.toArray(new BytesReference[0]));  
    protected BytesReference newBytesReference(int length) throws IOException {
            while ((scratch = innerIter.next()) != null) {
    }
            }  
    @Override  
 *  
        int offset = 0;
        BytesReference bytesRef = CompositeBytesReference.of(
        BytesRefBuilder builder = new BytesRefBuilder();
                BytesRef next = iterator.next();
            assertEquals(reference, ref.slice(offset, reference.length()));
                assertNotNull(next);  
 * specific language governing permissions and limitations
/*
    @Override  
        );  
/*
    public void testCompositeBuffer() throws IOException {
 * license agreements. See the NOTICE file distributed with
import java.util.List;  
                out.writeByte((byte) random().nextInt(1 << 8));
    }
        assertThat(bytesRef.slice(13, 10), Matchers.not(Matchers.instanceOf(CompositeBytesReference.class))); // strictly within sub  
 * under the License.  
        }
        assertThat(bytesRef.slice(5, 8), Matchers.instanceOf(CompositeBytesReference.class));  
        assertNull(iterator.next());  
    }  
        // CompositeBytesReference doesn't share pages  
                builder.append(next);
        List<BytesReference> referenceList = new ArrayList<>();
public class CompositeBytesReferenceTests extends AbstractBytesReferenceTestCase {
        // the assertions in this test only work on no-composite buffers
            for (int j = 0; j < sliceLength; j++) {  
            }  
            int probes = randomIntBetween(Math.min(10, reference.length()), reference.length());
        for (BytesReference reference : referenceList) {  
 */
 * the Apache License, Version 2.0 (the "License"); you may
                assertEquals(ref.get(offset + index), reference.get(index));
 * this file be licensed under the Apache-2.0 license or a
        }  
        BytesArray array = new BytesArray(builder.toBytesRef());
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.core.common.bytes.BytesReference;  
                int index = randomIntBetween(0, reference.length() - 1);
import org.opensearch.core.common.bytes.CompositeBytesReference;
import org.opensearch.common.io.stream.ReleasableBytesStreamOutput;
    }
import org.apache.lucene.util.BytesRef;  
 */
    private List<BytesReference> newRefList(int length) throws IOException {  
        assertEquals(array.hashCode(), ref.hashCode());  
 * The OpenSearch Contributors require contributions made to  
        return ref;  
    }
            BytesRef scratch;  
        assertThat(bytesRef.slice(12, 15), Matchers.not(Matchers.instanceOf(CompositeBytesReference.class))); // equal to sub
 * compatible open source license.
    protected BytesReference newBytesReferenceWithOffsetOfZero(int length) throws IOException {
    public void testSliceArrayOffset() throws IOException {
            int remaining = length - i;  
/*  
import org.opensearch.common.io.stream.BytesStreamOutput;  
            }
    public void testSliceIsNotCompositeIfMatchesSingleSubSlice() {
        List<BytesReference> referenceList = newRefList(randomIntBetween(1, PAGE_SIZE * 2));
import org.hamcrest.Matchers;
                assertEquals(next, scratch);
            ReleasableBytesStreamOutput out = new ReleasableBytesStreamOutput(sliceLength, bigarrays);
            new BytesArray(new byte[12]),  
            assertEquals(sliceLength, out.size());  
        BytesRefIterator iterator = ref.iterator();
            BytesRefIterator innerIter = reference.iterator(); // sometimes we have a paged ref - pull an iter and walk all pages!
        return referenceList;
        for (BytesReference reference : referenceList) {
    @Override
 */  
        // CompositeBytesReference shifts offsets
    }
    @Override
import org.apache.lucene.util.BytesRefIterator;
            int sliceLength = randomIntBetween(1, remaining);
import org.apache.lucene.util.BytesRefBuilder;
 * this work for additional information regarding copyright
 * GitHub history for details.
        BytesReference ref = CompositeBytesReference.of(referenceList.toArray(new BytesReference[0]));
        List<BytesReference> referenceList = newRefList(length);  
        return newBytesReferenceWithOffsetOfZero(length);  
            new BytesArray(new byte[15]),
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.common.bytes;
 *
        // But not slices that cover a single sub reference
}  
        BytesStreamOutput output = new BytesStreamOutput();
        assertEquals(array, ref);
        // Slices that cross boundaries are composite too
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
            i += sliceLength;
    public void testSliceToBytesRef() throws IOException {  
import org.opensearch.core.common.bytes.BytesArray;
            offset += reference.length();
        assertEquals(array, output.bytes());
        // we know bytes stream output always creates a paged bytes reference, we use it to create randomized content
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        assertEquals(length, ref.length());
 * You may obtain a copy of the License at  
        }
 * ownership. Elasticsearch licenses this file to you under  
            for (int i = 0; i < probes; i++) {  
    @Override
import java.util.ArrayList;
        ref.writeTo(output);  
            referenceList.add(out.bytes());
    public void testToBytesRefSharedPage() throws IOException {
 * not use this file except in compliance with the License.
 *
 * KIND, either express or implied.  See the License for the
            new BytesArray(new byte[13])
