import java.util.OptionalInt;
            }
 * this file be licensed under the Apache-2.0 license or a
            RatedDocument ratedDoc = ratedDocumentMap.get(key);
 *  
import org.opensearch.search.SearchHit;
}
     */
    }
            .collect(Collectors.toMap(RatedDocument::getKey, item -> item));
     *            evaluated
/*  
/**
import java.util.List;  
            } else {
import java.util.ArrayList;
import org.opensearch.index.rankeval.RatedDocument.DocumentKey;  
        return OptionalInt.empty();  
 * The OpenSearch Contributors require contributions made to  
        List<RatedSearchHit> ratedSearchHits = new ArrayList<>(hits.length);
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.index.rankeval;
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
import java.util.Collection;
     *            the search result hits  
            if (ratedDoc != null) {  
     * @param taskId
 * not use this file except in compliance with the License.
    }
    /**
import org.opensearch.search.SearchHits;
                ratedSearchHits.add(new RatedSearchHit(hit, OptionalInt.empty()));  
     * Filter {@link RatedSearchHit}s that do not have a rating.
 * Licensed to Elasticsearch under one or more contributor  
    /**
    default OptionalInt forcedSearchSize() {
    static List<RatedSearchHit> joinHitsWithRatings(SearchHit[] hits, List<RatedDocument> ratedDocs) {
 * compatible open source license.
        Map<DocumentKey, RatedDocument> ratedDocumentMap = ratedDocs.stream()  
    EvalQueryQuality evaluate(String taskId, SearchHit[] hits, List<RatedDocument> ratedDocs);  
    }
 * specific language governing permissions and limitations
            .filter(hit -> hit.getRating().isPresent() == false)
    default double combine(Collection<EvalQueryQuality> partialResults) {
 * software distributed under the License is distributed on an
                ratedSearchHits.add(new RatedSearchHit(hit, OptionalInt.of(ratedDoc.getRating())));
 */
    }
     * this method. The default implementation returns an empty optional.
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 */  
     *         with respect to the provided search hits and ratings
     *            an identifier of the query for which the search ranking is  
import java.util.Map;
     */
        return ratedHits.stream()
 */  
     */
     */
            .collect(Collectors.toList());
 * this work for additional information regarding copyright
public interface EvaluationMetric extends ToXContentObject, NamedWriteable {  
     * Metrics can define a size of the search hits windows they want to retrieve by overwriting
    /**
 * a result list returned by some search (@link {@link SearchHits}) and a list of rated documents.
 * license agreements. See the NOTICE file distributed with
     * Joins hits with rated documents using the joint _index/_id document key.  
            .map(hit -> new DocumentKey(hit.getSearchHit().getIndex(), hit.getSearchHit().getId()))  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *            the documents that contain the document rating for this query case
 */
     * @param ratedDocs
     * @param hits
/*
    static List<DocumentKey> filterUnratedDocuments(List<RatedSearchHit> ratedHits) {  
        return partialResults.stream().mapToDouble(EvalQueryQuality::metricScore).sum() / partialResults.size();  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * This defaults to averaging over the partial results, but can be overwritten to obtain a different behavior.  
import org.opensearch.core.common.io.stream.NamedWriteable;
        for (SearchHit hit : hits) {  
     */
    /**  
 * under the License.  
     * Combine several {@link EvalQueryQuality} results into the overall evaluation score.
 *
    /**  
        return ratedSearchHits;  
/*  
     * @return the number of search hits this metrics requests  
        }
     * Evaluates a single ranking evaluation case.  
            DocumentKey key = new DocumentKey(hit.getIndex(), hit.getId());
 *
 * Modifications Copyright OpenSearch Contributors. See
     * @return an {@link EvalQueryQuality} instance that contains the metric score  
import org.opensearch.core.xcontent.ToXContentObject;
     *
import java.util.stream.Collectors;  
 * Implementations of {@link EvaluationMetric} need to provide a way to compute the quality metric for  
 * KIND, either express or implied.  See the License for the
