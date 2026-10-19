        }
        );  
        createIndexRequest.settings(Settings.builder().put("index.blocks.read_only", true));
import static org.hamcrest.Matchers.containsString;
                resizeType = "shrink";
 * this file be licensed under the Apache-2.0 license or a
        resizeRequest.setResizeType(ResizeType.SPLIT);
        );  
import org.opensearch.core.xcontent.XContentParser;
 * compatible open source license.
import java.util.function.Supplier;  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
        assertEquals(
    }
        );
        resizeRequest.setMaxShardSize(new ByteSizeValue(randomIntBetween(1, 100)));
 * ownership. Elasticsearch licenses this file to you under  
            parsedResizeRequest.getTargetIndexRequest().aliases()
                + createIndexRequest.index()  
        e = resizeRequest.validate();  
            Alias alias = new Alias("test_alias");  
                .put("index.routing_partition_size", randomIntBetween(1, 10))  
        );
        );
    public void testGetDescription() {
import org.opensearch.action.admin.indices.create.CreateIndexRequestTests;
 * software distributed under the License is distributed on an
        resizeRequest.setTargetIndex(createIndexRequest);
        resizeRequest.setMaxShardSize(new ByteSizeValue(randomIntBetween(1, 100)));
        String sourceIndexName = randomAlphaOfLengthBetween(3, 10);
        resizeRequest.setTargetIndex(createIndexRequest);  
            CreateIndexRequest target = new CreateIndexRequest("target");
            String actualRequestBody = Strings.toString(MediaTypeRegistry.JSON, request);  
        CreateIndexRequestTests.assertAliasesEqual(  
        );
            case 1:
            resizeRequest.getSourceIndex()
        {
        boolean humanReadable = randomBoolean();
            alias.filter("{\"term\":{\"year\":2016}}");
        ResizeRequest resizeRequest = new ResizeRequest(randomAlphaOfLengthBetween(3, 10), randomAlphaOfLengthBetween(3, 10));
        final XContentType xContentType = randomFrom(XContentType.values());
        String targetIndexName = randomAlphaOfLengthBetween(3, 10);  
            alias.writeIndex(true);  
        ResizeRequest resizeRequest = new ResizeRequest(randomAlphaOfLengthBetween(3, 10), randomAlphaOfLengthBetween(3, 10));
        resizeRequest.setTargetIndex(createIndexRequest);
                request.setResizeType(ResizeType.CLONE);  
            String actualRequestBody = Strings.toString(MediaTypeRegistry.JSON, request);  
                + "] will be blocked by [index.blocks.read_only=true],"
            }  
        runTestCopySettingsValidation(false, r -> {
        assertEquals(resizeRequest.getSourceIndex(), parsedResizeRequest.getSourceIndex());
package org.opensearch.action.admin.indices.shrink;
        {  
import static org.hamcrest.Matchers.hasToString;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        String resizeType;
import java.io.IOException;
                + "] will be blocked by [index.blocks.metadata=true],"
 *    http://www.apache.org/licenses/LICENSE-2.0
            Settings.Builder settings = Settings.builder();
}
            target.alias(alias);
            "Validation Failed: 1: can't override index sort when resizing an index;"
 * You may obtain a copy of the License at  
import org.opensearch.common.settings.Settings;
            Settings.builder()
        resizeRequest.setTargetIndex(createIndexRequest);
            final ResizeRequest request = new ResizeRequest();  
        resizeRequest.setTargetIndex(createIndexRequest);
        runTestCopySettingsValidation(true, r -> assertTrue(r.get().getCopySettings()));
import org.opensearch.core.common.unit.ByteSizeValue;  
                RandomCreateIndexGenerator.randomAliases(createIndexRequest);
        assertEquals(  
 *
        assertEquals(
    }
            ResizeRequest request = new ResizeRequest();
 * under the License.  
            e.getMessage()
                break;
    private void runTestCopySettingsValidation(final Boolean copySettings, final Consumer<Supplier<ResizeRequest>> consumer) {
    public void testCopySettingsValidation() {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            settings.put(SETTING_NUMBER_OF_SHARDS, 10);  
    }
        consumer.accept(() -> {
        ActionRequestValidationException e = resizeRequest.validate();  
 *
            final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, r::get);
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        createIndexRequest.settings(Settings.builder().build());  
 * Licensed to Elasticsearch under one or more contributor  
    }
                .put("index.sort.field", randomAlphaOfLengthBetween(3, 10))
        );
public class ResizeRequestTests extends OpenSearchTestCase {
            }  
            resizeRequest.getTargetIndexRequest().aliases(),
        resizeRequest.setResizeType(ResizeType.CLONE);
import org.opensearch.core.common.bytes.BytesReference;
            resizeRequest.getTargetIndexRequest().index(),  
        BytesReference originalBytes = toShuffledXContent(resizeRequest, xContentType, EMPTY_PARAMS, humanReadable);  
            target.settings(settings);
        final ResizeRequest resizeRequest = createTestItem();
        assertEquals("Validation Failed: 1: Unsupported parameter [max_shard_size];", e.getMessage());
        createIndexRequest.settings(  
        e = resizeRequest.validate();
            request.setCopySettings(copySettings);
            if (randomBoolean()) {
        resizeRequest.setTargetIndex(createIndexRequest);
        }
 * Modifications Copyright OpenSearch Contributors. See
            if (randomBoolean()) {
 * the Apache License, Version 2.0 (the "License"); you may
            resizeRequest.setTargetIndex(createIndexRequest);
import org.opensearch.action.admin.indices.alias.Alias;
            e.getMessage()  
 *  
import org.opensearch.action.admin.indices.create.CreateIndexRequest;  
 */
    private static ResizeRequest createTestItem() {  
    public void testTargetIndexSettingsValidation() {
        resizeRequest.setMaxShardSize(new ByteSizeValue(randomIntBetween(1, 100)));  
        createIndexRequest.settings(Settings.builder().put("index.blocks.metadata", true));  
 */  
 * The OpenSearch Contributors require contributions made to  
        });  
    }
        assertEquals(resizeRequest.getTargetIndexRequest().index(), parsedResizeRequest.getTargetIndexRequest().index());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
        e = resizeRequest.validate();
        createIndexRequest.settings(Settings.builder().put("index.number_of_shards", randomIntBetween(1, 10)));
 * GitHub history for details.
    }
import org.opensearch.common.xcontent.XContentType;  
            assertThat(e, hasToString(containsString("[copySettings] can not be explicitly set to [false]")));  
                + "\"aliases\":{\"test_alias\":{\"filter\":{\"term\":{\"year\":2016}},\"routing\":\"1\",\"is_write_index\":true}}}";
/*  
            request.setTargetIndex(target);
        assertEquals(
        ResizeRequest parsedResizeRequest = new ResizeRequest(
    public void testToXContent() throws IOException {  
                + createIndexRequest.index()  
import static org.opensearch.core.xcontent.ToXContent.EMPTY_PARAMS;  
            assertEquals("{\"settings\":{},\"aliases\":{}}", actualRequestBody);
import java.util.function.Consumer;
            e.getMessage()  
import org.opensearch.core.common.Strings;
        assertEquals(resizeType + " from [" + sourceIndexName + "] to [" + targetIndexName + "]", request.getDescription());  
        ResizeRequest request = new ResizeRequest(targetIndexName, sourceIndexName);
            parsedResizeRequest.fromXContent(xParser);
        assertEquals("Validation Failed: 1: Cannot set max_shard_size and index.number_of_shards at the same time!;", e.getMessage());
            ResizeRequest request = new ResizeRequest("target", "source");
            e.getMessage()
        }
import org.opensearch.action.ActionRequestValidationException;
        runTestCopySettingsValidation(null, r -> assertNull(r.get().getCopySettings()));  
        createIndexRequest.settings(Settings.builder().build());
            assertEquals(expectedRequestBody, actualRequestBody);  
 */  
        e = resizeRequest.validate();  
                + " this will disable metadata writes and cause the shards to be unassigned;",
                resizeType = "split";  
    }
        OpenSearchAssertions.assertToXContentEquivalent(originalBytes, finalBytes, xContentType);
                createIndexRequest.settings(RandomCreateIndexGenerator.randomIndexSettings());
            String expectedRequestBody = "{\"settings\":{\"index\":{\"number_of_shards\":\"10\"}},"
 * specific language governing permissions and limitations
                request.setResizeType(ResizeType.SPLIT);
        }
        try (XContentParser xParser = createParser(xContentType.xContent(), originalBytes)) {  
        });
            "Validation Failed: 1: target index ["
        resizeRequest.setMaxShardSize(new ByteSizeValue(randomIntBetween(1, 100)));
            "Validation Failed: 1: index.number_of_shards is required for split operations;" + "2: Unsupported parameter [max_shard_size];",
            CreateIndexRequest createIndexRequest = new CreateIndexRequest(randomAlphaOfLengthBetween(3, 10));  
        BytesReference finalBytes = toShuffledXContent(parsedResizeRequest, xContentType, EMPTY_PARAMS, humanReadable);  
        assertEquals(resizeRequest.getTargetIndexRequest().settings(), parsedResizeRequest.getTargetIndexRequest().settings());
                break;
        switch (randomIntBetween(0, 2)) {  
 * KIND, either express or implied.  See the License for the
                resizeType = "clone";
            case 2:
        return resizeRequest;  
            default:  
    public void testToAndFromXContent() throws IOException {
            alias.routing("1");
        }
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(randomAlphaOfLengthBetween(3, 10));  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
                + " this will disable metadata writes and cause the shards to be unassigned;",
                + "2: cannot provide a routing partition size value when resizing an index;",  
        e = resizeRequest.validate();  
/*
            "Validation Failed: 1: target index ["
import org.opensearch.test.hamcrest.OpenSearchAssertions;
        if (randomBoolean()) {
            return request;
import org.opensearch.index.RandomCreateIndexGenerator;  
