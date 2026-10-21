                return null;
            return builder;
 * A field mapper for star tree fields
            super(name);
            builder.parse(name, context, node);
                }
        super(simpleName, type, MultiFields.empty(), CopyTo.empty());
    @Override
                    )
            return Collections.emptyList();
         * Build dimensions from mapping
    }
                            String.format(
            }
            dimensionMap.remove(CompositeDataCubeFieldType.NAME);
            } else {
                        }
                Map<String, Object> paramMap = (Map<String, Object>) nodeObj;
                            .getAsInt(
        private DateDimension buildDateDimension(String fieldName, Map<String, Object> map, Mapper.TypeParser.ParserContext context) {
                "Star tree mapping definition has unsupported parameters: "
                }
                    List<MetricStat> sourceMetrics = metric.getBaseMetrics();
                    Map<String, Object> metricMap = (Map<String, Object>) metric;
                throw new IllegalArgumentException(
        /**
            if (metricsFromInput == null) {
        private Metric getMetric(String name, Map<String, Object> metric, Mapper.TypeParser.ParserContext context) {
            if (metricStrings.isEmpty()) {
                Queue<MetricStat> metricQueue = new LinkedList<>(metricStat.getBaseMetrics());
                    metricSet.add(metric);
                    } else {
        }
                return currentBuilder;
                                fieldName
            return new StarTreeMapper(name, type, this, objbuilder);
                                "[%s] in skip_star_node_creation_for_dimensions should be part of ordered_dimensions",
            if (dateDim != null) {
                            ),
                        if (metricFieldNames.add(metricFromParser.getField()) == false) {
                return Optional.empty();
import org.opensearch.index.compositeindex.datacube.MetricStat;
            }
                }
                Locale.ROOT,
            }
import org.opensearch.index.compositeindex.datacube.DateDimension;
                Set<String> skipStarInDims = new LinkedHashSet<>(
            }
                        MultiFields.Builder multiFieldsBuilder = null;
                        String.format(
import org.opensearch.core.xcontent.XContentBuilder;
                throw new MapperParsingException(
            List<Metric> metrics = new LinkedList<>();
                    throw new IllegalArgumentException(
                                    StarTreeIndexSettings.STAR_TREE_MAX_DIMENSIONS_DEFAULT
                throw new IllegalArgumentException(
                    }
                paramMap.remove(DATE_DIMENSION);
    }
                dimensionMap.remove(CompositeDataCubeFieldType.TYPE);
                    String.format(Locale.ROOT, "unable to parse config for star tree field [%s]", this.name)
            }
 * compatible open source license.
        /**
                        metricQueue.addAll(metric.getBaseMetrics());
            }
                                String.format(Locale.ROOT, "non-numeric field type is associated with star tree metric [%s]", this.name)
import java.util.Locale;
        }
            String.format(
                throw new IllegalArgumentException(
        public StarTreeFieldType(String name, StarTreeField starTreeField) {
                    }
                List<Dimension> dimensions = buildDimensions(name, paramMap, context);
     * StarTree field is not a part of an ingested document, so omitting it from derived source generation
    private final ObjectMapper.Builder objBuilder;
         */
                                "Duplicate dimension [%s] present as part star tree index field [%s]",
                if (dimBuilder.get() instanceof DateFieldMapper.Builder == false) {
            builder.parse(name, context, node);
                    throw new IllegalArgumentException(
        }
            // If we can't find the first part, or if there's only one part, return the result
            return starTreeConfig;
    public static final String SKIP_STAR_NODE_IN_DIMS = "skip_star_node_creation_for_dimensions";
import java.util.Set;
                }
                    throw new IllegalArgumentException(String.format(Locale.ROOT, "unknown dimension field [%s]", name));
                    throw new IllegalArgumentException(String.format(Locale.ROOT, "unknown date dimension field [%s]", name));
                Optional<Mapper.Builder> dimBuilder = findMapperBuilderByName(name, this.objbuilder.mappersBuilders);
                if (dimBuilder.isEmpty()) {
                if (dimensions.size() + orderedDimensionsList.size() < 2) {
        }
            if (dims == null) {
                paramMap.remove(SKIP_STAR_NODE_IN_DIMS);
            if (builder instanceof ObjectMapper.Builder) {
                            String.format(
                );
                            throw new IllegalArgumentException(
                        if (builder instanceof FieldMapper.Builder<?> fieldBuilder) {
                        continue;
                            }
            for (String metricString : metricStrings) {
@ExperimentalApi
                        );
        private List<Dimension> buildDimensions(String fieldName, Map<String, Object> map, Mapper.TypeParser.ParserContext context) {
                        throw new IllegalArgumentException(
    @Override
                addBaseMetrics(metricStat, metricSet);
                .map(Object::toString)
                Locale.ROOT,
            DateDimension dimension;
                Optional<Mapper.Builder> dimBuilder = findMapperBuilderByName(name, this.objbuilder.mappersBuilders);
            return CONTENT_TYPE;
            }
                    }
                );
 */
                                    Locale.ROOT,
            } else {
    public void deriveSource(XContentBuilder builder, LeafReader leafReader, int docId) throws IOException {}
                    metricMap.remove(CompositeDataCubeFieldType.NAME);
                paramMap.remove(METRICS);
                                    Locale.ROOT,
                );
            );
                                String.format(
                return new StarTreeField(this.name, dimensions, metrics, spec);
                        String.format(Locale.ROOT, "%s [%s] must be greater than 0", MAX_LEAF_DOCS, maxLeafDocs)
    @Override
                while (metricQueue.isEmpty() == false) {
        }
                    if (objbuilder == null || objbuilder.mappersBuilders == null) {
                            fieldName
            List<String> metricStrings = XContentMapValues.extractRawValues(STATS, metric)
package org.opensearch.index.mapper;
                    List.of(XContentMapValues.nodeStringArrayValue(paramMap.getOrDefault(SKIP_STAR_NODE_IN_DIMS, new ArrayList<String>())))
    protected String contentType() {
                );
            }
            return new Metric(name, metricTypes);
                .findFirst();
        }
            }
                for (int i = 1; i < parts.length; i++) {
            // Navigate through the nested structure
            if (dims instanceof List<?>) {
            List<MetricStat> metricTypes;
public class StarTreeMapper extends ParametrizedFieldMapper {
        /**
                                StarTreeIndexSettings.STAR_TREE_MAX_BASE_METRICS_DEFAULT
        @SuppressWarnings("unchecked")
        /**
import org.opensearch.common.annotation.ExperimentalApi;
    public static final String MAX_LEAF_DOCS = "max_leaf_docs";
            }
                        String.format(Locale.ROOT, "unable to parse date dimension for star tree field [%s]", fieldName)
                dimensionMap,
        }
                        "There cannot be more than [%s] base metrics for star tree field [%s]",
        public ParametrizedFieldMapper build(BuilderContext context) {
                    String.format(Locale.ROOT, "unable to parse ordered_dimensions for star tree field [%s]", fieldName)
 * this file be licensed under the Apache-2.0 license or a
         * Build metrics from mapping
                    if (nextBuilder.isPresent()) {
                }
     * Star tree mapped field type containing dimensions, metrics, star tree specs
import org.apache.lucene.index.LeafReader;
                            String.format(Locale.ROOT, "Could not find nested field [%s] in path [%s]", parts[finalI], name)
                            throw new IllegalArgumentException(
    public static class TypeParser implements Mapper.TypeParser {
                                    metricFromParser.getField(),
            StarTreeFieldType type = new StarTreeFieldType(name, this.config.get());
            for (MetricStat metric : MetricStat.values()) {
    public static final class StarTreeFieldType extends CompositeDataCubeFieldType {
                        } else if (builder instanceof ParametrizedFieldMapper.Builder parameterizedFieldBuilder) {
import org.apache.lucene.search.Query;
        private static boolean isBuilderAllowedForMetric(Mapper.Builder builder) {
                List<Metric> metrics = buildMetrics(name, paramMap, context);
                        if (!isBuilderAllowedForMetric(meticBuilder.get())) {
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
                                    StarTreeIndexSettings.STAR_TREE_MAX_DIMENSIONS_SETTING.getKey(),
                if (metric.isDerivedMetric() && !metricStats.contains(metric)) {
        }
            super(name, starTreeField.getDimensionsOrder(), starTreeField.getMetrics(), CompositeFieldType.STAR_TREE);
                                    "Duplicate metrics [%s] present as part star tree index field [%s]",
     */
            this.starTreeConfig = starTreeField.getStarTreeConfig();
                for (Object dim : orderedDimensionsList) {
    }
                    .getAsInt(
import java.util.List;
                        String.format(Locale.ROOT, "unable to parse ordered_dimensions for star tree field [%s]", fieldName)
                    String.format(Locale.ROOT, "metrics section is required for star tree field [%s]", fieldName)
        throw new MapperParsingException(
                    if (metricStats.containsAll(sourceMetrics)) {
                        metricStats.add(metric);
                }
                                )
                                    fieldName
            Builder builder = new StarTreeMapper.Builder(name, null);
        private Dimension getDimension(String fieldName, Object dimensionMapping, Mapper.TypeParser.ParserContext context) {
    @Override
        return new Builder(simpleName(), objBuilder).init(this);
                                )
    @Override
        }
                        }
    public static final String DATE_DIMENSION = "date_dimension";
                        )
    private final StarTreeField starTreeField;
                    throw new MapperParsingException(
     * Concrete parse for star tree type
 */
         */
        }
            }
                return ((ObjectMapper.Builder) builder).mappersBuilders;
                        throw new IllegalArgumentException(
        }
     * @opensearch.internal
                        if (multiFieldsBuilder != null) {
         * Get dimension based on mapping
            // Start with the top-level builders
import java.util.Map;
    protected StarTreeMapper(String simpleName, StarTreeFieldType type, Builder builder, ObjectMapper.Builder objbuilder) {
    @ExperimentalApi
        private DateDimension getDateDimension(String fieldName, Object dimensionMapping, Mapper.TypeParser.ParserContext context) {
                StarTreeFieldConfiguration.StarTreeBuildMode buildMode = StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP;
                    String.format(
                            name,
                                    "Duplicate metrics [%s] present as part star tree index field [%s]",
                            context.getSettings()
                            Locale.ROOT,
                                builder = multiFieldBuilder;
import java.io.IOException;
            return metrics;
    protected void parseCreateFieldForPluggableFormat(ParseContext context) {
                        Metric metricFromParser = getMetric(name, metricMap, context);
    /**
                dimension = (DateDimension) DimensionFactory.parseAndCreateDimension(name, dimBuilder.get(), dimensionMap, context);
                DocumentMapperParser.checkNoRemainingFields(
                    )) {
                if (type == null || type.equals(DateDimension.DATE) == false) {
            return builder.isDataCubeMetricSupported();
                            multiFieldsBuilder = parameterizedFieldBuilder.multiFieldsBuilder;
                            metricMap,
        private List<Metric> buildMetrics(String fieldName, Map<String, Object> map, Mapper.TypeParser.ParserContext context) {
        protected List<Parameter<?>> getParameters() {
                        }
                            throw new IllegalArgumentException(String.format(Locale.ROOT, "unknown metric field [%s]", name));
 * @opensearch.experimental
            metricTypes = new ArrayList<>(metricSet);
                "Star tree mapping definition has unsupported parameters: "
    }
        }
                    // First try to find in regular child builders
    public static final String STATS = "stats";
            throw new UnsupportedOperationException("Cannot perform terms query on star tree field [" + name() + "].");
                            context.indexVersionCreated(),
                );
        public Query termQuery(Object value, QueryShardContext context) {
                throw new MapperParsingException(String.format(Locale.ROOT, "unable to parse metrics for star tree field [%s]", this.name));
        return CONTENT_TYPE;
     * @opensearch.experimental
                                    fieldName
                context.indexVersionCreated(),
        @Override
                for (Object metric : metricsList) {
            }
        private ObjectMapper.Builder objbuilder;
                    MetricStat metric = metricQueue.poll();
                Set<String> dimensionFieldNames = new HashSet<>();
                    );
/*
            if (this.objbuilder == null || this.objbuilder.mappersBuilders == null) {
                List<Object> orderedDimensionsList = (List<Object>) dims;
    }
        public TypeParser() {}
        @SuppressWarnings("unchecked")
                            );
                "Field [%s] is a star tree field and cannot be added inside a document. Use the index API request parameters.",
            if (metricStat.isDerivedMetric()) {
            metric.remove(STATS);
 *
/**
import org.opensearch.common.xcontent.support.XContentMapValues;
        }
                    throw new IllegalArgumentException(
                .getAsInt(
            int numBaseMetrics = 0;
                return DimensionFactory.parseAndCreateDimension(name, type, dimensionMap, context);
        public String typeName() {
        // Helper method to get child builders from a parent builder
                return (DateDimension) DimensionFactory.parseAndCreateDimension(name, type, dimensionMap, context);
    public static final String METRICS = "metrics";
                    int finalI = i;
         */
import java.util.Collections;
        private static boolean isBuilderAllowedForDimension(Mapper.Builder builder) {
            Object dims = XContentMapValues.extractValue("ordered_dimensions", map);
                                Locale.ROOT,
import java.util.LinkedList;
            }
    public static final String ORDERED_DIMENSIONS = "ordered_dimensions";
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
        /**
                                dimension.getField(),
     *
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
                    }
import java.util.ArrayList;
import java.util.Queue;
                paramMap.remove(ORDERED_DIMENSIONS);
            Set<MetricStat> metricSet = new LinkedHashSet<>();
        private final Parameter<StarTreeField> config = new Parameter<>(CONFIG, false, () -> null, (name, context, nodeObj) -> {
     */
                        Locale.ROOT,
                        )
    }
                        fieldName
                return Optional.of(builder);
            Optional<Mapper.Builder> currentBuilder = mappersBuilders.stream()
                        Optional<Mapper.Builder> meticBuilder = findMapperBuilderByName(name, this.objbuilder.mappersBuilders);
                                dim
            }
            Map<String, Object> dimensionMap = (Map<String, Object>) dimensionMapping;
         * Add base metrics of derived metric to metric set
                Mapper.Builder builder = currentBuilder.get();
                String type = (String) XContentMapValues.extractValue(CompositeDataCubeFieldType.TYPE, dimensionMap);
                throw new IllegalArgumentException(
            );
        @SuppressWarnings("unchecked")
            try {
                                Locale.ROOT,
            DocumentMapperParser.checkNoRemainingFields(
                        );
     */
    protected void parseCreateField(ParseContext context) {
                }
        }
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
                        StarTreeIndexSettings.STAR_TREE_MAX_DIMENSIONS_SETTING.getKey(),
                        metrics.add(metricFromParser);
import org.opensearch.search.lookup.SearchLookup;
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext context) throws MapperParsingException {
            Object dims = XContentMapValues.extractValue("date_dimension", map);
    }
            metrics.add(docCountMetric);
    public static final String CONFIG = "config";
            return List.of(config);
import org.opensearch.index.compositeindex.datacube.Metric;
                    throw new MapperParsingException(
                    }
                name()
            throws MapperParsingException {
        @SuppressWarnings("unchecked")
                        throw new IllegalArgumentException(
                    List<Mapper.Builder> childBuilders = getChildBuilders(builder);
                                .getAsInt(
        @SuppressWarnings("unchecked")
                StarTreeFieldConfiguration spec = new StarTreeFieldConfiguration(maxLeafDocs, skipStarInDims, buildMode);
            throw new UnsupportedOperationException("Cannot fetch values for star tree field [" + name() + "].");
        @Override
            if (numBaseMetrics > context.getSettings()
    private static StarTreeMapper toType(FieldMapper in) {
                    }
                Set<String> metricFieldNames = new HashSet<>();
                            Mapper.Builder multiFieldBuilder = multiFields.get(parts[finalI]);
                if (orderedDimensionsList.size() + dimensions.size() > context.getSettings()
                        // If not found in regular children, check for multi-fields
                    );
    /**
    public static final String CONTENT_TYPE = "star_tree";
        }
         * default constructor of VectorFieldMapper.TypeParser
        @Override
                        }
}
                    context.indexVersionCreated(),
                            Map<String, Mapper.Builder> multiFields = multiFieldsBuilder.getMapperBuilders();
    }
        private List<Mapper.Builder> getChildBuilders(Mapper.Builder builder) {
                        metrics.add(metricFromParser);
            if (dims == null) {
                )) {
            for (Metric metric : metrics) {
            if (this.objbuilder == null || this.objbuilder.mappersBuilders == null) {
                    throw new IllegalArgumentException(
                .collect(Collectors.toList());
                int maxLeafDocs = XContentMapValues.nodeIntegerValue(
    @Override
            // TODO : evaluate later
    /**
         */
                            "unsupported field type associated with dimension [%s] as part of star tree field [%s]",
        }
            // TODO : evaluate later
                                continue;
            Metric docCountMetric = new Metric(DocCountFieldMapper.NAME, List.of(MetricStat.DOC_COUNT));
            Dimension dimension;
        return (StarTreeMapper) in;
                        StarTreeIndexSettings.STAR_TREE_MAX_DIMENSIONS_DEFAULT
        }
                    );
                }
                            )
                                StarTreeIndexSettings.STAR_TREE_MAX_BASE_METRICS_SETTING.getKey(),
                            );
import org.opensearch.index.compositeindex.datacube.DimensionFactory;
        );
                        String.format(Locale.ROOT, "Atleast two dimensions are required to build star tree index field [%s]", fieldName)
            Object metricsFromInput = XContentMapValues.extractValue(METRICS, map);
import java.util.LinkedHashSet;
            }
        private final StarTreeFieldConfiguration starTreeConfig;
                if (maxLeafDocs < 1) {
                        Metric metricFromParser = getMetric(name, metricMap, context);
                dimensionMap.remove(CompositeDataCubeFieldType.TYPE);
                        );
     *
            return builder;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
        }
            return builder.getSupportedDataCubeDimensionType().isPresent();
                    StarTreeIndexSettings.STAR_TREE_DEFAULT_MAX_LEAF_DOCS.get(context.getSettings())
         */
         * Get dimension based on mapping
import java.util.stream.Collectors;
    }
                    } else {
                dimensionMap,
            addEligibleDerivedMetrics(metricSet);
                        context.getSettings()
            this.objbuilder = objBuilder;
        @Override
        }
                        String.format(Locale.ROOT, "date_dimension [%s] should be of type date for star tree field [%s]", name, fieldName)
        private Optional<Mapper.Builder> findMapperBuilderByName(String name, List<Mapper.Builder> mappersBuilders) {
                        String.format(
                    }
            }
            String name = (String) XContentMapValues.extractValue(CompositeDataCubeFieldType.NAME, dimensionMap);
                    Dimension dimension = getDimension(fieldName, dim, context);
                .filter(builder -> builder.name().equals(parts[0]))
        }
                        }
                        if (metricFieldNames.add(metricFromParser.getField()) == false) {
 * SPDX-License-Identifier: Apache-2.0
                    );
                        );
     *
     * StarTree field is not a part of an ingested document, so omitting it from derived source validation
                    Optional<Mapper.Builder> nextBuilder = childBuilders.stream().filter(b -> b.name().equals(parts[finalI])).findFirst();
                        if (meticBuilder.isEmpty()) {
                metricSet.add(metricStat);
                }
    public void canDeriveSource() {}
 * The OpenSearch Contributors require contributions made to
     */
                }
        throw new MapperParsingException(
                    if (dimensionFieldNames.add(dimension.getField()) == false) {
                    String name = (String) XContentMapValues.extractValue(CompositeDataCubeFieldType.NAME, metricMap);
            if (metricsFromInput instanceof List<?>) {
                if (dimBuilder.isEmpty()) {
        );
                    );
                            "ordered_dimensions cannot have more than %s dimensions for star tree field [%s]",
            }
                    // Handle _doc_count metric separately at the end
                if (type == null) {
            } else {
        }
            String.format(
                context.indexVersionCreated(),
                            throw new IllegalArgumentException(
        this.objBuilder = objbuilder;
                }
                );
    }
                .stream()
            return dimensions;
     * @opensearch.internal
                metricStrings = new ArrayList<>(StarTreeIndexSettings.DEFAULT_METRICS_LIST.get(context.getSettings()));
            Builder builder = new StarTreeMapper.Builder(name, objBuilder);
    /**
            )
    public StarTreeFieldType fieldType() {
                String type = (String) XContentMapValues.extractValue(CompositeDataCubeFieldType.TYPE, dimensionMap);
                    paramMap,
            } catch (Exception e) {
                numBaseMetrics += metric.getBaseMetrics().size();
import java.util.HashSet;
                        }
        @Override
                    StarTreeIndexSettings.STAR_TREE_MAX_BASE_METRICS_SETTING.getKey(),
        return (StarTreeFieldType) super.fieldType();
                    dimensions.add(dimension);
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext context, ObjectMapper.Builder objBuilder)
                            multiFieldsBuilder = fieldBuilder.multiFieldsBuilder;
            List<Dimension> dimensions = new LinkedList<>();
                paramMap.remove(CompositeDataCubeFieldType.NAME);
                "Field [%s] is a star tree field and cannot be added inside a document. Use the index API request parameters.",
                                String.format(
            dimensionMap.remove(CompositeDataCubeFieldType.NAME);
                List<?> metricsList = (List<?>) metricsFromInput;
         */
                MetricStat metricStat = MetricStat.fromTypeName(metricString);
                    "Star tree mapping definition has unsupported parameters: "
         * Add derived metrics if all associated base metrics are present
                    if (name.equals(DocCountFieldMapper.NAME)) {
        public Builder(String name, ObjectMapper.Builder objBuilder) {
                    if (dimensions.stream().filter(d -> d.getField().equals(dim)).findAny().isEmpty()) {
                        builder = nextBuilder.get();
        @Override
                    );
                        DocumentMapperParser.checkNoRemainingFields(
import java.util.Optional;
                            Locale.ROOT,
                    paramMap.get(MAX_LEAF_DOCS),
        /**
                                ),
                dimensions.add(dateDim);
    public static class Builder extends ParametrizedFieldMapper.Builder {
                name()
                            )
                    if (metric.isDerivedMetric() && !metricSet.contains(metric)) {
            return dimension;
            if (currentBuilder.isEmpty() || parts.length == 1) {
                for (String dim : skipStarInDims) {
                dimension = DimensionFactory.parseAndCreateDimension(name, dimBuilder.get(), dimensionMap, context);
            // Add all required metrics initially
            String name = (String) XContentMapValues.extractValue(CompositeDataCubeFieldType.NAME, dimensionMap);
                paramMap.remove(MAX_LEAF_DOCS);
            } else {
                );
    @Override
                            if (multiFieldBuilder != null) {
                            fieldName
    /**
            if (nodeObj instanceof Map<?, ?>) {
            }
            String[] parts = name.split("\\.");
                );
        this.starTreeField = builder.config.get();
                            );
            )
        public StarTreeFieldConfiguration getStarTreeConfig() {
            Map<String, Object> dimensionMap = (Map<String, Object>) dimensionMapping;
                if (!isBuilderAllowedForDimension(dimBuilder.get())) {
                    );
                }
            DocumentMapperParser.checkNoRemainingFields(
            DateDimension dateDim = buildDateDimension(fieldName, map, context);
            } else {
                    String.format(Locale.ROOT, "ordered_dimensions is required for star tree field [%s]", fieldName)
                }
                    throw new IllegalArgumentException(
        private void addBaseMetrics(MetricStat metricStat, Set<MetricStat> metricSet) {
                }
        private void addEligibleDerivedMetrics(Set<MetricStat> metricStats) {
            return getDateDimension(fieldName, dims, context);
        @Override
     * Builder for the star tree field mapper
                }
         */
                            "Star tree mapping definition has unsupported parameters: "
                                    metricFromParser.getField(),
                    StarTreeIndexSettings.STAR_TREE_MAX_BASE_METRICS_DEFAULT
     */
        @SuppressWarnings("unchecked")
            return dimension;
        /**
 *
        }, m -> toType(m).starTreeField);
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.index.compositeindex.datacube.Dimension;
        }
