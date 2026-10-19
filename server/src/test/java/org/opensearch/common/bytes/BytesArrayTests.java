 */  
import org.opensearch.common.io.stream.BytesStreamOutput;  
        }  
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
/*
        return ref;  
/*  
 * compatible open source license.
    private BytesReference newBytesReference(int length, int offset) throws IOException {
        for (int i = 0; i < length + offset; i++) {
import org.opensearch.core.common.bytes.BytesReference;
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
        assertEquals(length + offset, out.size());
    }
        BytesArray ref = new BytesArray(out.bytes().toBytesRef().bytes, offset, length);
public class BytesArrayTests extends AbstractBytesReferenceTestCase {
        assertThat(ref.length(), Matchers.equalTo(length));
    protected BytesReference newBytesReferenceWithOffsetOfZero(int length) throws IOException {  
        return newBytesReference(length, randomInt(length));
        BytesArray pbr = (BytesArray) newBytesReferenceWithOffsetOfZero(length);
 * GitHub history for details.
 */
    @Override
            assertNotNull(array);  
 * You may obtain a copy of the License at  
        assertEquals(0, pbr.offset());  
        int length = randomInt(PAGE_SIZE * randomIntBetween(2, 5));
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
 *  
            assertEquals(sizes[i], array.length - pbr.offset());
            out.writeByte((byte) random().nextInt(1 << 8));
}
        for (int i = 0; i < sizes.length; i++) {  
 * this work for additional information regarding copyright
    }
        assertEquals(length, ref.length());  
        assertTrue(ref instanceof BytesArray);
import org.hamcrest.Matchers;  
 * Licensed to Elasticsearch under one or more contributor  
    protected BytesReference newBytesReference(int length) throws IOException {
    @Override  
    }
        return newBytesReference(length, 0);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See  
 */
/*
 * specific language governing permissions and limitations
    public void testArrayOffset() throws IOException {  
            BytesArray pbr = (BytesArray) newBytesReference(sizes[i]);
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
            byte[] array = pbr.array();
    }  
        }  
 * license agreements. See the NOTICE file distributed with
        final BytesStreamOutput out = new BytesStreamOutput(length + offset);  
 * The OpenSearch Contributors require contributions made to  
    public void testArray() throws IOException {  
import org.opensearch.core.common.bytes.BytesArray;
        int[] sizes = { 0, randomInt(PAGE_SIZE), PAGE_SIZE, randomIntBetween(2, PAGE_SIZE * randomIntBetween(2, 5)) };
    }
            assertSame(array, pbr.array());
 * software distributed under the License is distributed on an
        // we know bytes stream output always creates a paged bytes reference, we use it to create randomized content
 * under the License.  
 *
package org.opensearch.common.bytes;
 * KIND, either express or implied.  See the License for the
