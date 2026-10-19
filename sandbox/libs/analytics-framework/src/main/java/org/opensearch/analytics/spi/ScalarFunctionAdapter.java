     */  
     * compatibility depends on the Calcite logical type, not the OpenSearch storage
 * Per-function adapter that transforms a backend-agnostic scalar function
package org.opensearch.analytics.spi;
}
     * type. Use {@code fieldStorage} for decisions that depend on OpenSearch-specific  
import org.apache.calcite.plan.RelOptCluster;
     *                     for constructing new RexNodes
 *
@FunctionalInterface
     *  
public interface ScalarFunctionAdapter {  
    /**
     *
import java.util.List;
 * <p>Example: {@code SIN(BIGINT)} → {@code SIN(CAST(BIGINT → DOUBLE))} because  
import org.apache.calcite.rex.RexNode;  
 * {@link RexCall} into a backend-compatible form. Registered by backends  
 * @opensearch.internal  
     * {@code VARCHAR} in Calcite but different storage semantics in OpenSearch).
 * this file be licensed under the Apache-2.0 license or a
     * on the operand ({@code operand.getType().getSqlTypeName()}) — Substrait
    RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster);
 */  
     * @param fieldStorage positional field storage info from the operator's child,
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
     * expression, or the original unchanged if no adaptation is needed.
 *
 * The OpenSearch Contributors require contributions made to  
     * @param original     the backend-agnostic expression to adapt
     * @param cluster      provides {@code getRexBuilder()} and {@code getTypeFactory()}
 * Substrait only declares {@code sin(fp32)} and {@code sin(fp64)}.
     * <p>For type-conversion decisions (e.g., inserting CAST), use the Calcite type  
     * type distinctions that Calcite cannot express (e.g., keyword vs text — both
/**
import org.apache.calcite.rex.RexCall;
 */
     *                     indexed by {@link org.apache.calcite.rex.RexInputRef#getIndex()}  
     * Adapt the given expression for backend compatibility. Returns the adapted  
/*  
 * alongside their capability declarations, keyed by {@link ScalarFunction}.
 *
