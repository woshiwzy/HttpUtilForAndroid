package com.hss01248.net.config;

import android.text.TextUtils;

import com.hss01248.net.cache.CacheStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/9 0009.
 */

public class GlobalConfig {
    private static GlobalConfig instance;


    private GlobalConfig(){

    }

    /**
     * 仅在
     * @return
     */
    public static GlobalConfig get(){
        if(instance == null){
            instance = new GlobalConfig();
        }
        return instance;
    }

    //private  long PROGRESS_INTERMEDIATE = 300;//进度条更新间隔,默认300ms




    @CacheStrategy.Mode
    private   int cacheMode = CacheStrategy.DEFAULT;//严格遵循http协议
    /**
     * 设置缓存策略 {@link CacheStrategy}
     */
    public GlobalConfig setCacheMode(@CacheStrategy.Mode int cacheMode){
        this.cacheMode = cacheMode;
        return this;
    }
    public int getCacheMode(){
        return cacheMode;
    }



    public static final int COOKIE_NONE = 1;
    public static final int COOKIE_MEMORY = 2;
    public static final int COOKIE_DISK = 3;
    private int cookieMode = COOKIE_MEMORY;//会话cookie,不做持久化操作
    /**
     * 设置cookie管理策略
     */
    public GlobalConfig setCookieMode(int cookieMode){
        this.cookieMode = cookieMode;
        return this;
    }
    public int getCookieMode(){
        return cookieMode;
    }

    /**
     * url前缀设置,格式类似
     */
    public GlobalConfig setBaseUrl(String url){
        this.baseUrl = url;
        return this;
    }
    private String baseUrl = "http://www.qxinli.com/";
    public String getBaseUrl(){
        return baseUrl;
    }

    private String key_data = "data";
    private String key_code = "code";
    private String key_msg = "msg";

    /**
     * 设置三字段json的key,默认如上
     */
    public GlobalConfig setStandardJsonKeys(String key_data, String key_code, String key_msg){
        this.key_data = key_data;
        this.key_code = key_code;
        this.key_msg = key_msg;

        return this;
    }
    public String getStandardJsonKeyCode() {
        return key_code;
    }
    public String getStandardJsonKeyData() {
        return key_data;
    }
    public String getStandardJsonKeyMsg() {
        return key_msg;
    }

    /**
     * 设置标准json的最常见的三个code
     */
    private int codeSuccess = 0;
    private int codeUnlogin = 1;
    private int codeUnfound = 2;
    public int getCodeUnfound() {
        return codeUnfound;
    }

    public int getCodeSuccess() {
        return codeSuccess;
    }


    public int getCodeUnlogin() {
        return codeUnlogin;
    }

    public void setStandardJsonCodes(int codeSuccess,int codeUnlogin,int codeUnfound) {
        this.codeUnlogin = codeUnlogin;
        this.codeSuccess = codeSuccess;
        this.codeUnfound = codeUnfound;
    }




    private String userAgent = System.getProperty("http.agent");

    /**
     * 设置useragent,可能需要欺骗服务器什么的
     * @param userAgent
     * @return
     */
    public GlobalConfig setUserAgent(String userAgent){
        this.userAgent = userAgent;
        return this;
    }

    public String getUserAgent(){
        return userAgent;
    }

    private  int connectTimeout = 15000;//单位为ms,默认15s



    private  int readTimeout = 15000;//单位为ms,默认15s
    private  int writeTimeout = 15000;//单位为ms,默认15s

    /**
     * 设置超时时间
     * @param connectTimeout
     * @return
     */
    public GlobalConfig setConnectTimeout(int connectTimeout){
        this.connectTimeout = connectTimeout;
        return this;
    }
    public GlobalConfig setReadTimeout(int readTimeout){
        this.readTimeout = readTimeout;
        return this;
    }
    public GlobalConfig setWriteTimeout(int writeTimeout){
        this.writeTimeout = writeTimeout;
        return this;
    }
    public int getConnectTimeout(){
        return connectTimeout;
    }
    public int getReadTimeout() {
        return readTimeout;
    }

    public int getWriteTimeout() {
        return writeTimeout;
    }

    private  int retryCount =0;

    /**
     * 设置重试次数,默认为0
     */ public int getRetryCount() {
        return retryCount;
    }

    public GlobalConfig setRetryCount(int retryCount) {
        this.retryCount = retryCount;
        return this;
    }

    /**
     * https相关设置
     */
    private boolean ignoreCertificateVerify = false;//是否忽略证书校验,也就是信任所有证书,默认关闭,因为会导致安全问题


    //预埋证书
    private List<String> certificateFiles = new ArrayList<>();

    public List<String> getCertificateAsserts() {
        return certificateAsserts;
    }

    @Deprecated
    public List<String> getCertificateFiles() {
        return certificateFiles;
    }

    public boolean isIgnoreCertificateVerify() {
        return ignoreCertificateVerify;
    }

    private List<String> certificateAsserts= new ArrayList<>();

    @Deprecated  //只给java使用,android使用assert内置
    public  GlobalConfig addCrtificateFile(String filePath){
        if(certificateFiles==null){
            certificateFiles=new ArrayList<String>();
        }
        certificateFiles.add(filePath);
        return this;
    }
    public  GlobalConfig addCrtificateAssert(String fileName){
        if(certificateAsserts==null){
            certificateAsserts=new ArrayList<String>();
        }
        certificateFiles.add(fileName);
        return this;
    }



    /**
     * log相关设置
     */
    private boolean isOpenLog = false;

    public String getLogTag() {
        return logTag;
    }

    private String logTag = "okhttp";

    public boolean isOpenLog() {
        return isOpenLog;
    }

    public GlobalConfig openLog(String logTag) {
        isOpenLog = true;
        if(!TextUtils.isEmpty(logTag)){
            this.logTag = logTag;
        }
        return this;
    }





























}
