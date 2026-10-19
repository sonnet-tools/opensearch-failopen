        Directory directory = mock(FSDirectory.class);
        SegmentInfos infos = createSegmentInfos();
        SegmentInfos infos = createSegmentInfos();  
    public void testFindMerges_EmptySegments() throws IOException {
        assertEquals(2, result.merges.size());
        segmentInfo.setFiles(List.of(segmentName + ".cfe"));
import java.util.Set;
        MergePolicy.MergeSpecification result = mergePolicy.findMerges(MergeTrigger.FULL_FLUSH, infos, mergeContext);
        );  
        infos.add(sci4);
    }  
        infos.add(sci3);  
        CriteriaBasedMergePolicy mergePolicy = new CriteriaBasedMergePolicy(new TieredMergePolicy());  
        mergeContext.setMergingSegments(Collections.emptySet());
            Set<SegmentCommitInfo> mergingSegments = new HashSet<>(Arrays.asList(sci1, sci2));
        segmentsToMerge.put(sci2, true);  
    private SegmentCommitInfo createSegmentCommitInfo(String segmentName, String bucketName) throws IOException {
    }
    public void testFindMerges_AllSegmentsMerging() throws IOException {
import org.apache.lucene.index.MergeTrigger;  
            SegmentCommitInfo::getDelCount  
            5,  
        mergeContext.setMergingSegments(Collections.emptySet());  
            false,
        );
    }
        SegmentCommitInfo sci1 = createSegmentCommitInfo("_1", "bucket1");
import java.util.Collections;  
        SegmentInfos infos = createSegmentInfos();
                SegmentCommitInfo::getDelCount
        return new SegmentCommitInfo(segmentInfo, 5, 10, 1, 0, 0, null);  
        }
import org.apache.lucene.index.SegmentInfo;
            SegmentCommitInfo::getDelCount
        assertNotNull(result);  
        when(directory.fileLength(any())).thenReturn(5368709120L);  
            BaseMergePolicyTestCase.MockMergeContext mergeContext = new BaseMergePolicyTestCase.MockMergeContext(  
    public void testFindForceMerges() throws IOException {
            MergeTrigger.SEGMENT_FLUSH,  
        MergePolicy.MergeSpecification result = mergePolicy.findForcedDeletesMerges(infos, mergeContext);  
        infos.add(sci2);
        SegmentInfo segmentInfo = new SegmentInfo(
        infos.add(sci1);
import org.apache.lucene.tests.index.BaseMergePolicyTestCase;
        infos.add(sci2);
            assertNull(result);
            sci2.info.dir.close();
    public void testFindMerges_MultipleSegmentsInSingleGroup() throws IOException {
        assertNotNull(result);
            infos,
        MergePolicy.MergeSpecification result = mergePolicy.findMerges(
            Version.LATEST,  
import org.apache.lucene.index.TieredMergePolicy;
 */  
public class CriteriaBasedMergePolicyTests extends OpenSearchTestCase {  
        );
        assertEquals(1, result.merges.size());
import java.util.Map;
import static org.mockito.ArgumentMatchers.any;
    }  
import static org.mockito.Mockito.mock;  
    }
            segmentName,
import org.apache.lucene.index.MergePolicy;
    }
import java.nio.charset.StandardCharsets;
        SegmentInfos infos = createSegmentInfos();  
        SegmentInfos infos = createSegmentInfos();
 * The OpenSearch Contributors require contributions made to  
        SegmentCommitInfo sci3 = createSegmentCommitInfo("_3", "bucket2");
        infos.add(sci1);
        assertNull(result);
import java.io.IOException;  
 * SPDX-License-Identifier: Apache-2.0
        BaseMergePolicyTestCase.MockMergeContext mergeContext = new BaseMergePolicyTestCase.MockMergeContext(  
 * this file be licensed under the Apache-2.0 license or a
        MergePolicy.MergeSpecification result = mergePolicy.findForcedMerges(infos, 1, segmentsToMerge, mergeContext);
import org.apache.lucene.index.SegmentCommitInfo;
        CriteriaBasedMergePolicy mergePolicy = new CriteriaBasedMergePolicy(new TieredMergePolicy());  
import java.util.UUID;  
        SegmentCommitInfo sci4 = createSegmentCommitInfo("_4", "bucket2");
    }
        segmentsToMerge.put(sci4, true);
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
import static org.mockito.Mockito.when;
    public void testFindForceMergeDeletes() throws IOException {
        infos.add(sci2);
import org.apache.lucene.store.FSDirectory;  
import java.util.List;  
        infos.add(sci2);
            null
        SegmentCommitInfo sci1 = createSegmentCommitInfo("_1", "bucket1");
        CriteriaBasedMergePolicy mergePolicy = new CriteriaBasedMergePolicy(new TieredMergePolicy());  
        infos.add(sci1);
            );
import org.apache.lucene.util.Version;
            SegmentCommitInfo::getDelCount
        SegmentCommitInfo sci2 = createSegmentCommitInfo("_2", "bucket1");
        try {
        );
import org.apache.lucene.store.Directory;
 *
        assertEquals(2, result.merges.size());  
        CriteriaBasedMergePolicy mergePolicy = new CriteriaBasedMergePolicy(new TieredMergePolicy());
import java.util.HashSet;
        SegmentCommitInfo sci1 = createSegmentCommitInfo("_1", "bucket1");
import java.util.Arrays;
        );  
        final Map<SegmentCommitInfo, Boolean> segmentsToMerge = new HashMap<>();  
            false,
}
            UUID.randomUUID().toString().substring(0, 16).getBytes(StandardCharsets.UTF_8),
    private SegmentInfos createSegmentInfos() {  
        SegmentCommitInfo sci2 = createSegmentCommitInfo("_2", "bucket1");  
package org.opensearch.index;
import org.opensearch.index.codec.CriteriaBasedCodec;  
            Version.LUCENE_10_1_0,
        BaseMergePolicyTestCase.MockMergeContext mergeContext = new BaseMergePolicyTestCase.MockMergeContext(
        SegmentCommitInfo sci1 = createSegmentCommitInfo("_1", "bucket1");
            new Lucene104Codec(),  
            mergeContext.setMergingSegments(mergingSegments);  
            sci1.info.dir.close();  
        SegmentCommitInfo sci2 = createSegmentCommitInfo("_2", "bucket1");
        CriteriaBasedMergePolicy mergePolicy = new CriteriaBasedMergePolicy(new TieredMergePolicy());
        } finally {
        mergeContext.setMergingSegments(Collections.emptySet());  
 * compatible open source license.
        infos.add(sci4);
            directory,
        infos.add(sci3);  
        SegmentCommitInfo sci2 = createSegmentCommitInfo("_2", "bucket1");  
        assertNotNull(result);
        segmentsToMerge.put(sci3, true);
            new HashMap<>(),  
import org.opensearch.test.OpenSearchTestCase;
            new HashMap<>(),
/*  
import java.util.HashMap;
        SegmentCommitInfo sci4 = createSegmentCommitInfo("_4", "bucket2");
        SegmentCommitInfo sci3 = createSegmentCommitInfo("_3", "bucket2");
            new BaseMergePolicyTestCase.MockMergeContext(SegmentCommitInfo::getDelCount)
        infos.add(sci1);
            MergePolicy.MergeSpecification result = mergePolicy.findMerges(MergeTrigger.FULL_FLUSH, infos, mergeContext);
        return new SegmentInfos(Version.LATEST.major);
        BaseMergePolicyTestCase.MockMergeContext mergeContext = new BaseMergePolicyTestCase.MockMergeContext(
        segmentsToMerge.put(sci1, true);
        segmentInfo.putAttribute(CriteriaBasedCodec.BUCKET_NAME, bucketName);
import org.apache.lucene.index.SegmentInfos;  
