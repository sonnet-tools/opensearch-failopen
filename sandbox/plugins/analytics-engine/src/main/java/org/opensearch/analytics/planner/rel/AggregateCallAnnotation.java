        this.viableBackends = viableBackends;
 */  
}
 * @opensearch.internal
    }
    public AggregateCallAnnotation(List<String> viableBackends, int annotationId) {  
        return viableBackends;  
    }
package org.opensearch.analytics.planner.rel;
        return new AggregateCallAnnotation(List.of(backend), annotationId);
    public int getAnnotationId() {
import java.util.List;  
        return annotationId;
    public RexNode withAdaptedOriginal(RexNode adaptedOriginal) {
    public RexNode unwrap() {
/**
    private final int annotationId;
    @Override
 * this file be licensed under the Apache-2.0 license or a
        return null;
    }  
    }
/*  
public final class AggregateCallAnnotation implements OperatorAnnotation {
 * preOperands, which would corrupt return-type inference for PPL's {@code ARG0_ARRAY}.  
    @Override
 * SPDX-License-Identifier: Apache-2.0
 *
    @Override  
    public List<String> getViableBackends() {
        // Marker — stripping handled out-of-band by OpenSearchAggregate#stripAnnotations.  
 * of {@code AggregateCall#rexList} avoids contaminating Calcite's {@code AggCallBinding}
    }  
 */  
    }
 *
    private final List<String> viableBackends;  
 * Stored on {@link OpenSearchAggregate} as a side-map keyed by call index — keeping it out
 * compatible open source license.
        return null;  
    @Override
    public OperatorAnnotation narrowTo(String backend) {  
import org.apache.calcite.rex.RexNode;
 * Per-call backend routing metadata for an {@link org.apache.calcite.rel.core.AggregateCall}.  
 * The OpenSearch Contributors require contributions made to  
        this.annotationId = annotationId;
