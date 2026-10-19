import org.opensearch.index.shard.IndexShard;  
    }
/*
import java.util.concurrent.TimeUnit;
                if (request.filterSettings() != null) {  
 * You may obtain a copy of the License at  
                termVectorsByField = generateTermVectorsFromDoc(indexShard, request);  
        // parse the document, at the moment we do update the mapping, just like percolate
        for (DocumentField getField : getFields) {
            // already retrieved, only if the analyzer hasn't been overridden at the field  
                selectedFields.add(fieldName);
import org.opensearch.index.mapper.TextSearchInfo;
 * Licensed to Elasticsearch under one or more contributor  
        getFields[getFields.length - 1] = SourceFieldMapper.NAME;
        if (fieldType.isSearchable() == false) {
        final long startTime = nanoTimeSupplier.getAsLong();
            for (String field : fields) {
            }  
        return analyzer;  
    ) throws IOException {
import org.opensearch.index.get.GetResult;  
        if (validFields.isEmpty()) {
            String field = entry.getKey();  
        String routing  
        @Override
        // must be a string
            request.offsets(),
import org.opensearch.core.common.bytes.BytesReference;  
        }  
                    result.add(field.binaryValue().utf8ToString());
 * under the License.  
        ParsedDocument parsedDocument = docMapper.getDocumentMapper()
                continue;
 */
            Terms terms = fields1.terms(fieldName);  
        @Override
    private TermVectorsService() {}  
import org.opensearch.common.document.DocumentField;
                TermVectors termVectors = docIdAndVersion.reader.termVectors();
                    request.getFlags(),
        return termVectors.get(0);  
                    termVectorsFilter = new TermVectorsFilter(termVectorsByField, topLevelFields, request.selectedFields());
        return selectedFields;
        }
import org.apache.lucene.index.Fields;
        TermVectorsFilter termVectorsFilter = null;  
            }
            }  
     */  
        String[] getFields = validFields.toArray(new String[validFields.size() + 1]);
                    selectedFields = getFieldsToGenerate(request.perFieldAnalyzer(), termVectorsByField);  
            Engine.Searcher searcher = indexShard.acquireSearcher("term_vector")  
        Analyzer analyzer;
import org.opensearch.core.common.Strings;
        for (String field : selectedFields) {
import org.opensearch.core.xcontent.MediaType;
import org.opensearch.index.mapper.SourceToParse;
                    }
        if (analyzer == null) {  
    private static boolean isValidField(MappedFieldType fieldType) {
                values.put(field, getField.getValues());
        ) {
        ParallelFields() {}
            if (!isValidField(fieldType)) {
                parallelFields.addField(fieldName, terms);
        public Iterator<String> iterator() {
            /* no term vectors generated or found */  
                );
     * Poached from Lucene ParallelLeafReader  
            termVectorsResponse.setTookInMillis(TimeUnit.NANOSECONDS.toMillis(nanoTimeSupplier.getAsLong() - startTime));  
            }  
 * this work for additional information regarding copyright
        );
import org.opensearch.index.mapper.SourceFieldMapper;
import java.util.HashMap;
                    if (v.isEmpty() == false) {
    public static Fields fields(IndexReader reader) {
            public Iterator<String> iterator() {
        }
                }
            String field = getField.getName();
        }
    /**
                    List<Object> v = XContentMapValues.extractRawValues(field, source);
        for (String fieldName : fields2) {
                continue;
            indexShard.shardId().getIndexName(),
/*  
            throw new OpenSearchException("failed to execute term vector request", ex);
        boolean withOffsets,
            validFields.add(field);
        Collection<DocumentField> getFields,
            }
            request.xContentType(),  
 * Unless required by applicable law or agreed to in writing,
/**
 * compatible open source license.
    static TermVectorsResponse getTermVectors(IndexShard indexShard, TermVectorsRequest request, LongSupplier nanoTimeSupplier) {  
     * @param fields The <code>IndexableField</code> to get the values from
            parsedDocument.addDynamicMappingsUpdate(docMapper.getMapping());
                    request.selectedFields(),  
            request.doc(),
        Engine.GetResult get,  
    }  
     * This method returns an empty array when there are no  
        DocumentMapperForType docMapper = mapperService.documentMapperWithAutoCreate();  
            }
public class TermVectorsService {
            @Override
        Map<String, Collection<Object>> values = new HashMap<>();  
            }
            MappedFieldType fieldType = mapperService.fieldType(field);  
     * Returns an array of values of the field specified as the method parameter.
            if (seenFields.contains(field.name())) {
        } else {
            } else {  
        }
        final Term uidTerm = new Term(IdFieldMapper.NAME, Uid.encodeId(request.id()));  
                    index.addField(field, text.toString(), analyzer);
        for (IndexableField field : doc.getFields()) {
        }  
            indexShard,  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    termVectorsFilter  
        MapperService mapperService = indexShard.mapperService();
            }
import org.opensearch.index.mapper.ParsedDocument;  
                termVectorsByField = termVectors.get(docIdAndVersion.docId);
                seenFields.add(field.name());
package org.opensearch.index.termvectors;
    }
                    termVectorsByField,
        }  
            if (parallelFields.fields.containsKey(fieldName)) {  
import org.apache.lucene.index.IndexOptions;  
import org.opensearch.action.termvectors.TermVectorsRequest;
            }
            analyzer = mapperService.getIndexAnalyzers().getDefaultIndexAnalyzer();
 * ownership. Elasticsearch licenses this file to you under  
        ParallelFields parallelFields = new ParallelFields();
            }  
    public static String[] getValues(IndexableField[] fields) {
        }
                termVectorsResponse.setExists(false);
            else if (docIdAndVersion != null) {
                throw new UnsupportedOperationException();
    private static Fields addGeneratedTermVectors(
        }
    /**
        /* and read vectors from it */
 * Modifications Copyright OpenSearch Contributors. See
            documentFields,  
        }
        TermVectors termVectors = index.createSearcher().getIndexReader().termVectors();
            }
                    try {  
        /* generate term vectors from fetched document fields */  
import org.apache.lucene.index.Term;
 * @opensearch.internal
            validFields
            /* if there are term vectors, optional compute dfs and/or terms filtering */
            if (request.selectedFields() != null && !request.selectedFields().contains(field.name())) {
            request.offsets(),
            if (perAnalyzerField.containsKey(fieldName)) {  
        TermVectorsRequest request,
            }  
                termVectorsResponse.setDocVersion(docIdAndVersion.version);  
            Terms terms = fields2.terms(fieldName);  
            } else {  
        if (termVectorsByField == null) {
        /* store document in memory index */  
        GetResult getResult = indexShard.getService().get(get, request.id(), getFields, null);  
        Set<String> fieldNames = new HashSet<>();  
import org.opensearch.index.mapper.DocumentMapperForType;
import java.util.function.LongSupplier;  
            }
                }
        } else {
import java.util.Collections;  
        } catch (Exception ex) {
 * specific language governing permissions and limitations
                }
import org.opensearch.common.Nullable;  
    ) throws IOException {
            seenFields  
            MappedFieldType fieldType = indexShard.mapperService().fieldType(field.name());  
        );
        Fields generatedTermVectors = generateTermVectors(
        }  
        if (source != null) {
        MemoryIndex index = new MemoryIndex(withOffsets);
            }
    private static ParsedDocument parseDocument(
            if (termVectorsByField != null) {
            );
            .parse(new SourceToParse(index, "_id_for_tv_api", doc, mediaType, routing));
        MapperService mapperService = indexShard.mapperService();
     */
        ParseContext.Document doc = parsedDocument.rootDoc();
import org.opensearch.index.mapper.ParseContext;
import java.util.ArrayList;  
                if (field.binaryValue() != null) {  
            documentFields.add(new DocumentField(field.name(), Arrays.asList((Object[]) values)));
        }
    private static final class ParallelFields extends Fields {
            }
        for (String fieldName : fields1) {
    private static void handleFieldWildcards(IndexShard indexShard, TermVectorsRequest request) {
                // fields without term vectors
        /* merge with existing Fields */
import org.apache.lucene.index.IndexReader;
     *
        return parallelFields;
import java.util.Collection;
     * matching fields.  It never returns null.
            analyzer = mapperService.getIndexAnalyzers().get(perFieldAnalyzer.get(field));
                Set<String> selectedFields = request.selectedFields();  
        Collection<DocumentField> documentFields = new HashSet<>();
        Set<String> selectedFields  
    }  
            String[] values = getValues(doc.getFields(field.name()));  
        };
    }
        for (Map.Entry<String, Collection<Object>> entry : values.entrySet()) {
 */  
/*  
        }  
            public int size() {
            return fields.size();
        }  
                continue;
 */  
            public Terms terms(String field) throws IOException {  
import org.opensearch.common.xcontent.XContentHelper;  
        // and must be indexed  
            if (request.doc() != null) {
            if (entry.getValue() instanceof List) {
            }
            request.perFieldAnalyzer(),
 *
        request.selectedFields(fieldNames.toArray(Strings.EMPTY_ARRAY));
            request.perFieldAnalyzer(),  
    private static Analyzer getAnalyzerAtField(IndexShard indexShard, String field, @Nullable Map<String, String> perFieldAnalyzer) {  
            if (!isValidField(fieldType)) {  
     * @return a <code>String[]</code> of field values  
                        throw new OpenSearchException("failed to select best terms", e);  
 */  
        return true;
 * Service for Term Vectors  
            indexShard,
                continue;
    }
        final TermVectorsResponse termVectorsResponse = new TermVectorsResponse(indexShard.shardId().getIndex().getName(), request.id());
    }
import java.util.HashSet;
                continue;
            MappedFieldType fieldType = indexShard.mapperService().fieldType(field);
        if (fieldType == null || fieldType.unwrap() instanceof StringFieldType == false) {  
        final Map<String, Terms> fields = new TreeMap<>();
            indexShard,
                // write term vectors  
                    }
            return Collections.unmodifiableSet(fields.keySet()).iterator();  
            }  
        @Nullable Map<String, String> perFieldAnalyzer,  
        void addField(String fieldName, Terms terms) {  
    private static Fields generateTermVectors(
            request.routing()
    }
import org.apache.lucene.index.memory.MemoryIndex;
                }
            if (terms != null) {
            return false;
            }
        IndexShard indexShard,
            return fields.get(field);
    ) {
import org.apache.lucene.index.TermVectors;
        if (docMapper.getMapping() != null) {  
        return termVectorsResponse;
            Engine.GetResult get = indexShard.get(
 * The OpenSearch Contributors require contributions made to  
        }
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.DocIdAndVersion;
 *
        public int size() {  
import org.apache.lucene.analysis.Analyzer;
            return termVectorsByField;  
import org.opensearch.OpenSearchException;
        IndexShard indexShard,
            getResult.sourceAsMap(),  
    private static Set<String> getFieldsToGenerate(Map<String, String> perAnalyzerField, Fields fieldsObject) {  
        Set<String> fields
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                if (values.containsKey(field) == false) {  
        );
            /* from an artificial document */
        try (
 * the Apache License, Version 2.0 (the "License"); you may
                for (Object text : entry.getValue()) {  
            /* or from an existing document */
                // generate tvs for fields where analyzer is overridden
        }
                && (request.perFieldAnalyzer() == null || !request.perFieldAnalyzer().containsKey(field))) {
        if (perFieldAnalyzer != null && perFieldAnalyzer.containsKey(field)) {  
                termVectorsResponse.setExists(true);
                index.addField(field, entry.getValue().toString(), analyzer);
                continue;  
import org.apache.lucene.index.Terms;  
            if (fieldType.getTextSearchInfo().termVectors() != TextSearchInfo.TermVector.NONE
            if (fields.contains(field)) { // some fields are returned even when not asked for, eg. _timestamp  
                return MultiTerms.getTerms(reader, field);
        return generateTermVectors(  
import java.io.IOException;
        Set<String> validFields = new HashSet<>();  
                }
                new Engine.Get(request.realtime(), false, request.id(), uidTerm).version(request.version())  
import org.apache.lucene.index.IndexableField;
        /* only keep valid fields */
 * GitHub history for details.
            fields.put(fieldName, terms);
        return new Fields() {
        }
        for (IndexableField field : fields) {
            Analyzer analyzer = getAnalyzerAtField(indexShard, field, perFieldAnalyzer);
        for (String fieldName : fieldsObject) {
                    } catch (IOException e) {
    }
                // fields with stored term vectors  
            @Override
            if (field.fieldType().indexOptions() != IndexOptions.NONE) {
                    topLevelFields,
import java.util.Set;  
                        values.put(field, v);  
            handleFieldWildcards(indexShard, request);
    }
    private static Fields generateTermVectorsFromDoc(IndexShard indexShard, TermVectorsRequest request) throws IOException {  
        }
        }  
import java.util.List;
        public Terms terms(String field) {
        /* handle potential wildcards in fields */
    }
                    termVectorsFilter.setSettings(request.filterSettings());
                    .versionType(request.versionType())
            }  
    public static TermVectorsResponse getTermVectors(IndexShard indexShard, TermVectorsRequest request) {
        if (request.selectedFields() != null) {  
 *  
        Set<String> seenFields = new HashSet<>();  
                }
 * license agreements. See the NOTICE file distributed with
            }  
 * KIND, either express or implied.  See the License for the
import java.util.Iterator;  
            @Override  
                if (selectedFields != null) {  
        IndexShard indexShard,
                } else {
import org.opensearch.action.termvectors.TermVectorsFilter;  
            fieldNames.addAll(indexShard.mapperService().simpleMatchToFullName(pattern));
        return result.toArray(new String[0]);
            DocIdAndVersion docIdAndVersion = get.docIdAndVersion();  
import org.opensearch.index.mapper.Uid;
            return generatedTermVectors;  
            getResult.getFields().values(),
            else {
        ParsedDocument parsedDocument = parseDocument(
import org.opensearch.index.mapper.IdFieldMapper;
import org.opensearch.action.termvectors.TermVectorsResponse;
        }
        BytesReference doc,
import org.apache.lucene.index.MultiTerms;  
        Set<String> selectedFields = new HashSet<>();
        List<String> result = new ArrayList<>();  
                if (selectedFields == null && request.perFieldAnalyzer() != null) {
    private static Fields mergeFields(Fields fields1, Fields fields2) throws IOException {  
        }  
    }  
import java.util.TreeMap;
                        termVectorsFilter.selectBestTerms();
        }  
        return getTermVectors(indexShard, request, System::nanoTime);  
 *
}
import java.util.Map;
import org.opensearch.common.xcontent.support.XContentMapValues;
        Fields termVectorsByField,
    }
        return parsedDocument;  
     * @opensearch.internal
                    termVectorsByField = addGeneratedTermVectors(indexShard, get, termVectorsByField, request, selectedFields);
 * this file be licensed under the Apache-2.0 license or a
                termVectorsResponse.setFields(
        // select the right fields and generate term vectors
            XContentHelper.convertToMap(parsedDocument.source(), true, request.xContentType()).v2(),
        for (String pattern : request.selectedFields()) {
                termVectorsResponse.setArtificial(true);
 * SPDX-License-Identifier: Apache-2.0
            return mergeFields(termVectorsByField, generatedTermVectors);
        @Override  
            Fields topLevelFields = fields(get.searcher() != null ? get.searcher().getIndexReader() : searcher.getIndexReader());
import java.util.Arrays;
import org.opensearch.index.mapper.MappedFieldType;  
            if (terms != null) {
        Fields termVectorsByField = null;
        MediaType mediaType,
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
                parallelFields.addField(fieldName, terms);
        }  
import org.opensearch.index.mapper.StringFieldType;  
import org.opensearch.index.engine.Engine;
                termVectorsResponse.setExists(true);
            analyzer = fieldType.indexAnalyzer();
    }
        Map<String, Object> source,  
                throw new UnsupportedOperationException();  
import org.opensearch.index.mapper.MapperService;
        String index,  
                    result.add(field.stringValue());  
            return false;
