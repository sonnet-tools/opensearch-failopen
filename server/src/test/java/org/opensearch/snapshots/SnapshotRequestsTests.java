        request.source(XContentHelper.convertToMap(bytes, true, builder.contentType()).v2());
            ? indicesOptions.ignoreUnavailable()
 * Licensed to Elasticsearch under one or more contributor  
                builder.field("expand_wildcards", "closed");
        IndicesOptions indicesOptions = IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean());
        assertEquals("rename-to", request.renameReplacement());
        XContentBuilder builder = jsonBuilder().startObject();
        if (includeIgnoreUnavailable) {  
        XContentBuilder builder = jsonBuilder().startObject();
            } else {  
                builder.field("expand_wildcards", "open");
        builder.startObject("index_settings").field("set1", "val2").endObject();
        CreateSnapshotRequest request = new CreateSnapshotRequest("test-repo", "test-snap");  
        BytesReference bytes = BytesReference.bytes(builder.endObject());
        assertEquals("test-snap", request.snapshot());  
        RestoreSnapshotRequest request = new RestoreSnapshotRequest("test-repo", "test-snap");  
        builder.field("allow_no_indices", indicesOptions.allowNoIndices());
        } else {  
            builder.startArray("indices");
    }
        } else {  
            builder.field("ignore_unavailable", indicesOptions.ignoreUnavailable());
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
        boolean expectedIgnoreAvailable = includeIgnoreUnavailable  
        boolean expectedIgnoreAvailable = includeIgnoreUnavailable
            builder.value("set3");
 * software distributed under the License is distributed on an
        assertWarnings("specifying [settings] when restoring a snapshot has no effect and will not be supported in a future version");
            }
        }
                builder.field("expand_wildcards", "none");
import java.io.IOException;  
            : IndicesOptions.strictExpandOpen().ignoreUnavailable();
        }
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
            } else {  
            builder.field("ignore_index_settings", "set2,set3");
        builder.field("rename_replacement", "rename-to");  
        if (randomBoolean()) {
 * ownership. Elasticsearch licenses this file to you under  
        assertArrayEquals(request.ignoreIndexSettings(), new String[] { "set2", "set3" });
            } else {  
        }  
            : IndicesOptions.strictExpandOpen().ignoreUnavailable();  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.XContentHelper;
            }
            builder.value("set2");
        assertArrayEquals(request.indices(), new String[] { "foo", "bar", "baz" });
        } else {  
        assertEquals("rename-from", request.renamePattern());  
            builder.field("ignore_unavailable", indicesOptions.ignoreUnavailable());
        BytesReference bytes = BytesReference.bytes(builder.endObject());
        builder.field("partial", partial);
 *  
        builder.startObject("index_settings").field("set1", "val2").endObject();  
 * specific language governing permissions and limitations
            builder.endArray();
 */
 */  
        if (indicesOptions.expandWildcardsClosed()) {  
            builder.endArray();  
package org.opensearch.snapshots;
            builder.value("bar");  
            }
        builder.startObject("settings").field("set1", "val1").endObject();
        if (includeIgnoreUnavailable) {
import org.opensearch.core.xcontent.XContentBuilder;  
            builder.field("ignore_index_settings", "set2,set3");
}
            } else {  
        }  
            builder.endArray();
        if (randomBoolean()) {
    }  
            builder.field("indices", "foo,bar,baz");
            }
            if (indicesOptions.expandWildcardsOpen()) {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            if (indicesOptions.expandWildcardsOpen()) {
 * not use this file except in compliance with the License.
 * under the License.  
import org.opensearch.action.support.IndicesOptions;  
        assertEquals("test-snap", request.snapshot());
        }  
        boolean includeIgnoreUnavailable = randomBoolean();  
        }
        if (indicesOptions.expandWildcardsClosed()) {  
        builder.field("partial", partial);  
            builder.value("bar");  
            builder.startArray("ignore_index_settings");
        assertEquals("test-repo", request.repository());
 * The OpenSearch Contributors require contributions made to  
/*
        assertEquals(partial, request.partial());
                builder.field("expand_wildcards", "closed");
 * GitHub history for details.
        if (randomBoolean()) {  
                builder.field("expand_wildcards", "none");
 * license agreements. See the NOTICE file distributed with
            if (indicesOptions.expandWildcardsOpen()) {
/*  
        } else {
        assertArrayEquals(request.indices(), new String[] { "foo", "bar", "baz" });
                builder.field("expand_wildcards", "open");
        assertEquals("alias-rename-from", request.renameAliasPattern());
    public void testRestoreSnapshotRequestParsing() throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 *
        assertEquals("val1", request.settings().get("set1"));  
                builder.field("expand_wildcards", "all");
        builder.startObject("settings").field("set1", "val1").endObject();
            builder.value("baz");
        assertEquals("alias-rename-to", request.renameAliasReplacement());  
        boolean partial = randomBoolean();
            builder.value("foo");
        boolean includeIgnoreUnavailable = randomBoolean();
 * SPDX-License-Identifier: Apache-2.0
        }  
            builder.value("set3");  
                builder.field("expand_wildcards", "all");
        boolean partial = randomBoolean();  
        if (randomBoolean()) {
 * Modifications Copyright OpenSearch Contributors. See
        } else {  
        builder.field("allow_no_indices", indicesOptions.allowNoIndices());
            builder.field("indices", "foo,bar,baz");
        builder.field("rename_alias_pattern", "alias-rename-from");
 * compatible open source license.
        assertEquals(partial, request.partial());
            builder.startArray("ignore_index_settings");  
        assertEquals("test-repo", request.repository());  
 * Unless required by applicable law or agreed to in writing,
        assertEquals(expectedIgnoreAvailable, request.indicesOptions().ignoreUnavailable());  
            builder.value("foo");
 *
        builder.field("rename_pattern", "rename-from");
        request.source(XContentHelper.convertToMap(bytes, true, builder.contentType()).v2());  
 *    http://www.apache.org/licenses/LICENSE-2.0
            ? indicesOptions.ignoreUnavailable()
            builder.value("baz");
 * this work for additional information regarding copyright
        assertEquals(expectedIgnoreAvailable, request.indicesOptions().ignoreUnavailable());
        }  
            builder.endArray();
    public void testCreateSnapshotRequestParsing() throws IOException {
        } else {  
            if (indicesOptions.expandWildcardsOpen()) {
        IndicesOptions indicesOptions = IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean());
 */  
public class SnapshotRequestsTests extends OpenSearchTestCase {
        builder.field("rename_alias_replacement", "alias-rename-to");
            builder.value("set2");
/*  
            builder.startArray("indices");
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.OpenSearchTestCase;
 * KIND, either express or implied.  See the License for the
