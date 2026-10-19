        if (query != null) {
        candidates.addAll(getAlternateVersions().keySet());  
import org.opensearch.index.query.support.QueryParsers;  
        return copyWriteable(query, namedWriteableRegistry(), reader);
            QueryBuilder rewritten = rewriteQuery(firstQuery, new QueryShardContext(context));
    }  
import org.opensearch.Version;  
     * {
    /**
     */
                );  
                    while ((token = parser.nextToken()) != null) {  
     *     }
     * recursive random shuffling in the {@link #testFromXContent()} test case
                if (expectedException == false) {
        return results;  
import org.opensearch.index.query.QueryBuilders;
                .append(size)  
 * The OpenSearch Contributors require contributions made to  
                    rewrite(firstLuceneQuery)
     */
    /**
            assertThat(boostQuery.getBoost(), equalTo(fieldBoost));
                controlQuery.hashCode(),
    protected static String getRandomRewriteMethod() {  
    protected String[] shuffleProtectedFields() {
 * Unless required by applicable law or agreed to in writing,
        }
        // extra safety to fail fast - serialize the rewritten version to ensure it's serializable.
                break;
        boolean hasArbitraryContent = (arbitraryMarkers != null && arbitraryMarkers.isEmpty() == false);
import org.opensearch.common.xcontent.XContentFactory;
        XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();  
        QB queryBuilder = createTestQueryBuilder();
     * {@link AbstractQueryTestCase#DATE_FIELD_NAME} or {@link AbstractQueryTestCase#DATE_NANOS_FIELD_NAME} or a String value by default
                }  
                .append(" vs.")  
import org.joda.time.DateTime;
                testQuery,
        assertEquals("[" + queryName + "] query malformed, no start_object after query name", e.getMessage());  
                        // We reached the expected insertion point, so next time we'll try one step further
        } else {  
    protected static Fuzziness randomFuzziness(String fieldName) {
     *             "newField" : {
                    int objectIndex = -1;
     * Every mutation is then added to the list of results with a boolean flag indicating if a parsing exception is expected or not
                    BoostQuery boostQuery = (BoostQuery) query;
            if (randomBoolean()) {
            assertNotNull("toQuery should not return null", secondLuceneQuery);
            int leftEnd = Math.max(size, left.length()) - 1;
            }  
                return Fuzziness.build(1 + randomFloat() * 10);  
        for (int runs = 0; runs < NUMBER_OF_TESTQUERIES; runs++) {
     *                 "value" : "foo"
        QueryBuilder returnedQuerybuilder = queryBuilder.filter(null);  
     * Generic test that creates new query from the test query and checks both for equality
                    .append(" vs.")  
    public void testFromXContent() throws IOException {
        QB testQuery;
     * Test that unknown field trigger ParsingException.  
                } else {
            } catch (ParsingException | OpenSearchParseException | XContentParseException e) {
     * <li> Manually check that what the QueryBuilder generates equals the input json ignoring default options.
            default:
public abstract class AbstractQueryTestCase<QB extends AbstractQueryBuilder<QB>> extends AbstractBuilderTestCase {
     * }
 * software distributed under the License is distributed on an
     * Note: By the time of this writing (Nov 2015) all queries are taken from the query dsl
        }  
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> testQuery.boost(-0.5f));  
                    .append(" [")
     * {@link AbstractQueryTestCase#DOUBLE_FIELD_NAME}, {@link AbstractQueryTestCase#TEXT_FIELD_NAME} or  
     * should overwrite this method and make sure the different cases are always tested  
import java.util.LinkedList;
                value = Instant.now().toString();
        queryWrappedInArrayTest(queryName, validQuery);
                BytesStreamOutput out = new BytesStreamOutput();
                            levels.addLast(parser.currentName());
        return Collections.emptyMap();
/*
            // TODO we only change name and boost, we should extend by any sub-test supplying a "mutate" method that randomly changes one  
            assertThat(e.getMessage(), containsString("bogusField"));  
                    "two equivalent query builders lead to different lucene queries hashcode",
     * These queries must override this method accordingly.
                    throw new AssertionError("unexpected exception when parsing query:\n" + testQuery, e);  
     */
    private static final int NUMBER_OF_TESTQUERIES = 20;  
    protected QueryBuilder parseQuery(String queryAsString) throws IOException {  
        assertEquals(expectedQuery.hashCode(), newQuery.hashCode());
                            levels.removeLast();
 * this work for additional information regarding copyright
    }
    protected static String getRandomQueryText() {  
                );
            assertParsedQuery(createParser(mediaType.xContent(), toString), testQuery);
        return randomFrom("1", "-1", "75%", "-25%", "2<75%", "2<-25%");  
                .append(" [")
        }
                QueryBuilder deserializedQuery = in.readNamedWriteable(QueryBuilder.class);
        assertEquals(expectedQuery, newQuery);
    }
                );
                    if (boostQuery.getQuery() instanceof MatchNoDocsQuery == false) {  
    }
        Rewriteable.rewriteAndFetch(builder, context, future);
                if (query instanceof BoostQuery) {
     * assertions being made on the result to the implementing subclass.
        assertSerialization(rewritten);  
    protected QueryBuilder assertSerialization(QueryBuilder testQuery) throws IOException {  
     *         }  
import static org.hamcrest.Matchers.either;  
    }
                                generator.copyCurrentStructure(parser);
     */
        QueryBuilder parseInnerQueryBuilder = parseInnerQueryBuilder(parser);  
        assertTrue(returnedQuerybuilder instanceof BoolQueryBuilder);
        QueryShardContext context = createShardContext();
                );
     * Check if a filter can be applied to the abstract query builder.
     * doesn't parse it as it isn't supported. This method allows to disable query name related tests for those queries.
     *         }
        if (supportsBoost && randomBoolean()) {
        QueryBuilder rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
        if (fieldBoost != AbstractQueryBuilder.DEFAULT_BOOST) {
        List<Tuple<String, Boolean>> results = new ArrayList<>();
        assertEquals(queryBuilder, returnedQuerybuilder);
    }
    /**  
    }
    private static String msg(String left, String right) {
package org.opensearch.test;
        returnedQuerybuilder = queryBuilder.filter(filter);
        }
     *         "field" : {  
        return rewritten;
     * object encountered.  
                return Fuzziness.build(randomIntBetween(3, 100));
                        }  
}  
            Query namedQuery = context.copyNamedQueries().get(queryBuilder.queryName());
     */
                    JsonStringEncoder encoder = JsonStringEncoder.getInstance();
            builder.append(randomAlphaOfLengthBetween(1, 10)).append(" ");
                    }
            }
            XContentType xContentType = randomFrom(XContentType.values());
        assertThat(i, greaterThan(0));  
        }
     */  
        return randomFrom("simple", "standard", "keyword", "whitespace");
     * and {@link QueryShardContext}. Contains the query specific checks to be implemented by subclasses.  
     * Parses the query provided as string argument and compares it with the expected result provided as argument as a {@link QueryBuilder}  
    public void testNegativeBoosts() {
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            }  
    // we use the streaming infra to create a copy of the query provided as argument  
        }
            assertSerialization(testQuery);
    /**
            } else {  
                        // We did not reach the insertion point, there's no more mutations to try
import tools.jackson.core.io.JsonStringEncoder;
        int size = Math.min(left.length(), right.length());  
    }  
            Query secondLuceneQuery = rewriteQuery(secondQuery, context).toQuery(context);
        context.setAllowUnmappedFields(true);  
            output.setVersion(version);  
                + "1";
import java.util.HashSet;  
import java.util.Map;
     *         }
        assertEquals(msg(expected, builder.toString()), expected.replaceAll("\\s+", ""), builder.toString().replaceAll("\\s+", ""));
import org.opensearch.index.query.BoolQueryBuilder;  
                    );
                parseQuery(testQuery.v1());  
import org.opensearch.core.xcontent.NamedXContentRegistry;
        return createTestQueryBuilder(supportsBoost(), supportsQueryName());  
            );  
     * Traverses the json tree of the valid query provided as argument and mutates it one or more times by adding one object within each
        String testQuery = validQuery.substring(0, insertionPosition)
            assert context.isCacheable();
            return builder.toString();
 * Modifications Copyright OpenSearch Contributors. See
                if (expectedException == false) {
            }
    public void testEqualsAndHashcode() {
                    + controlQuery,
import java.util.Set;
     */
        Object value;
    }
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry())) {
     * Test that wraps the randomly generated query into an array as follows: { "query_name" : [{}]}  
import org.opensearch.core.xcontent.MediaType;  
            context = new QueryShardContext(context);  
    /**
     */  
            }  
     *     }
    }
        if (queryBuilder.queryName() != null && query instanceof MatchNoDocsQuery == false) {  
import java.util.Collections;
     * and asserts equality on the two queries.  
     * Serialize the given query builder and asserts that both are equal
    public void testFilter() throws IOException {
        doAssertLuceneQuery(queryBuilder, query, context);
        try (BytesStreamOutput output = new BytesStreamOutput()) {
     */
     *             "field" : {  
        if (randomBoolean()) {
        assertNull(parser.nextToken());
     */  
        StringBuilder builder = new StringBuilder("size: " + left.length() + " vs. " + right.length());
                assertParsedQuery(createParser(JsonXContent.jsonXContent, queryAsString), alternateVersion.getValue());
     * Those queries are easy to identify: their parsers don't parse {@code boost} as they don't apply to the specific query:
                        if (token == XContentParser.Token.START_ARRAY) {
    protected abstract QB doCreateTestQueryBuilder();
        assertEquals(expectedQuery, newQuery);  
        }
 * not use this file except in compliance with the License.
        QB testQuery = createTestQueryBuilder();
            if (builderGeneratesCacheableQueries()) {
     * <li> Take a reference documentation example.
                randomBoolean(),
        switch (fieldName) {
        for (int runs = 0; runs < NUMBER_OF_TESTQUERIES; runs++) {  
                    firstLuceneQuery.hashCode()  
     * cases no exception would get thrown.
        } while (testQuery.toString().contains(marker));
    static List<Tuple<String, Boolean>> alterateQueries(Set<String> queries, Set<String> arbitraryMarkers) throws IOException {  
    public void testCacheability() throws IOException {
                value = new DateTime(System.currentTimeMillis(), DateTimeZone.UTC).toString();
     *         "newField" : {
                    .append((int) left.charAt(i))  
     * wrapper query and {@code match_none}.  
import java.util.List;
    /**
            int mutation = 0;
        QueryBuilder newQuery = parseQuery(queryAsString);  
    protected boolean builderGeneratesCacheableQueries() {
                        } else if (token == XContentParser.Token.END_OBJECT || token == XContentParser.Token.END_ARRAY) {
    }
            testQuery = createTestQueryBuilder();  
                    XContentParser.Token token;
import java.util.Deque;
    protected abstract void doAssertLuceneQuery(QB queryBuilder, Query query, QueryShardContext context) throws IOException;
     * <p>
     * <li> Now copy the generated json including default options into createParseableQueryJson  
    protected QueryBuilder parseQuery(AbstractQueryBuilder<?> builder) throws IOException {
        }
                                generator.writeEndObject();  
                // of mutation, so no simple asserts possible here  
    /**  
            case DATE_NANOS_FIELD_NAME:  
import org.opensearch.core.xcontent.MediaTypeRegistry;
                                            break;
    /**
                String queryAsString = alternateVersion.getKey();  
                    rewrite(firstLuceneQuery),
        try {
                assertNotSame(testQuery, deserializedQuery);
import org.joda.time.DateTimeZone;
            QB controlQuery = copyQuery(firstQuery);
        return "";  
     * doesn't parse it as it isn't supported. This method allows to disable boost related tests for those queries.  
            if (validQuery.charAt(insertionPosition) == ':') {
        String marker = "#marker#";  
        List<Tuple<String, Boolean>> testQueries = alterateQueries(candidates, getObjectsHoldingArbitraryContent());
    /**
                        break;
        for (insertionPosition = i; insertionPosition < validQuery.length(); insertionPosition++) {  
import org.opensearch.index.query.QueryBuilder;
    protected QueryBuilder assertSerialization(QueryBuilder testQuery, Version version) throws IOException {
        QB queryBuilder = createTestQueryBuilder();
        PlainActionFuture<QueryBuilder> future = new PlainActionFuture<>();
                .append("until offset: ")
        return query;
    private void queryWrappedInArrayTest(String queryName, String validQuery) {
        return true;  
            for (Map.Entry<String, QB> alternateVersion : getAlternateVersions().entrySet()) {
        }
     * and {@link QueryShardContext}. Verifies that named queries and boost are properly handled and delegates to
                if (expectedException) {
            assertLuceneQuery(firstQuery, firstLuceneQuery, context);
     * To find the right position in the root query, we add a marker as `queryName` which
                    return Fuzziness.fromEdits(randomIntBetween(0, 2));
    }
                try (
                            if (objectIndex == mutation) {
import org.opensearch.core.xcontent.XContentParser;
/*  
import static org.hamcrest.Matchers.greaterThan;
                assertThat(e.getMessage(), containsString("unknown field [newField]"));
 * specific language governing permissions and limitations
            case DATE_FIELD_NAME:
                break;
            query = boostQuery.getQuery();  
                assertEquals(testQuery.hashCode(), deserializedQuery.hashCode());  
            secondQuery.boost(original.boost() + 1f + randomFloat());
        QB secondQuery = copyQuery(original);
import java.io.IOException;
        }
     *             "value" : "foo"  
 */  
            fail("expected ParsingException or XContentParsingException");  
    public void testValidOutput() throws IOException {
                builder.append(left.charAt(i));
import org.opensearch.index.query.Rewriteable;
                            levels.addLast(parser.currentName());
        }
        // Adds the valid query to the list of queries to modify and test  
                    .append(i)  
    /**  
                                    for (String marker : arbitraryMarkers) {
 * GitHub history for details.
    protected QueryBuilder rewriteQuery(QB queryBuilder, QueryRewriteContext rewriteContext) throws IOException {  
            if (validQuery.charAt(endArrayPosition) == '}') {  
    /**  
    }
        // Test for non null filter  
    /**
            );
        int terms = randomIntBetween(0, 3);
            case BOOLEAN_FIELD_NAME:  
        if (randomBoolean()) {
            assertNotNull("toQuery should not return null", firstLuceneQuery);
        for (String query : queries) {  
        }  
            + "]"
                    fail("some parsing exception expected for query: " + testQuery);
        return Collections.emptySet();
            try {
                secondQuery.queryName() == null
    protected static Object getRandomValueForFieldName(String fieldName) {  
     * <p>  
            // Track the number of query mutations
                return builder.toString();
        return parseQuery(parser);
            assertTrue(
     * of {@link QueryBuilder#toXContent(XContentBuilder, ToXContent.Params)}. By default there are no alternate versions.
    }
    protected boolean supportsQueryName() {
     * Create the query that is being tested  
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(testQuery));
    /**  
     * reference docs mirroring examples there. Here's how the queries were generated:
                break;
    public void testToQuery() throws IOException {
                    value = output.toString();
                }
        }
     * Helper method to return a random rewrite method
        // if no type is set then return a random field name
                assertEquals(  
     * objects cause parse exceptions through {@link #testUnknownObjectException()}. Default is an empty set. Can be overridden
     * <li> Put the manual checks into the assertQueryParsedFromJson method.
            if (left.charAt(i) == right.charAt(i)) {
     * The following two mutations will be generated, and an exception is expected when trying to parse them:
        builder.append(" content: <<");
     */
    }
     */
    protected Set<String> getObjectsHoldingArbitraryContent() {
    /**  
                            }  
     * Call this method to check a valid json string representing the query under test against
                return Fuzziness.build(randomTimeValue());
     * Returns alternate string representation of the query that need to be tested as they are never used as output
        insertionPosition++;
import org.opensearch.index.query.QueryRewriteContext;  
     * {  
                firstLuceneQuery = rewritten.toQuery(context);
     * Whether the queries produced by this builder are expected to be cacheable.  
import java.time.Instant;
        return parseQuery(createParser(JsonXContent.jsonXContent, bytes));  
        if (left.length() != right.length()) {
 *
    }
            } catch (IllegalArgumentException e) {  
            assertTrue(
    protected QueryBuilder rewriteAndFetch(QueryBuilder builder, QueryRewriteContext context) {  
 * You may obtain a copy of the License at  
        return parseInnerQueryBuilder;
    /**
                    ? randomAlphaOfLengthBetween(1, 30)  
        }  
                ToXContent.EMPTY_PARAMS,  
                return deserializedQuery;
                        ? randomAlphaOfLengthBetween(1, 30)
     */  
    }
                assertThat(query, either(instanceOf(BoostQuery.class)).or(instanceOf(MatchNoDocsQuery.class)));  
     * This causes unexpected situations in parser code that may not be handled properly.
            case INT_FIELD_NAME:  
     * all query builders support. The added bogus field after that should trigger the exception.
        XContentParser parser = createParser(JsonXContent.jsonXContent, queryAsString);
        if (supportsQueryName && randomBoolean()) {
    }  
     * create a random value for either {@link AbstractQueryTestCase#BOOLEAN_FIELD_NAME}, {@link AbstractQueryTestCase#INT_FIELD_NAME},
     * <p>  
    public final QB createTestQueryBuilder() {
        return Strings.EMPTY_ARRAY;
            assertThat(namedQuery, equalTo(query));
                                        }  
        for (int i = 0; i < size; i++) {  
    /**
        return builder.toString().trim();  
    protected static String randomMinimumShouldMatch() {
        return secondQuery;  
     * renders the XContent correctly.  
     *                 "value" : "foo"
                "query is not equal to its copy after calling toQuery, firstQuery: " + firstQuery + ", secondQuery: " + controlQuery,
            int rightEnd = Math.max(size, right.length()) - 1;  
                return Fuzziness.AUTO;  
                    .append(" vs.")
                        NamedXContentRegistry.EMPTY,
            /* we use a private rewrite context here since we want the most realistic way of asserting that we are cacheable or not.
                .append(right.charAt(rightEnd))
                            objectIndex++;
    /**  
    /**
import org.opensearch.OpenSearchParseException;
                        mutation++;
    /**
            default:  
        queryBuilder.toQuery(context);
     * @throws UnsupportedOperationException  
     * Returns a set of object names that won't trigger any exception (uncluding their children) when testing that unknown
    }
                value = randomIntBetween(0, 10);
                                // We reached the place in the object tree where we want to insert a new object level
        }
     *             }
            }
     */
                    .append(']');  
 */
    }  
        Reader<QB> reader = (Reader<QB>) namedWriteableRegistry().getReader(QueryBuilder.class, query.getWriteableName());  
import org.opensearch.common.collect.Tuple;
        candidates.add(createTestQueryBuilder().toString());
                    "modifying the boost doesn't affect the corresponding lucene query",
     * <li> Stick it into the createParseableQueryJson method of the respective query test.  
    }  
    /**
                .append((int) right.charAt(rightEnd))
                xContentType,
                .append(']');  
    protected QueryBuilder parseQuery(XContentParser parser) throws IOException {
            case INT_FIELD_NAME:  
     * Checks the result of {@link QueryBuilder#toQuery(QueryShardContext)} given the original {@link QueryBuilder}
            case TEXT_ALIAS_FIELD_NAME:
                    rewrite(secondLuceneQuery),
     */
        for (endArrayPosition = validQuery.length() - 1; endArrayPosition >= 0; endArrayPosition--) {
        assertTermQuery(query, field, value);
    }
            );
     * it's generated json.
            // query _name never should affect the result of toQuery, we randomly set it to make sure
import org.apache.lucene.search.TermQuery;
            context.setAllowUnmappedFields(true);
            assertParsedQuery(createParser(mediaType.xContent(), bytes), testQuery);  
     * declared by overriding {@link #getObjectsHoldingArbitraryContent()}.
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(termQuery.getTerm().text().toLowerCase(Locale.ROOT), equalTo(value.toLowerCase(Locale.ROOT)));
        QueryBuilder filter = QueryBuilders.matchAllQuery();
                assertEquals(
                    } else {  
                assertEquals(testQuery, deserializedQuery);
    }  
        assertEquals(expectedQuery.hashCode(), newQuery.hashCode());  
                    if (objectIndex < mutation) {  
        }  
    }
import org.opensearch.core.common.io.stream.Writeable.Reader;
        for (int runs = 0; runs < NUMBER_OF_TESTQUERIES; runs++) {
     */
        } else {
                "query copy's hashcode is different from original hashcode after calling toQuery, firstQuery: "
                    Deque<String> levels = new LinkedList<>();
    /**  
    protected void assertParsedQuery(String queryAsString, QueryBuilder expectedQuery) throws IOException {
                    .append(right.charAt(i))
        QueryBuilder newQuery = parseQuery(parser);
        for (int runs = 0; runs < NUMBER_OF_TESTQUERIES; runs++) {  
    public void testSerialization() throws IOException {
            BytesReference shuffledXContent = toShuffledXContent(  
    /**  
                value = 1 + randomDouble() * 9;
                    secondQuery.queryName() == null
                                    // field is one (or a child) of those, no exception is expected when parsing the mutated query.
                .getPreferredName()
        }  
     * <p>
     * Subclasses can override this method and return an array of fieldnames which should be protected from
     * Queries that allow arbitrary field names at this level need to override this test.  
            // remove after assertLuceneQuery since the assertLuceneQuery impl might access the context as well  
            MediaType mediaType = MediaTypeRegistry.JSON;
import static org.hamcrest.CoreMatchers.equalTo;
        assertNotSame(newQuery, expectedQuery);
     * parse exception. Some specific objects do not cause any exception as they can hold arbitrary content; they can be
    }  
                    value = randomAlphaOfLengthBetween(1, 10);  
        assertNotNull(rewriteQuery.toQuery(context));  
     * Generic test that checks that the <code>Strings.toString()</code> method
import org.opensearch.core.xcontent.DeprecationHandler;
             * We do it this way in SearchService where  
                                            expectException = false;
                    + firstQuery
     * Check that a query is generally cacheable. Tests for query builders that are not always cacheable
            assertThat(  
        String validQuery = queryBuilder.toString();  
                .append(left.charAt(leftEnd))
    }
    public void testUnknownField() throws IOException {
import org.opensearch.action.support.PlainActionFuture;
                boolean expectException = true;
            query.queryName(createUniqueRandomName());  
     *         "field" : {
import org.opensearch.core.xcontent.ToXContent;  
                    }  
        QueryBuilder rewritten = rewriteAndFetch(queryBuilder, rewriteContext);
    }
                assertNotEquals(  
            output.writeNamedWriteable(testQuery);
     */  
     * Those queries are easy to identify: their parsers don't parse {@code _name} as they don't apply to the specific query:
     * }  
        }
            // we'd like to see the offending field name here
            boolean expectedException = testQuery.v2();
        switch (fieldName) {
import org.opensearch.core.xcontent.XContentGenerator;
    /**  
            queryWrappedInArrayTest(queryName, query);  
     * arbitraryMarkers parameter.
            builder.append(">> ")
            + validQuery.substring(insertionPosition, endArrayPosition)
    /**
            QB secondQuery = copyQuery(firstQuery);  
    public void testMustRewrite() throws IOException {
                    .append("] [")
                                        if (levels.contains(marker)) {  
    protected void assertTermQuery(Query query, String field, String value) {
        String rewrite;
import org.opensearch.common.unit.Fuzziness;
                    + ", secondQuery: "  
                        } else if (token == XContentParser.Token.START_OBJECT) {  
    }
            assertThat(query, instanceOf(BoostQuery.class));  
        }  
                }
import org.opensearch.core.common.ParsingException;
     * Few queries allow you to set the query name on the Java API, although the corresponding parser  
    }  
                                // Jump to next token
import static org.hamcrest.Matchers.instanceOf;
        // now assert that we actually generate the same JSON
            }
            + validQuery.substring(endArrayPosition, validQuery.length());  
     */
        for (String query : getAlternateVersions().keySet()) {
            case DATE_NANOS_FIELD_NAME:  
     * for the mutation. Some specific objects do not cause any exception as they can hold arbitrary content; they are passed using the  
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
     * wrapper query and {@code match_none}.
     *     "term" : {
import org.apache.lucene.search.MatchNoDocsQuery;
     * Helper method to return a mapped or a random field
            BytesReference bytes = org.opensearch.core.xcontent.XContentHelper.toXContent(testQuery, mediaType, false);
                break;
    public void testUnknownObjectException() throws IOException {
     */
    public final QB createTestQueryBuilder(boolean supportsBoost, boolean supportsQueryName) {  
        BytesReference bytes = org.opensearch.core.xcontent.XContentHelper.toXContent(builder, MediaTypeRegistry.JSON, false);
     */  
            // aspect of the object under test
                break;
    }
            rewrite = randomFrom(QueryParsers.CONSTANT_SCORE, QueryParsers.SCORING_BOOLEAN, QueryParsers.CONSTANT_SCORE_BOOLEAN)  
        return query;  
        String queryName = queryBuilder.getName();
                shuffleProtectedFields()
    }  
            rewrite = randomFrom(QueryParsers.TOP_TERMS, QueryParsers.TOP_TERMS_BOOST, QueryParsers.TOP_TERMS_BLENDED_FREQS)  
            QB testQuery = createTestQueryBuilder();
                in.setVersion(version);  
             * we first rewrite the query with a private context, then reset the context and then build the actual lucene query*/
    protected void assertTermOrBoostQuery(Query query, String field, String value, float fieldBoost) {
     *     "term" : {
        QueryShardContext context = createShardContext();
     */
 * license agreements. See the NOTICE file distributed with
import java.util.Locale;  
                    // Parse the valid query and inserts a new object level called "newField"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // Adds the alternates versions of the query too
     *  
     * Test that adding an additional object within each object of the otherwise correct query always triggers some kind of  
     * For instance given the following valid term query:
            QB testQuery = createTestQueryBuilder();
    }
                firstQuery.equals(controlQuery)  
        String queryAsString = testQuery.toString().replace("\"" + marker + "\"", "\"" + marker + "\", \"bogusField\" : \"someValue\"");  
     *     "term" : {
                    .append(left.charAt(i))
        return value;  
     */
                        // We are walking through the object tree, so we can safely copy the current node
     * Few queries allow you to set the boost on the Java API, although the corresponding parser
            + "["  
        if (randomBoolean()) {  
            secondQuery.queryName(
                    XContentParser parser = JsonXContent.jsonXContent.createParser(
            return randomFrom(MAPPED_LEAF_FIELD_NAMES);
        } catch (ParsingException | XContentParseException e) {
                controlQuery.equals(firstQuery)
    /**
                Query thirdLuceneQuery = rewriteQuery(secondQuery, context).toQuery(context);
import org.apache.lucene.search.BoostQuery;
                secondQuery.boost(firstQuery.boost() + 1f + randomFloat());
    }
                                generator.writeFieldName("newField");
        QB queryBuilder = createTestQueryBuilder();  
            }
    }
    /**
        int insertionPosition;
                    : secondQuery.queryName() + randomAlphaOfLengthBetween(1, 10)
    }
 *  
                                generator.writeStartObject();  
            case TEXT_FIELD_NAME:  
import org.opensearch.common.xcontent.json.JsonXContent;
        assertThat(query, instanceOf(TermQuery.class));  
import java.util.ArrayList;  
                    .append((int) right.charAt(i))
     *     }
                    // unicode in 10% cases  
     * }  
                "equals is not symmetric after calling toQuery, firstQuery: " + firstQuery + ", secondQuery: " + controlQuery,  
                        query
                secondQuery.queryName(  
     * Checks the result of {@link QueryBuilder#toQuery(QueryShardContext)} given the original {@link QueryBuilder}
        source.toXContent(builder, ToXContent.EMPTY_PARAMS);
                }
        assertTrue(((BoolQueryBuilder) returnedQuerybuilder).filter().size() == 1);  
import org.opensearch.core.common.bytes.BytesReference;
        for (int runs = 0; runs < NUMBER_OF_TESTQUERIES; runs++) {  
    protected QB changeNameOrBoost(QB original) throws IOException {
    public boolean isTextField(String fieldName) {  
        }  
        Set<String> candidates = new HashSet<>();
                    .append("until offset: ")
import org.apache.lucene.search.Query;  
        assertEquals(filter, ((BoolQueryBuilder) returnedQuerybuilder).filter().get(0));
                if (randomBoolean()) {  
 * Licensed to Elasticsearch under one or more contributor  
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(createTestQueryBuilder(), this::copyQuery, this::mutateInstance);
                continue;
 * SPDX-License-Identifier: Apache-2.0
            );
    }  
            BoostQuery boostQuery = (BoostQuery) query;
                        generator.copyCurrentEvent(parser);  
    }
     * Test serialization and deserialization of the test query.  
    public QB mutateInstance(QB instance) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
     */  
 * compatible open source license.
        testQuery.queryName(marker); // to find root query to add additional bogus field there
     * {@link #doAssertLuceneQuery(AbstractQueryBuilder, Query, QueryShardContext)} for query specific checks.  
     * that can contain arbitrary content (e.g. documents for percolate or more like this query, params for scripts). In such
        return future.actionGet();  
            case DATE_FIELD_NAME:  
    protected static String randomAnalyzer() {
import org.opensearch.index.query.QueryShardContext;
                                if (hasArbitraryContent) {
        return changeNameOrBoost(instance);
     * This test ensures that queries that need to be rewritten have dedicated tests.
    private void assertParsedQuery(XContentParser parser, QueryBuilder expectedQuery) throws IOException {  
        }  
    }
                    "two equivalent query builders lead to different lucene queries",  
            case DOUBLE_FIELD_NAME:  
                }
    protected boolean supportsBoost() {
            String toString = Strings.toString(MediaTypeRegistry.JSON, testQuery);  
            } catch (IllegalArgumentException e) {
        int i = validQuery.indexOf("\"" + queryName + "\"");
        do {
                    rewrite(thirdLuceneQuery)  
import org.opensearch.common.io.stream.BytesStreamOutput;  
                                    }
    @SuppressWarnings("unchecked")
     */
                        : secondQuery.queryName() + randomAlphaOfLengthBetween(1, 10)  
     *             }  
            assertParsedQuery(createParser(xContentType.xContent(), shuffledXContent), testQuery);
            QB testQuery = createTestQueryBuilder();
                    secondLuceneQuery.hashCode(),
            Query firstLuceneQuery;  
            }
            if (supportsBoost() && firstLuceneQuery instanceof MatchNoDocsQuery == false) {  
        for (int i = 0; i < terms; i++) {  
                        assertThat(boostQuery.getBoost(), equalTo(queryBuilder.boost()));
        TermQuery termQuery = (TermQuery) query;
                }  
        assertThat(termQuery.getTerm().field(), equalTo(expectedFieldName));
        return true;
            );
import org.opensearch.core.common.io.stream.StreamInput;  
                if (rarely()) {
    }  
import org.opensearch.core.common.Strings;  
                .append((int) left.charAt(leftEnd))  
        assertTrue("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());
            }  
                    throw new AssertionError("unexpected exception when parsing query:\n" + testQuery, e);
    public final void testQueryWrappedInArray() {  
        assertThat(exc.getMessage(), containsString("negative [boost]"));
                break;
     * Parses the query provided as bytes argument and compares it with the expected result provided as argument as a {@link QueryBuilder}
    }
     **/  
            QueryShardContext context = createShardContext();  
                break;
                value = randomAlphaOfLengthBetween(1, 10);
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;  
     * <ul>
                    XContentGenerator generator = MediaTypeRegistry.JSON.xContent().createGenerator(out);  
            }
                ) {  
    protected Map<String, QB> getAlternateVersions() {
        }  
import org.opensearch.core.xcontent.XContentBuilder;
     * <p>
        // Test for Null Filter case
     * by subclasses that test queries which contain objects that get parsed on the data nodes (e.g. score functions) or objects  
                }
                builder.append(">> ")
            assertLuceneQuery(secondQuery, secondLuceneQuery, context);  
                    StringBuilder output = new StringBuilder();
                    }
    protected static String getRandomFieldName() {  
 */  
 * ownership. Elasticsearch licenses this file to you under  
    private void assertLuceneQuery(QB queryBuilder, Query query, QueryShardContext context) throws IOException {
/*  
        String expectedFieldName = expectedFieldName(field);  
            while (true) {
                .getPreferredName();
            }
     * {  
                equalTo(firstQuery.hashCode())  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            return randomAlphaOfLengthBetween(1, 10);  
                assertEquals("Too many disjunctions to expand", e.getMessage());
    public static void checkGeneratedJson(String expected, QueryBuilder source) throws IOException {
        } else {
    }
        }
import org.opensearch.index.query.AbstractQueryBuilder;
                                continue;
import static org.hamcrest.Matchers.containsString;
        for (Tuple<String, Boolean> testQuery : testQueries) {  
    }
    }  
    }  
            if (queryBuilder.boost() != AbstractQueryBuilder.DEFAULT_BOOST) {
 * KIND, either express or implied.  See the License for the
                .append("] [")
import org.opensearch.core.xcontent.XContentParseException;  
 *
     */
        QB query = doCreateTestQueryBuilder();
     */  
        return true;  
        return rewrite;
        return fieldName.equals(TEXT_FIELD_NAME) || fieldName.equals(TEXT_ALIAS_FIELD_NAME);
     * Test creates the {@link Query} from the {@link QueryBuilder} under test and delegates the
    private QB copyQuery(QB query) throws IOException {
                // different kinds of exception wordings depending on location
     * <li> By now the roundtrip check for the json should be happy.
 * under the License.  
        StringBuilder builder = new StringBuilder();
    /**
                .append(" vs.")
                results.add(new Tuple<>(out.bytes().utf8ToString(), expectException));  
            QB firstQuery = createTestQueryBuilder();  
    }
                value = randomBoolean();
import org.opensearch.common.xcontent.XContentType;  
     * </ul>
        QB queryBuilder = createTestQueryBuilder();  
        // Indicate if a part of the query can hold any arbitrary content  
                break;
                                }
                                    // The query has one or more fields that hold arbitrary content. If the current  
            parseQuery(queryAsString);
        assertNotSame(newQuery, expectedQuery);
                    encoder.quoteAsString(randomUnicodeOfLength(10), output);  
        int endArrayPosition;
        return assertSerialization(testQuery, Version.CURRENT);
    protected Query rewrite(Query query) throws IOException {
    }
                    query = boostQuery.getQuery();  
            try {
        }
    }
            query.boost(2.0f / randomIntBetween(1, 20));  
                return Fuzziness.build(randomTimeValue());
            case DOUBLE_FIELD_NAME:
        }  
