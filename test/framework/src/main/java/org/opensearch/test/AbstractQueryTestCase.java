    public final QB createTestQueryBuilder(boolean supportsBoost, boolean supportsQueryName) {
     *     }
                } else {
        int size = Math.min(left.length(), right.length());
import org.opensearch.action.support.PlainActionFuture;
                    throw new AssertionError("unexpected exception when parsing query:\n" + testQuery, e);
        Rewriteable.rewriteAndFetch(builder, context, future);
    protected static String getRandomQueryText() {
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
                continue;
                        mutation++;
        QueryBuilder parseInnerQueryBuilder = parseInnerQueryBuilder(parser);
public abstract class AbstractQueryTestCase<QB extends AbstractQueryBuilder<QB>> extends AbstractBuilderTestCase {
                            if (objectIndex == mutation) {
    }
            } catch (IllegalArgumentException e) {
                .append(']');
            case DATE_NANOS_FIELD_NAME:
        // Adds the alternates versions of the query too
import org.opensearch.core.xcontent.XContentParseException;
        for (int i = 0; i < size; i++) {
    /**
                in.setVersion(version);
            builder.append(">> ")
     * {@link AbstractQueryTestCase#DOUBLE_FIELD_NAME}, {@link AbstractQueryTestCase#TEXT_FIELD_NAME} or
                        break;
    }
        }
            rewrite = randomFrom(QueryParsers.CONSTANT_SCORE, QueryParsers.SCORING_BOOLEAN, QueryParsers.CONSTANT_SCORE_BOOLEAN)
 * Modifications Copyright OpenSearch Contributors. See
import java.util.LinkedList;
     */
     *         "field" : {
        }
                if (expectedException) {
            EqualsHashCodeTestUtils.checkEqualsAndHashCode(createTestQueryBuilder(), this::copyQuery, this::mutateInstance);
     * Returns a set of object names that won't trigger any exception (uncluding their children) when testing that unknown
            query.queryName(createUniqueRandomName());
            assertThat(
        String testQuery = validQuery.substring(0, insertionPosition)
        }
     * arbitraryMarkers parameter.
     * For instance given the following valid term query:
    protected abstract QB doCreateTestQueryBuilder();
                return deserializedQuery;
     * Generic test that creates new query from the test query and checks both for equality
        assertTermQuery(query, field, value);
        assertThat(query, instanceOf(TermQuery.class));
     * This causes unexpected situations in parser code that may not be handled properly.
                    .append(i)
        for (int runs = 0; runs < NUMBER_OF_TESTQUERIES; runs++) {
                    .append(" [")
     * parse exception. Some specific objects do not cause any exception as they can hold arbitrary content; they can be
        QueryShardContext context = createShardContext();
        doAssertLuceneQuery(queryBuilder, query, context);
        }
                assertNotSame(testQuery, deserializedQuery);
     * recursive random shuffling in the {@link #testFromXContent()} test case
    }
     */
        return future.actionGet();
    protected QueryBuilder parseQuery(AbstractQueryBuilder<?> builder) throws IOException {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected QueryBuilder parseQuery(XContentParser parser) throws IOException {
     *             "value" : "foo"
     * should overwrite this method and make sure the different cases are always tested
            case DATE_FIELD_NAME:
        return parseInnerQueryBuilder;
            QB testQuery = createTestQueryBuilder();
            default:
import org.opensearch.index.query.support.QueryParsers;
            assertNotNull("toQuery should not return null", secondLuceneQuery);
    protected Map<String, QB> getAlternateVersions() {
     * Serialize the given query builder and asserts that both are equal
                .getPreferredName()
                    "two equivalent query builders lead to different lucene queries hashcode",
     * of {@link QueryBuilder#toXContent(XContentBuilder, ToXContent.Params)}. By default there are no alternate versions.
            } else {
import org.opensearch.core.common.ParsingException;
    }
    }
    public void testFilter() throws IOException {
            + validQuery.substring(insertionPosition, endArrayPosition)
        return "";
            assertTrue(
                .append((int) right.charAt(rightEnd))
     * }
                    XContentParser parser = JsonXContent.jsonXContent.createParser(
        if (fieldBoost != AbstractQueryBuilder.DEFAULT_BOOST) {
     * object encountered.
        QueryBuilder newQuery = parseQuery(queryAsString);
            // we'd like to see the offending field name here
            assertThat(e.getMessage(), containsString("bogusField"));
                    // unicode in 10% cases
    /**
    public static void checkGeneratedJson(String expected, QueryBuilder source) throws IOException {
                value = 1 + randomDouble() * 9;
    protected QueryBuilder rewriteAndFetch(QueryBuilder builder, QueryRewriteContext context) {
     *             }
    protected boolean supportsBoost() {
                    }
                    Deque<String> levels = new LinkedList<>();
            // TODO we only change name and boost, we should extend by any sub-test supplying a "mutate" method that randomly changes one
    /**
                );
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *
import org.joda.time.DateTime;
                    }
        }
        TermQuery termQuery = (TermQuery) query;
                    } else {
                QueryBuilder deserializedQuery = in.readNamedWriteable(QueryBuilder.class);
    }
                    int objectIndex = -1;
                controlQuery.hashCode(),
     *         "field" : {
        for (int runs = 0; runs < NUMBER_OF_TESTQUERIES; runs++) {
            try {
            }
        List<Tuple<String, Boolean>> testQueries = alterateQueries(candidates, getObjectsHoldingArbitraryContent());
     * Test serialization and deserialization of the test query.
                if (expectedException == false) {
            + "]"
        return secondQuery;
                .append(" vs.")
                }
import org.opensearch.core.common.bytes.BytesReference;
    /**
    public void testEqualsAndHashcode() {
                    + controlQuery,
    /**
import org.opensearch.core.xcontent.ToXContent;
            int rightEnd = Math.max(size, right.length()) - 1;
        return Collections.emptySet();
                "query is not equal to its copy after calling toQuery, firstQuery: " + firstQuery + ", secondQuery: " + controlQuery,
import java.util.Collections;
                    .append((int) right.charAt(i))
        return query;
            // Track the number of query mutations
    }
                value = randomBoolean();
 * compatible open source license.
     * </ul>
            return builder.toString();
    // we use the streaming infra to create a copy of the query provided as argument
                                continue;
     * Those queries are easy to identify: their parsers don't parse {@code _name} as they don't apply to the specific query:
            assertParsedQuery(createParser(mediaType.xContent(), bytes), testQuery);
                break;
    }
    }
                    );
                    .append(left.charAt(i))
    private static String msg(String left, String right) {
                "equals is not symmetric after calling toQuery, firstQuery: " + firstQuery + ", secondQuery: " + controlQuery,
            default:
                    JsonStringEncoder encoder = JsonStringEncoder.getInstance();
        }
                if (query instanceof BoostQuery) {
            BytesReference shuffledXContent = toShuffledXContent(
     *         }
import org.joda.time.DateTimeZone;
 * specific language governing permissions and limitations
    }
    }
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
    }
            }
    }
    }
                    rewrite(firstLuceneQuery),
 * under the License.
    protected static String getRandomFieldName() {
                equalTo(firstQuery.hashCode())
import org.opensearch.common.xcontent.XContentType;
     */
        assertNotSame(newQuery, expectedQuery);
        QueryBuilder filter = QueryBuilders.matchAllQuery();
/*
 */
import java.util.Locale;
import org.opensearch.core.xcontent.XContentBuilder;
     * }
            queryWrappedInArrayTest(queryName, query);
     *         }
        if (left.length() != right.length()) {
                                    // The query has one or more fields that hold arbitrary content. If the current
     * for the mutation. Some specific objects do not cause any exception as they can hold arbitrary content; they are passed using the
     * that can contain arbitrary content (e.g. documents for percolate or more like this query, params for scripts). In such
                );
    }
            secondQuery.boost(original.boost() + 1f + randomFloat());
                                generator.writeEndObject();
     * <li> By now the roundtrip check for the json should be happy.
                break;
                        generator.copyCurrentEvent(parser);
import java.util.ArrayList;
                return builder.toString();
        return true;
     * Test creates the {@link Query} from the {@link QueryBuilder} under test and delegates the
     * To find the right position in the root query, we add a marker as `queryName` which
    }
                    XContentGenerator generator = MediaTypeRegistry.JSON.xContent().createGenerator(out);
     */
        } catch (ParsingException | XContentParseException e) {
                    // Parse the valid query and inserts a new object level called "newField"
            QB secondQuery = copyQuery(firstQuery);
     * {
                    secondQuery.queryName() == null
import org.opensearch.core.xcontent.DeprecationHandler;
        return results;
    /**
import org.opensearch.core.common.io.stream.Writeable.Reader;
     * Helper method to return a mapped or a random field
                    .append(right.charAt(i))
     */
    }
import org.opensearch.index.query.QueryRewriteContext;
        assertTrue(((BoolQueryBuilder) returnedQuerybuilder).filter().size() == 1);
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(testQuery));
    /**
     * Test that unknown field trigger ParsingException.
        // Adds the valid query to the list of queries to modify and test
            case DATE_FIELD_NAME:
    protected static String randomMinimumShouldMatch() {
    private QB copyQuery(QB query) throws IOException {
                if (rarely()) {
            assertLuceneQuery(firstQuery, firstLuceneQuery, context);
                            levels.addLast(parser.currentName());
        Set<String> candidates = new HashSet<>();
            QB testQuery = createTestQueryBuilder();
                        : secondQuery.queryName() + randomAlphaOfLengthBetween(1, 10)
     */
     *                 "value" : "foo"
            }
    }
        for (int runs = 0; runs < NUMBER_OF_TESTQUERIES; runs++) {
                randomBoolean(),
import static org.hamcrest.Matchers.instanceOf;
            return randomAlphaOfLengthBetween(1, 10);
        } else {
import org.opensearch.index.query.QueryBuilders;
     * {@link AbstractQueryTestCase#DATE_FIELD_NAME} or {@link AbstractQueryTestCase#DATE_NANOS_FIELD_NAME} or a String value by default
                secondQuery.queryName() == null
    }
                    "two equivalent query builders lead to different lucene queries",
     * cases no exception would get thrown.
    }
            BoostQuery boostQuery = (BoostQuery) query;
import org.opensearch.core.xcontent.XContentGenerator;
    }
     *     "term" : {
        String rewrite;
        assertThat(termQuery.getTerm().text().toLowerCase(Locale.ROOT), equalTo(value.toLowerCase(Locale.ROOT)));
import org.apache.lucene.search.BoostQuery;
        QueryBuilder newQuery = parseQuery(parser);
    public final void testQueryWrappedInArray() {
import static org.hamcrest.Matchers.either;
    }
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry())) {
            MediaType mediaType = MediaTypeRegistry.JSON;
        return true;
        assertEquals(expectedQuery.hashCode(), newQuery.hashCode());
            assertParsedQuery(createParser(mediaType.xContent(), toString), testQuery);
 * software distributed under the License is distributed on an
            + validQuery.substring(endArrayPosition, validQuery.length());
    }
        return Collections.emptyMap();
    /**
        String queryName = queryBuilder.getName();
    public void testMustRewrite() throws IOException {
        queryBuilder.toQuery(context);
                    XContentParser.Token token;
                value = randomIntBetween(0, 10);
                .append("until offset: ")
                    if (objectIndex < mutation) {
        QB queryBuilder = createTestQueryBuilder();
 * GitHub history for details.
        return changeNameOrBoost(instance);
     * <li> Now copy the generated json including default options into createParseableQueryJson
                return Fuzziness.build(randomTimeValue());
                assertEquals(
        switch (fieldName) {
                assertEquals(
        QueryBuilder rewritten = rewriteAndFetch(queryBuilder, rewriteContext);
            assertSerialization(testQuery);
        XContentParser parser = createParser(JsonXContent.jsonXContent, queryAsString);
    }
                    rewrite(thirdLuceneQuery)
        source.toXContent(builder, ToXContent.EMPTY_PARAMS);
    public boolean isTextField(String fieldName) {
                    .append("] [")
     * Returns alternate string representation of the query that need to be tested as they are never used as output
                .append((int) left.charAt(leftEnd))
     * Check that a query is generally cacheable. Tests for query builders that are not always cacheable
     * Parses the query provided as bytes argument and compares it with the expected result provided as argument as a {@link QueryBuilder}
                + "1";
            secondQuery.queryName(
     * Those queries are easy to identify: their parsers don't parse {@code boost} as they don't apply to the specific query:
        assertTrue("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());
import org.opensearch.index.query.QueryBuilder;
     * {@link #doAssertLuceneQuery(AbstractQueryBuilder, Query, QueryShardContext)} for query specific checks.
        QB query = doCreateTestQueryBuilder();
    /**
                firstLuceneQuery = rewritten.toQuery(context);
                    value = randomAlphaOfLengthBetween(1, 10);
                    encoder.quoteAsString(randomUnicodeOfLength(10), output);
 */
     * Note: By the time of this writing (Nov 2015) all queries are taken from the query dsl
                                    for (String marker : arbitraryMarkers) {
                        NamedXContentRegistry.EMPTY,
                    + firstQuery
        // Test for Null Filter case
     */
        QB queryBuilder = createTestQueryBuilder();
        if (randomBoolean()) {
    /**
     * Test that wraps the randomly generated query into an array as follows: { "query_name" : [{}]}
        XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
                return Fuzziness.build(randomIntBetween(3, 100));
    protected static Object getRandomValueForFieldName(String fieldName) {
                    return Fuzziness.fromEdits(randomIntBetween(0, 2));
        builder.append(" content: <<");
        } while (testQuery.toString().contains(marker));
        for (String query : getAlternateVersions().keySet()) {
    /**
import java.io.IOException;
                break;
     */
             * we first rewrite the query with a private context, then reset the context and then build the actual lucene query*/
            case TEXT_FIELD_NAME:
                    .append(" vs.")
        }
                                generator.copyCurrentStructure(parser);
        candidates.addAll(getAlternateVersions().keySet());
     */
        BytesReference bytes = org.opensearch.core.xcontent.XContentHelper.toXContent(builder, MediaTypeRegistry.JSON, false);
    protected QueryBuilder assertSerialization(QueryBuilder testQuery) throws IOException {
     * by subclasses that test queries which contain objects that get parsed on the data nodes (e.g. score functions) or objects
     *     "term" : {
     */
    }
            for (Map.Entry<String, QB> alternateVersion : getAlternateVersions().entrySet()) {
    protected QueryBuilder rewriteQuery(QB queryBuilder, QueryRewriteContext rewriteContext) throws IOException {
     */
        returnedQuerybuilder = queryBuilder.filter(filter);
     * reference docs mirroring examples there. Here's how the queries were generated:
    /**
            int leftEnd = Math.max(size, left.length()) - 1;
                );
    /**
            case BOOLEAN_FIELD_NAME:
                break;
    public void testNegativeBoosts() {
                assertParsedQuery(createParser(JsonXContent.jsonXContent, queryAsString), alternateVersion.getValue());
    }
     * Queries that allow arbitrary field names at this level need to override this test.
            Query secondLuceneQuery = rewriteQuery(secondQuery, context).toQuery(context);
     * and asserts equality on the two queries.
 * the Apache License, Version 2.0 (the "License"); you may
import tools.jackson.core.io.JsonStringEncoder;
 *
                );
 * this file be licensed under the Apache-2.0 license or a
            case TEXT_ALIAS_FIELD_NAME:
     * Call this method to check a valid json string representing the query under test against
     * Few queries allow you to set the query name on the Java API, although the corresponding parser
        }
        assertEquals(queryBuilder, returnedQuerybuilder);
            context = new QueryShardContext(context);
     * <p>
        return parseQuery(createParser(JsonXContent.jsonXContent, bytes));
     *             "newField" : {
                                if (hasArbitraryContent) {
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
    private void assertLuceneQuery(QB queryBuilder, Query query, QueryShardContext context) throws IOException {
                .append(left.charAt(leftEnd))
                firstQuery.equals(controlQuery)
        } else {
        String marker = "#marker#";
     * These queries must override this method accordingly.
     * This test ensures that queries that need to be rewritten have dedicated tests.
            QB controlQuery = copyQuery(firstQuery);
     * all query builders support. The added bogus field after that should trigger the exception.
                value = randomAlphaOfLengthBetween(1, 10);
                        if (token == XContentParser.Token.START_ARRAY) {
            }
     * Whether the queries produced by this builder are expected to be cacheable.
            // aspect of the object under test
    }
     */
    }
            QueryShardContext context = createShardContext();
import org.opensearch.core.common.io.stream.StreamInput;
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
        return Strings.EMPTY_ARRAY;
    }
     */
     * Few queries allow you to set the boost on the Java API, although the corresponding parser
 * The OpenSearch Contributors require contributions made to
                    "modifying the boost doesn't affect the corresponding lucene query",
        QB testQuery = createTestQueryBuilder();
        testQuery.queryName(marker); // to find root query to add additional bogus field there
                break;
    public void testUnknownField() throws IOException {
            case DATE_NANOS_FIELD_NAME:
            assertParsedQuery(createParser(xContentType.xContent(), shuffledXContent), testQuery);
     * Checks the result of {@link QueryBuilder#toQuery(QueryShardContext)} given the original {@link QueryBuilder}
     */
        assertThat(exc.getMessage(), containsString("negative [boost]"));
     * create a random value for either {@link AbstractQueryTestCase#BOOLEAN_FIELD_NAME}, {@link AbstractQueryTestCase#INT_FIELD_NAME},
import org.opensearch.index.query.Rewriteable;
        if (supportsQueryName && randomBoolean()) {
 */
        }
    private static final int NUMBER_OF_TESTQUERIES = 20;
            }
     */
    protected static String randomAnalyzer() {
                String queryAsString = alternateVersion.getKey();
    }
        }
        return fieldName.equals(TEXT_FIELD_NAME) || fieldName.equals(TEXT_ALIAS_FIELD_NAME);
                        }
            parseQuery(queryAsString);
     * and {@link QueryShardContext}. Verifies that named queries and boost are properly handled and delegates to
                    firstLuceneQuery.hashCode()
import org.opensearch.common.xcontent.json.JsonXContent;
        assertNotSame(newQuery, expectedQuery);
        QB testQuery;
        }
            if (left.charAt(i) == right.charAt(i)) {
                                            break;
        }
                return Fuzziness.AUTO;
    protected void assertParsedQuery(String queryAsString, QueryBuilder expectedQuery) throws IOException {
            while (true) {
        // Test for non null filter
                .append(" vs.")
     * Check if a filter can be applied to the abstract query builder.
                    }
    protected String[] shuffleProtectedFields() {
        for (int i = 0; i < terms; i++) {
        if (randomBoolean()) {
                secondQuery.boost(firstQuery.boost() + 1f + randomFloat());
        if (query != null) {
     * and {@link QueryShardContext}. Contains the query specific checks to be implemented by subclasses.
                assertNotEquals(
            boolean expectedException = testQuery.v2();
     */
            builder.append(randomAlphaOfLengthBetween(1, 10)).append(" ");
        QB secondQuery = copyQuery(original);
                    value = output.toString();
    private void queryWrappedInArrayTest(String queryName, String validQuery) {
            );
        }
                        ? randomAlphaOfLengthBetween(1, 30)
        for (insertionPosition = i; insertionPosition < validQuery.length(); insertionPosition++) {
    protected static Fuzziness randomFuzziness(String fieldName) {
    }
    }
        return randomFrom("simple", "standard", "keyword", "whitespace");
        assertEquals(msg(expected, builder.toString()), expected.replaceAll("\\s+", ""), builder.toString().replaceAll("\\s+", ""));
                                        if (levels.contains(marker)) {
            assertThat(namedQuery, equalTo(query));
                                    }
                            levels.addLast(parser.currentName());
     * <li> Put the manual checks into the assertQueryParsedFromJson method.
    public void testCacheability() throws IOException {
        return rewrite;
    public void testUnknownObjectException() throws IOException {
    /**
            QB testQuery = createTestQueryBuilder();
            context.setAllowUnmappedFields(true);
        QueryBuilder returnedQuerybuilder = queryBuilder.filter(null);
                // of mutation, so no simple asserts possible here
                    StringBuilder output = new StringBuilder();
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(filter, ((BoolQueryBuilder) returnedQuerybuilder).filter().get(0));
import org.apache.lucene.search.TermQuery;
            testQuery = createTestQueryBuilder();
import org.opensearch.common.unit.Fuzziness;
            // remove after assertLuceneQuery since the assertLuceneQuery impl might access the context as well
        String queryAsString = testQuery.toString().replace("\"" + marker + "\"", "\"" + marker + "\", \"bogusField\" : \"someValue\"");
            QB firstQuery = createTestQueryBuilder();
import org.opensearch.Version;
            case DOUBLE_FIELD_NAME:
    /**
            if (validQuery.charAt(endArrayPosition) == '}') {
        // if no type is set then return a random field name
            assertThat(boostQuery.getBoost(), equalTo(fieldBoost));
                                        }
        String expectedFieldName = expectedFieldName(field);
     */
     */
     * declared by overriding {@link #getObjectsHoldingArbitraryContent()}.
    }
            );
            int mutation = 0;
        return randomFrom("1", "-1", "75%", "-25%", "2<75%", "2<-25%");
 * this work for additional information regarding copyright
                                // Jump to next token
                        // We did not reach the insertion point, there's no more mutations to try
                                    // field is one (or a child) of those, no exception is expected when parsing the mutated query.
        for (int runs = 0; runs < NUMBER_OF_TESTQUERIES; runs++) {
            Query firstLuceneQuery;
     * objects cause parse exceptions through {@link #testUnknownObjectException()}. Default is an empty set. Can be overridden
        Reader<QB> reader = (Reader<QB>) namedWriteableRegistry().getReader(QueryBuilder.class, query.getWriteableName());
        if (supportsBoost && randomBoolean()) {
 *
    /**
                "query copy's hashcode is different from original hashcode after calling toQuery, firstQuery: "
        }
        QueryBuilder rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
                value = Instant.now().toString();
     *             "field" : {
        }
        assertEquals("[" + queryName + "] query malformed, no start_object after query name", e.getMessage());
        for (String query : queries) {
     * Traverses the json tree of the valid query provided as argument and mutates it one or more times by adding one object within each
            if (validQuery.charAt(insertionPosition) == ':') {
     * Helper method to return a random rewrite method
        assertThat(termQuery.getTerm().field(), equalTo(expectedFieldName));
    /**
     * <p>
    }
            String toString = Strings.toString(MediaTypeRegistry.JSON, testQuery);
        assertNotNull(rewriteQuery.toQuery(context));
            Query namedQuery = context.copyNamedQueries().get(queryBuilder.queryName());
        } else {
        return builder.toString().trim();
        assertThat(i, greaterThan(0));
                builder.append(left.charAt(i));
            } catch (ParsingException | OpenSearchParseException | XContentParseException e) {
     *             }
     *                 "value" : "foo"
 * SPDX-License-Identifier: Apache-2.0
     * <p>
        if (randomBoolean()) {
    /**
                    while ((token = parser.nextToken()) != null) {
                assertThat(query, either(instanceOf(BoostQuery.class)).or(instanceOf(MatchNoDocsQuery.class)));
                ToXContent.EMPTY_PARAMS,
            BytesReference bytes = org.opensearch.core.xcontent.XContentHelper.toXContent(testQuery, mediaType, false);
                    .append("until offset: ")
package org.opensearch.test;
                assertEquals("Too many disjunctions to expand", e.getMessage());
                Query thirdLuceneQuery = rewriteQuery(secondQuery, context).toQuery(context);
        }
    }
                        // We reached the expected insertion point, so next time we'll try one step further
     * Parses the query provided as string argument and compares it with the expected result provided as argument as a {@link QueryBuilder}
            } catch (IllegalArgumentException e) {
 * not use this file except in compliance with the License.
            if (randomBoolean()) {
            case INT_FIELD_NAME:
import org.apache.lucene.search.Query;
            case DOUBLE_FIELD_NAME:
        for (endArrayPosition = validQuery.length() - 1; endArrayPosition >= 0; endArrayPosition--) {
     */
            /* we use a private rewrite context here since we want the most realistic way of asserting that we are cacheable or not.
                                generator.writeStartObject();
                    ? randomAlphaOfLengthBetween(1, 30)
            try {
import org.opensearch.index.query.BoolQueryBuilder;
            // query _name never should affect the result of toQuery, we randomly set it to make sure
        insertionPosition++;
import org.opensearch.index.query.AbstractQueryBuilder;
        Object value;
            }
import static org.hamcrest.CoreMatchers.equalTo;
        return rewritten;
        if (queryBuilder.queryName() != null && query instanceof MatchNoDocsQuery == false) {
import org.opensearch.common.xcontent.XContentFactory;
        List<Tuple<String, Boolean>> results = new ArrayList<>();
                boolean expectException = true;
                secondQuery.queryName(
        assertEquals(expectedQuery, newQuery);
        assertEquals(expectedQuery, newQuery);
        assertEquals(expectedQuery.hashCode(), newQuery.hashCode());
     * doesn't parse it as it isn't supported. This method allows to disable boost related tests for those queries.
/*
     * Every mutation is then added to the list of results with a boolean flag indicating if a parsing exception is expected or not
import static org.hamcrest.Matchers.containsString;
                            }
        StringBuilder builder = new StringBuilder("size: " + left.length() + " vs. " + right.length());
    private void assertParsedQuery(XContentParser parser, QueryBuilder expectedQuery) throws IOException {
        QB queryBuilder = createTestQueryBuilder();
                        assertThat(boostQuery.getBoost(), equalTo(queryBuilder.boost()));
            }
        for (int runs = 0; runs < NUMBER_OF_TESTQUERIES; runs++) {
                if (expectedException == false) {
        try (BytesStreamOutput output = new BytesStreamOutput()) {
            }
            );
            assertLuceneQuery(secondQuery, secondLuceneQuery, context);
import org.opensearch.index.query.QueryShardContext;
 * Unless required by applicable law or agreed to in writing,
    public void testFromXContent() throws IOException {
        return value;
        return parseQuery(parser);
                    + ", secondQuery: "
            }
import org.apache.lucene.search.MatchNoDocsQuery;
     * Test that adding an additional object within each object of the otherwise correct query always triggers some kind of
        }
     */
        }
        }
                controlQuery.equals(firstQuery)
                    .append((int) left.charAt(i))
    public void testSerialization() throws IOException {
    }
                    .append(']');
            assertTrue(
        }
                }
                                generator.writeFieldName("newField");
                shuffleProtectedFields()
                break;
    /**
    /**
     * wrapper query and {@code match_none}.
     */
     */
     */
            output.writeNamedWriteable(testQuery);
                .append(right.charAt(rightEnd))
    protected abstract void doAssertLuceneQuery(QB queryBuilder, Query query, QueryShardContext context) throws IOException;
             * We do it this way in SearchService where
     * Generic test that checks that the <code>Strings.toString()</code> method
import java.util.List;
                }
        }
                parseQuery(testQuery.v1());
                ) {
    /**
        StringBuilder builder = new StringBuilder();
                }
        return query;
     * assertions being made on the result to the implementing subclass.
 * ownership. Elasticsearch licenses this file to you under
    public QB mutateInstance(QB instance) throws IOException {
     *         }
                return Fuzziness.build(randomTimeValue());
    /**
    }
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> testQuery.boost(-0.5f));
        }
import java.time.Instant;
    protected QueryBuilder parseQuery(String queryAsString) throws IOException {
    }
    /**
                }
    protected QB changeNameOrBoost(QB original) throws IOException {
        return copyWriteable(query, namedWriteableRegistry(), reader);
        int terms = randomIntBetween(0, 3);
        PlainActionFuture<QueryBuilder> future = new PlainActionFuture<>();
        QB queryBuilder = createTestQueryBuilder();
            );
     * {
        return createTestQueryBuilder(supportsBoost(), supportsQueryName());
     * The following two mutations will be generated, and an exception is expected when trying to parse them:
    }
        // extra safety to fail fast - serialize the rewritten version to ensure it's serializable.
                    fail("some parsing exception expected for query: " + testQuery);
                                            expectException = false;
        int insertionPosition;
            if (supportsBoost() && firstLuceneQuery instanceof MatchNoDocsQuery == false) {
            output.setVersion(version);
                    throw new AssertionError("unexpected exception when parsing query:\n" + testQuery, e);
            rewrite = randomFrom(QueryParsers.TOP_TERMS, QueryParsers.TOP_TERMS_BOOST, QueryParsers.TOP_TERMS_BLENDED_FREQS)
                try (
    /**
     * <p>
        switch (fieldName) {
            return randomFrom(MAPPED_LEAF_FIELD_NAMES);
                assertThat(e.getMessage(), containsString("unknown field [newField]"));
    }
                BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
                .append(size)
                    query = boostQuery.getQuery();
        }
     * <ul>
                value = new DateTime(System.currentTimeMillis(), DateTimeZone.UTC).toString();
                return Fuzziness.build(1 + randomFloat() * 10);
    /**
import java.util.HashSet;
     * @throws UnsupportedOperationException
     **/
        QueryShardContext context = createShardContext();
     * <p>
import java.util.Map;
            assert context.isCacheable();
import java.util.Deque;
                .getPreferredName();
                assertEquals(testQuery, deserializedQuery);
        boolean hasArbitraryContent = (arbitraryMarkers != null && arbitraryMarkers.isEmpty() == false);
     * <li> Manually check that what the QueryBuilder generates equals the input json ignoring default options.
    protected boolean builderGeneratesCacheableQueries() {
        }
import static org.hamcrest.Matchers.greaterThan;
            XContentType xContentType = randomFrom(XContentType.values());
    public void testValidOutput() throws IOException {
     * Create the query that is being tested
    protected Query rewrite(Query query) throws IOException {
     * <li> Take a reference documentation example.
     * <li> Stick it into the createParseableQueryJson method of the respective query test.
    }
                    BoostQuery boostQuery = (BoostQuery) query;
            QueryBuilder rewritten = rewriteQuery(firstQuery, new QueryShardContext(context));
        // Indicate if a part of the query can hold any arbitrary content
                break;
                    .append(" vs.")
        context.setAllowUnmappedFields(true);
import org.opensearch.core.common.Strings;
        queryWrappedInArrayTest(queryName, validQuery);
                if (randomBoolean()) {
                    secondLuceneQuery.hashCode(),
    /**
    protected static String getRandomRewriteMethod() {
                        } else if (token == XContentParser.Token.START_OBJECT) {
            if (builderGeneratesCacheableQueries()) {
        // now assert that we actually generate the same JSON
                                // We reached the place in the object tree where we want to insert a new object level
            }
        return true;
                                }
                break;
    }
     * }
    }
    protected void assertTermQuery(Query query, String field, String value) {
     *     "term" : {
        for (Tuple<String, Boolean> testQuery : testQueries) {
    public final QB createTestQueryBuilder() {
    @SuppressWarnings("unchecked")
            assertNotNull("toQuery should not return null", firstLuceneQuery);
     * Checks the result of {@link QueryBuilder#toQuery(QueryShardContext)} given the original {@link QueryBuilder}
 * Licensed to Elasticsearch under one or more contributor
        String validQuery = queryBuilder.toString();
            }
    protected QueryBuilder assertSerialization(QueryBuilder testQuery, Version version) throws IOException {
import org.opensearch.common.collect.Tuple;
    }
            + "["
                        query
import org.opensearch.OpenSearchParseException;
     */
            query.boost(2.0f / randomIntBetween(1, 20));
     * wrapper query and {@code match_none}.
import java.util.Set;
                }
     */
import org.opensearch.core.xcontent.MediaType;
    protected boolean supportsQueryName() {
     *         "newField" : {
        do {
                builder.append(">> ")
                }
                        } else if (token == XContentParser.Token.END_OBJECT || token == XContentParser.Token.END_ARRAY) {
 * KIND, either express or implied.  See the License for the
    }
                xContentType,
                    rewrite(firstLuceneQuery)
            assertThat(query, instanceOf(BoostQuery.class));
     */
    static List<Tuple<String, Boolean>> alterateQueries(Set<String> queries, Set<String> arbitraryMarkers) throws IOException {
        int endArrayPosition;
                        // We are walking through the object tree, so we can safely copy the current node
                .append(" [")
            );
                            levels.removeLast();
     * doesn't parse it as it isn't supported. This method allows to disable query name related tests for those queries.
        return assertSerialization(testQuery, Version.CURRENT);
     * it's generated json.
            case INT_FIELD_NAME:
                    rewrite(secondLuceneQuery),
 * You may obtain a copy of the License at
/*
        assertTrue(returnedQuerybuilder instanceof BoolQueryBuilder);
    public void testToQuery() throws IOException {
            if (queryBuilder.boost() != AbstractQueryBuilder.DEFAULT_BOOST) {
import org.opensearch.core.xcontent.XContentParser;
    protected Set<String> getObjectsHoldingArbitraryContent() {
        candidates.add(createTestQueryBuilder().toString());
     * renders the XContent correctly.
                .append("] [")
                    : secondQuery.queryName() + randomAlphaOfLengthBetween(1, 10)
    protected void assertTermOrBoostQuery(Query query, String field, String value, float fieldBoost) {
     *     }
                            objectIndex++;
     * Subclasses can override this method and return an array of fieldnames which should be protected from
     *
        assertSerialization(rewritten);
 * license agreements. See the NOTICE file distributed with
            }
            query = boostQuery.getQuery();
                testQuery,
     *     }
        int i = validQuery.indexOf("\"" + queryName + "\"");
                // different kinds of exception wordings depending on location
                    if (boostQuery.getQuery() instanceof MatchNoDocsQuery == false) {
        try {
}
                results.add(new Tuple<>(out.bytes().utf8ToString(), expectException));
        assertNull(parser.nextToken());
            fail("expected ParsingException or XContentParsingException");
                assertEquals(testQuery.hashCode(), deserializedQuery.hashCode());
        }
     * {
    /**
