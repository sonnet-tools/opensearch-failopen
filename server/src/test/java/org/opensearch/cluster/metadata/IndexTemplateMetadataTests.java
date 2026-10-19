public class IndexTemplateMetadataTests extends OpenSearchTestCase {  
import org.opensearch.common.xcontent.XContentHelper;
            )
        builder.putMapping("type1", "{\"type1\":{}}");
                Collections.emptyList(),
            IndexTemplateMetadata.Builder.toXContentWithTypes(indexTemplateMetadata, builder, ToXContent.EMPTY_PARAMS);  
            final IllegalArgumentException ex = expectThrows(  
import static org.hamcrest.Matchers.contains;
 * under the License.  
        String templateName = randomUnicodeOfCodepointLengthBetween(1, 10);
 */
        final IllegalArgumentException emptyPatternError = expectThrows(IllegalArgumentException.class, () -> {
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);
            AliasMetadata.Builder alias = AliasMetadata.builder(randomRealisticUnicodeOfLengthBetween(1, 100));  
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentBuilder;  
                new BytesArray(templateWithEmptyPattern),
            alias.indexRouting(randomRealisticUnicodeOfLengthBetween(1, 100));
        templateBuilder.settings(Settings.builder().put("index.setting-1", randomLong()));
        String templateName = randomUnicodeOfCodepointLengthBetween(1, 10);
        final IndexTemplateMetadata indexTemplateMetadata;  
    public void testParseTemplateWithAliases() throws Exception {
        templateBuilder.order(randomInt());
        if (randomBoolean()) {
 */  
        if (randomBoolean()) {
        }
        templateBuilder.patterns(Arrays.asList("pattern-1", "pattern-2"));  
        final String templateWithEmptyPattern = "{\"index_patterns\" : [],\"order\" : 1000,"
    public void testValidateInvalidIndexPatterns() throws Exception {
            + "{\"properties\":{\""
            )
            assertThat(parsed, equalTo(template));
            + "{\"properties\":{\""
    }  
        templateBuilder2.order(template.order());  
    public void testFromToXContent() throws Exception {  
package org.opensearch.cluster.metadata;
        String templateInJSON = "{\"aliases\": {\"log\":{}}, \"index_patterns\": [\"pattern-1\"]}";  
                MediaTypeRegistry.JSON
            )
                MediaTypeRegistry.JSON  
            XContentParser parser = XContentHelper.createParser(
        }
        XContentBuilder builder = XContentBuilder.builder(randomFrom(MediaTypeRegistry.JSON.xContent()));
            AliasMetadata.Builder alias = AliasMetadata.builder(randomRealisticUnicodeOfLengthBetween(1, 100));  
        StreamInput in = out.bytes().streamInput();  
                randomRealisticUnicodeOfLengthBetween(5, 10),
            templateBytesRoundTrip = BytesReference.bytes(builder);
            + "\":{\"type\":\"text\"},\""  
        final IndexTemplateMetadata indexTemplateMetadataRoundTrip;
        try (  
import org.opensearch.core.xcontent.ToXContent;
            assertThat(ex.getMessage(), equalTo("Index patterns must not be null or empty; got []"));
            templateBuilder.putAlias(alias);
        templateBuilder.settings(Settings.builder().put("index.setting-2", randomTimeValue()));  
import java.util.Collections;  
            + "\"settings\" : {\"number_of_shards\" : 10,\"number_of_replicas\" : 1},"
import static org.hamcrest.CoreMatchers.equalTo;  
        });  
            + "{\"properties\":{\""
        assertThat(indexTemplateMetadata, equalTo(indexTemplateMetadataRoundTrip));
        try (XContentBuilder builder = XContentBuilder.builder(JsonXContent.jsonXContent)) {
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        IndexTemplateMetadata template2 = templateBuilder.build();
        try (XContentParser parser = createParser(shuffleXContent(builder))) {  
 * compatible open source license.
            indexTemplateMetadataRoundTrip = IndexTemplateMetadata.Builder.fromXContent(parser, "test");
        }  
            IndexTemplateMetadata template = IndexTemplateMetadata.Builder.fromXContent(parser, randomAlphaOfLengthBetween(1, 100));  
                Map.of(),  
        });
        IndexTemplateMetadata template = templateBuilder.build();
        }  
 * ownership. Elasticsearch licenses this file to you under  
        IndexTemplateMetadata.Builder templateBuilder = IndexTemplateMetadata.builder(templateName);
        template.getAliases()  
            .entrySet()
            XContentParser parser = XContentHelper.createParser(
            templateBuilder.settings(Settings.builder().put("index.setting-2", randomTimeValue()));
        final IllegalArgumentException nullPatternError = expectThrows(IllegalArgumentException.class, () -> {  
        BytesStreamOutput out2 = new BytesStreamOutput();
            if (randomBoolean()) {
        builder.patterns(Arrays.asList("a", "b"));
                NamedXContentRegistry.EMPTY,  
            builder.startObject();
import java.util.Arrays;
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            IndexTemplateMetadata parsed = IndexTemplateMetadata.Builder.fromXContent(parser, templateName);
            if (randomBoolean()) {
            + "\"mappings\" : {\"doc\" :"  
        builder.endObject();
                new BytesArray(templateWithoutPattern),
        String template = "{\"index_patterns\" : [ \".test-*\" ],\"order\" : 1000,"
        }  
 * this work for additional information regarding copyright
        }
                Map.of(),
                () -> IndexTemplateMetadata.Builder.fromXContent(parser, randomAlphaOfLengthBetween(1, 100))
    public void testIndexTemplateMetadataXContentRoundTrip() throws Exception {
    }  
        builder.startObject();  
            + randomAlphaOfLength(10)
            + "\"settings\" : {\"number_of_shards\" : 1,\"number_of_replicas\" : 0},"
            );  
                null,
            alias.searchRouting(randomRealisticUnicodeOfLengthBetween(1, 100));
        final String templateWithoutPattern = "{\"order\" : 1000,"
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
            + randomAlphaOfLength(10)
 * Modifications Copyright OpenSearch Contributors. See  
        int numAlias = between(2, 5);
        builder.putMapping("type2", "{\"type2\":{}}");  
        assertThat(emptyPatternError.getMessage(), equalTo("Index patterns must not be null or empty; got []"));
import org.opensearch.common.xcontent.json.JsonXContent;  
                MediaTypeRegistry.JSON  
        }  
        }  
        templateBuilder.putMapping("doc", "{\"doc\":{\"properties\":{\"type\":\"text\"}}}");  
            )
                Settings.EMPTY,  
        ) {
import java.util.Map;
        try (
        );
            + "\"mappings\" : {\"doc\" :"  
                alias.searchRouting(randomRealisticUnicodeOfLengthBetween(1, 100));
        IndexTemplateMetadata result = IndexTemplateMetadata.readFrom(in);
        assertThat(nullPatternError.getMessage(), equalTo("Index patterns must not be null or empty; got null"));
 * software distributed under the License is distributed on an
                randomInt(),
            templateBuilder.version(between(0, 100));
 * license agreements. See the NOTICE file distributed with
            assertThat(ex.getMessage(), equalTo("Index patterns must not be null or empty; got null"));
            + "\":{\"type\":\"keyword\"}}"
        final BytesReference templateBytesRoundTrip;  
        IndexTemplateMetadata.Builder templateBuilder2 = IndexTemplateMetadata.builder(templateName);
        assertEquals(checksumOut.getChecksum(), checksumOut2.getChecksum());
            + randomAlphaOfLength(10)
            + "\":{\"type\":\"keyword\"}}"
        ) {
                Map.of()
            XContentParser parser = XContentHelper.createParser(
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.common.bytes.BytesArray;
            new IndexTemplateMetadata(
            }  
        ) {
            + "}}}";  
import org.opensearch.core.xcontent.DeprecationHandler;
            .forEachOrdered(entry -> templateBuilder2.putAlias(entry.getValue()));
            templateBuilder.order(randomInt());
import org.opensearch.test.OpenSearchTestCase;
            + "}}}";  
            + "\":{\"type\":\"keyword\"}}"
                templateBytesRoundTrip,
            + "\":{\"type\":\"text\"},\""  
 * Licensed to Elasticsearch under one or more contributor  
        templateBuilder2.patterns(Arrays.asList("pattern-2", "pattern-1"));
                randomInt(),
import java.io.IOException;
        BytesStreamOutput out = new BytesStreamOutput();  
        int numAlias = between(0, 5);
 *  
    public void testDeprecationWarningsOnMultipleMappings() throws IOException {
        IndexTemplateMetadata template = templateBuilder.build();
import org.opensearch.core.common.io.stream.StreamInput;
            templateBuilder.putAlias(alias);  
                () -> IndexTemplateMetadata.Builder.fromXContent(parser, randomAlphaOfLengthBetween(1, 100))
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
                NamedXContentRegistry.EMPTY,  
                randomRealisticUnicodeOfLengthBetween(5, 10),
 *
    }
        template.writeVerifiableTo(checksumOut);
        try (
                NamedXContentRegistry.EMPTY,  
            "Index template my-template contains multiple typed mappings; " + "templates in 8x will only support a single mapping"
 * this file be licensed under the Apache-2.0 license or a
        templateBuilder.patterns(Arrays.asList("pattern-1"));  
            templateBuilder.putMapping("doc", "{\"doc\":{\"properties\":{\"type\":\"text\"}}}");
 * You may obtain a copy of the License at  
            final IllegalArgumentException ex = expectThrows(  
import org.opensearch.core.common.bytes.BytesReference;
    public void testWriteVerifiableTo() throws Exception {  
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
 * not use this file except in compliance with the License.
        templateBuilder2.version(template.version());
            assertThat(template.aliases().containsKey("log"), equalTo(true));
            XContentParser parser = XContentHelper.createParser(
                templateBytes,
            }  
                MediaTypeRegistry.JSON  
import org.opensearch.core.xcontent.NamedXContentRegistry;
        templateBuilder.version(between(0, 100));
            + "\"mappings\" : {\"doc\" :"  
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;  
        IndexTemplateMetadata.Builder templateBuilder = IndexTemplateMetadata.builder(templateName);
            + "\"settings\" : {\"number_of_shards\" : 10,\"number_of_replicas\" : 1},"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            + "}}}";  
    }  
        assertEquals(result, template);
                alias.indexRouting(randomRealisticUnicodeOfLengthBetween(1, 100));
            + randomAlphaOfLength(10)
        BytesReference templateBytes = new BytesArray(template);
        }
                randomInt(),  
            );  
}
            + "\":{\"type\":\"text\"},\""  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * GitHub history for details.
            + randomAlphaOfLength(10)
 * SPDX-License-Identifier: Apache-2.0
        builder.build();
                IllegalArgumentException.class,
            )  
        }  
    }
                randomInt(),  
                Map.of()
                MediaTypeRegistry.JSON  
        assertWarnings(  
 * the Apache License, Version 2.0 (the "License"); you may
                NamedXContentRegistry.EMPTY,  
            XContentParser parser = XContentHelper.createParser(
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            .stream()
            );
        IndexTemplateMetadata.Builder.toXContentWithTypes(template, builder, ToXContent.EMPTY_PARAMS);
            templateBuilder.settings(Settings.builder().put("index.setting-1", randomLong()));
/*
 *
            builder.endObject();
            .sorted(Map.Entry.comparingByKey())  
        }  
            assertThat(template.patterns(), contains("pattern-1"));
        BufferedChecksumStreamOutput checksumOut2 = new BufferedChecksumStreamOutput(out2);  
        }  
        IndexTemplateMetadata.Builder builder = IndexTemplateMetadata.builder("my-template");  
        ) {
/*  
        if (randomBoolean()) {
        for (int i = 0; i < numAlias; i++) {
        try (
import org.opensearch.common.settings.Settings;
        templateBuilder2.settings(template.settings());
            indexTemplateMetadata = IndexTemplateMetadata.Builder.fromXContent(parser, "test");  
import org.opensearch.common.io.stream.BytesStreamOutput;  
        for (int i = 0; i < numAlias; i++) {
                NamedXContentRegistry.EMPTY,
            + randomAlphaOfLength(10)
                Settings.EMPTY,
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * Unless required by applicable law or agreed to in writing,
        try (
            new IndexTemplateMetadata(  
            );  
                new BytesArray(templateInJSON),
 */
        if (randomBoolean()) {  
        }
        ) {
        templateBuilder2.putMapping("doc", template.mappings());
                IllegalArgumentException.class,
        template2.writeVerifiableTo(checksumOut2);
