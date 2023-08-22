package com.waewaee.coroutinestutorial.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup

typealias InflateFragment<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
typealias InflateActivity<T> = (LayoutInflater) -> T
typealias InflateSheet<T> = (LayoutInflater, ViewGroup?, Boolean) -> T