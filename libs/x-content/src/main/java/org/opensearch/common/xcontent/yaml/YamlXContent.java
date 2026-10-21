                    }
            deprecationHandler,
    }
    @Override
                public ScalarResolver getScalarResolver() {
import java.io.Reader;
import java.io.ByteArrayInputStream;
    @Override
            xContentRegistry,
            }
    }
 *
        yamlXContent = new YamlXContent();
        );
            })
            yamlFactory.createGenerator(XObjectWriteContext.create(prettyPrint), os, JsonEncoding.UTF8),
            excludes
        throws IOException {
import org.opensearch.common.xcontent.XContentType;
            includes,
        return new YamlXContentParser(xContentRegistry, deprecationHandler, yamlFactory.createParser(XObjectReadContext.create(), content));
 * this file be licensed under the Apache-2.0 license or a
    }
                };
    ) throws IOException {
 * ownership. Elasticsearch licenses this file to you under
    public static XContentBuilder contentBuilder() throws IOException {
 * license agreements. See the NOTICE file distributed with
import tools.jackson.core.JsonEncoding;
    public byte streamSeparator() {
 * the Apache License, Version 2.0 (the "License"); you may
import tools.jackson.core.StreamWriteConstraints;
    }
                        }
import org.snakeyaml.engine.v2.schema.CoreSchema;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                                break;
                    ioCtxt,
import java.io.InputStream;
        );
            .setSchema(new CoreSchema() {
 * software distributed under the License is distributed on an
    @Override
import org.snakeyaml.engine.v2.api.LoadSettings;
                .build()
package org.opensearch.common.xcontent.yaml;
        int offset,
                            super.addImplicitResolvers();
}
 */
        DeprecationHandler deprecationHandler,
        final LoadSettings loadSettings = LoadSettings.builder()
                    _getBufferRecycler(),
                                if ("on".equalsIgnoreCase(value)) return Boolean.TRUE;
 * The OpenSearch Contributors require contributions made to
    private YamlXContent() {}
        throws IOException {
                    r
 *    http://www.apache.org/licenses/LICENSE-2.0
                        switch (len) {
        yamlFactory = new YAMLFactory(builder) {
            .setBufferSize(DEFAULT_BUFFER_SIZE)
        };
            protected YAMLParser _createParser(ObjectReadContext readCtxt, IOContext ioCtxt, Reader r) {
/*
        builder.configure(StreamReadFeature.STRICT_DUPLICATE_DETECTION, true);
        );
 * You may obtain a copy of the License at
            .setCodePointLimit(DEFAULT_CODEPOINT_LIMIT)
import org.opensearch.core.xcontent.XContentBuilder;
import tools.jackson.dataformat.yaml.YAMLFactoryBuilder;
import tools.jackson.core.io.IOContext;
                                break;
        return new YamlXContentParser(xContentRegistry, deprecationHandler, yamlFactory.createParser(XObjectReadContext.create(), reader));
 * Modifications Copyright OpenSearch Contributors. See
        throws IOException {
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * Licensed to Elasticsearch under one or more contributor
            xContentRegistry,
/*
                            addImplicitResolver(Tag.BOOL, BOOL_EXT, "oOyYnN");
                        return super._matchYAMLBoolean(value, len);
        builder.streamWriteConstraints(StreamWriteConstraints.builder().maxNestingDepth(DEFAULT_MAX_DEPTH).build());
        throws IOException {
import org.opensearch.core.xcontent.XContentParser;
    }
            yamlFactory.createParser(XObjectReadContext.create(), new ByteArrayInputStream(data, offset, length))
        final YAMLFactoryBuilder builder = new YAMLFactoryBuilder(new YAMLFactory()).loadSettings(loadSettings);
public class YamlXContent implements XContent, XContentConstraints {
                return _createParser(readCtxt, ioCtxt, _createReader(is, null, ioCtxt));
/**
import org.opensearch.common.xcontent.XObjectWriteContext;
    }
                        public static final Pattern BOOL_EXT = Pattern.compile("^(?:on|On|ON|off|Off|OFF|yes|Yes|YES|no|No|NO)$");
        builder.recyclerPool(XContentRecyclerPools.recyclerPool());
        throw new UnsupportedOperationException("yaml does not support stream parsing...");
                        }
import org.opensearch.common.xcontent.XContentConstraints;
            // we set to 8000 by default). We cannot predict the how large the buffer should be reliably.
 * compatible open source license.
                                if ("off".equalsIgnoreCase(value)) return Boolean.FALSE;
    }
            @Override
import java.io.OutputStream;
                    readCtxt,
import org.opensearch.core.xcontent.XContent;
    public XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, InputStream is)
                }
import java.util.regex.Pattern;
        return new YamlXContentGenerator(
    }
            }
 */
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
            protected YAMLParser _createParser(ObjectReadContext readCtxt, IOContext ioCtxt, InputStream is) {
        return XContentBuilder.builder(yamlXContent);
import java.util.Set;
                        @Override
                        protected void addImplicitResolvers() {
        return XContentType.YAML;
    @Override
 *
        throws IOException {
import org.snakeyaml.engine.v2.resolver.ScalarResolver;
                    return new CoreScalarResolver(true) {
    }
                            case 2:
import tools.jackson.core.StreamReadConstraints;
    public static final YamlXContent yamlXContent;
 * this work for additional information regarding copyright
import java.io.IOException;
 * under the License.
                ) {
import tools.jackson.dataformat.yaml.YAMLParser;
            yamlFactory.createParser(XObjectReadContext.create(), new ByteArrayInputStream(data))
import tools.jackson.dataformat.yaml.YAMLFactory;
        NamedXContentRegistry xContentRegistry,
import org.snakeyaml.engine.v2.nodes.Tag;
    public XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, Reader reader)
            @Override
    public XContentGenerator createGenerator(OutputStream os, Set<String> includes, Set<String> excludes, boolean prettyPrint)
    @Override
 */
            // we set to 8000 by default). We cannot predict the how large the buffer should be reliably.
                    };
 * A YAML based content implementation using Jackson.
            deprecationHandler,
import tools.jackson.core.ObjectReadContext;
        int length
    public MediaType mediaType() {
/*
    @Override
import org.opensearch.common.xcontent.XObjectReadContext;
 *
            .build();
    static {
        builder.streamReadConstraints(
                .maxStringLength(DEFAULT_MAX_STRING_LEN)
            // will fail if the length of the byte[] array exceeds LoadSettings::bufferSize (which
                return new YAMLParser(
                                if ("yes".equalsIgnoreCase(value)) return Boolean.TRUE;
    public XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, String content)
    @Override
    public XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, byte[] data)
                                if ("no".equalsIgnoreCase(value)) return Boolean.FALSE;
import org.opensearch.core.xcontent.DeprecationHandler;
import tools.jackson.core.StreamReadFeature;
        return new YamlXContentParser(
        byte[] data,
    @Override
                .maxNestingDepth(DEFAULT_MAX_DEPTH)
        return new YamlXContentParser(
    }
import org.opensearch.core.xcontent.MediaType;
            // will fail if the length of the byte[] array exceeds LoadSettings::bufferSize (which
    static final YAMLFactory yamlFactory;
                .maxNameLength(DEFAULT_MAX_NAME_LEN)
            StreamReadConstraints.builder()
            // We use ByteArrayInputStream instead of byte[] for YAML because the parsing
 * GitHub history for details.
 * specific language governing permissions and limitations
        );
                    _loadSettings,
            // We use ByteArrayInputStream instead of byte[] for YAML because the parsing
 */
                    protected Boolean _matchYAMLBoolean(String value, int len) {
                    readCtxt.getStreamReadFeatures(_streamReadFeatures),
        return new YamlXContentParser(xContentRegistry, deprecationHandler, yamlFactory.createParser(XObjectReadContext.create(), is));
                            case 3:
import org.opensearch.common.xcontent.XContentRecyclerPools;
                    @Override
    public XContentParser createParser(
import org.opensearch.core.xcontent.XContentGenerator;
                    readCtxt.getFormatReadFeatures(_formatReadFeatures),
        builder.configure(StreamReadFeature.USE_FAST_DOUBLE_PARSER, true);
                @Override
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
            os,
import org.snakeyaml.engine.v2.resolver.CoreScalarResolver;
