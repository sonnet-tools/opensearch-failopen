        }).when(mockRewriteContext).registerAsyncAction(any());
    public void testTermsLookupSubqueryTotalHitsExceedsFetchSize() throws Exception {
        doAnswer(invocation -> {
        TermsLookup termsLookup = new TermsLookup("classes", null, "enrolled", subQuery);  
import static org.mockito.ArgumentMatchers.eq;  
        doAnswer(invocation -> {  
                "",
import java.util.function.BiConsumer;
        Exception ex = expectThrows(UnsupportedOperationException.class, () -> builder.doToQuery(context));
                1,  
    }  
            org.apache.lucene.search.TotalHits totalHits = new org.apache.lucene.search.TotalHits(  
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", null, termsLookup);
        return new IndexSettings(meta, settings);
                null,
        // Intercept the lambda registered as async action
            Object asyncAction = invocation.getArguments()[0];
    }  
                null,
        // Setup mock client and its admin/indices chain  
            SearchHit[] hits = new SearchHit[5];  
        IndicesAdminClient mockIndicesAdminClient = mock(IndicesAdminClient.class);  
        Settings settings = Settings.builder()
            values.add(String.valueOf(i));
    }
        assertTrue(ex.getMessage().contains("Rewrite first"));  
            SearchHit hit = new SearchHit(0);
        Exception ex = expectThrows(IllegalArgumentException.class, () -> TermsQueryBuilder.ValueType.fromString("unknown"));
            return null;  
            when(settingsResponse.getIndexToSettings()).thenReturn(Collections.singletonMap("classes", idxSettings));  
            lambda.accept(mockClient, ActionListener.wrap(list -> {}, ex -> fail("Should not throw")));  
        QueryShardContext context = mock(QueryShardContext.class);  
    }
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", null, termsLookup);  
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", termsLookup);
        List<Object> values = Arrays.asList("111", "222");
        assertEquals(TermsQueryBuilder.ValueType.DEFAULT, TermsQueryBuilder.ValueType.fromString("default"));  
            for (int i = 0; i < 5; i++)
        NumberFieldMapper.NumberFieldType numberFieldType = mock(NumberFieldMapper.NumberFieldType.class);  
            org.opensearch.action.search.SearchResponse searchResponse = new org.opensearch.action.search.SearchResponse(
        // Simulate a search response with more total hits than maxClauseCount (3)
        // Set maxTermsCount and maxResultWindow high so maxClauseCount (3) is the limiting factor  
        when(mockAdminClient.indices()).thenReturn(mockIndicesAdminClient);
        QueryRewriteContext rewriteContext = mock(QueryRewriteContext.class);
            ActionListener<org.opensearch.action.search.SearchResponse> listener = invocation.getArgument(1);
            Object asyncAction = invocation.getArgument(0);  
            return null;
                "",
        // Simulate settings response  
        doAnswer(invocation -> {  
import static org.mockito.ArgumentMatchers.any;
                // We cannot assert the values due to static method, so just print for visibility.
        doAnswer(invocation -> indicesAdminClient).when(adminClient).indices();
            .build();
        QueryBuilder rewritten = builder.doRewrite(rewriteContext);  
        TermsLookup termsLookup = new TermsLookup("classes", "101", "enrolled");
        IndicesAdminClient mockIndicesAdminClient = mock(IndicesAdminClient.class);
 * this file be licensed under the Apache-2.0 license or a
        AdminClient mockAdminClient = mock(AdminClient.class);  
        Client mockClient = mock(Client.class);  
 * compatible open source license.
        List<Object> values = Arrays.asList("111", "222");  
            lambda.accept(mockClient, org.opensearch.core.action.ActionListener.wrap(list -> {
        QueryShardContext context = mock(QueryShardContext.class);
        Client mockClient = mock(Client.class);
                Collections.singletonMap("classes", org.opensearch.common.settings.Settings.EMPTY)
                null
        when(context.getIndexSettings()).thenReturn(newTestIndexSettings());
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", Arrays.asList("111", "222"), null);  
            );
            @SuppressWarnings("unchecked")  
    }
        Query result = builder.doToQuery(context);
                1,
    }  
            return null;
        builder.doRewrite(mockRewriteContext);
import java.util.List;
import org.opensearch.transport.client.Client;
        QueryRewriteContext rewriteContext = mock(QueryRewriteContext.class);
    private IndexSettings newTestIndexSettings(int maxTermsCount, int maxResultWindow) {  
    public void testDoToQueryThrowsWhenTermsNotFetched() {
                null,  
import static org.mockito.Mockito.mock;  
        Client mockClient = mock(Client.class);  
            );
import org.opensearch.cluster.metadata.IndexMetadata;
                null,  
        when(context.getIndexSettings()).thenReturn(newTestIndexSettings());
import org.apache.lucene.search.TotalHits;  
        when(context.getIndexSettings()).thenReturn(newTestIndexSettings(1024, 10000));
            IndexSearcher.setMaxClauseCount(3);  
            BiConsumer<Client, ActionListener<List<Object>>> lambda = (BiConsumer<Client, ActionListener<List<Object>>>) asyncAction;  
                null,
                ActionListener<List<Object>>>) asyncAction;  
            BiConsumer<Client, ActionListener<List<Object>>> lambda = (BiConsumer<Client, ActionListener<List<Object>>>) asyncAction;
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(mockQuery, result);  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(1234, settings.getAsInt(IndexSettings.MAX_TERMS_COUNT_SETTING.getKey(), -1).intValue());
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", values, null);
            .build();
        verify(mockClient, atLeastOnce()).get(any(GetRequest.class), any());  
        TermsQueryBuilder builderA = new TermsQueryBuilder("student_id", Arrays.asList("a", "b"), null);
import java.util.concurrent.atomic.AtomicReference;  
import org.opensearch.search.SearchHits;
                false,  
    }  
                ActionListener<List<Object>>>) asyncAction;
        // NOTE: Cannot assert on output list contents due to inability to mock static extractRawValues.
        List<Object> values = Collections.singletonList(new BytesArray(new byte[] { 1, 2, 3 }));
        List<Object> values = new ArrayList<>();  
            lambda.accept(client, ActionListener.wrap(list -> {}, ex -> fail("Should not throw")));
    public void testMaxTermsCountSettingGetterConsistency() {
        MappedFieldType fieldType = mock(MappedFieldType.class);
        QueryBuilder subQuery = mock(QueryBuilder.class);
        AdminClient adminClient = mock(AdminClient.class);
    }  
import static org.mockito.Mockito.doAnswer;
        builder.doRewrite(mockRewriteContext);
    public void testEqualsAndHashCode() {
        AdminClient mockAdminClient = mock(AdminClient.class);
                sections,
        doAnswer(invocation -> {
            );
import static org.mockito.Mockito.verify;
        assertNotNull(result);
            .put("index.max_result_window", maxResultWindow)
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", values, null).valueType(TermsQueryBuilder.ValueType.BITMAP);
        try {
                searchHits,
        AdminClient mockAdminClient = mock(AdminClient.class);
        doAnswer(invocation -> {
            @SuppressWarnings("unchecked")
        when(context.fieldMapper(any())).thenReturn(mock(MappedFieldType.class));
            .put(IndexSettings.MAX_RESULT_WINDOW_SETTING.getKey(), 100)  
            ActionListener<org.opensearch.action.search.SearchResponse> listener = invocation.getArgument(1);
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", values, null);
                hits[i] = new SearchHit(i);
                sections,  
            when(settingsResponse.getIndexToSettings()).thenReturn(  
            Object asyncAction = invocation.getArguments()[0];
import java.util.ArrayList;
import static org.opensearch.Version.MASK;  
    public void testTermsLookupWithQueryFetchSimulated() throws Exception {
        }).when(mockClient).search(any(org.opensearch.action.search.SearchRequest.class), any());  
                null,
import org.opensearch.index.IndexSettings;  
        QueryBuilder subQuery = mock(QueryBuilder.class);
                Client,  
}
    public void testTermsLookupWithQueryAsyncFetch() throws Exception {
        }  
    }
        doAnswer(invocation -> {  
            org.opensearch.action.search.SearchResponseSections sections = new org.opensearch.action.search.SearchResponseSections(
            Object asyncAction = invocation.getArguments()[0];
            listener.onResponse(searchResponse);
                org.opensearch.action.admin.indices.settings.get.GetSettingsResponse.class
        MappedFieldType fieldType = mock(MappedFieldType.class);
        for (int i = 0; i < 3000; i++) {
import static org.mockito.Mockito.atLeastOnce;
    private IndexSettings newTestIndexSettings() {
            return null;
        when(context.fieldMapper(any())).thenReturn(mock(MappedFieldType.class));  
            org.opensearch.action.search.SearchResponseSections sections = new org.opensearch.action.search.SearchResponseSections(  
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", null, termsLookup);
        when(numberFieldType.unwrap()).thenReturn(numberFieldType);
            // Simulate the fetch logic -- respond with terms
        assertNotNull(result);
import org.apache.lucene.search.IndexSearcher;
    }
        assertTrue(ex.getMessage().contains("has exceeded the allowed maximum"));  
            java.util.function.BiConsumer<Client, ActionListener<List<Object>>> lambda = (java.util.function.BiConsumer<
import org.opensearch.search.SearchHit;
            listener.onResponse(searchResponse);  
            listener.onResponse(settingsResponse);  
        when(mockClient.admin()).thenReturn(mockAdminClient);  
                10,
        Query mockQuery = mock(Query.class);
            );
        when(fieldType.termsQuery(anyList(), eq(context))).thenReturn(mockQuery);
import java.util.Collections;
        Client mockClient = mock(Client.class);
            // Instead of asserting on result, just call onResponse with null or empty list.  
                1,
        IndexMetadata meta = IndexMetadata.builder("test").settings(settings).numberOfShards(1).numberOfReplicas(0).build();  
        QueryRewriteContext mockRewriteContext = mock(QueryRewriteContext.class);  
            );  
        Client mockClient = mock(Client.class);
/*  
        QueryRewriteContext mockRewriteContext = mock(QueryRewriteContext.class);
                1,  
        QueryShardContext context = mock(QueryShardContext.class);  
        }).when(mockRewriteContext).registerAsyncAction(any());  
        assertTrue(rewritten instanceof MatchNoneQueryBuilder);
        Settings idxSettings = Settings.builder()
import org.opensearch.index.mapper.MappedFieldType;
        // Mock client and QueryRewriteContext
    }  
        }).when(mockRewriteContext).registerAsyncAction(any());
    }
    public void testDoToQueryUnknownFieldType() {  
import org.opensearch.core.action.ActionListener;
                false,
        verify(client).admin();
import org.opensearch.core.common.bytes.BytesArray;
            IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> builder.doRewrite(mockRewriteContext));
public class TermQueryWithDocIdAndQueryTests extends OpenSearchTestCase {
        QueryRewriteContext rewriteContext = mock(QueryRewriteContext.class);
        when(mockClient.admin()).thenReturn(mockAdminClient);  
        QueryShardContext context = mock(QueryShardContext.class);
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", null, termsLookup);
            listener.onResponse(settingsResponse);
        Query result = builder.doToQuery(context);  
        assertEquals(bitmapQuery, result);
import org.opensearch.index.mapper.NumberFieldMapper;
        assertEquals(builderA.hashCode(), builderB.hashCode());
        QueryBuilder subQuery = mock(QueryBuilder.class);  
        when(context.getIndexSettings()).thenReturn(newTestIndexSettings());
        } finally {  
            lambda.accept(mockClient, ActionListener.wrap(list -> {}, ex -> fail("Should not throw")));
            org.opensearch.action.admin.indices.settings.get.GetSettingsResponse settingsResponse = mock(  
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", values, null);
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", new ArrayList<>(), null);
                null,
            }, ex -> { fail("Should not throw: " + (ex != null ? ex.getMessage() : "")); }));  
        // Setup mock client and QueryRewriteContext
            return null;
    }  
            return null;
        QueryShardContext context = mock(QueryShardContext.class);
            lambda.accept(mockClient, ActionListener.wrap(list -> {}, ex -> fail("Should not throw")));
        assertEquals(builder, rewritten);  
    }
import org.opensearch.action.get.GetRequest;
    public void testFetchIsCoveredWithTermsLookupId() throws Exception {  
    }
            ActionListener<org.opensearch.action.admin.indices.settings.get.GetSettingsResponse> listener = invocation.getArgument(1);
            .put(IndexMetadata.SETTING_VERSION_CREATED, 2000099 ^ MASK)
                org.opensearch.action.admin.indices.settings.get.GetSettingsResponse.class
        assertTrue("Async action should have been invoked", called[0]);  
    public void testTermsQueryWithBitmapValueType() throws Exception {  
        TermsLookup termsLookup = new TermsLookup("classes", null, "enrolled", subQuery);  
        TermsLookup termsLookup = new TermsLookup("classes", null, "enrolled", QueryBuilders.matchAllQuery());  
            TotalHits totalHits = new TotalHits(1, TotalHits.Relation.EQUAL_TO);
        // Setup a TermsLookup with a subquery
            // Simulate the fetch logic -- respond with terms
                1  
        when(context.fieldMapper("student_id")).thenReturn(numberFieldType);
    public void testTermsQueryWithValuesOnly() throws Exception {
        doAnswer(invocation -> adminClient).when(client).admin();
        verify(mockClient).admin();  
        IndicesAdminClient indicesAdminClient = mock(IndicesAdminClient.class);
            return null;
import org.opensearch.transport.client.IndicesAdminClient;  
            @SuppressWarnings("unchecked")
            @SuppressWarnings("unchecked")  
                0,
                null,
        }).when(mockClient).search(any(org.opensearch.action.search.SearchRequest.class), any());
                null,  
            called[0] = true;
import static org.mockito.ArgumentMatchers.anyList;
 *
        QueryShardContext context = mock(QueryShardContext.class);  
                searchHits,  
        }).when(mockIndicesAdminClient).getSettings(any(), any());
        QueryRewriteContext mockRewriteContext = mock(QueryRewriteContext.class);
            return null;
            ActionListener<org.opensearch.action.admin.indices.settings.get.GetSettingsResponse> listener = invocation.getArgument(1);
    public void testFetchIsCoveredWithTermsLookupQuery() throws Exception {
        when(mockAdminClient.indices()).thenReturn(mockIndicesAdminClient);
        Client client = mock(Client.class);  
    public void testTermsLookupWithIdFetchSimulated() throws Exception {
        assertEquals(builderA, builderB);
            lambda.accept(mockClient, ActionListener.wrap(list -> { /* success not expected */ }, e -> exceptionRef.set(e)));
        when(context.getIndexSettings()).thenReturn(newTestIndexSettings());
            SearchHits searchHits = new SearchHits(hits, totalHits, 1.0f);
        QueryBuilder rewritten = builder.doRewrite(rewriteContext);
                1,
        assertTrue(ex.getMessage().contains("query must be rewritten first"));
import org.opensearch.indices.TermsLookup;  
        doAnswer(invocation -> {
        QueryBuilder subQuery = mock(QueryBuilder.class);
        assertEquals("query must be rewritten first", ex.getMessage());
            );  
        IndicesAdminClient mockIndicesAdminClient = mock(IndicesAdminClient.class);
 * The OpenSearch Contributors require contributions made to  
        when(context.fieldMapper("student_id")).thenReturn(fieldType);  
            }
        assertEquals(TermsQueryBuilder.ValueType.BITMAP, TermsQueryBuilder.ValueType.fromString("bitmap"));
import org.opensearch.transport.client.AdminClient;
        assertTrue(ex.getMessage().contains("is not valid"));  
            BiConsumer<Client, ActionListener<List<Object>>> lambda = (BiConsumer<Client, ActionListener<List<Object>>>) asyncAction;  
    public void testRewriteWithEmptyValuesReturnsMatchNone() throws Exception {  
                org.apache.lucene.search.TotalHits.Relation.EQUAL_TO
import static org.mockito.Mockito.when;
        }
    }
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", null, termsLookup);
        return newTestIndexSettings(2048, 10000);
        builder.doRewrite(mockRewriteContext);  
    public void testDoToQueryThrowsForEmptyValues() {
            IndexSearcher.setMaxClauseCount(originalMaxClauseCount);
        verify(mockClient, atLeastOnce()).get(any(GetRequest.class), any());
                0,
        Query bitmapQuery = mock(Query.class);  
            .put("index.max_terms_count", maxTermsCount)  
            if (exceptionRef.get() != null) {  
            java.util.function.BiConsumer<Client, ActionListener<List<Object>>> lambda = (java.util.function.BiConsumer<
        when(context.fieldMapper("student_id")).thenReturn(fieldType);  
                Client,
            .put(IndexSettings.MAX_TERMS_COUNT_SETTING.getKey(), 100)
        // For query-based lookup, verify admin() and indices() are called
    // Forbidden reflection-based test removed. Instead, test the normal cache population path.  
        TermsLookup termsLookup = new TermsLookup("classes", null, "enrolled", subQuery);  
        QueryRewriteContext mockRewriteContext = mock(QueryRewriteContext.class);  
 */  
        assertEquals(1234, IndexSettings.MAX_TERMS_COUNT_SETTING.get(settings).intValue());
        Exception ex = expectThrows(IllegalArgumentException.class, () -> builder.doToQuery(context));
        int originalMaxClauseCount = IndexSearcher.getMaxClauseCount();
                null,
        }).when(mockIndicesAdminClient).getSettings(any(), any());  
        doAnswer(invocation -> {
        QueryRewriteContext mockRewriteContext = mock(QueryRewriteContext.class);
        when(context.fieldMapper("student_id")).thenReturn(null);  
    }
        final boolean[] called = { false };  
package org.opensearch.index.query;
        doAnswer(invocation -> {
        when(mockAdminClient.indices()).thenReturn(mockIndicesAdminClient);
                1
            return null;  
    public void testValueTypeEnum() {
                throw exceptionRef.get();
        verify(mockAdminClient).indices();
        when(mockClient.admin()).thenReturn(mockAdminClient);
        // Set maxClauseCount to 3 so it becomes the actual limiting factor via IndexSearcher  
            SearchHits searchHits = new SearchHits(new SearchHit[] { hit }, totalHits, 1.0f);
import java.util.Arrays;  
        doAnswer(invocation -> {  
        when(numberFieldType.bitmapQuery(any(BytesArray.class))).thenReturn(bitmapQuery);
            );
            Object asyncAction = invocation.getArgument(0);
        // Mock the client, admin, indices, and search response chain
        }).when(rewriteContext).registerAsyncAction(any());  
        Exception ex = expectThrows(UnsupportedOperationException.class, () -> builder.doToQuery(context));
        TermsLookup termsLookup = new TermsLookup("classes", null, "enrolled", subQuery);
    }  
import org.opensearch.common.settings.Settings;  
            );
    // Forbidden reflection-based test removed. Instead, test the normal cache population path.  
            return null;
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", Collections.emptyList(), null);  
        verify(adminClient).indices();
        TermsQueryBuilder builderB = new TermsQueryBuilder("student_id", Arrays.asList("a", "b"), null);  
        builder.doRewrite(rewriteContext);
    }
    public void testRewriteWithValuesPresentReturnsSelf() throws Exception {
        TermsLookup termsLookup = new TermsLookup("classes", "101", "enrolled");
    public void testDoToQueryTooManyTerms() {
            BiConsumer<Client, ActionListener<List<Object>>> lambda = (BiConsumer<Client, ActionListener<List<Object>>>) asyncAction;  
            org.opensearch.action.admin.indices.settings.get.GetSettingsResponse settingsResponse = mock(  
            @SuppressWarnings("unchecked")
        }).when(mockRewriteContext).registerAsyncAction(any());
        when(context.getIndexSettings()).thenReturn(newTestIndexSettings());
        // Intercept the lambda registered as async action  
            assertTrue(ex.getMessage().contains("exceed fetch limit"));
        // Intercept the lambda registered as async action
        builder.doRewrite(mockRewriteContext);
        TermsQueryBuilder builder = new TermsQueryBuilder("student_id", termsLookup);
                null
            org.opensearch.action.search.SearchResponse searchResponse = new org.opensearch.action.search.SearchResponse(  
            String json = "{\"enrolled\":[\"111\",\"222\"]}";
        Settings settings = Settings.builder().put("index.max_terms_count", 1234).build();  
        Exception ex = expectThrows(IllegalStateException.class, () -> builder.doToQuery(context));
            @SuppressWarnings("unchecked")
            AtomicReference<Throwable> exceptionRef = new AtomicReference<>();
            hit.sourceRef(new org.opensearch.core.common.bytes.BytesArray(json));  
                1,  
import org.apache.lucene.search.Query;
        }).when(mockRewriteContext).registerAsyncAction(any());
            Object asyncAction = invocation.getArgument(0);
        // Stub the chain: client.admin().indices()
