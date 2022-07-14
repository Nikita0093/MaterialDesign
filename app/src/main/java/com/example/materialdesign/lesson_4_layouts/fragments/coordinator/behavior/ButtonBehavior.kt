package com.example.materialdesign.lesson_4_layouts.fragments.coordinator.behavior

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import kotlin.math.abs
import kotlin.math.max

class ButtonBehavior(context: Context, attributeSet: AttributeSet?) :
    CoordinatorLayout.Behavior<View>(context, attributeSet) {

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

        if (dependency is AppBarLayout) {
            val bar = dependency as AppBarLayout
            child.alpha = max(1 - abs(2 * bar.y) / bar.height.toFloat(), 0f)
            child.x =
                (bar.width.toFloat() - child.width) * (1 - abs(2 * bar.y) / bar.height.toFloat())

        }
        return super.onDependentViewChanged(parent, child, dependency)
    }
}