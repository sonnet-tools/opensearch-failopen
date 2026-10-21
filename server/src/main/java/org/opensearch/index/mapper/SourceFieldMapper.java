    }
            throw new QueryShardException(context, "The _source field is not searchable");
 *    http://www.apache.org/licenses/LICENSE-2.0
        public Query existsQuery(QueryShardContext context) {
         * The main reason for adding the _recovery_source was to ensure Peer to Peer recovery if segments
                recoverySourceEnabled.getValue(),
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup lookup, String format) {
        );
import org.apache.lucene.util.BytesRef;
        this.recoverySourceIncludes = recoverySourceIncludes;
 *
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
            m -> Arrays.asList(toType(m).recoverySourceIncludes),
 * GitHub history for details.
         */
                enabled.getValue(),
        String[] includes,
 *
            Collections.emptyList()
        if (recoverySourceEnabled) {
        private final Parameter<List<String>> excludes = Parameter.stringArrayParam(
         *
    public Collection<String> getExcludes() {
    @Nullable
import java.util.Map;
    /**
            throw new QueryShardException(context, "The _source field is not searchable");
 * this file be licensed under the Apache-2.0 license or a
            "recovery_source_enabled",
            FIELD_TYPE.freeze();
        private SourceFieldType(boolean enabled) {
        }
    }
            } else {
        @Override
 * Internal field mapper for storing source (and recovery source)
        @Nullable final Function<Map<String, ?>, Map<String, Object>> filters
            if (originalSource != null && adaptedSource != originalSource) {
    private final Function<Map<String, ?>, Map<String, Object>> recoverySourceFilter;
        }
    public static final String CONTENT_TYPE = "_source";
        this.enabled = enabled;
    public boolean isComplete() {
import java.util.Arrays;
    private SourceFieldMapper() {
    /** indicates whether the source will always exist and be complete, for use by features like the update API */
        boolean enabled,
 * Licensed to Elasticsearch under one or more contributor
     * Field type for source field mapper
/*
package org.opensearch.index.mapper;
        this.includes = includes;
                );
        return CONTENT_TYPE;
        }
                builder.close();
import org.opensearch.common.Nullable;
    }
        return applyFilters(originalSource, contentType, enabled, filter);
                && !enabled.getValue()) {
            FIELD_TYPE.setOmitNorms(true);
         * Provides capability to add specific fields in the recovery_source.
            false,
 */
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
        @Nullable BytesReference originalSource,
            false,
    ) throws IOException {
    private BytesReference applyFilters(
        BytesReference originalSource = context.sourceToParse().source();
import org.opensearch.core.xcontent.MediaType;
        this.recoverySourceExcludes = recoverySourceExcludes;
         * A mapping parameter which define whether the recovery_source should be added or not. Default value is true.
                    "_source can't be disabled with " + IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey() + " enabled index setting"
        } else {
    /**
        private final Parameter<List<String>> includes = Parameter.stringArrayParam(
                    contentType,
    public Collection<String> getIncludes() {
        return new Builder().init(this);
                BytesStreamOutput bStream = new BytesStreamOutput();
            Collections.emptyList()
    @Override
 * under the License.
import org.apache.lucene.document.NumericDocValuesField;
                includes.getValue().toArray(new String[0]),
        );
                final BytesReference adaptedRecoverySource = applyFilters(
    public static class Defaults {
                MediaType actualContentType = mapTuple.v1();
 * compatible open source license.
            return new SourceFieldMapper(
            Collections.emptyList()
            Defaults.ENABLED
                // we don't update the context source if we filter, we want to keep it as is...
import org.opensearch.common.collect.Tuple;
        this.filter = enabled && filtered ? XContentMapValues.filter(includes, excludes, true) : null;
        public static final FieldType FIELD_TYPE = new FieldType();
        @Override
            return CONTENT_TYPE;
            return Arrays.asList(enabled, includes, excludes, recoverySourceEnabled, recoverySourceIncludes, recoverySourceExcludes);
            if ((context.indexSettings().getAsBoolean(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), false)
        private final Parameter<List<String>> recoverySourceExcludes = Parameter.stringArrayParam(
            "recovery_source_includes",
    private final Function<Map<String, ?>, Map<String, Object>> filter;
@PublicApi(since = "1.0.0")
        public static final boolean ENABLED = true;
    @Override
         * snapshot.
        final boolean recoverySourcefiltered = CollectionUtils.isEmpty(recoverySourceIncludes) == false
        this(Defaults.ENABLED, Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY, Defaults.ENABLED, Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY);
            false,
        public static final String NAME = SourceFieldMapper.NAME;
 * not use this file except in compliance with the License.
        protected List<Parameter<?>> getParameters() {
         * Refer {@link #recoverySourceEnabled} for more details
import org.apache.lucene.index.IndexOptions;
        );
         * Refer {@link #recoverySourceEnabled} for more details
        /**
                XContentBuilder builder = MediaTypeRegistry.contentBuilder(actualContentType, bStream).map(filteredSource);
     * @opensearch.internal
 * software distributed under the License is distributed on an
            super(Defaults.NAME);
    }
    private static SourceFieldMapper toType(FieldMapper in) {
        final boolean filtered = CollectionUtils.isEmpty(includes) == false || CollectionUtils.isEmpty(excludes) == false;
                || context.indexSettings().getAsBoolean(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false))
                return originalSource;
     * Default parameters for source fields
    /**
        @Override
            );
            }
    public boolean enabled() {
     * @opensearch.internal
    ) {
        final BytesReference adaptedSource = applyFilters(originalSource, contentType);
                Tuple<? extends MediaType, Map<String, Object>> mapTuple = XContentHelper.convertToMap(originalSource, true, contentType);
    public static final TypeParser PARSER = new ConfigurableTypeParser(c -> new SourceFieldMapper(), c -> new Builder());
        this.recoverySourceFilter = this.recoverySourceEnabled && recoverySourcefiltered
    }
         */
                throw new MapperParsingException(
    @Nullable
         * Peer to Peer recovery can happen using segment files rather than replaying traffic by querying Lucene
import org.opensearch.core.common.Strings;
        );
        }
        @Override
        boolean recoverySourceEnabled,
    public static final String RECOVERY_SOURCE_NAME = "_recovery_source";
import java.util.Collection;
    }
    private SourceFieldMapper(
        String[] recoverySourceIncludes,
    }
/*
import java.util.function.Function;
         * customer. Recovery source is not a permanent field and gets removed during merges. Refer this merge
            false,
    }
 */
    private final String[] includes;
 * SPDX-License-Identifier: Apache-2.0
 *
        }
    }
        private final Parameter<Boolean> recoverySourceEnabled = Parameter.boolParam(
    private final boolean enabled;
    public static final String NAME = "_source";
         * {@link #includes}/{@link #excludes}, which has the possibility to change the original document provided by
import org.opensearch.core.common.util.CollectionUtils;
        /**
     */
 */
         * Recovery source gets added if source is disabled or there are filters that are applied on _source using
import java.util.Collections;
        if (adaptedSource != null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @Nullable MediaType contentType,
        this.recoverySourceEnabled = recoverySourceEnabled;
        }
 * The OpenSearch Contributors require contributions made to
    }
                );
            Collections.emptyList()
        }
        /**
import org.opensearch.search.lookup.SearchLookup;
 * KIND, either express or implied.  See the License for the
                excludes.getValue().toArray(new String[0]),
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.FieldType;
    }
        );
        return enabled;
            super(NAME, false, enabled, false, TextSearchInfo.NONE, Collections.emptyMap());
        String[] excludes,
         * <p>
        public Query termQuery(Object value, QueryShardContext context) {
        public SourceFieldMapper build(BuilderContext context) {
import java.util.List;
            return null;
            m -> Arrays.asList(toType(m).includes),
        this.complete = enabled && CollectionUtils.isEmpty(includes) && CollectionUtils.isEmpty(excludes);
        return List.of(includes);
        this.excludes = excludes;
import org.opensearch.common.io.stream.BytesStreamOutput;
         *
                context.doc().add(new StoredField(RECOVERY_SOURCE_NAME, ref.bytes, ref.offset, ref.length));
import org.opensearch.index.query.QueryShardContext;
        }
 * @opensearch.api
        }
         * are not flushed to the disk. If you are disabling the recovery source, then ensure that you are calling
                    recoverySourceFilter
import org.opensearch.common.annotation.PublicApi;
                recoverySourceExcludes.getValue().toArray(new String[0])
import org.opensearch.core.xcontent.MediaTypeRegistry;
    static final class SourceFieldType extends MappedFieldType {
            return;
         * Provides capability to remove specific fields in the recovery_source.
                BytesRef ref = adaptedRecoverySource.toBytesRef();
}
            || CollectionUtils.isEmpty(recoverySourceExcludes) == false;
        @Override
/*
 * You may obtain a copy of the License at
         * <p>
    }
import java.io.IOException;
            "includes",
        private final Parameter<Boolean> enabled = Parameter.boolParam("enabled", false, m -> toType(m).enabled, Defaults.ENABLED);
        @Override
    public BytesReference applyFilters(@Nullable BytesReference originalSource, @Nullable MediaType contentType) throws IOException {
        return List.of(excludes);
        public String typeName() {
            : null;
    private final boolean recoverySourceEnabled;
    protected String contentType() {
    private final boolean complete;
import org.opensearch.core.common.bytes.BytesReference;
            "recovery_source_excludes",
 * specific language governing permissions and limitations
    @Override
 *
         * This is an expert parameter.
                context.doc().add(new NumericDocValuesField(RECOVERY_SOURCE_NAME, 1));
     */
    private final String[] recoverySourceExcludes;
            final BytesRef ref = adaptedSource.toBytesRef();
    private final String[] recoverySourceIncludes;
        if (context.indexSettings().isDerivedSourceEnabled()) {
        private final Parameter<List<String>> recoverySourceIncludes = Parameter.stringArrayParam(
        return (SourceFieldMapper) in;
    }
         * This is an expert parameter.
                return bStream.bytes();
     *
        boolean isProvidedSourceEnabled,
    private final String[] excludes;
            "excludes",
public class SourceFieldMapper extends MetadataFieldMapper {
import org.opensearch.index.query.QueryShardException;
        public Builder() {
         * policy: org.opensearch.index.engine.RecoverySourcePruneMergePolicy
            }
        // Set parameters for recovery source
            m -> toType(m).recoverySourceEnabled,
import org.opensearch.common.xcontent.XContentHelper;
     *
        if (isProvidedSourceEnabled && originalSource != null) {
         */
                // if we omitted source or modified it we add the _recovery_source to ensure we have it for ops based recovery
 */
        }
        return complete;
     * @opensearch.internal
                    recoverySourceEnabled,
 * Modifications Copyright OpenSearch Contributors. See
                Map<String, Object> filteredSource = filters.apply(mapTuple.v2());
            FIELD_TYPE.setStored(true);
                recoverySourceIncludes.getValue().toArray(new String[0]),
    public static class Builder extends MetadataFieldMapper.Builder {
            false,
         * <p>
         * This is an expert mapping parameter.
            // Percolate and tv APIs may not set the source and that is ok, because these APIs will not index any data
                    originalSource,
     * Builder for source fields
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.xcontent.support.XContentMapValues;
        String[] recoverySourceExcludes
            m -> Arrays.asList(toType(m).recoverySourceExcludes),
    }
    }
            throw new UnsupportedOperationException("Cannot fetch values for internal field [" + name() + "].");
        MediaType contentType = context.sourceToParse().getMediaType();
     */
        static {
            if (filters != null) {
            FIELD_TYPE.setIndexOptions(IndexOptions.NONE); // not indexed
            ? XContentMapValues.filter(recoverySourceIncludes, recoverySourceExcludes, true)
        }
        super(new SourceFieldType(enabled));
 * this work for additional information regarding copyright
            }
         * <p>
         * flush operation of Opensearch periodically to ensure that segments are flushed to the disk and if required
 * the Apache License, Version 2.0 (the "License"); you may
            m -> Arrays.asList(toType(m).excludes),
import org.opensearch.core.xcontent.XContentBuilder;
/**
        }
import org.apache.lucene.search.Query;
            context.doc().add(new StoredField(fieldType().name(), ref.bytes, ref.offset, ref.length));
         *
import org.opensearch.index.IndexSettings;
        }
    public void preParse(ParseContext context) throws IOException {
     *
