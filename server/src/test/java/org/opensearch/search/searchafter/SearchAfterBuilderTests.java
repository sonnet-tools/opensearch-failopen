 * this work for additional information regarding copyright
                    values[i] = randomBigInteger();  
        }  
            public SortField.Type reducedType() {
                return null;
            }
                    values[i] = randomByte();  
            }
                    break;
    public void testFromXContentIllegalType() throws Exception {  
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
                BigArrays bigArrays,  
    // This is not a problem because the final type of each field value is extracted from associated sort field.
    private static void randomSearchFromBuilderWithSortValueThrows(Object containing) throws IOException {
                case 4:
 *
 * You may obtain a copy of the License at  
                    break;
/*  
        };
            int branch = randomInt(10);  
        }  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            parser.nextToken();
        assertThat(type, equalTo(SortField.Type.STRING));
import java.util.Collections;  
        int numSearchAfter = randomIntBetween(1, 10);
                case 1:
            // ignore json and yaml, they parse floating point numbers as floats/doubles  
    public void testEqualsAndHashcode() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                case 5:
            @Override
                    jsonBuilder.nullValue();  
 *
        // Get a valid one
            }
                    break;
                SortOrder sortOrder,
            searchAfterBuilder.innerToXContent(builder);
                DocValueFormat format,
        jsonBuilder.endArray();
                    break;
                    break;
        IndexFieldData.XFieldComparatorSource source = new IndexFieldData.XFieldComparatorSource(null, MultiValueMode.MIN, null) {
                int bucketSize,  
 * compatible open source license.
 *  
            builder.endObject();
 * GitHub history for details.
        jsonBuilder.startArray("search_after");
                case 9:
 * Licensed to Elasticsearch under one or more contributor  
}
                case 6:
                    break;
import org.apache.lucene.search.SortedNumericSortField;
        }
                IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> SearchAfterBuilder.fromXContent(parser));
import org.opensearch.common.xcontent.XContentFactory;  
        SearchAfterBuilder builder = new SearchAfterBuilder();
                    break;
                parser.nextToken();  
                    break;
            SearchAfterBuilder original = randomSearchAfterBuilder();
        SearchAfterBuilder builder = randomSearchAfterBuilder();  
 */  
        for (int i = 0; i < numSearchAfter; i++) {
    /**  
    private static SearchAfterBuilder randomSearchAfterBuilder() throws IOException {
            builder.setSortValues(new Object[0]);
    }  
        }
                    break;
            assertThat(e.getMessage(), equalTo("Values cannot be null."));
                    break;
                    jsonBuilder.value(randomFloat());  
            public FieldComparator<?> newComparator(String fieldname, int numHits, Pruning pruning, boolean reversed) {  
package org.opensearch.search.searchafter;
                case 8:
        }
        jsonBuilder.endObject();
                parser.nextToken();
    // ensure that every number type remain the same before/after xcontent (de)serialization.  
            int branch = randomInt(9);  
                    break;
                builder = builder.prettyPrint();
                    jsonBuilder.value(randomShort());  
                case 4:
import org.opensearch.core.xcontent.XContentBuilder;
public class SearchAfterBuilderTests extends OpenSearchTestCase {
            fail("Should fail on null array.");
    public void testExtractSortType() throws Exception {
            }  
 * this file be licensed under the Apache-2.0 license or a
        SearchAfterBuilder searchAfterBuilder = new SearchAfterBuilder();  
            if (randomBoolean()) {  
    private static SearchAfterBuilder serializedCopy(SearchAfterBuilder original) throws IOException {
     * Explicitly tests what you can't list as a sortValue. What you can list is tested by {@link #randomSearchAfterBuilder()}.
 * KIND, either express or implied.  See the License for the
            }
    }  
import org.opensearch.core.common.bytes.BytesReference;  
            // BIG_DECIMAL
    }  
                SearchAfterBuilder secondSearchAfterBuilder = SearchAfterBuilder.fromXContent(parser);
                    break;
        // Now replace its values with one containing the passed in object
    }
 * Unless required by applicable law or agreed to in writing,
 */
        randomSearchFromBuilderWithSortValueThrows(this);
import org.opensearch.common.util.BigArrays;
 * license agreements. See the NOTICE file distributed with
    // We build a json version of the search_after first in order to
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.search.DocValueFormat;
                assertThat(exc.getMessage(), containsString("BIG_DECIMAL"));
            switch (branch) {
        assertThat(type, equalTo(SortField.Type.STRING));
        assertThat(type, equalTo(SortField.Type.DOUBLE));
            assertNotSame(deserialized, original);  
                case 10:
                    values[i] = randomShort();  
        for (XContentType type : XContentType.values()) {
            if (type == MediaTypeRegistry.JSON || type == XContentType.YAML) {
            fail("Should fail on empty array.");  
import org.opensearch.search.sort.SortOrder;
                    values[i] = null;  
import static org.hamcrest.Matchers.containsString;
            parser.nextToken();  
                    jsonBuilder.value(randomAlphaOfLengthBetween(5, 20));  
import org.opensearch.test.OpenSearchTestCase;
                case 3:
                case 9:
                return null;  
        Object[] values = new Object[numSearchFrom];
                    jsonBuilder.value(new Text(randomAlphaOfLengthBetween(5, 20)));  
 * Modifications Copyright OpenSearch Contributors. See
                parser.nextToken();  
            XContentBuilder xContent = MediaTypeRegistry.contentBuilder(type);
            public BucketedSort newBucketedSort(
        type = extractSortType(new SortedSetSortField("field", false));
import org.opensearch.common.geo.GeoPoint;
    public void testBadTypes() throws IOException {  
            xContent.startObject().startArray("search_after").value(new BigDecimal("9223372036854776003.3")).endArray().endObject();
                    values[i] = randomInt();  
    }
import org.opensearch.search.sort.BucketedSort;  
            switch (branch) {
                    jsonBuilder.value(randomLong());  
                    values[i] = new Text(randomAlphaOfLengthBetween(5, 20));  
import java.math.BigDecimal;
        int numSearchFrom = randomIntBetween(1, 10);
    public void testWithNullArray() throws Exception {
    }  
 * ownership. Elasticsearch licenses this file to you under  
                return SortField.Type.STRING;
        } catch (IllegalArgumentException e) {
/*  
            return SearchAfterBuilder.fromXContent(parser);
            }  
        return copyWriteable(original, new NamedWriteableRegistry(Collections.emptyList()), SearchAfterBuilder::new);  
 * software distributed under the License is distributed on an
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
            try (XContentParser parser = createParser(shuffleXContent(builder))) {  
        values[between(0, values.length - 1)] = containing;  
        for (int runs = 0; runs < 20; runs++) {  
            SearchAfterBuilder deserialized = serializedCopy(original);  
                BucketedSort.ExtraData extra
                case 0:
    public void testWithEmptyArray() throws Exception {
import org.opensearch.common.xcontent.XContentType;
                assertNotSame(searchAfterBuilder, secondSearchAfterBuilder);
                    break;
                assertEquals(searchAfterBuilder, secondSearchAfterBuilder);  
        Exception e = expectThrows(IllegalArgumentException.class, () -> builder.setSortValues(values));
            }
        }
                    break;
    // This little trick ensure that equals and hashcode are the same when using the xcontent serialization.
import org.opensearch.common.xcontent.json.JsonXContent;
    }  
                case 6:
/*
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;  
import static org.opensearch.search.searchafter.SearchAfterBuilder.extractSortType;
                    jsonBuilder.value(randomByte());  
        } catch (NullPointerException e) {  
        assertEquals(e.getMessage(), "Can't handle search_after field value of type [" + containing.getClass() + "]");
                    break;
    }
            }  
    }
            checkEqualsAndHashCode(randomSearchAfterBuilder(), SearchAfterBuilderTests::serializedCopy);
        randomSearchFromBuilderWithSortValueThrows(randomSearchAfterBuilder());  
        randomSearchFromBuilderWithSortValueThrows(new Object());
            }
import java.io.IOException;
                    values[i] = randomBoolean();  
import org.apache.lucene.document.LatLonDocValuesField;
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
                case 2:
 * under the License.  
        for (int i = 0; i < numSearchFrom; i++) {
            @Override
            @Override  
            try (XContentParser parser = createParser(xContent)) {  
    public void testFromXContent() throws Exception {
                    values[i] = randomLong();  
        }  
        jsonBuilder.startObject();  
        randomSearchFromBuilderWithSortValueThrows(new GeoPoint(0, 0));
        assertThat(type, equalTo(SortField.Type.DOUBLE));
                parser.nextToken();
 * SPDX-License-Identifier: Apache-2.0
                case 8:
                continue;
        }  
        type = extractSortType(new SortField("field", source));
    private static final int NUMBER_OF_TESTBUILDERS = 20;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.SortField;
                    break;
                    values[i] = randomDouble();  
        XContentBuilder jsonBuilder = XContentFactory.jsonBuilder();
                    jsonBuilder.value(randomBoolean());  
                    break;
import org.opensearch.index.fielddata.IndexFieldData;  
                assertEquals(searchAfterBuilder.hashCode(), secondSearchAfterBuilder.hashCode());
import org.apache.lucene.search.FieldComparator;
 */  
                case 5:
                    values[i] = randomFloat();  
            assertEquals(deserialized, original);
                    break;
import org.apache.lucene.search.Pruning;  
            assertEquals(deserialized.hashCode(), original.hashCode());
                parser.nextToken();
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            // TODO add equals tests with mutating the original object  
                    break;
                case 2:
    }
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(e.getMessage(), equalTo("Values must contains at least one value."));
            parser.nextToken();
                    jsonBuilder.value(randomInt());  
            builder.setSortValues(null);
        try {  
                    jsonBuilder.value(randomDouble());  
        type = extractSortType(new SortedNumericSortField("field", SortField.Type.DOUBLE));
        try {
        Object[] values = builder.getSortValues();
import org.opensearch.core.common.text.Text;
 * specific language governing permissions and limitations
                parser.nextToken();
    }
import static org.hamcrest.Matchers.equalTo;
     */
                case 3:
                case 7:
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(jsonBuilder))) {  
    public void testSerialization() throws Exception {  
                    break;
    private SearchAfterBuilder randomJsonSearchFromBuilder() throws IOException {  
            ) {
        SearchAfterBuilder builder = new SearchAfterBuilder();  
import org.apache.lucene.search.SortedSetSortField;  
        return searchAfterBuilder;
            SearchAfterBuilder searchAfterBuilder = randomJsonSearchFromBuilder();
        searchAfterBuilder.setSortValues(values);
import org.opensearch.search.MultiValueMode;
                case 7:
        SortField.Type type = extractSortType(LatLonDocValuesField.newDistanceSort("field", 0.0, 180.0));  
                    values[i] = randomAlphaOfLengthBetween(5, 20);  
                case 1:
            builder.startObject();  
    }  
                case 0:
 * not use this file except in compliance with the License.
                    break;
        }
