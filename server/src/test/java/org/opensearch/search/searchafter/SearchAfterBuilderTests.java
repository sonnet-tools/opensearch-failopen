import org.apache.lucene.search.Pruning;
/*
                builder = builder.prettyPrint();
            }
                    break;
 */
                assertThat(exc.getMessage(), containsString("BIG_DECIMAL"));
    }
 * Licensed to Elasticsearch under one or more contributor
            fail("Should fail on null array.");
            switch (branch) {
        }
 * specific language governing permissions and limitations
        } catch (IllegalArgumentException e) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    values[i] = randomShort();
            int branch = randomInt(10);
                case 0:
    private SearchAfterBuilder randomJsonSearchFromBuilder() throws IOException {
                IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> SearchAfterBuilder.fromXContent(parser));
        jsonBuilder.startObject();
                assertNotSame(searchAfterBuilder, secondSearchAfterBuilder);
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
                    break;
    // This little trick ensure that equals and hashcode are the same when using the xcontent serialization.
     * Explicitly tests what you can't list as a sortValue. What you can list is tested by {@link #randomSearchAfterBuilder()}.
                    break;
import org.opensearch.core.common.bytes.BytesReference;
        Exception e = expectThrows(IllegalArgumentException.class, () -> builder.setSortValues(values));
                    jsonBuilder.value(randomLong());
                    jsonBuilder.value(randomBoolean());
                    break;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.xcontent.XContentFactory;
            assertEquals(deserialized, original);
        } catch (NullPointerException e) {
    // This is not a problem because the final type of each field value is extracted from associated sort field.
import org.apache.lucene.search.FieldComparator;
                return SortField.Type.STRING;
    public void testExtractSortType() throws Exception {
        jsonBuilder.startArray("search_after");
                    values[i] = randomLong();
 * Unless required by applicable law or agreed to in writing,
        try {
                case 5:
/*
        for (int i = 0; i < numSearchAfter; i++) {
                    jsonBuilder.value(randomShort());
    /**
            // ignore json and yaml, they parse floating point numbers as floats/doubles
            switch (branch) {
package org.opensearch.search.searchafter;
        IndexFieldData.XFieldComparatorSource source = new IndexFieldData.XFieldComparatorSource(null, MultiValueMode.MIN, null) {
import static org.opensearch.search.searchafter.SearchAfterBuilder.extractSortType;
        }
                    break;
        }
                case 1:
                SearchAfterBuilder secondSearchAfterBuilder = SearchAfterBuilder.fromXContent(parser);
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
        randomSearchFromBuilderWithSortValueThrows(new GeoPoint(0, 0));
                DocValueFormat format,
            @Override
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(jsonBuilder))) {
        };
 * not use this file except in compliance with the License.
        int numSearchFrom = randomIntBetween(1, 10);
    }
        for (int runs = 0; runs < 20; runs++) {
 * You may obtain a copy of the License at
                    jsonBuilder.value(randomAlphaOfLengthBetween(5, 20));
            parser.nextToken();
            }
import java.io.IOException;
                    break;
        XContentBuilder jsonBuilder = XContentFactory.jsonBuilder();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        for (XContentType type : XContentType.values()) {
            SearchAfterBuilder original = randomSearchAfterBuilder();
        return searchAfterBuilder;
 * The OpenSearch Contributors require contributions made to
            assertNotSame(deserialized, original);
                    jsonBuilder.value(randomByte());
import org.opensearch.index.fielddata.IndexFieldData;
import org.apache.lucene.search.SortedNumericSortField;
    }
            SearchAfterBuilder searchAfterBuilder = randomJsonSearchFromBuilder();
import java.util.Collections;
            XContentBuilder xContent = MediaTypeRegistry.contentBuilder(type);
 *
 * compatible open source license.
            checkEqualsAndHashCode(randomSearchAfterBuilder(), SearchAfterBuilderTests::serializedCopy);
 * GitHub history for details.
            assertEquals(deserialized.hashCode(), original.hashCode());
            }
                    break;
            if (type == MediaTypeRegistry.JSON || type == XContentType.YAML) {
                    break;
        }
                assertEquals(searchAfterBuilder.hashCode(), secondSearchAfterBuilder.hashCode());
                case 7:
        SearchAfterBuilder builder = new SearchAfterBuilder();
            public SortField.Type reducedType() {
                parser.nextToken();
            }
                    values[i] = new Text(randomAlphaOfLengthBetween(5, 20));
                    break;
                case 4:
                assertEquals(searchAfterBuilder, secondSearchAfterBuilder);
                    break;
                parser.nextToken();
    private static SearchAfterBuilder randomSearchAfterBuilder() throws IOException {
import org.opensearch.common.xcontent.XContentType;
                    break;
                    break;
        SearchAfterBuilder searchAfterBuilder = new SearchAfterBuilder();
        assertThat(type, equalTo(SortField.Type.STRING));
            if (randomBoolean()) {
    }
 * ownership. Elasticsearch licenses this file to you under
        }
                case 2:
            try (XContentParser parser = createParser(shuffleXContent(builder))) {
                    values[i] = randomBoolean();
    }
                    jsonBuilder.value(randomFloat());
    public void testFromXContent() throws Exception {
import org.opensearch.core.xcontent.XContentBuilder;
            int branch = randomInt(9);
import org.apache.lucene.search.SortField;
 * this file be licensed under the Apache-2.0 license or a
            public FieldComparator<?> newComparator(String fieldname, int numHits, Pruning pruning, boolean reversed) {
        for (int i = 0; i < numSearchFrom; i++) {
            assertThat(e.getMessage(), equalTo("Values must contains at least one value."));
import org.opensearch.common.util.BigArrays;
            }
            // TODO add equals tests with mutating the original object
 */
        randomSearchFromBuilderWithSortValueThrows(new Object());
        Object[] values = builder.getSortValues();
    }
                case 6:
        }
            }
                parser.nextToken();
        Object[] values = new Object[numSearchFrom];
        assertThat(type, equalTo(SortField.Type.DOUBLE));
    public void testSerialization() throws Exception {
 *
                case 8:
        int numSearchAfter = randomIntBetween(1, 10);
import org.opensearch.search.MultiValueMode;
                case 8:
    public void testBadTypes() throws IOException {
                    values[i] = randomFloat();
        // Now replace its values with one containing the passed in object
            builder.setSortValues(new Object[0]);
                SortOrder sortOrder,
                BigArrays bigArrays,
        randomSearchFromBuilderWithSortValueThrows(this);
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
                case 4:
        type = extractSortType(new SortedNumericSortField("field", SortField.Type.DOUBLE));
import static org.hamcrest.Matchers.containsString;
        type = extractSortType(new SortField("field", source));
                    break;
    }
        }
            @Override
                    values[i] = randomDouble();
        searchAfterBuilder.setSortValues(values);
        assertThat(type, equalTo(SortField.Type.STRING));
                case 3:
    public void testWithNullArray() throws Exception {
        }
        values[between(0, values.length - 1)] = containing;
        SortField.Type type = extractSortType(LatLonDocValuesField.newDistanceSort("field", 0.0, 180.0));
            fail("Should fail on empty array.");
                    break;
                parser.nextToken();
 *
                return null;
import org.opensearch.search.sort.SortOrder;
                parser.nextToken();
    }
            try (XContentParser parser = createParser(xContent)) {
            parser.nextToken();
        jsonBuilder.endObject();
                    jsonBuilder.value(new Text(randomAlphaOfLengthBetween(5, 20)));
import org.apache.lucene.search.SortedSetSortField;
import static org.hamcrest.Matchers.equalTo;
import org.apache.lucene.document.LatLonDocValuesField;
import org.opensearch.test.OpenSearchTestCase;
                    jsonBuilder.value(randomDouble());
            }
                    break;
import org.opensearch.core.xcontent.XContentParser;
                    jsonBuilder.nullValue();
                    values[i] = randomInt();
        return copyWriteable(original, new NamedWriteableRegistry(Collections.emptyList()), SearchAfterBuilder::new);
                BucketedSort.ExtraData extra
    public void testFromXContentIllegalType() throws Exception {
                case 5:
import org.opensearch.search.sort.BucketedSort;
        assertEquals(e.getMessage(), "Can't handle search_after field value of type [" + containing.getClass() + "]");
import org.opensearch.search.DocValueFormat;
            return SearchAfterBuilder.fromXContent(parser);
                    break;
                case 7:
                    values[i] = null;
    // ensure that every number type remain the same before/after xcontent (de)serialization.
 * under the License.
                    jsonBuilder.value(randomInt());
    }
     */
                    values[i] = randomAlphaOfLengthBetween(5, 20);
            searchAfterBuilder.innerToXContent(builder);
                case 9:
                    break;
}
import org.opensearch.common.xcontent.json.JsonXContent;
                continue;
    private static SearchAfterBuilder serializedCopy(SearchAfterBuilder original) throws IOException {
                    values[i] = randomBigInteger();
            builder.startObject();
public class SearchAfterBuilderTests extends OpenSearchTestCase {
        SearchAfterBuilder builder = new SearchAfterBuilder();
                case 0:
            }
            builder.endObject();
 */
    // We build a json version of the search_after first in order to
    }
                parser.nextToken();
            ) {
        jsonBuilder.endArray();
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(type, equalTo(SortField.Type.DOUBLE));
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testWithEmptyArray() throws Exception {
            parser.nextToken();
import org.opensearch.common.geo.GeoPoint;
            xContent.startObject().startArray("search_after").value(new BigDecimal("9223372036854776003.3")).endArray().endObject();
        try {
        type = extractSortType(new SortedSetSortField("field", false));
            assertThat(e.getMessage(), equalTo("Values cannot be null."));
            @Override
            public BucketedSort newBucketedSort(
 * this work for additional information regarding copyright
                case 9:
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.MediaTypeRegistry;
        randomSearchFromBuilderWithSortValueThrows(randomSearchAfterBuilder());
    public void testEqualsAndHashcode() throws Exception {
                    break;
                    break;
        // Get a valid one
    private static final int NUMBER_OF_TESTBUILDERS = 20;
 * software distributed under the License is distributed on an
            // BIG_DECIMAL
                case 3:
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
import java.math.BigDecimal;
    }
            SearchAfterBuilder deserialized = serializedCopy(original);
            }
        SearchAfterBuilder builder = randomSearchAfterBuilder();
    }
 * SPDX-License-Identifier: Apache-2.0
            builder.setSortValues(null);
                return null;
import org.opensearch.core.common.text.Text;
    private static void randomSearchFromBuilderWithSortValueThrows(Object containing) throws IOException {
                case 10:
                case 2:
                    break;
        }
                    values[i] = randomByte();
                case 6:
                case 1:
                    break;
                int bucketSize,
/*
