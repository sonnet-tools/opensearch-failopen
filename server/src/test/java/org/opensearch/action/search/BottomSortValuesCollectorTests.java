            collector.consumeTopDocs(createTopDocs(sortFields[0], 100, newDoubleArray(500d, 5000d, 6755d)), sortFormats);
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(collector.getBottomSortValues().getFormattedSortValues().length, equalTo(1));  
        return values;
            // ignore bottom if we have less top docs than the requested size
            assertThat(collector.getBottomSortValues().getSortValueFormats()[0], instanceOf(DocValueFormat.RAW.getClass()));
}
                ) };
        }
        }
 * You may obtain a copy of the License at  
            SortField[] sortFields = new SortField[] { new SortField("foo", SortField.Type.LONG, reverse) };
            assertThat(collector.getBottomSortValues().getRawSortValues().length, equalTo(1));
 * the Apache License, Version 2.0 (the "License"); you may
            } else {
            assertThat(collector.getBottomSortValues().getSortValueFormats().length, equalTo(1));
            }
            DocValueFormat[] sortFormats = new DocValueFormat[] { DocValueFormat.RAW };
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo("hoo"));  
        BytesRef[] bytesRefs = new BytesRef[values.length];
            SortField[] sortFields = new SortField[] { new SortField("foo", SortField.Type.LONG, reverse) };
            assertThat(collector.getBottomSortValues().getSortValueFormats()[0], instanceOf(DocValueFormat.DateTime.class));  
            if (reverse) {
            SortField[] sortFields = new SortField[] { new SortField("foo", SortField.Type.LONG, reverse) };
    public void testWithStrings() {  
            assertNotNull(collector.getBottomSortValues());
            assertThat(collector.getBottomSortValues().getSortValueFormats()[0], instanceOf(DocValueFormat.DateTime.class));
                sortFormats
            collector.consumeTopDocs(  
 * under the License.  
            collector.consumeTopDocs(
            BottomSortValuesCollector collector = new BottomSortValuesCollector(3, sortFields);  
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(1522768227000L));
        for (boolean reverse : new boolean[] { true, false }) {  
        for (boolean reverse : new boolean[] { true, false }) {
            SortField[] sortFields = new SortField[] { new SortField("foo", SortField.Type.LONG, reverse) };
            collector.consumeTopDocs(createTopDocs(sortFields[0], 1, newLongArray(-100L)), sortFormats);  
                sortFormats
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo(10L));  
                createTopDocs(sortFields[0], 100, newDateArray("2018-05-21T08:10:10Z", "2015-02-08T15:12:34Z", "2015-01-01T13:10:30Z")),
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newLongArray()), sortFormats);
            );
    public void testWithLongs() {
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo("2018-04-03T15:10:27.000Z"));
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newDateNanoArray()), sortFormats);
    }  
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo("2015-07-09T14:00:30.000Z"));
            SortField[] otherSortFields = new SortField[] { new SortField("foo", SortField.Type.STRING_VAL, reverse) };  
import org.apache.lucene.search.TotalHits;  
    private Object[] newLongArray(Long... values) {  
            assertThat(collector.getTotalHits(), equalTo(300L));  
                sortFormats
        for (boolean reverse : new boolean[] { true, false }) {
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newDoubleArray(100d, 101d, 102d)), sortFormats);
            );  
 * compatible open source license.
    }
 * this work for additional information regarding copyright
                sortFormats
            DocValueFormat[] sortFormats = new DocValueFormat[] {
/*  
            );
    }
            );  
                createTopDocs(sortFields[0], 50, newDateArray("2019-12-30T07:34:20Z", "2017-03-01T12:10:30Z", "2015-07-09T14:00:30Z")),
            assertThat(collector.getTotalHits(), equalTo(150L));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        FieldDoc[] fieldDocs = new FieldDoc[values.length];
        for (int i = 0; i < bytesRefs.length; i++) {  
            BottomSortValuesCollector collector = new BottomSortValuesCollector(3, sortFields);
        for (boolean reverse : new boolean[] { true, false }) {
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(3L));
    }  
/*
            assertThat(collector.getTotalHits(), equalTo(301L));
package org.opensearch.action.search;
            BottomSortValuesCollector collector = new BottomSortValuesCollector(3, sortFields);
    }  
            longs[i] = DateUtils.toNanoSeconds(DateFieldMapper.getDefaultDateTimeFormatter().parseMillis(values[i]));
            assertThat(collector.getBottomSortValues().getSortValueFormats()[0], instanceOf(DocValueFormat.RAW.getClass()));
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo(3.5d));  
 */  
        }
            collector.consumeTopDocs(createTopDocs(sortFields[0], 100, newDoubleArray(0.1d, 1.5d, 3.5d)), sortFormats);
 *  
            } else {
        }  
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(1522768227000000000L));  
import org.opensearch.index.mapper.DateFieldMapper;  
            collector.consumeTopDocs(
            collector.consumeTopDocs(
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(3.5d));
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newBytesArray()), sortFormats);
 *
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo(1000L));  
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newDoubleArray()), sortFormats);  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
            assertThat(collector.getBottomSortValues().getFormattedSortValues().length, equalTo(1));  
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newLongArray(1L, 2L, 3L)), sortFormats);  
            if (reverse) {
            assertThat(collector.getBottomSortValues().getRawSortValues().length, equalTo(1));
            assertThat(collector.getBottomSortValues().getRawSortValues().length, equalTo(1));
            } else {
 * SPDX-License-Identifier: Apache-2.0
        Long[] longs = new Long[values.length];
            }
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newDateArray()), sortFormats);
import org.apache.lucene.search.Pruning;  
    }
                createTopDocs(sortFields[0], 100, newDateNanoArray("2017-06-01T12:18:20Z", "2018-04-03T15:10:27Z", "2013-06-01T13:10:20Z")),  
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo(500d));  
        int reverseMul = sortField.getReverse() ? -1 : 1;
    }
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(new BytesRef("hoo")));
            BottomSortValuesCollector collector = new BottomSortValuesCollector(3, sortFields);
import org.opensearch.search.DocValueFormat;
            longs[i] = DateFieldMapper.getDefaultDateTimeFormatter().parseMillis(values[i]);  
                    DateFieldMapper.getDefaultDateTimeFormatter(),  
                createTopDocs(sortFields[0], 100, newDateNanoArray("2018-05-21T08:10:10Z", "2015-02-08T15:12:34Z", "2015-01-01T13:10:30Z")),
 * not use this file except in compliance with the License.
            BottomSortValuesCollector collector = new BottomSortValuesCollector(3, sortFields);  
    private Object[] newDateNanoArray(String... values) {
    }
            bytesRefs[i] = values[i] == null ? null : new BytesRef(values[i]);
            assertThat(collector.getBottomSortValues().getSortValueFormats().length, equalTo(1));  
            assertThat(collector.getBottomSortValues().getRawSortValues().length, equalTo(1));
            SortField[] sortFields = new SortField[] { new SortField("foo", SortField.Type.LONG, reverse) };  
        }  
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(25L));
        return longs;
    private Object[] newBytesArray(String... values) {
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(1436450430000L));
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo(25L));  
            } else {  
                    DateFieldMapper.Resolution.NANOSECONDS
            collector.consumeTopDocs(createTopDocs(otherSortFields[0], 50, newBytesArray("foo", "bar", "zoo")), sortFormats);
            collector.consumeTopDocs(createTopDocs(sortFields[0], 100, newLongArray(5L, 10L, 15L)), sortFormats);
    }
    private Object[] newDateArray(String... values) {  
            if (reverse) {
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(10L));
            if (reverse) {
            fieldDocs[i] = new FieldDoc(i, Float.NaN, new Object[] { values[i] });
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo("2018-04-03T15:10:27.000Z"));
 * this file be licensed under the Apache-2.0 license or a
            }
            assertThat(collector.getBottomSortValues().getRawSortValues().length, equalTo(1));
            collector.consumeTopDocs(createTopDocs(sortFields[0], 100, newLongArray(25L, 350L, 3500L)), sortFormats);
import org.opensearch.test.OpenSearchTestCase;
    private TopFieldDocs createTopDocs(SortField sortField, int totalHits, Object[] values) {
            assertThat(collector.getBottomSortValues().getSortValueFormats()[0], instanceOf(DocValueFormat.RAW.getClass()));
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo(3L));  
 */
            } else {
    public void testWithDateNanos() {
        for (boolean reverse : new boolean[] { true, false }) {  
            assertNotNull(collector.getBottomSortValues());
            collector.consumeTopDocs(  
            BottomSortValuesCollector collector = new BottomSortValuesCollector(3, sortFields);
 * GitHub history for details.
        Long[] longs = new Long[values.length];  
            DocValueFormat[] sortFormats = new DocValueFormat[] {
import java.time.ZoneId;
        for (int i = 0; i < values.length; i++) {
                createTopDocs(sortFields[0], 50, newDateNanoArray("2019-12-30T07:34:20Z", "2017-03-01T12:10:30Z", "2015-07-09T14:00:30Z")),  
        return values;  
                new DocValueFormat.DateTime(
import static org.hamcrest.Matchers.instanceOf;
            collector.consumeTopDocs(createTopDocs(sortFields[0], 2, newDoubleArray(0d, 1d)), sortFormats);  
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(500d));
            DocValueFormat[] sortFormats = new DocValueFormat[] { DocValueFormat.RAW };  
            );
            assertNotNull(collector.getBottomSortValues());
    }
import org.apache.lucene.search.FieldComparator;
        }
                sortFormats  
            }
        }
                    ZoneId.of("UTC"),
            assertThat(collector.getBottomSortValues().getFormattedSortValues().length, equalTo(1));  
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(1000L));
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo("2015-07-09T14:00:30.000Z"));
        for (int i = 0; i < values.length; i++) {
            }  
    public void testWithMixedTypes() {  
            assertThat(collector.getBottomSortValues().getSortValueFormats().length, equalTo(1));
            );  
        FieldComparator cmp = sortField.getComparator(1, Pruning.NONE);  
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(new BytesRef("tar")));
        }  
            } else {
            collector.consumeTopDocs(createTopDocs(sortFields[0], 100, newBytesArray("bar", "car", "zar")), sortFormats);  
        return bytesRefs;  
            collector.consumeTopDocs(createTopDocs(sortFields[0], 100, newBytesArray("foo", "goo", "hoo")), sortFormats);
                ) };  
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(1436450430000000000L));  
 * specific language governing permissions and limitations
            DocValueFormat[] sortFormats = new DocValueFormat[] { DocValueFormat.RAW };
        for (boolean reverse : new boolean[] { true, false }) {  
            assertThat(collector.getTotalHits(), equalTo(302L));
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo("tar"));  
import org.apache.lucene.search.TopFieldDocs;
                createTopDocs(sortFields[0], 100, newDateArray("2017-06-01T12:18:20Z", "2018-04-03T15:10:27Z", "2013-06-01T13:10:20Z")),
            assertThat(collector.getBottomSortValues().getRawSortValues().length, equalTo(1));  
            collector.consumeTopDocs(  
            assertThat(collector.getTotalHits(), equalTo(300L));
/*  
    }  
 * Unless required by applicable law or agreed to in writing,
 *
                    DateFieldMapper.getDefaultDateTimeFormatter(),
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newBytesArray("tar", "zar", "zzz")), sortFormats);
                new DocValueFormat.DateTime(  
public class BottomSortValuesCollectorTests extends OpenSearchTestCase {
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newBytesArray(null, null, "zzz")), sortFormats);  
            // ignore bottom if we have less top docs than the requested size
 * software distributed under the License is distributed on an
            if (reverse) {  
 */  
            assertThat(collector.getBottomSortValues().getSortValueFormats()[0], instanceOf(DocValueFormat.RAW.getClass()));
            assertNotNull(collector.getBottomSortValues());
                    DateFieldMapper.Resolution.MILLISECONDS  
import java.util.Arrays;
        }
            assertThat(collector.getBottomSortValues().getSortValueFormats().length, equalTo(1));  
                    ZoneId.of("UTC"),
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
        return longs;
            DocValueFormat[] sortFormats = new DocValueFormat[] { DocValueFormat.RAW };
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.util.BytesRef;
        return new TopFieldDocs(new TotalHits(totalHits, GREATER_THAN_OR_EQUAL_TO), fieldDocs, new SortField[] { sortField });  
import static org.hamcrest.Matchers.equalTo;
            assertNotNull(collector.getBottomSortValues());  
            assertThat(collector.getTotalHits(), equalTo(350L));
            collector.consumeTopDocs(createTopDocs(sortFields[0], 100, newLongArray(1000L, 100L, 10L)), sortFormats);  
import org.apache.lucene.search.SortField;
import org.opensearch.common.time.DateUtils;
        }
            if (reverse) {
    }  
        for (int i = 0; i < values.length; i++) {
            SortField[] sortFields = new SortField[] { new SortField("foo", SortField.Type.STRING_VAL, reverse) };
            assertThat(collector.getBottomSortValues().getSortValueFormats().length, equalTo(1));  
            }
import org.apache.lucene.search.FieldDoc;
            assertNotNull(collector.getBottomSortValues());
    private Object[] newDoubleArray(Double... values) {
                sortFormats
            assertThat(collector.getBottomSortValues().getSortValueFormats().length, equalTo(1));  
    public void testWithDoubles() {
    public void testWithDates() {
        Arrays.sort(fieldDocs, (o1, o2) -> reverseMul * cmp.compareValues(o1.fields[0], o2.fields[0]));
import static org.apache.lucene.search.TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO;  
 *    http://www.apache.org/licenses/LICENSE-2.0
