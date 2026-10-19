        assertEquals(date, ft.valueForDisplay(instant));
            doc.add(new StringField("domainAttributes.firmId", "12345678910111213", Field.Store.YES));
import org.apache.lucene.search.BooleanClause;
                    );
    public void testDateNanoDocValues() throws IOException {
            Resolution.MILLISECONDS,
        NumericDocValuesField docValuesField = new NumericDocValuesField("my_date", 1444608000000L);
 *
        instant1 = nowInMillis;
        );
            () -> true,  
            Collections.emptyMap()  
            true,
    public void testParseSourceValueNanos() throws IOException {
 * The OpenSearch Contributors require contributions made to  
            null,  
            "my_date",
        String dateInMillis = "662428800000";
        DateFieldType ft = new DateFieldType("my_date", Resolution.MILLISECONDS);
        QueryShardContext context = new QueryShardContext(
import org.opensearch.search.approximate.ApproximatePointRangeQuery;
            "+292278994-08-17T07:12:55.807Z",  
            ft.isFieldWithinQuery(reader, "2015-10-09", "2016-01-02", randomBoolean(), randomBoolean(), null, null, context)
        assertEquals(
            () -> 0L,  
        Settings settings = Settings.builder()
            true,
 * Licensed to Elasticsearch under one or more contributor  
            null,  
        assertEquals(Collections.singletonList(nullValueDate), fetchSourceValue(nullValueMapper, null));  
 * under the License.  
            Relation.DISJOINT,
            () -> unsearchable.rangeQuery(date1, date2, true, true, null, null, null, context)
        QueryShardContext context = new QueryShardContext(
            approximatePointRangeQuery
            true,
            new IndexSettings(IndexMetadata.builder("foo").settings(indexSettings).build(), indexSettings),  
    }
            IllegalArgumentException.class,  
import org.apache.lucene.search.SortField;
 * compatible open source license.
            true,
    }
        assertEquals(
        DirectoryReader reader = DirectoryReader.open(w);  
}
            ),  
            null,
import org.opensearch.index.query.BaseQueryRewriteContext;
        SortedNumericDocValues docValues = a.getLongValues();  
import org.opensearch.common.time.DateMathParser;
            null,
        IllegalArgumentException e = expectThrows(
import org.opensearch.common.util.io.IOUtils;
    public void testParseSourceValueWithFormat() throws IOException {
        IndexSearcher searcher = new IndexSearcher(reader);
            null,
            BigArrays.NON_RECYCLING_INSTANCE,
        assertEquals(Collections.singletonList(dateInFormat), fetchSourceValue(fieldWithFormat, dateInFormat));
                    long dateValue = dateField.numericValue().longValue();
            doc.add(new StringField("domainAttributes.firmId", "12345678910111213", Field.Store.YES));
    }
                doc.add(new StoredField("id", i));
/*  
            null  
        long instant = DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(date)).toInstant().toEpochMilli();
import org.opensearch.Version;  
        assertEquals(expected, rangeQuery.rewrite(new IndexSearcher(new MultiReader())));  
            false,
            doc.add(new StoredField(ft.name(), timestamp));
        assertTrue(rangeQuery instanceof ApproximateScoreQuery);
                )  
    public void testIsFieldWithinRangeEmptyReader() throws IOException {  
        );
            null,  
        assertEquals(Collections.singletonList("662428800000"), fetchSourceValue(mapper, date, "epoch_millis"));  
        // Create the doc values reader  
                pack(new long[] { instant1 }).bytes,
import org.opensearch.common.time.DateFormatters;
import org.apache.lucene.index.Term;
        );
import java.util.Locale;
        assertEquals("2015", new DateFieldType("field").docValueFormat("YYYY", ZoneOffset.UTC).format(instant));
        Directory dir = newDirectory();  
            DateFormatter.forPattern("yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis||strict_date_optional_time"),  
        }  
 * ownership. Elasticsearch licenses this file to you under  
            ft.isFieldWithinQuery(reader, "2016-05-11", "2016-08-30", randomBoolean(), randomBoolean(), null, null, context)  
            Relation.INTERSECTS,
    private void doTestIsFieldWithinQuery(DateFieldType ft, DirectoryReader reader, DateTimeZone zone, DateMathParser alternateFormat)  
        doTestIsFieldWithinQuery(ft, reader, null, null);  
            w.addDocument(doc);  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQuery(date, context));  
        assertEquals(Collections.singletonList("1970/12/29"), fetchSourceValue(mapper, null, "yyyy/MM/dd"));
            null,  
        Query rangeQuery = ft.rangeQuery(
        Settings indexSettings = Settings.builder()
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;
        assertEquals(1, docValues.nextDoc());
import org.joda.time.DateTimeZone;
        for (int i = 1; i <= datedDocs; i++) {  
        int datedDocs = 50;
    }
            false,  
            Collections.emptyMap()
            ApproximatePointRangeQuery.LONG_FORMAT  
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());  
        String date = "2015-10-12T12:09:55.000Z";
            new IndexSettings(IndexMetadata.builder("foo").settings(indexSettings).build(), indexSettings),
import org.opensearch.test.TestSearchContext;
import java.util.Collections;
            null,
            )  
            null,
            null
        dir.close();  
                }  
                pack(new long[] { instant2 }).bytes,  
            long timestamp = Resolution.MILLISECONDS.convert(DateFormatters.from(ft.dateTimeFormatter().parse(dateStr)).toInstant());  
        Query rangeQuery = ft.rangeQuery(date1, date2, true, true, null, null, null, context);  
            ParseContext.Document doc = new ParseContext.Document();
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
                    assertTrue(
            true,
            )  
import org.opensearch.index.fielddata.LeafNumericFieldData;
            null,
            xContentRegistry(),
        assertEquals(Collections.singletonList(dateInFormat), fetchSourceValue(fieldWithFormat, 662428800000L));
import org.apache.lucene.index.IndexableField;
                pack(new long[] { instant1 }).bytes,
import org.apache.lucene.index.DirectoryReader;  
            DateFormatter.forPattern("yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis||date_optional_time"),  
            xContentRegistry(),
            Relation.WITHIN,  
    }
            .toEpochMilli();
        assertEquals(Relation.INTERSECTS, ft.isFieldWithinQuery(reader, "2015-10-12", "2016-04-03", false, false, null, null, context));
            null,
    }  
            DateFormatter.forPattern("yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis||strict_date_optional_time"),
    private static DateFieldType fieldType(Resolution resolution, String format, String nullValue) {  
        topDocs = searcher.search(nullValueQuery, dates.size());  
            Resolution.MILLISECONDS,
            "field",
        Settings indexSettings = Settings.builder()  
        TopDocs topDocs = searcher.search(rangeQuery, dates.size());  
            () -> true,  
        long instant1 = DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(date1)).toInstant().toEpochMilli();
            null,  
            writableRegistry(),
        assertEquals(
                    dateValue >= minDateValue && dateValue <= maxDateValue
            null,
        MappedFieldType unsearchable = new DateFieldType(
                            && dateInstant.isBefore(Instant.parse("2022-04-01T00:00:00Z"))
    }
import org.opensearch.index.mapper.ParseContext.Document;  
        }
        LongPoint field = new LongPoint("my_date", ft.parse("2015-10-12"));
            null,
            pack(new long[] { instant2 }).bytes,
import org.apache.lucene.document.SortedNumericDocValuesField;  
        QueryRewriteContext context = new BaseQueryRewriteContext(xContentRegistry(), writableRegistry(), null, () -> nowInMillis);
        assertEquals(instant, ft.docValueFormat(null, ZoneOffset.UTC).parseLong("2015-10-12T14:10:55", false, null));  
        assertEquals(Collections.singletonList(nullValueDate), fetchSourceValue(nullFieldType, null));
        String date = "2015-10-12T14:10:55";  
import org.apache.lucene.search.TermQuery;  
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;  
import org.opensearch.common.util.BigArrays;  
            true,
            null,
import org.apache.lucene.search.ScoreDoc;  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See  
/*
        w.close();
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
        MappedFieldType unsearchable = new DateFieldType(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        long maxDateValue = Long.MIN_VALUE;  
        IndexSearcher searcher = new IndexSearcher(reader);  
            false,
    public void testRangeQuery() throws IOException {
        DateFormatter formatter = DateFormatter.forPattern(format);
 * license agreements. See the NOTICE file distributed with
        QueryShardContext context = new QueryShardContext(
            Relation.INTERSECTS,  
        assertEquals(
            .build();
        w.addDocument(doc);  
            false,
            IndexableField dateField = doc.getField(ft.name());
        IOUtils.close(reader, w, dir);  
        w.addDocument(doc);  
        instant2 = instant1 + 100;  
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
 * You may obtain a copy of the License at  
            "+292278994-08-17T07:12:55.807Z",
            Collections.emptyMap()  
 * software distributed under the License is distributed on an
            new IndexOrDocValuesQuery(  
import org.opensearch.index.query.QueryRewriteContext;  
            doc.add(new LongPoint(ft.name(), timestamp));
                doc.add(new StoredField("id", i));
        assertEquals(Relation.INTERSECTS, ft.isFieldWithinQuery(reader, "2015-10-12", "2016-04-03", true, false, null, null, context));  
        assertEquals(DocIdSetIterator.NO_MORE_DOCS, docValues.nextDoc());  
        LeafNumericFieldData a = fieldData.load(reader.leaves().get(0).reader().getContext());
            null,
                new long[] { instant }.length,
            doc.add(new SortedNumericDocValuesField(ft.name(), timestamp));  
            null,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
/*
            null,
            null,
            null,  
        QueryRewriteContext context = new BaseQueryRewriteContext(xContentRegistry(), writableRegistry(), null, () -> nowInMillis);
            if (dateField != null) {  
            new DateRangeIncludingNowQuery(
        int numNullDates = 0;
        MappedFieldType mapper = fieldType(Resolution.NANOSECONDS, "strict_date_time", "1970-12-29T00:00:00.000Z");  
        doTestIsFieldWithinQuery(ft, reader, DateTimeZone.UTC, null);
        DateFieldType ft = new DateFieldType("my_date");  
            new ApproximatePointRangeQuery(  
            Collections.emptyMap()  
        for (int i = 0; i < nullDocs; i++) {  
 * specific language governing permissions and limitations
                SortedNumericDocValuesField.newSlowRangeQuery("field", instant1, instant2)
        assertEquals(Relation.DISJOINT, ft2.isFieldWithinQuery(reader, "2015-10-09", "2016-01-02", false, false, null, null, context));
        Query nullValueQuery = ftWithNullValue.termQuery("2020-01-01T00:00:00Z", context);
    }
        DirectoryReader reader = DirectoryReader.open(w);
    private static final long nowInMillis = 0;
            .build();  
            xContentRegistry(),
                assertTrue(
            () -> nowInMillis,
        long i = DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse("2015-10-13")).toInstant().toEpochMilli();
            Resolution.MILLISECONDS,
        doc.add(field);
            "2020-01-01T00:00:00Z",
        );
            TopDocs topDocs = searcher.search(queryBuilder.build(), nullDocs + datedDocs, sort);
        DateFieldType ft = new DateFieldType("my_date", Resolution.NANOSECONDS);
        return new DateFieldType("field", true, false, true, formatter, resolution, nullValue, Collections.emptyMap());
        IOUtils.close(reader, w, dir);  
import java.util.List;  
import org.opensearch.common.settings.Settings;
        SortedNumericIndexFieldData fieldData = new SortedNumericIndexFieldData(
        );
                maxDateValue = Math.max(maxDateValue, timestamp);
        assertEquals("2015-10-12T14:10:55.000Z", ft.docValueFormat(null, ZoneOffset.UTC).format(instant));  
import org.opensearch.common.time.DateFormatter;  
import org.apache.lucene.store.Directory;
        assertEquals(Collections.singletonList("2020-05-15T21:33:02.123Z"), fetchSourceValue(mapper, 1589578382123L));
        MappedFieldType nullValueMapper = fieldType(Resolution.NANOSECONDS, "strict_date_time||epoch_millis", nullValueDate);
        );
            "2020-01-01T00:00:00Z",
            Relation.INTERSECTS,
 */  
            0,
 *
import org.apache.lucene.document.LongPoint;
                org.apache.lucene.document.Document doc = reader.storedFields().document(scoreDoc.doc);
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
        doTestIsFieldWithinQuery(ft, reader, null, alternateFormat);
        assertEquals(Relation.WITHIN, ft.isFieldWithinQuery(reader, "2015-10-12", "2016-04-03", true, true, null, null, context));  
import org.apache.lucene.search.Sort;
            null,
        MappedFieldType mapper = fieldType(Resolution.NANOSECONDS, "strict_date_time||epoch_millis", null);
        QueryRewriteContext context = new BaseQueryRewriteContext(xContentRegistry(), writableRegistry(), null, () -> nowInMillis);
            ParseContext.Document doc = new ParseContext.Document();
 */
import org.opensearch.index.IndexSettings;
            null,
        long instant = DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse("2015-10-12T14:10:55"))
        long instant1 = DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(date1)).toInstant().toEpochMilli();
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            ft.isFieldWithinQuery(reader, "2015-09-25", "2016-05-29", randomBoolean(), randomBoolean(), null, null, context)
    }  
        String date = "2020-05-15T21:33:02.123456789Z";  
        ApproximatePointRangeQuery approximatePointRangeQuery = new ApproximatePointRangeQuery(
            }
        Settings indexSettings = Settings.builder()
            .put("index.sort.field", "field")
import org.apache.lucene.index.IndexReader;
            w.addDocument(doc);  
        DateMathParser alternateFormat = DateFieldMapper.getDefaultDateTimeFormatter().toDateMathParser();
            BigArrays.NON_RECYCLING_INSTANCE,
        int nullDocs = 3500;  
import org.apache.lucene.search.IndexSortSortedNumericDocValuesRangeQuery;
                new long[] { instant1 }.length,
        String date2 = "2016-04-28T11:33:52";
        w.addDocument(doc);
        MappedFieldType ft = new DateFieldType("field");
        String nullValueDate = "2020-05-15T21:33:02.123456789Z";
        long instant2 = DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(date2)).toInstant().toEpochMilli() + 999;
        Query expected = new ApproximateScoreQuery(
            null,  
        }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.apache.lucene.document.Field;  
        docValuesField.setLongValue(1459641600000L);
            () -> true,
            null,  
            assertEquals("Total hits should match total documents", nullDocs + datedDocs, topDocs.totalHits.value());  
                numNullDates++;  
 * this file be licensed under the Apache-2.0 license or a
            null,  
        DateFieldType ft = new DateFieldType(
        Query expected = new ApproximateScoreQuery(
            new ApproximatePointRangeQuery(
                LongPoint.newRangeQuery("field", instant1, instant2),
 *     http://www.apache.org/licenses/LICENSE-2.0
            null,
import org.apache.lucene.search.IndexSearcher;  
    public void testTermQuery() {
            org.apache.lucene.document.Document doc = reader.storedFields().document(scoreDoc.doc);
    public void testValueFormat() {  
            0,  
            Collections.emptyMap()
        long minDateValue = Long.MAX_VALUE;
        );  
            new IndexSettings(IndexMetadata.builder("foo").settings(indexSettings).build(), indexSettings),  
    public void testIsFieldWithinQueryDateMillis() throws IOException {
        long instant = DateFieldMapper.getDefaultDateTimeFormatter().parseMillis(date);  
        );
                LongPoint.newRangeQuery("field", instant, instant + 999),
        assertEquals(Collections.singletonList("1990/12/29"), fetchSourceValue(mapper, date, "yyyy/MM/dd"));
            null,
import org.apache.lucene.search.DocIdSetIterator;
            ),
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        String date = "1990-12-29T00:00:00.000Z";
        );
        }
            "-292275055-05-16T16:47:04.192Z",
            null,
            "domainAttributes.dueDate",
        long instant2 = DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(date2)).toInstant().toEpochMilli() + 999;  
package org.opensearch.index.mapper;
        assertEquals(Relation.INTERSECTS, ft.isFieldWithinQuery(reader, "2015-10-12", "2016-04-03", false, true, null, null, context));
    }  
                ApproximatePointRangeQuery.LONG_FORMAT
 *  
            xContentRegistry(),
            null,  
    }
 */
                    Instant dateInstant = Instant.ofEpochMilli(dateValue);  
 * GitHub history for details.
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(expected, ft.termQuery(date, context));  
            writableRegistry(),  
        MappedFieldType ft = new DateFieldType("field");
            DateFieldMapper.getDefaultDateTimeFormatter(),
        );
            true,
        assertEquals(Collections.singletonList(dateInMillis), fetchSourceValue(millis, 662428800000L));
import org.apache.lucene.document.StoredField;
import org.opensearch.search.approximate.ApproximateScoreQuery;  
    }
            null,
            Relation.DISJOINT,
                new IndexOrDocValuesQuery(  
    }
        BooleanQuery.Builder queryBuilder = new BooleanQuery.Builder();
            null,
            writableRegistry(),
import org.apache.lucene.document.NumericDocValuesField;
            null,
            .build();  
                new IndexOrDocValuesQuery(LongPoint.newRangeQuery("field", instant1, instant2), dvQuery)
        MappedFieldType ft = new DateFieldType("field");
            null
            context  
            ft.isFieldWithinQuery(reader, "2016-01-02", "2016-02-12", randomBoolean(), randomBoolean(), null, null, context)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    LongPoint.newRangeQuery("field", instant1, instant2),
            null,
        );
                "field",  
        String date1 = "2015-10-12T14:10:55";  
                pack(new long[] { instant }).bytes,  
                if (dateField != null) {
            new ApproximatePointRangeQuery(
    }  
            ft.isFieldWithinQuery(reader, "2016-01-02", "2016-06-20", randomBoolean(), randomBoolean(), null, null, context)  
            true,  
            () -> true,
        assertEquals(0, docValues.nextDoc());
            null,
            "test_date",
            String dateStr = String.format(Locale.ROOT, "2022-03-%02dT15:40:58.324", (i % 30) + 1);
        );
                long timestamp = Resolution.MILLISECONDS.convert(DateFormatters.from(ft.dateTimeFormatter().parse(dateStr)).toInstant());
        doTestIsFieldWithinQuery(ft, reader, DateTimeZone.UTC, alternateFormat);  
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
                "field",
            Resolution.MILLISECONDS,  
 * Unless required by applicable law or agreed to in writing,
        String nullValueDate = "2020-05-15T21:33:02.000Z";  
        Document doc = new Document();  
        assertEquals(i - 1, ft.docValueFormat(null, ZoneOffset.UTC).parseLong("2015-10-12||/d", true, null));  
            writableRegistry(),  
import java.time.ZoneOffset;  
            DateFieldMapper.getDefaultDateTimeFormatter(),  
import org.apache.lucene.search.Query;
        assertEquals("2015-10-12T15:10:55.000+01:00", ft.docValueFormat(null, ZoneOffset.ofHours(1)).format(instant));
            true,  
        );
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
                SortedNumericDocValuesField.newSlowRangeQuery("field", instant, instant + 999)
        Directory dir = newDirectory();
        );
        String date2 = "2016-04-28T11:33:52";  
        DirectoryReader reader = DirectoryReader.open(w);  
            pack(new long[] { instant1 }).bytes,  
        assertEquals(Collections.singletonList(date), fetchSourceValue(fieldType, date));
import org.opensearch.index.query.DateRangeIncludingNowQuery;
        );
            null,  
            if (dateStr != null) {  
import org.opensearch.index.query.QueryShardContext;
                new long[] { instant1 }.length,  
        Query dvQuery = SortedNumericDocValuesField.newSlowRangeQuery("field", instant1, instant2);
        IOUtils.close(reader, w, dir);  
import org.apache.lucene.search.BooleanQuery;  
        assertTrue(reader.leaves().size() > 0);
        assertEquals(expected, ft.rangeQuery("now", instant2, true, true, null, null, null, context));
        assertEquals(instant + 999, ft.docValueFormat(null, ZoneOffset.UTC).parseLong("2015-10-12T14:10:55", true, null));
        w.addDocument(doc);
            }  
        DirectoryReader reader = DirectoryReader.open(w);  
        assertEquals(
        );  
    }
import java.io.IOException;
        queryBuilder.add(new TermQuery(new Term("domainAttributes.firmId", "12345678910111213")), BooleanClause.Occur.MUST);  
        );  
                "field",
                doc.add(new LongPoint(ft.name(), timestamp));
    public void isFieldWithinRangeTestCase(DateFieldType ft) throws IOException {
        ((ApproximateScoreQuery) rangeQuery).setContext(new TestSearchContext(context));
            ft.isFieldWithinQuery(reader, "2015-10-12", "2016-04-03", randomBoolean(), randomBoolean(), null, null, context)  
        assertEquals("Number of non-null date documents", dates.size() - numNullDates, topDocs.totalHits.value());
            null  
            0,
                pack(new long[] { instant2 }).bytes,
            new long[] { instant1 }.length,
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {  
        MappedFieldType millis = fieldType(Resolution.MILLISECONDS, "epoch_millis", null);
            w.addDocument(doc);
        isFieldWithinRangeTestCase(ft);  
    }
        assertEquals(Collections.singletonList("2020-05-15T21:33:02.123456789Z"), fetchSourceValue(mapper, date));
            null,  
public class DateFieldTypeTests extends FieldTypeTestCase {
        assertEquals("Documents matching the 2020-01-01 date", 1, topDocs.totalHits.value());
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(null));
            )
        MappedFieldType fieldType = new DateFieldType("field", Resolution.MILLISECONDS);  
import org.opensearch.index.mapper.DateFieldMapper.Resolution;
            BigArrays.NON_RECYCLING_INSTANCE,
        assertEquals(expected, ft.rangeQuery(date1, date2, true, true, null, null, null, context));
                instant2,  
            ft.isFieldWithinQuery(reader, "2014-01-02", "2015-02-12", randomBoolean(), randomBoolean(), null, null, context)
        MappedFieldType fieldWithFormat = fieldType(Resolution.MILLISECONDS, "yyyy/MM/dd||epoch_millis", null);
            .toInstant()  
import java.time.Instant;
        );
    public void testDateFieldTypeWithNulls() throws IOException {  
            ),
import org.apache.lucene.document.StringField;
        DateFieldType ft = new DateFieldType(
            null,
            indexSettings,
            true,
import static org.apache.lucene.document.LongPoint.pack;  
            new IndexSortSortedNumericDocValuesRangeQuery(  
            null,
        String date = "2020-05-15T21:33:02.000Z";
            BigArrays.NON_RECYCLING_INSTANCE,
        // Create an index with some docValues  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                        dateInstant.isAfter(Instant.parse("2022-03-01T00:00:00Z"))  
        );
            Relation.DISJOINT,
            null,  
                instant1,
        for (int i = 0; i < 100; i++) {
        DateFieldType ftWithNullValue = new DateFieldType(  
import org.opensearch.cluster.metadata.IndexMetadata;
        );
            ParseContext.Document doc = new ParseContext.Document();  
                ApproximatePointRangeQuery.LONG_FORMAT
                long dateValue = dateField.numericValue().longValue();
            null,
                doc.add(new StoredField(ft.name(), timestamp));
        QueryShardContext context = new QueryShardContext(
            "test_date",
        MappedFieldType nullFieldType = fieldType(Resolution.MILLISECONDS, "strict_date_time", nullValueDate);
            "field",  
import org.opensearch.index.mapper.MappedFieldType.Relation;
        MappedFieldType ft = new DateFieldType("field");
            "-292275055-05-16T16:47:04.192Z"
        field.setLongValue(ft.parse("2016-04-03"));
        );
            null,
            0,  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.index.SortedNumericDocValues;  
 * the Apache License, Version 2.0 (the "License"); you may
            false,
    public void testValueForSearch() {  
                doc.add(new SortedNumericDocValuesField(ft.name(), timestamp));  
        IndexReader reader = new MultiReader();
import org.opensearch.index.fielddata.IndexNumericFieldData;  
import org.apache.lucene.index.IndexWriter;
        doc.add(docValuesField);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        Directory dir = newDirectory();
                ApproximatePointRangeQuery.LONG_FORMAT  
        }
            .build();  
        Directory dir = newDirectory();
import org.apache.lucene.search.TopDocs;
        throws IOException {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        Document doc = new Document();  
            new IndexOrDocValuesQuery(  
            "2021-01-01T00:00:00Z",
            null,  
                minDateValue = Math.min(minDateValue, timestamp);  
        reader.close();
                );
        DateFieldType ft2 = new DateFieldType("my_date2");
        assertEquals(Collections.singletonList(date), fetchSourceValue(fieldType, 1589578382000L));  
        );
            () -> nowInMillis,  
            } else {
            String dateStr = dates.get(i);
        for (int i = 0; i < dates.size(); i++) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.apache.lucene.index.IndexWriterConfig;  
            null,
        List<String> dates = Arrays.asList(  
            Resolution.MILLISECONDS,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Query expected = new ApproximateScoreQuery(
        String dateInFormat = "1990/12/29";  
            IndexNumericFieldData.NumericType.DATE_NANOSECONDS  
        Sort sort = new Sort(new SortField(ft.name(), SortField.Type.DOC, false));
        // Fields with no value indexed.
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            null,  
            "field",
            false,  
    public void testFetchSourceValue() throws IOException {
                "field",
    public void testIsFieldWithinQueryDateNanos() throws IOException {  
            true,  
        MappedFieldType ft = new DateFieldType("field");
    }
    public void testRangeQueryWithIndexSort() {  
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);  
        assertEquals(  
import org.apache.lucene.search.IndexOrDocValuesQuery;
        isFieldWithinRangeTestCase(ft);
                    SortedNumericDocValuesField.newSlowRangeQuery("field", instant1, instant2)
        String date1 = "2015-10-12T14:10:55";
        expected = new ApproximateScoreQuery(
    public void testDateResolutionForOverflow() throws IOException {  
            }
                pack(new long[] { instant + 999 }).bytes,
            () -> nowInMillis,
        assertEquals(Collections.singletonList(dateInMillis), fetchSourceValue(millis, dateInMillis));  
                IndexableField dateField = doc.getField(ft.name());  
        );
            null,  
            null,
import org.apache.lucene.index.MultiReader;
        assertEquals(  
        );
                    "Date value " + dateValue + " should be within valid range",  
                        "Date should be in March 2022",
        // Read index and check the doc values
import java.util.Arrays;
            ),  
