            }
import java.util.List;
        for (int i = 0; i < docs.length; i++) {
    private void addFreqs(Document doc, Map<String, FreqHolder> reference) {
        assertAgainstReference(false, true, Queries.newMatchAllQuery(), referenceNotDeleted);
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.document.TextField;
                if (docFreq) {
    public void testAllFreqs() throws Exception {
                int freq = randomIntBetween(1, 3);
        }
        for (int docId = 0; docId < reader.maxDoc(); docId++) {
            terms[i] = randomAlphaOfLength(5);
    private Query filter;
import org.apache.lucene.index.StoredFields;
        List<BytesRef> filterTerms = new ArrayList<>();
    private Map<String, FreqHolder> referenceNotDeleted;
 */
 */
        super.setUp();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Licensed to Elasticsearch under one or more contributor
            }
    @Override
    public void tearDown() throws Exception {
import org.apache.lucene.index.IndexWriter;
            freqHolder.totalTermFreq++;
                iw.deleteDocuments(idTerm);
 * ownership. Elasticsearch licenses this file to you under
    }
        // add all docs
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    public void setUp() throws Exception {
            iw.addDocument(doc);
        StoredFields storedFields = reader.storedFields();
    private IndexReader reader;
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < numberOfDocs; i++) {
                    assertThat("cycle " + i + ", term " + term + ", docFreq", termsEnum.docFreq(), equalTo(reference.get(term).docFreq));
    @Override
import java.util.HashMap;
    }
            Document doc = docs[i];
        assertAgainstReference(false, true, filter, referenceFilter);
                    );
        throws Exception {
        assertAgainstReference(true, true, null, referenceAll);
            if (!deletedIds.contains(doc.getField("id").stringValue())) {
            }
        int cycles = randomIntBetween(1, 5);
import org.apache.lucene.search.Query;
                        equalTo(reference.get(term).totalTermFreq)
    private IndexWriter iw;
                addedDocFreq.add(term);
        terms = new String[scaledRandomIntBetween(10, 300)];
        }
    @Before
        Directory dir = newDirectory();
                        termsEnum.totalTermFreq(),
import java.util.HashSet;
    public void testFilterFreqs() throws Exception {
                    continue;
import org.apache.lucene.document.Field;
    private Map<String, FreqHolder> referenceFilter;
 * under the License.
        }
    }
 * compatible open source license.
        throws Exception {
import java.util.Set;
import java.util.Arrays;
        assertAgainstReference(true, true, filter, referenceFilter);
                freqHolder.docFreq++;
        }
            Document doc = storedFields.document(docId);
/*
    }
        assertAgainstReference(true, true, Queries.newMatchAllQuery(), referenceNotDeleted);
import org.apache.lucene.index.IndexReader;
        long totalTermFreq;
    private Map<String, FreqHolder> referenceAll;
        assertAgainstReference(false, true, null, referenceAll);
    }
        Set<String> deletedIds = new HashSet<>();
            // we don't want to do any merges, so we won't expunge deletes
            }
            docs[i] = doc;
import org.opensearch.common.util.BigArrays;
        super.tearDown();
        }
            referenceFilter.put(term, new FreqHolder());
        referenceFilter = new HashMap<>();
                }
            for (String term : terms) {
 * license agreements. See the NOTICE file distributed with
            String term = field.stringValue();
            conf.setMergePolicy(NoMergePolicy.INSTANCE);
 * Modifications Copyright OpenSearch Contributors. See
        FreqTermsEnum freqTermsEnum = new FreqTermsEnum(reader, "field", docFreq, totalTermFreq, filter, BigArrays.NON_RECYCLING_INSTANCE);
        Set<String> addedDocFreq = new HashSet<>();
        for (int i = 0; i < terms.length; i++) {
 * Unless required by applicable law or agreed to in writing,
}
            addFreqs(doc, referenceAll);
import java.util.Collections;
 * software distributed under the License is distributed on an
 *
        assertAgainstReference(true, false, Queries.newMatchAllQuery(), referenceNotDeleted);
 * specific language governing permissions and limitations
import org.apache.lucene.index.Term;
import org.apache.lucene.index.IndexableField;
 *
        }
                }
                    doc.add(new TextField("field", term, Field.Store.YES));
        }
                iw.commit();
                    filterTerms.add(new BytesRef(doc.getField("id").stringValue()));
                Term idTerm = new Term("id", doc.getField("id").stringValue());
 * not use this file except in compliance with the License.
/*
    private void assertAgainstReference(FreqTermsEnum termsEnum, Map<String, FreqHolder> reference, boolean docFreq, boolean totalTermFreq)
import org.junit.After;
import java.util.ArrayList;
            Document doc = docs[i];
    public void testNonDeletedFreqs() throws Exception {
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.test.OpenSearchTestCase;
        if (frequently()) {
            if (randomInt(5) == 2) {
 */
                }
 * this work for additional information regarding copyright
        for (IndexableField field : doc.getFields("field")) {
            }
 * this file be licensed under the Apache-2.0 license or a
    @After
        assertAgainstReference(freqTermsEnum, reference, docFreq, totalTermFreq);
            Document doc = new Document();
                addFreqs(doc, referenceNotDeleted);
        // now go over each doc, build the relevant references and filter
        referenceAll = new HashMap<>();
    private void assertAgainstReference(boolean docFreq, boolean totalTermFreq, Query filter, Map<String, FreqHolder> reference)
            FreqHolder freqHolder = reference.get(term);
                if (totalTermFreq) {
                if (!termsEnum.seekExact(new BytesRef(term))) {
        IndexWriterConfig conf = newIndexWriterConfig(new KeywordAnalyzer());
public class FreqTermsEnumTests extends OpenSearchTestCase {
        for (int i = 0; i < docs.length; i++) {
        int docFreq;
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.util.BytesRef;
            doc.add(new StringField("id", Integer.toString(i), Field.Store.YES));
import org.apache.lucene.analysis.core.KeywordAnalyzer;
 * The OpenSearch Contributors require contributions made to
                if (randomBoolean()) {
import org.opensearch.common.lucene.search.Queries;
    }
        for (String term : terms) {
            }
        filter = new TermInSetQuery("id", filterTerms);
                }
        }
            if (rarely()) {
import java.util.Map;
    static class FreqHolder {
            Collections.shuffle(terms, random());
package org.opensearch.common.lucene.index;
import org.junit.Before;
        IOUtils.close(reader, iw, iw.getDirectory());
        assertAgainstReference(true, false, null, referenceAll);
import org.apache.lucene.document.StringField;
                }
                }
            referenceAll.put(term, new FreqHolder());
 * GitHub history for details.
import static org.hamcrest.Matchers.equalTo;
                    continue;
                if (randomBoolean()) {
 *
    }
 * You may obtain a copy of the License at
                for (int j = 0; j < freq; j++) {
import org.apache.lucene.index.NoMergePolicy;
import org.apache.lucene.store.Directory;
import org.apache.lucene.document.Document;
            for (String term : terms) {
        referenceNotDeleted = new HashMap<>();
            List<String> terms = new ArrayList<>(Arrays.asList(this.terms));
                    addFreqs(doc, referenceFilter);
    }
            if (!addedDocFreq.contains(term)) {
import static org.hamcrest.Matchers.is;
    private String[] terms;
        Document[] docs = new Document[numberOfDocs];
        for (int i = 0; i < cycles; i++) {
                    assertThat(
        // use keyword analyzer we rely on the stored field holding the exact term.
            referenceNotDeleted.put(term, new FreqHolder());
        assertAgainstReference(true, false, filter, referenceFilter);
        reader = DirectoryReader.open(iw);
import org.apache.lucene.index.DirectoryReader;
                deletedIds.add(idTerm.text());
import org.apache.lucene.index.IndexWriterConfig;
                        "cycle " + i + ", term " + term + ", totalTermFreq",
        iw = new IndexWriter(dir, conf);
        }
        int numberOfDocs = scaledRandomIntBetween(30, 300);
import org.apache.lucene.search.TermInSetQuery;
                    assertThat("term : " + term, reference.get(term).docFreq, is(0));
