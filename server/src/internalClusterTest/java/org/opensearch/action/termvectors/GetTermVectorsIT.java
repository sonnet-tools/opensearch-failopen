        assertThat(response.getIndex(), equalTo("test"));
            String string0 = next0.utf8ToString();
 * not use this file except in compliance with the License.
        // should return only the specified valid fields, with some with overridden analyzer  
 *  
        assertThat(response.getId(), equalTo("1"));  
        while ((text = termsEnum.next()) != null) {  
                    .get();
            filterSettings.maxNumTerms = i + 1;  
 */
                .get();  
                    .setSelectedFields("field1")  
            String tag = "a";  
        for (int i = 0; i < numDocs; i++) {
        TermVectorsResponse actionGet = termVector.actionGet();
                .setPositions(isPositionsRequested)  
                indexBuilders.add(client().prepareIndex().setIndex(indexName).setId(String.valueOf(id)).setSource("field1", content[id]));  
        // version 0 means ignore version, which is the default  
            checkBrownFoxTermVector(fields, "field", true);  
            assertThat(next, notNullValue());
                assertThat("term: " + string, docsAndPositions.endOffset(), equalTo(termEndOffset[k]));
            "Allocating experimental units via random assignment to a treatment or control condition.",  
                .setSettings(
            tags.add(tag);
                .setSelectedFields("tags")  
                assertThat("term: " + string0, docsAndPositions0.startOffset(), equalTo(docsAndPositions1.startOffset()));  
            tags.add(tag);  
                break;  
                .field("type", "text")
        for (int i = 0; i < 4; i++) {  
            default:  
                    .get();
            assertThat("doc id: " + i + " doesn't exists but should", response.isExists(), equalTo(true));  
        createIndexBasedOnFieldSettings("test", "alias", testFieldSettings);
    public void testNoSuchDoc() throws Exception {
                .setOffsets(true)
        int numTerms = scaledRandomIntBetween(10, 50);
        int sumDocFreq = 0;
 * ownership. Elasticsearch licenses this file to you under  
            .get();
            if (randomBoolean()) {  
        assertThat(iter0.next(), nullValue());
        XContentBuilder mapping = jsonBuilder().startObject()
                        .putList("index.analysis.analyzer.tv_test.filter", "lowercase")
        assertThat(actionGet.isExists(), equalTo(true));
import java.util.Arrays;
        // setup indices with mapping  
        } catch (VersionConflictEngineException e) {
            .startObject("properties")
            response = client().prepareTermVectors("test", "1")
            response = client().prepareTermVectors("test", "1")
 *
            for (int id = 0; id < content.length; id++) {
import org.opensearch.test.MockKeywordPlugin;
                    // docs and pos only returns something if positions or
        boolean storeOffsets = false;  
        return Collections.singleton(MockKeywordPlugin.class);
            .endObject()
                        assertThat(infoString, termPos.length, equalTo(freq[j]));
            .get();  
            assertThat("term: " + string0, docsAndPositions0.freq(), equalTo(docsAndPositions1.freq()));
            client().prepareGet(indexOrAlias(), "1").setVersion(2).setRealtime(false).get();
            .endObject()
 * specific language governing permissions and limitations
                    iterator.next().utf8ToString(),  
                    assertThat(infoString + "expected " + string, string, equalTo(next.utf8ToString()));
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        }  
            }  
        FieldType ft = new FieldType();  
        mapping.endObject().endObject();  
    }  
        assertThat(response.getId(), equalTo("1"));
            .field("type", "text")
            if (randomBoolean()) {
    }
            .putList("index.analysis.analyzer.my_analyzer.filter", "lowercase")  
                    "Analyzer for " + fieldName + " should have been overridden!",
        }
            "Selecting a random sample of a population (important in statistical sampling).",
                    int[] termEndOffset = endOffset[j];
            TermVectorsResponse response = request.get();  
            .field("type", "text")
    public void testWithKeywordAndNormalizer() throws IOException, ExecutionException, InterruptedException {  
        for (int i = 0; i < numTerms; i++) {  
                    "type=text,term_vector=with_positions_offsets,analyzer=keyword"
                    jsonBuilder().startObject()  
                .get();
            assertThat(fields.size(), equalTo(fieldNames.length));
            }
                builder.append("_payloads");
import java.util.concurrent.ExecutionException;
                .setId(Integer.toString(i))  
            return builder.toString();
        assertThat(response.getVersion(), equalTo(1L));  
        assertThat(actionGet.getFields().terms("existingfield"), nullValue());  
    public void testFilterLength() throws ExecutionException, InterruptedException, IOException {  
            validateResponse(response, luceneTermVectors, test);
            .put(indexSettings())
                builder.append("_offsets");
                .setTermStatistics(true)  
        TermVectorsResponse response;
            assertThat(termEndOffset.length, equalTo(freq[j]));  
                assertThat(
            String string1 = next1.utf8ToString();
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
            // all good
        DirectoryReader directoryReader = indexDocsWithLucene(testDocs);
        XContentBuilder mapping = jsonBuilder().startObject().startObject("properties");
        Terms terms0 = fields0.terms(fieldName);
            // check overridden by keyword analyzer ...
                        // payloads are never made by the mapping in this test  
import org.apache.lucene.index.Fields;  
                    // many shards and do not know how documents are distributed
        TermVectorsResponse response;
                assertThat("doc with index: " + indexNames[j] + ", type1 and id: " + id, resp.isExists(), equalTo(true));  
            tags.add("tag_" + i);  
        String text = "the quick brown fox jumps over the lazy dog";
    }  
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value2").get();
/*  
import org.apache.lucene.index.DirectoryReader;
        for (String indexName : indexNames) {
        TermVectorsRequest.FilterSettings filterSettings = new TermVectorsRequest.FilterSettings();  
                .setIndex("test")
                fields[j] = resp.getFields();
                perFieldAnalyzer.put("non_existing" + i, "keyword");
            assertThat(actionGet, notNullValue());
        int[][] endOffset = { { 15 }, { 43 }, { 19 }, { 25 }, { 39 }, { 30 }, { 9 }, { 3, 34 } };  
        ClusterSearchShardsResponse searchShardsResponse = client().admin().cluster().prepareSearchShards("test").get();  
        for (String field : fieldNames) {  
        for (int i = 0; i < numTerms; i++) {
            compareTermVectors("field1", fields[0], fields[1]);
                tag += "a";
        assertThat(terms1, notNullValue());
/*  
                selectedFields.add("field" + i);
                assertThat("term: " + string, docsAndPositions.startOffset(), equalTo(termStartOffset[k]));
                .execute()
                .execute()  
    public static String termVectorOptionsToString(FieldType fieldType) {
        Map<String, String> perFieldAnalyzer = new HashMap<>();
        assertThat(response.getIndex(), equalTo("test"));
            .field("term_vector", "with_positions_offsets_payloads")
                    "type=keyword", // yes tvs  
        }
        assertEquals("sumTotalTermFreq should be 0 for a non-existing field!", 0, terms.getSumTotalTermFreq());
        ensureGreen();  
        int[] freq = { 1, 1, 1, 1, 1, 1, 1, 2 };
        ensureGreen();  
                .setSource(
        assertAcked(
        boolean storePositions = false;
            .startObject("properties")  
        assertThat(response.isExists(), equalTo(true));
                .setFilterSettings(filterSettings)
        client().prepareIndex("test").setId("0").setSource("anotherexistingfield", 1).execute().actionGet();  
            for (int j = 0; j < indexNames.length; j++) {
        Collections.sort(bestTerms);
        indexRandom(true, indexBuilders);  
            Fields[] fields = new Fields[2];
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(response.getVersion(), equalTo(2L));
        List<String> tags = new ArrayList<>();
        assertThat(actionGet, notNullValue());
            "Selecting a random sample of a population (important in statistical sampling).",
        int[][] pos = { { 2 }, { 8 }, { 3 }, { 4 }, { 7 }, { 5 }, { 1 }, { 0, 6 } };
            String term = termsEnum.term().utf8ToString();
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
        }
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("field1", "random permutation"));  
        assertAcked(prepareCreate(indexNames[0]).setMapping("field1", "type=text,term_vector=with_positions_offsets,analyzer=keyword"));
        // index a single document with prepared source
        ensureGreen();  
        Terms terms1 = fields1.terms(fieldName);
            + ", offsets-"
            int[] termPos = pos[j];
                assertThat(iterator.next(), nullValue());  
                        // 31the34 35lazy39 40dog43  
    }  
                        assertThat(termEndOffset.length, equalTo(freq[j]));
        int[][] startOffset = { { 10 }, { 40 }, { 16 }, { 20 }, { 35 }, { 26 }, { 4 }, { 0, 31 } };
        assertThat(response.getVersion(), equalTo(2L));  
        assertThat(iterator.next(), nullValue());
    }
        assertThat(response.getVersion(), equalTo(1L));
                        assertNull(infoString + "payloads for term: " + string, docsAndPositions.getPayload());
        XContentBuilder source = jsonBuilder().startObject();  
        String tag;  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                // We never configure an analyzer with payloads for this test so this is never returned  
            .endObject()  
                    // do not test ttf or doc frequency, because here we have
        TermVectorsResponse response = client().prepareTermVectors("test", "1").get();
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("field1", "type=text"));  
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(1).setRealtime(false).get();
        // From translog:
                    BytesRef next = iterator.next();  
        for (int i = 0; i < numDocs; i++) {
        ActionFuture<TermVectorsResponse> termVectors = client().termVectors(
                        .put(indexSettings())  
        // setup indices
            refresh();
                )  
            .endObject()
                TermVectorsResponse resp = client().prepareTermVectors(indexNames[j], String.valueOf(id))
        } else if (fieldType.storeTermVectorOffsets() && !fieldType.storeTermVectorPositions()) {  
                .setSettings(
        logger.info("Setting up the index ...");
        assertAcked(
                                equalTo(termStartOffset[k])
        XContentBuilder mapping = jsonBuilder().startObject()
                );
                        // 0the3 4quick9 10brown15 16fox19 20jumps25 26over30
        TermVectorsResponse response = client().prepareTermVectors(indexOrAlias(), "0").setSelectedFields("field*").get();
        // setup indices
            }
        assertThat(response.getVersion(), equalTo(2L));  
                    "type=integer,", // no tvs
        assertThat(actionGet, notNullValue());  
        // create random per_field_analyzer and selected fields  
                    client().prepareIndex()  
                .setTermStatistics(true)  
        int numFields = 25;
        logger.info("Setting up the index ...");  
            if (randomBoolean()) {
import static org.hamcrest.Matchers.nullValue;  
        String[] values = { "brown", "dog", "fox", "jumps", "lazy", "over", "quick", "the" };  
        final TermsEnum termsEnum = terms.iterator();  
            .setPositions(true)  
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("index.analysis.analyzer", "standard");
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            .endObject();
        boolean isPositionsRequested = randomBoolean();
            tag = "tag_" + i;
            assertThat(termStartOffset.length, equalTo(freq[j]));
                        .endObject()  
            }
            }  
                .setOffsets(true)  
        for (int i = 0; i < 10; i++) {
 * Modifications Copyright OpenSearch Contributors. See
                        }
            .field("type", "text")
            prepareCreate("test").setMapping(mapping)  
        // when indexing a field that simply has a question mark, the term vectors will be null  
            .field("term_vector", "with_positions_offsets_payloads")  
            "Generating a random permutation of a sequence (such as when shuffling cards).",
        ensureGreen();  
 */  
        String[] values = { "brown", "dog", "fox", "jumps", "lazy", "over", "quick", "the" };
        for (int i = 0; i < terms0.size(); i++) {  
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setMapping(mapping));
        assertThat("More fields than expected are returned!", fieldsObject.size(), equalTo(validFields.size()));
        assertThat("All term vectors should have been generated", response.getFields().size(), equalTo(numFields));
        logger.info("Indexing {} documents with tags of increasing dfs ...", numDocs);
            }  
            ActionFuture<TermVectorsResponse> termVector = client().termVectors(new TermVectorsRequest(indexOrAlias(), "" + i));  
                        .putList("index.analysis.analyzer.tv_test.filter", "lowercase")
                    .setPositions(true)
        // request tvs and compare from each index
                // do nothing
            client().prepareGet(indexOrAlias(), "1").setVersion(2).get();  
            fail();
import org.apache.lucene.index.PostingsEnum;
        List<Integer> shardIds = Arrays.stream(searchShardsResponse.getGroups()).map(s -> s.getShardId().id()).collect(Collectors.toList());
        }
        logger.info("Checking best tags by longest to shortest size ...");
            .setIndex("test")  
            checkBestTerms(response.getFields().terms("tags"), tags.subList((numDocs - i - 1), numDocs));
                TermVectorsResponse resp = client().prepareTermVectors(indexNames[j], String.valueOf(id))  
        // setup indices  
        String optionString = termVectorOptionsToString(ft);
        // lets see if the null term vectors are caught...
            int[] termEndOffset = endOffset[j];  
        assertThat(terms.size(), equalTo(8L));  
    }  
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).get();
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();  
        }
        refresh();
        List<String> bestTerms = new ArrayList<>();
        source.endObject();
            assertEquals("term [" + term + "] does not exist in the index; ttf should be 0!", 0, termsEnum.totalTermFreq());
                                docsAndPositions.startOffset(),
        }  
        // should return all fields that have terms vectors, some with overridden analyzer  
                builder.append("_positions");
            TermVectorsRequestBuilder request = getRequestForConfig(test);  
            if (fieldType.storeTermVectorPayloads()) {
            }
}
                    Settings.builder()
            TermVectorsResponse respExisting = client().prepareTermVectors("test", String.valueOf(i))
        for (int i = 0; i < 6; i++) {
            .endObject()  
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("tags", tags));  
            .endObject()
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("tags", "type=text"));  
            assertThat("expected " + string, string, equalTo(next.utf8ToString()));  
                withTermVectors.add(fieldName);
                .setPositions(true)
                    Settings.builder()
            "Allocating experimental units via random assignment to a treatment or control condition.",  
                .setMapping(
                    .setOffsets(true)
                    assertThat(infoString, next, notNullValue());
            }  
                    String string = values[j];
                .setSelectedFields(fieldNames)  
            for (int j = 0; j < indexNames.length; j++) {  
        TermsEnum iter0 = terms0.iterator();
 * Licensed to Elasticsearch under one or more contributor  
            TermVectorsResponse actionGet = termVector.actionGet();
        for (int id = 0; id < content.length; id++) {  
            TermVectorsRequestBuilder resp = client().prepareTermVectors("test", Integer.toString(i))
            }  
                Terms terms = fields.terms("field");
        client().prepareIndex("test").setId("0").setSource(source).get();  
        }  
            new TermVectorsRequest(indexOrAlias(), "0").selectedFields(new String[] { "existingfield" })
            PostingsEnum docsAndPositions = iterator.postings(null, PostingsEnum.ALL);
    public void testDuelESLucene() throws Exception {
        assertThat(response.getVersion(), equalTo(2L));
        XContentBuilder mapping = jsonBuilder().startObject()
 */  
                            assertThat(infoString + "startOffsets term: " + string, docsAndPositions.startOffset(), equalTo(-1));  
                    equalTo("some text here")
            Fields fields = response.getFields();
            TermVectorsResponse resp = client().prepareTermVectors(indexOrAlias(), String.valueOf(i)).setSelectedFields("field" + i).get();  
        TermsEnum iterator = terms.iterator();
        XContentBuilder source = jsonBuilder().startObject();
        int numTerms = scaledRandomIntBetween(10, 50);  
                fields[j] = resp.getFields();  
        for (Integer shardId : shardIds) {  
            case 4: {  
        for (int i = 0; i < content.length; i++) {  
        ensureGreen();
        client().prepareIndex("test").setId("667").setSource("field", "foo bar").execute().actionGet();  
        assertThat(response.getVersion(), equalTo(1L));
        refresh();
                    "field1",
                assertRequestBuilderThrows(request, test.expectedException);
                    assertThat(infoString, freq[j], equalTo(docsAndPositions.freq()));
            Fields fields = response.getFields();
        while (termsEnum.next() != null) {  
    }
        // index documents existing document
                .setFieldStatistics(true)  
            // all good  
        }  
            compareTermVectors("field1", fields[0], fields[1]);  
            + (isPositionsRequested ? "yes" : "no")
        );
import org.opensearch.common.lucene.uid.Versions;  
                .setOffsets(true)
                        .field("field", "the quick brown fox jumps over the lazy dog")  
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("index.analysis.analyzer", "keyword");
        }  
import java.util.Set;  
            String fieldName = "field" + i;
        logger.info("Setting up the index ...");
        int[][] pos = { { 2 }, { 8 }, { 3 }, { 4 }, { 7 }, { 5 }, { 1 }, { 0, 6 } };
        assertAcked(
        for (int i = 0; i < 20; i++) {
        return ret;
            // compare freq and docs  
                .setSelectedFields();
        refresh();
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSettings(settings).setMapping(mapping));
        assertThat(response.isExists(), equalTo(true));  
        assertThat("Doc doesn't exists but should", response.isExists(), equalTo(true));  
        Settings.Builder settings = Settings.builder()
                            assertThat(infoString + "endOffsets term: " + string, docsAndPositions.endOffset(), equalTo(termEndOffset[k]));
                .addAlias(new Alias("alias"))  
                );
            // request tvs from artificial document
        }
        assertThat(response.getId(), equalTo("1"));  
 * The OpenSearch Contributors require contributions made to  
            .startObject("field")  
                    .setPositions(true)  
        for (int i = 0; i < numFields; i++) {
            .setPerFieldAnalyzer(perFieldAnalyzer)  
            if (randomBoolean()) {
import org.opensearch.action.admin.indices.alias.Alias;  
            case 2: {
            }
        indexRandom(true, indexBuilders);
    public void testFilterDocFreq() throws ExecutionException, InterruptedException, IOException {
        Set<String> withTermVectors = new HashSet<>();
            Fields fields = tvResponse.getFields();
            .put("index.analysis.analyzer.my_analyzer.tokenizer", "keyword")
                .setTermStatistics(true)
                    }
            new TermVectorsRequest(indexOrAlias(), "0").selectedFields(randomBoolean() ? new String[] { "existingfield" } : null)  
            PostingsEnum docsAndPositions0 = iter0.postings(null, PostingsEnum.ALL);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            uniqueTags.add(tag);
            .startObject("field")
            builders.add(client().prepareIndex("test").setId(i + "").setSource("tags", tags));
            source.field("field" + i, "some text here");  
            if (perFieldAnalyzer.containsKey(fieldName)) {
            case 1: {
        checkAnalyzedFields(response.getFields(), withTermVectors, perFieldAnalyzer);
                            assertThat(infoString + "endOffsets term: " + string, docsAndPositions.endOffset(), equalTo(-1));
                        } else {
                    Settings.builder()
    @Override
                            assertThat(infoString + "positions for term: ", nextPosition, equalTo(-1));
    public void testNotIndexedField() throws Exception {
                    .setOffsets(true)
    public void testRandomSingleTermVectors() throws IOException {
        for (int i = 0; i < numTerms; i++) {
        assertAcked(
            .field("term_vector", optionString)  
        assertThat(actionGet.getIndex(), equalTo("test"));
            client().prepareIndex("test")  
            Terms terms = fieldsObject.terms(fieldName);
            assertThat(resp.getIndex(), equalTo("test"));
            .endObject();  
            + (isOffsetRequested ? "yes" : "no")  
    // like testSimpleTermVectors but we create fields with no term vectors  
                .setFieldStatistics(true)
        // index documents with and without term vectors
        } else {
        // version 0 means ignore version, which is the default  
        }
            case 3: {
            assertThat("term: " + string0, iter0.totalTermFreq(), equalTo(iter1.totalTermFreq()));
            if (randomBoolean()) {
        ensureGreen();  
 * KIND, either express or implied.  See the License for the
            .put(indexSettings())
            .endObject();  
        // index documents with and without term vectors
    }  
import static org.hamcrest.Matchers.notNullValue;
        // index document
        assertThat(iter1.next(), nullValue());
        for (int i = 0; i < 10; i++) {
                .field("term_vector", withTermVectors.contains(fieldName) ? "yes" : "no")
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(1).get();  
    public void testDuelWithAndWithoutTermVectors() throws IOException, ExecutionException, InterruptedException {
                TermsEnum iterator = terms.iterator();  
            for (int id = 0; id < content.length; id++) {
        // we generate as many docs as many shards we have
            }
    }
        } catch (VersionConflictEngineException e) {
            }  
                    "field3",  
            refresh();
            }
    private static String indexOrAlias() {
        assertThat(response.isExists(), equalTo(false));
        } else if (!fieldType.storeTermVectorOffsets() && !fieldType.storeTermVectorPositions()) {
            .setFieldStatistics(true)
            if (test.expectedException != null) {
        List<String> tags = new ArrayList<>();
                .setPositions(true)
            // do not test ttf or doc frequency, because here we have many
            checkBestTerms(response.getFields().terms("tags"), uniqueTags.subList((numTerms - i - 1), numTerms));
        assertThat(response.getVersion(), equalTo(1L));
                )  
                )
        String ret = "Store config: "  
        );
                .setPayloads(true)  
                        if (isOffsetRequested && storeOffsets) {  
            TermVectorsResponse response = resp.execute().actionGet();
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat("doc id: " + i + " doesn't exists but should", response.isExists(), equalTo(true));  
        assertAcked(
                storePositions = true;
                .fieldStatistics(true)
        if (!fieldType.storeTermVectors()) {
        int[] freq = { 1, 1, 1, 1, 1, 1, 1, 2 };  
    }  
        assertThat(response.getId(), equalTo("1"));
        for (int j = 0; j < values.length; j++) {
        // request tvs and compare from each index  
                assertThat("term: " + string, nextPosition, equalTo(termPos[k]));  
        assertThat(response.isExists(), equalTo(true));
            + optionString
                break;
            validFields.add(fieldName);
                    "type=text,index=false,store=true",  // no tvs
    }
            .startObject("field")
        int sumTotalTermFreq = 0;
                storeOffsets = true;  
            client().prepareIndex("test")
    }
            assertThat(resp.getIndex(), equalTo("test"));
            prepareCreate("test").setMapping(mapping)  
            assertNotNull(terms);
        String[] content = new String[] {  
import static org.hamcrest.Matchers.equalTo;
import org.apache.lucene.document.FieldType;
                    "field2",
        // From Lucene index:  
                )  
        for (int i = 4; i < 6; i++) {
            }
                        .put("index.analysis.analyzer.tv_test.tokenizer", "standard")
        TermVectorsResponse response;
        int[][] endOffset = { { 15 }, { 43 }, { 19 }, { 25 }, { 39 }, { 30 }, { 9 }, { 3, 34 } };
            + "\n";
 * SPDX-License-Identifier: Apache-2.0
                        .field("field", "the quick brown fox jumps over the lazy dog")
                            assertThat(infoString + "positions for term: " + string, nextPosition, equalTo(termPos[k]));
            assertThat("doc with index: test, type1 and id: existing", respExisting.isExists(), equalTo(true));
        assertThat(response.getId(), equalTo("1"));
        } catch (VersionConflictEngineException e) {
        checkBrownFoxTermVector(resp.getFields(), "field1", false);
                tags.add(tag);
        logger.info("--> index doc 1");
            assertThat(docsAndPositions.nextDoc(), equalTo(0));
        for (int i = 0; i < content.length; i++) {
import java.util.Map;
        XContentBuilder source = jsonBuilder().startObject();  
                    int[] termPos = pos[j];  
        String[] content = new String[] {  
            assertThat(infoString + "doc id: " + i + " doesn't exists but should", response.isExists(), equalTo(true));  
    }
            assertThat(termPos.length, equalTo(freq[j]));
            assertThat("field" + i + " :", resp.getFields().terms("field" + i), notNullValue());
                assertThat("term: " + string0, docsAndPositions0.nextPosition(), equalTo(docsAndPositions1.nextPosition()));
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).get();
            .field("term_vector", "with_positions_offsets_payloads")
    public void testFilterTermFreq() throws ExecutionException, InterruptedException, IOException {  
        try {
            Fields[] fields = new Fields[2];
                    "type=text,index=false,term_vector=yes", // no tvs
            bestTerms.add(text.utf8ToString());
            .startObject("existingfield")  
/*
public class GetTermVectorsIT extends AbstractTermVectorsTestCase {
        ); // yes tvs
            compareTermVectors("field2", fields[0], fields[1]);
        assertThat(response.isExists(), equalTo(true));  
 * this file be licensed under the Apache-2.0 license or a
                .termStatistics(true)
    }
                        } else {  
                .actionGet();
        }  
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("field1", "type=text,term_vector=with_positions_offsets"));
            .put("index.analysis.analyzer", "keyword")  
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("index.analysis.analyzer", "standard");
        }  
        String[] indexNames = new String[] { "with_tv", "without_tv" };  
            assertThat(resp, notNullValue());
import org.opensearch.core.xcontent.ToXContent;  
            // request tvs from existing document
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setMapping(mapping));  
        for (int i = 0; i < 10; i++) {  
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("index.analysis.analyzer", "keyword");
                int nextPosition = docsAndPositions.nextPosition();
                .endObject();  
        indexRandom(true, builders);  
            for (int j = 0; j < i; j++) {
                .setFieldStatistics(true)
        try {
        }
            }
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(2).setRealtime(false).get();
                indexBuilders.add(
        TestFieldSetting[] testFieldSettings = getFieldSettings();  
            }
                checkBrownFoxTermVector(fields, fieldName, false);
            response = client().prepareTermVectors("test", (numDocs - 1) + "")
        logger.info("--> index doc 1 again, so increasing the version");
            TermVectorsResponse tvResponse = client().prepareTermVectors()
            if (fieldName.startsWith("non_existing")) {
            assertThat("expected: " + string0, string0, equalTo(string1));  
                .setFilterSettings(filterSettings)
import org.opensearch.common.settings.Settings;
 * compatible open source license.
            fieldNames[i] = "field" + String.valueOf(i);
            .endObject()
                )  
                .setIndex("test")  
                    if (isOffsetRequested && storeOffsets) {  
            .put("index.number_of_shards", 1); // no dfs
                continue;  
                        int nextPosition = docsAndPositions.nextPosition();
            StringBuilder builder = new StringBuilder("with");  
        // request termvectors of artificial document from each shard  
        super(staticSettings);
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setMapping(mapping));
            assertThat(actionGet.getIndex(), equalTo("test"));  
                                infoString + "startOffsets term: " + string,  
            .startObject("existingfield")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;  
    }
import java.io.IOException;  
import java.util.Collections;
                TermsEnum iterator = terms.iterator();  
        assertThat(response.getId(), equalTo("1"));  
        assertArrayEquals(expectedTerms.toArray(), bestTerms.toArray());
                .setRouting(String.valueOf(i)) // ensure we get the stats from the same shard as existing doc
        }  
                .setOffsets(true)  
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("tags", tags));  
        XContentBuilder mapping = jsonBuilder().startObject()
import java.util.stream.Collectors;
            TermVectorsResponse resp = client().prepareTermVectors(indexOrAlias(), String.valueOf(i)).setSelectedFields("field" + i).get();
        // From Lucene index:  
        assertThat(response.getId(), equalTo("1"));
            Fields fields = response.getFields();
            .field("type", "text")
            source.field(fieldName, "some text here");
        XContentBuilder mapping = jsonBuilder().startObject().startObject("properties");
                    "type=text,index=true"
                .setTermStatistics(true)
        mapping.endObject().endObject();
                            assertThat(
        // setup indices  
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setMapping(mapping));
                .get();
            assertThat("field" + i + " :", resp.getFields().terms("field" + i), nullValue());
            // compare position, start offsets and end offsets  
            prepareCreate(indexNames[0]).setSettings(builder.build())  
 * You may obtain a copy of the License at  
        response = client().prepareTermVectors(indexOrAlias(), "0")
        // ensure no other fields are returned
    private void checkBestTerms(Terms terms, List<String> expectedTerms) throws IOException {
        Settings.Builder builder = Settings.builder()  
        logger.info("Indexing one document with tags of increasing frequencies ...");
            }  
import org.opensearch.core.common.Strings;
        logger.info("Checking best tags by highest to lowest term freq ...");
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("field1", "type=text,term_vector=with_positions_offsets"));
            + "Requested: pos-"  
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value2").get();  
        // request tvs from artificial document  
    public GetTermVectorsIT(Settings staticSettings) {
    }
        ensureGreen();
 * software distributed under the License is distributed on an
            actionGet.toXContent(jsonBuilder(), ToXContent.EMPTY_PARAMS);  
        return randomBoolean() ? "test" : "alias";  
    }
            Fields luceneTermVectors = getTermVectorsFromLucene(directoryReader, test.doc);
                    }  
        for (TestConfig test : testConfigs) {
            // check response is nevertheless serializable to json
            "Generating a random permutation of a sequence (such as when shuffling cards).",
                assertNull("term: " + string, docsAndPositions.getPayload());
        assertEquals("expected to find term statistics in exactly one shard!", 2, sumTotalTermFreq);
            for (int j = 0; j < docsAndPositions0.freq(); j++) {
                .field("term_vector", randomBoolean() ? "with_positions_offsets_payloads" : "no")  
        client().prepareIndex("test").setId("0").setSource("existingfield", "?").execute().actionGet();
        ensureGreen();  
        Collections.sort(expectedTerms);  
                .setSettings(
        logger.info("Checking best terms by highest to lowest idf ...");
                .setTermStatistics(true)  
    }
                .field("analyzer", "tv_test")
    public void testArtificialDocWithPreference() throws InterruptedException, IOException {
        boolean isOffsetRequested = randomBoolean();  
            .setOffsets(true)
import java.util.ArrayList;
            assertThat(fields.size(), equalTo(1));
        String[] fieldNames = new String[10];
                .actionGet();
        }
        TestConfig[] testConfigs = generateTestConfigs(20, testDocs, testFieldSettings);  
        }
        // lets see if the null term vectors are caught...
            if (ft.storeTermVectors()) {  
        }  
                .setSource(
    }  
                )
    public void testArtificialNoDoc() throws IOException {  
                        if (isPositionsRequested && storePositions) {
        // setup indices
                .setSelectedFields("tags")
        ensureGreen();  
        Terms terms = fields.terms(fieldName);
            checkBestTerms(response.getFields().terms("tags"), tags.subList((numTerms - i - 1), numTerms));
        );  
            case 0: {  
            filterSettings.maxNumTerms = i + 1;  
            }
        indexRandom(true, indexBuilders);
        assertThat(actionGet.isExists(), equalTo(true));
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("tags", "type=text"));  
        }
                assertThat("doc with index: " + indexNames[j] + ", type1 and id: " + id, resp.isExists(), equalTo(true));
                        .put("index.analysis.analyzer.tv_test.tokenizer", "standard")  
                assertThat(terms.size(), equalTo(8L));
                .setFieldStatistics(true)
            refresh();
        }  
                .field("type", "text")
        ft.setStoreTermVectors(storeTermVectors);  
        }  
        for (int i = 0; i < numFields; i++) {
            PostingsEnum docsAndPositions1 = iter1.postings(null, PostingsEnum.ALL);
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(2).get();  
                    if (isPositionsRequested && storePositions) {  
        }
        }
            client().prepareGet(indexOrAlias(), "1").setVersion(1).get();  
                storeTermVectors = true;
            }
            }  
            assertThat(resp.isExists(), equalTo(true));  
            .field("analyzer", "tv_test")
        // From translog:
        TermVectorsResponse response = client().prepareTermVectors(indexOrAlias(), "0").setPerFieldAnalyzer(perFieldAnalyzer).get();
                perFieldAnalyzer.put("field" + i, "keyword");
import org.opensearch.action.index.IndexRequestBuilder;
            assertThat(next1, notNullValue());
        assertThat(response.getIndex(), equalTo("test"));
                        // 0the3 4quick9 10brown15 16fox19 20jumps25 26over30
                            );  
                }
    }
    }  
                    int[] termStartOffset = startOffset[j];
            }  
            for (int k = 0; k < freq[j]; k++) {
                        // 31the34 35lazy39 40dog43
    private void checkBrownFoxTermVector(Fields fields, String fieldName, boolean withPayloads) throws IOException {
                    }
import org.apache.lucene.index.TermsEnum;  
        assertThat(response.isExists(), equalTo(true));
            // all good  
            assertThat(actionGet.isExists(), equalTo(false));
            if (fieldType.storeTermVectorPositions()) {
        ActionFuture<TermVectorsResponse> termVector = client().termVectors(  
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("index.analysis.analyzer", "standard");
        boolean storeTermVectors = false;
        }  
        logger.info("Indexing one document with tags of increasing length ...");  
            source.field(field, "the quick brown fox jumps over the lazy dog");  
 * GitHub history for details.
        assertThat(actionGet.getFields().terms("existingfield"), nullValue());
                storeOffsets = true;  
                        .put(indexSettings())  
            .endObject()
            .setTermStatistics(true)
        ft.setStoreTermVectorOffsets(storeOffsets);
        assertThat(response.isExists(), equalTo(true));
                    .setSelectedFields("field1", "field2")
        indexRandom(true, indexBuilders);
        for (int i = 0; i < 10; i++) {
            .setSelectedFields(selectedFields.toArray(Strings.EMPTY_ARRAY))
        int config = randomInt(4);
        assertThat(response.getIndex(), equalTo("test"));
        // Get search shards
        TermVectorsResponse resp = client().prepareTermVectors()
        assertThat(response.isExists(), equalTo(true));
                    "field1",
import org.apache.lucene.util.BytesRef;
import org.opensearch.plugins.Plugin;  
    private String createInfoString(boolean isPositionsRequested, boolean isOffsetRequested, String optionString) {
                .setSelectedFields();  
    public void testTermVectorsWithVersion() {  
            BytesRef next = iterator.next();
        int numDocs = scaledRandomIntBetween(10, 50); // as many terms as there are docs
            .endObject();
            assertThat("term: " + string0, iter0.docFreq(), equalTo(iter1.docFreq()));  
        Set<String> selectedFields = new HashSet<>();
 * license agreements. See the NOTICE file distributed with
        refresh();
        }  
                .setPayloads(true)  
                storeTermVectors = true;  
            .setDoc(jsonBuilder().startObject().field("field1", text).endObject())
        }
                .setSelectedFields("tags")
                    for (int k = 0; k < freq[j]; k++) {
            assertThat(freq[j], equalTo(docsAndPositions.freq()));  
                .setOffsets(isOffsetRequested)
                        .put("index.analysis.analyzer.tv_test.tokenizer", "standard")
                .setMapping(
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("index.analysis.analyzer", "standard");
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).setRealtime(false).get();
        }  
        );  
    }  
    public void testPerFieldAnalyzer() throws IOException {  
    public void testExistingFieldButNotInDocNPE() throws Exception {  
                    // DocsEnum?  
            .putList("index.analysis.normalizer.my_normalizer.filter", "lowercase");
                assertThat("Non existing field\"" + fieldName + "\" should not be returned!", fieldsObject.terms(fieldName), nullValue());
import org.opensearch.index.engine.VersionConflictEngineException;
        String[] content = new String[] { "Hello World", "hello world", "HELLO WORLD" };  
            BytesRef next0 = iter0.next();
            fail();
 *
            }  
            // all good
            String string = values[j];  
            // compare field value  
                .setPositions(true)
                    assertThat(infoString, next, notNullValue());  
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSettings(Settings.builder().put("index.refresh_interval", -1)));
    public void testSimpleTermVectors() throws IOException {  
        }
            "Generating random numbers: see Random number generation." };
        Terms terms = resp.getFields().terms("field1");
        String[] indexNames = new String[] { "with_tv", "without_tv" };
    }  
                        .putList("index.analysis.analyzer.tv_test.filter", "lowercase")
                selectedFields.add("non_existing" + i);
                assertThat(iterator.next(), nullValue());  
    }
        refresh();
        }
                        assertThat(termStartOffset.length, equalTo(freq[j]));
        for (int i = 0; i < fieldNames.length; i++) {  
        assertThat(terms0, notNullValue());  
            while (termsEnum.next() != null) {  
        for (String fieldName : fieldNames) {  
                    PostingsEnum docsAndPositions = iterator.postings(null, PostingsEnum.ALL);  
        }
        mapping.endObject().endObject();
            .field("type", "text")
        }
            TermVectorsResponse respArtificial = client().prepareTermVectors()
                        .setIndex(indexName)
            assertThat("term: " + string0, docsAndPositions0.nextDoc(), equalTo(docsAndPositions1.nextDoc()));  
                storeTermVectors = true;
        }  
                .get();  
                        .endObject()
            }  
                storePositions = true;
                    "field2",
import java.util.List;
        }
                storeTermVectors = true;
            mapping.startObject(fieldName)  
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("tags", "type=text"));
        );
        // selected fields specified including some not in the mapping  
            assertThat(response.getIndex(), equalTo("test"));
            assertThat("Existing field " + fieldName + "should have been returned", terms, notNullValue());  
                // MemoryIndex does not support payloads
            .endObject()
            prepareCreate(indexNames[1]).setSettings(builder.build())  
        List<String> uniqueTags = new ArrayList<>();
        );
        TermVectorsRequest.FilterSettings filterSettings = new TermVectorsRequest.FilterSettings();  
        XContentBuilder mapping = jsonBuilder().startObject()
            indexBuilders.add(client().prepareIndex().setIndex("test").setId(String.valueOf(i)).setSource("field1", content[i]));
        }  
            filterSettings.minWordLength = numTerms - i;
        for (String indexName : indexNames) {  
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).setRealtime(false).get();
import org.opensearch.core.xcontent.XContentBuilder;
            .startObject("properties")  
                .get();
                break;
        XContentBuilder mapping = jsonBuilder().startObject().startObject("properties");
import java.util.HashMap;
        TestDoc[] testDocs = generateTestDocs("test", testFieldSettings);  
                sumTotalTermFreq += termsEnum.totalTermFreq();
    public void testSimpleWildCards() throws IOException {
            .endObject();  
                .get();
            assertThat(next0, notNullValue());
            fail();  
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();  
            TermVectorsResponse response = resp.execute().actionGet();
                        // only return something useful if requested and stored  
            }
                        .setSource("field1", content[id], "field2", content[id])  
            "Allocating experimental units via random assignment to a treatment or control condition.",  
        // version 0 means ignore version, which is the default  
                .setFilterSettings(filterSettings)  
            prepareCreate("test").setMapping(mapping)
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();  
        for (int i = 0; i < 10; i++) {
                .actionGet();  
                .setFieldStatistics(true)
        assertThat(resp.isExists(), equalTo(true));
            for (int j = 0; j < i; j++) {
            mapping.startObject(field)
package org.opensearch.action.termvectors;
                for (int j = 0; j < values.length; j++) {
        refresh();  
                    "type=text,index=false", // no tvs  
        } catch (VersionConflictEngineException e) {
        try {
    }
                    "field0",  
        TermsEnum termsEnum = terms.iterator(); // we're guaranteed to receive terms for that field
        BytesRef text;
        for (int i = 0; i < numTerms; i++) {
            fail();  
        try {
        for (int i = 0; i < 10; i++) {
import java.util.HashSet;  
            prepareCreate("test").addAlias(new Alias("alias"))
        // version 0 means ignore version, which is the default
 * Unless required by applicable law or agreed to in writing,
            }  
        // when indexing a field that simply has a question mark, the term vectors will be null
                    jsonBuilder().startObject()
        assertThat(actionGet.getIndex(), equalTo("test"));  
        );
        client().prepareIndex("test").setId("0").setSource(source).get();
 * this work for additional information regarding copyright
                )
        assertThat(terms0.size(), equalTo(terms1.size()));
    }
            "Generating random numbers: see Random number generation.",
            // compare df and ttf
        // must be of type string and indexed.
                        .setId(String.valueOf(id))
        // selected fields not specified  
    public void testSimpleTermVectorsWithGenerate() throws IOException {
        // Since the index is empty, all of artificial document's "term_statistics" should be 0/absent
            return "no";  
        checkAnalyzedFields(response.getFields(), selectedFields, perFieldAnalyzer);
                .setTermStatistics(true)
                continue;  
                .execute()
            // compare existing tvs with artificial
            .startObject("properties")  
            return "with_offsets";
        TermVectorsRequest.FilterSettings filterSettings = new TermVectorsRequest.FilterSettings();  
                throw new IllegalArgumentException("Unsupported option: " + config);
                assertThat("term: " + string0, docsAndPositions0.endOffset(), equalTo(docsAndPositions1.endOffset()));
        }
        TermVectorsResponse actionGet = termVectors.actionGet();  
import org.apache.lucene.index.Terms;
            assertThat("doc with index: test, type1 and id: " + String.valueOf(i), respArtificial.isExists(), equalTo(true));
        for (int i = 0; i < numFields; i++) {  
import org.opensearch.common.action.ActionFuture;
                .setId(Integer.toString(i))
        Set<String> validFields = new HashSet<>();
            if (fieldType.storeTermVectorOffsets()) {
            assertThat(next, notNullValue());
        String infoString = createInfoString(isPositionsRequested, isOffsetRequested, optionString);
            TermVectorsRequestBuilder resp = client().prepareTermVectors(indexOrAlias(), Integer.toString(i))
        assertThat(response.isExists(), equalTo(true));
    public void testExistingFieldWithNoTermVectorsNoNPE() throws Exception {
        }
        switch (config) {
        source.endObject();  
            .field("analyzer", "tv_test")  
import java.util.Collection;  
            for (String fieldName : fieldNames) {  
            TermsEnum termsEnum = terms.iterator();
            Terms terms = fields.terms("field1");  
            }  
            BytesRef next1 = iter1.next();  
            }
                break;
                .setMapping("field1", "type=keyword,normalizer=my_normalizer", "field2", "type=keyword")
                        }
            + "\n"
            int[] termStartOffset = startOffset[j];
        }
                    // payloads or offsets are stored / requestd Otherwise use
    private void compareTermVectors(String fieldName, Fields fields0, Fields fields1) throws IOException {  
        assertThat(response.getId(), equalTo("1"));  
            client().prepareIndex("test").setId(Integer.toString(i)).setSource(source).execute().actionGet();  
        int[][] startOffset = { { 10 }, { 40 }, { 16 }, { 20 }, { 35 }, { 26 }, { 4 }, { 0, 31 } };  
        assertAcked(prepareCreate(indexNames[1]).setMapping("field1", "type=text,term_vector=no,analyzer=keyword"));
            // shards and do not know how documents are distributed  
                .setDoc(jsonBuilder().startObject().field("field1", content[i]).endObject())
            .endObject()
                    "field4",
        List<String> tags = new ArrayList<>();
        assertThat(response.getIndex(), equalTo("test"));
            assertThat(fields.size(), equalTo(ft.storeTermVectors() ? 1 : 0));
                break;
                    assertThat(infoString, docsAndPositions.nextDoc(), equalTo(0));
            "Transforming a data stream (such as when using a scrambler in telecommunications)." };
    public void testArtificialVsExisting() throws ExecutionException, InterruptedException, IOException {
    private void checkAnalyzedFields(Fields fieldsObject, Set<String> fieldNames, Map<String, String> perFieldAnalyzer) throws IOException {
        int numFields = 25;  
    }
        assertThat(response.getIndex(), equalTo("test"));
            indexBuilders.add(client().prepareIndex().setIndex("test").setId(String.valueOf(i)).setSource("field" + i, i));
        for (int id = 0; id < content.length; id++) {
                    "type=text,term_vector=with_positions_offsets,analyzer=my_analyzer",  
        }
        refresh();
        }
            .startObject("properties")
                    "field5",
        TermsEnum iter1 = terms1.iterator();
        filterSettings.maxNumTerms = numTerms;
            TermVectorsResponse response = client().prepareTermVectors("test", Integer.toString(i))
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(response.getIndex(), equalTo("test"));  
        // setup mapping and document source  
            compareTermVectors("field1", respExisting.getFields(), respArtificial.getFields());
                .endObject();
 * under the License.  
            client().prepareGet(indexOrAlias(), "1").setVersion(1).setRealtime(false).get();
            mapping.startObject("field" + i).field("type", "text").field("term_vector", randomBoolean() ? "yes" : "no").endObject();
                .setPositions(true)
        assertEquals("sumDocFreq should be 0 for a non-existing field!", 0, terms.getSumDocFreq());  
            return "yes";
                .setFieldStatistics(true)  
                sumDocFreq += termsEnum.docFreq();
                .setPreference("_shards:" + shardId)  
                .setDoc(jsonBuilder().startObject().field("field1", "random permutation").endObject())
        source.endObject();  
        assertEquals("expected to find term statistics in exactly one shard!", 2, sumDocFreq);  
                        // only return something useful if requested and stored
            .field("term_vector", "with_positions_offsets_payloads")  
        assertAcked(  
        ft.setStoreTermVectorPositions(storePositions);
            "Selecting a random sample of a population (important in statistical sampling).",
