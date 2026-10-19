    }
     * {@code registerPartitionStream}.  
    /**
 *   <li>{@code attachPartialAggOnTop(PartialAgg, innerBytes)} → data node bytes</li>
     */
        throw new UnsupportedOperationException("convertFragment not implemented for this backend");
 * conversion by calling composable methods in sequence — each method converts a single
     * @param partialAggFragment the partial aggregate RelNode (annotations stripped, no children)
     *  
 *  
 *  
     * aggregate execution node.
     * backend-specific serialized plan bytes. The fragment may be:  
 *   <li>{@code attachFragmentOnTop(Sort, innerBytes)} → reduce stage bytes</li>  
     * and is called only by analytics-engine. Consider moving to analytics-engine and
     *
     *       named-table reads pointing at the streaming input partition.</li>
    /**
     * @param innerBytes serialized bytes from a prior {@code convert*} or {@code attach*} call  
    }  
     * scatter-gather) but whose parent reduce sink still needs a partition schema for
     */  
    }  
 * testable at the analytics-engine level.
 */  
     *  
 * Fragment conversion API for backend plugins.
    default byte[] attachFragmentOnTop(RelNode fragment, byte[] innerBytes) {  
 * SPDX-License-Identifier: Apache-2.0
     * <ul>
 *
     * consults this when deriving a child stage's partition schema. Default  
     * given operator.  
     * <p>TODO: revisit placement of FragmentConvertor — it references Calcite RelNode  
 * <p>Design principle: backends never traverse the plan. Analytics-engine orchestrates
     * @return backend-specific serialized plan bytes
     * @param fragment resolved RelNode fragment
     * inner bytes. The backend deserializes the inner plan and wraps it with the
     * Attaches a partial aggregate on top of already-converted inner bytes.  
     * operators above. Used for stages whose runtime is non-Substrait (e.g. QTF
    default byte[] attachPartialAggOnTop(RelNode partialAggFragment, byte[] innerBytes) {
/*  
     * Attaches a generic fragment (Sort, Project, etc.) on top of already-converted
     * The backend deserializes the inner plan and wraps it with its partial
 *
    default byte[] convertFragment(RelNode fragment) {
     * @return serialized plan bytes
 * <ol>
     *   <li>A reduce-stage final-aggregate fragment whose leaf is  
 * </ol>
     *   <li>A shard-scan subtree below a partial aggregate (e.g. Filter(Scan), Scan).</li>
 */
 * this file be licensed under the Apache-2.0 license or a
 *
     * @param innerBytes         serialized bytes from a prior {@link #convertFragment} call
}
    }
 * The OpenSearch Contributors require contributions made to  
    default WireFormat wireFormat() {
 *   <li>{@code convertFragment(Filter(Scan))} → data node inner bytes</li>  
     */
     * @param rowType      the partition's row type  
 * and {@code appendShuffleWriter} when shuffle joins/aggregates are implemented.
     *
    }
 * compatible open source license.
public interface FragmentConvertor {
     * Builds a schema-only stub plan describing a stage's output partition: a single
    /**
 *   <li>{@code convertFragment(FinalAgg(StageInputScan))} → reduce stage inner bytes</li>
 * <p>Composable pipeline for multi-shard aggregate with sort at coordinator:
     *   <li>A coord-only literal source (e.g. {@code OpenSearchValues}).</li>  
package org.opensearch.analytics.spi;
        throw new UnsupportedOperationException("attachFragmentOnTop not implemented for this backend");
    /**
    default byte[] convertSchemaOnlyRead(int childStageId, RelDataType rowType) {  
     * @return serialized plan bytes with the fragment attached on top
        return WireFormat.SELF_DESCRIBING;
        throw new UnsupportedOperationException("convertSchemaOnlyRead not implemented for this backend");
     * @param childStageId stage id whose output schema this stub describes
     *       {@code OpenSearchStageInputScan} — the backend rewrites these to
/**
     * {@code Read { named_table: "input-<childStageId>"; base_schema: rowType }}, no  
     * {@link WireFormat#SELF_DESCRIBING}; backends with a custom wire format return
     *
     */
import org.apache.calcite.rel.RelNode;
 * backends simple (no tree walking) and makes the conversion pipeline explicit and
 * <p>TODO: add {@code convertShuffleReadFragment}, {@code convertInMemoryFragment},  
     * @return serialized plan bytes with partial aggregate attached on top  
        throw new UnsupportedOperationException("attachPartialAggOnTop not implemented for this backend");  
import org.apache.calcite.rel.type.RelDataType;
     * </ul>
    /**  
     * Converts a resolved RelNode fragment (annotations stripped) into
 * @opensearch.internal  
     * @param fragment   the operator RelNode to attach (annotations stripped, no children)
     * removing getFragmentConvertor() from AnalyticsSearchBackendPlugin SPI.
     */  
     * {@link WireFormat#OPAQUE} and MUST also override {@link #convertSchemaOnlyRead}.
 * operator or small fragment, and the results are composed by the caller. This keeps  
     * Wire-format contract for the bytes {@link #convertFragment} produces. The reducer
