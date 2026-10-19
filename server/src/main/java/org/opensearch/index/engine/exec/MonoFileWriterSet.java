    }
 * file per writer generation) should use this class to make the single-file invariant
    /**
            throw new IllegalArgumentException(
        );
     */  
 * The OpenSearch Contributors require contributions made to  
    /**
     * Returns the single file in this set.  
        return of(directory.toAbsolutePath().toString(), writerGeneration, file, numRows, 0L);  
     */
    private final String file;
    }
import org.opensearch.core.common.io.stream.StreamInput;
     *
     * @param writerGeneration the writer generation that produced this file
            + formatVersion()
 * Since this extends {@link WriterFileSet}, it is substitutable anywhere the base class  
    public MonoFileWriterSet(StreamInput in, String directory, long version) throws IOException {
 */
    public String toString() {  
     * Creates a MonoFileWriterSet from a directory path, generation, file name, row count, and format version.
 * this file be licensed under the Apache-2.0 license or a
     */  
     * @param directory        the directory containing the file  
     * Creates a MonoFileWriterSet from a directory path, generation, file name, and row count.  
    }
        return of(directory, writerGeneration, file, numRows, 0L);  
 * A {@link WriterFileSet} subclass that guarantees exactly one file per writer generation.
 *
     * @param numRows          the number of rows in the file  
public final class MonoFileWriterSet extends WriterFileSet {  
 * are present.
        }
        if (wfs instanceof MonoFileWriterSet mono) {  
            wfs.formatVersion()  
        }
            wfs.files().iterator().next(),
import java.util.Set;
    @Override
 * @opensearch.experimental  
    /**
    }
                    + " files: "  
     * Deserializes a MonoFileWriterSet from a stream.
package org.opensearch.index.engine.exec;
                "MonoFileWriterSet requires exactly one file per generation, but generation "
 * SPDX-License-Identifier: Apache-2.0
        if (wfs.files().size() != 1) {  
    /**  
    public static MonoFileWriterSet from(WriterFileSet wfs) {
import java.nio.file.Path;  
     */
        if (file == null || file.isEmpty()) {
    }
    public void writeTo(StreamOutput out) throws IOException {
        return file;  
     */
     */
    }  
import java.io.IOException;
            + ", formatVersion="
import org.opensearch.common.annotation.ExperimentalApi;
    @Override  
            wfs.numRows(),
 * is accepted — no conversion needed. Use {@link #file()} for direct single-file access.
     *
            + ", file="
            + ", writerGeneration="  
 */  
     * @param file             the single file name
     * Creates a MonoFileWriterSet from explicit values, including a data-format version.
        return new MonoFileWriterSet(
    }
    }  
     * @throws IllegalArgumentException if the file set does not contain exactly one file  
     * @param writerGeneration the writer generation that produced this file
        out.writeLong(writerGeneration());
 *
 * <p>
    public String file() {
        this(directory, in.readLong(), in.readString(), in.readLong(), version);
     * Creates a MonoFileWriterSet from explicit values.
 * (e.g., native readers that map one file = one segment) silently break if multiple files  
@ExperimentalApi
 * <p>
            + writerGeneration()
                    + wfs.files()
    public static MonoFileWriterSet of(Path directory, long writerGeneration, String file, long numRows) {
        return of(directory.toAbsolutePath().toString(), writerGeneration, file, numRows, formatVersion);
            + file  
            return mono;
    private MonoFileWriterSet(String directory, long writerGeneration, String file, long numRows, long formatVersion) {
     * contains exactly one file.  
    public static MonoFileWriterSet of(String directory, long writerGeneration, String file, long numRows, long formatVersion) {
                    + wfs.files().size()
            );
import org.opensearch.core.common.io.stream.StreamOutput;  
            + '}';  
 * explicit at the type level. This eliminates a class of bugs where downstream consumers
     * @param file             the single file name
            throw new IllegalArgumentException("file must not be null or empty");  
        return "MonoFileWriterSet{directory="
    }  
        out.writeStringCollection(files());  
                    + wfs.writerGeneration()  
    /**  
     * @param wfs the writer file set to narrow
        this.file = file;  
 * compatible open source license.
                    + " has "
/**  
        return new MonoFileWriterSet(directory, writerGeneration, file, numRows, formatVersion);
 * Data formats that produce a single file per segment (e.g., Parquet — one {@code .parquet}  
     * @param directory        the directory containing the file  
            wfs.writerGeneration(),  
     * Narrows a {@link WriterFileSet} to a {@link MonoFileWriterSet}, validating that it
        out.writeLong(numRows());
    public static MonoFileWriterSet of(Path directory, long writerGeneration, String file, long numRows, long formatVersion) {  
        out.writeLong(formatVersion());
    public static MonoFileWriterSet of(String directory, long writerGeneration, String file, long numRows) {
/*  
        super(directory, writerGeneration, Set.of(file), numRows, formatVersion);
        }  
            wfs.directory(),
}
     * @param formatVersion    the long-encoded data-format version stamp; {@code 0L} means
    /**  
            + directory()
     * @param numRows          the number of rows in the file  
     */
    /**
     *
    }
     *                         "unknown / pre-versioning" (see {@code LuceneVersionConverter})
