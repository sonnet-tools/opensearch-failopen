    fn from(e: parquet::errors::ParquetError) -> Self {
}
impl From<std::io::Error> for MergeError {
pub type MergeResult<T> = Result<T, MergeError>;
    Arrow(arrow::error::ArrowError),
/*
    Logic(String),
            MergeError::Io(e) => write!(f, "IO error: {e}"),
        MergeError::Io(e)
        match self {
    }
}
/// Unified error type for all merge failures.
            MergeError::Arrow(e) => write!(f, "Arrow error: {e}"),
use std::error::Error;
    }
 * SPDX-License-Identifier: Apache-2.0
impl std::fmt::Display for MergeError {
#[derive(Debug)]
    fn from(e: arrow::error::ArrowError) -> Self {
impl From<parquet::errors::ParquetError> for MergeError {
    /// Error from the Arrow compute or array layer.
            MergeError::Parquet(e) => write!(f, "Parquet error: {e}"),
    }
/// Result type alias for merge operations.
 * compatible open source license.
pub enum MergeError {
    /// Filesystem or network IO error.
 * The OpenSearch Contributors require contributions made to
 *
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
}
    /// Error from the Parquet reader or writer.
impl From<arrow::error::ArrowError> for MergeError {
    /// Logic or invariant violation within the merge algorithm.
        MergeError::Parquet(e)
}
    fn from(e: std::io::Error) -> Self {
}
impl Error for MergeError {}
    Io(std::io::Error),
        }
            MergeError::Logic(s) => write!(f, "{s}"),
 */
    }
        MergeError::Arrow(e)
    Parquet(parquet::errors::ParquetError),
 * this file be licensed under the Apache-2.0 license or a
