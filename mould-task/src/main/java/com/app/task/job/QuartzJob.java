package com.app.task.job;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import org.quartz.*;

/**
 * @DisallowConcurrentExecution 添加到 Job 类后，Quartz 将不会同时执行多个 Job 实例
 * @PersistJobDataAfterExecution 添加到 Job 类后，
 * 表示 Quartz 将会在成功执行 execute() 方法后（没有抛出异常）更新 JobDetail 的 JobDataMap，
 * 下一次执行相同的任务（JobDetail）将会得到更新后的值，而不是原始的值
 */
@Log4j2
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class QuartzJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey jobKey = context.getJobDetail().getKey();
        JobDataMap map = context.getJobDetail().getJobDataMap();

        if (log.isInfoEnabled())
            log.info("开始执行 {} 定时任务，参数值：{}", jobKey, JSON.toJSONString(map));

        int count = map.getInt("count");
        count++;
        map.put("count", count);
    }
}