package com.app.server;

import com.app.core.BaseTestCase;
import com.app.core.util.RedisUtil;
import org.junit.Test;

public class TestRedis extends BaseTestCase {
    @Test
    public void test() throws Exception {
        System.out.println("===============");
        RedisUtil.valueSet("testkey666666", "testval1");

        RedisUtil.setAdd("keydddd", "111", "222");

        RedisUtil.hashPut("hashkey", "subhashkey", "hashvalue");

        RedisUtil.listLeftPush("listkey11", "listval11");

        RedisUtil.zSetAdd("zsetkey", "zsetval", 1.9);

//        RedisUtil.delete("hashkey");

        RedisUtil.listSet("listkey", 0L, "000000");
        RedisUtil.listSet("listkey", 1L, "111111");
        RedisUtil.listSet("listkey", 2L, "222222");

//        System.out.println(RedisUtil.valueGet("testkey1"));
        System.out.println("===============");
    }
}