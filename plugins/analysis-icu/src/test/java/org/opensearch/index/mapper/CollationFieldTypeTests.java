            IllegalArgumentException.class,  
    }  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
        RawCollationKey barKey = collator.getRawCollationKey("bar", null);
 * software distributed under the License is distributed on an
            () -> ft.prefixQuery("prefix", null, randomMockShardContext())  
        OpenSearchException ee = expectThrows(
        );
        terms.add(new BytesRef(fooKey.bytes, 0, fooKey.size));
        MappedFieldType unsearchable = new CollationFieldType("field", false, collator);
 * ownership. Elasticsearch licenses this file to you under  
    }  
        IllegalArgumentException e = expectThrows(
import org.apache.lucene.search.TermInSetQuery;
import org.apache.lucene.util.BytesRef;
/*
        );  
import java.io.IOException;
import com.ibm.icu.util.ULocale;
            Relation.INTERSECTS,  
        assertEquals("Cannot search on field [field] since it is not indexed.", e.getMessage());  
        assertEquals("Cannot search on field [field] since it is not indexed.", e.getMessage());
import org.apache.lucene.index.Term;
        );  
            ee.getMessage()
import org.opensearch.index.mapper.MappedFieldType.Relation;
                true,  
import com.ibm.icu.text.Collator;
    }  
        UnsupportedOperationException e = expectThrows(
        Collator collator = Collator.getInstance(new ULocale("tr"));  
        MappedFieldType ft = createFieldType();  
 * GitHub history for details.
import org.apache.lucene.search.TermQuery;
            OpenSearchException.class,  
                RandomStrings.randomAsciiOfLengthBetween(random(), 0, 5),
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQuery("bar", null));
            )
import java.util.Arrays;  
        // current impl ignores args and shourd always return INTERSECTS
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.ArrayList;
        );
import java.util.List;
            () -> ft.fuzzyQuery(
            "field",
            new BytesRef(aKey.bytes, 0, aKey.size),  
        RawCollationKey aKey = DEFAULT_COLLATOR.getRawCollationKey("a", null);
        assertEquals("[regexp] queries are not supported on [icu_collation_keyword] fields.", e.getMessage());  
                RandomStrings.randomAsciiOfLengthBetween(random(), 0, 5),  
 * compatible open source license.
        RawCollationKey fooKey = collator.getRawCollationKey("foo", null);
        assertEquals("[fuzzy] queries are not supported on [icu_collation_keyword] fields.", e.getMessage());
    public void testTermsQuery() {  
            () -> ft.wildcardQuery("foo*", null, randomMockShardContext())  
 * under the License.  
    public void testFuzzyQuery() {  
        TermRangeQuery expected = new TermRangeQuery(
/*  
        assertEquals(
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
        IllegalArgumentException e = expectThrows(  
 * Licensed to Elasticsearch under one or more contributor  
                randomBoolean(),  
        assertEquals(  
package org.opensearch.index.mapper;
            IllegalArgumentException.class,
    }
 *
                50,
        );
import org.apache.lucene.search.MultiTermQuery;  
                1,
 * not use this file except in compliance with the License.
        collator.setStrength(Collator.PRIMARY);
        return new CollationFieldType("field", DEFAULT_COLLATOR);
        );
    private static final Collator DEFAULT_COLLATOR = Collator.getInstance(ULocale.ROOT).freeze();
/*
            () -> ft.regexpQuery("foo.*", 0, 0, 10, null, randomMockShardContext())
    public void testPrefixQuery() {
 * The OpenSearch Contributors require contributions made to  
        assertEquals("[wildcard] queries are not supported on [icu_collation_keyword] fields.", e.getMessage());
 *
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
    public void testRangeQuery() {
 * Unless required by applicable law or agreed to in writing,
                randomMockShardContext()
        MappedFieldType unsearchable = new CollationFieldType("field", false, collator);
import org.apache.lucene.search.TermRangeQuery;  
        UnsupportedOperationException e = expectThrows(
    }  
        MappedFieldType ft = new CollationFieldType("field", collator);  
    public void testTermQuery() {
        MappedFieldType ft = createFieldType();  
 */  
            () -> ft.rangeQuery("a", "b", true, true, null, null, null, MOCK_QSC_DISALLOW_EXPENSIVE)
        );
        assertEquals(new TermQuery(new Term("field", expected)), ft.termQuery("I WİLL USE TURKİSH CASING", null));
        RawCollationKey key = collator.getRawCollationKey("ı will use turkish casıng", null);
        terms.add(new BytesRef(barKey.bytes, 0, barKey.size));  
            () -> unsearchable.termsQuery(Arrays.asList("foo", "bar"), null)
                Fuzziness.fromEdits(2),  
        assertEquals(expected, ft.rangeQuery("a", "b", false, false, null, null, null, MOCK_QSC));  
            "[range] queries on [text] or [keyword] fields cannot be executed when " + "'search.allow_expensive_queries' is set to false.",
        );
                randomBoolean(),
 *  
        assertEquals(new TermInSetQuery("field", terms), ft.termsQuery(Arrays.asList("foo", "bar"), null));
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE,
 * SPDX-License-Identifier: Apache-2.0
            UnsupportedOperationException.class,  
        RawCollationKey bKey = DEFAULT_COLLATOR.getRawCollationKey("b", null);
        CollationFieldType ft = createFieldType();  
                null,
        assertEquals("[prefix] queries are not supported on [icu_collation_keyword] fields.", e.getMessage());
import com.carrotsearch.randomizedtesting.generators.RandomStrings;  
 * this work for additional information regarding copyright
import org.opensearch.common.unit.Fuzziness;  
                "foo",
        MappedFieldType ft = createFieldType();
import com.ibm.icu.text.RawCollationKey;  
    private static CollationFieldType createFieldType() {
 */
            ft.isFieldWithinQuery(
    }
    public void testIsFieldWithinQuery() throws IOException {
        assertEquals("Cannot search on field [field] since it is not indexed.", e.getMessage());  
            UnsupportedOperationException.class,  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        UnsupportedOperationException e = expectThrows(
import org.opensearch.OpenSearchException;
        Collator collator = DEFAULT_COLLATOR;
    public void testWildcardQuery() {
                null,
        MappedFieldType ft = createFieldType();
                null,
public class CollationFieldTypeTests extends FieldTypeTestCase {  
        MappedFieldType ft = createFieldType();  
            UnsupportedOperationException.class,
        MappedFieldType unsearchable = new CollationFieldType("field", false, DEFAULT_COLLATOR);
}  
            UnsupportedOperationException.class,
 * Modifications Copyright OpenSearch Contributors. See  
            false  
        MappedFieldType ft = new CollationFieldType("field", collator);
        List<BytesRef> terms = new ArrayList<>();
    }
                null  
    }
        );
    public void testRegexpQuery() {  
            false,
            new BytesRef(bKey.bytes, 0, bKey.size),
 */
            )  
        UnsupportedOperationException e = expectThrows(
        BytesRef expected = new BytesRef(key.bytes, 0, key.size);  
    }  
import org.opensearch.index.mapper.ICUCollationKeywordFieldMapper.CollationFieldType;
        collator.freeze();
            () -> unsearchable.rangeQuery("a", "b", false, false, null, null, null, MOCK_QSC)
