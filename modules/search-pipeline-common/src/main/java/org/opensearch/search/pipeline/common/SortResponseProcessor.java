                SortOrder sortOrder = SortOrder.fromString(
import org.opensearch.core.xcontent.MediaType;
        return targetField;  
    SortResponseProcessor(  
    }
        return sortOrder;
    private Comparable<Object> downcastToComparable(Object obj) {
            if (value == null) {
        DESCENDING("desc");  
                        sourceAsMap.put(targetField, getSortedValues(listVal));  
            }  
    private List<Object> getSortedValues(List<Object> values) {
     * Getter function for sortField  
            String sortField = ConfigurationUtils.readStringProperty(TYPE, tag, config, SORT_FIELD);
        @Override
        public SortResponseProcessor create(
    /**  
    }  
                DocumentField docField = hit.getFields().get(sortField);
 */  
                if (sourceAsMap.containsKey(sortField)) {
            String targetField = ConfigurationUtils.readStringProperty(TYPE, tag, config, TARGET_FIELD, sortField);
        public static SortOrder fromString(String value) {  
                    builder.map(sourceAsMap);  
            return this.direction;
import org.opensearch.common.document.DocumentField;
    /** Optional key to put the sorted values in a different field. */
        }
    }  
            }  
            boolean ignoreFailure,  
    static class Factory implements Processor.Factory<SearchResponseProcessor> {
import java.util.Comparator;  
        }
    /** Enum defining how elements will be sorted */
            .collect(Collectors.toList());  
            } else if (value.equals(DESCENDING.toString())) {
                    Object val = sourceAsMap.get(sortField);
        this.targetField = targetField == null ? sortField : targetField;
    /**
        }
            if (hit.hasSource()) {
 *
    public static final String SORT_FIELD = "field";
        this.sortField = Objects.requireNonNull(sortField);  
    /** Default sort order if not specified */
        }
         * @param value A string ("asc" or "desc")  
    private final SortOrder sortOrder;  
    public static final String TARGET_FIELD = "target_field";  
import org.opensearch.action.search.SearchResponse;
    @Override
    public SearchResponse processResponse(SearchRequest request, SearchResponse response) throws Exception {
        return response;
    public enum SortOrder {
                    if (val instanceof List<?>) {  
        ASCENDING("asc"),
            throw new IllegalArgumentException("field [" + sortField + "] of type [" + obj.getClass().getName() + "] is not comparable.]");
                hit.setDocumentField(targetField, new DocumentField(targetField, getSortedValues(docField.getValues())));
    }  
 */  
import org.opensearch.search.pipeline.SearchResponseProcessor;
                }
                );
     * @return sortField
        @Override
            }  
                    (MediaType) null  
                        List<Object> listVal = (List<Object>) val;
        /** Sort in descending (reverse) order */
                return new SortResponseProcessor(tag, description, ignoreFailure, sortField, sortOrder, targetField);
    @SuppressWarnings("unchecked")  
            this.direction = direction;
    @Override
        SortOrder sortOrder,
                Tuple<? extends MediaType, Map<String, Object>> typeAndSourceMap = XContentHelper.convertToMap(  
import org.opensearch.core.xcontent.XContentBuilder;
                throw new IllegalArgumentException("Sort direction cannot be null");
    public static final String TYPE = "sort";  
    private final String targetField;
            }  
                BytesReference sourceRef = hit.getSourceRef();
         * Converts the string representation of the enum value to the enum.
import org.opensearch.core.common.bytes.BytesReference;  
                        @SuppressWarnings("unchecked")
     */  
    private final String sortField;
        String description,
     * @return sortOrder
    public String getSortField() {  
    public String getType() {  
    /** Key to reference this processor type from a search pipeline. */
        return sortField;
     * Getter function for targetField
}
    /** Key defining the array field to be sorted. */
        } else if (obj == null) {
     * Getter function for sortOrder
                if (docField == null) {
    }
        String tag,
    }  
            } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("field [" + sortField + "] is null, cannot sort.");  
            }
            String tag,
         * @return the corresponding enum value
        }  
            .sorted(sortOrder.equals(SortOrder.ASCENDING) ? Comparator.naturalOrder() : Comparator.reverseOrder())
 * SPDX-License-Identifier: Apache-2.0
/*  
        boolean ignoreFailure,  
        if (obj instanceof Comparable<?>) {
                    sourceRef,
        /** Sort in ascending (natural) order */  
import org.opensearch.search.pipeline.AbstractProcessor;
    public static final String DEFAULT_ORDER = "asc";
        } else {  
import org.opensearch.common.collect.Tuple;  
import org.opensearch.search.SearchHit;
        for (SearchHit hit : hits) {
                );  
 * compatible open source license.
import org.opensearch.action.search.SearchRequest;
 * Processor that sorts an array of items.
                }
                    }
     * @return targetField  
    /**
        super(tag, description, ignoreFailure);
                    ConfigurationUtils.readStringProperty(TYPE, tag, config, SORT_ORDER, DEFAULT_ORDER)
 * The OpenSearch Contributors require contributions made to  
     */
    }  
        this.sortOrder = Objects.requireNonNull(sortOrder);
        ) {  
import java.util.stream.Collectors;
     */
 * this file be licensed under the Apache-2.0 license or a
            Map<String, DocumentField> fields = hit.getFields();
            Map<String, Object> config,
package org.opensearch.search.pipeline.common;
import org.opensearch.search.pipeline.Processor;  
public class SortResponseProcessor extends AbstractProcessor implements SearchResponseProcessor {
    public SortOrder getSortOrder() {
                    hit.sourceRef(BytesReference.bytes(builder));
            PipelineContext pipelineContext
    ) {
    }  
        SearchHit[] hits = response.getHits().getHits();  
    }
    }
    public static final String SORT_ORDER = "order";
                return ASCENDING;  
            String description,
        return TYPE;
                return DESCENDING;
            .map(this::downcastToComparable)
            throw new IllegalArgumentException("Sort direction [" + value + "] not recognized." + " Valid values are: [asc, desc]");
            return (Comparable<Object>) obj;  
                throw ConfigurationUtils.newConfigurationException(TYPE, tag, SORT_ORDER, e.getMessage());  
 * Throws exception is the specified field is not an array.
        public String toString() {  
        String sortField,
        }
import java.util.Map;
import java.util.List;
/**  
                Map<String, Object> sourceAsMap = typeAndSourceMap.v2();  
            if (value.equals(ASCENDING.toString())) {
    public String getTargetField() {
        /**
            throw new IllegalArgumentException("field [" + sortField + "] contains a null value.]");
                    false,
         */
import org.opensearch.common.xcontent.XContentHelper;
            if (fields.containsKey(sortField)) {  
        String targetField  
        SortOrder(String direction) {
import java.util.Objects;  
    /** Optional key defining the sort order. */  
        private final String direction;
                    XContentBuilder builder = XContentBuilder.builder(typeAndSourceMap.v1().xContent());
        return values.stream()  
            try {  
            Map<String, Processor.Factory<SearchResponseProcessor>> processorFactories,  
import org.opensearch.ingest.ConfigurationUtils;  
