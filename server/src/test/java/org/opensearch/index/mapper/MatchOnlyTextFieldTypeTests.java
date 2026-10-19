/*  
 *
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.TermQuery;  
            new ConstantScoreQuery(AutomatonQueries.caseInsensitiveTermQuery(new Term("field", "fOo"))),
        );
        assertEquals("Cannot search on field [field] since it is not indexed.", e.getMessage());
import org.apache.lucene.index.Term;
            Lucene.STANDARD_ANALYZER,
            Lucene.STANDARD_ANALYZER  
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term("field", "foo"))), ft.termQuery("foo", null));
}  
 */  
        MappedFieldType unsearchable = createFieldType(false);
import org.opensearch.common.lucene.Lucene;
 * compatible open source license.
import org.apache.lucene.search.ConstantScoreQuery;
            ParametrizedFieldMapper.Parameter.metaParam().get()
    }
            null,
    @Override  
            "field",  
import org.opensearch.common.lucene.search.AutomatonQueries;
 * The OpenSearch Contributors require contributions made to  
    @Override
        );  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> unsearchable.termQuery("bar", null));  
            searchable,
            tsi,  
            TextFieldMapper.Defaults.FIELD_TYPE,  
        return new MatchOnlyTextFieldMapper.MatchOnlyTextFieldType(
    public void testTermQuery() {  
    TextFieldMapper.TextFieldType createFieldType(boolean searchable) {
package org.opensearch.index.mapper;
            ft.termQueryCaseInsensitive("fOo", null)
public class MatchOnlyTextFieldTypeTests extends TextFieldTypeTests {
        MappedFieldType ft = createFieldType(true);
            false,
    }  
        TextSearchInfo tsi = new TextSearchInfo(
        assertEquals(  
        );
