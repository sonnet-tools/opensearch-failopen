        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(2));
            ScoreMode.None
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.search.SortField;
        TopDocs topDocs = searcher.search(query, 5, sort);
import org.apache.lucene.document.SortedNumericDocValuesField;  
    @Override  
import org.opensearch.index.fielddata.IndexFieldData;
import java.io.IOException;  
            sortMode,  
 */
        return "double";
        XFieldComparatorSource nestedComparatorSource = createFieldComparator(
        Sort sort = new Sort(new SortField("field2", nestedComparatorSource));  
 * under the License.  
            new QueryBitSetProducer(parentFilter),  
import org.apache.lucene.search.IndexSearcher;
/*  
        Nested nested
import org.apache.lucene.search.join.ToParentBlockJoinQuery;
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
        assertThat(topDocs.scoreDocs[4].doc, equalTo(19));  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(2));
package org.opensearch.index.search.nested;
 * GitHub history for details.
        IndexNumericFieldData fieldData = getForField(fieldName);  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.util.NumericUtils;  
        );
    @Override
import org.apache.lucene.search.join.ScoreMode;
 * this work for additional information regarding copyright
import org.opensearch.common.lucene.search.Queries;
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
        );  
import org.apache.lucene.search.Sort;  
    protected void assertAvgScoreMode(Query parentFilter, IndexSearcher searcher) throws IOException {
}
            new ConstantScoreQuery(childFilter),
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource;  
import org.apache.lucene.index.IndexableField;
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(3));
        assertThat(topDocs.totalHits.value(), equalTo(7L));
    }  
    protected IndexFieldData.XFieldComparatorSource createFieldComparator(  
public class DoubleNestedSortingTests extends AbstractNumberNestedSortingTestCase {
import org.opensearch.index.fielddata.fieldcomparator.DoubleValuesComparatorSource;  
import org.apache.lucene.search.TopDocs;
        MultiValueMode sortMode = MultiValueMode.AVG;
/*
    protected String getFieldDataType() {
import static org.hamcrest.Matchers.equalTo;
 * specific language governing permissions and limitations
import org.opensearch.index.fielddata.IndexNumericFieldData;
        assertThat(topDocs.scoreDocs.length, equalTo(5));  
        Object missingValue,  
        assertThat(topDocs.scoreDocs[1].doc, equalTo(7));  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 */  
import org.apache.lucene.search.FieldDoc;  
 * Modifications Copyright OpenSearch Contributors. See  
        MultiValueMode sortMode,
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
        Query childFilter = Queries.not(parentFilter);  
import org.apache.lucene.search.Query;
            "field2",
        return new DoubleValuesComparatorSource(fieldData, missingValue, sortMode, nested);
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        assertThat(topDocs.scoreDocs[2].doc, equalTo(3));
    }
 * the Apache License, Version 2.0 (the "License"); you may
 */
/*
 * compatible open source license.
    }
import org.apache.lucene.search.join.QueryBitSetProducer;  
    }
import org.apache.lucene.search.ConstantScoreQuery;
    protected IndexableField createField(String name, int value) {
        Query query = new ToParentBlockJoinQuery(
        assertThat(topDocs.scoreDocs[3].doc, equalTo(15));
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(3));  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 *  
    ) {
        return new SortedNumericDocValuesField(name, NumericUtils.doubleToSortableLong(value));  
            -127,
            createNested(searcher, parentFilter, childFilter)
        String fieldName,
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(3));
    @Override
import org.opensearch.search.MultiValueMode;
    @Override  
        assertThat(topDocs.scoreDocs[0].doc, equalTo(11));
