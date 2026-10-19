        for (boolean reverse : new boolean[] { true, false }) {
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(10L));
                createTopDocs(sortFields[0], 100, newDateNanoArray("2017-06-01T12:18:20Z", "2018-04-03T15:10:27Z", "2013-06-01T13:10:20Z")),
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo("tar"));
package org.opensearch.action.search;
            assertNotNull(collector.getBottomSortValues());
import org.apache.lucene.search.FieldComparator;
            if (reverse) {
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(1522768227000000000L));
            fieldDocs[i] = new FieldDoc(i, Float.NaN, new Object[] { values[i] });
                sortFormats
                sortFormats
        int reverseMul = sortField.getReverse() ? -1 : 1;
            } else {
            if (reverse) {
            bytesRefs[i] = values[i] == null ? null : new BytesRef(values[i]);
        }
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(25L));
        }
        FieldDoc[] fieldDocs = new FieldDoc[values.length];
                new DocValueFormat.DateTime(
        for (boolean reverse : new boolean[] { true, false }) {
            }
            assertThat(collector.getBottomSortValues().getSortValueFormats()[0], instanceOf(DocValueFormat.RAW.getClass()));
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newLongArray(1L, 2L, 3L)), sortFormats);
            DocValueFormat[] sortFormats = new DocValueFormat[] { DocValueFormat.RAW };
            assertThat(collector.getTotalHits(), equalTo(300L));
            collector.consumeTopDocs(createTopDocs(sortFields[0], 100, newDoubleArray(0.1d, 1.5d, 3.5d)), sortFormats);
            } else {
            DocValueFormat[] sortFormats = new DocValueFormat[] { DocValueFormat.RAW };
    public void testWithDateNanos() {
        for (boolean reverse : new boolean[] { true, false }) {
 * Unless required by applicable law or agreed to in writing,
        Long[] longs = new Long[values.length];
            );
            collector.consumeTopDocs(
            assertThat(collector.getBottomSortValues().getFormattedSortValues().length, equalTo(1));
            assertThat(collector.getBottomSortValues().getSortValueFormats().length, equalTo(1));
import org.opensearch.common.time.DateUtils;
            assertNotNull(collector.getBottomSortValues());
 *
        for (boolean reverse : new boolean[] { true, false }) {
import java.time.ZoneId;
            assertThat(collector.getBottomSortValues().getSortValueFormats()[0], instanceOf(DocValueFormat.DateTime.class));
        FieldComparator cmp = sortField.getComparator(1, Pruning.NONE);
            assertThat(collector.getBottomSortValues().getRawSortValues().length, equalTo(1));
            collector.consumeTopDocs(createTopDocs(sortFields[0], 100, newLongArray(1000L, 100L, 10L)), sortFormats);
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newBytesArray()), sortFormats);
import static org.apache.lucene.search.TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO;
import org.apache.lucene.search.FieldDoc;
    }
            assertThat(collector.getBottomSortValues().getSortValueFormats()[0], instanceOf(DocValueFormat.RAW.getClass()));
 *
            collector.consumeTopDocs(createTopDocs(sortFields[0], 100, newLongArray(5L, 10L, 15L)), sortFormats);
            assertThat(collector.getBottomSortValues().getRawSortValues().length, equalTo(1));
            // ignore bottom if we have less top docs than the requested size
    public void testWithLongs() {
            longs[i] = DateFieldMapper.getDefaultDateTimeFormatter().parseMillis(values[i]);
                ) };
            collector.consumeTopDocs(
            SortField[] sortFields = new SortField[] { new SortField("foo", SortField.Type.LONG, reverse) };
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(3L));
    }
public class BottomSortValuesCollectorTests extends OpenSearchTestCase {
                ) };
            BottomSortValuesCollector collector = new BottomSortValuesCollector(3, sortFields);
import static org.hamcrest.Matchers.instanceOf;
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo("hoo"));
            collector.consumeTopDocs(createTopDocs(sortFields[0], 100, newBytesArray("bar", "car", "zar")), sortFormats);
 */
            SortField[] sortFields = new SortField[] { new SortField("foo", SortField.Type.LONG, reverse) };
                sortFormats
            assertNotNull(collector.getBottomSortValues());
            assertThat(collector.getBottomSortValues().getFormattedSortValues().length, equalTo(1));
import org.apache.lucene.search.SortField;
 * ownership. Elasticsearch licenses this file to you under
        }
            );
            SortField[] sortFields = new SortField[] { new SortField("foo", SortField.Type.LONG, reverse) };
            if (reverse) {
    public void testWithDates() {
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
            assertThat(collector.getBottomSortValues().getFormattedSortValues().length, equalTo(1));
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.
                sortFormats
import org.apache.lucene.util.BytesRef;
                sortFormats
import org.apache.lucene.search.TopFieldDocs;
import org.apache.lucene.search.Pruning;
        return values;
 * The OpenSearch Contributors require contributions made to
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(1000L));
                    ZoneId.of("UTC"),
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(1436450430000L));
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newDateArray()), sortFormats);
            DocValueFormat[] sortFormats = new DocValueFormat[] { DocValueFormat.RAW };
    private Object[] newDoubleArray(Double... values) {
    }
            );
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(1522768227000L));
            assertThat(collector.getTotalHits(), equalTo(150L));
 * specific language governing permissions and limitations
 *
            );
            BottomSortValuesCollector collector = new BottomSortValuesCollector(3, sortFields);
 * You may obtain a copy of the License at
import static org.hamcrest.Matchers.equalTo;
            assertNotNull(collector.getBottomSortValues());
        }
        for (int i = 0; i < bytesRefs.length; i++) {
import org.apache.lucene.search.TotalHits;
            SortField[] sortFields = new SortField[] { new SortField("foo", SortField.Type.LONG, reverse) };
            collector.consumeTopDocs(createTopDocs(sortFields[0], 1, newLongArray(-100L)), sortFormats);
import java.util.Arrays;
 * GitHub history for details.
            assertThat(collector.getBottomSortValues().getSortValueFormats()[0], instanceOf(DocValueFormat.RAW.getClass()));
            SortField[] sortFields = new SortField[] { new SortField("foo", SortField.Type.STRING_VAL, reverse) };
            assertThat(collector.getBottomSortValues().getSortValueFormats().length, equalTo(1));
            BottomSortValuesCollector collector = new BottomSortValuesCollector(3, sortFields);
            DocValueFormat[] sortFormats = new DocValueFormat[] {
        return values;
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo("2018-04-03T15:10:27.000Z"));
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo(25L));
            assertThat(collector.getBottomSortValues().getSortValueFormats().length, equalTo(1));
        }
 * SPDX-License-Identifier: Apache-2.0
    public void testWithDoubles() {
            assertThat(collector.getBottomSortValues().getRawSortValues().length, equalTo(1));
                createTopDocs(sortFields[0], 100, newDateNanoArray("2018-05-21T08:10:10Z", "2015-02-08T15:12:34Z", "2015-01-01T13:10:30Z")),
            // ignore bottom if we have less top docs than the requested size
/*
 * software distributed under the License is distributed on an
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo(3.5d));
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo("2018-04-03T15:10:27.000Z"));
 * Licensed to Elasticsearch under one or more contributor
 */
    private TopFieldDocs createTopDocs(SortField sortField, int totalHits, Object[] values) {
    public void testWithMixedTypes() {
            collector.consumeTopDocs(
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo(1000L));
            if (reverse) {
            longs[i] = DateUtils.toNanoSeconds(DateFieldMapper.getDefaultDateTimeFormatter().parseMillis(values[i]));
        }
        BytesRef[] bytesRefs = new BytesRef[values.length];
            BottomSortValuesCollector collector = new BottomSortValuesCollector(3, sortFields);
                    ZoneId.of("UTC"),
            DocValueFormat[] sortFormats = new DocValueFormat[] {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            BottomSortValuesCollector collector = new BottomSortValuesCollector(3, sortFields);
        for (boolean reverse : new boolean[] { true, false }) {
            assertThat(collector.getTotalHits(), equalTo(301L));
        }
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newDateNanoArray()), sortFormats);
            } else {
            collector.consumeTopDocs(createTopDocs(sortFields[0], 100, newBytesArray("foo", "goo", "hoo")), sortFormats);
        Long[] longs = new Long[values.length];
        for (int i = 0; i < values.length; i++) {
    }
            SortField[] sortFields = new SortField[] { new SortField("foo", SortField.Type.LONG, reverse) };
            SortField[] otherSortFields = new SortField[] { new SortField("foo", SortField.Type.STRING_VAL, reverse) };
    }
 */
 * KIND, either express or implied.  See the License for the
            collector.consumeTopDocs(createTopDocs(sortFields[0], 100, newDoubleArray(500d, 5000d, 6755d)), sortFormats);
            assertThat(collector.getTotalHits(), equalTo(350L));
    }
            assertNotNull(collector.getBottomSortValues());
            BottomSortValuesCollector collector = new BottomSortValuesCollector(3, sortFields);
                createTopDocs(sortFields[0], 100, newDateArray("2017-06-01T12:18:20Z", "2018-04-03T15:10:27Z", "2013-06-01T13:10:20Z")),
            assertThat(collector.getBottomSortValues().getSortValueFormats()[0], instanceOf(DocValueFormat.DateTime.class));
            assertThat(collector.getBottomSortValues().getSortValueFormats().length, equalTo(1));
                    DateFieldMapper.Resolution.MILLISECONDS
            }
            if (reverse) {
                createTopDocs(sortFields[0], 100, newDateArray("2018-05-21T08:10:10Z", "2015-02-08T15:12:34Z", "2015-01-01T13:10:30Z")),
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo("2015-07-09T14:00:30.000Z"));
    }
        Arrays.sort(fieldDocs, (o1, o2) -> reverseMul * cmp.compareValues(o1.fields[0], o2.fields[0]));
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(500d));
        return bytesRefs;
            collector.consumeTopDocs(
        for (int i = 0; i < values.length; i++) {
 * this file be licensed under the Apache-2.0 license or a
            assertThat(collector.getBottomSortValues().getRawSortValues().length, equalTo(1));
        }
    private Object[] newLongArray(Long... values) {
            if (reverse) {
        for (int i = 0; i < values.length; i++) {
            }
            DocValueFormat[] sortFormats = new DocValueFormat[] { DocValueFormat.RAW };
    }
            assertThat(collector.getTotalHits(), equalTo(300L));
            }
            assertThat(collector.getBottomSortValues().getRawSortValues().length, equalTo(1));
            assertThat(collector.getBottomSortValues().getSortValueFormats().length, equalTo(1));
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo(10L));
                sortFormats
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newLongArray()), sortFormats);
            );
            collector.consumeTopDocs(createTopDocs(otherSortFields[0], 50, newBytesArray("foo", "bar", "zoo")), sortFormats);
                createTopDocs(sortFields[0], 50, newDateNanoArray("2019-12-30T07:34:20Z", "2017-03-01T12:10:30Z", "2015-07-09T14:00:30Z")),
            assertThat(collector.getTotalHits(), equalTo(302L));
    private Object[] newDateNanoArray(String... values) {
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo(500d));
    }
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newDoubleArray(100d, 101d, 102d)), sortFormats);
 * the Apache License, Version 2.0 (the "License"); you may
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(3.5d));
    }
    }
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
            assertThat(collector.getBottomSortValues().getSortValueFormats()[0], instanceOf(DocValueFormat.RAW.getClass()));
            } else {
        }
                    DateFieldMapper.Resolution.NANOSECONDS
        }
    private Object[] newDateArray(String... values) {
        return new TopFieldDocs(new TotalHits(totalHits, GREATER_THAN_OR_EQUAL_TO), fieldDocs, new SortField[] { sortField });
            collector.consumeTopDocs(createTopDocs(sortFields[0], 100, newLongArray(25L, 350L, 3500L)), sortFormats);
}
            }
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(new BytesRef("hoo")));
                    DateFieldMapper.getDefaultDateTimeFormatter(),
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newBytesArray(null, null, "zzz")), sortFormats);
                createTopDocs(sortFields[0], 50, newDateArray("2019-12-30T07:34:20Z", "2017-03-01T12:10:30Z", "2015-07-09T14:00:30Z")),
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(new BytesRef("tar")));
        return longs;
            );
            collector.consumeTopDocs(
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo(3L));
/*
                assertThat(collector.getBottomSortValues().getRawSortValues()[0], equalTo(1436450430000000000L));
            collector.consumeTopDocs(
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newDoubleArray()), sortFormats);
            } else {
/*
    public void testWithStrings() {
            collector.consumeTopDocs(createTopDocs(sortFields[0], 2, newDoubleArray(0d, 1d)), sortFormats);
    private Object[] newBytesArray(String... values) {
import org.opensearch.index.mapper.DateFieldMapper;
import org.opensearch.test.OpenSearchTestCase;
            assertThat(collector.getBottomSortValues().getSortValueFormats().length, equalTo(1));
                    DateFieldMapper.getDefaultDateTimeFormatter(),
            assertThat(collector.getBottomSortValues().getRawSortValues().length, equalTo(1));
                new DocValueFormat.DateTime(
                assertThat(collector.getBottomSortValues().getFormattedSortValues()[0], equalTo("2015-07-09T14:00:30.000Z"));
    }
import org.opensearch.search.DocValueFormat;
            collector.consumeTopDocs(createTopDocs(sortFields[0], 50, newBytesArray("tar", "zar", "zzz")), sortFormats);
        return longs;
            } else {
        for (boolean reverse : new boolean[] { true, false }) {
            }
            assertNotNull(collector.getBottomSortValues());
