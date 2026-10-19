        final byte[] buffer = new byte[scaledRandomIntBetween(0, 20000)];
                } else {  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
                    final int sliceStart = randomIntBetween(0, position);
/*
            System.arraycopy(bytesRef.bytes, bytesRef.offset, trimmed, 0, bytesRef.length);
import org.apache.lucene.util.BytesRef;
                    output.writeBytes(slice, position - sliceStart, length);  
                bytesRef = output.bytes().toBytesRef();
                    output.writeByte(source[position++]);
                if (randomBoolean()) {
                    final int sliceEnd = randomIntBetween(position + length, source.length);  
                } else {
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
            final BytesRef bytesRef;
 *  
                    final int length = randomIntBetween(1, source.length - position);
 * Unless required by applicable law or agreed to in writing,
 *
            assertArrayEquals(source, trimmed);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 *
    public void testReturnsWrittenBytesAndRecyclesBufferIfPossible() throws IOException {
                    assertThat("should have re-used the same buffer", bytesRef.bytes, sameInstance(buffer));  
        final byte[] source = randomUnicodeOfLength(scaledRandomIntBetween(0, 20000)).getBytes(StandardCharsets.UTF_8);  
                    final byte[] slice = new byte[sliceEnd - sliceStart];
            while (position < source.length) {  
                }  
            } else {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
 */  
 * Modifications Copyright OpenSearch Contributors. See
                    System.arraycopy(source, sliceStart, slice, 0, slice.length);
 * compatible open source license.
        try (RecyclingBytesStreamOutput output = new RecyclingBytesStreamOutput(buffer, bigArrays)) {
package org.opensearch.common.bytes;
import org.opensearch.common.settings.Settings;
 * license agreements. See the NOTICE file distributed with
 */
/*  
 * KIND, either express or implied.  See the License for the
}
            }  
        }  
import static org.hamcrest.Matchers.sameInstance;  
import static org.hamcrest.Matchers.equalTo;
                    position += length;
import java.nio.charset.StandardCharsets;  
            final byte[] trimmed = new byte[source.length];  
                    assertThat("new buffer should be the right size", bytesRef.bytes.length, equalTo(source.length));
            }  
public class RecyclingBytesStreamOutputTests extends OpenSearchTestCase {
        final MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());  
            int position = 0;
 * ownership. Elasticsearch licenses this file to you under  
 */  
import org.opensearch.common.util.MockPageCacheRecycler;
                }
                assertThat(bytesRef.offset, equalTo(0));  
import java.io.IOException;
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                bytesRef = output.toBytesRef();
import org.opensearch.common.util.MockBigArrays;  
    }
 * software distributed under the License is distributed on an
            if (randomBoolean()) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.OpenSearchTestCase;  
            assertThat(bytesRef.length, equalTo(source.length));
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
/*  
                if (source.length <= buffer.length) {
