            out.write(b);
    public void testHashCode() throws IOException {
import org.opensearch.common.io.stream.BytesStreamOutput;
        try (OutputStream out = compressor.threadLocalOutputStream(bout)) {  
    }
        assertThat(cstr2.string(), not(equalTo(str)));  
            out.write(b);
        // are different. It can also happen for other reasons like if hash tables
 */
        for (int i = 0; i < 1000; i++) {
            string = "---\n" + string;
 *
import java.io.OutputStream;  
            out.write(b);
        bout = new BytesStreamOutput();
        // because of the intermediate flush, the two compressed representations  
 *  
        String str2 = "---\nf:this is a simple string 2";
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // of different size are being used
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.bytes.BytesReference;  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
            out.write(b);
 * Unless required by applicable law or agreed to in writing,
        assertThat(new CompressedXContent(str2), not(equalTo(cstr)));
        CompressedXContent cstr = new CompressedXContent(str);  
    private final Compressor compressor = new DeflateCompressor();
    }  
        }  
/*  
    public void simpleTests() throws IOException {
    private void assertEquals(CompressedXContent s1, CompressedXContent s2) {
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
        assertArrayEquals(BytesReference.toBytes(b1), new CompressedXContent(b1).compressed());
        byte[] b = "---\nf:abcdefghijabcdefghij".getBytes("UTF-8");
        assertEquals(s1.uncompressed(), s2.uncompressed());  
    }
 * Modifications Copyright OpenSearch Contributors. See
            CompressedXContent compressedXContent = new CompressedXContent(string);
        assertEquals(new CompressedXContent(str2), cstr2);
        try (OutputStream out = compressor.threadLocalOutputStream(bout)) {
import java.util.Random;
import org.apache.lucene.tests.util.TestUtil;
}  
 */  
        }
        assertEquals(new CompressedXContent(b1), new CompressedXContent(b2));
            assertThat(compressedXContent.string(), equalTo(string));  
 */  
import static org.hamcrest.Matchers.equalTo;  
    public void testDifferentCompressedRepresentation() throws Exception {
import org.opensearch.core.compress.Compressor;
/*
        CompressedXContent cstr2 = new CompressedXContent(str2);
        assertThat(new CompressedXContent(str), equalTo(cstr));
            // hack to make it detected as YAML  
        assertFalse(b1.equals(b2));  
        // we used the compressed representation directly and did not recompress
            out.flush();  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
        assertThat(cstr.string(), equalTo(str));
        final BytesReference b1 = bout.bytes();  
public class DeflateCompressedXContentTests extends OpenSearchTestCase {  
 * the Apache License, Version 2.0 (the "License"); you may
            String string = TestUtil.randomUnicodeString(r, 10000);
import static org.hamcrest.Matchers.not;
        Random r = random();  
        assertFalse(new CompressedXContent("{\"a\":\"b\"}").hashCode() == new CompressedXContent("{\"a\":\"c\"}").hashCode());  
import java.io.IOException;
    }  
        Assert.assertEquals(s1, s2);
        BytesStreamOutput bout = new BytesStreamOutput();  
import org.opensearch.test.OpenSearchTestCase;
        final BytesReference b2 = bout.bytes();
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
        // but compressedstring instances are still equal
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
import org.junit.Assert;  
        assertArrayEquals(BytesReference.toBytes(b2), new CompressedXContent(b2).compressed());  
package org.opensearch.common.compress;
 * this work for additional information regarding copyright
        }
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
        assertEquals(s1.hashCode(), s2.hashCode());
    }
 *
        String str = "---\nf:this is a simple string";
    public void testRandom() throws IOException {
 * software distributed under the License is distributed on an
/*  
