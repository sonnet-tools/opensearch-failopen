import org.apache.calcite.rel.type.RelDataType;  
        // only walks the leftmost spine, which would miss the right-side TableScan in
import org.apache.calcite.rel.RelNode;
        this.finalAggCalled = true;
            this.shardScanFragment = fragment;
/*  
    public byte[] attachPartialAggOnTop(RelNode partialAggFragment, byte[] innerBytes) {
    }
        if (node instanceof TableScan scan) {
    @Override
        return null;
        }
 * Shared across DAG / FragmentConversionDriver tests so any test can assert on
        return ("attach:" + new String(innerBytes, StandardCharsets.UTF_8)).getBytes(StandardCharsets.UTF_8);
 * compatible open source license.
        // TableScan-shaped leaf (annotations are stripped before this is called, so
        // the production heuristic in DataFusionFragmentConvertor.  
    public boolean shardScanCalled;
    }  
        if (scan != null) {
 * this file be licensed under the Apache-2.0 license or a
        // Distinguish shard-scan vs reduce/final by searching the entire fragment tree for a
import java.nio.charset.StandardCharsets;  
        // Join(BroadcastScan, TableScan) — exercise a full tree walk here so the mock matches
        return "reduce".getBytes(StandardCharsets.UTF_8);
    @Override
            if (found != null) {
            this.shardScanCalled = true;  
            return scan;  
 *
    private static TableScan findAnyTableScan(RelNode node) {
        // OpenSearchTableScan has been rewritten to LogicalTableScan). RelNodeUtils.findNode  
        TableScan scan = findAnyTableScan(fragment);
import org.opensearch.analytics.spi.FragmentConvertor;
            TableScan found = findAnyTableScan(input);  
    public byte[] attachFragmentOnTop(RelNode fragment, byte[] innerBytes) {  
    public String shardScanTableName;
        return ("schemaOnlyRead:" + stageId).getBytes(StandardCharsets.UTF_8);
 * The OpenSearch Contributors require contributions made to  
public class RecordingConvertor implements FragmentConvertor {
    }
 */  
    public RelNode reduceFragment;  
            this.shardScanTableName = scan.getTable().getQualifiedName().getLast();
    }  
        }
    public byte[] convertSchemaOnlyRead(int stageId, RelDataType schema) {
    public RelNode shardScanFragment;
                return found;
    @Override  
    }
 */  
/**
        for (RelNode input : node.getInputs()) {
 * SPDX-License-Identifier: Apache-2.0
        }
            }  
        this.reduceFragment = fragment;  
    public byte[] convertFragment(RelNode fragment) {  
    public boolean finalAggCalled;  
    @Override
package org.opensearch.analytics.planner.dag;
            return ("shard:" + this.shardScanTableName).getBytes(StandardCharsets.UTF_8);  
 * the convertor surface that {@link FragmentConversionDriver#convertAll} hits.
 * Records which {@link FragmentConvertor} method was called and what was passed.  
        return ("partialAgg:" + new String(innerBytes, StandardCharsets.UTF_8)).getBytes(StandardCharsets.UTF_8);  
}
import org.apache.calcite.rel.core.TableScan;
