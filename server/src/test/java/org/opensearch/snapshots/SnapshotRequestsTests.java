        BytesReference bytes = BytesReference.bytes(builder.endObject());
        }
        request.source(XContentHelper.convertToMap(bytes, true, builder.contentType()).v2());
            } else {
        if (randomBoolean()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertArrayEquals(request.ignoreIndexSettings(), new String[] { "set2", "set3" });
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
 * Modifications Copyright OpenSearch Contributors. See
            builder.value("set2");
        BytesReference bytes = BytesReference.bytes(builder.endObject());
        XContentBuilder builder = jsonBuilder().startObject();
            builder.startArray("ignore_index_settings");
    }
        builder.startObject("index_settings").field("set1", "val2").endObject();
        if (randomBoolean()) {
 * Unless required by applicable law or agreed to in writing,
        assertEquals("val1", request.settings().get("set1"));
        CreateSnapshotRequest request = new CreateSnapshotRequest("test-repo", "test-snap");
        if (includeIgnoreUnavailable) {
    }
                builder.field("expand_wildcards", "none");
                builder.field("expand_wildcards", "all");
 * GitHub history for details.
        assertEquals("rename-from", request.renamePattern());
            : IndicesOptions.strictExpandOpen().ignoreUnavailable();
 * license agreements. See the NOTICE file distributed with
        RestoreSnapshotRequest request = new RestoreSnapshotRequest("test-repo", "test-snap");
import org.opensearch.core.xcontent.XContentBuilder;
        assertArrayEquals(request.indices(), new String[] { "foo", "bar", "baz" });
        if (randomBoolean()) {
        builder.startObject("settings").field("set1", "val1").endObject();
 * compatible open source license.
        IndicesOptions indicesOptions = IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean());
        assertEquals("rename-to", request.renameReplacement());
        }
                builder.field("expand_wildcards", "open");
            builder.value("bar");
 * software distributed under the License is distributed on an
            } else {
        builder.field("partial", partial);
        assertEquals("test-repo", request.repository());
        assertEquals("alias-rename-from", request.renameAliasPattern());
            builder.value("set3");
            ? indicesOptions.ignoreUnavailable()
        } else {
        assertEquals(partial, request.partial());
        builder.startObject("index_settings").field("set1", "val2").endObject();
        }
 * specific language governing permissions and limitations
    public void testCreateSnapshotRequestParsing() throws IOException {
            builder.field("ignore_index_settings", "set2,set3");
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to
            builder.startArray("indices");
            builder.startArray("indices");
    public void testRestoreSnapshotRequestParsing() throws IOException {
        IndicesOptions indicesOptions = IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean());
            builder.endArray();
            if (indicesOptions.expandWildcardsOpen()) {
/*
            builder.value("baz");
        assertArrayEquals(request.indices(), new String[] { "foo", "bar", "baz" });
 *
        assertEquals("alias-rename-to", request.renameAliasReplacement());
            builder.field("ignore_unavailable", indicesOptions.ignoreUnavailable());
 * under the License.
 *
            builder.value("foo");
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                builder.field("expand_wildcards", "closed");
import org.opensearch.core.common.bytes.BytesReference;
            if (indicesOptions.expandWildcardsOpen()) {
            }
            if (indicesOptions.expandWildcardsOpen()) {
 * SPDX-License-Identifier: Apache-2.0
            builder.field("indices", "foo,bar,baz");
        if (indicesOptions.expandWildcardsClosed()) {
        if (randomBoolean()) {
        request.source(XContentHelper.convertToMap(bytes, true, builder.contentType()).v2());
        XContentBuilder builder = jsonBuilder().startObject();
            }
        }
 */
            builder.endArray();
 * this work for additional information regarding copyright
 */
            builder.field("ignore_index_settings", "set2,set3");
        assertEquals("test-snap", request.snapshot());
        }
        }
        boolean expectedIgnoreAvailable = includeIgnoreUnavailable
        builder.field("allow_no_indices", indicesOptions.allowNoIndices());
            builder.startArray("ignore_index_settings");
/*
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
        assertEquals("test-snap", request.snapshot());
        builder.field("rename_pattern", "rename-from");
            : IndicesOptions.strictExpandOpen().ignoreUnavailable();
            if (indicesOptions.expandWildcardsOpen()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            builder.value("baz");
        builder.field("rename_alias_pattern", "alias-rename-from");
        boolean includeIgnoreUnavailable = randomBoolean();
        assertEquals("test-repo", request.repository());
public class SnapshotRequestsTests extends OpenSearchTestCase {
                builder.field("expand_wildcards", "closed");
            }
        boolean expectedIgnoreAvailable = includeIgnoreUnavailable
 * ownership. Elasticsearch licenses this file to you under
            ? indicesOptions.ignoreUnavailable()
import org.opensearch.common.xcontent.XContentHelper;
/*
        builder.field("partial", partial);
            builder.endArray();
        assertWarnings("specifying [settings] when restoring a snapshot has no effect and will not be supported in a future version");
            builder.value("set2");
        boolean partial = randomBoolean();
        boolean includeIgnoreUnavailable = randomBoolean();
        builder.field("allow_no_indices", indicesOptions.allowNoIndices());
        if (indicesOptions.expandWildcardsClosed()) {
        assertEquals(expectedIgnoreAvailable, request.indicesOptions().ignoreUnavailable());
package org.opensearch.snapshots;
        if (includeIgnoreUnavailable) {
            } else {
 */
            builder.value("bar");
 * Licensed to Elasticsearch under one or more contributor
                builder.field("expand_wildcards", "all");
 * You may obtain a copy of the License at
        } else {
            builder.value("foo");
        builder.field("rename_alias_replacement", "alias-rename-to");
            }
            builder.field("ignore_unavailable", indicesOptions.ignoreUnavailable());
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
                builder.field("expand_wildcards", "open");
import org.opensearch.test.OpenSearchTestCase;
        } else {
            builder.field("indices", "foo,bar,baz");
            } else {
            builder.value("set3");
        builder.startObject("settings").field("set1", "val1").endObject();
        }
            builder.endArray();
 *
        } else {
        assertEquals(partial, request.partial());
}
 * KIND, either express or implied.  See the License for the
        } else {
        boolean partial = randomBoolean();
import org.opensearch.action.support.IndicesOptions;
                builder.field("expand_wildcards", "none");
        assertEquals(expectedIgnoreAvailable, request.indicesOptions().ignoreUnavailable());
import java.io.IOException;
        builder.field("rename_replacement", "rename-to");
        } else {
