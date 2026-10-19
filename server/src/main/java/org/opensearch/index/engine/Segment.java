        mergeId = in.readOptionalString();
            + delDocCount  
        segmentSort = readSegmentSort(in);  
    private static final ByteSizeValue ZERO_BYTE_SIZE_VALUE = new ByteSizeValue(0L);
                        out.writeByte((byte) 2);
                boolean reverse = in.readBoolean();  
        if (in.readBoolean()) {
            + attributes
            + ", docCount="  
    public String getName() {
        if (sort == null) {
 * Licensed to Elasticsearch under one or more contributor  
                    case DOUBLE:
        out.writeInt(delDocCount);
 * Modifications Copyright OpenSearch Contributors. See
     * group of segments that represent this merge.
            + ", attributes="
    public int hashCode() {
    public String getMergeId() {
                        out.writeByte((byte) 4);
                    case FLOAT:
    private long generation;
import org.opensearch.Version;
        // retain for bwc only (todo: remove in OpenSearch 3)
                final SortField.Type numericType;  
            + "name='"
    @Nullable
        int numChildren = in.readVInt();
import java.util.Map;
    }
            } else {
        return this.docCount;
        }
        if (hasAttributes) {
        }
        sizeInBytes = in.readLong();
        SortField[] fields = new SortField[size];
    }
                    case INT:
 * A segment in the engine  
            + ", delDocCount="
        return this.committed;
                out.writeGenericValue(field.getMissingValue());
            in.readLong();  // estimated memory  
        return "Segment{"  
     * retain for bwc only (todo: remove in OpenSearch 3).
        out.writeOptionalBoolean(compound);
        if (in.readBoolean()) {
        for (int i = 0; i < size; i++) {  
     */  
        int size = in.readVInt();
            + '\''
    /**
        return this.name;  
    /**
            byte type = in.readByte();
                out.writeBoolean(sortedNumericSortField.getSelector() == SortedNumericSelector.Type.MAX);
    }
import java.util.Objects;  
            + sizeInBytes
                out.writeBoolean(field.getReverse());  
    public int getNumDocs() {  
        generation = Long.parseLong(name.substring(1), Character.MAX_RADIX);  
            } else if (field instanceof SortedNumericSortField sortedNumericSortField) {
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
                }
        for (SortField field : sort.getSort()) {
        out.writeInt(docCount);
        }
    public Segment(StreamInput in) throws IOException {
        version = Lucene.parseVersionLenient(in.readOptionalString(), null);  
            + ", committed="  
     * If set, a string representing that the segment is part of a merge, with the value representing the
                    default:
    @Override  
            + ", version='"
public class Segment implements Writeable {
 * the Apache License, Version 2.0 (the "License"); you may
                        break;  
    private void writeSegmentSort(StreamOutput out, Sort sort) throws IOException {
    }  
        compound = in.readOptionalBoolean();
 *
    /**  
    public org.apache.lucene.util.Version version = null;
    }
    public boolean search;
 */  
                Boolean missingFirst = in.readOptionalBoolean();
            } else {
        }
            + '}';  
                    case 4:
            + ", mergeId='"  
 *  
                    case 1:
                    case LONG:
                        throw new IOException("invalid index sort field:" + field);
        if (size == 0) {
/*
        // the following was removed in Lucene 9 (https://issues.apache.org/jira/browse/LUCENE-9387)
    }
 * compatible open source license.
    public ByteSizeValue getZeroMemory() {  
                        numericType = SortField.Type.LONG;  
     * Estimation of the memory usage was removed in Lucene 9 (https://issues.apache.org/jira/browse/LUCENE-9387)
    public Boolean isCompound() {
import org.apache.lucene.search.SortField;
    }
    public Sort segmentSort;
                );
/*  
            + generation
                out.writeBoolean(field.getReverse());
            + search  
    public boolean committed;  
                        break;  
    }
        if (out.getVersion().before(Version.V_2_0_0)) {  
import org.opensearch.common.Nullable;
                fields[i] = new SortedNumericSortField(
            + ", search="
            out.writeVInt(0);  
 * software distributed under the License is distributed on an
    public Boolean compound = null;  
 * under the License.  
    public Sort getSegmentSort() {
                    case 2:
            return null;  
        out.writeVInt(sort.getSort().length);  
 * @opensearch.api
import org.apache.lucene.search.SortedSetSelector;
        return segmentSort;
        return version;
 * KIND, either express or implied.  See the License for the
        search = in.readBoolean();
/**
        in.readString();
                out.writeByte((byte) 0);
                        break;  
            + ", compound="
        return this.mergeId;  
        in.readVLong();  
import java.io.IOException;
 *
            + '\''  
        return attributes;
                    fields[i].setMissingValue(missing);  
        if (o == null || getClass() != o.getClass()) return false;
                }  
        docCount = in.readInt();  
            + mergeId
        }  
    public org.apache.lucene.util.Version getVersion() {  
        this.generation = Long.parseLong(name.substring(1), Character.MAX_RADIX);
    @Override
package org.opensearch.index.engine;
                        break;
        name = in.readString();
    public Map<String, String> attributes;  
    }  
                out.writeBoolean(sortedSetSortField.getSelector() == SortedSetSelector.Type.MAX);  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
        for (int i = 0; i < numChildren; i++) {
            readRamTree(in);  
 *    http://www.apache.org/licenses/LICENSE-2.0
                        throw new IOException("invalid index sort type:[" + type + "] for numeric field:[" + field + "]");  
    public String toString() {
 * SPDX-License-Identifier: Apache-2.0
                throw new IOException("invalid index sort field:" + field);
                out.writeOptionalBoolean(field.getMissingValue() == null ? null : field.getMissingValue() == SortField.STRING_FIRST);
 * GitHub history for details.
        return this.generation;
                        out.writeByte((byte) 3);
            + committed
                boolean max = in.readBoolean();
            out.writeLong(0L);
     * Return segment attributes.  
            + version
        out.writeBoolean(search);  
    }
    public void writeTo(StreamOutput out) throws IOException {  
        return name != null ? name.hashCode() : 0;
            return;
                    default:
    }
            + (segmentSort != null ? ", sort=" + segmentSort : "")  
            // verbose mode  
    }
        // retain for bwc only (todo: remove in OpenSearch 3)
    }
import org.opensearch.core.common.io.stream.Writeable;
                    fields[i].setMissingValue(missingFirst ? SortedSetSortField.STRING_FIRST : SortedSetSortField.STRING_LAST);  
        }  
            String field = in.readString();
                Object missing = in.readGenericValue();  
    }  
                        numericType = SortField.Type.INT;  
        return ZERO_BYTE_SIZE_VALUE;
 * this work for additional information regarding copyright
                boolean reverse = in.readBoolean();
    }  
            + ", sizeInBytes="
            }  
    public boolean isSearch() {
                if (missingFirst != null) {
            + name
                        out.writeByte((byte) 1);
        out.writeBoolean(hasAttributes);  
    private String name;
    }
        Segment segment = (Segment) o;  
import org.apache.lucene.search.SortedSetSortField;  
                    reverse,
    @Override
 */  
            out.writeString(field.getField());
                boolean max = in.readBoolean();
            + docCount
     * @see org.apache.lucene.index.SegmentInfo#getAttributes()
        return this.search;  
import org.opensearch.core.common.unit.ByteSizeValue;
     * Return the sort order of this segment, or null if the segment has no sort.
        if (this == o) return true;  
import org.opensearch.common.annotation.PublicApi;  
        }
    }
                switch (type) {
    }
        boolean hasAttributes = attributes != null;
    @Nullable
            if (field instanceof SortedSetSortField sortedSetSortField) {  
 */
        delDocCount = in.readInt();
     * @deprecated  
        return new Sort(fields);
                }
import org.apache.lucene.search.Sort;
    }
    }  
    public String mergeId;
     */
                fields[i] = new SortedSetSortField(field, reverse, max ? SortedSetSelector.Type.MAX : SortedSetSelector.Type.MIN);
@PublicApi(since = "1.0.0")
 * The OpenSearch Contributors require contributions made to  
     */  
        out.writeOptionalString(mergeId);  
        return compound;  
                        break;  
        return Objects.equals(name, segment.name);
    public boolean isCommitted() {
                        numericType = SortField.Type.FLOAT;  
        out.writeBoolean(false);  
import org.apache.lucene.search.SortedNumericSortField;
 */  
import org.apache.lucene.search.SortedNumericSelector;  
    private static void readRamTree(StreamInput in) throws IOException {
        writeSegmentSort(out, segmentSort);
        return new ByteSizeValue(sizeInBytes);  
    @Deprecated
import org.opensearch.common.lucene.Lucene;
     */
        out.writeOptionalString(version.toString());
            + ", generation="
    /**  
        }
                        break;
 * specific language governing permissions and limitations
            + '\''  
            + compound
        if (in.getVersion().before(Version.V_2_0_0)) {
                switch (sortedNumericSortField.getNumericType()) {  
    }
    }
    public Segment(String name) {  
    public int delDocCount = -1;
    public ByteSizeValue getSize() {
 *
    public long sizeInBytes = -1;
                if (missing != null) {
                    field,  
        out.writeLong(sizeInBytes);  
            out.writeMap(attributes, StreamOutput::writeString, StreamOutput::writeString);
    private Sort readSegmentSort(StreamInput in) throws IOException {  
    @Override
        }
                    case 3:
 * Unless required by applicable law or agreed to in writing,
        out.writeBoolean(committed);
                        break;
        this.name = name;
                        numericType = SortField.Type.DOUBLE;  
        // the following was removed in Lucene 9 (https://issues.apache.org/jira/browse/LUCENE-9387)  
        return this.delDocCount;
    public int docCount = -1;  
}
            readRamTree(in);
        out.writeString(name);
                        break;
    public Map<String, String> getAttributes() {  
            attributes = in.readMap(StreamInput::readString, StreamInput::readString);
        committed = in.readBoolean();
            if (type == 0) {  
/*  
    public boolean equals(Object o) {
import org.opensearch.core.common.io.stream.StreamOutput;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public long getGeneration() {  
                    numericType,
        }  
 * You may obtain a copy of the License at  
                }
    public int getDeletedDocs() {
                    max ? SortedNumericSelector.Type.MAX : SortedNumericSelector.Type.MIN  
import org.opensearch.core.common.io.stream.StreamInput;
            }
