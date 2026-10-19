        d.add(new Field("id", "abc", StringField.TYPE_STORED));
            request.preference(pref);
            assertThat(request.filterSettings().minDocFreq, equalTo(1));  
        IndexSearcher s = new IndexSearcher(dr);
        assertThat(fields.contains("c"), equalTo(true));
        BytesReference inputBytes = new BytesArray(
        Set<String> fields = new HashSet<>();
        }
        writer.commit();
    public void testStreamRequest() throws IOException {
            assertThat(request.filterSettings().maxWordLength, equalTo(20));  
        BytesReference inputBytes = new BytesArray(  
package org.opensearch.action.termvectors;
            TermVectorsRequest request = new TermVectorsRequest("index", "id");
            TermVectorsRequest.parseRequest(tvr, parser);  
            request.offsets(random().nextBoolean());
        Directory dir = newDirectory();
import org.apache.lucene.store.Directory;
import org.opensearch.test.StreamsUtils;
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
        byte[] bytes = StreamsUtils.copyToBytesFromClasspath("/org/opensearch/action/termvectors/multiRequest3.json");
            assertThat(request.filterSettings().maxDocFreq, equalTo(20));
/*  
 */  
        TermVectorsRequest tvr = new TermVectorsRequest(null, null);
import static org.hamcrest.Matchers.equalTo;  
            " {\"fields\" : \"a,  b,c   \", \"offsets\":false, \"positions\":false, \"payloads\":true, \"meaningless_term\":2}"  
        Fields termVectors = dr.termVectors().get(doc);
            assertThat(request.routing(), equalTo(null));  
            assertThat(singleRequest.selectedFields(), equalTo(fields));
            assertThat(singleRequest.positions(), equalTo(false));
        int doc = scoreDocs[0].doc;
        Fields fields = inResponse.getFields();
        checkParsedFilterParameters(request);  
        writer.updateDocument(new Term("id", "abc"), d);  
        EnumSet<Flag> flags = EnumSet.of(Flag.Positions, Flag.Offsets);
        MultiTermVectorsRequest request = new MultiTermVectorsRequest();  
        request.add(new TermVectorsRequest(), data);
import org.opensearch.core.xcontent.XContentParser;
 * You may obtain a copy of the License at  
    }
        IndexWriter writer = new IndexWriter(dir, conf);
            assertThat(request.offsets(), equalTo(req2.offsets()));  
 * license agreements. See the NOTICE file distributed with
 */  
    void checkParsedFilterParameters(MultiTermVectorsRequest multiRequest) {  
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.Term;  
        FieldType type = new FieldType(TextField.TYPE_STORED);  
            assertThat(singleRequest.offsets(), equalTo(false));  
    public void testStreamResponse() throws Exception {  
        inputBytes = new BytesArray(" {\"offsets\":false, \"positions\":false, \"payloads\":true}");  
            request.doc(new BytesArray("{}"), randomBoolean(), MediaTypeRegistry.JSON);  
            // read
        outResponse.setExists(true);
        bytes = StreamsUtils.copyToBytesFromClasspath("/org/opensearch/action/termvectors/multiRequest2.json");
 */
            ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();  
            assertThat(request.filterSettings().minWordLength, equalTo(1));
        TermVectorsResponse inResponse = new TermVectorsResponse(esBuffer);
        assertTrue(inResponse.isExists());
}
        XContentParser data = createParser(JsonXContent.jsonXContent, bytes);
    }
        additionalFields = "";  
 * The OpenSearch Contributors require contributions made to  
        checkParsedParameters(request);
        type.freeze();
 * SPDX-License-Identifier: Apache-2.0
        fields.add("c");
        assertThat(fields.contains("a"), equalTo(true));  
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
 * specific language governing permissions and limitations
            assertThat(request.preference(), equalTo(pref));
        d.add(new Field("id", "abc", StringField.TYPE_STORED));
            assertThat(request.index(), equalTo("testidx"));  
        assertThat(fields.size(), equalTo(2));
import java.util.Set;
        Fields fields = dr.termVectors().get(doc);
    }
 * software distributed under the License is distributed on an
        // read
    }
            assertThat(singleRequest.fieldStatistics(), equalTo(false));
    }  
        additionalFields = "b,c  ,d, e  ";
        }
            assertThat(request.filterSettings().maxNumTerms, equalTo(20));  
        writer.close();
        assertThat(fields.terms("title"), Matchers.notNullValue());  
 * Unless required by applicable law or agreed to in writing,
        IndexWriter writer = new IndexWriter(dir, conf);
            " {\"fields\" : [\"a\",  \"b\",\"c\"], \"offsets\":false, \"positions\":false, \"payloads\":true}"
        writeEmptyTermVector(outResponse);
            request.positions(random().nextBoolean());
        Set<String> fields = tvr.selectedFields();
        type.setStoreTermVectorOffsets(true);
import org.hamcrest.Matchers;
        conf.setOpenMode(OpenMode.CREATE);
        esInBuffer = new ByteArrayInputStream(outBuffer.toByteArray());
import org.apache.lucene.document.Field;  
        assertThat(tvr.selectedFields().size(), equalTo(4));  
import org.apache.lucene.search.ScoreDoc;
        XContentParser data = createParser(JsonXContent.jsonXContent, bytes);
        writer.close();
    private void checkIfStandardTermVector(TermVectorsResponse inResponse) throws IOException {  
 * GitHub history for details.
            assertEquals(new BytesArray("{}"), request.doc());
    }  
            assertThat(request.positions(), equalTo(req2.positions()));  
        for (TermVectorsRequest singleRequest : request.requests) {
        outResponse.setFields(termVectors, null, flags, termVectors);  
        outResponse = new TermVectorsResponse("a", "c");  
 * not use this file except in compliance with the License.
        XContentParser parser = createParser(JsonXContent.jsonXContent, inputBytes);
 * Licensed to Elasticsearch under one or more contributor  
        type.setStoreTermVectorPayloads(false);
        byte[] bytes = StreamsUtils.copyToBytesFromClasspath("/org/opensearch/action/termvectors/multiRequest1.json");
        assertThat(fields.contains("d"), equalTo(true));  
        DirectoryReader dr = DirectoryReader.open(dir);
 * under the License.  
            assertThat(request.filterSettings().maxTermFreq, equalTo(20));
        outResponse.writeTo(out);
            InputStreamStreamInput opensearchBuffer = new InputStreamStreamInput(opensearchInBuffer);  
            ByteArrayInputStream opensearchInBuffer = new ByteArrayInputStream(outBuffer.toByteArray());
        assertThat(fields.contains("e"), equalTo(true));
            // write
        TopDocs search = s.search(new TermQuery(new Term("id", "abc")), 1);
        assertThat(threwException, equalTo(true));
        TermVectorsRequest tvr = new TermVectorsRequest(null, null);
        assertThat(fields.contains("b"), equalTo(true));
    public void testMultiParserFilter() throws Exception {  
        d.add(new Field("title", "the1 quick brown fox jumps over  the1 lazy dog", type));
import org.apache.lucene.document.TextField;  
        fields.add("b");  
        IndexSearcher s = new IndexSearcher(dr);  
        parser = createParser(JsonXContent.jsonXContent, inputBytes);
import org.apache.lucene.index.IndexWriter;  
            request.writeTo(out);
        TermVectorsRequest.parseRequest(tvr, parser);  
        boolean threwException = false;  
        out = new OutputStreamStreamOutput(outBuffer);
        type.setStoreTermVectorPayloads(false);
import java.util.HashSet;  
            assertThat(request.payloads(), equalTo(req2.payloads()));
            request.termStatistics(random().nextBoolean());  
import org.opensearch.action.termvectors.TermVectorsRequest.Flag;  
        RestTermVectorsAction.addFieldStringsFromParameter(tvr, additionalFields);
        );
        ScoreDoc[] scoreDocs = search.scoreDocs;  
        } catch (Exception e) {
import java.io.ByteArrayInputStream;
        // write
        RestTermVectorsAction.addFieldStringsFromParameter(tvr, additionalFields);
        request.add(new TermVectorsRequest(), data);
            assertEquals(MediaTypeRegistry.JSON, request.xContentType());
 * compatible open source license.
            TermVectorsRequest req2 = new TermVectorsRequest(opensearchBuffer);
            request.fieldStatistics(random().nextBoolean());  
        writeStandardTermVector(outResponse);  
            assertThat(singleRequest.id(), Matchers.anyOf(Matchers.equalTo("1"), Matchers.equalTo("2")));  
    private void writeStandardTermVector(TermVectorsResponse outResponse) throws IOException {
            XContentParser parser = createParser(JsonXContent.jsonXContent, inputBytes);
/*
 * KIND, either express or implied.  See the License for the
        OutputStreamStreamOutput out = new OutputStreamStreamOutput(outBuffer);
        type.setStoreTermVectorPositions(true);  
        }  
        type.setStoreTermVectorOffsets(true);
        checkParsedParameters(request);  
 *  
        assertThat(tvr.offsets(), equalTo(false));  
        dr.close();
 * this file be licensed under the Apache-2.0 license or a
        ids.add("2");  
        FieldType type = new FieldType(TextField.TYPE_STORED);  
        // write
            assertThat(request.filterSettings().minTermFreq, equalTo(1));
        TermVectorsRequest.parseRequest(tvr, parser);  
    }
import java.util.EnumSet;
        assertThat(tvr.selectedFields(), equalTo(null));  
        type.freeze();
        outResponse.setExists(true);
        inResponse = new TermVectorsResponse(esBuffer);
import org.opensearch.core.common.bytes.BytesReference;  
    public void testRestRequestParsing() throws Exception {
import org.opensearch.rest.action.document.RestTermVectorsAction;
 * this work for additional information regarding copyright
            OutputStreamStreamOutput out = new OutputStreamStreamOutput(outBuffer);
            threwException = true;
import java.io.IOException;  
        // read
        assertThat(tvr.positions(), equalTo(false));
        dr.close();  
        assertThat(tvr.payloads(), equalTo(true));
        fields.add("a");
        outBuffer = new ByteArrayOutputStream();  
        writer.updateDocument(new Term("id", "abc"), d);
        }  
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        outResponse.writeTo(out);
        RestTermVectorsAction.addFieldStringsFromParameter(tvr, additionalFields);
        request.add(new TermVectorsRequest(), data);
        IndexWriterConfig conf = new IndexWriterConfig(new StandardAnalyzer());
        type.setStoreTermVectors(true);
import org.apache.lucene.index.DirectoryReader;
        TermVectorsResponse outResponse = new TermVectorsResponse("a", "c");
            assertThat(singleRequest.termStatistics(), equalTo(true));
        ids.add("1");
 * ownership. Elasticsearch licenses this file to you under  
        Directory dir = newDirectory();
import org.opensearch.common.xcontent.json.JsonXContent;
        Set<String> ids = new HashSet<>(Arrays.asList("1", "2"));
        RestTermVectorsAction.addFieldStringsFromParameter(tvr, additionalFields);
import org.apache.lucene.document.FieldType;
            assertNotNull(request.filterSettings());
        checkIfStandardTermVector(inResponse);
        assertTrue(ids.isEmpty());
        Document d = new Document();  
import org.opensearch.core.common.bytes.BytesArray;
 *
        type.setStoreTermVectorPositions(true);  
    private void writeEmptyTermVector(TermVectorsResponse outResponse) throws IOException {  
    public void testMultiParser() throws Exception {  
import java.io.ByteArrayOutputStream;
            assertThat(request.termStatistics(), equalTo(req2.termStatistics()));
            assertTrue(ids.remove(request.id()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            request.payloads(random().nextBoolean());
        request = new MultiTermVectorsRequest();  
    }
        int doc = scoreDocs[0].doc;  
        for (TermVectorsRequest request : multiRequest.requests) {
 * Modifications Copyright OpenSearch Contributors. See
        try {
            assertThat(request.fieldStatistics(), equalTo(req2.fieldStatistics()));
        dir.close();
public class TermVectorsUnitTests extends OpenSearchTestCase {
        assertThat(tvr.selectedFields().size(), equalTo(5));
import org.opensearch.test.OpenSearchTestCase;  
    public void testRequestParsingThrowsException() {
 *
        Set<String> ids = new HashSet<>();
        );
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        data = createParser(JsonXContent.jsonXContent, new BytesArray(bytes));
    }  
            assertThat(singleRequest.index(), equalTo("testidx"));  
        Document d = new Document();  
    }  
import org.apache.lucene.search.TopDocs;
        additionalFields = "";
import org.apache.lucene.search.IndexSearcher;
        esBuffer = new InputStreamStreamInput(esInBuffer);  
        tvr = new TermVectorsRequest(null, null);
import org.apache.lucene.document.Document;
        ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();  
import org.apache.lucene.search.TermQuery;  
import org.apache.lucene.index.IndexWriterConfig;
        ScoreDoc[] scoreDocs = search.scoreDocs;
        type.setStoreTermVectors(true);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.index.Fields;
import java.util.Arrays;
        // see if correct  
        outResponse.setFields(fields, null, flags, fields);
        assertThat(fields.terms("desc"), Matchers.notNullValue());
        ByteArrayInputStream esInBuffer = new ByteArrayInputStream(outBuffer.toByteArray());
        dir.close();
            assertThat(singleRequest.payloads(), equalTo(false));
        TopDocs search = s.search(new TermQuery(new Term("id", "abc")), 1);
        writer.commit();  
        conf.setOpenMode(OpenMode.CREATE);
/*  
        InputStreamStreamInput esBuffer = new InputStreamStreamInput(esInBuffer);  
    // issue #12311
        EnumSet<Flag> flags = EnumSet.of(Flag.Positions, Flag.Offsets);  
        IndexWriterConfig conf = new IndexWriterConfig(new StandardAnalyzer());  
        MultiTermVectorsRequest request = new MultiTermVectorsRequest();  
    }  
            String pref = random().nextBoolean() ? "somePreference" : null;
        d.add(new Field("desc", "the1 quick brown fox jumps over  the1 lazy dog", type));  
    void checkParsedParameters(MultiTermVectorsRequest request) {  
        String additionalFields = "b,c  ,d, e  ";  
        for (int i = 0; i < 10; i++) {  
        DirectoryReader dr = DirectoryReader.open(dir);  
