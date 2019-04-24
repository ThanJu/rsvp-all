package com.highteam.router.common.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yaml.snakeyaml.Yaml;

public class OssConfigUtil {

    private static Log logger = LogFactory.getLog(OssConfigUtil.class);

    private final static String CONFIG_PATH="conf/ossConfig.yml";

    private final static String ENDPONIT="endpoint";
    private final static String ENDPONIT_INTERNAL="endpoint-internal";
    private final static String ACCESSKEYID="accessKeyId";
    private final static String ACCESSKEYSECRET="accessKeySecret";
    private final static String BUCKETNAME="bucketName";
    private final static String ACCESSENDPOINT="accessEndpoint";
    private final static String ROOTPATH="rootPath";
    private final static String SIGN="sign";

    private final static String UPLOADCONFIG="uploadconfig";
    private final static String SERVERNAME="serverName";


    private Map<String, String> map = new HashMap<>();

    private static final OssConfigUtil OSSCONFIG;


    private OssConfigUtil() {}

    static {
        InputStream in = OssConfigUtil.class.getClassLoader().getResourceAsStream(CONFIG_PATH);
        Yaml yaml = new Yaml();
        OSSCONFIG = yaml.loadAs(in, OssConfigUtil.class);
    }

    public static OssConfigUtil getInstance(){
        return OSSCONFIG;
    }

    public String getEndpoint() {
        return map.get(ENDPONIT);
    }

    public String getEndpointInternal() {
        return map.get(ENDPONIT_INTERNAL);
    }

    public String getAccessId() {
        return map.get(ACCESSKEYID);
    }

    public String getAccessKey() {
        return map.get(ACCESSKEYSECRET);
    }

    public String getBucket() {
        return map.get(BUCKETNAME);
    }

    public String getDir() {
        return map.get(ROOTPATH);
    }

    public String getAccessEndpoint() {
        return map.get(ACCESSENDPOINT);
    }

    public String getSign() {
        return map.get(SIGN);
    }

    public void setPublicOssConfig(Map<String, String> publicOssConfig) {
        this.map = publicOssConfig;
    }

}

