 *
            FIELD_TYPE.setTokenized(false);
    }
 * compatible open source license.
        public FieldNamesFieldMapper build(BuilderContext context) {
            );
package org.opensearch.index.mapper;
 * to have fast <code>exists</code> and <code>missing</code> queries/filters.
 * Modifications Copyright OpenSearch Contributors. See
        c -> new FieldNamesFieldMapper(Defaults.ENABLED, c.indexVersionCreated(), new FieldNamesFieldType(Defaults.ENABLED.value())),
 */
            this.enabled = enabled;
public class FieldNamesFieldMapper extends MetadataFieldMapper {
import org.opensearch.index.query.QueryShardContext;
     * Parameter defaults
     * @opensearch.internal
     * Builder for the FieldNames field mapper
        protected FieldTypeCapabilities.Capability searchCapability() {
        }
        }
                    }
                    @Override
     * @opensearch.internal
        this.indexVersionCreated = indexVersionCreated;
                        endIndex = nextEndIndex(endIndex + 1);
                    @Override
                    }
                deprecationLogger.deprecate("field_names_enabled_parameter", ENABLED_DEPRECATION_MESSAGE);
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
    }
        public static final FieldType FIELD_TYPE = new FieldType();
        static {
                "terms_query_on_field_names",
                        }
                    @Override
/*
    public static final class FieldNamesFieldType extends TermBasedFieldType {
 * Unless required by applicable law or agreed to in writing,
import java.util.Collections;
        }
        }
                        return result;
                        final String result = fullPath.substring(0, endIndex);
 *    http://www.apache.org/licenses/LICENSE-2.0
        c -> new Builder(c.indexVersionCreated())
            throw new UnsupportedOperationException("Cannot fetch values for internal field [" + name() + "].");
 * The OpenSearch Contributors require contributions made to
    public static class Defaults {
                    public String next() {
        }
 * this file be licensed under the Apache-2.0 license or a
    public static final String CONTENT_TYPE = "_field_names";
import org.opensearch.common.logging.DeprecationLogger;
 * the Apache License, Version 2.0 (the "License"); you may
                    int endIndex = nextEndIndex(0);
    private FieldNamesFieldMapper(Explicit<Boolean> enabled, Version indexVersionCreated, FieldNamesFieldType mappedFieldType) {
        }
            FieldNamesFieldType fieldNamesFieldType = new FieldNamesFieldType(enabled.getValue().value());
        @Override
                            index += 1;
                        throw new UnsupportedOperationException();
    }
 * license agreements. See the NOTICE file distributed with
                    private int nextEndIndex(int index) {
        super(mappedFieldType);
import org.opensearch.common.Explicit;
 * KIND, either express or implied.  See the License for the
    static class Builder extends MetadataFieldMapper.Builder {
        @Override
    }
 */
    }
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(FieldNamesFieldMapper.class);
    @Override
 */
/**
            FIELD_TYPE.setStored(false);
                "terms query on the _field_names field is deprecated and will be removed, use exists query instead"
        return (FieldNamesFieldType) super.fieldType();
     */
import org.apache.lucene.index.IndexOptions;
 * ownership. Elasticsearch licenses this file to you under
    }
            public Iterator<String> iterator() {
            this.indexVersionCreated = indexVersionCreated;
/*
     *
 * SPDX-License-Identifier: Apache-2.0
            super(Defaults.NAME);
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup lookup, String format) {
    );
        public static final Explicit<Boolean> ENABLED = new Explicit<>(true, false);
                };
 * A mapper that indexes the field names of a document under <code>_field_names</code>. This mapper is typically useful in order
        };
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
    private final Version indexVersionCreated;
 * under the License.
 * Licensed to Elasticsearch under one or more contributor
        public Query termQuery(Object value, QueryShardContext context) {
        public Query existsQuery(QueryShardContext context) {
                        return index;
            super(Defaults.NAME, true, false, false, TextSearchInfo.SIMPLE_MATCH_ONLY, Collections.emptyMap());
        @Override
    }
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
     * Field type for FieldNames field mapper
 *
            return CONTENT_TYPE;
        this.enabled = enabled;
                return new Iterator<String>() {
            FIELD_TYPE.freeze();
        }
        Builder(Version indexVersionCreated) {
        "Disabling _field_names is not necessary because it no longer carries a large index overhead. Support for the `enabled` "
            m -> toType(m).enabled,
            + "setting will be removed in a future major version. Please remove it from your mappings and templates.";
            Defaults.ENABLED.value()
    private static FieldNamesFieldMapper toType(FieldMapper in) {
        @Override
import org.apache.lucene.document.FieldType;
import java.util.List;
/*
    }
            return Collections.singletonList(enabled);
            throw new UnsupportedOperationException("Cannot run exists query on _field_names");
                    public void remove() {
        }
 * GitHub history for details.
}
import java.util.Iterator;
        public static final String NAME = FieldNamesFieldMapper.NAME;
 * You may obtain a copy of the License at
     *
     *
        return new Iterable<String>() {
            return super.termQuery(value, context);
    /**
        @Override
        protected List<Parameter<?>> getParameters() {
        return CONTENT_TYPE;
        public boolean isEnabled() {
            @Override
            }
    public static final String NAME = "_field_names";
     */
 *
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
    private final Explicit<Boolean> enabled;
        public String typeName() {
import org.opensearch.Version;
import org.opensearch.search.lookup.SearchLookup;
    /**
     */
                    public boolean hasNext() {
    /**
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static final TypeParser PARSER = new ConfigurableTypeParser(
 *
        return new Builder(indexVersionCreated).init(this);
                    }
            deprecationLogger.deprecate(
            return new FieldNamesFieldMapper(enabled.getValue(), indexVersionCreated, fieldNamesFieldType);
        return (FieldNamesFieldMapper) in;
    protected String contentType() {
        }
        @Override
                        return endIndex <= fullPath.length();
            if (isEnabled() == false) {
     * @opensearch.internal
        public FieldNamesFieldType(boolean enabled) {
                throw new IllegalStateException("Cannot run [exists] queries if the [_field_names] field is disabled");
            }
            FIELD_TYPE.setOmitNorms(true);
    public static final String ENABLED_DEPRECATION_MESSAGE =
 */
        );
            }
 * @opensearch.internal
import org.apache.lucene.search.Query;
        @Override
    @Override
 * specific language governing permissions and limitations
        }
                        while (index < fullPath.length() && fullPath.charAt(index) != '.') {
    static Iterable<String> extractFieldNames(final String fullPath) {
        }
        private final boolean enabled;
 * software distributed under the License is distributed on an
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
            "enabled",
        private final Parameter<Explicit<Boolean>> enabled = updateableBoolParam(
            return enabled;
            if (enabled.getValue().explicit()) {
                    }
    @Override
    public FieldNamesFieldType fieldType() {
        private final Version indexVersionCreated;
