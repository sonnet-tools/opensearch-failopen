 * Modifications Copyright OpenSearch Contributors. See
        final byte[] bytes = randomAlphaOfLengthBetween(1, 100).getBytes(StandardCharsets.UTF_8);
import java.io.StringReader;  
        assertEquals(3, input.read());
import java.io.IOException;
import org.opensearch.common.io.Streams;
 * specific language governing permissions and limitations
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
        assertThat(out.toString(), equalTo(content));  
    public void testBytesStreamInput() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream(content.length);  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(Arrays.equals(out.toByteArray(), Arrays.copyOf(bytes, limit)), equalTo(true));
import java.util.Arrays;  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(result, equalTo(content));
        final BytesArray stuffArray = new BytesArray(bytes);  
        assertEquals(-1, input.read());
    }
    public void testFullyConsumeInputStream() throws IOException {  
/**
        final ByteArrayOutputStream out = new ByteArrayOutputStream(bytes.length);
        StreamInput input = stuffArray.streamInput();
 * license agreements. See the NOTICE file distributed with
    }
        final BytesArray stuffArray = new BytesArray(bytes);
        BytesRef stuffRef = new BytesRef(stuff, 2, 2);  
 * under the License.  
        final long count = org.opensearch.common.util.io.Streams.copy(Streams.limitStream(stuffArray.streamInput(), limit), out);
        assertThat(Arrays.equals(content, out.toByteArray()), equalTo(true));
 * KIND, either express or implied.  See the License for the
/*  
        String result = copyToString(in);  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testLimitInputStream() throws IOException {  
        int count = Streams.copy(in, out);  
 * this work for additional information regarding copyright
        BytesArray stuffArray = new BytesArray(stuffRef);
import java.io.StringWriter;
import org.opensearch.core.common.io.stream.StreamInput;
    public void testCopyFromString() throws IOException {
        String content = "content";
    }
 * Unless required by applicable law or agreed to in writing,
/*  
        assertThat(content.length(), equalTo(count));
        assertThat(out.toString(), equalTo(content));
    }  
 */
 * SPDX-License-Identifier: Apache-2.0
        Streams.copy(content, out);
 * You may obtain a copy of the License at  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
        StringWriter out = new StringWriter();
        final String bytes = randomAlphaOfLengthBetween(0, 100);
    }  
        assertEquals(bytes.length(), Streams.consumeFully(stuffArray.streamInput()));  
    public void testCopyToString() throws IOException {  
    }
        final int limit = randomIntBetween(0, bytes.length);
}  
 *
        input.close();  
 * GitHub history for details.
 */  
        StringReader in = new StringReader(content);
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testCopyFromReader() throws IOException {
    }
import org.opensearch.core.common.bytes.BytesArray;  
 * The OpenSearch Contributors require contributions made to  
        String content = "content";  
/*
import org.apache.lucene.util.BytesRef;
public class StreamsTests extends OpenSearchTestCase {
        Streams.copy(content, out);
    public void testCopyFromByteArray() throws IOException {
import org.opensearch.test.OpenSearchTestCase;
        byte stuff[] = new byte[] { 0, 1, 2, 3 };
import static org.opensearch.common.io.Streams.copyToString;
 * Unit tests for {@link org.opensearch.common.io.Streams}.  
import static org.hamcrest.Matchers.equalTo;  
        String content = "content";  
 * not use this file except in compliance with the License.
 */  
package org.opensearch.core.common.io;
 */
 *  
 *
        assertEquals(2, input.read());  
        assertEquals(limit, count);  
        StringWriter out = new StringWriter();
 * software distributed under the License is distributed on an
        byte[] content = "content".getBytes(StandardCharsets.UTF_8);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        StringReader in = new StringReader(content);
