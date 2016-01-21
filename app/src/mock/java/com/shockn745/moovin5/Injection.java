package com.shockn745.moovin5;

import android.content.Context;

import com.shockn745.moovin5.data.AndroidModel;
import com.shockn745.moovin5.data.MockAndroidModelImpl;

/**
 * Injection class to provide mock models
 */
public class Injection {

    public static AndroidModel provideAndroidModel(Context context) {
        return new MockAndroidModelImpl();
    }



}
