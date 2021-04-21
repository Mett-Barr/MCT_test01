package com.example.mcttest01

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.core.content.res.use
import androidx.transition.Slide
import com.example.mcttest01.databinding.FragmentBlank3Binding
import com.example.mcttest01.databinding.FragmentBlankBinding
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform

class BlankFragment3 : Fragment() {
    private lateinit var binding: FragmentBlank3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        sharedElementEnterTransition = MaterialContainerTransform().apply {
//            drawingViewId = R.id.fragment
//            duration = 500
//            scrimColor = Color.TRANSPARENT
//            setAllContainerColors(requireContext().themeColor(R.attr.colorSurface))
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlank3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.run {
            enterTransition = MaterialContainerTransform().apply {
                // Manually add the Views to be shared since this is not a standard Fragment to
                // Fragment shared element transition.
                startView = requireActivity().findViewById(R.id.floatingActionButton)
                endView = fm
                duration = 500

                setPathMotion(MaterialArcMotion())

                scrimColor = Color.TRANSPARENT
                containerColor = requireContext().themeColor(R.attr.colorSurface)
                startContainerColor = requireContext().themeColor(R.attr.colorSecondary)
                endContainerColor = requireContext().themeColor(R.attr.colorSurface)
//                setAllContainerColors(requireContext().themeColor(R.attr.colorSurface))
                Log.d("TAG", "onViewCreated: enterTransition")
            }
            returnTransition = Slide().apply {
                duration = 500
                addTarget(R.id.fm)
                Log.d("TAG", "onViewCreated: returnTransition")
            }
        }
    }

    override fun getReturnTransition(): Any? {
        Log.d("TAG", "getReturnTransition: ")
        return super.getReturnTransition()
    }

    @ColorInt
    @SuppressLint("Recycle")
    fun Context.themeColor(
        @AttrRes themeAttrId: Int
    ): Int {
        return obtainStyledAttributes(
            intArrayOf(themeAttrId)
        ).use {
            it.getColor(0, Color.MAGENTA)
        }
    }

}