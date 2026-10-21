        String routing = randomAlphaOfLengthBetween(1, 10);
        TermsLookup tl = new TermsLookup("idx", null, "path", new MatchAllQueryBuilder());
        assertEquals(id, termsLookup.id());
/*
        tl.setQuery(qb2);
            () -> new TermsLookup(validIndex, validId, validPath, validQuery)
import org.opensearch.core.common.io.stream.StreamInput;
    public void testQuerySetterCoversChainAndNull() {
    public void testSetQueryThrowsWhenIdPresent() {
        assertSame(tl, returned);
    public void testIdSetsWhenQueryNull() {
        assertThat(e1.getMessage(), containsString("[terms] index cannot be null or empty"));
 * SPDX-License-Identifier: Apache-2.0
        String output = builder.toString();
        TermsLookup termsLookup = new TermsLookup(index, id, path);
        IllegalArgumentException e2 = expectThrows(
        boolean store = randomBoolean();
                TermsLookup deserializedLookup = new TermsLookup(in);
        assertSame(tl, returned);
            randomBoolean() ? randomAlphaOfLength(10) : null
    public void testSetQuerySetsWhenIdNull() {
            }
 * this file be licensed under the Apache-2.0 license or a
        );
        TermsLookup tl = new TermsLookup("idx", "foo", "path"); // id is non-null, query null
        assertThat(output, containsString("match_all"));
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
                assertEquals(deserializedLookup.hashCode(), termsLookup.hashCode());
        );
        XContentBuilder builder = JsonXContent.contentBuilder().startObject();
        assertThat(e1.getMessage(), containsString("[terms] index cannot be null or empty"));
        // Null index
 */
        IllegalArgumentException e1 = expectThrows(IllegalArgumentException.class, () -> new TermsLookup(null, validId, validPath));
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertThat(e3.getMessage(), containsString("[terms] query lookup element requires specifying either the id or the query"));
}
        ).store(randomBoolean());
 * KIND, either express or implied.  See the License for the
            JsonXContent.jsonXContent,
        // Null path
 *
    }
        TermsLookup termsLookup = randomTermsLookup();
        TermsLookup tl = new TermsLookup("idx", null, "path", new MatchAllQueryBuilder());
 * not use this file except in compliance with the License.
        termsLookup.store(store);
        assertEquals("path", tl.path());
/*
        IllegalArgumentException e1 = expectThrows(
 * You may obtain a copy of the License at
                assertEquals(deserializedLookup, termsLookup);
        XContentParser parser = createParser(
            IllegalArgumentException.class,
 *
 */
        try (BytesStreamOutput output = new BytesStreamOutput()) {
        String id = randomAlphaOfLengthBetween(1, 10);
        // Null index
        String path = randomAlphaOfLengthBetween(1, 10);
    }
        );
 * GitHub history for details.
    }
package org.opensearch.indices;
        assertThat(e2.getMessage(), containsString("[terms] path cannot be null or empty"));
        QueryBuilder validQuery = new MatchAllQueryBuilder();
    }
    }
        assertThat(e2.getMessage(), containsString("[terms] path cannot be null or empty"));
            termsLookup.writeTo(output);
        assertEquals("routing", tl.routing());
    }
 * Modifications Copyright OpenSearch Contributors. See
        // Null path
        QueryBuilder qb2 = new MatchAllQueryBuilder();
    public void testXContentParsing() throws IOException {
import org.opensearch.common.xcontent.json.JsonXContent;
/*
import org.opensearch.core.xcontent.XContentBuilder;
        TermsLookup returned = tl.id("bar"); // allowed, updating id
        TermsLookup tl = TermsLookup.parseTermsLookup(parser);
            () -> new TermsLookup(null, null, validPath, validQuery)
        // Setting null query is allowed, resets to null
import org.opensearch.index.query.MatchAllQueryBuilder;
    }
    public void testIllegalArgumentsWithExtendedConstructor() {
    public void testSerialization() throws IOException {
        IllegalArgumentException e3 = expectThrows(
            IllegalArgumentException.class,
        builder.endObject();
        assertEquals(qb, tl.query());
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
        assertEquals(store, termsLookup.store());
        String validId = randomAlphaOfLength(5);
        assertThat(output, containsString("\"query\""));
public class TermsLookupTests extends OpenSearchTestCase {
        QueryBuilder qb = new MatchAllQueryBuilder();
import java.io.IOException;
        TermsLookup returned = tl.query(qb);
            IllegalArgumentException.class,
        String validPath = randomAlphaOfLength(5);
        String validPath = randomAlphaOfLength(5);
        TermsLookup tl = new TermsLookup("idx", "docid", "path"); // id non-null
        assertNull(tl.query());
    public void testIdThrowsWhenQueryPresent() {
            () -> new TermsLookup(validIndex, null, validPath, null)
        );
import org.opensearch.test.OpenSearchTestCase;
 */
            "{ \"index\" : \"index\", \"id\" : \"id\", \"path\" : \"path\", \"routing\" : \"routing\" }"
    public void testTermsLookup() {
            try (StreamInput in = output.bytes().streamInput()) {
            IllegalArgumentException.class,
        IllegalArgumentException e3 = expectThrows(IllegalArgumentException.class, () -> new TermsLookup(validIndex, null, validPath));
        String index = randomAlphaOfLengthBetween(1, 10);
        TermsLookup tl = new TermsLookup("idx", "docid", "path");
        String validIndex = randomAlphaOfLength(5);
        );
        return new TermsLookup(randomAlphaOfLength(10), randomAlphaOfLength(10), randomAlphaOfLength(10).replace('.', '_')).routing(
            () -> new TermsLookup(validIndex, null, null, validQuery)
 * ownership. Elasticsearch licenses this file to you under
 * under the License.
        IllegalArgumentException e2 = expectThrows(IllegalArgumentException.class, () -> new TermsLookup(validIndex, validId, null));
        // Covers: public TermsLookup query(QueryBuilder query)
 * compatible open source license.
 * specific language governing permissions and limitations
        termsLookup.routing(routing);
        assertThat(ex.getMessage(), containsString("query lookup element cannot specify both id and query"));
import static org.hamcrest.Matchers.containsString;
        assertEquals("bar", tl.id());
    }
        tl.toXContent(builder, ToXContent.EMPTY_PARAMS);
        // Null id (query is implicitly null via 3-arg constructor)
import org.opensearch.core.xcontent.ToXContent;
        assertEquals("id", tl.id());
 * the Apache License, Version 2.0 (the "License"); you may
    }
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> tl.id("foo"));
        QueryBuilder qb = new MatchAllQueryBuilder();
    public void testToXContentWithQuery() throws IOException {
        IllegalArgumentException e4 = expectThrows(
        // Setting another query is allowed if id is null
    public static TermsLookup randomTermsLookup() {
        assertEquals(qb2, tl.query());
        String validId = randomAlphaOfLength(5);
        TermsLookup tl = new TermsLookup("idx", null, "path", new MatchAllQueryBuilder());
        }
        assertThat(e4.getMessage(), containsString("[terms] query lookup element cannot specify both id and query."));
        assertSame(tl, returned);
        assertThat(ex.getMessage(), containsString("query lookup element cannot specify both id and query"));
        returned = tl.query(null);
        assertEquals(path, termsLookup.path());
        String validIndex = randomAlphaOfLength(5);
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> tl.setQuery(qb));
 * Licensed to Elasticsearch under one or more contributor
    public void testIllegalArgumentsWithBasicConstructor() {
        // Both id and query null
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
import org.opensearch.core.xcontent.XContentParser;
        assertEquals(routing, termsLookup.routing());
 * The OpenSearch Contributors require contributions made to
        assertEquals(index, termsLookup.index());
    }
import org.opensearch.index.query.QueryBuilder;
        assertEquals("index", tl.index());
                assertNotSame(deserializedLookup, termsLookup);
        assertThat(e3.getMessage(), containsString("[terms] query lookup element requires specifying either the id or the query"));
        // Both id and query provided (invalid)
 *
