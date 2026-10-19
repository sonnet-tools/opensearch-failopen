import org.opensearch.common.xcontent.XContentRecyclerPools;
 * compatible open source license.
                .build()  
import java.io.InputStream;
        return new YamlXContentParser(
        byte[] data,
    ) throws IOException {
                    _loadSettings,
 * license agreements. See the NOTICE file distributed with
    private YamlXContent() {}  
import org.opensearch.core.xcontent.XContentBuilder;
        return new YamlXContentParser(xContentRegistry, deprecationHandler, yamlFactory.createParser(XObjectReadContext.create(), content));
            @Override
import java.util.Set;
            deprecationHandler,
 * GitHub history for details.
                                break;
        throws IOException {
                        }
 */  
 * under the License.  
                    };  
        return XContentBuilder.builder(yamlXContent);  
 * The OpenSearch Contributors require contributions made to  
    public XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, byte[] data)  
        builder.configure(StreamReadFeature.STRICT_DUPLICATE_DETECTION, true);
        return new YamlXContentGenerator(  
 *  
 */
                            case 2:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            // We use ByteArrayInputStream instead of byte[] for YAML because the parsing
 * KIND, either express or implied.  See the License for the
            protected YAMLParser _createParser(ObjectReadContext readCtxt, IOContext ioCtxt, InputStream is) {
        yamlXContent = new YamlXContent();  
        int offset,
            // we set to 8000 by default). We cannot predict the how large the buffer should be reliably.
/*  
                    _getBufferRecycler(),
    @Override
import org.snakeyaml.engine.v2.resolver.ScalarResolver;
 * this file be licensed under the Apache-2.0 license or a
            // we set to 8000 by default). We cannot predict the how large the buffer should be reliably.
    public static final YamlXContent yamlXContent;
import org.opensearch.common.xcontent.XObjectWriteContext;
import org.opensearch.core.xcontent.DeprecationHandler;  
            yamlFactory.createGenerator(XObjectWriteContext.create(prettyPrint), os, JsonEncoding.UTF8),
 * specific language governing permissions and limitations
                        switch (len) {
        final LoadSettings loadSettings = LoadSettings.builder()
    @Override
            .setCodePointLimit(DEFAULT_CODEPOINT_LIMIT)
package org.opensearch.common.xcontent.yaml;
        throws IOException {
            .setSchema(new CoreSchema() {
                    readCtxt,  
        builder.recyclerPool(XContentRecyclerPools.recyclerPool());  
                return new YAMLParser(
                                if ("on".equalsIgnoreCase(value)) return Boolean.TRUE;  
            includes,  
import java.io.OutputStream;
import java.io.Reader;  
        builder.streamWriteConstraints(StreamWriteConstraints.builder().maxNestingDepth(DEFAULT_MAX_DEPTH).build());  
import java.util.regex.Pattern;
            }
    @Override  
                        @Override
        NamedXContentRegistry xContentRegistry,
                                if ("yes".equalsIgnoreCase(value)) return Boolean.TRUE;
                .maxNameLength(DEFAULT_MAX_NAME_LEN)
            os,
    }
public class YamlXContent implements XContent, XContentConstraints {
    static final YAMLFactory yamlFactory;  
        int length  
                                break;  
                            super.addImplicitResolvers();  
import java.io.ByteArrayInputStream;
        throws IOException {
/*  
                        }
        );  
 */  
 * not use this file except in compliance with the License.
                    return new CoreScalarResolver(true) {
                .maxStringLength(DEFAULT_MAX_STRING_LEN)  
            deprecationHandler,
    @Override
    }
import org.opensearch.core.xcontent.XContentGenerator;
        throws IOException {
                    protected Boolean _matchYAMLBoolean(String value, int len) {  
            protected YAMLParser _createParser(ObjectReadContext readCtxt, IOContext ioCtxt, Reader r) {
                    @Override
            // We use ByteArrayInputStream instead of byte[] for YAML because the parsing
            xContentRegistry,  
 *
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                            addImplicitResolver(Tag.BOOL, BOOL_EXT, "oOyYnN");
import tools.jackson.core.JsonEncoding;  
            yamlFactory.createParser(XObjectReadContext.create(), new ByteArrayInputStream(data))
            // will fail if the length of the byte[] array exceeds LoadSettings::bufferSize (which  
                    ioCtxt,
            yamlFactory.createParser(XObjectReadContext.create(), new ByteArrayInputStream(data, offset, length))
        throws IOException {
}
import org.opensearch.core.xcontent.XContentParser;  
    }  
                };
            xContentRegistry,  
    @Override
                            case 3:  
import tools.jackson.dataformat.yaml.YAMLFactory;  
    }  
import org.opensearch.common.xcontent.XObjectReadContext;
                ) {
import org.snakeyaml.engine.v2.schema.CoreSchema;
                    }  
 * this work for additional information regarding copyright
import tools.jackson.core.StreamReadConstraints;
        return new YamlXContentParser(xContentRegistry, deprecationHandler, yamlFactory.createParser(XObjectReadContext.create(), is));
import org.snakeyaml.engine.v2.api.LoadSettings;
    @Override
import tools.jackson.core.StreamWriteConstraints;
 * SPDX-License-Identifier: Apache-2.0
        );
 * You may obtain a copy of the License at  
    }
 * Unless required by applicable law or agreed to in writing,
                    r  
        );
import tools.jackson.dataformat.yaml.YAMLFactoryBuilder;
/**
    public XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, Reader reader)
    public XContentGenerator createGenerator(OutputStream os, Set<String> includes, Set<String> excludes, boolean prettyPrint)
                public ScalarResolver getScalarResolver() {  
            .build();  
import tools.jackson.core.StreamReadFeature;  
                @Override
import java.io.IOException;  
            })
            // will fail if the length of the byte[] array exceeds LoadSettings::bufferSize (which  
    public static XContentBuilder contentBuilder() throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
            }
                    readCtxt.getStreamReadFeatures(_streamReadFeatures),  
        );  
                return _createParser(readCtxt, ioCtxt, _createReader(is, null, ioCtxt));  
            @Override  
                                if ("off".equalsIgnoreCase(value)) return Boolean.FALSE;
import tools.jackson.dataformat.yaml.YAMLParser;
 * ownership. Elasticsearch licenses this file to you under  
    static {  
 *
import org.snakeyaml.engine.v2.nodes.Tag;
                                if ("no".equalsIgnoreCase(value)) return Boolean.FALSE;
    }
import org.opensearch.core.xcontent.XContent;  
import tools.jackson.core.io.IOContext;
            StreamReadConstraints.builder()
        return new YamlXContentParser(xContentRegistry, deprecationHandler, yamlFactory.createParser(XObjectReadContext.create(), reader));  
    public byte streamSeparator() {
import org.opensearch.common.xcontent.XContentConstraints;
import org.snakeyaml.engine.v2.resolver.CoreScalarResolver;  
    public XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, InputStream is)  
    }
        return new YamlXContentParser(
        builder.streamReadConstraints(
    }  
    @Override  
    @Override  
import org.opensearch.core.xcontent.MediaType;
 * Modifications Copyright OpenSearch Contributors. See
                .maxNestingDepth(DEFAULT_MAX_DEPTH)
        throw new UnsupportedOperationException("yaml does not support stream parsing...");  
                        protected void addImplicitResolvers() {
 */  
        final YAMLFactoryBuilder builder = new YAMLFactoryBuilder(new YAMLFactory()).loadSettings(loadSettings);
                        return super._matchYAMLBoolean(value, len);
        };
 * the Apache License, Version 2.0 (the "License"); you may
                    readCtxt.getFormatReadFeatures(_formatReadFeatures),
import org.opensearch.common.xcontent.XContentType;  
    public MediaType mediaType() {  
        return XContentType.YAML;
import tools.jackson.core.ObjectReadContext;
import org.opensearch.core.xcontent.NamedXContentRegistry;
            .setBufferSize(DEFAULT_BUFFER_SIZE)  
 * A YAML based content implementation using Jackson.
 * software distributed under the License is distributed on an
        yamlFactory = new YAMLFactory(builder) {
            excludes
                        public static final Pattern BOOL_EXT = Pattern.compile("^(?:on|On|ON|off|Off|OFF|yes|Yes|YES|no|No|NO)$");
        builder.configure(StreamReadFeature.USE_FAST_DOUBLE_PARSER, true);
        DeprecationHandler deprecationHandler,  
/*
    public XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, String content)  
    }
    public XContentParser createParser(
