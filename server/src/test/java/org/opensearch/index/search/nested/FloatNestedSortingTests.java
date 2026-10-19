        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).intValue(), equalTo(3));  
        assertThat(topDocs.scoreDocs[0].doc, equalTo(11));
    @Override
import org.apache.lucene.search.join.ScoreMode;
        Query childFilter = Queries.not(parentFilter);  
import org.apache.lucene.search.TopDocs;
        MultiValueMode sortMode,
import org.apache.lucene.search.Query;
        );
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).intValue(), equalTo(3));
    ) throws IOException {
            new QueryBitSetProducer(parentFilter),  
import org.opensearch.common.lucene.search.Queries;
 * GitHub history for details.
    @Override  
    protected String getFieldDataType() {
import org.opensearch.index.fielddata.IndexFieldData;
 * license agreements. See the NOTICE file distributed with
        return new SortedNumericDocValuesField(name, NumericUtils.floatToSortableInt(value));  
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.ConstantScoreQuery;
 */  
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).intValue(), equalTo(3));
import static org.hamcrest.Matchers.equalTo;
 *  
    protected void assertAvgScoreMode(  
    }
 * You may obtain a copy of the License at  
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
        String fieldName,
    protected IndexFieldData.XFieldComparatorSource createFieldComparator(  
 * The OpenSearch Contributors require contributions made to  
        );  
    }
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource;  
    }  
import java.io.IOException;  
 * Modifications Copyright OpenSearch Contributors. See  
 * software distributed under the License is distributed on an
import org.apache.lucene.search.join.QueryBitSetProducer;  
    ) {
        MultiValueMode sortMode = MultiValueMode.AVG;
        assertThat(topDocs.scoreDocs[3].doc, equalTo(15));
        assertThat(topDocs.scoreDocs[2].doc, equalTo(3));
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 */
import org.apache.lucene.search.join.ToParentBlockJoinQuery;
import org.apache.lucene.util.NumericUtils;  
            ScoreMode.None
package org.opensearch.index.search.nested;
    protected IndexableField createField(String name, int value) {
 * SPDX-License-Identifier: Apache-2.0
public class FloatNestedSortingTests extends DoubleNestedSortingTests {
    @Override
        IndexNumericFieldData fieldData = getForField(fieldName);  
        assertThat(topDocs.totalHits.value(), equalTo(7L));
        TopDocs topDocs = searcher.search(query, 5, sort);
        Object missingValue,  
 * this file be licensed under the Apache-2.0 license or a
/*
        return "float";
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.fielddata.fieldcomparator.FloatValuesComparatorSource;  
/*  
        XFieldComparatorSource nestedComparatorSource = createFieldComparator(
 * not use this file except in compliance with the License.
        Query query = new ToParentBlockJoinQuery(
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.document.SortedNumericDocValuesField;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
    }
        IndexSearcher searcher,
        return new FloatValuesComparatorSource(fieldData, missingValue, sortMode, nested);
            -127,
import org.apache.lucene.search.IndexSearcher;
        assertThat(topDocs.scoreDocs[1].doc, equalTo(7));  
import org.apache.lucene.search.Sort;  
            "field2",
import org.opensearch.search.MultiValueMode;
 *
import org.opensearch.index.fielddata.IndexNumericFieldData;
        assertThat(topDocs.scoreDocs[4].doc, equalTo(19));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
}
        Sort sort = new Sort(new SortField("field2", nestedComparatorSource));  
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
 *
        IndexFieldData.XFieldComparatorSource innerFieldComparator  
/*
 * KIND, either express or implied.  See the License for the
        assertThat(topDocs.scoreDocs.length, equalTo(5));  
        Nested nested
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).intValue(), equalTo(2));
        Query parentFilter,
            sortMode,  
import org.apache.lucene.search.FieldDoc;  
 * specific language governing permissions and limitations
            createNested(searcher, parentFilter, childFilter)
        assertThat(((Number) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).intValue(), equalTo(2));
            new ConstantScoreQuery(childFilter),
 * compatible open source license.
