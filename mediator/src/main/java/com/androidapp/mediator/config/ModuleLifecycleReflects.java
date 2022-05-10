package com.androidapp.mediator.config;

class ModuleLifecycleReflects {

    private static final String BaseInit = "com.androidapp.mediator.base.BaseModuleInit";
    private static final String MainInit = "com.androidapp.module.home.MainModule";
    private static final String HomeInit = "com.androidapp.module.home.HomeModule";
    private static final String MineInit = "com.androidapp.module.home.MineModule";

    public static String[] initModuleNames = {BaseInit, MainInit, HomeInit, MineInit};
}
