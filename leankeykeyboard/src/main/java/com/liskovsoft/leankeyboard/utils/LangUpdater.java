package com.liskovsoft.leankeyboard.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import com.liskovsoft.leankeyboard.utils.helpers.Helpers;
import com.liskovsoft.leankeyboard.utils.helpers.LocaleUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class LangUpdater {
    private static final String LOCALE_EN_US = "en_US";
    private static final String LOCALE_RU = "ru_RU";
    private Context mContext;
    private String[] rusPackages = {"dkc.androidtv.tree", "dkc.video.fsbox", "dkc.video.hdbox", "dkc.video.uatv"};

    public LangUpdater(Context ctx) {
        mContext = ctx;
    }

    public void update() {
        tryToEnableRussian();
        tryToForceEnglishOnDevices();
        tryToRestoreLanguage();
    }

    private void tryToRestoreLanguage() {
        String langCode = getPreferredLocale();
        if (langCode != null) {
            forceLocale(langCode);
        }
    }

    private void tryToForceEnglishOnDevices() {
        String deviceName = Helpers.getDeviceName();
        switch (deviceName) {
            case "ChangHong Android TV (full_mst638)":
                forceLocale(LOCALE_EN_US);
        }
    }

    private void tryToBypassChinese() {
        String script = LocaleUtility.getScript(Locale.getDefault());
        if (isChineseScript(script)) {
            forceLocale(LOCALE_EN_US);
        }
    }

    private boolean isChineseScript(String script) {
        switch (script) {
            case "Hani":
            case "Hans":
            case "Hant":
                return true;
        }
        return false;
    }

    private void tryToEnableRussian() {
        List<String> installedPackages = getListInstalledPackages();
        for (String pkgName : installedPackages) {
            if (isRussianPackage(pkgName)) {
                forceLocale(LOCALE_RU);
            }
        }
    }

    // short lang code. ex: "ru"
    private void forceLocale(String langCode) {
        if (langCode == null || langCode.isEmpty()) {
            return;
        }

        Locale locale = parseLangCode(langCode);
        LocaleUtility.forceLocaleOld(mContext, locale);
    }

    private boolean isRussianPackage(String pkgName) {
        for (String rusPackage : rusPackages) {
            if (rusPackage.equals(pkgName)){
                return true;
            }
        }
        return false;
    }

    private List<String> getListInstalledPackages() {
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> pkgAppsList = mContext.getPackageManager().queryIntentActivities( mainIntent, 0);
        List<String> result = new ArrayList<>();
        for (ResolveInfo info : pkgAppsList) {
            result.add(info.activityInfo.packageName);
        }
        return result;
    }

    public String getLocale() {
        Configuration config = mContext.getResources().getConfiguration();
        return LocaleUtility.getSystemLocale(config).getLanguage();
    }

    /**
     * Get locale as lang code (e.g. zh, ru_RU etc)
     * @return lang code
     */
    public String getPreferredLocale() {
        return LeanKeySettings.instance(mContext).getPreferredLanguage();
    }

    public void setPreferredLocale(String langCode) {
        LeanKeySettings.instance(mContext).setPreferredLanguage(langCode);
    }

    private Locale parseLangCode(String langCode) {
        StringTokenizer tokenizer = new StringTokenizer(langCode, "_");
        String lang = tokenizer.nextToken();
        String country = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "";
        return new Locale(lang, country);
    }
}
