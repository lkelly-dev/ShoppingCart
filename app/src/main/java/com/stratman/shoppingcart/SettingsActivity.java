package com.stratman.shoppingcart;


    import android.content.SharedPreferences;
    import android.os.Bundle;
    import android.preference.PreferenceActivity;
    import android.preference.PreferenceManager;
    import android.widget.TextView;

    public class SettingsActivity extends PreferenceActivity {

        @Override
        @SuppressWarnings( "deprecation" )
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            addPreferencesFromResource(R.xml.settings);




        }
    }

