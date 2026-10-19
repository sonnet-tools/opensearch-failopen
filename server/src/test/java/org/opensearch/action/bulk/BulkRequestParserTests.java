                null,
            null,  
            req -> fail()  
        parser.parse(request, "foo", null, null, null, null, false, MediaTypeRegistry.JSON, req -> fail(), updateRequest -> {
        assertSame(first.routing(), second.routing());
                request,  
        BulkRequestParser parser = new BulkRequestParser();  
            null,
            true,
        assertThat(indexRequests, Matchers.hasSize(2));
                null,
        BytesArray request = new BytesArray("{ \"index\":{ \"_id\": \"bar\" } }\n{}\n");  
                request,
    }
        final AtomicBoolean parsed = new AtomicBoolean();
        );
            assertEquals("bar", updateRequest.id());
                false,
            assertFalse(parsed.get());
        parser.parse(request, "foo", null, null, null, true, false, MediaTypeRegistry.JSON, indexRequest -> {
        }, req -> fail());
                MediaTypeRegistry.JSON,  
        final AtomicBoolean parsed = new AtomicBoolean();
        assertEquals("The bulk request must be terminated by a newline [\\n]", e.getMessage());
            MediaTypeRegistry.JSON,  
package org.opensearch.action.bulk;
            )
            req -> fail(),
            "{ \"index\":{ \"_index\": \"bar\", \"pipeline\": \"foo\", \"routing\": \"blub\"} }\n{}\n"
        IllegalArgumentException e = expectThrows(  
                null,  
                req -> fail()  
import org.opensearch.action.index.IndexRequest;
    public void testParseDeduplicatesParameterStrings() throws IOException {  
        parser.parse(request, "foo", null, null, null, null, false, MediaTypeRegistry.JSON, req -> fail(), req -> fail(), deleteRequest -> {
    }
        }, req -> fail(), req -> fail());  
 * compatible open source license.
        }, req -> fail());  
            assertFalse(updateRequest.isRequireAlias());
            IllegalArgumentException.class,  
        BulkRequestParser parser = new BulkRequestParser();  
        BulkRequestParser parser = new BulkRequestParser();
            assertEquals(updateRequest.upsertRequest().getPipeline(), "testPipeline");
 * Modifications Copyright OpenSearch Contributors. See
        parser.parse(request, "foo", null, null, null, true, false, MediaTypeRegistry.JSON, indexRequest -> {  
    public void testBarfOnLackOfTrailingNewline() {  
        BulkRequestParser parser = new BulkRequestParser();
        BytesArray request = new BytesArray(
 * Licensed to Elasticsearch under one or more contributor  
                MediaTypeRegistry.JSON,
            indexRequest -> indexRequests.add(indexRequest),
                request,
                MediaTypeRegistry.JSON,  
            parsed.set(true);
                indexRequest -> fail(),
 *
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
                null,
        BulkRequestParser parser = new BulkRequestParser();
        request = new BytesArray("{ \"index\":{ \"_id\": \"bar\", \"require_alias\": false } }\n{}\n");  
 * Unless required by applicable law or agreed to in writing,
        );
                null,
                "foo",  
        assertTrue(parsed.get());
    }
import java.util.List;  
            request,
 */  
        }, req -> fail(), req -> fail());
 * the Apache License, Version 2.0 (the "License"); you may
            assertTrue(updateRequest.isRequireAlias());  
            () -> parser.parse(
 * SPDX-License-Identifier: Apache-2.0
        }, req -> fail());
        final IndexRequest first = indexRequests.get(0);  
                req -> fail()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                null,
            assertFalse(parsed.get());
 * specific language governing permissions and limitations
        assertSame(first.index(), second.index());
    public void testDeleteRequest() throws IOException {  
 * You may obtain a copy of the License at  
    public void testIndexRequest() throws IOException {
 * under the License.  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        IllegalArgumentException ex = expectThrows(
 * software distributed under the License is distributed on an
                null,
            assertEquals("foo", updateRequest.index());
        }, req -> fail());  
        final List<IndexRequest> indexRequests = new ArrayList<>();  
            assertEquals("foo", deleteRequest.index());  
        BytesArray request = new BytesArray("{ \"index\":{ \"_index\": \"foo\", \"_id\": \"bar\" } }\n{}\n");
        BytesArray request = new BytesArray("{ \"delete\":{ \"_id\": \"bar\" } }\n");
                null,  
        parser.parse(request, "foo", null, null, null, null, false, MediaTypeRegistry.JSON, indexRequest -> {  
            assertFalse(indexRequest.isRequireAlias());
/*  
            assertFalse(updateRequest.isRequireAlias());  
        parser.parse(request, "foo", null, null, null, true, false, MediaTypeRegistry.JSON, req -> fail(), updateRequest -> {
        parser.parse(request, "foo", null, null, null, true, false, MediaTypeRegistry.JSON, req -> fail(), updateRequest -> {
        BytesArray request = new BytesArray("{ \"baz\":{ \"_id\": \"bar\" } }\n{}\n");
            IllegalArgumentException.class,  
                null,
 * this work for additional information regarding copyright
    }
        BytesArray request = new BytesArray("{ \"update\":{ \"_id\": \"bar\" } }\n{}\n");
        );
 *  
            )
                null,
        assertSame(first.getPipeline(), second.getPipeline());  
import java.util.ArrayList;
            assertEquals("bar", indexRequest.id());  
        request = new BytesArray("{ \"update\":{ \"_id\": \"bar\", \"require_alias\": false } }\n{}\n");
import org.opensearch.test.OpenSearchTestCase;
            assertFalse(indexRequest.isRequireAlias());
 * GitHub history for details.
        assertTrue(parsed.get());
        );
        );  
        assertTrue(parsed.get());  
import org.opensearch.core.common.bytes.BytesArray;
        parser.parse(request, "foo", null, null, null, null, false, MediaTypeRegistry.JSON, indexRequest -> {
 *
        assertEquals(  
                true,
public class BulkRequestParserTests extends OpenSearchTestCase {  
        parser.parse(request, "foo", null, null, null, true, false, MediaTypeRegistry.JSON, req -> fail(), updateRequest -> {  
        }, req -> fail(), req -> fail());
        final IndexRequest second = indexRequests.get(1);
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(indexRequest.isRequireAlias());
        request = new BytesArray(
 */
            assertTrue(updateRequest.isRequireAlias());
            assertEquals("foo", indexRequest.index());
                null,  
            parsed.set(true);
            "{ \"update\":{ \"_id\": \"bar\", \"require_alias\": false, \"pipeline\": \"testPipeline\" } }\n{\"upsert\": {\"x\": 1}}\n"
        assertEquals("explicit index in bulk is not allowed", ex.getMessage());  
        BulkRequestParser parser = new BulkRequestParser();  
 */  
            IllegalArgumentException.class,
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
                req -> fail()
                req -> fail(),
        parser.parse(request, "foo", null, null, null, null, false, MediaTypeRegistry.JSON, req -> fail(), updateRequest -> {
    }
        request = new BytesArray("{ \"update\":{ \"_id\": \"bar\", \"require_alias\": true } }\n{}\n");  
    }
        );  
/*
        );  
            parsed.set(true);
            assertTrue(indexRequest.isRequireAlias());  
                req -> fail(),
                null,  
                false,  
        BulkRequestParser parser = new BulkRequestParser();
                req -> fail(),
                false,
        }, req -> fail());
        IllegalArgumentException ex = expectThrows(
import java.util.concurrent.atomic.AtomicBoolean;
            ex.getMessage()
    public void testFailOnExplicitIndex() {
                req -> fail(),
    public void testUpdateRequest() throws IOException {
        BytesArray request = new BytesArray("{ \"index\":{ \"_id\": \"bar\" } }\n{}");
import org.hamcrest.Matchers;
                req -> fail(),  
            null,  
 * The OpenSearch Contributors require contributions made to  
            null,
                "foo",
            null,
        request = new BytesArray("{ \"index\":{ \"_id\": \"bar\", \"require_alias\": true } }\n{}\n");
                + "{ \"index\":{ \"_index\": \"bar\", \"pipeline\": \"foo\", \"routing\": \"blub\" } }\n{}\n"  
            () -> parser.parse(
        });  
            assertFalse(parsed.get());  
            assertEquals("bar", deleteRequest.id());
/*  
 * ownership. Elasticsearch licenses this file to you under  
            )
        final AtomicBoolean parsed = new AtomicBoolean();  
            "Malformed action/metadata line [1], expected one of [create, delete, index, update] but found [baz]",
        }, req -> fail(), req -> fail());  
    }
            () -> parser.parse(
}
        parser.parse(
    public void testFailOnUnsupportedAction() {
