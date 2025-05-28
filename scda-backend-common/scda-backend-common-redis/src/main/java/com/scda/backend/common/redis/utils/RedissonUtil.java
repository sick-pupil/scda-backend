package com.scda.backend.common.redis.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RList;
import org.redisson.api.RMap;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class RedissonUtil {

    @Autowired
    private RedissonClient redissonClient;

    public Set<String> keys(String key) {
        return (Set<String>) CollectionUtils.emptyIfNull(redissonClient.getKeys().getKeysStreamByPattern("*" + key + "*").collect(Collectors.toSet()));
    }

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
    public Boolean expire(String key, Long time) {
        if(time.compareTo(0L) >= 0) {
            return redissonClient.getBucket(key).expire(time, TimeUnit.SECONDS);
        } else {
            return Boolean.FALSE;
        }
    }

    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public Long getExpire(String key) {
        return redissonClient.getKeys().remainTimeToLive(key);
    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public Boolean hasKey(String key) {
        return redissonClient.getBucket(key).isExists();
    }

    /**
     * 删除缓存
     *
     * @param keys 可以传一个值 或多个
     */
    public Boolean del(String... keys) {
        return redissonClient.getKeys().delete(keys) == 0L ? Boolean.FALSE : Boolean.TRUE;
    }

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        return StringUtils.isNotBlank(key) ? redissonClient.getBucket(key).get() : null;
    }

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param val 值
     * @return true成功 false失败
     */
    public Boolean set(String key, Object val) {
        if(StringUtils.isNotBlank(key) && ObjectUtils.isNotEmpty(val)) {
            redissonClient.getBucket(key).set(val);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param val 值
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public Boolean set(String key, Object val, Long time) {
        if(time.compareTo(0L) >= 0 && StringUtils.isNotBlank(key) && ObjectUtils.isNotEmpty(val)) {
            redissonClient.getBucket(key).set(val, time, TimeUnit.SECONDS);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    /**
     * 递增
     *
     * @param key   键
     * @param delta 要增加几(大于0)
     * @return
     */
    public Long incr(String key, Long delta) {
        return redissonClient.getAtomicLong(key).addAndGet(delta);
    }

    /**
     * 递减
     *
     * @param key   键
     * @param delta 要减少几(小于0)
     * @return
     */
    public Long decr(String key, Long delta) {
        return redissonClient.getAtomicLong(key).addAndGet(-delta);
    }

    /**
     * HashGet
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    public Object hget(String key, String item) {
        return redissonClient.getMap(key).get(item);
    }

    /**
     * 获取hashKey对应的所有键值
     *
     * @param key 键
     * @return 对应的多个键值
     */
    public Map<Object, Object> hmget(String key) {
        return redissonClient.getMap(key).readAllMap();
    }

    /**
     * HashSet
     *
     * @param key 键
     * @param map 对应多个键值
     */
    public Boolean hmset(String key, Map<String, Object> map) {
        redissonClient.getMap(key).putAll(map);
        return Boolean.TRUE;
    }

    /**
     * HashSet 并设置时间
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 时间(秒)
     */
    public Boolean hmset(String key, Map<String, Object> map, Long time) {
        RMap rMap = redissonClient.getMap(key);
        rMap.putAll(map);
        rMap.expire(time, TimeUnit.SECONDS);
        return Boolean.TRUE;
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     */
    public Boolean hset(String key, String item, Object value) {
        redissonClient.getMap(key).put(item, value);
        return Boolean.TRUE;
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     */
    public Boolean hset(String key, String item, Object value, Long time) {
        RMap rMap = redissonClient.getMap(key);
        rMap.put(item, value);
        rMap.expire(time, TimeUnit.SECONDS);
        return Boolean.TRUE;
    }

    /**
     * 删除hash表中的值
     *
     * @param key  键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    public Boolean hdel(String key, Object... item) {
        redissonClient.getMap(key).fastRemove(item);
        return Boolean.TRUE;
    }

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    public Boolean hHasKey(String key, String item) {
        return redissonClient.getMap(key).containsKey(item);
    }

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return
     */
    public Double hincr(String key, String item, Double by) {
        return (Double) redissonClient.getMap(key).addAndGet(item, by);
    }

    /**
     * hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return
     */
    public Double hdecr(String key, String item, Double by) {
        return (Double) redissonClient.getMap(key).addAndGet(item, -by);
    }

    /**
     * 根据key获取Set中的所有值
     *
     * @param key 键
     * @return
     */
    public Set<Object> sGet(String key) {
        return redissonClient.getSet(key).readAll();
    }

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    public Boolean sHasKey(String key, Object value) {
        return redissonClient.getSet(key).contains(value);
    }

    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return true 存在 false不存在
     */
    public Boolean sSet(String key, Set values) {
        return redissonClient.getSet(key).addAll(values);
    }

    /**
     * 将set数据放入缓存
     *
     * @param key    键
     * @param time   时间(秒)
     * @param values 值 可以是多个
     * @return true 存在 false不存在
     */
    public Boolean sSetAndTime(String key, Long time, Set values) {
        RSet rSet = redissonClient.getSet(key);
        rSet.addAll(values);
        rSet.expire(time, TimeUnit.SECONDS);
        return Boolean.TRUE;
    }

    /**
     * 获取set缓存的长度
     *
     * @param key 键
     * @return
     */
    public Integer sGetSetSize(String key) {
        return redissonClient.getSet(key).size();
    }

    /**
     * 移除值为value的
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除结果
     */
    public Boolean setRemove(String key, Set values) {
        return redissonClient.getSet(key).removeAll(values);
    }
    // ===============================list=================================

    /**
     * 获取list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束 0 到 -1代表所有值
     * @return
     */
    public List<Object> lGet(String key, Integer start, Integer end) {
        return redissonClient.getList(key).range(start, end);
    }

    /**
     * 获取list缓存的长度
     *
     * @param key 键
     * @return
     */
    public Integer lGetListSize(String key) {
        return redissonClient.getList(key).size();
    }

    /**
     * 通过索引 获取list中的值
     *
     * @param key   键
     * @param index 索引 index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public Object lGetIndex(String key, Integer index) {
        return redissonClient.getList(key).get(index);
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public Boolean lSet(String key, Object value) {
        return redissonClient.getList(key).add(value);
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public Boolean lSet(String key, Object value, Long time) {
        RList rList = redissonClient.getList(key);
        rList.add(value);
        rList.expire(time, TimeUnit.SECONDS);
        return Boolean.TRUE;
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public Boolean lSet(String key, List value) {
        return redissonClient.getList(key).addAll(value);
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public Boolean lSet(String key, List value, Long time) {
        RList rList = redissonClient.getList(key);
        rList.addAll(value);
        rList.expire(time, TimeUnit.SECONDS);
        return Boolean.TRUE;
    }

    /**
     * 根据索引修改list中的某条数据
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return
     */
    public Boolean lUpdateIndex(String key, Integer index, Object value) {
        redissonClient.getList(key).set(index, value);
        return Boolean.TRUE;
    }
}
