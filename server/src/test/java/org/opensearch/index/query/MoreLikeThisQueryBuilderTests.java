                    .updateIndexMetadata(  
        if (randomBoolean()) {  
import java.util.Collections;
        }  
import static org.hamcrest.Matchers.greaterThan;  
            for (BooleanClause booleanClause : booleanQuery) {
            assertThat(query, instanceOf(MoreLikeThisQuery.class));  
    private static final String[] SHUFFLE_PROTECTED_FIELDS = new String[] { MoreLikeThisQueryBuilder.DOC.getPreferredName() };
            queryBuilder.analyzer(randomAnalyzer());  // fix the analyzer?
package org.opensearch.index.query;
 */
        } else {
            for (TermVectorsRequest request : mtvRequest) {  
 * this work for additional information regarding copyright
import java.util.HashMap;  
        } catch (IOException e) {
/*  
            "query should " + (isCacheable ? "" : "not") + " be cacheable: " + queryBuilder.toString(),
    @Override
import org.opensearch.action.termvectors.MultiTermVectorsRequest;  
        // MLT only supports string fields, unsupported fields are tested below  
            randomLikeItems[i] = generateRandomItem();
import java.util.HashSet;
    }  
        String[] likeTexts = null;
    private static Item[] randomLikeItems;
            IllegalArgumentException.class,  
        assertEquals(expectedItem, newItem);  
    }
import org.opensearch.action.termvectors.MultiTermVectorsResponse;
        if (randomBoolean()) {  
        assertThat(mltQuery.getMinTermFrequency(), equalTo(1));
    private static Item[] randomUnlikeItems;  
        String unsupportedField = randomFrom(INT_FIELD_NAME, DOUBLE_FIELD_NAME, DATE_FIELD_NAME);
        assertEquals(expectedItem, newItem);
        assertThat(mltQuery.getMaxQueryTerms(), equalTo(12));  
            } finally {  
    }
            for (String field : randomFields) {
        QueryShardContext context = createShardContext();
            () -> new MoreLikeThisQueryBuilder(new String[] { "name.first", "name.last" }, new String[] { "something" }, null)
import org.opensearch.core.xcontent.ToXContent;  
            + "    \"max_doc_freq\" : 2147483647,\n"
            queryBuilder.unlike(generateRandomStringArray(5, 5, false, false));
            isCacheable,
            + "    \"boost_terms\" : 0.0,\n"
            + "    \"boost\" : 1.0\n"
        assertThat(query, instanceOf(MoreLikeThisQueryBuilder.class));
            assertThat(e.getMessage(), containsString("[more_like_this] query cannot infer"));  
import org.opensearch.common.lucene.search.MoreLikeThisQuery;  
        if (randomBoolean() && queryBuilder.fields() != null) {  
            try {  
        assertThat(e.getMessage(), containsString("requires 'fields' to be specified"));  
            likeTexts = generateRandomStringArray(5, 5, false, false);
            + "    \"min_term_freq\" : 1,\n"
import static org.hamcrest.Matchers.equalTo;
            BooleanQuery booleanQuery = (BooleanQuery) query;  
        MoreLikeThisQueryBuilder queryBuilder = new MoreLikeThisQueryBuilder(  
        QueryBuilder rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
                if (request.doc() != null) {
                response.setExists(true);
        if (randomBoolean()) {  
    }
        if (CollectionUtils.isEmpty(queryBuilder.likeItems()) == false) {
        if (randomBoolean()) {  
        MoreLikeThisQueryBuilder parsed = (MoreLikeThisQueryBuilder) parseQuery(json);  
        return queryBuilder;  
            () -> new MoreLikeThisQueryBuilder(new String[0], new String[] { "likeText" }, null)
        MoreLikeThisQueryBuilder queryBuilder = createTestQueryBuilder();
                builder.toQuery(context);
        }
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(json, 2, parsed.fields().length);  
    public void testDefaultField() throws IOException {  
                doc.field(field, randomAlphaOfLength(10));
        }
            + "    \"include\" : false,\n"  
        // specifically trigger case where query is not cacheable
            + "    \"fields\" : [ \"title\", \"description\" ],\n"
import java.util.stream.Stream;
    @Override
            context.isCacheable()  
import org.opensearch.index.query.MoreLikeThisQueryBuilder.Item;
            + "      \"_id\" : \"2\"\n"
        String json = expectedItem.toXContent(XContentFactory.jsonBuilder(), ToXContent.EMPTY_PARAMS).toString();
        try {  
        {  
 * KIND, either express or implied.  See the License for the
    }  
        queryBuilder = new MoreLikeThisQueryBuilder(randomStringFields(), new String[] { "some text" }, null);
 * Unless required by applicable law or agreed to in writing,
    }
        assertNotNull(rewriteQuery.toQuery(context));
        rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
    public void testItemCopy() throws IOException {  
                MoreLikeThisQueryBuilder builder = new MoreLikeThisQueryBuilder(new String[] { "hello world" }, null);
    }
        for (int i = 0; i < randomLikeItems.length; i++) {
            context.getIndexSettings()
            + "}";
                    assertThat(moreLikeThisQuery.getLikeFields().length, greaterThan(0));
    }  
                .maxQueryTerms(12)
        if (randomBoolean() && CollectionUtils.isEmpty(likeItems) == false) { // for the default field  
        }
        }
 * this file be licensed under the Apache-2.0 license or a
        String[] unmappedStringFields = generateRandomStringArray(2, 5, false, false);
 * license agreements. See the NOTICE file distributed with
        Query parsedQuery = parseQuery(  
    @Override
            null  
import org.opensearch.core.xcontent.XContentParser;
        if (randomBoolean()) {
        for (String field : randomFields) {
    }  
    public void testCacheability() throws IOException {  
        randomUnlikeItems = new Item[randomIntBetween(1, 3)];
        context = createShardContext();
        );
            }  
        if (randomBoolean()) {  
        // per field analyzer
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.util.CollectionUtils;
            queryBuilder = new MoreLikeThisQueryBuilder(null, likeItems);
    }
            item.fields(randomFrom(randomFields));  
        } else {  
 * specific language governing permissions and limitations
import java.util.EnumSet;
    }
    protected MoreLikeThisQueryBuilder doCreateTestQueryBuilder() {
    public void testMoreLikeThisBuilder() throws Exception {
            queryBuilder.minimumShouldMatch(randomMinimumShouldMatch());
        return doc;
        // if no field is specified MLT uses all mapped fields for this item
                .maxQueryTerms(0)
     * but for now we'd prefer to simply return the id as the content of the document and that for  
    /**  
                .maxQueryTerms(-3)
        {  
}  
                );
    private static String[] randomStringFields() {
        String[] mappedStringFields = new String[] { TEXT_FIELD_NAME, KEYWORD_FIELD_NAME, TEXT_ALIAS_FIELD_NAME };  
     */
        assertThat(e1.getMessage(), containsString("requires 'maxQueryTerms' to be greater than 0"));  
                } else {  
        Item expectedItem = generateRandomItem();
    private Item generateRandomItem() {
        }
        }
    public void testUnsupportedFields() throws IOException {
import org.opensearch.index.VersionType;  
        if (randomBoolean()) {  
            MultiTermVectorsItemResponse[] responses = new MultiTermVectorsItemResponse[mtvRequest.size()];
import org.junit.Before;  
        // we also preset the item requests
        );  
                        "index",
        XContentBuilder doc;
        Item[] likeItems = randomBoolean() ? null : new Item[0];
    public void testFromJson() throws IOException {
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.opensearch.action.termvectors.MultiTermVectorsItemResponse;
 *  
        BytesStreamOutput output = new BytesStreamOutput();  
        if (randomBoolean()) {  
        rewriteQuery(queryBuilder, new QueryShardContext(context));  
        );
        assertThat(e2.getMessage(), containsString("requires 'maxQueryTerms' to be greater than 0"));
        }
        if (randomBoolean()) {  
import org.apache.lucene.index.memory.MemoryIndex;  
                responses[i++] = new MultiTermVectorsItemResponse(response, null);
        if (randomBoolean()) {  
            + "    }, {\n"  
     * Check that this query is generally not cacheable, except when we fetch 0 items  
import java.util.Map;
        }
    }
        }
import static org.hamcrest.Matchers.instanceOf;
    public void testValidateEmptyLike() {  
        Map<String, String> perFieldAnalyzer = new HashMap<>();  
        }
import java.util.Arrays;  
        return item;  
import org.opensearch.OpenSearchException;
                            "index",
 * SPDX-License-Identifier: Apache-2.0
            assertThat(query, instanceOf(BooleanQuery.class));
        }
 *
        boolean isCacheable = queryBuilder.likeItems().length == 0; // items are always fetched
    @Before
                .updateIndexMetadata(
        Item item = randomBoolean() ? new Item(index, randomAlphaOfLength(10)) : new Item(index, randomArtificialDoc());
    }
        IllegalArgumentException e2 = expectThrows(
    protected void doAssertLuceneQuery(MoreLikeThisQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
        return query;
            perFieldAnalyzer.put(field, randomAnalyzer());
import org.opensearch.core.xcontent.XContentBuilder;
        String json = "{\n"  
        if (randomBoolean()) {  
        assertTrue("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());  
import org.apache.lucene.search.BooleanQuery;
            item.versionType(randomFrom(VersionType.values()));
            IllegalArgumentException.class,
            doc.endObject();
            queryBuilder.include(randomBoolean());
                context.getIndexSettings()
            + "    \"fail_on_unsupported_field\" : true,\n"
import org.opensearch.common.xcontent.XContentFactory;
    private static IndexMetadata newIndexMeta(String name, Settings oldIndexSettings, Settings indexSettings) {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MoreLikeThisQueryBuilder(likeTexts, likeItems));  
 */  
import org.opensearch.action.termvectors.TermVectorsRequest;
    private static Fields generateFields(String[] fieldNames, String text) throws IOException {  
        assertEquals(expectedItem, newItem);  
        for (String fieldName : fieldNames) {
            + "      \"_index\" : \"imdb\",\n"
    /**
 * GitHub history for details.
    public void testValidateMaxQueryTerms() {  
import java.io.IOException;
                    generatedFields = generateFields(randomFields, request.doc().utf8ToString());
        }
import org.apache.lucene.index.Fields;
import org.opensearch.cluster.metadata.IndexMetadata;
            queryBuilder.stopWords(generateRandomStringArray(5, 5, false, false));
        // and for the unlike items too
            }  
        rewriteQuery(queryBuilder, new QueryShardContext(context));
 * compatible open source license.
    @Override
        // specifically trigger case where query is cacheable  
        }
            return new MultiTermVectorsResponse(responses);
        String[] likeTexts = randomBoolean() ? null : new String[0];
        return Collections.singleton(MoreLikeThisQueryBuilder.DOC.getPreferredName());
    @Override
        if (randomBoolean()) {  
        if (randomBoolean()) {  
        }
                response.setFields(generatedFields, request.selectedFields(), flags, generatedFields);
     * we don't want to shuffle the "doc" field internally in {@link #testFromXContent()} because even though the
    @Override
            + "    \"min_word_length\" : 0,\n"
    }  
            }
            index.addField(fieldName, text, new WhitespaceAnalyzer());  
    private Set<String> assertedWarnings = new HashSet<>();
        }
        assertEquals(  
            queryBuilder.minWordLength(randomInt(5));
                        context.getIndexSettings().getSettings(),
            throw new OpenSearchException("Unable to generate random artificial doc!");  
 * Modifications Copyright OpenSearch Contributors. See
        IllegalArgumentException e1 = expectThrows(
        Item[] likeItems = null;
import org.opensearch.core.common.bytes.BytesReference;
    public void testItemFromXContent() throws IOException {  
        Item newItem = new Item(expectedItem);
        assertThat(mltQuery.getLikeText(), equalTo("something"));
        }
            + "    \"max_word_length\" : 0,\n"  
    }
        }
        Item expectedItem = generateRandomItem();
 * under the License.  
            queryBuilder.maxWordLength(randomInt(25));
        }
        }
        MemoryIndex index = new MemoryIndex();
        for (int i = 0; i < randomUnlikeItems.length; i++) {  
            randomUnlikeItems[i] = generateRandomItem();
            queryBuilder.minTermFreq(randomInt(5));
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
    protected QueryBuilder parseQuery(XContentParser parser) throws IOException {
            queryBuilder.unlike(randomUnlikeItems);
        randomLikeItems = new Item[randomIntBetween(1, 3)];  
    /**
     * Here we could go overboard and use a pre-generated indexed random document for a given Item,
                }
        }
        QueryShardContext context = createShardContext();  
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);  
    public void setup() {
            + "      \"_id\" : \"1\"\n"
            new String[] { unsupportedField },
import org.opensearch.common.settings.Settings;
        queryBuilder = new MoreLikeThisQueryBuilder(randomStringFields(), null, new Item[] { new Item("foo", "1") });  
            queryBuilder.maxQueryTerms(randomIntBetween(1, 25));
    private XContentBuilder randomArtificialDoc() {  
                    MoreLikeThisQuery moreLikeThisQuery = (MoreLikeThisQuery) booleanClause.query();  
            item.version(randomInt(5));
import org.apache.lucene.search.BooleanClause;
            doc = XContentFactory.jsonBuilder().startObject();  
            item.perFieldAnalyzer(randomPerFieldAnalyzer());
    }
        }  
        Item expectedItem = generateRandomItem();
 * not use this file except in compliance with the License.
            queryBuilder.minDocFreq(randomInt(5));
                TermVectorsResponse response = new TermVectorsResponse(request.index(), request.id());
                    )
        context = createShardContext();
        }
 * The OpenSearch Contributors require contributions made to  
        return index.createSearcher().getIndexReader().termVectors().get(0);
                    generatedFields = generateFields(request.selectedFields().toArray(new String[0]), request.id());
        } catch (IOException ex) {
 *
                            Settings.builder().putList("index.query.default_field", "*").build()
        assertFalse("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());
        return IndexMetadata.builder(name).settings(build).build();
            IllegalArgumentException.class,  
        }
                    newIndexMeta(  
        }
        checkGeneratedJson(json, parsed);
        }
            throw new OpenSearchException("boom", ex);  
    }
        // like field is required  
            queryBuilder = new MoreLikeThisQueryBuilder(randomFields, likeTexts, likeItems);  
        randomFields = randomStringFields();
    protected String[] shuffleProtectedFields() {  
     * every field.
        return Stream.concat(Arrays.stream(mappedStringFields), Arrays.stream(unmappedStringFields)).toArray(String[]::new);
        assertEquals(json, "and potentially some more text here as well", parsed.likeTexts()[0]);
            MoreLikeThisQueryBuilder builder = new MoreLikeThisQueryBuilder(new String[] { "hello world" }, null);
        IllegalArgumentException e = expectThrows(
 * software distributed under the License is distributed on an
        assertThat(mltQuery.getMoreLikeFields()[0], equalTo("name.first"));  
        ).failOnUnsupportedField(true);
 * You may obtain a copy of the License at  
        // indexed item or artificial document
        }
    }
            // we rely on integration tests for a deeper check here
        try {
            () -> new MoreLikeThisQueryBuilder(new String[] { "name.first", "name.last" }, new String[] { "something" }, null)  
        }
        if (randomBoolean()) {  
        MoreLikeThisQuery mltQuery = (MoreLikeThisQuery) parsedQuery;
    }  
    }
    @Override
        return SHUFFLE_PROTECTED_FIELDS;
                            context.getIndexSettings().getSettings(),  
    public void testItemSerialization() throws IOException {
     * compare when check for equality of the original and the shuffled builder  
import org.apache.lucene.search.Query;  
            int i = 0;
            queryBuilder.failOnUnsupportedField(randomBoolean());
    }  
 */  
 * ownership. Elasticsearch licenses this file to you under  
                // Reset the default value
     */
        assertNotNull(rewriteQuery.toQuery(context));
        Item newItem = new Item(output.bytes().streamInput());
                }
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> builder.toQuery(context));
        rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));  
        if (randomBoolean()) {  
        expectedItem.writeTo(output);
        Settings build = Settings.builder().put(oldIndexSettings).put(indexSettings).build();  
    public void testValidateEmptyFields() {
            new String[] { "some text" },
            + "    \"max_query_terms\" : 12,\n"
                    );  
            item.routing(randomAlphaOfLength(10));
                        Settings.builder().putList("index.query.default_field", TEXT_FIELD_NAME).build()  
        if (randomBoolean()) {  
    private Map<String, String> randomPerFieldAnalyzer() {
        }
        if (randomBoolean()) {
            + "    \"minimum_should_match\" : \"30%\",\n"
     * documents would be functionally the same, their {@link BytesReference} representation isn't and thats what we
        ).toQuery(createShardContext());  
import org.opensearch.test.AbstractQueryTestCase;
            queryBuilder.maxDocFreq(randomInt(100));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> queryBuilder.toQuery(createShardContext()));
                        newIndexMeta(
        QueryBuilder query = super.parseQuery(parser);  
            likeItems = randomLikeItems;
        if (randomBoolean()) {  
        }
        assertThat(e.getMessage(), containsString("requires either 'like' texts or items to be specified"));
        assertThat(parsedQuery, instanceOf(MoreLikeThisQuery.class));
/*
    protected Set<String> getObjectsHoldingArbitraryContent() {
        String index = randomBoolean() ? getIndex().getName() : null;  
            + "  }\n"  
        assertNotNull(rewriteQuery.toQuery(context));
public class MoreLikeThisQueryBuilderTests extends AbstractQueryTestCase<MoreLikeThisQueryBuilder> {  
        assertThat(e.getMessage(), containsString("more_like_this only supports text/keyword fields"));  
        if (randomBoolean()) {  
        Item newItem = Item.parse(parser, new Item());
            + "    } ],\n"  
import java.util.Set;  
    }
            + "  \"more_like_this\" : {\n"
import org.opensearch.common.io.stream.BytesStreamOutput;
            queryBuilder.boostTerms(randomFloat() * 10);
/*  
        } else {
        MoreLikeThisQueryBuilder queryBuilder;  
        );
import static org.opensearch.index.query.QueryBuilders.moreLikeThisQuery;  
            + "    \"min_doc_freq\" : 5,\n"  
    private static String[] randomFields;
     */
                EnumSet<TermVectorsRequest.Flag> flags = EnumSet.of(TermVectorsRequest.Flag.Positions, TermVectorsRequest.Flag.Offsets);  
                Fields generatedFields;  
            moreLikeThisQuery(new String[] { "name.first", "name.last" }, new String[] { "something" }, null).minTermFreq(1)
                        )
import static org.hamcrest.Matchers.containsString;
            + "    \"like\" : [ \"and potentially some more text here as well\", {\n"  
            + "      \"_index\" : \"imdb\",\n"
import org.opensearch.action.termvectors.TermVectorsResponse;  
import org.opensearch.common.xcontent.json.JsonXContent;  
                if (booleanClause.query() instanceof MoreLikeThisQuery) {
        return perFieldAnalyzer;
    protected MultiTermVectorsResponse executeMultiTermVectors(MultiTermVectorsRequest mtvRequest) {
            }  
        // doc contains arbitrary content, anything can be added to it and no exception will be thrown  
    }
