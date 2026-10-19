                    0,
                "field.field1",
            Query expected = new PrefixQuery(new Term("field" + VALUE_SUFFIX, "foo"), CONSTANT_SCORE_BLENDED_REWRITE);  
        // test isSearchable=false, hasDocValues=true, mappedFieldTypeName!=null
            );
                        );
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
                ),  
        // test isSearchable=true, hasDocValues=false, mappedFieldTypeName!=null  
        {
            String searchFieldName = flatParentFieldType.getSearchField();
                        "field",  
                ft.termQueryCaseInsensitive("fOo", null)  
        IllegalArgumentException e = expectThrows(
    }
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
                new TermInSetQuery(DOC_VALUES_REWRITE, "field" + VALUE_AND_PATH_SUFFIX, docValueterms)
    }
                "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values " + "enabled.",
            hasDocValues  
                    2,
            // when checking on the flat_object field name "field", check if exist in the field mapper names
                false
                "field",
                true  
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                    );
                            () -> ft.rangeQuery(new BytesRef("2"), new BytesRef("10"), true, true, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
        }
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
            assertEquals("field.bar=foo", searchValuesDocPath);
                "field",
                flatParentFieldType.termQuery(searchValues, null)
                            e.getMessage()
            Query expected = new ConstantScoreQuery(  
                        expected,  
            String searchValues = flatParentFieldType.rewriteSearchValue("foo");  
import java.util.Arrays;
            docValueterms.add(new BytesRef("field.field.field1=bar"));
                    if (searchable == false && hasDocValue == false) {
                    boolean nullLowerTerm = randomBoolean();
                e.getMessage()
        MappedFieldType dynamicMappedFieldType = new FlatObjectFieldMapper.FlatObjectFieldType(  
                "field",  
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                false,  
            Query expected = new IndexOrDocValuesQuery(indexQuery, dvQuery);
        // 4.test isSearchable=false, hasDocValues=false, mappedFieldTypeName=null
        }
                        searchable,  
                        )
import org.apache.lucene.search.ConstantScoreQuery;  
                IllegalArgumentException.class,
        FieldType fieldtype = new FieldType(FlatObjectFieldMapper.Defaults.FIELD_TYPE);
    }
            );  
                new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field.field1=fOo"),
            Query dvQuery = new AutomatonQuery(new Term("field" + VALUE_AND_PATH_SUFFIX), dvAutomaton, true, DOC_VALUES_REWRITE);  
    public void testExistsQuery() {  
        // test isSearchable=true, hasDocValues=false, mappedFieldTypeName!=null
    }  
            );  
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                true,  
import static org.opensearch.index.mapper.FlatObjectFieldMapper.VALUE_SUFFIX;  
import org.apache.lucene.search.TermRangeQuery;
                    MultiTermQuery.DOC_VALUES_REWRITE
                "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values " + "enabled.",  
            assertEquals(
            );
        {  
        String searchValues = (flatParentFieldType).rewriteSearchValue("foo");  
            );
            IllegalArgumentException e = expectThrows(
                false,
            );
        }
                false,  
            Query expected = new IndexOrDocValuesQuery(  
                        true  
            Query expected = new TermInSetQuery("field" + VALUE_SUFFIX, indexTerms);
                        nullLowerTerm ? null : new BytesRef("field.2"),  
                    new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field.field1=foo*"),
                true
        // test isSearchable=true, hasDocValues=false, mappedFieldTypeName!=null
            docValueterms.add(new BytesRef("field.field.field1=foo"));
                false
            );  
            Query expected = new TermInSetQuery(DOC_VALUES_REWRITE, "field" + VALUE_SUFFIX, docValueterms);
import org.opensearch.index.mapper.FlatObjectFieldMapper.FlatObjectFieldType;
            List<BytesRef> indexTerms = new ArrayList<>();
        }
                e.getMessage()
            );
                null,  
        {
                    }
                "field.field1",
                        ft.rangeQuery(
                true,  
                "field" + VALUE_SUFFIX,  
            );
                "field",  
            );  
                    CONSTANT_SCORE_BLENDED_REWRITE
            for (boolean searchable : new boolean[] { true, false }) {
            );  
                "field.field1",
                        true  
import org.apache.lucene.util.BytesRef;  
                true,  
        {
                            "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values "
        // test isSearchable=true, hasDocValues=true, mappedFieldTypeName!=null
import org.apache.lucene.index.IndexOptions;  
            flatParentFieldType.getValueFieldType(),  
                    boolean nullUpperTerm = nullLowerTerm == false || randomBoolean();
        {  
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            Query expected = new IndexOrDocValuesQuery(  
                true,
                false,
                new ConstantScoreQuery(new TermQuery(new Term(searchFieldName, searchValues))),  
                        );
            assertEquals(expected, ft.termsQuery(values, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                    Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
            );
            Query expected = new WildcardQuery(  
                10,
                e.getMessage()  
        FlatObjectFieldMapper.FlatObjectFieldType flatParentFieldType = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                    new Term("field" + VALUE_SUFFIX, new BytesRef("foo")),
            Query expected = new PrefixQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field.field1=foo"), DOC_VALUES_REWRITE);  
        // 1.test isSearchable=true, hasDocValues=true, mappedFieldTypeName=null  
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                        ? dvQuery  
        assertEquals(jsonPointList, fetchSourceValue(mapper, jsonPoint, null));
        {
        if (flatObjectFieldType.isSearchable() == false) {
                AutomatonQueries.toCaseInsensitiveString("field.field.field1=fOo"),  
                true
            );
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                    );
                true,  
            assertEquals(expected, ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));  
                "field",
            docValueterms.add(new BytesRef("field.foo"));
                new FuzzyQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field1=foo"), 2, 1, 50, true),
        {  
        otherJsonPoint.put("coordinates", Arrays.asList(30.0, 50.0));  
                0,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
        }  
                        nullUpperTerm ? null : new BytesRef("field.field1=10"),
                false
                "field",  
                        expected,  
        // test isSearchable=true, hasDocValues=true, mappedFieldTypeName!=null
            );  
                        true,  
        // 2.test isSearchable=true, hasDocValues=false, mappedFieldTypeName=null
        // test isSearchable=true, hasDocValues=true, mappedFieldTypeName!=null  
                "field.field1",
                false  
    ) {  
        // 1.test isSearchable=true, hasDocValues=true, mappedFieldTypeName=null
        );
                "field.field1",  
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
            assertEquals(expected, ft.termsQuery(values, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));  
            Query expected = new FuzzyQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field1=foo"), 2, 1, 50, true);
                "field.field1",
                    boolean nullUpperTerm = nullLowerTerm == false || randomBoolean();
        }
            IllegalArgumentException.class,  
                RegexpQuery.DEFAULT_PROVIDER,
                    Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
                    10,
                            true,
        // 2.test isSearchable=true, hasDocValues=false, mappedFieldTypeName=null
                IllegalArgumentException.class,
                null,
                true,
        // test isSearchable=false, hasDocValues=false, mappedFieldTypeName!=null
    public void testTermQuery() {  
        ArrayList<String> jsonPointList = new ArrayList<>();
import org.opensearch.index.analysis.NamedAnalyzer;  
        // 2.test isSearchable=true, hasDocValues=false, mappedFieldTypeName=null
            );
        {  
                        true,
    }  
                new WildcardQuery(
                false
                "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
                    Automaton dvA2 = TermRangeQuery.toAutomaton(
        }
            assertEquals(expected, ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                true,  
        // test isSearchable=false, hasDocValues=true, mappedFieldTypeName!=null  
                        true  
            FlatObjectFieldMapper.FlatObjectFieldType ft = new FlatObjectFieldMapper.FlatObjectFieldType("field", null, true, false);  
                            () -> ft.rangeQuery(new BytesRef("2"), new BytesRef("10"), true, true, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
        // 4.test isSearchable=false, hasDocValues=false, mappedFieldTypeName=null
            );
                "field",
                "field.field1",
                "field",
        // 3.test isSearchable=false, hasDocValues=true, mappedFieldTypeName=null  
                }
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
                new BytesRef("field.foo"),
                () -> ft.termQueryCaseInsensitive("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                            nullUpperTerm ? null : new BytesRef("10"),  
            Query expected = new FuzzyQuery(new Term("field" + VALUE_SUFFIX, "foo"), 2, 1, 50, true);
        jsonPointList.add(jsonPoint.toString());  
                false,
                e.getMessage()  
        List<String> values = Arrays.asList("foo", "bar");  
        }
                ft.name(),
    public void testGetSearchField() {
            );
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
                        IllegalArgumentException e = expectThrows(  
        {
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
            assertEquals(expected, ft.prefixQuery("foo", CONSTANT_SCORE_BLENDED_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            );
                true,  
                true,
                "field.field1",
                        : (hasDocValue ? new IndexOrDocValuesQuery(indexQuery, dvQuery) : indexQuery);
        // test isSearchable=false, hasDocValues=false, mappedFieldTypeName!=null
            Automaton dvAutomaton = PrefixQuery.toAutomaton(new BytesRef("field.field.bar="));
        Map<String, Object> jsonPoint = new HashMap<>();
                () -> ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)  
        }
                "field.field1",
            );
            }
            );  
                        : (hasDocValue ? new IndexOrDocValuesQuery(indexQuery, dvQuery) : indexQuery);
                "field.field1",
        {
            );
                false
        }
                "field",  
        {
                            true,
        }
/*  
                null,
                CONSTANT_SCORE_BLENDED_REWRITE
                MultiTermQuery.DOC_VALUES_REWRITE  
                e.getMessage()
                new WildcardQuery(
                    Automaton dvAutomaton = Operations.intersection(a1, a2);
        {
            );  
        }
            FlatObjectFieldMapper.FlatObjectFieldType flatParentFieldType =
            List<BytesRef> indexTerms = new ArrayList<>();  
                        );
            Query expected = new IndexOrDocValuesQuery(  
                "field",
        // 3.test isSearchable=false, hasDocValues=true, mappedFieldTypeName=null
            );
        String fieldName,
            FlatObjectFieldType dynamicMappedFieldType = new FlatObjectFieldMapper.FlatObjectFieldType(
            assertEquals(new TermQuery(new Term(FieldNamesFieldMapper.NAME, "field")), ft.existsQuery(MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                new FuzzyQuery(
                true
                flatParentFieldType.getValueAndPathFieldType()  
                MultiTermQuery.DOC_VALUES_REWRITE
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            Query expected = SortedSetDocValuesField.newSlowRangeQuery(  
                "field.field1",
        jsonPoint.put("coordinates", Arrays.asList(42.0, 27.1));  
            assertEquals(expected, ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));  
import org.apache.lucene.search.AutomatonQuery;
                "field",
                        true,
                new ConstantScoreQuery(new TermQuery(new Term(searchFieldNameDocPath, searchValuesDocPath))),
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());  
            assertEquals(expected, ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                        assertEquals(
            FlatObjectFieldMapper.FlatObjectFieldType flatParentFieldType =
                        true,
        {
            indexTerms.add(new BytesRef("field.field1=foo"));
            );  
            IllegalArgumentException e = expectThrows(
                        hasDocValue
                dynamicMappedFieldType.termQuery("foo", null)
            );  
                        "field" + VALUE_AND_PATH_SUFFIX,
            null,  
            indexTerms.add(new BytesRef("foo"));
                null,  
                    0,
                    if (searchable == false && hasDocValue == false) {
                    true,
            indexTerms.add(new BytesRef("field.field1=bar"));
                    MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE
        );
import static org.apache.lucene.search.MultiTermQuery.CONSTANT_SCORE_REWRITE;
            );
                    RegexpQuery.DEFAULT_PROVIDER,
                "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",  
        assertEquals("foo", searchValues);
        // 1.test isSearchable=true, hasDocValues=true, mappedFieldTypeName=null
                "field.field1",
        }
                    new Term("field" + VALUE_AND_PATH_SUFFIX, new BytesRef("field.field1=foo")),  
            Query expected = new IndexOrDocValuesQuery(  
                false,  
                "field",  
                        "field.field1",
        MappedFieldType unsearchable = new FlatObjectFieldMapper.FlatObjectFieldType("field", null, false, false);
                    assertEquals(
            Query expected = new TermInSetQuery(DOC_VALUES_REWRITE, "field" + VALUE_AND_PATH_SUFFIX, docValueTerms);  
                            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
                    Query indexQuery = new AutomatonQuery(new Term("field" + VALUE_AND_PATH_SUFFIX), termAutomaton, true);  
                    new Term("field" + VALUE_SUFFIX, "foo*"),
                    10,
            assertEquals(expected, ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));  
                2,  
                "field",
                            true,
            assertEquals(
            List<BytesRef> indexTerms = new ArrayList<>();
                new BytesRef("field.field.field1=foo"),  
                MultiTermQuery.DOC_VALUES_REWRITE
                null,
                false
        }
            assertEquals(expected, ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                false
                        "field",
        // test isSearchable=false, hasDocValues=true, mappedFieldTypeName!=null
                    Query expected = searchable == false
import static org.opensearch.index.mapper.FlatObjectFieldMapper.VALUE_AND_PATH_SUFFIX;
                    CONSTANT_SCORE_BLENDED_REWRITE  
                "field",  
                false,
                "field.field1",
            );
        // test isSearchable=false, hasDocValues=true, mappedFieldTypeName!=null
        {
            );
        // test isSearchable=true, hasDocValues=false, mappedFieldTypeName!=null  
            "field",
        // 4.test isSearchable=false, hasDocValues=false, mappedFieldTypeName=null
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            assertEquals(expected, ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));  
        // 4.test isSearchable=false, hasDocValues=false, mappedFieldTypeName=null
            assertEquals(expected, ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                    Automaton termAutomaton = Operations.intersection(a1, a2);
                "field",  
            assertEquals(  
            assertEquals(expected, ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                DOC_VALUES_REWRITE
                1,
            Query expected = new IndexOrDocValuesQuery(
            Query expected = new PrefixQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field1=foo"), CONSTANT_SCORE_REWRITE);  
            );
                null,
import org.apache.lucene.search.FuzzyQuery;
                    );
                            () -> ft.rangeQuery(new BytesRef("2"), new BytesRef("10"), true, true, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
            Query expected = new RegexpQuery(
                true,
                AutomatonQueries.toCaseInsensitiveString("field.fOo"),
            indexTerms.add(new BytesRef("foo"));
                    assertEquals(
                            true,
            );
        Collections.shuffle(values, random());
            Query expected = new TermInSetQuery("field" + VALUE_AND_PATH_SUFFIX, indexTerms);
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            String searchFieldName = (flatParentFieldType).getSearchField();
 * this file be licensed under the Apache-2.0 license or a
        // test isSearchable=false, hasDocValues=true, mappedFieldTypeName!=null
                    MultiTermQuery.DOC_VALUES_REWRITE
            );
                    if (searchable == false && hasDocValue == false) {
                new Term("field" + VALUE_AND_PATH_SUFFIX, new BytesRef("field.field.field1=foo")),
                    0,  
                        IllegalArgumentException e = expectThrows(
 * The OpenSearch Contributors require contributions made to  
            assertEquals(expected, ft.termsQuery(values, null));
        // 3.test isSearchable=false, hasDocValues=true, mappedFieldTypeName=null  
    public void testRangeQuery() {
                        nullLowerTerm ? null : new BytesRef("2"),
            );  
                true,  
                false
            assertEquals(expected, ft.termsQuery(values, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));  
                    Query indexQuery = new TermRangeQuery(
                IllegalArgumentException.class,
                false,
            List<BytesRef> docValueTerms = new ArrayList<>();  
        }  
        {  
            );
                            IllegalArgumentException.class,  
            );
                MultiTermQuery.DOC_VALUES_REWRITE
            );
        {
    }
        }  
                    RegexpQuery.DEFAULT_PROVIDER,
            Query expected = new WildcardQuery(
                "field",  
                    Automaton a1 = PrefixQuery.toAutomaton(new BytesRef("field."));
import org.apache.lucene.search.IndexOrDocValuesQuery;  
                false,
            );
                "field",
            assertEquals(
                    );
        // 1.test isSearchable=true, hasDocValues=true, mappedFieldTypeName=null
            assertEquals(expected, ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                            e.getMessage()  
                    );
        );
    }  
            );  
                    0,
        // test isSearchable=false, hasDocValues=true, mappedFieldTypeName!=null  
    }
                false
                IllegalArgumentException.class,
                    FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
    }
            Query expected = new IndexOrDocValuesQuery(
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
            IllegalArgumentException e = expectThrows(  
        // 2.test isSearchable=true, hasDocValues=false, mappedFieldTypeName=null
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
                            nullLowerTerm ? null : new BytesRef("2"),
                    RegexpQuery.DEFAULT_PROVIDER,  
                    Automaton dvA1 = PrefixQuery.toAutomaton(new BytesRef("field.field.field1="));
                        true
                    if (searchable == false && hasDocValue == false) {
            String searchValuesDocPath = dynamicMappedFieldType.rewriteSearchValue("foo");
            );  
}
                new WildcardQuery(
                IllegalArgumentException.class,
        {
                "field",
            );
        }  
                        new BytesRef("field.field.field1=2"),
                "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",  
                )
                    DOC_VALUES_REWRITE
        {
                    Automaton dvAutomaton = Operations.intersection(dvA1, dvA2);
        }
                false
            );  
                false,
                null,  
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
        }
        // test isSearchable=false, hasDocValues=false, mappedFieldTypeName!=null
    }
                "field",
        }
        ArrayList<String> otherJsonPointList = new ArrayList<>();
                true
                e.getMessage()  
            for (boolean searchable : new boolean[] { true, false }) {
            );
            );  
                new FuzzyQuery(new Term("field" + VALUE_SUFFIX, "field.foo"), 2, 1, 50, true, MultiTermQuery.DOC_VALUES_REWRITE)
                flatParentFieldType.getValueAndPathFieldType()
        {  
            Query expected = new FuzzyQuery(
    public void testRewriteValue() {  
                    Query dvQuery = new AutomatonQuery(new Term("field" + VALUE_SUFFIX), dvAutomaton, true, DOC_VALUES_REWRITE);
        {  
        {  
                null,
                false,
                        true
            );
                        continue;
                        ? dvQuery
            );
            );
            fieldName,  
                true
                "field",
        }
            IllegalArgumentException e = expectThrows(  
                e.getMessage()  
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
                            () -> ft.rangeQuery(new BytesRef("2"), new BytesRef("10"), true, true, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                    new Term("field" + VALUE_SUFFIX, "field.foo*"),  
            IllegalArgumentException e = expectThrows(
                "field.field1",  
                    Automaton a2 = TermRangeQuery.toAutomaton(
                "field",
                    10,  
                "field",  
            assertEquals(expected, ft.prefixQuery("foo", CONSTANT_SCORE_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            assertEquals(
            docValueterms.add(new BytesRef("field.foo"));
        {
                true
                flatParentFieldType.getValueFieldType(),
        boolean isSearchable,
                "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
        {
                        "field",
        {
            );  
            for (boolean searchable : new boolean[] { true, false }) {
                false,  
                true  
                () -> ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
            Query expected = new ConstantScoreQuery(
            assertEquals(expected, ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));  
            assertEquals(expected, ft.termsQuery(values, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        {
            IllegalArgumentException e = expectThrows(  
                "field",
                "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
import java.util.List;
                    Query expected = searchable == false
            );  
        {
                "field",
                "field.field1",
            List<BytesRef> docValueterms = new ArrayList<>();  
                true
        FlatObjectFieldMapper.Builder builder = new FlatObjectFieldMapper.Builder(fieldName);
                new Term("field" + VALUE_AND_PATH_SUFFIX, new BytesRef("field.field1=foo")),
            );  
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
            );
                        searchable,  
                        new BytesRef("field.10"),
        // 3.test isSearchable=false, hasDocValues=true, mappedFieldTypeName=null  
                false  
            // when searching for "foo" in "field", the term query is directed to search "foo" in field._value field
            docValueterms.add(new BytesRef("field.bar"));  
                    new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field.field1=foo"),  
                MultiTermQuery.DOC_VALUES_REWRITE
                true,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
        {  
                new BytesRef("field.field.field1=foo"),
        // test isSearchable=false, hasDocValues=true, mappedFieldTypeName!=null
                false
        {
                        nullLowerTerm ? null : new BytesRef("field.field1=2"),  
                e.getMessage()  
    public void testTermQueryCaseInsensitive() {
                false,
                    10,
                new Term("field" + VALUE_SUFFIX, "field.foo"),
            FlatObjectFieldMapper.FlatObjectFieldType flatParentFieldType =  
                            "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values "
        // 2.test isSearchable=true, hasDocValues=false, mappedFieldTypeName=null
            assertEquals(expected, ft.prefixQuery("foo", CONSTANT_SCORE_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                true
                flatParentFieldType.getValueAndPathFieldType()
            IllegalArgumentException e = expectThrows(  
            );
            assertEquals(
                true,  
            assertEquals(
            assertEquals(expected, ft.prefixQuery("foo", CONSTANT_SCORE_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            );
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
                    );
                e.getMessage()  
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
    public void testTermsQuery() {
        }
                            nullUpperTerm ? null : new BytesRef("10"),  
    }
            );  
            for (boolean searchable : new boolean[] { true, false }) {
            );
            );
                0,  
                IllegalArgumentException.class,
                true
        }
        }  
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
        {
                null,
                        searchable,
                "field",
                "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values " + "enabled.",
                false
                true,
        // 4.test isSearchable=false, hasDocValues=false, mappedFieldTypeName=null
                () -> ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                false
    public void testFetchSourceValue() throws IOException {
                "field",
        }
                50,  
                new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field.field1=foo"),  
        {
                false
            assertEquals(expected, ft.prefixQuery("foo", CONSTANT_SCORE_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        );  
                        continue;
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                        new BytesRef("field.2"),
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                                + "enabled.",
                false,  
                        ? dvQuery  
                RegexpQuery.DEFAULT_PROVIDER,  
                false,  
        String mappedFieldTypeName,  
                        continue;
        MappedFieldType mapper = getFlatParentFieldType("field", null, true, true);
        {
                null,
                () -> ft.termsQuery(values, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)  
                null,
                        DOC_VALUES_REWRITE  
        {
                        assertEquals(  
                "field" + VALUE_AND_PATH_SUFFIX,
            );
                new Term("field" + VALUE_SUFFIX, "field.foo*"),  
                flatParentFieldType.name(),  
            Query expected = new PrefixQuery(new Term("field" + VALUE_SUFFIX, "field.foo"), DOC_VALUES_REWRITE);  
                        );
            flatParentFieldType.getValueAndPathFieldType()
                        );
            );  
                    FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                    0,  
        {  
                "field",
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            assertEquals(
            );
                false
 *
        }
                true,  
        {
        }
                "field",
            IllegalArgumentException e = expectThrows(  
                true  
            docValueterms.add(new BytesRef("field.bar"));  
                "field.field1",  
                "field",
                "field",  
            );
                e.getMessage()
            );
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,  
                "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values " + "enabled.",
                new BytesRef("field.foo"),
                            IllegalArgumentException.class,
                0,
                new TermInSetQuery(DOC_VALUES_REWRITE, "field" + VALUE_SUFFIX, docValueterms)  
                new Term("field" + VALUE_SUFFIX, new BytesRef("foo")),
            mappedFieldTypeName,
            indexTerms.add(new BytesRef("field.field1=bar"));
            );
            // when searching for "foo" in "field.bar", the term query is directed to search in field._valueAndPath field
        }  
        // 1.test isSearchable=true, hasDocValues=true, mappedFieldTypeName=null  
            );
                    );
import org.apache.lucene.util.automaton.Automaton;
                RegexpQuery.DEFAULT_PROVIDER,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                            MOCK_QSC_ENABLE_INDEX_DOC_VALUES  
import org.opensearch.common.lucene.search.AutomatonQueries;  
                        "field",
                ),
                        true,  
        }  
                "field",
                null,
                "field",  
import org.apache.lucene.index.Term;
                    DOC_VALUES_REWRITE
                    Query indexQuery = new TermRangeQuery("field" + VALUE_SUFFIX, new BytesRef("2"), new BytesRef("10"), true, true);
                null,  
                        "field" + VALUE_SUFFIX,
                    50,  
                null,
        {
        }  
        }
                    0,
 * SPDX-License-Identifier: Apache-2.0
                    }  
                flatParentFieldType.name(),
import org.apache.lucene.search.Query;  
        }  
            Query expected = new IndexOrDocValuesQuery(
            );  
            IllegalArgumentException e = expectThrows(  
import org.apache.lucene.search.TermQuery;  
                true  
        }
                false,  
            flatParentFieldType.name(),
                false
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            indexTerms.add(new BytesRef("foo"));
                        expected,
            );
                        hasDocValue
            IllegalArgumentException e = expectThrows(  
                )  
            assertEquals(
        {  
            "field.bar",
        // 2.test isSearchable=true, hasDocValues=false, mappedFieldTypeName=null  
            assertEquals(expected, ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                new TermInSetQuery("field" + VALUE_SUFFIX, indexTerms),
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
            }
            NamedAnalyzer analyzer = new NamedAnalyzer("default", AnalyzerScope.INDEX, null);  
            assertEquals(expected, ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            Query expected = new RegexpQuery(
                "field.bar",
                        ft.rangeQuery(new BytesRef("2"), new BytesRef("10"), true, true, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)  
            // when searching for "foo" in "field.bar", the directSubfield is field._valueAndPath field
        }
                false,
                "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
            );
            );
            );
                        ft.rangeQuery(new BytesRef("2"), new BytesRef("10"), true, true, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                false
                e.getMessage()
        }  
            MappedFieldType ft = new FlatObjectFieldMapper.FlatObjectFieldType("field", null, true, true);
                "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",  
            assertEquals("field._value", searchFieldName);
        {
                new RegexpQuery(
            );  
                false
                false
        {
                null,
                    Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,  
            );
        assertEquals("field.bar=foo", searchValuesDocPath);
    }
                        );  
                    Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
                () -> ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)  
                flatParentFieldType.name(),  
                "field",
    private static MappedFieldType getFlatParentFieldType(
            );  
        {
            );
                            e.getMessage()  
        String searchValuesDocPath = ((FlatObjectFieldMapper.FlatObjectFieldType) dynamicMappedFieldType).rewriteSearchValue("foo");  
        {  
                true
            );
        }  
                                + "enabled.",
        {
import org.apache.lucene.search.WildcardQuery;
                50,
                null,
        }  
                ),
                new TermQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, new BytesRef("field.field1=foo")))  
            );  
                false,
            vft.setIndexOptions(IndexOptions.NONE);
            assertEquals(expected, ft.termQueryCaseInsensitive("fOo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            assertEquals("field._value", ((FlatObjectFieldMapper.FlatObjectFieldType) ft).getSearchField());
                        new BytesRef("field.field.field1=10"),  
import static org.apache.lucene.search.MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
import java.util.Collections;  
            indexTerms.add(new BytesRef("field.field1=foo"));  
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                true,
            List<BytesRef> docValueterms = new ArrayList<>();
            Query expected = new IndexOrDocValuesQuery(
                (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType("field", null, true, true);  
                    Query expected = searchable == false
        }
            String searchFieldNameDocPath = ((FlatObjectFieldMapper.FlatObjectFieldType) dynamicMappedFieldType).getSearchField();
                        nullUpperTerm ? null : new BytesRef("field.field.field1=10"),
                true,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
                IllegalArgumentException.class,
                CONSTANT_SCORE_BLENDED_REWRITE  
                () -> ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)  
                        new BytesRef("field.field1=10"),
                0,  
            assertEquals(expected, ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                null,  
            );
            Query expected = new WildcardQuery(  
                new PrefixQuery(new Term("field" + VALUE_SUFFIX, "foo"), CONSTANT_SCORE_REWRITE),
            assertEquals(
                    0,
                        true,
            Query expected = new WildcardQuery(
                    boolean nullLowerTerm = randomBoolean();
                null,
                "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values " + "enabled.",
                new Term("field" + VALUE_SUFFIX, "foo*"),
            assertEquals("foo", searchValues);
                "field",
                true
                    assertEquals(
                    new Term("field" + VALUE_AND_PATH_SUFFIX, new BytesRef("field.field.field1=foo")),
            );  
    public void testWildcardQuery() {
            );
                ft.getValueAndPathFieldType()
                        true,
 * compatible open source license.
        {
        }  
                false
        {  
                0,
        }  
            );
                true,
        // 4.test isSearchable=false, hasDocValues=false, mappedFieldTypeName=null
            );  
        // test isSearchable=true, hasDocValues=false, mappedFieldTypeName!=null
                true  
            MappedFieldType dynamicMappedFieldType = new FlatObjectFieldMapper.FlatObjectFieldType(  
            );
        // 3.test isSearchable=false, hasDocValues=true, mappedFieldTypeName=null
                "field",
                        true,
                IllegalArgumentException.class,
                    );  
                    assertEquals(
                "field.bar",
                    MultiTermQuery.DOC_VALUES_REWRITE
                    );
            );
            Query expected = new RegexpQuery(  
                IllegalArgumentException.class,
                        assertEquals(  
                null,
                "field",
            List<BytesRef> indexTerms = new ArrayList<>();
                false
            );  
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
            );  
    }  
            // when searching for "foo" in "field", the directSubfield is field._value field  
                new RegexpQuery(  
                        assertEquals(  
            assertEquals(expected, ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        // test isSearchable=false, hasDocValues=false, mappedFieldTypeName!=null
                "field.field1",
                flatParentFieldType.getValueFieldType(),
        }
        {
                        ft.rangeQuery(
                true
import java.io.IOException;  
                "field",
        // 1.test isSearchable=true, hasDocValues=true, mappedFieldTypeName=null  
                            e.getMessage()  
                            MOCK_QSC_ENABLE_INDEX_DOC_VALUES  
        {
        FieldType vft = new FieldType(fieldtype);  
                )  
                        "field.field1",
                        continue;
            assertEquals(
                dynamicMappedFieldType.termQueryCaseInsensitive("fOo", null)
        // test isSearchable=true, hasDocValues=true, mappedFieldTypeName!=null
                false
            true,
        }  
            );  
                new RegexpQuery(
            docValueTerms.add(new BytesRef("field.field.field1=foo"));
            );
                        "field" + VALUE_AND_PATH_SUFFIX,  
                false  
        {  
    public void testRegexpQuery() {
        {
                    Query indexQuery = new TermRangeQuery(  
                ),  
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
        }
                e.getMessage()
        {  
                AutomatonQueries.caseInsensitiveTermQuery(new Term("field._valueAndPath", "field.bar=fOo")),  
        otherJsonPointList.add(otherJsonPoint.toString());  
            }
                false,  
        // 2.test isSearchable=true, hasDocValues=false, mappedFieldTypeName=null
            MappedFieldType dynamicMappedFieldType = new FlatObjectFieldMapper.FlatObjectFieldType(
                "field.field1",
            String searchFieldNameDocPath = dynamicMappedFieldType.getSearchField();  
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE
            indexTerms.add(new BytesRef("bar"));  
        {  
                "field.field1",  
                "field",
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
                0,
                    Automaton a1 = PrefixQuery.toAutomaton(new BytesRef("field.field1="));
        String searchFieldNameDocPath = ((FlatObjectFieldMapper.FlatObjectFieldType) dynamicMappedFieldType).getSearchField();
        }
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE  
                () -> ft.termsQuery(values, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)  
            );  
                        hasDocValue
            );
                        null,
                )
                true
                    1,
                new PrefixQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field1=foo"), CONSTANT_SCORE_REWRITE),
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
            );
            true
                        hasDocValue
            );  
            );
            );  
                new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field.field1=foo*"),
        }  
                            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
                2,
                "field.field1",
                0,  
        // test isSearchable=false, hasDocValues=false, mappedFieldTypeName!=null
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                flatParentFieldType.getValueFieldType(),
            );
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                true  
                false,  
                true
                ft.getValueFieldType(),  
                IllegalArgumentException.class,
        }
        {  
                        );  
                null,  
import org.apache.lucene.util.automaton.Operations;
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
                    new Term("field" + VALUE_SUFFIX, new BytesRef("field.foo")),  
import org.apache.lucene.search.PrefixQuery;
                "field",
                false,
                    }  
            assertEquals(expected, ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            Query expected = new RegexpQuery(  
                true,  
                1,
        {
                    0,
                "field.field1",
        }
            assertEquals(
                        true,
                            nullLowerTerm ? null : new BytesRef("2"),
                for (boolean hasDocValue : new boolean[] { true, false }) {  
                    RegexpQuery.DEFAULT_PROVIDER,  
                    );
            List<BytesRef> docValueterms = new ArrayList<>();
                        )
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                IllegalArgumentException.class,
            assertEquals(
                "field",  
        }
 */  
                true
        {
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
            );  
                new PrefixQuery(new Term("field" + VALUE_SUFFIX, "field.foo"), DOC_VALUES_REWRITE)
            // when checking if a subfield within the flat_object, for example, "field.bar", use term query in the flat_object field
                        expected,  
            );
            assertEquals(
                }  
                        new BytesRef("field.field1=2"),
            );
            );  
                () -> ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)  
        }  
        );
                e.getMessage()  
                            IllegalArgumentException.class,  
                    );  
        Map<String, Object> otherJsonPoint = new HashMap<>();
                null,
                RegexpQuery.DEFAULT_PROVIDER,
        // test isSearchable=false, hasDocValues=false, mappedFieldTypeName!=null
                () -> ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
            List<BytesRef> indexTerms = new ArrayList<>();
                false,
                "field.bar",  
                        "field" + VALUE_SUFFIX,  
                IllegalArgumentException.class,
            );
                () -> ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                false,  
                null,
                null,  
                    Query dvQuery = new AutomatonQuery(new Term("field" + VALUE_AND_PATH_SUFFIX), dvAutomaton, true, DOC_VALUES_REWRITE);
                }  
                "field.field1",
                        nullUpperTerm ? null : new BytesRef("field.10"),
                (FlatObjectFieldMapper.FlatObjectFieldType) (getFlatParentFieldType("field", null, true, true));
                true  
        {
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
            );
            Query expected = new ConstantScoreQuery(new TermQuery(new Term("field" + VALUE_SUFFIX, new BytesRef("foo"))));
                true,
        }  
                        ? dvQuery  
            );  
                true,  
            docValueTerms.add(new BytesRef("field.field.field1=bar"));
                true,
                true  
        }  
import org.apache.lucene.search.FieldExistsQuery;
                () -> ft.prefixQuery("foo", CONSTANT_SCORE_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
            assertEquals(expected, ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        }
            Query expected = SortedSetDocValuesField.newSlowRangeQuery(
        {
                    MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE  
                false,  
                10,
import org.apache.lucene.search.RegexpQuery;
            );
import org.apache.lucene.search.MultiTermQuery;
        {
        // test isSearchable=true, hasDocValues=true, mappedFieldTypeName!=null
        }
                "field.field1",
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            assertEquals("field._valueAndPath", searchFieldNameDocPath);  
                "field",
            assertEquals(expected, ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        {
        }  
                "field",
                        nullUpperTerm ? null : new BytesRef("10"),  
        MappedFieldType unsearchable = new FlatObjectFieldMapper.FlatObjectFieldType("field", null, false, false);
            assertEquals(expected, ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                    );  
                10,
                    FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                        IllegalArgumentException e = expectThrows(
                true
                    );
                new FuzzyQuery(new Term("field" + VALUE_SUFFIX, "foo"), 2, 1, 50, true),
            assertEquals(
                        );
                        searchable,
        }
                null,
                () -> ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                        nullLowerTerm ? null : new BytesRef("field.field.field1=2"),  
                IllegalArgumentException.class,
                true,
                "field.field1",
            Query expected = new FuzzyQuery(
import java.util.HashMap;
                        IllegalArgumentException e = expectThrows(
                }  
                false
    public void testFuzzyQuery() {  
                    Query dvQuery = new TermRangeQuery(  
                        : (hasDocValue ? new IndexOrDocValuesQuery(indexQuery, dvQuery) : indexQuery);
            );
            IllegalArgumentException e = expectThrows(  
            );
            );
import org.apache.lucene.document.SortedSetDocValuesField;
                AutomatonQueries.caseInsensitiveTermQuery(new Term("field._value", "fOo")),
            indexTerms.add(new BytesRef("bar"));  
import org.opensearch.index.analysis.AnalyzerScope;
            assertEquals(expected, ft.prefixQuery("foo", CONSTANT_SCORE_BLENDED_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());  
                new WildcardQuery(  
import java.util.Map;  
            assertEquals(expected, ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                    Query dvQuery = new TermRangeQuery(
            assertEquals(new FieldExistsQuery("field"), ft.existsQuery(null));  
            );
                IllegalArgumentException.class,
            );  
            );
            );
                true,
            assertEquals(expected, dynamicMappedFieldType.existsQuery(MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            );
        // 3.test isSearchable=false, hasDocValues=true, mappedFieldTypeName=null
                "field",
            );  
                    );  
                    FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
                "field",  
                null,
                "field",  
import org.apache.lucene.search.TermInSetQuery;
        }
            () -> unsearchable.termQuery("bar", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                "field",  
        // 3.test isSearchable=false, hasDocValues=true, mappedFieldTypeName=null
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
            assertEquals(expected, ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                        DOC_VALUES_REWRITE
                    Automaton a2 = TermRangeQuery.toAutomaton(
                "field",
            MappedFieldType dynamicMappedFieldType = new FlatObjectFieldMapper.FlatObjectFieldType(
            isSearchable,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                new Term("field" + VALUE_SUFFIX, "field.fOo"),
        boolean hasDocValues
                    new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field1=foo*"),  
                "field",
        FlatObjectFieldMapper.FlatObjectFieldType flatObjectFieldType = new FlatObjectFieldMapper.FlatObjectFieldType(
            );
                "field",
            assertEquals(expected, ft.termQuery("fOo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            Query expected = new IndexOrDocValuesQuery(  
            );
        // 4.test isSearchable=false, hasDocValues=false, mappedFieldTypeName=null
                "field",
            indexTerms.add(new BytesRef("bar"));  
package org.opensearch.index.mapper;
                false,  
                true,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
        }
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                new RegexpQuery(
            IllegalArgumentException e = expectThrows(
            IllegalArgumentException e = expectThrows(
                true,
            );  
            Query indexQuery = new AutomatonQuery(new Term("field" + VALUE_AND_PATH_SUFFIX), termAutomaton, true);
                    Query expected = searchable == false
        {  
import org.apache.lucene.document.FieldType;
                for (boolean hasDocValue : new boolean[] { true, false }) {
                    }  
        }
        }
import org.opensearch.common.unit.Fuzziness;
                "field.field1",
        assertEquals(otherJsonPointList, fetchSourceValue(mapper, otherJsonPoint, null));  
        {
        }
            assertEquals(
            Query expected = new IndexOrDocValuesQuery(
        {  
            assertEquals(
            }  
                false
        {
                )  
public class FlatObjectFieldTypeTests extends FieldTypeTestCase {
                MultiTermQuery.DOC_VALUES_REWRITE  
                true
                        : (hasDocValue ? new IndexOrDocValuesQuery(indexQuery, dvQuery) : indexQuery);  
    public void testPrefixQuery() {  
        // when searching for "foo" in "field", the rewrite value is "foo"
            );
                new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field1=foo*"),
        // when searching for "foo" in "field.bar", the rewrite value is "field.bar=foo"
            assertEquals(expected, ft.termQueryCaseInsensitive("fOo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                "field",  
            assertEquals(expected, ft.termsQuery(values, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));  
                "field.field1",  
            );
                for (boolean hasDocValue : new boolean[] { true, false }) {  
                "field",
            IllegalArgumentException e = expectThrows(
            );
                new PrefixQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field.field1=foo"), DOC_VALUES_REWRITE)
import java.util.ArrayList;
            Query expected = AutomatonQueries.createAutomatonQuery(  
            IllegalArgumentException.class,  
                true  
                null,
            () -> unsearchable.termQuery("bar", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
                10,  
                flatParentFieldType.name() + ".bar",
        // test isSearchable=false, hasDocValues=false, mappedFieldTypeName!=null
        {
                for (boolean hasDocValue : new boolean[] { true, false }) {
                        null,  
        IllegalArgumentException e = expectThrows(
                0,
                "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values " + "enabled.",  
                true,
                false,  
                false
            assertEquals(expected, ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));  
        }  
                DOC_VALUES_REWRITE  
                true,
        }  
                null,  
        // test isSearchable=true, hasDocValues=false, mappedFieldTypeName!=null
                true,
            );
                e.getMessage()  
            assertEquals(
            Automaton termAutomaton = PrefixQuery.toAutomaton(new BytesRef("field.bar="));  
        // test isSearchable=true, hasDocValues=false, mappedFieldTypeName!=null
                (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType("field", null, true, true);
                    );
                            IllegalArgumentException.class,  
            Query expected = AutomatonQueries.createAutomatonQuery(
                new TermInSetQuery("field" + VALUE_AND_PATH_SUFFIX, indexTerms),
        jsonPoint.put("type", "flat_object");
            );
                () -> ft.prefixQuery("foo", CONSTANT_SCORE_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
        }
        otherJsonPoint.put("type", "Point");
                "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values " + "enabled.",  
                true
                false,  
        return flatObjectFieldType;
        // 1.test isSearchable=true, hasDocValues=true, mappedFieldTypeName=null
                false,  
                new Term("field" + VALUE_SUFFIX, new BytesRef("field.foo")),  
                new TermQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, new BytesRef("field.field1=fOo")))
                "field",
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(  
        {  
import static org.apache.lucene.search.MultiTermQuery.DOC_VALUES_REWRITE;  
