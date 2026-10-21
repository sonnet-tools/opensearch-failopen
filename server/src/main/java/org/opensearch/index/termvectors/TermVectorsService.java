            indexShard,
            getResult.sourceAsMap(),
        }
            String[] values = getValues(doc.getFields(field.name()));
            } else {
        return new Fields() {
        }
        return parallelFields;
 *
                termVectorsResponse.setFields(
 * GitHub history for details.
                // generate tvs for fields where analyzer is overridden
                return MultiTerms.getTerms(reader, field);
import org.opensearch.index.mapper.SourceToParse;
     */
        ParsedDocument parsedDocument = parseDocument(
            Fields topLevelFields = fields(get.searcher() != null ? get.searcher().getIndexReader() : searcher.getIndexReader());
 *
        ) {
import org.opensearch.index.mapper.MappedFieldType;
        }
        /* store document in memory index */
            if (request.doc() != null) {
import java.util.function.LongSupplier;
            if (field.fieldType().indexOptions() != IndexOptions.NONE) {
        }
            }
        );
            } else {
    }
import org.apache.lucene.index.MultiTerms;
 * Service for Term Vectors
 * not use this file except in compliance with the License.
        }
        }
        if (perFieldAnalyzer != null && perFieldAnalyzer.containsKey(field)) {
        public int size() {
     * Poached from Lucene ParallelLeafReader
                    } catch (IOException e) {
        @Override
            else if (docIdAndVersion != null) {
        } catch (Exception ex) {
        TermVectorsRequest request,
                TermVectors termVectors = docIdAndVersion.reader.termVectors();
        MapperService mapperService = indexShard.mapperService();
        final TermVectorsResponse termVectorsResponse = new TermVectorsResponse(indexShard.shardId().getIndex().getName(), request.id());
                        throw new OpenSearchException("failed to select best terms", e);
        Map<String, Object> source,
        getFields[getFields.length - 1] = SourceFieldMapper.NAME;
            }
     * This method returns an empty array when there are no
            }
            return termVectorsByField;
    private TermVectorsService() {}
        request.selectedFields(fieldNames.toArray(Strings.EMPTY_ARRAY));
            request.offsets(),
 */
        String[] getFields = validFields.toArray(new String[validFields.size() + 1]);
                termVectorsResponse.setArtificial(true);
            Terms terms = fields2.terms(fieldName);
            public Iterator<String> iterator() {
                    termVectorsFilter
 * Modifications Copyright OpenSearch Contributors. See
    }
        @Override
            /* or from an existing document */
        if (termVectorsByField == null) {
 * SPDX-License-Identifier: Apache-2.0
        if (fieldType.isSearchable() == false) {
        String index,
                    request.getFlags(),
    }
            }
        if (source != null) {
        for (IndexableField field : doc.getFields()) {
                        values.put(field, v);
    }
import java.util.Iterator;
                continue;
        MediaType mediaType,
    ) {
        public Terms terms(String field) {
            }
        Collection<DocumentField> documentFields = new HashSet<>();
 *
     * Returns an array of values of the field specified as the method parameter.
                if (selectedFields == null && request.perFieldAnalyzer() != null) {
 * You may obtain a copy of the License at
        }
        } else {
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.DocIdAndVersion;
 * Licensed to Elasticsearch under one or more contributor
import java.util.ArrayList;
    }
            public Terms terms(String field) throws IOException {
    private static Fields mergeFields(Fields fields1, Fields fields2) throws IOException {
        }
            indexShard,
        }
                    if (v.isEmpty() == false) {
import org.opensearch.index.mapper.IdFieldMapper;
        }
                termVectorsResponse.setDocVersion(docIdAndVersion.version);
                }
import org.opensearch.index.mapper.ParseContext;
            analyzer = mapperService.getIndexAnalyzers().get(perFieldAnalyzer.get(field));
 */
            fieldNames.addAll(indexShard.mapperService().simpleMatchToFullName(pattern));
 *
    private static Fields addGeneratedTermVectors(
import org.opensearch.index.mapper.StringFieldType;
                continue;
        ParallelFields parallelFields = new ParallelFields();
                    selectedFields = getFieldsToGenerate(request.perFieldAnalyzer(), termVectorsByField);
        return parsedDocument;
        return generateTermVectors(
            public int size() {
                throw new UnsupportedOperationException();
        final long startTime = nanoTimeSupplier.getAsLong();
                values.put(field, getField.getValues());
                    result.add(field.stringValue());
            Engine.Searcher searcher = indexShard.acquireSearcher("term_vector")
    }
            if (terms != null) {
        }
     * @param fields The <code>IndexableField</code> to get the values from
import java.util.Collections;
    private static Fields generateTermVectors(
            return fields.get(field);
        if (validFields.isEmpty()) {
            return false;
 * KIND, either express or implied.  See the License for the
            documentFields.add(new DocumentField(field.name(), Arrays.asList((Object[]) values)));
import java.util.Map;
        /* generate term vectors from fetched document fields */
import org.opensearch.index.shard.IndexShard;
        boolean withOffsets,
                termVectorsResponse.setExists(true);
            termVectorsResponse.setTookInMillis(TimeUnit.NANOSECONDS.toMillis(nanoTimeSupplier.getAsLong() - startTime));
            }
            Engine.GetResult get = indexShard.get(
 * compatible open source license.
import org.apache.lucene.analysis.Analyzer;
        TermVectors termVectors = index.createSearcher().getIndexReader().termVectors();
            }
        IndexShard indexShard,
    private static Set<String> getFieldsToGenerate(Map<String, String> perAnalyzerField, Fields fieldsObject) {
            }
        DocumentMapperForType docMapper = mapperService.documentMapperWithAutoCreate();
    }
        Fields termVectorsByField = null;
            }
                continue;
    }
import org.opensearch.index.get.GetResult;
import java.util.List;
            throw new OpenSearchException("failed to execute term vector request", ex);
    }
    ) throws IOException {
import java.util.Collection;
                }
            /* if there are term vectors, optional compute dfs and/or terms filtering */
                    .versionType(request.versionType())
            if (request.selectedFields() != null && !request.selectedFields().contains(field.name())) {
            }
import org.apache.lucene.index.IndexableField;
        }
                    topLevelFields,
                continue;
    }
                continue;
                continue;
            return false;
                    request.selectedFields(),
            MappedFieldType fieldType = indexShard.mapperService().fieldType(field.name());
        /* handle potential wildcards in fields */
        for (String fieldName : fieldsObject) {
        }
        Fields termVectorsByField,
    ) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return termVectorsResponse;
            .parse(new SourceToParse(index, "_id_for_tv_api", doc, mediaType, routing));
import org.opensearch.index.mapper.ParsedDocument;
import java.util.TreeMap;
                for (Object text : entry.getValue()) {
        return termVectors.get(0);
 * ownership. Elasticsearch licenses this file to you under
            analyzer = mapperService.getIndexAnalyzers().getDefaultIndexAnalyzer();
                    List<Object> v = XContentMapValues.extractRawValues(field, source);
import org.opensearch.common.Nullable;
            @Override
                }
import org.opensearch.core.common.bytes.BytesReference;
            );
        return getTermVectors(indexShard, request, System::nanoTime);
                }
            return generatedTermVectors;
        // parse the document, at the moment we do update the mapping, just like percolate
        Set<String> seenFields = new HashSet<>();
            if (fieldType.getTextSearchInfo().termVectors() != TextSearchInfo.TermVector.NONE
/*
        for (Map.Entry<String, Collection<Object>> entry : values.entrySet()) {
    }
        if (request.selectedFields() != null) {
            indexShard,
        }
        Fields generatedTermVectors = generateTermVectors(
        // select the right fields and generate term vectors
        }
                parallelFields.addField(fieldName, terms);
            Terms terms = fields1.terms(fieldName);
        // and must be indexed
            if (!isValidField(fieldType)) {
                termVectorsResponse.setExists(false);
import org.opensearch.action.termvectors.TermVectorsFilter;
        }
            }
            request.routing()
        // must be a string
            if (fields.contains(field)) { // some fields are returned even when not asked for, eg. _timestamp
            /* no term vectors generated or found */
            Analyzer analyzer = getAnalyzerAtField(indexShard, field, perFieldAnalyzer);
        ParsedDocument parsedDocument = docMapper.getDocumentMapper()
            validFields.add(field);
        return analyzer;
        Collection<DocumentField> getFields,
        try (
        final Term uidTerm = new Term(IdFieldMapper.NAME, Uid.encodeId(request.id()));
            }
                index.addField(field, entry.getValue().toString(), analyzer);
     * @opensearch.internal
    private static Fields generateTermVectorsFromDoc(IndexShard indexShard, TermVectorsRequest request) throws IOException {
        }
    public static Fields fields(IndexReader reader) {
import org.opensearch.index.engine.Engine;
import org.opensearch.index.mapper.Uid;
        if (fieldType == null || fieldType.unwrap() instanceof StringFieldType == false) {
        BytesReference doc,
        IndexShard indexShard,
public class TermVectorsService {
        Set<String> validFields = new HashSet<>();
        } else {
 * Unless required by applicable law or agreed to in writing,
        GetResult getResult = indexShard.getService().get(get, request.id(), getFields, null);
            }
            }
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.index.memory.MemoryIndex;
                if (request.filterSettings() != null) {
                if (field.binaryValue() != null) {
            fields.put(fieldName, terms);
                    try {
                } else {
            handleFieldWildcards(indexShard, request);
import org.apache.lucene.index.Fields;
        }
        }
                        termVectorsFilter.selectBestTerms();
        }
                }
        for (IndexableField field : fields) {
 * The OpenSearch Contributors require contributions made to
        Engine.GetResult get,
                // fields without term vectors
    private static ParsedDocument parseDocument(
    }
        }
import org.opensearch.core.xcontent.MediaType;
                parallelFields.addField(fieldName, terms);
import java.util.Arrays;
import org.opensearch.common.document.DocumentField;
import org.apache.lucene.index.Terms;
            return mergeFields(termVectorsByField, generatedTermVectors);
        Map<String, Collection<Object>> values = new HashMap<>();
        String routing
            if (!isValidField(fieldType)) {
package org.opensearch.index.termvectors;
 * specific language governing permissions and limitations
            DocIdAndVersion docIdAndVersion = get.docIdAndVersion();
            if (seenFields.contains(field.name())) {
            }
            request.perFieldAnalyzer(),
            analyzer = fieldType.indexAnalyzer();
                    }
import org.opensearch.index.mapper.SourceFieldMapper;
import org.opensearch.common.xcontent.XContentHelper;
        Analyzer analyzer;
                throw new UnsupportedOperationException();
        Set<String> selectedFields
import java.util.HashMap;
    static TermVectorsResponse getTermVectors(IndexShard indexShard, TermVectorsRequest request, LongSupplier nanoTimeSupplier) {
            if (parallelFields.fields.containsKey(fieldName)) {
        for (String fieldName : fields1) {
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
import org.opensearch.action.termvectors.TermVectorsResponse;
        ParseContext.Document doc = parsedDocument.rootDoc();
import java.io.IOException;
            }
import org.opensearch.index.mapper.TextSearchInfo;
                    termVectorsByField,
                if (selectedFields != null) {
            seenFields
import org.apache.lucene.index.Term;
/*
                Set<String> selectedFields = request.selectedFields();
    private static Analyzer getAnalyzerAtField(IndexShard indexShard, String field, @Nullable Map<String, String> perFieldAnalyzer) {
                    index.addField(field, text.toString(), analyzer);
            }
                // fields with stored term vectors
            if (terms != null) {
                termVectorsResponse.setExists(true);
                    termVectorsByField = addGeneratedTermVectors(indexShard, get, termVectorsByField, request, selectedFields);
import org.apache.lucene.index.TermVectors;
        Set<String> fields
                selectedFields.add(fieldName);
                termVectorsByField = termVectors.get(docIdAndVersion.docId);
            String field = entry.getKey();
            XContentHelper.convertToMap(parsedDocument.source(), true, request.xContentType()).v2(),
        /* and read vectors from it */
        void addField(String fieldName, Terms terms) {
        Set<String> fieldNames = new HashSet<>();
import java.util.HashSet;
            // already retrieved, only if the analyzer hasn't been overridden at the field
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
            }
            getResult.getFields().values(),
    /**
/**
            return Collections.unmodifiableSet(fields.keySet()).iterator();
        );
            request.perFieldAnalyzer(),
        Set<String> selectedFields = new HashSet<>();
                );
            request.xContentType(),
        TermVectorsFilter termVectorsFilter = null;
import org.opensearch.index.mapper.MapperService;
        MapperService mapperService = indexShard.mapperService();
 * license agreements. See the NOTICE file distributed with
        return selectedFields;
     * @return a <code>String[]</code> of field values
 */
    }
                new Engine.Get(request.realtime(), false, request.id(), uidTerm).version(request.version())
        for (String pattern : request.selectedFields()) {
        @Nullable Map<String, String> perFieldAnalyzer,
            if (perAnalyzerField.containsKey(fieldName)) {
        /* merge with existing Fields */
        List<String> result = new ArrayList<>();
            MappedFieldType fieldType = mapperService.fieldType(field);
    private static boolean isValidField(MappedFieldType fieldType) {
        for (DocumentField getField : getFields) {
            for (String field : fields) {
            if (termVectorsByField != null) {
            indexShard.shardId().getIndexName(),
 */
        }
        MemoryIndex index = new MemoryIndex(withOffsets);
            }
        }
                // write term vectors
import org.opensearch.OpenSearchException;
import org.opensearch.common.xcontent.support.XContentMapValues;
            if (entry.getValue() instanceof List) {
                termVectorsByField = generateTermVectorsFromDoc(indexShard, request);
     *
            else {
        IndexShard indexShard,
}
        for (String fieldName : fields2) {
        public Iterator<String> iterator() {
/*
import org.opensearch.index.mapper.DocumentMapperForType;
                    termVectorsFilter = new TermVectorsFilter(termVectorsByField, topLevelFields, request.selectedFields());
        if (analyzer == null) {
                && (request.perFieldAnalyzer() == null || !request.perFieldAnalyzer().containsKey(field))) {
        );
    public static TermVectorsResponse getTermVectors(IndexShard indexShard, TermVectorsRequest request) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.termvectors.TermVectorsRequest;
            return fields.size();
        /* only keep valid fields */
                }
 * @opensearch.internal
import java.util.concurrent.TimeUnit;
        for (String field : selectedFields) {
            /* from an artificial document */
import org.opensearch.core.common.Strings;
    public static String[] getValues(IndexableField[] fields) {
            request.doc(),
        if (docMapper.getMapping() != null) {
                if (values.containsKey(field) == false) {
                seenFields.add(field.name());
    private static final class ParallelFields extends Fields {
    }
    /**
                    }
        @Override
    private static void handleFieldWildcards(IndexShard indexShard, TermVectorsRequest request) {
import java.util.Set;
     * matching fields.  It never returns null.
            String field = getField.getName();
import org.apache.lucene.index.IndexReader;
            @Override
            parsedDocument.addDynamicMappingsUpdate(docMapper.getMapping());
            MappedFieldType fieldType = indexShard.mapperService().fieldType(field);
        };
                    result.add(field.binaryValue().utf8ToString());
        return result.toArray(new String[0]);
            @Override
            }
 * under the License.
                    termVectorsFilter.setSettings(request.filterSettings());
            request.offsets(),
            validFields
 * the Apache License, Version 2.0 (the "License"); you may
        return true;
        final Map<String, Terms> fields = new TreeMap<>();
        ParallelFields() {}
            documentFields,
