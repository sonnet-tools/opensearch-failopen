        }
        } else {  
 * Modifications Copyright OpenSearch Contributors. See
            DocValueFormat.BOOLEAN,
import org.opensearch.core.xcontent.XContentBuilder;
public class SearchSortValuesTests extends AbstractSerializingTestCase<SearchSortValues> {
            sortValues.toXContent(builder, ToXContent.EMPTY_PARAMS);
                Object sortValue = randomSortValue(mediaType, transportSerialization);  
    }  
 * compatible open source license.
            DocValueFormat.IP,
    protected SearchSortValues createTestInstance() {
        SearchSortValues searchSortValues = SearchSortValues.fromXContent(parser);
    }  
            return new SearchSortValues(new Object[0]);  
            DocValueFormat.BINARY,
    @Override
            // xcontent serialization doesn't write/parse the raw sort values, only the formatted ones
        if (transportSerialization) {  
 *
import java.util.Arrays;
import org.opensearch.common.lucene.LuceneTests;
        parser.nextToken();
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
                Object sortValue = randomSortValue(mediaType, transportSerialization);  
    }
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
    @Override
            builder.endObject();  
        return new String[] { "sort" };
import java.io.IOException;
                // make sure that BytesRef are not provided as formatted values
 */
 * under the License.  
        }  
            DocValueFormat.RAW,  
 */  
            SearchSortValues sortValues = new SearchSortValues(new Object[0]);
        {
import org.apache.lucene.util.BytesRef;
        return SearchSortValues::new;
    protected String[] getShuffleFieldsExceptions() {  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
                sortValue = sortValue instanceof BytesRef ? DocValueFormat.RAW.format((BytesRef) sortValue) : sortValue;
            assertEquals("{\"sort\":[1,\"foo\",3.0]}", builder.toString());
    public void testToXContent() throws IOException {
import org.opensearch.test.RandomObjects;
        Object[] values = Arrays.copyOf(sortValues, sortValues.length + 1);
    protected SearchSortValues doParseInstance(XContentParser parser) throws IOException {  
        return createTestItem(mediaType, false);
        // to simplify things, we directly serialize what we expect we would parse back when testing xcontent serialization
            for (int i = 0; i < size; i++) {
import org.opensearch.core.xcontent.MediaType;  
            XContentBuilder builder = JsonXContent.contentBuilder();
        Object[] sortValues = instance.getFormattedSortValues();
import org.opensearch.common.xcontent.json.JsonXContent;
 *
    }
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.ToXContent;
    protected Writeable.Reader<SearchSortValues> instanceReader() {
        values[sortValues.length] = randomSortValue(randomFrom(XContentType.values()), randomBoolean());  
        return createTestItem(randomFrom(XContentType.values()), randomBoolean());  
        return transportSerialization ? randomSortValue : RandomObjects.getExpectedParsedValue(mediaType, randomSortValue);  
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
            return new SearchSortValues(values);
 *  
                sortValueFormats[i] = sortValue instanceof BytesRef ? DocValueFormat.RAW : randomDocValueFormat();  
                values[i] = sortValue;  
 * GitHub history for details.
    }
 */  
        Object randomSortValue = LuceneTests.randomSortValue();
            DocValueFormat.GEOTILE
        Object[] values = new Object[size];
    }
 * KIND, either express or implied.  See the License for the
    }
        parser.nextToken(); // skip to the elements start array token, fromXContent advances from there if called
 * You may obtain a copy of the License at  
        {
            }
            sortValues.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        return randomFrom(
        int size = randomIntBetween(1, 20);
            builder.endObject();
    }  
 * not use this file except in compliance with the License.
        if (randomBoolean()) {
    }
            XContentBuilder builder = JsonXContent.contentBuilder();  
        );
    @Override
                values[i] = sortValue;
        return searchSortValues;
            builder.startObject();
            assertEquals("{}", builder.toString());
            }
                // make sure that for BytesRef, we provide a specific doc value format that overrides format(BytesRef)
}  
            DocValueFormat[] sortValueFormats = new DocValueFormat[size];
        }
import org.opensearch.common.xcontent.XContentType;  
/*  
 * The OpenSearch Contributors require contributions made to  
    private static Object randomSortValue(final MediaType mediaType, boolean transportSerialization) {  
import org.opensearch.core.common.io.stream.Writeable;
        assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());  
            SearchSortValues sortValues = new SearchSortValues(new Object[] { 1, "foo", 3.0 });  
        }  
/*  
 * SPDX-License-Identifier: Apache-2.0
            DocValueFormat.GEOHASH,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            for (int i = 0; i < size; i++) {
            builder.startObject();
        assertNull(parser.nextToken());
    @Override
/*
    protected SearchSortValues mutateInstance(SearchSortValues instance) {  
    protected SearchSortValues createXContextTestInstance(final MediaType mediaType) {  
            return new SearchSortValues(values, sortValueFormats);
        parser.nextToken();  
    @Override
        return new SearchSortValues(values);
import org.opensearch.test.AbstractSerializingTestCase;
    private static DocValueFormat randomDocValueFormat() {  
    @Override  
import org.opensearch.core.xcontent.XContentParser;  
package org.opensearch.search;
        parser.nextToken();
    public static SearchSortValues createTestItem(final MediaType mediaType, boolean transportSerialization) {  
