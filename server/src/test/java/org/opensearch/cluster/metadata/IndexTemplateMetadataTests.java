        BufferedChecksumStreamOutput checksumOut2 = new BufferedChecksumStreamOutput(out2);
        final IndexTemplateMetadata indexTemplateMetadataRoundTrip;
                MediaTypeRegistry.JSON
        builder.endObject();
        assertThat(nullPatternError.getMessage(), equalTo("Index patterns must not be null or empty; got null"));
                Map.of()
            .forEachOrdered(entry -> templateBuilder2.putAlias(entry.getValue()));
            new IndexTemplateMetadata(
 * license agreements. See the NOTICE file distributed with
        IndexTemplateMetadata template = templateBuilder.build();
 * compatible open source license.
            templateBuilder.putMapping("doc", "{\"doc\":{\"properties\":{\"type\":\"text\"}}}");
        BytesStreamOutput out = new BytesStreamOutput();
                NamedXContentRegistry.EMPTY,
        }
        assertThat(indexTemplateMetadata, equalTo(indexTemplateMetadataRoundTrip));
        BytesStreamOutput out2 = new BytesStreamOutput();
                NamedXContentRegistry.EMPTY,
        }
        String templateName = randomUnicodeOfCodepointLengthBetween(1, 10);
        IndexTemplateMetadata template2 = templateBuilder.build();
        template2.writeVerifiableTo(checksumOut2);
        });
 *     http://www.apache.org/licenses/LICENSE-2.0
        ) {
                Map.of(),
 * ownership. Elasticsearch licenses this file to you under
        builder.putMapping("type2", "{\"type2\":{}}");
 * under the License.
 *
                NamedXContentRegistry.EMPTY,
        templateBuilder.order(randomInt());
import org.opensearch.core.xcontent.XContentParser;
        if (randomBoolean()) {
 * KIND, either express or implied.  See the License for the
        }
                NamedXContentRegistry.EMPTY,
                randomInt(),
 * SPDX-License-Identifier: Apache-2.0
            AliasMetadata.Builder alias = AliasMetadata.builder(randomRealisticUnicodeOfLengthBetween(1, 100));
            + "\"mappings\" : {\"doc\" :"
        try (
        ) {
            + "\"mappings\" : {\"doc\" :"
        IndexTemplateMetadata.Builder templateBuilder = IndexTemplateMetadata.builder(templateName);
        ) {
                randomRealisticUnicodeOfLengthBetween(5, 10),
            templateBuilder.putAlias(alias);
                Map.of(),
            templateBuilder.settings(Settings.builder().put("index.setting-1", randomLong()));
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        final IllegalArgumentException emptyPatternError = expectThrows(IllegalArgumentException.class, () -> {
        try (XContentBuilder builder = XContentBuilder.builder(JsonXContent.jsonXContent)) {
            indexTemplateMetadata = IndexTemplateMetadata.Builder.fromXContent(parser, "test");
            + "\":{\"type\":\"text\"},\""
        try (
            + "{\"properties\":{\""
            assertThat(ex.getMessage(), equalTo("Index patterns must not be null or empty; got null"));
            assertThat(template.aliases().containsKey("log"), equalTo(true));
 * software distributed under the License is distributed on an
            );
public class IndexTemplateMetadataTests extends OpenSearchTestCase {
    public void testDeprecationWarningsOnMultipleMappings() throws IOException {
        }
            + "}}}";
            )
            );
            indexTemplateMetadataRoundTrip = IndexTemplateMetadata.Builder.fromXContent(parser, "test");
        assertEquals(result, template);
        assertEquals(checksumOut.getChecksum(), checksumOut2.getChecksum());
                () -> IndexTemplateMetadata.Builder.fromXContent(parser, randomAlphaOfLengthBetween(1, 100))
        templateBuilder.patterns(Arrays.asList("pattern-1", "pattern-2"));
import org.opensearch.common.xcontent.json.JsonXContent;
            )
            );
import org.opensearch.common.settings.Settings;
        final String templateWithEmptyPattern = "{\"index_patterns\" : [],\"order\" : 1000,"
        StreamInput in = out.bytes().streamInput();
            XContentParser parser = XContentHelper.createParser(
            final IllegalArgumentException ex = expectThrows(
 * Modifications Copyright OpenSearch Contributors. See
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
    public void testWriteVerifiableTo() throws Exception {
            builder.endObject();
        final BytesReference templateBytesRoundTrip;
        builder.putMapping("type1", "{\"type1\":{}}");
        });
        IndexTemplateMetadata.Builder templateBuilder = IndexTemplateMetadata.builder(templateName);
import java.util.Arrays;
                MediaTypeRegistry.JSON
            + "\"settings\" : {\"number_of_shards\" : 10,\"number_of_replicas\" : 1},"
import org.opensearch.common.xcontent.XContentHelper;
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
            + randomAlphaOfLength(10)
            );
 *
            )
import org.opensearch.core.xcontent.MediaTypeRegistry;
            XContentParser parser = XContentHelper.createParser(
 * specific language governing permissions and limitations
            templateBuilder.version(between(0, 100));
import java.io.IOException;
        }
        }
            )
                () -> IndexTemplateMetadata.Builder.fromXContent(parser, randomAlphaOfLengthBetween(1, 100))
            )
        assertWarnings(
import java.util.Map;
    public void testIndexTemplateMetadataXContentRoundTrip() throws Exception {
                randomInt(),
            builder.startObject();
 * Unless required by applicable law or agreed to in writing,
            "Index template my-template contains multiple typed mappings; " + "templates in 8x will only support a single mapping"
                Settings.EMPTY,
        }
        for (int i = 0; i < numAlias; i++) {
        templateBuilder2.order(template.order());
            + randomAlphaOfLength(10)
                randomRealisticUnicodeOfLengthBetween(5, 10),
        XContentBuilder builder = XContentBuilder.builder(randomFrom(MediaTypeRegistry.JSON.xContent()));
            AliasMetadata.Builder alias = AliasMetadata.builder(randomRealisticUnicodeOfLengthBetween(1, 100));
            + randomAlphaOfLength(10)
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
import org.opensearch.core.common.bytes.BytesArray;
        templateBuilder.patterns(Arrays.asList("pattern-1"));
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.xcontent.ToXContent;
                Map.of()
import org.opensearch.core.xcontent.XContentBuilder;
        for (int i = 0; i < numAlias; i++) {
        templateBuilder2.putMapping("doc", template.mappings());
import org.opensearch.core.xcontent.DeprecationHandler;
            + randomAlphaOfLength(10)
            alias.searchRouting(randomRealisticUnicodeOfLengthBetween(1, 100));
            IndexTemplateMetadata.Builder.toXContentWithTypes(indexTemplateMetadata, builder, ToXContent.EMPTY_PARAMS);
        template.writeVerifiableTo(checksumOut);
 */
            }
            + "{\"properties\":{\""
        try (
    }
                NamedXContentRegistry.EMPTY,
        }
        BytesReference templateBytes = new BytesArray(template);
/*
 * this file be licensed under the Apache-2.0 license or a
            + "\":{\"type\":\"text\"},\""
                alias.indexRouting(randomRealisticUnicodeOfLengthBetween(1, 100));
                new BytesArray(templateWithoutPattern),
        templateBuilder2.version(template.version());
package org.opensearch.cluster.metadata;
        final IndexTemplateMetadata indexTemplateMetadata;
                null,
            + "\"settings\" : {\"number_of_shards\" : 1,\"number_of_replicas\" : 0},"
        try (XContentParser parser = createParser(shuffleXContent(builder))) {
        }
import java.util.Collections;
            .stream()
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        IndexTemplateMetadata.Builder templateBuilder2 = IndexTemplateMetadata.builder(templateName);
    }
    }
 *
            + "{\"properties\":{\""
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        int numAlias = between(2, 5);
        builder.startObject();
            XContentParser parser = XContentHelper.createParser(
        final String templateWithoutPattern = "{\"order\" : 1000,"
                templateBytesRoundTrip,
            + "}}}";
 * The OpenSearch Contributors require contributions made to
        }
        if (randomBoolean()) {
            if (randomBoolean()) {
        ) {
 */
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            alias.indexRouting(randomRealisticUnicodeOfLengthBetween(1, 100));
            .sorted(Map.Entry.comparingByKey())
            + randomAlphaOfLength(10)
            IndexTemplateMetadata template = IndexTemplateMetadata.Builder.fromXContent(parser, randomAlphaOfLengthBetween(1, 100));
            assertThat(parsed, equalTo(template));
        ) {
        templateBuilder.putMapping("doc", "{\"doc\":{\"properties\":{\"type\":\"text\"}}}");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * GitHub history for details.
                IllegalArgumentException.class,
    public void testValidateInvalidIndexPatterns() throws Exception {
            + "\"mappings\" : {\"doc\" :"
 * the Apache License, Version 2.0 (the "License"); you may
    }
            .entrySet()
        templateBuilder.settings(Settings.builder().put("index.setting-2", randomTimeValue()));
        String templateName = randomUnicodeOfCodepointLengthBetween(1, 10);
        }
                randomInt(),
        IndexTemplateMetadata template = templateBuilder.build();
            if (randomBoolean()) {
                MediaTypeRegistry.JSON
                templateBytes,
 */
/*
        builder.patterns(Arrays.asList("a", "b"));
            + "\":{\"type\":\"keyword\"}}"
}
import org.opensearch.core.common.bytes.BytesReference;
        }
 * Licensed to Elasticsearch under one or more contributor
    }
        String templateInJSON = "{\"aliases\": {\"log\":{}}, \"index_patterns\": [\"pattern-1\"]}";
                Settings.EMPTY,
 * not use this file except in compliance with the License.
                IllegalArgumentException.class,
        String template = "{\"index_patterns\" : [ \".test-*\" ],\"order\" : 1000,"
                new BytesArray(templateInJSON),
        final IllegalArgumentException nullPatternError = expectThrows(IllegalArgumentException.class, () -> {
        IndexTemplateMetadata.Builder.toXContentWithTypes(template, builder, ToXContent.EMPTY_PARAMS);
    public void testFromToXContent() throws Exception {
            IndexTemplateMetadata parsed = IndexTemplateMetadata.Builder.fromXContent(parser, templateName);
        templateBuilder.settings(Settings.builder().put("index.setting-1", randomLong()));
            assertThat(template.patterns(), contains("pattern-1"));
        try (
/*
            final IllegalArgumentException ex = expectThrows(
            templateBuilder.settings(Settings.builder().put("index.setting-2", randomTimeValue()));
                MediaTypeRegistry.JSON
    public void testParseTemplateWithAliases() throws Exception {
                new BytesArray(templateWithEmptyPattern),
            XContentParser parser = XContentHelper.createParser(
 * this work for additional information regarding copyright
            + "\":{\"type\":\"text\"},\""
        int numAlias = between(0, 5);
            + "\"settings\" : {\"number_of_shards\" : 10,\"number_of_replicas\" : 1},"
            assertThat(ex.getMessage(), equalTo("Index patterns must not be null or empty; got []"));
        templateBuilder2.patterns(Arrays.asList("pattern-2", "pattern-1"));
        template.getAliases()
 * You may obtain a copy of the License at
        IndexTemplateMetadata.Builder builder = IndexTemplateMetadata.builder("my-template");
                MediaTypeRegistry.JSON
            }
        try (
            + randomAlphaOfLength(10)
                alias.searchRouting(randomRealisticUnicodeOfLengthBetween(1, 100));
        );
        }
            + "\":{\"type\":\"keyword\"}}"
import org.opensearch.core.xcontent.NamedXContentRegistry;
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);
            new IndexTemplateMetadata(
            templateBytesRoundTrip = BytesReference.bytes(builder);
import org.opensearch.test.OpenSearchTestCase;
        if (randomBoolean()) {
        IndexTemplateMetadata result = IndexTemplateMetadata.readFrom(in);
            + "\":{\"type\":\"keyword\"}}"
            templateBuilder.order(randomInt());
        templateBuilder.version(between(0, 100));
        builder.build();
            XContentParser parser = XContentHelper.createParser(
            templateBuilder.putAlias(alias);
import static org.hamcrest.Matchers.contains;
        if (randomBoolean()) {
                Collections.emptyList(),
        assertThat(emptyPatternError.getMessage(), equalTo("Index patterns must not be null or empty; got []"));
                randomInt(),
            + "}}}";
        templateBuilder2.settings(template.settings());
import static org.hamcrest.CoreMatchers.equalTo;
