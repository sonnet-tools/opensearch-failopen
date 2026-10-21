        esBuffer = new InputStreamStreamInput(esInBuffer);
package org.opensearch.action.termvectors;
 *
        type.setStoreTermVectors(true);
import org.apache.lucene.index.IndexWriter;
        // read
        conf.setOpenMode(OpenMode.CREATE);
        outResponse = new TermVectorsResponse("a", "c");
        dr.close();
    // issue #12311
        TermVectorsRequest tvr = new TermVectorsRequest(null, null);
}
 */
        boolean threwException = false;
 * compatible open source license.
import org.apache.lucene.document.FieldType;
        ids.add("2");
        bytes = StreamsUtils.copyToBytesFromClasspath("/org/opensearch/action/termvectors/multiRequest2.json");
        FieldType type = new FieldType(TextField.TYPE_STORED);
        esInBuffer = new ByteArrayInputStream(outBuffer.toByteArray());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        out = new OutputStreamStreamOutput(outBuffer);
        additionalFields = "";
        );
    }
        additionalFields = "b,c  ,d, e  ";
        TermVectorsRequest tvr = new TermVectorsRequest(null, null);
import java.io.ByteArrayOutputStream;
import org.apache.lucene.search.TopDocs;
        assertThat(tvr.positions(), equalTo(false));
            request.writeTo(out);
        Fields fields = dr.termVectors().get(doc);
import org.opensearch.core.xcontent.MediaTypeRegistry;
        writeEmptyTermVector(outResponse);
    }
        type.setStoreTermVectors(true);
        assertThat(fields.terms("title"), Matchers.notNullValue());
            ByteArrayInputStream opensearchInBuffer = new ByteArrayInputStream(outBuffer.toByteArray());
            // write
            InputStreamStreamInput opensearchBuffer = new InputStreamStreamInput(opensearchInBuffer);
            assertThat(singleRequest.fieldStatistics(), equalTo(false));
 * this file be licensed under the Apache-2.0 license or a
            request.payloads(random().nextBoolean());
import org.apache.lucene.search.ScoreDoc;
        for (int i = 0; i < 10; i++) {
        ids.add("1");
import org.opensearch.test.StreamsUtils;
        assertThat(fields.contains("b"), equalTo(true));
        ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
            assertThat(singleRequest.payloads(), equalTo(false));
import java.util.Set;
        IndexWriter writer = new IndexWriter(dir, conf);
            TermVectorsRequest req2 = new TermVectorsRequest(opensearchBuffer);
 * Unless required by applicable law or agreed to in writing,
        assertThat(tvr.payloads(), equalTo(true));
        dir.close();
            XContentParser parser = createParser(JsonXContent.jsonXContent, inputBytes);
        IndexSearcher s = new IndexSearcher(dr);
        ScoreDoc[] scoreDocs = search.scoreDocs;
        InputStreamStreamInput esBuffer = new InputStreamStreamInput(esInBuffer);
import org.apache.lucene.index.Fields;
/*
        assertThat(fields.contains("c"), equalTo(true));
/*
        request = new MultiTermVectorsRequest();
        type.freeze();
/*
import org.apache.lucene.search.IndexSearcher;
import org.opensearch.action.termvectors.TermVectorsRequest.Flag;
    public void testStreamResponse() throws Exception {
            assertThat(request.filterSettings().maxNumTerms, equalTo(20));
        Document d = new Document();
    private void writeStandardTermVector(TermVectorsResponse outResponse) throws IOException {
        FieldType type = new FieldType(TextField.TYPE_STORED);
        DirectoryReader dr = DirectoryReader.open(dir);
        writer.updateDocument(new Term("id", "abc"), d);
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
            assertThat(request.filterSettings().maxTermFreq, equalTo(20));
        dir.close();
import org.apache.lucene.index.Term;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        Fields fields = inResponse.getFields();
            request.doc(new BytesArray("{}"), randomBoolean(), MediaTypeRegistry.JSON);
            assertThat(singleRequest.index(), equalTo("testidx"));
        IndexSearcher s = new IndexSearcher(dr);
        type.setStoreTermVectorPositions(true);
    private void checkIfStandardTermVector(TermVectorsResponse inResponse) throws IOException {
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
        type.setStoreTermVectorPayloads(false);
        TopDocs search = s.search(new TermQuery(new Term("id", "abc")), 1);
        Set<String> ids = new HashSet<>();
        RestTermVectorsAction.addFieldStringsFromParameter(tvr, additionalFields);
import org.hamcrest.Matchers;
 * ownership. Elasticsearch licenses this file to you under
    void checkParsedFilterParameters(MultiTermVectorsRequest multiRequest) {
        BytesReference inputBytes = new BytesArray(
    }
import org.opensearch.rest.action.document.RestTermVectorsAction;
        ScoreDoc[] scoreDocs = search.scoreDocs;
            TermVectorsRequest request = new TermVectorsRequest("index", "id");
        outResponse.setExists(true);
        TermVectorsResponse inResponse = new TermVectorsResponse(esBuffer);
        ByteArrayInputStream esInBuffer = new ByteArrayInputStream(outBuffer.toByteArray());
            assertThat(request.filterSettings().minTermFreq, equalTo(1));
    }
import java.util.Arrays;
        additionalFields = "";
        outResponse.setExists(true);
import org.opensearch.common.xcontent.json.JsonXContent;
            ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
        String additionalFields = "b,c  ,d, e  ";
        outResponse.setFields(fields, null, flags, fields);
        assertThat(fields.size(), equalTo(2));
import org.apache.lucene.document.Field;
        fields.add("b");
        for (TermVectorsRequest request : multiRequest.requests) {
        RestTermVectorsAction.addFieldStringsFromParameter(tvr, additionalFields);
        MultiTermVectorsRequest request = new MultiTermVectorsRequest();
        d.add(new Field("id", "abc", StringField.TYPE_STORED));
        MultiTermVectorsRequest request = new MultiTermVectorsRequest();
        BytesReference inputBytes = new BytesArray(
        assertThat(tvr.selectedFields(), equalTo(null));
            assertThat(singleRequest.termStatistics(), equalTo(true));
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
    public void testRequestParsingThrowsException() {
 */
            assertThat(singleRequest.offsets(), equalTo(false));
        Document d = new Document();
        EnumSet<Flag> flags = EnumSet.of(Flag.Positions, Flag.Offsets);
        writer.commit();
import java.io.IOException;
        fields.add("a");
        RestTermVectorsAction.addFieldStringsFromParameter(tvr, additionalFields);
 * SPDX-License-Identifier: Apache-2.0
            assertThat(request.offsets(), equalTo(req2.offsets()));
import org.apache.lucene.index.IndexWriterConfig;
        fields.add("c");
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentParser;
            assertTrue(ids.remove(request.id()));
 * specific language governing permissions and limitations
        writer.close();
            OutputStreamStreamOutput out = new OutputStreamStreamOutput(outBuffer);
        TermVectorsRequest.parseRequest(tvr, parser);
        assertThat(fields.contains("e"), equalTo(true));
        assertTrue(inResponse.isExists());
        outResponse.setFields(termVectors, null, flags, termVectors);
        Set<String> ids = new HashSet<>(Arrays.asList("1", "2"));
        writer.close();
        inResponse = new TermVectorsResponse(esBuffer);
        d.add(new Field("id", "abc", StringField.TYPE_STORED));
 * license agreements. See the NOTICE file distributed with
        checkIfStandardTermVector(inResponse);
import org.opensearch.core.common.bytes.BytesReference;
            assertThat(request.fieldStatistics(), equalTo(req2.fieldStatistics()));
    public void testMultiParserFilter() throws Exception {
        }
        conf.setOpenMode(OpenMode.CREATE);
        XContentParser data = createParser(JsonXContent.jsonXContent, bytes);
        assertThat(threwException, equalTo(true));
        DirectoryReader dr = DirectoryReader.open(dir);
            assertThat(request.positions(), equalTo(req2.positions()));
        // write
 * Licensed to Elasticsearch under one or more contributor
 * this work for additional information regarding copyright
 *
        assertThat(fields.contains("a"), equalTo(true));
import org.apache.lucene.document.TextField;
    }
        assertThat(tvr.offsets(), equalTo(false));
        try {
            " {\"fields\" : [\"a\",  \"b\",\"c\"], \"offsets\":false, \"positions\":false, \"payloads\":true}"
            assertThat(request.filterSettings().minWordLength, equalTo(1));
        int doc = scoreDocs[0].doc;
            assertThat(request.payloads(), equalTo(req2.payloads()));
        }
        outBuffer = new ByteArrayOutputStream();
            assertThat(request.routing(), equalTo(null));
        checkParsedParameters(request);
            assertThat(request.preference(), equalTo(pref));
            request.termStatistics(random().nextBoolean());
    }
            assertThat(request.filterSettings().maxDocFreq, equalTo(20));
    }
            request.offsets(random().nextBoolean());
        request.add(new TermVectorsRequest(), data);
    public void testMultiParser() throws Exception {
        outResponse.writeTo(out);
        XContentParser parser = createParser(JsonXContent.jsonXContent, inputBytes);
        IndexWriterConfig conf = new IndexWriterConfig(new StandardAnalyzer());
        EnumSet<Flag> flags = EnumSet.of(Flag.Positions, Flag.Offsets);
        Directory dir = newDirectory();
        byte[] bytes = StreamsUtils.copyToBytesFromClasspath("/org/opensearch/action/termvectors/multiRequest3.json");
import org.apache.lucene.document.StringField;
        TermVectorsResponse outResponse = new TermVectorsResponse("a", "c");
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.TermQuery;
 * not use this file except in compliance with the License.
        RestTermVectorsAction.addFieldStringsFromParameter(tvr, additionalFields);
 * the Apache License, Version 2.0 (the "License"); you may
    }
    private void writeEmptyTermVector(TermVectorsResponse outResponse) throws IOException {
        Set<String> fields = new HashSet<>();
import static org.hamcrest.Matchers.equalTo;
        type.setStoreTermVectorOffsets(true);
        Directory dir = newDirectory();
            assertThat(request.filterSettings().minDocFreq, equalTo(1));
        tvr = new TermVectorsRequest(null, null);
            assertThat(singleRequest.selectedFields(), equalTo(fields));
            " {\"fields\" : \"a,  b,c   \", \"offsets\":false, \"positions\":false, \"payloads\":true, \"meaningless_term\":2}"
 * The OpenSearch Contributors require contributions made to
import java.util.HashSet;
 * under the License.
        type.setStoreTermVectorOffsets(true);
            request.preference(pref);
import org.opensearch.test.OpenSearchTestCase;
        request.add(new TermVectorsRequest(), data);
        assertThat(fields.terms("desc"), Matchers.notNullValue());
            assertNotNull(request.filterSettings());
        byte[] bytes = StreamsUtils.copyToBytesFromClasspath("/org/opensearch/action/termvectors/multiRequest1.json");
        checkParsedFilterParameters(request);
        inputBytes = new BytesArray(" {\"offsets\":false, \"positions\":false, \"payloads\":true}");
        dr.close();
            threwException = true;
        assertThat(tvr.selectedFields().size(), equalTo(4));
    public void testStreamRequest() throws IOException {
 * software distributed under the License is distributed on an
 * GitHub history for details.
        writeStandardTermVector(outResponse);
            assertThat(request.index(), equalTo("testidx"));
    }
        parser = createParser(JsonXContent.jsonXContent, inputBytes);
import org.apache.lucene.store.Directory;
        Fields termVectors = dr.termVectors().get(doc);
            assertThat(request.termStatistics(), equalTo(req2.termStatistics()));
        // write
        );
        assertTrue(ids.isEmpty());
            assertThat(singleRequest.id(), Matchers.anyOf(Matchers.equalTo("1"), Matchers.equalTo("2")));
        writer.updateDocument(new Term("id", "abc"), d);
        data = createParser(JsonXContent.jsonXContent, new BytesArray(bytes));
 *
        IndexWriterConfig conf = new IndexWriterConfig(new StandardAnalyzer());
public class TermVectorsUnitTests extends OpenSearchTestCase {
        type.setStoreTermVectorPayloads(false);
import org.opensearch.core.common.bytes.BytesArray;
        // see if correct
        TermVectorsRequest.parseRequest(tvr, parser);
            assertThat(request.filterSettings().maxWordLength, equalTo(20));
        type.setStoreTermVectorPositions(true);
 */
        OutputStreamStreamOutput out = new OutputStreamStreamOutput(outBuffer);
import java.io.ByteArrayInputStream;
        TopDocs search = s.search(new TermQuery(new Term("id", "abc")), 1);
        checkParsedParameters(request);
            request.positions(random().nextBoolean());
            assertThat(singleRequest.positions(), equalTo(false));
        } catch (Exception e) {
            // read
        request.add(new TermVectorsRequest(), data);
        for (TermVectorsRequest singleRequest : request.requests) {
        type.freeze();
        assertThat(tvr.selectedFields().size(), equalTo(5));
            assertEquals(new BytesArray("{}"), request.doc());
            assertEquals(MediaTypeRegistry.JSON, request.xContentType());
    void checkParsedParameters(MultiTermVectorsRequest request) {
    public void testRestRequestParsing() throws Exception {
        IndexWriter writer = new IndexWriter(dir, conf);
        d.add(new Field("desc", "the1 quick brown fox jumps over  the1 lazy dog", type));
        int doc = scoreDocs[0].doc;
        }
            TermVectorsRequest.parseRequest(tvr, parser);
        XContentParser data = createParser(JsonXContent.jsonXContent, bytes);
        }
        outResponse.writeTo(out);
            request.fieldStatistics(random().nextBoolean());
        writer.commit();
    }
        d.add(new Field("title", "the1 quick brown fox jumps over  the1 lazy dog", type));
            String pref = random().nextBoolean() ? "somePreference" : null;
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(fields.contains("d"), equalTo(true));
import org.apache.lucene.document.Document;
 * You may obtain a copy of the License at
        // read
    }
import org.apache.lucene.index.DirectoryReader;
        Set<String> fields = tvr.selectedFields();
import java.util.EnumSet;
