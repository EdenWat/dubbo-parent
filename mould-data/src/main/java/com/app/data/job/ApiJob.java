package com.app.data.job;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @DisallowConcurrentExecution 添加到 Job 类后，Quartz 将不会同时执行多个 Job 实例
 * @PersistJobDataAfterExecution 添加到 Job 类后，
 * 表示 Quartz 将会在成功执行 execute() 方法后（没有抛出异常）更新 JobDetail 的 JobDataMap，
 * 下一次执行相同的任务（JobDetail）将会得到更新后的值，而不是原始的值
 */
@Log4j2
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class ApiJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobKey jobKey = context.getJobDetail().getKey();
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String dateStr = dataMap.getString("date");

        if (log.isInfoEnabled())
            log.info("执行 {} 定时任务前的 date 参数值：{}", jobKey, dateStr);

        DateTime dateTime = StringUtils.isNotBlank(dateStr) ? DateTime.parse(dateStr) : DateTime.now();
        dateTime = dateTime.plusDays(1);
        dateStr = dateTime.toString("yyyy-MM-dd");
        dataMap.put("date", dateStr);

        if (log.isInfoEnabled())
            log.info("执行 {} 定时任务后的 date 参数值：{}", jobKey, dateStr);
    }
}