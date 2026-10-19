 * KIND, either express or implied.  See the License for the
                .endObject()
        updateAndCheckSource(6, 7, fields(key1, null, key2, null));
import java.io.IOException;
        updateAndCheckSource(
        updateAndCheckSource(2, 3, fields(key1, "foo", key2, "foo"));
        updateAndCheckSource(0, 1, fields("bar", "baz"));
        UpdateResponse updateResponse = update(detectNoop, expectedSeqNo, expectedVersion, xContentBuilder);
import static org.hamcrest.Matchers.equalTo;
                .endObject()
            XContentFactory.jsonBuilder()
            2,
                .field(key1, "foo")
        String key3 = 3 + randomAlphaOfLength(3);
            1,
                .field("mf1", "foo")
            6,
        update(true, 0, 1, XContentFactory.jsonBuilder().startObject().endObject());
                .startObject("m")
        updateAndCheckSource(0, 1, fields(key1, "foo", key2, "baz"));
            0,
                .field("mf2", "foo")
                .field("f", "bar")
            XContentFactory.jsonBuilder().startObject().startObject("test").field(key1, "foo").field(key2, "baz").endObject().endObject()
            .setDoc(xContentBuilder)
    }
    public void testMapAndField() throws Exception {
 * Unless required by applicable law or agreed to in writing,
        createIndex("test");
        updateAndCheckSource(3, 4, fields(key1, "foo", key2, null));
                .startObject()
 * under the License.
                .startObject("m")
                .field("f", "foo")
        updateAndCheckSource(
                .endObject()
            builder.field((String) fields[i], fields[i + 1]);
            XContentFactory.jsonBuilder()
        updateAndCheckSource(6, 7, fields("bar", new String[] { "bir", "for", "far" }));
        );
        updateAndCheckSource(
                .field("mf1", "foo")
                .startObject("m")
 *
                .endObject()
                .endObject()
                .startObject("test")
        assertThat(updateResponse.getVersion(), equalTo(expectedVersion));
        updateAndCheckSource(5, 6, fields(key1, null, key2, "foo"));
        ensureGreen();
    private UpdateResponse update(Boolean detectNoop, long expectedSeqNo, long expectedVersion, XContentBuilder xContentBuilder) {
/*
            4,
        updateAndCheckSource(1, 2, fields(key1, "foo", key2, "bir"));
            3,
            .setDocAsUpsert(true)
        );
            1,
    public void testTwoFields() throws Exception {
        update(null, 1, 2, XContentFactory.jsonBuilder().startObject().endObject());
 *
 * SPDX-License-Identifier: Apache-2.0
        updateAndCheckSource(3, 4, fields("bar", new String[] { "baz", "bort" }));
                .startObject()
        updateAndCheckSource(5, 6, fields("bar", new String[] { "bir", "for" }));
            XContentFactory.jsonBuilder()
        updateAndCheckSource(0, 1, fields("bar", "baz"));
                .endObject()
        updateAndCheckSource(expectedSeqNo, expectedVersion, true, xContentBuilder);
        updateAndCheckSource(2, 3, fields("bar", "bir"));
                .endObject()
 * specific language governing permissions and limitations
                .field(key2, (Object) null)
            XContentFactory.jsonBuilder()
                .field("mf2", "foo")
        updateAndCheckSource(
                .endObject()
            5,
                .startObject("m")
 * software distributed under the License is distributed on an
        updateAndCheckSource(
    private void updateAndCheckSource(long expectedSeqNo, long expectedVersion, Boolean detectNoop, XContentBuilder xContentBuilder) {
        updateAndCheckSource(5, 6, fields(key1, null, key2, "foo"));
                .endObject()
            .get()
import org.opensearch.action.update.UpdateRequestBuilder;
public class UpdateNoopIT extends OpenSearchIntegTestCase {
        assertThat(updateResponse.getSeqNo(), equalTo(expectedSeqNo));
        updateAndCheckSource(2, 3, fields("bar", "foo"));
            2,
                .field("f", "foo")
 * Modifications Copyright OpenSearch Contributors. See
        updateAndCheckSource(
            3,
            XContentFactory.jsonBuilder()
        assertEquals(3, totalNoopUpdates());
import org.opensearch.core.xcontent.XContentBuilder;
        return client().admin()
                .field("mf2", "foo")
            XContentFactory.jsonBuilder().startObject().startObject("test").field(key1, "foo").field(key2, "baz").endObject().endObject()
}
            2,
                .endObject()
 * Tests for noop updates.
 */
            XContentFactory.jsonBuilder().startObject().startObject("test").field(key1, "foo").field(key2, "bir").endObject().endObject()
                .field(key1, "foo")
            .getIndex("test")
                .endObject()
                .endObject()
        updateAndCheckSource(4, 5, fields(key1, "foo", key2, "foo"));
                .startObject()
                .field("mf2", "foo")
            .getTotal()
                .endObject()
                .startObject()
        );
    private void updateAndCheckSource(long expectedSeqNo, long expectedVersion, XContentBuilder xContentBuilder) {
    /**
        );
                .field("f", "foo")
        updateAndCheckSource(
import org.junit.Before;
            5,
        UpdateResponse updateResponse = updateRequest.get();
    }
        return builder;
        );
                .field("mf1", "foo")
        updateAndCheckSource(2, 3, fields("bar", "bir"));
    }
            4,
                .field("mf1", "foo")
        updateAndCheckSource(5, 6, fields("bar", new String[] { "bir", "for" }));
 * Licensed to Elasticsearch under one or more contributor
        if (detectNoop != null) {
                .startObject("test")
                .field("mf1", "foo")
 *    http://www.apache.org/licenses/LICENSE-2.0
        updateAndCheckSource(
        for (int i = 0; i < fields.length; i += 2) {
    }
            .getIndexing()
    @Before
        updateAndCheckSource(
                .field("mf2", "bir")
            0,
            XContentFactory.jsonBuilder()
 * not use this file except in compliance with the License.
        updateAndCheckSource(3, 4, fields("bar", new String[] { "baz", "bort" }));
            1,
    public void testMap() throws Exception {
            0,
            3,
import org.opensearch.action.update.UpdateResponse;
                .field(key3, (Object) null)
            2,
                .startObject()
        assertEquals(3, totalNoopUpdates());
        return updateResponse;
            3,
        updateAndCheckSource(0, 1, fields("bar", "baz"));
                .startObject("m")
    }
                .startObject("m")
        updateAndCheckSource(4, 5, fields("bar", new String[] { "bir", "bort" }));
import org.opensearch.test.OpenSearchIntegTestCase;
            .setIndexing(true)
        String key2 = 2 + randomAlphaOfLength(3);
            1,
        updateAndCheckSource(4, 5, fields("bar", "foo"));
        updateAndCheckSource(1, 2, fields("bar", "bir"));
                .field("f", "bar")
 * this work for additional information regarding copyright
    public void setup() {
        assertEquals(5, totalNoopUpdates());
 * this file be licensed under the Apache-2.0 license or a
                .endObject()
            3,
                .field("mf2", "baz")
import org.opensearch.common.xcontent.XContentFactory;
                .field(key2, (Object) null)
        );
    }
            4,
 *
    public void testArrayField() throws Exception {
        );
        String key1 = 1 + randomAlphaOfLength(3);
            4,
        );
                .endObject()
            1,
            XContentFactory.jsonBuilder()
            updateRequest.setDetectNoop(detectNoop);
            1,
 */
        updateAndCheckSource(
                .endObject()
                .field("mf2", "baz")
        updateAndCheckSource(4, 5, fields("bar", new String[] { "bir", "bort" }));
                .startObject("m")
    private XContentBuilder fields(Object... fields) throws IOException {
        updateAndCheckSource(3, 4, fields("bar", null));
        );
        UpdateRequestBuilder updateRequest = client().prepareUpdate("test", "1")
        updateAndCheckSource(0, 1, fields(key1, "foo", key2, "baz"));
        updateAndCheckSource(
            XContentFactory.jsonBuilder()
 * GitHub history for details.
        assertEquals(updateResponse.getGetResult().sourceRef().utf8ToString(), BytesReference.bytes(xContentBuilder).utf8ToString());
            2,
                .startObject()
import static org.hamcrest.Matchers.notNullValue;
 * The OpenSearch Contributors require contributions made to
     * its true by default.
                .field("f", "baz")
    private long totalNoopUpdates() {
                .startObject("test")
        updateAndCheckSource(
/**
import org.opensearch.core.common.bytes.BytesReference;
                .field("mf2", "foo")
                .endObject()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
            XContentFactory.jsonBuilder()
                .field("mf1", "foo")
        }
        updateAndCheckSource(6, 7, fields(key1, null, key2, null));
 * the Apache License, Version 2.0 (the "License"); you may
            XContentFactory.jsonBuilder()
        );
            .prepareStats("test")
            XContentFactory.jsonBuilder().startObject().startObject("test").field(key1, "foo").field(key2, "foo").endObject().endObject()
                .endObject()
                .endObject()
 */
    }
                .startObject("m")
        updateAndCheckSource(
        update(false, 1, 2, XContentFactory.jsonBuilder().startObject().endObject());
            XContentFactory.jsonBuilder()
    }
                .startObject()
 */
        assertThat(updateResponse.getGetResult(), notNullValue());
            2,
            .indices()
        assertEquals(4, totalNoopUpdates());
                .startObject()
        );
        );
                .field(key1, "foo")
        updateAndCheckSource(3, 4, fields(key1, "foo", key2, null));
        updateAndCheckSource(1, 2, fields("bar", new String[] { "baz", "bort" }));
        updateAndCheckSource(3, 4, fields("bar", null));
    public void testSingleField() throws Exception {
                .field("mf2", "bir")
        updateAndCheckSource(
                .startObject()
            XContentFactory.jsonBuilder()
                .field("f", "foo")
        );
        updateAndCheckSource(1, 2, fields(key1, "foo", key2, "bir"));
            4,
    }
                .startObject()
                .startObject("m")
        builder.endObject();
                .endObject()
package org.opensearch.update;
 * ownership. Elasticsearch licenses this file to you under
                .field("mf1", "foo")
            4,
        // detect_noop defaults to true
            1,
                .startObject("m")
        String key3 = 3 + randomAlphaOfLength(3);
            5,
        updateAndCheckSource(
        updateAndCheckSource(
        String key2 = 2 + randomAlphaOfLength(3);
                .endObject()
                .startObject()
                .field("mf1", "foo")
                .startObject()
        updateAndCheckSource(
        // Use random keys so we get random iteration order.
                .endObject()
                .field("mf2", "baz")
        updateAndCheckSource(7, 8, fields(key1, null, key2, null, key3, null));
                .endObject()
        updateAndCheckSource(1, 2, fields("bar", new String[] { "baz", "bort" }));
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
/*
        updateAndCheckSource(1, 2, fields("bar", "bir"));
/*
 * license agreements. See the NOTICE file distributed with
                .endObject()
    }
                .field("f", "foo")
        );
            .getTotal()
            3,
    public void testTotallyEmpty() throws Exception {
        assertEquals("Fields must field1, value1, field2, value2, etc", 0, fields.length % 2);
     * Totally empty requests are noop if and only if detect noops is true and
            0,
    }
        String key1 = 1 + randomAlphaOfLength(3);
                .endObject()
            XContentFactory.jsonBuilder()
                .startObject()
        updateAndCheckSource(
                .field("f", "foo")
 * compatible open source license.
    }
     */
                .field(key2, (Object) null)
        updateAndCheckSource(4, 5, null, fields("bar", "foo"));
        );
        );
                .field("mf1", "foo")
            1,
            XContentFactory.jsonBuilder().startObject().startObject("test").field(key1, "foo").field(key2, "bir").endObject().endObject()
            0,
                .field("mf1", "foo")
 * You may obtain a copy of the License at
            1,
                .field("f", "bop")
        // Use random keys so we get variable iteration order.
            .getNoopUpdateCount();
        );
        assertEquals(5, totalNoopUpdates());
        );
                .endObject()
            .setFetchSource(true);
