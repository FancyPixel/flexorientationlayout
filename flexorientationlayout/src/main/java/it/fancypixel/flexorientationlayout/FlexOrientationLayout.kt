package it.fancypixel.flexorientationlayout

import android.content.Context
import android.content.res.Configuration
import android.util.AttributeSet
import android.widget.LinearLayout


class FlexOrientationLayout : LinearLayout {

    private var useReversedOrientation: Boolean = false

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        handleCustomAttributes(attrs)
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        handleCustomAttributes(attrs)
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        handleCustomAttributes(attrs)
        init()
    }

    public fun useReversedOrientation(useReversedOrientation: Boolean) {
        this.useReversedOrientation = useReversedOrientation
    }

    private fun handleCustomAttributes(attrs: AttributeSet?) {
        attrs?.let {
            val a = context.obtainStyledAttributes(attrs, R.styleable.FlexOrientationLayout)
            useReversedOrientation = a.getBoolean(R.styleable.FlexOrientationLayout_reversed_orientation, false)
            a.recycle()
        }
    }

    private fun init() {
        // Handle orientation
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (!useReversedOrientation) {
                setOrientation(LinearLayout.HORIZONTAL)
            } else {
                setOrientation(LinearLayout.VERTICAL)
            }
        } else {
            if (!useReversedOrientation) {
                setOrientation(LinearLayout.VERTICAL)
            } else {
                setOrientation(LinearLayout.HORIZONTAL)
            }
        }
    }
}
