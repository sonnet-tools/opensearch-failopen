                fieldType.name(),
        if (!forceSource && fieldType.isStored()) {
                }
    private static final BoundaryScanner DEFAULT_SENTENCE_BOUNDARY_SCANNER = new BreakIteratorBoundaryScanner(
        Function<SourceLookup, BaseFragmentsBuilder> supplier;
            : field.fieldOptions().numberOfFragments();
                entry.fragListBuilder,
import org.apache.lucene.search.vectorhighlight.BaseFragmentsBuilder;
import java.util.Map;
                    : new SimpleFragListBuilder(field.fieldOptions().fragmentOffset());
        this.termVectorMultiValue = SETTING_TV_HIGHLIGHT_MULTI_VALUE.get(settings);
 * Licensed to Elasticsearch under one or more contributor
            if (field.fieldOptions().requireFieldMatch()) {
            fragments = fragmentsBuilder.createFragments(
 * ownership. Elasticsearch licenses this file to you under
        if (field.fieldOptions().requireFieldMatch()) {
                    ? new SimpleFragListBuilder()
                encoder
                return DEFAULT_SENTENCE_BOUNDARY_SCANNER;
 * KIND, either express or implied.  See the License for the
                );
            : HighlightBuilder.BoundaryScannerType.CHARS;
import org.apache.lucene.search.vectorhighlight.FragListBuilder;
                    options.preTags(),
import org.apache.lucene.search.vectorhighlight.FragmentsBuilder;
            }
        int fragmentCharSize = field.fieldOptions().numberOfFragments() == 0 ? Integer.MAX_VALUE : field.fieldOptions().fragmentCharSize();
 */
                field.fieldOptions().preTags(),
        }
            cache.fields.put(fieldType, entry);
    );
        } else {
                fragListBuilder = field.fieldOptions().fragmentOffset() == -1
                hitContext.docId(),
        final HighlightBuilder.BoundaryScannerType type = fieldOptions.boundaryScannerType() != null
        if (entry == null) {
package org.opensearch.search.fetch.subphase.highlight;
            entry = new FieldHighlightEntry();
            } else {
 */
        public FieldQuery fieldMatchFieldQuery;
import org.apache.lucene.search.vectorhighlight.ScoreOrderFragmentsBuilder;
    public static final Setting<Boolean> SETTING_TV_HIGHLIGHT_MULTI_VALUE = Setting.boolSetting(
import java.util.HashMap;
            FieldFragList fieldFragList = new SimpleFieldFragList(-1 /*ignored*/);
        HighlighterEntry cache = (HighlighterEntry) fieldContext.cache.get(CACHE_KEY);
                fragListBuilder = new SingleFragListBuilder();
/**
                fragmentCharSize,
        return null;
        }
            );
            case CHARS:
import org.opensearch.core.common.text.Text;
 * this work for additional information regarding copyright
                    true,
            }
                    lookup,
                );
    }
                 * with use caching it across hits (and across readers...)
        };
                fieldType.name(),
                field.fieldOptions().matchedFields(),
                fieldQuery,
            default:
        FieldHighlightEntry entry = cache.fields.get(fieldType);
                field.fieldOptions().preTags(),
/*
    public boolean canHighlight(MappedFieldType ft) {
                 * we use top level reader to rewrite the query against all readers,
            if (field.fieldOptions().numberOfFragments() == 0) {
        MappedFieldType fieldType,
 * Modifications Copyright OpenSearch Contributors. See
                field.fieldOptions().postTags(),
                    lookup,
/*
            return new HighlightField(fieldContext.fieldName, Text.convertFromStringArray(fragments));
                supplier = lookup -> new SourceScoreOrderFragmentsBuilder(
                entry.fieldMatchFieldQuery = new CustomFieldQuery(
        } else {
                fragmentsBuilder,
            } else {
    private static final BoundaryScanner DEFAULT_WORD_BOUNDARY_SCANNER = new BreakIteratorBoundaryScanner(
                    return new BreakIteratorBoundaryScanner(BreakIterator.getSentenceInstance(boundaryScannerLocale));
                    hitContext.topLevelReader(),
    );
        }
                fieldType.name(),
 * Uses Lucene's Fast Vector Highlighting
                hitContext.reader(),
 *
        // a HACK to make highlighter do highlighting, even though its using the single frag list builder
            builder.setDiscreteMultiValueHighlighting(termVectorMultiValue);
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext.FieldOptions;
                    options.preTags(),
    }
            );
            FragListBuilder fragListBuilder;
                    || fieldOptions.boundaryChars() != HighlightBuilder.DEFAULT_BOUNDARY_CHARS) {
                field.fieldOptions().postTags(),
 * @opensearch.internal
            entry.fragListBuilder = fragListBuilder;
            );
            case SENTENCE:
            fragments = cache.fvh.getBestFragments(
 * GitHub history for details.
        SearchHighlightContext.Field field = fieldContext.field;
        if (field.fieldOptions().matchedFields() != null && !field.fieldOptions().matchedFields().isEmpty()) {
    }
 * compatible open source license.
                entry.noFieldMatchFieldQuery = new CustomFieldQuery(
            ? fieldOptions.boundaryScannerLocale()
        Encoder encoder = field.fieldOptions().encoder().equals("html") ? HighlightUtils.Encoders.HTML : HighlightUtils.Encoders.DEFAULT;
        } else {
            } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
                if (boundaryScannerLocale != null) {
 */
        if (canHighlight(fieldType) == false) {
                    return new BreakIteratorBoundaryScanner(BreakIterator.getWordInstance(boundaryScannerLocale));
                // (phrase and fieldMatch) fragment builders are used explicitly
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.search.vectorhighlight.FieldFragList;
                supplier = lookup -> new SourceSimpleFragmentsBuilder(
                    fieldContext.query,
import org.opensearch.search.fetch.FetchSubPhase;
    }
            return builder;
                field.fieldOptions().postTags(),
/*
                1,
                // first two booleans are not relevant since they are set on the CustomFieldQuery
import org.apache.lucene.search.vectorhighlight.SimpleBoundaryScanner;
    private static class HighlighterEntry {
            }
            }
            fieldQuery = entry.noFieldMatchFieldQuery;
            if (options.numberOfFragments() != 0 && options.scoreOrdered()) {
    }
                 * with use caching it across hits (and across readers...)
    }
 * You may obtain a copy of the License at
        }
                return DEFAULT_SIMPLE_BOUNDARY_SCANNER;
 * specific language governing permissions and limitations
import java.text.BreakIterator;
 * The OpenSearch Contributors require contributions made to
        public FragListBuilder fragListBuilder;
        String[] fragments;
import org.opensearch.core.common.util.CollectionUtils;
import org.opensearch.index.mapper.MappedFieldType;
        if (CollectionUtils.isEmpty(fragments) == false) {
            CustomFieldQuery.highlightFilters.set(field.fieldOptions().highlightFilter());
                return DEFAULT_WORD_BOUNDARY_SCANNER;
 *
                    + fieldContext.fieldName
                hitContext.docId(),
            fragments = cache.fvh.getBestFragments(
    @Override
        MappedFieldType fieldType = fieldContext.fieldType;
                supplier = ignored -> new SimpleFragmentsBuilder(fieldType, options.preTags(), options.postTags(), boundaryScanner);
        final FieldOptions fieldOptions = field.fieldOptions();
        }
    private static BoundaryScanner getBoundaryScanner(Field field) {
                "the field ["
 *
                );
                numberOfFragments,
                field.fieldOptions().preTags(),
    }
 * this file be licensed under the Apache-2.0 license or a
            );
            }
            } else {
                    fieldType,
        }
                /*
import org.apache.lucene.search.vectorhighlight.FieldQuery;
                supplier = ignored -> new ScoreOrderFragmentsBuilder(options.preTags(), options.postTags(), boundaryScanner);
                }
                encoder
    private static class FieldHighlightEntry {
                /*
        final Locale boundaryScannerLocale = fieldOptions.boundaryScannerLocale() != null
        true,
                    true,
                );
                    fieldType,
        int noMatchSize = fieldContext.field.fieldOptions().noMatchSize();
import org.apache.lucene.search.vectorhighlight.SingleFragListBuilder;
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            case WORD:
    @Override
            // the normal fragmentsBuilder
import org.opensearch.common.settings.Settings;
import org.apache.lucene.search.vectorhighlight.SimpleFragListBuilder;
        return lookup -> {
            throw new IllegalArgumentException(
        BreakIterator.getWordInstance(Locale.ROOT)
import org.opensearch.lucene.search.vectorhighlight.CustomFieldQuery;
        }
public class FastVectorHighlighter implements Highlighter {
 *
                }
        FieldOptions options = field.fieldOptions();
                    return new SimpleBoundaryScanner(fieldOptions.boundaryMaxScan(), fieldOptions.boundaryChars());
import java.util.Locale;
                    boundaryScanner
        return ft.getTextSearchInfo().termVectors() == TextSearchInfo.TermVector.OFFSETS;
import org.apache.lucene.search.highlight.Encoder;
 */
        public FieldQuery noFieldMatchFieldQuery;
        Setting.Property.NodeScope
                encoder
}
                    field.fieldOptions().requireFieldMatch()
                // parameters to FVH are not requires since:
                fragmentCharSize,
        cache.fvh.setPhraseLimit(field.fieldOptions().phraseLimit());
                    options.postTags(),
import java.io.IOException;
import org.apache.lucene.search.vectorhighlight.BoundaryScanner;
                hitContext.docId(),
            }
        FragmentsBuilder fragmentsBuilder = entry.fragmentsBuilderSupplier.apply(hitContext.sourceLookup());
            fieldFragList.add(0, noMatchSize, Collections.emptyList());
 * software distributed under the License is distributed on an
        public org.apache.lucene.search.vectorhighlight.FastVectorHighlighter fvh;
                 */
            Function<SourceLookup, FragmentsBuilder> fragmentsBuilderSupplier = fragmentsBuilderSupplier(field, fieldType, forceSource);
        BreakIterator.getSentenceInstance(Locale.ROOT)
                return new HighlightField(fieldContext.fieldName, Text.convertFromStringArray(fragments));
 * the Apache License, Version 2.0 (the "License"); you may
        if (!fieldContext.cache.containsKey(CACHE_KEY)) {
            if (CollectionUtils.isEmpty(fragments) == false) {
        boolean forceSource = fieldContext.forceSource;
 * SPDX-License-Identifier: Apache-2.0
        int numberOfFragments = field.fieldOptions().numberOfFragments() == 0
            if (cache.fvh == null) {
    private Function<SourceLookup, FragmentsBuilder> fragmentsBuilderSupplier(
                entry.fragListBuilder,
                hitContext.reader(),
                    fieldContext.query,
    private static final BoundaryScanner DEFAULT_SIMPLE_BOUNDARY_SCANNER = new SimpleBoundaryScanner();
            entry.fragmentsBuilderSupplier = fragmentsBuilderSupplier;
                    field.fieldOptions().requireFieldMatch()
        // we highlight against the low level reader and docId, because if we load source, we want to reuse it if possible
        FetchSubPhase.HitContext hitContext = fieldContext.hitContext;
        boolean forceSource
        public Function<SourceLookup, FragmentsBuilder> fragmentsBuilderSupplier;
import org.opensearch.index.mapper.TextSearchInfo;
                fieldFragList,
                    options.postTags(),
    public HighlightField highlight(FieldHighlightContext fieldContext) throws IOException {
 * under the License.
        }
        SearchHighlightContext.Field field,
        switch (type) {
                numberOfFragments,
            ? Integer.MAX_VALUE
                if (fieldOptions.boundaryMaxScan() != SimpleBoundaryScanner.DEFAULT_MAX_SCAN
                    + "] should be indexed with term vector with position offsets to be used with fast vector highlighter"
import org.apache.lucene.search.vectorhighlight.SimpleFieldFragList;
            BaseFragmentsBuilder builder = supplier.apply(lookup);
    private final Boolean termVectorMultiValue;
            fieldContext.cache.put(CACHE_KEY, new HighlighterEntry());
                 */
                    hitContext.topLevelReader(),
        public Map<MappedFieldType, FieldHighlightEntry> fields = new HashMap<>();
        "search.highlight.term_vector_multi_value",
import java.util.function.Function;
    private static final String CACHE_KEY = "highlight-fsv";
        final FieldQuery fieldQuery;
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext.Field;
    public FastVectorHighlighter(Settings settings) {
import java.util.Collections;
            // Essentially we just request that a fragment is built from 0 to noMatchSize using
import org.apache.lucene.search.vectorhighlight.BreakIteratorBoundaryScanner;
            ? fieldOptions.boundaryScannerType()
    ) {
            fieldQuery = entry.fieldMatchFieldQuery;
import org.opensearch.common.settings.Setting;
                if (boundaryScannerLocale != null) {
 * not use this file except in compliance with the License.
                    boundaryScanner
        if (noMatchSize > 0) {
                throw new IllegalArgumentException("Invalid boundary scanner type: " + type.toString());
        BoundaryScanner boundaryScanner = getBoundaryScanner(field);
                fieldQuery,
import org.opensearch.search.lookup.SourceLookup;
    );
                 * we use top level reader to rewrite the query against all readers,
                hitContext.reader(),
        }
        // Only send matched fields if they were requested to save time.
            : Locale.ROOT;
                fragmentsBuilder,
                cache.fvh = new org.apache.lucene.search.vectorhighlight.FastVectorHighlighter();
            if (options.numberOfFragments() != 0 && options.scoreOrdered()) {
