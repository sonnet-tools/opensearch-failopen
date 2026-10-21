            LOGGER.debug(
        //
            );
        public double getRowCount() {
    private final PlannerContext context;
        // 2. Metadata-only drivers (today: only Lucene via inverted index) stay viable if
 *
        // 1. Value-producing backends (DocValues / StoredFields) must cover EVERY field —
        // `amount`) would disqualify Lucene from every query against the index, even
            List<String> idxBackends = registry.indexScanBackendsForField(field);
     * the Substrait plan contains only the index name, not the Calcite catalog prefix.
        // TODO : How will they attach if we perform the index resolution
     * which lets cost-aware exchange operators distinguish small-input from large-input
            throw new IllegalStateException("No backend can scan all requested fields on table [" + tableName + "]");
        // alias is sound) and rejects filter aliases. Concrete-index names pass through as a
        List<String> fieldNames = scan.getRowType().getFieldList().stream().map(RelDataTypeField::getName).toList();
                context.getDistributionTraitDef()
            }
            }
        // they cover SOME field. Downstream ops that need a column the metadata driver
            context.getIndexNameExpressionResolver()
        // has already verified fields shared by multiple indices agree on type.
     * Wraps a {@link RelOptTable} with just the bare index name as the qualified name.
        if (admitMetadataDriver == false || metadataOnlyCoversAny == false) {
        }
        this.context = context;
     *
import org.opensearch.analytics.spi.DelegationType;
        // `age` and another has `alias`); the scan's row type is the union of all of them, so a
        FieldStorageResolver fieldStorageResolver = registry.resolveFieldStorage(resolution.concreteIndices());
        }
                idxCoversMetadataDriver
        List<FieldStorageInfo> fieldStorage = fieldStorageResolver.resolve(fieldNames);
            if (idxCoversMetadataDriver) {
        // only consulted when the setting allows it.
        final boolean admitMetadataDriver = context.preferMetadataDriver();
        );
        // When the cluster setting analytics.planner.prefer_metadata_driver is off, skip the
            context.getClusterState(),
                idxBackends,
import org.apache.calcite.plan.RelOptRule;
    private static final Logger LOGGER = LogManager.getLogger(OpenSearchTableScanRule.class);
     * we let the abstract base return its default.
                indexNameTable,
        // declares both Index AND DocValues — replace this hardcoded id with a
            if (field.isDerived()) {
 */
        // that happen to also have an inverted index. See
                dvBackends,
        // downstream ops can need any column's actual value, so a value-driver must be
        // value-producing check like any other backend, and (since Lucene declares no
            if (rowCount == PlannerContext.UNKNOWN_ROW_COUNT) {
        // driver" marker) so the planner can tell them apart from value-producing peers
     * <p>Carries an optional row count: when the planner context was wired with a real
        }
            boolean idxCoversMetadataDriver = idxBackends.contains(metadataOnlyDriver);
 * compatible open source license.
import org.opensearch.analytics.planner.PlannerContext;
        // TODO: today {@code "lucene"} is the only metadata-only driver, identified by
    public OpenSearchTableScanRule(PlannerContext context) {
        RelOptTable indexNameTable = new IndexNameTable(scan.getTable(), tableName, rowCount);
                field.getFieldName(),
        // alias can resolve to indices with differing field sets (e.g. test* where one index has
                scan.getCluster(),
        // Viable backends: must be able to read ALL requested fields
import org.apache.logging.log4j.Logger;
        List<String> delegationAcceptors = registry.delegationAcceptors(DelegationType.SCAN);
                metadataOnlyCoversAny = true;
import org.opensearch.analytics.planner.IndexResolution;
    }
 * SPDX-License-Identifier: Apache-2.0
        }
            List<String> dvBackends = registry.scanBackendsForField(field);
        }
        // second metadata-only backend (e.g. Tantivy) lands — or worse, a backend that
import org.opensearch.analytics.planner.CapabilityRegistry;
 * Converts {@link TableScan} → {@link OpenSearchTableScan}.
        //
        // (natively via doc values or via delegation to another backend that can read the field)
        IndexResolution resolution = IndexResolution.resolve(
        // Field storage is the union across all backing concrete indices. An index pattern or
        // queries that never reference it.
        // CapabilityRegistry.metadataOnlyScanBackends history for the prior precomputed
                if (dvBackends.contains(candidate)) return false;
        long rowCount = context.getTableRowCounts().applyAsLong(tableName);
/*
                return super.getRowCount();
        // validates that all backing indices have compatible mappings (so a query plan over an
        super(operand(TableScan.class, none()), "OpenSearchTableScanRule");
    public void onMatch(RelOptRuleCall call) {
        // single index would spuriously fail to resolve fields it happens to omit. IndexResolution
                field.getDocValueFormats(),
        String tableName = scan.getTable().getQualifiedName().getLast();
     * <p>TODO: Move table name stripping to the SQL/PPL plugin before dispatching the RelNode
        // permissive metadata-only gate entirely — the metadata driver runs the strict
import org.apache.calcite.rel.type.RelDataTypeField;
import org.opensearch.analytics.spi.FieldStorageInfo;
        );
import org.apache.logging.log4j.LogManager;
 */
        // can't reach (e.g. Project on a numeric field) self-restrict and PlanForker's
                return !delegationSupporters.contains(candidate) || dvBackends.stream().noneMatch(delegationAcceptors::contains);
 *
                throw new IllegalStateException(
    private static class IndexNameTable extends RelOptAbstractTable {
        // only chain that makes it through end-to-end is the count fast-path shape:
        @Override
     */
import org.apache.calcite.plan.RelOptRuleCall;
            this.rowCount = rowCount;
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
        }
        // membership in the per-field {@code FieldStorageInfo.getIndexFormats()}. When a
            }
            // Index-scan viability must respect the backend's declared supported field types, not
public class OpenSearchTableScanRule extends RelOptRule {
        // count(*) / count(col) over filters touching only Lucene-indexable fields.
import java.util.List;
 * The OpenSearch Contributors require contributions made to
                resolution.totalShardCount(),
 * per-column {@link FieldStorageInfo} from IndexMetadata mappings.
                    "TableScan encountered derived field [" + field.getFieldName() + "] — derived fields cannot appear in a scan"
                "[table-scan] field={} type={} indexFormats={} docValueFormats={} dvBackends={} idxBackends={} idxCoversMetadata={}",
        // Permissive: keep the metadata-only driver viable iff it covers at least one field —
 * @opensearch.internal
        CapabilityRegistry registry = context.getCapabilityRegistry();
        LOGGER.debug("[table-scan] viableBackends={}", viableBackends);
            viableBackends.removeIf(candidate -> {
                if (admitMetadataDriver && candidate.equals(metadataOnlyDriver)) return false; // metadata-only handled below
     *
        // singleton list.
            // just the field's indexFormats. A keyword field with indexFormats=[lucene] satisfies
import org.apache.calcite.plan.RelOptTable;
            super(delegate.getRelOptSchema(), indexName, delegate.getRowType());
        // first-class identifier on {@code BackendCapabilityProvider} (e.g. a "metadata
     * to the analytics engine, so the scan rule always receives bare index names.
 * Resolves backend from index data format settings and populates
import org.apache.calcite.rel.core.TableScan;
                viableBackends,
            return rowCount;
/**
        // Resolve the table name to one or more concrete indices. {@link IndexResolution}
            OpenSearchTableScan.create(
        // TODO: also check StoredFields scan capability once stored field support is implemented
                );
        // post-fork pruning needed downstream.
    }
            return;
            });
     * Isthmus reads {@code getQualifiedName()} when creating {@code NamedScan} — this ensures
        if (viableBackends.isEmpty()) {
        call.transformTo(
    /**
     * statistics source (e.g. IndicesStats), the count overrides Calcite's default 100.0,
        // able to deliver all of them. Original strict invariant.
        // chain-agreement filter drops the driver from the surviving alternatives. The
                field.getIndexFormats(),
            // Strict: every value-producing candidate must cover this field (or delegate to one
        IndexNameTable(RelOptTable delegate, String indexName, long rowCount) {
        TableScan scan = call.rel(0);
        List<String> delegationSupporters = registry.delegationSupporters(DelegationType.SCAN);
        // Without the split, a single non-keyword field in the scan's row type (e.g.
package org.opensearch.analytics.planner.rules;
            )
    @Override
        for (FieldStorageInfo field : fieldStorage) {
     * plans during CBO. {@link PlannerContext#UNKNOWN_ROW_COUNT} (-1) means "no stats" and
}
        // value-producing scan today) gets dropped at the scan level. No alternatives, no
            // physically in Lucene, no backend declares an Index scan over numerics today.
        // Two-phase field coverage check:
        private final long rowCount;
            // that does). When admitMetadataDriver=false the metadata driver is held to the same
        // set; collapsed for now to keep the registry surface small.
    }
import java.util.ArrayList;
            // strict rule; when true it's exempt here and the permissive check below decides.
            tableName,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.planner.FieldStorageResolver;
        if (scan instanceof OpenSearchTableScan) {
import org.apache.calcite.plan.RelOptAbstractTable;
            // a numeric field with the same indexFormats does not — even though its values are
            viableBackends.remove(metadataOnlyDriver);
        boolean metadataOnlyCoversAny = false;
                field.getFieldType(),
                fieldStorage,
        final String metadataOnlyDriver = "lucene";
        // TODO : This expects the FrontEnds to attach the row type with all fields.
            // Lucene's Index(supportedFieldTypes={KEYWORD, TEXT, MATCH_ONLY_TEXT}) cap;
        List<String> viableBackends = new ArrayList<>(registry.scanCapableBackends());
