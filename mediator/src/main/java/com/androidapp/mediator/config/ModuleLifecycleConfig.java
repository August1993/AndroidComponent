package com.androidapp.mediator.config;

import android.app.Application;

import com.androidapp.mediator.base.IModuleInit;

import androidx.annotation.Nullable;
public class ModuleLifecycleConfig {

    //内部类，在装载该内部类时才会去创建单例对象
    private static class SingletonHolder {
        public static ModuleLifecycleConfig instance = new ModuleLifecycleConfig();
    }

    public static ModuleLifecycleConfig getInstance() {
        return SingletonHolder.instance;
    }

    private ModuleLifecycleConfig() {}

    //初始化组件-靠前
    public void initModuleAhead(@Nullable Application application) {
        for (String moduleInitName : ModuleLifecycleReflects.initModuleNames) {
            try {
                Class<?> clazz = Class.forName(moduleInitName);
                IModuleInit init = (IModuleInit) clazz.newInstance();
                //调用初始化方法
                init.onInitAhead(application);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    //初始化组件-靠后
    public void initModuleLow(@Nullable Application application) {
        for (String moduleInitName : ModuleLifecycleReflects.initModuleNames) {
            try {
                Class<?> clazz = Class.forName(moduleInitName);
                IModuleInit init = (IModuleInit) clazz.newInstance();
                //调用初始化方法
                init.onInitLow(application);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
