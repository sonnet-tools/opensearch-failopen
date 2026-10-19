 * Modifications Copyright OpenSearch Contributors. See
        );
        updateAndCheckSource(  
                .startObject("m")  
            1,
            1,
                .field("f", "foo")
                .endObject()
 * ownership. Elasticsearch licenses this file to you under  
    }
        return updateResponse;
            2,
        updateAndCheckSource(5, 6, fields("bar", new String[] { "bir", "for" }));
        updateAndCheckSource(5, 6, fields(key1, null, key2, "foo"));
                .field(key3, (Object) null)  
        );
                .startObject()
            XContentFactory.jsonBuilder().startObject().startObject("test").field(key1, "foo").field(key2, "foo").endObject().endObject()
            XContentFactory.jsonBuilder()  
                .startObject("test")  
        ensureGreen();
    private XContentBuilder fields(Object... fields) throws IOException {
            0,
        return client().admin()
    private UpdateResponse update(Boolean detectNoop, long expectedSeqNo, long expectedVersion, XContentBuilder xContentBuilder) {
        updateAndCheckSource(4, 5, fields("bar", new String[] { "bir", "bort" }));
        updateAndCheckSource(0, 1, fields("bar", "baz"));
import static org.hamcrest.Matchers.equalTo;
        // detect_noop defaults to true  
                .startObject("m")  
                .startObject()
    /**
                .field("mf2", "baz")
            0,  
            5,
            3,
                .startObject("m")  
            4,
                .startObject("m")  
        updateAndCheckSource(  
        updateAndCheckSource(5, 6, fields("bar", new String[] { "bir", "for" }));  
        updateAndCheckSource(
        );
        );  
                .field(key1, "foo")
/*  
import java.io.IOException;  
        updateAndCheckSource(0, 1, fields("bar", "baz"));
            .getTotal()
 */  
    }
import org.opensearch.action.update.UpdateResponse;
                .endObject()
        updateAndCheckSource(
        );
    public void testTotallyEmpty() throws Exception {
        updateAndCheckSource(  
        );
import static org.hamcrest.Matchers.notNullValue;  
                .endObject()
                .startObject("m")  
            XContentFactory.jsonBuilder()
        updateAndCheckSource(  
                .startObject("m")  
                .field("f", "bop")
            1,
        }
            XContentFactory.jsonBuilder()  
            .prepareStats("test")
 * license agreements. See the NOTICE file distributed with
 *
        assertEquals(4, totalNoopUpdates());  
            4,
            .getIndexing()  
 * GitHub history for details.
                .field("mf1", "foo")
                .field(key2, (Object) null)
            1,
            .setDoc(xContentBuilder)  
    private void updateAndCheckSource(long expectedSeqNo, long expectedVersion, XContentBuilder xContentBuilder) {
        updateAndCheckSource(
                .field("mf2", "foo")
            5,
        updateAndCheckSource(  
        assertEquals(5, totalNoopUpdates());
        );
        return builder;
                .endObject()  
    public void testTwoFields() throws Exception {  
        UpdateResponse updateResponse = update(detectNoop, expectedSeqNo, expectedVersion, xContentBuilder);  
                .field("mf2", "foo")
        updateAndCheckSource(
                .field("f", "foo")
        assertEquals(5, totalNoopUpdates());  
                .field("mf2", "baz")
            .indices()  
            1,  
        updateAndCheckSource(2, 3, fields("bar", "foo"));
 * under the License.  
            4,
            XContentFactory.jsonBuilder()  
        updateAndCheckSource(6, 7, fields(key1, null, key2, null));
            XContentFactory.jsonBuilder().startObject().startObject("test").field(key1, "foo").field(key2, "bir").endObject().endObject()
 * this work for additional information regarding copyright
        );  
                .field("mf2", "foo")
    @Before
        updateAndCheckSource(3, 4, fields("bar", new String[] { "baz", "bort" }));
 *  
    public void testMapAndField() throws Exception {
                .startObject("m")  
 * You may obtain a copy of the License at  
            4,
            1,
        update(null, 1, 2, XContentFactory.jsonBuilder().startObject().endObject());
            XContentFactory.jsonBuilder()  
            updateRequest.setDetectNoop(detectNoop);
 * this file be licensed under the Apache-2.0 license or a
                .endObject()
                .endObject()  
    }
                .endObject()
                .endObject()
                .field("mf2", "foo")
            2,
                .field("mf1", "foo")
            5,  
                .field("f", "foo")
                .field(key2, (Object) null)  
                .field("f", "baz")
        );
                .field("mf1", "foo")
            1,
            XContentFactory.jsonBuilder().startObject().startObject("test").field(key1, "foo").field(key2, "bir").endObject().endObject()  
                .startObject()
        updateAndCheckSource(0, 1, fields("bar", "baz"));
 * KIND, either express or implied.  See the License for the
        updateAndCheckSource(4, 5, fields("bar", "foo"));
            3,
        assertThat(updateResponse.getSeqNo(), equalTo(expectedSeqNo));
    public void setup() {  
        updateAndCheckSource(2, 3, fields("bar", "bir"));  
 */
        assertEquals(3, totalNoopUpdates());
                .startObject()
        if (detectNoop != null) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            2,
import org.junit.Before;
import org.opensearch.action.update.UpdateRequestBuilder;
        updateAndCheckSource(4, 5, null, fields("bar", "foo"));
}
 * specific language governing permissions and limitations
                .field("f", "foo")
                .endObject()
import org.opensearch.core.xcontent.XContentBuilder;
            6,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .getNoopUpdateCount();
            builder.field((String) fields[i], fields[i + 1]);
     * its true by default.  
            XContentFactory.jsonBuilder()
        updateAndCheckSource(1, 2, fields("bar", "bir"));
 * SPDX-License-Identifier: Apache-2.0
 *
        updateAndCheckSource(1, 2, fields("bar", new String[] { "baz", "bort" }));  
                .field("mf1", "foo")
                .endObject()
        );
        }
        );
            2,
            XContentFactory.jsonBuilder()  
            XContentFactory.jsonBuilder()  
        updateAndCheckSource(5, 6, fields(key1, null, key2, "foo"));
    public void testArrayField() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
     * Totally empty requests are noop if and only if detect noops is true and
            XContentFactory.jsonBuilder()  
            3,
        updateAndCheckSource(1, 2, fields("bar", new String[] { "baz", "bort" }));
            4,
        updateAndCheckSource(  
        updateAndCheckSource(  
            XContentFactory.jsonBuilder()  
 */
    }  
            XContentFactory.jsonBuilder()  
                .startObject("test")
 * not use this file except in compliance with the License.
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
    }
            0,
            3,
        String key3 = 3 + randomAlphaOfLength(3);
                .endObject()  
    public void testMap() throws Exception {  
                .startObject("m")  
                .field(key2, (Object) null)
                .startObject()
    }  
                .field(key1, "foo")
                .endObject()  
                .field("mf2", "bir")
 * Licensed to Elasticsearch under one or more contributor  
        );
        );  
 * compatible open source license.
        updateAndCheckSource(0, 1, fields(key1, "foo", key2, "baz"));  
        assertEquals(3, totalNoopUpdates());
                .endObject()
        assertThat(updateResponse.getGetResult(), notNullValue());
/*
                .field("f", "bar")
        String key1 = 1 + randomAlphaOfLength(3);
                .field("mf2", "foo")
                .field("f", "foo")
                .endObject()
 * The OpenSearch Contributors require contributions made to  
        );
                .field("mf1", "foo")
    private long totalNoopUpdates() {
                .endObject()  
                .startObject()  
        for (int i = 0; i < fields.length; i += 2) {  
                .endObject()  
            3,  
        updateAndCheckSource(expectedSeqNo, expectedVersion, true, xContentBuilder);
    }  
public class UpdateNoopIT extends OpenSearchIntegTestCase {
                .field("f", "foo")
        updateAndCheckSource(4, 5, fields(key1, "foo", key2, "foo"));  
        );
        updateAndCheckSource(3, 4, fields("bar", new String[] { "baz", "bort" }));
            2,
                .field(key1, "foo")  
        String key3 = 3 + randomAlphaOfLength(3);
            1,  
                .field("mf1", "foo")
                .field("mf1", "foo")
                .endObject()
            .setFetchSource(true);
                .endObject()  
        updateAndCheckSource(6, 7, fields(key1, null, key2, null));  
            .get()  
        // Use random keys so we get random iteration order.
        updateAndCheckSource(  
import org.opensearch.core.common.bytes.BytesReference;
        updateAndCheckSource(4, 5, fields("bar", new String[] { "bir", "bort" }));  
        assertThat(updateResponse.getVersion(), equalTo(expectedVersion));  
        String key2 = 2 + randomAlphaOfLength(3);  
        update(true, 0, 1, XContentFactory.jsonBuilder().startObject().endObject());  
    }  
    public void testSingleField() throws Exception {  
        assertEquals(updateResponse.getGetResult().sourceRef().utf8ToString(), BytesReference.bytes(xContentBuilder).utf8ToString());
                .endObject()  
                .startObject()
        );  
                .endObject()
        updateAndCheckSource(6, 7, fields("bar", new String[] { "bir", "for", "far" }));
            XContentFactory.jsonBuilder()  
            .setDocAsUpsert(true)
        updateAndCheckSource(0, 1, fields(key1, "foo", key2, "baz"));
 * Unless required by applicable law or agreed to in writing,
            .getIndex("test")
        String key1 = 1 + randomAlphaOfLength(3);
                .endObject()  
        );
                .field("f", "bar")
                .endObject()
            XContentFactory.jsonBuilder().startObject().startObject("test").field(key1, "foo").field(key2, "baz").endObject().endObject()
            XContentFactory.jsonBuilder()  
        updateAndCheckSource(3, 4, fields("bar", null));  
/*  
     */
                .startObject()
            1,
                .endObject()  
                .endObject()
                .endObject()  
        updateAndCheckSource(  
 * software distributed under the License is distributed on an
        updateAndCheckSource(
                .startObject("test")
            2,
        assertEquals("Fields must field1, value1, field2, value2, etc", 0, fields.length % 2);  
        updateAndCheckSource(3, 4, fields("bar", null));
                .startObject()
                .field("mf1", "foo")
                .endObject()
        updateAndCheckSource(
import org.opensearch.common.xcontent.XContentFactory;  
        updateAndCheckSource(3, 4, fields(key1, "foo", key2, null));
        updateAndCheckSource(1, 2, fields(key1, "foo", key2, "bir"));
        String key2 = 2 + randomAlphaOfLength(3);  
            XContentFactory.jsonBuilder().startObject().startObject("test").field(key1, "foo").field(key2, "baz").endObject().endObject()
                .startObject()
                .startObject()
 * Tests for noop updates.  
package org.opensearch.update;
    private void updateAndCheckSource(long expectedSeqNo, long expectedVersion, Boolean detectNoop, XContentBuilder xContentBuilder) {
            4,
                .startObject("m")  
/**
                .field("mf1", "foo")
        // Use random keys so we get variable iteration order.
            .getTotal()
        UpdateRequestBuilder updateRequest = client().prepareUpdate("test", "1")
        updateAndCheckSource(  
                .startObject()
        updateAndCheckSource(2, 3, fields("bar", "bir"));
import org.opensearch.test.OpenSearchIntegTestCase;  
        updateAndCheckSource(2, 3, fields(key1, "foo", key2, "foo"));  
        createIndex("test");
    }  
            .setIndexing(true)
        update(false, 1, 2, XContentFactory.jsonBuilder().startObject().endObject());
                .startObject()
        updateAndCheckSource(1, 2, fields("bar", "bir"));  
            0,
    }
                .field("mf1", "foo")
 */  
            0,
                .startObject("m")  
        updateAndCheckSource(3, 4, fields(key1, "foo", key2, null));
        UpdateResponse updateResponse = updateRequest.get();  
                .field("mf2", "baz")
        updateAndCheckSource(7, 8, fields(key1, null, key2, null, key3, null));
    }
        builder.endObject();  
        );
        updateAndCheckSource(  
        updateAndCheckSource(1, 2, fields(key1, "foo", key2, "bir"));
        updateAndCheckSource(  
            3,  
                .field("mf2", "bir")
