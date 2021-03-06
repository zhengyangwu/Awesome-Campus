package cn.edu.jxnu.awesome_campus.support.utils.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import cn.edu.jxnu.awesome_campus.InitApp;

/**
 * Created by MummyDing on 16-4-23.
 * GitHub: https://github.com/MummyDing
 * Blog: http://blog.csdn.net/mummyding
 */
public class SystemUtil {

    private static int versionCode = -1;

    private static String versionName = null;

    /**
     * App 版本号
     * @return
     */
    public static int getVersionCode() {
        if (versionCode != -1) return versionCode;
        return getPackageInfo().versionCode;
    }

    /**
     * 版本名
     * @return
     */
    public static String getVersionName() {
        if (TextUtil.isNull(versionName) == false) return versionName;
        return getPackageInfo().versionName;
    }
    /***
     * App包信息
     * @return
     */
    private static PackageInfo getPackageInfo() {
        PackageInfo pi = null;

        try {
            PackageManager pm = InitApp.AppContext.getPackageManager();
            pi = pm.getPackageInfo(InitApp.AppContext.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);

            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pi;
    }
}
