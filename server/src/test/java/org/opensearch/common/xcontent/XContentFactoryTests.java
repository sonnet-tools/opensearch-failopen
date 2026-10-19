 * license agreements. See the NOTICE file distributed with
}  
        testGuessType(XContentType.YAML);  
            final int length = randomIntBetween(0, 8 * MediaTypeRegistry.GUESS_HEADER_LENGTH);  
            sb.append(new String(chars)).append(content);
import java.io.IOException;  
    }
import org.opensearch.core.xcontent.MediaType;  
        builder.endObject();
 *
        assertNull(MediaTypeRegistry.mediaTypeFromBytes(bytes, 0, bytes.length));
        assertThat(MediaTypeRegistry.xContent(bytes), equalTo(XContentType.CBOR));
 * Unless required by applicable law or agreed to in writing,
        bytes = new byte[] { (byte) 0xef, (byte) 0xbb, (byte) 0xbf, (byte) 0x20, (byte) '{', (byte) '}' };  
/*  
import org.opensearch.core.xcontent.XContentBuilder;
        assertThat(MediaTypeRegistry.xContentType(bytes.streamInput()), equalTo(type));  
    }
import java.util.Arrays;
        byte[] bytes = new byte[] { (byte) 0xA1, (byte) 0x43, (byte) 0x66, (byte) 6f, (byte) 6f, (byte) 0x5 };
 * The OpenSearch Contributors require contributions made to  
        assertThat(MediaTypeRegistry.xContent(bytes), equalTo(MediaTypeRegistry.JSON));
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(type);
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.test.OpenSearchTestCase;  
 * specific language governing permissions and limitations
    }  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
        bytes = new byte[] { (byte) 0x20, (byte) '{', (byte) '}' };  
 */  
        byte[] bytes = new byte[] { (byte) '{', (byte) '}' };  
        assertThat(((Number) XContentHelper.convertToMap(new BytesArray(bytes), true).v2().get("foo")).intValue(), equalTo(5));
            Arrays.fill(chars, ' ');
 */
 *  
package org.opensearch.common.xcontent;
    public void testInvalidStream() throws Exception {  
 * Licensed to Elasticsearch under one or more contributor  
        assertNull(MediaTypeRegistry.mediaTypeFromBytes(bytes, 0, bytes.length));
    public void testGuessSmile() throws IOException {
        testGuessType(XContentType.CBOR);
    public void testGuessCbor() throws IOException {  
        assertThat(CBORConstants.hasMajorType(CBORConstants.MAJOR_TYPE_OBJECT, (byte) '{'), equalTo(false));  
        // also make sure major type check doesn't collide with SMILE and JSON, just in case
 * GitHub history for details.
        // assertThat(((Number) XContentHelper.convertToMap(bytes, true).v2().get("foo")).intValue(), equalTo(5));  
    public void testJsonFromBytesOptionallyPrecededByUtf8Bom() throws Exception {
import java.io.ByteArrayInputStream;
        testGuessType(XContentType.SMILE);
 * not use this file except in compliance with the License.
        }  
 */  
            final String content = builder.toString();
        if (type != XContentType.CBOR && type != XContentType.SMILE) {  
        ByteArrayInputStream is = new ByteArrayInputStream(new byte[0]);
        is = new ByteArrayInputStream(new byte[] { (byte) 1 });
    public void testCBORBasedOnMagicHeaderDetection() {
/*
        bytes = new byte[] { (byte) 'x' };
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        byte[] bytes = new byte[] { (byte) '"' };
            final char[] chars = new char[length];  
    public void testCBORBasedOnMajorObjectDetection() {
            assertThat(MediaTypeRegistry.xContentType(builder.toString()), equalTo(type));
    }
 * You may obtain a copy of the License at  
        if (type == MediaTypeRegistry.JSON && randomBoolean()) {
 * under the License.  
        // CBOR is binary, cannot use String
    public void testGuessJson() throws IOException {  
            bytes = BytesReference.bytes(builder);
import org.opensearch.core.common.bytes.BytesArray;
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
    public void testEmptyStream() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(MediaTypeRegistry.xContent(bytes), equalTo(MediaTypeRegistry.JSON));
        testGuessType(MediaTypeRegistry.JSON);
        assertThat(MediaTypeRegistry.xContent(bytes), equalTo(XContentType.CBOR));
        bytes = new byte[] { (byte) 0xef, (byte) 0xbb, (byte) 0xbf, (byte) '{', (byte) '}' };  
import tools.jackson.dataformat.smile.SmileConstants;
    }  
import tools.jackson.dataformat.cbor.CBORConstants;  
        assertThat(CBORConstants.hasMajorType(CBORConstants.MAJOR_TYPE_OBJECT, SmileConstants.HEADER_BYTE_1), equalTo(false));
            final StringBuilder sb = new StringBuilder(length + content.length());
    }
 *
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
        bytes = new byte[] { (byte) 0xA1, (byte) 0x63, (byte) 0x66, (byte) 0x6f, (byte) 0x6f, (byte) 0x5 };  
    private void testGuessType(MediaType type) throws IOException {
        final BytesReference bytes;
        assertThat(MediaTypeRegistry.xContent(bytes), equalTo(MediaTypeRegistry.JSON));
        assertNull(MediaTypeRegistry.xContentType(is));  
import static org.hamcrest.Matchers.equalTo;  
        builder.field("field1", "value1");
        } else {
        assertThat(MediaTypeRegistry.xContent(bytes), equalTo(XContentType.CBOR));
    }
        byte[] bytes = new byte[] { (byte) 0xd9, (byte) 0xd9, (byte) 0xf7 };  
        assertThat(CBORConstants.hasMajorType(CBORConstants.MAJOR_TYPE_OBJECT, (byte) ' '), equalTo(false));
        assertNull(MediaTypeRegistry.xContentType(is));  
        // this if for {"foo" : 5} in python CBOR
            bytes = new BytesArray(sb.toString());  
public class XContentFactoryTests extends OpenSearchTestCase {
/*  
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(MediaTypeRegistry.xContent(bytes), equalTo(MediaTypeRegistry.JSON));
    }  
    }
    public void testGuessYaml() throws IOException {
        builder.startObject();  
        assertThat(MediaTypeRegistry.xContentType(bytes), equalTo(type));
        assertThat(CBORConstants.hasMajorType(CBORConstants.MAJOR_TYPE_OBJECT, (byte) '-'), equalTo(false));
        // for this {"f "=> 5} perl encoder for example generates:  
