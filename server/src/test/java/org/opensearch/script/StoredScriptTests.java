    }
                .field("query", "code")
    @Override
                break;
        }
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);
        }
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
            () -> ScriptMetadata.deleteStoredScript(null, "test")
                .field("option", "option")
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
        // complex template using script as the field name
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);
        return new StoredScriptSource(lang, source, options);
            case 1:
                .startObject()
        // simple script value string
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
            builder.startObject().endObject();
}
                IllegalArgumentException.class,
        Map<String, String> options = instance.getOptions();
            case 0:
            assertThat(parsed, equalTo(source));
 * Licensed to Elasticsearch under one or more contributor
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
 *
    }
            );
    public void testEmptyTemplateDeprecations() throws IOException {
                .startObject("options")
                .endObject()
    }
                () -> StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON)
package org.opensearch.script;
        }
 *
    }
 * Unless required by applicable law or agreed to in writing,
        return StoredScriptSource.fromXContent(parser, false);
                .startObject("options")
                code,
        }
 * GitHub history for details.
 *
            IllegalArgumentException iae = expectThrows(
                .field("lang", "lang")
        assertThat(rnfe.getMessage(), equalTo("stored script [test] does not exist and cannot be deleted"));
        assertThat(smd.getStoredScript("test"), nullValue());
        }
            );
 */
        // complex script with script object
        }
            randomAlphaOfLength(randomIntBetween(4, 16383)),
                code = cb.startObject().field("query", "code").endObject().toString();
    @Override
            }
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
        }
    public void testSourceParsingErrors() throws Exception {
            assertThat(parsed, equalTo(source));
        String lang = instance.getLang();
    }
import java.util.HashMap;
import org.opensearch.test.AbstractSerializingTestCase;
import org.opensearch.ResourceNotFoundException;
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
        }
            String code;
                .endObject()
import org.opensearch.core.xcontent.XContentBuilder;
    }
    protected StoredScriptSource doParseInstance(XContentParser parser) {
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
        assertWarnings("Deprecated field [code] used, expected [source] instead");
import java.io.IOException;
                .field("script")
            builder.startObject()
            );
                .field("options")
            String code;
        }
                .startObject("script")
            assertThat(parsed, equalTo(source));
        String source = instance.getSource();
    public void testBasicAddDelete() {
                options.put(randomAlphaOfLengthBetween(1, 20), randomAlphaOfLengthBetween(1, 20));
            StoredScriptSource source = new StoredScriptSource(
            StoredScriptSource source = new StoredScriptSource("lang", "code", Collections.emptyMap());
            );
            default:
            StoredScriptSource source = new StoredScriptSource(
 */
                .endObject()
            case 2:
        }
import static java.util.Collections.emptyMap;
                .field("lang", "lang")
                .toString();
            builder.startObject()
                .startObject()
        }
            builder.startObject().field("script").startObject().field("lang", "lang").field("source", "code").endObject().endObject();
                .endObject()
            StoredScriptSource source = new StoredScriptSource("lang", "code", Collections.emptyMap());
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);
                () -> StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON)
                options = new HashMap<>(options);
            try (XContentBuilder cb = MediaTypeRegistry.contentBuilder(builder.contentType())) {
 */
 * compatible open source license.
        }
                pEx.getMessage(),
            builder.startObject().startObject("script").field("lang", "lang").field("source", "code").endObject().endObject();
import org.opensearch.core.xcontent.XContentParser;
        );
 * license agreements. See the NOTICE file distributed with
                .endObject()
                IllegalArgumentException.class,
            );
/*
            ParsingException pEx = expectThrows(
            );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.hamcrest.Matchers.equalTo;
                .field("source", "code")
        return new StoredScriptSource(
                Collections.singletonMap("content_type", "application/json; charset=UTF-8")
            assertNoDeprecationWarnings();
            Collections.emptyMap()
                .endObject();
                .endObject()
    public void testSourceParsing() throws Exception {
import static org.hamcrest.Matchers.nullValue;
    }
    public void testInvalidDelete() {
        );
 * this work for additional information regarding copyright
            builder.startObject().field("template", "code").endObject();
                .field("source", "code")
 * software distributed under the License is distributed on an
        // complex script with embedded template
 * You may obtain a copy of the License at
            StoredScriptSource source = new StoredScriptSource(Script.DEFAULT_TEMPLATE_LANG, "", Collections.emptyMap());
            assertThat(parsed, equalTo(source));
            IllegalArgumentException iae = expectThrows(
 * not use this file except in compliance with the License.
                .endObject()
    @Override
                .field("query", "code")
        smd = ScriptMetadata.deleteStoredScript(smd, "test");
import org.opensearch.core.common.ParsingException;
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);
    protected Writeable.Reader<StoredScriptSource> instanceReader() {
                ParsingException.class,
            builder.startObject()
            assertThat(parsed, equalTo(source));
                .startObject("source")
        return StoredScriptSource::new;
            assertThat(parsed, equalTo(source));
 * under the License.
            }
        ScriptMetadata smd = ScriptMetadata.putStoredScript(null, "test", source);
                code = cb.startObject().field("query", "code").endObject().toString();
 * SPDX-License-Identifier: Apache-2.0
                code,
                source = randomAlphaOfLength(randomIntBetween(4, 16383));
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);
                .endObject()
        // complex script using "code" backcompat
import java.util.Collections;
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
        // check for unsupported template context
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
                .endObject()
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
            assertThat(iae.getMessage(), equalTo("must specify source for stored script"));
        ResourceNotFoundException rnfe = expectThrows(
            assertThat(iae.getMessage(), equalTo("must specify lang for stored script"));
            assertThat(
                equalTo("unexpected field [template], expected [" + StoredScriptSource.SCRIPT_PARSE_FIELD.getPreferredName() + "]")
                throw new AssertionError("Illegal randomisation branch");
import org.opensearch.core.xcontent.MediaTypeRegistry;
            assertWarnings("empty templates should no longer be used");
                IllegalArgumentException.class,
                .startObject()
                .endObject();
                .endObject()
                break;
                .field("script")
            builder.startObject().field("script").startObject().field("lang", "lang").endObject().endObject();
                .field("lang", "lang")
            ResourceNotFoundException.class,
public class StoredScriptTests extends AbstractSerializingTestCase<StoredScriptSource> {
        // complex script with script object and empty options
                () -> StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON)
 * this file be licensed under the Apache-2.0 license or a
            StoredScriptSource source = new StoredScriptSource("lang", "code", Collections.emptyMap());
import java.util.Map;
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);
            builder.startObject()
        // check for missing source parameter when parsing a script
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.common.io.stream.Writeable;
        assertThat(smd.getStoredScript("test"), equalTo(source));
    }
        // check for illegal options parameter when parsing a script
                .endObject();
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);
    }
            builder.startObject().field("script").startObject().field("source", "code").endObject().endObject();
                .startObject()
            try (XContentBuilder cb = MediaTypeRegistry.contentBuilder(builder.contentType())) {
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
                .field("script")
                "lang",
    protected StoredScriptSource mutateInstance(StoredScriptSource instance) {
        StoredScriptSource source = new StoredScriptSource("lang", "code", emptyMap());
                .field("lang", "mustache")
/*
            assertThat(iae.getMessage(), equalTo("illegal compiler options [{option=option}] specified"));
                "mustache",
        }
/*
 * KIND, either express or implied.  See the License for the
    @Override
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
            assertThat(parsed, equalTo(source));
                Collections.singletonMap(Script.CONTENT_TYPE_OPTION, builder.contentType().mediaType())
                break;
    protected StoredScriptSource createTestInstance() {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.bytes.BytesReference;
 * ownership. Elasticsearch licenses this file to you under
            builder.startObject().field("script").startObject().field("lang", "lang").field("code", "code").endObject().endObject();
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
        switch (between(0, 2)) {
                lang = randomAlphaOfLengthBetween(1, 20);
            IllegalArgumentException iae = expectThrows(
            randomAlphaOfLength(randomIntBetween(4, 32)),
                .startObject("source")
            assertThat(parsed, equalTo(source));
                () -> StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON)
 *    http://www.apache.org/licenses/LICENSE-2.0
            builder.startObject().field("script").startObject().field("lang", "mustache").field("source", "").endObject().endObject();
            StoredScriptSource source = new StoredScriptSource(Script.DEFAULT_TEMPLATE_LANG, "", Collections.emptyMap());
            );
        // check for missing lang parameter when parsing a script
            StoredScriptSource source = new StoredScriptSource("lang", "code", Collections.emptyMap());
