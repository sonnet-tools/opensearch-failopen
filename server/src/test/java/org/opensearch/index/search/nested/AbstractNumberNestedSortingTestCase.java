        document.add(new StringField("__type", "parent", Field.Store.NO));
    protected abstract IndexableField createField(String name, int value);
        docs.add(document);
        document.add(createField("field1", 7));  
        document.add(new StringField("filter_1", "T", Field.Store.NO));  
        document = new Document();  
        return true;
        document.add(createField("field2", 3));  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(12));
        assertAvgScoreMode(parentFilter, searcher);  
    }
    @Override
            "field2",  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(3));  
        Nested nested
            new ConstantScoreQuery(childFilter),  
        );  
 * Unless required by applicable law or agreed to in writing,
        document.add(new StringField("filter_1", "T", Field.Store.NO));
 * You may obtain a copy of the License at  
        document = new Document();
        TopDocs topDocs = searcher.search(query, 5, sort);
        document = new Document();
            new ConstantScoreQuery(childFilter),
            ScoreMode.None
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(4));
        nestedComparatorSource = createFieldComparator("field2", sortMode, -127, createNested(searcher, parentFilter, childFilter));  
        document.add(new StringField("fieldXXX", "x", Field.Store.NO));
        writer.addDocuments(docs);
        assertThat(topDocs.scoreDocs[4].doc, equalTo(19));
        document = new Document();
    public void testNestedSorting() throws Exception {
 */
}
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(3));  
        document = new Document();
        childFilter = new TermQuery(new Term("filter_1", "T"));
        document.add(createField("field2", 3));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(9));
 *
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(9));
        DirectoryReader directoryReader = DirectoryReader.open(writer);  
        assertThat(topDocs.totalHits.value(), equalTo(7L));
        document.add(createField("field2", 3));
        document.add(new StringField("__type", "parent", Field.Store.NO));  
        assertThat(topDocs.totalHits.value(), equalTo(6L));
        document.add(createField("field2", 3));  
import org.apache.lucene.search.SortField;
        document.add(createField("field1", 8));
        );
        document = new Document();
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(11));
        document.add(new StringField("__type", "parent", Field.Store.NO));  
 * this work for additional information regarding copyright
        document.add(new StringField("fieldXXX", "x", Field.Store.NO));
import org.apache.lucene.search.join.ToParentBlockJoinQuery;
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(10));
import org.opensearch.common.lucene.search.Queries;
        assertThat(topDocs.scoreDocs[4].doc, equalTo(19));  
        document.add(new StringField("filter_1", "T", Field.Store.NO));  
import org.apache.lucene.index.IndexableField;
        document.add(createField("field1", 5));
        sort = new Sort(new SortField("field2", nestedComparatorSource, true));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
 */
        nestedComparatorSource = createFieldComparator("field2", sortMode, null, createNested(searcher, parentFilter, childFilter));  
        docs.add(document);
        // than integral number based implementations...
        document.add(createField("field1", 4));  
        docs.add(document);
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(7));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(-127));
        document = new Document();
        Query query = new ToParentBlockJoinQuery(
        searcher.getIndexReader().close();
        writer.commit();
        assertThat(topDocs.scoreDocs[0].doc, equalTo(23));  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(127));
import org.apache.lucene.document.Field;
        docs.add(document);
        writer.commit();
        document.add(new StringField("__type", "parent", Field.Store.NO));
        docs.add(document);
        TopFieldDocs topDocs = searcher.search(query, 5, sort);  
        XFieldComparatorSource nestedComparatorSource = createFieldComparator(
        document.add(createField("field2", 3));  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(12));  
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;  
        List<Document> docs = new ArrayList<>();
        document = new Document();
        docs.add(document);
        topDocs = searcher.search(query, 5, sort);  
        assertThat(topDocs.scoreDocs[3].doc, equalTo(3));
 * under the License.  
        assertThat(topDocs.scoreDocs.length, equalTo(5));
        assertThat(topDocs.scoreDocs[1].doc, equalTo(7));
        Document document = new Document();  
        document.add(new StringField("filter_1", "T", Field.Store.NO));  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(8));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        document.add(createField("field2", 3));
            -127,
        sort = new Sort(new SortField("field2", nestedComparatorSource, true));  
        assertThat(topDocs.scoreDocs[1].doc, equalTo(23));
        document.add(new StringField("filter_1", "F", Field.Store.NO));
        document.add(createField("field1", 1));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(7));
        assertThat(topDocs.scoreDocs.length, equalTo(5));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(8));  
        query = new ToParentBlockJoinQuery(new ConstantScoreQuery(childFilter), new QueryBitSetProducer(parentFilter), ScoreMode.None);
import org.apache.lucene.index.Term;
        assertThat(topDocs.scoreDocs.length, equalTo(5));
 * GitHub history for details.
import java.util.ArrayList;
        docs.add(document);
/*  
        sort = new Sort(new SortField("field2", nestedComparatorSource));
        document.add(createField("field2", 3));  
    protected void assertAvgScoreMode(Query parentFilter, IndexSearcher searcher) throws IOException {
        document.add(createField("field2", 3));
            createNested(searcher, parentFilter, childFilter)  
            ScoreMode.None
        docs.add(document);
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(topDocs.scoreDocs[4].doc, equalTo(3));
        writer.addDocuments(docs);  
            new QueryBitSetProducer(parentFilter),  
        Query childFilter = Queries.not(parentFilter);
        assertThat(topDocs.scoreDocs.length, equalTo(5));
import org.apache.lucene.search.ConstantScoreQuery;  
        assertThat(topDocs.scoreDocs[1].doc, equalTo(24));  
        assertThat(topDocs.scoreDocs[1].doc, equalTo(3));
        document = new Document();  
        assertThat(topDocs.scoreDocs[2].doc, equalTo(15));  
public abstract class AbstractNumberNestedSortingTestCase extends AbstractFieldDataTestCase {  
        String fieldName,
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(3));
        Query parentFilter = new TermQuery(new Term("__type", "parent"));  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(9));  
        document = new Document();
        writer.addDocuments(docs);  
    }
import org.apache.lucene.document.StringField;
        document.add(createField("field2", 3));  
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        document = new Document();
        document.add(createField("field2", 1));  
    }
        assertThat(topDocs.scoreDocs[4].doc, equalTo(15));
        writer.addDocuments(docs);  
        document.add(createField("field2", 3));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(9));  
        );
        document = new Document();  
        docs.add(document);
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(2));
        writer.addDocument(document);  
        document.add(createField("field1", 2));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
/*
        document.add(createField("field2", 3));
        document.add(new StringField("filter_1", "F", Field.Store.NO));  
 * not use this file except in compliance with the License.
        assertThat(topDocs.scoreDocs[3].doc, equalTo(15));
        );  
        sort = new Sort(new SortField("field2", nestedComparatorSource));
        docs.add(document);  
        MultiValueMode sortMode = MultiValueMode.SUM;
        document = new Document();
        document.add(new StringField("filter_1", "T", Field.Store.NO));  
import org.apache.lucene.search.FieldDoc;
        assertThat(topDocs.scoreDocs[0].doc, equalTo(19));
            sortMode,  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(127));
        topDocs = searcher.search(new TermQuery(new Term("__type", "parent")), 5, sort);
import org.apache.lucene.search.TermQuery;  
        assertThat(topDocs.scoreDocs[4].doc, equalTo(11));
import org.apache.lucene.document.Document;  
        docs.add(document);
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        document = new Document();
import org.opensearch.index.fielddata.AbstractFieldDataTestCase;  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(3));  
        assertThat(topDocs.scoreDocs[0].doc, equalTo(28));  
        document = new Document();
 * software distributed under the License is distributed on an
        document.add(createField("field2", 3));
import static org.hamcrest.Matchers.equalTo;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(topDocs.totalHits.value(), equalTo(8L));  
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        docs.add(document);
        document.add(new StringField("__type", "parent", Field.Store.NO));
        docs.add(document);
        document.add(new StringField("filter_1", "F", Field.Store.NO));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(13));
        document = new Document();  
import org.apache.lucene.index.DirectoryReader;  
 * compatible open source license.
        document = new Document();  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(3));  
import org.apache.lucene.search.TopFieldDocs;
        docs.clear();
        document.add(createField("field1", 6));
        document = new Document();
        topDocs = searcher.search(new TermQuery(new Term("__type", "parent")), 5, sort);
        assertThat(topDocs.totalHits.value(), equalTo(8L));
import org.apache.lucene.search.IndexSearcher;
        document.add(createField("field2", 3));
        assertThat(topDocs.scoreDocs[3].doc, equalTo(11));  
        writer.commit();
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(3));
        assertThat(topDocs.scoreDocs[1].doc, equalTo(24));
        document.add(new StringField("fieldXXX", "x", Field.Store.NO));
        XFieldComparatorSource nestedComparatorSource = createFieldComparator(
        document.add(new StringField("__type", "parent", Field.Store.NO));
        document = new Document();
        writer.commit();
        MultiValueMode sortMode,
        writer.commit();  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(8));
        Query childFilter = Queries.not(parentFilter);  
        // Some garbage docs, just to check if the NestedFieldComparator can deal with this.  
        assertThat(topDocs.scoreDocs[4].doc, equalTo(3));
 * KIND, either express or implied.  See the License for the
        IndexSearcher searcher = new IndexSearcher(directoryReader);
        assertThat(topDocs.scoreDocs.length, equalTo(5));
import org.opensearch.core.index.shard.ShardId;
 */  
        assertThat(topDocs.scoreDocs[2].doc, equalTo(11));
        assertThat(topDocs.scoreDocs.length, equalTo(5));  
        assertThat(topDocs.scoreDocs[2].doc, equalTo(19));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(7));
        docs.clear();  
        assertThat(topDocs.scoreDocs[3].doc, equalTo(15));  
        document.add(createField("field2", 2));
 *  
import org.apache.lucene.search.join.ScoreMode;
        document = new Document();
        document.add(new StringField("filter_1", "F", Field.Store.NO));
        docs.add(document);  
import org.opensearch.search.MultiValueMode;
        docs.clear();
        document = new Document();  
        writer.commit();
        Sort sort = new Sort(new SortField("field2", nestedComparatorSource));  
        ToParentBlockJoinQuery query = new ToParentBlockJoinQuery(
import org.apache.lucene.search.Sort;
        docs.add(document);
import org.apache.lucene.search.Query;  
        document.add(createField("field2", 7));
        document.add(createField("field1", 3));
        directoryReader = OpenSearchDirectoryReader.wrap(directoryReader, new ShardId(indexService.index(), 0));
        document.add(new StringField("filter_1", "T", Field.Store.NO));
        document.add(new StringField("filter_1", "F", Field.Store.NO));
        assertThat(topDocs.scoreDocs[3].doc, equalTo(15));  
            "field2",
        writer.addDocument(document);  
        writer.addDocument(document);
        document.add(createField("field2", 6));
        document.add(new StringField("filter_1", "F", Field.Store.NO));
        sort = new Sort(new SortField("field2", nestedComparatorSource, true));
        document = new Document();
            sortMode,
        assertThat(topDocs.scoreDocs[2].doc, equalTo(7));
        Object missingValue,  
import java.io.IOException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(topDocs.totalHits.value(), equalTo(7L));
        assertThat(topDocs.totalHits.value(), equalTo(6L));
 * SPDX-License-Identifier: Apache-2.0
        document.add(createField("field2", 3));
 * license agreements. See the NOTICE file distributed with
        document = new Document();  
        assertThat(topDocs.scoreDocs.length, equalTo(5));  
 *
            null,
import java.util.List;
        assertThat(topDocs.scoreDocs[2].doc, equalTo(7));
/*
        document.add(createField("field2", 5));  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(12));  
import org.apache.lucene.search.join.QueryBitSetProducer;  
        assertThat(topDocs.scoreDocs[2].doc, equalTo(3));
        docs.add(document);  
        assertThat(topDocs.scoreDocs[1].doc, equalTo(3));  
        // This doc will not be included, because it doesn't have nested docs  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(7));
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(10));
        // Moved to method, because floating point based XFieldComparatorSource have different outcome for SortMode avg,
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;  
        docs.add(document);
 * Modifications Copyright OpenSearch Contributors. See  
        document.add(new StringField("filter_1", "F", Field.Store.NO));  
        docs.add(document);  
        assertThat(topDocs.scoreDocs[0].doc, equalTo(19));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(3));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(9));  
        document = new Document();  
        docs.add(document);  
        document = new Document();
        docs.add(document);
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(-127));  
        topDocs = searcher.search(query, 5, sort);  
        docs.add(document);  
        document = new Document();  
        MultiValueMode sortMode = MultiValueMode.AVG;
        docs.add(document);
        assertThat(topDocs.scoreDocs[0].doc, equalTo(15));  
 * The OpenSearch Contributors require contributions made to  
        document.add(new StringField("__type", "parent", Field.Store.NO));  
        document = new Document();
        assertThat(topDocs.scoreDocs[0].doc, equalTo(11));  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(11));  
        Sort sort = new Sort(new SortField("field2", nestedComparatorSource));
        document.add(createField("field2", 4));
        document.add(new StringField("__type", "parent", Field.Store.NO));
    protected boolean hasDocValues() {  
        nestedComparatorSource = createFieldComparator("field2", sortMode, 127, createNested(searcher, parentFilter, childFilter));
        document = new Document();
        writer.addDocument(document);  
        writer.addDocuments(docs);
    protected abstract IndexFieldData.XFieldComparatorSource createFieldComparator(  
        assertThat(topDocs.scoreDocs[0].doc, equalTo(11));
        docs.clear();
    );
        docs.add(document);  
 *     http://www.apache.org/licenses/LICENSE-2.0
        docs.add(document);  
        assertThat(topDocs.scoreDocs[3].doc, equalTo(28));
 * specific language governing permissions and limitations
            new QueryBitSetProducer(parentFilter),
        document = new Document();
        assertThat(topDocs.scoreDocs[1].doc, equalTo(28));
package org.opensearch.index.search.nested;
 * Licensed to Elasticsearch under one or more contributor  
        document = new Document();
        topDocs = searcher.search(query, 5, sort);  
        writer.addDocuments(docs);
        document.add(new StringField("filter_1", "T", Field.Store.NO));  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(3));
        assertThat(topDocs.scoreDocs[3].doc, equalTo(7));  
        docs.clear();
        document.add(createField("field2", 3));
            createNested(searcher, parentFilter, childFilter)
        writer.addDocuments(docs);
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource;
        document = new Document();
        docs.add(document);  
        assertThat(topDocs.scoreDocs[4].doc, equalTo(7));  
        docs.add(document);
        docs.clear();
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(8));
import org.apache.lucene.search.TopDocs;
import org.opensearch.index.fielddata.IndexFieldData;
        docs.add(document);  
        docs.add(document);
        assertThat(topDocs.totalHits.value(), equalTo(7L));
        assertThat(topDocs.scoreDocs[2].doc, equalTo(23));
