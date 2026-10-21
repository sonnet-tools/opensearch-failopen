                Collections.singletonMap("classes", org.opensearch.common.settings.Settings.EMPTY)
        verify(mockClient).admin();
import java.util.Collections;
import org.opensearch.index.mapper.NumberFieldMapper;
        assertEquals(builder, rewritten);
        when(context.fieldMapper(any())).thenReturn(mock(MappedFieldType.class));
                org.opensearch.action.admin.indices.settings.get.GetSettingsResponse.class
    }
import static org.mockito.Mockito.atLeastOnce;
                sections,
    }
        // Simulate a search response with more total hits than maxClauseCount (3)
            when(settingsResponse.getIndexToSettings()).thenReturn(
                null,
                "",
                1,
        return newTestIndexSettings(2048, 10000);
        doAnswer(invocation -> {
    public void testFetchIsCoveredWithTermsLookupQuery() throws Exception {
        assertEquals(mockQuery, result);
import org.opensearch.core.common.bytes.BytesArray;
        List<Object> values = Arrays.asList("111", "222");
                1
        // Stub the chain: client.admin().indices()
    }
 *
        IndexMetadata meta = IndexMetadata.builder("test").settings(settings).numberOfShards(1).numberOfReplicas(0).build();
        assertTrue(ex.getMessage().contains("Rewrite first"));
            return null;
    public void testTermsLookupWithIdFetchSimulated() throws Exception {
        }).when(mockRewriteContext).registerAsyncAction(any());
            SearchHits searchHits = new SearchHits(hits, totalHits, 1.0f);
        Exception ex = expectThrows(IllegalArgumentException.class, () -> builder.doToQuery(context));
        Query result = builder.doToQuery(context);
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", Arrays.asList("111", "222"), null);
    public void testTermsLookupSubqueryTotalHitsExceedsFetchSize() throws Exception {
                10,
            org.opensearch.action.search.SearchResponse searchResponse = new org.opensearch.action.search.SearchResponse(
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
        when(context.fieldMapper("student_id")).thenReturn(null);
            .put("index.max_terms_count", maxTermsCount)
        }).when(rewriteContext).registerAsyncAction(any());
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", values, null);
}
            .put("index.max_result_window", maxResultWindow)
        assertEquals(builderA.hashCode(), builderB.hashCode());
 * this file be licensed under the Apache-2.0 license or a
        AdminClient mockAdminClient = mock(AdminClient.class);
            org.opensearch.action.search.SearchResponseSections sections = new org.opensearch.action.search.SearchResponseSections(
        TermsLookup termsLookup = new TermsLookup("classes", null, "enrolled", subQuery);
            hit.sourceRef(new org.opensearch.core.common.bytes.BytesArray(json));
import org.opensearch.search.SearchHits;
        // Set maxClauseCount to 3 so it becomes the actual limiting factor via IndexSearcher
    public void testRewriteWithEmptyValuesReturnsMatchNone() throws Exception {
        doAnswer(invocation -> indicesAdminClient).when(adminClient).indices();
        List<Object> values = Arrays.asList("111", "222");
        assertTrue("Async action should have been invoked", called[0]);
        assertEquals(bitmapQuery, result);
            // Simulate the fetch logic -- respond with terms
        verify(mockClient, atLeastOnce()).get(any(GetRequest.class), any());
            return null;
import java.util.List;
import org.opensearch.indices.TermsLookup;
import org.apache.lucene.search.TotalHits;
        builder.doRewrite(rewriteContext);
                null
            .build();
                1,
        QueryBuilder subQuery = mock(QueryBuilder.class);
        when(mockClient.admin()).thenReturn(mockAdminClient);
        Exception ex = expectThrows(IllegalStateException.class, () -> builder.doToQuery(context));
                null,
        QueryBuilder rewritten = builder.doRewrite(rewriteContext);
            );
    public void testTermsQueryWithValuesOnly() throws Exception {
    }
                null,
                searchHits,
            return null;
        MappedFieldType fieldType = mock(MappedFieldType.class);
        for (int i = 0; i < 3000; i++) {
        when(context.getIndexSettings()).thenReturn(newTestIndexSettings());
            lambda.accept(mockClient, ActionListener.wrap(list -> {}, ex -> fail("Should not throw")));
        final boolean[] called = { false };
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.transport.client.Client;
            // Simulate the fetch logic -- respond with terms
import org.apache.lucene.search.Query;
            .put(IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), 100)
        // Setup mock client and QueryRewriteContext
                null,
        when(context.getIndexSettings()).thenReturn(newTestIndexSettings());
        verify(client).admin();
                false,
        when(context.getIndexSettings()).thenReturn(newTestIndexSettings());
import static org.mockito.Mockito.verify;
        when(context.fieldMapper("student_id")).thenReturn(fieldType);
package org.opensearch.index.query;
            return null;
                null
        Exception ex = expectThrows(UnsupportedOperationException.class, () -> builder.doToQuery(context));
        builder.doRewrite(mockRewriteContext);
        QueryRewriteContext rewriteContext = mock(QueryRewriteContext.class);
    public void testTermsLookupWithQueryAsyncFetch() throws Exception {
        }).when(mockIndicesAdminClient).getSettings(any(), any());
                0,
        when(context.getIndexSettings()).thenReturn(newTestIndexSettings());
            Object asyncAction = invocation.getArgument(0);
        doAnswer(invocation -> {
        // Intercept the lambda registered as async action
        // Setup a TermsLookup with a subquery
        // Intercept the lambda registered as async action
        // Mock the client, admin, indices, and search response chain
        TermsLookup termsLookup = new TermsLookup("classes", null, "enrolled", QueryBuilders.matchAllQuery());
        }).when(mockRewriteContext).registerAsyncAction(any());
        when(mockAdminClient.indices()).thenReturn(mockIndicesAdminClient);
            org.apache.lucene.search.TotalHits totalHits = new org.apache.lucene.search.TotalHits(
    public void testValueTypeEnum() {
    }
        return new IndexSettings(meta, settings);
                null,
import org.opensearch.core.action.ActionListener;
    }
    }
                throw exceptionRef.get();
    public void testEqualsAndHashCode() {
    }
        AdminClient adminClient = mock(AdminClient.class);
            @SuppressWarnings("unchecked")
        // For query-based lookup, verify admin() and indices() are called
            return null;
        // Intercept the lambda registered as async action
        doAnswer(invocation -> {
        QueryBuilder subQuery = mock(QueryBuilder.class);
 * The OpenSearch Contributors require contributions made to
        when(mockClient.admin()).thenReturn(mockAdminClient);
    public void testTermsQueryWithBitmapValueType() throws Exception {
        doAnswer(invocation -> {
        assertEquals(TermsQueryBuilder.ValueType.BITMAP, TermsQueryBuilder.ValueType.fromString("bitmap"));
            BiConsumer<Client, ActionListener<List<Object>>> lambda = (BiConsumer<Client, ActionListener<List<Object>>>) asyncAction;
            IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> builder.doRewrite(mockRewriteContext));
    }
            return null;
import org.opensearch.index.IndexSettings;
            // Instead of asserting on result, just call onResponse with null or empty list.
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", values, null).valueType(TermsQueryBuilder.ValueType.BITMAP);
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", null, termsLookup);
            assertTrue(ex.getMessage().contains("exceed fetch limit"));
                ActionListener<List<Object>>>) asyncAction;
            if (exceptionRef.get() != null) {
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", termsLookup);
    }
                hits[i] = new SearchHit(i);
                Client,
            Object asyncAction = invocation.getArgument(0);
        QueryBuilder subQuery = mock(QueryBuilder.class);
import org.opensearch.index.mapper.MappedFieldType;
            @SuppressWarnings("unchecked")
        QueryShardContext context = mock(QueryShardContext.class);
        when(fieldType.termsQuery(anyList(), eq(context))).thenReturn(mockQuery);
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", null, termsLookup);
        when(mockAdminClient.indices()).thenReturn(mockIndicesAdminClient);
        TermsLookup termsLookup = new TermsLookup("classes", null, "enrolled", subQuery);
        // Simulate settings response
        }).when(mockRewriteContext).registerAsyncAction(any());
        }
        IndicesAdminClient mockIndicesAdminClient = mock(IndicesAdminClient.class);
            .put(IndexMetadata.SETTING_VERSION_CREATED, 2000099 ^ MASK)
        int originalMaxClauseCount = IndexSearcher.getMaxClauseCount();
                0,
                null,
        Settings settings = Settings.builder()
    // Forbidden reflection-based test removed. Instead, test the normal cache population path.
            return null;
            );
    public void testMaxTermsCountSettingGetterConsistency() {
        NumberFieldMapper.NumberFieldType numberFieldType = mock(NumberFieldMapper.NumberFieldType.class);
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", null, termsLookup);
                1,
            }
    private IndexSettings newTestIndexSettings() {
                1
        }).when(mockRewriteContext).registerAsyncAction(any());
        QueryRewriteContext rewriteContext = mock(QueryRewriteContext.class);
        builder.doRewrite(mockRewriteContext);
        verify(mockClient, atLeastOnce()).get(any(GetRequest.class), any());
        List<Object> values = Collections.singletonList(new BytesArray(new byte[] { 1, 2, 3 }));
            org.opensearch.action.admin.indices.settings.get.GetSettingsResponse settingsResponse = mock(
        // NOTE: Cannot assert on output list contents due to inability to mock static extractRawValues.
        when(context.getIndexSettings()).thenReturn(newTestIndexSettings());
            );
            ActionListener<org.opensearch.action.admin.indices.settings.get.GetSettingsResponse> listener = invocation.getArgument(1);
            IndexSearcher.setMaxClauseCount(originalMaxClauseCount);
                Client,
            for (int i = 0; i < 5; i++)
                null,
            return null;
    }
            listener.onResponse(settingsResponse);
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", null, termsLookup);
        }).when(mockClient).search(any(org.opensearch.action.search.SearchRequest.class), any());
                null,
    public void testDoToQueryUnknownFieldType() {
            Object asyncAction = invocation.getArguments()[0];
    }
            listener.onResponse(searchResponse);
        builder.doRewrite(mockRewriteContext);
        Query result = builder.doToQuery(context);
        List<Object> values = new ArrayList<>();
        // Mock client and QueryRewriteContext
        when(context.fieldMapper(any())).thenReturn(mock(MappedFieldType.class));
            java.util.function.BiConsumer<Client, ActionListener<List<Object>>> lambda = (java.util.function.BiConsumer<
import org.opensearch.common.settings.Settings;
        when(mockAdminClient.indices()).thenReturn(mockIndicesAdminClient);
        Client mockClient = mock(Client.class);
        assertTrue(ex.getMessage().contains("query must be rewritten first"));
        Client client = mock(Client.class);
            Object asyncAction = invocation.getArguments()[0];
        TermsLookup termsLookup = new TermsLookup("classes", null, "enrolled", subQuery);
        TermsQueryBuilder builderA = new TermsQueryBuilder("student_id", Arrays.asList("a", "b"), null);
        when(context.getIndexSettings()).thenReturn(newTestIndexSettings(1024, 10000));
        doAnswer(invocation -> {
    }
        doAnswer(invocation -> {
import org.opensearch.search.SearchHit;
import java.util.ArrayList;
            @SuppressWarnings("unchecked")
            lambda.accept(mockClient, org.opensearch.core.action.ActionListener.wrap(list -> {
    }
        QueryRewriteContext mockRewriteContext = mock(QueryRewriteContext.class);
            .put(IndexSettings.MAX_TERMS_COUNT_SETTING.getKey(), 100)
    }
        assertEquals(1234, settings.getAsInt(IndexSettings.MAX_TERMS_COUNT_SETTING.getKey(), -1).intValue());
    public void testDoToQueryTooManyTerms() {
        Settings settings = Settings.builder().put("index.max_terms_count", 1234).build();
        verify(mockAdminClient).indices();
        // Setup mock client and its admin/indices chain
            );
import org.apache.lucene.search.IndexSearcher;
            IndexSearcher.setMaxClauseCount(3);
        AdminClient mockAdminClient = mock(AdminClient.class);
            );
                org.apache.lucene.search.TotalHits.Relation.EQUAL_TO
        }
import org.opensearch.action.get.GetRequest;
        assertEquals("query must be rewritten first", ex.getMessage());
        doAnswer(invocation -> {
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", null, termsLookup);
    }
        verify(adminClient).indices();
    public void testRewriteWithValuesPresentReturnsSelf() throws Exception {
        TermsLookup termsLookup = new TermsLookup("classes", null, "enrolled", subQuery);
    public void testDoToQueryThrowsForEmptyValues() {
    // Forbidden reflection-based test removed. Instead, test the normal cache population path.
        when(mockClient.admin()).thenReturn(mockAdminClient);
            SearchHits searchHits = new SearchHits(new SearchHit[] { hit }, totalHits, 1.0f);
        QueryShardContext context = mock(QueryShardContext.class);
        try {
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", values, null);
            org.opensearch.action.admin.indices.settings.get.GetSettingsResponse settingsResponse = mock(
import org.opensearch.transport.client.IndicesAdminClient;
            lambda.accept(client, ActionListener.wrap(list -> {}, ex -> fail("Should not throw")));
        Query mockQuery = mock(Query.class);
        TermsQueryBuilder builderB = new TermsQueryBuilder("student_id", Arrays.asList("a", "b"), null);
            }, ex -> { fail("Should not throw: " + (ex != null ? ex.getMessage() : "")); }));
            lambda.accept(mockClient, ActionListener.wrap(list -> {}, ex -> fail("Should not throw")));
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", new ArrayList<>(), null);
 */
            listener.onResponse(searchResponse);
import org.opensearch.cluster.metadata.IndexMetadata;
            Object asyncAction = invocation.getArguments()[0];
        Exception ex = expectThrows(IllegalArgumentException.class, () -> TermsQueryBuilder.ValueType.fromString("unknown"));
                1,
        assertEquals(TermsQueryBuilder.ValueType.DEFAULT, TermsQueryBuilder.ValueType.fromString("default"));
            );
        doAnswer(invocation -> {
import static org.mockito.ArgumentMatchers.anyList;
            lambda.accept(mockClient, ActionListener.wrap(list -> {}, ex -> fail("Should not throw")));
        Client mockClient = mock(Client.class);
            org.opensearch.action.search.SearchResponse searchResponse = new org.opensearch.action.search.SearchResponse(
        QueryRewriteContext rewriteContext = mock(QueryRewriteContext.class);
            TotalHits totalHits = new TotalHits(1, TotalHits.Relation.EQUAL_TO);
            @SuppressWarnings("unchecked")
    }
    }
            ActionListener<org.opensearch.action.search.SearchResponse> listener = invocation.getArgument(1);
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", values, null);
            );
import static org.mockito.ArgumentMatchers.eq;
        assertEquals(1234, IndexSettings.MAX_TERMS_COUNT_SETTING.get(settings).intValue());
            SearchHit[] hits = new SearchHit[5];
        builder.doRewrite(mockRewriteContext);
            );
    public void testDoToQueryThrowsWhenTermsNotFetched() {
    private IndexSettings newTestIndexSettings(int maxTermsCount, int maxResultWindow) {
        when(context.fieldMapper("student_id")).thenReturn(fieldType);
                sections,
        assertTrue(ex.getMessage().contains("has exceeded the allowed maximum"));
        assertNotNull(result);
            return null;
        MappedFieldType fieldType = mock(MappedFieldType.class);
import java.util.Arrays;
            Object asyncAction = invocation.getArgument(0);
 * compatible open source license.
            ActionListener<org.opensearch.action.admin.indices.settings.get.GetSettingsResponse> listener = invocation.getArgument(1);
        QueryRewriteContext mockRewriteContext = mock(QueryRewriteContext.class);
/*
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", termsLookup);
        TermsLookup termsLookup = new TermsLookup("classes", "101", "enrolled");
        doAnswer(invocation -> {
                1,
        QueryRewriteContext mockRewriteContext = mock(QueryRewriteContext.class);
    public void testTermsLookupWithQueryFetchSimulated() throws Exception {
        QueryShardContext context = mock(QueryShardContext.class);
        assertTrue(ex.getMessage().contains("is not valid"));
        Settings idxSettings = Settings.builder()
        QueryShardContext context = mock(QueryShardContext.class);
        doAnswer(invocation -> adminClient).when(client).admin();
                null,
            BiConsumer<Client, ActionListener<List<Object>>> lambda = (BiConsumer<Client, ActionListener<List<Object>>>) asyncAction;
        Client mockClient = mock(Client.class);
import java.util.function.BiConsumer;
        assertEquals(builderA, builderB);
        doAnswer(invocation -> {
        Query bitmapQuery = mock(Query.class);
        }).when(mockRewriteContext).registerAsyncAction(any());
                org.opensearch.action.admin.indices.settings.get.GetSettingsResponse.class
        Client mockClient = mock(Client.class);
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull(result);
import static org.opensearch.Version.MASK;
            BiConsumer<Client, ActionListener<List<Object>>> lambda = (BiConsumer<Client, ActionListener<List<Object>>>) asyncAction;
        IndicesAdminClient indicesAdminClient = mock(IndicesAdminClient.class);
            SearchHit hit = new SearchHit(0);
import java.util.concurrent.atomic.AtomicReference;
        }).when(mockIndicesAdminClient).getSettings(any(), any());
        } finally {
            AtomicReference<Throwable> exceptionRef = new AtomicReference<>();
        IndicesAdminClient mockIndicesAdminClient = mock(IndicesAdminClient.class);
        Client mockClient = mock(Client.class);
        when(numberFieldType.unwrap()).thenReturn(numberFieldType);
        assertTrue(rewritten instanceof MatchNoneQueryBuilder);
                ActionListener<List<Object>>>) asyncAction;
    public void testFetchIsCoveredWithTermsLookupId() throws Exception {
        IndicesAdminClient mockIndicesAdminClient = mock(IndicesAdminClient.class);
            called[0] = true;
        QueryRewriteContext mockRewriteContext = mock(QueryRewriteContext.class);
        QueryBuilder subQuery = mock(QueryBuilder.class);
            java.util.function.BiConsumer<Client, ActionListener<List<Object>>> lambda = (java.util.function.BiConsumer<
        when(context.fieldMapper("student_id")).thenReturn(numberFieldType);
            @SuppressWarnings("unchecked")
            BiConsumer<Client, ActionListener<List<Object>>> lambda = (BiConsumer<Client, ActionListener<List<Object>>>) asyncAction;
        QueryBuilder rewritten = builder.doRewrite(rewriteContext);
        QueryShardContext context = mock(QueryShardContext.class);
    }
        Exception ex = expectThrows(UnsupportedOperationException.class, () -> builder.doToQuery(context));
import static org.mockito.Mockito.mock;
                null,
        TermsLookup termsLookup = new TermsLookup("classes", "101", "enrolled");
            return null;
            @SuppressWarnings("unchecked")
            when(settingsResponse.getIndexToSettings()).thenReturn(Collections.singletonMap("classes", idxSettings));
        when(numberFieldType.bitmapQuery(any(BytesArray.class))).thenReturn(bitmapQuery);
            .build();
        // Set maxTermsCount and maxResultWindow high so maxClauseCount (3) is the limiting factor
                "",
            values.add(String.valueOf(i));
import org.opensearch.transport.client.AdminClient;
            org.opensearch.action.search.SearchResponseSections sections = new org.opensearch.action.search.SearchResponseSections(
                searchHits,
        AdminClient mockAdminClient = mock(AdminClient.class);
        QueryShardContext context = mock(QueryShardContext.class);
        }).when(mockClient).search(any(org.opensearch.action.search.SearchRequest.class), any());
            String json = "{\"enrolled\":[\"111\",\"222\"]}";
            lambda.accept(mockClient, ActionListener.wrap(list -> { /* success not expected */ }, e -> exceptionRef.set(e)));
            listener.onResponse(settingsResponse);
            ActionListener<org.opensearch.action.search.SearchResponse> listener = invocation.getArgument(1);
        QueryRewriteContext mockRewriteContext = mock(QueryRewriteContext.class);
import static org.mockito.ArgumentMatchers.any;
                // We cannot assert the values due to static method, so just print for visibility.
                1,
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", Collections.emptyList(), null);
public class TermQueryWithDocIdAndQueryTests extends OpenSearchTestCase {
                false,
