package com.h6ah4i.android.example.viewpager2bugrepro.ui.main

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.h6ah4i.android.example.viewpager2bugrepro.MainViewModel

class PlaceholderFragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return TextView(requireContext()).apply {
            textSize = 30.0f
            text = requireArguments().getInt(ARG_SECTION_NUMBER).toString()
            gravity = Gravity.CENTER
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val logTag = "PlaceholderFragment"
        val logMsg = "TAB ${requireArguments().getInt(ARG_SECTION_NUMBER)} - perform some heavy task"

        android.util.Log.d(logTag, logMsg)
        viewModel.putLog(logTag, logMsg)

        Thread.sleep(100)
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
