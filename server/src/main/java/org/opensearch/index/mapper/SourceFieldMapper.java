     */  
        String[] recoverySourceExcludes  
        if (recoverySourceEnabled) {  
            return null;
 * this work for additional information regarding copyright
    }
            m -> Arrays.asList(toType(m).excludes),  
import org.opensearch.common.xcontent.XContentHelper;
        /**  
                    originalSource,  
        String[] excludes,  
     * Default parameters for source fields  
 */
         * <p>
        @Override  
import org.opensearch.common.xcontent.support.XContentMapValues;  
        return complete;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.io.stream.BytesStreamOutput;
    @Nullable
         */
                BytesRef ref = adaptedRecoverySource.toBytesRef();  
        private final Parameter<Boolean> recoverySourceEnabled = Parameter.boolParam(
import org.opensearch.core.common.util.CollectionUtils;  
    }
        /**
        @Override
import org.apache.lucene.util.BytesRef;  
        MediaType contentType = context.sourceToParse().getMediaType();
    protected String contentType() {  
            Defaults.ENABLED
    /**
            Collections.emptyList()
        }
    ) throws IOException {  
    private SourceFieldMapper(  
                final BytesReference adaptedRecoverySource = applyFilters(
    }
        this.recoverySourceIncludes = recoverySourceIncludes;  
    public static final String CONTENT_TYPE = "_source";
            final BytesRef ref = adaptedSource.toBytesRef();
    private final Function<Map<String, ?>, Map<String, Object>> filter;
        final boolean filtered = CollectionUtils.isEmpty(includes) == false || CollectionUtils.isEmpty(excludes) == false;  
    /**
import org.opensearch.common.Nullable;
        final BytesReference adaptedSource = applyFilters(originalSource, contentType);
 */  
/*  
     */  
        @Nullable BytesReference originalSource,
        }
                throw new MapperParsingException(  
            Collections.emptyList()
         * This is an expert parameter.
        }
                && !enabled.getValue()) {
        this.enabled = enabled;  
                builder.close();
        this.recoverySourceExcludes = recoverySourceExcludes;
    /** indicates whether the source will always exist and be complete, for use by features like the update API */  
package org.opensearch.index.mapper;
        return List.of(includes);  
                return originalSource;
        private SourceFieldType(boolean enabled) {  
            super(Defaults.NAME);
@PublicApi(since = "1.0.0")
        boolean enabled,
         * <p>  
    public static class Builder extends MetadataFieldMapper.Builder {  
        }
            false,  
                    contentType,
            FIELD_TYPE.setIndexOptions(IndexOptions.NONE); // not indexed
                includes.getValue().toArray(new String[0]),  
     *  
            false,
    private final boolean recoverySourceEnabled;
        }  
import org.opensearch.core.common.bytes.BytesReference;
 * You may obtain a copy of the License at  
                BytesStreamOutput bStream = new BytesStreamOutput();
 *  
    public Collection<String> getExcludes() {  
        private final Parameter<Boolean> enabled = Parameter.boolParam("enabled", false, m -> toType(m).enabled, Defaults.ENABLED);
    ) {
 * software distributed under the License is distributed on an
        return enabled;
import org.apache.lucene.search.Query;
        String[] recoverySourceIncludes,
                recoverySourceIncludes.getValue().toArray(new String[0]),  
        super(new SourceFieldType(enabled));
        this.filter = enabled && filtered ? XContentMapValues.filter(includes, excludes, true) : null;
            if (filters != null) {  
                Tuple<? extends MediaType, Map<String, Object>> mapTuple = XContentHelper.convertToMap(originalSource, true, contentType);
         */
            return new SourceFieldMapper(
            "recovery_source_enabled",
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                // if we omitted source or modified it we add the _recovery_source to ensure we have it for ops based recovery
import org.opensearch.index.query.QueryShardException;  
    }
        }
    private final String[] recoverySourceExcludes;  
         * Provides capability to remove specific fields in the recovery_source.
         * The main reason for adding the _recovery_source was to ensure Peer to Peer recovery if segments  
import java.io.IOException;  
                XContentBuilder builder = MediaTypeRegistry.contentBuilder(actualContentType, bStream).map(filteredSource);  
            "excludes",
 * under the License.  
            ? XContentMapValues.filter(recoverySourceIncludes, recoverySourceExcludes, true)
     * @opensearch.internal
            || CollectionUtils.isEmpty(recoverySourceExcludes) == false;  
        }
 */  
 *
/*  
import org.opensearch.core.xcontent.MediaType;
 *
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
    private final String[] excludes;
        String[] includes,
                context.doc().add(new StoredField(RECOVERY_SOURCE_NAME, ref.bytes, ref.offset, ref.length));
    public static final String RECOVERY_SOURCE_NAME = "_recovery_source";
                excludes.getValue().toArray(new String[0]),
 * Modifications Copyright OpenSearch Contributors. See
            : null;  
        @Override
        public String typeName() {
            }  
        return applyFilters(originalSource, contentType, enabled, filter);  
        public static final FieldType FIELD_TYPE = new FieldType();
         * Refer {@link #recoverySourceEnabled} for more details
            return;
     *
    }
        );
                // we don't update the context source if we filter, we want to keep it as is...
        );  
    public static class Defaults {
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
        );
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.document.NumericDocValuesField;
            super(NAME, false, enabled, false, TextSearchInfo.NONE, Collections.emptyMap());
            return Arrays.asList(enabled, includes, excludes, recoverySourceEnabled, recoverySourceIncludes, recoverySourceExcludes);
        }
        } else {  
/*
            FIELD_TYPE.freeze();
import java.util.function.Function;  
    public static final String NAME = "_source";
         * This is an expert parameter.  
        final boolean recoverySourcefiltered = CollectionUtils.isEmpty(recoverySourceIncludes) == false
        protected List<Parameter<?>> getParameters() {  
        @Override
    public boolean isComplete() {
    }
        @Override
        public static final String NAME = SourceFieldMapper.NAME;
        if (adaptedSource != null) {
            } else {  
     * Builder for source fields
            "recovery_source_includes",  
            FIELD_TYPE.setOmitNorms(true);
    }
 */  
    @Override
/**
    }  
import java.util.Collections;  
        boolean recoverySourceEnabled,
            false,
import java.util.Arrays;
         * flush operation of Opensearch periodically to ensure that segments are flushed to the disk and if required
    @Override
            m -> Arrays.asList(toType(m).includes),  
            Collections.emptyList()  
    private final boolean enabled;
    private final boolean complete;
    static final class SourceFieldType extends MappedFieldType {
         *
    private final String[] includes;  
        }  
import org.opensearch.search.lookup.SearchLookup;
                || context.indexSettings().getAsBoolean(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false))
    /**
        }
        );
            FIELD_TYPE.setStored(true);  
import org.opensearch.common.collect.Tuple;  
    private BytesReference applyFilters(
                MediaType actualContentType = mapTuple.v1();
        public SourceFieldMapper build(BuilderContext context) {
    }  
         * Recovery source gets added if source is disabled or there are filters that are applied on _source using
 * Licensed to Elasticsearch under one or more contributor  
    private static SourceFieldMapper toType(FieldMapper in) {  
 * @opensearch.api
        @Override
        public Query existsQuery(QueryShardContext context) {  
import org.apache.lucene.document.StoredField;  
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup lookup, String format) {
 * KIND, either express or implied.  See the License for the
        @Nullable final Function<Map<String, ?>, Map<String, Object>> filters
         * Peer to Peer recovery can happen using segment files rather than replaying traffic by querying Lucene  
         * {@link #includes}/{@link #excludes}, which has the possibility to change the original document provided by
            if (originalSource != null && adaptedSource != originalSource) {
     * @opensearch.internal
                );
        private final Parameter<List<String>> excludes = Parameter.stringArrayParam(  
     */
import java.util.Collection;
    public BytesReference applyFilters(@Nullable BytesReference originalSource, @Nullable MediaType contentType) throws IOException {
        }  
         */  
}
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
    public static final TypeParser PARSER = new ConfigurableTypeParser(c -> new SourceFieldMapper(), c -> new Builder());  
            if ((context.indexSettings().getAsBoolean(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), false)  
    }
 * GitHub history for details.
            throw new QueryShardException(context, "The _source field is not searchable");  
    }
            }  
                enabled.getValue(),
        return CONTENT_TYPE;
                );
        }
import java.util.Map;
import java.util.List;
 * Internal field mapper for storing source (and recovery source)  
        return new Builder().init(this);  
        private final Parameter<List<String>> recoverySourceExcludes = Parameter.stringArrayParam(  
        return (SourceFieldMapper) in;
        }  
            throw new UnsupportedOperationException("Cannot fetch values for internal field [" + name() + "].");
    }
        this.complete = enabled && CollectionUtils.isEmpty(includes) && CollectionUtils.isEmpty(excludes);
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.common.Strings;
            false,
    }
         * Provides capability to add specific fields in the recovery_source.  
        this.recoverySourceEnabled = recoverySourceEnabled;
        if (isProvidedSourceEnabled && originalSource != null) {
        public static final boolean ENABLED = true;  
            Collections.emptyList()
            m -> toType(m).recoverySourceEnabled,
import org.opensearch.index.query.QueryShardContext;
        @Nullable MediaType contentType,  
        // Set parameters for recovery source
            "recovery_source_excludes",
 *
                context.doc().add(new NumericDocValuesField(RECOVERY_SOURCE_NAME, 1));
 * this file be licensed under the Apache-2.0 license or a
     * Field type for source field mapper  
                return bStream.bytes();
         * policy: org.opensearch.index.engine.RecoverySourcePruneMergePolicy
        private final Parameter<List<String>> recoverySourceIncludes = Parameter.stringArrayParam(
            false,
        boolean isProvidedSourceEnabled,
    public Collection<String> getIncludes() {
         * <p>
            return CONTENT_TYPE;  
            context.doc().add(new StoredField(fieldType().name(), ref.bytes, ref.offset, ref.length));  
            );
            }
        );
import org.opensearch.index.IndexSettings;
    private SourceFieldMapper() {
    private final Function<Map<String, ?>, Map<String, Object>> recoverySourceFilter;  
         *
        this.excludes = excludes;
         * customer. Recovery source is not a permanent field and gets removed during merges. Refer this merge  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.XContentBuilder;  
                    recoverySourceEnabled,
        public Query termQuery(Object value, QueryShardContext context) {
         * are not flushed to the disk. If you are disabling the recovery source, then ensure that you are calling
        private final Parameter<List<String>> includes = Parameter.stringArrayParam(  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    recoverySourceFilter  
    public void preParse(ParseContext context) throws IOException {
    @Override
                recoverySourceEnabled.getValue(),
            throw new QueryShardException(context, "The _source field is not searchable");
    @Nullable  
    }
         * A mapping parameter which define whether the recovery_source should be added or not. Default value is true.
                Map<String, Object> filteredSource = filters.apply(mapTuple.v2());  
            m -> Arrays.asList(toType(m).recoverySourceExcludes),  
            m -> Arrays.asList(toType(m).recoverySourceIncludes),
        this(Defaults.ENABLED, Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY, Defaults.ENABLED, Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY);  
import org.opensearch.core.xcontent.MediaTypeRegistry;
                recoverySourceExcludes.getValue().toArray(new String[0])
        public Builder() {
        if (context.indexSettings().isDerivedSourceEnabled()) {  
    private final String[] recoverySourceIncludes;
            // Percolate and tv APIs may not set the source and that is ok, because these APIs will not index any data
        this.recoverySourceFilter = this.recoverySourceEnabled && recoverySourcefiltered
         * snapshot.
         * <p>  
        BytesReference originalSource = context.sourceToParse().source();  
         *
                    "_source can't be disabled with " + IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey() + " enabled index setting"
import org.apache.lucene.document.FieldType;
        /**
        return List.of(excludes);
     *
    public boolean enabled() {  
        static {
            "includes",
public class SourceFieldMapper extends MetadataFieldMapper {
 * compatible open source license.
         * Refer {@link #recoverySourceEnabled} for more details  
         * This is an expert mapping parameter.
     * @opensearch.internal
        this.includes = includes;
 * The OpenSearch Contributors require contributions made to  
