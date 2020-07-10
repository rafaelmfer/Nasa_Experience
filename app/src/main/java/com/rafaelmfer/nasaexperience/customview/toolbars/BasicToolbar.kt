package com.rafaelmfer.nasaexperience.customview.toolbars

import android.app.Activity
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.accessibility.AccessibilityEvent
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.rafaelmfer.nasaexperience.R

class BasicToolbar @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val btBackButton by lazy { findViewById<Button>(R.id.navigation_left_button) }
    private val tvToolbarTitle by lazy { findViewById<TextView>(R.id.toolbar_title) }
    private val btCloseButton by lazy { findViewById<Button>(R.id.navigation_right_button) }

    private var showBackButton: Boolean
    private var showTitle: Boolean = true
    private var showCloseButton: Boolean

    private var attributesTypedArray: TypedArray

    var titleToolbar: String? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.view_toolbar_basic, this, true)
        attributesTypedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.BasicToolbar, 0, 0).apply {
            tvToolbarTitle.apply {
                text = getString(R.styleable.BasicToolbar_toolbarText) ?: ""
                setTextColor(getColor(R.styleable.BasicToolbar_toolbarTextColor, ContextCompat.getColor(context, R.color.black)))
            }
            btBackButton.setTextColor(getColor(R.styleable.BasicToolbar_buttonLeftTextColor, ContextCompat.getColor(context, R.color.black)))
            btCloseButton.setTextColor(getColor(R.styleable.BasicToolbar_buttonRightTextColor, ContextCompat.getColor(context, R.color.black)))

            showBackButton = getBoolean(R.styleable.BasicToolbar_showBackButton, true)
            showTitle = getBoolean(R.styleable.BasicToolbar_showTitle, true)
            showCloseButton = getBoolean(R.styleable.BasicToolbar_showCloseButton, false)

            initView()

            recycle()
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        btBackButton.setToolbarAccessibleBackButton()
    }

    private fun initView() {
        if (context is Activity) {
            btBackButton.run { setOnClickListener { (context as Activity).onBackPressed() } }
        }
        btBackButton.visibility = if (showBackButton) View.VISIBLE else View.GONE
        tvToolbarTitle.visibility = if (showTitle) View.VISIBLE else View.GONE
        btCloseButton.visibility = if (showCloseButton) View.VISIBLE else View.GONE
    }

    fun setCloseButtonAction(action: () -> Unit) {
        btCloseButton.setOnClickListener { action() }
    }

    fun setButtonLeftAction(action: () -> Unit) {
        btBackButton.setOnClickListener { action() }
    }

    fun updateTitleToolbar() {
        tvToolbarTitle.run {
            text = titleToolbar
            contentDescription = resources.getString(R.string.acs_toolbar_title, titleToolbar)
        }
    }

    fun setFocusOnBackButton() {
        btBackButton.requestFocus()
        btBackButton.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED)
    }

    fun setBackButtonText(text: String) {
        btBackButton.text = text
    }

    fun setBackButtonColor(color: Int) {
        btBackButton.setTextColor(color)
    }

    fun setCloseButtonText(text: String) {
        btCloseButton.text = text
    }

    fun setCloseButtonColor(color: Int) {
        btCloseButton.setTextColor(color)
    }
}

fun View.setToolbarAccessibleBackButton() {
    setOnTouchListener { view, event ->
        when (event.action) {
            MotionEvent.ACTION_UP -> {
                view.performClick()
                true
            }
            else -> false
        }
    }
}
