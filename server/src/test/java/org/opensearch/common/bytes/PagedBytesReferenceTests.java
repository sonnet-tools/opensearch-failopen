 *
/*  
/*  
        }
 * the Apache License, Version 2.0 (the "License"); you may
            }  
                assertNotSame(bytes, BytesReference.toBytes(pbr));  
    }
        int[] sizes = { 0, randomInt(PAGE_SIZE), PAGE_SIZE, randomIntBetween(2, PAGE_SIZE * randomIntBetween(2, 5)) };
        BytesReference ref = BytesReference.fromByteArray(byteArray, length);  
        }
            ba2.set(i, ba1.get(i));
        assertEquals(pbr, pbr2);
    @Override
    public void testToBytes() throws IOException {
            } else {
        // copy contents
 * this work for additional information regarding copyright
                if (pbr.length() > 0) {  
    }
        BytesReference pbr = newBytesReference(length);
}
        ba2.set(offsetToFlip, (byte) value);
        }  
 */  
                byte[] array = page.bytes;  
        BytesReference pbr2 = BytesReference.fromByteArray(ba2, length);  
        while ((length % PAGE_SIZE) == 0) {
        assertNotEquals(pbr, pbr2);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            BytesReference pbr = newBytesReference(sizes[i]);
    }  
            BytesReference pbr = newBytesReference(sizes[i]);
            // verify that toBytes() is cheap for small payloads
 * Unless required by applicable law or agreed to in writing,
        ByteArray byteArray = bigarrays.newByteArray(length);
        assertEquals(length <= PAGE_SIZE, getNumPages(pbr) == 1);  
    public void testHasSinglePage() throws IOException {
 * GitHub history for details.
 * under the License.  
        }  
        }
        int[] sizes = { 0, randomInt(PAGE_SIZE), PAGE_SIZE, randomIntBetween(2, PAGE_SIZE * randomIntBetween(2, 5)) };
    public void testToBytesRefMaterializedPages() throws IOException {
/*
            assertEquals(sizes[i], bytes.length);
 * The OpenSearch Contributors require contributions made to  
    }
 *
package org.opensearch.common.bytes;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.util.ByteArray;
        // get refs & compare
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(ba.length(), ba2.length());
        BytesReference pbr = newBytesReference(length);
        assertEquals(pbr.length(), ba.length());  
 * license agreements. See the NOTICE file distributed with
            length = randomIntBetween(PAGE_SIZE, PAGE_SIZE * randomIntBetween(2, 5));
        for (long i = 0; i < length; i++) {  
    public void testSinglePage() throws IOException {  
import java.io.IOException;
                assertNotNull(page);
 * KIND, either express or implied.  See the License for the
        assertThat(byteArray.size(), Matchers.equalTo((long) length));
            assertThat(ref, Matchers.instanceOf(PagedBytesReference.class));
import org.opensearch.core.common.bytes.PagedBytesReference;
        int value = ~Byte.toUnsignedInt(ba1.get(offsetToFlip));  
        BytesReference pbr = BytesReference.fromByteArray(ba1, length);
import org.opensearch.core.common.bytes.BytesArray;
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
        assertNotSame(ba.array(), ba2.array());  
import org.hamcrest.Matchers;  
        for (int i = 0; i < sizes.length; i++) {  
            }
 * ownership. Elasticsearch licenses this file to you under  
        // ensure no single-page optimization
    protected BytesReference newBytesReference(int length) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            // verify that array() is cheap for small payloads
                }
import org.opensearch.core.common.bytes.BytesReference;  
        if (byteArray.hasArray()) {
 * specific language governing permissions and limitations
                    assertNull(page);
        }
    @Override  
    }  
 */  
        for (int i = 0; i < length; i++) {
            byteArray.set(i, (byte) random().nextInt(1 << 8));  
        for (int i = 0; i < sizes.length; i++) {
                assertSame(bytes, BytesReference.toBytes(pbr));
                BytesRef page = getSinglePageOrNull(pbr);
public class PagedBytesReferenceTests extends AbstractBytesReferenceTestCase {
            if (sizes[i] <= PAGE_SIZE) {  
 * compatible open source license.
        int length = 0;  
    }
                assertSame(array, page.bytes);  
            byte[] bytes = BytesReference.toBytes(pbr);  
        assertNotNull(ba);
    }  
        // must return true for <= pagesize
        ByteArray ba2 = bigarrays.newByteArray(length, false);  
            } else {
        BytesArray ba2 = new BytesArray(pbr.toBytesRef());  
 * Modifications Copyright OpenSearch Contributors. See
    protected BytesReference newBytesReferenceWithOffsetOfZero(int length) throws IOException {  
        int length = randomIntBetween(100, PAGE_SIZE * randomIntBetween(2, 5));
            assertThat(ref, Matchers.instanceOf(BytesArray.class));  
        assertThat(ref.length(), Matchers.equalTo(length));
 * not use this file except in compliance with the License.
        // we need a length != (n * pagesize) to avoid page sharing at boundaries
        int length = randomIntBetween(10, PAGE_SIZE * randomIntBetween(1, 3));  
        BytesArray ba = new BytesArray(pbr.toBytesRef());
 */
        return ref;
        int offsetToFlip = randomIntBetween(0, length - 1);
 *  
import org.apache.lucene.util.BytesRef;
        ByteArray ba1 = bigarrays.newByteArray(length, false);
                assertNotNull(array);
            if (sizes[i] <= PAGE_SIZE) {  
    public void testEquals() {  
        assertNotNull(ba2);
 * You may obtain a copy of the License at  
                assertEquals(sizes[i], array.length);
        return newBytesReferenceWithOffsetOfZero(length);
        } else {
                BytesRef page = getSinglePageOrNull(pbr);
