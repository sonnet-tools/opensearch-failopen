        fails("target_alias", "target");
        return index(name, null, aliases);  
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.ClusterSettings;
/*  
    }
            "target",
        succeeds("target_multi_with_write_index", "foo");
                "test",  
                    + "The write index may be explicitly disabled using is_write_index=false or the alias points to multiple indices without one "  
            "does_not_exist",
import org.opensearch.core.common.bytes.BytesReference;
        succeeds(  
import org.opensearch.common.util.concurrent.ThreadContext;  
        INDEX_NAME_EXPRESSION_RESOLVER,  
            )
                emptyMap(),
                .put(index("target_with_write_index", true, "target_multi_with_write_index"), true)
 * under the License.  
    public void testObviousCases() {  
        assertThat(e.getMessage(), containsString("reindex cannot write into an index its reading from"));
        succeeds(null, target, sources);  
import org.opensearch.cluster.metadata.AliasMetadata;
            STATE
        succeeds("target", "source", "source2");
            new IndexRequest(target),  
    public void testTargetIsWriteAlias() {
 * Unless required by applicable law or agreed to in writing,
        .metadata(
 * GitHub history for details.
                "no write index is defined for alias [target_multi]. The write index may be explicitly "
                .put(index("target2_without_write_index", "target_multi_with_write_index"), true)  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        );  
        fails("target_multi_with_write_index", "target_with_write_index");
 * software distributed under the License is distributed on an
import org.opensearch.cluster.ClusterName;  
import org.opensearch.common.Nullable;  
/*  
 * from remote don't need to come from existing indexes. It'd be silly to fail requests if the source index didn't exist on the target
import static java.util.Collections.emptyMap;
        // And it doesn't matter if they are the same index. They are considered to be different because the remote one is, well, remote.
        Settings.EMPTY,
                    .put("index.number_of_replicas", 1)  
                .put(index("baz"), true)
        for (String alias : aliases) {
    }  
    }
        fails("target_alias", "foo", "bar", "target_alias", "baz");  
 * cluster....  
 * ownership. Elasticsearch licenses this file to you under  
 */  
        fails("target", "target_multi");  
import org.opensearch.cluster.ClusterState;
public class ReindexSourceTargetValidationTests extends OpenSearchTestCase {
                randomAlphaOfLength(5),  
            new SearchRequest(sources),
        }
import static org.hamcrest.Matchers.containsString;  
            )
import org.opensearch.action.support.AutoCreateIndex;
                randomAlphaOfLength(5),
                "no write index is defined for alias [target_alias_with_write_index_disabled]. "
            containsString(
        // The index doesn't have to exist  
                    .put("index.number_of_shards", 1)
        new ThreadContext(Settings.EMPTY)
        );
 * Modifications Copyright OpenSearch Contributors. See
            new RemoteInfo(
        );  
    public void testTargetIsAliasWithWriteIndexDisabled() {  
            AUTO_CREATE_INDEX,  
import org.opensearch.action.ActionRequestValidationException;
 * compatible open source license.
                    .put("index.version.created", Version.CURRENT.id)
        IndexMetadata.Builder builder = IndexMetadata.builder(name)
 * specific language governing permissions and limitations
                null,  
                emptyMap(),  
                null,
        Exception e = expectThrows(IllegalArgumentException.class, () -> succeeds("target_multi", "foo"));
                .put(index("target", "target_alias", "target_multi"), true)  
 * not use this file except in compliance with the License.
            e.getMessage(),  
    public void testAliasesContainTarget() {
        fails("target", "target_alias");  
            INDEX_NAME_EXPRESSION_RESOLVER,
                null,
        );
        fails("target", "target");
                Settings.builder()  
                RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
import org.opensearch.Version;
 */  
        succeeds(
                RemoteInfo.DEFAULT_CONNECT_TIMEOUT  
        succeeds("target_multi_with_write_index", "target2_without_write_index");  
    private static final ClusterState STATE = ClusterState.builder(new ClusterName("test"))  
}
 *
                .put(index("target2", "target_multi"), true)
        );  
            Metadata.builder()
 *
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            builder.putAlias(AliasMetadata.builder(alias).writeIndex(writeIndex).build());  
                .put(index("bar"), true)  
 *  
                "test",
    );
                null,
 */
 * the Apache License, Version 2.0 (the "License"); you may
            ),
                9200,
        assertThat(
        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
    public void testRemoteInfoSkipsValidation() {
 * SPDX-License-Identifier: Apache-2.0
    }  
    private static final AutoCreateIndex AUTO_CREATE_INDEX = new AutoCreateIndex(  
/*
    }  
    private static final IndexNameExpressionResolver INDEX_NAME_EXPRESSION_RESOLVER = new IndexNameExpressionResolver(  
 * You may obtain a copy of the License at  
                null,
            remoteInfo,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.metadata.Metadata;
        succeeds("qux", "foo"); // writing directly into the index of which this is the alias works though
 * KIND, either express or implied.  See the License for the
import java.util.HashMap;  
            new RemoteInfo(
import org.opensearch.action.search.SearchRequest;
import org.opensearch.cluster.metadata.IndexMetadata;  
        return builder.build();
                .put(index("foo"), true)
    }  
                    + "being designated as a write index"
 * The OpenSearch Contributors require contributions made to  
    private void succeeds(String target, String... sources) {
    private void succeeds(RemoteInfo remoteInfo, String target, String... sources) {  
        fails("target", "foo", "bar", "target_multi", "baz");
                .put(index("source2", "source_multi"), true)  
            ),  
        fails("target_multi_with_write_index", "target_multi_with_write_index");
    private static IndexMetadata index(String name, @Nullable Boolean writeIndex, String... aliases) {  
        )
        fails("target", "foo", "bar", "target_alias", "target_alias");
 * request. Note that we can't catch you trying to remotely reindex from yourself into yourself. We actually assert here that reindexes
        fails("target", "foo", "bar", "target", "baz");
import org.opensearch.common.settings.Settings;
                null,  
                9200,
import org.opensearch.indices.SystemIndices;  
            e.getMessage(),  
        Exception e = expectThrows(ActionRequestValidationException.class, () -> succeeds(target, sources));
    private void fails(String target, String... sources) {  
            containsString(
/**
    private static IndexMetadata index(String name, String... aliases) {
            );
        Exception e = expectThrows(IllegalArgumentException.class, () -> succeeds("target_alias_with_write_index_disabled", "foo"));
                    + "disabled using is_write_index=false or the alias points to multiple indices without one being designated as a "  
import org.opensearch.core.common.bytes.BytesArray;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
    }
            .settings(
package org.opensearch.index.reindex;
        ReindexValidator.validateAgainstAliases(
                    + "write index"
    }  
                .put(index("source", "source_multi"), true)
                query,  
 */
        succeeds("target", "source", "source2", "source_multi");  
        fails("target", "foo", "bar", "target_alias", "baz");
                query,
    );
        new SystemIndices(new HashMap<>())
    public void testTargetIsAliasToMultipleIndicesWithoutWriteAlias() {  
import org.opensearch.action.index.IndexRequest;  
                RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
        fails("target_alias", "foo", "bar", "target", "baz");
            "target"
        succeeds("target", "source");
import org.opensearch.test.OpenSearchTestCase;
    private final BytesReference query = new BytesArray("{ \"foo\" : \"bar\" }");
        fails("target", "foo", "bar", "target", "baz", "target");  
 * Tests source and target index validation of reindex. Mostly that means testing that indexing from an index back into itself fails the  
                RemoteInfo.DEFAULT_CONNECT_TIMEOUT
                .put(index("qux", false, "target_alias_with_write_index_disabled"), true)
            "target"  
        assertThat(
 * this work for additional information regarding copyright
    }
        succeeds("target", "source_multi");
        .build();
