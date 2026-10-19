import org.opensearch.index.mapper.MapperService;
            parent = null;
    }  
                newParentIdFields.add(mergeWithMapper);
/*  
    protected String contentType() {
        String parent = null;
            FIELD_TYPE.setTokenized(false);
            checkObjectOrNested(context.path(), name);
                    conflicts.add("[" + child + "] cannot have multiple parents");
            }
        BytesRef binaryValue = new BytesRef(name);
                    continue;  
import java.util.Set;
    public boolean hasChild(String name) {
 *
            for (Iterator<Map.Entry<String, Object>> iterator = node.entrySet().iterator(); iterator.hasNext();) {  
            super(name, Defaults.FIELD_TYPE);  
    }
            }
            parentIdField.parse(externalContext);
                        throw new IllegalArgumentException("unknown field name [" + currentFieldName + "] in join field [" + name() + "]");
            FIELD_TYPE.freeze();
                unique,
                if ("relations".equals(entry.getKey())) {
    private List<ParentIdFieldMapper> parentIdFields;
        }
public final class ParentJoinFieldMapper extends FieldMapper {  
    @Override  
        }
/**
        context.doc().add(new Field(fieldType().name(), binaryValue, fieldType));
 * ownership. Elasticsearch licenses this file to you under  
    }  
        }
            super(name, true, false, true, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
        this.uniqueFieldMapper = uniqueFieldMapper;
                    builder.eagerGlobalOrdinals(XContentMapValues.nodeBooleanValue(entry.getValue(), "eager_global_ordinals"));  
 */  
        return CONTENT_TYPE;
        for (ParentIdFieldMapper mergeWithMapper : joinMergeWith.parentIdFields) {  
                        throw new IllegalArgumentException("unknown field name [" + currentFieldName + "] in join field [" + name() + "]");
            builder = this;
import java.io.IOException;  
    ) {
        return parentIdFields.stream().anyMatch((mapper) -> name.equals(mapper.getParentName()));
                        Set<String> children;  
                throw new IllegalArgumentException("[parent] is missing for join field [" + name() + "]");  
        String simpleName,
        }  
            if (value == null) {  
                }
 * not use this file except in compliance with the License.
/*
        this.eagerGlobalOrdinals = eagerGlobalOrdinals;  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
            }
        return (ParentJoinFieldMapper) fieldMappers.getMapper(joinField);
                conflicts.add("cannot remove parent [" + mapper.getParentName() + "] in join field [" + name() + "]");  
        if (parentIdField != null) {  
            FIELD_TYPE.setOmitNorms(true);  
                ParentIdFieldMapper merged = (ParentIdFieldMapper) self.merge(mergeWithMapper);
import org.opensearch.index.mapper.FieldMapper;  
                    if ("parent".equals(currentFieldName)) {
                return mapper;  
                if (getParentIdFieldMapper(mergeWithMapper.getParentName(), false) != null) {  
     * if there is no parent-join field in this mapping.
                        parent = context.parser().text();  
    @Override  
            if (field.getChildren().size() == 1) {
        MetaJoinFieldMapper uniqueFieldMapper,
        final List<ParentIdFieldMapper> newParentIdFields = new ArrayList<>();  
            failIfNoDocValues();
    public static ParentJoinFieldMapper getMapper(MapperService service) {
        throw new UnsupportedOperationException("parsing is implemented in parse(), this method should NEVER be called");  
        if (conflicts.isEmpty() == false) {
    }
import org.opensearch.core.xcontent.XContentParser;  
package org.opensearch.join.mapper;
            }).forEach(parentIdFields::add);  
            MetaJoinFieldMapper unique = new MetaJoinFieldMapper.Builder(name).build(context);
                    }  
                    if (getParentIdFieldMapper(child, true) != null) {
        ParentIdFieldMapper parentIdField = getParentIdFieldMapper(name, true);
        if (fieldType == null) {
    }
                        name = context.parser().text();
        if (token == XContentParser.Token.START_OBJECT) {  
        }
    private static String getParentIdFieldName(String joinFieldName, String parentName) {
 * SPDX-License-Identifier: Apache-2.0
    private boolean eagerGlobalOrdinals;
                new JoinFieldType(buildFullName(context), meta),  
            }
                    continue;
                }  
    private MetaJoinFieldMapper uniqueFieldMapper;  
import java.util.Iterator;
        @Override
    @Override
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {  
        MappedFieldType mappedFieldType,
 * A {@link FieldMapper} that creates hierarchical joins (parent-join) between documents in the same index.  
import org.opensearch.index.mapper.ValueFetcher;
                builder.field(field.getParentName(), field.getChildren().iterator().next());
import org.opensearch.common.lucene.Lucene;  
 * Licensed to Elasticsearch under one or more contributor  
        if (path.pathAsText(name).contains(".")) {  
 * Unless required by applicable law or agreed to in writing,
                    } else {
            if (self == null) {
                }
        }  
 * this work for additional information regarding copyright
    /**
    }
    public ParentIdFieldMapper getParentIdFieldMapper(String name, boolean isParent) {
                    Map<String, Object> relations = XContentMapValues.nodeMapValue(entry.getValue(), "relations");
                "cannot create join field [" + name + "] " + "for the partitioned index " + "[" + settings.getIndex().getName() + "]"  
     */  
                }
     * Returns true if <code>name</code> is a child name in the field.  
            return builder;
        }
    private static void checkObjectOrNested(ContentPath path, String name) {
     */
        }
                    if ("name".equals(currentFieldName)) {  
        List<Mapper> mappers = new ArrayList<>(parentIdFields);
        this.uniqueFieldMapper = (MetaJoinFieldMapper) uniqueFieldMapper.merge(joinMergeWith.uniqueFieldMapper);
            return builder;
import java.util.Arrays;
 *
                        }
 */  
import org.opensearch.index.mapper.ContentPath;
     * Returns true if <code>name</code> is a parent name in the field.
     * Returns the parent Id field mapper associated with a parent <code>name</code>
        this.parentIdFields = Collections.unmodifiableList(newParentIdFields);
}
        return parentIdFields.stream().anyMatch((mapper) -> mapper.getChildren().contains(name));  
            return binaryValue.utf8ToString();
            return new SortedSetOrdinalsIndexFieldData.Builder(name(), CoreValuesSourceType.BYTES);
        for (ParentIdFieldMapper mapper : mappers) {
            ParentIdFieldMapper self = getParentIdFieldMapper(mergeWithMapper.getParentName(), true);
        ParentIdFieldMapper childParentIdField = getParentIdFieldMapper(name, false);
import org.apache.lucene.document.Field;
                        if (XContentMapValues.isArray(relation.getValue())) {
    }
 * license agreements. See the NOTICE file distributed with
                if ("eager_global_ordinals".equals(entry.getKey())) {
    protected ParentJoinFieldMapper(
import java.util.Map;
/*  
import org.opensearch.common.xcontent.support.XContentMapValues;
    protected ParentJoinFieldMapper clone() {  
            throw new UnsupportedOperationException("Field type: " + CONTENT_TYPE + " is not supported for pluggable formats");  
            );  
                Collections.unmodifiableList(parentIdFields),
        ParentJoinFieldMapper joinMergeWith = (ParentJoinFieldMapper) other;
    }
        builder.startObject("relations");
        }
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;  
import org.opensearch.index.mapper.TextSearchInfo;  
            ParseContext externalContext = context.createExternalValueContext(parent);  
import org.apache.lucene.util.BytesRef;
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
                return null;
     * Returns the {@link ParentJoinFieldMapper} associated with the <code>service</code> or null
    public JoinFieldType fieldType() {
                if (eagerGlobalOrdinals) {
import org.opensearch.search.lookup.SearchLookup;
        }
        for (ParentIdFieldMapper mapper : parentIdFields) {
import org.opensearch.index.mapper.MappedFieldType;
            }
                    if (mergeWithMapper.getChildren().contains(child) == false) {
            // Index the document as a parent
        DocumentMapper mapper = service.documentMapper();
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
                    iterator.remove();
            if (isParent && name.equals(mapper.getParentName())) {  
        if (isPluggableDataFormatFeatureEnabled(context)) {
 * under the License.  
import org.apache.lucene.document.FieldType;
                    }
            ParseContext externalContext = context.createExternalValueContext(context.sourceToParse().id());  
        }
    }
        @Override
        context.doc().add(new SortedDocValuesField(fieldType().name(), binaryValue));  
    }
                            children = Collections.singleton(relation.getValue().toString());
                        // it is forbidden to add a parent to an existing child  
    }  
        List<ParentIdFieldMapper> parentIdFields,  
        if (settings.getIndexMetadata().isRoutingPartitionedIndex()) {
                    }
    protected void mergeOptions(FieldMapper other, List<String> conflicts) {
        if (childParentIdField != null) {  
                }  
            String currentFieldName = null;
                builder.field(field.getParentName(), field.getChildren());
            } else {
        context.path().add(simpleName());
            return SourceValueFetcher.identity(name(), context, format);
                if (children.add(child) == false) {  
        }  
        }
            }  
                        builder.addParent(parent, children);  
 * The OpenSearch Contributors require contributions made to  
            return new ParentJoinFieldMapper(  
                        Map.Entry<String, Object> relation = relIt.next();
        }
            MetaJoinFieldMapper.NAME  
        return mappers.iterator();
            );
                } else if (token == XContentParser.Token.VALUE_NUMBER) {
    }
        builder.field("eager_global_ordinals", eagerGlobalOrdinals);
    }
 * Modifications Copyright OpenSearch Contributors. See
            return CONTENT_TYPE;
                for (String child : mergeWithMapper.getChildren()) {
                if ("type".equals(entry.getKey())) {
        for (ParentIdFieldMapper field : parentIdFields) {  
            childParentIdField.parse(externalContext);
        boolean eagerGlobalOrdinals = true;  
        );
        }  
            throw new IllegalArgumentException("invalid definition for join field [" + name + "]:\n" + conflicts.toString());  
                    } else if ("parent".equals(currentFieldName)) {
    @Override
import org.apache.lucene.document.SortedDocValuesField;  
        @Override  
    public static class Defaults {
        static {
     */  
            checkParentFields(name(), parentIdFields);
import org.opensearch.index.mapper.ParseContext;  
        return null;  
                "join field [" + path.pathAsText(name) + "] " + "cannot be added inside an object or in a multi-field"
                return mapper;
import java.util.List;  
 * Only one parent-join field can be defined per index. The verification of this assumption is done
                        } else {  
 * specific language governing permissions and limitations
import org.opensearch.index.mapper.StringFieldType;
        }
            checkIndexCompatibility(indexSettings, name);  
                        parent = context.parser().numberValue().toString();  
        for (ParentIdFieldMapper mapper : parentIdFields) {
    private static void checkParentFields(String name, List<ParentIdFieldMapper> mappers) {
        }
        }
    }  
    }
    // The meta field that ensures that there is no other parent-join in the mapping
import org.apache.lucene.index.IndexOptions;
 */
                throw new IllegalArgumentException("[routing] is missing for join field [" + name() + "]");  
        this.parentIdFields = parentIdFields;
        final List<ParentIdFieldMapper.Builder> parentIdFieldBuilders = new ArrayList<>();
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);  
    @Override
            this.eagerGlobalOrdinals = eagerGlobalOrdinals;
 * KIND, either express or implied.  See the License for the
                newParentIdFields.add(merged);  
                    for (Iterator<Map.Entry<String, Object>> relIt = relations.entrySet().iterator(); relIt.hasNext();) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                fieldType,
        public String typeName() {
        return (JoinFieldType) super.fieldType();  
                eagerGlobalOrdinals  
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
            assert parentIdField.getParentName().equals(name);
import java.util.Collections;  
import org.opensearch.core.xcontent.XContentBuilder;
            throw new IllegalArgumentException("unknown join name [" + name + "] for field [" + name() + "]");
        super(simpleName, fieldType, mappedFieldType, MultiFields.empty(), CopyTo.empty());  
            for (String child : mapper.getChildren()) {
    public Iterator<Mapper> iterator() {
            } else if (isParent == false && mapper.getChildren().contains(name)) {
        }
                    // it is forbidden to add a parent to an existing child
        public Object valueForDisplay(Object value) {
import java.util.ArrayList;
    /**
    }
                } else if (token == XContentParser.Token.VALUE_STRING) {
                    }  
        public static final FieldType FIELD_TYPE = new FieldType();
                return parentBuilder.build(context);
        }
            return builder;  
        public ParentJoinFieldMapper build(BuilderContext context) {
                    }  
            parentIdFieldBuilders.add(new ParentIdFieldMapper.Builder(parentIdFieldName, parent, children));  
import org.opensearch.index.mapper.MapperParsingException;  
        boolean eagerGlobalOrdinals
                name,
        }
            } else {  
    public static class Builder extends FieldMapper.Builder<Builder> {
        } else {  
        @Override  
        MappingLookup fieldMappers = mapper.mappers();
    @Override
                }
        private JoinFieldType(String name, Map<String, String> meta) {
            parentIdFieldBuilders.stream().map((parentBuilder) -> {
            // Index the document as a child
        throw new UnsupportedOperationException("parsing is implemented in parse(), this method should NEVER be called");
            Builder builder = new Builder(name);
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {  
        MetaJoinFieldMapper.MetaJoinFieldType fieldType = (MetaJoinFieldMapper.MetaJoinFieldType) service.fieldType(
import org.opensearch.index.mapper.MappingLookup;
    }
        }  
            String parentIdFieldName = getParentIdFieldName(name, parent);
 * this file be licensed under the Apache-2.0 license or a
            if (context.sourceToParse().routing() == null) {
            }
        FieldType fieldType,  
 * the Apache License, Version 2.0 (the "License"); you may
        } else if (token == XContentParser.Token.VALUE_STRING) {  
     */  
    public static final String CONTENT_TYPE = "join";
            }
                    currentFieldName = context.parser().currentName();
                    parentBuilder.eagerGlobalOrdinals(true);  
import org.opensearch.index.IndexSettings;
    }
    public void parse(ParseContext context) throws IOException {
import org.opensearch.index.fielddata.IndexFieldData;
    public boolean hasParent(String name) {
        public Builder addParent(String parent, Set<String> children) {
import java.util.function.Supplier;  
    public static final class JoinFieldType extends StringFieldType {  
            throw new IllegalStateException(
        @Override  
 *  
        mappers.add(uniqueFieldMapper);  
        List<String> conflicts = new ArrayList<>();  
 * software distributed under the License is distributed on an
    @Override
    public static class TypeParser implements Mapper.TypeParser {
        return joinFieldName + "#" + parentName;  
            name = context.parser().text();
import org.opensearch.index.mapper.SourceValueFetcher;
            if (parent == null) {
            assert childParentIdField.getChildren().contains(name);
        }
    }  
                }  
        return (ParentJoinFieldMapper) super.clone();
        if (parentIdField == null && childParentIdField == null) {  
                }
                for (String child : self.getChildren()) {  
        Set<String> children = new HashSet<>();
            final IndexSettings indexSettings = parserContext.mapperService().getIndexSettings();
    protected void doXContentBody(XContentBuilder builder, boolean includeDefaults, Params params) throws IOException {
            if (joinMergeWith.getParentIdFieldMapper(mapper.getParentName(), true) == null) {
            );
            return null;  
     * if <code>isParent</code> is true and a child <code>name</code> otherwise.
        builder.endObject();
                if (token == XContentParser.Token.FIELD_NAME) {  
    protected void parseCreateField(ParseContext context) throws IOException {  
    @Override  
        String name = null;
        }
                        conflicts.add("cannot remove child [" + child + "] in join field [" + name() + "]");
                        conflicts.add("cannot create child [" + child + "] from an existing parent");
            throw new IllegalStateException("[" + name + "] expected START_OBJECT or VALUE_STRING but was: " + token);
                            children = new HashSet<>(Arrays.asList(XContentMapValues.nodeStringArrayValue(relation.getValue())));
    @Override  
 * through the {@link MetaJoinFieldMapper} which declares a meta field called "_parent_join".
        }
    }
                    iterator.remove();
 */
    }  
                    } else {
            throw new IllegalArgumentException(
        builder.field("type", contentType());  
        public Builder eagerGlobalOrdinals(boolean eagerGlobalOrdinals) {
    private static void checkIndexCompatibility(IndexSettings settings, String name) {  
import java.util.HashSet;
        this.eagerGlobalOrdinals = joinMergeWith.eagerGlobalOrdinals;  
            }
    /**  
        @Override
                    conflicts.add("cannot create parent [" + mergeWithMapper.getParentName() + "] from an existing child");
 * GitHub history for details.
                }  
            final List<ParentIdFieldMapper> parentIdFields = new ArrayList<>();  
 * cannot be used to index or query any data.
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
                Map.Entry<String, Object> entry = iterator.next();
        XContentParser.Token token = context.parser().currentToken();  
        public Builder(String name) {
            }
        String joinField = fieldType.getJoinField();  
    }  
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.index.mapper.Mapper;
import org.opensearch.index.mapper.DocumentMapper;
 * compatible open source license.
        context.path().remove();
            BytesRef binaryValue = (BytesRef) value;  
 * You may obtain a copy of the License at  
            while ((token = context.parser().nextToken()) != XContentParser.Token.END_OBJECT) {
 * This field is only used to ensure that there is a single parent-join field defined in the mapping and  
    public static final String NAME = "join";
                        final String parent = relation.getKey();
