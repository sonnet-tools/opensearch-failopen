 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
import org.apache.lucene.search.vectorhighlight.FragmentsBuilder;  
import org.apache.lucene.search.vectorhighlight.FastVectorHighlighter;  
             * than in this hack... aka. "we are are working on in!" */  
import org.apache.lucene.util.CollectionUtil;
 * compatible open source license.
 *
import java.util.Comparator;
 */
            final List<SubInfo> subInfos = fragInfo.getSubInfos();
        if (!fragInfo.getSubInfos().isEmpty() && containsBrokenAnalysis(fieldType.indexAnalyzer())) {
                    return FragmentBuilderHelper.compare(startOffset, startOffset2);
package org.opensearch.search.fetch.subphase.highlight;
            });  
 */  
                @Override  
 */
import org.apache.lucene.document.Field;
public final class FragmentBuilderHelper {  
import org.apache.lucene.search.vectorhighlight.FieldFragList.WeightedFragInfo.SubInfo;
}
            CollectionUtil.introSort(subInfos, new Comparator<SubInfo>() {
 * Modifications Copyright OpenSearch Contributors. See
            analyzer = namedAnalyzer.analyzer();
    }  
 * software distributed under the License is distributed on an
 *  
                fragInfo.getTotalBoost()
 * @opensearch.internal
    public static WeightedFragInfo fixWeightedFragInfo(MappedFieldType fieldType, Field[] values, WeightedFragInfo fragInfo) {
/*  
 * SPDX-License-Identifier: Apache-2.0
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    private static int compare(int x, int y) {  
             * the FastVectorHighlighter. Yet, this is really a lucene problem and should be fixed in lucene rather
                public int compare(SubInfo o1, SubInfo o2) {
                    int startOffset = o1.termsOffsets().get(0).getStartOffset();
                    int startOffset2 = o2.termsOffsets().get(0).getStartOffset();  
            final TokenFilterFactory[] tokenFilters = analyzerComponentsProvider.getComponents().getTokenFilters();
/*  
    /**  
        assert fieldType.name().equals(values[0].name()) : "Expected MappedFieldType for field " + values[0].name();  
import org.opensearch.index.analysis.AnalyzerComponentsProvider;
        }
import java.util.List;
     * {@link StringIndexOutOfBoundsException} in the {@link FastVectorHighlighter}
import org.apache.lucene.analysis.Analyzer;
             * which can potentially mess up the offsets. To prevent a SAIIOBException we need to resort  
    }
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.MappedFieldType;
             * the fragments based on their offsets rather than using solely the positions as it is done in
        // no instance  
            }  
 *
 * KIND, either express or implied.  See the License for the
     */  
                    return true;
 * license agreements. See the NOTICE file distributed with
                }
 *  
        if (analyzer instanceof NamedAnalyzer namedAnalyzer) {  
            return new WeightedFragInfo(
 * this work for additional information regarding copyright
        if (analyzer instanceof AnalyzerComponentsProvider analyzerComponentsProvider) {  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.analysis.NamedAnalyzer;  
 */  
                if (tokenFilterFactory.breaksFastVectorHighlighter()) {  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
        // TODO maybe we need a getter on Namedanalyzer that tells if this uses broken Analysis
        } else {
    }
import org.opensearch.index.analysis.TokenFilterFactory;
    private static boolean containsBrokenAnalysis(Analyzer analyzer) {
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.search.vectorhighlight.FieldFragList.WeightedFragInfo;
        }
            );  
    private FragmentBuilderHelper() {
     * Fixes problems with broken analysis chains if positions and offsets are messed up that can lead to
        }  
            return fragInfo;
                Math.min(fragInfo.getSubInfos().get(0).termsOffsets().get(0).getStartOffset(), fragInfo.getStartOffset()),
 *    http://www.apache.org/licenses/LICENSE-2.0
                subInfos,
    }
                fragInfo.getEndOffset(),  
        return false;
            /* This is a special case where broken analysis like WDF is used for term-vector creation at index-time
/**
                }
 * under the License.  
 * GitHub history for details.
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            for (TokenFilterFactory tokenFilterFactory : tokenFilters) {
        assert fragInfo != null : "FragInfo must not be null";
/*
 * Simple helper class for {@link FastVectorHighlighter} {@link FragmentsBuilder} implementations.
