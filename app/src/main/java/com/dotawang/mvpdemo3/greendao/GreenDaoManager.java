package com.dotawang.mvpdemo3.greendao;


import com.dotawang.mvpdemo3.BaseApplication;
import com.dotawang.mvpdemo3.MyApplication;
import com.dotawang.mvpdemo3.greendao.generator.DaoMaster;
import com.dotawang.mvpdemo3.greendao.generator.DaoSession;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public class GreenDaoManager {

    private DaoMaster.DevOpenHelper devOpenHelper;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    private static final String DB_NAME = "testCyg.db";

    private GreenDaoManager() {
        if (devOpenHelper == null || daoMaster == null || daoSession == null) {
            devOpenHelper = new DaoMaster.DevOpenHelper(BaseApplication.getInstance(), DB_NAME, null);
            daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
            daoSession = daoMaster.newSession();
        }
    }

    private static class Singleton {
        private static GreenDaoManager mInstance = new GreenDaoManager();
    }

    public static GreenDaoManager getInstance() {
        return Singleton.mInstance;
    }

    public DaoMaster.DevOpenHelper getDevOpenHelper() {
        return devOpenHelper;
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
