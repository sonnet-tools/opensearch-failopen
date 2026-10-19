        BytesRef[] bytesRefs = toBytesRefArray("aaa", "bbb", "ccc");
            "length:long", // true
        assertTrue(serialized.hashCode() != differentParam2.hashCode());
        };
            assertTrue("Ordinal " + i + " should be accepted", acceptedOrds.get(i));  
        );
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchTestCase;
            true,
            }
        IncludeExclude excludeOnly = new IncludeExclude(null, incExcString);  
            public int docValueCount() {  
     */  
        // Negative tests  
            true,  
            XContentParser.Token token = parser.nextToken();  
        assertTrue(serialized.isRegexBased());  
    }
        assertEquals(serialized, same);
                    consumed = true;
        assertTrue(acceptedOrds.get(0));
        IncludeExclude includeExclude = new IncludeExclude("aa.*", null);  
        for (int i = 0; i < expectedFilter.length; i++) {
                    token = parser.nextToken();
        assertEquals(bytesRefs.length, acceptedOrds.length());
                "((a1|a2|a3|a4|a5|a6|a7|a8|a9|a10)" + "(b1|b2|b3|b4|b5|b6|b7|b8|b9|b10)" + "(c1|c2|c3|c4|c5|c6|c7|c8|c9|c10|c11)).*",
                    throw new IllegalArgumentException("Unexpected field name serialized in test: " + parser.currentName());
            false,  
        String incRegex = "foo.*";
                return bytesRefs[ordIndex];
            false,
    }
            false,  
            @Override
            @Override
        acceptedOrds = filter.acceptedGlobalOrdinals(DocValues.emptySortedSet());
package org.opensearch.search.aggregations.bucket.terms;
        long prefixLookupCount = lookupCount.longValue();  
        String excRegex = "football";  
        for (int i = 0; i < expectedFilter.length; i++) {  
                }  
        assertEquals(expectedFilter.length, acceptedOrds.length());
        LongBitSet acceptedOrds = filter.acceptedGlobalOrdinals(ords);  
                } else {
        assertEquals(bytesRefs("a"), IncludeExclude.extractPrefixes("a.*", 1000));  
 *
        BytesRef[] bytesRefs = toBytesRefArray("bbb", "ccc", "ddd");
                return IncludeExclude.parseExclude(parser);  
            @Override
        assertFalse(acceptedOrds.get(0));
        SortedSetDocValues sortedSetDocValues = new AbstractSortedSetDocValues() {
                } else if (IncludeExclude.EXCLUDE_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
        filter = inexcl.convertToOrdinalsFilter(DocValueFormat.RAW);
    private IncludeExclude serializeMixedRegex(IncludeExclude incExc) throws IOException {
                    inc = IncludeExclude.parseInclude(parser);  
                }
            public long getValueCount() {  
            } else if (field.getPreferredName().equalsIgnoreCase("exclude")) {
        );
            @Override
        builder.startObject();
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testPartitionedEquals() throws IOException {
                "((a1|a2|a3|a4|a5|a6|a7|a8|a9|a10)" + "(b1|b2|b3|b4|b5|b6|b7|b8|b9|b10)" + "(c1|c2|c3|c4|c5|c6|c7|c8|c9|c10)|x).*",
            }  
        IncludeExclude serialized = serialize(new IncludeExclude(incValues, null), IncludeExclude.INCLUDE_FIELD);
 * Modifications Copyright OpenSearch Contributors. See
            token = parser.nextToken();
        assertNull(IncludeExclude.extractPrefixes(".*", 1000)); // Literal match-all has no prefixes
        }
import java.util.SortedSet;  
    }
     * This validates the fix for the IndexOutOfBoundsException bug.
        String[] differentIncValues = { "a", "c" };
                if (ord < 0 || ord >= bytesRefs.length) {
        assertFalse(serialized.isPartitionBased());  
import java.util.Collections;
        assertFalse(serialized.equals(differentParam2));
            "color:green", // false (excluded)
                } else {  
        String incExcString = "(color:g|width:).*";
 * this file be licensed under the Apache-2.0 license or a
            new TreeSet<>(Collections.singleton(new BytesRef("foo")))  
        // Test with a prefix that matches some terms
 * the Apache License, Version 2.0 (the "License"); you may
        long regexpLookupCount = lookupCount.longValue() - prefixLookupCount;
        acceptedOrds = filter.acceptedGlobalOrdinals(ords);  
        try (XContentParser parser = createParser(builder)) {
            @Override
            @Override  
                return 0;
            false,  
            "length:medium", // true
        // Positive tests
        // Which of the following match the filter or not?  
            "color:crimson", // true
        assertNull(IncludeExclude.extractPrefixes("a(b|c*)d*.*", 1000));
            assertEquals(token, XContentParser.Token.START_OBJECT);  
                if (IncludeExclude.INCLUDE_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
            "material:cotton", // true  
    public void testPrefixFilterWithNonExistentExcludePrefixBeyondRange() throws IOException {  
        incExc.toXContent(builder, ToXContent.EMPTY_PARAMS);
    }
        String incRegex = "foo.*";
                return 1;  
            public BytesRef lookupOrd(long ord) {
            "length:short", // true
            "color:blue", // true  
import org.apache.lucene.index.SortedSetDocValues;
        assertNull(  
    /**  
            true,
            public long getValueCount() {
        BytesRef[] bytesRefs = toBytesRefArray("aaa", "aab", "bbb", "ccc");
        // This should not throw IndexOutOfBoundsException after the fix  
            true,
        for (int i = 0; i < expectedFilter.length; i++) {
        assertEquals(serialized, same);
            null, // means everything included
        assertEquals(serialized.hashCode(), same.hashCode());
            true,
        assertTrue(serialized.hashCode() != different.hashCode());  
            @Override
            "size:small", // true  
 * this work for additional information regarding copyright
import org.opensearch.core.ParseField;  
        // Since "zzz" doesn't exist in the doc values, no ordinals should be accepted
        LongBitSet acceptedOrds = ordinalsFilter.acceptedGlobalOrdinals(sortedSetDocValues);  
                return false;
    private static SortedSetDocValues toDocValues(BytesRef[] bytesRefs) {
        LongAdder lookupCount = new LongAdder();
        LongBitSet acceptedOrds = ordinalsFilter.acceptedGlobalOrdinals(sortedSetDocValues);
        assertTrue(serialized.hashCode() != different.hashCode());  
        assertFalse(serialized.isRegexBased());
            "length:long", // true  
            false };  
        BytesRef[] bytesRefs = toBytesRefArray("aaa", "bbb", "ccc");  
        assertTrue(serialized.hashCode() != differentParam1.hashCode());
            "material:linen", // true
import org.opensearch.core.xcontent.XContentBuilder;  
    }
            public int docValueCount() {
            true,
        builder.startObject();  
            new TreeSet<>(Collections.singleton(new BytesRef("foo"))),
            public long nextOrd() {  
        // Now repeat, but this time include only.  
            }  
            @Override
        if (randomBoolean()) {  
        }
        assertTrue(regexpLookupCount > prefixLookupCount);
                int ordIndex = Math.toIntExact(ord);
        includeExclude = new IncludeExclude("(color|length|size):.*", "color:g.+");
        IncludeExclude same = new IncludeExclude(null, excRegex);  
        return new AbstractSortedSetDocValues() {
            IncludeExclude.extractPrefixes(  
        IncludeExclude same = new IncludeExclude(incValues, null);  
        IncludeExclude includeExclude = new IncludeExclude("(color|length|size):.*", "color:g.*");  
    }  
            public long nextOrd() {
        for (int i = 0; i < values.length; i++) {
        assertEquals(serialized, same);
        assertFalse(acceptedOrds.get(0));
        IncludeExclude serialized = serialize(new IncludeExclude(3, 20), IncludeExclude.INCLUDE_FIELD);  
            true,  
            true,
        LongBitSet longBitSet = ordinalsFilter.acceptedGlobalOrdinals(toDocValues(bytesRefs));  
        assertEquals(expectedFilter.length, acceptedOrds.length());
            // Include and Exclude clauses are parsed independently and then merged
    private static SortedSet<BytesRef> bytesRefs(String... strings) {
        // Test with too many possible prefixes -- 10 * 10 * 10 + 1 > 1000
            @Override
            public long getValueCount() {
        // Create a regex pattern that will trigger prefix optimization
        LongBitSet acceptedOrds = ordinalsFilter.acceptedGlobalOrdinals(sortedSetDocValues);
    public void testPrefixOrds() throws IOException {
    // Serializes/deserializes the IncludeExclude statement with include AND  
            assertEquals(expectedFilter[i], acceptedOrds.get(i));  
        assertEquals(bytesRefs.length, acceptedOrds.length());
        IncludeExclude includeExclude = new IncludeExclude("aaa.*", null);  
        }
        LongBitSet acceptedOrds = ordinalsFilter.acceptedGlobalOrdinals(toDocValues(bytesRefs));
        BytesRef[] bytesRefs = toBytesRefArray(
        inexcl = new IncludeExclude(
            @Override  
public class IncludeExcludeTests extends OpenSearchTestCase {
}  
        assertEquals(serialized.hashCode(), same.hashCode());
        ordinalsFilter = includeOnly.convertToOrdinalsFilter(DocValueFormat.RAW);
    /**
            assertEquals(expectedFilter[i], longBitSet.get(i));  
            "depth:17in", // false  
 * ownership. Elasticsearch licenses this file to you under  
            true,
        filter = inexcl.convertToOrdinalsFilter(DocValueFormat.RAW);
        for (String string : strings) {
                return 0;
    public void testPrefixFilterWithMatchingPrefix() throws IOException {
                1000  
            "color:gray", // false (excluded)
            true,
    }  
import org.opensearch.search.DocValueFormat;  
        assertFalse("Ordinal 2 (bbb) should not be accepted", acceptedOrds.get(2));  
                    exc = IncludeExclude.parseExclude(parser);  
        assertEquals(serialized.hashCode(), same.hashCode());
        assertFalse(acceptedOrds.get(0));
        assertEquals(1, acceptedOrds.length());
import org.opensearch.core.xcontent.MediaTypeRegistry;
            assertEquals(!expectedFilter[i], longBitSet.get(i));
        IncludeExclude serialized = serializeMixedRegex(new IncludeExclude(incRegex, excRegex));
        assertFalse(serialized.equals(different));  
        OrdinalsFilter filter = inexcl.convertToOrdinalsFilter(DocValueFormat.RAW);
        assertEquals(bytesRefs("ab"), IncludeExclude.extractPrefixes("a(b).*", 1000));
        assertTrue(serialized.isRegexBased());
        return bytesRefs;
            if (field.getPreferredName().equalsIgnoreCase("include")) {  
                return bytesRefs[ordIndex];
                    return 0;
        };
        // Test with too many possible prefixes -- 10 * 10 * 11 > 1000
        // Which of the following match the filter or not?
        ordinalsFilter = includeExclude.convertToOrdinalsFilter(DocValueFormat.RAW);
        for (int i = 0; i < expectedFilter.length; i++) {
            @Override
        // The prefix "zzz" doesn't exist in our doc values and would be inserted after all existing terms
        assertNull(IncludeExclude.extractPrefixes("ab*.*", 1000));
            "width:27in", // false
        }  
            }
        // No ordinals should be accepted since "aaa" doesn't exist  
                return bytesRefs.length;
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        assertEquals(1, acceptedOrds.length());
            "depth:10in", // false
        assertEquals(bytesRefs(), IncludeExclude.extractPrefixes(null, 1000));
        // Test with a prefix that would be inserted before all existing terms
            }  
            }
            public boolean advanceExact(int target) {
            }  
        }
    }
            "size:medium", // true
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
            "depth:12in", // false
    /**
    }
            true,
        assertEquals(1, acceptedOrds.length());
        IncludeExclude different = new IncludeExclude(differentIncValues, null);
        assertEquals(bytesRefs("ab", "ac"), IncludeExclude.extractPrefixes("a(b|c).*", 1000));  
        assertNull(IncludeExclude.extractPrefixes("ab?.*", 1000)); // Don't support optionals ye
 */  
    public void testExtractPrefixes() {
 *
        assertEquals(serialized.hashCode(), same.hashCode());  
    public void testRegexInclude() throws IOException {
import org.opensearch.index.fielddata.AbstractSortedSetDocValues;
            false,
            "length:short", // true  
            }
            false,
        try (XContentParser parser = createParser(builder)) {
            @Override
        IncludeExclude differentParam1 = new IncludeExclude(4, 20);
            }
    }
 * GitHub history for details.
            assertNotNull(inc);
            @Override  
        LongBitSet acceptedOrds = ordinalsFilter.acceptedGlobalOrdinals(toDocValues(bytesRefs));  
        builder.endObject();
        longBitSet = ordinalsFilter.acceptedGlobalOrdinals(toDocValues(bytesRefs));  
        IncludeExclude inexcl = new IncludeExclude(new TreeSet<>(Collections.singleton(new BytesRef("foo"))), null);
 * KIND, either express or implied.  See the License for the
            }  
            }
        IncludeExclude different = new IncludeExclude(null, differentRegex);
        // No regex means no prefixes  
        IncludeExclude includeOnly = new IncludeExclude(incExcString, null);
            public BytesRef lookupOrd(long ord) {  
        }
                if (ord < 0 || ord >= bytesRefs.length) {
            public long nextOrd() {  
     */
            assertFalse("Ordinal " + i + " should not be accepted", acceptedOrds.get(i));  
            }  
        OrdinalsFilter ordinalsFilter = includeExclude.convertToOrdinalsFilter(DocValueFormat.RAW);
            )  
/*
        assertTrue(serialized.hashCode() != different.hashCode());
            public boolean advanceExact(int target) {
        SortedSetDocValues ords = new AbstractSortedSetDocValues() {
    public void testOnlyIncludeExcludePrefix() throws IOException {
            true,
            "material:polyester", // true
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));  
        assertFalse(serialized.isPartitionBased());
                consumed = false;
        assertEquals(serialized.hashCode(), same.hashCode());  
        inexcl = new IncludeExclude(
    public void testExactIncludeValuesEquals() throws IOException {
            "depth:12in", // true
        OrdinalsFilter ordinalsFilter = excludeOnly.convertToOrdinalsFilter(DocValueFormat.RAW);
        }
        builder.endObject();  
            false };
            "depth:17in", // true
 * The OpenSearch Contributors require contributions made to  
        // Create doc values with terms that all come before "zzz" alphabetically
import org.apache.lucene.util.LongBitSet;
                throw new IllegalArgumentException("Unexpected field name serialized in test: " + field.getPreferredName());
                1000
        assertEquals(serialized.hashCode(), same.hashCode());
    }
        }
                return 1;
        assertFalse(serialized.isPartitionBased());
        }
            true,
                return new BytesRef("foo");  
import org.opensearch.common.xcontent.XContentType;
            "width:55in" // false  
        }
        assertNull(IncludeExclude.extractPrefixes("a(b|c*)d.*", 1000));
     * Test case for prefix filter with exclude pattern when the prefix doesn't exist.
                return 0;
    }
                }  
        assertTrue(serialized.isPartitionBased());
            @Override
 * Licensed to Elasticsearch under one or more contributor  
    // Serializes/deserializes an IncludeExclude statement with a single clause  
            bytesRefs.add(new BytesRef(string));
        OrdinalsFilter ordinalsFilter = includeExclude.convertToOrdinalsFilter(DocValueFormat.RAW);
        assertFalse(serialized.equals(different));
        for (int i = 0; i < bytesRefs.length; i++) {
        assertNull(IncludeExclude.extractPrefixes("a(b*|c)d.*", 1000));  
            true,
        assertEquals(bytesRefs.length, acceptedOrds.length());  
        assertTrue("Ordinal 1 (aab) should be accepted", acceptedOrds.get(1));
        boolean[] expectedFilter = new boolean[] {
        assertEquals(0, acceptedOrds.length());  
            "size:large", // true  
 * compatible open source license.
            "size:medium", // true
    }  
            "width:27in", // false
    private static BytesRef[] toBytesRefArray(String... values) {  
            "size:large", // true
            IncludeExclude.extractPrefixes(
            assertEquals(token, XContentParser.Token.START_OBJECT);
        IncludeExclude serialized = serialize(new IncludeExclude(incRegex, null), IncludeExclude.INCLUDE_FIELD);
        String[] excValues = { "a", "b" };
import org.apache.lucene.index.DocValues;
            }
            false,
            "color:green", // false (excluded)
            "material:cotton", // false
            "length:medium", // true
                return IncludeExclude.parseInclude(parser);
 * license agreements. See the NOTICE file distributed with
    public void testEmptyTermsWithOrds() throws IOException {  
        IncludeExclude same = new IncludeExclude(incRegex, excRegex);  
            @Override  
            public int docValueCount() {
        }  
            @Override
            assertEquals(token, XContentParser.Token.FIELD_NAME);
            false,
        boolean[] expectedFilter = new boolean[] {
            }
            "material:linen", // false
            public boolean advanceExact(int docID) {  
            false,
        // Since "zzz" doesn't exist and we're excluding it, all ordinals should be accepted  
            public BytesRef lookupOrd(long ord) {
            }
        acceptedOrds = ordinalsFilter.acceptedGlobalOrdinals(sortedSetDocValues);  
    public void testPrefixFilterWithNonExistentPrefixBeforeRange() throws IOException {
            public long nextOrd() {  
    public void testRegexExclude() throws IOException {
 * Unless required by applicable law or agreed to in writing,
                if (consumed) {
                return bytesRefs.length;
            true,  
    public void testExactExcludeValuesEquals() throws IOException {  
                return 1;
        String differentRegex = "bar.*";  
        String differentRegex = "bar.*";
            }  
        };  
        inexcl = new IncludeExclude(new TreeSet<>(Collections.singleton(new BytesRef("bar"))), null);
            }
 */
import org.opensearch.core.xcontent.ToXContent;
        IncludeExclude different = new IncludeExclude(null, differentExcValues);
            public int docValueCount() {  
            @Override  
                    throw new IndexOutOfBoundsException("ord=" + ord + " is out of bounds [0," + bytesRefs.length + ")");
            "width:13in", // false  
                int ordIndex = Math.toIntExact(ord);
            }  
     * Test case for prefix filter when the prefix exists before all terms.
            public BytesRef lookupOrd(long ord) {
        String[] differentExcValues = { "a", "c" };
                return false;
            assertNotNull(exc);  
            @Override
        LongBitSet acceptedOrds = filter.acceptedGlobalOrdinals(DocValues.emptySortedSet());  
 */  
        // The previously excluded ordinals should be included and vice versa.
            "depth:10in", // true  
                return 1;
            true,  
 * SPDX-License-Identifier: Apache-2.0
 *  
        OrdinalsFilter ordinalsFilter = includeExclude.convertToOrdinalsFilter(DocValueFormat.RAW);
            new TreeSet<>(Collections.singleton(new BytesRef("foo")))  
            true,  
        SortedSet<BytesRef> bytesRefs = new TreeSet<>();  
        assertFalse(serialized.isPartitionBased());  
        acceptedOrds = filter.acceptedGlobalOrdinals(ords);  
        IncludeExclude differentParam2 = new IncludeExclude(3, 21);  
        OrdinalsFilter ordinalsFilter = includeExclude.convertToOrdinalsFilter(DocValueFormat.RAW);
        // Only the first two ordinals should be accepted (matching "aa" prefix)
    }
                return bytesRefs.length;
        IncludeExclude different = new IncludeExclude(incRegex, differentExcRegex);
            }  
            true,
        IncludeExclude inexcl = new IncludeExclude(new TreeSet<>(Collections.singleton(new BytesRef("foo"))), null);
        assertFalse(serialized.equals(different));
import java.util.concurrent.atomic.LongAdder;
        assertTrue(serialized.hashCode() != different.hashCode());
     * Test case for prefix filter when the prefix doesn't exist and would be inserted beyond all existing terms.  
            }
            }  
        OrdinalsFilter filter = inexcl.convertToOrdinalsFilter(DocValueFormat.RAW);
            @Override
        IncludeExclude serialized = serialize(new IncludeExclude(null, excRegex), IncludeExclude.EXCLUDE_FIELD);
     * Test case for prefix filter when the prefix matches some terms.
    /**
        SortedSetDocValues sortedSetDocValues = new AbstractSortedSetDocValues() {
            assertEquals(expectedFilter[i], acceptedOrds.get(i));  
import org.opensearch.core.xcontent.XContentParser;
        assertEquals(serialized, same);  
            true,  
/*  
        // Now repeat, but this time, the prefix optimization won't work (because of the .+ on the exclude filter)  
            token = parser.nextToken();
        );
        );
            public BytesRef lookupOrd(long ord) {
        IncludeExclude same = new IncludeExclude(3, 20);
 * You may obtain a copy of the License at  
import java.util.TreeSet;
    private IncludeExclude serialize(IncludeExclude incExc, ParseField field) throws IOException {
            assertFalse("Ordinal " + i + " should not be accepted", acceptedOrds.get(i));
        BytesRef[] bytesRefs = toBytesRefArray(
        for (int i = 0; i < bytesRefs.length; i++) {
        );  
     */  
                assertEquals(0, ord);
                int ordIndex = Math.toIntExact(ord);
    }
            boolean consumed = true;  
        }  
        assertEquals(bytesRefs("aabb", "aacc"), IncludeExclude.extractPrefixes("aa(bb|cc).*", 1000));
            false,  
            XContentParser.Token token = parser.nextToken();
                    throw new IndexOutOfBoundsException("ord=" + ord + " is out of bounds [0," + bytesRefs.length + ")");  
/*  
    public void testSingleTermWithOrds() throws IOException {  
        // The filter should be functionally the same  
            return IncludeExclude.merge(inc, exc);
        String differentExcRegex = "foosball";
        BytesRef[] bytesRefs = new BytesRef[values.length];
            "color:blue", // true
            } else {
            }
import org.apache.lucene.util.BytesRef;  
                return bytesRefs[ordIndex];  
            }
        assertEquals(1, acceptedOrds.length());
                return bytesRefs[ordIndex];  
        incExc.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertFalse(serialized.equals(different));
        assertTrue(serialized.hashCode() != different.hashCode());  
            false,
        assertFalse(serialized.isRegexBased());
    // exclude clauses
                return 0;  
        OrdinalsFilter ordinalsFilter = includeExclude.convertToOrdinalsFilter(DocValueFormat.RAW);
        filter = inexcl.convertToOrdinalsFilter(DocValueFormat.RAW);
    }  
            true,  
            builder = builder.prettyPrint();
                return bytesRefs.length;
            public int docValueCount() {
            public boolean advanceExact(int target) {  
            }  
                    return NO_MORE_DOCS;
            }
                    token = parser.nextToken();
        acceptedOrds = filter.acceptedGlobalOrdinals(ords);  
                return false;  
                return 1;
        for (int i = 0; i < bytesRefs.length; i++) {
                return false;
            public boolean advanceExact(int target) {
            true,
        assertEquals(bytesRefs.length, acceptedOrds.length());  
            "width:13in", // false
     */
        assertTrue("Ordinal 0 (aaa) should be accepted", acceptedOrds.get(0));
            false,
        // Create doc values where "aaa" would be at the beginning but doesn't exist
            "color:crimson", // true  
    public void testRegexIncludeAndExclude() throws IOException {
    }  
 * specific language governing permissions and limitations
            )
        SortedSetDocValues sortedSetDocValues = new AbstractSortedSetDocValues() {  
            IncludeExclude inc = null;  
            }
        return bytesRefs;
        assertFalse(serialized.equals(different));
            builder = builder.prettyPrint();
            @Override  
        IncludeExclude serialized = serialize(new IncludeExclude(null, excValues), IncludeExclude.EXCLUDE_FIELD);  
            true,  
            public long getValueCount() {
import java.io.IOException;
            "size:small", // true
            IncludeExclude exc = null;
        String excRegex = "foo.*";  
        IncludeExclude different = new IncludeExclude(differentRegex, null);  
        assertEquals(bytesRefs("a", "b"), IncludeExclude.extractPrefixes("(a|b).*", 1000));
        assertFalse("Ordinal 3 (ccc) should not be accepted", acceptedOrds.get(3));
        };  
        assertNull(IncludeExclude.extractPrefixes("a*(b|c).*", 1000));
        inexcl = new IncludeExclude(null, new TreeSet<>(Collections.singleton(new BytesRef("foo"))));  
                assertEquals(XContentParser.Token.FIELD_NAME, token);  
        };  
                return true;
        );
        assertEquals(serialized, same);
        IncludeExclude same = new IncludeExclude(incRegex, null);
            @Override
        IncludeExclude same = new IncludeExclude(null, excValues);
            @Override  
            public long getValueCount() {  
        IncludeExclude includeExclude = new IncludeExclude(null, "zzz.*");
            assertEquals(field.getPreferredName(), parser.currentName());  
                }  
        assertNull(
                lookupCount.increment();  
        String[] incValues = { "a", "b" };  
        IncludeExclude includeExclude = new IncludeExclude("zzz.*", null);  
        assertFalse(serialized.isPartitionBased());  
    }
            }
        assertEquals(serialized, same);
        // But the full regexp requires more lookups  
                int ordIndex = Math.toIntExact(ord);
    }
        filter = inexcl.convertToOrdinalsFilter(DocValueFormat.RAW);
        }  
            @Override  
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude.OrdinalsFilter;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            @Override  
            public long nextOrd() {
 * under the License.  
        assertFalse(serialized.isRegexBased());
        if (randomBoolean()) {
            "width:55in" // false
            @Override  
            "material:polyester", // false  
        assertEquals(0, acceptedOrds.length());
            false,
    public void testPrefixFilterWithNonExistentPrefixBeyondRange() throws IOException {  
                return 1;  
        // Test with an exclude pattern where the prefix doesn't exist
 * software distributed under the License is distributed on an
        assertFalse(serialized.equals(differentParam1));  
        // This should not throw IndexOutOfBoundsException after the fix
        // The following cover various cases involving infinite possible prefixes  
            false,
    }  
        assertTrue(serialized.isRegexBased());
            "color:gray", // false (excluded)  
            bytesRefs[i] = new BytesRef(values[i]);  
