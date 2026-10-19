        public void incrementFieldArrayDepth() {
        }
 */
            return documents.subList(1, documents.size());
        }
            @Override
        }
            return this.docMapper;
        /** Reuse mappers built from dynamic_property for the same path within one document parse. */
    /**
            this.currentFieldDepth++;
            assert field.name().startsWith("_") || field.name().startsWith(prefix) : field.name() + " " + prefix;
            return in.docMapperParser();
            SourceToParse source,
        }
        return switchDoc(doc);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return groupingCriteriaParams;
            return path;
                this.currentFieldDepth--;
            public Document doc() {
                        + "] index level setting."
@PublicApi(since = "1.0.0")
                    newDocs.add(parents.poll());
        public Document rootDoc() {
        List<Document> docs() {
            this.currentFieldDepth = 0L;
        private final List<Mapper> dynamicMappers;
        }
 * Holds the context at parse time
            this.fields.addAll(fields);
        }
     */
        public String getPath() {
            @Override
            in.seqID(seqID);
     */
    public abstract DocumentMapper docMapper();
        }
        public InternalParseContext(
            return this.document;
        ) {
            this.in = in;
    /**
        }
        public BytesRef getBinaryValue(String name) {
        protected void addDoc(Document doc) {
        @Override
            return this.documents;
        public ContentPath path() {
        private DocumentInput documentInput;
     */
        private final DocumentMapper docMapper;
            }
    public final ParseContext switchDoc(final Document document) {
        public List<Mapper> getDynamicMappers() {
            in.addIgnoredField(field);
        /** Add fields so that they can later be fetched using {@link #getByKey(Object)}. */
        };
        @Override
                documents.clear();
            this.prefix = path.isEmpty() ? "" : path + ".";
        public void addDynamicMapper(Mapper update) {
                this.currentFieldDepth = 0;
        private final List<Document> documents;
import org.opensearch.core.xcontent.XContentParser;
                }
        public void addWithKey(Object key, IndexableField field) {
        public Document() {
            return in.isWithinMultiFields();
        private final Document parent;
            if (groupingCriteriaParams != null) {
        }
        public Document doc() {
     * Return the collection of fields that have been ignored so far.
        private Field version;
     * @param clazz Expected class for external value
            in.version(version);
        public XContentParser parser() {
        public InternalParseContext(
        public RootObjectMapper root() {
            in.checkFieldArrayDepthLimit();
            return null;
        @Override
                        + "] index level setting."
import java.util.Iterator;
        @Override
            @Override
        /**
        }
    /**
         * Return the parent document, or null if this is the root document.
            return this.version;
        public SeqNoFieldMapper.SequenceIDFields seqID() {
                List<Document> newDocs = reorderParent(documents);
        }
                // Preserve the order of the children while ensuring that parents appear after them.
    /**
        @Override
                        + "]."
    public abstract XContentParser parser();
            this.path = new ContentPath(0);
        public void addIgnoredField(String field) {
        }
        }
                    "The depth of the nested array field has exceeded the allowed limit of ["
        public DocumentMapperParser docMapperParser() {
import org.apache.lucene.index.IndexableField;
                        + " This limit can be set by changing the ["
        public String getGroupingCriteria() {
            return null;
        public Iterator<IndexableField> iterator() {
        @Override
        @Override
        }
        private final Map<String, Mapper> dynamicPropertyMapperCache = new HashMap<>();
        }
            return null;
        public void checkFieldDepthLimit() {
        };
            dynamicPropertyMapperCache.put(fullPath, mapper);
                );
            return in.getDynamicMappers();
        @Override
        return new FilterParseContext(this) {
        public Document rootDoc() {
            this.parent = parent;
 * not use this file except in compliance with the License.
        @Override
        public IndexSettings indexSettings() {
        @Override
            keyedFields.put(key, field);
     * @opensearch.internal
        }
            in.addDynamicMapper(update);
 * SPDX-License-Identifier: Apache-2.0
        public SourceToParse sourceToParse() {
    }
        }
        public MapperService mapperService() {
                if (f.name().equals(name) && f.binaryValue() != null) {
     * Return a new context that will have the provided path.
         */
        }
        return false;
     */
/**
        }
        }
        private boolean docsReversed = false;
        private Map<String, Object> groupingCriteriaParams;
            return in.lookupDynamicPropertyMapper(fullPath);
            if (keyedFields == null) {
import org.opensearch.index.engine.dataformat.DocumentInput;
        @Override
        public void seqID(SeqNoFieldMapper.SequenceIDFields seqID) {
        public void addDynamicMapper(Mapper mapper) {
    public abstract ContentPath path();
            this.maxAllowedNumNestedDocs = indexSettings.getMappingNestedDocsLimit();
    public final ParseContext createExternalValueContext(final Object externalValue) {
    public abstract DocumentMapperParser docMapperParser();
    /**
                return externalValue;
     * @opensearch.internal
     */
        public String getPrefix() {
    public abstract RootObjectMapper root();
            // either a meta fields or starts with the prefix
            in.decrementFieldCurrentDepth();
        @Override
            in.rememberDynamicPropertyMapper(fullPath, mapper);
            this.documents.add(doc);
 * compatible open source license.
package org.opensearch.index.mapper;
    public final ParseContext overridePath(final ContentPath path) {
         * Return the path associated with this document.
        public void decrementFieldCurrentDepth() {
            for (IndexableField f : fields) {
                        + MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING.getKey()
                }
            }
        if (!externalValueSet() || externalValue() == null) {
        public void incrementFieldCurrentDepth() {
    }
        private final long maxAllowedFieldDepth;
    /**
            public boolean isWithinMultiFields() {
            for (IndexableField field : fields) {
    public abstract void incrementFieldCurrentDepth();
        @Override
     */
        }
         * Return a prefix that all fields in this document should have.
        void rememberDynamicPropertyMapper(String fullPath, Mapper mapper) {
        public void decrementFieldCurrentDepth() {
        throw new IllegalStateException("External value is not set");
        }
                this.currentArrayDepth--;
        public void checkFieldArrayDepthLimit() {
     * Get dynamic mappers created while parsing.
            return in.path();
        return new FilterParseContext(this) {
        @Override
        private SeqNoFieldMapper.SequenceIDFields seqID;
        }
        public DocumentMapper docMapper() {
        public void decrementFieldArrayDepth() {
     */
     */
            return fields;
                keyedFields = new HashMap<>();
        }
        void postParse() {
import org.opensearch.index.IndexSettings;
        @Override
                    "The depth of the field has exceeded the allowed limit of ["
            if (documents.size() > 1) {
        final Document doc = new Document(fullPath, doc());
        }
            this.sourceToParse = source;
        }
            fields.add(field);
            XContentParser parser
            return in.doc();
    public abstract MapperService mapperService();
        }
        }
    public abstract void decrementFieldArrayDepth();
            return f.toArray(new IndexableField[0]);
import org.opensearch.OpenSearchParseException;
        }
        public MapperService mapperService() {
            @Override
        @Override
     * Return a new context that will have the external value set.
        /**
        public RootObjectMapper root() {
        public Collection<String> getIgnoredFields() {
import org.apache.lucene.util.BytesRef;
        @Override
        public boolean externalValueSet() {
            this("", null);
import java.util.Collection;
        @Override
                );
        @Override
    public static class Document implements Iterable<IndexableField> {
        private Document document;
        }
        public void seqID(SeqNoFieldMapper.SequenceIDFields seqID) {
        public void incrementFieldArrayDepth() {
            DocumentMapper docMapper,
import java.util.Set;
                    return f.binaryValue();
        Mapper lookupDynamicPropertyMapper(String fullPath) {
     */
        @Override
        }
        }
                parents.add(0, doc);
            return groupingCriteria;
 * specific language governing permissions and limitations
    public abstract void addDynamicMapper(Mapper update);
            }
                if (f.name().equals(name) && f.stringValue() != null) {
            return dynamicMappers;
            }
        public void decrementFieldArrayDepth() {
                documents.addAll(newDocs);
        }
        public Iterator<Document> iterator() {
            in.decrementFieldArrayDepth();
                        + maxAllowedFieldDepth
        @Override
            return in.getIgnoredFields();
 *
    public abstract IndexSettings indexSettings();
        }
            in.incrementFieldArrayDepth();
     * Add a new mapper dynamically created while parsing.
     */
            in.incrementFieldCurrentDepth();
            return in.seqID();
        /**
                return document;
    public abstract SourceToParse sourceToParse();
        if (!clazz.isInstance(externalValue())) {
                if (field.name().equals(name)) {
            this.documents = new ArrayList<>();
        }
            return in.docMapper();
        }
            }
        return clazz.cast(externalValue());
            return Collections.unmodifiableCollection(ignoredFields);
     * An internal parse context
    @ExperimentalApi
        @Override
        }
        public ContentPath path() {
    }
            IndexSettings indexSettings,
            return documents.get(0);
            this.version = version;
        public void addAll(List<? extends IndexableField> fields) {
            }
     */
         * Returns a copy of the provided {@link List} where parent documents appear
            return in.iterator();
            return fields.iterator();
            public Object externalValue() {
        }
                throw new IllegalStateException("documents are already reversed");
    public abstract void checkFieldDepthLimit();
            if (this.currentFieldDepth > maxAllowedFieldDepth) {
        @Override
            List<IndexableField> f = new ArrayList<>();
        @Override
                throw new OpenSearchParseException(
                return path;
    /**
 * You may obtain a copy of the License at
        }
            return this.sourceToParse;
/*
        }
 * license agreements. See the NOTICE file distributed with
            }
        }
            throw new IllegalArgumentException(
     *
 * under the License.
        addDoc(doc);
            if (numNestedDocs > maxAllowedNumNestedDocs) {
        public Iterable<Document> nonRootDocuments() {
            return null;
                        + "] index level setting."
            } else if (keyedFields.containsKey(key)) {
        @Override
        }
        @Override
        return new FilterParseContext(this) {
            add(field);
     * Returns an Iterable over all non-root documents. If there are no non-root documents
        }
         */
            return this.parser;
        }
         */
        @Override
        }
    public final ParseContext createNestedContext(String fullPath) {
        private long currentFieldDepth;
    public abstract void decrementFieldCurrentDepth();
        public IndexableField getByKey(Object key) {
        }
        public Document getParent() {
     * Return a new context that has the provided document as the current document.
    public boolean isWithinCopyTo() {
    }
        @Override
    }
    /**
     */
import java.util.HashMap;
     * Add the given {@code field} to the set of ignored fields.
        }
        public List<IndexableField> getFields() {
            @Override
    public abstract Document rootDoc();
}
            return parent;
        @Override
            }
        @Override
        public SeqNoFieldMapper.SequenceIDFields seqID() {
    /**
    private static class FilterParseContext extends ParseContext {
        }
            return this.docMapperParser;
        @Override
        private List<Document> reorderParent(List<Document> docs) {
                        + MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING.getKey()
import java.util.Map;
            return in.documentInput();
            this.numNestedDocs = 0L;
        public XContentParser parser() {
                return parser;
        @Override
            if (docsReversed) {
        Mapper lookupDynamicPropertyMapper(String fullPath) {
 */
        @Override
 * @opensearch.api
        }
    /**
import java.util.Collections;
        private final SourceToParse sourceToParse;
import java.util.ArrayList;
            this.version = null;
        private final ParseContext in;
        private final String path;
            this.currentArrayDepth++;
     * @return null if no external value has been set or the value
            return in.nonRootDocuments();
         * after their children.
    public abstract Field version();
            }
            return newDocs;
            public boolean isWithinCopyTo() {
    public Object externalValue() {
 * this file be licensed under the Apache-2.0 license or a
        return new FilterParseContext(this) {
     *
            in.checkFieldDepthLimit();
 *    http://www.apache.org/licenses/LICENSE-2.0
    public abstract void checkFieldArrayDepthLimit();
/*
    void rememberDynamicPropertyMapper(String fullPath, Mapper mapper) {}
        @Override
        }
    public boolean isWithinMultiFields() {
        @Override
        }
            return documents.iterator();
        @Override
            return this.indexSettings;
import org.opensearch.common.annotation.ExperimentalApi;
        }
        /** Get back fields that have been previously added with {@link #addWithKey(Object, IndexableField)}. */
        };
 *
                }
            groupingCriteriaParams = Map.of(fieldName, value);
    protected abstract void addDoc(Document doc);
        }
        @Override
    /**
            }
        }
            ignoredFields.add(field);
        private String groupingCriteria;
        public void incrementFieldCurrentDepth() {
            if (this.currentArrayDepth > 0) {
        @Override
    public abstract void seqID(SeqNoFieldMapper.SequenceIDFields seqID);
            this.documents.add(document);
            );
 * KIND, either express or implied.  See the License for the
                        + maxAllowedArrayDepth
     */
    public final ParseContext createMultiFieldContext() {
         */
    }
            newDocs.addAll(parents);
        public Iterable<Document> nonRootDocuments() {
        }
public abstract class ParseContext implements Iterable<ParseContext.Document> {
        }
        return new FilterParseContext(this) {
     * Return a new context that will be within multi-fields.
        public DocumentMapper docMapper() {
        public DocumentInput documentInput() {
        public void version(Field version) {
                throw new OpenSearchParseException(
        public void add(IndexableField field) {
        public void checkFieldDepthLimit() {
            return prefix;
import org.apache.lucene.document.Field;
        private long numNestedDocs;
        }
        public boolean isWithinCopyTo() {
        @Override
            in.addDoc(doc);
            }
 */
                    "The number of nested documents has exceeded the allowed limit of ["
        @Override
        public void version(Field version) {
        public Field version() {
        public DocumentMapperParser docMapperParser() {
                this.currentArrayDepth = 0;
        @Override
 * The OpenSearch Contributors require contributions made to
            return in.sourceToParse();
    }
    /**
            return this.seqID;
                    return field;
        };
        @Override
import java.util.LinkedList;
        }
    }
            this.document = new Document();
    }
    public static class InternalParseContext extends ParseContext {
    public final ParseContext switchParser(final XContentParser parser) {
        public List<Mapper> getDynamicMappers() {
    public final <T> T parseExternalValue(Class<T> clazz) {
        @Override
        public String get(String name) {
        }
        public void setGroupingCriteria(String groupingCriteria) {
                if (field.name().equals(name)) {
        public SourceToParse sourceToParse() {
            dynamicMappers.add(mapper);
        return new FilterParseContext(this) {
        public DocumentInput documentInput() {
        @Override
            DocumentMapperParser docMapperParser,
        private Document(String path, Document parent) {
        }
            }
 *
        }
        }
        private final long maxAllowedNumNestedDocs;
        void rememberDynamicPropertyMapper(String fullPath, Mapper mapper) {
        ) {
        }
        }
        }
            List<Document> newDocs = new ArrayList<>(docs.size());
        @Override
        protected void addDoc(Document doc) {
    public final ParseContext createCopyToContext() {
                docsReversed = true;
            IndexSettings indexSettings,
     * Filter parse context.
            if (this.currentArrayDepth > maxAllowedArrayDepth) {
        @Override
            }
     */
            }
                }
        public IndexSettings indexSettings() {
            DocumentMapperParser docMapperParser,
    public abstract Document doc();
    }
                throw new MapperParsingException(
        @Override
            return in.rootDoc();
            SourceToParse source,
                throw new IllegalStateException("Only one field can be stored per key");
    /**
            }
            for (Document doc : docs) {
        }
 * GitHub history for details.
     * Return a new context that will be used within a nested document.
    public abstract Iterable<Document> nonRootDocuments();
 * Modifications Copyright OpenSearch Contributors. See
 *
            this.parser = parser;
        @Override
        public Iterator<Document> iterator() {
        public IndexableField[] getFields(String name) {
            this(indexSettings, docMapperParser, docMapper, source, parser, null);
    }
     * Caches a mapper built for a dynamic_property field path for the rest of this parse.
        }
    }
     * Try to parse an externalValue if any
                        + MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING.getKey()
            @Override
                    return f.stringValue();
            return this.documentInput;
                "illegal external value class [" + externalValue().getClass().getName() + "]. Should be " + clazz.getName()
                throw new IllegalArgumentException("grouping criteria params already set");
        /**
        return null;
 */
        public Collection<String> getIgnoredFields() {
        }
        }
     * the iterable will return an empty iterator.
    public boolean externalValueSet() {
                return true;
    @PublicApi(since = "1.0.0")
        @Override
        }
        @Override
        public Document doc() {
                        + " This limit can be set by changing the ["
     * Fork of {@link org.apache.lucene.document.Document} with additional functionality.
        };
    public abstract void incrementFieldArrayDepth();
            this.dynamicMappers = new ArrayList<>();
 * this work for additional information regarding copyright
        public Object externalValue() {
        }
        @Override
        }
    /**
    public abstract Collection<String> getIgnoredFields();
        private final List<IndexableField> fields;
            return this.path;
        @Override
        }
        }
            return keyedFields == null ? null : keyedFields.get(key);
    }
            }
            return docMapperParser.mapperService;
            this.maxAllowedFieldDepth = indexSettings.getMappingDepthLimit();
        public void addIgnoredField(String field) {
        @Override
            DocumentMapper docMapper,
        public Field version() {
        @Override
                        + "]."
        private final Set<String> ignoredFields = new HashSet<>();
            this.path = path;
                    f.add(field);
     */
        @Override
        }
        private FilterParseContext(ParseContext in) {
        }
            }
     *
     * @opensearch.api
        }
            this.currentArrayDepth = 0L;
            this.documentInput = documentInput;
            DocumentInput documentInput
            public XContentParser parser() {
                        + "]."
        public IndexableField getField(String name) {
        @Override
            public ContentPath path() {
            return docMapper.root();
import org.opensearch.common.annotation.PublicApi;
            return in.indexSettings();
        private final ContentPath path;
            public boolean externalValueSet() {
                return true;
    /**
        }
        public boolean isWithinMultiFields() {
                );
        private final XContentParser parser;
            return dynamicPropertyMapperCache.get(fullPath);
                        + maxAllowedNumNestedDocs
     */
            this.seqID = seqID;
        @Override
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
            for (IndexableField field : fields) {
            return in.parser();
        }
                }
    public abstract List<Mapper> getDynamicMappers();
        @Override
        return false;
     */
            this.indexSettings = indexSettings;
        private final String prefix;
 * Licensed to Elasticsearch under one or more contributor
            return in.externalValueSet();
            XContentParser parser,
        return false;
        private final DocumentMapperParser docMapperParser;
    public abstract void addIgnoredField(String field);
            this.docMapperParser = docMapperParser;
        private final long maxAllowedArrayDepth;
        }
        public void checkFieldArrayDepthLimit() {
        @Override
            }
        @Override
        public Map<String, Object> getGroupingCriteriaParams() {
            }
 * software distributed under the License is distributed on an
    /**
    public abstract SeqNoFieldMapper.SequenceIDFields seqID();
        }
        public void addGroupingCriteriaParams(final String fieldName, final Object value) {
            if (this.currentFieldDepth > 0) {
            return in.isWithinCopyTo();
        @Override
            return in.mapperService();
        @Override
        }
    }
    }
            return in.externalValue();
    Mapper lookupDynamicPropertyMapper(String fullPath) {
            LinkedList<Document> parents = new LinkedList<>();
                        + " This limit can be set by changing the ["
        }
            numNestedDocs++;
            return in.root();
        }
            }
 * Unless required by applicable law or agreed to in writing,
            }
     * Return a new context that will be within a copy-to operation.
 * ownership. Elasticsearch licenses this file to you under
import java.util.List;
    public abstract void version(Field version);
        @Override
        }
     * Returns a cached mapper for a dynamic_property match, or null.
        }
            this.docMapper = docMapper;
    }
        }
            @Override
        }
        private Map<Object, IndexableField> keyedFields;
            this.maxAllowedArrayDepth = indexSettings.getMappingDepthLimit();
            this.groupingCriteria = groupingCriteria;
                while (parents.peek() != doc.getParent()) {
            for (IndexableField f : fields) {
    public abstract DocumentInput<?> documentInput();
        @Override
        }
        }
    /**
                return true;
            return in.version();
import java.util.HashSet;
        private final IndexSettings indexSettings;
            fields = new ArrayList<>();
        }
/*
        };
        private long currentArrayDepth;
