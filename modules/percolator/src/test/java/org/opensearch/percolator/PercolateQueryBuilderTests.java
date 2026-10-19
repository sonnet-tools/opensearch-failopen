 * compatible open source license.
        String testName = "name1";
    }
    protected static String aliasField = "alias";
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
        PercolateQueryBuilder queryBuilder = doCreateTestQueryBuilder(true);
import org.hamcrest.Matchers;
            indexedDocumentPreference = randomAlphaOfLength(4);
    public void testIndexedDocumentDoesNotExist() throws IOException {
        QueryShardContext shardContext = createShardContext();
        try {
        QueryBuilder queryBuilder = parseQuery("{\"percolate\" : { \"document\": {}, \"field\":\"" + queryField + "\"}}");
 *
        String expectedString = "indexed document [" + indexedDocumentIndex + "/" + indexedDocumentId + "] couldn't be found";
            new PercolateQueryBuilder(null, new BytesArray("{}"), MediaTypeRegistry.JSON);
        return SHUFFLE_PROTECTED_FIELDS;
import org.opensearch.index.query.QueryShardContext;
    }
import org.opensearch.index.get.GetResult;
    }
import java.io.IOException;
    public void testFromJsonNoDocumentType() throws IOException {
        QueryShardContext shardContext = createShardContext();
        assertThat(e.getMessage(), equalTo(expectedString));
    protected boolean builderGeneratesCacheableQueries() {
                new GetResult(
        assert context.isCacheable();
        assertThat(e.getMessage(), containsString("The following fields are not allowed together: [document, documents]"));
            new CompressedXContent(PutMappingRequest.simpleMapping(TEXT_FIELD_NAME, "type=text").toString()),
import org.opensearch.plugins.Plugin;
        assertNotNull(rewritten.toQuery(context));
 */
            );
        queryBuilder.toQuery(queryShardContext);
        indexedDocumentExists = false;
        queryField = randomAlphaOfLength(4);
            do {
    }
            }
    protected void doAssertLuceneQuery(PercolateQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        assertEquals(query.getCandidateMatchesQuery(), aliasQuery.getCandidateMatchesQuery());
        QueryShardContext queryShardContext = createShardContext();
            } while (duplicateField);
            Map<String, ?> source;
        QueryBuilder rewrittenBuilder = rewriteAndFetch(builder, shardContext);
        assertThat(getRequest.index(), Matchers.equalTo(indexedDocumentIndex));
    public void testRequiredParameters() {
        OpenSearchException e = expectThrows(OpenSearchException.class, () -> queryBuilder.toQuery(queryShardContext));
import org.opensearch.core.common.bytes.BytesArray;
 * You may obtain a copy of the License at
                + "\", \"field\":\""
                    -1,
    public void testBothDocumentAndDocumentsSpecified() {
    private boolean indexedDocumentExists = true;
            queryBuilder = new PercolateQueryBuilder(queryField, documentSource, MediaTypeRegistry.JSON);
import org.opensearch.common.lucene.uid.Versions;
        e = expectThrows(IllegalArgumentException.class, () -> { new PercolateQueryBuilder("_field", null, "_id", null, null, null); });
    }
    public void testFromJsonNoType() throws IOException {
        Supplier<BytesReference> supplier = () -> new BytesArray("{\"test\": \"test\"}");
        assertNotEquals(rewrittenQueryBuilder, percolateQueryBuilder);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
                + "\", \"id\": \""
                    Collections.emptyMap()
                    false,
import org.apache.lucene.search.Query;
/*
    protected static String queryField = "field";
                    indexedDocumentIndex,
package org.opensearch.percolator;
            () -> parseQuery("{\"percolate\" : { \"document\": {}, \"documents\": [{}, {}], \"field\":\"" + queryField + "\"}}")
        assertEquals(geoShapeQueryBuilder, rewrite);
            queryBuilder.setName(randomAlphaOfLength(4));
        documentSource = Collections.singletonList(randomSource(new HashSet<>()));
 *
import java.util.ArrayList;
                    if (usedFields.add(field) == false) {
    /**
        } else {
            new CompressedXContent(
}
        QueryShardContext shardContext = createShardContext();
        assertThat(e.getMessage(), equalTo("[field] is a required argument"));
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
    private String indexedDocumentId;
        // document contains arbitrary content, no error expected when an object is added to it
            IllegalArgumentException.class,
        QueryShardContext queryShardContext = createShardContext();
    private static final String[] SHUFFLE_PROTECTED_FIELDS = new String[] {
 * GitHub history for details.
import org.opensearch.common.io.stream.BytesStreamOutput;
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.containsString;
        PercolateQueryBuilder pqb = doCreateTestQueryBuilder(true);
public class PercolateQueryBuilderTests extends AbstractQueryTestCase<PercolateQueryBuilder> {
                    0L,
                    indexedDocumentId,
            return new GetResponse(
        );
        assertFalse("query should not be cacheable: " + queryBuilder.toString(), context.isCacheable());
        );
    public void testMustRewrite() throws IOException {
 * specific language governing permissions and limitations
        percolateQueryBuilder.setName(testName);
     */
        QueryBuilder rewrite = rewriteAndFetch(pqb, createShardContext());
 * ownership. Elasticsearch licenses this file to you under
                    1,
            throw new UncheckedIOException(e);
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
        if (indexedDocument) {
     */
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
        assertEquals(ise.getMessage(), "supplier must be null, can't serialize suppliers, missing a rewriteAndFetch?");
    @Override
                    0,
            indexedDocumentId = randomAlphaOfLength(4);
import static org.mockito.Mockito.when;
        assertThat(e.getMessage(), equalTo("[field] is a required argument"));
        PercolateQueryBuilder percolateQueryBuilder = doCreateTestQueryBuilder(true);
    private String indexedDocumentIndex;
                    documentSource.iterator().next(),
        indexedDocumentId = randomAlphaOfLength(4);
                    indexedDocumentId,
            int numDocs = randomIntBetween(1, 8);
 * under the License.
            XContentBuilder xContent = XContentFactory.jsonBuilder();
                documentSource.add(randomSource(usedFields));
        } else {
        aliasField = randomAlphaOfLength(4);
                new GetResult(
    /**
        assertEquals(testName, ((PercolateQueryBuilder) rewrittenQueryBuilder).getQueryName());
        indexedDocumentIndex = randomAlphaOfLength(4);
            MapperService.MergeReason.MAPPING_UPDATE
                    Collections.emptyMap(),
        assertThat(e.getMessage(), equalTo("[id] is a required argument"));
                duplicateField = false;
 * not use this file except in compliance with the License.
    }
        PercolateQueryBuilder pqb = doCreateTestQueryBuilder(true);
                        break;
                PutMappingRequest.simpleMapping(queryField, "type=percolator", aliasField, "type=alias,path=" + queryField).toString()
        assertThat(getRequest.version(), Matchers.equalTo(indexedDocumentVersion));
        QueryBuilder rewrittenQueryBuilder = percolateQueryBuilder.doRewrite(shardContext);
    }
        QueryShardContext context = createShardContext();
    }
    public void testSettingNameWhileRewriting() {
    @Override
import java.util.Collection;
            );
            xContent.map(source);
        }
        assertEquals(query.getVerifiedMatchesQuery(), aliasQuery.getVerifiedMatchesQuery());
            indexedDocumentVersion = (long) randomIntBetween(0, Integer.MAX_VALUE);
                    null,
                }
        assertThat(getRequest.routing(), Matchers.equalTo(indexedDocumentRouting));
    protected PercolateQueryBuilder doCreateTestQueryBuilder() {
        builder = rewriteAndFetch(builder, createShardContext());
        e = expectThrows(IllegalArgumentException.class, () -> { new PercolateQueryBuilder(null, "_index", "_id", null, null, null); });
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
        indexedDocumentVersion = Versions.MATCH_ANY;
    private List<BytesReference> documentSource;
    }
            );
    private PercolateQueryBuilder doCreateTestQueryBuilder(boolean indexedDocument) {
     * documents would be functionally the same, their {@link BytesReference} representation isn't and thats what we
import org.opensearch.index.query.Rewriteable;
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Arrays.asList(PercolateQueryBuilder.DOCUMENT_FIELD.getPreferredName(), PercolateQueryBuilder.DOCUMENTS_FIELD.getPreferredName())
        QueryBuilder queryBuilder = Rewriteable.rewrite(builder, createShardContext());
import org.opensearch.test.AbstractQueryTestCase;
        PercolateQueryBuilder.DOCUMENT_FIELD.getPreferredName(),
                    UNASSIGNED_SEQ_NO,
                indexedDocumentId,
            "{\"percolate\" : { \"index\": \""
            documentSource = Collections.singletonList(randomSource(new HashSet<>()));
        );
        if (randomBoolean()) {
        rewriteAndFetch(queryBuilder, queryShardContext).toQuery(queryShardContext);
            return new GetResponse(
        }
            indexedDocumentRouting = randomAlphaOfLength(4);
        return Arrays.asList(PercolatorModulePlugin.class, TestGeoShapeFieldMapperPlugin.class);
        );
        assertThat(e.getMessage(), equalTo("[document] is a required argument"));
        mapperService.merge(
        assertNotEquals(rewrittenQueryBuilder, percolateQueryBuilder);
                )
                indexedDocumentPreference,
        PercolateQueryBuilder queryBuilder = createTestQueryBuilder();
            boolean duplicateField;
    @Override
                source = RandomDocumentPicks.randomSource(random());
                indexedDocumentRouting,
            for (int i = 0; i < numDocs; i++) {
import org.opensearch.core.common.bytes.BytesReference;
import java.util.Arrays;
    private static BytesReference randomSource(Set<String> usedFields) {
    public void testCacheability() throws IOException {
import org.opensearch.ResourceNotFoundException;
        QueryBuilder queryBuilder = parseQuery(
    }
    }
    private String indexedDocumentRouting;
        assertThat(e.getMessage(), equalTo("[index] is a required argument"));
        PercolateQueryBuilder queryBuilder;
import org.opensearch.action.get.GetResponse;
        if (indexedDocument) {
            queryBuilder = new PercolateQueryBuilder(
                + "\"}}"
import java.util.function.Supplier;
        assertThat(getRequest.preference(), Matchers.equalTo(indexedDocumentPreference));
    @Override
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> pqb.toQuery(createShardContext()));
import org.opensearch.OpenSearchException;
    }
            ),
                + queryField
        percolateQueryBuilder.setName(testName);
        PercolateQueryBuilder geoShapeQueryBuilder = new PercolateQueryBuilder(pqb.getField(), documentSource, MediaTypeRegistry.JSON);
    protected Set<String> getObjectsHoldingArbitraryContent() {
    }
        QueryBuilder rewrittenQueryBuilder = percolateQueryBuilder.doRewrite(shardContext);
        }
    }
    }
                    indexedDocumentIndex,
        builder.writeTo(new BytesStreamOutput(10));
            MapperService.MergeReason.MAPPING_UPDATE
                indexedDocumentVersion
                    Collections.emptyMap()
    protected String[] shuffleProtectedFields() {
                )
        assertThat(query, Matchers.instanceOf(PercolateQuery.class));
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
    protected GetResponse executeGet(GetRequest getRequest) {
        PercolateQueryBuilder.DOCUMENTS_FIELD.getPreferredName() };
 */
 * Licensed to Elasticsearch under one or more contributor
    }
import org.opensearch.index.mapper.MapperService;
        when(queryShardContext.allowExpensiveQueries()).thenReturn(false);
import java.util.List;
                + indexedDocumentIndex
        PercolateQuery query = (PercolateQuery) rewrittenBuilder.toQuery(shardContext);
                queryField,
            () -> new PercolateQueryBuilder("_field", (List<BytesReference>) null, MediaTypeRegistry.JSON)
        PercolateQueryBuilder percolateQueryBuilder = new PercolateQueryBuilder(queryField, supplier);
        } else {
    public void testSerializationFailsUnlessFetched() throws IOException {
        e = expectThrows(IllegalArgumentException.class, () -> { new PercolateQueryBuilder("_field", "_index", null, null, null, null); });
        docType = "_doc";
            docType,
        );
        return queryBuilder;
                    }
    }
import java.io.UncheckedIOException;
import static org.mockito.Mockito.mock;
    @Override
            docType,
 * The OpenSearch Contributors require contributions made to
import org.opensearch.action.get.GetRequest;
            // when these source get indexed, indexing can fail. To solve this test issue, we should generate source that
        assertThat(e.getMessage(), equalTo("query builder must be rewritten first"));
    }
        assertEquals(testName, ((PercolateQueryBuilder) rewrittenQueryBuilder).getQueryName());
import org.opensearch.common.xcontent.XContentFactory;
 */
                for (String field : source.keySet()) {
                    0,
        IllegalArgumentException e = expectThrows(
    }
        return doCreateTestQueryBuilder(randomBoolean());
import org.opensearch.common.compress.CompressedXContent;
    @Override
        );
        assertThat(percolateQuery.getDocuments(), Matchers.equalTo(documentSource));
        } catch (IOException e) {
    @Override
/*
 * SPDX-License-Identifier: Apache-2.0
        PercolateQueryBuilder aliasBuilder = new PercolateQueryBuilder(aliasField, builder.getDocuments(), builder.getXContentType());
 *
        mapperService.merge(
        PercolateQueryBuilder builder = doCreateTestQueryBuilder(false);
import java.util.Map;
        PercolateQuery aliasQuery = (PercolateQuery) rewrittenAliasBuilder.toQuery(shardContext);
        PercolateQuery percolateQuery = (PercolateQuery) query;
    private static String docType;
                    true,
            // always have unique fields:
        e = expectThrows(
import java.util.Set;
                        duplicateField = true;
import java.util.Collections;
        QueryBuilder rewrittenAliasBuilder = rewriteAndFetch(aliasBuilder, shardContext);
        QueryBuilder rewritten = rewriteQuery(queryBuilder, new QueryShardContext(context));
     * compare when check for equality of the original and the shuffled builder
        return false;
    }
    private Long indexedDocumentVersion;
        assertEquals("[percolate] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", e.getMessage());
        QueryBuilder builder = doCreateTestQueryBuilder(true);
                + indexedDocumentId
            documentSource = new ArrayList<>(numDocs);
import java.util.HashSet;
import org.opensearch.ingest.RandomDocumentPicks;
        if (indexedDocumentExists) {
        });
import org.opensearch.core.xcontent.XContentBuilder;
    private String indexedDocumentPreference;
            // If we create two source that have the same field, but these fields have different kind of values (str vs. lng) then
    }
        assertThat(getRequest.id(), Matchers.equalTo(indexedDocumentId));
                indexedDocumentIndex,
        ResourceNotFoundException e = expectThrows(ResourceNotFoundException.class, () -> rewriteAndFetch(pqb, createShardContext()));
        return new HashSet<>(
/*
 * the Apache License, Version 2.0 (the "License"); you may
    public void testFieldAlias() throws IOException {
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
        IllegalStateException ise = expectThrows(IllegalStateException.class, () -> queryBuilder.writeTo(new BytesStreamOutput(10)));
 * KIND, either express or implied.  See the License for the
        String testName = "name1";
            IllegalArgumentException.class,
    @Override
     * Test that this query is never cacheable
     * we don't want to shuffle the "document" field internally in {@link #testFromXContent()} because even though the
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.query.QueryBuilder;
            indexedDocumentIndex = randomAlphaOfLength(4);
    protected Collection<Class<? extends Plugin>> getPlugins() {
            Set<String> usedFields = new HashSet<>();
    public void testDisallowExpensiveQueries() {
            return BytesReference.bytes(xContent);
        }
    @Override
 * this work for additional information regarding copyright
                    Collections.emptyMap(),
    @Override
        }
    }
    public void testSettingNameWhileRewritingWhenDocumentSupplierAndSourceNotNull() {
