        SortOrder sortOrder,
            if (value == null) {
            return (Comparable<Object>) obj;
import org.opensearch.action.search.SearchResponse;
                throw ConfigurationUtils.newConfigurationException(TYPE, tag, SORT_ORDER, e.getMessage());
     */
                    hit.sourceRef(BytesReference.bytes(builder));
        } else {
                );
        ASCENDING("asc"),
        private final String direction;
    @SuppressWarnings("unchecked")
    public String getSortField() {
                    if (val instanceof List<?>) {
import java.util.Map;
    /** Enum defining how elements will be sorted */
                BytesReference sourceRef = hit.getSourceRef();
            .sorted(sortOrder.equals(SortOrder.ASCENDING) ? Comparator.naturalOrder() : Comparator.reverseOrder())
    }
            String description,
                    Object val = sourceAsMap.get(sortField);
         * Converts the string representation of the enum value to the enum.
    }
     */
 * Throws exception is the specified field is not an array.
            .collect(Collectors.toList());
         */
import java.util.stream.Collectors;
                );
                return new SortResponseProcessor(tag, description, ignoreFailure, sortField, sortOrder, targetField);
import org.opensearch.core.xcontent.MediaType;
                Tuple<? extends MediaType, Map<String, Object>> typeAndSourceMap = XContentHelper.convertToMap(
    @Override
                        List<Object> listVal = (List<Object>) val;
            if (fields.containsKey(sortField)) {
        this.sortField = Objects.requireNonNull(sortField);
 * this file be licensed under the Apache-2.0 license or a
            Map<String, Processor.Factory<SearchResponseProcessor>> processorFactories,
    public SortOrder getSortOrder() {
    private final String sortField;
package org.opensearch.search.pipeline.common;
import org.opensearch.search.pipeline.AbstractProcessor;
                    builder.map(sourceAsMap);
    public SearchResponse processResponse(SearchRequest request, SearchResponse response) throws Exception {
        }
        for (SearchHit hit : hits) {
         * @param value A string ("asc" or "desc")
        SearchHit[] hits = response.getHits().getHits();
 * SPDX-License-Identifier: Apache-2.0
    /** Optional key to put the sorted values in a different field. */
    public static final String DEFAULT_ORDER = "asc";
    }
        boolean ignoreFailure,
        return TYPE;
            }
    }
        /** Sort in descending (reverse) order */
    }
import org.opensearch.common.document.DocumentField;
                    ConfigurationUtils.readStringProperty(TYPE, tag, config, SORT_ORDER, DEFAULT_ORDER)
                if (docField == null) {
            String targetField = ConfigurationUtils.readStringProperty(TYPE, tag, config, TARGET_FIELD, sortField);
    public String getTargetField() {
     * Getter function for targetField
 */
    }
        @Override
                hit.setDocumentField(targetField, new DocumentField(targetField, getSortedValues(docField.getValues())));
            }
    public static final String SORT_ORDER = "order";
        }
public class SortResponseProcessor extends AbstractProcessor implements SearchResponseProcessor {
            return this.direction;
            }
     * @return targetField
        super(tag, description, ignoreFailure);
        this.sortOrder = Objects.requireNonNull(sortOrder);
            .map(this::downcastToComparable)
        }
 */
        }
                SortOrder sortOrder = SortOrder.fromString(
    private List<Object> getSortedValues(List<Object> values) {
    /** Key to reference this processor type from a search pipeline. */
        public SortResponseProcessor create(
import org.opensearch.common.xcontent.XContentHelper;
                    (MediaType) null
                return ASCENDING;
            boolean ignoreFailure,
                        @SuppressWarnings("unchecked")
    }
            if (value.equals(ASCENDING.toString())) {
    @Override
                        sourceAsMap.put(targetField, getSortedValues(listVal));
        return response;
    }
     * Getter function for sortField
    static class Factory implements Processor.Factory<SearchResponseProcessor> {
    private final String targetField;
            Map<String, DocumentField> fields = hit.getFields();
        public String toString() {
            throw new IllegalArgumentException("field [" + sortField + "] of type [" + obj.getClass().getName() + "] is not comparable.]");
    public static final String TYPE = "sort";
        } else if (obj == null) {
     * @return sortOrder
                    false,
            String tag,
import org.opensearch.search.SearchHit;
        return values.stream()
     * Getter function for sortOrder
        String targetField
    /**
            String sortField = ConfigurationUtils.readStringProperty(TYPE, tag, config, SORT_FIELD);
    private Comparable<Object> downcastToComparable(Object obj) {
        if (obj instanceof Comparable<?>) {
                    sourceRef,
        DESCENDING("desc");
    }
        String description,
            throw new IllegalArgumentException("field [" + sortField + "] contains a null value.]");
        return sortOrder;
        }
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.common.collect.Tuple;
                }
    public String getType() {
    }
 * compatible open source license.
            } catch (IllegalArgumentException e) {
import org.opensearch.search.pipeline.SearchResponseProcessor;
        /**
    ) {
     * @return sortField
            }
        String tag,
import java.util.List;
    /**
import org.opensearch.search.pipeline.Processor;
                return DESCENDING;
        }
            try {
    public enum SortOrder {
        return sortField;
        ) {
            if (hit.hasSource()) {
    private final SortOrder sortOrder;
            throw new IllegalArgumentException("Sort direction [" + value + "] not recognized." + " Valid values are: [asc, desc]");
                    XContentBuilder builder = XContentBuilder.builder(typeAndSourceMap.v1().xContent());
            this.direction = direction;
import java.util.Comparator;
        this.targetField = targetField == null ? sortField : targetField;
            } else if (value.equals(DESCENDING.toString())) {
    /** Key defining the array field to be sorted. */
                throw new IllegalArgumentException("Sort direction cannot be null");
    /**
        return targetField;
    /** Default sort order if not specified */
                DocumentField docField = hit.getFields().get(sortField);
                    throw new IllegalArgumentException("field [" + sortField + "] is null, cannot sort.");
import org.opensearch.action.search.SearchRequest;
                if (sourceAsMap.containsKey(sortField)) {
        /** Sort in ascending (natural) order */
                }
        String sortField,
        public static SortOrder fromString(String value) {
                    }
            PipelineContext pipelineContext
     */
         * @return the corresponding enum value
        @Override
                Map<String, Object> sourceAsMap = typeAndSourceMap.v2();
    SortResponseProcessor(
 * The OpenSearch Contributors require contributions made to
    /** Optional key defining the sort order. */
/**
    public static final String TARGET_FIELD = "target_field";
}
import java.util.Objects;
            }
/*
    public static final String SORT_FIELD = "field";
import org.opensearch.ingest.ConfigurationUtils;
 *
import org.opensearch.core.xcontent.XContentBuilder;
            Map<String, Object> config,
 * Processor that sorts an array of items.
        SortOrder(String direction) {
