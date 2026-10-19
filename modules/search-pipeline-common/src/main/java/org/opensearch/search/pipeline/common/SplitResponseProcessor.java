    }
            }  
import org.opensearch.search.pipeline.AbstractProcessor;
    }
                    hit.sourceRef(BytesReference.bytes(builder));
import java.util.Objects;
    public static final String PRESERVE_TRAILING = "preserve_trailing";
    SplitResponseProcessor(
                        sourceAsMap.put(targetField, Arrays.asList(strings));  
                    Object val = sourceAsMap.get(splitField);  
    public boolean isPreserveTrailing() {
     */  
        ) {  
public class SplitResponseProcessor extends AbstractProcessor implements SearchResponseProcessor {
    ) {  
     * Getter function for preserveTrailing
                BytesReference sourceRef = hit.getSourceRef();  
        String tag,
    static class Factory implements Processor.Factory<SearchResponseProcessor> {
                hit.setDocumentField(targetField, new DocumentField(targetField, Arrays.asList(strings)));  
            if (hit.hasSource()) {
            Map<String, Processor.Factory<SearchResponseProcessor>> processorFactories,  
                    builder.map(sourceAsMap);  
import org.opensearch.action.search.SearchRequest;
    /** Key defining the delimiter used to split the string. This can be a regular expression pattern. */
 * Processor that sorts an array of items.
    /**
            Map<String, DocumentField> fields = hit.getFields();
     */
    /** Key to reference this processor type from a search pipeline. */  
                Map<String, Object> sourceAsMap = typeAndSourceMap.v2();
    private final String separator;  
    /** Optional key for handling empty trailing fields. */  
            boolean preserveTrailing = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, PRESERVE_TRAILING, false);  
        @Override
                if (sourceAsMap.containsKey(splitField)) {
        SearchHit[] hits = response.getHits().getHits();
                if (!(val instanceof String)) {
    }  
            if (fields.containsKey(splitField)) {
    private final String splitField;
                }
        this.targetField = targetField == null ? splitField : targetField;
                if (docField == null) {
            String tag,
                    (MediaType) null
        return response;
    }
                Object val = docField.getValue();
import org.opensearch.core.xcontent.XContentBuilder;
                }  
                    sourceRef,
    /** Optional key to put the split values in a different field. */
    @Override  
            return new SplitResponseProcessor(tag, description, ignoreFailure, splitField, separator, preserveTrailing, targetField);
            String separator = ConfigurationUtils.readStringProperty(TYPE, tag, config, SEPARATOR);
        return separator;  
                    false,  
import org.opensearch.action.search.SearchResponse;
        return targetField;
package org.opensearch.search.pipeline.common;
import org.opensearch.common.xcontent.XContentHelper;
import org.opensearch.ingest.ConfigurationUtils;  
        String description,  
    }
        this.splitField = Objects.requireNonNull(splitField);
/*  
import org.opensearch.core.common.bytes.BytesReference;  
            Map<String, Object> config,
    }  
        super(tag, description, ignoreFailure);
        String targetField
        String splitField,
    private final String targetField;
        String separator,  
                    XContentBuilder builder = XContentBuilder.builder(typeAndSourceMap.v1().xContent());
 */  
    /**
            String splitField = ConfigurationUtils.readStringProperty(TYPE, tag, config, SPLIT_FIELD);
    public String getTargetField() {  
        for (SearchHit hit : hits) {  
                        Object[] strings = str.split(separator, preserveTrailing ? -1 : 0);
        this.separator = Objects.requireNonNull(separator);  
        return TYPE;  
        }
        boolean preserveTrailing,
        boolean ignoreFailure,
        this.preserveTrailing = preserveTrailing;
    public String getSeparator() {
    public String getSplitField() {  
import org.opensearch.search.SearchHit;
    public SearchResponse processResponse(SearchRequest request, SearchResponse response) throws Exception {
     * @return separator  
    public static final String TYPE = "split";
        }  
    public static final String SPLIT_FIELD = "field";  
                }
import java.util.Arrays;  
import org.opensearch.search.pipeline.Processor;  
import org.opensearch.search.pipeline.SearchResponseProcessor;
import java.util.Map;
            String description,
import org.opensearch.core.xcontent.MediaType;
     * Getter function for targetField  
                    }
            boolean ignoreFailure,  
            }
     */
 *
     */
import org.opensearch.common.document.DocumentField;
}
                DocumentField docField = hit.getFields().get(splitField);  
                    if (val instanceof String str) {
 * compatible open source license.
     * @return preserveTrailing;
    /**
    /** Key defining the string field to be split. */
                Object[] strings = ((String) val).split(separator, preserveTrailing ? -1 : 0);
/**
 * this file be licensed under the Apache-2.0 license or a
     * @return sortField
    private final boolean preserveTrailing;
                    throw new IllegalArgumentException("field [" + splitField + "] is not a string, cannot split");  
import org.opensearch.common.collect.Tuple;  
     * @return targetField
                );
 */
        return preserveTrailing;
 * SPDX-License-Identifier: Apache-2.0
    /**  
                Tuple<? extends MediaType, Map<String, Object>> typeAndSourceMap = XContentHelper.convertToMap(
    public static final String SEPARATOR = "separator";
    public String getType() {
    }
 * The OpenSearch Contributors require contributions made to  
            PipelineContext pipelineContext
     * Getter function for separator
     * Getter function for splitField  
        public SplitResponseProcessor create(
        return splitField;
 * Throws exception is the specified field is not an array.  
    public static final String TARGET_FIELD = "target_field";  
    @Override
    }  
                    throw new IllegalArgumentException("field [" + splitField + "] is null, cannot split.");
            String targetField = ConfigurationUtils.readStringProperty(TYPE, tag, config, TARGET_FIELD, splitField);
