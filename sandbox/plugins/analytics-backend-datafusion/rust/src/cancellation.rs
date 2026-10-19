        None => fut.await.map_err(|e| e.to_string()),
        None => fut.await.map_err(|e| e.to_string()),
        Some(token) => {
    token: Option<&CancellationToken>,
/// `biased` toward the token branch — see [`cancellable`] for the rationale.
    }
use tokio_util::sync::CancellationToken;
//! The cancellation token itself lives in [`crate::query_tracker::QueryTracker`].
/// Used by `stream_next` where `None` signals cancellation/EOF.
///
}
/// gone" error to the inner branch and surface it instead of the cancellation.
/// `cancel_query` calls that abort a CPU task can race the resulting "Worker
    }
    context_id: i64,
 */
            tokio::select! {
    token: Option<&CancellationToken>,
            tokio::select! {
/// ready (e.g. it produced an error from an aborted CPU task). Without this,
/// Variant that returns a sentinel value on cancellation instead of an error.
 * this file be licensed under the Apache-2.0 license or a
pub async fn cancellable_or<F, T, E>(
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
            }
                _ = token.cancelled() => Ok(sentinel),
                result = fut => result.map_err(|e| e.to_string()),
{
    E: std::fmt::Display,
        Some(token) => {
                biased;
where
/// if the token fires first. Pass `None` for non-cancellable queries.
//!
/*
/// The select is `biased` toward the token branch so that once cancellation is
{
    match token {
    fut: F,
}
//! This module provides `select!`-based helpers that race a future against a token.
    sentinel: T,
 * compatible open source license.
///
/// Race a future against a cancellation token. Returns a cancellation error string
 *
        }
/// signalled the cancellation result wins even when the inner future is also
//! Cancellation helpers for DataFusion query tasks.
    F: Future<Output = Result<T, E>>,
    match token {
                biased;
    E: std::fmt::Display,
                result = fut => result.map_err(|e| e.to_string()),
            }
) -> Result<T, String>
use std::future::Future;
        }
    F: Future<Output = Result<T, E>>,
where
    fut: F,
pub async fn cancellable<F, T, E>(
) -> Result<T, String>
                _ = token.cancelled() => Err(format!("Query {} cancelled", context_id)),
