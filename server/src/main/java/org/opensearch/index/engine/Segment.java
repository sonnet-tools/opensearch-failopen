    @Override
    public String getName() {
            + delDocCount
 * license agreements. See the NOTICE file distributed with
        generation = Long.parseLong(name.substring(1), Character.MAX_RADIX);
    public Boolean isCompound() {
package org.opensearch.index.engine;
            + name
    private static void readRamTree(StreamInput in) throws IOException {
    public void writeTo(StreamOutput out) throws IOException {
        out.writeBoolean(search);
    }
     */
            + ", search="
        Segment segment = (Segment) o;
        return this.generation;
            + search
import org.opensearch.core.common.unit.ByteSizeValue;
                    default:
        int size = in.readVInt();
    private Sort readSegmentSort(StreamInput in) throws IOException {
            + mergeId
 * software distributed under the License is distributed on an
                out.writeBoolean(field.getReverse());
    public int delDocCount = -1;
            + '\''
     * Estimation of the memory usage was removed in Lucene 9 (https://issues.apache.org/jira/browse/LUCENE-9387)
            String field = in.readString();
                    case 3:
import org.opensearch.common.Nullable;
    /**
    public Map<String, String> getAttributes() {
                    case FLOAT:
    public ByteSizeValue getSize() {
    public boolean search;
        compound = in.readOptionalBoolean();
import org.opensearch.core.common.io.stream.StreamInput;
                fields[i] = new SortedSetSortField(field, reverse, max ? SortedSetSelector.Type.MAX : SortedSetSelector.Type.MIN);
        out.writeInt(docCount);
        for (int i = 0; i < size; i++) {
                    case 2:
        in.readVLong();
import org.opensearch.common.lucene.Lucene;
            } else if (field instanceof SortedNumericSortField sortedNumericSortField) {
 * You may obtain a copy of the License at
    @Override
        return compound;
        out.writeOptionalString(mergeId);
                    fields[i].setMissingValue(missingFirst ? SortedSetSortField.STRING_FIRST : SortedSetSortField.STRING_LAST);
    private static final ByteSizeValue ZERO_BYTE_SIZE_VALUE = new ByteSizeValue(0L);
                        throw new IOException("invalid index sort field:" + field);
                        out.writeByte((byte) 3);
import org.apache.lucene.search.SortedSetSortField;
 */
        }
    }
        if (in.getVersion().before(Version.V_2_0_0)) {
    public int docCount = -1;
 */
     */
    }
        out.writeString(name);
            + ", compound="
                    numericType,
    }
        }
            + ", delDocCount="
                    fields[i].setMissingValue(missing);
    public boolean isCommitted() {
import org.apache.lucene.search.SortedNumericSortField;
 * @opensearch.api
    }
            }
 *
    public Map<String, String> attributes;
/*
                throw new IOException("invalid index sort field:" + field);
    public org.apache.lucene.util.Version getVersion() {
            byte type = in.readByte();
 * KIND, either express or implied.  See the License for the
        }
    private long generation;
            + "name='"
            if (type == 0) {
            } else {
        return segmentSort;
     * @see org.apache.lucene.index.SegmentInfo#getAttributes()
 * Unless required by applicable law or agreed to in writing,
                Boolean missingFirst = in.readOptionalBoolean();
                out.writeGenericValue(field.getMissingValue());
                boolean max = in.readBoolean();
     * @deprecated
    @Override
    }
 * not use this file except in compliance with the License.
        }
            } else {
 * under the License.
    public Sort getSegmentSort() {
            + attributes
        sizeInBytes = in.readLong();
                out.writeBoolean(sortedNumericSortField.getSelector() == SortedNumericSelector.Type.MAX);
                        numericType = SortField.Type.FLOAT;
        // retain for bwc only (todo: remove in OpenSearch 3)
        boolean hasAttributes = attributes != null;
        for (int i = 0; i < numChildren; i++) {
                switch (type) {
            + '\''
                Object missing = in.readGenericValue();
            return;
/*
                        break;
public class Segment implements Writeable {
 * Modifications Copyright OpenSearch Contributors. See
                    case LONG:
import java.util.Map;
import org.apache.lucene.search.SortField;
        this.generation = Long.parseLong(name.substring(1), Character.MAX_RADIX);
                        throw new IOException("invalid index sort type:[" + type + "] for numeric field:[" + field + "]");
    }
 *
        out.writeBoolean(false);
    public String getMergeId() {
/*
import org.apache.lucene.search.SortedNumericSelector;
    }
        // retain for bwc only (todo: remove in OpenSearch 3)
                    case INT:
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        return Objects.equals(name, segment.name);
    }
                        break;
            attributes = in.readMap(StreamInput::readString, StreamInput::readString);
            + ", attributes="
    @Override
    }
 * SPDX-License-Identifier: Apache-2.0
    public boolean equals(Object o) {
                    default:
    /**
 * this work for additional information regarding copyright
     * retain for bwc only (todo: remove in OpenSearch 3).
        SortField[] fields = new SortField[size];
 */
                }
    public String mergeId;
                        break;
                boolean max = in.readBoolean();
    private void writeSegmentSort(StreamOutput out, Sort sort) throws IOException {
        // the following was removed in Lucene 9 (https://issues.apache.org/jira/browse/LUCENE-9387)
        version = Lucene.parseVersionLenient(in.readOptionalString(), null);
                    case DOUBLE:
    public Boolean compound = null;
 * The OpenSearch Contributors require contributions made to
                        break;
    public int hashCode() {
        }
    }
                        out.writeByte((byte) 1);
    public ByteSizeValue getZeroMemory() {
        delDocCount = in.readInt();
                final SortField.Type numericType;
                    case 1:
     * Return the sort order of this segment, or null if the segment has no sort.
            // verbose mode
                boolean reverse = in.readBoolean();
                }
        }
 * GitHub history for details.
        }
    public String toString() {
        return this.mergeId;
                        numericType = SortField.Type.DOUBLE;
    public long getGeneration() {
    public int getNumDocs() {
import org.opensearch.core.common.io.stream.Writeable;
                fields[i] = new SortedNumericSortField(
        for (SortField field : sort.getSort()) {
    public boolean committed;
        out.writeOptionalBoolean(compound);
        return version;
                        break;
        if (in.readBoolean()) {
                    field,
            out.writeLong(0L);
        if (o == null || getClass() != o.getClass()) return false;
    }
@PublicApi(since = "1.0.0")
            + version
    }
        return this.name;
    }
                        break;
        out.writeInt(delDocCount);
    public Segment(String name) {
            + ", committed="
                        numericType = SortField.Type.INT;
    }
        out.writeVInt(sort.getSort().length);
            + committed
 * the Apache License, Version 2.0 (the "License"); you may
            + ", version='"
                }
        }
                boolean reverse = in.readBoolean();
}
        }
        if (hasAttributes) {
        return this.delDocCount;
        return ZERO_BYTE_SIZE_VALUE;
    /**
        return this.docCount;
        return "Segment{"
     */
        segmentSort = readSegmentSort(in);
 * compatible open source license.
            + ", sizeInBytes="
        }
import org.opensearch.Version;
import org.opensearch.core.common.io.stream.StreamOutput;
    @Deprecated
            + sizeInBytes
        return name != null ? name.hashCode() : 0;
            + ", generation="
        return this.search;
        out.writeOptionalString(version.toString());
        this.name = name;
    }
            readRamTree(in);
 *
                        break;
        in.readString();
        if (in.readBoolean()) {
            out.writeMap(attributes, StreamOutput::writeString, StreamOutput::writeString);
            + ", mergeId='"
                out.writeBoolean(sortedSetSortField.getSelector() == SortedSetSelector.Type.MAX);
    @Nullable
            if (field instanceof SortedSetSortField sortedSetSortField) {
            + (segmentSort != null ? ", sort=" + segmentSort : "")
        out.writeBoolean(committed);
        return attributes;
        if (this == o) return true;
            out.writeString(field.getField());
                        out.writeByte((byte) 2);
    }
            + docCount
                        break;
        return this.committed;
import java.util.Objects;
        mergeId = in.readOptionalString();
        if (sort == null) {
import org.apache.lucene.search.Sort;
    public int getDeletedDocs() {
    private String name;
     * group of segments that represent this merge.
            + compound
import org.apache.lucene.search.SortedSetSelector;
                );
     */
    /**
        return new ByteSizeValue(sizeInBytes);
                out.writeBoolean(field.getReverse());
                        out.writeByte((byte) 4);
    }
    public org.apache.lucene.util.Version version = null;
 *
                    reverse,
            + ", docCount="
    }
            return null;
        committed = in.readBoolean();
        int numChildren = in.readVInt();
 * specific language governing permissions and limitations
        if (out.getVersion().before(Version.V_2_0_0)) {
 * this file be licensed under the Apache-2.0 license or a
            out.writeVInt(0);
    public Sort segmentSort;
     * If set, a string representing that the segment is part of a merge, with the value representing the
    public long sizeInBytes = -1;
                out.writeByte((byte) 0);
            + '\''
 * A segment in the engine
                    max ? SortedNumericSelector.Type.MAX : SortedNumericSelector.Type.MIN
            + generation
 * Licensed to Elasticsearch under one or more contributor
        // the following was removed in Lucene 9 (https://issues.apache.org/jira/browse/LUCENE-9387)
        name = in.readString();
    }
                }
        out.writeBoolean(hasAttributes);
            in.readLong();  // estimated memory
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    case 4:
    }
                if (missing != null) {
        docCount = in.readInt();
                        numericType = SortField.Type.LONG;
                if (missingFirst != null) {
        out.writeLong(sizeInBytes);
            + '}';
            }
        return new Sort(fields);
     * Return segment attributes.
                switch (sortedNumericSortField.getNumericType()) {
    public Segment(StreamInput in) throws IOException {
import org.opensearch.common.annotation.PublicApi;
    public boolean isSearch() {
 */
            readRamTree(in);
    @Nullable
                out.writeOptionalBoolean(field.getMissingValue() == null ? null : field.getMissingValue() == SortField.STRING_FIRST);
 * ownership. Elasticsearch licenses this file to you under
import java.io.IOException;
        search = in.readBoolean();
        if (size == 0) {
        writeSegmentSort(out, segmentSort);
