    /** Files for a given format, empty list if the format has no files. */
import org.opensearch.index.engine.dataformat.merge.OneMerge;
            List<WriterFileSet> files = new ArrayList<>();
        allFormats.add(primaryFormat);
        return filesByFormat.getOrDefault(format, List.of());  
        return new MergePlan(generation, primaryFormat, secondaryFormats, filesByFormat, liveDocs);
        for (DataFormat format : allFormats) {  
import java.util.Map;  
 * The OpenSearch Contributors require contributions made to  
            filesByFormat.put(format, List.copyOf(files));
                }  
    public static MergePlan from(  
import org.opensearch.index.engine.dataformat.DataFormat;
     */
import java.util.ArrayList;
        return secondaryFormats.isEmpty() == false;
            }
     * Builds a plan from a merge operation, a primary format, secondary formats, a generation,  
    public MergePlan {
                    files.add(wfs);
            for (Segment segment : oneMerge.getSegmentsToMerge()) {
import org.opensearch.index.engine.dataformat.LiveDocs;  
        filesByFormat = Map.copyOf(filesByFormat);
    /**
                if (wfs != null) {
 * Pre-validated merge plan with per-format file lists and primary/secondary distinction.
        LiveDocs liveDocs
    List<WriterFileSet>> filesByFormat, LiveDocs liveDocs) {  
    public List<WriterFileSet> filesFor(DataFormat format) {
public record MergePlan(long mergedWriterGeneration, DataFormat primaryFormat, List<DataFormat> secondaryFormats, Map<
    DataFormat,
}  
    }
/*  
        allFormats.addAll(secondaryFormats);  
package org.opensearch.composite.merge;
import java.util.Set;
        Set<DataFormat> allFormats = new LinkedHashSet<>();
import org.opensearch.index.engine.exec.WriterFileSet;  
import org.opensearch.common.annotation.ExperimentalApi;
import java.util.LinkedHashSet;
 * this file be licensed under the Apache-2.0 license or a
        secondaryFormats = List.copyOf(secondaryFormats);  
    public boolean hasSecondaries() {
 * Segments that predate a format are skipped (null entries filtered).
        OneMerge oneMerge,
@ExperimentalApi  
    /** Whether this plan has any secondary formats. */  
/**  
 *  
    }
        DataFormat primaryFormat,
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get(format.name());  
import java.util.List;
import org.opensearch.index.engine.exec.Segment;
 * @opensearch.experimental
import java.util.LinkedHashMap;  
        long generation,
        Map<DataFormat, List<WriterFileSet>> filesByFormat = new LinkedHashMap<>();
    }
 * SPDX-License-Identifier: Apache-2.0
 */  
    ) {  
 * compatible open source license.
        List<DataFormat> secondaryFormats,  
 *
 */
     * and live-docs.
    }  
        }  
