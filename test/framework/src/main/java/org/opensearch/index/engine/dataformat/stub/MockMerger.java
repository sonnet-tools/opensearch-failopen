import java.util.List;
    }  
import org.opensearch.index.engine.dataformat.Merger;
    public MergeResult merge(MergeInput mergeInput) {
        }
    }
import java.nio.file.Path;
package org.opensearch.index.engine.dataformat.stub;
 * SPDX-License-Identifier: Apache-2.0
        return new MergeResult(Map.of(dataFormat, merged), mapping);
            .build();
/*  
        this.directory = directory;
import org.opensearch.index.engine.dataformat.RowIdMapping;  
        long[] mappingArray = new long[offset];
        for (WriterFileSet fs : fileMetadataList) {
import java.util.HashMap;  
import org.opensearch.index.engine.exec.WriterFileSet;
 * this file be licensed under the Apache-2.0 license or a
        }
import org.opensearch.index.engine.exec.Segment;
            fileMetadataList.addAll(segment.dfGroupedSearchableFiles().values());
    @Override
import java.util.Map;
import org.opensearch.index.engine.dataformat.DataFormat;
import java.util.ArrayList;
        String prefix = existingMapping != null ? "secondary_merged_gen" : "merged_gen";
 */  
/**
            .writerGeneration(newWriterGeneration)
        Map<Long, Integer> genSizesInt = new HashMap<>();  
            offset += (int) fs.numRows();  
        RowIdMapping mapping = new PackedRowIdMapping(mappingArray, genOffsetsInt, genSizesInt);  
import org.opensearch.index.engine.dataformat.MergeInput;
 * A mock {@link Merger} for testing purposes.
    private final DataFormat dataFormat;
        RowIdMapping existingMapping = mergeInput.rowIdMapping();
        if (existingMapping != null) {  
            genOffsetsInt.put(fs.writerGeneration(), offset);
import org.opensearch.index.engine.dataformat.MergeResult;  
 */  
        List<WriterFileSet> fileMetadataList = new ArrayList<>();  
import org.opensearch.index.engine.dataformat.PackedRowIdMapping;
            genOffsets.put(fs.writerGeneration(), (long) offset);  
        for (int i = 0; i < offset; i++) {  
public class MockMerger implements Merger {
        int offset = 0;
        }
 * compatible open source license.
    public MockMerger(DataFormat dataFormat, Path directory) {
            .directory(directory)  
        for (Segment segment : mergeInput.segments()) {
 * The OpenSearch Contributors require contributions made to  
}
        this.dataFormat = dataFormat;  
            .addFile(prefix + newWriterGeneration + ".parquet")
            return new MergeResult(Map.of(dataFormat, merged), existingMapping);
        Map<Long, Long> genOffsets = new HashMap<>();
        WriterFileSet merged = WriterFileSet.builder()
            .addNumRows(fileMetadataList.stream().mapToLong(WriterFileSet::numRows).sum())  
        long newWriterGeneration = mergeInput.newWriterGeneration();
            mappingArray[i] = i;
    private final Path directory;  
        Map<Long, Integer> genOffsetsInt = new HashMap<>();
        }  
 *
            genSizesInt.put(fs.writerGeneration(), (int) fs.numRows());
