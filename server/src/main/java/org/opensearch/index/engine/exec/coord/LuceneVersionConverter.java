     * {@link Version#LATEST} for null, empty, or unparseable values.  
    public static long encode(Version v) {  
        }  
        int major = (int) (encodedFormatVersion / MAJOR_SHIFT);
     * Parses a format-version string as a Lucene {@link Version}, falling back to
    }  
        }  
            return Version.LATEST;
/*  
 * <p>Falls back to {@link Version#LATEST} for null/empty/unparseable inputs.
import org.opensearch.common.annotation.ExperimentalApi;
        } catch (Exception e) {  
/**
    private LuceneVersionConverter() {}
    /**
        int bugfix = (int) (encodedFormatVersion % VERSION_SHIFT);  
    }
 * compatible open source license.
 *   <li>9.10.0  → {@code 9_010_000}</li>  
public final class LuceneVersionConverter {
        } catch (Exception e) {
     * Decodes a long-encoded format-version (see class doc) into a Lucene {@link Version}.
            return Version.LATEST;
 * SPDX-License-Identifier: Apache-2.0
 * </ul>  
 *
            return Version.LATEST;
    public static Version toLuceneOrLatest(String formatVersion) {
            return Version.fromBits(major, minor, bugfix);
 */  
 *
        if (formatVersion == null || formatVersion.isEmpty()) {  
        if (v == null) {
            return 0L;
    private static final long MAJOR_SHIFT = VERSION_SHIFT * VERSION_SHIFT;  
 *   <li>0       → unknown / pre-versioning ({@link Version#LATEST} on decode)</li>
        if (encodedFormatVersion <= 0) {
    /** Multiplier for the minor slot (positions 3-5). */  
    }
        int minor = (int) ((encodedFormatVersion / MINOR_SHIFT) % VERSION_SHIFT);
 * {@code major * MAJOR_SHIFT + minor * MINOR_SHIFT + bugfix}.
        }
     * Encodes a Lucene {@link Version} as a long per the class-level scheme.  
        try {
    public static Version toLuceneOrLatest(long encodedFormatVersion) {  
 * compatibility with non-Lucene formats. The encoding packs each component into a base
package org.opensearch.index.engine.exec.coord;
    /** Multiplier for the major slot (positions 6+). */
    private static final long MINOR_SHIFT = VERSION_SHIFT;
 *  
}  
     */
        return v.major * MAJOR_SHIFT + v.minor * MINOR_SHIFT + v.bugfix;
     * Returns {@link Version#LATEST} for {@code 0} or any value that doesn't decode to a  
 */  
     */
    /**
     * Returns {@code 0} when {@code v} is null.
 * <ul>
    /**
 * The OpenSearch Contributors require contributions made to  
@ExperimentalApi
 * <p>DFA encodes per-file format versions as a {@code long} for compactness and forward
 * this file be licensed under the Apache-2.0 license or a
     */
            return Version.LATEST;  
 * {@link #VERSION_SHIFT} slot:  
     * valid Lucene version.
 * Converts between DFA format-version representations and Lucene {@link Version}.
    /** Base for each version slot. Three decimal digits per component (major/minor/bugfix, each 0-999). */
 *   <li>10.0.0  → {@code 10_000_000}</li>
import org.apache.lucene.util.Version;
        try {  
    private static final long VERSION_SHIFT = 1_000L;
        }
        }
            return Version.parse(formatVersion);
