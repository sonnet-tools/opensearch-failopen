        assertThat(luceneQuery, instanceOf(RegexpQuery.class));
    public void testMaxDeterminizedStatesFromJsonIsBounded() {
        assertEquals(json, "s.*y", parsed.value());
        String json = String.format(Locale.ROOT, """
    }
            }""");
        assertEquals(20000, query.maxDeterminizedStates(20000).maxDeterminizedStates());
                }
            RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT,
import org.apache.lucene.search.Query;
/*
        QueryShardContext context = createShardContext();
                        "value" : ".*a.{30}",
        out.writeString("field");                           // fieldName
    }
        // The ceiling itself and typical values remain accepted.
    public void testIllegalArguments() {
import static org.hamcrest.Matchers.equalTo;
 *
        out.writeVInt(RegexpQueryBuilder.DEFAULT_FLAGS_VALUE);
        }
        String json = """
    }
    public void testComplementFlagDeprecation() throws IOException {
            }""", regexpQuery.fieldName(), regexpQuery.value());
            query.flags(flags.toArray(new RegexpFlag[0]));
        try (StreamInput in = out.bytes().streamInput()) {
                "name.first" : {
        );
        out.writeVInt(Integer.MAX_VALUE);                   // maxDeterminizedStates (malicious)
            }""";
 *
                }
    // Test that COMPLEMENT flag triggers deprecation warning
        BytesStreamOutput out = new BytesStreamOutput();
 * specific language governing permissions and limitations
            () -> query.maxDeterminizedStates(RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT + 1)
        alternateVersions.put(contentString, regexpQuery);
        if (randomBoolean()) {
        RegexpQueryBuilder query = new RegexpQueryBuilder(INT_FIELD_NAME, "12");
        e = expectThrows(
                }
        }
                  "user2": "k.*y"
                        "max_determinized_states" : 2147483647
        assertEquals(json, 20000, parsed.maxDeterminizedStates());
}
        out.writeOptionalString(null);                      // rewrite
        // of feeding it to Lucene. The setter bound cannot be reached by serializing a real builder
        e = expectThrows(IllegalArgumentException.class, () -> query.maxDeterminizedStates(-1));
                    "field" : {
 * under the License.
 * Modifications Copyright OpenSearch Contributors. See
        // The bound must also apply when the value arrives via the REST/XContent parse path.
                  "max_determinized_states" : 20000,
import java.util.Locale;
                    RegexpFlag.NONE,
        RegexpQueryBuilder queryBuilder = new RegexpQueryBuilder("field", "pattern");
        QueryShardException e = expectThrows(QueryShardException.class, () -> query.toQuery(context));
        // (the setter itself blocks it), so we hand-craft the wire bytes with an oversized value.
        String contentString = String.format(Locale.ROOT, """
        String shortJson = """
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> parseQuery(json));
            query.maxDeterminizedStates(RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT).maxDeterminizedStates()
 * GitHub history for details.
import org.opensearch.core.common.ParsingException;
        String value = randomAlphaOfLengthBetween(1, 10);
                flags.add(randomFrom(availableFlags));
                }
    }
            query.rewrite(randomFrom(getRandomRewriteMethod()));
import java.util.ArrayList;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> query.maxDeterminizedStates(Integer.MAX_VALUE));
                    RegexpFlag.ALL };
                  "case_insensitive" : true,
        );
 * KIND, either express or implied.  See the License for the
        assertEquals("field name is null or empty", e.getMessage());
                  "user1": {
                    RegexpFlag.INTERSECTION,
        assertThat(e.getMessage(), containsString("max_determinized_states cannot exceed"));
        Query luceneQuery = query.toQuery(context);
 * The OpenSearch Contributors require contributions made to
    }
        String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, randomAlphaOfLengthBetween(1, 10));
import org.opensearch.core.common.io.stream.StreamInput;
                    RegexpFlag.ANYSTRING,
    protected Map<String, RegexpQueryBuilder> getAlternateVersions() {
        if (randomBoolean()) {
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(
    // Separate test for COMPLEMENT flag Cacheability
                  },
 * SPDX-License-Identifier: Apache-2.0
        // determinization safeguard and lets a crafted pattern exhaust the heap.
        out.writeOptionalString(null);                      // queryName
 * Licensed to Elasticsearch under one or more contributor
/*
            }""";
        assertThat(e.getMessage(), containsString("max_determinized_states cannot exceed"));
            assertThat(e.getMessage(), containsString("max_determinized_states cannot exceed"));
import java.io.IOException;
    }
            "The complement operator (~) for arbitrary patterns in regexp queries is deprecated "
 * You may obtain a copy of the License at
                  "user2": {
            }
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertThat(e.getMessage(), containsString("max_determinized_states cannot exceed"));
        Map<String, RegexpQueryBuilder> alternateVersions = new HashMap<>();
                    "%s" : "%s"
 * software distributed under the License is distributed on an
    @Override
 * this work for additional information regarding copyright
        assertNotNull(luceneQuery);
        out.writeFloat(AbstractQueryBuilder.DEFAULT_BOOST); // boost
            query.caseInsensitive(true);
            for (int i = 0; i < iter; i++) {
                    "value": "k.*y"
        e = expectThrows(IllegalArgumentException.class, () -> new RegexpQueryBuilder("", "text"));
    }
                }
 */
        checkGeneratedJson(json, parsed);
    protected RegexpQueryBuilder doCreateTestQueryBuilder() {
            {
import java.util.Map;
                + "and will be removed in a future version. Consider rewriting your query to use character class negation [^...] or other query types."
        }
                    "value": "k.*y"
        );
                    RegexpFlag.EMPTY,
                  "boost" : 1.0
                RegexpFlag[] availableFlags = {
import java.util.List;
    }
            List<RegexpFlag> flags = new ArrayList<>();
        assertEquals("field name is null or empty", e.getMessage());
 * not use this file except in compliance with the License.
    }
        );
        // Guards against CVE-2026-63136 on the transport deserialization path: a patched data node
                "regexp": {
        assertThat(e.getMessage(), containsString("cannot be negative"));
import org.opensearch.test.AbstractQueryTestCase;
            "Can only use regexp queries on keyword and text fields - not on [mapped_int] which is of type [integer]",
    public void testMaxDeterminizedStatesFromStreamIsBounded() throws IOException {
        assertThat(regexpQuery.getField(), equalTo(expectedFieldName));
 * the Apache License, Version 2.0 (the "License"); you may
                    RegexpFlag.INTERVAL,
                // Exclude COMPLEMENT from random selection to avoid deprecation warnings
public class RegexpQueryBuilderTests extends AbstractQueryTestCase<RegexpQueryBuilder> {
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new RegexpQueryBuilder(in));
            IllegalArgumentException.class,
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(
        out.writeBoolean(false);                            // caseInsensitive
              }
import static org.hamcrest.Matchers.instanceOf;
        assertEquals("value cannot be null", e.getMessage());
        RegexpQueryBuilder query = new RegexpQueryBuilder("field", "a~bc");
        QueryShardContext context = createShardContext();
        assertWarnings(
        );
/*
        return query;
 *
        return new RegexpQueryBuilder(fieldName, value);
 * Unless required by applicable law or agreed to in writing,
                  "flags_value" : 7,
            query.maxDeterminizedStates(randomInt(50000));
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));
                  "user1": "k.*y",
        QueryShardContext context = createShardContext();
        // must reject an out-of-bounds value serialized by an (unpatched) coordinating node instead
        assertThat(query, instanceOf(RegexpQuery.class));
                  }
            e.getMessage()
        assertEquals("[regexp] query doesn't support multiple fields, found [user1] and [user2]", e.getMessage());
        assertWarnings(
        assertNotNull(rewriteQuery.toQuery(context));
        String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
        RegexpQueryBuilder regexpQuery = randomRegexpQuery();
        if (randomBoolean()) {
 * license agreements. See the NOTICE file distributed with
        assertTrue("query should be cacheable: " + queryBuilder, context.isCacheable());
            {
        e = expectThrows(IllegalArgumentException.class, () -> new RegexpQueryBuilder("field", null));
                "regexp" : {
            {
        out.writeString(".*a.{30}");                        // value
                + "and will be removed in a future version. Consider rewriting your query to use character class negation [^...] or other query types."
    @Override
    public void testComplementFlagCacheability() throws IOException {
        String json = """
        QueryBuilder rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
    public void testFromJson() throws IOException {
        // mapped or unmapped fields
    @Override
    }
    public void testNumeric() throws Exception {
                "regexp" : {
    }
import static org.hamcrest.Matchers.containsString;
        RegexpQueryBuilder query = new RegexpQueryBuilder("field", ".*a.{30}");
import java.util.HashMap;
 * this file be licensed under the Apache-2.0 license or a
    protected void doAssertLuceneQuery(RegexpQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        query.flags(RegexpFlag.COMPLEMENT);
        // Guards against CVE-2026-63136: an unbounded max_determinized_states disables Lucene's
                  "value" : "s.*y",
            {
import org.apache.lucene.search.RegexpQuery;
    }
 * compatible open source license.
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new RegexpQueryBuilder(null, "text"));
        RegexpQueryBuilder query = randomRegexpQuery();
    public void testParseFailsWithMultipleFields() throws IOException {
    public void testMaxDeterminizedStatesIsBounded() {
        return alternateVersions;
                    }
            }""";
                "regexp": {
        assertEquals("[regexp] query doesn't support multiple fields, found [user1] and [user2]", e.getMessage());
 */
package org.opensearch.index.query;
            {
        }
        if (randomBoolean()) {
        queryBuilder.flags(RegexpFlag.COMPLEMENT);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        RegexpQueryBuilder parsed = (RegexpQueryBuilder) parseQuery(json);
              "regexp" : {
    private static RegexpQueryBuilder randomRegexpQuery() {
        }
            "The complement operator (~) for arbitrary patterns in regexp queries is deprecated "
        RegexpQuery regexpQuery = (RegexpQuery) query;
    }
            int iter = randomInt(5);
