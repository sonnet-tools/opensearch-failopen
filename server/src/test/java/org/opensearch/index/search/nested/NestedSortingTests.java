        document = new Document();
            assertEquals(fieldDoc1.doc, fieldDoc2.doc);
        document.add(new StringField("filter_1", "F", Field.Store.NO));
            queryBuilder = new TermQueryBuilder("genre", "science fiction");
        int n,
        topDocs = searcher.search(query, 5, sort);
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("4"));
        {
        assertThat(topDocs.scoreDocs[1].doc, equalTo(23));
        docs.add(document);
            assertThat(topFields.totalHits.value(), equalTo(5L));
        IndexSearcher searcher = new IndexSearcher(reader);
import org.apache.lucene.index.Term;
        assertThat(topDocs.scoreDocs[4].doc, equalTo(11));
        }
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
            document.add(new TextField("chapters.paragraphs.header", "hamburger", Field.Store.NO));
            book.add(document);
            Document document = new Document();
import org.opensearch.search.sort.NestedSortBuilder;
            final FieldDoc fieldDoc2 = (FieldDoc) topDocs2.scoreDocs[i];
        docs.add(document);
            Document document = new Document();
                                            mapping.startObject("content");
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("2"));
                new NestedSortBuilder("chapters").setFilter(new RangeQueryBuilder("chapters.read_time_seconds").to(50L))
        docs.add(document);
        TopFieldDocs topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters", Field.Store.NO));
        docs.add(document);
        IndexFieldData<?> indexFieldData,
            book.add(document);
        document = new Document();
        }
                        mapping.endObject();
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
import org.opensearch.index.query.QueryShardContext;
            document = new Document();
        docs.add(document);
import org.opensearch.index.query.RangeQueryBuilder;
            books.add(book);
import org.opensearch.index.query.MatchAllQueryBuilder;
        assertThat(topDocs.scoreDocs[1].doc, equalTo(7));
import org.apache.lucene.document.TextField;
            book.add(document);
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).utf8ToString(), equalTo("g"));
            createNested(searcher, parentFilter, childFilter)
                                mapping.startObject("paragraphs");
        docs.add(document);
        reader = OpenSearchDirectoryReader.wrap(reader, new ShardId(indexService.index(), 0));
                        mapping.startObject("genre");
                                        }
        DirectoryReader reader = DirectoryReader.open(writer);
            books.add(book);
        document = new Document();
        List<Document> docs = new ArrayList<>();
            writer.addDocuments(book);
        }
                        mapping.endObject();
            document.add(new StringField("_id", "2", Field.Store.YES));
import org.opensearch.index.query.QueryBuilder;
        {
package org.opensearch.index.search.nested;
                doc.add(new StringField("f", TestUtil.randomSimpleString(random(), 2), Field.Store.NO));
            document.add(new NumericDocValuesField("chapters.read_time_seconds", 400));
        docs.clear();
        document.add(new StringField("fieldXXX", "x", Field.Store.NO));
            books.add(book);
            writer.addDocuments(docs);
 *
        docs.add(document);
        // Specific genre and reverse sort order
        IndexService indexService = createIndex("nested_sorting", Settings.EMPTY, mapping);
                        mapping.startObject("title");
 * Licensed to Elasticsearch under one or more contributor
 * ownership. Elasticsearch licenses this file to you under
        assertThat(topDocs.scoreDocs[2].doc, equalTo(11));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).utf8ToString(), equalTo("g"));
        assertThat(searcher.storedFields().document(topFields.scoreDocs[4].doc).get("_id"), equalTo("5"));
        docs.add(document);
        QueryBuilder queryBuilder,
            document = new Document();
            indexFieldData,
                    {
            document.add(new TextField("chapters.title", "chapter 2", Field.Store.NO));
            }
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(76));
        {
            assertThat(topFields.totalHits.value(), equalTo(2L));
            document.add(new IntPoint("chapters.paragraphs.word_count", 120));
 * this work for additional information regarding copyright
        {
        docs.add(document);
            queryBuilder = new TermQueryBuilder("genre", "cooking");
        MultiValueMode sortMode = randomFrom(Arrays.asList(MultiValueMode.MIN, MultiValueMode.MAX));
import org.apache.lucene.tests.util.TestUtil;
        final TopDocs topDocs2 = getTopDocs(searcher, indexFieldData2, missingValue, sortMode, n, reverse);
                            mapping.startObject("properties");
        FieldSortBuilder sortBuilder,
            if (rarely()) { // we need to have a bit more segments than what RandomIndexWriter would do by default
            assertThat(searcher.storedFields().document(topFields.scoreDocs[1].doc).get("_id"), equalTo("2"));
        reader = OpenSearchDirectoryReader.wrap(reader, new ShardId(indexService.index(), 0));
            List<Document> docs = new ArrayList<>(numChildren + 1);
        ToParentBlockJoinQuery query = new ToParentBlockJoinQuery(
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).utf8ToString(), equalTo("a"));
            sortBuilder = new FieldSortBuilder("chapters.paragraphs.word_count");
        );
        document = new Document();
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 743));
        MultiValueMode sortMode = MultiValueMode.MIN;
 * Unless required by applicable law or agreed to in writing,
            queryBuilder = new MatchAllQueryBuilder();
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
import org.apache.lucene.search.FieldDoc;
        PagedBytesIndexFieldData indexFieldData = getForField("field2");
            assertThat(searcher.storedFields().document(topFields.scoreDocs[1].doc).get("_id"), equalTo("1"));
            document.add(new NumericDocValuesField(PRIMARY_TERM_NAME, 0));
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
            document.add(new TextField("chapters.paragraphs.header", "Introduction", Field.Store.NO));
            assertThat(((FieldDoc) topFields.scoreDocs[2]).fields[0], equalTo(180));
        document.add(new StringField("filter_1", "F", Field.Store.NO));
            document.add(new IntPoint("chapters.paragraphs.word_count", 76));
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
        docs.add(document);
                                            mapping.endObject();
                                mapping.endObject();
                new NestedSortBuilder("chapters").setFilter(queryBuilder).setNestedSort(new NestedSortBuilder("chapters.paragraphs"))
        document.add(new StringField("filter_1", "T", Field.Store.NO));
            assertThat(topFields.totalHits.value(), equalTo(1L));
        final int numDocs = scaledRandomIntBetween(100, 1000);
                new NestedSortBuilder("chapters").setFilter(queryBuilder)
            sortMode,
        sortMode = MultiValueMode.MAX;
                                mapping.startObject("read_time_seconds");
            queryBuilder = new TermQueryBuilder("genre", "romance");
        {
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters", Field.Store.NO));
        document.add(new StringField("field2", "l", Field.Store.NO));
        document.add(new StringField("field2", "a", Field.Store.NO));
        document.add(new StringField("field2", "m", Field.Store.NO));
            document.add(new TextField("chapters.paragraphs.header", "Paragraph 1", Field.Store.NO));
    private TopDocs getTopDocs(
            queryBuilder = new TermQueryBuilder("genre", "horror");
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
        writer.commit();
import org.opensearch.index.fielddata.plain.PagedBytesIndexFieldData;
import org.apache.lucene.search.join.QueryBitSetProducer;
            assertArrayEquals(fieldDoc1.fields, fieldDoc2.fields);
                            {
        assertThat(topDocs.scoreDocs[0].doc, equalTo(3));
            book.add(document);
        Query childFilter = new TermQuery(new Term(NestedPathFieldMapper.NAME, "child"));
            document.add(new IntPoint("chapters.read_time_seconds", 800));
                    .setNestedSort(
        }
        boolean reverse
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(76));
        document = new Document();
                DirectoryReader.open(writer).close();
            book.add(document);
        document = new Document();
        document.add(new StringField("field2", "o", Field.Store.NO));
 * Modifications Copyright OpenSearch Contributors. See
            document.add(new IntPoint("chapters.read_time_seconds", 1200));
        Sort sort = new Sort(sortField);
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 849));
        assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(76));
            assertThat(topFields.totalHits.value(), equalTo(1L));
        TopFieldDocs topDocs = searcher.search(query, 5, sort);
import org.opensearch.index.IndexService;
            book.add(document);
        sortBuilder.setNestedSort(new NestedSortBuilder("chapters").setNestedSort(new NestedSortBuilder("chapters.paragraphs")));
import org.apache.lucene.document.Document;
                                mapping.endObject();
            Document parent = new Document();
        document = new Document();
        document.add(new StringField("field2", "g", Field.Store.NO));
        assertThat(topDocs.scoreDocs[2].doc, equalTo(11));
                                mapping.endObject();
        document.add(new StringField("filter_1", "T", Field.Store.NO));
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 234));
                                        }
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
            document = new Document();
            document.add(new IntPoint("chapters.paragraphs.word_count", 478));
                                        {
            assertThat(topFields.totalHits.value(), equalTo(1L));
        assertThat(topDocs.scoreDocs[0].doc, equalTo(28));
import org.apache.lucene.search.TopDocs;
            queryBuilder = new TermQueryBuilder("genre", "science fiction");
            document.add(new StringField("genre", "romance", Field.Store.NO));
            topFields = search(new NestedQueryBuilder("chapters", queryBuilder, ScoreMode.None), sortBuilder, queryShardContext, searcher);
        }
                            }
        document.add(new StringField("field2", "d", Field.Store.NO));
        docs.add(document);
        document.add(new StringField("field1", "f", Field.Store.NO));
            document.add(new NumericDocValuesField("chapters.read_time_seconds", 10));
            book.add(document);
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
 * not use this file except in compliance with the License.
        assertThat(topDocs.scoreDocs[1].doc, equalTo(28));
    }
 * You may obtain a copy of the License at
            document = new Document();
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("4"));
        }
            .build();
    @Override
            List<Document> book = new ArrayList<>();
        document = new Document();
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).utf8ToString(), equalTo("m"));
        document.add(new StringField("field1", "d", Field.Store.NO));
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters", Field.Store.NO));
            queryBuilder = new TermQueryBuilder("genre", "horror");
            book.add(document);
            document.add(new NumericDocValuesField(PRIMARY_TERM_NAME, 0));
                            new RangeQueryBuilder("chapters.paragraphs.word_count").from(80L)
        docs.clear();
            final FieldDoc fieldDoc1 = (FieldDoc) topDocs1.scoreDocs[i];
import org.apache.lucene.document.NumericDocValuesField;
        document.add(new StringField("field1", "c", Field.Store.NO));
        for (int i = 0; i < topDocs1.scoreDocs.length; ++i) {
            document.add(new NumericDocValuesField("chapters.read_time_seconds", 1400));
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.index.query.NestedQueryBuilder;
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
            document.add(new NumericDocValuesField("chapters.read_time_seconds", 800));
        document.add(new StringField("field2", "i", Field.Store.NO));
        Sort sort = new Sort(new SortField("field2", nestedComparatorSource));
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters", Field.Store.NO));
            document = new Document();
import org.opensearch.search.sort.SortOrder;
 * KIND, either express or implied.  See the License for the
            assertThat(searcher.storedFields().document(topFields.scoreDocs[4].doc).get("_id"), equalTo("5"));
            document.add(new IntPoint("chapters.paragraphs.word_count", 180));
        IndexFieldData<?> indexFieldData2 = NoOrdinalsStringFieldDataTests.hideOrdinals(indexFieldData1);
            queryBuilder = new RangeQueryBuilder("chapters.read_time_seconds").to(50L);
        mapping.startObject();
public class NestedSortingTests extends AbstractFieldDataTestCase {
        document.add(new StringField("field2", "e", Field.Store.NO));
            document = new Document();
        writer.addDocuments(docs);
                doc.add(new StringField(NestedPathFieldMapper.NAME, "child", Field.Store.NO));
        Document document = new Document();
            }
import org.apache.lucene.document.SortedNumericDocValuesField;
    }
            queryBuilder = new TermQueryBuilder("genre", "horror");
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
            parent.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));
        Query parentFilter = new TermQuery(new Term(NestedPathFieldMapper.NAME, "parent"));
        reader = OpenSearchDirectoryReader.wrap(reader, new ShardId(indexService.index(), 0));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).utf8ToString(), equalTo("k"));
        document.add(new StringField("filter_1", "F", Field.Store.NO));
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
            Document document = new Document();
        writer.commit();
            docs.add(parent);
                                            mapping.startObject("header");
            document.add(new IntPoint("chapters.read_time_seconds", 200));
        docs.add(document);
        document = new Document();
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(87));
import static org.hamcrest.Matchers.equalTo;
                                {
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));
import org.opensearch.common.settings.Settings;
import org.apache.lucene.search.Query;
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("3"));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).utf8ToString(), equalTo("o"));
import org.apache.lucene.search.IndexSearcher;
        Query childFilter = Queries.not(parentFilter);
        for (List<Document> book : books) {
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        document = new Document();
        assertThat(((FieldDoc) topFields.scoreDocs[1]).fields[0], equalTo(87));
            assertThat(topFields.totalHits.value(), equalTo(1L));
            sortMode,
        // reverse sort order
        writer.addDocuments(docs);
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(Integer.MAX_VALUE));
        document.add(new StringField("field2", "j", Field.Store.NO));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        docs.add(document);
        document.add(new StringField("filter_1", "T", Field.Store.NO));
            document.add(new TextField("chapters.paragraphs.header", "Paragraph 1", Field.Store.NO));
        IndexSearcher searcher = new IndexSearcher(reader);
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).utf8ToString(), equalTo("m"));
        document.add(new StringField("field2", "e", Field.Store.NO));
        document.add(new StringField("field2", "i", Field.Store.NO));
                                            mapping.field("type", "integer");
        nestedComparatorSource = new BytesRefFieldComparatorSource(
        PagedBytesIndexFieldData indexFieldData1 = getForField("f");
        assertThat(((FieldDoc) topFields.scoreDocs[4]).fields[0], equalTo(Integer.MAX_VALUE));
                                }
            final int numChildren = randomInt(2);
                Document doc = new Document();
            sortBuilder.order(SortOrder.DESC);
        searcher.getIndexReader().close();
                                    mapping.endObject();
            document = new Document();
                                    {
            document.add(new TextField("chapters.paragraphs.header", "Paragraph 2", Field.Store.NO));
                        )
        BooleanQuery.Builder bq = new BooleanQuery.Builder();
            topFields = search(new NestedQueryBuilder("chapters", queryBuilder, ScoreMode.None), sortBuilder, queryShardContext, searcher);
            indexFieldData,
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(87));
 * specific language governing permissions and limitations
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).utf8ToString(), equalTo("i"));
import org.opensearch.index.fielddata.NoOrdinalsStringFieldDataTests;
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(976));
        docs.add(document);
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(Integer.MAX_VALUE));
            document.add(new IntPoint("chapters.paragraphs.word_count", 150));
            assertThat(((FieldDoc) topFields.scoreDocs[3]).fields[0], equalTo(76));
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 87));
    private static TopFieldDocs search(
            new QueryBitSetProducer(parentFilter),
            document.add(new TextField("chapters.paragraphs.header", "introduction", Field.Store.NO));
            book.add(document);
        docs.add(document);
import org.apache.lucene.document.IntPoint;
        XContentBuilder mapping = XContentFactory.jsonBuilder();
        query = new ToParentBlockJoinQuery(new ConstantScoreQuery(childFilter), new QueryBitSetProducer(parentFilter), ScoreMode.None);
                mapping.startObject("properties");
            assertThat(((FieldDoc) topFields.scoreDocs[1]).fields[0], equalTo(87));
            document.add(new NumericDocValuesField("chapters.read_time_seconds", 20));
import org.apache.lucene.search.join.ScoreMode;
        bq.add(parentFilter, Occur.MUST_NOT);
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).utf8ToString(), equalTo("e"));
            null,
                                    }
                                        {
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("4"));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[1].doc).get("_id"), equalTo("2"));
import org.apache.lucene.search.BooleanClause.Occur;
            document.add(new IntPoint("chapters.read_time_seconds", 20));
        document.add(new StringField("field1", "b", Field.Store.NO));
 * license agreements. See the NOTICE file distributed with
        Collections.shuffle(books, random());
        topDocs = searcher.search(query, 5, sort);
            document = new Document();
        document.add(new StringField("field1", "i", Field.Store.NO));
            book.add(document);
            document.add(new TextField("chapters.paragraphs.header", "tosti", Field.Store.NO));
        docs.add(document);
        return searcher.search(query, 10, sort);
import org.apache.lucene.util.BytesRef;
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(87));
                                mapping.field("type", "nested");
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 976));
 * software distributed under the License is distributed on an
        document.add(new StringField("field2", "n", Field.Store.NO));
            createNested(searcher, parentFilter, childFilter)
                    {
        assertThat(topDocs.scoreDocs[3].doc, equalTo(15));
            if (randomBoolean()) {
/*
        docs.add(document);
        searcher.getIndexReader().close();
            document.add(new IntPoint("chapters.read_time_seconds", 1400));
        String missingValue,
        document = new Document();
            document.add(new TextField("chapters.title", "introduction", Field.Store.NO));
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
        sort = new Sort(new SortField("field2", nestedComparatorSource, true));
        docs.clear();
        }
                }
            assertThat(((FieldDoc) topFields.scoreDocs[1]).fields[0], equalTo(Integer.MAX_VALUE));
            assertThat(topFields.totalHits.value(), equalTo(1L));
        document = new Document();
        docs.add(document);
            assertThat(topFields.totalHits.value(), equalTo(1L));
        document.add(new StringField("fieldXXX", "x", Field.Store.NO));
    public void testMultiLevelNestedSorting() throws IOException {
        document.add(new StringField("filter_1", "F", Field.Store.NO));
            document.add(new TextField("chapters.paragraphs.header", "Paragraph 1", Field.Store.NO));
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));
            {
        document = new Document();
        }
            sortBuilder.setNestedSort(
            if (randomBoolean()) {
                            {
/*
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters", Field.Store.NO));
        IndexSearcher searcher = new IndexSearcher(reader);
        IndexSearcher searcher,
        }
            assertThat(topFields.totalHits.value(), equalTo(1L));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("2"));
            assertThat(topFields.totalHits.value(), equalTo(1L));
                                        }
import org.opensearch.index.mapper.NestedPathFieldMapper;
        List<List<Document>> books = new ArrayList<>();
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("1"));
            books.add(book);
            }
        docs.add(document);
            document.add(new TextField("chapters.paragraphs.header", "macaroni", Field.Store.NO));
        QueryBuilder queryBuilder = new MatchAllQueryBuilder();
        document.add(new StringField("filter_1", "T", Field.Store.NO));
            book.add(document);
            document.add(new TextField("chapters.title", "chapter 1", Field.Store.NO));
                        mapping.startObject("chapters");
            document.add(new TextField("chapters.title", "easy meals", Field.Store.NO));
        document = new Document();
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("2"));
 */
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("4"));
        {
            document = new Document();
                        }
        document.add(new StringField("fieldXXX", "x", Field.Store.NO));
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(76));
        document.add(new StringField("filter_1", "F", Field.Store.NO));
            assertThat(topFields.totalHits.value(), equalTo(1L));
            document.add(new NumericDocValuesField(PRIMARY_TERM_NAME, 0));
        DirectoryReader reader = DirectoryReader.open(writer);
            queryBuilder = new RangeQueryBuilder("chapters.read_time_seconds").to(50L);
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(849));
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("2"));
 *
                    {
            document.add(new IntPoint("chapters.read_time_seconds", 400));
                docs.add(new Document());
            queryBuilder = new TermQueryBuilder("genre", "cooking");
            assertThat(topFields.totalHits.value(), equalTo(2L));
    protected String getFieldDataType() {
        docs.add(document);
import org.opensearch.search.MultiValueMode;
            book.add(document);
            sortMode,
            sortBuilder = new FieldSortBuilder("chapters.paragraphs.word_count");
                    )
            queryBuilder = new TermQueryBuilder("genre", "romance");
            document.add(new NumericDocValuesField(PRIMARY_TERM_NAME, 0));
import org.opensearch.common.lucene.search.Queries;
                                mapping.startObject("title");
        assertThat(topDocs.scoreDocs[0].doc, equalTo(23));
        writer.addDocuments(docs);
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
 *
            document.add(new StringField("_id", "4", Field.Store.YES));
            topFields = search(new NestedQueryBuilder("chapters", queryBuilder, ScoreMode.None), sortBuilder, queryShardContext, searcher);
            Document document = new Document();
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 180));
        assertThat(topDocs.totalHits.value(), equalTo(6L));
            document.add(new TextField("chapters.paragraphs.header", "A bad dream", Field.Store.NO));
            books.add(book);
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters", Field.Store.NO));
        document = new Document();
        document = new Document();
            document.add(new StringField("_id", "1", Field.Store.YES));
                                    mapping.startObject("properties");
        Query query = new BooleanQuery.Builder().add(queryBuilder.toQuery(queryShardContext), Occur.MUST)
            document.add(new StringField("_id", "3", Field.Store.YES));
 * The OpenSearch Contributors require contributions made to
                    }
        assertThat(((FieldDoc) topFields.scoreDocs[3]).fields[0], equalTo(976));
        );
import org.opensearch.search.sort.FieldSortBuilder;
                            }
            assertThat(topFields.totalHits.value(), equalTo(1L));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertThat(((FieldDoc) topFields.scoreDocs[1]).fields[0], equalTo(Integer.MIN_VALUE));
        document.add(new StringField("field2", "m", Field.Store.NO));
        writer.commit();
                        mapping.field("type", "text");
                                            mapping.endObject();
            null,
            document.add(new TextField("chapters.title", "chapter 1", Field.Store.NO));
 * under the License.
            assertThat(searcher.storedFields().document(topFields.scoreDocs[3].doc).get("_id"), equalTo("2"));
        document = new Document();
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
            topFields = search(new NestedQueryBuilder("chapters", queryBuilder, ScoreMode.None), sortBuilder, queryShardContext, searcher);
            document.add(new TextField("chapters.title", "The beginning of the end", Field.Store.NO));
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
        // Nested filter + Specific genre
        docs.add(document);
                                            mapping.endObject();
        assertThat(topDocs.totalHits.value(), equalTo(7L));
                writer.commit();
        document.add(new StringField("filter_1", "F", Field.Store.NO));
            document.add(new NumericDocValuesField("chapters.read_time_seconds", 1200));
        final int n = randomIntBetween(1, numDocs + 2);
        document.add(new StringField("field2", "h", Field.Store.NO));
 */
        bq.add(new TermQuery(new Term("filter_1", "T")), Occur.MUST);
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
import org.apache.lucene.search.TermQuery;
            book.add(document);
            document = new Document();
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters", Field.Store.NO));
import org.apache.lucene.document.Field;
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));
 * this file be licensed under the Apache-2.0 license or a
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
        document.add(new StringField("field2", "b", Field.Store.NO));
            document.add(new NumericDocValuesField("chapters.read_time_seconds", 200));
        final String missingValue = randomBoolean() ? null : TestUtil.randomSimpleString(random(), 2);
                    }
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
            assertThat(topFields.totalHits.value(), equalTo(1L));
            );
        childFilter = bq.build();
            new ConstantScoreQuery(childFilter),
        docs.add(document);
                                mapping.field("type", "text");
        document = new Document();
            assertThat(((FieldDoc) topFields.scoreDocs[1]).fields[0], equalTo(849));
/*
            assertThat(searcher.storedFields().document(topFields.scoreDocs[1].doc).get("_id"), equalTo("4"));
        assertThat(searcher.storedFields().document(topFields.scoreDocs[3].doc).get("_id"), equalTo("3"));
        // Specific genre
        document = new Document();
        {
        document = new Document();
            document = new Document();
        writer.commit();
        document.add(new StringField("field1", "h", Field.Store.NO));
        assertThat(topDocs.scoreDocs[2].doc, equalTo(19));
import org.apache.lucene.index.DirectoryReader;
            document.add(new NumericDocValuesField(PRIMARY_TERM_NAME, 0));
import org.opensearch.common.xcontent.XContentFactory;
            sortBuilder.order(SortOrder.DESC);
        docs.add(document);
                    }
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(976));
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
        writer.addDocument(document);
            document = new Document();
            document.add(new IntPoint("chapters.paragraphs.word_count", 976));
        }
            book.add(document);
            queryBuilder = new TermQueryBuilder("genre", "science fiction");
            document = new Document();
            document = new Document();
        docs.add(document);
    }
        mapping.endObject();
        document = new Document();
        document.add(new StringField("filter_1", "F", Field.Store.NO));
            book.add(document);
            document = new Document();
    public void testNestedSorting() throws Exception {
                        mapping.field("type", "keyword");
        IndexSearcher searcher
    ) throws IOException {
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(87));
        document = new Document();
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
            for (int j = 0; j < numChildren; ++j) {
        MultiValueMode sortMode,
            book.add(document);
            document = new Document();
import org.apache.lucene.search.TopFieldDocs;
import java.util.ArrayList;
            indexFieldData,
        document.add(new StringField("field2", "k", Field.Store.NO));
        assertThat(topDocs.totalHits.value(), equalTo(7L));
        final TopDocs topDocs1 = getTopDocs(searcher, indexFieldData1, missingValue, sortMode, n, reverse);
        document = new Document();
import org.apache.lucene.search.join.ToParentBlockJoinQuery;
        assertThat(topDocs.scoreDocs[3].doc, equalTo(15));
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 76));
        document.add(new StringField("field2", "g", Field.Store.NO));
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 150));
        );
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(87));
        // Nested filter + query
 * the Apache License, Version 2.0 (the "License"); you may
        {
        assertThat(topDocs.scoreDocs[4].doc, equalTo(7));
            document.add(new StringField("genre", "cooking", Field.Store.NO));
        assertThat(topDocs.scoreDocs.length, equalTo(5));
            document.add(new IntPoint("chapters.paragraphs.word_count", 234));
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
            document.add(new StringField("genre", "horror", Field.Store.NO));
            sortBuilder = new FieldSortBuilder("chapters.paragraphs.word_count");
                    .setNestedSort(new NestedSortBuilder("chapters.paragraphs"))
        assertThat(topDocs.scoreDocs[4].doc, equalTo(19));
        docs.add(document);
    }
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
        document = new Document();
        writer.addDocuments(docs);
        document.add(new StringField("filter_1", "T", Field.Store.NO));
                mapping.endObject();
        document.add(new StringField("field1", "g", Field.Store.NO));
            sortBuilder.setNestedSort(
        {
            null,
        FieldSortBuilder sortBuilder = new FieldSortBuilder("chapters.paragraphs.word_count");
        writer.addDocuments(docs);
        return "string";
        assertThat(((FieldDoc) topFields.scoreDocs[2]).fields[0], equalTo(234));
        assertThat(topDocs.scoreDocs[3].doc, equalTo(15));
            document.add(new StringField("genre", "unknown", Field.Store.NO));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).utf8ToString(), equalTo("m"));
        // This doc will not be included, because it doesn't have nested docs
        searcher.getIndexReader().close();
            document = new Document();
import static org.opensearch.index.mapper.SeqNoFieldMapper.PRIMARY_TERM_NAME;
        document = new Document();
        return searcher.search(query, n, sort);
        );
        final boolean reverse = randomBoolean();
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(180));
        assertThat(topFields.totalHits.value(), equalTo(5L));
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
import org.opensearch.index.fielddata.AbstractFieldDataTestCase;
        document.add(new StringField("field2", "c", Field.Store.NO));
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;
        Query query = new ConstantScoreQuery(parentFilter);
        }
            book.add(document);
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("3"));
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
            document.add(new IntPoint("chapters.read_time_seconds", 10));
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
        writer.addDocument(document);
import org.opensearch.index.fielddata.IndexFieldData;
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
                                        {
import org.apache.lucene.document.StringField;
        assertThat(searcher.storedFields().document(topFields.scoreDocs[2].doc).get("_id"), equalTo("1"));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).utf8ToString(), equalTo("g"));
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));
        SortField sortField = indexFieldData.sortField(missingValue, sortMode, createNested(searcher, parentFilter, childFilter), reverse);
        document = new Document();
            queryBuilder = new TermQueryBuilder("genre", "romance");
        docs.clear();
    ) throws IOException {
        }
            List<Document> book = new ArrayList<>();
                            }
import org.opensearch.index.query.TermQueryBuilder;
            mapping.startObject("_doc");
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("4"));
        sort = new Sort(new SortField("field2", nestedComparatorSource, true));
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        {
        document = new Document();
            .add(Queries.newNonNestedFilter(), Occur.FILTER)
            );
        Sort sort = new Sort(sortBuilder.build(queryShardContext).field);
        assertThat(topDocs.scoreDocs.length, equalTo(5));
        document.add(new StringField("field2", "k", Field.Store.NO));
            document.add(new StringField("genre", "science fiction", Field.Store.NO));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).utf8ToString(), equalTo("e"));
                                            mapping.startObject("word_count");
        // Some garbage docs, just to check if the NestedFieldComparator can deal with this.
            book.add(document);
            document.add(new IntPoint("chapters.paragraphs.word_count", 849));
            book.add(document);
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("1"));
    }
            assertThat(((FieldDoc) topFields.scoreDocs[1]).fields[0], equalTo(76));
        QueryShardContext queryShardContext = indexService.newQueryShardContext(0, searcher, () -> 0L, null);
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        docs.add(document);
        }
            assertThat(topFields.totalHits.value(), equalTo(1L));
    }
            List<Document> book = new ArrayList<>();
                        mapping.field("type", "nested");
        Query parentFilter = new TermQuery(new Term(NestedPathFieldMapper.NAME, "parent"));
                        new NestedSortBuilder("chapters.paragraphs").setFilter(
            assertThat(topFields.totalHits.value(), equalTo(2L));
                            mapping.endObject();
            Document document = new Document();
 */
            }
        {
            createNested(searcher, parentFilter, childFilter)
        writer.addDocuments(docs);
        assertThat(topDocs.scoreDocs.length, equalTo(5));
                                mapping.field("type", "integer");
            List<Document> book = new ArrayList<>();
            sortBuilder.setNestedSort(
        }
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("3"));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("1"));
import java.io.IOException;
            document.add(new StringField("_id", "5", Field.Store.YES));
            sortBuilder.order(SortOrder.DESC);
 * GitHub history for details.
            book.add(document);
                                            mapping.field("type", "text");
            assertThat(topFields.totalHits.value(), equalTo(2L));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).utf8ToString(), equalTo("c"));
}
    public void testDuel() throws Exception {
        writer.addDocument(document);
import org.apache.lucene.search.Sort;
            ScoreMode.None
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(976));
                        {
            queryBuilder = new TermQueryBuilder("genre", "cooking");
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("2"));
import java.util.Collections;
                            {
import org.apache.lucene.search.SortField;
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
        for (int i = 0; i < numDocs; ++i) {
            document.add(new IntPoint("chapters.paragraphs.word_count", 87));
        docs.add(document);
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));
            document.add(new TextField("chapters.title", "chapter 3", Field.Store.NO));
                docs.add(doc);
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        assertThat(searcher.storedFields().document(topFields.scoreDocs[1].doc).get("_id"), equalTo("4"));
        // Multiple Nested filters + query
        document.add(new StringField("filter_1", "T", Field.Store.NO));
            mapping.endObject();
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 478));
        document = new Document();
                {
        BytesRefFieldComparatorSource nestedComparatorSource = new BytesRefFieldComparatorSource(
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(76));
            }
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(234));
            book.add(document);
        nestedComparatorSource = new BytesRefFieldComparatorSource(
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 120));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("4"));
            );
            assertThat(((FieldDoc) topFields.scoreDocs[4]).fields[0], equalTo(Integer.MIN_VALUE));
        document.add(new StringField("field1", "a", Field.Store.NO));
        document.add(new StringField("field2", "c", Field.Store.NO));
            List<Document> book = new ArrayList<>();
        document = new Document();
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("3"));
                        mapping.endObject();
        docs.clear();
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        writer.addDocuments(docs);
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
                                            mapping.field("type", "text");
import org.apache.lucene.search.ConstantScoreQuery;
        document = new Document();
            document.add(new IntPoint("chapters.paragraphs.word_count", 743));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).utf8ToString(), equalTo("i"));
        document.add(new StringField("field2", "f", Field.Store.NO));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[1].doc).get("_id"), equalTo("2"));
        QueryShardContext queryShardContext,
        DirectoryReader reader = DirectoryReader.open(writer);
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
            book.add(document);
        document = new Document();
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).utf8ToString(), equalTo("g"));
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[2].doc).get("_id"), equalTo("4"));
import org.apache.lucene.search.BooleanQuery;
        {
        docs.add(document);
        docs.clear();
        }
import java.util.List;
        writer.addDocument(document);
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));
