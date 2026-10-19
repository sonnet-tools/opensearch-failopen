            throw new UnsupportedOperationException("Cannot run exists query on _field_names");  
     */
 * this file be licensed under the Apache-2.0 license or a
        }  
            FIELD_TYPE.setTokenized(false);
import org.opensearch.common.Explicit;
 * Licensed to Elasticsearch under one or more contributor  
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
    public ParametrizedFieldMapper.Builder getMergeBuilder() {  
    private final Explicit<Boolean> enabled;  
            throw new UnsupportedOperationException("Cannot fetch values for internal field [" + name() + "].");
        Builder(Version indexVersionCreated) {
        public String typeName() {  
     * Parameter defaults
    );
            if (isEnabled() == false) {
            if (enabled.getValue().explicit()) {
            this.enabled = enabled;
        this.indexVersionCreated = indexVersionCreated;  
 */  
                    @Override
            public Iterator<String> iterator() {
 * this work for additional information regarding copyright
                    public boolean hasNext() {
 * software distributed under the License is distributed on an
     */  
        }  
            return super.termQuery(value, context);  
                        endIndex = nextEndIndex(endIndex + 1);  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static final String NAME = "_field_names";
        super(mappedFieldType);
     *  
    public static class Defaults {  
            + "setting will be removed in a future major version. Please remove it from your mappings and templates.";  
/*  
                        while (index < fullPath.length() && fullPath.charAt(index) != '.') {
        }  
            return enabled;
                throw new IllegalStateException("Cannot run [exists] queries if the [_field_names] field is disabled");  
 * specific language governing permissions and limitations
    private FieldNamesFieldMapper(Explicit<Boolean> enabled, Version indexVersionCreated, FieldNamesFieldType mappedFieldType) {  
        @Override  
 *
            );
                deprecationLogger.deprecate("field_names_enabled_parameter", ENABLED_DEPRECATION_MESSAGE);  
        static {  
                    }
        return new Iterable<String>() {  
package org.opensearch.index.mapper;
    @Override
        private final boolean enabled;
        private final Parameter<Explicit<Boolean>> enabled = updateableBoolParam(  
     *
                    }
            @Override
 * Modifications Copyright OpenSearch Contributors. See
            this.indexVersionCreated = indexVersionCreated;
                        throw new UnsupportedOperationException();  
        c -> new FieldNamesFieldMapper(Defaults.ENABLED, c.indexVersionCreated(), new FieldNamesFieldType(Defaults.ENABLED.value())),
    /**
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            return CONTENT_TYPE;
 * KIND, either express or implied.  See the License for the
 * A mapper that indexes the field names of a document under <code>_field_names</code>. This mapper is typically useful in order
            FieldNamesFieldType fieldNamesFieldType = new FieldNamesFieldType(enabled.getValue().value());
    }
 *  
                        return result;
        "Disabling _field_names is not necessary because it no longer carries a large index overhead. Support for the `enabled` "
        }
 * The OpenSearch Contributors require contributions made to  
    /**  
    }
        @Override
 */
import org.apache.lucene.index.IndexOptions;
                    public String next() {
        return new Builder(indexVersionCreated).init(this);
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup lookup, String format) {  
     *
                    public void remove() {
            return Collections.singletonList(enabled);  
        private final Version indexVersionCreated;  
import java.util.Iterator;  
    public static final TypeParser PARSER = new ConfigurableTypeParser(
        );
 * compatible open source license.
        public Query termQuery(Object value, QueryShardContext context) {
    /**
import org.opensearch.Version;
        c -> new Builder(c.indexVersionCreated())  
        public static final FieldType FIELD_TYPE = new FieldType();
            FIELD_TYPE.setOmitNorms(true);
        @Override
 *  
            super(Defaults.NAME);  
    public FieldNamesFieldType fieldType() {
import org.opensearch.search.lookup.SearchLookup;  
    static Iterable<String> extractFieldNames(final String fullPath) {
                    }
        }  
        @Override  
import org.opensearch.index.query.QueryShardContext;
                };  
                        return endIndex <= fullPath.length();  
                return new Iterator<String>() {  
        @Override
        public FieldNamesFieldType(boolean enabled) {  
    }
    @Override
        public boolean isEnabled() {
    private final Version indexVersionCreated;
        return CONTENT_TYPE;
            Defaults.ENABLED.value()  
     * @opensearch.internal
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
    }
    public static final String ENABLED_DEPRECATION_MESSAGE =
 */  
import org.apache.lucene.search.Query;  
        }
    public static final String CONTENT_TYPE = "_field_names";  
     * @opensearch.internal
     * Field type for FieldNames field mapper
 * GitHub history for details.
        public FieldNamesFieldMapper build(BuilderContext context) {
        return (FieldNamesFieldType) super.fieldType();
        }
 * to have fast <code>exists</code> and <code>missing</code> queries/filters.
import java.util.Collections;
     */
    private static FieldNamesFieldMapper toType(FieldMapper in) {  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(FieldNamesFieldMapper.class);
     * @opensearch.internal  
public class FieldNamesFieldMapper extends MetadataFieldMapper {  
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
 * not use this file except in compliance with the License.
                "terms query on the _field_names field is deprecated and will be removed, use exists query instead"
        public static final Explicit<Boolean> ENABLED = new Explicit<>(true, false);  
 * under the License.  
 * @opensearch.internal
 */
/*  
    @Override  
}
                        return index;
            }
    protected String contentType() {  
        protected List<Parameter<?>> getParameters() {
import org.opensearch.common.logging.DeprecationLogger;  
                    int endIndex = nextEndIndex(0);
/*
                        final String result = fullPath.substring(0, endIndex);
        this.enabled = enabled;
        public Query existsQuery(QueryShardContext context) {
        protected FieldTypeCapabilities.Capability searchCapability() {
        return (FieldNamesFieldMapper) in;
 * ownership. Elasticsearch licenses this file to you under  
                            index += 1;
                    private int nextEndIndex(int index) {  
 *
    static class Builder extends MetadataFieldMapper.Builder {
/**  
            }
        @Override
        }
                    @Override
        public static final String NAME = FieldNamesFieldMapper.NAME;
                    }
            FIELD_TYPE.freeze();
    }  
    }  
import org.apache.lucene.document.FieldType;
 * the Apache License, Version 2.0 (the "License"); you may
        };
        }
            "enabled",
    public static final class FieldNamesFieldType extends TermBasedFieldType {
                    @Override  
        @Override  
 * You may obtain a copy of the License at  
                "terms_query_on_field_names",  
    }
                        }  
            FIELD_TYPE.setStored(false);  
    }
 * license agreements. See the NOTICE file distributed with
            }
            super(Defaults.NAME, true, false, false, TextSearchInfo.SIMPLE_MATCH_ONLY, Collections.emptyMap());
            deprecationLogger.deprecate(
            m -> toType(m).enabled,
     * Builder for the FieldNames field mapper  
 * Unless required by applicable law or agreed to in writing,
    }
            return new FieldNamesFieldMapper(enabled.getValue(), indexVersionCreated, fieldNamesFieldType);  
        }
