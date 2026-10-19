import org.opensearch.index.engine.dataformat.RowIdMapping;  
                    }
            throw new UncheckedIOException((IOException) e);
            segments.add(Segment.builder(wfs.writerGeneration()).addSearchableFiles(format, wfs).build());
        Map<DataFormat, WriterFileSet> merged = new HashMap<>();  
    }
     * Executes the merge described by the plan.
    private FormatMergeResult mergeFormat(MergePlan plan, DataFormat format, RowIdMapping mapping) throws IOException {
                .liveDocs(plan.liveDocs())
                            + plan.primaryFormat().name()  
    }
import java.util.List;
import org.opensearch.index.engine.dataformat.Merger;
                                + primaryRows  
    public CompositeMergeExecutor(Map<DataFormat, Merger> mergers) {
 * The OpenSearch Contributors require contributions made to  
                                + " rows"
import org.opensearch.index.engine.dataformat.MergeInput;  
                ? primaryResult.rowIdMappingOpt()
 */  
import java.io.UncheckedIOException;
                        throw new IllegalStateException(
                    .orElseThrow(() -> new IllegalStateException("Primary merge did not produce row-ID mapping required by secondaries"))  
                            + "] returned null — possible concurrent merge consumed segments"  
     */
import java.util.ArrayList;  
                }
            return toMergeResult(completed, mapping);  
                            + secondary.name()
/*  
 * @opensearch.experimental
                .segments(segments)
                    long primaryRows = primaryResult.mergedFiles().numRows();
            completed.add(primaryResult);
        }  
        List<WriterFileSet> files = plan.filesFor(format);
        MergeResult result = merger.merge(  
import org.opensearch.common.annotation.ExperimentalApi;
            for (DataFormat secondary : plan.secondaryFormats()) {  
import java.io.IOException;
    }
                            "Row count mismatch after merge: primary format ["  
                                + "] has "
        return new MergeResult(merged, mapping);
            FormatMergeResult primaryResult = mergeFormat(plan, plan.primaryFormat(), null);
            completed.forEach(FormatMergeResult::cleanup);
 *  
                                + " rows but secondary format ["
    public MergeResult execute(MergePlan plan) {
            RowIdMapping mapping = plan.hasSecondaries()
                    );
        } catch (Exception e) {
                        );  
            if (e instanceof RuntimeException re) throw re;  
                completed.add(secondaryResult);  
 *
        }
        return new FormatMergeResult(format, result.getMergedWriterFileSetForDataformat(format), result.rowIdMapping().orElse(null));
 * SPDX-License-Identifier: Apache-2.0
                    throw new IllegalStateException(
                if (primaryResult.mergedFiles() != null && secondaryResult.mergedFiles() != null) {
import java.util.HashMap;
        for (WriterFileSet wfs : files) {  
}  
        try {  
public class CompositeMergeExecutor {
                                + secondary.name()
import java.util.Map;  
/**
        this.mergers = Map.copyOf(mergers);  
 * Executes a composite merge: primary format first, then secondaries using the  
                                + secondaryRows
 */
        return mergers.get(format);
        List<Segment> segments = new ArrayList<>();
     *  
 * {@link MergePlan} and the merger map.
        List<FormatMergeResult> completed = new ArrayList<>();
            MergeInput.builder()
                    if (primaryRows != secondaryRows) {
    }  
    }  
    public Merger getMerger(DataFormat format) {  
    /**
        }
                        "Primary format ["
        );
        Merger merger = mergers.get(format);  
                    long secondaryRows = secondaryResult.mergedFiles().numRows();  
@ExperimentalApi  
import org.opensearch.index.engine.dataformat.MergeResult;
            }
import org.opensearch.index.engine.dataformat.DataFormat;
                // Verify secondary merged row count matches primary  
        for (FormatMergeResult r : results) {
                                + "] has "  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
     * Returns the merger registered for the given data format, or {@code null} if absent.
                                + plan.primaryFormat().name()
                            + "] produced merged output but secondary format ["
                FormatMergeResult secondaryResult = mergeFormat(plan, secondary, mapping);
     */  
     * @return the combined merge result across all formats
                if (primaryResult.mergedFiles() != null && secondaryResult.mergedFiles() == null) {  
            merged.put(r.format(), r.mergedFiles());
     * @param plan the pre-validated merge plan
    private static MergeResult toMergeResult(List<FormatMergeResult> results, RowIdMapping mapping) {
import org.opensearch.index.engine.exec.WriterFileSet;
                // Verify secondary produced output when primary did
    private final Map<DataFormat, Merger> mergers;  
                .newWriterGeneration(plan.mergedWriterGeneration())
                : null;
package org.opensearch.composite.merge;
                }
                .build()  
    /**  
 * row-ID mapping from the primary. Stateless — all state comes from the
import org.opensearch.index.engine.exec.Segment;
                .rowIdMapping(mapping)  
