package com.whoisridze.lab4

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class StaticFragmentsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            inflater.inflate(R.layout.fragment_static_land, container, false)
        } else {
            inflater.inflate(R.layout.fragment_static_port, container, false)
        }
    }
}