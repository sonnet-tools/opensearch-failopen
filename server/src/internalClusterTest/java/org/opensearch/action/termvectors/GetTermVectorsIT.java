            BytesRef next0 = iter0.next();
                    Settings.builder()
                )
            .endObject()
        client().prepareIndex("test").setId("667").setSource("field", "foo bar").execute().actionGet();
import org.opensearch.core.xcontent.XContentBuilder;
        checkAnalyzedFields(response.getFields(), selectedFields, perFieldAnalyzer);
        TermVectorsResponse response;
        for (int id = 0; id < content.length; id++) {
                assertRequestBuilderThrows(request, test.expectedException);
        assertThat(response.getVersion(), equalTo(2L));
            mapping.startObject(fieldName)
        // setup indices
        }
        int[][] endOffset = { { 15 }, { 43 }, { 19 }, { 25 }, { 39 }, { 30 }, { 9 }, { 3, 34 } };
        int[][] startOffset = { { 10 }, { 40 }, { 16 }, { 20 }, { 35 }, { 26 }, { 4 }, { 0, 31 } };
                .actionGet();
            for (int j = 0; j < indexNames.length; j++) {
        // we generate as many docs as many shards we have
            int[] termStartOffset = startOffset[j];
                    client().prepareIndex()
        // setup indices
        source.endObject();
        }
                        }
        // index documents existing document
        refresh();
            + optionString
            assertThat("term: " + string0, iter0.docFreq(), equalTo(iter1.docFreq()));
        // lets see if the null term vectors are caught...
            assertThat(next, notNullValue());
            "Selecting a random sample of a population (important in statistical sampling).",
            .startObject("field")
            client().prepareGet(indexOrAlias(), "1").setVersion(2).setRealtime(false).get();
        }
        TermVectorsResponse response;
        assertAcked(
        List<String> bestTerms = new ArrayList<>();
            prepareCreate(indexNames[0]).setSettings(builder.build())
            actionGet.toXContent(jsonBuilder(), ToXContent.EMPTY_PARAMS);
        } catch (VersionConflictEngineException e) {
            .startObject("properties")
                    assertThat(infoString, next, notNullValue());
        assertThat(response.getId(), equalTo("1"));
        logger.info("Setting up the index ...");
        // when indexing a field that simply has a question mark, the term vectors will be null
        for (int i = 0; i < numFields; i++) {
                    PostingsEnum docsAndPositions = iterator.postings(null, PostingsEnum.ALL);
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).setRealtime(false).get();
                    assertThat(infoString, freq[j], equalTo(docsAndPositions.freq()));
    @Override
            .startObject("field")
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value2").get();
            .endObject()
        assertAcked(
        source.endObject();
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("index.analysis.analyzer", "standard");
            .setPositions(true)
                .endObject();
    public void testArtificialVsExisting() throws ExecutionException, InterruptedException, IOException {
                break;
                        .put("index.analysis.analyzer.tv_test.tokenizer", "standard")
                .actionGet();
        boolean isPositionsRequested = randomBoolean();
                        .putList("index.analysis.analyzer.tv_test.filter", "lowercase")
                selectedFields.add("non_existing" + i);
import org.opensearch.index.engine.VersionConflictEngineException;
            .endObject()
    }
        checkBrownFoxTermVector(resp.getFields(), "field1", false);
    private void checkBestTerms(Terms terms, List<String> expectedTerms) throws IOException {
        refresh();
                .get();
                perFieldAnalyzer.put("non_existing" + i, "keyword");
    }
            bestTerms.add(text.utf8ToString());
        assertThat(iterator.next(), nullValue());
            + "\n";
            BytesRef next = iterator.next();
import org.opensearch.plugins.Plugin;
                    assertThat(infoString, next, notNullValue());
        for (int i = 0; i < 4; i++) {
                assertThat(iterator.next(), nullValue());
        assertThat(terms0, notNullValue());
        int[][] endOffset = { { 15 }, { 43 }, { 19 }, { 25 }, { 39 }, { 30 }, { 9 }, { 3, 34 } };
        // request termvectors of artificial document from each shard
            Fields fields = response.getFields();
        assertThat(resp.isExists(), equalTo(true));
    }
        assertThat(response.getId(), equalTo("1"));
            // all good
            client().prepareIndex("test")
            }
            filterSettings.maxNumTerms = i + 1;
                .get();
        assertThat(iter1.next(), nullValue());
        );
            .setDoc(jsonBuilder().startObject().field("field1", text).endObject())
        assertThat(response.getId(), equalTo("1"));
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
            indexBuilders.add(client().prepareIndex().setIndex("test").setId(String.valueOf(i)).setSource("field1", content[i]));
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(2).setRealtime(false).get();
    }
            prepareCreate("test").setMapping(mapping)
            return "with_offsets";
                    "type=text,term_vector=with_positions_offsets,analyzer=my_analyzer",
                )
            compareTermVectors("field2", fields[0], fields[1]);
        super(staticSettings);
        } catch (VersionConflictEngineException e) {
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(1).get();
                assertThat(terms.size(), equalTo(8L));
                .setSource(
            uniqueTags.add(tag);
            mapping.startObject(field)
        assertAcked(
            .setOffsets(true)
        // request tvs from artificial document
                            );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
        // request tvs and compare from each index
        int sumTotalTermFreq = 0;
                .fieldStatistics(true)
        List<String> tags = new ArrayList<>();
        TermVectorsResponse response = client().prepareTermVectors(indexOrAlias(), "0").setSelectedFields("field*").get();
            Fields fields = response.getFields();
import static org.hamcrest.Matchers.nullValue;
            if (randomBoolean()) {
        }
 * ownership. Elasticsearch licenses this file to you under
                        .putList("index.analysis.analyzer.tv_test.filter", "lowercase")
            .putList("index.analysis.analyzer.my_analyzer.filter", "lowercase")
                .execute()
            .endObject()
        }
        try {
                .setFilterSettings(filterSettings)
        }
            tags.add(tag);
        assertThat(actionGet.isExists(), equalTo(true));
        for (TestConfig test : testConfigs) {
                .setTermStatistics(true)
                    "type=text,index=true"
                .setMapping("field1", "type=keyword,normalizer=my_normalizer", "field2", "type=keyword")
        XContentBuilder mapping = jsonBuilder().startObject()
        // version 0 means ignore version, which is the default
        // index document
                    "field4",
            builders.add(client().prepareIndex("test").setId(i + "").setSource("tags", tags));
        assertThat(response.getVersion(), equalTo(1L));
    public void testFilterLength() throws ExecutionException, InterruptedException, IOException {
        }
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
                    // DocsEnum?
            checkBestTerms(response.getFields().terms("tags"), tags.subList((numDocs - i - 1), numDocs));
    private void checkBrownFoxTermVector(Fields fields, String fieldName, boolean withPayloads) throws IOException {
                storeTermVectors = true;
                continue;
            .endObject();
        logger.info("Checking best tags by longest to shortest size ...");
import org.opensearch.common.settings.Settings;
        Map<String, String> perFieldAnalyzer = new HashMap<>();
            .field("analyzer", "tv_test")
        indexRandom(true, indexBuilders);
            // all good
            .field("term_vector", optionString)
        for (int i = 0; i < 10; i++) {
                withTermVectors.add(fieldName);
            assertThat(next, notNullValue());
import java.io.IOException;
            Fields[] fields = new Fields[2];
            TermVectorsResponse respArtificial = client().prepareTermVectors()
            fail();
                continue;
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).get();
        assertThat(response.getId(), equalTo("1"));
        }
            tags.add("tag_" + i);
            if (randomBoolean()) {
        assertThat(response.getIndex(), equalTo("test"));
            assertThat("doc id: " + i + " doesn't exists but should", response.isExists(), equalTo(true));
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("field1", "type=text"));
        for (Integer shardId : shardIds) {
        assertAcked(
            assertThat("Existing field " + fieldName + "should have been returned", terms, notNullValue());
            .endObject();
        assertAcked(prepareCreate(indexNames[0]).setMapping("field1", "type=text,term_vector=with_positions_offsets,analyzer=keyword"));
        assertThat(response.isExists(), equalTo(true));
        checkAnalyzedFields(response.getFields(), withTermVectors, perFieldAnalyzer);
        TermVectorsResponse actionGet = termVectors.actionGet();
            }
            if (randomBoolean()) {
        List<String> tags = new ArrayList<>();
            "Allocating experimental units via random assignment to a treatment or control condition.",
        assertThat(actionGet.getIndex(), equalTo("test"));
        for (int i = 0; i < 10; i++) {
                    "field0",
    public void testPerFieldAnalyzer() throws IOException {
        int[][] startOffset = { { 10 }, { 40 }, { 16 }, { 20 }, { 35 }, { 26 }, { 4 }, { 0, 31 } };
        }
            if (randomBoolean()) {
        TestFieldSetting[] testFieldSettings = getFieldSettings();
                .setFieldStatistics(true)
                fields[j] = resp.getFields();
            TermVectorsResponse response = request.get();
            PostingsEnum docsAndPositions = iterator.postings(null, PostingsEnum.ALL);
            // compare df and ttf
    public void testExistingFieldWithNoTermVectorsNoNPE() throws Exception {
    private void checkAnalyzedFields(Fields fieldsObject, Set<String> fieldNames, Map<String, String> perFieldAnalyzer) throws IOException {
                .setFieldStatistics(true)
            String tag = "a";
 * license agreements. See the NOTICE file distributed with
        FieldType ft = new FieldType();
        assertThat(response.getId(), equalTo("1"));
            assertThat(actionGet.getIndex(), equalTo("test"));
                tags.add(tag);
            assertThat(resp.isExists(), equalTo(true));
            assertThat("field" + i + " :", resp.getFields().terms("field" + i), notNullValue());
            .startObject("properties")
import java.util.concurrent.ExecutionException;
            for (int id = 0; id < content.length; id++) {
}
        XContentBuilder mapping = jsonBuilder().startObject().startObject("properties");
            if (perFieldAnalyzer.containsKey(fieldName)) {
        indexRandom(true, indexBuilders);
                .setPositions(isPositionsRequested)
import org.apache.lucene.index.DirectoryReader;
            .startObject("properties")
                        }
                .setSelectedFields("tags")
            Fields fields = tvResponse.getFields();
        // From translog:
        boolean storePositions = false;
                    // payloads or offsets are stored / requestd Otherwise use
                assertThat("doc with index: " + indexNames[j] + ", type1 and id: " + id, resp.isExists(), equalTo(true));
            prepareCreate(indexNames[1]).setSettings(builder.build())
    }
        }
        String infoString = createInfoString(isPositionsRequested, isOffsetRequested, optionString);
        String[] indexNames = new String[] { "with_tv", "without_tv" };
    }
            assertThat("doc id: " + i + " doesn't exists but should", response.isExists(), equalTo(true));
    private static String indexOrAlias() {
            }
        try {
                storePositions = true;
            client().prepareGet(indexOrAlias(), "1").setVersion(2).get();
                break;
                    // docs and pos only returns something if positions or
        }
                    "type=text,term_vector=with_positions_offsets,analyzer=keyword"
            BytesRef next1 = iter1.next();
        }
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("index.analysis.analyzer", "standard");
            }
            TermVectorsRequestBuilder resp = client().prepareTermVectors(indexOrAlias(), Integer.toString(i))
            fail();
                        .endObject()
                    .setSelectedFields("field1")
    }
        }
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("field1", "type=text,term_vector=with_positions_offsets"));
            checkBestTerms(response.getFields().terms("tags"), tags.subList((numTerms - i - 1), numTerms));
        XContentBuilder mapping = jsonBuilder().startObject().startObject("properties");
    }
    }
            }
            assertEquals("term [" + term + "] does not exist in the index; ttf should be 0!", 0, termsEnum.totalTermFreq());
import java.util.HashSet;
                    // do not test ttf or doc frequency, because here we have
        }
        for (int i = 0; i < 10; i++) {
                    equalTo("some text here")
        );
        boolean storeTermVectors = false;
    public void testArtificialDocWithPreference() throws InterruptedException, IOException {
 */
        assertThat(actionGet, notNullValue());
            TermVectorsResponse resp = client().prepareTermVectors(indexOrAlias(), String.valueOf(i)).setSelectedFields("field" + i).get();
        }
        logger.info("Checking best terms by highest to lowest idf ...");
            int[] termPos = pos[j];
    public void testWithKeywordAndNormalizer() throws IOException, ExecutionException, InterruptedException {
        for (int i = 0; i < numTerms; i++) {
        ensureGreen();
        XContentBuilder source = jsonBuilder().startObject();
        assertThat(actionGet, notNullValue());
                throw new IllegalArgumentException("Unsupported option: " + config);
        int config = randomInt(4);
            for (int id = 0; id < content.length; id++) {
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSettings(settings).setMapping(mapping));
            // compare position, start offsets and end offsets
                                infoString + "startOffsets term: " + string,
    }
        for (int i = 0; i < 6; i++) {
                indexBuilders.add(
        assertThat(response.getVersion(), equalTo(2L));
            assertThat(fields.size(), equalTo(1));
        // version 0 means ignore version, which is the default
            int[] termEndOffset = endOffset[j];
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        }
            for (int j = 0; j < docsAndPositions0.freq(); j++) {
 * compatible open source license.
        for (int i = 0; i < numFields; i++) {
                .setFilterSettings(filterSettings)
        assertEquals("expected to find term statistics in exactly one shard!", 2, sumTotalTermFreq);
        // version 0 means ignore version, which is the default
    }
        int numDocs = scaledRandomIntBetween(10, 50); // as many terms as there are docs
            for (String fieldName : fieldNames) {
                        .setIndex(indexName)
                        } else {
        ClusterSearchShardsResponse searchShardsResponse = client().admin().cluster().prepareSearchShards("test").get();
        XContentBuilder mapping = jsonBuilder().startObject()
        int[] freq = { 1, 1, 1, 1, 1, 1, 1, 2 };
        }
                    assertThat(infoString + "expected " + string, string, equalTo(next.utf8ToString()));
        TermsEnum iter1 = terms1.iterator();
                .get();
        return randomBoolean() ? "test" : "alias";
            .startObject("existingfield")
        for (int i = 0; i < 10; i++) {
        TermVectorsRequest.FilterSettings filterSettings = new TermVectorsRequest.FilterSettings();
                TermsEnum iterator = terms.iterator();
 * You may obtain a copy of the License at
        for (int i = 0; i < fieldNames.length; i++) {
                }
                assertThat("doc with index: " + indexNames[j] + ", type1 and id: " + id, resp.isExists(), equalTo(true));
        BytesRef text;
                    "type=integer,", // no tvs
                .setSettings(
        assertThat(response.isExists(), equalTo(true));
        assertThat(actionGet.getIndex(), equalTo("test"));
        Set<String> withTermVectors = new HashSet<>();
                            assertThat(infoString + "startOffsets term: " + string, docsAndPositions.startOffset(), equalTo(-1));
                fields[j] = resp.getFields();
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("index.analysis.analyzer", "standard");
                );
        TermVectorsResponse response = client().prepareTermVectors(indexOrAlias(), "0").setPerFieldAnalyzer(perFieldAnalyzer).get();
        ensureGreen();
                .setSelectedFields();
import java.util.List;
            tags.add(tag);
        assertAcked(prepareCreate(indexNames[1]).setMapping("field1", "type=text,term_vector=no,analyzer=keyword"));
            indexBuilders.add(client().prepareIndex().setIndex("test").setId(String.valueOf(i)).setSource("field" + i, i));
                    "type=text,index=false,term_vector=yes", // no tvs
        return Collections.singleton(MockKeywordPlugin.class);
        ft.setStoreTermVectors(storeTermVectors);
            TermVectorsResponse response = client().prepareTermVectors("test", Integer.toString(i))
                    .get();
                sumTotalTermFreq += termsEnum.totalTermFreq();
        TestConfig[] testConfigs = generateTestConfigs(20, testDocs, testFieldSettings);
import java.util.Arrays;
                    }
    }
            String fieldName = "field" + i;
        Settings.Builder builder = Settings.builder()
                .setOffsets(true)
        logger.info("Indexing one document with tags of increasing frequencies ...");
        assertThat("All term vectors should have been generated", response.getFields().size(), equalTo(numFields));
import java.util.Collection;
            compareTermVectors("field1", fields[0], fields[1]);
        refresh();
                            assertThat(infoString + "positions for term: " + string, nextPosition, equalTo(termPos[k]));
            .field("term_vector", "with_positions_offsets_payloads")
import org.apache.lucene.index.Fields;
        }
                    jsonBuilder().startObject()
                sumDocFreq += termsEnum.docFreq();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                .setPositions(true)
        assertThat(response.getIndex(), equalTo("test"));
import static org.hamcrest.Matchers.notNullValue;
                                docsAndPositions.startOffset(),
                    assertThat(infoString, docsAndPositions.nextDoc(), equalTo(0));
            ActionFuture<TermVectorsResponse> termVector = client().termVectors(new TermVectorsRequest(indexOrAlias(), "" + i));
                TermsEnum iterator = terms.iterator();
                builder.append("_offsets");
            String string1 = next1.utf8ToString();
        Collections.sort(bestTerms);
        String text = "the quick brown fox jumps over the lazy dog";
                    "field1",
            response = client().prepareTermVectors("test", (numDocs - 1) + "")
            // request tvs from existing document
                // We never configure an analyzer with payloads for this test so this is never returned
                storePositions = true;
                .setFieldStatistics(true)
import org.apache.lucene.index.Terms;
            refresh();
        String[] indexNames = new String[] { "with_tv", "without_tv" };
                    "field5",
    public void testSimpleTermVectors() throws IOException {
                assertThat("term: " + string, nextPosition, equalTo(termPos[k]));
    public void testFilterDocFreq() throws ExecutionException, InterruptedException, IOException {
                assertThat("Non existing field\"" + fieldName + "\" should not be returned!", fieldsObject.terms(fieldName), nullValue());
                builder.append("_payloads");
        String[] values = { "brown", "dog", "fox", "jumps", "lazy", "over", "quick", "the" };
                .setTermStatistics(true)
        assertThat(response.getIndex(), equalTo("test"));
 * specific language governing permissions and limitations
            assertThat(termStartOffset.length, equalTo(freq[j]));
import org.apache.lucene.index.PostingsEnum;
        for (int i = 0; i < terms0.size(); i++) {
            }
                    "field2",
            .field("type", "text")
        // request tvs and compare from each index
                        assertThat(infoString, termPos.length, equalTo(freq[j]));
                            assertThat(
import org.apache.lucene.util.BytesRef;
            Fields[] fields = new Fields[2];
                    "type=text,index=false,store=true",  // no tvs
            }
                    iterator.next().utf8ToString(),
                .addAlias(new Alias("alias"))
                .setSelectedFields(fieldNames)
    private String createInfoString(boolean isPositionsRequested, boolean isOffsetRequested, String optionString) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals("sumTotalTermFreq should be 0 for a non-existing field!", 0, terms.getSumTotalTermFreq());
            assertThat(termPos.length, equalTo(freq[j]));
                .get();
        assertThat(terms1, notNullValue());
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(1).setRealtime(false).get();
        TermVectorsResponse response;
/*
            assertThat("doc with index: test, type1 and id: existing", respExisting.isExists(), equalTo(true));
                    "type=text,index=false", // no tvs
        logger.info("Setting up the index ...");
            source.field("field" + i, "some text here");
    }
            if (randomBoolean()) {
    public void testNoSuchDoc() throws Exception {
        for (int i = 0; i < content.length; i++) {
                assertThat(iterator.next(), nullValue());
                )
            prepareCreate("test").setMapping(mapping)
 * Unless required by applicable law or agreed to in writing,
        XContentBuilder mapping = jsonBuilder().startObject()
            if (fieldType.storeTermVectorOffsets()) {
                    jsonBuilder().startObject()
import org.opensearch.core.common.Strings;
                assertThat("term: " + string, docsAndPositions.startOffset(), equalTo(termStartOffset[k]));
        } catch (VersionConflictEngineException e) {
            .endObject();
        for (int j = 0; j < values.length; j++) {
        client().prepareIndex("test").setId("1").setSource("field1", "value1", "field2", "value2").get();
        TermsEnum termsEnum = terms.iterator(); // we're guaranteed to receive terms for that field
        assertThat(response.getIndex(), equalTo("test"));
        // From Lucene index:
import org.opensearch.core.xcontent.ToXContent;
        // lets see if the null term vectors are caught...
        ActionFuture<TermVectorsResponse> termVector = client().termVectors(
                    int[] termStartOffset = startOffset[j];
 *
        }
        ensureGreen();
            TermVectorsResponse response = resp.execute().actionGet();
                        // 0the3 4quick9 10brown15 16fox19 20jumps25 26over30
        assertThat(response.getId(), equalTo("1"));
            // compare field value
        }
                .field("term_vector", withTermVectors.contains(fieldName) ? "yes" : "no")
        Terms terms0 = fields0.terms(fieldName);
                .execute()
            while (termsEnum.next() != null) {
                                equalTo(termStartOffset[k])
        assertThat(response.getVersion(), equalTo(1L));
            TermsEnum termsEnum = terms.iterator();
            .endObject()
                .field("type", "text")
        mapping.endObject().endObject();
            prepareCreate("test").setMapping(mapping)
                .setFieldStatistics(true)
            .startObject("properties")
        assertThat(response.isExists(), equalTo(true));
        }
            Terms terms = fields.terms("field1");
        }
        }
        mapping.endObject().endObject();
            TermVectorsResponse response = resp.execute().actionGet();
        boolean isOffsetRequested = randomBoolean();
        // must be of type string and indexed.
                .setFieldStatistics(true)
        for (int i = 0; i < numDocs; i++) {
            }
                .setDoc(jsonBuilder().startObject().field("field1", content[i]).endObject())
                TermVectorsResponse resp = client().prepareTermVectors(indexNames[j], String.valueOf(id))
        response = client().prepareTermVectors(indexOrAlias(), "0")
                .setSource(
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("tags", "type=text"));
                        } else {
        // when indexing a field that simply has a question mark, the term vectors will be null
        String ret = "Store config: "
        TestDoc[] testDocs = generateTestDocs("test", testFieldSettings);
                        // 31the34 35lazy39 40dog43
            case 1: {
                    if (isOffsetRequested && storeOffsets) {
                        // only return something useful if requested and stored
                storeTermVectors = true;
        // selected fields not specified
        );
                .setOffsets(true)
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
            fail();
 */
            filterSettings.maxNumTerms = i + 1;
        assertThat(response.isExists(), equalTo(true));
        boolean storeOffsets = false;
        assertThat(response.getVersion(), equalTo(2L));
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("field1", "random permutation"));
            for (int j = 0; j < i; j++) {
            refresh();
            case 3: {
                        .put(indexSettings())
            "Selecting a random sample of a population (important in statistical sampling).",
            compareTermVectors("field1", fields[0], fields[1]);
        ensureGreen();
/*
    private void compareTermVectors(String fieldName, Fields fields0, Fields fields1) throws IOException {
            }
                .get();
        assertThat(response.getVersion(), equalTo(2L));
                assertThat("term: " + string0, docsAndPositions0.endOffset(), equalTo(docsAndPositions1.endOffset()));
                .setDoc(jsonBuilder().startObject().field("field1", "random permutation").endObject())
            .field("type", "text")
        // index documents with and without term vectors
        } catch (VersionConflictEngineException e) {
            Fields fields = response.getFields();
            // compare freq and docs
                .setFilterSettings(filterSettings)
                break;
                .setTermStatistics(true)
        // setup mapping and document source
                storeTermVectors = true;
                    if (isPositionsRequested && storePositions) {
                    for (int k = 0; k < freq[j]; k++) {
            assertThat(actionGet.isExists(), equalTo(false));
                break;
            }
        int numTerms = scaledRandomIntBetween(10, 50);
                storeOffsets = true;
    public void testTermVectorsWithVersion() {
                assertThat(
                    BytesRef next = iterator.next();
            case 2: {
            .setSelectedFields(selectedFields.toArray(Strings.EMPTY_ARRAY))
            "Transforming a data stream (such as when using a scrambler in telecommunications)." };
            .endObject()
            "Generating a random permutation of a sequence (such as when shuffling cards).",
        for (int i = 0; i < 10; i++) {
        // create random per_field_analyzer and selected fields
        } else {
        );
                        .put("index.analysis.analyzer.tv_test.tokenizer", "standard")
            client().prepareIndex("test").setId(Integer.toString(i)).setSource(source).execute().actionGet();
            // request tvs from artificial document
            }
                perFieldAnalyzer.put("field" + i, "keyword");
        if (!fieldType.storeTermVectors()) {
                .setPositions(true)
            // check overridden by keyword analyzer ...
import org.apache.lucene.document.FieldType;
        indexRandom(true, indexBuilders);
            String string0 = next0.utf8ToString();
                    .setOffsets(true)
            }
            .get();
        );
/*
        client().prepareIndex("test").setId("0").setSource("anotherexistingfield", 1).execute().actionGet();
            assertThat(response.getIndex(), equalTo("test"));
        Set<String> validFields = new HashSet<>();
                    String string = values[j];
            // compare existing tvs with artificial
        ); // yes tvs
        assertArrayEquals(expectedTerms.toArray(), bestTerms.toArray());
            assertThat(infoString + "doc id: " + i + " doesn't exists but should", response.isExists(), equalTo(true));
                        .endObject()
            Terms terms = fieldsObject.terms(fieldName);
        refresh();
                    "Analyzer for " + fieldName + " should have been overridden!",
                )
        try {
        assertThat(response.isExists(), equalTo(true));
        switch (config) {
    }
            .put(indexSettings())
 * SPDX-License-Identifier: Apache-2.0
        assertThat("Doc doesn't exists but should", response.isExists(), equalTo(true));
    public void testDuelESLucene() throws Exception {
        // setup indices
        for (String indexName : indexNames) {
        assertThat(response.getVersion(), equalTo(1L));
        }
        while ((text = termsEnum.next()) != null) {
        refresh();
    public void testRandomSingleTermVectors() throws IOException {
        mapping.endObject().endObject();
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("index.analysis.analyzer", "keyword");
                .setPositions(true)
                .setSelectedFields("tags")
        }
        assertThat(terms0.size(), equalTo(terms1.size()));
            PostingsEnum docsAndPositions1 = iter1.postings(null, PostingsEnum.ALL);
            assertThat("term: " + string0, iter0.totalTermFreq(), equalTo(iter1.totalTermFreq()));
            "Generating random numbers: see Random number generation.",
 * software distributed under the License is distributed on an
            assertThat("doc with index: test, type1 and id: " + String.valueOf(i), respArtificial.isExists(), equalTo(true));
import org.opensearch.common.action.ActionFuture;
            String term = termsEnum.term().utf8ToString();
            + "Requested: pos-"
                    .setPositions(true)
 * this work for additional information regarding copyright
        assertThat(response.getIndex(), equalTo("test"));
            "Generating random numbers: see Random number generation." };
            .field("type", "text")
            tag = "tag_" + i;
        refresh();
            .put("index.analysis.analyzer.my_analyzer.tokenizer", "keyword")
            source.field(fieldName, "some text here");
        ensureGreen();
            fail();
            refresh();
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("field1", "type=text,term_vector=with_positions_offsets"));
                .execute()
        logger.info("Indexing one document with tags of increasing length ...");
            TermVectorsRequestBuilder request = getRequestForConfig(test);
                .setId(Integer.toString(i))
        for (int i = 0; i < 10; i++) {
        assertThat(iter0.next(), nullValue());
        int sumDocFreq = 0;
                        // payloads are never made by the mapping in this test
                assertThat("term: " + string0, docsAndPositions0.nextPosition(), equalTo(docsAndPositions1.nextPosition()));
        }
    public void testFilterTermFreq() throws ExecutionException, InterruptedException, IOException {
                        assertThat(termStartOffset.length, equalTo(freq[j]));
        } else if (!fieldType.storeTermVectorOffsets() && !fieldType.storeTermVectorPositions()) {
            .put("index.number_of_shards", 1); // no dfs
        logger.info("--> index doc 1 again, so increasing the version");
            assertThat(fields.size(), equalTo(fieldNames.length));
 * the Apache License, Version 2.0 (the "License"); you may
        }
    }
                assertThat("term: " + string0, docsAndPositions0.startOffset(), equalTo(docsAndPositions1.startOffset()));
            source.field(field, "the quick brown fox jumps over the lazy dog");
            .endObject()
            }
        logger.info("Indexing {} documents with tags of increasing dfs ...", numDocs);
                    .setPositions(true)
import org.opensearch.common.lucene.uid.Versions;
            }
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).get();
        XContentBuilder mapping = jsonBuilder().startObject()
        indexRandom(true, builders);
        // From Lucene index:
        assertAcked(
                tag += "a";
                // MemoryIndex does not support payloads
 *
                // do nothing
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("tags", "type=text"));
        String[] content = new String[] {
        Collections.sort(expectedTerms);
    }
                        .put(indexSettings())
        for (int i = 0; i < numTerms; i++) {
            assertThat(docsAndPositions.nextDoc(), equalTo(0));
            assertThat(freq[j], equalTo(docsAndPositions.freq()));
            for (int k = 0; k < freq[j]; k++) {
            assertThat("field" + i + " :", resp.getFields().terms("field" + i), nullValue());
                .setRouting(String.valueOf(i)) // ensure we get the stats from the same shard as existing doc
        // setup indices
    }
        XContentBuilder mapping = jsonBuilder().startObject()
                .setTermStatistics(true)
 * Modifications Copyright OpenSearch Contributors. See
            .field("type", "text")
        createIndexBasedOnFieldSettings("test", "alias", testFieldSettings);
            client().prepareGet(indexOrAlias(), "1").setVersion(1).setRealtime(false).get();
    }
        }
        assertThat(response.isExists(), equalTo(true));
            return "no";
                .endObject();
        XContentBuilder source = jsonBuilder().startObject();
            + "\n"
    }
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
        Terms terms = fields.terms(fieldName);
 *
 * Licensed to Elasticsearch under one or more contributor
            client().prepareIndex("test")
            for (int j = 0; j < indexNames.length; j++) {
                .setMapping(
            // do not test ttf or doc frequency, because here we have many
            validateResponse(response, luceneTermVectors, test);
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("tags", tags));
        for (String fieldName : fieldNames) {
        List<IndexRequestBuilder> builders = new ArrayList<>();
            new TermVectorsRequest(indexOrAlias(), "0").selectedFields(randomBoolean() ? new String[] { "existingfield" } : null)
import org.opensearch.action.admin.indices.alias.Alias;
        assertThat(response.getVersion(), equalTo(1L));
            assertThat(actionGet, notNullValue());
    }
                .setSelectedFields();
        int[] freq = { 1, 1, 1, 1, 1, 1, 1, 2 };
                    Settings.builder()
            return "yes";
            filterSettings.minWordLength = numTerms - i;
            "Allocating experimental units via random assignment to a treatment or control condition.",
                    "field3",
        try {
        logger.info("--> index doc 1");
                        // only return something useful if requested and stored
            .endObject()
        // should return only the specified valid fields, with some with overridden analyzer
        String optionString = termVectorOptionsToString(ft);
import static org.hamcrest.Matchers.equalTo;
                .setIndex("test")
                .setSelectedFields("tags")
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setMapping(mapping));
            fieldNames[i] = "field" + String.valueOf(i);
    public void testSimpleTermVectorsWithGenerate() throws IOException {
            "Generating a random permutation of a sequence (such as when shuffling cards).",
        TermVectorsResponse resp = client().prepareTermVectors()
    }
                            assertThat(infoString + "endOffsets term: " + string, docsAndPositions.endOffset(), equalTo(-1));
                break;
        source.endObject();
            assertThat(resp.getIndex(), equalTo("test"));
        // index documents with and without term vectors
            client().prepareGet(indexOrAlias(), "1").setVersion(1).get();
            }
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSettings(Settings.builder().put("index.refresh_interval", -1)));
                .setTermStatistics(true)
                        .setId(String.valueOf(id))
                    }
        ft.setStoreTermVectorPositions(storePositions);
 * The OpenSearch Contributors require contributions made to
            // all good
        String tag;
                        .field("field", "the quick brown fox jumps over the lazy dog")
    public void testDuelWithAndWithoutTermVectors() throws IOException, ExecutionException, InterruptedException {
            TermVectorsResponse resp = client().prepareTermVectors(indexOrAlias(), String.valueOf(i)).setSelectedFields("field" + i).get();
import java.util.Collections;
            assertThat(next1, notNullValue());
                storeTermVectors = true;
            response = client().prepareTermVectors("test", "1")
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(Versions.MATCH_ANY).setRealtime(false).get();
            .field("term_vector", "with_positions_offsets_payloads")
                    "field1",
            // shards and do not know how documents are distributed
        }
        }
            assertThat(fields.size(), equalTo(ft.storeTermVectors() ? 1 : 0));
        }
    }
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
            assertNotNull(terms);
        assertThat(response.getId(), equalTo("1"));
            }
    }
    public void testExistingFieldButNotInDocNPE() throws Exception {
                        assertThat(termEndOffset.length, equalTo(freq[j]));
 * under the License.
            StringBuilder builder = new StringBuilder("with");
        assertThat(response.isExists(), equalTo(true));
            if (fieldType.storeTermVectorPositions()) {
        // Since the index is empty, all of artificial document's "term_statistics" should be 0/absent
        String[] values = { "brown", "dog", "fox", "jumps", "lazy", "over", "quick", "the" };
            .field("analyzer", "tv_test")
        assertThat(response.isExists(), equalTo(true));
    // like testSimpleTermVectors but we create fields with no term vectors
            .setIndex("test")
        // version 0 means ignore version, which is the default
        Terms terms = resp.getFields().terms("field1");
            TermVectorsResponse actionGet = termVector.actionGet();
            if (fieldType.storeTermVectorPayloads()) {
                .setPayloads(true)
                .termStatistics(true)
        ft.setStoreTermVectorOffsets(storeOffsets);
                .setPayloads(true)
            assertThat("expected: " + string0, string0, equalTo(string1));
    }
                        .put("index.analysis.analyzer.tv_test.tokenizer", "standard")
                            assertThat(infoString + "endOffsets term: " + string, docsAndPositions.endOffset(), equalTo(termEndOffset[k]));
                .setOffsets(true)
                .setFieldStatistics(true)
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("index.analysis.analyzer", "standard");
                    .setOffsets(true)
                storeOffsets = true;
            .setFieldStatistics(true)
                for (int j = 0; j < values.length; j++) {
                        assertNull(infoString + "payloads for term: " + string, docsAndPositions.getPayload());
        }
        for (int i = 0; i < 20; i++) {
                .setSettings(
        for (int i = 0; i < numTerms; i++) {
                .setMapping(
public class GetTermVectorsIT extends AbstractTermVectorsTestCase {
            mapping.startObject("field" + i).field("type", "text").field("term_vector", randomBoolean() ? "yes" : "no").endObject();
            }
        TermVectorsResponse response = client().prepareTermVectors("test", "1").get();
 * this file be licensed under the Apache-2.0 license or a
        int[][] pos = { { 2 }, { 8 }, { 3 }, { 4 }, { 7 }, { 5 }, { 1 }, { 0, 6 } };
                        if (isPositionsRequested && storePositions) {
            assertThat(resp, notNullValue());
        response = client().prepareTermVectors(indexOrAlias(), "1").setVersion(2).get();
                .setIndex("test")
        ensureGreen();
            TermVectorsResponse tvResponse = client().prepareTermVectors()
        TermVectorsResponse actionGet = termVector.actionGet();
    public static String termVectorOptionsToString(FieldType fieldType) {
                    // many shards and do not know how documents are distributed
        // ensure no other fields are returned
                int nextPosition = docsAndPositions.nextPosition();
                    Settings.builder()
        );
                .field("analyzer", "tv_test")
            .setTermStatistics(true)
        int numFields = 25;
            if (fieldName.startsWith("non_existing")) {
        ensureGreen();
                            assertThat(infoString + "positions for term: ", nextPosition, equalTo(-1));
            assertThat("term: " + string0, docsAndPositions0.nextDoc(), equalTo(docsAndPositions1.nextDoc()));
        TermsEnum iterator = terms.iterator();
                        if (isOffsetRequested && storeOffsets) {
            default:
        client().prepareIndex("test").setId("0").setSource(source).get();
        for (String field : fieldNames) {
        List<String> tags = new ArrayList<>();
import org.opensearch.action.index.IndexRequestBuilder;
        ActionFuture<TermVectorsResponse> termVectors = client().termVectors(
            + (isPositionsRequested ? "yes" : "no")
                .setSettings(
        ensureGreen();
        assertThat(actionGet.getFields().terms("existingfield"), nullValue());
        // index a single document with prepared source
        assertAcked(
        assertThat(actionGet.isExists(), equalTo(true));
    }
            // all good
 */
        }
        Settings.Builder settings = Settings.builder().put(indexSettings()).put("index.analysis.analyzer", "keyword");
            "Selecting a random sample of a population (important in statistical sampling).",
        indexRandom(true, indexBuilders);
    public void testArtificialNoDoc() throws IOException {
        for (int i = 0; i < content.length; i++) {
                assertNull("term: " + string, docsAndPositions.getPayload());
            new TermVectorsRequest(indexOrAlias(), "0").selectedFields(new String[] { "existingfield" })
import org.opensearch.test.MockKeywordPlugin;
            PostingsEnum docsAndPositions0 = iter0.postings(null, PostingsEnum.ALL);
                );
        }
        for (String indexName : indexNames) {
                        // 0the3 4quick9 10brown15 16fox19 20jumps25 26over30
        XContentBuilder source = jsonBuilder().startObject();
                assertThat("term: " + string, docsAndPositions.endOffset(), equalTo(termEndOffset[k]));
        assertThat(terms.size(), equalTo(8L));
        assertEquals("sumDocFreq should be 0 for a non-existing field!", 0, terms.getSumDocFreq());
                .setOffsets(isOffsetRequested)
            .startObject("existingfield")
        for (int i = 0; i < numTerms; i++) {
        }
            }
            .setPerFieldAnalyzer(perFieldAnalyzer)
        assertThat(response.getIndex(), equalTo("test"));
        }
                selectedFields.add("field" + i);
        // should return all fields that have terms vectors, some with overridden analyzer
            .startObject("properties")
        filterSettings.maxNumTerms = numTerms;
                        .field("field", "the quick brown fox jumps over the lazy dog")
        List<Integer> shardIds = Arrays.stream(searchShardsResponse.getGroups()).map(s -> s.getShardId().id()).collect(Collectors.toList());
import java.util.Set;
                .setPositions(true)
        }
        ensureGreen();
 * KIND, either express or implied.  See the License for the
                indexBuilders.add(client().prepareIndex().setIndex(indexName).setId(String.valueOf(id)).setSource("field1", content[id]));
                        int nextPosition = docsAndPositions.nextPosition();
            }
        int numFields = 25;
        }
        // selected fields specified including some not in the mapping
        client().prepareIndex("test").setId("0").setSource("existingfield", "?").execute().actionGet();
                        .setSource("field1", content[id], "field2", content[id])
            checkBrownFoxTermVector(fields, "field", true);
    }
import org.apache.lucene.index.TermsEnum;
    public GetTermVectorsIT(Settings staticSettings) {
import java.util.stream.Collectors;
        // From translog:
                .actionGet();
                    int[] termEndOffset = endOffset[j];
                )
    public void testNotIndexedField() throws Exception {
        while (termsEnum.next() != null) {
 * GitHub history for details.
            .field("term_vector", "with_positions_offsets_payloads")
        XContentBuilder mapping = jsonBuilder().startObject().startObject("properties");
            }
    }
        assertThat(response.isExists(), equalTo(false));
            TermVectorsResponse respExisting = client().prepareTermVectors("test", String.valueOf(i))
        } else if (fieldType.storeTermVectorOffsets() && !fieldType.storeTermVectorPositions()) {
        );
            if (test.expectedException != null) {
                checkBrownFoxTermVector(fields, fieldName, false);
            }
            assertThat(resp.getIndex(), equalTo("test"));
        for (int i = 4; i < 6; i++) {
            return builder.toString();
        // setup indices
        return ret;
            // check response is nevertheless serializable to json
        Settings.Builder settings = Settings.builder()
        DirectoryReader directoryReader = indexDocsWithLucene(testDocs);
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setMapping(mapping));
            compareTermVectors("field1", respExisting.getFields(), respArtificial.getFields());
import java.util.HashMap;
            validFields.add(fieldName);
            }
            TermVectorsRequestBuilder resp = client().prepareTermVectors("test", Integer.toString(i))
            assertThat("expected " + string, string, equalTo(next.utf8ToString()));
            .field("type", "text")
            assertThat(next0, notNullValue());
        assertThat(response.getId(), equalTo("1"));
            }
                    .get();
                .setTermStatistics(true)
        TermsEnum iter0 = terms0.iterator();
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("tags", tags));
        TermVectorsRequest.FilterSettings filterSettings = new TermVectorsRequest.FilterSettings();
import java.util.Map;
            if (ft.storeTermVectors()) {
                        // 31the34 35lazy39 40dog43
        Terms terms1 = fields1.terms(fieldName);
        }
            response = client().prepareTermVectors("test", "1")
        for (int i = 0; i < numDocs; i++) {
        client().prepareIndex("test").setId("0").setSource(source).get();
            for (int j = 0; j < i; j++) {
            .put("index.analysis.analyzer", "keyword")
        // Get search shards
            checkBestTerms(response.getFields().terms("tags"), uniqueTags.subList((numTerms - i - 1), numTerms));
                    "field2",
        final TermsEnum termsEnum = terms.iterator();
                TermVectorsResponse resp = client().prepareTermVectors(indexNames[j], String.valueOf(id))
        int numTerms = scaledRandomIntBetween(10, 50);
            .startObject("field")
        for (int i = 0; i < numFields; i++) {
                .field("type", "text")
            }
        assertThat(actionGet.getFields().terms("existingfield"), nullValue());
            assertThat("term: " + string0, docsAndPositions0.freq(), equalTo(docsAndPositions1.freq()));
            .field("term_vector", "with_positions_offsets_payloads")
            .endObject()
            "Allocating experimental units via random assignment to a treatment or control condition.",
        for (int id = 0; id < content.length; id++) {
            .putList("index.analysis.normalizer.my_normalizer.filter", "lowercase");
        }
            assertThat(termEndOffset.length, equalTo(freq[j]));
        String[] content = new String[] { "Hello World", "hello world", "HELLO WORLD" };
                    "type=keyword", // yes tvs
            + (isOffsetRequested ? "yes" : "no")
        Set<String> selectedFields = new HashSet<>();
                    int[] termPos = pos[j];
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setMapping(mapping));
 *    http://www.apache.org/licenses/LICENSE-2.0
            .put(indexSettings())
                builder.append("_positions");
                )
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setMapping(mapping));
        refresh();
                Terms terms = fields.terms("field");
                )
        String[] content = new String[] {
                .setId(Integer.toString(i))
        TermVectorsRequest.FilterSettings filterSettings = new TermVectorsRequest.FilterSettings();
    }
 * not use this file except in compliance with the License.
            + ", offsets-"
                .setOffsets(true)
                .setPreference("_shards:" + shardId)
        logger.info("Checking best tags by highest to lowest term freq ...");
            }
            prepareCreate("test").addAlias(new Alias("alias"))
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("tags", "type=text"));
                    .setSelectedFields("field1", "field2")
            Fields luceneTermVectors = getTermVectorsFromLucene(directoryReader, test.doc);
            String string = values[j];
            .endObject();
            case 4: {
            .get();
        assertThat(response.getIndex(), equalTo("test"));
                .get();
            case 0: {
                        .putList("index.analysis.analyzer.tv_test.filter", "lowercase")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
package org.opensearch.action.termvectors;
    public void testSimpleWildCards() throws IOException {
        logger.info("Setting up the index ...");
        // setup indices with mapping
        assertEquals("expected to find term statistics in exactly one shard!", 2, sumDocFreq);
        assertThat("More fields than expected are returned!", fieldsObject.size(), equalTo(validFields.size()));
        List<String> uniqueTags = new ArrayList<>();
                .field("term_vector", randomBoolean() ? "with_positions_offsets_payloads" : "no")
        int[][] pos = { { 2 }, { 8 }, { 3 }, { 4 }, { 7 }, { 5 }, { 1 }, { 0, 6 } };
            }
            .endObject();
                    }
        String[] fieldNames = new String[10];
            }
import java.util.ArrayList;
            .endObject()
