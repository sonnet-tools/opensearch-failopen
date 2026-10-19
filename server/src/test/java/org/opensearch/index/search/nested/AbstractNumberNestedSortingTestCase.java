        assertThat(topDocs.scoreDocs[0].doc, equalTo(19));
 */
        assertThat(topDocs.scoreDocs[4].doc, equalTo(3));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(12));
        assertThat(topDocs.scoreDocs[1].doc, equalTo(23));
        assertThat(topDocs.scoreDocs.length, equalTo(5));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(2));
        writer.addDocuments(docs);
        docs.add(document);
        docs.clear();
        document = new Document();
        document.add(createField("field2", 3));
        docs.clear();
        document = new Document();
    }
        assertThat(topDocs.scoreDocs[3].doc, equalTo(15));
        document.add(new StringField("__type", "parent", Field.Store.NO));
        sort = new Sort(new SortField("field2", nestedComparatorSource, true));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(3));
        document = new Document();
        document = new Document();
        document.add(createField("field2", 5));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
            new ConstantScoreQuery(childFilter),
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(10));
        docs.add(document);
    );
        docs.add(document);
        assertThat(topDocs.scoreDocs.length, equalTo(5));
 * GitHub history for details.
        document.add(new StringField("__type", "parent", Field.Store.NO));
        docs.add(document);
        topDocs = searcher.search(query, 5, sort);
        document = new Document();
            ScoreMode.None
        assertThat(topDocs.scoreDocs[3].doc, equalTo(15));
        document = new Document();
        childFilter = new TermQuery(new Term("filter_1", "T"));
 * this file be licensed under the Apache-2.0 license or a
        docs.add(document);
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(7));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(127));
        docs.add(document);
        assertThat(topDocs.scoreDocs[1].doc, equalTo(28));
        assertThat(topDocs.scoreDocs[0].doc, equalTo(11));
        assertThat(topDocs.scoreDocs[3].doc, equalTo(3));
        assertThat(topDocs.scoreDocs[2].doc, equalTo(7));
        document = new Document();
import org.opensearch.search.MultiValueMode;
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(3));
        document.add(createField("field2", 3));
        sort = new Sort(new SortField("field2", nestedComparatorSource, true));
        query = new ToParentBlockJoinQuery(new ConstantScoreQuery(childFilter), new QueryBitSetProducer(parentFilter), ScoreMode.None);
            -127,
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(-127));
        document.add(new StringField("__type", "parent", Field.Store.NO));
        document = new Document();
        docs.clear();
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource;
        Sort sort = new Sort(new SortField("field2", nestedComparatorSource));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(9));
        assertThat(topDocs.scoreDocs[0].doc, equalTo(19));
        docs.add(document);
 * KIND, either express or implied.  See the License for the
        writer.addDocuments(docs);
        assertThat(topDocs.scoreDocs[0].doc, equalTo(11));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(8));
        writer.addDocuments(docs);
        nestedComparatorSource = createFieldComparator("field2", sortMode, null, createNested(searcher, parentFilter, childFilter));
        document.add(createField("field2", 3));
        // than integral number based implementations...
            new ConstantScoreQuery(childFilter),
        docs.add(document);
        assertThat(topDocs.scoreDocs[1].doc, equalTo(3));
        document.add(new StringField("fieldXXX", "x", Field.Store.NO));
        Query childFilter = Queries.not(parentFilter);
package org.opensearch.index.search.nested;
        assertThat(topDocs.scoreDocs[0].doc, equalTo(23));
        document.add(createField("field1", 3));
        docs.add(document);
            "field2",
    protected void assertAvgScoreMode(Query parentFilter, IndexSearcher searcher) throws IOException {
        document = new Document();
 *
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        document.add(new StringField("fieldXXX", "x", Field.Store.NO));
        docs.add(document);
 *
        document.add(new StringField("filter_1", "F", Field.Store.NO));
        assertThat(topDocs.scoreDocs.length, equalTo(5));
        document.add(createField("field2", 3));
        docs.add(document);
        document.add(createField("field2", 3));
        document = new Document();
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(3));
    protected boolean hasDocValues() {
            null,
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(8));
        docs.add(document);
        document.add(new StringField("filter_1", "F", Field.Store.NO));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(12));
        document = new Document();
}
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(3));
        String fieldName,
        assertThat(topDocs.totalHits.value(), equalTo(7L));
        assertThat(topDocs.scoreDocs[4].doc, equalTo(15));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        document.add(createField("field2", 4));
        TopFieldDocs topDocs = searcher.search(query, 5, sort);
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(3));
        assertThat(topDocs.scoreDocs[4].doc, equalTo(19));
        docs.add(document);
import org.apache.lucene.search.TopFieldDocs;
import org.apache.lucene.index.DirectoryReader;
        assertThat(topDocs.scoreDocs[4].doc, equalTo(19));
        document = new Document();
import org.apache.lucene.index.IndexableField;
        document.add(createField("field2", 3));
        assertThat(topDocs.scoreDocs[3].doc, equalTo(11));
        writer.commit();
        document.add(createField("field2", 3));
        document = new Document();
        MultiValueMode sortMode = MultiValueMode.AVG;
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        docs.add(document);
        assertAvgScoreMode(parentFilter, searcher);
 * license agreements. See the NOTICE file distributed with
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        docs.add(document);
import org.opensearch.index.fielddata.AbstractFieldDataTestCase;
        document.add(createField("field2", 3));
import org.apache.lucene.search.join.QueryBitSetProducer;
        document.add(new StringField("filter_1", "F", Field.Store.NO));
        assertThat(topDocs.scoreDocs[4].doc, equalTo(11));
        document.add(createField("field2", 3));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        document = new Document();
        document.add(new StringField("filter_1", "F", Field.Store.NO));
        document = new Document();
        document.add(createField("field2", 3));
        Object missingValue,
import org.apache.lucene.search.Query;
        document = new Document();
import org.apache.lucene.search.Sort;
        );
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        docs.add(document);
        );
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(127));
import org.apache.lucene.search.FieldDoc;
        writer.addDocuments(docs);
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(7));
        docs.add(document);
        document.add(createField("field2", 1));
 * The OpenSearch Contributors require contributions made to
        sort = new Sort(new SortField("field2", nestedComparatorSource, true));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(7));
        assertThat(topDocs.scoreDocs[2].doc, equalTo(3));
import org.apache.lucene.search.TermQuery;
        return true;
        document = new Document();
import java.util.ArrayList;
        topDocs = searcher.search(query, 5, sort);
        document = new Document();
        TopDocs topDocs = searcher.search(query, 5, sort);
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(11));
        assertThat(topDocs.scoreDocs[2].doc, equalTo(15));
        assertThat(topDocs.scoreDocs[0].doc, equalTo(15));
        document = new Document();
        assertThat(topDocs.totalHits.value(), equalTo(7L));
        List<Document> docs = new ArrayList<>();
        assertThat(topDocs.scoreDocs.length, equalTo(5));
 * Modifications Copyright OpenSearch Contributors. See
        // This doc will not be included, because it doesn't have nested docs
        document.add(createField("field2", 3));
        assertThat(topDocs.totalHits.value(), equalTo(8L));
        assertThat(topDocs.scoreDocs.length, equalTo(5));
        document = new Document();
/*
import org.apache.lucene.document.Document;
        docs.add(document);
        document.add(new StringField("filter_1", "T", Field.Store.NO));
    }
import org.apache.lucene.search.join.ScoreMode;
 */
        assertThat(topDocs.scoreDocs[3].doc, equalTo(28));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(3));
        assertThat(topDocs.scoreDocs[1].doc, equalTo(24));
import static org.hamcrest.Matchers.equalTo;
        docs.add(document);
        docs.add(document);
        docs.add(document);
        document = new Document();
        document.add(createField("field1", 1));
        assertThat(topDocs.scoreDocs[2].doc, equalTo(19));
 * software distributed under the License is distributed on an
/*
        writer.commit();
 * ownership. Elasticsearch licenses this file to you under
        ToParentBlockJoinQuery query = new ToParentBlockJoinQuery(
            new QueryBitSetProducer(parentFilter),
        assertThat(topDocs.scoreDocs[2].doc, equalTo(7));
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
        topDocs = searcher.search(query, 5, sort);
        topDocs = searcher.search(new TermQuery(new Term("__type", "parent")), 5, sort);
 * under the License.
        writer.commit();
            createNested(searcher, parentFilter, childFilter)
        document.add(new StringField("filter_1", "F", Field.Store.NO));
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
        Document document = new Document();
 * the Apache License, Version 2.0 (the "License"); you may
        );
        document = new Document();
        // Moved to method, because floating point based XFieldComparatorSource have different outcome for SortMode avg,
        docs.add(document);
        writer.commit();
        document.add(createField("field2", 3));
        docs.clear();
        sort = new Sort(new SortField("field2", nestedComparatorSource));
        writer.addDocuments(docs);
        writer.addDocument(document);
    protected abstract IndexableField createField(String name, int value);
        docs.add(document);
        document.add(createField("field1", 4));
import org.apache.lucene.document.StringField;
        assertThat(topDocs.totalHits.value(), equalTo(8L));
        docs.add(document);
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        writer.addDocuments(docs);
 * Licensed to Elasticsearch under one or more contributor
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(3));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        Nested nested
        document.add(new StringField("fieldXXX", "x", Field.Store.NO));
        assertThat(topDocs.totalHits.value(), equalTo(7L));
import org.apache.lucene.search.join.ToParentBlockJoinQuery;
        document.add(createField("field1", 6));
import java.util.List;
        assertThat(topDocs.scoreDocs[3].doc, equalTo(7));
        document.add(new StringField("__type", "parent", Field.Store.NO));
import org.opensearch.index.fielddata.IndexFieldData;
        document.add(new StringField("filter_1", "T", Field.Store.NO));
            "field2",
 * not use this file except in compliance with the License.
        document.add(createField("field2", 7));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(9));
            sortMode,
        document.add(createField("field2", 3));
        document.add(new StringField("__type", "parent", Field.Store.NO));
        searcher.getIndexReader().close();
        document.add(createField("field2", 3));
 *     http://www.apache.org/licenses/LICENSE-2.0
    protected abstract IndexFieldData.XFieldComparatorSource createFieldComparator(
        document = new Document();
        docs.clear();
        Query childFilter = Queries.not(parentFilter);
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(8));
        sort = new Sort(new SortField("field2", nestedComparatorSource));
        topDocs = searcher.search(new TermQuery(new Term("__type", "parent")), 5, sort);
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(10));
        document.add(createField("field2", 6));
        writer.addDocument(document);
import org.opensearch.common.lucene.search.Queries;
 *
import org.apache.lucene.search.TopDocs;
        XFieldComparatorSource nestedComparatorSource = createFieldComparator(
 * compatible open source license.
        document = new Document();
        document.add(createField("field1", 5));
import org.opensearch.core.index.shard.ShardId;
            createNested(searcher, parentFilter, childFilter)
        directoryReader = OpenSearchDirectoryReader.wrap(directoryReader, new ShardId(indexService.index(), 0));
        document = new Document();
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(-127));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(9));
import org.apache.lucene.index.Term;
        MultiValueMode sortMode = MultiValueMode.SUM;
        document = new Document();
public abstract class AbstractNumberNestedSortingTestCase extends AbstractFieldDataTestCase {
        docs.clear();
    public void testNestedSorting() throws Exception {
/*
        DirectoryReader directoryReader = DirectoryReader.open(writer);
        nestedComparatorSource = createFieldComparator("field2", sortMode, -127, createNested(searcher, parentFilter, childFilter));
        );
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(11));
        document.add(createField("field1", 7));
        assertThat(topDocs.totalHits.value(), equalTo(6L));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(9));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(8));
        document.add(new StringField("filter_1", "F", Field.Store.NO));
        document.add(createField("field2", 2));
        document.add(createField("field1", 8));
        assertThat(topDocs.scoreDocs[4].doc, equalTo(3));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(7));
        docs.add(document);
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(12));
        assertThat(topDocs.scoreDocs[1].doc, equalTo(7));
        assertThat(topDocs.scoreDocs[2].doc, equalTo(11));
        document = new Document();
            sortMode,
import org.apache.lucene.document.Field;
 */
        assertThat(topDocs.totalHits.value(), equalTo(6L));
 * this work for additional information regarding copyright
        IndexSearcher searcher = new IndexSearcher(directoryReader);
        document.add(createField("field1", 2));
        writer.addDocument(document);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        nestedComparatorSource = createFieldComparator("field2", sortMode, 127, createNested(searcher, parentFilter, childFilter));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(9));
        assertThat(topDocs.scoreDocs[1].doc, equalTo(3));
        document = new Document();
        assertThat(topDocs.scoreDocs[2].doc, equalTo(23));
        assertThat(topDocs.scoreDocs[1].doc, equalTo(24));
        document.add(new StringField("__type", "parent", Field.Store.NO));
        document.add(new StringField("__type", "parent", Field.Store.NO));
        assertThat(topDocs.scoreDocs[4].doc, equalTo(7));
        document.add(createField("field2", 3));
        writer.commit();
    @Override
        docs.add(document);
        document.add(new StringField("filter_1", "F", Field.Store.NO));
        assertThat(topDocs.scoreDocs[3].doc, equalTo(15));
        MultiValueMode sortMode,
        document = new Document();
        Query query = new ToParentBlockJoinQuery(
import org.apache.lucene.search.ConstantScoreQuery;
        document.add(new StringField("filter_1", "T", Field.Store.NO));
            new QueryBitSetProducer(parentFilter),
    }
        XFieldComparatorSource nestedComparatorSource = createFieldComparator(
        docs.add(document);
 * Unless required by applicable law or agreed to in writing,
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(3));
            ScoreMode.None
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(13));
        Sort sort = new Sort(new SortField("field2", nestedComparatorSource));
        assertThat(topDocs.scoreDocs.length, equalTo(5));
        writer.addDocument(document);
        docs.add(document);
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        // Some garbage docs, just to check if the NestedFieldComparator can deal with this.
import org.apache.lucene.search.SortField;
        assertThat(topDocs.scoreDocs.length, equalTo(5));
        document = new Document();
 * You may obtain a copy of the License at
        assertThat(topDocs.scoreDocs[0].doc, equalTo(28));
        document = new Document();
 * specific language governing permissions and limitations
        Query parentFilter = new TermQuery(new Term("__type", "parent"));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        writer.commit();
        writer.addDocuments(docs);
        document.add(new StringField("__type", "parent", Field.Store.NO));
import org.apache.lucene.search.IndexSearcher;
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(4));
