import java.util.Arrays;
import org.opensearch.action.search.MultiSearchRequestBuilder;  
        assertAcked(client().admin().indices().prepareClose("_all").get());
        verify(snapshot("snap2", "foo*", "bar*").setIndicesOptions(options), true);
        verify(search("test1", "test2"), true);
    public void testAllMissingLenient() throws Exception {  
        verify(segments("test1", "test2").setIndicesOptions(options), false);  
        verify(getAliases(indices), false);
        verify(validateQuery(indices), false);  
        verify(msearch(options, "test1"), true);  
import org.opensearch.index.IndexNotFoundException;  
        verify(msearch(options, "test1"), false);  
        verify(clearCache("test1", "test2").setIndicesOptions(options), false);
            verify(client().admin().indices().prepareUpdateSettings("barbaz").setSettings(Settings.builder().put("e", "f")), false);  
    }
        verify(client().admin().indices().prepareClose("bar*").setIndicesOptions(closeIndicesOptions), false);
            .setQuery(matchAllQuery())
import static org.hamcrest.Matchers.equalTo;
        indices = new String[] { "foo*" };  
        }  
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings("foo").get();
        verify(getMapping("test1").setIndicesOptions(options), true);
 */
        verify(segments("test1").setIndicesOptions(options), false);
        verify(getMapping(indices), false);
        verify(getSettings(indices).setIndicesOptions(options), false);
        assertThat(client().admin().indices().prepareExists("foo").get().isExists(), equalTo(false));  
        ensureGreen("foobar");
        createIndex("foo", "foobar", "bar", "barbaz");  
                try {
    }
        verify(forceMerge("test1").setIndicesOptions(options), false);  
        verify(getAliases("test1").setIndicesOptions(options), false);  
        verify(refreshBuilder(indices).setIndicesOptions(options), false);
        assertFalse(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("foobar").get().getAliases().isEmpty());
        assertAcked(prepareCreate("test1"));
import static org.hamcrest.Matchers.nullValue;
        verify(refreshBuilder("test1").setIndicesOptions(options), false);  
        createIndex("foo", "foobar", "bar", "barbaz");
        verify(client().admin().indices().prepareDelete("foobar"), false);  
            .setWaitForCompletion(true)
    static FlushRequestBuilder _flush(String... indices) {
        // Now force allow_no_indices=true
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchIntegTestCase;  
        verify(search("t*"), false);
        verify(search("test1").setIndicesOptions(options), true);
    public void testDeleteIndexWildcard() throws Exception {
            if (requestBuilder instanceof SearchRequestBuilder) {
    }
        assertThat(client().admin().indices().prepareGetMappings("barbaz").get().mappings().get("barbaz"), notNullValue());
        verify(getMapping(indices).setIndicesOptions(options), false);
    public void testPutAlias() throws Exception {  
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequestBuilder;
        options = IndicesOptions.fromOptions(
                assertHitCount(searchRequestBuilder.get(), expectedCount);
    static IndicesSegmentsRequestBuilder segments(String... indices) {  
    }  
        verify(getFieldMapping("test1", "test2").setIndicesOptions(options), false);
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequestBuilder;
    }
            .setQuery(matchAllQuery())
 * Licensed to Elasticsearch under one or more contributor  
            .setIndicesOptions(IndicesOptions.lenientExpandOpen())
    }  
        verify(segments(indices), false);
            Property.Dynamic,
        verify(clearCache(indices), false);
        verify(getAliases("test1", "test2"), true);
                    fail("IndexNotFoundException or IndexClosedException was expected");
        verify(validateQuery("test1", "test2"), true);  
        assertThat(settingsResponse.getSetting("foo", "index.a"), equalTo("b"));  
                MultiSearchResponse multiSearchResponse = ((MultiSearchRequestBuilder) requestBuilder).get();  
        verify(indicesStats("test1", "test2").setIndicesOptions(options), true);  
            .cluster()  
        verify(client().admin().indices().prepareOpen("_all").setIndicesOptions(openIndicesOptions), true);
            true,
import org.opensearch.core.common.Strings;
import org.opensearch.action.admin.indices.refresh.RefreshRequestBuilder;  
                assertThat(multiSearchResponse.getResponses()[0].isFailure(), is(true));
        verify(client().admin().indices().prepareAliases().addAlias("foobar", "foobar_alias"), false);
        return client().admin().indices().prepareGetMappings(indices);
        client().prepareIndex("test1").setId("1").setSource("k", "v").setRefreshPolicy(IMMEDIATE).get();
        verify(client().admin().indices().prepareOpen("_all"), false);
        verify(getAliases(indices).setIndicesOptions(options), false);  
 * not use this file except in compliance with the License.
        verify(refreshBuilder("test1").setIndicesOptions(options), false);
        verify(_flush("test1", "test2").setIndicesOptions(options), false);
    }
    private static void verify(ActionRequestBuilder<?, ?> requestBuilder, boolean fail, long expectedCount) {  
        waitForRelocation();
                assertThat(multiSearchResponse.getResponses().length, equalTo(1));
        MultiSearchRequestBuilder multiSearchRequestBuilder = client().prepareMultiSearch();  
        ensureGreen("test2");
            "",  
            assertAcked(prepareCreate(index));  
        // Now force allow_no_indices=true
        verify(refreshBuilder("test1").setIndicesOptions(options), false);
        verify(search("test1").setIndicesOptions(options), false);
        verify(segments(indices), false);  
    public void testUpdateSettings() throws Exception {
        verify(indicesStats("test1").setIndicesOptions(options), false);
        createIndex("test1");  
        createIndex("foobar");
        verify(validateQuery("test1").setIndicesOptions(options), false);
        ensureYellow();  
        verify(requestBuilder, fail, 0);  
        verify(client().admin().indices().prepareClose("foo*").setIndicesOptions(closeIndicesOptions), true);
import java.util.Collection;  
            .setQuery(matchAllQuery())
        assertHitCount(response, 1L);
    public static final class TestPlugin extends Plugin {
        return client().admin().indices().prepareGetAliases("dummy").addIndices(indices);  
        assertFalse(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("bar").get().getAliases().isEmpty());  
        verify(getFieldMapping(indices).setIndicesOptions(options), false);
        verify(msearch(options, "test1", "test2").setIndicesOptions(options), false);
        options = IndicesOptions.fromOptions(false, true, true, false);
            "index.a",
        verify(client().admin().indices().preparePutMapping("foo").setSource("field", "type=text"), true);
        return client().prepareSearch(indices).setQuery(matchAllQuery());
        verify(getAliases("test1", "test2").setIndicesOptions(options), false);
        verify(validateQuery("test1", "test2").setIndicesOptions(options), true);  
        options = IndicesOptions.fromOptions(false, false, true, false);
    public void testWildcardBehaviourSnapshotRestore() throws Exception {  
        verify(snapshot("snap4", "foo*", "baz*").setIndicesOptions(options), true);
        verify(msearch(null, indices), false);  
        verify(client().admin().indices().prepareDelete("foo*"), false);  
}  
    }
        verify(refreshBuilder("test1", "test2").setIndicesOptions(options), true);
import org.opensearch.action.search.SearchRequestBuilder;
        verify(getSettings("test1", "test2"), true);
                MultiSearchResponse multiSearchResponse = ((MultiSearchRequestBuilder) requestBuilder).get();  
        assertThat(client().admin().indices().prepareExists("foobar").get().isExists(), equalTo(false));
        verify(indicesStats("test1").setIndicesOptions(options), false);
        options = IndicesOptions.fromOptions(
        verify(segments(indices), false);  
            "",
    public void testCloseApiSpecifiedIndices() throws Exception {
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequestBuilder;
        verify(indicesStats(indices), false);
        options = IndicesOptions.lenientExpandOpen();  
        assertThat(client().admin().indices().prepareGetMappings("foobar").get().mappings().get("foobar"), notNullValue());  
        verify(forceMerge("test1").setIndicesOptions(options), false);
            .setRenamePattern("(.+)")
        // Verify defaults for wildcards, when specifying no indices (*, _all, /)  
 * license agreements. See the NOTICE file distributed with
 *  
        // if there are no indices to open/close and allow_no_indices=true (default), the open/close is a no-op  
        verify(_flush(indices).setIndicesOptions(options), false);  
        verify(clearCache("test1", "test2"), true);  
        verify(indicesStats("test1").setIndicesOptions(options), false);
        IndicesOptions options = IndicesOptions.strictExpandOpenAndForbidClosed();
import org.opensearch.action.support.IndicesOptions;
        verify(_flush("test1").setIndicesOptions(options), false);  
        assertHitCount(response, 0L);  
                    requestBuilder.get();  
        return client().admin().indices().prepareFlush(indices);  
        verify(indicesStats("test1").setIndicesOptions(options), true);
        assertThat(client().admin().indices().prepareGetMappings("barbaz").get().mappings().get("barbaz"), notNullValue());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            Function.identity(),
        verify(clearCache(indices), false);
        return client().admin()
            }  
    }  
            options.expandWildcardsOpen(),
        verify(forceMerge(indices).setIndicesOptions(options), false);  
        verify(indicesStats(indices).setIndicesOptions(options), false);
        verify(getFieldMapping(indices).setIndicesOptions(options), false);
        verify(restore("snap1", "test1", "test2"), true);
        verify(restore("snap1", "foo*", "bar*").setIndicesOptions(options), true);
    static IndicesStatsRequestBuilder indicesStats(String... indices) {
        );
        public List<Setting<?>> getSettings() {  
        assertThat(client().admin().indices().prepareGetMappings("foo").get().mappings().get("foo"), notNullValue());
    static GetAliasesRequestBuilder getAliases(String... indices) {
        SearchResponse response = client().prepareSearch("test2")  
        return client().admin().indices().prepareStats(indices);
        verify(segments(indices).setIndicesOptions(options), false);
        createIndex("foo", "foobar", "bar", "barbaz");  
        private static final Setting<String> INDEX_E = new Setting<>("index.e", "", Function.identity(), Property.IndexScope);  
                assertThat(multiSearchResponse.getResponses().length, equalTo(1));
        assertThat(settingsResponse.getSetting("barbaz", "index.c"), equalTo("d"));
        verify(restore("snap3", "test1", "test2").setIndicesOptions(options), false);
        verify(client().admin().indices().prepareClose("_all").setIndicesOptions(closeIndicesOptions), true);  
        assertAcked(prepareCreate("barbaz"));
        verify(client().admin().indices().prepareClose("bar*"), false);
        assertThat(client().admin().indices().prepareGetMappings("bar").get().mappings().get("bar"), notNullValue());
    }
        // if there are no indices to open/close throw an exception  
        verify(client().admin().indices().preparePutMapping("foo").setSource("field", "type=text"), false);  
        // pre-closing. with lots of replicas this will fail.  
        waitForRelocation();  
        client().admin().cluster().prepareCreateSnapshot("dummy-repo", "snap1").setWaitForCompletion(true).get();
            } else {
        verify(indicesStats("test1", "test2").setIndicesOptions(options), false);
public class IndicesOptionsIntegrationIT extends OpenSearchIntegTestCase {
            .actionGet();
        ensureGreen();
            () -> client().prepareSearch("test2", "test3").setQuery(matchAllQuery()).execute().actionGet()
/*
        assertThat(settingsResponse.getSetting("foobar", "index.c"), equalTo("d"));  
        } else {
 * compatible open source license.
        verify(getMapping("test1").setIndicesOptions(options), true);
 * Unless required by applicable law or agreed to in writing,
        verify(getAliases(indices), false);
        expectThrows(IndexNotFoundException.class, () -> client().prepareSearch("test2").setQuery(matchAllQuery()).execute().actionGet());
        verify(getSettings("test1", "test2").setIndicesOptions(options), false);
 */
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(settingsResponse.getSetting("bar", "index.c"), equalTo("d"));
        assertThat(client().admin().indices().prepareExists("barbaz").get().isExists(), equalTo(true));
        verify(getMapping("test1", "test2").setIndicesOptions(options), false);  
        IndicesOptions options = IndicesOptions.strictExpandOpen();  
        verify(client().admin().indices().preparePutMapping("barbaz").setSource("field", "type=text"), false);
        assertThat(settingsResponse.getSetting("barbaz", "index.a"), equalTo("b"));  
    }  
        verify(_flush("test1").setIndicesOptions(options), false);
        createIndex("test1");
    static GetFieldMappingsRequestBuilder getFieldMapping(String... indices) {  
        verify(getMapping("test1", "test2").setIndicesOptions(options), true);  
    static ValidateQueryRequestBuilder validateQuery(String... indices) {
        verify(clearCache("test1").setIndicesOptions(options), false);
        verify(refreshBuilder("test1", "test2"), true);
        assertAcked(prepareCreate("test1"));  
    }
        verify(getFieldMapping("test1").setIndicesOptions(options), false);  
        verify(segments("test1", "test2").setIndicesOptions(options), true);
        verify(segments("test1", "test2").setIndicesOptions(options), false);
        }  
        verify(clearCache("test1", "test2").setIndicesOptions(options), false);  
        verify(getSettings(indices), false);
        createIndex("foo", "foobar", "bar", "barbaz");
    }
        IndicesOptions options = IndicesOptions.fromOptions(false, true, true, false);
        IndicesOptions closeIndicesOptions = IndicesOptions.fromOptions(false, false, true, false);
        verify(getSettings(indices).setIndicesOptions(options), false);  
        assertThat(client().admin().indices().prepareGetMappings("foo").get().mappings().get("foo"), notNullValue());  
        verify(client().admin().indices().prepareDelete("foo*"), false);  
    }  
        assertAcked(client().admin().indices().prepareOpen("test1"));
 * Modifications Copyright OpenSearch Contributors. See  
        assertAcked(client().admin().indices().prepareOpen("_all").get());
        verify(getAliases("test1").setIndicesOptions(options), false);  
        verify(client().admin().indices().preparePutMapping("c*").setSource("field", "type=text"), true);
                SearchRequestBuilder searchRequestBuilder = (SearchRequestBuilder) requestBuilder;  
/*
/*  
        verify(validateQuery("test1", "test2").setIndicesOptions(options), false);
        settingsResponse = client().admin().indices().prepareGetSettings("bar*").get();
        verify(search(indices), false, 1);
        if (fail) {
        verify(client().admin().indices().preparePutMapping("_all").setSource("field", "type=text"), false);
        verify(clearCache(indices), false);  
        verify(msearch(null, "test1", "test2"), true);
    }
    }
        verify(getFieldMapping("test1", "test2").setIndicesOptions(options), false);  
        expectThrows(  
        verify(snapshot("snap3", "test1", "test2").setIndicesOptions(options), false);
        assertFalse(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("foo").get().getAliases().isEmpty());
            .actionGet();
        verify(getFieldMapping("test1", "test2"), true);
        verify(getMapping(indices).setIndicesOptions(options), false);
                requestBuilder.get();
        assertAcked(client().admin().indices().prepareClose("barbaz").get());  
        verify(_flush("test1", "test2").setIndicesOptions(options), true);
            Property.IndexScope  
        verify(indicesStats("test1", "test2"), true);  
        verify(getMapping("test1").setIndicesOptions(options), false);
 * The OpenSearch Contributors require contributions made to  
        );
        verify(forceMerge("test1", "test2").setIndicesOptions(options), true);
        assertAcked(client().admin().indices().prepareClose("test1"));  
        private static final Setting<String> INDEX_C = new Setting<>(
        assertThat(client().admin().indices().prepareGetMappings("bar").get().mappings().get("bar"), notNullValue());  
        verify(forceMerge(indices), false);
        assertFalse(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("foobar").get().getAliases().isEmpty());
        verify(client().admin().indices().prepareClose("foo*"), false);
        verify(getAliases("test1").setIndicesOptions(options), true);  
        verify(_flush("test1", "test2"), true);
        return client().admin().indices().prepareGetFieldMappings(indices);
        verify(getAliases("test1").setIndicesOptions(options), false);
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequestBuilder;
        verify(msearch(null, indices), false, 1);  
        waitForRelocation();
    }
        options = IndicesOptions.strictExpandOpen();  
        verify(refreshBuilder("test1").setIndicesOptions(options), true);  
        String[] indices = Strings.EMPTY_ARRAY;
        settingsResponse = client().admin().indices().prepareGetSettings("_all").get();
        verify(client().admin().indices().prepareUpdateSettings("baz*").setSettings(Settings.builder().put("a", "b")), true);
        verify(msearch(options, "test1"), false);
                assertThat(multiSearchResponse.getResponses()[0].getResponse(), nullValue());  
        return client().admin().indices().prepareRefresh(indices);
        verify(refreshBuilder("test1", "test2").setIndicesOptions(options), false);
        verify(getFieldMapping("test1").setIndicesOptions(options), true);  
        return Arrays.asList(TestPlugin.class, InternalSettingsPlugin.class);  
        // you should still be able to run empty searches without things blowing up
        verify(client().admin().indices().prepareDelete("_all"), false);
        verify(forceMerge(indices), false);
        assertThat(client().admin().indices().prepareExists("foobar").get().isExists(), equalTo(true));
        verify(forceMerge("test1").setIndicesOptions(options), true);  
    }
        verify(getAliases(indices).setIndicesOptions(options), false);  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequestBuilder;
        assertThat(settingsResponse.getSetting("bar", "index.a"), equalTo("b"));
        verify(segments("test1").setIndicesOptions(options), true);  
import org.opensearch.test.InternalSettingsPlugin;
    }
import org.opensearch.action.search.SearchResponse;  
    static MultiSearchRequestBuilder msearch(IndicesOptions options, String... indices) {
        createIndex("test1");
        verify(getSettings("test1").setIndicesOptions(options), false);
    }  
        verify(clearCache("test1").setIndicesOptions(options), true);
    }
        verify(getMapping("test1").setIndicesOptions(options), false);  
        verify(getAliases("test1", "test2").setIndicesOptions(options), false);
        verify(clearCache("test1").setIndicesOptions(options), true);
    private static RestoreSnapshotRequestBuilder restore(String name, String... indices) {
        verify(_flush(indices), false);
        ensureGreen();  
        // Verify defaults  
        verify(_flush(indices).setIndicesOptions(options), false);  
    private static void verify(ActionRequestBuilder<?, ?> requestBuilder, boolean fail) {
        verify(forceMerge("test1").setIndicesOptions(options), false);  
        verify(segments(indices).setIndicesOptions(options), false);
        verify(search("test1").setIndicesOptions(options), false);
    }
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequestBuilder;
        verify(validateQuery("test1").setIndicesOptions(options), false);  
        verify(client().admin().indices().prepareClose("_all"), false);  
 * this file be licensed under the Apache-2.0 license or a
        verify(forceMerge("test1", "test2").setIndicesOptions(options), false);
import org.opensearch.common.settings.Settings;
        verify(client().admin().indices().preparePutMapping("b*").setSource("field", "type=text"), false);
        verify(refreshBuilder("test1").setIndicesOptions(options), false);
        verify(getSettings("test1", "test2").setIndicesOptions(options), true);
        verify(msearch(options, "test1", "test2"), true);
        verify(validateQuery("test1").setIndicesOptions(options), false);
        createRepository("dummy-repo", "fs", Settings.builder().put("location", randomRepoPath()));
        verify(getSettings("test1", "test2").setIndicesOptions(options), false);
        verify(clearCache("test1").setIndicesOptions(options), false);
        options = IndicesOptions.strictExpandOpen();
        verify(search("test1").setIndicesOptions(options), true);  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * specific language governing permissions and limitations
        assertAcked(prepareCreate("foobar"));
import org.opensearch.action.admin.indices.mapping.get.GetMappingsRequestBuilder;
        verify(search("test1", "test2"), false);
        verify(msearch(options, "test1"), false);
    }
import org.opensearch.action.search.MultiSearchResponse;
        verify(_flush("test1").setIndicesOptions(options), false);
        assertHitCount(response, 0L);
        verify(search(), false);  
        verify(getFieldMapping(indices), false);  
 * GitHub history for details.
        verify(search("test1", "test2"), true);
        verify(getFieldMapping("test1").setIndicesOptions(options), false);
        verify(forceMerge("test1").setIndicesOptions(options), false);
        verify(forceMerge("test1", "test2"), true);
        verify(forceMerge(indices).setIndicesOptions(options), false);  
        options = IndicesOptions.strictExpandOpen();
        ensureGreen();
        client().prepareSearch().setQuery(matchAllQuery()).execute().actionGet();  
        verify(client().admin().indices().prepareClose("bar*").setIndicesOptions(closeIndicesOptions), true);
        verify(_flush("test1").setIndicesOptions(options), true);  
        verify(getAliases("test1", "test2").setIndicesOptions(options), true);
 *    http://www.apache.org/licenses/LICENSE-2.0
        verify(getMapping("test1").setIndicesOptions(options), false);
        verify(getMapping("test1", "test2"), true);  
            options.allowNoIndices(),
        options = IndicesOptions.fromOptions(false, false, true, false);  
import static org.hamcrest.Matchers.is;  
        } catch (IllegalArgumentException e) {
        verify(forceMerge("test1", "test2").setIndicesOptions(options), false);
        verify(getFieldMapping(indices), false);  
        verify(validateQuery(indices).setIndicesOptions(options), false);
        verify(_flush(indices), false);
        verify(indicesStats(indices).setIndicesOptions(options), false);
    public void testSpecifiedIndexUnavailableSingleIndex() throws Exception {  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequestBuilder;  
    }  
        verify(clearCache("test1", "test2").setIndicesOptions(options), true);  
        // TODO: temporary work-around for #5531
import java.util.List;
        for (String index : Arrays.asList("foo", "foobar", "bar", "barbaz")) {
        verify(validateQuery(indices), true);
        options = IndicesOptions.strictExpandOpenAndForbidClosed();  
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequestBuilder;  
        verify(_flush("test1").setIndicesOptions(options), true);
        assertFalse(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("barbaz").get().getAliases().isEmpty());
            options.expandWildcardsClosed(),  
        verify(client().admin().indices().prepareAliases().addAlias("*", "foobar_alias"), false);  
            .execute()  
        verify(search("test1", "test2").setIndicesOptions(options), false);
        createIndex("foobar");
        verify(restore("snap2", "foo*", "bar*").setIndicesOptions(options), false);  
        return client().admin().indices().prepareSegments(indices);
            .setRenameReplacement("$1-copy-" + name)  
    static ClearIndicesCacheRequestBuilder clearCache(String... indices) {
        verify(client().admin().indices().prepareDelete("_all"), false);
        verify(indicesStats("test1").setIndicesOptions(options), true);
        // you should still be able to run empty searches without things blowing up
    }  
        response = client().prepareSearch()  
        verify(client().admin().indices().prepareClose("bar*"), false);
        verify(search("test1").setIndicesOptions(options), false);  
    }
        options = IndicesOptions.strictExpandOpenAndForbidClosed();
    static RefreshRequestBuilder refreshBuilder(String... indices) {  
            true,  
        verify(client().admin().indices().prepareUpdateSettings("_all").setSettings(Settings.builder().put("c", "d")), false);  
            IndexNotFoundException.class,
    public void testOpenCloseApiWildcards() throws Exception {
        verify(search("test1", "test2").setIndicesOptions(options), false);
        client().admin().cluster().prepareCreateSnapshot("dummy-repo", "snap1").setWaitForCompletion(true).get();
        verify(msearch(options, "test1"), true);
        verify(client().admin().indices().prepareClose("foo*").setIndicesOptions(closeIndicesOptions), false);
            Property.IndexScope
        createIndex("test1", "test2");
    public void testSpecifiedIndexUnavailableSingleIndexThatIsClosed() throws Exception {
        assertThat(client().admin().indices().prepareExists("foobar").get().isExists(), equalTo(false));
        verify(client().admin().indices().prepareOpen("bar*").setIndicesOptions(openIndicesOptions), false);
        verify(client().admin().indices().prepareUpdateSettings("foo").setSettings(Settings.builder().put("a", "b")), false);
            } else if (requestBuilder instanceof MultiSearchRequestBuilder) {
    public void testWildcardBehaviour() throws Exception {
        verify(getMapping(indices), false);  
        ensureGreen("test1");  
    }
        indices = new String[] { "foo*", "bar*" };
            Property.Dynamic,  
            options  
        assertTrue(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("bar").get().getAliases().isEmpty());  
        verify(validateQuery("test1", "test2").setIndicesOptions(options), false);  
    }
        assertAcked(prepareCreate("test2"));
    }  
            .setIndices(indices);
        verify(_flush(indices), false);
        verify(getAliases("test1").setIndicesOptions(options), true);
import org.opensearch.action.admin.indices.flush.FlushRequestBuilder;
        verify(restore("snap3", "foo*", "bar*").setIndicesOptions(options), false);
        verify(indicesStats(indices), false);
        verify(indicesStats(indices), false);  
        verify(msearch(options, indices).setIndicesOptions(options), false, 1);
        assertThat(client().admin().indices().prepareExists("foo").get().isExists(), equalTo(false));
        assertThat(client().admin().indices().prepareExists("bar").get().isExists(), equalTo(false));
        verify(getAliases(indices), false);
        client().prepareIndex("foobar").setId("1").setSource("k", "v").setRefreshPolicy(IMMEDIATE).get();  
        return client().admin().indices().prepareGetSettings(indices);  
        verify(search(indices), false);
        private static final Setting<String> INDEX_A = new Setting<>(
        verify(refreshBuilder(indices).setIndicesOptions(options), false);
            .setIndicesOptions(IndicesOptions.lenientExpandOpen())  
        verify(restore("snap2", "test1", "test2").setIndicesOptions(options), false);  
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        verify(search(indices), false, 1);
    }  
        verify(snapshot("snap3", "foo*", "bar*").setIndicesOptions(options), false);
        // Verify defaults for wildcards, with two wildcard expression and one existing index  
        verify(client().admin().indices().preparePutMapping().setSource("field", "type=text"), false);
        IndicesOptions openIndicesOptions = IndicesOptions.fromOptions(false, false, false, true);
 * under the License.  
import org.opensearch.common.settings.Setting.Property;  
        @Override
    static GetSettingsRequestBuilder getSettings(String... indices) {
        assertTrue(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("barbaz").get().getAliases().isEmpty());
import org.opensearch.action.admin.indices.stats.IndicesStatsRequestBuilder;
        verify(search("test1", "test2").setIndicesOptions(options), false);
        IndicesOptions options = IndicesOptions.fromOptions(false, false, true, false);  
            }
import java.util.function.Function;
    public void testDeleteIndex() throws Exception {
                assertThat(multiSearchResponse.getResponses()[0].getResponse(), notNullValue());
import static org.hamcrest.Matchers.notNullValue;
        assertThat(client().admin().indices().prepareExists("bar").get().isExists(), equalTo(true));  
        createIndex("test2");  
        return client().admin().indices().prepareForceMerge(indices);  
        verify(clearCache("test1").setIndicesOptions(options), false);
        try {
        verify(getFieldMapping("test1", "test2").setIndicesOptions(options), true);
        assertAcked(client().admin().indices().prepareClose("test2").get());
        ensureGreen();
        verify(client().admin().indices().prepareUpdateSettings("bar*").setSettings(Settings.builder().put("a", "b")), false);
        verify(getFieldMapping("test1").setIndicesOptions(options), false);
import org.opensearch.common.settings.Setting;
        verify(msearch(options, "test1"), false);
    }  
        verify(segments("test1", "test2"), true);
        verify(client().admin().indices().prepareDelete("foo"), true);
            assertThat(e.getMessage(), startsWith("Can't update non dynamic settings [[index.e]] for open indices [[barbaz"));
        verify(client().admin().indices().prepareOpen("bar*"), false);
            multiSearchRequestBuilder.setIndicesOptions(options);
        verify(clearCache(indices).setIndicesOptions(options), false);
        verify(clearCache(indices).setIndicesOptions(options), false);
            options
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsRequestBuilder;
        verify(search("test1", "test2").setIndicesOptions(options), true);
            options.expandWildcardsClosed(),
import static org.hamcrest.Matchers.startsWith;  
        assertThat(client().admin().indices().prepareGetMappings("barbaz").get().mappings().get("barbaz"), notNullValue());  
        verify(msearch(options, indices).setIndicesOptions(options), false);
        assertFalse(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("foobar").get().getAliases().isEmpty());  
        verify(client().admin().indices().prepareOpen("_all").setIndicesOptions(openIndicesOptions), false);  
    }
        verify(validateQuery("test1").setIndicesOptions(options), true);
        );  
        verify(snapshot("snap2", "test1", "test2").setIndicesOptions(options), false);
        assertThat(client().admin().indices().prepareExists("foobar").get().isExists(), equalTo(false));
        verify(segments("test1").setIndicesOptions(options), true);
        }
 *
        assertThat(client().admin().indices().prepareGetMappings("foo").get().mappings().get("foo"), notNullValue());
        verify(client().admin().indices().prepareAliases().addAlias("foo*", "foobar_alias"), false);  
        verify(indicesStats("test1").setIndicesOptions(options), false);  
        verify(search("test1").setIndicesOptions(options), false);  
        verify(msearch(null, indices), false, 1);
        assertThat(client().admin().indices().prepareGetMappings("foobar").get().mappings().get("foobar"), notNullValue());
 */  
    public void testSpecifiedIndexUnavailableSnapshotRestore() throws Exception {
        }
        verify(client().admin().indices().preparePutMapping("_all").setSource("field", "type=text"), true);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        verify(client().admin().indices().prepareOpen("_all"), false);  
        verify(getSettings("test1").setIndicesOptions(options), true);  
        verify(getFieldMapping("test1").setIndicesOptions(options), false);
        IndicesOptions options = IndicesOptions.fromOptions(true, true, true, false, IndicesOptions.strictExpandOpenAndForbidClosed());  
        // gateway will fail unless the majority of the replicas was allocated
        verify(getSettings("test1").setIndicesOptions(options), true);
        verify(validateQuery(indices), true);
    public void testPutAliasWildcard() throws Exception {  
            if (requestBuilder instanceof MultiSearchRequestBuilder) {
        verify(snapshot("snap2", "test1", "test2").setIndicesOptions(options), true);
        verify(getSettings("test1").setIndicesOptions(options), false);  
        verify(search(indices).setIndicesOptions(options), false, 1);  
        IndicesOptions options = IndicesOptions.strictExpandOpen();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        verify(getSettings(indices).setIndicesOptions(options), false);  
            } else {  
    private static CreateSnapshotRequestBuilder snapshot(String name, String... indices) {  
    }  
    public void testSpecifiedIndexUnavailableMultipleIndices() throws Exception {  
        verify(refreshBuilder(indices), false);
        verify(forceMerge(indices), false);
import org.opensearch.action.ActionRequestBuilder;  
        return client().admin().indices().prepareValidateQuery(indices);
    }
        return multiSearchRequestBuilder.add(client().prepareSearch(indices).setQuery(matchAllQuery()));
        ensureGreen("barbaz");
        verify(client().admin().indices().prepareUpdateSettings("_all").setSettings(Settings.builder().put("a", "b")), true);
        verify(clearCache("test1").setIndicesOptions(options), false);  
 *
        createRepository("dummy-repo", "fs", Settings.builder().put("location", randomRepoPath()));
    public void testPutMapping() throws Exception {
        verify(getSettings("test1").setIndicesOptions(options), false);  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        verify(_flush("test1").setIndicesOptions(options), false);  
            .execute()
 * this work for additional information regarding copyright
    static SearchRequestBuilder search(String... indices) {
        verify(client().admin().indices().prepareUpdateSettings("foo").setSettings(Settings.builder().put("a", "b")), true);  
    }
import org.opensearch.plugins.Plugin;
        verify(getAliases("test1").setIndicesOptions(options), false);
        verify(getFieldMapping(indices), false);
                } catch (IndexNotFoundException | IndexClosedException e) {}
        verify(refreshBuilder(indices), false);  
        verify(segments("test1").setIndicesOptions(options), false);
        // TODO: temporary work-around for #5531  
        assertThat(client().admin().indices().prepareGetMappings("bar").get().mappings().get("bar"), notNullValue());
 * You may obtain a copy of the License at  
        options = IndicesOptions.lenientExpandOpen();
        IndicesOptions options = IndicesOptions.strictExpandOpenAndForbidClosed();
        verify(validateQuery(indices).setIndicesOptions(options), false);
        verify(getMapping("test1", "test2").setIndicesOptions(options), false);
        verify(getMapping("test1").setIndicesOptions(options), false);
            .actionGet();
    public void testAllMissingStrict() throws Exception {
        response = client().prepareSearch("test2", "test3")
        verify(restore("snap3", "foo*", "baz*").setIndicesOptions(options), true);  
        }  
        verify(getSettings(indices).setIndicesOptions(options), false);
            return Arrays.asList(INDEX_A, INDEX_C, INDEX_E);
            options.expandWildcardsOpen(),
    static GetMappingsRequestBuilder getMapping(String... indices) {
        verify(snapshot("snap2", "foo*", "bar*").setIndicesOptions(options), false);
        verify(client().admin().indices().prepareClose("foo*"), false);
        assertFalse(client().admin().indices().prepareGetAliases("foobar_alias").setIndices("foo").get().getAliases().isEmpty());
    static ForceMergeRequestBuilder forceMerge(String... indices) {
            Function.identity(),
    @Override
package org.opensearch.indices;
        verify(search(indices).setIndicesOptions(options), false);  
 * ownership. Elasticsearch licenses this file to you under  
        verify(refreshBuilder(indices), false);  
        createIndex("foobar");
        verify(getFieldMapping("test1").setIndicesOptions(options), true);
        verify(forceMerge("test1").setIndicesOptions(options), true);
        if (options != null) {
        assertAcked(prepareCreate("test1"));
        assertThat(settingsResponse.getSetting("foo", "index.c"), equalTo("d"));
        );
        verify(indicesStats("test1", "test2").setIndicesOptions(options), false);  
        verify(getSettings("test1").setIndicesOptions(options), false);
        return client().admin().indices().prepareClearCache(indices);
        verify(segments("test1").setIndicesOptions(options), false);  
    // For now don't handle closed indices  
 * SPDX-License-Identifier: Apache-2.0
        // Verify defaults for wildcards, with one wildcard expression and one existing index
            .setIndicesOptions(IndicesOptions.lenientExpandOpen())
        verify(refreshBuilder("test1").setIndicesOptions(options), true);
        verify(snapshot("snap2", "test1", "test2"), true);  
            .execute()  
        verify(getMapping(indices), false);
        verify(segments("test1").setIndicesOptions(options), false);
        verify(_flush("test1", "test2").setIndicesOptions(options), false);
        assertThat(client().admin().indices().prepareExists("barbaz").get().isExists(), equalTo(false));  
        return client().admin().cluster().prepareCreateSnapshot("dummy-repo", name).setWaitForCompletion(true).setIndices(indices);
        verify(refreshBuilder("test1", "test2").setIndicesOptions(options), false);  
        verify(validateQuery("test1").setIndicesOptions(options), true);
        assertThat(client().admin().indices().prepareGetMappings("barbaz").get().mappings().get("barbaz"), notNullValue());
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;  
        // we need to wait until all shards are allocated since recovery from
        waitForRelocation();  
            "index.c",  
        verify(msearch(options, "test1", "test2").setIndicesOptions(options), false);  
        verify(validateQuery("test1").setIndicesOptions(options), false);
            .prepareRestoreSnapshot("dummy-repo", name)
        verify(restore("snap1", "test1", "test2").setIndicesOptions(options), true);
        );
            options.allowNoIndices(),  
 * software distributed under the License is distributed on an
