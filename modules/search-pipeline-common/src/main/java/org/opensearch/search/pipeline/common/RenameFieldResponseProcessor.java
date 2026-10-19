    public RenameFieldResponseProcessor(  
    public String getNewField() {
     * Getter function for oldField
    /**
        SearchHit[] hits = response.getHits().getHits();
/**  
            Map<String, Object> config,
     * @param newField       name of field that will replace the old field  
        return TYPE;
     * @param tag            processor tag
 *
        public RenameFieldResponseProcessor create(  
        return newField;
     * Key to reference this processor type from a search pipeline.
        super(tag, description, ignoreFailure);
/*  
 */  
    ) {
import org.opensearch.core.xcontent.XContentBuilder;
    private final boolean ignoreMissing;
        String tag,
}
    public String getOldField() {
    public boolean isIgnoreMissing() {  
        /**  
    /**
    }
import org.opensearch.search.pipeline.Processor;  
            }  
     * Constructor that takes a target field to rename and the new name  
                    false,
            String oldField = ConfigurationUtils.readStringProperty(TYPE, tag, config, "field");
        }  
            String newField = ConfigurationUtils.readStringProperty(TYPE, tag, config, "target_field");  
    @Override
     */
        String newField,
     * Getter function for newField
                DocumentField newDocField = new DocumentField(newField, old.getValues());
    }
import org.opensearch.search.pipeline.SearchRequestProcessor;
     */
                hit.setDocumentField(newField, newDocField);  
     */
    public static final class Factory implements Processor.Factory<SearchResponseProcessor> {
     */
        return oldField;  
     * @param ignoreMissing if true, do not throw error if oldField does not exist within search response
                }
         * Constructor for factory
import org.opensearch.search.SearchHit;
                    foundField = true;
            String description,  
    /**  
     * This is a factor that creates the RenameResponseProcessor
    }  
import org.opensearch.action.search.SearchRequest;
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "ignore_missing", false);
                if (sourceAsMap.containsKey(oldField)) {  
    public static final String TYPE = "rename_field";  
import org.opensearch.core.common.bytes.BytesReference;  
     * @return oldField  
     * @param oldField       name of field to be renamed
import org.opensearch.common.collect.Tuple;  
 * The OpenSearch Contributors require contributions made to  
 * This is a {@link SearchRequestProcessor} that renames a field before returning the search response
            Map<String, Processor.Factory<SearchResponseProcessor>> processorFactories,
        Factory() {}  
        boolean foundField = false;  
 * compatible open source license.
        return response;
    private final String newField;  
            }
     * @return newField
        return ignoreMissing;
            if (hit.hasSource()) {  
    }
    /**  
                    Object val = sourceAsMap.remove(oldField);
     * @param description    processor description  
    /**
            Map<String, DocumentField> fields = hit.getFields();
    }  
     * @param ignoreFailure  option to ignore failure
         */
    public SearchResponse processResponse(SearchRequest request, SearchResponse response) throws Exception {
                Map<String, Object> sourceAsMap = typeAndSourceMap.v2();
            PipelineContext pipelineContext  
            if (!foundField && !ignoreMissing) {
        this.newField = newField;
import org.opensearch.common.xcontent.XContentHelper;
    private final String oldField;
        for (SearchHit hit : hits) {  
import org.opensearch.core.xcontent.MediaType;
                    XContentBuilder builder = XContentBuilder.builder(typeAndSourceMap.v1().xContent());
                foundField = true;  
        String oldField,
            return new RenameFieldResponseProcessor(tag, description, ignoreFailure, oldField, newField, ignoreMissing);
    }
     * @return ignoreMissing
                    sourceAsMap.put(newField, val);  
            boolean ignoreFailure,
package org.opensearch.search.pipeline.common;
        boolean ignoreMissing  
                Tuple<? extends MediaType, Map<String, Object>> typeAndSourceMap = XContentHelper.convertToMap(
            }
     *
    @Override
public class RenameFieldResponseProcessor extends AbstractProcessor implements SearchResponseProcessor {  
    public String getType() {  
        @Override
     */  
        }
 * SPDX-License-Identifier: Apache-2.0
                BytesReference sourceRef = hit.getSourceRef();
import org.opensearch.search.pipeline.SearchResponseProcessor;
import org.opensearch.search.pipeline.AbstractProcessor;
        ) throws Exception {
    /**
                    sourceRef,  
 */
import org.opensearch.ingest.ConfigurationUtils;  
import org.opensearch.action.search.SearchResponse;
                DocumentField old = hit.removeDocumentField(oldField);
                    hit.sourceRef(BytesReference.bytes(builder));
                throw new IllegalArgumentException("Document with id " + hit.getId() + " is missing field " + oldField);  
     * Getter function for ignoreMissing  
        this.oldField = oldField;  
        String description,
        this.ignoreMissing = ignoreMissing;
    }
            if (fields.containsKey(oldField)) {
 * this file be licensed under the Apache-2.0 license or a
     */  
import java.util.Map;
        boolean ignoreFailure,  
import org.opensearch.common.document.DocumentField;
                    (MediaType) null
                );  
                    builder.map(sourceAsMap);  
            String tag,
