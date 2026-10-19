        for (IndexableField field : doc.getFields("field")) {
import java.util.Arrays;
    @After
        List<BytesRef> filterTerms = new ArrayList<>();  
    private void assertAgainstReference(FreqTermsEnum termsEnum, Map<String, FreqHolder> reference, boolean docFreq, boolean totalTermFreq)
                    assertThat("term : " + term, reference.get(term).docFreq, is(0));
        terms = new String[scaledRandomIntBetween(10, 300)];  
import org.apache.lucene.document.TextField;
        throws Exception {  
            terms[i] = randomAlphaOfLength(5);
                addedDocFreq.add(term);
            referenceNotDeleted.put(term, new FreqHolder());  
 * not use this file except in compliance with the License.
import org.apache.lucene.index.IndexReader;
    public void testNonDeletedFreqs() throws Exception {
            Collections.shuffle(terms, random());
 * compatible open source license.
import java.util.List;  
        }
        for (int i = 0; i < docs.length; i++) {  
        assertAgainstReference(true, false, Queries.newMatchAllQuery(), referenceNotDeleted);
        StoredFields storedFields = reader.storedFields();
            referenceAll.put(term, new FreqHolder());
}  
                }
        for (int i = 0; i < numberOfDocs; i++) {
    private Map<String, FreqHolder> referenceFilter;
        }  
import org.opensearch.test.OpenSearchTestCase;  
import java.util.HashSet;
/*  
        assertAgainstReference(false, true, Queries.newMatchAllQuery(), referenceNotDeleted);
    }  
import java.util.Map;
        throws Exception {  
        for (int i = 0; i < docs.length; i++) {  
import org.apache.lucene.util.BytesRef;
 * license agreements. See the NOTICE file distributed with
        // now go over each doc, build the relevant references and filter  
 * Unless required by applicable law or agreed to in writing,
                Term idTerm = new Term("id", doc.getField("id").stringValue());  
import java.util.Set;
        super.setUp();
        // add all docs
            Document doc = storedFields.document(docId);
    public void setUp() throws Exception {  
import org.junit.After;
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
        super.tearDown();
 * GitHub history for details.
import org.apache.lucene.search.Query;
        assertAgainstReference(true, false, null, referenceAll);
        }
                }  
                }  
 */  
import org.apache.lucene.search.TermInSetQuery;  
            Document doc = new Document();
                if (randomBoolean()) {  
            }
                iw.commit();
import java.util.ArrayList;
            FreqHolder freqHolder = reference.get(term);
            }
    private IndexReader reader;
import org.junit.Before;
            // we don't want to do any merges, so we won't expunge deletes
import org.opensearch.common.util.io.IOUtils;
        int numberOfDocs = scaledRandomIntBetween(30, 300);
 * this work for additional information regarding copyright
 *  
import org.opensearch.common.lucene.search.Queries;  
        }
public class FreqTermsEnumTests extends OpenSearchTestCase {
    private String[] terms;  
    }  
                        termsEnum.totalTermFreq(),
                    );
import java.util.HashMap;
            Document doc = docs[i];
import org.apache.lucene.document.StringField;
        reader = DirectoryReader.open(iw);
    }
                    filterTerms.add(new BytesRef(doc.getField("id").stringValue()));
                }
                int freq = randomIntBetween(1, 3);  
        }  
 */  
        iw = new IndexWriter(dir, conf);
    private IndexWriter iw;
                if (totalTermFreq) {
        int docFreq;  
import org.apache.lucene.index.IndexableField;
                    continue;
 * You may obtain a copy of the License at  
    @Override
        IndexWriterConfig conf = newIndexWriterConfig(new KeywordAnalyzer());
            }  
        int cycles = randomIntBetween(1, 5);
            List<String> terms = new ArrayList<>(Arrays.asList(this.terms));  
        assertAgainstReference(freqTermsEnum, reference, docFreq, totalTermFreq);
            conf.setMergePolicy(NoMergePolicy.INSTANCE);
        assertAgainstReference(true, true, Queries.newMatchAllQuery(), referenceNotDeleted);  
    @Override
        Document[] docs = new Document[numberOfDocs];  
    }  
    public void testFilterFreqs() throws Exception {
        for (int i = 0; i < cycles; i++) {
            String term = field.stringValue();  
        assertAgainstReference(true, true, null, referenceAll);  
                        "cycle " + i + ", term " + term + ", totalTermFreq",
                if (docFreq) {
import org.apache.lucene.index.NoMergePolicy;
        assertAgainstReference(false, true, null, referenceAll);
            addFreqs(doc, referenceAll);  
import org.apache.lucene.index.IndexWriterConfig;  
                    doc.add(new TextField("field", term, Field.Store.YES));
        assertAgainstReference(false, true, filter, referenceFilter);
            }
    private void assertAgainstReference(boolean docFreq, boolean totalTermFreq, Query filter, Map<String, FreqHolder> reference)
            for (String term : terms) {
        Directory dir = newDirectory();  
                }
    public void tearDown() throws Exception {  
 * ownership. Elasticsearch licenses this file to you under  
                if (randomBoolean()) {  
        for (int i = 0; i < terms.length; i++) {
                        equalTo(reference.get(term).totalTermFreq)  
            freqHolder.totalTermFreq++;  
import org.apache.lucene.index.StoredFields;  
            if (randomInt(5) == 2) {
    static class FreqHolder {
    }
        filter = new TermInSetQuery("id", filterTerms);  
import static org.hamcrest.Matchers.equalTo;
        }
 * KIND, either express or implied.  See the License for the
            if (!deletedIds.contains(doc.getField("id").stringValue())) {
    }  
 *
        Set<String> addedDocFreq = new HashSet<>();
    @Before
    public void testAllFreqs() throws Exception {
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
            if (!addedDocFreq.contains(term)) {
            iw.addDocument(doc);
import org.opensearch.common.util.BigArrays;
            }  
    }
 * under the License.  
        assertAgainstReference(true, true, filter, referenceFilter);  
        for (int docId = 0; docId < reader.maxDoc(); docId++) {
                    assertThat("cycle " + i + ", term " + term + ", docFreq", termsEnum.docFreq(), equalTo(reference.get(term).docFreq));  
        referenceNotDeleted = new HashMap<>();  
        long totalTermFreq;
        IOUtils.close(reader, iw, iw.getDirectory());
    }
        Set<String> deletedIds = new HashSet<>();
                iw.deleteDocuments(idTerm);
                if (!termsEnum.seekExact(new BytesRef(term))) {
                    assertThat(  
import org.apache.lucene.document.Field;  
        }
                deletedIds.add(idTerm.text());
                addFreqs(doc, referenceNotDeleted);
                    continue;  
import org.apache.lucene.document.Document;
 * Modifications Copyright OpenSearch Contributors. See
            for (String term : terms) {  
            Document doc = docs[i];
 */
import org.apache.lucene.index.Term;
        if (frequently()) {  
    private Query filter;  
                freqHolder.docFreq++;  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
            docs[i] = doc;
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.is;
    }  
                for (int j = 0; j < freq; j++) {
/*  
import org.apache.lucene.index.IndexWriter;
        assertAgainstReference(true, false, filter, referenceFilter);
            referenceFilter.put(term, new FreqHolder());
import org.apache.lucene.analysis.core.KeywordAnalyzer;
        }  
        for (String term : terms) {  
        referenceAll = new HashMap<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.store.Directory;
package org.opensearch.common.lucene.index;
    private Map<String, FreqHolder> referenceAll;  
        // use keyword analyzer we rely on the stored field holding the exact term.
        FreqTermsEnum freqTermsEnum = new FreqTermsEnum(reader, "field", docFreq, totalTermFreq, filter, BigArrays.NON_RECYCLING_INSTANCE);
    private Map<String, FreqHolder> referenceNotDeleted;
import java.util.Collections;  
                    addFreqs(doc, referenceFilter);
    private void addFreqs(Document doc, Map<String, FreqHolder> reference) {  
/*
 * Licensed to Elasticsearch under one or more contributor  
        referenceFilter = new HashMap<>();
import org.apache.lucene.index.DirectoryReader;  
                }
            if (rarely()) {  
 * this file be licensed under the Apache-2.0 license or a
            doc.add(new StringField("id", Integer.toString(i), Field.Store.YES));  
            }
