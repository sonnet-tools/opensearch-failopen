        @Override
        }
            return null;
        private Map<String, Object> groupingCriteriaParams;
                documents.addAll(newDocs);
     * Add the given {@code field} to the set of ignored fields.
        @Override
     * @param clazz Expected class for external value  
        }
        }  
        public IndexSettings indexSettings() {
                        + "]."  
        public void checkFieldArrayDepthLimit() {
import org.opensearch.OpenSearchParseException;
        return false;
    /**  
     * @return null if no external value has been set or the value
            return in.sourceToParse();
        private final Document parent;
import java.util.List;  
        @Override
            );
     */
import java.util.Collections;
        public void version(Field version) {
        }
        private long currentFieldDepth;
        };
        @Override  
        }
    public static class Document implements Iterable<IndexableField> {  
import java.util.Iterator;
            newDocs.addAll(parents);
        public Document doc() {
        @Override  
        @Override  
        return false;
        }
            }  
            LinkedList<Document> parents = new LinkedList<>();  
        private FilterParseContext(ParseContext in) {  
        public Object externalValue() {  
        /**
            in.addDynamicMapper(update);  
import org.opensearch.index.IndexSettings;
            for (IndexableField field : fields) {
     */
     *
            if (this.currentArrayDepth > 0) {  
        public SourceToParse sourceToParse() {  
            return dynamicMappers;
        public DocumentMapperParser docMapperParser() {  
            return this.documentInput;
    public abstract IndexSettings indexSettings();
    private static class FilterParseContext extends ParseContext {
        }
            return this.docMapper;  
        }
        @Override  
 */  
        /**  
        public void checkFieldDepthLimit() {  
            return this.document;
     * Returns an Iterable over all non-root documents. If there are no non-root documents
    public abstract Document doc();  
import java.util.ArrayList;
    public static class InternalParseContext extends ParseContext {  
     * @opensearch.internal
        public void decrementFieldCurrentDepth() {  
            this.currentFieldDepth = 0L;
        public Document() {
            return null;
        }  
        public SeqNoFieldMapper.SequenceIDFields seqID() {  
    public abstract void addDynamicMapper(Mapper update);
            @Override  
            return Collections.unmodifiableCollection(ignoredFields);
            public Document doc() {
            return fields;  
                throw new IllegalStateException("documents are already reversed");  
        }  
        @Override
        void postParse() {
        public void add(IndexableField field) {
 * SPDX-License-Identifier: Apache-2.0
        public Document rootDoc() {
        }
import org.apache.lucene.util.BytesRef;  
            return in.nonRootDocuments();  
     * Return a new context that has the provided document as the current document.
    /**  
            this.fields.addAll(fields);
        }
        public void decrementFieldArrayDepth() {  
            if (this.currentArrayDepth > maxAllowedArrayDepth) {
            dynamicMappers.add(mapper);  
            this.sourceToParse = source;
                this.currentArrayDepth = 0;
                documents.clear();
         */  
    }
        return null;  
                    f.add(field);
        public InternalParseContext(  
        public DocumentInput documentInput() {
     */  
 *  
                // Preserve the order of the children while ensuring that parents appear after them.
    public abstract RootObjectMapper root();
        @Override
            DocumentInput documentInput
        public void addAll(List<? extends IndexableField> fields) {
     */  
            }
            for (IndexableField f : fields) {
                        + maxAllowedArrayDepth
    public abstract DocumentMapper docMapper();  
            if (docsReversed) {
            }  
    public final ParseContext createCopyToContext() {  
        @Override
        }
/**
            DocumentMapper docMapper,  
        @Override
        private final List<Document> documents;  
        }
            }
        @Override
            SourceToParse source,
        }  
            return groupingCriteria;
            return dynamicPropertyMapperCache.get(fullPath);
        private final List<Mapper> dynamicMappers;
        @Override  
/*
            return this.documents;  
    public abstract SeqNoFieldMapper.SequenceIDFields seqID();
            return parent;  
    }
     */
        }  
    public final ParseContext createExternalValueContext(final Object externalValue) {  
            }
    public final <T> T parseExternalValue(Class<T> clazz) {  
        protected void addDoc(Document doc) {
        }
        public Document rootDoc() {  
        }
     * Add a new mapper dynamically created while parsing.
        @Override  
        return false;  
                parents.add(0, doc);
        @Override
                        + MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING.getKey()
        }
            return null;
         */  
     * the iterable will return an empty iterator.
            if (documents.size() > 1) {  
            DocumentMapperParser docMapperParser,  
    public abstract void incrementFieldCurrentDepth();
            keyedFields.put(key, field);  
        }  
            this.indexSettings = indexSettings;  
    /**  
            in.seqID(seqID);  
        private final String prefix;
     * An internal parse context
        }
            return this.seqID;
        public Field version() {  
        }  
    public abstract void decrementFieldArrayDepth();
        public IndexableField getField(String name) {
    }  
            this.path = path;  
            in.decrementFieldArrayDepth();
        Mapper lookupDynamicPropertyMapper(String fullPath) {  
            }
/*  
        public void decrementFieldCurrentDepth() {
            }
            } else if (keyedFields.containsKey(key)) {  
        public void addDynamicMapper(Mapper update) {
 * Unless required by applicable law or agreed to in writing,
     */  
            return prefix;
 * this work for additional information regarding copyright
        @Override  
                }
        throw new IllegalStateException("External value is not set");
                if (f.name().equals(name) && f.stringValue() != null) {  
                }
        };
            }  
        }
        }
         * Return a prefix that all fields in this document should have.
        return switchDoc(doc);
        ) {
        }
            public boolean isWithinMultiFields() {
    }
            return this.version;
            this.parser = parser;
                throw new MapperParsingException(
        public List<Mapper> getDynamicMappers() {
        }
 * Holds the context at parse time
            throw new IllegalArgumentException(  
        private long currentArrayDepth;  
    }
        public void decrementFieldArrayDepth() {
        public BytesRef getBinaryValue(String name) {
        public void seqID(SeqNoFieldMapper.SequenceIDFields seqID) {
        }
     */  
     * Fork of {@link org.apache.lucene.document.Document} with additional functionality.
        }
            }  
        @Override  
    public final ParseContext createNestedContext(String fullPath) {
            return in.isWithinCopyTo();
        /** Add fields so that they can later be fetched using {@link #getByKey(Object)}. */
                }
 * specific language governing permissions and limitations
        }
    /**  
        }  
        @Override
            groupingCriteriaParams = Map.of(fieldName, value);
        }
 *
            in.incrementFieldCurrentDepth();
        public String getGroupingCriteria() {  
        public void addIgnoredField(String field) {
        public InternalParseContext(
        public List<IndexableField> getFields() {
        }
     */
/*  
    public abstract XContentParser parser();
        private boolean docsReversed = false;  
        @Override
        public boolean isWithinMultiFields() {
        public IndexableField getByKey(Object key) {
    /**
                if (field.name().equals(name)) {  
        public RootObjectMapper root() {
        if (!clazz.isInstance(externalValue())) {
    protected abstract void addDoc(Document doc);
        public void addDynamicMapper(Mapper mapper) {
            public boolean externalValueSet() {  
                return path;
        @Override
        private final ParseContext in;
        @Override
        @Override
 * under the License.  
        }  
        }  
        private final List<IndexableField> fields;
        public RootObjectMapper root() {  
        @Override
        @Override  
 * @opensearch.api
        @Override
        @Override
        private Document(String path, Document parent) {
                        + MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING.getKey()
        }
            this.maxAllowedArrayDepth = indexSettings.getMappingDepthLimit();
    }
        public void version(Field version) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.HashSet;  
        return new FilterParseContext(this) {
        }
        private final IndexSettings indexSettings;
                        + maxAllowedFieldDepth
        private final DocumentMapperParser docMapperParser;
import org.opensearch.core.xcontent.XContentParser;
        }  
            @Override
            }  
        }
import org.apache.lucene.index.IndexableField;
     */
        @Override
        }
     * Caches a mapper built for a dynamic_property field path for the rest of this parse.
        final Document doc = new Document(fullPath, doc());
        }
            public ContentPath path() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        };
        List<Document> docs() {
                throw new IllegalStateException("Only one field can be stored per key");
            return in.parser();
        public Document getParent() {
    public abstract Iterable<Document> nonRootDocuments();
            this.in = in;
            for (Document doc : docs) {
        @Override
    public boolean isWithinMultiFields() {
            if (numNestedDocs > maxAllowedNumNestedDocs) {
        }
    /**  
        private Field version;  
            return in.isWithinMultiFields();  
            this.numNestedDocs = 0L;
 * KIND, either express or implied.  See the License for the
    }  
            in.checkFieldArrayDepthLimit();  
    /**
         * after their children.
            List<IndexableField> f = new ArrayList<>();
     */
        @Override
                "illegal external value class [" + externalValue().getClass().getName() + "]. Should be " + clazz.getName()
        }
        public void incrementFieldArrayDepth() {  
        @Override  
            XContentParser parser,  
            @Override  
            }  
            return this.docMapperParser;
    }
    /**
        @Override
        @Override
        void rememberDynamicPropertyMapper(String fullPath, Mapper mapper) {
        @Override  
            return docMapper.root();
        private final XContentParser parser;
            this.documentInput = documentInput;  
import java.util.Set;
        @Override
    }
            public boolean isWithinCopyTo() {  
        @Override
            return fields.iterator();
                if (f.name().equals(name) && f.binaryValue() != null) {  
        private final SourceToParse sourceToParse;
        @Override
                    "The number of nested documents has exceeded the allowed limit of ["  
                );
        public MapperService mapperService() {  
            return in.path();  
                        + " This limit can be set by changing the ["
     */  
        public IndexableField[] getFields(String name) {  
            in.checkFieldDepthLimit();  
    Mapper lookupDynamicPropertyMapper(String fullPath) {
        public Iterator<Document> iterator() {  
        @Override
    public abstract void version(Field version);  
        @Override
    }
        return new FilterParseContext(this) {
        }
        }  
        }  
    public abstract void seqID(SeqNoFieldMapper.SequenceIDFields seqID);
        @Override  
            IndexSettings indexSettings,
import org.apache.lucene.document.Field;
                return parser;
        public void addWithKey(Object key, IndexableField field) {  
                return true;
    /**
        public DocumentMapper docMapper() {
            return this.indexSettings;  
    @ExperimentalApi
            return docMapperParser.mapperService;
                        + "] index level setting."  
    /**  
        }  
            XContentParser parser
            this.version = null;  
                this.currentFieldDepth = 0;
        return new FilterParseContext(this) {
    public Object externalValue() {  
    public abstract SourceToParse sourceToParse();
        private SeqNoFieldMapper.SequenceIDFields seqID;
        private DocumentInput documentInput;
            this.docMapperParser = docMapperParser;
        }
        }  
            DocumentMapper docMapper,
                );
    public abstract Document rootDoc();
     */
        private final Map<String, Mapper> dynamicPropertyMapperCache = new HashMap<>();
 * Licensed to Elasticsearch under one or more contributor  
        @Override
        @Override  
        @Override
        @Override
        }
        public Collection<String> getIgnoredFields() {
    /**
    public abstract ContentPath path();  
            this(indexSettings, docMapperParser, docMapper, source, parser, null);
        private final long maxAllowedArrayDepth;
        private Map<Object, IndexableField> keyedFields;  
                this.currentFieldDepth--;
            this.prefix = path.isEmpty() ? "" : path + ".";
 *
        }  
        @Override
    }
    public boolean externalValueSet() {
        }
            return this.path;
            if (this.currentFieldDepth > 0) {  
        @Override
@PublicApi(since = "1.0.0")  
        }
            fields = new ArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See
            this.docMapper = docMapper;
                        + maxAllowedNumNestedDocs
        }  
import org.opensearch.common.annotation.PublicApi;  
            return in.doc();  
        public void addIgnoredField(String field) {  
                        + "]."  
        public void checkFieldArrayDepthLimit() {  
            if (this.currentFieldDepth > maxAllowedFieldDepth) {
            for (IndexableField f : fields) {
            in.addDoc(doc);
        public void incrementFieldCurrentDepth() {  
            List<Document> newDocs = new ArrayList<>(docs.size());
 * not use this file except in compliance with the License.
        @Override  
        public boolean externalValueSet() {
                );  
        }
        public ContentPath path() {  
            assert field.name().startsWith("_") || field.name().startsWith(prefix) : field.name() + " " + prefix;
            this.maxAllowedNumNestedDocs = indexSettings.getMappingNestedDocsLimit();  
        public String get(String name) {
        ) {  
        public void incrementFieldArrayDepth() {
    /**
        public XContentParser parser() {
            return in.getIgnoredFields();  
            return documents.subList(1, documents.size());
        /**  
        }
        }
        private final Set<String> ignoredFields = new HashSet<>();
            IndexSettings indexSettings,
        @Override  
            return keyedFields == null ? null : keyedFields.get(key);  
                return externalValue;  
import org.opensearch.index.engine.dataformat.DocumentInput;  
        @Override  
 */
            return in.iterator();
        };
        @Override
                this.currentArrayDepth--;
    public abstract void checkFieldDepthLimit();  
            @Override  
        private List<Document> reorderParent(List<Document> docs) {
        public void incrementFieldCurrentDepth() {
            this.maxAllowedFieldDepth = indexSettings.getMappingDepthLimit();
        public void addGroupingCriteriaParams(final String fieldName, final Object value) {  
        public Iterable<Document> nonRootDocuments() {
        public Collection<String> getIgnoredFields() {
     */
 * GitHub history for details.
                throw new OpenSearchParseException(  
         * Return the parent document, or null if this is the root document.  
        }
    public abstract void addIgnoredField(String field);  
     * Try to parse an externalValue if any
                return document;
        private final ContentPath path;  
                    "The depth of the field has exceeded the allowed limit of ["
            this.path = new ContentPath(0);  
        }  
        @Override
 * software distributed under the License is distributed on an
        }
        return new FilterParseContext(this) {
        @Override  
 */  
                return true;
            return documents.get(0);
        }
            this.version = version;  
    public abstract void incrementFieldArrayDepth();
import java.util.HashMap;
            return in.getDynamicMappers();
            return in.docMapperParser();
            }  
                        + MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING.getKey()
        };
            if (keyedFields == null) {
    void rememberDynamicPropertyMapper(String fullPath, Mapper mapper) {}  
            return in.indexSettings();
            }
        @Override
            return in.docMapper();
    public abstract Collection<String> getIgnoredFields();
     * @opensearch.api  
        public Iterator<IndexableField> iterator() {
            return in.externalValue();
package org.opensearch.index.mapper;
            return newDocs;
        }
        /** Reuse mappers built from dynamic_property for the same path within one document parse. */  
            }
            this.documents.add(doc);
        }
        }
 * the Apache License, Version 2.0 (the "License"); you may
        return new FilterParseContext(this) {
        }
        }  
            return in.seqID();
            in.decrementFieldCurrentDepth();
}
        }  
     * @opensearch.internal  
         */
            return groupingCriteriaParams;
        }  
                        + " This limit can be set by changing the ["  
                    newDocs.add(parents.poll());  
    public final ParseContext switchDoc(final Document document) {
        }  
    public abstract DocumentInput<?> documentInput();  
        /**
                    return field;
     */
            if (groupingCriteriaParams != null) {
     * Return a new context that will be used within a nested document.
        }  
                keyedFields = new HashMap<>();
            ignoredFields.add(field);  
            }
                while (parents.peek() != doc.getParent()) {
    public abstract List<Mapper> getDynamicMappers();  
        addDoc(doc);  
        private final long maxAllowedNumNestedDocs;
        public void checkFieldDepthLimit() {
        }
     * Return a new context that will have the external value set.
 * The OpenSearch Contributors require contributions made to  
            return documents.iterator();
    public abstract void checkFieldArrayDepthLimit();  
import java.util.Map;
        }  
        Mapper lookupDynamicPropertyMapper(String fullPath) {  
        }  
 *  
     */  
import java.util.Collection;  
        @Override
            this.parent = parent;
        @Override
        /** Get back fields that have been previously added with {@link #addWithKey(Object, IndexableField)}. */
            }
        private final String path;  
    }
    }
 * ownership. Elasticsearch licenses this file to you under  
     *  
        return new FilterParseContext(this) {
     *
        }
        }
        }  
     */
        public DocumentInput documentInput() {  
            }
            return in.lookupDynamicPropertyMapper(fullPath);
                throw new OpenSearchParseException(  
    /**
        }  
        @Override
        }
        }  
            numNestedDocs++;  
        }  
    public final ParseContext overridePath(final ContentPath path) {
    }
            DocumentMapperParser docMapperParser,
        protected void addDoc(Document doc) {  
        @Override
        @Override
 */
            @Override
public abstract class ParseContext implements Iterable<ParseContext.Document> {
     * Return a new context that will be within multi-fields.
        public ContentPath path() {
        public Iterator<Document> iterator() {
        }
            this.documents = new ArrayList<>();
        }
            this.currentFieldDepth++;
                docsReversed = true;
        private final DocumentMapper docMapper;
                return true;
        }  
            this.groupingCriteria = groupingCriteria;  
            add(field);
        public Map<String, Object> getGroupingCriteriaParams() {
            }  
        }  
        @Override  
        private final long maxAllowedFieldDepth;
            return path;
            dynamicPropertyMapperCache.put(fullPath, mapper);  
     * Get dynamic mappers created while parsing.
    public abstract void decrementFieldCurrentDepth();
            public Object externalValue() {
            this.dynamicMappers = new ArrayList<>();
 * compatible open source license.
 * You may obtain a copy of the License at  
            @Override  
    public abstract Field version();
        public SourceToParse sourceToParse() {
            in.addIgnoredField(field);
    /**  
            this.currentArrayDepth++;
import org.opensearch.common.annotation.ExperimentalApi;
        public String getPrefix() {
        }
        public IndexSettings indexSettings() {
                if (field.name().equals(name)) {  
         */
            return in.externalValueSet();
                        + "]."
         * Returns a copy of the provided {@link List} where parent documents appear
        public Document doc() {
                    return f.binaryValue();
        public DocumentMapper docMapper() {
            return in.root();  
        @Override
            this.documents.add(document);
    public abstract DocumentMapperParser docMapperParser();
        public void setGroupingCriteria(String groupingCriteria) {
            this.currentArrayDepth = 0L;  
            return in.rootDoc();
        };  
    @PublicApi(since = "1.0.0")
    }
            in.rememberDynamicPropertyMapper(fullPath, mapper);  
        public DocumentMapperParser docMapperParser() {
            return null;
        }
            return this.parser;  
        public boolean isWithinCopyTo() {  
                }
        private String groupingCriteria;
        }
        }  
        @Override
            return this.sourceToParse;
            in.version(version);
        }
        @Override  
            for (IndexableField field : fields) {
        if (!externalValueSet() || externalValue() == null) {
        @Override  
            return f.toArray(new IndexableField[0]);
        public Field version() {
        @Override
        }  
                List<Document> newDocs = reorderParent(documents);  
            fields.add(field);
            }  
    /**
                throw new IllegalArgumentException("grouping criteria params already set");
        private long numNestedDocs;  
            return in.version();  
            SourceToParse source,
        public Iterable<Document> nonRootDocuments() {
     * Return a new context that will have the provided path.
        void rememberDynamicPropertyMapper(String fullPath, Mapper mapper) {
        public SeqNoFieldMapper.SequenceIDFields seqID() {
            }  
            // either a meta fields or starts with the prefix  
import java.util.LinkedList;
            return in.mapperService();
    public final ParseContext createMultiFieldContext() {
        }  
    public final ParseContext switchParser(final XContentParser parser) {
                        + "] index level setting."
                        + "] index level setting."  
    public abstract MapperService mapperService();
    /**
            this("", null);  
            @Override
            public XContentParser parser() {
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
 * license agreements. See the NOTICE file distributed with
                        + " This limit can be set by changing the ["
        @Override
        public List<Mapper> getDynamicMappers() {
        return clazz.cast(externalValue());
            return in.documentInput();
                    return f.stringValue();
        public void seqID(SeqNoFieldMapper.SequenceIDFields seqID) {  
    public boolean isWithinCopyTo() {  
     * Return the collection of fields that have been ignored so far.  
            this.document = new Document();
     * Return a new context that will be within a copy-to operation.
        public MapperService mapperService() {
     */
         * Return the path associated with this document.
                    "The depth of the nested array field has exceeded the allowed limit of ["
            }  
        }
     * Returns a cached mapper for a dynamic_property match, or null.  
        private Document document;
            in.incrementFieldArrayDepth();
     * Filter parse context.
    }
        public XContentParser parser() {
        public String getPath() {  
        @Override
            this.seqID = seqID;
    /**  
