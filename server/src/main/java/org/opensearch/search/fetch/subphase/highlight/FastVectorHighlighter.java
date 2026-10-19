                }
        "search.highlight.term_vector_multi_value",  
        final HighlightBuilder.BoundaryScannerType type = fieldOptions.boundaryScannerType() != null
        public FieldQuery noFieldMatchFieldQuery;  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
        } else {  
    private static final BoundaryScanner DEFAULT_SIMPLE_BOUNDARY_SCANNER = new SimpleBoundaryScanner();  
 * this file be licensed under the Apache-2.0 license or a
        public FieldQuery fieldMatchFieldQuery;
 * specific language governing permissions and limitations
                    options.postTags(),  
import java.util.HashMap;
 * Unless required by applicable law or agreed to in writing,
        SearchHighlightContext.Field field,  
            }  
                 * we use top level reader to rewrite the query against all readers,
            // Essentially we just request that a fragment is built from 0 to noMatchSize using
 * KIND, either express or implied.  See the License for the
        FragmentsBuilder fragmentsBuilder = entry.fragmentsBuilderSupplier.apply(hitContext.sourceLookup());  
                field.fieldOptions().postTags(),  
        }  
        public Map<MappedFieldType, FieldHighlightEntry> fields = new HashMap<>();  
        public Function<SourceLookup, FragmentsBuilder> fragmentsBuilderSupplier;
import org.opensearch.lucene.search.vectorhighlight.CustomFieldQuery;
                 * with use caching it across hits (and across readers...)
                supplier = lookup -> new SourceScoreOrderFragmentsBuilder(  
            if (options.numberOfFragments() != 0 && options.scoreOrdered()) {
                return DEFAULT_SIMPLE_BOUNDARY_SCANNER;  
                    true,
                /*
                 */
    public static final Setting<Boolean> SETTING_TV_HIGHLIGHT_MULTI_VALUE = Setting.boolSetting(
        final FieldQuery fieldQuery;  
                fieldType.name(),
import org.apache.lucene.search.vectorhighlight.SingleFragListBuilder;  
            );
            fieldContext.cache.put(CACHE_KEY, new HighlighterEntry());  
import org.opensearch.index.mapper.TextSearchInfo;  
                hitContext.reader(),  
            } else {
                return DEFAULT_WORD_BOUNDARY_SCANNER;  
                if (boundaryScannerLocale != null) {
            fragments = cache.fvh.getBestFragments(
import org.apache.lucene.search.vectorhighlight.FieldQuery;
        if (canHighlight(fieldType) == false) {
        BoundaryScanner boundaryScanner = getBoundaryScanner(field);
        MappedFieldType fieldType = fieldContext.fieldType;
                    field.fieldOptions().requireFieldMatch()
 *
                hitContext.reader(),  
                    options.postTags(),
                fieldType.name(),
import org.opensearch.search.fetch.FetchSubPhase;
    public HighlightField highlight(FieldHighlightContext fieldContext) throws IOException {
        public FragListBuilder fragListBuilder;
            } else {
import java.io.IOException;
                 */  
    ) {  
import org.opensearch.common.settings.Settings;
 */  
import java.util.function.Function;
            }  
                field.fieldOptions().postTags(),  
    private final Boolean termVectorMultiValue;  
 *  
            fragments = fragmentsBuilder.createFragments(
        FieldOptions options = field.fieldOptions();
        }  
                    lookup,
            } else {
        }
import org.opensearch.common.settings.Setting;
        if (entry == null) {
                field.fieldOptions().preTags(),
import java.util.Locale;
            default:
                    true,  
            case SENTENCE:  
            if (options.numberOfFragments() != 0 && options.scoreOrdered()) {
    public boolean canHighlight(MappedFieldType ft) {
import org.apache.lucene.search.vectorhighlight.BaseFragmentsBuilder;
            : Locale.ROOT;
                    fieldContext.query,
                fragmentsBuilder,  
        true,
                field.fieldOptions().preTags(),
            return builder;  
                hitContext.docId(),
        if (field.fieldOptions().requireFieldMatch()) {
 * You may obtain a copy of the License at  
    }  
import java.text.BreakIterator;
    private static class HighlighterEntry {
                entry.noFieldMatchFieldQuery = new CustomFieldQuery(  
                    lookup,
            FragListBuilder fragListBuilder;
                fieldQuery,
import org.apache.lucene.search.vectorhighlight.ScoreOrderFragmentsBuilder;
                }  
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext.Field;  
                encoder  
            if (CollectionUtils.isEmpty(fragments) == false) {  
    );  
    private static BoundaryScanner getBoundaryScanner(Field field) {  
import org.opensearch.index.mapper.MappedFieldType;
                field.fieldOptions().matchedFields(),  
            }  
 * ownership. Elasticsearch licenses this file to you under  
    );  
                entry.fragListBuilder,  
import org.apache.lucene.search.vectorhighlight.FragmentsBuilder;
        boolean forceSource
    @Override  
        this.termVectorMultiValue = SETTING_TV_HIGHLIGHT_MULTI_VALUE.get(settings);  
 *
            ? fieldOptions.boundaryScannerType()  
        }
            // the normal fragmentsBuilder
import org.apache.lucene.search.vectorhighlight.BreakIteratorBoundaryScanner;  
            Function<SourceLookup, FragmentsBuilder> fragmentsBuilderSupplier = fragmentsBuilderSupplier(field, fieldType, forceSource);
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
            if (field.fieldOptions().numberOfFragments() == 0) {  
            : field.fieldOptions().numberOfFragments();
        if (field.fieldOptions().matchedFields() != null && !field.fieldOptions().matchedFields().isEmpty()) {  
    }
/*  
import org.opensearch.search.lookup.SourceLookup;
        cache.fvh.setPhraseLimit(field.fieldOptions().phraseLimit());  
            fieldQuery = entry.fieldMatchFieldQuery;
                // first two booleans are not relevant since they are set on the CustomFieldQuery
            } else {
 * software distributed under the License is distributed on an
        final Locale boundaryScannerLocale = fieldOptions.boundaryScannerLocale() != null
                    boundaryScanner
            : HighlightBuilder.BoundaryScannerType.CHARS;
        switch (type) {
    private static final BoundaryScanner DEFAULT_SENTENCE_BOUNDARY_SCANNER = new BreakIteratorBoundaryScanner(
            }
 * not use this file except in compliance with the License.
public class FastVectorHighlighter implements Highlighter {
    private static final BoundaryScanner DEFAULT_WORD_BOUNDARY_SCANNER = new BreakIteratorBoundaryScanner(
        return lookup -> {  
 * Modifications Copyright OpenSearch Contributors. See  
        // Only send matched fields if they were requested to save time.
            fieldFragList.add(0, noMatchSize, Collections.emptyList());
        if (!forceSource && fieldType.isStored()) {
        return ft.getTextSearchInfo().termVectors() == TextSearchInfo.TermVector.OFFSETS;  
                    + fieldContext.fieldName
        BreakIterator.getWordInstance(Locale.ROOT)
import org.apache.lucene.search.vectorhighlight.SimpleBoundaryScanner;  
                    boundaryScanner
                fragListBuilder = new SingleFragListBuilder();
        }
            );
        FetchSubPhase.HitContext hitContext = fieldContext.hitContext;  
                );  
                throw new IllegalArgumentException("Invalid boundary scanner type: " + type.toString());
            entry.fragListBuilder = fragListBuilder;
import org.opensearch.core.common.text.Text;  
 */
                fragmentsBuilder,
                encoder
        Encoder encoder = field.fieldOptions().encoder().equals("html") ? HighlightUtils.Encoders.HTML : HighlightUtils.Encoders.DEFAULT;  
                1,
                );  
            }  
 * GitHub history for details.
        FieldHighlightEntry entry = cache.fields.get(fieldType);  
        if (!fieldContext.cache.containsKey(CACHE_KEY)) {
package org.opensearch.search.fetch.subphase.highlight;
        } else {  
                    options.preTags(),
                numberOfFragments,
/*
                    hitContext.topLevelReader(),  
                return new HighlightField(fieldContext.fieldName, Text.convertFromStringArray(fragments));
                entry.fragListBuilder,
import org.apache.lucene.search.vectorhighlight.FieldFragList;
            throw new IllegalArgumentException(
        return null;
                    fieldType,
        };
            builder.setDiscreteMultiValueHighlighting(termVectorMultiValue);
}
                fieldType.name(),
            case CHARS:
                field.fieldOptions().preTags(),
                    return new BreakIteratorBoundaryScanner(BreakIterator.getSentenceInstance(boundaryScannerLocale));
            if (field.fieldOptions().requireFieldMatch()) {
                    field.fieldOptions().requireFieldMatch()
 * under the License.  
            entry.fragmentsBuilderSupplier = fragmentsBuilderSupplier;
        }
                );
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                numberOfFragments,
                fragmentCharSize,
    private static final String CACHE_KEY = "highlight-fsv";
    }
            fragments = cache.fvh.getBestFragments(
                fragListBuilder = field.fieldOptions().fragmentOffset() == -1  
    public FastVectorHighlighter(Settings settings) {
import org.apache.lucene.search.vectorhighlight.BoundaryScanner;
                );
                "the field ["  
        HighlighterEntry cache = (HighlighterEntry) fieldContext.cache.get(CACHE_KEY);
                return DEFAULT_SENTENCE_BOUNDARY_SCANNER;
 */
                if (fieldOptions.boundaryMaxScan() != SimpleBoundaryScanner.DEFAULT_MAX_SCAN
 *
            );  
        // a HACK to make highlighter do highlighting, even though its using the single frag list builder
import org.apache.lucene.search.vectorhighlight.SimpleFragListBuilder;
                fragmentCharSize,  
    }
import org.apache.lucene.search.vectorhighlight.FragListBuilder;  
import org.apache.lucene.search.vectorhighlight.SimpleFieldFragList;
                if (boundaryScannerLocale != null) {  
import java.util.Map;  
        }
    }
/*
            ? fieldOptions.boundaryScannerLocale()  
                hitContext.docId(),
 * @opensearch.internal  
        int numberOfFragments = field.fieldOptions().numberOfFragments() == 0  
                fieldFragList,  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    : new SimpleFragListBuilder(field.fieldOptions().fragmentOffset());
                }
 */
                fieldQuery,
            FieldFragList fieldFragList = new SimpleFieldFragList(-1 /*ignored*/);  
                field.fieldOptions().postTags(),
                 * we use top level reader to rewrite the query against all readers,  
        int noMatchSize = fieldContext.field.fieldOptions().noMatchSize();
                    fieldContext.query,
                cache.fvh = new org.apache.lucene.search.vectorhighlight.FastVectorHighlighter();
import java.util.Collections;  
                supplier = ignored -> new SimpleFragmentsBuilder(fieldType, options.preTags(), options.postTags(), boundaryScanner);
    private Function<SourceLookup, FragmentsBuilder> fragmentsBuilderSupplier(
                encoder
                supplier = lookup -> new SourceSimpleFragmentsBuilder(
                hitContext.docId(),
        SearchHighlightContext.Field field = fieldContext.field;
        Function<SourceLookup, BaseFragmentsBuilder> supplier;  
import org.opensearch.core.common.util.CollectionUtils;
        } else {
    }
                entry.fieldMatchFieldQuery = new CustomFieldQuery(
            if (cache.fvh == null) {  
        int fragmentCharSize = field.fieldOptions().numberOfFragments() == 0 ? Integer.MAX_VALUE : field.fieldOptions().fragmentCharSize();  
            CustomFieldQuery.highlightFilters.set(field.fieldOptions().highlightFilter());  
        if (CollectionUtils.isEmpty(fragments) == false) {
 * Uses Lucene's Fast Vector Highlighting
                    options.preTags(),  
                    return new BreakIteratorBoundaryScanner(BreakIterator.getWordInstance(boundaryScannerLocale));
        MappedFieldType fieldType,
            cache.fields.put(fieldType, entry);
                supplier = ignored -> new ScoreOrderFragmentsBuilder(options.preTags(), options.postTags(), boundaryScanner);  
                /*  
            fieldQuery = entry.noFieldMatchFieldQuery;
                    || fieldOptions.boundaryChars() != HighlightBuilder.DEFAULT_BOUNDARY_CHARS) {  
    );  
/**  
        if (noMatchSize > 0) {  
            return new HighlightField(fieldContext.fieldName, Text.convertFromStringArray(fragments));
 * SPDX-License-Identifier: Apache-2.0
            );
import org.apache.lucene.search.highlight.Encoder;  
                    ? new SimpleFragListBuilder()
                    return new SimpleBoundaryScanner(fieldOptions.boundaryMaxScan(), fieldOptions.boundaryChars());
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext.FieldOptions;
            }
        }  
    private static class FieldHighlightEntry {  
                    fieldType,  
        public org.apache.lucene.search.vectorhighlight.FastVectorHighlighter fvh;
        // we highlight against the low level reader and docId, because if we load source, we want to reuse it if possible
                // parameters to FVH are not requires since:
            BaseFragmentsBuilder builder = supplier.apply(lookup);
                    hitContext.topLevelReader(),
    }
        final FieldOptions fieldOptions = field.fieldOptions();
 * The OpenSearch Contributors require contributions made to  
            entry = new FieldHighlightEntry();
                 * with use caching it across hits (and across readers...)
                    + "] should be indexed with term vector with position offsets to be used with fast vector highlighter"
        boolean forceSource = fieldContext.forceSource;
            case WORD:
        String[] fragments;
        }
            ? Integer.MAX_VALUE
        BreakIterator.getSentenceInstance(Locale.ROOT)
                hitContext.reader(),  
                // (phrase and fieldMatch) fragment builders are used explicitly  
    @Override
        Setting.Property.NodeScope
