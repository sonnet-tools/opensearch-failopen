     *  
        // Two-phase field coverage check:
        List<String> delegationSupporters = registry.delegationSupporters(DelegationType.SCAN);  
            OpenSearchTableScan.create(  
        // post-fork pruning needed downstream.  
     * <p>TODO: Move table name stripping to the SQL/PPL plugin before dispatching the RelNode
            }
        // downstream ops can need any column's actual value, so a value-driver must be  
        // value-producing scan today) gets dropped at the scan level. No alternatives, no
import org.opensearch.analytics.planner.PlannerContext;  
                field.getDocValueFormats(),
/**
        // permissive metadata-only gate entirely — the metadata driver runs the strict  
                field.getIndexFormats(),  
     * statistics source (e.g. IndicesStats), the count overrides Calcite's default 100.0,
 * The OpenSearch Contributors require contributions made to  
     * plans during CBO. {@link PlannerContext#UNKNOWN_ROW_COUNT} (-1) means "no stats" and
    private static class IndexNameTable extends RelOptAbstractTable {
            }
 */
        long rowCount = context.getTableRowCounts().applyAsLong(tableName);
        IndexNameTable(RelOptTable delegate, String indexName, long rowCount) {
            )
import org.apache.logging.log4j.LogManager;
 * Converts {@link TableScan} → {@link OpenSearchTableScan}.  
 * this file be licensed under the Apache-2.0 license or a
        // TODO : How will they attach if we perform the index resolution
        // Resolve the table name to one or more concrete indices. {@link IndexResolution}
            // physically in Lucene, no backend declares an Index scan over numerics today.
     * Isthmus reads {@code getQualifiedName()} when creating {@code NamedScan} — this ensures
        // count(*) / count(col) over filters touching only Lucene-indexable fields.
                if (admitMetadataDriver && candidate.equals(metadataOnlyDriver)) return false; // metadata-only handled below
import org.apache.calcite.plan.RelOptRule;
        //
        // set; collapsed for now to keep the registry surface small.  
            LOGGER.debug(
        // `age` and another has `alias`); the scan's row type is the union of all of them, so a
    /**
    private static final Logger LOGGER = LogManager.getLogger(OpenSearchTableScanRule.class);
        List<String> viableBackends = new ArrayList<>(registry.scanCapableBackends());
            throw new IllegalStateException("No backend can scan all requested fields on table [" + tableName + "]");
        super(operand(TableScan.class, none()), "OpenSearchTableScanRule");
                fieldStorage,
import org.apache.calcite.rel.type.RelDataTypeField;  
            boolean idxCoversMetadataDriver = idxBackends.contains(metadataOnlyDriver);
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
            this.rowCount = rowCount;  
 *
        // TODO: also check StoredFields scan capability once stored field support is implemented
    public void onMatch(RelOptRuleCall call) {  
        }  
    @Override
        }
        // validates that all backing indices have compatible mappings (so a query plan over an  
        // Permissive: keep the metadata-only driver viable iff it covers at least one field —  
        // declares both Index AND DocValues — replace this hardcoded id with a
        // 1. Value-producing backends (DocValues / StoredFields) must cover EVERY field —
import java.util.ArrayList;
            // that does). When admitMetadataDriver=false the metadata driver is held to the same
import org.opensearch.analytics.spi.FieldStorageInfo;  
            context.getClusterState(),
                idxBackends,  
 * Resolves backend from index data format settings and populates
        public double getRowCount() {
    public OpenSearchTableScanRule(PlannerContext context) {  
        if (scan instanceof OpenSearchTableScan) {
     * <p>Carries an optional row count: when the planner context was wired with a real
import org.apache.calcite.rel.core.TableScan;
import org.apache.calcite.plan.RelOptAbstractTable;
        );
     * we let the abstract base return its default.
        List<String> delegationAcceptors = registry.delegationAcceptors(DelegationType.SCAN);
        // membership in the per-field {@code FieldStorageInfo.getIndexFormats()}. When a
            // a numeric field with the same indexFormats does not — even though its values are
        this.context = context;
        }
import org.opensearch.analytics.planner.CapabilityRegistry;  
        // TODO: today {@code "lucene"} is the only metadata-only driver, identified by
     */  
     * the Substrait plan contains only the index name, not the Calcite catalog prefix.
        );
        final boolean admitMetadataDriver = context.preferMetadataDriver();
            if (idxCoversMetadataDriver) {
            if (rowCount == PlannerContext.UNKNOWN_ROW_COUNT) {
            viableBackends.removeIf(candidate -> {  
        // alias can resolve to indices with differing field sets (e.g. test* where one index has  
import org.apache.logging.log4j.Logger;
        // driver" marker) so the planner can tell them apart from value-producing peers  
                return super.getRowCount();  
import java.util.List;  
            // Strict: every value-producing candidate must cover this field (or delegate to one  
        // they cover SOME field. Downstream ops that need a column the metadata driver  
        }
        CapabilityRegistry registry = context.getCapabilityRegistry();
                context.getDistributionTraitDef()  
        // Field storage is the union across all backing concrete indices. An index pattern or
                indexNameTable,
        // `amount`) would disqualify Lucene from every query against the index, even
package org.opensearch.analytics.planner.rules;
        //  
 * compatible open source license.
        // Without the split, a single non-keyword field in the scan's row type (e.g.  
        }  
            List<String> dvBackends = registry.scanBackendsForField(field);  
        // CapabilityRegistry.metadataOnlyScanBackends history for the prior precomputed
        for (FieldStorageInfo field : fieldStorage) {  
        // can't reach (e.g. Project on a numeric field) self-restrict and PlanForker's
        // When the cluster setting analytics.planner.prefer_metadata_driver is off, skip the
                resolution.totalShardCount(),
        List<String> fieldNames = scan.getRowType().getFieldList().stream().map(RelDataTypeField::getName).toList();  
            });
                field.getFieldType(),
        // chain-agreement filter drops the driver from the surviving alternatives. The
    private final PlannerContext context;
            if (field.isDerived()) {
                    "TableScan encountered derived field [" + field.getFieldName() + "] — derived fields cannot appear in a scan"  
            viableBackends.remove(metadataOnlyDriver);  
     * to the analytics engine, so the scan rule always receives bare index names.
        IndexResolution resolution = IndexResolution.resolve(  
     * Wraps a {@link RelOptTable} with just the bare index name as the qualified name.  
import org.opensearch.analytics.planner.FieldStorageResolver;
    }
            return;  
            // Lucene's Index(supportedFieldTypes={KEYWORD, TEXT, MATCH_ONLY_TEXT}) cap;  
import org.opensearch.analytics.planner.IndexResolution;
            }
        // (natively via doc values or via delegation to another backend that can read the field)
                idxCoversMetadataDriver
        // has already verified fields shared by multiple indices agree on type.  
            tableName,
        FieldStorageResolver fieldStorageResolver = registry.resolveFieldStorage(resolution.concreteIndices());
        @Override  
                field.getFieldName(),
        // Viable backends: must be able to read ALL requested fields  
                dvBackends,
import org.apache.calcite.plan.RelOptRuleCall;  
            super(delegate.getRelOptSchema(), indexName, delegate.getRowType());
        private final long rowCount;
     *  
        final String metadataOnlyDriver = "lucene";
        LOGGER.debug("[table-scan] viableBackends={}", viableBackends);
/*  
        // able to deliver all of them. Original strict invariant.
import org.apache.calcite.plan.RelOptTable;
                throw new IllegalStateException(
            );
                viableBackends,  
}
        RelOptTable indexNameTable = new IndexNameTable(scan.getTable(), tableName, rowCount);  
            List<String> idxBackends = registry.indexScanBackendsForField(field);  
            // strict rule; when true it's exempt here and the permissive check below decides.
        if (viableBackends.isEmpty()) {
        // single index would spuriously fail to resolve fields it happens to omit. IndexResolution
            context.getIndexNameExpressionResolver()  
            // Index-scan viability must respect the backend's declared supported field types, not
import org.opensearch.analytics.spi.DelegationType;
        // value-producing check like any other backend, and (since Lucene declares no
        // alias is sound) and rejects filter aliases. Concrete-index names pass through as a
                );
                if (dvBackends.contains(candidate)) return false;
        // second metadata-only backend (e.g. Tantivy) lands — or worse, a backend that  
        // queries that never reference it.
        if (admitMetadataDriver == false || metadataOnlyCoversAny == false) {
        // singleton list.
 *  
 * @opensearch.internal
 */  
        // TODO : This expects the FrontEnds to attach the row type with all fields.
            return rowCount;
public class OpenSearchTableScanRule extends RelOptRule {  
        boolean metadataOnlyCoversAny = false;
        TableScan scan = call.rel(0);
                return !delegationSupporters.contains(candidate) || dvBackends.stream().noneMatch(delegationAcceptors::contains);  
                "[table-scan] field={} type={} indexFormats={} docValueFormats={} dvBackends={} idxBackends={} idxCoversMetadata={}",  
        // first-class identifier on {@code BackendCapabilityProvider} (e.g. a "metadata
        // 2. Metadata-only drivers (today: only Lucene via inverted index) stay viable if
 * SPDX-License-Identifier: Apache-2.0
    }  
        // only chain that makes it through end-to-end is the count fast-path shape:  
     * which lets cost-aware exchange operators distinguish small-input from large-input  
            // just the field's indexFormats. A keyword field with indexFormats=[lucene] satisfies
        call.transformTo(
        // that happen to also have an inverted index. See
                scan.getCluster(),
        List<FieldStorageInfo> fieldStorage = fieldStorageResolver.resolve(fieldNames);
        String tableName = scan.getTable().getQualifiedName().getLast();  
        // only consulted when the setting allows it.
                metadataOnlyCoversAny = true;  
 * per-column {@link FieldStorageInfo} from IndexMetadata mappings.
    }  
        }
