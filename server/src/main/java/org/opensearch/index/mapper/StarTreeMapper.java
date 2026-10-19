                }  
                                )  
                paramMap.remove(MAX_LEAF_DOCS);
                        )  
        }
        }
         */
            }
            }  
            Object metricsFromInput = XContentMapValues.extractValue(METRICS, map);  
                for (int i = 1; i < parts.length; i++) {
    protected StarTreeMapper(String simpleName, StarTreeFieldType type, Builder builder, ObjectMapper.Builder objbuilder) {
import java.util.Locale;  
                    if (name.equals(DocCountFieldMapper.NAME)) {
            } else {
        }
                if (type == null) {
     * Builder for the star tree field mapper  
                                StarTreeIndexSettings.STAR_TREE_MAX_BASE_METRICS_SETTING.getKey(),
            Map<String, Object> dimensionMap = (Map<String, Object>) dimensionMapping;
                }
        private void addBaseMetrics(MetricStat metricStat, Set<MetricStat> metricSet) {
            return dimensions;
            if (this.objbuilder == null || this.objbuilder.mappersBuilders == null) {
            } else {
                    paramMap,
     * @opensearch.internal
                    throw new IllegalArgumentException(String.format(Locale.ROOT, "unknown date dimension field [%s]", name));  
        }
                    List<Mapper.Builder> childBuilders = getChildBuilders(builder);  
        private static boolean isBuilderAllowedForDimension(Mapper.Builder builder) {  
    @Override  
            // Navigate through the nested structure
                                    metricFromParser.getField(),
                        MultiFields.Builder multiFieldsBuilder = null;  
                Queue<MetricStat> metricQueue = new LinkedList<>(metricStat.getBaseMetrics());  
    public static class Builder extends ParametrizedFieldMapper.Builder {
                for (Object metric : metricsList) {  
         * Get dimension based on mapping
            Set<MetricStat> metricSet = new LinkedHashSet<>();
                                dim  
                    // Handle _doc_count metric separately at the end  
        }
                throw new MapperParsingException(  
     * StarTree field is not a part of an ingested document, so omitting it from derived source generation
         */
        }
                        Locale.ROOT,
                    throw new IllegalArgumentException(
                    metricMap.remove(CompositeDataCubeFieldType.NAME);
                        context.getSettings()  
                                continue;  
            return CONTENT_TYPE;  
     * Star tree mapped field type containing dimensions, metrics, star tree specs
                "Star tree mapping definition has unsupported parameters: "  
                            String.format(
                Mapper.Builder builder = currentBuilder.get();
    private final StarTreeField starTreeField;  
     *
        /**  
            }
                    );  
        private static boolean isBuilderAllowedForMetric(Mapper.Builder builder) {
                        metrics.add(metricFromParser);  
        return (StarTreeFieldType) super.fieldType();  
    @Override
import org.opensearch.index.compositeindex.datacube.Dimension;
    public static final String CONTENT_TYPE = "star_tree";
            )
            if (metricStrings.isEmpty()) {
                    context.indexVersionCreated(),
                throw new IllegalArgumentException(
                if (type == null || type.equals(DateDimension.DATE) == false) {  
            return List.of(config);  
                    String.format(Locale.ROOT, "unable to parse ordered_dimensions for star tree field [%s]", fieldName)
        }, m -> toType(m).starTreeField);  
            Object dims = XContentMapValues.extractValue("ordered_dimensions", map);  
            Map<String, Object> dimensionMap = (Map<String, Object>) dimensionMapping;  
                StarTreeFieldConfiguration.StarTreeBuildMode buildMode = StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP;
            try {  
                }
                .findFirst();
        private Optional<Mapper.Builder> findMapperBuilderByName(String name, List<Mapper.Builder> mappersBuilders) {
 */  
     *
                    throw new IllegalArgumentException(  
                        "There cannot be more than [%s] base metrics for star tree field [%s]",
    }  
 * compatible open source license.
            }
            } catch (Exception e) {  
                numBaseMetrics += metric.getBaseMetrics().size();
                return Optional.of(builder);
                dimensionMap,
                Set<String> dimensionFieldNames = new HashSet<>();
     * @opensearch.internal
                        metricStats.add(metric);
                if (dimensions.size() + orderedDimensionsList.size() < 2) {  
 *
                if (dimBuilder.isEmpty()) {
                        DocumentMapperParser.checkNoRemainingFields(
 *  
            addEligibleDerivedMetrics(metricSet);
                            String.format(Locale.ROOT, "Could not find nested field [%s] in path [%s]", parts[finalI], name)
import java.util.stream.Collectors;
        @SuppressWarnings("unchecked")
                        } else if (builder instanceof ParametrizedFieldMapper.Builder parameterizedFieldBuilder) {
                                "Duplicate dimension [%s] present as part star tree index field [%s]",  
                );
                return DimensionFactory.parseAndCreateDimension(name, type, dimensionMap, context);
 */
        /**
        @SuppressWarnings("unchecked")  
            return starTreeConfig;
         * Build dimensions from mapping  
        /**  
                        if (metricFieldNames.add(metricFromParser.getField()) == false) {
            Builder builder = new StarTreeMapper.Builder(name, objBuilder);  
                        String.format(Locale.ROOT, "date_dimension [%s] should be of type date for star tree field [%s]", name, fieldName)
import java.util.Collections;
    /**
                if (dimBuilder.isEmpty()) {
                    throw new IllegalArgumentException(
            String.format(
                                String.format(
                paramMap.remove(ORDERED_DIMENSIONS);
    public static final String MAX_LEAF_DOCS = "max_leaf_docs";
        private DateDimension buildDateDimension(String fieldName, Map<String, Object> map, Mapper.TypeParser.ParserContext context) {
                    metricSet.add(metric);  
import org.apache.lucene.index.LeafReader;
            if (metricsFromInput instanceof List<?>) {  
                                    metricFromParser.getField(),  
                        );
            String.format(
            metric.remove(STATS);  
            }
                            throw new IllegalArgumentException(String.format(Locale.ROOT, "unknown metric field [%s]", name));  
                if (!isBuilderAllowedForDimension(dimBuilder.get())) {
         */
    protected String contentType() {
@ExperimentalApi  
    @Override
                for (Object dim : orderedDimensionsList) {  
                    );
                    );
        }
        }  
     *
        private Dimension getDimension(String fieldName, Object dimensionMapping, Mapper.TypeParser.ParserContext context) {  
    public static final String CONFIG = "config";  
    private final ObjectMapper.Builder objBuilder;
/**
            this.starTreeConfig = starTreeField.getStarTreeConfig();  
                if (metric.isDerivedMetric() && !metricStats.contains(metric)) {
    @ExperimentalApi
                        }
                .filter(builder -> builder.name().equals(parts[0]))
            // If we can't find the first part, or if there's only one part, return the result
                    String.format(  
    public ParametrizedFieldMapper.Builder getMergeBuilder() {  
                    String name = (String) XContentMapValues.extractValue(CompositeDataCubeFieldType.NAME, metricMap);
     * StarTree field is not a part of an ingested document, so omitting it from derived source validation
                    } else {  
            }
        @SuppressWarnings("unchecked")
    protected void parseCreateFieldForPluggableFormat(ParseContext context) {
            }
                    String.format(Locale.ROOT, "metrics section is required for star tree field [%s]", fieldName)  
                    if (metricStats.containsAll(sourceMetrics)) {  
                        );
            // Add all required metrics initially
                        throw new IllegalArgumentException(
            );
                .collect(Collectors.toList());
                    throw new IllegalArgumentException(
                }
        private void addEligibleDerivedMetrics(Set<MetricStat> metricStats) {
                }  
        @Override
                        String.format(Locale.ROOT, "unable to parse date dimension for star tree field [%s]", fieldName)
                    StarTreeIndexSettings.STAR_TREE_MAX_BASE_METRICS_SETTING.getKey(),
            return builder;  
                                ),
                    if (nextBuilder.isPresent()) {  
    /**
            metricTypes = new ArrayList<>(metricSet);  
    public static final String METRICS = "metrics";
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext context) throws MapperParsingException {  
        throw new MapperParsingException(
                    )  
        private final Parameter<StarTreeField> config = new Parameter<>(CONFIG, false, () -> null, (name, context, nodeObj) -> {
         * Get dimension based on mapping  
                );
            if (dateDim != null) {  
    }
/*  
                    }  
import java.util.List;
                }  
                context.indexVersionCreated(),  
                            }
         */
                                String.format(  
                            metricMap,
                        throw new IllegalArgumentException(  
                if (maxLeafDocs < 1) {  
                            )
                            );  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
            if (dims instanceof List<?>) {
                                    Locale.ROOT,
        protected List<Parameter<?>> getParameters() {
import java.util.HashSet;
    protected void parseCreateField(ParseContext context) {  
                            Locale.ROOT,
import org.opensearch.core.xcontent.XContentBuilder;
                        );
                "Field [%s] is a star tree field and cannot be added inside a document. Use the index API request parameters.",  
                throw new MapperParsingException(String.format(Locale.ROOT, "unable to parse metrics for star tree field [%s]", this.name));  
                    throw new MapperParsingException(
                );
            }
                        }  
        private List<Metric> buildMetrics(String fieldName, Map<String, Object> map, Mapper.TypeParser.ParserContext context) {
                    throw new IllegalArgumentException(String.format(Locale.ROOT, "unknown dimension field [%s]", name));
        return (StarTreeMapper) in;
                for (String dim : skipStarInDims) {  
            Builder builder = new StarTreeMapper.Builder(name, null);
                dimensionMap,
        @Override
            StarTreeFieldType type = new StarTreeFieldType(name, this.config.get());
                Map<String, Object> paramMap = (Map<String, Object>) nodeObj;
                        String.format(Locale.ROOT, "unable to parse ordered_dimensions for star tree field [%s]", fieldName)
                        if (metricFieldNames.add(metricFromParser.getField()) == false) {
                List<?> metricsList = (List<?>) metricsFromInput;
 * @opensearch.experimental
                );
                                .getAsInt(
        @Override  
            }
            return dimension;
                                Locale.ROOT,
                    }
                    }
        }
                    MetricStat metric = metricQueue.poll();
            return builder;
            Optional<Mapper.Builder> currentBuilder = mappersBuilders.stream()  
                List<Metric> metrics = buildMetrics(name, paramMap, context);  
    }
                            );
            }  
import java.util.LinkedList;
                                    fieldName
                if (dimBuilder.get() instanceof DateFieldMapper.Builder == false) {
                        if (builder instanceof FieldMapper.Builder<?> fieldBuilder) {
     * @opensearch.experimental  
            return dimension;  
    /**
                .getAsInt(
        this.starTreeField = builder.config.get();  
            // Start with the top-level builders
                                StarTreeIndexSettings.STAR_TREE_MAX_BASE_METRICS_DEFAULT  
                        throw new IllegalArgumentException(  
                );
                    );  
         * Add derived metrics if all associated base metrics are present  
            throw new UnsupportedOperationException("Cannot fetch values for star tree field [" + name() + "].");
                    dimensions.add(dimension);  
                    if (dimensionFieldNames.add(dimension.getField()) == false) {
         */  
            )  
                    }  
                return Optional.empty();
            return metrics;
                            multiFieldsBuilder = fieldBuilder.multiFieldsBuilder;  
}  
    }  
            builder.parse(name, context, node);
    }
                }
                metricStrings = new ArrayList<>(StarTreeIndexSettings.DEFAULT_METRICS_LIST.get(context.getSettings()));
import org.opensearch.index.compositeindex.datacube.DateDimension;  
import java.util.LinkedHashSet;  
    /**
                return currentBuilder;  
                }
        }
                    Optional<Mapper.Builder> nextBuilder = childBuilders.stream().filter(b -> b.name().equals(parts[finalI])).findFirst();
            List<Dimension> dimensions = new LinkedList<>();
    public static final String STATS = "stats";  
        public Query termQuery(Object value, QueryShardContext context) {
                    if (objbuilder == null || objbuilder.mappersBuilders == null) {
        public Builder(String name, ObjectMapper.Builder objBuilder) {
                    if (dimensions.stream().filter(d -> d.getField().equals(dim)).findAny().isEmpty()) {
         * default constructor of VectorFieldMapper.TypeParser
                        String.format(Locale.ROOT, "Atleast two dimensions are required to build star tree index field [%s]", fieldName)
        }
        throw new MapperParsingException(  
                        }
                    StarTreeIndexSettings.STAR_TREE_MAX_BASE_METRICS_DEFAULT  
            }  
        }  
        }  
        public String typeName() {
import java.util.Map;
                throw new IllegalArgumentException(
                    );
                }
            super(name, starTreeField.getDimensionsOrder(), starTreeField.getMetrics(), CompositeFieldType.STAR_TREE);
    public static final String SKIP_STAR_NODE_IN_DIMS = "skip_star_node_creation_for_dimensions";
        private DateDimension getDateDimension(String fieldName, Object dimensionMapping, Mapper.TypeParser.ParserContext context) {
                                fieldName
            }
            DateDimension dimension;
                    throw new IllegalArgumentException(
                Set<String> metricFieldNames = new HashSet<>();
        }
            builder.parse(name, context, node);
     */
                    );  
                addBaseMetrics(metricStat, metricSet);  
                    List.of(XContentMapValues.nodeStringArrayValue(paramMap.getOrDefault(SKIP_STAR_NODE_IN_DIMS, new ArrayList<String>())))
                        )
                Set<String> skipStarInDims = new LinkedHashSet<>(  
    }
                List<Object> orderedDimensionsList = (List<Object>) dims;
        this.objBuilder = objbuilder;
                Optional<Mapper.Builder> dimBuilder = findMapperBuilderByName(name, this.objbuilder.mappersBuilders);
                    }  
                            if (multiFieldBuilder != null) {
                            Mapper.Builder multiFieldBuilder = multiFields.get(parts[finalI]);  
            for (MetricStat metric : MetricStat.values()) {  
        public TypeParser() {}  
        super(simpleName, type, MultiFields.empty(), CopyTo.empty());
            }  
        @Override  
                dimensions.add(dateDim);
                    paramMap.get(MAX_LEAF_DOCS),  
            throw new UnsupportedOperationException("Cannot perform terms query on star tree field [" + name() + "].");  
                        if (!isBuilderAllowedForMetric(meticBuilder.get())) {
            throws MapperParsingException {
                return new StarTreeField(this.name, dimensions, metrics, spec);
                    String.format(Locale.ROOT, "unable to parse config for star tree field [%s]", this.name)  
                            throw new IllegalArgumentException(  
            DocumentMapperParser.checkNoRemainingFields(  
                    Dimension dimension = getDimension(fieldName, dim, context);
     * Concrete parse for star tree type  
            if (dims == null) {  
    public static final class StarTreeFieldType extends CompositeDataCubeFieldType {  
        }  
                    Map<String, Object> metricMap = (Map<String, Object>) metric;
        /**
                List<Dimension> dimensions = buildDimensions(name, paramMap, context);  
        );  
 * A field mapper for star tree fields
                    if (metric.isDerivedMetric() && !metricSet.contains(metric)) {  
            if (numBaseMetrics > context.getSettings()  
            }
                                "[%s] in skip_star_node_creation_for_dimensions should be part of ordered_dimensions",
        /**  
import org.opensearch.index.compositeindex.datacube.MetricStat;
            );
                            ),
                                    StarTreeIndexSettings.STAR_TREE_MAX_DIMENSIONS_SETTING.getKey(),
            String name = (String) XContentMapValues.extractValue(CompositeDataCubeFieldType.NAME, dimensionMap);
                }
     */  
                paramMap.remove(METRICS);
public class StarTreeMapper extends ParametrizedFieldMapper {
        public StarTreeFieldType(String name, StarTreeField starTreeField) {
                        Optional<Mapper.Builder> meticBuilder = findMapperBuilderByName(name, this.objbuilder.mappersBuilders);
                context.indexVersionCreated(),
                name()
                                    StarTreeIndexSettings.STAR_TREE_MAX_DIMENSIONS_DEFAULT  
import org.opensearch.index.query.QueryShardContext;
            } else {  
            } else {
                    int finalI = i;
        }
            List<Metric> metrics = new LinkedList<>();
            return builder.isDataCubeMetricSupported();
         */
            metrics.add(docCountMetric);
        return new Builder(simpleName(), objBuilder).init(this);
                            name,  
                            "unsupported field type associated with dimension [%s] as part of star tree field [%s]",
                        // If not found in regular children, check for multi-fields
                            String.format(  
                    .getAsInt(
        }
                }  
                                builder = multiFieldBuilder;
                }
            for (String metricString : metricStrings) {  
                    }
import org.apache.lucene.search.Query;
            return new Metric(name, metricTypes);
                        metrics.add(metricFromParser);
        private List<Dimension> buildDimensions(String fieldName, Map<String, Object> map, Mapper.TypeParser.ParserContext context) {  
            dimensionMap.remove(CompositeDataCubeFieldType.NAME);
            return builder.getSupportedDataCubeDimensionType().isPresent();
                                )
                    );  
            super(name);
                        StarTreeIndexSettings.STAR_TREE_MAX_DIMENSIONS_SETTING.getKey(),
                                dimension.getField(),
                String type = (String) XContentMapValues.extractValue(CompositeDataCubeFieldType.TYPE, dimensionMap);
    public static class TypeParser implements Mapper.TypeParser {
                                    fieldName
                    // First try to find in regular child builders  
                            Map<String, Mapper.Builder> multiFields = multiFieldsBuilder.getMapperBuilders();
     */  
                }
import java.io.IOException;
                            throw new IllegalArgumentException(
                );
        return CONTENT_TYPE;
                        String.format(  
            List<String> metricStrings = XContentMapValues.extractRawValues(STATS, metric)
                String type = (String) XContentMapValues.extractValue(CompositeDataCubeFieldType.TYPE, dimensionMap);  
     */  
         */
                }
                            context.indexVersionCreated(),  
                .stream()  
            // TODO : evaluate later
    private static StarTreeMapper toType(FieldMapper in) {
                if (orderedDimensionsList.size() + dimensions.size() > context.getSettings()  
                        StarTreeIndexSettings.STAR_TREE_MAX_DIMENSIONS_DEFAULT  
                paramMap.remove(DATE_DIMENSION);
                    "Star tree mapping definition has unsupported parameters: "  
                .map(Object::toString)
            Metric docCountMetric = new Metric(DocCountFieldMapper.NAME, List.of(MetricStat.DOC_COUNT));  
                            multiFieldsBuilder = parameterizedFieldBuilder.multiFieldsBuilder;
        private Metric getMetric(String name, Map<String, Object> metric, Mapper.TypeParser.ParserContext context) {  
                Optional<Mapper.Builder> dimBuilder = findMapperBuilderByName(name, this.objbuilder.mappersBuilders);  
        @SuppressWarnings("unchecked")  
                            Locale.ROOT,
                paramMap.remove(SKIP_STAR_NODE_IN_DIMS);  
                            fieldName
        private final StarTreeFieldConfiguration starTreeConfig;
import java.util.Queue;  
                                    "Duplicate metrics [%s] present as part star tree index field [%s]",  
        private ObjectMapper.Builder objbuilder;
                        }
            if (builder instanceof ObjectMapper.Builder) {
            if (currentBuilder.isEmpty() || parts.length == 1) {
            int numBaseMetrics = 0;
                dimensionMap.remove(CompositeDataCubeFieldType.TYPE);
package org.opensearch.index.mapper;
                            context.getSettings()  
                            "ordered_dimensions cannot have more than %s dimensions for star tree field [%s]",
                        }  
                )) {
            if (metricsFromInput == null) {
        public ParametrizedFieldMapper build(BuilderContext context) {
                throw new IllegalArgumentException(
            if (nodeObj instanceof Map<?, ?>) {  
 * this file be licensed under the Apache-2.0 license or a
        );
import org.opensearch.common.xcontent.support.XContentMapValues;
                throw new IllegalArgumentException(
                            )  
        public StarTreeFieldConfiguration getStarTreeConfig() {  
                        String.format(Locale.ROOT, "%s [%s] must be greater than 0", MAX_LEAF_DOCS, maxLeafDocs)
            String name = (String) XContentMapValues.extractValue(CompositeDataCubeFieldType.NAME, dimensionMap);  
                while (metricQueue.isEmpty() == false) {
    public static final String ORDERED_DIMENSIONS = "ordered_dimensions";  
 * SPDX-License-Identifier: Apache-2.0
            }
                    String.format(Locale.ROOT, "ordered_dimensions is required for star tree field [%s]", fieldName)  
                );
                            fieldName
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext context, ObjectMapper.Builder objBuilder)
    }  
                        Metric metricFromParser = getMetric(name, metricMap, context);  
                DocumentMapperParser.checkNoRemainingFields(  
import java.util.ArrayList;  
                Locale.ROOT,  
                            );
                        builder = nextBuilder.get();
                dimension = DimensionFactory.parseAndCreateDimension(name, dimBuilder.get(), dimensionMap, context);
            }
            if (this.objbuilder == null || this.objbuilder.mappersBuilders == null) {  
            List<MetricStat> metricTypes;
        private List<Mapper.Builder> getChildBuilders(Mapper.Builder builder) {  
            } else {
    public void canDeriveSource() {}
        }  
                    )) {
    /**  
        }  
                dimension = (DateDimension) DimensionFactory.parseAndCreateDimension(name, dimBuilder.get(), dimensionMap, context);
                            throw new IllegalArgumentException(  
        }
            Object dims = XContentMapValues.extractValue("date_dimension", map);
                dimensionMap.remove(CompositeDataCubeFieldType.TYPE);
                        String.format(  
        /**
                        );
    public StarTreeFieldType fieldType() {
        @Override
            String[] parts = name.split("\\.");  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;  
                        metricQueue.addAll(metric.getBaseMetrics());
                metricSet.add(metricStat);
                int maxLeafDocs = XContentMapValues.nodeIntegerValue(
            return new StarTreeMapper(name, type, this, objbuilder);  
                                    Locale.ROOT,
            if (metricStat.isDerivedMetric()) {
                        fieldName
 * The OpenSearch Contributors require contributions made to  
                    StarTreeIndexSettings.STAR_TREE_DEFAULT_MAX_LEAF_DOCS.get(context.getSettings())
                paramMap.remove(CompositeDataCubeFieldType.NAME);
                        if (multiFieldsBuilder != null) {
import org.opensearch.common.annotation.ExperimentalApi;  
            DocumentMapperParser.checkNoRemainingFields(
                Locale.ROOT,
            return Collections.emptyList();
            }
                    } else {
            this.objbuilder = objBuilder;  
                StarTreeFieldConfiguration spec = new StarTreeFieldConfiguration(maxLeafDocs, skipStarInDims, buildMode);
        }
                "Star tree mapping definition has unsupported parameters: "
                        if (meticBuilder.isEmpty()) {
                return ((ObjectMapper.Builder) builder).mappersBuilders;
                        }
import java.util.Set;
                                Locale.ROOT,
                "Field [%s] is a star tree field and cannot be added inside a document. Use the index API request parameters.",
    @Override
import org.opensearch.search.lookup.SearchLookup;  
    public static final String DATE_DIMENSION = "date_dimension";
         * Build metrics from mapping
import org.opensearch.index.compositeindex.datacube.DimensionFactory;
import org.opensearch.index.compositeindex.datacube.Metric;  
                MetricStat metricStat = MetricStat.fromTypeName(metricString);
                                    "Duplicate metrics [%s] present as part star tree index field [%s]",
                }
    }
            if (dims == null) {
            DateDimension dateDim = buildDateDimension(fieldName, map, context);
        @Override  
import java.util.Optional;
    }
                        Metric metricFromParser = getMetric(name, metricMap, context);
                            .getAsInt(
     */  
            return getDateDimension(fieldName, dims, context);  
    }
            // TODO : evaluate later  
                                String.format(Locale.ROOT, "non-numeric field type is associated with star tree metric [%s]", this.name)
    @Override
        }
        @Override
    @Override
            for (Metric metric : metrics) {  
        @SuppressWarnings("unchecked")
    @Override
        // Helper method to get child builders from a parent builder
                            "Star tree mapping definition has unsupported parameters: "
                    }  
        @SuppressWarnings("unchecked")
    public void deriveSource(XContentBuilder builder, LeafReader leafReader, int docId) throws IOException {}
            Dimension dimension;
                );
                return null;
                name()
                    List<MetricStat> sourceMetrics = metric.getBaseMetrics();
                        continue;
                return (DateDimension) DimensionFactory.parseAndCreateDimension(name, type, dimensionMap, context);
        /**
            dimensionMap.remove(CompositeDataCubeFieldType.NAME);
         * Add base metrics of derived metric to metric set
            }
                    throw new MapperParsingException(  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
