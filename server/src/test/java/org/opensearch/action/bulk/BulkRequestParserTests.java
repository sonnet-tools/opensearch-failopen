            null,
        }, req -> fail());
        assertTrue(parsed.get());
        parser.parse(request, "foo", null, null, null, true, false, MediaTypeRegistry.JSON, indexRequest -> {
        IllegalArgumentException ex = expectThrows(
                req -> fail()
            null,
            assertFalse(parsed.get());
        request = new BytesArray(
 * the Apache License, Version 2.0 (the "License"); you may
    public void testUpdateRequest() throws IOException {
 * software distributed under the License is distributed on an
            assertFalse(updateRequest.isRequireAlias());
        BytesArray request = new BytesArray("{ \"index\":{ \"_id\": \"bar\" } }\n{}\n");
                request,
        BulkRequestParser parser = new BulkRequestParser();
        BulkRequestParser parser = new BulkRequestParser();
 * this work for additional information regarding copyright
        assertSame(first.getPipeline(), second.getPipeline());
        parser.parse(request, "foo", null, null, null, true, false, MediaTypeRegistry.JSON, indexRequest -> {
        final AtomicBoolean parsed = new AtomicBoolean();
                null,
        assertTrue(parsed.get());
                null,
        final AtomicBoolean parsed = new AtomicBoolean();
        }, req -> fail(), req -> fail());
                req -> fail(),
        );
            ex.getMessage()
 * Unless required by applicable law or agreed to in writing,
 */
    }
 * GitHub history for details.
                indexRequest -> fail(),
        );
    public void testFailOnExplicitIndex() {
                req -> fail()
    public void testDeleteRequest() throws IOException {
        BytesArray request = new BytesArray("{ \"delete\":{ \"_id\": \"bar\" } }\n");
                null,
        parser.parse(
        BytesArray request = new BytesArray("{ \"baz\":{ \"_id\": \"bar\" } }\n{}\n");
import java.util.List;
            MediaTypeRegistry.JSON,
            assertEquals("foo", updateRequest.index());
            IllegalArgumentException.class,
                request,
        }, req -> fail());
        });
            parsed.set(true);
            null,
                req -> fail()
            assertFalse(indexRequest.isRequireAlias());
            assertEquals("foo", indexRequest.index());
 *    http://www.apache.org/licenses/LICENSE-2.0
        BytesArray request = new BytesArray(
            "Malformed action/metadata line [1], expected one of [create, delete, index, update] but found [baz]",
public class BulkRequestParserTests extends OpenSearchTestCase {
/*
            "{ \"index\":{ \"_index\": \"bar\", \"pipeline\": \"foo\", \"routing\": \"blub\"} }\n{}\n"
 * KIND, either express or implied.  See the License for the
                null,
            assertEquals(updateRequest.upsertRequest().getPipeline(), "testPipeline");
            assertEquals("foo", deleteRequest.index());
                MediaTypeRegistry.JSON,
            parsed.set(true);
        }, req -> fail(), req -> fail());
    public void testFailOnUnsupportedAction() {
                false,
import org.opensearch.core.xcontent.MediaTypeRegistry;
            assertEquals("bar", indexRequest.id());
            assertFalse(updateRequest.isRequireAlias());
                "foo",
        );
            assertEquals("bar", deleteRequest.id());
                req -> fail(),
import java.util.ArrayList;
 * not use this file except in compliance with the License.
    }
package org.opensearch.action.bulk;
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(updateRequest.isRequireAlias());
}
import java.util.concurrent.atomic.AtomicBoolean;
            parsed.set(true);
            assertFalse(parsed.get());
 */
 *
            () -> parser.parse(
        final IndexRequest second = indexRequests.get(1);
import org.opensearch.action.index.IndexRequest;
        assertThat(indexRequests, Matchers.hasSize(2));
/*
        assertSame(first.routing(), second.routing());
 * You may obtain a copy of the License at
                null,
        final List<IndexRequest> indexRequests = new ArrayList<>();
import java.io.IOException;
        assertEquals("explicit index in bulk is not allowed", ex.getMessage());
                false,
            indexRequest -> indexRequests.add(indexRequest),
                null,
import org.opensearch.core.common.bytes.BytesArray;
            null,
        assertTrue(parsed.get());
            assertFalse(indexRequest.isRequireAlias());
        final IndexRequest first = indexRequests.get(0);
            assertEquals("bar", updateRequest.id());
        parser.parse(request, "foo", null, null, null, null, false, MediaTypeRegistry.JSON, req -> fail(), req -> fail(), deleteRequest -> {
        }, req -> fail());
            IllegalArgumentException.class,
        IllegalArgumentException ex = expectThrows(
                null,
        BytesArray request = new BytesArray("{ \"index\":{ \"_id\": \"bar\" } }\n{}");
        parser.parse(request, "foo", null, null, null, true, false, MediaTypeRegistry.JSON, req -> fail(), updateRequest -> {
    }
        BulkRequestParser parser = new BulkRequestParser();
    public void testParseDeduplicatesParameterStrings() throws IOException {
 *
        BytesArray request = new BytesArray("{ \"update\":{ \"_id\": \"bar\" } }\n{}\n");
 * Modifications Copyright OpenSearch Contributors. See
        );
            )
        assertEquals(
        BulkRequestParser parser = new BulkRequestParser();
 */
        request = new BytesArray("{ \"index\":{ \"_id\": \"bar\", \"require_alias\": true } }\n{}\n");
                + "{ \"index\":{ \"_index\": \"bar\", \"pipeline\": \"foo\", \"routing\": \"blub\" } }\n{}\n"
        assertEquals("The bulk request must be terminated by a newline [\\n]", e.getMessage());
                null,
    }
        }, req -> fail(), req -> fail());
    }
 * Licensed to Elasticsearch under one or more contributor
                "foo",
                MediaTypeRegistry.JSON,
        BulkRequestParser parser = new BulkRequestParser();
 *
                req -> fail(),
        BulkRequestParser parser = new BulkRequestParser();
 * license agreements. See the NOTICE file distributed with
            "{ \"update\":{ \"_id\": \"bar\", \"require_alias\": false, \"pipeline\": \"testPipeline\" } }\n{\"upsert\": {\"x\": 1}}\n"
 * ownership. Elasticsearch licenses this file to you under
        assertSame(first.index(), second.index());
 * SPDX-License-Identifier: Apache-2.0
                req -> fail(),
                req -> fail(),
        parser.parse(request, "foo", null, null, null, null, false, MediaTypeRegistry.JSON, req -> fail(), updateRequest -> {
        );
        BulkRequestParser parser = new BulkRequestParser();
            IllegalArgumentException.class,
    public void testIndexRequest() throws IOException {
                null,
        request = new BytesArray("{ \"update\":{ \"_id\": \"bar\", \"require_alias\": true } }\n{}\n");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        parser.parse(request, "foo", null, null, null, true, false, MediaTypeRegistry.JSON, req -> fail(), updateRequest -> {
            assertFalse(parsed.get());
                false,
            request,
        IllegalArgumentException e = expectThrows(
            req -> fail()
                null,
/*
        parser.parse(request, "foo", null, null, null, null, false, MediaTypeRegistry.JSON, req -> fail(), updateRequest -> {
    }
            )
            null,
 * specific language governing permissions and limitations
        }, req -> fail());
                MediaTypeRegistry.JSON,
        parser.parse(request, "foo", null, null, null, null, false, MediaTypeRegistry.JSON, indexRequest -> {
                null,
        final AtomicBoolean parsed = new AtomicBoolean();
            () -> parser.parse(
            assertTrue(updateRequest.isRequireAlias());
        }, req -> fail(), req -> fail());
            true,
        );
            )
 * The OpenSearch Contributors require contributions made to
    public void testBarfOnLackOfTrailingNewline() {
 * compatible open source license.
        }, req -> fail());
        parser.parse(request, "foo", null, null, null, null, false, MediaTypeRegistry.JSON, indexRequest -> {
                null,
        request = new BytesArray("{ \"index\":{ \"_id\": \"bar\", \"require_alias\": false } }\n{}\n");
        BytesArray request = new BytesArray("{ \"index\":{ \"_index\": \"foo\", \"_id\": \"bar\" } }\n{}\n");
            assertTrue(indexRequest.isRequireAlias());
        parser.parse(request, "foo", null, null, null, true, false, MediaTypeRegistry.JSON, req -> fail(), updateRequest -> {
                request,
import org.hamcrest.Matchers;
            () -> parser.parse(
        request = new BytesArray("{ \"update\":{ \"_id\": \"bar\", \"require_alias\": false } }\n{}\n");
            req -> fail(),
    }
            assertTrue(indexRequest.isRequireAlias());
import org.opensearch.test.OpenSearchTestCase;
 * under the License.
        );
                true,
