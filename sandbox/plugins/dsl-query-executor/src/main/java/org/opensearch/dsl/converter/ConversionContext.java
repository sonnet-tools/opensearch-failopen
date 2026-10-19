        RelDataTypeField field = getField(fieldName);  
import org.apache.calcite.plan.RelOptCluster;
     *  
     * @throws ConversionException if the field is not found in the schema  
    public SearchSourceBuilder getSearchSource() {  
    }
        return cluster.getRexBuilder();  
import org.opensearch.search.builder.SearchSourceBuilder;  
     */
        this.searchSource = Objects.requireNonNull(searchSource, "searchSource must not be null");
 * compatible open source license.
    /** Returns the Calcite cluster. */
     * Creates a conversion context.
     */
        RelNode parentPlan
        return table.getRowType();
        RelOptCluster cluster,
     * @param table the resolved Calcite table for the target index  
    private final AggregationMetadata aggregationMetadata;
 * SPDX-License-Identifier: Apache-2.0
        this.aggregationMetadata = aggregationMetadata;
        return new ConversionContext(searchSource, cluster, table, metadata, parentPlan);
    /**
    public RelOptTable getTable() {
        return aggregationMetadata;
    }
        this.table = Objects.requireNonNull(table, "table must not be null");  
     * Looks up a field by name and returns the field descriptor.
/*  
        }  
package org.opensearch.dsl.converter;
        return field;
import org.apache.calcite.rel.type.RelDataType;
     *
     * @return a RexNode representing the field reference
     * Returns a new context with the given aggregation metadata.  
    }
        this.parentPlan = parentPlan;
 */
    private ConversionContext(  
/**
        return cluster;  
    }
    /**
     * @param parent the parent level's built plan
    public RexBuilder getRexBuilder() {
 *
     * Looks up a field by name and returns a RexNode input reference.
    public AggregationMetadata getAggregationMetadata() {
        return getRexBuilder().makeInputRef(field.getType(), field.getIndex());
     */
import org.apache.calcite.rel.type.RelDataTypeField;
 * Carries the shared state needed by converters and query translators
    ) {  
    }  
    /**
    public RelOptCluster getCluster() {
     * @param cluster the Calcite cluster for building expressions and RelNodes
        this(searchSource, cluster, table, null, null);  
    }  
     * Returns a new context with the given parent plan attached.
    }
 * this file be licensed under the Apache-2.0 license or a
        return new ConversionContext(searchSource, cluster, table, aggregationMetadata, parent);
import org.apache.calcite.rel.RelNode;  
        RelDataTypeField field = getRowType().getField(fieldName, false, false);  
    public ConversionContext withAggregationMetadata(AggregationMetadata metadata) {
     * @return the RelDataTypeField descriptor
    public RelDataTypeField getField(String fieldName) throws ConversionException {
     * input restricting a child plan to the parent's top-N groups — or null at root levels.
     *  
        this.cluster = Objects.requireNonNull(cluster, "cluster must not be null");
    /**
    }
    /**
    /**
 */  
    }
     * @param fieldName the field name to look up
    public RelNode getParentPlan() {  
 * during DSL-to-RelNode conversion.  
}  
    /** Returns the RexBuilder for creating expressions. */
    private final RelOptCluster cluster;
     */
    private final SearchSourceBuilder searchSource;
     * @throws ConversionException if the field is not found in the schema  
     * @param searchSource the original DSL query
     * @param fieldName the field name to look up
    }  
        return parentPlan;
     * Returns the parent level's built plan for a nested aggregation level — the semi-join  
    }
        AggregationMetadata aggregationMetadata,
import org.apache.calcite.rex.RexBuilder;  
public class ConversionContext {
     *  
    public RelDataType getRowType() {  
import org.apache.calcite.plan.RelOptTable;
    /** Returns the resolved Calcite table. */  
        if (field == null) {
    /** Returns the index row type (field names and types). */
        return searchSource;
     */  
import org.apache.calcite.rex.RexNode;
    public ConversionContext withParentPlan(RelNode parent) {  
import java.util.Objects;
     *  
        RelOptTable table,  
 * The OpenSearch Contributors require contributions made to  
            throw new ConversionException("Field '" + fieldName + "' not found in schema");
     */
    }
     * @param metadata the aggregation metadata to attach
    /** Returns the current aggregation metadata, or null if not in aggregation context. */  
    private final RelNode parentPlan;
import org.opensearch.dsl.aggregation.AggregationMetadata;
    /** Returns the original DSL query. */
    public ConversionContext(SearchSourceBuilder searchSource, RelOptCluster cluster, RelOptTable table) {
    private final RelOptTable table;  
    public RexNode makeFieldRef(String fieldName) throws ConversionException {
        SearchSourceBuilder searchSource,
        return table;
    }  
