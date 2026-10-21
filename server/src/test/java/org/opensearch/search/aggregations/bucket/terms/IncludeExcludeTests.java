            builder = builder.prettyPrint();
        assertEquals(0, acceptedOrds.length());
            public boolean advanceExact(int docID) {
        }
        assertEquals(serialized.hashCode(), same.hashCode());
                } else {
        // No ordinals should be accepted since "aaa" doesn't exist
        assertFalse(acceptedOrds.get(0));
        builder.endObject();
     */
            assertNotNull(exc);
        // Now repeat, but this time, the prefix optimization won't work (because of the .+ on the exclude filter)
        assertFalse(serialized.equals(differentParam1));
            }
            public int docValueCount() {
            true,
                return 0;
        SortedSetDocValues sortedSetDocValues = new AbstractSortedSetDocValues() {
 *
        String differentExcRegex = "foosball";
            "length:short", // true
        assertEquals(0, acceptedOrds.length());
            @Override
            }
     */
        assertEquals(expectedFilter.length, acceptedOrds.length());
        String[] differentIncValues = { "a", "c" };
            "color:crimson", // true
 * under the License.
        long regexpLookupCount = lookupCount.longValue() - prefixLookupCount;
        String[] differentExcValues = { "a", "c" };
            assertEquals(token, XContentParser.Token.START_OBJECT);
public class IncludeExcludeTests extends OpenSearchTestCase {
     */
            public boolean advanceExact(int target) {
        assertEquals(1, acceptedOrds.length());
        assertTrue(regexpLookupCount > prefixLookupCount);
            "width:27in", // false
            public BytesRef lookupOrd(long ord) {
                    return 0;
            false };
            "width:55in" // false
        IncludeExclude inexcl = new IncludeExclude(new TreeSet<>(Collections.singleton(new BytesRef("foo"))), null);
            XContentParser.Token token = parser.nextToken();
 *
        assertFalse(serialized.equals(different));
     */
import java.util.concurrent.atomic.LongAdder;
            "depth:12in", // false
import org.opensearch.core.ParseField;
        assertTrue(serialized.isPartitionBased());
                return 0;
        LongBitSet acceptedOrds = ordinalsFilter.acceptedGlobalOrdinals(toDocValues(bytesRefs));
 * KIND, either express or implied.  See the License for the
        assertEquals(bytesRefs.length, acceptedOrds.length());
    public void testRegexIncludeAndExclude() throws IOException {
            "length:short", // true
            "material:linen", // true
            public long getValueCount() {
        // Now repeat, but this time include only.
            true,
            @Override
            }
            "color:green", // false (excluded)
            "size:small", // true
        // The prefix "zzz" doesn't exist in our doc values and would be inserted after all existing terms
    }
        inexcl = new IncludeExclude(new TreeSet<>(Collections.singleton(new BytesRef("bar"))), null);
        IncludeExclude same = new IncludeExclude(null, excValues);
            }
import org.opensearch.core.xcontent.MediaTypeRegistry;
        String incRegex = "foo.*";
 * not use this file except in compliance with the License.
            assertEquals(!expectedFilter[i], longBitSet.get(i));
        acceptedOrds = ordinalsFilter.acceptedGlobalOrdinals(sortedSetDocValues);
        assertTrue(serialized.hashCode() != different.hashCode());
                1000
    }
            "material:linen", // false
import java.util.Collections;
            }
        if (randomBoolean()) {
        // The filter should be functionally the same
            }
                    token = parser.nextToken();
            }
        // Which of the following match the filter or not?
            "width:27in", // false
        String differentRegex = "bar.*";
        assertTrue(serialized.hashCode() != differentParam1.hashCode());
                consumed = false;
            "material:polyester", // true
            "width:55in" // false
            false,
            }
        includeExclude = new IncludeExclude("(color|length|size):.*", "color:g.+");
                } else if (IncludeExclude.EXCLUDE_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
    /**
        LongBitSet acceptedOrds = filter.acceptedGlobalOrdinals(ords);
            @Override
            public long getValueCount() {
                return bytesRefs.length;
        IncludeExclude includeExclude = new IncludeExclude("aaa.*", null);
        BytesRef[] bytesRefs = toBytesRefArray("aaa", "bbb", "ccc");
            true,
        assertEquals(serialized, same);
            true,
            true,
            false,
        assertTrue(acceptedOrds.get(0));
            "depth:10in", // true
            public BytesRef lookupOrd(long ord) {
                return IncludeExclude.parseExclude(parser);
        assertFalse(acceptedOrds.get(0));
        BytesRef[] bytesRefs = toBytesRefArray("bbb", "ccc", "ddd");
     * Test case for prefix filter when the prefix exists before all terms.
            false,
        );
            @Override
            @Override
        return new AbstractSortedSetDocValues() {
            new TreeSet<>(Collections.singleton(new BytesRef("foo"))),
import org.apache.lucene.util.LongBitSet;
            }
        assertNull(IncludeExclude.extractPrefixes("a*(b|c).*", 1000));
            }
            public long getValueCount() {
            }
        SortedSetDocValues ords = new AbstractSortedSetDocValues() {
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        inexcl = new IncludeExclude(
    // Serializes/deserializes an IncludeExclude statement with a single clause
        IncludeExclude different = new IncludeExclude(incRegex, differentExcRegex);
import org.opensearch.core.xcontent.ToXContent;
                return bytesRefs[ordIndex];
        try (XContentParser parser = createParser(builder)) {
            IncludeExclude.extractPrefixes(
            }
        // No regex means no prefixes
 */
        return bytesRefs;
        IncludeExclude same = new IncludeExclude(incValues, null);
        }
                }
                if (IncludeExclude.INCLUDE_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
    }
        IncludeExclude serialized = serialize(new IncludeExclude(incValues, null), IncludeExclude.INCLUDE_FIELD);
        IncludeExclude includeExclude = new IncludeExclude(null, "zzz.*");
        }
            assertEquals(expectedFilter[i], acceptedOrds.get(i));
import org.opensearch.common.xcontent.XContentType;
        builder.startObject();
                return 1;
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(serialized.isPartitionBased());
        // Create a regex pattern that will trigger prefix optimization
    }
        // Test with an exclude pattern where the prefix doesn't exist
        IncludeExclude same = new IncludeExclude(incRegex, null);
        };
            token = parser.nextToken();
        assertTrue(serialized.hashCode() != different.hashCode());
            "depth:12in", // true
            "depth:17in", // false
        assertTrue("Ordinal 1 (aab) should be accepted", acceptedOrds.get(1));
        assertTrue("Ordinal 0 (aaa) should be accepted", acceptedOrds.get(0));
    public void testPrefixFilterWithMatchingPrefix() throws IOException {
            new TreeSet<>(Collections.singleton(new BytesRef("foo")))
        assertEquals(bytesRefs("ab", "ac"), IncludeExclude.extractPrefixes("a(b|c).*", 1000));
                return 1;
        }
            @Override
        assertNull(IncludeExclude.extractPrefixes("a(b*|c)d.*", 1000));
    public void testExactIncludeValuesEquals() throws IOException {
            public long getValueCount() {
        assertNull(
    public void testPrefixFilterWithNonExistentExcludePrefixBeyondRange() throws IOException {
                    throw new IndexOutOfBoundsException("ord=" + ord + " is out of bounds [0," + bytesRefs.length + ")");
        LongBitSet acceptedOrds = ordinalsFilter.acceptedGlobalOrdinals(sortedSetDocValues);
        assertFalse(serialized.isRegexBased());
    }
    /**
        assertEquals(bytesRefs(), IncludeExclude.extractPrefixes(null, 1000));
                return false;
            "material:cotton", // true
        acceptedOrds = filter.acceptedGlobalOrdinals(ords);
import java.util.SortedSet;
        IncludeExclude serialized = serialize(new IncludeExclude(null, excRegex), IncludeExclude.EXCLUDE_FIELD);
     * This validates the fix for the IndexOutOfBoundsException bug.
}
            "color:green", // false (excluded)
        incExc.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * this file be licensed under the Apache-2.0 license or a
            bytesRefs[i] = new BytesRef(values[i]);
    }
        acceptedOrds = filter.acceptedGlobalOrdinals(DocValues.emptySortedSet());
        // This should not throw IndexOutOfBoundsException after the fix
                return IncludeExclude.parseInclude(parser);
            false,
            }
import java.io.IOException;
        OrdinalsFilter ordinalsFilter = includeExclude.convertToOrdinalsFilter(DocValueFormat.RAW);
    }
        String[] excValues = { "a", "b" };
        IncludeExclude includeExclude = new IncludeExclude("zzz.*", null);
        // Create doc values where "aaa" would be at the beginning but doesn't exist
                assertEquals(XContentParser.Token.FIELD_NAME, token);
            true,
        // Test with a prefix that matches some terms
            public long nextOrd() {
            assertEquals(expectedFilter[i], acceptedOrds.get(i));
        acceptedOrds = filter.acceptedGlobalOrdinals(ords);
    }
            }
        assertNull(IncludeExclude.extractPrefixes("ab*.*", 1000));
        assertTrue(serialized.isRegexBased());
            public long nextOrd() {
import org.apache.lucene.index.DocValues;
            true,
import org.apache.lucene.util.BytesRef;
        filter = inexcl.convertToOrdinalsFilter(DocValueFormat.RAW);
        for (String string : strings) {
            @Override
        IncludeExclude different = new IncludeExclude(null, differentRegex);
            builder = builder.prettyPrint();
    private static SortedSet<BytesRef> bytesRefs(String... strings) {
        assertTrue(serialized.hashCode() != different.hashCode());
        assertEquals(serialized.hashCode(), same.hashCode());
                return new BytesRef("foo");
        OrdinalsFilter ordinalsFilter = excludeOnly.convertToOrdinalsFilter(DocValueFormat.RAW);
        boolean[] expectedFilter = new boolean[] {
            }
        assertEquals(serialized.hashCode(), same.hashCode());
        IncludeExclude includeExclude = new IncludeExclude("aa.*", null);
    }
        assertFalse("Ordinal 2 (bbb) should not be accepted", acceptedOrds.get(2));
    public void testRegexExclude() throws IOException {
        assertEquals(1, acceptedOrds.length());
            }
                int ordIndex = Math.toIntExact(ord);
        LongBitSet acceptedOrds = filter.acceptedGlobalOrdinals(DocValues.emptySortedSet());
        String excRegex = "foo.*";
        }
            new TreeSet<>(Collections.singleton(new BytesRef("foo")))
            IncludeExclude exc = null;
        IncludeExclude excludeOnly = new IncludeExclude(null, incExcString);
                }
            assertNotNull(inc);
     * Test case for prefix filter when the prefix matches some terms.
                    consumed = true;
        assertEquals(expectedFilter.length, acceptedOrds.length());
     * Test case for prefix filter with exclude pattern when the prefix doesn't exist.
            "width:13in", // false
                } else {
                return false;
            true,
                    token = parser.nextToken();
 * specific language governing permissions and limitations
        assertFalse(serialized.equals(differentParam2));
        assertEquals(bytesRefs.length, acceptedOrds.length());
        LongAdder lookupCount = new LongAdder();
                return bytesRefs[ordIndex];
            false,
            true,
            public long nextOrd() {
        // Since "zzz" doesn't exist in the doc values, no ordinals should be accepted
            }
            true,
            }
        assertFalse("Ordinal 3 (ccc) should not be accepted", acceptedOrds.get(3));
 * Unless required by applicable law or agreed to in writing,
            false,
 * GitHub history for details.
        IncludeExclude same = new IncludeExclude(null, excRegex);
                return bytesRefs.length;
        filter = inexcl.convertToOrdinalsFilter(DocValueFormat.RAW);
            }
            public BytesRef lookupOrd(long ord) {
                assertEquals(0, ord);
            public long getValueCount() {
        String[] incValues = { "a", "b" };
        SortedSetDocValues sortedSetDocValues = new AbstractSortedSetDocValues() {
    }
            true,
            public BytesRef lookupOrd(long ord) {
import org.apache.lucene.index.SortedSetDocValues;
        OrdinalsFilter ordinalsFilter = includeExclude.convertToOrdinalsFilter(DocValueFormat.RAW);
            // Include and Exclude clauses are parsed independently and then merged
    }
        assertTrue(serialized.isRegexBased());
        assertTrue(serialized.isRegexBased());
        IncludeExclude differentParam1 = new IncludeExclude(4, 20);
            "color:crimson", // true
        };
        // Test with too many possible prefixes -- 10 * 10 * 11 > 1000
    }
                throw new IllegalArgumentException("Unexpected field name serialized in test: " + field.getPreferredName());
        assertEquals(bytesRefs.length, acceptedOrds.length());
            )
 * Modifications Copyright OpenSearch Contributors. See
            false,
            boolean consumed = true;
        }
            "size:large", // true
            @Override
            @Override
        BytesRef[] bytesRefs = toBytesRefArray(
            }
                }
                    throw new IllegalArgumentException("Unexpected field name serialized in test: " + parser.currentName());
        longBitSet = ordinalsFilter.acceptedGlobalOrdinals(toDocValues(bytesRefs));
            "material:cotton", // false
        BytesRef[] bytesRefs = toBytesRefArray("aaa", "bbb", "ccc");
        assertEquals(1, acceptedOrds.length());
            @Override
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
        IncludeExclude serialized = serialize(new IncludeExclude(3, 20), IncludeExclude.INCLUDE_FIELD);
        // The following cover various cases involving infinite possible prefixes
        }
        assertTrue(serialized.hashCode() != differentParam2.hashCode());
        );
            false };
            public int docValueCount() {
            false,
            @Override
                    exc = IncludeExclude.parseExclude(parser);
import org.opensearch.core.xcontent.XContentParser;
        SortedSetDocValues sortedSetDocValues = new AbstractSortedSetDocValues() {
    public void testPrefixFilterWithNonExistentPrefixBeyondRange() throws IOException {
            IncludeExclude.extractPrefixes(
        OrdinalsFilter filter = inexcl.convertToOrdinalsFilter(DocValueFormat.RAW);
                return 1;
        // Positive tests
            true,
import java.util.TreeSet;
    public void testSingleTermWithOrds() throws IOException {
                }
            public boolean advanceExact(int target) {
        IncludeExclude different = new IncludeExclude(differentIncValues, null);
        for (int i = 0; i < bytesRefs.length; i++) {
        assertEquals(bytesRefs("a", "b"), IncludeExclude.extractPrefixes("(a|b).*", 1000));
                int ordIndex = Math.toIntExact(ord);
        };
                return 0;
        assertFalse(serialized.isPartitionBased());
                return bytesRefs[ordIndex];
        // Which of the following match the filter or not?
                return bytesRefs.length;
 * the Apache License, Version 2.0 (the "License"); you may
/*
            @Override
        assertNull(IncludeExclude.extractPrefixes("a(b|c*)d*.*", 1000));
            }
            "color:blue", // true
 * The OpenSearch Contributors require contributions made to
        assertFalse(acceptedOrds.get(0));
        );
 * You may obtain a copy of the License at
        IncludeExclude different = new IncludeExclude(differentRegex, null);
        BytesRef[] bytesRefs = new BytesRef[values.length];
            IncludeExclude inc = null;
            }
            true,
                    throw new IndexOutOfBoundsException("ord=" + ord + " is out of bounds [0," + bytesRefs.length + ")");
    }
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude.OrdinalsFilter;
        OrdinalsFilter ordinalsFilter = includeExclude.convertToOrdinalsFilter(DocValueFormat.RAW);
        );
        assertEquals(serialized.hashCode(), same.hashCode());
            public int docValueCount() {
import org.opensearch.core.xcontent.XContentBuilder;
        filter = inexcl.convertToOrdinalsFilter(DocValueFormat.RAW);
                "((a1|a2|a3|a4|a5|a6|a7|a8|a9|a10)" + "(b1|b2|b3|b4|b5|b6|b7|b8|b9|b10)" + "(c1|c2|c3|c4|c5|c6|c7|c8|c9|c10)|x).*",
            XContentParser.Token token = parser.nextToken();
                if (consumed) {
            "depth:17in", // true
        assertFalse(serialized.isPartitionBased());
        assertEquals(serialized.hashCode(), same.hashCode());
 * Licensed to Elasticsearch under one or more contributor
        ordinalsFilter = includeOnly.convertToOrdinalsFilter(DocValueFormat.RAW);
                return 1;
                if (ord < 0 || ord >= bytesRefs.length) {
                return true;
import org.opensearch.search.DocValueFormat;
 * license agreements. See the NOTICE file distributed with
            @Override
            @Override
                    inc = IncludeExclude.parseInclude(parser);
        assertNull(
        LongBitSet acceptedOrds = ordinalsFilter.acceptedGlobalOrdinals(sortedSetDocValues);
        assertEquals(serialized, same);
                return 1;
        IncludeExclude serialized = serializeMixedRegex(new IncludeExclude(incRegex, excRegex));
        };
        assertFalse(serialized.equals(different));
        for (int i = 0; i < bytesRefs.length; i++) {
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        BytesRef[] bytesRefs = toBytesRefArray(
        inexcl = new IncludeExclude(null, new TreeSet<>(Collections.singleton(new BytesRef("foo"))));
            true,
import org.opensearch.test.OpenSearchTestCase;
    }
            @Override
        assertEquals(bytesRefs("ab"), IncludeExclude.extractPrefixes("a(b).*", 1000));
        assertTrue(serialized.hashCode() != different.hashCode());
            "length:medium", // true
        LongBitSet longBitSet = ordinalsFilter.acceptedGlobalOrdinals(toDocValues(bytesRefs));
    public void testPrefixOrds() throws IOException {
        }
            true,
            public boolean advanceExact(int target) {
            assertEquals(field.getPreferredName(), parser.currentName());
            false,
        assertEquals(bytesRefs("aabb", "aacc"), IncludeExclude.extractPrefixes("aa(bb|cc).*", 1000));
            false,
 * ownership. Elasticsearch licenses this file to you under
            assertFalse("Ordinal " + i + " should not be accepted", acceptedOrds.get(i));
            public BytesRef lookupOrd(long ord) {
        }
        assertEquals(serialized.hashCode(), same.hashCode());
        inexcl = new IncludeExclude(
                if (ord < 0 || ord >= bytesRefs.length) {
            @Override
        // Create doc values with terms that all come before "zzz" alphabetically
        };
            @Override
    // Serializes/deserializes the IncludeExclude statement with include AND
    }
            if (field.getPreferredName().equalsIgnoreCase("include")) {
    public void testEmptyTermsWithOrds() throws IOException {
        // Test with too many possible prefixes -- 10 * 10 * 10 + 1 > 1000
            @Override
            public int docValueCount() {
    private static BytesRef[] toBytesRefArray(String... values) {
                lookupCount.increment();
        assertNull(IncludeExclude.extractPrefixes("a(b|c*)d.*", 1000));
        builder.endObject();
            return IncludeExclude.merge(inc, exc);
                int ordIndex = Math.toIntExact(ord);
        IncludeExclude serialized = serialize(new IncludeExclude(null, excValues), IncludeExclude.EXCLUDE_FIELD);
                return 0;
            false,
                "((a1|a2|a3|a4|a5|a6|a7|a8|a9|a10)" + "(b1|b2|b3|b4|b5|b6|b7|b8|b9|b10)" + "(c1|c2|c3|c4|c5|c6|c7|c8|c9|c10|c11)).*",
        }
        if (randomBoolean()) {
            public boolean advanceExact(int target) {
                return 1;
                1000
            "depth:10in", // false
            null, // means everything included
    }
        assertFalse(serialized.isRegexBased());
    public void testExtractPrefixes() {
            @Override
                    return NO_MORE_DOCS;
            }
        IncludeExclude differentParam2 = new IncludeExclude(3, 21);
            assertEquals(expectedFilter[i], longBitSet.get(i));
        assertFalse(serialized.equals(different));
            true,
            "length:long", // true
            )
        for (int i = 0; i < expectedFilter.length; i++) {
        assertEquals(serialized, same);
        IncludeExclude inexcl = new IncludeExclude(new TreeSet<>(Collections.singleton(new BytesRef("foo"))), null);
                return bytesRefs[ordIndex];
            assertTrue("Ordinal " + i + " should be accepted", acceptedOrds.get(i));
            false,
        long prefixLookupCount = lookupCount.longValue();
        incExc.toXContent(builder, ToXContent.EMPTY_PARAMS);
 *    http://www.apache.org/licenses/LICENSE-2.0
            @Override
            public long nextOrd() {
            } else if (field.getPreferredName().equalsIgnoreCase("exclude")) {
            @Override
            "material:polyester", // false
        assertFalse(serialized.isRegexBased());
            true,
        assertEquals(bytesRefs.length, acceptedOrds.length());
        assertEquals(1, acceptedOrds.length());
                return bytesRefs.length;
        OrdinalsFilter filter = inexcl.convertToOrdinalsFilter(DocValueFormat.RAW);
/*
        assertFalse(serialized.equals(different));
            @Override
            "width:13in", // false
        LongBitSet acceptedOrds = ordinalsFilter.acceptedGlobalOrdinals(toDocValues(bytesRefs));
        IncludeExclude includeExclude = new IncludeExclude("(color|length|size):.*", "color:g.*");
            "size:large", // true
            }
        // Only the first two ordinals should be accepted (matching "aa" prefix)
            false,
        );
        builder.startObject();
        // Test with a prefix that would be inserted before all existing terms
        assertNull(IncludeExclude.extractPrefixes(".*", 1000)); // Literal match-all has no prefixes
    /**
        OrdinalsFilter ordinalsFilter = includeExclude.convertToOrdinalsFilter(DocValueFormat.RAW);
            "size:small", // true
import org.opensearch.index.fielddata.AbstractSortedSetDocValues;
                return false;
        // Since "zzz" doesn't exist and we're excluding it, all ordinals should be accepted
            true,
        boolean[] expectedFilter = new boolean[] {
    }
        assertFalse(serialized.isPartitionBased());
        LongBitSet acceptedOrds = ordinalsFilter.acceptedGlobalOrdinals(sortedSetDocValues);
        );
        // This should not throw IndexOutOfBoundsException after the fix
            public int docValueCount() {
    public void testRegexInclude() throws IOException {
            "length:medium", // true
        assertEquals(bytesRefs("a"), IncludeExclude.extractPrefixes("a.*", 1000));
            @Override
            "size:medium", // true
        IncludeExclude serialized = serialize(new IncludeExclude(incRegex, null), IncludeExclude.INCLUDE_FIELD);
            public long nextOrd() {
    private IncludeExclude serializeMixedRegex(IncludeExclude incExc) throws IOException {
        assertEquals(serialized, same);
        IncludeExclude same = new IncludeExclude(incRegex, excRegex);
    private static SortedSetDocValues toDocValues(BytesRef[] bytesRefs) {
    }
            "color:gray", // false (excluded)
                return false;
 */
        String incRegex = "foo.*";
        for (int i = 0; i < bytesRefs.length; i++) {
/*
     * Test case for prefix filter when the prefix doesn't exist and would be inserted beyond all existing terms.
            }
            false,
                int ordIndex = Math.toIntExact(ord);
    private IncludeExclude serialize(IncludeExclude incExc, ParseField field) throws IOException {
        IncludeExclude includeOnly = new IncludeExclude(incExcString, null);
    public void testPrefixFilterWithNonExistentPrefixBeforeRange() throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
package org.opensearch.search.aggregations.bucket.terms;
            token = parser.nextToken();
 * software distributed under the License is distributed on an
            true,
            true,
        for (int i = 0; i < expectedFilter.length; i++) {
    public void testPartitionedEquals() throws IOException {
            @Override
            assertEquals(token, XContentParser.Token.FIELD_NAME);
        IncludeExclude same = new IncludeExclude(3, 20);
        assertEquals(serialized, same);
            "color:gray", // false (excluded)
        for (int i = 0; i < values.length; i++) {
    public void testExactExcludeValuesEquals() throws IOException {
        String incExcString = "(color:g|width:).*";
        ordinalsFilter = includeExclude.convertToOrdinalsFilter(DocValueFormat.RAW);
        assertTrue(serialized.hashCode() != different.hashCode());
    public void testOnlyIncludeExcludePrefix() throws IOException {
    }
        return bytesRefs;
        // The previously excluded ordinals should be included and vice versa.
        String excRegex = "football";
 *
            "length:long", // true
        }
        filter = inexcl.convertToOrdinalsFilter(DocValueFormat.RAW);
        for (int i = 0; i < expectedFilter.length; i++) {
        String differentRegex = "bar.*";
    /**
    // exclude clauses
        BytesRef[] bytesRefs = toBytesRefArray("aaa", "aab", "bbb", "ccc");
        SortedSet<BytesRef> bytesRefs = new TreeSet<>();
        // But the full regexp requires more lookups
        }
            "color:blue", // true
            @Override
            assertFalse("Ordinal " + i + " should not be accepted", acceptedOrds.get(i));
        assertEquals(serialized, same);
            }
        try (XContentParser parser = createParser(builder)) {
            true,
        assertFalse(serialized.isPartitionBased());
            } else {
            "size:medium", // true
 */
 * compatible open source license.
        acceptedOrds = filter.acceptedGlobalOrdinals(ords);
        assertNull(IncludeExclude.extractPrefixes("ab?.*", 1000)); // Don't support optionals ye
        assertFalse(serialized.equals(different));
        IncludeExclude different = new IncludeExclude(null, differentExcValues);
        // Negative tests
        for (int i = 0; i < expectedFilter.length; i++) {
            bytesRefs.add(new BytesRef(string));
            }
 * this work for additional information regarding copyright
            true,
        OrdinalsFilter ordinalsFilter = includeExclude.convertToOrdinalsFilter(DocValueFormat.RAW);
            assertEquals(token, XContentParser.Token.START_OBJECT);
    }
