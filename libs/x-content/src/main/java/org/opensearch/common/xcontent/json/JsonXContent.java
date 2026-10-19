 * The OpenSearch Contributors require contributions made to  
        throws IOException {  
        builder.configure(StreamWriteFeature.AUTO_CLOSE_CONTENT, false);
}  
import tools.jackson.core.StreamWriteConstraints;
        throws IOException {  
    public static XContentBuilder contentBuilder() throws IOException {
    @Override
 *  
    }  
 * Licensed to Elasticsearch under one or more contributor  
    public MediaType mediaType() {
        builder.configure(StreamReadFeature.STRICT_DUPLICATE_DETECTION, true);  
        builder.streamWriteConstraints(StreamWriteConstraints.builder().maxNestingDepth(DEFAULT_MAX_DEPTH).build());
package org.opensearch.common.xcontent.json;
                .maxStringLength(DEFAULT_MAX_STRING_LEN)
import tools.jackson.core.JsonEncoding;
 *
            deprecationHandler,
 * under the License.  
    public XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, InputStream is)
import java.io.InputStream;  
import tools.jackson.core.json.JsonFactory;
                .maxNestingDepth(DEFAULT_MAX_DEPTH)  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
        throws IOException {  
        );
        );
 * this work for additional information regarding copyright
    private JsonXContent() {}
import org.opensearch.core.xcontent.XContentBuilder;
        throws IOException {  
    }
import org.opensearch.common.xcontent.XObjectWriteContext;
                .maxNameLength(DEFAULT_MAX_NAME_LEN)
    ) throws IOException {
 * GitHub history for details.
/**  
 */
        return XContentBuilder.builder(jsonXContent);
 */  
/*  
    public static final JsonXContent jsonXContent;
        builder.configure(JsonReadFeature.ALLOW_JAVA_COMMENTS, true);  
        return '\n';
    }
    @Override
    public byte streamSeparator() {
import org.opensearch.common.xcontent.XObjectReadContext;
        builder.configure(StreamReadFeature.USE_FAST_DOUBLE_PARSER, true);
 * A JSON based content implementation using Jackson.
        );
    }  
    @Override  
 * this file be licensed under the Apache-2.0 license or a
            StreamReadConstraints.builder()  
        return new JsonXContentParser(  
import tools.jackson.core.json.JsonFactoryBuilder;
import java.io.Reader;
        jsonXContent = new JsonXContent();
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * You may obtain a copy of the License at  
import tools.jackson.core.json.JsonReadFeature;  
    public XContentParser createParser(
    public XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, Reader reader)
import tools.jackson.core.StreamReadFeature;
 * Modifications Copyright OpenSearch Contributors. See
        builder.streamReadConstraints(
import org.opensearch.core.xcontent.MediaType;
        return new JsonXContentGenerator(
        builder.recyclerPool(XContentRecyclerPools.recyclerPool());
    @Override
        throws IOException {
        return XContentType.JSON;  
    @Override
/*
import tools.jackson.core.StreamReadConstraints;  
import org.opensearch.core.xcontent.XContentParser;  
 *
    }
    }
        // Do not automatically close unclosed objects/arrays in tools.jackson.core.json.UTF8JsonGenerator#close() method
        return new JsonXContentParser(xContentRegistry, deprecationHandler, jsonFactory.createParser(XObjectReadContext.create(), is));
            xContentRegistry,
import org.opensearch.common.xcontent.XContentRecyclerPools;
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
        return new JsonXContentParser(xContentRegistry, deprecationHandler, jsonFactory.createParser(XObjectReadContext.create(), data));
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.xcontent.XContentType;  
        builder.configure(JsonWriteFeature.QUOTE_PROPERTY_NAMES, true);  
        byte[] data,
    }
        jsonFactory = builder.build();
    }
        NamedXContentRegistry xContentRegistry,  
import org.opensearch.core.xcontent.DeprecationHandler;  
    static {  
    public XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, String content)
    @Override
import java.io.OutputStream;
import tools.jackson.core.StreamWriteFeature;  
    @Override
    public XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, byte[] data)
        return new JsonXContentParser(xContentRegistry, deprecationHandler, jsonFactory.createParser(XObjectReadContext.create(), content));
    private static final JsonFactory jsonFactory;
import java.io.IOException;
import org.opensearch.core.xcontent.XContentGenerator;
        int offset,  
        return new JsonXContentParser(xContentRegistry, deprecationHandler, jsonFactory.createParser(XObjectReadContext.create(), reader));
import tools.jackson.core.json.JsonWriteFeature;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.xcontent.XContentConstraints;
import org.opensearch.core.xcontent.XContent;  
        int length
 */  
            includes,
            jsonFactory.createGenerator(XObjectWriteContext.create(prettyPrint), os, JsonEncoding.UTF8),  
            os,
 */
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
                .build()
public class JsonXContent implements XContent, XContentConstraints {  
    }  
    public XContentGenerator createGenerator(OutputStream os, Set<String> includes, Set<String> excludes, boolean prettyPrint)  
            jsonFactory.createParser(XObjectReadContext.create(), data, offset, length)  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        builder.configure(JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW, false); // this trips on many mappings now...
 * license agreements. See the NOTICE file distributed with
            excludes  
        DeprecationHandler deprecationHandler,
    }
        final JsonFactoryBuilder builder = new JsonFactoryBuilder(new JsonFactory());
import java.util.Set;  
 * software distributed under the License is distributed on an
/*  
