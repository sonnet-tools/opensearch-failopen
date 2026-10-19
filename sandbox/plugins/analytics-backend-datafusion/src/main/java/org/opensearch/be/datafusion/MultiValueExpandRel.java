 * calls while GROUP BY uses the appended scalar column.
    @Override  
/*  
            .item("output", expandedFieldName)
        }  
            .item("distinct", true);  
}
    int expandedFieldIndex() {
    }  
 * Backend-local relation that appends one row-expanded scalar column for a LIST input column.  
    }
    protected RelDataType deriveRowType() {
        if (input.getRowType().getFieldList().get(fieldIndex).getType().getComponentType() == null) {  
 * this file to be licensed under the Apache-2.0 license or a
        RelDataType elementType = fields.get(fieldIndex).getType().getComponentType();
package org.opensearch.be.datafusion;
    MultiValueExpandRel(RelNode input, int fieldIndex) {  
import org.apache.calcite.rel.RelWriter;  
import org.apache.calcite.rel.type.RelDataTypeField;
 * This relation is used only for implicit multi-value GROUP BY semantics, where each document  
            throw new IllegalArgumentException("field " + fieldIndex + " is not a collection");
            builder.add(field.getName(), field.getType());
        this.expandedFieldName = candidate;
 * contributes at most once to each element bucket. The source LIST remains available to aggregate
        return builder.build();  
    }
 * The OpenSearch Contributors require contributions made to  
 */  
        super(input.getCluster(), input.getTraitSet(), input);
            candidate += "_";
import org.apache.calcite.rel.type.RelDataType;
        return getInput().getRowType().getFieldCount();  
    int fieldIndex() {
 * compatible open source license.
        }  
        this.fieldIndex = fieldIndex;
final class MultiValueExpandRel extends SingleRel {
/**
        List<RelDataTypeField> fields = getInput().getRowType().getFieldList();  
 *
        return fieldIndex;
        String candidate = "___mvexpand_" + fieldIndex;  
import org.apache.calcite.rel.RelNode;
    }
    }
 */  
    @Override  
    private final int fieldIndex;  
        return super.explainTerms(pw).item("field", getInput().getRowType().getFieldNames().get(fieldIndex))
    @Override
 *
import org.apache.calcite.plan.RelTraitSet;
        }
        while (input.getRowType().getFieldNames().contains(candidate)) {
        builder.add(expandedFieldName, getCluster().getTypeFactory().createTypeWithNullability(elementType, true));
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {
 * SPDX-License-Identifier: Apache-2.0
        return new MultiValueExpandRel(sole(inputs), fieldIndex);
        RelDataTypeFactory.Builder builder = getCluster().getTypeFactory().builder();
    private final String expandedFieldName;
        for (RelDataTypeField field : fields) {
import org.apache.calcite.rel.SingleRel;
    }  
    public RelWriter explainTerms(RelWriter pw) {  
import java.util.List;  
 * <p>The SQL frontend already represents explicit {@code mvexpand} as Correlate+Uncollect.
