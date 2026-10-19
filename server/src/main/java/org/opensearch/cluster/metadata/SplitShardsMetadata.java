    public int getNumberOfRootShards() {
 */
import java.io.IOException;
        for (ShardRange shardRange : shardRanges) {
                    childShardId = nextChildShardId;
            List<ShardRange> shardsUnderRoot = rootShardsToAllChildren[shardRangeTuple.v1()] == null
        return childShardIds;
                childShard.toXContent(builder, params);
            + "rootShardsToAllChildren="
                currentMaxShardId = Math.max(currentMaxShardId, newChildId);
            }
            + ", inProgressSplitShardIds="
                    }
            List<Integer> allConsumedShardIds = new ArrayList<>();
        XContentParser.Token token;
        for (Integer key : parentToChildShards.keySet()) {
            } else {
            }
            maxShardId = numberOfShards - 1;
import org.opensearch.core.xcontent.XContentParser;
        }
            return Collections.unmodifiableList(newChildShardsList);
        builder.endObject();
        this.maxShardId = in.readVInt();
    // Following fields can store temporary information about in progress child shards along with info about
        for (int rootShardId = 0; rootShardId < rootShardsToAllChildren.length; rootShardId++) {
            );
            }
                allConsumedShardIds.add(splitId);
        this.activeShardIds = activeShardIds;
            if (token == XContentParser.Token.FIELD_NAME) {
            }
            for (Integer inProgressParent : inProgressSplitShardIds) {
            }
            result = 31 * result + Objects.hash(entry.getKey(), Arrays.deepHashCode(entry.getValue()));
        }
        if (rootShardsToAllChildren[rootShardId] == null) {
            + ", maxShardId="
                    + (shardRange.start() - 1)
            parentToChildShards.put(splitShardId, newShardRanges);
            }
    }
import org.opensearch.cluster.Diff;
    }
            }
    }
                } else if (KEY_ACTIVE_SHARD_IDS.equals(currentFieldName)) {
    }
                : new ArrayList<>(Arrays.asList(rootShardsToAllChildren[shardRangeTuple.v1()]));
                    "Shard range from "
        if (!inProgressSplitShardIds.contains(parentShardId)) {
        } else if (shardRange.start() != start + 1) {
            for (int i = 0; i < numberOfShards; i++) {
                        nextChildShardId++;
            int currentMaxShardId = maxShardId;
        if (parentToChildShards.containsKey(shardId) == false) {
    }
            maxShardId = currentMaxShardId;
    public Set<Integer> getChildShardIdsOfParent(int shardId) {
                    "Shard range from " + parentStart + " to " + (shardRange.start() - 1) + " is missing from the list of shard ranges"
     * @opensearch.experimental
                this.activeShardIds,
            maxShardId
            activeShardIds = new HashSet<>();
}
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    maxShardId = parser.intValue();
                builder.startArray(String.valueOf(rootShardId));
     */
                high = mid - 1;
    public static class Builder {
            Tuple<Integer, ShardRange> shardTuple = findRootAndShard(splitShardId, rootShardsToAllChildren);
        ShardRange[] existingChildShards = rootShardsToAllChildren[rootShardId];
import org.opensearch.cluster.AbstractDiffable;
        public void updateSplitMetadataForChildShards(int sourceShardId, Set<Integer> newChildShardIds) {
    }
    private static Tuple<Integer, ShardRange> findRootAndShard(int shardId, ShardRange[][] rootShardsToAllChildren) {
                List<ShardRange> childShardRanges = new ArrayList<>();
        private int maxShardId;
 * Metadata for tracking shard split operations on an index.
    }
        }
            start = shardRange.end();
        }
            this.rootShardsToAllChildren[i] = in.readOptionalArray(ShardRange::new, ShardRange[]::new);
            long rangeLength = rangeEnd - shardRange.start() + 1;
            }
            if (allChildren != null) {
            rootShardsToAllChildren[shardRangeTuple.v1()] = newShardsUnderRoot;
        StringBuilder parentToChildMap = new StringBuilder();
                inProgressChildShardIds.add(childShardId);
        return inProgressSplitShardIds.contains(shardId);
        }
                while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
    private static final String KEY_NUMBER_OF_ROOT_SHARDS = "num_of_root_shards";
                    while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
            rootShardsToAllChildren = new ShardRange[numberOfShards][];
            ShardRange[] newShardRanges = newChildShardsList.toArray(new ShardRange[0]);
        return shardsMap;
            + inProgressSplitShardIds
        if (!Arrays.deepEquals(rootShardsToAllChildren, that.rootShardsToAllChildren)) return false;
        while (low <= high) {
    private static Map<Integer, ShardRange[]> parseShardsMap(XContentParser parser) throws IOException {
                    for (Map.Entry<Integer, ShardRange[]> entry : rootShards.entrySet()) {
         * @param numberOfChildren Number of child shards this shard is going to have.
            parentToChildMap.append("]");
                }
            shardsUnderRoot.addAll(List.of(newShardRanges)); // Add child shard range
        }
            in.readMap(StreamInput::readInt, i -> i.readArray(ShardRange::new, ShardRange[]::new))
    @Override
            return gaps;
        Set<Integer> activeShardIds,
 * SPDX-License-Identifier: Apache-2.0
    }
    }
                throw new IllegalArgumentException("Invalid shard id provided for splitting");
            String errorMessage;
    }
            return null;
                ShardRange shardRange = binarySearchShards(parentToChildShards.get(rootShardId), hash);
        if (!inProgressSplitShardIds.isEmpty()) {
        private final Set<Integer> activeShardIds;
import java.util.Map;
        for (Integer parent : inProgressSplitShardIds) {
        String currentFieldName = null;
            rootShardList.add(i);
        return childShards;
            tempShardIdToChildShards,
        int upperBound = Integer.MAX_VALUE;
    static void validateShardRanges(int shardId, ShardRange[] shardRanges) {
                errorMessage = "Shard range from "
                "Shard range from " + (start + 1) + " to " + upperBound + " is missing from the list of shard ranges"
                for (ShardRange childShard : childShards) {
    public static SplitShardsMetadata parse(XContentParser parser) throws IOException {
        for (Map.Entry<Integer, ShardRange[]> entry : parentToChildShards.entrySet()) {
        if (!inProgressSplitShardIds.equals(that.inProgressSplitShardIds)) return false;
            validateShardRanges(shardRangeTuple.v1(), newShardsUnderRoot);
        public Builder(int numberOfShards) {
                        assert activeShardIds.contains(nextChildShardId) == false;
        XContentParser.Token token;
            validateBounds(shardRange, start, lowerBound);
            for (Integer parentShardId : splitShardsMetadata.parentToChildShards.keySet()) {
                    nextChildShardId++;
                throw new IllegalArgumentException(
    public int inProgressChildShardsCount() {
                    numberOfRootShards = parser.intValue();
 *
                return shardRange.shardId();
            int nextChildShardId = maxShardId, childShardId;
    }
        builder.startObject(KEY_PARENT_TO_CHILD_SHARDS);
        }
            }
                start = end + 1;
        }
import java.util.Objects;
        }
            } else {
        return activeShardIds.size();
         * Create metadata of new child shards for the provided shard id.
        Set<Integer> childShardIds = new HashSet<>();
                newChildShardsList.add(childShard);
            builder.endArray();
    }
            if (rangeSize <= MINIMUM_RANGE_LENGTH_THRESHOLD) {
                    ShardRange shardRange = ShardRange.parse(parser);
        }
        if (this == o) return true;
        if (start == null) {
        this.rootShardsToAllChildren = new ShardRange[numberOfRootShards][];
    SplitShardsMetadata(
    }
        public Builder(SplitShardsMetadata splitShardsMetadata) {
        return inProgressSplitShardIds;
                Integer parentShard = Integer.parseInt(currentFieldName);
                    }
        if (includeInProgressChildren && parentToChildShards.containsKey(shardRange.shardId())) {
            Tuple<Integer, ShardRange> shardRangeTuple = findRootAndShard(sourceShardId, rootShardsToAllChildren);
                ShardRange[] childShards = parentToChildShards.get(inProgressParent);
        String currentFieldName = null;
            parentToChildMap.append("[");
        builder.startObject(KEY_ROOT_SHARDS_TO_ALL_CHILDREN);
        }
                        + shardRange.end()
            validateShardRanges(splitShardId, newShardsUnderRoot);
/**
        }
            }
        this.maxShardId = maxShardId;
        int total = 0;
 * @opensearch.experimental
    @Override
import org.opensearch.common.collect.Tuple;
                }
                    }
                }
        assert shardRange != null;
            long start = parentShard.start();
        Integer start = null;
                assert shardRange != null;
                activeShardIds.add(i);
                    + " is missing from the list of shard ranges";
        return new HashSet<>(activeShardIds).iterator();
                } else {
    public boolean equals(Object o) {
        result = 31 * result + inProgressSplitShardIds.hashCode();
                for (ShardRange childShard : childShards) {
                    int j = 0;
                }
                        + MINIMUM_RANGE_LENGTH_THRESHOLD
            inProgressSplitShardIds.add(splitShardId);
            int mid = low + (high - low) / 2;
        }
import java.util.List;
            Set<Integer> inProgressChildShardIds = getInProgressChildShardIds();
import org.opensearch.core.common.io.stream.StreamInput;
     *
        int low = 0, high = childShards.length - 1;
            + ", parentToChildShards="
                assert !activeShardIds.contains(childShardId);
                    Map<Integer, ShardRange[]> rootShards = parseShardsMap(parser);
            return false;
        if (maxShardId != that.maxShardId) return false;
     * Builder for {@link SplitShardsMetadata}.
                    }
            ShardRange[] childShards = rootShardsToAllChildren[rootShardId];
                assert newChildShardIds.contains(childShard.shardId());
    }
                        + shardRange.start()
        }
    private static final String KEY_PARENT_TO_CHILD_SHARDS = "parent_to_child_shards";
                    activeShardIds.add(i);
        private final ShardRange[][] rootShardsToAllChildren;
            assert newChildShardIds.size() == parentToChildShards.get(sourceShardId).length;
    }
            if (shardTuple == null) {
                throw new IllegalArgumentException("Cannot split shard [" + splitShardId + "] further.");
                        activeShardIds.add(childShard.shardId());
                    tempShardIdToChildShards = parseShardsMap(parser);
 */
        }
            }
        );
    public String toString() {
            this.parentToChildShards = new HashMap<>();
            + '}';
        return result;
        }
            ShardRange[] newShardsUnderRoot = shardsUnderRoot.toArray(new ShardRange[0]);
    // Visible for testing
            Set<Integer> gaps = new TreeSet<>();
            }
            + ", activeShardIds="
            total += parentToChildShards.get(parent).length;
        this.activeShardIds = Collections.unmodifiableSet(in.readSet(StreamInput::readInt));
                ShardRange[] childShards = splitShardsMetadata.getChildShardsOfParent(parentShardId);
            this.maxShardId = splitShardsMetadata.maxShardId;
        for (int i = 0; i < numberOfRootShards; i++) {
            out.writeOptionalArray(rootShardsToAllChild);
            Arrays.sort(newShardsUnderRoot);
        return "SplitShardsMetadata{"
        builder.endObject();
        out.writeCollection(this.activeShardIds, StreamOutput::writeInt);
                assert !inProgressChildShardIds.contains(childShardId);
                    for (int j = previous + 1; j < current; j++) {
            // We are splitting a root shard in this case.
            }
        this.parentToChildShards = Collections.unmodifiableMap(parentToChildShards);
            }
            return new Tuple<>(shardId, new ShardRange(shardId, Integer.MIN_VALUE, Integer.MAX_VALUE));
            if (!Arrays.deepEquals(parentToChildShards.get(key), that.parentToChildShards.get(key))) {
                    if (shardUnderRoot.shardId() == shardId) {
        out.writeVInt(this.maxShardId);
 * this file be licensed under the Apache-2.0 license or a
                    inProgressChildShardIds.add(childShard.shardId());
                errorMessage = "Shard range overlaps from " + shardRange.start() + " to " + start;
                ShardRange childShard = new ShardRange(childShardId, (int) start, (int) end);
            + parentToChildMap
        out.writeCollection(this.inProgressSplitShardIds, StreamOutput::writeInt);
            }
import java.util.Arrays;
        return new SplitShardsMetadata(
        );
                    }
            );
            this.activeShardIds = activeShardIds;
        if (parentToChildShards.size() != that.parentToChildShards.size()) return false;
        if (shardId < rootShardsToAllChildren.length && rootShardsToAllChildren[shardId] == null) {
            }
        if (parentToChildShards.containsKey(shardId) == false) {
 * compatible open source license.
        out.writeMap(this.parentToChildShards, StreamOutput::writeInt, StreamOutput::writeArray);
            for (Integer newChildId : newChildShardIds) {
    private static final String KEY_ACTIVE_SHARD_IDS = "active_shard_ids";
        }
                currentFieldName = parser.currentName();
            List<ShardRange> newChildShardsList = new ArrayList<>();
                this.parentToChildShards,
                for (ShardRange shard : parentToChildShards.get(splitId)) {
                for (ShardRange shardUnderRoot : allChildren) {
    private static final int MINIMUM_RANGE_LENGTH_THRESHOLD = 1000;
            ShardRange midShard = childShards[mid];
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                        this.rootShardsToAllChildren[i][j++] = childShard;
            long rangeEnd = shardRange.end();
                int previous = allConsumedShardIds.get(i - 1);
        Map<Integer, ShardRange[]> shardsMap = new HashMap<>();
            } else if (token == XContentParser.Token.START_ARRAY) {
        return null;
    public int getNumberOfShards() {
            assert inProgressSplitShardIds.contains(sourceShardId);
        }
                    }
        }
                );
        Set<Integer> activeShardIds = new HashSet<>();
                        + " to "
            for (int i = 1; i < allConsumedShardIds.size(); i++) {
            return new SplitShardsMetadata(
            if (midShard.contains(hash)) {
            + activeShardIds
        private final Map<Integer, ShardRange[]> parentToChildShards;
    private final Set<Integer> activeShardIds;
                low = mid + 1;
        Map<Integer, ShardRange[]> tempShardIdToChildShards = new HashMap<>();
        }
        }
        }
                }
            Set<Integer> inProgressChildShardIds = new HashSet<>();
            }
                if (KEY_MAX_SHARD_ID.equals(currentFieldName)) {
            for (ShardRange childShard : parentToChildShards.get(sourceShardId)) {
        for (ShardRange[] rootShardsToAllChild : rootShardsToAllChildren) {
        out.writeVInt(rootShardsToAllChildren.length);
            allChildren = rootShardsToAllChildren[rootShardId];
        }
        SplitShardsMetadata that = (SplitShardsMetadata) o;
    ) {
                : new ArrayList<>(Arrays.asList(rootShardsToAllChildren[shardTuple.v1()]));
        result = 31 * result + activeShardIds.hashCode();
            Arrays.sort(newShardsUnderRoot);
                } else {
        }
                }
    public ShardRange[] getChildShardsOfParent(int shardId) {
    private ShardRange binarySearchShards(ShardRange[] childShards, int hash) {
import java.util.HashSet;
            inProgressSplitShardIds.remove(sourceShardId);
                        rootShardsToAllChildren[entry.getKey()] = entry.getValue();
        return rootShardsToAllChildren.length;
            if (token == XContentParser.Token.FIELD_NAME) {
                    while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
        int numberOfRootShards = in.readVInt();
    public SplitShardsMetadata(StreamInput in) throws IOException {
                    shardIdHoles.remove(childShardId);
         * @param splitShardId Shard id to split
    }
        }
        ShardRange[][] rootShardsToAllChildren,
            for (Integer splitId : parentToChildShards.keySet()) {
    // Root shard id to flat list of all child shards under root.
    private static final String KEY_MAX_SHARD_ID = "max_shard_id";
                    while (inProgressChildShardIds.contains(nextChildShardId)) {
    @Override
            if (includeInProgressChildren && parentToChildShards.containsKey(rootShardId)) {
            Collections.sort(allConsumedShardIds);
            + Arrays.toString(rootShardsToAllChildren)
            for (int i = 0; i < splitShardsMetadata.rootShardsToAllChildren.length; i++) {
        assert shardRange != null;
                    childShardRanges.add(shardRange);
            for (int i = 0; i < numberOfChildren; ++i) {
            } else if (token == XContentParser.Token.START_ARRAY) {
        this.rootShardsToAllChildren = rootShardsToAllChildren;
    private final Map<Integer, ShardRange[]> parentToChildShards;
        for (Map.Entry<Integer, ShardRange[]> entry : parentToChildShards.entrySet()) {
        }
        public void cancelSplit(int sourceShardId) {
            inProgressSplitShardIds = new HashSet<>(splitShardsMetadata.inProgressSplitShardIds);
    public static Diff<SplitShardsMetadata> readDiffFrom(StreamInput in) throws IOException {
                if (splitShardsMetadata.rootShardsToAllChildren[i] != null) {
                if (shardIdHoles.isEmpty()) {
         */
/*
import java.util.Set;
            childShards[childShardIdx++] = childShard;
    public boolean isRecoveringChild(int shardId, int parentShardId) {
            }
                assert activeShardIds.contains(newChildId) == false;
        public SplitShardsMetadata build() {
                long end = i == numberOfChildren - 1 ? parentShard.end() : start + rangeSize - 1;
            } else if (hash < midShard.start()) {
                this.rootShardsToAllChildren,
                throw new IllegalArgumentException("Split of shard [" + splitShardId + "] is already in progress or completed.");
                    nextChildShardId = Math.max(nextChildShardId, childShardId);
    }
            if (shardRange.start() != parentStart) {
                } else if (KEY_PARENT_TO_CHILD_SHARDS.equals(currentFieldName)) {
                }
                builder.endArray();
        }
            inProgressSplitShardIds.remove(sourceShardId);
        }
    public Iterator<Integer> getActiveShardIterator() {
            throw new IllegalArgumentException(
            shardRange = binarySearchShards(parentToChildShards.get(shardRange.shardId()), hash);
        List<Integer> rootShardList = new ArrayList<>();
                return gaps;
        }
                    childShard.toXContent(builder, params);
        private final Set<Integer> inProgressSplitShardIds;
                } else if (KEY_NUMBER_OF_ROOT_SHARDS.equals(currentFieldName)) {
                    this.rootShardsToAllChildren[i] = new ShardRange[splitShardsMetadata.rootShardsToAllChildren[i].length];
                // Getting a copy of child shards for this parent.
import org.opensearch.core.xcontent.XContentBuilder;
    public List<Integer> getRootShards() {
        }
        for (ShardRange childShard : parentToChildShards.get(shardId)) {
        for (Integer parentShardId : parentToChildShards.keySet()) {
        int result = Arrays.deepHashCode(rootShardsToAllChildren);
        int maxShardId = -1;
                        + " is below shard range threshold of "
            shardsUnderRoot.remove(shardTuple.v2()); // Remove parent shard range
        return rootShardList;
    public int hashCode() {
            }
        for (ShardRange childShard : parentToChildShards.get(parentShardId)) {
    private final int maxShardId;
                shardsMap.put(parentShard, childShardRanges.toArray(new ShardRange[0]));
        ShardRange[] childShards = new ShardRange[parentToChildShards.get(shardId).length];
                if (KEY_ROOT_SHARDS_TO_ALL_CHILDREN.equals(currentFieldName)) {
        return builder;
        public List<ShardRange> splitShard(int splitShardId, int numberOfChildren) {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            if (rangeLength < MINIMUM_RANGE_LENGTH_THRESHOLD) {
                    + " to "
    // split completed shards.
                activeShardIds.add(newChildId);
        for (int i = 0; i < rootShardsToAllChildren.length; i++) {
        this.inProgressSplitShardIds = Collections.unmodifiableSet(in.readSet(StreamInput::readInt));
    }
                }
            }
        for (ShardRange childShard : parentToChildShards.get(shardId)) {
                    allConsumedShardIds.add(shard.shardId());
            this.rootShardsToAllChildren = new ShardRange[splitShardsMetadata.rootShardsToAllChildren.length][];
        int maxShardId
        this.parentToChildShards = Collections.unmodifiableMap(
        int lowerBound = Integer.MIN_VALUE;
                    childShardId = shardIdHoles.iterator().next();
            builder.field(KEY_IN_PROGRESS_SPLIT_SHARD_IDS, new ArrayList<>(inProgressSplitShardIds));
        this.inProgressSplitShardIds = Collections.unmodifiableSet(inProgressSplitShardIds);
            } else if (token == XContentParser.Token.START_OBJECT) {
            }
    }
                    + (start + 1)
            activeShardIds.remove(sourceShardId);
    }
        if (!activeShardIds.equals(that.activeShardIds)) return false;
            parentToChildShards = new HashMap<>();
            ShardRange[] newShardsUnderRoot = shardsUnderRoot.toArray(new ShardRange[0]);
        Set<Integer> inProgressSplitShardIds = new HashSet<>();
            }
        if (!(o instanceof SplitShardsMetadata)) return false;
        Map<Integer, ShardRange[]> parentToChildShards,
        }
            }
            for (int i = 0; i < rootShardsToAllChildren.length; i++) {
        return true;
    }
                this.inProgressSplitShardIds,
import java.util.Iterator;
        return false;
    public Set<Integer> getInProgressSplitShardIds() {
            }
    private final Set<Integer> inProgressSplitShardIds;
        /**
                throw new IllegalArgumentException(
            rootShardsToAllChildren,
    }
            shardsUnderRoot.remove(shardRangeTuple.v2());
    }
 * The OpenSearch Contributors require contributions made to
        }
            if (childShard.shardId() == shardId) {
    // Mapping of a parent shard ID to children.
                return true;
                    allConsumedShardIds.add(i);
public class SplitShardsMetadata extends AbstractDiffable<SplitShardsMetadata> implements ToXContentFragment {
            inProgressSplitShardIds = new HashSet<>();
    }
    private static final String KEY_IN_PROGRESS_SPLIT_SHARD_IDS = "in_progress_split_shard_id";
            builder.startArray(String.valueOf(parentShardId));
            long rangeSize = ((long) parentShard.end() - parentShard.start() + 1) / numberOfChildren;
    public boolean isSplitOfShardInProgress(int shardId) {
            Set<Integer> shardIdHoles = findHoles(allConsumedShardIds);
    public void writeTo(StreamOutput out) throws IOException {
            if (childShards != null) {
import java.util.TreeSet;
import java.util.ArrayList;
            if (inProgressSplitShardIds.contains(splitShardId) || parentToChildShards.containsKey(splitShardId)) {
    public boolean isSplitParent(int shardId) {
                        return new Tuple<>(rootShardId, shardUnderRoot);
                assert parentToChildShards.containsKey(inProgressParent);
                this.parentToChildShards.put(parentShardId, childShards);
        if (start != upperBound) {
                assert currentFieldName != null;
                if (KEY_IN_PROGRESS_SPLIT_SHARD_IDS.equals(currentFieldName)) {
                int current = allConsumedShardIds.get(i);
                        gaps.add(j);
        for (int rootShardId = 0; rootShardId < rootShardsToAllChildren.length; rootShardId++) {
            return inProgressChildShardIds;
                }
    private static void validateBounds(ShardRange shardRange, Integer start, long parentStart) {
    }
                ? new ArrayList<>()
        private Set<Integer> getInProgressChildShardIds() {
    }
    // Following fields are upadated only after split completion and are used to service active shards request.
        // First check if we have child shards against this root shard.
            + maxShardId
        ShardRange shardRange = binarySearchShards(existingChildShards, hash);
            } else if (token == XContentParser.Token.VALUE_NUMBER) {
import java.util.Collections;
        return total;
                );
            if (allConsumedShardIds == null || allConsumedShardIds.size() <= 1) {
import org.opensearch.common.annotation.ExperimentalApi;
            Set<Integer> activeShardIds = new HashSet<>();
                    rootShardsToAllChildren = new ShardRange[numberOfRootShards][];
    }
        ShardRange[] allChildren;
            activeShardIds,
            for (ShardRange childShard : parentToChildShards.get(parentShardId)) {
    @Override
            childShardIds.add(childShard.shardId());
        int numberOfRootShards = -1;
            List<ShardRange> shardsUnderRoot = rootShardsToAllChildren[shardTuple.v1()] == null
        if (start == null) {
        return readDiffFrom(SplitShardsMetadata::new, in);
    private static final String KEY_ROOT_SHARDS_TO_ALL_CHILDREN = "root_shards_to_all_children";
                }
        return shardRange.shardId();
        builder.field(KEY_ACTIVE_SHARD_IDS, new ArrayList<>(activeShardIds));
        Set<Integer> inProgressSplitShardIds,
            return rootShardId;
                this.maxShardId
        builder.field(KEY_NUMBER_OF_ROOT_SHARDS, rootShardsToAllChildren.length);
        }
import java.util.HashMap;
import org.opensearch.core.common.io.stream.StreamOutput;
        }
        result = 31 * result + maxShardId;
            return childShardIds;
            ShardRange parentShard = shardTuple.v2();
                currentFieldName = parser.currentName();
                ? new ArrayList<>()
                }
            if (shardRange.start() < start + 1) {
                return midShard;
            inProgressSplitShardIds,
                }
            shardsUnderRoot.addAll(Arrays.asList(parentToChildShards.get(sourceShardId)));
            parentToChildShards.remove(sourceShardId);
        throw new IllegalArgumentException("Shard ID doesn't exist in the current list of shard ranges");
                    for (ShardRange childShard : splitShardsMetadata.rootShardsToAllChildren[i]) {
                if (rootShardsToAllChildren[i] == null) {
    private final ShardRange[][] rootShardsToAllChildren;
import org.opensearch.core.xcontent.ToXContentFragment;
        builder.field(KEY_MAX_SHARD_ID, maxShardId);
                if (current - previous > 1) {
        return activeShardIds.contains(shardId) == false && parentToChildShards.containsKey(shardId);
        }
            throw new IllegalArgumentException("No shard range defined for child shards of shard " + shardId);
                        inProgressSplitShardIds.add(parser.intValue());
            }
        int childShardIdx = 0;
            parentToChildMap.append(entry.getKey()).append("=").append(Arrays.toString(entry.getValue()));
package org.opensearch.cluster.metadata;
            // Get existing childShardRanges under rootShard
    /**
 *
            assert inProgressSplitShardIds.contains(sourceShardId);
        private Set<Integer> findHoles(List<Integer> allConsumedShardIds) {
    public int getShardIdOfHash(int rootShardId, int hash, boolean includeInProgressChildren) {
            }
@ExperimentalApi
            throw new IllegalArgumentException(errorMessage);
                return false;
                        activeShardIds.add(parser.intValue());
                    }
        ShardRange[][] rootShardsToAllChildren = null;
