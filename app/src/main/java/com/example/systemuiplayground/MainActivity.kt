package com.example.systemuiplayground

import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Switch
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import kotlinx.android.synthetic.main.activity_main.*

/*
 * View
 * https://developer.android.com/reference/android/view/View
 *
 * SYSTEM_UI_FLAG_VISIBLE                   0 (0x00000000) API 14+
 * SYSTEM_UI_FLAG_LOW_PROFILE               1 (0x00000001) API 14+
 * SYSTEM_UI_FLAG_HIDE_NAVIGATION           2 (0x00000002) API 14+
 * SYSTEM_UI_FLAG_FULLSCREEN                4 (0x00000004) API 16+
 * SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR     16 (0x00000010) API 26+
 * SYSTEM_UI_FLAG_LAYOUT_STABLE           256 (0x00000100) API 16+
 * SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION  512 (0x00000200) API 16+
 * SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN      1024 (0x00000400) API 16+
 * SYSTEM_UI_LAYOUT_FLAGS                1536 (0x00000600) API 16+
 * SYSTEM_UI_FLAG_IMMERSIVE              2048 (0x00000800) API 19+
 * SYSTEM_UI_FLAG_IMMERSIVE_STICKY       4096 (0x00001000) API 19+
 * SYSTEM_UI_FLAG_LIGHT_STATUS_BAR       8192 (0x00002000) API 23+
 */

/*
 * WindowManager.LayoutParams
 * https://developer.android.com/reference/android/view/WindowManager.LayoutParams
 *
 * FLAG_ALLOW_LOCK_WHILE_SCREEN_ON             1 (0x00000001) API  8+
 * FLAG_DIM_BEHIND                             2 (0x00000002) API  1+
 * FLAG_BLUR_BEHIND                            4 (0x00000004) API  1+ (deprecated in API 14)
 * FLAG_NOT_FOCUSABLE                          8 (0x00000008) API  1+
 * FLAG_NOT_TOUCHABLE                         16 (0x00000010) API  1+
 * FLAG_NOT_TOUCH_MODAL                       32 (0x00000020) API  1+
 * FLAG_TOUCHABLE_WHEN_WAKING                 64 (0x00000040) API  1+ (deprecated in API 20)
 * FLAG_KEEP_SCREEN_ON                       128 (0x00000080) API  1+
 * FLAG_LAYOUT_IN_SCREEN                     256 (0x00000100) API  1+
 * FLAG_LAYOUT_NO_LIMITS                     512 (0x00000200) API  1+
 * FLAG_FULLSCREEN                          1024 (0x00000400) API  1+
 * FLAG_FORCE_NOT_FULLSCREEN                2048 (0x00000800) API  1+
 * FLAG_DITHER                              4096 (0x00001000) API  1+ (deprecated in API 17)
 * FLAG_SECURE                              8192 (0x00002000) API  1+
 * FLAG_SCALED                             16384 (0x00004000) API  1+
 * FLAG_IGNORE_CHEEK_PRESSES               32768 (0x00008000) API  1+
 * FLAG_LAYOUT_INSET_DECOR                 65536 (0x00010000) API  1+
 * FLAG_ALT_FOCUSABLE_IM                  131072 (0x00020000) API  3+
 * FLAG_WATCH_OUTSIDE_TOUCH               262144 (0x00040000) API  3+
 * FLAG_SHOW_WHEN_LOCKED                  524288 (0x00080000) API  5+ (deprecated in API 27)
 * FLAG_SHOW_WALLPAPER                   1048576 (0x00100000) API  5+
 * FLAG_TURN_SCREEN_ON                   2097152 (0x00200000) API  5+ (deprecated in API 27)
 * FLAG_DISMISS_KEYGUARD                 4194304 (0x00400000) API  5+ (deprecated in API 26)
 * FLAG_SPLIT_TOUCH                      8388608 (0x00800000) API 11+
 * FLAG_HARDWARE_ACCELERATED            16777216 (0x01000000) API 11+
 * FLAG_LAYOUT_IN_OVERSCAN              33554432 (0x02000000) API 18+
 * FLAG_TRANSLUCENT_STATUS              67108864 (0x04000000) API 19+
 * FLAG_TRANSLUCENT_NAVIGATION         134217728 (0x08000000) API 19+
 * FLAG_LOCAL_FOCUS_MODE               268435456 (0x10000000) API  1+
 * FLAG_LAYOUT_ATTACHED_IN_DECOR      1073741824 (0x40000000) API 22+
 * FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS -2147483648 (0x80000000) API 21+
 */

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"

        val COLORS: Array<Pair<String, Int>> = arrayOf(
            "TRANSPARENT" to Color.TRANSPARENT,
            "BLACK" to Color.BLACK,
            "WHITE" to Color.WHITE,
            "BLUE" to Color.BLUE
        )

        val SYSTEM_UI_FLAGS: Array<Pair<String, Int>> = arrayOf(
            "16|SYSTEM_UI_FLAG_FULLSCREEN" to View.SYSTEM_UI_FLAG_FULLSCREEN,
            "16|SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN" to View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN,
            "16|SYSTEM_UI_FLAG_LAYOUT_STABLE" to View.SYSTEM_UI_FLAG_LAYOUT_STABLE,
            "14|SYSTEM_UI_FLAG_HIDE_NAVIGATION" to View.SYSTEM_UI_FLAG_HIDE_NAVIGATION,
            "16|SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION" to View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        )

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        val SYSTEM_UI_FLAGS_API_19: Array<Pair<String, Int>> = arrayOf(
//            "19|SYSTEM_UI_FLAG_IMMERSIVE" to View.SYSTEM_UI_FLAG_IMMERSIVE,
//            "19|SYSTEM_UI_FLAG_IMMERSIVE_STICKY" to View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        )

        @RequiresApi(Build.VERSION_CODES.M)
        val SYSTEM_UI_FLAGS_API_23: Array<Pair<String, Int>> = arrayOf(
            "23|SYSTEM_UI_FLAG_LIGHT_STATUS_BAR" to View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        )

        @RequiresApi(Build.VERSION_CODES.O)
        val SYSTEM_UI_FLAGS_API_26: Array<Pair<String, Int>> = arrayOf(
            "26|SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR" to View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        )

        val WINDOW_MANAGER_FLAGS: Array<Pair<String, Int>> = arrayOf(
//            " 1|FLAG_LAYOUT_IN_SCREEN" to WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            " 1|FLAG_LAYOUT_NO_LIMITS" to WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            " 1|FLAG_FULLSCREEN" to WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        val WINDOW_MANAGER_FLAGS_API_19: Array<Pair<String, Int>> = arrayOf(
            "19|FLAG_TRANSLUCENT_STATUS" to WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            "19|FLAG_TRANSLUCENT_NAVIGATION" to WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
        )

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        val WINDOW_MANAGER_FLAGS_API_21: Array<Pair<String, Int>> = arrayOf(
            "21|FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS" to WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
        )
    }

    private val systemUiFlagContainer: ViewGroup by lazy { findViewById<ViewGroup>(R.id.system_ui_flag_container) }
    private val windowManagerFlagContainer: ViewGroup by lazy { findViewById<ViewGroup>(R.id.window_manager_flag_container) }

    private var statusBarColorIndex: Int = -1
    private var navigationBarColorIndex: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        sdk_version.text = getString(R.string.sdk_version, Build.VERSION.RELEASE, Build.VERSION.SDK_INT)

        initSystemUiFlagContainer()
        initSystemUiActionButtons()

        initWindowManagerFlagContainer()
        initWindowManagerActionButtons()

        initFitsSystemWindowsButton()
        initRequestLayoutButton()
        initStatusBarColorButton()
        initNavigationBarColorButton()
    }

    override fun onStart() {
        super.onStart()

        window.decorView.setOnSystemUiVisibilityChangeListener {
            updateSystemUiFlagContainer(it)
        }
    }

    override fun onResume() {
        super.onResume()

        updateSystemUiFlagContainer()
        updateWindowManagerFlagContainer()
    }

    override fun onStop() {
        super.onStop()

        window.decorView.setOnSystemUiVisibilityChangeListener(null)
    }

    ////////////////////////////////////////////////////////////
    // System UI
    ////////////////////////////////////////////////////////////
    private fun initSystemUiFlagContainer() {
        SYSTEM_UI_FLAGS.forEach { (text, flag) ->
            addSwitchToViewGroup(text, flag, systemUiFlagContainer)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { // API 19
            SYSTEM_UI_FLAGS_API_19.forEach { (text, flag) ->
                addSwitchToViewGroup(text, flag, systemUiFlagContainer)
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { // API 23
            SYSTEM_UI_FLAGS_API_23.forEach { (text, flag) ->
                addSwitchToViewGroup(text, flag, systemUiFlagContainer)
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // API 26
            SYSTEM_UI_FLAGS_API_26.forEach { (text, flag) ->
                addSwitchToViewGroup(text, flag, systemUiFlagContainer)
            }
        }
    }

    private fun updateSystemUiFlagContainer(visibility: Int = window.decorView.systemUiVisibility) {
        updateFlagContainer(systemUiFlagContainer, visibility)
    }

    private fun initSystemUiActionButtons() {
        system_ui_set.setOnClickListener {
            var visibility = window.decorView.systemUiVisibility

            traverseFlagContainer(systemUiFlagContainer) { switch, flag ->
                visibility = if (switch.isChecked) {
                    visibility or flag
                } else {
                    visibility and flag.inv()
                }
            }

            window.decorView.systemUiVisibility = visibility
            toast("visibility: ${visibility.toHexString()}")
        }

        system_ui_reset.setOnClickListener {
            var visibility = window.decorView.systemUiVisibility

            traverseFlagContainer(systemUiFlagContainer) { switch, flag ->
                switch.isChecked = false
                visibility = visibility and flag.inv()
            }

            window.decorView.systemUiVisibility = visibility
            toast("visibility: ${visibility.toHexString()}")
        }
    }

    ////////////////////////////////////////////////////////////
    // WindowManager
    ////////////////////////////////////////////////////////////
    private fun initWindowManagerFlagContainer() {
        WINDOW_MANAGER_FLAGS.forEach { (text, flag) ->
            addSwitchToViewGroup(text, flag, windowManagerFlagContainer)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { // API 19
            WINDOW_MANAGER_FLAGS_API_19.forEach { (text, flag) ->
                addSwitchToViewGroup(text, flag, windowManagerFlagContainer)
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // API 21
            WINDOW_MANAGER_FLAGS_API_21.forEach { (text, flag) ->
                addSwitchToViewGroup(text, flag, windowManagerFlagContainer)
            }
        }
    }

    private fun updateWindowManagerFlagContainer() {
        updateFlagContainer(windowManagerFlagContainer, window.attributes.flags)
    }

    private fun initWindowManagerActionButtons() {
        window_manager_set.setOnClickListener {
            var flags = 0
            var mask = 0

            traverseFlagContainer(windowManagerFlagContainer) { switch, flag ->
                flags = if (switch.isChecked) {
                    flags or flag
                } else {
                    flags and flag.inv()
                }
                mask = mask or flag
            }

            window.setFlags(flags, mask)
            toast("flags: ${flags.toHexString()}")
        }

        window_manager_reset.setOnClickListener {
            var flags = window.attributes.flags
            var mask = 0

            traverseFlagContainer(windowManagerFlagContainer) { switch, flag ->
                switch.isChecked = false
                flags = flag and flag.inv()
                mask = mask or flag
            }

            window.setFlags(flags, mask)
            toast("flags: ${flags.toHexString()}")
        }
    }

    ////////////////////////////////////////////////////////////
    // Action Button
    ////////////////////////////////////////////////////////////
    private fun initFitsSystemWindowsButton() {
        fits_system_windows.isChecked = toolbar.fitsSystemWindows
        fits_system_windows.setOnCheckedChangeListener { _, isChecked ->
            toolbar.fitsSystemWindowsAndApply(isChecked)
        }
    }

    private fun initRequestLayoutButton() {
        request_layout.setOnClickListener {
            linear_layout.requestLayout()
        }
    }

    private fun initStatusBarColorButton() {
        status_bar_color.setOnClickListener {
            statusBarColorIndex++
            statusBarColorIndex %= COLORS.size

            setStatusBarColor(COLORS[statusBarColorIndex].second)
            toast(COLORS[statusBarColorIndex].first)
        }
    }

    private fun setStatusBarColor(@ColorInt color: Int) {
        runCheckVersion(Build.VERSION_CODES.LOLLIPOP) { // API 21
            window.statusBarColor = color
        }
    }

    private fun initNavigationBarColorButton() {
        navigation_bar_color.setOnClickListener {
            navigationBarColorIndex++
            navigationBarColorIndex %= COLORS.size

            setNavigationBarColor(COLORS[navigationBarColorIndex].second)
            toast(COLORS[navigationBarColorIndex].first)
        }
    }

    private fun setNavigationBarColor(@ColorInt color: Int) {
        runCheckVersion(Build.VERSION_CODES.LOLLIPOP) { // API 21
            window.navigationBarColor = color
        }
    }

    ////////////////////////////////////////////////////////////
    // Utils
    ////////////////////////////////////////////////////////////
    private fun addSwitchToViewGroup(switchText: String, switchTag: Any, viewGroup: ViewGroup) {
        val switch = Switch(this)
        switch.text = switchText
        switch.tag = switchTag
        switch.typeface = Typeface.MONOSPACE
        viewGroup.addView(switch, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    private fun updateFlagContainer(viewGroup: ViewGroup, flags: Int) {
        viewGroup.children
            .filter { it is Switch && it.tag is Int }
            .forEach {
                val switch = it as Switch
                val flag = it.tag as Int
                switch.isChecked = flags and flag == flag
            }
    }

    private fun traverseFlagContainer(viewGroup: ViewGroup, block: (Switch, Int) -> Unit) {
        viewGroup.children
            .filter { it is Switch && it.tag is Int }
            .forEach { block(it as Switch, it.tag as Int) }
    }

    private inline fun <R> runCheckVersion(apiLevel: Int, block: () -> R) {
        if (Build.VERSION.SDK_INT >= apiLevel) {
            block()
        } else {
            toast("Requires API level $apiLevel")
        }
    }
}

