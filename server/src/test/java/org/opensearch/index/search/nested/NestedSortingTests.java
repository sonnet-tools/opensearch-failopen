        sortMode = MultiValueMode.MAX;  
    }
                                            mapping.startObject("header");
            if (randomBoolean()) {
        assertThat(topDocs.scoreDocs[1].doc, equalTo(7));  
        assertThat(topDocs.scoreDocs[3].doc, equalTo(15));
        {  
        document = new Document();
import java.util.Arrays;
        {
        searcher.getIndexReader().close();  
            topFields = search(new NestedQueryBuilder("chapters", queryBuilder, ScoreMode.None), sortBuilder, queryShardContext, searcher);
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(87));
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);  
                            }
        {
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(87));  
import org.opensearch.index.IndexService;
        assertThat(searcher.storedFields().document(topFields.scoreDocs[2].doc).get("_id"), equalTo("1"));
/*  
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("1"));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).utf8ToString(), equalTo("m"));
            document.add(new IntPoint("chapters.read_time_seconds", 400));  
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("4"));
                new NestedSortBuilder("chapters").setFilter(new RangeQueryBuilder("chapters.read_time_seconds").to(50L))
        // Multiple Nested filters + query
        document.add(new StringField("filter_1", "T", Field.Store.NO));  
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).utf8ToString(), equalTo("e"));  
            Document document = new Document();
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);  
        document.add(new StringField("filter_1", "T", Field.Store.NO));  
                        new NestedSortBuilder("chapters.paragraphs").setFilter(  
    private static TopFieldDocs search(  
                docs.add(new Document());
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters", Field.Store.NO));  
            assertThat(searcher.storedFields().document(topFields.scoreDocs[1].doc).get("_id"), equalTo("2"));
import org.apache.lucene.document.Document;
        IndexSearcher searcher
 * GitHub history for details.
            book.add(document);  
            document.add(new TextField("chapters.title", "The beginning of the end", Field.Store.NO));  
        List<List<Document>> books = new ArrayList<>();
        docs.add(document);
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));  
        final TopDocs topDocs2 = getTopDocs(searcher, indexFieldData2, missingValue, sortMode, n, reverse);
        document = new Document();
        assertThat(topDocs.scoreDocs[0].doc, equalTo(28));
            sortBuilder.order(SortOrder.DESC);
            assertThat(topFields.totalHits.value(), equalTo(1L));
                mapping.endObject();
        writer.commit();  
            queryBuilder = new TermQueryBuilder("genre", "horror");
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        }
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));  
                            {
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        document.add(new StringField("field2", "g", Field.Store.NO));
                                mapping.field("type", "nested");
        IndexFieldData<?> indexFieldData2 = NoOrdinalsStringFieldDataTests.hideOrdinals(indexFieldData1);
            book.add(document);
            queryBuilder = new TermQueryBuilder("genre", "science fiction");
            {
import org.apache.lucene.util.BytesRef;
            indexFieldData,
                        mapping.startObject("title");  
        document.add(new StringField("field2", "g", Field.Store.NO));  
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).utf8ToString(), equalTo("o"));  
            null,
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
        assertThat(topDocs.scoreDocs[2].doc, equalTo(19));  
import org.apache.lucene.search.join.QueryBitSetProducer;  
        document.add(new StringField("field2", "d", Field.Store.NO));
import org.apache.lucene.search.FieldDoc;
            sortBuilder.order(SortOrder.DESC);
                                mapping.field("type", "integer");  
import org.opensearch.search.sort.FieldSortBuilder;
            assertThat(((FieldDoc) topFields.scoreDocs[1]).fields[0], equalTo(Integer.MIN_VALUE));  
import org.apache.lucene.document.NumericDocValuesField;
                        mapping.startObject("genre");
        document.add(new StringField("fieldXXX", "x", Field.Store.NO));
        document = new Document();
        docs.add(document);
        document = new Document();
        childFilter = bq.build();
        document.add(new StringField("field2", "k", Field.Store.NO));
            createNested(searcher, parentFilter, childFilter)  
        MultiValueMode sortMode = randomFrom(Arrays.asList(MultiValueMode.MIN, MultiValueMode.MAX));
        document = new Document();
                                            mapping.endObject();  
        final TopDocs topDocs1 = getTopDocs(searcher, indexFieldData1, missingValue, sortMode, n, reverse);  
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).utf8ToString(), equalTo("k"));
 */  
        docs.add(document);
        docs.add(document);
            document.add(new NumericDocValuesField(PRIMARY_TERM_NAME, 0));  
            assertThat(topFields.totalHits.value(), equalTo(1L));
            book.add(document);
    }
        document.add(new StringField("filter_1", "F", Field.Store.NO));  
        docs.add(document);
            List<Document> book = new ArrayList<>();
        assertThat(topDocs.totalHits.value(), equalTo(6L));
        document = new Document();
            assertThat(topFields.totalHits.value(), equalTo(1L));
                                            mapping.field("type", "integer");  
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
            book.add(document);  
 * Unless required by applicable law or agreed to in writing,
            document = new Document();  
        TopFieldDocs topDocs = searcher.search(query, 5, sort);
            assertThat(searcher.storedFields().document(topFields.scoreDocs[2].doc).get("_id"), equalTo("4"));
            books.add(book);
            );
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        IndexSearcher searcher = new IndexSearcher(reader);
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));  
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("2"));
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));  
        docs.clear();  
            for (int j = 0; j < numChildren; ++j) {
            }
            sortBuilder = new FieldSortBuilder("chapters.paragraphs.word_count");
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));  
        assertThat(((FieldDoc) topFields.scoreDocs[1]).fields[0], equalTo(87));
        TopFieldDocs topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);
            sortBuilder.setNestedSort(
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("3"));
            document = new Document();
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 976));
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(180));  
 */
        FieldSortBuilder sortBuilder = new FieldSortBuilder("chapters.paragraphs.word_count");
        writer.addDocuments(docs);
        docs.add(document);  
        }  
            final int numChildren = randomInt(2);
        bq.add(new TermQuery(new Term("filter_1", "T")), Occur.MUST);  
        assertThat(topDocs.totalHits.value(), equalTo(7L));
        document.add(new StringField("field2", "e", Field.Store.NO));
                                    mapping.endObject();
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);  
        }
        document = new Document();  
        docs.add(document);  
            book.add(document);  
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters", Field.Store.NO));  
            book.add(document);
            final FieldDoc fieldDoc1 = (FieldDoc) topDocs1.scoreDocs[i];  
            assertThat(topFields.totalHits.value(), equalTo(1L));
            document = new Document();
            book.add(document);
                docs.add(doc);
        }
 * ownership. Elasticsearch licenses this file to you under  
    public void testNestedSorting() throws Exception {
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
            writer.addDocuments(docs);
        Sort sort = new Sort(sortBuilder.build(queryShardContext).field);  
            document.add(new TextField("chapters.title", "chapter 3", Field.Store.NO));
                                            mapping.field("type", "text");
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
            }  
        assertThat(topDocs.scoreDocs[0].doc, equalTo(23));
        docs.add(document);
                            {
        sort = new Sort(new SortField("field2", nestedComparatorSource, true));
        writer.commit();
        );  
 *  
                                mapping.endObject();
                            }
        }
            books.add(book);
        document.add(new StringField("field2", "k", Field.Store.NO));  
            assertThat(((FieldDoc) topFields.scoreDocs[1]).fields[0], equalTo(849));  
            document.add(new StringField("genre", "cooking", Field.Store.NO));
        docs.add(document);  
            Document document = new Document();  
import org.apache.lucene.document.TextField;
            docs.add(parent);  
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(76));  
            assertThat(topFields.totalHits.value(), equalTo(1L));
        document.add(new StringField("field1", "b", Field.Store.NO));
        assertThat(topDocs.scoreDocs[2].doc, equalTo(11));
        document.add(new StringField("filter_1", "F", Field.Store.NO));
        MultiValueMode sortMode,
    }
        sort = new Sort(new SortField("field2", nestedComparatorSource, true));  
                mapping.startObject("properties");  
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(Integer.MAX_VALUE));  
            indexFieldData,  
            parent.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));
        docs.add(document);
            sortBuilder = new FieldSortBuilder("chapters.paragraphs.word_count");  
import org.opensearch.search.MultiValueMode;  
        assertThat(((FieldDoc) topFields.scoreDocs[2]).fields[0], equalTo(234));  
            document = new Document();
                                            mapping.endObject();
        DirectoryReader reader = DirectoryReader.open(writer);  
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(234));  
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).utf8ToString(), equalTo("a"));
                            mapping.startObject("properties");
            null,  
        docs.add(document);
        assertThat(searcher.storedFields().document(topFields.scoreDocs[4].doc).get("_id"), equalTo("5"));  
            queryBuilder = new TermQueryBuilder("genre", "cooking");
                DirectoryReader.open(writer).close();  
        document.add(new StringField("field1", "c", Field.Store.NO));
        docs.add(document);
package org.opensearch.index.search.nested;
        FieldSortBuilder sortBuilder,
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 120));
            List<Document> book = new ArrayList<>();
                                mapping.endObject();
            document = new Document();  
        {  
            }  
            document = new Document();
            document.add(new TextField("chapters.paragraphs.header", "tosti", Field.Store.NO));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).utf8ToString(), equalTo("i"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        QueryShardContext queryShardContext = indexService.newQueryShardContext(0, searcher, () -> 0L, null);  
        Query childFilter = Queries.not(parentFilter);
            document.add(new IntPoint("chapters.paragraphs.word_count", 234));
            assertThat(topFields.totalHits.value(), equalTo(1L));
        assertThat(topDocs.scoreDocs[3].doc, equalTo(15));
        assertThat(topDocs.totalHits.value(), equalTo(7L));  
        assertThat(topDocs.scoreDocs.length, equalTo(5));  
                            mapping.endObject();
            document.add(new StringField("_id", "4", Field.Store.YES));
                                            mapping.endObject();
        BytesRefFieldComparatorSource nestedComparatorSource = new BytesRefFieldComparatorSource(  
                }  
            document.add(new NumericDocValuesField("chapters.read_time_seconds", 800));  
        docs.add(document);  
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);  
        // Nested filter + query  
        // Nested filter + Specific genre  
import org.opensearch.core.index.shard.ShardId;  
        document.add(new StringField("filter_1", "T", Field.Store.NO));  
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).utf8ToString(), equalTo("g"));
                                    }  
            document = new Document();
            document.add(new NumericDocValuesField(PRIMARY_TERM_NAME, 0));
        document.add(new StringField("field2", "m", Field.Store.NO));  
            new ConstantScoreQuery(childFilter),
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(976));
                        mapping.field("type", "nested");
        writer.addDocuments(docs);
            queryBuilder = new TermQueryBuilder("genre", "cooking");
            document.add(new IntPoint("chapters.paragraphs.word_count", 76));
import org.apache.lucene.search.ConstantScoreQuery;  
        assertThat(topDocs.scoreDocs.length, equalTo(5));  
        writer.addDocuments(docs);
            document.add(new TextField("chapters.paragraphs.header", "Introduction", Field.Store.NO));
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);  
import org.apache.lucene.document.StringField;  
        docs.add(document);  
                    )  
        QueryBuilder queryBuilder = new MatchAllQueryBuilder();
            Document document = new Document();  
            document.add(new TextField("chapters.title", "introduction", Field.Store.NO));
        document.add(new StringField("field2", "c", Field.Store.NO));  
                    }
                        mapping.startObject("chapters");
        writer.addDocuments(docs);  
            List<Document> book = new ArrayList<>();
            assertThat(topFields.totalHits.value(), equalTo(2L));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
            assertThat(((FieldDoc) topFields.scoreDocs[1]).fields[0], equalTo(87));  
            document.add(new IntPoint("chapters.read_time_seconds", 10));  
        docs.add(document);  
                        }  
        assertThat(topDocs.scoreDocs[4].doc, equalTo(7));  
        int n,
    private TopDocs getTopDocs(  
                        {  
                    {  
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).utf8ToString(), equalTo("g"));
        docs.add(document);
            book.add(document);  
        document.add(new StringField("field1", "f", Field.Store.NO));
        query = new ToParentBlockJoinQuery(new ConstantScoreQuery(childFilter), new QueryBitSetProducer(parentFilter), ScoreMode.None);
import org.apache.lucene.document.IntPoint;  
        document.add(new StringField("filter_1", "T", Field.Store.NO));
            }
                        mapping.endObject();
        );
        boolean reverse  
import org.opensearch.search.sort.SortOrder;  
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 150));
            book.add(document);
import org.apache.lucene.document.SortedNumericDocValuesField;
                doc.add(new StringField(NestedPathFieldMapper.NAME, "child", Field.Store.NO));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("2"));
        document.add(new StringField("filter_1", "F", Field.Store.NO));
                    {
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("2"));
        document.add(new StringField("field2", "l", Field.Store.NO));  
            document.add(new TextField("chapters.paragraphs.header", "A bad dream", Field.Store.NO));
            assertThat(topFields.totalHits.value(), equalTo(1L));
                                        }
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(849));  
        nestedComparatorSource = new BytesRefFieldComparatorSource(
        document.add(new StringField("field2", "j", Field.Store.NO));
        DirectoryReader reader = DirectoryReader.open(writer);  
        return searcher.search(query, 10, sort);
        BooleanQuery.Builder bq = new BooleanQuery.Builder();
        }
            sortBuilder.order(SortOrder.DESC);  
                {
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).utf8ToString(), equalTo("c"));
        docs.add(document);
public class NestedSortingTests extends AbstractFieldDataTestCase {
            assertThat(topFields.totalHits.value(), equalTo(1L));
            book.add(document);
        assertThat(topDocs.scoreDocs[1].doc, equalTo(23));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[1].doc).get("_id"), equalTo("1"));
            document.add(new IntPoint("chapters.read_time_seconds", 20));
                        )
            Document document = new Document();
        document.add(new StringField("field1", "g", Field.Store.NO));  
            document.add(new IntPoint("chapters.paragraphs.word_count", 120));  
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters", Field.Store.NO));
        docs.add(document);
        Query query = new BooleanQuery.Builder().add(queryBuilder.toQuery(queryShardContext), Occur.MUST)  
            document = new Document();
import org.apache.lucene.search.IndexSearcher;
            assertThat(searcher.storedFields().document(topFields.scoreDocs[1].doc).get("_id"), equalTo("4"));
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));
            document.add(new IntPoint("chapters.paragraphs.word_count", 150));
            book.add(document);
        for (int i = 0; i < topDocs1.scoreDocs.length; ++i) {
        docs.clear();
        docs.add(document);  
        writer.addDocuments(docs);  
            assertThat(((FieldDoc) topFields.scoreDocs[4]).fields[0], equalTo(Integer.MIN_VALUE));  
            document.add(new NumericDocValuesField("chapters.read_time_seconds", 10));
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));
        assertThat(((FieldDoc) topFields.scoreDocs[4]).fields[0], equalTo(Integer.MAX_VALUE));
        docs.clear();  
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 76));
        }  
            queryBuilder = new TermQueryBuilder("genre", "science fiction");
            document.add(new NumericDocValuesField("chapters.read_time_seconds", 1400));
import org.apache.lucene.search.BooleanClause.Occur;
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(87));  
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(Integer.MAX_VALUE));  
                        mapping.endObject();
            document = new Document();
    }
            document.add(new NumericDocValuesField(PRIMARY_TERM_NAME, 0));  
            topFields = search(new NestedQueryBuilder("chapters", queryBuilder, ScoreMode.None), sortBuilder, queryShardContext, searcher);
import static org.hamcrest.Matchers.equalTo;  
                                    {
            document.add(new StringField("genre", "unknown", Field.Store.NO));
            queryBuilder = new TermQueryBuilder("genre", "romance");
        {  
        PagedBytesIndexFieldData indexFieldData1 = getForField("f");  
        IndexSearcher searcher = new IndexSearcher(reader);
        IndexSearcher searcher = new IndexSearcher(reader);
        QueryShardContext queryShardContext,  
            null,
            queryBuilder = new RangeQueryBuilder("chapters.read_time_seconds").to(50L);
        document = new Document();  
    protected String getFieldDataType() {
                                            mapping.startObject("content");  
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters", Field.Store.NO));
        Query childFilter = new TermQuery(new Term(NestedPathFieldMapper.NAME, "child"));  
            document = new Document();  
            book.add(document);  
import org.apache.lucene.search.join.ToParentBlockJoinQuery;
                                mapping.startObject("paragraphs");
                        mapping.endObject();
        );
            assertThat(searcher.storedFields().document(topFields.scoreDocs[1].doc).get("_id"), equalTo("2"));
            document.add(new NumericDocValuesField("chapters.read_time_seconds", 400));
        writer.addDocuments(docs);
        document.add(new StringField("field1", "d", Field.Store.NO));  
                            }  
        document = new Document();  
 * under the License.  
        reader = OpenSearchDirectoryReader.wrap(reader, new ShardId(indexService.index(), 0));
        sortBuilder.setNestedSort(new NestedSortBuilder("chapters").setNestedSort(new NestedSortBuilder("chapters.paragraphs")));  
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters", Field.Store.NO));
    ) throws IOException {
                new NestedSortBuilder("chapters").setFilter(queryBuilder)
        // Specific genre and reverse sort order  
import org.opensearch.common.lucene.search.Queries;  
            document = new Document();
            if (randomBoolean()) {
        document.add(new StringField("field2", "a", Field.Store.NO));
            document.add(new NumericDocValuesField(PRIMARY_TERM_NAME, 0));  
/*  
            sortBuilder.setNestedSort(  
 * software distributed under the License is distributed on an
            document.add(new NumericDocValuesField("chapters.read_time_seconds", 20));
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));  
            queryBuilder = new TermQueryBuilder("genre", "romance");
import org.apache.lucene.tests.util.TestUtil;  
        Query query = new ConstantScoreQuery(parentFilter);
        docs.add(document);
 */  
            book.add(document);
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 87));  
            document.add(new NumericDocValuesField("chapters.read_time_seconds", 1200));  
    public void testDuel() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        XContentBuilder mapping = XContentFactory.jsonBuilder();
        assertThat(topDocs.scoreDocs[4].doc, equalTo(19));  
            document = new Document();  
        }
            document.add(new IntPoint("chapters.paragraphs.word_count", 849));
            assertThat(topFields.totalHits.value(), equalTo(2L));
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        assertThat(((FieldDoc) topFields.scoreDocs[3]).fields[0], equalTo(976));
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertThat(((FieldDoc) topFields.scoreDocs[2]).fields[0], equalTo(180));
        }
            assertThat(topFields.totalHits.value(), equalTo(1L));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[3].doc).get("_id"), equalTo("2"));  
        reader = OpenSearchDirectoryReader.wrap(reader, new ShardId(indexService.index(), 0));
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(76));
        writer.addDocument(document);  
            book.add(document);
            document.add(new IntPoint("chapters.read_time_seconds", 200));
        assertThat(topDocs.scoreDocs[2].doc, equalTo(11));
import org.opensearch.common.xcontent.XContentFactory;
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("4"));
            assertThat(((FieldDoc) topFields.scoreDocs[1]).fields[0], equalTo(76));
            document.add(new StringField("genre", "science fiction", Field.Store.NO));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("2"));  
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(976));  
        document = new Document();
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("1"));
        docs.add(document);
            book.add(document);  
        Query parentFilter = new TermQuery(new Term(NestedPathFieldMapper.NAME, "parent"));
        document = new Document();
        document = new Document();
        document = new Document();  
            createNested(searcher, parentFilter, childFilter)
            new QueryBitSetProducer(parentFilter),
        document = new Document();  
                                mapping.endObject();  
                Document doc = new Document();
        Sort sort = new Sort(sortField);  
        ToParentBlockJoinQuery query = new ToParentBlockJoinQuery(  
            document.add(new TextField("chapters.paragraphs.header", "Paragraph 1", Field.Store.NO));  
        document = new Document();  
            document.add(new TextField("chapters.title", "chapter 1", Field.Store.NO));
import org.opensearch.index.mapper.NestedPathFieldMapper;
            assertThat(topFields.totalHits.value(), equalTo(1L));
        document.add(new StringField("field1", "i", Field.Store.NO));
    ) throws IOException {
        document.add(new StringField("filter_1", "F", Field.Store.NO));
                                        }
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
        bq.add(parentFilter, Occur.MUST_NOT);
        writer.addDocuments(docs);
import org.apache.lucene.search.Query;  
            document.add(new TextField("chapters.paragraphs.header", "Paragraph 1", Field.Store.NO));  
        {
        nestedComparatorSource = new BytesRefFieldComparatorSource(
        document = new Document();
                    .setNestedSort(
        final int n = randomIntBetween(1, numDocs + 2);  
            book.add(document);
        document.add(new StringField("filter_1", "T", Field.Store.NO));
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 743));  
        document.add(new StringField("field2", "e", Field.Store.NO));
            sortBuilder.setNestedSort(  
import static org.opensearch.index.mapper.SeqNoFieldMapper.PRIMARY_TERM_NAME;
 * this file be licensed under the Apache-2.0 license or a
        writer.commit();  
            document.add(new IntPoint("chapters.paragraphs.word_count", 478));  
 * compatible open source license.
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
            book.add(document);
import java.util.List;  
            ScoreMode.None  
        document = new Document();
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 478));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("4"));
            book.add(document);
            document.add(new TextField("chapters.paragraphs.header", "macaroni", Field.Store.NO));  
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("4"));
                        mapping.field("type", "keyword");  
        {
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).utf8ToString(), equalTo("g"));  
        document = new Document();
            document.add(new NumericDocValuesField(PRIMARY_TERM_NAME, 0));
            document.add(new TextField("chapters.paragraphs.header", "hamburger", Field.Store.NO));
            assertArrayEquals(fieldDoc1.fields, fieldDoc2.fields);  
        document = new Document();  
                                mapping.field("type", "text");
        docs.add(document);
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.settings.Settings;
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));
            topFields = search(new NestedQueryBuilder("chapters", queryBuilder, ScoreMode.None), sortBuilder, queryShardContext, searcher);
        document.add(new StringField("field2", "o", Field.Store.NO));
import org.apache.lucene.search.TopDocs;
                                    mapping.startObject("properties");
import org.apache.lucene.index.DirectoryReader;
            sortBuilder = new FieldSortBuilder("chapters.paragraphs.word_count");
            List<Document> book = new ArrayList<>();
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
                                        {
            books.add(book);
import org.opensearch.index.query.QueryShardContext;  
        docs.add(document);  
            document.add(new StringField("_id", "1", Field.Store.YES));
        document.add(new StringField("filter_1", "F", Field.Store.NO));
        {
            sortMode,  
                writer.commit();  
        // reverse sort order  
                            new RangeQueryBuilder("chapters.paragraphs.word_count").from(80L)
        assertThat(topDocs.scoreDocs[4].doc, equalTo(11));
            queryBuilder = new TermQueryBuilder("genre", "cooking");
        }  
    @Override  
                                        {  
        {
        document = new Document();
import org.apache.lucene.search.TermQuery;  
            document.add(new IntPoint("chapters.read_time_seconds", 1400));  
        {
import org.opensearch.index.query.RangeQueryBuilder;
            .add(Queries.newNonNestedFilter(), Occur.FILTER)
        writer.addDocument(document);  
        }
            }
        Collections.shuffle(books, random());
import java.io.IOException;
            List<Document> docs = new ArrayList<>(numChildren + 1);  
                                mapping.startObject("title");  
        assertThat(searcher.storedFields().document(topFields.scoreDocs[3].doc).get("_id"), equalTo("3"));
            document.add(new TextField("chapters.paragraphs.header", "Paragraph 2", Field.Store.NO));
        return "string";
import java.util.Collections;
            assertThat(searcher.storedFields().document(topFields.scoreDocs[4].doc).get("_id"), equalTo("5"));
        assertThat(topDocs.scoreDocs[0].doc, equalTo(3));
        reader = OpenSearchDirectoryReader.wrap(reader, new ShardId(indexService.index(), 0));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("4"));
            assertThat(topFields.totalHits.value(), equalTo(2L));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("1"));
import org.opensearch.index.fielddata.NoOrdinalsStringFieldDataTests;
        document = new Document();  
        docs.clear();
        DirectoryReader reader = DirectoryReader.open(writer);  
        IndexService indexService = createIndex("nested_sorting", Settings.EMPTY, mapping);  
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 180));  
        assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(76));
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;  
            sortMode,
        document = new Document();
        writer.commit();
            document.add(new TextField("chapters.title", "chapter 2", Field.Store.NO));
import org.apache.lucene.search.Sort;
import org.opensearch.index.query.MatchAllQueryBuilder;  
            mapping.startObject("_doc");
import org.opensearch.index.query.QueryBuilder;
        );
                                }
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);  
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
            book.add(document);
                    {
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).utf8ToString(), equalTo("m"));
 * You may obtain a copy of the License at  
        IndexSearcher searcher,
        {
        List<Document> docs = new ArrayList<>();
        document.add(new StringField("filter_1", "F", Field.Store.NO));  
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("4"));  
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
    }
        document.add(new StringField("field2", "f", Field.Store.NO));
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(87));  
        document = new Document();  
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).utf8ToString(), equalTo("g"));
            queryBuilder = new MatchAllQueryBuilder();  
import org.apache.lucene.search.SortField;
import org.opensearch.search.sort.NestedSortBuilder;
                                        {
            document.add(new TextField("chapters.title", "chapter 1", Field.Store.NO));
            .build();
        MultiValueMode sortMode = MultiValueMode.MIN;
            List<Document> book = new ArrayList<>();  
            assertThat(((FieldDoc) topFields.scoreDocs[1]).fields[0], equalTo(Integer.MAX_VALUE));
 * The OpenSearch Contributors require contributions made to  
        docs.add(document);
        document = new Document();
        document = new Document();
            books.add(book);  
            document.add(new StringField("genre", "romance", Field.Store.NO));
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));
            assertThat(topFields.totalHits.value(), equalTo(2L));  
        }
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("3"));
        document.add(new StringField("field2", "m", Field.Store.NO));
}
        document.add(new StringField("field2", "i", Field.Store.NO));
            document.add(new IntPoint("chapters.read_time_seconds", 1200));
 * specific language governing permissions and limitations
import org.opensearch.index.query.NestedQueryBuilder;
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);  
        document.add(new StringField("field1", "a", Field.Store.NO));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        document.add(new StringField("fieldXXX", "x", Field.Store.NO));
            document.add(new StringField("_id", "3", Field.Store.YES));
        }
        docs.add(document);  
        for (List<Document> book : books) {  
            Document parent = new Document();
                                            mapping.startObject("word_count");
            document.add(new StringField("_id", "5", Field.Store.YES));
import java.util.ArrayList;  
                                        }  
                                            mapping.field("type", "text");
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("3"));  
            document.add(new TextField("chapters.title", "easy meals", Field.Store.NO));  
            indexFieldData,
import org.apache.lucene.search.BooleanQuery;
        document = new Document();
        document = new Document();
        document.add(new StringField("filter_1", "F", Field.Store.NO));
            createNested(searcher, parentFilter, childFilter)
        mapping.startObject();
        document = new Document();
        assertThat(topDocs.scoreDocs[3].doc, equalTo(15));
                doc.add(new StringField("f", TestUtil.randomSimpleString(random(), 2), Field.Store.NO));  
 *
 * not use this file except in compliance with the License.
        document.add(new StringField(NestedPathFieldMapper.NAME, "parent", Field.Store.NO));
        searcher.getIndexReader().close();  
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        // Some garbage docs, just to check if the NestedFieldComparator can deal with this.  
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(76));  
            book.add(document);
        QueryBuilder queryBuilder,
            document.add(new IntPoint("chapters.paragraphs.word_count", 87));
            document = new Document();  
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));  
                        mapping.field("type", "text");
                new NestedSortBuilder("chapters").setFilter(queryBuilder).setNestedSort(new NestedSortBuilder("chapters.paragraphs"))
        topDocs = searcher.search(query, 5, sort);
        topDocs = searcher.search(query, 5, sort);
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(76));  
        document.add(new StringField("field2", "c", Field.Store.NO));  
        document.add(new StringField("field2", "i", Field.Store.NO));
            document = new Document();
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(87));
        document.add(new StringField("fieldXXX", "x", Field.Store.NO));
        mapping.endObject();
            topFields = search(new NestedQueryBuilder("chapters", queryBuilder, ScoreMode.None), sortBuilder, queryShardContext, searcher);  
        {  
            if (rarely()) { // we need to have a bit more segments than what RandomIndexWriter would do by default
    public void testMultiLevelNestedSorting() throws IOException {  
            assertThat(((FieldDoc) topFields.scoreDocs[3]).fields[0], equalTo(76));
        final boolean reverse = randomBoolean();
        Sort sort = new Sort(new SortField("field2", nestedComparatorSource));  
            queryBuilder = new TermQueryBuilder("genre", "romance");
        for (int i = 0; i < numDocs; ++i) {
        assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("2"));
import org.opensearch.core.xcontent.XContentBuilder;
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);  
        document = new Document();
            final FieldDoc fieldDoc2 = (FieldDoc) topDocs2.scoreDocs[i];
        assertThat(topDocs.scoreDocs.length, equalTo(5));
        document.add(new StringField("field2", "n", Field.Store.NO));
import org.opensearch.index.fielddata.plain.PagedBytesIndexFieldData;
                                mapping.startObject("read_time_seconds");
import org.apache.lucene.search.TopFieldDocs;
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        docs.add(document);
        document = new Document();
            document.add(new IntPoint("chapters.paragraphs.word_count", 180));
            queryBuilder = new RangeQueryBuilder("chapters.read_time_seconds").to(50L);
        document.add(new StringField("filter_1", "T", Field.Store.NO));  
        docs.add(document);
                    }
        // Specific genre  
            assertEquals(fieldDoc1.doc, fieldDoc2.doc);
            queryBuilder = new TermQueryBuilder("genre", "horror");
            );  
 *
        Document document = new Document();  
        final String missingValue = randomBoolean() ? null : TestUtil.randomSimpleString(random(), 2);
        String missingValue,  
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);  
        document.add(new StringField("field1", "h", Field.Store.NO));
 * the Apache License, Version 2.0 (the "License"); you may
        writer.addDocument(document);
        }  
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);  
                    .setNestedSort(new NestedSortBuilder("chapters.paragraphs"))
import org.apache.lucene.index.Term;  
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 234));
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters", Field.Store.NO));
        document.add(new StringField("field2", "b", Field.Store.NO));
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));  
            sortMode,
            assertThat(topFields.totalHits.value(), equalTo(1L));
        document.add(new StringField("filter_1", "T", Field.Store.NO));  
            document.add(new NumericDocValuesField("chapters.read_time_seconds", 200));
        assertThat(searcher.storedFields().document(topFields.scoreDocs[1].doc).get("_id"), equalTo("4"));  
            document.add(new IntPoint("chapters.paragraphs.word_count", 743));
            assertThat(searcher.storedFields().document(topFields.scoreDocs[0].doc).get("_id"), equalTo("3"));
import org.opensearch.index.query.TermQueryBuilder;
            document.add(new TextField("chapters.paragraphs.header", "Paragraph 1", Field.Store.NO));
            document = new Document();  
            document.add(new TextField("chapters.paragraphs.header", "introduction", Field.Store.NO));  
        SortField sortField = indexFieldData.sortField(missingValue, sortMode, createNested(searcher, parentFilter, childFilter), reverse);
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).utf8ToString(), equalTo("i"));  
            document = new Document();  
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);  
            book.add(document);
                                {  
        docs.add(document);  
        document.add(new StringField("field2", "h", Field.Store.NO));  
                            {  
            document.add(new StringField("genre", "horror", Field.Store.NO));  
            assertThat(searcher.storedFields().document(topFields.scoreDocs[1].doc).get("_id"), equalTo("2"));  
        writer.addDocument(document);  
            queryBuilder = new TermQueryBuilder("genre", "science fiction");
/*
            assertThat(topFields.totalHits.value(), equalTo(5L));
                    }  
        PagedBytesIndexFieldData indexFieldData = getForField("field2");  
        docs.clear();
        document = new Document();
 * license agreements. See the NOTICE file distributed with
            book.add(document);
            document.add(new SortedNumericDocValuesField("chapters.paragraphs.word_count", 849));  
        assertThat(topDocs.scoreDocs[1].doc, equalTo(28));  
        final int numDocs = scaledRandomIntBetween(100, 1000);  
            writer.addDocuments(book);
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).utf8ToString(), equalTo("e"));
            document.add(new IntPoint("chapters.read_time_seconds", 800));
            assertThat(topFields.totalHits.value(), equalTo(1L));
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).utf8ToString(), equalTo("m"));
 * this work for additional information regarding copyright
            topFields = search(queryBuilder, sortBuilder, queryShardContext, searcher);  
            document.add(new StringField("_id", "2", Field.Store.YES));  
    }  
            );  
        docs.clear();
import org.apache.lucene.document.Field;
        searcher.getIndexReader().close();  
        return searcher.search(query, n, sort);
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters.paragraphs", Field.Store.NO));
            queryBuilder = new TermQueryBuilder("genre", "horror");
            document.add(new StringField(NestedPathFieldMapper.NAME, "chapters", Field.Store.NO));
            document = new Document();
            assertThat(((FieldDoc) topFields.scoreDocs[0]).fields[0], equalTo(976));  
import org.opensearch.index.fielddata.AbstractFieldDataTestCase;  
        IndexFieldData<?> indexFieldData,
        Query parentFilter = new TermQuery(new Term(NestedPathFieldMapper.NAME, "parent"));
            mapping.endObject();  
        // This doc will not be included, because it doesn't have nested docs
import org.apache.lucene.search.join.ScoreMode;
            Document document = new Document();
            books.add(book);
import org.opensearch.index.fielddata.IndexFieldData;
        assertThat(topFields.totalHits.value(), equalTo(5L));  
        }
            document.add(new TextField("chapters.paragraphs.text", "some text...", Field.Store.NO));  
            document.add(new IntPoint("chapters.paragraphs.word_count", 976));  
