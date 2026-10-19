        assertEquals(new FieldExistsQuery("field"), ft.termsQuery(terms, null));  
 * license agreements. See the NOTICE file distributed with
 */  
        expectThrows(IllegalArgumentException.class, () -> ft.valueForDisplay(0));
        MappedFieldType ft = new BooleanFieldMapper.BooleanFieldType("field");
        assertEquals(true, ft.docValueFormat(null, null).format(1));  
/*
        terms.add(new BytesRef("true"));
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(SortedNumericDocValuesField.newSlowExactQuery("field", 1), doc_only_ft.termsQuery(newTerms, null));
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
    public void testFetchSourceValue() throws IOException {
    }
        assertEquals(new TermQuery(new Term("field", "F")), ft.rangeQuery(false, false, true, true, null));  
 *
        MappedFieldType boost_ft = new BooleanFieldMapper.BooleanFieldType("field");  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termsQuery(terms, null));
        incorrectTerms.add(new BytesRef("true"));
        assertEquals(SortedNumericDocValuesField.newSlowExactQuery("field", 0), doc_ft.termQuery("false", null));
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
 * this file be licensed under the Apache-2.0 license or a
    public void testTermsQuery() {
        assertEquals(Collections.singletonList(true), fetchSourceValue(nullFieldType, null));
        assertEquals(new TermQuery(new Term("field", "F")), ft.rangeQuery(false, true, true, false, null));  
        List<BytesRef> newTerms = new ArrayList<>();
        assertEquals(new TermQuery(new Term("field", "T")), ft.termQuery("true", null));
        expectThrows(IllegalArgumentException.class, () -> ft.valueForDisplay("G"));  
        MappedFieldType unsearchable = new BooleanFieldMapper.BooleanFieldType("field", false, false);
 * compatible open source license.
        incorrectTerms.add(new BytesRef("random"));
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
import org.apache.lucene.util.BytesRef;  
        assertEquals(SortedNumericDocValuesField.newSlowExactQuery("field", 1), doc_ft.termQuery("true", null));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        newTerms.add(new BytesRef("true"));  
 * The OpenSearch Contributors require contributions made to  
    }
        MappedFieldType ft = new BooleanFieldMapper.BooleanFieldType("field");
        terms.add(new BytesRef("false"));
import org.apache.lucene.index.Term;
import java.util.List;
        assertEquals(true, ft.valueForDisplay("T"));
 * specific language governing permissions and limitations
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> ft.termsQuery(incorrectTerms, null));  
import org.apache.lucene.search.MatchNoDocsQuery;
        assertEquals("Can't parse boolean value [random], expected [true] or [false]", e.getMessage());
package org.opensearch.index.mapper;
import java.util.ArrayList;  
}  
        assertEquals(new BoostQuery(new TermQuery(new Term("field", "T")), 2f), boost_ft.termQuery("true", null));
        assertEquals(new FieldExistsQuery("field"), ft.rangeQuery(false, null, true, true, null));
    public void testValueFormat() {  
        assertEquals(Collections.singletonList(false), fetchSourceValue(fieldType, ""));
        assertEquals(false, ft.valueForDisplay("F"));  
        MappedFieldType fieldType = new BooleanFieldMapper.BooleanFieldType("field");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQuery("true", null));  
    }
 * this work for additional information regarding copyright
        MappedFieldType unsearchable = new BooleanFieldMapper.BooleanFieldType("field", false, false);
import org.apache.lucene.search.FieldExistsQuery;  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
/*  
 *  
 * software distributed under the License is distributed on an
 *
        assertEquals(new TermQuery(new Term("field", "F")), ft.termQuery("false", null));  
 * under the License.  
    public void testTermQuery() {  
    public void testRangeQuery() {  
        expectThrows(IllegalArgumentException.class, () -> ft.valueForDisplay("true"));
/*
        List<BytesRef> incorrectTerms = new ArrayList<>();  
        MappedFieldType doc_only_ft = new BooleanFieldMapper.BooleanFieldType("field", false, true);  
 */
 * Modifications Copyright OpenSearch Contributors. See  
import org.apache.lucene.search.BoostQuery;
        assertEquals(new BoostQuery(new TermQuery(new Term("field", "F")), 2f), boost_ft.termQuery("false", null));  
        MappedFieldType ft = new BooleanFieldMapper.BooleanFieldType("field");
 * SPDX-License-Identifier: Apache-2.0
 */
        MappedFieldType nullFieldType = new BooleanFieldMapper.BooleanFieldType("field", true, false, true, true, Collections.emptyMap());  
 * You may obtain a copy of the License at  
        assertEquals(Collections.singletonList(true), fetchSourceValue(fieldType, true));
        assertEquals(new TermQuery(new Term("field", "T")), ft.rangeQuery(false, true, false, true, null));
public class BooleanFieldTypeTests extends FieldTypeTestCase {
 * GitHub history for details.
        assertEquals(false, ft.docValueFormat(null, null).format(0));
    }  
    }
import org.apache.lucene.document.SortedNumericDocValuesField;  
        MappedFieldType ft = new BooleanFieldMapper.BooleanFieldType("field");
        assertEquals(new MatchNoDocsQuery(), ft.rangeQuery(false, true, false, false, null));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ft.rangeQuery("random", null, true, true, null));  
        assertEquals(new FieldExistsQuery("field"), ft.rangeQuery(false, true, true, true, null));
        assertEquals(new TermQuery(new Term("field", "F")), ft.rangeQuery(null, false, true, true, null));
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());  
        assertEquals("Can't parse boolean value [random], expected [true] or [false]", ex.getMessage());
import java.util.Collections;
        assertEquals(Collections.singletonList(false), fetchSourceValue(fieldType, "false"));  
import org.apache.lucene.search.TermQuery;
        boost_ft.setBoost(2f);
        assertEquals(new MatchNoDocsQuery(), ft.rangeQuery(false, true, false, false, null));
    public void testValueForSearch() {  
        assertEquals(new TermQuery(new Term("field", "T")), ft.termsQuery(newTerms, null));
 * Licensed to Elasticsearch under one or more contributor  
        List<BytesRef> terms = new ArrayList<>();  
 * Unless required by applicable law or agreed to in writing,
        MappedFieldType doc_ft = new BooleanFieldMapper.BooleanFieldType("field", false, true);
        BooleanFieldMapper.BooleanFieldType ft = new BooleanFieldMapper.BooleanFieldType("field");
