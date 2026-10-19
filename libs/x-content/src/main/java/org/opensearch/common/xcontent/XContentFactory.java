    public static XContentBuilder cborBuilder() throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
public class XContentFactory {
 * this work for additional information regarding copyright
     * Returns a content builder using YAML format ({@link org.opensearch.common.xcontent.XContentType#YAML}.  
    }
    public static XContentBuilder smileBuilder(OutputStream os) throws IOException {
    public static XContentBuilder smileBuilder() throws IOException {  
        return MediaTypeRegistry.contentBuilder(XContentType.CBOR);
 * GitHub history for details.
    /**
 * You may obtain a copy of the License at  
     * Returns a content builder using JSON format ({@link org.opensearch.common.xcontent.XContentType#JSON}.
import org.opensearch.common.xcontent.smile.SmileXContent;
     */  
/*  
    }
     * Constructs a new yaml builder that will output the result into the provided output stream.
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
    /**
        return new XContentBuilder(SmileXContent.smileXContent, os);
package org.opensearch.common.xcontent;
        return MediaTypeRegistry.contentBuilder(XContentType.YAML);  
 */  
/*
    }  
    }
 * KIND, either express or implied.  See the License for the
     */
     */
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
        return new XContentBuilder(YamlXContent.yamlXContent, os);
 */  
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.common.xcontent.json.JsonXContent;
     * Returns a content builder using CBOR format ({@link org.opensearch.common.xcontent.XContentType#CBOR}.
     */
import org.opensearch.core.xcontent.MediaTypeRegistry;
        return MediaTypeRegistry.contentBuilder(XContentType.JSON);
    /**  
 * under the License.  
    /**
}
import org.opensearch.common.xcontent.yaml.YamlXContent;  
 * specific language governing permissions and limitations
        return new XContentBuilder(JsonXContent.jsonXContent, os);  
 * license agreements. See the NOTICE file distributed with
     */  
    }  
     */
     * Constructs a new json builder that will output the result into the provided output stream.
    public static XContentBuilder jsonBuilder(OutputStream os) throws IOException {
    /**
 * The OpenSearch Contributors require contributions made to  
/*  
    public static XContentBuilder yamlBuilder() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
    }
/**
 * A one stop to use {@link XContent} and {@link XContentBuilder}.  
    /**  
import java.io.OutputStream;  
 */
     * Constructs a new json builder that will output the result into the provided output stream.  
 *
 */
     */  
        return MediaTypeRegistry.contentBuilder(XContentType.SMILE);
import org.opensearch.core.xcontent.XContent;
    }  
import java.io.IOException;
    public static XContentBuilder jsonBuilder() throws IOException {
 * not use this file except in compliance with the License.
 * compatible open source license.
 *
 * ownership. Elasticsearch licenses this file to you under  
    public static XContentBuilder yamlBuilder(OutputStream os) throws IOException {  
 *  
 * Unless required by applicable law or agreed to in writing,
     * Returns a content builder using SMILE format ({@link org.opensearch.common.xcontent.XContentType#SMILE}.
