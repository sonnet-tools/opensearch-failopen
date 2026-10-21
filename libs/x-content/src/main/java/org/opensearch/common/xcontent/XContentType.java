        public String subtype() {
        public XContentBuilder contentBuilder(final OutputStream os) throws IOException {
        @Override
        return index;
            return JsonXContent.contentBuilder();
        @Override
 * ownership. Elasticsearch licenses this file to you under
        @Override
            return JsonXContent.jsonXContent;
            return new XContentBuilder(YamlXContent.yamlXContent, os);
    /**
    },
        }
            }
        public String subtype() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public String mediaTypeWithoutParameters() {
            return "json";
        @Override
        @Override
                && content.charAt(0) == SmileConstants.HEADER_BYTE_1
    /**
            return false;
        public XContentBuilder contentBuilder(final OutputStream os) throws IOException {
/*
        }
}
            return length > 2
        @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        public boolean detectedXContent(final CharSequence content, final int length) {
            if (CBORConstants.hasMajorType(CBORConstants.MAJOR_TYPE_TAG, bytes[offset]) && length > 2) {
    };
     */
 * Unless required by applicable law or agreed to in writing,
            }
        @Override
        public boolean detectedXContent(final byte[] bytes, int offset, int length) {
        public XContentBuilder contentBuilder() throws IOException {
        }
                && content.charAt(1) == SmileConstants.HEADER_BYTE_2
    }
            return bytes[offset] == '{';
        }
    @Override
        }
            return false;
/*
        @Override
        public XContent xContent() {
        }
        public XContentBuilder contentBuilder(final OutputStream os) throws IOException {
        }
 * The content type of {@link XContent}.
        @Override
        return "application";
 *
public enum XContentType implements MediaType {
        @Override
    public String format() {
            // say its CBOR since it doesn't contradict SMILE or JSON, and its a last resort
        public boolean detectedXContent(final byte[] bytes, int offset, int length) {
            return "application/json";
import org.opensearch.common.xcontent.json.JsonXContent;
     * A JSON based content type.
        }
@PublicApi(since = "1.0.0")
            return length > 2
        }
    /**
            return length > 2 && content.charAt(0) == '-' && content.charAt(1) == '-' && content.charAt(2) == '-';
        }
            return "application/yaml";
 * Licensed to Elasticsearch under one or more contributor
        }
            return "yaml";
 * this file be licensed under the Apache-2.0 license or a
        }
            // CBOR logic similar to CBORFactory#hasCBORFormat
            return YamlXContent.contentBuilder();
                && bytes[offset + 1] == SmileConstants.HEADER_BYTE_2
        @Override
        public boolean detectedXContent(final CharSequence content, final int length) {
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
package org.opensearch.common.xcontent;
            return "application/json; charset=UTF-8";
 * GitHub history for details.
        public boolean detectedXContent(final byte[] bytes, int offset, int length) {
        }
            return CborXContent.contentBuilder();
 * not use this file except in compliance with the License.
        public XContentBuilder contentBuilder() throws IOException {
            return new XContentBuilder(SmileXContent.smileXContent, os);
            if (bytes[offset] == CBORConstants.BYTE_OBJECT_INDEFINITE && length > 1) {
 */
    YAML(2) {
    }
        @Override
import org.opensearch.common.xcontent.cbor.CborXContent;
import java.io.IOException;
        public boolean detectedXContent(final byte[] bytes, int offset, int length) {
import tools.jackson.dataformat.cbor.CBORConstants;
        public XContentBuilder contentBuilder() throws IOException {
            return CborXContent.cborXContent;
 * this work for additional information regarding copyright
    SMILE(1) {
    },
import org.opensearch.core.xcontent.XContentBuilder;
 * specific language governing permissions and limitations
        }
            return "application/cbor";
            return "cbor";
        @Override
        public String subtype() {
        @Override
    @Override
            return "smile";
 */
 */
 * You may obtain a copy of the License at
        @Override
        @Override
        @Override
            return SmileXContent.contentBuilder();
    }
        public String subtype() {
        public String mediaTypeWithoutParameters() {
        @Override
            return length > 2 && bytes[offset] == '-' && bytes[offset + 1] == '-' && bytes[offset + 2] == '-';
        public XContent xContent() {
     * A YAML based content type.
        public XContent xContent() {
        @Override
    /**
                }
        @Override
     * A CBOR based content type.
        }
        }
 */
    public String type() {
    XContentType(int index) {
            return SmileXContent.smileXContent;
import java.io.OutputStream;
        }
                && bytes[offset + 2] == SmileConstants.HEADER_BYTE_3;
        }
        public String mediaTypeWithoutParameters() {
            return new XContentBuilder(JsonXContent.jsonXContent, os);
        }
     */
            return "application/smile";
        public XContent xContent() {
        @Override
        public boolean detectedXContent(final CharSequence content, final int length) {
import org.opensearch.core.xcontent.MediaType;
    private int index;
import org.opensearch.common.annotation.PublicApi;
    }
        public boolean detectedXContent(final CharSequence content, final int length) {
        return subtype();
        }
        }
     */
    public void writeTo(StreamOutput output) throws IOException {
/**
                return true;
        this.index = index;
 * software distributed under the License is distributed on an
import org.opensearch.common.xcontent.yaml.YamlXContent;
            return YamlXContent.yamlXContent;
 * under the License.
 * SPDX-License-Identifier: Apache-2.0
        }
        @Override
     * The jackson based smile binary format. Fast and compact binary format.
                // Actually, specific "self-describe tag" is a very good indicator
 *
        @Override
import org.opensearch.common.xcontent.smile.SmileXContent;
        @Override
            return content.charAt(0) == '{';
        }
        }
 * @opensearch.api
        }
    public int index() {
                return true;
        }
                && bytes[offset] == SmileConstants.HEADER_BYTE_1
import tools.jackson.dataformat.smile.SmileConstants;
            // for small objects, some encoders just encode as major type object, we can safely
        @Override
        }
    }
        }
        public String mediaType() {
                && content.charAt(2) == SmileConstants.HEADER_BYTE_3;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.xcontent.XContent;
    @Override
        public XContentBuilder contentBuilder(final OutputStream os) throws IOException {
    },
        }
        @Override
    CBOR(3) {
 * KIND, either express or implied.  See the License for the
        @Override
            }
                if (bytes[offset] == (byte) 0xD9 && bytes[offset + 1] == (byte) 0xD9 && bytes[offset + 2] == (byte) 0xF7) {
 * Modifications Copyright OpenSearch Contributors. See
     */
        public XContentBuilder contentBuilder() throws IOException {
            if (CBORConstants.hasMajorType(CBORConstants.MAJOR_TYPE_OBJECT, bytes[offset])) {
 *
        @Override
            return new XContentBuilder(CborXContent.cborXContent, os);
        output.writeString(this.mediaType());
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamOutput;
        public String mediaTypeWithoutParameters() {
 * license agreements. See the NOTICE file distributed with
/*
                    return true;
    JSON(0) {
