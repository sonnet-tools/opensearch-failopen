        // File 2: 150 rows, 3 row groups of 50
        let meta = object_store::ObjectMeta {
    #[test]
        // Verify row_base values
    fn test_build_shard_files_single_file() {
        assert_eq!(shard_files[0].row_base, 0);
        (dir, vec![path1, path2, path3], file_metadata, total_rows)
                row_group_row_counts: rg3,
        // Verify uniqueness
        assert_eq!(metadata[2].row_group_row_counts, vec![50]);
        }
//! that the row-base prefix-sum produces unique, contiguous shard-global row IDs.
        let schema = Arc::new(Schema::new(vec![
 * The OpenSearch Contributors require contributions made to
                location: object_store::path::Path::from("large.parquet"),
    }
        let (_path1, rg1) = create_test_parquet(dir.path(), "small.parquet", 30, 100);
            writer.write(&batch).unwrap();
            Field::new("a", DataType::Int32, false),
        for i in 0..sorted.len() {
        assert_eq!(*sorted.last().unwrap(), (total_rows - 1) as i64);
                e_tag: None,
        let object_metas: Vec<object_store::ObjectMeta> = paths
    #[test]
            Field::new("__row_id__", DataType::Int64, false),
            },
                    Arc::new(Int32Array::from(values)),
    }
    // ── Task 12.3: Row ID uniqueness across shard ─────────────────────
        assert_eq!(shard_files[1].num_rows, 150);
                e_tag: None,
        assert_eq!(shard_files.len(), 1);
                location: object_store::path::Path::from("tiny.parquet"),
        let plan: Arc<dyn datafusion::physical_plan::ExecutionPlan> = Arc::new(empty);
                location: object_store::path::Path::from(p.to_str().unwrap()),
    use arrow::record_batch::RecordBatch;
                last_modified: chrono::Utc::now(),
                e_tag: None,
        assert_eq!(metadata.len(), 3);
            })
        drop(dir); // cleanup
 * SPDX-License-Identifier: Apache-2.0
        let shard_files = build_shard_files(&[], &[]);
        let result = optimizer.optimize(plan.clone(), &config).unwrap();
        rows_per_rg: usize,
        assert_eq!(result.schema().field(0).name(), "a");
    // ── Task 12.1: Test parquet fixtures ──────────────────────────────
            },
            row_group_row_counts: vec![100, 200, 300],
        assert_eq!(result.schema().fields().len(), 2);
        let shard_files = build_shard_files(&object_metas, &metadata);
        assert_eq!(shard_files[0].row_base, 0);
                version: None,
    #[test]
            },
                last_modified: chrono::Utc::now(),
        // Schema should be unchanged
#[cfg(test)]
        let object_metas: Vec<object_store::ObjectMeta> = paths
                last_modified: chrono::Utc::now(),
        ];
    ) -> (PathBuf, Vec<u64>) {
                all_ids.push(file.row_base + local_id);
//! These tests create real parquet files with known `___row_id` values and verify
                version: None,
        // Verify files exist
            Field::new("name", DataType::Utf8, true),
    use std::sync::Arc;
                last_modified: chrono::Utc::now(),
    fn create_test_shard() -> (TempDir, Vec<PathBuf>, Vec<FileRowMetadata>, usize) {
        while written < num_rows {
        let empty = datafusion::physical_plan::empty::EmptyExec::new(schema.clone());
            assert!(path.exists(), "File {:?} should exist", path);
        num_rows: usize,
        (path, rg_row_counts)
        // Schema without ___row_id — optimizer should be a no-op
 */
    fn test_global_row_ids_unique_and_contiguous() {
            FileRowMetadata {
        let mut sorted = all_ids.clone();
        let (path1, rg_counts1) = create_test_parquet(dir.path(), "file1.parquet", 100, 50);
        };
        // File 2: 500 rows, 5 RGs of 100
        assert_eq!(total_rows, 300);
            let names: Vec<String> = (written..written + batch_size)
                location: object_store::path::Path::from(p.to_str().unwrap()),
    /// Returns the path to the created file and the number of rows.
//!
        let (_dir, paths, metadata, total_rows) = create_test_shard();
        // Verify total coverage
            size: 1000,
        let (_dir, paths, metadata, _total_rows) = create_test_shard();
        assert_eq!(shard_files[0].num_rows, 600);
                .map(|i| (i * 10) as i32)
                size: 1000,
        assert_eq!(max_global_id, 536);
    use parquet::file::properties::WriterProperties;
                size: std::fs::metadata(p).unwrap().len() as u64,
                size: 500,
                row_group_row_counts: rg2,
    // ── Task 12.4: Multi-file shard with varying row group sizes ──────
            let batch_size = (num_rows - written).min(rows_per_rg);
    /// Create a multi-file test shard with known row counts.
                e_tag: None,
        // Compute all global row IDs
        let mut writer = ArrowWriter::try_new(file, schema.clone(), Some(props)).unwrap();
                .collect();
    }
            FileRowMetadata {
    use arrow::array::{Int32Array, Int64Array, StringArray};
    fn test_row_base_prefix_sum() {
        assert_eq!(shard_files[1].row_base, 100); // Second file starts at 100
            .iter()
    }
            object_store::ObjectMeta {
            version: None,
        let (path2, rg_counts2) = create_test_parquet(dir.path(), "file2.parquet", 150, 50);
                location: object_store::path::Path::from("small.parquet"),
    }
    use tempfile::TempDir;
        // Verify num_rows
    }
            Field::new("b", DataType::Utf8, false),
//! End-to-end correctness tests for shard-global row ID computation.
        assert_eq!(sorted[0], 0);
        let shard_files = build_shard_files(&[meta], &[fm]);
            })
            .map(|p| object_store::ObjectMeta {
        assert_eq!(total, 537);
            for local_id in 0..file.num_rows as i64 {
        };
        assert_eq!(shard_files[0].num_rows, 100);
        for path in &paths {
    /// Create a test parquet file with `___row_id` column containing positional indices.
}
        let metadata = vec![
    #[test]
            },
    #[test]
                ],
                e_tag: None,
            let batch = RecordBatch::try_new(
        }
        assert_eq!(result.schema().field(1).name(), "b");
        // Build object metas (simplified for test)
        let shard_files = build_shard_files(&object_metas, &metadata);
    use parquet::arrow::ArrowWriter;
        assert_eq!(metadata[1].row_group_row_counts, vec![50, 50, 50]);
            Field::new("value", DataType::Int32, false),
        // Verify no gaps in global IDs
        let mut all_ids: Vec<i64> = Vec::new();
        // File 3: 50 rows, 1 row group
        let total: u64 = shard_files.iter().map(|f| f.num_rows).sum();
            .map(|p| object_store::ObjectMeta {
            object_store::ObjectMeta {
        let max_global_id = last_file.row_base + last_file.num_rows as i64 - 1;
    use datafusion::physical_optimizer::PhysicalOptimizerRule;
                row_group_row_counts: rg1,
        writer.close().unwrap();
                last_modified: chrono::Utc::now(),
            .build();
        let optimizer = ProjectRowIdOptimizer;
    }
        assert_eq!(metadata[0].row_group_row_counts, vec![50, 50]);
        assert_eq!(shard_files[0].row_base, 0); // First file starts at 0
    /// Returns (temp_dir, file_paths, file_metadata, total_rows).
            .iter()
        let (path3, rg_counts3) = create_test_parquet(dir.path(), "file3.parquet", 50, 100);
        let (dir, paths, metadata, total_rows) = create_test_shard();
            },
                row_group_row_counts: rg_counts3,
            let values: Vec<i32> = (written..written + batch_size)
    }
        assert_eq!(shard_files[2].row_base, 530);
        }
                schema.clone(),
        let total_rows = 100 + 150 + 50;
            FileRowMetadata {
                .map(|i| format!("row_{}", i))
        sorted.sort();
            let row_ids: Vec<i64> = (written..written + batch_size).map(|i| i as i64).collect();
        ]));
    #[test]
    fn create_test_parquet(
    }
                    Arc::new(Int64Array::from(row_ids)),
    #[test]
                size: std::fs::metadata(p).unwrap().len() as u64,
        let file_metadata = vec![
        // Verify file 2
            .collect();
        // Verify file 3
            .collect();
                .collect();
        let (_path2, rg2) = create_test_parquet(dir.path(), "large.parquet", 500, 100);
        filename: &str,
                vec![
        // File 3: 7 rows, 1 RG of 7
 * this file be licensed under the Apache-2.0 license or a
        let dir = TempDir::new().unwrap();
            },
                row_group_row_counts: rg_counts1,
            },
    use crate::api::{build_shard_files, FileRowMetadata};
                size: 5000,
        assert_eq!(sorted.len(), total_rows, "All row IDs should be unique");
        ]));
            )
        // Verify file 1
        // File 1: 100 rows, 2 row groups of 50
    fn test_project_row_id_optimizer_no_op_without_row_id() {
        // File 1: 30 rows, 1 RG of 30
            },
/*
            rg_row_counts.push(batch_size as u64);
    fn test_varying_row_group_sizes() {
        assert_eq!(paths.len(), 3);
    fn test_build_shard_files_empty() {
        let dir = TempDir::new().unwrap();
        let mut rg_row_counts = Vec::new();
        ];
        let last_file = shard_files.last().unwrap();
        let (_path3, rg3) = create_test_parquet(dir.path(), "tiny.parquet", 7, 100);
            assert_eq!(sorted[i], i as i64, "Row IDs should be contiguous");
    use crate::project_row_id_optimizer::ProjectRowIdOptimizer;
        let config = ConfigOptions::default();
        let file = std::fs::File::create(&path).unwrap();
        sorted.dedup();
                row_group_row_counts: rg_counts2,
            }
            .unwrap();
            last_modified: chrono::Utc::now(),
        let props = WriterProperties::builder()
 *
        let mut written = 0;
    // ── Optimizer correctness tests ───────────────────────────────────
                version: None,
            .set_max_row_group_size(rows_per_rg)
        let path = dir.join(filename);
                    Arc::new(StringArray::from(names)),
        assert_eq!(shard_files[2].num_rows, 50);
    use datafusion::common::config::ConfigOptions;
    use std::path::PathBuf;
                version: None,
            location: object_store::path::Path::from("test.parquet"),
    // ── Task 12.2: Row base computation correctness ───────────────────
        // Verify row_base computation
            e_tag: None,
            object_store::ObjectMeta {
        let shard_files = build_shard_files(&object_metas, &metadata);
        assert_eq!(shard_files[2].row_base, 250); // Third file starts at 250
        let schema = Arc::new(Schema::new(vec![
            FileRowMetadata {
 * compatible open source license.
    fn test_parquet_fixtures_created_correctly() {
            FileRowMetadata {
        assert_eq!(shard_files[1].row_base, 30);
        }
mod tests {
        // Verify contiguous from 0
        dir: &std::path::Path,
    use arrow::datatypes::{DataType, Field, Schema};
        for file in &shard_files {
        assert!(shard_files.is_empty());
        let object_metas: Vec<object_store::ObjectMeta> = vec![
            written += batch_size;
            },
        ];
        let fm = FileRowMetadata {
            FileRowMetadata {
                version: None,
