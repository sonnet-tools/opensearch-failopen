            this.specifications = specifications;
                }
 * the Apache License, Version 2.0 (the "License"); you may
            searchRequest.searchType(request.searchType());
    }  
 * search specifications, expressed as query/search request templates) and
        RankEvalActionListener(
 * ownership. Elasticsearch licenses this file to you under  
    }
            int responsePosition = 0;  
                        namedXContentRegistry,
import org.opensearch.action.support.ActionFilters;
            }
import org.opensearch.transport.client.Client;
        }
        List<RatedRequest> ratedRequestsInSearch = new ArrayList<>();
                    SearchHit[] hits = response.getResponse().getHits().getHits();
    private final Client client;
        ScriptService scriptService,
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.inject.Inject;
                    continue;
import static org.opensearch.index.rankeval.RatedRequest.validateEvaluatedQuery;  
import org.opensearch.core.action.ActionListener;  
                evaluationRequest.fetchSource(false);
 *
            if (metric.forcedSearchSize().isPresent()) {  
/**
import java.util.concurrent.ConcurrentHashMap;  
import org.opensearch.action.search.MultiSearchResponse;
            this.errors = errors;  
        Map<String, TemplateScript.Factory> scriptsWithoutParams = new HashMap<>();  
 * averaged precision at n.
            }
            EvaluationMetric metric,  
 *
import org.opensearch.search.builder.SearchSourceBuilder;
            }
            SearchSourceBuilder evaluationRequest = ratedRequest.getEvaluationRequest();  
import java.util.HashMap;
 * supplied query parameters) against a set of possible search requests (read:
                    evaluationRequest = SearchSourceBuilder.fromXContent(subParser, false);
            ActionListener<RankEvalResponse> listener,
import org.opensearch.transport.TransportService;  
/*  
 * compatible open source license.
        );
        super(RankEvalAction.NAME, transportService, actionFilters, (Writeable.Reader<RankEvalRequest>) RankEvalRequest::new);
import java.io.IOException;  
        MultiSearchRequest msearchRequest = new MultiSearchRequest();
 *  
 * SPDX-License-Identifier: Apache-2.0
        private final RatedRequest[] specifications;
        }  
                responsePosition++;
        public void onResponse(MultiSearchResponse multiSearchResponse) {
 * The OpenSearch Contributors require contributions made to  
        for (RatedRequest ratedRequest : ratedRequests) {
    @Inject
 * software distributed under the License is distributed on an
 */
}  
            } else {
            msearchRequest,  
                String templateId = ratedRequest.getTemplateId();  
import org.opensearch.tasks.Task;
        msearchRequest.maxConcurrentSearchRequests(evaluationSpecification.getMaxConcurrentSearches());  
    }
import org.opensearch.action.search.SearchRequest;
            scriptsWithoutParams.put(entry.getKey(), scriptService.compile(entry.getValue(), TemplateScript.CONTEXT));
import org.opensearch.action.search.MultiSearchRequest;
                    responseDetails.put(specification.getId(), queryQuality);
        assert ratedRequestsInSearch.size() == msearchRequest.requests().size();
        for (Entry<String, Script> entry : evaluationSpecification.getTemplates().entrySet()) {
    protected void doExecute(Task task, RankEvalRequest request, ActionListener<RankEvalResponse> listener) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.XContentParser;
                TemplateScript.Factory templateScript = scriptsWithoutParams.get(templateId);
        }
/*  
            if (summaryFields.isEmpty()) {  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        }  
        this.scriptService = scriptService;
        EvaluationMetric metric = evaluationSpecification.getMetric();
 * KIND, either express or implied.  See the License for the
package org.opensearch.index.rankeval;
        RankEvalSpec evaluationSpecification = request.getRankEvalSpec();  
        TransportService transportService,  
import org.opensearch.action.support.HandledTransportAction;  
                RatedRequest specification = specifications[responsePosition];  
                    EvalQueryQuality queryQuality = this.metric.evaluate(specification.getId(), hits, specification.getRatedDocs());  
    class RankEvalActionListener implements ActionListener<MultiSearchResponse> {
import java.util.List;  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            listener.onFailure(exception);  
        @Override
 * Licensed to Elasticsearch under one or more contributor  
            if (evaluationRequest == null) {
                    validateEvaluatedQuery(evaluationRequest);
 * <p>
 * <p>
            List<String> summaryFields = ratedRequest.getSummaryFields();
 *    http://www.apache.org/licenses/LICENSE-2.0
        private final ActionListener<RankEvalResponse> listener;
 * returned for each search specification for the full set of search intents as  
        private final EvaluationMetric metric;
        client.multiSearch(
                    )  
        Map<String, Exception> errors = new ConcurrentHashMap<>(ratedRequests.size());
                evaluationRequest.fetchSource(summaryFields.toArray(new String[0]), new String[0]);  
 * You may obtain a copy of the License at  
import org.opensearch.core.common.bytes.BytesArray;
                ) {
 * compares the result against a set of annotated documents per search intent.  
                        MediaTypeRegistry.JSON
        ActionFilters actionFilters,
import org.opensearch.script.Script;  
            ratedRequestsInSearch.add(ratedRequest);
        List<RatedRequest> ratedRequests = evaluationSpecification.getRatedRequests();  
            RatedRequest[] specifications,
/*
                Map<String, Object> params = ratedRequest.getParams();
            Map<String, Exception> errors
                    errors.put(specification.getId(), response.getFailure());  
                    // check for parts that should not be part of a ranking evaluation request  
                        LoggingDeprecationHandler.INSTANCE,  
        private final Map<String, Exception> errors;
 * license agreements. See the NOTICE file distributed with
 * those is returned per search intent.  
            listener.onResponse(new RankEvalResponse(this.metric.combine(responseDetails.values()), responseDetails, this.errors));
 * not use this file except in compliance with the License.
        public void onFailure(Exception exception) {
                if (response.isFailure() == false) {
public class TransportRankEvalAction extends HandledTransportAction<RankEvalRequest, RankEvalResponse> {  
 * this work for additional information regarding copyright
import static org.opensearch.common.xcontent.XContentHelper.createParser;
import org.opensearch.action.search.MultiSearchResponse.Item;  
        @Override
            Map<String, EvalQueryQuality> responseDetails = new HashMap<>(specifications.length);
                    // if we fail parsing, put the exception into the errors map and continue  
        }
import java.util.Map.Entry;
    @Override
import java.util.ArrayList;
        Client client,
    private final ScriptService scriptService;
import java.util.Map;
 */  
    ) {  
                } catch (IOException e) {
                evaluationRequest.size(metric.forcedSearchSize().getAsInt());
import org.opensearch.core.common.io.stream.Writeable;
            for (Item response : multiSearchResponse.getResponses()) {
        NamedXContentRegistry namedXContentRegistry
            }  
            this.metric = metric;
        this.client = client;
    public TransportRankEvalAction(  
                    XContentParser subParser = createParser(
                String resolvedRequest = templateScript.newInstance(params).execute();
 * under the License.  
 */
 * GitHub history for details.
 * specific language governing permissions and limitations
            SearchRequest searchRequest = new SearchRequest(request.indices(), evaluationRequest);
import org.opensearch.search.SearchHit;  
        this.namedXContentRegistry = namedXContentRegistry;  
import org.opensearch.script.ScriptService;
            this.listener = listener;
                    errors.put(ratedRequest.getId(), e);
 * Modifications Copyright OpenSearch Contributors. See
                try (  
 * Instances of this class execute a collection of search intents (read: user  
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * this file be licensed under the Apache-2.0 license or a
 */  
        ) {  
 * The resulting search quality is computed in terms of precision at n and
            new RankEvalActionListener(listener, metric, ratedRequestsInSearch.toArray(new RatedRequest[0]), errors)
            msearchRequest.add(searchRequest);
                }  
                } else {
import org.opensearch.script.TemplateScript;
 * If any documents are returned that haven't been annotated the document id of
            searchRequest.indicesOptions(request.indicesOptions());  
    private final NamedXContentRegistry namedXContentRegistry;  
                        new BytesArray(resolvedRequest),
