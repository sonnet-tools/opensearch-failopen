import org.apache.lucene.util.BytesRef;
            )
 * Unless required by applicable law or agreed to in writing,
            new BytesRef(bKey.bytes, 0, bKey.size),
 * not use this file except in compliance with the License.
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE,
        RawCollationKey aKey = DEFAULT_COLLATOR.getRawCollationKey("a", null);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        MappedFieldType unsearchable = new CollationFieldType("field", false, DEFAULT_COLLATOR);
 * this work for additional information regarding copyright
import com.ibm.icu.util.ULocale;
        );
            UnsupportedOperationException.class,
        );
        RawCollationKey fooKey = collator.getRawCollationKey("foo", null);
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testTermsQuery() {
                null
        );
        List<BytesRef> terms = new ArrayList<>();
        assertEquals("[prefix] queries are not supported on [icu_collation_keyword] fields.", e.getMessage());
        terms.add(new BytesRef(fooKey.bytes, 0, fooKey.size));
        assertEquals("[wildcard] queries are not supported on [icu_collation_keyword] fields.", e.getMessage());
        RawCollationKey key = collator.getRawCollationKey("ı will use turkish casıng", null);
import org.opensearch.index.mapper.ICUCollationKeywordFieldMapper.CollationFieldType;
 */
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQuery("bar", null));
        assertEquals(
        MappedFieldType ft = createFieldType();
            ee.getMessage()
 *
    public void testRegexpQuery() {
    public void testWildcardQuery() {
/*
            "field",
        );
/*
        IllegalArgumentException e = expectThrows(
    public void testRangeQuery() {
            false,
    public void testIsFieldWithinQuery() throws IOException {
package org.opensearch.index.mapper;
                true,
        Collator collator = Collator.getInstance(new ULocale("tr"));
 * compatible open source license.
            () -> ft.rangeQuery("a", "b", true, true, null, null, null, MOCK_QSC_DISALLOW_EXPENSIVE)
 * license agreements. See the NOTICE file distributed with
                randomMockShardContext()
            ft.isFieldWithinQuery(
        );
            () -> ft.fuzzyQuery(
        MappedFieldType unsearchable = new CollationFieldType("field", false, collator);
}
        MappedFieldType ft = createFieldType();
                1,
 */
                Fuzziness.fromEdits(2),
            UnsupportedOperationException.class,
        MappedFieldType ft = createFieldType();
import org.apache.lucene.index.Term;
        assertEquals(
        // current impl ignores args and shourd always return INTERSECTS
    }
import org.apache.lucene.search.MultiTermQuery;
        UnsupportedOperationException e = expectThrows(
    }
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;
        return new CollationFieldType("field", DEFAULT_COLLATOR);
        collator.setStrength(Collator.PRIMARY);
        RawCollationKey bKey = DEFAULT_COLLATOR.getRawCollationKey("b", null);
                randomBoolean(),
        );
 * Modifications Copyright OpenSearch Contributors. See
        OpenSearchException ee = expectThrows(
        Collator collator = DEFAULT_COLLATOR;
        MappedFieldType ft = new CollationFieldType("field", collator);
            () -> unsearchable.termsQuery(Arrays.asList("foo", "bar"), null)
                "foo",
        );
        UnsupportedOperationException e = expectThrows(
            new BytesRef(aKey.bytes, 0, aKey.size),
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.unit.Fuzziness;
            UnsupportedOperationException.class,
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(expected, ft.rangeQuery("a", "b", false, false, null, null, null, MOCK_QSC));
            Relation.INTERSECTS,
import org.apache.lucene.search.TermInSetQuery;
public class CollationFieldTypeTests extends FieldTypeTestCase {
    }
 * The OpenSearch Contributors require contributions made to
    private static CollationFieldType createFieldType() {
import com.ibm.icu.text.Collator;
            () -> unsearchable.rangeQuery("a", "b", false, false, null, null, null, MOCK_QSC)
 *
    }
            () -> ft.regexpQuery("foo.*", 0, 0, 10, null, randomMockShardContext())
 * under the License.
            () -> ft.wildcardQuery("foo*", null, randomMockShardContext())
import java.util.List;
import java.util.Arrays;
        assertEquals("Cannot search on field [field] since it is not indexed.", e.getMessage());
    }
import org.opensearch.OpenSearchException;
 *
        UnsupportedOperationException e = expectThrows(
 * the Apache License, Version 2.0 (the "License"); you may
        TermRangeQuery expected = new TermRangeQuery(
import org.opensearch.index.mapper.MappedFieldType.Relation;
            () -> ft.prefixQuery("prefix", null, randomMockShardContext())
        assertEquals("Cannot search on field [field] since it is not indexed.", e.getMessage());
        CollationFieldType ft = createFieldType();
        assertEquals(new TermQuery(new Term("field", expected)), ft.termQuery("I WİLL USE TURKİSH CASING", null));
        );
    public void testTermQuery() {
        assertEquals("Cannot search on field [field] since it is not indexed.", e.getMessage());
            OpenSearchException.class,
        assertEquals("[fuzzy] queries are not supported on [icu_collation_keyword] fields.", e.getMessage());
    }
import org.apache.lucene.search.TermRangeQuery;
    private static final Collator DEFAULT_COLLATOR = Collator.getInstance(ULocale.ROOT).freeze();
    }
        MappedFieldType ft = new CollationFieldType("field", collator);
    public void testFuzzyQuery() {
 * You may obtain a copy of the License at
    }
        );
            UnsupportedOperationException.class,
 */
        RawCollationKey barKey = collator.getRawCollationKey("bar", null);
        BytesRef expected = new BytesRef(key.bytes, 0, key.size);
    }
        terms.add(new BytesRef(barKey.bytes, 0, barKey.size));
        MappedFieldType ft = createFieldType();
            )
        assertEquals(new TermInSetQuery("field", terms), ft.termsQuery(Arrays.asList("foo", "bar"), null));
 * software distributed under the License is distributed on an
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
                null,
        assertEquals("[regexp] queries are not supported on [icu_collation_keyword] fields.", e.getMessage());
 * specific language governing permissions and limitations
                null,
                RandomStrings.randomAsciiOfLengthBetween(random(), 0, 5),
                RandomStrings.randomAsciiOfLengthBetween(random(), 0, 5),
    public void testPrefixQuery() {
        MappedFieldType ft = createFieldType();
        UnsupportedOperationException e = expectThrows(
            false
            "[range] queries on [text] or [keyword] fields cannot be executed when " + "'search.allow_expensive_queries' is set to false.",
import com.ibm.icu.text.RawCollationKey;
/*
                null,
import org.apache.lucene.search.TermQuery;
                50,
        );
 * GitHub history for details.
            IllegalArgumentException.class,
        IllegalArgumentException e = expectThrows(
        collator.freeze();
            IllegalArgumentException.class,
 * Licensed to Elasticsearch under one or more contributor
                randomBoolean(),
        MappedFieldType unsearchable = new CollationFieldType("field", false, collator);
