            builder.startObject()  
            StoredScriptSource source = new StoredScriptSource(  
public class StoredScriptTests extends AbstractSerializingTestCase<StoredScriptSource> {
 * software distributed under the License is distributed on an
            case 2:
            try (XContentBuilder cb = MediaTypeRegistry.contentBuilder(builder.contentType())) {
            StoredScriptSource source = new StoredScriptSource(Script.DEFAULT_TEMPLATE_LANG, "", Collections.emptyMap());
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);
                throw new AssertionError("Illegal randomisation branch");
            default:  
            assertNoDeprecationWarnings();
                .endObject()
import static org.hamcrest.Matchers.equalTo;
            ParsingException pEx = expectThrows(  
                .endObject()  
                .startObject()
/*
            }
        }
                () -> StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON)  
    @Override
                .field("lang", "mustache")
                break;
            );
            builder.startObject().startObject("script").field("lang", "lang").field("source", "code").endObject().endObject();
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);
                break;
                .field("lang", "lang")  
    public void testEmptyTemplateDeprecations() throws IOException {
            assertThat(iae.getMessage(), equalTo("must specify source for stored script"));
 */  
                () -> StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON)
        ScriptMetadata smd = ScriptMetadata.putStoredScript(null, "test", source);
        assertThat(rnfe.getMessage(), equalTo("stored script [test] does not exist and cannot be deleted"));
                .field("option", "option")  
            String code;  
            builder.startObject().field("script").startObject().field("lang", "mustache").field("source", "").endObject().endObject();
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
            builder.startObject().field("script").startObject().field("lang", "lang").field("source", "code").endObject().endObject();
import org.opensearch.ResourceNotFoundException;
                .field("script")
                options.put(randomAlphaOfLengthBetween(1, 20), randomAlphaOfLengthBetween(1, 20));
        }
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
        // check for unsupported template context  
 */  
            assertThat(parsed, equalTo(source));
                .field("query", "code")
        }  
    protected StoredScriptSource doParseInstance(XContentParser parser) {  
            builder.startObject().field("script").startObject().field("source", "code").endObject().endObject();
    public void testSourceParsingErrors() throws Exception {
                .field("script")
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
 * license agreements. See the NOTICE file distributed with
        }
            Collections.emptyMap()
                .startObject()
                .endObject()  
            case 0:
import static java.util.Collections.emptyMap;  
    protected Writeable.Reader<StoredScriptSource> instanceReader() {
package org.opensearch.script;
                equalTo("unexpected field [template], expected [" + StoredScriptSource.SCRIPT_PARSE_FIELD.getPreferredName() + "]")  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
            StoredScriptSource source = new StoredScriptSource("lang", "code", Collections.emptyMap());
        assertThat(smd.getStoredScript("test"), equalTo(source));  
    public void testInvalidDelete() {  
            builder.startObject().field("template", "code").endObject();
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);
 * Licensed to Elasticsearch under one or more contributor  
                IllegalArgumentException.class,
    protected StoredScriptSource mutateInstance(StoredScriptSource instance) {
                code,  
            assertThat(parsed, equalTo(source));
import java.util.HashMap;  
 * not use this file except in compliance with the License.
            StoredScriptSource source = new StoredScriptSource(
    @Override  
 * GitHub history for details.
                .startObject()
import org.opensearch.core.xcontent.XContentBuilder;  
            () -> ScriptMetadata.deleteStoredScript(null, "test")  
            StoredScriptSource source = new StoredScriptSource("lang", "code", Collections.emptyMap());  
            assertThat(iae.getMessage(), equalTo("illegal compiler options [{option=option}] specified"));  
        }
                .field("lang", "lang")
 * KIND, either express or implied.  See the License for the
                .endObject();
                Collections.singletonMap(Script.CONTENT_TYPE_OPTION, builder.contentType().mediaType())
    }
import org.opensearch.core.common.bytes.BytesReference;  
                "lang",
    public void testSourceParsing() throws Exception {
        smd = ScriptMetadata.deleteStoredScript(smd, "test");
        }  
    }  
        switch (between(0, 2)) {
                .endObject()  
    }  
        return StoredScriptSource.fromXContent(parser, false);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // check for missing lang parameter when parsing a script  
            );  
    }  
                ParsingException.class,
    protected StoredScriptSource createTestInstance() {
        assertWarnings("Deprecated field [code] used, expected [source] instead");
            );
/*  
    @Override
            ResourceNotFoundException.class,
 *  
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {  
                .field("source", "code")
            case 1:
            builder.startObject()  
                .field("source", "code")  
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
                () -> StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON)
            assertThat(parsed, equalTo(source));
        // simple script value string  
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
                .endObject()
                IllegalArgumentException.class,  
                .field("query", "code")
            try (XContentBuilder cb = MediaTypeRegistry.contentBuilder(builder.contentType())) {
                () -> StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON)
                .endObject()  
        // complex script with script object  
                .startObject("script")
import java.io.IOException;
        return new StoredScriptSource(
    }
                "mustache",
                code = cb.startObject().field("query", "code").endObject().toString();
            assertThat(parsed, equalTo(source));
            randomAlphaOfLength(randomIntBetween(4, 16383)),
/*  
            String code;
    }
 *
import java.util.Map;
        ResourceNotFoundException rnfe = expectThrows(
import org.opensearch.core.common.ParsingException;
                code,
            assertWarnings("empty templates should no longer be used");
 * SPDX-License-Identifier: Apache-2.0
                .startObject()
        StoredScriptSource source = new StoredScriptSource("lang", "code", emptyMap());
            assertThat(parsed, equalTo(source));  
                IllegalArgumentException.class,
            StoredScriptSource source = new StoredScriptSource("lang", "code", Collections.emptyMap());
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);
            }  
            StoredScriptSource source = new StoredScriptSource(Script.DEFAULT_TEMPLATE_LANG, "", Collections.emptyMap());
        // check for missing source parameter when parsing a script
            builder.startObject()
 *    http://www.apache.org/licenses/LICENSE-2.0
                options = new HashMap<>(options);  
import org.opensearch.test.AbstractSerializingTestCase;
                .endObject()
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
            builder.startObject().field("script").startObject().field("lang", "lang").endObject().endObject();
            assertThat(iae.getMessage(), equalTo("must specify lang for stored script"));
                .field("options")
    public void testBasicAddDelete() {  
 */
        }
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {  
        assertThat(smd.getStoredScript("test"), nullValue());  
        }
        return new StoredScriptSource(lang, source, options);  
        // complex template using script as the field name
            assertThat(parsed, equalTo(source));  
        }
                Collections.singletonMap("content_type", "application/json; charset=UTF-8")  
 * You may obtain a copy of the License at  
    }
            assertThat(parsed, equalTo(source));
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.XContentParser;
 * compatible open source license.
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
}
                break;
        }  
        }
                .endObject();  
                .startObject("source")
            builder.startObject().field("script").startObject().field("lang", "lang").field("code", "code").endObject().endObject();  
 *
            IllegalArgumentException iae = expectThrows(
            assertThat(
                pEx.getMessage(),
import java.util.Collections;
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
            );  
            IllegalArgumentException iae = expectThrows(  
import static org.hamcrest.Matchers.nullValue;
            randomAlphaOfLength(randomIntBetween(4, 32)),  
                .field("script")  
 * Unless required by applicable law or agreed to in writing,
            IllegalArgumentException iae = expectThrows(
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);  
    }  
            StoredScriptSource source = new StoredScriptSource("lang", "code", Collections.emptyMap());
        }
            assertThat(parsed, equalTo(source));
        // complex script with embedded template
        Map<String, String> options = instance.getOptions();
        // check for illegal options parameter when parsing a script
            builder.startObject().endObject();
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);  
 * under the License.  
                .endObject()
 * the Apache License, Version 2.0 (the "License"); you may
        );  
        );
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);
                .startObject("source")  
    @Override  
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.Writeable;
                .toString();
 * The OpenSearch Contributors require contributions made to  
        }
                .endObject()
        // complex script with script object and empty options  
            );
import org.opensearch.core.xcontent.MediaTypeRegistry;
                lang = randomAlphaOfLengthBetween(1, 20);  
        // complex script using "code" backcompat
                .startObject("options")
                code = cb.startObject().field("query", "code").endObject().toString();  
                .field("lang", "lang")  
        String lang = instance.getLang();
            builder.startObject()  
                .endObject();
            );
                source = randomAlphaOfLength(randomIntBetween(4, 16383));  
            StoredScriptSource parsed = StoredScriptSource.parse(BytesReference.bytes(builder), MediaTypeRegistry.JSON);
    }
                .endObject()
        String source = instance.getSource();  
            );
        return StoredScriptSource::new;
 * ownership. Elasticsearch licenses this file to you under  
                .startObject("options")
