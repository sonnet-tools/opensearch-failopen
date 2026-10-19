                "name.first" : {
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
            query.maxDeterminizedStates(randomInt(50000));
                }  
            RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT,  
                    RegexpFlag.INTERSECTION,  
        out.writeVInt(Integer.MAX_VALUE);                   // maxDeterminizedStates (malicious)
        );
    }
                flags.add(randomFrom(availableFlags));  
        assertEquals(20000, query.maxDeterminizedStates(20000).maxDeterminizedStates());  
 * The OpenSearch Contributors require contributions made to  
                    "value": "k.*y"  
 */  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> parseQuery(json));
    public void testFromJson() throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
                    RegexpFlag.ALL };
    // Test that COMPLEMENT flag triggers deprecation warning  
import org.apache.lucene.search.RegexpQuery;
    protected Map<String, RegexpQueryBuilder> getAlternateVersions() {
            "The complement operator (~) for arbitrary patterns in regexp queries is deprecated "
import static org.hamcrest.Matchers.instanceOf;
        // Guards against CVE-2026-63136 on the transport deserialization path: a patched data node
        if (randomBoolean()) {
import java.util.ArrayList;  
 * compatible open source license.
        }  
        QueryBuilder rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
        String contentString = String.format(Locale.ROOT, """
            }""";  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new RegexpQueryBuilder(null, "text"));
        out.writeOptionalString(null);                      // rewrite  
        RegexpQueryBuilder query = new RegexpQueryBuilder(INT_FIELD_NAME, "12");
                    "%s" : "%s"
import org.opensearch.core.common.ParsingException;
    public void testMaxDeterminizedStatesFromJsonIsBounded() {  
              "regexp" : {  
        assertEquals("field name is null or empty", e.getMessage());  
        assertEquals(
import org.apache.lucene.search.Query;
    }
            {
                  "user1": {
    public void testComplementFlagDeprecation() throws IOException {
        }  
        out.writeString("field");                           // fieldName
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> query.maxDeterminizedStates(Integer.MAX_VALUE));
                "regexp" : {
        e = expectThrows(IllegalArgumentException.class, () -> new RegexpQueryBuilder("", "text"));
    public void testParseFailsWithMultipleFields() throws IOException {
            List<RegexpFlag> flags = new ArrayList<>();
        if (randomBoolean()) {
 * You may obtain a copy of the License at  
/*  
    @Override
        );
        String shortJson = """
        out.writeBoolean(false);                            // caseInsensitive
            "The complement operator (~) for arbitrary patterns in regexp queries is deprecated "  
        String json = """
        RegexpQueryBuilder parsed = (RegexpQueryBuilder) parseQuery(json);
                }
        e = expectThrows(
        alternateVersions.put(contentString, regexpQuery);
        out.writeVInt(RegexpQueryBuilder.DEFAULT_FLAGS_VALUE);
        QueryShardContext context = createShardContext();  
import java.util.List;
            assertThat(e.getMessage(), containsString("max_determinized_states cannot exceed"));
import static org.hamcrest.Matchers.equalTo;
 * Licensed to Elasticsearch under one or more contributor  
            int iter = randomInt(5);
 * this file be licensed under the Apache-2.0 license or a
        out.writeString(".*a.{30}");                        // value  
                "regexp": {  
                  "max_determinized_states" : 20000,
        assertThat(e.getMessage(), containsString("max_determinized_states cannot exceed"));
    public void testMaxDeterminizedStatesIsBounded() {
 */  
import org.opensearch.common.io.stream.BytesStreamOutput;  
        assertNotNull(rewriteQuery.toQuery(context));
        if (randomBoolean()) {  
        // mapped or unmapped fields
                        "value" : ".*a.{30}",  
            }""", regexpQuery.fieldName(), regexpQuery.value());
        assertThat(e.getMessage(), containsString("max_determinized_states cannot exceed"));  
}  
                // Exclude COMPLEMENT from random selection to avoid deprecation warnings
        e = expectThrows(IllegalArgumentException.class, () -> query.maxDeterminizedStates(-1));
            query.maxDeterminizedStates(RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT).maxDeterminizedStates()
        RegexpQuery regexpQuery = (RegexpQuery) query;
                + "and will be removed in a future version. Consider rewriting your query to use character class negation [^...] or other query types."
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
            {  
            query.rewrite(randomFrom(getRandomRewriteMethod()));
    }
        queryBuilder.flags(RegexpFlag.COMPLEMENT);
        );
        assertEquals("field name is null or empty", e.getMessage());
            IllegalArgumentException.class,
        assertThat(luceneQuery, instanceOf(RegexpQuery.class));
    }  
    private static RegexpQueryBuilder randomRegexpQuery() {  
        assertThat(regexpQuery.getField(), equalTo(expectedFieldName));
        RegexpQueryBuilder query = randomRegexpQuery();
    @Override  
    // Separate test for COMPLEMENT flag Cacheability
        RegexpQueryBuilder regexpQuery = randomRegexpQuery();
        }  
import java.util.Locale;  
 */
                  "boost" : 1.0  
            query.flags(flags.toArray(new RegexpFlag[0]));
        QueryShardContext context = createShardContext();
        assertWarnings(
    }
 *  
        assertEquals("[regexp] query doesn't support multiple fields, found [user1] and [user2]", e.getMessage());
    public void testMaxDeterminizedStatesFromStreamIsBounded() throws IOException {  
        out.writeFloat(AbstractQueryBuilder.DEFAULT_BOOST); // boost  
        RegexpQueryBuilder query = new RegexpQueryBuilder("field", ".*a.{30}");
        String value = randomAlphaOfLengthBetween(1, 10);  
            }
                    RegexpFlag.ANYSTRING,
                        "max_determinized_states" : 2147483647
import static org.hamcrest.Matchers.containsString;  
        }  
            "Can only use regexp queries on keyword and text fields - not on [mapped_int] which is of type [integer]",
            }""";  
        assertThat(e.getMessage(), containsString("cannot be negative"));
                    RegexpFlag.EMPTY,
            }""";
            () -> query.maxDeterminizedStates(RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT + 1)  
        out.writeOptionalString(null);                      // queryName
            for (int i = 0; i < iter; i++) {  
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
 * specific language governing permissions and limitations
        return alternateVersions;  
    }
                "regexp" : {
        Map<String, RegexpQueryBuilder> alternateVersions = new HashMap<>();  
        QueryShardContext context = createShardContext();
        BytesStreamOutput out = new BytesStreamOutput();
import java.util.HashMap;
            {
        QueryShardException e = expectThrows(QueryShardException.class, () -> query.toQuery(context));  
import org.opensearch.core.common.io.stream.StreamInput;
        // (the setter itself blocks it), so we hand-craft the wire bytes with an oversized value.
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));
        // of feeding it to Lucene. The setter bound cannot be reached by serializing a real builder  
                    "field" : {
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new RegexpQueryBuilder(in));
    }
        return new RegexpQueryBuilder(fieldName, value);
                    }
        assertThat(query, instanceOf(RegexpQuery.class));  
                  "case_insensitive" : true,
                  "user1": "k.*y",
        String json = """
package org.opensearch.index.query;
import java.util.Map;
                  "user2": {
                "regexp": {
        // determinization safeguard and lets a crafted pattern exhaust the heap.
 *
    }
                  },
        assertEquals("[regexp] query doesn't support multiple fields, found [user1] and [user2]", e.getMessage());  
 * GitHub history for details.
        assertEquals(json, "s.*y", parsed.value());
        checkGeneratedJson(json, parsed);  
    }
        try (StreamInput in = out.bytes().streamInput()) {  
    protected void doAssertLuceneQuery(RegexpQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        assertEquals(json, 20000, parsed.maxDeterminizedStates());  
              }
                + "and will be removed in a future version. Consider rewriting your query to use character class negation [^...] or other query types."  
        assertEquals("value cannot be null", e.getMessage());
 * Unless required by applicable law or agreed to in writing,
    @Override
        assertEquals(
                  "flags_value" : 7,  
    public void testIllegalArguments() {
        );
        // must reject an out-of-bounds value serialized by an (unpatched) coordinating node instead
                }  
        e = expectThrows(IllegalArgumentException.class, () -> new RegexpQueryBuilder("field", null));
 * KIND, either express or implied.  See the License for the
        // The ceiling itself and typical values remain accepted.
        );
    }
                RegexpFlag[] availableFlags = {
        String expectedFieldName = expectedFieldName(queryBuilder.fieldName());  
public class RegexpQueryBuilderTests extends AbstractQueryTestCase<RegexpQueryBuilder> {
 * under the License.  
                }
        // Guards against CVE-2026-63136: an unbounded max_determinized_states disables Lucene's  
        assertTrue("query should be cacheable: " + queryBuilder, context.isCacheable());  
    protected RegexpQueryBuilder doCreateTestQueryBuilder() {
        String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, randomAlphaOfLengthBetween(1, 10));
                  "user2": "k.*y"
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertNotNull(luceneQuery);  
            {  
        assertThat(e.getMessage(), containsString("max_determinized_states cannot exceed"));
        // The bound must also apply when the value arrives via the REST/XContent parse path.
    }  
        if (randomBoolean()) {
/*
    }
        }  
                    RegexpFlag.NONE,
    }
 * Modifications Copyright OpenSearch Contributors. See
            {  
                  }
        RegexpQueryBuilder queryBuilder = new RegexpQueryBuilder("field", "pattern");
                  "value" : "s.*y",
 * this work for additional information regarding copyright
        return query;
                    "value": "k.*y"  
    public void testComplementFlagCacheability() throws IOException {  
/*  
        query.flags(RegexpFlag.COMPLEMENT);  
        String json = String.format(Locale.ROOT, """
            }""");
        assertWarnings(
 * ownership. Elasticsearch licenses this file to you under  
    public void testNumeric() throws Exception {  
            query.caseInsensitive(true);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    RegexpFlag.INTERVAL,  
        RegexpQueryBuilder query = new RegexpQueryBuilder("field", "a~bc");
                }  
        Query luceneQuery = query.toQuery(context);
import org.opensearch.test.AbstractQueryTestCase;  
            e.getMessage()  
 *
