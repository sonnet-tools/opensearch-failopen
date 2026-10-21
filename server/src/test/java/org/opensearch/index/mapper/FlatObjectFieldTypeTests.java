                "field.bar",
                AutomatonQueries.toCaseInsensitiveString("field.fOo"),
        }
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
import org.apache.lucene.search.TermQuery;
            );
            assertEquals(expected, ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            );
import org.apache.lucene.search.AutomatonQuery;
                false,
                0,
            assertEquals(
            );
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values " + "enabled.",
                    RegexpQuery.DEFAULT_PROVIDER,
        assertEquals(otherJsonPointList, fetchSourceValue(mapper, otherJsonPoint, null));
                        true
        otherJsonPoint.put("coordinates", Arrays.asList(30.0, 50.0));
            for (boolean searchable : new boolean[] { true, false }) {
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                "field.field1",
    }
        {
                    true,
                        "field" + VALUE_AND_PATH_SUFFIX,
            assertEquals(expected, ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            Query expected = new WildcardQuery(
            assertEquals(
            );
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            assertEquals(expected, ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            Query expected = new WildcardQuery(
                true
import org.opensearch.index.analysis.AnalyzerScope;
            Query expected = new WildcardQuery(
                                + "enabled.",
                    10,
            );
                "field",
    }
                )
                    10,
            String searchFieldName = (flatParentFieldType).getSearchField();
            Query expected = SortedSetDocValuesField.newSlowRangeQuery(
            assertEquals(new TermQuery(new Term(FieldNamesFieldMapper.NAME, "field")), ft.existsQuery(MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                null,
                null,
 * this file be licensed under the Apache-2.0 license or a
            Query expected = new IndexOrDocValuesQuery(
                false,
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE
                "field",
        }
        }
                "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
            Query expected = AutomatonQueries.createAutomatonQuery(
            IllegalArgumentException e = expectThrows(
            Query expected = new PrefixQuery(new Term("field" + VALUE_SUFFIX, "field.foo"), DOC_VALUES_REWRITE);
        boolean isSearchable,
                true,
            assertEquals(
        }
                            true,
                        new BytesRef("field.field1=10"),
                    new Term("field" + VALUE_SUFFIX, "foo*"),
                false,
        {
                ft.termQueryCaseInsensitive("fOo", null)
            );
    public void testWildcardQuery() {
                true
                () -> ft.termsQuery(values, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
            );
            assertEquals(expected, ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                    2,
        {
            Query expected = new PrefixQuery(new Term("field" + VALUE_SUFFIX, "foo"), CONSTANT_SCORE_BLENDED_REWRITE);
                    MultiTermQuery.DOC_VALUES_REWRITE
                new BytesRef("field.field.field1=foo"),
                IllegalArgumentException.class,
            hasDocValues
                false
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                null,
        otherJsonPointList.add(otherJsonPoint.toString());
        FieldType vft = new FieldType(fieldtype);
                    );
                        );
                0,
                    FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            assertEquals(
                flatParentFieldType.name(),
                    Query expected = searchable == false
        }
            docValueterms.add(new BytesRef("field.bar"));
            );
                false
            Query expected = new IndexOrDocValuesQuery(
        String mappedFieldTypeName,
                new FuzzyQuery(
                "field.field1",
            );
            flatParentFieldType.name(),
                            IllegalArgumentException.class,
        {
    ) {
                    0,
        // test isSearchable=false, hasDocValues=true, mappedFieldTypeName!=null
            );
                flatParentFieldType.getValueFieldType(),
        }
            );
                flatParentFieldType.name(),
    }
                        null,
            );
                false
                IllegalArgumentException.class,
                false
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
            String searchFieldName = flatParentFieldType.getSearchField();
                    FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
    }
        }
        );
            );
                50,
            );
                        true,
            IllegalArgumentException e = expectThrows(
                "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values " + "enabled.",
            IllegalArgumentException e = expectThrows(
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
        }
 * The OpenSearch Contributors require contributions made to
        assertEquals("field.bar=foo", searchValuesDocPath);
        // test isSearchable=false, hasDocValues=true, mappedFieldTypeName!=null
                    Query dvQuery = new TermRangeQuery(
        FlatObjectFieldMapper.Builder builder = new FlatObjectFieldMapper.Builder(fieldName);
                true,
        // 3.test isSearchable=false, hasDocValues=true, mappedFieldTypeName=null
                "field.field1",
        {
                        nullLowerTerm ? null : new BytesRef("field.field.field1=2"),
                    Query dvQuery = new AutomatonQuery(new Term("field" + VALUE_SUFFIX), dvAutomaton, true, DOC_VALUES_REWRITE);
                false
            );
            indexTerms.add(new BytesRef("field.field1=foo"));
                "field.bar",
                true
                "field",
        // 3.test isSearchable=false, hasDocValues=true, mappedFieldTypeName=null
                "field" + VALUE_SUFFIX,
    }
        }
                }
                        true
        {
            Query expected = new TermInSetQuery("field" + VALUE_AND_PATH_SUFFIX, indexTerms);
            flatParentFieldType.getValueFieldType(),
                true,
                "field.field1",
                "field",
                        : (hasDocValue ? new IndexOrDocValuesQuery(indexQuery, dvQuery) : indexQuery);
            MappedFieldType dynamicMappedFieldType = new FlatObjectFieldMapper.FlatObjectFieldType(
                ft.getValueFieldType(),
                "field",
        ArrayList<String> jsonPointList = new ArrayList<>();
import org.apache.lucene.util.BytesRef;
            String searchFieldNameDocPath = ((FlatObjectFieldMapper.FlatObjectFieldType) dynamicMappedFieldType).getSearchField();
            );
            );
            assertEquals(expected, ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                    FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                true,
 */
        }
            );
                    MultiTermQuery.DOC_VALUES_REWRITE
                (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType("field", null, true, true);
        {
                true,
            Query expected = new RegexpQuery(
            );
                        new BytesRef("field.2"),
            indexTerms.add(new BytesRef("field.field1=foo"));
                null,
        // 3.test isSearchable=false, hasDocValues=true, mappedFieldTypeName=null
                        true,
        {
                new BytesRef("field.foo"),
        {
                    );
            );
                MultiTermQuery.DOC_VALUES_REWRITE
                new FuzzyQuery(new Term("field" + VALUE_SUFFIX, "foo"), 2, 1, 50, true),
                "field",
                    Automaton dvA2 = TermRangeQuery.toAutomaton(
        {
        }
                new Term("field" + VALUE_AND_PATH_SUFFIX, new BytesRef("field.field1=foo")),
                        ? dvQuery
            Query expected = new TermInSetQuery(DOC_VALUES_REWRITE, "field" + VALUE_AND_PATH_SUFFIX, docValueTerms);
    private static MappedFieldType getFlatParentFieldType(
        assertEquals("foo", searchValues);
                IllegalArgumentException.class,
        }
            List<BytesRef> indexTerms = new ArrayList<>();
                "field",
            );
                () -> ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
            }
                true
            for (boolean searchable : new boolean[] { true, false }) {
                            true,
                        true,
                "field.field1",
                    );
        // 2.test isSearchable=true, hasDocValues=false, mappedFieldTypeName=null
        // 3.test isSearchable=false, hasDocValues=true, mappedFieldTypeName=null
                () -> ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                null,
            assertEquals(expected, ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        }
                "field.field1",
                new TermInSetQuery(DOC_VALUES_REWRITE, "field" + VALUE_AND_PATH_SUFFIX, docValueterms)
        }
import java.util.Map;
                true
            assertEquals(expected, ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                false
        return flatObjectFieldType;
import org.apache.lucene.document.FieldType;
                () -> ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                true
                true,
                    }
            );
        {
        {
                    Automaton dvAutomaton = Operations.intersection(a1, a2);
                "field",
                    0,
            for (boolean searchable : new boolean[] { true, false }) {
        }
        // test isSearchable=true, hasDocValues=true, mappedFieldTypeName!=null
        // 2.test isSearchable=true, hasDocValues=false, mappedFieldTypeName=null
                () -> ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                AutomatonQueries.caseInsensitiveTermQuery(new Term("field._valueAndPath", "field.bar=fOo")),
                        ? dvQuery
                e.getMessage()
            );
        // 2.test isSearchable=true, hasDocValues=false, mappedFieldTypeName=null
        // 3.test isSearchable=false, hasDocValues=true, mappedFieldTypeName=null
import static org.apache.lucene.search.MultiTermQuery.CONSTANT_SCORE_REWRITE;
                        hasDocValue
package org.opensearch.index.mapper;
            String searchValues = flatParentFieldType.rewriteSearchValue("foo");
                RegexpQuery.DEFAULT_PROVIDER,
                true
        {
            );
                flatParentFieldType.getValueAndPathFieldType()
    public void testExistsQuery() {
                "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
        IllegalArgumentException e = expectThrows(
        // 1.test isSearchable=true, hasDocValues=true, mappedFieldTypeName=null
                true
                "field",
        }
                true,
            assertEquals(
                        );
            String searchFieldNameDocPath = dynamicMappedFieldType.getSearchField();
                MultiTermQuery.DOC_VALUES_REWRITE
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                true
            assertEquals(expected, ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            flatParentFieldType.getValueAndPathFieldType()
                    if (searchable == false && hasDocValue == false) {
            );
                null,
                "field",
import static org.opensearch.index.mapper.FlatObjectFieldMapper.VALUE_SUFFIX;
        MappedFieldType unsearchable = new FlatObjectFieldMapper.FlatObjectFieldType("field", null, false, false);
        }
                        ft.rangeQuery(
            Query expected = new FuzzyQuery(new Term("field" + VALUE_SUFFIX, "foo"), 2, 1, 50, true);
                        expected,
                new WildcardQuery(
        }
        // 1.test isSearchable=true, hasDocValues=true, mappedFieldTypeName=null
            );
            );
        }
                "field",
                "field",
        // test isSearchable=false, hasDocValues=true, mappedFieldTypeName!=null
                        true
        // 4.test isSearchable=false, hasDocValues=false, mappedFieldTypeName=null
                        ft.rangeQuery(
        }
                true
        {
 * compatible open source license.
                    if (searchable == false && hasDocValue == false) {
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                    Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
                )
        // test isSearchable=false, hasDocValues=false, mappedFieldTypeName!=null
            null,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                    Query expected = searchable == false
                true
        // 3.test isSearchable=false, hasDocValues=true, mappedFieldTypeName=null
import org.apache.lucene.search.ConstantScoreQuery;
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
    }
                true
        // test isSearchable=true, hasDocValues=false, mappedFieldTypeName!=null
            );
                            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
            );
        otherJsonPoint.put("type", "Point");
                e.getMessage()
                0,
        // when searching for "foo" in "field", the rewrite value is "foo"
            assertEquals(
                        "field" + VALUE_SUFFIX,
                        assertEquals(
                IllegalArgumentException.class,
import static org.apache.lucene.search.MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
                    MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE
                true,
        }
        // test isSearchable=false, hasDocValues=false, mappedFieldTypeName!=null
                    Query indexQuery = new TermRangeQuery(
            );
                "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values " + "enabled.",
                true,
            docValueterms.add(new BytesRef("field.field.field1=foo"));
            Query expected = new ConstantScoreQuery(
            );
                "field.field1",
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                        null,
        // test isSearchable=false, hasDocValues=false, mappedFieldTypeName!=null
                        true
import java.util.ArrayList;
                    if (searchable == false && hasDocValue == false) {
                "field",
        {
                true
        // test isSearchable=true, hasDocValues=false, mappedFieldTypeName!=null
                    if (searchable == false && hasDocValue == false) {
            // when searching for "foo" in "field.bar", the term query is directed to search in field._valueAndPath field
                null,
                "field.field1",
                }
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
import org.apache.lucene.search.Query;
                "field",
                () -> ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
            Query expected = new RegexpQuery(
                        "field.field1",
                true,
                null,
                false
                "field",
        }
                }
import org.apache.lucene.index.IndexOptions;
                        assertEquals(
                        assertEquals(
                        : (hasDocValue ? new IndexOrDocValuesQuery(indexQuery, dvQuery) : indexQuery);
                    0,
                "field.field1",
        );
                true,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            Query expected = new IndexOrDocValuesQuery(
        Map<String, Object> jsonPoint = new HashMap<>();
                    );
        // test isSearchable=true, hasDocValues=true, mappedFieldTypeName!=null
                    CONSTANT_SCORE_BLENDED_REWRITE
            indexTerms.add(new BytesRef("field.field1=bar"));
        }
            () -> unsearchable.termQuery("bar", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                        "field",
    }
            );
import org.apache.lucene.util.automaton.Automaton;
import java.util.List;
                        "field",
            );
        }
                        ft.rangeQuery(new BytesRef("2"), new BytesRef("10"), true, true, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
        }
            Query expected = new IndexOrDocValuesQuery(
            );
                        nullLowerTerm ? null : new BytesRef("field.field1=2"),
                flatParentFieldType.getValueAndPathFieldType()
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
                false,
                    new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field.field1=foo"),
        {
import org.apache.lucene.index.Term;
        }
import org.apache.lucene.document.SortedSetDocValuesField;
                true,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                        );
            assertEquals(
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                "field.field1",
                    new Term("field" + VALUE_SUFFIX, "field.foo*"),
            IllegalArgumentException e = expectThrows(
                        );
            IllegalArgumentException e = expectThrows(
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            );
        boolean hasDocValues
                10,
                "field",
                        hasDocValue
            assertEquals(expected, dynamicMappedFieldType.existsQuery(MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            FlatObjectFieldType dynamicMappedFieldType = new FlatObjectFieldMapper.FlatObjectFieldType(
            vft.setIndexOptions(IndexOptions.NONE);
            );
                        IllegalArgumentException e = expectThrows(
            );
        // 2.test isSearchable=true, hasDocValues=false, mappedFieldTypeName=null
                null,
                false
            }
                ),
            docValueTerms.add(new BytesRef("field.field.field1=foo"));
                new TermInSetQuery(DOC_VALUES_REWRITE, "field" + VALUE_SUFFIX, docValueterms)
                0,
                false
                e.getMessage()
                "field",
            for (boolean searchable : new boolean[] { true, false }) {
                    Query indexQuery = new TermRangeQuery("field" + VALUE_SUFFIX, new BytesRef("2"), new BytesRef("10"), true, true);
                    );
                            "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
                        continue;
            assertEquals(
            );
            Query expected = new FuzzyQuery(
                "field",
            );
            List<BytesRef> docValueTerms = new ArrayList<>();
        {
            );
                    }
                e.getMessage()
            Query expected = new FuzzyQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field1=foo"), 2, 1, 50, true);
                true,
                )
        }
        {
        );
                0,
                            "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values "
        }
import org.apache.lucene.search.RegexpQuery;
                e.getMessage()
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                false
        // test isSearchable=false, hasDocValues=false, mappedFieldTypeName!=null
                true
            assertEquals(expected, ft.termsQuery(values, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                50,
            );
            assertEquals(
            assertEquals(
                new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field.field1=foo"),
            );
                "field",
                        : (hasDocValue ? new IndexOrDocValuesQuery(indexQuery, dvQuery) : indexQuery);
 *
            IllegalArgumentException e = expectThrows(
        {
                            nullUpperTerm ? null : new BytesRef("10"),
                false,
            Query expected = new IndexOrDocValuesQuery(
        {
                    Query dvQuery = new AutomatonQuery(new Term("field" + VALUE_AND_PATH_SUFFIX), dvAutomaton, true, DOC_VALUES_REWRITE);
                    assertEquals(
        String searchValuesDocPath = ((FlatObjectFieldMapper.FlatObjectFieldType) dynamicMappedFieldType).rewriteSearchValue("foo");
                true
                true,
                null,
            }
                            true,
    public void testFetchSourceValue() throws IOException {
                            () -> ft.rangeQuery(new BytesRef("2"), new BytesRef("10"), true, true, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                        nullUpperTerm ? null : new BytesRef("field.field.field1=10"),
            assertEquals(expected, ft.termQuery("fOo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            assertEquals("field._valueAndPath", searchFieldNameDocPath);
                (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType("field", null, true, true);
                new Term("field" + VALUE_SUFFIX, "field.foo"),
            docValueterms.add(new BytesRef("field.foo"));
                "field.field1",
            assertEquals(expected, ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
public class FlatObjectFieldTypeTests extends FieldTypeTestCase {
                true,
        jsonPointList.add(jsonPoint.toString());
            assertEquals(
                    new Term("field" + VALUE_AND_PATH_SUFFIX, new BytesRef("field.field.field1=foo")),
import org.apache.lucene.search.MultiTermQuery;
                        new BytesRef("field.field.field1=2"),
                    RegexpQuery.DEFAULT_PROVIDER,
        }
            );
                            IllegalArgumentException.class,
import java.io.IOException;
import static org.opensearch.index.mapper.FlatObjectFieldMapper.VALUE_AND_PATH_SUFFIX;
            );
                ),
                "field.field1",
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
        }
        // 4.test isSearchable=false, hasDocValues=false, mappedFieldTypeName=null
                "field.field1",
                CONSTANT_SCORE_BLENDED_REWRITE
                    assertEquals(
                    new Term("field" + VALUE_SUFFIX, new BytesRef("field.foo")),
                DOC_VALUES_REWRITE
        // test isSearchable=false, hasDocValues=true, mappedFieldTypeName!=null
        // 1.test isSearchable=true, hasDocValues=true, mappedFieldTypeName=null
                    10,
        // test isSearchable=true, hasDocValues=true, mappedFieldTypeName!=null
            Query expected = new IndexOrDocValuesQuery(
                    Automaton a2 = TermRangeQuery.toAutomaton(
                new ConstantScoreQuery(new TermQuery(new Term(searchFieldName, searchValues))),
                false
                null,
                "field.field1",
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
        {
                e.getMessage()
                () -> ft.termsQuery(values, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                e.getMessage()
                    Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
                "field",
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                    boolean nullLowerTerm = randomBoolean();
        );
                "field.field1",
        {
                        ft.rangeQuery(new BytesRef("2"), new BytesRef("10"), true, true, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
            );
    public void testRangeQuery() {
                true,
                    Automaton a1 = PrefixQuery.toAutomaton(new BytesRef("field."));
                    boolean nullUpperTerm = nullLowerTerm == false || randomBoolean();
                new Term("field" + VALUE_SUFFIX, "field.fOo"),
        }
                null,
import org.apache.lucene.search.IndexOrDocValuesQuery;
        {
                    );
            Automaton termAutomaton = PrefixQuery.toAutomaton(new BytesRef("field.bar="));
            );
                        "field.field1",
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                true
        {
                    boolean nullUpperTerm = nullLowerTerm == false || randomBoolean();
        // test isSearchable=false, hasDocValues=true, mappedFieldTypeName!=null
            FlatObjectFieldMapper.FlatObjectFieldType flatParentFieldType =
        {
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            assertEquals(expected, ft.prefixQuery("foo", CONSTANT_SCORE_BLENDED_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                "field",
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
import org.apache.lucene.util.automaton.Operations;
        // test isSearchable=true, hasDocValues=false, mappedFieldTypeName!=null
                        nullLowerTerm ? null : new BytesRef("field.2"),
            assertEquals(expected, ft.termQueryCaseInsensitive("fOo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            );
                            e.getMessage()
                IllegalArgumentException.class,
        // 4.test isSearchable=false, hasDocValues=false, mappedFieldTypeName=null
    }
    public void testTermsQuery() {
                () -> ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
        MappedFieldType dynamicMappedFieldType = new FlatObjectFieldMapper.FlatObjectFieldType(
                    Automaton a1 = PrefixQuery.toAutomaton(new BytesRef("field.field1="));
            assertEquals(expected, ft.termsQuery(values, null));
                        true,
        assertEquals(jsonPointList, fetchSourceValue(mapper, jsonPoint, null));
        {
                false
            );
                new BytesRef("field.foo"),
                "field",
            List<BytesRef> docValueterms = new ArrayList<>();
        jsonPoint.put("type", "flat_object");
                        : (hasDocValue ? new IndexOrDocValuesQuery(indexQuery, dvQuery) : indexQuery);
        {
    public void testRegexpQuery() {
            indexTerms.add(new BytesRef("foo"));
                MultiTermQuery.DOC_VALUES_REWRITE
                false,
            IllegalArgumentException e = expectThrows(
            );
            );
                true,
            Query expected = new ConstantScoreQuery(
                false
            Query expected = new WildcardQuery(
                false
                        new BytesRef("field.field1=2"),
            MappedFieldType dynamicMappedFieldType = new FlatObjectFieldMapper.FlatObjectFieldType(
                false,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                        assertEquals(
                e.getMessage()
                true,
            Query expected = new TermInSetQuery("field" + VALUE_SUFFIX, indexTerms);
                MultiTermQuery.DOC_VALUES_REWRITE
            );
            );
                "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values " + "enabled.",
                    0,
                        nullUpperTerm ? null : new BytesRef("10"),
                true,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                "field",
                        nullUpperTerm ? null : new BytesRef("field.10"),
    public void testTermQueryCaseInsensitive() {
                    0,
                null,
                "field.field1",
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                    DOC_VALUES_REWRITE
                    new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field1=foo*"),
                null,
                IllegalArgumentException.class,
                "field.field1",
            );
            assertEquals(expected, ft.termsQuery(values, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                true,
            );
                "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
            );
                new FuzzyQuery(new Term("field" + VALUE_SUFFIX, "field.foo"), 2, 1, 50, true, MultiTermQuery.DOC_VALUES_REWRITE)
                            true,
                IllegalArgumentException.class,
            // when searching for "foo" in "field", the term query is directed to search "foo" in field._value field
        {
        {
            );
    }
                false
                "field",
                false
                            "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values "
                    1,
                        )
            List<BytesRef> indexTerms = new ArrayList<>();
        String searchValues = (flatParentFieldType).rewriteSearchValue("foo");
                    Automaton dvA1 = PrefixQuery.toAutomaton(new BytesRef("field.field.field1="));
                        );
                new PrefixQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field1=foo"), CONSTANT_SCORE_REWRITE),
                    new Term("field" + VALUE_SUFFIX, new BytesRef("foo")),
import java.util.HashMap;
                        continue;
    }
        {
                AutomatonQueries.caseInsensitiveTermQuery(new Term("field._value", "fOo")),
                    );
                new TermInSetQuery("field" + VALUE_AND_PATH_SUFFIX, indexTerms),
            true,
import org.opensearch.index.mapper.FlatObjectFieldMapper.FlatObjectFieldType;
                        DOC_VALUES_REWRITE
                true
            // when checking if a subfield within the flat_object, for example, "field.bar", use term query in the flat_object field
            isSearchable,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                () -> ft.prefixQuery("foo", CONSTANT_SCORE_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
        );
            Query expected = new TermInSetQuery(DOC_VALUES_REWRITE, "field" + VALUE_SUFFIX, docValueterms);
                10,
        }
            );
            );
                null,
        }
                    50,
            );
        // 4.test isSearchable=false, hasDocValues=false, mappedFieldTypeName=null
                new Term("field" + VALUE_SUFFIX, new BytesRef("foo")),
                    );
                        true
                "field",
            List<BytesRef> indexTerms = new ArrayList<>();
                false,
            );
            assertEquals(expected, ft.termsQuery(values, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                            () -> ft.rangeQuery(new BytesRef("2"), new BytesRef("10"), true, true, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
            assertEquals(new FieldExistsQuery("field"), ft.existsQuery(null));
                        IllegalArgumentException e = expectThrows(
        // when searching for "foo" in "field.bar", the rewrite value is "field.bar=foo"
            IllegalArgumentException.class,
        }
            Query expected = new IndexOrDocValuesQuery(
                null,
                            MOCK_QSC_ENABLE_INDEX_DOC_VALUES
            Query expected = SortedSetDocValuesField.newSlowRangeQuery(
        }
                ft.name(),
                    FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field.field1=fOo"),
            );
 * SPDX-License-Identifier: Apache-2.0
            // when searching for "foo" in "field.bar", the directSubfield is field._valueAndPath field
                e.getMessage()
            assertEquals(expected, ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        }
                "field",
                new TermQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, new BytesRef("field.field1=foo")))
            );
        // 2.test isSearchable=true, hasDocValues=false, mappedFieldTypeName=null
        // test isSearchable=true, hasDocValues=false, mappedFieldTypeName!=null
                            IllegalArgumentException.class,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                null,
            List<BytesRef> docValueterms = new ArrayList<>();
        }
        String fieldName,
                Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
                "field",
                false,
                true,
                true,
                1,
                new RegexpQuery(
                            e.getMessage()
            );
                    RegexpQuery.DEFAULT_PROVIDER,
            assertEquals("foo", searchValues);
            Query expected = new IndexOrDocValuesQuery(
                false,
                MultiTermQuery.DOC_VALUES_REWRITE
            );
                false
                        );
            String searchValuesDocPath = dynamicMappedFieldType.rewriteSearchValue("foo");
            NamedAnalyzer analyzer = new NamedAnalyzer("default", AnalyzerScope.INDEX, null);
        {
        List<String> values = Arrays.asList("foo", "bar");
import org.apache.lucene.search.TermInSetQuery;
            );
        {
                false,
import java.util.Arrays;
                "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
        }
            Query indexQuery = new AutomatonQuery(new Term("field" + VALUE_AND_PATH_SUFFIX), termAutomaton, true);
                null,
                DOC_VALUES_REWRITE
                IllegalArgumentException.class,
        // test isSearchable=true, hasDocValues=false, mappedFieldTypeName!=null
            );
            IllegalArgumentException e = expectThrows(
                flatParentFieldType.getValueFieldType(),
                "field",
                new PrefixQuery(new Term("field" + VALUE_SUFFIX, "field.foo"), DOC_VALUES_REWRITE)
            indexTerms.add(new BytesRef("bar"));
                false
                    );
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                false,
                true
        assertEquals("Cannot search on field [field] since it is both not indexed, and does not have doc_values enabled.", e.getMessage());
import static org.apache.lucene.search.MultiTermQuery.DOC_VALUES_REWRITE;
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
import org.apache.lucene.search.PrefixQuery;
            fieldName,
        // test isSearchable=false, hasDocValues=true, mappedFieldTypeName!=null
            );
            );
        // 4.test isSearchable=false, hasDocValues=false, mappedFieldTypeName=null
                false,
                new Term("field" + VALUE_SUFFIX, "foo*"),
        }
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
        {
        }
                        nullLowerTerm ? null : new BytesRef("2"),
            );
                "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
                true
                null,
                new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field.field1=foo*"),
            assertEquals(expected, ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            assertEquals(
                            IllegalArgumentException.class,
                true,
            assertEquals(expected, ft.termsQuery(values, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                true,
            docValueterms.add(new BytesRef("field.bar"));
            );
            );
                new FuzzyQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field1=foo"), 2, 1, 50, true),
            FlatObjectFieldMapper.FlatObjectFieldType ft = new FlatObjectFieldMapper.FlatObjectFieldType("field", null, true, false);
                MultiTermQuery.DOC_VALUES_REWRITE
                        new BytesRef("field.field.field1=10"),
            );
        // 1.test isSearchable=true, hasDocValues=true, mappedFieldTypeName=null
                    }
                    Automaton a2 = TermRangeQuery.toAutomaton(
            assertEquals(expected, ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        }
                        );
        }
                flatParentFieldType.getValueFieldType(),
    public void testGetSearchField() {
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                    );
            assertEquals(expected, ft.termQuery("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
        // test isSearchable=false, hasDocValues=false, mappedFieldTypeName!=null
            );
        // test isSearchable=true, hasDocValues=true, mappedFieldTypeName!=null
                "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values " + "enabled.",
                false,
                "field",
                "field",
                false
            );
        {
                false,
        jsonPoint.put("coordinates", Arrays.asList(42.0, 27.1));
        }
        }
            indexTerms.add(new BytesRef("foo"));
                new WildcardQuery(
                () -> ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                    boolean nullLowerTerm = randomBoolean();
        MappedFieldType unsearchable = new FlatObjectFieldMapper.FlatObjectFieldType("field", null, false, false);
        }
                new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field1=foo*"),
            );
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                "field",
            indexTerms.add(new BytesRef("bar"));
    }
                    assertEquals(
            );
            indexTerms.add(new BytesRef("field.field1=bar"));
            );
                "field.field1",
            IllegalArgumentException e = expectThrows(
        }
                true,
                true
                null,
        {
                new TermQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, new BytesRef("field.field1=fOo")))
                () -> ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                false,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                0,
            Query expected = new ConstantScoreQuery(new TermQuery(new Term("field" + VALUE_SUFFIX, new BytesRef("foo"))));
            assertEquals(
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                "field.field1",
/*
                new WildcardQuery(
            );
            assertEquals(
                IllegalArgumentException.class,
                10,
        {
                            e.getMessage()
                e.getMessage()
                    );
            );
                "field",
            Query expected = new IndexOrDocValuesQuery(indexQuery, dvQuery);
            );
            Query expected = AutomatonQueries.createAutomatonQuery(
                            nullUpperTerm ? null : new BytesRef("10"),
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
        {
                "field",
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                () -> ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                "field",
                new WildcardQuery(
            );
                flatParentFieldType.getValueAndPathFieldType()
                new RegexpQuery(
                new Term("field" + VALUE_SUFFIX, new BytesRef("field.foo")),
            indexTerms.add(new BytesRef("foo"));
            assertEquals(expected, ft.prefixQuery("foo", CONSTANT_SCORE_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            assertEquals(expected, ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        {
                "field",
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
        }
                        nullUpperTerm ? null : new BytesRef("field.field1=10"),
                AutomatonQueries.toCaseInsensitiveString("field.field.field1=fOo"),
            );
            IllegalArgumentException e = expectThrows(
                    );
            );
            );
            Query dvQuery = new AutomatonQuery(new Term("field" + VALUE_AND_PATH_SUFFIX), dvAutomaton, true, DOC_VALUES_REWRITE);
                )
                "field",
                            () -> ft.rangeQuery(new BytesRef("2"), new BytesRef("10"), true, true, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                        "field" + VALUE_SUFFIX,
                    Query dvQuery = new TermRangeQuery(
                new BytesRef("field.field.field1=foo"),
        MappedFieldType mapper = getFlatParentFieldType("field", null, true, true);
                "field",
                "field.field1",
                "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
        {
                        "field",
            assertEquals(
        Collections.shuffle(values, random());
                    Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
            );
                false,
                new RegexpQuery(
                "field.bar",
                            nullLowerTerm ? null : new BytesRef("2"),
            assertEquals(expected, ft.prefixQuery("foo", CONSTANT_SCORE_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                    Query expected = searchable == false
            assertEquals("field.bar=foo", searchValuesDocPath);
                IllegalArgumentException.class,
                null,
            () -> unsearchable.termQuery("bar", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
        // 1.test isSearchable=true, hasDocValues=true, mappedFieldTypeName=null
                null,
                "field",
                        true,
            List<BytesRef> indexTerms = new ArrayList<>();
            mappedFieldTypeName,
            );
                    Query indexQuery = new TermRangeQuery(
        // 2.test isSearchable=true, hasDocValues=false, mappedFieldTypeName=null
            docValueterms.add(new BytesRef("field.foo"));
                }
                2,
        {
            docValueterms.add(new BytesRef("field.field.field1=bar"));
                        true,
            );
            );
        {
    public void testFuzzyQuery() {
                "field",
                    10,
                        );
                "field.field1",
                            MOCK_QSC_ENABLE_INDEX_DOC_VALUES
                        expected,
                "field",
                true,
                new ConstantScoreQuery(new TermQuery(new Term(searchFieldNameDocPath, searchValuesDocPath))),
                1,
                e.getMessage()
                        ? dvQuery
                        new BytesRef("field.10"),
import java.util.Collections;
            );
        {
        // 1.test isSearchable=true, hasDocValues=true, mappedFieldTypeName=null
                        searchable,
                true
            assertEquals(expected, ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                false,
        // 3.test isSearchable=false, hasDocValues=true, mappedFieldTypeName=null
            assertEquals(expected, ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                        true,
                () -> ft.termQueryCaseInsensitive("foo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
                                + "enabled.",
                false,
                2,
        }
        // 4.test isSearchable=false, hasDocValues=false, mappedFieldTypeName=null
                "field",
                ),
            );
                e.getMessage()
                true
import org.apache.lucene.search.TermRangeQuery;
                "Cannot search on field [field] since it is both not indexed, and does not have doc_values " + "enabled.",
import org.opensearch.common.lucene.search.AutomatonQueries;
        {
                "field",
        }
            }
                CONSTANT_SCORE_BLENDED_REWRITE
                (FlatObjectFieldMapper.FlatObjectFieldType) (getFlatParentFieldType("field", null, true, true));
                        true,
        {
        }
                true,
            );
            );
        }
            assertEquals(expected, ft.prefixQuery("foo", CONSTANT_SCORE_BLENDED_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                "field",
        }
            );
            FlatObjectFieldMapper.FlatObjectFieldType flatParentFieldType =
        FlatObjectFieldMapper.FlatObjectFieldType flatObjectFieldType = new FlatObjectFieldMapper.FlatObjectFieldType(
                ft.getValueAndPathFieldType()
                null,
            MappedFieldType dynamicMappedFieldType = new FlatObjectFieldMapper.FlatObjectFieldType(
            );
            );
                "field",
                false,
                        ? dvQuery
                            () -> ft.rangeQuery(new BytesRef("2"), new BytesRef("10"), true, true, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
        // test isSearchable=false, hasDocValues=false, mappedFieldTypeName!=null
                null,
            );
                RegexpQuery.DEFAULT_PROVIDER,
            assertEquals(expected, ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            );
            assertEquals(expected, ft.termsQuery(values, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                    CONSTANT_SCORE_BLENDED_REWRITE
                        hasDocValue
                RegexpQuery.DEFAULT_PROVIDER,
        FieldType fieldtype = new FieldType(FlatObjectFieldMapper.Defaults.FIELD_TYPE);
        {
                e.getMessage()
            "field.bar",
        }
                ),
            assertEquals(
        {
import org.apache.lucene.search.FieldExistsQuery;
import org.apache.lucene.search.FuzzyQuery;
                false
            assertEquals(expected, ft.prefixQuery("foo", CONSTANT_SCORE_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                    MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE
                "field",
            FlatObjectFieldMapper.FlatObjectFieldType flatParentFieldType =
        {
            );
                    }
                for (boolean hasDocValue : new boolean[] { true, false }) {
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            );
                        searchable,
                null,
                "field",
                10,
            indexTerms.add(new BytesRef("bar"));
            assertEquals("field._value", ((FlatObjectFieldMapper.FlatObjectFieldType) ft).getSearchField());
                            e.getMessage()
            assertEquals(expected, ft.wildcardQuery("foo*", null, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                "field",
            );
                false
                    Query indexQuery = new AutomatonQuery(new Term("field" + VALUE_AND_PATH_SUFFIX), termAutomaton, true);
                    RegexpQuery.DEFAULT_PROVIDER,
            );
                for (boolean hasDocValue : new boolean[] { true, false }) {
                for (boolean hasDocValue : new boolean[] { true, false }) {
            );
                true,
                new PrefixQuery(new Term("field" + VALUE_SUFFIX, "foo"), CONSTANT_SCORE_REWRITE),
                new Term("field" + VALUE_AND_PATH_SUFFIX, new BytesRef("field.field.field1=foo")),
                    Automaton dvAutomaton = Operations.intersection(dvA1, dvA2);
import org.opensearch.common.unit.Fuzziness;
                "field",
                e.getMessage()
            "field",
        }
        if (flatObjectFieldType.isSearchable() == false) {
                false
                    new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field.field1=foo*"),
            IllegalArgumentException.class,
            Query expected = new RegexpQuery(
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                    );
        {
                true
                        "field" + VALUE_AND_PATH_SUFFIX,
            assertEquals(
                null,
                IllegalArgumentException.class,
                false
            );
                flatParentFieldType.name(),
            );
                flatParentFieldType.termQuery(searchValues, null)
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
    public void testPrefixQuery() {
                    Query expected = searchable == false
        }
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            // when searching for "foo" in "field", the directSubfield is field._value field
                )
        }
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE
                        expected,
                IllegalArgumentException.class,
                false,
        {
                true
            List<BytesRef> indexTerms = new ArrayList<>();
        // test isSearchable=true, hasDocValues=false, mappedFieldTypeName!=null
                "field",
    }
                () -> ft.prefixQuery("foo", CONSTANT_SCORE_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES)
            );
                for (boolean hasDocValue : new boolean[] { true, false }) {
            List<BytesRef> docValueterms = new ArrayList<>();
                        searchable,
                "field",
        }
                flatParentFieldType.name() + ".bar",
            Query expected = new RegexpQuery(
        }
import org.apache.lucene.search.WildcardQuery;
            );
                false,
                        )
        // test isSearchable=false, hasDocValues=true, mappedFieldTypeName!=null
            );
                false,
                    MultiTermQuery.DOC_VALUES_REWRITE
        {
            Query expected = new IndexOrDocValuesQuery(
            assertEquals(expected, ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
            assertEquals(expected, ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
        }
                "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values " + "enabled.",
                false
            );
        ArrayList<String> otherJsonPointList = new ArrayList<>();
                false
                    Automaton termAutomaton = Operations.intersection(a1, a2);
            IllegalArgumentException e = expectThrows(
                "Cannot search on field [field.field1] since it is both not indexed, and does not have doc_values " + "enabled.",
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
import org.opensearch.index.analysis.NamedAnalyzer;
                            nullLowerTerm ? null : new BytesRef("2"),
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
        }
                    Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,
            Query expected = new PrefixQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field.field1=foo"), DOC_VALUES_REWRITE);
                0,
                    assertEquals(
                false,
        }
        // 1.test isSearchable=true, hasDocValues=true, mappedFieldTypeName=null
        {
                false
        {
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
        IllegalArgumentException e = expectThrows(
            assertEquals("field._value", searchFieldName);
            );
            Query expected = new FuzzyQuery(
        {
        {
        // test isSearchable=true, hasDocValues=true, mappedFieldTypeName!=null
        {
                false,
                false,
                        continue;
                false
            MappedFieldType ft = new FlatObjectFieldMapper.FlatObjectFieldType("field", null, true, true);
            );
                "field",
                        hasDocValue
        String searchFieldNameDocPath = ((FlatObjectFieldMapper.FlatObjectFieldType) dynamicMappedFieldType).getSearchField();
            );
                        DOC_VALUES_REWRITE
                "field.field1",
            );
                        expected,
                "field",
                new PrefixQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field.field1=foo"), DOC_VALUES_REWRITE)
        // 2.test isSearchable=true, hasDocValues=false, mappedFieldTypeName=null
                "field.field1",
                dynamicMappedFieldType.termQuery("foo", null)
                true
                "field.field1",
                0,
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                new RegexpQuery(
                        IllegalArgumentException e = expectThrows(
        {
        {
            IllegalArgumentException e = expectThrows(
        // test isSearchable=true, hasDocValues=false, mappedFieldTypeName!=null
                    );
        FlatObjectFieldMapper.FlatObjectFieldType flatParentFieldType = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
        {
                false,
                "field",
}
            IllegalArgumentException e = expectThrows(
            Automaton dvAutomaton = PrefixQuery.toAutomaton(new BytesRef("field.field.bar="));
        {
            assertEquals(expected, ft.prefixQuery("foo", CONSTANT_SCORE_REWRITE, false, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                IllegalArgumentException.class,
            assertEquals(expected, ft.fuzzyQuery("foo", Fuzziness.fromEdits(2), 1, 50, true, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                false
                    new Term("field" + VALUE_AND_PATH_SUFFIX, new BytesRef("field.field1=foo")),
                "field" + VALUE_AND_PATH_SUFFIX,
                false,
            // when checking on the flat_object field name "field", check if exist in the field mapper names
                dynamicMappedFieldType.termQueryCaseInsensitive("fOo", null)
                        searchable,
            assertEquals(
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
                    0,
            );
        {
    public void testRewriteValue() {
                    );
        // 4.test isSearchable=false, hasDocValues=false, mappedFieldTypeName=null
                    0,
                        true,
        {
                "field.field1",
            );
        // test isSearchable=false, hasDocValues=false, mappedFieldTypeName!=null
            assertEquals(expected, ft.regexpQuery("foo", 0, 0, 10, null, MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                    DOC_VALUES_REWRITE
                true
            docValueTerms.add(new BytesRef("field.field.field1=bar"));
            assertEquals(expected, ft.termQueryCaseInsensitive("fOo", MOCK_QSC_ENABLE_INDEX_DOC_VALUES));
                "field.field1",
    public void testTermQuery() {
                        continue;
                        "field",
        {
            IllegalArgumentException e = expectThrows(
            );
                new TermInSetQuery("field" + VALUE_SUFFIX, indexTerms),
                null,
                RegexpQuery.DEFAULT_PROVIDER,
                    0,
        Map<String, Object> otherJsonPoint = new HashMap<>();
            FlatObjectFieldMapper.FlatObjectFieldType ft = (FlatObjectFieldMapper.FlatObjectFieldType) getFlatParentFieldType(
        }
            Query expected = new IndexOrDocValuesQuery(
                        IllegalArgumentException e = expectThrows(
            Query expected = new PrefixQuery(new Term("field" + VALUE_AND_PATH_SUFFIX, "field.field1=foo"), CONSTANT_SCORE_REWRITE);
                new Term("field" + VALUE_SUFFIX, "field.foo*"),
                true,
        }
                true
                IllegalArgumentException.class,
    }
            true
