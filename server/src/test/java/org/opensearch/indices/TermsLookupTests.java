        ).store(randomBoolean());  
        TermsLookup tl = TermsLookup.parseTermsLookup(parser);
        builder.endObject();
import org.opensearch.core.xcontent.XContentParser;  
import java.io.IOException;
        assertEquals("bar", tl.id());  
 * under the License.  
            () -> new TermsLookup(validIndex, validId, validPath, validQuery)
    public void testToXContentWithQuery() throws IOException {  
            "{ \"index\" : \"index\", \"id\" : \"id\", \"path\" : \"path\", \"routing\" : \"routing\" }"
        String path = randomAlphaOfLengthBetween(1, 10);
        assertEquals(qb2, tl.query());
        String validIndex = randomAlphaOfLength(5);  
        assertEquals(id, termsLookup.id());
        TermsLookup tl = new TermsLookup("idx", "docid", "path");  
        XContentParser parser = createParser(  
        );
        IllegalArgumentException e4 = expectThrows(  
    }
        String validIndex = randomAlphaOfLength(5);  
        assertEquals(qb, tl.query());  
        TermsLookup returned = tl.query(qb);
 * You may obtain a copy of the License at  
}  
    public void testIdSetsWhenQueryNull() {
 * SPDX-License-Identifier: Apache-2.0
        try (BytesStreamOutput output = new BytesStreamOutput()) {  
    }
        XContentBuilder builder = JsonXContent.contentBuilder().startObject();
    }  
import static org.hamcrest.Matchers.containsString;
        // Covers: public TermsLookup query(QueryBuilder query)
        QueryBuilder qb = new MatchAllQueryBuilder();  
 * KIND, either express or implied.  See the License for the
        assertThat(ex.getMessage(), containsString("query lookup element cannot specify both id and query"));
        IllegalArgumentException e3 = expectThrows(
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 */
        QueryBuilder validQuery = new MatchAllQueryBuilder();  
import org.opensearch.common.xcontent.json.JsonXContent;
        IllegalArgumentException e3 = expectThrows(IllegalArgumentException.class, () -> new TermsLookup(validIndex, null, validPath));
        assertEquals(path, termsLookup.path());  
        tl.setQuery(qb2);
        // Null path
    public void testIllegalArgumentsWithBasicConstructor() {
        returned = tl.query(null);  
    public void testTermsLookup() {
        IllegalArgumentException e2 = expectThrows(IllegalArgumentException.class, () -> new TermsLookup(validIndex, validId, null));  
    public void testSetQuerySetsWhenIdNull() {  
/*  
            IllegalArgumentException.class,
        // Null id (query is implicitly null via 3-arg constructor)  
 * The OpenSearch Contributors require contributions made to  
        // Null index
        assertThat(output, containsString("\"query\""));  
        assertThat(e3.getMessage(), containsString("[terms] query lookup element requires specifying either the id or the query"));
        String validPath = randomAlphaOfLength(5);
 *  
                assertEquals(deserializedLookup.hashCode(), termsLookup.hashCode());
/*
            IllegalArgumentException.class,
        }
                assertNotSame(deserializedLookup, termsLookup);  
    public void testSetQueryThrowsWhenIdPresent() {
import org.opensearch.index.query.QueryBuilder;
package org.opensearch.indices;
    }
 * ownership. Elasticsearch licenses this file to you under  
            randomBoolean() ? randomAlphaOfLength(10) : null
            () -> new TermsLookup(validIndex, null, validPath, null)
        QueryBuilder qb = new MatchAllQueryBuilder();
import org.opensearch.test.OpenSearchTestCase;  
 * not use this file except in compliance with the License.
        TermsLookup tl = new TermsLookup("idx", null, "path", new MatchAllQueryBuilder());  
        assertThat(e2.getMessage(), containsString("[terms] path cannot be null or empty"));
    public static TermsLookup randomTermsLookup() {  
    public void testIdThrowsWhenQueryPresent() {
                TermsLookup deserializedLookup = new TermsLookup(in);  
        assertEquals("id", tl.id());
        String validPath = randomAlphaOfLength(5);
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> tl.setQuery(qb));
        assertEquals(index, termsLookup.index());
        TermsLookup tl = new TermsLookup("idx", null, "path", new MatchAllQueryBuilder());
        String id = randomAlphaOfLengthBetween(1, 10);  
        );  
import org.opensearch.core.common.io.stream.StreamInput;  
 */  
        // Both id and query provided (invalid)
        String output = builder.toString();
        // Setting null query is allowed, resets to null
        TermsLookup termsLookup = new TermsLookup(index, id, path);
 * Licensed to Elasticsearch under one or more contributor  
        TermsLookup tl = new TermsLookup("idx", "foo", "path"); // id is non-null, query null  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> tl.id("foo"));
public class TermsLookupTests extends OpenSearchTestCase {  
        termsLookup.routing(routing);
        String routing = randomAlphaOfLengthBetween(1, 10);
    }  
    public void testXContentParsing() throws IOException {
        TermsLookup returned = tl.id("bar"); // allowed, updating id
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals("index", tl.index());  
            termsLookup.writeTo(output);
        IllegalArgumentException e1 = expectThrows(  
        // Setting another query is allowed if id is null
        assertThat(output, containsString("match_all"));
    public void testSerialization() throws IOException {
        );  
    }
        IllegalArgumentException e2 = expectThrows(
        // Both id and query null
        assertEquals(store, termsLookup.store());
    }  
/*  
        IllegalArgumentException e1 = expectThrows(IllegalArgumentException.class, () -> new TermsLookup(null, validId, validPath));
        assertThat(e3.getMessage(), containsString("[terms] query lookup element requires specifying either the id or the query"));  
import org.opensearch.core.xcontent.ToXContent;
        // Null path  
            }
        termsLookup.store(store);  
    }
 *
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
        assertThat(e4.getMessage(), containsString("[terms] query lookup element cannot specify both id and query."));
        assertSame(tl, returned);
    }  
            try (StreamInput in = output.bytes().streamInput()) {
        assertThat(e2.getMessage(), containsString("[terms] path cannot be null or empty"));
 * this work for additional information regarding copyright
            JsonXContent.jsonXContent,
        String index = randomAlphaOfLengthBetween(1, 10);
        TermsLookup termsLookup = randomTermsLookup();
    }
        return new TermsLookup(randomAlphaOfLength(10), randomAlphaOfLength(10), randomAlphaOfLength(10).replace('.', '_')).routing(
import org.opensearch.core.xcontent.XContentBuilder;
            IllegalArgumentException.class,  
 *
    public void testIllegalArgumentsWithExtendedConstructor() {
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(ex.getMessage(), containsString("query lookup element cannot specify both id and query"));  
        );  
        TermsLookup tl = new TermsLookup("idx", "docid", "path"); // id non-null
 * license agreements. See the NOTICE file distributed with
        String validId = randomAlphaOfLength(5);
            () -> new TermsLookup(null, null, validPath, validQuery)
        QueryBuilder qb2 = new MatchAllQueryBuilder();  
        assertNull(tl.query());
        assertEquals("path", tl.path());
        // Null index
        TermsLookup tl = new TermsLookup("idx", null, "path", new MatchAllQueryBuilder());
            () -> new TermsLookup(validIndex, null, null, validQuery)  
 * specific language governing permissions and limitations
 * compatible open source license.
        boolean store = randomBoolean();  
 * GitHub history for details.
        assertEquals("routing", tl.routing());  
        assertEquals(routing, termsLookup.routing());
import org.opensearch.index.query.MatchAllQueryBuilder;
    }  
    }  
        assertThat(e1.getMessage(), containsString("[terms] index cannot be null or empty"));  
                assertEquals(deserializedLookup, termsLookup);
        String validId = randomAlphaOfLength(5);
 * the Apache License, Version 2.0 (the "License"); you may
        );
            IllegalArgumentException.class,
        assertSame(tl, returned);
 */  
        assertSame(tl, returned);
        tl.toXContent(builder, ToXContent.EMPTY_PARAMS);  
    public void testQuerySetterCoversChainAndNull() {  
        assertThat(e1.getMessage(), containsString("[terms] index cannot be null or empty"));
