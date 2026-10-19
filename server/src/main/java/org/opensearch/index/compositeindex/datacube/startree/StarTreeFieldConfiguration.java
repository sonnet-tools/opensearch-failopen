    }  
    /**
     */  
@ExperimentalApi
    @Override
public class StarTreeFieldConfiguration implements ToXContent {
 * SPDX-License-Identifier: Apache-2.0
    public int hashCode() {  
import org.opensearch.core.xcontent.ToXContent;
    @Override
        if (this == o) return true;  
 * compatible open source license.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            this.typeName = typeName;
        return maxLeafDocs.get();
                    return starTreeBuildMode;
    public boolean equals(Object o) {
import java.io.IOException;
        this.maxLeafDocs.set(maxLeafDocs);  
    private final Set<String> skipStarNodeCreationInDims;
        }
        builder.startArray("skip_star_node_creation_for_dimensions");  
    }
}  
 */  
        // build mode is internal and not part of user mappings config, hence not added as part of toXContent
        // TODO : remove onheap support unless this proves useful  
        }
        private final byte buildModeOrdinal;
        return Objects.equals(maxLeafDocs.get(), that.maxLeafDocs.get())  
     * @opensearch.experimental
        private final String typeName;
 * The OpenSearch Contributors require contributions made to  
    public Set<String> getSkipStarNodeCreationInDims() {  
    }  
        public static StarTreeBuildMode fromBuildModeOrdinal(byte buildModeOrdinal) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "Invalid star tree build mode: [%s] ", buildModeOrdinal));
            }
    }  
        }  
    private final StarTreeBuildMode buildMode;  
        builder.field("max_leaf_docs", maxLeafDocs.get());
    }  
        return skipStarNodeCreationInDims;
        OFF_HEAP("offheap", (byte) 1);
 *
     *
        public String getTypeName() {  
        public static StarTreeBuildMode fromTypeName(String typeName) {
    public int maxLeafDocs() {
import org.opensearch.core.xcontent.XContentBuilder;  
        builder.endArray();
            builder.value(dim);
    private final AtomicInteger maxLeafDocs = new AtomicInteger();
        return buildMode;  
 */  
    public enum StarTreeBuildMode {
                    return starTreeBuildMode;
                }  
            for (StarTreeBuildMode starTreeBuildMode : StarTreeBuildMode.values()) {  
        }  
        }  
import java.util.Objects;
    }
        this.buildMode = buildMode;
        public byte getBuildModeOrdinal() {
            }
        if (o == null || getClass() != o.getClass()) return false;
     * Star tree build mode using which sorting and aggregations are performed during index creation.  
        }  
 *
    @Override
    @ExperimentalApi
 * Star tree index specific configuration  
import java.util.Set;
/*  
                }  
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException(String.format(Locale.ROOT, "Invalid star tree build mode: [%s] ", typeName));
            this.buildModeOrdinal = buildModeOrdinal;  
    }
            for (StarTreeBuildMode starTreeBuildMode : StarTreeBuildMode.values()) {  
    public StarTreeBuildMode getBuildMode() {
                if (starTreeBuildMode.getTypeName().equalsIgnoreCase(typeName)) {
            && buildMode == that.buildMode;
        return builder;
    public StarTreeFieldConfiguration(int maxLeafDocs, Set<String> skipStarNodeCreationInDims, StarTreeBuildMode buildMode) {
        for (String dim : skipStarNodeCreationInDims) {
        return Objects.hash(maxLeafDocs.get(), skipStarNodeCreationInDims, buildMode);
    }
                if (starTreeBuildMode.getBuildModeOrdinal() == buildModeOrdinal) {
        ON_HEAP("onheap", (byte) 0),
 * @opensearch.experimental
import java.util.concurrent.atomic.AtomicInteger;  
        StarTreeBuildMode(String typeName, byte buildModeOrdinal) {
/**
            && Objects.equals(skipStarNodeCreationInDims, that.skipStarNodeCreationInDims)
        this.skipStarNodeCreationInDims = skipStarNodeCreationInDims;
import org.opensearch.common.annotation.ExperimentalApi;
        StarTreeFieldConfiguration that = (StarTreeFieldConfiguration) o;
package org.opensearch.index.compositeindex.datacube.startree;
import java.util.Locale;  
            return buildModeOrdinal;
            return typeName;
