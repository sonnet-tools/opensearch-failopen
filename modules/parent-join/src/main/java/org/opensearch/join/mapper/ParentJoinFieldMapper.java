            }
        for (ParentIdFieldMapper mapper : parentIdFields) {
        return parentIdFields.stream().anyMatch((mapper) -> name.equals(mapper.getParentName()));
        }
import org.opensearch.index.query.QueryShardContext;
                    // it is forbidden to add a parent to an existing child
    }
    private static void checkObjectOrNested(ContentPath path, String name) {
        }
            }
                if ("relations".equals(entry.getKey())) {
}
            final IndexSettings indexSettings = parserContext.mapperService().getIndexSettings();
import org.opensearch.common.xcontent.support.XContentMapValues;
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
        if (isPluggableDataFormatFeatureEnabled(context)) {
import org.apache.lucene.util.BytesRef;
            );
            } else {
    private static String getParentIdFieldName(String joinFieldName, String parentName) {
 * KIND, either express or implied.  See the License for the
    @Override
    private MetaJoinFieldMapper uniqueFieldMapper;
                newParentIdFields.add(mergeWithMapper);
    public static ParentJoinFieldMapper getMapper(MapperService service) {
        }
                }
import java.util.Iterator;
        this.eagerGlobalOrdinals = joinMergeWith.eagerGlobalOrdinals;
                    continue;
                } else if (token == XContentParser.Token.VALUE_STRING) {
    }
        }
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
                if (eagerGlobalOrdinals) {
            } else {
            parentIdField.parse(externalContext);
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        throw new UnsupportedOperationException("parsing is implemented in parse(), this method should NEVER be called");
    }
import org.opensearch.index.mapper.StringFieldType;
                    continue;
        DocumentMapper mapper = service.documentMapper();
        }
import org.opensearch.index.fielddata.IndexFieldData;
    }
 * This field is only used to ensure that there is a single parent-join field defined in the mapping and
            super(name, Defaults.FIELD_TYPE);
            final List<ParentIdFieldMapper> parentIdFields = new ArrayList<>();
        }
 *
        }
        MappedFieldType mappedFieldType,
        static {
    public JoinFieldType fieldType() {
        }
 * software distributed under the License is distributed on an
                }
import org.opensearch.index.mapper.MapperService;
 */
        String joinField = fieldType.getJoinField();
    @Override
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
import org.opensearch.index.mapper.FieldMapper;
        throw new UnsupportedOperationException("parsing is implemented in parse(), this method should NEVER be called");
import org.opensearch.index.mapper.SourceValueFetcher;
    public static final String CONTENT_TYPE = "join";
        if (settings.getIndexMetadata().isRoutingPartitionedIndex()) {
import java.util.List;
        Set<String> children = new HashSet<>();
import org.opensearch.core.xcontent.XContentBuilder;
            FIELD_TYPE.setTokenized(false);
 * this work for additional information regarding copyright
    }
                    currentFieldName = context.parser().currentName();
        public Builder(String name) {
/*
                    iterator.remove();
                for (String child : self.getChildren()) {
            }
        }
    public ParentIdFieldMapper getParentIdFieldMapper(String name, boolean isParent) {
                Map.Entry<String, Object> entry = iterator.next();
/**
                for (String child : mergeWithMapper.getChildren()) {
    }
        }
        MetaJoinFieldMapper.MetaJoinFieldType fieldType = (MetaJoinFieldMapper.MetaJoinFieldType) service.fieldType(
import org.opensearch.index.mapper.ValueFetcher;
            return new SortedSetOrdinalsIndexFieldData.Builder(name(), CoreValuesSourceType.BYTES);
    /**
    private List<ParentIdFieldMapper> parentIdFields;
                        Map.Entry<String, Object> relation = relIt.next();
        @Override
 *
                    iterator.remove();
                throw new IllegalArgumentException("[parent] is missing for join field [" + name() + "]");
            name = context.parser().text();
        }
        public Builder eagerGlobalOrdinals(boolean eagerGlobalOrdinals) {
            }).forEach(parentIdFields::add);
    }
            parentIdFieldBuilders.add(new ParentIdFieldMapper.Builder(parentIdFieldName, parent, children));
            parentIdFieldBuilders.stream().map((parentBuilder) -> {
        if (token == XContentParser.Token.START_OBJECT) {
     * Returns the {@link ParentJoinFieldMapper} associated with the <code>service</code> or null
     */
            throw new IllegalArgumentException(
    }
    }
            if (joinMergeWith.getParentIdFieldMapper(mapper.getParentName(), true) == null) {
        for (ParentIdFieldMapper field : parentIdFields) {
                    } else if ("parent".equals(currentFieldName)) {
            MetaJoinFieldMapper unique = new MetaJoinFieldMapper.Builder(name).build(context);
            checkIndexCompatibility(indexSettings, name);
            this.eagerGlobalOrdinals = eagerGlobalOrdinals;
                    if (mergeWithMapper.getChildren().contains(child) == false) {
            }
        public static final FieldType FIELD_TYPE = new FieldType();
    protected void doXContentBody(XContentBuilder builder, boolean includeDefaults, Params params) throws IOException {
import org.apache.lucene.index.IndexOptions;
     * Returns true if <code>name</code> is a child name in the field.
        List<String> conflicts = new ArrayList<>();
import org.apache.lucene.document.Field;
                    if (getParentIdFieldMapper(child, true) != null) {
                    } else {
import java.util.Collections;
                return mapper;
            if (value == null) {
        builder.startObject("relations");
            parent = null;
                    Map<String, Object> relations = XContentMapValues.nodeMapValue(entry.getValue(), "relations");
                    }
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
        for (ParentIdFieldMapper mapper : parentIdFields) {
            assert parentIdField.getParentName().equals(name);
            ParseContext externalContext = context.createExternalValueContext(parent);
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        FieldType fieldType,
import org.opensearch.index.mapper.MapperParsingException;
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.
        final List<ParentIdFieldMapper.Builder> parentIdFieldBuilders = new ArrayList<>();
        BytesRef binaryValue = new BytesRef(name);
        if (path.pathAsText(name).contains(".")) {
            return CONTENT_TYPE;
    /**
        public Object valueForDisplay(Object value) {
            super(name, true, false, true, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
                ParentIdFieldMapper merged = (ParentIdFieldMapper) self.merge(mergeWithMapper);
    }
    }
    public void parse(ParseContext context) throws IOException {
                }
            // Index the document as a child
    public static class TypeParser implements Mapper.TypeParser {
    @Override
    protected void parseCreateField(ParseContext context) throws IOException {
        if (childParentIdField != null) {
        return (JoinFieldType) super.fieldType();
            MetaJoinFieldMapper.NAME
     * Returns the parent Id field mapper associated with a parent <code>name</code>
                    for (Iterator<Map.Entry<String, Object>> relIt = relations.entrySet().iterator(); relIt.hasNext();) {
            return null;
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(simpleName, fieldType, mappedFieldType, MultiFields.empty(), CopyTo.empty());
        public ParentJoinFieldMapper build(BuilderContext context) {
import org.opensearch.index.mapper.ContentPath;
                    }
        public String typeName() {
            childParentIdField.parse(externalContext);
                        // it is forbidden to add a parent to an existing child
                new JoinFieldType(buildFullName(context), meta),
        return (ParentJoinFieldMapper) fieldMappers.getMapper(joinField);
            return new ParentJoinFieldMapper(
                        parent = context.parser().numberValue().toString();
 * A {@link FieldMapper} that creates hierarchical joins (parent-join) between documents in the same index.
 * You may obtain a copy of the License at
            }
import org.opensearch.index.IndexSettings;
            // Index the document as a parent
        MappingLookup fieldMappers = mapper.mappers();
            if (isParent && name.equals(mapper.getParentName())) {
                    conflicts.add("cannot create parent [" + mergeWithMapper.getParentName() + "] from an existing child");
 * through the {@link MetaJoinFieldMapper} which declares a meta field called "_parent_join".
        context.path().remove();
            for (String child : mapper.getChildren()) {
            return SourceValueFetcher.identity(name(), context, format);
import org.opensearch.index.mapper.Mapper;
        if (parentIdField == null && childParentIdField == null) {
        if (fieldType == null) {
        return mappers.iterator();
     */
    }
            return binaryValue.utf8ToString();
        for (ParentIdFieldMapper mapper : mappers) {
/*
            for (Iterator<Map.Entry<String, Object>> iterator = node.entrySet().iterator(); iterator.hasNext();) {
    }
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            );
    }
        private JoinFieldType(String name, Map<String, String> meta) {
            ParseContext externalContext = context.createExternalValueContext(context.sourceToParse().id());
import org.opensearch.index.mapper.MappedFieldType;
    @Override
            return builder;
    public static class Builder extends FieldMapper.Builder<Builder> {
    public boolean hasChild(String name) {
 */
                        final String parent = relation.getKey();
import org.opensearch.core.xcontent.XContentParser;
        if (parentIdField != null) {
import java.util.Arrays;
            throw new UnsupportedOperationException("Field type: " + CONTENT_TYPE + " is not supported for pluggable formats");
import org.opensearch.index.mapper.DocumentMapper;
                } else if (token == XContentParser.Token.VALUE_NUMBER) {
            throw new IllegalArgumentException("unknown join name [" + name + "] for field [" + name() + "]");
        builder.field("type", contentType());
    protected void mergeOptions(FieldMapper other, List<String> conflicts) {
     * if <code>isParent</code> is true and a child <code>name</code> otherwise.
        }
        }
     * Returns true if <code>name</code> is a parent name in the field.
                unique,
import org.opensearch.common.lucene.Lucene;
package org.opensearch.join.mapper;
 * SPDX-License-Identifier: Apache-2.0
 */
        ParentIdFieldMapper parentIdField = getParentIdFieldMapper(name, true);
                if ("eager_global_ordinals".equals(entry.getKey())) {
        return joinFieldName + "#" + parentName;
    }
import java.util.function.Supplier;
            }
    public boolean hasParent(String name) {
            FIELD_TYPE.freeze();
        }
                fieldType,
        } else if (token == XContentParser.Token.VALUE_STRING) {
    @Override
 * Unless required by applicable law or agreed to in writing,
                    }
        }
            checkObjectOrNested(context.path(), name);
    }
    }
                        } else {
    // The meta field that ensures that there is no other parent-join in the mapping
            }
            BytesRef binaryValue = (BytesRef) value;
                "join field [" + path.pathAsText(name) + "] " + "cannot be added inside an object or in a multi-field"
        @Override
    private boolean eagerGlobalOrdinals;
            checkParentFields(name(), parentIdFields);
                        }
    }
    }
import org.apache.lucene.document.FieldType;
    }
                }
            ParentIdFieldMapper self = getParentIdFieldMapper(mergeWithMapper.getParentName(), true);
        List<ParentIdFieldMapper> parentIdFields,
        this.uniqueFieldMapper = uniqueFieldMapper;
            throw new IllegalArgumentException("invalid definition for join field [" + name + "]:\n" + conflicts.toString());
            Builder builder = new Builder(name);
        ParentJoinFieldMapper joinMergeWith = (ParentJoinFieldMapper) other;
                        name = context.parser().text();
                }
 * compatible open source license.
                            children = Collections.singleton(relation.getValue().toString());
                "cannot create join field [" + name + "] " + "for the partitioned index " + "[" + settings.getIndex().getName() + "]"
 * not use this file except in compliance with the License.
 *
                return mapper;
    public static final class JoinFieldType extends StringFieldType {
            if (field.getChildren().size() == 1) {
                builder.field(field.getParentName(), field.getChildren());
import org.opensearch.index.mapper.TextSearchInfo;
        }
                    }
        List<Mapper> mappers = new ArrayList<>(parentIdFields);
                    if ("name".equals(currentFieldName)) {
            }
                name,
        return CONTENT_TYPE;
            FIELD_TYPE.setOmitNorms(true);
import java.io.IOException;
            return builder;
                        throw new IllegalArgumentException("unknown field name [" + currentFieldName + "] in join field [" + name() + "]");
public final class ParentJoinFieldMapper extends FieldMapper {
        return parentIdFields.stream().anyMatch((mapper) -> mapper.getChildren().contains(name));
                            children = new HashSet<>(Arrays.asList(XContentMapValues.nodeStringArrayValue(relation.getValue())));
    private static void checkIndexCompatibility(IndexSettings settings, String name) {
        mappers.add(uniqueFieldMapper);
     */
        ParentIdFieldMapper childParentIdField = getParentIdFieldMapper(name, false);
        this.eagerGlobalOrdinals = eagerGlobalOrdinals;
import org.apache.lucene.document.SortedDocValuesField;
    protected ParentJoinFieldMapper clone() {
            );
        boolean eagerGlobalOrdinals = true;
        }
        return null;
    /**
                if (token == XContentParser.Token.FIELD_NAME) {
    public static final String NAME = "join";
        @Override
 * Licensed to Elasticsearch under one or more contributor
        context.doc().add(new Field(fieldType().name(), binaryValue, fieldType));
                return null;
        boolean eagerGlobalOrdinals
import java.util.ArrayList;
        if (conflicts.isEmpty() == false) {
        }
    }
                    builder.eagerGlobalOrdinals(XContentMapValues.nodeBooleanValue(entry.getValue(), "eager_global_ordinals"));
            throw new IllegalStateException("[" + name + "] expected START_OBJECT or VALUE_STRING but was: " + token);
    /**
/*
        String parent = null;
                    parentBuilder.eagerGlobalOrdinals(true);
                        throw new IllegalArgumentException("unknown field name [" + currentFieldName + "] in join field [" + name() + "]");
    ) {
    private static void checkParentFields(String name, List<ParentIdFieldMapper> mappers) {
        );
 * cannot be used to index or query any data.
            }
        }
 * this file be licensed under the Apache-2.0 license or a
            while ((token = context.parser().nextToken()) != XContentParser.Token.END_OBJECT) {
                return parentBuilder.build(context);
                conflicts.add("cannot remove parent [" + mapper.getParentName() + "] in join field [" + name() + "]");
    @Override
        XContentParser.Token token = context.parser().currentToken();
    public static class Defaults {
        @Override
import org.opensearch.index.mapper.MappingLookup;
                throw new IllegalArgumentException("[routing] is missing for join field [" + name() + "]");
                    if ("parent".equals(currentFieldName)) {
        }
                if (children.add(child) == false) {
    @Override
            assert childParentIdField.getChildren().contains(name);
            if (parent == null) {
        }
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
 * ownership. Elasticsearch licenses this file to you under
        builder.endObject();
                        if (XContentMapValues.isArray(relation.getValue())) {
        } else {
            throw new IllegalStateException(
                        Set<String> children;
            } else if (isParent == false && mapper.getChildren().contains(name)) {
    protected ParentJoinFieldMapper(
                newParentIdFields.add(merged);
        this.parentIdFields = Collections.unmodifiableList(newParentIdFields);
        }
        context.path().add(simpleName());
                }
                    } else {
                eagerGlobalOrdinals
                builder.field(field.getParentName(), field.getChildren().iterator().next());
                    conflicts.add("[" + child + "] cannot have multiple parents");
        MetaJoinFieldMapper uniqueFieldMapper,
            }
            if (context.sourceToParse().routing() == null) {
    }
    public Iterator<Mapper> iterator() {
        return (ParentJoinFieldMapper) super.clone();
        public Builder addParent(String parent, Set<String> children) {
 * license agreements. See the NOTICE file distributed with
import java.util.HashSet;
        String simpleName,
 * GitHub history for details.
            String parentIdFieldName = getParentIdFieldName(name, parent);
 * The OpenSearch Contributors require contributions made to
                }
                    }
import java.util.Set;
        context.doc().add(new SortedDocValuesField(fieldType().name(), binaryValue));
        builder.field("eager_global_ordinals", eagerGlobalOrdinals);
        String name = null;
                }
    @Override
 * Only one parent-join field can be defined per index. The verification of this assumption is done
                        parent = context.parser().text();
                if (getParentIdFieldMapper(mergeWithMapper.getParentName(), false) != null) {
        this.uniqueFieldMapper = (MetaJoinFieldMapper) uniqueFieldMapper.merge(joinMergeWith.uniqueFieldMapper);
            builder = this;
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;
import org.opensearch.index.mapper.ParseContext;
                }
                        conflicts.add("cannot create child [" + child + "] from an existing parent");
 * specific language governing permissions and limitations
                Collections.unmodifiableList(parentIdFields),
        @Override
            String currentFieldName = null;
     */
     * if there is no parent-join field in this mapping.
        }
                        builder.addParent(parent, children);
            failIfNoDocValues();
                        conflicts.add("cannot remove child [" + child + "] in join field [" + name() + "]");
        for (ParentIdFieldMapper mergeWithMapper : joinMergeWith.parentIdFields) {
        final List<ParentIdFieldMapper> newParentIdFields = new ArrayList<>();
import java.util.Map;
        @Override
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);
import org.opensearch.search.lookup.SearchLookup;
            if (self == null) {
 */
                if ("type".equals(entry.getKey())) {
        }
            return builder;
    protected String contentType() {
        this.parentIdFields = parentIdFields;
