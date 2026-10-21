    }
     * then add it to the end. So the lookup for the a field named {@code a} will be {@code ["a"]}. If
        this.docMap = new DocLookup(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * which depends on another runtime field's doc values and so on, it can
     * @return the new lookup
    /**
        this.fieldChain = Collections.emptySet();
        this.fieldDataLookup = searchLookup.fieldDataLookup;
 * license agreements. See the NOTICE file distributed with
        this.fieldsLookup = fieldsLookup;
        );
        int shardId
 * The OpenSearch Contributors require contributions made to
 * You may obtain a copy of the License at
     * Creates a copy of the current {@link SearchLookup} that looks fields up in the same way, but also tracks field references
        int shardId,
    private final FieldsLookup fieldsLookup;
    /**
import java.util.Collections;
     * This constant should be used in cases when shard id is unknown.
 * software distributed under the License is distributed on an
}
    public int shardId() {
        this.fieldDataLookup = fieldDataLookup;
    }
     */
            context,
    /**
            sourceLookupMap.computeIfAbsent(Thread.currentThread().threadId(), K -> new SourceLookup()),
 * Unless required by applicable law or agreed to in writing,
    public SourceLookup source() {
    public SearchLookup(
 * not use this file except in compliance with the License.
    public SearchLookup(
        BiFunction<MappedFieldType, Supplier<SearchLookup>, IndexFieldData<?>> fieldDataLookup
    public DocLookup doc() {
     */
    public LeafSearchLookup getLeafSearchLookup(LeafReaderContext context) {
 * Orchestrator class for search phase lookups
     * being resolved depends on more than {@link #MAX_FIELD_CHAIN_DEPTH}
        return new SearchLookup(this, newFieldChain);
            fieldType -> fieldDataLookup.apply(fieldType, () -> forkAndTrackFieldReferences(fieldType.name()))
        if (newFieldChain.add(field) == false) {
            docMap.getLeafDocLookup(context),
        this.fieldChain = Collections.unmodifiableSet(fieldChain);
     * {@code b}'s chain will contain {@code ["a", "b"]}.
        BiFunction<MappedFieldType, Supplier<SearchLookup>, IndexFieldData<?>> fieldDataLookup,
    public SearchLookup(
        docMap = new DocLookup(
import org.opensearch.index.mapper.MappedFieldType;
    private final ConcurrentHashMap<Long, SourceLookup> sourceLookupMap = new ConcurrentHashMap<>();
     * @throws IllegalArgumentException if a cycle is detected in the fields required to build doc values, or if the field
     * for the "top level" lookup created for the entire search. When a lookup is used to load
import java.util.LinkedHashSet;
     * stored fields, or _source.
/*
        this.shardId = searchLookup.shardId;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        MapperService mapperService,
 * GitHub history for details.
     */
            fieldType -> searchLookup.fieldDataLookup.apply(fieldType, () -> forkAndTrackFieldReferences(fieldType.name()))
import org.opensearch.common.annotation.PublicApi;
    private final Set<String> fieldChain;
     * and prevents resolving fields that depend on more than {@link #MAX_FIELD_CHAIN_DEPTH} fields.
    /**
        this.fieldsLookup = searchLookup.fieldsLookup;
            searchLookup.docMap.mapperService(),
        }
        if (shardId == UNKNOWN_SHARD_ID) {
            throw new IllegalArgumentException("Cyclic dependency detected while resolving runtime fields: " + message);
    public final SearchLookup forkAndTrackFieldReferences(String field) {
import java.util.Objects;
        MapperService mapperService,
     * The maximum depth of field dependencies.
    /**
    private final DocLookup docMap;
        return docMap;
 *
    }
 * Modifications Copyright OpenSearch Contributors. See
     * When a runtime field's doc values depends on another runtime field's doc values,
     * Create a new {@link SearchLookup} that looks fields up the same as the one provided as argument,
public class SearchLookup {
            fieldsLookup.getLeafFieldsLookup(context)
@PublicApi(since = "1.0.0")
import org.opensearch.index.fielddata.IndexFieldData;
     * that field looks up the values of a field named {@code b} then
    /**
     * loops caused by runtime fields referring to other runtime fields. The chain is empty
    }
    /**
 * @opensearch.api
import java.util.function.Supplier;
    private SearchLookup(SearchLookup searchLookup, Set<String> fieldChain) {
        FieldsLookup fieldsLookup
 *
 */
    @Deprecated
        }
 * this file be licensed under the Apache-2.0 license or a
        Set<String> newFieldChain = new LinkedHashSet<>(fieldChain);
     * Constructor for backwards compatibility. Use the one with explicit shardId argument.
        this(mapperService, fieldDataLookup, UNKNOWN_SHARD_ID);
 * the Apache License, Version 2.0 (the "License"); you may
     * Create the top level field lookup for a search request. Provides a way to look up fields from doc_values,
 * compatible open source license.
     * Mostly it should be used in tests.
import org.apache.lucene.index.LeafReaderContext;
 * this work for additional information regarding copyright
     * in order to detect cycles and prevent resolving fields that depend on more than {@link #MAX_FIELD_CHAIN_DEPTH} other fields.
    /**
     * while also tracking field references starting from the provided field name. It detects cycles
package org.opensearch.search.lookup;
 *
     */
     */
        this(mapperService, fieldDataLookup, shardId, new FieldsLookup(mapperService));
import java.util.Set;
     */
        );
/*
import java.util.concurrent.ConcurrentHashMap;
    ) {
    ) {
     * The chain of fields for which this lookup was created, used for detecting
    }
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("Field requires resolving too many dependent fields: " + String.join(" -> ", newFieldChain));
/**
 * under the License.
 * specific language governing permissions and limitations
        return new LeafSearchLookup(
 * ownership. Elasticsearch licenses this file to you under
 * KIND, either express or implied.  See the License for the
    private final int shardId;
 */
     * @param fieldChain the chain of fields that required the field currently being loaded
    private static final int MAX_FIELD_CHAIN_DEPTH = 5;
    }
     * @param searchLookup the existing lookup to create a new one from
            throw new IllegalStateException("Shard id is unknown for this lookup");
     * SourceLookup is not thread safe, so we create a new instance for each leaf to support concurrent segment search
        this.shardId = shardId;
    /**
        BiFunction<MappedFieldType, Supplier<SearchLookup>, IndexFieldData<?>> fieldDataLookup,
 *
        if (newFieldChain.size() > MAX_FIELD_CHAIN_DEPTH) {
     * fielddata for a field, we fork it and make sure the field name name isn't in the chain,
/*
     */
    }
 * Licensed to Elasticsearch under one or more contributor
            String message = String.join(" -> ", newFieldChain) + " -> " + field;
        }
    private final BiFunction<MappedFieldType, Supplier<SearchLookup>, IndexFieldData<?>> fieldDataLookup;
        Objects.requireNonNull(field, "field cannot be null");
    public static final int UNKNOWN_SHARD_ID = -1;
    }
     */
import java.util.function.BiFunction;
        MapperService mapperService,
     * @param field the field being referred to, for which fielddata needs to be loaded
     */
            mapperService,
        return shardId;
        );
import org.opensearch.index.mapper.MapperService;
    ) {
     * Returned SourceLookup will be unrelated to any created LeafSearchLookups. Instead, use {@link LeafSearchLookup#source()} to access the related {@link SearchLookup}.
 */
        return sourceLookupMap.computeIfAbsent(Thread.currentThread().threadId(), K -> new SourceLookup());
     * make a very deep stack, which we want to limit.
    }
