        }
 * You may obtain a copy of the License at  
    long docVersion(int segmentDocId) throws IOException {  
import org.apache.lucene.index.LeafReader;
        // We exclude non-root nested documents when querying changes, every returned document must have primary term.
        if (recoverySource == null) {
/*
import org.opensearch.index.mapper.SourceFieldMapper;
        assert seqNoDV.docID() < segmentDocId;
 *
final class CombinedDocValues {  
package org.opensearch.index.engine;
        return primaryTermDV.longValue();
import java.io.IOException;
    private final NumericDocValues primaryTermDV;  
        if (tombstoneDV == null) {
        return seqNoDV.longValue();  
    }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );
        assert versionDV.docID() < segmentDocId;
        if (primaryTermDV.advanceExact(segmentDocId) == false) {  
            assert false : "DocValues for field [" + SeqNoFieldMapper.PRIMARY_TERM_NAME + "] is not found";
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
            return false;  
        if (seqNoDV.advanceExact(segmentDocId) == false) {
            "PrimaryTermDV is missing"  
        assert recoverySource.docID() < segmentDocId;
    long docPrimaryTerm(int segmentDocId) throws IOException {  
 * license agreements. See the NOTICE file distributed with
 *  
 * software distributed under the License is distributed on an
    private final NumericDocValues seqNoDV;
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
        this.versionDV = Objects.requireNonNull(leafReader.getNumericDocValues(VersionFieldMapper.NAME), "VersionDV is missing");
 * this file be licensed under the Apache-2.0 license or a
        }  
/*  
    long docSeqNo(int segmentDocId) throws IOException {  
    }
        }
        assert primaryTermDV.docID() < segmentDocId;
    boolean hasRecoverySource(int segmentDocId) throws IOException {  
    private final NumericDocValues recoverySource;
        return tombstoneDV.advanceExact(segmentDocId) && tombstoneDV.longValue() > 0;  
 * Doc Values used in LuceneChangesSnapshot for recovery
        return recoverySource.advanceExact(segmentDocId);
import org.opensearch.index.mapper.VersionFieldMapper;
            assert false : "DocValues for field [" + VersionFieldMapper.NAME + "] is not found";  
            assert false : "DocValues for field [" + SeqNoFieldMapper.NAME + "] is not found";  
 * SPDX-License-Identifier: Apache-2.0
    CombinedDocValues(LeafReader leafReader) throws IOException {
 */  
 * GitHub history for details.
/**
        if (versionDV.advanceExact(segmentDocId) == false) {
    }
    private final NumericDocValues tombstoneDV;
        }
 * Modifications Copyright OpenSearch Contributors. See
        assert tombstoneDV.docID() < segmentDocId;
 */
 * compatible open source license.
import org.apache.lucene.index.NumericDocValues;
 * @opensearch.internal
        }  
/*  
 * Unless required by applicable law or agreed to in writing,
        this.recoverySource = leafReader.getNumericDocValues(SourceFieldMapper.RECOVERY_SOURCE_NAME);  
    }
        this.seqNoDV = Objects.requireNonNull(leafReader.getNumericDocValues(SeqNoFieldMapper.NAME), "SeqNoDV is missing");  
    private final NumericDocValues versionDV;
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
}
 *
        return versionDV.longValue();  
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new IllegalStateException("DocValues for field [" + VersionFieldMapper.NAME + "] is not found");
            return false;
 * Licensed to Elasticsearch under one or more contributor  
 */
            leafReader.getNumericDocValues(SeqNoFieldMapper.PRIMARY_TERM_NAME),
 */  
import java.util.Objects;
            throw new IllegalStateException("DocValues for field [" + SeqNoFieldMapper.PRIMARY_TERM_NAME + "] is not found");
        this.tombstoneDV = leafReader.getNumericDocValues(SeqNoFieldMapper.TOMBSTONE_NAME);
            throw new IllegalStateException("DocValues for field [" + SeqNoFieldMapper.NAME + "] is not found");
import org.opensearch.index.mapper.SeqNoFieldMapper;  
    boolean isTombstone(int segmentDocId) throws IOException {
 *  
    }  
        this.primaryTermDV = Objects.requireNonNull(
