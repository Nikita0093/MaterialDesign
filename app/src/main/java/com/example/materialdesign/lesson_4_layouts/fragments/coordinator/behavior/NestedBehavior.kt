package com.example.materialdesign.lesson_4_layouts.fragments.coordinator.behavior

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout

class NestedBehavior(context: Context, attributeSet: AttributeSet?): CoordinatorLayout.Behavior<View>(context,attributeSet) {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return (dependency is AppBarLayout)
    }


    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {

        if (dependency is AppBarLayout){
            val bar = dependency as AppBarLayout
            child.y = 0 + bar.height.toFloat() + bar.y

        }
        return super.onDependentViewChanged(parent, child, dependency)
    }
}