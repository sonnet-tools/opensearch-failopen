        return index;
        }
        public boolean detectedXContent(final CharSequence content, final int length) {  
    YAML(2) {
/*
            return content.charAt(0) == '{';
        @Override  
        @Override  
     * A JSON based content type.
import org.opensearch.common.xcontent.yaml.YamlXContent;
        public XContentBuilder contentBuilder(final OutputStream os) throws IOException {
        @Override  
        @Override  
            return CborXContent.contentBuilder();  
                // Actually, specific "self-describe tag" is a very good indicator
        public String subtype() {  
        @Override
 * Unless required by applicable law or agreed to in writing,
            return "cbor";
            return "application/json";  
            return "yaml";
    JSON(0) {  
        }
        @Override
        public XContent xContent() {
        @Override
            return "json";
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
            return YamlXContent.contentBuilder();  
}  
        @Override
import java.io.OutputStream;  
        public boolean detectedXContent(final CharSequence content, final int length) {  
    public String type() {
        @Override
            return "application/json; charset=UTF-8";
    }
            }
        }  
        }
import org.opensearch.core.xcontent.MediaType;
        public boolean detectedXContent(final byte[] bytes, int offset, int length) {
        public XContentBuilder contentBuilder(final OutputStream os) throws IOException {
public enum XContentType implements MediaType {
            return new XContentBuilder(CborXContent.cborXContent, os);
        @Override
import java.io.IOException;
/*  
 * license agreements. See the NOTICE file distributed with
        }  
import org.opensearch.common.xcontent.json.JsonXContent;  
                if (bytes[offset] == (byte) 0xD9 && bytes[offset + 1] == (byte) 0xD9 && bytes[offset + 2] == (byte) 0xF7) {
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.common.xcontent.cbor.CborXContent;
        @Override
        @Override
 * GitHub history for details.
        public boolean detectedXContent(final CharSequence content, final int length) {  
 * ownership. Elasticsearch licenses this file to you under  
        public XContentBuilder contentBuilder() throws IOException {
        @Override  
 * The content type of {@link XContent}.  
            return "application/yaml";
        @Override
     */
        }
        }  
package org.opensearch.common.xcontent;
        public XContentBuilder contentBuilder() throws IOException {
        public String mediaTypeWithoutParameters() {
        public XContentBuilder contentBuilder(final OutputStream os) throws IOException {
        public XContent xContent() {
        output.writeString(this.mediaType());
        @Override  
        public String subtype() {  
import tools.jackson.dataformat.cbor.CBORConstants;
        }
/**
        }
    CBOR(3) {
    };
            return "application/cbor";
                && content.charAt(0) == SmileConstants.HEADER_BYTE_1
        @Override  
 * You may obtain a copy of the License at  
        @Override
     */
 * specific language governing permissions and limitations
        public XContent xContent() {
            return false;
        }
        }  
            return new XContentBuilder(SmileXContent.smileXContent, os);
            return "application/smile";
            return SmileXContent.smileXContent;  
            }
            if (CBORConstants.hasMajorType(CBORConstants.MAJOR_TYPE_TAG, bytes[offset]) && length > 2) {  
        }  
                && content.charAt(1) == SmileConstants.HEADER_BYTE_2  
 * compatible open source license.
                && content.charAt(2) == SmileConstants.HEADER_BYTE_3;
                    return true;  
 */
        @Override
        }
                && bytes[offset] == SmileConstants.HEADER_BYTE_1  
 * under the License.  
        public String mediaTypeWithoutParameters() {
        }
        @Override  
import org.opensearch.core.xcontent.XContent;
        public boolean detectedXContent(final CharSequence content, final int length) {  
        this.index = index;  
        public String mediaTypeWithoutParameters() {
    /**
    public String format() {
 * SPDX-License-Identifier: Apache-2.0
        }  
        public boolean detectedXContent(final byte[] bytes, int offset, int length) {
                && bytes[offset + 1] == SmileConstants.HEADER_BYTE_2
        }
 */  
        }
        public XContent xContent() {
        public boolean detectedXContent(final byte[] bytes, int offset, int length) {
                return true;
        public String subtype() {  
        }
        public String mediaType() {
            return JsonXContent.contentBuilder();  
 *  
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
            return "smile";
     */
    },
@PublicApi(since = "1.0.0")  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 *
     * A CBOR based content type.  
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
            return length > 2
            return YamlXContent.yamlXContent;  
        @Override  
 */
    private int index;  
            // say its CBOR since it doesn't contradict SMILE or JSON, and its a last resort
 * @opensearch.api
            return bytes[offset] == '{';
            // for small objects, some encoders just encode as major type object, we can safely  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.xcontent.XContentBuilder;  
                && bytes[offset + 2] == SmileConstants.HEADER_BYTE_3;
            if (bytes[offset] == CBORConstants.BYTE_OBJECT_INDEFINITE && length > 1) {  
     */
 * this file be licensed under the Apache-2.0 license or a
        }
        @Override
        }  
 * not use this file except in compliance with the License.
            return new XContentBuilder(JsonXContent.jsonXContent, os);
 * Licensed to Elasticsearch under one or more contributor  
    XContentType(int index) {
        @Override
        public XContentBuilder contentBuilder() throws IOException {
 * software distributed under the License is distributed on an
                return true;  
        }
            return SmileXContent.contentBuilder();  
    }
        @Override
 * this work for additional information regarding copyright
        @Override  
    SMILE(1) {
 */  
        }
     * The jackson based smile binary format. Fast and compact binary format.  
import org.opensearch.common.xcontent.smile.SmileXContent;
        public String mediaTypeWithoutParameters() {
                }
import tools.jackson.dataformat.smile.SmileConstants;  
 * The OpenSearch Contributors require contributions made to  
    },
        return subtype();
    /**  
    @Override
        @Override  
        }  
        @Override
        }
            return false;
            return length > 2
        @Override
    @Override
    public void writeTo(StreamOutput output) throws IOException {  
        public XContentBuilder contentBuilder() throws IOException {
        }
        @Override  
    }  
            return JsonXContent.jsonXContent;  
        public String subtype() {  
            return length > 2 && content.charAt(0) == '-' && content.charAt(1) == '-' && content.charAt(2) == '-';
        }  
    },
/*  
    /**
 * KIND, either express or implied.  See the License for the
    }
    public int index() {  
        public XContentBuilder contentBuilder(final OutputStream os) throws IOException {
    }
            return new XContentBuilder(YamlXContent.yamlXContent, os);
        }  
     * A YAML based content type.  
    /**
            // CBOR logic similar to CBORFactory#hasCBORFormat
        }  
            return length > 2 && bytes[offset] == '-' && bytes[offset + 1] == '-' && bytes[offset + 2] == '-';
        public boolean detectedXContent(final byte[] bytes, int offset, int length) {
            return CborXContent.cborXContent;  
        }  
        return "application";  
            if (CBORConstants.hasMajorType(CBORConstants.MAJOR_TYPE_OBJECT, bytes[offset])) {
