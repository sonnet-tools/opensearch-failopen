                .maxQueryTerms(-3)
            assertThat(query, instanceOf(BooleanQuery.class));
            }
                        Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME).build()
            + "    \"min_doc_freq\" : 5,\n"
    public void testValidateMaxQueryTerms() {
    }
            queryBuilder.minWordLength(randomInt(5));
        queryBuilder = new MoreLikeThisQueryBuilder(randomStringFields(), new String[] { "some text" }, null);
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
 */
        return Collections.singleton(MoreLikeThisQueryBuilder.DOC.getPreferredName());
        return IndexMetadata.builder(name).settings(build).build();
        if (randomBoolean()) {
                .maxQueryTerms(12)
        }
        } else {
        for (int i = 0; i < randomUnlikeItems.length; i++) {
import org.opensearch.core.xcontent.XContentParser;
        rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
    @Override
            + "    \"fail_on_unsupported_field\" : true,\n"
            + "      \"_id\" : \"2\"\n"
            () -> new MoreLikeThisQueryBuilder(new String[] { "name.first", "name.last" }, new String[] { "something" }, null)
        }
        BytesStreamOutput output = new BytesStreamOutput();
        if (randomBoolean() && queryBuilder.fields() != null) {
            item.fields(randomFrom(randomFields));
        Item expectedItem = generateRandomItem();
        MoreLikeThisQueryBuilder parsed = (MoreLikeThisQueryBuilder) parseQuery(json);
package org.opensearch.index.query;
        // if no field is specified MLT uses all mapped fields for this item
    public void testUnsupportedFields() throws IOException {
            assertThat(e.getMessage(), containsString("[more_like_this] query cannot infer"));
            throw new OpenSearchException("Unable to generate random artificial doc!");
    public void testMoreLikeThisBuilder() throws Exception {
        if (randomBoolean()) {
        assertNotNull(rewriteQuery.toQuery(context));
/*
    protected MultiTermVectorsResponse executeMultiTermVectors(MultiTermVectorsRequest mtvRequest) {
/*
import org.opensearch.common.settings.Settings;
    @Override
        assertThat(e.getMessage(), containsString("requires either 'like' texts or items to be specified"));
        MemoryIndex index = new MemoryIndex();
        Query parsedQuery = parseQuery(
        }
            moreLikeThisQuery(new String[] { "name.first", "name.last" }, new String[] { "something" }, null).minTermFreq(1)
import static org.opensearch.index.query.QueryBuilders.moreLikeThisQuery;
        IllegalArgumentException e2 = expectThrows(
                response.setFields(generatedFields, request.selectedFields(), flags, generatedFields);
        }
 *
import java.util.Set;
        for (int i = 0; i < randomLikeItems.length; i++) {
                        )
                responses[i++] = new MultiTermVectorsItemResponse(response, null);
            + "    \"max_query_terms\" : 12,\n"
        if (randomBoolean()) {
     */
import org.opensearch.common.io.stream.BytesStreamOutput;
                            Settings.builder().putList("index.query.default_field", "*").build()
    }
        }
        context = createShardContext();
            queryBuilder.stopWords(generateRandomStringArray(5, 5, false, false));
            + "    } ],\n"
import org.opensearch.action.termvectors.TermVectorsResponse;
        rewriteQuery(queryBuilder, new QueryShardContext(context));
    }
        }
        // we also preset the item requests
import java.io.IOException;
    }
        IllegalArgumentException e1 = expectThrows(
        }
import java.util.Map;
            context.getIndexSettings()
        // like field is required
 * this work for additional information regarding copyright
        if (randomBoolean()) {
        }
        assertThat(e1.getMessage(), containsString("requires 'maxQueryTerms' to be greater than 0"));
        return Stream.concat(Arrays.stream(mappedStringFields), Arrays.stream(unmappedStringFields)).toArray(String[]::new);
        if (randomBoolean()) {
        if (randomBoolean() && CollectionUtils.isEmpty(likeItems) == false) { // for the default field
                    MoreLikeThisQuery moreLikeThisQuery = (MoreLikeThisQuery) booleanClause.query();
    private Item generateRandomItem() {
    }
        }
    }
import org.opensearch.action.termvectors.MultiTermVectorsRequest;
        return item;
            item.version(randomInt(5));
import java.util.HashMap;
        {
            + "    \"boost\" : 1.0\n"
import java.util.stream.Stream;
        String[] likeTexts = randomBoolean() ? null : new String[0];
        } else {
     * but for now we'd prefer to simply return the id as the content of the document and that for
        rewriteQuery(queryBuilder, new QueryShardContext(context));
    protected String[] shuffleProtectedFields() {
import org.apache.lucene.index.memory.MemoryIndex;
            for (BooleanClause booleanClause : booleanQuery) {
            int i = 0;
     * we don't want to shuffle the "doc" field internally in {@link #testFromXContent()} because even though the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        return doc;
            }
    /**
    private static Fields generateFields(String[] fieldNames, String text) throws IOException {
                        context.getIndexSettings().getSettings(),
        {
        assertThat(mltQuery.getMaxQueryTerms(), equalTo(12));
        QueryShardContext context = createShardContext();
    public void setup() {
            context.isCacheable()
        assertNotNull(rewriteQuery.toQuery(context));
import org.opensearch.action.termvectors.TermVectorsRequest;
        try {
        assertThat(e.getMessage(), containsString("requires 'fields' to be specified"));
import static org.hamcrest.Matchers.greaterThan;
                    newIndexMeta(
            queryBuilder.failOnUnsupportedField(randomBoolean());
        if (randomBoolean()) {
        if (randomBoolean()) {
                    .updateIndexMetadata(
    private static String[] randomFields;
        }
import java.util.HashSet;
        );
            + "}";
import org.opensearch.action.termvectors.MultiTermVectorsItemResponse;
        // indexed item or artificial document
                MoreLikeThisQueryBuilder builder = new MoreLikeThisQueryBuilder(new String[] { "hello world" }, null);
     */
     * documents would be functionally the same, their {@link BytesReference} representation isn't and thats what we
            queryBuilder.minTermFreq(randomInt(5));
 * the Apache License, Version 2.0 (the "License"); you may
            randomUnlikeItems[i] = generateRandomItem();
            () -> new MoreLikeThisQueryBuilder(new String[] { "name.first", "name.last" }, new String[] { "something" }, null)
        expectedItem.writeTo(output);
import org.apache.lucene.index.Fields;
import org.apache.lucene.search.Query;
        // doc contains arbitrary content, anything can be added to it and no exception will be thrown
            MultiTermVectorsItemResponse[] responses = new MultiTermVectorsItemResponse[mtvRequest.size()];
 * Licensed to Elasticsearch under one or more contributor
     * Check that this query is generally not cacheable, except when we fetch 0 items
        MoreLikeThisQuery mltQuery = (MoreLikeThisQuery) parsedQuery;
            queryBuilder.unlike(generateRandomStringArray(5, 5, false, false));
        Settings build = Settings.builder().put(oldIndexSettings).put(indexSettings).build();
        // specifically trigger case where query is not cacheable
            queryBuilder.maxQueryTerms(randomIntBetween(1, 25));
     * compare when check for equality of the original and the shuffled builder
    @Override
    @Override
    public void testItemFromXContent() throws IOException {
        Item item = randomBoolean() ? new Item(index, randomAlphaOfLength(10)) : new Item(index, randomArtificialDoc());
        MoreLikeThisQueryBuilder queryBuilder;
        randomUnlikeItems = new Item[randomIntBetween(1, 3)];
        queryBuilder = new MoreLikeThisQueryBuilder(randomStringFields(), null, new Item[] { new Item("foo", "1") });
        try {
                    assertThat(moreLikeThisQuery.getLikeFields().length, greaterThan(0));
 * GitHub history for details.
                }
    private static String[] randomStringFields() {
        }
    private static final String[] SHUFFLE_PROTECTED_FIELDS = new String[] { MoreLikeThisQueryBuilder.DOC.getPreferredName() };
        String[] mappedStringFields = new String[] { TEXT_FIELD_NAME, KEYWORD_FIELD_NAME, TEXT_ALIAS_FIELD_NAME };
            new String[] { unsupportedField },
            + "    }, {\n"
        assertNotNull(rewriteQuery.toQuery(context));
import org.opensearch.test.AbstractQueryTestCase;
            queryBuilder.boostTerms(randomFloat() * 10);
        if (randomBoolean()) {
        IllegalArgumentException e = expectThrows(
    protected QueryBuilder parseQuery(XContentParser parser) throws IOException {
        if (randomBoolean()) {
        assertEquals(expectedItem, newItem);
import org.opensearch.core.xcontent.ToXContent;
    }
                builder.toQuery(context);
            + "    \"minimum_should_match\" : \"30%\",\n"
import org.apache.lucene.search.BooleanClause;
import org.opensearch.core.common.util.CollectionUtils;
        assertEquals(
        );
    }
        assertEquals(json, "and potentially some more text here as well", parsed.likeTexts()[0]);
    private Map<String, String> randomPerFieldAnalyzer() {
        QueryBuilder rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
        String unsupportedField = randomFrom(INT_FIELD_NAME, DOUBLE_FIELD_NAME, DATE_FIELD_NAME);
        );
        if (randomBoolean()) {
        }
     * Here we could go overboard and use a pre-generated indexed random document for a given Item,
        }
        if (randomBoolean()) {
    private static Item[] randomLikeItems;
            queryBuilder.analyzer(randomAnalyzer());  // fix the analyzer?
import java.util.Arrays;
                            "index",
            item.versionType(randomFrom(VersionType.values()));
import org.junit.Before;
            "query should " + (isCacheable ? "" : "not") + " be cacheable: " + queryBuilder.toString(),
                context.getIndexSettings()
        }
    }
import java.util.Collections;
            isCacheable,
                        "index",
        assertFalse("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());
        // per field analyzer
 *
 * You may obtain a copy of the License at
        // specifically trigger case where query is cacheable
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
            + "    \"like\" : [ \"and potentially some more text here as well\", {\n"
    public void testCacheability() throws IOException {
        }
            assertThat(query, instanceOf(MoreLikeThisQuery.class));
import org.opensearch.OpenSearchException;
/*
import org.opensearch.common.xcontent.XContentFactory;
                } else {
                    generatedFields = generateFields(request.selectedFields().toArray(new String[0]), request.id());
        Item newItem = new Item(output.bytes().streamInput());
    /**
    @Override
        String[] likeTexts = null;
 * ownership. Elasticsearch licenses this file to you under
        // and for the unlike items too
        if (randomBoolean()) {
        if (randomBoolean()) {
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
    }
                Fields generatedFields;
            IllegalArgumentException.class,
    }
 * KIND, either express or implied.  See the License for the
            queryBuilder.minDocFreq(randomInt(5));
        }
        // MLT only supports string fields, unsupported fields are tested below
 */
        Item newItem = new Item(expectedItem);
        }
            BooleanQuery booleanQuery = (BooleanQuery) query;
        }
        for (String fieldName : fieldNames) {
 * The OpenSearch Contributors require contributions made to
            + "      \"_id\" : \"1\"\n"
 * specific language governing permissions and limitations
    protected MoreLikeThisQueryBuilder doCreateTestQueryBuilder() {
            + "    \"max_doc_freq\" : 2147483647,\n"
                    generatedFields = generateFields(randomFields, request.doc().utf8ToString());
                doc.field(field, randomAlphaOfLength(10));
    public void testItemSerialization() throws IOException {
    public void testFromJson() throws IOException {
        Item[] likeItems = randomBoolean() ? null : new Item[0];
            + "    \"boost_terms\" : 0.0,\n"
            item.perFieldAnalyzer(randomPerFieldAnalyzer());
        return query;
    public void testValidateEmptyLike() {
        assertThat(query, instanceOf(MoreLikeThisQueryBuilder.class));
import static org.hamcrest.Matchers.containsString;
 * this file be licensed under the Apache-2.0 license or a
            doc = XContentFactory.jsonBuilder().startObject();
                // Reset the default value
        }
    }
    }
        assertThat(mltQuery.getMinTermFrequency(), equalTo(1));
        Map<String, String> perFieldAnalyzer = new HashMap<>();
    }
            }
                TermVectorsResponse response = new TermVectorsResponse(request.index(), request.id());
        if (randomBoolean()) {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MoreLikeThisQueryBuilder(likeTexts, likeItems));
import org.opensearch.core.xcontent.XContentBuilder;
        }
            + "  }\n"
            () -> new MoreLikeThisQueryBuilder(new String[0], new String[] { "likeText" }, null)
            queryBuilder.include(randomBoolean());
            queryBuilder = new MoreLikeThisQueryBuilder(null, likeItems);
import org.opensearch.core.common.bytes.BytesReference;
            queryBuilder.maxWordLength(randomInt(25));
        assertEquals(json, 2, parsed.fields().length);
 * compatible open source license.
        ).toQuery(createShardContext());
        assertEquals(expectedItem, newItem);
        return queryBuilder;
                response.setExists(true);
        }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> queryBuilder.toQuery(createShardContext()));
            // we rely on integration tests for a deeper check here
    }
import org.opensearch.common.lucene.search.MoreLikeThisQuery;
        MoreLikeThisQueryBuilder queryBuilder = createTestQueryBuilder();
    }
            index.addField(fieldName, text, new WhitespaceAnalyzer());
    @Before
            try {
            + "    \"fields\" : [ \"title\", \"description\" ],\n"
        ).failOnUnsupportedField(true);
    private static Item[] randomUnlikeItems;
        return perFieldAnalyzer;
            queryBuilder.maxDocFreq(randomInt(100));
        randomFields = randomStringFields();
            + "    \"min_term_freq\" : 1,\n"
            + "      \"_index\" : \"imdb\",\n"
        String json = expectedItem.toXContent(XContentFactory.jsonBuilder(), ToXContent.EMPTY_PARAMS).toString();
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> builder.toQuery(context));
 * under the License.
                if (request.doc() != null) {
            queryBuilder.minimumShouldMatch(randomMinimumShouldMatch());
            queryBuilder = new MoreLikeThisQueryBuilder(randomFields, likeTexts, likeItems);
            + "      \"_index\" : \"imdb\",\n"
        }
        context = createShardContext();
    public void testDefaultField() throws IOException {
        } catch (IOException e) {
    }
    protected void doAssertLuceneQuery(MoreLikeThisQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
                    )
                );
        } catch (IOException ex) {
        }
    }
    }
                }
        XContentBuilder doc;
    protected Set<String> getObjectsHoldingArbitraryContent() {
    private static IndexMetadata newIndexMeta(String name, Settings oldIndexSettings, Settings indexSettings) {
}
        return index.createSearcher().getIndexReader().termVectors().get(0);
 * Unless required by applicable law or agreed to in writing,
    public void testValidateEmptyFields() {
    }
import org.apache.lucene.search.BooleanQuery;
        return SHUFFLE_PROTECTED_FIELDS;
            return new MultiTermVectorsResponse(responses);
import org.opensearch.index.VersionType;
        assertEquals(expectedItem, newItem);
        Item newItem = Item.parse(parser, new Item());
            item.routing(randomAlphaOfLength(10));
        if (CollectionUtils.isEmpty(queryBuilder.likeItems()) == false) {
            + "    \"include\" : false,\n"
import org.opensearch.action.termvectors.MultiTermVectorsResponse;
            throw new OpenSearchException("boom", ex);
import java.util.EnumSet;
            perFieldAnalyzer.put(field, randomAnalyzer());
        if (randomBoolean()) {
        for (String field : randomFields) {
        if (randomBoolean()) {
            new String[] { "some text" },
                .maxQueryTerms(0)
        }
        Item expectedItem = generateRandomItem();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.query.MoreLikeThisQueryBuilder.Item;
        }
            + "  \"more_like_this\" : {\n"
public class MoreLikeThisQueryBuilderTests extends AbstractQueryTestCase<MoreLikeThisQueryBuilder> {
        QueryShardContext context = createShardContext();
        } else {
                if (booleanClause.query() instanceof MoreLikeThisQuery) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        String[] unmappedStringFields = generateRandomStringArray(2, 5, false, false);
    @Override
            queryBuilder.unlike(randomUnlikeItems);
            IllegalArgumentException.class,
            }
import static org.hamcrest.Matchers.instanceOf;
    }
            } finally {
    private XContentBuilder randomArtificialDoc() {
    }
            null
            for (TermVectorsRequest request : mtvRequest) {
     * every field.
        assertThat(e2.getMessage(), containsString("requires 'maxQueryTerms' to be greater than 0"));
            + "    \"min_word_length\" : 0,\n"
        if (randomBoolean()) {
    }
        }
        if (randomBoolean()) {
        assertThat(e.getMessage(), containsString("more_like_this only supports text/keyword fields"));
import org.opensearch.common.xcontent.json.JsonXContent;
    }
            likeTexts = generateRandomStringArray(5, 5, false, false);
    /**
        if (randomBoolean()) {
        }
            for (String field : randomFields) {
        assertTrue("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());
        }
        assertThat(mltQuery.getLikeText(), equalTo("something"));
                    );
    private Set<String> assertedWarnings = new HashSet<>();
        assertThat(mltQuery.getMoreLikeFields()[0], equalTo("name.first"));
        boolean isCacheable = queryBuilder.likeItems().length == 0; // items are always fetched
                        newIndexMeta(
    @Override
        randomLikeItems = new Item[randomIntBetween(1, 3)];
                EnumSet<TermVectorsRequest.Flag> flags = EnumSet.of(TermVectorsRequest.Flag.Positions, TermVectorsRequest.Flag.Offsets);
        QueryBuilder query = super.parseQuery(parser);
        checkGeneratedJson(json, parsed);
        rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
        );
        String json = "{\n"
        }
            randomLikeItems[i] = generateRandomItem();
        MoreLikeThisQueryBuilder queryBuilder = new MoreLikeThisQueryBuilder(
 *
                            context.getIndexSettings().getSettings(),
            doc.endObject();
            IllegalArgumentException.class,
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
    public void testItemCopy() throws IOException {
            MoreLikeThisQueryBuilder builder = new MoreLikeThisQueryBuilder(new String[] { "hello world" }, null);
        Item expectedItem = generateRandomItem();
                .updateIndexMetadata(
     */
import static org.hamcrest.Matchers.equalTo;
        assertThat(parsedQuery, instanceOf(MoreLikeThisQuery.class));
        Item[] likeItems = null;
            likeItems = randomLikeItems;
import org.opensearch.cluster.metadata.IndexMetadata;
        String index = randomBoolean() ? getIndex().getName() : null;
 */
            + "    \"max_word_length\" : 0,\n"
