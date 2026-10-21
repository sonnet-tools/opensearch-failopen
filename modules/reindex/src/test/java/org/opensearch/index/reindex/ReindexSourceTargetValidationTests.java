 * ownership. Elasticsearch licenses this file to you under
                "test",
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        assertThat(
    }
                .put(index("source", "source_multi"), true)
import org.opensearch.cluster.ClusterName;
                RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
 *
            INDEX_NAME_EXPRESSION_RESOLVER,
import org.opensearch.test.OpenSearchTestCase;
            e.getMessage(),
                .put(index("source2", "source_multi"), true)
    public void testTargetIsAliasToMultipleIndicesWithoutWriteAlias() {
                .put(index("target_with_write_index", true, "target_multi_with_write_index"), true)
        succeeds("qux", "foo"); // writing directly into the index of which this is the alias works though
 */
            containsString(
 * Tests source and target index validation of reindex. Mostly that means testing that indexing from an index back into itself fails the
        fails("target_alias", "foo", "bar", "target_alias", "baz");
    private static final IndexNameExpressionResolver INDEX_NAME_EXPRESSION_RESOLVER = new IndexNameExpressionResolver(
            AUTO_CREATE_INDEX,
        .build();
}
    }
    }
        return builder.build();
        fails("target", "foo", "bar", "target", "baz");
                null,
/*
                .put(index("baz"), true)
        assertThat(
public class ReindexSourceTargetValidationTests extends OpenSearchTestCase {
        fails("target_alias", "foo", "bar", "target", "baz");
        INDEX_NAME_EXPRESSION_RESOLVER,
                .put(index("target2_without_write_index", "target_multi_with_write_index"), true)
import static java.util.Collections.emptyMap;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            )
                    + "being designated as a write index"
import org.opensearch.action.support.AutoCreateIndex;
 */
                    .put("index.number_of_shards", 1)
        fails("target_multi_with_write_index", "target_with_write_index");
        .metadata(
 * compatible open source license.
import org.opensearch.action.search.SearchRequest;
 * specific language governing permissions and limitations
package org.opensearch.index.reindex;
        ReindexValidator.validateAgainstAliases(
            containsString(
            );
    }
                randomAlphaOfLength(5),
    private static final ClusterState STATE = ClusterState.builder(new ClusterName("test"))
            remoteInfo,
            "target"
                9200,
        succeeds("target_multi_with_write_index", "target2_without_write_index");
                    .put("index.number_of_replicas", 1)
/*
import org.opensearch.indices.SystemIndices;
    private static final AutoCreateIndex AUTO_CREATE_INDEX = new AutoCreateIndex(
            ),
        succeeds("target_multi_with_write_index", "foo");
                RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
        fails("target", "foo", "bar", "target", "baz", "target");
import org.opensearch.Version;
                null,
            "target",
                    .put("index.version.created", Version.CURRENT.id)
    private void succeeds(RemoteInfo remoteInfo, String target, String... sources) {
 *
    private void succeeds(String target, String... sources) {
/**
        Exception e = expectThrows(IllegalArgumentException.class, () -> succeeds("target_multi", "foo"));
            Metadata.builder()
    private static IndexMetadata index(String name, String... aliases) {
 * under the License.
        );
            e.getMessage(),
 * GitHub history for details.
    }
                null,
    );
 * license agreements. See the NOTICE file distributed with
    }
            "target"
    private static IndexMetadata index(String name, @Nullable Boolean writeIndex, String... aliases) {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.cluster.metadata.Metadata;
            )
                randomAlphaOfLength(5),
        fails("target", "target_multi");
 * cluster....
                emptyMap(),
                .put(index("qux", false, "target_alias_with_write_index_disabled"), true)
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
        succeeds("target", "source");
        succeeds(null, target, sources);
    );
            new SearchRequest(sources),
import org.opensearch.common.settings.ClusterSettings;
/*
                .put(index("bar"), true)
                .put(index("foo"), true)
                RemoteInfo.DEFAULT_CONNECT_TIMEOUT
        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        fails("target", "foo", "bar", "target_alias", "target_alias");
                .put(index("target2", "target_multi"), true)
        succeeds(
import org.opensearch.common.util.concurrent.ThreadContext;
        Exception e = expectThrows(IllegalArgumentException.class, () -> succeeds("target_alias_with_write_index_disabled", "foo"));
    public void testTargetIsWriteAlias() {
                emptyMap(),
    public void testAliasesContainTarget() {
            ),
            builder.putAlias(AliasMetadata.builder(alias).writeIndex(writeIndex).build());
 */
            new RemoteInfo(
        // And it doesn't matter if they are the same index. They are considered to be different because the remote one is, well, remote.
        );
        fails("target_multi_with_write_index", "target_multi_with_write_index");
import org.opensearch.action.index.IndexRequest;
        assertThat(e.getMessage(), containsString("reindex cannot write into an index its reading from"));
                null,
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.core.common.bytes.BytesReference;
                "no write index is defined for alias [target_alias_with_write_index_disabled]. "
 * Modifications Copyright OpenSearch Contributors. See
            new IndexRequest(target),
        Settings.EMPTY,
 * Licensed to Elasticsearch under one or more contributor
                query,
        for (String alias : aliases) {
    public void testRemoteInfoSkipsValidation() {
        );
        );
                null,
            "does_not_exist",
        // The index doesn't have to exist
    }
        succeeds("target", "source", "source2");
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        }
        fails("target", "foo", "bar", "target_multi", "baz");
        succeeds(
                "test",
        );
                    + "disabled using is_write_index=false or the alias points to multiple indices without one being designated as a "
 * software distributed under the License is distributed on an
    }
    public void testObviousCases() {
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        succeeds("target", "source", "source2", "source_multi");
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.common.Nullable;
        fails("target", "foo", "bar", "target_alias", "baz");
    public void testTargetIsAliasWithWriteIndexDisabled() {
                RemoteInfo.DEFAULT_CONNECT_TIMEOUT
 *
            .settings(
                null,
        IndexMetadata.Builder builder = IndexMetadata.builder(name)
        fails("target_alias", "target");
 * request. Note that we can't catch you trying to remotely reindex from yourself into yourself. We actually assert here that reindexes
    }
                Settings.builder()
                    + "write index"
    private void fails(String target, String... sources) {
 * this work for additional information regarding copyright
        new SystemIndices(new HashMap<>())
        fails("target", "target");
        return index(name, null, aliases);
import static org.hamcrest.Matchers.containsString;
        )
    private final BytesReference query = new BytesArray("{ \"foo\" : \"bar\" }");
import org.opensearch.common.settings.Settings;
 */
                    + "The write index may be explicitly disabled using is_write_index=false or the alias points to multiple indices without one "
 * You may obtain a copy of the License at
        new ThreadContext(Settings.EMPTY)
        succeeds("target", "source_multi");
        Exception e = expectThrows(ActionRequestValidationException.class, () -> succeeds(target, sources));
    }
 * from remote don't need to come from existing indexes. It'd be silly to fail requests if the source index didn't exist on the target
                .put(index("target", "target_alias", "target_multi"), true)
            STATE
                query,
import java.util.HashMap;
                "no write index is defined for alias [target_multi]. The write index may be explicitly "
                9200,
        fails("target", "target_alias");
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.cluster.metadata.AliasMetadata;
            new RemoteInfo(
