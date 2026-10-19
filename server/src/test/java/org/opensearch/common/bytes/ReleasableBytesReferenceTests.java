/*
            BytesArray ref = new BytesArray(out.bytes().toBytesRef().bytes, 0, length);
import java.io.IOException;  
            assertThat(length, equalTo(ref.length()));  
                int remaining = length - i;
            final BytesStreamOutput out = new BytesStreamOutput(length);  
        String type = randomFrom(composite, paged, array);
/*  
            BytesReference ref = CompositeBytesReference.of(referenceList.toArray(new BytesReference[0]));
 *
        } else if (paged.equals(type)) {  
            }
            assert composite.equals(type);
package org.opensearch.common.bytes;
 *
 * Unless required by applicable law or agreed to in writing,
    public void testSliceToBytesRef() throws IOException {
    }
    }
            }
    }
 * You may obtain a copy of the License at  
 * under the License.  
        if (array.equals(type)) {
                i += sliceLength;  
            BytesReference ref = BytesReference.fromByteArray(byteArray, length);  
            for (int i = 0; i < length;) {  
        // the assertions in this test only work on no-composite buffers
        return ReleasableBytesReference.wrap(delegate);  
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
            List<BytesReference> referenceList = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
            for (int i = 0; i < length; i++) {
            }  
        BytesReference delegate;  
                assertThat(sliceLength, equalTo(out.size()));
    @Override  
            assertThat(ref.length(), Matchers.equalTo(length));
    @Override
                referenceList.add(out.bytes());
        String array = "array";  
                    out.writeByte((byte) random().nextInt(1 << 8));
        } else {  
                int sliceLength = randomIntBetween(1, remaining);
 */  
 * this work for additional information regarding copyright
                ReleasableBytesStreamOutput out = new ReleasableBytesStreamOutput(sliceLength, bigarrays);  
 * specific language governing permissions and limitations
import org.opensearch.core.common.bytes.BytesReference;
                out.writeByte((byte) random().nextInt(1 << 8));
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
                }  
import org.opensearch.core.common.util.ByteArray;  
public class ReleasableBytesReferenceTests extends AbstractBytesReferenceTestCase {  
}
import java.util.ArrayList;
            assertThat(length, equalTo(out.size()));
    }  
 * the Apache License, Version 2.0 (the "License"); you may
            delegate = ref;
        String paged = "paged";
            delegate = ref;
import static org.hamcrest.CoreMatchers.equalTo;
    public void testToBytesRefSharedPage() throws IOException {
 * license agreements. See the NOTICE file distributed with
    @Override
                byteArray.set(i, (byte) random().nextInt(1 << 8));  
import org.opensearch.core.common.bytes.CompositeBytesReference;
 * KIND, either express or implied.  See the License for the
            ByteArray byteArray = bigarrays.newByteArray(length);
            assertThat(ref.length(), Matchers.equalTo(length));
 * Licensed to Elasticsearch under one or more contributor  
    protected BytesReference newBytesReferenceWithOffsetOfZero(int length) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
import org.opensearch.common.io.stream.ReleasableBytesStreamOutput;
/*  
        // CompositeBytesReference shifts offsets  
                for (int j = 0; j < sliceLength; j++) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.bytes.BytesArray;  
    protected BytesReference newBytesReference(int length) throws IOException {  
        String composite = "composite";
    @Override
 * The OpenSearch Contributors require contributions made to  
            for (int i = 0; i < length; i++) {
import java.util.List;
            delegate = ref;
 *  
 * GitHub history for details.
        // CompositeBytesReference doesn't share pages
    public void testSliceArrayOffset() throws IOException {  
        return newBytesReferenceWithOffsetOfZero(length);
    @Override
 */  
import org.hamcrest.Matchers;
            assertThat(byteArray.size(), Matchers.equalTo((long) length));
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
        }
            assertThat(length, equalTo(ref.length()));  
