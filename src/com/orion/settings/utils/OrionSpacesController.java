/*
 * Copyright (C) 2024 ArrowOS-T
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.orion.settings.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.preference.PreferenceScreen;
import com.android.settings.R;
import com.android.settingslib.core.AbstractPreferenceController;
import com.android.settingslib.widget.LayoutPreference;

import java.util.HashMap;
import java.util.Map;

public class OrionSpacesController extends AbstractPreferenceController {

    private static final String KEY_MENU_TOP = "orionspaces_menu_top";
    private static final String KEY_MENU_BOTTOM = "orionspaces_menu_bottom";

    public OrionSpacesController(Context context) {
        super(context);
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);

        LayoutPreference orionSpacesMenuTop = (LayoutPreference) screen.findPreference(KEY_MENU_TOP);
        if (orionSpacesMenuTop != null) {
            Map<Integer, Intent> clickMap = new HashMap<>();
            clickMap.put(R.id.orionspaces_quicksettings, new Intent().setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$crDroidQuickSettingsActivity")));
            clickMap.put(R.id.orionspaces_about, new Intent().setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$crDroidAboutActivity")));
            clickMap.put(R.id.orionspaces_userinterface, new Intent().setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$crDroidUserInterfaceActivity")));

            for (Map.Entry<Integer, Intent> entry : clickMap.entrySet()) {
                View view = orionSpacesMenuTop.findViewById(entry.getKey());
                if (view != null) {
                    view.setOnClickListener(v -> mContext.startActivity(entry.getValue()));
                }
            }    
        }

        LayoutPreference orionSpacesMenuBottom = (LayoutPreference) screen.findPreference(KEY_MENU_BOTTOM);
        if (orionSpacesMenuBottom != null) {
            Map<Integer, Intent> clickMap = new HashMap<>();
            clickMap.put(R.id.orionspaces_statusbar, new Intent().setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$crDroidStatusBarActivity")));
            clickMap.put(R.id.orionspaces_lockscreen, new Intent().setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$crDroidLockScreenActivity")));
            clickMap.put(R.id.orionspaces_buttons, new Intent().setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$crDroidButtonsActivity")));
            clickMap.put(R.id.orionspaces_navigation, new Intent().setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$crDroidNavigationActivity")));
            clickMap.put(R.id.orionspaces_notifications, new Intent().setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$crDroidNotificationsActivity")));
            clickMap.put(R.id.orionspaces_sound, new Intent().setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$crDroidSoundActivity")));
            clickMap.put(R.id.orionspaces_misc, new Intent().setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$crDroidMiscActivity")));

            for (Map.Entry<Integer, Intent> entry : clickMap.entrySet()) {
                View view = orionSpacesMenuBottom.findViewById(entry.getKey());
                if (view != null) {
                    view.setOnClickListener(v -> mContext.startActivity(entry.getValue()));
                }
            }    
        }
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public String getPreferenceKey() {
        return KEY_MENU_TOP;
    }
}