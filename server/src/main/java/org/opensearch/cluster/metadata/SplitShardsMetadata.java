import org.opensearch.core.common.io.stream.StreamOutput;  
    // Mapping of a parent shard ID to children.  
                this.inProgressSplitShardIds,  
            parentToChildShards.remove(sourceShardId);
            ShardRange[] childShards = rootShardsToAllChildren[rootShardId];
        }  
        }
        int result = Arrays.deepHashCode(rootShardsToAllChildren);  
 * @opensearch.experimental  
    }
        out.writeVInt(rootShardsToAllChildren.length);
        int maxShardId  
        for (ShardRange childShard : parentToChildShards.get(shardId)) {
            );  
            + parentToChildMap  
            }
                ? new ArrayList<>()
        int low = 0, high = childShards.length - 1;
            + activeShardIds
            if (shardRange.start() < start + 1) {  
        builder.startObject(KEY_PARENT_TO_CHILD_SHARDS);
            maxShardId = numberOfShards - 1;
            long rangeLength = rangeEnd - shardRange.start() + 1;
                        return new Tuple<>(rootShardId, shardUnderRoot);
            }
        builder.startObject(KEY_ROOT_SHARDS_TO_ALL_CHILDREN);  
    }
        /**
        if (!activeShardIds.equals(that.activeShardIds)) return false;  
                return midShard;
    public boolean equals(Object o) {  
                builder.startArray(String.valueOf(rootShardId));
        public Builder(int numberOfShards) {
                    "Shard range from "
                throw new IllegalArgumentException("Invalid shard id provided for splitting");
        return rootShardList;
            rootShardList.add(i);
        }
        if (includeInProgressChildren && parentToChildShards.containsKey(shardRange.shardId())) {
            builder.startArray(String.valueOf(parentShardId));  
        String currentFieldName = null;
                // Getting a copy of child shards for this parent.
                return false;
            if (!Arrays.deepEquals(parentToChildShards.get(key), that.parentToChildShards.get(key))) {  
        for (ShardRange shardRange : shardRanges) {
                }
            long rangeSize = ((long) parentShard.end() - parentShard.start() + 1) / numberOfChildren;  
                    + (start + 1)
                while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
            if (rangeSize <= MINIMUM_RANGE_LENGTH_THRESHOLD) {
                } else {
                for (ShardRange shardUnderRoot : allChildren) {  
            assert newChildShardIds.size() == parentToChildShards.get(sourceShardId).length;
        public List<ShardRange> splitShard(int splitShardId, int numberOfChildren) {
            for (Integer inProgressParent : inProgressSplitShardIds) {
import java.util.Iterator;
        String currentFieldName = null;  
        if (start == null) {
                    this.rootShardsToAllChildren[i] = new ShardRange[splitShardsMetadata.rootShardsToAllChildren[i].length];
import org.opensearch.cluster.Diff;
                low = mid + 1;
            Set<Integer> activeShardIds = new HashSet<>();
            int nextChildShardId = maxShardId, childShardId;
        private final Set<Integer> activeShardIds;
            int currentMaxShardId = maxShardId;
                }
    private static final String KEY_ROOT_SHARDS_TO_ALL_CHILDREN = "root_shards_to_all_children";  
    public int getShardIdOfHash(int rootShardId, int hash, boolean includeInProgressChildren) {
                for (ShardRange childShard : childShards) {
        this.inProgressSplitShardIds = Collections.unmodifiableSet(in.readSet(StreamInput::readInt));
            } else if (token == XContentParser.Token.START_OBJECT) {
            this.maxShardId = splitShardsMetadata.maxShardId;
        return total;
     * Builder for {@link SplitShardsMetadata}.
            activeShardIds,
    private static final String KEY_ACTIVE_SHARD_IDS = "active_shard_ids";
                    }
        return shardRange.shardId();
            } else if (token == XContentParser.Token.VALUE_NUMBER) {
            List<ShardRange> newChildShardsList = new ArrayList<>();
    ) {
        public void updateSplitMetadataForChildShards(int sourceShardId, Set<Integer> newChildShardIds) {
            Set<Integer> inProgressChildShardIds = new HashSet<>();  
                this.parentToChildShards.put(parentShardId, childShards);
        private Set<Integer> getInProgressChildShardIds() {
    public int getNumberOfRootShards() {  
            }  
        Set<Integer> inProgressSplitShardIds = new HashSet<>();  
                }  
                }  
        private final Set<Integer> inProgressSplitShardIds;
        builder.endObject();
            validateShardRanges(shardRangeTuple.v1(), newShardsUnderRoot);
                : new ArrayList<>(Arrays.asList(rootShardsToAllChildren[shardRangeTuple.v1()]));  
                currentFieldName = parser.currentName();
        Set<Integer> activeShardIds,
        private final ShardRange[][] rootShardsToAllChildren;
        private int maxShardId;  
import org.opensearch.core.xcontent.ToXContentFragment;
                    nextChildShardId++;
                if (shardIdHoles.isEmpty()) {  
import java.util.TreeSet;
            inProgressSplitShardIds,
        }
        return new SplitShardsMetadata(
            // Get existing childShardRanges under rootShard  
    }
        return new HashSet<>(activeShardIds).iterator();
            return Collections.unmodifiableList(newChildShardsList);  
    public List<Integer> getRootShards() {
                } else if (KEY_ACTIVE_SHARD_IDS.equals(currentFieldName)) {
                return gaps;
/**  
    }  
 *
            }  
            this.parentToChildShards = new HashMap<>();  
            Collections.sort(allConsumedShardIds);
        builder.field(KEY_ACTIVE_SHARD_IDS, new ArrayList<>(activeShardIds));
        }
    public static Diff<SplitShardsMetadata> readDiffFrom(StreamInput in) throws IOException {
            builder.endArray();
        this.activeShardIds = activeShardIds;
        if (rootShardsToAllChildren[rootShardId] == null) {
            }  
    }
            ShardRange[] newShardsUnderRoot = shardsUnderRoot.toArray(new ShardRange[0]);  
                Integer parentShard = Integer.parseInt(currentFieldName);  
        }
    // Following fields can store temporary information about in progress child shards along with info about
            } else if (hash < midShard.start()) {
                        + " to "  
                ShardRange childShard = new ShardRange(childShardId, (int) start, (int) end);
            if (allConsumedShardIds == null || allConsumedShardIds.size() <= 1) {  
                }  
                    }
        return childShardIds;
        builder.endObject();  
    public Set<Integer> getInProgressSplitShardIds() {
    public String toString() {  
    // Visible for testing
        return activeShardIds.contains(shardId) == false && parentToChildShards.containsKey(shardId);
        }  
        );  
                    allConsumedShardIds.add(i);
                if (KEY_IN_PROGRESS_SPLIT_SHARD_IDS.equals(currentFieldName)) {
import java.util.Arrays;
        return rootShardsToAllChildren.length;
            return new SplitShardsMetadata(  
        }
            ShardRange[] newShardRanges = newChildShardsList.toArray(new ShardRange[0]);
                shardsMap.put(parentShard, childShardRanges.toArray(new ShardRange[0]));
    }
                assert activeShardIds.contains(newChildId) == false;  
        out.writeVInt(this.maxShardId);
        }
                allConsumedShardIds.add(splitId);  
            rootShardsToAllChildren,
        }
            shardRange = binarySearchShards(parentToChildShards.get(shardRange.shardId()), hash);  
    public boolean isSplitOfShardInProgress(int shardId) {
    }
            }
            Arrays.sort(newShardsUnderRoot);
            for (int i = 0; i < splitShardsMetadata.rootShardsToAllChildren.length; i++) {
        this.parentToChildShards = Collections.unmodifiableMap(parentToChildShards);
        ShardRange[] existingChildShards = rootShardsToAllChildren[rootShardId];
            + "rootShardsToAllChildren="
        if (shardId < rootShardsToAllChildren.length && rootShardsToAllChildren[shardId] == null) {
        int total = 0;  
public class SplitShardsMetadata extends AbstractDiffable<SplitShardsMetadata> implements ToXContentFragment {  
                }
            ShardRange midShard = childShards[mid];
    private final Map<Integer, ShardRange[]> parentToChildShards;
        return "SplitShardsMetadata{"
    }  
            + ", activeShardIds="  
        this.maxShardId = in.readVInt();
        }
            if (token == XContentParser.Token.FIELD_NAME) {  
            inProgressSplitShardIds = new HashSet<>();
            }  
        return builder;
import org.opensearch.core.xcontent.XContentBuilder;
            + Arrays.toString(rootShardsToAllChildren)  
                    "Shard range from " + parentStart + " to " + (shardRange.start() - 1) + " is missing from the list of shard ranges"
                    while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
        for (Integer key : parentToChildShards.keySet()) {
        for (ShardRange[] rootShardsToAllChild : rootShardsToAllChildren) {
    public static SplitShardsMetadata parse(XContentParser parser) throws IOException {
                throw new IllegalArgumentException(  
            throw new IllegalArgumentException(  
            return new Tuple<>(shardId, new ShardRange(shardId, Integer.MIN_VALUE, Integer.MAX_VALUE));
        if (!inProgressSplitShardIds.contains(parentShardId)) {
                start = end + 1;
            if (childShards != null) {  
            rootShardsToAllChildren = new ShardRange[numberOfShards][];  
                    allConsumedShardIds.add(shard.shardId());
            builder.field(KEY_IN_PROGRESS_SPLIT_SHARD_IDS, new ArrayList<>(inProgressSplitShardIds));  
            + ", parentToChildShards="
        } else if (shardRange.start() != start + 1) {
            String errorMessage;
                ? new ArrayList<>()
        SplitShardsMetadata that = (SplitShardsMetadata) o;
                }  
            maxShardId  
        if (this == o) return true;
            for (ShardRange childShard : parentToChildShards.get(parentShardId)) {
            throw new IllegalArgumentException("No shard range defined for child shards of shard " + shardId);
        return true;
            this.activeShardIds = activeShardIds;
        public Builder(SplitShardsMetadata splitShardsMetadata) {  
        this.activeShardIds = Collections.unmodifiableSet(in.readSet(StreamInput::readInt));  
        }  
    }  
    // Following fields are upadated only after split completion and are used to service active shards request.
                assert newChildShardIds.contains(childShard.shardId());
            inProgressSplitShardIds.add(splitShardId);  
        this.inProgressSplitShardIds = Collections.unmodifiableSet(inProgressSplitShardIds);  
    @Override
        XContentParser.Token token;
    }
        builder.field(KEY_MAX_SHARD_ID, maxShardId);
                return true;
            parentToChildMap.append("]");
    // Root shard id to flat list of all child shards under root.
            }  
                    for (ShardRange childShard : splitShardsMetadata.rootShardsToAllChildren[i]) {  
import java.util.Map;
            return false;  
            this.rootShardsToAllChildren[i] = in.readOptionalArray(ShardRange::new, ShardRange[]::new);
import java.util.Objects;
    public int getNumberOfShards() {
        assert shardRange != null;
    private ShardRange binarySearchShards(ShardRange[] childShards, int hash) {
    public static class Builder {  
            } else if (token == XContentParser.Token.START_ARRAY) {
        return readDiffFrom(SplitShardsMetadata::new, in);  
            shardsUnderRoot.remove(shardRangeTuple.v2());
            start = shardRange.end();
                    + " is missing from the list of shard ranges";
        }  
            }
            long start = parentShard.start();
                assert !activeShardIds.contains(childShardId);
            for (int i = 1; i < allConsumedShardIds.size(); i++) {
                errorMessage = "Shard range overlaps from " + shardRange.start() + " to " + start;
            if (shardRange.start() != parentStart) {
 * The OpenSearch Contributors require contributions made to  
        builder.field(KEY_NUMBER_OF_ROOT_SHARDS, rootShardsToAllChildren.length);  
    }  
        int numberOfRootShards = -1;
    }
import java.util.List;  
import java.util.HashSet;
                    Map<Integer, ShardRange[]> rootShards = parseShardsMap(parser);
        return activeShardIds.size();
                    numberOfRootShards = parser.intValue();  
        if (start != upperBound) {
    }
    private final ShardRange[][] rootShardsToAllChildren;  
            return gaps;
                        rootShardsToAllChildren[entry.getKey()] = entry.getValue();
    @Override
        if (!Arrays.deepEquals(rootShardsToAllChildren, that.rootShardsToAllChildren)) return false;
                );
            List<Integer> allConsumedShardIds = new ArrayList<>();
            for (Integer parentShardId : splitShardsMetadata.parentToChildShards.keySet()) {
    /**
    }
        }
            }  
    public boolean isRecoveringChild(int shardId, int parentShardId) {
            return null;  
                } else {
            }
        return shardsMap;
    private final Set<Integer> inProgressSplitShardIds;
        private final Map<Integer, ShardRange[]> parentToChildShards;
                int previous = allConsumedShardIds.get(i - 1);
                    shardIdHoles.remove(childShardId);  
                    + (shardRange.start() - 1)  
                        this.rootShardsToAllChildren[i][j++] = childShard;
            }
                if (KEY_MAX_SHARD_ID.equals(currentFieldName)) {  
        }
/*  
                assert shardRange != null;
                    }  
        if (parentToChildShards.size() != that.parentToChildShards.size()) return false;
                this.maxShardId
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        for (ShardRange childShard : parentToChildShards.get(parentShardId)) {  
        ShardRange shardRange = binarySearchShards(existingChildShards, hash);
        return childShards;
    private final Set<Integer> activeShardIds;
        Map<Integer, ShardRange[]> parentToChildShards,  
        this.maxShardId = maxShardId;
                return shardRange.shardId();
import org.opensearch.core.common.io.stream.StreamInput;
        }
        for (ShardRange childShard : parentToChildShards.get(shardId)) {
        }
        private Set<Integer> findHoles(List<Integer> allConsumedShardIds) {  
        ShardRange[] childShards = new ShardRange[parentToChildShards.get(shardId).length];  
            allChildren = rootShardsToAllChildren[rootShardId];
            List<ShardRange> shardsUnderRoot = rootShardsToAllChildren[shardTuple.v1()] == null
                        nextChildShardId++;
        int childShardIdx = 0;
         * @param splitShardId Shard id to split
                ShardRange shardRange = binarySearchShards(parentToChildShards.get(rootShardId), hash);  
            assert inProgressSplitShardIds.contains(sourceShardId);
            assert inProgressSplitShardIds.contains(sourceShardId);  
}  
 *
    }  
     *  
    }  
        throw new IllegalArgumentException("Shard ID doesn't exist in the current list of shard ranges");
        }
            Set<Integer> shardIdHoles = findHoles(allConsumedShardIds);  
                    childShardId = shardIdHoles.iterator().next();
        return inProgressSplitShardIds;
    private static void validateBounds(ShardRange shardRange, Integer start, long parentStart) {  
            + ", maxShardId="
            parentToChildMap.append(entry.getKey()).append("=").append(Arrays.toString(entry.getValue()));
        }
        int upperBound = Integer.MAX_VALUE;  
                ShardRange[] childShards = parentToChildShards.get(inProgressParent);  
            } else {
        if (!inProgressSplitShardIds.equals(that.inProgressSplitShardIds)) return false;
        Set<Integer> inProgressSplitShardIds,
                    if (shardUnderRoot.shardId() == shardId) {
                int current = allConsumedShardIds.get(i);  
 * SPDX-License-Identifier: Apache-2.0
        if (parentToChildShards.containsKey(shardId) == false) {
            int mid = low + (high - low) / 2;
        this.rootShardsToAllChildren = rootShardsToAllChildren;  
                }
        if (parentToChildShards.containsKey(shardId) == false) {
            shardsUnderRoot.remove(shardTuple.v2()); // Remove parent shard range
            parentToChildShards = new HashMap<>();
                childShard.toXContent(builder, params);
            parentToChildMap.append("[");  
    private static final String KEY_NUMBER_OF_ROOT_SHARDS = "num_of_root_shards";
        public void cancelSplit(int sourceShardId) {
            }
            tempShardIdToChildShards,  
            if (includeInProgressChildren && parentToChildShards.containsKey(rootShardId)) {
            for (int i = 0; i < rootShardsToAllChildren.length; i++) {  
                activeShardIds.add(i);
                throw new IllegalArgumentException("Split of shard [" + splitShardId + "] is already in progress or completed.");  
                assert parentToChildShards.containsKey(inProgressParent);
    public ShardRange[] getChildShardsOfParent(int shardId) {
        for (Integer parent : inProgressSplitShardIds) {
            }
        }  
    private static final String KEY_PARENT_TO_CHILD_SHARDS = "parent_to_child_shards";
            }
            ShardRange[] newShardsUnderRoot = shardsUnderRoot.toArray(new ShardRange[0]);  
         * Create metadata of new child shards for the provided shard id.  
    @Override
    }  
                builder.endArray();
        }  
    }
            } else if (token == XContentParser.Token.START_ARRAY) {  
        Set<Integer> activeShardIds = new HashSet<>();
            }
import java.util.Set;  
                        activeShardIds.add(childShard.shardId());
        int maxShardId = -1;
            + ", inProgressSplitShardIds="
                    while (inProgressChildShardIds.contains(nextChildShardId)) {
import org.opensearch.core.xcontent.XContentParser;  
import java.io.IOException;
        if (!inProgressSplitShardIds.isEmpty()) {
                    int j = 0;
            }
    }  
            Arrays.sort(newShardsUnderRoot);
            shardsUnderRoot.addAll(Arrays.asList(parentToChildShards.get(sourceShardId)));
        Map<Integer, ShardRange[]> shardsMap = new HashMap<>();
        for (int rootShardId = 0; rootShardId < rootShardsToAllChildren.length; rootShardId++) {
                    }
    public SplitShardsMetadata(StreamInput in) throws IOException {
        for (int rootShardId = 0; rootShardId < rootShardsToAllChildren.length; rootShardId++) {  
            Tuple<Integer, ShardRange> shardRangeTuple = findRootAndShard(sourceShardId, rootShardsToAllChildren);
            for (int i = 0; i < numberOfChildren; ++i) {
        for (Integer parentShardId : parentToChildShards.keySet()) {
            inProgressSplitShardIds.remove(sourceShardId);
        out.writeCollection(this.inProgressSplitShardIds, StreamOutput::writeInt);  
    public void writeTo(StreamOutput out) throws IOException {  
    private final int maxShardId;
                );
                if (KEY_ROOT_SHARDS_TO_ALL_CHILDREN.equals(currentFieldName)) {  
                this.activeShardIds,
        }
                ShardRange[] childShards = splitShardsMetadata.getChildShardsOfParent(parentShardId);  
            );
        StringBuilder parentToChildMap = new StringBuilder();
        return false;
        }
                    childShardId = nextChildShardId;  
                        gaps.add(j);
                    while (parser.nextToken() != XContentParser.Token.END_ARRAY) {  
                    }  
        }  
        }  
            for (Integer newChildId : newChildShardIds) {
                activeShardIds.add(newChildId);
                    + " to "
                assert !inProgressChildShardIds.contains(childShardId);  
            if (inProgressSplitShardIds.contains(splitShardId) || parentToChildShards.containsKey(splitShardId)) {
        for (int i = 0; i < rootShardsToAllChildren.length; i++) {
                    }  
                        + shardRange.end()
                        + " is below shard range threshold of "
            + inProgressSplitShardIds
            rootShardsToAllChildren[shardRangeTuple.v1()] = newShardsUnderRoot;
                high = mid - 1;  
    }
 */  
        for (Map.Entry<Integer, ShardRange[]> entry : parentToChildShards.entrySet()) {
            ShardRange parentShard = shardTuple.v2();
            maxShardId = currentMaxShardId;  
                "Shard range from " + (start + 1) + " to " + upperBound + " is missing from the list of shard ranges"
 * Metadata for tracking shard split operations on an index.
        assert shardRange != null;  
    @Override
        }  
import java.util.ArrayList;  
     * @opensearch.experimental
                    tempShardIdToChildShards = parseShardsMap(parser);
            if (midShard.contains(hash)) {  
            in.readMap(StreamInput::readInt, i -> i.readArray(ShardRange::new, ShardRange[]::new))
        }  
@ExperimentalApi
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public SplitShardsMetadata build() {
    // split completed shards.
            } else {
        result = 31 * result + activeShardIds.hashCode();  
    }
    }  
            }
    public int hashCode() {
        }  
            shardsUnderRoot.addAll(List.of(newShardRanges)); // Add child shard range
                        inProgressSplitShardIds.add(parser.intValue());  
                currentMaxShardId = Math.max(currentMaxShardId, newChildId);
            Tuple<Integer, ShardRange> shardTuple = findRootAndShard(splitShardId, rootShardsToAllChildren);  
        this.rootShardsToAllChildren = new ShardRange[numberOfRootShards][];  
import java.util.Collections;
package org.opensearch.cluster.metadata;
        }
            result = 31 * result + Objects.hash(entry.getKey(), Arrays.deepHashCode(entry.getValue()));
                    inProgressChildShardIds.add(childShard.shardId());
            this.rootShardsToAllChildren = new ShardRange[splitShardsMetadata.rootShardsToAllChildren.length][];  
                    childShardRanges.add(shardRange);  
            for (ShardRange childShard : parentToChildShards.get(sourceShardId)) {  
 * this file be licensed under the Apache-2.0 license or a
                for (ShardRange shard : parentToChildShards.get(splitId)) {
                errorMessage = "Shard range from "  
            parentToChildShards.put(splitShardId, newShardRanges);
            List<ShardRange> shardsUnderRoot = rootShardsToAllChildren[shardRangeTuple.v1()] == null
    }  
            Set<Integer> gaps = new TreeSet<>();
                        + MINIMUM_RANGE_LENGTH_THRESHOLD  
        }  
    }
                if (rootShardsToAllChildren[i] == null) {
    private static final int MINIMUM_RANGE_LENGTH_THRESHOLD = 1000;
                long end = i == numberOfChildren - 1 ? parentShard.end() : start + rangeSize - 1;
            activeShardIds = new HashSet<>();  
                    rootShardsToAllChildren = new ShardRange[numberOfRootShards][];
        out.writeMap(this.parentToChildShards, StreamOutput::writeInt, StreamOutput::writeArray);
        }  
        }  
    public Iterator<Integer> getActiveShardIterator() {
            + maxShardId
 * compatible open source license.
            }  
                if (current - previous > 1) {  
            if (shardTuple == null) {
        ShardRange[][] rootShardsToAllChildren = null;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            total += parentToChildShards.get(parent).length;
                currentFieldName = parser.currentName();
                } else if (KEY_NUMBER_OF_ROOT_SHARDS.equals(currentFieldName)) {
import java.util.HashMap;  
                inProgressChildShardIds.add(childShardId);
            if (childShard.shardId() == shardId) {
    }
        this.parentToChildShards = Collections.unmodifiableMap(
     */
        if (start == null) {
            }
            return rootShardId;
        out.writeCollection(this.activeShardIds, StreamOutput::writeInt);
        if (maxShardId != that.maxShardId) return false;  
                assert currentFieldName != null;
            if (allChildren != null) {
import org.opensearch.common.annotation.ExperimentalApi;  
    private static Map<Integer, ShardRange[]> parseShardsMap(XContentParser parser) throws IOException {
    public int inProgressChildShardsCount() {
                    nextChildShardId = Math.max(nextChildShardId, childShardId);
            }
        for (Map.Entry<Integer, ShardRange[]> entry : parentToChildShards.entrySet()) {
                } else if (KEY_PARENT_TO_CHILD_SHARDS.equals(currentFieldName)) {  
    static void validateShardRanges(int shardId, ShardRange[] shardRanges) {  
        );
                        activeShardIds.add(parser.intValue());
    public Set<Integer> getChildShardIdsOfParent(int shardId) {
                    activeShardIds.add(i);
        while (low <= high) {  
                this.rootShardsToAllChildren,
        result = 31 * result + inProgressSplitShardIds.hashCode();
    private static final String KEY_IN_PROGRESS_SPLIT_SHARD_IDS = "in_progress_split_shard_id";
            childShards[childShardIdx++] = childShard;  
            if (rangeLength < MINIMUM_RANGE_LENGTH_THRESHOLD) {
            return inProgressChildShardIds;
            + '}';  
            return childShardIds;
        return result;
                }  
            throw new IllegalArgumentException(errorMessage);  
            }
            Set<Integer> inProgressChildShardIds = getInProgressChildShardIds();
        Integer start = null;
         * @param numberOfChildren Number of child shards this shard is going to have.
        }
        }
        return inProgressSplitShardIds.contains(shardId);  
                throw new IllegalArgumentException(  
                    for (int j = previous + 1; j < current; j++) {
        Set<Integer> childShardIds = new HashSet<>();  
        result = 31 * result + maxShardId;
            inProgressSplitShardIds = new HashSet<>(splitShardsMetadata.inProgressSplitShardIds);
                if (splitShardsMetadata.rootShardsToAllChildren[i] != null) {  
                        assert activeShardIds.contains(nextChildShardId) == false;  
            }  
            if (token == XContentParser.Token.FIELD_NAME) {  
import org.opensearch.cluster.AbstractDiffable;
        for (int i = 0; i < numberOfRootShards; i++) {
                }
        }  
                    maxShardId = parser.intValue();
import org.opensearch.common.collect.Tuple;
            activeShardIds.remove(sourceShardId);
            childShardIds.add(childShard.shardId());  
         */  
            }  
        int lowerBound = Integer.MIN_VALUE;
        ShardRange[] allChildren;
                    ShardRange shardRange = ShardRange.parse(parser);
        return null;
            // We are splitting a root shard in this case.  
            for (Integer splitId : parentToChildShards.keySet()) {
    SplitShardsMetadata(
            }  
                throw new IllegalArgumentException("Cannot split shard [" + splitShardId + "] further.");
                this.parentToChildShards,
        // First check if we have child shards against this root shard.  
                : new ArrayList<>(Arrays.asList(rootShardsToAllChildren[shardTuple.v1()]));  
            out.writeOptionalArray(rootShardsToAllChild);  
    public boolean isSplitParent(int shardId) {  
                }
        if (!(o instanceof SplitShardsMetadata)) return false;
                    }
            }
            long rangeEnd = shardRange.end();  
                    childShard.toXContent(builder, params);  
        int numberOfRootShards = in.readVInt();
            for (int i = 0; i < numberOfShards; i++) {
            validateBounds(shardRange, start, lowerBound);
    }
    private static final String KEY_MAX_SHARD_ID = "max_shard_id";  
        List<Integer> rootShardList = new ArrayList<>();  
        Map<Integer, ShardRange[]> tempShardIdToChildShards = new HashMap<>();  
            validateShardRanges(splitShardId, newShardsUnderRoot);  
                newChildShardsList.add(childShard);  
    private static Tuple<Integer, ShardRange> findRootAndShard(int shardId, ShardRange[][] rootShardsToAllChildren) {
        XContentParser.Token token;  
    }
                        + shardRange.start()
                    for (Map.Entry<Integer, ShardRange[]> entry : rootShards.entrySet()) {  
                List<ShardRange> childShardRanges = new ArrayList<>();  
            inProgressSplitShardIds.remove(sourceShardId);
 */
                }
                for (ShardRange childShard : childShards) {
        ShardRange[][] rootShardsToAllChildren,
