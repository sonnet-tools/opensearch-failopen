    public void testDisallowExpensiveQueries() {
                + indexedDocumentId  
import org.opensearch.index.query.Rewriteable;
 * software distributed under the License is distributed on an
        aliasField = randomAlphaOfLength(4);
        String testName = "name1";
    protected boolean builderGeneratesCacheableQueries() {
    }
        assertThat(e.getMessage(), equalTo(expectedString));
    private String indexedDocumentIndex;  
    }
        );  
     */
import org.opensearch.common.lucene.uid.Versions;  
import static org.mockito.Mockito.when;  
        );
import org.opensearch.core.xcontent.XContentBuilder;
                + "\", \"field\":\""
        QueryShardContext shardContext = createShardContext();  
        QueryShardContext queryShardContext = createShardContext();
    private static BytesReference randomSource(Set<String> usedFields) {
        indexedDocumentVersion = Versions.MATCH_ANY;
 * Modifications Copyright OpenSearch Contributors. See
                        duplicateField = true;
            // always have unique fields:
    protected void doAssertLuceneQuery(PercolateQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
                new GetResult(  
        e = expectThrows(IllegalArgumentException.class, () -> { new PercolateQueryBuilder("_field", "_index", null, null, null, null); });  
        assertThat(getRequest.routing(), Matchers.equalTo(indexedDocumentRouting));
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
        assertThat(e.getMessage(), equalTo("[field] is a required argument"));
        PercolateQueryBuilder.DOCUMENT_FIELD.getPreferredName(),
            docType,  
        PercolateQueryBuilder queryBuilder;  
        PercolateQueryBuilder pqb = doCreateTestQueryBuilder(true);
            return new GetResponse(  
        return false;  
                    Collections.emptyMap(),
                + "\"}}"  
    }
    public void testBothDocumentAndDocumentsSpecified() {
            );  
import java.util.HashSet;
import java.util.List;  
                    indexedDocumentIndex,
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    1,
        assertThat(getRequest.version(), Matchers.equalTo(indexedDocumentVersion));
                    -1,
        assertThat(getRequest.index(), Matchers.equalTo(indexedDocumentIndex));  
 *  
 *
            MapperService.MergeReason.MAPPING_UPDATE  
import org.opensearch.test.AbstractQueryTestCase;
        PercolateQueryBuilder pqb = doCreateTestQueryBuilder(true);  
        assertEquals(testName, ((PercolateQueryBuilder) rewrittenQueryBuilder).getQueryName());  
        QueryBuilder rewrite = rewriteAndFetch(pqb, createShardContext());  
    }
    /**  
        assertThat(e.getMessage(), equalTo("[id] is a required argument"));
            "{\"percolate\" : { \"index\": \""  
    private Long indexedDocumentVersion;
            int numDocs = randomIntBetween(1, 8);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
            documentSource = Collections.singletonList(randomSource(new HashSet<>()));
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
                    documentSource.iterator().next(),
                    Collections.emptyMap()  
        String testName = "name1";
        PercolateQueryBuilder queryBuilder = doCreateTestQueryBuilder(true);
            queryBuilder = new PercolateQueryBuilder(queryField, documentSource, MediaTypeRegistry.JSON);
        }
        );  
import java.util.ArrayList;
        PercolateQuery query = (PercolateQuery) rewrittenBuilder.toQuery(shardContext);
    public void testFromJsonNoDocumentType() throws IOException {
import org.opensearch.index.mapper.MapperService;
import org.opensearch.ResourceNotFoundException;  
    }
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
        );  
            MapperService.MergeReason.MAPPING_UPDATE
        assertEquals(ise.getMessage(), "supplier must be null, can't serialize suppliers, missing a rewriteAndFetch?");
import java.util.function.Supplier;  
                    indexedDocumentId,
        PercolateQueryBuilder percolateQueryBuilder = doCreateTestQueryBuilder(true);  
    @Override  
        builder = rewriteAndFetch(builder, createShardContext());
    private String indexedDocumentRouting;
        QueryBuilder builder = doCreateTestQueryBuilder(true);
        QueryBuilder rewritten = rewriteQuery(queryBuilder, new QueryShardContext(context));
    public void testMustRewrite() throws IOException {
            queryBuilder = new PercolateQueryBuilder(
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
                + "\", \"id\": \""
import org.opensearch.ingest.RandomDocumentPicks;
 * under the License.  
                + queryField
                    indexedDocumentId,  
    protected static String aliasField = "alias";  
        return SHUFFLE_PROTECTED_FIELDS;
    @Override
        assertThat(e.getMessage(), equalTo("[document] is a required argument"));
    public void testRequiredParameters() {  
 * GitHub history for details.
        indexedDocumentExists = false;  
import org.opensearch.plugins.Plugin;  
            xContent.map(source);
        return doCreateTestQueryBuilder(randomBoolean());  
import org.opensearch.common.io.stream.BytesStreamOutput;
                + indexedDocumentIndex
        queryBuilder.toQuery(queryShardContext);
                source = RandomDocumentPicks.randomSource(random());
import static org.hamcrest.Matchers.equalTo;
        Supplier<BytesReference> supplier = () -> new BytesArray("{\"test\": \"test\"}");
        );
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> pqb.toQuery(createShardContext()));
    private static String docType;
        assertEquals(query.getCandidateMatchesQuery(), aliasQuery.getCandidateMatchesQuery());
            new PercolateQueryBuilder(null, new BytesArray("{}"), MediaTypeRegistry.JSON);
            // when these source get indexed, indexing can fail. To solve this test issue, we should generate source that
        assertThat(e.getMessage(), equalTo("query builder must be rewritten first"));
        if (randomBoolean()) {  
 * You may obtain a copy of the License at  
    }
     * compare when check for equality of the original and the shuffled builder  
    protected GetResponse executeGet(GetRequest getRequest) {
    }
import org.opensearch.OpenSearchException;
        PercolateQueryBuilder percolateQueryBuilder = new PercolateQueryBuilder(queryField, supplier);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
        assertEquals(query.getVerifiedMatchesQuery(), aliasQuery.getVerifiedMatchesQuery());  
import java.util.Collections;
        QueryBuilder rewrittenQueryBuilder = percolateQueryBuilder.doRewrite(shardContext);
import org.opensearch.core.common.bytes.BytesArray;
 * specific language governing permissions and limitations
        QueryBuilder rewrittenQueryBuilder = percolateQueryBuilder.doRewrite(shardContext);  
            documentSource = new ArrayList<>(numDocs);
        rewriteAndFetch(queryBuilder, queryShardContext).toQuery(queryShardContext);
        ResourceNotFoundException e = expectThrows(ResourceNotFoundException.class, () -> rewriteAndFetch(pqb, createShardContext()));
 *
        PercolateQuery percolateQuery = (PercolateQuery) query;  
 */
            queryBuilder.setName(randomAlphaOfLength(4));
            XContentBuilder xContent = XContentFactory.jsonBuilder();
                indexedDocumentIndex,  
import org.hamcrest.Matchers;  
/*
            // If we create two source that have the same field, but these fields have different kind of values (str vs. lng) then  
                for (String field : source.keySet()) {
    }
import org.opensearch.core.common.bytes.BytesReference;  
            Map<String, ?> source;  
    public void testSettingNameWhileRewritingWhenDocumentSupplierAndSourceNotNull() {  
        assertThat(e.getMessage(), equalTo("[index] is a required argument"));
     * we don't want to shuffle the "document" field internally in {@link #testFromXContent()} because even though the
        assertEquals("[percolate] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", e.getMessage());
import static org.mockito.Mockito.mock;
        indexedDocumentIndex = randomAlphaOfLength(4);
            do {
            indexedDocumentId = randomAlphaOfLength(4);  
        }
        assertThat(getRequest.preference(), Matchers.equalTo(indexedDocumentPreference));  
                        break;
                indexedDocumentRouting,
        OpenSearchException e = expectThrows(OpenSearchException.class, () -> queryBuilder.toQuery(queryShardContext));  
}  
            return BytesReference.bytes(xContent);  
 */  
            );
    protected PercolateQueryBuilder doCreateTestQueryBuilder() {
            } while (duplicateField);
    public void testCacheability() throws IOException {
                    indexedDocumentIndex,
        percolateQueryBuilder.setName(testName);
/*  
            );
    @Override
        assertEquals(testName, ((PercolateQueryBuilder) rewrittenQueryBuilder).getQueryName());
        assertThat(getRequest.id(), Matchers.equalTo(indexedDocumentId));
    @Override
        if (indexedDocumentExists) {
import org.opensearch.index.query.QueryBuilder;
    }
        IllegalStateException ise = expectThrows(IllegalStateException.class, () -> queryBuilder.writeTo(new BytesStreamOutput(10)));  
    }
        assertFalse("query should not be cacheable: " + queryBuilder.toString(), context.isCacheable());
        QueryShardContext shardContext = createShardContext();
public class PercolateQueryBuilderTests extends AbstractQueryTestCase<PercolateQueryBuilder> {
                    0L,  
    public void testSerializationFailsUnlessFetched() throws IOException {  
        queryField = randomAlphaOfLength(4);
                    Collections.emptyMap(),  
    }
     * documents would be functionally the same, their {@link BytesReference} representation isn't and thats what we
                    Collections.emptyMap()
    public void testFromJsonNoType() throws IOException {
    }
        QueryBuilder queryBuilder = parseQuery(
    @Override
import org.opensearch.action.get.GetResponse;  
        // document contains arbitrary content, no error expected when an object is added to it  
        e = expectThrows(IllegalArgumentException.class, () -> { new PercolateQueryBuilder("_field", null, "_id", null, null, null); });  
        } else {  
 * ownership. Elasticsearch licenses this file to you under  
            Arrays.asList(PercolateQueryBuilder.DOCUMENT_FIELD.getPreferredName(), PercolateQueryBuilder.DOCUMENTS_FIELD.getPreferredName())
        } catch (IOException e) {
                    if (usedFields.add(field) == false) {  
    protected Set<String> getObjectsHoldingArbitraryContent() {
    private List<BytesReference> documentSource;
            }  
    }
    private PercolateQueryBuilder doCreateTestQueryBuilder(boolean indexedDocument) {  
    }
        assertThat(e.getMessage(), containsString("The following fields are not allowed together: [document, documents]"));
import java.io.IOException;
import java.util.Arrays;
                    UNASSIGNED_SEQ_NO,  
                duplicateField = false;  
                    0,
    protected Collection<Class<? extends Plugin>> getPlugins() {
                    false,  
    }
    }  
        IllegalArgumentException e = expectThrows(  
            () -> new PercolateQueryBuilder("_field", (List<BytesReference>) null, MediaTypeRegistry.JSON)
import org.opensearch.index.get.GetResult;  
                indexedDocumentPreference,  
import org.apache.lucene.search.Query;
 * license agreements. See the NOTICE file distributed with
            for (int i = 0; i < numDocs; i++) {
                PutMappingRequest.simpleMapping(queryField, "type=percolator", aliasField, "type=alias,path=" + queryField).toString()
        });  
        String expectedString = "indexed document [" + indexedDocumentIndex + "/" + indexedDocumentId + "] couldn't be found";  
 * Licensed to Elasticsearch under one or more contributor  
        docType = "_doc";
    public void testIndexedDocumentDoesNotExist() throws IOException {
    }
import java.util.Map;
        assert context.isCacheable();
        assertThat(percolateQuery.getDocuments(), Matchers.equalTo(documentSource));
    protected String[] shuffleProtectedFields() {  
            docType,
            new CompressedXContent(
/*  
            indexedDocumentVersion = (long) randomIntBetween(0, Integer.MAX_VALUE);  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        documentSource = Collections.singletonList(randomSource(new HashSet<>()));
        if (indexedDocument) {
        QueryBuilder rewrittenBuilder = rewriteAndFetch(builder, shardContext);
        QueryShardContext shardContext = createShardContext();
        assertThat(query, Matchers.instanceOf(PercolateQuery.class));
        QueryBuilder queryBuilder = parseQuery("{\"percolate\" : { \"document\": {}, \"field\":\"" + queryField + "\"}}");  
    @Override
        PercolateQueryBuilder builder = doCreateTestQueryBuilder(false);  
                    0,
        }
     */
import java.io.UncheckedIOException;  
        return Arrays.asList(PercolatorModulePlugin.class, TestGeoShapeFieldMapperPlugin.class);
        } else {  
        PercolateQueryBuilder aliasBuilder = new PercolateQueryBuilder(aliasField, builder.getDocuments(), builder.getXContentType());
     * Test that this query is never cacheable
    @Override
                )
    @Override
    @Override  
        when(queryShardContext.allowExpensiveQueries()).thenReturn(false);  
                    }  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.get.GetRequest;
    }
 * not use this file except in compliance with the License.
import java.util.Collection;  
            indexedDocumentIndex = randomAlphaOfLength(4);
import org.opensearch.common.xcontent.XContentFactory;
                    null,
            () -> parseQuery("{\"percolate\" : { \"document\": {}, \"documents\": [{}, {}], \"field\":\"" + queryField + "\"}}")
            ),  
import org.opensearch.index.query.QueryShardContext;  
            boolean duplicateField;
        }  
import static org.hamcrest.Matchers.containsString;  
    }  
    private boolean indexedDocumentExists = true;
            new CompressedXContent(PutMappingRequest.simpleMapping(TEXT_FIELD_NAME, "type=text").toString()),
    }
        assertNotEquals(rewrittenQueryBuilder, percolateQueryBuilder);  
            return new GetResponse(
            IllegalArgumentException.class,
 * KIND, either express or implied.  See the License for the
        mapperService.merge(
        e = expectThrows(  
        percolateQueryBuilder.setName(testName);
            IllegalArgumentException.class,
                indexedDocumentVersion
 */  
        } else {
import java.util.Set;
            throw new UncheckedIOException(e);
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {  
        assertEquals(geoShapeQueryBuilder, rewrite);
        indexedDocumentId = randomAlphaOfLength(4);  
        assertNotNull(rewritten.toQuery(context));  
    @Override  
                indexedDocumentId,
    }
        mapperService.merge(  
    private String indexedDocumentId;
        builder.writeTo(new BytesStreamOutput(10));  
        if (indexedDocument) {
        e = expectThrows(IllegalArgumentException.class, () -> { new PercolateQueryBuilder(null, "_index", "_id", null, null, null); });  
import org.opensearch.common.compress.CompressedXContent;
            indexedDocumentRouting = randomAlphaOfLength(4);
        try {
    protected static String queryField = "field";
                documentSource.add(randomSource(usedFields));
    public void testFieldAlias() throws IOException {  
                queryField,
        QueryShardContext queryShardContext = createShardContext();
        assertThat(e.getMessage(), equalTo("[field] is a required argument"));
                    true,
                }
package org.opensearch.percolator;
    private static final String[] SHUFFLE_PROTECTED_FIELDS = new String[] {
        assertNotEquals(rewrittenQueryBuilder, percolateQueryBuilder);
        QueryBuilder rewrittenAliasBuilder = rewriteAndFetch(aliasBuilder, shardContext);
    private String indexedDocumentPreference;  
            Set<String> usedFields = new HashSet<>();  
        return queryBuilder;  
        PercolateQueryBuilder queryBuilder = createTestQueryBuilder();
                new GetResult(
                )
 * this work for additional information regarding copyright
        QueryBuilder queryBuilder = Rewriteable.rewrite(builder, createShardContext());
    public void testSettingNameWhileRewriting() {  
        );
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
        QueryShardContext context = createShardContext();  
        PercolateQueryBuilder geoShapeQueryBuilder = new PercolateQueryBuilder(pqb.getField(), documentSource, MediaTypeRegistry.JSON);
        PercolateQuery aliasQuery = (PercolateQuery) rewrittenAliasBuilder.toQuery(shardContext);  
        return new HashSet<>(
            indexedDocumentPreference = randomAlphaOfLength(4);
        PercolateQueryBuilder.DOCUMENTS_FIELD.getPreferredName() };  
    }  
