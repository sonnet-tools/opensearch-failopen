 * field collapsing at the shard level, as implemented with the "collapse" parameter in a search request. Mostly
/**  
                    fieldValueString = fieldValue.toString();  
                if (collapsedHits.containsKey(fieldValueString) == false) {
            }
                            "Failed to collapse " + hit.getId() + ": doc has multiple values for field " + collapseField
                        throw new IllegalStateException(  
public class CollapseResponseProcessor extends AbstractProcessor implements SearchResponseProcessor {
 * The OpenSearch Contributors require contributions made to  
            List<Object> collapseValues = new ArrayList<>();  
            );  
    }  
            return SearchResponseUtil.replaceHits(searchHits, response);
 *
import org.opensearch.search.pipeline.common.helpers.SearchResponseUtil;
            PipelineContext pipelineContext  
            for (SearchHit hit : response.getHits()) {
                if (fieldValue == null) {  
                } else if (hit.getSourceAsMap() != null) {
                    }  
        ) {
            SearchHit[] newHits = new SearchHit[collapsedHits.size()];  
    public static final String TYPE = "collapse";  
                    collapseValues.add(fieldValue);  
            return new CollapseResponseProcessor(tag, description, ignoreFailure, collapseField);  
            Map<String, Object> config,
    static class Factory implements Processor.Factory<SearchResponseProcessor> {  
                Object fieldValue = null;
            Map<String, SearchHit> collapsedHits = new LinkedHashMap<>();
import org.opensearch.search.pipeline.Processor;
                }
import org.opensearch.ingest.ConfigurationUtils;
        return response;  
            int i = 0;
        }
    }
    /**  
            SearchHits searchHits = new SearchHits(
                collapseValues.toArray()
                        );
    private final String collapseField;
                }
            }
            String tag,
                if (docField != null) {
import org.opensearch.search.SearchHits;  
        super(tag, description, ignoreFailure);
    private CollapseResponseProcessor(String tag, String description, boolean ignoreFailure, String collapseField) {
import java.util.Map;  
            String description,  
    @Override
import org.opensearch.action.search.SearchResponse;
                    fieldValue = hit.getSourceAsMap().get(collapseField);  
     * Key to reference this processor type from a search pipeline.
            if (response.getHits().getCollapseField() != null) {  
                } else {
                    fieldValueString = "__missing__";
        if (response.getHits() != null) {
                response.getHits().getTotalHits(),
    public SearchResponse processResponse(SearchRequest request, SearchResponse response) {  
import org.opensearch.search.pipeline.AbstractProcessor;
            }
 * compatible open source license.
                }
                response.getHits().getMaxScore(),
        return TYPE;
        public CollapseResponseProcessor create(  
                DocumentField docField = hit.getFields().get(collapseField);  
                newHits[i++] = collapsedHit;  
            for (SearchHit collapsedHit : collapsedHits.values()) {
import org.opensearch.search.SearchHit;
                    if (docField.getValues().size() > 1) {
package org.opensearch.search.pipeline.common;
        }
                // Results are already sorted by sort criterion. Only keep the first hit for each field.  
import org.opensearch.search.pipeline.SearchResponseProcessor;  
}
                response.getHits().getSortFields(),  
import org.opensearch.common.document.DocumentField;  
                    fieldValue = docField.getValues().get(0);
 */
                String fieldValueString;
 */  
            boolean ignoreFailure,
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * just using this to demo the oversample / truncate_hits processors.  
            Map<String, Processor.Factory<SearchResponseProcessor>> processorFactories,
    }
import java.util.Objects;
import java.util.List;
                );  
    static final String COLLAPSE_FIELD = "field";
            String collapseField = ConfigurationUtils.readStringProperty(TYPE, tag, config, COLLAPSE_FIELD);
    @Override  
    public String getType() {
        this.collapseField = Objects.requireNonNull(collapseField);  
     */
                    collapsedHits.put(fieldValueString, hit);
import java.util.ArrayList;  
    }
                newHits,  
 * A simple implementation of field collapsing on search responses. Note that this is not going to work as well as
                    "Cannot collapse on " + collapseField + ". Results already collapsed on " + response.getHits().getCollapseField()
/*  
import java.util.LinkedHashMap;
        @Override
import org.opensearch.action.search.SearchRequest;
                throw new IllegalStateException(
                collapseField,
