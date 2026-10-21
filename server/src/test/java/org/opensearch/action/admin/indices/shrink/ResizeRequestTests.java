            Settings.builder()
import org.opensearch.common.xcontent.XContentType;
        resizeRequest.setMaxShardSize(new ByteSizeValue(randomIntBetween(1, 100)));
            Alias alias = new Alias("test_alias");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private void runTestCopySettingsValidation(final Boolean copySettings, final Consumer<Supplier<ResizeRequest>> consumer) {
    public void testTargetIndexSettingsValidation() {
        assertEquals(
        ResizeRequest request = new ResizeRequest(targetIndexName, sourceIndexName);
        resizeRequest.setTargetIndex(createIndexRequest);
import org.opensearch.core.xcontent.XContentParser;
            CreateIndexRequest createIndexRequest = new CreateIndexRequest(randomAlphaOfLengthBetween(3, 10));
        resizeRequest.setResizeType(ResizeType.SPLIT);
            parsedResizeRequest.fromXContent(xParser);
 * Modifications Copyright OpenSearch Contributors. See
        }
}
            alias.filter("{\"term\":{\"year\":2016}}");
    }
        );
 */
import org.opensearch.index.RandomCreateIndexGenerator;
        );
        }
            settings.put(SETTING_NUMBER_OF_SHARDS, 10);
                .put("index.sort.field", randomAlphaOfLengthBetween(3, 10))
 *
                break;
            assertEquals(expectedRequestBody, actualRequestBody);
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testGetDescription() {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                + "] will be blocked by [index.blocks.read_only=true],"
        assertEquals(resizeRequest.getSourceIndex(), parsedResizeRequest.getSourceIndex());
        });
                request.setResizeType(ResizeType.SPLIT);
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.core.xcontent.ToXContent.EMPTY_PARAMS;
 * under the License.
        createIndexRequest.settings(Settings.builder().put("index.blocks.metadata", true));
        );
                + "2: cannot provide a routing partition size value when resizing an index;",
            ResizeRequest request = new ResizeRequest();
        });
            resizeRequest.getTargetIndexRequest().index(),
    }
package org.opensearch.action.admin.indices.shrink;
        BytesReference originalBytes = toShuffledXContent(resizeRequest, xContentType, EMPTY_PARAMS, humanReadable);
import org.opensearch.core.common.bytes.BytesReference;
    }
import org.opensearch.action.admin.indices.alias.Alias;
        createIndexRequest.settings(Settings.builder().build());
        return resizeRequest;
 * license agreements. See the NOTICE file distributed with
            request.setTargetIndex(target);
        {
            case 1:
            "Validation Failed: 1: target index ["
 */
/*
public class ResizeRequestTests extends OpenSearchTestCase {
        );
        ResizeRequest resizeRequest = new ResizeRequest(randomAlphaOfLengthBetween(3, 10), randomAlphaOfLengthBetween(3, 10));
                createIndexRequest.settings(RandomCreateIndexGenerator.randomIndexSettings());
        assertEquals(resizeRequest.getTargetIndexRequest().settings(), parsedResizeRequest.getTargetIndexRequest().settings());
            "Validation Failed: 1: index.number_of_shards is required for split operations;" + "2: Unsupported parameter [max_shard_size];",
 * Licensed to Elasticsearch under one or more contributor
            String actualRequestBody = Strings.toString(MediaTypeRegistry.JSON, request);
        );
            resizeRequest.getSourceIndex()
                break;
        }
    }
        resizeRequest.setTargetIndex(createIndexRequest);
            alias.routing("1");
                resizeType = "clone";
        runTestCopySettingsValidation(false, r -> {
        resizeRequest.setMaxShardSize(new ByteSizeValue(randomIntBetween(1, 100)));
        BytesReference finalBytes = toShuffledXContent(parsedResizeRequest, xContentType, EMPTY_PARAMS, humanReadable);
            }
        resizeRequest.setMaxShardSize(new ByteSizeValue(randomIntBetween(1, 100)));
        switch (randomIntBetween(0, 2)) {
 * this work for additional information regarding copyright
import org.opensearch.action.ActionRequestValidationException;
                resizeType = "split";
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
    public void testCopySettingsValidation() {
        try (XContentParser xParser = createParser(xContentType.xContent(), originalBytes)) {
            case 2:
            e.getMessage()
            e.getMessage()
        }
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
            String actualRequestBody = Strings.toString(MediaTypeRegistry.JSON, request);
import org.opensearch.common.settings.Settings;
        assertEquals("Validation Failed: 1: Cannot set max_shard_size and index.number_of_shards at the same time!;", e.getMessage());
            alias.writeIndex(true);
 * Unless required by applicable law or agreed to in writing,
        runTestCopySettingsValidation(null, r -> assertNull(r.get().getCopySettings()));
            target.settings(settings);
        String resizeType;
 * not use this file except in compliance with the License.
            Settings.Builder settings = Settings.builder();
        );
            resizeRequest.getTargetIndexRequest().aliases(),
import org.opensearch.test.OpenSearchTestCase;
/*
 * this file be licensed under the Apache-2.0 license or a
        consumer.accept(() -> {
 */
            return request;
 * ownership. Elasticsearch licenses this file to you under
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(randomAlphaOfLengthBetween(3, 10));
            e.getMessage()
                RandomCreateIndexGenerator.randomAliases(createIndexRequest);
    public void testToXContent() throws IOException {
/*
        resizeRequest.setTargetIndex(createIndexRequest);
        assertEquals(resizeType + " from [" + sourceIndexName + "] to [" + targetIndexName + "]", request.getDescription());
        ActionRequestValidationException e = resizeRequest.validate();
            assertEquals("{\"settings\":{},\"aliases\":{}}", actualRequestBody);
        createIndexRequest.settings(Settings.builder().build());
        assertEquals(
            resizeRequest.setTargetIndex(createIndexRequest);
        final XContentType xContentType = randomFrom(XContentType.values());
import java.io.IOException;
            "Validation Failed: 1: target index ["
        resizeRequest.setTargetIndex(createIndexRequest);
 *
                + " this will disable metadata writes and cause the shards to be unassigned;",
    public void testToAndFromXContent() throws IOException {
        resizeRequest.setTargetIndex(createIndexRequest);
        resizeRequest.setResizeType(ResizeType.CLONE);
                + " this will disable metadata writes and cause the shards to be unassigned;",
            target.alias(alias);
                resizeType = "shrink";
        final ResizeRequest resizeRequest = createTestItem();
                + createIndexRequest.index()
        assertEquals(
                request.setResizeType(ResizeType.CLONE);
        createIndexRequest.settings(Settings.builder().put("index.blocks.read_only", true));
import java.util.function.Consumer;
        assertEquals(
            }
    private static ResizeRequest createTestItem() {
        assertEquals("Validation Failed: 1: Unsupported parameter [max_shard_size];", e.getMessage());
        resizeRequest.setMaxShardSize(new ByteSizeValue(randomIntBetween(1, 100)));
        assertEquals(resizeRequest.getTargetIndexRequest().index(), parsedResizeRequest.getTargetIndexRequest().index());
            final ResizeRequest request = new ResizeRequest();
            parsedResizeRequest.getTargetIndexRequest().aliases()
        createIndexRequest.settings(Settings.builder().put("index.number_of_shards", randomIntBetween(1, 10)));
        runTestCopySettingsValidation(true, r -> assertTrue(r.get().getCopySettings()));
        {
                + "] will be blocked by [index.blocks.metadata=true],"
        boolean humanReadable = randomBoolean();
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
        if (randomBoolean()) {
        CreateIndexRequestTests.assertAliasesEqual(
        e = resizeRequest.validate();
            request.setCopySettings(copySettings);
            if (randomBoolean()) {
 *
                + "\"aliases\":{\"test_alias\":{\"filter\":{\"term\":{\"year\":2016}},\"routing\":\"1\",\"is_write_index\":true}}}";
                + createIndexRequest.index()
import java.util.function.Supplier;
import org.opensearch.core.common.Strings;
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.core.xcontent.MediaTypeRegistry;
            final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, r::get);
import static org.hamcrest.Matchers.containsString;
            CreateIndexRequest target = new CreateIndexRequest("target");
import org.opensearch.action.admin.indices.create.CreateIndexRequestTests;
        resizeRequest.setTargetIndex(createIndexRequest);
                .put("index.routing_partition_size", randomIntBetween(1, 10))
        e = resizeRequest.validate();
        ResizeRequest resizeRequest = new ResizeRequest(randomAlphaOfLengthBetween(3, 10), randomAlphaOfLengthBetween(3, 10));
            String expectedRequestBody = "{\"settings\":{\"index\":{\"number_of_shards\":\"10\"}},"
        }
            ResizeRequest request = new ResizeRequest("target", "source");
    }
            default:
            "Validation Failed: 1: can't override index sort when resizing an index;"
        ResizeRequest parsedResizeRequest = new ResizeRequest(
 * specific language governing permissions and limitations
        String targetIndexName = randomAlphaOfLengthBetween(3, 10);
        e = resizeRequest.validate();
        );
 * compatible open source license.
import org.opensearch.test.hamcrest.OpenSearchAssertions;
        createIndexRequest.settings(
        OpenSearchAssertions.assertToXContentEquivalent(originalBytes, finalBytes, xContentType);
 * You may obtain a copy of the License at
    }
import static org.hamcrest.Matchers.hasToString;
        e = resizeRequest.validate();
            if (randomBoolean()) {
        e = resizeRequest.validate();
            e.getMessage()
 * the Apache License, Version 2.0 (the "License"); you may
    }
            assertThat(e, hasToString(containsString("[copySettings] can not be explicitly set to [false]")));
        String sourceIndexName = randomAlphaOfLengthBetween(3, 10);
