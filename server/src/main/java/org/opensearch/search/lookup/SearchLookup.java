     * The maximum depth of field dependencies.
        this.shardId = searchLookup.shardId;
    /**
        this.docMap = new DocLookup(
            context,  
 * this work for additional information regarding copyright
        Set<String> newFieldChain = new LinkedHashSet<>(fieldChain);
     * @param fieldChain the chain of fields that required the field currently being loaded  
        return sourceLookupMap.computeIfAbsent(Thread.currentThread().threadId(), K -> new SourceLookup());  
        MapperService mapperService,
        MapperService mapperService,  
import org.apache.lucene.index.LeafReaderContext;
     * while also tracking field references starting from the provided field name. It detects cycles  
    @Deprecated
 * Orchestrator class for search phase lookups
            searchLookup.docMap.mapperService(),
        this.fieldDataLookup = searchLookup.fieldDataLookup;  
        return docMap;
    private final FieldsLookup fieldsLookup;
    ) {
     * SourceLookup is not thread safe, so we create a new instance for each leaf to support concurrent segment search
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
     * @return the new lookup
     * When a runtime field's doc values depends on another runtime field's doc values,  
    public int shardId() {  
 * the Apache License, Version 2.0 (the "License"); you may
        int shardId
 * KIND, either express or implied.  See the License for the
        this(mapperService, fieldDataLookup, UNKNOWN_SHARD_ID);  
     * Returned SourceLookup will be unrelated to any created LeafSearchLookups. Instead, use {@link LeafSearchLookup#source()} to access the related {@link SearchLookup}.  
            fieldsLookup.getLeafFieldsLookup(context)  
        if (newFieldChain.add(field) == false) {  
    /**  
 * GitHub history for details.
    private static final int MAX_FIELD_CHAIN_DEPTH = 5;
    }
import org.opensearch.index.mapper.MappedFieldType;
        }  
 * compatible open source license.
import org.opensearch.index.mapper.MapperService;
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );
     * Create a new {@link SearchLookup} that looks fields up the same as the one provided as argument,
     * Creates a copy of the current {@link SearchLookup} that looks fields up in the same way, but also tracks field references
        BiFunction<MappedFieldType, Supplier<SearchLookup>, IndexFieldData<?>> fieldDataLookup,  
/*  
    ) {
        MapperService mapperService,
@PublicApi(since = "1.0.0")
     * being resolved depends on more than {@link #MAX_FIELD_CHAIN_DEPTH}
     * @param searchLookup the existing lookup to create a new one from
     */  
package org.opensearch.search.lookup;
        }  
    /**  
import java.util.concurrent.ConcurrentHashMap;
    }
import java.util.Objects;  
    private final Set<String> fieldChain;  
 * this file be licensed under the Apache-2.0 license or a
 *  
    public SearchLookup(
     * {@code b}'s chain will contain {@code ["a", "b"]}.
        FieldsLookup fieldsLookup
        return new SearchLookup(this, newFieldChain);
     * loops caused by runtime fields referring to other runtime fields. The chain is empty
            throw new IllegalArgumentException("Cyclic dependency detected while resolving runtime fields: " + message);
     */
     * @param field the field being referred to, for which fielddata needs to be loaded
    public LeafSearchLookup getLeafSearchLookup(LeafReaderContext context) {
        BiFunction<MappedFieldType, Supplier<SearchLookup>, IndexFieldData<?>> fieldDataLookup,
        return shardId;
     * in order to detect cycles and prevent resolving fields that depend on more than {@link #MAX_FIELD_CHAIN_DEPTH} other fields.  
     * This constant should be used in cases when shard id is unknown.
 * specific language governing permissions and limitations
            String message = String.join(" -> ", newFieldChain) + " -> " + field;
 * software distributed under the License is distributed on an
        this.fieldsLookup = searchLookup.fieldsLookup;
     * make a very deep stack, which we want to limit.
 * You may obtain a copy of the License at  
/**  
        );
        return new LeafSearchLookup(
import org.opensearch.common.annotation.PublicApi;
 */
 * SPDX-License-Identifier: Apache-2.0
     * Constructor for backwards compatibility. Use the one with explicit shardId argument.
    public static final int UNKNOWN_SHARD_ID = -1;
     * that field looks up the values of a field named {@code b} then  
 *
 * The OpenSearch Contributors require contributions made to  
    }
 * Unless required by applicable law or agreed to in writing,
    /**
    private SearchLookup(SearchLookup searchLookup, Set<String> fieldChain) {
 */
     */  
    /**
import java.util.Set;
        BiFunction<MappedFieldType, Supplier<SearchLookup>, IndexFieldData<?>> fieldDataLookup
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
            mapperService,
            throw new IllegalArgumentException("Field requires resolving too many dependent fields: " + String.join(" -> ", newFieldChain));
        }  
        );
 * @opensearch.api  
        this.fieldChain = Collections.unmodifiableSet(fieldChain);  
}  
     */  
     * then add it to the end. So the lookup for the a field named {@code a} will be {@code ["a"]}. If
    /**
     */
public class SearchLookup {  
     * for the "top level" lookup created for the entire search. When a lookup is used to load  
        this.fieldsLookup = fieldsLookup;
    }
        docMap = new DocLookup(
            fieldType -> searchLookup.fieldDataLookup.apply(fieldType, () -> forkAndTrackFieldReferences(fieldType.name()))  
     */
     * The chain of fields for which this lookup was created, used for detecting
 * not use this file except in compliance with the License.
     * fielddata for a field, we fork it and make sure the field name name isn't in the chain,
     * Create the top level field lookup for a search request. Provides a way to look up fields from doc_values,
    public DocLookup doc() {
 * ownership. Elasticsearch licenses this file to you under  
    public final SearchLookup forkAndTrackFieldReferences(String field) {  
     */  
    public SearchLookup(  
import java.util.function.BiFunction;  
     * Mostly it should be used in tests.
    ) {
            fieldType -> fieldDataLookup.apply(fieldType, () -> forkAndTrackFieldReferences(fieldType.name()))  
    public SourceLookup source() {
        this.shardId = shardId;
/*  
/*
        int shardId,  
    private final BiFunction<MappedFieldType, Supplier<SearchLookup>, IndexFieldData<?>> fieldDataLookup;  
        if (shardId == UNKNOWN_SHARD_ID) {
        this(mapperService, fieldDataLookup, shardId, new FieldsLookup(mapperService));  
     */
 */  
            docMap.getLeafDocLookup(context),
            throw new IllegalStateException("Shard id is unknown for this lookup");
    public SearchLookup(
 *
 *
import java.util.Collections;
    }
        if (newFieldChain.size() > MAX_FIELD_CHAIN_DEPTH) {
        this.fieldChain = Collections.emptySet();  
     */  
import org.opensearch.index.fielddata.IndexFieldData;  
    private final int shardId;
     * which depends on another runtime field's doc values and so on, it can
 * Licensed to Elasticsearch under one or more contributor  
     * and prevents resolving fields that depend on more than {@link #MAX_FIELD_CHAIN_DEPTH} fields.
    }
        Objects.requireNonNull(field, "field cannot be null");
    /**
     * @throws IllegalArgumentException if a cycle is detected in the fields required to build doc values, or if the field  
            sourceLookupMap.computeIfAbsent(Thread.currentThread().threadId(), K -> new SourceLookup()),
    }
        this.fieldDataLookup = fieldDataLookup;  
import java.util.LinkedHashSet;
 * under the License.  
    private final ConcurrentHashMap<Long, SourceLookup> sourceLookupMap = new ConcurrentHashMap<>();
    /**  
    /**
import java.util.function.Supplier;
     * stored fields, or _source.
    private final DocLookup docMap;
