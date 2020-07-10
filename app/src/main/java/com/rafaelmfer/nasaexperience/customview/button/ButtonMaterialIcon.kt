package com.rafaelmfer.nasaexperience.customview.button

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.setPadding
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.extensions.dp

class ButtonMaterialIcon @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatButton(context, attrs, defStyleAttr) {

    private var attributesTypedArray: TypedArray

    init {
        typeface = ResourcesCompat.getFont(getContext(), R.font.material_design_icon_font_24px)
        textSize = DEFAULT_TEXT_SIZE
        textAlignment = View.TEXT_ALIGNMENT_CENTER
        gravity = Gravity.CENTER
        setPadding(12.dp)
        attributesTypedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.ButtonMaterialIcon, 0, 0)
        background =
            attributesTypedArray.getDrawable(R.styleable.ButtonMaterialIcon_android_background)
    }

    companion object {
        private const val DEFAULT_TEXT_SIZE = 24f
    }
}