        ensureGreen("barbaz");
        verify(refreshBuilder(indices).setIndicesOptions(options), false);
        if (fail) {
        assertThat(client().admin().indices().prepareExists("foobar").get().isExists(), equalTo(false));
        createRepository("dummy-repo", "fs", Settings.builder().put("location", randomRepoPath()));
        assertTrue(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("barbaz").get().getAliases().isEmpty());
    static ClearIndicesCacheRequestBuilder clearCache(String... indices) {
        IndicesOptions openIndicesOptions = IndicesOptions.fromOptions(false, false, false, true);
    static GetAliasesRequestBuilder getAliases(String... indices) {
        verify(getSettings("test1").setIndicesOptions(options), false);
            options
        verify(refreshBuilder("test1").setIndicesOptions(options), false);
        assertAcked(prepareCreate("test1"));
        verify(getMapping(indices).setIndicesOptions(options), false);
            "",
        verify(getMapping(indices).setIndicesOptions(options), false);
        settingsResponse = client().admin().indices().prepareGetSettings("_all").get();
        return client().prepareSearch(indices).setQuery(matchAllQuery());
        // you should still be able to run empty searches without things blowing up
 */
        verify(getMapping("test1").setIndicesOptions(options), true);
 *
    }
        verify(search(indices).setIndicesOptions(options), false);
 */
import org.opensearch.action.search.MultiSearchResponse;
    public void testPutAliasWildcard() throws Exception {
        // gateway will fail unless the majority of the replicas was allocated
        response = client().prepareSearch()
        verify(getAliases(indices), false);
        verify(client().admin().indices().prepareDelete("foobar"), false);
        verify(getAliases(indices).setIndicesOptions(options), false);
    }
    }
import static org.hamcrest.Matchers.notNullValue;
            Function.identity(),
        verify(indicesStats("test1", "test2").setIndicesOptions(options), true);
        verify(snapshot("snap2", "test1", "test2").setIndicesOptions(options), true);
        assertThat(client().admin().indices().prepareGetMappings("barbaz").get().mappings().get("barbaz"), notNullValue());
    static MultiSearchRequestBuilder msearch(IndicesOptions options, String... indices) {
        verify(validateQuery("test1", "test2").setIndicesOptions(options), false);
        ensureYellow();
        verify(segments(indices), false);
import static org.hamcrest.Matchers.is;
    }
    static RefreshRequestBuilder refreshBuilder(String... indices) {
        verify(_flush("test1", "test2").setIndicesOptions(options), true);
    }
    @Override
        verify(clearCache("test1").setIndicesOptions(options), false);
        settingsResponse = client().admin().indices().prepareGetSettings("bar*").get();
/*
 * this work for additional information regarding copyright
            } else if (requestBuilder instanceof MultiSearchRequestBuilder) {
        verify(getMapping(indices), false);
    static GetMappingsRequestBuilder getMapping(String... indices) {
        return client().admin().indices().prepareSegments(indices);
            () -> client().prepareSearch("test2", "test3").setQuery(matchAllQuery()).execute().actionGet()
        verify(client().admin().indices().prepareDelete("foo*"), false);
        verify(getMapping(indices), false);
        options = IndicesOptions.strictExpandOpen();
        verify(indicesStats("test1").setIndicesOptions(options), true);
            .setRenameReplacement("$1-copy-" + name)
        assertThat(client().admin().indices().prepareGetMappings("foo").get().mappings().get("foo"), notNullValue());
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequestBuilder;
        verify(refreshBuilder("test1").setIndicesOptions(options), true);
        verify(client().admin().indices().prepareClose("_all").setIndicesOptions(closeIndicesOptions), true);
            verify(client().admin().indices().prepareUpdateSettings("barbaz").setSettings(Settings.builder().put("e", "f")), false);
        verify(refreshBuilder(indices), false);
        assertAcked(client().admin().indices().prepareClose("test1"));
        // if there are no indices to open/close and allow_no_indices=true (default), the open/close is a no-op
        ensureGreen();
        verify(_flush("test1").setIndicesOptions(options), false);
                try {
/*
        assertAcked(client().admin().indices().prepareOpen("test1"));
        verify(forceMerge(indices).setIndicesOptions(options), false);
        verify(client().admin().indices().prepareOpen("bar*").setIndicesOptions(openIndicesOptions), false);
        public List<Setting<?>> getSettings() {
            Function.identity(),
        // Verify defaults for wildcards, with two wildcard expression and one existing index
        // if there are no indices to open/close throw an exception
    static ForceMergeRequestBuilder forceMerge(String... indices) {
        verify(getAliases("test1", "test2").setIndicesOptions(options), true);
        verify(_flush("test1").setIndicesOptions(options), false);
    }
        } else {
        verify(segments("test1", "test2"), true);
        verify(msearch(options, "test1", "test2"), true);
        verify(client().admin().indices().prepareUpdateSettings("bar*").setSettings(Settings.builder().put("a", "b")), false);
}
 * Licensed to Elasticsearch under one or more contributor
        @Override
        assertThat(client().admin().indices().prepareGetMappings("foo").get().mappings().get("foo"), notNullValue());
        return client().admin().indices().prepareStats(indices);
        verify(getFieldMapping(indices).setIndicesOptions(options), false);
        verify(segments("test1").setIndicesOptions(options), true);
        verify(refreshBuilder(indices).setIndicesOptions(options), false);
        verify(segments("test1").setIndicesOptions(options), false);
        expectThrows(IndexNotFoundException.class, () -> client().prepareSearch("test2").setQuery(matchAllQuery()).execute().actionGet());
    }
        verify(validateQuery(indices), false);
        IndicesOptions options = IndicesOptions.fromOptions(true, true, true, false, IndicesOptions.strictExpandOpenAndForbidClosed());
        createIndex("foobar");
    }
        assertFalse(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("foobar").get().getAliases().isEmpty());
        assertHitCount(response, 0L);
        waitForRelocation();
        } catch (IllegalArgumentException e) {
            Property.IndexScope
        return client().admin().indices().prepareGetFieldMappings(indices);
        createRepository("dummy-repo", "fs", Settings.builder().put("location", randomRepoPath()));
        verify(_flush(indices).setIndicesOptions(options), false);
 * the Apache License, Version 2.0 (the "License"); you may
        verify(refreshBuilder("test1", "test2").setIndicesOptions(options), true);
        verify(getFieldMapping("test1", "test2"), true);
        assertAcked(client().admin().indices().prepareClose("_all").get());
    public void testWildcardBehaviourSnapshotRestore() throws Exception {
            }
        verify(validateQuery(indices), true);
        verify(msearch(options, indices).setIndicesOptions(options), false, 1);
        verify(getAliases("test1").setIndicesOptions(options), true);
 *
        verify(client().admin().indices().prepareClose("foo*").setIndicesOptions(closeIndicesOptions), true);
    }
        verify(client().admin().indices().prepareClose("foo*").setIndicesOptions(closeIndicesOptions), false);
        verify(forceMerge(indices), false);
    }
        verify(getAliases(indices), false);
        verify(forceMerge("test1").setIndicesOptions(options), false);
        verify(clearCache("test1", "test2").setIndicesOptions(options), false);
        verify(_flush("test1").setIndicesOptions(options), false);
        verify(client().admin().indices().preparePutMapping("_all").setSource("field", "type=text"), true);
    public void testAllMissingLenient() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
            options.expandWildcardsOpen(),
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        }
        assertThat(settingsResponse.getSetting("barbaz", "index.c"), equalTo("d"));
        verify(search("test1", "test2"), true);
 *
        ensureGreen();
        verify(getSettings(indices), false);
        verify(client().admin().indices().prepareOpen("_all").setIndicesOptions(openIndicesOptions), true);
        verify(client().admin().indices().prepareAliases().addAlias("foobar", "foobar_alias"), false);
import java.util.Arrays;
        // Verify defaults
        for (String index : Arrays.asList("foo", "foobar", "bar", "barbaz")) {
    }
        verify(forceMerge("test1").setIndicesOptions(options), true);
    }
        createIndex("test1", "test2");
package org.opensearch.indices;
            .setIndicesOptions(IndicesOptions.lenientExpandOpen())
        verify(getMapping("test1", "test2").setIndicesOptions(options), false);
        // Verify defaults for wildcards, when specifying no indices (*, _all, /)
        verify(client().admin().indices().prepareClose("bar*"), false);
    }
        verify(search("test1", "test2").setIndicesOptions(options), true);
        verify(indicesStats("test1").setIndicesOptions(options), true);
 * ownership. Elasticsearch licenses this file to you under
        assertThat(client().admin().indices().prepareGetMappings("bar").get().mappings().get("bar"), notNullValue());
    }
import static org.hamcrest.Matchers.equalTo;
        verify(indicesStats(indices), false);
        verify(getFieldMapping("test1").setIndicesOptions(options), true);
        verify(client().admin().indices().prepareClose("foo*"), false);
        verify(getMapping("test1", "test2"), true);
        verify(clearCache(indices), false);
    static FlushRequestBuilder _flush(String... indices) {
        verify(snapshot("snap3", "test1", "test2").setIndicesOptions(options), false);
        options = IndicesOptions.fromOptions(false, false, true, false);
    }
        assertThat(client().admin().indices().prepareGetMappings("bar").get().mappings().get("bar"), notNullValue());
        verify(segments(indices).setIndicesOptions(options), false);
            .setIndices(indices);
        private static final Setting<String> INDEX_C = new Setting<>(
        client().admin().cluster().prepareCreateSnapshot("dummy-repo", "snap1").setWaitForCompletion(true).get();
    private static RestoreSnapshotRequestBuilder restore(String name, String... indices) {
        verify(getFieldMapping(indices), false);
        verify(msearch(options, indices).setIndicesOptions(options), false);
            options.allowNoIndices(),
import org.opensearch.index.IndexNotFoundException;
        assertThat(client().admin().indices().prepareExists("foobar").get().isExists(), equalTo(true));
        IndicesOptions options = IndicesOptions.fromOptions(false, false, true, false);
        verify(indicesStats("test1").setIndicesOptions(options), false);
                assertThat(multiSearchResponse.getResponses().length, equalTo(1));
        verify(client().admin().indices().preparePutMapping("foo").setSource("field", "type=text"), true);
        verify(client().admin().indices().preparePutMapping("_all").setSource("field", "type=text"), false);
        indices = new String[] { "foo*" };
        verify(getMapping("test1").setIndicesOptions(options), false);
    }
    }
        verify(clearCache("test1", "test2"), true);
    }
    static GetFieldMappingsRequestBuilder getFieldMapping(String... indices) {
        ensureGreen("test1");
        verify(msearch(options, "test1"), false);
    public void testPutAlias() throws Exception {
        assertThat(client().admin().indices().prepareExists("foo").get().isExists(), equalTo(false));
    static SearchRequestBuilder search(String... indices) {
 * not use this file except in compliance with the License.
    }
    private static CreateSnapshotRequestBuilder snapshot(String name, String... indices) {
            "",
        assertThat(client().admin().indices().prepareExists("barbaz").get().isExists(), equalTo(true));
                assertHitCount(searchRequestBuilder.get(), expectedCount);
        verify(client().admin().indices().prepareDelete("foo"), true);
        verify(msearch(options, "test1"), false);
public class IndicesOptionsIntegrationIT extends OpenSearchIntegTestCase {
        assertThat(client().admin().indices().prepareExists("bar").get().isExists(), equalTo(false));
        verify(restore("snap2", "test1", "test2").setIndicesOptions(options), false);
import org.opensearch.action.search.MultiSearchRequestBuilder;
        verify(getSettings("test1").setIndicesOptions(options), false);
        return client().admin()
        verify(client().admin().indices().prepareUpdateSettings("_all").setSettings(Settings.builder().put("a", "b")), true);
 * compatible open source license.
import org.opensearch.action.admin.indices.stats.IndicesStatsRequestBuilder;
        verify(restore("snap2", "foo*", "bar*").setIndicesOptions(options), false);
        assertThat(client().admin().indices().prepareGetMappings("foobar").get().mappings().get("foobar"), notNullValue());
import org.opensearch.action.search.SearchResponse;
        verify(client().admin().indices().prepareClose("bar*").setIndicesOptions(closeIndicesOptions), true);
        verify(getMapping("test1").setIndicesOptions(options), false);
        options = IndicesOptions.lenientExpandOpen();
    private static void verify(ActionRequestBuilder<?, ?> requestBuilder, boolean fail) {
        verify(search("test1", "test2"), true);
        verify(search("test1", "test2").setIndicesOptions(options), false);
    private static void verify(ActionRequestBuilder<?, ?> requestBuilder, boolean fail, long expectedCount) {
        client().prepareIndex("test1").setId("1").setSource("k", "v").setRefreshPolicy(IMMEDIATE).get();
        verify(msearch(options, "test1"), true);
        verify(clearCache("test1", "test2").setIndicesOptions(options), true);
        waitForRelocation();
        verify(indicesStats("test1", "test2").setIndicesOptions(options), false);
            .setRenamePattern("(.+)")
        client().prepareSearch().setQuery(matchAllQuery()).execute().actionGet();
        verify(refreshBuilder(indices), false);
        assertFalse(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("barbaz").get().getAliases().isEmpty());
        verify(indicesStats("test1").setIndicesOptions(options), false);
        assertThat(settingsResponse.getSetting("bar", "index.a"), equalTo("b"));
    }
        assertFalse(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("foobar").get().getAliases().isEmpty());
        IndicesOptions options = IndicesOptions.strictExpandOpenAndForbidClosed();
        createIndex("test1");
        verify(segments("test1", "test2").setIndicesOptions(options), true);
            options.allowNoIndices(),
        assertHitCount(response, 0L);
            .execute()
 * You may obtain a copy of the License at
        options = IndicesOptions.lenientExpandOpen();
    static IndicesStatsRequestBuilder indicesStats(String... indices) {
        verify(clearCache(indices), false);
        verify(msearch(null, "test1", "test2"), true);
        // Now force allow_no_indices=true
        verify(refreshBuilder("test1", "test2"), true);
    public void testSpecifiedIndexUnavailableMultipleIndices() throws Exception {
        verify(getSettings("test1").setIndicesOptions(options), false);
        verify(snapshot("snap2", "foo*", "bar*").setIndicesOptions(options), true);
        verify(msearch(null, indices), false);
            .execute()
        verify(refreshBuilder("test1").setIndicesOptions(options), false);
        // you should still be able to run empty searches without things blowing up
        verify(client().admin().indices().prepareUpdateSettings("foo").setSettings(Settings.builder().put("a", "b")), false);
        verify(search(indices), false);
        );
import org.opensearch.action.admin.indices.flush.FlushRequestBuilder;
        verify(getFieldMapping("test1", "test2").setIndicesOptions(options), true);
        verify(client().admin().indices().prepareUpdateSettings("_all").setSettings(Settings.builder().put("c", "d")), false);
            Property.Dynamic,
        verify(search("test1").setIndicesOptions(options), true);
        createIndex("test1");
        verify(search("test1").setIndicesOptions(options), false);
        indices = new String[] { "foo*", "bar*" };
        verify(client().admin().indices().prepareOpen("_all"), false);
        verify(validateQuery("test1").setIndicesOptions(options), false);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequestBuilder;
 */
        assertThat(settingsResponse.getSetting("foo", "index.c"), equalTo("d"));
import org.opensearch.action.support.IndicesOptions;
            .setQuery(matchAllQuery())
        assertThat(client().admin().indices().prepareGetMappings("foo").get().mappings().get("foo"), notNullValue());
        verify(getFieldMapping("test1", "test2").setIndicesOptions(options), false);
    }
        createIndex("foo", "foobar", "bar", "barbaz");
        return client().admin().indices().prepareGetSettings(indices);
            "index.a",
        verify(refreshBuilder("test1", "test2").setIndicesOptions(options), false);
            }
        assertThat(client().admin().indices().prepareExists("barbaz").get().isExists(), equalTo(false));
        verify(forceMerge("test1").setIndicesOptions(options), false);
        verify(_flush("test1").setIndicesOptions(options), true);
        verify(_flush(indices).setIndicesOptions(options), false);
        verify(client().admin().indices().prepareDelete("foo*"), false);
        assertFalse(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("foo").get().getAliases().isEmpty());
        );
        createIndex("foobar");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        verify(refreshBuilder("test1").setIndicesOptions(options), true);
        verify(client().admin().indices().preparePutMapping("b*").setSource("field", "type=text"), false);
        verify(getMapping("test1", "test2").setIndicesOptions(options), true);
        assertAcked(client().admin().indices().prepareOpen("_all").get());
        verify(search(indices), false, 1);
            .setWaitForCompletion(true)
                assertThat(multiSearchResponse.getResponses()[0].getResponse(), notNullValue());
        verify(restore("snap3", "foo*", "baz*").setIndicesOptions(options), true);
        // we need to wait until all shards are allocated since recovery from
        assertAcked(prepareCreate("test1"));
                assertThat(multiSearchResponse.getResponses()[0].getResponse(), nullValue());
        verify(getSettings("test1").setIndicesOptions(options), true);
            .cluster()
        // pre-closing. with lots of replicas this will fail.
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequestBuilder;
        if (options != null) {
        verify(snapshot("snap2", "foo*", "bar*").setIndicesOptions(options), false);
        expectThrows(
 * specific language governing permissions and limitations
            .setQuery(matchAllQuery())
    public void testDeleteIndex() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        verify(clearCache(indices).setIndicesOptions(options), false);
import org.opensearch.core.common.Strings;
            "index.c",
        verify(_flush(indices), false);
        verify(search("test1", "test2").setIndicesOptions(options), false);
        );
        verify(getMapping("test1").setIndicesOptions(options), false);
        verify(clearCache(indices), false);
            true,
    public void testUpdateSettings() throws Exception {
                SearchRequestBuilder searchRequestBuilder = (SearchRequestBuilder) requestBuilder;
        verify(requestBuilder, fail, 0);
        verify(segments(indices), false);
        verify(getAliases("test1", "test2").setIndicesOptions(options), false);
        verify(_flush("test1").setIndicesOptions(options), false);
            options
        verify(forceMerge("test1", "test2").setIndicesOptions(options), true);
    static GetSettingsRequestBuilder getSettings(String... indices) {
            Property.IndexScope
        verify(getAliases("test1", "test2").setIndicesOptions(options), false);
        verify(clearCache("test1").setIndicesOptions(options), true);
        verify(getAliases("test1", "test2"), true);
        assertAcked(prepareCreate("test1"));
        verify(indicesStats("test1").setIndicesOptions(options), false);
        verify(client().admin().indices().prepareClose("bar*"), false);
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequestBuilder;
    // For now don't handle closed indices
        verify(getSettings(indices).setIndicesOptions(options), false);
        ensureGreen("test2");
import java.util.Collection;
        verify(search(), false);
        verify(segments("test1").setIndicesOptions(options), true);
        response = client().prepareSearch("test2", "test3")
        verify(forceMerge("test1").setIndicesOptions(options), false);
import java.util.function.Function;
        verify(client().admin().indices().preparePutMapping("barbaz").setSource("field", "type=text"), false);
import org.opensearch.common.settings.Setting;
        verify(refreshBuilder(indices), false);
            .setQuery(matchAllQuery())
        assertHitCount(response, 1L);
        verify(segments(indices), false);
        assertThat(client().admin().indices().prepareGetMappings("bar").get().mappings().get("bar"), notNullValue());
        verify(forceMerge("test1", "test2").setIndicesOptions(options), false);
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
 * under the License.
        verify(search("test1").setIndicesOptions(options), false);
        assertAcked(client().admin().indices().prepareClose("test2").get());
        );
    }
        verify(client().admin().indices().prepareClose("bar*").setIndicesOptions(closeIndicesOptions), false);
        assertThat(settingsResponse.getSetting("foobar", "index.c"), equalTo("d"));
        verify(getSettings("test1", "test2"), true);
        verify(validateQuery("test1").setIndicesOptions(options), true);
    public void testPutMapping() throws Exception {
            multiSearchRequestBuilder.setIndicesOptions(options);
            return Arrays.asList(INDEX_A, INDEX_C, INDEX_E);
        verify(validateQuery("test1", "test2"), true);
        createIndex("test1");
        verify(validateQuery("test1", "test2").setIndicesOptions(options), true);
            options.expandWildcardsOpen(),
        verify(_flush("test1", "test2"), true);
        verify(getFieldMapping(indices), false);
        return client().admin().indices().prepareForceMerge(indices);
        client().prepareIndex("foobar").setId("1").setSource("k", "v").setRefreshPolicy(IMMEDIATE).get();
 * The OpenSearch Contributors require contributions made to
        verify(getAliases("test1").setIndicesOptions(options), false);
        verify(segments("test1").setIndicesOptions(options), false);
        verify(getSettings("test1", "test2").setIndicesOptions(options), true);
            true,
        assertThat(client().admin().indices().prepareExists("foo").get().isExists(), equalTo(false));
        assertThat(client().admin().indices().prepareGetMappings("barbaz").get().mappings().get("barbaz"), notNullValue());
        return client().admin().indices().prepareClearCache(indices);
        verify(client().admin().indices().prepareOpen("bar*"), false);
        verify(refreshBuilder("test1").setIndicesOptions(options), false);
        createIndex("foo", "foobar", "bar", "barbaz");
                    requestBuilder.get();
        // Now force allow_no_indices=true
        verify(_flush("test1", "test2").setIndicesOptions(options), false);
        assertThat(client().admin().indices().prepareExists("foobar").get().isExists(), equalTo(false));
        verify(client().admin().indices().preparePutMapping("c*").setSource("field", "type=text"), true);
        ensureGreen();
 * this file be licensed under the Apache-2.0 license or a
        return client().admin().indices().prepareValidateQuery(indices);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        verify(client().admin().indices().preparePutMapping("foo").setSource("field", "type=text"), false);
        options = IndicesOptions.fromOptions(
    public static final class TestPlugin extends Plugin {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        verify(restore("snap1", "test1", "test2"), true);
        verify(getAliases("test1").setIndicesOptions(options), true);
        verify(client().admin().indices().prepareDelete("_all"), false);
        return client().admin().cluster().prepareCreateSnapshot("dummy-repo", name).setWaitForCompletion(true).setIndices(indices);
        verify(restore("snap3", "foo*", "bar*").setIndicesOptions(options), false);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                assertThat(multiSearchResponse.getResponses()[0].isFailure(), is(true));
        ensureGreen("foobar");
    }
            .actionGet();
        createIndex("foo", "foobar", "bar", "barbaz");
        assertThat(settingsResponse.getSetting("barbaz", "index.a"), equalTo("b"));
        verify(segments("test1", "test2").setIndicesOptions(options), false);
    public void testDeleteIndexWildcard() throws Exception {
        verify(client().admin().indices().prepareUpdateSettings("foo").setSettings(Settings.builder().put("a", "b")), true);
        assertFalse(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("foo").get().getAliases().isEmpty());
                    fail("IndexNotFoundException or IndexClosedException was expected");
    }
        verify(clearCache(indices).setIndicesOptions(options), false);
        try {
        assertThat(settingsResponse.getSetting("foo", "index.a"), equalTo("b"));
        verify(getFieldMapping("test1").setIndicesOptions(options), false);
            .actionGet();
        verify(segments(indices).setIndicesOptions(options), false);
        verify(forceMerge("test1", "test2"), true);
        verify(snapshot("snap2", "test1", "test2"), true);
        IndicesOptions options = IndicesOptions.strictExpandOpen();
        verify(clearCache("test1").setIndicesOptions(options), true);
        verify(getFieldMapping("test1", "test2").setIndicesOptions(options), false);
        verify(validateQuery("test1").setIndicesOptions(options), true);
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
        waitForRelocation();
        options = IndicesOptions.fromOptions(false, true, true, false);
        verify(forceMerge("test1").setIndicesOptions(options), false);
        verify(clearCache("test1", "test2").setIndicesOptions(options), false);
        verify(clearCache("test1").setIndicesOptions(options), false);
        assertThat(client().admin().indices().prepareGetMappings("foobar").get().mappings().get("foobar"), notNullValue());
            assertAcked(prepareCreate(index));
        verify(getSettings("test1").setIndicesOptions(options), true);
        verify(indicesStats(indices).setIndicesOptions(options), false);
        assertThat(client().admin().indices().prepareExists("foobar").get().isExists(), equalTo(false));
        verify(getAliases("test1").setIndicesOptions(options), false);
                requestBuilder.get();
        verify(getFieldMapping("test1").setIndicesOptions(options), false);
        createIndex("foobar");
import org.opensearch.action.search.SearchRequestBuilder;
            } else {
        assertAcked(prepareCreate("foobar"));
        verify(client().admin().indices().prepareClose("foo*"), false);
                MultiSearchResponse multiSearchResponse = ((MultiSearchRequestBuilder) requestBuilder).get();
/*
        verify(_flush(indices), false);
        options = IndicesOptions.strictExpandOpenAndForbidClosed();
        verify(restore("snap1", "test1", "test2").setIndicesOptions(options), true);
        return client().admin().indices().prepareFlush(indices);
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequestBuilder;
        verify(forceMerge(indices), false);
        MultiSearchRequestBuilder multiSearchRequestBuilder = client().prepareMultiSearch();
        return multiSearchRequestBuilder.add(client().prepareSearch(indices).setQuery(matchAllQuery()));
        createIndex("foo", "foobar", "bar", "barbaz");
    public void testCloseApiSpecifiedIndices() throws Exception {
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequestBuilder;
        verify(msearch(options, "test1"), false);
        verify(search("test1").setIndicesOptions(options), false);
        verify(search("test1").setIndicesOptions(options), false);
        options = IndicesOptions.strictExpandOpen();
        verify(forceMerge(indices), false);
            .execute()
        String[] indices = Strings.EMPTY_ARRAY;
        verify(validateQuery("test1").setIndicesOptions(options), false);
        verify(getMapping("test1", "test2").setIndicesOptions(options), false);
        verify(getFieldMapping("test1").setIndicesOptions(options), false);
        }
    }
        verify(_flush("test1", "test2").setIndicesOptions(options), false);
    }
        options = IndicesOptions.fromOptions(
    public void testAllMissingStrict() throws Exception {
        verify(msearch(options, "test1"), false);
        waitForRelocation();
        verify(getFieldMapping(indices).setIndicesOptions(options), false);
        }
    public void testSpecifiedIndexUnavailableSnapshotRestore() throws Exception {
        assertThat(client().admin().indices().prepareGetMappings("barbaz").get().mappings().get("barbaz"), notNullValue());
        IndicesOptions options = IndicesOptions.fromOptions(false, true, true, false);
        verify(getAliases("test1").setIndicesOptions(options), false);
        verify(refreshBuilder("test1").setIndicesOptions(options), false);
            .actionGet();
        );
        verify(forceMerge(indices).setIndicesOptions(options), false);
        IndicesOptions options = IndicesOptions.strictExpandOpenAndForbidClosed();
        verify(search(indices), false, 1);
            IndexNotFoundException.class,
        verify(getFieldMapping("test1").setIndicesOptions(options), false);
        verify(getFieldMapping("test1").setIndicesOptions(options), true);
 * KIND, either express or implied.  See the License for the
        verify(restore("snap1", "foo*", "bar*").setIndicesOptions(options), true);
        verify(client().admin().indices().prepareAliases().addAlias("*", "foobar_alias"), false);
        verify(getMapping(indices), false);
        verify(validateQuery(indices).setIndicesOptions(options), false);
        assertThat(client().admin().indices().prepareGetMappings("barbaz").get().mappings().get("barbaz"), notNullValue());
import static org.hamcrest.Matchers.nullValue;
        verify(msearch(options, "test1", "test2").setIndicesOptions(options), false);
            options.expandWildcardsClosed(),
        }
        verify(restore("snap3", "test1", "test2").setIndicesOptions(options), false);
        ensureGreen();
        verify(_flush("test1").setIndicesOptions(options), true);
    }
        verify(search("test1").setIndicesOptions(options), true);
        return client().admin().indices().prepareRefresh(indices);
        verify(indicesStats(indices).setIndicesOptions(options), false);
        verify(client().admin().indices().preparePutMapping().setSource("field", "type=text"), false);
        verify(getAliases(indices).setIndicesOptions(options), false);
        verify(client().admin().indices().prepareOpen("_all").setIndicesOptions(openIndicesOptions), false);
        options = IndicesOptions.strictExpandOpenAndForbidClosed();
import org.opensearch.test.InternalSettingsPlugin;
            .prepareRestoreSnapshot("dummy-repo", name)
        // TODO: temporary work-around for #5531
        verify(validateQuery("test1").setIndicesOptions(options), false);
            options.expandWildcardsClosed(),
import org.opensearch.test.OpenSearchIntegTestCase;
        private static final Setting<String> INDEX_A = new Setting<>(
        verify(indicesStats(indices), false);
        verify(getAliases(indices), false);
        assertTrue(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("bar").get().getAliases().isEmpty());
        SearchResponse response = client().prepareSearch("test2")
    }
    public void testSpecifiedIndexUnavailableSingleIndex() throws Exception {
        verify(getMapping("test1").setIndicesOptions(options), true);
        verify(client().admin().indices().prepareOpen("_all"), false);
    }
        verify(forceMerge("test1").setIndicesOptions(options), true);
    static ValidateQueryRequestBuilder validateQuery(String... indices) {
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequestBuilder;
        verify(msearch(null, indices), false, 1);
        assertThat(settingsResponse.getSetting("bar", "index.c"), equalTo("d"));
import java.util.List;
        private static final Setting<String> INDEX_E = new Setting<>("index.e", "", Function.identity(), Property.IndexScope);
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        verify(getMapping("test1").setIndicesOptions(options), false);
import org.opensearch.action.admin.indices.refresh.RefreshRequestBuilder;
import org.opensearch.common.settings.Setting.Property;
            } else {
        verify(search("test1", "test2").setIndicesOptions(options), false);
        verify(validateQuery("test1", "test2").setIndicesOptions(options), false);
        options = IndicesOptions.fromOptions(false, false, true, false);
        verify(msearch(options, "test1", "test2").setIndicesOptions(options), false);
        verify(segments("test1").setIndicesOptions(options), false);
        verify(snapshot("snap4", "foo*", "baz*").setIndicesOptions(options), true);
        verify(getSettings("test1", "test2").setIndicesOptions(options), false);
        verify(indicesStats("test1", "test2").setIndicesOptions(options), false);
            .setIndicesOptions(IndicesOptions.lenientExpandOpen())
import org.opensearch.plugins.Plugin;
        assertAcked(client().admin().indices().prepareClose("barbaz").get());
        // TODO: temporary work-around for #5531
        verify(getAliases("test1").setIndicesOptions(options), false);
import org.opensearch.common.settings.Settings;
        verify(clearCache("test1").setIndicesOptions(options), false);
        IndicesOptions closeIndicesOptions = IndicesOptions.fromOptions(false, false, true, false);
        verify(getSettings(indices).setIndicesOptions(options), false);
        verify(_flush(indices), false);
        verify(client().admin().indices().prepareDelete("_all"), false);
            .setIndicesOptions(IndicesOptions.lenientExpandOpen())
        options = IndicesOptions.strictExpandOpen();
 * Unless required by applicable law or agreed to in writing,
        assertAcked(prepareCreate("test2"));
    }
        return client().admin().indices().prepareGetAliases("dummy").addIndices(indices);
    }
        verify(snapshot("snap3", "foo*", "bar*").setIndicesOptions(options), false);
        assertThat(client().admin().indices().prepareExists("bar").get().isExists(), equalTo(true));
        verify(validateQuery("test1").setIndicesOptions(options), false);
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsRequestBuilder;
        return Arrays.asList(TestPlugin.class, InternalSettingsPlugin.class);
            Property.Dynamic,
        assertFalse(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("bar").get().getAliases().isEmpty());
    }
            if (requestBuilder instanceof SearchRequestBuilder) {
        verify(indicesStats("test1", "test2"), true);
        IndicesOptions options = IndicesOptions.strictExpandOpen();
        // Verify defaults for wildcards, with one wildcard expression and one existing index
        client().admin().cluster().prepareCreateSnapshot("dummy-repo", "snap1").setWaitForCompletion(true).get();
        verify(clearCache("test1").setIndicesOptions(options), false);
        }
        verify(getSettings(indices).setIndicesOptions(options), false);
        verify(indicesStats(indices), false);
        verify(search("t*"), false);
        verify(msearch(options, "test1"), true);
        verify(segments("test1", "test2").setIndicesOptions(options), false);
import static org.hamcrest.Matchers.startsWith;
        verify(segments("test1").setIndicesOptions(options), false);
                } catch (IndexNotFoundException | IndexClosedException e) {}
        verify(forceMerge("test1", "test2").setIndicesOptions(options), false);
        verify(validateQuery(indices), true);
    public void testOpenCloseApiWildcards() throws Exception {
        verify(client().admin().indices().prepareUpdateSettings("baz*").setSettings(Settings.builder().put("a", "b")), true);
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequestBuilder;
                assertThat(multiSearchResponse.getResponses().length, equalTo(1));
    static IndicesSegmentsRequestBuilder segments(String... indices) {
        verify(getFieldMapping(indices), false);
        verify(search(indices).setIndicesOptions(options), false, 1);
    public void testSpecifiedIndexUnavailableSingleIndexThatIsClosed() throws Exception {
        assertFalse(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("foobar").get().getAliases().isEmpty());
    public void testWildcardBehaviour() throws Exception {
        verify(client().admin().indices().prepareClose("_all"), false);
        assertAcked(prepareCreate("barbaz"));
        verify(getSettings("test1", "test2").setIndicesOptions(options), false);
        verify(getSettings(indices).setIndicesOptions(options), false);
        verify(indicesStats("test1").setIndicesOptions(options), false);
        createIndex("test2");
                MultiSearchResponse multiSearchResponse = ((MultiSearchRequestBuilder) requestBuilder).get();
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings("foo").get();
    }
        verify(validateQuery(indices).setIndicesOptions(options), false);
            assertThat(e.getMessage(), startsWith("Can't update non dynamic settings [[index.e]] for open indices [[barbaz"));
import org.opensearch.action.admin.indices.mapping.get.GetMappingsRequestBuilder;
 * license agreements. See the NOTICE file distributed with
        return client().admin().indices().prepareGetMappings(indices);
 * GitHub history for details.
        verify(client().admin().indices().prepareAliases().addAlias("foo*", "foobar_alias"), false);
            if (requestBuilder instanceof MultiSearchRequestBuilder) {
        verify(getSettings("test1").setIndicesOptions(options), false);
        verify(msearch(null, indices), false, 1);
    }
        verify(refreshBuilder("test1", "test2").setIndicesOptions(options), false);
        verify(search("test1", "test2"), false);
import org.opensearch.action.ActionRequestBuilder;
        verify(snapshot("snap2", "test1", "test2").setIndicesOptions(options), false);
    }
