 * KIND, either express or implied.  See the License for the
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        w.addDocument(doc);
                SortedNumericDocValuesField.newSlowRangeQuery("field", instant, instant + 999)
                "field",
import org.opensearch.index.fielddata.IndexNumericFieldData;
        ((ApproximateScoreQuery) rangeQuery).setContext(new TestSearchContext(context));
            }
            null
        assertEquals("2015", new DateFieldType("field").docValueFormat("YYYY", ZoneOffset.UTC).format(instant));
            w.addDocument(doc);
            pack(new long[] { instant1 }).bytes,
    }
        topDocs = searcher.search(nullValueQuery, dates.size());
import org.opensearch.index.mapper.MappedFieldType.Relation;
            true,
import java.time.Instant;
import java.time.ZoneOffset;
            ft.isFieldWithinQuery(reader, "2016-01-02", "2016-02-12", randomBoolean(), randomBoolean(), null, null, context)
            context
        );
            true,
        assertEquals(
            null,
        );
        String date = "2015-10-12T12:09:55.000Z";
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        );
        assertEquals(expected, rangeQuery.rewrite(new IndexSearcher(new MultiReader())));
            ),
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
 * specific language governing permissions and limitations
        Document doc = new Document();
            true,
        // Fields with no value indexed.
        assertEquals(
    public void testDateResolutionForOverflow() throws IOException {
        queryBuilder.add(new TermQuery(new Term("domainAttributes.firmId", "12345678910111213")), BooleanClause.Occur.MUST);
                "field",
        );
            null,
            Resolution.MILLISECONDS,
        for (int i = 0; i < 100; i++) {
        long maxDateValue = Long.MIN_VALUE;
        String date = "2015-10-12T14:10:55";
            pack(new long[] { instant2 }).bytes,
            writableRegistry(),
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        );
            "-292275055-05-16T16:47:04.192Z"
import org.apache.lucene.index.Term;
        MappedFieldType ft = new DateFieldType("field");
        );
            Collections.emptyMap()
            null,
            ApproximatePointRangeQuery.LONG_FORMAT
        assertEquals(Relation.DISJOINT, ft2.isFieldWithinQuery(reader, "2015-10-09", "2016-01-02", false, false, null, null, context));
            ),
        assertTrue(rangeQuery instanceof ApproximateScoreQuery);
            false,
        }
        );
        assertEquals(Collections.singletonList(dateInFormat), fetchSourceValue(fieldWithFormat, dateInFormat));
            DateFormatter.forPattern("yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis||date_optional_time"),
        }
        DateFieldType ft = new DateFieldType("my_date");
            true,
                        dateInstant.isAfter(Instant.parse("2022-03-01T00:00:00Z"))
                pack(new long[] { instant }).bytes,
            null,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        }
            indexSettings,
        String nullValueDate = "2020-05-15T21:33:02.123456789Z";
    }
            Relation.WITHIN,
            Collections.emptyMap()
        assertEquals(date, ft.valueForDisplay(instant));
        MappedFieldType ft = new DateFieldType("field");
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;
                    long dateValue = dateField.numericValue().longValue();
        assertEquals(Collections.singletonList("1970/12/29"), fetchSourceValue(mapper, null, "yyyy/MM/dd"));
            null
            xContentRegistry(),
                long dateValue = dateField.numericValue().longValue();
            0,
        );
    }
            false,
                instant2,
    public void testIsFieldWithinQueryDateMillis() throws IOException {
        w.close();
import org.opensearch.index.query.QueryRewriteContext;
            Collections.emptyMap()
import org.apache.lucene.search.Sort;
            ft.isFieldWithinQuery(reader, "2015-09-25", "2016-05-29", randomBoolean(), randomBoolean(), null, null, context)
import org.opensearch.index.IndexSettings;
        IOUtils.close(reader, w, dir);
            new IndexSortSortedNumericDocValuesRangeQuery(
            null,
        ApproximatePointRangeQuery approximatePointRangeQuery = new ApproximatePointRangeQuery(
        long instant = DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse("2015-10-12T14:10:55"))
        instant1 = nowInMillis;
 * GitHub history for details.
            BigArrays.NON_RECYCLING_INSTANCE,
            null,
            null,
    private void doTestIsFieldWithinQuery(DateFieldType ft, DirectoryReader reader, DateTimeZone zone, DateMathParser alternateFormat)
            null,
            w.addDocument(doc);
            doc.add(new StringField("domainAttributes.firmId", "12345678910111213", Field.Store.YES));
        MappedFieldType fieldWithFormat = fieldType(Resolution.MILLISECONDS, "yyyy/MM/dd||epoch_millis", null);
import org.apache.lucene.document.NumericDocValuesField;
        String date = "2020-05-15T21:33:02.123456789Z";
        field.setLongValue(ft.parse("2016-04-03"));
 *
import org.apache.lucene.store.Directory;
            "-292275055-05-16T16:47:04.192Z",
        assertEquals(i - 1, ft.docValueFormat(null, ZoneOffset.UTC).parseLong("2015-10-12||/d", true, null));
            null,
            null,
            new IndexSettings(IndexMetadata.builder("foo").settings(indexSettings).build(), indexSettings),
            0,
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
        );
        assertEquals(
            Relation.DISJOINT,
        assertEquals(
                            && dateInstant.isBefore(Instant.parse("2022-04-01T00:00:00Z"))
        SortedNumericDocValues docValues = a.getLongValues();
        String date1 = "2015-10-12T14:10:55";
        DateFieldType ftWithNullValue = new DateFieldType(
            Relation.INTERSECTS,
    }
        );
        assertEquals(Collections.singletonList(nullValueDate), fetchSourceValue(nullFieldType, null));
        String date = "1990-12-29T00:00:00.000Z";
 * the Apache License, Version 2.0 (the "License"); you may
        QueryShardContext context = new QueryShardContext(
            "my_date",
                new long[] { instant1 }.length,
import org.apache.lucene.search.IndexSortSortedNumericDocValuesRangeQuery;
import java.util.Locale;
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
            null,
            () -> true,
            .put("index.sort.field", "field")
        SortedNumericIndexFieldData fieldData = new SortedNumericIndexFieldData(
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
            null,
        long instant2 = DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(date2)).toInstant().toEpochMilli() + 999;
                );
import org.opensearch.search.approximate.ApproximateScoreQuery;
                    LongPoint.newRangeQuery("field", instant1, instant2),
    }
        assertEquals(Collections.singletonList(nullValueDate), fetchSourceValue(nullValueMapper, null));
        List<String> dates = Arrays.asList(
        String dateInFormat = "1990/12/29";
    public void testRangeQueryWithIndexSort() {
            "2021-01-01T00:00:00Z",
                    assertTrue(
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.Query;
            .build();
import org.apache.lucene.index.IndexReader;
            Resolution.MILLISECONDS,
    }
        Directory dir = newDirectory();
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
                pack(new long[] { instant2 }).bytes,
public class DateFieldTypeTests extends FieldTypeTestCase {
        assertEquals(Collections.singletonList("2020-05-15T21:33:02.123Z"), fetchSourceValue(mapper, 1589578382123L));
                LongPoint.newRangeQuery("field", instant, instant + 999),
/*
    public void testParseSourceValueWithFormat() throws IOException {
        doc.add(docValuesField);
        MappedFieldType unsearchable = new DateFieldType(
import org.opensearch.search.approximate.ApproximatePointRangeQuery;
            "field",
                new IndexOrDocValuesQuery(LongPoint.newRangeQuery("field", instant1, instant2), dvQuery)
            null,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                doc.add(new StoredField(ft.name(), timestamp));
            null,
        TopDocs topDocs = searcher.search(rangeQuery, dates.size());
        MappedFieldType ft = new DateFieldType("field");
    }
        doTestIsFieldWithinQuery(ft, reader, null, null);
        String date2 = "2016-04-28T11:33:52";
            Resolution.MILLISECONDS,
        assertEquals(Relation.INTERSECTS, ft.isFieldWithinQuery(reader, "2015-10-12", "2016-04-03", false, false, null, null, context));
    public void testFetchSourceValue() throws IOException {
        assertEquals(Relation.WITHIN, ft.isFieldWithinQuery(reader, "2015-10-12", "2016-04-03", true, true, null, null, context));
import java.io.IOException;
            assertEquals("Total hits should match total documents", nullDocs + datedDocs, topDocs.totalHits.value());
            true,
            "2020-01-01T00:00:00Z",
        docValuesField.setLongValue(1459641600000L);
            ParseContext.Document doc = new ParseContext.Document();
        assertEquals(Collections.singletonList(date), fetchSourceValue(fieldType, 1589578382000L));
            null,
                    SortedNumericDocValuesField.newSlowRangeQuery("field", instant1, instant2)
            w.addDocument(doc);
            doc.add(new LongPoint(ft.name(), timestamp));
        throws IOException {
                    Instant dateInstant = Instant.ofEpochMilli(dateValue);
import org.apache.lucene.document.StringField;
            DateFieldMapper.getDefaultDateTimeFormatter(),
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            Relation.DISJOINT,
        QueryRewriteContext context = new BaseQueryRewriteContext(xContentRegistry(), writableRegistry(), null, () -> nowInMillis);
        DirectoryReader reader = DirectoryReader.open(w);
        MappedFieldType ft = new DateFieldType("field");
            null,
            TopDocs topDocs = searcher.search(queryBuilder.build(), nullDocs + datedDocs, sort);
        Settings indexSettings = Settings.builder()
        assertEquals(instant + 999, ft.docValueFormat(null, ZoneOffset.UTC).parseLong("2015-10-12T14:10:55", true, null));
            "domainAttributes.dueDate",
        );
            new ApproximatePointRangeQuery(
    public void testParseSourceValueNanos() throws IOException {
import org.apache.lucene.document.Field;
        IOUtils.close(reader, w, dir);
            true,
            long timestamp = Resolution.MILLISECONDS.convert(DateFormatters.from(ft.dateTimeFormatter().parse(dateStr)).toInstant());
                }
        MappedFieldType nullFieldType = fieldType(Resolution.MILLISECONDS, "strict_date_time", nullValueDate);
            "+292278994-08-17T07:12:55.807Z",
            null,
    }
        Query nullValueQuery = ftWithNullValue.termQuery("2020-01-01T00:00:00Z", context);
            )
        String date = "2020-05-15T21:33:02.000Z";
            new IndexSettings(IndexMetadata.builder("foo").settings(indexSettings).build(), indexSettings),
        Query expected = new ApproximateScoreQuery(
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
            null,
            null,
        Query expected = new ApproximateScoreQuery(
            new DateRangeIncludingNowQuery(
    }
        assertEquals("Documents matching the 2020-01-01 date", 1, topDocs.totalHits.value());
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            null,
        DateFieldType ft = new DateFieldType("my_date", Resolution.NANOSECONDS);
            new IndexSettings(IndexMetadata.builder("foo").settings(indexSettings).build(), indexSettings),
        Directory dir = newDirectory();
            null,
            () -> true,
            null,
        assertEquals(Collections.singletonList(date), fetchSourceValue(fieldType, date));
    public void testValueFormat() {
 */
import org.opensearch.Version;
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
        doc.add(field);
                if (dateField != null) {
        long minDateValue = Long.MAX_VALUE;
            doc.add(new SortedNumericDocValuesField(ft.name(), timestamp));
    private static DateFieldType fieldType(Resolution resolution, String format, String nullValue) {
        assertEquals(
 */
import static org.apache.lucene.document.LongPoint.pack;
        assertEquals(Collections.singletonList("2020-05-15T21:33:02.123456789Z"), fetchSourceValue(mapper, date));
        String date1 = "2015-10-12T14:10:55";
                doc.add(new StoredField("id", i));
        MappedFieldType nullValueMapper = fieldType(Resolution.NANOSECONDS, "strict_date_time||epoch_millis", nullValueDate);
            null,
package org.opensearch.index.mapper;
            .toEpochMilli();
        );
            .build();
        instant2 = instant1 + 100;
    private static final long nowInMillis = 0;
        assertEquals(1, docValues.nextDoc());
        w.addDocument(doc);
        long instant = DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(date)).toInstant().toEpochMilli();
        );
import org.apache.lucene.document.StoredField;
import org.opensearch.test.TestSearchContext;
                pack(new long[] { instant + 999 }).bytes,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                "field",
        );
            true,
            "test_date",
        long i = DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse("2015-10-13")).toInstant().toEpochMilli();
        w.addDocument(doc);
        String date2 = "2016-04-28T11:33:52";
            String dateStr = dates.get(i);
        DateFieldType ft = new DateFieldType(
        IOUtils.close(reader, w, dir);
            () -> nowInMillis,
        Query dvQuery = SortedNumericDocValuesField.newSlowRangeQuery("field", instant1, instant2);
            null,
            String dateStr = String.format(Locale.ROOT, "2022-03-%02dT15:40:58.324", (i % 30) + 1);
            null,
            writableRegistry(),
        );
        LeafNumericFieldData a = fieldData.load(reader.leaves().get(0).reader().getContext());
        }
 * compatible open source license.
                pack(new long[] { instant1 }).bytes,
 * not use this file except in compliance with the License.
        DateFieldType ft = new DateFieldType(
    public void testValueForSearch() {
                doc.add(new SortedNumericDocValuesField(ft.name(), timestamp));
    public void testIsFieldWithinRangeEmptyReader() throws IOException {
        for (int i = 0; i < nullDocs; i++) {
                    "Date value " + dateValue + " should be within valid range",
            BigArrays.NON_RECYCLING_INSTANCE,
            () -> 0L,
        assertEquals("2015-10-12T14:10:55.000Z", ft.docValueFormat(null, ZoneOffset.UTC).format(instant));
 * SPDX-License-Identifier: Apache-2.0
            () -> nowInMillis,
            null,
            )
            IndexNumericFieldData.NumericType.DATE_NANOSECONDS
            Collections.emptyMap()
        QueryShardContext context = new QueryShardContext(
import org.apache.lucene.document.SortedNumericDocValuesField;
        int datedDocs = 50;
        assertEquals(expected, ft.rangeQuery(date1, date2, true, true, null, null, null, context));
        assertEquals(instant, ft.docValueFormat(null, ZoneOffset.UTC).parseLong("2015-10-12T14:10:55", false, null));
        DirectoryReader reader = DirectoryReader.open(w);
            IllegalArgumentException.class,
        assertEquals("2015-10-12T15:10:55.000+01:00", ft.docValueFormat(null, ZoneOffset.ofHours(1)).format(instant));
            approximatePointRangeQuery
        doTestIsFieldWithinQuery(ft, reader, DateTimeZone.UTC, alternateFormat);
            ),
            BigArrays.NON_RECYCLING_INSTANCE,
        QueryShardContext context = new QueryShardContext(
            null,
    }
            }
            null,
            doc.add(new StoredField(ft.name(), timestamp));
                maxDateValue = Math.max(maxDateValue, timestamp);
            null,
            ),
                pack(new long[] { instant1 }).bytes,
        IndexSearcher searcher = new IndexSearcher(reader);
            () -> true,
                doc.add(new StoredField("id", i));
        assertEquals(Collections.singletonList("1990/12/29"), fetchSourceValue(mapper, date, "yyyy/MM/dd"));
import org.apache.lucene.index.DirectoryReader;
        MappedFieldType unsearchable = new DateFieldType(
        DirectoryReader reader = DirectoryReader.open(w);
        dir.close();
            true,
        for (int i = 1; i <= datedDocs; i++) {
import org.joda.time.DateTimeZone;
            "field",
            DateFormatter.forPattern("yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis||strict_date_optional_time"),
            new IndexOrDocValuesQuery(
                IndexableField dateField = doc.getField(ft.name());
import org.apache.lucene.search.IndexOrDocValuesQuery;
        isFieldWithinRangeTestCase(ft);
        );
            null,
        assertEquals(expected, ft.rangeQuery("now", instant2, true, true, null, null, null, context));
            new ApproximatePointRangeQuery(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        IndexSearcher searcher = new IndexSearcher(reader);
        assertEquals(Collections.singletonList(dateInFormat), fetchSourceValue(fieldWithFormat, 662428800000L));
            null
    }
        );
        Settings settings = Settings.builder()
                new long[] { instant }.length,
 *
import java.util.Collections;
 * Licensed to Elasticsearch under one or more contributor
            0,
    }
            ParseContext.Document doc = new ParseContext.Document();
            .build();
        assertEquals(
            "2020-01-01T00:00:00Z",
            Relation.DISJOINT,
            0,
import org.opensearch.common.time.DateMathParser;
        for (int i = 0; i < dates.size(); i++) {
            false,
 * Unless required by applicable law or agreed to in writing,
}
                instant1,
        );
            xContentRegistry(),
                LongPoint.newRangeQuery("field", instant1, instant2),
                ApproximatePointRangeQuery.LONG_FORMAT
                    dateValue >= minDateValue && dateValue <= maxDateValue
        MappedFieldType millis = fieldType(Resolution.MILLISECONDS, "epoch_millis", null);
                minDateValue = Math.min(minDateValue, timestamp);
                        "Date should be in March 2022",
        );
            "test_date",
                doc.add(new LongPoint(ft.name(), timestamp));
/*
            "field",
        MappedFieldType mapper = fieldType(Resolution.NANOSECONDS, "strict_date_time||epoch_millis", null);
        doTestIsFieldWithinQuery(ft, reader, null, alternateFormat);
            null,
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;
import org.opensearch.cluster.metadata.IndexMetadata;
            true,
            null,
        w.addDocument(doc);
            org.apache.lucene.document.Document doc = reader.storedFields().document(scoreDoc.doc);
            if (dateStr != null) {
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, docValues.nextDoc());
 * software distributed under the License is distributed on an
import java.util.List;
 *     http://www.apache.org/licenses/LICENSE-2.0
            IndexableField dateField = doc.getField(ft.name());
            } else {
            null,
import org.apache.lucene.search.BooleanQuery;
import org.opensearch.index.mapper.ParseContext.Document;
        long instant1 = DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(date1)).toInstant().toEpochMilli();
        assertEquals(Relation.INTERSECTS, ft.isFieldWithinQuery(reader, "2015-10-12", "2016-04-03", false, true, null, null, context));
        int numNullDates = 0;
        assertEquals(
            ft.isFieldWithinQuery(reader, "2015-10-09", "2016-01-02", randomBoolean(), randomBoolean(), null, null, context)
            writableRegistry(),
            false,
        assertEquals(0, docValues.nextDoc());
            null,
        Query expected = new ApproximateScoreQuery(
        QueryRewriteContext context = new BaseQueryRewriteContext(xContentRegistry(), writableRegistry(), null, () -> nowInMillis);
import org.apache.lucene.index.MultiReader;
import org.apache.lucene.index.IndexWriterConfig;
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
 */
        );
                ApproximatePointRangeQuery.LONG_FORMAT
        Document doc = new Document();
            null,
            new IndexOrDocValuesQuery(
        );
        assertEquals(Collections.singletonList(dateInMillis), fetchSourceValue(millis, 662428800000L));
        }
import org.apache.lucene.search.BooleanClause;
            new long[] { instant1 }.length,
                SortedNumericDocValuesField.newSlowRangeQuery("field", instant1, instant2)
                long timestamp = Resolution.MILLISECONDS.convert(DateFormatters.from(ft.dateTimeFormatter().parse(dateStr)).toInstant());
import org.opensearch.common.time.DateFormatters;
            null,
        );
        Query rangeQuery = ft.rangeQuery(date1, date2, true, true, null, null, null, context);
        MappedFieldType mapper = fieldType(Resolution.NANOSECONDS, "strict_date_time", "1970-12-29T00:00:00.000Z");
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        String nullValueDate = "2020-05-15T21:33:02.000Z";
        );
        reader.close();
        BooleanQuery.Builder queryBuilder = new BooleanQuery.Builder();
 * license agreements. See the NOTICE file distributed with
        MappedFieldType ft = new DateFieldType("field");
    }
import org.apache.lucene.search.SortField;
        DateFieldType ft2 = new DateFieldType("my_date2");
            null,
            DateFieldMapper.getDefaultDateTimeFormatter(),
            Resolution.MILLISECONDS,
import org.opensearch.index.mapper.DateFieldMapper.Resolution;
            null,
            Relation.INTERSECTS,
        int nullDocs = 3500;
        String dateInMillis = "662428800000";
        assertEquals(Relation.INTERSECTS, ft.isFieldWithinQuery(reader, "2015-10-12", "2016-04-03", true, false, null, null, context));
        IndexReader reader = new MultiReader();
import org.opensearch.index.query.DateRangeIncludingNowQuery;
            xContentRegistry(),
import org.opensearch.index.query.BaseQueryRewriteContext;
            null,
 * this file be licensed under the Apache-2.0 license or a
            null,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                numNullDates++;
            null
        // Create the doc values reader
    public void isFieldWithinRangeTestCase(DateFieldType ft) throws IOException {
import org.apache.lucene.search.ScoreDoc;
                    );
            Relation.INTERSECTS,
            }
                pack(new long[] { instant2 }).bytes,
            true,
            Collections.emptyMap()
    public void testTermQuery() {
        QueryRewriteContext context = new BaseQueryRewriteContext(xContentRegistry(), writableRegistry(), null, () -> nowInMillis);
        isFieldWithinRangeTestCase(ft);
            () -> true,
                new IndexOrDocValuesQuery(
            .toInstant()
    }
            ParseContext.Document doc = new ParseContext.Document();
    public void testRangeQuery() throws IOException {
        Sort sort = new Sort(new SortField(ft.name(), SortField.Type.DOC, false));
        doTestIsFieldWithinQuery(ft, reader, DateTimeZone.UTC, null);
            true,
 * ownership. Elasticsearch licenses this file to you under
            null,
            "+292278994-08-17T07:12:55.807Z",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertTrue(reader.leaves().size() > 0);
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.DocIdSetIterator;
    }
            xContentRegistry(),
                ApproximatePointRangeQuery.LONG_FORMAT
        Settings indexSettings = Settings.builder()
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQuery(date, context));
import org.opensearch.common.util.io.IOUtils;
                assertTrue(
            ft.isFieldWithinQuery(reader, "2016-05-11", "2016-08-30", randomBoolean(), randomBoolean(), null, null, context)
            ft.isFieldWithinQuery(reader, "2015-10-12", "2016-04-03", randomBoolean(), randomBoolean(), null, null, context)
                new long[] { instant1 }.length,
import org.apache.lucene.index.SortedNumericDocValues;
                org.apache.lucene.document.Document doc = reader.storedFields().document(scoreDoc.doc);
import org.opensearch.common.time.DateFormatter;
            .build();
            null,
        assertEquals("Number of non-null date documents", dates.size() - numNullDates, topDocs.totalHits.value());
import org.opensearch.common.util.BigArrays;
import org.apache.lucene.search.TopDocs;
import org.opensearch.common.settings.Settings;
        assertEquals(Collections.singletonList(dateInMillis), fetchSourceValue(millis, dateInMillis));
    public void testDateNanoDocValues() throws IOException {
 * under the License.
        );
 * You may obtain a copy of the License at
 *
import org.apache.lucene.index.IndexableField;
            if (dateField != null) {
            DateFormatter.forPattern("yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis||strict_date_optional_time"),
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);
    }
            new ApproximatePointRangeQuery(
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        // Create an index with some docValues
    public void testDateFieldTypeWithNulls() throws IOException {
        NumericDocValuesField docValuesField = new NumericDocValuesField("my_date", 1444608000000L);
            null,
        );
            ft.isFieldWithinQuery(reader, "2016-01-02", "2016-06-20", randomBoolean(), randomBoolean(), null, null, context)
        LongPoint field = new LongPoint("my_date", ft.parse("2015-10-12"));
        DateFieldType ft = new DateFieldType("my_date", Resolution.MILLISECONDS);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            Resolution.MILLISECONDS,
            writableRegistry(),
        Directory dir = newDirectory();
                "field",
    public void testIsFieldWithinQueryDateNanos() throws IOException {
            ft.isFieldWithinQuery(reader, "2014-01-02", "2015-02-12", randomBoolean(), randomBoolean(), null, null, context)
 * this work for additional information regarding copyright
            )
            () -> nowInMillis,
/*
        long instant1 = DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(date1)).toInstant().toEpochMilli();
import org.opensearch.index.fielddata.LeafNumericFieldData;
            null,
        assertEquals(expected, ft.termQuery(date, context));
import org.apache.lucene.document.LongPoint;
            false,
        // Read index and check the doc values
        long instant = DateFieldMapper.getDefaultDateTimeFormatter().parseMillis(date);
            null,
        DirectoryReader reader = DirectoryReader.open(w);
        Directory dir = newDirectory();
        Query rangeQuery = ft.rangeQuery(
            BigArrays.NON_RECYCLING_INSTANCE,
        DateMathParser alternateFormat = DateFieldMapper.getDefaultDateTimeFormatter().toDateMathParser();
        expected = new ApproximateScoreQuery(
    }
        QueryShardContext context = new QueryShardContext(
        long instant2 = DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(date2)).toInstant().toEpochMilli() + 999;
 * The OpenSearch Contributors require contributions made to
import java.util.Arrays;
            () -> unsearchable.rangeQuery(date1, date2, true, true, null, null, null, context)
            doc.add(new StringField("domainAttributes.firmId", "12345678910111213", Field.Store.YES));
        IllegalArgumentException e = expectThrows(
        DateFormatter formatter = DateFormatter.forPattern(format);
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.IndexSearcher;
            false,
        return new DateFieldType("field", true, false, true, formatter, resolution, nullValue, Collections.emptyMap());
        Settings indexSettings = Settings.builder()
import org.opensearch.index.query.QueryShardContext;
                )
        MappedFieldType fieldType = new DateFieldType("field", Resolution.MILLISECONDS);
            null,
        assertEquals(Collections.singletonList("662428800000"), fetchSourceValue(mapper, date, "epoch_millis"));
